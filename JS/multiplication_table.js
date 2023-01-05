// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 7. Write a JavaScript to print the multiplication table of a given Integer.

let num = parseInt(prompt("Print the Multiplication Table of ??"));
let printUpto = parseInt(prompt(`Print the Multiplication Table of ${num}, upto ??`));

for(let i = 1; i <= printUpto; i++) {
    console.log(`${num} X ${i} = ${num*i}`);
}