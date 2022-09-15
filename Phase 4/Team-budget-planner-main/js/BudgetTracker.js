export default class BudgetTracker {
    constructor(querySelectorString) {
        this.root = document.querySelector(querySelectorString);
        this.root.innerHTML = BudgetTracker.html();

        this.root.querySelector(".new-entry").addEventListener("click", () => {
            this.onNewEntryBtnClick();
        });

        // Load initial data from Local Storage
        this.load();
    }

    static html() {
        return `
            <table class="budget-tracker card">
                <thead class= "card-header row ">
                    <tr>
                        <th class="col-lg-3">Date</th>
                        <th class="col-lg-3">Description</th>
                        <th class="col-lg-3">Type</th>
                        <th class="col-lg-3">Amount</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody class="entries"></tbody>
                <tbody>
                    <tr>
                        <td colspan="5" class="controls">
                            <button type="button" class="new-entry">New Entry</button>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="5" class="summary">
                            <strong>Total:</strong>
                            <span class="total">Rs0.00</span>
                        </td>
                    </tr>
                </tfoot>
            </table>
        `;
    }

    static entryHtml() {
        return `
           
           <tr>
           <td class="col-lg-3">
               <input class="input input-date" type="date">
           </td>
           <td class="col-lg-3">
               <input class="input input-description" type="text" placeholder="Add a Description (e.g. wages, bills, etc.)">
           </td>
           <td class="col-lg-3">
               <select class="input input-type">
                   <option value="income">Income</option>
                   <option value="expense">Expense</option>
               </select>
           </td>
           <td class="col-lg-3">
               <input type="number" class="input input-amount">
           </td>
           <td class="col-lg-3">
               <button type="button" class="delete-entry">&#10005;</button>
           </td>
       </tr>
        `;
    }

    dashBudget(amount){       
        document.querySelector(".dashBudget").textContent=amount;        
    }

    dashExpense(amount){
        document.querySelector(".dashExpense").textContent=amount;
    }

    load() {
        const entries = JSON.parse(
            localStorage.getItem("budget-tracker-entries-dev") || "[]"
        );

        for (const entry of entries) {
            this.addEntry(entry);
        }

        this.updateSummary();
    }

    updateSummary() {
        const total = this.getEntryRows().reduce((total, row) => {
            const amount = row.querySelector(".input-amount").value;
            const isExpense = row.querySelector(".input-type").value === "expense";
            const modifier = isExpense ? -1 : 1;
            
            if(modifier==1){
                this.dashBudget(amount);
            }
            else if(modifier==-1){
                this.dashExpense(amount);
            }
            return total + amount * modifier;
        }, 0);

        const totalFormatted = new Intl.NumberFormat("en-IN", {
            style: "currency",
            currency: "IND",
        }).format(total);

        this.root.querySelector(".total").textContent = totalFormatted;
        document.querySelector(".dashTotal").textContent=totalFormatted;
    }

    save() {
        const data = this.getEntryRows().map((row) => {
            return {
                date: row.querySelector(".input-date").value,
                description: row.querySelector(".input-description").value,
                type: row.querySelector(".input-type").value,
                amount: parseFloat(row.querySelector(".input-amount").value),
            };
        });

        localStorage.setItem("budget-tracker-entries-dev", JSON.stringify(data));
        this.updateSummary();
    }

    addEntry(entry = {}) {
        this.root
            .querySelector(".entries")
            .insertAdjacentHTML("beforeend", BudgetTracker.entryHtml());

        const row = this.root.querySelector(".entries tr:last-of-type");

        row.querySelector(".input-date").value =
            entry.date || new Date().toISOString().replace(/T.*/, "");
        row.querySelector(".input-description").value = entry.description || "";
        row.querySelector(".input-type").value = entry.type || "income";
        row.querySelector(".input-amount").value = entry.amount || 0;
        row.querySelector(".delete-entry").addEventListener("click", (e) => {
            this.onDeleteEntryBtnClick(e);
        });

        row.querySelectorAll(".input").forEach((input) => {
            input.addEventListener("change", () => this.save());
        });
    }

    getEntryRows() {
        return Array.from(this.root.querySelectorAll(".entries tr"));
    }

    onNewEntryBtnClick() {
        this.addEntry();
    }

    onDeleteEntryBtnClick(e) {
        e.target.closest("tr").remove();
        this.save();
    }
}