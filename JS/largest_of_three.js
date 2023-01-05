// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 6. Write a JavaScript to find the largest of 3 numbers.

let x = parseInt(prompt(`Enter the first number:  `));
let y = parseInt(prompt(`Enter the second number:  `));
let z = parseInt(prompt(`Enter the third nummber:  `));

if(x > y && x > z) {
    console.log(`${x} is the largest among ${x},  ${y}  and  ${z}`);
} else if(y > x && y > z) {
    console.log(`${y} is the largest among ${x},  ${y}  and  ${z}`);
} else {
    console.log(`${z} is the largest among ${x},  ${y}  and  ${z}`);
}