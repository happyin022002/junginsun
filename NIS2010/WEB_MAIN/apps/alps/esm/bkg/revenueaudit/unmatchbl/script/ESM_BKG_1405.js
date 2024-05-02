/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : esm_bkg_1405.js
*@FileTitle : Stop Off BKG List for Audit
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 2015.02.05 
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
     * @class esm_bkg_1405 : esm_bkg_1405 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_1405() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

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

                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;

                case "btn_new":

                	sheetObject.RemoveAll();
                	
                	formObject.fm_dt.value = ComGetNowInfo("ymd", "");  //현재일자를 설정
                    formObject.to_dt.value = ComGetNowInfo("ymd", "");  //현재일자를 설정
                    
                    ComSetFocus(document.form.fm_dt);
                break;

                case "btns_calendar2":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.elements["fm_dt"], formObject.elements["to_dt"],'yyyy-MM-dd');

                break;
                
                case "btn_downexcel":
                    if(sheetObject.rowcount < 1){//결과가 없을경우
                        ComShowCodeMessage("BKG00109");
                    }else{
                    	sheetObject.Down2Excel(true);
                    }
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
                initSheet(sheetObjects[i],sheetObjects[i].id);
                ComEndConfigSheet(sheetObjects[i]);
            }

            initControl();
            
//            form.fm_dt.value="2014-02-24";
//            form.to_dt.value="2014-02-25";
//            
//            btn_Retrieve.fireEvent('onclick');
        }

        /**
         * 화면의 Control의 초기값과 이벤트를 설정한다.
         */
        function initControl() {

			initText();
			axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
            axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
            axon_event.addListenerForm  ('beforeactivate',   'obj_activate',    form);
            axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- 키보드 입력할때
        }

        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var sheetID = sheetObj.id;

            var cnt = 0;

            switch(sheetID) {

                //----------------------------------------
                // Customer
                //----------------------------------------
                case "sheet1":      
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 420;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        //MergeSheet = msHeaderOnly;
                        
                      //전체Merge 종류 [선택, Default msNone] 
//                        MergeSheet = msHeaderOnly;
                        MergeSheet = msPrevColumnMerge + msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        

                        var HeadTitle1 = "BKG No.|SHPR|Contract No.| Scope| POR| POL| POD| DEL| CMDT| Stop Off| Stop Off Cargo \nOrder Remark| Internal Remark| External Remark| Internal Charge Remark| External Charge Remark| | Charge Info| Charge Info| Charge Info| Charge Info| Rate| Amount| SHPR_CD| BKG_CTRT_TP_CD";
                        var HeadTitle2 = "BKG No.|SHPR|Contract No.| Scope| POR| POL| POD| DEL| CMDT| Stop Off| Stop Off Cargo \nOrder Remark| Internal Remark| External Remark| Internal Charge Remark| External Charge Remark| | Charge Code \n(MIS/MSC)| Currency| Per| Rated As| Rate| Amount| SHPR_CD| BKG_CTRT_TP_CD";


                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 3, 100);
                        
                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, true, true, false,false);
                        
                        var headCount = ComCountHeadTitle(HeadTitle1);
                		//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                		InitColumnInfo(headCount, 0, 0, true);
                        

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        var Status = 0;
                        var prefix = "";

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                                                                                                                                                
                        InitDataProperty(0, cnt++ , dtPopup,    120,   daCenter,  true,    "bkg_no" ,           false,   "",          dfNone,    0,          false,        false);
                        InitDataProperty(0, cnt++ , dtData ,    100,   daLeft,    true,    "shpr_nm" ,          false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtPopup,    90,    daCenter,  true,    "ctrt_no" ,          false,   "",          dfNone,    0,          false,        false);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,  true,    "svc_scp_cd" ,       false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,  true,    "por_cd" ,           false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,  true,    "pol_cd" ,           false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,  true,    "pod_cd" ,           false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,  true,    "del_cd" ,           false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    150,   daLeft,    true,    "cmdt_nm" ,          false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,  true,    "stop_off_loc_cd" ,  false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    160,   daLeft,    true,    "stop_off_diff_rmk" ,false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    160,   daLeft,    true,    "inter_rmk" ,        false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    160,   daLeft,    true,    "xter_rmk" ,         false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    160,   daLeft,    true,    "rt_inter_rmk" ,     false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    160,   daLeft,    true,    "diff_rmk" ,         false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtHiddenStatus,0,  daCenter,  false,   "ibflag");//이하 머지 안됨.
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,  true,    "chg_cd" ,           false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,  true,    "curr_cd" ,          false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,  true,    "rat_ut_cd" ,        false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,  true,    "rat_as_qty" ,       false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,  true,    "chg_ut_amt" ,       false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,  true,    "chg_amt" ,          false,   "",          dfNone,    0,          false,       false);
                        
                        InitDataProperty(0, cnt++ , dtHidden ,  40,    daCenter,    true,    "shpr_cd" ,          false,   "",          dfNone,    0,          false,       false);
                        InitDataProperty(0, cnt++ , dtHidden ,  40,    daCenter,    true,    "bkg_ctrt_tp_cd" ,   false,   "",          dfNone,    0,          false,       false);

                        ShowButtonImage = 2;
                        Ellipsis = true;
                        WordWrap = false;

                        //CountPosition = 0;
                        AutoRowHeight = false;

                        WaitImageVisible = false;
                        DataAutoTrim = false;

                    }// end with 
                    break;
            }//switch
        }

        /**
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            switch(sAction) {

                case IBSEARCH:      //조회
                    if(!validateForm(sheetObj,formObj,sAction)) return false;

                    formObj.f_cmd.value = SEARCH;
                    ComOpenWait(true);
                    
                    sheetObj.RemoveAll();
                    sheetObj.DoSearch("ESM_BKG_1405GS.do",FormQueryString(formObj));
                    
                    ComOpenWait(false);
                break;
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            switch(sAction) {
            case IBSEARCH:

            		if(ComIsEmpty(formObj.fm_dt.value) && ComIsEmpty(formObj.to_dt.value)){
	                    ComShowCodeMessage('BKG00554');
	                    formObj.fm_dt.focus();
	                    return false;
	                }

	                var v_sdate = formObj.fm_dt.value;//시작일
	                var v_edate = formObj.to_dt.value;//종료일

	                if(!ComIsDate(v_sdate, 'yyyy-MM-dd') || !ComIsDate(v_edate, 'yyyy-MM-dd')){
	                    ComShowCodeMessage("BKG00421");
	                    formObj.fm_dt.focus();
	                    return false;
	                }

	                if(ComGetDaysBetween(v_edate, v_sdate) > 0){
	                    ComShowCodeMessage("BKG00421");
	                    formObj.fm_dt.focus();
	                    return false;
	                }

	                // 조회기간 범위 체크 31일 : 1일 부터 31일까지 기간이 30일 체크
	                if(ComGetDaysBetween(v_sdate,v_edate) > 30){
	                    ComShowCodeMessage("BKG00555","31 Days");
	                    formObj.fm_dt.focus();
	                    return false;
	                }
            
                break;
            }

            return true;
        }

        /**
         * 업무 자바스크립트 OnFocus 이벤트 처리
         */
        function obj_activate() {
            var objName = event.srcElement.name;
            var formObj = document.form;

            switch(objName) {

                case "fm_dt":
                    formObj.fm_dt.value = formObj.fm_dt.value.replace(eval("/-/gi"), "");
                    break;
                case "to_dt":
                    formObj.to_dt.value = formObj.to_dt.value.replace(eval("/-/gi"), "");
                    break;
            }

        }

        /**
         * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.
         * @return
         */
       function obj_deactivate(){
           var objName = event.srcElement.name;
           var formObj = document.form;
           switch(objName) {
               case "fm_dt":
                   ComChkObjValid(event.srcElement);
                   break;
               case "to_dt":
                   ComChkObjValid(event.srcElement);
                   break;
           }
       }


        /**
         * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
         **/
        function obj_keypress(){
            switch(event.srcElement.dataformat){
            	case "ymd":
                case "float":
                    //숫자+"."입력하기
                    ComKeyOnlyNumber(event.srcElement, ".");
                    break;
                case "eng":
                    //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
                    //ComKeyOnlyAlphabet();
                    ComKeyOnlyAlphabet('uppernum');
                    break;
                case "engdn":
                    //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
                    ComKeyOnlyAlphabet('lower');
                    break;
                case "engup":
                    //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                    ComKeyOnlyAlphabet('upper');
                    break;
                default:
                    //숫자만입력하기(정수,날짜,시간)
                    ComKeyOnlyNumber(event.srcElement);
            }
        }

        /**
         * 입력 필드값 초기화 처리
         **/
        function initText() {
            var formObject = document.form;
                formObject.fm_dt.value = ComGetNowInfo("ymd", "");  //현재일자를 설정
                formObject.to_dt.value = ComGetNowInfo("ymd", "");  //현재일자를 설정
        }


        
        /** 
         * sheet1 팝업연결 선택시 발생하는 sheet1_OnClick 이벤트핸들러 <br>
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param  {IBSheet} sheetObj : 시트오브젝트  
         * @param  {Long} Row : 해당 셀의 Row Index
         * @param  {Long} Col : 해당 셀의 Column Index
         * @return  
         */
       function sheet1_OnClick(sheetObj, Row, Col) {
       	 	var form = document.form;
       	 	var colName    = sheetObj.ColSaveName(Col);
       		var sName      = sheetObj.ColSaveName(Col);
       		
       		var bkgNo 	   = sheetObj.CellValue(Row, "bkg_no");    			
       		var scRfaNo    = sheetObj.CellValue(Row, "ctrt_no");	
       		var ctrtTpCd   = sheetObj.CellValue(Row, "bkg_ctrt_tp_cd");
       		
       	 	switch(colName){
       	 		case "bkg_no":
       		    	if(null == bkgNo || "" == bkgNo) { return; }
       		    	var popParams = "bkg_no=" + bkgNo;// "&openTab=B8";
       		    	comRASCallPop("ESM_BKG_0079", "ESM_BKG_1401", popParams, "");
       				break;
       	 	
       			case "ctrt_no":
       	        	if(null == scRfaNo || "" == scRfaNo) { return; }
       	    		var pgmNo = "ESM_PRI_0004";//S : S/C
       	    		var scRfaNoP = scRfaNo.substr(0, 3);
       	    		var scRfaNoS = scRfaNo.substr(3);
       	        	var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.fm_dt.value + "&exp_dt=" + form.to_dt.value;
       		    	if(ctrtTpCd == "R") { // RFA
       		    		pgmNo = "ESM_PRI_2019";
       		    		popParams = "s_rfa_no=" + scRfaNo;
       		    	}
       		    	else if(ctrtTpCd == "T") { // TAA
       		    		pgmNo = "ESM_PRI_3007";
       		    		popParams = "cond_taa_no=" + scRfaNo;  
       		    	}
       	        	comRASCallPop(pgmNo, "ESM_BKG_1401", popParams, "");
       				break;
       				
       		 }
       }        
    /* 개발자 작업  끝 */