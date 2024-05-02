/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0105.js
*@FileTitle : dailyforecastinquiry
*Open Issues :
*Change history :
*2008-12-26 임옥영 CSR:N200812230019 BKG의 TEU->Total TEU로 변경
*2010-07-07 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171  53ft 추가
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.03 한상훈
* 1.0 Creation
* 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청 
			 -RHQ가 현재 필수항목으로 SHARC/SINRS/HAMRU/NYCRA로 되어있으나, ALL을 추가.
			 -RHQ : ALL 선택 시 T/S Conti는 필수항목. 
			 -T/S Lane과 T/S Port 사이에  T/S VVD 및  T/S ETB DATE(T/S VVD의 T/S Port의 ETB_DT) 추가
			 -Grid 상단의 Check Box에 T/S VVD 체크박스 추가 : 해당 체크박스 체크시 T/S VVD 및 ETB Date 보여줌
* 2011.05.06 최성민 [CHM-201110577-01] Pre/Post T/S ETB Date 항목 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 - 유저 요청에 따라 기존 105번 화면 (T/S Booking Status)는 133번으로 copy하여 복원
* 2014.12.22 박은주 [CHM-201433402] TS BKG status(new) 기능 추가 요청 (conti 로만 조회 하도록 쿼리 변경)
* 2015.01.28 김성욱 [CHM-201533975] T/S BKG status(new) View 보완 요청 Sort 변경
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
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
     * @class ESM_SPC_105 : ESM_SPC_105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0105() {
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
    var sheetObjects = new Array();
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    var init_week = '';
    var init_duration = '';
    var init_ofcCd = '';
    
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

            	    case "btn_retrieve":
       	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	            break;
        	            
    				case "btn_new":
    					if(checkModifiedSheet(sheetObject)) {
    						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    							return;
    						}
    					}
    	            	//공통함수사용: 화면을 초기화
    					resetAll();
    					document.getElementsByName("chkDsTSPort")[0].checked = true;
            	    	document.getElementsByName("chkDsPort")[0].checked = true;
            	    	document.getElementsByName("chkDsDel")[0].checked = true;
            	    	document.getElementsByName("chkDsOffice")[0].checked = true;
            	    	document.getElementsByName("chkDsLane")[0].checked = true;
            	    	document.getElementsByName("chkDsPVvd")[0].checked = false;
            	    	document.getElementsByName("chkDsPsVvd")[0].checked = false;
    					
    					sheetObject.ColHidden("ts_port") = false;
    					sheetObject.ColHidden("vvd") = false;
    					
    					sheetObject.ColHidden("pre_etb_dt") = true;
    					sheetObject.ColHidden("post_etb_dt") = true;

    					formObject.year.value = init_year;
    					formObject.week.value = init_week;
    					formObject.duration.value = init_duration;
    					formObject.rhq_cd.value = rhq_cd;
    					document.getElementById("ofc_cd").Code2 = init_ofcCd;
    					
    					SpcSearchOptionWeek("week",false,document.form.year.value);   
    					SpcSearchOptionSvcLane("slane");
    					break;
    					
            	    case "btn_downexcel":
       	            	doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
            	        break;

    			} // end switch
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
         * new 버튼 클릭시 resetAll() 에서 호출함.
         * ts_conti 초기화
         */
        function initDataValue_ts_conti(){
            var sheetObj = document.getElementById("ts_conti");
            with(sheetObj){
                Index2 = 0;
            }        	
        }

    	/**
    	 * new 버튼 클릭시 resetAll() 에서 호출함.
    	 */
    	function initDataValue_ofc_cd(){
    	    var sheetObj = document.getElementById("ofc_cd");
    	    with(sheetObj){
    	        Index2 = 0;
    	    }
    	}
    	
    	/**
    	 * new 버튼 클릭시 resetAll() 에서 호출함.
    	 */
        function initDataValue_lane(){
        	var sheetObj = document.getElementById("lane");
        	with(sheetObj){
        		Index2 = 0;
        	}
        }
        
        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
    		comObjects[comboCnt++] = combo_obj;
        }
        
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {

        	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
        	document.getElementById("lane").Enable = false;
        	document.getElementById("ts_conti").Enable = false;
        	
        	SpcSearchOptionYear("year");
         	SpcSearchOptionWeek("week");
         	SpcSearchOptionDuration("duration", 8, 3);
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            var sheetResizeFull = true;
    		document_onresize();

    		var formObject = document.form;
    		formObject.rhq_cd.value = rhq_cd;
    		rhq_cd_OnChange(formObject.rhq_cd.value);

    		SpcSearchOptionSvcLane("lane", true, true);
    		SpcSearchOptionContiCd("ts_conti", true, true);	   //T/S Conti 코드 조회

    	    var comObj = document.getElementById("ofc_cd");
    		formObject.year.focus();

        	init_year = formObject.year.value; // 년 초기화용
        	init_week = formObject.week.value; // 주차 초기화용
        	init_duration = formObject.duration.value; // duration 초기화용
        	init_ofcCd = document.getElementById("ofc_cd").Code;
        	
        	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
        	document.getElementById("lane").Enable = true;
        	document.getElementById("ts_conti").Enable = true;
        }

       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
        	
        	var formObj = document.form;
    		var search_Type = formObj.type.value;
    		
    		with (sheetObj) {
    			// 높이 설정
    			style.height = getSheetHeight(20) ;
    			//전체 너비 설정
    			SheetWidth = mainTable.clientWidth;
    			//Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    			
    			//전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msPrevColumnMerge + msHeaderOnly;
    			
    			//전체Edit 허용 여부 [선택, Default false]
    			Editable = false;
    			
    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo( 3, 1, 10, 100);
    			
    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			var HeadTitle0 = "";
    			var HeadTitle1 = "";
    			var HeadTitle2 = "";

    			if( search_Type == "T" || search_Type == "" ) {
    				HeadTitle0 = "WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK";
    				HeadTitle1 = " | | | | | | | | | | | | | | |";
    				HeadTitle2 = "WEEK|Pre Lane|Pre VVD|Pre VVD ETB|Post Lane|Post VVD|Post VVD ETB|T/S Port|POL|POD|DEL|L/Office|Trunk Lane|Trunk VVD|LVL" ;
    			} else if( search_Type == "D" ) {
    				HeadTitle0 = "WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK|WeeK";
    				HeadTitle1 = " | | | | | | | | | | | | | | | | | | | | | | |";
    				HeadTitle2 = "WEEK|Pre Lane1|Pre VVD1|Pre VVD1 ETB|T/S Port1|T.Lane|T.VVD|T.VVD ETB|T.Pod|Post Lane1|Post VVD1|T/S Port2|Post Lane2|Post VVD2|T/S Port3|Post Lane3|Post VVD3|POL|POD|DEL|DEL ETB|L/Office|LVL" ;
    			}
    			HeadTitle0 = HeadTitle0 + "| WeeK| WeeK|TYPE/SIZE|TYPE/SIZE|TYPE/SIZE|TYPE/SIZE|TYPE/SIZE|TYPE/SIZE|TYPE/SIZE|TYPE/SIZE";
    			HeadTitle1 = HeadTitle1 + "| |Dry|Dry|Dry|Dry|RF|RF|DG|AK";
    			HeadTitle2 = HeadTitle2 + "|BKG Vol(TEU)|BKG Weight|D2|D4|HC|D7|R2|R5|DG|AK";

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(ComCountHeadTitle(HeadTitle0)+1, 0, 0, false);
    			InitHeadMode(true, true, false, true, false, false) ;
    			
    			InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				InitHeadRow(2, HeadTitle2, true);    	
				
    			var cnt = 0;
    			
    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "yrwk",     		false,          "",       dfNone,       0,     false,       false);

    			if( search_Type == "T" || search_Type == "" ) {
    			///////////////////////////////
    				
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "pre_slan",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "pre_vvd",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "pre_etb_dt",     false,          "",       dfNone,       0,     false,       false);  //ts_etb_dt ==> pre_etb_dt  
	    			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "post_slan",     false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "post_vvd",     	false,          "",       dfDateYmd,    0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "post_etb_dt",    false,          "",       dfNone,       0,     false,       false); //ts2_etb_dt ==> post_etb_dt 
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "ts_port",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "pol_cd",     	false,          "",       dfDateYmd,    0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "pod_cd",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "del_cd",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "sls_ofc_cd",    false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    75,    daCenterTop,   true,    "tslan_cd",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    75,    daCenterTop,   true,    "vvd",     		false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden , 10,    dtHidden,   	 true,    "lvl",     		false,          "",       dfNone,       0,     false,       false);
    			} else if( search_Type == "D" ) {
    			///////////////////////////
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "pre_lane1",     false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "pre_vvd1",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "pre_vvd1_etb",  false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "pre_port1",     false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "t_lane",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "t_vvd",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,   true,    "t_vvd_etb",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "t_pod",     false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_lane2",    false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_vvd2",     false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_port2",    false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_lane3",    false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_vvd3",     false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_port3",    false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_lane4",    false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden ,    70,    daCenterTop,   true,    "post_vvd4",     false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "pol_cd",     	false,          "",       dfDateYmd,    0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "pod_cd",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "del_cd",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "del_etb",     	false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "sls_ofc_cd",    false,          "",       dfNone,       0,     false,       false);
	    			InitDataProperty(0, cnt++ , dtHidden , 10,    dtHidden,   	 true,    "lvl",     		false,          "",       dfNone,       0,     false,       false);
    			}
    			//----------------------------------
    			
    			InitDataProperty(0, cnt++ , dtData ,    80,    daRight,   false,    "bkg_ttl_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    80,    daRight,   false,    "bkg_ttl_wgt",     	false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_20ft_qty",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_40ft_qty",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_40ft_hc_qty",  false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_45ft_hc_qty",  false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_rf20_qty",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_rf40_qty",     false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_dg_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
    			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   false,    "bkg_ak_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
    			
    			HeadRowHeight  = 10;
    			var backColor = RgbColor(222, 251, 248);
    		}
        }
        
        /**
         * Prev./Post VVD 클릭시 SHEET 항목 hidden 처리하는 function
         * <br><b>Example :</b>
         * <pre>
         *
         * </pre>
         * @return 없음
         * @author 최성민
         * @version 2011.05.16
         */
        function showPrePostDataCol() {        	
        	if ( document.getElementsByName("chkDsPVvd")[0].checked ) {
        		sheetObjects[0].ColHidden("pre_vvd") = false;
        		sheetObjects[0].ColHidden("pre_etb_dt") = false;
        	} else {
        		sheetObjects[0].ColHidden("pre_vvd") = true;
        		sheetObjects[0].ColHidden("pre_etb_dt") = true;
        	}
        	
        	if ( document.getElementsByName("chkDsPsVvd")[0].checked ) {
        		sheetObjects[0].ColHidden("post_vvd") = false;
        		sheetObjects[0].ColHidden("post_etb_dt") = false;
        	} else {
        		sheetObjects[0].ColHidden("post_vvd") = true;
        		sheetObjects[0].ColHidden("post_etb_dt") = true;
        	}
        	
        	if ( document.getElementsByName("chkDsDPsVvd")[0].checked ) {
        		sheetObjects[0].ColHidden("post_lane2") = false;
        		sheetObjects[0].ColHidden("post_vvd2") = false;
        		sheetObjects[0].ColHidden("post_port2") = false;
        		sheetObjects[0].ColHidden("post_lane3") = false;
        		sheetObjects[0].ColHidden("post_vvd3") = false;
        		sheetObjects[0].ColHidden("post_port3") = false;
        		sheetObjects[0].ColHidden("post_lane4") = false;
        		sheetObjects[0].ColHidden("post_vvd4") = false;
        	} else {
        		sheetObjects[0].ColHidden("post_lane2") = true;
        		sheetObjects[0].ColHidden("post_vvd2") = true;
        		sheetObjects[0].ColHidden("post_port2") = true;
        		sheetObjects[0].ColHidden("post_lane3") = true;
        		sheetObjects[0].ColHidden("post_vvd3") = true;
        		sheetObjects[0].ColHidden("post_port3") = true;
        		sheetObjects[0].ColHidden("post_lane4") = true;
        		sheetObjects[0].ColHidden("post_vvd4") = true;
        	}
        }

       	/**
       	 * 선택한 Cell의 값을 val 으로 변경
       	 */
    	function ChangeValue2(sheetObj, row, col, val){
    		with(sheetObj){
    			CellValue2(row, col) = val;
    		}
    	}

     	/**
     	 * 체크박스 클릭시 SHEET 컬럼 HIDDEN 설정하는 Function <br>
     	 * - Pre/Post T/S ETB Date 항목 추가로 CHECKBOX value 값 수정함.
     	 * <br><b>Example :</b>
     	 * <pre>
     	 * changeDataSelection();
     	 * </pre>
     	 * @return 없음
     	 * @author 최성민
     	 * @version 2011.05.06
     	 */
    	function changeDataSelection(){
    		var sheetObj = sheetObjects[0];
    		var obj = null;
    		obj = event.srcElement;
    		var sts = obj.checked;
    		var lvl = obj.value * 1;
    		
    		sheetObj.ColHidden("ts_port") = !document.getElementsByName("chkDsTSPort")[0].checked;
    		sheetObj.ColHidden("pol_cd") = !document.getElementsByName("chkDsPort")[0].checked;
    		sheetObj.ColHidden("pod_cd") = !document.getElementsByName("chkDsPort")[0].checked;
    		sheetObj.ColHidden("del_cd") = !document.getElementsByName("chkDsDel")[0].checked;
    		sheetObj.ColHidden("sls_ofc_cd") = !document.getElementsByName("chkDsOffice")[0].checked;
    		sheetObj.ColHidden("vvd") = !document.getElementsByName("chkDsLane")[0].checked;
    		sheetObj.ColHidden("tslan_cd") = !document.getElementsByName("chkDsLane")[0].checked;
    		
    		return true;
    	}

    	/**
    	 * IBSheet Sort방법 변경.
    	 *
    	 */
    	function changeSortSelection() {
    		var sheetObj = sheetObjects[0];
    		var obj = null;
    		obj = event.srcElement;
    		var sortType = "";

    		var formObj = document.form;
    		var search_Type = formObj.type.value;

    		if( obj.name == "chkPreLane" ) {
    			document.getElementById("chkPostLane").checked = false;
    			preLaneSort( search_Type );
    		} else { //chkPostLane
    			document.getElementById("chkPreLane").checked = false;
    			postLaneSort( search_Type );
    		}
    	}
    	
    	/**
    	 * Default List View, By Post Lane Radio 버튼 선택시
    	 */
    	function postLaneSort( sType ) {
    		var sheetObj = sheetObjects[0];

    		if( sType == "T" ) {
    			sheetObj.MoveColumnPos( "post_slan", 1 );
    			sheetObj.MoveColumnPos( "post_vvd", 2 );
    			sheetObj.MoveColumnPos( "post_etb_dt", 3);
    			sheetObj.MoveColumnPos( "ts_port", 4 );
    			sheetObj.MoveColumnPos( "tslan_cd", 5 );
    			sheetObj.MoveColumnPos( "vvd", 6 );
    			sheetObj.MoveColumnPos( "sls_ofc_cd", 7 );
	    		sheetObj.MoveColumnPos( "pol_cd", 8 );
	    		sheetObj.MoveColumnPos( "pod_cd", 9 );
	    		sheetObj.MoveColumnPos( "del_cd", 10 );
	    		sheetObj.MoveColumnPos( "pre_slan", 11 );
	    		sheetObj.MoveColumnPos( "pre_vvd", 12 );
	    		sheetObj.MoveColumnPos( "pre_etb_dt", 13 );
	    		
	    		sheetObj.ColumnSort( "post_slan|post_vvd|post_etb_dt" , "ASC" );
	    		
    		} else if( sType == "D" ) {
    			sheetObj.MoveColumnPos( "post_lane2", 1 );
    			sheetObj.MoveColumnPos( "post_vvd2", 2 );
    			sheetObj.MoveColumnPos( "post_port2", 3 );
    			
    			sheetObj.MoveColumnPos( "post_lane3", 4 );
    			sheetObj.MoveColumnPos( "post_vvd3", 5 );
    			sheetObj.MoveColumnPos( "post_port3", 6 );
    			
    			sheetObj.MoveColumnPos( "post_lane4", 7 );
    			sheetObj.MoveColumnPos( "post_vvd4", 8 );
    			sheetObj.MoveColumnPos( "t_lane", 9 );
    			sheetObj.MoveColumnPos( "t_vvd", 10 );
    			sheetObj.MoveColumnPos( "t_vvd_etb", 11 );
    			
    			sheetObj.MoveColumnPos( "pre_port1", 12 );
    			sheetObj.MoveColumnPos( "t_pod", 13 );
    			sheetObj.MoveColumnPos( "sls_ofc_cd", 14 );
    			
    			sheetObj.MoveColumnPos( "pol_cd", 15 );
    			sheetObj.MoveColumnPos( "pod_cd", 16 );
    			sheetObj.MoveColumnPos( "del_cd", 17 );
    			sheetObj.MoveColumnPos( "del_etb", 18 );
    			sheetObj.MoveColumnPos( "pre_lane1", 19 );
    			sheetObj.MoveColumnPos( "pre_vvd1", 20 );
    			sheetObj.MoveColumnPos( "pre_vvd1_etb", 21 );
    			
    			sheetObj.ColumnSort( "post_lane2|post_vvd2" , "ASC" );
    		}
    		
    		
    	}
    	
    	/**
    	 * By Pre Lane Radio 버튼 선택시
    	 */
    	function preLaneSort( sType ) {
    		var sheetObj = sheetObjects[0];
    		if( sType == "T" ) {
    			sheetObj.MoveColumnPos( "pre_slan", 1 );
	    		sheetObj.MoveColumnPos( "pre_vvd", 2 );
	    		sheetObj.MoveColumnPos( "pre_etb_dt", 3 );
	    		sheetObj.MoveColumnPos( "post_slan", 4 );
	    		sheetObj.MoveColumnPos( "post_vvd", 5 );
	    		sheetObj.MoveColumnPos( "post_etb_dt", 6 );
	    		sheetObj.MoveColumnPos( "ts_port", 7 );
	    		sheetObj.MoveColumnPos( "pol_cd", 8 );
	    		sheetObj.MoveColumnPos( "pod_cd", 9 );
	    		sheetObj.MoveColumnPos( "del_cd", 10 );
	    		sheetObj.MoveColumnPos( "sls_ofc_cd", 11 );
	    		sheetObj.MoveColumnPos( "tslan_cd", 12 );
	    		sheetObj.MoveColumnPos( "vvd", 13 );
	    		
	    		sheetObj.ColumnSort( "yrwk|pre_slan" , "ASC" );
	    		
    		} else if( sType == "D" ) {
    			sheetObj.MoveColumnPos( "pre_lane1", 1 );
    			sheetObj.MoveColumnPos( "pre_vvd1", 2 );
    			sheetObj.MoveColumnPos( "pre_vvd1_etb", 3 );
    			sheetObj.MoveColumnPos( "pre_port1", 4 );
    			sheetObj.MoveColumnPos( "t_lane", 5 );
    			sheetObj.MoveColumnPos( "t_vvd", 6 );
    			sheetObj.MoveColumnPos( "t_vvd_etb", 7 );
    			sheetObj.MoveColumnPos( "t_pod", 8 );
    			sheetObj.MoveColumnPos( "post_lane2", 9 );
    			sheetObj.MoveColumnPos( "post_vvd2", 10 );
    			sheetObj.MoveColumnPos( "post_port2", 11 );
    			sheetObj.MoveColumnPos( "post_lane3", 12 );
    			sheetObj.MoveColumnPos( "post_vvd3", 13 );
    			sheetObj.MoveColumnPos( "post_port3", 14 );
    			sheetObj.MoveColumnPos( "post_lane4", 15 );
    			sheetObj.MoveColumnPos( "post_vvd4", 16 );
    			sheetObj.MoveColumnPos( "pol_cd", 17 );
    			sheetObj.MoveColumnPos( "pod_cd", 18 );
    			sheetObj.MoveColumnPos( "del_cd", 19 );
    			sheetObj.MoveColumnPos( "del_etb", 20 );
    			sheetObj.MoveColumnPos( "sls_ofc_cd", 21 );
    			
    			sheetObj.ColumnSort( "yrwk|pre_vvd1|t_vvd_etb" , "ASC" );
    		}
    	}
    	
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, quite) {
        	if(quite == undefined) quite = false;
            sheetObj.ShowDebugMsg = false;		
    		
            switch(sAction) {
    			
               case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)){
                        return false;
                    }
    				
    				//data sort choice box defalut setting
    				document.getElementById("chkPostLane").checked = true; //default
    				document.getElementById("chkPreLane").checked = false;
    				
    				document.getElementsByName("chkDsTSPort")[0].checked = true;
        	    	document.getElementsByName("chkDsPort")[0].checked = true;
        	    	document.getElementsByName("chkDsDel")[0].checked = true;
        	    	document.getElementsByName("chkDsOffice")[0].checked = true;
        	    	document.getElementsByName("chkDsLane")[0].checked = true;
        	    	document.getElementsByName("chkDsPVvd")[0].checked = false;
        	    	document.getElementsByName("chkDsPsVvd")[0].checked = false;
        	    	document.getElementsByName("chkDsDPsVvd")[0].checked = false;
        	    	
					if(formObj.pol1.value.length >= 5 || ComGetObjValue(formObj.ts_conti) != ""){
            	    	formObj.type.value = "T";
            	    	document.getElementsByName("chkDsTSPort")[0].disabled = false;
            	    	document.getElementsByName("chkDsPort")[0].disabled = false;
            	    	document.getElementsByName("chkDsDel")[0].disabled = false;
            	    	document.getElementsByName("chkDsOffice")[0].disabled = false;
            	    	document.getElementsByName("chkDsLane")[0].disabled = false;
            	    	document.getElementsByName("chkDsPVvd")[0].disabled = false;
            	    	document.getElementsByName("chkDsPsVvd")[0].disabled = false;
            	    	document.getElementsByName("chkDsDPsVvd")[0].disabled = true;
            	    }else{
            	    	formObj.type.value = "D";
            	    	document.getElementsByName("chkDsTSPort")[0].disabled = true;
            	    	document.getElementsByName("chkDsPort")[0].disabled = true;
            	    	document.getElementsByName("chkDsDel")[0].disabled = true;
            	    	document.getElementsByName("chkDsOffice")[0].disabled = true;
            	    	document.getElementsByName("chkDsLane")[0].disabled = true;
            	    	document.getElementsByName("chkDsPVvd")[0].disabled = true;
            	    	document.getElementsByName("chkDsPsVvd")[0].disabled = true;
            	    	document.getElementsByName("chkDsDPsVvd")[0].disabled = false;
            	    }
					
    				var param = "year=" + formObj.year.value;
    				param = param + "&week="        + formObj.week.value;
    				param = param + "&duration="    + formObj.duration.value;
    				param = param + "&rhq_cd="      + formObj.rhq_cd.value;
    				param = param + "&ofc_cd="      + comObjects[0].Code;
    				param = param + "&lane="        + comObjects[1].Code;
    				param = param + "&ts_conti="    + comObjects[2].Code;
    				param = param + "&pol1="        + formObj.pol1.value;
    				param = param + "&del="         + formObj.del.value;
    				param = param + "&type="        + formObj.type.value;
    				
    				var sXml = sheetObj.GetSearchXml("ESM_SPC_0105GS.do", "f_cmd="+(SEARCHLIST01)+"&"+ param + "&" + ComGetPrefixParam(""));
    				
    				// Sheet를 초기화한다.
    	            sheetObj.Redraw = false;
    	            sheetObj.RemoveAll();
    	            sheetObj.Reset();
    	            initSheet(sheetObj, 0);
    	            sheetObj.Redraw = true;
    	            // data를 로딩한다.
    	            //-------------------------
    	            sheetObj.LoadSearchXml(sXml);
    	            sheetObj.RemoveEtcData();                          // ETC 데이타 삭제
    	            //-------------------------
    				
    				break;

               case IBDOWNEXCEL:        //엑셀 다운로드              
                  sheetObj.Down2Excel(-1, true, true, false);
                  break;
            }
        }

        /**
         * RHQ Combo 값 변경시 호출됨
         */
    	function rhq_cd_OnChange(value){
    		if(value == undefined){
    			var obj = event.srcElement;
    			value = obj.value;
    		}
    		if(value == "") {
    			return;
    		}
    		var rtn = getCodeList("ChildOffice", "ofc_cd="+value+"&level=4&include=0");
    		initData_ofc_cd(rtn[0].split("|"), rtn[1].split("|"));
    	} 
    	
    	/**
    	 * RHQ Combo 값 변경시 Office 값 세팅
    	 */
    	function initData_ofc_cd(codes, names){
    	    var sheetObj = document.getElementById("ofc_cd");
    	    var cnt = 0;
    	    with(sheetObj){
    	        RemoveAll();
    	        SetTitle("Office|Name");
    	        SetColWidth("60|250");
    	        SetColAlign("left|left");
    	        ShowCol = 0;
    	        MultiSelect = false;
    	        MaxSelect = 1;
    	        DropHeight = 190;
    	        if(codes == undefined || codes == null){
    	        	return;
    	        }
    	        if(codes.length > 2){
    	    		InsertItem(-1, "|ALL", "");
    	        }
    	    	var selectCode = "";
    		    for(var i = 0 ; i < codes.length - 1 ; i++){
    		    	var txt = names[i].split("~");
    		    	if(txt[1] == "1"){
    		    		selectCode = codes[i];
    		    	}
    		    	InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		    }
    		    // 접속한 user소속 rgn office로 조회 조건 강제 세팅 제거
    		    Index = 0;
    	    }
    	}
    	
    	/**
    	 * 검색조건의 By Post Lane / By Pre Lane 선택시 TS Port / BKG Port 타이틀 변경
    	 */
//    	function changeSelectPort(value){
//    		var obj = event.srcElement;
//    		if(value == undefined){
//    			value = obj.value;
//    		}
//    		switch(value){
//    		case "S":
//    			txtPol.innerHTML = "<img class='nostar'>B.POL";
////    			txtPod.innerHTML = "<img class='nostar'>T/S Port";
//    			break;
//    		case "U":
//    			txtPol.innerHTML = "<img class='nostar'>T/S Port";
////    			txtPod.innerHTML = "<img class='nostar'>B.POD";   
//    			break;
//    		}
//    	}
    	/**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){

            switch(sAction) {
    			
               case IBSEARCH:      //조회
            	   var del      = formObj.del.value;		//필수 입력 체크 삭제 by kjj
            	   var ts_port  = formObj.pol1.value;
            	   var ts_conti = ComGetObjValue(formObj.ts_conti);
            	   
            	   if(del == "" && (ts_port.length < 5 && ts_conti == "")){
            		   ComShowMessage(getMsg("SPC90114", "T/S information"));
            		   formObj.pol1.focus();
            		   return false;
            	   }
            	   
    		       return true;
    		    break;
    		}
    		return true;
        }


        /**
         * Start Week 의 year 변경시 주차 변경
         */
        function checkWeek(){
        	SpcSearchOptionWeek("week",false,document.form.year.value);
        	
        }
        
        /*
         * 조회 후처리
         */
       function sheet1_OnSearchEnd(sheetObj, ErrMsg){
       	var formObj = document.form;
       	var size = sheetObj.LastCol;
        var view = formObj.type.value;
        postLaneSort( view );
       }

       /**
        * Sheet 1 더블 클릭시 이벤트, BKG Vol 더블클릭시 발생, 
        * @param sheetObj
        * @param row
        * @param col
        */
       function sheet1_OnDblClick(sheetObj, row, col) {
    	   var colName = sheetObj.ColSaveName(col);
    	   var param   = "";
    		var sheet1  = sheetObjects[0];
    	   if(colName == "bkg_ttl_qty" && document.form.type.value == "T"){
    		   var url   = "ESM_SPC_0072.do?";
    		   var post_vvd = sheet1.CellValue(sheet1_SelectedRow, "post_vvd");
    		   if(post_vvd == 'null'||post_vvd ==""||post_vvd =="-"){
    			   post_vvd = "-";
    		   }
   			   param = "?f_cmd="		+ SEARCHLIST
   			   + "&vvd="		+ sheet1.CellValue(sheet1_SelectedRow, "vvd")
   			   + "&pol_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "pol_cd")
   			   + "&pod_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "pod_cd")
   			   + "&del_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "del_cd")
   			   + "&ts_port="	+ sheet1.CellValue(sheet1_SelectedRow, "ts_port")
   			   + "&pre_vvd="		+ sheet1.CellValue(sheet1_SelectedRow, "pre_vvd")
   			   + "&post_vvd="		+ post_vvd
   			   + "&sls_ofc_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "sls_ofc_cd")
   			   + "&week="		    + sheet1.CellValue(sheet1_SelectedRow, "yrwk")
   			   + "&type="		    + document.form.type.value;

    		   var cnt = eval(sheetObj.CellValue(row, col));
    		   if( cnt > 0 ){
    			   window.showModalDialog(url+param, window, "scroll:no;status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px")
    		   }
    	   }
    	   else if(colName == "bkg_ttl_qty" && document.form.type.value == "D"){
    		   var url   = "ESM_SPC_0072.do?";

    		   var pre_vvd1 = sheet1.CellValue(sheet1_SelectedRow, "pre_vvd1");
    		   var post_vvd = sheet1.CellValue(sheet1_SelectedRow, "post_vvd2");
    		   var post_vvd1 = sheet1.CellValue(sheet1_SelectedRow, "post_vvd3");
    		   var post_vvd2 = sheet1.CellValue(sheet1_SelectedRow, "post_vvd4");
    		   if(pre_vvd1 == null||pre_vvd1 ==""){
    			   pre_vvd1 = "*";
    		   }
    		   if(post_vvd == null||post_vvd ==""){
    			   post_vvd = "*";
    		   }
    		   if(post_vvd1 == null||post_vvd1 ==""){
    			   post_vvd1 = "*";
    		   }
    		   if(post_vvd2 == null||post_vvd2 ==""){
    			   post_vvd2 = "*";
    		   }
   			   param = "?f_cmd="		+ SEARCHLIST
   			   + "&vvd="		+ sheet1.CellValue(sheet1_SelectedRow, "vvd")
   			   + "&pol_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "pol_cd")
   			   + "&pod_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "pod_cd")
   			   + "&del_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "del_cd")
   			   + "&ts_port="	+ sheet1.CellValue(sheet1_SelectedRow, "pre_port1")
   			   + "&pre_vvd="		+ pre_vvd1
   			   + "&post_vvd="		+ post_vvd
   			   + "&post_vvd1="		+ post_vvd1
   			   + "&post_vvd2="		+ post_vvd2
   			   + "&sls_ofc_cd="		+ sheet1.CellValue(sheet1_SelectedRow, "sls_ofc_cd")
   			   + "&week="		    + sheet1.CellValue(sheet1_SelectedRow, "yrwk")
   			   + "&type="		    + document.form.type.value;
    		   var cnt = eval(sheetObj.CellValue(row, col));
    		   if( cnt > 0 ){
    			   window.showModalDialog(url+param, window, "scroll:no;status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px")
    		   }
    	   }
       }
       /**
        * ie11 관련 개선 lane 콤보 
        */
       function lane_OnFocus(combj, value, text){
       	document.getElementById("year").focus();
        document.getElementById("lane").focus(); 
       }
       /**
        * ie11 관련 개선 lane 콤보 
        */
       function ts_conti_OnFocus(combj, value, text){
       	document.getElementById("year").focus();
        document.getElementById("ts_conti").focus(); 
       }
       function ofc_cd_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("ofc_cd").focus(); 
       }

	/* 개발자 작업  끝 */
