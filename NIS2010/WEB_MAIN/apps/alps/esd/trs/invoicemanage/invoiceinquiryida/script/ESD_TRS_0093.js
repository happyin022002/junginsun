/*=========================================================
*Copyright(c) 2017 SMLine
*@FileName : ESD_TRS_0093.js
*@FileTitle : TRS GST Invoice Summary 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.28
*@LastModifier : 
*@LastVersion : 1.0 
* 2017.11.28
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 
=========================================================*/


/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM Line 
 */

/**
 * @extends
 * @class ESD_TRS_0093
 */
function ESD_TRS_0093() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject  = sheetObjects[0];
	 var sheetObject1 = sheetObjects[1];

	 /*******************************************************/
	 var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_reset":
				resetSearchCondition(formObject);
				break;

			case "btns_calendar":
				var cal2 = new ComCalendarFromTo();
				cal2.displayType = "date";
				cal2.select(document.form.fmdate, document.form.todate, 'yyyyMMdd');
				break;

			case 'btns_no_cd':
				rep_Multiful_inquiry(srcName);
				break;
				
			case 'btns_ofc_cd':
				rep_Multiful_inquiry('Office Code');
				break;
				
			case 'btng_downexcel':
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL, "");
				break;
			
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){

   sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

	//시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//html컨트롤 이벤트초기화
	initControl();
	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(16);
//				style.height = GetSheetHeight(100);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 2, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(50, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Seq.|Invoice\nCreation\nOffice|Cost\nOffice|SM Line|SM Line|Service Provider|Service Provider|S/P|S/P|Invoice No|Received\nType|Status|W/O Amount|W/O Amount"
				              +"|Exchange\nRate|Calculation\nLogic|Date|Date|Date|Date|Date|Date|CSR No|HSN/SAC|HSN/SAC Description|Goods/Services|Reverse\nCharge|Hold|Currency"
				              +"|Invoice Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST SUM|GST SUM|Total Amount\n(Invoice + GST)|Payment Mothod|Check/T.T No|Invoice Remark"
				              +"|SPP\nInvoice\nRemark|Inv Creation|Inv Creation|Inv Update|Inv Update|ETS";
				
				
				var HeadTitle1= "Seq.|Invoice\nCreation\nOffice|Cost\nOffice|GSTIN/UIN|State\nCode|GSTIN/UIN|State\nCode|Code|Name|Invoice No|Received\nType|Status|Currency|Total"
				              +"|Exchange\nRate|Calculation\nLogic|Issue|Received|Paid|G/L|Status\nUpdated|Invoice Confirm|CSR No|HSN/SAC|HSN/SAC Description|Goods/Services|Reverse\nCharge|Hold|Currency"
				              +"|Invoice Amount|Rate|AMT|Rate|AMT|Rate|AMT|Rate|AMT|Rate|AMT|Total Amount\n(Invoice + GST)|Payment Mothod|Check/T.T No|Invoice Remark"
				              +"|SPP\nInvoice\nRemark|Office|User ID|User Nm|User ID|ETS";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				HeadRowHeight = 12;

				//데이터속성              [ROW, COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE, SAVENAME,                   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,    dtSeq,      110,    daCenter,   true,     "",                         false,      "",         dfNone,		0,  		false,   	false); 
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "inv_ofc_cd",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "cost_ofc_cd",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  120,	  daLeft,	  true,     "cst_ofc_gst_no",			false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "cst_ofc_ste_cd",			false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  120,	  daLeft,	  true,     "vndr_gst_no",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "vndr_ste_cd",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  80,	  daCenter,	  true,     "inv_vndr_seq",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  250,	  daLeft,	  true,     "inv_vndr_nm",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  120,	  daLeft,	  true,     "inv_no",			        false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "if_sys_knd_nm",			false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  100,	  daCenter,	  true,     "trsp_inv_aud_sts_nm",		false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "curr_cd",			        false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  100,	  daRight,	  true,     "wo_tot_amt",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "inv_xch_rt",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  230,	  daLeft,	  true,     "trsp_inv_calc_lgc_tp_nm",	false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  80,	  daCenter,	  true,     "inv_iss_dt",			    false,		"",	        dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  80,	  daCenter,	  true,     "inv_rcv_dt",			    false,		"",	        dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  80,	  daCenter,	  true,     "pay_dt",			        false,		"",	        dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  80,	  daCenter,	  true,     "gl_dt",			        false,		"",	        dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  80,	  daCenter,	  true,     "upd_dt",			        false,		"",	        dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  110,	  daCenter,	  true,     "inv_cfm_dt",			    false,		"",	        dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  160,	  daCenter,	  true,     "csr_no",			        false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "ida_sac_cd",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  190,	  daLeft,	  true,     "ida_sac_nm",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  110,	  daCenter,	  true,     "ida_pay_tp_cd",			false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "ap_rvs_cng_flg",			false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "inv_hld_flg",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "inv_curr_cd",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoSum,  110,	  daRight,	  true,     "inv_bzc_amt",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoAvg,  70,	  daRight,	  true,     "ida_cgst_rto",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoSum,  110,	  daRight,	  true,	    "ida_cgst_amt",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoAvg,  70,	  daRight,	  true,	    "ida_sgst_rto",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoSum,  110,	  daRight,	  true,	    "ida_sgst_amt",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoAvg,  70,	  daRight,	  true,	    "ida_igst_rto",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoSum,  110,	  daRight,	  true,	    "ida_igst_amt",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoAvg,  70,	  daRight,	  true,	    "ida_ugst_rto",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoSum,  110,	  daRight,	  true,	    "ida_ugst_amt",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoAvg,  70,	  daRight,	  true,     "ida_gst_rto",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoSum,  110,	  daRight,	  true,     "gst_amt",			        false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtAutoSum,  110,	  daRight,	  true,     "total_amt",			    false,		"",	        dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  120,	  daCenter,	  true,     "inv_pay_mzd_cd",			false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  100,	  daCenter,	  true,     "inv_chk_trns_no",			false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  110,	  daCenter,	  true,     "inv_rmk",			        false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "sp_inv_rmk",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "cre_ofc_cd",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "cre_usr_id",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  100,	  daLeft,	  true,     "upd_usr_nm",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  70,	  daCenter,	  true,     "upd_usr_id",			    false,		"",	        dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ ,   dtData,	  30,	  daCenter,	  true,     "ets_sts_flg",			    false,		"",	        dfNone,		0,			false,		false);				
				
				HeadRowHeight = 35 ;				
			
                AutoSumBottom = 1;               
                MessageText("Sum")  = "Total ";
                MessageText("Avg")  = " Average";				
				
		   }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			if(ComIsNull(formObj.no_cd)){
	   			if(ComIsNull(formObj.fmdate) || ComIsNull(formObj.todate) || ComIsNull(formObj.inv_cre_ofc)){
	   				ComShowCodeMessage("TRS90124");
					return false;
	   			}	   			
	   		}
	   		var days_between = ComGetDaysBetween(formObj.fmdate , formObj.todate) ;  // 조회 기간
	   		if( days_between   < 0) {
				ComShowCodeMessage("TRS90118");
				formObj.fmdate.focus();
				return false;
			} 
			if ( days_between > 60 ) {
				ComShowMessage(" Possible inquiry period is limited to 2 months.");
				return false;
			}
			
			formObj.f_cmd.value = SEARCH04;
			sheetObj.DoSearch4Post("ESD_TRS_0093GS.do", TrsFrmQryString(formObj));
		break;
		
		case IBDOWNEXCEL:        // excel down
			sheetObj.SpeedDown2Excel(-1);
		break;

	}
}


/**
  * 저장결과가 오류가 발생했을 때 공통처리하는 함수
  * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var sheetObj = sheetObjects[0];
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	var rowCount = sheetObj.rowcount;
	var value = null;
	var curr_cd = null;
	var inv_curr_cd = null;
	var wo_tot_amt = null;
	var inv_bzc_amt = null;

	for(var i=2; i<rowCount+2; i++){
		value = sheetObj.CellValue(i, 'if_sys_knd_cd');
		curr_cd = sheetObj.CellValue(i, 'curr_cd');
		inv_curr_cd = sheetObj.CellValue(i, 'inv_curr_cd');
		wo_tot_amt = sheetObj.CellValue(i, 'wo_tot_amt');
		inv_bzc_amt = sheetObj.CellValue(i, 'inv_bzc_amt');
		
		if(value == 'I' && (curr_cd != inv_curr_cd || wo_tot_amt != inv_bzc_amt) ){
			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
		}
		
		sheetObj.CellFont("FontBold", i,'inv_bzc_amt') = true;
		sheetObj.CellFont("FontBold", i,'gst_amt')     = true;
		sheetObj.CellFont("FontBold", i,'total_amt')   = true;
	}
	/** HKGSC Invoice EDI PDF File view Button Control */
	
}
 
/**
 * rep_commodity팝업호출
 */
function rep_Multiful_inquiry(val)
{
		var formObject = document.form;
		var cmdt_cd_val ="";       //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";     //향후 사용가능 예정변수
		var classId ="getTRS_ENS_906";
		var xx1=val;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var title = val;
		
		if (val == "btns_no_cd" ) {
			if(formObject.no_tp[0].checked)  {
				title = "Invoice No.";
			} else {
				title = "CSR No.";
			}
		}
		
		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 330, 'getTRS_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray,returnval) {
	var formObject = document.form;
	
	if(returnval=="btns_no_cd") {
		var x1=formObject.no_cd.value;
		if(x1==""){
			formObject.no_cd.value = rowArray;
			formObject.no_cd.focus();
		}else{
			formObject.no_cd.value = formObject.no_cd.value+","+rowArray;
			formObject.no_cd.focus();
		}
	} else if(returnval=="Office Code") {
		var x2=formObject.inv_cre_ofc.value;
		if(x2==""){
			formObject.inv_cre_ofc.value = rowArray;
			formObject.inv_cre_ofc.focus();
		}else{
			formObject.inv_cre_ofc.value = formObject.inv_cre_ofc.value+","+rowArray;
			formObject.inv_cre_ofc.focus();
		}
	}
}

/**
 * 조회조건을 초기화한다.
 */
function resetSearchCondition(formObj){
	
	formObj.reset();
}

/**
 * enter check
 **/
function enterCheck(obj)
{
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	if(event.keyCode == 13)
	{
		switch(obj.name){
			case 'combo_svc_provider':
				getTextVendorSeq(sheetObj, formObj, obj.value);
				break;
			case 'inv_cre_ofc':
			case 'ivc_upd_usr_id':
				value_upper(obj);
			case 'no_cd':
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
		}
	}
}

/**
 * Include Office를 처리하기 위한 Logic
 */
var request = null;
function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Erroe Request XMLHttp");
	}
}

/**
 * Include Check Bok를 Click했을 때
 */
function fun_chkOffice() {
	var doc_office = document.form.chk_office;
	var prm_office = doSepRemove(document.form.inv_cre_ofc.value.toUpperCase(), " "); //input text
	if( prm_office == "" ) {
		doc_office.checked = false;
		document.form.inv_cre_ofc.value = "";
		ComShowMessage("Please input the 'Invoice Creation Office'!!");
		return false;
	}
	if( doc_office.checked == true ) {
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+prm_office;
		document.form.old_ofc_cd.value = prm_office;
		createHttpRequest();
		request.open("GET", url, false);
		request.onreadystatechange = subCntorlOffice;
		request.send(null);
	} else {
		document.form.inv_cre_ofc.value = document.form.old_ofc_cd.value;
		document.form.inv_cre_ofc.disabled = false;
	}
}

/**
 * Office의 값을 가지고 온다.
 */
function subCntorlOffice() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				ComShowMessage("No Data!");
			}
			document.form.inv_cre_ofc.value = text_ofc.substring(0, text_ofc.length-1);
		}
	}
}
