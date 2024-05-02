/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_LSE_0021.js
 *@FileTitle : Off-Hire CNTR List - Send to Lessor
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
	 * @class EES_LSE_0021 : EES_LSE_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0021() {
		this.processButtonClick  = processButtonClick;
		this.setSheetObject 	 = setSheetObject;
		this.loadPage 			 = loadPage;
		this.sheet1_OnLoadFinish = sheet1_OnLoadFinish;
		this.initSheet 			 = initSheet;
		this.doActionIBSheet 	 = doActionIBSheet;
		this.sheet1_OnMouseMove  = sheet1_OnMouseMove;
		this.openPopup 			 = openPopup;
		this.callbackSendMail 	 = callbackSendMail;
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
		this.delayActionIBSheet  = delayActionIBSheet;
		this.validateForm 		 = validateForm;
	}

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	var sendFlag = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObj = document.form;

    	try {
			var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_email":
					openPopup("1");
					break;
				case "btn_save":
					openPopup("2");
					break;

				case "btn_downexcel":
					with(sheetObject) {
						if(FindCheckedRow("del_chk") == "") {
							ComShowMessage(MessageText("UserMsg13"));
						} else {
							var vSkipRows = "";

							for(var i = HeaderRows; i <= LastRow; i++) {
								if(CellValue(i, "del_chk") == 0) {
									vSkipRows += i+"|";
								}
							}
							SpeedDown2Excel(-1,false,false,'','',false,false,'',false,'del_chk',vSkipRows,false);
						}
					}
					break;

                case "btn_close":
                	//모달창에서 window.open 호출시 세션이 끊기는 문제로 모달리스로 변경
                	//var opener = window.dialogArguments;
                	if(sendFlag == true) {
    					opener.callbackPopupMail(500);
                	}
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

		//doActionIBSheet(sheetObj, formObj, IBSEARCH);
		doActionIBSheet(sheetObj, formObj, IBBATCH);
    }

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetid = sheetObj.id;
		var formObj = document.form;

        switch(sheetid) {
            case "sheet1":
				with (sheetObj) {

                    // 높이 설정
                    style.height = 270;
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

					var HeadTitle1 = "";
					if(/2|3/.test(formObj.loc_case.value)) {//Location Case is Lane or Port
						HeadTitle1 = "|SEL.||Lessor|Lessor||AGMT No.|||Lease\nTerm|Ref No.|TP/SZ|CNTR No.|T.VVD|Current\nYard|Return\nYard|Off-Hire\nYard|Off-Hire\nDue Date|MT/Full|MVMT\nState|MVMT\nDate|On-Hire\nYard|On-Hire\nDate|Min On-Hire\nDays|Used\nDays|Free\nDays|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|R.Office|ETD-DT|ETA-DT|";
					} else {
						HeadTitle1 = "|SEL.||Lessor|Lessor||AGMT No.|||Lease\nTerm|Ref No.|TP/SZ|CNTR No.|Current\nYard|Return\nYard|Off-Hire\nYard|Off-Hire\nDue Date|MT/Full|MVMT\nState|MVMT\nDate|On-Hire\nYard|On-Hire\nDate|Min On-Hire\nDays|Used\nDays|Free\nDays|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|R.Office|ETD-DT|ETA-DT|T.VVD|";
					}
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 13, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,	true,	"del_chk");

		            InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"scc_cd",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,	true,	"vndr_seq",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"vndr_abbr_nm",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtHidden,      	90,		daCenter,	true,	"vndr_lgl_eng_nm",	false,"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,		daCenter,	true,	"agmt_no",			false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	50,		daCenter,	true,	"agmt_cty_cd",		false,	"",		dfNone, 	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daCenter,	true,	"agmt_seq",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	55,		daCenter,	true,	"lstm_cd",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,     	110,   	daLeft,		true,	"ref_no",			false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,      	55,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",		dfNone, 	0,	false,	false);
		            InitDataProperty(0, cnt++ , dtData,     	90,   	daCenter,	true,	"cntr_no",			false,	"",		dfNone, 	0,	false,	false);
		            if(/2|3/.test(formObj.loc_case.value)) {//Location Case is Lane or Port
		            	InitDataProperty(0, cnt++ , dtData,    	80,		daCenter,	true,	"vvd_cd",			false,	"",		dfNone, 	0,	false,	false);
		            }
		            InitDataProperty(0, cnt++ , dtData,      	65,		daCenter,	true,	"crnt_yd_cd",		false,	"",		dfNone, 	0,	false,	false);
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
					if(!/2|3/.test(formObj.loc_case.value)) {//Location Case is Lane or Port
						InitDataProperty(0, cnt++ , dtData,     80,		daCenter,	true,	"vvd_cd",			false,	"",		dfNone, 	0,	false,	false);
					}
					InitDataProperty(0, cnt++ , dtHidden,      	120,	daCenter,	true,	"complex_pk",		false,	"",		dfNone, 	0,	false,	false);

					SelectBackColor = LSE_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
				}
				break;

        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj, formObj, sAction)) {

					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("EES_LSE_0021GS.do",FormQueryString(formObj));

				}
				break;

			case IBBATCH:      //조회-BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = COMMAND01;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);

					var sXml = sheetObj.GetSearchXml("EES_LSE_0021GS.do", FormQueryString(formObj), "", true);
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

					if (backendJobKey.length > 0) {
						ComSetObjValue(formObj.backendjob_key, backendJobKey);
						sheetObj.RequestTimeOut = 10000;
						timer1 = setInterval(getBackEndJobStatus, 3000);
					}
				}
				break;

			case IBSAVE:
                if(validateForm(sheetObj, formObj, sAction)) {
                    if(sheetObj.id == "sheet1") {
                        formObj.f_cmd.value = MULTI;
                        sheetObj.DoSave("EES_LSE_0021GS.do", FormQueryString(formObj), -1, false);
                    }

                }
                break;
        }
    }

	/**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			//마우스 위치를 행과 컬럼과 값 가져오기
			Row = MouseRow;
			Col = MouseCol;
			if(Row >= HeaderRows && ColSaveName(Col) == "vndr_seq") {
				sText = CellText(Row,Col);
				//풍선도움말 만들기
				MouseToolTipText = CellText(Row,"vndr_lgl_eng_nm");
			} else {
				MouseToolTipText = "";
			}
		}
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Lessor Code Popup for FORM, 2:Agreement No. Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];

    	if ( type == "1" ) {
			with(sheetObj) {
				if(FindCheckedRow("del_chk") == "") {
					ComShowMessage(MessageText("UserMsg13"));
				} else {
					var vCntrItems = "";
					for(var i = HeaderRows, cnt = 1; i <= LastRow; i++) {
						if(CellValue(i, "del_chk") == 1) {
		            		vCntrItems += "<tr align='center'><td>"+ cnt++ +"</td>";
		            		vCntrItems += "<td>"+ CellValue(i, "cntr_no") +"</td>";
		            		vCntrItems += "<td>"+ CellValue(i, "off_hire_yard") +"</td>";
		            		vCntrItems += "<td>"+ CellValue(i, "off_hire_due_date") +"</td>";
		            		vCntrItems += "<td></td></tr>";
						}
					}

					formObj.argument.value  = "send_dt;"+ formObj.curr_dt.value;
		    		formObj.argument.value += ",cntr_list;" + vCntrItems;
		    		var vFeatures = "status=no, resizable=no, scrollbars=no, width=" + 770
							  	  + ", height=" + 780 + ", left=" + (screen.width -770) / 2
							  	  + ", top=" + (screen.height -780) / 2;

	    			ComPostOpenWindow("/hanjin/EES_LSE_0021_01.do?f_cmd=", "EES_LSE_0021_01", vFeatures);
				}
			}
    	}else if(type == "2"){
			with(sheetObj) {
				if(FindCheckedRow("del_chk") == "") {
					ComShowMessage(MessageText("UserMsg13"));
				} else {
					var vCntrItems = "";
					for(var i = HeaderRows, cnt = 1; i <= LastRow; i++) {
						if(CellValue(i, "del_chk") == 1) {
		            		vCntrItems += "<tr align='center'><td>"+ cnt++ +"</td>";
		            		vCntrItems += "<td>"+ CellValue(i, "cntr_no") +"</td>";
		            		vCntrItems += "<td>"+ CellValue(i, "off_hire_yard") +"</td>";
		            		vCntrItems += "<td>"+ CellValue(i, "off_hire_due_date") +"</td>";
		            		vCntrItems += "<td></td></tr>";
						}
					}

					formObj.argument.value  = "send_dt;"+ formObj.curr_dt.value;
		    		formObj.argument.value += ",cntr_list;" + vCntrItems;

					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
			}
    		
    	}

    	return;
    }

	/**
	 * 메일전송 후 호출되는 콜백메서드
	 */
	function callbackSendMail(interval) {
		timer2 = setInterval(delayActionIBSheet, interval);
	}

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0021GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			document.body.style.overflow="hidden";
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("LSE01125");
			clearInterval(timer1);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND03;
		var sXml = sheetObj.GetSearchXml("EES_LSE_0021GS.do", FormQueryString(form));
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
	}

	/**
	 * 지연된 Sheet관련 프로세스 처리
	 */
	function delayActionIBSheet() {
		var formObj = document.form;
		//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
		clearInterval(timer2);
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH:      //조회
    			case IBBATCH:      	//조회-BackEndJob
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}

	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//저장
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}

        return true;
    }

	/* 개발자 작업  끝 */
