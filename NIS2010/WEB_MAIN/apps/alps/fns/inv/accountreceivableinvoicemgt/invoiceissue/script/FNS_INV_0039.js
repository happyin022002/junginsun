/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0039.js
*@FileTitle : (Korea) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.04 박정진
* 1.0 Creation
*--------------------------------------------------------
* History
* 2013.05.27 김현화[CHM-201324849]ALPS 데이터품질 - INV validation 로직보완: Email 형식 Check
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	/**
	 * @extends 
	 * @class fns_inv_0039 : fns_inv_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0039() {
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
	var IBREQUEST = 21;
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	//RD
    var rdObjects = new Array();
	var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];
		/*******************************************************/
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btns_cust": //CUST 조회버튼
					var v_cust_cnt_cd = formObj.act_cust_cnt_cd.value;
					var v_cust_seq = formObj.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				case "btns_cust2": //CUST 조회버튼
					var v_cust_rgst_no = formObj.cust_rgst_no.value;
					var office = formObj.ofc_cd.Text;

					var classId = "FNS_INV_0086";
					var param = '?cust_rgst_no='+v_cust_rgst_no+'&pop_yn=Y&classId='+classId;
			
					//ComOpenWindow('/hanjin/FNS_INV_0086.do' + param, 'getFNS_INV_0086', 'width=900,height=650');
					ComOpenPopup('/hanjin/FNS_INV_0086.do?cust_rgst_no='+v_cust_rgst_no+'&office='+office, 910, 450, 'getFnsInv0086', '1,0,1,1,1', false, false);
				break;
				case "btns_calendar": //달력버튼
					if(formObj.btns_calendar.disabled == true){
						return false;
					}
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObj.iss_dt, 'yyyy-MM-dd');
	            break;
				
				case "btn_retrieve":
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
				break;
					
				case "btn_new":
					removeAll(formObj);
					initSheet(sheetObj2,2);
					doActionIBSheet(sheetObj1, formObj, IBSEARCH_ASYNC10);
				break;
				
				case "btn_print":
					formObj.send_flg.value = "P";
					
					doActionIBSheet(sheetObj1,formObj,IBINSERT);
				break;
					
//				case "btn_reissue":
//					doActionIBSheet(sheetObj1,formObj,IBSAVE);
//				break;
				
				case "btn_fax":
					sendFaxEml(sheetObj1,formObj,'F');
				break;
				
				case "btn_eml":
					sendFaxEml(sheetObj1,formObj,'E');
				break;
				
				case "btn_add":
					sheetObj1.DataInsert(-1);					
					sheetObj1.SelectCell(sheetObj1.SelectRow,1);
					sheetObj2.RemoveAll();
				break;
				
				case "btn_delete":
					if(ComShowCodeConfirm("INV00028")){
						//main 그리드 삭제시 main 그리드와 chareg 그리드, 통합 charge 그리드의 선택된 B/L NO를 삭제한다.
						delMainSheet(sheetObj1.SelectRow);
		    			//선택한 B/L No의 charge list에 대한 소계를 구한다.
		    			calChargeSum(sheetObj2);
		    			//B/L COUNT와 TOTAL AMT(KRW)을 계산한다.
		    			calTotalSum();
					}
				break;
				case "btn_add2":
					//var bl_src_no = sheetObj1.CellText(1,1);
					var bl_src_no = sheetObj1.CellText(sheetObj1.SelectRow,1);
					if(bl_src_no == ""){
						ComShowCodeMessage("INV00041","[B/L NO.]");
						sheetObj1.SelectCell(1,1);
						return false;
					}
					sheetObj2.DataInsert(-1);
					sheetObj2.SelectCell(sheetObj2.SelectRow,2);
					sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_chg_cd') = true;
					sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_curr_cd') = true;
					//sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_chg_amt') = true;
					sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_trf_rt_amt') = true;
					sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_rat_as_cntr_qty') = true;
					sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_per_tp_cd') = true;
					//sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_iss_amt') = true;
					sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_inv_xch_rt') = true;
					var arrStr2 = formObj.ofc_cd.Code.split("^");
		   			var curr_cd = arrStr2[4];
		   			sheetObj2.CellText(sheetObj2.SelectRow,"sheet2_ar_curr_cd") = curr_cd;		   			
		   			sheetObj2.CellText(sheetObj2.SelectRow,"sheet2_bl_src_no") = bl_src_no;
		   			var chg_seq = sheetObj2.CellText(sheetObj2.RowCount-1,"sheet2_chg_seq")
		   			
		   			if(chg_seq == "") chg_seq = "0";
		   			sheetObj2.CellText(sheetObj2.SelectRow,"sheet2_chg_seq") = Number(chg_seq)+1;
					//sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_ar_curr_cd') = true;
					//sheetObj2.CellEditable(sheetObj2.SelectRow,'sheet2_locl_amt') = true;
		   			var selRow = sheetObj3.DataInsert(-1);
		   			sheetObj3.CellText(selRow,"sheet3_chg_seq") = Number(chg_seq)+1;
		   			sheetObj3.CellText(selRow,"sheet3_bl_src_no") = bl_src_no;

					sheetObj2.CellText(sheetObj2.SelectRow, "sheet2_ar_ofc_cd") = formObj.ofc_cd.Text;
		   			
				break;
				
				case "btn_delete2":
						//main 그리드 삭제시 main 그리드와 chareg 그리드, 통합 charge 그리드의 선택된 B/L NO를 삭제한다.
						var chg_seq = sheetObj2.CellText(sheetObj2.SelectRow,"sheet2_chg_seq");						
						
						sheetObj2.RowDelete();
						for (var i=1; i<=sheetObjects[2].RowCount; i++) {							
							if(chg_seq == sheetObjects[2].CellText(i,"sheet3_chg_seq")){
								sheetObjects[2].RowDelete(i, false);
							}
						}
						//sheetObject3.RowDelete();
		    			//선택한 B/L No의 charge list에 대한 소계를 구한다.
		    			calChargeSum(sheetObj2);
		    			//B/L COUNT와 TOTAL AMT(KRW)을 계산한다.
		    			calTotalSum();
				break;
			} // end switch
		}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}
	
	/**
	 * Quick Customer Search 팝업에서 호출하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     getFnsInv0086()
	 * </pre>
	 * @param rowArray
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */    
	function getFnsInv0086(rowArray) {
	
		var colArray = rowArray[0];		
		var formObject = document.form;
	
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	
	}    
	
	/** 
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function loadPage() {
		var formObj = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
		
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		//RD
		initRdConfig(rdObjects[0]);
		
		formObj.ofc_cd.Enable = false;
	}
	
	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObj = document.form;
		
		var cnt = 0;
		var currPoint = formObj.dp_prcs_knt.value;
		var fCmd = formObj.f_cmd.value;
		var updEdit = false;
		// 조회시는 그리드 입력,수정을 막는다
		if (fCmd == '2') {
			updEdit = false; 
		}
		else {
			updEdit = true; 
		}
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 125;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					var HeadTitle = "|B/L No.|BKG No.|Local VVD|S/A Date|Bound|Port|polCd|podCd|Ex.Rate";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//InitHeadMode(true, true, true, true, false,false);
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix="sheet1_";
					
					//데이터속성          [ROW, COL,   DATATYPE,      WIDTH,   DATAALIGN, COLMERGE, SAVENAME,    KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,	true,	prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,   		 95,    daCenter,	true,	prefix + "bl_src_no",	true,		"",		dfNone,		0,	false,		true,		12);
					InitDataProperty(0, cnt++ , dtData,    		100,    daCenter,	true,	prefix + "bkg_no",		false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 80,	daCenter,	true,	prefix + "vvd",			false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 70,	daCenter,	true,	prefix + "sail_arr_dt",	false,		"",		dfDateYmd,	0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,    		 50,	daCenter,	true,	prefix + "io_bnd_cd",	false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,    		 50,	daCenter,	true,	prefix + "port",		false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		 50,	daCenter,	true,	prefix + "pol_cd",		false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		 50,	daCenter,	true,	prefix + "pod_cd",		false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,  		 60,	daRight,	true,	prefix + "usd_xch_rt",	false,		"",		dfNone,		0,	false,		false);
					
					InitDataValid(0,		prefix + "bl_src_no",	vtEngUpOther,	"0123456789");	// 영대문자, 숫자만 입력되도록 설정
				
					CountPosition = 0;
				}
			break;
			case 2:      //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 127;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
				
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
				
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
				
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
				
					var HeadTitle = "|Office|CHG|Curr|Invoice Total|Rate|Rated As|Per|Issue Amount|Ex.Rate|AR Curr|Local Amount|B/L No|I/F No|I/F SER No|charge seq";
					var headCount = ComCountHeadTitle(HeadTitle);
				
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix2="sheet2_";
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if (currPoint > 0) {
						InitDataProperty(0, cnt++ , dtHiddenStatus, 45,		daCenter,	false,	prefix2 + "ibflag");	
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix2 + "ar_ofc_cd",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtComboEdit,    	70,    	daCenter,  	false,	prefix2 + "chg_cd",   			true,    "",    dfNone,			0,     false,       false,	3);
						InitDataProperty(0, cnt++ , dtComboEdit,			75,		daCenter,	false,	prefix2 + "curr_cd",		true,    "",	dfNone,			0,		false,	false, 3);
						InitDataProperty(0, cnt++ , dtData,			115,	daRight,	false,	prefix2 + "chg_amt",		false,    "",	dfNullFloat,		2,	false,	false);
						InitDataProperty(0, cnt++ , dtData,			115,	daRight,	false,	prefix2 + "trf_rt_amt",		true,    "",	dfNullFloat,		2,	updEdit,	false);

						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix2 + "rat_as_cntr_qty",true,    "",	dfFloat, 		3,		updEdit,	false);
						InitDataProperty(0, cnt++ , dtComboEdit,			65,		daCenter,	false,	prefix2 + "per_tp_cd",		true,    "",	dfNone,			0,		updEdit,	false, 2);
						InitDataProperty(0, cnt++ , dtData,			125,	daRight,	false,	prefix2 + "iss_amt",		false,    "",	dfNullFloat,		2,		false,	false);
						InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,	prefix2 + "inv_xch_rt",		true,    "",	dfNullFloat, 	6,		updEdit,	false);
						InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	prefix2 + "ar_curr_cd",		true,    "",	dfNone,			0,		false,	false);
						
						InitDataProperty(0, cnt++ , dtData,			105,	daRight,	false,	prefix2 + "locl_amt",		false,    "",	dfInteger,		0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "bl_src_no",		false,    "",	dfNone,			0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "ar_if_no",		false,    "",	dfNone,			0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "ar_if_ser_no",	false,    "",	dfNone,			0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "chg_seq",		false,    "",	dfNone,			0,		false,	false);
					}
					else {
						InitDataProperty(0, cnt++ , dtHiddenStatus, 45,		daCenter,	false,	prefix2 + "ibflag");
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix2 + "ar_ofc_cd",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtComboEdit,    	70,    	daCenter,  	false,	prefix2 + "chg_cd",   			true,    "",    dfNone,			0,     false,       false,	3);
						InitDataProperty(0, cnt++ , dtComboEdit,			75,		daCenter,	false,	prefix2 + "curr_cd",		true,    "",	dfNone,			0,		false,	false, 3);
						InitDataProperty(0, cnt++ , dtData,			115,	daRight,	false,	prefix2 + "chg_amt",		false,    "",	dfNullFloat,		2,		false,	false);
						InitDataProperty(0, cnt++ , dtData,			115,	daRight,	false,	prefix2 + "trf_rt_amt",		true,    "",	dfNullFloat,		2,		updEdit,	false);
						
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix2 + "rat_as_cntr_qty",true,    "",	dfFloat, 		3,		updEdit,	false);
						InitDataProperty(0, cnt++ , dtComboEdit,			65,		daCenter,	false,	prefix2 + "per_tp_cd",		true,    "",	dfNone,			0,		updEdit,	false,	2);
						InitDataProperty(0, cnt++ , dtData,			125,	daRight,	false,	prefix2 + "iss_amt",		false,    "", 	dfNullFloat, 		2,		false,	false);
						InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,	prefix2 + "inv_xch_rt",		true,    "",	dfNullFloat, 	6,		updEdit,	false);
						InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	prefix2 + "ar_curr_cd",		true,    "",	dfNone,			0,		false,	false);
						
						InitDataProperty(0, cnt++ , dtData,			105,	daRight,	false,	prefix2 + "locl_amt",		false,    "", 	dfInteger,		0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "bl_src_no",		false,    "",	dfNone,			0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "ar_if_no",		false,    "",	dfNone,			0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "ar_if_ser_no",	false,    "",	dfNone,			0,		false,	false);
						InitDataProperty(0, cnt++ , dtHidden,		45,		daCenter,	false,	prefix2 + "chg_seq",		false,    "",	dfNone,			0,		false,	false);
					}
					
					InitDataValid(0,		prefix2 + "per_tp_cd",	vtEngUpOther,	"0123456789");	// 영대문자, 숫자만 입력되도록 설정
					
					InitDataValid(0,    prefix2 + "chg_cd",   vtEngUpOther, "1234567890/");					
					//InitDataValid(0,    prefix2 + "curr_cd",   vtEngUpOther, "1234567890");
					//InitDataValid(0,    prefix2 + "per_tp_cd",   vtEngUpOther, "1234567890");
					
					CountPosition = 0;					
				}
			break;
			case 3:      //sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = 230;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
				
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
				
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
				
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
				
					var HeadTitle = "|Office|CHG|Curr|Invoice Total|Rate|Rated As|Per|Issue Amount|Ex.Rate|AR Curr|Local Amount|B/L No|I/F No|I/F SER No|charge seq";
					var headCount = ComCountHeadTitle(HeadTitle);
				
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix="sheet3_";
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					if (currPoint > 0) {
						InitDataProperty(0, cnt++ , dtHiddenStatus, 45,		daCenter,	false,	prefix + "ibflag");
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix + "ar_ofc_cd",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix + "chg_cd",			false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	prefix + "curr_cd",			false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "chg_amt",			false,    "",	dfNullFloat, 	2,	false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "trf_rt_amt",		false,    "",	dfNullFloat, 	2,	false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			75,		daRight,	false,	prefix + "rat_as_cntr_qty",	false,    "",	dfFloat, 	3,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix + "per_tp_cd",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "iss_amt",			false,    "",	dfNullFloat, 	2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			85,		daRight,	false,	prefix + "inv_xch_rt",		false,    "",	dfFloat, 	6,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	prefix + "ar_curr_cd",		false,    "",	dfNone,		0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "locl_amt",		false,    "",	dfInteger,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "bl_src_no",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "ar_if_no",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "ar_if_ser_no",	false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "chg_seq",			false,    "",	dfNone,		0,		false,		false);
					}
					else {
						InitDataProperty(0, cnt++ , dtHiddenStatus, 45,		daCenter,	false,	prefix + "ibflag");
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix + "ar_ofc_cd",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix + "chg_cd",			false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	prefix + "curr_cd",			false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "chg_amt",			false,    "",	dfNullFloat,	2,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "trf_rt_amt",		false,    "",	dfNullFloat,	2,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			75,		daRight,	false,	prefix + "rat_as_cntr_qty",	false,    "",	dfFloat, 	3,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	prefix + "per_tp_cd",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "iss_amt",			false,    "",	dfNullFloat, 	2,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			85,		daRight,	false,	prefix + "inv_xch_rt",		false,    "",	dfFloat, 	6,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	prefix + "ar_curr_cd",		false,    "",	dfNone,		0,		false,		false);
						
						InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,	prefix + "locl_amt",		false,    "",	dfInteger,	0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "bl_src_no",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "ar_if_no",		false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "ar_if_ser_no",	false,    "",	dfNone,		0,		false,		false);
						InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	prefix + "chg_seq",			false,    "",	dfNone,		0,		false,		false);
					}
				}
			break;
		}
	}
	
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @param comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ofc_cd":
				with (comboObj) {
					SetColAlign("left");
					SetColWidth("50");
					//SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
			break;
		}
	}
	
	/** 
	 * RD 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {RdObject} rdObject
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;
		
		Rdviewer.style.height = 0;
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
	}

	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".");
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;
			case "engup":
				switch(event.srcElement.name){
					case "inv_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
	
					case "act_cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
				}
			break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
            break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
	}

	/** 
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "iss_dt":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "act_cust_seq":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement,true, true, false);
				//마스크 구분자 없애기
				//ComClearSeparator (event.srcElement);
			break;
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
		}
	}
	
	/** 
	 * HTML Control OnFocusOut 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_focusout() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "act_cust_seq":
				//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
				if (formObj.act_cust_cnt_cd.value != '' && formObj.act_cust_seq.value != '') {
					var valueCustSeq = formObj.act_cust_seq.value;
					formObj.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC20);
	
					var custCd = "";
					if (formObj.cust_nm.value != '') {
						custCd = formObj.act_cust_cnt_cd.value+ComLpad(valueCustSeq,6,"0");
					}
					else {
						custCd = "";
						formObj.act_cust_seq.focus();
					}
					
					for(i=sheetObj.rowCount; i>0; i--){
						sheetObj.CellValue2(i, "cust_code") = custCd;
					}
				}
				else {
					formObj.cust_nm.value = '';
					
					for(i=sheetObj.rowCount; i>0; i--){
						sheetObj.CellValue2(i, "cust_code") = "";
					}
				}
			break;
		}
	}

	/** 
	 * HTML Control KeyUp 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function obj_keyup() {
		var formObj = document.form;
		switch (event.srcElement.name) {
			case "iss_dt":
				var issDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (issDt.length == 8) {
					formObj.ofc_cd.focus();
				}
	 		break;
			case "act_cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObj.act_cust_seq.focus();
				}
	 		break;
	 	}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,selectRow) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;

					var arrStr2 = formObj.ofc_cd.Code.split("^");
					formObj.ar_ofc_cd.value = arrStr2[1];
	     			
					var sheetObj1 = sheetObjects[0];
					var sheetObj2 = sheetObjects[1];
					var sheetObj3 = sheetObjects[2];

					var aryPrefix = new Array("main_", "sheet1_", "sheet2_", "sheet3_");
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0039GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					var arrXml = sXml.split("|$$|");
	     			if(CoInvShowXmlMessage(arrXml[0]) != "") {
	     				var invNo = formObj.inv_no.value;
	     				var issDt = formObj.iss_dt.value;
	     				var arOfcCd = formObj.ar_ofc_cd.text;
	     				
	     				removeAll(formObj);
	     				
	     				formObj.inv_no.value = invNo;
	     				formObj.iss_dt.value = issDt;
	     				formObj.ar_ofc_cd.text = arOfcCd;
	     				
	     				ComAlertFocus(formObj.bl_src_no, CoInvShowXmlMessage(arrXml[0]));
					} else {
						if (arrXml.length > 0) {
							//소수점 자릿수
							var currPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt");
							
							var list1 = ComXml2ListMap(arrXml[0]);
							
							var expensInfo1  = list1[0];
							
							var invSeq = expensInfo1["main_inv_seq"];
							var issDt = expensInfo1["main_iss_dt"];
							var actCustCntCd = expensInfo1["main_act_cust_cnt_cd"];
							var actCustSeq = expensInfo1["main_act_cust_seq"];
							var custNm = expensInfo1["main_locl_nm"];
							var custRgstNo = expensInfo1["main_cust_rgst_no"];
							var issDivCd = expensInfo1["main_iss_div_cd"];
							var cntcPsonNm = expensInfo1["main_cntc_pson_nm"];
							var loclAddr = expensInfo1["main_locl_addr"];
							var bzctNm = expensInfo1["main_bzct_nm"];
							var bztpNm = expensInfo1["main_bztp_nm"];
							var invRmk = expensInfo1["main_inv_rmk"];
							var custFaxNo = expensInfo1["main_cust_fax_no"];
							var custEml = expensInfo1["main_cust_eml"];
							var indivCorpDivCd = expensInfo1["main_indiv_corp_div_cd"];
							
							if (formObj.act_cust_cnt_cd.value == '' && formObj.act_cust_seq.value == '') {
								formObj.inv_seq.value = invSeq;
								formObj.iss_dt.value = issDt;
								formObj.act_cust_cnt_cd.value = actCustCntCd;
								formObj.act_cust_seq.value = actCustSeq;
								formObj.cust_nm.value = custNm;
								if (indivCorpDivCd == 'C') {
									formObj.cust_rgst_no.value = ComGetMaskedValue(custRgstNo,"saupja");
								} else {
									formObj.cust_rgst_no.value = ComGetMaskedValue(custRgstNo,"jumin");
								}
								var tmpIssDivCd = "";
								if (issDivCd == 'I') {
									tmpIssDivCd = "INTERNET";
								}
								else if (issDivCd == 'P') {
									tmpIssDivCd = "PAPER";
								}
								else if (issDivCd == 'E') {
									tmpIssDivCd = "EDI";
								}
								else if (issDivCd == 'V') {
									tmpIssDivCd = "VIETNAM";
								}
								formObj.iss_div_cd.value = tmpIssDivCd;
								formObj.cntc_pson_nm.value = cntcPsonNm;
								formObj.locl_addr.value = loclAddr;
								formObj.bzct_nm.value = bzctNm;
								formObj.bztp_nm.value = bztpNm;
								formObj.inv_rmk.value = invRmk;
								formObj.cust_fax_no.value = custFaxNo;
								formObj.cust_eml.value = custEml;
							}
						}
				    	if (arrXml.length > 1) {
				    		sheetObj1.LoadSearchXml(arrXml[1]);
				    		
				    		// main 그리드 비활성화
							for(var i=sheetObj1.rowCount; i>0; i--){
								sheetObj1.RowEditable(i) = false;
							}
						}
				    	if (arrXml.length > 3) {
				    		sheetObj3.LoadSearchXml(arrXml[3]);
				    		
					    	// sheet 초기화
							sheetObj2.Reset();
							
							initSheet(sheetObj2,2);
						}
				    	
				    	ComEnableObject(formObj.inv_no,	false);
				    	ComEnableObject(formObj.iss_dt,	false);
				    	formObj.inv_no.className = "input2";
				    	formObj.iss_dt.className = "input2";
				    	formObj.btns_calendar.disabled = true;
				    	
				    	formObj.ofc_cd.Enable = false;
				    	
				    	sheet1_OnDblClick(sheetObj1, 1);
					}
				}
			break;
			
			case IBINSERT:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					var sendFlg = formObj.send_flg.value;
					
					formObj.f_cmd.value = MULTI;
					
					var arrStr2 = formObj.ofc_cd.Code.split("^");
					formObj.ar_ofc_cd.value = arrStr2[1];
					
					var sParam = FormQueryString(formObj);
					var sParam1 = sheetObjects[0].GetSaveString(true);
					var sParam3 = sheetObjects[2].GetSaveString(true);

					if (sParam1 == "" || sParam3 == "") {
						return;
					}
					else {
						sParam = sParam + "&" + sParam1 + "&" + sParam3;
					}

					var sXml = sheetObjects[1].GetSaveXml("FNS_INV_0039GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						var invNo = ComGetEtcData(sXml,"inv_no");
						var sndNum = ComGetEtcData(sXml,"snd_num");
						var arOfcCd = formObj.ar_ofc_cd.value;
						
						removeAll(formObj);
						
						formObj.inv_no.value = invNo;
						formObj.ofc_cd.Text = arOfcCd;

						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					
						if (sendFlg == "P") {
							rdOpen(rdObjects[0], formObj);
						}
						else {
							ComShowCodeMessage("INV00065", sndNum);
						}
					}
					else {
						ComShowCodeMessage("INV00053");
					}
				}
			break;

			case IBSEARCH_ASYNC11: // B/L NO 조회
				formObj.f_cmd.value = SEARCH01;
				// OFFICE
				var arrStr2 = formObj.ofc_cd.Code.split("^");
	 			formObj.ar_ofc_cd.value = arrStr2[1];
	 			
				var sheetObj1 = sheetObjects[0];
				var sheetObj2 = sheetObjects[1];
				var selectRow = sheetObj1.SelectRow;
	 			
				var aryPrefix = new Array("main_", "sheet1_", "sheet2_");
			
				var sXml = sheetObj.GetSearchXml("FNS_INV_0039GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				
     			if(CoInvShowXmlMessage(arrXml[0]) != "") {
     				//sheetObj1.CellValue2(selectRow, "sheet1_bl_src_no") = "";
					sheetObj2.RemoveAll();
     				
     				ComAlertFocus(formObj.ofc_cd, CoInvShowXmlMessage(arrXml[0]));
					sheetObj1.SelectCell(selectRow,1);
				} else {
				
					if (arrXml.length > 0) {
						//소수점 자릿수
						var currPoint = ComGetEtcData(arrXml[0], "dp_prcs_knt");
						
						var list1 = ComXml2ListMap(arrXml[0]);
						
						var expensInfo1  = list1[0];
						
						var actCustCntCd = expensInfo1["main_act_cust_cnt_cd"];
						var actCustSeq = expensInfo1["main_act_cust_seq"];
						var custNm = expensInfo1["main_locl_nm"];
						var custRgstNo = expensInfo1["main_cust_rgst_no"];
						var issDivCd = expensInfo1["main_iss_div_cd"];
						var cntcPsonNm = expensInfo1["main_cntc_pson_nm"];
						var loclAddr = expensInfo1["main_locl_addr"];
						var bzctNm = expensInfo1["main_bzct_nm"];
						var bztpNm = expensInfo1["main_bztp_nm"];
						var invRmk = expensInfo1["main_inv_rmk"];
						var custFaxNo = expensInfo1["main_cust_fax_no"];
						var custEml = expensInfo1["main_cust_eml"];
						var indivCorpDivCd = expensInfo1["main_indiv_corp_div_cd"];
						
						
						if (formObj.act_cust_cnt_cd.value == '' && formObj.act_cust_seq.value == '') {
							formObj.act_cust_cnt_cd.value = actCustCntCd;
							formObj.act_cust_seq.value = actCustSeq;
							formObj.cust_nm.value = custNm;
							if (indivCorpDivCd == 'C') {
								formObj.cust_rgst_no.value = ComGetMaskedValue(custRgstNo,"saupja");
							} else {
								formObj.cust_rgst_no.value = ComGetMaskedValue(custRgstNo,"jumin");
							}
							var tmpIssDivCd = "";
							if (issDivCd == 'I') {
								tmpIssDivCd = "INTERNET";
							}
							else if (issDivCd == 'P') {
								tmpIssDivCd = "PAPER";
							}
							else if (issDivCd == 'E') {
								tmpIssDivCd = "EDI";
							}
							else if (issDivCd == 'V') {
								tmpIssDivCd = "VIETNAM";
							}
							formObj.iss_div_cd.value = tmpIssDivCd;
							formObj.cntc_pson_nm.value = cntcPsonNm;
							formObj.locl_addr.value = loclAddr;
							formObj.bzct_nm.value = bzctNm;
							formObj.bztp_nm.value = bztpNm;
							formObj.inv_rmk.value = "";
							formObj.cust_fax_no.value = custFaxNo;
							formObj.cust_eml.value = custEml;
						}
					}
			    	if (arrXml.length > 1) {
			    		var list2 = ComXml2ListMap(arrXml[1]);
			    		var expensInfo2  = list2[0];
			    		
			    		sheetObj1.CellValue(selectRow, "sheet1_bkg_no") = expensInfo2["sheet1_bkg_no"];
			    		sheetObj1.CellValue(selectRow, "sheet1_vvd") = expensInfo2["sheet1_vvd"];
			    		sheetObj1.CellValue(selectRow, "sheet1_sail_arr_dt") = expensInfo2["sheet1_sail_arr_dt"];
			    		sheetObj1.CellValue(selectRow, "sheet1_io_bnd_cd") = expensInfo2["sheet1_io_bnd_cd"];
			    		sheetObj1.CellValue(selectRow, "sheet1_port") = expensInfo2["sheet1_port"];
			    		sheetObj1.CellValue(selectRow, "sheet1_pol_cd") = expensInfo2["sheet1_pol_cd"];
			    		sheetObj1.CellValue(selectRow, "sheet1_pod_cd") = expensInfo2["sheet1_pod_cd"];
			    		sheetObj1.CellValue(selectRow, "sheet1_usd_xch_rt") = expensInfo2["sheet1_usd_xch_rt"];
			    		
			    		sheetObj1.RowEditable(selectRow) = false;
					}
			    	if (arrXml.length > 2) {
				    	// sheet 초기화
						//sheetObj2.Reset();
						
						//initSheet(sheetObj2,2);
			    		formObj.bl_search.value = "Y";
			    		sheetObj2.LoadSearchXml(arrXml[2]);
			    		formObj.bl_search.value = "";
					}
				}
			break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH02;
				
				var sXml = sheetObj.GetSearchXml("FNS_INV_0039GS.do", FormQueryString(formObj));
	
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
	
				MakeComboObject(formObj.ofc_cd, arrStr);
	
				var arrStr2 = arrStr[1].split("^");
				var ofc_cd = arrStr2[3];
				formObj.ofc_cd.text = ofc_cd;
				
        		var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
        		formObj.inv_prn_dvc_nm.value = sStr;
        		
        		//var sheetObj2 = sheetObjects[1];
        		var chg_cd = ComGetEtcData(sXml, "chg_cd");	
        		addCellComboItem(sheetObjects[1],chg_cd,"sheet2_chg_cd",false);
        		
    			var comboValues = ComGetEtcData(sXml, "currInfo");
    			addCellComboItem(sheetObjects[1],comboValues,"sheet2_curr_cd",false);
    			
    			var comboValues2 = ComGetEtcData(sXml, "currInfo");
    			addCellComboItem(sheetObjects[1],comboValues2,"sheet2_ar_curr_cd",false);
    			
    			var comboValues3 = ComGetEtcData(sXml, "perInfo");	
				addCellComboItem(sheetObjects[1],comboValues3,"sheet2_per_tp_cd",false);
 			break;
 			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ofc_cd.Code.split("^");
				formObj.ar_ofc_cd.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = ComReplaceStr(formObj.act_cust_seq.value,",","");
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.act_cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					formObj.cust_rgst_no.value = "";
					formObj.iss_div_cd.value = "";
					formObj.cntc_pson_nm.value = "";
					formObj.locl_addr.value = "";
					formObj.bzct_nm.value = "";
					formObj.bztp_nm.value = "";
					//formObj.inv_rmk.value = "";
					//formObj.cust_fax_no.value = "";
					//formObj.cust_eml.value = "";
					
					ComAlertFocus(formObj.cust_cnt_cd, CoInvShowXmlMessage(sXml));
				} else {
					var custNm = ComGetEtcData(sXml,"cust_eng_nm");
					var deltFlg = ComGetEtcData(sXml,"delt_flg");
					
					var custRgstNo = ComGetEtcData(sXml,"cust_rgst_no");
					var issDivCd = ComGetEtcData(sXml,"iss_div_cd");
					var cntcPsonNm = ComGetEtcData(sXml,"cntc_pson_nm");
					var loclAddr = ComGetEtcData(sXml,"locl_addr");
					var bzctNm = ComGetEtcData(sXml,"bzct_nm");
					var bztpNm = ComGetEtcData(sXml,"bztp_nm");
					var invRmk = ComGetEtcData(sXml,"inv_rmk");
					var indivCorpDivCd = ComGetEtcData(sXml,"indiv_corp_div_cd");
					
					if (custNm != undefined && deltFlg != undefined) {
						formObj.cust_nm.value = custNm;
						if (indivCorpDivCd == 'C') {
							formObj.cust_rgst_no.value = ComGetMaskedValue(custRgstNo,"saupja");
						} else {
							formObj.cust_rgst_no.value = ComGetMaskedValue(custRgstNo,"jumin");
						}
						var tmpIssDivCd = "";
						if (issDivCd == 'I') {
							tmpIssDivCd = "INTERNET";
						}
						else if (issDivCd == 'P') {
							tmpIssDivCd = "PAPER";
						}
						else if (issDivCd == 'E') {
							tmpIssDivCd = "EDI";
						}
						else if (issDivCd == 'V') {
							tmpIssDivCd = "VIETNAM";
						}
						formObj.iss_div_cd.value = tmpIssDivCd;
						formObj.cntc_pson_nm.value = cntcPsonNm;
						formObj.locl_addr.value = loclAddr;
						formObj.bzct_nm.value = bzctNm;
						formObj.bztp_nm.value = bztpNm;
						//formObj.inv_rmk.value = "";
						//formObj.cust_fax_no.value = "";
						//formObj.cust_eml.value = "";
					} else {
						formObj.act_cust_seq.value = "";
						formObj.cust_nm.value = "";
						
						formObj.cust_rgst_no.value = "";
						formObj.iss_div_cd.value = "";
						formObj.cntc_pson_nm.value = "";
						formObj.locl_addr.value = "";
						formObj.bzct_nm.value = "";
						formObj.bztp_nm.value = "";
						//formObj.inv_rmk.value = "";
						//formObj.cust_fax_no.value = "";
						//formObj.cust_eml.value = "";
					}
				}
			break;
		}
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:      //조회
				with(formObj){
					if(inv_no.value == "") {          		 
						ComShowCodeMessage("INV00004");
						inv_no.focus();
						return false;
					}
					if(ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ofc_cd.focus();
						return false;
					}
				}
			break;
			case IBINSERT:      //ISSUE
				var rowCnt = sheetObj.RowCount;
				var noUsdXchRtCnt = 0;
				
				with(formObj){
					if(iss_dt.value == "") {
						ComShowCodeMessage("INV00004");
						iss_dt.focus();
						return false;
					}
					if(ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ofc_cd.focus();
						return false;
					}
					if(act_cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						act_cust_cnt_cd.focus();
						return false;
					}
					if(act_cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						act_cust_seq.focus();
						return false;
					}
					//FAX 입력여부 확인
					if(formObj.send_flg.value == "F" && cust_fax_no.value == "") {
						ComShowCodeMessage("INV00104");
						cust_fax_no.focus();
						return false;
					}
					//EMAIL 입력여부 확인
					if(formObj.send_flg.value =="E" && cust_eml.value == "" ) {
						ComShowCodeMessage("INV00104");
						cust_eml.focus();
						return false;
					}
					// Email format 확인
					var eml = cust_eml.value;
					if(formObj.send_flg.value =="E" && !ComIsEmailAddr(eml) ){
						ComShowCodeMessage("INV00104");
						cust_eml.focus();
						return false;
					}
					//INV_AR_MN의 USD_XCH_RT 값 확인
					/*
					for(var i = 1; i <= rowCnt; i++){
						if (sheetObj.CellValue(i, "sheet1_usd_xch_rt") == "0") {
							noUsdXchRtCnt++;
						}
						if (noUsdXchRtCnt > 0) {
							ComShowCodeMessage("INV00098");
							return false;
						}
					}*/
					for(var i = 1; i <= sheetObjects[1].RowCount; i++){						
						//if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "I"){							
							if(sheetObjects[1].CellValue(i,"sheet2_chg_cd") == ""){
								ComShowCodeMessage("INV00004");
								sheetObjects[1].SelectCell(i,"sheet2_chg_cd");
								return false;
							}
							if(sheetObjects[1].CellValue(i,"sheet2_curr_cd") == ""){
								ComShowCodeMessage("INV00004");
								sheetObjects[1].SelectCell(i,"sheet2_curr_cd");
								return false;
							}
							if(sheetObjects[1].CellValue(i,"sheet2_trf_rt_amt") == ""){
								ComShowCodeMessage("INV00004");
								sheetObjects[1].SelectCell(i,"sheet2_trf_rt_amt");
								return false;
							}
							if(sheetObjects[1].CellValue(i,"sheet2_rat_as_cntr_qty") == "" || sheetObjects[1].CellValue(i,"sheet2_rat_as_cntr_qty") == "0" || sheetObjects[1].CellValue(i,"sheet2_rat_as_cntr_qty") == "0.000"){
								ComShowCodeMessage("INV00004");
								sheetObjects[1].SelectCell(i,"sheet2_rat_as_cntr_qty");
								return false;
							}
							if(sheetObjects[1].CellValue(i,"sheet2_per_tp_cd") == ""){
								ComShowCodeMessage("INV00004");
								sheetObjects[1].SelectCell(i,"sheet2_per_tp_cd");
								return false;
							}
							if(sheetObjects[1].CellValue(i,"sheet2_inv_xch_rt") == "" || Number(sheetObjects[1].CellValue(i,"sheet2_inv_xch_rt")) == "0"){
								ComShowCodeMessage("INV00098");
								sheetObjects[1].SelectCell(i,"sheet2_inv_xch_rt");
								return false;
							}
						//}
						
					}
				}
			break;
			case IBSAVE:      //RE-ISSUE
				with(formObj){
					if(inv_no.value == "") {
						ComShowCodeMessage("INV00004");
						inv_no.focus();
						return false;
					}
					if(iss_dt.value == "") {
						ComShowCodeMessage("INV00004");
						iss_dt.focus();
						return false;
					}
					if(ofc_cd.text == "") {
						ComShowCodeMessage("INV00004");
						ofc_cd.focus();
						return false;
					}
					if(act_cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						act_cust_cnt_cd.focus();
						return false;
					}
					if(act_cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						act_cust_seq.focus();
						return false;
					}
				}
			break;
    	}
		
		return true;
	}
	
	/**
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */
	function sheet1_OnLoadFinish(sheetObj){
		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
		setDefaultDateValue(formObj);
		
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SelectCell(1,1);
	}
	
	/**
	 * 셀을 클릭했을때 발생하는 이벤트 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 **/
	function sheet1_OnClick(sheetObj, Row, Col) {
		sheet1_OnDblClick(sheetObj, Row, Col);
	}
	
	/**
	 * 셀을 더블 클릭했을때 발생하는 이벤트 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 **/
	function sheet1_OnDblClick(sheetObj, Row, Col, vType) {
		var chargeSheet = sheetObjects[1];
		var hiddenSheet = sheetObjects[2];
		
	   	var formObj = document.form;
   		var blSrcNo = ComReplaceStr(sheetObj.CellValue(sheetObj.SelectRow, "sheet1_bl_src_no"), " ", "");
   		
   		var prefix2 = "sheet2_";
   		var prefix3 = "sheet3_";
   		
   		//메인 그리드를 더블클릭했을 때 B/L NO가 있다면 hiddenSheet(sheetObjects[2])에서 같은 번호로 입력된 내용을 chargeSheet(sheetObjects[1])에 옮겨준다.
   		if(blSrcNo != ''){
   			chargeSheet.RemoveAll();
   			
   			if(hiddenSheet.RowCount > 0) {
   				for(i = 1 ; i < hiddenSheet.Rows; i++){
   					if(hiddenSheet.CellValue(i, "sheet3_bl_src_no") == blSrcNo) {
   						chargeSheet.DataInsert(-1);
   						
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "ibflag") = hiddenSheet.CellValue(i, prefix3 + "ibflag");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "chg_cd") = hiddenSheet.CellValue(i, prefix3 + "chg_cd");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "curr_cd") = hiddenSheet.CellValue(i, prefix3 + "curr_cd");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "chg_amt") = hiddenSheet.CellValue(i, prefix3 + "chg_amt");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "rat_as_cntr_qty") = hiddenSheet.CellValue(i, prefix3 + "rat_as_cntr_qty");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "trf_rt_amt") = hiddenSheet.CellValue(i, prefix3 + "trf_rt_amt");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "per_tp_cd") = hiddenSheet.CellValue(i, prefix3 + "per_tp_cd");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "iss_amt") = hiddenSheet.CellValue(i, prefix3 + "iss_amt");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "inv_xch_rt") = hiddenSheet.CellValue(i, prefix3 + "inv_xch_rt");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "ar_curr_cd") = hiddenSheet.CellValue(i, prefix3 + "ar_curr_cd");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "locl_amt") = hiddenSheet.CellValue(i, prefix3 + "locl_amt");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "bl_src_no") = hiddenSheet.CellValue(i, prefix3 + "bl_src_no");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "ar_if_no") = hiddenSheet.CellValue(i, prefix3 + "ar_if_no");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "ar_if_ser_no") = hiddenSheet.CellValue(i, prefix3 + "ar_if_ser_no");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "chg_seq") = hiddenSheet.CellValue(i, prefix3 + "chg_seq");
   						chargeSheet.CellValue2(chargeSheet.SelectRow, prefix2 + "ar_ofc_cd") = hiddenSheet.CellValue(i, prefix3 + "ar_ofc_cd");
   					}
   				}
   			}

   			if (vType == "R") {
	    		// main 그리드 비활성화
				for(var i=chargeSheet.rowCount; i>0; i--){
					chargeSheet.RowEditable(i) = false;
				}
   			}

   			//charge list의 계산 로직을 수행한다. (iss Amount, local Amount 계산)
   			document.form.bl_search.value = "Y";
   			calCargeLoclAmt(chargeSheet);
   			document.form.bl_search.value = "";
			//선택한 B/L No의 charge list에 대한 소계를 구한다.
			calChargeSum(chargeSheet);
			//B/L COUNT와 TOTAL AMT(KRW)을 계산한다.
			calTotalSum();
   		}
	}
	
    /** 
     * OnChange 이벤트 발생시[CR 그리드 입력항목 변경] 호출되는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj        
     * @param  {rownum} Row        
     * @param  {colnum} Col        
     * @param  {object} Value        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
     */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
    	var formObj = document.form;
    	var dpPrcsKnt = formObj.dp_prcs_knt.value;
    	
    	//B/L NO
    	if (Col == 1) {
    		// 입력된 B/L NO가 있다면 
    		if(Value != '') {
    			//신규 B/L NO 입력시 기입력여부 체크
    			if(chkBlNoDuplicate(sheetObj,Row,Col,Value)) {
	    			formObj.bl_src_no.value = Value;
	    			
	    			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC11, Row);
    			}
    			else {
					 ComShowCodeMessage("INV00017");
					 //sheetObj.CellValue2(Row, "sheet1_bl_src_no") = "";
					 sheetObj.SelectCell(Row, "sheet1_bl_src_no");
					 return false;
    			}
    		}
    	}
	}
	
    /** 
     * OnChange 이벤트 발생시[CR 그리드 입력항목 변경] 호출되는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj        
     * @param  {rownum} Row        
     * @param  {colnum} Col        
     * @param  {object} Value        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
     */
	function sheet2_OnChange(sheetObj,Row,Col,Value){
    	var formObj = document.form;
    	var dpPrcsKnt = formObj.dp_prcs_knt.value;

    	if(Value != '') {
    		//charge list의 계산 로직을 수행한다. (iss Amount, local Amount 계산)
	    	//calCargeLoclAmt(sheetObj);
    		calCargeLoclAmt_change(sheetObj);
			//선택한 B/L No의 charge list에 대한 소계를 구한다.
			calChargeSum(sheetObj);
			//통합 charge 그리드의 같은 B/L No의 정보를 수정한다.
			updateHiddenChargeList(sheetObj);
			//B/L COUNT와 TOTAL AMT(KRW)을 계산한다.
			calTotalSum();
    	}
	}
	
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 	  	
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		//charge list의 계산 로직을 수행한다. (iss Amount, local Amount 계산)	
		calCargeLoclAmt(sheetObj);
		//선택한 B/L No의 charge list에 대한 소계를 구한다.
		calChargeSum(sheetObj);
		
		//chareg 그리드의 내용을 통합 charge 그리드에 옮긴다.
		setHiddenChargeList(sheetObj);
	}
	
	/**
	 * Send/Fax 발송 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function sendFaxEml(sheetObj, formObj, sendFlg) {
		var emailSubject = "";
		var emailFileName = "";
		var rowCnt = sheetObj.RowCount;

		if(rowCnt > 0) {
			if (rowCnt > 1) {
				if(sendFlg == "E"){
					emailSubject = sheetObj.CellValue(1, "sheet1_bl_src_no") + " 외 "+parseInt(rowCnt-1)+" 건";
					emailFileName = sheetObj.CellValue(1, "sheet1_bl_src_no") + " except "+parseInt(rowCnt-1)+" case";
				}else{
					emailSubject = sheetObj.CellValue(1, "sheet1_bl_src_no");
					emailFileName = sheetObj.CellValue(1, "sheet1_bl_src_no") + " except "+parseInt(rowCnt-1)+" case";
				}
			}
			else {
				emailSubject = sheetObj.CellValue(1, "sheet1_bl_src_no");
				emailFileName = sheetObj.CellValue(1, "sheet1_bl_src_no");
			}
		}
		
		formObj.send_flg.value = sendFlg;
		formObj.email_subject.value = emailSubject;
		formObj.email_file_name.value = emailFileName;
		formObj.rd_name.value = "FNS_INV_0519.mrd";
		
		doActionIBSheet(sheetObj,formObj,IBINSERT);
	}
	
	/**
	 * charge list의 계산 로직을 수행한다. (iss Amount, local Amount 계산)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function calCargeLoclAmt(sheetObj) {
		var chargeSheet = sheetObjects[1];
		var hiddenSheet = sheetObjects[2];
		var curr_cd = "";
		var point = "";
		
		if(sheetObj.RowCount > 0) {
			for(i = 1 ; i < sheetObj.Rows; i++){
				curr_cd = sheetObj.CellValue(i, "sheet2_curr_cd");
				//point = sheetObj.CellValue(sheetObj.SelectRow, 11);
				
				if(curr_cd == "KRW"){
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "", "", dfInteger);
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 10, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(i, 5, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(i, 8, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(i, 11, dtData , daRight , "", "", dfInteger);
				}else{
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "", "", dfNullFloat, 2);
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 10, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(i, 5, dtData , daRight , "", "", dfNullFloat, 2);
					sheetObj.InitCellProperty(i, 8, dtData , daRight , "", "", dfNullFloat, 2);
					sheetObj.InitCellProperty(i, 11, dtData , daRight , "", "", dfInteger);
				}

				if(document.form.bl_search.value == "Y"){
					sheetObj.CellValue2(i, "sheet2_iss_amt") = sheetObj.CellValue(i, "sheet2_chg_amt");
				}else{
					if (sheetObj.CellValue(i, "sheet2_per_tp_cd") == 'PC') {
						sheetObj.CellValue2(i, "sheet2_iss_amt") = sheetObj.CellValue(i, "sheet2_rat_as_cntr_qty") * sheetObj.CellValue(i, "sheet2_trf_rt_amt") / 100;
					}
					else {
						sheetObj.CellValue2(i, "sheet2_iss_amt") = sheetObj.CellValue(i, "sheet2_rat_as_cntr_qty") * sheetObj.CellValue(i, "sheet2_trf_rt_amt");
					}
				}	
				
				sheetObj.CellValue2(i, "sheet2_locl_amt") = sheetObj.CellValue(i, "sheet2_iss_amt") * sheetObj.CellValue(i, "sheet2_inv_xch_rt");
			}
		}
		
		if(hiddenSheet.RowCount > 0) {
			for(i = 1 ; i < hiddenSheet.Rows; i++){
				curr_cd = hiddenSheet.CellValue(i, "sheet2_curr_cd");
				if(curr_cd == "KRW"){
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 7, dtData , daRight , "", "", dfInteger);
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 10, dtData , daRight , "", "", dfInteger);
				}else{
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 7, dtData , daRight , "", "", dfNullFloat, 2);
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 10, dtData , daRight , "", "", dfNullFloat, 2);
				}
				
				if(document.form.bl_search.value == "Y"){
					sheetObj.CellValue2(i, "sheet2_iss_amt") = sheetObj.CellValue(i, "sheet2_chg_amt");
				}else{
					if (hiddenSheet.CellValue(i, "sheet3_per_tp_cd") == 'PC') {
						hiddenSheet.CellValue2(i, "sheet3_iss_amt") = hiddenSheet.CellValue(i, "sheet3_rat_as_cntr_qty") * hiddenSheet.CellValue(i, "sheet3_trf_rt_amt") / 100;
					}
					else {
						hiddenSheet.CellValue2(i, "sheet3_iss_amt") = hiddenSheet.CellValue(i, "sheet3_rat_as_cntr_qty") * hiddenSheet.CellValue(i, "sheet3_trf_rt_amt");
					}
				}	
				
				hiddenSheet.CellValue2(i, "sheet3_locl_amt") = hiddenSheet.CellValue(i, "sheet3_iss_amt") * hiddenSheet.CellValue(i, "sheet3_inv_xch_rt");
			}
		}
	}
	
	/**
	 * charge list의 계산 로직을 수행한다. (iss Amount, local Amount 계산)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function calCargeLoclAmt_change(sheetObj) {
		var chargeSheet = sheetObjects[1];
		var hiddenSheet = sheetObjects[2];
		var curr_cd = "";
		var point = "";
		
		if(sheetObj.RowCount > 0) {
				curr_cd = sheetObj.CellValue(sheetObj.SelectRow, "sheet2_curr_cd");				
				if(curr_cd == "KRW"){
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "", "", dfInteger);
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 10, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(sheetObj.SelectRow, 5, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(sheetObj.SelectRow, 8, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(sheetObj.SelectRow, 11, dtData , daRight , "", "", dfInteger);
				}else{
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "", "", dfNullFloat, 2);
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 10, dtData , daRight , "", "", dfInteger);
					sheetObj.InitCellProperty(sheetObj.SelectRow, 5, dtData , daRight , "", "", dfNullFloat, 2);
					sheetObj.InitCellProperty(sheetObj.SelectRow, 8, dtData , daRight , "", "", dfNullFloat, 2);
					sheetObj.InitCellProperty(sheetObj.SelectRow, 11, dtData , daRight , "", "", dfInteger);
				}

				if (sheetObj.CellValue(sheetObj.SelectRow, "sheet2_per_tp_cd") == 'PC') {
					sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_iss_amt") = sheetObj.CellValue(sheetObj.SelectRow, "sheet2_rat_as_cntr_qty") * sheetObj.CellValue(sheetObj.SelectRow, "sheet2_trf_rt_amt") / 100;
				}
				else {
					sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_iss_amt") = sheetObj.CellValue(sheetObj.SelectRow, "sheet2_rat_as_cntr_qty") * sheetObj.CellValue(sheetObj.SelectRow, "sheet2_trf_rt_amt");
				}
				sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_chg_amt") = sheetObj.CellValue(sheetObj.SelectRow, "sheet2_iss_amt");
				sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_locl_amt") = sheetObj.CellValue(sheetObj.SelectRow, "sheet2_iss_amt") * sheetObj.CellValue(sheetObj.SelectRow, "sheet2_inv_xch_rt");
		}
		/*
		if(hiddenSheet.RowCount > 0) {
			for(i = 1 ; i < hiddenSheet.Rows; i++){
				curr_cd = hiddenSheet.CellValue(i, "sheet2_curr_cd");
				if(curr_cd == "KRW"){
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 7, dtData , daRight , "", "", dfInteger);
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 10, dtData , daRight , "", "", dfInteger);
				}else{
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 7, dtData , daRight , "", "", dfNullFloat, 2);
					//hiddenSheet.InitCellProperty(hiddenSheet.SelectRow, 10, dtData , daRight , "", "", dfNullFloat, 2);
				}
				if (hiddenSheet.CellValue(i, "sheet3_per_tp_cd") == 'PC') {
					hiddenSheet.CellValue2(i, "sheet3_iss_amt") = hiddenSheet.CellValue(i, "sheet3_rat_as_cntr_qty") * hiddenSheet.CellValue(i, "sheet3_trf_rt_amt") / 100;
				}
				else {
					hiddenSheet.CellValue2(i, "sheet3_iss_amt") = hiddenSheet.CellValue(i, "sheet3_rat_as_cntr_qty") * hiddenSheet.CellValue(i, "sheet3_trf_rt_amt");
				}
				
				hiddenSheet.CellValue2(i, "sheet3_locl_amt") = hiddenSheet.CellValue(i, "sheet3_iss_amt") * hiddenSheet.CellValue(i, "sheet3_inv_xch_rt");
			}
		}
		*/
	}
	
	/**
	 * 선택한 B/L No의 charge list에 대한 소계를 구한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function calChargeSum_BAK(sheetObj) {
		var formObj = document.form;
		var totalUsd = 0;
		var vatKrw = 0;
		var totalKrw = 0;
		
		if(sheetObj.RowCount > 0) {
			var sSaveName = "";
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (sheetObj.CellValue(i, "sheet2_curr_cd") == 'USD') {
					totalUsd = Number(totalUsd) + Number(sheetObj.CellValue(i, "sheet2_iss_amt"));
				}
				if (sheetObj.CellValue(i, "sheet2_chg_cd") == 'TVA') {
					vatKrw = Number(vatKrw) + Number(sheetObj.CellValue(i, "sheet2_locl_amt"));
				}
				
				totalKrw = Number(totalKrw) + Number(sheetObj.CellValue(i, "sheet2_locl_amt"));
			}
		}
		
		document.getElementById("total_usd").innerHTML = ComAddComma(totalUsd);
		document.getElementById("vat_krw").innerHTML = ComAddComma(vatKrw);
		document.getElementById("total_krw").innerHTML = ComAddComma(totalKrw);
	}
	/**
	 * B/L COUNT와 TOTAL AMT(KRW)을 계산한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function calTotalSum_BAK() {
		var blNoCnt = 0;
		var totalKrw = 0;
		var formObj = document.form;
		var mainSheet = sheetObjects[0];
		var hiddenSheet = sheetObjects[2];
		
		if(mainSheet.RowCount > 0) {
			for(i = 1 ; i < mainSheet.Rows; i++){
				if (mainSheet.CellValue(i, "sheet1_bl_src_no") != '') {
					blNoCnt++;
				}
			}
		}
		
		if(hiddenSheet.RowCount > 0) {
			for(i = 1 ; i < hiddenSheet.Rows; i++){
				totalKrw = Number(totalKrw) + Number(hiddenSheet.CellValue(i, "sheet3_locl_amt"));
			}
		}
		
		formObj.bl_no_cnt.value = ComAddComma(blNoCnt)
		formObj.total_amt.value = ComAddComma(Math.round(totalKrw));
	}
	
	
	/**
	 * 선택한 B/L No의 charge list에 대한 소계를 구한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function calChargeSum(sheetObj) {
		var formObj = document.form;
		var totalUsd = 0;
		var vatKrw = 0;
		var totalKrw = 0;
		
		var a_curr = "";
		var b_curr = "";
		var ex_rate = "";
		var b_totalKrw = 0;
		var a_totalKrw = 0;
		
		if(sheetObj.RowCount > 0) {
			var sSaveName = "";
			//var main_bl_src_no = sheetObjects[0].CellValue(SelectRow, "sheet1_bl_src_no");
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (sheetObj.CellValue(i, "sheet2_curr_cd") == 'USD') {
					totalUsd = Number(totalUsd) + Number(sheetObj.CellValue(i, "sheet2_iss_amt"));
				}
				if (sheetObj.CellValue(i, "sheet2_chg_cd") == 'TVA') {
					vatKrw = Number(vatKrw) + Number(sheetObj.CellValue(i, "sheet2_locl_amt"));
				}
				
				b_curr = sheetObj.CellValue(i, "sheet2_curr_cd");
				a_curr = sheetObj.CellValue(i+1, "sheet2_curr_cd");
				b_exRate = sheetObj.CellValue(i, "sheet3_inv_xch_rt");
				a_exRate = sheetObj.CellValue(i+1, "sheet3_inv_xch_rt");
				ex_rate = sheetObj.CellValue(i, "sheet2_inv_xch_rt");
				//alert(a_curr+"::"+b_curr);
				if(a_curr == b_curr && a_exRate == b_exRate){
					b_totalKrw = Number(b_totalKrw) + Number(sheetObj.CellValue(i, "sheet2_iss_amt"));
				}else{
					b_totalKrw = Number(b_totalKrw) + Number(sheetObj.CellValue(i, "sheet2_iss_amt"));
					a_totalKrw = a_totalKrw + Number(b_totalKrw)*ex_rate;
					b_totalKrw = 0;
				}				
				//alert(b_totalKrw+"::"+a_totalKrw);

				totalKrw = Number(totalKrw) + Number(sheetObj.CellValue(i, "sheet2_locl_amt"));
			}
		}
		//alert(Math.round(a_totalKrw));
		document.getElementById("total_usd").innerHTML = ComAddComma(totalUsd.toFixed(2));
		document.getElementById("vat_krw").innerHTML = ComAddComma(vatKrw);
		//document.getElementById("total_krw").innerHTML = ComAddComma(totalKrw);
		document.getElementById("total_krw").innerHTML = ComAddComma(Math.round(a_totalKrw));
	}
	
	/**
	 * B/L COUNT와 TOTAL AMT(KRW)을 계산한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function calTotalSum() {
		var blNoCnt = 0;
		var totalKrw = 0;
		var formObj = document.form;
		var mainSheet = sheetObjects[0];
		var hiddenSheet = sheetObjects[2];
		
		var a_curr = "";
		var b_curr = "";
		var ex_rate = "";
		var b_totalKrw = 0;
		var a_totalKrw = 0;
		
		if(mainSheet.RowCount > 0) {
			for(i = 1 ; i < mainSheet.Rows; i++){
				if (mainSheet.CellValue(i, "sheet1_bl_src_no") != '') {
					blNoCnt++;
				}
			}
		}
		
		if(hiddenSheet.RowCount > 0) {
			for(i = 1 ; i < hiddenSheet.Rows; i++){
				totalKrw = Number(totalKrw) + Number(hiddenSheet.CellValue(i, "sheet3_locl_amt"));
				
				b_curr = hiddenSheet.CellValue(i, "sheet3_curr_cd");
				a_curr = hiddenSheet.CellValue(i+1, "sheet3_curr_cd");
				b_exRate = hiddenSheet.CellValue(i, "sheet3_inv_xch_rt");
				a_exRate = hiddenSheet.CellValue(i+1, "sheet3_inv_xch_rt");
				ex_rate = hiddenSheet.CellValue(i, "sheet3_inv_xch_rt");
				//alert(a_curr+"::"+b_curr);
				if(a_curr == b_curr && a_exRate == b_exRate){
					b_totalKrw = Number(b_totalKrw) + Number(hiddenSheet.CellValue(i, "sheet3_iss_amt"));
				}else{
					b_totalKrw = Number(b_totalKrw) + Number(hiddenSheet.CellValue(i, "sheet3_iss_amt"));
					a_totalKrw = a_totalKrw + Number(b_totalKrw)*ex_rate;
					b_totalKrw = 0;
				}				
				//alert(b_totalKrw+"::"+a_totalKrw);

				totalKrw = Number(totalKrw) + Number(hiddenSheet.CellValue(i, "sheet3_locl_amt"));
			}
		}
		
		formObj.bl_no_cnt.value = ComAddComma(blNoCnt)
		formObj.total_amt.value = ComAddComma(Math.round(a_totalKrw));
		
	}
	
	
	/**
	 * main 그리드 삭제시 main 그리드와 charge 그리드, 통합 charge 그리드의 선택된 B/L NO를 삭제한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {rownum} selectRow
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function delMainSheet(selectRow) {
		var mainSheet = sheetObjects[0];
		var chargeSheet = sheetObjects[1];
		var hiddenSheet = sheetObjects[2];
		
		var prefix1 = "sheet1_";
		var prefix3 = "sheet3_";
		
		var blSrcNo = mainSheet.CellValue(selectRow, prefix1 + "bl_src_no");
		//main 그리드 삭제
		mainSheet.RowDelete(selectRow, false);
		//charge 그리드 삭제
		chargeSheet.RemoveAll();
		//통합 charge 그리드 삭제
		if(hiddenSheet.RowCount > 0) {
			for(var i=hiddenSheet.rowCount; i>0; i--){
				if (hiddenSheet.CellValue(i, prefix3 + "bl_src_no") == blSrcNo) {
					hiddenSheet.RowDelete(i, false);
				}
			}
		}
	}
	
	/**
	 * chareg 그리드의 내용을 통합 charge 그리드에 옮긴다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function setHiddenChargeList(sheetObj) {
		var hiddenSheet = sheetObjects[2];
		
		//sheet1의 데이터를 조회XML로 만들기
		var sXml = ComMakeSearchXml(sheetObj, true);

		//sheet3로 조회XML 로드하기
		hiddenSheet.LoadSearchXml(sXml, true);

		//B/L COUNT와 TOTAL AMT(KRW)을 계산한다.
		calTotalSum();
	}
	
	/**
	 * 통합 charge 그리드의 같은 B/L No의 정보를 수정한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function updateHiddenChargeList(sheetObj) {
		var chargeSheet = sheetObj;
		var hiddenSheet = sheetObjects[2];
		
   		var prefix2 = "sheet2_";
   		var prefix3 = "sheet3_";
		
		if(chargeSheet.RowCount > 0) {
			for(var i = 1; i < chargeSheet.Rows; i++){
				for(var j = 1; j < hiddenSheet.Rows; j++){
					if((hiddenSheet.CellValue(j, prefix3 + "bl_src_no") == chargeSheet.CellValue(i, prefix2 + "bl_src_no")) 
						&& (hiddenSheet.CellValue(j, prefix3 + "ar_if_no") == chargeSheet.CellValue(i, prefix2 + "ar_if_no"))
						&& (hiddenSheet.CellValue(j, prefix3 + "ar_if_ser_no") == chargeSheet.CellValue(i, prefix2 + "ar_if_ser_no"))
						&& (hiddenSheet.CellValue(j, prefix3 + "chg_seq") == chargeSheet.CellValue(i, prefix2 + "chg_seq"))) {
						hiddenSheet.CellValue2(j, prefix3 + "rat_as_cntr_qty") = chargeSheet.CellValue(i, prefix2 + "rat_as_cntr_qty");
						hiddenSheet.CellValue2(j, prefix3 + "trf_rt_amt") = chargeSheet.CellValue(i, prefix2 + "trf_rt_amt");
						hiddenSheet.CellValue2(j, prefix3 + "per_tp_cd") = chargeSheet.CellValue(i, prefix2 + "per_tp_cd");
						hiddenSheet.CellValue2(j, prefix3 + "iss_amt") = chargeSheet.CellValue(i, prefix2 + "iss_amt");
						hiddenSheet.CellValue2(j, prefix3 + "inv_xch_rt") = chargeSheet.CellValue(i, prefix2 + "inv_xch_rt");
						hiddenSheet.CellValue2(j, prefix3 + "ar_curr_cd") = chargeSheet.CellValue(i, prefix2 + "ar_curr_cd");
						hiddenSheet.CellValue2(j, prefix3 + "locl_amt") = chargeSheet.CellValue(i, prefix2 + "locl_amt");
						hiddenSheet.CellValue2(j, prefix3 + "chg_cd") = chargeSheet.CellValue(i, prefix2 + "chg_cd");
						hiddenSheet.CellValue2(j, prefix3 + "curr_cd") = chargeSheet.CellValue(i, prefix2 + "curr_cd");
						hiddenSheet.CellValue2(j, prefix3 + "chg_amt") = chargeSheet.CellValue(i, prefix2 + "chg_amt");
						hiddenSheet.CellText(j, prefix3 + "iss_amt") = chargeSheet.CellValue(i, prefix2 + "iss_amt");
						hiddenSheet.CellValue(j, prefix3 + "iss_amt") = chargeSheet.CellValue(i, prefix2 + "iss_amt");
						hiddenSheet.CellValue(j, prefix3 + "ar_ofc_cd") = chargeSheet.CellValue(i, prefix2 + "ar_ofc_cd");
					}
					/*else if(hiddenSheet.CellValue(j, prefix3 + "bl_src_no") == chargeSheet.CellValue(i, prefix2 + "bl_src_no")
							&& hiddenSheet.CellValue(j, prefix3 + "chg_seq") == chargeSheet.CellValue(i, prefix2 + "chg_seq")){
						hiddenSheet.CellValue2(j, prefix3 + "rat_as_cntr_qty") = chargeSheet.CellValue(i, prefix2 + "rat_as_cntr_qty");
						hiddenSheet.CellValue2(j, prefix3 + "trf_rt_amt") = chargeSheet.CellValue(i, prefix2 + "trf_rt_amt");
						hiddenSheet.CellValue2(j, prefix3 + "per_tp_cd") = chargeSheet.CellValue(i, prefix2 + "per_tp_cd");
						hiddenSheet.CellValue2(j, prefix3 + "iss_amt") = chargeSheet.CellValue(i, prefix2 + "iss_amt");
						hiddenSheet.CellValue2(j, prefix3 + "inv_xch_rt") = chargeSheet.CellValue(i, prefix2 + "inv_xch_rt");
						hiddenSheet.CellValue2(j, prefix3 + "ar_curr_cd") = chargeSheet.CellValue(i, prefix2 + "ar_curr_cd");
						hiddenSheet.CellValue2(j, prefix3 + "locl_amt") = chargeSheet.CellValue(i, prefix2 + "locl_amt");
						hiddenSheet.CellValue2(j, prefix3 + "bl_src_no") = chargeSheet.CellValue(i, prefix2 + "bl_src_no");						
						hiddenSheet.CellValue2(j, prefix3 + "chg_cd") = chargeSheet.CellValue(i, prefix2 + "chg_cd");
						hiddenSheet.CellValue2(j, prefix3 + "curr_cd") = chargeSheet.CellValue(i, prefix2 + "curr_cd");
					}*/										
				}				
			}
		}
	}
	
	/**
	 * 신규 B/L NO 입력시 기입력여부 체크<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
     * @param  {IBSheet} sheetObj
     * @param  {rownum} Row
     * @param  {colnum} Col
     * @param  {object} Value
	 * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.05.04
	 */ 
	function chkBlNoDuplicate(sheetObj,Row,Col,Value) {
		var blNoCnt = 0;
		var mainSheet = sheetObjects[0];
		
		if(sheetObj.RowCount > 0) {
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (sheetObj.CellValue(i, "sheet1_bl_src_no") == Value) {
					blNoCnt++;
				}
			}
		}
		if (blNoCnt > 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/** 
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		setDefaultDateValue(formObj);
		
		document.getElementById("total_usd").innerHTML = "0";
		document.getElementById("vat_krw").innerHTML = "0";
		document.getElementById("total_krw").innerHTML = "0";
		
    	ComEnableObject(formObj.inv_no,	true);
    	ComEnableObject(formObj.iss_dt,	true);
    	formObj.inv_no.className = "input1";
    	formObj.iss_dt.className = "input1";
    	
    	formObj.ofc_cd.Enable = true;
		
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SelectCell(sheetObjects[0].SelectRow,1);
		formObj.btns_calendar.disabled = false;
	}
	
	/** 
	 * Rd 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {RdObject} rdObject
	 * @param  {object} formObj    
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function rdOpen(rdObject, formObj){
		
		var formObject = document.form; 
		var Rdviewer = rdObject;
		
		var invNo = formObj.inv_no.value;
		var invSeq = formObj.inv_seq.value;
		var ofcCd = formObj.ar_ofc_cd.value;
		var invPrnDvcNm = formObj.inv_prn_dvc_nm.value;
		
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";
		var rdFile = "FNS_INV_0519.mrd";
		var rdParam = "/rv frm1_inv_no["+invNo+"] frm1_ar_ofc_cd ["+ofcCd+"] frm1_inv_seq["+invSeq+"]";
	
		// 열고자 하는 RD 파일을 지정한다.		
////////Preview 작업 이전 소스 - Start
//		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");
////////////Preview 작업 이전 소스 - End		
//원래주석		//Rdviewer.FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait"); 
		
		formObject.com_mrdPath.value = rdFile+"|";
		formObject.com_mrdArguments.value = rdParam;
		ComOpenWindowCenter("FNS_INV_0034_02_prev.do?view_flag=K", "pop3", 800, 700);

//////////// Preview 작업 이전 소스 - Start 
//		//프린트세팅
//		if(invPrnDvcNm != ""){
//			Rdviewer.SetPrintInfo (invPrnDvcNm, 1, 1, 4);
//		}
//		
//		Rdviewer.CMPrint();
//////////// Preview 작업 이전 소스 - End 
	}
	
	/** 
	 * office code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function MakeComboObject(cmbObj, arrStr) {
 		cmbObj.RemoveAll(); 
 		
 		for (var i = 1; i < arrStr.length;i++ ) {
 			var arrStr2 = arrStr[i].split("^");
 			var ofc_cd = arrStr2[1];
 			
 			cmbObj.InsertItem(i-1, ofc_cd, arrStr[i]);
 		}
 		cmbObj.BackColor = "#CCFFFD";
	}

	/**
	 * 날짜조건의 값을 초기화한다.
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param formObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function setDefaultDateValue(formObj) {
		today = new Date();
  		
		var year = today.getYear();
		var mon  = today.getMonth()+1;
		var sday = today.getDate();
		
		var vDay = year+"-"+ComLpad(mon,2,"0")+"-"+ComLpad(sday,2,"0");
		
		formObj.iss_dt.value = vDay;
	}
	
	/** 
	 * VoList를 array[array[name]]형태로 변환<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function ComXml2ListMap(xmlStr) {
		var rtnArr = new Array();

		if (xmlStr == null || xmlStr == "") {
			return rtnArr;
		}

		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);

			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return rtnArr;
			}

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return rtnArr;
			}

			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChileNodes = dataNode.childNodes;
			if (dataChileNodes == null) {
				return rtnArr;
			}

			for ( var i = 0; i < dataChileNodes.length; i++) {
				if (dataChileNodes[i].nodeType != 1) {
					continue;
				}
				
				var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

				var subDataArr = new Array();
				
				for ( var j = 0; j < arrData.length; j++) {
					subDataArr[colArr[j]] = arrData[j];
				}
				
				rtnArr[i] = (subDataArr);
			}

		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return rtnArr;
	}

	/** 
	 * Array의 name 과 HTML form의 이름이 동일할경우 form의 객체에 Value설정<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {form} form html 폼 
	 * @param {map} Array[name] 의 값 
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function ComMapToForm(form, map) {		
		//사용가능한 컨트롤을 배열로 생성한다.
		var len = form.elements.length;
		for (var i = 0; i < len; i++) {
			if (form.elements[i].classid == undefined) {
				var xvalue = map[form.elements[i].name];
				if (xvalue == undefined)
					continue;
				switch (form.elements[i].type) {
				case "button":
				case "reset":
				case "submit":
					break;
				case "radio":
					var eRadio = document.all[form.elements[i].name];
					var idx = 0;
					for ( var k = 0; k < eRadio.length; k++) {
						if (eRadio[k].value == xvalue) {
							idx = k;
							break;
						}
					}
					eRadio[idx].checked = true;
					break;
				case "checkbox":
					form.elements[i].checked = xvalue;
					break;
				case "select-one":
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						for ( var k = 0; k < opt_len; k++) {
							if (eOpt[k].value == xvalue) {
								idx = k;
								break;
							}
						}
					}
					form.elements[i].selectedIndex = idx;
					break;
				case "select-multiple": //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						var tvalue = xvalue.split("|");
						var tval_len = tvalue.length;
						for ( var k = 0; k < opt_len; k++) {
							for ( var m = 0; m < tval_len; m++) {
								if (eOpt[k].value == tvalue[m])
									eOpt[k].selected = true;
							}
						}
					}
					break;
				default:
					switch (form.elements[i].name) {
//						case "curr_cd":
//							form.elements[i].value = xvalue;
//						break;
//						case "ar_tax_ind_cd":
//							form.elements[i].value = xvalue;
//						break;
						case "cgo_meas_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "bkg_teu_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "bkg_feu_qty":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "good":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "nogood":
							form.elements[i].value = ComAddCommaRun(xvalue);
						break;
						case "cust_rgst_no":
							form.elements[i].value = ComGetMaskedValue(xvalue, "saupja");
						break;
						default:
							form.elements[i].value = xvalue;
						break;
					}
				}
			}
		}
	}
	
	/** 
     * sheet상에서 데이타를 받아 sheet의 콤보박스에 세팅. <br>
     * curr_cd : currency code 세팅
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {String} comboValues : 세팅할 값
     * @param  {String} colName : sheet에서 세팅할 컬럼
     * @return (boolean) isCellCombo : CellComboItem, InitDataCombo
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var ROWMARK = "|";
		var FIELDMARK = "=";

		comboValues = "|"+" "+comboValues;
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 1 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				if (comboItem[0] != "") {
					comboTxt += comboItem[0];
					comboVal += comboItem[0];
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
		}
	}
	/* 개발자 작업  끝 */