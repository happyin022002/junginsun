/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0032.js
*@FileTitle : TRS invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.25
*@LastModifier : 조인영
*@LastVersion : 1.3
* 2009.02.23 조풍연
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2009.02.23         1.1 N200902170070 : 미주지역 CSR Check Mailing Address 기능 추가
* 2009.03.04         1.2 N200903030070 : CSR IF Inquriy Downexcel 버튼 추가
* 2011.12.26 최 선        1.3 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2013.01.25 조인영 [CHM-201322577-01] CSR creation approval step 로직 개선
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0032 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0032() {
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

var comboObjects = new Array();
var comboCnt = 0 ;
var findCheckRow = "";
var checkRows = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject    = sheetObjects[0];
	var sheetObject1   = sheetObjects[1];
	var sheetObject2   = sheetObjects[2];

	/*******************************************************/
	var formObject = document.form;

	if(formObject.total_amt.value >= 0){
		formObject.csr_tp_cd.value = "S"
	}else{
		formObject.csr_tp_cd.value = "C"
	}

	try {
		var srcName = window.event.srcElement.getAttribute("name");


		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;

			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
			break;

			case "btns_calendar1":
				var cal = new ComCalendar();
				cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
			break;

			case "btns_calendar2":
				var cal = new ComCalendar();
				cal.select(formObject.pm_due_dt, 'pm_due_dt', 'yyyy-MM-dd');
			break;

			case "btng_evidence":
			
				if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
					errMsg = ComGetMsg("TRS90036" );
					ComShowMessage(errMsg);
					return false;
				}

//                var option620 = "dialogWidth:790px; dialogHeight:680px; help:no; status:no; resizable:no;";
				var option620 = "dialogWidth:1020px; dialogHeight:615px; help:no; status:no; resizable:no;";
                var option590 = "dialogWidth:800px; dialogHeight:640px; help:no; status:no; resizable:no;";

				if(formObject.evi_gb.value=="1"){
					
				   if(document.form.eviInputFlg.value!="Y"){
				        checkRows = sheetObject.FindCheckedRow(1);
						ComOpenPopup('ESD_TRS_0034.do', 1020, 615, '','1,0,1,1,1,1,1,1', true);
//						ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
				   } else {

					   if ( !isInputEvidence() )
					   {
						   if(confirm("기 입력된 세금계산서 또는 계산서 내역이 삭제됩니다. 계속하시겠습니까?"))
						   {
							   resetTax();
							   window.showModalDialog("ESD_TRS_0034.do", window, option620);
						   }
					   } else {
						   window.showModalDialog("ESD_TRS_0034.do", window, option620);
					   }
				   }
				}else if(formObject.evi_gb.value=="2"){
					 if(document.form.eviInputFlg.value!="Y"){
						checkRows = sheetObject.FindCheckedRow(1);
						ComOpenPopup('ESD_TRS_0037.do', 800, 595, '','1,0,1,1,1,1,1,1', true);
					 } else {
					   if ( !isInputEvidence() )
					   {
						   if(confirm("기 입력된 세금계산서 또는 계산서 내역이 삭제됩니다. 계속하시겠습니까?"))
						   {
							   resetTax();
							   window.showModalDialog("ESD_TRS_0037.do", window, option590);
						   }
					   }else{
                            window.showModalDialog("ESD_TRS_0037.do", window, option590);
					   }
				   }
				}else if(formObject.evi_gb.value=="3"){
                    resetTax();
				}else{
                    errMsg = ComGetMsg("TRS90029");
                    ComShowMessage(errMsg);
				}
			break;

			case "btng_preview":
			
				/*** ACCT_CD IS NULL OR LGS_COST_CD IS NULL DATA CHECK ***/
				if(!isNullAcctCdLgsCostCd(sheetObject))     return false;
			
//				if (ComIsEmpty(formObject.apro_step))
//				{
//					errMsg = ComGetMsg("TRS90100");
//					ComShowMessage(errMsg);
//					return false;
//				}
				
				if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
					return false;
				}
				
				/** ASA NO. Select 여부 체크 */
				if(formObject.asanogb.value == "ASA" && (formObject.asa_no.value == null || formObject.asa_no.value == "")){
					errMsg = ComGetMsg("TRS90385", "ASA No.");
					ComShowMessage(errMsg);
					return false;  
				}

				if(formObject.evi_gb.value=="3")
				{
					formObject.evi_tax_code.value ="";
				}
				if(cnt_cd == "KR"){
                    if(formObject.evi_gb.value == ""){
                        errMsg = ComGetMsg("TRS90029");
                        ComShowMessage(errMsg);
                        return false;
                    }else{
                        if(formObject.evi_gb.value!="3"){
                            if(!isInputEvidence()){
                                errMsg = "선택된 Invoice가 입력된 세금계산서 또는 계산서의 내용과 일치하지 않습니다.";
                                //ComGetMsg("TRS90030")+getNotInputEvidenceList();
                                ComShowMessage(errMsg);
                                return false;
                            }
                        }
                    }
				}

				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();

				doActionIBSheet1(sheetObject2,formObject,IBSEARCH);
				document.form.csr_no.value = "";
				break;

//			case "btns_search":
//
//				var v_apro_step = document.form.apro_step.value;
//				var ofc_cd = "";
//				if(document.form.ofc_tp[0].checked){
//					ofc_cd = document.form.cost_ofc_cd.value;
//				}else if (document.form.ofc_tp[1].checked){
//					ofc_cd = document.form.inv_ofc_cd.value;
//				}
//				var param = "?mode=set&ofc_cd="+ofc_cd+"&sub_sys_cd=TRS&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";
//				ComOpenPopup('/hanjin/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
//				break;

			case "btng_print":
                var fromObj = new Array();
                var rdObj      = new Array();
                var parmObj = new Array();
				fromObj[0] = formObject;                            // RD 로 보내기 위해 배열로담는다
				rdObj[0] = sheetObjects[0];                                                     // Coincidence 에 sheet를 RD로 보내기 위해 배열로 담는다

				// RD 로 보내기 위한 설정
				parmObj[0] = "1";
				parmObj[1] = "";
				parmObj[2] = "N";
				parmObj[3] = RD_path+"apps/alps/esd/trs/invoicemanage/csrissuetranferslip/report/ESD_TRS_0032Print.mrd";     // RD 화면
				parmObj[4] = rdObj;
				parmObj[5] = fromObj;
				rdObjModaless(RdReport , parmObj , 1000 ,700);
				break;

			case "btng_approvalrequest":

				/*** ACCT_CD IS NULL OR LGS_COST_CD IS NULL DATA CHECK ***/
				if(!isNullAcctCdLgsCostCd(sheetObject))     return false;

//				if (ComIsEmpty(formObject.apro_step))
//				{
//					errMsg = ComGetMsg("TRS90100");
//					ComShowMessage(errMsg);
//					return false;
//				}
				
				//Null check : Payment Due Date, 2013.10.24 by SHIN DONG IL 
				if (ComIsEmpty(formObject.payment_due_dt_view)){
					formObject.payment_due_dt_view.focus();
					errMsg = ComGetMsg("TRS90388","Payment Due Date");
					ComShowMessage(errMsg);
					return false;
				}

				if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
					return false;
				}
				
				/** ASA NO. Select 여부 체크 */
				if(formObject.asanogb.value == "ASA" && (formObject.asa_no.value == null || formObject.asa_no.value == "")){
					errMsg = ComGetMsg("TRS90385", "ASA No.");
					ComShowMessage(errMsg);
					return false;  
				}

				if(cnt_cd == "KR"){
					if(formObject.evi_gb.value == ""){
						errMsg = ComGetMsg("TRS90029");
						ComShowMessage(errMsg);
						return false;
					}else{
						if(formObject.evi_gb.value != "3"){
							if(!isInputEvidence()){
                                errMsg = "선택된 Invoice와 입력된 세금계산서 또는 계산서의 내용과 일치하지 않습니다.";
                                //ComGetMsg("TRS90030")+getNotInputEvidenceList();
                                ComShowMessage(errMsg);
                                return false;
							}
						}
					}
				}

				/** Hold Invoice 여부 체크 */
    	        var chkrow = sheetObject.FindCheckedRow("chk");
    	        var arrRow = chkrow.split("|");
    	        var inv_no = "";
    	        var inv_vndr_seq = "";
    	        
                for (idx=arrRow.length-2; idx >= 0; idx--){ 
                	inv_no += sheetObject.CellValue(arrRow[idx], 'inv_no')+"|";
                	inv_vndr_seq += sheetObject.CellValue(arrRow[idx], 'inv_vndr_seq')+"|";
                }
				formObject.f_cmd.value = SEARCH02;
				formObject.r_inv_no.value = inv_no;
				formObject.r_inv_vndr_seq.value = inv_vndr_seq;
				
				var sXml = sheetObject.GetSearchXml("ESD_TRS_0032GS.do", TrsFrmQryString(formObject));
				var holdInvNo = ComGetEtcData(sXml,'holdInvNo');   
				if (holdInvNo != "N") {
					errMsg = ComGetMsg("TRS00410", holdInvNo);
					ComShowMessage(errMsg);
					return false;
  				}
//				errMsg = ComShowMessage("Are you sure to proceed for Approval Request?");
				if(!confirm('Are you sure to proceed for Approval Request?')) return false;
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
				
			//N200903030070 2009-03-04 : CSR IF Inquriy Downexcel 버튼 추가
			case "btng_downexcel1": //sheet1 엑셀다운로드
				sheetObject.SpeedDown2Excel(true);
			break;
					
		   } // end switch
		   
	}catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90392");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

function isInputEvidence(){
    var sheetObject     = sheetObjects[0];
    var inputFlag       = false;

    var chkList  = sheetObject.FindCheckedRow('chk');
    var taxList  = sheetObject.FindCheckedRow('taxcheck');

    if(chkList == taxList){
        inputFlag = true;
    }

    return inputFlag;
}

function getNotInputEvidenceList(){
    var sheetObject     = sheetObjects[0];

    var checkList  = sheetObject.FindCheckedRow('chk');
    var checkArray = checkList.split('|');
    var list       = '';
    var cnt = 0;

    for(var i=0; i<checkArray.length-1; i++){
        if(sheetObject.CellValue(checkArray[i], 'taxcheck') == 0){
            if(cnt++==0) {
                list += '\n\n입력할 Invoice No :'+sheetObject.CellValue(checkArray[i], 'inv_no');
            }else{
                list += ','+sheetObject.CellValue(checkArray[i], 'inv_no');
            }
        }
    }

    cnt=0;
    checkList  = sheetObject.FindCheckedRow('taxcheck');
    checkArray = checkList.split('|');

    for(var i=0; i<checkArray.length-1; i++){
        if(sheetObject.CellValue(checkArray[i], 'chk') == 0){
            if(cnt++==0) {
                list += '\n\n입력된 Invoice No :'+sheetObject.CellValue(checkArray[i], 'inv_no');
            }else{
                list += ','+sheetObject.CellValue(checkArray[i], 'inv_no');
            }
        }
    }
    return list;
}


function resetTax()
{
	document.form.tax_naid_flg.value = "";
	document.form.finance_flg.value = "";
	document.form.fa_flg.value = "";
	document.form.tax_type.value = "";
	document.form.tax_nsl_flg.value = "";
	document.form.type.value = "";

	document.form.evi_inv_dt.value = "";
	document.form.evi_comp_no.value = "";
	document.form.evi_total_net_amt.value = "";
	document.form.evi_tax_no2.value = "";
	document.form.evi_total_tax_amt.value = "";
	document.form.evi_ctnt1.value = "";
	document.form.evi_ctnt2.value = "";
	document.form.evi_ctnt3.value = "";
	document.form.evi_ctnt4.value = "";
	document.form.evi_ctnt5.value = "";
	document.form.evi_ctnt6.value = "";
	document.form.evi_ctnt7.value = "";
	document.form.evi_ctnt8.value = "";
	document.form.evi_ctnt9.value = "";
	document.form.evi_ctnt10.value = "";
	document.form.evi_ctnt11.value = "";
	document.form.evi_ctnt12.value = "";
	document.form.evi_tax_no.value = "";
	document.form.evi_tax_code.value = "";
	document.form.eviInputFlg.value = "";

    resetTaxFlag();
}

function resetTaxFlag(){

    var checkList  = sheetObjects[0].FindCheckedRow('taxcheck');
    var checkArray = checkList.split('|');

    for(var i=0; i<checkArray.length-1; i++){
        sheetObjects[0].CellValue2(checkArray[i], 'taxcheck') = '0';
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
        ComConfigSheet(sheetObjects[i]);

        initSheet(sheetObjects[i],i+1);
    //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

   if ( ComIsNumber(document.form.gen_pay_term_cd) )
   {
	   document.form.gen_pay_term_view.value =   document.form.gen_pay_term_cd.value;
   } else {
	   document.form.gen_pay_term_view.value = "KR H/O Payment_60";
   }

  if(document.form.asanogb.value == "A/P" && cnt_cd == "KR"){
	  document.all.item("srLayer")[1].style.display = "inline";
	  document.all.item("srLayer")[0].style.display = "none";
	  document.all.item("srLayer")[2].style.display = "none";
	  document.all.item("btLayer")[1].style.display = "inline";
	  document.all.item("btLayer")[0].style.display = "none";
	}else if(document.form.asanogb.value == "ASA" && cnt_cd == "KR"){
	  document.all.item("srLayer")[1].style.display = "none";
	  document.all.item("srLayer")[0].style.display = "none";
	  document.all.item("srLayer")[2].style.display = "inline";
	  document.all.item("btLayer")[1].style.display = "inline";
	  document.all.item("btLayer")[0].style.display = "none";
	}else if(document.form.asanogb.value == "ASA" && cnt_cd != "KR"){
	  document.all.item("srLayer")[1].style.display = "none";
	  document.all.item("srLayer")[0].style.display = "inline";
	  document.all.item("srLayer")[2].style.display = "none";
	  document.all.item("btLayer")[1].style.display = "none";
	  document.all.item("btLayer")[0].style.display = "inline";
	}else if(document.form.asanogb.value == "A/P" && cnt_cd != "KR"){
	  document.all.item("srLayer")[1].style.display = "none";
	  document.all.item("srLayer")[0].style.display = "none";
	  document.all.item("srLayer")[2].style.display = "none";
	  document.all.item("btLayer")[1].style.display = "none";
	  document.all.item("btLayer")[0].style.display = "inline";
	}

	for(p=0;p< comboObjects.length;p++){
		initCombo (comboObjects[p],p+1, '');
	}

	ComEnableObject(document.form.cost_ofc_cd, false);
	ComEnableObject(document.form.cfm_dt, false);
	ComEnableObject(document.form.vndr_seq, false);
	ComEnableObject(document.form.vndr_seq_name, false);
	ComEnableObject(document.form.cnt_inv, false);
	ComEnableObject(document.form.curr_cd, false);
	ComEnableObject(document.form.total_amt, false);
	ComEnableObject(document.form.csr_no, false);
	ComEnableObject(document.form.max_iss_dt, false);
	ComEnableObject(document.form.max_rcv_dt, false);
	ComEnableObject(document.form.gen_pay_term_view, false);
//	ComEnableObject(document.form.apro_step, false);
	ComEnableObject(document.form.payment_due_dt, false);
	
	//CHM-201327226 미주지역 Payment Due Date 창 활성화
	//대륙코드가 미주(M)일 경우 Payment due date textbox활성화
	//2013.10.23 by SHIN DONG IL
	if (document.form.conti_cd.value == "M") {
		ComEnableObject(document.form.payment_due_dt_view, true);	
	}else{
		ComEnableObject(document.form.payment_due_dt_view, false);	
	}
	
    document.form.reset();
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	//html컨트롤 이벤트초기화
	initControl();
	
//	/**
//	 * 2013.01.25 조인영 [CHM-201322577-01]
//	 * Cost Office 와 Log-in Office 가 동일할 경우 Radio 버튼 비활성화
//	 */
//	if(document.form.cost_ofc_cd.value ==document.form.inv_ofc_cd.value) {
//		ComEnableObject(document.form.ofc_tp[0], false);
//		ComEnableObject(document.form.ofc_tp[1], false);
//	}else{
//		ComEnableObject(document.form.ofc_tp[0], true);
//		ComEnableObject(document.form.ofc_tp[1], true);
//	}
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
//            axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//            axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//            axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//            axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//            axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//            axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
//            axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
}


//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
/*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
        form.boo_bl_no.value = "";
    else
        form.boo_bl_no.value = form.hdn_boo_bl_no.value;
*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end


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
            style.height = GetSheetHeight(13);
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
            InitColumnInfo(16, 1, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false)

            var HeadTitle = "Seq.||Invoice No|Net Amount|Tax Amount|W.H.T Amount|S.B.C Amount|Total Amount|Issue Date|Receive Date|Confirm Date|Tax Invoice\n(Korea only)" ;

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,                      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

            InitDataProperty(0, cnt++ , dtSeq,          30, daCenter, false, "",                 false,   "", dfNone,    0, false, false );
            InitDataProperty(0, cnt++ , dtCheckBox,     30, daCenter, false, "chk",              false,   "", dfNone,    0, true,  true  );
            InitDataProperty(0, cnt++ , dtData,        100, daLeft,   false, "inv_no",           false,   "", dfNone,    0, false, false );
            InitDataProperty(0, cnt++ , dtData,        100, daRight,  false, "inv_bzc_amt",      false,   "", dfFloat,   2, false, false );
            InitDataProperty(0, cnt++ , dtData,        100, daRight,  false, "inv_vat_amt",      false,   "", dfFloat,   2, false, false );
            InitDataProperty(0, cnt++ , dtData,        100, daRight,  false, "inv_whld_tax_amt", false,   "", dfFloat,   2, false, false );
            InitDataProperty(0, cnt++ , dtData,        100, daRight,  false, "inv_sbc_amt",      false,   "", dfFloat,   2, false, false );
            InitDataProperty(0, cnt++ , dtData,        100, daRight,  false, "inv_ttl_amt",      false,   "", dfFloat,   2, false, false );
            InitDataProperty(0, cnt++ , dtData,        110, daCenter, false, "inv_iss_dt",       false,   "", dfDateYmd, 0, false, false );
            InitDataProperty(0, cnt++ , dtData,        110, daCenter, false, "inv_rcv_dt",       false,   "", dfDateYmd, 0, false, false );
            InitDataProperty(0, cnt++ , dtData,        110, daCenter, false, "inv_cfm_dt",       false,   "", dfDateYmd, 0, false, false );
            InitDataProperty(0, cnt++ , dtCheckBox,    80, daCenter, false, "taxcheck",         false,   "", dfNone,    0, false, true );
            InitDataProperty(0, cnt++ , dtHidden,        1, daRight,  false, "inv_vndr_seq",     false,   "", dfNone,    0, false, false );
            InitDataProperty(0, cnt++ , dtHiddenStatus,  1, daRight,  false, "ibflag",           false,   "", dfNone,    0, false, false );
            
            InitDataProperty(0, cnt++ , dtHidden,        1, daRight,  false, "acct_cd_empty_cnt",false,   "", dfNone,    0, false, false );
            InitDataProperty(0, cnt++ , dtHidden,        1, daRight,  false, "wo_vndr_seq",      false,   "", dfNone,    0, false, false );
       
        }
			break;

		case 2:      //sheet1 init
			with (sheetObj) {
            // 높이 설정
            style.height = GetSheetHeight(13);
            //전체 너비 설정
            SheetWidth = mainTable2.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(25, 1, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            //var HeadTitle = "csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|chk_mail" ;
            var HeadTitle = "pre_csr_no|pre_office|pre_prpd_dy|pre_pay_to|pre_csr_type|pre_desc|pre_pay_group|pre_evi_tp|pre_due_date|pre_asa_no|pre_inv_dt|pre_curr_cd|pre_amt|pre_pay_curr_cd|pre_pay_amt||pre_title|chk_mail" ;

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,                      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtData,    70,    daLeft, false,"pre_csr_no",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_office",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_prpd_dy",    false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_pay_to",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_csr_type",    false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_desc",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_pay_group",    false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_evi_tp",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_due_date",    false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_asa_no",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_inv_dt",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_curr_cd",    false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_amt",        false,"",dfNullFloat,2,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_pay_curr_cd",false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_pay_amt",    false,"",dfNullFloat,2,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"apro_step",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"pre_title",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail1",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail2",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail3",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail4",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail5",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail6",        false,"",dfNone,    0,false,false);
            InitDataProperty(0, cnt++ , dtData,    70,    daRight,false,"chk_mail7",        false,"",dfNone,    0,false,false);
		}
			break;

		case 3:      //sheet1 init
			with (sheetObj) {
            // 높이 설정
            style.height = GetSheetHeight(13);
            //전체 너비 설정
            SheetWidth = mainTable3.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 9, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(8, 1, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle = "char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,         SAVENAME,                                  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtData,                 80,            daCenter,        false,    "pre_chart_of_account",        false,            "",            dfNone,                    0,            false,            false    );
            InitDataProperty(0, cnt++ , dtData,             80,            daCenter,        false,    "pre_account_name",                false,            "",            dfNone,                    0,            true,            true    );
            InitDataProperty(0, cnt++ , dtData,                 80,            daLeft,            false,    "pre_gl_date",                        false,            "",            dfNone,                    0,            false,            false    );
            InitDataProperty(0, cnt++ , dtData,                 80,            daRight,        false,    "pre_city",                                false,            "",            dfNone,                    2,            false,            false    );
            InitDataProperty(0, cnt++ , dtData,                 80,            daRight,        false,    "pre_inv_no",                            false,            "",            dfNone,                    2,            false,            false    );
            InitDataProperty(0, cnt++ , dtData,                 80,            daRight,        false,    "pre_desc",                                false,            "",            dfNone,                    2,            false,            false    );
            InitDataProperty(0, cnt++ , dtData,                 80,            daRight,        false,    "pre_debit",                            false,            "",            dfNullFloat,                    2,            false,            false    );
            InitDataProperty(0, cnt++ , dtData,                 80,            daRight,        false,    "pre_credit",                            false,            "",            dfNullFloat,                    2,            false,            false    );
		 }
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	   case IBSEARCH:      //조회

			   formObj.f_cmd.value = SEARCHLIST;
			   //sheetObj.ShowDebugMsg   = true;
			sheetObj.DoSearch4Post("ESD_TRS_0032GS.do", TrsFrmQryString(formObj));
			//sheetObj.ShowDebugMsg   = false;

			break;

		case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;
			
			//-- sheetObj.ShowDebugMsg   = true;
			sheetObj.DoSave("ESD_TRS_0032GS.do", TrsFrmQryString(formObj), "chk", false);
			//-- sheetObj.ShowDebugMsg   = false;
			
			break;

	   case IBCOPYROW:        //행 복사
		  sheetObj.DataCopy();
		  break

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet1(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:      //조회

			   formObj.f_cmd.value = SEARCH01;

			var param = sheetObjects[0].GetSaveString(false,false);

			sheetObj.DoSearch4Post ("ESD_TRS_0032PreView.do", param+'&'+TrsFrmQryString(formObj),"",true);
			//document.write(sXml);
//                sheetObj.LoadSearchXml(sXml);
			break;
	}
}

function sheet1_OnChange(sheetObj , row , col, value)
{
	var chkRow = sheetObj.FindCheckedRow ("chk");
	var arrRow = chkRow.split("|");
	var chkRowCount =0 ;
	var maxIss = 0;
	var maxRcv = 0 ;
	var total_amt = 0;
	var vat_amt = 0 ;
    var selectRow = 0;

	for (idx=0; idx<arrRow.length-1; idx++)
	{
		  if( maxIss < sheetObj.Cellvalue( arrRow[idx] , "inv_iss_dt"))
		  {
			  maxIss =  sheetObj.Cellvalue( arrRow[idx] , "inv_iss_dt");
              selectRow = arrRow[idx];
		  }

		  if( maxRcv < sheetObj.Cellvalue( arrRow[idx] , "inv_rcv_dt"))
		  {
			  maxRcv =  sheetObj.Cellvalue( arrRow[idx] , "inv_rcv_dt");
		  }

		  total_amt = parseFloat(sheetObj.CellValue( arrRow[idx],"inv_ttl_amt")*100)+parseFloat(total_amt)*100;
		  vat_amt = parseFloat(sheetObj.CellValue( arrRow[idx],"inv_vat_amt")*100)+parseFloat(vat_amt)*100;
		  total_amt = total_amt/100;
		  vat_amt = vat_amt /100 ;
		  chkRowCount++;
	}

    document.form.wo_vndr_seq.value = sheetObj.Cellvalue( selectRow , "wo_vndr_seq");

	if ( maxIss == "0")  maxIss ="";
	if ( maxRcv == "0")  maxRcv ="";
	if ( chkRowCount == "0")  chkRowCount ="";

	document.form.max_iss_dt.value = maxIss;
	document.form.max_rcv_dt.value = maxRcv;
	document.form.total_amt.value = total_amt;
	ComChkObjValid(document.form.max_iss_dt);
	ComChkObjValid(document.form.max_rcv_dt);
	document.form.cnt_inv.value = chkRowCount;
   
    var payDueDt = document.form.max_iss_dt.value;
    var genPayTerm = getPaymentTermDate(document.form.gen_pay_term_cd.value);

	if ( maxIss != "" )
	{
        //document.form.payment_due_dt_view.value = ComGetDateAdd(null, payDueDt, genPayTerm);
		document.form.payment_due_dt_view.value = ComGetDateAdd(payDueDt, "D", genPayTerm, ""); 
        document.form.gen_pay_term_view.value   =   document.form.gen_pay_term_cd.value;
		
	} else {
		document.form.payment_due_dt_view.value = "";
        document.form.gen_pay_term_view.value = "";
	}        

  if(document.form.asanogb.value=="A/P" && cnt_cd=="KR"){
	   if ( vat_amt > 0)
	   {
		   document.form.evi_gb1.options[1].selected = true ;
		   ComEnableObject(document.form.evi_gb1, false);
		   eviGbSelect(1);
	   } else {
		   document.form.evi_gb1.options[0].selected = true ;
		   ComEnableObject(document.form.evi_gb1, true);
		   eviGbSelect(1);
	   }
	}else if(document.form.asanogb.value=="ASA" && cnt_cd=="KR"){
	   if ( vat_amt > 0)
	   {
		   document.form.evi_gb1.options[1].selected = true ;
		   ComEnableObject(document.form.evi_gb1, false);
		   eviGbSelect(2);
	   } else {
		   document.form.evi_gb1.options[0].selected = true ;
		   ComEnableObject(document.form.evi_gb1, true);
		   eviGbSelect(2);
	   }
	}
}

 function sheet1_OnSaveEnd(sheetObj, ErrMsg)
{

	if (ErrMsg != "") return false;

	var csr_no = sheetObj.EtcData("csrNo");

	document.form.csr_no.value = csr_no;
	sheetObj.RemoveEtcData ();

	var chkRow = sheetObj.FindCheckedRow ("chk");
	var arrRow = chkRow.split("|");
	for (idx=0; idx<arrRow.length-1; idx++)
	{
		sheetObj.CellEditable(arrRow[idx] , "chk") = false;
		sheetObj.CellValue2(arrRow[idx] , "chk") = 0;
	}
	errMsg = ComGetMsg("TRS90046" );
	ComShowMessage(errMsg);

//	if ( myWin != null)
//	{
//		if(!myWin.closed)
//		{
//			sheetObjects[1].CellValue(1,"pre_csr_no")     = csr_no;
//			myWin = null;
//			myWin = ComOpenPopup('/hanjin/ESD_TRS_0036.do', 800,700,'', '1,0,1,1,1,1,1,1');
//			myWin.close();
//		}
//	}
	/*16.01.06 SY SHIM CSR 결재 유형 변경 오피스 확인 로직*/	
    var csrNo = document.form.csr_no.value;
    var aproTpParam = "f_cmd="+SEARCH03+"&csr_no="+csrNo;
    var sXml = sheetObj.GetSearchXml("COM_CSR_0002GS.do", aproTpParam);
    var chkOfc = ComGetEtcData(sXml,"CN_OFC_CHK");
    
    if(chkOfc == "Y"){
    	var csrNo = document.form.csr_no.value;
		ComOpenPopup('/hanjin/COM_CSR_0016.do?csr_no='+csrNo, 300, 150, '', 'none', true);
    }
    
	//Approval Step지정을 하겠습니까? Yes면 CSR조회 화면으로 , No면 CSR을 계속 생성하도록 현재 화면
	if(ComShowConfirm("Do you want to select Approval Step?")) {
		location.href = 'ESD_TRS_0047.do?CSR_NO='+ csr_no+'&STS='+'RA';
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
	}

	return true;
}

  /**
 * MInimize 클릭시 이벤트 관련
 */
function Minimize(nItem)
{

	var objs = document.all.item("showMin");

	if ( nItem == "1" )
	{
			objs.style.display = "none";
		  sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
					sheetObjects[0].focus();
					sheetObjects[0].ViewRows  =20;
			}
		else
		{
			objs.style.display = "inline";
			sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
					sheetObjects[0].focus();
					sheetObjects[0].ViewRows  =10;
		}
}

function isNum(obj){
	//숫자만..
	if (!ComIsNumber(obj)){
		obj.value = '';
	}
}

function isNum1(obj){
	//숫자만..
	if (!isNumDash(obj)){
		obj.value = '';
	}
}

function isDate1(obj){
	//숫자만..
	if (!ComIsDate(obj)){
		obj.value = '';

		//ComShowMessage("잘못된 날짜 입력입니다. 다시 입력하세요.");
	}
}

function sheet3_OnSearchEnd(sheetObj,errMsg){

	if(errMsg!="")  return;

	var pre_title               = "";
	var previewFlg              = "";

    var pre_csr_no      = sheetObj.EtcData("pre_csr_no");
    var pre_office      = sheetObj.EtcData("pre_office");
    var pre_prpd_dy     = sheetObj.EtcData("pre_prpd_dy");
    var pre_pay_to      = sheetObj.EtcData("pre_pay_to");
    var pre_csr_type    = sheetObj.EtcData("pre_csr_type");
    var pre_desc        = sheetObj.EtcData("pre_desc");
    var pre_pay_group   = sheetObj.EtcData("pre_pay_group");
    var pre_evi_tp      = sheetObj.EtcData("pre_evi_tp");
    var pre_due_date    = sheetObj.EtcData("pre_due_date");
    //var pre_asa_no    = sheetObj.EtcData("pre_asa_no");
    var pre_inv_dt      = sheetObj.EtcData("pre_inv_dt");
    var pre_curr_cd     = sheetObj.EtcData("pre_curr_cd");
    var pre_amt         = sheetObj.EtcData("pre_amt");
    //N200902170070 2009-02-23 : 미주지역 CSR Check Mailing Address 기능 추가
    var chk_mail        = sheetObj.EtcData("chk_mail");
    var chk_mail1        = sheetObj.EtcData("chk_mail1");
    var chk_mail2        = sheetObj.EtcData("chk_mail2");
    var chk_mail3        = sheetObj.EtcData("chk_mail3");
    var chk_mail4        = sheetObj.EtcData("chk_mail4");
    var chk_mail5        = sheetObj.EtcData("chk_mail5");
    var chk_mail6        = sheetObj.EtcData("chk_mail6");
    var chk_mail7        = sheetObj.EtcData("chk_mail7");
    var pre_evi_tp_count= "";

    sheetObj.RemoveEtcData();
    if(cnt_cd =="KR"){
            pre_evi_tp_count ="1";
    }else{
            var sRow = sheetObjects[0].FindCheckedRow(1);
            var arrRow = sRow.split("|");
            pre_evi_tp_count =arrRow.length-1;
    }

   if(pre_amt==0 || pre_amt=="0" || pre_amt=="0.00"){
            pre_title  = "TRANSFER SLIP";
    }else{
            pre_title  = "CONSULTATION SLIP";
    }
    sheetObjects[1].RemoveAll();

    sheetObjects[1].DataInsert(-1);

	sheetObjects[1].CellValue(1,"pre_csr_no")     = pre_csr_no;
	sheetObjects[1].CellValue(1,"pre_office")     = document.form.cost_ofc_cd.value;
	sheetObjects[1].CellValue(1,"pre_prpd_dy")     = pre_prpd_dy;
	sheetObjects[1].CellValue(1,"pre_pay_to")     = pre_pay_to;
	sheetObjects[1].CellValue(1,"pre_csr_type") = pre_csr_type;
	sheetObjects[1].CellValue(1,"pre_desc")         = pre_desc;
	sheetObjects[1].CellValue(1,"pre_pay_group")= pre_pay_group;
	sheetObjects[1].CellValue(1,"pre_evi_tp")     = pre_evi_tp+"/"+pre_evi_tp_count;
	sheetObjects[1].CellValue(1,"pre_due_date") = pre_due_date;
	sheetObjects[1].CellValue(1,"pre_asa_no")     = document.form.asa_no.value;
	sheetObjects[1].CellValue(1,"pre_inv_dt")     = pre_inv_dt;
	sheetObjects[1].CellValue(1,"pre_curr_cd")     = pre_curr_cd;
	sheetObjects[1].CellValue(1,"pre_amt")         = pre_amt;
	sheetObjects[1].CellValue(1,"pre_title")         = pre_title;
	//N200902170070 2009-02-23 : 미주지역 CSR Check Mailing Address 기능 추가
	sheetObjects[1].CellValue(1,"chk_mail")         = chk_mail;
	sheetObjects[1].CellValue(1,"chk_mail1")         = chk_mail1;
	sheetObjects[1].CellValue(1,"chk_mail2")         = chk_mail2;
	sheetObjects[1].CellValue(1,"chk_mail3")         = chk_mail3;
	sheetObjects[1].CellValue(1,"chk_mail4")         = chk_mail4;
	sheetObjects[1].CellValue(1,"chk_mail5")         = chk_mail5;
	sheetObjects[1].CellValue(1,"chk_mail6")         = chk_mail6;
	sheetObjects[1].CellValue(1,"chk_mail7")         = chk_mail7;

	if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY"){
			 previewFlg = "krjp";
	}
	 myWin = ComOpenPopup('/hanjin/ESD_TRS_0036.do?previewFlg='+previewFlg, 800,700,'', '1,0,1,1,1,1,1,1');

}

function sheet1_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!="")  return;

	var asaNoString = sheetObj.EtcData("asaNoString");
	var csrNo = sheetObj.EtcData("csrNo");
	var apOfcCd = sheetObj.EtcData("apOfcCd");

	document.form.csr_no.value = csrNo;
	document.form.ap_ofc_cd.value = apOfcCd;

	for(p=0;p< comboObjects.length;p++){
		initCombo (comboObjects[p],p+1, asaNoString);
	}
}

function initCombo (comboObj, comboNo, asaNoString){
	var cnt  = 0 ;
	var asaNoArray = asaNoString.split("|");

	 switch(comboNo){
		case 1:
			comboObj.RemoveAll();

		   with (comboObj){
					   SetColAlign("left");
					   SetColWidth("60");
					 InsertItem(cnt++, '', '');
					   for(i=0 ;i<asaNoArray.length;i++){
					   InsertItem(cnt++, asaNoArray[i], asaNoArray[i]);
					 }
					}
		   break;
		   }
}

function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function asa_no_1_OnChange(comObj,index,text)
{
   document.form.asa_no.value = comObj.Code;
}

function asa_no_2_OnChange(comObj,index,text)
{
   document.form.asa_no.value = comObj.Code;
}

function approvalrequest(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	if(sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined){
	    errMsg = ComGetMsg("TRS90036" );
	    ComShowMessage(errMsg);
	    return false;
	}
	
	//if(cnt_cd=="KR"){
	//if(formObject.asanogb.value=="A/P"){
	if(cnt_cd == "KR"){
	    if(formObject.evi_gb.value == ""){
	        errMsg = ComGetMsg("TRS90029" );
	        ComShowMessage(errMsg);
	        return false;
	    }else{
	        if(formObject.evi_gb.value != "3"){
	            if(document.form.eviInputFlg.value != "Y"){
	                errMsg = ComGetMsg("TRS90030" );
	                ComShowMessage(errMsg);
	                return false;
	            }
	        }
	    }
	}
	
	/** Hold Invoice 여부 체크 */
	var chkrow = sheetObject.FindCheckedRow("chk");
	var arrRow = chkrow.split("|");
	var inv_no = "";
	var inv_vndr_seq = "";
	for (idx=arrRow.length-2; idx >= 0; idx--){ 
		inv_no += sheetObject.CellValue(arrRow[idx], 'inv_no')+"|";
		inv_vndr_seq += sheetObject.CellValue(arrRow[idx], 'inv_vndr_seq')+"|";
	}		

	formObject.f_cmd.value = SEARCH02;
	formObject.r_inv_no.value = inv_no;
	formObject.r_inv_vndr_seq.value = inv_vndr_seq;
	
	var sXml = sheetObject.GetSearchXml("ESD_TRS_0032GS.do", TrsFrmQryString(formObject));
	var holdInvNo = ComGetEtcData(sXml,'holdInvNo');  
	
	if (holdInvNo != "N") {
		errMsg = ComGetMsg("TRS00410", holdInvNo);
		ComShowMessage(errMsg);
		return false;
	}
	
	if(!confirm('Are you sure to proceed for Approval Request?')) return false;
	
	doActionIBSheet(sheetObject,formObject,IBSAVE);
}

function eviGbSelect(evi_gb){
    if(evi_gb==1){
        document.form.evi_gb.value=document.form.evi_gb1.value;
    }else if(evi_gb==2){
        document.form.evi_gb.value=document.form.evi_gb2.value;
    }
}

function isNullAcctCdLgsCostCd(sheetObject){
    var isNullTotalCnt    = 0;
    var isNullCnt         = 0;
    var checkedRow        = 0;

    var checkList         = sheetObject.FindCheckedRow('chk');
    var checkArray        = checkList.split('|');

    for(var k=0; k<checkArray.length-1; k++)
    {
        var checkedRow       = checkArray[k];
        var isNullTotalCnt   = isNullTotalCnt + Number(sheetObject.CellValue(checkedRow, 'acct_cd_empty_cnt'));
    }      

    if( isNullTotalCnt > 0 ){
        errMsg = ComGetMsg("TRS90398");
        ComShowMessage(errMsg);          
        return false;
    }

    return true;

}

function getPaymentTermDate(payTermCd){

    var payTermDate = 0;
    if(payTermCd == 'IN'){
        payTermDate = 5;
    }else if(payTermCd == 'OUT'){
        payTermDate = 60;
    }else if(payTermCd == 'O60'){
        payTermDate = 0;
    }else if(payTermCd == 'O45'){
        payTermDate = 0;
    }else{
        payTermDate = payTermCd;
    }
    return parseInt(payTermDate);
}

///**
// * 2013.01.25 조인영 [CHM-201322577-01]
// * Cost Office, Log-in Office Radio 버튼 클릭시 Approval Step 변경
// */
//function ofcChange(){
//	var formObj = document.form;
//
//	var apro_step = "";
//	if(formObj.ofc_tp[0].checked){
//		apro_step = formObj.cost_apro_step.value;
//	}else if (formObj.ofc_tp[1].checked){
//		apro_step = formObj.login_apro_step.value;
//	}
//	formObj.apro_step.value = apro_step;
//}

/**
 * OnKeyPress 이벤트 처리
 */
function form_keypress() {
	var formObject = document.form;
	switch (event.srcElement.name) {
		case "payment_due_dt_view":
			ComKeyOnlyNumber("payment_due_dt_view","");//숫자만 입력허용
		break;
			
	}
}


/**
 * 설  명 : Form Object Event - onChange <br>
 * @author SHIN DONG IL
 * @version 2013.10.24
 */
function form_change(obj){
	if (obj.readOnly==true){return false;}
	
	obj.value = obj.value.trim();
	if (obj.value==null || obj.value.trim()==''){return false;}
	
	var formObj = document.form;
	var term_dt = "0";
	
	srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
			
		case "payment_due_dt_view":

			if (!ComIsDate(formObj.payment_due_dt_view, "ymd")) {
				errMsg = ComGetMsg("TRS90388","Date format(YYYYMMDD)");
        		ComShowMessage(errMsg);    
				formObj.payment_due_dt_view.value = "";
			}else {
				/*****************************************************************************************
	  			payment_due_dt가 입력가능한 경우는 미주지역인 경우 뿐이며,
				MAX_ISS_DT 이전 날짜나 100이상날짜도 허용하지 않는다.
				*****************************************************************************************/
				if (formObj.max_iss_dt.value != null && 
					formObj.max_iss_dt.value.trim() != '' &&
					formObj.gen_pay_term_view.value != null &&
					formObj.gen_pay_term_view.value.trim() != '') {
					//Issue date와 Payment due date사이의 일 수.
					term_dt = ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt_view.value.trim());
					
					if (term_dt < 0) { //입력받은 Payment due date가 Issue date 보다 빠른 경우
						formObj.payment_due_dt_view.value = formObj.max_iss_dt.value;
					}
					
					if (term_dt > 100) {//입력받은 Payment due date가 Issue date 보다  100일 이상 클 경우 Issue date의 100일 후로 설정 
						formObj.payment_due_dt_view.value = ComGetDateAdd(formObj.max_iss_dt.value, "D", 100, "");
					}
					
					formObj.gen_pay_term_cd.value = ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt_view.value);
					formObj.gen_pay_term_view.value = ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt_view.value);
					formObj.payment_due_dt.value = formObj.payment_due_dt_view.value //COM_APRO_CSR_DTL테이블에 PAY_DUE_DT 컬럼에 저장
				}
			}
		break;
	}
		
}
