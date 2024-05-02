/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0153.js
*@FileTitle  : Process Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
 // Event handler processing by button click event */
    document.onclick=processButtonClick;
 // Event handler processing by button name */
    function processButtonClick(){
    	 var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve": // retrieving after save
    				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    				break;
    			case "btng_downexcel":
    				if(sheetObjects[0].RowCount() < 1){//no data
    					ComShowCodeMessage("COM132501");
    				}else{
    					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
    				}
    				break;
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    		    ComShowMessage(getMsg("COM12111"));
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
        function setSheetObject(sheet_obj){
    		sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
        	optionSetting();
            for(var i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            var sheetResizeFull=true;
           	setYearMonthObject(formObj.year, formObj.quarter);
            changeTrade();
            changeStepSts();
            document.form.year.focus();
        }

    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
    		case 1:      //sheet1 init
    		    with(sheetObj){
	    	      var HeadTitle="";
	    	      formObj=document.form;
	    	      if(formObj.grp[0].checked){
	    	    	  HeadTitle="Stage|Seq|Step|Status|Target Group|Trade|Bound|Org.|Version|Last Update|gline_ver_no|saq_sts_cd|bse_yr|rep_mon|mqta_ver_no";
	    	      }else{
	    	    	  HeadTitle="Stage|Seq|Step|Status|Org.|Target Group|Trade|Bound|Version|Last Update|gline_ver_no|saq_sts_cd|bse_yr|rep_mon|mqta_ver_no";
	    	      }
	    	      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
	    	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	      InitHeaders(headers, info);
	    	      var cols = [ {Type:"Text",      Hidden:0,  Width:100,                            Align:"Center",  ColMerge:1,   SaveName:"STAGE",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:30,                             Align:"Center",  ColMerge:1,   SaveName:"SEQ",          KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:240,                            Align:"Left",    ColMerge:1,   SaveName:"STEP",         KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:80,                             Align:"Center",  ColMerge:1,   SaveName:"GRP_STATUS",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:(formObj.grp[0].checked?80:120),Align:"Center",  ColMerge:1,   SaveName:"FILTER1",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:70,                             Align:"Center",  ColMerge:1,   SaveName:"FILTER2",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:70,                             Align:"Center",  ColMerge:1,   SaveName:"FILTER3",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:(formObj.grp[0].checked?100:70),Align:"Center",  ColMerge:1,   SaveName:"FILTER4",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:160,                            Align:"Center",  ColMerge:1,   SaveName:"VERSION",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:0,  Width:90,                             Align:"Center",  ColMerge:1,   SaveName:"UPD_DT",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:1,  Width:70,                             Align:"Center",  ColMerge:1,   SaveName:"BSE_YR",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:1,  Width:70,                             Align:"Center",  ColMerge:1,   SaveName:"REP_MON",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:1,  Width:70,                             Align:"Center",  ColMerge:1,   SaveName:"MQTA_VER_NO",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	    	                   {Type:"Text",      Hidden:1,  Width:70,                             Align:"Center",  ColMerge:1,   SaveName:"STATUS",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 } ];

	    	      InitColumns(cols);
	    	      SetEditable(0);
//	    	      SetSheetHeight(510);
	    	      resizeSheet();
	    	      SetFocusEditMode(default_edit_mode);
	    	      SetHeaderRowHeight(25);
    	      }
    		  break;
    	}
    }
    
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
 // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	switch(sAction) {
    		case IBSEARCH:
    			//sheetObj.Reset();
//    			initSheet(sheetObjects[0],1);
    			sheetObj.SetWaitImageVisible(0);
    			ComOpenWait(true);
    			formObj.f_cmd.value=SEARCHLIST;
    			if(formObj.grp[0].checked){
    				formObj.grp_flg.value="1";
    			}else{
    				formObj.grp_flg.value="2";
    			}
    			sheetObjects[0] = sheetObj.Reset();
    			initSheet(sheetObjects[0] , 1);
//    			sheetObj.DoSearch("ESM_SAQ_0153GS.do", saqFormString(formObj) );
    			 var sXml = sheetObjects[0].GetSearchData("ESM_SAQ_0153GS.do ", saqFormString(formObj));
                 if (sXml != "") sheetObjects[0].LoadSearchData(sXml, {Sync:1});

    			if(ComGetEtcData(sXml, "status") == "OK"){
    					retrieved=true;
    			}
    			break;
    		case IBDOWNEXCEL:  // excel download
    			selectDownExcelMethod(sheetObj);
    			break;
    	}
    }

    /**
     * Down Excel 팝업창 이후 값을 받아서 타입을 리턴함
     *
     * excelType
	 * AY - 전체 데이터를 Format 적용해서 down 받는 경우
	 * DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
	 * AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
	 * DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
     */
   	function callBackExcelMethod(excelType){
		var sheetObj = sheetObjects[0];
		DownExcel(sheetObj, excelType);
	}

    function year_onChange(){
    	changeTrade();
    }
    function quarter_onChange(){
    	changeTrade();
    }
    function trd_cd_onChange(){
    	changeBound();
    }
    function grp_onChange(){
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    function changeTrade(){
    		var params="year="+document.form.year.value+"&quarter="+document.form.quarter.value;
    		getSelectCodeList(document.form.trd_cd, "MonthlyQtaStatusInquiryTrade", params);
    		changeBound();
    }
    function changeBound(){
    		var params="year="+document.form.year.value+"&quarter="+document.form.quarter.value+ "&trd_cd="+document.form.trd_cd.value;
    		getSelectCodeList(document.form.dir_cd, "MonthlyQtaStatusInquiryBound", params);
    }
    function changeStepSts(){
    		var params="year="+document.form.year.value+"&quarter="+document.form.quarter.value+ "&trd_cd="+document.form.trd_cd.value;
    		getSelectCodeList(document.form.step, "MonthlyQtaStatusInquiryStep", params);
    		getSelectCodeList(document.form.sts, "MonthlyQtaStatusInquirySts", "");
    }
    function optionSetting() {
		SaqSearchOptionYear("year");
		SaqSearchOptionQuarter("quarter");
    }

    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    	ComOpenWait(false);
    }