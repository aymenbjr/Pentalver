<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Modification commande</title>

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
                        <h2 class="form-title">Modifier la Commande N° ${commande.id_commande }</h2>
                        <form method="POST" action="modifierCommandeClient" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="hidden" name="id_commande"  value="${commande.id_commande }"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="id_client"  value="${commande.id_client }"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="id_conteneur"  value=" ${commande.id_conteneur }"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="nom_cl" value="${commande.nom_cl }"/>
                            </div>
                            <div class="form-group">
                                <label for="Telephone"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="titre"   value=" ${commande.titre }"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="type"  value="${commande.type }"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="prix"  value="${commande.prix }"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="taille"  value="${commande.taille }"/>
                            </div>
                             
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Modifer"/>
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