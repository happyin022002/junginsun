/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0306.js
*@FileTitle  : Vessel VVD & Name Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class business script for Vessel VVD & Name Inquiry : Vessel VVD & Name Inquiry 
     */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
     var sheetObject=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
                case "pop_vsl_cd":
					var url="CPS_CNI_0308.do";
					var winName="CPS_CNI_0308";
					var reqWin=openWinCenter(url,winName,800,435);	
		            break;
				case "btn1_Retrieve":
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
		            break;
                case "btn1_New":
					ComResetAll();
                    break; 
				case "btn1_Select":
					sheet1_OnDblClick(sheetObject, sheetObject.GetSelectRow(), 0)
		            break;
				case "btn1_Close":
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
    	form.vvd_cd.focus();
    }
    /**
		 * registering initial event 
     **/
    function initControl() {
    	  axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form);
//        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form);
//    	  axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
//        axon_event.addListener ('keypress', 'obj_keypress' , form);
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//        axon_event.addListener ('keyup', 'obj_keyup' , "vvd_cd");
    }
 	//focus in
 	function obj_activate(){
 		obj=event.srcElement;
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 
    /**
     * checking VVD information
     **/
    function vvd_change() {
    	if (form.vvd_cd.value.trim() != "" && form.vvd_cd.value.trim().length > 3) {
			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vvd_cd');
    	}
    }
    /**
     * checking validation
     **/
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }
    /**
     * only numbers <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.name){
	        case "vvd_cd":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
			default:
		        //only numbers
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    /**
     * setting sheet initial values and header
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
               
	                var HeadTitle1="Seq|VVD|VVD|VVD|Name of Vessel|TOV|TOO|Lane|Built|Flag|Flag|Class|GRT|DWT";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	//                (headCount, 0, 0, true);
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"tov",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vsl_own_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"lnch_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cnt_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"vsl_rgst_cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"blk_vsl_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"grs_rgst_tong_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	                    {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"smr_dwt_wgt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	                SetEditable(0);
	                SetSheetHeight(240);
               }
                break;
        }
    }
    /**
     * Handling sheet's processes
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     **/
    function doActionIBSheet(sheetObj,formObj,sAction, Col) {
        switch(sAction) {
        	case IBSEARCH:
        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value=SEARCH;
         			sheetObj.DoSearch("CPS_CNI_0306GS.do", FormQueryString(formObj) );
        		}
        		break;
        }
    }
	/**
	* input Vessel Code/Name
	* @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	*/
	function setVslCd(vslVo){
		document.form.vvd_cd.value=vslVo.vsl_cd;
		document.form.vsl_eng_nm.value=vslVo.vsl_eng_nm;
	}
	/**
	* The function called when OnDbClick event on Sheet1 triggered 
	* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
	* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
	* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
	*/
	function sheet1_OnDblClick(sheetObj, row, col) {	
		if (row < 1) {
			return;
		}
		var vvdVo={
				vvd_cd:sheetObj.GetCellValue(row , "vsl_cd")+sheetObj.GetCellValue(row , "skd_voy_no")+sheetObj.GetCellValue(row , "skd_dir_cd"),
				vsl_eng_nm:sheetObj.GetCellValue(row , "vsl_eng_nm")
		};
		opener.setVvdCd(vvdVo);
  ComClosePopup(); 
	}
    /**
     * handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	input values sheetObj
     * @return {boolean} true or false
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if (!ComChkValid(formObj)) return false;
			var vvdCd=formObj.vvd_cd.value.trim();
			var vslEngNm=formObj.vsl_eng_nm.value.trim();
			if (vvdCd.length < 4 && vslEngNm.length < 4) {
				ComAlertFocus(formObj.vsl_cd, ComGetMsg("CNI09035"));
				return;
			}
        }
        return true;
    }
    /**
     * The function called when OnSearchEnd event triggered
     * Calling Function in case of OnSearchEnd event <br>
     * After sheet has retrieved, expand the node <br>
     * Expanding nodes after retrieving<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {string} ErrMsg Optional, Message
     * @returns void
     * @author 
     * @version 2009.06.03
     */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComColFontName(sheetObj, "cd_cnt", "Courier New"); 	
	}	
