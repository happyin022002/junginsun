/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0170.js
*@FileTitle  : Reefer Unit Warranty Period
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0170 : EES_MNR_0170 - Defining a script used by screen
     */
    function EES_MNR_0170() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
/* Developer's task	*/
// Common global variable
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;
					case "btn_new":
						doActionIBSheet(sheetObject1,document.form,IBCLEAR);
					break;
					case "btn_save":
						doActionIBSheet(sheetObject1,document.form,IBSAVE);
					break;
					case "btn_RowDel":
						doActionIBSheet(sheetObject1, formObject, IBDELETE);
					break;
					case "btn_RowAdd":
						doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
					case "btn_downexcel":
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
							}
					break;
					case "dpc_yr_cal1":
						var cal=new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.fm_lot_pln_yr, 'yyyy');
					break;
					case "dpc_yr_cal2":
						var cal=new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.to_lot_pln_yr, 'yyyy');
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
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
		              var HeadTitle1="|Sel.|Seq.|Range|Range|Range|Range|TP/SZ|Maker|Unit Model|MFG|Q'ty|Warranty Period|Warranty Period|Remark(s)";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount + 2, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"S" },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lot_eq_pfx_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"fm_ser_no",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
		                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ser_frefix",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"to_ser_no",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
		                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"eq_mkr_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"eq_mdl_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"mft_yr",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                     {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"eq_qty",         KeyField:0,   CalcLogic:"|to_ser_no|*10-|fm_ser_no|*10+1",Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		                     {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fm_warr_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"to_warr_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"warr_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"mnr_grp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetShowButtonImage(2);
		              SetSelectionMode(smSelectionRow);
//		              SetSheetHeight(422);
		              resizeSheet( sheetObj );
              }
		      break;
        }
    }
  //Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
					case IBSEARCH:      //Retrieving
						if(validateForm(sheetObj,formObj,sAction)){
							formObj.f_cmd.value=SEARCH;
							sheetObj.DoSearch("EES_MNR_0170GS.do", FormQueryString(formObj) );
						}
					break;
					case IBSAVE:        //Saving
          				if(validateForm(sheetObj,formObj,sAction)){
							if(ComShowCodeConfirm("MNR00160","")){
								formObj.f_cmd.value=MULTI;
								sheetObj.DoSave("EES_MNR_0170GS.do", FormQueryString(formObj),-1,false);
							}
						}
					break;
					case IBCLEAR:      //Inserting
						MnrWaitControl(true);
                    	sheetObj.WaitImageVisible = false;
						formObj.reset();
						sheetObj.RemoveAll();
						var sDate=new Date();
						//get full year current.
						formObj.fm_lot_pln_yr.value=sDate.getFullYear() - 10;
						formObj.to_lot_pln_yr.value=sDate.getFullYear();
						//Retrieving data of combo of sheet 
						var sCondition=new Array (
						 	new Array("MnrGenCd","CD00009", "COMMON"),
							new Array("EqTpSz","U","COMMON")
						)
						var sheetComboText="";
						var sheetComboCode="";
						var sheetComboDefault=new Array();
						//combo of sheet SAVE_NAME
						var comboSaveNames=new Array();
						comboSaveNames[0]="eq_mkr_nm";
						comboSaveNames[1]="eq_tpsz_cd";
						var sheetComboList=MnrComSearchCombo(sheetObj,sCondition);
						for(var i=0; i < sheetComboList.length;i++){
						 	if(sheetComboList[i] != null){
								//Initializing each combo of sheets
								sheetComboText="";
								sheetComboCode="";
								//sheetComboCodeText = "";
						 		for(var j=0; j < sheetComboList[i].length;j++){
									var tempText=sheetComboList[i][j].split("|");
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									//sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
									if(j == 0){
										sheetComboDefault[i]=tempText[0];
									}
								}
					   	     	sheetComboText=MnrDelLastDelim(sheetComboText);
						        sheetComboCode=MnrDelLastDelim(sheetComboCode);
						        //sheetComboCodeText = MnrDelLastDelim(sheetComboCodeText);
								if(comboSaveNames[i] == "eq_mkr_nm"){
									sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault[i]);
								} else {
									sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboCode, sheetComboCode ,sheetComboDefault[i]);
								}
							}
						}
						sheetObj.SetWaitImageVisible(1);
                    	MnrWaitControl(false);
						break;
					case IBDELETE:      //Deleting
						if(sheetObj.FindCheckedRow("del_chk") != ""){
							ComRowHideDelete(sheetObj,"del_chk");
						} else {
							ComShowCodeMessage("MNR00150");
						}
					break;
					case IBINSERT:      //Inserting
						var sDate=new Date();
						var Row=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(Row, "lot_eq_pfx_cd","COMU",0);
						sheetObj.SetCellValue(Row, "ser_frefix","-",0);
						//alert(sDate.getFullYear());
						sheetObj.SetCellValue(Row, "mft_yr",sDate.getFullYear(),0);
						sheetObj.SetCellValue(Row, "eq_knd_cd","U",0);
						sheetObj.SetCellValue(Row, "mnr_grp_tp_cd","RPR",0);
					break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) {
				if (!ComChkValid(formObj)) return false;
			}   else if(sAction==IBSAVE){
				if(sheetObj.IsDataModified()== false){
					return false;
				}
				for(var i=1; i <= sheetObj.RowCount(); i++){
					if(sheetObj.GetRowStatus(i) == "I" || sheetObj.GetRowStatus(i) == "U"){
					if(sheetObj.GetCellValue(i, "fm_warr_dt") != "" && sheetObj.GetCellValue(i, "to_warr_dt") != ""){
					if(sheetObj.GetCellValue(i, "fm_warr_dt") > sheetObj.GetCellValue(i, "to_warr_dt")){
								ComShowCodeMessage("MNR00166");
								sheetObj.SelectCell(i, "fm_warr_dt");
								return false;
							}
						}
					if(sheetObj.GetCellValue(i, "fm_ser_no") != "" && sheetObj.GetCellValue(i, "to_ser_no") != ""){
						if(sheetObj.GetCellValue(i, "fm_ser_no") > sheetObj.GetCellValue(i, "to_ser_no")){
								ComShowCodeMessage("MNR00173");
								sheetObj.SelectCell(i, "fm_ser_no");
								return false;
							}
						}
					if(sheetObj.GetCellValue(i, "eq_qty").replace(/,/g,"") > 999999){
							ComShowCodeMessage("MNR00166");
							sheetObj.SelectCell(i, "to_ser_no");
							return false;
						}
				   }
					//Checking duplicate data
			   		var Row=sheetObj.ColValueDup("lot_eq_pfx_cd|fm_ser_no|to_ser_no");
					if(Row > 0){
						ComShowCodeMessage("MNR00006"," sheet of "  + Row + " row ");
						sheetObj.SelectCell(Row, "fm_ser_no", true);
						return false;
					}
			   }
			}
        }
        return true;
    }
	function sheet1_OnKeyDown(sheetObj,Row,Col,KeyCode,Shift){
		if(KeyCode == 9){
			if(Col == 4){
				sheetObj.SelectCell(Row,Col + 1);
			}
		}
	}
	//Showing message after saving
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023",'');
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	function sheet1_OnPopupClick(sheetObj, row,col){
        if (!(sheetObj.ColSaveName(col) == "fm_warr_dt" || sheetObj.ColSaveName(col) == "to_warr_dt")) return;
        var cal=new ComCalendarGrid();
        cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    }
	function initControl() {
	    //Axon event handling 1. Catching event
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  form);
	//    axon_event.addListenerFormat('focus',    'obj_activate',    form);
	}
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
/* End of developer's task */
