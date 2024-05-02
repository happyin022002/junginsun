/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0922.js
*@FileTitle  : Office Search(Agent List) Popup Option
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

 /**
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items
  * defining list on the top of source
  */
var sheetObjects=new Array();
var sheetCnt=0;
var prefix="sheet1_";


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
		   // initControl();
		    doActionIBSheet(sheetObjects[0],form,IBSEARCH);
     }
    function initControl() {
    	var formObject=document.form;

    }        
 
	/**
	 * changing 3 at print option number of Sheets of paper<br>
	 **/
   function setPrintcnt(){
   	form.face_print_cnt.options[3].selected=true;
   	form.rider_print_cnt.options[3].selected=true;
   }
// Event handler processing by button click event */
 		document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
	     	try {
	     		var srcName=ComGetEvent("name");
		 			switch(srcName) {
					  case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_copy":
							custPooupOK(formObject);
		 					break;
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
      * handling sheet process
      * @param sheetObj
      * @param formObj
      * @param sAction
      * @return void
      */
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			 			case IBSEARCH:      //retrieve

			 				formObj.f_cmd.value=SEARCH;
							sheetObj.RemoveAll();
							sheetObj.RenderSheet(0);
							sheetObj.SetWaitImageVisible(1);
 							var sXml=sheetObj.GetSearchData("ESM_BKG_0922GS.do", FormQueryString(formObj));
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							sheetObj.SetWaitImageVisible(0);
							sheetObj.RenderSheet(1);
							if(ComGetEtcData(sXml, "eng_nm") == undefined){
								break;
							}
							formObj.eng_nm.value=ComGetEtcData(sXml, "eng_nm");
							formObj.address.value=ComGetEtcData(sXml, "address");
							formObj.country.value=ComGetEtcData(sXml, "country");
							formObj.phone_no.value=ComGetEtcData(sXml, "phone_no");
							formObj.fax_no.value=ComGetEtcData(sXml, "fax_no");
							break;
			    }
     }
	function custPooupOK(formObj) {
		var retStr=formObj.ofc_cd.value	  +"|$$|"
		            + formObj.eng_nm.value	  +"|$$|"
					+	formObj.address.value   +"|$$|"
					+	formObj.country.value	  +"|$$|"
					+	formObj.phone_no.value	+"|$$|"
					+	formObj.fax_no.value;
		if(callbackMethod == null){
			ComClosePopup(); 
		}else{
			callbackMethod(retStr);
			ComClosePopup(); 
		}
	}
	/**
     * handling process for input validation <br>
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
     function validateForm(sheetObj,formObj,sAction){
     	switch(sAction) {
    		case IBSEARCH:
			  	if(formObj.bkg_no.value == "" ){
							ComShowCodeMessage('BKG00626','BKG No.');
							return false;
					}
	  			break;
    		case MODIFY01:
			  	if(formObj.bl_face_prn_dvc_nm.value == "" ){
							ComShowCodeMessage('BKG00626','Print Setup(Face)');
							return false;
					}
	  			break;
    	 	}
            return true;
     }
    function isNullEtcData(xmlStr){
    	var rtn=false;
    	
    	var xmlDoc = ComGetXmlDoc(xmlStr);
    	if (xmlDoc == null) return true;
    	var xmlRoot = xmlDoc.documentElement;
    	
    	var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item[0];
        if(etcDataNode == null) return true;
        var etcNodes=etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn=true;
        return rtn;
    }
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
     function initSheet(sheetObj,sheetNo) {
         switch(sheetObj.id) {
            case "sheet1":
              with(sheetObj){
            	var HeadTitle="|Seq.|Val|Name|Desc";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"val" },
			             {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"name",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(0);
              }
			break;
         }
     }
