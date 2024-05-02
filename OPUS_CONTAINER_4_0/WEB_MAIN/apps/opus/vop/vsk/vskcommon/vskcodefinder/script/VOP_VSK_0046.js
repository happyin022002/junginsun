/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0046.js
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
			  MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
			  Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var bakObj=null;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;  
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObj,IBSEARCH)
					break;
//				case "btn_pop":
//					var landCd = formObj.vsl_slan_cd.value;
//					var sUrl = "/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + landCd;
//        			var rVal = ComOpenPopupWithTarget(sUrl, 422, 490, "sheet1_vsl_slan_cd:vsl_slan_cd", "0,0", true);
//					if(rVal){
//						//formObj.vsl_slan_cd.value = rVal;
//					}
//					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initControl();
        document.form.vsl_slan_cd.focus();
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
                tabIndex=-1;
              
              var HeadTitle1="|Code|Lane Name|Lane Service Type"

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_slan_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vsl_slan_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_svc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(0);
              FitColWidth("20|20|60");
              resizeSheet();
                    }


                break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
        	   sheetObj.SetWaitImageVisible(0);
     		   ComOpenWait(true);
        	   formObj.f_cmd.value=SEARCH;
        	   if(validateForm(sheetObj,formObj,sAction)){
        		   var sParam=FormQueryString(formObj);
        		   sheetObj.DoSearch("VOP_VSK_0046GS.do", sParam );
        	   }
        	   ComOpenWait(false);
        	   //formObj.vsl_slan_cd.focus();
                break;
           case SEARCH01:	// Lane Code Retrieve
        	   formObj.f_cmd.value=SEARCH;
       		   var sParam=FormQueryString(formObj);
       		   var rXml=sheetObj.GetSearchData("VOP_VSK_0046GS.do" , sParam);
       		   var nm=ComGetEtcData(rXml, "vsl_slan_nm");
	       		if(nm!=null){
	       			formObj.vsl_slan_nm.value=nm;
//	       			formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
	       			ComSetNextFocus();
	       		}else{
	       			ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
	       			formObj.vsl_slan_cd.value="";
//	       			formObj.tmp_vsl_slan_cd.value = "";
	       			formObj.vsl_slan_nm.value="";
	       			formObj.vsl_slan_cd.focus();
	       		}
        	   break;
        }
    }
    /**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var vsl_slan_cd=formObj.vsl_slan_cd;
    	var vsl_slan_nm=formObj.vsl_slan_nm;
    	with(formObj){
    		if (ComChkLen(vsl_slan_cd, 1)==1 && ComChkLen(vsl_slan_nm, 1)==1){
    			ComShowCodeMessage("VSK00022", "1", "'Lane Code' or 'Lane Name'");
    			formObj.vsl_slan_cd.focus();
    			return false;
    		}
    	}
        return true;
    }
    /**
     * registering initial event 
     **/
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('blur'   , "obj_deactivate", formObj); //deactivate
	axon_event.addListenerForm('focus'  , 'obj_focus'     , formObj);
	axon_event.addListenerForm('keydown', 'ComKeyEnter'   , formObj);
}
function obj_focus() {
	switch(ComGetEvent("name")){
		case "vsl_slan_cd":
			bakObj=ComGetEvent().value;
			break;
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * Handling focus out event
 */
function obj_deactivate() {
	var formObj=document.form;
	var obj=ComGetEvent();
	switch (ComGetEvent("name")) {
		case "vsl_slan_cd":
			if(obj.value=="" || ComChkLen(obj.value, 3)!=2){
				break;
			}
			if(bakObj != obj.value){
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
			break;
	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}