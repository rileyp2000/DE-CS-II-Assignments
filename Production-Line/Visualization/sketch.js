var inputField, productionLine, itemsInQueue, output,towers,t;
var button, header;

function setup(){
  createCanvas(windowWidth, windowHeight);
  header = createElement('h2', "Production Line Visualized");
  button = createButton('Process Next Disk');
  header.position(0,0);
  header.center("horizontal");
  button.position(10, 150);

  productionLine = new ProductionLine();
  button.mousePressed(setRun);
  t = new Tower();
  randomSeed(8675309);
  var ct = 0;
  while(ct < 10){
    let rnd = round(random(1, 15));
    var d = new Disk(rnd);
    //console.log(rnd);
    productionLine.addDisk(d);
    t.push(d);
    ct++;
  }
  //productionLine.addDisk(new Disk(3));
  //productionLine.addDisk(new Disk(2));

  itemsInQueue = createP("Put into input: " +productionLine.getInput());
  itemsInQueue.position(0, 80);

  //frameRate(1);
  //productionLine.run();
}

function setRun(){
  productionLine.setRunn((productionLine.getRun() + 1) % 3);
}

function clearDraw(){
  noStroke();
  fill(255);
  rect(0, windowHeight * .8 - 20 , windowWidth * .45, 20);
  rect(windowWidth * .5 - 60, windowHeight * .8 - 155, 201, 75);
  rect(windowWidth * .6 + 1, windowHeight * .8 - 21, windowWidth * .3, 20);

}

function drawDisks(){
  clearDraw();
  productionLine.drawInput();
  productionLine.drawRobotArm();
  productionLine.drawOutput();
}

function drawBase(y, mid){
  fill(0);
  rect(10, windowHeight * .8, windowWidth * .40 - 10, 20, 10);
  rect(windowWidth * .5 - 10, windowHeight * .8 - 80, 50, 75, 10);
  rect(windowWidth * .6 + 10, windowHeight * .8, windowWidth * .3, 20, 10);
}

function draw(){
  productionLine.run();
  //productionLine.drawInput();\
  let y = windowHeight * .8 - 80;
  let mid = windowWidth * .5 + 15;
  drawBase(y, mid);
  drawDisks();

}
