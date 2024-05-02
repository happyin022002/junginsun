/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0992.js
*@FileTitle  : Pickup No Notice Setup copy Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0992 : business script for ESM_BKG_0992.
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * 
     * @return 
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_Copy":
            	doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;
            case "btn_Close":
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen <br>
     * 
     */
    function loadPage() {
        for(var i=0;i<sheetObjects.length;i++) {
           initSheet(sheetObjects[i],i+1);
        }
   	    initControl();
   	    document.form.ofc_cd.focus();
     }
    /**
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param {IBSheet} sheet_obj 
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering initial event 
     */
    function initControl() {
        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
    }
    /**
     * handling sheet process <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {object}  formObj
     * @param {string}  sAction 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
   		    sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        case IBSAVE:
           	if (validateForm(sheetObj,formObj,sAction) == false) return; 
           	ComOpenWait(true);
           	formObj.f_cmd.value=SEARCH01;
    	        var sXml=sheetObj.GetSearchData("ESM_BKG_0992GS.do", FormQueryString(formObj));
   	        if (ComGetEtcData(sXml, "valid") == "false") {
	        	if (ComShowCodeConfirm("BKG00343") == false) {
	       			ComOpenWait(false);
	        		break;
	        	}
   	        }
            formObj.f_cmd.value=MULTI;
            var sParam=FormQueryString(formObj);
             var sXml=sheetObj.GetSaveData("ESM_BKG_0992GS.do", sParam);
    			sheetObj.LoadSaveData(sXml);
   			ComOpenWait(false);
   			
           	break;
        }
    }
    /**
     * setting sheet initial values and header<br>
     * adding case as numbers of counting sheets <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {number}  sheetNo
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
        // Word Information
        case "sheet1":
            with(sheetObj){
		          var HeadTitle1="status";
		          var headCount=ComCountHeadTitle(HeadTitle1);
		          (headCount, 0, 0, true);
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          SetVisible(false);
                }
        	break;
        }
    }
    /**
     * handling Save complete <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {string}  ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
       	if (ErrMsg == "") {    	
       		var obj=new Object();
       		obj.ofc_cd=document.form.ofc_cd.value;
       		obj.del_cd=document.form.del_cd.value;
       		//window.returnValue=obj;       		
       		ComPopUpReturnValue(obj);
       		ComClosePopup(); 
       	}
    }
    /**
     * handling process for input validation <br>
     * 
     * @param {ibsheet} sheetObj
     * @param {object}  formObj
     * @param {string}  sAction 
     * @return boolean 
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
            switch(sAction) {
     	    case IBSAVE:
         		if (!ComChkValid(formObj)) return false;
         		if ( (fm_ofc_cd.value == ofc_cd.value) && 
         			 (fm_del_cd.value == del_cd.value)){
         			ComShowCodeMessage("BKG00488");
         			return false;
         		}
         		break;
            }
        }
        return true;
    }

    