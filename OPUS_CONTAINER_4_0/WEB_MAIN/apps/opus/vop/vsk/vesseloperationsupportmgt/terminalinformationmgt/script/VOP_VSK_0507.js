/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0507.js
*@FileTitle  : Terminal Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================
*/

/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_vsk_0507 : business script for vop_vsk_0507
     */
   
	// public variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var marrPrefix=new Array("t1sheet1_", "t2sheet1_", "t3sheet1_", "t4sheet1_");
	var marrTabTitle=new Array("G/Crane", "F/Crane", "Gang Structure", "Berth Window");
	//day Array{}
	var marrWeekNm=new Array("sun", "mon", "tue", "wed", "thu", "fri", "sat");
	var mQuestion=true;
	var mClearData=true;
	var mPreviousTab=0;
	var mCheckKey=true;
	var mCheckValue=false;
	var mEditRow=0;
	var arrGCraneCombo=new Array();
	var arrSearchCond=new Array("", "", "");
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         var sheetObject3=sheetObjects[2];
         var sheetObject4=sheetObjects[3];
         var sheetObject5=sheetObjects[4];
         /*******************************************************/
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;  
				switch(srcName) {
					case "btn_t1RowAdd":
						var row=sheetObject1.DataInsert(-1);
						//sheetObject1.SelectCell(row, "t1sheet1_yd_cd", true);
						break;
					case "btn_t1RowInsert":
						var row=sheetObject1.DataInsert();
						//sheetObject1.SelectCell(row, "t1sheet1_yd_cd", true);
						break;
					case "btn_t1Delete":
						ComRowHideDelete(sheetObject1,"t1sheet1_del_chk");
						break;
					case "ComOpenPopupWithTarget":
        				ComOpenPopup("VOP_VSK_0043.do", 990, 520, "returnPortHelp", "0,0", true);
						break;
					case "btn_t2RowAdd":
						var row=sheetObject2.DataInsert(-1);
						//sheetObject2.SelectCell(row, "t2sheet1_loc_cd");
						break;
					case "btn_t2RowInsert":
						var row=sheetObject2.DataInsert();
						//sheetObject2.SelectCell(row, "t2sheet1_loc_cd");
						break;
					case "btn_t2Delete":
						ComRowHideDelete(sheetObject2,"t2sheet1_del_chk");
						break;
					case "btn_t3RowAdd":
						var row=sheetObject3.DataInsert(-1);
						//sheetObject3.SelectCell(row, "t3sheet1_loc_cd");
						break;
					case "btn_t3RowInsert":
						var row=sheetObject3.DataInsert();
						//sheetObject3.SelectCell(row, "t3sheet1_loc_cd");
						break;
					case "btn_t3Delete":
						ComRowHideDelete(sheetObject3,"t3sheet1_del_chk");
						break;
					case "btn_t4RowAdd":
						var row=sheetObject4.DataInsert(-1);
						sheetObject4.SetCellValue(row, "t4sheet1_loc_cd",formObject.loc_cd.value);
						if(row > 1){
							sheetObject4.SetCellValue(row, "t4sheet1_yd_cd",sheetObject4.GetCellValue(row - 1, "t4sheet1_yd_cd"));
						}
						sheetObject4.SelectCell(row, "t4sheet1_yd_cd");
						break;
					case "btn_t4RowInsert":
						var row=sheetObject4.DataInsert();
						sheetObject4.SetCellValue(row, "t4sheet1_loc_cd",formObject.loc_cd.value);
						if(row > 1){
							sheetObject4.SetCellValue(row, "t4sheet1_yd_cd",sheetObject4.GetCellValue(row - 1, "t4sheet1_yd_cd"));
						}
						sheetObject4.SelectCell(row, "t4sheet1_yd_cd");
						break;
					case "btn_t4Delete":
						ComRowHideDelete(sheetObject4, "t4sheet1_del_chk");
						break;
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
						break;
					case "btn_New":
						var statsCnt=changeSheet();
						if(statsCnt > 0){
							if(ComShowCodeConfirm("VSK50012")){
								clearFormNData();
								moveFocus(beforetab);
							}
						} else{
							clearFormNData();
							moveFocus(beforetab);
						}
						break;
					case "btn_Save":
						mQuestion=true;
						doActionIBSheet(sheetObjects[beforetab], document.form, IBSAVE);
						doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);	
						break;
					case "btn_t1DownExcel1":
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								//sheetObject1.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
							}
						// false, "t1sheet1_del_chk|t1sheet1_upd_usr_id|t1sheet1_upd_dt", "", false, false, "");
						break;
					case "btn_t2DownExcel1":
						if(sheetObject2.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								//sheetObject2.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject2.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject2),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
							}
						// false, "t2sheet1_del_chk|t2sheet1_upd_usr_id|t2sheet1_upd_dt", "", false, false, "");
						break;
					case "btn_t3DownExcel1":
						if(sheetObject3.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								//sheetObject3.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject3.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject3),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
							}
						// false, "t3sheet1_del_chk|t3sheet1_upd_usr_id|t3sheet1_upd_dt", "", false, false, "") ;
						break;
					case "btn_t4DownExcel1":
						var deleteCol="t4sheet1_del_chk|t4sheet1_loc_cd|t4sheet1_etb_dy_cd|t4sheet1_etb_tm_hrmnt|t4sheet1_etd_dy_cd|t4sheet1_etd_tm_hrmnt|t4sheet1_upd_usr_id|t4sheet1_upd_dt";
						if(sheetObject4.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
							}else{
								//sheetObject4.Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetDesign:1 });
								sheetObject4.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject4),KeyFieldMark:0,HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
							}
						// false, deleteCol, "", false, false, "") ;
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
	 * after [Port] Button Click, calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.loc_cd.value=rtnDatas;
				}
			}
		}
		
	}
	
    /**
    * registering initial event  
    */
    function initControl() {
    	axon_event.addListener('blur', 'gntr_rmk_onchange', 'gntr_rmk', '');
//    	axon_event.addListener('change', 'por_rhq_OnChange', 'por_rhq');
    	axon_event.addListener('change', 'fltg_rmk_onchange', 'fltg_rmk');
    	axon_event.addListener('keyup', 'loc_cd_onkeyup', 'loc_cd', '');
    	axon_event.addListener('keypress', 'loc_cd_onkeypress', 'loc_cd', '');
		axon_event.addListener('blur', 'loc_cd_onblur', 'loc_cd');
		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form);
        axon_event.addListenerFormat('focus',			'obj_activate',		form);
        //axon_event.addListenerFormat('keypress',        'obj_keypress', 	form);
    }
    
    function dateFormat(n, digits) {
    	var zero='';
    	n=n.toString();
    	if (n.length < digits) {
    		for (i=0; i < digits - n.length; i++)
    	    zero += '0';
    	}
    	return zero + n;
    }
    /**
     * Deleting mask separator in onfocus event
     **/
    function obj_activate(){
        ComClearSeparator(ComGetEvent());
    }
    /**
     * Making mask separator, Checking Validation
     **/
	function obj_deactivate(){
		ComChkObjValid(ComGetEvent());
	}
    /**
     * Handling key press event
     **/
//    function obj_keypress(){
//    	switch(event.srcElement.dataformat){
//			case "int":
//		        ComKeyOnlyNumber(ComGetEvent());
//				break;
//			case "float":
//		        ComKeyOnlyNumber(ComGetEvent(), ".");
//				break;
//			default:
//		        ComKeyOnlyNumber(ComGetEvent());
//    	}
//    }
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
		for(k=0; k < tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		/*for(i=0;i<sheetObjects.length;i++){
        	doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }*/
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
		initControl();
		portCdInit();
//		document.form.loc_cd.focus();
//		document.t3sheet1.SetMergeCell(0, 1, 2, 1);
//		document.t3sheet1.SetMergeCell(0, 3, 2, 1);
//		document.t3sheet1.SetMergeCell(0, 8, 2, 1);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel.|TMNL Code|TMNL Name|Max Weight with\nSpreader (Ton)|Max Weight without\nSpreader (Ton)|Clearance between\nLegs (M)|Reach\nRows|Tier|G/Crane Q’ty|G/Crane Q’ty|Remark|upd_usr_id|upd_usr_id";
	              var HeadTitle2="|Sel.|TMNL Code|TMNL Name|Max Weight with\nSpreader (Ton)|Max Weight without\nSpreader (Ton)|Clearance between\nLegs (M)|Reach\nRows|Tier|Total gang in TMNL|Max gang per Vessel|Remark|upd_usr_id|upd_usr_id";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t1sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
	                     {Type:"ComboEdit", Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, InputCaseSensitive:1, AcceptKeys:"E|N"},
	                     {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:1,   SaveName:prefix+"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"grs_max_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"net_max_wgt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"clr_btwn_leg_wdt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
	                     {Type:"Int",       Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_rch_row_knt",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Int",       Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_tr_knt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                     {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_gntr_crn_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"vsl_gntr_crn_max_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"gntr_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              // InitDataValid(0, prefix + "yd_cd", vtEngUpOther, "0123456789");
	              SetColProperty(0 , prefix + "yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	              SetSheetHeight(390);
	              
              }
			break;
			
            case "t2sheet1":
                with(sheetObj){
					var HeadTitle1="|Sel.|Port|Seq.||Handling Cargo Weight (Ton)|Handling Cargo Height (M)|Crane Reach (M)|Handling Cost (Remark)|Remark(s)|upd_usr_id|upd_usr_id";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="t2sheet1_";
					SetConfig( { SearchMode:0, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
								{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
								{Type:"ComboEdit",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E|N" },
								
								{Type:"Text",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crn_view_seq",          KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",       Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crn_seq",          KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								
								{Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"max_hndl_cgo_wgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
								{Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"max_hndl_cgo_hgt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
								{Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"max_rch_len",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
								{Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hndl_cost_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
								{Type:"Text",      Hidden:1, Width:105,  Align:"Left",    ColMerge:0,   SaveName:prefix+"fltg_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
								{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					InitColumns(cols);
					SetEditable(1);
					SetSheetHeight(390);
				}
			break;
			
            case "t3sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel.|Port|Seq.||Gang Working Time|Gang Working Time|Break/Meal Time (Standard)|Break/Meal Time (Standard)|Remark(s)|upd_usr_id|upd_usr_id";
	              var HeadTitle2="|Sel.|Port|Seq.||From|To|From|To|Remark(s)|upd_usr_id|upd_usr_id";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="t3sheet1_";
	              SetConfig( { SearchMode:0, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
	                     {Type:"ComboEdit",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E|N"  },
	                     
	                     {Type:"Text",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crn_view_seq",             KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",       Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"crn_seq",             KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_wrk_st_hrmnt",    KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_wrk_end_hrmnt",   KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_nwork_st_hrmnt",  KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gng_nwork_end_hrmnt", KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:prefix+"gng_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetSheetHeight(390);
	              // InitDataValid(0, prefix + "loc_cd", vtEngUpOnly);
              }
			break;
			
            case "t4sheet1":
                with(sheetObj){
	              var HeadTitle1="|Sel|loc_cd|TMNL Code|TMNL Name|Lane Code|Bound|Carrier|etb_dy_cd|etb_tm_hrmnt|etd_dy_cd|etd_tm_hrmnt|upd_usr_id|upd_usr_id|brth_seq";
	              for (var weekCnt=0; weekCnt < marrWeekNm.length; weekCnt++){
	            	  HeadTitle1=HeadTitle1 + "|" + marrWeekNm[weekCnt].toUpperCase();
	            	  HeadTitle1=HeadTitle1 + "|" + marrWeekNm[weekCnt].toUpperCase();
	              }
	              var headCount= ComCountHeadTitle(HeadTitle1);
	              var prefix="t4sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:11, DataRowMerge:0 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"loc_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
		                     {Type:"ComboEdit", Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",                         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7, InputCaseSensitive:1, AcceptKeys:"E|N"},
		                     {Type:"Text",      Hidden:0,  Width:155,   Align:"Left",    ColMerge:0,   SaveName:prefix+"yd_nm",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Popup", Hidden:0, Width:80,   Align:"Center",    ColMerge:0,   SaveName:prefix+"ref_slan_nm",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3, InputCaseSensitive:1},
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_dir_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Popup", Hidden:0, Width:80,   Align:"Center",    ColMerge:0,   SaveName:prefix+"crr_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3, InputCaseSensitive:1},
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_usr_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"upd_dt",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"brth_seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_dy_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_tm_hrmnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_dy_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_tm_hrmnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              for(var weekCnt = 0; weekCnt < marrWeekNm.length; weekCnt++){
	            	  cols.push({Type:"Text",      Hidden:0,  Width:68,   Align:"Center",  ColMerge:0,   SaveName:prefix+"etd_tm_"+marrWeekNm[weekCnt]+"_am",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0});
	            	  cols.push({Type:"Text",      Hidden:0,  Width:68,   Align:"Center",  ColMerge:0,   SaveName:prefix+"etd_tm_"+marrWeekNm[weekCnt]+"_pm",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0});
	              }
	              InitColumns(cols);
	              SetEditable(1);
	              SetColProperty(prefix+"etb_tm_hrmnt", {Format:"##:##"} );
	              SetColProperty(prefix+"etd_tm_hrmnt", {Format:"##:##"} );
	              SetColProperty(0 , prefix + "yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	              sheetHeaderBackColor(sheetObj, prefix  + "etd_tm_" + marrWeekNm[0] + "_am", prefix  + "etd_tm_" + marrWeekNm[0] + "_pm", "#FF7D7D");
	              sheetHeaderBackColor(sheetObj, prefix  + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_am", prefix  + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_pm", "#7D7DFF");
	              SetShowButtonImage(2);
	              SetSheetHeight(390);
	              SelectHighLight=false;
              }
			break;
			
            case "sheet1":
                with(sheetObj){
	              var HeadTitle1="|Value|Name";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              var prefix="sheet1_";
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"val" },
	                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"name" } ];
	               
	              InitColumns(cols);
	              SetSheetHeight(50);
	              SetEditable(1);
            	}
			break;
        }
    }
    
	function initCombo(comboObj, comboNo) {
		switch(comboObj.options.id) {
			case "por_rhq":    //R/D Term-post
				var i=0;
				with(comboObj) {
//					style.width=90;
					SetColWidth(0, 90);
//					SetDropHeight(150);
					InsertItem(i++,  "ALL",	"%");
					SetBackColor("#CCFFFD");
					SetSelectCode("%");
				}
				break;
			case "flt_type":    //R/D Term-post
				var i=0;
				with(comboObj) {
//					style.width=230;
					SetColWidth(0, 230);
					SetDropHeight(150);
					SetMaxSelect(1);
					SetSelectCode("%");
				}
				break;
		}
	}
	
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case SEARCH01:
				formObj.f_cmd.value=SEARCH01;
				var sParam=FormQueryString(formObj)
				var sXml=sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
				var rhqlist=ComGetEtcData(sXml, "rhqlist");
				if(rhqlist){
					var comboObj=comboObjects[0];
					var rhqs=rhqlist.split(":");
					for(var i=0; i<rhqs.length; i++){
						comboObj.InsertItem(-1, rhqs[i], rhqs[i]);
					}
				}
			break; 
			
			case IBSEARCH:		//Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					//in case search condition change, and sheet data change
					if(arrSearchCond[0] != ""){
						var changeYn=false;
						if(arrSearchCond[0] != formObj.loc_cd.value)
							changeYn=true;
						if(arrSearchCond[1] != (enablePorRhq.style.display == "inline" ? por_rhq.options.id: document.form.por_rhq_diable.value))
							changeYn=true;
						//in case data change
						if(changeYn){
							removeSheet();
						}
					}
					if ( sheetObj.id == "t1sheet1"){
						formObj.f_cmd.value=SEARCH01;
						var arr="t1sheet1_";
						var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.LoadSearchData(sXml,{Sync:0} );
						sheetObj.RenderSheet(1);
					}else if ( sheetObj.id == "t2sheet1"){
						formObj.f_cmd.value=SEARCH02;
						var arr=new Array("t2sheet1_", "");
						var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
						var arrXml=sXml.split("|$$|");
						var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
						if(arrCombo != null){
							var vInitDataComboName="";
							var arrVal=arrCombo[0].split("|");
							var arrName=arrCombo[1].split("|");
							for(var j=0; j<arrVal.length ; j++)
							{
								if(j == 0)
							    	vInitDataComboName=vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
								else
									vInitDataComboName=vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
							}
							sheetObj.SetColProperty("t2sheet1_loc_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+arrCombo[0]} );
						}										
						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.LoadSearchData(arrXml[0],{Sync:0} );
						sheetObj.RenderSheet(1);
					} else if ( sheetObj.id == "t3sheet1"){
						formObj.f_cmd.value=SEARCH03;
						var arr=new Array("t3sheet1_", "");
						var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
						var arrXml=sXml.split("|$$|");
						var arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
						sheetObj.SetColProperty("t3sheet1_loc_cd", {ComboText:"", ComboCode:""} );
						if(arrCombo != null){
							var vInitDataComboName="";
							var arrVal=arrCombo[0].split("|");
							var arrName=arrCombo[1].split("|");
							for(var j=0; j<arrVal.length ; j++)
							{
								if(j == 0)
							    	vInitDataComboName=vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
								else
									vInitDataComboName=vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
							}
							sheetObj.SetColProperty("t3sheet1_loc_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+arrCombo[0]} );
						}									
						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.LoadSearchData(arrXml[0],{Sync:0} );
						sheetObj.RenderSheet(1);
					} else if ( sheetObj.id == "t4sheet1"){
						formObj.f_cmd.value=SEARCH04;
						var arr="t4sheet1_";
						var sXml=sheetObj.GetSearchData("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.LoadSearchData(sXml,{Sync:0} );
						sheetObj.RenderSheet(1);
						//sheet coloring
						
					}
					arrSearchCond[0]=formObj.loc_cd.value;
					arrSearchCond[1]=(enablePorRhq.style.display == "inline" ? por_rhq.options.id: document.form.por_rhq_diable.value);
				}
			break;
			
			case IBSAVE:			//save
				
				formObj.f_cmd.value=MULTI;
				var sParam="";
				sParam=ComGetSaveString(sheetObjects);	
				if (sParam == "") return;
				formObj.gntr_rmk.value = VopAsciiRemove(formObj.gntr_rmk.value);
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObjects[beforetab].GetSaveData("VOP_VSK_0507GS.do", sParam);
				sheetObjects[0].LoadSaveData(sXml);
				//showing message once, after that message delete
				sXml=ComDeleteMsg(sXml);
				
				sheetObjects[1].LoadSaveData(sXml);
				//doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
				
				sheetObjects[2].LoadSaveData(sXml);
				//doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
				
				sheetObjects[3].LoadSaveData(sXml);
				if(sXml.indexOf("<TR-ALL>OK</TR-ALL>") > 0 && marrTabTitle[beforetab] == "Berth Window"){
					doActionIBSheet(sheetObjects[3], formObj, IBSEARCH);
				}
			break;
       }
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					for(; cnt < marrTabTitle.length; cnt++){
						InsertItem( marrTabTitle[cnt] , "");
					}
                }
             break;
         }
         tabObj.SetSelectedIndex(0);
    }
    /**
     * Handling tab click event
     * Activating clicked tab
     */
    function tab1_OnChange(tabObj , nItem)
    {
    	 formObject = document.form;
	   	 var objs=document.all.item("tabLayer");
	   	 objs[nItem].style.display="Inline";
	   	 for(var i = 0; i<objs.length; i++){
	       	  if(i != nItem){
	        	   objs[i].style.display="none";
	        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	       	  }
	   	 }
		if(nItem == 0 || nItem == 3){
			document.all.item("disablePorRhq").style.display="inline";
			document.all.item("enablePorRhq").style.display="none";
			document.form.loc_cd.className="input1";
		}else{
			document.all.item("disablePorRhq").style.display="none";
			document.all.item("enablePorRhq").style.display="inline";
			document.form.loc_cd.className="input";
		}
		beforetab=nItem;
 		if(document.form.loc_cd.value.length == 5 ){
			doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
		}else if(document.form.loc_cd.value == "" && (beforetab == 1 || beforetab == 2) ){
			doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
		}
		moveFocus(nItem);
	}
	/**
	 *	Sheet Event Start
	 */
    var checkyDcDFlg1=false;  //Tmml Code check flag        
	function t1sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.gntr_rmk.value=sheetObj.GetCellValue(Row, "t1sheet1_gntr_rmk");
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t1sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t1sheet1_upd_usr_id");
		if(sheetObj.ColSaveName(Col) == "t1sheet1_yd_cd"){
			if(!checkyDcDFlg1){
				sheetObj.SelectCell(Row, "t1sheet1_yd_cd", true);
			}
		}
	}
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			document.form.gntr_rmk.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_gntr_rmk");
			document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_dt");
			document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t1sheet1_upd_usr_id");
		}
	}
    function t1sheet1_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t1sheet1_yd_cd"){
    		duplCheck(sheetObj, Row, Col, Value, "t1sheet1_yd_cd");	//imdg_segr_grp_no Value Duplication Check
			checkyDcDFlg1=false;
			var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
			var arrCode=sCode.split("|");
			for(var i=0 ; i<arrCode.length ; i++){
				if(arrCode[i] == Value ){
					checkyDcDFlg1=true;
				}
			}
			//if valid tmnl code is not exist, focus on TMNL Code
			if(!checkyDcDFlg1){
				//length(7) check, and valid tmnl check 
			if(sheetObj.GetCellValue(Row, "t1sheet1_yd_cd") != "" ){
				if(sheetObj.GetCellValue(Row, "t1sheet1_yd_cd").length < 7){
						ComShowCodeMessage("VSK50018");
				} else{
						ComShowCodeMessage("VSK50020");
					}
				}
				sheetObj.SetCellValue(Row, "t1sheet1_yd_cd","");
				sheetObj.SelectCell(Row, "t1sheet1_yd_cd", true);
			}
			if(checkyDcDFlg1){
				var sText=sheetObj.GetComboInfo(Row, Col, "Text");
				var arrText=sText.split("|");
				var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
				var vText=arrText[idx].split("\t");
				sheetObj.SetCellValue(Row, "t1sheet1_yd_nm",vText[1]);
			}
			} else if(sheetObj.ColSaveName(Col) == "t1sheet1_grs_max_wgt" || sheetObj.ColSaveName(Col) == "t1sheet1_net_max_wgt"){
				if(sheetObj.GetCellValue(Row, "t1sheet1_grs_max_wgt") != "0" && sheetObj.GetCellValue(Row, "t1sheet1_net_max_wgt") != "0" && (parseInt(sheetObj.GetCellValue(Row, "t1sheet1_grs_max_wgt")) > parseInt(sheetObj.GetCellValue(Row, "t1sheet1_net_max_wgt"))))
				{
					ComShowCodeMessage("VSK57015", "Max Weight without Spreader", "Max Weight with Spreader");
					sheetObj.SetCellValue(Row, "t1sheet1_grs_max_wgt","");
					sheetObj.SetCellValue(Row, "t1sheet1_net_max_wgt","");
				}
		}
   	}
	function t1sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t1sheet1_yd_cd"){
			if(!checkyDcDFlg1){
				sheetObj.SelectCell(NewRow, "t1sheet1_yd_cd", true);
			}
		}
	}
	
    var checkyDcDFlg2=false;  //valid TMNL Code check
	function t2sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.fltg_rmk.value=sheetObj.GetCellValue(Row, "t2sheet1_fltg_rmk");
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t2sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t2sheet1_upd_usr_id");
		if(sheetObj.ColSaveName(Col) == "t2sheet1_loc_cd"){
			if(!checkyDcDFlg2){
				sheetObj.SelectCell(Row, "t2sheet1_loc_cd", true);
			}
		}
	}
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			document.form.fltg_rmk.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_fltg_rmk");
			document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_upd_dt");
			document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t2sheet1_upd_usr_id");
		}
	}
	function t2sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix="t2sheet1_"; 
		if(sheetObj.ColSaveName(Col) == prefix + "loc_cd"){
			checkyDcDFlg2=false;
			var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
			var arrCode=sCode.split("|");
			for(var i=0 ; i<arrCode.length ; i++){
				if(arrCode[i] == Value ){
					checkyDcDFlg2=true;
					break;
				}
			}
			if(!checkyDcDFlg2){
				//length(7) check, and valid tmnl check 
				if(sheetObj.GetCellValue(Row, "t2sheet1_loc_cd") != "" ){
					if(sheetObj.GetCellValue(Row, "t2sheet1_loc_cd").length < 5){
						ComShowCodeMessage("VSK50025");
						sheetObj.SetCellValue(Row, Col,"");
						sheetObj.SetCellValue(Row, Col + 1,"");
						sheetObj.SelectCell(Row, "t2sheet1_loc_cd", true);
					}else{
						ComShowCodeMessage("VSK50026");
						sheetObj.SetCellValue(Row, Col,"");
						sheetObj.SetCellValue(Row, Col + 1,"");
						sheetObj.SelectCell(Row, "t2sheet1_loc_cd", true);
					}
				}
			}
			if(checkyDcDFlg2){
				//sheetObj.SelectCell(Row, prefix +"max_hndl_cgo_wgt", true);
			}
		}
	}
	function t2sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t2sheet1_loc_cd"){
			if(!checkyDcDFlg2){
				sheetObj.SelectCell(NewRow, "t2sheet1_loc_cd", true);
			}
		}
	}

	
    var checkyDcDFlg3=false;  //valid tmnl check     
	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t3sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t3sheet1_upd_usr_id");
		if(sheetObj.ColSaveName(Col) == "t3sheet1_loc_cd"){
			if(!checkyDcDFlg3){
				sheetObj.SelectCell(Row, "t3sheet1_loc_cd", true);
			}
		}
	}
	
	function t3sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix="t3sheet1_"; 
		if(sheetObj.ColSaveName(Col) == prefix + "loc_cd"){
			checkyDcDFlg3=false;
			var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
			var arrCode=sCode.split("|");
			for(var i=0 ; i<arrCode.length ; i++){
				if(arrCode[i] == Value ){
					checkyDcDFlg3=true;
					break;
				}
			}
			if(!checkyDcDFlg3){
				if(sheetObj.GetCellValue(Row, "t3sheet1_loc_cd") != "" ){
					if(sheetObj.GetCellValue(Row, "t3sheet1_loc_cd").length < 5){
						ComShowCodeMessage("VSK50025");
						sheetObj.SetCellValue(Row, Col,"");
						sheetObj.SetCellValue(Row, Col + 1,"");
						sheetObj.SelectCell(Row, "t3sheet1_loc_cd", true);
					}else{
						ComShowCodeMessage("VSK50026");
						sheetObj.SetCellValue(Row, Col,"");
						sheetObj.SetCellValue(Row, Col + 1,"");
						sheetObj.SelectCell(Row, "t3sheet1_loc_cd", true);
					}
				}
			}
			if(checkyDcDFlg3){
				//sheetObj.SelectCell(Row, "t3sheet1_gng_wrk_st_hrmnt", true);
			}
		}
	}
	
	function t3sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t3sheet1_loc_cd"){
			if(!checkyDcDFlg3){
				sheetObj.SelectCell(NewRow, "t3sheet1_loc_cd", true);
			}
		}
	}
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t3sheet1_upd_dt");
			document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t3sheet1_upd_usr_id");
		}
	}
    var checkyDcDFlg4=false;  //Tmnl Code Check Flag        
    var checkLane=false;        
    var checkCarrier=false;      
	function t4sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value=sheetObj.GetCellValue(Row, "t4sheet1_upd_dt");
		document.form.upd_id_view.value=sheetObj.GetCellValue(Row, "t4sheet1_upd_usr_id");
		if(sheetObj.ColSaveName(Col) == "t4sheet1_yd_cd"){
			if(!checkyDcDFlg1){
				sheetObj.SelectCell(Row, "t4sheet1_yd_cd", true);
			}
		}
	}
	
    function t4sheet1_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t4sheet1_yd_cd" || sheetObj.ColSaveName(Col) == "t4sheet1_slan_cd" || sheetObj.ColSaveName(Col) == "t4sheet1_skd_dir_cd" || sheetObj.ColSaveName(Col) == "t4sheet1_crr_cd" )
		{
		}
		if(sheetObj.ColSaveName(Col) == "t4sheet1_yd_cd"){
			checkyDcDFlg4=false;
			var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
			var arrCode=sCode.split("|");
			for(var i=0 ; i<arrCode.length ; i++){
				if(arrCode[i] == Value ){
					checkyDcDFlg4=true;
				}
			}
			if(!checkyDcDFlg4){
				//length(7) check, and valid tmnl check
				if(sheetObj.GetCellValue(Row, "t4sheet1_yd_cd") != "" ){
					if(sheetObj.GetCellValue(Row, "t4sheet1_yd_cd").length < 7){
						ComShowCodeMessage("VSK50018");
					}else{
						ComShowCodeMessage("VSK50020");
					}
				}
				sheetObj.SetCellValue(Row, "t4sheet1_yd_cd","");
				sheetObj.SelectCell(Row, "t4sheet1_yd_cd", true);
			} else{
			 	var sText=sheetObj.GetComboInfo(Row, Col, "Text");
				var arrText=sText.split("|");
				var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
				var vText=arrText[idx].split("\t");
				sheetObj.SetCellValue(Row, "t4sheet1_yd_nm",vText[1]);
			}
		}
   	}
    
	function t4sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t4sheet1_yd_cd"){
			if(!checkyDcDFlg4){
				sheetObj.SelectCell(NewRow, "t4sheet1_yd_cd", true);
			}
		}
	}
	
	function t4sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
		if(sheetObj.ColSaveName(Col) == "t4sheet1_slan_cd"){
			if(sheetObj.GetCellValue(Row, Col).length > 2){
				sheetObj.SelectCell(Row, "skd_dir_cd");
			}
		}
	}
	
	function t4sheet1_OnDblClick(sheetObj, Row, Col){
		if(Col > sheetObj.SaveNameCol("t4sheet1_upd_dt"))
			ComOpenPopup('/opuscntr/VOP_VSK_0703.do?enableForm=Y', 500, 275, "returnLoc", "0,0", true);
			
	}
	
	function returnLoc( obj ){
		alert( obj);
	}
	
	function t4sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t4sheet1_ref_slan_nm"){
			ComOpenPopup('/opuscntr/COM_ENS_081.do', 830, 450, "setLaneInfo", "0,0,1,1,1,1", false, false, Row, Col, 0);
			
		}else if(sheetObj.ColSaveName(Col) == "t4sheet1_crr_cd"){
			//ComOpenPopup("/opuscntr/COM_ENS_0N1.do", 530, 450, "setVslOprTpCd", "0,0", true);
			ComOpenPopup("COM_ENS_0N1.do", 550, 500, "setVslOprTpCd", "0,0,1,1,1,1", false, false, Row, Col, 0);
		}
	}
	
	function t4sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
		if(sheetObj.RowCount()> 0){
			var prefix="t4sheet1_";
			for(var cnt=1; cnt <= sheetObj.RowCount(); cnt++){
				var amPmS=parseInt(sheetObj.GetCellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2)) < 12 ? "am" : "pm";
				var amPmE=parseInt(sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2)) <= 12 ? "am" : "pm";
				
				if(sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2) == "00"){
					amPmE = "pm";
				}
				
				var colName3=prefix +  "etd_tm_" + sheetObj.GetCellValue(cnt, prefix + "etb_dy_cd").toLowerCase() + "_"  + amPmS;
				var colName4=prefix +  "etd_tm_" + sheetObj.GetCellValue(cnt, prefix + "etd_dy_cd").toLowerCase() + "_"  + amPmE;
				sheetSetBackColor(sheetObj, cnt, colName3, colName4);
				sheetSetForeColor(sheetObj, cnt, colName3, colName4);
				for(var col=sheetObj.SaveNameCol(prefix + "etd_tm_" + marrWeekNm[0] + "_am");
						col <= sheetObj.SaveNameCol(prefix + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_pm"); col++){
					sheetObj.SetCellValue(cnt, col,"    ");
				}
				if(colName3 == colName4){
					sheetObj.SetCellValue(cnt, colName3,sheetObj.GetCellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2) + "/" + sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2));
				}else{
					sheetObj.SetCellValue(cnt, colName3,sheetObj.GetCellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2));
					sheetObj.SetCellValue(cnt, colName4,sheetObj.GetCellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2));
				}
				sheetObj.SetRowStatus(cnt,"R");
			}
		}
		
		if(sheetObj.RowCount()> 0){
			document.form.upd_dt_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t4sheet1_upd_dt");
			document.form.upd_id_view.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "t4sheet1_upd_usr_id");
		}
	}
	function t4sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix="t4sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd"){
			mCheckValue=true;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
		if(sheetObj.RowCount()> 0){
			if(document.form.f_cmd.value == SEARCH05){
				if(beforetab == 1){
					sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "t2sheet1_crn_seq",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val"));
					sheetObjects[1].SelectCell(sheetObjects[1].GetSelectRow(), "t2sheet1_max_hndl_cgo_wgt", true);
				}
			} else if(document.form.f_cmd.value == SEARCH20){
			    if(beforetab == 2){
			    	sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "t3sheet1_crn_seq",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val"));
				    sheetObjects[2].SelectCell(sheetObjects[2].GetSelectRow(), "t3sheet1_gng_wrk_st_hrmnt", true);
			    }
			} else if(document.form.f_cmd.value == SEARCH06){
				por_rhq.SetSelectCode(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val"));
				document.form.por_rhq_diable.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_val");
				document.form.f_cmd.value=SEARCH07;
				var sXml=sheetObjects[1].GetSearchData("VOP_VSK_0507GS.do", FormQueryString(document.form));
				var arrCombo=ComXml2ComboString(sXml, "val", "name");
				if(arrCombo != null){
					var vInitDataComboName="";
					var arrVal=arrCombo[0].split("|");
					var arrName=arrCombo[1].split("|");
					for(var j=0; j<arrVal.length ; j++)
					{
						if(j == 0)
					    	vInitDataComboName=vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
						else
							vInitDataComboName=vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
					}
					sheetObjects[0].SetColProperty("t1sheet1_yd_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+arrCombo[0]} );
					sheetObjects[3].SetColProperty("t4sheet1_yd_cd", {ComboText:"|"+vInitDataComboName, ComboCode:"|"+arrCombo[0]} );
				}
			}
		} else{
			if(document.form.f_cmd.value == SEARCH06){
				ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
				ComClearObject(formObj.loc_cd);
				ComClearObject(formObj.por_rhq_diable);
				por_rhq.SetSelectCode("%");
				sheetObjects[0].SetColProperty("t1sheet1_yd_cd", {ComboText:"", ComboCode:""} );
			} else if(document.form.f_cmd.value == SEARCH03){
				ComShowCodeMessage("VSK50028");
				sheetObjects[3].SelectCell(mEditRow, "t4sheet1_slan_cd", true);
			} else if(document.form.f_cmd.value == SEARCH04){
				ComShowCodeMessage("VSK50030");
				sheetObjects[3].SelectCell(mEditRow, "t4sheet1_crr_cd", true);
			}
		}
	}
	/**
	 *	Sheet Event End
	 */
	/**
	 * vsl_opr_tp_cd<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setLaneInfo(aryPopupData, Row, Col, sheetIdx){
		mCheckValue= false;
		sheetObjects[3].SetCellValue(Row,Col,aryPopupData[0][3],0);
	}
	/**
	 * vsl_opr_tp_cd<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setVslOprTpCd(aryPopupData, Row, Col, sheetIdx){
		mCheckValue=false;
		sheetObjects[3].SetCellValue(Row,Col,aryPopupData[0][3],0);
	}
	/**
	 *	Form Event Start
	 */
/*
	function por_rhq_OnChange(){
		if(document.all.item("enablePorRhq").style.display == "inline" && !mCheckKey){
			document.form.loc_cd.value="";
		}
	}
*/	
	//By Hwang
	function por_rhq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if(beforetab == 1||beforetab == 2){
			  doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
	     }
	}
	
	function por_rhq_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
		}
	}
	
	function gntr_rmk_onchange(){
		if(sheetObjects[0].GetSelectRow()> 0){
        	if(document.form.gntr_rmk.value.length > 1000){
	    		ComShowCodeMessage("VSK01019", "[Remark(s)]");
	    		document.form.gntr_rmk.value="";  
	    		return false;
	    	}
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "t1sheet1_gntr_rmk",document.form.gntr_rmk.value);
		}
	}
	
	function fltg_rmk_onchange(){
		if(sheetObjects[1].GetSelectRow()> 0){
        	if(document.form.fltg_rmk.value.length > 1000){
	    		ComShowCodeMessage("VSK01019", "[Remark(s)]");
	    		document.form.fltg_rmk.value="";  
	    		return false;
	    	}
			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "t2sheet1_fltg_rmk",document.form.fltg_rmk.value);
		}
	}
	function loc_cd_onkeyup(){
		document.form.f_cmd.value=SEARCH06;
		if(document.form.loc_cd.value.length == 5){
			sheetObjects[4].DoSearch("VOP_VSK_0507GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") );
		} else if (document.form.loc_cd.value.length == 0) {
			por_rhq.SetSelectCode("%");
			document.form.por_rhq_diable.value="";
		} 
		mCheckKey=true;
	}
	function loc_cd_onblur(){
		mCheckKey=false;
	}
	function loc_cd_onkeypress(){
		ComKeyOnlyAlphabet('upper');
 		if(document.form.loc_cd.value.length == 5 && event.keyCode == 13){
 			setTimeout(function(){
 				doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
            },300);     
			
		}else if(document.form.loc_cd.value == "" && (beforetab == 1 || beforetab == 2) && event.keyCode == 13){
			setTimeout(function(){
				doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);	
			},300);
			
		}
	}
	function portCdInit(){
		document.form.f_cmd.value=SEARCH01;
		var arr=new Array("", "");
		document.form.comboCd.value="CD00593,CD02121";
		var sXml=sheetObjects[1].GetSearchData("VOP_VSK_VOSIGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(arr));
		var arrXml=sXml.split("|$$|");
		if(arrXml.length > 1){
			arrCombo=ComXml2ComboString(arrXml[0], "val", "name");
			sheetObjects[3].SetColProperty("t4sheet1_skd_dir_cd", {ComboText:"|"+arrCombo[0], ComboCode:"|"+arrCombo[1]} );
		}
	}
	/**
	 *	Form Event End
	 */
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
				case IBSEARCH:
					if(beforetab == 0 || beforetab == 3){
						if(loc_cd.value == ''){
							ComShowCodeMessage('COM12114','Port');
//							loc_cd.focus();
							return false;
						}	
						if(loc_cd.value.length < 5){
							ComShowCodeMessage('COM12174','Port', 5);
//							loc_cd.focus();
							return false;
						}
					}
					if(beforetab == 1 || beforetab == 2){
						if(por_rhq.id == ''){
							ComShowCodeMessage('COM12114','RHQ');
							ComAlertFocus(por_rhq, "");
							return false;
						}	
					}
				break;			
			}
		}
        return true;
    }
    
	function sheetSetBackColor(sheet, Row, Col, Col2){
		var startRow=sheet.SaveNameCol(Col);
		var endRow=sheet.SaveNameCol(Col2);
		
		var firstRow=sheet.SaveNameCol(prefix +"etd_tm_hrmnt")+1;
		var lastRow=sheet.LastCol();
		for(var cnt=firstRow; cnt < startRow; cnt++){
			sheet.SetCellBackColor(Row, cnt,"#ffffff");
		}
		for(var cnt=endRow+1; cnt <= lastRow; cnt++){
			sheet.SetCellBackColor(Row, cnt,"#ffffff");
		}
		
		var prefix="t4sheet1_";
		if(startRow <= endRow){
			for(var cnt=startRow; cnt <= endRow; cnt++){
				sheet.SetCellBackColor(Row, cnt,"#0080C0");
			}
		} else{
			for(var cnt=startRow; cnt <= sheet.LastCol(); cnt++){
				sheet.SetCellBackColor(Row, cnt,"#0080C0");
			}
			var newStart=parseInt(sheet.SaveNameCol(prefix + "etd_tm_hrmnt")) + 1;
			for(var cnt=newStart; cnt <= endRow; cnt++){
				sheet.SetCellBackColor(Row, cnt,"#0080C0");
			}
		}
		
	}
	
	function sheetSetForeColor(sheet, Row, Col, Col2){
		var startRow=sheet.SaveNameCol(Col);
		var endRow=sheet.SaveNameCol(Col2);
		sheet.SetCellFontColor(Row, startRow,"#FFFFFF");
		sheet.SetCellFontColor(Row, endRow,"#FFFFFF");
	}
	
	function sheetHeaderBackColor(sheet, Col, Col2, bgColor){
		var startCol=sheet.SaveNameCol(Col);
		var endCol=sheet.SaveNameCol(Col2);
		for(var cnt=startCol; cnt <= endCol; cnt++){
			sheet.SetCellBackColor(0, cnt,bgColor);
		}
	}
	
	function duplCheck(sheetObj,Row, Col, Value, chkCol){
		var dupRow=sheetObj.ColValueDup(chkCol, true);
		if(sheetObj.id == "t1sheet1"){
			if(dupRow != -1 && sheetObj.GetCellValue(dupRow, chkCol) != '') {
				ComShowCodeMessage('VSK50016'); 
				sheetObj.SetCellValue(Row, Col,"");
				return;
			}
		} else if(sheetObj.id == "t4sheet1"){
			if(dupRow != -1 && sheetObj.GetCellValue(dupRow, chkCol) != '') {
				ComShowCodeMessage('VSK50016');  
				var arrCheckCol=chkCol.split("|");
				for(var cnt=0; cnt < arrCheckCol.length; cnt++){
					sheetObj.SetCellValue(Row, arrCheckCol[cnt],"");
				}
				return;
			}
		}
	}
	
	function clearFormNData(){
		var formObject=document.form;
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		with(formObject){
			loc_cd.value="";
			formObject.por_rhq_text.value="%";
			por_rhq_diable.value="";
			upd_dt_view.value="";
			upd_id_view.value="";
			gntr_rmk.value="";
			fltg_rmk.value="";
		}
	}
	
	function removeSheet(){
		var formObject=document.form
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		with(formObject){
			upd_dt_view.value="";
			upd_id_view.value="";
			gntr_rmk.value="";
			fltg_rmk.value="";
		}
	}
	
	function moveFocus(nItem){
		switch(nItem){
			case 0:
//				document.form.loc_cd.focus();
				break;
			case 1:
				ComAlertFocus(por_rhq, "");
				//por_rhq.Code = "%";
				break;
			case 2:
				ComAlertFocus(por_rhq, "");
				//por_rhq.SetSelectCode("%");
				break;
			case 3:
//				document.form.loc_cd.focus();
				break;
		}
	}
	
	function yardCdCellComboInit(sheetObj, Row){
		with(sheetObj){
			var code=" |" + arrGCraneCombo[0];
			var val=" |" + arrGCraneCombo[1];
			for(var cnt=HeaderRows(); cnt <= RowCount(); cnt++){
				if(cnt != Row && GetRowStatus(cnt) == "R"){
					code=ComReplaceStr(code, "|" + GetCellValue(cnt, "t1sheet1_yd_cd"), "");
					//finding text
					var sText=sheetObj.GetComboInfo(cnt, "t1sheet1_yd_cd", "Text");
					var arrText=sText.split("|");
					var idx=sheetObj.GetComboInfo(cnt, "t1sheet1_yd_cd", "SelectedIndex");
					//deleting text
					val=ComReplaceStr(val, "|" + arrText[idx], "");
				}
			}
			CellComboItem(Row,"t1sheet1_yd_cd", {ComboText:val, ComboCode:code} );
		}
	}
	function changeSheet(){
		var statsCnt=0;
		var changeSheet="";
		for(var cnt=0; cnt < sheetObjects.length; cnt++){
			var changeSheetCnt = sheetObjects[cnt].RowCount("I") + sheetObjects[cnt].RowCount("U") + sheetObjects[cnt].RowCount("D");
			if(changeSheetCnt > 0){
				statsCnt += changeSheetCnt;
				changeSheet += changeSheet == "" ? marrTabTitle[cnt] : ", " + marrTabTitle[cnt];
			}
		}
		return statsCnt;
	}
    /**
	 * Pol Code<br>
	 * @param {arry} aryPopupData
	 */
    function setPolCd(aryPopupData){
		document.form.loc_cd.value=aryPopupData[0][2];
		loc_cd_onkeyup();
    }
