/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6010.js
*@FileTitle  : Waive Report by Office - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================
*/

/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
/**
 * @extends 
 * @class EES_DMT_6010 : business script for  EES_DMT_6010.
 */ 
    function EES_DMT_6010() {
        this.processButtonClick=processButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.doActionIBSheet=doActionIBSheet;
        this.validateForm=validateForm;
    }
    // Common Global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_close":
                	ComClosePopup(); 
                break;
                case "btn_down":
                	if(sheetObject1.RowCount() < 1){//no data
	            		ComShowCodeMessage("COM132501");
	            	}else{
	            		sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	            	}
                break;
                case "btn_bkg":
                	var sWidth  = "1200";
                	var sHeight =  "700";
                	
					document.form.bkg_no             .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "bkgno"  );
					document.form.cntr_no            .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "cntrno" );
					document.form.bl_no              .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "blno"   );
					document.form.dmdt_trf_cd        .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "tariff" );
					document.form.svr_id             .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "grpid"  );
					document.form.cntr_cyc_no        .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "cycno"  );
					document.form.dmdt_chg_loc_div_cd.value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "divcd"  );
					document.form.chg_seq            .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "chgseq" );
                    if(ComGetObjValue(document.form.role_permit) == 'Y') {
                    ComOpenPopupWithTarget('/opuscntr/EES_DMT_3002P.do?call_flag=P&bkg_no=' + document.form.bkg_no.value + '&bl_no='  + document.form.bl_no.value + '&dmdt_trf_cd=' + document.form.dmdt_trf_cd.value, sWidth, sHeight, "", "0,1,1,1,1,1,1", true);
                    } else {
                    ComOpenPopupWithTarget('/opuscntr/EES_DMT_3005P.do?call_flag=P&bkg_no=' + document.form.bkg_no.value + '&bl_no=' + document.form.bl_no.value + '&dmdt_trf_cd='+document.form.dmdt_trf_cd.value, sWidth, sHeight, "", "0,1,1,1,1,1,1", true);
                    }
                break;                
                case "btn_cntr":
                    var chkRow=sheetObjects[0].GetSelectRow();
					document.form.bkg_no             .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "bkgno"  );
					document.form.cntr_no            .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "cntrno" );
					document.form.bl_no              .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "blno"   );
					document.form.dmdt_trf_cd        .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "tariff" );
					document.form.svr_id             .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "grpid"  );
					document.form.cntr_cyc_no        .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "cycno"  );
					document.form.dmdt_chg_loc_div_cd.value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "divcd"  );
					document.form.chg_seq            .value=sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "chgseq" );
					
					var paramVal = "?call_flag=P";
					paramVal += "&cntr_no=" + document.form.cntr_no.value;
					paramVal += "&svr_id="              + document.form.svr_id.value;
					paramVal += "&cntr_cyc_no="         + document.form.cntr_cyc_no.value;
					paramVal += "&dmdt_chg_loc_div_cd=" + document.form.dmdt_chg_loc_div_cd.value;
					paramVal += "&chg_seq="             + document.form.chg_seq.value;
					paramVal += "&dmdt_trf_cd="         + document.form.dmdt_trf_cd.value;
					
					if (ComGetObjValue(document.form.role_permit) == 'Y' 
						&& sheetObjects[0].GetCellValue(chkRow , "ofcrhqcd") == ComGetObjValue(document.form.h_rhq_off)) {
			  			// Calculation 화면
			  			sUrl='EES_DMT_3003P.do' + paramVal;
	 		  			sWidth='1150';
		          		sHeight='700';							
                    } 
					else {
		  				// Inquiry 화면
		  				sUrl='EES_DMT_3006P.do' + paramVal;
	 		  			sWidth='1150';
		          		sHeight='700';	
                    }     
					ComOpenPopup(sUrl, sWidth, sHeight, "callbackProc", "0,1", true);
                break;  
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	ComOpenPopupWithTarget('/opuscntr/EES_DMT_3006.do?call_flag=P&cntr_no='+sheetObj.GetCellValue(Row,"cntrno"), 1020, 650, "", "0,1,1,1,1,1,1", true);
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
        ComConfigSheet (sheetObjects[0] );
        initSheet(sheetObjects[0],1);
        ComEndConfigSheet(sheetObjects[0]);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
            case "sheet1":
                with(sheetObj){
	              var HeadTitle1="Seq.|S/C No.|RFA No.|Customer|Customer|CTRT OFC|Tariff|STS|CNTR No.|T/S|DMT OFC|From YD|To YD|Fm|To|F/T|Over| ";
	              HeadTitle1 += "From Date|To Date|F/Time CMNC|F/Time End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Invoiced AMT|A/R|BKG No.|B/L No.|VVD CD|";
	              HeadTitle1 += "Lane|POR|POL|POD|DEL|R|D|INV No.|ISS DT|G/B|DAR APVL No.|Request|Request|Request|Approval|Approval|Approval|||||";
	              var HeadTitle2="Seq.|S/C No.|RFA No.|Code|Name|CTRT OFC|Tariff|STS|CNTR No.|T/S|DMT OFC|From YD|To YD|Fm|To|F/T|Over| ";
	              HeadTitle2 += "From Date|To Date|F/Time CMNC|F/Time End|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Invoiced AMT|A/R|BKG No.|B/L No.|VVD CD|";
	              HeadTitle2 += "Lane|POR|POL|POD|DEL|R|D|INV No.|ISS DT|G/B|DAR APVL No.|Date|Office|Name|Date|Office|Name|||||";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"},
	                              { Text:HeadTitle2, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"scno",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rfano",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"custcode",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"custname",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ctrtofc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tariff",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sts",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntrno",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"dmtofc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fromyard",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"toyard",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"too",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ft",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
	                     {Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"over",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
	                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"fromdate",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                     {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"todate",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ftcmnc",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ftend",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cur",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"incurred",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	                     {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"exceptionn",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dcamt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	                     {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"billable",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cur2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"invoiced",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ar",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkgno",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"blno",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lane",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"por",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"del",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"invno",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"issdt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"gb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:1,   SaveName:"darapprno",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"date1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"office1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"name1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"date2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"office2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"name2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"grpid",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cycno",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"chgseq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"divcd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofcrhqcd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetSheetHeight(555);
              }
            break;
        }
    }  
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      // Retrieve
                formObj.f_cmd.value=SEARCH;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                sheetObj.DoSearch("EES_DMT_6010GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                var rolePermit=sheetObj.GetEtcData("ROLE_PERMIT");
                var roleAuth=sheetObj.GetEtcData("ROLE_AUTH");
                ComSetObjValue(formObj.role_permit, rolePermit);
                ComSetObjValue(formObj.role_auth,   roleAuth);
            break;
        }
    }
    /**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    function sheet1_OnSearchEnd(sheetObj,  code, ErrMsg){
        with(sheetObj){
            if ( RowCount()> 0 ) {
                document.form.cntrqtybox         .value=ComAddComma(RowCount());
				document.form.bkg_no             .value=GetCellValue(2,"bkgno" );
				document.form.cntr_no            .value=GetCellValue(2,"cntrno");
				document.form.bl_no              .value=GetCellValue(2,"blno"  );
				document.form.dmdt_trf_cd        .value=GetCellValue(2,"tariff");
				document.form.svr_id             .value=GetCellValue(2,"grpid" );
				document.form.cntr_cyc_no        .value=GetCellValue(2,"cycno" );
				document.form.dmdt_chg_loc_div_cd.value=GetCellValue(2,"divcd" );
				document.form.chg_seq            .value=GetCellValue(2,"chgseq");
				
				if (GetCellValue(2,"scno") == "") {
                    SetColHidden("scno", 1);
				} 
				else if (GetCellValue(2,"rfano") == "") {
                    SetColHidden("rfano", 1);
                }
            } else {
                document.form.cntrqtybox.value=0;
            }
        }
    }
    function sheet1_OnClick(sheetObj, Row, Col, Value){
        with(sheetObj){
            if (RowCount() > 0) {
				document.form.bkg_no             .value=GetCellValue(Row,"bkgno" );
				document.form.cntr_no            .value=GetCellValue(Row,"cntrno");
				document.form.bl_no              .value=GetCellValue(Row,"blno"  );
				document.form.dmdt_trf_cd        .value=GetCellValue(Row,"tariff");
				document.form.svr_id             .value=GetCellValue(Row,"grpid" );
				document.form.cntr_cyc_no        .value=GetCellValue(Row,"cycno" );
				document.form.dmdt_chg_loc_div_cd.value=GetCellValue(Row,"divcd" );
				document.form.chg_seq            .value=GetCellValue(Row,"chgseq");
            }
        }
    } 
    /**
     * 팝업화면 종료시 호출되는 함수
     */  	
  	function callbackProc(rtnVal) {
  		// 삭제하면 스크립트 오류 발생됩니다.
  	}    