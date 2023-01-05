// Contributed by - Anuj Das (Gurucharan College, Silchar - @Department of Computer Science)

// 8. Write a JavaScript to enter a list of positive integers terminated by 0. Find the sum and average of these integers in the list.

let sum = 0;
let list = [];

while(true) {
    let num  = parseInt(prompt(`Enter Positive Integers (Enter 0 to Terminate):  `));
    if(num == 0) {
        break;
    }
    list.push(num); 
}

list.forEach(element => {
    sum += element;
});

let average = sum / list.length;

console.log(list);
console.log(`The Sum of all the positive numbers in the list is ${sum}`);
console.log(`The Average of all the positive numbers in the list is ${average}`);