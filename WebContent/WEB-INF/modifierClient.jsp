<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Modification client</title>

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
                        <h2 class="form-title">Modifier le client N° ${client.id_client }</h2>
                        <form method="POST" action="modifierClient" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="hidden" name="id_client"  value="${client.id_client }"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="nom"  value=" ${client.nom }"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="text" name="email" value="${client.email }"/>
                            </div>
                            <div class="form-group">
                                <label for="Telephone"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="password"   value=" ${client.password }"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="text" name="tel"  value="${client.tel }"/>
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