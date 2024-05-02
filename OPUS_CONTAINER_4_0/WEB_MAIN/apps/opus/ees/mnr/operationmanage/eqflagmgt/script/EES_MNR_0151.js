/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0151.js
*@FileTitle  : M&R Disposal Candidate Selection 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	/* Developer's task	*/
	//Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var uTpSz=new Array();
	var gTpSz=new Array();
	var zTpSz=new Array();
	var costDtlCode="";
	var costDtlDesc="";
	var OrgCostType="";
	var nowLoad=0;
	//Requesting calculate
	var calReq=0;
	var calDel="";
	var startCopyRow=0;
	var OrgVndrSeq="";
	var OrgCostCd="";
	var preEqkinCd="";
	// Office level by login user : HQ L1, RHQ L2, Office L3 (from MnrOfficeLevel function of CoMnr.js)
	var strMnrOfficeLevel="";
	// Defining event handler of button click
	document.onclick=processButtonClick;
	
	// Event handler to diverge process by button name	
    function processButtonClick(){
    	/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			var formObj=document.form;
				switch(srcName) {
					case "btn_calendar":
						var cal=new ComCalendarFromTo();
					    cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
					    break;
					case "btn_fryear": //calender button
						var cal=new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.fryear, 'yyyy');
						break;
					case "btn_toyear": //calender button
						var cal=new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.toyear, 'yyyy');
						break;
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
						break;
					case "btn_new":
						doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
						break;
					case "btn_save":
						MnrWaitControl(true);
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					case "btn_rowadd":
						doActionIBSheet(sheetObjects[1], formObject,IBINSERT);
						break;
					case "btn_rowdel":
						if(sheetObjects[1].FindCheckedRow("del_chk") == ""){
							ComShowCodeMessage("MNR00038","DELETE ");
							return false;
						}
						if(ComShowCodeConfirm("MNR00026")){
							sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "sheet2_mnr_disp_sel_flg","0",0);
							ComRowHideDelete(sheetObjects[1], "del_chk");
							calReq=0;
						}
						break;
					case "eq_no_multi1":
						if(combo_select_cd.GetSelectCode()=="N") {
							rep_Multiful_inquiry("rqst_eq_no");
						}
						break;
					case "btn_downexcel":
						if(sheetObjects[0].RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
						}
						break;
					case "btn_rulabel_cd":	//RU Label 조회 팝업
						var par_rulabel_type = form.hid_rulabel_type.value;
						var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
						var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
						ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true);		   
						break;
					case "btn_loadexcel":
						sheetObjects[1].RemoveAll();
						sheetObjects[1].LoadExcel();
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
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
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
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		MnrWaitControl(true);
		// Retrieving and Setting for office level
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		setTpSzArray(sheetObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }

	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
	
    /**
     * MultiSelect속성을 이용하는 경우, checking박스를 클릭하는 순간 발생한다.
     * @return
     */
    function rstr_usg_lbl_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    
    
    /**
     * in case of onChange combo event
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */
    function ru_lable_type_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    	comboOnChange2(NewIndex,NewText, NewCode);
    }        
    
    
    /**
     * handling in case of onChange combo event 
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */   
    function comboOnChange2(NewIndex,NewText,NewCode){ 	
    	
    	var formObj=document.form;
    	comboObjects[4].RemoveAll();
        form.f_cmd.value=SEARCH02;
        var ruLabelType=NewCode;
//        ruLabelType = comboObjects[4].GetSelectCode();
    	var param="&ru_label_type="+ruLabelType;
    	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
    	var chk=sXml.indexOf("ERROR");
    	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    		 sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
    		 return;
    	}	             
    	 
    	var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
        var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
         
        comboObjects[4].InsertItem(0 , 'ALL',''); 
        if(strRstrUsgTblNm.length > 1) {
        	for ( var i=0; i<strRstrUsgTblNm.length; i++) {
        		 var arrCode=strRstrUsgTblNm[i].split("|");
        		 comboObjects[4].InsertItem(i+1, arrCode[0], arrCode[0]);
        	}	
        }
        comboObjects[4].SetItemCheck(0,1);
        comboObjects[4].SetEnable(1);
    }	
	
 	/**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo){
    	var cnt=0;
    	switch(sheetNo){
    		case 1:      // sheet1 init
    			with(sheetObj){
    				var HeadTitle1="|Seq.|FLAG|Manu Year|EQ Range|TP/SZ|Q'ty|Active Qty|Flag Date|Creation Date|Creation ID";
    				var headCount=ComCountHeadTitle(HeadTitle1) + 5;
    				var prefix="sheet1_";

    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	    		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	    		             {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_disp_sel_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mft_yr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_range_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_qty",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_disp_sel_flg_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_knd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lot_eq_pfx_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fm_ser_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"to_ser_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    		             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_grp_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
    		    
    				InitColumns(cols);

    				SetEditable(1);
//    				SetSheetHeight(380);
    				resizeSheet( sheetObj );
    			}
    			break;
    		case 2:
    			with(sheetObj){
    				var HeadTitle1="|Sel|Seq.|FLAG|Sale Category|EQ No|RU Label Type|RU Label Value|TS|Term|Disposal No|Disposal Status|Yard|U.date|User ID";
    				var headCount=ComCountHeadTitle(HeadTitle1) + 1;
    				var prefix="sheet2_";

    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		    	             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		    	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_disp_sel_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"disp_rsn_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eq_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		    	             //{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"rstr_usg_lbl_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"rstr_usg_lbl_tp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"rstr_usg_lbl_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lstm_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"disp_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"disp_sts_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_disp_sel_flg_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_knd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
    	    
    				InitColumns(cols);

    				SetEditable(1);
    				SetColHidden(prefix+"mnr_disp_sel_flg",1);
    				//conversion of function[check again]CLT 		   InitDataValid(0, prefix + "eq_no" ,vtEngUpOther, "0123456789");
    				//conversion of function[check again]CLT 		   InitDataValid(0, prefix + "mnr_disp_sel_flg_yd_cd" ,vtEngUpOther, "0123456789");

    				SetVisible(false);
    				SetSheetHeight(380);
    			}
    			break;
    		case 3:
    			with (sheetObj) {
    				SetVisible(0);
    			}
    			break;
    		case 4:  // sheet1 init
    			with(sheetObj){
    				var HeadTitle1="|Seq.|FLAG|MANU|EQ S/No. Range|TS|Q'ty|Flag Date|U.date|User ID";
    				var headCount=ComCountHeadTitle(HeadTitle1) + 5;
    				var prefix="sheet4_";

    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		    	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		    	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_disp_sel_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mft_yr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_range_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_qty",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_disp_sel_flg_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_knd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lot_eq_pfx_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fm_ser_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"to_ser_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_grp_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
    	    
    				InitColumns(cols);

    				SetEditable(1);
    				SetVisible(false);
    			}
    			break;
    	}
    }
    
 	/**
 	* Initializing multi combo
 	* @return
 	*/
 	function initCombo() {
 		var formObject=document.form;
		with (combo_select_cd) {
			combo_select_cd.SetColAlign(0, "left");
			combo_select_cd.SetColWidth(0, "80");
			combo_select_cd.SetDropHeight(160);
			combo_select_cd.SetEnable(1);
 		}
 		with (combo_eq_knd_cd) {
 			combo_eq_knd_cd.SetColAlign(0, "left");
 			combo_eq_knd_cd.SetColWidth(0, "80");
 			combo_eq_knd_cd.SetDropHeight(160);
 			combo_eq_knd_cd.SetEnable(1);
 		}
 		with (combo_eq_tpsz_cd) {
 			combo_eq_tpsz_cd.SetMultiSelect(1);
 			combo_eq_tpsz_cd.SetUseAutoComplete(1);
 			combo_eq_tpsz_cd.SetColAlign(0, "left");
 			combo_eq_tpsz_cd.SetColWidth(0, "80");
 			combo_eq_tpsz_cd.SetDropHeight(200);
 		}
 		
// 		with(ru_lable_type) {
//	  		SetBackColor("#CCFFFA");
// 			SetDropHeight(150);
// 			SetMultiSelect(0);
// 			SetMaxSelect(1);
// 			SetUseAutoComplete(1);
// 		}
//   		with(rstr_usg_lbl) {
//   			SetBackColor("#CCFFFA");
//   			SetDropHeight(150);
//   			SetMultiSelect(1);
//   			SetUseAutoComplete(1);
//      	 	SetMultiSeparator(",");
//   			Style=0;
//   		}
 		
 	}
 	
	//Multi combo click event
	function combo_eq_tpsz_cd_OnCheckClick(comboObj, index, code) {
		MnrAllChkMultiCombo(comboObj ,index);
	}
	
	/**
	 * Event handling of OnChange of combo_eq_tpsz_cd
	 * @param	{IBMultiCombo}		comboOjb    Combo object
	 */
	function combo_eq_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	   combo_eq_tpsz_cd_text.value = newCode;
	}
   
	function combo_eq_tpsz_cd_OnBlur(comboObj) {
	   combo_eq_tpsz_cd_text.value = comboObj.GetSelectCode();
   	}
	
	function combo_eq_knd_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
		formObject=document.form;
		if(combo_select_cd.GetSelectCode()== "N" && sheetObjects[1].RowCount()> 0){
			if (!ComShowCodeConfirm("MNR00297")){
				comboObj.SetSelectCode(preEqkinCd,false);
				return;
			}
		}
		//EQ No Initializing sheet
		sheetObjects[1].RemoveAll();
		if(newcode == null) return;
 		combo_eq_tpsz_cd.RemoveAll();
		var selTpSz=new Array();
		if(newcode == "U"){
			selTpSz=uTpSz;
		} else if(newcode == "G"){
			selTpSz=gTpSz;
		} else {
			selTpSz=zTpSz;
		}
		combo_eq_tpsz_cd.InsertItem(0,"ALL","ALL");
		for(var i=1;i < (selTpSz.length + 1);i++){
			combo_eq_tpsz_cd.InsertItem(i, ComReplaceStr(selTpSz[i - 1],"^"," - ") , selTpSz[i - 1]);
		}
		preEqkinCd=comboObj.GetSelectCode();
		
		if(combo_select_cd.GetSelectCode()== "N"){
			if(combo_eq_knd_cd.GetSelectCode() == "U")
				document.getElementById("locTpCdCombo").style.display =  "";
			else
				document.getElementById("locTpCdCombo").style.display =  "none";
		}
	}
	
	function combo_select_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode) {
		var formObj=document.form;
		var dateTitle=document.getElementById("dateTitle");
		var dateHtml=document.getElementById("dateHtml");
		var btn_rowadd=document.getElementById("btn_rowadd");
		var btn_rowdel=document.getElementById("btn_rowdel");
		var btn_loadexcel=document.getElementById("btn_loadexcel");
		var btn_downexcel=document.getElementById("btn_downexcel");
		if(newcode=="R")
		{
			sheetObjects[0].SetVisible(true);
			sheetObjects[1].SetVisible(false);
			dateTitle.innerHTML="EQ Manufactured Year&nbsp;";
			dateHtml.innerHTML="<input type=\"text\" maxlength=4 style=\"width:40px;text-align:center\" class=\"input\" name=\"fryear\" dataformat=\"int\">&nbsp;"
				+ "<button type=\"button\" class=\"calendar ir\" name=\"btn_fryear\" id=\"btn_fryear\"></button>"
				+ "&nbsp;~&nbsp;<input type=\"text\" maxlength=4 style=\"width:40px;text-align:center\" class=\"input\" name=\"toyear\" dataformat=\"int\">&nbsp;"
				+ "<button type=\"button\" class=\"calendar ir\" name=\"btn_toyear\" id=\"btn_toyear\"></button>"
				;
			+ "<img name =\"btn_fryear\" src=\"img/btns_calendar.gif\" width=\"19\" height=\"20\" alt=\"\" border=\"0\" align=\"absmiddle\" class=\"cursor\">"
			$("#sheet_title").html("Disposal Candidate Selection by Serial Range");
			btn_rowadd.style.display="none";
			btn_rowdel.style.display="none";
			btn_loadexcel.style.display="none";
			btn_downexcel.style.display="inline";
			document.getElementById("locTpCdCombo").style.display =  "none";

		}
		else if(newcode=="N")
		{
			sheetObjects[0].SetVisible(false);
			sheetObjects[1].SetVisible(true);
			dateTitle.innerHTML="EQ Selection Date&nbsp;";
			dateHtml.innerHTML="<input   name=\"fromcal\" type=\"text\" maxlength=8  style=\"width:80px;text-align:center\" class=\"input\" dataformat=\"ymd\" >"
								  +"&nbsp;~&nbsp;<input  name=\"tocal\" type=\"text\"    maxlength=8  style=\"width:80px;text-align:center\" class=\"input\" dataformat=\"ymd\">"
								  +"&nbsp;<button type=\"button\" class=\"calendar ir\" name=\"btn_calendar\" id=\"btn_calendar\"></button>";
			$("#sheet_title").html("Disposal Candidate Selection by EQ No");
			btn_rowadd.style.display="block";
			btn_rowdel.style.display="block";
//			btn_loadexcel.style.display="block";
			btn_loadexcel.style.display="none";
			btn_downexcel.style.display="none";
			if(combo_eq_knd_cd.GetSelectCode() == "U")
				document.getElementById("locTpCdCombo").style.display =  "";
			else
				document.getElementById("locTpCdCombo").style.display =  "none";
		}
		if(combo_select_cd.GetSelectCode()=="R")
		{
			formObj.fryear.value=ComGetNowInfo("yy") - 5;
			formObj.toyear.value=ComGetNowInfo("yy");
			formObj.rqst_eq_no.disabled=true;
			formObj.eq_no_multi1.disabled=true;
			formObj.rqst_eq_no.value="";
		}
		else if(combo_select_cd.GetSelectCode()=="N")
		{
			formObj.tocal.value = ComGetNowInfo("ymd");
			formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "M", -3);
			formObj.rqst_eq_no.disabled=false;
			formObj.eq_no_multi1.disabled=false;
			formObj.rqst_eq_no.value="";
		}
		initControl();
	}
 	
	function sheet1ToSheet4Copy(fromSheet,toSheet){
	    toSheet.RemoveAll();
	    var row=0;
	    for (var idx=startCopyRow ; idx<=fromSheet.LastRow(); idx++) {
	    	if(row>10)break;
	    	if(fromSheet.GetCellValue(idx,"sheet1_ibflag")!='U') continue;
			 row=toSheet.DataInsert(-1);
	        //Copying data
	        for (ic=0; ic<=fromSheet.LastCol(); ic++) {
	        	toSheet.SetCellValue(row, ic,fromSheet.GetCellValue(idx, ic));
	        }
	    }
	    startCopyRow=idx;
	    var formObj=document.form;
		formObj.f_cmd.value=MULTI;
		var aryPrefix=new Array("sheet4_", "sheet2_");
		var sParam=ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
		{
			MnrWaitControl(false);
			setSaveBtnDisplay();
			combo_select_cd.SetEnable(1);
			return false;
		}
		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);
		//parameter changed[check again]CLT
		var sXml=toSheet.GetSaveData("EES_MNR_0151GS.do", sParam);
		//parameter changed[check again]CLT
		toSheet.LoadSaveData(sXml);
		fromSheet.RenderSheet(1);
	}
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") {
				ComShowCodeMessage("MNR00111");
				if(combo_select_cd.GetSelectCode()=="R")
					sheetObjects[0].RemoveAll();
				else if(combo_select_cd.GetSelectCode()=="N")
					sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			} else {
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad=0;
		MnrWaitControl(false);
		setSaveBtnDisplay();
		ComEnableObject(formObj.select_cd,true);
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		var formObj=document.form;
		var prefix="sheet3_";
		combo_select_cd.SetEnable(1);
		nowLoad=0;
		MnrWaitControl(false);
		setSaveBtnDisplay();
	}
	
	function sheet2_OnChange(sheetObj,Row, Col, Value)
	{
		var formObj=document.form;
		if(nowLoad == 0)
		{
			if(sheetObj.ColSaveName(Col) == "sheet2_eq_no")
			{
				var checkEqn=sheetObjects[1].GetCellValue(Row,"sheet2_eq_no");
				sheetObjects[1].SetCellValue(Row,"sheet2_eq_no",checkEqn.toUpperCase(),0);
				checkEqn=checkEqn.toUpperCase();
				var retArray=MnrGeneralCodeCheck(sheetObjects[0],"ESTEQN",checkEqn + "," + combo_eq_knd_cd.GetSelectCode());
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
					sheetObjects[1].SetCellValue(Row,"sheet2_eq_no","",0);
					sheetObjects[1].SelectCell(Row,"sheet2_eq_no");
					return;
				} else {
					setEqInfo(sheetObjects[2],Row,combo_eq_knd_cd.GetSelectCode(),checkEqn,ComGetNowInfo("ymd"));
					return;
				}
			}
			else if(sheetObj.ColSaveName(Col) == "sheet2_mnr_disp_sel_flg_yd_cd")
			{
				var checkYard=Value;
				retArray=MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkYard,"YARD");
					sheetObj.SetCellValue(Row ,Col,"",0);
					sheetObj.SelectCell(Row ,Col);
				} else {
					return;
				}
			}
		}
	}
	
	function sheet3_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI && startCopyRow > sheetObjects[0].LastRow())
		{
	 		sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), "sheet1_mft_yr",true);
			sheetObjects[0].SetWaitImageVisible(0);
			ComOpenWait(false);
			if (errMsg == "") {
				ComShowCodeMessage("MNR00111");
				if(combo_select_cd.GetSelectCode()=="R")
					sheetObjects[0].RemoveAll();
				else if(combo_select_cd.GetSelectCode()=="N")
					sheetObjects[1].RemoveAll();
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			} else {
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
			nowLoad=0;
			MnrWaitControl(false);
			setSaveBtnDisplay();
			combo_select_cd.SetEnable(1);
		}else{
	 		sheetObjects[0].SelectCell(startCopyRow - 1, "sheet1_mft_yr",true);
	 		setTimeout("sheet1ToSheet4Copy(sheetObjects[0],sheetObjects[3])",300);
		}
		combo_select_cd.SetEnable(1);
	}
	
	//Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:
				MnrWaitControl(true);
				formObj.f_gubuns.value="";
				formObj.cost_ofc_cd.value=currOfcCd;
				//Initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				//Initializing sheet
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				//Setting combo
				var sCondition=new Array (
					new Array("MnrGenCd","CD00066", "COMMON"),
					new Array("MnrGenCd",formObj.self_ofc_cd.value,"CUSTOM9"),
					new Array("MnrGenCd","CD00038", "COMMON"),
					new Array("ComIntgCd","CD20097", "COMMON")
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//1. combo_select_cd
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						combo_select_cd.InsertItem(j,tempText[1] ,tempText[0]);
					}
				}
				combo_select_cd.SetSelectCode("R");
				//2. combo_eq_knd_cd
				if(comboList[1] != null){
					for(var j=0; j < comboList[1].length;j++){
						var tempText=comboList[1][j].split("|");
						combo_eq_knd_cd.InsertItem(j,tempText[1] ,tempText[0]);
					}
				}
				combo_eq_knd_cd.SetSelectCode("U");
				//3  sheet2_disp_rsn_cd
				if(comboList[2] != null){
		 			sheetComboText="";
		 			sheetComboCode="";
		 			sheetComboDefault="";
		 	 		for(var j=0; j < comboList[2].length;j++){
		 				var tempText=comboList[2][j].split("|");
		 				sheetComboText +=  tempText[1] + "|";
		 				sheetComboCode +=  tempText[0] + "|";
		 				if(j == 0){
		 					sheetComboDefault=tempText[0];
		 				}
		 			}
					sheetComboText=MnrDelLastDelim(sheetComboText);
					sheetComboCode=MnrDelLastDelim(sheetComboCode);
		 			//Setting combo of sheet of tab
					sheetObjects[1].SetColProperty(0,"sheet2_disp_rsn_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
		 		}
				
//				if(comboList[3] != null){
//					for(var j = 0; j < comboList[3].length;j++){
//						var tempText = comboList[3][j].split("|");
//						ru_lable_type.InsertItem(j,tempText[1] ,tempText[0]);
//					}
//				}
//				ru_lable_type.InsertItem(0 , 'ALL','ALL');
//				ru_lable_type.SetSelectCode("ALL");	
			
				//Setting init value by combo
				if(combo_select_cd.GetSelectCode()== "R")
				{
					formObj.fryear.value=ComGetNowInfo("yy") - 5;
					formObj.toyear.value=ComGetNowInfo("yy");
				}
				else if(combo_select_cd.GetSelectCode()=="N")
				{
					formObj.tocal.value=ComGetNowInfo("ymd");
					formObj.fromcal.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -3);
				}
				MnrWaitControl(false);
				//Setting displaying of save button
				setSaveBtnDisplay();
				break;
			case IBINSERT:
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				var row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(row, "sheet2_disp_rsn_cd","C",0);
				sheetObj.SetCellValue(row, "sheet2_mnr_disp_sel_flg","1",0);
				sheetObj.SetCellEditable(row,"sheet2_mnr_disp_sel_flg",0);
				sheetObj.SetCellValue(row, "sheet2_eq_knd_cd",combo_eq_knd_cd.GetSelectCode(),0);
				sheetObj.SelectCell(row, "sheet2_eq_no",true);
				MnrWaitControl(false);
				setSaveBtnDisplay();
				break;
			case IBSEARCH:      //Retrieving
				MnrWaitControl(true);
				if(!validateForm(sheetObj,formObj,sAction))
				{
					MnrWaitControl(false);
					setSaveBtnDisplay();
					return;
				}
				nowLoad=1;
				formObj.f_gubuns.value="";
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.select_cd.value=combo_select_cd.GetSelectCode();
				formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
				formObj.eq_tpsz_cd.value=combo_eq_tpsz_cd.GetSelectCode();
				formObj.rqst_eq_no.value=formObj.rqst_eq_no.value.replace(/,/g,"','");
				formObj.f_cmd.value=SEARCH;
				var sParam="";
				var aryPrefix=new Array("sheet1_", "sheet2_");
				sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("EES_MNR_0151GS.do", sParam);
				arrDataSearchDbXml=sXml.split("|$$|");
				for ( var i=0; i < arrDataSearchDbXml.length; i++) {
						sheetObjects[i].RenderSheet(0);
						sheetObjects[i].SetWaitImageVisible(0);
						sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:0} );
						sheetObjects[i].RenderSheet(1);
				}
				break;
		case IBSAVE:        //Saving
			if(nowLoad != 0) return;
			MnrWaitControl(true);
			combo_select_cd.SetEnable(0);
			var sheetObjCheck;
			if(combo_select_cd.GetSelectCode()=="R")
				sheetObjCheck=sheetObjects[0];
			else if(combo_select_cd.GetSelectCode()=="N")
				sheetObjCheck=sheetObjects[1];
			if(!validateForm(sheetObjCheck,formObj,sAction))
			{
				combo_select_cd.SetEnable(1);
				nowLoad=0;
				MnrWaitControl(false);
				setSaveBtnDisplay();
				return;
			}
			nowLoad=1;
			formObj.select_cd.value=combo_select_cd.GetSelectCode();
			formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
			formObj.eq_tpsz_cd.value=combo_eq_tpsz_cd.GetSelectCode();
			formObj.f_cmd.value=MULTI;
			if(formObj.select_cd.value == "R")
			{
				MnrWaitControl(true);
				ComOpenWait(true);
			 	startCopyRow=sheetObjects[0].HeaderRows();
				sheet1ToSheet4Copy(sheetObjects[0],sheetObjects[3]);
			}else{
				MnrWaitControl(true);
				var aryPrefix=new Array("sheet1_", "sheet2_");
				var sParam=ComGetSaveString(sheetObjects, true, false);
				if (sParam == "")
				{
					MnrWaitControl(false);
					setSaveBtnDisplay();
					combo_select_cd.SetEnable(1);
					return false;
				}
				sParam += "&" + FormQueryString(formObj) + "&"
				+ ComGetPrefixParam(aryPrefix);
				var sXml=sheetObj.GetSaveData("EES_MNR_0151GS.do", sParam);
				sheetObjects[0].LoadSaveData(sXml);
			}
			break;
        }
    }
    
 	/**
 	* Validating process for input form data
 	*/
 	function validateForm(sheetObj,formObj,sAction){
 			//Adding
 			if(sAction==IBINSERT)
 			{
 			}
 			//At retrieving
 			else if(sAction==IBSEARCH)
 			{
 				var sRow=sheetObj.FindStatusRow("I|U|D");
 				if(sRow != "") 
 				{
 					if(!ComShowCodeConfirm("MNR00007"))
 					{
 						return false;
 					}
 				}
 				if(combo_eq_knd_cd.GetSelectIndex()== "-1"){
 					ComShowCodeMessage("MNR00036","EQ KIND");
 					ComSetFocus(combo_eq_knd_cd);
 					return false;
 				}
 			}
 			//Saving
 			else if(sAction==IBSAVE) {
 				if(sheetObj.RowCount()<=0)return false;
 				if(combo_select_cd.GetSelectCode()=="N")
 				{
	 				for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
	 				{
	 					if(sheetObj.GetCellValue(i, "sheet2_ibflag")!="R" && sheetObj.GetCellValue(i, "sheet2_ibflag")!="D")
	 					{
	 						var strEqNo=ComTrimAll(sheetObj.GetCellValue(i, "sheet2_eq_no")," ");
		 					if(strEqNo=="")
		 					{
		 						ComShowCodeMessage("MNR00172","EQ No.");
		 						sheetObj.SelectCell(i, "sheet2_eq_no",true);
		 						return false;
		 					}
		 					var checkYard=ComTrimAll(sheetObj.GetCellValue(i, "sheet2_mnr_disp_sel_flg_yd_cd")," ");;
							retArray=MnrGeneralCodeCheck(sheetObj,"YARD",checkYard);
							if(retArray == null){
								ComShowCodeMessage("MNR00165",checkYard,"YARD");
								sheetObj.SelectCell(i, "sheet2_mnr_disp_sel_flg_yd_cd",true);
								return false;
							}
	 					}
	 				}
 				}
 			}
 			//In case of Copying
 			else if (sAction=="COPY") {
 				//Checking grid row data
 				if(!checkIsDetailRow()) {return false;}
 			}
 			//Deleting row
 			else if (sAction==IBDELETE) {
 				if(sheetObj.FindCheckedRow("del_chk") == ""){
 					ComShowCodeMessage("MNR00038","DELETE ");
 					return false;
 				}
 			}
 			//Copying row
 			else if (sAction==IBCOPYROW) {
 				//Checking grid row data
 				if(!checkIsDetailRow()) {return false;}
 			}
 			//Load Excel
 			else if (sAction==IBLOADEXCEL) {
 				//Checking tariff status value
 				if(!checkTariffStatus()) {return false;}
 			}
 		return true;
 	}
 	
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
	
 	function setEqInfo(sheetObj,Row,sEqType,sEqNo,sTotalLossDate){
 		var formObj=document.form;
 		var sCostType="";
 		if(combo_eq_knd_cd.GetSelectCode()== "U"){
 			sCostType="MRDRRC";
 		} else if(combo_eq_knd_cd.GetSelectCode()== "G"){
 			sCostType="MRGSRC";
 		} else {
 			sCostType="MRZSRC";
 		}
 		var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
 		var retArr=MnrXmlToArray(sXml);
 		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
 		if(retArr != null){
 			var cntrStsCd = retArr[0][46];
 			var lstmCd = retArr[0][19];
 			
 			if(cntrStsCd == "TLL"){
 				//TpSz
 	 			sheetObjects[1].SetCellValue(Row,"sheet2_eq_tpsz_cd",retArr[0][31],0);
 	 			//Lstm
 	 			sheetObjects[1].SetCellValue(Row,"sheet2_lstm_cd",retArr[0][19],0);
 	 			//Yard
 	 			sheetObjects[1].SetCellValue(Row,"sheet2_mnr_disp_sel_flg_yd_cd",retArr[0][18],0);
 	 			//RU
 	 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_tp",retArr[0][44],0);
 	 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_desc",retArr[0][45],0);
 			}else{
 				if(lstmCd == "OW"){
 					//TpSz
 	 	 			sheetObjects[1].SetCellValue(Row,"sheet2_eq_tpsz_cd",retArr[0][31],0);
 	 	 			//Lstm
 	 	 			sheetObjects[1].SetCellValue(Row,"sheet2_lstm_cd",retArr[0][19],0);
 	 	 			//Yard
 	 	 			sheetObjects[1].SetCellValue(Row,"sheet2_mnr_disp_sel_flg_yd_cd",retArr[0][18],0);
 	 	 			//RU
 	 	 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_tp",retArr[0][44],0);
 	 	 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_desc",retArr[0][45],0);
 				}else{
 					ComShowCodeMessage("MNR00379");
 					sheetObjects[1].SetCellValue(Row, "sheet2_eq_no","", 0);
 					//TpSz
 		 			sheetObjects[1].SetCellValue(Row,"sheet2_eq_tpsz_cd","",0);
 		 			//Lstm
 		 			sheetObjects[1].SetCellValue(Row,"sheet2_lstm_cd","",0);
 		 			//Yard
 		 			sheetObjects[1].SetCellValue(Row,"sheet2_mnr_disp_sel_flg_yd_cd","",0);
 		 			//RU
 		 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_tp","",0);
 		 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_desc","",0);
 					sheetObjects[1].SelectCell(Row, "sheet2_eq_no",true);
					return false;
 				}
 			}
 			
 		} else {
 			//TpSz
 			sheetObjects[1].SetCellValue(Row,"sheet2_eq_tpsz_cd","",0);
 			//Lstm
 			sheetObjects[1].SetCellValue(Row,"sheet2_lstm_cd","",0);
 			//Yard
 			sheetObjects[1].SetCellValue(Row,"sheet2_mnr_disp_sel_flg_yd_cd","",0);
 			//RU
 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_tp","",0);
 			sheetObjects[1].SetCellValue(Row,"sheet2_rstr_usg_lbl_desc","",0);
 		}
 		calReq=0;
 	}
 	
	function initControl() {
		//Axon event handling 1. Catching event
		var formObject=document.form;
		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
		//axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
		// axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
 	}
	
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
		var formObject=document.form;
		ComChkObjValid(ComGetEvent());
		obj=ComGetEvent();
		if(obj.name=="fryear" || obj.name=="toyear" )
		{
			keys=event.keyCode;
			if(formObject.fryear!=undefined)
			{
				va=formObject.fryear.value;
				va=va.split(",");
				formObject.fryear.value=va.join("");
			}
			if(formObject.toyear!=undefined)
			{
				va=formObject.toyear.value;
				va=va.split(",");
				formObject.toyear.value=va.join("");
			}
		}
	}
	
	/**
	 * Processing the returned data of rep_Multiful_inquiry
	 * @param	{Array}		rowArray	Retruned array
	 * @param	{String}	return_val	Retruned form element name
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form;
 		var tempText="";
 		//Initializing
		eval("document.form." + return_val + ".value='';");
 		for(var i=0; i < rowArray.length; i++) {
 			tempText +=  rowArray[i] + ',';
 		}
 		//Removing last comma
		tempText=MnrDelLastDelim(tempText);
 		eval("document.form." + return_val + ".value='" + tempText + "';");
 	}
	
	function obj_activate(){
		ComClearSeparator(ComGetEvent());
	}
	
	function obj_change()
	{
		var obj= ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" )
		{
			switch(ComGetEvent("name"))
			{
			case "empty":
  				break;
			}
		}
	}
	
//	function obj_keypress(){
//		obj=ComGetEvent();
//		keys=event.keyCode;
//		if(obj.dataformat == null) return;
//		window.defaultStatus=obj.dataformat;
//		var formObj=document.form;
//		if ( ComTrim(obj.value) != "" ) {
//			switch(ComGetEvent("name")) {
//			case "empty":
//  				break;
//			}
//		}
//		switch(obj.dataformat) {
//        case "ymd":
//		case "int":
//			ComKeyOnlyNumber(obj);
//			break;
//		case "float":
//			ComKeyOnlyNumber(obj, "-.");
//			break;
//		case "eng":
//			ComKeyOnlyAlphabet();
//			break;
//		case "engup":
//			ComKeyOnlyAlphabet('uppernum');
//			break;
//		case "int":
//			ComKeyOnlyNumber(obj);
//			break;
//		}
//	}
	
	/**
	 * Setting displayed of save button
	 * @return
	 */
	function setSaveBtnDisplay() {
		if(strMnrOfficeLevel=="L1") {
			ComBtnEnable("btn_save");
		} else {
			ComBtnDisable("btn_save");
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
	
	function sheet2_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		for(var i=1; i<sheetObj.RowCount()+1; i++){
			var checkEqn=sheetObj.GetCellValue(i,"sheet2_eq_no");
			sheetObj.SetCellValue(i,"sheet2_eq_no",checkEqn.toUpperCase(),0);
			checkEqn=checkEqn.toUpperCase();
			var retArray=MnrGeneralCodeCheck(sheetObjects[0],"ESTEQN",checkEqn + "," + combo_eq_knd_cd.GetSelectCode());
			if(retArray == null){
				ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
				sheetObjects[1].SetCellValue(i,"sheet2_eq_no","",0);
			} else {
				setEqInfo(sheetObjects[2],i,combo_eq_knd_cd.GetSelectCode(),checkEqn,ComGetNowInfo("ymd"));
			}
			if(sheetObj.GetCellValue(i, "sheet2_disp_rsn_cd") == ""){
				sheetObj.SetCellValue(i, "sheet2_disp_rsn_cd","C",0);
			}
			sheetObj.SetCellValue(i, "sheet2_mnr_disp_sel_flg","1",0);
			sheetObj.SetCellEditable(i,"sheet2_mnr_disp_sel_flg",0);
			sheetObj.SetCellValue(i, "sheet2_eq_knd_cd",combo_eq_knd_cd.GetSelectCode(),0);
		}
		
		setSaveBtnDisplay();
	}