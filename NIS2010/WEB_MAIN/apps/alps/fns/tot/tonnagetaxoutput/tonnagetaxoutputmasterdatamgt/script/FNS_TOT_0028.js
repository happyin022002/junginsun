/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0028.js
*@FileTitle : MRT & BSA Change
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.22
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.04.23 이준범
* 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

	/**
	 * @extends
	 * @class FNS_TOT_0028 : FNS_TOT_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_TOT_0028() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
		try {
     		var srcObj = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
		        case "btn_Save":
		        	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);		        	
					window.close()
					break;

				case "btn_close":
					window.close();
					break;

			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        switch (sheetNo) {
            case 1:
            with (sheetObj) {
                // 높이 설정
                style.height = 250;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 2, 100);

                var HeadTitle1  = "|SEQ|Lane|Vessel|VVD|NRT|NRT|BSA|BSA";
                var HeadTitle2  = "|SEQ|Lane|Vessel|VVD|Before|After|Before|After";
                
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                //데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,0,       daCenter,    true,    "ibflag"   );
                InitDataProperty(0, cnt++, dtSeq,    	  30,	   daCenter,	true,	 "seq",		      false,	"",    dfNone,    0,	false,    false);
                InitDataProperty(0, cnt++, dtData,        60,      daCenter,    true,    "slan_cd",       false,    "",    dfNone,    0,    false,    false);
                InitDataProperty(0, cnt++, dtData,        60,      daCenter,    true,    "vsl_cd",        false,    "",    dfNone,    0,    false,    false);
                InitDataProperty(0, cnt++, dtData,        90,      daCenter,    true,    "vvd",           false,    "",    dfNone,    0,    false,    false);
                InitDataProperty(0, cnt++, dtData,        80,      daRight,     true,    "nrt_bfr",       false,    "",    dfNone,    0,    false,    false);
                InitDataProperty(0, cnt++, dtData,        80,      daRight,     true,    "nrt_aft",       false,    "",    dfNone,    0,    false,    false);
                InitDataProperty(0, cnt++, dtData,        80,      daRight,     true,    "bsa_bfr",       false,    "",    dfNone,    0,    false,    false);
                InitDataProperty(0, cnt++, dtData,        80,      daRight,     true,    "bsa_aft",       false,    "",    dfNone,    0,    false,    false);                
                CountPosition = 0;
            }
            break;
        }
    }


	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		var param = "";
		switch (sAction) {

			case IBSEARCH:
		       	formObj.f_cmd.value = SEARCH;

		       	if(!validateForm(sheetObj,formObj,sAction)) return;

                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);

		   		var sXml = sheetObj.GetSearchXml("FNS_TOT_0028GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);

                //ComOpenWait End
                ComOpenWait(false);

				break;
				
			case IBSAVE:        //저장
            
				var SaveStr = ComGetSaveString(sheetObj);
			
				if (SaveStr == ""){
					ComShowCodeMessage('TOT00011');
					return;
				}
			
				if (!ComShowCodeConfirm('TOT00069')){
					return;
				}
			
	           	sheetObj.WaitImageVisible=false;
	            ComOpenWait(true);
	                	
		    	formObj.f_cmd.value = MULTI;

		    	var sXml = sheetObj.GetSaveXml("FNS_TOT_0028GS.do", SaveStr + "&" + FormQueryString(formObj));
		    	sheetObj.LoadSaveXml(sXml);
		    	ComOpenWait(false);
		    	
		    	opener.tax_recalculated();
	
				break;				
		}
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj, formObj, sAction) {
		return true;
	}

	/* 개발자 작업  끝 */