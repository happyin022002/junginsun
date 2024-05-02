/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2001.js
*@FileTitle : Guarantee Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
* 2012.02.03 박성호 [CHM-201215762] [TES] US Irregular/Guarantee 보완 사항 구현
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author SM LINE
	 */
	
	/**
	 * @extends 
	 * @class ESD_TES_2001 : ESD_TES_2001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_TES_2001() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var	comboVal;

/**
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 */
document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 **/
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];	// Container List Sheet.
		var sheetObject2 = sheetObjects[1];	// Header Info Hidden Sheet.
	
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					
					if ( ComIsNull( formObject.gnte_no.value ) ) {
						ComShowCodeMessage('TES70101');    // Please enter Reference Number.
						formObject.gnte_no.focus();
						return false;
					}
					
					// 12자리 체크
					if ( formObject.gnte_no.value.length != 12 ) {
						ComShowCodeMessage('TES70109');    // Please check length Guarantee No.
						formObject.gnte_no.focus();
						return false;
					}
					
					// CUST_CD 자리수 체크
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
					break;
	
				case "btn_new":
					initFormHdr();		// Header Form Init.
					initFormCntrList();	// Container List Sheet Init.
					
					document.getElementById("gnte_no").focus();
					break; 
	
				case "btn_save":
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}
					
					/* Header Info */
					if (!ComIsNull(sheetObject2.CellValue(1, "ofc_cd") ) && 
						sheetObject2.CellValue(1, "ofc_cd") != document.getElementById("cre_ofc_cd").value	
					) {
						ComShowCodeMessage('TES70121');    // No authority to correct/delete the Guarantee - Creation office mismatch!
						return false;
					}
					
					if (ComIsNull( formObject.gnte_cust_cd.value ) || 
						ComIsNull( formObject.gnte_cust_cd_hidden.value ) ||
						formObject.gnte_cust_cd.value != formObject.gnte_cust_cd_hidden.value ) {
						ComShowCodeMessage('TES70102');    // Please enter Customer Code.
						formObject.gnte_cust_cd.focus();
						return false;
					}
					
					//20100618 CUST_CD 유효성 체크
					if(formObject.gnte_cust_cd.value.length==8){
						if(ComIsAlphabet(formObject.gnte_cust_cd.value.substring(0,2))==false){
							ComShowCodeMessage('TES70111');
							return false;
						}
						
						if(ComIsNumber(formObject.gnte_cust_cd.value.substring(2,8))==false){
							ComShowCodeMessage('TES70111');
							return false;
						}
						
					}

					if (ComIsNull( formObject.vndr_seq.value ) || 
						ComIsNull( formObject.vndr_seq_hidden.value ) ||
						formObject.vndr_seq.value != formObject.vndr_seq_hidden.value ) {
						ComShowCodeMessage('TES10011');    // Please enter Service Provider Code.
						formObject.vndr_seq.focus();
						return false;
					}
					
//					if ( ComIsNull( document.getElementById("dept_no").value ) ) {
//						ComShowCodeMessage('TES70603');    // This is invalid Depart.
//						return false;
//					}

					/* Container List */
					for ( var i = sheetObject1.HeaderRows; i < sheetObject1.HeaderRows + sheetObject1.RowCount; i++ ) {
						if (ComIsNull( sheetObject1.CellValue(i , "cntr_no") ) ) {
							ComShowCodeMessage('TES70104');    // Please enter Container No.
							return false;
						}
						
						// 저장시 Container No. & Bkg No. Duplication Check.
						if ( !checkDupCntrNo( sheetObject1, i) ) {
							return false;
						}
						
						// Storage 인 경우 날짜입력 Check. 아니면 초기화.(Inquiry 에서 보여짐)
						if ( formObject.gnte_tp_cd.value == "ST" ) {
							if ( ComIsNull( sheetObject1.CellValue(i , "fm_dt") ) ) {
								ComShowCodeMessage('TES70106');		// Please enter Container List start date.
								return false;
							}
							
							if ( ComIsNull( sheetObject1.CellValue(i , "to_dt") ) ) {
								ComShowCodeMessage('TES70107');		// Please enter Container List end date.
								return false;
							}
							
							if ( ComGetDaysBetween(sheetObject1.CellValue(i , "fm_dt"), sheetObject1.CellValue(i , "to_dt")) < 0 ) {
								ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
								sheetObject1.CellValue2(i , "to_dt") = "";
								return false;
							}
							
						} else {
							sheetObject1.CellValue2(i , "fm_dt") = "";
							sheetObject1.CellValue2(i , "to_dt") = "";
						}
						
						if ( ComIsNull( sheetObject1.CellValue(i , "gnte_amt") ) ) {
							ComShowCodeMessage('TES70105');    // Please enter Amount.
							return false;
						}
						
						if (isNaN(sheetObject1.CellValue(i, 'gnte_amt')) || sheetObject1.CellValue(i, 'gnte_amt') <= 0) {
							ComShowCodeMessage('TES60102'); 	//Amount should be greater than 0.
							return false;
						}
					}

					// Reference Number(Guarantee No.) 가 조회된 값이 없고 regflag 'Y' 이면 저장.
					if ( ComIsNull( document.getElementById("gnte_no").value ) ) {
						formObject.f_cmd.value = ADD;
						
						if (sheetObject1.RowCount == 1){
							document.getElementById("gnte_cust_cd_tmp").value = document.form.gnte_cust_cd.value;
							document.getElementById("vndr_seq_tmp").value	  = document.form.vndr_seq.value;
							document.getElementById("gnte_tp_cd_tmp").value	  = document.form.gnte_tp_cd.value;
							document.getElementById("bkg_no_tmp").value	      = sheetObject1.CellValue(1, "bkg_no");
							document.getElementById("cntr_no_tmp").value	  = sheetObject1.CellValue(1, "cntr_no");
							
							var tmp = '';
							tmp = (document.getElementById("cntr_no_tmp").value + document.getElementById("bkg_no_tmp").value);
							document.form.all_tmp.value = tmp;
							tes_getInputValueGuarantee('is_valid_cntr_info2', SEARCH10, 'gnte_cust_cd_tmp|vndr_seq_tmp|gnte_tp_cd_tmp|all_tmp', 'checkValidCntrInfo3');
							
						} else if (sheetObject1.RowCount > 1){
							var tmp = '';
							for(var i = 1; i < sheetObject1.RowCount+1; i++ ) {
								tmp += ((tmp!=null&&tmp!=''?':':'') + sheetObject1.CellValue(i, "cntr_no") + sheetObject1.CellValue(i, "bkg_no"));
							}
							document.form.all_tmp.value = tmp;
							tes_getInputValueGuarantee('is_valid_cntr_info2', SEARCH10, 'gnte_cust_cd_tmp|vndr_seq_tmp|gnte_tp_cd_tmp|all_tmp', 'checkValidCntrInfo3');
						}
						
					// Reference Number(Guarantee No.) 가 조회된 값과 같으면 Update.
					} else if ( !ComIsNull( document.getElementById("gnte_no").value ) &&
						formObject.gnte_no.value == sheetObject2.CellValue(1, "gnte_no") ) {
						formObject.f_cmd.value = MODIFY;
						document.getElementById("gnte_cust_cd_tmp").value = document.form.gnte_cust_cd.value;
						document.getElementById("vndr_seq_tmp").value	  = document.form.vndr_seq.value;
						var tmp = '';
						for(var i = 1; i < sheetObject1.RowCount+1; i++ ) {
							tmp += ((tmp!=null&&tmp!=''?':':'') + sheetObject1.CellValue(i, "cntr_no") + sheetObject1.CellValue(i, "bkg_no"));
						}
						document.form.all_tmp.value = tmp;
						tes_getInputValueGuarantee('is_valid_cntr_info2', SEARCH10, 'gnte_cust_cd_tmp|vndr_seq_tmp|gnte_tp_cd_tmp|all_tmp', 'checkValidCntrInfo3');
					}
					
					break;

				case "btn_irregular":
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}

					if ( document.getElementById("gnte_tp_cd").value != sheetObject2.CellValue(1, "gnte_tp_cd") ) {
						ComShowCodeMessage('TES70112');   // Save Guarantee before proceeding.
						return false;
					}

					// Irregular Popup 
	            	if (sheetObject1.CheckedRows('chk') < 1){
	            		ComShowCodeMessage('TES21009'); // 선택된 데이터가 없습니다.
	            		return false;
	            	}

					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; 
					var classId = "ESD_TES_2006";
					var param	= "?";
					var chkStr	= dispaly.substring(0,3)
					var	cntr_seq= "";
					
					iCheckRow = sheetObject1.FindCheckedRow('chk');
				    var arrRow = iCheckRow.split("|");
					if (iCheckRow != null && arrRow.length > 1)	{

						
						for(var i = 0; i < arrRow.length - 1; i++ ) {
							if (sheetObject1.CellValue(arrRow[i], "tml_gnte_cntr_list_seq") == null || 
								sheetObject1.CellValue(arrRow[i], "tml_gnte_cntr_list_seq") == '' ) {
								ComShowCodeMessage('TES70112');	// 'Save Guarantee before proceeding'
								cntr_seq = "";
								return false;
							} else {
								// Irregular 이 이미 등록되어 있으면 제외시킨다.
								if ( !ComIsNull( sheetObject1.CellValue(arrRow[i], "chk_irr") ) ) {
									ComShowCodeMessage('TES70115');	// Irregular exists already.
									cntr_seq = '';
									return false;
								}
								else if ( !ComIsNull( sheetObject1.CellValue(arrRow[i], "chk_tpb_if") ) ) {
									ComShowCodeMessage('TES70120');	// TPB I/F exists already.
									cntr_seq = '';
									return false;
								} else {
									cntr_seq = cntr_seq + sheetObject1.CellValue(arrRow[i], "tml_gnte_cntr_list_seq") + ",";
								}
							}
						}
						cntr_seq = cntr_seq.substring(0, cntr_seq.length - 1);
					}
					
					param	= param 
							+ 'pgmNo=ESD_TES_2006'
							+ '&gnte_flg=Y'
					 		+ '&gnte_no='	+ document.getElementById("gnte_no").value
							+ '&cntr_seq='	+ cntr_seq
							;
					
					var irregularUrl = "ESD_TES_2006.do" + param;
					location.href = irregularUrl;
					break; 
					
				case "btn_tpbif":
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return false;
					}
					
					// TPB BillingCase Code 존재 여부 확인.
					var	arrBillCase;
					var	isTpbBill	= false;
					comboVal	= tes_tpbBillcaseCodeVal(document.getElementById('n3pty_bil_tp_cd_tmp').value);
					arrBillCase	= comboVal.split("|");
					for( i = 0; arrBillCase != null && i < arrBillCase.length; i++ )  {
						if (arrBillCase[i] != null && arrBillCase[i] != "" && arrBillCase[i] == document.getElementById("gnte_tp_cd").value ) {
							isTpbBill	= true;
							break;
						}
					}
					
					if ( document.getElementById("gnte_tp_cd").value != sheetObject2.CellValue(1, "gnte_tp_cd") ) {
						ComShowCodeMessage('TES70112');   // Save Guarantee before proceeding.
						return false;
					}
					
					if ( isTpbBill == false ) {
						ComShowCodeMessage('TES70802');   // Please check charge type. The charge type is not registered on TPB.
						return false;
					}

					// MODAL 로 변경할것.(4342-12-09)
					// TPB IF Report Designer 출력
					// Irregular Or TPB IF 둘중 하나 생성되어야  Print 가능
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; 
					var classId = "ESD_TES_2008";
					var param = '?classId=' + classId;
					var chkStr = dispaly.substring(0,3)
					var	cntr_seq	= "";
	            	if (sheetObject1.CheckedRows('chk') < 1){
	            		ComShowCodeMessage('TES21009'); // 선택된 데이터가 없습니다.
	            		return false;
	            	}

					iCheckRow = sheetObject1.FindCheckedRow('chk');
				    var arrRow = iCheckRow.split("|");
					if (iCheckRow != null && arrRow.length > 1)	{
						
						for(var i = 0; i < arrRow.length - 1; i++ ) {
							if (sheetObject1.CellValue(arrRow[i], "tml_gnte_cntr_list_seq") == null || 
								sheetObject1.CellValue(arrRow[i], "tml_gnte_cntr_list_seq") == '' ) {
								ComShowCodeMessage('TES70112');	// 'Save Guarantee before proceeding'
								cntr_seq = "";
								return false;
							} else {
								// Irregular 이 이미 등록되어 있으면 제외시킨다.
								if ( !ComIsNull( sheetObject1.CellValue(arrRow[i], "chk_irr") ) ) {
									ComShowCodeMessage('TES70115');	// Irregular exists already.
									cntr_seq = '';
									return false;
								}
								else if ( !ComIsNull( sheetObject1.CellValue(arrRow[i], "chk_tpb_if") ) ) {
									ComShowCodeMessage('TES70120');	// "More than one of CNTR has already been interfaced to TPB. Please check TPB status. \n\n(If you want to delete the data, all of CNTR's TPB status should be Non-TPB.)";
									cntr_seq = '';
									return false;
								}
								else {
									cntr_seq = cntr_seq + sheetObject1.CellValue(arrRow[i], "tml_gnte_cntr_list_seq") + ",";
								}
							}
						}
						cntr_seq = cntr_seq.substring(0, cntr_seq.length - 1);
					}

					param	= param 
							+ 'pgmNo=ESD_TES_2008'
					 		+ '&gnte_no=' + document.getElementById("gnte_no").value
					 		+ '&curr_cd=' + document.getElementById("curr_cd").value
							+ '&cntr_seq=' + cntr_seq
							+ '&irr_no_if_flg=' + "N";
					
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('ESD_TES_2008.do' + param, 500, 370, '', dispaly, true);
						
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;
	
				case "btn_print":
					// Guarantee 생성 내용 Report Designer 출력
					if ( (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount) <= 1 ) {
						ComShowCodeMessage('TES21017'); // 'There is no data.';
						return false;
					}
					else {
							document.form.gnte_no_hidden.value = document.getElementById("gnte_no").value;
							tes_getInputValueGuarantee('is_valid_print', SEARCH06, 'gnte_no_hidden', 'gnteInqPrintChk');
					}
					break;
					
				case "btn_delete":
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}
					
					// Guarantee 내용 모두 삭제
					if (!ComIsNull(sheetObject2.CellValue(1, "ofc_cd") ) && 
						sheetObject2.CellValue(1, "ofc_cd") != document.getElementById("cre_ofc_cd").value	
					) {
						ComShowCodeMessage('TES70121');    // No authority to correct/delete the Guarantee - Creation office mismatch!
						return false;
					}
					
					if ( !ComIsNull( document.getElementById("gnte_no").value ) && 
						ComShowConfirm(ComGetMsg('TES70113') ) ) {
						// checkNonTPB ( 바로삭제 : Y, 삭제가능 : N, 삭제불가 : X, I/F대상없음 : O )
						tes_getInputValueGuarantee('is_valid_TPB', SEARCH03, 'gnte_no', 'checkNonTPB');
					}
					break;

				case "btn_refno":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "ESD_TES_2004";
					var param = '?cre_flg=G&classId='+classId;
					var chkStr = dispaly.substring(0,3)

					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('ESD_TES_2004.do' + param, 300, 350, '', dispaly, true);
						
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;

				case "btn_custcd":
					var dispaly = "1,0,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_041";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)

					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 430, 'getCust', dispaly, true);

					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;

				case "btn_vndr":
                    var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                    var classId = "COM_ENS_0C1";
                    var param = '?classId='+classId;
                    var chkStr = dispaly.substring(0,3);

                    // radio PopUp
                    if(chkStr == "1,0") {
                    	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param,  700, 410, 'getVender', dispaly, true);
                    } else {
                    	ComShowCodeMessage('TES10004'); // There is lack of data for pop-up display.
                    	return;
                    }
                    break;

				case "btng_rowadd":
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}

					var Row = sheetObject1.DataInsert();

					break; 
	
				case "btng_rowdelete":
					
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}

					var	delRow	= "";
					iCheckRow = sheetObject1.FindCheckedRow('chk');
				    var arrChkRow = iCheckRow.split("|");
					if (iCheckRow != null && arrChkRow.length > 1)	{
						for(var i = arrChkRow.length - 1; i >= 0; i-- ) {
							// TPB I/F, Irregular 생성되지 않은것만 삭제 가능.
							var delId	= arrChkRow[i];
							if ( delId != null && delId != "" ) {
								if (ComIsNull( sheetObject1.CellValue(delId, "chk_tpb_if") ) && 
									ComIsNull( sheetObject1.CellValue(delId, "chk_irr") ) ) {
									if ( ComIsNull( sheetObject1.CellValue(delId, "cntr_no") ) ) {
										sheetObject1.RowDelete(delId, false);
									}
									else {
										if ( !ComIsNull( sheetObject1.CellValue(delId, "tml_gnte_cntr_list_seq") ) ) {
											sheetObject1.RowHidden(delId) = true;
										}
										sheetObject1.RowStatus(delId) = "D";
									}
								}
							}
						}
					}

					// Amount 재설정
					document.getElementById("ttl_amt").value = getShtTotAmt(sheetObject1, "gnte_amt" );
					break;
				case "btn_guarantee":
					
					var url_str = 'ESD_TES_2002.do';
					url_str += '?pgmNo=ESD_TES_2002';
					url_str += '&pre_cond_gnte_no='+document.form.pre_cond_gnte_no.value;
					url_str += '&pre_cond_cost_ofc_cd='+document.form.pre_cond_cost_ofc_cd.value;
					url_str += '&pre_cond_cre_usr_id='+document.form.pre_cond_cre_usr_id.value;
					url_str += '&pre_cond_gnte_tp_cd='+document.form.pre_cond_gnte_tp_cd.value;
					url_str += '&pre_cond_fm_cre_dt='+document.form.pre_cond_fm_cre_dt.value;
					url_str += '&pre_cond_to_cre_dt='+document.form.pre_cond_to_cre_dt.value;
					url_str += '&pre_cond_gnte_cust_cd='+document.form.pre_cond_gnte_cust_cd.value;
					url_str += '&pre_cond_vndr_seq='+document.form.pre_cond_vndr_seq.value;
					url_str += '&pre_cond_delt_flg='+document.form.pre_cond_delt_flg.value;
					location.href = url_str;
					
					break; 
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');   //The service is not available now
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * IBSheet Object 를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의. <br>
	 * @param{ibsheet}		sheet_obj		IBSheet Object
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
		}
		// TPB BillingCase Code TES 사용하는것 전체 조회.
		tes_getInputValueInvoice('n3pty_bil_tp_cd_tmp', SEARCH07, '', 'setTpbBillcaseCode');
        // Inquiry, Irregular 에서 넘어온 경우.
        if (document.getElementById("irr_flg").value == "Y" || 
        	document.getElementById("inq_flg").value == "Y" ) {
        	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        } else {
        	initFormHdr();
        }

        document.getElementById("gnte_no").focus();
        
	}
	

	 
    /**
     * 임시 FUnction
     * TPB 에서 가져온 Billing Case 문자열로 콤보를 만들 함수 호출
     * getThirdPartyBillingCaseHorizontally 동작이 끝난 후 호출된다
     * @return
     */
    function setTpbBillcaseCode(){
//   	 tes_tpbBillcaseCode(sheetObjects[0], document.getElementById('n3pty_bil_tp_cd_tmp').value, 'n3pty_bil_tp_cd', '', '', 'getList');
    }

	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * 시트가 다수일 경우 시트 수만큼 case 를 추가하여 시트 초기화모듈을 구성한다
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,String} 	sheetNo		Sheet Object 태그의 아이디에 붙인 일련번호
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init ( Container List )
				with (sheetObj) {

					// 높이 설정
					style.height = 220; //162;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
						       

					var HeadTitle1 = "| |Seq|TPB|IR|Container No.|SZ|BKG No.|BL No.|VVD|SC No.|" +
									"From DT|To DT|Amount|Invoice No.|Bkg No. List|BKG No Org|TML IF OFC|TML IF SEQ|IRR NO";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
	               
	                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		"chk",				false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		"tml_gnte_cntr_list_seq",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"chk_tpb_if",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"chk_irr",			false,		"",				dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"cntr_no",			false,      "",				dfNone,		0,			true,		true,		11);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"cntr_tpsz_cd",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		110,	daCenter,	false,		"bkg_no",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"bl_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"vvd_cd",			false,      "",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"sc_no",			false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"fm_dt",			false,      "",				dfDateYmd,	0,			true,		true,		10);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"to_dt",			false,		"",				dfDateYmd,	0,			true,		true,		10);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"gnte_amt",			false,      "",				dfFloat,	2,			true,		true,		12);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"tpb_inv_no",		false,      "",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"bkg_no_list_ctnt",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"bkg_no2",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"tml_if_ofc_cd",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"tml_if_seq",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"irr_no",			false,		"",				dfNone,		0,			false,		false);

					InitDataCombo(0 , "bkg_no", "", "");

					CountPosition = 0;
					CountFormat = "[SELECTDATAROW / ROWCOUNT]";
					
					
				}
				break;
			case "sheet2":      //sheet2 init ( Header Info )
				with (sheetObj) {

					// 높이 설정
					style.height = 100;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 1, 20);
						       

					var HeadTitle1 = "STS|Ref no|Office|Size|Currency|Yard|Yard Name|Cust Cd|Cust Name|Bkg Sts|Amt|Phone No.|Fax No.|Department|Remark|Del|User|Cre Date";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"gnte_no",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"ofc_cd",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"gnte_tp_cd",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"curr_cd",		false,      "",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"vndr_seq",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"vndr_seq_name",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"gnte_cust_cd",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"gnte_cust_cd_name",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"bkg_sts_cd",	false,      "",				dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"ttl_amt",		false,      "",				dfFloat,	2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"pic_phn_no",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"pic_fax_no",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"dept_no",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"gnte_rmk",		false,      "",				dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"delt_flg",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"cre_usr_id",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"cre_dt",		false,      "",				dfNone,		0,			false,		false);
					
					CountPosition = 0;
					
				}
				break;	
		}
	}

	
	/**
	 * IBSheet ( Header ) 관련 프로세스 처리.<br>
	 * 
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {Object}		formObj		Form Object
	 * @param {String}		sAction		Action Command
	 */
	function doActionIBSheet( sheetObj, formObj, sAction ) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
	    		formObj.f_cmd.value = SEARCH;
    	 		var	sXml	= sheetObj.GetSearchXml("ESD_TES_2001GS.do", tesFrmQryStr(formObj) );
    	 		var arrXml	= sXml.split("|$$|"); 
    	 		
				for (var i = 0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}
				
                sXml	= null;
                arrXml	= null;

				break;
		
			case IBSAVE:        //저장
				var param = sheetObj.GetSaveString();
				var savexml = sheetObjects[1].GetSaveXml("ESD_TES_2001GS.do", tesFrmQryStr(formObj) + '&' + param);
				sheetObjects[1].LoadSaveXml(savexml, true);
				break;
		
			case IBINSERT:      // 입력
				break;
				
			case IBDELETE:      // 입력
				formObj.f_cmd.value = REMOVE;
				var param = sheetObj.GetSaveString();
				var savexml = sheetObj.GetSaveXml("ESD_TES_2001GS.do", tesFrmQryStr(formObj));
				
				doActionIBSheet( sheetObj, formObj, IBSEARCH );

				break;
		}
	}
	
	/**
	 * IBSheet (Container List ) 관련 프로세스 처리.<br>
	 * 
	 * @param {ibsheet}		sheetObj	IBSheet Object
	 * @param {Object}		formObj		Form Object
	 * @param {String}		sAction		Action Command
	 */	
	function doActionIBSheet1( sheetObj, formObj, sAction ) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBSEARCH:      //조회
	    		formObj.f_cmd.value = SEARCH;
    	 		var	sXml = sheetObj.DoSearch4Post("ESD_TES_2001GS.do", tesFrmQryStr(formObj) );
    	 		sheetObj.LoadSearchXml(sXml, false);

				break;
		
			case IBSAVE:        //저장

				formObj.f_cmd.value = MULTI;
				var param = sheetObjects[0].GetSaveString();
				var saveXml = sheetObjects[0].GetSaveXml("ESD_TES_2001GS.do", tesFrmQryStr(formObj) + '&' + param);
    	 		var arrXml	= saveXml.split("|$$|"); 
    	 		
				for (var i = 0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}
				
                sXml	= null;
                arrXml	= null;

				break;
		
			case IBINSERT:      // 입력
				break;
				
			case IBDELETE:      // 삭제
				formObj.f_cmd.value = MULTI;
                var param = sheetObj.GetSaveString();
		        var savexml = sheetObj.GetSaveXml("ESD_TES_2001GS.do", tesFrmQryStr(formObj) + '&' + param );
//				sheetObj.LoadSaveXml(savexml, true);
				break;
		}
	}
	

	
	/**
	 * Reference No 셋팅. <br>
	 * 
	 * @param{Array}		rowArray	rowArray
	 */
	function getRefNo(rowArray) {
		document.all.gnte_no.value	= rowArray[0];
	}
	
	/**
	 * Customer 정보( Code, Name) 셋팅. <br>
	 * 
	 * @param{Array}		rowArray	rowArray
	 */
	function getCust(rowArray) {
		var colArray	= rowArray[0];
		document.all.gnte_cust_cd.value			= colArray[3];
		document.all.gnte_cust_cd_hidden.value	= colArray[3];
		document.all.gnte_cust_cd_name.value	= colArray[4];
	}
	
	
	/**
	 * Vender 정보( Code, Name) 셋팅. <br>
	 * 
	 * @param{Array}		rowArray	rowArray
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		document.all.vndr_seq.value			= colArray[2];
		document.all.vndr_seq_hidden.value	= colArray[2];
		document.all.vndr_seq_name.value	= colArray[4];
	}


	/**
     * Form Object Guarantee Value 초기화<br>
     **/
	function initFormHdr() {
		sheetObjects[1].RemoveAll();
		
		document.getElementById("gnte_no").value	= "";
		document.getElementById("ofc_cd").value		= document.getElementById("cre_ofc_cd").value;
		document.getElementById("delt_flg").value	= "";
		document.getElementById("gnte_tp_cd").value	= "ST";
		document.getElementById("curr_cd").value	= "USD";
		
		document.getElementById("bkg_sts_cd").value				= "F";
		document.getElementById("gnte_cust_cd").value			= "";
		document.getElementById("gnte_cust_cd_name").value		= "";
		document.getElementById("gnte_cust_cd_hidden").value	= "";
		document.getElementById("is_valid_gnte_cust_cd").value	= "";

		document.getElementById("vndr_seq").value			= "";
		document.getElementById("vndr_seq_name").value		= "";
		document.getElementById("vndr_seq_hidden").value	= "";
		document.getElementById("is_valid_vndr_seq").value	= "";
		document.getElementById("ttl_amt").value	= "";

		document.getElementById("gnte_rmk").value	= "";
		document.getElementById("pic_phn_no").value	= "";
		document.getElementById("pic_fax_no").value	= "";
		document.getElementById("dept_no").value	= "";
		
		document.getElementById("gnte_no").readOnly	= false;
		document.getElementById("gnte_no").className	= "";
		
		tes_getInputValue('DB_DATE', SEARCH06, '', 'setCreDate');
		
		// 저장 Flag 초기화
		document.getElementById("regflag").value	= "Y";
	}

	
	/**
     * Form Object Guarantee Value 초기화<br>
     **/
	function initFormCntrList() {
		sheetObjects[0].RemoveAll();
		
		sheetObjects[0].ColHidden("fm_dt") = false; 
		sheetObjects[0].ColHidden("to_dt") = false;

	}


	/**
     * Customer Code  Validate Check. <br>
     **/
	function checkValidCustCode() {
		var formObj = document.form;
		var tmp = '';
		
		if (formObj.is_valid_gnte_cust_cd.value != undefined && 
			formObj.is_valid_gnte_cust_cd.value != null && 
			formObj.is_valid_gnte_cust_cd.value.trim() != '') {
			tmp = formObj.is_valid_gnte_cust_cd.value.split('--');
			
			if (tmp.length > 0) {
				formObj.is_valid_gnte_cust_cd.value = ( tmp[0] != undefined && tmp[0] != null ? tmp[0] : '' );
				
				if (formObj.is_valid_gnte_cust_cd.value != null && formObj.is_valid_gnte_cust_cd.value == 'Y' ) {
					formObj.gnte_cust_cd_name.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '' );
					formObj.gnte_cust_cd_hidden.value = formObj.gnte_cust_cd.value;
					
					document.getElementById("gnte_cust_cd").focus();
					
				} else {
					formObj.is_valid_gnte_cust_cd.value	= '';
					formObj.gnte_cust_cd_hidden.value	= '';
					formObj.gnte_cust_cd_name.value		= '';
					ComShowCodeMessage('TES70111');		// This is invalid Customer Code.
				}
				
			} else {
				formObj.is_valid_gnte_cust_cd.value	= '';
				formObj.gnte_cust_cd_hidden.value	= '';
				formObj.gnte_cust_cd_name.value		= '';
				ComShowCodeMessage('TES70111');		// This is invalid Customer Code.
			}
			
		} else {
			formObj.is_valid_gnte_cust_cd.value	= '';
			formObj.gnte_cust_cd_hidden.value	= '';
			formObj.gnte_cust_cd_name.value		= '';
			ComShowCodeMessage('TES70111');		// This is invalid Customer Code.
		}
	}
	
	/**
	 *  VndrCode Validation 함수
	 */
	function checkValidVndrCode(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_vndr_seq.value != undefined && 
			formObj.is_valid_vndr_seq.value != null && 
			formObj.is_valid_vndr_seq.value.trim() != '' ) {
			tmp = formObj.is_valid_vndr_seq.value.split('|');
			
			if (tmp.length > 0){
				formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '' );
				
				if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y'){
					formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
					//여기에 이름을 넣어주셔요
					formObj.vndr_seq_name.value	= (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
					
				} else {
					formObj.is_valid_vndr_seq.value	= '';
					formObj.vndr_seq_hidden.value	= '';
					formObj.vndr_seq_name.value		= '';
					ComShowCodeMessage('TES21040'); // This is invalid Service Provider Code.
				}
				
			} else {
				formObj.is_valid_vndr_seq.value	= '';
				formObj.vndr_seq_hidden.value	= '';
				formObj.vndr_seq_name.value		= '';
				ComShowCodeMessage('TES21040'); // This is invalid Service Provider Code.
			}
			
		} else {
			formObj.is_valid_vndr_seq.value	= '';
			formObj.vndr_seq_hidden.value	= '';
			formObj.vndr_seq_name.value		= '';
			ComShowCodeMessage('TES21040'); // This is invalid Service Provider Code.
		}
	}
	
	
	/**
     * gnte_tp_cd(Type) 가 'ST'(Storage) 인 경우에만 보여주고  <br>
     * gnte_tp_cd(Type) 가 'FL'(Flip), 'CY'(Other) 인 경우에는 보여주지 않는다.<br>
     **/
	function setTypeCntrDt() {
		// gnte_tp_cd(Type) 가 'ST'(Storage) 인 경우에만 보여주고 입력 가능하게 한다.
		if ( document.getElementById("gnte_tp_cd").value == 'ST' ) { 
			sheetObjects[0].ColHidden("fm_dt") = false; 
			sheetObjects[0].ColHidden("to_dt") = false;
			
		// gnte_tp_cd(Type) 가 'FL'(Flip), 'CY'(Other) 인 경우에는 보여주지 않는다. 
		} else {
			sheetObjects[0].ColHidden("fm_dt") = true; 
			sheetObjects[0].ColHidden("to_dt") = true;
		}
	}

	
	/**
	 * ESD_TES_2008에서 TPB I/F 이후 Guarantee 조회. <br>
	 */
	function tpbRetrive() {
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}

	
	/**
	 * sheet1 ( Container List ) Data 변경시 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		Row			Row Index.
	 * @param{string}		Col			Col Index.
	 * @param{string}		Value		Value
	 */
	function sheet1_OnChange(sheet1, Row, Col, Value) {
		var sName = sheet1.ColSaveName(Col);
		var formObject = document.form;
		// Bkg No 조회한 데이타 RowId에 넣기 위해 설정.
		document.getElementById("rowId").value	= Row;
		
		// container bkg no inquiry
		document.getElementById("cntr_no_tmp").value	= sheet1.CellValue(Row, "cntr_no");
		
		if ( sName == 'cntr_no' ) {
			if ( ComIsNull( sheet1.CellValue(Row, "cntr_no") ) ) {
				return false;				
			}
			// UpperCase
			sheet1.CellValue2(Row, "cntr_no") = sheet1.CellValue(Row, "cntr_no").toUpperCase();
			
			// checkDigsit
			sheet1.CellValue2(Row, "cntr_no") = cntrCheckDigit( sheet1.CellValue(Row, "cntr_no") );
			
			// Container No. Duplication Check.
			if ( !checkDupCntrNo(sheet1, Row) ) {
				return false;
			}
			
			// Container No.로 Bkg No. search.
			searchBkgNoList(sheet1, Row);
		}

		// Container No. Bkg No. 로 BL No. SC No. VVD 조회 setting.
	    if ( sName == 'bkg_no' && document.getElementById("retrieveFlg").value == 'N') {
	    	searchCntrInfo();
	    }

	    if ( sName == 'gnte_amt' ) {
			if (isNaN(sheet1.CellValue(Row, 'gnte_amt')) || sheet1.CellValue(Row, 'gnte_amt') <= 0) {
				ComShowCodeMessage('TES60102'); 	//Amount should be greater than 0.
				return false;
			}
			
	    	document.getElementById("ttl_amt").value = getShtTotAmt(sheet1, 'gnte_amt');
	    }
	    
	    if ( sName == 'to_dt' ) {
			if ( ComGetDaysBetween(sheet1.CellValue(Row , "fm_dt"), sheet1.CellValue(Row , "to_dt")) < 0 ) {
				ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
				sheet1.CellValue2(Row , "to_dt") = "";
				return false;
			}
	    }
	    
	    if ( sName == 'cntr_no' || sName == 'bkg_no'){ 
	    	sheet1.RowFontColor(Row) = sheet1.RgbColor(0, 0, 0);//Row가 빨간색일수 있으므로 무조건 검은색으로..
	    }
	}

	/**
	 * sheet1 (Guarantee Conatainer Info ) 조회후 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg){
	    var formObject = document.form;
	
	    if( errMsg == '' ) {
	    	// To-Do
	    	// Delete 시 Message Alert 할것.
	    	
			// TPB I/F 나 Irregular Data 가 없는 경우  Editable 한다
			for (var i = sheetObj.HeaderRows; i < (sheetObj.HeaderRows + sheetObj.RowCount); i++)
			{
				if ((!ComIsNull( sheetObj.CellValue(i, "tml_if_ofc_cd") ) &&
					!ComIsNull( sheetObj.CellValue(i, "tml_if_seq") ) ) ||
					!ComIsNull( sheetObj.CellValue(i, "irr_no") ) ) {
					setShtCellsEditable2(sheetObj,i,'cntr_no|bkg_no|bkg_no|fm_dt|to_dt|gnte_amt|bkg_no2', 'N');
				}
			}
	    } else {
			ComShowMessage( errMsg );
	    }
	}
	
	/** 
	 * Cell 활성화, 비활성화 처리
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
	

	/**
	 * sheet2 (Guarantee Header Info ) 조회후 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet2_OnSearchEnd(sheetObj, errMsg){
	    var formObject = document.form;
	
	    if( errMsg == '' ) {
	    	// To-Do
	    	// Delete 시 Message Alert 할것.
	    	
	    	if ( !ComIsNull( sheetObjects[1].CellValue(1, "gnte_no") ) ) {
	    		// 저장 Flag 
				document.getElementById("regflag").value		= "N";
				document.getElementById("retrieveFlg").value	= "Y";

				document.getElementById("gnte_no").value			= sheetObjects[1].CellValue(1, "gnte_no");
				document.getElementById("delt_flg").value			= sheetObjects[1].CellValue(1, "delt_flg");
				document.getElementById("gnte_tp_cd").value			= sheetObjects[1].CellValue(1, "gnte_tp_cd");
				document.getElementById("curr_cd").value			= sheetObjects[1].CellValue(1, "curr_cd");
				document.getElementById("bkg_sts_cd").value			= sheetObjects[1].CellValue(1, "bkg_sts_cd");
				
				document.getElementById("gnte_cust_cd").value		= sheetObjects[1].CellValue(1, "gnte_cust_cd");
				document.getElementById("gnte_cust_cd_name").value	= sheetObjects[1].CellValue(1, "gnte_cust_cd_name");
				document.getElementById("vndr_seq").value			= sheetObjects[1].CellValue(1, "vndr_seq");
				document.getElementById("vndr_seq_name").value		= sheetObjects[1].CellValue(1, "vndr_seq_name");
				document.getElementById("ttl_amt").value			= sheetObjects[1].CellValue(1, "ttl_amt");	// tes_chkAmtFmt( sheetObjects[1].CellValue(1, "ttl_amt"), sheetObjects[1].CellValue(1, "curr_cd") );
				
				document.getElementById("gnte_rmk").value			= sheetObjects[1].CellValue(1, "gnte_rmk");
				document.getElementById("pic_phn_no").value			= sheetObjects[1].CellValue(1, "pic_phn_no");
				document.getElementById("pic_fax_no").value			= sheetObjects[1].CellValue(1, "pic_fax_no");
				document.getElementById("dept_no").value			= sheetObjects[1].CellValue(1, "dept_no");
				document.getElementById("cost_ofc_cd").value		= sheetObjects[1].CellValue(1, "dept_no");
				
				document.getElementById("is_valid_dept_no").value	= "Y";
				document.getElementById("cre_dt").value				= sheetObjects[1].CellValue(1, "cre_dt");
				document.getElementById("gnte_cust_cd_hidden").value= sheetObjects[1].CellValue(1, "gnte_cust_cd");
				document.getElementById("vndr_seq_hidden").value	= sheetObjects[1].CellValue(1, "vndr_seq");
				document.getElementById("ofc_cd").value				= sheetObjects[1].CellValue(1, "ofc_cd");
				
				document.getElementById("cre_usr_id").value			= sheetObjects[1].CellValue(1, "cre_usr_id");
				
				document.getElementById("gnte_no").readOnly			= true;
				document.getElementById("gnte_no").className		= "input2";

				// fm_dt, to_dt CellHidden
				setTypeCntrDt();
				
				// Container Bkg No. List ComboBox 조회.
				for (var i = sheetObjects[0].HeaderRows; i < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++)
				{
					sheetObjects[0].CellComboItem(i, "bkg_no", sheetObjects[0].CellValue(i, "bkg_no_list_ctnt"), sheetObjects[0].CellValue(i, "bkg_no_list_ctnt") );
					sheetObjects[0].CellValue2(i, "bkg_no")	= sheetObjects[0].CellValue(i, "bkg_no2"); 
				}
				
				document.getElementById("retrieveFlg").value= "N";
	    	} else {
	    		// 조회건수가 없을경우 새로 생성할건지 Confirm.
	    		document.getElementById("regflag").value	= "Y";

	    		initFormHdr();
	    	}
	    } else {
			ComShowMessage( errMsg );
	    }
	
	}
    
	
	/**
	 * sheet2 (Guarantee Header Info ) 조회후 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet2_OnSaveEnd(sheetObj, errMsg){
	    var formObject = document.form;
	
	    if( errMsg == '' ) {
	    	if ( formObject.f_cmd.value == ADD ) {
	    		document.getElementById("gnte_no").value	= sheetObj.EtcData("gnte_no");
	    	}

			doActionIBSheet1(sheetObjects[0], formObject, IBSAVE);
	    } else {
			ComShowMessage( errMsg );
	    }
	}

	
	/**
	 * sheet2 (Guarantee Header Info ) 조회후 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function getShtTotAmt(sheetObj, colnm) {

		var tot_amt_val = 0;

		for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++)
		{
			if (sheetObj.RowSumable(i) && sheetObj.CellValue(i, colnm) != null &&
				sheetObj.CellValue(i, colnm).trim() != '' && 
				sheetObj.CellValue(i, colnm) != undefined &&
				!isNaN(parseFloat(sheetObj.CellValue(i, colnm))) && 
				sheetObj.RowStatus(i) != 'D'
			) {
				tot_amt_val = Math.round(Number(tot_amt_val) * 10000) / 10000 + Math.round(Number(sheetObj.CellValue(i, colnm)) * 10000) / 10000;
			}
		}

		tot_amt_val = Math.round(Number(tot_amt_val)*10000)/10000;
		tot_amt_val = tes_chkAmtFmt(tot_amt_val, document.form.curr_cd.Code);

		return tot_amt_val;
	}
	
	
	
	/**
     * 생성날짜 체크 설정.
     * 
     */
	function setCreDate(){
		/* from 한달전 ~ to 오늘 */
		var formObj = document.form;
		var cre_dt = new String(formObj.DB_DATE.value).substring(0, 8);

		if (cre_dt != undefined && cre_dt != null && cre_dt.trim() != '' && cre_dt.length == 8) {
			formObj.cre_dt.value = cre_dt.substring(0, 4) + '-' + cre_dt.substring(4, 6) + '-' + cre_dt.substring(6, 8);
		}
	}
	
	
	/**
     * TPB IF 된 대상의 Delete 여부 Check.
     * 
     */
	function checkNonTPB() {
		var arrTPB = document.getElementById("is_valid_TPB").value.split("|");
		var	delCnt = 0;
		var	delNotCnt = 0;
		// checkNonTPB ( 바로삭제(Non TPB) : Y, 삭제가능(TPB Candidate) : N, 삭제불가 (Confirm Or TPB INV 생성): X, I/F대상없음 : O )
		// 건별 체크로 전부 되돌려 주는 건지 확인.
		for( var i = 0; i < arrTPB.length; i++ ) {
			if ( arrTPB[i] == "Y" ) {
				delCnt++;
			} else if ( arrTPB[i] == "N" ) {
				delNotCnt++;
//				ComShowCodeMessage('TES70114'); // 'TPB No. exists already. Please have it deleted first at TPB';
			} else if ( arrTPB[i] == "X" ) {
				delNotCnt++;
//				ComShowMessage('// TPB I/F를 삭제할수 없습니다.'); // TPB I/F를 삭제할수 없습니다.
			} else if ( arrTPB[i] == "O" ) {
				delCnt++;
//				ComShowMessage("// 삭제할 TPB I/F 대상이 없습니다."); // 삭제할 TPB I/F 대상이 없습니다.
			}
		}

		// 바로 삭제 가능한 건수와 TPB 건수가 같을 경우 삭제처리.
		if ( delCnt == arrTPB.length ) {
			// Header 삭제 처리 하고 Container List TPB I/F 된건 삭제 처리
			doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
		} else if ( delNotCnt > 0 ) {
			ComShowCodeMessage('TES70120'); // 'TPB No. exists already. Please have it deleted first at TPB';
			return false;
		}
	}

	
	/**
	 * Container No. Duplication Check. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function checkDupCntrNo(sheetObj, row) {

		for (var i = sheetObjects[0].HeaderRows; i < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++) {
		
			if ( i != row ) {
				if ((sheetObjects[0].CellValue(i, "cntr_no") == sheetObjects[0].CellValue(row, "cntr_no") ) &&
					(sheetObjects[0].CellValue(i, "bkg_no") == sheetObjects[0].CellValue(row, "bkg_no") ) && 
					 sheetObjects[0].CellValue(i, "ibflag") != 'D'
				) {
					ComShowCodeMessage("TES70117", sheetObjects[0].CellValue(row, "cntr_no"), sheetObjects[0].CellValue(row, "bkg_no"));		//[Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.
					return false;
				}
			}
		}
		return true;
	}

	
	/**
	 * Container No. BKG No. List 조회. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function searchBkgNoList(sheetObj, row, retrieveFlg) {
		// container bkg no inquiry
		document.getElementById("cntr_no_tmp").value	= sheetObj.CellValue(row, "cntr_no");
		
		// BKG No.를 조회  ComboBox 설정. 
		// ( Retrieve Guarantee 면 Container Info 조회된 것으로 입력.)
		if ( retrieveFlg == 'Y' ) {
			tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', 'bkgNoCheck');
		// ( New Guarantee 면 Container Info 자동 입력.)
		} else {
        //	tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', 'searchCntrInfo', sheetObj);
			tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', 'bkgNoCheck');
		}
	}
	
    /**
	 * BKG No List가 없을 경우 Popup Message : "This Container is not valid for the Guarantee input" <br>
	 * 
	 */
	function bkgNoCheck(){		
		 tmp = sheetObjects[0].CellValue(sheetObjects[0].RowCount, "bkg_no_list_ctnt");
		
		if (tmp == undefined || tmp == null || tmp == '' ) {  
			ComShowCodeMessage("TES70123");
			}			
    } 
	 
	/**
	 * Container No. BKG No. 조회후 Container Info 조회. <br>
	 * 
	 */
	function searchCntrInfo(){
		 // Container no 로 조회된 BKG No.가 있으면 Container Info 조회 
		if ( !ComIsNull( sheetObjects[0].CellValue( document.getElementById("rowId").value, "bkg_no") ) ) {
			document.getElementById("bkg_no_tmp").value	= sheetObjects[0].CellValue( document.getElementById("rowId").value, "bkg_no");
			tes_getInputValueGuarantee('is_valid_cntr_info', SEARCH01, 'cntr_no_tmp|bkg_no_tmp', 'checkValidCntrInfo');
			
			document.getElementById("gnte_cust_cd_tmp").value = document.form.gnte_cust_cd.value;
			document.getElementById("vndr_seq_tmp").value	  = document.form.vndr_seq.value;
			document.getElementById("gnte_tp_cd_tmp").value	  = document.form.gnte_tp_cd.value;
			tes_getInputValueGuarantee('is_valid_cntr_info2', SEARCH09, 'vndr_seq_tmp|gnte_cust_cd_tmp|gnte_tp_cd_tmp|bkg_no_tmp|cntr_no_tmp', 'checkValidCntrInfo2');
		// Container No. 의 BKG No.가 없는 경우 초기화.
		} else {
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_tpsz_cd")	= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bkg_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bl_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "vvd_cd")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "sc_no")		= "";
			document.getElementById("cntr_no_tmp").value	= "";
			document.getElementById("bkg_no_tmp").value		= "";
			ComShowCodeMessage("TES70116"); // This is invalid Container No.
		}
	}
	
	/**
	 * Container Info 조회후 setting. <br>
	 * tmp[0]. Valid
	 * tmp[1]. cntr_no
	 * tmp[2]. cntr_tpsz_cd
	 * tmp[3]. bkg_no
	 * tmp[4]. bl_no
	 * tmp[5]. vvd_cd
	 * tmp[6]. sc_no
	 */
	function checkValidCntrInfo(){
		// Container Info Setting. 
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_cntr_info.value != undefined && 
			formObj.is_valid_cntr_info.value != null && 
			formObj.is_valid_cntr_info.value.trim() != '' ) {
			tmp = formObj.is_valid_cntr_info.value.split('|');
			
			if (tmp.length > 0){
				formObj.is_valid_cntr_info.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '' );
				if (formObj.is_valid_cntr_info.value != null && formObj.is_valid_cntr_info.value == 'Y'){
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_tpsz_cd")	= (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bl_no")		= (tmp[4] != undefined && tmp[4] != null ? tmp[4] : '');
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "vvd_cd")		= (tmp[5] != undefined && tmp[5] != null ? tmp[5] : '');
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "sc_no")		= (tmp[6] != undefined && tmp[6] != null ? tmp[6] : '');
					document.getElementById("bkg_no_tmp").value		= "";
					
				} else {
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_no")		= "";
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_tpsz_cd")	= "";
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bkg_no")		= "";
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bl_no")		= "";
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "vvd_cd")		= "";
					sheetObjects[0].CellValue2( document.getElementById("rowId").value, "sc_no")		= "";
					document.getElementById("cntr_no_tmp").value	= "";
					document.getElementById("bkg_no_tmp").value		= "";
					ComShowCodeMessage("TES70116"); // This is invalid Container No.
				}
			} else {
				sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_no")		= "";
				sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_tpsz_cd")	= "";
				sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bkg_no")		= "";
				sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bl_no")		= "";
				sheetObjects[0].CellValue2( document.getElementById("rowId").value, "vvd_cd")		= "";
				sheetObjects[0].CellValue2( document.getElementById("rowId").value, "sc_no")		= "";
				document.getElementById("cntr_no_tmp").value	= "";
				document.getElementById("bkg_no_tmp").value		= "";
				ComShowCodeMessage("TES70116"); // This is invalid Container No.
			}
		} else {
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_tpsz_cd")	= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bkg_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bl_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "vvd_cd")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "sc_no")		= "";
			document.getElementById("cntr_no_tmp").value	= "";
			document.getElementById("bkg_no_tmp").value		= "";
			ComShowCodeMessage("TES70116"); // This is invalid Container No.
		}		
	}
	
	function checkValidCntrInfo2(){
		// Container Info Setting. 
		var formObj = document.form;
		if (formObj.is_valid_cntr_info2.value != undefined && 
			formObj.is_valid_cntr_info2.value != null && 
			formObj.is_valid_cntr_info2.value.trim() != '' ) {  
			
			if (formObj.is_valid_cntr_info2.value != null && formObj.is_valid_cntr_info2.value == 'Y'){
				ComShowCodeMessage("TES70122");
			}
		}
 }
	
	function checkValidCntrInfo3(){
		// Container Info Setting. 
		var formObj = document.form;
		if (formObj.is_valid_cntr_info2.value != undefined && 
			formObj.is_valid_cntr_info2.value != null && 
			formObj.is_valid_cntr_info2.value.trim() != '' ) {  
			
			tmp = formObj.is_valid_cntr_info2.value.split(':');
			for(var i = 0;i<tmp.length;i++){
				cntrBkg = tmp[i].split('|');
				for (var j = sheetObjects[0].HeaderRows ; j < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); j++){
				    if ((cntrBkg[0] == sheetObjects[0].CellValue(j , "cntr_no")) && (cntrBkg[1] == sheetObjects[0].CellValue(j , "bkg_no"))){
				    	sheetObjects[0].RowFontColor(j) = sheetObjects[0].RgbColor(255, 0, 0);
				    } 
				}
			}
					ComShowCodeMessage("TES70122");
					return false;
		} else {	
				doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
		}
	}
 
	
    /**
	 * 입력된 Depart 값을 Validation Check 함수
	 *
	 */
	function validateDeptNo() {
		var formObj = document.form;
		if (formObj.dept_no.readOnly == false && formObj.cost_ofc_cd.value != "" ) {
			if ((formObj.dept_no.value == null || formObj.dept_no.value.trim() == '') ||
				formObj.dept_no.value != formObj.cost_ofc_cd.value ) {
				tes_getInputValue('is_valid_dept_no', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidDeptNo');
			}
		}
	}

	/**
	 * 설명 : Depart Validation Check 함수
	 * 사용 :
	 */
	function checkValidDeptNo(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_dept_no.value != undefined && formObj.is_valid_dept_no.value != null &&
			formObj.is_valid_dept_no.value.trim() != '' ){
			tmp = formObj.is_valid_dept_no.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_dept_no.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
				if (formObj.is_valid_dept_no.value != null && formObj.is_valid_dept_no.value == 'Y'){
					formObj.dept_no.value	= document.getElementById("cost_ofc_cd").value;
				} else {
					formObj.is_valid_dept_no.value = '';
					formObj.dept_no.value = '';
					ComShowCodeMessage('TES70603');	// This is invalid Depart.
				}
			} else {
				formObj.is_valid_dept_no.value = '';
				formObj.dept_no.value = '';
				ComShowCodeMessage('TES70603');	// This is invalid Depart.
			}
		} else {
			formObj.is_valid_dept_no.value = '';
			formObj.dept_no.value = '';
			ComShowCodeMessage('TES70603');	// This is invalid Depart.
		}
	}

	/**
     * 영문(대문자)과 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isApNum(obj){
		if (!ComIsAlphabet(obj,'u')){
			obj.value = '';
		}
	}

	/**
     * 영문과 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isApNum2(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,'n')){
			obj.value = '';
		}
		obj.value = obj.value.toUpperCase();
	}

	
	/**
     * 영문과 숫자만.. <br>
     * @param {obj}    Text Value
     **/
	function isApNum2(obj){
		//영문과 숫자만..
		if (!ComIsAlphabet(obj,'n')){
			obj.value = '';
		}
		obj.value = obj.value.toUpperCase();
	}
	
	/**
	 * Print에 앞서 TPB I/F 혹은 Irregular여부 확인하여 둘중 하나에 해당될 때만 Print 되도록 하기 위함
	 * @return
	 */
	function gnteInqPrintChk() {
		
		if ( (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount) <= 1 ) {
			ComShowCodeMessage('TES21017'); // 'There is no data.';
			return false;
		}
		else {
			if (document.form.is_valid_print.value == "N") {
			ComShowCodeMessage('TES70119');		// 'TPB I/F Or Irregular 중 하나라도 생성되어야 Print 가능.'
			return false;
			}
		
		var url_str = 'ESD_TES_2003.screen';
		url_str = url_str + '?pgmNo=ESD_TES_2003';
		url_str = url_str + '&gnte_no=' + document.form.gnte_no_hidden.value;
		window.showModalDialog(url_str, window, "dialogWidth:900px; dialogHeight:700px; help:no; status:no; resizable:yes;");
		}
	}
	
	/* 개발자 작업  끝 */