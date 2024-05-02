/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0060.js
*@FileTitle : oceanroute management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.24 김귀진
* 1.0 Creation
* CSR : CHM-201005409-01 : OCEAN ROUTE CREATION시, Dummy Ocean Route 생성 방지를 위한 Validation 추가요청.
* 2011.07.29 이수진 [CHM-201111687] Ocean Route Management에 대한 부분 Logic 변경 및 보완 요청  - Del, Chk가 되지 않은 Row는 저장되지 않도록 Validation 추가 - 데이타 중복시 Error Msg 보여주고 데이타 저장되지 않도록 로직 수정
* 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
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
     * @class ESD_PRD_0060 : ESD_PRD_0060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */


function ESD_PRD_0060() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.inputChk				= inputChk;
	this.chkTempRmk				= chkTempRmk;
	this.getLnkCnt				= getLnkCnt;
	this.mandatoryChk			= mandatoryChk;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.sheet1_OnChange		= sheet1_OnChange;
//	this.calStTime				= calStTime;
//	this.getLinkCnt				= getLinkCnt;
	this.validateForm			= validateForm;
//	this.changeSelect			= changeSelect;
	this.selectLane				= selectLane;
	this.getLane1				= getLane1;
	this.getLane2				= getLane2;
	this.getLane3				= getLane3;
	this.getLane4				= getLane4;
	
	
}

//* csr N200903120230 20080414  [PRD] Ocean Route 기능 보완
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
       
         var formObject = document.form;

    	try {
    		//var srcName = window.event.srcElement.getAttribute("id");
    		var srcName = window.event.srcElement.getAttribute("name");
    		
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;
         
            /****************************/
            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
    	            
        	        break;

        	    case "btn_save":        	    	
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btn_downexcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_rowcopy":
      	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
      	            sheetObject.CellEditable(sheetObject.SelectRow,"s_chk") = true;
      	            sheetObject.CellValue2(sheetObject.SelectRow,"s_insert_flag") = 'N';
      	            sheetObject.CellValue2(sheetObject.SelectRow,"s_c_user") = '';
      	            sheetObject.CellValue2(sheetObject.SelectRow,"s_c_date") = '';
        	        break;

				case "btn_tnk_lane_cd":
    	            selectLane('lane1');
        	        break;
        	        
				case "btn_1st_lane_cd":
					selectLane('lane2');
					break;
					
				case "btn_2nd_lane_cd":
					selectLane('lane3');
					break;
					
				case "btn_3rd_lane_cd":
					selectLane('lane4');
					break;

				case "btn_close":
      	            self.close();
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
      //CHM-201005409-01 의거 추가
      if(CRUD == "R") {
			ComBtnDisable("btn_new");
			ComBtnDisable("btn_save");
			ComBtnDisable("btng_rowadd");
			ComBtnDisable("btng_rowcopy");
		}

		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'lane1', 'lane2', 'lane3','lane4');
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
                    style.height = 320 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(73, 4, 0, true); //67

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "SEQ|Del.|CHK|STS|Ocean\nFlag|Rmk|Rmk|Priority|POL|Lane|SVC\nType|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hour)|S/Time\n(Day)|T/Time\n(Day/Hour)|Flag|C.Date|C.User|Insert Flag"; //|sFU|sRoutSeq|sTTime|sTTDy|sTTHr|sTT1|sTT2|sTT3|sTT4|sSTime|sSTDy|sSTHr|sST1|sST2|sST3|sPol1|sPod1|sDir1|sFdrFlg1|sPol2|sPod2|sDir2|sFdrFlg2|sPol3|sPod3|sDir3|sFdrFlg3|sPol4|sPod4|sDir4|sFdrFlg4|sTsIndCd|sPod1Etb|sPol2Etb|sPod2Etb|sPol3Etb|sPod3Etb|sPol4Etb|sLnkCnt|sUpdIndCd|sRowCopyFlg|sDoubtFlg|sDupAllow";
                    var HeadTitle1 = "SEQ|Del.|CHK|STS|Ocean\nFlag|Type|Note|Priority|POL|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|POD|T/Time\n(Day/Hour)|S/Time\n(Day)|T/Time\n(Day/Hour)|Flag|C.Date|C.User|Insert Flag";
                                  
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ ROW,     COL, DATATYPE,   WIDTH, 	DATAALIGN, COLMERGE, SAVENAME,  		 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,    "s_seq",            false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtDelCheck,   50,    daCenter,  true,    "s_del",            false,          "",       dfNone,     0,     true,        true,		-1,		false, 		true, 		"", 	true);
                    InitDataProperty(0, cnt++ , dtCheckBox,   50,    daCenter,  true,    "s_chk",            false,          "",       dfNone,     0,     true,        true,		-1, 	false, 		true, 		"", 	false);
                    InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,    "ibflag",           false,          "",       dfNone,     0,     true,        true);
                    //ROUTE FLAG: Standard/Temp/Add
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    "s_route_flg",      true,           "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtCombo,      80,    daLeft,  	true,    "s_route_rmk",      false,          "",       dfNone, 	   0,     true,        true);
                    InitDataProperty(0, cnt++ , dtData,       100,   daLeft,  	true,    "s_route_note",     false,          "",       dfNone, 	   0,     false,       false);
                    InitDataProperty(0, cnt++ , dtCombo,      60,    daCenter,  true,    "s_prior",          true,           "",       dfNone,     0,     false,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "s_pol",            true,           "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "s_ts1_lane",       true,           "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "s_ts1_type",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  50,    daCenter,  true,    "s_ts1_port",       false,          "",       dfNone,     0,     false,       true,		5);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "s_ts2_lane",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "s_ts2_type",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  50,    daCenter,  true,    "s_ts2_port",       false,          "",       dfNone,     0,     false,       true,		5);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "s_ts3_lane",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "s_ts3_type",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  50,    daCenter,  true,    "s_ts3_port",       false,          "",       dfNone,     0,     false,       true,		5);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,    "s_ts4_lane",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "s_ts4_type",       false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,  50,    daCenter,  true,    "s_pod",            true,           "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "fmt_tot_tt",       false,          "",dfUserFormat2,     0,     false,       true,		-1,		false, 		true, 		"", 	true,		"IUD",		true);
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "fmt_tot_st",       false,          "",dfUserFormat2,     0,     false,       true,		-1,		false, 		true, 		"", 	true,		"IUD",		true);
                    
                    // Hidden Fields
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "tot_tt_st",        false,          "",dfUserFormat2,     0,     false,       true,		-1,		false, 		true, 		"", 	true,		"IUD",		true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "val_flg",          false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_c_date",         false,          "",       dfDateYmd,  0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_c_user",         false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_f_u",            true,           "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_rout_seq",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_t_time",         false,          "|s_n1st_tztm_hrs|+|s_n2nd_tztm_hrs|+|s_n3rd_tztm_hrs|+|s_n4th_tztm_hrs|",       dfNone,    0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     75,    daCenter,  true,    "s_t_t_dy",         false,          "Int(|s_t_time|/24)",       dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     75,    daCenter,  true,    "s_t_t_hr",         false,          "|s_t_time|%24",       dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_n1st_tztm_hrs",  false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_n2nd_tztm_hrs",  false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_n3rd_tztm_hrs",  false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_n4th_tztm_hrs",  false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     75,    daCenter,  true,    "s_s_time",         false,          "|s_n1st_stay_tm_hrs|+|s_n2nd_stay_tm_hrs|+|s_n3rd_stay_tm_hrs|",       dfNone,   0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,     75,    daCenter,  true,    "s_s_t_dy",         false,          "Int(|s_s_time|/24)",       dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     75,    daCenter,  true,    "s_s_t_hr",         false,          "|s_s_time|%24",       dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_n1st_stay_tm_hrs", false,          "",     dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_n2nd_stay_tm_hrs", false,          "",     dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_n3rd_stay_tm_hrs", false,          "",     dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pol1",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pod1",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_dir1",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_fdr_flg1",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pol2",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pod2",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_dir2",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_fdr_flg2",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pol3",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pod3",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_dir3",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_fdr_flg3",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pol4",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pod4",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_dir4",           false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_fdr_flg4",       false,          "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_ts_ind",         false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pod1_etb",       false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pol2_etb",       false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pod2_etb",       false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pol3_etb",       false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pod3_etb",       false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_pol4_etb",       false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_lnk_cnt",        false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_upd_ind_cd",     false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     70,    daCenter,  true,    "s_row_copy_flg",   false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     20,    daCenter,  true,    "s_doubt_flg",      false,          "",       dfNone,     0,     true,        true);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  false,   "s_dup_allow",      false,          "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtHidden,     20,    daCenter,  true,    "s_insert_flag",    false,          "",       dfNone,     0,     true,        true);
                    
                    InitDataProperty(0, cnt++,  dtHidden,    100,    daCenter,  true,    "s_ocn_rout_tmp_exp_dt",false,          "",       dfDateYmd,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  false,   "s_ocn_rout_tmp_flg",   false,          "",       dfNone,	    0,     false,      false);
                    // sRmk 의 dtComboEdit 의  TEXT 가 보이게 셋팅 
                    InitComboNoMatchText(true);

		            InitDataCombo (0, "s_prior", " |1|2|3|4|5|6|7|8|9|10", " |1|2|3|4|5|6|7|8|9|10");
		            InitDataCombo (0, "s_f_u", " |Y|N", " |Y|N");
		            InitDataCombo (0, "s_route_flg", " |Guide|Standard|Temporary|Validation", " |G|S|T|V");
		            InitDataCombo (0, "s_route_rmk", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others");   // 20090317
					InitDataValid(0, "s_pol",        vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts1_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts1_port",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts2_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts2_port",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts3_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts3_port",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts4_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_pod",        vtEngUpOther, "1234567890");
					InitUserFormat2(0, "fmt_tot_tt", "##D-##H", "D|-|H" );
					InitUserFormat2(0, "fmt_tot_st", "##D-##H", "D|-|H" );
					InitUserFormat2(0, "tot_tt_st", "##D-##H", "D|-|H" );

		            RangeBackColor(1, 6, 1, 15) = RgbColor(222, 251, 248);   // alps
		            HeadRowHeight = 20 ;
		            
		            WaitImageVisible=false;
                }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var uid ;
    	var sXml ;
	    sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction));
				getLnkCnt(formObj);
				if(!ComChkRequired(formObj)) return;
				//check exception
				if(!CheckExceptionFlag(formObj)) return;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_PRD_0060GS.do", PrdFQString(formObj));
				ComOpenWait(false);
				
				break;
            case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction));
                if(!inputChk(sheetObj)) {
                    return;
                }                
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI;
                
                var bSaveSuccess = sheetObj.DoSave("ESD_PRD_0060GS.do", PrdFQString(formObj));
                
                ComOpenWait(false);  
                
                if (!bSaveSuccess) { // ui에서 실패
                	return;
                }

                break;

           case IBINSERT:      // 입력
				var iRow = sheetObj.DataInsert();
                sheetObj.CellEditable(iRow,"s_del") = false;
      	        sheetObj.CellBackColor(iRow,"s_del") = -1;
      	        sheetObj.CellValue2(iRow,"s_insert_flag") = 'N' ;
      	        sheetObj.CellEditable(iRow, "s_route_flg") = true;
      	        if( formObj.expt_flag.checked ){
      	        	
      	        	sheetObj.CellValue(iRow,"s_route_flg")='T';
      	        	sheetObj.CellEditable(iRow, "s_route_flg") = false;
      	        } 
				break;

			case IBCOPYROW:        //행 복사
				var Row = sheetObj.DataCopy();
				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case IBLOADEXCEL:        //엑셀 업로드
				sheetObj.LoadExcel();
				break;
           case SEARCH01:
              formObj.f_cmd.value = SEARCH01;  
              uid= "ESD_PRD_0004";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;
           case SEARCH07:
              formObj.f_cmd.value = SEARCH07;

              uid= "ESD_PRD_0033";
              sXml = sheetObj.GetSaveXml("PRD_VALIDATE.do","uid="+uid+"&check_data="+validateData+"&"+PrdFQString(formObj));  
              
              sheetObj.LoadSearchXml(sXml,true, -1, true);
              retValidate = sheetObjects[0].EtcData("rowCount");
              
              break;
        }
    }

    function inputChk(sheetObj) {    	
    	if(!chkTempRmk(sheetObj)) {
            ComShowMessage(ComGetMsg('PRD90107'));
            return false;
        }
        
        if(!chkDataValid(sheetObj)) {
            ComShowMessage(ComGetMsg('PRD90026'));
            return false;
        }

        if(!otherFlagChk(sheetObj)){   
            ComShowMessage(ComGetMsg('PRD90124'));
            return false;
        } 

		// mgpark (체크된 것이 하나도 없을 경우 그냥 에러메시지 내고 대기한다.
		if (sheetObj.CheckedRows("s_chk") == 0 && sheetObj.CheckedRows("s_del") == 0) {
			ComShowCodeMessage('COM130503');
			return;
		}

        for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
        	
        	if(sheetObj.CellValue(i,"s_chk")!= 1 && sheetObj.CellValue(i,"s_del")!= 1){    //2011.07.29 작업
        		sheetObj.RowStatus(i) = "R";                 
        	}
        	
        }
        return true;
            
    }
    
    /**
     * Temp Route일 경우 Route Remark를 입력했는지 검사한다.
     * @param sheetObj
     * @return
     */
	function chkTempRmk(sheetObj){
	    if(sheetObj.CheckedRows("s_chk")>0) {
    		var checkedRow = sheetObj.FindCheckedRow("s_chk");
    		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){

        	    // tempflg Check
        	    
                if( sheetObj.CellValue(i,"s_chk")==1 && sheetObj.CellValue(i, "s_route_flg") == "T"){                	
                    if( ComTrim(sheetObj.CellValue(i, "s_route_rmk")) == "") {                    	
                        return false;
                    }  ;
                }                
            }
           return true;
	    }
        return true;
	    
	}
	
	function chkDataValid(sheetObj){
	    if(sheetObj.CheckedRows("s_chk")>0) {

    		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                if( sheetObj.CellValue(i,"s_chk")==1 && sheetObj.CellValue(i, "val_flg") != "Y"){                	
                  	return false;
                }
            }
           return true;
	    }
        return true;
	    
	}
	
    /**
    * save 전에 Type이 "The Ohter"이면서 Note가 null 인 경우 Message 처리
    * @return
    */
   function otherFlagChk(sheetObj){
	   if(sheetObj.CheckedRows("s_chk")>0) {
   		var checkedRow = sheetObj.FindCheckedRow("s_chk");
   		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){

       	    // tempflg Check
       	    
               if( sheetObj.CellValue(i,"s_chk")==1 && sheetObj.CellValue(i, "s_route_rmk") == "The Others"  && 
            	   ComTrim(sheetObj.CellValue(i, "s_route_note")) == "" ){  
            	   
                       return false;
               }                
           }
          return true;
	    }
       return true;
   }
   
              
	
	/**
	 * 조회조건의 link개수를 기록한다.
	 * @param formObj
	 * @return
	 */    
    function getLnkCnt(formObj) {
		if(formObj.lane4.value.length >0 ) {
			formObj.lnk_cnt.value = 4;
		} else if(formObj.lane3.value.length >0 ) {
			formObj.lnk_cnt.value = 3;
		} else if(formObj.lane2.value.length >0 ) {
			formObj.lnk_cnt.value = 2;
		} else if(formObj.lane1.value.length >0 ) {
			formObj.lnk_cnt.value = 1;
		} else {
			formObj.lnk_cnt.value = 0;
		}
    }
    
    function mandatoryChk(formObj) {

        if(formObj.pol_port_cd.value.length !=5 && formObj.pod_port_cd.value.length !=5) {
            ComShowMessage(ComGetMsg('PRD90108'));
            return false;
        }
        return true;
    }
    // dtPopupEdit 로 처리 할 경우 팝업오픈 처리
    
    function sheet1_OnPopupClick(sheetObj, row, col)
    {
    	
        var oriLoc  =  "";
        var destLoc =  "";
        
        var lane   =  "";
        var gubun  =  "";
        var tsIdx ="";
        var lastPod = "N";
        var tsProt = "N";
        if( sheetObj.ColSaveName(col)=="s_pod"){
            
            if( sheetObj.CellValue(row,"s_ts3_port").length >0  ) {
        	    tsIdx ='4';
            } else if( sheetObj.CellValue(row,"s_ts2_port").length >0  ) {
        	    tsIdx ='3';       
            } else if( sheetObj.CellValue(row,"s_ts1_port").length >0  ) {
        	    tsIdx ='2';
            } else {                
        	    tsIdx ='1';
            }
    	    oriLoc =  sheetObj.CellValue(sheetObj.SelectRow ,"s_pol"+tsIdx); 
    	    destLoc =  sheetObj.CellValue(sheetObj.SelectRow ,"s_pod"+tsIdx);  
    	    lane   =  sheetObj.CellValue(sheetObj.SelectRow ,"s_ts"+tsIdx+"_lane");           
            gubun = tsIdx; //첫번째 
            lastPod ="Y";
        } else {
            tsProt ='Y';
           
            var idx = sheetObj.ColSaveName(col).substring(4,5); //s_ts3_port
            if ( sheetObj.ColSaveName(col) == "s_ts"+idx+"_port")  {
                gubun = idx; //첫번째 
                oriLoc =  sheetObj.CellValue(sheetObj.SelectRow ,"s_pol"+idx);
                destLoc =  sheetObj.CellValue(sheetObj.SelectRow ,"s_pod"+idx);
                lane   =  sheetObj.CellValue(sheetObj.SelectRow ,"s_ts"+idx+"_lane");
            }
                 
        }
        //var param = '?i_org_cd='+ oriLoc +'&i_dest_cd='+destLoc;
        var param = '?ori_loc='+ oriLoc +'&dest_loc='+ destLoc+'&f_cmd='+ SEARCH +'&lane='+lane+'&gubun='+gubun+"&row=" + sheetObj.SelectRow + "&col=" + sheetObj.SelectCol+"&sTsPort="+tsProt+"&isLastPod="+lastPod;
        myWin = ComOpenWindowCenter('ESD_PRD_0040.do'+param, 'compop', 800, 480, false);
    
      
         myWin.focus();
    }
    
    
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
    		
        sheetObj.ShowDebugMsg = false;
    	
        // Save시 기존 신규인 경우 insert를 위함
        if(sheetObj.CellValue(Row, "s_insert_flag") == 'N'){
       	 sheetObj.RowStatus(Row) = 'I';
        }

        if(sheetObj.CellValue(Row, "s_route_flg") == "T" ) { //&& sheetObj.CellValue(Row, "s_route_rmk") == "The Others") {
	    	sheetObj.CellEditable(Row, "s_route_note") = true;
	    } else {
	    	sheetObj.CellEditable(Row, "s_route_note") = false;
	    }

        if( sheetObj.ColSaveName(Col) == "s_route_flg" && Value == "T") {

            ComShowMessage(ComGetMsg('PRD90102'));
            sheetObj.CellComboItem(Row,"s_route_rmk"," |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customer Problem|Clerical Error|The Others", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customer Problem|Clerical Error|The Others");
            sheetObj.SelectCell(Row, "s_route_rmk");
            sheetObj.CellValue2(Row, "s_route_rmk")='Space Shortage';
         // temp 일 경우 s_ocn_rout_tmp_exp_dt 를 한달로 강제 셋팅해준다. 
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_exp_dt")=ComGetDateAdd(null, "D", 30);
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_flg")='Y';  //jsy
            
        } else if(sheetObj.ColSaveName(Col) == "s_route_flg" && Value != "T") {
            sheetObj.CellComboItem(Row,"s_route_rmk"," ", " ");   
            sheetObj.CellValue2(Row,"s_route_note") = ""; 
            
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_exp_dt")='';
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_flg")='N'; 
        } 
      //jsy 201301 -------------------         
//        else if(sheetObj.ColSaveName(Col) == "s_route_rmk" && Value != "The Others") {
//        	sheetObj.CellValue2(Row, "s_route_note")='';        
//        } else if(sheetObj.ColSaveName(Col) == "s_route_note" && Value != " ") {        	
//        	if(sheetObj.CellValue(Row, "s_route_rmk") != "The Others") {        	
//        		sheetObj.CellValue2(Row, "s_route_note")='';
//        	}
//        }
        
        // S 일때 DROP BOX에서 SELECT 하면 못하게 처리 
        var idx   = sheetObj.GetComboInfo(Row, "s_route_rmk", "SelectedIndex");

        if(  (sheetObj.CellValue(Row, "s_route_flg") != "T" ) &&  (sheetObj.ColSaveName(Col) == "s_route_rmk") && idx >0){
   
            sheetObj.CellValue2(Row, "s_route_rmk")=' '; 
            ComShowMessage(ComGetMsg('PRD90102'));
        }  	    
        if(  (sheetObj.CellValue(Row, "s_route_flg") == "T" ) &&   (sheetObj.ColSaveName(Col) == "s_route_rmk") && idx < 1){

            sheetObj.SelectCell(Row, "s_route_rmk");
            sheetObj.CellValue2(Row, "s_route_rmk")='';
            ComShowMessage(ComGetMsg('PRD90102'));
            
        } 
        
		if( sheetObj.CellValue( sheetObj.SelectRow, "s_insert_flag") == 'N'){ 
			if ( sheetObj.CellValue( sheetObj.SelectRow, "s_chk") == '1'){			
				if( sheetObj.ColSaveName(Col) == "s_pol" || sheetObj.ColSaveName(Col) == "s_ts1_lane" || sheetObj.ColSaveName(Col) == "s_ts1_port" || 
			    	    sheetObj.ColSaveName(Col) == "s_ts2_lane" || sheetObj.ColSaveName(Col) == "s_ts2_port" || sheetObj.ColSaveName(Col) == "s_ts3_lane" ||
			    	    sheetObj.ColSaveName(Col) == "s_ts3_port" || sheetObj.ColSaveName(Col) == "s_ts4_lane" || sheetObj.ColSaveName(Col) == "s_pod"){							
			    	    		sheetObj.CellValue( sheetObj.SelectRow, "s_chk") = "0";
								ComShowMessage(ComGetMsg('PRD90123'));
			    	}
			}
		}
		
		
        if( sheetObj.ColSaveName(Col) == "s_chk") {
        	
        	if( sheetObj.CellValue( sheetObj.SelectRow, "s_insert_flag") == 'N'){ // 새로운 Row를 Insert 한 경우
        		// mgpark (완성되지 않은 Route는 검사할 필요도 없고, check해서 저장할 필요도 없다.
        		// mgpark 유효한 Route가 아닐 경우 Uncheck한다.
        		if (sheetObj.CellValue(sheetObj.SelectRow, "val_flg") != "Y" ) {
        			ComShowMessage(ComGetMsg('PRD90026'));
        			sheetObj.CellValue2(sheetObj.SelectRow, "s_chk") = 0;
        			return;
        		}
            	
        		if(Value == "1"){ // Check Button이 Check 된 경우   
					 var resultXml = sheetObj.GetSearchXml("ESD_PRD_0060GS.do", "f_cmd="+SEARCH12+"&s_pol="+sheetObj.CellValue(Row, "s_pol") +"&s_pod="+sheetObj.CellValue(Row, "s_pod") 
                             +"&s_pol1="+sheetObj.CellValue(Row,"s_pol1") + "&s_pod1="+sheetObj.CellValue(Row, "s_pod1")+ "&s_ts4_lane="+sheetObj.CellValue(Row, "s_ts4_lane")+ "&s_dir1="+sheetObj.CellValue(Row, "s_dir1")
                             +"&s_ts1_port="+sheetObj.CellValue(Row,"s_ts1_port") + "&s_pod2="+sheetObj.CellValue(Row, "s_pod2")+ "&s_ts1_lane="+sheetObj.CellValue(Row, "s_ts1_lane")+ "&s_dir2="+sheetObj.CellValue(Row, "s_dir2")
                             +"&s_ts2_port="+sheetObj.CellValue(Row,"s_ts2_port") + "&s_pod3="+sheetObj.CellValue(Row, "s_pod3")+ "&s_ts2_lane="+sheetObj.CellValue(Row, "s_ts2_lane")+ "&s_dir3="+sheetObj.CellValue(Row, "s_dir3")
                             +"&s_ts3_port="+sheetObj.CellValue(Row,"s_ts3_port") + "&s_pod4="+sheetObj.CellValue(Row, "s_pod4")+ "&s_ts3_lane="+sheetObj.CellValue(Row, "s_ts3_lane")+ "&s_dir4="+sheetObj.CellValue(Row, "s_dir4")
                             +"&s_route_flg="+sheetObj.CellValue(Row,"s_route_flg")+"&s_route_rmk="+sheetObj.CellValue(Row,"s_route_rmk")+"&s_route_note="+sheetObj.CellValue(Row,"s_route_note")+ "&" +PrdFQString(document.form) ) ;
					 
					 sheetObj.LoadSearchXml(resultXml,true, -1, true);
        			 var dup_chk = ComGetEtcData(resultXml, "dup_flag");
        			 var err_cd = ComGetEtcData(resultXml, "ERR_CD");
        			 if ( err_cd != "N") {
        				 sheetObj.CellValue( sheetObj.SelectRow, "s_chk") = "0";
        			 }
        			 if (dup_chk =="Y") {
        				 ComShowMessage(ComGetMsg('PRD90125'));
        				 sheetObj.CellValue( sheetObj.SelectRow, "s_chk") = "0";
        			 }else if(dup_chk=="N"){   
        				 // 중복되지 않은 신규 Router 임으로 Skip.  
        				 //JSY 20131105 POD Overlap Error 체크 
//        				 var pod = sheetObj.CellValue(Row, "s_pod");
//        				 var ts1_port = sheetObj.CellValue(Row,"s_ts1_port");
//        				 var ts2_port = sheetObj.CellValue(Row,"s_ts2_port");
//        				 var ts3_port = sheetObj.CellValue(Row,"s_ts3_port");
//        				 if( pod == ts1_port || pod == ts2_port || pod == ts3_port){
//        					 alert('POD Overlap Error');
//        					 sheetObj.CellValue( sheetObj.SelectRow, "s_chk") = "0";
//        				 }
        				 
        				 
        				 
        			 }
        			
        		}else{
        			// 새로 Insert 후에 Uncheck 한 경우        			
        		}
        		
        	}else if(sheetObj.CellValue( sheetObj.SelectRow, "s_insert_flag") != 'N'){        	
	            if(Value == "1"){            	
	                 sheetObj.RowStatus(Row) = "I";
	
	                sheetObj.DoRowSearch("ESD_PRD_0032_ROW_GS.do", "f_cmd="+SEARCH11+"&org_loc_cd="+sheetObj.CellValue(Row, "s_pol") +"&dest_loc_cd="+sheetObj.CellValue(Row, "s_pod") 
	                                                         +"&n1st_pol_cd="+sheetObj.CellValue(Row,"s_pol1") + "&n1st_pod_cd="+sheetObj.CellValue(Row, "s_pod1")+ "&n1st_lane_cd="+sheetObj.CellValue(Row, "s_ts1_lane")
	                                                         +"&n2nd_pol_cd="+sheetObj.CellValue(Row,"s_pol2") + "&n2nd_pod_cd="+sheetObj.CellValue(Row, "s_pod2")+ "&n2nd_lane_cd="+sheetObj.CellValue(Row, "s_ts2_lane")
	                                                         +"&n3rd_pol_cd="+sheetObj.CellValue(Row,"s_pol3") + "&n3rd_pod_cd="+sheetObj.CellValue(Row, "s_pod3")+ "&n3rd_lane_cd="+sheetObj.CellValue(Row, "s_ts3_lane")
	                                                         +"&n4th_pol_cd="+sheetObj.CellValue(Row,"s_pol4") + "&n4th_pod_cd="+sheetObj.CellValue(Row, "s_pod4")+ "&n4th_lane_cd="+sheetObj.CellValue(Row, "s_ts4_lane")
	                                                         +"&row="+Row+"&col="+Col );
	                                                         
	                if(sheetObj.EtcData("rowCount")==0) {
	            	    sheetObj.CellValue2(Row,"s_doubt_flg")="";
	            	    sheetObj.CellValue2(Row,"s_dup_allow")="";
	            	} else {
	                    if(sheetObj.CellValue(Row, "s_doubt_flg") == "Y"){
	                      
	                        if(!CONFIRM(ComGetMsg('PRD90053'))){
	                            sheetObj.CellValue2(Row , "s_chk" ) = "0";
	                        } else {
	                            sheetObj.CellValue2(Row , "s_dup_allow" ) = "Y";
	                        }
	                    }	            	    
	            	}
	            	
	                sheetObj.CellEditable(Row,"s_route_flg") = true;
	                sheetObj.CellEditable(Row,"s_route_rmk") = true;
	              
	                
	            } else {
	                 sheetObj.CellValue2(Row, "s_dup_allow") = "";
	                 sheetObj.RowStatus(Row) = "R";
	                 sheetObj.CellEditable(Row,"s_route_flg") = false;
	                 sheetObj.CellEditable(Row,"s_route_rmk") = false;
	            }     
        	}
        }
        
         if(Value == "V") {
            ComShowMessage(ComGetMsg('PRD90104','Validation'));
            sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");
            return;
         }	
         // CHM-201005409-01 의거 추가      
         if(Value == "G" ) {
	            if(OCN_FLG !='S'){
	            	ComShowMessage(ComGetMsg('PRD90104','Guide'));
	            	sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");	                
	            }else {
	                sheetObj.CellValue2(Row,"s_prior") = 1;
	            }
	            return;
         }
         
         //2011.09.08 변종건
         var colNm = sheetObj.ColSaveName(Col);
         if( colNm=="s_pol" || colNm=="s_ts1_port" || colNm=="s_ts2_port"|| colNm=="s_ts3_port" || colNm =="s_pod"
        	 || colNm=="s_ts1_lane" || colNm=="s_ts2_lane" || colNm=="s_ts3_lane" || colNm=="s_ts4_lane" ){
        	 
        	 var param = "f_cmd="+SEARCH02 +"&s_pol="+sheetObj.CellValue(Row,"s_pol") +"&s_ts1_port="+sheetObj.CellValue(Row,"s_ts1_port")
        	 			+"&s_ts2_port="+sheetObj.CellValue(Row,"s_ts2_port") +"&s_ts3_port="+sheetObj.CellValue(Row,"s_ts3_port")
        	 			+"&s_pod="+sheetObj.CellValue(Row,"s_pod") +"&s_ts1_lane="+sheetObj.CellValue(Row,"s_ts1_lane") +"&s_ts2_lane="+sheetObj.CellValue(Row,"s_ts2_lane")
        	 			+"&s_ts3_lane="+sheetObj.CellValue(Row,"s_ts3_lane") +"&s_ts4_lane="+sheetObj.CellValue(Row,"s_ts4_lane");

        	 var resultXml = sheetObj.GetSearchXml("ESD_PRD_0060GS.do", param );

        	 sheetObj.CellValue2(Row,"s_prior") 	= ComGetEtcData(resultXml, "prio");
        	 sheetObj.CellValue2(Row,"s_pol1") 		= ComGetEtcData(resultXml, "pol1");
        	 sheetObj.CellValue2(Row,"s_pol2") 		= ComGetEtcData(resultXml, "pol2");
        	 sheetObj.CellValue2(Row,"s_pol3") 		= ComGetEtcData(resultXml, "pol3");
        	 sheetObj.CellValue2(Row,"s_pol4") 		= ComGetEtcData(resultXml, "pol4");
        	 sheetObj.CellValue2(Row,"s_pod1") 		= ComGetEtcData(resultXml, "pod1");
        	 sheetObj.CellValue2(Row,"s_pod2") 		= ComGetEtcData(resultXml, "pod2");
        	 sheetObj.CellValue2(Row,"s_pod3") 		= ComGetEtcData(resultXml, "pod3");
        	 sheetObj.CellValue2(Row,"s_pod4") 		= ComGetEtcData(resultXml, "pod4");
        	 sheetObj.CellValue2(Row,"s_dir1") 		= ComGetEtcData(resultXml, "dir1");
        	 sheetObj.CellValue2(Row,"s_dir2") 		= ComGetEtcData(resultXml, "dir2");
        	 sheetObj.CellValue2(Row,"s_dir3") 		= ComGetEtcData(resultXml, "dir3");
        	 sheetObj.CellValue2(Row,"s_dir4") 		= ComGetEtcData(resultXml, "dir4");
        	 sheetObj.CellValue2(Row,"s_fdr_flg1") 	= ComGetEtcData(resultXml, "fdr_flg1");
        	 sheetObj.CellValue2(Row,"s_fdr_flg2") 	= ComGetEtcData(resultXml, "fdr_flg2");
        	 sheetObj.CellValue2(Row,"s_fdr_flg3") 	= ComGetEtcData(resultXml, "fdr_flg3");
        	 sheetObj.CellValue2(Row,"s_fdr_flg4") 	= ComGetEtcData(resultXml, "fdr_flg4");
        	 sheetObj.CellValue2(Row,"s_ts1_type") 	= ComGetEtcData(resultXml, "svc_tp1");
        	 sheetObj.CellValue2(Row,"s_ts2_type") 	= ComGetEtcData(resultXml, "svc_tp2");
        	 sheetObj.CellValue2(Row,"s_ts3_type") 	= ComGetEtcData(resultXml, "svc_tp3");
        	 sheetObj.CellValue2(Row,"s_ts4_type") 	= ComGetEtcData(resultXml, "svc_tp4");
        	 sheetObj.CellValue2(Row,"fmt_tot_tt")	= ComGetEtcData(resultXml, "fmt_tot_tt");
        	 sheetObj.CellValue2(Row,"fmt_tot_st")	= ComGetEtcData(resultXml, "fmt_tot_st");
        	 sheetObj.CellValue2(Row,"tot_tt_st")	= ComGetEtcData(resultXml, "fmt_tt");
        	 sheetObj.CellValue2(Row,"s_f_u")		= ComGetEtcData(resultXml, "fdr_usd");
        	 sheetObj.CellValue2(Row,"s_lnk_cnt")   = ComGetEtcData(resultXml, "link_cnt");
        	 sheetObj.CellValue2(Row,"s_upd_ind_cd")= ComGetEtcData(resultXml, "upd_ind_cd");
        	 
        	 sheetObj.CellValue2(Row,"val_flg") 			= ComGetEtcData(resultXml, "link_valid_flg");
        	 sheetObj.CellValue2(Row,"s_n1st_tztm_hrs") 	= ComGetEtcData(resultXml, "tt1");
        	 sheetObj.CellValue2(Row,"s_n2st_tztm_hrs") 	= ComGetEtcData(resultXml, "tt2");
        	 sheetObj.CellValue2(Row,"s_n3st_tztm_hrs") 	= ComGetEtcData(resultXml, "tt3");
        	 sheetObj.CellValue2(Row,"s_n4st_tztm_hrs") 	= ComGetEtcData(resultXml, "tt4");
        	 sheetObj.CellValue2(Row,"s_n1st_stay_tm_hrs") 	= ComGetEtcData(resultXml, "st1");
        	 sheetObj.CellValue2(Row,"s_n2st_stay_tm_hrs") 	= ComGetEtcData(resultXml, "st2");
        	 sheetObj.CellValue2(Row,"s_n3st_stay_tm_hrs") 	= ComGetEtcData(resultXml, "st3");

         }
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){      
    	  switch(sAction) {

             case IBSAVE:      //2015 PHR  on_change 없이 저장 시 standard flag 일 때 tmp_flg='N' 처리
        		for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
	            	if(sheetObj.CellValue(idx,"s_route_flg")=='T') {
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'Y';
	            	}else if(sheetObj.CellValue(idx,"s_route_flg")!='T') {  
	            		sheetObj.CellValue2(idx, "s_ocn_rout_tmp_flg")= 'N';
        	     	} 
                }
            return true;
    	  }
    	  }


	/**
	 * Lane코드를 조회하기 위한 팝업창을 호출한다.
	 * @param tgt
	 * @return
	 */
	function selectLane(tgt) {
		var frm = document.form;
		var param = '?classId=' + 'COM_ENS_081';
		if(tgt == 'lane1') param = param + '&lane_cd='+frm.lane1.value;
		if(tgt == 'lane2') param = param + '&lane_cd='+frm.lane2.value;
		if(tgt == 'lane3') param = param + '&lane_cd='+frm.lane3.value;
		if(tgt == 'lane4') param = param + '&lane_cd='+frm.lane4.value;
		ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane'+tgt.substr(4,1) , "1,0,1,1,1,1,1,1,1,1,1,1", true);
	
	}

	/**
	 * Lane Code조회에 의한 값을 조회조건에 설정한다.
	 * @param rowArray
	 * @return
	 */
	function getLane1(rowArray) {
		var colArray = rowArray[0];
    	document.form.lane1.value = colArray[3];
    } 
	
	/**
	 * Lane Code조회에 의한 값을 조회조건에 설정한다.
	 * @param rowArray
	 * @return
	 */
	function getLane2(rowArray) {
		var colArray = rowArray[0];
		document.form.lane2.value = colArray[3];
	} 
	
	/**
	 * Lane Code조회에 의한 값을 조회조건에 설정한다.
	 * @param rowArray
	 * @return
	 */
	function getLane3(rowArray) {
		var colArray = rowArray[0];
		document.form.lane3.value = colArray[3];
	} 
	
	/**
	 * Lane Code조회에 의한 값을 조회조건에 설정한다.
	 * @param rowArray
	 * @return
	 */
	function getLane4(rowArray) {
		var colArray = rowArray[0];
		document.form.lane4.value = colArray[3];
	} 

	/**
	 * 저장후 이벤트를 처리한다.
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){   
    	if (ErrMsg != '') { return; } // 시스템 오류 등, 예기치 않은 서버오류에 의한 메시지가 왔을 경우 해당에서 처리한다.
    	
    	var formObj = document.form;
    	 var rowcount = sheetObj.RowCount;

    	 var flg = 0;
    	 for(k=0 ; k<= rowcount ; k++){
    		 if(sheetObj.RowStatus(k)== 'I'){
    			 flg++;
    		 }
    	 }
    	if(flg == 0) {    		
    		ComShowMessage("Data" + ComGetMsg('COM130102'));                
            self.close();            
    	}
    }   
    
    
    function checkExptFlag() {
        var frm = document.form;
        sheetObjects[0].RemoveAll();
        if(frm.expt_flag.checked ) {
        	
        	ComShowMessage('Please be informed that the right process is creating one more BKG over ship back route.');
        }

    }
    function CheckExceptionFlag(formObj) {
    	if(formObj.expt_flag.checked ) {
    		ComShowMessage('Please uncheck Allow Exception. ');
    		return false;
    	}
    	return true;
    }
    
    