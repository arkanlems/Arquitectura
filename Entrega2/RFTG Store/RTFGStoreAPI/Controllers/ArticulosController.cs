using RTFGStoreAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace RTFGStoreAPI.Controllers
{
    public class ArticulosController : ApiController
    {
        private proyectoasEntities db = new proyectoasEntities();

        public IQueryable<articulo> GetArticulos()
        {
            return db.articulo;
        }
        public HttpResponseMessage PostArticulos(articulo art)
        {
            if (!ModelState.IsValid)
            {
                db.articulo.Add(art);
                db.SaveChanges();
                HttpResponseMessage response = Request.CreateResponse(HttpStatusCode.Created, art);
                response.Headers.Location = new Uri(Url.Link("DefaultApi", new { id = art.uniqueid}));
                return response;
            }
            else
            {
                return Request.CreateErrorResponse(HttpStatusCode.BadRequest, ModelState);
            }

        }

    }
}
