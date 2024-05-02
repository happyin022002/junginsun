/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2007.js
*@FileTitle : Irregular Inquiry
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
     * @class ESD_TES_2007 : ESD_TES_2007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TES_2007() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab1 = 1;
var beforetab2 = 1

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
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
	
				case "btn_retrieve":
					if(formObject.cost_ofc_cd.value != "" ){
						formObject.ofc_cd.value = formObject.cost_ofc_cd.value;
					}else{
						formObject.ofc_cd.value = "";
					}
					
					/*if (ComIsNull( formObject.irr_no.value ) &&
						ComIsNull( formObject.cost_ofc_cd.value ) &&		
						ComIsNull( formObject.cre_usr_id.value )
					) {
						ComShowCodeMessage('TES70201');    // Please enter Item.
						return false;
					}
					*/
					/*if ( ( formObject.ofc_cd.value != formObject.cost_ofc_cd.value) ) {
//						ComShowCodeMessage('TES70205');    // Check Vaild Office Code.
						return false;
					}*/
					
					// p_date1과 p_date2가 6개월이 넘으면 return
                    if (ComGetUnMaskedValue(ComGetDateAdd(formObject.fm_cre_dt.value, "M", 6), "ymd") < ComGetUnMaskedValue(formObject.to_cre_dt.value, "ymd")) {
                        ComShowCodeMessage("TES70702", "6 months");
                        formObject.fm_cre_dt.focus();
                        return;
                    }
                    
					if (ComIsNull( formObject.fm_cre_dt.value ) ) {
						ComShowCodeMessage('TES21903'); // ComShowMessage("조회조건 : 시작 날짜를 입력하세요.");
						return false;
					}
						
					if (ComIsNull( formObject.to_cre_dt.value ) ) {
						ComShowCodeMessage('TES21904'); // ComShowMessage("조회조건 : 마지막 날짜를 입력하세요.");
						return false;
					}

					if (!tes_validateDateObj(formObject.fm_cre_dt)) {
						ComShowCodeMessage('TES23011'); // ComShowMessage('날짜 형식이 잘못되었습니다.');
						formObject.fm_cre_dt.focus();
						return false;
					}
					
					if (!tes_validateDateObj(formObject.to_cre_dt)) {
						ComShowCodeMessage('TES23011'); // ComShowMessage('날짜 형식이 잘못되었습니다.');
						formObject.to_cre_dt.focus();
						return false;
					}
					
					if ( ComGetDaysBetween(formObject.fm_cre_dt, formObject.to_cre_dt) < 0 ) {
						ComShowCodeMessage('TES24012'); // Start date must be earlier than end date.
						return false;
					}
					
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
	
				case "btn_new":
					initForm();
					break; 
	
				case "btn_guarantee":
					// Guarantee 생성화면으로 이동
					// Select Row Guarantee No. Guarantee 생성화면으로 이동
					var	selectRow	= sheetObject1.SelectRow;
					if ( sheetObject1.CellValue(selectRow, "dmy_flg") == 'Y'  ) {
						ComShowCodeMessage('TES70701'); // This Is Not A Guarantee.
						return false;
					}
					
					if ( sheetObject1.RowCount >= 1 && !ComIsNull( sheetObject1.CellValue(selectRow, "gnte_no") ) ) {
						var gnteUrl = "ESD_TES_2001.do?pgmNo=ESD_TES_2001&inq_flg=Y"
							+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)
							+ "&gnte_no="	+ sheetObject1.CellValue(selectRow, "gnte_no")
							;
						window.location.replace(gnteUrl);
					}
					break;
	
				case "btn_irregular":
					
					// Irregular 생성화면으로 이동
					// Select Row Irregular No. Irregular 생성화면으로 이동
					var	selectRow	= sheetObject1.SelectRow;
					
					if ( sheetObject1.RowCount >= 1 && !ComIsNull( sheetObject1.CellValue(selectRow, "irr_no") ) ) {
						var gnteUrl = "ESD_TES_2006.do?pgmNo=ESD_TES_2006&inq_flg=Y"
							+((pre_ret_cond_val!=null&pre_ret_cond_val.trim()!=''?'&':'')+pre_ret_cond_val)
							+ "&irr_no="	+ sheetObject1.CellValue(selectRow, "irr_no")
							+ "&gnte_no="	+ sheetObject1.CellValue(selectRow, "gnte_no")
							;
						window.location.replace(gnteUrl);
					}
					break; 
					
				case "btn_downexcel":
					// sheet ( Container List ) Excel Down
                    doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);

					break;

					
				case "btn_print":
					// Irregular 생성 내용 Report Designer 출력
					var	selectRow	= sheetObject1.SelectRow;
					
//					if ( sheetObject1.CellValue(selectRow, "dmy_flg") != 'Y'  ) {
//						alert("This Is Not An Irregular"); // This Is Not A Irregular.
//						return false;
//					}
					
					if ( (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount) <= 1 ) {
						ComShowCodeMessage('TES21017'); // 'There is no data.';
						return false;
					}
					else {
						document.form.irr_no_hidden.value = sheetObject1.CellValue(selectRow, "irr_no");
						tes_getInputValueGuarantee('is_valid_print', SEARCH07, 'irr_no_hidden', 'irrInqPrintChk');
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
					
//					window.showModalDialog("ESD_TES_2007.do", window, "dialogWidth:410px; dialogHeight:650px; help:no; status:no; resizable:yes;");
//					break;
					
				case "btn_custcd":
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
					var classId = "COM_ENS_041";
					var param = '?classId='+classId;
					var chkStr = dispaly.substring(0,3)
					
					// radio PopUp
					if(chkStr == "1,0") {
						ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 430, 'getYard', dispaly);
						
					} else {
						ComShowCodeMessage('TES10004');   //There is lack of data for pop-up display.
						return;
					}
					break;

				case "btns_calendar1":
					var cal = new ComCalendar();	//calendarPopup();
					cal.select(formObject.fm_cre_dt, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.select(formObject.to_cre_dt, 'yyyy-MM-dd');
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
	
		initForm();
		
		document.getElementById("irr_no").focus();
		
		/**
 		 * 	2012-01-15 : 조회 조건 - 조회 화면 이동시 재조회하기 추가
 		 *  조회 화면에서 이동해 왔을 경우 바로 다시 조회 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위한 값들. (2009-10-15)
 		 */
 		 try {
 			 pre_ret_cond_val = '';
 			 var retrieve_tf = false;
 			 var formObj = document.form;
 			 for (var i = 0; i < formObj.elements.length; i++){
 				 if (formObj.elements[i].name != null && formObj.elements[i].name.trim() != '' && 
 				     formObj.elements[i].name.substring(0,9) == 'pre_cond_')
 				 {
 					 with (formObj) {
 						 if (eval((elements[i].name)).value != null && eval((elements[i].name)).value != '') {
 							 eval(elements[i].name.substring('pre_cond_'.length,elements[i].name.length)).value = eval(elements[i].name).value;
 							 if (!retrieve_tf) {retrieve_tf = true;}
 						 }
 					 }
 				 }
 			 }
 			 
 			 if (retrieve_tf) {retrieve();}
 		 } catch(e){}
		
	}
	
	/**
	 * 조회
	 * @return
	*/
	function retrieve(){
		
		document.form.ofc_cd.value = document.form.cost_ofc_cd.value;
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
	}
	 
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * 시트가 다수일 경우 시트 수만큼 case 를 추가하여 시트 초기화모듈을 구성한다
	 * 
	 * @param {ibsheet}  	sheetObj	Sheet Object
	 * @param {int,String} 	sheetNo		Sheet Object 태그의 아이디에 붙인 일련번호
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
				with (sheetObj) {

					// 높이 설정
					style.height = 324;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 1000);
						       

					var HeadTitle1	= "|Seq.|REF No.|TPB|Container No.|SZ|Type|Irr Type|Reason|BL No.|SC No.|From DT|To DT|"
									+ "Amount|U.User ID|U.User Name|U.Date|SE|ST|CS|EF|OT|LD|"
									+ "LF|CW|ES|OC|TO|TT|SP|TC|MR|TR|Gnte No|DMY FLG";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,		40,			daCenter,	true,		"",					false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"irr_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	true,		"chk_tpb_if",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"cntr_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,			daCenter,	true,		"cntr_tpsz_cd",		false,		"",				dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		50,			daCenter,	true,		"gnte_tp_cd",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,			daCenter,	true,		"irr_tp_cd",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"irr_rsn_rmk",		false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"bl_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"sc_no",			false,		"",				dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"fm_dt",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"to_dt",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"gnte_amt",			false,      "",				dfFloat,	2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"cre_usr_id",		false,		"",				dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"usr_nm",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		110,		daCenter,	true,		"cre_dt",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_stf_err_flg",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_sys_err_flg",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_chss_shtg_flg",	false,		"",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_otr_flg",			false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_late_dis_flg",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_lack_of_flw_flg",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_cxl_wo_flg",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"irr_eq_shtg_flg",		false,		"",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_ocp_flg",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_tnk_ord_flg",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_team_trkg_flg",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_xtra_ft_flg",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_sptg_icrz_flg",	false,		"",				dfNone,		0,			false,		false);

					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_otr_tml_chss_flg",	false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_mnr_flg",			false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"op_cost_tri_axl_flg",		false,		"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	110,		daCenter,	true,		"gnte_no",			false,      "",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	110,		daCenter,	true,		"dmy_flg",			false,      "",				dfNone,		0,			false,		false);

					CountPosition = 0;
				}
				break;
		}
	}
	
	/**
	 * 첫번째(Coincidence) 탭의 sheet OnMouseMove Event
	 * @param {ibsheet}	sheet1	Coincidence) 탭의 sheet
	 * @param {int}	Button	마우스버튼 방향, 1:왼쪽, 2:오른쪽
	 * @param {int}	Shift	해당 셀의 Column Index
	 * @param {Long}	X	X좌표
	 * @param {Long}	Y	Y좌표
	 * @return
	 */
	function sheet1_OnMouseMove(sheet1, Button, Shift, X, Y){
		
		var row = sheet1.MouseRow;
		var col = sheet1.MouseCol;
		if (sheet1.ColSaveName(col) == "irr_rsn_rmk" && row >= 1 && sheet1.CellValue(row,"irr_rsn_rmk")!=null && sheet1.CellValue(row,"dscr_ind_cd")!=''){
			sheet1.ToolTipText(row,col) = tes_getInvVerifyResultFullNm(sheet1.CellValue(row,"irr_rsn_rmk"));
		}
	}
	
    /**
     * IBSheet 관련 프로세스 처리.<br>
     * 
     * @param {ibsheet}		sheetObj	IBSheet Object
     * @param {Object}		formObj		Form Object
     * @param {String}		sAction		Action Command
     */	
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	
    	switch(sAction) {
	    	case IBSEARCH:      // 조회
	    		formObj.f_cmd.value = SEARCH;
    	 		var sXml = sheetObj.DoSearch4Post("ESD_TES_2007GS.do", tesFrmQryStr(formObj) );
    	 		sheetObj.LoadSearchXml(sXml, false);

//    			document.getElementById("ttl_cnt").value = sheetObj.EtcData("ttlCnt");
//    			document.getElementById("ttl_amt").value = sheetObj.EtcData("ttlAmt");
	    		break;
	    		
	    	case IBDOWNEXCEL:	// 엑셀 다운로드
	    		sheetObj.SpeedDown2Excel(-1);
	    		break;
    	}
    }
    	
    
    
	/**
	 * Reference No 셋팅. <br>
	 * 
	 * @param{Array}		rowArray	rowArray
	 */
	function getRefNo(rowArray) {
		document.all.irr_no.value	= rowArray[0];
	}

	
	/**
     * Form Object Header Value 초기화<br>
     **/
	function initForm() {
    	 
    	if(document.form.pre_cond_fm_cre_dt.value == ""){
    		tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
    	}
    	
		document.getElementById("irr_no").value		= "";
		document.getElementById("ofc_cd").value		= document.getElementById("cre_ofc_cd").value;
		document.getElementById("cre_usr_id").value	= "";
		document.getElementById("gnte_tp_cd").value	= "";
		
		sheetObjects[0].RemoveAll();
	}

	
	/**
     * 기간체크 함수
     * 
     */
	function setPeriodFromTo(){
		/* from 한달전 ~ to 오늘 */
		var formObj = document.form;
		var to_dt = new String(formObj.DB_DATE.value).substring(0, 8);
		var fr_dt;
		
		if (to_dt != undefined && to_dt != null && to_dt.trim() != '' && to_dt.length == 8) {
			//fr_dt = tes_getDiffDate(to_dt, -30, 'D');
			fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6,8);
			
			if (fr_dt != undefined && fr_dt != null && fr_dt.trim() != '' && fr_dt.length == 8) {
				
				if (fr_dt.substring(6, 8) > ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10))){
					fr_dt = fr_dt.substring(0, 6) + ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10));
				}
				
				formObj.fm_cre_dt.value = fr_dt.substring(0, 4) + '-' + fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
				formObj.to_cre_dt.value = to_dt.substring(0, 4) + '-' + to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
			}
		}
	}

    /**
	 * 입력된 Office Code Validation Check 함수
	 *
	 */
	function validateDeptNo() {
		var formObj = document.form;
		if (formObj.ofc_cd.readOnly == false && formObj.cost_ofc_cd.value != "" ) {
			if ((formObj.ofc_cd.value == null || formObj.ofc_cd.value.trim() == '') ||
				formObj.ofc_cd.value != formObj.cost_ofc_cd.value ) {
				tes_getInputValue('is_valid_ofc_cd', SEARCH04, 'cost_ofc_cd|yd_cd', 'checkValidDeptNo');
			}
		}
	}

	
	/**
	 * 설명 : Office Code Validation Check 함수
	 * 사용 :
	 */
	function checkValidDeptNo(){
		var formObj = document.form;
		var tmp = '';
		if (formObj.is_valid_ofc_cd.value != undefined && formObj.is_valid_ofc_cd.value != null &&
			formObj.is_valid_ofc_cd.value.trim() != '' ){
			tmp = formObj.is_valid_ofc_cd.value.split('|');
			if (tmp.length > 0){
				formObj.is_valid_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
				if (formObj.is_valid_ofc_cd.value != null && formObj.is_valid_ofc_cd.value == 'Y'){
					formObj.ofc_cd.value	= document.getElementById("cost_ofc_cd").value;
				} else {
					formObj.is_valid_ofc_cd.value = '';
					formObj.cost_ofc_cd.value = '';
					formObj.ofc_cd.value = '';
					ComShowCodeMessage('TES70204');	// This is invalid Office Code.
				}
			} else {
				formObj.is_valid_ofc_cd.value = '';
				formObj.cost_ofc_cd.value = '';
				formObj.ofc_cd.value = '';
				ComShowCodeMessage('TES70204');	// This is invalid Office Code.
			}
		} else {
			formObj.is_valid_ofc_cd.value = '';
			formObj.cost_ofc_cd.value = '';
			formObj.ofc_cd.value = '';
			ComShowCodeMessage('TES70204');	// This is invalid Office Code.
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
	
	 /**
     * Sheet 선택
     * param : sheetObj ==> 시트오브젝트
     * @param(ibsheet) 	sheetObj 		IBSheet Object
     * @return
     */  
    function sheet1_OnSearchEnd(sheetObj){
     	if (sheetObj.RowCount > 0) {
    		/**
    		 * 조회 조건으로 조회가 성공적으로 된 경우만 pre_cond 조건에 넣는다.
    		 */
    		pre_ret_cond_val = getPreviousRetreiveCondition();
    	}
    }
	
	/**
	 * pre_cond 조건 가져오기
	 * @return 
	*/
	function getPreviousRetreiveCondition(){
		 var retval = '';
		 if (document.form.irr_no.value!=null && document.form.irr_no.value.trim()!=''){
				retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_irr_no="+document.form.irr_no.value;
		}
		if (document.form.ofc_cd.value!=null && document.form.ofc_cd.value.trim()!=''){
			retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_cost_ofc_cd="+document.form.ofc_cd.value;
		}
		if (document.form.cre_usr_id.value!=null && document.form.cre_usr_id.value.trim()!=''){
			retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_cre_usr_id="+document.form.cre_usr_id.value;
		}
		if (document.form.gnte_tp_cd.value!=null && document.form.gnte_tp_cd.value.trim()!=''){
			retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_gnte_tp_cd="+document.form.gnte_tp_cd.value;
		}
		if (document.form.fm_cre_dt!=undefined && document.form.fm_cre_dt.value!=null && document.form.fm_cre_dt.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_fm_cre_dt="+document.form.fm_cre_dt.value;
    	}
    	if (document.form.to_cre_dt!=undefined && document.form.to_cre_dt.value!=null && document.form.to_cre_dt.value.trim()!=''){
    		retval += (retval!=null && retval.trim()!='' ? '&' : '') + "pre_cond_to_cre_dt="+document.form.to_cre_dt.value;
    	}
		
	 	return retval;
	}
     
	/* 개발자 작업  끝 */