/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0086.js
*@FileTitle : Verification Result
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.06
*@LastModifier : 변종건
*@LastVersion : 1.0 
* 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESD_PRD_0086 : ESD_PRD_0086 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */


var sheetObjects = new Array();
var sheetCnt = 0;
var prefix = "s_";
var firstLoad = true;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         var sheetObject2 = sheetObjects[2];
         var sheetObject3 = sheetObjects[3];

         /*******************************************************/
         var formObject = document.form;

      try {
      var srcName = window.event.srcElement.getAttribute("name");

      switch(srcName) {

        case "btn_rule":
        	var theURL = "ESD_PRD_0086_01.do";
			var winName = "ESD_TES_0086_01";
			var features = "scroll:yes;status:no;help:no;dialogWidth:1000px;dialogHeight:680px";
			ComOpenWindow(theURL,winName,features,true);
			break;

        case "btn_verify":
        	doActionIBSheet(sheetObject,formObject,SEARCH01);
            break;

        case "btn_delete":
        	doActionIBSheet(sheetObject,formObject,IBDELETE);
            break;
            
        case "btn_save":
        	doActionIBSheet(sheetObject,formObject,MULTI01);
            break;
            
        case "btn_close":
            window.close();
            break;

      } // end switch
      }catch(e) {
        if( e == "[object Error]") {
          ComShowMessage(ComGetMsg('COM12111'));
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initSet();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
            	//전체 너비 설정
//              style.height = GetSheetHeight(12) ;
            	style.height = 390 ;
            	SheetWidth = mainTable.clientWidth;

            	//Host정보 설정[필수][HostIp, Port, PagePath]
            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            	//전체Merge 종류 [선택, Default msNone]
            	MergeSheet = msHeaderOnly;

            	//전체Edit 허용 여부 [선택, Default false]
            	Editable = true;

            	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            	InitRowInfo( 3, 1, 9, 100);

            	var HeadTitle0 = "*When you upload a lot of ocean routes through 'Upload Excel' function, the columns in red are mandatory items.|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
            	var HeadTitle1 = "|Verification Result|Verification Result|SEQ|Del.|STS|POL|Lane|SVC\nType|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Remark|Remark|Validation date|C.Date|C.User|U.Date|U.User|Full Route||||||||||||||||||||||||||||||||||||||||||||||||";
            	var HeadTitle2 = "|Status|Error Type|SEQ|Del.|STS|POL|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Type|Note|Validation date|C.Date|C.User|U.Date|U.User|Full Route||||||||||||||||||||||||||||||||||||||||||||||||";

            	var headCount = ComCountHeadTitle(HeadTitle1);

            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            	InitColumnInfo(headCount, 4, 0, true);
//              InitColumnInfo(64, 4, 0, true);

            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	InitHeadMode(true, true, true, true, false,false);

            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            	InitHeadRow(0, HeadTitle0, true, true);
            	InitHeadRow(1, HeadTitle1, true);
            	InitHeadRow(2, HeadTitle2, true);

            	//데이터속성    [  ROW, COL,    DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE,	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++ , dtCheckBox,     20,    	daCenter,  	true,    	"s_chk",     			false,          "",       dfNone,   	0,     true,       true);
            	InitDataProperty(0, cnt++ , dtCombo,        50,   	daCenter,  	true,    	"s_err_tp",     		false,          "",       dfNone,   	0,     false,      false);
            	InitDataProperty(0, cnt++ , dtCombo,        120,   	daCenter,  	true,    	"s_err_desc",    		false,          "",       dfNone,   	0,     false,      false);
            	InitDataProperty(0, cnt++ , dtSeq,        	30,    	daCenter,  	true,    	"s_seq",     			false,          "",       dfNone,   	0,     false,      false);
            	InitDataProperty(0, cnt++ , dtHidden,   	30,    	daCenter,  	true,    	"s_del",     			false,          "",       dfNone,	    0,     false,      false);
            	InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter,  	true,    	"ibflag",  				false,          "",       dfNone,	    0,     false,      false);
            	InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_pol",     			false,          "",		  dfNone,   	0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,       	60,    	daCenter,  	true,    	"s_ts1_lane",    		false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts1_type", 			false,          "",       dfNone,  		0,     false,      false);
            	
            	InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts1_port", 			false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"s_ts2_lane", 			false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts2_type", 			false,          "",       dfNone,  		0,     false,      false);
            	
            	InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts2_port", 			false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"s_ts3_lane", 			false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,       	40,    	daCenter,  	true,    	"s_ts3_type", 			false,          "",       dfNone,  		0,     false,      false);
            	
            	InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts3_port", 			false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"s_ts4_lane", 			false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"s_ts4_type", 			false,          "",       dfNone,  		0,     false,      false);
              
            	InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,     	"s_pod",     			false,          "",       dfNone,  		0,     true,      true);
            	InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"fmt_tot_tt",  			false,          "",       dfUserFormat2,0,     false,      false);
            	InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"fmt_tot_st",  			false,          "",       dfUserFormat2,0,     false,      false);
            	InitDataProperty(0, cnt++ , dtCombo,      	60,    	daCenter,  	true,    	"s_prior",   			false,          "",       dfNone,  		0,     false,      false);
            	InitDataProperty(0, cnt++ , dtCombo,      	60,    	daCenter,  	true,    	"s_route_flg",   		false,          "",       dfNone,  		0,     true,      true);
              
            	InitDataProperty(0, cnt++ , dtCombo,       	60,    	daLeft,  	true,    	"s_route_rmk",   		false,          "",       dfNone, 		0,     true,      true);
				InitDataProperty(0, cnt++ , dtData,       	100,    daLeft,  	true,    	"s_route_note",  		false,          "",       dfNone, 		0,     true,      true);

				InitDataProperty(0, cnt++,  dtPopupEdit,    100,    daCenter,   true,       "s_ocn_rout_tmp_exp_dt",false,          "",       dfDateYmd,    0,     true,       true);
				
				InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_c_date",   			false,          "",       dfDateYmd, 	0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_c_user",   			false,          "",       dfNone, 	    0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_u_date",   			false,          "",       dfDateYmd, 	0,     false,      false);
				InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_u_user",   			false,          "",       dfNone, 	   	0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,     	200,    daCenter,  	true,    	"full_rout",    		false,          "",       dfNone,     0,     false,       false);
				
				// Hidden Fields
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"tot_tt_st",        	false,          "",		  dfUserFormat2,     0,     false,       true,		-1,		false, 		true, 		"", 	true,		"IUD",		true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"val_flg",          	false,          "",       dfNone,     0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_f_u",            	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_rout_seq",       	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_t_time",         	false,          "|s_n1st_tztm_hrs|+|s_n2nd_tztm_hrs|+|s_n3rd_tztm_hrs|+|s_n4th_tztm_hrs|",       dfNone,    0,     false,      true);
                InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"s_t_t_dy",         	false,          "Int(|s_t_time|/24)",       dfUserFormat2,   0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"s_t_t_hr",         	false,          "|s_t_time|%24",       dfUserFormat2,   0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_n1st_tztm_hrs",  	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_n2nd_tztm_hrs",  	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_n3rd_tztm_hrs",  	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_n4th_tztm_hrs",  	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"s_s_time",         	false,          "|s_n1st_stay_tm_hrs|+|s_n2nd_stay_tm_hrs|+|s_n3rd_stay_tm_hrs|",       dfNone,   0,     false,      true);
                InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"s_s_t_dy",         	false,          "Int(|s_s_time|/24)",       dfUserFormat2,   0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"s_s_t_hr",         	false,          "|s_s_time|%24",       dfUserFormat2,   0,     true,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_n1st_stay_tm_hrs", 	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_n2nd_stay_tm_hrs", 	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_n3rd_stay_tm_hrs", 	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pol1",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pod1",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_dir1",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_fdr_flg1",       	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pol2",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pod2",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_dir2",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_fdr_flg2",       	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pol3",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pod3",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_dir3",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_fdr_flg3",       	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pol4",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pod4",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_dir4",           	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_fdr_flg4",       	false,          "",       dfNone,     0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_ts_ind",         	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pod1_etb",       	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pol2_etb",       	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pod2_etb",       	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pol3_etb",       	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pod3_etb",       	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_pol4_etb",       	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_lnk_cnt",        	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_upd_ind_cd",     	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_row_copy_flg",   	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	20,    	daCenter,  	true,    	"s_doubt_flg",      	false,          "",       dfNone,     0,     true,        true);
                InitDataProperty(0, cnt++ , dtHidden,     	50,    	daCenter,  	false,   	"s_dup_allow",      	false,          "",       dfNone,     0,     false,       false);
                InitDataProperty(0, cnt++ , dtHidden,     	20,    	daCenter,  	true,    	"s_insert_flag",    	false,          "",       dfNone,     0,     true,        true);
				InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,  "s_ocn_rout_tmp_flg",   false,          "",       dfNone,	    0,     false,      false);

				InitComboNoMatchText(true); 
				InitDataCombo (0, "s_err_tp", " |Fail|Success|Modified", " |Y|N|M");
				InitDataCombo (0, "s_err_desc", " |Port Code Error|Lane Code Error|Lane P/F SKD Error|Link Error|POD Overlap Error|Canal Code Error|Optimization Error(1)|Optimization Error(2)|Optimization Error(3)|Return Shipment Error|Temporary Flag Error|Ocean Flag Error|Transit Time Error|Trans-shipment Error|Duplication Error|The others Error", " |E01|E02|E03|E04|E05|E06|E07|E08|E09|E10|E11|E12|E13|E14|E98|E99");
	            InitDataCombo (0, "s_prior", " |1|2|3|4|5|6|7|8|9|10", " |1|2|3|4|5|6|7|8|9|10");
	            InitDataCombo (0, "s_route_flg", " |Standard|Temporary", " |S|T");
	            InitDataCombo (0, "s_route_rmk", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others");
	            
	            InitUserFormat2(0, "fmt_tot_tt", "##D-##H", "D|-|H" );
	            InitUserFormat2(0, "fmt_tot_st", "##D-##H", "D|-|H" );
	            InitUserFormat2(0, "tot_tt_st", "##D-##H", "D|-|H" );
	            
	            InitDataCombo (0, "s_f_u", " |Y|N", " |Y|N");
	            
				InitDataValid(0, "s_pol",        vtEngUpOther, "1234567890");
				InitDataValid(0, "s_ts1_lane",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_ts1_port",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_ts2_lane",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_ts2_port",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_ts3_lane",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_ts3_port",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_ts4_lane",   vtEngUpOther, "1234567890");
				InitDataValid(0, "s_pod",        vtEngUpOther, "1234567890");
				
	            RangeBackColor(1, 6, 1, 14) = RgbColor(222, 251, 248);
	            HeadRowHeight = 20 ;
	            
	            WaitImageVisible=false;
            }
            
            break;
        }
    }



    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
           		if(!validateForm(sheetObj,formObj,sAction)) return;
           
           		ComOpenWait(true);
           		formObj.f_cmd.value = SEARCH;
           		var queryStr = sheetObj.GetSaveString(false);
           		var sXml = sheetObj.GetSearchXml("ESD_PRD_0086GS.do", queryStr +"&"+ PrdFQString(formObj));
           		sheetObj.LoadSearchXml(sXml);
           		ComOpenWait(false);
           		break;
           		
           case SEARCH01:
        	    if(!validateForm(sheetObj,formObj,sAction)) return;
                
        	    formObj.f_cmd.value = SEARCH01;
        	    ComOpenWait(true);
        	    var queryStr = sheetObj.GetSaveString(false, false, "s_chk");
          		var resultXml = sheetObj.GetSearchXml("ESD_PRD_0086GS.do", queryStr +"&"+ PrdFQString(formObj));

          		var arrStr = ComGetEtcData(resultXml, "arrStr").split(",");

          		for( var idx = 0; idx < arrStr.length; idx++ ){
          			var Row = sheetObj.FindText( "s_seq", arrStr[idx].split("|")[0], parseInt(sheetObj.HeaderRows) );
//          			sheetObj.CellValue2(Row,"s_chk") 				= arrStr[idx].split("|")[1];
          			sheetObj.CellValue2(Row,"s_err_tp") 			= arrStr[idx].split("|")[2];
          			sheetObj.CellValue2(Row,"s_err_desc") 			= arrStr[idx].split("|")[3];
          			sheetObj.CellValue2(Row,"s_ts1_type") 			= arrStr[idx].split("|")[4];
          			sheetObj.CellValue2(Row,"s_ts2_type") 			= arrStr[idx].split("|")[5];
          			sheetObj.CellValue2(Row,"s_ts3_type") 			= arrStr[idx].split("|")[6];
          			sheetObj.CellValue2(Row,"s_ts4_type") 			= arrStr[idx].split("|")[7];
          			sheetObj.CellValue2(Row,"fmt_tot_tt") 			= arrStr[idx].split("|")[8];
          			sheetObj.CellValue2(Row,"s_prior") 				= arrStr[idx].split("|")[9];
          			sheetObj.CellValue2(Row,"full_rout") 			= arrStr[idx].split("|")[10];
          			
          			sheetObj.CellValue2(Row,"s_pol1") 				= arrStr[idx].split("|")[11];
          			sheetObj.CellValue2(Row,"s_pol2") 				= arrStr[idx].split("|")[12];
          			sheetObj.CellValue2(Row,"s_pol3") 				= arrStr[idx].split("|")[13];
          			sheetObj.CellValue2(Row,"s_pol4") 				= arrStr[idx].split("|")[14];
          			
          			sheetObj.CellValue2(Row,"s_pod1") 				= arrStr[idx].split("|")[15];
          			sheetObj.CellValue2(Row,"s_pod2") 				= arrStr[idx].split("|")[16];
          			sheetObj.CellValue2(Row,"s_pod3") 				= arrStr[idx].split("|")[17];
          			sheetObj.CellValue2(Row,"s_pod4") 				= arrStr[idx].split("|")[18];
          			
          			sheetObj.CellValue2(Row,"s_dir1") 				= arrStr[idx].split("|")[19];
          			sheetObj.CellValue2(Row,"s_dir2") 				= arrStr[idx].split("|")[20];
          			sheetObj.CellValue2(Row,"s_dir3") 				= arrStr[idx].split("|")[21];
          			sheetObj.CellValue2(Row,"s_dir4") 				= arrStr[idx].split("|")[22];
          			
          			sheetObj.CellValue2(Row,"s_fdr_flg1") 			= arrStr[idx].split("|")[23];
          			sheetObj.CellValue2(Row,"s_fdr_flg2") 			= arrStr[idx].split("|")[24];
          			sheetObj.CellValue2(Row,"s_fdr_flg3") 			= arrStr[idx].split("|")[25];
          			sheetObj.CellValue2(Row,"s_fdr_flg4") 			= arrStr[idx].split("|")[26];
          			
          			sheetObj.CellValue2(Row,"s_n1st_tztm_hrs") 		= arrStr[idx].split("|")[27];
          			sheetObj.CellValue2(Row,"s_n2nd_tztm_hrs") 		= arrStr[idx].split("|")[28];
          			sheetObj.CellValue2(Row,"s_n3rd_tztm_hrs") 		= arrStr[idx].split("|")[29];
          			sheetObj.CellValue2(Row,"s_n4th_tztm_hrs") 		= arrStr[idx].split("|")[30];
          			
          			sheetObj.CellValue2(Row,"s_n1st_stay_tm_hrs")	= arrStr[idx].split("|")[31];
          			sheetObj.CellValue2(Row,"s_n2nd_stay_tm_hrs") 	= arrStr[idx].split("|")[32];
          			sheetObj.CellValue2(Row,"s_n3rd_stay_tm_hrs") 	= arrStr[idx].split("|")[33];
          			sheetObj.CellValue2(Row,"s_lnk_cnt") 			= arrStr[idx].split("|")[34];
          		}
          		
          		var dupFlg = routeDupChk(sheetObj);
          		
        	    ComOpenWait(false);
          		break;
           		
           case IBDELETE:
        	   	if(!validateForm(sheetObj,formObj,sAction)) return;
        	   	
        	   	var idx = 0;
        	   	for( idx = sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx >= 0+parseInt(sheetObj.HeaderRows); idx-- ){
        	   		if( sheetObj.CellValue(idx,"s_chk") == "1" ){
        	   			sheetObj.RowDelete(idx, false);
        	   		}
        	   	}
        	   	break;
        	   	
           case IBSAVE:
        	   	if(!validateForm(sheetObj,formObj,sAction)) return;
        	   	
        	   	for( var idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
        	   		if( sheetObj.CellValue(idx,"s_chk") != "1" ){
        	   			sheetObj.RowStatus(idx) = "";
        	   		}
        	   	}
        	   	
        	   	ComOpenWait(true);
        	   	formObj.f_cmd.value = MULTI;
        	   	
        	   	var bSaveSuccess = sheetObj.DoSave("ESD_PRD_0086GS.do", PrdFQString(formObj), -1, false);
        	   	ComOpenWait(false);
        	   	
        	   	if (!bSaveSuccess) { // ui에서 실패
        	   		return;
        	   	}
        	   	break;
        	   	
           case MULTI01:
	       	   	if(!validateForm(sheetObj,formObj,sAction)) return;
	       	   	
	       	   	for( var idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	       	   		if( sheetObj.CellValue(idx,"s_chk") != "1" ){
	       	   			sheetObj.RowStatus(idx) = "";
	       	   		}
	       	   	}
	       	   	
	       	   	ComOpenWait(true);
	       	   	formObj.f_cmd.value = MULTI;
	       	   	
	       	   	var bSaveSuccess = sheetObj.DoSave("ESD_PRD_0086GS.do", PrdFQString(formObj), -1, false);
	       	   	ComOpenWait(false);
	       	   	
	       	   	if (!bSaveSuccess) { // ui에서 실패
	       	   		return;
	       	   	}
	       	   	break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
    	 	case IBDELETE:
    	 		var idx = 0;
	        	var chkCnt = 0;
	        	
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	        		if( sheetObj.CellValue(idx,"s_chk") == "1" ){
	        			chkCnt++;
	        		}
	        	}
	        	if( chkCnt == 0 ){
	        		ComShowCodeMessage("COM12189");
	        		return false;
	        	}
	        	break;
    	 		
	        case IBSAVE:
	        	var idx = 0;
	        	
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	        		if( sheetObj.CellValue(idx,"s_chk") == "1" && ( sheetObj.CellValue(idx,"s_err_tp") == "Y" || sheetObj.CellValue(idx,"s_err_tp") == "M" ) ){
	        			ComShowCodeMessage("PRD90132");
	        			return false;
	        		}
	        	}
	  			break;
	  			
	        case MULTI01:
	        	var idx = 0;
	        	var chkCnt = 0;
	        	
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	        		if( sheetObj.CellValue(idx,"s_chk") == "1" ){
	        			chkCnt++;
	        		}
	        	}
	        	if( chkCnt == 0 ){
	        		ComShowCodeMessage("COM12189");
	        		return false;
	        	}
	        	
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
        	   		if( sheetObj.CellValue(idx,"s_chk") == "1" && ( sheetObj.CellValue(idx,"s_err_tp") == "Y" || sheetObj.CellValue(idx,"s_err_tp") == "M" ) ){
	        			ComShowCodeMessage("PRD90132");
	        			return false;
	        		}
	        	}
	        	
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	        		if(sheetObj.CellValue(idx,"s_route_flg")=='T') {
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'Y';
	            	}else if(sheetObj.CellValue(idx,"s_route_flg")!='T') {  //2015 PHR temp 아닌 경우 'N'값 입력 
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'N';
	            	}
	        	}	
	        	
	        	if( ComShowCodeConfirm("COM12147","Ocean Route") ){ 
	    			return true;
	    		} else{
	    			return false;
	    		}
	  			break;
	  			
	        case IBSEARCH:
	        	if( sheetObj.RowCount <= 0 ){
	        		return false;
	        	}
		        //jsy 
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	        		   		        		
	        		if( sheetObj.CellValue(idx,"s_route_flg")=='T' && sheetObj.CellValue(idx,"s_ocn_rout_tmp_exp_dt")=='' ) {
//	        			alert('exp dt 입력');
	        			ComShowMessage(ComGetMsg('PRD90143'));
	        			sheetObj.SelectCell(idx, "s_ocn_rout_tmp_exp_dt");
	        			return false;
	        		}
	        		
	        		if(sheetObj.CellValue(idx,"s_route_flg")=='T' && sheetObj.CellValue(idx,"s_ocn_rout_tmp_exp_dt")!='' &&
	        				0 == ComChkPeriod ( sheetObj.CellValue(idx,"s_ocn_rout_tmp_exp_dt") ,ComGetDateAdd(null, "D", 30)) ) {
//	            		alert('30일 이내로 ~')
	            		ComShowMessage(ComGetMsg('PRD90142'));
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_exp_dt")= ''; //ComGetDateAdd(null, "D", 30);
	            		sheetObj.SelectCell(idx, "s_ocn_rout_tmp_exp_dt");
	            		return false;
	            	};
	            	
	            	if(sheetObj.CellValue(idx,"s_route_flg")=='T') {
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'Y';
	            	}else if(sheetObj.CellValue(idx,"s_route_flg")!='T') {  //2015 PHR temp 아닌 경우 tmp_flg='N' 입력 & 기타 컬럼 초기화
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'N';
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_exp_dt")= '';
	            		sheetObj.CellValue2(idx, "s_route_rmk")='';
	            	}
	        	}
	        		
	        	break;
	        	
	        case SEARCH01:
	        	if( sheetObj.RowCount <= 0 ){
	        		return false;
	        	}
	        	
	        	var idx = 0;
	        	var chkCnt = 0;
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	        		if( sheetObj.CellValue(idx,"s_chk") == "1" ){
	        			chkCnt++;
	        		}
	        	}
	        	if( chkCnt == 0 ){
	        		ComShowCodeMessage("COM12189");
	        		return false;
	        	}
	        	
	        	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	        		//alert("s_route_flg : " + sheetObj.CellValue(idx,"s_route_flg"));
	        		
	        		if( sheetObj.CellValue(idx,"s_route_flg")=='T' && sheetObj.CellValue(idx,"s_ocn_rout_tmp_exp_dt")=='' ) {
//	        			alert('exp dt 입력');
	        			ComShowMessage(ComGetMsg('PRD90143'));
	        			sheetObj.SelectCell(idx, "s_ocn_rout_tmp_exp_dt");
	        			return false;
	        		}
	        			        		
	        		if(sheetObj.CellValue(idx,"s_route_flg")=='T' && sheetObj.CellValue(idx,"s_ocn_rout_tmp_exp_dt")!='' &&
	        				0 == ComChkPeriod ( sheetObj.CellValue(idx,"s_ocn_rout_tmp_exp_dt") ,ComGetDateAdd(null, "D", 30)) ) {
//	            		alert('30일 이내로 ~')
	            		ComShowMessage(ComGetMsg('PRD90142'));
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_exp_dt")= ''; //ComGetDateAdd(null, "D", 30);
	            		sheetObj.SelectCell(idx, "s_ocn_rout_tmp_exp_dt");
	            		return false;
	            	};
	            	
	            	if(sheetObj.CellValue(idx,"s_route_flg")=='T') {
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'Y';
	            	}else if(sheetObj.CellValue(idx,"s_route_flg")!='T') {  //2015 PHR temp 아닌 경우 tmp_flg='N' 입력 & 기타 컬럼 초기화
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'N';
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_exp_dt")= '';
	            		sheetObj.CellValue2(idx, "s_route_rmk")='';
	            	}
	        	}
	        	
	        	break;
        		
        }

        return true;
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function initSet(){
    	var sheetObj = sheetObjects[0];
        var excelColumnMapping = 	"2=>s_pol|3=>s_ts1_lane|4=>s_ts1_type|5=>s_ts1_port|6=>s_ts2_lane|7=>s_ts2_type|8=>s_ts2_port|9=>s_ts3_lane|10=>s_ts3_type|" +
							        "11=>s_ts3_port|12=>s_ts4_lane|13=>s_ts4_type|14=>s_pod|15=>fmt_tot_tt|16=>s_prior|17=>s_route_flg|18=>s_route_rmk|19=>s_route_note|20=>s_ocn_rout_tmp_exp_dt|";

        sheetObj.LoadExcel(-1, 1, "", 1, -1, "", true, false, excelColumnMapping);

        var idx = 0;
        for( idx = sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx >= 0+parseInt(sheetObj.HeaderRows); idx-- ){
	        if( sheetObj.CellValue(idx,"s_pol") == "" && sheetObj.CellValue(idx,"s_ts1_lane") == ""  && sheetObj.CellValue(idx,"s_pod") == ""  && sheetObj.CellValue(idx,"s_prior") == "" )
	     	{
	        	sheetObj.RowDelete(idx, false);
	     	}
     	}
    }
     
    /**
     * 조회 후 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var errCnt = 0;
    	var idx = 0;
    	for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
    		if( sheetObj.CellValue(idx,"s_err_tp") == "Y" || sheetObj.CellValue(idx,"s_err_desc") != "" ){
    			errCnt++;
    		}
    	}
    	
    	var dupFlg = routeDupChk(sheetObj);
    	if( dupFlg == false ){
    		errCnt++;
    	}
    	
    	if( errCnt == 0 && ErrMsg == "" ){
    		if( ComShowCodeConfirm("PRD90131") ){
    			doActionIBSheet(sheetObj,document.form,IBSAVE);
    		} else{
    			window.close();
    		}
    	} else{
    		ComShowCodeMessage("PRD90132");
    	}
    }
     
    /**
     * 저장 후 이벤트 처리
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg != "Saved data successfully." ){
    		return;		// 시스템 오류 등, 예기치 않은 서버오류에 의한 메시지가 왔을 경우 해당에서 처리한다.
    	} else{
    		self.close();
    	}
    }
     
    /**
 	 * Sheet1 Change 이벤트 시
 	 * @return
 	 */  	
 	function sheet1_OnChange(sheetObj, Row, Col, Val) {
 		if( sheetObj.ColSaveName(Col) != "s_chk" ){
 			sheetObj.CellValue2(Row,"s_err_tp") = "M";
 		}
 	    if( sheetObj.ColSaveName(Col) == "s_route_flg" && Val == "T") {
 	        ComShowMessage("Please select a type of temp flag.");
 	        sheetObj.SelectCell(Row, "s_route_rmk");
 	        sheetObj.CellValue2(Row, "s_route_rmk")='Space Shortage';
 	        sheetObj.CellValue2(Row, "s_route_note")='';  
 	    } else if( sheetObj.ColSaveName(Col) == "s_route_flg" && Val != "T") {
 	        sheetObj.CellValue2(Row, "s_route_rmk")='';
 	        sheetObj.CellValue2(Row, "s_route_note")='';  
 	    }   
 	  }
 	 
 	/**
  	 * Duplication Check
  	 * @return dupCnt
  	 */  	
  	function routeDupChk(sheetObj){
  		if( sheetObj.RowCount <= 1 ){
  			return true;
  		}
  		
  		var idx = 0;
  		var jdx = 0;
  		var idxStr = "";
  		var jdxStr = "";
  		var dupArr = [];
  		var dupCnt = 0;
  		for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows) - 1; idx++ ){
  			for( jdx = idx + 1; jdx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); jdx++ ){
  				idxStr = sheetObj.CellValue(idx,"s_pol") +"/"+ sheetObj.CellValue(idx,"s_ts1_lane") +"/"+ sheetObj.CellValue(idx,"s_ts1_port") +"/"+ sheetObj.CellValue(idx,"s_ts2_lane") +"/"+ sheetObj.CellValue(idx,"s_ts2_port") +"/"+ sheetObj.CellValue(idx,"s_ts3_lane") +"/"+ sheetObj.CellValue(idx,"s_ts3_port") +"/"+ sheetObj.CellValue(idx,"s_ts4_lane") +"/"+ sheetObj.CellValue(idx,"s_pod");
  				jdxStr = sheetObj.CellValue(jdx,"s_pol") +"/"+ sheetObj.CellValue(jdx,"s_ts1_lane") +"/"+ sheetObj.CellValue(jdx,"s_ts1_port") +"/"+ sheetObj.CellValue(jdx,"s_ts2_lane") +"/"+ sheetObj.CellValue(jdx,"s_ts2_port") +"/"+ sheetObj.CellValue(jdx,"s_ts3_lane") +"/"+ sheetObj.CellValue(jdx,"s_ts3_port") +"/"+ sheetObj.CellValue(jdx,"s_ts4_lane") +"/"+ sheetObj.CellValue(jdx,"s_pod");
  				
  				if( idxStr == jdxStr ){
  					dupArr[dupCnt] = idx;
  					dupCnt++;
  					dupArr[dupCnt] = jdx;
  					dupCnt++;
  				}
  			}
  		}
  		
  		if( dupArr.length != 0 ){
  			if( firstLoad == true ){
  				firstLoad = false;
  				for( idx = 0; idx < dupArr.length; idx++ ){
  					sheetObj.CellValue2(dupArr[idx],"s_chk") = "0";
		  			sheetObj.CellValue2(dupArr[idx],"s_err_tp") = "Y";
		  			sheetObj.CellValue2(dupArr[idx],"s_err_desc") = "E98";
		  		}
  			} else{
		  		for( idx = 0; idx < dupArr.length; idx++ ){
		  			sheetObj.CellValue2(dupArr[idx],"s_err_tp") = "Y";
		  			sheetObj.CellValue2(dupArr[idx],"s_err_desc") = "E98";
		  		}
  			}
	  		return false;
  		} else{
  			return true;
  		}
  		
//  		sheetObj.SpaceDupCheck = false;
////  		var dupResult = sheetObj.ColValueDupRows("full_rout");
//  		var dupResult = sheetObj.ColValueDupRows("s_pol|s_ts1_lane|s_ts1_port|s_ts2_lane|s_ts2_port|s_ts3_lane|s_ts3_port|s_ts4_lane|s_pod");
//  		var dupArr = dupResult.split(",");
//  		alert(dupResult);
//  		alert(dupArr.length);
//
//  		if( dupResult != "" ){
//	  		for( var idx = 0; idx < dupArr.length; idx++ ){
//	  			sheetObj.CellValue2(dupArr[idx],"s_err_tp") = "Y";
//	  			sheetObj.CellValue2(dupArr[idx],"s_err_desc") = "E98";
//	  		}
//	  		return false;
//  		} else{
//  			return true;
//  		}
  	}
    
    