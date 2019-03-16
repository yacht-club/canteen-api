from uuid import uuid4

data = [  # SOUP
         {"calories": 57.7, "carbo": 4.3, "fats": 2.9, "proteins": 3.8, "price": 50, "category": "SOUP", "name": "борщ", "weight": 200, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 50.9, "carbo": 4.6, "fats": 3.4, "proteins": 0.8, "price": 60, "category": "SOUP", "name": "грибной суп", "weight": 190, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 54.3, "carbo": 5, "fats": 3, "proteins": 2.2, "price": 42, "category": "SOUP", "name": "гороховый суп", "weight": 250, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 59.7, "carbo": 3.1, "fats": 3.3, "proteins": 4.5, "price": 70, "category": "SOUP", "name": "куриный суп", "weight": 200, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 57.7, "carbo": 4.3, "fats": 2.9, "proteins": 3.8, "price": 50, "category": "SOUP", "name": "борщ", "weight": 200, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 50.9, "carbo": 4.6, "fats": 3.4, "proteins": 0.8, "price": 60, "category": "SOUP", "name": "грибной суп", "weight": 190, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 54.3, "carbo": 5, "fats": 3, "proteins": 2.2, "price": 42, "category": "SOUP", "name": "гороховый суп", "weight": 250, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 59.7, "carbo": 3.1, "fats": 3.3, "proteins": 4.5, "price": 70, "category": "SOUP", "name": "куриный суп", "weight": 200, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 57.7, "carbo": 4.3, "fats": 2.9, "proteins": 3.8, "price": 50, "category": "SOUP", "name": "борщ постный", "weight": 200, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 50.9, "carbo": 4.6, "fats": 3.4, "proteins": 0.8, "price": 60, "category": "SOUP", "name": "грибной суп", "weight": 190, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 54.3, "carbo": 5, "fats": 3, "proteins": 2.2, "price": 42, "category": "SOUP", "name": "гороховый суп", "weight": 250, "canteen_id": 4, "ext_id": str(uuid4())},
         {"calories": 59.7, "carbo": 3.1, "fats": 3.3, "proteins": 4.5, "price": 70, "category": "SOUP", "name": "куриный суп с макаронами", "weight": 200, "canteen_id": 4, "ext_id": str(uuid4())},

         # DRINK
         {"calories": 41.1, "carbo": 10.6, "fats": 0.05, "proteins": 0.2, "price": 10, "category": "DRINK", "name": "чай с лимоном", "weight": 200, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 64.1, "carbo": 12.1, "fats": 1.5, "proteins": 1.4, "price": 40, "category": "DRINK", "name": "кофе с молоком", "weight": 200, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 55.2, "carbo": 14.6, "fats": 0.02, "proteins": 0.06, "price": 15, "category": "DRINK", "name": "компот из ягод", "weight": 220, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 75.2, "carbo": 19.9, "fats": 0.05, "proteins": 0.07, "price": 30, "category": "DRINK", "name": "кисель из вишни", "weight": 220, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 41.1, "carbo": 10.6, "fats": 0.05, "proteins": 0.2, "price": 10, "category": "DRINK", "name": "чай с лимоном", "weight": 200, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 64.1, "carbo": 12.1, "fats": 1.5, "proteins": 1.4, "price": 40, "category": "DRINK", "name": "кофе с молоком", "weight": 200, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 55.2, "carbo": 14.6, "fats": 0.02, "proteins": 0.06, "price": 15, "category": "DRINK", "name": "компот из ягод", "weight": 220, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 41.1, "carbo": 10.6, "fats": 0.05, "proteins": 0.2, "price": 10, "category": "DRINK", "name": "чай с лимоном", "weight": 200, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 64.1, "carbo": 12.1, "fats": 1.5, "proteins": 1.4, "price": 40, "category": "DRINK", "name": "кофе с молоком", "weight": 200, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 55.2, "carbo": 14.6, "fats": 0.02, "proteins": 0.06, "price": 15, "category": "DRINK", "name": "компот из ягод", "weight": 220, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 41.1, "carbo": 10.6, "fats": 0.05, "proteins": 0.2, "price": 10, "category": "DRINK", "name": "чай с лимоном", "weight": 200, "canteen_id": 4, "ext_id": str(uuid4())},
         {"calories": 64.1, "carbo": 12.1, "fats": 1.5, "proteins": 1.4, "price": 40, "category": "DRINK", "name": "кофе с молоком", "weight": 200, "canteen_id": 4, "ext_id": str(uuid4())},
         {"calories": 55.2, "carbo": 14.6, "fats": 0.02, "proteins": 0.06, "price": 15, "category": "DRINK", "name": "компот из ягод", "weight": 220, "canteen_id": 4, "ext_id": str(uuid4())},

         # SALAD
         {"calories": 100.2, "carbo": 2, "fats": 13.5, "proteins": 7.4, "price": 30, "category": "SALAD", "name": "овощной", "weight": 150, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 130.1, "carbo": 8.2, "fats": 10.3, "proteins": 1.7, "price": 45, "category": "SALAD", "name": "винегрет", "weight": 200, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 100.2, "carbo": 2, "fats": 13.5, "proteins": 7.4, "price": 30, "category": "SALAD", "name": "овощной", "weight": 150, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 130.1, "carbo": 8.2, "fats": 10.3, "proteins": 1.7, "price": 45, "category": "SALAD", "name": "винегрет", "weight": 200, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 100.2, "carbo": 2, "fats": 13.5, "proteins": 7.4, "price": 30, "category": "SALAD", "name": "овощной", "weight": 150, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 130.1, "carbo": 8.2, "fats": 10.3, "proteins": 1.7, "price": 45, "category": "SALAD", "name": "винегрет", "weight": 200, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 100.2, "carbo": 2, "fats": 13.5, "proteins": 7.4, "price": 30, "category": "SALAD", "name": "овощной", "weight": 150, "canteen_id": 4, "ext_id": str(uuid4())},
         {"calories": 130.1, "carbo": 8.2, "fats": 10.3, "proteins": 1.7, "price": 45, "category": "SALAD", "name": "винегрет", "weight": 200, "canteen_id": 4, "ext_id": str(uuid4())},

          # MAINCOURSE
         {"calories": 326, "carbo": 7.7, "fats": 22, "proteins": 24.9, "price": 150, "category": "MAINCOURSE", "name": "гуляш", "weight": 300, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 342, "carbo": 2.6, "fats": 29.7, "proteins": 16.3, "price": 100, "category": "MAINCOURSE", "name": "омлет с сыром", "weight": 250, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 142, "carbo": 0.7, "fats": 7.9, "proteins": 17.1, "price": 135, "category": "MAINCOURSE", "name": "куриные рулетики", "weight": 300, "canteen_id": 1, "ext_id": str(uuid4())},
         {"calories": 326, "carbo": 7.7, "fats": 22, "proteins": 24.9, "price": 150, "category": "MAINCOURSE", "name": "гуляш", "weight": 300, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 342, "carbo": 2.6, "fats": 29.7, "proteins": 16.3, "price": 100, "category": "MAINCOURSE", "name": "омлет с сыром", "weight": 250, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 142, "carbo": 0.7, "fats": 7.9, "proteins": 17.1, "price": 135, "category": "MAINCOURSE", "name": "куриные рулетики", "weight": 300, "canteen_id": 2, "ext_id": str(uuid4())},
         {"calories": 142, "carbo": 0.7, "fats": 7.9, "proteins": 17.1, "price": 135, "category": "MAINCOURSE", "name": "куриные рулетики", "weight": 300, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 326, "carbo": 7.7, "fats": 22, "proteins": 24.9, "price": 150, "category": "MAINCOURSE", "name": "гуляш", "weight": 300, "canteen_id": 4, "ext_id": str(uuid4())},
         {"calories": 342, "carbo": 2.6, "fats": 29.7, "proteins": 16.3, "price": 100, "category": "MAINCOURSE", "name": "омлет с сыром", "weight": 250, "canteen_id": 3, "ext_id": str(uuid4())},
         {"calories": 142, "carbo": 0.7, "fats": 7.9, "proteins": 17.1, "price": 135, "category": "MAINCOURSE", "name": "куриные рулетики", "weight": 300, "canteen_id": 4, "ext_id": str(uuid4())},
         ]