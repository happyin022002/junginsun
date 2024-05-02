/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0022.js
*@FileTitle  : Vessel Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
/****************************************************************************************
 event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
     * @extends 
     * @class ESM_FMS_0022 : ESM_FMS_0022 definition of biz script for creation screen
     */
    // common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		//ComDebug(srcName);
            switch(srcName) {
            	case "btn_crr_cd":
            		ComOpenPopup("ESM_FMS_0077.do", 528, 430, "setCrrCd", "1,0,1,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0077");
            		break;
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btn_confirm":
                	comPopupOK();
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
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
					var HeadTitle="||Vessel\nCode|Vessel Name|Carrier|Vessel\nType|Trunk On\nOff  ";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"radio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:66,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"vsl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:66,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:66,   Align:"Center",  ColMerge:0,   SaveName:"vsl_type",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:66,   Align:"Center",  ColMerge:0,   SaveName:"fdr_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(250);
					SetEditable(1);
                }
                break;
        }
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     * @param {String}  gubun     	gubun value
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:  
        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value=SEARCH;
        			sheetObj.DoSearch("ESM_FMS_0022GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("") );
       	   	   	}
       		   	break;
        	case IBROWSEARCH:      
        		formObj.f_cmd.value=SEARCH08;
        		var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
   				var crrCd=ComGetEtcData(sXml, "crrCd");
	   			if(typeof crrCd != "undefined" && crrCd != "" ) {
					formObj.crr_cd.value=crrCd;
				} else {
					formObj.crr_cd.value="";
					ComAlertFocus(formObj.crr_cd, ComGetMsg('FMS01092'));
					return;
				}
        		break;
        }
    }
    /**
 	 * Insert setCrrCd(Carrier Code)<br>
 	 * @param {arry} aryPopupData
 	 */
    function setCrrCd(aryPopupData) {
    	form.crr_cd.value=aryPopupData[0][3];
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	mandatory html form object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj Input Value
     * @return {boolean} bool <br>
	 *          true  : Valid<br>
	 *          false : inValid
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
    	if(    formObj.vsl_cd.value.length < 1
    		&& formObj.vsl_eng_nm.value.length < 1
    		&& formObj.crr_cd.value.length < 1
    		&& formObj.fdr_div_cd.selectedIndex == 0) {
    		ComShowMessage(ComGetMsg('FMS01091'));
    		return false;
    	}
        return true;
    }
    /**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
        //Axon Event Handling1. event catch
        //axon_event.addListener ('keypress', 'eng_keypress', 'crr_cd');
        //axon_event.addListener ('keypress', 'engnum_keypress', 'vsl_cd');
        //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener  ('blur', 'obj_deactivate',  "crr_cd"); 
    }

    /**
     * Validation of HTML Control will check in the onblur event.<br>
     **/
    function obj_deactivate(){
        //Input Validation to check
    	switch(ComGetEvent("name")){	
	    	case "crr_cd":
	    		if(form.crr_cd.value == "") return;
	    		if(form.crr_cd.value.length < 4) return;
	    		
	    		crr_cd_change();
    			break;
	    	default:
    	}
    }
    /**
     * Checking Information existing when inserting Carrier Code <br>
     **/
    function crr_cd_change() {
    	doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);
    }
    /**
     * Event occurring after completing search by DoSearch<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  	}