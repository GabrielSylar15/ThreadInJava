using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Logging;
using ClosedXML.Excel;
using System.IO;
using Microsoft.AspNetCore.Http;
namespace ImportExcel.Pages
{    public class Bill
    {
        public string RoomName { set; get; }
        public string EletricBill { set; get; }
        public string WaterBill { set; get; }
        public string RoomBill { set; get; }
        public string Paid { set; get; }
        public string Debt { set; get; }
        public string Note { set; get; }
        public string DatePaid { set; get; }
    }
    public class IndexModel : PageModel
    {
        private readonly ILogger<IndexModel> _logger;

        public IndexModel(ILogger<IndexModel> logger)
        {
            _logger = logger;
        }

        public void OnGet()
        {
            Console.WriteLine("GET METHOD------");
        }
        public async Task OnPostPayment(IFormFile file){
            Console.WriteLine("POST METHOD------");
            int row = 1;
            List<Bill> listBills = new List<Bill>();
            if(file!=null & file.Length>0){
                using(var stream = new MemoryStream()){
                    await file.CopyToAsync(stream);                    
                    Bill bill = new Bill();
                    var xl = new XLWorkbook(stream).Worksheets.First();
                    List<string> lists  = xl.Column("A").Cells().Select(c => c.Value.ToString()).ToList();
                    Console.WriteLine( xl.LastRow().RowNumber());
                    while(true){
                        if(xl.Row(row).Cell(1).Value==null||"".Equals(xl.Row(row).Cell(1).Value.ToString()))   break;
                        bill = new Bill();
                        bill.RoomName = xl.Row(row).Cell(1).Value.ToString();
                        bill.EletricBill = xl.Row(row).Cell(2).Value.ToString();
                        bill.WaterBill = xl.Row(row).Cell(3).Value.ToString();
                        bill.RoomBill = xl.Row(row).Cell(4).Value.ToString();
                        bill.Paid = xl.Row(row).Cell(5).Value.ToString();
                        bill.Debt = xl.Row(row).Cell(6).Value.ToString();
                        bill.Note = xl.Row(row).Cell(7).Value.ToString();
                        bill.DatePaid = xl.Row(row).Cell(8).Value.ToString();
                        listBills.Add(bill);
                                            Console.WriteLine("------"+xl.Row(row).Cell(1).Value.ToString()+"--------");
                        row+=1;
                    }
                }
            }
            foreach(Bill b in listBills){
                Console.WriteLine(b.RoomName + "-"+b.EletricBill+"-"+b.DatePaid+"-"+b.Debt+"-"+b.WaterBill);
            }
        }
    }
}
