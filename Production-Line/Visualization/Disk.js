class Disk {

  constructor(rad){
    if(rad <= 0 )
      throw "Not a valid radius";

    this.radius = rad;
    this.x = 0;
    this.y = 0;
  }

  getRadius(){
    return this.radius;
  }

  copy(){
    return new Disk(this.radius);
  }

  coord(xx, yy){
    this.x = xx;
    this.y = yy;
  }

  compareTo(disk2){
    return this.getRadius() - disk2.getRadius();
  }

  setX(xx){
    this.x = xx;
  }

  setY(yy){
    this.y = yy;
  }

  display(){
    fill(0,255,255);
    stroke(2);
    rect(this.x, this.y, this.radius * 10, 15, 10);
  }

  toString(){
    return this.radius;
  }

}
