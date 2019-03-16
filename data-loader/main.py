import jaydebeapi
from data import data

from config import jclassname, driver_args, jar_path


if __name__ == "__main__":

    conn = jaydebeapi.connect(jclassname=jclassname, driver_args=driver_args, jars=jar_path)
    curs = conn.cursor()

    for dish in data:
        print(dish)
        curs.execute("insert into canteen.dishes"
                     " (calories, carbohydrates, fats, proteins, weight, price, ext_id, name, canteen_id, category)"
                     " values ({calories}, {carbohydrates}, {fats}, {proteins},"
                     " {weight}, {price}, '{ext_id}', '{name}', {canteen_id}, '{category}')".
                     format(
                            calories=dish["calories"],
                            fats=dish["fats"],
                            proteins=dish["proteins"],
                            weight=dish["weight"],
                            carbohydrates=dish["carbo"],
                            price=dish["price"],
                            ext_id=dish["ext_id"],
                            name=dish["name"],
                            canteen_id=dish["canteen_id"],
                            category=dish["category"]
                            ))

    curs.execute("select * from canteen.dishes")
    for item in curs.fetchall():
        print(item)
