/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1113.js
 *@FileTitle : Historical Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.08.03
 *@LastModifier : 김상수
 *@LastVersion : 1.51
 *
 * 2009.08.24 조재성
 *     1.0 Creation
 *
 * 2010.08.03 김상수
 *     [CHM-201004960-01] Genset Ineventory Logic error 수정건
 *         : [EES_CGM_1113] UI에 RCC멀티콤보 기능 및 조회조건 추가 by 김상수
 *
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends
     * @class EES_CGM_1113 : EES_CGM_1113 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1113() {
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
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

    var crntLccCd = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	case "btn_Retrieve":
                	if (validateForm(sheetObject1,formObject,IBSEARCH) != false) {
                		sheetObject1.RemoveAll();
                		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                	}
					break;

            	case "btn_New":
	                initControl();
					break;

				case "btn_DownExcel":
                	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;

                case "btns_crnt_yd_cd":		// Yard
                	ComOpenPopup('/hanjin/COM_ENS_061.do', 800, 475, "callBackYard", "0,1,1,1,1,1,1", true, false);
                	break;

                case "btns_Calendar1" :		// Agreement Date (To Date)
	            	if (formObject.period_type.Code == "Q") {
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	                	cal.setEndFunction("inqFmDysEnd_Q_Cal");
	                	cal.select(formObject.disp_fm_dys, "yyyy-MM");
	        	  	} else if (formObject.period_type.Code == "M")
	        	  	{
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	                	cal.select(formObject.disp_fm_dys, "yyyy-MM");
	        	  	} else if (formObject.period_type.Code == "W")
	        	  	{
	                	var cal = new ComCalendarFromTo();
	                	cal.setEndFunction("inqFmDysEnd_W_Cal");
	                	cal.select(formObject.disp_fm_dys,  formObject.disp_to_dys,  'yyyy-MM-dd');
	        	  	} else if (formObject.period_type.Code == "D")
	        	  	{
	                	var cal = new ComCalendarFromTo();
	                	cal.select(formObject.disp_fm_dys,  formObject.disp_to_dys,  'yyyy-MM-dd');
	        	  	}
                	break;

                case "btns_Calendar2" :		// Agreement Date (To Date)
	            	if (formObject.period_type.Code == "Q")
	            	{
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	                	cal.setEndFunction("inqFmDysEnd_Q_Cal");
	                	cal.select(formObject.disp_fm_dys, "yyyy-MM");

	        	  	} else if (formObject.period_type.Code == "M")
	        	  	{
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	                	cal.select(formObject.disp_to_dys, "yyyy-MM");

	        	  	} else if (formObject.period_type.Code == "W")
	        	  	{
	                	//var cal = new ComCalendar();
	                	//cal.setEndFunction("inqFmDysEnd_W_Cal");
	                	//cal.select(formObject.disp_fm_dys, 'yyyy-MM-dd');
	                	var cal = new ComCalendarFromTo();
	                	cal.setEndFunction("inqFmDysEnd_W_Cal");
	                	cal.select(formObject.disp_fm_dys,  formObject.disp_to_dys,  'yyyy-MM-dd');
	        	  	} else if (formObject.period_type.Code == "D")
	        	  	{
	                	var cal = new ComCalendarFromTo();
	                	cal.select(formObject.disp_fm_dys,  formObject.disp_to_dys,  'yyyy-MM-dd');
	        	  	}
	    			break;
            } // end switch
    	} catch(e) {
    		if ( e == "[object Error]") {
         		ComShowMessage(OBJECT_ERROR);
    		} else {
         		ComShowMessage(e);
    		}
    	}
    }


    /**
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheet_obj	필수
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function loadPage() {
      	for(i=0;i<sheetObjects.length;i++) {
        	//khlee-시작 환경 설정 함수 이름  변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    }


    /**
     * Sheet 로딩 후 기본 설정 및 초기화 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.10.20
     */
    function sheet1_OnLoadFinish(sheetObj) {
        var formObject = document.form;
      	// axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
      	axon_event.addListener('keyup', 'enterFire', 'crnt_yd_cd', 'disp_fm_dys', 'disp_to_dys');
      	axon_event.addListener('blur', 'disp_fm_dys_blur', 'disp_fm_dys');
      	axon_event.addListener('blur', 'disp_to_dys_blur', 'disp_to_dys');
      	axon_event.addListener('focusin', 'disp_fm_dys_focusin', 'disp_fm_dys');
      	axon_event.addListener('focusin', 'disp_to_dys_focusin', 'disp_to_dys');
      	axon_event.addListener('keyup', 'obj_keyup', 'crnt_yd_cd');

     	// Multi Combo 초기화
     	comboObjects[comboCnt++] = document.report_type;
     	comboObjects[comboCnt++] = document.cnmv_sts_cd;
     	comboObjects[comboCnt++] = document.period_type;
     	// 김상수 2010-07-29 rcc_cd to multicombo
     	comboObjects[comboCnt++] = document.crnt_rcc_cd;
     	// 김상수 2010-07-29 lcc_cd to multicombo
     	comboObjects[comboCnt++] = document.crnt_lcc_cd;
     	// chungpa 20091016 scc_cd to multicombo
     	comboObjects[comboCnt++] = document.crnt_scc_cd;

      	for(var k=0;k<comboObjects.length;k++) {
  	        initCombo(comboObjects[k]);
        }

        // report_type
      	var arrRT = new Array();
      	arrRT[0] = "I|Chassis Inventory";
      	arrRT[1] = "C|Container Status";
		arrRT[2] = "v|Available Chassis";
		arrRT[3] = "A|Assigned Days";
		arrRT[4] = "U|Usage Days";
		arrRT[5] = "t|Utilization (%)";
      	makeComboObject(document.report_type, arrRT, 1, 0, 0);

      	// cnmv_sts_cd
      	var arrSTS = new Array();
      	arrSTS[0] = 'W|Wheeled Containers';
      	arrSTS[1] = 'G|Grounded Containers';
      	arrSTS[2] = 'MT|MT';
      	arrSTS[3] = 'OP|OP';
      	arrSTS[4] = 'OC|OC';
      	arrSTS[5] = 'IC|IC';
      	arrSTS[6] = 'ID|ID';
      	arrSTS[7] = 'EN|EN';
      	arrSTS[8] = 'TN|TN';
      	arrSTS[9] = 'TS|TS';
      	arrSTS[10] = 'CM|CM';
      	arrSTS[11] = 'CP|CP';
      	arrSTS[12] = 'CO|CO';
      	arrSTS[13] = 'CI|CI';
      	arrSTS[14] = 'CD|CD';
      	arrSTS[15] = 'CE|CE';
      	arrSTS[16] = 'CT|CT';
      	makeComboObject(document.cnmv_sts_cd, arrSTS, 1, 0, 0);


      	// period_type
      	var arrPT = new Array();
      	arrPT[0] = "Q|Quarter";
      	arrPT[1] = "M|Month";
      	arrPT[2] = "W|Week";
      	arrPT[3] = "D|Day";
      	makeComboObject(document.period_type, arrPT, 1, 0, 0);

     	// rcc_cd to multicombo
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC08);

      	initControl();
    }

    /**
     * Form의 Conrol 를 초기화 시킨다. <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function initControl() {
        var formObj = document.form;
        var sheetObj1 = sheetObjects[0];

        //Form Object 초기화
        with(formObj) {
        	crnt_rcc_cd.value = "";
        	crnt_scc_cd.value = "";
        	crnt_yd_cd.value = "";
        	inq_fm_dys.value = "";
        	inq_to_dys.value = "";
        	disp_fm_dys.value = "";
        	disp_to_dys.value = "";

        	cntr_psn_sts_cd.value = "";

        	// MultiCombo 초기화
        	for(var i=0; i<comboObjects.length; i++) {
        		comboObjects[i].Text2 = "";
        	}
        }
    	// Sheet Object 초기화
    	sheetObj1.RemoveAll();

    	// 초기값 설정
    	comboObjects[0].Index2 = 0;	// change event 를 발생시키지 않기 위해 Index2 를 사용
    	report_type_OnChange();
    	comboObjects[2].Index2 = 3; // Day default.

    	ComSetFocus(formObj.crnt_rcc_cd); //초기화시  focus는 location으로 가게 만든다.
    }


    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 402;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);

                    var HeadTitle1 = "|Chassis Inventory|Chassis Inventory|Chassis Inventory|Chassis Inventory";
                    var HeadTitle2 = "|Period|20’|40’|45’";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"Status");
					InitDataProperty(0, cnt++ , dtData,			125,	daCenter,	true,		"period",			false,	"",		dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			125,	daRight,	true,		"chss_20ft_qty",	false,	"",		dfFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			125,	daRight,	true,		"chss_40ft_qty",	false,	"",		dfFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		"chss_45ft_qty",	false,	"",		dfFloat,	2,	false,	false);
					CountPosition = 0;
	                EditableColorDiff = false;
			 		WaitImageVisible = false;
				}

			break;
        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type
     * @return 없음
     * @author 조재성
     * @version 2009.07.30
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:      //조회
        		if (formObj.period_type.Code == 'Q') {
        			//inqFmDysEnd_Q_Cal() 에서  이미 들어가 있슴.
        		} else if (formObj.period_type.Code == 'M') {
        			inqFmDysEnd_M_Cal();
        			inqToDysEnd_M_Cal();
        		} else if (formObj.period_type.Code == 'W') {
        			//inqFmDysEnd_W_Cal() 에서  이미 들어가 있슴.
        		} else if (formObj.period_type.Code == 'D') {
        			formObj.inq_fm_dys.value = formObj.disp_fm_dys.value;
        			formObj.inq_to_dys.value = formObj.disp_to_dys.value;
        		}

        		//cntr_psn_sts_cd start
        		formObj.cntr_psn_sts_cd.value = "";
        		if (document.cnmv_sts_cd.CheckCode("W")) {
        			if (formObj.cntr_psn_sts_cd.value == "")
        				formObj.cntr_psn_sts_cd.value = "W";
        			else
        				formObj.cntr_psn_sts_cd.value = ",W";
        		}
        		if (document.cnmv_sts_cd.CheckCode("G")) {
        			if (formObj.cntr_psn_sts_cd.value == "")
        				formObj.cntr_psn_sts_cd.value = "G";
        			else
        				formObj.cntr_psn_sts_cd.value = ",G";
        		}
        		//cntr_psn_sts_cd end

				if (validateForm(sheetObj,formObj,sAction)) {
			 		ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("EES_CGM_1113GS.do" , FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
			 		ComOpenWait(false);

					// Report type 명을 쉬트 제목으로 설정해준다.
					sheetObj.CellValue(0,1) = document.form.report_type.Text;
					sheetObj.CellValue(0,2) = document.form.report_type.Text;
					sheetObj.CellValue(0,3) = document.form.report_type.Text;
					sheetObj.CellValue(0,4) = document.form.report_type.Text;

					if (formObj.period_type.Code == 'Q') {
						//3달 데이터를 1분기로 보여준다.
						if (sheetObj.rowCount == 3) {
							sheetObj.DataInsert(-1);

							var strDys = ComReplaceStr(sheetObj.CellValue(2,"period"),"-","");
							var qYear = strDys.substring(0,4);
							var qMonth = strDys.substring(4,6) - '00';

				    		if (Math.ceil( qMonth / 3 ) == 1) {
				    			sheetObj.CellValue2(5,"period") = qYear + "-1st";
				    		} else if (Math.ceil( qMonth / 3 ) == 2) {
				    			sheetObj.CellValue2(5,"period") = qYear + "-2nd";
				    		} else if (Math.ceil( qMonth / 3 ) == 3) {
				    			sheetObj.CellValue2(5,"period") = qYear + "-3rd";
				    		} else if (Math.ceil( qMonth / 3 ) == 4) {
				    			sheetObj.CellValue2(5,"period") = qYear + "-4th";
							}

				    		//if (document.form.report_type.Text == "Utilization (%)") { 일평균이기 때문에  3으로 나누어야 한다.
				    			sheetObj.CellValue2(5,"chss_20ft_qty") = Math.round((parseInt(sheetObj.CellValue(2,"chss_20ft_qty")) + parseInt(sheetObj.CellValue(3,"chss_20ft_qty")) + parseInt(sheetObj.CellValue(4,"chss_20ft_qty")))/3);
				    			sheetObj.CellValue2(5,"chss_40ft_qty") = Math.round((parseInt(sheetObj.CellValue(2,"chss_40ft_qty")) + parseInt(sheetObj.CellValue(3,"chss_40ft_qty")) + parseInt(sheetObj.CellValue(4,"chss_40ft_qty")))/3);
				    			sheetObj.CellValue2(5,"chss_45ft_qty") = Math.round((parseInt(sheetObj.CellValue(2,"chss_45ft_qty")) + parseInt(sheetObj.CellValue(3,"chss_45ft_qty")) + parseInt(sheetObj.CellValue(4,"chss_45ft_qty")))/3);
				    		//} else {
				    			//sheetObj.CellValue2(5,"chss_20ft_qty") = parseInt(sheetObj.CellValue(2,"chss_20ft_qty")) + parseInt(sheetObj.CellValue(3,"chss_20ft_qty")) + parseInt(sheetObj.CellValue(4,"chss_20ft_qty"));
				    			//sheetObj.CellValue2(5,"chss_40ft_qty") = parseInt(sheetObj.CellValue(2,"chss_40ft_qty")) + parseInt(sheetObj.CellValue(3,"chss_40ft_qty")) + parseInt(sheetObj.CellValue(4,"chss_40ft_qty"));
				    			//sheetObj.CellValue2(5,"chss_45ft_qty") = parseInt(sheetObj.CellValue(2,"chss_45ft_qty")) + parseInt(sheetObj.CellValue(3,"chss_45ft_qty")) + parseInt(sheetObj.CellValue(4,"chss_45ft_qty"));
				    		//}

				    		//3개월데이터를 지우고, 분기데이터만 남긴다.
				    		sheetObj.RowDelete(2,false);
				    		sheetObj.RowDelete(2,false);
				    		sheetObj.RowDelete(2,false);

						}
	        		}
				}
				break;

 	        case IBSEARCH_ASYNC01:	// WEEK정보 조회
			    formObj.f_cmd.value = SEARCH15;
                ComOpenWait(true);
 	         	var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
                ComOpenWait(false);
	        	var plnyr = ComCgmXml2ComboString(sXml, "code1","code1"); 	//년도
	        	var plnwk = ComCgmXml2ComboString(sXml,"code2","code2");	//주
	        	var plnmon = ComCgmXml2ComboString(sXml,"code3","code3");	//월
	        	var wkstdt = ComCgmXml2ComboString(sXml,"code4","code4");	//시작일
	        	var wkenddt = ComCgmXml2ComboString(sXml,"code5","code5");	//끝일
	        	if (plnyr!=null) {
		        	formObj.plnyr.value = plnyr[0];
		        	formObj.plnwk.value = plnwk[0];
		        	formObj.plnmon.value = plnmon[0];
		        	formObj.wkstdt.value = wkstdt[0];
		        	formObj.wkenddt.value = wkenddt[0];
	        	}
				break;

 	        case IBSEARCH_ASYNC02:	// WEEK정보 조회
			    formObj.f_cmd.value = SEARCH16;
                ComOpenWait(true);
	         	var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
                ComOpenWait(false);
	        	var plnyr = ComCgmXml2ComboString(sXml, "code1","code1"); 	//년도
	        	var plnwk = ComCgmXml2ComboString(sXml,"code2","code2");	//주
	        	var plnmon = ComCgmXml2ComboString(sXml,"code3","code3");	//월
	        	var wkstdt = ComCgmXml2ComboString(sXml,"code4","code4");	//시작일
	        	var wkenddt = ComCgmXml2ComboString(sXml,"code5","code5");	//끝일
		        if (plnyr != null) {
		        	formObj.plnyr.value = plnyr[0];
		        	formObj.plnwk.value = plnwk[0];
		        	formObj.plnmon.value = plnmon[0];
		        	formObj.wkstdt.value = wkstdt[0];
		        	formObj.wkenddt.value = wkenddt[0];
		        }
				break;

        	case IBSEARCH_ASYNC03:	// Yard 에 대한 Validation 체크
		   		formObj.f_cmd.value = COMMAND01;
		   		formObj.yd_cd.value = formObj.crnt_yd_cd.value;
                ComOpenWait(true);
		   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
                ComOpenWait(false);
		   		var sCheckResult = ComGetEtcData(sXml,"checkResult");
		   		if (sCheckResult == COM_VALIDATION_FALSE) {
		   			ComShowCodeMessage('CGM10009','Yard');
		   			formObj.crnt_yd_cd.value = "";
		   			ComSetFocus(formObj.crnt_yd_cd);
		   		}
		   		break;

            case IBSEARCH_ASYNC08:    // RCC조회및 멀티콤보 구성
                formObj.f_cmd.value = SEARCH17;
                formObj.eq_orz_cht_chktype.value = "RCC";
                formObj.eq_orz_cht_rcc_cd.value = "%%";
                ComOpenWait(true);
                var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
                ComOpenWait(false);
                var sStr = ComGetEtcData(sXml,"comboList");
                var arrStr = sStr.split("@");
                makeComboObject(document.crnt_rcc_cd, arrStr, 0, 0, 0);
                ComSetFocus(document.crnt_rcc_cd);
                break;

            case IBSEARCH_ASYNC09:    // LCC조회및 멀티콤보 구성
                formObj.f_cmd.value = SEARCH17;
                formObj.eq_orz_cht_chktype.value = "RCCLCC";
                formObj.eq_orz_cht_rcc_cd.value = formObj.crnt_rcc_cd.Text;
                formObj.eq_orz_cht_lcc_cd.value = "%%";
                ComOpenWait(true);
                var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
                ComOpenWait(false);
                var sStr = ComGetEtcData(sXml,"comboList");
                if (sStr == null || sStr == "") {
                    document.crnt_lcc_cd.RemoveAll();
                } else {
                    var arrStr = sStr.split("@");
                    makeComboObject(document.crnt_lcc_cd, arrStr, 0, 0, 0);
                    ComSetFocus(document.crnt_lcc_cd);
                }
                break;

            case IBSEARCH_ASYNC10:    // SCC조회및 멀티콤보 구성
                formObj.f_cmd.value = SEARCH17;
                formObj.eq_orz_cht_chktype.value = "LCCSCC";
                formObj.eq_orz_cht_lcc_cd.value = document.crnt_lcc_cd.Text;
                formObj.eq_orz_cht_scc_cd.value = "%%";
                ComOpenWait(true);
                var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
                ComOpenWait(false);
                var sStr = ComGetEtcData(sXml,"comboList");
                if (sStr == null || sStr == "") {
                    document.crnt_scc_cd.RemoveAll();
                } else {
                    var arrStr = sStr.split("@");
                    makeComboObject(document.crnt_scc_cd, arrStr, 0, 0, 0);
                    ComSetFocus(document.crnt_scc_cd);
                }
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                sheetObj.SpeedDown2Excel(-1);
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 조재성
     * @version 2009.07.21
     */
    function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:
                    if (crnt_rcc_cd.Code == '') {
    					ComShowCodeMessage('CGM10004','RCC');
    					ComSetFocus(crnt_rcc_cd);
    					return false;
    				}

                    if (crnt_lcc_cd.Code == '') {
    					ComShowCodeMessage('CGM10004','LCC');
    					ComSetFocus(crnt_lcc_cd);
    					return false;
    				}

                    if (crnt_scc_cd.Code == '') {
    					ComShowCodeMessage('CGM10004','SCC');
                        ComSetFocus(crnt_scc_cd);
    					return false;
    				}

    				if (disp_fm_dys.value == '') {
            			ComShowCodeMessage('CGM10004','Period ');
            			ComSetFocus(disp_fm_dys);
            			return false;
            		}

     		 		if (disp_to_dys.value == '') {
            			ComShowCodeMessage('CGM10004','Period ');
                        ComSetFocus(disp_to_dys);
           				return false;
           			}

     		 		//
     		 		// 날짜 범위 체크
     		 		//
     		 		// Querter
     		    	if (formObj.period_type.Code == "Q") {

     			  	}
     		 		// Months
     		    	else if (formObj.period_type.Code == "M")
     			  	{

     			  	}
     		 		// Weeks
     			  	else if (formObj.period_type.Code == "W")
     			  	{


     			  	}
     		 		// Days
     			  	else if (formObj.period_type.Code == "D")
     			  	{

     			  	}
 			  		var dt_str = ComReplaceStr(document.form.disp_fm_dys.value,"-","");
     		 		var dt_end = ComReplaceStr(document.form.disp_to_dys.value,"-","");

     	    		if (dt_str != '' && dt_end != '') {
     	    			if (dt_end < dt_str) {
     	    				ComShowCodeMessage('COM12133','To date','From date','greater');
     	    				disp_fm_dys.value='';
     	    				disp_to_dys.value='';
                            ComSetFocus(disp_fm_dys);
     	    				return false;
     	    			}
     	    		}

	    			break;
    		}
    	}
        return true;
    }


    /**
     * 콜백 함수. <br>
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function callBackYard(aryPopupData, row, col, sheetIdx) {
        var formObj = document.form;
        var crntYdCd = "";
        for (var i = 0; i < aryPopupData.length; i++) {
            crntYdCd = crntYdCd + aryPopupData[i][3];
            if (i < aryPopupData.length - 1) {
                crntYdCd = crntYdCd + ",";
            }
        }
        formObj.crnt_yd_cd.value = crntYdCd;
    }


    /**
     * Sheet1 의 OnChangeSum 이벤트처리 <br>
     * @param  {object} sheetObj	필수 Sheet Object
     * @param  {String} Row		필수 String
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
	function sheet1_OnChangeSum(sheetObj, Row )
	{
		with(sheetObj)
		{
			//SumText(0,"Seq") = "";
			//SumText(0,"location") = "Grand Total";
			//CellAlign(Row, "location") = daCenter;
		}
	}

    /**
     * Sheet1 의 OnSearchEnd 이벤트처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {string} ErrMsg		필수 String
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        ComSetFocus(document.crnt_rcc_cd); //조회후 focus는 location으로 가게 만든다.
	}

    /**
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */
    function obj_activate() {
        ComClearSeparator(event.srcElement);
    }

    /**
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function obj_deactivate() {
    	var formObj = document.form;
     	obj = event.srcElement;

     	if (obj.name=="disp_fm_dys"  ) {
     		with(formObj) {
     			var creDtFr = ComReplaceStr(disp_fm_dys.value,"-","");
        	}
  	        ComChkObjValid(event.srcElement);
        }
       	if (obj.name=="disp_to_dys"  ) {
       		with(formObj) {
       			var creDtFr = ComReplaceStr(disp_to_dys.value,"-","");
  	        }
  	        ComChkObjValid(event.srcElement);
        }
     }

    /**
      * Object 의 Keypress 이벤트에 대한 처리  <br>
      * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.24
      */
     function obj_keypress() {
       	obj = event.srcElement;
       	if (obj.dataformat == null) return;

       	window.defaultStatus = obj.dataformat;

       	switch(obj.dataformat) {
       	 	case "ym": case "ymd":
       	 		ComKeyOnlyNumber(obj);
       	 		break;
       	 	case "int":
       	 		if (obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
       	 		else ComKeyOnlyNumber(obj);
       	        break;
       	 	case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;
       	    case "eng":
      	    	if (obj.name=="vndr_seq")
      	    		ComKeyOnlyNumber(obj,",");
      	    	else
      	    		ComKeyOnlyAlphabet();
       	        break;
       	    case "engup":
      	        if (obj.name=="crnt_loc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
      	        else if (obj.name=="crnt_scc_cd") ComKeyOnlyAlphabet('upper',"44");//ComKeyOnlyAlphabet('uppernum',"44");
      	        else if (obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
       	        else ComKeyOnlyAlphabet('upper');
       	        break;
       	    case "engdn":
       	        if (obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
       	        else ComKeyOnlyAlphabet('lower');
       	        break;
       	}
     }


    /**
     * Combo Object 초기화  <br>
     * @param  {object} comboObj	필수 Combo Object
     * @return 없음
     * @author 조재성
     * @version 2009.08.13
     */
    function initCombo(comboObj) {
        with(comboObj) {
            switch(comboObj.id) {
                case "report_type":
                    Code = "";
                    Text = "";
                    DropHeight = 150;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseCode = true;
                    break;

                case "cnmv_sts_cd":
                    Code = "";
                    Text = "";
                    DropHeight = 300;
                    MultiSelect = true; //추후 멀티기능적용안하는걸로 함. 20090826. 현재는 멀티로 잘 동작함.
                    MaxSelect = 100;
                    UseCode = true;
                    break;

                case "period_type":
                    Code = "";
                    Text = "";
                    DropHeight = 100;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseCode = true;
                    break;

                case "crnt_rcc_cd":
                    Code = "";
                    Text = "";
                    DropHeight = 150;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseCode = true;
                    UseAutoComplete = true;
                    ValidChar(2,2);        // 영어 대문자, 특수(',')
                    IMEMode = 0;           // 영문
                    MaxLength = 5;         // 5자까지 입력
                    break;

                case "crnt_lcc_cd":
                    Code = "";
                    Text = "";
                    DropHeight = 200;
                    MultiSelect = true;
                    MaxSelect = 100;
                    UseCode = true;
                    ValidChar(2,2);         // 영어 대문자, 특수(',')
                    IMEMode = 0;            // 영문
                    MaxLength = 100;        // 100자까지 입력
                    break;

                //chungpa 20091016 scc_cd to multicombo
                case "crnt_scc_cd":
                    Code = "";
                    Text = "";
                    DropHeight = 300;
                    MultiSelect = true;
                    MaxSelect = 100;
                    UseCode = true;
                    ValidChar(2,2);         // 영어 대문자, 특수(',')
                    IMEMode = 0;            // 영문
                    MaxLength = 100;        // 100자까지 입력
                    break;
            }
        }
    }


    /**
     * Combo Object 에 값을 추가하는 처리 <br>
     * @param  {object} cmbObj	필수 Combo Object
     * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분)
     * @param  {int} 	txtCol	필수 Combo Text에 표시할 Colume Index 번호
     * @param  {int} 	codeCol	필수 Combo Code 값에 설정할 Column Index 번호
     * @param  {int} 	opt		필수 공백문자 추가여부 (0:추가안함, 1:추가)
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */
    function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
        cmbObj.RemoveAll();
        if (opt == 0) {
            for (var i = 0; i < arrStr.length;i++ ) {
                var arrCode = arrStr[i].split("|");
                cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
            }
        } else if (opt == 1) {
            cmbObj.InsertItem(0,"","");
            for (var i = 0; i < arrStr.length;i++ ) {
                var arrCode = arrStr[i].split("|");
                cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
            }
        }
        cmbObj.Index2 = "";
    }


    /**
     * float값을 유효숫자(2자리)만큼 잘라내는 함수
     * @param	{text}	sVal	필수		숫자 텍스트 데이터
     * @return	{float} rVal			변환된 float데이터
     */
    function returnFloat(sVal)
    {
    	var comp;
    	/* 바로 float값이 들어오기 때문에 텍스트 처리하지 않는다.
    	if (strAllTrim(sVal)=="")
    		comp=0;
    	else
    		comp=parseFloat(sVal);
		comp = parseInt(comp*100)/100;
    	*/
    	comp = parseInt(sVal*100)/100;
    	return comp;
    }

    /**
     * 기본조건 입력 후 ENTER키 적용 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.14
     */
    function enterFire() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        if (event.keyCode == 13) {
            if (validateForm(sheetObj, formObj, IBSEARCH)) {
                ComKeyEnter("search");
            }
        }
    }


    /**
     * report_type 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function report_type_OnChange() {
        var formObj = document.form;
        if (formObj.report_type.Text == "Container Status") {
            document.cnmv_sts_cd.Enable = true;
        } else {
            document.cnmv_sts_cd.Enable = false;
            document.cnmv_sts_cd.Text2 = "";
        }
        sheetObjects[0].removeAll(); //설계 요구사항. report_type을 바꿀때 grid를 초기화해준다.
    }


    /**
     * crnt_rcc_cd 의 OnChange 이벤트에 대한 처리
     */
    function crnt_rcc_cd_OnChange() {
        document.crnt_lcc_cd.RemoveAll(); // LCC를 Cear
        document.crnt_scc_cd.RemoveAll(); // SCC를 Cear
        if (document.crnt_rcc_cd.Text != "") {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC09); // LCC를 재구성해준다.
        }
    }


    /**
     * crnt_lcc_cd 의 OnBlur 이벤트에 대한 처리
     */
    function crnt_lcc_cd_OnBlur() {
        if (document.crnt_lcc_cd.Text.length > 4) {
            if (document.crnt_lcc_cd.Text != crntLccCd) {  // 공통함수인 crntLccCd와 비교
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10); // SCC를 재구성해준다.
                // 공통함수인 crntLccCd에 값 setting
                crntLccCd = document.crnt_lcc_cd.Text;
            }
        } else {
            document.crnt_scc_cd.RemoveAll(); // SCC를 Cear
        }
    }


    /**
     * period_type 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function period_type_OnChange() {
        var formObj = document.form;
        formObj.disp_fm_dys.value = "";
        formObj.disp_to_dys.value = "";
        if (formObj.period_type.Code == "Q") {
            formObj.disp_fm_dys.dataformat="ym";
            formObj.disp_to_dys.dataformat="ym";
            formObj.disp_fm_dys.maxlength="6";
            formObj.disp_to_dys.maxlength="6";
        } else if (formObj.period_type.Code == "M") {
            formObj.disp_fm_dys.dataformat="ym";
            formObj.disp_to_dys.dataformat="ym";
            formObj.disp_fm_dys.maxlength="6";
            formObj.disp_to_dys.maxlength="6";
        } else if (formObj.period_type.Code == "W") {
            formObj.disp_fm_dys.dataformat="";
            formObj.disp_to_dys.dataformat="";
            formObj.disp_fm_dys.maxlength="7";
            formObj.disp_to_dys.maxlength="7";
        } else if (formObj.period_type.Code == "D") {
            formObj.disp_fm_dys.dataformat="ymd";
            formObj.disp_to_dys.dataformat="ymd";
            formObj.disp_fm_dys.maxlength="8";
            formObj.disp_to_dys.maxlength="8";
        }
    }


	/**
	 * inq_fm_dys, inq_to_dys Quarter setting <br>
	 * @param  없음
	 * @return 없음
	 * @author 조재성
	 * @version 2009.08.24
	 */
	function inqFmDysEnd_Q_Cal() {
	    var formObj = document.form;
		var strFmDys = ComReplaceStr(formObj.disp_fm_dys.value,"-","");
		var strToDys = '';

		var qYear = strFmDys.substring(0,4);
		var qMonth = strFmDys.substring(4,6) - '00';

		if (qMonth > 0 && qMonth <=3) //1분기
		{
			formObj.disp_fm_dys.value = qYear+ "01";
			formObj.disp_to_dys.value = qYear+ "03";
		} else if (qMonth > 3 && qMonth <=6) // 2분기
		{
			formObj.disp_fm_dys.value = qYear+ "04";
			formObj.disp_to_dys.value = qYear+ "06";
		} else if (qMonth > 6 && qMonth <=9) // 3분기
		{
			formObj.disp_fm_dys.value = qYear+ "07";
			formObj.disp_to_dys.value = qYear+ "09";
		} else if (qMonth > 9 && qMonth <=12) // 4분기
		{
			formObj.disp_fm_dys.value = qYear+ "10";
			formObj.disp_to_dys.value = qYear+ "12";
		}

		ComSetFocus(formObj.disp_fm_dys);
		ComSetFocus(formObj.disp_to_dys);

		var toQMonth = formObj.disp_to_dys.value.substring(5,7)- '00';
		formObj.inq_fm_dys.value = formObj.disp_fm_dys.value+"01";
		formObj.inq_to_dys.value = formObj.disp_to_dys.value+""+LastDay(toQMonth,qYear);

	}
    /**
     * inq_fm_dys, inq_to_dys week setting <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.24
     */
    function inqFmDysEnd_W_Cal() {
    	var formObj = document.form;
    	//FM
     	formObj.eq_spec_no.value =  formObj.disp_fm_dys.value;
    	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC01);
    	formObj.disp_fm_dys.value = formObj.plnyr.value + "-" + formObj.plnwk.value;
    	//formObj.inq_fm_dys.value = formObj.wkstdt.value;//일자로 안주고
    	formObj.inq_fm_dys.value = formObj.disp_fm_dys.value;//실제 주데이터로 준다.

    	//TO
    	formObj.eq_spec_no.value = formObj.disp_to_dys.value;
    	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC01);
    	formObj.disp_to_dys.value = formObj.plnyr.value + "-" + formObj.plnwk.value;
    	//formObj.inq_to_dys.value = formObj.wkenddt.value; //일자로 안주고
    	formObj.inq_to_dys.value = formObj.disp_to_dys.value;//실제 주데이터로 준다.
     }

     /**
      * 해당 달의 last day얻기  <br>
      * @param  month,year
      * @return date
      * @author 조재성
      * @version 2009.08.25
      */
     function LastDay(month,year) {
    	 var ds = String(month+1)+'/0/'+String(year);
    	 var dd = new Date(ds);
    	 return dd.getDate();
     }

	/**
	 * inq_fm_dys Month setting <br>
	 * @param  없음
	 * @return 없음
	 * @author 조재성
	 * @version 2009.08.25
	 */
 	function inqFmDysEnd_M_Cal() {
 	    var formObj = document.form;
 		var strFmDys = formObj.disp_fm_dys.value;
 		//if (strFmDys.length != 7)
 		//	return;
 		formObj.inq_fm_dys.value = strFmDys+"-01";
 	}

 	/**
 	 * inq_to_dys Month setting <br>
 	 * @param  없음
 	 * @return 없음
 	 * @author 조재성
 	 * @version 2009.08.25
 	 */
  	function inqToDysEnd_M_Cal() {
  	    var formObj = document.form;
  		var strToDys = formObj.disp_to_dys.value;
  		//if (strToDys.length != 7)
  		//	return;
		var qYear = strToDys.substring(0,4);
		var qMonth = strToDys.substring(5,7) - '00';
		formObj.inq_to_dys.value = strToDys+"-"+LastDay(qMonth,qYear);

  	}

  	/**
  	 * disp_fm_dys_blur <br>
  	 * @param  없음
  	 * @return 없음
  	 * @author 조재성
  	 * @version 2009.08.25
  	 */
   	function disp_fm_dys_blur() {
    	var formObj = document.form;

    	if (formObj.period_type.Code == "Q")
    	{
    		var baseDys = ComReplaceStr(formObj.disp_fm_dys.value,"-","");
    		if (baseDys.length != 6)
    			return;

    		if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 1)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-01";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-03";
    		} else if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 2)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-04";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-06";
    		} else if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 3)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-07";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-09";
    		} else if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 4)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-10";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-12";
    		}
	  	} else if (formObj.period_type.Code == "M")
	  	{

	  	} else if (formObj.period_type.Code == "W")
	  	{
	 		var dt_str = ComReplaceStr(document.form.disp_fm_dys.value,"-","");
	    	if (dt_str.length != 6 && dt_str != "")
	    	{
	 			ComShowCodeMessage('CGM10009','Period ');
	 			if (formObj.disp_fm_dys.value != "")
	 			{
	 				ComSetFocus(formObj.disp_fm_dys);
	 				formObj.disp_fm_dys.value = "";
	 				return;
	 			}
	    	} else if (dt_str.length == 6) //정상이면
	    	{
	    		if (parseInt(dt_str.substring(4,6)) >0 && parseInt(dt_str.substring(4,6))<=53)
	    		{
	    			formObj.disp_fm_dys.value = dt_str.substring(0,4)+"-"+ dt_str.substring(4,6);
	    		} else
	    		{
		 			ComShowCodeMessage('CGM10009','Period ');
	 				ComSetFocus(formObj.disp_fm_dys);
	 				formObj.disp_fm_dys.value = "";
	 				return;
	    		}
	    	}

	    	//FM
	     	formObj.eq_spec_no.value =  formObj.disp_fm_dys.value;
	    	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC02); // YYYY-WW로 검색
	    	//formObj.inq_fm_dys.value = formObj.wkstdt.value;
	    	formObj.inq_fm_dys.value = formObj.disp_fm_dys.value;
	    	//alert(formObj.inq_fm_dys.value);
	  	} else if (formObj.period_type.Code == "D")
	  	{

	  	}
   	}

   	/**
   	 * disp_to_dys_blur setting <br>
   	 * @param  없음
   	 * @return 없음
   	 * @author 조재성
   	 * @version 2009.08.25
   	 */
	function disp_to_dys_blur() {
	 	var formObj = document.form;

	 	if (formObj.period_type.Code == "Q")
	 	{
	 		var baseDys = ComReplaceStr(formObj.disp_to_dys.value,"-","");
    		if (baseDys.length != 6)
    			return;

    		if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 1)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-01";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-03";
    		} else if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 2)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-04";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-06";
    		} else if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 3)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-07";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-09";
    		} else if (Math.ceil( (baseDys.substring(4,6)- '00') / 3 ) == 4)
    		{
    			formObj.disp_fm_dys.value = baseDys.substring(0,4) + "-10";
    			formObj.disp_to_dys.value = baseDys.substring(0,4) + "-12";
    		}
	  	} else if (formObj.period_type.Code == "M") {

	  	} else if (formObj.period_type.Code == "W") {
 			var dt_end = ComReplaceStr(document.form.disp_to_dys.value,"-","");

	    	if (dt_end.length != 6 && dt_end != "") {
	 			ComShowCodeMessage('CGM10009','Period ');
	 			if (formObj.disp_to_dys.value != "")
	 			{
                    ComSetFocus(formObj.disp_to_dys);
	 				formObj.disp_to_dys.value = "";
	 				return;
	 			}
	    	} else if (dt_end.length == 6) //정상이면
	    	{
	    		if (parseInt(dt_end.substring(4,6)) >0 && parseInt(dt_end.substring(4,6))<=53)
	    		{
	    			formObj.disp_to_dys.value = dt_end.substring(0,4)+"-"+ dt_end.substring(4,6);
	    		} else
	    		{
		 			ComShowCodeMessage('CGM10009','Period ');
                    ComSetFocus(formObj.disp_to_dys);
	 				formObj.disp_to_dys.value = "";
	 				return;
	    		}
	    	}

	    	//TO
	    	formObj.eq_spec_no.value = formObj.disp_to_dys.value;
	    	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_ASYNC02);
	    	//formObj.inq_to_dys.value = formObj.wkenddt.value;
	    	formObj.inq_to_dys.value = formObj.disp_to_dys.value;
	    	//alert(formObj.inq_to_dys.value);
	  	} else if (formObj.period_type.Code == "D")
	  	{

	  	}
	}

   	/**
   	 * disp_fm_dys_focusin <br>
   	 * @param  없음
   	 * @return 없음
   	 * @author 조재성
   	 * @version 2009.08.25
   	 */
	function disp_fm_dys_focusin() {
	 	var formObj = document.form;

	 	if (formObj.period_type.Code == "Q") {

	  	} else if (formObj.period_type.Code == "M") {

	  	} else if (formObj.period_type.Code == "W") {
	  		document.form.disp_fm_dys.value = ComReplaceStr(document.form.disp_fm_dys.value,"-","");
	  	} else if (formObj.period_type.Code == "D") {

	  	}
	}

   	/**
  	 * disp_to_dys_focusin <br>
  	 * @param  없음
  	 * @return 없음
  	 * @author 조재성
  	 * @version 2009.08.25
  	 */
	function disp_to_dys_focusin() {
	 	var formObj = document.form;

	 	if (formObj.period_type.Code == "Q")
	 	{

	  	} else if (formObj.period_type.Code == "M")
	  	{

	  	} else if (formObj.period_type.Code == "W")
	  	{
	  		document.form.disp_to_dys.value = ComReplaceStr(document.form.disp_to_dys.value,"-","");
	  	} else if (formObj.period_type.Code == "D")
	  	{

	  	}
	}


    /**
     * 유효값체크 로직(자리수에 맞춰서)
     * @author 조재성 2009.09.30
     */
    function obj_keyup() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        obj = event.srcElement;

        switch(obj.name) {

            case "crnt_yd_cd":
                var crntYdCd = ComTrimAll(formObj.crnt_yd_cd.value);
                if ( formObj.crnt_yd_cd.value.search(',') > 0 || (formObj.crnt_yd_cd.value == '')) { // 다중 yard code(,로 연결됨)이면 검사하지 않는다.
                    break;
                }
                var arrCrntYdCd = crntYdCd.split(",");
                for (var i = 0; i < arrCrntYdCd.length; i++) {
                    // 입력오류 체크 (예> ,,)
                    if (arrCrntYdCd[i] == '') {
                        ComShowCodeMessage('CGM10009','Yard');
                        formObj.crnt_yd_cd.value = "";
                        ComSetFocus(formObj.crnt_yd_cd);
                        break;
                    }
                }

                //if (arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value != '') {
                if (arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7) {
                    //chungpa 20091015 MULTI일경우 YD check안함
                    //doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
                }
                break;
        }
    }


/* 개발자 작업  끝 */