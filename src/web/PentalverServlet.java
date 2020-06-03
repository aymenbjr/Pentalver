package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientImpl;
import dao.CommandeImpl;
import dao.ConteneurImpl;
import dao.DepotImpl;
import dao.IClient;
import dao.ICommande;
import dao.IConteneur;
import dao.IDepot;
import entities.Client;
import entities.Commande;
import entities.Conteneur;
import entities.Depot;



@WebServlet({"/Admin","/modifierCo","/modifierClient","/modifierDep","/supprimerCo","/supprimerClient","/supprimerDep"
	,"/ajoutConteneur","/ajoutDepot","/ajoutClient","/Commande","/deconnexion","/login","/registration","/Acceuil"
	,"/conteneur","/deleteCommande","/categorie","/recherche","/detail","/addCommande","/utilisateur_commande"
	,"/modifierCommandeClient","/modifierCommande","/deleteCommandeClient"})

public class PentalverServlet extends HttpServlet {
	private IConteneur conteneurDAO;
	private IClient clientDAO;
	private IDepot depotDAO;
	private ICommande commandeDAO;
	
	
	HttpSession session;
	@Override
	public void init() throws ServletException {
		conteneurDAO = new ConteneurImpl();
		clientDAO = new ClientImpl();
		depotDAO = new DepotImpl();
		commandeDAO = new CommandeImpl();
	}
	
	
	
    public PentalverServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getServletPath().equals("/Admin")) {
			List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
			request.setAttribute("conteneur", kantonir);
			List<Depot> dipo =  depotDAO.ListDepot();
			request.setAttribute("depot", dipo);
			List<Client> klyan =  clientDAO.ListClient();
			request.setAttribute("client", klyan);
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/modifierCo")) {
			String idConteneur = request.getParameter( "id_c" );
	    	if(idConteneur == null) {
	    		request.setAttribute("erreur", "une erreur est survenue");
	    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	    	}else{
	    		Conteneur conteneur = conteneurDAO.getConteneur(idConteneur);
			request.setAttribute("conteneur", conteneur);
	    	request.getRequestDispatcher("WEB-INF/modifierCo.jsp").forward(request, response);
	    	}
		
	}
if(request.getServletPath().equals("/detail")) {
	Client clyan = (Client) request.getSession().getAttribute("session");
	if(clyan == null){
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}else{
			String idControleur = request.getParameter( "id_c" );		
				Conteneur conteneurAffichee = conteneurDAO.getConteneur(idControleur);
					request.setAttribute("idUtilisateur", clyan.getId_client());
					int id = clyan.getId_client();
					request.setAttribute("id", id);

				request.setAttribute("conteneur", conteneurAffichee);			
				request.getRequestDispatcher("WEB-INF/produit.jsp").forward(request, response);
			}
			}
		
		if(request.getServletPath().equals("/Acceuil")) {
			Client clyan = (Client) request.getSession().getAttribute("session");
			if(clyan == null){
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}else{
				int id = clyan.getId_client();
				request.setAttribute("id", id);
				
	    	request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
			}
			
	    	}
		
		if(request.getServletPath().equals("/categorie")) {
			Client clyan = (Client) request.getSession().getAttribute("session");
			if(clyan == null){
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}else{
			String categorieConteneur = request.getParameter( "categorie_c" );
	    	if(categorieConteneur == null) {
				int id = clyan.getId_client();
				request.setAttribute("id", id);
	    		request.getRequestDispatcher("WEB-INF/categories.jsp").forward(request, response);
	    	} else {
	    		List<Conteneur> conteneurs = conteneurDAO.ListParType(categorieConteneur);
	    		request.setAttribute("conteneur", conteneurs);		
				int id = clyan.getId_client();
				request.setAttribute("id", id);		
	    		request.getRequestDispatcher("WEB-INF/conteneur.jsp").forward(request, response);
	    	}
		}	
		}
		


		if(request.getServletPath().equals("/utilisateur_commande")) {
			Client clyan = (Client) request.getSession().getAttribute("session");
			if(clyan == null){
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}else{
				int idU = Integer.parseInt(request.getParameter( "id_client"));
				List<Commande> commandes =  commandeDAO.ListCommandeClient(idU);
				request.setAttribute("commande", commandes);
				int id = clyan.getId_client();
				request.setAttribute("id", id);
			request.getRequestDispatcher("WEB-INF/ClientCmd.jsp").forward(request, response);
		}
		}
		
		if(request.getServletPath().equals("/addCommande")) {
			Client clyan = (Client) request.getSession().getAttribute("session");
			if(clyan == null){
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}else{
				String idC = request.getParameter( "id_c" );
				String idU = request.getParameter( "id_u" );
				
				Conteneur C = conteneurDAO.getConteneur(idC);
				Client Cl = clientDAO.getClient(idU);
				String nom_cl = Cl.getNom();
				String titre2 = C.getTitre(); 
				String type2 = C.getType();
				Double taille2 = C.getTaille();
				Double prix2 = C.getPrix();
				int id = clyan.getId_client();
				request.setAttribute("id", id);

				commandeDAO.addCommande(idC,idU,nom_cl,titre2,type2,taille2,prix2);
	    		request.setAttribute("succes", "Commande bien placée");
			
			request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
		}
		}
		
		if(request.getServletPath().equals("/conteneur")) {
			Client clyan = (Client) request.getSession().getAttribute("session");
			if(clyan == null){
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}else{
			List<Conteneur> conteneurs = conteneurDAO.ListConteneur();
    		request.setAttribute("conteneur", conteneurs);		
			int id = clyan.getId_client();
			request.setAttribute("id", id);
			
			request.getRequestDispatcher("WEB-INF/conteneur.jsp").forward(request, response);
		}
		}
		

	
	if(request.getServletPath().equals("/Commande")) {
		List<Commande> commandes =  commandeDAO.ListCommande();
		request.setAttribute("commande", commandes);
    	request.getRequestDispatcher("WEB-INF/commande.jsp").forward(request, response);
    	}
	
	
		
		if(request.getServletPath().equals("/modifierClient")) {
				String idClient = request.getParameter( "id_c" );
		    	if(idClient == null) {
		    		request.setAttribute("erreur", "une erreur est survenue");
		    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		    	}else{
		    		Client client = clientDAO.getClient(idClient);
				request.setAttribute("client", client);
		    	request.getRequestDispatcher("WEB-INF/modifierClient.jsp").forward(request, response);
		    	}
			
		}
			
			if(request.getServletPath().equals("/modifierDep")) {
				String idDep = request.getParameter( "id_c" );
		    	if(idDep == null) {
		    		request.setAttribute("erreur", "une erreur est survenue");
		    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		    	}else{
		    		Depot dipo = depotDAO.getDep(idDep);
				request.setAttribute("depot", dipo);
		    	request.getRequestDispatcher("WEB-INF/modifierDep.jsp").forward(request, response);
		    	}
		    	
		}

		if(request.getServletPath().equals("/modifierCommande")) {
			String idCmd = request.getParameter( "id_c" );
	    	if(idCmd == null) {
	    		request.setAttribute("erreur", "une erreur est survenue");
	    		request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
	    	}else{
	    		Commande cmd = commandeDAO.getCmd(idCmd);
			request.setAttribute("commande", cmd);
	    	request.getRequestDispatcher("WEB-INF/modifierCmd.jsp").forward(request, response);
	    	}
		
	}


		if(request.getServletPath().equals("/modifierCommandeClient")) {
			String idCmd = request.getParameter( "id_c" );
	    	if(idCmd == null) {
	    		request.setAttribute("erreur", "une erreur est survenue");
	    		request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
	    	}else{
	    	Commande cmd = commandeDAO.getCmd(idCmd);
			request.setAttribute("commande", cmd);
	    	request.getRequestDispatcher("WEB-INF/modifierCommandeClient.jsp").forward(request, response);
	    	}
		
	}
			
			if(request.getServletPath().equals("/deleteCommande")) {
				String idCommande = request.getParameter( "id_c" );
		    	if(idCommande == null) {
		    		request.setAttribute("erreur", "une erreur est survenue");
		    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		    	}else{
		    		int idd=Integer.parseInt(idCommande);
		    		commandeDAO.deleteCommande(idd);
		    		//chargement des listes
		    		List<Commande> commandes =  commandeDAO.ListCommande();
		    		request.setAttribute("commande", commandes);
					request.setAttribute("succes", "La Commande numero "+idCommande+" est supprimée!");
		        	request.getRequestDispatcher("WEB-INF/commande.jsp").forward(request, response);
		    	}
			}
			
			if(request.getServletPath().equals("/deleteCommandeClient")) {
				String idCommande = request.getParameter( "id_c" );
		    	if(idCommande == null) {
		    		request.setAttribute("erreur", "une erreur est survenue");
		    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		    	}else{
		    		int idd=Integer.parseInt(idCommande);
		    		Commande cm = commandeDAO.getCmd(idCommande);
		    		commandeDAO.deleteCommande(idd);
		    		//chargement des listes
		    		List<Commande> commandes =  commandeDAO.ListCommandeClient(cm.getId_client());
					request.setAttribute("commande", commandes);
					request.setAttribute("succes", "La Commande numero "+idCommande+" est supprimée!");
		        	request.getRequestDispatcher("WEB-INF/ClientCmd.jsp").forward(request, response);
		    	}
			}
			
			
		if(request.getServletPath().equals("/supprimerCo")) {
			String idConteneur = request.getParameter( "id_c" );
	    	if(idConteneur == null) {
	    		request.setAttribute("erreur", "une erreur est survenue");
	    		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	    	}else{
	    		int idd=Integer.parseInt(idConteneur);
	    		conteneurDAO.deleteConteneur(idd);
	    		//chargement des listes
	    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
				request.setAttribute("conteneur", kantonir);
				List<Depot> dipo =  depotDAO.ListDepot();
				request.setAttribute("depot", dipo);
				List<Client> klyan =  clientDAO.ListClient();
				request.setAttribute("client", klyan);
				request.setAttribute("succes", "Conteneur "+idConteneur+" supprimé!");
	    	request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	    	}
		
		}
		
		if(request.getServletPath().equals("/supprimerClient")) {
			String idClient= request.getParameter( "id_c" );
    		int idd=Integer.parseInt(idClient);
    		clientDAO.deleteClient(idd);
    		//chargement des listes
    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
			request.setAttribute("conteneur", kantonir);
			List<Depot> dipo =  depotDAO.ListDepot();
			request.setAttribute("depot", dipo);
			List<Client> klyan =  clientDAO.ListClient();
			request.setAttribute("client", klyan);
			request.setAttribute("succes", "Client "+idClient+" supprimé!");
    	request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
    	
	
	}
		
		if(request.getServletPath().equals("/supprimerDep")) {
			String idDepot= request.getParameter( "id_c" );
	    		int idd=Integer.parseInt(idDepot);
	    		depotDAO.deleteDep(idd);
	    		//chargement des listes
	    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
				request.setAttribute("conteneur", kantonir);
				List<Depot> dipo =  depotDAO.ListDepot();
				request.setAttribute("depot", dipo);
				List<Client> klyan =  clientDAO.ListClient();
				request.setAttribute("client", klyan);
				request.setAttribute("succes", "Depot "+idDepot+" supprimé!");
	    	request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	    	
		
		}
		
		if(request.getServletPath().equals("/login")) {
			
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/registration")) {
			
			request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/ajoutConteneur")) {

			request.getRequestDispatcher("WEB-INF/ajoutConteneur.jsp").forward(request, response);
		
}

		
		if(request.getServletPath().equals("/ajoutDepot")) {

			request.getRequestDispatcher("WEB-INF/ajoutDepot.jsp").forward(request, response);
		
	}
		
		if(request.getServletPath().equals("/ajoutClient")) {

			request.getRequestDispatcher("WEB-INF/ajoutClient.jsp").forward(request, response);
		
		}
		
		
		if(request.getServletPath().equals("/deconnexion")){
			session = request.getSession();
			session.invalidate();
			request.setAttribute("succes", "Vous vous êtes bien déconnecté(e)");
			// Redirection vers la page d'acceuil
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//--------------------------------------------------------
		
		if(request.getServletPath().equals("/modifierCo")) {
			try {
				String id_conteneur = request.getParameter("id_conteneur");
				System.out.println(id_conteneur);
				String titre = request.getParameter("titre");
				String type = request.getParameter("type");
				String prix = request.getParameter("prix");
				String description = request.getParameter("description");
				String image = request.getParameter("image");
				String taille = request.getParameter("taille");
				
				Conteneur nouveauCo = new Conteneur(Integer.parseInt(id_conteneur),titre,type,Double.valueOf(prix), description,image ,Double.valueOf(taille));
				conteneurDAO.editConteneur(nouveauCo);
				
				//chargement des listes
	    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
				request.setAttribute("conteneur", kantonir);
				List<Depot> dipo =  depotDAO.ListDepot();
				request.setAttribute("depot", dipo);
				List<Client> klyan =  clientDAO.ListClient();
				request.setAttribute("client", klyan);
				request.setAttribute("succes", "Conteneur "+id_conteneur+" modifié!");
			} catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			}	
	}
		
		//--------------------------------------------------------
if(request.getServletPath().equals("/recherche")){
	Client clyan = (Client) request.getSession().getAttribute("session");
	if(clyan == null){
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}else{
			
			String recherche = request.getParameter("recherche");
			if(recherche.equals("")){
				String option = request.getParameter("option");
				if(option=="0"){
					response.sendRedirect("http://localhost:8080/Kargo/Acceuil");
				}
				else if(option.equals("1")){
					response.sendRedirect("http://localhost:8080/Pentalver/categorie?categorie_c=DRY");
				}
				else if(option.equals("2")){
					response.sendRedirect("http://localhost:8080/Pentalver/categorie?categorie_c=OPEN TOP");
				}
				else if(option.equals("3")){
					response.sendRedirect("http://localhost:8080/Pentalver/categorie?categorie_c=FLAT RACK");
				}
				
			}else{
			List<Conteneur> conteneurs =  conteneurDAO.ListParMC(recherche);
			request.setAttribute("conteneur", conteneurs);
			if(conteneurs==null){
				request.setAttribute("erreur", "Aucun Resultat");
				
			}
			int id = clyan.getId_client();
			request.setAttribute("id", id);
			request.getRequestDispatcher("WEB-INF/conteneur.jsp").forward(request, response);
			
			
			}
}
}




	if(request.getServletPath().equals("/modifierCommandeClient")) {
		try {
			String id_commande = request.getParameter("id_commande");
			String id_client = request.getParameter("id_client");
			String id_conteneur = request.getParameter("id_conteneur");
			String nom_cl = request.getParameter("nom_cl");
			String titre = request.getParameter("titre");
			String type = request.getParameter("type");
			String prix = request.getParameter("prix");
			String taille = request.getParameter("taille");
			double pri= Double.valueOf(prix);
			double tail= Double.valueOf(taille);
			Commande nouvelleCommande= new Commande(Integer.parseInt(id_commande),Integer.parseInt(id_client),Integer.parseInt(id_conteneur),nom_cl
					,titre,type,pri,tail); 
			commandeDAO.editCommande(nouvelleCommande);
			
			//chargement des listes
    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
			request.setAttribute("conteneur", kantonir);
			List<Depot> dipo =  depotDAO.ListDepot();
			request.setAttribute("depot", dipo);
			List<Client> klyan =  clientDAO.ListClient();
			request.setAttribute("client", klyan);
			request.setAttribute("succes", "La Commande N°  "+id_commande+" est modifié!");
		} catch (Exception e) {
			request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
		} finally {
			request.getRequestDispatcher("WEB-INF/ClientCmd.jsp").forward(request, response);
		}	
}


			if(request.getServletPath().equals("/modifierClient")) {
				try {
					String id_client = request.getParameter("id_client");
					String nom = request.getParameter("nom");
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					String tel = request.getParameter("tel");
					
					Client nouveauClient = new Client(Integer.parseInt(id_client),nom,email,password,tel);
					clientDAO.editClient(nouveauClient);
					
					//chargement des listes
		    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
					request.setAttribute("conteneur", kantonir);
					List<Depot> dipo =  depotDAO.ListDepot();
					request.setAttribute("depot", dipo);
					List<Client> klyan =  clientDAO.ListClient();
					request.setAttribute("client", klyan);
					request.setAttribute("succes", "Le Client "+nom+" est modifié!");
				} catch (Exception e) {
					request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
				} finally {
					request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
				}	
		}
			
			if(request.getServletPath().equals("/modifierCommande")) {
				try {
					String id_commande = request.getParameter("id_commande");
					String id_client = request.getParameter("id_client");
					String id_conteneur = request.getParameter("id_conteneur");
					String nom_cl = request.getParameter("nom_cl");
					String titre = request.getParameter("titre");
					String type = request.getParameter("type");
					String prix = request.getParameter("prix");
					String taille = request.getParameter("taille");
					double pri= Double.valueOf(prix);
					double tail= Double.valueOf(taille); 
					commandeDAO.editCommande(Integer.parseInt(id_commande),Integer.parseInt(id_client),Integer.parseInt(id_conteneur), nom_cl
							,titre,type,pri,tail);
					
					//chargement des listes
		    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
					request.setAttribute("conteneur", kantonir);
					List<Depot> dipo =  depotDAO.ListDepot();
					request.setAttribute("depot", dipo);
					List<Client> klyan =  clientDAO.ListClient();
					request.setAttribute("client", klyan);
					request.setAttribute("succes", "La Commande N°  "+id_commande+" est modifié!");
				} catch (Exception e) {
					request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
				} finally {
					request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
				}	
		}
			
			//--------------------------------------------------------
			
			if(request.getServletPath().equals("/modifierDep")) {
				try {
					String id_depot = request.getParameter("id_depot");
					String location = request.getParameter("location");
					String capacite = request.getParameter("capacite");
					
					Depot nouveauDepot = new Depot(Integer.parseInt(id_depot),location,Double.valueOf(capacite));
					depotDAO.editDep(nouveauDepot);
					
					//chargement des listes
		    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
					request.setAttribute("conteneur", kantonir);
					List<Depot> dipo =  depotDAO.ListDepot();
					request.setAttribute("depot", dipo);
					List<Client> klyan =  clientDAO.ListClient();
					request.setAttribute("client", klyan);
					request.setAttribute("succes", "Depot "+id_depot+" modifié!");
				} catch (Exception e) {
					request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
				} finally {
					request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
				}	
		}
			
			//--------------------------------------------------------
			if(request.getServletPath().equals("/ajoutConteneur")) {
				try {
					String titre = request.getParameter("titre");
					String type = request.getParameter("type");
					String prix = request.getParameter("prix");
					String description = request.getParameter("description");
					String image = request.getParameter("image");
					String taille = request.getParameter("taille");
					
					Conteneur nouveauCo = new Conteneur(titre,type,Double.valueOf(prix), description,image ,Double.valueOf(taille));
					conteneurDAO.addConteneur(nouveauCo);
					
					//chargement des listes
		    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
					request.setAttribute("conteneur", kantonir);
					List<Depot> dipo =  depotDAO.ListDepot();
					request.setAttribute("depot", dipo);
					List<Client> klyan =  clientDAO.ListClient();
					request.setAttribute("client", klyan);
					request.setAttribute("succes", "Conteneur bien ajouté!");
				
			} catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			}
	}
			//--------------------------------------------------------
			if(request.getServletPath().equals("/ajoutDepot")) {
				try {
					String location = request.getParameter("location");
					String capacite = request.getParameter("capacite");
					
					Depot nouveauDepot = new Depot(location,Double.valueOf(capacite));
					depotDAO.addDep(nouveauDepot);
					
					//chargement des listes
		    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
					request.setAttribute("conteneur", kantonir);
					List<Depot> dipo =  depotDAO.ListDepot();
					request.setAttribute("depot", dipo);
					List<Client> klyan =  clientDAO.ListClient();
					request.setAttribute("client", klyan);
					request.setAttribute("succes", "Depot bien ajouté!");
					
			} catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			}
			}
			//--------------------------------------------------------
			if(request.getServletPath().equals("/ajoutClient")) {
				try {
					String nom = request.getParameter("nom");
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					String tel = request.getParameter("tel");
					
					Client nouveauClient = new Client(nom,email,password,tel);
					clientDAO.ajoutClient(nouveauClient);
					
					//chargement des listes
		    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
					request.setAttribute("conteneur", kantonir);
					List<Depot> dipo =  depotDAO.ListDepot();
					request.setAttribute("depot", dipo);
					List<Client> klyan =  clientDAO.ListClient();
					request.setAttribute("client", klyan);
					request.setAttribute("succes", "Client bien ajouté!");
			
			} catch (Exception e) {
				request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les champs du formulaire ");	
			} finally {
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			}
			}
			//--------------------------------------------------------
			
			if(request.getServletPath().equals("/login")) {

				String exceptionContent = "Une erreur est survenue lors de l'authentification";
				try{
					String nom = request.getParameter("nom");
					String password = request.getParameter("password");
					if(nom.equals("oussama") && password.equals("dridi")){
						//chargement des listes
			    		List<Conteneur> kantonir =  conteneurDAO.ListConteneur();
						request.setAttribute("conteneur", kantonir);
						List<Depot> dipo =  depotDAO.ListDepot();
						request.setAttribute("depot", dipo);
						List<Client> klyan =  clientDAO.ListClient();
						request.setAttribute("client", klyan);
						request.setAttribute("succes", "Bienvenue Oussama, Vous vous êtes bien authentifié");
			    	request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
					}else{
					boolean status = false;
					status=clientDAO.login(nom, password);
					// utilisateur existe dans la base
					if(status){
						// crée la session
						session = request.getSession();
						// on met dedans l'utilisateur authentifié maintenant qu'on sait qu'il existe dans notre base de données
						Client utilisateur = clientDAO.getClient(nom, password);
						session.setAttribute("session", utilisateur);
						request.setAttribute("succes", "Bienvenue "+ utilisateur.getNom() + "! Vous vous êtes bien authentifié");
						request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
				
					}else {
						exceptionContent = "login / mdp incorrect";
						throw new Exception(exceptionContent);
					}
				}
				}catch (Exception e) {
					request.setAttribute("erreur", exceptionContent);	
					request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
				
				}
		}
			//--------------------------------------------------------
			
			if(request.getServletPath().equals("/registration")) {
				try {
					// Restitution des données depuis le formulaire
					String nom = request.getParameter("nom");
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					String telephone = request.getParameter("telephone");
					
					
					Client client = new Client(nom,email ,password ,telephone);		
					clientDAO.ajoutClient(client); 
					Client client2 = clientDAO.getClient(nom, password);
					session = request.getSession();
					session.setAttribute("session", client2);
					request.setAttribute("succes", "Bienvenue "+ client2.getNom() + "! Vous vous êtes bien authentifié");
					request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);
					
				} catch (Exception e) {
					request.setAttribute("erreur", "Une erreur est survenue. Veuillez verifier que vous avez bien saisi les shamps du formulaire ");	
					request.getRequestDispatcher("WEB-INF/registration.jsp").forward(request, response);
				} 
			}
			
			//--------------------------------------------------------
			
			
		
			//-----------------------  fin  ----------------------------
	}

}
