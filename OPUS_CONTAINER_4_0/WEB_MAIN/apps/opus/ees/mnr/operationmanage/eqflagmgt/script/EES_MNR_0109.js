/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0109.js
*@FileTitle  : Hanger Rack/Bar Installation/Uninstallation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
/****************************************************************************************
	  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
						COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class EES_MNR_0109 : EES_MNR_0109 - Defining a script used by screen
	 */
/* Developer's task	*/
/* ********* General Functions ************* */
	// Common global variable
	var tabObjects=new Array();
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="";
	var uTpSz=new Array();
	var gTpSz=new Array();
	var zTpSz=new Array();
	var excelLoadFlg = "N";
	var appendPageNo = 1;
   	var appendCondParam = "";
   	var rtv_total = 0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
	 function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheet2=sheetObjects[0];
		var sheet1=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheet1,formObject,IBSEARCH);
					break;
				case "btn_more":
	                doActionIBSheet1(sheet1, formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
	                break;
				case "btn_new":
					doActionIBSheet(sheet2,formObject,IBCLEAR);
					break;
				case "btn_save":
					doActionIBSheet(sheet1, formObject, IBSAVE);
					break;
		        case "btns_popup":
                    ComOpenPopup('/opuscntr/COM_ENS_061.do', 766, 450, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                    break;
		        case "btns_req_multy2":
                    rep_Multiful_inquiry("eq_no");
                    break;
		        case "btns_req_multy":
                    rep_Multiful_inquiry("eq_tpsz_cd");
					break;
				case "btn_downexcel":
					doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
					break;
				case "btn_loadexcel":
					sheet1.RemoveAll();
					sheet1.LoadExcel();
					break;
		        case "eq_no_multi":
                    rep_Multiful_inquiry("eq_list");
                    break;
				case "btns_search":	//Form Location. Calling Retrieve pop-up
					if(p_loc_tp.GetSelectCode()!= "ALL"){
						openPopup("1");
					}
 					break;
				case IBDOWNEXCEL:
					if(sheet1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
					}
					break;
					
				case "btn_rulabel_cd":	//RU Label 조회 팝업
					var par_rulabel_type = form.hid_rulabel_type.value;
					var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
					var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
					ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true); 
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
	/**
	 * Sheet default setting and initializing
	 * To implement for onload event of body tag
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {
		MnrWaitControl(true);
		initControl();
		initSheet(sheetObjects[0],"sheet2");
		ComConfigSheet (sheetObjects[1]);
		initSheet(sheetObjects[1],"sheet1");
		ComEndConfigSheet(sheetObjects[1]);
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
		setTpSzArray(sheetObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	/**
	 * Assigning array of IBSheet object
	 * Array defined at the top of the source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * Initializing of multi combo type
	 * @return
	 */
	function initCombo(comboObj, comboNo) {
		var formObject=document.form
		switch(comboNo) {
			case 3:
			    with (comboObj) {
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "130");
					SetDropHeight(200);
			    }
	        	break;
	    }
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj,sheetType) {
		var cnt=0;
		switch(sheetType) {
		case "sheet1":      		// sheet1 init
		    with(sheetObj){
				var HeadTitle1="|Seq.|EQ No.|TP/SZ|MVMT|Yard|Flag|RU Label Type|Hanger Rack\nType|Tariff Type|Tariff\nDesc|Hanger Bar\nType|Installation\nBar Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Remark(s)|Recently Worked\nInfomation|Inventory apply\nOffice|Flag Date";
				var HeadTitle2="|Seq.|EQ No.|TP/SZ|MVMT|Yard|Flag|RU Label Type|Hanger Rack\nType|Tariff Type|Tariff\nDesc|Hanger Bar\nType|Installation\nBar Qty|Sound|Repairable|Missing|disposal|Remark(s)|Recently Worked\nInfomation|Inventory apply\nOffice|Flag Date";
				var headCount=ComCountHeadTitle(HeadTitle1) + 6;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mnr_hngr_flg_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"mnr_hngr_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Left",  ColMerge:1,   SaveName:"rstr_usg_lbl_tp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_trf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_trf_otr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_hngr_bar_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"hngr_bar_atch_knt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"act_invt_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mnr_hngr_dmg_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mnr_lost_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"mnr_disp_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"wo_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"cre_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnr_hngr_flg_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnr_ord_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnr_ord_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"copy_row_num",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
   
				InitColumns(cols);
//				SetSheetHeight(380);
				SetEditable(1);
				SetShowButtonImage(2);
				SetSelectionMode(smSelectionRow);
				resizeSheet( sheetObj );
	      	}
			break;
		case "sheet2":
		    with(sheetObj){
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				var headers = [ { Text:"", Align:"Center"}];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"recent_hngr_bar_atch_knt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_hngr_bar_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_hngr_trf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_hngr_trf_otr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_act_invt_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_hngr_dmg_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_lost_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_disp_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tmp_mnr_sts_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetVisible(0);
				SetEditable(0);
				SetRowHidden(0, 1);
	            }
			break;
		}
	}
	/**
     * Processing of sheet process
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:        //Initializing
			MnrWaitControl(true);
		    sheetObj.SetWaitImageVisible(0);
			//Initializing sheet
			for(i=0;i < sheetObjects.length;i++){
				sheetObjects[i].RemoveAll();
	        }
			//Initializing combo
			for(var i=0; i < comboObjects.length;i++){
				comboObjects[i].SetSelectCode(0);
				comboObjects[i].RemoveAll();
			}
			//Setting combo value
			var sCondition=new Array (
				//MULTICOMBO
				new Array("MnrGenCd","CD00061", "COMMON"),   //Location By
				new Array("MnrGenCd","","CUSTOM9"),		     //EQ_TYPE
				new Array("MnrGenCd","CD00093", "COMMON"),   //Search Bound Type
				//MULTICOMBO  + SHEETCOMBO
				new Array("MnrGenCd","CD00092", "COMMON"),   //Tariff Type
				new Array("MnrGenCd","CD00021", "COMMON"),   //Hanger Rack Type
				new Array("MnrGenCd","CD00022", "COMMON"),   //Hanger Bar Type
				new Array("MnrGenCd","CD00023", "COMMON")    //Amend Type
			)
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			//*** Location By
			var comboDefValue="";
			if(comboList[0] != null){
				p_loc_tp.InsertItem(0, 'ALL' ,'ALL');
				for(var j=1; j < comboList[0].length + 1;j++){
					var tempText=comboList[0][j - 1].split("|");
					p_loc_tp.InsertItem(j, tempText[1] ,tempText[0]);
				}
			}
			p_loc_tp.SetSelectCode("ALL");
			//*** EQ_TYPE
			if(comboList[1] != null){
				for(var j=0; j < comboList[1].length;j++){
					var tempText=comboList[1][j].split("|");
					eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}
			}
			eq_knd_cd.SetSelectCode('U');
			eq_knd_cd.SetEnable(0);
			//*** Search Bound Type
			if(comboList[2] != null){
				bound_tp_cd.InsertItem(0, 'ALL' ,'ALL');
				for(var j=1; j < comboList[2].length + 1;j++){
					var tempText=comboList[2][j - 1].split("|");
					bound_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}
			}
			
			bound_tp_cd.SetSelectCode("ALL");
			//*** Tariff Type
			if(comboList[3] != null){
				mnr_hngr_trf_cd.InsertItem(0, 'ALL' ,'ALL');
				for(var j=1; j < comboList[3].length + 1;j++){
					var tempText=comboList[3][j - 1].split("|");
					mnr_hngr_trf_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}
			}
			mnr_hngr_trf_cd.SetSelectCode("ALL");
			//*** Hanger Rack Type
			if(comboList[4] != null){
				mnr_hngr_rck_cd.InsertItem(0, 'ALL' ,'ALL');
				for(var j=1; j < comboList[4].length + 1;j++){
					var tempText=comboList[4][j - 1].split("|");
					mnr_hngr_rck_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}
			}
			mnr_hngr_rck_cd.SetSelectCode("ALL");
			//*** Hanger Bar Type
			if(comboList[5] != null){
				mnr_hngr_bar_tp_cd.InsertItem(0, 'ALL' ,'ALL');
				for(var j=1; j < comboList[5].length + 1;j++){
					var tempText=comboList[5][j - 1].split("|");
					mnr_hngr_bar_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}
			}
			mnr_hngr_bar_tp_cd.SetSelectCode("ALL");
			var sheetComboText="";
			var sheetComboCode="";
			var sheetComboDefault=new Array();
			var comboSaveNames=new Array();
			comboSaveNames[0]="mnr_hngr_trf_cd";
			comboSaveNames[1]="mnr_hngr_rck_cd";
			comboSaveNames[2]="mnr_hngr_bar_tp_cd";
			for(var i=3; i < comboList.length;i++){
			 	if(comboList[i] != null){
					sheetComboText="";
					sheetComboCode="";
					sheetComboDefault="";
			 		for(var j=0; j < comboList[i].length;j++){
						var tempText=comboList[i][j].split("|");
						if(comboSaveNames[i - 3] == "mnr_hngr_rck_cd" && tempText[0] == "A"){
							sheetComboDefault[i - 3]="R";
							continue;
						}
						sheetComboText +=  tempText[1] + "|";
						sheetComboCode +=  tempText[0] + "|";
						if(j == 0){
							sheetComboDefault[i - 3]=tempText[0];
						}
					}
					sheetComboCode=MnrDelLastDelim(sheetComboCode);
			     	sheetComboText=MnrDelLastDelim(sheetComboText);
					sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 3], sheetComboText, sheetComboCode ,sheetComboDefault[i - 3]);
				}
			}
			formObj.eq_list.value="";
			formObj.rstr_usg_lbl.value="";
			excelLoadFlg = "N";
			rtv_total = 0;
			formObj.pagerows.value=10000;
			sheetObj.SetWaitImageVisible(1);
			MnrWaitControl(false);
			ComBtnDisable("btn_more");
            break;
		case IBSEARCH:      //Retrieving
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait1(true);
				var formObj=document.form;
				formObj.mnr_flg_tp_cd.value=coMnrFlgHangerTypeCd;
				formObj.f_cmd.value=SEARCH;
					
				rowTotal = 0;
				rtv_total=rowTotal;					
				if(Number(rowTotal) > formObj.pagerows.value) {
					ComBtnEnable("btn_more");
				}else{
					ComBtnDisable("btn_more");
				}
					
				appendPageNo=1;
				appendCondParam = FormQueryString(formObj);	
				sheetObj.DoSearchFx("EES_MNR_0109GS.do",FormQueryString(formObj) );
//				var sXml = sheetObj.GetSearchData("EES_MNR_0109GS.do",FormQueryString(formObj));
//				sheetObj.LoadSearchData(sXml);

				excelLoadFlg = "N";
			}
			break;
		case IBSAVE:        //Saving
			if(validateForm(sheetObj,formObj,sAction)){
			   	formObj.mnr_flg_tp_cd.value=coMnrFlgHangerTypeCd;
			   	formObj.excel_load_flg.value = excelLoadFlg;
				formObj.f_cmd.value=MULTI;
				var sParam=sheetObj.GetSaveString(false, false);
				sParam=ComSetPrifix(sParam,"sheet1_");
				//ComDebug(sParam);
		    	if(sParam == "" && sheetObj.IsDataModified()){
					return;
				}
				if(!sheetObj.IsDataModified()){
					return;
				}
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("EES_MNR_0109GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
			}
			break;
		case IBDOWNEXCEL:
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			}
			break;
		}
	}
	
	/**
     * handling process for Sheet
     */    
    function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
    	switch(sAction) {
    	case IBSEARCHAPPEND:
    		if(!validateForm(sheetObj,formObj,sAction)) return;
    		ComOpenWait(true);
			sheetObj.SetWaitImageVisible(0);				
			sheetObj.DoSearch("EES_MNR_0109GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
	        
			break;
    	}
    }
	/**
	 * Validating process for input form data
	 */
	function validateForm(sheetObj,formObj,sAction){
		if(sAction==IBSAVE) {
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
				if(sheetObj.GetRowStatus(i)=="U" || excelLoadFlg == "Y"){
					if(sheetObjects[1].GetCellValue(i,  "mnr_hngr_rck_cd") == ""){
						ComShowCodeMessage("MNR00003","Hanger Rack Type");
						sheetObj.SelectCell(i, "mnr_hngr_rck_cd",true);
						return false;
					}
					if(sheetObjects[1].GetCellValue(i,  "mnr_hngr_bar_tp_cd") == ""){
						ComShowCodeMessage("MNR00003","Hanger Bar Type");
						sheetObj.SelectCell(i, "mnr_hngr_bar_tp_cd",true);
						return false;
					}
					if(sheetObjects[1].GetCellValue(i,  "mnr_hngr_trf_cd") == ""){
						ComShowCodeMessage("MNR00003","Mnr_Hngr_Trf_Cd");
						sheetObj.SelectCell(i, "mnr_hngr_trf_cd",true);
						return false;
					}
					if (sheetObj.GetCellValue(i,"mnr_hngr_flg") =="0") {
						//Checking install qty
						var hngrBarAtchKnt=parseInt(sheetObj.GetCellValue(i,"hngr_bar_atch_knt"));
						var actInvtQty=parseInt(sheetObj.GetCellValue(i,"act_invt_qty"));
						var mnrHngrDmgQty=parseInt(sheetObj.GetCellValue(i,"mnr_hngr_dmg_qty"));
						var mnrLostHngrQty=parseInt(sheetObj.GetCellValue(i,"mnr_lost_hngr_qty"));
						var mnrDispHngrQty=parseInt(sheetObj.GetCellValue(i,"mnr_disp_hngr_qty"));
						if(hngrBarAtchKnt != (actInvtQty + mnrHngrDmgQty + mnrLostHngrQty + mnrDispHngrQty)){
							ComShowCodeMessage("MNR00356");
							sheetObj.SelectCell(i, "act_invt_qty",true);
							return false;
						}
					} else {
						if (sheetObj.GetCellValue(i,"hngr_bar_atch_knt") == "0") {
							ComShowCodeMessage("MNR00359");
							sheetObj.SelectCell(i, "hngr_bar_atch_knt",true);
							return false;
						}
					}
					
					if(excelLoadFlg == "Y"){
						var dup = sheetObj.ColValueDup("eq_no");
						if(dup > 0){
							ComShowCodeMessage("MNR00006", dup + " row [" + sheetObj.GetCellValue(dup, "eq_no")+"] ");
							sheetObjects[1].SelectCell(dup, "eq_no", false);
							return false;
						}
						
						if(sheetObj.GetCellValue(i, "mnr_hngr_flg") == "0"){
							ComShowCodeMessage("MNR00377");
							sheetObj.SelectCell(i, "mnr_hngr_flg", false);
							return false;
						}
						
//						if(sheetObj.GetCellValue(i, "mnr_hngr_flg_dt") == "")
					}
				}
			}
			return true;
		} else if(sAction==IBSEARCH) {
			if(formObj.eq_list.value == ""){
				if(p_loc_tp.GetSelectText() == "ALL"){
					ComShowCodeMessage("MNR00084");
					return false;
				}
				if(formObj.p_loc_cd.value == "" || eq_tpsz_cd.GetSelectCode()== ""){
					ComShowCodeMessage("MNR00360");
					return false;
				}
			}
			return true;
		} else if(sAction==IBSEARCHAPPEND) {
			if(formObj.eq_list.value == ""){
				if(p_loc_tp.GetSelectText() == "ALL"){
					ComShowCodeMessage("MNR00084");
					return false;
				}
				if(formObj.p_loc_cd.value == "" || eq_tpsz_cd.GetSelectCode()== ""){
					ComShowCodeMessage("MNR00360");
					return false;
				}
			}
			return true;
		}
	}
	/********** Event Functions Start ************* */
	/**
	 * Event handler of OnChange of eq_knd_cd
	 * @param	{IBMultiCombo}		comboOjb    Combo object
	 * @param 	{Number} 			Index_Code 	Selected row
	 * @param 	{String} 			Text 		Selected text
	 */
	function eq_knd_cd_OnChange(comboObj,OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		var formObj=document.form;
		var comboValue=comboObj.GetSelectCode();
		eq_tpsz_cd.RemoveAll();
		var selTpSz=new Array();
		eq_tpsz_cd.SetEnable(1);
		if(comboValue == "U"){
			selTpSz=uTpSz;
		} else if(comboValue == "G"){
			selTpSz=gTpSz;
		} else {
			selTpSz=zTpSz;
		}
		for(var i=0;i < (selTpSz.length);i++){
			eq_tpsz_cd.InsertItem(i, ComReplaceStr(selTpSz[i],"^"," - ") , selTpSz[i]);
		}
	}
	/**
	 * Event hanlding of OnChange of p_loc_tp
	 * @param	{IBMultiCombo}		comboOjb    Combo object
	 * @param 	{Number} 			Index_Code 	Selected row
	 * @param 	{String} 			Text 		Selected text
	 */
	function p_loc_tp_OnChange(comboObj,OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		var formObj=document.form;
		formObj.p_loc_cd.value="";
		if(p_loc_tp.GetSelectText() == "ALL") {
			MnrFormSetReadOnly(formObj,true,"p_loc_cd");
		}else {
			MnrFormSetReadOnly(formObj,false,"p_loc_cd");
			ComSetFocus(formObj.p_loc_cd);
		}
		
		if(p_loc_tp.GetSelectText() == "Yard"){
			document.getElementById("p_loc_cd").maxLength = 7;
		}else{
			document.getElementById("p_loc_cd").maxLength = 5;
		}
	}
	//Event hanlding of OnCheckClick of eq_tpsz_cd
	function eq_tpsz_cd_OnCheckClick(comboObj, index, code) {
		//MnrAllChkMultiCombo(comboObj,index);
	}
	/**
	 * Event hanlding of OnChange of eq_tpsz_cd
	 * @param	{IBMultiCombo}		comboOjb    Combo object
	 * @param 	{Number} 			Index_Code 	Selected row
	 * @param 	{String} 			Text 		Selected text
	 */
	function eq_tpsz_cd_OnChange(comboObj,OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		formObj=document.form;
		eq_tpsz_cd.value=comboObj.GetSelectCode();
	}
	function sheet1_OnBeforeEdit(sheetObj,Row,Col) {
		if(sheetObjects[1].GetCellValue(Row, "copy_row_num") == ""){
			var CopyRow=sheetObjects[0].DataInsert(-1);
			sheetObjects[1].SetCellValue(Row, "copy_row_num",CopyRow,0);//Copy Row
			//Copying data
			sheetObjects[0].SetCellValue(CopyRow, "recent_hngr_bar_atch_knt",sheetObjects[1].GetCellValue(Row,  "hngr_bar_atch_knt"),0);
			sheetObjects[0].SetCellValue(CopyRow, "mnr_sts_flg",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_flg"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_rck_cd",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_rck_cd"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_bar_tp_cd",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_bar_tp_cd"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_trf_cd",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_trf_cd"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_trf_otr_desc",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_trf_otr_desc"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_act_invt_qty",sheetObjects[1].GetCellValue(Row,  "act_invt_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_dmg_qty",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_dmg_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_lost_hngr_qty",sheetObjects[1].GetCellValue(Row,  "mnr_lost_hngr_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_disp_hngr_qty",sheetObjects[1].GetCellValue(Row,  "mnr_disp_hngr_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_sts_rmk",sheetObjects[1].GetCellValue(Row,  "mnr_sts_rmk"),0);
		}
	}
	function sheet1_OnBeforeCheck(sheetObj,Row,Col) {
		if(sheetObjects[1].GetCellValue(Row, "copy_row_num") == ""){
			var CopyRow=sheetObjects[0].DataInsert(-1);
			sheetObjects[1].SetCellValue(Row, "copy_row_num",CopyRow,0);//Copy Row
			//Copying data
			sheetObjects[0].SetCellValue(CopyRow, "recent_hngr_bar_atch_knt",sheetObjects[1].GetCellValue(Row,  "hngr_bar_atch_knt"),0);
			sheetObjects[0].SetCellValue(CopyRow, "mnr_sts_flg",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_flg"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_rck_cd",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_rck_cd"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_bar_tp_cd",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_bar_tp_cd"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_trf_cd",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_trf_cd"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_trf_otr_desc",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_trf_otr_desc"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_act_invt_qty",sheetObjects[1].GetCellValue(Row,  "act_invt_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_hngr_dmg_qty",sheetObjects[1].GetCellValue(Row,  "mnr_hngr_dmg_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_lost_hngr_qty",sheetObjects[1].GetCellValue(Row,  "mnr_lost_hngr_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_disp_hngr_qty",sheetObjects[1].GetCellValue(Row,  "mnr_disp_hngr_qty"),0);
			sheetObjects[0].SetCellValue(CopyRow, "tmp_mnr_sts_rmk",sheetObjects[1].GetCellValue(Row,  "mnr_sts_rmk"),0);
		}
	}
   /**
    * Event handling of OnChange of sheet1
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		var copysheetObj=sheetObjects[0];
		var copyRow=sheetObj.GetCellValue(Row,"copy_row_num");
		if (sheetObj.ColSaveName(Col) == "mnr_hngr_flg"){
			sheetObj.SetCellValue(Row,  "cre_ofc_cd",currOfcCd,0);
			if(Value == "1"){
				if(copysheetObj.GetCellValue(copyRow,  "mnr_sts_flg") == "1"){
					sheetObj.SetCellValue(Row,  "mnr_hngr_rck_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_rck_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_bar_tp_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_bar_tp_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_trf_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_otr_desc",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_trf_otr_desc"),0);
					sheetObj.SetCellValue(Row,  "hngr_bar_atch_knt",copysheetObj.GetCellValue(copyRow,  "recent_hngr_bar_atch_knt"),0);
					sheetObj.SetCellValue(Row,  "act_invt_qty",copysheetObj.GetCellValue(copyRow,  "tmp_act_invt_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_dmg_qty",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_dmg_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_lost_hngr_qty",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_lost_hngr_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_disp_hngr_qty",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_disp_hngr_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_sts_rmk",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_sts_rmk"),0);
					if(copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_rck_cd") == "O"){
						sheetObj.SetCellEditable(Row, "mnr_hngr_rck_cd",0);
						sheetObj.SetCellEditable(Row, "mnr_hngr_bar_tp_cd",0);
					} else {
						sheetObj.SetCellEditable(Row, "mnr_hngr_rck_cd",1);
						sheetObj.SetCellEditable(Row, "mnr_hngr_bar_tp_cd",1);
					}
					sheetObj.SetCellEditable(Row, "mnr_hngr_trf_cd",1);
//					if(copysheetObj.GetCellValue(copyRow,  "mnr_hngr_trf_cd") == "OT"){
						sheetObj.SetCellEditable(Row, "mnr_hngr_trf_otr_desc",1);
//					} else {
//						sheetObj.SetCellEditable(Row, "mnr_hngr_trf_otr_desc",0);
//					}
					sheetObj.SetCellEditable(Row, "hngr_bar_atch_knt",1);
					sheetObj.SetCellEditable(Row, "act_invt_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_dmg_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_lost_hngr_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_disp_hngr_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_sts_rmk",1);
					sheetObj.SetRowStatus(Row,"R");
				} else {
					if(copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_rck_cd") == "O"){
						sheetObj.SetCellEditable(Row, "mnr_hngr_rck_cd",0);
						sheetObj.SetCellEditable(Row, "mnr_hngr_bar_tp_cd",0);
					} else {
						sheetObj.SetCellEditable(Row, "mnr_hngr_rck_cd",1);
						sheetObj.SetCellEditable(Row, "mnr_hngr_bar_tp_cd",1);
					}
//					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_cd","CB",0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_otr_desc","",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_trf_cd",1);
					sheetObj.SetCellEditable(Row, "mnr_hngr_trf_otr_desc",0);
					sheetObj.SetCellValue(Row,  "hngr_bar_atch_knt","0",0);
					sheetObj.SetCellValue(Row,  "act_invt_qty","0",0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_dmg_qty","0",0);
					sheetObj.SetCellValue(Row,  "mnr_lost_hngr_qty","0",0);
					sheetObj.SetCellValue(Row,  "mnr_disp_hngr_qty","0",0);
					sheetObj.SetCellEditable(Row, "hngr_bar_atch_knt",1);
					sheetObj.SetCellEditable(Row, "act_invt_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_dmg_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_lost_hngr_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_disp_hngr_qty",0);
					sheetObj.SetCellEditable(Row, "mnr_sts_rmk",1);
				}
			}else if(Value == "0") {
				if(copysheetObj.GetCellValue(copyRow,  "mnr_sts_flg") == "0"){
					sheetObj.SetCellValue(Row,  "mnr_hngr_rck_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_rck_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_bar_tp_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_bar_tp_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_trf_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_otr_desc",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_trf_otr_desc"),0);
					sheetObj.SetCellValue(Row,  "hngr_bar_atch_knt",copysheetObj.GetCellValue(copyRow,  "recent_hngr_bar_atch_knt"),0);
					sheetObj.SetCellValue(Row,  "act_invt_qty",copysheetObj.GetCellValue(copyRow,  "tmp_act_invt_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_dmg_qty",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_dmg_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_lost_hngr_qty",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_lost_hngr_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_disp_hngr_qty",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_disp_hngr_qty"),0);
					sheetObj.SetCellValue(Row,  "mnr_sts_rmk",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_sts_rmk"),0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_rck_cd",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_bar_tp_cd",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_trf_cd",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_trf_otr_desc",0);
					sheetObj.SetCellEditable(Row, "hngr_bar_atch_knt",0);
					if(copysheetObj.GetCellValue(copyRow,  "recent_hngr_bar_atch_knt") != "0"){
						sheetObj.SetCellEditable(Row, "act_invt_qty",1);
						sheetObj.SetCellEditable(Row, "mnr_hngr_dmg_qty",1);
						sheetObj.SetCellEditable(Row, "mnr_lost_hngr_qty",1);
						sheetObj.SetCellEditable(Row, "mnr_disp_hngr_qty",1);
						sheetObj.SetCellEditable(Row, "mnr_sts_rmk",1);
					} else {
						sheetObj.SetCellEditable(Row, "act_invt_qty",0);
						sheetObj.SetCellEditable(Row, "mnr_hngr_dmg_qty",0);
						sheetObj.SetCellEditable(Row, "mnr_lost_hngr_qty",0);
						sheetObj.SetCellEditable(Row, "mnr_disp_hngr_qty",0);
						sheetObj.SetCellEditable(Row, "mnr_sts_rmk",0);
					}
					sheetObj.SetRowStatus(Row,"R");
				} else {
					sheetObj.SetCellValue(Row,  "mnr_hngr_rck_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_rck_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_bar_tp_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_bar_tp_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_trf_cd"),0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_trf_otr_desc",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_trf_otr_desc"),0);
					sheetObj.SetCellValue(Row,  "hngr_bar_atch_knt",copysheetObj.GetCellValue(copyRow,  "recent_hngr_bar_atch_knt"),0);
					sheetObj.SetCellValue(Row,  "act_invt_qty","0",0);
					sheetObj.SetCellValue(Row,  "mnr_hngr_dmg_qty","0",0);
					sheetObj.SetCellValue(Row,  "mnr_lost_hngr_qty","0",0);
					sheetObj.SetCellValue(Row,  "mnr_disp_hngr_qty","0",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_rck_cd",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_bar_tp_cd",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_trf_cd",0);
					sheetObj.SetCellEditable(Row, "mnr_hngr_trf_otr_desc",0);
					sheetObj.SetCellEditable(Row, "hngr_bar_atch_knt",0);
					sheetObj.SetCellEditable(Row, "act_invt_qty",1);
					sheetObj.SetCellEditable(Row, "mnr_hngr_dmg_qty",1);
					sheetObj.SetCellEditable(Row, "mnr_lost_hngr_qty",1);
					sheetObj.SetCellEditable(Row, "mnr_disp_hngr_qty",1);
					sheetObj.SetCellEditable(Row, "mnr_sts_rmk",1);
				}
			}
		} else if(sheetObj.ColSaveName(Col) == "mnr_hngr_rck_cd"){
			if(sheetObj.GetCellValue(Row,  "mnr_hngr_rck_cd") == "O" && copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_rck_cd") != "O"){
				ComShowCodeMessage("MNR00331");
				sheetObj.SetCellValue(Row,  "mnr_hngr_rck_cd",copysheetObj.GetCellValue(copyRow,  "tmp_mnr_hngr_rck_cd"),0);
			}
		} else if(sheetObj.ColSaveName(Col) == "mnr_hngr_trf_cd"){
//			if(Value == "OT"){
				sheetObj.SetCellEditable(Row, "mnr_hngr_trf_otr_desc",1);
//			}
		} else if(sheetObj.ColSaveName(Col) == "hngr_bar_atch_knt" || sheetObj.ColSaveName(Col) == "act_invt_qty"
				|| sheetObj.ColSaveName(Col) == "mnr_hngr_dmg_qty" || sheetObj.ColSaveName(Col) == "mnr_lost_hngr_qty"
				|| sheetObj.ColSaveName(Col) == "mnr_disp_hngr_qty"	|| sheetObj.ColSaveName(Col) == "mnr_hngr_bar_tp_cd"){
			if(copysheetObj.GetCellValue(copyRow,  "mnr_sts_flg") ==  sheetObj.GetCellValue(Row,  "mnr_hngr_flg")){
				sheetObj.SetCellValue(Row,"cre_ofc_cd",sheetObj.GetCellValue(Row,"ofc_cd"),0);
			}
		}
	}
	/**
	 * Showing result message after saving
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
          ComShowCodeMessage("MNR00023",ErrMsg);
          if(excelLoadFlg == "N"){
        	  doActionIBSheet(sheetObj,document.form,IBSEARCH);
          }
      	} else {
          ComShowCodeMessage("MNR00008","Hanger Installation");
		}
	}
	/* ********* User Functions Start ************* */
	/**
	 * Getting rep_Multiful_inquiry
	 */
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;
		var tempText="";
		//Initializing
		eval("document.form." + ret_val + ".value='';");
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//Removing last comma
		if (tempText != "")
	        tempText=tempText.substr(0, tempText.length - 1);
		tempText=tempText.toUpperCase();
		eval("document.form." + ret_val + ".value='" + tempText + "';");
	}
	/**
     * @param	{IBSheet}	sheetObj
	 */
	function setTpSzArray(sheetObj){
		var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
		if(arrXml != null){
		    for(var i=0; i < arrXml.length; i++){
				if(i == 0){
					uTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){
					zTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){
					gTpSz=MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
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
    		switch(p_loc_tp.GetSelectCode()) {
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
    	}
    	return;
    }
	/* ********* User Functions End ************* */
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
		//Axon event handling 1. Catching event
		var formObject=document.form;
		axon_event.addListenerForm  ('blur',     	'obj_deactivate', 	formObject);
	//	axon_event.addListenerFormat('focus',    	'obj_activate',		formObject);
		//axon_event.addListenerFormat('keypress',	'obj_keypress', 	formObject);
		axon_event.addListenerFormat('change',	 	'obj_change',		formObject);
		//axon_event.addListener('change',	 		'obj_change1',		'ord_hdr_rmk');
	}
	/**
     * Onblur event handling <br>
     **/
	function obj_deactivate(){
		ComChkObjValid(ComGetEvent());
	}
	/**
     * Event handling activate
     **/
	function obj_activate(){
		ComClearSeparator(ComGetEvent());
	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
				//do nothing
			}
	    }
		ComBtnDisable("btn_more");
	}
	/**
	 * Keypress event handling <br>
	 **/
	function obj_keypress(){
	    obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
	         	if(obj.name == "eq_list"){
					ComKeyOnlyAlphabet('uppernum','44');
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	    }
	}
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		excelLoadFlg = "Y";
		
		for(var i = 2 ; i < sheetObj.LastRow()+1 ; i++){
			if(sheetObj.GetCellValue(i, "mnr_hngr_flg_dt") == ""){
				ComShowCodeMessage("MNR00003", "[Row " + (i-1) + "] Flag Date ");
				sheetObj.RemoveAll();
				excelLoadFlg = "N";
				return;
			}
			
			if(!ComIsDate(sheetObj.GetCellValue(i, "mnr_hngr_flg_dt"), "ymd")){
				ComShowMessage("[Row: "+(i-1)+"] "+ComGetMsg("MNR00015"));
				sheetObj.RemoveAll();
				excelLoadFlg = "N";
				return;
			}
			
			var sXml=MnrComEqGenInfoSearch(sheetObj,"U",sheetObj.GetCellValue(i, "eq_no"),ComGetNowInfo("ymd"),"");
			var retArr=MnrXmlToArray(sXml);

            sheetObj.SetCellValue(i, "eq_tpsz_cd", retArr[0][31]);
            sheetObj.SetCellValue(i, "mvmt_cd", retArr[0][13]);
			sheetObj.SetCellValue(i, "mnr_hngr_flg_yd_cd", retArr[0][18]);
			sheetObj.SetCellValue(i, "rstr_usg_lbl_tp", retArr[0][44]);
			sheetObj.SetCellValue(i, "eq_knd_cd", retArr[0][28]);
			
			if(sheetObj.GetCellValue(i,  "tmp_mnr_hngr_rck_cd") == "O"){
				sheetObj.SetCellEditable(i, "mnr_hngr_rck_cd",0);
				sheetObj.SetCellEditable(i, "mnr_hngr_bar_tp_cd",0);
			} else {
				sheetObj.SetCellEditable(i, "mnr_hngr_rck_cd",1);
				sheetObj.SetCellEditable(i, "mnr_hngr_bar_tp_cd",1);
			}
			sheetObj.SetCellEditable(i, "mnr_hngr_trf_cd",1);
			sheetObj.SetCellEditable(i, "mnr_hngr_trf_otr_desc",1);
			sheetObj.SetCellEditable(i, "hngr_bar_atch_knt",1);
			sheetObj.SetCellEditable(i, "act_invt_qty",0);
			sheetObj.SetCellEditable(i, "mnr_hngr_dmg_qty",0);
			sheetObj.SetCellEditable(i, "mnr_lost_hngr_qty",0);
			sheetObj.SetCellEditable(i, "mnr_disp_hngr_qty",0);
			sheetObj.SetCellEditable(i, "mnr_sts_rmk",1);
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
	
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	if(appendPageNo == 1){
    		rtv_total = sheetObj.GetEtcData("rtv_total");
    	}
    	if (sheetObj.RowCount()< rtv_total) {
            // setting page number for APPEND retrieving
            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
            ComBtnEnable("btn_more");
        } else {
        	appendPageNo = 1;
            ComBtnDisable("btn_more");
        }		
    	sheetObj.SetWaitImageVisible(0);
    	ComOpenWait1(false);    	
    }
    
    function ComOpenWait1(flag, bOpenLayer){
        try {
            if(flag == isOpenWaitWindow ) return;
            isOpenWaitWindow = flag;
            if(flag) {
            	var waitW   = 60;
            	var waitH   = 60;
            	var waitImage = "style/images/theme_default/waiting.gif";
            	
            	var ifr = document.getElementById("waitiframe");
            	if (ifr==null){
                	$('<div class="layer_wait"> </div>').appendTo("body");
                	//$('<img name="waitiframe" id="waitiframe" src="'+waitImage+ '">').appendTo(".layer_wait");            	
                	//$('<IFRAME id="waitiframe" name="waitiframe" frameBorder="0" name="iFrm" src="'+waitImage+ '"scrolling="no" width="'+waitW + '" height="' + waitH + '"></IFRAME>').appendTo(".layer_wait")
        
                	$("body").prepend("<div class='layer_wait_bg'></div>");        	
            	}

            	//open wait image
            	$(".layer_wait_bg,.layer_wait").fadeIn(100);

            	//position center
            	$(".layer_wait").css({
                	marginTop : parseInt("-" + $(".layer_wait").outerHeight()/2),
                	marginLeft : parseInt("-" + $(".layer_wait").outerWidth()/2)
            	});
            } else {
            	//close wait image
            	$(".layer_wait_bg,.layer_wait").fadeOut(100);
            }
        } catch(err) {ComFuncErrMsg(err.message); }
        return true;
    }
/* End of developer's task */
