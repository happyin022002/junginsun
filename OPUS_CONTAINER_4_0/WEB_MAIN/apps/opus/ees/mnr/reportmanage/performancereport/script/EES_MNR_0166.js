/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0166.jsp
*@FileTitle  : Disposal Performance by Equipment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0166 : business script for EES_MNR_0166.
     */
   	/* developer job	*/
   	/* Sheet Select Back Color */
	var MNR_SELECT_BACK_COLOR=10092543;
	var MNR_TOTCOL_BACK_COLOR=15723503;
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick() {
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
     	try {
 			var srcObj = event.target || window.event.srcElement;
 			var srcName=ComGetEvent("name");
 			if(ComGetBtnDisable(srcName)) return false;
 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;
 				case "btn_New":
					ComResetAll();
					formObj.p_loc_cd.readOnly=true;
					formObj.p_loc_cd.className="input2";
					ComEnableObject(formObj.btns_search, false);
					ComSetFocus(formObj.p_str_evnt_dt);
					comboObjects[0].SetSelectIndex(0);
					comboObjects[1].SetSelectIndex(0);
					sheetObject.SetColHidden("part_amt",0);
					sheetObject.SetColHidden("cal_part_amt",1);
 					break;
             	case "btns_search":	//Form Location. retrieving popup
 					openPopup("1");
 					break;
 				case "btns_search2":	//retrieving Buyer popup
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
             				sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
             			}
					break;
				case "p_chk_usd":
					//var srcObj=document.getElementById("p_chk_usd");
					var viewFlag=srcObj.checked;
					sheetObject.SetColHidden("part_amt",viewFlag);
					sheetObject.SetColHidden("cal_part_amt",!viewFlag);
					break;
					
				case "btn_rulabel_cd":	//RU Label 조회 팝업
					var par_rulabel_type = form.hid_rulabel_type.value;
					var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
					var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
					ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true);		   
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * registering IBMultiCombo Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
		for(i=0; i < sheetObjects.length; i++) {
	        //
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i], i + 1);
	        //
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k + 1);
	    }
		var formObj=document.form;
     	/* IBMulti Combo Item Setting */
    	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
    	/* Axon Control Setting*/
    	initControl();
    	/* initial Focus Setting */
    	ComSetFocus(formObj.p_str_evnt_dt);
    	ComEnableObject(formObj.btns_search, false);
    }
    // Axon handling event
  	// 1. event catch
  	function initControl() {
//  		var formObj=document.form;
//  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
//		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 		
//		axon_event.addListenerForm('change',   		'obj_change',  	formObj); 
  	}
	//setting event duplicate
	var preEventType=null;
  	// 2. handling event -- Start
  	/**
	 * checking on HTML Control's onblur event.
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
	 * checking on HTML Control's focus event.
	 */
	function obj_focus() {
		var obj=ComGetEvent();
	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
	    } else {
	    	//clearing mask separator
		    ComClearSeparator(obj);
	    }
	}
	/**
	 * handling Change Event
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
    		case "p_eq_knd_cd":
    			if( ComTrim(obj.value) != "U"){
    				aset_knd.SetSelectIndex(0);
    				aset_knd.SetEnable(0);
    				
    				formObj.rstr_usg_lbl.value = "";
    				ComEnableObject(formObj.rstr_usg_lbl,false);
    				ComEnableObject(formObj.btn_rulabel_cd,false);
    			}else{
    				aset_knd.SetEnable(1);
    				
    				ComEnableObject(formObj.rstr_usg_lbl,true);
    				ComEnableObject(formObj.btn_rulabel_cd,true);
    			}
		}
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}

  	//2. handling event -- End
  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
    	var formObj=document.form;
		var sheetid=sheetObj.id;
		var cnt=0;
		switch(sheetid) {
			case "sheet1":
				  with(sheetObj){
				   var HeadTitle="Seq.|RHQ|Rquest\nOffice|Approval\nOffice|EQ Type|EQ No.|TP/SZ|Lessor|Term|RU Label Type|RU Label Value|Asset Kind|Status|Invoice No|User ID|Last Update|MNFR Date|Disposal No.|Sold Date|Buyer|Buyer"
				   + "|RCC|LCC|SCC|LOC|Yard|Disposal Kind|RPR Cost(USD)|Currency|Disposal\nAmount|Disposal\nAmount(USD)||Tariff Price||Verify Result";
				   var headCount=ComCountHeadTitle(HeadTitle);
				   (headCount, 9, 0, true);
	
				   SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, FrozenCol:9 } );
	
				   var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				   var headers = [ { Text:HeadTitle, Align:"Center"} ];
				   InitHeaders(headers, info);
	
				   var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no",           KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:180,   Align:"Left",  ColMerge:1,   SaveName:"lessor_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",  ColMerge:1,   SaveName:"rstr_usg_lbl_tp",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",  ColMerge:1,   SaveName:"rstr_usg_lbl_val",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"aset_knd",       KeyField:0,   CalcLogic:"",   Format:"" },
				             
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"disp_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",       KeyField:0,   CalcLogic:"",   Format:"" },

				             {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"manu_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd" },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",          KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"disp_sold_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"disp_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"disp_rsn_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Float",     Hidden:0,  Width:110,   Align:"Right",   ColMerge:1,   SaveName:"rpr_cost_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:"part_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
				             {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:"cal_part_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"disp_ut_prc",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
				             {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:"disp_trf_ut_prc",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"disp_vrfy_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"disp_vrfy_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"" } ];
				    
				   InitColumns(cols);
	
				   SetEditable(0);
				   SetCountFormat("[SELECTDATAROW / TOTALROWS]");
//				   SetColProperty(0, "disp_sold_dt", {Format:"####-##-##"} );
				   SetColHidden("cal_part_amt",1);
//				   SetSheetHeight(410);
				   resizeSheet( sheetObj );
			   }
				break;
		}
	}
	/**
	 * setting combo initial values and header
	 * param : comboObj, sheetNo
	 * adding case as numbers of counting combos
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "combo1":
	        	with(comboObj) {
	            	SetDropHeight(87);
	        	}
	        	break;
	    }
	}
	/**
	 * handling process for sheet
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
				//Disposal Kind Combo Item Setting
				//retrieving common combo.
				var sCondition=new Array (
					new Array("MnrGenCd","CD00038", "COMMON")	//DISP_RSN_CD
				   ,new Array("ComIntgCd","CD20098","COMMON")  // INTG_CD_ID
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//setting DISP_RSN_CD 
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						comboObjects[0].InsertItem(j,tempText[1] ,tempText[0]);
					}
				}
				comboObjects[0].InsertItem(0 , 'ALL','');
				comboObjects[0].SetSelectIndex(0);
				
				//setting INTG_CD_ID 
				if(comboList[1] != null){
					for(var j = 0; j < comboList[1].length;j++){
						var tempText = comboList[1][j].split("|");
						comboObjects[1].InsertItem(j,tempText[1] ,tempText[1]);
					}
				}
				comboObjects[1].InsertItem(0 , 'ALL','');
				comboObjects[1].SetSelectIndex(0);
				
				break;
			case IBSEARCH:			//retrieving
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("EES_MNR_0166GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchData(sXml,{Sync:0} );
						ComOpenWait(false);
						sheetObj.SetWaitImageVisible(1);
					}
				}
				break;
			case IBSEARCH_ASYNC01:	//retrieving Location 
 				if(validateForm(sheetObj,formObj,sAction)) {
 					
 					if ( sheetObj.id == "sheet1") {
 						
						var vLocType=formObj.p_loc_tp.value;
						var vLocCode=formObj.p_loc_cd.value;
 						var param="f_cmd="+SEARCH+"&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&loc_state=";
 						if(vLocType == "RCC") {
							param += "&loc_cd=&rcc_cd="+ vLocCode +"&lcc_cd=";
 						} else if(vLocType == "LCC") {
							param += "&loc_cd=&rcc_cd=&lcc_cd="+ vLocCode;
 						} else if(vLocType == "SCC") {//SCC is subset of LOC
							param += "&loc_cd="+ vLocCode +"&rcc_cd=&lcc_cd=";
 						}
 						sheetObj.WaitImageVisible = false;
 						
 						var sXml=sheetObj.GetSearchData("COM_ENS_051GS.do", param);
 						
 						//if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} ); // 비동기 처리
 						
						sheetObj.SetWaitImageVisible(1);
						
						//if ( ComGetTotalRows(sXml) < 1 ) {
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
 			case IBSEARCH_ASYNC02:	// retrieving Buyer Code
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vCustCntCd=formObj.p_cust_cd.value;
 						var param="f_cmd="+SEARCH+"&cust_cd="+ vCustCntCd.substr(0,2) +"&cust="+ vCustCntCd.substr(2);
 						sheetObj.WaitImageVisible = false;
 						var sXml=sheetObj.GetSearchData("COM_ENS_041GS.do", param);
 						
 						//if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} ); // 비동기 처리
 						
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
     * event after retrieving
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj=document.form;
    	}
    }
	/**
	 * combo1_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj=document.form;
		p_disp_rsn_cd.value=ComGetObjValue(comboObj);
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
     * Pop-up Open <br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row IBSheet Row index
     * @param Col IBSheet Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(formObj.p_loc_tp.value) {
    			case "RCC" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 610,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "LCC" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 610,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "SCC" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 610,"scc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	} else if(type == "2") {
    		ComOpenPopup('/opuscntr/COM_ENS_041.do', 780, 520, 'setPopData_BuyerCd', '1,0,1,1,1,1,1,1', true);
    	}
    	return;
    }
	/**
	 * (Service Provider) handling Pop-up Return Value<br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Sheet Array index
	 */
	function setPopData_BuyerCd(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.p_cust_cd.value=aryPopupData[0][3];
			formObj.p_vndr_nm.value=aryPopupData[0][4];
		}
	}
	/**
	 * handling Validation Duration Date<br>
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
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //retrieving
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
	 * handling Form Element Clear.<br>
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
	
	function ComToHtml2(obj){
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var str = getArgValue(obj);

            str = str.replace(/&/gi, "@amp;");
            return str;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	/* developer job */
