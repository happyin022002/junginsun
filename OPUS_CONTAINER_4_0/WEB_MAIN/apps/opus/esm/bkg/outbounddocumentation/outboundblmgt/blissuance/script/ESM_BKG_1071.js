/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1071.js
*@FileTitle  : Multi Fax / E-Mail / EDI Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event  */
document.onclick = processButtonClick;

		// Event handler processing by button name */
		function processButtonClick(){
			try{
				var sheetObject1=sheetObjects[0];
		        var formObject=document.form;
		        var srcName=ComGetEvent("name");
		        switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					case "btn_Close":
						ComClosePopup(); 
						break;
		        } // end switch
			} catch(e){
				ComShowMessage(e.message);
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
	     * adding first-served functions after loading screen
	     */                    
	    function loadPage() {
	    	for (var i=0; i<sheetObjects.length; i++) {
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
	        var sheetID=sheetObj.id;
	        switch(sheetID) {
	            case "sheet1":      //sheet1 init
	            	with(sheetObj){
		            	var HeadTitle1="Sent Result|Sent Result|Sent Result|Sent Result|Sent Result|Freight Option|Freight Option|Freight Option|Freight Option|Freight Option";
		            	var HeadTitle2="Fax / E-mail / EDI|Result|Date|By|Office|A|C|P|N|F";
	
		            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            	var headers = [ { Text:HeadTitle1, Align:"Center"},
		            	                { Text:HeadTitle2, Align:"Center"} ];
		            	InitHeaders(headers, info);
	
		            	var cols = [ {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"fax_eml",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"snd_result",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"snd_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_all_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_ppd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_chg_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					            	 {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_arr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
		            	InitColumns(cols);
		            	SetEditable(0);
		            	SetSheetHeight(342);
	            	}

	                break;
	        }
	    }
		// handling sheet process
	    function doActionIBSheet(sheetObj,formObj,sAction) {
	        sheetObj.ShowDebugMsg(false);
	        switch(sAction) {
	        	case IBSEARCH:
					if (validateForm(sheetObj,formObj,sAction)) {
						if (sheetObj.id == "sheet1") {
							formObj.elements["f_cmd"].value=SEARCH;
	 					    var sXml=sheetObj.GetSearchData("ESM_BKG_1071GS.do", FormQueryString(formObj));
	 					    sheetObj.LoadSearchData(sXml);
							ComEtcDataXmlToForm(sXml, formObj);
						}
					}
	        		break;
	        }
		}
	    /**
	     * handling process for input validation
	     */
	    function validateForm(sheetObj,formObj,sAction){
	        with(formObj){
	        }
	        return true;
	    }
