// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 5. Write a JavaScript to find the Factorial of a given number using function.

function findFactorial(num) {
    let fact = 1;
    for(let i = num; i > 0; i--) {
        fact *= i;
    }
    return fact;
}


let x = parseInt(prompt("Enter an Integer:  "));

console.log(`The Factorial of ${x} is ${findFactorial(x)}`);