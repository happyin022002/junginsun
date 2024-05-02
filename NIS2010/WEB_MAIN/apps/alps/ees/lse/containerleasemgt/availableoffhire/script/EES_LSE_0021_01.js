/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0021_01.js
 *@FileTitle : Off-Hire CNTR List - Send to E-mail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 장준우
 *@LastVersion : 1.0
 * 2009.10.05 장준우
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
	 * @class EES_LSE_0021_01 : EES_LSE_0021_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0021_01() {
		this.processButtonClick  = processButtonClick;
		this.setSheetObject 	 = setSheetObject;
		this.loadPage 			 = loadPage;
		this.sheet1_OnLoadFinish = sheet1_OnLoadFinish;
		this.initControl 		 = initControl;
		this.initSheet 			 = initSheet;
		this.sheet1_OnSaveEnd 	 = sheet1_OnSaveEnd;
		this.doSendMail 		 = doSendMail;
		this.doFileUpload 		 = doFileUpload;
	}

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var formObj = document.form;

    	try {
			var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_send":
                    doSendMail();
                	break;
                case "btn_attach":
                    doFileUpload();
                	break;
				case "btn_close":
					window.close();
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
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }
    }

	/**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
		/* Axon Control Setting*/
		initControl();

		//오프너로부터 IBSheet에 체크된 데이터행을 복사한다.
		var vSaveNames = "ibflag|scc_cd|vndr_seq|agmt_cty_cd|agmt_seq|lstm_cd|cntr_tpsz_cd|cntr_no|mty_rtn_yd_cd|off_hire_yard|"
					   + "off_hire_due_date|full_flg|mvmt_sts_cd|cnmv_dt|onh_yd_cd|onh_dt|min_onh_dys|used_days|onh_free_dys|"
					   + "mnr_cost|bkg_no|bl_no|pol_cd|pod_cd|del_cd|evnt_ofc_cd|pol_etd_dt|pod_eta_dt|vvd_cd";
		var sXml = ComMakeSearchXml(opener.sheetObjects[0], false, "del_chk",vSaveNames, false);
		sheetObj.LoadSearchXml(sXml, false);
    }


	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		//do nothing
  	}

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetid = sheetObj.id;

        switch(sheetid) {
            case "sheet1":
				with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "||Lessor|AGMT No.|AGMT No.|Lease\nTerm|TP/SZ|CNTR No.|Yard|Off-Hire\nYard|Off-Hire\nDue Date|MT/Full|MVMT\nState|MVMT\nDate|On-Hire\nYard|On-Hire\nDate|Min On-Hire\nDays|Used\nDays|Free\nDays|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|R.Office|ETD-DT|ETA-DT|T.VVD";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 11, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	false,	"ibflag");
		            InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"scc_cd",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"vndr_seq",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"agmt_cty_cd",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daCenter,	true,	"agmt_seq",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	55,		daCenter,	true,	"lstm_cd",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	55,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,     	90,   	daCenter,	true,	"cntr_no",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"mty_rtn_yd_cd",	false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"off_hire_yard",	false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"off_hire_due_date",false,	"",		dfDateYmd, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"full_flg",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"mvmt_sts_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"cnmv_dt",			false,	"",		dfDateYmd, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"onh_yd_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"onh_dt",			false,	"",		dfDateYmd, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	75,		daRight,	true,	"min_onh_dys",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	70,		daRight,	true,	"used_days",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	70,		daRight,	true,	"onh_free_dys",		false,	"",		dfInteger, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	80,		daRight,	true,	"mnr_cost",			false,	"",		dfFloat, 	2,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	100,	daCenter,	true,	"bkg_no",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	100,	daCenter,	true,	"bl_no",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"pol_cd",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"pod_cd",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	60,		daCenter,	true,	"del_cd",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,	true,	"evnt_ofc_cd",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"pol_etd_dt",		false,	"",		dfDateYmd, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	85,		daCenter,	true,	"pod_eta_dt",		false,	"",		dfDateYmd, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,		daCenter,	true,	"vvd_cd",			false,	"",		dfNone, 	0,	false,	false);

					SelectBackColor = LSE_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
				break;

        }
    }

	/**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		window.close();
    		opener.sendFlag = true;
    		opener.callbackSendMail(500);
    	}
    }

	/**
	 * 이메일을 송부한다.
	 */
	function doSendMail(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		if(ComChkValid(formObj, true)){
			if(ComIsEmailAddr(formObj.recipient.value) == false) {
				ComShowCodeMessage("LSE01108");
				ComSetFocus(formObj.recipient);
			} else {
				ComOpenWait(true, "tabLayer");
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("EES_LSE_0021GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false, "tabLayer");
			}
		}
	}

	/**
	 * 첨부파일을 업로드한다.
	 */
	function doFileUpload(){
		var formObj = document.form;

		var before = formObj.fileKey.value;
		var returnValue = openUpload(formObj.siteConfig.value);

		if(returnValue == null){
			returnValue = "";
		} else if(before == "") {
			returnValue = returnValue;
		} else{
			returnValue = ";"+returnValue;
		}

		formObj.fileKey.value=before+returnValue;
	}
	/* 개발자 작업  끝 */
