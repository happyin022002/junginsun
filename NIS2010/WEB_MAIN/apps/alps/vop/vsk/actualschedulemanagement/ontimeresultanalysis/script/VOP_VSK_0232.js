/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0232.js
 *@FileTitle : Target VVD & Remark(s)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.08.26 정진우
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
	 * @class VOP_VSK_0232 : VOP_VSK_0232 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_VSK_0232() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}

	/* 개발자 작업	*/



	//공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;


	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		  
		var sheetObject = sheetObjects[0];
		  
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_close":
					window.close();
					break;
						
				case "btn_ok":
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
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initLoadAction(sheetObjects[0], document.form);
	}
	
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerForm('focus', 'obj_focus', formObj);
	}
	
	function obj_focus() {
		if(event.srcElement.options){
			event.srcElement.focus();
		}else{
			event.srcElement.select();
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 210;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					/*
					 * mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
					 *  
					 * SortEnable Boolean 선택  해더 행의 소트 가능 여부, Default=true 
					 * ColumnMove Boolean 선택  해더 행의 컬럼 이동 가능 여부, Default=false
					 * AllCheckEnable Boolean 선택  해더 행의 전체 CheckBox 표시 여부, Default=true
					 * UserResize Boolean 선택  해더 행의 컬럼 너비 변경 가능 여부, Default=true
					 * RowMove Boolean 선택  좌측 해더의 행 이동 가능 여부, Default=false
					 * Head3D Boolean 선택  해더 셀의 모양의 입체 여부Default=true 
					 */
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "|VVD|Port|RSN Port|Arr/Dep|RSN|HR|Remark";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);


					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	false,	prefix+"vvd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,	daCenter,	false,	prefix+"vps_port_cd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	false,	prefix+"reason_port",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,	daCenter,	false,	prefix+"arr_dep",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					40,	daCenter,	false,	prefix+"rsn_cd",			false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					40,	daCenter,	false,	prefix+"delay_tm",				false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					115,daLeft,		false,	prefix+"rmk",		false,	"",		dfNone,				0,			true,		true);
					
//					CountPosition = "0";
					WaitImageVisible = false;
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
						
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
			
					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");					
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0232GS.do", sParam);
						
					showSheetData(sheetObj, formObj, sXml);
					ComOpenWait(false);
				}
				break;
						
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction))
				break;
						
			case IBINSERT:      // 입력
				break;
		}
	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}

		return true;
	}

	/**
	 * 조회 후 처리로직.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @return
	 */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix = sheetObj.id + "_";
		
		if(sXml != null){
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(sXml);

			var dataNode = xmlDoc.selectSingleNode("//DATA/@TOTAL");
			if(dataNode.length > 0){
				var totValue = dataNode.value;

				if(totValue > 0){
					sheetObj.Redraw = false;
					sheetObj.LoadSearchXml(sXml);
					sheetObj.Redraw = true;
				}
			}else{
				sheetObj.LoadSearchXml(sXml);
//				clearAllFormData(formObj);
//				formObj.vps_port_cd.focus();
//				return;
			}
		}
	}
	
	/**
	 * 화면 Open 시 해당 Data 를 조회한다.
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function initLoadAction(sheetObj, formObj){
		var opner = window.dialogArguments;
		var prefix = sheetObj.id + "_";
		var pSheetObj = null;
		
		if(opner.sheetObjects){
			if(opner.sheetObjects.length > 0){
				pSheetObj = opner.sheetObjects[opner.beforetab];
				var pPrefix = getParentSheetPrefix(pSheetObj);
				var tabIdx = opner.beforetab;
				
				var selRows = pSheetObj.GetSelectionRows("|");
				if(selRows == null || selRows == undefined && selRows == ""){
					//선택된 행이 없습니다.
					ComShowCodeMessage("VSK00020");
					return false;
				}
				var selRowArr = selRows.split("|");
				var conObjs = pSheetObj.CellValue(selRowArr[0], pPrefix+"lane");
				for(var i=1; i<selRowArr.length; i++){
					conObjs = conObjs + "," + pSheetObj.CellValue(selRowArr[i], pPrefix+"lane");
				}

				formObj.fm_dt.value 			= opner.form.act_inp_fm_dt.value;
				formObj.to_dt.value 			= opner.form.act_inp_to_dt.value;
				formObj.ig_flg.value 			= getRadioCheckValue(opner.form.lane_grp);
				formObj.vsl_slan_cd.value 		= opner.form.vsl_slan_cd.value;
				
				formObj.lane_grp_nm.value 		= opner.form.lane_grp_nm.Text;
				formObj.vsl_cd.value 			= opner.form.vsl_cd.value;
				formObj.vps_port_cd.value 		= opner.form.vps_port_cd.value;
				formObj.crr_cd.value 			= opner.form.crr_cd.value;
				formObj.tab_flg.value 			= Number(tabIdx) + 1;
				formObj.grp_flg.value 			= opner.form.grp_flg[tabIdx].value;
				formObj.condition.value 		= conObjs;
				formObj.port_skp_tp_cd.value 	= getRadioCheckValue(opner.form.port_skp_tp_cd);
//				formObj.ie_flg.value = opner.form.ie_flg[].value;
				
				if(tabIdx == "0"){
					sheetObj.ColHidden(prefix + "reason_port") = true;
				}else{
					sheetObj.ColHidden(prefix + "arr_dep") = true;
					sheetObj.ColHidden(prefix + "rsn_cd") = true;
					sheetObj.ColHidden(prefix + "delay_tm") = true;
				}
				
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}
	
	/**
	 * 부모창의 Sheet의 prefix 를 찾는다.
	 * @param pSheetObj
	 * @return
	 */
	function getParentSheetPrefix(pSheetObj){
		var prefix = "";
		if(pSheetObj.id == "t1sheet1"){
			prefix = "sheet1_";
		}else if(pSheetObj.id == "t2sheet1"){
			prefix = "sheet2_";
		}
		
		return prefix;
	}
	
	/**
	 * 해당 radio 버튼의 체크된 값을 찾는다.
	 * @param radioObj
	 * @return
	 */
	function getRadioCheckValue(radioObj){
		var rdoCnt = radioObj.length;
		
		for(var i=0; i<rdoCnt; i++){
			if(radioObj[i].checked){
				return radioObj[i].value;
			}
		}
		
		return "";
	}


	/* 개발자 작업  끝 */