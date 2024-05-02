/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0244.js
*@FileTitle : Disposal Performance by RCC
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0244 : EES_MNR_0244 - Defining a script used by screen
     */
    function EES_MNR_0244() {
    	this.processButtonClick=processButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initControl=initControl;
		this.obj_blur=obj_blur;
		this.obj_focus=obj_focus;
		this.obj_change=obj_change;
		this.obj_keypress=obj_keypress;
		this.obj_keyup=obj_keyup;
		this.obj_keydown=obj_keydown;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
		this.openPopup=openPopup;
		this.initDynamicEqTpszCd=initDynamicEqTpszCd;
		this.setDynamicEqTpszHeader=setDynamicEqTpszHeader;
		this.validateForm=validateForm;
		this.clearForm=clearForm;
    }
   	/* Developer's task	*/
   	/* Sheet Select Back Color */
	var MNR_SELECT_BACK_COLOR="#99FFFF";
	var MNR_TOTCOL_BACK_COLOR="#EFEBEF";
	var cntrTpSz=new Array();
	var chssTpSz=new Array();
	var gsetTpSz=new Array();
	var vCntrTpszHdr="| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
	var vArrCntrTpsz=vCntrTpszHdr.split("|");
	var vCntrTpszCnt=vArrCntrTpsz.length;
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick() {
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
     	try {
     		var srcObj=ComGetEvent();
 			var srcName=ComGetEvent("name");
 			if(ComGetBtnDisable(srcName)) return false;
 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;
 				case "btn_New":
					ComResetAll();
					setDynamicEqTpszHeader(sheetObjects[0], "U");
					formObj.p_loc_cd.readOnly=true;
					formObj.p_loc_cd.className="input2";
					ComEnableObject(formObj.btns_search, false);
					ComSetFocus(formObj.p_str_evnt_dt);
					comboObjects[0].SetSelectIndex(0);
 					break;
             	case "btns_search":	//Form Location. Retrieving pop-up
 					openPopup("1");
 					break;
 				case "btns_search2":	//Buyer Retrieving pop-up
 					openPopup("2");
 					break;
				case "btns_calendar":	// Event Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendarFromTo();
						cal.select(formObj.p_str_evnt_dt, formObj.p_end_evnt_dt, 'yyyy-MM-dd');
					}
					break;
             	case "btn_DownExcel":
             		if(sheetObject.RowCount() < 1){//no data
             			 ComShowCodeMessage("COM132501");
         			}else{
         				sheetObject.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1});
         			}
					break;
				case "p_chk_expand":
					/* Setting tree-level */
					if ( srcObj.checked ) {
						sheetObject.ShowTreeLevel(-1);
					} else {
						sheetObject.ShowTreeLevel(0);
					}
					break;
 			} // end switch
     	} catch(e) {
     		if(e == "[object Error]") {
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * IBMultiCombo Register array for object
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	var formObj=document.form;
		for(i=0; i < sheetObjects.length; i++) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* IBMultiCombo Initializing */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
    }
    /**
	 * Event handling of OnLoadFinish of sheet1
	 */
    // Axon event handling
  	// 1. Catching event
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj);
	//	axon_event.addListenerFormat('focus',		'obj_focus',	formObj);
		axon_event.addListenerForm('change',   		'obj_change',  	formObj);
  	}
	//Prevent duplicate events
	var preEventType=null;
  	// 2. Event-handling functions -- Start
  	/**
	 * Event handling of blur of elements
	 **/
	function obj_blur() {
		var obj=ComGetEvent();
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")) {
	        default: //do nothing
	        	ComChkObjValid(obj);
	        	break;
	    }
	}
	/**
	 * Event handling of focus of elements
	 */
	function obj_focus() {
		var obj=ComGetEvent();
	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
	    } else {
	    	//Clearing separator
		    ComClearSeparator(obj);
	    }
	}
	/**
	 * Event handling of change of elements
	 */
	function obj_change() {
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var tabObj=tabObjects[0];
		switch(ComGetEvent("name")) {
			case "p_str_evnt_dt":
    		case "p_end_evnt_dt":
    			checkDurationDate(obj);
	    		break;
			case "p_eq_knd_cd":			//Equipment Type
				sheetObjects[0].RemoveAll();
				setDynamicEqTpszHeader(sheetObjects[0], obj.value);
				break;
			case "p_loc_tp":		//Location Type
				formObj.p_loc_cd.value="";
				if(obj.value == "") {
					formObj.p_loc_cd.readOnly=true;
					formObj.p_loc_cd.className="input2";
					ComEnableObject(formObj.btns_search, false);
				} else {
					formObj.p_loc_cd.readOnly=false;
					formObj.p_loc_cd.className="input";
					ComEnableObject(formObj.btns_search, true);
					ComSetNextFocus(obj);
				}
				break;
			case "p_loc_cd":	//Location Code
    			if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
    			break;
    		case "p_cust_cd":	//Buyer Code
    			if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  				}
    			break;
		}
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	/**
	 * Event handling of keypress of elements
	 */
  	
  	/**
  	 * Event handling of keyup of elements
  	 */
  
   	/**
     * Event handling of keydown of elements
     */
 
  	//2. Event-handling functions -- End
  	/**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj, sheetNo) {
    	var formObj=document.form;
		var sheetid=sheetObj.id;
		var cnt=0;
		switch(sheetid) {
			case "sheet1":
				  with(sheetObj){
					
					   var HeadTitle="RCC||||||G.TTL|Ratio|TTL Amount(USD)"+ vCntrTpszHdr +"|";
					   var headCount=ComCountHeadTitle(HeadTitle);
					   for(var i=0; i < 4; i++) {
						   cnt=0;
						
						   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:9, DataRowMerge:1 } );
						
						   var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
						   var headers = [ { Text:HeadTitle, Align:"Center"} ];
						   InitHeaders(headers, info);
						
						   var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"" , TreeCol:1, LevelSaveName:""},
							 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"level_no",          KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"disp_qty_tot",      KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"disp_qty_cnt",      KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"disp_qty_rto",      KeyField:0,   CalcLogic:"",   Format:"" },
							 {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"cal_part_amt_tot",  KeyField:0,   CalcLogic:"",   Format:"" } ];
						   for(var j = 1; j < vCntrTpszCnt; j++) {
							   var tpsz_dp_no = "tpsz_dp"+ ComLpad(j, 2, "0");
							   if(vArrCntrTpsz[j] != "") {
								   cols.push({Type:"Text", Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:tpsz_dp_no,          KeyField:0,   CalcLogic:"",   Format:"" });
							   } else {
								   cols.push({Type:"Text", Hidden:1,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:tpsz_dp_no,          KeyField:0,   CalcLogic:"",   Format:"" });
							   }					  						 
					      	}
//						   cols.push({Type:"AutoSum",   Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"auto_sum",          KeyField:0,   CalcLogic:"",   Format:"" });
					   	}
					   SetEditable(0);
					   InitColumns(cols);	
//					   SetSheetHeight(382);					  		
					   SetCountFormat("[SELECTDATAROW / TOTALROWS]");		
					   resizeSheet( sheetObj );
			   }
				break;
		}
	}
	/**
	 * Initializing combo
	 * param : comboObj ==> combo object, sheetNo ==> Sequence number from combo object tag id
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "combo1":
	        	with(comboObj) {
	            	SetDropHeight(250);
	        	}
	        	break;
	    }
	}
	/**
	 * Sheet processing-related processes
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCREATE:
				//Equipment Type/Size Grid Header Item Setting
				initDynamicEqTpszCd(sheetObj);
				setDynamicEqTpszHeader(sheetObj, formObj.p_eq_knd_cd.value);
				//Disposal Kind Combo Item Setting
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MnrGenCd","CD00038", "COMMON")	//DISP_RSN_CD
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//DISP_RSN_CD setting
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						comboObjects[0].InsertItem(j,tempText[1] ,tempText[0]);
					}
				}
				comboObjects[0].InsertItem(0 , 'ALL','');
				comboObjects[0].SetSelectIndex(0);
				break;
			case IBSEARCH:			//Retrieving
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("EES_MNR_0244GS.do", FormQueryString(formObj));
						if(ComGetTotalRows(sXml) > 4) {
//							sheetObj.RenderSheet(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
//							sheetObj.RenderSheet(1);
						} else {
							sheetObj.LoadSearchData("<SHEET><ETC-DATA><ETC KEY='Exception'><![CDATA[]]></ETC><ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC></ETC-DATA>	<DATA  TOTAL='0'></DATA></SHEET>",{Sync:0} );
						}
						ComOpenWait(false);
						sheetObj.SetWaitImageVisible(1);
					}
				}
				break;
			case IBSEARCH_ASYNC01:	// Location Retrieving
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
						var vLocType=formObj.p_loc_tp.value;
						var vLocCode=formObj.p_loc_cd.value;
 						var param="f_cmd="+SEARCH+"&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&loc_state=";
 						if(vLocType == "RCC") {
							param += "&loc_cd=&rcc_cd="+ vLocCode +"&lcc_cd=";
 						} else if(vLocType == "LCC") {
							param += "&loc_cd=&rcc_cd=&lcc_cd="+ vLocCode;
 						} else if(vLocType == "SCC") {//SCC is part of LOC
							param += "&loc_cd="+ vLocCode +"&rcc_cd=&lcc_cd=";
 						}
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_051GS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) < 1 ) {
							ComShowCodeMessage("MNR00117");
 							formObj.p_loc_cd.value="";
							ComSetFocus(formObj.p_loc_cd);
						} else if(vLocType == "SCC") {
							var aryData=MnrXmlToArray(sXml);
							if(vLocCode != aryData[0][11]) {
								ComShowCodeMessage("MNR00117");
	 							formObj.p_loc_cd.value="";
								ComSetFocus(formObj.p_loc_cd);
							}
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC02:	// Buyer Code Retrieving
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vCustCntCd=formObj.p_cust_cd.value;
 						var param="f_cmd="+SEARCH+"&cust_cd="+ vCustCntCd.substr(0,2) +"&cust="+ vCustCntCd.substr(2);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_041GS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) != 1 ) {
							ComShowCodeMessage("MNR00025", "Buyer");
 							clearForm("p_cust_cd");
							ComSetFocus(formObj.p_cust_cd);
						} else {
							var aryData=MnrXmlToArray(sXml);
							ComSetObjValue(formObj.p_vndr_nm, aryData[0][1]);
							formObj.p_vndr_nm.focus();
						}
					}
				}
 				break;
		}
    }
	/**
     * Event handling of OnSearchEnd of sheet1
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj=document.form;
			var viewCnt=0;
			if(LastRow()> 3) {
				SetColBackColor("disp_qty_cnt",MNR_TOTCOL_BACK_COLOR);
				SetColBackColor("disp_qty_rto",MNR_TOTCOL_BACK_COLOR);
				SetColBackColor("cal_part_amt_tot",MNR_TOTCOL_BACK_COLOR);
				for(var i=LastRow(); i > LastRow()-4; i--) {
					SetCellAlign(i, "loc_cd","Center");
				}
				for ( var i=1 ; i < vCntrTpszCnt ; i++ ) {
					var cellData=eval('GetCellValue(LastRow()-3, "tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					if(cellData <= 0) {
						eval('SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",1);');
					} else {
						eval('SetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '",0);');
					}
					var viewFlag=eval('GetColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					if(viewFlag == false) {
						viewCnt++;
					}
				}
				if(360 + (viewCnt * 80) > 984) {
					SetSheetWidth(984);
				} else {
					SetSheetWidth(370 + (viewCnt * 80));
				}

				SetRangeBackColor(LastRow()-3, 0, LastRow(), LastCol(), "#FFA7A7");
     			SetRangeFontBold(LastRow()-3, 0, LastRow(), LastCol(), 1);

     			if(formObj.p_chk_expand.checked){
     				sheetObj.ShowTreeLevel(-1,1);
     			}else{
     				sheetObj.ShowTreeLevel(0,1);
     			}
				
			}
    	}
    }
	/**
	 * combo1_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj=document.form;
		formObj.p_disp_rsn_cd.value=ComGetObjValue(comboObj);
		if(ComGetObjValue(formObj.p_disp_rsn_cd) == "ALL") {
			ComSetObjValue(formObj.p_disp_rsn_cd, "");
		}
	}
	/**
	 * cobo1_OnKeyDown
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if(KeyCode == 13) {
				formObj.p_disp_rsn_cd.value=ComGetObjValue(comboObj);
				if(ComGetObjValue(formObj.p_disp_rsn_cd) == "ALL") {
					ComSetObjValue(formObj.p_disp_rsn_cd, "");
				}
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
		}
	}
	/**
     * Pop-up Open<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row The object is row index in case of IBSheet
     * @param Col The object is column index in case of IBSheet
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(formObj.p_loc_tp.value) {
    			case "RCC" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "LCC" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "SCC" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	} else if(type == "2") {
    		ComOpenPopup('/opuscntr/COM_ENS_041.do', 780, 490, 'setPopData_BuyerCd', '1,0,1,1,1,1,1,1', true);
    	}
    	return;
    }
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_BuyerCd(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.p_cust_cd.value=aryPopupData[0][3];
			formObj.p_vndr_nm.value=aryPopupData[0][4];
		}
	}
	/**
	 * Assigning each array by EQ_TYPE size
	 */
	function initDynamicEqTpszCd(sheetObj) {
		var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind","");
		if(arrXml != null) {
			for(var i=0; i < arrXml.length; i++) {
				if(i == 0){//U
					cntrTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){//Z
					chssTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){//G
					gsetTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
			}
		}
	}
	/**
	 * Equipment Type/Size Grid Header Setting
	 */
	function setDynamicEqTpszHeader(sheetObj, eqKndCd) {
		var eqTpSzAry=new Array();
		if(eqKndCd == "U") {
			eqTpSzAry=cntrTpSz;
		} else if(eqKndCd == "Z") {
			eqTpSzAry=chssTpSz;
		} else {//eqKndCd is 'G'
			eqTpSzAry=gsetTpSz;
		}
		if(eqTpSzAry.length > 0) {
			var eqTpSzStr="|"+ eqTpSzAry.toString().replace(/,/g, "|");
			vCntrTpszHdr=eqTpSzStr;
			vArrCntrTpsz=eqTpSzStr.split("|");
			vCntrTpszCnt=vArrCntrTpsz.length;
			for(i=0; i < sheetObjects.length; i++) {
				/* Resetting IBSheet */
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i], i+1);
				ComEndConfigSheet(sheetObjects[i]);
			}
		}
	}
	/**
	 * Duration Date Validation<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj=document.form;
    	var vEffDt=ComReplaceStr(ComGetObjValue(formObj.p_str_evnt_dt),"-","");
		var vExpDt=ComReplaceStr(ComGetObjValue(formObj.p_end_evnt_dt),"-","");
		/* Duration Date Validation(p_str_evnt_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("MNR00172", "Start Date");
			ComSetFocus(formObj.p_str_evnt_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "p_str_evnt_dt") {
			ComShowCodeMessage("MNR00172", "Start Date");
			ComSetFocus(formObj.p_str_evnt_dt);
			return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.p_str_evnt_dt) ) {
			ComShowCodeMessage("MNR00346");
			ComSetObjValue(formObj.p_str_evnt_dt,"");
			ComSetFocus(formObj.p_str_evnt_dt);
			return false;
		}
		/* Duration Date Validation(end_evnt_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("MNR00172", "End Date");
			ComSetFocus(formObj.p_end_evnt_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "p_end_evnt_dt") {
			ComShowCodeMessage("MNR00172", "End Date");
			ComSetFocus(formObj.p_end_evnt_dt);
			return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.p_end_evnt_dt) ) {
			ComShowCodeMessage("MNR00347");
			ComSetObjValue(formObj.p_end_evnt_dt,"");
			ComSetFocus(formObj.p_end_evnt_dt);
			return false;
		}
		/* Duration Date Validation(str_evnt_dt < end_evnt_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("MNR00346");
				if(eventObj == null) {
					ComSetObjValue(formObj.p_end_evnt_dt,"");
					ComSetFocus(formObj.p_end_evnt_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
		}
		return true;
    }
    /**
	 * Validating process for input form data
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //Retrieving
    				if (!checkDurationDate()) {
    					return false;
    				}
    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}
        return true;
	}
  	/**
	 * Clearing form elements<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			case "p_cust_cd":
				ComSetObjValue(formObj.p_cust_cd, 	"");
				ComSetObjValue(formObj.p_vndr_nm,  	"");
				ComSetFocus(formObj.p_cust_cd);
				break;
			default :	//do nothing
		}
	}
	/* End of developer's task */
