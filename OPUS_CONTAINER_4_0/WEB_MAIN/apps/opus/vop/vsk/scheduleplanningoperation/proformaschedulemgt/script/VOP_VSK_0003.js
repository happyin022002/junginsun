/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0003.js
*@FileTitle : P/F SKD Creation
*@author     : CLT 
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_VSK_0003 : business script for VOP_VSK_0003
     */
    function VOP_VSK_0003() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var portDataFlgs=new Array();		//Port in grid change status
    var ydCdsArr=new Array();
    //Handling M/Simulation and A/Simulation
    //var statusFlag = "";
    var submitFlg="N"; 
    //Check Vsl Cls duplicate call
    var vslClsCheck="N";
    var saveFlg = "N";
    var isACal = "N"; //A/Calculation 처리여부
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            if (!ComIsBtnEnable(srcName)) return;  
            switch(srcName) {
				case "btn_RowAdd":
					var rowIdx = getRowCount(sheetObject2)+ sheetObject2.HeaderRows();
					var rowIdx2=0;
					if(rowIdx == sheetObject2.HeaderRows()){
						
						if(ComIsNull(formObject.vsl_slan_cd.value)||ComIsNull(formObject.pf_svc_tp_cd.value)||ComIsNull(comboObjects[0].GetSelectText())){
							ComShowCodeMessage('VSK00027', "Lane Code, P/F SKD Type, Vessel Class");
							
							if(ComIsNull(formObject.vsl_slan_cd.value)){
							formObject.vsl_slan_cd.focus()
							}else if(ComIsNull(formObject.pf_svc_tp_cd.value)){
							formObject.pf_svc_tp_cd.focus()
							}else if(ComIsNull(comboObjects[0].GetSelectText())){
//							comboObjects[0].GetSelectText());
							}
							return;
						}
						
					if(sheetObject1.RowCount()== 0){
							rowIdx2=sheetObject1.DataInsert(-1);
						}
						rowIdx2=sheetObject2.DataInsert(-1);
						resetRowSeq(sheetObject2);
						//var rowIdx2 = sheetObject2.RowCount + sheetObject2.HeaderRows - 1;
						//sheetObject2.CellValue(rowIdx2,"sheet2_row_seq") = sheetObject2.RowCount;
						sheetObject2.SetCellValue(rowIdx2,sheetObject2.id+"_etb_dy_no",0);
						sheetObject2.SetCellValue(rowIdx2,sheetObject2.id+"_etb_dy_cd","MON");
						sheetObject2.SetCellValue(rowIdx2,sheetObject2.id+"_etb_tm_hrmnt","00:00");
						sheetObject2.SetCellEditable(rowIdx2, "sheet2_etb_dy_no",0);
						sheetObject2.SetCellEditable(rowIdx2, "sheet2_etd_dy_no",0);
						sheetObject2.SetCellEditable(rowIdx2, "sheet2_etd_dy_cd",0);
						sheetObject2.SetCellEditable(rowIdx2, "sheet2_etd_tm_hrmnt",0);
						sheetObject2.SelectCell(rowIdx2, sheetObject2.id+"_port_cd", true);
						//if(sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_ibflag") == "I"){
						if(sheetObject2.GetRowStatus(rowIdx2) == "I"){
							sheetObject2.SetCellEditable(rowIdx2, "sheet2_tztm_hrs",0);
							sheetObject2.SetCellEditable(rowIdx2, "sheet2_sea_buf_spd",0);
							sheetObject2.SetCellEditable(rowIdx2, "sheet2_tml_prod_qty",0);
							sheetObject2.SetCellEditable(rowIdx2, "sheet2_crn_knt",0);
						}
					}else{
						if(sheetObject1.RowCount()== 0){
							sheetObject1.DataInsert(-1);
						}
						sheetObject2.DataInsert(-1);
						resetRowSeq(sheetObject2);
						var lastRow=searchLastRow(sheetObject2);
						sheetObject2.SetCellValue(lastRow-1,"sheet2_skd_dir_cd",sheetObject2.GetCellValue(lastRow-2,"sheet2_skd_dir_cd"));
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etb_dy_no",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etb_dy_cd",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etb_tm_hrmnt",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etd_dy_no",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etd_dy_cd",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etd_tm_hrmnt",0);
						sheetObject2.SelectCell(lastRow-1, sheetObject2.id+"_port_cd", true);
						//if(sheetObject2.CellValue(lastRow-1,sheetObject2.id+"_ibflag") == "I"){
						if(sheetObject2.GetRowStatus(lastRow-1) == "I"){
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_tztm_hrs",0);
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_sea_buf_spd",0);
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_tml_prod_qty",0);
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_crn_knt",0);
						}
						setlastLowViewUndo(sheetObject2,lastRow-1);
						setlastLowView(sheetObject2,lastRow);
						
						
					}
					
					break;
				case "btn_RowInsert":
					var rowIdx=sheetObject2.GetSelectRow()+ sheetObject2.HeaderRows()- 1;
					if(rowIdx){
						if(rowIdx > sheetObject2.HeaderRows()){
							var selRow = sheetObject2.DataInsert();
							sheetObject2.SetCellEditable(selRow, "sheet2_etb_dy_no",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_etb_dy_cd",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_etb_tm_hrmnt",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_etd_dy_no",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_etd_dy_cd",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_etd_tm_hrmnt",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_tztm_hrs",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_sea_buf_spd",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_tml_prod_qty",0);
							sheetObject2.SetCellEditable(selRow, "sheet2_crn_knt",0);
							resetRowSeq(sheetObject2);
							sheetObject2.SetCellValue(selRow,"sheet2_skd_dir_cd",sheetObject2.GetCellValue(selRow-1,"sheet2_skd_dir_cd"));
							sheetObject2.SelectCell(rowIdx-1, sheetObject2.id+"_port_cd", true);
							var lastRow=searchLastRow(sheetObject2);
							setlastLowViewUndo(sheetObject2,lastRow-1);
							setlastLowView(sheetObject2,lastRow);
						}
					}
					break;
				case "btn_RowDelete":
					var prefix="sheet2_";
					var dataRows=sheetObject2.HeaderRows();
					var lastRows=sheetObject2.LastRow();
					var	checkFlag=true;
					for (var i=dataRows; i<=lastRows; i++){
						if(sheetObject2.GetCellValue(i, prefix+"Sel")== 1){
							checkFlag=false;
							break;
						}
					}
					if (checkFlag){return;}
					var rowIdx=sheetObject2.GetSelectRow()+ sheetObject2.HeaderRows()- 1;
					if(rowIdx){
						if(rowIdx > sheetObject2.HeaderRows()){
							ComShowCodeMessage('VSK00005');
							if(ComIsNull(formObject.vsl_slan_cd.value)){
								ComShowCodeMessage('VSK00027', "Lane Code");
								formObject.vsl_slan_cd.focus()
								return;
							}
							if(ComIsNull(formObject.pf_svc_tp_cd.value)){
								ComShowCodeMessage('VSK00027', "P/F SKD Type");
								formObject.pf_svc_tp_cd.focus()
								return;
							}
							if(ComIsNull(comboObjects[0].GetSelectText())){
								ComShowCodeMessage('VSK00027', "1st Vessel Class");
								//comboObjects[0].focus();
								return;
							}
//							if(ComIsNull(formObject.n1st_vsl_clss_knt.value)){
//								ComShowCodeMessage('VSK00027', "1st Vessel Count");
//								formObject.n1st_vsl_clss_knt.focus();
//								return;
//							}
							var result=ComRowHideDelete(sheetObject2,"sheet2_Sel");
							if(result  > 0){
								doActionIBSheet(sheetObject1,formObject,REMOVE02);
							}
						}
					}
					break
				case "btn_DownExcel":					
					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{					
						sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2),Merge:1,TreeLevel:false,SheetDesign:1 });						
					}
					break;	
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_New":
					clearAllData(sheetObject1,sheetObject2,formObject,true);
					break;
				case "btn_Save":
					/*
					 * 20150108 DONGSOO
					 * saveFlg가 'Y'일 경우 M/Calculation을 체크 후에 저장 처리한다. 
					 * 필수 체크된 대상만 처리하면 저장처리되면서 DATA가 틀어지는 문제 발생됨
					 */
					if (!$("#btn_MSimulation").prop("disabled")) {
						saveFlg = "Y";
						doActionIBSheet(sheetObject2,formObject,COMMAND01);
					} else {
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
					}
					break;
				case "btn_MSimulation":
					doActionIBSheet(sheetObject2,formObject,COMMAND01);
					break;
				case "btn_ASimulation":
					doActionIBSheet(sheetObject2,formObject,COMMAND02);
					break;
				case "btns_search":
					openLandCdHelp(sheetObject2);
					break;	
				case "btns_search02":
					openPfLandTypeCdHelp(sheetObject2);
					break;	
				case "btns_search03":
					openPfSkdHistoryHelp(sheetObject2);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject1,formObject,REMOVE);
					break;	
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('VSK00011');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /** 
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */ 
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++]=combo_obj;  
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */                    
    function loadPage() {
    	var formObject=document.form;
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet();
    	for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
    	doActionIBCombo(sheetObjects[0],formObject,IBSEARCH,comboObjects[0],SEARCH01);
    	initControl();
    	if(sheetObjects[0].RowCount()== 0){
    		sheetObjects[0].DataInsert(-1);
    	}
    	clearDescData(sheetObjects[0],sheetObjects[1],formObject);
    	
    	document.form.vsl_slan_cd.focus();
    }
/**
 * setting combo initial values and header
 * param : comboObj, comboNo
 * adding case as numbers of counting combos 
 */ 
function initCombo(comboObj, comboNo) {
    var formObject=document.form
    switch(comboNo) {
          case 1: 
           with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "50");
				SetBackColor("#D4F6FF");
				SetFontColor("#000000");
				SetColBackColor(0,"#D4F6FF");
				SetColFontColor(0,"#000000");
 				SetDropHeight(160);
 		    	}
 			break;
          case 2: 
              with (comboObj) { 
   				SetMultiSelect(0);
   				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "50");
   				SetBackColor("#FFFFFF");
   				SetFontColor("#000000");
   				SetColBackColor(0,"#FFFFFF");
   				SetColFontColor(0,"#000000");
				SetDropHeight(160);
		    	}
    		break;
          case 3: 
              with (comboObj) { 
   				SetMultiSelect(0);
   				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "50");
   				SetBackColor("#FFFFFF");
   				SetFontColor("#000000");
   				SetColBackColor(0,"#FFFFFF");
   				SetColFontColor(0,"#000000");
				SetDropHeight(160);
		    	}
    		break;
 	     }
 	}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
    switch(sheetID) {
    	case "sheet1":      //sheet1 init
    	  with(sheetObj){ 
        
          var HeadTitle="STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK|CRE_DT|UPD_DT";
          var headCount=ComCountHeadTitle(HeadTitle);
          var prefix="sheet1_";

          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_stnd_flg",     KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"svc_dur_dys",       KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"stnd_svc_spd",      KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"brth_itval_dys",    KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mml_usd_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_no",            KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_knt",          KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dist",          KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"max_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"avg_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_skd_rmk",        KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
                 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"" } ];
           
          InitColumns(cols);
          SetVisible(0);
          SetEditable(0);
          SetWaitImageVisible(0);
        }

        break;
        case "sheet2":      //sheet1 init
            with(sheetObj) {          
	            var HeadTitle1="|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|Manv.|Manv.|Port\nTime|Port\nBUF|Cargo Volume|Cargo Volume|Cargo Volume|Cargo Volume|TMNL PRD|TMNL PRD|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|CheckWkTm|CraneWkTm";
	            var HeadTitle2="|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|IPC|IPC|Ocean|Ocean|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|CheckWkTm|CraneWkTm";
	            var HeadTitle3="||No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|CheckWkTm|CraneWkTm";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            var prefix="sheet2_";

	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	            var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},
	                    { Text:HeadTitle2, Align:"Center"},
	                    { Text:HeadTitle3, Align:"Center"} ];
	            InitHeaders(headers, info);

	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel" },
	             {Type:"Int"     ,  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"row_seq",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	             {Type:"Combo"   ,  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text"    ,  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
	             {Type:"Combo"   ,  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Int"     ,  Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"zd",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int"     ,  Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etb_dy_no",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Combo"   ,  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text"    ,  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
	             {Type:"Text"    ,  Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etd_dy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Combo"   ,  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text"    ,  Hidden:0, Width:60,   Align:"Center",   ColMerge:1,   SaveName:prefix+"etd_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
	             {Type:"Int"     ,  Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float"   ,  Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_spd",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Float"   ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float"   ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float"   ,  Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_spd",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Float"   ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Float"   ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Float"   ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wrk_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Float"   ,  Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"port_buf_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int"     ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int"     ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int"     ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int"     ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int"     ,  Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_knt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1 },
	             {Type:"Float"   ,  Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_prod_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1 },
	             {Type:"Combo"   ,  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text"    ,  Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text"    ,  Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text"    ,  Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text"    ,  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"check_wk_tm" },
	             {Type:"Text"    ,  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"crane_wk_tm" } ];
	             
	            InitColumns(cols);
	            SetEditable(1);
	            SetCountPosition(0);
	            SetWaitImageVisible(0);
	           
	            SetRowHeight(0,10);
	            SetRowHeight(1,10);
	            SetRowHeight(2,10);
	            SetColProperty(prefix+"port_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            SetColProperty(prefix+"skd_dir_cd", {ComboText:"W|E|N|S", ComboCode:"W|E|N|S"} );
	        	SetColProperty(prefix+"yd_cd", {ComboText:"", ComboCode:""} );
	        	SetColProperty(prefix+"etb_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
	        	SetColProperty(prefix+"etd_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
	        	SetColProperty(prefix+"turn_port_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
	        	
	        	SetColProperty(prefix+"port_buf_hrs" ,{ExceptKeys:"-"});
	        	
	        }
            break;
        }
    }
//handling combo process
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      // Retrieve
			if (sheetObj.id == "sheet1") {
				//Initializing combo
				sComboObj.RemoveAll();
				formObj.f_cmd.value=SEARCH01;
				//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", FormQueryString(formObj));
				var param="f_cmd=" + SEARCH01;
				var sXml=sheetObj.GetSearchData("VSK_COMGS.do", param);
				//var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
				var comboItems=ComGetEtcData(sXml, "vslCls").split("|");
				addComboItem(comboObjects[0],comboItems);
				addComboItem(comboObjects[1],comboItems);	
				addComboItem(comboObjects[2],comboItems);	
				comboObjects[1].InsertItem(0, '', '');
				comboObjects[2].InsertItem(0, '', ''); 
			};
            break;
    }
}
/**
 * Adding data to ComboAdding data to Combo
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(",");
		//comboObj.InsertItem(i, comboItem,comboItem);
		if (comboItem.length == 1) {
			comboObj.InsertItem(i, comboItem[0],comboItem[0]);
		} else if (comboItem.length == 2) {
			comboObj.InsertItem(i, comboItem[0],comboItem[1]);
		}
	}   		
}
function combo2_OnChange(comboObj, comboText, comboValue){
	var formObject=document.form
	if(comboValue == ""){
		formObject.n2nd_vsl_clss_knt.value="";
	} else{
		formObject.n2nd_vsl_clss_knt.value="0";
	}
}
function combo3_OnChange(comboObj, comboText, comboValue){
	var formObject=document.form
	if(comboValue == ""){
		formObject.n3rd_vsl_clss_knt.value="";
	} else {
		formObject.n3rd_vsl_clss_knt.value="0";	
	} 
}
function combo1_OnBlur(comboObj){
	var val=comboObjects[0].GetSelectText();
	var cnt=comboObjects[0].GetItemCount();
	var chkCnt=0;
	for(var i=0; i<cnt; i++){
		if(comboObjects[0].GetText(i,0) == val){
			chkCnt++;
		}
	}
	if(chkCnt == 0){
		comboObjects[0].SetSelectText("");
	}
}
function combo2_OnBlur(comboObj){
	var val=comboObjects[1].GetSelectText();
	var cnt=comboObjects[1].GetItemCount();
	var chkCnt=0;
	for(var i=0; i<cnt; i++){
		if(comboObjects[1].GetText(i,0) == val){
			chkCnt++;
		}
	}
	if(chkCnt == 0){
		comboObjects[1].SetSelectText("");
	}
}
function combo3_OnBlur(comboObj){
	var val=comboObjects[2].GetSelectText();
	var cnt=comboObjects[2].GetItemCount();
	var chkCnt=0;
	for(var i=0; i<cnt; i++){
		if(comboObjects[2].GetText(i,0) == val){
			chkCnt++;
		}
	}
	if(chkCnt == 0){
		comboObjects[2].SetSelectText("");
	}
}
/**
 * registering initial event
 */
function initControl() {
	var formObj=document.form;
//	axon_event.addListenerForm	('focus', 		'obj_focus', 	formObj);
//	axon_event.addListenerFormat('keypress', 	'obj_keypress', form);
//	axon_event.addListenerForm	('keyup', 		'obj_keyup' , 	form);
	axon_event.addListenerForm	('change', 		'obj_change' , 	form);	
}
function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
/**
 * Handling key press event
 */
/**
 * Handling key up event
 */
function obj_change(){
	var formObject=document.form;
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    var sheetObject1=sheetObjects[0];
    var prefix1="sheet1_";
    /*******************************************************/
    if(sheetObjects[0].RowCount()== 0){
		sheetObjects[0].DataInsert(-1);
	}
	try {
		var eleObj=ComGetEvent();
		var srcName=eleObj.getAttribute("name");
		switch(srcName) {
        	case "vsl_slan_cd":
        		clearDescData(sheetObjects[0],sheetObjects[1],formObject);
				if(eleObj.value.length == 3){
					var sXml=doActionIBSheet(sheetObjects[0], formObject, SEARCH06);
					var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
		  		  	var dirCds=ComGetEtcData(sXml, "checkDirCd");
		  		  	sheetObjects[1].SetColProperty("sheet2_skd_dir_cd", {ComboText:dirCds, ComboCode:dirCds} );
					if(vslSlanNm == ""){
						ComShowCodeMessage('VSK00021', formObject.vsl_slan_cd.value);
						formObject.vsl_slan_cd.focus();
						formObject.vsl_slan_cd.value="";
						formObject.pf_svc_tp_cd.value="";
					}else{
						formObject.pf_svc_tp_cd.focus();
						formObject.pf_svc_tp_cd.value="";
					}
					sheetObjects[0].SetCellValue(1,prefix1+"vsl_slan_cd",formObject.vsl_slan_cd.value,0);
				}
				break;
//        	case "pf_svc_tp_cd":
        		//clearDescData(sheetObjects[0],sheetObjects[1],formObject);
//        		break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}



  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        ////alert(sAction);
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					clearAllData(sheetObjects[0],sheetObjects[1],formObj,false)
					ComOpenWait(true);
					formObj.check_vsl_skd.value="N" ;	// Initializing P/F SKD Use in VESSEL SKD Status to "N"
					formObj.f_cmd.value=SEARCH;
					var	parm="f_cmd=" +formObj.f_cmd.value+
							"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
							"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value;
			        var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix string array
			        //var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			        var sXml=sheetObj.GetSearchData("VOP_VSK_0003GS.do", parm + "&" + ComGetPrefixParam(aryPrefix));
			        
			        ComOpenWait(false);
			        var arrXml=sXml.split("|$$|");
			    	submitFlg = "Y";
			    	saveFlg   = "N";
			    	if (arrXml.length > 1) {
				    	for(var inx=0; inx<arrXml.length; inx++){
				    		showSheetData(sheetObjects[inx],formObj,arrXml[inx], "N");
				    	}			    		
			    	}else{
			    		var tmpXml="<SHEET><DATA  TOTAL='0'></DATA></SHEET>";
			    		showSheetData(sheetObjects[1],formObj,tmpXml, "N");
			    	}
			    	
//			    	var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows();
//			    	setlastLowView(sheetObjects[1],lastPos);
//			    	// in case Proforma Schedule is using in Trunk Vessel Schedule, showing message
//			    	if((formObj.vsl_svc_tp_cd.value != "O") && (formObj.check_vsl_skd.value == "Y")) {
//			    		ComBtnDisable("btn_RowAdd");
//			    		ComBtnDisable("btn_RowInsert");
//			    		ComBtnDisable("btn_RowDelete");
//			    		ComBtnDisable("btn_Delete");
//			    		ComBtnDisable("btn_MSimulation");
//			    		ComBtnDisable("btn_ASimulation");
//			    		ComShowCodeMessage("VSK00083");
//			    	}else{
//			    		ComBtnEnable("btn_RowAdd");
//			    		ComBtnEnable("btn_RowInsert");
//			    		ComBtnEnable("btn_RowDelete");
//			    		ComBtnEnable("btn_Delete");
//			    		ComBtnEnable("btn_MSimulation");
//			    		ComBtnEnable("btn_ASimulation");
//			    	}

				}
			break;
			case SEARCH02: //Port Code change
				var prefix="sheet2_";
				var headCnt=sheetObj.HeaderRows();
				var rowCnt=sheetObj.RowCount();
				var totalCnt=headCnt+rowCnt;
				var currRow=sheetObj.GetSelectRow();
				var idx=0;
				//row of changed port
				var currPos=(sheetObj.GetSelectRow()- headCnt)+1;
				//pre port not exist : 1
				//pre port exist   : 1
				//post port exist : 2
				var portInfoCnt="";
				var data_pos="";
				//current port is first and count of all port is 1
				if(currPos == 1 && currPos == rowCnt){
					portInfoCnt=1;
					formObj.first_port_cd.value="";
					formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
					formObj.third_port_cd.value="";
					formObj.port_info_cnt.value=portInfoCnt;
					formObj.curr_pos.value=currRow;
					formObj.data_pos.value="S";
				}else if(currPos > 1 && currPos <= rowCnt-1){
					portInfoCnt=2;
					formObj.first_port_cd.value=sheetObj.GetCellValue(currRow-1,prefix+"port_cd");
					formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
					formObj.third_port_cd.value=sheetObj.GetCellValue(currRow+1,prefix+"port_cd");
					formObj.port_info_cnt.value=portInfoCnt;
					formObj.curr_pos.value=sheetObj.GetSelectRow();
					formObj.data_pos.value="A";
				}else if(currPos == 1 && currPos <= rowCnt-1){
					portInfoCnt=1;
					formObj.first_port_cd.value="";
					formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
					formObj.third_port_cd.value=sheetObj.GetCellValue(currRow+1,prefix+"port_cd");
					formObj.port_info_cnt.value=portInfoCnt;
					formObj.curr_pos.value=sheetObj.GetSelectRow();
					formObj.data_pos.value="T";
				}else if(currPos == 2){
					portInfoCnt=1;
					formObj.first_port_cd.value=sheetObj.GetCellValue(currRow-1,prefix+"port_cd");
					formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
					formObj.third_port_cd.value="";
					formObj.port_info_cnt.value=portInfoCnt;
					formObj.curr_pos.value=sheetObj.GetSelectRow();
					formObj.data_pos.value="F";
				}else if(currPos == rowCnt){
					portInfoCnt=1;
					formObj.first_port_cd.value=sheetObj.GetCellValue(currRow-1,prefix+"port_cd");
					formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
					formObj.third_port_cd.value="";
					formObj.port_info_cnt.value=portInfoCnt;
					formObj.curr_pos.value=sheetObj.GetSelectRow();
					formObj.data_pos.value="E";
				}
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH02;
				var loc_cd=formObj.port_cd.value;
				var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
				var sXml=sheetObj.GetSearchData("VOP_VSK_0003GS.do?loc_cd="+loc_cd, sParam);
				ComOpenWait(false);
				return sXml;
			break;
			case SEARCH04: //Yard Code change
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH03;
				var sParam="f_cmd=" + formObj.f_cmd.value + 
							"&yd_cd=" + formObj.yd_cd.value;
				var sXml=sheetObj.GetSearchData("VOP_VSK_0003GS.do", sParam);
				//var sParam = FormQueryString(formObj);	            
				//var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do", sParam);
				ComOpenWait(false);
				return sXml;
			break;
			case SEARCH05:	// Yard List Retrieve by Location.
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH04;
				var sParam="f_cmd=" + formObj.f_cmd.value + 
							"&loc_cd=" + formObj.port_cd.value;
				var sXml=sheetObj.GetSearchData("VOP_VSK_0003GS.do", sParam);
				//var loc_cd = formObj.port_cd.value				
				//formObj.f_cmd.value = SEARCH04;
				//var sParam = FormQueryString(formObj);
				//var sXml = sheetObj.GetSearchXml("VOP_VSK_0003GS.do?loc_cd="+loc_cd, sParam);
				ComOpenWait(false);
				return sXml;
			break;
			case SEARCH06:	// Lane Code Check
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH03;
				var sParam="f_cmd=" + formObj.f_cmd.value + 
							"&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				var sXml=sheetObj.GetSearchData("VOP_VSK_0053GS.do", sParam);
				//var vslSlanCd  = formObj.vsl_slan_cd.value;
				//var sParam = FormQueryString(formObj); 
				//var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?vslSlanCd="+vslSlanCd, sParam);
				ComOpenWait(false);
				return sXml;
			break;
			case IBSAVE:        //Save
				var prefix=sheetObj.id + "_";
				var headCnt=sheetObj.HeaderRows();
				var totCnt=sheetObj.LastRow();
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					
					var prefix="sheet1_";
					
					sheetObjects[0].SetCellValue(1,prefix+"vsl_slan_cd",formObj.vsl_slan_cd.value);
					sheetObjects[0].SetCellValue(1,prefix+"pf_svc_tp_cd",formObj.pf_svc_tp_cd.value);
					sheetObjects[0].SetCellValue(1,prefix+"brth_itval_dys",formObj.brth_itval_dys.value);
					sheetObjects[0].SetCellValue(1,prefix+"mml_usd_flg",formObj.mml_usd_flg.value);
					sheetObjects[0].SetCellValue(1,prefix+"n1st_vsl_clss_cd",comboObjects[0].GetSelectCode());
					sheetObjects[0].SetCellValue(1,prefix+"n1st_vsl_clss_knt",formObj.n1st_vsl_clss_knt.value);
					sheetObjects[0].SetCellValue(1,prefix+"n2nd_vsl_clss_cd",comboObjects[1].GetSelectCode());
					sheetObjects[0].SetCellValue(1,prefix+"n2nd_vsl_clss_knt",formObj.n2nd_vsl_clss_knt.value);
					sheetObjects[0].SetCellValue(1,prefix+"n3rd_vsl_clss_cd",comboObjects[2].GetSelectCode());
					sheetObjects[0].SetCellValue(1,prefix+"n3rd_vsl_clss_knt",formObj.n3rd_vsl_clss_knt.value);
					sheetObjects[0].SetCellValue(1,prefix+"svc_dur_dys",formObj.svc_dur_dys.value);
					sheetObjects[0].SetCellValue(1,prefix+"slan_stnd_flg",formObj.slan_stnd_flg.value);
					sheetObjects[0].SetCellValue(1,prefix+"upd_dt",formObj.upd_dt.value);
					sheetObjects[0].SetCellValue(1,prefix+"pf_skd_rmk",formObj.pf_skd_rmk.value);
					
					formObj.f_cmd.value=MULTI;
		     	   	var SaveStr=ComGetSaveString(sheetObjects);
		     	   	var aryPrefix=new Array("sheet1_", "sheet2_");
		     	   	var sXml=sheetObj.GetSaveData("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   	ComOpenWait(false);
		     	   	
		     	   	sheetObjects[0].LoadSearchData(sXml,{Sync:1});
		     	   	if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
		     	   		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		     	   	} else {
			     	   	if(sheetObjects[0].RowCount()== 0){
			        		sheetObjects[0].DataInsert(-1);
			        	}
		     	   	}
				}
			break;
			case COMMAND01:	// Manual Simulation
				if(validateForm(sheetObj,formObj,"Msimul")){
						sheetObjects[0].SetRowStatus(1,"U");
					   var currPos=0;
					   for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
						   if(sheetObjects[1].GetRowStatus(i) == "I" || sheetObjects[1].GetRowStatus(i) == "U"){
							   currPos=i;
						   }
					   }
					   for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
						   if(sheetObjects[1].GetRowStatus(i) == "R"){
							   sheetObjects[1].SetRowStatus(i,"U");
						   }
					   }
				   var prefix="sheet1_"
				   sheetObjects[0].SetCellValue(1,prefix+"n1st_vsl_clss_cd" , comboObjects[0].GetSelectCode());
				   sheetObjects[0].SetCellValue(1,prefix+"n2nd_vsl_clss_cd" , comboObjects[1].GetSelectCode());
				   sheetObjects[0].SetCellValue(1,prefix+"n3rd_vsl_clss_cd" , comboObjects[2].GetSelectCode());
				   sheetObjects[0].SetCellValue(1,prefix+"n1st_vsl_clss_knt", formObj.n1st_vsl_clss_knt.value);
				   sheetObjects[0].SetCellValue(1,prefix+"n2nd_vsl_clss_knt", formObj.n2nd_vsl_clss_knt.value);
				   sheetObjects[0].SetCellValue(1,prefix+"n3rd_vsl_clss_knt", formObj.n3rd_vsl_clss_knt.value);
				   sheetObjects[0].SetCellValue(1,prefix+"pf_skd_rmk"       , formObj.pf_skd_rmk.value);
				   sheetObjects[0].SetCellValue(1,prefix+"slan_stnd_flg"    , formObj.slan_stnd_flg.value);
				   formObj.currPos.value=currPos-1;
				   
				   ComOpenWait(true);
				   formObj.f_cmd.value=COMMAND01;
		     	   var SaveStr=ComGetSaveString(sheetObjects);
		     	   
		     	   var aryPrefix=new Array("sheet1_", "sheet2_");
		     	   var sXml=sheetObj.GetSaveData("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   var checkArrXml=sXml.split("|$$|");		     	   
				   var totValue =  ComGetSelectSingleNode(checkArrXml[0], "TOTAL")
				   if(totValue){
						if(totValue > 0){
							var arrXml=sXml.split("|$$|");
					     	submitFlg="Y";
					     	for(var inx=0; inx<arrXml.length; inx++){
					     		showSheetData(sheetObjects[inx],formObj,arrXml[inx],"Y");
							}
					     	gridEndJob(sheetObjects[1],formObj);
					     	var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows();
					     	setlastLowView(sheetObjects[1],lastPos);
						}
				   }else{
					   sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
					   if (sheetObjects[0].RowCount()== 0) {
						   sheetObjects[0].DataInsert(-1);
				       }
			     	   
					}
				   ComOpenWait(false);
				}
			break;
			case COMMAND02: // Auto Simulation
				var prefix1="sheet1_";
				var prefix2="sheet2_";
				var headCnt=sheetObjects[1].HeaderRows();
				var cnt=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows()-1;
				if(validateForm(sheetObj,formObj,"Asimul")){
					sheetObjects[0].SetRowStatus(1,"I");
				   sheetObjects[0].SetCellValue(1,prefix1+"vsl_slan_cd",formObj.vsl_slan_cd.value);
				   sheetObjects[0].SetCellValue(1,prefix1+"pf_svc_tp_cd",formObj.pf_svc_tp_cd.value);
				   sheetObjects[0].SetCellValue(1,prefix1+"n1st_vsl_clss_cd",comboObjects[0].GetSelectCode());
				   sheetObjects[0].SetCellValue(1,prefix1+"n1st_vsl_clss_knt",formObj.n1st_vsl_clss_knt.value);
				   for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows()-1; i++){
					   //in case data does not inputed after Add Row, setting ibflag = R
					   if(sheetObjects[1].GetCellValue(i,prefix2+"port_cd") == "" && sheetObjects[1].GetCellValue(i,prefix2+"yd_cd") == ""){						  
						   sheetObjects[1].SetRowStatus(i,"R");
					   }else{
						   sheetObjects[1].SetRowStatus(i,"I");
					   }
				   }
				   ComOpenWait(true);
				   formObj.f_cmd.value=COMMAND02;
		     	   var SaveStr=ComGetSaveString(sheetObjects);
		     	   //alert(SaveStr);

		     	   var aryPrefix=new Array("sheet1_", "sheet2_");
		     	   var sXml=sheetObj.GetSaveData("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   var arrXml=sXml.split("|$$|");
		     	   isACal="Y";
		     	   submitFlg="Y";
		     	   for(var inx=0; inx<arrXml.length; inx++){
						showSheetData(sheetObjects[inx],formObj,arrXml[inx],"N");
					}
					gridEndJob(sheetObjects[1],formObj);
					var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows();
					setlastLowView(sheetObjects[1],lastPos);
					sheetObjects[1].CheckAll("sheet2_Sel",0);
					ComOpenWait(false);
				}
			break;
			
			case COMMAND23:        	// PORT TIME CHECK
				formObj.f_cmd.value = COMMAND23;				
				var sParam = FormQueryString(formObj);
				var sXml   = sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
				
				return sXml;
				
			case REMOVE:
				if(validateForm(sheetObj,formObj,"Remove")){
					sheetObjects[0].SetRowStatus(1,"D");
				   ComOpenWait(true);
				   formObj.f_cmd.value=REMOVE;
		     	   var SaveStr=ComGetSaveString(sheetObjects);
		     	   var aryPrefix=new Array("sheet1_");
		     	   var sXml=sheetObj.GetSaveData("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   if(sXml.length>0) {
		     		   sheetObj.LoadSearchData(sXml,{Sync:0} );
		     		   doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		     	   }
		     	   sheetObjects[1].CheckAll("sheet2_Sel",0);
		     	   ComOpenWait(false);
				}
				break;
			case REMOVE02:
				if(validateForm(sheetObj,formObj,"Remove02")){
					sheetObjects[0].SetRowStatus(1,"U");
				   for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
					   if(sheetObjects[1].GetRowStatus(i) == "R"){
						   sheetObjects[1].SetRowStatus(i,"U");
					   }
				   } 
				   ComOpenWait(true);
				   formObj.f_cmd.value=REMOVE02;
		     	   var SaveStr=ComGetSaveString(sheetObjects);

		     	   var aryPrefix=new Array("sheet1_", "sheet2_");
		     	   var sXml=sheetObj.GetSaveData("VOP_VSK_0003GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   var arrXml=sXml.split("|$$|");
		     	   if(arrXml.length > 1){
			     	   for(var inx=0; inx<arrXml.length; inx++){
							rowDelshowSheetData(sheetObjects[inx],formObj,arrXml[inx]);
					   }
			     	   var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows();
					   setlastLowView(sheetObjects[1],lastPos);
		     	   }
		     	   sheetObjects[1].CheckAll("sheet2_Sel",0);
		     	   ComOpenWait(false);
				}
				break;	
        }
    }
/**
 * process after retrieve.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml,Pos){

	var prefix=sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":			
//			//alert('showSheetData_sheet1-start');

			var xmlDoc = ComGetXmlDoc(sXml);
			if (xmlDoc == null) return;		
			//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
			var totValue =  ComGetSelectSingleNode(sXml, "TOTAL")
			if(totValue){
				//var totValue=dataNode.value;
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(totValue > 0){
					if(Pos != "Y"){
						formObj.vsl_slan_cd.value=sheetObj.GetCellValue(1,prefix+"vsl_slan_cd");
						formObj.pf_svc_tp_cd.value=sheetObj.GetCellValue(1,prefix+"pf_svc_tp_cd");
					}
					
					if (sheetObj.GetCellValue(1,prefix+"slan_stnd_flg") == "") {
						formObj.slan_stnd_flg.value = "N";
					} else {
						formObj.slan_stnd_flg.value = sheetObj.GetCellValue(1,prefix+"slan_stnd_flg");
					}
					//formObj.n1st_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
					setValCls(comboObjects[0],sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_cd"));
					formObj.n1st_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_knt");
					//formObj.n2nd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
					setValCls(comboObjects[1],sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_cd"));
					formObj.n2nd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_knt");
					//formObj.n3rd_vsl_clss_cd.value = sheetObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
					setValCls(comboObjects[2],sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_cd"));
					formObj.n3rd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_knt");
					formObj.svc_dur_dys.value=sheetObj.GetCellValue(1,prefix+"svc_dur_dys");
					formObj.brth_itval_dys.value=sheetObj.GetCellValue(1,prefix+"brth_itval_dys");
					formObj.mml_usd_flg.value=sheetObj.GetCellValue(1,prefix+"mml_usd_flg");
					var tempUpdDt=sheetObj.GetCellValue(1,prefix+"upd_dt");
					formObj.upd_dt.value=tempUpdDt;
					
					formObj.pf_skd_rmk.value=sheetObj.GetCellValue(1,prefix+"pf_skd_rmk");
					var ydCds=ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
//							//alert(ydCds[i]);
							ydCdsArr[i]=ydCds[i];
							sheetObjects[1].CellComboItem(i+sheetObjects[1].HeaderRows(),"sheet2_yd_cd",{ComboCode:ydCds[i], ComboText:""});
						}
					}
					if (formObj.n2nd_vsl_clss_knt.value == "0"){formObj.n2nd_vsl_clss_knt.value=""};
					if (formObj.n3rd_vsl_clss_knt.value == "0"){formObj.n3rd_vsl_clss_knt.value=""};
					//![CDATA[23.4|22.7|17.7|2.9|3.6|0|2266.4|1946.5|1]]
					var etcdts=ComGetEtcData(sXml, "etcdt").split("|");
					formObj.max_spd.value=etcdts[0]+" Kts";
					//formObj.avg_spd.value = etcdts[1]+" Kts";
					//formObj.buf_spd.value = etcdts[2]+" Kts";
					formObj.tot_buf_rat.value=etcdts[3]+" %";
					formObj.sea_buf_rat.value=etcdts[4]+" %";
					formObj.port_buf_rat.value=etcdts[5]+" %";
					formObj.pf_spd_rat.value=etcdts[6]+" %";
					formObj.buf_spd_rat.value=etcdts[7]+" %";
					formObj.min_max_spd.value=etcdts[8];
					//Retrieved Lane Cd and P/F TYPE CD - Feeder or Trunker
					formObj.vsl_svc_tp_cd.value=etcdts[9];
					//Retrieved Lane Cd and P/F TYPE CD - exist in VSL SKD 
					//formObj.check_vsl_skd.value=etcdts[10];
				
					var chkVslSkd = ComGetEtcData(sXml, "chkVslSkd");
					formObj.check_vsl_skd.value=chkVslSkd;
				
					
					if(Pos == "Y"){
						formObj.currPos.value=ComGetEtcData(sXml, "currPos");
					}				   	
				}else{
					clearAllData(sheetObjects[0],sheetObjects[1],formObj,true)
				}
				
			}
//			//alert('showSheetData_sheet1-end');

		break;
		case "sheet2":
//			//alert('showSheetData_sheet2-start');

			//sheetObj.RenderSheet(0);
			sheetObj.SetEditable(1);
			sheetObj.LoadSearchData(sXml,{Sync:0} );
			//sheetObj.RenderSheet(1);
			if(sheetObj.RowCount()> 0){
//				sheetObjects[1].CheckAll("sheet2_Sel",0);
//				//in case of Proforma Schedule in VSL SKD
//				if(formObj.check_vsl_skd.value == "Y"){
//					//in case Lane Cd is Feeder, Editable
//					if(formObj.vsl_svc_tp_cd.value == "O"){
//						sheetObj.SetEditable(1);
//						formObj.brth_itval_dys.disabled=false;
//						comboObjects[0].SetEnable(1);
//						formObj.n1st_vsl_clss_knt.disabled=false;
//						comboObjects[1].SetEnable(1);
//						formObj.n2nd_vsl_clss_knt.disabled=false;
//						comboObjects[2].SetEnable(1);
//						formObj.n3rd_vsl_clss_knt.disabled=false;
//						formObj.svc_dur_dys.disabled=false;
//					//in case Lane Cd is Feeder, not Editable
//					}else{
//						sheetObj.SetEditable(0);
//						formObj.brth_itval_dys.disabled=true;
//						comboObjects[0].SetEnable(0);
//						formObj.n1st_vsl_clss_knt.disabled=true;
//						comboObjects[1].SetEnable(0);
//						formObj.n2nd_vsl_clss_knt.disabled=true;
//						comboObjects[2].SetEnable(0);
//						formObj.n3rd_vsl_clss_knt.disabled=true;
//						formObj.svc_dur_dys.disabled=true;
//					}
//				//in case of Proforma Schedule not in VSL SKD, Editable
//				}else{
//					sheetObj.SetEditable(1);
//					formObj.brth_itval_dys.disabled=false;
//					comboObjects[0].SetEnable(1);
//					formObj.n1st_vsl_clss_knt.disabled=false;
//					comboObjects[1].SetEnable(1);
//					formObj.n2nd_vsl_clss_knt.disabled=false;
//					comboObjects[2].SetEnable(1);
//					formObj.n3rd_vsl_clss_knt.disabled=false;
//					formObj.svc_dur_dys.disabled=false;
//				}
//				var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows()- 1;
//				var whiteColor="#NANNANNAN";
//				var grayColor="#NANNANNAN";
//				sheetObj.SetCellEditable(3, prefix+"mnvr_in_hrs",0);
//				sheetObj.SetCellFontColor(3,prefix+"mnvr_in_hrs",grayColor);
//				sheetObj.SetCellEditable(lastPos, prefix+"mnvr_in_hrs",1);
//				sheetObj.SetCellBackColor(lastPos, prefix+"mnvr_in_hrs",whiteColor);
//				for(var k=4; k<=sheetObj.RowCount()+2; k++){
//					sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
//					sheetObj.SetCellEditable(k, "sheet2_etb_dy_cd",0);
//					sheetObj.SetCellEditable(k, "sheet2_etb_tm_hrmnt",0);
//	       	 	}
//				for(var k=3; k<=sheetObj.RowCount()+2; k++){
//					sheetObj.SetCellEditable(k, "sheet2_etd_dy_no",0);
//					sheetObj.SetCellEditable(k, "sheet2_etd_dy_cd",0);
//					sheetObj.SetCellEditable(k, "sheet2_etd_tm_hrmnt",0);
//					sheetObj.SetCellEditable(k, "sheet2_tztm_hrs",0);
//					sheetObj.SetCellEditable(k, "sheet2_sea_buf_spd",0);
//					sheetObj.SetCellEditable(k, "sheet2_port_cd",1);
//					sheetObj.SetCellEditable(k, "sheet2_tml_prod_qty",0);
//					sheetObj.SetCellEditable(k, "sheet2_crn_knt",0);
//	       	 	}
//				for(var k=3; k<=sheetObj.RowCount()+2; k++){
//					if(sheetObj.GetCellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.GetCellValue(k, "sheet2_crane_wk_tm") != ""){
//						var redColor="#NANNANNAN";
//						sheetObj.SetCellBackColor(k,"sheet2_port_cd",redColor);
//						sheetObj.SetCellBackColor(k,"sheet2_etb_dy_no",redColor);
//						sheetObj.SetCellBackColor(k,"sheet2_etb_dy_cd",redColor);
//						sheetObj.SetCellBackColor(k,"sheet2_etb_tm_hrmnt",redColor);
//					}
//	       	 	}
//				for(var i=0; i<sheetObj.RowCount(); i++){
//					sheetObj.CellComboItem(sheetObj.HeaderRows+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
//					sheetObj.SetCellValue(sheetObj.HeaderRows()+i, prefix+"yd_cd",ydCdsArr[i],0);
//					//sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
//					sheetObj.SetRowStatus(sheetObj.HeaderRows()+i,"R");
//				}
				if(Pos == "Y"){
					var posTemp=Number(formObj.currPos.value);
					sheetObj.SelectCell(posTemp, sheetObj.id+"_port_cd", true);
				}
//				
//
			}
//			//alert('showSheetData_sheet1-end');

		break;
	}
}

	
function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) 
{
	formObj = document.form;
	prefix = sheetObj.id+"_";
	if(sheetObj.RowCount()> 0){
		sheetObjects[1].CheckAll("sheet2_Sel",0);
		for(var i=0; i<sheetObj.RowCount(); i++){
			sheetObj.CellComboItem(sheetObj.HeaderRows()+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
			
			sheetObj.SetCellValue(i+3, "sheet2_lnk_spd", ComRound(sheetObj.GetCellValue(i+3,"sheet2_lnk_spd"), 1), 0);
		}
	}
	if(sheetObj.RowCount()> 0){
		sheetObjects[1].CheckAll("sheet2_Sel",0);
		//VSL SKD에 등록이 되어 있는 Profoma Schedule일 경우
		if(formObj.check_vsl_skd.value == "Y"){
			//해당 Lane Cd가 Feeder 일 경우는 Editable 가능
//			if(formObj.vsl_svc_tp_cd.value == "O"){
//				sheetObj.SetEditable(1);
//				formObj.brth_itval_dys.disabled=false;
//				comboObjects[0].SetEnable(1);
//				formObj.n1st_vsl_clss_knt.disabled=false;
//				comboObjects[1].SetEnable(1);
//				formObj.n2nd_vsl_clss_knt.disabled=false;
//				comboObjects[2].SetEnable(1);
//				formObj.n3rd_vsl_clss_knt.disabled=false;
//				formObj.svc_dur_dys.disabled=false;
//			//해당 Lane Cd가 Trunk 일 경우는 Editable 불가능
//			}else{
				sheetObj.SetEditable(0);
				formObj.brth_itval_dys.disabled=true;
				comboObjects[0].SetEnable(0);
				formObj.n1st_vsl_clss_knt.disabled=true;
				comboObjects[1].SetEnable(0);
				formObj.n2nd_vsl_clss_knt.disabled=true;
				comboObjects[2].SetEnable(0);
				formObj.n3rd_vsl_clss_knt.disabled=true;
				formObj.svc_dur_dys.disabled=true;
			}
		//VSL SKD에 등록이 되어 있는 Profoma Schedule이 아닌 경우 Editable 가능
		else{
			sheetObj.SetEditable(1);
			formObj.brth_itval_dys.disabled=false;
			comboObjects[0].SetEnable(1);
			formObj.n1st_vsl_clss_knt.disabled=false;
			comboObjects[1].SetEnable(1);
			formObj.n2nd_vsl_clss_knt.disabled=false;
			comboObjects[2].SetEnable(1);
			formObj.n3rd_vsl_clss_knt.disabled=false;
			formObj.svc_dur_dys.disabled=false;
		}
		
		var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows()- 1;
		var whiteColor="#FFFFFF";
		var grayColor="#F5F5F5";

		sheetObj.SetCellEditable(3, prefix+"mnvr_in_hrs",0);
		sheetObj.SetCellFontColor(3,prefix+"mnvr_in_hrs",grayColor);
		sheetObj.SetCellEditable(lastPos, prefix+"mnvr_in_hrs",1);
		//sheetObj.SetCellBackColor(lastPos, prefix+"mnvr_in_hrs",whiteColor);
		for(var k=4; k<=sheetObj.RowCount()+2; k++){
			sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
			sheetObj.SetCellEditable(k, "sheet2_etb_dy_cd",0);
			sheetObj.SetCellEditable(k, "sheet2_etb_tm_hrmnt",0);
   	 	}
		for(var k=3; k<=sheetObj.RowCount()+2; k++){
			sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
			sheetObj.SetCellEditable(k, "sheet2_etd_dy_no",0);
			sheetObj.SetCellEditable(k, "sheet2_etd_dy_cd",0);
			sheetObj.SetCellEditable(k, "sheet2_etd_tm_hrmnt",0);
			sheetObj.SetCellEditable(k, "sheet2_tztm_hrs",0);
			sheetObj.SetCellEditable(k, "sheet2_sea_buf_spd",0);
			sheetObj.SetCellEditable(k, "sheet2_port_cd",1);
			sheetObj.SetCellEditable(k, "sheet2_tml_prod_qty",0);
			sheetObj.SetCellEditable(k, "sheet2_crn_knt",0);
   	 	}
		for(var k=3; k<=sheetObj.RowCount()+2; k++){
			if(sheetObj.GetCellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.GetCellValue(k, "sheet2_crane_wk_tm") != ""){
				var redColor="#FF7F50";
				sheetObj.SetCellBackColor(k,"sheet2_port_cd",redColor);
				sheetObj.SetCellBackColor(k,"sheet2_etb_dy_no",redColor);
				sheetObj.SetCellBackColor(k,"sheet2_etb_dy_cd",redColor);
				sheetObj.SetCellBackColor(k,"sheet2_etb_tm_hrmnt",redColor);
			}
   	 	}
	}
	
	//A/Calculation 일경우  Manv. Out의 첫번째 값을  마지막 Manv. In에 할당한다.
	var lastRow  = sheetObj.HeaderRows()+sheetObj.RowCount()- 1;
	var frstRow  = sheetObj.HeaderRows();
	if(isACal == "Y"){
		sheetObj.SetCellValue(lastRow, "sheet2_mnvr_in_hrs", sheetObj.GetCellValue(frstRow,"sheet2_mnvr_out_hrs"), 0);
		isACal = "N";
	}
	
	var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows();
 	gridEndJob(sheetObjects[1],formObj);
	setlastLowView(sheetObjects[1],lastPos);
	ComOpenWait(false);
	// Vessel Schedule(Trunk, Feeder 포함)에서 해당 Proforma Schedule 사용시 메세지를 표시한다.
	if(formObj.check_vsl_skd.value == "Y") {
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowInsert");
		ComBtnDisable("btn_RowDelete");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_MSimulation");
		ComBtnDisable("btn_ASimulation");
		ComShowCodeMessage("VSK00083");
	}else{
		ComBtnEnable("btn_RowAdd");
		ComBtnEnable("btn_RowInsert");
		ComBtnEnable("btn_RowDelete");
		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_MSimulation");
		ComBtnEnable("btn_ASimulation");
	}
	
	/*
	 * Save전에 M/Calculation으로 data check한다
	 */		
	if (saveFlg == "Y") {
		saveFlg = "N";
		doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
	}
}


/**
 * after Showing grid Duration, Setting Frequency
 * @param sheetObj
 * @param formObj
 * @return
 */
function gridEndJob(sheetObj,formObj){

	formObj.mml_usd_flg.value="N";
//	formObj.slan_stnd_flg.value="N";
	
	var lastRow         = sheetObj.HeaderRows()+sheetObj.RowCount()- 1;
	var frstRow         = sheetObj.HeaderRows();
	var lastEtbDyNo     = parseInt(sheetObj.GetCellValue(lastRow,"sheet2_etb_dy_no"));
	var lastEtbTmHrmnt  = sheetObj.GetCellValue(lastRow,"sheet2_etb_tm_hrmnt");
	var firstEtbDyNo    = parseInt(sheetObj.GetCellValue(frstRow,"sheet2_etb_dy_no"));
	var firstEtbTmHrmnt = sheetObj.GetCellValue(frstRow,"sheet2_etb_tm_hrmnt");

	//Manv. In의 마지막 값을 첫번째 Manv. In에 할당한다.
	sheetObj.SetCellValue(frstRow, "sheet2_mnvr_in_hrs", sheetObj.GetCellValue(lastRow,"sheet2_mnvr_in_hrs"), 0);
	
	var tempLastEtbTmHrmnt  = lastEtbTmHrmnt.length;
	var tempFirstEtbTmHrmnt = firstEtbTmHrmnt.length;
	var lastEtbTmHrmntVal   = 0;
	var firstEtbTmHrmntVal  = 0;
	if(tempLastEtbTmHrmnt == 4){
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,2);
	}else{
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,1);
	}
	if(tempFirstEtbTmHrmnt == 4){
		firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,2);
	}else{
		firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,1);
	}
	if(tempLastEtbTmHrmnt == 4){
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,2);
	}else{
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,1);
	}
	if(tempFirstEtbTmHrmnt == 4){
		firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,2);
	}else{
		firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,1);
	}
	var lastTot=parseInt(lastEtbDyNo * 24) + parseInt(lastEtbTmHrmntVal);
	var firstTot=parseInt(firstEtbDyNo * 24) + parseInt(firstEtbTmHrmntVal);
	var tempDur=parseInt(lastTot - firstTot);
	// Duration, Frequency - emission of fraction to the nearest hundredth
	var durVal1=tempDur/24;
	durVal1=parseInt(durVal1 * 10);
	durVal1=parseFloat(durVal1/10);
	var resultDurVal=isNaN(durVal1);
	if(resultDurVal == true){
		durVal1=0;
	}
	formObj.svc_dur_dys.value=durVal1; 
	// Frequency
	var vslCnt=Number(formObj.n1st_vsl_clss_knt.value) + Number(formObj.n2nd_vsl_clss_knt.value) + Number(formObj.n3rd_vsl_clss_knt.value);
	var frequency=durVal1/vslCnt;
	frequency=Math.round(parseInt(frequency * 10))/10;
	/*
	 * 2015.04.16 P/F SKD Creation(CCA)에서 만든 SKD의 경우, 
	 * P/F SKD Creation에서 Retrieve시, Frequency가 NaN으로 나오는현상 수정 
	 * 밑의 주석 부분은 0으로 반영, 실제로는 공백으로 반영되도록 수정 
	 */
	if(vslCnt==0){
		frequency = "";
	}
//	var resultFreqVal = isNan(frequency);
//	if(resultFreqVal==true){
//	 frequency = "";
//	}
	formObj.brth_itval_dys.value=frequency;

}


/**
 * process after Row Delete
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function rowDelshowSheetData(sheetObj, formObj, sXml,Pos){
	var prefix=sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":
			var ydCds=ComGetEtcData(sXml, "ydCd").split("|");
			if(ydCds != null && ydCds != undefined && ydCds != ""){
				for(var i=0 ; i < ydCds.length ; i++ ){
					ydCdsArr[i]=ydCds[i];
				}
			}
		break;
		case "sheet2":
			var dataNode = ComGetSelectSingleNode(sXml, "TOTAL");
			
			if(dataNode){
				//var totValue=dataNode.value;
				//::FOR.NYK.START::by DONGSOO:2014-09-10:://
				var totValue=dataNode;
				//::FOR.NYK.FINISH::by DONGSOO:2014-09-10:://
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(totValue > 0){
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					initPortDataFlg(sheetObj);
					if(sheetObj.RowCount()> 0){
						var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows()- 1;
						var whiteColor="#FFFFFF";
						var grayColor="#F5F5F5";

						sheetObj.SetCellEditable(3, prefix+"mnvr_in_hrs",0);
						sheetObj.SetCellFontColor(3,prefix+"mnvr_in_hrs",grayColor);
						sheetObj.SetCellEditable(lastPos, prefix+"mnvr_in_hrs",1);
						sheetObj.SetCellBackColor(lastPos, prefix+"mnvr_in_hrs",whiteColor);
						for(var k=4; k<=sheetObj.RowCount()+2; k++){
							sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
							sheetObj.SetCellEditable(k, "sheet2_etb_dy_cd",0);
							sheetObj.SetCellEditable(k, "sheet2_etb_tm_hrmnt",0);
			       	 	}
						for(var k=3; k<=sheetObj.RowCount()+2; k++){
							sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
							sheetObj.SetCellEditable(k, "sheet2_etd_dy_no",0);
							sheetObj.SetCellEditable(k, "sheet2_etd_dy_cd",0);
							sheetObj.SetCellEditable(k, "sheet2_etd_tm_hrmnt",0);
							sheetObj.SetCellEditable(k, "sheet2_tztm_hrs",0);
							sheetObj.SetCellEditable(k, "sheet2_sea_buf_spd",0);
							sheetObj.SetCellEditable(k, "sheet2_port_cd",1);
							sheetObj.SetCellEditable(k, "sheet2_tml_prod_qty",0);
							sheetObj.SetCellEditable(k, "sheet2_crn_knt",0);
			       	 	}
						for(var k=3; k<=sheetObj.RowCount()+2; k++){
							if(sheetObj.GetCellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.GetCellValue(k, "sheet2_crane_wk_tm") != ""){
								var redColor="#FF7F50";
								sheetObj.SetCellBackColor(k,"sheet2_port_cd",redColor);
								sheetObj.SetCellBackColor(k,"sheet2_etb_dy_no",redColor);
								sheetObj.SetCellBackColor(k,"sheet2_etb_dy_cd",redColor);
								sheetObj.SetCellBackColor(k,"sheet2_etb_tm_hrmnt",redColor);
							}
			       	 	}
						resetRowSeq(sheetObj);
						for(var i=0; i<sheetObj.RowCount(); i++){
							sheetObj.CellComboItem(sheetObj.HeaderRows+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
							sheetObj.SetCellValue(sheetObj.HeaderRows()+i, prefix+"yd_cd",ydCdsArr[i],0);
							//sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
							sheetObj.SetRowStatus(sheetObj.HeaderRows()+i,"R");
						}
					}
				}
			}
		break;
	}
}
/**
 * Setting initial data for P/F Type Setting
 * @param sheetObj
 * @return
 */
function initPortDataFlg(sheetObj){ 
	for(var i=3; i<sheetObj.LastRow(); i++){
		portDataFlgs[i-3]="N";
	}
}
/**
 * Handling grid click process
 */
function sheet2_OnClick(sheetObject, Row, Col) {
	var formObj=document.form;
	var sXml=null;
	var prefix=sheetObject.id + "_";
	if(Row > 1 && Col > 0){
		if(sheetObject.ColSaveName(Col) == prefix+"yd_cd"){
			formObj.port_cd.value=sheetObject.GetCellValue(Row, prefix + "port_cd");
			var tempPortCd=formObj.port_cd.value;
			if(tempPortCd.length == 5){
				// if combo already retrieved, not retrieve anymore
				var ydCdArr=sheetObject.GetComboInfo(Row, prefix + "yd_cd", "Code");
				if(ydCdArr.split("|").length == 1){
					sXml=doActionIBSheet(sheetObject, formObj, SEARCH05);
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetComboSinc(sXml, sheetObject, Row, Col);
					}
				}
			}
		}
	}
}
function sheet2_OnComboChange(sheetObj,Row, Col, Code, Text){
	var colSaveName = sheetObj.ColSaveName(Col);
	var formObj=document.form;
	var prefix="sheet2_";
	var tempYdCd=sheetObj.GetCellValue(Row,Col);
	var portCd=sheetObj.GetCellValue(Row,Col-1);
	var ydCd="";
	if(tempYdCd != "" && portCd != ""){
		if(colSaveName == prefix+"yd_cd"){
			formObj.yd_cd.value=portCd+tempYdCd;	
			var sXml=doActionIBSheet(sheetObj, formObj, SEARCH04);
			var mnvrInHrs=ComGetEtcData(sXml, "mnvr_in_hrs");
			var mnvrOutHrs=ComGetEtcData(sXml, "mnvr_out_hrs");
			sheetObj.SetCellValue(Row,prefix+"mnvr_in_hrs",mnvrInHrs);
			sheetObj.SetCellValue(Row,prefix+"mnvr_out_hrs",mnvrOutHrs);
		}
	}
}
/**
 * SHEET2 그리드 데이타 change 이벤트
 */
function sheet2_OnChange(sheetObj, Row, Col, Value, OldValue) {
	var colSaveName = sheetObj.ColSaveName(Col);
	var prefix=sheetObj.id + "_";
	var cnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
	var formObj=document.form;
	
	
	if(Row > 2){
		if(colSaveName == prefix+"skd_dir_cd"){
			for(var i=Row; i<=cnt+Row; i++){
				sheetObj.SetCellValue(i,prefix+"skd_dir_cd",Value,0);
			}
		}else if(colSaveName == prefix+"port_cd"){
			//초기에 sheet2_OnKeyUp 이벤트에서 5자리로  이벤트를 잡았는데
			//후에 port_cd의 validtion 체트 (3자를 넣어도 체크를 할 수 있도록 요청)때문에
			//sheet2_OnChange로 이벤트를 바꿈 
			//그래서  sheet2_OnChange에서는 port_cd 사이즈로는 이벤트를 자동으로 발생시킬 수가 없음
			var headCnt=sheetObj.HeaderRows();
			var rowCnt=sheetObj.RowCount();
			var totalCnt=headCnt+rowCnt;
			var currPos=(sheetObj.GetSelectRow()- headCnt)+1;
			var currRow=sheetObj.GetSelectRow();
			var tempVal=sheetObj.GetEditText();
			if(currPos == 1 && rowCnt == 1){ // Retrieve 하지 않고 Row Add 버튼을 눌러 하나의 Row를 생성한 경우
				if(Value.length == 0){ // 기존 Port Code 값을 지운 경우
					return;
				}
			}
			if(Value.length == 5){
				formObj.port_cd.value=Value;		
				sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
				var chkPort=ComGetEtcData(sXml, "check_port");
				if(chkPort == "X"){ // 존재하는 Port Code 인 경우
					if(sXml != null && sXml != undefined && sXml != ""){
						//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
						//xmlDoc.loadXML(sXml);
//						// Terminal Code 리스트가 있으면 콤보에 반영한다.
						//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
						//::FOR.NYK.START::by DONGSOO:2014-09-17:://
						//::dataNode에 TOTAL값이 넘겨져옮 
						var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
						//if(dataNode){
							var totValue=dataNode;
							if(totValue > 0){
								setSheetComboSinc(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.SetCellValue(Row, sheetObj.id+"_yd_cd","",0);
							}
						//}
						//::FOR.NYK.FINISH::by DONGSOO:2014-09-17:://
					}
					var portInfoCnt=Number(ComGetEtcData(sXml, "portInfoCnt"));
					var currPos=Number(ComGetEtcData(sXml, "currPos"));
					var dataPos=ComGetEtcData(sXml, "dataPos");
					var oneDataPos=0;
					var twoFromDataPos=0;
					var twoToDataPos=0;
					//전 포트가 존재 하지 않기때문에 자기 자신의 현재 포트에 데이타를 출력한다 S = SELF
					if(dataPos == "S"){
						oneDataPos=currPos;
					//전 포트가 존재 하기때문에 자기 자신의 전 포트에 데이타를 출력한다 F = FROM
					}else if(dataPos == "F"){
						oneDataPos=currPos - 1;
					//현재 포트와 전 포트 , 그리고 다음 포트까지 존해 하므로 A = ALL	
					}else if(dataPos == "A"){
						twoFromDataPos=currPos -1;
						twoToDataPos=currPos + 1;
					//현재포트와 다음 포트 존재 T = TO	
					}else if(dataPos == "T"){
						oneDataPos=currPos;
					//현재 포트가 마지막 로우일때 E = END	
					}else if(dataPos == "E"){
						oneDataPos=currPos-1;
					}
					//현재 포트나  현재포트와 전포트, 현재포트와 후 포트를 조회시
					if(portInfoCnt == 1){
						//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
						//전 포트의 LNK_DIST,FM_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY 값을 채운다
						//현재 포트의 TO_ZD를 채운다
						var dataVal=ComGetEtcData(sXml, "one_row");
						var dataValArr=dataVal.split("|");
						//현재 포트가 첫번째이면서 전체 로우가 하나일때
						if(dataPos == "S"){
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[2]);
							sheetObj.SetCellValue(oneDataPos,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos,prefix+"tml_prod_qty",dataValArr[5]);
						//현재 포트가 두번째 로우 이고 전체 로우가 두개일때	
						}else if(dataPos == "F"){
							//현재 포트의 전 포트
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[1]);
							//현재 포트
							sheetObj.SetCellValue(oneDataPos+1,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"tml_prod_qty",dataValArr[5]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"zd",dataValArr[2]);
						//현재 포트가 첫번재 이면서 전체 로우가 하나이상일때	
						}else if(dataPos == "T"){
							//현재 포트
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[1]);
							sheetObj.SetCellValue(oneDataPos,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos,prefix+"tml_prod_qty",dataValArr[5]);
							//다음 포트
							sheetObj.SetCellValue(oneDataPos+1,prefix+"zd",dataValArr[2]);
						//현재 포트가 마지  막 로우일때		
						}else if(dataPos == "E"){
							//전 포트
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[1]);
							//현재 포트
							sheetObj.SetCellValue(oneDataPos+1,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"tml_prod_qty",dataValArr[5]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"zd",dataValArr[2]);
						}
					//현재 포트와 전,후 포트 모두 조회시
					}else{
						var oneDataVal=ComGetEtcData(sXml, "one_row");
						var twoDataVal=ComGetEtcData(sXml, "two_row");
						var oneDataValArr=oneDataVal.split("|");
						var twoDataValArr=twoDataVal.split("|");
						//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
						sheetObj.SetCellValue(twoFromDataPos,prefix+"lnk_dist",oneDataValArr[0]);
						sheetObj.SetCellValue(twoFromDataPos,prefix+"zd",oneDataValArr[1]);
						sheetObj.SetCellValue(currPos,prefix+"port_buf_hrs",oneDataValArr[3]);
						sheetObj.SetCellValue(currPos,prefix+"crn_knt",oneDataValArr[4]);
						sheetObj.SetCellValue(currPos,prefix+"tml_prod_qty",oneDataValArr[5]);
						sheetObj.SetCellValue(currPos,prefix+"lnk_dist",twoDataValArr[0]);
						sheetObj.SetCellValue(currPos,prefix+"zd",oneDataValArr[2]);
						sheetObj.SetCellValue(twoToDataPos,prefix+"zd",twoDataValArr[2]);
					}
					sheetObj.SelectCell(Row, Col, true);
				}else{	// 존재하지 않는 Port Code를 입력한 경우
					ComShowCodeMessage('VSK00029', Value); 
					sheetObj.SetCellValue(Row, Col,"",0);
					sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(Row,"sheet2_zd","");
					sheetObj.SelectCell(Row, Col-1, true);
				}
			}else{
				//ComShowCodeMessage('VSK00029', tempVal);
				ComShowCodeMessage('VSK50014');
				sheetObj.SetCellValue(Row, Col,"",0);
				sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
				sheetObj.SetCellValue(Row,"sheet2_zd","");
				sheetObj.SelectCell(Row, Col-1, true);
			}
		}else if(colSaveName == prefix+"etb_dy_no"){
			var tempEtbDyNo=parseInt(sheetObj.GetCellValue(Row, Col));
			if(tempEtbDyNo != 0 && tempEtbDyNo != 1){
				ComShowCodeMessage('VSK00041');
				sheetObj.SetCellValue(Row, Col,0);
				sheetObj.SelectCell(Row, Col, true);
			}
		}else if(colSaveName == prefix+"etb_tm_hrmnt"){
			var tempEtbTmHrmnt=parseInt(sheetObj.GetCellValue(Row, Col));
			if(tempEtbTmHrmnt != 0){
				sheetObj.SelectCell(Row, 16, true);
			}
		}else if(colSaveName == prefix+"mnvr_in_hrs" && Row == sheetObj.LastRow()) {
			sheetObj.SetCellValue(sheetObj.HeaderRows(), Col, Value, 0);
		}else if(Col >= 13 && Col <= 25){ // port code 
			if (Number(Value) < 0) {
				sheetObj.SetCellValue(Row, Col,OldValue);
			}
			
		}else if(colSaveName == prefix+"turn_port_flg"){
			var tempPortFlg=sheetObj.GetCellValue(Row, Col);
			sheetObj.SetCellValue(Row, Col+1,tempPortFlg);
		}
	}
}
/**
 * Handling Terminal Code of SHEET2 Event
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){
	var ydKindCode=ComGetEtcData(xmlStr, "yd_kind");
	var ydNm=ComGetEtcData(xmlStr, "yd_nm");
	var ydTxt="";
	if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
		var ydKindCodeArr=ydKindCode.split("|");
		var ydNmArr=ydNm.split("|");
		var ydCnt=ydKindCodeArr.length;
		ydTxt=ydKindCodeArr[0] + "\t" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxt=ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
		}
		sheetObject.CellComboItem(Row,sheetObject.id+"_yd_cd", {ComboText:ydTxt, ComboCode:ydKindCode} );
	}
}
/**
 * Initializing screen
 */
function clearAllData(sheetObj1,sheetObj2,formObj,status){
	if(status){
		formObj.vsl_slan_cd.value="";
		formObj.pf_svc_tp_cd.value="";
	}
	formObj.brth_itval_dys.value="";
	formObj.slan_stnd_flg.value="N";
	//formObj.n1st_vsl_clss_cd.value = "";
	comboObjects[0].SetSelectIndex(-1,false);
	formObj.n1st_vsl_clss_knt.value="";
	//formObj.n2nd_vsl_clss_cd.value = "";
	comboObjects[1].SetSelectIndex(-1,false);
	formObj.n2nd_vsl_clss_knt.value="";
	//formObj.n3rd_vsl_clss_cd.value = "";
	comboObjects[2].SetSelectIndex(-1,false);
	formObj.n3rd_vsl_clss_knt.value="";
	formObj.svc_dur_dys.value="";
	formObj.mml_usd_flg.value="N";
	formObj.upd_dt.value="";
	formObj.pf_skd_rmk.value="";
	//formObj.clpt_knt.value = "";
	formObj.tot_buf_rat.value="";
	//formObj.ttl_dist.value = "";
	formObj.sea_buf_rat.value="";
	formObj.max_spd.value="";
	formObj.port_buf_rat.value="";
	//formObj.avg_spd.value = "";
	formObj.pf_spd_rat.value="";
	//formObj.buf_spd.value = "";
	formObj.buf_spd_rat.value="";
	formObj.brth_itval_dys.disabled=false;
	//formObj.n1st_vsl_clss_cd.disabled = false;
	comboObjects[0].SetEnable(1);
	formObj.n1st_vsl_clss_knt.disabled=false;
	//formObj.n2nd_vsl_clss_cd.disabled = false;
	comboObjects[1].SetEnable(1);
	formObj.n2nd_vsl_clss_knt.disabled=false;
	//formObj.n3rd_vsl_clss_cd.disabled = false;
	comboObjects[2].SetEnable(1);
	formObj.n3rd_vsl_clss_knt.disabled=false;
	formObj.svc_dur_dys.disabled=false;
	formObj.check_vsl_skd.value="N"
	sheetObj2.SetEditable(1);
	sheetObj1.RemoveAll();
	sheetObj1.DataInsert(-1);
	sheetObj2.RemoveAll();
	ComBtnEnable("btn_RowAdd");
	ComBtnEnable("btn_RowInsert");
	ComBtnEnable("btn_RowDelete");
	ComBtnEnable("btn_Delete");
	ComBtnEnable("btn_MSimulation");
	ComBtnEnable("btn_ASimulation");
	formObj.vsl_slan_cd.focus();
}
/**
 * Open Lane Code Help
 */
function openLandCdHelp(sheetObj){
   var v_display="0,0";
   var laneCd=document.form.vsl_slan_cd.value;
   ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "getReturn0202", v_display, true);
}

function getReturn0202(rtnVal){

	var formObj=document.form;
	var rVal = rtnVal[0];
	if( rVal.length >0 ){
		
		formObj.vsl_slan_cd.value =rVal[1];
	}
	
}

/**
 * Open P/F Lane Type Code Help  
 */
function openPfLandTypeCdHelp(sheetObj){
	 var targetObjList="sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
	 var v_display="0,0";
	 var laneCd=document.form.vsl_slan_cd.value;
	 //ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 640, 490, targetObjList, v_display, true);
	 ComOpenPopup('/opuscntr/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 640, 510, "getReturn0241", v_display, true);
}

function getReturn0241( rVal ){
	var formObj=document.form;
	var tmp = rVal[0];
	if( rVal != ""  || rVal != null ){
		
		formObj.pf_svc_tp_cd.value =tmp[3];
	}
	
}

/**
 * Open P/F Skd History  
 */
function openPfSkdHistoryHelp(sheetObj){
	var formObj=document.form;
	 var vslSlanCd=formObj.vsl_slan_cd.value;
	 var pfSvcTpCd=formObj.pf_svc_tp_cd.value;
	 if(vslSlanCd == "" || vslSlanCd.length == 0){
		 ComShowCodeMessage('VSK00027', "Lane Code");
		 formObj.vsl_slan_cd.focus();
		 return;
	 }
	 if(pfSvcTpCd == "" || pfSvcTpCd.length == 0){
		 ComShowCodeMessage('VSK00027', "P/F SKD Type");
		 formObj.pf_svc_tp_cd.focus();
		 return;
	 }
	 var targetObjList="sheet1_upd_dt:upd_dt";
	 var v_display="0,0";
	 ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0248.do?vsl_slan_cd='+vslSlanCd+"&pf_svc_tp_cd="+pfSvcTpCd, 700, 510, targetObjList, v_display, true);
	 //var tempUpdDt = formObj.upd_dt.value;
	 //var tempVal = tempUpdDt.substring(0,4)+"-"+tempUpdDt.substring(4,6)+"-"+tempUpdDt.substring(6,8)+" "+tempUpdDt.substring(8,10)+":"+tempUpdDt.substring(10,12);
	 //formObj.upd_dt.value = tempVal;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				return false;
			}
			break;
		case "Msimul": 
			var rowCnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
			var prefix=sheetObj.id + "_";
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus();
				return false;
			}
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(ComIsNull(comboObjects[0].GetSelectCode())){
				ComShowCodeMessage('VSK00027', "1st Vessel Class");
//				comboObjects[0].focus();
				return false;
			}
			if(ComIsNull(formObj.n1st_vsl_clss_knt.value)){
				ComShowCodeMessage('VSK00027', "1st Vessel Count");
				formObj.n1st_vsl_clss_knt.focus();
				return false;
			}
			if(sheetObjects[1].RowCount()< 1){
				ComShowCodeMessage("VSK00012");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(rowCnt > 2){
				for(var i=3; i<=sheetObj.RowCount()+2; i++){
					if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "Port Code");
						sheetObj.SelectCell(i,"sheet2_port_cd");
						return false;
					}
					/*
					if(sheetObj.GetCellValue(i, prefix+"yd_cd").length < 2){
						ComShowCodeMessage("VSK01018", "[Terminal Code]");
						sheetObj.SelectCell(i,"sheet2_yd_cd");
						return false;
					}
					*/
				}
			}
			
			break;		
		case "Asimul":      //save
			var rowCnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
			var prefix=sheetObj.id + "_";
			var rowCnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
			var prefix=sheetObj.id + "_";
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus()
				return false;
			}
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(ComIsNull(comboObjects[0].GetSelectCode())){
				ComShowCodeMessage('VSK00027', "1st Vessel Class");
				comboObjects[0].focus();
				return false;
			}
			if(ComIsNull(formObj.n1st_vsl_clss_knt.value)){
				ComShowCodeMessage('VSK00027', "1st Vessel Count");
				formObj.n1st_vsl_clss_knt.focus();
				return false;
			}
			if(sheetObjects[1].RowCount()< 2){
				ComShowCodeMessage("VSK00036");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(rowCnt > 2){
				for(var i=3; i<=sheetObj.RowCount()+2; i++){
					if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "Port Code");
						sheetObj.SelectCell(i,"sheet2_port_cd");
						return false;
					}
					if(sheetObj.GetCellValue(i, prefix+"yd_cd").length < 2){
						ComShowCodeMessage("VSK01018", "Terminal Code");
						sheetObj.SelectCell(i,"sheet2_yd_cd");
						return false;
					}
				}
			}
			break;
		case IBSAVE:      //save
			var prefix=sheetObj.id + "_";
			var headCnt=sheetObj.HeaderRows();
			var totCnt=sheetObj.LastRow();
			//###########################################################
			// Proforma Schedule Master Validation
			//###########################################################
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				formObj.vsl_slan_cd.focus()
				ComShowCodeMessage('VSK00027', "Lane Code");
				return false;
			}
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				formObj.pf_svc_tp_cd.focus()
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				return false;
			}
			if(formObj.vsl_slan_cd.value.length < 3){
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				ComShowCodeMessage('VSK00027', "Lane Code");
				return false;
			}
			if(ComIsNull(comboObjects[0].GetSelectCode())){
				comboObjects[0].focus();
				ComShowCodeMessage('VSK00027', "1st Vessel Class");
				return false;
			}
			if(ComIsNull(formObj.n1st_vsl_clss_knt.value) || formObj.n1st_vsl_clss_knt.value == "0"){
				formObj.n1st_vsl_clss_knt.focus();
				ComShowCodeMessage('VSK00027', "1st Vessel Count");
				return false;
			}
			var vslClssCd1=comboObjects[0].GetSelectText();
			var vslClssCd2=comboObjects[1].GetSelectText();
			var vslClssCd3=comboObjects[2].GetSelectText();
			var	comVslClss=0;
			if(VskIsNull(vslClssCd1)){
				comboObjects[0].focus();
				ComShowCodeMessage('VSK00099', vslClssCd1);
				return false;
			}
			if(ComIsNull(vslClssCd2) && (formObj.n2nd_vsl_clss_knt.value > 0)) {
				comboObjects[1].focus();
				ComShowCodeMessage('VSK01017', "2nd Vessel Class");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			if (!ComIsNull(vslClssCd2) && ((formObj.n2nd_vsl_clss_knt.value == 0) || (formObj.n2nd_vsl_clss_knt.value == ""))) {
				formObj.n2nd_vsl_clss_knt.focus();
				ComShowCodeMessage('VSK01017', "2nd Vessel Count");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			if(ComIsNull(vslClssCd3) && (formObj.n3rd_vsl_clss_knt.value > 0)) {
				comboObjects[2].focus();
				ComShowCodeMessage('VSK01017', "3th Vessel Class");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			if(!ComIsNull(vslClssCd3) && ((formObj.n3rd_vsl_clss_knt.value == 0) || (formObj.n3rd_vsl_clss_knt.value == ""))) {
				formObj.n3rd_vsl_clss_knt.focus();
				ComShowCodeMessage('VSK01017', "3th Vessel Count");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			if(VskIsNotNull(vslClssCd1) && VskIsNotNull(vslClssCd2)){
				if (vslClssCd1 == vslClssCd2) {
					comboObjects[1].focus();
					ComShowCodeMessage('VSK00099', vslClssCd2);
					return false;
				};
			}
			if(VskIsNotNull(vslClssCd1) && VskIsNotNull(vslClssCd3)){
				if (vslClssCd1 == vslClssCd3) {
					comboObjects[2].focus();
					ComShowCodeMessage('VSK00099', vslClssCd3);
					return false;
				}
			}
			if(VskIsNotNull(vslClssCd2) && VskIsNotNull(vslClssCd3)){
				if (vslClssCd2 == vslClssCd3) {
					comboObjects[2].focus();
					ComShowCodeMessage('VSK00099', vslClssCd3);
					return false;
				}
			}
			if (ComIsNull(vslClssCd2) && !ComIsNull(vslClssCd3)) {
				comboObjects[1].SetSelectText(vslClssCd3);
				formObj.n2nd_vsl_clss_knt.value=formObj.n3rd_vsl_clss_knt.value;
				comboObjects[2].SetSelectText("");
				formObj.n3rd_vsl_clss_knt.value="";
			}
			if(ComIsNull(formObj.svc_dur_dys.value) || (formObj.svc_dur_dys.value == 0)) {
				formObj.svc_dur_dys.focus();
				ComShowCodeMessage('VSK01017', "Duration");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}			
			if(ComIsNull(formObj.brth_itval_dys.value) || (formObj.brth_itval_dys.value == 0)) {
				formObj.brth_itval_dys.focus();
				ComShowCodeMessage('VSK01017', "Frequency");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			if(sheetObj.RowCount()< 2){
				ComShowCodeMessage("VSK00036");
				formObj.vsl_slan_cd.focus();
				return false;
			}
            //Remark Check...
            if (formObj.pf_skd_rmk.value.length > 4000){
                  ComShowCodeMessage( 'VSK01019' , "Remark" );
                  formObj.pf_skd_rmk.focus();
                   return false ;
            }
			//###########################################################
			// Proforma Schedule Detail Validation
			//###########################################################
			
			if(totCnt > headCnt){
				for(var i=headCnt; i<=totCnt; i++){
					if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
						sheetObj.SelectCell(i,prefix+"port_cd");
						ComShowCodeMessage("VSK01018", "Port Code");
						return false;
					}
					if(sheetObj.GetCellValue(i, prefix+"yd_cd").length < 2){
						sheetObj.SelectCell(i,prefix+"yd_cd");
						ComShowCodeMessage("VSK01018", "Terminal Code");
						return false;
					}
					if (i >= headCnt && i < totCnt) {
						if(Number(sheetObj.GetCellValue(i, prefix+"lnk_dist")) < 0){
							sheetObj.SelectCell(i,prefix+"lnk_dist");
							ComShowCodeMessage("VSK01018", "Dist");
							return false;
						}
						/** adding checking logic in case of sea time zero & mnvr/out zero 
						 *  by TOP : 2015-05-26
						 */
						else if( Number(sheetObj.GetCellValue(i, prefix+"lnk_dist")) == 0 && Number(sheetObj.GetCellValue(i, prefix+"mnvr_out_hrs")) <= 0 ){
							sheetObj.SelectCell(i,prefix+"mnvr_out_hrs");
							ComShowCodeMessage("VSK01018", "Manv/Out hours");
							return false;							
						}
						/*****************************************************************/
					}
					
					if (i >= headCnt && i < totCnt) {
						if(Number(sheetObj.GetCellValue(i, prefix+"tztm_hrs")) < 0){
							sheetObj.SelectCell(i,prefix+"tztm_hrs");
							ComShowCodeMessage("VSK01018", "Sea Time");
							return false;
						}
					}
					
					if (i > headCnt) {
						if(Number(sheetObj.GetCellValue(i, prefix+"mnvr_in_hrs")) <= 0){
							sheetObj.SelectCell(i,prefix+"mnvr_in_hrs");
							ComShowCodeMessage("VSK01018", "Manv/In hours");
							return false;
						}
					}
				}
			}
			var firstDirCd=sheetObj.GetCellValue(headCnt,prefix+"skd_dir_cd");
			var otherDirCd=0;
			//Finding Dir Cd which different with dir cd of first port
			for(var i=headCnt; i<=totCnt; i++){
				if(sheetObj.GetCellValue(i,prefix+"skd_dir_cd") != firstDirCd){
					otherDirCd=i;
					break;
				}
			}
			if(otherDirCd > 0){
				if(sheetObj.GetCellValue(headCnt,prefix+"port_cd") == sheetObj.GetCellValue(totCnt,prefix+"port_cd")
						&& sheetObj.GetCellValue(headCnt,prefix+"yd_cd") == sheetObj.GetCellValue(totCnt,prefix+"yd_cd")
					    && sheetObj.GetCellValue(headCnt,prefix+"etb_dy_cd") == sheetObj.GetCellValue(totCnt,prefix+"etb_dy_cd")
						&& sheetObj.GetCellValue(headCnt,prefix+"etb_tm_hrmnt") == sheetObj.GetCellValue(totCnt,prefix+"etb_tm_hrmnt")
					){
						// for Long Range SKD Creation
					sheetObj.SetCellValue(totCnt,prefix+"etd_dy_cd",sheetObj.GetCellValue(headCnt,prefix+"etd_dy_cd"));
					sheetObj.SetCellValue(totCnt,prefix+"etd_tm_hrmnt",sheetObj.GetCellValue(headCnt,prefix+"etd_tm_hrmnt"));
				}else{
					ComShowCodeMessage("VSK00084");
					if(sheetObj.GetCellValue(headCnt,prefix+"port_cd") != sheetObj.GetCellValue(totCnt,prefix+"port_cd")){
						sheetObj.SelectCell(headCnt,prefix+"port_cd", true);
					}else if(sheetObj.GetCellValue(headCnt,prefix+"yd_cd") != sheetObj.GetCellValue(totCnt,prefix+"yd_cd")){
						sheetObj.SelectCell(headCnt,prefix+"yd_cd", true);
					//}else if(sheetObj.CellValue(headCnt,prefix+"etb_dy_cd") != sheetObj.CellValue(totCnt,prefix+"etb_dy_cd")){
					//	sheetObj.SelectCell(headCnt,prefix+"etb_dy_cd", true);
					}else if(sheetObj.GetCellValue(headCnt,prefix+"etb_tm_hrmnt") != sheetObj.GetCellValue(totCnt,prefix+"etb_tm_hrmnt")){
						sheetObj.SelectCell(headCnt,prefix+"etb_tm_hrmnt", true);
					}
					return false;
				}
			}
			/**************************************************************
			 * Handling flag for Sending Hidden Grid to Server 
			 **************************************************************/
//			sheetObjects[0].CellValue(1,"sheet1_ibflag") = "I";
			sheetObjects[0].SetRowStatus(1,"I");
			var otherDirTurnCnt=0;
			for(var i=headCnt; i<=totCnt; i++){
				if(sheetObj.GetCellValue(i,prefix+"skd_dir_cd") != firstDirCd){
					if(sheetObj.GetCellValue(i,prefix+"turn_port_flg") == "Y"){
				  	    if(i != totCnt){				  	    	
				  	    	otherDirTurnCnt++;
					    }
				    }
			    }			    
			    //Handling flag for Sending Hidden, Detail Grid to Server 
//			    sheetObj.CellValue(i,prefix+"ibflag") = "I"; 
			    sheetObj.SetRowStatus(i,"I");
		    }
		   for(var i=headCnt; i<=totCnt; i++){
			   if(sheetObj.GetCellValue(i, prefix+"turn_port_flg").length < 1){
					ComShowCodeMessage("VSK01018", "T/Port IND(N/Y)");
					sheetObj.SelectCell(i,prefix+"turn_port_flg");
					return false;
				}
			   var zd          = sheetObj.GetCellValue(i, prefix+"zd");
			   var portCd      = sheetObj.GetCellValue(i, prefix+"port_cd");
			   var etbDyNo     = sheetObj.GetCellValue(i, prefix+"etb_dy_no");
			   var etbTmHrmnt  = sheetObj.GetCellValue(i, prefix+"etb_tm_hrmnt");
			   var etdDyNo     = sheetObj.GetCellValue(i, prefix+"etd_dy_no");
			   var etdTmHrmnt  = sheetObj.GetCellValue(i, prefix+"etd_tm_hrmnt");
				// Checking ETB, ETD are input in order
				if ( (i < totCnt) && (etbDyNo+etbTmHrmnt)*1 >= (etdDyNo+etdTmHrmnt)*1 ) {
					sheetObj.SelectCell(i,prefix+"etb_dy_no");
					ComShowCodeMessage("VSK01018", "Seq : " +(i-headCnt+1)+ " (" +portCd+ ")ETB >= ETD");
					return false;
				}
				//::FOR.NYK.START::by DONGSOO:2014-09-17:://
				//:: apia, pago pago 간의 시간차이 계산하기 위해 zd정보 추가 
				//:: PORT CODE가 WSAPW, ASPPG간의 시간차이 
				// Checking PRE ETB, ETD are input in order
				if (i > headCnt) {
					var preZd           = sheetObj.GetCellValue(i-1, prefix+"zd");
					var PrePortCd       = sheetObj.GetCellValue(i-1, prefix+"port_cd");
					var preEtdDyNo      = sheetObj.GetCellValue(i-1, prefix+"etd_dy_no");
					var preEtdTmHrmnt   = sheetObj.GetCellValue(i-1, prefix+"etd_tm_hrmnt");
					if (sheetObj.GetCellValue(i-1, prefix+"port_cd") != "WSAPW" ||
							sheetObj.GetCellValue(i, prefix+"port_cd") != "ASPPG") {
						if ((preEtdDyNo + preEtdTmHrmnt)*1 >= (etbDyNo + etbTmHrmnt)*1) {
							sheetObj.SelectCell(i,prefix+"etb_dy_no");
							ComShowCodeMessage("VSK01018", "Seq : " +(i-headCnt+1)+ " ( " +PrePortCd+ ") Previous ETD >= (" +portCd+ ") Current ETB");
							return false;
						}
					} else {						
						//::FOR.NYK.START::by dongsoo:2014-10-07:://												
						formObj.vps_port_cd.value = sheetObj.GetCellValue(i, prefix+"port_cd");
						formObj.act_arr_dt.value  = ComGetDateAdd(null, "D", etbDyNo).replace(/-/g,"") + etbTmHrmnt;
						formObj.pre_port_cd.value = sheetObj.GetCellValue(i-1, prefix+"port_cd");
						formObj.pre_etd_dt.value  = VskGetAddedTimeByMin(ComGetDateAdd(null, "D", preEtdDyNo).replace(/-/g,"") + preEtdTmHrmnt, 60, true) ;
						if(!isPortTimeCheck(sheetObj, formObj)) {
							sheetObj.SelectCell(i,prefix+"etb_dy_no");
							ComShowCodeMessage("VSK01018", "Seq : " +(i-headCnt+1)+ " ( " +PrePortCd+ ") Previous ETD >= (" +portCd+ ") Current ETB");
							return false;
						}						
						//::FOR.NYK.FINISH::by dongso:2014-09-30:://
					}
				}
		   	}
		   
		    // Comparing inputed Duration and original Duration
			var dur1=Number(formObj.svc_dur_dys.value);
			var dur2=Number(sheetObj.GetCellValue(totCnt, prefix+"etb_dy_no")) - Number(sheetObj.GetCellValue(headCnt, prefix+"etb_dy_no"));
			if(dur1!=dur2){
				ComShowCodeMessage("VSK00096", "Duration or ETB No");
				return false;
			}
			break;
		case "Remove":      //DELETE
			var rowCnt=sheetObj.RowCount();
			var prefix=sheetObj.id + "_";
			if(rowCnt < 0){
				ComShowCodeMessage("VSK00043");
				return false;
			}
//			if(sheetObj.CellValue(1,"sheet1_ibflag") == "I"){
			if(sheetObj.GetRowStatus(1) == "I"){
				ComShowCodeMessage("VSK00043");
				return false;
			}
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus()
				return false;
			}
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				return false;
			}
		break;
		case "Remove02":      //Row Delete
			var rowCnt=sheetObj.RowCount();
			var prefix=sheetObj.id + "_";
		break;	
	}
    return true;
}
/**
 * Handling enter key
 */
function doSearch(){
	var formObject = document.form;

	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}


/**
 * after showing grid, setting color of last row
 */ 
function setlastLowView(sheetObj,rowPos){
//	//alert('setlastLowView-start');
	formObj = document.form;
	var rdInx=rowPos - 1;	
	var prefix="sheet2_";
	if(sheetObj.RowCount()> 0){
		//gray
		var grayColor="#F5F5F5";
		//white
		var withrColor="#FFFFFF";
		
		
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_dist",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_spd",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tztm_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_spd",0);

		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_in_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_out_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"act_wrk_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"port_buf_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ipcgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ipcgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ocn_cgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ocn_cgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tml_prod_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"crn_knt",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"turn_port_flg",0);
		
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_no",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_cd",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_tm_hrmnt",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_dist",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_spd",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tztm_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_spd",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"mnvr_out_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"act_wrk_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"port_buf_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ipcgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ipcgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ocn_cgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ocn_cgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tml_prod_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"crn_knt",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"turn_port_flg",grayColor);
		//sheetObjects[1].SetCellBackColor(rdInx,prefix+"mnvr_in_hrs",withrColor);


	}
}
/**
 * after showing grid, setting color of last row
 * @param sheetObj
 * @param formObj
 * @return
 */
function setlastLowViewUndo(sheetObj,rowPos){
	var rdInx=rowPos - 1;					
	var prefix="sheet2_";
	if(sheetObj.RowCount()> 0){
		//회색
		var grayColor="#F5F5F5";
		//흰색
		var withrColor="#FFFFFF";
		//검은색
		var blackColor="#000000";
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_dist",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_spd",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tztm_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_spd",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_in_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_out_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"act_wrk_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"port_buf_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ipcgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ipcgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ocn_cgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ocn_cgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tml_prod_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"crn_knt",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"turn_port_flg",1);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_no",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_cd",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_tm_hrmnt",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_dist",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_spd",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tztm_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_spd",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"mnvr_in_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"mnvr_out_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"act_wrk_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"port_buf_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ipcgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ipcgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ocn_cgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ocn_cgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tml_prod_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"crn_knt",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"turn_port_flg",blackColor);
		//sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;
	}
}
/**
 * Creating CLPT_SEQ in order
 * @param sheetObj
 * @return
 */
function resetRowSeq(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var prefix=sheetObj.id + "_";
	var idx=0;
	var vIbFlag="";
	for(var i=0; i<rowCnt; i++){
	//		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
	//			vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
	//			idx++;
	//			sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
	//			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
	//		}
	if(sheetObj.GetRowStatus(i+headCnt) != "D") {
		vIbFlag=sheetObj.GetRowStatus(i+headCnt);
			idx++;
			sheetObj.SetCellValue(i+headCnt, prefix+"row_seq",idx,0);
			sheetObj.SetRowStatus(i+headCnt,vIbFlag);
		}
	}
}
/**
 * Finding Last Row except Deleted Row
 * @param sheetObj
 * @return
 */
function searchLastRow(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var prefix=sheetObj.id + "_";
	var idx=0;
	var rtnIdx=0;
	var delCnt=0
	for(var i=totalCnt-1; i>headCnt-1; i--){
		if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
			idx=i;
			rtnIdx=idx+1;
			break;
		}
	}
	return rtnIdx;
}
/**
 * Hidden Manu In of First Row
 * if first row delete, Finding Manu In of one of Other row except delete
 * @param sheetObj
 * @return
 */
function searchFirstRow(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var rtnIdx=0;
	var prefix="sheet2_";
	var grayColor="#F5F5F5";
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
			idx=i;
			break;
		}
	}
	//sheetObj.SetCellEditable(idx, "sheet2_etb_dy_no",1);
	sheetObj.SetCellEditable(idx, "sheet2_etb_dy_cd",1);
	sheetObj.SetCellEditable(idx, "sheet2_etb_tm_hrmnt",1);
	sheetObj.SetCellEditable(idx, prefix+"mnvr_in_hrs",0);
	sheetObj.SetCellFontColor(idx,prefix+"mnvr_in_hrs",grayColor);
}
/**
 * Finding First Row except Deleted Row
 * @param sheetObj
 * @return
 */
function getSearchFirstRow(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var rtnIdx=0;
	var prefix="sheet2_";
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
			idx=i;
			break;
		}
	}
	return idx;
}
/**
 * Initializing except condition item
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearDescData(sheetObj1, sheetObj2, formObj){
	formObj.brth_itval_dys.value="";
	formObj.slan_stnd_flg.value="N";
	//formObj.n1st_vsl_clss_cd.value = "";
	comboObjects[0].SetSelectIndex(-1,false);
	formObj.n1st_vsl_clss_knt.value="";
	//formObj.n2nd_vsl_clss_cd.value = "";
	comboObjects[1].SetSelectIndex(-1,false);
	formObj.n2nd_vsl_clss_knt.value="";
	//formObj.n3rd_vsl_clss_cd.value = "";
	comboObjects[2].SetSelectIndex(-1,false);
	formObj.n3rd_vsl_clss_knt.value="";
	formObj.svc_dur_dys.value="";
	formObj.mml_usd_flg.value="N";
	formObj.upd_dt.value="";
	formObj.pf_skd_rmk.value="";
	//formObj.clpt_knt.value = "";
	formObj.tot_buf_rat.value="";
	//formObj.ttl_dist.value = "";
	formObj.sea_buf_rat.value="";
	formObj.max_spd.value="";
	formObj.port_buf_rat.value="";
	//formObj.avg_spd.value = "";
	formObj.pf_spd_rat.value="";
	//formObj.buf_spd.value = "";
	formObj.buf_spd_rat.value="";
	sheetObj1.RemoveAll();
	sheetObj1.DataInsert(-1);
	sheetObj2.RemoveAll();
	//All Check Initializing
	sheetObj2.CheckAll(sheetObj2.id+"_Sel",0);
}
/**
 * 
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
	if(sheetObj.RowCount()> 0){
		var colSaveName = sheetObj.ColSaveName(Col);
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix=sheetObj.id+"_";
        if(Row > 0 && (colSaveName == "sheet2_port_cd" || Col == "sheet2_etb_dy_no" || Col == "sheet2_etb_dy_cd" || Col == "sheet2_etb_tm_hrmnt")){
        	var checkWkTm=sheetObj.GetCellValue(Row, "sheet2_check_wk_tm");
        	if(checkWkTm == "Y"){
	        	var sText=sheetObj.GetCellText(Row,"sheet2_crane_wk_tm");
	        	if(sText != ""){
	        		sheetObj.SetToolTipText(Row, Col, sText.replace(/\n/g,"<br>") );
	        		sheetObj.SetMousePointer("Hand");
	        	}else{
	        		sheetObj.SetToolTipText(Row, Col, "");
	        		sheetObj.SetMousePointer("Default"); 
	        	}
        	}else{
        		sheetObj.SetToolTipText(Row, Col, "");
            	sheetObj.SetMousePointer("Default");
            }
        }
    }    
}
function getRowCount(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var rtnIdx=0;
	var prefix="sheet2_";
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
			idx++;
		}
	}
	return idx;
}
function setValCls(comboObj,val){
	var cnt=comboObj.GetItemCount();
	var comboPos=-1;
	for(var i=0; i<cnt; i++){
		if(comboObj.GetText(i,0) == val){
			comboPos=i;
			break;
		}
	}
	if(comboPos >= 0){
		comboObj.SetSelectIndex(comboPos,false);
	}else{
		comboObj.SetSelectIndex(-1,false);
	}
}
/**
 * Clearing Terminal Combo Data in sheet
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function setSheetClearCombo(sheetObj, Row, Col){
	sheetObj.CellComboItem(Row,sheetObj.id+"_yd_cd", {ComboText:"", ComboCode:""} );
}
function sheet2_OnAfterEdit(sheetObj, Row,Col){
	var formObj=document.form;
	formObj.max_spd.value="";
	formObj.sea_buf_rat.value="";
	formObj.pf_spd_rat.value="";
	formObj.tot_buf_rat.value="";
	formObj.port_buf_rat.value="";
	formObj.buf_spd_rat.value="";
}

/**
 * Checking ETB,ETD
 * @param sheetObj
 * @param formObj
 * @return
 */
function calcETBETD(valNo,valTime) {
	var tempValNo       = parseInt(valNo);
	var tempValTime     = valTime;
	var tempvalHrmnt    = tempValTime.length;
	var tempvalTimeVal  = 0;
	var tempvalHrmntVal = 0; 
		tempvalTimeVal  = tempValTime.substring(0,2);
		tempvalHrmntVal = tempValTime.substring(2,4);
		tempvalHrmntVal = tempvalHrmntVal/100;
	return Number(tempValNo * 24) + Number(tempvalTimeVal) + Number(tempvalHrmntVal);
}

/**
 * PORT TIME CHECK
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function isPortTimeCheck(sheetObj, formObj) {
		
	var sXml = doActionIBSheet(sheetObj, formObj, COMMAND23);
	
	var actStatus = ComGetEtcData(sXml, "actStatus");
	
	if(actStatus == "NORMAL"){  		
		return true;
	}else{    		
		return false;
	}
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i], 80);
    }
}