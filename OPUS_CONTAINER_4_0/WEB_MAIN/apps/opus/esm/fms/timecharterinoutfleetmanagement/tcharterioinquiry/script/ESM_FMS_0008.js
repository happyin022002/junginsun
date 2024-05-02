/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0008.js
*@FileTitle  : Capital Budgeting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
	 	var sheetObject1=sheetObjects[1];
	  	var formObject=document.form;
	 	try {
	 		var srcName=ComGetEvent("name");
	     	switch(srcName) {
	 			case "btn_retrieve":
	 				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	             	break;
	 			case "btn_new":
	 				formReset();
	 				initPeriod();
	             	break;
	 			case "btn_DownExcel":
	 				if(sheetObject.RowCount() < 1){//no data	
	 					ComShowCodeMessage("COM132501");
	 				}else{	
//	 					sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
	 					//sheetObject.Down2Excel({ SheetDesign:1, HiddenColumn:1 });
	 					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
	 				}	
	             	break;
	 			case "btn_print":
	 				rdOpen(document.form);
	             	break;
	 			case "ef_dt": 
					var cal=new ComCalendar();
					cal.select(form.eff_dt, 'yyyy-MM-dd');
					break;
	 			case "ex_dt": 
					var cal=new ComCalendar();
					cal.select(form.exp_dt, 'yyyy-MM-dd');
					break;
	 			case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0022");
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
	 	for(k=0;k<tabObjects.length;k++){
	     	initTab(tabObjects[k],k+1);
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
	 	var sheetID=sheetObj.id;
	 	switch(sheetID) {
	     	case "sheet1":
	     	    with(sheetObj){
			          var HeadTitle1="Installment\nDate|Vessel\nCode|Vessel Full Name|Expense|Expense|Expense|Expense|Revenue|Revenue|Revenue|Revenue";
			          var HeadTitle2="Installment\nDate|Vessel\nCode|Vessel Full Name|Cur 1|Amount|Cur 2|Amount|Cur 1|Amount|Cur 2|Amount";
			          var headCount=ComCountHeadTitle(HeadTitle1);
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
			          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:173,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ti_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:124,  Align:"Right",   ColMerge:0,   SaveName:"ti_inv_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ti_curr_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:124,  Align:"Right",   ColMerge:0,   SaveName:"ti_inv_amt2",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:124,  Align:"Right",   ColMerge:0,   SaveName:"to_inv_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_curr_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:124,  Align:"Right",   ColMerge:0,   SaveName:"to_inv_amt2",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
			           
			          InitColumns(cols);
			          SetEditable(0);
//			          SetSheetHeight(420);
			          SetCountPosition(0);
			          resizeSheet();			          
	                }
	         	break;
	      	case "sheet2":
	      	    with(sheetObj){
		          var HeadTitle1="Installment\nDate|Vessel\nCode|Vessel Full Name|Expense|Expense|Expense|Expense|Revenue|Revenue|Revenue|Revenue";
		          var headCount=ComCountHeadTitle(HeadTitle1);
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
	
		          var cols = [ {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:173,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ti_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:124,  Align:"Right",   ColMerge:0,   SaveName:"ti_inv_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ti_curr_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:124,  Align:"Right",   ColMerge:0,   SaveName:"ti_inv_amt2",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:124,  Align:"Right",   ColMerge:0,   SaveName:"to_inv_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_curr_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:142,  Align:"Right",   ColMerge:0,   SaveName:"to_inv_amt2",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
		           
		          InitColumns(cols);
		          SetSheetHeight(100);
//		          resizeSheet();
		          SetEditable(0);
		          SetRowHidden(0, 1);
		          SetFocusAfterProcess(0);
		          SetCountPosition(0);
		          SetVisible(false);
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
	function doActionIBSheet(sheetObj,formObj,sAction,gubun) {
	 	sheetObj.ShowDebugMsg(false);
	 	switch(sAction) {
	   		case IBSEARCH:     
	   			if(!validateForm(sheetObj,formObj,sAction))  return true;
	   			formObj.f_cmd.value=SEARCH;
	   			var sXml=sheetObj.GetSearchData("ESM_FMS_0008GS.do" , FormQueryString(formObj));
    			var arrXml=sXml.split("|$$|");	
				if (arrXml.length > 0) {
 	   	  			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
 	   	  			sheetObjects[1].RemoveAll();
 	   	  			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:0} );
 	   	  			var total=ComFmsGetAttr(arrXml[1], "DATA", "TOTAL");
// 	   	  			if(total > 0) {
// 	   	  				sheetObjects[1].SetSheetHeight(20 + (total * 20));
// 	   	  			} else {
// 	   	  				sheetObjects[1].SetVisible(false);
// 	   	  			}
 	   	  			sheetObjects[1].SetVisible(total > 0);
 	   	  		} else {
 	   	  			sheetObjects[1].SetVisible(false);
 	   	  		}
				//durationReadonly();
	         	break;
	 		case IBROWSEARCH:     
	 			if(gubun == "Vessel") {
			    	if(formObj.vsl_cd.value == "") {
			    		formObj.vsl_eng_nm.value="";
			    		return;
			    	}
			    	formObj.f_cmd.value=SEARCH01;
			    	var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
		   				//formObj.vsl_cd.readOnly = true;
		   				//formObj.btn_vslpop.style.cursor = "default";
		   				//document.images["btn_vslpop"].name = "no_btn_vslpop";
		   				document.body.focus();
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01056'));
						return;
					}
				}
	 			break;
	 	}
	}
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
    	DATE_SEPARATOR="-";
    	initPeriod()
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form); //- Code handling to OnBeforeDeactivate(blur) Event of All Controls
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- Code Handling to OnBeforeActivate(focus) Event of All Controls having dateformat attribute
    }
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	switch(ComGetEvent("name")){
	    	case "shp_spd_qty": 
	    	case "vsl_dznd_capa": 
	    	case "bse_14ton_vsl_capa": 
	    	case "rf_cntr_plg_qty": 
	    	case "ddwt_cgo_capa_qty": 
	    	case "grs_wgt": 
	    	case "nrt_wgt":
	    	case "cust_seq":
	    		//ComChkObjValid(obj, bMsg, bTrim, bMasked)
    			ComChkObjValid(ComGetEvent(), true, false, false);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(ComGetEvent());
    	}
    }
    /**
     * Removing Mask Separator in onfocus Event of HTML Control <br>
     **/
    function obj_activate(){
    	ComClearSeparator(ComGetEvent());
    }
    /**
     * Getting Name when changing VslCd <br>
     **/
    function vsl_cd_change() {
    	doActionIBSheet(sheetObjects[1],document.form,IBROWSEARCH,'Vessel');
    }
    //Axon Event Handling2. Event Handling Function --- end
    /**
	  * Insering Vessel Code<br>
	  * @param {arry} aryPopupData
	  */
	function setVslCd(aryPopupData){
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener  ('change', 'vsl_cd_change', 'vsl_cd');			//Getting Name information after inserting Vessel Code
		form.vsl_cd.readOnly=true;
		form.btn_vslpop.style.cursor="default";
		//document.images["btn_vslpop"].name="no_btn_vslpop";
		form.btn_vslpop.style.cursor="hand";
	}
	/**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL )
     **/
	function validateForm(sheetObj,formObj,sAction){
        if(!ComChkValid(formObj)) return false;
        
        var sFrDt = formObj.eff_dt.value;
        var sToDt = formObj.exp_dt.value;
        var iDiffDay = ComGetDaysBetween(sFrDt, sToDt);
        
        if(iDiffDay > gOneYearDay) {
    		ComAlertFocus(form.exp_dt, ComGetMsg('FMS01174')); //Please enter less than one year.
    		return false;
    	}
	 	return true;
	}
    /**
     * Preventing Modifying Duration information <br>
     * @return none
     **/
    function durationReadonly() {
    	form.ef_dt.style.cursor="default";
		form.ex_dt.style.cursor="default";
		document.images["ef_dt"].name="no_ef_dt";
		document.images["ex_dt"].name="no_ex_dt";
		form.eff_dt.className="input2";
		form.exp_dt.className="input2";
		form.eff_dt.readOnly=true;
		form.exp_dt.readOnly=true;
    }
 	/**
     * Initializing Screen <br>
     * @return none
     * @see #ComResetAll
     **/
	function formReset() {
		ComResetAll();
		//document.all.btn_creation.style.display = "";
    	//document.all.btn_save.style.display = "none";
    	//document.all.btn_delete.style.display = "none";
		form.ef_dt.style.cursor="hand";
		form.ex_dt.style.cursor="hand";
//		document.images["ef_dt"].name="ef_dt";
//		document.images["ex_dt"].name="ex_dt";
		form.eff_dt.className="input1";
		form.exp_dt.className="input1";
		form.eff_dt.readOnly=false;
		form.exp_dt.readOnly=false;
		sheetObjects[1].SetVisible(false);
//no support[implemented common]CLT 		controlScrollBar();
		form.vsl_cd.readOnly=false;
		form.btn_vslpop.style.cursor="hand";
		sheetObjects[0].RemoveAll();
//		document.images["btn_vslpop"].name="btn_vslpop";
	}
    /**
     * Controlling scroll bar automatically when retrieving data <br>
     **/
	function controlScrollBar() {
 		try{
 			top.syncHeight()
 		} catch(err){ComFuncErrMsg(err.message);}
 	}
 	/**
     * 
     * @param sheetObj
     * @param olTopRow
     * @param oldLeftCol
     * @param newTopRow
     * @param newLeftCol
     * @return
     */
	function sheet1_OnScroll(sheetObj, olGetTopRow, oldLeftCol, newGetTopRow, newLeftCol) {
    	sheetObjects[1].SetHighLeftCol(newGetHighLeftCol());
    }
    /**
     * 
     * @param sheetObj
     * @param olTopRow
     * @param oldLeftCol
     * @param newTopRow
     * @param newLeftCol
     * @return
     */
	function sheet2_OnScroll(sheetObj, olGetTopRow, oldLeftCol, newGetTopRow, newLeftCol) {
    	sheetObjects[0].SetHighLeftCol(newGetHighLeftCol());
    }
    /**
     * Event occurred after retrieveing by DoSearch <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error Message
     **/
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
  		setInitCellProperty(sheetObj);
//  		InitColumns(sheetObj,undefined );
  	}
    /**
     * 
     * @param sheetObj
     * @param errMsg
     * @return
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	sheetObj.SetVisible(sheetObj.RowCount() > 0);
    	$('#DIV_sheet2 div.GMFillRow').hide();
        for(var row = 1; row <= sheetObj.LastRow(); row++) {
        	sheetObj.InitCellProperty(row, "eff_dt", {Type:"Text", Format:""}, "");
            if(row == 1) {
     			sheetObj.SetCellText(row, "eff_dt" ,"Total Amount");
     		} else {
     			sheetObj.SetCellText(row, "eff_dt" ,"");
     		}
     		sheetObj.SetRowBackColor(row,"#FFE6FB");
     		sheetObj.SetCellFont("FontBold", row, "eff_dt",1);
     		//sheetObj.CellFont("FontBold", row, "flet_ctrt_tp_cd") = true;
     		//sheetObj.CellFont("FontBold", row, "ownr_nm") = true;
     		//sheetObj.CellFont("FontBold", row, "vsl_dznd_capa") = true;
     		sheetObj.SetCellFont("FontBold", row, "ti_curr_cd",1);
     		sheetObj.SetCellFont("FontBold", row, "ti_inv_amt",1);
     		sheetObj.SetCellFont("FontBold", row, "ti_curr_cd2",1);
     		sheetObj.SetCellFont("FontBold", row, "ti_inv_amt2",1);
     		sheetObj.SetCellFont("FontBold", row, "to_curr_cd",1);
     		sheetObj.SetCellFont("FontBold", row, "to_inv_amt",1);
     		sheetObj.SetCellFont("FontBold", row, "to_curr_cd2",1);
     		sheetObj.SetCellFont("FontBold", row, "to_inv_amt2",1);
        }
//        sheetObj.InitCellProperty(sheetObj, undefined);
        setInitCellProperty(sheetObj);
        sheetObj.SetSheetWidth(sheet1.GetSheetWidth());
    }
    /**
     * Event occurred when clicking Cell <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
    function setInitCellProperty(sheetObj){  
    	for(var ir=1; ir<=sheetObj.LastRow(); ir++) {
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, "ti_curr_cd"))) {
    			sheetObj.InitCellProperty(ir, 4,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
			}
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, "ti_curr_cd2"))) {
    			sheetObj.InitCellProperty(ir, 6,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
			}
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, "to_curr_cd"))) {
    			sheetObj.InitCellProperty(ir, 8,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
			}
    		if(ComFmsCheckCurrencyYn(sheetObj.GetCellValue(ir, "to_curr_cd2"))) {
    			sheetObj.InitCellProperty(ir, 10,{ Type:"Null",Align:"Right",Format:"NullInteger"} );
			}
		}
    }

	function rdOpen(formObject){
		if(sheetObjects[0].RowCount() == 0) {
			ComShowCodeMessage("FMS00015");
			return;
		}  		

		var usrId = formObject.usr_id.value;
		var effDt = formObject.eff_dt.value.replace(/-/g,"");
		var expDt = formObject.exp_dt.value.replace(/-/g,"");
		var vslCd = formObject.vsl_cd.value;

		var rdParam = '/rp ' + '[' + usrId + '] [' + effDt + '] [' + expDt + '] [' + vslCd + ']';
		
		var rdFile = 'apps/opus/esm/fms/timecharterinoutfleetmanagement/tcharterioinquiry/report/ESM_FMS_009.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0],100);
	}	
	
	function initPeriod(){	
		var formObj = document.form;
		setToday(formObj.eff_dt,"ymd");

		var varExpDt = ComGetDateAdd(null, "M", 1);
		formObj.exp_dt.value = ComGetMaskedValue(varExpDt,"ymd");
	}