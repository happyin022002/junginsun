/*********************************************************************
 * Copyright(c) 2006 CyberLogitec
 * @FileName    : ESD_TES_0001.js
 * @FileTitle   : Marine Terminal Invoice
 * Open Issues      :
 * Change history   :
 * 2009-05-08 [R200905060012]   : TPB I/F SVXXJO COST CODE 누락건 방지
 * 2009-06-08 [N200906080150]   : INV TTL Amount 에러 조치 요청
 * 2009-06-22 : [N200906220001] TES 소급처리용 invoice 기능 추가 및 LEA 처리 로직 추가  
 * 2009-07-08 : [N200907080230]  TES, Retroactive Inv 기능 활성화 요청
 * 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 금액 계산 항목에 추가
 * 								DTL에 EDI로 전송된 MANUAL CNTR목록 존재 여부 DATA 추가 * 
 * 2009-09-16 : [ITM-200900087] 데이타 정제 작업으로 인한 Logic 수정 
 * 2010-05-06 : [CHM-201003712] KRKANY4 에 대한 Carrier Code Mandatory 입력조건 수정요청 
 * 2010-11-11 [CHM-201006940-01] INV AUTO CALC CHECK
 * 2011-04-12 [CHM-201109884-01] lgs_cost_cd가 TMRFMO, edi_flg가 Y가 아닐 경우는 rf_mntr_dys 입력가능하도록 수정함
 * 2011.06.10 [CHM-201111056-01] Split 03-Split 07-ALPS Error 처리 요청
 * 2011.08.17 [E-mail요청] [TES] special character, characterSet problem
 * 2011.09.30 [CHM-201113485][TES] Invoice II7088112 --- detailed data 조회 관련
 * 2011.11.21 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완(수정)
 * 2013.04.03 [CHM-201322399-01] Special Cargo Quotation Project (Break Bulk Cost 추가)
 * 2014-06-19 [CHM-201429211][TES] TES: Double call시 Target yard에서 Get cntr 기능 추가
 * 2015-01-20 [CHM-201430578] TMNL Invoice Manual 입력시 Vol validation 추가
 * 2015-04-01 [CHM-201534782] R/H Volume Ahjustment pop-up에 TPSZ 별 검색조건 추가 
 *                                 Cost calculation tab에서 Save시 R/H Volume Adjustment  화면 자동 Open 
 *********************************************************************/

// 공통전역변수
 
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var beforetab2 = 1;

var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0 ;

var rdObjects = new Array();
var rdCnt = 0;


var io_hidden = '';

var CNTR_TPSZ_CD;
var MT_A_LGS_COST_CD;
var CARR_CD;

//Cost  Calculation과 3rd Data를 연결해 줄 Temp Key
//Page Loading시 - t3sheet OnsearchEnd function에서.. 매번 초기화 시키고, row순서대로 1씩 값 증가
//Manual Cost 입력시 seq 1씩 증가.
var tmp_seq = 0;


var whld_tax_readonly_mode = true;
var costCalculated = "N";   //Cost Calculation이 수행되었는지 확인하는 변수. 2007.02.05 추가
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */


// MR Creation / get CNTR LIST 수행후  R/D Term 필드의 값을 체크하여 I or O 데이타의 체크 플래그
var checkFIO = 0;
 
document.onclick = processButtonClick;

var rtnValue = "";

    /***
     *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
        var formObj = document.form;
        var rdObject 				= rdObjects[0];
        var sheetObject 			= sheetObjects[0];
        var sheetObject1 			= sheetObjects[1];
        var sheetObject2 			= sheetObjects[2];
        var main_hidden  			= sheetObjects[3];
        var vvd_hidden       		= sheetObjects[4];

    	try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				// eBilling - B
				case "btn_EDIinvoiceview":
					var url_str = 'ESD_TES_1001Popup.screen';
					url_str += '?tml_so_ofc_cty_cd='+document.form.tml_so_ofc_cty_cd.value;
					url_str += '&tml_so_seq='+document.form.tml_so_seq.value;
					url_str += '&fm_cre_mode=Y';
					window.showModalDialog(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;");
					break;
				// eBilling - E
					
					// eBilling - B
				case "btn_pre_inquiry_cond":
					var url_str = 'ESD_TES_0013.do';
					url_str += '?pgmNo=ESD_TES_0013';
					url_str += '&pre_cond_inv_no='+document.form.pre_cond_inv_no.value;
					url_str += '&pre_cond_inv_date_type='+document.form.pre_cond_inv_date_type.value;
					url_str += '&pre_cond_fm_prd_dt='+document.form.pre_cond_fm_prd_dt.value;
					url_str += '&pre_cond_to_prd_dt='+document.form.pre_cond_to_prd_dt.value;
					url_str += '&pre_cond_yd_cd='+document.form.pre_cond_yd_cd.value;
					url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
					url_str += '&pre_cond_cost_ofc_cd='+document.form.pre_cond_cost_ofc_cd.value;
					url_str += '&pre_cond_inv_ofc_cd='+document.form.pre_cond_inv_ofc_cd.value;
					url_str += '&pre_cond_tml_inv_sts_cd='+document.form.pre_cond_tml_inv_sts_cd.value;
					url_str += '&pre_cond_csr_no='+document.form.pre_cond_csr_no.value;
					url_str += '&pre_cond_csr_status='+document.form.pre_cond_csr_status.value;
					url_str += '&pre_cond_tml_inv_rjct_sts_cd='+document.form.pre_cond_tml_inv_rjct_sts_cd.value;
					location.href = url_str;
				break;
					

            	case "btn_retrieve":
            	    retrieveAll();
            	    break;

				case "btn_new":
					try {
						tes_removeTESCommonALLIframes();
						tes_removeTESInvoiceCommonALLIframes();
					} catch (e){
					}
					
					document.all.EDILayer01.style.display = "none";
					formObj.edi_flg.value = '';
                    resetSheets();
                    formObj.reset();
                    tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd');
                    formObj.call_yd_ind_seq.Code = '';                  
                    setInitComponent("N");
                    
                    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                    
                    break;

                case "btn_copy":
					document.all.EDILayer01.style.display = "none";
					formObj.edi_flg.value = '';
					var tmp_vndr_seq = formObj.vndr_seq.value;
                    var tmp_yd_cd = formObj.yd_cd.value;
                    var tmp_iss_dt = formObj.iss_dt.value;
                    var tmp_rcv_dt = formObj.rcv_dt.value;
                    resetSheets();
                    formObj.reset();
                    formObj.call_yd_ind_seq.Code = '';         
                    formObj.vndr_seq.value = tmp_vndr_seq;
                    formObj.yd_cd.value = tmp_yd_cd;
                    formObj.iss_dt.value = tmp_iss_dt;
                    formObj.rcv_dt.value = tmp_rcv_dt;
                    
                    validateVndrSeq();
                    validateYardCode();
                    setInitComponent("N");
                    
                    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
                    
                    break;

                case "btn_vndr":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                    	ComShowMessage("Rejected Invoice !!");
                    	return false;
                    }
                    if (formObj.tml_inv_sts_cd		.value == "C") {
                    	ComShowMessage("Confirmed Invoice !!");
                    	return false;
                    }
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                    var classId = "COM_ENS_0C1";
                    var param = '?classId='+classId;
                    var chkStr = dispaly.substring(0,3);

                    // radio PopUp
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
                    } else {
                    	ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
                    	return;
                    }
                    break;


				case "btn_yard":
					if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == "C") {
						ComShowMessage("Confirmed Invoice !!");
						return false;
					}
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_061";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)

					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 770, 480, 'getYard', dispaly);
						
					} else {
						ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
						return;
					}
//					getAccumulateVol();
					break;


				case "btn_cost_ofc":
        	   		if(formObj.cost_ofc_cd.readOnly){
        	   			ComShowMessage(ComGetMsg('TES21024')); //ComShowMessage("Yard Code가 먼저 입력되어야합니다.");
        	   			return false;
        	   		}
					if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == "C") {
						ComShowMessage("Confirmed Invoice !!");
						return false;
					}
					if (formObj.cost_ofc_cd.readOnly) { return false;	}

					var dispaly = '1,0,1,1,1,1,1,1,1,1,1,1';
					var classId = "COM_ENS_071";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)

					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_071.do' + param,  770,  450, 'getOfcCd', dispaly, true);
					} else {
						ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
						return;
					}
					break;

				case "btns_remarks":
					if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd		.value == "C") {
						ComShowMessage("Confirmed Invoice !!");
						return false;
					}
					if (formObj.hld_flg.checked == true) {
						ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk', 'popup_remarks', 300, 140, true);
					}
					break;

                case "btns_calendar1":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == 'C') {
						ComShowMessage('Confirmed Invoice !!');
						return false;
					}
                    var cal = new ComCalendar();
                    cal.select(formObj.iss_dt, 'yyyy-MM-dd');
                    break;

                case "btns_calendar2":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == 'C') {
						ComShowMessage('Confirmed Invoice !!');
						return false;
					}
                    var cal = new ComCalendar();
                    cal.select(formObj.rcv_dt, 'yyyy-MM-dd');
                    break;

                case "btns_accumulate":
					if(formObj.vndr_seq.value == null || formObj.vndr_seq.value == '' ||
					   formObj.yd_cd.value == null || formObj.yd_cd.value == '' || formObj.is_valid_yd_cd.value != 'Y')
							 return false;
					if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage("Rejected Invoice !!");
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == 'C') {
						ComShowMessage('Confirmed Invoice !!');
						return false;
					}
					
					ComOpenWindowCenter('ESD_TES_9220AcumulatePopup.screen', 'popup_accumaulate', 500, 390, true);
					break;

                case "btn_save":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                        ComShowMessage("Rejected Invoice !!");
                        return false;
                    }
                    if (formObj.tml_inv_sts_cd.value == "C") {
    					ComShowMessage("Confirmed Invoice !!");
    					return false;
    				}

    				if(!fnChkEmptyObj(formObj.vndr_seq))   return;
                    if(!fnChkEmptyObj(formObj.inv_no))     return;
                    if(!fnChkEmptyObj(formObj.yd_cd))      return;
                    if(!fnChkEmptyObj(formObj.inv_ofc_cd)) return;
                    if(!fnChkEmptyObj(formObj.cost_ofc_cd))return;
                    if (formObj.curr_cd.Code == null || formObj.curr_cd.Code.trim() == '') {
            			ComShowMessage(ComGetMsg('TES40039')); // ComShowMessage('so header의 currency code가 선택되지 않았습니다.');
            			return false;
            		}
                    if(!fnChkEmptyObj(formObj.ttl_inv_amt))return;
                    if(!fnChkEmptyObj(formObj.iss_dt))     return;
                    if(!fnChkEmptyObj(formObj.rcv_dt))     return;
                    if(ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0){
                        ComShowMessage('Issue date must be earlier than RCV date.'); //ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
                        return false;
                    }
                    
				   if (!isValIssSys(formObj.iss_dt)){ 	
					   return false;
				   } 
				   
				   if (!isValIssSys(formObj.rcv_dt)){ 	
					   return false;
				   }
						   
    				doActionMainHidden(main_hidden, formObj, IBSAVE);
			        break;

			    case "btng_plus":
				    if(formObj.tml_so_ofc_cty_cd.value == '' || formObj.tml_so_seq.value == ''){
				        ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage('Invoice Header가 저장되지 않았습니다.')
				        return false;
				    }
					if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage('Rejected Invoice !!');
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == 'C') {
						ComShowMessage('Confirmed Invoice !!');
						return false;
					}
					// REV_YRMON - 2007.05.08 ... Start
//				    if(check_revYRMON() == false){
//                        return false;
//                    }
				    // REV_YRMON - 2007.05.08 ... END
					if(sheetObjects[4].RowCount>0 && (sheetObject.IsDataModified || sheetObject1.IsDataModified)){
					    ComShowMessage(ComGetMsg('TES40007')); //ComShowMessage('CNTR LIST가 저장되지 않았습니다. CNTR LIST 저장 후 새로운 VVD를 입력하세요.');
					    return false;
					}
					if(sheetObjects[0].RowCount>0 && sheetObject2.RowCount == 0){
					    ComShowMessage(ComGetMsg('TES40014')); //'Cost Calculation 하지 않았습니다. 계산 & 저장 후 새로운 VVD를 입력하세요.');
					    return false;
					}
					if(sheetObjects[4].RowCount>0 && sheetObject2.IsDataModified){
					    ComShowMessage(ComGetMsg('TES40013')); //ComShowMessage('Cost Calculation 결과가 저장되지 않았습니다. 저장 후 새로운 VVD를 입력하세요.');
					    return false;
					}
//					if(ComShowConfirm(ComGetMsg('TES21018'))){//VVD를 추가하시겠습니까?
					    formObj.tab1.selectedIndex = 0;
					    sheetObject.removeAll();
					    sheetObject1.removeAll();
					    sheetObject2.removeAll();
					    ComEnableManyObjects(true, formObj.vvd, formObj.io_bnd_cd, formObj.call_yd_ind_seq);
					    formObj.atb_dt.value = '';
					    formObj.vvd.value = '';
					    formObj.clpt_ind_seq.value = '';
					    comboObjects[1].removeAll();
					    formObj.vvd.focus();
					    ShowCalculatedAmountByVVD();

//					}
					break;

                case "btng_minus":
                    if(formObj.tml_so_ofc_cty_cd.value == '' || formObj.tml_so_seq.value == ''){
				        ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage('Invoice Header가 저장되지 않았습니다.')
				        return false;
				    }
      

				    if(sheetObject.RowCount == 0 && sheetObject1.RowCount == 0 && sheetObject2.RowCount == 0 
				    		&& vvd_hidden.FindText('vvd', formObj.vvd.value+io_hidden+formObj.call_yd_ind_seq.Code+formObj.clpt_ind_seq.value) == -1){
			            formObj.vvd.value = '';
			            formObj.atb_dt.value = '';
			            comboObjects[1].removeAll();

				    }else{
				        listClear();
				    }
					break;

                case "btng_back":
                    if(vvd_hidden.FindText('vvd', formObj.vvd.value+io_hidden+formObj.call_yd_ind_seq.Code+formObj.clpt_ind_seq.value) == vvd_hidden.HeaderRows){
                        ComShowMessage(ComGetMsg('TES21022')); //ComShowMessage('첫번째 페이지 입니다.');
                        return false;
                    }else{
                        findPage(-1);
                    }
                    break;

                case "btng_next":
                    if(vvd_hidden.FindText('vvd', formObj.vvd.value+io_hidden+formObj.call_yd_ind_seq.Code+formObj.clpt_ind_seq.value) == vvd_hidden.RowCount){
                        ComShowMessage(ComGetMsg('TES21023')); //ComShowMessage('마지막 페이지 입니다.');
                        return false;
                    }else{
                        findPage(1);
                    }
                    break;

                case "t1btng_getcntr":
                    if(formObj.tml_so_ofc_cty_cd.value == null || formObj.tml_so_ofc_cty_cd.value == ''){
                        ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage('Invoice Header정보가 저장되지 않았습니다.');
                        return false;
                    }
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                        ComShowMessage('Rejected Invoice !!');
                        return false;
                    }
                    if (formObj.tml_inv_sts_cd.value == 'C') {
                        ComShowMessage('Confirmed Invoice !!');
                        return false;
                    }
                    
                    if(!fnChkEmptyObj(formObj.vndr_seq))  return;
                    if(!fnChkEmptyObj(formObj.yd_cd))     return;
                    if(!fnChkEmptyObj(formObj.rcv_dt))    return;
                    if(!fnChkEmptyObj(formObj.vvd))       return;
                    //io_bnd_cd 를 필수체크로 추가  2011.09.26 박성호
                    if(!fnChkEmptyObj(formObj.io_bnd_cd)) return;
                    //-------------------------------------------
                    if(!fnChkEmptyObj(formObj.atb_dt))    return;

                    if(sheetObject.RowCount > 0 || sheetObject1.RowCount > 0){
                        if(ComShowConfirm(ComGetMsg('TES40032', formObj.vvd.value+formObj.io_bnd_cd.value))){//해당 VVD '의 모든 Data를 삭제하시겠습니까? '
                            sheetObject.RemoveAll();
                            sheetObject1.RemoveAll();
                            doActionIBSheet1(sheetObject,formObj,IBCLEAR);
                        }else{
                            return false;
                        }
                    }

                    /** [CHM-201429211] calling port의 yard가 복수일 경우 port값과 calling이 되는 port의 모든 yard를 combo에 뿌리고 사용자에 의해 선택가능하게 하기 위해 9010에 추가로 값을 넘김 (털보 요청)  **/
                    window.showModalDialog('ESD_TES_9010.do?yd_cd='+formObj.yd_cd.value+'&vvd='+formObj.vvd.value+'&cntr_tpsz_cd='+CNTR_TPSZ_CD, window, 'dialogWidth:510px; dialogHeight:585px; help:no; status:no; resizable:yes;');
					// MR Creation / get CNTR LIST 수행후  R/D Term 필드의 값을 체크하여 I or O 데이타의 체크 플래그
					CheckFIOLists();
                    break;

                case "t1btng_save":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                        ComShowMessage('Rejected Invoice !!');
                        return false;
                    }
                    if (formObj.tml_inv_sts_cd.value == 'C') {
                        ComShowMessage('Confirmed Invoice !!');
                        return false;
                    }
                    if(formObj.tml_so_ofc_cty_cd.value == null || formObj.tml_so_ofc_cty_cd.value == ''){
                        ComShowMessage(ComGetMsg('TES21005')); //ComShowMessage('Invoice Header정보가 저장되지 않았습니다.');
                        return false;
                    }

                    if(formObj.page.value == ''){
                        ComShowMessage('[CASE 1] The system will retrieve the invoice data automatically due to the error to call the related information. \nPlease input the VVD data again for invoice auditing after completion of retrieve.');
                        retrieveAll();
                        return false;
                    }
                    if(CheckCNTRListMandatoryCol() == false){
                        return false;
                    }
   
                    if(formObj.edi_flg.value == 'Y'){
                        if(sheetObject2.RowCount > 0 && sheetObject2.FindText('calc_tp_cd','Auto Calculated Cost')>0){
                            needRecalculation();
                            return false;
                        }
                    }else{
                        if(sheetObject2.RowCount > 0 ){
                            needRecalculation();
                        }
                    }
                    
                    if (formObj.atb_dt.value=='' || formObj.atb_dt.value==null) {
                        ComShowMessage(ComGetMsg('TES40036'));
                        return false;
                    }

                    // Coincidence 에서 Container Verify Result 'CO', 'HO' 가 아니면 alert후 통과 ( 4342. 01. 28 - LGH과장 요청 )
                    var verifyCnt    = 0;
                    for ( var i = sheetObject.HeaderRows; i < sheetObject.HeaderRows + sheetObject.RowCount; i++ ) {
            			
            			// Verify Result "CO", "HO"가 아닌경우 +1 ( 4342. 01. 28 - LGH과장 요청 )
//            			if(sheetObject.CellValue(i,'dscr_ind_cd') != 'CO' && sheetObject.CellValue(i,'dscr_ind_cd') != 'HO' ){
            			if(sheetObject.CellValue(i,'dscr_ind_cd') != '' && sheetObject.CellValue(i,'dscr_ind_cd') != 'HO' ){                            
            				verifyCnt++;
                        }    
                    }
                    
                    if ( verifyCnt > 0 ) {
                       ComShowMessage("There are containers without correct verify result.\nPlease check whether container list, VVD, bound, F/M are correctly input.");
                    }
                    
                    doActionIBSheet1(sheetObject, formObj, IBSAVE);
                    break;

                case "t1btng_downexcel":
                    doActionIBSheet1(sheetObject,formObj,IBDOWNEXCEL);
                    break;

                case "t1btng_clear":
                    listClear();
                    break;

                case "t1btng_todiscrepancy":
                	if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                		ComShowMessage('Rejected Invoice !!');
                		return false;
                	}
                	if (formObj.tml_inv_sts_cd.value == 'C') {
                		ComShowMessage('Confirmed Invoice !!');
                		return false;
                	}
                	if (sheetObject.RowCount < 1){
                		ComShowMessage(ComGetMsg('TES21008')); //ComShowMessage('변환할 데이터가 없습니다.');
                		return false;
                	}
                	if (sheetObject.CheckedRows('chk') < 1){
                		ComShowMessage(ComGetMsg('TES21009')); //ComShowMessage('선택된 데이터가 없습니다.');
                		return false;
                	}
                    modifyContainerVerifyStatus(sheetObject, sheetObject1, 'DC', '');
                	break;

                case "t1btng_costcalc":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                        ComShowMessage('Rejected Invoice !!');
                        return false;
                    }
                    if (formObj.tml_inv_sts_cd.value == 'C') {
                        ComShowMessage('Confirmed Invoice !!');
                        return false;
                    }
                    var auto_cnt = 0;

                    if(!isValidAgmtSts()){
                        return false;
                    }

                    if(CheckCNTRListMandatoryCol() == false){
                        return false;
                    }

//                    if(!isValidAgmtCurrCD()){
//                        return false;
//                    }

                    // EDI로 접수된 Invoice는 Manual 비용이 있더라도 계산이 가능하다.
                    // 일반적인 Invoice의 경우만 계산된 결과가 있는지 확인한다.    --- 2008.04.30  eBilling
                    if(sheetObject2.RowCount > 0){
                        if(formObj.edi_flg.value == 'Y'){
                            var calc_flg = 'N';
                            for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
                                if(sheetObject2.CellValue(i,'calc_tp_cd')=='A'){
                                    calc_flg = 'Y';
                                }
                            }
                            if(calc_flg == 'Y'){
                                ComShowMessage('AutoCalculated Costs exist. Calculate after deleting auto calculated costs.');
                                return false;
                            }
                        }else{
                            ComShowMessage(ComGetMsg('TES40053')); //ComShowMessage('이미 계산된 결과가 존재합니다. 계산결과 삭제 후 Calculation 하십시오.');
                            return false;
                        }
                    }

                    if(sheetObject.IsDataModified || sheetObject1.IsDataModified){
                        ComShowMessage(ComGetMsg('TES21011')); //ComShowMessage('CNTR List에 변경된 data가 있습니다. 저장 후 Calculate하십시오');
                        return false;
                    }


                    formObj.tab1.selectedIndex = 2;
                    doActionIBSheet3(sheetObject2,formObj,IBSEARCH);
                    if(formObj.accm_seq.value != ''){
                        doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
                    }
                    break;

                case "t2btng_clear":
                    listClear();
                    break;


                case "t2btng_reverify":
                    if(sheetObject.RowCount == 0 && sheetObject1.RowCount == 0){
                        ComShowMessage(ComGetMsg('TES21017'));
                        return false;
                    }
                    doActionIBSheet2(sheetObject1,formObj,IBSEARCH);
                    break;

                case "t2btng_coincidence":
                	if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                		ComShowMessage('Rejected Invoice !!');
                		return false;
                	}
                	if (formObj.tml_inv_sts_cd.value == 'C') {
                		ComShowMessage('Confirmed Invoice !!');
                		return false;
                	}
                	if (sheetObject1.RowCount < 1){
                		ComShowMessage(ComGetMsg('TES21008')); //ComShowMessage('변환할 데이터가 없습니다.');
                	    return false;
                	}
                	if (sheetObject1.CheckedRows('chk') < 1){
                		ComShowMessage(ComGetMsg('TES21009')); //ComShowMessage('선택된 데이터가 없습니다.');
                		return false;
                	}
                    modifyContainerVerifyStatus(sheetObject1, sheetObject, 'CO', 'Y');
                	break;
                	
                case "t2btng_chkdgit":
                	if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                		ComShowMessage('Rejected Invoice !!');
                		return false;
                	}
                	if (formObj.tml_inv_sts_cd.value == 'C') {
                		ComShowMessage('Confirmed Invoice !!');
                		return false;
                	}
                	
        			if (sheetObject1.RowCount > 0) {
        				doActionIBSheet2(sheetObject1,formObj,IBSEARCH_ASYNC01);
        			}
                    
                	break;
                	

                case "t2btng_reject":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                    	ComShowMessage('Rejected Invoice !!');
                    	return false;
                    }
                    if (formObj.tml_inv_sts_cd.value == 'C') {
                    	ComShowMessage('Confirmed Invoice !!');
                    	return false;
                    }
                    if (sheetObject1.RowCount < 1){
                    	ComShowMessage(ComGetMsg('TES21012')); //ComShowMessage('계산 할 데이터가 없습니다.');
                        return false;
                    }
                    ComOpenWindowCenter('ESD_TES_9020RejectPopup.screen?rjct_sts_inp_nm=inv_rjct_rmk&rjct_fn_nm=rjctInv', 'popup_reject', 300, 200, true);
                    break;

                case "t2btng_print":
                    var fromObj = new Array();
                    var rdObj  	= new Array();
                    var parmObj = new Array();
                    fromObj[0] = formObj;// Form Data를 RD 로 보내기 위해 배열로담는다

                    if ( sheetObjects[3].RowCount < 1 || sheetObjects[1].RowCount < 1 ){ // RD 로 보낼 sheet 에 데이타가 없으면 Error
                        ComShowMessage(ComGetMsg('TES21013')); //ComShowMessage('Not Exist Discrepancy Container List Data!');
                        return;
                    }
                    
                    // RD 로 보내기 위한 설정
                    parmObj[0] = '1';
                    parmObj[1] = '';
                    parmObj[2] = 'N';
                    parmObj[3] = RD_path+'apps/alps/esd/tes/serviceproviderinvoicemanage/marineterminalinvoicemanage/report/ESD_TES_0805.mrd';     // RD 화면
                    parmObj[4] = rdObj;
                    parmObj[5] = fromObj;
                    rdObjModaless(RdReport , parmObj , 1000 ,700);
					break;

                case "t2btng_downexcel":
                    doActionIBSheet2(sheetObject1,formObj,IBDOWNEXCEL);
                    break;

                //2008-10-27 LGH대리 요청 TM BOUND 자동배분 --사용안함 주석처리 되있음.
                case "t3btng_allocate":
					
					var url_str = 'ESD_TES_1003Popup.screen';
				    url_str = url_str + '?tml_so_ofc_cty_cd='+formObj.tml_so_ofc_cty_cd.value;
				    url_str = url_str + '&tml_so_seq='+formObj.tml_so_seq.value;	 		
				    window.showModalDialog(url_str, window, "dialogWidth:800px; dialogHeight:425px; help:no; status:no; resizable:yes;");
					
					break;
				
                case "t3btng_clear":
                    listClear();
                    break;	
					
                case "t3btng_bb":
                	var vvd = formObj.vvd.value;
                	var yd_cd = formObj.yd_cd.value;
                	var tml_so_ofc_cty_cd = formObj.tml_so_ofc_cty_cd.value;
                	var tml_so_seq = formObj.tml_so_seq.value;
                	var io_bnd_cd = formObj.io_bnd_cd.value;
                	var atb_dt = formObj.atb_dt.value;
                	
                	var bkg_no = sheetObject2.CellValue(sheetObject2.SelectRow, "bkg_no");
            		for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
            			 if(sheetObject2.CellValue(i, "ibflag") == "I" || sheetObject2.CellValue(i, "ibflag") == "D" || sheetObject2.CellValue(i, "ibflag") == "U"){
            			 ComShowCodeMessage('TES23021');  // 'There is modified data.\n\n Please save first.'
            			 return false;
            			 }
            		}
            		var sUrl = "/hanjin/ESD_TES_0058.do?vvd="+vvd+"&yd_cd="+yd_cd+"&tml_so_ofc_cty_cd="+tml_so_ofc_cty_cd+"&tml_so_seq="+tml_so_seq+"&bkg_no="+bkg_no+"&io_bnd_cd="+io_bnd_cd+"&atb_dt="+atb_dt;
            		ComOpenPopup(sUrl, 1100, 550, "", "0,0", true);
            		//ComOpenPopup(sUrl, 1100, 750, "", "0,0", true);
            		retrieveAll();
                	break;

                case "t3btng_rowadd":
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                        ComShowMessage('Rejected Invoice !!');
                    	return false;
                	}
                    if (formObj.tml_inv_sts_cd.value == 'C') {
                        ComShowMessage('Confirmed Invoice !!');
                        return false;
                    }

                    if(formObj.vvd.value == '' || formObj.atb_dt.value == ''){
                        ComShowMessage('VVD must be entered before you input cost calculation data manually!');
                        return false;
                    }

                    var vvd_row = vvd_hidden.FindText('vvd', formObj.vvd.value+io_hidden+formObj.call_yd_ind_seq.Code+formObj.clpt_ind_seq.value);

                    if(vvd_row < 0){
                        ComShowMessage('[CASE 2] The system will retrieve the invoice data automatically due to the error to call the related information. ' +
                                '\nPlease input the VVD data again for invoice auditing after completion of retrieve.');
                        retrieveAll();
                        return false;
                    }
                    if(vvd_hidden.CellValue(vvd_row, 'vvd_vsl_cd') == '' || vvd_hidden.CellValue(vvd_row, 'vvd_skd_voy_no')==''
                         || vvd_hidden.CellValue(vvd_row, 'vvd_skd_dir_cd') == '' || vvd_hidden.CellValue(vvd_row, 'vvd_atb_dt')==''){
                        ComShowMessage('[CASE 3] The system will retrieve the invoice data automatically due to the error to call the related information. ' +
                                '\nPlease input the VVD data again for invoice auditing after completion of retrieve.');
                        retrieveAll();
                        return false;
                    }

                    //VVD 입력 후 CNTR List 없이 Cost 만입력할 경우 VVD 입력란을 비활성화하여 VVD누락 현상 방지함   --- 2007.12.26
                    if(sheetObject.RowCount==0 && sheetObject1.RowCount == 0 && sheetObject2.RowCount == 0){
                        ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd, formObj.call_yd_ind_seq);
                    }

                    // CHM-201640694 Cost Calculation Tab에서 Multi-Row Add기능 추가 - 2016-04-01
					for (var i = 0; i < formObj.rowsadd.value; i++) {

						var row = sheetObject2.DataInsert(-1);
						sheetObject2.CellValue2(row,'calc_cost_grp_cd') = 'TM';
						sheetObject2.CellValue2(row,'calc_tp_cd') = 'M';
						sheetObject2.CellValue2(row,'cntr_tpsz_cd') = '';
						sheetObject2.CellValue2(row,'io_bnd_cd') = io_hidden;
						sheetObject2.CellValue2(row,'dcgo_ind_cd') = 'N';
						sheetObject2.CellValue2(row,'vol_tr_ut_cd') = '';
						sheetObject2.CellComboItem(row, 'lgs_cost_cd', formObj.calcTerminalComboItemsDesc.value, formObj.calcTerminalComboItems.value);
						sheetObject2.CellValue2(row,'lgs_cost_cd') = '';
						sheetObject2.CellValue2(row,'tml_crr_cd') = '';
						sheetObject2.CellValue2(row,'ioc_cd') = '';
						sheetObject2.CellValue2(row,'rc_flg') = '';
						sheetObject2.CellValue2(row,'lane_cd') = '';
						sheetObject2.CellValue2(row,'tml_wrk_dy_cd') = '';
						sheetObject2.CellValue2(row,'inv_xch_rt') = '1.00';
						sheetObject2.CellValue2(row,'vsl_cd')= vvd_hidden.CellValue(vvd_row, 'vvd_vsl_cd');
						sheetObject2.CellValue2(row,'skd_voy_no')= vvd_hidden.CellValue(vvd_row, 'vvd_skd_voy_no');
						sheetObject2.CellValue2(row,'skd_dir_cd')= vvd_hidden.CellValue(vvd_row, 'vvd_skd_dir_cd');
						sheetObject2.CellValue2(row,'atb_dt')= vvd_hidden.CellValue(vvd_row, 'vvd_atb_dt');
						if(ida_ofc_cd == 'Y'){
							sheetObject2.CellValue2(row,'ida_pay_tp_cd') = 'S';
						}
							
						//3rd data와 so_dtl data를 연결시키는 가상의 Key.
						//가상 key를 활용해 so_dtl data 수정시 바로 3rd Hidden data에도 적용시킬 수 있도록 한다.
						sheetObject2.CellValue2(row,'page_rows') = tmp_seq ++;
						
						setShtCellsEditable(sheetObject2,row,'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg','Y');
					}
                    break;

                case "t3btng_rowdel":
                    var flag = false; //이미 저장된 Data를 삭제할 경우 true가 되어 Data 삭제함
                    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                        ComShowMessage('Rejected Invoice !!');
                    	return false;
                    }
                    if (formObj.tml_inv_sts_cd.value == 'C') {
                        ComShowMessage('Confirmed Invoice !!');
                        return false;
                    }

                    if (sheetObject2.RowCount > 0){
                        var selectedRow = sheetObject2.GetSelectionRows('|').split('|');
                        for(var i=selectedRow.length-1; i>=0; i--){
                            if (sheetObject2.CellValue(selectedRow[i],"tml_so_dtl_seq")==null
                                  || sheetObject2.CellValue(selectedRow[i],"tml_so_dtl_seq").trim()==''
                                  || parseInt(sheetObject2.CellValue(selectedRow[i],"tml_so_dtl_seq"))==0)
                            {
        						sheetObject2.RowDelete(selectedRow[i], false);
        					} else {
        					    flag = true;
        						sheetObject2.RowStatus(selectedRow[i]) = 'D';
        						sheetObject2.RowHidden(selectedRow[i]) = true;
        						sheetObject2.CellValue2(selectedRow[i],"inv_amt") = 0; // 어짜피 지울넘... 숨기더라도 총액 계산에 반영되므로 0으로 만들어야 합당...
        					}
                        }
                        if(flag == true){
                            formObj.delete_mode.value = 'ROW';
                            doActionIBSheet3(sheetObject2,formObj,IBDELETE);
            				formObj.delete_mode.value = '';
                        }
                    }
                    break;

				case "t3btng_save":
				    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
                        ComShowMessage('Rejected Invoice !!');
                        return false;
                    }
                    if (formObj.tml_inv_sts_cd.value == 'C') {
                        ComShowMessage('Confirmed Invoice !!');
                        return false;
                    }

                    if (formObj.atb_dt.value=='' || formObj.atb_dt.value==null) {
                        ComShowMessage(ComGetMsg('TES40036'));
                        return false;
                    }
                    
                    //cost_code 중복 체크               
                    if(costCodeDupCheck() == false) {
						ComShowMessage("Vol and Rate are mandatory, add it each.");
						return false;
					}
					
					for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
						 var costCd = sheetObject2.CellValue(i,'lgs_cost_cd');
						 var calRmk = sheetObject2.CellValue(i,'calc_rmk').trim();
						 var tpsz = sheetObject2.CellValue(i,'cntr_tpsz_cd').trim();

//						 if(CostCdValidForCalcRemark('TM',costCd,calRmk) == false){
//							 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
//							 return false;
//						 }
						 
						 if(CostCdValidForCalcTpSz(costCd, tpsz) == false && (sheetObject2.CellValue(i,'vol_tr_ut_cd')=="C" || sheetObject2.CellValue(i,'vol_tr_ut_cd')=="")){
							 ComShowMessage("Reefer EQ should be selected fot your cost code"); 
							 return false;
						 }

//						 if(sheetObject2.CellValue(i,'calc_tp_cd') == "M" && sheetObject2.CellValue(i,'bkg_no') == "" && (sheetObject2.CellValue(i,'calc_vol_qty')==null || sheetObject2.CellValue(i,'calc_vol_qty')==0) 
//								 	&& sheetObject2.CellValue(i,'lgs_cost_cd')!='TPNDTS'  && sheetObject2.CellValue(i,'lgs_cost_cd')!="TPNDTM"){
//							 if(sheetObject2.CellValue(i,'rvis_vol_qty')==null || sheetObject2.CellValue(i,'rvis_vol_qty')==0){
//								 ComShowMessage("Plz, input Calculated Vol or Revised Vol. Zero or Null does not allow.");
//								 return false;
//							 }
//						 }
		                    
//						 if( sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'ctrt_rt')==null || sheetObject2.CellValue(i,'ctrt_rt')==0.00)){
//							 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//							 return false;
//						 }
						 
						 //Manaul 입력시 Vol, Rate validation 추가
						 var calcVol = sheetObject2.CellValue(i,'calc_vol_qty').trim();
						 var rvisVol = sheetObject2.CellValue(i,'rvis_vol_qty').trim();
						 var ctrtRt = sheetObject2.CellValue(i,'ctrt_rt').trim();
						 
						 //UOM이 C인 경우는 모두 필수 입력
						 if(sheetObject2.CellValue(i,'vol_tr_ut_cd') == 'C') {
							 if(isValidForVolRate(calcVol, rvisVol, ctrtRt) == false) {
								 ComShowMessage("Vol and Rate are mandatory, add it each.");
								 return false;
							 }
						 }
						 
						 if(sheetObject2.CellValue(i,'calc_tp_cd') == 'M' || sheetObject2.CellValue(i,'calc_tp_cd') == 'S'){	//Manual Input or semi-update   
							 if(sheetObject2.CellValue(i,'vol_rt_chk_flg') == 'Y') {
								 if(isValidForVolRate(calcVol, rvisVol, ctrtRt) == false) {
									 ComShowMessage("Vol and Rate are mandatory, add it each.");
									 return false;
								 }
							 }
						 }
						 
						 //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
						 // A인 경우는 4개의 Invoice에서 모두 필수 이면서 10자이상 입력, TM화면에서 Y인 경우는 Remark값이 필수 
						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'A' && calRmk.length < 10) {
							 ComShowMessage(ComGetMsg('TES10128'));
							 return false;
						 }
						 
						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'Y' && calRmk.length == 0) {
							 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
							 return false;
						 }
					}

				    // REV_YRMON - 2007.05.08 ... Start
//				    if(check_revYRMON() == false){
//                        return false;
//                    }
				    // REV_YRMON - 2007.05.08 ... END

				    needRecalculation();
				    if(checkCostCalculation() == false){
				        return false;
				    }

				    doActionIBSheet3(sheetObject2,formObj,IBSAVE);
				    
				    //[CHM-201534782]Cost calculation tab에서 Save시 R/H Volume Adjustment  화면 자동  Open
				    openRhVolumeAdj();
				    
					break;

				case "t3btng_totalamount":
					var url_str = "ESD_TES_9040Pop.screen";
					window.showModalDialog(url_str, window, "dialogWidth:510px; dialogHeight:410px; help:no; status:no; resizable:yes;");
					break;

				case "t3btng_confirm":  // t3btng_save Cost Calculation 저장후 confirm 함.즉 저장된내용에대해서만 confirm.
				    if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
						ComShowMessage('Rejected Invoice !!');
						return false;
					}
					if (formObj.tml_inv_sts_cd.value == 'C') {
						ComShowMessage('Confirmed Invoice !!');
						return false;
					}
					if(ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0){
                        ComShowMessage('Issue date must be earlier than RCV date.'); //ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
                        return false;
                    }
					
				   if (!isValIssSys(formObj.iss_dt)){ 	
					   return false;
				   } 
				   
				   if (!isValIssSys(formObj.rcv_dt)){ 	
					   return false;
				   }
				   
				   if(ida_ofc_cd == 'Y'){
					   if(formObj.ida_cgst_amt.value != formObj.tot_cgst_amt.value) {
						   	ComShowMessage(ComGetMsg('TES21056')); //ComShowMessage("CGST AMT and calculated CGST AMT do not match."); 
							return false;
					   }
					   if(formObj.ida_sgst_amt.value != formObj.tot_sgst_amt.value) {
						   	ComShowMessage(ComGetMsg('TES21057')); //ComShowMessage("SGST AMT and calculated SGST AMT do not match."); 
							return false;
					   }
					   if(formObj.ida_igst_amt.value != formObj.tot_igst_amt.value) {
						   	ComShowMessage(ComGetMsg('TES21058')); //ComShowMessage("IGST AMT and calculated IGST AMT do not match."); 
							return false;
					   }
					   if(formObj.ida_ugst_amt.value != formObj.tot_ugst_amt.value) {
						   	ComShowMessage(ComGetMsg('TES21059')); //ComShowMessage("UGST AMT and calculated UGST AMT do not match."); 
							return false;
					   }
				   }
				    
                    if(formObj.ttl_inv_amt.value != formObj.tot_inv_amt.value){
						ComShowMessage(ComGetMsg('TES21016')); //ComShowMessage("INV AMT 와 Calculated AMT 값이 일치하지않습니다.");
						return false;
					}
					if(sheetObject2.RowCount == 0){
					    ComShowMessage('There is no Calculation data.');
					    return false;
					}
					
					//cost_code 중복 체크
					if(costCodeDupCheck() == false) {
						ComShowMessage("Vol and Rate are mandatory, add it each.");
						return false;
					}

					/* RVIS.VOL과 TPB를 바로 저장으로 변경하면서 confirm시 JO 필수 사항 확인을 한다.  */
					for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
						 //2011.05.11 COST_CD가 'SVSCRF','TMRFGO','TMRFMO','TMRFPL','TMRFPT','TMRFXX'이면 TYPE/SIZE를 넣어야한다.
						// CHM-201432352 [TESLEA] 철도운송 RF 화물 Genset 관련 Cost Code 생성 (TMRFGR) 추가 - 4347-10-13
						 var costCd = sheetObject2.CellValue(i,'lgs_cost_cd');
						 var tpsz = sheetObject2.CellValue(i,'cntr_tpsz_cd').trim();
						 var calRmk = sheetObject2.CellValue(i,'calc_rmk').trim();
						 
						 if(CostCdValidForCalcTpSz(costCd, tpsz) == false && (sheetObject2.CellValue(i,'vol_tr_ut_cd')=="C" || sheetObject2.CellValue(i,'vol_tr_ut_cd')=="")){
							 ComShowMessage("Reefer EQ should be selected fot your cost code"); 
							 return false;
						 }	
						 
						 //20140421 
//						 if(sheetObject2.CellValue(i,'calc_tp_cd') == "M"  && sheetObject2.CellValue(i,'bkg_no') == "" && (sheetObject2.CellValue(i,'calc_vol_qty')==null || sheetObject2.CellValue(i,'calc_vol_qty')==0)
//								 && sheetObject2.CellValue(i,'lgs_cost_cd')!='TPNDTS'  && sheetObject2.CellValue(i,'lgs_cost_cd')!="TPNDTM"){
//							 if(sheetObject2.CellValue(i,'rvis_vol_qty')==null || sheetObject2.CellValue(i,'rvis_vol_qty')==0){
//								 ComShowMessage("Plz, input Calculated Vol or Revised Vol. Zero or Null does not allow.");
//								 return false;
//							 }
//						 }
		                    
//						 if( sheetObject2.CellValue(i,'calc_tp_cd') == "M" && (sheetObject2.CellValue(i,'ctrt_rt')==null || sheetObject2.CellValue(i,'ctrt_rt')==0.00)){
//							 ComShowMessage("Plz, input Rate. Zero or Null does not allow.");
//							 return false;
//						 }						 
						 
						 
						// 20100617 LJE 과장요청  JO이면서 +금액일때만 필수입력값 체크
						if(sheetObject2.CellValue(i,'lgs_cost_cd') == 'SVXXJO' && sheetObject2.CellValue(i,'inv_amt') > 0){
							if( (sheetObject2.CellValue(i,'rvis_vol_qty') ==''||sheetObject2.CellValue(i,'rvis_vol_qty') == 0)
								|| (sheetObject2.CellValue(i,'n3pty_flg') == ''||sheetObject2.CellValue(i,'n3pty_flg') != 'Y')|| sheetObject2.CellValue(i,'tml_crr_cd') == '')
							{
								ComShowMessage(ComGetMsg('TES40022')); //ComShowMessage('SVXXJO에 Revised Vol / 3rd Party / Carrier 는 필수 입력사항입니다.');
								return false;
							}
							// 20100617 LJE 과장요청 JO조건도 -금액 입력 가능 주석처리함.
//							if(sheetObject2.CellValue(i,'inv_amt') <= 0){
//								ComShowMessage('Amount should be bigger than 0 when you have 3rd Party(SVXXJO).');
//								return false;
//							}
						}
						
						//Manaul 입력시 Vol, Rate validation 추가
						var calcVol = sheetObject2.CellValue(i,'calc_vol_qty').trim();
						var rvisVol = sheetObject2.CellValue(i,'rvis_vol_qty').trim();
						var ctrtRt = sheetObject2.CellValue(i,'ctrt_rt').trim();
						 
						//UOM이 C인 경우는 모두 필수 입력
						if(sheetObject2.CellValue(i,'vol_tr_ut_cd') == 'C') {
							if(isValidForVolRate(calcVol, rvisVol, ctrtRt) == false) {
								ComShowMessage("Vol and Rate are mandatory, add it each.");
								return false;
							}
						}
						
						if(sheetObject2.CellValue(i,'calc_tp_cd') == 'M' || sheetObject2.CellValue(i,'calc_tp_cd') == 'S'){	//Manual Input or semi-update   
							 if(sheetObject2.CellValue(i,'vol_rt_chk_flg') == 'Y') {
								 if(isValidForVolRate(calcVol, rvisVol, ctrtRt) == false) {
									 ComShowMessage("Vol and Rate are mandatory, add it each.");
									 return false;
								 }
							 }
						 }
						
						 //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
						 // A인 경우는 4개의 Invoice에서 모두 필수 이면서 10자이상 입력, TM화면에서 Y인 경우는 Remark값이 필수 
						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'A' && calRmk.length < 10) {
							 ComShowMessage(ComGetMsg('TES10128'));
							 return false;
						 }
						 
						 if(sheetObject2.CellValue(i,'rmk_chk_flg') == 'Y' && calRmk.length == 0) {
							 ComShowMessage("Plz, Input Remarks in Cost Calculation Tab"); 
							 return false;
						 }
						 
						 //[CHM-201642800]VGM Cost Code 4개 관련 TPB Billing강제화 및 Billing Case Match강제화 
						 if(sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGSC' || sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGWC'
							 || sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGPF' || sheetObject2.CellValue(i,'lgs_cost_cd') == 'TMVGXX'){
							 if(sheetObject2.CellValue(i,'n3pty_flg') == '' || sheetObject2.CellValue(i,'n3pty_flg') != 'Y'){
								 ComShowMessage(ComGetMsg('TES21702'));
								 return false;
							 }
						 }
					}

					needRecalculation();
					if(checkCostCalculation() == false){
				        return false;
				    }
				    // TPB IF SVXXJO N3PTY_FLG 누락 방지위한 Confirm 구분값 ( 2009-05-07 ) C : Confirm
				    document.getElementById("costCalcFlg").value = "C";
 
				    //save 'Detailes' inadvance to keep 'curr_cd in detail' from saving in header
				    doActionIBSheet3(sheetObject2,formObj,IBSAVE);
 
		            doActionMainHidden(main_hidden, formObj, IBSEARCH_ASYNC01);
					break;
					
				
					
				case "t3btng_costCal":
				     var param = "?yd_cd="+formObj.yd_cd.value +"&yd_nm="+formObj.yd_nm.value +"&vvd="+formObj.vvd.value  +"&vndr_seq="+formObj.vndr_seq.value+"&vndr_seq_nm="+formObj.vndr_seq_nm.value+"&prgm_id=ESD_TES_0001&cost_cd_inv_tp_cd=MT&atb_dt="+formObj.atb_dt.value;
				   //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
				    ComOpenPopup("ESD_TES_9001.do" + param,   820,    670,     "setCostCode",  "1,0,1,1,1,1,1", true,   false,    null, null,  null,     'Cost Calculation','no');
               	break;
					
					
            } // end switch
    	}catch(e) {
    		if( e == '[object Error]') {
    			ComShowCodeMessage('TES21025'); //ComShowMessage('지금은 사용하실 수가 없습니다 ');
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

	/**
	 * 폼값을 체크함
	 * @param {form} formObj   form object 
	 * @return
	 */		
	function fnChkSearchForm(formObj){
		if(!fnChkEmptyObj(formObj.vndr_seq)) return false;
		if(!fnChkEmptyObj(formObj.inv_no)) return false;
		return true;
	}

	/** 엔터키 코드 체크 함
	 * 
	 * @param {String} funcNm	function name
	 * @return
	 */
	function enterCheck(funcNm){
        var formObj = document.form;
		if (funcNm==undefined || funcNm==null || funcNm.trim()==''){return false;}
		if (event.keyCode == 13){retrieveAll();}
	}


    /**
     * 단일 Object Validation
     *
     * @param {object} obj    - validation할 object
     * 예 : fnChkEmptyObj(obj)
     *      해당 object에 desc= ''를 기술해놓는다.
     */
 	function fnChkEmptyObj(obj){
 	    if (obj.type == 'text' || obj.type == 'textarea' ||obj.type == 'password' || obj.type == 'file' ) {
 	        if (obj.value == null || obj.value == '') {
 	            ComShowMessage(ComGetMsg('TES21026',obj.desc));//msg1+'값이 입력되지 않았습니다.';
 	            obj.focus();
 	            return false;
 	         }
 	    }else if (obj.type.indexOf('select') != -1) {
 	        if (obj.selectedIndex == -1) {
 	            ComShowMessage(ComGetMsg('TES21026', obj.desc));
                obj.focus();
                return false;
 	        }
 	    }else if (obj.type == 'radio') {
 	        var group = formObj[obj.name];
 	        var checked = false;
 	        if (!group.length){
 	            checked = obj.checked;
 	        }else{
 	            for (var r = 0; r < group.length; r++){
 	                if ((checked = group[r].checked)){ break; }
 	            }
 	        }
 	        if (!checked) {
 	            ComShowMessage(ComGetMsg('TES21027',obj.desc));//msg1+'값이 선택되지 않았습니다.';
 	            obj.focus();
 	            return false;
 	        }
		}else if (obj.type == 'checkbox') {
		    var group = formObj[obj.name];
		    if (group.length) {
    		    var checked = false;
    		    for (var r = 0; r < group.length; r++){
    		        if ((checked = group[r].checked)){ break; }
    		    }
    		    if (!checked) {
    		        ComShowMessage(ComGetMsg('TES21027',obj.desc));//msg1+'값이 선택되지 않았습니다.';
    		        obj.focus();
    		        return false;
    		    }
    		}
		}
 	    
		return true;
	}

/**
 * 필수입력 Form Validation
 *
 * @param {from} obj    - validation할 object
 * 예 : validChkForm(formObj)
 *      해당 object에 valid='1'  desc= ''를 기술해놓는다.
 */
	function validChkForm(formObj){
		for (var e = 0; e < formObj.elements.length; e++) {
		    var el = formObj.elements[e];
		    if(el.valid == '1'){
		        if(!fnChkEmptyObj(el)) return false;
		    }
		}
		return true;
	}


   /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {ibsheet}	sheet_obj   sheet object
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
        sheetObjectsMap[sheet_obj.id]= sheet_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	//ComShowMessage('loadPage');
        for(i=0;i< comboObjects.length;i++){
            initCombo (comboObjects[i],i+1);
        }
        /* Moving to 'setCalcColFormat' methods

        try	{
			tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');
			tes_getInputValueInvoice('whld_tax_amt_mode', SEARCH05, 'inv_ofc_cd', 'setWhldTaxAmtMode');
			tes_getInputValue('manual_lgs_cost_cd', SEARCH16, 'calc_cost_grp_cd','');

		} catch(e){}  
		*/

        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(i=0;i<tabObjects.length;i++){
            initTab(tabObjects[i],i+1);
        }

        var formObj = document.form;
        
        try	{
        	//login user의 default office와 로그인한 office가 같은지 체크 
        	if(formObj.pre_cond_inv_no.value == ''){
        		tes_getInputValue('chk_ofc_cd', SEARCH25, '', 'checkLoginOfc');  
        	}
        	      	
        	tes_getComboItem('curr_cd', 1, SEARCH03, '', 'inv_ofc_cd', 'setCalcColFormat');

        } catch(e){}
       
        setInitComponent('N');
        tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("vndr_seq|inv_no"));
           
        //formObj.vndr_seq.focus();
        
        //India Info Display
    	if(ida_ofc_cd == 'Y'){
    		document.all.IndiaLayer01.style.display = "inline";
    		document.all.IndiaLayer02.style.display = "inline";
    		
    	} else {
    		document.all.IndiaLayer01.style.display = "none";
    		document.all.IndiaLayer02.style.display = "none";
    		
    	}
    }
    
    /** tax mod 결정 
     * 
     * @return
     */ 
    function setWhldTaxAmtMode(){
		var formObj = document.form;
		var tmp = '';
		tmp = formObj.whld_tax_amt_mode.value;
		if (tmp!=undefined && tmp!=null && tmp.trim()=='Y'){
			whld_tax_readonly_mode = false;
		} else {
			whld_tax_readonly_mode = true;
		}
	}
    
    /** 데이타 값 설정
     * 
     * @return
     */
    function setCalcColFormat(){
		resetSheetDataProperty(comboObjects[0].Code);
		try	{
			tes_getInputValue('tmp_common_code', SEARCH17, '', 'setCommonCode');  //alert("tes_getInputValue");
			tes_getInputValueInvoice('whld_tax_amt_mode', SEARCH05, 'inv_ofc_cd', 'setWhldTaxAmtMode');
			tes_getInputValue('manual_lgs_cost_cd', SEARCH16, 'calc_cost_grp_cd','');		
		} catch(e){}
	}
    
    /** 공통코드 설정
     * 
     * @return
     */
    function setCommonCode(){//alert("start setCommonCode");
		var formObj = document.form;
		var tmp = '';
		if (formObj.tmp_common_code.value!=undefined && formObj.tmp_common_code.value!=null && formObj.tmp_common_code.value.trim()!=''){
			tmp = formObj.tmp_common_code.value.split('--');
			if (tmp.length > 0){
				for (var i=0; i<tmp.length; i++){
					tmp[i] = (tmp[i]!=undefined&&tmp[i]!=null?tmp[i]:'');
				}
				CNTR_TPSZ_CD		= tmp[0];
				MT_A_LGS_COST_CD	= tmp[1];
				CARR_CD             = tmp[6];
			}
		}
		for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
		}

		//Invoice Summary 화면에서 이동시 바로 조회하도록 함
        var sheetObject_main= sheetObjects[3];
        if(!ComIsNull(formObj.inv_no_tmp.value)){
        // [TES] special character, characterSet problem
            formObj.inv_no.value =  formObj.inv_no_tmp.value;
            formObj.vndr_seq.value = vndr_seq;
            retrieveAll();
        }
	}

    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param (object)	combo_obj	combo object
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
     
    /** Combo 기본 설정 
     *  Combo의 항목을 설정한다.
     * @param {comoObj}	comboObj	combo Object
     * @param {int}		comboNo 	combo no
     * @param {String}	combo_val 	combo value
     * @param {String}	def_val 	def value
     */ 
    function initCombo (comboObj, comboNo, combo_val, def_val) {
        var cnt  = 0 ;

        switch(comboNo) {

            case 1:   //currency
                with (comboObj) {
                    SetColAlign('center');
					SetColWidth('90');
					DropHeight=150;

					var tmp = '';
					if (combo_val!=null){tmp = combo_val.split('|');}
					for (var i=0; tmp!=null && i<tmp.length; i++){
						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
					}
					if (def_val!=undefined && def_val!=null && def_val.trim()!=''){
						Code = def_val;
					} else {
						Code = '';
					}
				}
                break;
                
            case 2:   //call_yd_ind_seq
                with (comboObj) {
                    SetColAlign('center');
					SetColWidth('40');
					DropHeight=20;

					var tmp = '';
					if (combo_val!=null){tmp = combo_val.split('|');}
					for (var i=0; tmp!=null && i<tmp.length; i++){
						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
					}
					
					//def_val = new String(tmp[0]);
					if (def_val!=undefined && def_val!=null && def_val.trim()!=''){
						Code = def_val;
					} else {
						Code = '';
					}
				}
                break;
         }
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * @param {ibsheet} sheetObj 	==> 시트오브젝트, 
     * @param {int} 	sheetNo 	==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(37, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|STS||Seq.|modi_flg|CNTR No.|Type/\nSize|F/M|I/O|DG|Working\n Date|IPC|Mode|Lane|Lane2|T/S|R/D Term|BKG NO|Verify \n Result|Remarks|"
                    							+ "tml_so_cntr_list_seq|vrfy_rslt_ind_cd|atb_dt|vvd|"
                    							+ "vsl_cd|skd_voy_no|skd_dir_cd|dscr_dtl_ind_cd|bb_cgo_flg|awk_cgo_flg|rc_flg|"
                    							+ "bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|call_yd_ind_seq|clpt_ind_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성     [ROW, COL,  DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus  ,      30,    daCenter,  false,    "ibflag"			     ,	   false,          "",      dfNone,      0,     false ,       true);
                    InitDataProperty(0, cnt++ , dtHidden  		,      30,    daCenter,  false,    "sts"			     ,	   false,          "",      dfNone,      0,     false ,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox		,      30,    daCenter,  false,    "chk"				 ,	   false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtSeq			,      35,    daCenter,  false,    ""					 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      30,    daCenter,  false,    "modi_flg"			 ,     false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtData    		,      80,    daCenter,  false,    "cntr_no"			 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo    		,      40,    daCenter,  false,    "cntr_tpsz_cd"		 ,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo   		,      35,    daCenter,  false,    "cntr_sty_cd"		 ,     false,          "",      dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtCombo   		,      35,    daCenter,  false,    "io_bnd_cd"			 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo   		,      35,    daCenter,  false,    "dcgo_clss_cd"		 ,     false,          "",      dfNone,      0,     true,         true);

                    InitDataProperty(0, cnt++ , dtData    		,      70,    daCenter,  false,    "wrk_dt"		 		 ,     false,          "",   dfDateYmd,      0,     true,         true);
                    InitDataProperty(0, cnt++ , dtCombo   		,      50,    daCenter,  false,    "ioc_cd"		 		 ,     false,          "",      dfNone,      0,     true,         true);
                    InitDataProperty(0, cnt++ , dtCombo   		,      50,    daCenter,  false,    "tml_trns_mod_cd" 	 ,     false,          "",      dfNone,      0,     true,         true);
                    InitDataProperty(0, cnt++ , dtCombo   		,      50,    daCenter,  false,    "lane_cd"		 	 ,     false,          "",      dfNone,      0,     true,         true);
                    InitDataProperty(0, cnt++ , dtHidden   		,      50,    daCenter,  false,    "lane_cd2"		 	 ,     false,          "",      dfNone,      0,     true,         true);

                    InitDataProperty(0, cnt++ , dtCombo   		,      35,    daCenter,  false,    "locl_ts_ind_cd"	 	 ,     false,          "",      dfNone,      0,     true,         true);
                    InitDataProperty(0, cnt++ , dtData    		,      60,    daCenter,  false,    "rcvde_term_ind_cd" 	 ,     false,          "",      dfNone,      0,     false,       false);
            		// Container가 Full 인 경우에 Bkg_no || Bkg_no_split 컬럼을 보여준다. ( 4342. 01. 13 - LGH 과장 요청 )
                    InitDataProperty(0, cnt++ , dtData  		,     100,    daCenter,  false,    "bkg_no_con"		 	 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    		,      50,    daCenter,  false,    "dscr_ind_cd"		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    		,     100,    daCenter,  false,    "cntr_rmk"			 ,     false,          "",      dfNone,      0,     true ,       true );
                    
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "tml_so_cntr_list_seq",     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "vrfy_rslt_ind_cd"    ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "atb_dt"				 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "vsl_cd"				 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "skd_voy_no"			 ,     false,          "",      dfNone,      0,     false,       false);
                    
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "skd_dir_cd"			 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "dscr_dtl_ind_cd"	 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "bb_cgo_flg"		 	 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "awk_cgo_flg"		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "rc_flg"		 		 ,     false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "bkg_no"		 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "bkg_no_split"		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "bl_no"		 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "bl_no_tp"	 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "bl_no_chk"	 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "call_yd_ind_seq"	 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,     100,    daCenter,  false,    "clpt_ind_seq"	 	 ,     false,          "",      dfNone,      0,     false,       false);

                    InitDataCombo(0 , "cntr_sty_cd"		, cntr_sty_cdCode		     , cntr_sty_cdCode);
                    InitDataCombo(0 , "io_bnd_cd"		, io_bnd_cdCode			     , io_bnd_cdCode);
                    InitDataCombo(0 , "dcgo_clss_cd"	, dcgo_clss_cdCode	         , dcgo_clss_cdCode);
                    InitDataCombo(0 , "ioc_cd"			, " |"+ioc_cdText		     , " |"+ioc_cdCode);
                    InitDataCombo(0 , "tml_trns_mod_cd"	, " |"+tml_trns_mod_cdText	 , " |"+tml_trns_mod_cdCode);
                    InitDataCombo(0 , "locl_ts_ind_cd"  , locl_ts_ind_cdCode         , locl_ts_ind_cdCode);
                    InitDataCombo(0 , "cntr_tpsz_cd"    , CNTR_TPSZ_CD               , CNTR_TPSZ_CD);
                    style.height = GetSheetHeight(16);
                    CountFormat = "[SELECTDATAROW / ROWCOUNT]";

               }
                break;
             case 2:      //t2sheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(37, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "|STS||Seq.|Modi Flg|Discrepancy Type|CNTR No.|Type/\nSize|F/M|I/O|DG|Working\n Date|IPC|Mode|Lane|Lane2|T/S|R/D Term|BKG NO|"
                    							+ "vrfy_rslt_ind_cd|Remarks|tml_so_cntr_list_seq|atb_dt|vvd|"
                    							+ "vsl_cd|skd_voy_no|skd_dir_cd|dscr_dtl_ind_cd|bb_cgo_flg|awk_cgo_flg|rc_flg"
                                                + "bkg_no|bkg_no_split|bl_no|bl_no_tp|bl_no_chk|call_yd_ind_seq|clpt_ind_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCdtHiddenStatusDATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus  ,       20,    daCenter,  false,    "ibflag"				,	  false,          "",      dfNone,      0,     false,       true );
                    InitDataProperty(0, cnt++ , dtHidden  		,       30,    daCenter,  false,    "sts"			     	,	  false,          "",      dfNone,      0,     false,       true );
                    InitDataProperty(0, cnt++ , dtCheckBox		,       30,    daCenter,  false,    "chk"					,	  false,          "",      dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtSeq			,       35,    daCenter,  false,    ""						,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,       30,    daCenter,  false,     "modi_flg"				,     false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtCombo  		,      130,    daCenter,  true,     "dscr_ind_cd"			,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    		,       80,    daCenter,  false,    "cntr_no"				,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo    		,       35,    daCenter,  false,    "cntr_tpsz_cd"			,     false,          "",      dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtCombo   		,       35,    daCenter,  false,    "cntr_sty_cd"			,     false,          "",      dfNone,      0,     true ,       true );

                    InitDataProperty(0, cnt++ , dtCombo   		,       35,    daCenter,  false,    "io_bnd_cd"			 	,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo   		,       35,    daCenter,  false,    "dcgo_clss_cd"		 	,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData    		,       70,    daCenter,  false,    "wrk_dt"		 		,     false,          "",   dfDateYmd,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo   		,       50,    daCenter,  false,    "ioc_cd"		 		,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo   		,       50,    daCenter,  false,    "tml_trns_mod_cd" 	    ,     false,          "",      dfNone,      0,     true,         true);

                    InitDataProperty(0, cnt++ , dtCombo   		,       50,    daCenter,  false,    "lane_cd"		 		,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden   		,       50,    daCenter,  false,    "lane_cd2"		 		,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo   		,       35,    daCenter,  false,    "locl_ts_ind_cd"	 	,     false,          "",      dfNone,      0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData    		,       60,    daCenter,  false,    "rcvde_term_ind_cd" 	,     false,          "",      dfNone,      0,     false,       false);
             		// Container가 Full 인 경우에 Bkg_no || Bkg_no_split 컬럼을 보여준다. ( 4342. 01. 13 - LGH 과장 요청 )
                    InitDataProperty(0, cnt++ , dtData  		,      100,    daCenter,  false,    "bkg_no_con"		 	,     false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "vrfy_rslt_ind_cd"      ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData    		,      150,    daCenter,  false,    "cntr_rmk"			    ,     false,          "",      dfNone,      0,     true ,       true );
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "tml_so_cntr_list_seq"  ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "atb_dt"				,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "vsl_cd"				,     false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "skd_voy_no"			,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "skd_dir_cd"			,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "dscr_dtl_ind_cd"		,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bb_cgo_flg"		 	,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "awk_cgo_flg"		 	,     false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "rc_flg"		 		,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bkg_no"		 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bkg_no_split"		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no"		 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no_tp"	 		 ,     false,          "",      dfNone,      0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "bl_no_chk"	 		 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "call_yd_ind_seq" 	 ,     false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden  		,      100,    daCenter,  false,    "clpt_ind_seq" 	     ,     false,          "",      dfNone,      0,     false,       false);

                    InitDataCombo(0 , "cntr_sty_cd"		, cntr_sty_cdCode		     , cntr_sty_cdCode);
                    InitDataCombo(0 , "io_bnd_cd"		, " |"+io_bnd_cdCode		 , "X|"+io_bnd_cdCode);
                    InitDataCombo(0 , "dcgo_clss_cd"	, dcgo_clss_cdCode	         , dcgo_clss_cdCode);
                    InitDataCombo(0 , "ioc_cd"			, " |"+ioc_cdText		  	 , " |"+ioc_cdCode);
                    InitDataCombo(0 , "tml_trns_mod_cd"	, " |"+tml_trns_mod_cdText	 , " |"+tml_trns_mod_cdCode);
                    InitDataCombo(0 , "locl_ts_ind_cd"  , locl_ts_ind_cdCode         , locl_ts_ind_cdCode);
                    InitDataCombo(0 , "cntr_tpsz_cd"    , CNTR_TPSZ_CD               , CNTR_TPSZ_CD);
                    InitDataCombo(0 , "dscr_ind_cd"     , dscr_ind_cdText            , dscr_ind_cdCode);
                    style.height = GetSheetHeight(17) ;
                    CountFormat = "[SELECTDATAROW / ROWCOUNT]";

					}
                break;
            case 3:      //t3sheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    if(ida_ofc_cd == 'Y'){
                    	InitRowInfo( 2, 1, 9, 100);
                    } else {
                    	InitRowInfo( 1, 1, 9, 100);
                    }

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(72, 9, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "SEQ|STS|tml_so_dtl_seq|calc_cost_grp_cd|Calculation Type|vsl_cd|skd_voy_no|skd_dir_cd|"
         				+ "Cost Code|lgs_cost_cd2|HSN/SAC|Goods/\nServices|Type/\n Size|BKG NO\n(B.Bulk)|I/O|DG|Reefer|Applied\n Date|IPC|Mode|Lane|Lane|fm_tr_vol_val|to_tr_vol_val|"
         				+ "Vol.Tier|acct_cd|Calculated\nVol.|Revised\n Vol.|"
         				+ "UOM|Rate|AGMT\nCurr.|Exch.\nRate|Reefer\nMntr Days|Amount|CGST|CGST|SGST|SGST|IGST|IGST|UGST|UGST|GST|GST|Remarks|Carrier|3rd\nParty|semi|atb_dt|cntr_no|wrk_dt|stay_dys|free_dys|ovr_dys|"
         				+ "fp_calc_prd_cd|stk_vol_qty|fp_teu_qty|inv_vol_qty|diff_vol_qty|ovr_vol_qty|calc_amt|"
         				+ "curr_chk|rvis_knt|plug_term|vol_rt_chk_flg|vol_dup_chk_flg|rmk_chk_flg";

                    if(ida_ofc_cd == 'Y'){
                        var HeadTitle1 = "SEQ|STS|tml_so_dtl_seq|calc_cost_grp_cd|Calculation Type|vsl_cd|skd_voy_no|skd_dir_cd|"
             				+ "Cost Code|lgs_cost_cd2|HSN/SAC|Goods/\nServices|Type/\n Size|BKG NO\n(B.Bulk)|I/O|DG|Reefer|Applied\n Date|IPC|Mode|Lane|Lane|fm_tr_vol_val|to_tr_vol_val|"
             				+ "Vol.Tier|acct_cd|Calculated\nVol.|Revised\n Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Reefer\nMntr Days|Amount|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Rate|Amt|Remarks|Carrier|3rd\nParty|"
             				+ "semi|atb_dt|cntr_no|wrk_dt|stay_dys|free_dys|ovr_dys|"
             				+ "fp_calc_prd_cd|stk_vol_qty|fp_teu_qty|inv_vol_qty|diff_vol_qty|ovr_vol_qty|calc_amt|"
             				+ "curr_chk|rvis_knt|plug_term|vol_rt_chk_flg|vol_dup_chk_flg|rmk_chk_flg";
                    }
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    if(ida_ofc_cd == 'Y'){
                    	InitHeadRow(1, HeadTitle1, true);
                    }
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtHidden  ,  70,    daCenter,  false,    "page_rows"              ,       false,          "",       dfNone ,   0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_so_dtl_seq"       ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "calc_cost_grp_cd"     ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,   120,    daCenter,  true,     "calc_tp_cd"           ,       false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "vsl_cd"               ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "skd_voy_no"           ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "skd_dir_cd"           ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,    70,    daCenter,  true,    "lgs_cost_cd"          ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  false,    "lgs_cost_cd2"         ,       false,          "",       dfNone,    0,     false,       false);

                    if(ida_ofc_cd == 'Y'){
                    	InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  true,     "ida_sac_cd"           ,       false,          "",       dfNone,    0,     true,       true);
                    	InitDataProperty(0, cnt++ , dtCombo,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     true,       true);
                    } else {
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_sac_cd"           ,       false,          "",       dfNone,    0,     false,       false);
                    	InitDataProperty(0, cnt++ , dtHidden,    70,    daCenter,  true,    "ida_pay_tp_cd"        ,       false,          "",       dfNone,    0,     false,       false);
                    }
                    
                    InitDataProperty(0, cnt++ , dtCombo ,    40,    daCenter,  true,    "cntr_tpsz_cd"         ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData ,     90,    daCenter,  true,    "bkg_no"         ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,    35,    daCenter,  true,    "io_bnd_cd"            ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,    35,    daCenter,  true,    "dcgo_ind_cd"          ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,    50,    daCenter,  true,    "rc_flg"               ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,    55,    daCenter,  true,    "tml_wrk_dy_cd"       	,       false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtCombo ,    35,    daCenter,  true,    "ioc_cd"               ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,    50,    daCenter,  true,    "tml_trns_mod_cd"      ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo ,    50,    daCenter,  true,    "lane_cd"              ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  true,    "lane_cd2"             ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  true,    "fm_tr_vol_val"        ,       false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  true,    "to_tr_vol_val"        ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData  ,    70,    daCenter,  true,    "tier"        			,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    80,    daCenter,  true,    "acct_cd"              ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData  ,    70,    daRight ,  true,    "calc_vol_qty"         ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopup ,    70,    daRight ,  true,    "rvis_vol_qty"         ,       false,          "",       dfNone,    0,     true ,       true);

                    InitDataProperty(0, cnt++ , dtCombo ,    40,    daCenter,  true,    "vol_tr_ut_cd"         ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData  ,    70,    daRight ,  true,    "ctrt_rt"              ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData  ,    70,    daCenter,  true,    "curr_cd"              ,       false,          "",       dfNone ,   0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData  ,    70,    daRight ,  true,    "inv_xch_rt"           ,       false,          "",       dfFloat,   5,     false,       false, 15);
                    InitDataProperty(0, cnt++ , dtData  ,    70,    daRight ,  true,    "rf_mntr_dys"          ,       false,          "",       dfNone,    2,     false,       false);

                    InitDataProperty(0, cnt++ , dtData  ,    70,    daRight ,  true,    "inv_amt"              ,       false,          "",       dfFloat,   2,     false,       false);
                    
                    if(ida_ofc_cd == 'Y'){
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
	                    InitDataProperty(0, cnt++ , dtData,    50,    daRight ,  false,    "ida_gst_rto"          ,       false,          "",       dfFloat,   2,     false,      false);
	                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "ida_gst_amt"          ,       false,          "",       dfFloat,   2,     false,      false);
	                } else {
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_cgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_sgst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_igst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_ugst_rto"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    50,    daRight ,  true,    "ida_gst_rto"         ,       false,          "",       dfFloat,   2,     false,       true);
                        InitDataProperty(0, cnt++ , dtHidden,    70,    daRight ,  true,    "ida_gst_amt"         ,       false,          "",       dfFloat,   2,     false,       true);  
                    }
                    
                    InitDataProperty(0, cnt++ , dtData  ,   100,    daCenter,  true,    "calc_rmk"             ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++ , dtCombo ,    50,    daCenter,  true,    "tml_crr_cd"           ,       false,          "",       dfNone,    0,     true ,      true);
                    InitDataProperty(0, cnt++ , dtPopup ,    50,    daCenter,  true,    "n3pty_flg"            ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,    daCenter,  false,    "semi_auto_calc_flg"   ,       false,          "",       dfNone ,   0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "atb_dt"               ,       false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "cntr_no"              ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "wrk_dt"               ,       false,          "",    dfDateYmd,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "stay_dys"             ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "free_dys"             ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "ovr_dys"              ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "fp_calc_prd_cd"       ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "stk_vol_qty"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "fp_teu_qty"           ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "inv_vol_qty"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "diff_vol_qty"         ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "ovr_vol_qty"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "calc_amt"             ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_agmt_ofc_cty_cd"  ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_agmt_seq"         ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "tml_agmt_ver_no"      ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "curr_chk"             ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "accm_chk"             ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "edi_so_dtl_id"        ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "rvis_knt"				,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "plug_term"			,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "vol_rt_chk_flg"		,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "vol_dup_chk_flg"		,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  false,    "rmk_chk_flg"			,       false,          "",       dfNone,    0,     false,       true);
                    
                    InitDataCombo(0 , "calc_tp_cd"	     , "Auto Calculated Cost|Manual Input Cost|Semi-Updated", "A|M|S");
                    InitDataCombo(0 , "io_bnd_cd"	     , io_bnd_cdCode,      io_bnd_cdCode);
                    InitDataCombo(0 , "dcgo_ind_cd"	     , dcgo_clss_cdCode,   dcgo_clss_cdCode);
                    InitDataCombo(0 , "tml_wrk_dy_cd"    , tml_wrk_dy_cdCode,  tml_wrk_dy_cdCode);
                    InitDataCombo(0 , "ioc_cd" 		     , ioc_cdText,         ioc_cdCode);
                    InitDataCombo(0 , "rc_flg" 		     , "Y|N",              "Y|N");
                    InitDataCombo(0 , "vol_tr_ut_cd"     , vol_tr_ut_cdCode,   vol_tr_ut_cdCode);
                    InitDataCombo(0 , "lgs_cost_cd"      , MT_A_LGS_COST_CD,   MT_A_LGS_COST_CD);
                    InitDataCombo(0 , "cntr_tpsz_cd"     , CNTR_TPSZ_CD,       CNTR_TPSZ_CD);
                    InitDataCombo(0 , "tml_crr_cd"       , CARR_CD,            CARR_CD);
                    InitDataCombo(0 , "tml_trns_mod_cd"	 , " |"+tml_trns_mod_cdText	 , " |"+tml_trns_mod_cdCode);
                    if(ida_ofc_cd == 'Y'){
                    	InitDataCombo(0 , "ida_pay_tp_cd"	     , "Goods|Services", "G|S");
                    }
                    style.height = GetSheetHeight(17) ;
                    CountFormat = "[SELECTDATAROW / ROWCOUNT]";

            		//sheetObj.cellVa	
					}
                break;

         case 4:      //main_hidden init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(47, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
                    								+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
                    								+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|vndr_nm|err_inv_no|whld_tax_amt|edi_flg|rtro_tml_inv_flg|ap_rvs_cng_flg|"
                    								+"dbt_note_no|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCdtHiddenStatusDATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,     30  ,  daCenter,  false,    "ibflag"			   ,	 false,          "",       dfNone,         0,    false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,  daCenter,  false,    "sts"			       ,	 false,          "",       dfNone,         0,    false,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_so_ofc_cty_cd"  ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_so_seq"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_ofc_cd"         ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "cost_ofc_cd"        ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_no"             ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "vndr_seq"           ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "yd_cd"              ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "yd_nm"              ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "curr_cd"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ttl_inv_amt"        ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "vat_amt"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ttl_calc_amt"       ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "fm_prd_dt"  	       ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "hld_flg"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "hld_rmk"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "to_prd_dt"          ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_tp_cd"      ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_cost_grp_cd"    ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_calc_ind_cd"    ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "sto_dys_ind_cd"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "iss_dt"             ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "rcv_dt"             ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "eff_dt"             ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "pay_due_dt"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "pay_flg"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_sts_cd"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_sts_nm"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_inv_rjct_sts_cd",     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_cfm_dt"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_agmt_ofc_cty_cd",     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_agmt_seq"       ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "tml_agmt_ver_no"    ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "inv_rjct_rmk"       ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "vndr_nm"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "err_inv_no"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "whld_tax_amt"       ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "edi_flg"            ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "rtro_tml_inv_flg"   ,     false,          "",       dfNone,         0,     true,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ap_rvs_cng_flg"     ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "file_chk"            ,     false,          "",       dfNone,         0,     true,      true);

                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "dbt_note_no"         ,     false,          "",       dfNone,         0,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_cgst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_sgst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_igst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    InitDataProperty(0, cnt++ , dtData,       50  ,    daLeft,  false,    "ida_ugst_amt"        ,     false,          "",       dfFloat,         2,     true,      true);
                    
                    style.height = GetSheetHeight(3) ;
						}
                break;
        	case 5:      //vvd_hidden init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

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
                    InitColumnInfo(16, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

//                    var HeadTitle = "STATUS|OFC_CTY|SO_SEQ|VVD_SEQ|VSL_CD|VOY_NO|DIR_CD|IO_BND|ATB_DT|VVD_TYPE|CRE_DT|VVD_AMOUNT|VVD|REV_YRMON";
                    var HeadTitle = "STATUS|OFC_CTY|SO_SEQ|VVD_SEQ|VSL_CD|VOY_NO|DIR_CD|IO_BND|ATB_DT|VVD_TYPE|CRE_DT|VVD_AMOUNT|VVD|REV_YRMON|call_yd_ind_seq|clpt_ind_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus, 100,    daCenter,  false,   "vvd_ibflag",                false,          "",       dfNone,    0,     false,      true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_ofc_cty_cd",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_seq",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_vvd_list_seq",   false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_vsl_cd",                false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_skd_voy_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_skd_dir_cd",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_io_bnd_cd",             false,          "",       dfNone,    0,     true,       true);                   
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_atb_dt",                false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_type",                  false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "cre_dt",                    false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_amt",                   false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd",                       false,          "",       dfNone,    0,     true,       true);
                    //REV_YRMON 2007.05.08
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "rev_yrmon",                 false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_call_yd_ind_seq",       false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_clpt_ind_seq",          false,          "",       dfNone,    0,     true,       true);

                    style.height = GetSheetHeight(4) ;

               }
                break;
           case 6:      //sheet_accumulate Vol. init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

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
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "ibflg|pay_vol_qty|accm_seq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtStatus,      100,    daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,  true,     "pay_vol_qty",	 false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,         100,    daCenter,  true,     "accm_seq"   ,	 false,          "",       dfNone,    0,     true,       true);

                    style.height = GetSheetHeight(3) ;

               }
               break;

           case 7:      //costRvisCntr_hidden init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(32, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "STS|OFC CD|SO SEQ|DTL SEQ|RVIS SEQ|INV TP|CALC GROUP|RVIS TYPE|COST CD"
									+ "|CNTR NO|BKG NO|BKG NO SPLIT|VSL|VOYAGE|DIR|CUZ CNTR|RHND RSN|RVIS RMK"
									+"|CALC TYPE|IOC_CD|LANE_CD|IO_BND|CNTR TPSZ|FM_TR|TO_TR|DCGO|tml_wrk_dy_cd|trns_mod|Reefer|rvis_ind_flg|page_rows|Carrier";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    InitDataProperty(0, cnt++,  dtStatus,    60,    daCenter,  false,    "rvis_ibflag");

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_so_ofc_cty_cd"	,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_so_seq"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_so_dtl_seq"      ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_so_rvis_list_seq",       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_inv_tp_cd"       ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_calc_cost_grp_cd"    ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_rvis_tp_cd"      ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_lgs_cost_cd"         ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_cntr_no"             ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_bkg_no"              ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_bkg_no_split"        ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_vsl_cd"              ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_skd_voy_no"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_skd_dir_cd"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_cuz_cntr_no"         ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_rhnd_rsn_cd"         ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_rvis_rmk"            ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_calc_tp_cd"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_ioc_cd"              ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_lane_cd"             ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_io_bnd_cd"           ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_cntr_tpsz_cd"        ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_fm_tr_vol_val"       ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_to_tr_vol_val"       ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_dcgo_ind_cd"         ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_wrk_dy_cd"		,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_trns_mod_cd"		,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_rc_flg"				,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_ind_flg"				,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_page_rows"			,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "rvis_tml_crr_cd"			,       false,          "",       dfNone,    0,     false,       true);
                    style.height = GetSheetHeight(6) ;
					}
                break;
            case 8:      //costN3ptyCntr_hidden init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(48, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "SEQ|STS|n3rd_tml_if_ofc_cd|n3rd_tml_if_seq|n3rd_tml_n3pty_if_sts_cd|n3rd_inv_no|n3rd_vndr_seq|n3rd_yd_cd|" +
                    				"n3rd_lgs_cost_cd|n3rd_acct_cd|n3rd_tml_so_ofc_cty_cd|n3rd_tml_so_seq|n3rd_tml_so_dtl_seq|"         +
                    				"n3rd_n3pty_bil_tp_cd|n3rd_cntr_no|n3rd_cntr_tpsz_cd|n3rd_bkg_no|n3rd_bkg_no_split|"                +
                    				"n3rd_vndr_cust_div_cd|"        +
                    				"n3rd_vndr_cnt_cd|n3rd_n3pty_vndr_seq|n3rd_cust_cnt_cd|n3rd_cust_seq|n3rd_n3pty_ofc_cd|"            +
                    				"n3rd_curr_cd|n3rd_if_amt|n3rd_if_rmk|n3rd_cxl_flg|n3rd_calc_tp_cd|n3rd_ioc_cd|n3rd_lane_cd|n3rd_io_bnd_cd|"        +
                    				"n3rd_fm_tr_vol_val|n3rd_to_tr_vol_val|n3rd_vvd|n3rd_dcgo_clss_cd|n3rd_tml_wrk_dy_cd|bl_no|bl_no_tp|bl_no_chk|" +
                    				"n3rd_acct_cd|vsl_cd|voy_no|dir_cd|trns_mod|ERR INVOICE|Reefer|CARRIER";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    InitDataProperty(0, cnt++ , dtData  ,    70,    daCenter,  false,    "n3rd_page_rows"             ,       false,          "",       dfNone,    0,     false,      false);
                    InitDataProperty(0, cnt++ , dtStatus,    60,    daCenter,  false,    "n3rd_ibflag");
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_if_ofc_cd"         ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_if_seq"            ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_n3pty_if_sts_cd"   ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_inv_no"                ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_vndr_seq"              ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_yd_cd"                 ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_lgs_cost_cd"           ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_acct_cd"               ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_so_ofc_cty_cd"     ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_so_seq"            ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_so_dtl_seq"        ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_n3pty_bil_tp_cd"       ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_cntr_no"               ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_cntr_tpsz_cd"          ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_bkg_no"                ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_bkg_no_split"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_vndr_cust_div_cd"      ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_vndr_cnt_cd"           ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_n3pty_vndr_seq"        ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_cust_cnt_cd"           ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_cust_seq"              ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_n3pty_ofc_cd"          ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_curr_cd"               ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_if_amt"                ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_if_rmk"                ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_cxl_flg"               ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_calc_tp_cd"            ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_ioc_cd"                ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_lane_cd"               ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_io_bnd_cd"             ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_fm_tr_vol_val"         ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_to_tr_vol_val"         ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_vvd"		              ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_dcgo_ind_cd"          ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_wrk_dy_cd"         ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData	,    50,    daCenter,  false,    "n3rd_bl_no"		 		  ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,    50,    daCenter,  false,    "n3rd_bl_no_tp"	 		  ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData	,    50,    daCenter,  false,    "n3rd_bl_no_chk"	 		  ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData  ,    80,    daCenter,  false,    "n3rd_acct_cd"               ,       false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_vsl_cd"  		      ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_skd_voy_no"            ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_skd_dir_cd"            ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_trns_mod_cd"       ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_err_inv_no"            ,       false,          "",       dfNone,    0,     false,       true);

                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_rc_flg"                ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData  ,    60,    daCenter,  false,    "n3rd_tml_crr_cd"                ,       false,          "",       dfNone,    0,     false,       true);

                    style.height = GetSheetHeight(9) ;
						}
                break;
           case 9:      //costCalc_hidden init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "SEQ|VSL_CD|VOY_NO|DIR_CD|IO_BND_CD|INV_AMT|RVIS_CNTR_LIST_CD";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "tml_so_vvd_list_seq"  ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "vsl_cd"               ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "skd_voy_no"           ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "skd_dir_cd"           ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "io_bnd_cd"            ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "inv_amt"              ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "rvis_cntr_list_cd"    ,       false,          "",       dfNone,    0,     false,       false);
                    style.height = GetSheetHeight(4) ;
						}
                break;
            case 10:      //ETC Data Search시 공통으로 사용하는 sheet
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(1, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "DATA";
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "etc"  ,       false,          "",       dfNone,    0,     false,       true);
						}
                break;

            case 11:      //t3sheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "vvd|io_bnd_cd|cost_cd|inv_amt|ida_cgst_amt|ida_sgst_amt|ida_igst_amt|ida_ugst_amt";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  false,    "vvd"            ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  false,    "io_bnd_cd"      ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,    30,    daCenter,  false,    "sum_basis"	    ,       false,          "",       dfNone,    0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "lgs_cost_cd"    ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,    70,    daRight ,  false,    "inv_amt"        ,       false,          "",       dfFloat,   2,     false,       false);
                
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "ida_cgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "ida_sgst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "ida_igst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "ida_ugst_amt"         ,       false,          "",       dfFloat,   2,     false,       false);
            	}
                break;

             case 12:      //vvd_check_hidden init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
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
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle = "STATUS|OFC_CTY|SO_SEQ|VVD_SEQ|VSL_CD|VOY_NO|DIR_CD";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus, 100,    daCenter,  false,   "vvd_ibflag",                false,          "",       dfNone,    0,     false,      true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_ofc_cty_cd",     false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_seq",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_tml_so_vvd_list_seq",   false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_vsl_cd",                false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_skd_voy_no",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_skd_dir_cd",            false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData,    100,    daCenter,  true,    "vvd_atb_dt",            false,          "",       dfNone,    0,     true,       true);
                    
                    style.height = GetSheetHeight(4) ;

               }
                break;
         }

    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param {tab object}	tab_obj	tab object
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     * @param(tabObj)  tab object 
     * @param(tabNo)   tab no
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Coincidence" , -1 );
                    InsertTab( cnt++ , "Discrepancy" , -1 );
                    InsertTab( cnt++ , "Cost Calculation" , -1 );
                }
             break;

         }

         //vndr_seq와 inv_no가 저장된것이 확인되면 (COIN과 DISCP)sheet를 활성화한다.
		 if (document.form.tml_so_ofc_cty_cd.value == '' && document.form.tml_so_seq.value ==''){
			 tabObj.Enable = false;
		 } else {
			 tabObj.Enable = true;
		 }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * @param(tabObj)  tab object 
     * @param(nItem)   item     
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

    /**
	 * 입력날짜타입을 Validation하는 함수
	 * @param {ojbect}	obj	object
	 */
    function validDate(obj){
        var formObj = document.form;
        if(obj.value != "" && !ComIsDate (obj)){
            ComShowMessage(ComGetMsg('TES21048')); //ComShowMessage( "날짜가 잘못입력되었습니다.");
            obj.value = "";
            return false;
        }
        if(formObj.iss_dt != null && formObj.rcv_dt != null && formObj.iss_dt.value != '' && formObj.rcv_dt.value != ''){
            if(ComGetDaysBetween(formObj.iss_dt, formObj.rcv_dt) < 0){
                ComShowMessage('Issue date must be earlier than RCV date.'); //ComShowMessage('Issue date이 RCV date보다 작아야 합니다.');
                return false;
            }
        }
    }



  /*
   * Component 초기 Setting하는 함수
   * @param {String}	sFlag 플래그 값
   */
   function setInitComponent(sFlag){//alert("start setInitComponent");
       var formObj = document.form;
       var flag_value = false;
       if(sFlag == "Y"){
           flag_value = true;
       } else{
           flag_value = false;
       }

       for (var e = 0; e < formObj.elements.length; e++) {
           var el = formObj.elements[e];
           ComEnableObject(el, false);
       }
       if(sFlag == "Y"){
           // 소급 적용 처리용 rtro_tml_inv_flg 추가 ( 2009-06-17 )
           ComEnableManyObjects(true, 
        		   			 formObj.yd_cd,
                             formObj.cost_ofc_cd,
                             formObj.pay_vol_qty,
                             formObj.ttl_inv_amt,
                             formObj.iss_dt,
                             formObj.vat_amt,
                             formObj.rcv_dt,
                             formObj.hld_flg,
                             formObj.rtro_tml_inv_flg,
                             formObj.err_inv_no,
                             formObj.rowsadd,
                             formObj.io_bnd_cd
                             );
// 소급 적용 처리 기능 해제 ( 2009-07-08 ) 
// 소급 적용 처리 기능 추가 
// 실제 적용 전까지 주석처리 적용시 제거후 위 Parameter로 이동. ( 2009-06-23 )
//                             formObj.rtro_tml_inv_flg,

           if(conti_cd=="E" || ida_ofc_cd == 'Y') ComEnableObject(formObj.ap_rvs_cng_flg, true);
           
           if(whld_tax_readonly_mode == false){
        	   ComEnableObject(formObj.whld_tax_amt, true);
		   }
           
           if(ida_ofc_cd == 'Y'){
        	   ComEnableManyObjects(true, formObj.dbt_note_no, formObj.ida_cgst_amt, formObj.ida_sgst_amt, formObj.ida_igst_amt, formObj.ida_ugst_amt);
           }
       }
       	ComEnableManyObjects(true, formObj.vndr_seq, formObj.inv_no);
      	formObj.cost_ofc_cd	.readOnly = true;
      	formObj.atb_dt.readOnly = true;

        tabObjects[0].Enable   = flag_value;
      	sheetObjects[0].Editable = flag_value;
        sheetObjects[1].Editable = flag_value;
        sheetObjects[2].Editable = flag_value;
        
        //2009.12.10 disabled 때문에 
        comboObjects[0].Enable = flag_value;
        comboObjects[1].Enable = flag_value;
        
	}



	/**
	 * Sheet들에 있는 data를 reset
	 */
	function resetSheets(){
	    sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[3].RemoveAll();
        sheetObjects[4].RemoveAll();
        sheetObjects[5].RemoveAll();
        sheetObjects[6].RemoveAll();
        sheetObjects[7].RemoveAll();
        sheetObjects[8].RemoveAll();
        sheetObjects[9].RemoveAll();
        sheetObjects[10].RemoveAll();
	}

// agreement의 currency code와 so header의 currency code를 비교 확인하기 - 시작 ++++++++++++++++++++++++++++++++++++++++++
	function validateAgmtCurrCD(){
		var formObj = document.form;
		if(ComIsNull(formObj.atb_dt.value)){
		    return false;
		}
		tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|atb_dt', '');
	}
	
	/** calc tab 계산전에 so hdr의 currency와 agreement의 currency code가 일치하는지 여부를 파악..
	 */
	function isValidAgmtCurrCD(){
		// calc tab 계산전에 so hdr의 currency와 agreement의 currency code가 일치하는지 여부를 파악...
		var formObj = document.form;
		if (formObj.curr_cd.Code==null || formObj.curr_cd.Code.trim()==''){
			ComShowMessage(ComGetMsg('TES40039')); //ComShowMessage('so header의 currency code가 선택되지 않았습니다.');
			return false;
		}
		if (formObj.curr_cd.Code!=main_hidden.CellValue(1,'curr_cd')){
			ComShowMessage(ComGetMsg('TES40040')); //ComShowMessage('so header의 currency code가 저장되지 않았습니다.');
			return false;
		}
		if (formObj.atb_dt.value==null || formObj.atb_dt.value.trim()==''){
			ComShowMessage(ComGetMsg('TES40036')); //ComShowMessage('so header의 ATB Date가 입력되지 않았습니다.');
			return false;
		}
		if (formObj.atb_dt.value == null || formObj.atb_dt.value.trim()==''){
			ComShowMessage(ComGetMsg('TES40002','ATB Date')); //ComShowMessage('ATB Date가 저장되지 않았습니다.');
			return false;
		}
		if (formObj.agmtCurrCd.value.trim() == formObj.curr_cd.Code.trim()){
			return true;
		} else {
			ComShowMessage(ComGetMsg('TES40028',formObj.agmtCurrCd.value,formObj.curr_cd.Code));
			//ComShowMessage('agreement에 등록된 currency code인 "'+formObj.agmtCurrCd.value+'"는 현재의 so header의 currency code인 "'+formObj.curr_cd.Code+'"와 일치하지 않습니다.');
			return false;
		}
		if (formObj.agmtCurrCd.value==null || formObj.agmtCurrCd.value.trim()==''){
			tes_getInputValueInvoice('agmtCurrCd', SEARCH01, 'tml_inv_tp_cd|yd_cd|vndr_seq|atb_dt', '');
			ComShowMessage(ComGetMsg('TES40029')); //ComShowMessage('agreement의 currency code 조회중입니다. 다시 계산해 주십시오.');
			return false;
		}
		return false;
	}
	// agreement의 currency code와 so header의 currency code를 비교 확인하기 - 끝 ++++++++++++++++++++++++++++++++++++++++++


	// agreement의 status를 확인하기 - 시작 ++++++++++++++++++++++++++++++++++++++++++
	function validateAgmtSts(){
	    if(document.form.tml_inv_tp_cd.value == '' ||document.form.yd_cd.value == ''
	       ||document.form.vndr_seq.value == '' ||document.form.atb_dt.value == '' ){
	        return false;
	    }
		tes_getInputValueInvoice('agmtSts', SEARCH04, 'tml_inv_tp_cd|yd_cd|vndr_seq|atb_dt', '');
	}
	
	
	/** Cost Cal 시 Effective Date가 Inv Date(ATB or Issue Date) or To Period 에 해당하는
	 *  Agreement를 List Up한 후 그중 최종 버전(ST)이 'C'이면 계산을 진행하고 'P' 상태이면
	 *  "Agreement가 수정중입니다. Agreement 담당자에게 문의하십시오."라는 메시지를 띄우고 Rate 계산을 하지 않도록 함
	 *  Agreement가 존재하지 않으면, 즉, EX가 0이면 "Agreement가 존재하지 않습니다.Agreement 담당자에게 문의하십시오."
	 *  라는 메시지를 띄우고 Rate 계산을 하지 않도록 함
	 * @return
	 */
	function isValidAgmtSts(){

		var formObj = document.form;
		var tmp = '';
		tmp = formObj.agmtSts.value;
		if (tmp!=undefined && tmp!=null && tmp.trim()!=''){
			tmp = tmp.split('|');
			if (tmp.length > 0){
				if (tmp[0]!=null && !isNaN(tmp[0])){
					if (parseInt(tmp[0])>0){

						if (tmp[1]!=undefined && tmp[1]!=null){
							if (tmp[1].trim()=='C'){
								// 오케바리 : 계산을 진행
								return true;
							} else if (tmp[1].trim()=='P'){
								ComShowMessage(ComGetMsg('TES40005')); //ComShowMessage('Agreement가 수정중입니다. Agreement 담당자에게 문의하십시오.');
								return false;
							} else {
								ComShowMessage(ComGetMsg('TES40003')); //ComShowMessage('Agreement status가 조회되지 않습니다.Agreement 담당자에게 문의하십시오.');
								return false;
							}
						}
					} else if (parseInt(tmp[0])==0){
						ComShowMessage(ComGetMsg('TES40005')); //ComShowMessage('Agreement가 존재하지 않습니다.Agreement 담당자에게 문의하십시오.');
						return false;
					} else {
						ComShowMessage('[ERR-Agreement_01]');
						return false;
					}
				} else {
					ComShowMessage('[ERR-Agreement_02]');
					return false;
				}
			} else {
				ComShowMessage('[ERR-Agreement_03]');
				return false;
			}
		} else {
			ComShowMessage('Failed to read Agreement. \nPlease Retrieve again.');
			return false;
		}
		return true;
	}
	// agreement의 status를 확인하기 - 끝 ++++++++++++++++++++++++++++++++++++++++++

//================================= Yard Code 관련 함수 시작 =================================================
	/**
	 *  설명 : Yard값을 Popup에서 가져오는 함수
	 *  @param(rowArray) 로우 배열
	 */
	function getYard(rowArray) {
		var colArray = rowArray[0];
		document.all.yd_cd.value = colArray[3];
		document.all.yd_nm.value = colArray[4];
		document.all.yd_cd_hidden.value = colArray[3];

		if (colArray[3]!=undefined && colArray[3]!=null && colArray[3].trim()!='')
		{
			//checkValidYardCode()에서 yd_cd가 있다면 MDM_YARD의 OFC_CD를 가져와서 넣어준다.
			tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
//			tes_getInputValue('laneCode', SEARCH19, 'yd_cd', 'initLaneCode');
		}
		document.all.cost_ofc_cd.readOnly = false;
	}

	/**
	 * 입력된 YardCode값을 Validation하는 함수
	 */
	function validateYardCode() {
		var formObj = document.form;
		if (formObj.yd_cd.value==null || formObj.yd_cd.value.trim()==''){
			formObj.yd_cd_hidden.value = '';
			formObj.is_valid_yd_cd.value = '';
			return false;
		}
		if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value.trim() == '')
		     || formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()){
			formObj.is_valid_yd_cd.value = '';

//			tes_getInputValue('laneCode', SEARCH19, 'yd_cd', 'initLaneCode');
			tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');

		}
	}

	/**
	 * Coincidence, Discrepancy sheet의 LaneCode Combo를 초기화한다.
	 * -2007.07.20 KKY 부장님 요청으로 'OTH'추가 (VSK_VSL_SKD에 Yard + CNTC항차로 조회시 Lane Code가 존재 하지 않기 때문에 수정하게 됨)
	 *
	 */
	function initLaneCode(){//alert("start initLaneCode");
		var laneCode;

		if(document.form.laneCode != null && document.form.laneCode.value != "undefined"){
			laneCode = document.form.laneCode.value;
		    sheetObjects[0].InitDataCombo(0 , "lane_cd"  , laneCode+'|OTH'   , laneCode+'|OTH');
		    sheetObjects[1].InitDataCombo(0 , "lane_cd"  , laneCode+'|OTH'   , laneCode+'|OTH');
		    sheetObjects[2].InitDataCombo(0 , "lane_cd"  , laneCode+'|OTH'   , laneCode+'|OTH');
		    
		}else{
		    sheetObjects[0].InitDataCombo(0 , "lane_cd"  , 'OTH'   , 'OTH');
		    sheetObjects[1].InitDataCombo(0 , "lane_cd"  , 'OTH'   , 'OTH');
		    sheetObjects[2].InitDataCombo(0 , "lane_cd"  , 'OTH'   , 'OTH');
		}

	}

    function initLaneCode2(){//alert("start initLaneCode2");    
		var laneCode;
		
		if(document.form.laneCode != null && document.form.laneCode.value != "undefined"){
			laneCode = document.form.laneCode.value;
		    sheetObjects[0].InitDataCombo(0 , "lane_cd"  , laneCode+'|OTH'   , laneCode+'|OTH');
		    sheetObjects[1].InitDataCombo(0 , "lane_cd"  , laneCode+'|OTH'   , laneCode+'|OTH');
		    sheetObjects[2].InitDataCombo(0 , "lane_cd"  , laneCode+'|OTH'   , laneCode+'|OTH');
		    
		}else{
		    sheetObjects[0].InitDataCombo(0 , "lane_cd"  , 'OTH'   , 'OTH');
		    sheetObjects[1].InitDataCombo(0 , "lane_cd"  , 'OTH'   , 'OTH');
		    sheetObjects[2].InitDataCombo(0 , "lane_cd"  , 'OTH'   , 'OTH');
		}
	    
	    doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH);
	}	 
	 
	/**
	 * 설명 : YardCode Validation 함수
	 */
	function checkValidYardCode(){
		var formObj = document.form;
		var tmp_yd_cd_hidden;
		var tmp = '';
		if (formObj.is_valid_yd_cd.value!=undefined && formObj.is_valid_yd_cd.value!=null && formObj.is_valid_yd_cd.value.trim()!=''){
			tmp = formObj.is_valid_yd_cd.value.split('--');
			if (tmp.length > 0){
				formObj.is_valid_yd_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_yd_cd.value !=null && formObj.is_valid_yd_cd.value == 'Y'){
//					if (formObj.yd_cd.value!=null && formObj.yd_cd.value.trim()!='' && formObj.yd_cd_hidden.value!=formObj.yd_cd.value)
//					{
//						if (sheetObjects[3].RowCount > 0 && formObj.yd_cd.value.trim()!=sheetObjects[3].CellValue(1,'yd_cd').trim()
//						      &&(sheetObjects[4].RowCount > 0 || sheetObjects[7].RowCount > 0))
//						{
//							if (!confirm(ComGetMsg('TES40027')))//'Yard Code가 변경되었습니다. \n\n Coincidence, Discrepancy, Cost Calc. Tab의 모든 Data를 삭제할까요?'
//							{
//								formObj.yd_cd.value = formObj.yd_cd_hidden.value;
//								return false;
//							} else {
//								//ComShowMessage('sheet들 다 지우고, yd, cost_ofc, calcStorageComboItems 수정하기');
//								if(deleteContanerList("ALL")) gridSave();
//							}
//						}
//					}

                    tmp_yd_cd_hidden = formObj.yd_cd_hidden.value;
                    formObj.yd_cd_hidden.value             = formObj.yd_cd.value;
                    formObj.yd_nm.value                    = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
                    formObj.yd_chr_cd.value                = (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
                    formObj.yd_fcty_tp_mrn_tml_flg.value   = (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
                    formObj.yd_fcty_tp_cy_flg.value        = (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
                    formObj.yd_fcty_tp_cfs_flg.value       = (tmp[6]!=undefined&&tmp[6]!=null?tmp[6]:'');
                    formObj.yd_fcty_tp_rail_rmp_flg.value  = (tmp[7]!=undefined&&tmp[7]!=null?tmp[7]:'');
                    formObj.yd_oshp_cd.value               = (tmp[8]!=undefined&&tmp[8]!=null?tmp[8]:'');
                    formObj.calcTerminalComboItems.value   = (tmp[9]!=undefined&&tmp[9]!=null?tmp[9]:'');
                    formObj.calcTerminalComboItemsDesc.value   = (tmp[14]!=undefined&&tmp[14]!=null?tmp[14]:'');

                    var tmp_yd_cd = formObj.yd_cd.value;
                    var tmp2;
                    var retval = '';
                    var retvalDesc = '';
                    tmp2 = tmp[9].split('|');
                    tmp3 = tmp[14].split('|');
                    for (var i=0; tmp2!=null && i<tmp2.length; i++){
                        if (!(( tmp_yd_cd=='KRPUSYK' || tmp_yd_cd=='KRPUSYG' || 
                        		tmp_yd_cd=='KRKANY4' || tmp_yd_cd=='KRPUSKC'
                        		|| tmp_yd_cd=='JPTYOY1' || tmp_yd_cd=='JPOSAY1'
                        	) && tmp2[i]=='SVXXJO')) {
                            retval += tmp2[i] + (i<tmp2.length-1?'|':'');
                            retvalDesc += tmp3[i] + (i<tmp3.length-1?'|':'');
                        }
                    }

                    formObj.calcTerminalComboItems.value   =  retval;
                    formObj.calcTerminalComboItemsDesc.value = retvalDesc;

                    if((formObj.tml_so_ofc_cty_cd.value == '' && formObj.tml_so_seq.value == '')
                     ||formObj.yd_cd.value != tmp_yd_cd_hidden
                     ||formObj.cost_ofc_hidden.value != formObj.cost_ofc_cd.value)
                    {
                        tes_getInputValue('cost_ofc_cd', SEARCH02, 'yd_cd', 'setCostOfcReadOnlyFalse');
                    }else{
                        setCostOfcReadOnlyFalse();
                    }

                    if (sheetObjects[2].RowCount > 0)	{
                    	setCalcTerminalManualCostCode(sheetObjects[2]);
                    }
                    // vndr_seq,yd_cd별 accm_seq,pay_vol_qty를 가져오기.
                    sheetObjects[5].RemoveAll();
                    doActionAccmHidden(sheetObjects[5], formObj, IBSEARCH);


				} else {
					ComShowMessage(ComGetMsg('TES21039')); //ComShowMessage('유효하지 않은 YardCode입니다.');
					formObj.is_valid_yd_cd.value = '';
					formObj.yd_cd_hidden.value = '';
					formObj.yd_nm.value = '';
				}
			} else {
				ComShowMessage(ComGetMsg('TES21039')); //ComShowMessage('유효하지 않은 YardCode입니다.');
				formObj.is_valid_yd_cd.value = '';
				formObj.yd_cd_hidden.value = '';
				formObj.yd_nm.value = '';
			}
		} else {
			ComShowMessage(ComGetMsg('TES21039')); //ComShowMessage('유효하지 않은 YardCode입니다.');
			formObj.is_valid_yd_cd.value = '';
			formObj.yd_cd_hidden.value = '';
			formObj.yd_nm.value = '';
		}
	}


//================================= Yard Code 관련 함수 끝 =================================================

//================================= Invoice No 관련 함수 시작 =============================================
    /**
	 * 입력된 Invoice No가 기 존재하는 중복된 것이 아닌지 확인하는 함수
	 */
	function validateInvDupChk() {
		var formObj = document.form;
		if (formObj.inv_no.value==null || formObj.inv_no.value.trim()==''){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			return false;
		}
		
		if ((formObj.inv_no_hidden.value==null || formObj.inv_no_hidden.value.trim()=='') || formObj.inv_no.value.trim()!=formObj.inv_no_hidden.value.trim()){
			formObj.is_dup_inv_no.value = '';
			formObj.inv_no_hidden.value = '';
			tes_getInputValue('is_dup_inv_no', SEARCH21, 'inv_no|vndr_seq', 'checkInvDup');
		}
	}	
	
	/**
	 *  Inv_no Dup Validation 함수
	 */
	function checkInvDup(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_dup_inv_no.value!=undefined && formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value.trim()!=''){
			tmp = formObj.is_dup_inv_no.value;
			if (tmp.length > 0){
				formObj.is_dup_inv_no.value = (tmp!=undefined&&tmp!=null?tmp:'');
				if (formObj.is_dup_inv_no.value!=null && formObj.is_dup_inv_no.value == 'Y'){
					//formObj.is_dup_inv_no.value = '';
					//formObj.inv_no_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No. is duplicated. Plz, change to another Invoice No.');
				}
			}
		}
	}
//================================= Invoice No 관련 함수 끝 =================================================
	
	
//================================= Vendor Code 관련 함수 시작 =============================================
    /**
	 * 입력된 vndr_seq값을 Validation하는 함수
	 */
	function validateVndrSeq() {
		var formObj = document.form;
		if (formObj.vndr_seq.value==null || formObj.vndr_seq.value.trim()==''){
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			return false;
		}
		if (formObj.vndr_seq.value.length < 6){
		    formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
		}
		if ((formObj.vndr_seq_hidden.value==null || formObj.vndr_seq_hidden.value.trim()=='') || formObj.vndr_seq.value.trim()!=formObj.vndr_seq_hidden.value.trim()){
			formObj.vndr_seq_hidden.value = '';
			formObj.is_valid_vndr_seq.value = '';
			tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
		}
	}


	/**
	 *  VndrCode Validation 함수
	 */
	function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';
//		ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
		if (formObj.is_valid_vndr_seq.value!=undefined && formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value.trim()!=''){
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_vndr_seq.value!=null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_nm.value	= (tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
					formObj.ida_gst_rgst_ste.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
					formObj.ida_gst_rgst_no.value = (tmp[3]!=undefined&&tmp[3]!=null?tmp[3]:'');
					formObj.ida_ste_cd.value = (tmp[4]!=undefined&&tmp[4]!=null?tmp[4]:'');
					formObj.ida_ste_nm.value = (tmp[5]!=undefined&&tmp[5]!=null?tmp[5]:'');
				} else {
					formObj.is_valid_vndr_seq.value = '';
					formObj.vndr_seq_hidden.value = '';
					ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
				}
			} else {
				formObj.is_valid_vndr_seq.value = '';
				formObj.vndr_seq_hidden.value = '';
				ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
			}
		} else {
			formObj.is_valid_vndr_seq.value = '';
			formObj.vndr_seq_hidden.value = '';
			ComShowMessage(ComGetMsg('TES21040')); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
		}
	}

	/**
	 *  Grid에서 Vender Pop으로 값을 가져오는 함수
	 *  @param(rowArray) 로우배열
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		//ComShowMessage(colArray);
		document.all.vndr_seq.value = colArray[2];
		document.all.vndr_seq_nm.value = colArray[4];
		
		var idaGstRgstSte = colArray[10];
		if(idaGstRgstSte == 'R'){
			document.all.ida_gst_rgst_ste.value = "Registered";
		} else if(idaGstRgstSte == 'U') {
			document.all.ida_gst_rgst_ste.value = "Unregistered";
		} else if(idaGstRgstSte == 'C') {
			document.all.ida_gst_rgst_ste.value = "Composite";
		}
		
		document.all.ida_gst_rgst_no.value=colArray[11];
		document.all.ida_ste_cd.value=colArray[12];
		document.all.ida_ste_nm.value=colArray[13];
	}

	/**
	 * Grid에서 Vender Pop으로 값을 가져오는 함수
	 *  @param {int}	rowArray	로우배열
	 *  @param {int}	row 		셀의 row index
	 *  @param {int}	col 		셀의 col index	
	 */
	function getVenderGrid(rowArray, row ,col) {
		var colArray = rowArray[0];
		//ComShowMessage(colArray[2].substr(2,6));
		//ComShowMessage(row+" : "+ col);
		sheetObjects[2].CellValue(row, col) =colArray[2];
	}

//================================= Vendor Code 관련 함수 끝 =============================================

//================================= Cost Office 관련 함수 시작 =================================================

    /**
	 * 입력된 CostOFC값을 Validation하는 함수
	 *
	 */
	function validateCostOFC() {
		var formObj = document.form;
		if (formObj.cost_ofc_cd.readOnly==false){
			if ((formObj.cost_ofc_hidden.value==null || formObj.cost_ofc_hidden.value.trim()=='') || formObj.cost_ofc_cd.value!=formObj.cost_ofc_hidden.value)
			{
				tes_getInputValue('is_valid_cost_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidCostOfc');
			}
		}
	}

	/* 설명 : CostOfc Validation하는 함수
	 * 사용 :
	 */
	function checkValidCostOfc(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_cost_ofc_cd.value!=undefined && formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value.trim()!=''){
			tmp = formObj.is_valid_cost_ofc_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_cost_ofc_cd.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				if (formObj.is_valid_cost_ofc_cd.value!=null && formObj.is_valid_cost_ofc_cd.value == 'Y'){
					if (tmp[1]!=undefined && tmp[1]!=null && tmp[1].trim()!=''){
						if (tmp[1].trim()!='Y'){
							//ComShowMessage(ComGetMsg('TES21036')); //ComShowMessage('CostOFC와 불일치하는 Yard Code입니다.');
							//formObj.yd_cd.focus();
						}
					} else {
						ComShowMessage(ComGetMsg('TES21037')); //ComShowMessage('CostOFC의 해당 Yard Code를 확인하는중 오류가 발생했습니다.');
					}
				} else {
					formObj.is_valid_cost_ofc_cd.value = '';
					ComShowMessage(ComGetMsg('TES21038')); //ComShowMessage('유효하지 않은 CostOFC입니다.');
				}
			} else {
				formObj.is_valid_cost_ofc_cd.value = '';
				ComShowMessage(ComGetMsg('TES21038')); //ComShowMessage('유효하지 않은 CostOFC입니다.');
			}
		} else {
			formObj.is_valid_cost_ofc_cd.value = '';
			ComShowMessage(ComGetMsg('TES21038')); //ComShowMessage('유효하지 않은 CostOFC입니다.');
		}
	}


	/* 설명 : OfcCd값을 Popup에서 가져오는 함수
	 * @param(rowArray )  rowArray
	 */
	function getOfcCd(rowArray) {
		var colArray = rowArray[0];
		document.all.cost_ofc_cd.value = (colArray[3]!=undefined&&colArray[3]!=null?colArray[3]:'');
	}




	/**
	 *  설명 : CostOfc를 Edit가능하게하는 함수
	 */
	function setCostOfcReadOnlyFalse(){
		var formObj = document.form;
		formObj.cost_ofc_cd.readOnly = false;
		if (formObj.cost_ofc_cd.value!=null && formObj.cost_ofc_cd.value.trim()!=''){
			formObj.cost_ofc_hidden.value = formObj.cost_ofc_cd.value;
		}
	}

	/**
	 * Cost Calculation에서 필요한 Combo Code를 setting하는 함수
	 * sheet : Cost Calculation Tab
	 * @param {ibsheet}	sheet sheet
	 * @param {String}	INIT	 INIT
	 */
	function setCalcTerminalManualCostCode(sheet,INIT){
		var formObj = document.form;
		for (var i=1; i<=sheet.RowCount; i++){
			if ( (sheet.CellValue(i,'calc_tp_cd') == 'M' || sheet.CellValue(i, 'calc_tp_cd') == 'S') && sheet.CellValue(i,'lgs_cost_cd')==''){
				org_sts = sheet.RowStatus(i);
				sheet.CellComboItem(i, 'lgs_cost_cd', formObj.calcTerminalComboItemsDesc.value, formObj.calcTerminalComboItems.value);
				sheet.CellValue2(i,'lgs_cost_cd') = sheet.CellValue(i,'lgs_cost_cd2');
				sheet.RowStatus(i) = org_sts;
			}
		}
	}

//================================= Cost Office 관련 함수 끝 =================================================



//================================= VVD/ATB dt 관련 함수 시작 =================================================
	function call_yd_ind_seq_OnChange(){
		getClptIndSeq();	
	}
	
	function getCallYdIndSeq(obj){//alert("start getCallYdIndSeq");
		var formObj = document.form;
		if(obj==undefined || obj.value==null || obj.value.trim()==''){
			formObj.err_inv_no.value = formObj.vvd.value.length;
			return false;
		} else {
			tes_getComboItem('call_yd_ind_seq', 2, SEARCHLIST14, '', 'yd_cd|vvd','getClptIndSeq'); 	
		}
	}
	
	function getClptIndSeq(){//alert("start getClptIndSeq");
		var formObj = document.form;
		formObj.param_call_yd_ind_seq.value = formObj.call_yd_ind_seq.Code;
		if(formObj.param_call_yd_ind_seq.value != ''){
			tes_getInputValue('clpt_ind_seq', SEARCH23, 'yd_cd|vvd|param_call_yd_ind_seq', 'getAtbDt');
		}		
	}
    /**
	 * yd_cd,vvd값으로 AtbDt데이터를 가져오는 함수.
	 * @param {object}	obj	object
	 */
	function getAtbDt(){//alert("start getAtbDt");
	//	ComShowMessage("getAtbDt");
		var formObj = document.form;
		var vvd_hidden = sheetObjects[4];	
		var vvd = formObj.vvd.value + formObj.io_bnd_cd.value + formObj.call_yd_ind_seq.Code + formObj.clpt_ind_seq.value;
		var tmp_date = '20'+formObj.vvd.value.substr(4,4)+'01';
		var atbDt;
		io_hidden = formObj.io_bnd_cd.value;
		formObj.atb_dt.value = '';
//		alert(obj.value);
//		alert(formObj.vvd.value.length);
//		alert(formObj.vvd.value.substr(8,1));
//			if(obj==undefined || obj.value==null || obj.value.trim()==''){
//				formObj.err_inv_no.value = formObj.vvd.value.length;
//				return false;
			//obj.value.length의 1자리를 허용하면 Exception 나기때문에 주석처리   2011.09.26 박성호
			//}else 
		
		if(formObj.vvd.value.length==9){
    		if(!fnChkEmptyObj(formObj.yd_cd)) return;
    		if(!fnChkEmptyObj(formObj.vvd)) return;
    		if(!fnChkEmptyObj(formObj.call_yd_ind_seq)) return;
    		

    		
    		if(formObj.vvd.value.substr(0,4) == 'CNTC'){
    		    if(formObj.vvd.value.substr(8,1) != 'M'){
    		        ComShowMessage(ComGetMsg('TES40052','VVD')); //ComShowMessage('유효하지 않은 VVD입니다.');
    		        formObj.atb_dt.value = '';
        		    formObj.page.value = '';
    		        return false;
    		    }

    		    tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode');

    		    atbDt = 'B|'+formObj.atb_dt.value+'|';
    		    atbDt = atbDt.split('|');

			  	ComEnableObject(formObj.atb_dt, true);

			  	//CNTC항차 작업시 오류발생.. 아래 소스 추가함 -- 2007.09.04
        		if(vvd_hidden.IsDataModified){
        		    for(var i=vvd_hidden.RowCount; i>0; i--){
        		        if(vvd_hidden.CellValue(i,'vvd_ibflag') == 'I'){
        		            vvd_hidden.RowDelete(i, false);
        		        }
        		    }
        		}
        		

               //새로 입력한 vvd_hidden 테이블에 vvd 정보 insert
               if(vvd_hidden.FindText('vvd', vvd) < 0){
                   var row = vvd_hidden.DataInsert(-1);
                   vvd_hidden.CellValue(row,'vvd_vsl_cd')            = formObj.vvd.value.substr(0, 4);
                   vvd_hidden.CellValue(row,'vvd_skd_voy_no')        = formObj.vvd.value.substr(4, 4);
                   vvd_hidden.CellValue(row,'vvd_skd_dir_cd')        = formObj.vvd.value.substr(8, 1);                  
                   vvd_hidden.CellValue(row,'vvd_io_bnd_cd')         = formObj.io_bnd_cd.value;
                   vvd_hidden.CellValue(row,'vvd_call_yd_ind_seq')   = formObj.call_yd_ind_seq.Code;
                   vvd_hidden.CellValue(row,'vvd_clpt_ind_seq')      = formObj.clpt_ind_seq.value;
                   vvd_hidden.CellValue(row,'vvd_atb_dt')            = get_Year(tmp_date)+'-'+get_Month(tmp_date)+'-'+ComGetLastDay(parseInt(get_Year(tmp_date),10), parseInt(get_Month(tmp_date),10));                   
                   vvd_hidden.CellValue(row,'vvd')                   = formObj.vvd.value + formObj.io_bnd_cd.value + formObj.call_yd_ind_seq.Code + formObj.clpt_ind_seq.value;
                   vvd_hidden.CellValue(row,'vvd_type')              = atbDt[0];//atbDt.substr(0,1);
                   vvd_hidden.CellValue(row,'rev_yrmon')             = atbDt[2];//atbDt.substr(0,1);
                   formObj.vvd_type.value = atbDt[0];//atbDt.substr(0,1);
                }

               formObj.page.value = vvd_hidden.FindText('vvd', vvd) +' / '+vvd_hidden.RowCount;

                //CNTC항차의 경우 Voyage No를 기준으로 해당월의 마지막 날을 가져온다.
    		    //아직.. 2000년도 초반이라.. 그냥 20붙이고, 마지막날이라 상관없으니 01을 대충 붙여
    		    //마지막날 찾아옴..  설마 100년넘게 이걸 쓰리라곤..ㅋ
                formObj.atb_dt.value = get_Year(tmp_date)+'-'+get_Month(tmp_date)+'-'+ComGetLastDay(parseInt(get_Year(tmp_date),10), parseInt(get_Month(tmp_date),10));
    		    formObj.atb_dt.readOnly = false;

    		}else{
    			if(formObj.call_yd_ind_seq.Code != '' && formObj.clpt_ind_seq.value != '' && formObj.atb_dt.value == ''){
    				doActionVVDHidden(vvd_hidden,formObj,IBSEARCH_ASYNC01);	 
    			}
    			   		    
    		    //page에 -1값이 나오는 경우를 없애기 위해 getAtbDt함수 하단에 있던 code 를 vvd_hidden_OnSearchEnd로 이동함 -- 2007.09.03
    		    //-------------------------------------------------------------------------------------------------------------//
    		}
		}else{
		    ComShowMessage(ComGetMsg('TES21047')); //ComShowMessage('잘못된 형식의 VVD가 입력되었습니다.');
		    formObj.atb_dt.value = '';
		    return false;
		}		
	}


	/** invoice 코드 체크
	 * 
	 * @return
	 */
	function validateErrInvNo() {
		var formObj = document.form;

		formObj.err_inv_no.value = formObj.err_inv_no.value.trim();
		if (formObj.err_inv_no.value!=null && formObj.err_inv_no.value.trim()!=''){
			tes_getInputValueInvoice('is_valid_err_inv_no', SEARCH03, 'tml_inv_tp_cd|yd_cd|vndr_seq|err_inv_no', 'checkValidErrInvNo');
		}
	}
	
	/** invoice 코드 체크
	 * 
	 * @return
	 */
	function checkValidErrInvNo(){
		var formObj = document.form;

		if (formObj.is_valid_err_inv_no.value!=undefined && formObj.is_valid_err_inv_no.value!=null && formObj.is_valid_err_inv_no.value.trim()=='Y'){
		    sheetObjects[3].CellValue(1,'err_inv_no') = formObj.err_inv_no.value;
			//ComShowMessage('ERR_INV_NO 오케바리');
		} else {
			formObj.is_valid_err_inv_no.value = '';
			ComShowMessage(ComGetMsg('TES40058','ERR INV.NO')); //ComShowMessage('존재하지 않는 ERR INV.NO입니다.');
		}
	}
//================================= retrieve 관련 함수 시작 ==============================================
    /**
     * 화면 상단의 retrieve button click시/Invoice Summary화면에서 detail 조회 시
     * Invoice전체 Data를 조회한다.
     */
    function retrieveAll(){
        var formObj = document.form;
        var main_hidden = sheetObjects[3];
        var sheetObj1 = sheetObjects[0];
        resetSheets();

        if(!fnChkEmptyObj(formObj.vndr_seq)) return false;
		if(!fnChkEmptyObj(formObj.inv_no)) return false;
		//Retrieve Button 클릭 시 첫 번째 페이지를 보여주기 위해 vvd와 atb_dt를 null로 만들어준다.
		formObj.vvd.value = '';
		formObj.atb_dt.value = '';
		comboObjects[1].removeAll();
		document.getElementById("costCalcFlg").value = "";   // Confirm Flag 초기화    ( 2009-05-14 ) 
		doActionMainHidden(main_hidden, formObj, IBSEARCH);
    }


    /**
     * Marine Terminal Invoice인지 확인
     * @param {ibsheet}	sheetObj	sheet object	 
     */
    function isMRInvoice(sheetObj){
        if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "ON"){
            ComShowMessage(ComGetMsg('TES21029')); //ComShowMessage("On-dock Rail Invoice 와 중복됩니다.");
            setInitComponent("N");
            return false;
        }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "OF"){
            ComShowMessage(ComGetMsg('TES21030')); //ComShowMessage("Off Dock Cy Invoice 와 중복됩니다.");
            setInitComponent("N");
            return false;
        }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "ST"){
            ComShowMessage(ComGetMsg('TES21031')); //ComShowMessage("Marine Terminal Storage Invoice 와 중복됩니다.");
            setInitComponent("N");
            return false;
        }else if(sheetObj.CellValue(1, "tml_inv_tp_cd") == "TM"){
            return true;
		}
    }



    /**
     * Cost Calculation Tab의 Mandatory Item Check & Validation
     * 1. Manual 입력비용은 Cost Code값이 mandatory
     * 2. VVD값은 Mandatory. VVD가 가끔 비정상적으로 빠지는 경우가 있어 확인함
     * 3. 전용터미널인 경우 Carrier Code가  Mandatory임
     *    (KRPUSYK, KRPUSYG, KRKANY4, KRPUSKC, JYTYOY1, JPOSAY1)
     *    KRPUSYK, KRPUSYG Yard는 SELTOB에서 입력할 경우 Carrier Code가 Mandatory
     * 4. SVXXJO인 경우 3rd Party 필수 입력값 확인 , Invoice Amount는 0이하값을 가질 수 없음
     * 5. SVXXJO이외의 Cost일 때 3rd Party가 입력된 경우 Contract Rate는 0이하값을 가질 수 없음
     * 6. Invoice Header와 Cost Calculation Tab의 Currency가 다른 Auto Calculated Cost의 경우 반드시 exchange rate이 있어야 함
     */

     function checkCostCalculation(){
         var sheetObject2 = sheetObjects[2];
         var formObj = document.form;
         for(var i = sheetObject2.HeaderRows; i<sheetObject2.HeaderRows + sheetObject2.RowCount; i++){
             if((sheetObject2.CellValue(i,'calc_tp_cd') == 'M' || sheetObject2.CellValue(i,'calc_tp_cd') == 'S') && sheetObject2.CellValue(i,'lgs_cost_cd') == ''){
                 ComShowMessage(ComGetMsg('TES40018')); //ComShowMessage('Manual Input된 Row에 Cost Code가 입력되지 않았습니다.');
                 return false;
             }
             if(sheetObject2.CellValue(i, 'vsl_cd') == '' || sheetObject2.CellValue(i, 'skd_voy_no')==''
               || sheetObject2.CellValue(i, 'skd_dir_cd') == '' || sheetObject2.CellValue(i, 'atb_dt')==''){
                 ComShowMessage('[CASE 4] The system will retrieve the invoice data automatically due to the error to call the related information. ' +
                         '\nPlease input the VVD data again for invoice auditing after completion of retrieve.');
                 retrieveAll();
                 return false;
             }
             //전용 터미널 에서는 Carrier Code를 mandatory Item으로 입력하도록 수정(관리회계팀 요청) - 2007.08.10
             // formObj.yd_cd.value=='KRKANY4' 제거 SELTOB에서만 Mandatory 처리. (2010-05-06)
             if ((formObj.yd_cd.value=='KRPUSKC' 
               || formObj.yd_cd.value=='JPTYOY1' || formObj.yd_cd.value=='JPOSAY1'
             	)
               &&(sheetObject2.CellValue(i,'tml_crr_cd')==null || sheetObject2.CellValue(i,'tml_crr_cd')==''))
             {
                 ComShowMessage('Carrier code is mandatory at '+formObj.yd_cd.value);
                 return false;
             }
             // 전용 터미널중 KRPUSYK, KRPUSYG 에서는 SELTOB인 경우만 Carrier Code를 mandatory Item으로 입력하도록 수정 - 2008.11.17
             // KRKANY4 추가. (2010-05-06)
             // 그룹사 조직 코드 변경 SELTOB->SELTBB (2015-08-03)
             if ( ( (formObj.yd_cd.value=='KRPUSYK' || 
            		 formObj.yd_cd.value=='KRPUSYG' ||
           			 formObj.yd_cd.value=='KRKANY4'
            		)
                && formObj.inv_ofc_cd.value == 'SELTBB' )
                && ( sheetObject2.CellValue(i,'tml_crr_cd')==null || sheetObject2.CellValue(i,'tml_crr_cd')=='') )
             {
                 ComShowMessage('[SELTBB] Carrier code is mandatory at '+formObj.yd_cd.value);
                 return false;
             }
			 /*
			 if(sheetObject2.CellValue(i,"cntr_tpsz_cd") == ""){
			    ComShowMessage("Not Selected Type/Size");
			    return false;
			 }
			 */
             if(sheetObject2.CellValue(i,'lgs_cost_cd') == 'SVXXJO'){
/*
				 if( (sheetObject2.CellValue(i,'rvis_vol_qty') ==''||sheetObject2.CellValue(i,'rvis_vol_qty') == 0)
                     || (sheetObject2.CellValue(i,'n3pty_flg') == ''||sheetObject2.CellValue(i,'n3pty_flg') != 'Y')|| sheetObject2.CellValue(i,'tml_crr_cd') == '')
                 {
                     ComShowMessage(ComGetMsg('TES40022')); //ComShowMessage('SVXXJO에 Revised Vol / 3rd Party / Carrier 는 필수 입력사항입니다.');
					 //msgs['TES40022'] = 'Revised Vol / 3rd Party / Carrier are mandatory items on SVXXJO.' ;
                     return false;
                 }
*/
                 if(sheetObject2.CellValue(i,'tml_crr_cd') == '')
                 {
                     ComShowMessage('Carrier are mandatory items on SVXXJO.');
                     return false;
                 }
				 
				 // 20100617 LJE 과장 요청 	SVXXJO -금액 입력가능-
//				 if(sheetObject2.CellValue(i,'inv_amt') <= 0){
//                     ComShowMessage('Amount should be bigger than 0 when you have 3rd Party(SVXXJO).');
//                     return false;
//                 }
             }

             if(sheetObject2.CellValue(i,'n3pty_flg') == 'Y' && sheetObject2.CellValue(i,'lgs_cost_cd') != 'SVXXJO' && sheetObject2.CellValue(i,'ctrt_rt')<=0){
                 ComShowMessage('Contract Rate should be bigger than 0 when you have 3rd Party');
                 return false;
             }

             if((sheetObject2.CellValue(i,'curr_cd') != formObj.curr_cd.Code) && (sheetObject2.CellValue(i,'inv_xch_rt')==0)&& (sheetObject2.CellValue(i,'calc_tp_cd') == 'A')){
                 ComShowMessage('There is no exchange rate at the suitable column.');
                 return false;
             }
         }
         return true;
     }


    /**
     * Header Search 이후 발생하는 Event처리 함수
     * @param {ibsheet}	sheetObj	IBsheet Object
     * */
    function main_hidden_OnSearchEnd(sheetObj){//alert("start main_hidden_OnSearchEnd");
        var formObj = document.form;

		if(isMRInvoice(sheetObj)==false){
		    return false;
		}
		if(formObj.f_cmd.value == MODIFY01){
		    mainHidden2Form(sheetObj, formObj);
		    ComShowMessage('Confirmed!');
		    setInitComponent('N');
		    tabObjects[0].Enable   = true;
		    return false;
		}
		
		if(formObj.f_cmd.value == MODIFY02){
		    mainHidden2Form(sheetObj, formObj);
		    ComShowMessage('Rejected!');
		    setInitComponent('N');
		    tabObjects[0].Enable   = true;
		    return false;
		}

		if(sheetObj.RowCount == 1){

		    if(formObj.inv_ofc_cd.value == '' || formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value == undefined){
		        ComShowMessage('No Inv OFC data is found in the session');
		        return false;
		    }
		    if(formObj.inv_ofc_cd.value != sheetObj.CellValue(1,'inv_ofc_cd')){
		    	ComShowMessage(ComGetMsg('TES21050'));
		        return false;
		    }

		    if(sheetObj.CellValue(1,'tml_inv_sts_cd').trim()=='A'){
		        ComShowMessage(ComGetMsg('TES23040')); //ComShowMessage('Approval Request 처리된 상태입니다.');
		        setInitComponent("N");
		        return false;
		    }else if(sheetObj.CellValue(1,'tml_inv_sts_cd').trim()=='P'){
		        ComShowMessage(ComGetMsg('TES23041')); //ComShowMessage('A/P Interface 처리된 상태입니다.');
		        setInitComponent("N");
		        return false;
		    }else if(sheetObj.CellValue(1,'tml_inv_sts_cd').trim()=='D'){
		        ComShowMessage('Paid Invoice!'); //ComShowMessage('A/P Interface 처리된 상태입니다.');
		        setInitComponent("N");
		        return false;
		    }else if(sheetObj.CellValue(1,'tml_inv_sts_cd').trim()=='C'){
		        if(ComShowConfirm(ComGetMsg('TES22029'))){ //'Confirmed Invoice 입니다. 수정하시겠습니까?')
		            //Confirm 상태를 풀어주는 function 새로 만들장 요기에....DB에 inv_sts를 R로, rjct_sts_cd = "RL로..
		            sheetObj.CellValue(1,'tml_inv_sts_cd') = 'R';
		            sheetObj.CellValue(1,'tml_inv_sts_nm') = 'RC';
		            if(sheetObj.CellValue(1,'tml_inv_rjct_sts_cd') == 'RJ'){
		                //sheetObj.CellValue(1,'tml_inv_rjct_sts_cd') = 'RL';
		                //RL시키는 action 넣기..

		                //2007.08.03
		                //HPC로 AP I/F, Pay, Cancel Data를 넘기는 로직 추가로
		                //Reject Lift시  아래 값들 NULL로 만들어주는 로직 추가
		                //AP_IF_DT = NULL,  HPC_CRE_FLG = NULL, LEA_CRE_FLG = NULL
		                //AP_CXL_DT = NULL, HPC_CXL_FLG = NULL, LEA_CXL_FLG = NULL
		                //AP_PAY_DT = NULL, HPC_DELT_FLG = NULL
		                doActionMainHidden(sheetObj, formObj, IBSEARCH_ASYNC03);
		            }else{
		                doActionMainHidden(sheetObj, formObj, IBSAVE);
		            }
		        }else{
		            setInitComponent("N");
		            tabObjects[0].Enable   = true;
		            return false;
		        }
		    }
		    if(sheetObj.CellValue(1,'tml_inv_rjct_sts_cd').trim() == 'RJ'){
		        if(ComShowConfirm(ComGetMsg('TES40019'))){//'Rejected Invoice입니다. Reject Lift하시겠습니까?'
		            //sheetObj.CellValue2(1,'tml_inv_rjct_sts_cd') = 'RL';
		            //doActionMainHidden(sheetObj, formObj, IBSAVE);
		            //RL시키는 action 넣기..
		            doActionMainHidden(sheetObj, formObj, IBSEARCH_ASYNC03);
		        }else{
		            setInitComponent("N");
		            return false;
		        }
		    }

		    setInitComponent("Y");
		    ComEnableManyObjects(false, formObj.vndr_seq, formObj.inv_no);

		    if(formObj.f_cmd.value == ADD){
		    	ComEnableManyObjects(true, formObj.vvd, formObj.io_bnd_cd, formObj.call_yd_ind_seq);
		        formObj.vvd.focus();
		    }

		    tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
		    
		    mainHidden2Form(sheetObj, formObj);
		    tes_getInputValue('is_valid_yd_cd', SEARCH09, 'yd_cd', 'checkValidYardCode');
//			tes_getInputValue('laneCode', SEARCH19, 'yd_cd', 'initLaneCode');


		}else if(sheetObj.RowCount > 1){
		    ComShowMessage(ComGetMsg('TES21032')); //ComShowMessage('복수개의 header data가 조회되었습니다.');
		}else if(formObj.is_dup_inv_no.value == 'Y'){ 
			ComShowMessage(ComGetMsg('TES21052')); //ComShowMessage('This Invoice No is duplicated in ERP(A/P). \n\nPlz, change to another Invoice No.');
	        setInitComponent("N");
			return false;
		}else{
		    if(ComShowConfirm(ComGetMsg('TES40031'))){   //'해당 data가 없습니다. 해당 Inv No로 새로 생성하시겠습니까?'
		        setInitComponent("Y");
		        formObj.yd_cd.focus();
		    }else{
		        setInitComponent("N");
		    }
		}
    }

    /**
     * Header Save 이후 발생하는 Event처리 함수
     * @param {ibsheet}	sheetObj	IBsheet object
     * */
    function main_hidden_OnSaveEnd(sheetObj){//alert("start main_hidden_OnSaveEnd");
     // TPB I/F Flag 누락방지 ( 2009-06-15 )
     // Save, Confirm Exception 발생시 SheetObj(main_hidden) 데이타 없을경우
//     if ( sheetObj.RowCount < 1 ) {
//         formObj   = document.form;
//         doActionMainHidden(sheetObj, formObj, IBSEARCH);         
//     } else {
        if(sheetObj.RowCount == 1){
           mainHidden2Form(sheetObj, document.form);
        }

        if(document.form.f_cmd.value == MODIFY01){
            mainHidden2Form(sheetObj, document.form);
            // DAOEXCEPTION 발생후 처리 안된 것 수정 ( 성공여부 상관없이 무조건 alert 되는것 수정 ) - 2009-05-13
            var errMsg = sheetObj.EtcData("successFlg");
             if ( errMsg != "Fail" ) {
       	       ComShowMessage('Confirmed!');
             }
		    setInitComponent("N");
		    tabObjects[0].Enable   = true;
		    return false;
		}
//     }
    }

    /**
     * main_hidden Sheet의 data를 form으로 Copy
     * @param {ibsheet}	sheetObj	sheetObj
     * @param {form}	formObj		formObj
     */
    function mainHidden2Form(sheetObj, formObj){//alert("start mainHidden2Form");
        formObj.tml_so_ofc_cty_cd.value		= sheetObj.CellValue(1, 'tml_so_ofc_cty_cd'  );
        formObj.tml_so_seq.value			= sheetObj.CellValue(1, 'tml_so_seq'         );
        formObj.cost_ofc_cd.value 			= sheetObj.CellValue(1, 'cost_ofc_cd'        );
        formObj.cost_ofc_hidden.value		= sheetObj.CellValue(1, 'cost_ofc_cd'        );
        formObj.inv_no.value			    = sheetObj.CellValue(1, 'inv_no'             );
        formObj.vndr_seq.value			    = sheetObj.CellValue(1, 'vndr_seq'           );
        formObj.yd_cd.value 			    = sheetObj.CellValue(1, 'yd_cd'              );
        formObj.yd_cd_hidden.value 			= sheetObj.CellValue(1, 'yd_cd'              );
        formObj.yd_nm.value 			    = sheetObj.CellValue(1, 'yd_nm'              );
        formObj.curr_cd.Code 			    = sheetObj.CellValue(1, 'curr_cd'            );
        formObj.curr_cd_tmp.value		    = sheetObj.CellValue(1, 'curr_cd'            );
        resetSheetDataProperty(comboObjects[0].Code);
        formObj.hld_rmk.value			    = sheetObj.CellValue(1, 'hld_rmk'            );
        formObj.iss_dt.value			    = sheetObj.CellValue(1, 'iss_dt'             );
        formObj.rcv_dt.value			    = sheetObj.CellValue(1, 'rcv_dt'             );
        formObj.tml_inv_rjct_sts_cd.value = sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd');

        if(sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd') == 'NL'){
            formObj.tml_inv_rjct_sts_nm.value = 'Normal';
        }else if(sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ'){
            formObj.tml_inv_rjct_sts_nm.value = 'Rejected';
        }else if(sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd') == 'RL'){
            formObj.tml_inv_rjct_sts_nm.value = 'Reject Lifted';
        }
//        formObj.tml_inv_rjct_sts_cd.value   = sheetObj.CellValue(1, 'tml_inv_rjct_sts_cd');
        formObj.tml_inv_sts_cd.value		= sheetObj.CellValue(1, 'tml_inv_sts_cd'		 );
        formObj.tml_inv_sts_nm.value		= sheetObj.CellValue(1, 'tml_inv_sts_nm'		 );
        
        //India GST Amount
        formObj.dbt_note_no.value			= sheetObj.CellValue(1, 'dbt_note_no' );
        formObj.ida_cgst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_cgst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_sgst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_sgst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_igst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_igst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.ida_ugst_amt.value 			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ida_ugst_amt' ),sheetObj.CellValue(1,'curr_cd'));
        
        formObj.ttl_inv_amt.value			= tes_chkAmtFmt(sheetObj.CellValue(1, 'ttl_inv_amt' ),sheetObj.CellValue(1,'curr_cd'));
        formObj.vat_amt.value			    = tes_chkAmtFmt(sheetObj.CellValue(1, 'vat_amt'     ),sheetObj.CellValue(1,'curr_cd'));
        formObj.whld_tax_amt.value			= tes_chkAmtFmt(sheetObj.CellValue(1, 'whld_tax_amt'),sheetObj.CellValue(1,'curr_cd'));
//        formObj.total_amt.value   			= tes_chkAmtFmt((Number(sheetObj.CellValue(1, 'ttl_inv_amt' ))
//                                                             + Number(sheetObj.CellValue(1, 'vat_amt'     ))
//                                                             - Number(sheetObj.CellValue(1, 'whld_tax_amt'))), formObj.curr_cd.Code);
        formObj.total_amt.value   			= tes_chkAmtFmt(tes_round( ( Number(sheetObj.CellValue(1, 'ttl_inv_amt' ))
                                                             + Number(sheetObj.CellValue(1, 'vat_amt'     ))
                                                             - Number(sheetObj.CellValue(1, 'whld_tax_amt'))), 2), formObj.curr_cd.Code);

        if (sheetObj.CellValue(1, 'hld_flg')=='Y') {
        	formObj.hld_flg.checked = true;
        } else {
        	formObj.hld_flg.checked = false;
        }

		if (sheetObj.CellValue(1,'edi_flg') == 'Y') {
            formObj.edi_flg.value = 'Y';
			if (sheetObj.CellValue(1,'file_chk') == 'Y') {
            	document.all.EDILayer01.style.display = "inline";	
            } else {
            	document.all.EDILayer01.style.display = "none";
            }
        } else {
            document.all.EDILayer01.style.display = "none";
            formObj.edi_flg.value = '';
        }
        
        if (sheetObj.CellValue(1, 'rtro_tml_inv_flg')=='Y') {
        	formObj.rtro_tml_inv_flg.checked = true;
        } else {
        	formObj.rtro_tml_inv_flg.checked = false;
        }

        if (sheetObj.CellValue(1, 'ap_rvs_cng_flg')=='Y') {
        	formObj.ap_rvs_cng_flg.checked = true;
        } else {
        	formObj.ap_rvs_cng_flg.checked = false;
        }

        if (sheetObj.CellValue(1, 'ap_rvs_cng_flg')=='Y') {
        	formObj.ap_rvs_cng_flg.checked = true;
        } else {
        	formObj.ap_rvs_cng_flg.checked = false;
        }
                
		/**
		 * 	2009-10-15 : [PJM-200900072] INVOICE 조회 조건 - 조회 화면 이동시 재조회하기 추가
		 *  Invoice 조회 화면에서 이동해 왔을 경우 바로 다시 Invoice 조회 화면으로 돌아위한 button활성화 (2009-10-15)
		 */
		 try {
			 for (var i = 0; i < formObj.elements.length; i++){
				 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
				     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
				 {
					 with (formObj) {
						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
							 document.all.PreInquiryCondLayer01.style.display = "inline";
							 break;
						 }
					 }
				 }
			 }
		 } catch(e){} 
		 
    }

/** vvd 값을 히든폼에 넣어줌
 * 
 * @param {ibsheet} sheetObj	IBsheet object
 * @return
 */     
function vvd_check_hidden_OnSearchEnd(sheetObj){//alert("vvd_check_hidden_OnSearchEnd");
    var vvd = sheetObj.CellValue(1, 'vvd_vsl_cd')+sheetObj.CellValue(1, 'vvd_skd_voy_no')+sheetObj.CellValue(1, 'vvd_skd_dir_cd');
    //alert("sheetObj.RowCount:"+sheetObj.RowCount);
            if(sheetObj.RowCount == 1){
//                if (confirm('Same VVD('+vvd+') exists.\n\n You should seperate amount by each VVD.\n\n Do you want to split the amount by VVD ?')){
                if (confirm('Same Vessel Voyage No. with different Direction(VVD:'+vvd+') exists.\n\nYou need to seperate amount by each VVD.\n\nDo you want to split the amount by VVD ?')){
                    
                    var url_str = 'ESD_TES_1003Pop.screen';
				    url_str = url_str + '?tml_so_ofc_cty_cd='+document.form.tml_so_ofc_cty_cd.value;
				    url_str = url_str + '&tml_so_seq='+document.form.tml_so_seq.value;	
				    url_str = url_str + '&yd_cd='+document.form.yd_cd.value;
				    url_str = url_str + '&bound_lgs_cost_cd='+document.form.bound_lgs_cost_cd.value;	
				    
				    url_str = url_str + '&vvd_vsl_cd='+document.form.vvd.value.substr(0, 4);	
				    url_str = url_str + '&vvd_skd_voy_no='+document.form.vvd.value.substr(4, 4);	
				    url_str = url_str + '&vvd_skd_dir_cd='+document.form.vvd.value.substr(8, 1);	
				    url_str = url_str + '&vvd='+document.form.vvd.value;
				    url_str = url_str + '&vvd_atb_dt='+document.form.atb_dt.value;	
				    url_str = url_str + '&vvd_io_bnd_cd='+document.form.io_bnd_cd.value;
				    
				    url_str = url_str + '&vvd_vsl_cd2='+sheetObj.CellValue(1, 'vvd_vsl_cd');	
				    url_str = url_str + '&vvd_skd_voy_no2='+sheetObj.CellValue(1, 'vvd_skd_voy_no');	
				    url_str = url_str + '&vvd_skd_dir_cd2='+sheetObj.CellValue(1, 'vvd_skd_dir_cd');	
				    url_str = url_str + '&vvd2='+vvd;
				    url_str = url_str + '&vvd_atb_dt2='+sheetObj.CellValue(1, 'vvd_atb_dt');	
				    url_str = url_str + '&vvd_io_bnd_cd2='+"";
				    	 	 		
				    
				    window.showModalDialog(url_str, window, "dialogWidth:800px; dialogHeight:425px; help:no; status:no; resizable:yes;");
					                    
                }
                               
            }
}

    /**
     * vvd_hidden 조회된 값을 form에 보여주는 기능
     * @param {ibsheet}	sheetObj	IBsheet object 
     */
    function vvd_hidden_OnSearchEnd(sheetObj){//alert("start vvd_hidden_OnSearchEnd");
        var formObj = document.form;
        //getAtbDt function에서 호출한 doActionVVDHidden 종료 후
        //page에 -1값이 나오는 경우를 없애기 위해 getAtbDt함수 하단에 있던 code 를 vvd_hidden_OnSearchEnd로 이동함 -- 2007.09.03
        if(formObj.f_cmd.value == SEARCH11){//alert("SEARCH11");
            var atbDt = sheetObj.EtcData("etcxml").split('|');
            if(atbDt == undefined ||atbDt == null || atbDt == ''){
                ComShowMessage(ComGetMsg('TES40052','VVD')); //ComShowMessage('유효하지 않은 VVD입니다.');
                formObj.atb_dt.value = '';
                formObj.page.value = '';
                return false;
            }else{

                if(sheetObj.IsDataModified){
                    for(var i=sheetObj.RowCount; i>0; i--){
                        if(sheetObj.CellValue(i,'vvd_ibflag') == 'I'){
                            sheetObj.RowDelete(i, false);
                        }
                    }
                }

                //새로 입력한 vvd_hidden 테이블에 vvd 정보 insert
                if(sheetObj.FindText('vvd', formObj.vvd.value+io_hidden+formObj.call_yd_ind_seq.Code+formObj.clpt_ind_seq.value) < 0){
                    var row = sheetObj.DataInsert(-1);
                    sheetObj.CellValue(row,'vvd_vsl_cd')            = formObj.vvd.value.substr(0, 4);
                    sheetObj.CellValue(row,'vvd_skd_voy_no')        = formObj.vvd.value.substr(4, 4);
                    sheetObj.CellValue(row,'vvd_skd_dir_cd')        = formObj.vvd.value.substr(8, 1);
                    sheetObj.CellValue(row,'vvd_io_bnd_cd')         = formObj.io_bnd_cd.value;
                    sheetObj.CellValue(row,'vvd_atb_dt')            = atbDt[1];
                    sheetObj.CellValue(row,'vvd_call_yd_ind_seq')	= formObj.call_yd_ind_seq.Code;		//[CHM-201640637]Calling Sequence추가
                    sheetObj.CellValue(row,'vvd_clpt_ind_seq')		= formObj.clpt_ind_seq.value;	
                    sheetObj.CellValue(row,'vvd')                   = formObj.vvd.value + formObj.io_bnd_cd.value + formObj.call_yd_ind_seq.Code + formObj.clpt_ind_seq.value;
                    sheetObj.CellValue(row,'vvd_type')              = atbDt[0];//atbDt.substr(0,1);
                    sheetObj.CellValue(row,'rev_yrmon')             = atbDt[2];//atbDt.substr(0,1);
                    formObj.vvd_type.value = atbDt[0];//atbDt.substr(0,1);
                }


                if(atbDt[1].length == 0){
                }else{
                    formObj.atb_dt.value = atbDt[1];//atbDt.substr(1,10);
                }
                
                //alert('atbDt[3]:\n'+atbDt[3] + ' - ' + formObj.yd_cd.value + ' --> ' + formObj.yd_cd.value.substring(0,5)); //COWH0174W (TEST VVD)
                /** [CHM-201428898] (2014-05-09) : JMHK 요청  **/
                if (
                	atbDt[3]!=null && atbDt[3]!='' && atbDt[3].length==7 //&& atbDt[3].substring(0,5)=='KRPUS' //일단 KRPUS만으로 국한하여 적용 -> 양B 요청으로 전체 적용
                	&& formObj.yd_cd.value!=null && formObj.yd_cd.value!='' 
                	&& formObj.yd_cd.value.length==7 //&& formObj.yd_cd.value.substring(0,5)=='KRPUS' //일단 KRPUS만으로 국한하여 적용 -> 양B 요청으로 전체 적용
                	)
                { 
                	if (atbDt[3]!=formObj.yd_cd.value){
                		alert('Unmatched Yard codes between Invoice and VVD terminal.'); // JMHK 제공 문구
                	}
                }
                doActionIBSheet1(sheetObjects[0], formObj, IBSEARCH);
                
            }
            validateAgmtSts();
           
            

        //doActionVVDHidden를 제외한 function 호출시
        }else{//alert("SEARCH11 diff");
            if(sheetObj.RowCount == 0 && formObj.tml_so_ofc_cty_cd.value != '' && formObj.tml_so_seq.value != ''){
            	ComEnableManyObjects(true, formObj.vvd, formObj.io_bnd_cd, formObj.call_yd_ind_seq);
            }
            //retrieve 버튼 클릭시

            if(sheetObj.RowCount > 0 && ComIsNull(formObj.vvd.value) && ComIsNull(formObj.atb_dt.value)){            	
                if(formObj.vvd.value == '' && sheetObj.CellValue(1, 'vvd_atb_dt') != '' && formObj.tml_so_seq.value !=''){
                    formObj.vvd.value = sheetObj.CellValue(1,"vvd_vsl_cd")+sheetObj.CellValue(1,"vvd_skd_voy_no")+sheetObj.CellValue(1,"vvd_skd_dir_cd");                   
                    formObj.io_bnd_cd.value = sheetObj.CellValue(1,"vvd_io_bnd_cd");
                    formObj.atb_dt.value = sheetObj.CellValue(1,"vvd_atb_dt");
                    formObj.vvd_type.value = sheetObj.CellValue(1,"vvd_type");
                    io_hidden = sheetObj.CellValue(1,"vvd_io_bnd_cd");                                                     

                    if(formObj.yd_cd.value != '' && formObj.vvd.value != ''){
                    	//**** LandCode로 인해 문제가 생기는것을 막기위해 새로 만듬 ****
                    	tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode2');
                    	tes_getComboItem('call_yd_ind_seq', 2, SEARCHLIST14, sheetObj.CellValue(1,"vvd_call_yd_ind_seq"), 'yd_cd|vvd');
                    }                	
                    
                    formObj.call_yd_ind_seq.Code = sheetObj.CellValue(1,"vvd_call_yd_ind_seq");
                    formObj.clpt_ind_seq.value = sheetObj.CellValue(1,"vvd_clpt_ind_seq");
                    //comboObjects[1].Enable = false;
                    if(sheetObjects[3].RowCount == 1 && sheetObjects[3].CellValue(1,'tml_inv_sts_cd') != 'C'){
                        validateAgmtSts();
                    }
					//  doActionIBSheet1(sheetObjects[0], formObj, IBSEARCH);
                }
            }
        }        

        if(sheetObj.RowCount > 0){
        	if(formObj.yd_cd.value != '' && formObj.vvd.value != ''){
        		tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode');
        	}
        	
        	formObj.page.value = sheetObj.FindText('vvd', formObj.vvd.value+formObj.io_bnd_cd.value+sheetObj.CellValue(1,"vvd_call_yd_ind_seq")+formObj.clpt_ind_seq.value) +' / '+sheetObj.RowCount; 
        }
        
        tes_setBackColorAllTextTypeReadonly(document.form, setEleNums("yd_cd|cost_ofc_cd|fm_prd_dt|to_prd_dt|ttl_inv_amt|to_prd_dt|iss_dt|rcv_dt"));
    }


    /**
     * t1sheet1 Search 시 CNRT SUMMARY 기능 및
     * discrepancy tab에서 이동한 데이타에 한해 discrepancy tab으로 이동 가능하도록 초기화]
     * @param {ibsheet}	sheetObj	IBsheet object
     */
    function t1sheet1_OnSearchEnd(sheetObj){//alert("start t1sheet1_OnSearchEnd");
        var formObj = document.form;

        formObj.sht_01_ttl.value	= 0;
        formObj.sht_01_full.value	= 0;
        formObj.sht_01_mt.value		= 0;
        formObj.sht_01_ts_same_yard.value = 0;
        formObj.sht_01_D2.value = 0;
        formObj.sht_01_D2.value = 0;
        formObj.sht_01_D4.value = 0;
        formObj.sht_01_D5.value = 0;
        formObj.sht_01_D7.value = 0;
        formObj.sht_01_D8.value = 0;
        formObj.sht_01_D9.value = 0;
        formObj.sht_01_DW.value = 0;
        formObj.sht_01_DX.value = 0;
        formObj.sht_01_R2.value = 0;
        formObj.sht_01_R4.value = 0;
        formObj.sht_01_R5.value = 0;
        formObj.sht_01_R7.value = 0;
        formObj.sht_01_R8.value = 0;
        formObj.sht_01_R9.value = 0;
        formObj.sht_01_F2.value = 0;
        formObj.sht_01_F4.value = 0;
		formObj.sht_01_F5.value = 0;
        formObj.sht_01_O2.value = 0;
        formObj.sht_01_O4.value = 0;
        formObj.sht_01_O5.value = 0;
        formObj.sht_01_O7.value = 0;
        formObj.sht_01_S2.value = 0;
        formObj.sht_01_S4.value = 0;
        formObj.sht_01_T2.value = 0;
        formObj.sht_01_T4.value = 0;
        formObj.sht_01_A2.value = 0;
        formObj.sht_01_A4.value = 0;
        formObj.sht_01_A5.value = 0;
        formObj.sht_01_P2.value = 0;
        formObj.sht_01_P4.value = 0;
        //formObj.sht_01_Z2.value = 0;
        //formObj.sht_01_Z4.value = 0;
        formObj.sht_01_C2.value = 0;
        formObj.sht_01_C4.value = 0;

        formObj.sht_01_ttl.value = sheetObjects[0].RowCount;

        for(var i=1; i<=sheetObj.RowCount; i++){

            with(formObj){
                if(sheetObj.CellValue(i,"cntr_sty_cd")=='F'){
                    sht_01_full.value++;
                }else if(sheetObj.CellValue(i,"cntr_sty_cd")=='M'){
                    sht_01_mt.value++;
                }

                if(sheetObj.CellValue(i,"locl_ts_ind_cd")=='T'){
                    sht_01_ts_same_yard.value++;
                }
                try {
                    eval('sht_01_'+sheetObj.CellValue(i,"cntr_tpsz_cd")).value++;
                } catch(e){
					//ComShowMessage(e); //여길 그냥 통과해야 한다..
				}
            }
        }

        for(var i= sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            if(sheetObj.CellValue(i, 'modi_flg') == 'Y' ){
				//toSheetObj1.InitCellProperty(Row, "chk", dtCheckBox);
				sheetObj.CellEditable(i, 'chk')  = true;
				sheetObj.CellValue(i,'chk') = 0;
			}
            
			sheetObj.CellValue2(i,'lane_cd') = sheetObj.CellValue(i,'lane_cd2');

			// 데이타 정제 작업으로 인한 Logic 수정  - CNTR LIST DSCR_IND_CD에 CO값 코드 부정합 ( 2009-09-16 )
//			if(sheetObj.CellValue(i,'dscr_ind_cd')=='CO'){
//			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Coincidence';
//			}else 
			if(sheetObj.CellValue(i,'dscr_ind_cd')=='HO'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'SML List only';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='HD'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'SML List double';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='NH'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Not in SML source';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='DB'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Double billing';
			}else if(sheetObj.CellValue(i,'dscr_ind_cd')=='DD'){
			    sheetObj.ToolTipText(i,'dscr_ind_cd') = 'Discrepancy by detail data';
			}
			
			// CNTR_LIST 조회 완료 후 Verify Result "CO", "HO"가 아닌경우 Column Color Red Mark ( 4342. 01. 28 - LGH과장 요청 )
			// 데이타 정제 작업으로 인한 Logic 수정  - CNTR LIST DSCR_IND_CD에 CO값 코드 부정합 ( 2009-09-16 )
//			if(sheetObj.CellValue(i,'dscr_ind_cd') != 'CO' && sheetObj.CellValue(i,'dscr_ind_cd') != 'HO' ){
			if(sheetObj.CellValue(i,'dscr_ind_cd') != '' && sheetObj.CellValue(i,'dscr_ind_cd') != 'HO' ){
			    sheetObj.CellBackColor(i,'dscr_ind_cd') = sheetObj.RgbColor(255, 0, 0);
			    sheetObj.CellFontColor(i,'dscr_ind_cd') = sheetObj.RgbColor(255, 255, 0);
			}else {
			    sheetObj.CellBackColor(i,'dscr_ind_cd') = sheetObj.RgbColor(255, 255, 255);
//			    sheetObj.CellFontColor(i,'dscr_ind_cd') = sheetObj.RgbColor(0, 0, 0);
			}
			
        }

        if(sheetObjects[4].RowCount > 0   &&   (sheetObjects[0].RowCount>0 || sheetObjects[1].RowCount>0 || sheetObjects[2].RowCount>0)){
        	ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd, formObj.call_yd_ind_seq);
        }
    }
    
    /** t1 sheet 초기화
     * 
     * @param {String} ErrMsg	err message
     * @return
     */ 
    function t1sheet1_OnSaveEnd(ErrMsg){
        var formObj = document.form;
        ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd, formObj.call_yd_ind_seq);
//        ComShowMessage('Container List Saved!');
    }

    /** t2 sheet 초기화
     * 
     * @param {ibsheet} sheetObj	IBsheet object
     * @return
     */
    function t2sheet1_OnSearchEnd(sheetObj){
        for(var i= sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){

			sheetObj.CellValue(i,'chk') = 0;

			// 미주지역에서(YARD 시작 2자리가 US 임 경우)는 HD, DB는 COINCIDENCE로 옮기기 못하도록 수정
			// COL 용성욱 차장 요청사항        - 2008.03.02 BY JJ KIM
			// 2017.06.29 옮길수 있도록 주석처리 
			//if(document.form.yd_cd.value.substring(0,2) == 'US' && (sheetObj.CellValue(i,'dscr_ind_cd') == 'HD'||sheetObj.CellValue(i,'dscr_ind_cd') == 'DB')){
			//    sheetObj.CellEditable(i, 'chk')  = false;
			//}
			// TES Common  JS를 사용해 lane code값 등을 초기화 시켜주게 되어있다.
			// 초기값 설정작업이 완료되기 전에 조회 작업이 일어나는 경우가 있다.
			// 이 경우 Lane Code 의 값이 누락되는 경우가 발생하기도 한다. 값 누락을 방지하기 위해
			// text로 설정된 lane_cd2의 값을 lane_cd combo로 다시한번 값을 설정해 준다.
			sheetObj.CellValue2(i,'lane_cd') = sheetObj.CellValue(i,'lane_cd2');

			// Discrepancy Tab 조회 완료 후 Discrepancy Reason 중 Full/MT, I/O Bound 가 원인인 경우
			// 해당 Column의 색을 바꿔준다.
//			if(sheetObj.CellValue(i,'dscr_dtl_ind_cd') == 'F'){
//			    sheetObj.CellBackColor(i,'cntr_sty_cd') = sheetObj.RgbColor(255, 153, 153);
//			}else if(sheetObj.CellValue(i,'dscr_dtl_ind_cd') == 'I'){
//			    sheetObj.CellBackColor(i,'io_bnd_cd') = sheetObj.RgbColor(255, 153, 153);
//			}
        }
        
		if(document.form.f_cmd.value==SEARCH10){
			retrieveAll();
		}		
    }

    /** t3 sheet 초기화
     * 
     * @param {ibsheet} sheetObj	sheet object
     * @return
     */
    function t3sheet1_OnSearchEnd(sheetObj){
        var formObj = document.form;
        var cur_sts;
        var accm_vol = 0;
        tmp_seq = 0;

        // Cost Cacluation 버튼 클릭시, Data의 Row Status를 Insert로 바꿔주고,
        // Auto Calculated Volume의 총 합을 구해 Accumulated Volume에 반영한다.
        if(formObj.f_cmd.value == SEARCH04){
            for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
                if(sheetObj.CellValue(i,'calc_tp_cd')=='A'){
                    sheetObj.RowStatus(i) = 'I';
                }
                if(sheetObj.CellValue(i,'accm_chk')=='Y'){
                    accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj.CellValue(i,'rvis_vol_qty'));
                }
            }
            if(formObj.accm_seq.value != ''){
                formObj.pay_vol_qty.value = ComAddComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) + parseInt(Math.round(accm_vol)));
            }
        }

        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			// 변환문자를 특수 문자로 치환. (2010-04-23)
        	sheetObj.CellValue2(i, "calc_rmk") = ComToString( sheetObj.CellValue(i, "calc_rmk") );
			
            //calc_tp_cd가 Manul인 경우 COST CODE combo 초기화
            if(sheetObj.CellValue(i,'calc_tp_cd')=='M'){
                cur_sts = sheetObj.RowStatus(i);
                sheetObj.CellComboItem(i, 'lgs_cost_cd', formObj.calcTerminalComboItemsDesc.value, formObj.calcTerminalComboItems.value);
                sheetObj.CellValue2(i,'lgs_cost_cd') = sheetObj.CellValue(i,'lgs_cost_cd2');
                setShtCellsEditable(sheetObj,i,'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg|tml_trns_mod_cd','Y');
                sheetObj.RowStatus(i) = cur_sts;
                
            }else if (sheetObj.CellValue(i, "calc_tp_cd") == "S") {
            	//요청이 오면 넣어준다
            	cur_sts = sheetObj.RowStatus(i);
                sheetObj.CellComboItem(i, 'lgs_cost_cd', formObj.calcTerminalComboItemsDesc.value, formObj.calcTerminalComboItems.value);
                sheetObj.CellValue2(i,'lgs_cost_cd') = sheetObj.CellValue(i,'lgs_cost_cd2');
            	setShtCellsEditable( sheetObj, i, 'cntr_tpsz_cd|rvis_vol_qty|rf_mntr_dys', 'Y', 'EXCEPTION');
            	sheetObj.RowStatus(i) = cur_sts;
			}

            //lane_cd의 초기화가 늦어 데이타가 어지는 현상을 보완하기 위한 꽁... -_-ㅋ
            sheetObj.CellValue2(i,'lane_cd') = sheetObj.CellValue(i,'lane_cd2');

            
            //edi에서 받은 inv가 아니고  lgs_cost_cd=='TMRFMO' 이면 입력활성화
            if(sheetObj.CellValue(i,'lgs_cost_cd')=='TMRFMO' && document.form.edi_flg.value!='Y'){
                cur_sts = sheetObj.RowStatus(i);
                setShtCellsEditable(sheetObj,i,'rf_mntr_dys','Y');
                sheetObj.RowStatus(i) = cur_sts;
            }else if(sheetObj.CellValue(i,'lgs_cost_cd')=='TMRFMO' && document.form.edi_flg.value=='Y'){
                cur_sts = sheetObj.RowStatus(i);
                setShtCellsEditable(sheetObj,i,'lgs_cost_cd','N');
                sheetObj.RowStatus(i) = cur_sts;
            }

            //3rd data와 so_dtl data를 연결시키는 가상의 Key.
            //가상 key를 활용해 so_dtl data 수정시 바로 3rd Hidden data에도 적용시킬 수 있도록 한다.
            //가상 key 삽입 때문에 sheet의 status가 'U'로 변경되기 때문에 Delete 버튼 클릭시 문제 발생하여
            //아래와 같이 status 를 동일하게 유지시켜주도록 꽁수 사용..ㅡㅡ;
            cur_sts = sheetObj.RowStatus(i);
            sheetObj.CellValue2(i,'page_rows') = tmp_seq ++;
            sheetObj.RowStatus(i) = cur_sts;


            if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='WD'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Week day';
			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='SA'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Saturday';
			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='SU'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Sunday';
			}else if(sheetObj.CellValue(i,'tml_wrk_dy_cd')=='HO'){
			    sheetObj.ToolTipText(i,'tml_wrk_dy_cd') = 'Holiday';
			}

			if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='C'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Container';
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='T'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'TEU';
    		 // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='B'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'BOX';
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='M'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Move';
    		}else if(sheetObj.CellValue(i,'vol_tr_ut_cd')=='G'){
    		    sheetObj.ToolTipText(i,'vol_tr_ut_cd') = 'Gang/Hour';
    		 // CHM-201539086 AgreementInvoice(4종류Invoice모두) 에서 기존 U를 B로 일괄 변경 & CHM-201539507 UOM에 Metric Ton추가 (W)(CAH D - 2016-01-11)
    		} else if (sheetObj.CellValue(i, 'vol_tr_ut_cd') == 'W' ) {
    			sheetObj.ToolTipText(i, 'vol_tr_ut_cd') = 'Ton';
    		}



            //SO Header의 Currency와 AGMT상의 Currency가 다른경우 Exchange Rate 입력 활성화
            if(formObj.curr_cd.Code != sheetObj.CellValue(i,'curr_cd') && sheetObj.CellValue(i,'curr_cd')!=''){
                setShtCellsEditable(sheetObj,i,'inv_xch_rt','Y','EXCEPTION');
            }

            //'SVXXJO'의 경우 3rd로 I/F하는 금액과 TES_TML_SO_DTL의 금액이 일치해야한다.
            // 잔머리 쓰는 유저때문에 추가함                          -- 2007.10.18
//            if(sheetObj.CellValue(i,'lgs_cost_cd') == 'SVXXJO' && sheetObj.CellValue(i,'n3pty_flg') == 'Y'){
//                sheetObj.CellEditable(i,'inv_amt') = false;
//                sheetObj.CellEditable(i,'ctrt_rt') = false;
//                sheetObj.CellEditable(i,'calc_vol_qty') = false;
//                sheetObj.CellEditable(i,'rvis_vol_qty') = false;
//            }else{
//                sheetObj.CellEditable(i,'inv_amt') = true;
//                sheetObj.CellEditable(i,'ctrt_rt') = true;
//                sheetObj.CellEditable(i,'calc_vol_qty') = true;
//                sheetObj.CellEditable(i,'rvis_vol_qty') = true;
//            }
            //Revised Vol. 값이 있는 경우 Type/Size 비활성화 2011.06.24 
            if(sheetObj.CellValue(i,"rvis_knt") > 0){
                setShtCellsEditable(sheetObj,i,'cntr_tpsz_cd','N');
            }
        }

        if(formObj.vvd.value != ''  &&   (sheetObjects[0].RowCount>0 || sheetObjects[1].RowCount>0 || sheetObjects[2].RowCount>0)){
            ComEnableManyObjects(false, formObj.vvd, formObj.io_bnd_cd, formObj.call_yd_ind_seq);
        }
		checkTPBdataEditable(sheetObj);
    }

    /** t3 sheet1 초기화
     * 
     * @param sheetObj
     * @return
     */
    function t3sheet1_OnSaveEnd(sheetObj){
        sheetObjects[6].RemoveAll();
        sheetObjects[7].RemoveAll();
		checkTPBdataEditable(sheetObj);
    }
    
     /**
      * 
      * @param vndr_seq
      * @param lgs_cost_cd
      * @param rf_mntr_dys
      * @param edi_flg
      * @return
      */
 	function calc_rf_mntr_dys(vndr_seq, lgs_cost_cd, rf_mntr_dys, edi_flg){
		/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 (금액 계산을 위해) return한다. **/		
		try {
			if ((vndr_seq!=null && vndr_seq!=undefined && vndr_seq=='180020') &&
				(lgs_cost_cd!=null && lgs_cost_cd!=undefined && lgs_cost_cd=='TMRFMO') &&
				(edi_flg!=null && edi_flg!=undefined && edi_flg=='Y')) {
				if (rf_mntr_dys!=null && rf_mntr_dys.trim()!='' && rf_mntr_dys!=undefined && !isNaN(rf_mntr_dys)){
					return rf_mntr_dys;
				}
			}else if(lgs_cost_cd!=null && lgs_cost_cd!=undefined && lgs_cost_cd=='TMRFMO'){
				if (rf_mntr_dys!=null && rf_mntr_dys.trim()!='' && rf_mntr_dys!=undefined && !isNaN(rf_mntr_dys) && rf_mntr_dys !='0' ){
					return rf_mntr_dys;
				}
			}
			
		} catch(e){
			return 1;
		}
		return 1;
	}     
     
     
    /** t3 sheet1 변경
     * 
     * @param sheetObj		sheet Object
     * @param row			row
     * @param col			col
     * @param value			value
     * @return
     */
    function t3sheet1_OnChange(sheetObj, row, col, value) {//alert("start t3sheet1_OnChange");
        var rvis_qty = sheetObj.CellValue(row,'rvis_vol_qty');
        var rate = sheetObj.CellValue(row,'ctrt_rt');
        var inv_xch_rt = sheetObj.CellValue(row,'inv_xch_rt');
        var n3rd_hidden = sheetObjects[7];
        var rvis_hidden = sheetObjects[6];
        var formObj = document.form;

        if (sheetObj.ColSaveName(col) == "inv_amt"){
            if(sheetObj.CellValue(row,'lgs_cost_cd') == 'SVXXJO' && sheetObj.CellValue(row,'n3pty_flg') == 'Y'){
                if(sheetObj.CellValue(row,'inv_amt') > 0){
                    var tmp_row = -1
                    for(var i = n3rd_hidden.HeaderRows; i<n3rd_hidden.HeaderRows + n3rd_hidden.RowCount; i++){
                        if(sheetObj.CellValue(row,'page_rows') == n3rd_hidden.CellValue(i,'n3rd_page_rows')){
                            tmp_row = i
                        }
                    }

                    if(tmp_row == -1){
                        //doAction 함수.. 추가 - 3rd Amount Update하는 함수..
                        //tmp_row가 -1이면 이미 저장된 상태. 단순히 amount update만 해준다.
                        //수정한 row의 data만 update하기 위해 n3pty_chk 값 사용
                        formObj.tmp_dtl_seq.value = sheetObj.CellValue(row,'tml_so_dtl_seq');
                        formObj.tmp_if_amt.value = sheetObj.CellValue(row,'inv_amt');
                        formObj.tmp_calc_vol_qty.value = sheetObj.CellValue(row,'calc_vol_qty');
                        formObj.tmp_rvis_vol_qty.value = sheetObj.CellValue(row,'rvis_vol_qty');
                        formObj.tmp_ctrt_rt.value = sheetObj.CellValue(row,'ctrt_rt');
                        formObj.tmp_inv_xch_rt.value = sheetObj.CellValue(row,'inv_xch_rt');
                        doActionN3rdHidden(sheetObjects[8], formObj, IBSAVE);
                        ComShowMessage('Correceted amount has been applied to the 3rd Party.');

                    }else{
                        n3rd_hidden.CellValue(tmp_row,'n3rd_if_amt') = sheetObj.CellValue(row,col);
                        ComShowMessage('Correceted amount has been applied to the 3rd Party.');
                    }
                }else{
                    ComShowMessage('Amount shoule be bigger than 0 when you have 3rd Party(SVXXJO).');
//                    sheetObj.ReturnCellData(row,'inv_amt');
                }

            }
            
            //금액이 변경되면 India GST 금액도 변경
            sheetObj.CellValue(row,'ida_cgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_cgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_sgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_sgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_igst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_igst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_ugst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_ugst_rto'))/100,2);
        	
        	sheetObj.CellValue(row,'ida_gst_rto') = parseFloat(sheetObj.CellValue(row,'ida_cgst_rto')) 
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_sgst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_igst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_ugst_rto'));
        	sheetObj.CellValue(row,'ida_gst_amt') = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
        											+ parseFloat(sheetObj.CellValue(row,'ida_sgst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_igst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));
        	
            ShowCalculatedAmountByVVD();



        }else if(sheetObj.ColSaveName(col) == "rvis_vol_qty"){
			/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
        	if(sheetObj.CellValue(row,'plug_term') > 0){
        		if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	        		sheetObj.CellValue(row,'inv_amt') = parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	        	}else{
	        		sheetObj.CellValue(row,'inv_amt') = parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	        	}
        	} else {
	        	if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	        		sheetObj.CellValue(row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	        	}else{
	        		sheetObj.CellValue(row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	        	}
        	}
        	            
        }else if(sheetObj.ColSaveName(col) == "ctrt_rt"){
            if(sheetObj.CellValue(row,'n3pty_flg')=='Y' && sheetObj.CellValue(row,'lgs_cost_cd')!= 'SVXXJO' && sheetObj.CellValue(row,'ctrt_rt')<=0){
                ComShowMessage('Contract rate shoule be bigger than 0 when you have 3rd Party.');
//                sheetObj.ReturnCellData(row,'ctrt_rt');
            }
			/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
            if(sheetObj.CellValue(row,'plug_term') > 0){
	            if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	            	sheetObj.CellValue(row,'inv_amt') = parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	            }else{
	            	sheetObj.CellValue(row,'inv_amt') = parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	            }
            } else {
            	if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	            	sheetObj.CellValue(row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	            }else{
	            	sheetObj.CellValue(row,'inv_amt') = parseFloat(rvis_qty) * parseFloat(rate) * parseFloat(inv_xch_rt) * parseFloat(calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value));
	            }
            }
        }else if(sheetObj.ColSaveName(col) == 'calc_vol_qty'){
            if(sheetObj.CellValue(row,'calc_tp_cd') == 'M'){
                sheetObj.CellValue(row,'rvis_vol_qty') = sheetObj.CellValue(row,'calc_vol_qty');
            }
        }else if(sheetObj.ColSaveName(col) == 'lgs_cost_cd'){
            if(sheetObj.CellValue(row,'calc_tp_cd') == 'M'){	//Manual
                sheetObj.CellValue(row,'tml_trns_mod_cd') = '';

                if(sheetObj.CellValue(row,'lgs_cost_cd') == 'SVLDTS' || sheetObj.CellValue(row,'lgs_cost_cd') == 'TPNDTS'
                   || sheetObj.CellValue(row,'lgs_cost_cd') == 'TMNDTS')
                {
                    sheetObj.CellComboItem(row, 'tml_trns_mod_cd', " |"+ts_trns_mod_cdText, " |"+ts_trns_mod_cdCode);
                }else if(sheetObj.CellValue(row,'lgs_cost_cd') == 'TMNDFL' || sheetObj.CellValue(row,'lgs_cost_cd') == 'TMNDMT'
                   || sheetObj.CellValue(row,'lgs_cost_cd') == 'SVLDFL'|| sheetObj.CellValue(row,'lgs_cost_cd') == 'SVLDMT'
                   || sheetObj.CellValue(row,'lgs_cost_cd') == 'TPNDFL'|| sheetObj.CellValue(row,'lgs_cost_cd') == 'TPNDMT')
                {
                    sheetObj.CellComboItem(row, 'tml_trns_mod_cd', " |"+lc_trns_mod_cdText, " |"+lc_trns_mod_cdCode);
                }else{
                    sheetObj.CellComboItem(row, 'tml_trns_mod_cd', " |"+tml_trns_mod_cdText, " |"+tml_trns_mod_cdCode);
                }
                
                //20140609 
                if(sheetObj.CellValue(row,'lgs_cost_cd') == 'SVXXHC')
                {
                     CheckTor();
                     if(rtnValue!=null && rtnValue!="" && rtnValue!=undefined){
                    	 sheetObj.CellValue(row,'calc_vol_qty') = rtnValue;	 
                     }
                     
                }   
                
            }
            
            //2011.04.11 lgs_cost_cd가 TMRFMO, edi_flg가 Y가 아닐  경우는 rf_mntr_dys 입력가능하도록 만들어 준다.
            if(sheetObj.CellValue(row,'lgs_cost_cd')=='TMRFMO' && document.form.edi_flg.value!='Y'){
                setShtCellsEditable(sheetObj,row,'rf_mntr_dys','Y');
            }else{
            	if(document.form.edi_flg.value!='Y'){
            		sheetObj.CellValue(row,'rf_mntr_dys') = '';
                }
            	setShtCellsEditable(sheetObj,row,'rf_mntr_dys','N');
            }
            
//            //MGSet input popup 띄운다    === 고객요청으로  주석처리함
//            if(sheetObj.CellValue(row,'tml_so_dtl_seq').trim() !='' && sheetObj.CellValue(row,'lgs_cost_cd').trim() == 'TMRFGO'){
//            	if(sheetObj.CellValue(row,'lgs_cost_cd').trim() == sheetObj.CellSearchValue(row,'lgs_cost_cd').trim()){
//            		openMGSet(row);
//            	}else{
//            		ComShowMessage("save sheet...!!");
//            	}
//            }     
            
            if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
            	if(sheetObj.CellValue(row,'lgs_cost_cd') != '' && sheetObj.CellValue(row,'lgs_cost_cd') != null){
            		checkValidForVolRate(sheetObj.CellValue(row,'lgs_cost_cd'), row);            
            	}           		
            }
            
            //[CHM-201536848]Extra Cost Code들에 대한 Remark 10자 이상 입력 강제화
            if(sheetObj.CellValue(row,'lgs_cost_cd') != '' && sheetObj.CellValue(row,'lgs_cost_cd') != null){
            	checkValidForRemark(sheetObj.CellValue(row,'lgs_cost_cd'), row, '2');
            }          
            
        }else if(sheetObj.ColSaveName(col) == 'rf_mntr_dys'){ //2011.04.12 [CHM-201109884-01]
            if(sheetObj.CellValue(row,'plug_term') > 0){
	            if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	                }
	            }else {
	                sheetObj.CellValue(row,'inv_xch_rt') = Math.abs(sheetObj.CellValue(row,'inv_xch_rt'));
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'inv_xch_rt') * sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'ctrt_rt') *  sheetObj.CellValue(row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	                }
	            }
            } else {
            	if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'rvis_vol_qty') *  sheetObj.CellValue(row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	                }
	            }else {
	                sheetObj.CellValue(row,'inv_xch_rt') = Math.abs(sheetObj.CellValue(row,'inv_xch_rt'));
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'inv_xch_rt') * sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'rvis_vol_qty') *  sheetObj.CellValue(row, 'ctrt_rt') *  sheetObj.CellValue(row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	                }
	            }
            }
            
        }else if(sheetObj.ColSaveName(col) == 'inv_xch_rt'){
        	if(sheetObj.CellValue(row,'plug_term') > 0){
	        	if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M' || sheetObj.CellValue(row,'calc_tp_cd') == 'S'){
						/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	                }
	            }else {
	                sheetObj.CellValue(row,'inv_xch_rt') = Math.abs(sheetObj.CellValue(row,'inv_xch_rt'));
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'inv_xch_rt') * sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M'){
	                    /** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'ctrt_rt') *  sheetObj.CellValue(row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	
	                }
	            }
        	} else {
        		if(sheetObj.CellValue(row,'inv_xch_rt')==0){
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M'){
						/** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'rvis_vol_qty') *  sheetObj.CellValue(row, 'ctrt_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	                }
	            }else {
	                sheetObj.CellValue(row,'inv_xch_rt') = Math.abs(sheetObj.CellValue(row,'inv_xch_rt'));
	                if(sheetObj.CellValue(row,'calc_tp_cd') == 'A'){
	                    sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row, 'inv_xch_rt') * sheetObj.CellValue(row,'calc_amt');
	                }else if(sheetObj.CellValue(row,'calc_tp_cd') == 'M'){
	                    /** 2009-08-27 : [PJM-200900072] 부산신항만(180020)이면서 TMRFMO인 경우 REEFER MONITORING DAYS를 곱한다. **/
						sheetObj.CellValue(row,'inv_amt') = sheetObj.CellValue(row,'rvis_vol_qty') *  sheetObj.CellValue(row, 'ctrt_rt') *  sheetObj.CellValue(row, 'inv_xch_rt') * calc_rf_mntr_dys(document.form.vndr_seq.value,sheetObj.CellValue(row,'lgs_cost_cd'),sheetObj.CellValue(row,'rf_mntr_dys'),document.form.edi_flg.value);
	
	                }
	            }
        	}
        //'SVXXJO'의 경우 3rd로 I/F하는 금액과 TES_TML_SO_DTL의 금액이 일치해야한다.
        // 잔머리 쓰는 유저때문에 수정 불가능하도록 수정함                          -- 2007.10.18
//        }else if(sheetObj.ColSaveName(col) == 'n3pty_flg'){
//            if(sheetObj.CellValue(row,'n3pty_flg') == 'Y'){
//                sheetObj.CellEditable(row,'inv_amt') = false;
//                sheetObj.CellEditable(row,'ctrt_rt') = false;
//                sheetObj.CellEditable(row,'calc_vol_qty') = false;
//                sheetObj.CellEditable(row,'rvis_vol_qty') = false;
//                sheetObj.CellEditable(row,'lgs_cost_cd') = false;
//            }else{
//                sheetObj.CellEditable(row,'inv_amt') = true;
//                sheetObj.CellEditable(row,'ctrt_rt') = true;
//                sheetObj.CellEditable(row,'calc_vol_qty') = true;
//                sheetObj.CellEditable(row,'rvis_vol_qty') = true;
//                sheetObj.CellEditable(row,'lgs_cost_cd') = true;
//            }

        // t3sheet1에서 3rd Party 입력 후 Data 수정이 발생할경우
        // 변경된 내용을 n3rd_hidden sheet에도 적용시켜 준다.
        // cntr_tpsz_cd, dcgo_clss_cd, tml_wrk_dy_cd, ioc_cd, lane_ce, tml_crr_cd
        } else if(sheetObj.ColSaveName(col) == 'cntr_tpsz_cd'    || sheetObj.ColSaveName(col) == 'dcgo_ind_cd'
                ||sheetObj.ColSaveName(col) == 'tml_wrk_dy_cd'  || sheetObj.ColSaveName(col) == 'ioc_cd'
                ||sheetObj.ColSaveName(col) == 'rc_flg'         || sheetObj.ColSaveName(col) == 'tml_trns_mod_cd'
                || sheetObj.ColSaveName(col) == 'lane_cd'       || sheetObj.ColSaveName(col) == 'tml_crr_cd')
        {
            for(var i=n3rd_hidden.HeaderRows; i<n3rd_hidden.HeaderRows+n3rd_hidden.RowCount; i++){
                if(sheetObj.CellValue(row,'page_rows')==n3rd_hidden.CellValue(i,'n3rd_page_rows')){
                    n3rd_hidden.CellValue2(i,'n3rd_'+sheetObj.ColSaveName(col)) = sheetObj.CellValue(row,col);
                }
            }

            for(var i=rvis_hidden.HeaderRows; i<rvis_hidden.HeaderRows+rvis_hidden.RowCount; i++){
                if(sheetObj.CellValue(row,'page_rows')==rvis_hidden.CellValue(i,'rvis_page_rows')){
                    rvis_hidden.CellValue2(i,'rvis_'+sheetObj.ColSaveName(col)) = sheetObj.CellValue(row,col);
                }
            }
            
            //2011.05.19 lgs_cost_cd가  rf 타입이면  type/size는 r로 시작하는것만 들어갈수있다.
			 if( sheetObj.ColSaveName(col) == 'cntr_tpsz_cd' && sheetObj.CellValue(row,'cntr_tpsz_cd')!='' && CostCdValidForCalcTpSz(sheetObj.CellValue(row,'lgs_cost_cd'), sheetObj.CellValue(row,'cntr_tpsz_cd')) == false 
					 					&& (sheetObj.CellValue(row,'vol_tr_ut_cd')=="C" || sheetObj.CellValue(row,'vol_tr_ut_cd')=="")){
				 ComShowMessage("Reefer EQ should be selected fot your cost code"); 
				 sheetObj.CellValue(row,'cntr_tpsz_cd') = '';
			 }	

        } else if(sheetObj.ColSaveName(col) == 'ida_sac_cd'){
        	checkValidSacCd(sheetObj.CellValue(row,'ida_sac_cd'), row);
    	
        } else if(sheetObj.ColSaveName(col) == 'ida_cgst_rto' || sheetObj.ColSaveName(col) == 'ida_sgst_rto'
        			|| sheetObj.ColSaveName(col) == 'ida_igst_rto' || sheetObj.ColSaveName(col) == 'ida_ugst_rto'){
        	
        	sheetObj.CellValue(row,'ida_cgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_cgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_sgst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_sgst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_igst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_igst_rto'))/100,2);
        	sheetObj.CellValue(row,'ida_ugst_amt') = tes_round((sheetObj.CellValue(row,'inv_amt') * sheetObj.CellValue(row,'ida_ugst_rto'))/100,2);
        	
        	sheetObj.CellValue(row,'ida_gst_rto') = parseFloat(sheetObj.CellValue(row,'ida_cgst_rto')) 
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_sgst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_igst_rto'))
        	                                        + parseFloat(sheetObj.CellValue(row,'ida_ugst_rto'));
        	sheetObj.CellValue(row,'ida_gst_amt') = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
        											+ parseFloat(sheetObj.CellValue(row,'ida_sgst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_igst_amt'))
        											+ parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));
        	
        	ShowCalculatedAmountByVVD();
        } else if(sheetObj.ColSaveName(col) == 'ida_cgst_amt' || sheetObj.ColSaveName(col) == 'ida_sgst_amt'
					|| sheetObj.ColSaveName(col) == 'ida_igst_amt' || sheetObj.ColSaveName(col) == 'ida_ugst_amt'){
        	sheetObj.CellValue(row,'ida_gst_amt') = parseFloat(sheetObj.CellValue(row,'ida_cgst_amt')) 
													+ parseFloat(sheetObj.CellValue(row,'ida_sgst_amt'))
													+ parseFloat(sheetObj.CellValue(row,'ida_igst_amt'))
													+ parseFloat(sheetObj.CellValue(row,'ida_ugst_amt'));
        	ShowCalculatedAmountByVVD();
        }
        
    }
    
    function checkValidSacCd(idaSacCd, row){
    	document.form.ida_sac_cd.value = idaSacCd;
       	document.form.ida_row.value = row;
       	
       	tes_getInputValue('valid_ida_sac_cd', SEARCH27, 'ida_sac_cd', 'getSacCd');   
    }
    
    function getSacCd(){
    	if(document.form.valid_ida_sac_cd.value == 'Y'){
    		tes_getInputValue('ida_gst_rto', SEARCH26, 'cost_ofc_cd|vndr_seq|ida_sac_cd', 'getIdaGstRto'); 
    	} else {
    		ComShowMessage(ComGetMsg('TES21060'));	//ComShowMessage('This Service Accounting Code is not valid code. Please check it again.');
    		return false;
    	}
    }
    
    function getIdaGstRto() {
    	var formObj = document.form;
    	var idaRow = formObj.ida_row.value;
    	if(formObj.ida_gst_rto.value != null && formObj.ida_gst_rto.value != '') {
    		var tmpInfo = formObj.ida_gst_rto.value;
    		var tmp = tmpInfo.split("|");
    		
    		sheetObjects[2].CellValue(idaRow, 'ida_cgst_rto') = tmp[0];
    		sheetObjects[2].CellValue(idaRow, 'ida_sgst_rto') = tmp[1];
    		sheetObjects[2].CellValue(idaRow, 'ida_igst_rto') = tmp[2];
    		sheetObjects[2].CellValue(idaRow, 'ida_ugst_rto') = tmp[3];
    	}
    }

    /**
     * 3rd Party 입력후에는 Cost Code 수정하지 못하도록 막음    -- 2007.08.21
     * 응급 조치..  onClick event는 combo의 화살표부분은 onClick으로 인식하지 못함. 후속 조치 필요함.
     * 
     * @param(sheetObj) sheet Object
     * @param(row) 		row
     * @param(col) 		col
     * @param(value) 	value
     */
    function t3sheet1_OnClick(sheetObj, row, col, value) {
        if (sheetObj.ColSaveName(col) == "lgs_cost_cd"){
            if(sheetObj.CellValue(row,'n3pty_flg') == 'Y'){
                ComShowMessage('You cannot edit cost code when you have 3rd Party.');
            }
        }

    }
    
    /**
	 * Cost Calculation Sheet의 popup Event 발생시 
	 * @param {ibsheet}	sheetObj	sheet object
	 * @param {String}	row			row
	 * @param {String}	col			col
	 */
	 function t3sheet1_OnPopupClick (sheetObj, row, col){
		var formObj = document.form;
		var rvis_vol_qty = 0;

		if (sheetObj.CellValue(row,"tml_so_dtl_seq")==null || sheetObj.CellValue(row,"tml_so_dtl_seq")==''){
			ComShowMessage('Save Cost Calculation before proceeding');
			return false;
		}

		if (sheetObj.CellValue(row,"inv_amt")!=sheetObj.CellSearchValue(row,"inv_amt")){
			ComShowMessage('Amount has been changed. Save Cost Calculation before proceeding');
			return false;
		}
		if (sheetObj.ColSaveName(col) == "n3pty_flg"){

		    // (-)금액 입력시 Popup Open을 막음(KKY부장님, LJE 대리 요청) - 2007.11.05
		    if((sheetObj.CellValue(row,'lgs_cost_cd')=="SVXXJO" && sheetObj.CellValue(row,'inv_amt')<=0)){
		        ComShowMessage('Invoice amount should be bigger than 0 to insert 3rd Party.');
		        return false;
		    /*
			}else if(sheetObj.CellValue(row,'lgs_cost_cd')!="SVXXJO" && sheetObj.CellValue(row,'ctrt_rt')<=0){
		        ComShowMessage('Contract rate should be bigger than 0 to insert 3rd Party.');
		        return false;
				*/
		    }

		    if (sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC"){
				var url_str = "ESD_TES_9232Pop.screen";    // ESD_TES_9232.jsp
						url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
						url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
						url_str += "&inv_ofc_cd="			+formObj.inv_ofc_cd.value;
						url_str += "&vndr_seq="				+formObj.vndr_seq.value;
						url_str += "&yd_cd="				+formObj.yd_cd.value;
						url_str += "&inv_no="				+formObj.inv_no.value;
						url_str += "&curr_cd="				+formObj.curr_cd.Code;
						url_str += "&vvd="				    +formObj.vvd.value;
						url_str += "&tml_inv_tp_cd="		+formObj.tml_inv_tp_cd.value;  //sheetObjects[3].CellValue(row,"tml_inv_tp_cd"); //main
						url_str += "&calc_cost_grp_cd="		+sheetObj.CellValue(row,"calc_cost_grp_cd");
						url_str += "&calc_tp_cd="			+sheetObj.CellValue(row,"calc_tp_cd");
						url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
						url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
						url_str += "&dcgo_ind_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
						url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
						url_str += "&tml_trns_mod_cd="		+sheetObj.CellValue(row,"tml_trns_mod_cd");
						url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
						url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
						url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd2");
						url_str += "&cal_vol="				+sheetObj.CellValue(row,"calc_vol_qty");
						url_str += "&fm_tr_vol_val="		+sheetObj.CellValue(row,"fm_tr_vol_val");
						url_str += "&to_tr_vol_val="		+sheetObj.CellValue(row,"to_tr_vol_val");
						url_str += "&tml_so_dtl_seq="		+sheetObj.CellValue(row,"tml_so_dtl_seq");
						url_str += "&rvis_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");;
						url_str += "&acct_cd="			    +sheetObj.CellValue(row,"acct_cd");
						url_str += "&inv_amt="				+sheetObj.CellValue(row,"inv_amt");
						url_str += "&ctrt_rt="				+sheetObj.CellValue(row,"ctrt_rt");
						url_str += "&inv_xch_rt="				+sheetObj.CellValue(row,"inv_xch_rt");
						url_str += "&tml_crr_cd="			+sheetObj.CellValue(row,"tml_crr_cd");
						url_str += "&n3rd_page_rows="		+sheetObj.CellValue(row,"page_rows");
						url_str += "&err_inv_no="			+formObj.err_inv_no.value;
						url_str += "&opener_row="			+row;

				window.showModalDialog(url_str, window, "dialogWidth:820px; dialogHeight:480px; help:no; status:no; resizable:yes;");
			}
		}else if (sheetObj.ColSaveName(col) == "rvis_vol_qty"){
			if(sheetObj.CellValue(row,"lgs_cost_cd"	) == ""){
			    ComShowMessage(ComGetMsg('TES21045')); //ComShowMessage("Not Selected Cost Code");
			    return false;
			}
			
			if(sheetObj.CellValue(row, "lgs_cost_cd") == 'SVXXJO'){
			    ComShowMessage(ComGetMsg('TES40021')); //ComShowMessage("SVXJO의 경우 Revised Vol. Popup을 사용할 수 없습니다.");
			    return false;
			}

			// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 YYSB 요청)
			// 2. TPSZ가 "Null"이고 UOM이 "T", "U"인 경우, Revised Vol 입력 허용
//			if ( !(sheetObj.CellValue(row,"cntr_tpsz_cd") == "" && ("T" == sheetObj.CellValue(row,"vol_tr_ut_cd") || "U" == sheetObj.CellValue(row,"vol_tr_ut_cd") ) ) ) {
				if ( sheetObj.CellValue(row,"cntr_tpsz_cd") == "" ) {
					ComShowMessage("Not Selected Type/Size");
					return false;
				}
//			}
			
			if(sheetObj.CellSearchValue(row,'cntr_tpsz_cd').trim() == ''){
			    ComShowMessage(ComGetMsg('TES22041')); //ComShowMessage("SVXJO의 경우 Revised Vol. Popup을 사용할 수 없습니다.");
			    return false;
			} else 
				if (sheetObj.CellValue(row,'cntr_tpsz_cd').trim()!=sheetObj.CellSearchValue(row,'cntr_tpsz_cd').trim()) {
				ComShowMessage(ComGetMsg('TES22042',sheetObj.CellSearchValue(row,'cntr_tpsz_cd').trim()));
				return false;
			}

			if (sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.CellValue(row,"calc_tp_cd")=="A"){
			    var url_str = "ESD_TES_9032Pop.screen";
					url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
					url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
					url_str += "&vndr_seq="				+formObj.vndr_seq.value;
					url_str += "&yd_cd="				+formObj.yd_cd.value;
					url_str += "&vvd="				    +formObj.vvd.value;
					url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
					url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
					url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
					url_str += "&dcgo_ind_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
					url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
					url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd2");
					url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
					url_str += "&tml_trns_mod_cd="		+sheetObj.CellValue(row,"tml_trns_mod_cd");
					url_str += "&cal_vol="				+sheetObj.CellValue(row,"calc_vol_qty");
					url_str += "&fm_tr_vol_val="		+sheetObj.CellValue(row,"fm_tr_vol_val");
					url_str += "&to_tr_vol_val="		+sheetObj.CellValue(row,"to_tr_vol_val");
					url_str += "&rvis_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");
					url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
					url_str += "&calc_tp_cd="           +sheetObj.CellValue(row,"calc_tp_cd");
					url_str += "&cntr_sty_cd="          +sheetObj.CellValue(row,"cntr_sty_cd");
					url_str += "&tml_so_dtl_seq="       +sheetObj.CellValue(row,"tml_so_dtl_seq");
					url_str += "&ctrt_rt="              +sheetObj.CellValue(row,"ctrt_rt");
					url_str += "&page_rows="            +sheetObj.CellValue(row,"page_rows");
					url_str += "&tml_crr_cd="           +sheetObj.CellValue(row,"tml_crr_cd");
					url_str += "&rc_flg="           	+sheetObj.CellValue(row,"rc_flg");
					url_str += "&opener_row="			+row;
					url_str += "&atb_dt="				+formObj.atb_dt.value;
				window.showModalDialog(url_str, window, "dialogWidth:440px; dialogHeight:450px; help:no; status:no; resizable:yes;");
			}else if(sheetObj.CellValue(row,"lgs_cost_cd")!="TMXXDC" && (sheetObj.CellValue(row,"calc_tp_cd")=="M" || sheetObj.CellValue(row,"calc_tp_cd")=="S"))
			{
				//temp_lgs_cost_cd : divCDValue조회를 위해 lgs_cost_cd전달하는 변수임.. 지우지 마세요!!!
				formObj.temp_lgs_cost_cd.value = sheetObj.CellValue(row,"lgs_cost_cd");
				doActionRvisHidden(sheetObjects[8], formObj, IBSEARCH);
				var divCDValue = sheetObjects[8].EtcData("etcxml");
				
				// CHM-201432590 [TES] TES: SVRHCC/SVRHCD 비용처리시 TOR의 Rehandling data 조회기능 추가 2015-02-10
				if ((sheetObj.CellValue(row,"lgs_cost_cd")=="SVRHCC" || sheetObj.CellValue(row,"lgs_cost_cd")=="SVRHCD") && rvisVolCnt(sheetObj, row, divCDValue) < 1){
				     var url_str = "ESD_TES_9035.screen";
				     url_str += "?tml_so_ofc_cty_cd=" +formObj.tml_so_ofc_cty_cd.value;
				     url_str += "&tml_so_seq="   +formObj.tml_so_seq.value;
				     url_str += "&tml_so_dtl_seq="  +sheetObj.CellValue(row,"tml_so_dtl_seq");
				     url_str += "&vndr_seq="    +formObj.vndr_seq.value;
				     url_str += "&yd_cd="    +formObj.yd_cd.value;
				     url_str += "&yd_nm="    +formObj.yd_nm.value;
				     url_str += "&vvd="        +formObj.vvd.value;
				     url_str += "&lgs_cost_cd="   +sheetObj.CellValue(row,"lgs_cost_cd");
				     url_str += "&cntr_tpsz_cd="   +sheetObj.CellValue(row,"cntr_tpsz_cd");
				     url_str += "&io_bnd_cd="   +sheetObj.CellValue(row,"io_bnd_cd");
				     url_str += "&dcgo_ind_cd="   +sheetObj.CellValue(row,"dcgo_ind_cd");
				     url_str += "&ioc_cd="    +sheetObj.CellValue(row,"ioc_cd");
				     url_str += "&lane_cd="    +sheetObj.CellValue(row,"lane_cd");
				     url_str += "&tml_wrk_dy_cd="  +sheetObj.CellValue(row,"tml_wrk_dy_cd");
				     url_str += "&tml_trns_mod_cd="  +sheetObj.CellValue(row,"tml_trns_mod_cd");
				     url_str += "&cal_vol="    +sheetObj.CellValue(row,"calc_vol_qty");
				     url_str += "&fm_tr_vol_val="  +sheetObj.CellValue(row,"fm_tr_vol_val");
				     url_str += "&to_tr_vol_val="  +sheetObj.CellValue(row,"to_tr_vol_val");
				     url_str += "&rvis_div="    +divCDValue;
				     url_str += "&rvis_vol_qty="   +sheetObj.CellValue(row,"rvis_vol_qty");
				     url_str +="&calc_tp_cd="            +sheetObj.CellValue(row,"calc_tp_cd");
				     url_str += "&opener_row="   +row;
				     url_str += "&tml_so_dtl_seq="       +sheetObj.CellValue(row,"tml_so_dtl_seq");
				     url_str += "&ctrt_rt="              +sheetObj.CellValue(row,"ctrt_rt");
				     url_str += "&page_rows="            +sheetObj.CellValue(row,"page_rows");
				     url_str += "&tml_crr_cd="           +sheetObj.CellValue(row,"tml_crr_cd");
				     url_str += "&rc_flg="           	 +sheetObj.CellValue(row,"rc_flg");
				     url_str += "&edi_so_dtl_id="        +sheetObj.CellValue(row,"edi_so_dtl_id"); //2009-08-27 : [PJM-200900072] 수동만 필요
				     url_str += "&atb_dt="    +formObj.atb_dt.value;
				     url_str += "&edi_flg="    +formObj.edi_flg.value;
				     url_str += "&rf_mntr_dys="   +sheetObj.CellValue(row,"rf_mntr_dys"); //2013.01.17 수동계산시 Amount 산정 할 때 RF Mntr Dys값을 곱해주기 위함
				     //window.showModalDialog(url_str, window, "dialogWidth:450px; dialogHeight:450px; help:no; status:no; resizable:yes;");
				     //var param = "?yd_cd="+formObj.yd_cd.value +"&yd_nm="+formObj.yd_nm.value +"&vvd="+formObj.vvd.value  +"&vndr_seq="+formObj.vndr_seq.value+"&vndr_seq_nm="+formObj.vndr_seq_nm.value+"&prgm_id=ESD_TES_0001&cost_cd_inv_tp_cd=MT&atb_dt="+formObj.atb_dt.value;
				        //ComOpenPopup(sUrl,                     iWidth, iHeight, sFunc,            sDisplay,        bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll)
				         //ComOpenPopup("ESD_TES_9001.do" + param,   820,    670,     "setCostCode",  "1,0,1,1,1,1,1", (window.event.shiftKey)?false:true,   false,    null, null,  null,     'Cost Calculation','no');
				     //ComOpenPopup(url_str,   820,    600,     "setCostCode",  "1,0,1,1,1,1,1", true,   false,    null, null,  null,     'Cost Calculation','no');
				     ComOpenPopup(url_str,   900,    600,     "",  "1,0,1,1,1,1,1", true);
				    }else if(divCDValue == "RH"){
					var url_str = "ESD_TES_9190.screen";
    					url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
    					url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
    					url_str += "&tml_so_dtl_seq="		+sheetObj.CellValue(row,"tml_so_dtl_seq");
    					url_str += "&vvd="				    +formObj.vvd.value;
    					url_str += "&yd_cd="				+formObj.yd_cd.value;
    					url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
    					url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
    					url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
    					url_str += "&dcgo_clss_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
    					url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
    					url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd");
    					url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
    					url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
    					url_str += "&rh_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");
    					url_str += "&page_rows="            +sheetObj.CellValue(row,"page_rows");
    					url_str += "&opener_row="			+row;
    					url_str += "&edi_so_dtl_id="        +sheetObj.CellValue(row,"edi_so_dtl_id"); //2009-08-27 : [PJM-200900072] 수동만 필요    					
						window.showModalDialog(url_str, window, "dialogWidth:440px; dialogHeight:450px; help:no; status:no; resizable:yes;");
				}else if (divCDValue == "RF" && sheetObj.CellValue(row,"lgs_cost_cd")=="TMRFMO"){
					var url_str = "ESD_TES_9033Pop.screen";
					url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
					url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
					url_str += "&tml_so_dtl_seq="		+sheetObj.CellValue(row,"tml_so_dtl_seq");
					url_str += "&vndr_seq="				+formObj.vndr_seq.value;
					url_str += "&yd_cd="				+formObj.yd_cd.value;
					url_str += "&vvd="				    +formObj.vvd.value;
					url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
					url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
					url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
					url_str += "&dcgo_ind_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
					url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
					url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd");
					url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
					url_str += "&tml_trns_mod_cd="		+sheetObj.CellValue(row,"tml_trns_mod_cd");
					url_str += "&cal_vol="				+sheetObj.CellValue(row,"calc_vol_qty");
					url_str += "&fm_tr_vol_val="		+sheetObj.CellValue(row,"fm_tr_vol_val");
					url_str += "&to_tr_vol_val="		+sheetObj.CellValue(row,"to_tr_vol_val");
					url_str += "&rvis_div="				+divCDValue;
					url_str += "&rvis_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");
					url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
					url_str +="&calc_tp_cd="            +sheetObj.CellValue(row,"calc_tp_cd");
					url_str += "&opener_row="			+row;
					url_str += "&tml_so_dtl_seq="       +sheetObj.CellValue(row,"tml_so_dtl_seq");
					url_str += "&ctrt_rt="              +sheetObj.CellValue(row,"ctrt_rt");
					url_str += "&page_rows="            +sheetObj.CellValue(row,"page_rows");
					url_str += "&tml_crr_cd="           +sheetObj.CellValue(row,"tml_crr_cd");
					url_str += "&edi_so_dtl_id="        +sheetObj.CellValue(row,"edi_so_dtl_id"); //2009-08-27 : [PJM-200900072] 수동만 필요
					url_str += "&atb_dt="				+formObj.atb_dt.value;
					url_str += "&edi_flg="				+formObj.edi_flg.value;
					url_str += "&rf_mntr_dys="			+sheetObj.CellValue(row,"rf_mntr_dys"); //2013.01.17 수동계산시 Amount 산정 할 때 RF Mntr Dys값을 곱해주기 위함
					url_str += "&rc_flg="			    +sheetObj.CellValue(row,"rc_flg");

					// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 YYSB 요청)
//					var dialogHeight = "";
//					if ( sheetObj.CellValue(row,"calc_tp_cd") != "A" ) {
//						dialogHeight = "550px";
//					} else {
//						dialogHeight = "450px";
//					}
					window.showModalDialog(url_str, window, "dialogWidth:450px; dialogHeight:450px; help:no; status:no; resizable:yes;");
//					window.showModalDialog(url_str, window, "dialogWidth:450px; dialogHeight:" + dialogHeight + "; help:no; status:no; resizable:yes;");
				}else{
					var url_str = "ESD_TES_9032Pop.screen";
						url_str += "?tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
						url_str += "&tml_so_seq="			+formObj.tml_so_seq.value;
						url_str += "&tml_so_dtl_seq="		+sheetObj.CellValue(row,"tml_so_dtl_seq");
						url_str += "&vndr_seq="				+formObj.vndr_seq.value;
						url_str += "&yd_cd="				+formObj.yd_cd.value;
						url_str += "&vvd="				    +formObj.vvd.value;
						url_str += "&lgs_cost_cd="			+sheetObj.CellValue(row,"lgs_cost_cd");
						url_str += "&cntr_tpsz_cd="			+sheetObj.CellValue(row,"cntr_tpsz_cd");
						url_str += "&io_bnd_cd="			+sheetObj.CellValue(row,"io_bnd_cd");
						url_str += "&dcgo_ind_cd="			+sheetObj.CellValue(row,"dcgo_ind_cd");
						url_str += "&ioc_cd="				+sheetObj.CellValue(row,"ioc_cd");
						url_str += "&lane_cd="				+sheetObj.CellValue(row,"lane_cd");
						url_str += "&tml_wrk_dy_cd="		+sheetObj.CellValue(row,"tml_wrk_dy_cd");
						url_str += "&tml_trns_mod_cd="		+sheetObj.CellValue(row,"tml_trns_mod_cd");
						url_str += "&cal_vol="				+sheetObj.CellValue(row,"calc_vol_qty");
						url_str += "&fm_tr_vol_val="		+sheetObj.CellValue(row,"fm_tr_vol_val");
						url_str += "&to_tr_vol_val="		+sheetObj.CellValue(row,"to_tr_vol_val");
						url_str += "&rvis_div="				+divCDValue;
						url_str += "&rvis_vol_qty="			+sheetObj.CellValue(row,"rvis_vol_qty");
						url_str += "&vol_tr_ut_cd="         +sheetObj.CellValue(row,"vol_tr_ut_cd");
						url_str +="&calc_tp_cd="            +sheetObj.CellValue(row,"calc_tp_cd");
						url_str += "&opener_row="			+row;
    					url_str += "&tml_so_dtl_seq="       +sheetObj.CellValue(row,"tml_so_dtl_seq");
    					url_str += "&ctrt_rt="              +sheetObj.CellValue(row,"ctrt_rt");
    					url_str += "&page_rows="            +sheetObj.CellValue(row,"page_rows");
    					url_str += "&tml_crr_cd="           +sheetObj.CellValue(row,"tml_crr_cd");
    					url_str += "&edi_so_dtl_id="        +sheetObj.CellValue(row,"edi_so_dtl_id"); //2009-08-27 : [PJM-200900072] 수동만 필요
    					url_str += "&atb_dt="				+formObj.atb_dt.value;
    					url_str += "&edi_flg="				+formObj.edi_flg.value;
    					url_str += "&rf_mntr_dys="			+sheetObj.CellValue(row,"rf_mntr_dys"); //2013.01.17 수동계산시 Amount 산정 할 때 RF Mntr Dys값을 곱해주기 위함
    					url_str += "&rc_flg="				+sheetObj.CellValue(row,"rc_flg"); 

    					// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 YYSB 요청)
//    					var dialogHeight = "";
//    					if ( sheetObj.CellValue(row,"calc_tp_cd") != "A" ) {
//    						dialogHeight = "550px";
//    					} else {
//    						dialogHeight = "450px";
//    					}
    					window.showModalDialog(url_str, window, "dialogWidth:440px; dialogHeight:450px; help:no; status:no; resizable:yes;");
//						window.showModalDialog(url_str, window, "dialogWidth:440px; dialogHeight:" + dialogHeight + "; help:no; status:no; resizable:yes;");
				}
			}
		}
	}
	 
	// CHM-201432590 [TES] TES: SVRHCC/SVRHCD 비용처리시 TOR의 Rehandling data 조회기능 추가 2015-02-10
	 function rvisVolCnt(sheetObj, row, divCDValue){
		  var formObj = document.form;
		  //formObj.f_cmd.value = SEARCH02;
		  formObj.f_cmd.value = SEARCH;
		     var param = "lgs_cost_cd="+sheetObj.CellValue(row,"lgs_cost_cd") + "&tml_so_dtl_seq="+sheetObj.CellValue(row,"tml_so_dtl_seq") +"&rvis_div="+divCDValue+"&cntr_tpsz_cd="+sheetObj.CellValue(row,"cntr_tpsz_cd");
		     //var searchXml = sheetObj.GetSearchXml("ESD_TES_9032GS.do",  param+'&'+tesFrmQryStr(formObj));
		     var searchXml = sheetObj.GetSearchXml("ESD_TES_9190GS.do",  param+'&'+tesFrmQryStr(formObj));
		     return ComGetTotalRows(searchXml);
	 }

    /** total 값 넣기
     * 
     * @param sheetObj
     * @return
     */
	function total_hidden_OnSearchEnd(sheetObj){
	    ShowCalculatedAmountByVVD();
	}

	/** pay_vol_qty, accm_seq 값 넣어줌 
	 * 
	 * @param (sheetObj) sheet object
	 * @return
	 */
	function accm_hidden_OnSearchEnd(sheetObj){
	    var formObj = document.form;
	    if(sheetObj.RowCount>0){
	        formObj.pay_vol_qty.value = addComma(sheetObj.CellValue(1, 'pay_vol_qty'));
	        formObj.accm_seq.value = sheetObj.CellValue(1,'accm_seq');
	    }
	}
	
	/** setShtCellsEditable2
	 * 
	 * @param sheetObj
	 * @param rownum
	 * @param colnms
	 * @param to_sts
	 * @return
	 */
	function setShtCellsEditable2(sheetObj, rownum, colnms, to_sts) {
		if (rownum==null || rownum==undefined || colnms==null || colnms==undefined || to_sts==null || to_sts==undefined)
		{
			return false;
		}

		var arr_colnms = colnms.split('|');

		for (var i=0; arr_colnms!=null && i<arr_colnms.length; i++){
			sheetObj.CellEditable(rownum,arr_colnms[i]) = (to_sts!=null&&to_sts=='Y'?true:false);
		}
	}
	
	/** Calc. tab을 조회나 저장후 TPB I/F data가 있는 경우 disable한다.
	 * 
	 * @param sheet
	 * @return
	 */
	function checkTPBdataEditable(sheet){
		// Calc. tab을 조회나 저장후 TPB I/F data가 있는 경우 disable한다.
		for (var i=sheet.HeaderRows; sheet!=null && i<(sheet.HeaderRows + sheet.RowCount); i++){
			if (sheet.CellValue(i,"calc_tp_cd")=="M" || sheet.CellValue(i,"calc_tp_cd")=="S") {
				if (sheet.CellValue(i,'n3pty_flg')!=null && sheet.CellValue(i,'n3pty_flg').trim()=='Y'){
					setShtCellsEditable2(sheet,i,'calc_vol_qty|rvis_vol_qty|ctrt_rt|inv_xch_rt|inv_amt','N');
				}
			}
		}
	}
	
	/**  comma를 3자리마다 끼워넣기
	 * 
	 * @param src
	 * @return
	 */
    function addComma(src){
	    // comma를 3자리마다 끼워넣기
		var src = String(src);
		if (src==null || ComTrim(src)==''){
			return '';
		}
		var re = /(-?\d+)(\d{3})/;
		while (re.test(src)) {
			src = src.replace(re, "$1,$2");
		}
		return  src;
	}

    /**
     * Coincidence, Discrepancy 탭간 이동
     * (cntr_status : 'CO'/'DC'
     *  modi_flg    : 'Y'/''   )
     */
    function modifyContainerVerifyStatus(fromSheet, toSheet, cntr_status, modi_flg){
    	//var needDigit = false;
    	
        for(var i=fromSheet.HeaderRows; i<fromSheet.HeaderRows+fromSheet.RowCount; i++){
            if(fromSheet.CellValue(i, 'chk') == '1'){
                fromSheet.CellValue(i,'vrfy_rslt_ind_cd') = cntr_status;
                fromSheet.CellValue(i,'modi_flg') = modi_flg;
                //CNTR_NO 길이 체크 로직 삭제 (2015.12.15 CAH D)
				//if( fromSheet.CellValue(i, 'cntr_no').length <= 10){
				//	needDigit = true;
				//} 
            }
        }
        
        //CNTR_NO 길이 체크 로직 삭제 (2015.12.15 CAH D)
		//if(needDigit){
		//	alert("Wrong Container NO exists, Please click CHK Dgit before verify process.");
		//	return false;
		//}
		
        var queryStr = '';
        queryStr = fromSheet.GetSaveString(false, false, 'chk');
        tes_copy_rows_to2(toSheet, queryStr, true);

        for(var i=fromSheet.RowCount; i>=fromSheet.HeaderRows; i--){
            if(fromSheet.CellValue(i, 'chk') == '1'){
                fromSheet.RowDelete(i, false);
            }
        }
    }

    /**
     * Coincidence, Discrepancy, CostCalculation 탭의 data를 삭제한다.
     * 삭제 대상 테이블 : TES_TML_SO_VVD_LIST
     *                  TES_TML_SO_CNTR_LIST
     *                  TES_TML_SO_RVIS_LIST
     *                  TES_N3RD_PTY_IF
     *                  TES_TML_SO_DTL
     * 사용 이벤트 : tab1, tab2, tab3의 List Clear 버튼 클릭,
     *              get Container시
     */
    function listClear(){
        var formObj = document.form;
        var sheetObj = sheetObjects[2];
        var accm_vol = 0;

        if (formObj.tml_inv_rjct_sts_cd.value=='RJ') {
            ComShowMessage("Rejected Invoice !!");
        	return false;
        }
        if (formObj.tml_inv_sts_cd.value == "C") {
            ComShowMessage("Confirmed Invoice !!");
        	return false;
        }
        if((sheetObjects[0].RowCount > 0 || sheetObjects[1].RowCount > 0) || sheetObjects[2].RowCount > 0 || sheetObjects[4].RowCount > 0){
            if(ComShowConfirm(ComGetMsg('TES40032',formObj.vvd.value+formObj.io_bnd_cd.value))){//formObj.vvd.value+formObj.io_bnd_cd.value+"의 Data를 삭제하시겠습니까? ")){
               //accm_vol 대상인 경우, List Clear시 더해진 ACCM Vol.을 빼준다.
                if(formObj.accm_seq.value != ''){
                    for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
                        if(sheetObj.CellValue(i,'accm_chk')=='Y'){
                            accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj.CellValue(i,'rvis_vol_qty'));
                        }
                    }
                    formObj.pay_vol_qty.value = tes_addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                    doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
                }
                doActionIBSheet1(sheetObjects[0],formObj,IBDELETE);
                //doAction(IBDELETE)후에 header, vvd정보만을 조회해온다. 아래 함수로 다시 sheet를 조회해주면
                //delete후 첫번째 vvd의 data를 보여줌.
                retrieveAll();
            }else{
                return false;
            }
        }else{
            ComShowMessage(formObj.vvd.value+formObj.io_bnd_cd.value+"의 삭제할 Data가 없습니다.");
        }

    }

    /**
     * ATB Date 옆의 page 이동 버튼 클릭시 해당 페이지를 보여준다
     * @param(dir) dir
     */
    function findPage(dir){
        var vvd_hidden = sheetObjects[4];
        var formObj = document.form;
        var page = vvd_hidden.FindText('vvd', formObj.vvd.value+io_hidden+formObj.call_yd_ind_seq.Code+formObj.clpt_ind_seq.value);

        if(page == -1){
            ComShowMessage(ComGetMsg('TES40026')); //ComShowMessage('VVD가 입력되지 않았습니다.');
            return false;
        }

        // REV_YRMON - 2007.05.08 ... Start
//	    if(check_revYRMON() == false){
//            return false;
//        }
	    // REV_YRMON - 2007.05.08 ... END

        page = page + eval(dir);

        formObj.vvd.value = vvd_hidden.CellValue(page,'vvd').substring(0,9);
        formObj.vvd_type.value = vvd_hidden.CellValue(page,'vvd_type');
        //ComEnableObject(formObj.io_bnd_cd), true;
        formObj.io_bnd_cd.value = vvd_hidden.CellValue(page,'vvd_io_bnd_cd');
        io_hidden = vvd_hidden.CellValue(page,'vvd_io_bnd_cd');
        formObj.call_yd_ind_seq.Code = vvd_hidden.CellValue(page,'vvd_call_yd_ind_seq');
        formObj.clpt_ind_seq.value = vvd_hidden.CellValue(page,'vvd_clpt_ind_seq');
        ComEnableObject(formObj.io_bnd_cd, false);
        ComEnableObject(formObj.call_yd_ind_seq, false);
        formObj.atb_dt.value = vvd_hidden.CellValue(page,'vvd_atb_dt');
        formObj.page.value = page +' / '+vvd_hidden.RowCount;
        tes_getInputValue('laneCode', SEARCH19, 'yd_cd|vvd', 'initLaneCode');

        doActionIBSheet1(sheetObjects[0], formObj, IBSEARCH);

    }

    /**
     * Coincidence탭의 data가 변경되었거나,
     * Form의 값중 변경된 값이 있으면 다시 계산하고 저장하도록 한다.
     * - t3sheet의save/confirm Button 클릭 시 발생
     * - Coincidence, Form 값 변경시 : CNTR LIST&HEADER저장 및 재계산
     * - Discrepancy 값 변경시 : CNTR LIST저장
     */
    function needRecalculation(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var sheetObj1 = sheetObjects[1];
        var sheetObj2 = sheetObjects[2];
        var main_hidden = sheetObjects[3];
        var accm_hidden = sheetObjects[5];
        var accm_vol = 0;

        if(formObj.yd_cd.value != main_hidden.CellValue(1,'yd_cd')){
            if(ComShowConfirm(ComGetMsg('TES40033','Yard Code'))){//'Yard Code가 변경되었습니다. 계산된 결과를 clear 후 다시 Calculate해야 합니다. 계속 진행하시겠습니까?')){
                if(formObj.accm_seq.value != ''){
                    for(var i=sheetObj2.HeaderRows; i<sheetObj2.HeaderRows+sheetObj.RowCount; i++){
                        if(sheetObj2.CellValue(i,'accm_chk')=='Y'){
                            accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj2.CellValue(i,'rvis_vol_qty'));
                        }
                    }
                    formObj.pay_vol_qty.value = addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                    doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
                }
                sheetObj2.RemoveAll();
                doActionIBSheet3(sheetObj2,formObj,IBDELETE);
                doActionIBSheet1(sheetObj, formObj, IBSAVE);
            }
        }
        if(accm_hidden.RowCount > 0){
            if(ComReplaceStr(formObj.pay_vol_qty.value,',','') != accm_hidden.CellValue(1,'pay_vol_qty')){
                if(ComShowConfirm(ComGetMsg('TES40033','Accumulated Volume'))){//'Acc. Vol 이 변경되었습니다. 계산된 결과를 clear 후 다시 Calculate해야 합니다. 계속 진행하시겠습니까?'
                    sheetObj2.RemoveAll();
                    doActionIBSheet3(sheetObj2,formObj,IBDELETE);
                    doActionIBSheet1(sheetObj, formObj, IBSAVE);
                }
            }
        }
        if(sheetObj.IsDataModified || sheetObj1.IsDataModified){
            if(formObj.edi_flg.value!='Y' || (formObj.edi_flg.value == 'Y' && sheetObj2.FindText('calc_tp_cd','Auto Calculated Cost')>0)){
                if(ComShowConfirm(ComGetMsg('TES40033','Coincidence Data'))){//'Coincidence의 data가 변경되었습니다. 계산된 결과를 clear 후 다시 Calculate해야 합니다. 계속 진행하시겠습니까?')){
                    if(formObj.accm_seq.value != ''){
                        for(var i=sheetObj2.HeaderRows; i<sheetObj2.HeaderRows+sheetObj.RowCount; i++){
                            if(sheetObj2.CellValue(i,'accm_chk')=='Y'){
                                accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj2.CellValue(i,'rvis_vol_qty'));
                            }
                        }
                        formObj.pay_vol_qty.value = addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                        doActionMainHidden(sheetObjects[3], formObj, IBSAVE);
                    }
                    sheetObj2.RemoveAll();
                    doActionIBSheet3(sheetObj2,formObj,IBDELETE);
                    doActionIBSheet1(sheetObj, formObj, IBSAVE);
                }
            }
        }
        return true;
    }

    /** setShtCellsEditable
     * 
     * @param sheetObj        	sheet object
     * @param rownum			row number
     * @param colnms			colnms
     * @param to_sts			status
     * @param EXCEPTION			예외
     * @return
     */    
    function setShtCellsEditable(sheetObj, rownum, colnms, to_sts, EXCEPTION) {
		// 수동입력 rowadd를 할때마다 실행..
		if (rownum==null || rownum==undefined || colnms==null || colnms==undefined || to_sts==null || to_sts==undefined)
		{
			return false;
		}
		var arr_colnms = colnms.split('|');
		for (var i=0; i<arr_colnms.length; i++)
		{
			if (EXCEPTION!=undefined && EXCEPTION=='EXCEPTION')
			{
				sheetObj.CellEditable(rownum,arr_colnms[i]) = (to_sts!=null&&to_sts=='Y'?true:false);
			} else {
				if (sheetObj.CellValue(rownum,'calc_tp_cd')=='M')
				{
					sheetObj.CellEditable(rownum,arr_colnms[i]) = (to_sts!=null&&to_sts=='Y'?true:false);
				}
			}
		}
	}


	/**
	 * 현재 화면(현재 VVD)의 Cost Calculation 탭의 Invoice Amount 의 합을 구해서
	 * form.vvd_inv_amt.value에 값을 보여줌
	 */
	function ShowCalculatedAmountByVVD(){
	    var sheetObj = sheetObjects[2];
        var tot_hidden = sheetObjects[10];
        var formObj = document.form;
	    var total_amt = 0;
        var curr_amt = 0;
        
        var total_cgst_amt = 0;
        var total_sgst_amt = 0;
        var total_igst_amt = 0;
        var total_ugst_amt = 0;
        
        var cur_cgst_amt = 0;
        var cur_sgst_amt = 0;
        var cur_igst_amt = 0;
        var cur_ugst_amt = 0;

        for(var i=tot_hidden.HeaderRows; i<tot_hidden.HeaderRows+tot_hidden.RowCount; i++){
            if((tot_hidden.CellValue(i,'vvd')+tot_hidden.CellValue(i,'io_bnd_cd'))!=(formObj.vvd.value+io_hidden)){
               // 소수점 게산 버그 주석 처리 ( 2009-06-08 )
//                total_amt = Math.round(total_amt*100)/100 + Math.round(tot_hidden.CellValue(i,'inv_amt')*100)/100;
                // 소수점 계산 버그로 function round 추가 ( 2009-06-08 )
                total_amt = tes_round( (Number(total_amt) + Number(tot_hidden.CellValue(i,'inv_amt')) ), 2 );
                
                total_cgst_amt = tes_round( (Number(total_cgst_amt) + Number(tot_hidden.CellValue(i,'ida_cgst_amt')) ), 2 );                      
                total_sgst_amt = tes_round( (Number(total_sgst_amt) + Number(tot_hidden.CellValue(i,'ida_sgst_amt')) ), 2 );  
                total_igst_amt = tes_round( (Number(total_igst_amt) + Number(tot_hidden.CellValue(i,'ida_igst_amt')) ), 2 );   
                total_ugst_amt = tes_round( (Number(total_ugst_amt) + Number(tot_hidden.CellValue(i,'ida_ugst_amt')) ), 2 );     
            }
        }
        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
               // 소수점 게산 버그 주석 처리 ( 2009-06-08 )
//            curr_amt = Math.round(curr_amt*100)/100 + Math.round(sheetObj.CellValue(i,'inv_amt')*100)/100;
//            curr_amt = eval(parseFloat(curr_amt) + parseFloat(sheetObj.CellValue(i,'inv_amt')));
             // 소수점 계산 버그로 function round 추가 ( 2009-06-08 )
            curr_amt = tes_round( (Number(curr_amt) + Number(sheetObj.CellValue(i,'inv_amt')) ), 2 );
            
            cur_cgst_amt = tes_round( (Number(cur_cgst_amt) + Number(sheetObj.CellValue(i,'ida_cgst_amt')) ), 2 );                      
            cur_sgst_amt = tes_round( (Number(cur_sgst_amt) + Number(sheetObj.CellValue(i,'ida_sgst_amt')) ), 2 );  
            cur_igst_amt = tes_round( (Number(cur_igst_amt) + Number(sheetObj.CellValue(i,'ida_igst_amt')) ), 2 );   
            cur_ugst_amt = tes_round( (Number(cur_ugst_amt) + Number(sheetObj.CellValue(i,'ida_ugst_amt')) ), 2 );    
        }
        
               // 소수점 게산 버그 주석 처리 ( 2009-06-08 )
//        curr_amt = Math.round(curr_amt*100)/100;
//        total_amt = Math.round((total_amt + curr_amt)*100)/100;
        // 소수점 계산 버그로 function round 추가 ( 2009-06-08 )
        curr_amt = tes_round(Number(curr_amt), 2);
        total_amt = tes_round( (Number(total_amt) + Number(curr_amt)), 2);
        
        total_cgst_amt = total_cgst_amt + cur_cgst_amt;
        total_sgst_amt = total_sgst_amt + cur_sgst_amt;
        total_igst_amt = total_igst_amt + cur_igst_amt;
        total_ugst_amt = total_ugst_amt + cur_ugst_amt;       
        
        formObj.vvd_inv_amt.value = tes_chkAmtFmt(curr_amt, formObj.curr_cd.Code);
        formObj.tot_inv_amt.value = tes_chkAmtFmt(total_amt, formObj.curr_cd.Code);
        
        formObj.tot_cgst_amt.value = tes_chkAmtFmt(total_cgst_amt.toFixed(2), formObj.curr_cd.Code);
        formObj.tot_sgst_amt.value = tes_chkAmtFmt(total_sgst_amt.toFixed(2), formObj.curr_cd.Code);
        formObj.tot_igst_amt.value = tes_chkAmtFmt(total_igst_amt.toFixed(2), formObj.curr_cd.Code);
        formObj.tot_ugst_amt.value = tes_chkAmtFmt(total_ugst_amt.toFixed(2), formObj.curr_cd.Code);

	}

	/**
	 * CNTR LIST 저장시
	 * I/O, F/M, DG, WorkingDate, IPC, Lane, T/S 가 모두 입력되어 있는지 체크한다.
	 * I/O의 경우에는 화면의 VVD 정보에 있는 IO Bound와 일치하는지도 체크한다.
	 *
	 * 추후 Trans Mode도 Mandatory Item으로 체크할 예정이다.
	 */
	function CheckCNTRListMandatoryCol(){
	    var formObj = document.form;
	    var flag = true;

	    //Coincidence, Discrepancy 모두 체크 -> Coincidence만 하도록 수정
	    for(j=0; j<1; j++){
	        for(i=sheetObjects[j].HeaderRows; i<sheetObjects[j].HeaderRows + sheetObjects[j].RowCount; i++){
	            if(sheetObjects[j].CellValue(i,'cntr_sty_cd') == '' || sheetObjects[j].CellValue(i,'cntr_sty_cd') == null){
	                flag = false;
	            }
	            if(sheetObjects[j].CellValue(i,'io_bnd_cd') == '' || sheetObjects[j].CellValue(i,'io_bnd_cd') == null){
	                flag = false;
	            }
	            if(sheetObjects[j].CellValue(i,'dcgo_clss_cd') == '' || sheetObjects[j].CellValue(i,'dcgo_clss_cd') == null){
	                flag = false;
	            }
	            if(sheetObjects[j].CellValue(i,'ioc_cd') == '' || sheetObjects[j].CellValue(i,'ioc_cd') == null){
	                flag = false;
	            }
//	            if(sheetObjects[j].CellValue(i,'lane_cd') == '' || sheetObjects[j].CellValue(i,'lane_cd') == null){
//	                flag = false;
//	            }
	            if(sheetObjects[j].CellValue(i,'locl_ts_ind_cd') == '' || sheetObjects[j].CellValue(i,'locl_ts_ind_cd') == null){
	                flag = false;
	            }
	            if(sheetObjects[j].CellValue(i,'cntr_tpsz_cd') == '' || sheetObjects[j].CellValue(i,'cntr_tpsz_cd') == null){
	                flag = false;
	            }
	            if(sheetObjects[j].CellValue(i,'tml_trns_mod_cd') == '' || sheetObjects[j].CellValue(i,'tml_trns_mod_cd') == null){
	                flag = false;
	            }
	        }
	    }

	    if(flag == false){
	        ComShowMessage(ComGetMsg('TES22037','CNTR Type/size, I/O, F/M, DG, WorkingDate, IPC, Mode, Lane, T/S')); //' I/O, F/M, DG, WorkingDate, IPC, Lane, T/S는 필수 입력항목입니다. 확인하십시오.');
	        return false;
	    }

	    for(j=0; j<2; j++){
	        for(i=sheetObjects[j].HeaderRows; i<sheetObjects[j].HeaderRows + sheetObjects[j].RowCount; i++){
	            if(sheetObjects[j].CellValue(i,'io_bnd_cd') != io_hidden && sheetObjects[j].CellValue(i,'io_bnd_cd')!= ''){
	                flag = false;
	            }

	            // SML List Only에서 COP가 없더라도 Data를 보여달라는 요청에따라 I/O Bound가 공란인값이 생기게 되었다.
	            // 공란인 경우 form과 TES_TML_SO_CNTR_LIST model에 'io_bnd_cd'라는 동일한 이름의 변수가 있어서
	            // 값이 밀려 들어가는 현상 발생함..ㅡㅡㅋ
	            // 어찌 막아볼까하여 꽁수를 부려 보았지만 소용없어서.. 일단 그대로 올림
	            // (io_bnd_cd가 없는 행의 값을 update할 경우 첫 번째 io_bnd_cd값이 form의 io_bnd_cd값과 동일한 값이 말려들어가는 현상 발생)
	            // 2007.07.26
	            if(j==1 && sheetObjects[j].RowStatus(i) == 'U' && sheetObjects[j].CellValue(i,'io_bnd_cd')!= io_hidden){
	                sheetObjects[j].CellValue(i,'io_bnd_cd') = 'X';
	            }
	        }

	    }
	    if(flag == false){
	        ComShowMessage(ComGetMsg('TES40054')); //ComShowMessage('입력하신 VVD와 CNTR List의 VVD가 일치하지 않습니다. ');
	        return false;
	    }
	    
	    return true;
	}

	/**
	 * total_amt : ttl_inv_amt + vat_amt - whld_tax_amt 값으로 user 편의를 위해 보여주는 값(readOnly)
	 */
	function set_total_amount(){
	    var formObj = document.form;
	    var ttl_inv_amt = 0;
	    var vat_amt = 0;
	    var whld_tax_amt = 0;

	    if(formObj.ttl_inv_amt.value !== '' || formObj.ttl_inv_amt != undefined){
	        ttl_inv_amt = ComTrimAll(formObj.ttl_inv_amt.value, ",");
	    }
	    if(formObj.vat_amt.value != '' || formObj.vat_amt != undefined){
	        vat_amt = ComTrimAll(formObj.vat_amt.value, ",");
	    }
	    if(formObj.whld_tax_amt.value != '' || formObj.vat_amt != undefined){
	        whld_tax_amt = ComTrimAll(formObj.whld_tax_amt.value, ",");
	    }
	    //2008-09-19 소수점 계산 버그로 *100 /100 추가
	    //formObj.total_amt.value = tes_chkAmtFmt((Number(ttl_inv_amt) + Number(vat_amt) - Number(whld_tax_amt)), formObj.curr_cd.Code);
//	    formObj.total_amt.value = tes_chkAmtFmt((Number(ttl_inv_amt*100) + Number(vat_amt*100) - Number(whld_tax_amt*100))/100, formObj.curr_cd.Code);
        // 소수점 계산 버그로 function round 추가 ( 2009-06-08 )
	    formObj.total_amt.value = tes_chkAmtFmt( tes_round( (Number(ttl_inv_amt) + Number(vat_amt)  - Number(whld_tax_amt)), 2 ), formObj.curr_cd.Code);
	}
	
	function set_vat_amount(){
	    var formObj = document.form;
	    var ttl_inv_amt = 0;
	    var whld_tax_amt = 0;
	    
	    var ida_cgst_amt = 0;
	    var ida_sgst_amt = 0;
	    var ida_igst_amt = 0;
	    var ida_ugst_amt = 0;

	    if(formObj.ttl_inv_amt.value !== '' || formObj.ttl_inv_amt != undefined){
	        ttl_inv_amt = ComTrimAll(formObj.ttl_inv_amt.value, ",");
	    }
	    if(formObj.whld_tax_amt.value != '' || formObj.whld_tax_amt != undefined){
	        whld_tax_amt = ComTrimAll(formObj.whld_tax_amt.value, ",");
	    }
	    if(formObj.ida_cgst_amt.value !== '' || formObj.ida_cgst_amt != undefined){
	    	ida_cgst_amt = ComTrimAll(formObj.ida_cgst_amt.value, ",");
	    }
	    if(formObj.ida_sgst_amt.value !== '' || formObj.ida_sgst_amt != undefined){
	    	ida_sgst_amt = ComTrimAll(formObj.ida_sgst_amt.value, ",");
	    }
	    if(formObj.ida_igst_amt.value !== '' || formObj.ida_igst_amt != undefined){
	    	ida_igst_amt = ComTrimAll(formObj.ida_igst_amt.value, ",");
	    }
	    if(formObj.ida_ugst_amt.value !== '' || formObj.ida_ugst_amt != undefined){
	    	ida_ugst_amt = ComTrimAll(formObj.ida_ugst_amt.value, ",");
	    }
	    
	    formObj.vat_amt.value = tes_chkAmtFmt( tes_round( (Number(ida_cgst_amt) + Number(ida_sgst_amt) + Number(ida_igst_amt) + Number(ida_ugst_amt)), 2 ), formObj.curr_cd.Code );
	    formObj.total_amt.value = tes_chkAmtFmt( tes_round( (Number(ttl_inv_amt) + Number(ida_cgst_amt) + Number(ida_sgst_amt) + Number(ida_igst_amt) + Number(ida_ugst_amt) - Number(whld_tax_amt)), 2 ), formObj.curr_cd.Code );
	    
	}


	/**
	 * Reject 버튼에대한  함수
	 *
	 */
	function rjctInv() {//reject한다 
	    sheetObjects[3].CellValue(1,'tml_inv_rjct_sts_cd') = 'RJ';
	    doActionMainHidden(sheetObjects[3], document.form, IBSEARCH_ASYNC02);
	}

	/**
	 * Currency Code 변경시
	 * 1. Cost Calculation Tab의 데이타 삭제
	 * 2. KRW, JPY가 선택되었을 경우 inv_amt, rate 등의 값의 소수점을 절삭하도록... &  세팅 변경해줌
	 */
	function curr_cd_OnChange(){
		var main_hidden = sheetObjects[3];
		var sheetObj2 = sheetObjects[2];
		var formObj = document.form;
		var accm_vol = 0;

		if (main_hidden.RowCount==1){
		    if((main_hidden.CellValue(1,'curr_cd')!=comboObjects[0].Code) ||
		       (formObj.curr_cd_tmp.value!=undefined && formObj.curr_cd_tmp.value!=null && formObj.curr_cd_tmp.value!='' && formObj.curr_cd_tmp.value!=comboObjects[0].Code)){
		        resetInputValue();
		    }
		    if(sheetObj2.RowCount > 0){
		        if (formObj.curr_cd_tmp.value != comboObjects[0].Code){
    		        if(ComShowConfirm(ComGetMsg('TES40033', 'Currency Code'))){  //'Currency가 변경되었습니다. \n\n Cost Calc. 탭의 Data를 삭제하시겠습니까?'
        		        if(formObj.accm_seq.value != ''){
                            for(var i=sheetObj2.HeaderRows; i<sheetObj2.HeaderRows+sheetObj2.RowCount; i++){
                                if(sheetObj2.CellValue(i,'accm_chk')=='Y'){
                                    accm_vol = parseFloat(accm_vol) + parseFloat(sheetObj2.CellValue(i,'rvis_vol_qty'));
                                }
                            }
                            formObj.pay_vol_qty.value = addComma(parseInt(tes_deleteComma(formObj.pay_vol_qty.value)) - parseInt(Math.round(accm_vol)));
                        }
                        //pay_vol_qty도,, currency Code도 다시 저장해줘야지 싶당..
                        doActionMainHidden(main_hidden, formObj, IBSAVE);
                        sheetObj2.RemoveAll();
                        doActionIBSheet3(sheetObj2,formObj,IBDELETE);
                        resetSheetDataProperty(comboObjects[0].Code);
    		        }else{
    		            comboObjects[0].Code = formObj.curr_cd_tmp.value;
    		        }
		        }
		    }
		    formObj.curr_cd_tmp.value = comboObjects[0].Code;
		}
	}
	
	/** 폼값 초기화
	 * 
	 * @return
	 */ 
	function resetInputValue(){
		var formObj = document.form;
		formObj.ttl_inv_amt.value = '';
		formObj.vat_amt.value = '';
	}
	
	/** CURR_CD 값 설정
	 * 
	 * @param CURR_CD
	 * @return
	 */
	function resetSheetDataProperty(CURR_CD){
        if (CURR_CD!=undefined && tes_isNoDecimalPointCurrCD(CURR_CD)){
            sheetObjects[2].InitDataProperty(0, 29 , dtData  ,    70,    daRight ,  true,    "ctrt_rt" ,  false,  "", dfInteger,   0,     false,       false);
            sheetObjects[2].InitDataProperty(0, 33 , dtData  ,    70,    daRight ,  true,    "inv_amt" ,  false,  "", dfInteger,   0,     false,       false);
        } else {
            sheetObjects[2].InitDataProperty(0, 29 , dtData  ,    70,    daRight ,  true,    "ctrt_rt" ,  false,  "", dfFloat,     2,     false,       false);
            sheetObjects[2].InitDataProperty(0, 33 , dtData  ,    70,    daRight ,  true,    "inv_amt" ,  false,  "", dfFloat,     2,     false,       false);
        }
	}

	/** 기본 정보 저장
	 * 
	 * @return
	 */ 
	function isBasicInfoSaved(){
	    if(sheetObjects[3].RowCount != 1){
	        ComShowMessage(ComGetMsg('TES22005'));  //"SO Header가 저장되지 않았습니다. 저장 후 VVD를 입력하십시오.");
	        document.form.vvd.value = '';
	        return false;
	    }
	}

	/** 사이즈 조절
	 * 
	 * @return
	 */
	function reSize(){
		var div01 = document.all.SearchLayer01.style.display ;
		var div02 = document.all.SearchLayer02.style.display ;
		var obj = event.srcElement;
		if ( div01 == "inline" ){
			obj.src = "/hanjin/img/alps/bu_prev01.gif";
			document.all.SearchLayer01.style.display = "none" ;
			document.all.SearchLayer02.style.display = "none" ;
		} else {
			obj.src = "/hanjin/img/alps/bu_next01.gif";
			document.all.SearchLayer01.style.display = "inline" ;
			document.all.SearchLayer02.style.display = "inline" ;
		}
	}
	
	/**  MR Creation / get CNTR LIST 수행후  R/D Term 필드의 값을 체크하여 I or O 데이타의 체크
	 *   IBSheet 에 인서트 후에 각 Row들을 체크하여 Cell 색을 바꾸어 준다
	 *   
	 * @return
	 */
	function fileimp(){
 
	    doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH);
 
		for(var i=1 ; i < sheetObjects[0].RowCount+1; i++){  

			// .indexOf("I") > 0   .indexOf("O") > 0 
			if(sheetObjects[0].CellValue(i,'rcvde_term_ind_cd').indexOf("I") >= 0 
			|| sheetObjects[0].CellValue(i,'rcvde_term_ind_cd').indexOf("O") >= 0)
			{
				checkFIO++;
				sheetObjects[0].CellBackColor(i, "rcvde_term_ind_cd") = sheetObjects[0].RgbColor(255, 255, 102); //노란색 바탕
			}
		}
	}

	/**  MR Creation / get CNTR LIST 수행후  R/D Term 필드의 값을 체크하여 I or O 데이타의 체크
	 *   fileimp() 메소드 수행후 checkFIO > 0 면 새로운 창을 띠운다
	 *   
	 * @return
	 */
	function CheckFIOLists() {    

        if (checkFIO > 0){
			var url_str = 'ESD_TES_9400Popup.screen';
			url_str += '?tml_so_ofc_cty_cd='+document.form.tml_so_ofc_cty_cd.value;
			url_str += '&tml_so_seq='+document.form.tml_so_seq.value;
			url_str += '&vvd='+document.form.vvd.value;
			url_str += '&io_bnd_cd='+document.getElementById("io_bnd_cd").value;
			url_str += '&fm_cre_mode=Y';
			window.showModalDialog(url_str, window, "dialogWidth:200px; dialogHeight:220px; help:no; status:no; resizable:yes;");
        }else {} //do nothing
		checkFIO = 0;
	}
	
	
	/**  cost code가 SVXXHC 일때 TOR 데이터 참조
	 *   
	 * @return
	 */
	function CheckTor() {    
			var url_str = 'ESD_TES_9500.screen';
			url_str += '?yd_cd='+document.form.yd_cd.value;
			url_str += '&yd_nm='+document.form.yd_nm.value;
			url_str += '&vvd='+document.form.vvd.value;
			url_str += '&atb_dt='+document.form.atb_dt.value;
			rtnValue  =  window.showModalDialog(url_str, window, "dialogWidth:790px; dialogHeight:250px; help:no; status:no; resizable:yes;");
			 
	}
	
	/**  MR Creation / get CNTR LIST 수행후  R/D Term 필드의 값을 체크하여 I or O 데이타의 체크
	 *   Pay를 클릭했을경우 호출
	 *   
	 * @return
	 */
	function setPay() {
	//	sheetObjects[0].SheetBackColor =  sheetObjects[0].RgbColor(255, 255, 255);
		for(var i=1 ; i < sheetObjects[0].RowCount+1; i++){
			if(sheetObjects[0].CellValue(i,'rcvde_term_ind_cd').indexOf("I") >= 0 
			|| sheetObjects[0].CellValue(i,'rcvde_term_ind_cd').indexOf("O") >= 0){
				sheetObjects[0].CellBackColor(i, "rcvde_term_ind_cd") = sheetObjects[0].RgbColor(255, 255, 255); //WHITE 바탕
			}
		}
	}

	/**  MR Creation / get CNTR LIST 수행후  R/D Term 필드의 값을 체크하여 I or O 데이타의 체크
	 *   Reject을 클릭했을경우 호출
	 *   
	 * @return
	 */
	function transferToDC(){	    

	     doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH);  
	}



//================================== doActionIBSheet 모음 시작 ===================================

	/**
	 *  @param sheetObj    sheet object
	 *  @param formObj     form object
	 *  @param sAction     Action	 
	 */
    function doActionMainHidden(sheetObj, formObj, sAction){//alert("start doActionMainHidden");
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction){
            case IBSEARCH :
                formObj.f_cmd.value = SEARCH;  //main_hidden과 vvd_hidden 조회
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
				var arrXml = searchXml.split("|$$|");
                sheetObj.RemoveEtcData();
                
				sheetObj.LoadSearchXml(arrXml[0]);
				sheetObjects[4].LoadSearchXml(arrXml[1]);	            
	            searchXml=null; arrXml[0]=null; arrXml[1]=null;
	            
//                sheetObj.LoadSearchXml(searchXml, false);
//                var sxml0 = sheetObj.EtcData("sxml0");
//                sheetObj.RemoveEtcData();
//                sheetObjects[4].LoadSearchXml(sxml0);
//                searchXml=null; sxml0=null;

                break;

            case IBSAVE :
                if(sheetObj.CellValue(1,'tml_so_seq') == null || sheetObj.CellValue(1,'tml_so_seq') == ''){
                    formObj.f_cmd.value = ADD;
                }else{
                    formObj.f_cmd.value = MODIFY;
                }
                var param = sheetObj.GetSaveString();
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", param+'&'+tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));

//                sheetObjects[3].RemoveAll();
//                if(formObj.f_cmd.value == MODIFY){
//                    sheetObjects[4].RemoveAll();
//                }
//                sheetObjects[5].RemoveAll();
//                
//                sheetObj.LoadSearchXml(saveXml, true);
//                var sxml0 = sheetObj.EtcData("sxml0");
//                var sxml1 = sheetObj.EtcData("sxml1");
//                
//                sheetObj.RemoveEtcData();
//                if(formObj.f_cmd.value == MODIFY){
//                    sheetObjects[4].LoadSearchXml(sxml0);
//                }
//                sheetObjects[5].LoadSearchXml(sxml1);

                
				var arrXml = saveXml.split("|$$|");
				sheetObj.LoadSearchXml(arrXml[0]);
				
                if(formObj.f_cmd.value == MODIFY){
                	sheetObjects[4].LoadSearchXml(arrXml[1]);
                }
                
				sheetObjects[5].LoadSearchXml(arrXml[2]);
                saveXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null;  
                break;


            // VVD 누락현상 방지를 위해 Confirm Logic 수정 - 2007.09.27
            // Confirm Button Click 시 Main Hidden, Calculation, VVD, Rvis, 3rd Data를 한꺼번에 저장
            case IBSEARCH_ASYNC01 :
                formObj.f_cmd.value = MODIFY01;
                var param = sheetObj.GetSaveString()
                             + '&' + sheetObjects[2].GetSaveString(false,false)
                             + '&' + sheetObjects[6].GetSaveString(false,false)
                             + '&' + sheetObjects[7].GetSaveString(false,false);
                             
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", param+'&'+ tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));

				var arrXml = saveXml.split("|$$|");
//				alert(arrXml);
//				alert("arrxml.legnth:"+arrXml.length);
				
				if(arrXml.length>1){
	                sheetObjects[3].RemoveAll();
	                sheetObjects[4].RemoveAll();
	                sheetObjects[5].RemoveAll();
	                
					sheetObj.LoadSearchXml(arrXml[0]);
					sheetObjects[4].LoadSearchXml(arrXml[1]);
					
				}else if(arrXml.length==1){
					if(arrXml[0].indexOf("TES00089")!=-1){
						ComShowMessage(ComGetMsg('TES70803'));
					}else if(arrXml[0].indexOf("TES00085")!=-1){
						ComShowMessage(ComGetMsg('TES70607'));
					}else if(arrXml[0].indexOf("TES00086")!=-1){
						ComShowMessage(ComGetMsg('TES70608'));
					}
					
				}
				
				
// 			    else{
//					ComShowMessage(ComGetMsg('TES80101')); //MGSET CHECK
//				}
				
//                sheetObj.LoadSaveXml(saveXml, true);
//                var sxml0 = sheetObj.EtcData("sxml0");
//                var sxml1 = sheetObj.EtcData("sxml1");
//                sheetObj.RemoveEtcData();
//                sheetObjects[4].LoadSearchXml(sxml0);
//                sheetObjects[5].LoadSearchXml(sxml1);
               
                saveXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null;
                break;


            case IBSEARCH_ASYNC02 :
                //Reject
                //alert("start IBSEARCH_ASYNC02==>"+IBSEARCH_ASYNC02);
                formObj.f_cmd.value = MODIFY02;
                var param = sheetObj.GetSaveString();
                
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", param+'&'+tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObjects[3].RemoveAll();
                sheetObjects[4].RemoveAll();
                sheetObjects[5].RemoveAll();
                
				var arrXml = saveXml.split("|$$|");
				//alert(arrXml.length);
				sheetObj.LoadSearchXml(arrXml[0]);
				sheetObjects[4].LoadSearchXml(arrXml[1]);
				saveXml=null; arrXml[0]=null; arrXml[1]=null;
                
//                sheetObj.LoadSearchXml(saveXml, true);
//                var sxml0 = sheetObj.EtcData("sxml0");
//                var sxml1 = sheetObj.EtcData("sxml1");
//                sheetObj.RemoveEtcData();
//                sheetObjects[4].LoadSearchXml(sxml0);
//                sheetObjects[5].LoadSearchXml(sxml1);
//                saveXml=null; sxml0=null; sxml1=null;
                
                
                break;

            case IBSEARCH_ASYNC03 :
                //Reject Lift
                //alert("start IBSEARCH_ASYNC03==>"+IBSEARCH_ASYNC03);
                formObj.f_cmd.value = MODIFY03;
                formObj.tml_so_ofc_cty_cd.value = sheetObj.CellValue(1,'tml_so_ofc_cty_cd');
                formObj.tml_so_seq.value = sheetObj.CellValue(1,'tml_so_seq');
                
                var saveXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObjects[3].RemoveAll();
                sheetObjects[4].RemoveAll();
                sheetObjects[5].RemoveAll();
                
				var arrXml = saveXml.split("|$$|");
				sheetObj.RemoveEtcData(); 
				sheetObj.LoadSearchXml(arrXml[0]);
				sheetObjects[4].LoadSearchXml(arrXml[1]);
	            searchXml=null; arrXml[0]=null; arrXml[1]=null; 
				
//                sheetObj.LoadSearchXml(saveXml, true);
//                var sxml0 = sheetObj.EtcData("sxml0");
//                var sxml1 = sheetObj.EtcData("sxml1");
//                sheetObj.RemoveEtcData();
//                sheetObjects[4].LoadSearchXml(sxml0);
//                sheetObjects[5].LoadSearchXml(sxml1);
//                saveXml=null; sxml0=null; sxml1=null;

                break;
        }
    }

    /** VVD hidden form 에 값 넣기
     * 
     * @param sheetObj    sheet Object
     * @param formObj	  form  Object	
     * @param sAction	  action value
     * @return
     */
    function doActionVVDHidden(sheetObj, formObj, sAction){//alert("start doActionVVDHidden");
        sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case IBSEARCH_ASYNC01:
            formObj.f_cmd.value = SEARCH11;
            var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (searchXml != "") sheetObj.LoadSearchXml(searchXml, true);
            break;
            
            case IBSEARCH_ASYNC02:
            formObj.f_cmd.value = SEARCH15;
            var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            sheetObjects[11].RemoveAll();
            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
            break;
        }
    }

//    /** hidden form 에 값 넣기  ### 사용하지 않음 ###
//     * 
//     * @param sheetObj			sheet Object
//     * @param formObj			form  Object		
//     * @param sAction			Action value
//     * @return
//     */ 
//    function doActionHidden(sheetObj, formObj, sAction){
//        sheetObj.ShowDebugMsg = false;
//        switch(sAction){
//            case IBSEARCH:
//            formObj.f_cmd.value = SEARCH13;
//            var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj));
//            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
//        }
//    }

    /** hidden form 에 값 넣기
    * 
    * @param sheetObj			sheet Object
    * @param formObj			form  Object		
    * @param sAction			Action value
    * @return
    */ 
    function doActionAccmHidden(sheetObj, formObj, sAction){
        sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case IBSEARCH:
            formObj.f_cmd.value = SEARCH12;
            var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
        }
    }
    
    /** hidden form 에 값 넣기
    * 
    * @param sheetObj			sheet Object
    * @param formObj			form  Object		
    * @param sAction			Action value
    * @return
    */ 
    function doActionRvisHidden(sheetObj, formObj, sAction){//alert("start doActionRvisHidden");
        sheetObj.ShowDebugMsg = false;
        switch(sAction){
            case IBSEARCH:
            formObj.f_cmd.value = SEARCH08;
            var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
        }
    }
    
    /** sheet retrieve 시 설정
     * 
     * @param sheetObj		sheet object
     * @param formObj		form object
     * @param sAction		Action value
     * @return
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회 Coincidence, Discrepancy, CostCalculation 조회
                formObj.f_cmd.value = SEARCH01;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
				var arrXml = searchXml.split("|$$|");

                sheetObjects[0].LoadSearchXml(arrXml[0]);
                sheetObjects[1].LoadSearchXml(arrXml[1]);
                sheetObjects[2].LoadSearchXml(arrXml[2]);
                sheetObjects[5].LoadSearchXml(arrXml[3]);
                sheetObjects[8].LoadSearchXml(arrXml[4]);
                sheetObjects[10].LoadSearchXml(arrXml[5]);	
                searchXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null; arrXml[3]=null; arrXml[4]=null; arrXml[5]=null;  

                afterSearchSheet3(sheetObjects[2]);
                /*                
                // if(searchXml != "")
                sheetObj.LoadSearchXml(searchXml,true);

                var sxml0 = sheetObj.EtcData("sxml0");
                var sxml1 = sheetObj.EtcData("sxml1");
                var sxml2 = sheetObj.EtcData("sxml2");
                var sxml3 = sheetObj.EtcData("sxml3");
                var sxml4 = sheetObj.EtcData("sxml4");
                var sxml5 = sheetObj.EtcData("sxml4");

                sheetObj.RemoveEtcData();
                sheetObjects[0].LoadSearchXml(sxml0);
                sheetObjects[1].LoadSearchXml(sxml1);
                sheetObjects[2].LoadSearchXml(sxml2);
                sheetObjects[5].LoadSearchXml(sxml3);
                sheetObjects[8].LoadSearchXml(sxml4);
                sheetObjects[10].LoadSearchXml(sxml5);
                searchXml=null; sxml0=null; sxml1=null; sxml2=null; sxml3=null; sxml4=null; sxml5=null;
*/                
                
                break;

            case IBSEARCH_ASYNC01:
                formObj.f_cmd.value = SEARCH02;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
				var arrXml = searchXml.split("|$$|");

				sheetObjects[0].LoadSearchXml(arrXml[0]);
                sheetObjects[1].LoadSearchXml(arrXml[1]);
 
                searchXml=null; arrXml[0]=null; arrXml[1]=null;                  
                
                /*
                if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                var sxml0 = sheetObj.EtcData("sxml0");
                var sxml1 = sheetObj.EtcData("sxml1");

                sheetObj.RemoveEtcData();
                sheetObjects[0].LoadSearchXml(sxml0);
                sheetObjects[1].LoadSearchXml(sxml1);
                searchXml=null; sxml0=null; sxml1=null;
                */
                
                break;

            case IBSAVE:       // vvd_hidden, ContainerList(CO/DC)를 저장한다.
                formObj.f_cmd.value = MULTI01;
                var param = sheetObj.GetSaveString(false) + '&' + sheetObjects[1].GetSaveString(false);
                //prompt('', tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd') + '&' + param);
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd') + '&' + param);
                
				var arrXml = saveXml.split("|$$|");

                sheetObjects[0].LoadSearchXml(arrXml[0]);
                sheetObjects[1].LoadSearchXml(arrXml[1]);
                sheetObjects[2].LoadSearchXml(arrXml[2]);
                

                searchXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null; 
                
 /*               
                sheetObj.LoadSaveXml(saveXml,true);
                var sxml0 = sheetObj.EtcData("sxml0");
                var sxml1 = sheetObj.EtcData("sxml1");
                var sxml2 = sheetObj.EtcData("sxml2");
                var sxml3 = sheetObj.EtcData("sxml3");
                sheetObj.RemoveEtcData();
                sheetObjects[0].LoadSearchXml(sxml0);
                sheetObjects[1].LoadSearchXml(sxml1);
                sheetObjects[2].LoadSearchXml(sxml2);
                sheetObjects[4].LoadSearchXml(sxml3);
                sxml0=null; sxml1 =null; sxml2 =null; sxml3 =null;
*/                
                break;

            case IBDELETE:
                formObj.f_cmd.value = REMOVE01;
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObj.LoadSaveXml(saveXml,true);
                break;

            case IBCLEAR:
                formObj.f_cmd.value = REMOVE03;
                var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
                sheetObj.LoadSaveXml(saveXml,true);
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
            	sheetObj. ExcelOption= "NOCOLOR";
                sheetObj.SpeedDown2Excel(-1);
                sheetObj. ExcelOption= "";
                break;
        }
    }
    
    /** doActionIBSheet2
     * 
     * @param sheetObj		sheet Object
     * @param formObj		form  Object
     * @param sAction		sAction value
     * @return
     */
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBDOWNEXCEL:        //엑셀 다운로드
            	sheetObj.ExcelOption= "NOCOLOR";
                sheetObj.SpeedDown2Excel(-1);
            	sheetObj.ExcelOption= "";
                break;

            case IBSEARCH:
                formObj.f_cmd.value = MULTI14;
				formObj.reverify_yn.value = "Y";
				
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
                
				var arrXml = searchXml.split("|$$|");
			
				sheetObj.LoadSearchXml(arrXml[0]);
                sheetObjects[0].LoadSearchXml(arrXml[1]);
                sheetObjects[1].LoadSearchXml(arrXml[2]);
                sheetObj.RemoveEtcData();
                
                searchXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null;
				formObj.reverify_yn.value = '';
                break;
                
        	case IBSEARCH_ASYNC01:
                formObj.f_cmd.value = SEARCH10;
                var param = sheetObj.GetSaveString(true,false);
                var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", param+'&'+tesFrmQryStr(formObj),"",true);
                sheetObj.RemoveAll();
        		if (searchXml!=null && searchXml!='') sheetObj.LoadSearchXml(searchXml);
        		break;		                
        }
    }
    
    /** cost calc 
     * 
     * @param sheetObj 		sheet object 
     * @param formObj		from  object
     * @param sAction		Actio value	
     * @return
     */
    function doActionIBSheet3(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //CostCalc조회
           	  //alert("start IBSEARCH :"+IBSEARCH);
              formObj.f_cmd.value = SEARCH04;
              var searchXml = sheetObj.GetSearchXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
              
              var arrXml = searchXml.split("|$$|");
//              sheetObj.LoadSearchXml(arrXml[0], true);
              sheetObj.RemoveEtcData();
              sheetObjects[2].LoadSearchXml(arrXml[0], true);
              sheetObjects[8].LoadSearchXml(arrXml[1]);
              sheetObjects[10].LoadSearchXml(arrXml[2]);
            
              saveXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null;    
              
/*              
			  sheetObj.LoadSearchXml(searchXml,true);
			  var sxml0 = sheetObj.EtcData("sxml0");
			  var sxml1 = sheetObj.EtcData("sxml1");
			  var sxml2 = sheetObj.EtcData("sxml2");
              sheetObj.RemoveEtcData();
              sheetObjects[2].LoadSearchXml(sxml0,true);
              sheetObjects[8].LoadSearchXml(sxml1);
              sheetObjects[10].LoadSearchXml(sxml2);
              sxml0=null; sxml1 =null; sxml2 =null; //sxml3 =null;
*/       
              
              break;

          case IBSAVE:
        	  //alert("start IBSAVE :"+IBSAVE);	
        	  formObj.f_cmd.value = MULTI02;
        	  
  			if (sheetObj.CellValue(i, 'calc_tp_cd') == 'S' && (sheetObj.RowStatus(i) == 'I' || sheetObj.RowStatus(i) == 'U')) {
				if (sheetObj.CellValue(i, 'inv_amt') == null || parseFloat(sheetObj.CellValue(i, 'inv_amt').trim()) == 0) {
					ComShowMessage("Please input Amount.");
					return false;
				}
			}
        	  
              var param = sheetObj.GetSaveString(false,true) + '&' + sheetObjects[6].GetSaveString(false,false) + '&'
                          + sheetObjects[7].GetSaveString(false,false);
              
              var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", param + '&' + tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
              
              var arrXml = saveXml.split("|$$|");
              sheetObj.LoadSearchXml(arrXml[0]);
              sheetObjects[2].LoadSearchXml(arrXml[0]);
              sheetObjects[8].LoadSearchXml(arrXml[1]);
              sheetObjects[10].LoadSearchXml(arrXml[2]);
              sheetObjects[4].LoadSearchXml(arrXml[3]);
              sheetObj.RemoveEtcData();
            
              saveXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null; arrXml[3]=null;           
              
 /*             
              sheetObj.LoadSaveXml(saveXml, true);
              var sxml0 = sheetObj.EtcData("sxml0");
			  var sxml1 = sheetObj.EtcData("sxml1");
			  var sxml2 = sheetObj.EtcData("sxml2");
			  var sxml3 = sheetObj.EtcData("sxml3");
              sheetObj.RemoveEtcData();
              sheetObjects[2].LoadSearchXml(sxml0);
              sheetObjects[8].LoadSearchXml(sxml1);
              sheetObjects[10].LoadSearchXml(sxml2);
              sheetObjects[4].LoadSearchXml(sxml3);
              sxml0=null; sxml1 =null; sxml2 =null; sxml3 =null;
*/              
              auto_bound();
              break;

          case IBDELETE:       // TES_TML_SO_DTL, TES_TML_SO_RVIS_LIST, TES_N3RD_PTY_IF, TES_TML_SO_BB_DTL 데이타 삭제
              formObj.f_cmd.value = REMOVE02;
              var param = sheetObj.GetSaveString(false,false);
              var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", param + '&' + tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
              var arrXml = saveXml.split("|$$|");
              sheetObj.LoadSearchXml(arrXml[0]);
              sheetObjects[2].LoadSearchXml(arrXml[0]);
              sheetObjects[8].LoadSearchXml(arrXml[1]);
              sheetObjects[10].LoadSearchXml(arrXml[2]);
              sheetObjects[4].LoadSearchXml(arrXml[3]);
              sheetObj.RemoveEtcData();
            
              saveXml=null; arrXml[0]=null; arrXml[1]=null; arrXml[2]=null; arrXml[3]=null;  
              afterSearchSheet3(sheetObjects[2]);
 /*             
              sheetObj.LoadSaveXml(saveXml, true);
              var sxml0 = sheetObj.EtcData("sxml0");
              var sxml1 = sheetObj.EtcData("sxml1");
			  var sxml2 = sheetObj.EtcData("sxml2");
			  var sxml3 = sheetObj.EtcData("sxml3");
              sheetObj.RemoveEtcData();
              sheetObjects[2].LoadSearchXml(sxml0);
              sheetObjects[8].LoadSearchXml(sxml1);
              sheetObjects[10].LoadSearchXml(sxml2);
              sheetObjects[4].LoadSearchXml(sxml3);
              sxml0=null; sxml1 =null; sxml2 =null; sxml3 =null;
*/              
              break;
        }
    }

    /** n3rd hidden
     * 
     * @param sheetObj		sheet object
     * @param formObj		froom object
     * @param sAction		Action value
     * @return
     */
    function doActionN3rdHidden(sheetObj,formObj,sAction) {//alert("start doActionN3rdHidden");
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSAVE:
              formObj.f_cmd.value = MODIFY04;
//              var param = sheetObj.GetSaveString(false,false,'n3pty_chk');
              var saveXml = sheetObj.GetSaveXml("ESD_TES_0001GS.do", tesFrmQryStr(formObj,'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
              sheetObj.LoadSaveXml(saveXml, true);
              break;
        }
    }
//================================== doActionIBSheet 모음 끝 ===================================
/**
 *  자동 바운드
 */
function auto_bound(){//alert("start auto_bound");
    var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value+io_hidden+document.form.call_yd_ind_seq.Code+document.form.clpt_ind_seq.value);

	var screen_vvd = document.form.vvd.value.substr(0,8);
	var screen_vvd2 = document.form.vvd.value.substr(8,1);
	var screen_vvd3 = "";
	if(screen_vvd2 == "E"){
	    screen_vvd3 = screen_vvd+"W";
	}else if(screen_vvd2 == "W"){
	    screen_vvd3 = screen_vvd+"E";
	}else if(screen_vvd2 == "S"){
	    screen_vvd3 = screen_vvd+"N";
	}else if(screen_vvd2 == "N"){
	    screen_vvd3 = screen_vvd+"S";
	}
	
	
	var vvd_cnt = 0;
	for(var i = 1; i<=sheetObjects[4].RowCount; i++){
	    if(screen_vvd3 == sheetObjects[4].CellValue(i, 'vvd').substr(0,9)){
	        vvd_cnt++;
	    }
	}
	//alert("vvd_cnt:"+vvd_cnt);
	if(vvd_cnt == 0){            
		if(sheetObjects[2].RowCount > 0 && (sheetObjects[4].CellValue(vvd_row, 'vvd_vsl_cd')).substr(0,4) != 'CNTC'){
              var arr_manual_lgs_cost_cd = document.form.manual_lgs_cost_cd.value.split('--');
              var cnt = 0;
              document.form.bound_lgs_cost_cd.value = "";
              for(var i = sheetObjects[2].HeaderRows; i<sheetObjects[2].HeaderRows + sheetObjects[2].RowCount; i++){
            	  	if(sheetObjects[2].CellValue(i,'calc_tp_cd') == 'M'){
                         if(document.form.bound_lgs_cost_cd.value == ""){
                             document.form.bound_lgs_cost_cd.value = sheetObjects[2].CellValue(i,'lgs_cost_cd');
                         }else{
                             document.form.bound_lgs_cost_cd.value = document.form.bound_lgs_cost_cd.value+"','"+sheetObjects[2].CellValue(i,'lgs_cost_cd');
                         }
                          for(var j =0; j < arr_manual_lgs_cost_cd.length; j++){
                               if(arr_manual_lgs_cost_cd[j] == sheetObjects[2].CellValue(i,'lgs_cost_cd')){//alert(sheetObjects[2].CellValue(i,'lgs_cost_cd'));
                               		if(sheetObjects[2].CellValue(i,'lgs_cost_cd') == 'SVALFL' ||
                                       sheetObjects[2].CellValue(i,'lgs_cost_cd') == 'SVOSOT' ||
                                       sheetObjects[2].CellValue(i,'lgs_cost_cd') == 'SVTLLS' 
                                       ){
                                        cnt = cnt + 1;
                                    }
                               }
                               
                          }
                                
                     }
              }
//alert("cnt==>"+cnt);              
              if(cnt > 0){
                  doActionVVDHidden(sheetObjects[11],document.form,IBSEARCH_ASYNC02);
                   return false;
              }
                        
         }
     }else{
         return false;
     }
    
}

/**
* @param     : str	=> 날짜
* sample	: get_Year("2003-01-01"); get_Year("20030101");
* @return 	: 년도
* 설명		: str에서 연도를 구함
**/
function get_Year(str)
{
	//str = delete_Char(str,'-');
	//str = trim(str);
	return (str.substr(0, 4));
}

/**
* @param     : str	=> 날짜
* sample	: get_Month("2003-01-01"); get_Month("20030101");
* @return 	: 월
* 설명		: str에서 월을 구함
**/
function get_Month(str)
{
	//str = delete_Char(str,'-');
	//str = trim(str);
	return (str.substr(4, 2));
}

/** 
 *  MGSet input popup 
 * 
 * @param {ibsheet}	sheetObj	IBsheet object
 * @param {String}	Row			셀의 row Index
 * @param {String}	Col			셀의 col Index
 * @param {long}	CellX
 * @param {long}	CellY
 * @param {long}	CellW
 * @param {long}	CellH
 * @return
 */
function t3sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	 //MGSet input popup 띄운다
	// CHM-201432352 [TESLEA] 철도운송 RF 화물 Genset 관련 Cost Code 생성 (TMRFGR) 추가 - 4347-10-13
	 if ( sheetObj.CellValue(Row,'tml_so_dtl_seq').trim() !='' && ( sheetObj.CellValue(Row,'lgs_cost_cd').trim() == 'TMRFGO' || sheetObj.CellValue(Row,'lgs_cost_cd').trim() == 'TMRFGR' ) ) {            	
    	if(sheetObj.CellValue(Row,'lgs_cost_cd').trim() == sheetObj.CellSearchValue(Row,'lgs_cost_cd2').trim()){
    		openMGSet(Row);
    	}else{
    		ComShowMessage("Please Double Click After Save Setting Values");
    	}
    }
}

/** 
 * Mgset open 
 *
 * @param {String}	row
 * @return
 */
function openMGSet(row){
	var tml_so_ofc_cty_cd = ComGetObjValue(document.form.tml_so_ofc_cty_cd);
	var tml_so_seq = ComGetObjValue(document.form.tml_so_seq);
	var tml_so_dtl_seq = sheetObjects[2].CellValue(row,'tml_so_dtl_seq');
	var curr_cd = document.form.curr_cd.Code;
	var yd_cd = ComGetObjValue(document.form.yd_cd);
	
	var url_str = 'ESD_TES_1004Popup.screen?tml_so_ofc_cty_cd='+tml_so_ofc_cty_cd+'&tml_so_seq='+tml_so_seq+'&tml_so_dtl_seq='+tml_so_dtl_seq+"&curr_cd="+curr_cd+"&yd_cd="+yd_cd;
	window.showModalDialog(url_str, window,"dialogWidth:800px; dialogHeight:440px; help:no; status:no; resizable:yes;");	
}
 
/**
 * 2011-03-11 : [CHM-201109193-01] 
 * Issue DT와 User Office의 Local Sysdate와의 유효성 체크
 * 입력받은 Issue DT가 Storage Invoice Creation화면이 loadPage될 때의 
 * User Office의 Sysdate보다 크면 false 그렇지 않으면 true
 * @return
 */
function isValIssSys(obj){
	if (ofc_cd !=null && ofc_cd == "SELTBB"){	//그룹사 조직 코드 변경 SELTOB->SELTBB (2015-08-03)
		return true;
	}
	
	var str_tgtDt = obj.value.replace(/-/gi,'');
	var str_sysDt = new String(db_date).substring(0,8);
	
	if (isNaN(str_tgtDt) || isNaN(str_sysDt) || str_tgtDt.trim().length!=8 || str_sysDt.trim().length!=8) {
		ComShowMessage(ComGetMsg('TES23011')); //ComShowMessage('날짜 형식이 잘못되었습니다.');
		return false;
	}
	
	if (parseInt(str_tgtDt,10) - parseInt(str_sysDt,10) > 0){
		if (obj.name == 'iss_dt'){
			ComShowMessage('Issued DT error.');
		} else if (obj.name == 'rcv_dt'){
			ComShowMessage('Received DT error.');
		}
		return false;
	}
	return true;
} 
 
/**  
 * 문자열을 구분자 "|" 로 배열을 반환
 * @param {string}	strEleNums	
 * @return
 */
function setEleNums(strEleNums){
	var eleNums = new Array();
	eleNums = strEleNums.split("|");
	return eleNums;	
}
 
function afterSearchSheet3(sheet3){
	var headCnt = sheet3.HeaderRows;
	var Row = sheet3.RowCount;
	for(var i=headCnt; i<=sheet3.LastRow; i++){
		if(sheet3.CellValue(i, "bkg_no") != ""){	
			sheet3.CellEditable(i,"lgs_cost_cd") = false;
			sheet3.CellEditable(i,"inv_xch_rt") = false;
			sheet3.CellEditable(i,"ctrt_rt") = false;
			sheet3.CellEditable(i,"inv_amt") = false;
			sheet3.CellEditable(i,"rvis_vol_qty") = false;
		}
	}	
} 


/**
 * 
 * @param sheetObj
 */
function setCostCode(sheetObj){
	 
	if (sheetObj.CheckedRows("sel") < 1) {
		return;
	}
	var vvd_hidden     = sheetObjects[4];
	var vvd_row = sheetObjects[4].FindText('vvd', document.form.vvd.value+io_hidden+document.form.call_yd_ind_seq.Code+document.form.clpt_ind_seq.value);
	var targetSheetObj = sheetObjectsMap['t3sheet1']; 
	var idx;
	for( var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount ; i++){
		if( !sheetObj.CellValue(i,"sel")) continue;
		idx = targetSheetObj.DataInsert(-1);
		
		targetSheetObj.CellValue2(idx,"calc_tp_cd")      =  sheetObj.CellValue(i,"calc_tp_cd");       
		targetSheetObj.CellValue2(idx,"lgs_cost_cd")     =  sheetObj.CellValue(i,"lgs_cost_cd");      
		targetSheetObj.CellValue2(idx,"cntr_tpsz_cd")    =  sheetObj.CellValue(i,"cntr_tpsz_cd");     
		targetSheetObj.CellValue2(idx,"io_bnd_cd")       =  document.form.io_bnd_cd.value;        
		targetSheetObj.CellValue2(idx,"dcgo_ind_cd")     =  sheetObj.CellValue(i,"dcgo_ind_cd"); 

		// 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)
		targetSheetObj.CellValue2(idx, "tml_agmt_ofc_cty_cd")	= sheetObj.CellValue(i, "tml_agmt_ofc_cty_cd");      
		targetSheetObj.CellValue2(idx, "tml_agmt_seq")			= sheetObj.CellValue(i, "tml_agmt_seq");      
		targetSheetObj.CellValue2(idx, "tml_agmt_ver_no")		= sheetObj.CellValue(i, "tml_agmt_ver_no");      
		
 
		if((sheetObj.CellValue(i,"dcgo_ind_cd"))=='ALL'){
			sheetObj.CellValue(i,"dcgo_ind_cd")='';
			targetSheetObj.CellValue2(idx,"dcgo_ind_cd")     =  sheetObj.CellValue(i,"dcgo_ind_cd");
		}

		targetSheetObj.CellValue2(idx,"rc_flg")          		=  sheetObj.CellValue(i,"rc_flg");           
		targetSheetObj.CellValue2(idx,"tml_wrk_dy_cd")   =  sheetObj.CellValue(i,"tml_wrk_dy_cd");
    	
    	
//     ,DECODE(A.IOC_CD, 'I','IPC','S','Same','O','OCN') AS ioc_cd /* IPC */
//     ,DECODE(A.TML_TRNS_MOD_CD,'V','Mother','R','Rail','T','Truck','B','Barge','O','Other','S','Same','F','Feeder') AS tml_trns_mod_cd /* Mode */
		if(sheetObj.CellValue(i,"ioc_cd")=='Same'){
			sheetObj.CellValue(i,"ioc_cd")='S';  
		}else if(sheetObj.CellValue(i,"ioc_cd")=='IPC'){
			sheetObj.CellValue(i,"ioc_cd")='I';  
		}else if(sheetObj.CellValue(i,"ioc_cd")=='OCN'){
			sheetObj.CellValue(i,"ioc_cd")='O';  
		}
		targetSheetObj.CellValue2(idx,"ioc_cd")          =  sheetObj.CellValue(i,"ioc_cd");  
     
		if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Mother'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='V';  
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Rail'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='R';  
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Truck'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='T';  
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Barge'){
    		sheetObj.CellValue(i,"tml_trns_mod_cd")='B';  
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Other'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='O';  
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Same'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='S';  
		}else if(sheetObj.CellValue(i,"tml_trns_mod_cd")=='Feeder'){
			sheetObj.CellValue(i,"tml_trns_mod_cd")='F';  
		}     
		
		if(sheetObj.CellValue(i,"lane_cd")=='Sam'){
			sheetObj.CellValue(i,"lane_cd")='';  
		}
		
		targetSheetObj.CellValue2(idx,"tml_trns_mod_cd") =  sheetObj.CellValue(i,"tml_trns_mod_cd"); 
		targetSheetObj.CellValue2(idx,"lane_cd")         =  sheetObj.CellValue(i,"lane_cd");          
		targetSheetObj.CellValue2(idx,"tier")            =  sheetObj.CellValue(i,"tier");             
		targetSheetObj.CellValue2(idx,"calc_vol_qty")    =  sheetObj.CellValue(i,"calc_vol_qty");     
		targetSheetObj.CellValue2(idx,"rvis_vol_qty")    =  sheetObj.CellValue(i,"rvis_vol_qty");     
		targetSheetObj.CellValue2(idx,"stay_days")       =  sheetObj.CellValue(i,"stay_days");        
		targetSheetObj.CellValue2(idx,"vol_tr_ut_cd")    =  sheetObj.CellValue(i,"vol_tr_ut_cd");     
		targetSheetObj.CellValue2(idx,"ctrt_rt")         =  sheetObj.CellValue(i,"ctrt_rt");          
		targetSheetObj.CellValue2(idx,"inv_amt")         =  sheetObj.CellValue(i,"inv_amt");          
		targetSheetObj.CellValue2(idx,"curr_cd")         =  sheetObj.CellValue(i,"curr_cd");  
		
		targetSheetObj.CellValue2(idx,'calc_cost_grp_cd') = 'TM';
		targetSheetObj.CellValue2(idx,'inv_xch_rt')       = sheetObj.CellValue(i,"inv_xch_rt");
		targetSheetObj.CellValue2(idx,'vsl_cd')           = vvd_hidden.CellValue(vvd_row, 'vvd_vsl_cd');
		targetSheetObj.CellValue2(idx,'skd_voy_no')       = vvd_hidden.CellValue(vvd_row, 'vvd_skd_voy_no');
		targetSheetObj.CellValue2(idx,'skd_dir_cd')       = vvd_hidden.CellValue(vvd_row, 'vvd_skd_dir_cd');
		targetSheetObj.CellValue2(idx,'atb_dt')           = vvd_hidden.CellValue(vvd_row, 'vvd_atb_dt');
		targetSheetObj.CellValue2(idx,'tml_crr_cd') 	  = '';
		targetSheetObj.CellValue2(idx,'semi_auto_calc_flg') = 'Y';
		
		targetSheetObj.CellValue2(idx,"vol_rt_chk_flg")   =  sheetObj.CellValue(i,"vol_rt_chk_flg");  
		targetSheetObj.CellValue2(idx,"vol_dup_chk_flg")  =  sheetObj.CellValue(i,"vol_dup_chk_flg");  
		targetSheetObj.CellValue2(idx,"rmk_chk_flg")  =  sheetObj.CellValue(i,"rmk_chk_flg");  
		
		setShtCellsEditable(targetSheetObj,idx,'lgs_cost_cd|cntr_tpsz_cd|dcgo_ind_cd|tml_wrk_dy_cd|ioc_cd|tml_trns_mod_cd|lane_cd|vol_tr_ut_cd|ctrt_rt|calc_vol_qty|inv_xch_rt|inv_amt|rc_flg','Y');
		setShtCellsEditable( targetSheetObj, idx, 'cntr_tpsz_cd|rvis_vol_qty|rf_mntr_dys', 'Y', 'EXCEPTION');
    }
} 

//[CHM-201430578] Invoice의 Volume과 Rate의 필수 입력 여부 값 세팅 - 2015.01.19 <Start>
function checkValidForVolRate(costCd, row) {
	
	if(costCd != null && costCd != '') {
		document.form.param_lgs_cost_cd.value = costCd;
		tes_getInputValue('vol_rt_chk_flg', SEARCH22, 'param_lgs_cost_cd','setVolRate');
	}
	
	document.form.cost_row.value = row;
}


function setVolRate() {	
	if(document.form.vol_rt_chk_flg.value != null && document.form.vol_rt_chk_flg.value != '') {
		var tmpInfo = document.form.vol_rt_chk_flg.value;
		var tmp = tmpInfo.split("|");
		
		sheetObjects[2].CellValue(document.form.cost_row.value, 'vol_rt_chk_flg') = tmp[0];
		sheetObjects[2].CellValue(document.form.cost_row.value, 'vol_dup_chk_flg') = tmp[1];
	}
}


function isValidForVolRate(calcVol, rvisVol, ctrtRt) {
	if((calcVol = null || calcVol == 0 || calcVol == '')
		&& (rvisVol == null || rvisVol == 0 || rvisVol == '')) {
		return false;
	} else if(ctrtRt == null || ctrtRt == 0.00 || ctrtRt == '') {
		return false;
	} else {
		return true;
	}
}

//[CHM-201430578] Invoice의 Volume과 Rate의 필수 입력 여부 값 세팅 - 2015.01.19 
//동일한 cost code를 중복 입력하는 경우, 적어도 한개의 row에 대해서는 Vol 과 Rate만 mandatory(필수입력)
function costCodeDupCheck() {
	var sheetObject2 = sheetObjects[2];
	var dupRowCount	= 0;
	var dupRowCount2 = 0;
	
	var dupRowInfo = sheetObject2.ColValueDupRows("lgs_cost_cd|vol_tr_ut_cd|cntr_tpsz_cd",false,true);

	if(dupRowInfo != ""){
		
		var dupRow = dupRowInfo.split("|");
		var dupRowNum1 = dupRow[0].split(",");	//기준행
		var dupRowNum2 = dupRow[1].split(",");	//반복행
		
		for(var i = 0 ; i < dupRowNum1.length ; i++){
			
			if(sheetObject2.CellValue(dupRowNum1[i],"vol_dup_chk_flg") == 'Y'){	//중복허용
				
				var calcVol = sheetObject2.CellValue(dupRowNum1[i],"calc_vol_qty");
				var rvisVol = sheetObject2.CellValue(dupRowNum1[i],"rvis_vol_qty");
				var ctrtRt = sheetObject2.CellValue(dupRowNum1[i],"ctrt_rt");
				
				if(isValidForVolRate(calcVol, rvisVol, ctrtRt) == false){
					for(var j = 0 ; j < dupRowNum2.length ; j++){
						if(sheetObject2.CellValue(dupRowNum1[i],"lgs_cost_cd") == sheetObject2.CellValue(dupRowNum2[j],"lgs_cost_cd")
								&& sheetObject2.CellValue(dupRowNum1[i],"vol_tr_ut_cd") == sheetObject2.CellValue(dupRowNum2[j],"vol_tr_ut_cd")
								&& sheetObject2.CellValue(dupRowNum1[i],"cntr_tpsz_cd") == sheetObject2.CellValue(dupRowNum2[j],"cntr_tpsz_cd")){
							
							var calcVol2 = sheetObject2.CellValue(dupRowNum2[j],"calc_vol_qty");
							var rvisVol2 = sheetObject2.CellValue(dupRowNum2[j],"rvis_vol_qty");
							var ctrtRt2 = sheetObject2.CellValue(dupRowNum2[j],"ctrt_rt");
							
							if(isValidForVolRate(calcVol2, rvisVol2, ctrtRt2)){
								dupRowCount2++;
							}
						}					
					}
					
					if(dupRowCount2 > 0){	//한건이라도 값이 있으면 		
						dupRowCount = 0;
					} else {	//한건도 값이 없으면			
						dupRowCount++;
					}
				}
			}
		}
		
		if(dupRowCount > 0){
			return false;
		} else {
			for(var i = 0 ; i < dupRowNum1.length ; i++){
				sheetObject2.CellValue(dupRowNum1[i],"vol_rt_chk_flg") = "N";	
			}			
			for(var j = 0 ; j < dupRowNum2.length ; j++){	
				sheetObject2.CellValue(dupRowNum2[j],"vol_rt_chk_flg") = "N";	//반복행에 값이 있으면 true	
			}			
			return true;
		}	
	} else {	//중복되는 행이 없으면 true
		return true;
	}
}

//[CHM-201534782]Cost calculation tab에서 Save시 R/H Volume Adjustment 화면 자동 Open - 2015.04.09
function openRhVolumeAdj(){
	var sheetObj = sheetObjects[2];
	var formObj = document.form;
	
	if(sheetObj.RowCount > 0){
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			
			formObj.temp_lgs_cost_cd.value = sheetObj.CellValue(i,"lgs_cost_cd");
			doActionRvisHidden(sheetObjects[8], formObj, IBSEARCH);
			var divCDValue = sheetObjects[8].EtcData("etcxml");

			if ((sheetObj.CellValue(i,"lgs_cost_cd")=="SVRHCC" || sheetObj.CellValue(i,"lgs_cost_cd")=="SVRHCD") && rvisVolCnt(sheetObj, i, divCDValue) < 1){

				var url_str = "ESD_TES_9035.screen";
			     url_str += "?tml_so_ofc_cty_cd=" +formObj.tml_so_ofc_cty_cd.value;
			     url_str += "&tml_so_seq="   +formObj.tml_so_seq.value;
			     url_str += "&tml_so_dtl_seq="  +sheetObj.CellValue(i,"tml_so_dtl_seq");
			     url_str += "&vndr_seq="    +formObj.vndr_seq.value;
			     url_str += "&yd_cd="    +formObj.yd_cd.value;
			     url_str += "&yd_nm="    +formObj.yd_nm.value;
			     url_str += "&vvd="        +formObj.vvd.value;
			     url_str += "&lgs_cost_cd="   +sheetObj.CellValue(i,"lgs_cost_cd");
			     url_str += "&cntr_tpsz_cd="   +sheetObj.CellValue(i,"cntr_tpsz_cd");
			     url_str += "&io_bnd_cd="   +sheetObj.CellValue(i,"io_bnd_cd");
			     url_str += "&dcgo_ind_cd="   +sheetObj.CellValue(i,"dcgo_ind_cd");
			     url_str += "&ioc_cd="    +sheetObj.CellValue(i,"ioc_cd");
			     url_str += "&lane_cd="    +sheetObj.CellValue(i,"lane_cd");
			     url_str += "&tml_wrk_dy_cd="  +sheetObj.CellValue(i,"tml_wrk_dy_cd");
			     url_str += "&tml_trns_mod_cd="  +sheetObj.CellValue(i,"tml_trns_mod_cd");
			     url_str += "&cal_vol="    +sheetObj.CellValue(i,"calc_vol_qty");
			     url_str += "&fm_tr_vol_val="  +sheetObj.CellValue(i,"fm_tr_vol_val");
			     url_str += "&to_tr_vol_val="  +sheetObj.CellValue(i,"to_tr_vol_val");
			     url_str += "&rvis_div="    +divCDValue;
			     url_str += "&rvis_vol_qty="   +sheetObj.CellValue(i,"rvis_vol_qty");
			     url_str += "&calc_tp_cd="            +sheetObj.CellValue(i,"calc_tp_cd");
			     url_str += "&opener_row="   +i;
			     url_str += "&tml_so_dtl_seq="       +sheetObj.CellValue(i,"tml_so_dtl_seq");
			     url_str += "&ctrt_rt="              +sheetObj.CellValue(i,"ctrt_rt");
			     url_str += "&page_rows="            +sheetObj.CellValue(i,"page_rows");
			     url_str += "&tml_crr_cd="           +sheetObj.CellValue(i,"tml_crr_cd");
			     url_str += "&edi_so_dtl_id="        +sheetObj.CellValue(i,"edi_so_dtl_id"); 
			     url_str += "&atb_dt="    +formObj.atb_dt.value;
			     url_str += "&edi_flg="    +formObj.edi_flg.value;
			     url_str += "&rf_mntr_dys="   +sheetObj.CellValue(i,"rf_mntr_dys");  
			     
			     ComOpenPopup(url_str,   900,    600,     "",  "1,0,1,1,1,1,1", true);	
			     break;
			}
		}		
	}		
}

function retrieveCalTab(){
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[5].RemoveAll();
	sheetObjects[8].RemoveAll();
	sheetObjects[10].RemoveAll();
	doActionIBSheet1(sheetObjects[0], document.form, IBSEARCH);
}


function checkLoginOfc(){	
	var formObj = document.form;
	
	if(formObj.chk_ofc_cd.value == "N"){
		if(ComShowConfirm(ComGetMsg('TES21053'))){  
			formObj.vndr_seq.focus();
			return;
		} else {
			ComShowMessage(ComGetMsg('TES21054'));
			setInitComponent('N');
			
			ComEnableObject(formObj.vndr_seq, false);
			ComEnableObject(formObj.inv_no, false);
			formObj.vndr_seq.readOnly = true;
			formObj.inv_no.readOnly = true;

			return false;
		}
	} else {
		formObj.vndr_seq.focus();
	}
}