/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_MNR_0028.js
*@FileTitle  : M&R Repair Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0028 : EES_MNR_0028 - Defining a script used by screen
     */
    function EES_MNR_0028() {
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
		var tabObjects=new Array();
		var tabCnt=0 ;
		var beforetab=1;
		var sheetObjects=new Array();
		var sheetCnt=0;
		var comboObjects=new Array();
		var comboCnt=0;
		var msgFlag="";
		var tpmWoType="";
		// Define an event handler
		document.onclick=processButtonClick;
		//Executing process for event
		function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_calendar":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.fm_est_dt, formObject.to_est_dt, 'yyyy-MM-dd');
                	break;
				case "btn_Print":
					if(sheetObjects[1].RowCount()== 0){
						ComShowCodeMessage("MNR00310");
					} else {
						//Calling RD in case of existing
						if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != '' && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq") != ''){
							var mnr_ord_seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq");
							var mnr_ord_ofc_cty_cd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd");
							var user_nm=formObject.user_nm.value;
							var rdParam='/rv mnr_ord_ofc_cty_cd['+ mnr_ord_ofc_cty_cd +'] mnr_ord_seq[' + mnr_ord_seq + '] user_nm[' + user_nm + ']';
							if(wo_type.GetSelectCode()== 'SPL'){
								formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0183.mrd';
								formObject.com_mrdBodyTitle.value="Simple Work Order";
							} else if(wo_type.GetSelectCode()== "EXT"){
								formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0187.mrd';
								formObject.com_mrdBodyTitle.value="Extra Work Order";
							} else if(wo_type.GetSelectCode()== "RFS"){
								formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0231.mrd';
								formObject.com_mrdBodyTitle.value="Reefer Spare Part Work Order";
							} else {
								if(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_inp_tp_cd")!="N"&&sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_inp_tp_cd")!="S"){
									formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd';
									formObject.com_mrdBodyTitle.value="Repair Work Order";
								}else{
									ComShowCodeMessage("MNR00375");
									return;
								}
							}
							formObject.com_mrdArguments.value=rdParam;
							ComOpenRDPopup();
						} else {
							var eqno=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no");
							var seq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_seq");
							var verNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_ver_no");
							formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0181.mrd';
							var rdParam='/rv rqst_eq_no[' + eqno + '] rpr_rqst_seq[' + seq + '] rpr_rqst_ver_no[' + verNo + '] is_tpb[N]';
							formObject.com_mrdArguments.value=rdParam;
							formObject.com_mrdBodyTitle.value="Repair Estimate";
							ComOpenRDPopup();
						}
					}
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;
				case "btn_DownExcel":
					if(sheetObjects[1].RowCount() < 1){//no data
		        		ComShowCodeMessage("COM132501");
		        	}else{
		        		sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
		        	}
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					break;
				case "btn_Detail":
					if(sheetObjects[1].RowCount()== 0){
						ComShowCodeMessage("MNR00309");
					} else {
						//Calling pop-up of estimate
						if(wo_type.GetSelectCode()== 'EST'){
							if(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_inp_tp_cd")!="N"&&sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_inp_tp_cd")!="S"){
								if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no")) != ''){
									var rqstEqNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rqst_eq_no");
									var rprRqstSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_seq");
									var rprRqstVerNo=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"rpr_rqst_ver_no");
									var eqKndCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"eq_knd_cd");
									
									var paramOption = "rqst_eq_no="+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd;
									ComOpenPopup("/opuscntr/EES_MNR_0192.do?" + paramOption, 1024, 768, "nonCallBack", "1,0,1,1,1", true);
								}
							}else{
								ComShowCodeMessage("MNR00375");
								return;
							}
						} else {
							//Calling pop-up of work order
							var mnrOrdOfcCtyCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd");
							var mnrOrdSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq");
							var costOfcCd=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"cost_ofc_cd");
							retArray=MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);
							if(retArray == null){
								ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);
								return;
							}
							if(wo_type.GetSelectCode()== 'SPL'){
								if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != ''
									&& MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq")) != ''){
									ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 670, '', '0,0', true);
								}
							} else if(wo_type.GetSelectCode()== 'EXT'){
								if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != ''
									&& MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq")) != ''){
									ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 530, '', '0,0', true);
								}
							} else if(wo_type.GetSelectCode()== 'RFS'){
								if(MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_ofc_cty_cd")) != ''
									&& MnrNullToBlank(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"mnr_ord_seq")) != ''){
									ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 500, '', '0,0', true);
								}
							}
						}
					}
					break;
				//in case of multi input data 1
				case "eq_no_multi1":
					rep_Multiful_inquiry("rqst_eq_no");
					break;
				//in case of multi input data 2
				case "eq_no_multi2":
					if(wo_type.GetSelectCode()== 'EST'){
						rep_Multiful_inquiry("rqst_ref_no");
					}
					break;
				//in case of multi input data 3
				case "eq_no_multi3":
				    rep_Multiful_inquiry("wo_no");
					break;
				case "btn_vndr":
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 555, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				case "btn_close":
					ComClosePopup();
					//ComClosePopupModal();
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
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }
		for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
		//**************** Initializing work by condition ***************/
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		if(ComGetObjValue(formObj.from_sys) == "MST" || ComGetObjValue(formObj.from_sys) == "CGM"){
			wo_type.SetSelectCode("EST");
			if(ComGetObjValue(formObj.from_sys) == "MST"){
				status_cd.SetSelectCode("WC");
			}
			ComSetObjValue(formObj.rqst_eq_no,formObj.eq_no.value);
			formObj.fm_est_dt.value="";
			formObj.to_est_dt.value="";
			doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
		}
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
        switch(sheetObj.id) {
			case "sheet1":
                with (sheetObj) {
                    sheetObj.SetVisible(false);
				}
                break;
            case "sheet2":      // sheet1 init
                with(sheetObj){
              var HeadTitle1="|Seq.|Estimate No|Service Provider|EQ No.|T/S|Cost Code|Cost Code Name|Est Date|Curr.|Est Amount|System Verify Result|DMG Flag|TPB|W/O No.|W/O Issue DT|W/O Send Method|W/O Send DT|W/O Amount|VVD|Yard|Invoice No|Invoice Amount|Status|C.OFC|Creation User|Remark(s)|Issue From";
              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tmp_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"rqst_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"rqst_eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_cd",             KeyField:0,   CalcLogic:"",   Format:"",             PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cost_cd_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"est_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"total_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"wo_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"iss_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"trsm_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"mnr_ord_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     
                     {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"mnr_wrk_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"spr_prt_spl_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"status",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"cost_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ord_hdr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"mnr_inp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_ver_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_ord_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_ord_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
               
              InitColumns(cols);
              var info = {ComboText:"OPUS|NEW PORT|SEA ONLINE", ComboCode:"|N|S"};
              SetColProperty(0, "mnr_inp_tp_cd", info);
//              SetSheetHeight(380);
              SetEditable(1);
              resizeSheet( sheetObj );
                    }


         		break;
        }
    }
    //Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var formObj=document.form;
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:      //Retrieving list
                 if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value=SEARCH;
						if(formObj.temp_tpb_only.checked){
							formObj.tpb_only.value="Y";
						} else {
							formObj.tpb_only.value="N";
						}
						
						if(formObj.temp_new_port_only.checked){
							formObj.new_port_only.value="Y";
						} else {
							formObj.new_port_only.value="N";
						}
						
						if(formObj.temp_sol_only.checked){
							formObj.sol_only.value="Y";
						} else {
							formObj.sol_only.value="N";
						}
						
						var sParam=FormQueryString(formObj);
						//ComDebug(sParam);
						sheetObj.DoSearch("EES_MNR_0028GS.do",sParam );
				  }
                break;
			case IBSEARCH_ASYNC01:	//Retrieving(sevice provider No. at inserting)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					//Retrieving service provider
					var sCondition=new Array (
						new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
					)
					//Setting when returned data exist
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
					if(comboList[0] != null){
						var tempText=comboList[0][0].split("|");
						formObj.vndr_nm.value=tempText[1];
					} else {
						ComShowCodeMessage("MNR00005", "Service Provider");
						ComSetObjValue(formObj.vndr_nm, "");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}
				}
				break;
			case IBCLEAR:      // Initializing
				MnrWaitControl(true);
				sheetObj.SetWaitImageVisible(0);
				//START
				formObj.reset();
				//Initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].SetSelectCode("-1");
					comboObjects[i].RemoveAll();
				}
				var sCondition=new Array (
					//MultiCombo
					new Array("MnrGenCd","CD00020", "COMMON"),
					new Array("MnrGenCd","","CUSTOM9"),
					//combo of sheet
					new Array("MnrGenCd","CD00028", "COMMON"),
					new Array("MnrGenCd","CD00004", "COMMON"),
					new Array("MnrGenCd","CD00016", "COMMON")
				)
				var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
				//*** W/O Type
				var comboObj = wo_type;
				var comboDefValue="";
				if(comboList[0] != null){
					for(var j=0; j < comboList[0].length;j++){
						var tempText=comboList[0][j].split("|");
						wo_type.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){
							comboDefValue=tempText[0];
						}
					}
				}
				wo_type.SetSelectCode(comboDefValue);
				//*** EQ_TYPE
				if(comboList[1] != null){
					eq_knd_cd.InsertItem(0, 'ALL' ,'A');
					for(var j=1; j < comboList[1].length + 1;j++){
						var tempText=comboList[1][j - 1].split("|");
						eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				var defEqType=formObj.default_eq_type.value;
				defEqType=MnrNullToBlank(defEqType);
				if(defEqType != ""){
					eq_knd_cd.SetSelectCode(defEqType);
				} else {
					eq_knd_cd.SetSelectCode('A');
				}
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault=new Array();
				var comboSaveNames=new Array();
				comboSaveNames[0]="status";
				comboSaveNames[1]="mnr_vrfy_tp_cd";
				comboSaveNames[2]="trsm_mod_cd";
				for(var i=2; i < comboList.length;i++){
				 	if(comboList[i] != null){
						sheetComboText="";
						sheetComboCode="";
						sheetComboDefault="";
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							if(j == 0){
								sheetComboDefault[i - 2]=tempText[0];
							}
						}
						sheetComboCode=MnrDelLastDelim(sheetComboCode);
				     	sheetComboText=MnrDelLastDelim(sheetComboText);
						sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 2], sheetComboText, sheetComboCode ,sheetComboDefault[i - 2]);
					}
				}
				formObj.cost_ofc_cd.value=selfOfcCd;
				formObj.fm_est_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7);
				formObj.to_est_dt.value=ComGetNowInfo("ymd");
				//END
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
                break;
                
			case IBSEARCH_ASYNC02:	//retrieving(in case of changing EQ Type)
				sheetObj.SetWaitImageVisible(0);
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//Cost Code						
					cost_cd.RemoveAll();
					var sCondition=new Array ( 		 
						new Array("MnrGenCd",eq_knd_cd.GetSelectCode()+ "G", "COMMON")
					)  	                           
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
					cost_cd.InsertItem(0,"ALL| |ALL","A");		  
					if(comboList[0] != null){
						for(var j=0; j < comboList[0].length;j++){  
							var tempText=comboList[0][j].split("|");  
							var tempTxt = tempText[0]+"-"+tempText[1];
							cost_cd.InsertItem(j + 1,tempText[0]+"|"+tempText[1]+"|"+tempTxt,tempText[0]);
						} 			      
					}		
				    cost_cd.SetSelectCode("A");
				}		
				sheetObj.SetWaitImageVisible(1);
				break;
        }
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
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form;
	    var objCb = comboObj.options;
	    switch(objCb.id) {
	    	case "cost_cd":
				with (comboObj) { 
		    		SetMultiSeparator("|");
					SetTitle("Code|Name");	
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "65");
					SetColWidth(1, "135");
					SetDropHeight(160);
					SetUseAutoComplete(1);
					SetTitleVisible(true);
					}
	            	break;
			   default :
		           with (comboObj) {
				   SetColAlign(0, "left");
					   SetDropHeight(200);
			       }
	           		break;
	     }
	}
    /**
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                }
             break;
         }
    }
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=ComLpad(aryPopupData[0][2],6,"0");
			formObj.vndr_nm.value=aryPopupData[0][4];
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
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var formObj=document.form;
		if(wo_type.GetSelectCode()== 'EST'){
			if(!formObject.temp_new_port_only.checked){
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"rqst_eq_no")) != ''){
					//Calling pop-up when existed data
					var rqstEqNo=sheetObjects[1].GetCellValue(Row,"rqst_eq_no");
					var rprRqstSeq=sheetObjects[1].GetCellValue(Row,"rpr_rqst_seq");
					var rprRqstVerNo=sheetObjects[1].GetCellValue(Row,"rpr_rqst_ver_no");
					var eqKndCd=sheetObjects[1].GetCellValue(Row,"eq_knd_cd");
					
					var paramOption = "rqst_eq_no="+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd;
					ComOpenPopup("EES_MNR_0192.do?" + paramOption, 1024, 768, "", "1,0,1,1,1,1,1,1,1,1,1,1", true);
				}
			}
		} else {
			//work order Calling pop-up screen
			var mnrOrdOfcCtyCd=sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd");
			var mnrOrdSeq=sheetObjects[1].GetCellValue(Row,"mnr_ord_seq");
			retArray=MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);
			if(retArray == null){
				ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);
				return;
			}
			if(wo_type.GetSelectCode()== 'SPL'){
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 670, '', '0,0', true);
				}
			}else if(wo_type.GetSelectCode()== 'EXT'){
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 530, '', '0,0', true);
				}
			}else if(wo_type.GetSelectCode()== 'RFS'){
				if(MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].GetCellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 500, '', '0,0', true);
				}
			}
		}
	}
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(msgFlag == "Cancel"){
				ComShowCodeMessage("MNR00104");
			} else {
				ComShowCodeMessage("MNR00105");
			}
		}
	}
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- Important logic --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSEARCH:
					if (!ComChkValid(formObj)) return false;
					var inputDateBet=ComGetDaysBetween(formObj.fm_est_dt.value, formObj.to_est_dt.value)
					if(inputDateBet > 30){
						ComShowCodeMessage("MNR00335");
						formObj.fm_est_dt.value=ComGetDateAdd(formObj.to_est_dt.value, "D", -30);
						return false;
					}
					var chkEstDt=0;
					var chkEqNo=0;
					var chkWoNo=0;
					var chkRefNo=0;
					if(ComGetObjValue(formObj.fm_est_dt) != "" && ComGetObjValue(formObj.to_est_dt) != ""){
						chkEstDt++;
					}
					if(ComGetObjValue(formObj.rqst_eq_no) != ""){
						chkEqNo++;
					}
					if(ComGetObjValue(formObj.wo_no) != ""){
						chkWoNo++;
					}
					if(ComGetObjValue(formObj.rqst_ref_no) != ""){
						chkRefNo++;
					}
					if((chkEstDt + chkEqNo + chkWoNo + chkRefNo) == 0){
						ComShowCodeMessage("MNR00264");
						return false;
					}
					var arrWoNo=formObj.wo_no.value.split(",");
					if(arrWoNo!=""){
						for(i=0;i<arrWoNo.length;i++){
							if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
								ComShowCodeMessage("MNR00010","W/O No");
								return false;
							}
						}
					}
				 	break;
			}
		}
        return true;
    }
    /**
	* Resetting combo data
	*/
	function resetStatusCdCombo(type,formObj){
		var comboObj = wo_type;
		var formObj=document.form;
		sheetObjects[1].RemoveAll();
		status_cd.SetDropHeight(200);
		var sCondition=new Array (
			new Array("MnrGenCd","CD00028", "COMMON")
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		if(comboList[0] != null){
			status_cd.RemoveAll();
			status_cd.InsertItem(0,"ALL","ALL");
			if(type == "EST"){
				for(var j=0; j < comboList[0].length;j++){
					var tempText=comboList[0][j].split("|");
					status_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
				}
			} else {
				var tempCnt=1;
				for(var j=0; j < comboList[0].length;j++){
					var tempText=comboList[0][j].split("|");
					if(tempText[0].substring(0,1) != 'H'){
						status_cd.InsertItem(tempCnt, tempText[1] ,tempText[0]);
						tempCnt++;
					}
				}
			}
			status_cd.SetSelectCode("ALL");
		}
	}
	/**
	* wo_type Event handling of combo
	*/
	function wo_type_OnChange(oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var comboObj = wo_type;
		var formObj=document.form;
		sheetObjects[1].RemoveAll();
		resetStatusCdCombo(comboObj.GetSelectCode(),formObj);
		if(comboObj.GetSelectCode()== 'EST'){
			//sheetObjects[1].ReturnColumn();
			sheetObjects[1].SetColHidden("rqst_eq_no",0);
			sheetObjects[1].SetColHidden("eq_tpsz_cd",0);
			sheetObjects[1].SetColHidden("est_dt",0);
			sheetObjects[1].SetColHidden("rqst_ref_no",0);
			sheetObjects[1].SetColHidden("curr_cd",0);
			sheetObjects[1].SetColHidden("total_amt",0);
			sheetObjects[1].SetColHidden("mnr_vrfy_tp_cd",0);
			sheetObjects[1].SetColHidden("dmg_flag",0);
			sheetObjects[1].SetColHidden("n3pty_flg",0);
			sheetObjects[1].SetColHidden("mnr_wrk_amt",1);
			sheetObjects[1].SetColHidden("vvd",1);
			sheetObjects[1].SetColHidden("spr_prt_spl_yd_cd",1);
//			sheetObjects[1].SetColHidden("cost_cd_nm",1);
			ComSetObjValue(formObj.rqst_ref_no,"");
//			sheetObjects[1].InitCellProperty(0, "cost_cd", {ColMerge:0});
			MnrFormSetReadOnly(formObj,false,"rqst_ref_no");
			sheetObjects[1].MoveColumnPos("wo_no", 14);
//			if(formObj.temp_new_port_only.checked){
//				ComBtnDisable("btn_Detail");
//				ComBtnDisable("btn_Print");
//			}else{
//				ComBtnEnable("btn_Detail");
//				ComBtnEnable("btn_Print");
//			}
		} else {
			sheetObjects[1].SetColHidden("rqst_eq_no",1);
			sheetObjects[1].SetColHidden("eq_tpsz_cd",1);
			sheetObjects[1].SetColHidden("est_dt",1);
			sheetObjects[1].SetColHidden("rqst_ref_no",1);
			sheetObjects[1].SetColHidden("total_amt",1);
			sheetObjects[1].SetColHidden("mnr_vrfy_tp_cd",1);
			sheetObjects[1].SetColHidden("dmg_flag",1);
			sheetObjects[1].SetColHidden("n3pty_flg",1);
			sheetObjects[1].SetColHidden("mnr_wrk_amt",0);
			if(comboObj.GetSelectCode()== 'RFS'){
				sheetObjects[1].SetColHidden("vvd",0);
				sheetObjects[1].SetColHidden("spr_prt_spl_yd_cd",0);
			} else {
				sheetObjects[1].SetColHidden("vvd",1);
				sheetObjects[1].SetColHidden("spr_prt_spl_yd_cd",1);
			}
//			if(comboObj.GetSelectCode()== 'SPL' || comboObj.GetSelectCode()== 'EXT'){
//				sheetObjects[1].SetColHidden("cost_cd_nm",0);
//			} else {
//				sheetObjects[1].SetColHidden("cost_cd_nm",1);
//			}
			ComSetObjValue(formObj.rqst_ref_no,"");
			MnrFormSetReadOnly(formObj,true,"rqst_ref_no");
			if(tpmWoType == 'SPL' && comboObj.GetSelectCode()== 'EXT'){
			}else if(tpmWoType == 'EXT' && comboObj.GetSelectCode()== 'SPL'){
			}else{
				sheetObjects[1].MoveColumnPos("curr_cd", "total_amt");
			}
			sheetObjects[1].MoveColumnPos("wo_no", 2);
			ComBtnEnable("btn_Detail");
			ComBtnEnable("btn_Print");
		}
		tpmWoType=comboObj.GetSelectCode();
	}
	function initControl() {
	    //Axon event handling 1. Catching event
		var formObject=document.form;
	 //   axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
	 //   axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
		axon_event.addListenerFormat('change',	 'obj_change',		formObject);
		axon_event.addListener('click',  'newport_only_onclcik', 'temp_new_port_only');
	}
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value,6,"0");
	        		doActionIBSheet(sheetObj, formObj ,IBSEARCH_ASYNC01);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
					ComSetObjValue(formObj.vndr_nm,"")
				   	break;
			}
		}
	}
	
	function eq_knd_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){ 
    	//setting Cost Cd combo
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
    }
	
//	function newport_only_onclcik(){
//		var formObj=document.form;
//		if(formObj.temp_new_port_only.checked){
//			//Initializing sheet
//			sheetObjects[1].RemoveAll();
//			
//			if(wo_type.GetSelectCode() == "EST"){
//				//Initializing button
//				ComBtnDisable("btn_Detail");
//				ComBtnDisable("btn_Print");
//			}else{
//				ComBtnEnable("btn_Detail");
//				ComBtnEnable("btn_Print");
//			}
//		} else {
//			//Initializing sheet
//			sheetObjects[1].RemoveAll();
//
//			//Initializing button
//			ComBtnEnable("btn_Detail");
//			ComBtnEnable("btn_Print");
//		}
//	}
	
	
//	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "ymd":
//	        case "int":
//				ComKeyOnlyNumber(obj);
//	            break;
//	        case "float":
//	            ComKeyOnlyNumber(obj, "-.");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//				break;
//	        case "engup":
//				if(obj.name == "vndr_seq"){
//					ComKeyOnlyAlphabet('uppernum');
//				} else {
//					ComKeyOnlyAlphabet('uppernum','44');
//				}
//	            break;
//	    }
//	}
	/* End of developer's task */
