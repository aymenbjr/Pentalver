<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ajouter conteneur</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Ajouter un conteneur</h2>
                        <form method="POST" action="ajoutConteneur" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="titre"  placeholder="titre"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="type"  placeholder="type"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="text" name="prix" placeholder="prix"/>
                            </div>
                            <div class="form-group">
                                <label for="Telephone"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="description"   placeholder="description"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="text" name="image"  placeholder="image"/>
                            </div>
                            <div class="form-group">
                                <label for="Telephone"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="taille"  placeholder="taille"/>
                            </div> 
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" placeholder="Ajouter"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="http://localhost:8080/Pentalver/Admin" class="signup-image-link">Revenir à l'acceuil</a>
                    </div>
                </div>
            </div>
        </section>