/* 
 * Common Global Variables
 */
var sheetObjects = new Array();
var sheetCnt = 0;
var currentRow = 0;

/* 
 * RD
 */
var rdObjects = new Array();
var rdCnt = 0;

/* 
 * Event handler processing by button click event 
 */
document.onclick = processButtonClick;

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
	    //Changing Start Environment Setting Method's Name
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	    
	    //Adding Last Environment Setting method
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// Setting FROM ~ TO Date	
	var formObj = document.form;
	var today = ComGetNowInfo();
	var frday = ComGetDateAdd(null, "D", -7);
	formObj.search_dt_fr.value = frday;
	formObj.search_dt_to.value = today;
	formObj.inv_dt.value = today;
	formObj.ar_ofc_cd.focus();

	// Setting Buttons deactive
	//doActionBtnEnable('-1');
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				//setting height
				style.height = GetSheetHeight(10);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msHeaderOnly;

			   	//Edit kind [Optional, Default false]
				Editable = true;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(23, 3, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;
			
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Status|No.|CHK|Audit No|Invoice No|Subj.OFC|VVD Cnt|Cur|Net AMT|VAT|TTL AMT|CSR No|I/F Date|I/F Remark|RCV Remark|IF Flag|RCV Flag|Pay AMT|Pay Date|Check No|Method|Status Code|inv_rgst_no";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtSeq,      30,    daCenter,  true,     "seq",    false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtCheckBox, 40,    daCenter,  true,     "chk",    false,    "",         dfNone,     0,          true,        false);
				InitDataProperty(0, cnt++, dtData,     90,    daCenter,  true,     "comm_apro_no", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     90,    daCenter,  true,     "inv_no",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     60,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     60,    daCenter,  true,     "vvd_cnt", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,     "curr_cd",   false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     70,    daRight,   true,     "net_amt", false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     50,    daRight,   true,     "vat",    false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     70,    daRight,   true,     "tot_amt", false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     140,   daCenter,  true,     "csr_no",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     80,    daCenter,  true,     "ac_if_dt",   false,    "",         dfDateYmd,  0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     400,   daLeft,    true,     "if_flg_msg",  false,    "",         dfNone,     0,          false,        false);
				InitDataProperty(0, cnt++, dtData,     400,   daLeft,    true,     "rcv_err_flg_msg", false,    "",         dfNone,     0,          false,        false);
				InitDataProperty(0, cnt++, dtHidden,   50,    daLeft,    true,     "if_flg",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtHidden,   50,    daLeft,    true,     "rcv_err_flg", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daRight,   true,     "pay_amt", false,    "",         dfFloat,    2,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daCenter,  true,     "pay_dt",  false,    "",         dfDateYmd,  0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daLeft,    true,     "ftu_use_ctnt1",false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,     100,   daLeft,    true,     "pay_mzd_lu_cd", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"status_cd", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,true,	"inv_rgst_no", false,    "",         dfNone,     0,          false,       false);
				CountPosition = 0;
			}
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
				//setting height
				style.height = GetSheetHeight(10);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msPrevColumnMerge;
				
			   	//Edit kind [Optional, Default false]
				Editable = true;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "VVD|BL NO|BKG NO|AGN CD|TYPE|AR OFC|AP OFC|BKG STS|I/F AMT";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  true,     "vvd",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  true,     "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
				//InitDataProperty(0, cnt++, dtHidden,  70,    daCenter,  false,    "seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  false,    "tp",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "ar_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "ap_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "bkg_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   false,    "if_amt",  false,    "",         dfFloat,    2,          false,      false);
				CountPosition = 0;
			}
			break;
			
		case 3:     	//sheet3 init
            with (sheetObj) {
                //setting height
                style.height = GetSheetHeight(3);
                
                //Whole setting width
                SheetWidth = mainTable.clientWidth;

                //setting Host information[mandatory][HostIp, Port, PagePath]
                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //Whole Merge kind [Optional, Default msNone]
                MergeSheet = msHeaderOnly;

                //Edit kind [Optional, Default false]
                Editable = true;

                //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(15, 1, 0, true);

                //Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false)

                //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle = "title|csr no|office|prpd by|pay to|csr type|desc|pay grp|evi tp|due date|asa no|inv dt|currcd|amt|apprd" ;
                InitHeadRow(0, HeadTitle, true);

                //Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_title",    false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_csr_no",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_office",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_prpd_by",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_pay_to",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_csr_type", false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_desc",     false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_pay_grp",  false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_evi_tp",   false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_due_dt",   false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_asa_no",   false,    "",         dfNone,     0,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_inv_dt",   false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_curr_cd",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_apprd_by", false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_amt",      false,    "",         dfNone,     0,          false,      false);
            }
            break; 

        case 4:      //sheet4 init
            with (sheetObj) {
                // setting height
                style.height = GetSheetHeight(10);
                
                //Whole setting width
                SheetWidth = mainTable.clientWidth;

                //setting Host information[mandatory][HostIp, Port, PagePath]
                if(location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //Whole Merge kind [Optional, Default msNone]
                MergeSheet = msHeaderOnly;

                //Edit kind [Optional, Default false]
                Editable = true;

                //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(9, 1, 0, true);

                //Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, false, true, false, false)

                //setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                var HeadTitle = "count|char of account|account name|gl date|city|inv no|desc|debit|credit" ;
                InitHeadRow(0, HeadTitle, true);

                //Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_seq",      false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_cht_acct", false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_acct_nm",  false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_gl_dt",    false,    "",         dfNone,     0,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_city",     false,    "",         dfNone,     2,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_inv_no",   false,    "",         dfNone,     2,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_desc",     false,    "",         dfNone,     2,          false,      false);
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_debit",    false,    "",         dfNone,     2,          false,      false); 
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "dtl_credit",   false,    "",         dfNone,     2,          false,      false);                                      
            }
            break;                      
	}
}

/* 
 * Event handler processing by button name 
 */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject  = sheetObjects[0];
	var sheetObject2  = sheetObjects[1];
	var rdObject = rdObjects[0];

//	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_request":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);
				break;
							
			case "btn_cancel":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
				break;
				
			case "btng_downexcel1":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			
			case "btng_downexcel2":
				doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
				break;

			case "btn_print":
				doActionIBSheet(sheetObject,formObject,RDPRINT);				
				break;

			case "btn_clear":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02);
				break;
				
			case "btn_cal_fr":
				var cal = new ComCalendar();
				cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
				break;

			case "btn_cal_to":
				var cal = new ComCalendar();
				cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
				break;

			case "btn_inv_dt":
				var cal = new ComCalendar();
				cal.select(formObject.inv_dt, 'yyyy-MM-dd');
				break;
			
            case "check_apply":
				cnt_Check();
				break;
				
			case "uncheck_apply":
				cnt_Uncheck();
				break;
			
		} // end switch
		
//	}catch(e) {
//		if( e == "[object Error]") {
//			ComShowMessage(ComGetMsg("COM12111", "", ""));
//		} else {
//			ComShowMessage(e);
//		}
//	}
}

/*
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
	    case IBSEARCH:	//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;

			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0017GS.do", agtQryStr(formObj));
			sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;

		case IBSEARCH_ASYNC03: //Approval Request
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI01;

			sheetObj.DoSave("ESM_AGT_0017GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
            break;
            
		case IBDELETE:	//Cancel
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESM_AGT_0017GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;
			
		case IBDOWNEXCEL:	//Down Excel
			sheetObj.SpeedDown2Excel(-1);
			break;

		case RDPRINT:	//Print
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			var sRow = sheetObj.FindCheckedRow("chk");
			var arrRow = sRow.split("|");
            formObj.h_csrNo.value = sheetObj.CellValue(arrRow[0], "csr_no");
            var currCd = sheetObj.CellValue(arrRow[0], "curr_cd");
			
			formObj.f_cmd.value = PRINT;
			var sXml = sheetObj.GetSearchXml("ESM_AGT_0017GS2.do", agtQryStr(formObj));
			var arrXml = sXml.split("|$$|");

   	        var sheetObj3 = sheetObjects[2];
   	        var sheetObj4 = sheetObjects[3];
   	        
   	        sheetObj.RemoveEtcData();         
   	        sheetObj3.LoadSearchXml(arrXml[0]);
   	        sheetObj4.LoadSearchXml(arrXml[1]);
   	        
			var fromObj = new Array();
			var rdObj  	= new Array();
			var parmObj = new Array();
			
            fromObj[0] = formObj;  
            rdObj[0] = sheetObjects[2]; /
            rdObj[1] = sheetObjects[3];
            //RD_path  = "http://127.0.0.1:9001/opuscntr/";
            //RD_path = "http://kov440h.company.com:9300/opuscntr/";

            parmObj[0] = "1";
            parmObj[1] = "";
            parmObj[2] = "N";
            if(currCd == "JPY" || currCd == "KRW"){
	            parmObj[3] = RD_path + "apps/opus/esm/agt/agtaudit/agtaudit/report/ESM_AGT_0017B.mrd"; //RD 화면
	        }else{
	            parmObj[3] = RD_path + "apps/opus/esm/agt/agtaudit/agtaudit/report/ESM_AGT_0017A.mrd"; //RD 화면
	        }
            parmObj[4] = rdObj;
            parmObj[5] = fromObj;
            rdObjModaless(RdReport, parmObj, 700, 700);	
            //ComOpenRDPopup(RdReport, parmObj, 700, 700);	
            break;

			

		case IBSEARCH_ASYNC02: //clear
			formObj.apro_step.value = "";
			break;
	}
	
	var sts = formObj.if_option.value;
	if(sts == "IF"){
		var rows = sheetObj.RowCount;
		for(var i=0; i<rows; i++){
			ifFlag = sheetObj.CellValue(i+1,"if_flg");
			rcvFlag = sheetObj.CellValue(i+1,"rcv_err_flg");
			
			if(ifFlag == "E" || rcvFlag == "E"){
				sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0); //red
			}
			
			if(ifFlag == ""){
				sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(0,0,255); //blue
			}
		}
	}
}

/*
 * Retrieving Detail information in Detail Grid when setting the column to Optional in Master Grid
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	
	if(currentRow == row) return false;
	currentRow = row;
	
	formObj.f_cmd.value = SEARCHLIST;
	formObj.comm_apro_no.value = sheetObj.CellValue(row,"comm_apro_no");
	sheetObj2.DoSearch4Post("ESM_AGT_0017GS.do", agtQryStr(formObj));	
	sheetObj.SelectCell(row, col);
	
	// Cancel button Activate/Deactivate
	//var statusCd = sheetObj1.cellValue(row,"status_cd");
	//doActionBtnEnable(statusCd);
	
}

/*
 * retrieving CSR Deatil Popup when Double Clicking CSR No column in Master Grid
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var csrNo = sheetObj.CellValue(row, col);

	if (sheetObj.ColSaveName(col) == "csr_no" && csrNo != "") {
		var param = "?csr_no=" + csrNo;
        //window.showModalDialog("ESM_AGT_011.do" + param, "Detail & History", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px");
        //window.showModelessDialog("ESM_AGT_011.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
		ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "700", "507", false);
	}
}

/**
 * Retrieving Subject Office List on Changing A/R Office
 */
function ar_ofc_cd_OnChange(obj){
    var formObj = document.form;
    formObj.param1.value = "sbOfcCd";
    formObj.param2.value = "&lt;&lt;select&gt;&gt;";
    formObj.param3.value = "agn_cd";
    formObj.param4.value = obj.value;
    formObj.param5.value = "SUBOFC";
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0017FR.do";
    formObj.submit();
    
    var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	currentRow = 0;
}

/**
 * Retrieving ASA No List on changing Subject Office
 */
function agn_cd_OnChange(obj){
    var formObj = document.form;
    formObj.param1.value = "asaNo";
    formObj.param2.value = "";
    formObj.param3.value = "asa_no";
    formObj.param4.value = obj.value;
    formObj.param5.value = "ASANO";
    formObj.target = "frmHidden";
    formObj.action = "ESM_AGT_0017FR.do";
    formObj.submit();
    
    var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	currentRow = 0;
}



/**
 * FOCUS on VAT
 */
function invTaxRt_onfocus(obj){
	obj.select();
}

/**
 * Checking Validation when Focusing out VAT 
 */
function invTaxRt_validate(obj){
	var formObj = document.form;
	
	if(!ComIsNumber(obj,'.')){
   		ComShowMessage(ComGetMsg("AGT10003", "", "", ""));
   		obj.value = "0.00";
   		formObj.inv_tax_rt.focus();
   		formObj.inv_tax_rt.select();
   		return false;
	}
	
	var vat = parseFloat(obj.value);
	if(vat < 0 || vat >= 100){
		ComShowMessage(ComGetMsg("AGT10003", "", "", ""));
		obj.value = "0.00";
   		formObj.inv_tax_rt.focus();
   		formObj.inv_tax_rt.select();
		return false
	}
}

/**
 * Initializing Grid on Changing I/F Option.
 */
function if_option_OnChange(obj){
    var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	currentRow = 0;
}


/**
 * Setting ASA TO_DATE to Effect Date on Changing ASA No.
 */
function asa_no_OnChange(){
	var formObj = document.form;
	var idx = formObj.asa_no.selectedIndex;
	if(idx >= 0){
		//ASA No의 TO_DATE로 세팅
	    var asaNo = formObj.asa_no[idx].text;
    	var split = asaNo.split('~');
    	var temp = ComReplaceStr(split[1], ')', ' ');
    	temp = ComReplaceStr(temp, '/', '-');
    	temp = ComReplaceStr(temp, ' ', '');
    	formObj.inv_dt.value = temp;
    }else{
    	//오늘 날짜로 세팅
    	formObj.inv_dt.value = ComGetNowInfo();
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//		if (!isNumber(iPage)) {
//			return false;
//		}
		
		switch(sAction) {
		    case IBSEARCH:	//Retrieve
		    	if(ar_ofc_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "A/R Office", "", ""));
		    		formObj.cbArOfcCd.focus();
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "Subject Office", "", ""));
		    		formObj.agn_cd.focus();
		    		return false;
		    	}
		    	break;
		    	
			case IBSEARCH_ASYNC03:	//Approval Request
				if(if_option.value != "AS"){
					//Please check **.
					ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
		    		return false;
		    	}
			
				if(ar_ofc_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)A/R Office", "", ""));
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)Subject Office", "", ""));
		    		return false;
		    	}
		    	
		    	if(offsetFlag.value == "Y" && asa_no.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", " ASA No", "", ""));
		    		formObj.asa_no.focus();
		    		return false;
		    	}
		    	
//		    	if(apro_step.value == ""){
////		    		ComShowMessage(ComGetMsg("COM12114", "Approval Step", "", ""));
//		    		ComShowMessage(ComGetMsg("AGT10034", "", "", ""));
//		    		return false;
//		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");s
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for approval request", "", ""));
					return false;
				}
		    	break; 
		    
		    case IBDELETE:	//Cancel
		    	if(if_option.value != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
		    		return false;
		    	}
			
				if(ar_ofc_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)A/R Office", "", ""));
		    		return false;
		    	}
		    	
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)Subject Office", "", ""));
		    		return false;
		    	}
		    	if(agn_cd.value == ""){
		    		ComShowMessage(ComGetMsg("COM12113", "(Approval)Subject Office", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					ComShowMessage(ComGetMsg("COM12113", "row for cancel", "", ""));
					return false;
				}else{
					var sRows = sheetObj.RowCount;
					
					for(var i=0; i<sRows; i++){
						if_flg_msg = sheetObj.CellValue(i+1,"if_flg_msg");
						status_cd = sheetObj.CellValue(i+1,"status_cd");
						chk = sheetObj.CellValue(i+1,"chk");
						
						if(chk == "1" && if_flg_msg == "Already Interfaced"){
							ComShowCodeMessage("AGT00091", "[" + sheetObj.CellValue(i+1,"csr_no") + "] CSR No", "", "");
							return false;
						}
						
						if(chk == "1" && (status_cd == "A" || status_cd == "P" || status_cd == "D")){
							ComShowCodeMessage("AGT00091", "[" + sheetObj.CellValue(i+1,"comm_apro_no") + "] Audit No", "", "");
							return false;
						}
					}
					
				}
		    	break; 

		    case RDPRINT:	//Print
		    	if(if_option.value != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "I/F Option", "", ""));
		    		return false;
		    	}
			
				var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("AGT10016", "", "", ""));
					return false;
				}
				break;
			
			case IBSEARCH_ASYNC04:
			    var checkCnt = sheetObj.CheckedRows("chk");
			    
			    if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("COM12177", "", "", ""));
					return false;
				}
			    
			    if(if_option.value != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "Approval Request!", "", ""));
		    		return false;
		    	}
		    	
		    	var selectValue = sheetObj.CellValue(sheetObj.SelectRow,'if_flg');
		    	if(selectValue != "Approval Request!"){
					ComShowMessage(ComGetMsg("COM12113", "Approval Request!", "", ""));
		    		return false;
		    	}
		    	
		    	
				
			    break;
		}
	}

	return true;
}
	
	/**
	 * Checking the number of rows
	 */
	function cnt_Check(){
		var formObj = document.form;
		var sheetObj  = sheetObjects[0];
		
		var chkStart = formObj.chkStart.value;
		var chkEnd = formObj.chkEnd.value;

		var sRows = sheetObj.RowCount;
		
		if(sRows > 0){
		    if(chkStart == "" || chkStart == null){
		    	ComShowCodeMessage("AGT10001", "Check Start Row", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(chkStart == "0"){
	    		ComShowCodeMessage("AGT10001", "number 1 over", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(chkEnd == "" || chkEnd == null){
	    		ComShowCodeMessage("AGT10001", "Check End Row", "", "");
	    		formObj.chkEnd.focus();
	    		return false;
	    	}

	    	
	    	var numChkStart	= parseInt(chkStart);
	    	var numChkEnd	= parseInt(chkEnd);
	    	if(numChkStart > numChkEnd){
	    		ComShowCodeMessage("COM12142", "Check Start Row", "Check End Row", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(numChkEnd > sheetObj.RowCount){
	    		ComShowCodeMessage("AGT10001", "number less than "+ sheetObj.RowCount+" or equal", "", "");
	    		formObj.chkEnd.focus();
	    		return false;
	    	}
	    	
	    	if(numChkStart > sheetObj.RowCount){
	    		ComShowCodeMessage("AGT10001", "number less than "+ sheetObj.RowCount+" or equal", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}
	    	
	    	if(numChkStart > sheetObj.RowCount){
	    		ComShowCodeMessage("AGT10001", "number less than end row or equal", "", "");
	    		formObj.chkStart.focus();
	    		return false;
	    	}

	    	var i = numChkStart;
	    	var max = numChkEnd;
	    	var checkd = "";
	    	sheetObj.Redraw = false;
	    	while ( i <= max )
	        {
	         checkd = checkd + "1\r\n";
	         sheetObj.RowStatus(i++) = "U";
	        }
	        sheetObj.Paste2Column(checkd,"|","\r\n","","chk",numChkStart);
	    	sheetObj.Redraw = true;
		}	
	}

	/**
	 * Unchecking the number of rows
	 */
	function cnt_Uncheck(){
		var formObj = document.form;
		var sheetObj  = sheetObjects[0];
		
		var unchkStart = formObj.unchkStart.value;
		var unchkEnd = formObj.unchkEnd.value;
		
		    if(unchkStart == "" || unchkStart == null){
		    	ComShowCodeMessage("AGT10001", "Uncheck Start Row", "", "");
	    		formObj.unchkStart.focus();
	    		return false;
	    	}
	    	
	    	if(unchkStart == "0"){
	    		ComShowCodeMessage("AGT10001", "number 1 over", "", "");
	    		formObj.unchkStart.focus();
	    		return false;
	    	}
	    	
	    	if(unchkEnd == "" || unchkEnd == null){
	    		ComShowCodeMessage("AGT10001", "Uncheck End Row", "", "");
	    		formObj.unchkEnd.focus();
	    		return false;
	    	}
	    	
	    	if(parseInt(unchkStart) > parseInt(unchkEnd)){
	    		ComShowCodeMessage("COM12142", "Uncheck Start Row", "Uncheck End Row", "");
	    		formObj.unchkStart.focus();
	    		return false;
	    	}
	    	
	    	var i =  parseInt(unchkStart);
	    	var max =  parseInt(unchkEnd);
	    	var checkd = "";
	    	sheetObj.Redraw = false;
	    	while ( i <= max )
		    {
		    	checkd = checkd + "0\r\n"
		    	sheetObj.RowStatus(i++) = "R";
		    }
		    sheetObj.Paste2Column(checkd,"|","\r\n","","chk", unchkStart);
	    	sheetObj.Redraw = true;

	}

