/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0038 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0038() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var beforetab2 = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var minCount = 0;
var myWindow = null;
var myWindow1 = null;
var myWindow2 = null;
var myWindow3 = null;

//RD 에 넘길 데이타
var parmObj = new Array();
var fromObj = new Array();
var rdObj = new Array();
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	
	/***** 탭당 시트가 2개이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	/*******************************************************/
	var formObject = document.form;

	var checkflag = false;
	var confirmflag = false;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				if ( ComIsEmpty(formObject.inv_no))          // invoice no is not empty
				{
					formErrMsg("Invoice No");
					formObject.inv_no.focus();
					return;
				}
				if ( ComIsEmpty(formObject.rail_road_name))  // rail road is not empty
				{
					formErrMsg("Rail Road");
					document.rail_road_code.focus();
					return;
				}
				doActionIBSheet(sheetObject,formObject,IBSEARCH);     // invoice no and rail road 조건으로 조회
				formObject.inv_no.readOnly=true ;
				formObject.currency.disabled= true;
				document.rail_road_code.Enable  =false ;
				break;

			case "btn_reset":    // 초기화
				if ( ! ComIsEmpty(formObject.editflag))    return;
				formObject.reset();
				document.rail_road_code.Text = "";
				
				formObject.inv_no.readOnly=false ;
				formObject.currency.disabled= false;
				document.rail_road_code.Enable  =true ;
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				break;
				
			case "btn_minimize":   // 화면 조건에 대해서 숨김 또는 보임
				minCount = (minCount+1)%2 ;
				Minimize(minCount);
				break;
				
			case "btns_provider":   // Service provider 팝업
				if ( ! ComIsEmpty(formObject.editflag))    return;
				rep_OnPopupClick();
				break;
				
			case "btns_calendar1":  // Receive DT 
				if ( ! ComIsEmpty(formObject.editflag))    return;
				var cal = new ComCalendar();
				cal.select(formObject.receive_dt, 'yyyy-MM-dd');
				break;

			case "btns_calendar2":  // Issue DT
				if ( ! ComIsEmpty(formObject.editflag))    return;
				var cal = new ComCalendar();
				cal.select(formObject.issue_dt, 'yyyy-MM-dd');
				break;
				
			case "t1btng_invoicefileimport":   // file import 팝업
			case "t2btng_invoicefileimport":
			case "t3btng_invoicefileimport":
				 if ( ! ComIsEmpty(formObject.editflag))    return;
				 if (formObject.sts_cd.value == "FI" || formObject.sts_cd.value == "SV")   // file import 후 다시 file import 블가능
				 {
					errMsg = ComGetMsg("TRS90008" );
					ComShowMessage(errMsg);
					return true;
				 }
	 
				if (chkComfirm(formObject)) return;         // comfirm 후 버튼 사용 불가능
				if ( ComIsEmpty(formObject.inv_no))         // invoice no 는 필수조건
				{
					formErrMsg("Invoice No");
					formObject.inv_no.focus();
					return;
				}
				
				if ( ComIsEmpty(formObject.rail_road_name))   // rail rold 는 필수조건
				{
					formErrMsg("Rail Road");
					document.rail_road_code.focus();
					return;
				}

				if (myWindow != null) {
					myWindow.close();
				}

				var url = '?inv_no='+formObject.inv_no.value;
				url += '&rail_road_code='+document.rail_road_code.Text;
				url += '&rail_road_name='+formObject.rail_road_name.value;
				url += '&payment_vndr_code='+formObject.payment_vndr_code.value;
				url += '&payment_vndr_name='+formObject.payment_vndr_name.value;
				url += '&receive_dt='+formObject.receive_dt.value;
				url += '&issue_dt='+formObject.issue_dt.value;
				url += '&invoice_amt='+formObject.invoice_amt.value;
				url += '&vat_amt='+formObject.vat_amt.value;
				url += '&currency='+formObject.currency.value;
				
				myWindow = window.showModelessDialog('ESD_TRS_0923.do'+url, window, "scroll:no;status:no;help:no;dialogWidth:930px;dialogHeight:450px");
				myWindow.focus();

				break;
				
			case "t1btng_paymenthistory":       // Payment History
			case "t2btng_paymenthistory":
			case "t3btng_paymenthistory":

				if ( srcName == "t1btng_paymenthistory")      checkflag = chkCntr(sheetObject);     // Coincidence 하나만 선택되어있는지 체크 (false : 하나체크 , true : 하나가 아닌경우)
				if ( srcName == "t2btng_paymenthistory")      checkflag = chkCntr(sheetObject1);    // Discrepancy 하나만 선택되어있는지 체크
				if ( srcName == "t3btng_paymenthistory")      checkflag = chkCntr(sheetObject2);    // Invoice Only 하나만 선택되어있는지 체크
				
				if ( checkflag)     // false : 한개의 cntr no  , true : 없거나 하나이상의 cntr no
				{
					errMsg = ComGetMsg("COM12177" );
					ComShowMessage(errMsg);
					return;
				}
				if (myWindow2 != null) {
					myWindow2.close();
				}
				myWindow2 = window.showModelessDialog('ESD_TRS_0929.do', window, "scroll:no;status:no;help:no;dialogWidth:760px;dialogHeight:385px");
				myWindow2.focus();
				break;
	 
			case "t2btng_move":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                     // comfirm 후 버튼 사용 불가능
				moveSheetData( sheetObject1, sheetObject, "sel");       // Discrepancy 에서 Coincidence 로 체크 행을 이동

				break;
				
			case "t1btng_reaudit":
//				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                     // comfirm 후 버튼 사용 불가능
				if(sheetObject.CheckedRows('sel') == "0"){             // cntr no 한개이상 선택여부 체크
					errMsg = ComGetMsg("COM12176" );
					ComShowMessage(errMsg);
					return;
				}

				if (myWindow3 != null) {
					myWindow3.close();
				}
				myWindow3 = window.showModelessDialog('ESD_TRS_0925.do?mode=search&sel_sheet_idx=0', window, "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:755px");
				myWindow3.focus();
				break;
			case "t2btng_reaudit":

				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                     // comfirm 후 버튼 사용 불가능
				if(sheetObject1.CheckedRows('sel') == "0"){             // cntr no 한개이상 선택여부 체크
					errMsg = ComGetMsg("COM12176" );
					ComShowMessage(errMsg);
					return;
				}

				if (myWindow3 != null) {
					myWindow3.close();
				}
				myWindow3 = window.showModelessDialog('ESD_TRS_0925.do?mode=search&sel_sheet_idx=1', window, "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:755px");
				myWindow3.focus();
				break;
			case "t3btng_reaudit":
				if ( formObject.editflag.value == "N")    return;
				
				if (chkComfirm(formObject)){
					return;                     // comfirm 후 버튼 사용 불가능
				}

				if(!checkWaybillDate(sheetObject2)) return;

				if(sheetObject2.CheckedRows('sel') == "0"){             // cntr no 한개이상 선택여부 체크
					errMsg = ComGetMsg("COM12176" );
					ComShowMessage(errMsg);
					return;
				}

				if (myWindow3 != null) {
					myWindow3.close();
				}
				myWindow3 = window.showModelessDialog('ESD_TRS_0925.do?mode=apply&sel_sheet_idx=2', window, "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:755px");
				myWindow3.focus();
				break;
				  
			case "t3btng_rowadd":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                      // comfirm 후 버튼 사용 불가능
				doActionIBSheet2(sheetObject2,formObject,IBINSERT);       // Invoice Only에 Row Add
				break;   
					 
			case "t1btng_save":                     // Coincidence,Discrepancy,Invoice Only  전체를  Save 한다
			case "t2btng_save":
			case "t3btng_save":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                  // comfirm 후 버튼 사용 불가능
				
				if (checkInputData(formObject))                      // 필수입력 조건에 대한 체크
				{					
					if ( sheetObjects[0].RowCount == 0 && sheetObjects[1].RowCount == 0 && sheetObjects[2].RowCount == 0  && sheetObjects[3].RowCount == 0 )
					{
						errMsg = ComGetMsg("TRS90381");
						ComShowMessage(errMsg);
						return;						
					} else {
						doActionIBSheet(sheetObject,formObject,IBSAVE , "SV");      // 저장한다  SV 는 SAVE의 Flag						
					}
				}
				break;
				
			case "t1btng_confirm":                  // Coincidence,Discrepancy,Invoice Only  전체를  Confirm 한다
			case "t2btng_confirm":
			case "t3btng_confirm":
				if ( formObject.editflag.value == "N")    return;
				if (chkComfirm(formObject)) return;                 // comfirm 후 버튼 사용 불가능
				if (checkSheetData()) return;						// invoice only에 대한 필수 입력조건 체크

				if( !checkDuplicateSoSeq() ) return;				// pay flag가 check된 항목의 SO 중복체크

				if (checkInputData(formObject))                     // 필수입력 조건에 대한 체크
				{
					if (Number(ComTrimAll(formObject.invoice_amt.value,",")) == Number(formObject.total_amt_for_payment.value))      // Total Amt = Coincidence + Discrepancy + Invoice Only
					{
						doActionIBSheet(sheetObject,formObject,IBSAVE , "CF");    // Confirm 한다  "CF" Confirm 구분자
					} else {                                                      
						errMsg = ComGetMsg("TRS90006");
						ComShowMessage(errMsg);
						return;
					}
				}
				break;
				
			case "t1btng_print":                            // 해당 탭에 대해서 Print 한다
			case "t2btng_print":
			case "t3btng_print":
				fromObj[0] = formObject;                            // RD 로 보내기 위해 배열로담는다
				if (srcName == "t1btng_print")                      rdObj[0] = sheetObject;     // Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다
				if (srcName == "t2btng_print")                      rdObj[0] = sheetObject1;    // Discrepancy 에 sheet를 RD로 보내기 위해 배열로 담는다
				if (srcName == "t3btng_print")                      rdObj[0] = sheetObject2;    // Invoice Only 에 sheet를 RD로 보내기 위해 배열로 담는다

				if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
				{
					errMsg = ComGetMsg("TRS90001");
					ComShowMessage(errMsg);
					return;
				}
				// RD 로 보내기 위한 설정
				parmObj[0] = "1";
				parmObj[1] = "";
				parmObj[2] = "N";
				parmObj[3] = RD_path+"apps/alps/esd/trs/invoicemanage/railinvoiceaudit/report/ESD_TRS_0926.mrd";     // RD 화면
				parmObj[4] = rdObj;
				parmObj[5] = fromObj;
				rdObjModaless(RdReport, parmObj , 1000 ,700);
				break;   
				
			 case "t4btng_downexce":
				doActionIBSheet2(sheetObject3,formObject,IBDOWNEXCEL);
				break;

			case 'btng_downexcel_1':
				doActionIBSheet2(sheetObject,formObject,IBDOWNEXCEL);
				break;

			case 'btng_downexcel_2':
				doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
				break;

			case 'btng_downexcel_3':
				doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
				break;
				
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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

	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	ComEnableObject(document.form.payment_vndr_code, false);
	ComEnableObject(document.form.payment_vndr_name, false);
	getRailVendorComboList(document.rail_road_code , rail_road_codeCode , rail_road_codeText , '');                           // Serveic Provider 멀티 콤보 (Rail Load) 설정
	initVendorCombo(document.rail_road_code);       // 공통스크립트  
	document.form.inv_no.focus();

	if ( ! ComIsEmpty(document.form.editflag))    tabObjects[0].TabEnable(3) = false;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var flag = false;
	
	if (sheetNo == 1 ){           // Coincidence - Additional Amout 입력 불가
		 flag = false ;
	} else {                      // Discrepancy - Additional Amout 입력 가능
		 flag = true;
	   
	}
	 
	switch(sheetNo) {
		case 1:      //sheet1 init
		case 2:      //sheet 2 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(12);
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(42, 7, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false,false)

				 var HeadTitle = "Del.|STS||Pay|COM|CNTR No.|TP/SZ|Full\nEmpty|DRP|From Node|From Node|To Node|To Node|ALPS\nCurrency|ALPS Fuel\nSurcharge|ALPS HzdMtrl\nSurcharge|ALPS ETC\nSurcharge|ALPS Overweight\nSurcharge|ALPS Total\nAmount|Invoice\nOrigin|Invoice \nDestination"
								+"|Invoice\nCurrency|Billed \nAmount|Additional \nAmount|Invoice \nAmount|Rail Billing\nDate|Waybill\nDate|Waybill\nNo|Invoice Remark|Originally|Veirty\nResult|Sub Invioce\nSeq";
				if (sheetNo == "1")
				{
					dtType = dtRadioCheck;
				} else {
					dtType = dtCheckBox;                        
				}
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,   	30, daCenter,  	true,    	"dflag",        				false,          "",       dfNone,    0,     false,       true,   2,     false,    false,   "",  false);
				InitDataProperty(0, cnt++ , dtStatus,     		30, daCenter,  	true,    	"ibflag",        				false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtCheckBox,   		30, daCenter,  	true,    	"sel");                                                                  
				InitDataProperty(0, cnt++ , dtCheckBox,   		40, daCenter,  	true,    	"pay_flg" ,       				false,          "",       dfNone,    0,     true,       true , -1, false , true , '' , true);                        
				InitDataProperty(0, cnt++ , dtData,       		60, daCenter,  	true,    	"trsp_inv_co_ind_cd",        	false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       		80, daCenter,  	true,    	"eq_no",        				false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       		40, daCenter,  	true,    	"eq_tpsz_cd",        			false,          "",       dfNone,    0,     false,      false);

				InitDataProperty(0, cnt++ , dtCombo,       		50, daCenter,  	true,    	"cgo_tp_cd",        			false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtCheckBox,       	40, daCenter,  	true,    	"dmst_repo_flg",        		false,          "",       dfNone,    0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,       		50, daCenter,  	true,    	"fm_nod_cd1",        			false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		20, daCenter,  	true,    	"fm_nod_cd2",        			false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		50, daCenter,  	true,    	"to_nod_cd1",        			false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		20, daCenter,  	true,    	"to_nod_cd2",        			false,          "",       dfNone,    0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtCombo,      		60, daCenter,  	true,    	"curr_cd",        				false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"fuel_scg_amt",        			false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"hzd_mtrl_scg_amt",        		false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"etc_add_amt",        			false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"ovr_wgt_scg_amt",        		false,          "",       dfFloat,    2,     false,       false);                    
				InitDataProperty(0, cnt++ , dtData,       		70, daRight,  	true,    	"ttl_amt",        				false,          "|bzc_amt|+|fuel_scg_amt|+|hzd_mtrl_scg_amt|+|etc_add_amt|+|ovr_wgt_scg_amt|",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,      	   100, daLeft,  	true,    	"inv_org_nod_nm",        		false,          "",       dfNone,    0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,      	   100, daLeft,  	true,    	"inv_dest_nod_nm",        		false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtCombo,      		60, daCenter,  	true,   	"inv_curr_cd",        			false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		70, daRight,  	true,    	"inv_bil_amt",        			false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		70, daRight,  	true,    	"inv_etc_add_amt",    			false,          "|inv_bzc_amt|-|inv_bil_amt|",		dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		60, daRight,  	true,    	"inv_bzc_amt",        			false,          "",       dfFloat,    2,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       		80, daCenter,  	true,    	"rail_bil_dt",        			false,          "",       dfDateYmd,    0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,       		80, daCenter,  	true,    	"wbl_dt",        				false,          "",       dfDateYmd,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		60, daCenter,  	true,    	"wbl_no",        				false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,      	   150, daLeft,  	true,    	"inv_rmk",        				false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       		50, daCenter,  	true,    	"org_trsp_rail_inv_aud_cd",     false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		80, daCenter,  	true,    	"result",        				false,          "",       dfNone,    0,     false,       false);
									
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"sub_inv_seq");
				
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"fm_nod_cd",        			false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"to_nod_cd",        			false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"crnt_trsp_rail_inv_aud_cd");
				InitDataProperty(0, cnt++ , dtSeq,      	   100, daCenter,  	true,    	"eq_seq");
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"trsp_so_ofc_cty_cd",        	false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"trsp_so_seq",        			false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"sub_rail_seq");
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"trsp_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,       	60, daRight,  	true,    	"org_inv_bzc_amt",        		false,          "",       dfFloat,    2,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"bzc_amt",        				false,          "",       dfFloat,    2,     false,       false);
				
				ColHidden ("eq_seq") = true;
				InitDataCombo(0, 'cgo_tp_cd', " |"+cgo_tp_cdText, " |"+cgo_tp_cdCode);
				InitDataCombo(0, 'inv_curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
				InitDataCombo(0, 'curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
				InitDataCombo(0, 'trsp_inv_co_ind_cd', " |"+trsp_inv_co_ind_cdText, " |"+trsp_inv_co_ind_cdCode);
		   }
			break;
		case 3:      //sheet 3 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(12);
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(42, 7, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false,false)

				var HeadTitle = "Del.|STS||Pay|COM|CNTR No.|TP/SZ|Full\nEmpty|DRP|From Node|From Node|To Node|To Node|ALPS\nCurrency|ALPS Fuel\nSurcharge|ALPS HzdMtrl\nSurcharge|ALPS ETC\nSurcharge|ALPS Overweight\nSurcharge|ALPS Total\nAmount|Invoice\nOrigin|Invoice \nDestination"
								+"|Invoice\nCurrency|Billed \nAmount|Additional \nAmount|Invoice \nAmount|Rail Billing\nDate|Waybill\nDate|Waybill\nNo|Invoice Remark|Originally|Veirty\nResult|Sub Invioce\nSeq";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,   	30, daCenter,  	true,    	"dflag",        				false,          "",       dfNone,    0,     true,       true,   2,     false,    false,   "",  false);
				InitDataProperty(0, cnt++ , dtStatus,     		30, daCenter,  	true,    	"ibflag",        				false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtCheckBox,   		30, daCenter,  	true,    	"sel");                                                                  
				InitDataProperty(0, cnt++ , dtCheckBox,   		40, daCenter,  	true,    	"pay_flg",       				false,          "",       dfNone,          0,     true,       true , -1, false , true , '' , true);                       
				InitDataProperty(0, cnt++ , dtData,       		60, daCenter,  	true,    	"trsp_inv_co_ind_cd",        	false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       		80, daCenter,  	true,    	"eq_no",        				false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,       		40, daCenter,  	true,    	"eq_tpsz_cd",        			false,          "",       dfNone,    0,     false,      false);

				InitDataProperty(0, cnt++ , dtCombo,       		50, daCenter,  	true,    	"cgo_tp_cd",        			false,          "",       dfNone,    0,     true,      true);
				InitDataProperty(0, cnt++ , dtCheckBox,       	40, daCenter,  	true,    	"dmst_repo_flg",        		false,          "",       dfNone,    0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,       		50, daCenter,  	true,    	"fm_nod_cd1",        			false,          "",       dfEngUpKey,    0,     true,       true ,5 , true);
				InitDataProperty(0, cnt++ , dtCombo,       		30, daCenter,  	true,    	"fm_nod_cd2",        			false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       		50, daCenter,  	true,    	"to_nod_cd1",        			false,          "",       dfEngUpKey,    0,     true,       true ,5 , true);
				InitDataProperty(0, cnt++ , dtCombo,       		30, daCenter,  	true,    	"to_nod_cd2",        			false,          "",       dfNone,    0,     true,       true);
				
				InitDataProperty(0, cnt++ , dtCombo,      		60, daCenter,  	true,    	"curr_cd",        				false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"fuel_scg_amt",        			false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"hzd_mtrl_scg_amt",        		false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"etc_add_amt",        			false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"ovr_wgt_scg_amt",        		false,          "",       dfFloat,    2,     false,       false);   
				InitDataProperty(0, cnt++ , dtData,       		70, daRight,  	true,    	"ttl_amt",        				false,          "|bzc_amt|+|fuel_scg_amt|+|hzd_mtrl_scg_amt|+|etc_add_amt|+|ovr_wgt_scg_amt|",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,      	   100, daLeft,  	true,    	"inv_org_nod_nm",        		false,     		"",       dfNone,    0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,      	   100, daLeft,  	true,    	"inv_dest_nod_nm",        		false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtCombo,      		60, daCenter,  	true,    	"inv_curr_cd",        			false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		70, daRight,  	true,    	"inv_bil_amt",        			false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		70, daRight,  	true,    	"inv_etc_add_amt",    			false,          "",		  dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       		60, daRight,  	true,    	"inv_bzc_amt",        			false,          "",       dfFloat,    2,     flag,       true);
				InitDataProperty(0, cnt++ , dtData,       		80, daCenter,  	true,    	"rail_bil_dt",        			false,          "",       dfDateYmd,    0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,       		80, daCenter,  	true,    	"wbl_dt",        				false,          "",       dfDateYmd,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,       		60, daCenter,  	true,    	"wbl_no",        				false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,      	   150, daLeft,  	true,		"inv_rmk",        				false,          "",       dfNone,    0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       	    50, daCenter,  	true,    	"org_trsp_rail_inv_aud_cd",     false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       	    80, daCenter,  	true,    	"result",        				false,          "",       dfNone,    0,     false,       false);
									
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"sub_inv_seq",        			false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"fm_nod_cd",        			false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"to_nod_cd",        			false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"crnt_trsp_rail_inv_aud_cd");
				InitDataProperty(0, cnt++ , dtSeq,      	   100, daCenter,  	true,    	"eq_seq");
				InitDataProperty(0, cnt++ , dtHidden,          100, daCenter,  	true,    	"trsp_so_ofc_cty_cd",        	false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"trsp_so_seq",        			false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"sub_rail_seq");
				InitDataProperty(0, cnt++ , dtHidden,      	   100, daCenter,  	true,    	"trsp_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,       	60, daRight,  	true,    	"org_inv_bzc_amt",        		false,          "",       dfFloat,    2,     flag,       true);
                InitDataProperty(0, cnt++ , dtHidden,       	70, daRight,  	true,    	"bzc_amt",        				false,          "",       dfFloat,    2,     false,       false);
				
				ColHidden ("eq_seq") = true;
				InitDataCombo(0, 'cgo_tp_cd', " |"+cgo_tp_cdText, " |"+cgo_tp_cdCode);
				InitDataCombo(0, 'inv_curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
				InitDataCombo(0, 'curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
				InitDataCombo(0, 'trsp_inv_co_ind_cd', " |"+trsp_inv_co_ind_cdText, " |"+trsp_inv_co_ind_cdCode);
				
				InitDataValid(0, "fm_nod_cd1", vtEngOther) ;
				InitDataValid(0, "to_nod_cd1", vtEngOther) ;
		   }
			break;
		case 4:      //sheet 3 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
									
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(1, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false,false)

				var HeadTitle = "Del.";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,   30,    daCenter,  true,    "dflag",        false,          "",       dfNone,    0,     true,       true,   2,     false,    false,   "",  false);
		   }
			break;
		case 5:      //sheet 4 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(10);
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(4, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false,false)

				var HeadTitle = "eq_seq|eq_no|result|sts";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "wbl_dt",        false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,    "eq_no",        false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "result",        false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtHiddenStatus,     30,    daCenter,  true,    "ibflag",        false,          "",       dfNone,    0,     false,      true);
			}
			break;

		case 6:      //sheet 4 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
									
				//전체 너비 설정
				SheetWidth = 0;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, false, true, true, false,false)

				var HeadTitle = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       0,    daCenter,  true,    "trsp_so_ofc_cty_cd_seq",	false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,       0,    daCenter,  true,    "sheetNo",				false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,       0,    daCenter,  true,    "row",					false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       0,    daCenter,  true,    "eq_no",				false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtStatus,     30,   daCenter,  true,    "ibflag",				false,          "",       dfNone,    0,     false,      true);
			}
			break;
	}
}

/**
 * Invoice Only 탭에서 Form Node 에 뒤에 2자리 To Node 에 뒤에 2자리에 대한 선택시 이벤트 처리
 */
function t3sheet1_OnClick(sheetObj, row , col) {
if( sheetObj.ReadDataProperty(row, col, dpDataType) == 6 ) {
	if( sheetObj.ColSaveName(col) == "fm_nod_cd2" ) {
		value = ComTrimAll(sheetObj.CellValue(row, "fm_nod_cd1"), " ");
		if( value.length > 0 ) {
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		} else {
			sheetObj.CellValue2(row, "fm_nod_cd1") = "";
		}
	} else if( sheetObj.ColSaveName(col) == "to_nod_cd2" ) {
		value = ComTrimAll(sheetObj.CellValue(row, "to_nod_cd1"), " ");
		if( value.length > 0 ) {
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		} else {
			sheetObj.CellValue2(row, "to_nod_cd1") = "";
		}
	} 
}
}


/**
 * sheet cell value 변경시 발생하는 이벤트
 **/
function t1sheet1_OnChange(sheetObj, row, col, value){
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){
		case 'inv_bzc_amt':
			if( sheetObj.CellValue(row , "pay_flg") == 1 ){
				setTotalAmtForPaymentBySheetChange(row, 0, 0);
			}else{
				setTotalAmtForPaymentBySheetChange(row, 0, 0);
			}
		break;
		case 'pay_flg':
			setTotalAmtForPaymentBySheetChange(row, 0, 0);
		break;
	}
}

/**
 * sheet cell value 변경시 발생하는 이벤트
 **/
function t2sheet1_OnChange(sheetObj, row, col, value){
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){
		case 'inv_bzc_amt':
			if( sheetObj.CellValue(row , "pay_flg") == 1 ){
				setTotalAmtForPaymentBySheetChange(0, row, 0);
			}else{
				setTotalAmtForPaymentBySheetChange(0, row, 0);
			}
		break;
		case 'pay_flg':
			setTotalAmtForPaymentBySheetChange(0, row, 0);
		break;
	}
}

/**
 * Invoice Only 탭에서 Form Node 에 To Node 에 대한 데이타 변동시 이벤트 처리
 */
function t3sheet1_OnChange(sheetObj , row , col , value)
{
	var colSaveName = sheetObj.ColSaveName(col);
	if ( colSaveName == "fm_nod_cd1")
	{
		if(value.length != "5")
		{
			errMsg = ComGetMsg("COM12174", "From Node" , "5" );
			ComShowMessage(errMsg);
			sheetObj.CellValue2(row, "fm_nod_cd1") = "";
			sheetObj.CellValue2(row, "fm_nod_cd2") = "";
			return;
		} else{
			sheetObj.CellValue2(row, col) = value.toUpperCase();
		}
	} else if (colSaveName == "to_nod_cd1"){
		if(value.length != "5")
		{
			errMsg = ComGetMsg("COM12174", "To Node" , "5" );
			ComShowMessage(errMsg);
			sheetObj.CellValue2(row, "to_nod_cd1") = "";
			sheetObj.CellValue2(row, "to_nod_cd2") = "";
			return;
		} else{
			sheetObj.CellValue2(row, col) = value.toUpperCase();
		}
	}

   if( colSaveName == "fm_nod_cd1" || colSaveName == "fm_nod_cd2" || colSaveName == "to_nod_cd1" || colSaveName == "to_nod_cd2")
   {
	   sheetObj.CellValue2(row , "fm_nod_cd") = sheetObj.CellValue(row , "fm_nod_cd1")+sheetObj.CellValue(row , "fm_nod_cd2");
	   sheetObj.CellValue2(row , "to_nod_cd") = sheetObj.CellValue(row , "to_nod_cd1")+sheetObj.CellValue(row , "to_nod_cd2");
   }
   
   switch(colSaveName){
		case 'eq_no':
			findRow = sheetObjects[0].FindText ("eq_no" , value , sheetObjects[0].HeaderRows );
			if ( findRow != "-1")
			{
				errMsg = ComGetMsg("TRS90009" , value);
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row , col) = "";
				return;
			}
			document.form.cntr_no.value = value;
			document.form.seq.value = row;
			doActionIBSheet2(sheetObjects[2] , document.form , IBROWSEARCH);
		break;
   
		case 'inv_bzc_amt':
			if( sheetObj.CellValue(row , "pay_flg") == 1 ){
				setTotalAmtForPaymentBySheetChange(0, 0, row);
			}else{
				setTotalAmtForPaymentBySheetChange(0, 0, row);
			}
		break;
		case 'pay_flg':
			setTotalAmtForPaymentBySheetChange(0, 0, row);
		break;
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction , flag) {

	switch(sAction) {

	   case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESD_TRS_0038GS.do", TrsFrmQryString(formObj));
			var arrXml = sXml.split("|$$|");			
			setEtcData(sheetObj, arrXml);
			sheetObj.ShowDebugMsg = false;
			break;
			
	   case IBSAVE:      //저장
			 formObj.f_cmd.value = MODIFY;
			 issue_dt = formObj.issue_dt.value.replace(/\/|\-|\./g , "");
			 receive_dt = formObj.receive_dt.value.replace(/\/|\-|\./g , "");
			 formObj.issue_dt.value = issue_dt;
			 formObj.receive_dt.value = receive_dt;
			 formObj.invoice_amt.value = ComTrimAll(formObj.invoice_amt.value,",");
			 formObj.vat_amt.value = ComTrimAll(formObj.vat_amt.value,",");
			 formObj.total_amt.value = ComTrimAll(formObj.total_amt.value,",");
			 formObj.sts_cd.value = flag;
			 setCntrRailInvAudCd();
			 var SaveStr = sheetObjects[0].GetSaveString(true, true);
			 var SaveStr1 = sheetObjects[1].GetSaveString(true, true);
			 var SaveStr2 = sheetObjects[2].GetSaveString(true, true);
			 var sXml = sheetObjects[beforetab].GetSaveXml("ESD_TRS_0038GS.do",TrsFrmQryString(formObj)+"&"+SaveStr+"&"+SaveStr1+"&"+SaveStr2);
			 sheetObjects[4].LoadSaveXml(sXml, false);
		   break;
			
	   case IBROWSEARCH:      //조회
			formObj.f_cmd.value = SEARCH10;
			sheetObj.DoRowSearch ("ESD_TRS_0038GS.do", TrsFrmQryString(formObj));
			ComEtcDataToForm(formObj ,sheetObj);
			
			var flag = sheetObj.EtcData("flag");
			sheetObj.RemoveEtcData();

			if ( flag > 0)
			{
				formObj.inv_no.value="";
				errMsg = ComGetMsg("TRS90004" );
				ComShowMessage(errMsg);
			}
			sheetObj.ShowDebugMsg = false;
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction) {

	switch(sAction) {

	   case IBSEARCH:      //조회

			break;
			
	   case IBINSERT:      //입력
			var row = sheetObj.DataInsert (-1);
			sheetObj.CellValue2(row , "org_trsp_rail_inv_aud_cd") = "I";
			sheetObj.CellValue2(row , "crnt_trsp_rail_inv_aud_cd") = "I";
			sheetObj.CellValue2(row , "trsp_inv_tp_cd") = "M";
			sheetObj.CellValue2(row , "inv_curr_cd") = formObj.currency.options[formObj.currency.selectedIndex].value;
			break;
			
	   case IBSAVE:      //저장
			break;
			
	   case IBROWSEARCH:      //조회
			formObj.f_cmd.value = SEARCH20;
			sheetObj.DoRowSearch ("ESD_TRS_0038GS.do", TrsFrmQryString(formObj));
			sheetObj.ShowDebugMsg = false;
			
			if ( sheetObj.CellValue( formObj.seq.value , "eq_tpsz_cd") == "")
			{
				sheetObj.CellValue2( formObj.seq.value , "eq_no") = "";
			}
			break;
			
	   case IBDOWNEXCEL:        //엑셀 업로드
		  sheetObj.SpeedDown2Excel (-1);
		  break;
		
	}
}

 /**
 * Coincidence 을 저장후 발생하는 이벤트 
 */
function t1sheet1_OnSaveEnd( sheetObj, errMsg )
{
	if(errMsg != "")  return;
			 
		 if ( document.form.sts_cd.value=="CF")
		 {

			 for( i = 0 ; i < sheetObjects[0].RowCount+1 ; i++)
			 {
				  sheetObjects[0].CellEditable (i , "inv_bzc_amt") = false;
			 }

			 for( i = 0 ; i < sheetObjects[1].RowCount+1 ; i++)
			 {
				  sheetObjects[1].CellEditable (i , "inv_bzc_amt") = false;
			 }

			 for( i = 0 ; i < sheetObjects[2].RowCount+1 ; i++)
			 {
				  sheetObjects[2].CellEditable (i , "inv_bzc_amt") = false;
			 }
		 } 
		document.form.receive_dt.focus();
		document.form.issue_dt.focus();
		document.form.invoice_amt.focus();
		document.form.vat_amt.focus();
		document.form.vat_amt.blur();
		
		doActionIBSheet(sheetObjects[0] ,document.form , IBSEARCH );
}

function sheet2_OnSaveEnd( sheetObj , errMsg)
{
	var formObj = document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == MODIFY){
			var msgStr = null;
			if( formObj.sts_cd.value == 'CF'){
				msgStr = 'Confirm';
				formObj.editflag.value = 'N';
				sheetObjects[0].Editable = false;
				sheetObjects[1].Editable = false;
				sheetObjects[2].Editable = false;
				sheetObjects[3].Editable = false;
			}else{
				msgStr = 'Save';
			}
			ComShowCodeMessage('COM12116', msgStr);
		}
	}
}

 /**
 * Discrepancy 을 조회 발생하는 이벤트 
 */
function t2sheet1_OnSearchEnd(sheetObj , errMsg)
{
	if (errMsg != "")   return ;
	
	document.form.insflag.value = "false";        // 입력 상태를 수정 상태로 전환 
}

function sheet2_OnSearchEnd(sheetObj , errMsg)
{
	if ( errMsg != "")     return ;
	
	for ( i =  sheetObj.HeaderRows ; i < sheetObj.RowCount+1 ; i++)
	{
	   findidx = sheetObjects[0].FindText("eq_no" , sheetObj.CellValue( i , "eq_no") , sheetObj.HeaderRows);
	   if( findidx != "-1") {
		   if( sheetObjects[0].CellValue( findidx , "wbl_dt") = sheetObj.CellValue(i , "wbl_dt"))
		   {
			   sheetObjects[0].CellValue2( findidx , "result") = sheetObj.CellValue(i , "result");
		   }
	   }
	   
	   findidx = sheetObjects[1].FindText("eq_no" , sheetObj.CellValue( i , "eq_no") , sheetObj.HeaderRows);
	   if( findidx != "-1") {
		   if( sheetObjects[1].CellValue( findidx , "wbl_dt") = sheetObj.CellValue(i , "wbl_dt"))
		   {
			   sheetObjects[1].CellValue2( findidx , "result") = sheetObj.CellValue(i , "result");
		   }
	   }
	   
	   findidx = sheetObjects[2].FindText("eq_no" , sheetObj.CellValue( i , "eq_no") , sheetObj.HeaderRows);
	   if( findidx != "-1") {
		   if( sheetObjects[2].CellValue( findidx , "wbl_dt") = sheetObj.CellValue(i , "wbl_dt"))
		   {
			   sheetObjects[2].CellValue2( findidx , "result") = sheetObj.CellValue(i , "result");
		   }
	   }
	}
}
 /**
 * ETC정보를 처리
 */
function setEtcData(sheetObj, arrXml)
{
	if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
	if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
	if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
	
	trsp_inv_aud_sts_cd = sheetObjects[0].EtcData('trsp_inv_aud_sts_cd');
	
	if ( trsp_inv_aud_sts_cd != "CF"){
		sheetObjects[0].EtcData('payment_vndr_code') = document.form.payment_vndr_code.value;
	}
	ComEtcDataToForm(document.form ,sheetObj);
	sheetObj.RemoveEtcData();	
	
	document.form.receive_dt.focus();
	document.form.issue_dt.focus();
	document.form.invoice_amt.focus();
	document.form.vat_amt.focus();
	document.form.vat_amt.blur();
}

 /**
 * ETC정보가 undefined 이면 "" 으로 처리
 */
function setEtcEmptyCheck(etcData)
{
	if ( etcData == "undefined")
	{
		return "";
	} else
	{
		return etcData ;
	}
}

function checkInputData(formObject)
{
	 if ( ComIsEmpty(formObject.inv_no))
	 {
		formErrMsg("Invoice No");
		formObject.inv_no.focus();
		return false;
	 }
	 if ( ComIsEmpty(formObject.receive_dt))
	 {
		formErrMsg("Receive Date");
		formObject.receive_dt.focus();
		return false;
	 }

	 if ( ComIsEmpty(formObject.issue_dt))
	 {
		formErrMsg("Issus Date");
		formObject.issue_dt.focus();
		return false;
	 }
	 
	 if ( ComIsEmpty(formObject.rail_road_name))
	 {
		formErrMsg("Rail Road");
		rail_road_code.focus();
		return false;
	 }

	 if ( ComIsEmpty(formObject.invoice_amt))
	 {
		formErrMsg("Invoice AMT");
		formObject.invoice_amt.focus();
		return false;
	 }
	 
	 if ( ComIsEmpty(formObject.vat_amt))
	 {
		formErrMsg("V.A.T AMT");
		formObject.vat_amt.focus();
		return false;
	 }
	 return true;
		
}

 /**
 * sheet  에 필수입력 처리
 */
function checkSheetData()
{
	
	var checkList = sheetObjects[2].FindCheckedRow('pay_flg');
	var checkArray = checkList.split('|');

	for (var idx=0; idx<checkArray.length-1; idx++){
		if(ComTrim(sheetObjects[2].CellValue( checkArray[idx] , "eq_no")) == "")
		{
			errMsg = ComGetMsg("COM12120" ,  checkArray[idx] , "CNTR No.");
			ComShowMessage(errMsg);
			sheetObjects[2].SelectCell( checkArray[idx], "eq_no");
			return true;
		}
		 if (ComTrim(sheetObjects[2].CellValue( checkArray[idx] , "cgo_tp_cd")) == "")
		 {
			errMsg = ComGetMsg("COM12130" ,  sheetObjects[2].CellValue(checkArray[idx] , "eq_no") , "Full/Empty");
			ComShowMessage(errMsg);
			sheetObjects[2].SelectCell( checkArray[idx], "cgo_tp_cd" , true);
			return true;
		 }
		 
		 if (ComTrim(sheetObjects[2].CellValue( checkArray[idx] , "fm_nod_cd1")) == "")
		 {
			errMsg = ComGetMsg("COM12130" ,  sheetObjects[2].CellValue(checkArray[idx] , "eq_no") , "From Node");
			ComShowMessage(errMsg);
			sheetObjects[2].SelectCell( checkArray[idx], "fm_nod_cd1" , true);
			return true;
		 }
		 
		 if (ComTrim(sheetObjects[2].CellValue( checkArray[idx] , "to_nod_cd1")) == "")
		 {
			errMsg = ComGetMsg("COM12130" ,  sheetObjects[2].CellValue(checkArray[idx] , "eq_no") , "To Node");
			ComShowMessage(errMsg);
			sheetObjects[2].SelectCell( checkArray[idx], "to_nod_cd1", true);
			return true;
		 }
		 
		 if (sheetObjects[2].CellValue( checkArray[idx] , "inv_bzc_amt") <= 0)
		 {
			errMsg = ComGetMsg("TRS90005" ,  sheetObjects[2].CellValue(checkArray[idx] , "eq_no") , "Invoice Amount");
			ComShowMessage(errMsg);
			sheetObjects[2].SelectCell( checkArray[idx], "inv_bzc_amt", true);
			return true;
		 }
	}
	return false;
}

function chkCntr(sheetObj)
{
	var cntr_no ;
		if(sheetObj.CheckedRows('sel') != "1")  return true;
		else {
			cntr_no = sheetObj.FindCheckedRow('sel');
			document.form.cntr_no.value = sheetObj.CellValue(cntr_no.substring(0, cntr_no.length-1),'eq_no');
			if (document.form.cntr_no.value == "")
			{
				return true;
			}
			return false;
		}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;

}


/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {

	 switch(tabNo) {
		 case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++ , "Coincidence " , -1 );
				InsertTab( cnt++ , "Discrepancy " , -1 );
				InsertTab( cnt++ , "Invoice Only" , -1 );
			}
		 break;

	 }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{


	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;

}

function rail_road_code_OnBlur (combo) {
	var finded = combo.FindIndex(combo.Text() , 0);

	 if ( document.form.rail_road_name.value ==  combo.GetText(finded,1))  return;

	document.form.rail_road_name.value = combo.GetText(combo.Code , 1);
	searchVendorName(combo);
}

/**
* Rail Road combo 선택시 textfield의 값 변경하는 이벤트
**/
function rail_road_code_OnChange(combo, Index_Code, Text) {

	if ( ! ComIsEmpty(document.form.editflag) ) return ;

	if ( document.form.rail_road_name.value == Text )  return;
	
	document.form.rail_road_name.value = combo.GetText(Index_Code,1);
	
	doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);
}

function searchVendorName(combo) {
	
	if ( ! ComIsEmpty(document.form.editflag) ) return ;
	 
	var formObject = document.form;
	document.rail_road_code.value = combo.GetText(combo.Text,1);
	
	if ( document.rail_road_code.Text != "")
	{
		
		  doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);
	} else {
			document.form.payment_vndr_code.value = "";
			document.form.payment_vndr_name.value = "";
	}
}

function chkComfirm(formObj)
{
	 if (formObj.trsp_inv_aud_sts_cd.value == "CF")
	 {
		errMsg = ComGetMsg("TRS90002" );
		ComShowMessage(errMsg);
		return true;
	 }
	 return false;
}

function checkWaybillDate(sheetObj){

	var checkList = sheetObj.FindCheckedRow('sel');
	var checkArray = checkList.split('|');

	for(var k=0; k<checkArray.length-1; k++){
		if(sheetObj.CellValue(checkArray[k], 'wbl_dt').length != 8){
			ComShowCodeMessage('COM12114', 'Waybill Date');
			sheetObj.SelectCell(checkArray[k], 'wbl_dt');
			return false;
		}
	}
	return true;

}

/**
 * Error Msg
 */
 function formErrMsg(checkName)
 {
	errMsg = ComGetMsg("COM12114", checkName );
	ComShowMessage(errMsg);
	return ;
 }

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function Minimize(nItem)
{

	var objs = document.all.item("MiniLayer");

	if ( nItem == "1" )
	{
		objs.style.display = "none";

		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(15);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(15);
		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(15);
		sheetObjects[3].style.height = sheetObjects[3].GetSheetHeight(15);

	}
	else
	{
		objs.style.display = "inline";

		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(10);
		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(10);
		sheetObjects[3].style.height = sheetObjects[3].GetSheetHeight(10);
	}

}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick()
{

		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');

}

/**
* 2개 Sheet에서 데이터 이동하기 - 체크된 데이터만 이동하기
* @param : fromSheet - 이동 원본 Sheet의 Object id
* @param : toSheet   - 이동 대상 Sheet의 Object id
* @param : chkCol    - 체크박스 컬럼의 인덱스
* @return : 없음
* @version : 2.4.0.0
* @sample
*  moveSheetData(mySheet1, mySheet2, 2);
*/
function moveSheetData(fromSheet, toSheet, chkCol)  {

  //데이터 행의 개수 확인
  var toRow = toSheet.RowCount;

  //원본에서 역순으로 Check 된 데이터를 확인하여 이동
  for (ir = fromSheet.RowCount; ir>= 1; ir--) {
	//Check 되지 않은 경우 건너뜀
	if (fromSheet.CellValue(ir, chkCol) == '0') continue;

	//데이터 행 추가
	toRow = toSheet.DataInsert(toRow);

	//데이터 옮기기
	for (ic = 0; ic<=fromSheet.LastCol; ic++) {
	  //체크 컬럼은 빼고 옮김
	  if (ic == chkCol) continue;
	  
	  if ( fromSheet.ColSaveName(ic) == "crnt_trsp_rail_inv_aud_cd")
	  {
		 toSheet.CellValue(toRow,ic) = "C";
	  } else {
		  toSheet.CellValue(toRow,ic) = fromSheet.CellValue(ir,ic);              
	  }

	}
	toSheet.RowStatus(toRow) =  fromSheet.RowStatus(ir);
	//원본에서 지움
	fromSheet.CellValue(ir, "pay_flg") = 0;
	fromSheet.RowDelete(ir, false);
	toRow--;
  }
}

 function setAuditInquiry( inv_no , inv_vndr_seq)
 {
	 if ( ComIsEmpty(document.form.editflag))    return;
	 sheetObjects[0].WaitImageVisible = false;
	 ComOpenWait(true);
	 
	ComEnableObject(document.form.inv_no, false);
	ComEnableObject(document.form.receive_dt, false);
	ComEnableObject(document.form.issue_dt, false);
	ComEnableObject(document.form.total_amt, false);
	ComEnableObject(document.form.rail_road_name, false);
	ComEnableObject(document.form.currency, false);
	document.rail_road_code.Enable  =false
	document.form.inv_no.value = inv_no;
	document.form.payment_vndr_code.value = inv_vndr_seq;
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	sumAmt();
	setTotalAmtForPayment();
	ComOpenWait(false);
	sheetObjects[0].WaitImageVisible = true;
 }
/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {

	var formObj = document.form;
	var comboObj = document.rail_road_code;
	
	for(var i=0; i<rowArray.length; i++)
	{

		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[4];

		comboObj.InsertItem(comboObj.GetCount(), colArray2+'|'+colArray3, colArray2);

		comboObj.Text = colArray2;
		document.form.rail_road_name.value = comboObj.GetText(comboObj.Text, 1);
	}
}

function checkDateFormat(dt){
	var date_regexp = "^(\\d{4}-\\d{2}-\\d{2})$";
	if (!checkFormat(dt, date_regexp)){
		return false;
	}
	return true;
}	

function BlurDate(obj){
   if (obj.value == "")
   {
	   return;
   }
   if ( !ComIsDate(obj) ){
		errMsg = ComGetMsg("COM12179");
		ComShowMessage(errMsg);
		obj.focus();
		return ;
	} else {
	   rsdate = addBar(obj.value);
	   obj.value = rsdate;
	}
}

function checkInvoiceName()
{
	document.form.inv_no.value = document.form.inv_no.value.toUpperCase()
	if ( ! ComIsEmpty(document.form.editflag) )
	{
		return false;
	}
	if ( ComIsEmpty(document.form.inv_no) || document.rail_road_code.Text == "" )
	{
		return;
	} else {
		doActionIBSheet(sheetObjects[0] , document.form , IBROWSEARCH);        // Invocie No + Paymanet Vndr 유효성 체크
	}
}
//날자포맷으로 yyyy-mm-dd
function addBar(dt) 
{
	var dat="";
	if( dt.length == 8 )
  {
	dat = dt.substr(0,4) + '-' + dt.substr(4,2) + '-' + dt.substr(6,2);
  }
	 return dat; 
}

function fun_Focus_del(obj)
{
	date = obj.value.replace(/\/|\-|\./g , "");
	obj.value = date;
}
function checkFormat(object, regexp){
	// 주어진 값이 정규식에 일치하는지 확인하고 맞으면 true를 틀릴경우 false를 return한다.
	if (object == null || object == ""){
		return false;
	} else {
		re = new RegExp(regexp,"gi"); //'gi'는 case-insensitive global match를 위함이다
		if (!re.test(object)){
			return false;
		}
	}
	return true;
}


function sumAmt()
{
	var invoice_amt = 0;
	var vat_amt = 0;
	if ( document.form.invoice_amt.value != "")
	{
		 invoice_amt = ComTrimAll(document.form.invoice_amt.value) ;
	}
	if ( document.form.vat_amt.value != "")
	{
		 vat_amt = ComTrimAll(document.form.vat_amt.value);
	}
	document.form.total_amt.value = ComAddComma((parseFloat(ComTrimAll(invoice_amt, ",")*100)+parseFloat(ComTrimAll(vat_amt, ",")*100))/100);
	chkAmtFmtObj(document.form.total_amt);
}

function isMon(obj, isChkFmt){
	//통화만 -> 숫자,.까지  + 소숫점 이하 2자리만 허용
	if (!ComIsNumber(obj,'-.,')){
		obj.value = '';
	}

	if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
		var src = ComTrimAll(obj.value);
		if (src.indexOf('.') != -1){
			if (src.length-1 > src.indexOf('.')+2){
				src = src.substring(0,src.indexOf('.')+3);
				obj.value = src;
			}
			if (src.indexOf('.') != src.lastIndexOf('.')){
				src = src.substring(0,src.lastIndexOf('.'));
				//obj.value = src;
				obj.value = chkAmtFmt(src);
			}
		}
	}
}

function chkAmtFmtObj(obj){
	if (obj==undefined || obj.value==null || ComTrim(obj.value)==''){
		return false;
	}
	obj.value = chkAmtFmt(obj.value);
}

function chkAmtFmt(src){
	
	if (src==undefined || src==null || ComTrim(src)==''){
		return false;
	}

	var src = ComTrimAll(src);
	
	if (src.indexOf('.') == -1){
		src = ComAddComma(src) + '.00'
	} else {
		var temp = src.split(".");
		if (temp.length == 2){
			if (temp[1]==null || ComTrim(temp[1])==''){temp[1] = '00';}
			if (temp[1].length == 1){temp[1] += '0';
			} else if (temp[1].length == 2){
			} else if (temp[1].length > 2){temp[1] = temp[1].substring(0,2);
			}
			src = ComAddComma(ComTrimAll(temp[0], ","))+'.'+temp[1];
		} else if (temp.length > 2){
			// 두번째 .부터 .를 다 삭제하고 재계산하기 
			var tmp_str = '';
			for (var i=1; i<temp.length; i++){
				tmp_str += ComTrim(new String(temp[i]));
			}
			if (tmp_str==null || ComTrim(tmp_str)==''){tmp_str = '00';}
			if (tmp_str.length == 1){tmp_str += '0';				
			} else if (tmp_str.length == 2){
			} else if (tmp_str.length > 2){tmp_str = tmp_str.substring(0,2);  
			}
			src = ComAddComma(temp[0])+'.'+tmp_str;
		} else {
			return false;
		}
	}

	return src;
}
	
function getSaveString(params){
	var saveString = null;
	if(params == null){
		saveString = "";
	}else{
		saveString = params.join("&");
	}
	return saveString;
}

function setTotalAmtForPayment(){
	
	var sheetObj_01 = sheetObjects[0];
	var sheetObj_02 = sheetObjects[1];
	var sheetObj_03 = sheetObjects[2];
	var formObj = document.form;

	var checkList = sheetObj_01.FindCheckedRow('pay_flg');
	var checkArray = checkList.split('|');
	var total_amt = 0.00;
	var total_coincidence = 0.00;
	var total_discrepancy = 0.00;
	var total_invoice_only = 0.00;

	for(var i=0; i<checkArray.length-1; i++){
		sheetObj_01.CellValue(checkArray[i], 'org_inv_bzc_amt') = sheetObj_01.CellValue(checkArray[i], 'inv_bzc_amt');
		total_amt += Number(sheetObj_01.CellValue(checkArray[i], 'inv_bzc_amt'));
		total_coincidence += Number(sheetObj_01.CellValue(checkArray[i], 'inv_bzc_amt'));
	}
	formObj.total_amt_coincidence.value = chkAmtPos(total_coincidence);
	checkList = sheetObj_02.FindCheckedRow('pay_flg');
	checkArray = checkList.split('|');
	for(var i=0; i<checkArray.length-1; i++){
		sheetObj_02.CellValue(checkArray[i], 'org_inv_bzc_amt') = sheetObj_02.CellValue(checkArray[i], 'inv_bzc_amt');
		total_amt += Number(sheetObj_02.CellValue(checkArray[i], 'inv_bzc_amt'));
		total_discrepancy += Number(sheetObj_02.CellValue(checkArray[i], 'inv_bzc_amt'));
	}
	formObj.total_amt_discrepancy.value = chkAmtPos(total_discrepancy);
	checkList = sheetObj_03.FindCheckedRow('pay_flg');
	checkArray = checkList.split('|');
	for(var i=0; i<checkArray.length-1; i++){
		sheetObj_03.CellValue(checkArray[i], 'org_inv_bzc_amt') = sheetObj_03.CellValue(checkArray[i], 'inv_bzc_amt')
		total_amt += Number(sheetObj_03.CellValue(checkArray[i], 'inv_bzc_amt'));
		total_invoice_only += Number(sheetObj_03.CellValue(checkArray[i], 'inv_bzc_amt'));
	}
	formObj.total_amt_invoice_only.value = chkAmtPos(total_invoice_only);
	formObj.total_amt_for_payment.value = chkAmtPos(total_amt);
}

function setTotalAmtForPaymentBySheetChange( row1, row2, row3 ){
	
	var sheetObj_01 = sheetObjects[0];
	var sheetObj_02 = sheetObjects[1];
	var sheetObj_03 = sheetObjects[2];
	var formObj = document.form;
	
	if( row1 != 0 ){
		if( sheetObj_01.CellValue(row1, 'pay_flg') == 1 ){
			if( sheetObj_01.CellValue(row1, 'org_inv_bzc_amt') != sheetObj_01.CellValue(row1, 'inv_bzc_amt') ){
				formObj.total_amt_coincidence.value = chkAmtPos( Number( formObj.total_amt_coincidence.value ) - Number(sheetObj_01.CellValue(row1, 'org_inv_bzc_amt')) );
				sheetObj_01.CellValue(row1, 'org_inv_bzc_amt') = sheetObj_01.CellValue(row1, 'inv_bzc_amt');
				formObj.total_amt_coincidence.value = chkAmtPos( Number( formObj.total_amt_coincidence.value ) + Number(sheetObj_01.CellValue(row1, 'inv_bzc_amt')) );				
			}else{
				sheetObj_01.CellValue(row1, 'org_inv_bzc_amt') = sheetObj_01.CellValue(row1, 'inv_bzc_amt');
				formObj.total_amt_coincidence.value = chkAmtPos( Number( formObj.total_amt_coincidence.value ) + Number(sheetObj_01.CellValue(row1, 'inv_bzc_amt')) );				
			}
			
		}else if( sheetObj_01.CellValue(row1, 'pay_flg') == 0 ){
			if( sheetObj_01.CellValue(row1, 'org_inv_bzc_amt') != sheetObj_01.CellValue(row1, 'inv_bzc_amt') ){
				sheetObj_01.CellValue(row1, 'org_inv_bzc_amt') = sheetObj_01.CellValue(row1, 'inv_bzc_amt');
			}else{
				formObj.total_amt_coincidence.value = chkAmtPos( Number( formObj.total_amt_coincidence.value ) - Number(sheetObj_01.CellValue(row1, 'inv_bzc_amt')) );				
			}							
		}		
	}
	
	if( row2 != 0 ){
		if( sheetObj_02.CellValue(row2, 'pay_flg') == 1 ){
			if( sheetObj_02.CellValue(row2, 'org_inv_bzc_amt') != sheetObj_02.CellValue(row2, 'inv_bzc_amt') ){
				formObj.total_amt_discrepancy.value = chkAmtPos( Number( formObj.total_amt_discrepancy.value ) - Number(sheetObj_02.CellValue(row2, 'org_inv_bzc_amt')) );
				sheetObj_02.CellValue(row2, 'org_inv_bzc_amt') = sheetObj_02.CellValue(row2, 'inv_bzc_amt');
				formObj.total_amt_discrepancy.value = chkAmtPos( Number( formObj.total_amt_discrepancy.value ) + Number(sheetObj_02.CellValue(row2, 'inv_bzc_amt')) );				
			}else{
				sheetObj_02.CellValue(row2, 'org_inv_bzc_amt') = sheetObj_02.CellValue(row2, 'inv_bzc_amt');
				formObj.total_amt_discrepancy.value = chkAmtPos( Number( formObj.total_amt_discrepancy.value ) + Number(sheetObj_02.CellValue(row2, 'inv_bzc_amt')) );				
			}
		}else if( sheetObj_02.CellValue(row2, 'pay_flg') == 0 ){
			if( sheetObj_02.CellValue(row2, 'org_inv_bzc_amt') != sheetObj_02.CellValue(row2, 'inv_bzc_amt') ){
				sheetObj_02.CellValue(row2, 'org_inv_bzc_amt') = sheetObj_02.CellValue(row2, 'inv_bzc_amt');
			}else{
				formObj.total_amt_discrepancy.value = chkAmtPos( Number( formObj.total_amt_discrepancy.value ) - Number(sheetObj_02.CellValue(row2, 'inv_bzc_amt')) );				
			}							
		}		
	}
	
	if( row3 != 0 ){
		if( sheetObj_03.CellValue(row3, 'pay_flg') == 1 ){		
			if( sheetObj_03.CellValue(row3, 'org_inv_bzc_amt') != sheetObj_03.CellValue(row3, 'inv_bzc_amt') ){
				formObj.total_amt_invoice_only.value = chkAmtPos( Number( formObj.total_amt_invoice_only.value ) - Number(sheetObj_03.CellValue(row3, 'org_inv_bzc_amt')) );
				sheetObj_03.CellValue(row3, 'org_inv_bzc_amt') = sheetObj_03.CellValue(row3, 'inv_bzc_amt');
				formObj.total_amt_invoice_only.value = chkAmtPos( Number( formObj.total_amt_invoice_only.value ) + Number(sheetObj_03.CellValue(row3, 'inv_bzc_amt')) );				
			}else{
				sheetObj_03.CellValue(row3, 'org_inv_bzc_amt') = sheetObj_03.CellValue(row3, 'inv_bzc_amt');
				formObj.total_amt_invoice_only.value = chkAmtPos( Number( formObj.total_amt_invoice_only.value ) + Number(sheetObj_03.CellValue(row3, 'inv_bzc_amt')) );
			}			
		}else if( sheetObj_03.CellValue(row3, 'pay_flg') == 0 ){
			if( sheetObj_03.CellValue(row3, 'org_inv_bzc_amt') != sheetObj_03.CellValue(row3, 'inv_bzc_amt') ){
				sheetObj_03.CellValue(row3, 'org_inv_bzc_amt') = sheetObj_03.CellValue(row3, 'inv_bzc_amt');
			}else{
				formObj.total_amt_invoice_only.value = chkAmtPos( Number( formObj.total_amt_invoice_only.value ) - Number(sheetObj_03.CellValue(row3, 'inv_bzc_amt')) );				
			}			
		}		
	}
	formObj.total_amt_for_payment.value = chkAmtPos( Number(formObj.total_amt_coincidence.value) + Number(formObj.total_amt_discrepancy.value) + Number(formObj.total_amt_invoice_only.value) );
}


function setCntrRailInvAudCd(){
	var sheetObj0 = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	var sheetObj2 = sheetObjects[2];

	for(var i=1; i< sheetObj0.RowCount+1; i++){
		sheetObj0.CellValue2(i, 'crnt_trsp_rail_inv_aud_cd') = 'C';
	}

	for(var i=1; i< sheetObj1.RowCount+1; i++){
		sheetObj1.CellValue2(i, 'crnt_trsp_rail_inv_aud_cd') = 'D';
	}

	for(var i=1; i< sheetObj2.RowCount+1; i++){
		sheetObj2.CellValue2(i, 'crnt_trsp_rail_inv_aud_cd') = 'I';
	}
}


// confirm시 Pay flag가 check된건중에 so seq가 중복되는지 여부 조회
function checkDuplicateSoSeq(){
	var sheetObj0 = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];
	var sheetObj2 = sheetObjects[2];

	var checkList0 = sheetObj0.FindCheckedRow('pay_flg');
	var checkArray0 = checkList0.split('|');

	var checkList1 = sheetObj1.FindCheckedRow('pay_flg');
	var checkArray1 = checkList1.split('|');

	var checkList2 = sheetObj2.FindCheckedRow('pay_flg');
	var checkArray2 = checkList2.split('|');

	var queryStr = '';

	for(var i=0; i< checkArray0.length-1; i++){
	
		if(sheetObj0.CellValue(checkArray0[i], 'trsp_so_seq') != ''){
			queryStr += '&ibflag=R&sheetNo=0';
			queryStr += '&row='+checkArray0[i];
			queryStr += '&eq_no='+sheetObj0.CellValue(checkArray0[i], 'eq_no');
			queryStr += '&trsp_so_ofc_cty_cd_seq='+sheetObj0.CellValue(checkArray0[i], 'trsp_so_ofc_cty_cd')
						+ sheetObj0.CellValue(checkArray0[i], 'trsp_so_seq');
		}
	}

	for(var i=0; i< checkArray1.length-1; i++){
		
		if(sheetObj1.CellValue(checkArray1[i], 'trsp_so_seq') != ''){
			queryStr += '&ibflag=R&sheetNo=1';
			queryStr += '&row='+checkArray1[i];
			queryStr += '&eq_no='+sheetObj1.CellValue(checkArray1[i], 'eq_no');
			queryStr += '&trsp_so_ofc_cty_cd_seq='+sheetObj1.CellValue(checkArray1[i], 'trsp_so_ofc_cty_cd')
						+ sheetObj1.CellValue(checkArray1[i], 'trsp_so_seq');
		}
	}

	for(var i=0; i< checkArray2.length-1; i++){
		if(sheetObj2.CellValue(checkArray2[i], 'trsp_so_seq') != ''){
			queryStr += '&ibflag=R&sheetNo=2';
			queryStr += '&row='+checkArray2[i];
			queryStr += '&eq_no='+sheetObj2.CellValue(checkArray2[i], 'eq_no');
			queryStr += '&trsp_so_ofc_cty_cd_seq='+sheetObj2.CellValue(checkArray2[i], 'trsp_so_ofc_cty_cd')
						+ sheetObj2.CellValue(checkArray2[i], 'trsp_so_seq');
		}
	}

	sheetObjects[5].RemoveAll();
	sheetObjects[5].DoSearch4Post("ESD_TRS_0969.screen", 'a=a',queryStr, true);
	var searchRow = sheetObjects[5].ColValueDup('trsp_so_ofc_cty_cd_seq');

	if(searchRow != -1){
		var srcRow = sheetObjects[5].CellValue(searchRow, 'row');
		ComShowCodeMessage('COM12115', 'SO SEQ')+'['+sheetObjects[5].CellValue(searchRow, 'eq_no')+']';
		return false;
	}
	
	return true;
}
