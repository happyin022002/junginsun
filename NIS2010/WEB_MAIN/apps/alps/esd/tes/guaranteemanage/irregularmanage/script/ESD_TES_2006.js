/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2006.js
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.14 yOng hO lEE
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
     * @class ESD_TES_2006 : ESD_TES_2006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TES_2006() {
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

/**
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 */
document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 **/
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];	// Irregular Container List Sheet.
		var sheetObject2 = sheetObjects[1];	// Irregular Header Info Hidden Sheet.
	
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					if ( ComIsNull( formObject.irr_no.value ) ) {
						ComShowCodeMessage('TES70101');    // Please enter Reference Number.
						formObject.irr_no.focus();
						return false;
					}
					
					// 12자리 체크
					if ( formObject.irr_no.value.length != 12 ) {
						ComShowCodeMessage('TES70109');    // Please check length Reference Number.
						formObject.irr_no.focus();
						return false;
					}
					
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
					break;
	
				case "btn_new":
					// Guarantee 에서 넘어온 경우 비활성화.
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }
					initFormHdr();		// Irregular Header Form Init.
					initFormCntrList();	// Irregular Container List Sheet Init.
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
						ComShowCodeMessage('TES70606');    // No authority to correct/delete the Irregular - Creation office mismatch!
						return false;
					}
					
					if ( ComIsNull( document.getElementById("irr_tp_cd").value ) ) {
						ComShowCodeMessage('TES70602');    // Please enter Irregular Type.
						return false;
					}

					if ( ComIsNull( document.getElementById("dept_no").value ) ) {
						ComShowCodeMessage('TES70603');    // This is invalid Depart.
						return false;
					}
					
					if (ComChkLen( document.getElementById("respb_pty_nm").value, 50) == "0"){
						ComShowCodeMessage('TES70609');
						return false;
					}
					
					if (ComChkLen( document.getElementById("irr_rsn_rmk").value, 1500) == "0"){
						ComShowCodeMessage('TES70610');
						return false;
					}
					
					/* Container List */
					for ( var i = sheetObject1.HeaderRows; i < sheetObject1.HeaderRows + sheetObject1.RowCount; i++ ) {
						
						if ( ComIsNull( sheetObject1.CellValue(i , "cntr_no") ) ) {
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
					}
					
					// Irregular Type 변경시 저장 정보 설정.
					irrTpCdSaveInit();
					
					// Guarantee에서 넘어왔을때 비활성화 된것을 활성화 시켜준다.
					ComEnableManyObjects(true 
							, document.form.gnte_tp_cd 
							, document.form.curr_cd
							, document.form.bkg_sts_cd
							);
					
					// Reference Number(Irregular No.) 가 조회된 값이 없으면 저장.
					if (ComIsNull( document.getElementById("irr_no").value ) ) {
						// Guarantee 에서 Irregular 등록할 경우.
						if ( document.getElementById("gnte_flg").value == 'Y') {
							formObject.f_cmd.value = MULTI01;
//							doActionIBSheet(sheetObject2, formObject, IBSEARCH_ASYNC02);
						} else {
							formObject.f_cmd.value = ADD;
						}
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
						
					// Reference Number(Irregular No.) 가 조회된 값과 같으면 Update.
					} else if (!ComIsNull( document.getElementById("irr_no").value ) &&
						formObject.irr_no.value == sheetObject2.CellValue(1, "irr_no") ) {
						formObject.f_cmd.value = MODIFY;
						doActionIBSheet(sheetObject2, formObject, IBSAVE);
					}

					break;
	
				case "btn_guarantee":
					// Irregular Popup 
					// Guarantee 에서 넘어온 경우.
					if ( document.getElementById("gnte_flg").value == "Y" ) {
						var guaranteeUrl = "ESD_TES_2001.do?pgmNo=ESD_TES_2001&irr_flg=Y"
							+ "&gnte_no=" + document.getElementById("gnte_no").value
							;
						window.location.replace(guaranteeUrl);
					}
					break; 
				
				case "btn_print":
					// Irregular 생성 내용 Report Designer 출력
//					if ( document.getElementById("dmy_flg").value != 'Y'  ) {						
//						alert("This Is Not An Irregular"); // This Is Not A Irregular.
//						return false;
//					}
					
					if ( (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount) <= 1 ) {
						ComShowCodeMessage('TES21017'); // 'There is no data.';
						return false;
					}
					else {	
						document.form.irr_no_hidden.value = document.getElementById("irr_no").value;
						tes_getInputValueGuarantee('is_valid_print', SEARCH07, 'irr_no_hidden', 'irrInqPrintChk');
					
//						var url_str = 'ESD_TES_2009.screen';
//						url_str = url_str + '?pgmNo=ESD_TES_2009';
//						url_str = url_str + '&irr_no=' + document.form.irr_no.value;
//						window.showModalDialog(url_str, window, "dialogWidth:900px; dialogHeight:700px; help:no; status:no; resizable:yes;");
					}
					break;
					
				case "btn_delete":
					// Guarantee 에서 넘어온 경우 비활성화.
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }

				    if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}

					// Irregular 내용 Header 삭제
					if (!ComIsNull(sheetObject2.CellValue(1, "ofc_cd") ) && 
							sheetObject2.CellValue(1, "ofc_cd") != document.getElementById("cre_ofc_cd").value	
					) {
						ComShowCodeMessage('TES70606');    // No authority to correct/delete the Irregular - Creation office mismatch!
						return false;
					}

					if ( ComShowConfirm(ComGetMsg('TES70604') ) ) {
						// checkNonTPB ( 바로삭제 : Y, 삭제가능 : N, 삭제불가 : X, I/F대상없음 : O )
						tes_getInputValueGuarantee('is_valid_TPB', SEARCH03, 'gnte_no|irr_no', 'checkNonTPB');
					}				    
					
					break;

				case "btn_refno":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "ESD_TES_2004";
					var param = '?cre_flg=I&classId='+classId;
					var chkStr = dispaly.substring(0,3)
					
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('ESD_TES_2004.do' + param, 300, 350, '', dispaly, true);
						
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;

				case "btng_rowadd":
					// Guarantee 에서 넘어온 경우 비활성화.
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }
				    
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}
					var Row = sheetObject1.DataInsert();
					
					break; 
	
				case "btng_rowdelete":
					// Guarantee 에서 넘어온 경우 비활성화.
				    if ( document.getElementById("gnte_flg").value == "Y" ) {
//				    	ComShowCodeMessage('TES70118');   // .
				    	return;
				    }
				    
					if ( document.getElementById("delt_flg").value == "Y") {
						ComShowCodeMessage('TES70118');   // Already Deleted.
						return;
					}
					
					var selectedRow = sheetObject1.GetSelectionRows('|').split('|');
					
					for(var i = selectedRow.length - 1; i >= 0; i-- ) {
						if (sheetObject1.CellValue(selectedRow[i], "cntr_no") == null ) {
					    	sheetObject1.RowDelete(selectedRow[i], false);
						} else {
							sheetObject1.RowStatus(selectedRow[i]) = 'D';
							sheetObject1.RowHidden(selectedRow[i]) = true;
//							sheetObject1.CellValue2(selectedRow[i], "gnte_amt") = 0; // 어짜피 지울넘... 숨기더라도 총액 계산에 반영되므로 0으로 만들어야 합당...
						}
					}
					
					// Amount 재설정
					document.getElementById("irr_ttl_amt").value = getShtTotAmt(sheetObject1, "gnte_amt" );
	                
					break;
				case "btn_irregular":
					
					var url_str = 'ESD_TES_2007.do';
					url_str += '?pgmNo=ESD_TES_2007';
					url_str += '&pre_cond_irr_no='+document.form.pre_cond_irr_no.value;
					url_str += '&pre_cond_cost_ofc_cd='+document.form.pre_cond_cost_ofc_cd.value;
					url_str += '&pre_cond_cre_usr_id='+document.form.pre_cond_cre_usr_id.value;
					url_str += '&pre_cond_gnte_tp_cd='+document.form.pre_cond_gnte_tp_cd.value;
					url_str += '&pre_cond_fm_cre_dt='+document.form.pre_cond_fm_cre_dt.value;
					url_str += '&pre_cond_to_cre_dt='+document.form.pre_cond_to_cre_dt.value;
					location.href = url_str;
					break; 
			} // end switch
		} catch(e) {
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
		for(i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	
	 		// Guarantee 에서 넘어온 경우 Data Setting.
		if ( document.getElementById("gnte_flg").value == "Y" ) {
			// Header 정보. Container List 정보 
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01); // IBSEARCH01
		}
		// Inquiry 화면에서 넘어온 경우.
		else if ( document.getElementById("inq_flg").value == "Y" ) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} 
		else {
			initFormHdr();
		}
	    
		document.getElementById("irr_no").focus();
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


					var HeadTitle1 = "|Seq|Container No.|SZ|BKG No.|BL No.|SC No.|From DT|To DT|Amount|VVD CD|Bkg No List|Bkg No. Org|IF OfC|IF SEQ";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,		"tml_gnte_cntr_list_seq",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"cntr_no",			false,      "",				dfNone,		0,			true,		true,		11);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"cntr_tpsz_cd",		false,      "",				dfNone,		0,			true,		true,		2);
					InitDataProperty(0, cnt++ , dtCombo,		110,	daCenter,	false,		"bkg_no",			false,		"",				dfNone,		0,			true,		true);

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"bl_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"sc_no",			false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"fm_dt",			false,      "",				dfDateYmd,	0,			true,		true,		10);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"to_dt",			false,		"",				dfDateYmd,	0,			true,		true,		10);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"gnte_amt",			false,      "",				dfFloat,	2,			true,		true,		12);

					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"vvd_cd",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"bkg_no_list_ctnt",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"bkg_no2",			false,		"",				dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"tml_if_ofc_cd",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		110,	daCenter,	false,		"tml_if_seq",		false,		"",				dfNone,		0,			true,		true);

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


					var HeadTitle1 = "STS|Irr No|Ref no|Office|Gnte Type|Currency|Bkg Sts|Irr Type|Irr Rsn Remark|Irr Prvt Remark|" +
									"Irr Amt|Staff|System|Chassis|Other|Dispatch|Lack|Canceled|Shortage|" +
									"OP Cost Ocp|Team|Tank Ord|Ext Ft|Spot Inc|Tml Chz|MnR|Triaxle|" +
									"Depart|Resp Part|Del|Cre User|Cre Date|Upd User|Upd Date|DMY FLG";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"irr_no",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"gnte_no",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"ofc_cd",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"gnte_tp_cd",	false,		"",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"curr_cd",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,		"bkg_sts_cd",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"irr_tp_cd",	false,      "",				dfNone,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"irr_rsn_rmk",	false,      "",				dfNone,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"irr_prvt_rmk",	false,      "",				dfNone,	0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"irr_ttl_amt",		false,      "",				dfFloat,	2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"irr_stf_err_flg",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"irr_sys_err_flg",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"irr_chss_shtg_flg",false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"irr_otr_flg",		false,      "",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"irr_late_dis_flg",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"irr_lack_of_flw_flg",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"irr_cxl_wo_flg",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"irr_eq_shtg_flg",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"op_cost_ocp_flg",		false,		"",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"op_cost_tnk_ord_flg",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"op_cost_team_trkg_flg",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"op_cost_xtra_ft_flg",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"op_cost_sptg_icrz_flg",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"op_cost_otr_tml_chss_flg",	false,      "",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"op_cost_mnr_flg",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"op_cost_tri_axl_flg",	false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"dept_no",				false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"respb_pty_nm",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"delt_flg",				false,      "",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"cre_usr_id",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"cre_dt",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"upd_usr_id",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		"upd_dt",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,	        110,	daCenter,	true,		"dmy_flg",		false,      "",				dfNone,		0,			false,		false);
					
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
    	 		var	sXml	= sheetObj.GetSearchXml("ESD_TES_2006GS.do", tesFrmQryStr(formObj) );
    	 		var arrXml	= sXml.split("|$$|"); 

				for (var i = 0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}

                sXml	= null;
                arrXml	= null;

				break;

			case IBSEARCH_ASYNC01:      // Guarantee 에서 넘어온 경우 조회
	    		formObj.f_cmd.value = SEARCH01;
    	 		var	sXml	= sheetObj.GetSearchXml("ESD_TES_2006GS.do", tesFrmQryStr(formObj) );
    	 		var arrXml	= sXml.split("|$$|"); 

				for (var i = 0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}

                sXml	= null;
                arrXml	= null;

				break;

			case IBSAVE:        // 저장
				var param = sheetObj.GetSaveString();
				var savexml = sheetObjects[1].GetSaveXml("ESD_TES_2006GS.do", tesFrmQryStr(formObj) + '&' + param);
				sheetObjects[1].LoadSaveXml(savexml, true);

				break;

			case IBDELETE:      // 삭제
				formObj.f_cmd.value = REMOVE;
				var param = sheetObj.GetSaveString();
				var savexml = sheetObj.GetSaveXml("ESD_TES_2006GS.do", tesFrmQryStr(formObj));

				doActionIBSheet( sheetObj, formObj, IBSEARCH );
				sheetObj.RemoveAll();
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
    	 		var	sXml = sheetObj.DoSearch4Post("ESD_TES_2006GS.do", tesFrmQryStr(formObj) );
    	 		sheetObj.LoadSearchXml(sXml, false);
				break;
		
			case IBSAVE:        //저장
				formObj.f_cmd.value = MULTI;
				var param = sheetObjects[0].GetSaveString();
				var saveXml = sheetObjects[0].GetSaveXml("ESD_TES_2006GS.do", tesFrmQryStr(formObj) + '&' + param);
    	 		var arrXml	= saveXml.split("|$$|"); 
    	 		
				for (var i = 0; arrXml != null && i < arrXml.length; i++) {
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}
				
                sXml	= null;
                arrXml	= null;
				break;

			case IBDELETE:      // 삭제
				formObj.f_cmd.value = MULTI;
                var param = sheetObj.GetSaveString();
		        var savexml = sheetObj.GetSaveXml("ESD_TES_2006GS.do", tesFrmQryStr(formObj) + '&' + param );
				break;
		}
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
			if ( ComIsNull( sheet1.CellValue(Row, "cntr_no").trim() ) ) {
				ComShowCodeMessage("TES70116");
				return false;				
			}

			//UpperCase
			sheet1.CellValue2(Row, "cntr_no") = sheet1.CellValue(Row, "cntr_no").toUpperCase();			
			
			//checkDigsit
			sheet1.CellValue2(Row, "cntr_no") = cntrCheckDigit( sheet1.CellValue(Row, "cntr_no") );
			
			//Container No. Duplication Check.
			if ( !checkDupCntrNo(sheet1, Row) ) {
				return false;
			}
			
			//Container No.로 Bkg No. search.
			//searchBkgNoList(sheet1, Row);
			
			//Master Container에서 CNTR 존재여부 확인
			searchMstCntrExist(sheet1, Row);
		}
		
		if ( sName == 'cntr_tpsz_cd' ) {
			//UpperCase
			sheet1.CellValue2(Row, "cntr_tpsz_cd") = sheet1.CellValue(Row, "cntr_tpsz_cd").toUpperCase();
		}

		// Container No. Bkg No. 로 BL No. SC No. VVD 조회 setting.
	    if ( sName == 'bkg_no' && document.getElementById("retrieveFlg").value == 'N') {
	    	searchCntrInfo();
	    }
		
	    if ( sName == 'gnte_amt' ) {
	    	document.getElementById("irr_ttl_amt").value = getShtTotAmt(sheet1, 'gnte_amt');
	    }
	    
	    if ( sName == 'to_dt' ) {
			if ( ComGetDaysBetween(sheet1.CellValue(Row , "fm_dt"), sheet1.CellValue(Row , "to_dt")) < 0 ) {
				ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
				sheet1.CellValue2(Row , "to_dt") = "";
				return false;
			}
	    }
	}
	
	
	/**
	 * sheet2 (Irregular Header Info ) 조회후 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet2_OnSearchEnd(sheetObj, errMsg){
	    var formObject = document.form;
	
	    if( errMsg == '' ) {
	    	if ( !ComIsNull( sheetObjects[1].CellValue(1, "gnte_no") ) ) {
				
				// 저장 Flag 
				document.getElementById("regflag").value		= "N";
				document.getElementById("retrieveFlg").value	= "Y";

				document.getElementById("irr_no"					).value	= sheetObjects[1].CellValue(1, "irr_no"						);
				document.getElementById("gnte_no"					).value	= sheetObjects[1].CellValue(1, "gnte_no"					);
				document.getElementById("ofc_cd"					).value	= sheetObjects[1].CellValue(1, "ofc_cd"					    );
				document.getElementById("gnte_tp_cd"				).value	= sheetObjects[1].CellValue(1, "gnte_tp_cd"				    );
				document.getElementById("curr_cd"					).value	= sheetObjects[1].CellValue(1, "curr_cd"					);
				
				document.getElementById("bkg_sts_cd"				).value	= sheetObjects[1].CellValue(1, "bkg_sts_cd"				    );
				document.getElementById("irr_rsn_rmk"				).value	= sheetObjects[1].CellValue(1, "irr_rsn_rmk"				);
				document.getElementById("irr_prvt_rmk"				).value	= sheetObjects[1].CellValue(1, "irr_prvt_rmk"				);
				document.getElementById("irr_ttl_amt"				).value	= tes_chkAmtFmt( sheetObjects[1].CellValue(1, "irr_ttl_amt"));
				document.getElementById("dmy_flg"					).value	= sheetObjects[1].CellValue(1, "dmy_flg"					);

				if ( !ComIsNull( sheetObjects[1].CellValue(1, "irr_stf_err_flg"	) ) ) {
					document.getElementById("irr_tp_cd").value	= sheetObjects[1].CellValue(1, "irr_tp_cd"				    );
				}
				
				if ( sheetObjects[1].CellValue(1, "irr_tp_cd") == "O" ) {
					document.getElementsByName("irLayer")[0].style.display	= "none"; 
					document.getElementsByName("irLayer")[1].style.display	= "inline"; 
					if ( sheetObjects[1].CellValue(1, "op_cost_ocp_flg"		    ) == 'Y' ) {
						document.getElementById("op_cost_ocp_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "op_cost_tnk_ord_flg"		) == 'Y' ) {
						document.getElementById("op_cost_tnk_ord_flg"		).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "op_cost_team_trkg_flg"	) == 'Y' ) {
						document.getElementById("op_cost_team_trkg_flg"		).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "op_cost_xtra_ft_flg"		) == 'Y' ) {
						document.getElementById("op_cost_xtra_ft_flg"		).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "op_cost_sptg_icrz_flg"	) == 'Y' ) {
						document.getElementById("op_cost_sptg_icrz_flg"		).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "op_cost_otr_tml_chss_flg") == 'Y' ) {
						document.getElementById("op_cost_otr_tml_chss_flg"	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "op_cost_mnr_flg"		    ) == 'Y' ) {
						document.getElementById("op_cost_mnr_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "op_cost_tri_axl_flg"		) == 'Y' ) {
						document.getElementById("op_cost_tri_axl_flg"		).checked	= true;
					}

				} else {
					document.getElementsByName("irLayer")[0].style.display	= "inline"; 
					document.getElementsByName("irLayer")[1].style.display	= "none";
					
					if ( sheetObjects[1].CellValue(1, "irr_stf_err_flg"		    ) == 'Y' ) {
						document.getElementById("irr_stf_err_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "irr_sys_err_flg"		    ) == 'Y' ) {
						document.getElementById("irr_sys_err_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "irr_chss_shtg_flg"		    ) == 'Y' ) {
						document.getElementById("irr_chss_shtg_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "irr_otr_flg"		    ) == 'Y' ) {
						document.getElementById("irr_otr_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "irr_late_dis_flg"		    ) == 'Y' ) {
						document.getElementById("irr_late_dis_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "irr_lack_of_flw_flg"		    ) == 'Y' ) {
						document.getElementById("irr_lack_of_flw_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "irr_cxl_wo_flg"		    ) == 'Y' ) {
						document.getElementById("irr_cxl_wo_flg"		  	).checked	= true;
					}
					if ( sheetObjects[1].CellValue(1, "irr_eq_shtg_flg"		    ) == 'Y' ) {
						document.getElementById("irr_eq_shtg_flg"		  	).checked	= true;
					}					
				}
				document.getElementById("dept_no"				  	).value	= sheetObjects[1].CellValue(1, "dept_no"				    );
				document.getElementById("cost_ofc_cd"				).value	= sheetObjects[1].CellValue(1, "dept_no"				    );
				document.getElementById("is_valid_dept_no"			).value	= "Y";
				document.getElementById("respb_pty_nm"			  	).value	= sheetObjects[1].CellValue(1, "respb_pty_nm"			    );
				document.getElementById("delt_flg"		          	).value	= sheetObjects[1].CellValue(1, "delt_flg"		            );
				
				document.getElementById("cre_usr_id"	          	).value	= sheetObjects[1].CellValue(1, "cre_usr_id"	                );
				document.getElementById("cre_dt"		          	).value	= sheetObjects[1].CellValue(1, "cre_dt"		                );

				document.getElementById("irr_no").readOnly	= true;
				document.getElementById("irr_no").className	= "input2";
				
				// fm_dt, to_dt CellHidden
				setTypeCntrDt();
				
				// Container Bkg No. List ComboBox 조회.
				for (var i = sheetObjects[0].HeaderRows; i < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++)
				{
					sheetObjects[0].CellComboItem(i, "bkg_no",sheetObjects[0].CellValue(i, "bkg_no_list_ctnt"), sheetObjects[0].CellValue(i, "bkg_no_list_ctnt") );
					sheetObjects[0].CellValue2(i, "bkg_no")	= sheetObjects[0].CellValue(i, "bkg_no2");
				}
				
				// Guarantee 에서 Container 조회온 경우 
				if ( document.getElementById("gnte_flg").value == 'Y' ) {
					// 모두 Editable false. ibflag = 'U'
					setEditable()
				
					// Irregular Header Amount 를 계산한다.
			    	document.getElementById("irr_ttl_amt").value = getShtTotAmt(sheetObjects[0], 'gnte_amt');
				}

				document.getElementById("retrieveFlg").value= "N";
				
	    	} else {
	    		// 조회건수가 없을경우 새로 생성할건지 Confirm.
	    		document.getElementById("regflag").value	= "Y";
	    		
				initFormHdr();		// Header Form Init.
				initFormCntrList();	// Container List Sheet Init.
	    	}
	    } else {
			ComShowMessage( errMsg );
	    }
	}

	/**
     * Guarantee 에서 Irregular 조회해온 경우 설정변경.
     **/
	function setEditable() {
		if ( document.getElementById("gnte_flg").value == 'Y' ) {
			for (var i = sheetObjects[0].HeaderRows; i < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++) {
				sheetObjects[0].RowStatus(i)	= "U";
				sheetObjects[0].RowEditable(i)	= false;
			}
			// Object 를 비활성화 한다. 저장시 활성화로 변경해줄것.
			ComEnableManyObjects(false
					, document.form.gnte_tp_cd
					, document.form.curr_cd
					, document.form.bkg_sts_cd
					);
		}
	}	
		
	
	/**
	 * sheet2 (Irregular Header Info ) 조회후 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{string}		errMsg		Error Message
	 */
	function sheet2_OnSaveEnd(sheetObj, errMsg){
	    var formObject = document.form;
	
	    if( errMsg == '' ) {
	    	// Header 저장후 Container List 저장
    		if ( formObject.f_cmd.value == ADD ) {
				document.getElementById("gnte_no").value	= sheetObj.EtcData("gnte_no");
				document.getElementById("irr_no").value		= sheetObj.EtcData("irr_no");
    		}
    		// Guarantee 에서 Irregular 저장시.
    		else if ( formObject.f_cmd.value == MULTI01 ) {
				document.getElementById("irr_no").value		= sheetObj.EtcData("irr_no");
    		}
    		
			doActionIBSheet1(sheetObjects[0], formObject, IBSAVE);

	    } else {
			ComShowMessage( errMsg );
	    }
	}

	
	/**
     * Form Object Irregular Value 초기화<br>
     **/
	function initFormHdr() {

		sheetObjects[1].RemoveAll();
		
		document.getElementById("irr_no").value		= "";
		document.getElementById("gnte_no").value	= "";
		document.getElementById("delt_flg").value	= "";
		document.getElementById("gnte_tp_cd").value	= "ST";
		document.getElementById("curr_cd").value	= "USD";

		document.getElementById("bkg_sts_cd").value		= "F";
		document.getElementById("irr_tp_cd").value		= "I";
		document.getElementById("dept_no").value		= "";
		document.getElementById("irr_ttl_amt").value	= "";
		document.getElementById("irr_rsn_rmk").value	= "";
		
		document.getElementById("irr_prvt_rmk").value			= "";
		document.getElementById("irr_stf_err_flg").checked		= false;
		document.getElementById("irr_late_dis_flg").checked		= false;
		document.getElementById("irr_sys_err_flg").checked		= false;
		document.getElementById("irr_lack_of_flw_flg").checked	= false;
		
		document.getElementById("irr_chss_shtg_flg").checked	= false;
		document.getElementById("irr_cxl_wo_flg").checked		= false;
		document.getElementById("irr_otr_flg").checked			= false;
		document.getElementById("irr_eq_shtg_flg").checked		= false;
		document.getElementById("op_cost_ocp_flg").checked		= false;
		
		document.getElementById("op_cost_sptg_icrz_flg").checked	= false;
		document.getElementById("op_cost_tnk_ord_flg").checked		= false;
		document.getElementById("op_cost_otr_tml_chss_flg").checked	= false;
		document.getElementById("op_cost_team_trkg_flg").checked	= false;
		document.getElementById("op_cost_mnr_flg").checked			= false;
		
		document.getElementById("op_cost_xtra_ft_flg").checked	= false;
		document.getElementById("op_cost_tri_axl_flg").checked	= false;
		document.getElementById("respb_pty_nm").value			= "";
		document.getElementById("ofc_cd").value					= document.getElementById("cre_ofc_cd").value;

		tes_getInputValue('DB_DATE', SEARCH06, '', 'setCreDate');
		irrTpCdChange();

		document.getElementById("irr_no").readOnly	= false;
		document.getElementById("irr_no").className	= "";

		// 저장 Flag 초기화
		document.getElementById("regflag").value	= "Y";
		
		document.getElementById("dmy_flg").value	= "";
	}

	
	/**
     * Form Object Irregular Value 초기화<br>
     **/
	function initFormCntrList() {
		sheetObjects[0].RemoveAll();
		
		sheetObjects[0].ColHidden("fm_dt") = false; 
		sheetObjects[0].ColHidden("to_dt") = false;
	}

	
	/**
	 * Reference No. 셋팅. <br>
	 * 
	 * @param{Array}		rowArray	rowArray
	 */
	function getRefNo(rowArray) {
		document.all.irr_no.value	= rowArray[0];
	}

	
	/**
     * irr_tp_cd(IRR Type) 가 'I'(Irregularity), 'O'(Operation Cost) 인 경우에따라 폼 변경.<br>
     **/
	function irrTpCdChange() {
		var	arrLayer	= document.getElementsByName("irLayer");
		
		if ( document.getElementById("irr_tp_cd").value == 'O' ) { 
			arrLayer[0].style.display	= "none";
			arrLayer[1].style.display	= "inline";
		} else {
			arrLayer[0].style.display	= "inline";
			arrLayer[1].style.display	= "none";
		}
	}
	
	/**
     * irr_tp_cd(IRR Type) 가 'I'(Irregularity), 'O'(Operation Cost) 인 경우에따라 저장 정보 설정 초기화.<br>
     **/
	function irrTpCdSaveInit() {
		var	arrLayer	= document.getElementsByName("irLayer");
		
		// Irregularity 일 경우 Operation Cost 초기화.
		if ( document.getElementById("irr_tp_cd").value == 'O' ) { 
			document.getElementById("irr_stf_err_flg").checked		= false;
			document.getElementById("irr_late_dis_flg").checked		= false;
			document.getElementById("irr_sys_err_flg").checked		= false;
			document.getElementById("irr_lack_of_flw_flg").checked	= false;
			document.getElementById("irr_chss_shtg_flg").checked	= false;

			document.getElementById("irr_cxl_wo_flg").checked	= false;
			document.getElementById("irr_otr_flg").checked		= false;
			document.getElementById("irr_eq_shtg_flg").checked	= false;
		} else {
			document.getElementById("op_cost_ocp_flg").checked			= false;
			document.getElementById("op_cost_sptg_icrz_flg").checked	= false;
			document.getElementById("op_cost_tnk_ord_flg").checked		= false;
			document.getElementById("op_cost_otr_tml_chss_flg").checked	= false;
			document.getElementById("op_cost_team_trkg_flg").checked	= false;

			document.getElementById("op_cost_mnr_flg").checked		= false;
			document.getElementById("op_cost_xtra_ft_flg").checked	= false;
			document.getElementById("op_cost_tri_axl_flg").checked	= false;
		}
	}
	
	
	/**
	 * sheet2 (Guarantee Header Info ) 조회후 프로세스 처리. <br>
	 * 
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{int,string}	colnm		Column Index
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
	
		tot_amt_val = Math.round(Number(tot_amt_val) * 10000) / 10000;
		tot_amt_val = tes_chkAmtFmt(tot_amt_val, document.form.curr_cd.Code);

		return tot_amt_val;
	}
	
	/**
     * 생성날짜 체크 설정.
     * 
     */
	function setCreDate() {
		/* 오늘 */
		var formObj = document.form;
		var cre_dt = new String(formObj.DB_DATE.value).substring(0, 8);
		
		if (cre_dt != undefined && cre_dt != null && cre_dt.trim() != '' && cre_dt.length == 8) {
			formObj.cre_dt.value = cre_dt.substring(0, 4) + '-' + cre_dt.substring(4, 6) + '-' + cre_dt.substring(6, 8);
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
     * TPB IF 된 대상의 Delete 여부 Check.
     * 
     */
	function checkNonTPB() {
		var arrTPB = document.getElementById("is_valid_TPB").value.split("|");
		var	delCnt = 0;
		// checkNonTPB ( 바로삭제 : Y, 삭제가능 : N, 삭제불가 : X, I/F대상없음 : O )
		// 건별 체크로 전부 되돌려 주는 건지 확인.
		for( var i = 0; i < arrTPB.length; i++ ) {
			if ( arrTPB[i] == "Y" ) {
				delCnt++;
			} else if ( arrTPB[i] == "N" ) {
				delNotCnt++;
//				ComShowCodeMessage('TES70114'); // 'The amount has been interfaced to TPB.';
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
			ComShowCodeMessage('TES70114'); // 'The amount has been interfaced to TPB.';
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
			tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', '');
		// ( New Guarantee 면 Container Info 자동 입력.)
		} else {
			tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp', 'searchCntrInfo', sheetObj);
		}
	}
	
	/**
	 * Container No. BKG No. List 조회. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function searchBkgNoList2(row,cntr) {
		// container bkg no inquiry
		document.getElementById("cntr_no_tmp").value	= cntr;
				
		// BKG No.를 조회  ComboBox 설정. 
		// ( Retrieve Guarantee 면 Container Info 조회된 것으로 입력.)
		tes_getComboItemGuarantee('bkg_no_list', row, SEARCH05, '', 'cntr_no_tmp|cre_flg', 'searchCntrInfo');
	}
		
	 /**
	 * Master Container 테이블에서 CNTR 존재하는지 여부 조회. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function searchMstCntrExist(sheetObj, row, retrieveFlg) {
		var formObj = document.form;
		var tmp = '';
		var mstCntr= false;
		
		document.getElementById("cntr_no_tmp").value = sheetObj.CellValue(row, "cntr_no");
		
		tes_getInputValueGuarantee('mst_cntr_exist', SEARCH08, 'cntr_no_tmp', 'searchMstCntrExist2');
		
		tmp = formObj.mst_cntr_exist.value;
		
	}

	/**
	 * Master Container 테이블에서 CNTR 존재하는지 여부 조회. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function searchMstCntrExist2() {
		 var formObj = document.form;
		//tmp  = document.form.mst_cntr_exist.value;
		row  = document.getElementById("rowId").value;
		cntr = document.getElementById("cntr_no_tmp").value;
		tmp = formObj.mst_cntr_exist.value.split('|');
		
		if (tmp != null && tmp[0] == 'Y') {
			searchBkgNoList2(row,cntr);
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_tpsz_cd")	= (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
		}else {
			mstCntr = ComShowConfirm("Attention! \nThe container is not operated by SML. Do you want to input it ?");

			if (mstCntr == true){
				searchBkgNoList2(row,cntr);
			} else {
				sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_no") = "";
			}
		}
	}	 
	 
	/**
	 * Container No. BKG No. 조회후 Container Info 조회. <br>
	 * 
	 */
	function searchCntrInfo(){
		if (sheetObjects[0].CellValue( document.getElementById("rowId").value, "bkg_no")=='N/A'){			
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "gnte_amt")		= 0;
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bl_no")		= "N/A";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "vvd_cd")		= "N/A";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "sc_no")		= "N/A";
		} else if ( !ComIsNull( sheetObjects[0].CellValue( document.getElementById("rowId").value, "bkg_no") ) ) {
			//Container no 로 조회된 BKG No.가 있으면 Container Info 조회 
			document.getElementById("bkg_no_tmp").value	= sheetObjects[0].CellValue( document.getElementById("rowId").value, "bkg_no");
			tes_getInputValueGuarantee('is_valid_cntr_info', SEARCH01, 'cntr_no_tmp|bkg_no_tmp', 'checkValidCntrInfo');		
		}else {
			//Container No. 의 BKG No.가 없는 경우 초기화.
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "cntr_tpsz_cd")	= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bkg_no")		= "";
			sheetObjects[0].CellValue2( document.getElementById("rowId").value, "bl_no")		= "";
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
	 * Print에 앞서 Irregular에 CNTR이 있을 경우만 Print 되도록 하기 위함
	 * @return
	 */
	function irrInqPrintChk() {
		if ( (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount) <= 1 ) {
			ComShowCodeMessage('TES21017'); // 'There is no data.';
			return false;
		}
		else {
			if (document.form.is_valid_print.value == "N") {
			ComShowCodeMessage('TES21017');		// 'There is no data.'
			return false;
			}
		
		var url_str = 'ESD_TES_2009.screen';
		url_str = url_str + '?pgmNo=ESD_TES_2009';
		url_str = url_str + '&irr_no=' + document.form.irr_no_hidden.value;
		window.showModalDialog(url_str, window, "dialogWidth:900px; dialogHeight:700px; help:no; status:no; resizable:yes;");
		}
	}

	/* 개발자 작업  끝 */