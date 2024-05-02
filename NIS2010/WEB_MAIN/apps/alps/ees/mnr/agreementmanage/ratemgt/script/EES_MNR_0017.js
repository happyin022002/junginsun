	/*=========================================================
	*Copyright(c) 2014 CyberLogitec
	*@FileName : EES_MNR_0017.js
	*@FileTitle : M&R Agreement Attachment_Pop Up
	*Open Issues :
	*Change history :
	*@LastModifyDate : 2014.12.15
	*@LastModifier : Chang Young Kim
	*@LastVersion : 1.0
	* 2014.12.15 Chang Young Kim
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
	 * @class ees_mnr_0017 : ees_mnr_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_mnr_0017() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl			= initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

//	var comboObjects = new Array();
//	var comboCnt = 0;
//
//	var comboValue = "";

	var rtnDataYn = "";
	
	var glRow = 0;
	
	var openerObj = window.dialogArguments;
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다.
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
//	function setComboObject(combo_obj){
//		comboObjects[comboCnt++] = combo_obj;
//	}
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 해당 메인에 포함되는 iframe으로 부터 값을 리턴받기 위한 정의 (S) */ 
	if(window.addEventListener) {
		window.addEventListener("message", receiveMessage, false);
	}

	if(window.attachEvent) {
		window.attachEvent("onmessage", receiveMessage);
	}

	if(document.attachEvent) {
		document.attachEvent("onmessage", receiveMessage);
	}

	// return 처리를 위한 함수 (필수)
	function receiveMessage(event) {
		// 리턴 처리 방법
		returnGwLink(event.data)
		
	}
	/* 해당 메인에 포함되는 iframe으로 부터 값을 리턴받기 위한 정의 (E) */
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_close":
					if(formObject.actn_flg.value == "S") {
						openerObj.setEES_MNR_0017(rtnDataYn);
					}
					window.close();
					break;
				case "btns_add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
				case "btns_del":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;
				
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
		}
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;
		var strActnFlg = formObj.actn_flg.value;
//		alert(formObj.agmt_ofc_cty_cd.value + "\n" +
//				formObj.agmt_seq.value + "\n" +
//				formObj.agmt_ver_no.value + "\n" +
//				formObj.actn_flg.value);
//		return;

		/* formObj.actn_flg.value => parent delivery parmaeter
		 * S : CRUD
		 * R : only R
		 */
		initPageControl(strActnFlg);
		rtnDataYn = formObj.file_atch_flg.value;
		
//		initControl()
//		MnrWaitControl(true);
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1,strActnFlg);
			ComEndConfigSheet(sheetObjects[i]);
		}
//		for(var k=0;k<comboObjects.length;k++){
//			initCombo(comboObjects[k],k + 1);
//		}

		var formObj  = document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
		
		if(!ComIsEmpty(formObj.agmt_ofc_cty_cd.value) &&
			!ComIsEmpty(formObj.agmt_seq.value) &&
			!ComIsEmpty(formObj.agmt_ver_no.value)) {
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		}
	}

	/**
	 * 초기 화면을 컨트롤함
	 * @param String paramActnFlg
	 */
	function initPageControl(paramActnFlg) {

		if(paramActnFlg == "S") {
			document.getElementById("div_grp_row").style.display	= "block";
			document.getElementById("div_grp_new").style.display	= "block";
			document.getElementById("div_new_line").style.display	= "block";
			document.getElementById("div_grp_save").style.display	= "block";
			document.getElementById("div_save_line").style.display	= "block";
		} else if(paramActnFlg == "R") {
			document.getElementById("div_grp_row").style.display	= "none";
			document.getElementById("div_grp_new").style.display	= "none";
			document.getElementById("div_new_line").style.display	= "none";
			document.getElementById("div_grp_save").style.display	= "none";
			document.getElementById("div_save_line").style.display	= "none";
		} else {
			document.getElementById("div_grp_row").style.display	= "none";
			document.getElementById("div_grp_new").style.display	= "none";
			document.getElementById("div_new_line").style.display	= "none";
			document.getElementById("div_grp_save").style.display	= "none";
			document.getElementById("div_save_line").style.display	= "none";
		}
	}

	/**
	 * Combo 기본 설정
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트.
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
//	function initCombo (comboObj, comboNo) {
//		switch(comboNo) {
//			case 1:
//				with (comboObj) {
//				SetColAlign("left|left");
//				SetColWidth("80|100");
//				DropHeight = 160;
//				UseAutoComplete = true;
//				}
//				break;
//		 }
//	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo,strActnFlg) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:	  // sheet1 init
				with (sheetObj) {
					// 높이 설정
					if(strActnFlg == "S") {
						style.height = 400;
					} else if(strActnFlg == "R") {
						style.height = 424;
					} else {
						style.height = 424;
					}

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					var HeadTitle = "|Sel|Seq|Contract Doc. No.|Contract Doc. Name";

					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,			30,		daCenter,		false,		"del_check");
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,		false,		"atch_file_seq",		false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtPopup,				150,	daCenter,		false,		"gw_uq_doc_no",			false,	"",		dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					60,		daLeft,			false,		"gw_uq_doc_tit_nm",		false,	"",		dfNone,		0,			false,		false);

//					InitUserFormat2(0, "eff_dt", "####-##-## ~ ####-##-##", "-|~" );
//					SelectionMode = smSelectionRow;
					CountPosition = 2;
					
					PopupImage  =  "/hanjin/img/btns_search.gif";
			   }
		 break;

		}
	}

//	function initControl() {
//		//Axon 이벤트 처리1. 이벤트catch
//		axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
//		axon_event.addListenerFormat('focus',   'obj_activate',	form);			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
//		axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
//	}

	/**
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
//	function obj_deactivate(){
//		obj = event.srcElement;
//		ComChkObjValid(event.srcElement);
//	}

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
//	function obj_activate(){
//		ComClearSeparator(event.srcElement);
//	}

	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/
//	function obj_keypress(){
//		obj = event.srcElement;
//		if(obj.dataformat == null) return;
//		window.defaultStatus = obj.dataformat;
//
//		switch(obj.dataformat) {
//			case "ymd":
//			case "int":
//				ComKeyOnlyNumber(obj);
//				break;
//			case "float":
//				ComKeyOnlyNumber(obj, ".");
//				break;
//			case "eng":
//				ComKeyOnlyAlphabet();
//				break;
//			case "engup":
//				ComKeyOnlyAlphabet('uppernum','45');
//			break;
//		}
//	}

	/**
	 * eq type Change 이벤트
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트
	 * @param  {String}	Index_Code   Index 나 코드
	 * @param  {String}	Text   텍스트
	 */
//	function combo1_OnChange(comboObj,Index_Code, Text){
//		var formObj  = document.form;
//		formObj.agmt_eq_type.value = comboObj.Code;
//	}

	/**
	 * ofc_cd Change 이벤트
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트
	 * @param  {String}	Index_Code   Index 나 코드
	 * @param  {String}	Text   텍스트
	 */
//	function combo2_OnChange(comboObj,Index_Code, Text){
//		var formObj  = document.form;
//		if(comboObj.Code=="A"){
//			formObj.agmt_ofc_cd.value = formObj.ofc_cd.value;
//		}else{
//			formObj.agmt_ofc_cd.value = comboObj.Code;
//		}
//	}

	/**
	 * sheet1 DblClick 이벤트
	 * @param {IBSheet}  sheetObj 콤보오브젝트
	 * @param  {String}	Row   Row Index
	 * @param  {String}	Col   Col Index
	 */
//	function sheet1_OnDblClick(sheetObj,Row,Col){
//		sheetObj.CellValue(Row,1) = "Y";
//		comPopupOK();
// 	}

  	/**
	 * Sheet1관련 프로세스 처리
	 * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트
	 * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
	 * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의)
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {

		switch(sAction) {
			case IBSEARCH:	//조회
				formObj.f_cmd.value = SEARCH;
				
				sheetObj.DoSearch("EES_MNR_0017GS.do",FormQueryString(formObj));
				
				break;
				
			case IBSAVE:	//저장
				formObj.f_cmd.value = MULTI;
//				prompt("save", sheetObj.GetSaveString(true)+ "&" + FormQueryString(formObj));
//				return;
				
				var sXml = sheetObj.GetSaveXml("EES_MNR_0017GS.do",sheetObj.GetSaveString(true)+ "&" + FormQueryString(formObj));
				
				//rtnDataYn Setting
				if(MnrComGetErrMsg(sXml) == null){
					if(ComGetEtcData(sXml, "ins_cnt") > 0) {
						rtnDataYn = "Y";
					} else {
						rtnDataYn = "N";
					}
				}
				
				break;
			case IBCLEAR:	//초기화
				MnrWaitControl(true);
				sheetObj.WaitImageVisible = false;
				//쉬트 초기화
				for(i=0;i<sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
				}

				//콤보 초기화
//				for(var i = 0; i < comboObjects.length;i++){
//					comboObjects[i].RemoveAll();
//				}

//				var sCondition = new Array (
//					new Array("MnrGenCd","SELHO","CUSTOM9"),	//Eq Kind
//					new Array("MnrOfcGenInfo","","AGMT")	//Agreement Office
//				);
//
//				var comboList = MnrComSearchCombo(sheetObj,sCondition);

				//콤보 설정(Eq Kind,Agreement Office)
//				for(var i = 0; i < comboList.length;i++){
//					if(comboList[i] != null){
//						//쉬트콤보별 초기화
//						sheetComboText = "";
//						sheetComboCode = "";
//						for(var j = 0; j < comboList[i].length;j++){
//							var tempText = comboList[i][j].split("|");
//							sheetComboText +=  tempText[1] + "|";
//							sheetComboCode +=  tempText[0] + "|";
//							//Eq Kind
//							if(i==0) {
//								formObj.combo1.InsertItem(j, tempText[1] ,tempText[0]);
//							//Agreement Office
//							} else if(i==1){
//								formObj.combo2.InsertItem(j, tempText[1] ,tempText[0]);
//							}
//						}
//					}
//				}

//				formObj.combo1.InsertItem(0, "ALL" ,"A" );
//				formObj.combo1.Code = "A";
//
//				formObj.combo2.InsertItem(0, "ALL" ,"A" );
//				formObj.combo2.Code = "A";
//
//				formObj.agmt_ofc_cd.value = formObj.ofc_cd.value;
//				formObj.agmt_fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
//				formObj.agmt_to_dt.value = ComGetNowInfo();

				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
				break;
				
			case IBINSERT:	  // Row insert
				sheetObj.DataInsert(-1);
				// sheet1의 atch_file_seq를 전체행의 갯수로 초기화한다.
				initSheetSeq(sheetObj, "atch_file_seq");
				break;
			
			case IBDELETE:	  // Row Delete
				MnrRowDelete(sheetObj, "del_check");
				// sheet1의 atch_file_seq를 전체행의 갯수로 초기화한다.
				initSheetSeq(sheetObj, "atch_file_seq");
				break;
		}
	}
	
	/**
	 * sheet의 seq를 전체행의 갯수로 초기화한다.
	 * @param Object sheetObject
	 * @parma String colNm
	 */
	function initSheetSeq(shtObj, colNm) {
		for(var idx = 1; idx <= shtObj.RowCount; idx++) {
			shtObj.CellValue2(idx, colNm) = idx;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트
	 * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
	 * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의)
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
	 		case IBSAVE: // 저장
	 			
				break;
		}
		return true;
	}
	
	function sheet1_OnPopupClick(sheetObj, row,col){
//		alert(sheetObj.id + ", " + row + ", " + col);
		var formObject = document.form;
		
		var csrGwUrl = formObject.csr_gw_url.value;
		
		// for Local Server Test
		if(csrGwUrl != "null") {
			
			//해당 메인에 포함되는 iframe 동적 생성 (GW 호출하기 위한 IFrame)
			ifrm = document.createElement("IFRAME");
			ifrm.setAttribute("id", "gwrequest");
			ifrm.style.width = 0+"px";
			ifrm.style.height = 0+"px";
			
			// for Local Server Test
			if(!ComIsEmpty(sheetObj.CellValue(row, col))) { // 계약문서 번호가 있을 때
				
				var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+sheetObj.CellValue(row, col));
				ifrm.setAttribute("src", url);
				document.body.appendChild(ifrm);
				
			} else {
				
				 var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS|MNR");
				 ifrm.setAttribute("src", url);
				 document.body.appendChild(ifrm);
				
			}
			
		} else {
			//msgs['MNR00312'] = 'You have no authority to {?msg1}.';
			ComShowCodeMessage('MNR00312', "G/W. ");
			return;
		}
		
		// GW 리턴후 값세팅을 위한 전역 변수값 세팅
		glRow = row;
	}
	
	//GW에서 리턴된 값 화면 적용
	function returnGwLink(msg) {
		var shtObj = sheetObjects[0];
		msg = msg.split(",");
		
		var formObj = document.form;
//		alert(msg[0] +  ", " + msg[1]);
		// setting
		shtObj.CellValue2(glRow, "gw_uq_doc_no") = msg[0];
		shtObj.CellValue2(glRow, "gw_uq_doc_tit_nm") = msg[1];
		
	}
	