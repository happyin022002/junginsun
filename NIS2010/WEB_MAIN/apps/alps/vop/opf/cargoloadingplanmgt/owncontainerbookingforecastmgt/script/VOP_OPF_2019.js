/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_2019.js
 *@FileTitle : CBF Summary Preview
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.27 우지석
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 * 2013.06.20 CHM-201324915 SKY  CBF – POD TMNL code로 구분
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
	 * @class vop_opf_2019 : vop_opf_2019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function vop_opf_2019() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}

	/* 개발자 작업	*/
	
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt     = 0;
	var beforetab  = 1;
	
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	
	var IBSEARCH02 = 30;
	var IBSEARCH03 = 33;
	var IBSEARCH11 = 31;
	var IBSEARCH12 = 32;
	
	var stwgNmList;	
	
	var uid;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {	
		
		var formObj   = document.form;
		var sheetObj  = sheetObjects[0];
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {	
				case "btn1_WGC":
					openWgcPopup(formObj);
					break;
		
				case "btn1_Close":
					window.close();
					break;

			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 **/
	function initControl() {
		axon_event.addListenerForm  ('click',    'obj_click',    form);
	}
	/** 
	 * Weight Group (Creation) 버튼 클릭시 팝업호출
	 */
	function openWgcPopup(formObj) {
		var vSlanCd   = ComGetObjValue(formObj.vsl_slan_cd);
		var vSkdDirCd = ComGetObjValue(formObj.skd_dir_cd);
		var vYdCd     = ComGetObjValue(formObj.yd_cd);
		var vPolCd    = vYdCd.substr(0, 5);
	
		sUrl = "/hanjin/VOP_OPF_3019.do?slan_cd=" + vSlanCd + "&skd_dir_cd=" + vSkdDirCd + "&pol_cd=" + vPolCd;
		ComOpenPopupWithTarget(sUrl, 700, 550, "yd_cd:yd_cd", "0,0", true);
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {	
		sheetObjects[sheetCnt++] = sheet_obj;	
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	 
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
			case 1:
				with (tabObj) {
					var cnt = 0;
					InsertTab(cnt++, "Volume/Weight", -1);
					InsertTab(cnt++, "Special Cargo", -1);
				}
				break;	
		}
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(bkgShprOwnrFlg) {		
		for (var k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		
		initControl();
		
		for (var i = 0; i < sheetObjects.length-1; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//타사일 경우 숨김
        if(bkgShprOwnrFlg == 'N') {
        	document.all.cbfIndLayer.style.display = "none";
        }
	}
	
	/**
     * Sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
	function t1sheet1_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
    }
     
    /**
     * Sheet2 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
 	function t2sheet1_OnLoadFinish(sheetObj) {	
 		doActionIBSheet(sheetObj, document.form, IBSEARCH02);
    }
 	
 	/**
     * Sheet3 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
 	function t2sheet2_OnLoadFinish(sheetObj) {	
    	//시트 초기화 및 동적해더 구성
    	ComConfigSheet(sheetObj);
    	initSheet(sheetObj, 3);
		ComEndConfigSheet(sheetObj);
		
 		doActionIBSheet(sheetObj, document.form, IBSEARCH03);
    }
     
     /** 
 	 * 컬럼 사이즈 조정
 	 */
 	function resizeCols(sheetObj) {
 		with (sheetObj) {
//	 		var startCol  = SaveNameCol("opr1");	 		
//	 		var headColLen = 0, dataColCt = 0;
//	 		for(var colCt=0; colCt<=LastCol; colCt++) {
//	 			if(!ColHidden(colCt)) {
//	 				if(colCt > startCol) {
//	 					dataColCt++;
//	 				} else {
//	 					headColLen += ColWidth(colCt);
//	 				}
//	 			}
//	 		}
//	 		
//	 		var contArea  = SheetWidth - headColLen;
//	 		var divColLen = contArea/dataColCt;
//	 		for(var colCt=startCol+1; colCt<=LastCol; colCt++) {
//	 			if(!ColHidden(colCt)) ColWidth(colCt) = divColLen;
//	 		}
 		}
 	}

	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo, headTitleList) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		var formObj = document.form;
	
		switch (sheetID) {	
			case "t1sheet1":
				with (sheetObj) {
					//높이 설정
					style.height = 382;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 2, 100);					
					
					//동적 해더 구성
					var crrCd = ComGetObjValue(formObj.crr_cd);
					
					var HeadTitle1 = "|  |  |  |  |";
					HeadTitle1 = HeadTitle1 + "|OPR|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd;
					HeadTitle1 = HeadTitle1 + "|Full Units Av.Weight|Full Units Av.Weight";
					
					var HeadTitle2 = "|POD >>|TMNL|BS CD|Weight Group >>|Weight Group >>";									
					HeadTitle2 = HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'|TTL|TEU";
					HeadTitle2 = HeadTitle2 + "|20|40";
		
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false, false);
		
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
		
					InitDataProperty(0, cnt++, dtHiddenStatus, 	100, 	daCenter, 	false,	"hdnStauts");
					InitDataProperty(0, cnt++, dtData, 			62, 	daLeft, 	true, 	"pod", 			false, "", 	dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_yd_cd", 	false, "", 	dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtHidden, 		37, 	daLeft, 	true, 	"mlb",	 		false, "", 	dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			104, 	daLeft, 	true, 	"fm", 			false, "", 	dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtHidden, 		70, 	daLeft, 	false, 	"wg", 			false, "", 	dfNone, 		0, true, true);
		
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	false,  "opr1", 		false, "", 	dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			61, 	daRight, 	false,	"opr1_qty_2", 	false, "",	dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			61, 	daRight, 	false,	"opr1_qty_2h", 	false, "",	dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			61, 	daRight, 	false,	"opr1_qty_4", 	false, "",	dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			61, 	daRight, 	false,	"opr1_qty_4h", 	false, "",	dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			61, 	daRight, 	false,	"opr1_qty_45", 	false, "",	dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false, 	"tot_ttl",		false, "", 	dfNullInteger, 	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			60, 	daRight, 	false,	"opr1_teu", 	false, "",	dfNullInteger, 	0, true, true);
		
					InitDataProperty(0, cnt++, dtData, 			61, 	daRight, 	false, 	"av_wgt_2",		false, "", 	dfNullFloat, 	1, true, true);
					InitDataProperty(0, cnt++, dtData, 			61, 	daRight, 	false, 	"av_wgt_4",		false, "", 	dfNullFloat, 	1, true, true);
		
					SelectHighLight = false;
				}
				break;
		
			case "t2sheet1":
				with (sheetObj) {
					//높이 설정
					style.height = 362;
					//전체 너비 설정
					SheetWidth = mainTable2.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(3, 1, 15, 100);		
					
					//동적 해더 구성
					var crrCd = ComGetObjValue(formObj.crr_cd);
		
					var HeadTitle0 = "|  |  |";
					HeadTitle0 = HeadTitle0 + "|OPR|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "";
					HeadTitle0 = HeadTitle0 + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "";
					HeadTitle0 = HeadTitle0 + "|" + crrCd + "|" + crrCd + "|" + crrCd + "|" + crrCd + "";
					HeadTitle0 = HeadTitle0 + "|" + crrCd + "|" + crrCd + "";
					
					var HeadTitle1 = "|  |  |";
					HeadTitle1 = HeadTitle1 + "|OPR|DG|DG|DG|DG|DG";
					HeadTitle1 = HeadTitle1 + "|RF|RF|RF|RF|RF";
					HeadTitle1 = HeadTitle1 + "|AK|AK|AK|AK";
					HeadTitle1 = HeadTitle1 + "|BB|BB";
					
					var HeadTitle2 = "|POD >>|TMNL|BS CD";
					HeadTitle2 = HeadTitle2 + "|OPR|20'|20HC|40'|40HC|45'";
					HeadTitle2 = HeadTitle2 + "|20'|20HC|40'|40HC|45'";
					HeadTitle2 = HeadTitle2 + "|20'|40'|40HC|45'";
					HeadTitle2 = HeadTitle2 + "|20'|40'";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 1, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, false, false, false);
		
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);
		
					InitDataProperty(0, cnt++, dtHiddenStatus, 	100, 	daCenter, 	true,	"hdnStauts");
					InitDataProperty(0, cnt++, dtData, 			64, 	daLeft, 	true, 	"pod", 		  false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_yd_cd",  false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtHidden, 		60, 	daLeft, 	true, 	"mlb",	 	  false, "", dfNone, 		0, true, true);
		
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	false,	"opr1", 	  false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_20_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_2h_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_40_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_4h_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"dg_45_opr1", false, "", dfNullInteger,	0, true, true);

					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_20_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_2h_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_40_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_4h_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"rf_45_opr1", false, "", dfNullInteger,	0, true, true);

					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_20_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_40_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_4h_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"ak_45_opr1", false, "", dfNullInteger,	0, true, true);

					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"bb_20_opr1", false, "", dfNullInteger,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 			49, 	daRight, 	false,	"bb_40_opr1", false, "", dfNullInteger,	0, true, true);
					
					SetMergeCell(0, 1, 2, 2);
					
					ImageList(0) = "img/btng_minus.gif";
					ImageList(1) = "img/btng_plus.gif";
		
					SelectHighLight = false;		
				}
				break;
		
			case "t2sheet2":
				with (sheetObj) {
					//높이 설정
					style.height = 362;
					//전체 너비 설정
					SheetWidth = subTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
		
					//동적 해더 구성
					var crrCd = ComGetObjValue(formObj.crr_cd);
					
					//Stowage Request 유형 갯수 가져오기
					//-----------------------------------------------------------------------------------------
					formObj.f_cmd.value = SEARCH16;
					var headerXml = sheetObj.GetSearchXml("VOP_OPF_2019GS.do", FormQueryString(formObj));
					var stwgStr = ComGetEtcData(headerXml, "stwgCdList");
					//-----------------------------------------------------------------------------------------
					
					var stwgList = ComTrim(stwgStr).split("|");			
					
					//Stowage Code & Description 정보 저장
					var stwgNmCt = 0;
					stwgNmList = new Array();
					
					var headTitles = new Array();
					
					headTitles[0] = "|  |  |  |OPR";	
					if(ComTrim(stwgStr) != "") {
						headTitles[1] = "|  |  |  |OPR";
						headTitles[2] = "|POD >>|TMNL|BS CD|OPR";
						for ( var colCt = 0; colCt < stwgList.length; colCt++) {
							var stwgCd = stwgList[colCt].split("+")[1];
							
							stwgNmList[stwgNmCt++] = stwgList[colCt].split("+")[1]+"+"+stwgList[colCt].split("+")[2];
							
							headTitles[0] += "|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"";						
							headTitles[1] += "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd + "|" + stwgCd;
							headTitles[2] += "|20'|20HC|40'|40HC|45'";
							
							//파라미터 생성
							ComSetObjValue(eval("formObj.st_"+(colCt+1)), stwgCd);
						}
					} else {
						headTitles[0] += "|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"|"+crrCd+"";
						headTitles[1]  = "|POD >>|TMNL|BS CD|OPR";
						headTitles[1] += "|20'|20HC|40'|40HC|45'";
					}
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(headTitles.length, 1, 15, 100);
					
					var headCount = ComCountHeadTitle(headTitles[0]);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 3, 0, true);
					
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, false, false, false);
					
					//해더 초기생성
					for(var headCt=0; headCt<headTitles.length; headCt++) {						
						InitHeadRow(headCt, headTitles[headCt], true);
					}
		
					InitDataProperty(0, cnt++, dtHiddenStatus, 	100, 	daCenter, 	true,	"hdnStauts");
					InitDataProperty(0, cnt++, dtData, 			64, 	daLeft, 	true, 	"pod", 			false,	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	true, 	"pod_yd_cd", 			false,	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtHidden, 		60, 	daLeft, 	false, 	"mlb", 			false,	"", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	false, 	"opr1",			false, 	"", dfNone, 0, true, true);
					
					if(ComTrim(stwgStr) != "") {
						for ( var colCt = 1; colCt <= stwgList.length; colCt++) {					
							var stwgCd = stwgList[colCt-1];
			
							InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ colCt + "_20_opr1", false, "", dfNullInteger,0, true, true);
							InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ colCt + "_2h_opr1", false, "", dfNullInteger,0, true, true);
							InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ colCt + "_40_opr1", false, "", dfNullInteger,0, true, true);
							InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ colCt + "_4h_opr1", false, "", dfNullInteger,0, true, true);
							InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st"	+ colCt + "_45_opr1", false, "", dfNullInteger,0, true, true);
						}
					} else {
						InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st1_20_opr1", false, "", dfNullInteger,0, true, true);
						InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st1_2h_opr1", false, "", dfNullInteger,0, true, true);
						InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st1_40_opr1", false, "", dfNullInteger,0, true, true);
						InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st1_4h_opr1", false, "", dfNullInteger,0, true, true);
						InitDataProperty(0, cnt++, dtData, 49, daRight, false, "st1_45_opr1", false, "", dfNullInteger,0, true, true);
					}
					
					if(ComTrim(stwgStr) != "") {
						SetMergeCell(0, 1, 2, 2);
					}
					
					ImageList(0) = "img/btng_minus.gif";
					ImageList(1) = "img/btng_plus.gif";
		
					SelectHighLight = false;		
				}
				break;
	
		}
	}

	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {
	
			case IBSEARCH:		// Volume Summary	
				sheetObj.Redraw = false; 
				formObj.f_cmd.value = SEARCH;				
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj));
				
				break;
				
			case IBSEARCH02:	//Special Cargo
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj));
				
				break;
				
			case IBSEARCH03:	//Stowage Request
				formObj.f_cmd.value = SEARCH03;
				sheetObj.DoSearch("VOP_OPF_2019GS.do", FormQueryString(formObj));
				
				break;
		}
	}
	// 업무 자바스크립트 OnClick 이벤트 처리
	function obj_click() {
	
		var formObj    = document.form;
		var t1sheetObj1  = sheetObjects[0];
		var t2sheetObj1  = sheetObjects[1];
		var t2sheetObj2  = sheetObjects[2];
		
		switch (event.srcElement.name) {
			case "t1sheet1_sum_flg":
				//2011.11.17 이준범
				//Sub Sum 체크 박스 , 소계행 콘트롤	
				with (t1sheetObj1) {
					for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
						if (!formObj.t1sheet1_sum_flg.checked){
							if (CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight") {
								RowHidden(checkRow) = true;
							}
						} else {
							if (CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight") {
								RowHidden(checkRow) = false;
							}
						}
					}
				}
				break;
			case "t2sheet1_sum_flg":
				with (t2sheetObj1) {
					if ( !ColHidden("mlb") ) {
						for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
							if (!formObj.t2sheet1_sum_flg.checked){
								if (CellValue(checkRow, "mlb") == "S.Total") {								
									RowHidden(checkRow) = true;
								}
							} else {
								if (CellValue(checkRow, "mlb") == "S.Total") {
									RowHidden(checkRow) = false;
								}
							}
						}
					}
				}
				break;
			case "t2sheet2_sum_flg":
				with (t2sheetObj2) {
					if ( !ColHidden("mlb") ) {
						for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
							if (!formObj.t2sheet2_sum_flg.checked){
								if (CellValue(checkRow, "mlb") == "S.Total") {
									RowHidden(checkRow) = true;
								}
							} else {
								if (CellValue(checkRow, "mlb") == "S.Total") {
									RowHidden(checkRow) = false;
								}
							}
						}
					}
				}
				break;
		}
	}
	/**
	 * Sheet1 MLB 컬럼 확장
	 * @param sheetObj
	 * @param what
	 */
	function spreadMlbCols(sheetObj) {
		with(sheetObj) {
			var podVal = "", mlbVal = "", fmVal = "", wgVal = "";
			var colVal1 = CellValue(1, 1);
			var colVal2 = CellValue(1, 3);
			var foldYn = false;
			
			Redraw = false;
			
			if(colVal1.indexOf(">") != -1) {	//접힌 상태일때					
				CellValue2(1,1)  = colVal1.replaceStr(">", "<");
			} else {
				foldYn = true;
				CellValue2(1,1)  = colVal1.replaceStr("<", ">");
			}	
			ColHidden("mlb") = foldYn;	
			
			//Weight Group 컬럼이 펼쳐져 있는 경우
            if(colVal2.indexOf("<") != -1) {
            	for(var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) {		
					podVal = CellValue(rowCt, "pod");
					mlbVal = CellValue(rowCt, "mlb");
					fmVal  = CellValue(rowCt, "fm");
	                wgVal  = CellValue(rowCt, "wg"); 
	                
	                //아래 순서는 펼치는 것을 기본으로 이해한다. 접힐때는 반대의 개념이다.
	            	if (                           mlbVal == "Sub WG"                                       ||	//Sub WG 모두 숨긴다.
					   (podVal == "Grand Total" &&                    fmVal == "Empty" && wgVal == "Total")) 	//Grand Total 부분의 Empty 항목의 Total항목을  숨긴다.
					{
						RowHidden(rowCt) = !foldYn;
					}
	            	if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight") ||	//Sub WG 가 아닌 항목중에서 Full이고 Total이나 Total Weight가 아닌 항목들만 보이기
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight") ||  //Sub WG 가 아닌 항목중에서 Empty이고 Total이나 Total Weight가 아닌 항목들만 보이기
						(                      fmVal == "Total"      || fmVal == "Total Weight"               ) ||  //Total, Total Weight 항목을 모두 보이기
						(                      fmVal == "Full Total" || fmVal == "Empty Total"                ) ||  //Full Total, Empty Total 항목을 모두 보이기
						(podVal == "Grand Total" &&                     fmVal == "Empty" && wgVal == ""))	        //Grand Total의 Empty항목의 "" 을 보이기
					{
						RowHidden(rowCt) = foldYn;
					}
	            	
	            	if ((podVal == "Grand Total" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight")) {	//Grand Total의 Full항목의 Total, Total Weight항목을 제외한 모든 항목 보이기
	            		RowHidden(rowCt) = false;
	            	}
            	}
            //Weight Group 컬럼이 닫혀있는 경우
            } else {
				//1. MLB 컬럼을 펼침/닫기한다.
				for(var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) {		
					podVal = CellValue(rowCt, "pod");
					mlbVal = CellValue(rowCt, "mlb");
					fmVal  = CellValue(rowCt, "fm");
	                wgVal  = CellValue(rowCt, "wg");   
	                
                	if ((podVal != "Grand Total" &&                       fmVal == "Full"  && wgVal == "Total") ||
						(podVal != "Grand Total" &&                       fmVal == "Empty" && wgVal == "Total") ||
						(                           mlbVal != ""       && fmVal == "Total"                     ) ||
						(                           mlbVal != ""       && fmVal == "Total Weight"              ))
					{
						RowHidden(rowCt) = foldYn;
					}
                	
                	if (foldYn && (fmVal == "Total" || fmVal == "Total Weight")) {	//Total, Total Weight 항목 모두 숨기기(접을 경우에만)
	            		RowHidden(rowCt) = true;
	            	}
				}	
            }
		
			Redraw = true; 
		}
	}
	 
	/**
	 * Sheet1 Weight Group 컬럼 확장
	 * @param sheetObj
	 * @param what
	 */
	function spreadWGCols(sheetObj) {
		with(sheetObj) {
			var podVal = "", mlbVal = "", fmVal = "", wgVal = "";
			var colVal1 = CellValue(1, 1);
			var colVal2 = CellValue(1, 3);
			var foldYn = false;
			
			Redraw = false;
			
			if(colVal2.indexOf(">") != -1) {					
				CellValue2(1,3)  = colVal2.replaceStr(">", "<");
				CellValue2(1,4)  = colVal2.replaceStr(">", "<");
			} else {
				foldYn = true;
				CellValue2(1,3)  = colVal2.replaceStr("<", ">");
				CellValue2(1,4)  = colVal2.replaceStr("<", ">");
			}	
			
			ColHidden("wg") = foldYn;
				
			for (var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) {
				podVal = CellValue(rowCt, "pod");
				mlbVal = CellValue(rowCt, "mlb");
				fmVal  = CellValue(rowCt, "fm");
                wgVal  = CellValue(rowCt, "wg");                    
                
                if(colVal1.indexOf(">") != -1) {	//MLB가 접힌 상태일때
                	//아래 순서는 펼치는 것을 기본으로 이해한다. 접힐때는 반대의 개념이다.
                	if ((podVal == "Grand Total" && fmVal == "Full" && wgVal == "Total") ||		//Grand Total 부분의 Full 항목의 Total 항목만 숨긴다.
                		(                           fmVal == "Full Total"              ) ||		//모든 Full Total 항목을 숨긴다.
                		(                           fmVal == "Empty Total"             )) 		//모든 Empty Total 항목을 숨긴다.
                	{						
						RowHidden(rowCt) = !foldYn;
					}
					if (                           mlbVal == "Sub WG"                                                                 ||	//Sub WG 모두 보이기
					   (podVal == "Grand Total" &&                    fmVal == "Full" && wgVal != "Total" && wgVal != "Total Weight")) 		//Grand Total 부분의 Full 항목의 Total, Total Weight 이외 항목들을 보이기
					{
						RowHidden(rowCt) = foldYn;
					}
                } else {							//MLB가 펼쳐진 상태
                	//아래 순서는 펼치는 것을 기본으로 이해한다. 접힐때는 반대의 개념이다.
                	if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal == "Total")  ||	//Sub WG 가 아닌 항목중에서 Full/Total만 숨긴다.
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal == "Total"))		//Sub WG 가 아닌 항목중에서 Empty/Total만 숨긴다.
					{
						RowHidden(rowCt) = !foldYn;
					}
					if ((mlbVal != "Sub WG" && fmVal == "Full"  && wgVal != "Total" && wgVal != "Total Weight") ||	//Sub WG 가 아닌 항목중에서 Full이고 Total이나 Total Weight가 아닌 항목들만 보이기
						(mlbVal != "Sub WG" && fmVal == "Empty" && wgVal != "Total" && wgVal != "Total Weight"))	//Sub WG 가 아닌 항목중에서 Empty이고 Total이나 Total Weight가 아닌 항목들만 보이기
					{
						RowHidden(rowCt) = foldYn;
					}
                }
			}	
		
			sheetObj.Redraw = true; 
		}
	}

	/**
	 * t1sheet1_OnMouseDown
	 */
	function t1sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		with (sheetObj) {
			if(MouseCol == SaveNameCol("pod") && MouseRow == (HeaderRows-1)) {
				spreadMlbCols(sheetObj);
			} else if((MouseCol == SaveNameCol("fm") || MouseCol == SaveNameCol("wg")) && MouseRow == (HeaderRows-1)) {
				spreadWGCols(sheetObj);
			}
		}
	}

	/**
	 * t2sheet1_OnMouseDown
	 */
	function t2sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {		
		
		 var formObj    = document.form;
		 
		 with(sheetObj) {
			if(MouseCol == SaveNameCol("pod") && MouseRow == (HeaderRows-1)) {
				Redraw = false;
				
				var foldYn = false;		
				var colVal = CellValue(2, 1);
				if(colVal.indexOf(">") != -1) {
					CellValue2(2, 1) = colVal.replaceStr(">", "<");				
				} else {
					foldYn = true;
					CellValue2(2, 1)  = colVal.replaceStr("<", ">");				
				}
				ColHidden("mlb") = foldYn;
				
				//MLB별 접기,펼치기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					//2011.11.17 이준범
					//Sub Sum 체크 박스 , 소계행 콘트롤	
					if (ColHidden("mlb")){
						if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
					} else {
						if (!formObj.t2sheet1_sum_flg.checked){
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = true;
						} else {
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
						}
					}
					
					if(CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = foldYn;	
				}
				
				var subRow = FindText("mlb", "S.Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow;) {
					if(foldYn) RowBackColor(checkRow++) = RgbColor(255,255,255);
					else RowBackColor(checkRow++) = RgbColor(247, 225, 236);
					
					subRow = FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow = subRow;
					} else {
						checkRow = LastRow+1;
					}
				}
		
				Redraw = true;
			}
		}
	}

	/**
	 * t2sheet2_OnMouseDown
	 */
	function t2sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		
		 var formObj    = document.form;
		 
		 with (sheetObj) {
			if(MouseCol == SaveNameCol("pod") && MouseRow == (HeaderRows-1)) {
				Redraw = false;
				
				var foldYn = false;		
				var colVal = CellValue(HeaderRows-1, 1);
				if(colVal.indexOf(">") != -1) {
					CellValue2(HeaderRows-1, 1) = colVal.replaceStr(">", "<");				
				} else {
					foldYn = true;
					CellValue2(HeaderRows-1, 1)  = colVal.replaceStr("<", ">");				
				}
				ColHidden("mlb") = foldYn;
				
				//MLB별 접기,펼치기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					//2011.11.17 이준범
					//Sub Sum 체크 박스 , 소계행 콘트롤	
					if (ColHidden("mlb")){
						if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
					} else {
						if (!formObj.t2sheet2_sum_flg.checked){
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = true;
						} else {
							if (CellValue(checkRow, "mlb") == "S.Total") RowHidden(checkRow) = false;
						}
					}		
					if(CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = foldYn;	
				}
				
				var subRow = FindText("mlb", "S.Total");
				
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow;) {
					if(foldYn) RowBackColor(checkRow++) = RgbColor(255,255,255);
					else RowBackColor(checkRow++) = RgbColor(247, 225, 236);
					
					subRow = FindText("mlb", "S.Total", checkRow);
					if(subRow != -1) {
						checkRow = subRow;
					} else {
						checkRow = LastRow+1;
					}
				}
				
				Redraw = true;
			}
		}
	}
	 
	/**
     * Sheet1 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
    	with (sheetObj) {
	     	if (MouseRow == (HeaderRows-1) && (MouseCol == SaveNameCol("pod") || MouseCol == SaveNameCol("fm") || MouseCol == SaveNameCol("wg"))) {
	     		MousePointer = "Hand";
	     	} else {
	     		MousePointer = "Default";
	     	}
    	}
    }
     
    /**
     * Sheet2 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	with (sheetObj) {
 	     	if (MouseRow == (HeaderRows-1) && MouseCol == SaveNameCol("pod")) {
 	     		MousePointer = "Hand";
 	     	} else {
 	     		MousePointer = "Default";
 	     	}
     	}
    }
    
    /**
     * Sheet3 OnMouseMove Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
    function t2sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) { 
     	with (sheetObj) {
 	     	if (MouseRow == (HeaderRows-1) && MouseCol == SaveNameCol("pod")) {
 	     		MousePointer = "Hand";
 	     	} else {
 	     		MousePointer = "Default";
 	     	}
 	     	
 	     	if (MouseRow == 1 && MouseCol > SaveNameCol("mlb")) {
  	     		for(var i=0; i<stwgNmList.length; i++) {
  	     			if(CellText(MouseRow, MouseCol) == stwgNmList[i].split("+")[0]) {
  	     				MouseToolTipText = stwgNmList[i].split("+")[1];
  	     				
  	     				break;
  	     			}
  	     		}
  	     	}
     	}
    }
     
    /**
     * t1sheet1 OnSelectCell Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 NewRow ==> NewRow, 선택한 NewCol ==> NewCol
     * 
     */
    function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	window.status = sheetObj.RowLevel(OldCol);
    }

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
	
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
	}
	 
	/**
	 * t1sheet1 조회후 처리
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {		
		with (sheetObj) {	
			if (RowCount > 0) {

				//Grand Total이 0인 컬럼은 숨김
				var grandRow = FindText("fm", "Grand Total");				
				for(var colCt=SaveNameCol("opr1_qty_2"); grandRow!=-1 && colCt<=SaveNameCol("opr1_teu"); colCt++) {
					//if(CellValue(grandRow, colCt) == 0) ColHidden(colCt) = true;
				}
				
				//소계행 색상 변경
				var subRow = FindText("fm", "Sub Total");
				for (var checkRow=subRow; subRow!=-1 && checkRow<=LastRow;) {
					RowBackColor(checkRow++) = RgbColor(247, 225, 236);
					RowBackColor(checkRow)   = RgbColor(247, 225, 236);

					subRow = FindText("fm", "Sub Total", checkRow);
					if(subRow != -1) {
						checkRow = subRow;
					} else {
						checkRow = LastRow+1;
					}
				}
				//2011.11.17 이준범
				//조회시 sub total 숨김
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					if (CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight") {
						RowHidden(checkRow) = true;
					}
				}
				//Grand행 색상 변경
				RowBackColor(grandRow)   = RgbColor(247, 225, 236);
				RowBackColor(++grandRow) = RgbColor(247, 225, 236);			
				
				//기본 접힌 형태 구성
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {					
					if (CellValue(checkRow, "fm") == "Full Total" || CellValue(checkRow, "fm") == "Empty Total" || 
						CellValue(checkRow, "fm") == "Sub Total"  || CellValue(checkRow, "fm") == "Sub Weight"  || 
						(CellValue(checkRow, "pod") == "Grand Total" && CellValue(checkRow, "fm") == "Full"  && CellValue(checkRow, "wg") == "Total") || 
						(CellValue(checkRow, "pod") == "Grand Total" && CellValue(checkRow, "fm") == "Empty" && CellValue(checkRow, "wg") == "Total") || 
						CellValue(checkRow, "fm") == "Grand Total"  || CellValue(checkRow, "fm") == "Grand Weight") {
					} else {
						RowHidden(checkRow) = true;
					}	
				}
				
				resizeCols(sheetObj);
			}
			
			Redraw = true; 
		}
	}

	/**
	 * t2sheet1 조회후 처리
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			if (RowCount > 0) {
				//G.Total이 0인 컬럼은 숨김
				var gRow = FindText("pod", "G.Total");				
				for(var colCt=SaveNameCol("dg_20_opr1"); gRow!=-1 && colCt<=SaveNameCol("bb_40_opr1"); colCt++) {
					//if(CellValue(gRow, colCt) == 0) ColHidden(colCt) = true;
				}
				
				//접은 상태 만들기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					if(CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = true;	
				}

				//G.Total행 색상 변경
				RowBackColor(gRow) = RgbColor(247, 225, 236);
			}
		}
	}

	/**
	 * t2sheet2 조회후 처리
	 */
	function t2sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			if (RowCount > 0) {
				//G.Total이 0인 컬럼은 숨김
				var gRow = FindText("pod", "G.Total");				
				for(var colCt=SaveNameCol("st1_20_opr1"); gRow!=-1 && colCt<=LastCol; colCt++) {
					//if(CellValue(gRow, colCt) == 0) ColHidden(colCt) = true;
				}
				
				//접은 상태 만들기
				for (var checkRow=HeaderRows; checkRow<=LastRow; checkRow++) {
					if(CellValue(checkRow, "pod") != "G.Total" && CellValue(checkRow, "mlb") != "S.Total") RowHidden(checkRow) = true;	
				}

				//G.Total행 색상 변경
				RowBackColor(gRow) = RgbColor(247, 225, 236);
			}
		}
	}

/* 개발자 작업  끝 */