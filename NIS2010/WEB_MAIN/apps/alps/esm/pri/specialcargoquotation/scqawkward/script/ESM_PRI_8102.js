/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8102.js
*@FileTitle : Ocean Route List
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.12 문동선
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
     * @class ESM_PRI_8102 : ESM_PRI_8102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_8102() {
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
	var sheetCnt = 0;


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
            //시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        if(document.form.bb_flag.value == "Y"){
        	// Breakbulk 화면에서 호출 됐을 경우, T/S port 2개 이상인 경우는 보여주지 않음
			var sheetObj = sheetObjects[0];
			sheetObj.ColHidden("s_ts2_port") = true;
			sheetObj.ColHidden("s_ts2_lane") = true;
			sheetObj.ColHidden("s_ts2_type") = true;
			sheetObj.ColHidden("s_ts3_port") = true;
			sheetObj.ColHidden("s_ts3_lane") = true;
			sheetObj.ColHidden("s_ts3_type") = true;    
        }

        // 페이지 로딩시 focus
//        document.form.p_cntrno.focus();
        
		initControl();
    }
    
     /**
      * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     initControl()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */ 	    
      function initControl() {
    	 axon_event.addListenerForm   ('change', 'form_onChange', document.form);
         axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
         axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);               
      }
      
      function form_onChange ( event ){
    	  var eventObj = window.event.srcElement;
    	  var eventObjNm = eventObj.getAttribute ( "name" );
    	  var eventObjVal = eventObj.getAttribute ( "value" );
    	      	  
    	  if ( eventObjNm == "pol_port_cd" || eventObjNm == "pod_port_cd" ) {
        	  document.form.f_cmd.value = SEARCH05;
    		  var sXml = sheetObjects[0].getSearchXml ( "PRICommonGS.do", FormQueryString(document.form) + "&cd="+eventObjVal);
			  var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				
				if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
					ComShowMessage ( "Invalid " + eventObjNm.substr(0,3).toUpperCase() + " Code!!!");
					eventObj.setAttribute ( "value", "");
					eventObj.focus();
		    		return false;
				} else {
					if ( eventObjNm == "pol_port_cd" ) {
						document.form.pod_port_cd.focus();
					} 
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

        switch(sheetNo) {
	        case 1:      //IBSheet1 init
	            with (sheetObj) {
	                //전체 너비 설정
	                style.height = 270 ;
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 2, 1, 9, 100);
	
	                var HeadTitle1 = "SEQ|Del.|STS|POL|Lane|SVC\nType|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Remark|Remark|Validation date|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||||||||||||||||";
	                var HeadTitle2 = "SEQ|Del.|STS|POL|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Type|Note|Validation date|F/Used|C.Date|C.User|U.Date|U.User|" +
	                                 "s_rout_seq|s_t_time|s_s_time|s_pol1|s_pod1|s_pol1_yd|s_pod1_yd|s_lane1|s_dir1|s_fdr_flg1|s_pol2|s_pod2|s_pol2_yd|s_pod2_yd|s_lane2|s_dir2|s_fdr_flg2|s_pol3|s_pod3|s_pol3_yd|s_pod3_yd|s_lane3|s_dir3|s_fdr_flg3|s_pol4|s_pod4|s_pol4_yd|s_pod4_yd|s_lane4|s_dir4|s_fdr_flg4|s_n1st_tztm_hrs|s_n2nd_tztm_hrs|s_n3rd_tztm_hrs|s_n4th_tztm_hrs|s_n1st_stay_tm_hrs|s_n2nd_stay_tm_hrs|s_n3rd_stay_tm_hrs|s_ts_ind_cd|s_pod1_etb|s_pol2_etb|s_pod2_etb|s_pol3_etb|s_pod3_etb|s_pol4_etb|s_lnk_cnt|s_upd_ind_cd|s_dup_allow|s_ocn_rout_tmp_flg|old_ocn_rout_tmp_flg";
	                                 //"|||||||||||||||||||||||||||||||||||||";

	                var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 4, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false, false);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	
	                //데이터속성    [  ROW, COL,    DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE,	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtDataSeq,      30,    	daCenter,  	true,    	"s_seq",     			false,          "",       dfNone,   	0,     true,       true);
	                InitDataProperty(0, cnt++ , dtDelCheck,   	30,    	daCenter,  	true,    	"s_del",     			false,          "",       dfNone,	    0,     true,       true);
	                InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter,  	true,    	"ibflag",  				false,          "",       dfNone,	    0,     true,       true);
	                InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_pol",     			true,          	"",		  dfNone,   	0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	60,    	daCenter,  	true,    	"s_lane",    			true,           "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_svc_type", 			false,          "",       dfNone,  		0,     false,      true);
	                
	                InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts1_port", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"s_ts1_lane", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts1_type", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts2_port", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"s_ts2_lane", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	40,    	daCenter,  	true,    	"s_ts2_type", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts3_port", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"s_ts3_lane", 			false,          "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts3_type", 			false,          "",       dfNone,  		0,     false,      true);
	                
	                InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,     	"s_pod",     			true,           "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_fmt_t_time",   		false,          "",       dfUserFormat2,0,     false,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"s_fmt_s_time",   		false,          "",       dfUserFormat2,0,     false,      true);
	                InitDataProperty(0, cnt++ , dtCombo,      	60,    	daCenter,  	true,    	"s_prior",   			true,           "",       dfNone,  		0,     true,       true);
	                InitDataProperty(0, cnt++ , dtCombo,      	60,    	daCenter,  	true,    	"s_route_flg",      	true,           "",       dfNone,  		0,     true,       true);
	                
	                InitDataProperty(0, cnt++ , dtCombo,       	60,    	daLeft,  	true,    	"s_route_rmk",      	false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       	100,    daLeft,  	true,    	"s_route_note",      	false,          "",       dfNone, 		0,     false,      false);
					InitDataProperty(0, cnt++,  dtPopupEdit,    100,    daCenter,   true,       "s_ocn_rout_tmp_exp_dt",false,          "",       dfDateYmd,    0,     true,       true);
	                InitDataProperty(0, cnt++ , dtHidden,      	60,    	daCenter,  	true,    	"s_f_u",      			true,           "",       dfNone,  		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_c_date",   			false,          "",       dfDateYmd, 	0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_c_user",   			false,          "",       dfNone, 	    0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_u_date",   			false,          "",       dfDateYmd, 	0,     false,      true);
	                InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_u_user",   			false,          "",       dfNone, 	   	0,     false,      true);
	
	                // Hidden Fields
					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	true,    	"s_rout_seq",    		false,          "",       dfNone, 		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_t_time",   			false,          "",       dfNone, 		0,     false,      true);
	                InitDataProperty(0, cnt++ , dtHidden,    	75,    	daCenter,  	true,    	"s_s_time",   			false,          "",       dfNone,  		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol1",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod1",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol1_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod1_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_lane1",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir1",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg1",    		false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol2",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod2",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol2_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod2_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_lane2",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir2",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg2",    		false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol3",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod3",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol3_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod3_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_lane3",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir3",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg3",    		false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol4",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod4",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol4_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod4_yd",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_lane4",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir4",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg4",    		false,          "",       dfNone, 		0,     false,      true);

					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n1st_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n2nd_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n3rd_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n4th_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n1st_stay_tm_hrs",   false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n2nd_stay_tm_hrs",   false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n3rd_stay_tm_hrs",   false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_ts_ind_cd",			false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod1_etb",      		false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol2_etb",      		false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod2_etb",      		false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol3_etb",      		false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod3_etb",      		false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol4_etb",      		false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_lnk_cnt",      		false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_upd_ind_cd",      	false,          "",       dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,   	"s_dup_allow",     		false,          "",       dfNone,	    0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,   	"s_ocn_rout_tmp_flg",   false,          "",       dfNone,	    0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,   	"old_ocn_rout_tmp_flg",   false,          "",       dfNone,	    0,     false,      false);

	                InitComboNoMatchText(true);
	                
		            InitDataCombo (0, "s_prior", " |1|2|3|4|5|6|7|8|9|10", " |1|2|3|4|5|6|7|8|9|10");
		            InitDataCombo (0, "s_f_u", " |Y|N", " |Y|N");
		            InitDataCombo (0, "s_route_flg", " |Guide|Standard|Temporary|Validation|Not Used|Deleted", " |G|S|T|V|N|D");   // Route Flag - add 2007.12.11
		            InitDataCombo (0, "s_route_rmk", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others");   // 20090317
		            
		            ImageList(0) = "/hanjin/img/alps/button/btns_calendar.gif";
		            PopupButtonImage(0, "s_ocn_rout_tmp_exp_dt") = 0;
		            
	                InitUserFormat2(0, "s_fmt_t_time", "##D-##H", "D|-|H" );
	                InitUserFormat2(0, "s_fmt_s_time", "##D-##H", "D|-|H" );
		            RangeBackColor(1, 6, 1, 14) = RgbColor(222, 251, 248);   // alps
		            HeadRowHeight = 20 ;
		            
		            WaitImageVisible=false;
	            }
	            break;

        }
    }    
    
  // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
     document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){

         var sheetObj = sheetObjects[0];
         var formObj = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
 	                
                 case "btn_retrieve":
                 	doActionIBSheet(sheetObj, formObj, IBSEARCH);
 					break;	
 		                	
                 	
 				case "btn_selection":
 					returnButtonRouteYDData();
 					break;
 					
 				case "btn_close":
 					window.close();
 					break;
 				
 				case "btns_searchPol":
                case "btns_searchPod":
                	//ESM_PRI_0108_02.js 참조
                    var sUrl = "/hanjin/ESM_PRI_4026.do?";
                    sUrl += "group_cmd=" + PRI_SP_SCP;
                    sUrl += "&location_cmd=L";
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
                    if (rtnVal != null){
                        if(srcName == "btns_searchPol") {
                            formObj.pol_port_cd.value = rtnVal.cd;
                        }else if(srcName == "btns_searchPod"){
                            formObj.pod_port_cd.value = rtnVal.cd;
                        }
                    }
                    break;	
 					
        } // end switch
         } catch(e) {
             if( e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj, formObj, sAction) {
         sheetObj.ShowDebugMsg = false;

         switch(sAction) {

             case IBSEARCH:      //CARGO SHEET 조회
                 if (!validateForm(sheetObj, formObj, sAction)) {
 					return false;
 				}
 				formObj.f_cmd.value = SEARCH;
 				var sParam = FormQueryString(formObj);
				ComOpenWait(true);
				sheetObj.DoSearch4Post("ESM_PRI_8102GS.do", sParam);
				ComOpenWait(false);
 				//var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_8003GS.do", sParam);
 	 			//sheetObjects[0].LoadSearchXml(sXml);
 	 			break;
 	 		
         }
     }
     
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch ( sAction ) {
        	 case IBSEARCH:
	        	 if ( pol_port_cd.value.length != 5 ) {
	        		 ComShowMessage ( "Invalid POL Location!!!");
	        		 pol_port_cd.focus();
	        		 return false;
	        	 }
	        	 if ( pod_port_cd.value.length != 5 ) {
	        		 ComShowMessage ( "Invalid POD Location!!!");
	        		 pod_port_cd.focus();
	        		 return false;
	        	 }
	        	 break;
        	 }
         }

         return true;
     }

     /**
      * SHEET에서 선택된 값을 부모창으로 리턴한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     returnButtonSheetData();
      * </pre>
      * @return 없음
      * @author 최성민
      * @version 2009.05.19
      */
      function returnButtonRouteYDData() {
     	 	var array = new Array();
     		//var obj = new Object(); 
     		//배열의 크기를 세팅한다.
     		var arrayCnt = 0;
     		var tsCnt = 0;
     		
     		var obj = new Object();
     		var sheetObj = sheetObjects[0];
     		var selectedRow = sheetObj.selectRow;
     		
     		obj.rout_tp_cd = 'L';
     		obj.rout_tp_seq = 1;
     		obj.ob_yd_cd = sheetObj.CellValue ( selectedRow, 's_pol1_yd');
     		array[arrayCnt] = obj;
     		arrayCnt++;
     		
     		if ( sheetObj.CellValue ( selectedRow, 's_lane1') != '' ) {
     			var obj = new Object();
     			if ( sheetObj.CellValue ( selectedRow, 's_lane2') != '' ) {
     				tsCnt++;
     				obj.rout_tp_cd = 'N';
     				obj.rout_tp_seq = tsCnt;
     				obj.lane_cd = sheetObj.CellValue ( selectedRow, 's_lane1');
     				obj.ib_yd_cd = sheetObj.CellValue ( selectedRow, 's_pod1_yd');
     				obj.ob_yd_cd = sheetObj.CellValue ( selectedRow, 's_pol2_yd');
     			} else {
     				obj.rout_tp_cd = 'P';
     				obj.rout_tp_seq = 1;
     				obj.lane_cd = sheetObj.CellValue ( selectedRow, 's_lane1');
     				obj.ib_yd_cd = sheetObj.CellValue ( selectedRow, 's_pod1_yd');
     				
     			}
     			array[arrayCnt] = obj;
     			arrayCnt++;
     			
     		}
     		
     		if ( sheetObj.CellValue ( selectedRow, 's_lane2') != '' ) {
     			var obj = new Object();
     			if ( sheetObj.CellValue ( selectedRow, 's_lane3') != '' ) {
	 				tsCnt++;
	 				obj.rout_tp_cd = 'N';
	 				obj.rout_tp_seq = tsCnt;
	 				obj.lane_cd = sheetObj.CellValue ( selectedRow, 's_lane2');
	 				obj.ib_yd_cd = sheetObj.CellValue ( selectedRow, 's_pod2_yd');
	 				obj.ob_yd_cd = sheetObj.CellValue ( selectedRow, 's_pol3_yd');
     			} else {
     				obj.rout_tp_cd = 'P';
     				obj.rout_tp_seq = 1;
     				obj.lane_cd = sheetObj.CellValue ( selectedRow, 's_lane2');
     				obj.ib_yd_cd = sheetObj.CellValue ( selectedRow, 's_pod2_yd');
     			}
     				
 				array[arrayCnt] = obj;
     			arrayCnt++;
	     		
     		}
     		
     		if ( sheetObj.CellValue ( selectedRow, 's_lane3') != '' ) {
     			var obj = new Object();
     			if ( sheetObj.CellValue ( selectedRow, 's_lane4') != '' ) {
	 				tsCnt++;
	 				obj.rout_tp_cd = 'N';
	 				obj.rout_tp_seq = tsCnt;
	 				obj.lane_cd = sheetObj.CellValue ( selectedRow, 's_lane3');
	 				obj.ib_yd_cd = sheetObj.CellValue ( selectedRow, 's_pod3_yd');
	 				obj.ob_yd_cd = sheetObj.CellValue ( selectedRow, 's_pol4_yd');
     			} else {
     				obj.rout_tp_cd = 'P';
     				obj.rout_tp_seq = 1;
     				obj.lane_cd = sheetObj.CellValue ( selectedRow, 's_lane3');
     				obj.ib_yd_cd = sheetObj.CellValue ( selectedRow, 's_pod3_yd');
     			}
     				
 				array[arrayCnt] = obj;
     			arrayCnt++;
	     		
     		}
     		
     		if ( sheetObj.CellValue ( selectedRow, 's_lane4') != '' ) {
     			var obj = new Object();
 				tsCnt++;
 				obj.rout_tp_cd = 'P';
 				obj.rout_tp_seq = 1;
 				obj.lane_cd = sheetObj.CellValue ( selectedRow, 's_lane4');
 				obj.ib_yd_cd = sheetObj.CellValue ( selectedRow, 's_pod4_yd');

 				array[arrayCnt] = obj;
     			arrayCnt++;
     		}
     		 window.returnValue = array;
			 self.close();
     	 }

      function sheet1_OnDblClick(sheetObj, Row, Col) {
    	  returnButtonRouteYDData();
      }
      
      /**
       * OnKeyPress event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_keypress()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */     
     function obj_keypress() {
         switch (event.srcElement.dataformat) {
             case "engup":
                 ComKeyOnlyAlphabet('upper');
                 break;
             case "int":
                 ComKeyOnlyNumber(event.srcElement);
                 break;
             case "float":
                 ComKeyOnlyNumber(event.srcElement, ".");
                 break;
             case "ymd":
             	ComKeyOnlyNumber(event.srcElement, "-");
                 break;
             default:
         }

     }    
     
       function obj_keydown(){
           //Proposal No,S/C No. 에서 Enter key조회
           var eleName = event.srcElement.name;
           var keyValue = null;
	       if(event == undefined || event == null) {
	    	   keyValue = 13;
	       }else{
	    	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	       }
	       if (keyValue == 13){
	    	   if (eleName == "pod_port_cd" ){
	        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    	   } else if ( eleName == "pol_port_cd" ){
	    		   event.keyCode = 9;
	    	   }
	       }
       }
        
      function sheet1_OnSearchEnd(){ // Breakbulk 화면에서 호출 됐을 경우, T/S port 2개 이상인 경우는 보여주지 않음
    	 if(document.form.bb_flag.value == "Y"){
	    	 var sheetObj = sheetObjects[0];
	    	 for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
	    	 	if(sheetObj.CellValue(i,"s_ts2_port")!=""){
	    	 		sheetObj.RowDelete(i,false);
	    	 		i--;
	    	 	}
	    	 }
    	 }
     }
      
	/* 개발자 작업  끝 */
      
      