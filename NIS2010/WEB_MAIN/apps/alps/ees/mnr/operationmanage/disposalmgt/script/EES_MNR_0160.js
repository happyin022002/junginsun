/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_mnr_0160.js
 *@FileTitle : Disposal Sold Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.11.27
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2009.09.28 WanGyu Kim
 * 1.0 Creation
* --------------------------------------------------------
* History
* 2011.10.14 허철용 [CHM-201113679-01] ALPS MNR-Disposal-SOLD Creation 에서
*                  office로 sold creation 할 수 있게 office 입력 및 조회할 수 있게 보완 개발
* 2012.05.07 신혜정 [CHM-201217691] Disposal Sold Creation 화면 조회시 Office 코드 조회조건 Mandatory 항목으로 설정            
* 2013.06.17 조경완 [CHM-201324910-01] ALPS-MNR-Disposal-SLD Creation 기능 보완 요청   
* 2013.11.27 이혜민 [CHM-201327675-01] Sold Date를 오늘 날짜 이상은 입력 불가능 하도록 입력 날짜 Validation 추가          
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
 * @class ees_mnr_0160 : ees_mnr_0160 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_mnr_0160() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* ********* General Functions ************* */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0; 
	//RowAdd 용
	var currCd			= null;
	var partAmt			= null;
	var dispUtTpCd		= null;
	var dispQty    		= null;
	var dispTrkrNm		= null;
	var dispUtPrc		= null;
	var dispRsnCd		= null;
	var invAmt			= null;
	var file_seq		= null;
	var rcvInvSeq		= null;
	var mnrPrnrCntCd	= null;
	var mnrPrnrSeq		= null;
	var creUsrId		= null;
	var creDt			= null;
	
	var ydCheck = true;
	var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,0);
					break;

				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,1);
					break;

				case "btn_Save":
					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
					break;

				//office 조회
				case "btn_ofc_cd":
					if (!window.event.srcElement.disabled) {
						ComOpenPopup("COM_ENS_071.do", 720, 450, 'setPopUpParam_COM_ENS_071', '1,0,1,1,1,1,1,1', true);
					}
					break;

				//달력
				case "apro_dt_cal":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.apro_dt_fr, formObject.apro_dt_to, 'yyyy-MM-dd');
					break;

				//멀티입력
				case "disp_no_multi":
				    rep_Multiful_inquiry("disp_no");
					break;

				//멀티입력
				case "eq_no_multi":
					rep_Multiful_inquiry("eq_no");
					break;

				//Buyer PopUp
				case "buyer_no_popup":
					ComOpenPopup('COM_ENS_041.do', 770, 450, 'setBuyer', '1,0,1,1,1,1,1,1,1,1,1,1');
					break;

				case "btn_LoadExcel":
					doActionIBSheet(sheetObjects[1],document.form,IBLOADEXCEL);
					break;

				case "btn_DownExcel":
					sheetObjects[1].SpeedDown2Excel(-1);
					break;

				//Doc Send
				case "btn_DocSend":
					doActionIBSheet(sheetObjects[0],formObject,"DOCSEND");
					break;

            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
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
    	// 버튼 설정
    	MnrWaitControl(true);
    	// IBMultiCombo초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// IBSheet 초기화
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon이벤트 초기화
		initControl();

		//화면초기화
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }

  	/**
     * IBCombo 기본 설정
     * @param	{IBCombo}	comboObj	초기설정될 콤보오브젝트
     * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initCombo(comboObj, comboNo) {
	    var cnt  = 0 ;
	    var formObject = document.form

	    switch(comboNo) {
	    	case 1:
	            with (comboObj) {
			       SetColAlign("left");
				   DropHeight = 160;
			    }
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

        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 360;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq.|Disposal No.|Type|Sale Type|Appoval DT|Buyer Code|Buyer Name|Sold Q'ty|Pending Q'ty|Total Q'ty";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 5, 3, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter, 	true,	"disp_no",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daLeft, 	true,	"disp_tp_nm",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter, 	true,	"disp_ut_tp_nm",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter, 	true,	"apro_dt",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,  	true,	"buyer_code",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daLeft,  	true,	"buyer_name",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	 	daRight,	true,	"sold_qty",	 		false,	"",	dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	 	daRight,	true,	"pending_qty", 		false,	"",	dfInteger,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	 	daRight,	true,	"total_qty",		false,	"",	dfInteger,	0,	false,	false);
					//Hidden
					InitDataProperty(0, cnt++ , dtHidden,		30,	 	daRight,	true,	"eq_knd_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	 	daRight,	true,	"mnr_prnr_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	 	daRight,	true,	"mnr_prnr_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,	 	daLeft,		true,	"fax_no");
					InitDataProperty(0, cnt++ , dtHidden,		30,	 	daLeft,		true,	"mnr_prnr_eml");
	            }
		        break;

		    case "sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 360;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Sel|Seq|Type|EQ No|TP/SZ|Release No|P/Up Yard|Sold DT|Inv No|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 24, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	50,	daCenter,	true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	"del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,			40,	daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,		    50,	daLeft,		true,	"disp_tp_nm",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		    80,	daCenter,	true,	"eq_no",			false,	"",	dfNone,			0,	false,	false,	14);
					InitDataProperty(0, cnt++ , dtData,		    40,	daCenter,	true,	"eq_tpsz_cd",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		    120,daCenter,	true,	"disp_rlse_no",		false,	"",	dfNone,			0,	false,	true,	20);
					InitDataProperty(0, cnt++ , dtData,		    80,	daCenter,	true,	"disp_yd_cd",		true,	"",	dfNone,			0,	false,	true,	7);
					InitDataProperty(0, cnt++ , dtPopupEdit,	80,	daCenter,	true,	"disp_sold_dt",		false,	"",	dfDateYmd,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,			80, daLeft,		true,	"inv_no",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		    100,daLeft,		true,	"mnr_disp_dtl_rmk",	false,	"",	dfNone,			0,	false,	true,	4000);
					//hidden
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	true,	"lcc_diff_flg");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	true,	"curr_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daRight,	true,	"part_amt");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_no");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_dtl_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_ut_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_qty");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_trkr_nm");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_ut_prc");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_rsn_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"inv_amt");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"file_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"rcv_inv_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"mnr_prnr_cnt_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"mnr_prnr_seq");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"cre_usr_id");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"cre_dt");
					InitDataProperty(0, cnt++ , dtHidden,		30, daLeft,		true,	"disp_sold_dt_flg");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"eq_knd_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"disp_rlse_no_flg");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"old_eq_no");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"old_eq_tpsz_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"old_eq_disp_yd_cd");
					InitDataProperty(0, cnt++ , dtHidden,		30,	daLeft,		true,	"old_sold_dt");

					//데이터 Validation
					InitDataValid(0,  "eq_no", vtEngUpOther,"0123456789");
					InitDataValid(0,  "disp_rlse_no", vtEngUpOther,"0123456789-");
					InitDataValid(0,  "disp_yd_cd", vtEngUpOther,"0123456789");

					SpaceDupCheck = false;

					PopupImage = "/hanjin/img/btns_calendar.gif";
					ShowButtonImage = 2;
                }
         		break;
        }
    }

    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	//- 포커스 나갈때
	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	//- 포커스 들어갈때
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		//- 키입력 할때
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form); 	//- 변경될때.
    }

	/**
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
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
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}

	/**
     * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_focus(){
    	ComClearSeparator(event.srcElement);
    }

	/**
	 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
	 **/
	function obj_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;

			case "engup":
				if(obj.name=="disp_no"){
	        		ComKeyOnlyAlphabet('uppernum','45|44');	//45:'-', 44:','
	        	} else {
	        		ComKeyOnlyAlphabet('uppernum','44'); 	//44:','
	        	}
	            break;
	    }
	}

	/**
	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
	 * @return
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
	    		case "buyer_code":
					setCustomerName();
				   	break;
				case "ofc_cd":   
					ofc_cd_Check();
					break;				   	
			}
	    }
	}

    /**
     * 콤보변경 이벤트
     *     Status 콤보 변경시 프린트 버튼 Display 설정
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */
    function status_OnChange(comboObj,Index_Code, Text){
		// 모든 쉬트를 초기화
		for (i = 0; i < sheetObjects.length; i++) {
			sheetObjects[i].RemoveAll();
		}

		//Doc Send 버튼 Display 설정
        if(Index_Code == "S") {
    		document.getElementById("iBtn_DocSend").style.display = "inline";
        } else {
        	document.getElementById("iBtn_DocSend").style.display = "none";
        }

        //Doc Send 버튼 활성화설정
        setBtnDocSend();
    }

	/**
	 * 조회된 Master Sheet에 포커스가 선택될때 발생하는 이벤트
	 *     Master Sheet 조회후 선택된 Row 에 해당하는 Detail Sheet 조회
	 * @param	{Sheet}			sheetObj	프로세스 처리될 시트오브젝트
	 * @param	{Long}			OldRow		선택한 셀의 Row Index
	 * @param	{Long/String}	OldCol		선택한 셀의 Column Index 또는 SaveName
	 * @param	{Long}			NewRow		선택할 셀의 Row Index
	 * @param	{Long/String}	NewCol		선택할 셀의 Column Index 또는 SaveName
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        var formObject = document.form;
        formObject.selected_disp_no.value = sheetObj.CellValue(NewRow, "disp_no");
		formObject.selected_mnr_prnr_cnt_cd.value = sheetObj.CellValue(NewRow, "mnr_prnr_cnt_cd");
        formObject.selected_mnr_prnr_seq.value = sheetObj.CellValue(NewRow, "mnr_prnr_seq");
        doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01, 1);
	}
	/**
	 * 조회후 설정
	 *     프린트 버튼의 활성화 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setBtnDocSend();
	}

	/**
	 * 조회후 설정
	 *     EQ No, Sel 컬럼 Edit 설정 및 Sold Dt 값 설정
	 *     RowAdd 시 컬럼 Default 값 설정
	 *     Release No 값 설정
	 *     Load Excel 버튼 활성화 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		var ydCdAlert = 0;
		if(sheetObj.RowCount > 0) {
			//Edit 설정(EQ No, Sel) 및  Sold DT 값설정
			for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
				//Sel (inv_no 관련)
				var invNo = sheetObj.CellValue(i, "inv_no");
				if(invNo != "" && invNo != null) {
					sheetObj.CellEditable(i, "del_chk") = true;
					sheetObj.CellEditable(i, "eq_no") = false;
					sheetObj.CellEditable(i, "disp_rlse_no") = false;
					if(sheetObj.CellValue(i, "disp_sold_dt") == "" || sheetObj.CellValue(i, "disp_sold_dt") == null){
						sheetObj.CellEditable(i, "disp_sold_dt") = true;
					}else{
						sheetObj.CellEditable(i, "disp_sold_dt") = false;
					}
					if(sheetObj.CellValue(i, "lcc_diff_flg") == "NOT SAME"){
						sheetObj.CellEditable(i, "disp_yd_cd") = true;
						ydCdAlert++;
					} else {
						sheetObj.CellEditable(i, "disp_yd_cd") = false;
					}
					
					sheetObj.CellEditable(i, "mnr_disp_dtl_rmk") = false;
				} else {
					sheetObj.CellEditable(i, "del_chk") = false;
				}
			}
			//RowAdd 용 전역변수 값 설정
			currCd		    = sheetObj.CellValue(sheetObj.HeaderRows, "curr_cd");
			partAmt		    = sheetObj.CellValue(sheetObj.HeaderRows, "part_amt");
			dispUtTpCd		= sheetObj.CellValue(sheetObj.HeaderRows, "disp_ut_tp_cd");
			dispQty       	= sheetObj.CellValue(sheetObj.HeaderRows, "disp_qty");
			dispTrkrNm    	= sheetObj.CellValue(sheetObj.HeaderRows, "disp_trkr_nm");
			dispUtPrc     	= sheetObj.CellValue(sheetObj.HeaderRows, "disp_ut_prc");
			dispRsnCd    	= sheetObj.CellValue(sheetObj.HeaderRows, "disp_rsn_cd");
			invAmt        	= sheetObj.CellValue(sheetObj.HeaderRows, "inv_amt");
			rcvInvSeq     	= sheetObj.CellValue(sheetObj.HeaderRows, "rcv_inv_seq");
			mnrPrnrCntCd	= sheetObj.CellValue(sheetObj.HeaderRows, "mnr_prnr_cnt_cd");
			mnrPrnrSeq    	= sheetObj.CellValue(sheetObj.HeaderRows, "mnr_prnr_seq");
			creUsrId      	= sheetObj.CellValue(sheetObj.HeaderRows, "cre_usr_id");
			creDt         	= sheetObj.CellValue(sheetObj.HeaderRows, "cre_dt");
			//ReleaseNo 생성설정
			setReleaseNo(sheetObj);
			
		}
		setBtnLoadExcel(); //Load Excel 버튼 설정
		if(ydCdAlert != 0 && ydCheck == true){
			ComShowCodeMessage("MNR00419");
		}
	}

	/**
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ를 재설정한다.
	 *
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet2_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
			//EQ No
			if(colname == 'eq_no') {
				if(Value!="" && Value!=null){
					setEqNoInfo(sheetObj,Row,Col);
				} else {
					setEqNoClear(sheetObj,Row);
				}
			}
			//P/Up Yard
			else if(colname == 'disp_yd_cd') {
				if(Value!="" && Value!=null) {
					checkPUpYardCd(sheetObj,Row,Col);
				}
			}
			
			//Disposal Sold Date
			else if(colname == 'disp_sold_dt') {
				if(sheetObj.CellEditable(Row, "disp_sold_dt") == true){
					var betDays = ComGetDaysBetween(Value, ComGetNowInfo("ymd")); //현재 날짜-입력 날짜
					if(betDays < 0){ //미래날짜를 입력한 경우 음수가 발생
						ComShowCodeMessage("MNR00396","Sold");
						sheetObj.CellValue2(Row, Col) = ""; //초기화
						sheetObj.SelectCell(Row, Col); //셀 자동 선택	
					}
				}		
			}
		}
	}

	/**
	 * 쉬트 팝업 클릭시 발생하는 이벤트
	 *     Date 의 달력팝업을 호출한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
        if (sheetObj.ColSaveName(Col) != "disp_sold_dt") return;
        var cal = new ComCalendarGrid();
        cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}

	/**
	 * 저장후 결과메세지 표시
	 * @param	{IBSheet}	sheetObj	저장이벤트의 시트 오브젝트
	 * @param	{String}	ErrMsg		에러메세지
	 */
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023");
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,0);
		}
		else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}

    /**
     * Sheet1관련 프로세스 처리
     *
     * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
     * @param {Form}formObj 프로세스 처리될 폼오브젝트
     * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	    	// 초기화
	    	case IBCLEAR:
	    		// 버튼 , 프로그레스바 설정 시작
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	    		
	    		//Office Level 조회  및 전역변수(strMnrOfficeLevel)에 세팅
				MnrOfficeLevel(currOfcCd,rhqOfcCd);
				
				//SignOnAccount 에서 로그인한 Office Cd
				document.form.ofc_cd.value = currOfcCd;

				if( strMnrOfficeLevel == "L1" ){
					document.form.ofc_cd.className = "input1"; // 필수 항목
					document.form.ofc_cd.readOnly = false;
					document.getElementById("btn_ofc_cd").style.cursor = "pointer";
					document.getElementById("btn_ofc_cd").disabled = false;
					document.getElementById("btn_ofc_cd").style.filter = "";
				}

	    		// 모든 쉬트를 초기화
	    		for (i = 0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}

	    		// Only Loading
	    		if (sActionIdx == 0) {
	    			// 조건부 콤보데이타 초기화
	    			for ( var i = 0; i < comboObjects.length; i++) {
	    				comboObjects[i].RemoveAll();
	    			}
					//조건부 콤보데이타 조회(Status)
					var sCondition = new Array (
						new Array("MnrGenCd","CD00063", "COMMON"), 	//Status
						new Array("MnrGenCd","SELHO","CUSTOM9")		//EQ Type
					)
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
	    			// 콤보데이타에 값을 세팅함
	    			for ( var i = 0; i < comboList.length; i++) {
	    				if (comboList[i] != null) {
							for(var j = 0; j < comboList[i].length;j++){
								var tempText = comboList[i][j].split("|");
								//Status
		    					if(i==0) {
		    						formObj.status.InsertItem(j, tempText[1], tempText[0]);
		    					}
		    					//EQ Type
		    					else if(i==1) {
		    						formObj.eq_knd_cd.InsertItem(j, tempText[1], tempText[0]);
		    					}
							}
	    				}
	    			}
	    		}

	    		// 초기값 설정
	    		formObj.status.focus();
	    		formObj.status.Code				= "I";											//Status(I:R/O Issue, S:R/O Send)
	    		formObj.eq_knd_cd.Code 			= "U"; 											//EQ Type
	    		formObj.apro_dt_fr.value		= ComGetDateAdd(ComGetNowInfo("ymd"), "M", -2);	//Approval Period From
	    		formObj.apro_dt_to.value		= ComGetNowInfo("ymd");							//Approval Period To
	    		formObj.disp_no.value			= "";											//Disporal No
	    		formObj.eq_no.value				= "";											//EQ No
	    		formObj.buyer_code.value 		= "";											//Buyer Code
	    		formObj.buyer_name.value 		= "";											//Buyer Name
	    		formObj.mnr_prnr_cnt_cd.value	= "";	 										//Buyer Code(hidden code 1)
	    		formObj.mnr_prnr_seq.value 		= "";
				formObj.selected_mnr_prnr_cnt_cd.value	= "";									//Buyer Code(hidden code 1)
	    		formObj.selected_mnr_prnr_seq.value 	= "";									//Buyer Code(hidden code 2)

	    		// 버튼 , 프로그레스바 설정 끝
	    		MnrWaitControl(false);
	    		sheetObj.WaitImageVisible = true;

	    		setBtnLoadExcel();	// Load Excel 버튼 활성화 설정
	    		setBtnDocSend();		//Doc Send 버튼 활성화 설정
	    		break;

    		//조회(Master)
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.WaitImageVisible = true;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0160GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
					sheetObj.WaitImageVisible = false;
				}
				break;

			//조회(Detail)
			case IBSEARCH_ASYNC01:
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.WaitImageVisible = true;
					formObj.f_cmd.value = SEARCH01;
					var sXml = sheetObj.GetSearchXml("EES_MNR_0160GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
					sheetObj.WaitImageVisible = false;
				}
				break;

			//저장
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					//저장전 상태변경  및  disp_sold_dt_flag 설정
					for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
						//모든 조회상태의 Row 상태 변경
						if(sheetObjects[1].RowStatus(i) == "R") {
							sheetObjects[1].RowStatus(i) = "U";
						}
						//disp_sold_dt_flag 설정
						var dispSoldDtFlg	= sheetObjects[1].CellValue(i, "disp_sold_dt_flg");
						var dispSoldDt    	= sheetObjects[1].CellValue(i, "disp_sold_dt");
						if(dispSoldDtFlg=="D") {
							//입력변경
							if(dispSoldDt!="" && dispSoldDt!=null) {
								sheetObjects[1].CellValue(i, "disp_sold_dt_flg") = "Y";
							}
						}
						if(dispSoldDtFlg=="E") {
							//제거변경
							if(dispSoldDt=="" || dispSoldDt==null) {
								sheetObjects[1].CellValue(i, "disp_sold_dt_flg") = "N";
							} else {
								//수정변경
								var eqNo	= sheetObjects[1].CellValue(i, "eq_no");
								var oldEqNo	= sheetObjects[1].CellValue(i, "old_eq_no");
								if(oldEqNo!=eqNo){
									sheetObjects[1].CellValue(i, "disp_sold_dt_flg") = "U";
								}
							}
						}
					}

					formObj.f_cmd.value = MULTI;
					var sParam = sheetObjects[1].GetSaveString(true, true);
					//멘덴토리 체크
					if(sParam == "" && sheetObjects[1].IsDataModified){
						return;
					}
					sParam = ComSetPrifix(sParam,"dispDtl_");
					sParam += "&" + FormQueryString(formObj);
					
					var sXml = sheetObjects[1].GetSaveXml("EES_MNR_0160GS.do", sParam);
					sheetObjects[0].LoadSaveXml(sXml);

					var mnrPrnrCntCd = ComGetEtcData(sXml,"mnr_prnr_cnt_cd");
					var mnrPrnrSeq 	 = ComGetEtcData(sXml,"mnr_prnr_seq");
					var selectDispNo = ComGetEtcData(sXml,"select_disp_no");
					
					
					ydCheck = false;
					for(var i=sheetObjects[0].HeaderRows; i<=sheetObjects[0].LastRow; i++){
						if(sheetObjects[0].CellValue(i,"mnr_prnr_cnt_cd") == mnrPrnrCntCd && sheetObjects[0].CellValue(i,"mnr_prnr_seq") == mnrPrnrSeq && sheetObjects[0].CellValue(i,"disp_no") == selectDispNo){
							//FOCUS
							sheetObjects[0].SelectCell(i, 1);
							//DETAIL 조회
							formObj.f_cmd.value = SEARCH01;
							var sXml = sheetObjects[1].GetSearchXml("EES_MNR_0160GS.do", FormQueryString(formObj));
							sheetObjects[1].LoadSearchXml(sXml);
						}
					}
					ydCheck = true;
				}
				break;

	        //Load Excel
			case IBLOADEXCEL:
				if(validateForm(sheetObj,formObj,sAction)) {
					var insCnt = getInsCnt();
					ComOpenPopup('/hanjin/EES_MNR_0221.do?insCnt='+insCnt, 500, 430, 'setEES_MNR_221', '0,1,1,1,1,1,1,1,1,1,1,1');
				}
				break;

		    //Doc Send
        	case "DOCSEND":
        		if(validateForm(sheetObj,formObj,sAction)) {
        			var dispNo 			= sheetObjects[0].CellValue(sheetObjects[0].selectRow, "disp_no");  		//Disposal No
        			var userNm 			= sheetObjects[0].CellValue(sheetObjects[0].selectRow, "buyer_name");		//Buyer Name
        			var mnrPrnrCntCd	= sheetObjects[0].CellValue(sheetObjects[0].selectRow, "mnr_prnr_cnt_cd");	//mnr_prnr_cnt_cd
        			var mnrPrnrSeq		= sheetObjects[0].CellValue(sheetObjects[0].selectRow, "mnr_prnr_seq");		//mnr_prnr_seq
        			var faxNo			= sheetObjects[0].CellValue(sheetObjects[0].selectRow, "fax_no");			//fax_no
        			var mnrPrnrEml		= sheetObjects[0].CellValue(sheetObjects[0].selectRow, "mnr_prnr_eml");		//mnr_prnr_eml
        			ComOpenPopup('/hanjin/EES_MNR_0235.do?disp_no='+dispNo+'&user_nm='+userNm+'&mnr_prnr_cnt_cd='+mnrPrnrCntCd+'&mnr_prnr_seq='+mnrPrnrSeq+'&fax_no='+faxNo+'&mnr_prnr_eml='+mnrPrnrEml, 900, 600, '', '0,1,1,1,1,1,1,1', true);
        		}
        		break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		// 조회시 체크
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    			
    			// [Retrieve] 시 Office 필수 체크
    			if(0 == sAction){    	
    				
    				// Office check
    				if(!ofc_cd_Check()) {return false;}
    				
    				if(ComTrim(formObj.ofc_cd.value) == ""){
    					ComShowCodeMessage("MNR00201", "Office");
    					formObj.ofc_cd.focus();
    					return false;
    				}
    			}
    		}
    		// 저장시 체크
    		else if (sAction == IBSAVE) {
				//그리드 존재유무
				if(sheetObjects[1].RowCount < 1) {return false;}
				//그리드 수정유무
				if(!sheetObjects[1].IsDataModified) {
					ComShowCodeMessage("MNR00369");
					return false;
				}
				//중복체크
				var Row = sheetObjects[1].ColValueDup("eq_no");
				if(Row>0){
					ComShowCodeMessage("MNR00006",(Row) + " row ");
					sheetObjects[1].SelectCell(Row, "eq_no", true);
					return false;
				}
				//EQ No 와 Release No,Sold Dt 존재관계 유무 체크
				for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
					var eqNo       	= sheetObjects[1].CellValue(i, "eq_no");		//EQ No
					var dispRlseNo	= sheetObjects[1].CellValue(i, "disp_rlse_no");	//Release No
					var dispSoldDt	= sheetObjects[1].CellValue(i, "disp_sold_dt");	//Sold DT
					//EQ No 가 없을 때
					if(eqNo=="" || eqNo==null) {
						if(dispRlseNo!="" && dispRlseNo!=null) {
							ComShowCodeMessage("MNR00294", "Release No");
							sheetObjects[1].SelectCell(i, "eq_no");
							return false;
						}
						if(dispSoldDt!="" && dispSoldDt!=null) {
							ComShowCodeMessage("MNR00294", "Sold DT");
							sheetObjects[1].SelectCell(i, "eq_no");
							return false;
						}

					} else {
						var dispYdCd = sheetObjects[1].CellValue(i, "disp_yd_cd");
						if(dispYdCd.length < 7) {
							ComShowCodeMessage("MNR00332");
							sheetObjects[1].SelectCell(i, "disp_yd_cd");
							return false;
						}
					}
				}
				
				
				
				
				//오늘날짜 이후 Date를 선택 불가: 2016-05-23 로직 보완(이율규) -- 시작
				var dateErr = 0; // 에러 메세지를 발생시키기 위한 변수 
				for(var i = 1; i < sheetObjects[1].Rows; i++){
					
					if(sheetObjects[1].CellValue(i, "disp_sold_dt") != "" && sheetObjects[1].CellEditable(i, "disp_sold_dt") == true){
				        var betDays = ComGetDaysBetween(sheetObjects[1].CellValue(i, "disp_sold_dt"), ComGetNowInfo("ymd"));
				        if(betDays < 0){
				        	if(dateErr == 0){
				        		ComShowCodeMessage("MNR00396","Sold");
				        		dateErr = 1;
				        	}
							sheetObjects[1].CellValue2(i, "disp_sold_dt") = "";
							
						}
					}
				}
				
				if(dateErr == 1){ //날짜에 문제가 있는 경우 false를 return. 
	        		return false;
	        	}
				//오늘날짜 이후 Date를 선택 불가: 2016-05-23 로직 보완(이율규) -- 종료				

				
				if (!ComShowCodeConfirm("MNR00160")){return false;}
    		}
    		// Load Excel 시  체크
    		else if (sAction == IBLOADEXCEL) {
    			var insCnt = getInsCnt();
				if(insCnt == 0) {
					//모든 EQ No 컬럼에  값이 존재합니다.
					ComShowCodeMessage("MNR00265");
					return false;
				}
    		}
    		// Doc Send 시 체크
    		else if (sAction == "DOCSEND") {
    			if(sheetObjects[0].RowCount<1) {
    				return false;
    			}
    		}
        }
        return true;
    }

/* ********* User Functions ************* */
	/**
	 * (Customer) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
    function setBuyer(aryPopupData) {
    	if ( aryPopupData.length > 0 ) {
    		var formObj = document.form;
    		var custCd 			= aryPopupData[0][3];
    		var custNm 			= aryPopupData[0][4];
    		var mnrPrnrCntCd	= custCd.substring(0,2);
    		var mnrPrnrSeq   	= custCd.substring(2);
    		formObj.buyer_code.value = custCd;
    		formObj.buyer_name.value = custNm;
    		formObj.mnr_prnr_cnt_cd.value = mnrPrnrCntCd;
    		formObj.mnr_prnr_seq.value = mnrPrnrSeq;
    	}
    }

    /**
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj = document.form;
 		var tempText = "";
 		//초기화
		eval("document.form." + return_val + ".value = '';");

 		for(var i=0; i<rowArray.length; i++) {
 			tempText +=  rowArray[i] + ',';
 		}
 		//마지막에 ,를 없애기 위함
 		tempText = MnrDelLastDelim(tempText);

 		eval("document.form." + return_val + ".value = '" + tempText + "';");
 	}

	/**
	 * EQ No 값을 변경함에 따라 TP/SZ 값을 재설정한다.
	 *
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		var dispUtTpCd	= sheetObj.CellValue(Row, "disp_ut_tp_cd");		//Sale Type(E:Unit Sale, Q:Bulk Sale)

		//EQ No 존재유무 체크조회
		var rqstEqNo 	= sheetObj.CellValue(Row, "eq_no");  									//EQ No
		var eqKndCd 	= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eq_knd_cd");	//EQ Type
		var dispNo		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "disp_no");		//Disposal No
		var eqTpszCd	= sheetObj.CellValue(Row,"eq_tpsz_cd");  								//TP/SZ
		if(dispUtTpCd=="E") {	//Sale Type(Unit Sale)
			var retArray = MnrGeneralCodeCheck(sheetObj,"DSPEQN",rqstEqNo + "," + eqKndCd + "," + dispNo);
		} else {				//Sale Type(Bulk Sale)
			var retArray = MnrGeneralCodeCheck(sheetObj,"DSPEQN",rqstEqNo + "," + eqKndCd + "," + dispNo + "," +eqTpszCd);
		}
		if(retArray == null){
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			setEqNoClear(sheetObj,Row,dispUtTpCd);
			return;

		} else {
			var tempText = retArray[0].split("|");
			if(tempText[1] != 'OK'){
				ComShowCodeMessage("MNR00302",tempText[0]);
				setEqNoClear(sheetObj,Row,dispUtTpCd);
				return;
			}
		}

		//TP/SZ 조회설정  : Sale Type(Unit Sale) 인 경우만
		if(dispUtTpCd=="E") {
			var formObj = document.form;
			var totalLossDate	= ComGetNowInfo("ymd");
			var sCostType = "";
			if(eqKndCd == "U"){
				sCostType = "MRDRRC";
			} else if(eqKndCd == "G"){
				sCostType = "MRGSRC";
			} else {
				sCostType = "MRZSRC";
			}
			var sXml = MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
			var retArr =  MnrXmlToArray(sXml);
			//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
			if(retArr == null){
				setEqNoClear(sheetObj,Row,dispUtTpCd);
				return;
			}
			sheetObj.CellValue2(Row, "eq_tpsz_cd") = retArr[0][31];  //TP/SZ
		}

		//EQ No 이외  항목 설정
		sheetObj.CellValue2(Row, "disp_rlse_no")	= getReleaseNo(sheetObj,Row);	//Release No
	}

	/**
	 * EQ No 관련 항목을 초기화 한다.
	 * @param sheetObj
	 * @param Row
	 * @return
	 */
	function setEqNoClear(sheetObj,Row,dispUtTpCd) {
		sheetObj.CellValue2(Row, "eq_no")	= "";	//EQ No
		//Unit Sale
		if(dispUtTpCd=="E") {
			sheetObj.ReturnCellData(Row, "eq_tpsz_cd");		//TP/SZ
		}
		sheetObj.CellValue2(Row, "disp_rlse_no")	= "";	//Release No
		sheetObj.CellValue2(Row, "disp_sold_dt")	= "";	//Sold DT
	}

	/**
	 * EQ No 입력시 Release No 를 생성조회한다.
	 * Thanks for Park Myung Shin
	 * @param sheetObj
	 * @return
	 */
	function getReleaseNo(sheetObj,Row){
		document.form.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("EES_MNR_0160GS.do", FormQueryString(document.form));
		var maxDispRlseNoSuffix = parseInt(ComGetEtcData(sXml, "dispRlseNo"),10);
        var dispRlseNoPrefix = currOfcCd + ComReplaceStr(ComGetNowInfo("ymd"), "-", "");

		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
			var rowStatus = sheetObj.RowStatus(i);
			if(rowStatus!="D" && i!=Row) { //삭제행 제외, 비교자신행 제외
				var rowDispRlseNo = sheetObj.CellValue(i, "disp_rlse_no");
				if(rowDispRlseNo!="" && rowDispRlseNo!=null) { //Release No 존재행
					var rowDispRlseNoPrefix = rowDispRlseNo.substring(0, rowDispRlseNo.indexOf("-"));
					if(rowDispRlseNoPrefix==dispRlseNoPrefix) { //Prefix 동일값
						var rowDispRlseNoSuffix = parseInt(rowDispRlseNo.substring(rowDispRlseNo.length-3),10);
						if(maxDispRlseNoSuffix < rowDispRlseNoSuffix) { //비교
							maxDispRlseNoSuffix = rowDispRlseNoSuffix;
						}
					}
				}
			}
		}

		var newDispRlseNoSuffix =  maxDispRlseNoSuffix + 1;
		var dispRlseNo = dispRlseNoPrefix + '-' + ComLpad((newDispRlseNoSuffix + ''),3,"0");;

		return dispRlseNo;
	}

    /**
     * 조회시 Release No 생성조회한다.
     * EQ No 가 존재하고 Release No 가 없는 경우
     * @param sheetObj
     * @return
     */
	function setReleaseNo(sheetObj) {
		document.form.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("EES_MNR_0160GS.do", FormQueryString(document.form));
		var maxDispRlseNoSuffix = ComGetEtcData(sXml, "dispRlseNo");

		maxDispRlseNoSuffix = parseInt(maxDispRlseNoSuffix,10);
		var dispRlseNoFlgCnt = 0;
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
			var dispRlseNoFlg = sheetObj.CellValue(i, "disp_rlse_no_flg");
			if(dispRlseNoFlg=="Y") {
				dispRlseNoFlgCnt++;
				var newDispRlseNoSuffix =  maxDispRlseNoSuffix + dispRlseNoFlgCnt;
				newDispRlseNoSuffix = ComLpad((newDispRlseNoSuffix + ''),3,"0");
				var dispRlseNo = currOfcCd + ComReplaceStr(ComGetNowInfo("ymd"), "-", "") + '-' + newDispRlseNoSuffix;
				sheetObj.CellValue(i, "disp_rlse_no") = dispRlseNo;
			}
		}
	}


	/**
	 * Yard 값의 존재유무를 체크한다.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function checkPUpYardCd(sheetObj,Row,Col) {
		var dispYdCd = sheetObj.CellValue(Row, "disp_yd_cd");
		var retArray = MnrGeneralCodeCheck(sheetObj,"SLDYARD",dispYdCd);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",dispYdCd,"YARD");
			sheetObj.ReturnCellData(Row, "disp_yd_cd");
			sheetObj.SelectCell(Row, "disp_yd_cd");
		}
	}

	/**
	 * 저장시 그리드 존재유무
	 */
	function checkIsDetailRow(){
		var cnt = 0;
		for (var i=1; i<6; i++) {
			if(sheetObjects[i].RowCount > 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}

		return true;
	}

	/**
	 * EES_MNR_0221 Popup의 값을 받은 함수
	 */
	function setEES_MNR_221(aryPopupData){
    	 var formObj = document.form;

    	 var eqNos    	= new Array();
    	 var pUpYards 	= new Array();
    	 var dispSoldDt	= new Array();
		 for(var i=0; i<aryPopupData.length; i++) {
			 eqNos[i] 		= aryPopupData[i][4];
			 pUpYards[i]	= aryPopupData[i][5];
			 dispSoldDt[i]	= aryPopupData[i][6];
		 }

		 var insCnt = 0;
		 for(var j=sheetObjects[1].HeaderRows; j<=sheetObjects[1].LastRow; j++) {
			 var eqNo = sheetObjects[1].CellValue(j, "eq_no");
			 if(eqNo == "" || eqNo == null) {
				 if(eqNos[insCnt] !="" && eqNos[insCnt] != null) {
					 sheetObjects[1].CellValue(j, "eq_no") 			= eqNos[insCnt];
					 sheetObjects[1].CellValue(j, "disp_yd_cd") 	= pUpYards[insCnt];
					 if(dispSoldDt[insCnt] !="" && dispSoldDt[insCnt] !=null) {
						 sheetObjects[1].CellValue(j, "disp_sold_dt")	= dispSoldDt[insCnt];
					 } else {
						 sheetObjects[1].CellValue(j, "disp_sold_dt")	= ComGetNowInfo("ymd");
					 }
					 insCnt++;
				 }
			 }
		 }
	}

	/**
	 * Disposal Detail List 의 값이 없는 EQ No 컬럼의 갯수를 구한다.
	 * @return int insCnt
	 */
    function getInsCnt() {
		var insCnt = 0;
		for(var i=sheetObjects[1].HeaderRows; i<=sheetObjects[1].LastRow; i++) {
			var eqNo = sheetObjects[1].CellValue(i, "eq_no");
			if(eqNo=="" || eqNo==null) {
				insCnt++;
			}
		}
		return insCnt;
    }

    /**
     * Load Excel 버튼의 Edit 설정
     * @return
     */
    function setBtnLoadExcel() {
    	var rowCnt 		= sheetObjects[1].RowCount;	//Disposal Detail List 의 Row 갯수
    	var eqNoNullCnt	= getInsCnt();				//EQ No 의 값이 없는 Row 갯수
    	if(rowCnt>0 && eqNoNullCnt>0) {
    		ComBtnEnable("btn_LoadExcel");
    	} else {
    		ComBtnDisable("btn_LoadExcel");
    	}
    }

    /**
     * Doc Send 버튼의 활성화 설정
     * @return
     */
    function setBtnDocSend() {
    	var status = ComGetObjValue(document.form.status);
    	var rowCnt = sheetObjects[0].RowCount;
    	if(status=="S" && rowCnt>0) {
    		ComBtnEnable("btn_DocSend");
    	} else {
    		ComBtnDisable("btn_DocSend");
    	}
    }
    /**
     * 조건부 Buyer 입력시 Buyer 명 조회
     * @return
     */
	function setCustomerName(){
		MnrWaitControl(true);
		sheetObjects[0].Enable=false;

		var formObj=document.form;

		var custCd			= formObj.buyer_code.value;
		var mnrPrnrCntCd	= custCd.substring(0,2);
		var mnrPrnrSeq   	= custCd.substring(2);
		mnrPrnrSeq = ComLpad(mnrPrnrSeq, 6, "0");
		formObj.buyer_code.value = mnrPrnrCntCd + mnrPrnrSeq;

		var	sXml=MnrComCustomerInfoSearch(sheetObjects[0],mnrPrnrCntCd,mnrPrnrSeq);
		var arrResult = MnrXmlToArray(sXml);

		if(arrResult != null){
       		formObj.buyer_name.value  		= arrResult[0][10];
       		formObj.mnr_prnr_cnt_cd.value	= mnrPrnrCntCd;
       		formObj.mnr_prnr_seq.value 		= mnrPrnrSeq;
		} else {
			ComShowCodeMessage("MNR00121");
			formObj.buyer_code.value  		= "";
       		formObj.buyer_name.value  		= "";
       		formObj.mnr_prnr_cnt_cd.value	= "";
       		formObj.mnr_prnr_seq.value 		= "";
		}

		sheetObjects[0].Enable=true;
		MnrWaitControl(false);
	}

	function setPopUpParam_COM_ENS_071(array) {
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(',');

		formObj.ofc_cd.value = arr[3];
	}
	
	// Office Check
	function ofc_cd_Check(){
		var sheetObj = sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.ofc_cd.value," ")!=""){
			var retArray = MnrGeneralCodeCheck(sheetObj,"OFC",formObj.ofc_cd.value);  
			if(retArray == null){           
				ComShowCodeMessage("MNR00165",formObj.ofc_cd.value,"OFFICE"); 
				formObj.ofc_cd.value="";
				ComSetFocus(formObj.ofc_cd);
				return false;
			} else {	  
				var retArray=retArray[0].split("|");
				formObj.ofc_cd.value=retArray[0];	
	
			}  
		}
		return true;
	}	
