/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0930.js
*@FileTitle  : (Kor)CNTR Loading List (CLL) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
*/
 /****************************************************************************************
  	Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var state="";
var dirtyFlg = "N";

//Event handler processing by button click event
document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/** If sheets are more than 2 in one tab, use additional sheet variables *** */
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		
		try {
			var srcName= ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch(srcName){
			case "btn_EDISend":
//				if(formObject.dirty_flg.value == 'Y' && confirm(ComGetMsg("BKG00824"))){
//					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
//        		}
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
				break;
			case "btn_finalEDISend":
//				if(formObject.dirty_flg.value == 'Y' && confirm(ComGetMsg("BKG00824"))){
//					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
//        		}
				// When Final EDI Sending, Flag='Y'
				formObject.in_final_edi_flg.value="Y";
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
				break;
			case "btn_CopyTsPodMlbDel":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND02);
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
				break;
			case "btn_Delete":
				doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
				break;
			case "btn_Retrieve":
				if(formObject.in_bl_cll_data.value !="BL" && formObject.dirty_flg.value == 'Y' && confirm(ComGetMsg("BKG00824"))){
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
        		}
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_New":
				formObject.reset();
				sheetObjects[0].RemoveAll();
				formObject.in_vvd_cd.focus();				
				break;
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_DownExcel":
				if(sheetObjects[0].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
        	    } else{
        	    	doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
        	    }
				break;
			case "btn_PrintPreview":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND03);
				break;
			case "btn_Summary":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND04);
				break;
			case "btn_Special_CGO":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND05);
				break;
			}// end switch
		}catch(e){
			if(e == "[object Error]"){
				ComShowMessage(OBJECT_ERROR);
			}else{
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage(){
		for(i=0; i < sheetObjects.length; i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		document.form.in_vvd_cd.focus();
		initControl();
		doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
		if(document.form.pop_mode.value == "VGM"){
			if(document.form.lcl_ts.value == "LC"){
				document.form.in_cll_type_tmp[0].checked = true;
			}else if(document.form.lcl_ts.value == "TS"){
				document.form.in_cll_type_tmp[1].checked = true;
			}
			document.form.bkg_no_list.value = opener.form.bkg_no_list.value;
			document.form.in_vvd_cd.value = document.form.vgm_vvd.value;
			document.form.in_pol_cd.value = document.form.vgm_pol.value;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	/**
	 * loading event of HTML Control<br>
	 * initializing IBSheet Object <br>
	 * @param sheetObj
	 * @param sheetNo
	 */ 
	function initControl(){
		DATE_SEPARATOR="-";
		var formObject = document.form;
		
		axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - focus out
		axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - focus iin
		
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		
		ComBtnDisable("btn_CopyTsPodMlbDel");
		ComBtnDisable("btn_PrintPreview");
		ComBtnDisable("btn_Summary");
		ComBtnDisable("btn_Special_CGO");
		ComBtnDisable("btn_EDISend");
		ComBtnDisable("btn_finalEDISend");
	}

	
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 * @param sheetObj 
	 * @param sheetNo
	 */
	function initSheet(sheetObj, sheetNo){
		var cnt=0;
		var sheetId=sheetObj.id;
		switch(sheetId){
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="|Seq.|Sel.|Container No.|TP|F/M|Seal No.|Weight|Weight|VGM|VGM|VGM\nTP|R/D|TS|Special Cargo|Special Cargo|Stow|BS|MP|SG|LQ|POD|POD|MLB|E.POD|A.POD|T/S VVD|T/S VSL NM|BKG No.|B/L No.|VVD|VVD|VVD|POL|POL|Ov L|Ov W|Ov H|PC|UN No|IMDG|Temp|Vent|HTS Code|HS Code||SIGNATORY";
				
				var headCount=ComCountHeadTitle(HeadTitle1);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:12, DataRowMerge:0 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"select_row" },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11,  AcceptKeys: "N|E", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,   AcceptKeys: "N|E", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mty_bkg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,   AcceptKeys: "E", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"seal_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15,  AcceptKeys: "N|E", InputCaseSensitive: 1 },
				             {Type:"Int",       Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bl_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys: "N" },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys: "N" },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vgm_wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vgm_doc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,   AcceptKeys: "E", InputCaseSensitive: 1  },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ts_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,   AcceptKeys: "E", InputCaseSensitive: 1  },
				             {Type:"Text",      Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:"cll_rmk1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100, AcceptKeys: "E|[0123456789-.,/: %()]", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cll_rmk2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100, AcceptKeys: "E|[0123456789-.,/: %()]", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4,   AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3,   AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mrn_polut_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,   AcceptKeys: "N", InputCaseSensitive: 1  },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4,   AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"lq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,   AcceptKeys: "E", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,   AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,   AcceptKeys: "E|N", InputCaseSensitive: 1},
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"blck_stwg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3,   AcceptKeys: "N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"edi_pod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3,   AcceptKeys: "E", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"a_pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,   AcceptKeys: "E|N", InputCaseSensitive: 1},
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ts_vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9,   AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:150,   Align:"left",  ColMerge:0,   SaveName:"ts_vsl_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,  EditLen:50,  InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13,  AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13,  AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4,   AcceptKeys: "E|N", InputCaseSensitive: 1},
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4,   AcceptKeys: "E|N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,   AcceptKeys: "E", InputCaseSensitive: 1},
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5,   AcceptKeys: "E|N", InputCaseSensitive: 1},
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2,   AcceptKeys: "E|N", InputCaseSensitive: 1},
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ovr_len_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12,  AcceptKeys: "N|[-.]", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ovr_wgt_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12,  AcceptKeys: "N|[-.]", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ovr_hgt_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12,  AcceptKeys: "N|[-.]", InputCaseSensitive: 1 },
//				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"min_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7,   AcceptKeys: "N", InputCaseSensitive: 1 },
//				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"max_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7,   AcceptKeys: "N", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"kr_tml_prct_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,   AcceptKeys: "E", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4,   AcceptKeys: "N|[-.]", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3,   AcceptKeys: "N|[-.]", InputCaseSensitive: 1 },
				             {Type:"Float",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cdo_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7,   AcceptKeys: "N|[-.]", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vent_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3,   AcceptKeys: "N|[-.]", InputCaseSensitive: 1 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_pol_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"esig_co_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
					InitColumns(cols);
					SetEditable(1);
					SetSheetHeight(310);
					SetCountPosition(0);
				}
			break;
		case "sheet2":
			with(sheetObj){
				var HeadTitle1="|val";
				var headCount=ComCountHeadTitle(HeadTitle1);
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"val",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(300);
			}
		break;
		}
	}
	
	/**
	 * Post-searh processing 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(){
		var sheetObj = sheetObjects[0];
		var inCllType = document.form.in_cll_type.value;
		if(inCllType == "LOCAL"||inCllType == "EMPTY"){
			sheetObj.SetColEditable("ts_flg",0);
		}else if(inCllType=="TS"){
			sheetObj.SetColEditable("ts_flg",1);
		}
	}
	
	/**
	* handling sheet process
	* @param sheetObj Sheet
	* @param formObj 
	* @param sAction 
	*/
	function doActionIBSheet(sheetObj, formObj, sAction, Row, Col){
		sheetObj.ShowDebugMsg(false);
		switch(sAction){
			case SEARCH01: // STWG Code valid check
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0930GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				ComOpenWait(false);
			break;
			
			case IBSEARCH: //search
				if(!validateForm(sheetObj, formObj, sAction))
					return;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				
//				if(formObj.in_cll_type_tmp[0].checked)
//					formObj.in_cll_type.value="CLL";
//				else 
				if(formObj.in_bl_cll_data_tmp[0].checked)
						formObj.in_bl_cll_data.value="BL";
				else if(formObj.in_bl_cll_data_tmp[1].checked)
						formObj.in_bl_cll_data.value="CLL";
				
				if(formObj.in_cll_type_tmp[0].checked)
						formObj.in_cll_type.value="LOCAL";
				else if(formObj.in_cll_type_tmp[1].checked)
						formObj.in_cll_type.value="TS";
				else if(formObj.in_cll_type_tmp[2].checked)
						formObj.in_cll_type.value="EMPTY";
				
				if(formObj.in_bkg_sts_cd_tmp[0].checked)
					formObj.in_bkg_sts_cd.value="";
				else if(formObj.in_bkg_sts_cd_tmp[1].checked)
						formObj.in_bkg_sts_cd.value="F";
				else if(formObj.in_bkg_sts_cd_tmp[2].checked)
						formObj.in_bkg_sts_cd.value="W";
				
				if(formObj.in_cntr_cfm_flg_tmp[0].checked)
					formObj.in_cntr_cfm_flg.value="";
				else if(formObj.in_cntr_cfm_flg_tmp[1].checked)
							formObj.in_cntr_cfm_flg.value="Y";
				else if(formObj.in_cntr_cfm_flg_tmp[2].checked)
						formObj.in_cntr_cfm_flg.value="N";
				var sXml =sheetObj.GetSearchData("ESM_BKG_0930GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml, {Sync:1} );
				ComEtcDataToForm(formObj, sheetObj);
				state = sheetObj.GetEtcData("TRANS_RESULT_KEY");
								
				if(state == "S" || state == undefined){
					var d2=0;
					var d4=0;
					var d5=0;
					var d7=0;
					var d8=0;
					var d9=0;
					var dw=0;
					var dx=0;
					var r2=0;
					var r4=0;
					var r5=0;
					var f2=0;
					var f4=0;
					var f5=0;
					var o2=0;
					var o4=0;
					var o5=0;
					var s2=0;
					var s4=0;
					var t2=0;
					var t4=0;
					var a2=0;
					var a4=0;
					var p2=0;
					var p4=0;
					var z2=0;
					var z4=0;
					var d3=0;
					var r9=0;
					var etc=0;
					var totalTpSize=0;
					var local=0;
					var localFull=0;
					var localEmpty=0;
					var ts=0;
					var tsFull=0;
					var tsEmpty=0;
					var wgt=0;
					var vgm=0;
					for( var i=1; i <= sheetObj.RowCount(); i++){
						
						if(sheetObj.GetCellValue(i, "seq") == ""){
							sheetObj.SetRowEditable(i,0);
						}
						if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D2"){
							d2=d2 + 1;
							totalTpSize=totalTpSize + 1;
							wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
							vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D4"){
								d4=d4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D5"){
								d5=d5 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D7"){
								d7=d7 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D8"){
								d8=d8 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D9"){
								d9=d9 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "DW"){
								dw=dw + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "DX"){
								dx=dx + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R2"){
								r2=r2 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R4"){
								r4=r4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R5"){
								r5=r5 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "F2"){
								f2=f2 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "F4"){
								f4=f4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "F5"){
								f5=f5 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "O2"){
								o2=o2 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "O4"){
								o4=o4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "O5"){
								o5=o5 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "S2"){
								s2=s2 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "S4"){
								s4=s4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "T2"){
								t2=t2 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "T4"){
								t4=t4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "A2"){
									a2=a2 + 1;
									totalTpSize=totalTpSize + 1;
									wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
									vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "A4"){
								a4=a4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "P2"){
								p2=p2 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "P4"){
								p4=p4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "Z2"){
								z2=z2 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "Z4"){
								z4=z4 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D3"){
								d3=d3 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R9"){
								r9=r9 + 1;
								totalTpSize=totalTpSize + 1;
								wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
								vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
						}
						else { 
								if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") != ""){
									etc=etc + 1;
									totalTpSize=totalTpSize + 1;
									wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
									vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
						}
						if(formObj.in_cll_type.value == "TS"){
							if(sheetObj.GetCellValue(i, "seq") != "")
							{
								ts=ts + 1;
								if(sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
									tsFull=tsFull + 1;
								else
									tsEmpty=tsEmpty + 1;
							}
						}
						else{
							if(sheetObj.GetCellValue(i, "ts_flg") == "TS" || sheetObj.GetCellValue(i, "ts_flg") == "TT")
							{
								ts=ts + 1;
								if(sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
									tsFull=tsFull + 1;
								else
									tsEmpty=tsEmpty + 1;
							}
							if(sheetObj.GetCellValue(i, "ts_flg") == "" && sheetObj.GetCellValue(i, "seq") != "")
							{
								local=local + 1;
								if(sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
									localFull=localFull + 1;
								else
									localEmpty=localEmpty + 1;
								}
							}
					}
					formObj.d2.value=d2;
					formObj.d4.value=d4;
					formObj.d5.value=d5;
					formObj.d7.value=d7;
					formObj.d8.value=d8;
					formObj.d9.value=d9;
					formObj.dw.value=dw;
					formObj.dx.value=dx;
					formObj.r2.value=r2;
					formObj.r4.value=r4;
					formObj.r5.value=r5;
					formObj.f2.value=f2;
					formObj.f4.value=f4;
					formObj.f5.value=f5;
					formObj.o2.value=o2;
					formObj.o4.value=o4;
					formObj.o5.value=o5;
					formObj.s2.value=s2;
					formObj.s4.value=s4;
					formObj.t2.value=t2;
					formObj.t4.value=t4;
					formObj.a2.value=a2;
					formObj.a4.value=a4;
					formObj.p2.value=p2;
					formObj.p4.value=p4;
					formObj.z2.value=z2;
					formObj.z4.value=z4;
					formObj.d3.value=d3;
					formObj.r9.value=r9;
					formObj.etc.value=etc;
					formObj.totalTpSize.value=totalTpSize;
					formObj.local.value=local;
					formObj.localFull.value=localFull;
					formObj.localEmpty.value=localEmpty;
					formObj.ts.value=ts;
					formObj.tsFull.value=tsFull;
					formObj.tsEmpty.value=tsEmpty;
					formObj.wgt.value=wgt;
					formObj.wgt.value=ComGetMaskedValue(formObj.wgt.value, 'int');
					formObj.vgm.value=vgm;
					formObj.vgm.value=ComGetMaskedValue(formObj.vgm.value, 'int');
					
					var rowCnt=sheetObjects[0].RowCount();
					if(rowCnt == 0){
						ComBtnDisable("btn_CopyTsPodMlbDel");
						ComBtnDisable("btn_PrintPreview");
						ComBtnDisable("btn_Summary");
						ComBtnDisable("btn_Special_CGO");
						ComBtnDisable("btn_EDISend");
						ComBtnDisable("btn_finalEDISend");
					}
					else{
						ComBtnEnable("btn_CopyTsPodMlbDel");
//						if(formObj.in_cll_type_tmp[0].checked){
						if(formObj.in_bl_cll_data_tmp[1].checked){
							ComBtnEnable("btn_PrintPreview");
							ComBtnEnable("btn_Summary");
							if(!formObj.in_cll_type_tmp[2].checked){
								ComBtnEnable("btn_Special_CGO");
							}
							ComBtnEnable("btn_EDISend");
							ComBtnEnable("btn_finalEDISend");
						}else{
							ComBtnDisable("btn_PrintPreview");
							ComBtnDisable("btn_Summary");
							ComBtnDisable("btn_Special_CGO");
							ComBtnDisable("btn_EDISend");
							ComBtnDisable("btn_finalEDISend");
						}
					}					
					sheetObjects[0].CheckAll("select_row",1);
					document.form.wgt.value=ComGetMaskedValue(document.form.wgt.value, 'int');
					
				}				
				formObj.dirty_flg.value = "N";
				ComOpenWait(false);
			break;
			
			case IBSAVE: // save
				if(!validateForm(sheetObj, formObj, sAction))
					return;
				sheetObj.SetWaitImageVisible(0);
				//ComOpenWait(true);
				formObj.f_cmd.value=MULTI;

//				if(formObj.in_cll_type_tmp[0].checked)
//					formObj.in_cll_type.value="CLL";
//				else 
				if(formObj.in_bl_cll_data_tmp[0].checked)
					formObj.in_bl_cll_data.value="BL";
				else if(formObj.in_bl_cll_data_tmp[1].checked)
					formObj.in_bl_cll_data.value="CLL";
			
				if(formObj.in_cll_type_tmp[0].checked)
					formObj.in_cll_type.value="LOCAL";
				else if(formObj.in_cll_type_tmp[1].checked)
					formObj.in_cll_type.value="TS";
				else if(formObj.in_cll_type_tmp[2].checked)
					formObj.in_cll_type.value="EMPTY";
			
				for( var i=1; i < sheetObj.RowCount()+ 1; i++){
					if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") != "" && sheetObj.GetCellValue(i, "ibflag") != "D"){
						sheetObj.SetCellValue(i, "ibflag","U");
					}
				}
//				sheetObj.DoSave("ESM_BKG_0930GS.do", FormQueryString(formObj));
				var sXml=sheetObj.GetSaveData("ESM_BKG_0930GS.do", FormQueryString(formObj) + "&" + sheetObj.GetSaveString());
				sheetObj.LoadSaveData(sXml,{Sync:1} );
				
				state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
				
				if(state == "S"){
					document.form.in_bl_cll_data_tmp[1].checked=true;
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}
				ComOpenWait(false);
			break;
			
			case IBDELETE: // delete
				if(!validateForm(sheetObj, formObj, sAction))
					return;
				for( var i=sheetObj.RowCount(); i >= 1; i--){
					if(sheetObj.GetCellValue(i, "select_row") == 1){
						sheetObj.SetRowHidden(i,1);
						sheetObj.SetRowStatus(i,"D");
					}
				}
				var vIsCheck=false;
				
				for( var i=1; i <= sheetObj.RowCount(); i++){
					if(sheetObj.GetCellValue(i, "select_row") == 0 && sheetObj.GetCellValue(i, "cntr_tpsz_cd") != ""){
						vIsCheck=true;
						break;
					}
				}
				
				if(!vIsCheck){
					for( var i=sheetObj.RowCount(); i >= 1; i--){
						sheetObj.SetRowHidden(i,1);
						if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") != "")
							sheetObj.SetRowStatus(i,"D");
					}
				}
				/*var delrows=sheetObj.FindCheckedRow("del_chk");
				 alert(delrows);
				var arrRow=delrows.split("|");
				 alert(arrRow);
				for( var i=0; i < arrRow.length - 1; i++){
					sheetObj.SetRowHidden(arrRow[i],1);
					sheetObj.SetRowStatus(arrRow[i],"D");
				}*/
				// }
				// alert("test4");
			break;
			
			case COMMAND01: // insert
				if(!validateForm(sheetObj, formObj, sAction))
					return;
				
				if(formObj.in_bl_cll_data_tmp[0].checked)
					formObj.in_bl_cll_data.value="BL";
				else if(formObj.in_bl_cll_data_tmp[1].checked)
					formObj.in_bl_cll_data.value="CLL";
				
				if(formObj.in_cll_type_tmp[0].checked)
					formObj.in_cll_type.value="LOCAL";
				else if(formObj.in_cll_type_tmp[1].checked)
					formObj.in_cll_type.value="TS";
				else if(formObj.in_cll_type_tmp[2].checked)
					formObj.in_cll_type.value="EMPTY";
				
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI01;
				var sXml=sheetObj.GetSaveData("ESM_BKG_0930GS.do", FormQueryString(formObj)+ "&" + sheetObj.GetSaveString(false,true,1));
				sheetObj.LoadSaveData(sXml,{Sync:1} );
				state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
//				if(state == "S"){
//					document.form.in_bl_cll_data_tmp[1].checked=true;
//					doActionIBSheet(sheetObj, document.form, IBSEARCH);
					
//				}else{
//					document.form.in_bl_cll_data_tmp[1].checked=true;
//					doActionIBSheet(sheetObj, document.form, IBSEARCH);
//				}
				document.form.in_bl_cll_data_tmp[1].checked=true;
				if(formObj.in_final_edi_flg.value=="Y"){
					formObj.in_final_edi_flg.value="N";
				}
				ComOpenWait(false);
			break;
			
			case COMMAND02: // insert
//				if(formObj.in_cll_type_tmp[0].checked)
//					formObj.in_cll_type.value="CLL";
				if(formObj.in_cll_type_tmp[0].checked)
						formObj.in_cll_type.value="LOCAL";
				else if(formObj.in_cll_type_tmp[1].checked)
						formObj.in_cll_type.value="TS";
				else if(formObj.in_cll_type_tmp[3].checked)
						formObj.in_cll_type.value="EMPTY";
				var sUrl="/opuscntr/ESM_BKG_1014.do?pgmNo=ESM_BKG_1014&inCllType=" + formObj.in_cll_type.value;
				ComOpenWindowCenter(sUrl, "ESM_BKG_1014", 400, 230, false);
			break;
			
			case COMMAND03: // �낅젰
				if(!validateForm(sheetObj, formObj, sAction))
					return;
				
				if(formObj.in_bkg_sts_cd_tmp[0].checked)
					formObj.in_bkg_sts_cd.value="";
				else if(formObj.in_bkg_sts_cd_tmp[1].checked)
						formObj.in_bkg_sts_cd.value="F";
				else if(formObj.in_bkg_sts_cd_tmp[2].checked)
					formObj.in_bkg_sts_cd.value="W";
				if(formObj.in_cntr_cfm_flg_tmp[0].checked)
						formObj.in_cntr_cfm_flg.value="";
				else if(formObj.in_cntr_cfm_flg_tmp[1].checked)
						formObj.in_cntr_cfm_flg.value="Y";
				else if(formObj.in_cntr_cfm_flg_tmp[2].checked)
						formObj.in_cntr_cfm_flg.value="N";
				
				var sUrl="/opuscntr/ESM_BKG_0931.do?pgmNo=ESM_BKG_0931&inVvdCd="+ formObj.in_vvd_cd.value 
						+ "&inPolCcd=" + formObj.in_pol_cd.value 
						+ "&inPolYdCd=" + formObj.in_pol_yd_cd.value 
						+ "&inCllType="	+ formObj.in_cll_type.value 
						+ "&inBkgStsCd=" + formObj.in_bkg_sts_cd.value 
						+ "&inCntrCfmFlg=" + formObj.in_cntr_cfm_flg.value 
						+ "&inSortType="+ formObj.in_sort_type.value 
						+ "&inBlCllData= "+ formObj.in_bl_cll_data.value
				
				ComOpenWindowCenter(sUrl, "ESM_BKG_0931", 1200, 600, false);
			break;
			
			case COMMAND04: // btn_Summary
				if(!validateForm(sheetObj, formObj, sAction))
					return;
				
				if(formObj.in_bkg_sts_cd_tmp[0].checked)
					formObj.in_bkg_sts_cd.value="";
				else if(formObj.in_bkg_sts_cd_tmp[1].checked)
						formObj.in_bkg_sts_cd.value="F";
				else if(formObj.in_bkg_sts_cd_tmp[2].checked)
						formObj.in_bkg_sts_cd.value="W";
				if(formObj.in_cntr_cfm_flg_tmp[0].checked)
						formObj.in_cntr_cfm_flg.value="";
				else if(formObj.in_cntr_cfm_flg_tmp[1].checked)
						formObj.in_cntr_cfm_flg.value="Y";
				else if(formObj.in_cntr_cfm_flg_tmp[2].checked)
						formObj.in_cntr_cfm_flg.value="N";
				var sUrl="/opuscntr/ESM_BKG_0932.do?pgmNo=ESM_BKG_0932&inVvdCd="
						+ formObj.in_vvd_cd.value + "&inPolCcd="
						+ formObj.in_pol_cd.value + "&inPolYdCd="
						+ formObj.in_pol_yd_cd.value + "&inCllType="
						+ formObj.in_cll_type.value + "&inBkgStsCd="
						+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
						+ formObj.in_cntr_cfm_flg.value + "&inSortType="
						+ formObj.in_sort_type.value;
				
				ComOpenWindowCenter(sUrl, "ESM_BKG_0932", 820,730, false);
				
			break;
			
			case COMMAND05: //btn_Special_CGO
				if(!validateForm(sheetObj, formObj, sAction))
					return;
				
				if(formObj.in_bkg_sts_cd_tmp[0].checked)
					formObj.in_bkg_sts_cd.value="";
				else if(formObj.in_bkg_sts_cd_tmp[1].checked)
						formObj.in_bkg_sts_cd.value="F";
				else if(formObj.in_bkg_sts_cd_tmp[2].checked)
						formObj.in_bkg_sts_cd.value="W";
				if(formObj.in_cntr_cfm_flg_tmp[0].checked)
						formObj.in_cntr_cfm_flg.value="";
				else if(formObj.in_cntr_cfm_flg_tmp[1].checked)
						formObj.in_cntr_cfm_flg.value="Y";
				else if(formObj.in_cntr_cfm_flg_tmp[2].checked)
						formObj.in_cntr_cfm_flg.value="N";
				var sUrl="/opuscntr/ESM_BKG_0933.do?pgmNo=ESM_BKG_0933&inVvdCd="
						+ formObj.in_vvd_cd.value + "&inPolCcd="
						+ formObj.in_pol_cd.value + "&inPolYdCd="
						+ formObj.in_pol_yd_cd.value + "&inCllType="
						+ formObj.in_cll_type.value + "&inBkgStsCd="
						+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
						+ formObj.in_cntr_cfm_flg.value + "&inSortType="
						+ formObj.in_sort_type.value
				ComOpenWindowCenter(sUrl, "ESM_BKG_0933", 1150, 600, false);
			break;
			
			case IBINSERT: // �낅젰
				sheetObj = sheetObjects[0];
				sheetObj.DataInsert(-1);
				formObj = document.form;
				var localTs = "";
				if(formObj.in_cll_type.value == "LOCAL"){
					localTs = "L";
					sheetObj.SetCellEditable(sheetObj.LastRow(),10,0);
				}else if(formObj.in_cll_type.value == "TS"){
					localTs = "T";
				}else if(formObj.in_cll_type.value == "EMPTY"){
					localTs = "E"
				    sheetObj.SetCellEditable(sheetObj.LastRow(),10,0);
				}
				var vvd = formObj.in_vvd_cd.value;
				sheetObj.SetCellValue(sheetObj.LastRow(),"select_row",1);
				sheetObj.SetCellValue(sheetObj.LastRow(),"wgt_ut_cd","K");
				sheetObj.SetCellValue(sheetObj.LastRow(),"vsl_cd",vvd.substr(0,4));
				sheetObj.SetCellValue(sheetObj.LastRow(),"skd_voy_no",vvd.substr(4,4));
				sheetObj.SetCellValue(sheetObj.LastRow(),"skd_dir_cd",vvd.substr(8,4));
				sheetObj.SetCellValue(sheetObj.LastRow(),"pol_cd",formObj.in_pol_cd.value);
				if(localTs=="E"){
					sheetObj.SetCellValue(sheetObj.LastRow(),"mty_bkg_cd","M");
				}else{
					sheetObj.SetCellValue(sheetObj.LastRow(),"mty_bkg_cd","F");
				}
			break;
				
			case IBDOWNEXCEL:
				var downRows="";
				if(validateForm(sheetObj, formObj, sAction)){
					for( var i=0; i <= sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") != "" && sheetObj.GetCellValue(i, "select_row") != 0){
							downRows=downRows + i + "|";
						}
					}
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							//sheetObj.Down2Excel(({ HiddenColumn:-1,TreeLevel:false}), "", false, "del_chk|del_chk", noRows); 2014.08.14 hannah lee
							sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj),DownRows:downRows, SheetDesign:1,Merge:1 });
						}
				}
				break;
			}
		}
		/**
		 * �붾㈃ �쇱엯�κ컪����븳 �좏슚�깃�利��꾨줈�몄뒪 泥섎━
		 * @param sheetObj Sheet
		 * @param formObj form媛앹껜
		 * @param sAction �묒뾽泥섎━肄붾뱶
		 */
		function validateForm(sheetObj, formObj, sAction){
			switch(sAction){
			case IBSEARCH: // 議고쉶
				// alert(formObj.vvd_cd.value);
				// alert(formObj.vps_eta_start_dt.value);
				if(formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9){
					ComShowCodeMessage('BKG00710');
					formObj.in_vvd_cd.focus();
					return false;
				}
				if(formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5){
					ComShowCodeMessage('BKG00711');
					formObj.in_pol_cd.focus();
					return false;
				}
				return true;
			break;
			
			case IBSAVE: // 議고쉶
				// alert(formObj.vvd_cd.value);
				// alert(formObj.vps_eta_start_dt.value);
				if(formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9){
					ComShowCodeMessage('BKG00710');
					formObj.in_vvd_cd.focus();
					return false;
				}
				if(formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5){
					ComShowCodeMessage('BKG00711');
					formObj.in_pol_cd.focus();
					return false;
				}
				for(var i=1;i <= sheetObj.RowCount(); i++){
					var cntrNo = sheetObj.GetCellValue(i,"cntr_no");
					if(cntrNo.substr(0,5) == "POL :"){
						continue;
					}
					for(var j=i; j <= sheetObj.RowCount(); j++){
						var cntrNoTmp = sheetObj.GetCellValue(j,"cntr_no");
						if(i == j || cntrNoTmp.substr(0,5) == "POL :"){
							continue;
						}
						if(cntrNo == cntrNoTmp){
							ComShowCodeMessage('BKG00965',cntrNoTmp);
							return false;
						}
					}
				}
				for(var i=1; i <= sheetObj.RowCount() ; i++){
					var cntrNo =  sheetObj.GetCellValue(i,"cntr_no")
					if(cntrNo.substr(0,5) == "POL :"){
						continue;
					}
					var type = sheetObj.GetCellValue(i,"cntr_tpsz_cd");
					
					if(type.length != 2){
						ComShowCodeMessage('BKG01183',cntrNo);
						return false;
					}
				}
				if(formObj.in_cll_type_tmp[1].checked){
					for(var i=1; i <= sheetObj.RowCount() ; i++){
						var cntrNo =  sheetObj.GetCellValue(i,"cntr_no")
						if(cntrNo.substr(0,5) == "POL :"){
							continue;
						}
						var tsFlg = sheetObj.GetCellValue(i,"ts_flg");
						if(tsFlg != "TS" && tsFlg != "TT"){
							ComShowCodeMessage('BKG01179');
							return false;
						}
					}
				}
				for(var i=1; i <= sheetObj.RowCount() ; i++){
					var cntrNo =  sheetObj.GetCellValue(i,"cntr_no")
					if(cntrNo.substr(0,5) == "POL :"){
						continue;
					}
					var vslCd = sheetObj.GetCellValue(i,"vsl_cd");
					var skdVoyNo = sheetObj.GetCellValue(i,"skd_voy_no");
					var skdDirCd = sheetObj.GetCellValue(i,"skd_dir_cd");
					if(vslCd.length != 4 || skdVoyNo.length != 4 || skdDirCd.length != 1){
						ComShowCodeMessage('BKG01184',cntrNo);
						return false;
					}
				}
				for(var i=1; i <= sheetObj.RowCount() ; i++){
					var cntrNo =  sheetObj.GetCellValue(i,"cntr_no")
					if(cntrNo.substr(0,5) == "POL :"){
						continue;
					}
					var polCd = sheetObj.GetCellValue(i,"pol_cd");
					if(polCd.length != 5){
						ComShowCodeMessage('BKG01185',cntrNo);
						return false;
					}
				}
				return true;
			break;
			
			case COMMAND01: // 議고쉶
				// alert(formObj.vvd_cd.value);
				// alert(formObj.vps_eta_start_dt.value);
				if(sheetObj.FindCheckedRow("select_row")==""){
					ComShowCodeMessage('BKG00249');
					return false;
				}
				if(formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9){
					ComShowCodeMessage('BKG00710');
					formObj.in_vvd_cd.focus();
					return false;
				}
				if(formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5){
					ComShowCodeMessage('BKG00711');
					formObj.in_pol_cd.focus();
					return false;
				}
				if(formObj.in_ktml_cd.value == ""){
					ComShowCodeMessage('BKG00763');
					formObj.in_ktml_cd.focus();
					return false;
				}
				if(formObj.in_rcv_id.value == ""){
					//ComShowCodeMessage('BKG00763');
					ComShowCodeMessage('BKG00767','Receiver');
					formObj.in_rcv_id.focus();
					return false;
				}
				if(formObj.in_edi_msg_tp.value == ""){
					//ComShowCodeMessage('BKG00763');
					ComShowCodeMessage('BKG00767','EDI Message Type');
					formObj.in_edi_msg_tp.focus();
					return false;
				}
				return true;
			break;
			
			case IBDELETE: // 議고쉶
				var vIsCheck=false;
				// alert(sheetObj.RowCount);
				if(!ComShowCodeConfirm("COM12188")){
					//alert();
					return false;
				}
				for( var i=1; i <= sheetObj.RowCount(); i++){
					if(sheetObj.GetCellValue(i, "select_row") == 1){
						vIsCheck=true;
						break;
					}
				}
				if(!vIsCheck){
					ComShowCodeMessage('BKG00249', '');
					return false;
				}
				return true;
			break;
				
			case IBDOWNEXCEL: // 議고쉶
				var vIsCheck=false;
				// alert(sheetObj.RowCount);
				for( var i=1; i <= sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i, "select_row") == 1){
							vIsCheck=true;
							break;
					}
				}
				if(!vIsCheck){
					ComShowCodeMessage('BKG00249', '');
					return false;
				}
				return true;
			break;
			
			case COMMAND03: // 議고쉶
				// alert(formObj.vvd_cd.value);
				// alert(formObj.vps_eta_start_dt.value);
				if(formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9){
					ComShowCodeMessage('BKG00710');
					formObj.in_vvd_cd.focus();
					return false;
				}
				if(formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5){
					ComShowCodeMessage('BKG00711');
					formObj.in_pol_cd.focus();
					return false;
				}
				return true;
			break;
			
			case COMMAND04: //btn_Summary
				// alert(formObj.vvd_cd.value);
				// alert(formObj.vps_eta_start_dt.value);
				if(formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9){
					ComShowCodeMessage('BKG00710');
					formObj.in_vvd_cd.focus();
					return false;
				}
				if(formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5){
					ComShowCodeMessage('BKG00711');
					formObj.in_pol_cd.focus();
					return false;
				}
				return true;
			break;
			
			case COMMAND05: // 議고쉶
				// alert(formObj.vvd_cd.value);
				// alert(formObj.vps_eta_start_dt.value);
				if(formObj.in_vvd_cd.value == "" || formObj.in_vvd_cd.value.length != 9){
					ComShowCodeMessage('BKG00710');
					formObj.in_vvd_cd.focus();
					return false;
				}
				if(formObj.in_pol_cd.value == "" || formObj.in_pol_cd.value.length != 5){
					ComShowCodeMessage('BKG00711');
					formObj.in_pol_cd.focus();
					return false;
				}
				return true;
				break;
			}
	}
			
	/**
	 * �앹뾽�붾㈃�먯꽌 遺�え李�議고쉶泥섎━
	 */
	function goSearch(){
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * �앹뾽�붾㈃�먯꽌 遺�え李쎌쓽 Sheet��start_index�먯꽌 end_index源뚯쓽 媛믪쓣 蹂�꼍
	 * @param start_index start_index
	 * @param end_index end_index
	 * @param ts ts
	 * @param pod pod
	 * @param mlb mlb
	 * @param yd yd
	 */
	function setData(start_index, end_index, ts, pod, mlb, yd){
		//alert(start_index+":"+end_index+":"+ts+":"+pod+":"+mlb+":"+del);
		for( var i=1; i <= sheetObjects[0].RowCount(); i++){
			if(sheetObjects[0].GetCellValue(i, "seq") * 1 >= start_index * 1 && sheetObjects[0].GetCellValue(i, "seq") * 1 <= end_index * 1)
			{
				if(ts != "")
					sheetObjects[0].SetCellValue(i, "ts_flg",ts);
				if(pod != "")
					sheetObjects[0].SetCellValue(i, "pod_cd",pod);
				if(mlb != "")
					sheetObjects[0].SetCellValue(i, "blck_stwg_cd",mlb);
				if(yd != "")
					sheetObjects[0].SetCellValue(i, "pol_yd_cd",yd);
			}
		}
	}
		/**
		 * �쒗듃 Change �대깽��
		 * @param sheetObj
		 * @param Row
		 * @param Col
		 * @param Value
		 * @return
		 */
	  function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObject=document.form;
	  	var stwgCd="";
	  	var sheetObj2=sheetObjects[1];
	  	var sheetObjRowCnt=sheetObj2.RowCount();
	  	if (sheetObj.ColSaveName(Col) == "stwg_cd") {
	  		stwgCd=sheetObj.GetCellValue(Row, "stwg_cd");
	  		var flag=false;
	  		for(var i=1; i<= sheetObjRowCnt; i++){
	  			if(stwgCd != '' && stwgCd == sheetObj2.GetCellValue(i, "val")){
	  				flag=true;
	  				break;
	  			}
	  		}
	  		if(!flag){
	  			ComShowCodeMessage('BKG01127');
	  			sheetObj.SetCellValue(Row, "stwg_cd","",0);
	  		}
	  	}
		if(sheetObj.ColSaveName(Col) == "ts_flg" && sheetObj.GetCellValue(Row,Col) != "" && formObject.in_cll_type.value == "TS"){		//ts_flg
  			if(sheetObj.GetCellValue(Row,Col) != "TS" && sheetObj.GetCellValue(Row,Col) != "TT"){
  				ComShowCodeMessage('BKG01179');
  				sheetObj.SetCellValue(Row,"ts_flg","");
  			}
	  	}
		if(sheetObj.ColSaveName(Col)== "rcv_term_cd" && sheetObj.GetCellValue(Row,Col) != ""){
	  		var RDTerm = sheetObj.GetCellValue(Row,Col);
	  		if(RDTerm.length != 2){
	  			ComShowCodeMessage('BKG01182');
	  			sheetObj.SetCellValue(Row,"rcv_term_cd","");
	  		}
	  	}
//		if(Col==4 && sheetObj.GetCellValue(Row,Col) != ""){
//	  		var tp = sheetObj.GetCellValue(Row,Col);
//	  		if(tp.length != 2){
//	  			ComShowCodeMessage('BKG01183');
//	  			sheetObj.SetCellValue(Row,Col,"");
//	  		}
//	  	}
	  	formObject.dirty_flg.value = "Y";
	  }