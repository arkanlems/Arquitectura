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

            Console.Write("entreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            return db.articulo;
        }

       
        public bool PostArticulos( articulo item)
        {

            if (item == null)
            {
                throw new ArgumentNullException("item");
            }
            articulo actulizado = db.articulo.Where(a => a.uniqueid == item.uniqueid).FirstOrDefault();
            if (actulizado == null)
            {
                return false;
            }
            actulizado.und_disponibles = item.und_disponibles;
            db.SaveChanges();
            return true;
            


        }

    }
}
