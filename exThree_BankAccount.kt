/*
* NOTES:
* -> The course suggested using Kotlin Playground instead of IntelliJ IDEA.
* -> As such, user input was swapped out with random numbers.
*/

fun main() {
    // BANK ACCOUNT PROJECT PART ONE
    // Step One
    var introMessage: String = """
        Welcome to Best Bank.
        What type of account would you like to create?
        1. Debit account
        2. Credit account
        3. Checking account
    """.trimIndent()
    print(introMessage)

    // Step Two
    var accountType: String = ""
    var userChoice: Int = 0

    // Step Three
    while (accountType == "") {
        println("Choose an option (1, 2 or 3)")
        userChoice = (1..5).random() // 1 to 5 allows for 'wrong' choices
        println("The selected option is $userChoice.")
        when (userChoice.toString()) {
            "1" -> {
                accountType = "debit"
            }
            "2" -> {
                accountType = "credit"
            }
            "3" -> {
                accountType = "checking"
            }
            else -> {
                continue
            }
        }
    }

    // Step Four
    println("You have created a $accountType account.")

    // BANK ACCOUNT PROJECT PART TWO
    // Step One
    var accountBalance: Int = (0..1000).random()
    println("Account Balance: $accountBalance (dollars).")
    val money: Int = (0..1000).random()
    println("Transaction Amount: $money (dollars).")

    // Step Two
    // var output: Int = 0

    // Step Three
    fun withdraw(amount: Int) : Int {
        accountBalance -= amount
        println("Amount withdrawn: $amount.")
        println("New balance is: $accountBalance")
        return amount
    }

    // Step Four
    // output = withdraw(money)
    // println("The amount you withdrew is $output dollars.")

    // Step Five
    fun debitWithdraw(amount: Int) : Int {
        if (accountBalance == 0) {
            println("Can't withdraw, no money in this account!")
            return accountBalance
        } else if (amount > accountBalance) {
            println("Insufficient funds in account. Balance is ${accountBalance} dollars.")
            return 0 // 0 == no money withdrawn
        } else {
            return withdraw(amount)
        }
    }

    // Step Six
    // output = debitWithdraw(money)
    // println("The amount you withdrew is $output dollars.")

    // Step Seven
    fun deposit(amount: Int) : Int {
        accountBalance += amount
        println("Amount deposited: $amount.")
        println("New balance is: $accountBalance")
        return amount
    }

    // Step Eight
    // output = deposit(money)
    // println("The amount you deposited is $output dollars.")

    // Step Nine
    fun creditDeposit(amount: Int) : Int {
        if (accountBalance == 0) {
            println("You don't need to deposit anything in order to pay off the account since it has already been paid off.")
            return accountBalance
        } else if (accountBalance + amount > 0) {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking balance is ${accountBalance} dollars.")
            return 0
        } else if (amount == -accountBalance) {
            accountBalance = 0
            println("You have paid off this account!")
            return amount
        } else {
            return deposit(amount)
        }
    }

    // Step Ten
    // output = creditDeposit(money)
    // println("The amount you deposited is $output dollars.")

    // BANK ACCOUNT PROJECT PART THREE
    // Step One
    // Update code/comment out unnecessary code above

    // Step Two
    fun transfer(mode: String) {
        val transferAmount: Int
        when (mode) {
            "withdraw" -> {
                if (accountType == "debit") {
                    transferAmount = debitWithdraw(money)
                } else {
                    transferAmount = (money)
                }
                println("The amount you withdrew is ${transferAmount} dollars.")
            }
            "deposit" -> {
                if (accountType == "credit") {
                    transferAmount = creditDeposit(money)
                } else {
                    transferAmount = deposit(money)
                }
                println("The amount you deposited is ${transferAmount} dollars.")
            }
            else -> {
                // An empty return will do nothing
                return
            }
        }
    }

    var isSystemOpen: Boolean = true
    var option: Int = 0

    while (isSystemOpen == true) {
        var actionMessage: String = """
            What would you like to do?
            1. Check bank account balance
            2. Withdraw money
            3. Deposit money
            4. Close the app
            Which option do you choose? (1, 2, 3, or 4)
        """.trimIndent()
        println(actionMessage)
        option = (1..5).random()
        println("Option selected: $option.")
        when (option.toString()) {
            "1" -> {
                println("Account balance is $accountBalance dollars.")
            }
            "2" -> {
                transfer("withdraw")
            }
            "3" -> {
                transfer("deposit")
            }
            "4" -> {
                isSystemOpen = false
                println("Thank you for banking with us today!")
            }
            else -> {
                // No account operation is performed for invalid entry
                continue
            }
        }
    }
}