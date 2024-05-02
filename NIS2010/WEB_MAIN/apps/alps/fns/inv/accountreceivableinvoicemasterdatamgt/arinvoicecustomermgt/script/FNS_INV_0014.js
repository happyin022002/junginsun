/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0014.js
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
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
	 * @class fns_inv_0014 : fns_inv_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0014() {
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
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
				case "btn_retrive":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
		
				case "btn_new":
					sheetObject.RemoveAll();
					doActionIBSheet(sheetObjects[0],formObject,IBRESET);
					break;
		
				case "btn_downExcel":
					sheetObject.SpeedDown2Excel(-1);
					break;	
					
				case "btn_print":
					if (sheetObject.RowCount == 0) {
						ComShowCodeMessage("INV00095");
						return false;
					}
					rdOpen();
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
	 * print화면 오픈
	 * @param vvd VVD
	 * @param io_bnd_cd io_bnd_cd
	 */
	function rdOpen() {
		
		var formObject = document.form;
		var cust_cnt_cd = formObject.cust_cnt_cd.value;
		var cust_type = formObject.cust_type.value;
		var cust_nm = formObject.cust_nm.value;
		var locl_zip_cd = formObject.locl_zip_cd.value;
		var cr_clt_ofc_cd = formObject.cr_clt_ofc_cd.value;
		var cr_flg = "";
		if(formObject.cr_flg[1].checked == true){
			cr_flg = "Y";
		}else if(formObject.cr_flg[2].checked == true){
			cr_flg = "N";
		}
		var credit_type = "";	
		if(formObject.credit_type[1].checked == true){
			credit_type = "I";
		}else if(formObject.credit_type[2].checked == true){
			credit_type = "O";
		}
		var chk_nm = "";
		var cust_nm1 = "";
		var cust_nm2 = "";
		var cust_nm3 = "";
		if(formObject.chk_nm.checked == true){
			chk_nm = "Y";
			var arrStr = cust_nm.split(" ");
			cust_nm1 = arrStr[0];
			cust_nm2 = arrStr[1];
			cust_nm3 = arrStr[2];
			if(cust_nm1 == undefined) cust_nm1 = "";
			if(cust_nm2 == undefined) cust_nm2 = "";
			if(cust_nm3 == undefined) cust_nm3 = "";
		}
		
		var rdFile = "FNS_INV_0532.mrd";		
		var rdParam = "/rv frm1_cust_cnt_cd["+cust_cnt_cd+"] frm1_cust_type["+cust_type+"] frm1_cust_nm["+cust_nm+"] frm1_locl_zip_cd["+locl_zip_cd+"] frm1_cr_clt_ofc_cd["+cr_clt_ofc_cd+"] frm1_cr_flg["+cr_flg+"] frm1_credit_type["+credit_type+"] frm1_chk_nm["+chk_nm+"] frm1_cust_nm1["+cust_nm1+"] frm1_cust_nm2["+cust_nm2+"] frm1_cust_nm3["+cust_nm3+"]";
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemasterdatamgt/arinvoicecustomermgt/report/";
		//alert(rdParam);
		rdObjects[0].FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
		//rdObjects[0].FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
		rdObjects[0].CMPrint ();
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
     * RD Object 초기화 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initRdConfig(rdObject)
     * </pre>
     * @param {rdviewer} rdObject Rdviewer Object
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */ 
    function initRdConfig(rdObject){
	     var Rdviewer = rdObject;
	     Rdviewer.style.height = 0;
	     Rdviewer.style.width = 0;
	    
	     Rdviewer.AutoAdjust = true;
	     Rdviewer.ViewShowMode(0);
	    
		 Rdviewer.setbackgroundcolor(128,128,128);
		 Rdviewer.SetPageLineColor(128,128,128);
	 }
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );	
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);	
		}
		initRdConfig(rdObjects[0]);
		document.form.cust_nm.focus();
		initControl();
	
	}
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	
	function obj_keypress(){
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "ymd":
				//숫자+"-"입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "eng":
				//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
				ComKeyOnlyAlphabet();
				break;
			case "engdn":
				//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
				ComKeyOnlyAlphabet('lower');
				break;
			case "engup":
				//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
				switch(event.srcElement.name){
		
				case "cust_nm":	    	        	
					//영문대문자+숫자 입력하기
					if(event.keyCode >= 97 && event.keyCode <= 122)
					{
						event.keyCode = event.keyCode - 32;
					}else if(event.keyCode == 32){
						event.keyCode = event.keyCode;
					}
					break;
				default:
					//영문대문자만입력하기		    	        
					ComKeyOnlyAlphabet('upper'); break;
				}
				break;
			case "num":
				//숫자만입력하기(정수,날짜,시간)
				ComKeyOnlyNumber('num');
				break;
			case "uppernum":
				//영문대+숫자 
				ComKeyOnlyAlphabet('uppernum');
				break;
			default:
				//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
				ComKeyOnlyAlphabet('upper');
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 380;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			//MergeSheet = msAll;
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			//InitRowInfo( 2, 2, 10, 100);
			InitRowInfo( 1, 1, 3, 100);                     
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//InitHeadMode(false, true, true, true, false,false)
			InitHeadMode(true, true, true, true, false,false)
	
			var HeadTitle       = "|Seq|Cust. Code|Customer Name|Sales Office|Customer Local Name|Address|Biz Registry No|Zip Code|Actual Payer|Credit Office|Credit Cur|Credit Limit|I/B Credit Term|O/B Credit Term|KOR I/B Office";
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			var rowCnt = 0;
	
			var Code = 100;
			var Name = 200;
			var Biz = 100;
			var Limit1 = 100;
			var Limit2 = 100;
	
			var CrOffice = 100;
			var SaOffice = 80;
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtHiddenStatus,	0,    daCenter,  	true,	"ibflag");
			
			InitDataProperty(rowCnt, cnt++ , dtSeq,			40,		daCenter,	false,	  "sheet1_seq");
			InitDataProperty(rowCnt, cnt++ , dtData,     Code,    	daCenter,  	false,    "sheet1_cust_cd",     		false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     Name,    	daLeft,  	false,    "sheet1_cust_lgl_eng_nm",     false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     SaOffice, daCenter,  	false,    "sheet1_ofc_cd",     			false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     Name,    	daLeft,  	false,    "sheet1_locl_nm",     		false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     350,    	daLeft,  	false,    "sheet1_addr",	     		false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     Biz,    	daCenter,  	false,    "sheet1_cust_rgst_no",     	false,          "",      dfSaupNo );
			InitDataProperty(rowCnt, cnt++ , dtData,     SaOffice, daCenter,  	false,    "sheet1_locl_zip_cd",     	false,          "",      dfPostNo );
			InitDataProperty(rowCnt, cnt++ , dtData,     Code,    	daCenter,  	false,    "sheet1_act_payer",     		false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     CrOffice, daCenter,  	false,    "sheet1_cr_clt_ofc_cd",     	false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     CrOffice, daCenter,  	false,    "sheet1_cr_curr_cd", 			false,          "",      dfNone );                     
			InitDataProperty(rowCnt, cnt++ , dtData,     Limit1,   daCenter,  	false,    "sheet1_cr_amt",     			false,          "",      dfFloat,    2 );                     
			InitDataProperty(rowCnt, cnt++ , dtData,     Limit1,   daCenter,  	false,    "sheet1_ib_cr_term_dys",     	false,          "",      dfInteger );
			InitDataProperty(rowCnt, cnt++ , dtData,     Limit2,   daCenter,  	false,    "sheet1_ob_cr_term_dys",     	false,          "",      dfInteger );
			InitDataProperty(rowCnt, cnt++ , dtData,     CrOffice, daCenter,  	false,    "sheet1_kr_ib_ofc_cd",     	false,          "",      dfNone );                                                                                                         
	
			FrozenCols = 3;
			
			WaitImageVisible = false; 
			
		}
		break;
	
	
	
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,CondParam, PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {	
	
			case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;	
			if(validateForm(sheetObj,formObj,sAction)) { 
				ComOpenWait(true);
				sheetObj.DoSearch("FNS_INV_0014GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
			} else {
				break;
			}
			break;
		
			case IBRESET: // New
			formObj.locl_zip_cd.value="";
			formObj.credit_type.value = "";
			formObj.cr_clt_ofc_cd.value = "";
			formObj.cust_cnt_cd.value = "";
			formObj.cust_nm.value = "";
			formObj.cust_nm.focus();
			formObj.cr_flg[0].checked = true;
			formObj.credit_type[0].checked = true;
			break;
		}
	}
		
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (formObj.cust_nm.value.trim() == ""){
				ComShowCodeMessage("INV00004");
				formObj.cust_nm.focus();
				return;
			}

			if (formObj.cust_nm.value.length  <  3 ){
				ComShowCodeMessage("INV00004");
				formObj.cust_nm.focus();
				return;
			}
		}
	
		return true;
	}
	
	function MakeComboObject2(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, ar_ofc_cd);
		}
	}      
	
	/**
	 * OnMouseMove 이벤트 발생시 호출되는 function <br>
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
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		//마우스 위치를 행과 컬럼과 값 가져오기
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		//풍선도움말 만들기
		var sText = sheetObj.CellText(Row,Col);
		if(sText != "") {
			sheetObj.MouseToolTipText = sText;
		}
	}	
	
	/** 
     * sheet상에서 더블클릭했을때 발생하는 이벤트로 팝업화면을 호출한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {int} Row : 포커스가 위치해 있는 sheet의 Row
     * @param  {int} Col : 포커스가 위치해 있는 sheet의 Col 
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
	function sheet1_OnDblClick(sheetObj, row, col) {
		var act_cust = sheetObj.CellText(row, 'sheet1_cust_cd');
		
		var v_act_cust_cnt_cd = act_cust.substr(0,2);
		var v_act_cust_seq = act_cust.substr(3,6);
		var classId = "FNS_INV_0013";
		var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;

		ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 920, 650, 'getFNS_INV_0013', '1,0,1,1,1', true);
	}
	
	/** 
     * 팝업창(FNS_INV_0013)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
     * @return 없음
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
 	function getFNS_INV_0013() {
		
	}
	
	/* 개발자 작업  끝 */