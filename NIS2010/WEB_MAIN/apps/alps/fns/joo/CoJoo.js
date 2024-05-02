/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoJoo.js
 *@FileTitle : Common JavaScript for Joint Operation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.06.30 박희동
 * 1.0 Creation
=========================================================*/
var gVtOther="0123456789-+=|_,./() ";
var gVtNumber="0123456789";
var gVtSpcChar="-+=|_,./()"; 

    msgs['JOO00000'] = "There is no data.  Please re-check key data.";
	msgs['JOO00001'] = "There is any error in script.  Please check it again.";
	msgs['JOO00002'] = "The length of carrier code is 3 characters only.";
	msgs['JOO00003'] = "Customer Code (XX999999) is invalid !";
	msgs['JOO00004'] = "To create accounts, Please recheck the delete mark.";
	msgs['JOO00005'] = "You should input either Customer or Service Provider code.";
	msgs['JOO00006'] = "Please check the validation of Customer Code.";
	msgs['JOO00007'] = "Please check the validation of Service Provider Code.";
	msgs['JOO00008'] = "Please select 'Carrier code'.";
	msgs['JOO00009'] = "Please select 'Trade code'.";
	msgs['JOO00010'] = "Please select 'Revenue Lane code'.";
	msgs['JOO00011'] = "There is no data to copy.";
	msgs['JOO00012'] = "You can copy after saving the modified data.";
	msgs['JOO00013'] = "Do you want to copy data ?";
	msgs['JOO00014'] = "Please select different carrier code.";
	msgs['JOO00015'] = "You can't choose 'ITEM, Dir. Code' when you click 'Create' button.";
	msgs['JOO00016'] = "You can't choose 'Dir. Code' when you click 'Create' button.";
	msgs['JOO00017'] = "[{?msg1}] ITEM is mandatory to inquiry (length=3).";
	msgs['JOO00018'] = "[{?msg1}] Dir. is mandatory item.";
	msgs['JOO00019'] = "[{?msg1}] is mandatory item.";
	msgs['JOO00020'] = "[{?msg1}] TDR/RDR is mandatory item.";
	msgs['JOO00021'] = "[{?msg1}] Basic port is mandatory item.";
	msgs['JOO00022'] = "[{?msg1}] Second port must be different from basic port.";
	msgs['JOO00023'] = "[{?msg1}] Third port must be different from basic port.";
	msgs['JOO00024'] = "[{?msg1}] Third port must be different from second port.";
	msgs['JOO00025'] = "[{?msg1}] Pair basic port is a mandatory item.";
	msgs['JOO00026'] = "[{?msg1}] Pair second port must be different from basic port.";
	msgs['JOO00027'] = "[{?msg1}] Pair third port must be different from basic port.";
	msgs['JOO00028'] = "[{?msg1}] Pair third port must be different from second port.";
	msgs['JOO00029'] = "[{?msg1}] Pair basic port must be different from basic port.";
	msgs['JOO00030'] = "[{?msg1}] Unit Cost basis port is a mandatory item.";
	msgs['JOO00031'] = "VVD is invalid !";
	msgs['JOO00032'] = "The VVD [{?msg1}] was canceled. If you want to keep on going,  Press 'OK' otherwise press 'CANCEL'.";
	msgs['JOO00033'] = "Please input an account month.";
	msgs['JOO00034'] = "Data already exists.";
	msgs['JOO00035'] = "[{?msg1}] Unit Cost Port is a mandatory item.";
	msgs['JOO00036'] = "There is no data to save.";
	msgs['JOO00037'] = "Please check the Vessel Code.(XXXX)";
	msgs['JOO00038'] = "Please check the Voyage Number(9999).";
	msgs['JOO00039'] = "Please input VVD at first.";
	msgs['JOO00040'] = "Please check the Vessel Code [{?msg1}].";
	msgs['JOO00041'] = "[{?msg1}] Please check the Voyage Number(9999).";
	msgs['JOO00042'] = "[{?msg1}] Please select direction.";
	msgs['JOO00043'] = "[{?msg1}] Please select item.";
	msgs['JOO00044'] = "[{?msg1}] Please select basic port.";
	msgs['JOO00045'] = "[{?msg1}] Please select status.";
	msgs['JOO00046'] = "Do you want to save the changes ?";
	msgs['JOO00047'] = "[{?msg1}] Please select trade code.";
	msgs['JOO00048'] = "[{?msg1}] Please select revenue lane code.";
	msgs['JOO00049'] = "[{?msg1}] Please select main carrier.";
	msgs['JOO00050'] = "[{?msg1}] Please select sub carrier.";
	msgs['JOO00051'] = "[{?msg1}] Sub carrier must be different form main carrier. Error 'Sub-carrier' must be different form main carrier.";
	msgs['JOO00052'] = "[{?msg1}] Please insert a full name.";
	msgs['JOO00053'] = "[{?msg1}] Please check the account code '999999'.";
	msgs['JOO00054'] = "There is no data to be added.";
	msgs['JOO00055'] = "[{?msg1}] Please select revenue direction.";
	msgs['JOO00056'] = "[{?msg1}] Please input amount.";
    msgs['JOO00057'] = "[{?msg1}] You can't remove the data because it has a slip number. [{?msg2}]";
	msgs['JOO00058'] = "[{?msg1}] {?msg2} is empty.";
	msgs['JOO00059'] = "[{?msg1}] There is duplicated.";
	msgs['JOO00060'] = "Item must be empty when you create data.";
	msgs['JOO00061'] = "Do you want to delete all data ?";
	msgs['JOO00062'] = "Please input YYYY-MM of the tax invoice.";
	msgs['JOO00063'] = "Please select office code for the tax invoice number.";
	msgs['JOO00064'] = "Please input 'Issue Date'.";
	msgs['JOO00065'] = "Please input exchange rate.";
	msgs['JOO00066'] = "Year/ Month of tax invoice must be identical with that of issue date.";
	msgs['JOO00067'] = "Please input commodity name/code ?";
	msgs['JOO00068'] = "Please input 'Item Amount'.";
	msgs['JOO00069'] = "Item amount must be over zero, if something is positive.";
	msgs['JOO00070'] = "Item amount must be below zero, if something is negative.";
	msgs['JOO00071'] = "'The exchange rate x USD amount is different from the current KRW amount.  To process, please click the 'OK' button.  If not, click the 'Cancel' button.";
 	msgs['JOO00072'] = "Please select CSR No. to view detail.";
	msgs['JOO00073'] = "There is no CSR information to view in detail.";
	msgs['JOO00074'] = "The CSR No. is missing.";
	msgs['JOO00075'] = "Please input full CSR No. (length 19~20).";
	msgs['JOO00076'] = "Please input a condition either CSR No. or Issue Date.";
	msgs['JOO00077'] = "Please input the reason of cancel.";
	msgs['JOO00078'] = "'To date' must be later than 'From date'.";
	msgs['JOO00079'] = "Please click 'row delete' button, after 1 or more checked rows.";
	msgs['JOO00080'] = "'To port' must be different from 'From port'.";
	msgs['JOO00081'] = "There is the same pair(VVD, From-To port).";
	msgs['JOO00082'] = "There is no data In Financial Matrix. Insert the Financial Matrix data at first'";
	msgs['JOO00083'] = "There is no data in basic port.  Please insert the basic port data at first.";
	msgs['JOO00084'] = "[{?msg1}] Please select a R/T/U.";
	msgs['JOO00085'] = "[{?msg1}] Please select a Inter Port/Ocean.";
	msgs['JOO00086'] = "[{?msg1}] Please select a RGN.";
	msgs['JOO00087'] = "[{?msg1}] Please select a POL.";
	msgs['JOO00088'] = "[{?msg1}] Please select a POD.";
	msgs['JOO00089'] = "Please input a right Year-Month (YYYY-MM).";
	msgs['JOO00090'] = "The period must be within 6 months.";
	msgs['JOO00091'] = "The period must be before Account month.";
	msgs['JOO00092'] = "Please select a combined No.";
	msgs['JOO00093'] = "There is no data to delete.";
	msgs['JOO00094'] = "If you want to save, Please remove combined No. at first.";
	msgs['JOO00095'] = "Unable to remove the data because it has a slip no.";
	msgs['JOO00096'] = "Please select the combined number.";
	msgs['JOO00097'] = "Please input  description.";
	msgs['JOO00098'] = "Please select Evidence Class.";
	msgs['JOO00099'] = "Please select Evidence Type.";
	msgs['JOO00100'] = "It was already settled.";
	msgs['JOO00101'] = "Please input  Eff.Date.";
	msgs['JOO00102'] = "Please input  Due Date.";
	msgs['JOO00103'] = "{?msg1} are cancelled VVD.  Do you want to keep on going ?";
	msgs['JOO00104'] = "Please retrieve at first !";
	msgs['JOO00105'] = "You can input an evidence when Evidence Class is Value Added Tax.";
	msgs['JOO00106'] = "Please input evidence.";
	msgs['JOO00107'] = "The month of Eff. Date [{?msg1}] was closed. \nDo you want to replace the Eff. Date with opened month's 1st date [{?msg2}]?";
	msgs['JOO00108'] = "Amount is not a number.";
	msgs['JOO00109'] = "Service Provider code is empty.";
	msgs['JOO00110'] = "Please check Lane code.";
	msgs['JOO00111'] = "Please select  Lane code.";
	msgs['JOO00112'] = "Please input  Office code";
    msgs['JOO00113'] = "Please select  Item type code.";
	msgs['JOO00114'] = "[{?msg1}] Please input currency.";
	msgs['JOO00115'] = "Please select  {?msg1}.";
	msgs['JOO00116'] = "Please input {?msg1}.";
    msgs['JOO00117'] = "Please check {?msg1}.";
	msgs['JOO00118'] = "You must save it before sending.";
	msgs['JOO00119'] = "It doesn't have any evidence.";
	msgs['JOO00120'] = "This Combined data has been reversed !";
	msgs['JOO00121'] = "This Combined data can't be reversed because its evidence type is 'TAX'.";
	msgs['JOO00122'] = "This Combined data was canceled.";
	msgs['JOO00123'] = "Are you sure to reverse it ?";
    msgs['JOO00124'] = "You must save it before printing.";
	msgs['JOO00125'] = "There doesn't exist month {?msg1} in AP_PERIOD.";
	msgs['JOO00126'] = "This combined data can't be reversed because the month of Eff. Date is closed.";
	msgs['JOO00127'] = "The necessary condition to send into ERP is only Execute Month.\nPlease deselect other conditions.";
	msgs['JOO00128'] = "You can send data into ERP after saving changes.";
	msgs['JOO00129'] = "Are you sure to send the retrieved data into ERP ?";
	msgs['JOO00130'] = "The estimate year should be equal to or greater than target VVD year.";	      
    msgs['JOO00131'] = "Total amount value is not found.";   
    msgs['JOO00132'] = "Data is duplicated ![{?msg1}]  Do you want to save without checking duplicated data ?";       
    msgs['JOO00133'] = "Please select settlement option.";
    msgs['JOO00134'] = "[{?msg1}] is more than 4000 bytes !";
    msgs['JOO00135'] = 'Do you want to delete {?msg1}?';
    msgs['JOO00136'] = "{?msg1} code is invalid !";
    msgs['JOO00137'] = "The Center Code ({?msg1})  in Financial Matrix is different from MDM's({?msg2}).";
    msgs['JOO00138'] = "The Location Code ({?msg1})  in Financial Matrix is different from MDM's({?msg2}).";
    msgs['JOO00139'] = "[{?msg1}] is closed month.  And it doesn't exist open month after the month.";
    msgs['JOO00140'] = "Two or more un-closed month exist ! Do you want ignore it ?";
    msgs['JOO00141'] = "No data found in 'Target VVD'.";
    msgs['JOO00142'] = "Two or more data in 'Target VVD'.";
    msgs['JOO00143'] = "There is no data !";
    msgs['JOO00144'] = "There is too many data.";
    msgs['JOO00145'] = "Data is duplicated !\nDo you want to update the old data ?"; 
    msgs['JOO00146'] = "Carrier-Trade-Lane is invalid !";
	msgs['JOO00147'] = "Service Provider Code (999999) is invalid !";
	msgs['JOO00148'] = "{?msg1} do(es) not have 'Revenue Year Month'.";
	msgs['JOO00149'] = "The settlement option of the lane is not 'Cycle'";
	msgs['JOO00150'] = "You can't press 'Create' button because the settlement option of the lane is 'Cycle'";
	msgs['JOO00151'] = "Fail to execute.";
	msgs['JOO00152'] = "Read result file aleady";
	msgs['JOO00153'] = "You can make 'Reverse Slip' after approval.";
	msgs['JOO00154'] = "Please input 'Unit Cost Basic Port Etd Date' at first.";
	msgs['JOO00155'] = "Please input 'Inter/Ocean' at first.";
	msgs['JOO00156'] = "Please input 'RGN' at first.";
    msgs['JOO00157'] = "There exists a same data\nDo you want to ignore the duplication?";
	msgs['JOO00158'] = "[{?msg1}] Please select 'BSA Type'.";
	msgs['JOO00159'] = "Please input 'From Port' at first.";
	msgs['JOO00160'] = "Success to execute";
	msgs['JOO00161'] = "There is duplicated data.";
	msgs['JOO00162'] = "Settlement Item [{?msg1}] do(es) not exist in 'Financial Matrix'.";
    msgs['JOO00163'] = "The Center Code in Financial Matrix is different from MDM's";
    msgs['JOO00164'] = "The Location Code in Financial Matrix is different from MDM's";
	msgs['JOO00165'] = "Please click the row that you want to reject.";
	msgs['JOO00166'] = "Are you sure to reject it?";
	msgs['JOO00167'] = "Please input a condition either 'Effective Date' or 'CSR No.'";
	msgs['JOO00168'] = "Please input both 'from date' and 'to date'";
	msgs['JOO00169'] = "Please retrieve at first.";
	msgs['JOO00170'] = "This csr data can't be approved because the month of Eff. Date is closed.";
	msgs['JOO00171'] = "Please select RDR/TDR.";
	msgs['JOO00172'] = "In creation mode...Please retrive at first.";
	msgs['JOO00173'] = "Can not retrieve 'R/F Surcharge' because it does not have 'Unit Cost Basic Port Etd Date'.";
	msgs['JOO00174'] = "Please, set the approval step.";
	msgs['JOO00175'] = "There is no need to create basic-port data if its settlement option is 'Cycle'.";
	msgs['JOO00176'] = "'Eff.Date' must be earlier than 'DUE Date'";
	msgs['JOO00177'] = "It was closed!!!";
	msgs['JOO00178'] = "Please, select tax invoice type.";
	msgs['JOO00179'] = "Please check CSR  I/F Status.";
	msgs['JOO00180'] = "Please check 'BSA Type'";
	msgs['JOO00181'] = "Do you want to delete the data of no value before saving?";
	msgs['JOO00182'] = "{?msg1} is pending case.";
	msgs['JOO00183'] = "Can not remove the selected data because there exists combined data.";
	msgs['JOO00184'] = "Please select 'Rev/Exp'.";
	msgs['JOO00185'] = "Please select 'Source'.";
	msgs['JOO00186'] = "Please select 'Booking Type'.";
	msgs['JOO00187'] = "Please input {?msg1} date.";
	msgs['JOO00188'] = "There is(are) {?msg1} same period data.\n\nIf you want to input new period, press 'OK' button,\notherwise press 'CANCEL' button and choose a 'Reference Number'.";
	msgs['JOO00189'] = "Please check VVD code.";
	msgs['JOO00190'] = "Please select 'Direction code'.";
	msgs['JOO00191'] = "There is same Carrier information.\nPlease select the other Carrier.";
	msgs['JOO00192'] = "Please save it before opening 'Add Carrier' Pop-up.";
	msgs['JOO00193'] = "This Carrier doesn’t exist in MDM. Do you want to use this Carrier?";
	msgs['JOO00194'] = "You should input exactly 3 characters.";
	msgs['JOO00195'] = "You should select one rep. carrier in ‘Sub Allocation and Ratio’.";
	msgs['JOO00196'] = "Please select 'Vessel code'.";
	msgs['JOO00197'] = "Please select 'Port code'.";
	msgs['JOO00198'] = "Please input 'Port Seq'.";
	msgs['JOO00199'] = "Vessel Code is invalid !";
	msgs['JOO00200'] = "Port is invalid!";
	msgs['JOO00201'] = "Please input End VVD(Vessel)";	
	msgs['JOO00202'] = "Please input End VVD(Voyage)";
	msgs['JOO00203'] = "Please input End VVD(Direction)";
	msgs['JOO00204'] = "Please input End Port";	
	msgs['JOO00205'] = "Some necessary items for RDR creation were not inserted. Please recheck and save again.";
	msgs['JOO00206'] = "End VVD and Port has not been inserted. Please recheck this.";
	msgs['JOO00207'] = "Please input Carrier or BSA.";
	msgs['JOO00208'] = "Please recheck the Port Code, it should be 5digit.";
	msgs['JOO00209'] = "It can not be deleted because RDR Finish or Delete Mark is Y.";
	msgs['JOO00210'] = "The length of {?msg1} is {?msg2} characters only.";
	msgs['JOO00211'] = 'There is no CSR No.' ;
	msgs['JOO00212'] = "Do you want to create an estimated target?";
	msgs['JOO00213'] = "Do you want to retrieve an estimated target?";
	msgs['JOO00214'] = "You have just selected the number of page beyond that of total pages.";	
	msgs['JOO00215'] = "Item Code is Wrong. Please check it again!";
	msgs['JOO00216'] = "{?msg1} are cancelled VVD.";
	msgs['JOO00217'] = "Do you want to continue?";
	
    /**
	 * radio 의 값을 return한다.
	 * @param radioObj
	 * @return
	 */
	function JooGetRadioValue(radioObj){
		var val = "";
		for(var i=0; i<radioObj.length; i++){
			if (radioObj[i].checked){
				val = radioObj[i].value;
				break;
			}
		}
		return val;
	}	

    /**
	 * radio 의 값을 Setting한다.
	 * @param radioObj
	 * @return
	 */
	function JooSetRadioValue(radioObj, val){
		for(var i=0; i<radioObj.length; i++){
			if (radioObj[i].value == val){
				radioObj[i].checked = true;
				break;
			}
		}
		radioObj.value = val;
	}	

	function JooSetRadioDisabled(radioObj, bol){
		for(var i=0; i<radioObj.length; i++){
			radioObj[i].disabled = bol;
		}
	}	
	
	/**
	 * del_chk 를 check 하고 Row Delete를 안 한 것이 있으면 true
	 * @param sheetObj
	 * @param prefix
	 * @return
	 */
	function existsUnDelRows(sheetObj, prefix){
		var rtnValue = false;
		var checkedRows = (sheetObj.FindCheckedRow(prefix+"del_chk")).split("|");
		
		if (checkedRows == "") 
			return rtnValue;
		
		var stat = "";

		for(var i=0; i < checkedRows.length-1; i++){
			stat = sheetObj.RowStatus(checkedRows[i]);

			if ((stat == "I" || stat == "U") && (sheetObj.RowHidden(checkedRows[i]) == false)){
				rtnValue = true;
				break;
			}
		}
		return rtnValue;
	}
	
	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function addComboItem(comboObj, comboItems) {
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(",");
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
		}   		
	}	

	/**
	 * 콤보필드에 데이터를 추가해준다.
	 */	
	function UF_addComboItem(comboObj, comboItems) {
		for (var i = 0 ; i < comboItems.length ; i++) {
			var comboItem = comboItems[i].split(",");
			comboObj.InsertItem(i, comboItem[0], comboItem[1]);
		}   		
	}	
	/**
      *  Xml에서 데이타 가져오기 
      *    savename 복수일경우 | 사용.
      * @param xmlStr
      * @param savename
      * @return value   ex)복수시 리턴값  aaa|dddd
      * @author jkc
      */
     function ComJooGetRowValue(xmlStr, cRow, savename)  {
         if (xmlStr == null || xmlStr == ""  ) {
              return;
         }
         if (savename  == null || savename == ""  ) {
             return;
         }
         try {
               var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
               xmlDoc.loadXML(xmlStr);

               var xmlRoot = xmlDoc.documentElement;
               if (xmlRoot == null) {
                       return;
               }

               var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
 
               if (dataNode == null || dataNode.attributes.length < 3) {
                       return "";
               }
               var TOTAL_ROWS = eval( dataNode.getAttribute("TOTAL") );
 
               if( TOTAL_ROWS == "0" ){
                   return "";
               }
               var col = dataNode.getAttribute("COLORDER");
 
               var colArr = col.split("|");
 
               var sep = dataNode.getAttribute("COLSEPARATOR");
               var dataChildNodes = dataNode.childNodes;
               if (dataChildNodes == null) {
                   return;
               }
 
               var colListIdx = Array();
               var arrText = savename.split("|");

               for (var i = 0; i < colArr.length; i++) {
                   for (var j = 0; j < arrText.length; j++) {
                       if ( colArr[i] == arrText[j] && colArr[i] != "" ) {
                               colListIdx[j] = i;
                       }
                   }
               }

               if(  cRow   >  TOTAL_ROWS ){
                   return "";
               }
               var arrData = dataChildNodes[cRow-1].firstChild.nodeValue.split(sep);
 
               var trData = "";
               for (var j = 0; j < colListIdx.length; j++) {
                   if( j < colListIdx.length-1){
                       trData += arrData[colListIdx[j]]+"|";
                   }else{
                       trData += arrData[colListIdx[j]];   
                   }
                   
               }
               return trData;
         } catch (err) {
                ComFuncErrMsg(err.message);
        }       

   }

    
     /**
      * 월 증감 버튼 클릭시...
      * @param obj
      * @param iMonth
      * @return
      */
     function UF_addMonth(obj, iMonth){
    	 if (obj.value != "") {
			 obj.value = ComGetDateAdd(obj.value+"-01", "M", iMonth).substring(0, 7);
    	 }
     }
      /**
       *  sXml에서 MESSAGE 내용을 추출 
       * @param sXml
       * @return Sring MESSAGE
       * @author jkc
       */
      function ComJooGetMessageFromXml(sXml){
         if ( sXml == null  || sXml == "" ) return;

         try {
             var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
             xmlDoc.loadXML(sXml);

             var xmlRoot = xmlDoc.documentElement;
             if(xmlRoot == null) return;
    
             var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
 
             if(msgNode == null) return "";

             return msgNode.firstChild.nodeValue;
         } catch(err) { ComFuncErrMsg(err.message); }
     }      
       
      
      /**
       * code1|code2|...와 name1|name2|...를 합하여 code1\tname1|code2\tname2|...형태로 return한다.
       * @param code
       * @param name
       * @return
       */
      function UF_getComboStringForSheet(code, name){

    	  var codeArr = code.split("|");
    	  var nameArr = name.split("|");
    	  
    	  if (codeArr.length == 0) return "";
    	  
    	  var cnt = codeArr.length;
    	  
    	  //둘중 짧은걸로 한다.
    	  if (codeArr.length > nameArr.length)
    		  cnt = nameArr.length;
    	  
    	  var rtnString ="";
    	  
    	  for (var inx=0; inx < cnt; inx++){
    		  if (inx==cnt-1)
    			  rtnString = rtnString+codeArr[inx]+"\t"+nameArr[inx];
    		  else
    			  rtnString = rtnString+codeArr[inx]+"\t"+nameArr[inx]+"|";
    	  }
    	  
    	  return rtnString;
      }
       /**
        * 
        * <pre>
        *    Excel Title 
        * </pre>
        *
        * @param   sheetObj
        * @param   paramObj
        *          - Attribute : title         : 제목명          (default : 화면제목명);
        *                      : align         : Title 가로 정렬 {"center", "left", "right"}, (default:center)
        *                      : cols          : 타이틀 칼럼수   (default : Sheet Cols수(단, hidden Type 제외 )
        *                      : orientation   : 용지방향        {Landscape,Portrait}(default : Landscape )
        *                      : columnwidth   : 특정 Col Width  (default : 자동) ex)지정필요시, 3 col 30, 4 col 50 일때, 3:30|4:50 
        *                      : datarowheight : 특정 Row Height (default : 20) ex)지정필요시, 3 Row 30, 4 Row 50 일때, 3:30|4:50
        *                                        양식 타이틀이 아닌, 그리드 타이틀부터 1, ex2)그리드 타이틀 row Height을 50으로 변경시
        *                                        paramObj.datarowheight="1:50"
        * @author jang kang cheol
        */
        function ComJooGetPgmTitle(sheetObj, paramObj){
           var doc   = document.all;
           var pageUrl = "FNS_JOO_EXCEL.do?";
           
           /*************************** 제목처리 **********************************/
           var sTitle = "";
           /*************************** 정렬처리 **********************************/
           var sTalign = "center,left,right";
           var sAlign = "";
           /*************************** Col수 처리 **********************************/
           var sCols  = "";
           var iCols = 0;
           /*************************** 용지방향 처리 **********************************/        
           var sOrientation = "";

           /*************************** 특정지정 컬럼들 width 처리 **********************************/        
           var sColumnwidth = "";

           /*************************** 특정지정 Row 들 Height 처리 **********************************/        
           var sDatarowheight = "";
           
           
           if(paramObj.title == undefined ){
               sTitle     = doc.title.innerHTML.replace("&nbsp;","");
               sTitle     = sTitle.replace("&amp;"," ");
           }else{
               sTitle     = paramObj.title;
           }
           if(paramObj.align == undefined ){
               sAlign="center"; 
           }else if(sTalign.indexOf(paramObj.align) == -1 ){
               sAlign = "left";
           }else{
               sAlign = paramObj.align;
           }
           if(paramObj.cols == undefined ){
               for(var i=0; i<= sheetObj.LastCol; i++){
                   if ( sheetObj.ReadDataProperty(0, i, dpDataType) != dtHidden 
                        && 
                        sheetObj.ReadDataProperty(0, i, dpDataType) != dtHiddenStatus
                      ){
                       iCols++;
                   }
               }
           }else{
               iCols = eval(paramObj.cols);
           }
    
           if(paramObj.orientation == undefined ){
               sOrientation = "Landscape";
           }else{
               sOrientation = paramObj.orientation;
           }
           
           if(paramObj.columnwidth == undefined ){
               sColumnwidth = "";
           }else{
               sColumnwidth = paramObj.columnwidth;
           }
           
           if(paramObj.datarowheight == undefined ){
               sDatarowheight = "";
           }else{
               sDatarowheight = paramObj.datarowheight;
           }        
    
           var sUrl = pageUrl+"title="+sTitle+"&align="+sAlign+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
           return sUrl;
       }
        /**
         *  Xml Tran 결과 조회 
         * @param xmlStr
         * @param savename
         * @return value    
         * @author jkc
         */
         function ComJooGetTrAllValue(sXml){
           if ( sXml == null  || sXml == "" ) return;

           try {
               var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
               xmlDoc.loadXML(sXml);

               var xmlRoot = xmlDoc.documentElement;
               if(xmlRoot == null) return;

               var msgNode = xmlRoot.getElementsByTagName("TR-ALL").item(0);
             
               if(msgNode == null) return "";

               return msgNode.firstChild.nodeValue;
           } catch(err) { ComFuncErrMsg(err.message); }
       }
         

         /**
          * Radio의 Disabled
          * @param radioObj
          * @param aBoolean
          * @return
          */
         function ComJooRadioDisabled(radioObj, aBoolean){
        		for(var i=0; i<radioObj.length; i++){ 
    				radioObj[i].disabled = aBoolean;
        		}
         }	
         
 /**
 * 빠른 처리
 * @param sheetObj
 * @param TrimComma
 * @param Status
 * @return
 */
function ComJooGetAllSaveText(sheetObj, TrimComma, Status) {
	if (TrimComma == undefined || TrimComma == null)
		TrimComma = false;

	if (Status == undefined || Status == null)
		Status = "ibflag";

	var arrSave = new Array();

	for ( var i = 0; i <= sheetObj.LastCol; i++) {
		arrSave[i] = sheetObj.ColSaveName(i);
	}

	var str = sheetObj.GetRangeText(sheetObj.HeaderRows, 0, sheetObj.LastRow,
			sheetObj.LastCol, "|", "^");

	if (TrimComma)
		str = str.replace(/\,/gi, "");

	var arrStr = str.split("^");

	for ( var i = 0 in arrStr) {
		var arrCol = arrStr[i].split("|");
		for ( var j = 0 in arrCol) {
			if (arrSave[j] == Status) {
				switch (arrCol[j]) {
				case "INS":
					arrCol[j] = "I";
					break;
				case "UPD":
					arrCol[j] = "U";
					break;
				case "DEL":
					arrCol[j] = "D";
					break;
				default:
					arrCol[j] = "R";
					break;
				}
			}

			arrCol[j] = arrSave[j] + "=" + arrCol[j];
		}

		arrStr[i] = arrCol.join("&");
	}

	return arrStr.join("&");
}

function JooRowHideDelete(sheetObj, col, isMsg) {
	    if (isMsg==undefined || isMsg==null) isMsg = true;
	var org_col = col;
	//컬럼Index가 아닌 경우 SaveName인 경우 -> 컬럼Index를 가져온다.
	col = ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
	
	//컬럼 인자의 유효성 확인하기
	if (col< 0 || col > sheetObj.LastCol) {
		ComShowMessage("[JooRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' 컬럼은 존재하지 않습니다.");
		return -1;
	}
	//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
	var sRow = sheetObj.FindCheckedRow(col);

	if (sRow == "") {
		if(isMsg) ComShowCodeMessage("COM12189");
		return 0;
	}
	
	//가져온 행을 배열로 만들기 
	var arrRow = sRow.split("|"); //결과 : "1|3|5|"
	
	sheetObj.RedrawSum = false;	//합계 계산하지 않기, dtAutoSumEx가 있는 경우를 대비

	//기준컬럼의 DataType이 dtDelCheck이면 그냥 숨기기만하고, dtDelCheck가 아닌 경우만 숨기고, 트랜잭션 바꾼다.
	if (sheetObj.ReadDataProperty(0, col, dpDataType) == dtDelCheck) {
		//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row = arrRow[idx];
			sheetObj.RowHidden(row)= true;		//2.행 숨기기
		}
	} else {
		//역순으로 삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로 반드시 역순으로 처리한다.)
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row = arrRow[idx];
			//Insert인 경우 삭제하면 아예 삭제
			if (sheetObj.RowStatus(row) == "I"){
				sheetObj.RowDelete(row, false);	//1.삭제
			}else{
				sheetObj.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
				sheetObj.RowHidden(row)= true;		//2.행 숨기기
				sheetObj.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			}
		}
	}

	sheetObj.RedrawSum = true;	//합계 계산하기
	
	return arrRow.length-1;
}

/**
 * Button클릭 했을 경우 클릭이 작동할지 안할지를 Class로 판단하여 return한다.
 * @param srcName
 * @return
 */
function JooBtnClickEnable(srcName) {
	var docObj = eval("document.all." + srcName);

	var aBol = true;
	if (docObj.id == undefined ){
		aBol = false;
	}else{
		if (docObj.id.indexOf("btn") > -1) {
			//class 명에 "_1" 이 붙으면 click 하지 않은 것처럼 처리한다.
			aBol = !(docObj.className.indexOf("_1") > -1);
		}
	}
	return aBol;
}

/**
 * button의 auth에 따라 class를 다르게 한다.
 * @param auth
 * @param editable
 * @return
 */
function JooSetBtnClass(auth, editable) {
	var doc = document.all;
	var className = "";
	//editable 하지 않으면 btn1_1, btn2_1 등 _1 이 붙는다.
	if (!editable) {
		className = "_1";
	}

	for ( var i = 0; i < doc.length; i++) {
		if (doc[i].id.indexOf("btn") > -1) {
			if (doc[i].getAttribute("auth") != undefined) {
				var btnName   = doc[i].className.substring(0,4);

				if (doc[i].getAttribute("auth") == auth) {
					doc[i].className = btnName+className;
				}
			}
		}
	}
}

	
	/**
	 * 조회결과 xml을 입력받아 Array 로 반환
	 * js sample)
	 * var sXml = sheetObj.GetSearchXml("JOOCommonGS.do","",FormQueryString(formObj),true);
	 * var arrResult = MnrXmlToArray(sXml);
	 *
	 * if(arrResult != null){
	 * 	formObj.fm_warr_dt.value = "Fm " +  arrResult[0][5];
	 * 	formObj.to_warr_dt.value = "To " +  arrResult[0][0];
	 * 	formObj.eq_mkr_nm.value = arrResult[0][2];
	 * 	formObj.eq_mdl_nm.value = arrResult[0][4];
	 * 	formObj.warr_rmk.value = arrResult[0][3];
	 * }
	 * </pre>
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
	 * @see 	#ComXml2ComboString
	 * @author 김영오
	 * @version 2012.02.28
	 */
	function JooXmlToArray(xmlStr) {
		var rtnArr = new Array();
	
		if (xmlStr == null || xmlStr == "") {
			return;
		}
	
		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);
	
			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}
	
			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
	
			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");
	
			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
	
			var retStr = "";
	
			for ( var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				rtnArr.push(arrData);
			}
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	
		return rtnArr;
	}