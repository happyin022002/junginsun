/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_pso_0018.js
*@FileTitle  : Requested Advance Payment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
	 * @extends
	 * @class vop_pso_0018 : business script for vop_pso_0018
	 */
    function vop_pso_0018() {
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
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /** **************************************************** */
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
	    		case "btns_calendar":
	    			openCalendar("ymd");
	    			break;
	    		case "btn_Close":
	    			ComClosePopup(); 
	    			break;
	    		case "btn_BankInformation":
	    			ComOpenPopup('VOP_PSO_0203.do?vndrSeq='+formObject.vndr_seq.value, 620, 300,'', '1,0,1,1,1,1,1,1', true, true);
	    			break;
	    		case "btn_DownExcel":
	    			/*
					 * if (sheetObject1.RowCount()<= 0) { // There is no
					 * related data! ComCodeMsgByNoRelatedData(); return; } else {
					 * if (sheetObject1.RowCount()> 0) {
					 * //sheetObject1.Down2Excel(1,true,true,true,"","",false,false,"Requested
					 * Advance Payment"); sheetObject1.Down2Excel( {DownCols:
					 * makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1
					 * }); } }
					 */
	    			f_DownExcel();
	    			break;
	    		case "btn_Confirm":
	    			if(!ComShowCodeConfirm("PSO00041", "confirm")){
	    				return;
	    			}
	    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
	    			break;
	    		case "btn_Reject":
	    			if(!ComShowCodeConfirm("PSO00041", "reject")){
	    				return;
	    			}
	    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
	    			break;
	    		case "btn_CreateCSR":
	    			// alert(srcName);
	// ComShowMessage("Under Construction!!!");
	    			break;
	    		case "btn_Print":
	    			// alert(srcName);
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
    function openCalendar(mode) {
		switch (mode) {
		case "ymd":
			var cal=new ComCalendar();
			cal.setDisplayType('date');
			cal.select(document.form.due_dt, "yyyy-MM-dd");
			break;
		default:
			break;
		}
	}
    /**
	 * registering IBSheet Object as list adding process for list in case of
	 * needing batch processing with other items defining list on the top of
	 * source
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * initializing sheet implementing onLoad event handler in body tag adding
	 * first-served functions after loading screen
	 */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
// for(i=0;i<sheetObjects.length;i++){
// doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
// }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
// sheetObjects[0].RowEditable(2) = true;
// sheetObjects[0].CellEditable(2, 6) = true;
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat('blur', 'obj_deactivate', form);
		axon_event.addListenerFormat('focus', 'obj_activate', form);
    }
	function obj_deactivate() {
		ComChkObjValid(event.srcElement);
	}
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
    function obj_keypress() {
		obj=event.srcElement;
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
		if (obj.dataformat == null)
			return;
		if (keyValue ==13) {
			// checking WorkMonth
			var formObject=document.form;
			if (formObject.revyrmon.value ==""
					|| formObject.revyrmon.value ==undefined) {
				ComShowCodeMessage("PSO00003", "Work Month");
				formObject.revyrmon.focus();
				return;
			}
			// Setting IBCOMBO value to vndr_seq parameter
			formObject.vndr_seq.value=comboObjects[0].GetSelectCode();
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			return true;
		}
		window.defaultStatus=obj.dataformat;
		switch (obj.dataformat) {
		case "ymd":
		case "ym":
		case "hms":
		case "hm":
		case "jumin":
		case "saupja":
			ComKeyOnlyNumber(obj);
			break;
		case "int":
			if (obj.name == "txtInt")
				ComKeyOnlyNumber(obj, "-")
			else
				ComKeyOnlyNumber(obj);
			break;
		case "float":
			ComKeyOnlyNumber(obj, "-.");
			break;
		case "eng":
			ComKeyOnlyAlphabet();
			break;
		case "engup":
			if (obj.name == "txtEngUp2")
				ComKeyOnlyAlphabet('uppernum')
			else if(obj.name=="vsl_slan_cd") 
				ComKeyOnlyAlphabet('uppernum');
			else
				ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
			if (obj.name == "txtEngDn2")
				ComKeyOnlyAlphabet('lowernum')
			else
				ComKeyOnlyAlphabet('lower');
			break;
		}
	}
    /**
	 * setting sheet initial values and header param : sheetObj, sheetNo adding
	 * case as numbers of counting sheets
	 */
     function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
    	 var sheetid=sheetObj.id;
    	 switch(sheetid) {
	    	 case "sheet1":
	    		    with(sheetObj){
	    	     
	    	      var HeadTitle1="|Seq.|COST CODE|ITEM|AMOUNT($)|Remark|Tariff Amount|Diff.|Formula|Formula Expression|Hidden1|Hidden2|Hidden3|h4|h5|h6|h7|h8|h9|h10|vvd|callSeq";
	    	      var headCount=ComCountHeadTitle(HeadTitle1);
	    	      var prefix="sheet1_"

	    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:1 } );

	    	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    	      InitHeaders(headers, info);

	    	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	    	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"lgs_cost_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lgs_cost_full_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rqst_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"calc_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"Diff",                    KeyField:0,   CalcLogic:"|sheet1_rqst_amt|-|sheet1_calc_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"dflt_xpr_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"sys_xpr_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_ver_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"suz_net_tong_wgt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_xch_rt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"tr_vol_val",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_pnm_capa",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_rgst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"call_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	    	       
	    	      InitColumns(cols);

	    	      SetEditable(1);
	    	      SetEllipsis(1);
	    	      SetSheetHeight(262);	    			 
//	    	      InitDataValid(0, prefix+"diff_rmk", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
	    	      SetColProperty(0 ,prefix+"diff_rmk", {AcceptKeys:"E|N|[.-/,() &]"});
	    	      }


	    		 break;
	    	 case "sheet2":
	    		    with(sheetObj){
	    			
	    	        SelectHighLight=false;
	    	      var HeadTitle1="AGENT BANK ACCOUNT DETAILS AS UNDER|AGENT BANK ACCOUNT DETAILS AS UNDER";
	    	      var headCount=ComCountHeadTitle(HeadTitle1);
	    	      // no support[check again]CLT
	    	      Rows=7;

	    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	    	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    	      InitHeaders(headers, info);

	    	      var cols = [ {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"key",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:1,   SaveName:"value",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	    	       
	    	      InitColumns(cols);
	    	      SetEditable(0);
	    	      SetCountPosition(0);
	    	      SetVisible(0);
	    	      SetSheetHeight(120);

	    	      }

	    		 break;
    	 }
     }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
          case IBSEARCH:      // Retrieving
            formObj.f_cmd.value=SEARCH;
           	if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					ComOpenWait(true);
					
					sheetObj.DoSearch("VOP_PSO_0018GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"), {Sync:2});
					// After Retrieving, Setting SCNT,SDR,TIER,
					// LimitedtimeSurcharge
					if (sheetObj.RowCount()> 0) {
						formObj.inv_no.value=sheetObj.GetCellValue(1,
								"sheet1_inv_no");
						formObj.scnt.value=sheetObj.GetCellValue(1, "sheet1_suz_net_tong_wgt");
						formObj.sdr.value=sheetObj.GetCellValue(1, "sheet1_locl_xch_rt");
						formObj.tier.value=sheetObj.GetCellValue(1,
								"sheet1_tr_vol_val");
						formObj.due_dt.value=sheetObj.GetCellValue(1,
								"sheet1_due_dt");
						formObj.cntr_pnm_capa.value=sheetObj.GetCellValue(1,
								"sheet1_cntr_pnm_capa");
						formObj.inv_rgst_no.value=sheetObj.GetCellValue(1,
								"sheet1_inv_rgst_no");
						formObj.due_dt.value=sheetObj.GetCellValue(1,
								"sheet1_due_dt");
// alert(sheetObj.CellValue(1,"sheet1_due_dt"));
						for ( var i=0; i < sheetObj.RowCount(); i++) {
							sheetObj.SetCellValue(i + 1, "sheet1_lgs_cost_cd",sheetObj.GetCellValue(i + 1, "sheet1_lgs_cost_cd").substring(0, 4),0);

						}
						f_SetBankInfo();
					}
					ComOpenWait(false);
				}
			}
			break;
          case IBSEARCH_ASYNC01: // Confirm btn click
          // sheetObj.ShowDebugMsg = true;
          	formObj.f_cmd.value=MULTI01;
          	if(validateForm(sheetObj,formObj,sAction)){
				if ( sheetObj.id == "sheet1"){
					// Updating due_dt from 1st record to due_dt from formObject
					sheetObj.SetCellValue(1,"sheet1_due_dt",formObj.due_dt.value,0);
					var SaveStr=ComGetSaveString(sheetObj, true, true);
					
					var sXml=sheetObj.GetSaveData("VOP_PSO_0018GS.do",SaveStr + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
					var etcVal=ComGetEtcData(sXml, "invoiceNo");
					if(etcVal==undefined || etcVal==null || etcVal==""){					
						sheetObj.LoadSaveData(sXml);
					} else{
						formObj.inv_no.value=etcVal;// Setting InvoiceNo
						ComShowCodeMessage("PSO01003");
						ComClosePopup(); 
						var opener=window.dialogArguments;
						opener.setAdvPyStatus("A", formObj.row.value, formObj.col.value, formObj.due_dt.value);						
					}
				}	
          	}
          	break;
          case IBSEARCH_ASYNC03: // Reject btn click
          // sheetObj.ShowDebugMsg = true;
          // formObj.f_cmd.value = COMMAND03; //[2010.05.11:jmh]
          formObj.f_cmd.value=MODIFY;			// [2010.05.11:jmh]
          if(validateForm(sheetObj,formObj,sAction)){
        	  if ( sheetObj.id == "sheet1"){
        		  var SaveStr=ComGetSaveString(sheetObj);       		  
        		  var sXml=sheetObj.GetSaveData("VOP_PSO_0018GS.do",SaveStr + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
        		  var etcVal=ComGetEtcData(sXml, "calcelResult");
        		  if(etcVal=="OK"){
        			  ComShowCodeMessage("PSO01002");
        			  ComClosePopup(); 
        			  var opener=window.dialogArguments;
        			  opener.setAdvPyStatus("R", formObj.row.value, formObj.col.value);
        		  }
        		  else
        			  ComShowMessage("failed to reject");
        		  // formObj.inv_no.value = etcVal;//Setting InvoiceNo
        	  }	
          }
          break;
        }
    }
    /**
	 * handling process for input validation
	 */
    function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction){
    	 case IBSEARCH_ASYNC01:
    		 if(!ComIsDate(formObj.due_dt.value)){
    			 ComShowMessage("Please Input correct Date");
    			 ComSetFocus(formObj.due_dt);
    			 return false;
    		 }
    		 break;
    	 }
        return true;
    }
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			for (var i=1; i <= LastRow(); i ++)
			{
if (GetCellValue(i, "Diff") > 0)
				
	SetCellFontColor(i, "Diff","#FF0000");// RED
else if (GetCellValue(i, "Diff") < 0)
				
	SetCellFontColor(i, "Diff","#0000FF");// BLUE
			}
			var row=LastRow();		
			SetSumText(0, "Seq","");		
			SetSumText(0, "sheet1_lgs_cost_full_nm","Advance Payment TTL Amount:");
			SetCellAlign(row, "sheet1_lgs_cost_full_nm","Right");			
			SetSumText(0, "Remark","Tariff TTL Amount ");
			SetCellAlign(row, "Remark","Right");
			// for Using Sum when Confirm
document.form.rqst_amt_sum.value=GetCellValue(row, "sheet1_rqst_amt");
document.form.calc_amt_sum.value=GetCellValue(row, "sheet1_calc_amt");
		}
	}
    function f_SetBankInfo(){
		
    	var sXml=sheetObjects[0].GetSearchData("VOP_PSO_0203GS.do", "vndrSeq=" + document.form.vndr_seq.value);
		var bankInfo=ComGetEtcData(sXml, "BANKINFO");
		// alert(bankInfo);
    	var data=bankInfo.split("@");
    	var arrHead=["To", "Favour", "Account Number", "Through", "Account Number", "Swift Code"];
    	for(var i=0; i<data.length; i++ ){
    		sheetObjects[1].DataInsert(-1);
    		sheetObjects[1].SetCellBackColor(i+1, "key",sheetObjects[1].GetHeaderBackColor());
    		sheetObjects[1].SetCellFont("FontBold", i+1, "key",sheetObjects[1].GetHeaderFontBold());
    		sheetObjects[1].SetCellFont("FontColor", i+1, "key",sheetObjects[1].HeadFontColor);
    		sheetObjects[1].SetCellValue(i+1, "key",arrHead[i],0);
    		sheetObjects[1].SetCellValue(i+1, "value",data[i],0);
    	}
    }
    function f_DownExcel(){
		var formObj=document.form;
		if(sheetObjects[0].RowCount()== 0){
			return;
		}
		var initRowCount=sheetObjects[0].RowCount();
		var paramObj=new Object();
		// paramObj.title = "Requested Advance Payment" + "\\n(" +
		// formObj.vvd2.value + ")";
		paramObj.title="Requested Advance Payment" + " (VVD : " + formObj.vvd2.value + ")";
		var url=ComJooGetPgmTitle(sheetObjects[0], paramObj);   
		if(initRowCount== 0){
			sheetObjects[0].DataInsert(-1);
		}
		sheetObjects[0].Down2ExcelBuffer(true);
		sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet1' });
		if(initRowCount== 0){
			sheetObjects[0].RowDelete(sheetObjects[0].HeaderRows(), false);
		}		
		sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 , FileName:'downexcel',SheetName:'sheet2'});
		sheetObjects[0].Down2ExcelBuffer(false);
    }
    function ComJooGetPgmTitle(sheetObj, paramObj){
    	var doc=document.all;
    	var pageUrl="FNS_JOO_EXCEL.do?";
    	var sTitle="";
    	var sTalign="center,left,right";
    	var sAlign="";
    	var sCols="";
    	var iCols=0;
    	var sOrientation="";
    	var sColumnwidth="";
    	var sDatarowheight="";
    	if(paramObj.title == undefined ){
    		sTitle=doc.title.innerHTML.replace("&nbsp;","");
    		sTitle=sTitle.replace("&amp;"," ");
    	}else{
    		sTitle=paramObj.title;
    	}
    	if(paramObj.align == undefined ){
    		sAlign="center"; 
    	}else if(sTalign.indexOf(paramObj.align) == -1 ){
    		sAlign="left";
    	}else{
    		sAlign=paramObj.align;
    	}
    	if(paramObj.cols == undefined ){
    		for(var i=0; i<= sheetObj.LastCol(); i++){
  if ( sheetObj.GetCellProperty(0, i, dpDataType)!= dtHidden
    					&& 
  sheetObj.GetCellProperty(0, i, dpDataType)!= dtHiddenStatus
    			){
    				iCols++;
    			}
    		}
    	}else{
    		iCols=eval(paramObj.cols);
    	}
    	if(paramObj.orientation == undefined ){
    		sOrientation="Landscape";
    	}else{
    		sOrientation=paramObj.orientation;
    	}
    	if(paramObj.columnwidth == undefined ){
    		sColumnwidth="";
    	}else{
    		sColumnwidth=paramObj.columnwidth;
    	}
    	if(paramObj.datarowheight == undefined ){
    		sDatarowheight="";
    	}else{
    		sDatarowheight=paramObj.datarowheight;
    	}        
    	var sUrl=pageUrl+"title="+sTitle+"&align="+sAlign+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
    	return sUrl;
    }     
