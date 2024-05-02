/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0054_2.js
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0054_2 : esm_fms_0054_2 definition of biz script for creation screen
     */
//    function esm_fms_0054_2() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    //no support[check again]CLT 	this.sheet1_OnLoadFinish=sheet1_OnLoadFinish;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
	//  common global variables 
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
       var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
          	switch(srcName) {
            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					ComResetAll();
					inputReadOnly("New");
                break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;
				case "btn_savetofile":
					if(sheetObject.RowCount() < 1){//no data	
						ComShowCodeMessage("COM132501");
					}else{	
						sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
					}	
                break;
				case "btn_add":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, "dck_fm_dt");
					sheetObject.SetCellValue(row, "dck_dur_dys_days","Days");
					sheetObject.SetCellValue(row,"vsl_cd",formObject.vsl_cd.value);
					sheetObject.SetCellValue(row,"dck_sel_cd",formObject.dck_sel_cd.value);
                break;
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					var row=sheetObject.DataInsert();
					sheetObject.SelectCell(row, "dck_fm_dt");
					sheetObject.SetCellValue(row, "dck_dur_dys_days","Days");
					sheetObject.SetCellValue(row,"vsl_cd",formObject.vsl_cd.value);
					sheetObject.SetCellValue(row,"dck_sel_cd",formObject.dck_sel_cd.value);
					break;
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
                break;
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0022");
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
	 * Insering Vessel Code<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			
	}
    /**
     * Only insert English/Numeric by eng_keypress Event of HTML Control <br>
     **/
//    function eng_keypress() {
//        ComKeyOnlyAlphabet('upper');
//    }
     /**
      * Only insert English/Numeric by engnum_keypress Event of HTML Control <br>
      **/
//     function engnum_keypress() {
//         ComKeyOnlyAlphabet('uppernum');
//     }
    /**
     * Getting Name when changing VslCd <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value="";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }
    /**
    * Registering IBSheet Object as Array
    * In case there is needs to do batch processing, process saving as Array can be added
    * defining array on the top of source
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
        initControl();
        sheet1_OnLoadFinish(sheet1);
        $("#vsl_cd").blur(function(){
        	vsl_cd_change();
        });
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Adding first-served function
     */
	function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
		sheetObj.SetWaitImageVisible(1);
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="/";
        //Axon Event Handling1. Event catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- Code handling to OnBeforeDeactivate(blur) Event of All Controls
//        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- Code handling to onkeypress Event of All Controls having dateformat attribute
//        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Input only Upper case English when inserting Veesel Code
//        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Getting Name information after inserting Vessel Code
        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
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
            case 1:     //sheet1 init
                with(sheetObj){
					var HeadTitle="|Sel|Seq|From D/Dock Date|To D/Dock Date|Duration|Duration|Class Recommendation Type";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					{Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
					{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
					{Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"dck_fm_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"dck_to_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dck_dur_dys",          KeyField:1,   CalcLogic:"sheet_dateDiff(|dck_fm_dt|, |dck_to_dt|)",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dck_dur_dys_days",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Combo",     Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"flet_dck_svey_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dck_sel_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dck_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"flet_dck_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 } ];
					
					InitColumns(cols);
					SetEditable(1);
//					SetSheetHeight(440);  
					resizeSheet();
				}
             break;
        }
    }
    // Handling Sheet Process
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value=SEARCH;
	        		sheetObj.DoSearch("ESM_FMS_0054_2GS.do", FormQueryString(formObj) );
	  	   	  		inputReadOnly("Search");
	  	   	  	}	
                break;
           	case IBSAVE:        
	 			if(!validateForm(sheetObj,formObj,sAction),true,true,false)return;
	 			formObj.f_cmd.value=MULTI;
	 			sheetObj.DoSave("ESM_FMS_0054_2GS.do", FormQueryString(formObj));
                break;
			case IBROWSEARCH:   
				if (Col == "ComCd") {//Status, Dry Dock Type
					formObj.f_cmd.value=SEARCH02;
		   			var param="&cd_id=CD01748"+"&com_code=flet_dck_svey_tp_cd"
		   						+"&com_text=flet_dck_svey_tp_cdText";
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0006GS.do" , FormQueryString(formObj)+param);
	    			setMakeCombo(sheetObj, ComGetEtcData(sXml, "flet_dck_svey_tp_cdText"), ComGetEtcData(sXml, "flet_dck_svey_tp_cd"), "flet_dck_svey_tp_cd");
	    		} else if (Col == "vsl_cd") {
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
				}	
        }
    }
    /**
     * Making Type Combo Box <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboCode   Code value of Type
     * @param {String}  comboText   Name of Type
     * @param {String}  col   		column name
     **/
    function setMakeCombo(sheetObj, comboText, comboCode, Col) {
		if(typeof comboCode != "undefined" && comboCode != "") {
        	sheetObj.SetColProperty(Col, {ComboText:comboText.substring(0 ,comboText.length-1), ComboCode:comboCode.substring(0,comboCode.length-1)} );
    	}
    }
    /**
     * Screen handling by Event <br>
     * @param {String} flag     	Event separator
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
	    	form.vsl_cd.readOnly=false;
//	    	document.images["btn_vslpop"].name="btn_vslpop";
	    	form.btn_vslpop.name="btn_vslpop";
	    	form.btn_vslpop.style.cursor="hand";
    	} else {
	    	if(sheetObjects[0].RowCount()== 1 || flag == "Search") {
		    	form.vsl_cd.readOnly=true;
//		    	document.images["btn_vslpop"].name="no_btn_vslpop";
		    	form.btn_vslpop.name="no_btn_vslpop";
		    	form.btn_vslpop.style.cursor="default";
	    	}
    	}
    }
     /**
      * In case input value is changed
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value) {
 			if (sheetObj.ColSaveName(Col) == "dck_fm_dt") {
 				if (sheetObj.GetCellValue(Row, "dck_to_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "dck_to_dt") < Value) {
 						ComShowCodeMessage("FMS01709");
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			} else if (sheetObj.ColSaveName(Col) == "dck_to_dt") {
 				if (sheetObj.GetCellValue(Row, "dck_fm_dt") != '') {
 					if (sheetObj.GetCellValue(Row, "dck_fm_dt") > Value) {
 						ComShowCodeMessage("FMS01711");
 						sheetObj.SetCellValue(Row, Col,'',0);
 						sheetObj.SelectCell(Row, Col);
 					}
 				}
 			}
	}
    /**
     * Handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
        return true;
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    