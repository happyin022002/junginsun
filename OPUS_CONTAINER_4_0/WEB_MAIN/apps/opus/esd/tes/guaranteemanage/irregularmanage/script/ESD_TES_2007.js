/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_2007.js
*@FileTitle : Irregular Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab1=1;
var beforetab2=1
var sheetObjects=new Array();
var sheetCnt=0;
/**
 * Event handler processing by button click event 
 */
document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name
	 **/
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":					
					if (ComIsNull( formObject.irr_no.value ) &&
						ComIsNull( formObject.cost_ofc_cd.value ) &&		
						ComIsNull( formObject.cre_usr_id.value )
					) {
						ComShowCodeMessage('TES70201');    // Please enter Item.
						return false;
					}
					if ( ( formObject.ofc_cd.value != formObject.cost_ofc_cd.value) ) {						
//						ComShowCodeMessage('TES70205');    // Check Vaild Office Code.
						return false;
					}
					if (ComIsNull( formObject.fm_cre_dt.value ) ) {
						ComShowCodeMessage('TES21903');
						return false;
					}
					if (ComIsNull( formObject.to_cre_dt.value ) ) {
						ComShowCodeMessage('TES21904');
						return false;
					}
					if (!tes_validateDateObj(formObject.fm_cre_dt)) {
						ComShowCodeMessage('TES23011');
						formObject.fm_cre_dt.focus();
						return false;
					}
					if (!tes_validateDateObj(formObject.to_cre_dt)) {
						ComShowCodeMessage('TES23011');
						formObject.to_cre_dt.focus();
						return false;
					}
					if ( ComGetDaysBetween(formObject.fm_cre_dt, formObject.to_cre_dt) < 0 ) {
						ComShowCodeMessage('TES24012');
						return false;
					}					
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);					
					break;
				case "btn_new":
					initForm();
					break; 
				case "btn_guarantee":
					var	selectRow=sheetObject1.GetSelectRow();
					if ( sheetObject1.GetCellValue(selectRow, "dmy_flg") == 'Y'  ) {
						ComShowCodeMessage('TES70701'); // This Is Not A Guarantee.
						return false;
					}
					if ( sheetObject1.RowCount()>= 1 && !ComIsNull( sheetObject1.GetCellValue(selectRow, "gnte_no") ) ) {
						var gnteUrl="ESD_TES_2001.do?pgmNo=ESD_TES_2001&parentPgmNo=ESD_TES_M001&inq_flg=Y"
							+ "&gnte_no="	+ sheetObject1.GetCellValue(selectRow, "gnte_no")
							;
						window.location.replace(gnteUrl);
					}
					break;
				case "btn_irregular":
					var	selectRow=sheetObject1.GetSelectRow();
					if ( sheetObject1.RowCount()>= 1 && !ComIsNull( sheetObject1.GetCellValue(selectRow, "irr_no") ) ) {
						var gnteUrl="ESD_TES_2006.do?pgmNo=ESD_TES_2006&parentPgmNo=ESD_TES_M001&inq_flg=Y"
							+ "&irr_no="	+ sheetObject1.GetCellValue(selectRow, "irr_no")
							+ "&gnte_no="	+ sheetObject1.GetCellValue(selectRow, "gnte_no")
							;
						window.location.replace(gnteUrl);
					}
					break; 
				case "btn_downexcel":
					// sheet ( Container List ) Excel Down
                    doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
					break;
				case "btn_refno":
					var dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId="ESD_TES_2004";
					var param='?cre_flg=I&classId='+classId;
					var chkStr=dispaly.substring(0,3);
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('ESD_TES_2004.do' + param, 500, 360, '', dispaly, true);
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;
//					window.showModalDialog("ESD_TES_2007.do", window, "dialogWidth:410px; dialogHeight:650px; help:no; status:no; resizable:yes;");
//					break;
				case "btn_custcd":
					var dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId="COM_ENS_041";
					var param='?classId='+classId;
					var chkStr=dispaly.substring(0,3);
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/opuscntr/COM_ENS_041.do' + param, 770, 460, 'getYard', dispaly);
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;
				case "btns_calendar1":
					var cal=new ComCalendar();	//calendarPopup();
					cal.select(formObject.fm_cre_dt, 'yyyy-MM-dd');
				break;
				case "btns_calendar2":
					var cal=new ComCalendar();
					cal.select(formObject.to_cre_dt, 'yyyy-MM-dd');
				break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');   //The service is not available now
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source. <br>
	 * @param{ibsheet}		sheet_obj		IBSheet Object
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
		initForm();
		document.getElementById("irr_no").focus();
	}
	/**
	 * setting sheet initial values and header
	 * adding case as numbers of counting sheets
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,String} 	sheetNo		Sheet Object 
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
			    with(sheetObj){
		        
		      var HeadTitle1="|Seq.|REF No.|Container No.|SZ|Type|BL No.|SC No.|From DT|To DT|"
		      + "Amount|U.User ID|U.User Name|U.Date|SE|ST|CS|EF|OT|LD|"
		      + "LF|CW|ES|OC|TO|TT|SP|TC|MR|TR|Gnte No|DMY FLG";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"irr_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"gnte_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"sc_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"fm_dt",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"to_dt",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"gnte_amt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"usr_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_stf_err_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_sys_err_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_chss_shtg_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_otr_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_late_dis_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_lack_of_flw_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_cxl_wo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"irr_eq_shtg_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_ocp_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_tnk_ord_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_team_trkg_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_xtra_ft_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_sptg_icrz_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_otr_tml_chss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_mnr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"op_cost_tri_axl_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"gnte_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmy_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      //SetCountPosition(0);
//		      SetSheetHeight(324);
		      resizeSheet();
		            }
				break;
		}
	}
    /**
     * IBhandling sheet process.<br>
     * 
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     */	
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
	    	case IBSEARCH:      
	    		formObj.f_cmd.value=SEARCH;
    	 		var sXml = sheetObj.DoSearch("ESD_TES_2007GS.do", tesFrmQryStr(formObj)  );
    	 		sheetObj.LoadSearchData(sXml,{Sync:1} );
//    			document.getElementById("ttl_cnt").value = sheetObj.EtcData("ttlCnt");
//    			document.getElementById("ttl_amt").value = sheetObj.EtcData("ttlAmt");
	    		break;
	    	case IBDOWNEXCEL:	
	    		if(sheetObj.RowCount() < 1){
    				ComShowCodeMessage("COM132501");
    			}else{
    				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(	    		sheetObj), SheetDesign:1,Merge:1 });
    			} 	    		
	    		break;
    	}
    }
	/**
	 * Reference No <br>
	 * 
	 * @param{Array}		rowArray	rowArray
	 */
	function getRefNo(rowArray) {
		document.all.irr_no.value=rowArray[0];
	}
	/**
     * Form Object Header Value <br>
     **/
	function initForm() {
		tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
		document.getElementById("irr_no").value="";
		document.getElementById("ofc_cd").value=document.getElementById("cre_ofc_cd").value;
		document.getElementById("cre_usr_id").value="";
		document.getElementById("gnte_tp_cd").value="";
		sheetObjects[0].RemoveAll();
	}
	/**
     * set Period From To
     * 
     */
	function setPeriodFromTo(){
		var formObj=document.form;
		var to_dt=new String(formObj.DB_DATE.value).substring(0, 8);
		var fr_dt;
		if (to_dt != undefined && to_dt != null && to_dt.trim() != '' && to_dt.length == 8) {
			//fr_dt = tes_getDiffDate(to_dt, -30, 'D');
			fr_dt=tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
			if (fr_dt != undefined && fr_dt != null && fr_dt.trim() != '' && fr_dt.length == 8) {
				if (fr_dt.substring(6, 8) > ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10))){
					fr_dt=fr_dt.substring(0, 6) + ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10));
				}
				formObj.fm_cre_dt.value=fr_dt.substring(0, 4) + '-' + fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
				formObj.to_cre_dt.value=to_dt.substring(0, 4) + '-' + to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
			}
		}
	}
    /**
	 * Validation Check Office Code
	 *
	 */
	function validateDeptNo() {
		var formObj=document.form;
		if (formObj.ofc_cd.readOnly == false && formObj.cost_ofc_cd.value != "" ) {
			if ((formObj.ofc_cd.value == null || formObj.ofc_cd.value.trim() == '') ||
				formObj.ofc_cd.value != formObj.cost_ofc_cd.value ) {
				tes_getInputValue('is_valid_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidDeptNo');
			}
		}
	}
	/**
	 * Office Code Validation Check
	 */
	function checkValidDeptNo(){
		var formObj=document.form;
		var tmp='';
		if (formObj.is_valid_ofc_cd.value != undefined && formObj.is_valid_ofc_cd.value != null &&
			formObj.is_valid_ofc_cd.value.trim() != '' ){
			tmp=formObj.is_valid_ofc_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_ofc_cd.value=(tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
				if (formObj.is_valid_ofc_cd.value != null && formObj.is_valid_ofc_cd.value == 'Y'){
					formObj.ofc_cd.value=document.getElementById("cost_ofc_cd").value;
				} else {
					formObj.is_valid_ofc_cd.value='';
					formObj.cost_ofc_cd.value='';
					formObj.ofc_cd.value='';
					ComShowCodeMessage('TES70204');	// This is invalid Office Code.
				}
			} else {
				formObj.is_valid_ofc_cd.value='';
				formObj.cost_ofc_cd.value='';
				formObj.ofc_cd.value='';
				ComShowCodeMessage('TES70204');	// This is invalid Office Code.
			}
		} else {
			formObj.is_valid_ofc_cd.value='';
			formObj.cost_ofc_cd.value='';
			formObj.ofc_cd.value='';
			ComShowCodeMessage('TES70204');	// This is invalid Office Code.
		}
	}
	/**
     * @param {obj}    Text Value
     **/
	function isApNum(obj){
		if (!ComIsAlphabet(obj,'u')){
			obj.value='';
		}
	}
	/**
     * @param {obj}    Text Value
     **/
	function isApNum2(obj){
		if (!ComIsAlphabet(obj,'n')){
			obj.value='';
		}
		obj.value=obj.value.toUpperCase();
	}
	// UI 표준화관련 하단 여백 설정
	function resizeSheet() {
		    ComResizeSheet(sheetObjects[0]);
	}