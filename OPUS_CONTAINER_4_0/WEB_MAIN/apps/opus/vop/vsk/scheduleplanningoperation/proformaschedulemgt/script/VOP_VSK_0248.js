/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0248.js
*@FileTitle  : P/F SKD History Inquiry (Pop-up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/04
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // public variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
 function processButtonClick(){
  var sheetObject1=sheetObjects[0];
  /*******************************************************/
  var formObject=document.form;
try {
	var srcName=ComGetEvent("name");
    if (!ComIsBtnEnable(srcName)) return;  
     switch(srcName) {
		case "btn_close":
  ComClosePopup(); 
			break;
     } // end switch
}catch(e) {
	if( e == "[object Error]") {
		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 }
 /**
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
 function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
 }
 /**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
 function loadPage() {
     for(i=0;i<sheetObjects.length;i++){
    	 ComConfigSheet (sheetObjects[i] );
    	 initSheet(sheetObjects[i],i+1);
    	 ComEndConfigSheet(sheetObjects[i]);
     }
     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
   /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
			var sheetId=sheetObj.id;
     switch(sheetId) {
         case "sheet1":      // sheet1 init
             with(sheetObj){
		          var HeadTitle1="|SEQ|Status|Date|ID|Remark(s)||";
		          var prefix="sheet1_";
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"num",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"history",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				              {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		           
		          InitColumns(cols);
		          SetEditable(0);
		          SetColProperty(prefix+"upd_dt", {Format:"####-##-## ##:##"} );
		          SetWaitImageVisible(0);
		          SetSheetHeight(300);
             }
             break;
         case "sheet2":      // sheet1 init
             with(sheetObj){
		          var HeadTitle1="|Created VVD|Created VVD|Created VVD|Created VVD";
		          var HeadTitle2="|VVD|VVD|VVD|Start Date";
		          var headCount=ComCountHeadTitle(HeadTitle1);
		          var prefix="sheet2_";
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_port_brth_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		           
		          InitColumns(cols);
		          SetEditable(0);
		          SetWaitImageVisible(0);
		          SetSheetHeight(300);
             }
             break;
         }
     }
   // handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
     switch(sAction) {
        case IBSEARCH:      //Retrieve
  		    ComOpenWait(true);
        	formObj.f_cmd.value=SEARCH;
        	var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix string array
         	var sXml=sheetObj.GetSearchData("VOP_VSK_0248GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
        	var arrXml=sXml.split("|$$|");
        	for(var inx=0; inx<arrXml.length; inx++){
				showSheetData(sheetObjects[inx],formObj,arrXml[inx]);
			}
        	ComOpenWait(false);
         break;
     }
 }
 /**
 * process after retrieve.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml,Pos){
	var prefix=sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = ComGetXmlDoc(sXml);
			if (xmlDoc == null) return;
			var dataNode = xmlDoc.documentElement;

			if(dataNode){
				var totValue=dataNode.value;
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(totValue > 0){
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
			}
		break;
		case "sheet2":
			sheetObj.LoadSearchData(sXml,{Sync:1} );
		break;
	}
}