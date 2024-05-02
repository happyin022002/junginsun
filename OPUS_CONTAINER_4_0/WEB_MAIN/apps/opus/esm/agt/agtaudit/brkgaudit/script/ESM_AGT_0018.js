/* 
 * Common Global Variables
 */
var sheetObjects = new Array();
var sheetCnt = 0;
var ifOptVal = "BF";
var CurrentRow = 0;

/* 
 * RD
 */
var rdObjects = new Array();
var rdCnt = 0;

/** 
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

		//IBSheet Initialization
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
	formObj.eff_date.value = today;
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
				InitColumnInfo(27, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "CHK|STS|Freight Forwarder|Freight Forwarder|Freight Forwarder|CNT|AMT|vndrSeq|AP OFC|CSR NO|I/F Date|I/F Remark|RCV Remark|IF Flag|RCV Flag|Pay AMT|Pay Date|Check No|Method||Status Code|inv_rgst_no|brog_apro_no";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,     30,    daCenter,  false,    "chk",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtHiddenStatus, 	   30,    daCenter,  false,    "ibflag",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "fwdr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "vndr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         200,   daLeft,    true,     "fwdr_name", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum,      30,    daRight,   false,    "tot_cnt", false,    "",         dfInteger,  0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum,      80,    daRight,   false,    "tot_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  true,     "vndr_seq",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "ap_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         140,   daCenter,  true,     "csr_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,     "if_date",   false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    true,     "if_rsn",  false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    true,     "rcv_rsn", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    true,     "if_flg",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    true,     "rcv_flg", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daRight,   true,     "pay_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daCenter,  true,     "pay_dt",  false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    true,     "ftu_use_ctnt1",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    true,     "pay_mzd_lu_cd", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "bkg_no", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "bkg_cre_dt", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "VNDR_TERM_NM", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "COA_INTER_COMPY_CD", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,         100,   daLeft,    true,     "INV_DESC", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtData,	30,	daCenter,true,	"status_cd", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,	30,	daCenter,true,	"inv_rgst_no", false,    "",         dfNone,     0,          false,       false);
				InitDataProperty(0, cnt++ , dtData,	30,	daCenter,true,	"brog_apro_no", false,    "",         dfNone,     0,          false,       false);
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
				InitColumnInfo(11, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "F.F|VNDR|BL NO|REF NO|I/F AMT|Type|Rate|BKG NO|BKG STS|SEQ|Remark";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    70,    daCenter,  true,     "fwdr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    50,    daCenter,  true,     "vndr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  false,    "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    100,   daCenter,  false,    "brog_ref_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 70,    daRight,   false,    "act_if_comm_amt",  false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,    50,    daCenter,  false,    "brog_type",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    50,    daRight,   false,    "brog_bkg_rt",   false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,    90,    daCenter,  false,    "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "bkg_sts_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  40,    daCenter,  false,    "brog_seq",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    300,   daLeft,    false,    "comm_proc_rslt_rsn",false,    "",         dfNone,     0,          false,      false);
				CountPosition = 0;
			}
			break;
			
		case 3:     	//sheet3 init
            with (sheetObj) {
                //setting height
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
                InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "hdr_prpd_dy",  false,    "",         dfNone,     0,          false,      false);
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
                              
		case 5:      //sheet5 init
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
				InitColumnInfo(6, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "SEQ|CSR No|Vendor|CUR|Amount|Desc";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "seq",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "csr_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "vendor", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "cur",    false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "amount", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,   100,   daLeft,    false,    "vendor_nm",   false,    "",         dfNone,     0,          false,      false);
				CountPosition = 0;
			}
			break;
		
		case 6:      //sheet1 init
			with (sheetObj) {
				//setting height
				style.height = GetSheetHeight(10);
				
				//Whole setting width
				SheetWidth = mainTable.clientWidth;

				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//Whole Merge kind [Optional, Default msNone]
				MergeSheet = msAll;
				
			   	//Edit kind [Optional, Default false]
				Editable = true;

				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(21, 0, 0, true);

				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false, false) ;
			
				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "CHK|STS|Freight Forwarder|Vendor|Freight Forwarder Name|CSR NO|BKG_NO|BL_NO|CNT|AMT|vndrSeq|AP OFC|I/F Date|I/F Remark|RCV Remark|IF Flag|RCV Flag|Pay AMT|Pay Date|Check No|Method";
				InitHeadRow(0, HeadTitle, true);

				//Data  properties    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtCheckBox,     30,    daCenter,  false,    "chk",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtHidden, 	   30,    daCenter,  false,    "ibflag",    false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "fwdr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "vndr",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         200,   daLeft,    true,     "fwdr_name", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         140,   daCenter,  true,     "csr_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         90,    daCenter,  false,    "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         90,    daCenter,  false,    "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         30,    daRight,   false,    "tot_cnt", false,    "",         dfInteger,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         80,    daRight,   false,    "tot_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       60,    daCenter,  false,     "vndr_seq",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         60,    daCenter,  false,     "ap_ofc_cd",  false,    "",         dfNone,     0,          false,      false);				
				InitDataProperty(0, cnt++, dtData,         80,    daCenter,  false,     "if_date",   false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    false,     "if_rsn",  false,    "",         dfNone,     0,          true,       false);
				InitDataProperty(0, cnt++, dtData,         400,   daLeft,    false,     "rcv_rsn", false,    "",         dfNone,     0,          true,       false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    false,     "if_flg",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,       50,    daLeft,    false,     "rcv_flg", false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daRight,   false,     "pay_amt", false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daCenter,  false,     "pay_dt",  false,    "",         dfDateYmd,  0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    false,     "ftu_use_ctnt1",false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,         100,   daLeft,    false,     "pay_mzd_lu_cd", false,    "",         dfNone,     0,          false,      false);
				//CountPosition = 0;
			}
			break;
	}
}

/** 
 * Event handler processing by button name 
 */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject  = sheetObjects[0];
	var sheetObject6  = sheetObjects[5];
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
				
			case "btn_downexcel":
				doActionIBSheet(sheetObject6,formObject,IBDOWNEXCEL);				
				break;

			case "btn_print":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC04);				
				break;

			case "btn_csrprint":
				doActionIBSheet(sheetObject,formObject,RDPRINT);				
				break;
				
			case "btn_cal_fr":
				var cal = new ComCalendar();
				cal.select(formObject.search_dt_fr, 'yyyy-MM-dd');
				break;

			case "btn_cal_to":
				var cal = new ComCalendar();
				cal.select(formObject.search_dt_to, 'yyyy-MM-dd');
				break;

			case "btn_eff_dt":
				var cal = new ComCalendar();
				cal.select(formObject.eff_date, 'yyyy-MM-dd');
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

/**
 * handling process for Sheet
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			    if(formObj.bl_no.value.trim().length > 0){
		    		setBlNoRetrieve(formObj.bl_no);
		    	}
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0018GS.do", agtQryStr(formObj));
			sheetObj.SumText(0,0) = "";
			sheetObj.SumText(0,4) = "TOTAL";
			sheetObj.CellAlign(sheetObj.LastRow,4) = daCenter;
			
			sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			
			formObj.if_cnt.selectedIndex = 0;
			break; 
            			
		case IBSEARCH_ASYNC03: //Approval Request
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoSave("ESM_AGT_0018GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj1 = sheetObjects[0];
			var sheetObj2 = sheetObjects[1];
			
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0018GS.do", agtQryStr(formObj));
			
//			sheetObj1.RemoveAll();
//			sheetObj2.RemoveAll();
			currentRow = 0;
            break;
            
		case IBDELETE:	//Cancel
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoSave("ESM_AGT_0018GS.do", agtQryStr(formObj), "chk");
			
			var sheetObj2 = sheetObjects[1];
			sheetObj2.RemoveAll();
			currentRow = 0;
			break;   

		case IBDOWNEXCEL:	//Down Excel
			//if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch4Post("ESM_AGT_0018GS5.do", agtQryStr(formObj));
			
//			sheetObj.SpeedDown2Excel(-1);
            sheetObj.Down2Excel(-1);
			break;
		
		case IBSEARCH_ASYNC04:  //Print
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			
			var sheetObj5 = sheetObjects[4];
   	        
			formObj.f_cmd.value = SEARCH01;
			//sheetObj5.DoSearch4Post("ESM_AGT_0018GS4.do", agtQryStr(formObj));
			var sXml = sheetObj5.GetSearchXml("ESM_AGT_0018GS4.do", agtQryStr(formObj));
			
			sheetObj5.LoadSearchXml(sXml);
			
			//Print
			var fromObj = new Array();
			var rdObj  	= new Array();
			var parmObj = new Array();
			
            fromObj[0] = formObj;  
            rdObj[0] = sheetObj5; 
            //RD_path  = "http://127.0.0.1:9001/opuscntr/";
            //RD_path = "http://kov440h.company.com:9300/opuscntr/";

            // RD 
            parmObj[0] = "1";
            parmObj[1] = "";
            parmObj[2] = "N";
            parmObj[3] = RD_path + "apps/opus/esm/agt/agtaudit/brkgaudit/report/ESM_AGT_0018.mrd"; //RD 
            parmObj[4] = rdObj;
            parmObj[5] = fromObj;
            rdObjModaless(RdReport, parmObj, 700, 700);	
			break;

		case RDPRINT:	//CSR Print
			if(!validateForm(sheetObj,formObj,sAction))	return false;

			var sheetObj3 = sheetObjects[2];
   	        var sheetObj4 = sheetObjects[3];
   	        
			var sRow = sheetObj.FindCheckedRow("chk");
			var arrRow = sRow.split("|");
            formObj.h_csrno.value = sheetObj.CellValue(arrRow[0], "csr_no");
            
			//AP_INV_HDR, AP_INV_DTRB Retrieve
			formObj.f_cmd.value = PRINT;
			var sXml = sheetObj3.GetSearchXml("ESM_AGT_0018GS3.do", agtQryStr(formObj));
			var arrXml = sXml.split("|$$|");
//			sheetObj3.LoadSearchXml(sXml);
//			var sxml1 = sheetObj3.EtcData("sxml1");
				
   	        
   	        //ETC date setting
   	        sheetObj.RemoveEtcData();         
	        sheetObj3.LoadSearchXml(arrXml[0]);
	        sheetObj4.LoadSearchXml(arrXml[1]);
   	        
			//Print
			var fromObj = new Array();
			var rdObj  	= new Array();
			var parmObj = new Array();
			
            fromObj[0] = formObj;  
            rdObj[0] = sheetObjects[2]; 
            rdObj[1] = sheetObjects[3];
            //RD_path  = "http://127.0.0.1:9001/opuscntr/";
            //RD_path = "http://kov440h.company.com:9300/opuscntr/";

            // RD setting
            parmObj[0] = "1";
            parmObj[1] = "";
            parmObj[2] = "N";
            parmObj[3] = RD_path + "apps/opus/esm/agt/agtaudit/agtaudit/report/ESM_AGT_0017A.mrd"; //RD 
            parmObj[4] = rdObj;
            parmObj[5] = fromObj;
            rdObjModaless(RdReport, parmObj, 700, 700);	
			break;
	}
	
	//Showing Interface Error
	if(ifOptVal == "IF"){
		var rows = sheetObj.RowCount;
		for(var i=0; i<rows; i++){
			ifFlag = sheetObj.CellValue(i+1,"if_flg");
			rcvFlag = sheetObj.CellValue(i+1,"rcv_flg");
			
			//Error
			if(ifFlag == "E" || rcvFlag == "E"){
				sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(255,0,0); //red
			}
			
			//Not Finished
			if(ifFlag == ""){
				sheetObj.RowFontColor(i+1) = sheetObj.RgbColor(0,0,255); //blue
			}
		}
	}
}

/**
 * Retrieving Detail information of F.Forwarder at the Deatil Grid in case that the colunm of Master Grid is set to Optional. .
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	var formObj = document.form;
	var sheetObj2 = sheetObjects[1];
	
	if(currentRow == row) return;
	currentRow = row;
	
//	if(sheetObj.CellValue(row,"chk") == 0){
//		alert(sheetObj.CellValue(row,"chk"));
//	}
	formObj.f_cmd.value = SEARCHLIST;
	formObj.vndr_seq.value = sheetObj.CellValue(row,"vndr_seq");
	formObj.fwdr.value = sheetObj.CellValue(row,"fwdr");
	formObj.csr_no.value = sheetObj.CellValue(row,"csr_no");
	formObj.ap_ofc_cd.value = sheetObj.CellValue(row,"ap_ofc_cd");
	sheetObj2.DoSearch4Post("ESM_AGT_0018GS2.do", agtQryStr(formObj));	
	sheetObj.SelectCell(row, col);
}

/**
 * Retrieving CSR Detail opoup On double clicking the CSR Column at Master Grid.
 */
function sheet1_OnDblClick(sheetObj, row, col) {
//	var csr_no = sheetObj.CellValue(row, col);
	var csr_no = sheetObj.CellValue(row, "csr_no");
	
	if (sheetObj.ColSaveName(col) == "csr_no" && csr_no != "") {
		var param = "?csr_no=" + csr_no;
		//window.showModalDialog("ESM_AGT_011.do" + param, "Detail & History", "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px");
        //window.showModelessDialog("ESM_AGT_011.do" + param, window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:630px")
		ComOpenWindowCenter("ESM_AGT_0043.do" + param, "compop3", "600", "550", false);
	}
}

/**
 * Initializing Grid data on modifying I/F option.
 */
function if_option_OnChange(obj){
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	
	if(ifOptVal == obj.value){
		return;
	}else{
		ifOptVal = obj.value;
		
		sheetObj1.RemoveAll();
		sheetObj2.RemoveAll();
	}
	
	if(ifOptVal == "IF"){
		//I/F Count : disable
		formObj.if_cnt.disabled = true;
		//Radio Check
		sheetObj1.InitDataProperty(0, 0, dtRadioCheck, 30, daCenter, false, "chk", false, "", dfNone, 0, true, true);
		
		//Status : disable
		formObj.sts_option.disabled = true;
	}else{
		//I/F Count : enable
		formObj.if_cnt.disabled = false;
		//Multi Check
		sheetObj1.InitDataProperty(0, 0, dtCheckBox,   30, daCenter, false, "chk", false, "", dfNone, 0, true, true);
		
		//Status : enable
		formObj.sts_option.disabled = false;
	}
}

/*
 * Setting the text to Whole optional On Focusing.
 */
function frDate_onfocus(obj){
	delete_Char(obj,'-');	
	obj.select();	
}

/**
 * Showing the checked Date when the date is changed 
 */
function frDate_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = obj.value;
		var toDt = delete_Char(formObj.toDate.value,'-');
		
		if(frDt > toDt){
			obj.value = toDt;

			//TO DATE must be greater than FROM DATE.
			ComShowMessage(ComGetMsg("COM12133", "End date", "start date", "greater"));
			obj.focus();
		}else{
			str = obj.value;
			str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
			obj.value = str;
		}
	}
}

/*
 * Setting the text to Whole optional On Focusing.
 */
function toDate_onfocus(obj){
	delete_Char(obj,'-');	
	obj.select();	
}

/**
 * Showing the checked Date when the date is changed 
 */
function toDate_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		var formObj = document.form;
		var frDt = delete_Char(formObj.frDate.value,'-');
		var toDt = obj.value;
		
		if(frDt > toDt){
			obj.value = frDt;

			//TO DATE must be greater than FROM DATE.
			ComShowMessage(ComGetMsg("COM12133", "End date", "start date", "greater"));
			obj.focus();
		}else{
			str = obj.value;
			str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
			obj.value = str;
		}
	}
}

/**
 * Checking the check column of the grid on changing I/F Count.
 */
function if_cnt_OnChange(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];
	
	var if_cnt = formObj.if_cnt.value;
	var sRows = sheetObj.RowCount;
		
	if(if_cnt == "SEL"){
		//user Optional 
		sheetObj.CheckAll2("chk") = 0;
	}else{
		
		if(if_cnt >= sRows){
			sheetObj.CheckAll2("chk") = 1;
		}else{
			sheetObj.CheckAll2("chk") = 0;
	
			
			for(var i=1; i<sRows; i++){
				sheetObj.CellValue2(i,"chk") = 1;
				if(i >= if_cnt) break;
			}
		}
	}
		
	sheetObj.focus();
}

/*
 * Setting the text to Whole optional On Focusing.
 */
function effDate_onfocus(obj){
	delete_Char(obj,'-');	
	obj.select();	
}

/**
 * Showing the checked Date when the date is changed 
 */
function effDate_onchange(obj){
	obj.value = delete_Char(obj.value,'-');
	
	if(!isDate(obj)){
		ComShowMessage(ComGetMsg("COM12179", "", "", ""));
		obj.focus();
	}else{
		str = obj.value;
		str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6);
		obj.value = str;
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
		    	break;
		    	
		    case IBDOWNEXCEL:	//Down Excel
		    	var rCnt = sheetObj.RowCount;
		    	if(rCnt < 1){
		    		ComShowMessage(ComGetMsg("AGT10004", "", "", ""));
					return false;
				}
				break; 
				
			case IBSEARCH_ASYNC03:	//Approval Request
				if(ifOptVal != "BF"){
		    		//Can't interface. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't interface.", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					//Please select **.
					ComShowMessage(ComGetMsg("COM12113", "row for interface", "", ""));
					return false;
				}
				
				
				//AR_OFC_CD 
				var rows = sheetObj.RowCount;
				for(var i=1; i<rows; i++) {
				    if(sheetObj.CellValue(i,"chk") == 1){
				    	apOfcCd = sheetObj.CellValue(i,"ap_ofc_cd");
				    	if(apOfcCd == ""){
				    		ComShowMessage(ComGetMsg("AGT10021", i, "", ""));
							return false;
						}
		     		}
		  		}
		    	break; 
		    
		    case IBDELETE:	//Cancel
		    	if(ifOptVal != "IF"){
		    		//Can't cancel. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't cancel.", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1){
					//Please select **.
					ComShowMessage(ComGetMsg("COM12113", "row for cancel", "", ""));
					return false;
				}else{
					var sRows = sheetObj.RowCount;
					
					for(var i=0; i<sRows; i++){
						if_flg_msg = sheetObj.CellValue(i+1,"if_rsn");
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
			
			case IBSEARCH_ASYNC04:	//Print
		    	if(ifOptVal != "IF"){
		    		//Can't print REPORT. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't print report[Brokerage Interfaced Status]", "", ""));
		    		return false;
		    	}
		    	break;
				
			case RDPRINT:	//CSR Print
		    	if(ifOptVal != "IF"){
		    		//Can't print CSR Report. Please check I/F Option.
		    		ComShowMessage(ComGetMsg("AGT10015", "Can't print report[CONSULTATION SLIP]", "", ""));
		    		return false;
		    	}
		    	
		    	var checkCnt = sheetObj.CheckedRows("chk");
				if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("AGT10016", "", "", ""));
					return false;
				}
				break;
				
			case IBSEARCH_ASYNC05:
			    var checkCnt = sheetObj.CheckedRows("chk");
			    
			    if(checkCnt < 1 || checkCnt > 1){
					ComShowMessage(ComGetMsg("COM12177", "", "", ""));
					return false;
				}
				
			    if(ifOptVal != "IF"){
					ComShowMessage(ComGetMsg("COM12114", "Approval Request!", "", ""));
		    		return false;
		    	}
		    	
		    	var selectValue = sheetObj.CellValue(sheetObj.SelectRow,'if_rsn');
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
 * F.Forwarder Retrieve pop-up open
 */	
function openWindowCustomer(formObj) {
	//var cust_cd = "US"; // Default setting
	var url = "COM_ENS_041.do";
	var width = 775;
	var height = 484;
	var func = "setForwarder";
	var display = "1,0,1";
	//url = url + "?cust_cd="+cust_cd;
	//comPopup(url, width, height, func, display, bModal, b2ndSheet);
	ComOpenPopup(url, width, height, func, display, true, false);
}

/**
 * Setting Returned Calue after Retrieving F.Forwarder
 */
function setForwarder(rowArray, row, col) {
	var colArray = rowArray[0];
    	
	document.form.ff_cnt_cd.value = colArray[3];
}

/**
 * Setting the user inserted BL NO 
 */
function setBlNo(obj) {

    var form = document.form;
    var bl_no = obj.value.trim().toUpperCase();
    var bl_no_list = form.bl_nos.value.trim().toUpperCase();
        
    if (window.event.keyCode==13) {
        if(bl_no.length > 0) {
   
            if(bl_no_list.length > 0) {
                form.bl_nos.value = bl_no_list + "," + bl_no;
            } else {
                form.bl_nos.value = bl_no;
            }

            obj.value = "";
        }
    }
}

/**
 * Deleting Date after inserting BL No.
 */
function setDateEmpty() {
    
    var form = document.form;
    var bl_no_list = form.bl_nos.value.trim().toUpperCase();

    /**
     * Setting the user inserted BL NO 
     */
}
function setBlNos(obj) {
     var form = document.form;
     form.bl_nos.value = obj.value.trim().toUpperCase();
}
/**
 * Retrieving after Setting the Bl no. on Clicking Retrieve button
 */
function setBlNoRetrieve(obj) {
    var form = document.form;
    var bl_no = obj.value.trim().toUpperCase();
    var bl_no_list = form.bl_nos.value.trim().toUpperCase();

        if(bl_no_list.length > 0) {
            form.bl_nos.value = bl_no_list + "," + bl_no;
        } else {
            form.bl_nos.value = bl_no;
        }

        obj.value = "";
}
