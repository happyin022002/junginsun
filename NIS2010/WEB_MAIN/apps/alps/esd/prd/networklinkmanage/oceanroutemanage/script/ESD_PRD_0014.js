/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0014.js
*@FileTitle : oceanroute management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김귀진
*@LastVersion : 1.0 
* 2009.07.24 김귀진
* 1.0 Creation
* 2010.08.24. CSR : CHM-201005409-01 : OCEAN ROUTE CREATION시, Dummy Ocean Route 생성 방지를 위한 Validation 추가요청.
* 2010.10.21 채창호 [CHM-201006410-01] : HQ Link Management Logic 변경 요청
* 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
* 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
* 2012.11.06 정선용 CHM-201221041 [PRD] Ocean Route Optimisation
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
     * @class ESD_PRD_0014 : ESD_PRD_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */



function ESD_PRD_0014() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject			= setSheetObject;
	this.loadPage				= loadPage;
	this.prdComKeyDown			= prdComKeyDown;
	this.initSheet				= initSheet;
	this.ocnFlagChk				= ocnFlagChk;
	this.otherFlagChk           = otherFlagChk;
	this.doActionIBSheet		= doActionIBSheet;
	this.mandatoryChk			= mandatoryChk;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.validateForm			= validateForm;
	this.changeSelect			= changeSelect;
	this.selectLane				= selectLane;
	this.getLane				= getLane;
	this.selectPort				= selectPort;
	this.getCOM_ENS_051			= getCOM_ENS_051;
	this.doOpenPopup			= doOpenPopup;
	this.ocnRoutSave			= ocnRoutSave;
	this.sheet1_OnChange		= sheet1_OnChange;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
	this.sheet1_OnSaveEnd		= sheet1_OnSaveEnd;
}
//* csr N200903120230 20080414  [PRD] Ocean Route 기능 보완
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
var popWin = '';

var iPage =1 ;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
//              if(srcName != null && !ComIsEmpty(srcName)) {
//            	  var btnDis = eval("document.getElementById('" + srcName + "').disabled");
//                  if (btnDis) return;
//              }
            /****************************
             enterKey 처리
            *****************************/
            var srcObj=window.event.srcElement.nodeName;
            var keyObj=window.event.keyCode;

            /****************************/
            switch(srcName) {

        	    case "btn_retrieve":        	    	
        	    	if(!checkInput()) return false;
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
        	        
        	    case "btn_uploadexcel":
        	    	doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
        	        break;

           	    case "btn_multi":
    	            doOpenPopup(sheetObject,formObject,'multi');
    	            break;
    	            
           	    case "btn_auto":
    	            doOpenPopup(sheetObject,formObject,'auto');
    	            break;

           	    case "btn_manu":
    	            doOpenPopup(sheetObject,formObject,'manual');
        	        break;

           	    case "btng_pcgeneral":
    	            document.location.href="ESD_PRD_0020.do?pgmNo=ESD_PRD_0020";
        	        break;

           	    case "btng_laneconnection":
    	            document.location.href="ESD_PRD_0033.do?pgmNo=ESD_PRD_0033";
            
        	        break;


				/*****************************************************/

				case "btn_pol_port_cd":
    	            selectPort(formObject, 'POL');
        	        break;

				case "btn_pod_port_cd":
    	            selectPort(formObject, 'POD');
        	        break;

				case "btn_tnk_lane_cd":
    	            selectLane();
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
       
		if(CRUD == "R") {
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_auto");
			ComBtnDisable("btn_downexcel");
			ComBtnDisable("btn_uploadexcel");
			ComBtnDisable("btn_manu");
			ComBtnDisable("btn_multi");
//			ComEnableObject(document.getElementById("btn_save"), false);
//			ComEnableObject(document.getElementById("btn_auto"), false);
//			ComEnableObject(document.getElementById("btn_downexcel"), false);
//			ComEnableObject(document.getElementById("btn_manu"), false);
//			ComEnableObject(document.getElementById("btn_multi"), false);
		}
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'pol_port_cd', 'pod_port_cd', 'ts_port_cd','tnk_lane_cd');
		axon_event.addListener('keydown', 'prdComKeyDown' , 'pol_port_cd', 'pod_port_cd', 'tnk_lane_cd');
	}
    
	/**
	 * tab event처리
	 * @return
	 */
	function prdComKeyDown(){
		var keyObj=window.event.keyCode;
    	
     	if(keyObj == 9){ // 탭을 할때만 처리하기 때문에, Tab Index에 해당하는 focus로 강제 이동
     		var srcName = window.event.srcElement.getAttribute("name");
     	    var formObject = document.form;
     	     
     	    var pol_port_cd = formObject.pol_port_cd.value;
     	    var pod_port_cd = formObject.pod_port_cd.value;
     	     
     		var bInputChk = false;
     		
     		
     		if(srcName == "pol_port_cd" && pol_port_cd.length ==5){
     			bInputChk =inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
     		}else if(srcName == "pod_port_cd" && pod_port_cd.length ==5){     			
     			bInputChk = inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
     		}else if(srcName == "tnk_lane_cd"){
     			bInputChk = inputChkUpper(window.event.srcElement,keyObj , 'SEARCH07');
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
//                    style.height = GetSheetHeight(12) ;
                    style.height = 390 ;
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 3, 1, 9, 100);
                    InitRowInfo( 3, 1, 3, 299); //OnSearchEnd 이벤트의 PageNo가 계산된다

                    var HeadTitle0 = "*When you upload a lot of ocean routes through 'Upload Excel' function, the columns in red are mandatory items.|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
                    var HeadTitle1 = "SEQ|Del.|STS|POL|Lane|SVC\nType|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Remark|Remark|Validation date|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||||";
                    var HeadTitle2 = "SEQ|Del.|STS|POL|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Type|Note|Validation date|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||||";
                    //var HeadTitle = "SEQ|Del.|STS|POL|Lane|SVC\nType|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Remark|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||";
                    //var HeadTitle1 = "SEQ|Del.|STS|POL|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Rmk|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);
//                    InitColumnInfo(64, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true, true);
                    InitHeadRow(1, HeadTitle1, true);
                    InitHeadRow(2, HeadTitle2, true);

                    //데이터속성    [  ROW, COL,    DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE,	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        	30,    	daCenter,  	true,    	"s_seq",     			false,          "",       dfNone,   	0,     true,       true);
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
                    
//					InitDataProperty(0, cnt++ , dtComboEdit,    60,    	daLeft,  	true,    	"s_route_rmk",      	false,          "",       dfNone, 		0,     true,       true);
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
                    InitDataProperty(0, cnt++ , dtHidden,       75,    	daCenter,  	true,    	"s_s_time",   			false,          "",       dfNone,  		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol1",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod1",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir1",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg1",    		false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol2",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod2",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir2",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg2",    		false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol3",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod3",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir3",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg3",    		false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol4",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod4",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir4",    			false,          "",       dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg4",    		false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_route_rmk",      	false,          "",       dfNone, 		0,     true,       true);
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
//					InitDataProperty(0, cnt++ , dtHidden,   	60,    	daCenter,  	true,    	"oldRouteFlg",      	true,           "",       dfNone,  		0,     true,       true);

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
		            CountFormat = "[SELECTDATAROW / TOTALROWS]";
		            WaitImageVisible=false;
                }
                break;

        }
    }


    /**
     * save 전에 temp 일때 selelt 했는지 , 입력했는지 체크해서 select만 선택하도록 처리.
     */
	function ocnFlagChk(sheetObj){

		i = 0;
		
		for(i = 0+parseInt(sheetObj.HeaderRows) ; i<  sheetObj.RowCount+parseInt(sheetObj.HeaderRows)  ; i++){
    	    // Priority Check
    	    var idx   = sheetObj.GetComboInfo(i, "s_route_rmk", "SelectedIndex");    	    
            if(  (sheetObj.RowStatus(i)=='U' || sheetObj.RowStatus(i)=='I')  &&
                 (sheetObj.CellValue(i, "s_route_flg") == "T" ) &&  idx==0){ // combo setting에  " " 이 있으면 idx 가 0 , 

                sheetObj.SelectCell(i, "s_route_rmk");
//                sheetObj.CellValue2(i, "s_route_rmk")=''; //jsy 201301
                return false;
            }                
        }
        return true;
	    
	}

    /**
     * save 전에 temp 일때 expire date 입력 체크.OCN_ROUT_TMP_EXP_DT
     */
	function ocnTempExpDtChk(sheetObj){

		i = 0;
		
		for(i = 0+parseInt(sheetObj.HeaderRows) ; i<  sheetObj.RowCount+parseInt(sheetObj.HeaderRows)  ; i++){
    	    // Priority Check
            if(  (sheetObj.RowStatus(i)=='U' || sheetObj.RowStatus(i)=='I')  &&
                 (sheetObj.CellValue(i, "s_route_flg") == "T" ) &&  
            	 (sheetObj.CellValue(i, "s_ocn_rout_tmp_exp_dt") =='' ) ) {
            		
            		sheetObj.SelectCell(i, "s_ocn_rout_tmp_exp_dt");
            		return false;
            }                
        }
        return true;
	    
	}
	
    /**
     * save 전에 Type이 "The Ohter"이면서 Note가 null 인 경우 Message 처리
     * @return
     */
     
     function otherFlagChk(sheetObj){
     	i = 0;
     	
     	for(i = 0+parseInt(sheetObj.HeaderRows) ; i<  sheetObj.RowCount+parseInt(sheetObj.HeaderRows)  ; i++){
     		//alert("!!!!length!!!!!!!" + sheetObj.CellValue(i, "s_route_note").length );
     		//alert("!!!!RowStatus!!!!!!!" + sheetObj.RowStatus(i) );
     	    // Priority Check    	        	    
             if(  (sheetObj.RowStatus(i)=='U' || sheetObj.RowStatus(i)=='I')  &&
                  (sheetObj.CellValue(i, "s_route_rmk") == "The Others" ) && ( ComTrim(sheetObj.CellValue(i, "s_route_note")) == "") ){                          
                 return false;
             }                
         }
         return true;
     }
     
//    function otherFlagChk(sheetObj){
//    	i = 0;
//    	
//    	for(i = 0+parseInt(sheetObj.HeaderRows) ; i<  sheetObj.RowCount+parseInt(sheetObj.HeaderRows)  ; i++){
//    		//alert("!!!!length!!!!!!!" + sheetObj.CellValue(i, "s_route_note").length );
//    		//alert("!!!!RowStatus!!!!!!!" + sheetObj.RowStatus(i) );
//    	    // Priority Check    	        	    
//            if(  (sheetObj.RowStatus(i)=='U' || sheetObj.RowStatus(i)=='I')  &&
//                 (sheetObj.CellValue(i, "s_route_rmk") == "The Others" ) && ( ComTrim(sheetObj.CellValue(i, "s_route_note")) == "") ){                          
//                return i;
//            }                
//        }
//        return -1;
//    }
     
     
	
	/**
	 * Sheet관련 프로세스 처리
	 * @return
	 */
  function doActionIBSheet(sheetObj,formObj,sAction, PageNo) {
    	var uid ;
    	var sXml ;
		sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           	case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction));
				if(!ComChkRequired(formObj)) return;
				formObj.f_cmd.value = SEARCH;
				ComOpenWait(true);
				sheetObj.DoSearch4Post("ESD_PRD_0014GS.do", PrdFQString(formObj));
				ComOpenWait(false);
				break;
            case IBSAVE:        //저장
        	
            	if(validateForm(sheetObj,formObj,sAction));
				
                if(!ocnFlagChk(sheetObj)){
                    ComShowMessage(ComGetMsg('PRD90102'));// PRD90100
                    return;            
                }
                
                if(!ocnTempExpDtChk(sheetObj)){
                	ComShowMessage(ComGetMsg('PRD90143')); //Validation date를 입력하지 않았을 때
                	return;            
                }
				
                if(!otherFlagChk(sheetObj)){                	
                    ComShowMessage(ComGetMsg('PRD90124'));
                    return;            
                }  
				
//                var sddf = otherFlagChk(sheetObj)
//                if(sddf > 0){     
//                	alert("return value :" + sddf);
//                    ComShowMessage(ComGetMsg('PRD90124', sddf));
//                    return;            
//                }                
                
                formObj.f_cmd.value = MULTI;
                ComOpenWait(true);
                sheetObj.DoSave("ESD_PRD_0014GS.do", PrdFQString(formObj));
                ComOpenWait(false);
                break;

			case IBDOWNEXCEL:        //엑셀 다운로드
			    ComOpenWait(true);
				sheetObj.Down2Excel(1,false,false,true,"","apps/alps/esd/prd/networklinkmanage/oceanroutemanage/script/ESD_PRD_0014.xml",true,false,"OceanRoute",false
						          , "s_fmt_s_time|s_f_u|s_rout_seq|s_t_time|s_s_time|s_pol1|s_pod1|s_dir1|s_fdr_flg1|s_pol2|s_pod2"
						            + "|s_dir2|s_fdr_flg2|s_pol3|s_pod3|s_dir3|s_fdr_flg3|s_pol4|s_pod4|s_dir4|s_fdr_flg4"
						            + "|s_n1st_tztm_hrs|s_n2nd_tztm_hrs|s_n3rd_tztm_hrs|s_n4th_tztm_hrs|s_n1st_stay_tm_hrs|s_n2nd_stay_tm_hrs|s_n3rd_stay_tm_hrs"
						            + "|s_ts_ind_cd|s_pod1_etb|s_pol2_etb|s_pod2_etb|s_pol3_etb|s_pod3_etb|s_pol4_etb|s_lnk_cnt|s_upd_ind_cd|s_dup_allow"
                                   );
			
//			    sheetObj.Down2Excel(1, false, false, true);
			    ComOpenWait(false);
				break;
				
			case IBLOADEXCEL:
				var theURL = "ESD_PRD_0086.do";
				var winName = "ESD_TES_0086";
				var features = "scroll:yes;status:no;help:no;dialogWidth:1000px;dialogHeight:600px";
				
				ComOpenWindow(theURL,winName,features,true);
				
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
			case IBSEARCHAPPEND:  // 페이징 조회
		        
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_PRD_0014GS.do", PrdFQString(formObj) , "iPage=" + PageNo, true);
			    break; 				
        }
    }

	/**
	 * 필수 조회 조건 체크
	 * @return 
	 */
    function mandatoryChk(formObj) {

        if(formObj.pol_port_cd.value.length !=5 && formObj.pod_port_cd.value.length !=5) {        	
            ComShowMessage(ComGetMsg('PRD90100'));
            return false;
        }
        return true;
    }

	/**
	 * dtPopupEdit 로 처리 할 경우 팝업오픈 처리
	 * @return
	 */    
    var CALENDAR_SELECTED_ROW ='';
    
    function sheet1_OnPopupClick(sheetObj, row, col)
    {
        if ( sheetObj.ColSaveName(col) == "a1" )
        {
           ComShowMessage("Lane Code Search Popup Open!! row=" + row );
        }
        if ( sheetObj.ColSaveName(col) == "a2" )
        {
           ComShowMessage("Carrier Search Popup Open!! row=" + row );
        }
        if ( sheetObj.ColSaveName(col) == "a3" )
        {
           ComShowMessage("TMNL Code Search Popup Open!! row=" + row );
        }
        
        var cal ;
		if(sheetObj.ColSaveName(col) == "s_ocn_rout_tmp_exp_dt"){
			CALENDAR_SELECTED_ROW = sheetObj.SelectRow;
			cal = new ComCalendarGrid();
			cal.setEndFunction("chkExpDate");	//Callback Function
			cal.select( sheetObj,  row, col , "yyyyMMdd");
			
			
		}
    }
    /*
     * Sheet의 s_ocn_rout_tmp_exp_dt 선택후 CallBack
     */ 
    function chkExpDate(){
    	var exp_dt     = sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "s_ocn_rout_tmp_exp_dt");
     	if( 0 == ComChkPeriod ( exp_dt ,ComGetDateAdd(null, "D", 30)) ) {
    		ComShowMessage(ComGetMsg('PRD90142')); //30일 이상일때
    		sheetObjects[0].CellValue2(CALENDAR_SELECTED_ROW, "s_ocn_rout_tmp_exp_dt")=ComGetDateAdd(null, "D", 30);
    	};
//    	
//    	if(new_exp_dt < eff_dt){
//    		ComShowCodeMessage('COM12133','To date','From date','greater');
//    		sheetObjects[0].CellValue2(CALENDAR_SELECTED_ROW, "sheet1_exp_dt") = CALENDAR_SELECTED_VAL;
//    		return;
//    	}
//    	
//    	//EXP_DT Validation
//    	doActionIBSheet(sheetObjects[0], formObj, COMMAND02);
    }
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }

        return true;
    }


	/******************************************************************************/

	/**
	 * 
	 * @return
	 */         
	function changeSelect(gubun) {
		var frm = document.form;
		var val = ''
		if(gubun=='T'){
			val = frm.select1[frm.select1.selectedIndex].value;
			frm.ts_type.value = (val==0) ? "" : val;
		}
		if(gubun=='S'){
			val = frm.select2[frm.select2.selectedIndex].value;
			frm.stay_time.value = (val==0) ? "0" : val;
		}
	}

	/**
	 * 
	 * @return
	 */  
	function selectLane() {

	    var frm = document.form;
        var slan_cd_val = frm.tnk_lane_cd.value;
	    var param = '?&lane_cd='+slan_cd_val;
        ComOpenPopup('/hanjin/COM_ENS_081.do' + param, 770,470,'getLane',"1,0,1,1,1,1,1,1,1,1,1,1", true);
	   
	}
	
	/**
	 * 
	 * @return
	 */  
	function getLane(rowArray) {

    	var colArray = rowArray[0];
    	document.form.tnk_lane_cd.value = colArray[3];
    	
    }  
	var portInd = '';

  /**
	* 팝업 오픈 처리	
	*/	
	function selectPort(frm, pt){
		portInd = pt;
		var param = '';

		if(pt == 'POL') param = '?loc_cd='+frm.pol_port_cd.value;
		if(pt == 'POD') param = '?loc_cd='+frm.pod_port_cd.value;
		
		ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}

	/**
    * 팝업 후 처리	
    */
	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];
		var frm = document.form;

		if(portInd == 'POL'){

			 frm.pol_port_cd.value = cArray[3];
		}
		if(portInd == 'POD'){
			 frm.pod_port_cd.value = cArray[3];
		}
	}
 
  /**
	* 팝업 오픈 처리	
	*/		
	function doOpenPopup(sheetObject,formObject,gubun){
		var w       = 800;
		var h       = 650;
		if(gubun == 'auto'){
			//w 		  = 800;
			//h  		  = 650;
			w 		  = 1000;
			h  		  = 575;
		}else if(gubun == 'manual'){
			w 		  = 800;
			h  		  = 500;
		}else if(gubun == 'multi'){
			w 		  = 900;
			h  		  = 580;
		}
		var screenW = screen.width;
		var screenH = screen.height;
		var posX    = (screenW-w)/2;
		var posY    = (screenH-h)/2;

		var url   = "";
		var param = "";
		formObject.f_cmd.value='2';
		if(gubun == 'auto'){
			if(formObject.pol_port_cd.value=='' || formObject.pol_port_cd.value.length != 5){				
				ComShowMessage(ComGetMsg('PRD90122'));
				return;
			}
			if(formObject.pod_port_cd.value=='' || formObject.pod_port_cd.value.length !=5 ){
				ComShowMessage(ComGetMsg('PRD90122'));
				return;
			}
			url   = 'ESD_PRD_0032.do';
//			param = PrdFQString(formObject);
			param = 'pol_port_cd=' + formObject.pol_port_cd.value + '&pod_port_cd=' + formObject.pod_port_cd.value + '&tnk_lane_cd=' + formObject.tnk_lane_cd.value;
		}else if(gubun == 'manual'){
		    //if(formObject.pol_port_cd.value==''){
		    if(formObject.pol_port_cd.value=='' || formObject.pol_port_cd.value.length != 5){
				ComShowMessage(ComGetMsg('PRD90122'));
				return;
			}
			if(formObject.pod_port_cd.value=='' || formObject.pod_port_cd.value.length != 5){
				ComShowMessage(ComGetMsg('PRD90122'));
				return;
			}
			url   = 'ESD_PRD_0035.do' ;
			//CHM-201005409-01 의거 추가 
			param = 'CRUD='+CRUD+'&OCN_FLG='+OCN_FLG;
		}else if(gubun == 'multi'){
		    url   = 'ESD_PRD_0060.do' ;
		    //CHM-201005409-01의거 추가 
		    param = 'CRUD='+CRUD+'&OCN_FLG='+OCN_FLG;
		}

		
		if(param.length > 0){
			url   = url + "?" + param;
		}

		popWin  = window.open(url, "OCEANROUTE", "status=1,width="+w+",height="+h+",resizable=0,scrollbars=0,left="+posX+",top="+posY);
		popWin.focus();
	}

	/**
	 * ESD_PRD_0032, ESD_PRD_0035 팝업화면에서 호출하는 메소드
	 * @return
	 */  	
	function ocnRoutSave(){
	    var formObj = document.form;
	    
        formObj.f_cmd.value = MULTI;
        sheetObjects[0].DoSave("ESD_PRD_0014GS.do", PrdFQString(formObj));	    
	    popWin.close();
		formObj.f_cmd.value = SEARCH;
		sheetObjects[0].DoSearch4Post("ESD_PRD_0014GS.do", PrdFQString(formObj));
	    
	}

	/**
	 * Sheet1 Change 이벤트 시
	 * @return
	 */  	
	function sheet1_OnChange(sheetObj, Row, Col, Val) {
	    if(sheetObj.CellValue(Row, "s_route_flg") == "T" )  { //&& sheetObj.CellValue(Row, "s_route_rmk") == "The Others") {  //jsy 201301
	    	sheetObj.CellEditable(Row, "s_route_note") = true;
	    	sheetObj.CellEditable(Row, "s_route_rmk") = true;//jsy 201301
	    } else {
	    	sheetObj.CellEditable(Row, "s_route_note") = false;
	    	sheetObj.CellEditable(Row, "s_route_rmk") = false;//jsy 201301
	    }
	   
        if( sheetObj.ColSaveName(Col) == "s_route_flg" && Val == "T") {
            ComShowMessage(ComGetMsg('PRD90102'));

            sheetObj.SelectCell(Row, "s_route_rmk");
            sheetObj.CellValue2(Row, "s_route_rmk")='';
            sheetObj.CellValue2(Row, "s_route_note")='';
            
            sheetObj.CellEditable(Row, "s_ocn_rout_tmp_exp_dt") = true;
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_flg")='Y';  //jsy
            
        } 
        else if(sheetObj.ColSaveName(Col) == "s_route_flg" && Val != "T") {
            sheetObj.CellValue2(Row, "s_route_rmk")=' ';
            sheetObj.CellValue2(Row, "s_route_note")=' ';
            
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_exp_dt")='';
            sheetObj.CellEditable(Row, "s_ocn_rout_tmp_exp_dt") = false;
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_flg")='N'; 
//            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_flg") = sheetObj.CellValue2(Row, "old_ocn_rout_tmp_flg");
        }	    
//        else if(sheetObj.ColSaveName(Col) == "s_route_rmk" && Val == "The Others") {
//       
//        alert("hate")
//        	sheetObj.CellValue2(Row, "s_route_note")='';
//        }

        //jsy 201301 -------------------
//        else if(sheetObj.ColSaveName(Col) == "s_route_rmk" && Val != "The Others") {
//        	sheetObj.CellValue2(Row, "s_route_note")='';        }
//        else if(sheetObj.ColSaveName(Col) == "s_route_note" && Val != " ") {        	
//        	if(sheetObj.CellValue(Row, "s_route_rmk") != "The Others") {        	
//        		sheetObj.CellValue2(Row, "s_route_note")='';
//        	}
//        }
        //------------------------------
        else         // validation date 는 현재일 +30 이내 지정
            if( sheetObj.ColSaveName(Col) == "s_ocn_rout_tmp_exp_dt" ) {
            	
            	if( 0 == ComChkPeriod ( Val ,ComGetDateAdd(null, "D", 30)) ) {
            		ComShowMessage(ComGetMsg('PRD90142'));
            		sheetObj.CellValue2(Row, "s_ocn_rout_tmp_exp_dt")=ComGetDateAdd(null, "D", 30);
            	};
                
            }
        	
        
        
	    // S 일때 DROP BOX에서 SELECT 하면 못하게 처리 
	    var idx   = sheetObj.GetComboInfo(Row, "s_route_rmk", "SelectedIndex");
        if(  (sheetObj.RowStatus(Row)=='U' || sheetObj.RowStatus(Row)=='I')  && (sheetObj.ColSaveName(Col) == "s_route_rmk") &&
             (sheetObj.CellValue(Row, "s_route_flg") != "T" ) &&  idx >0){


            sheetObj.CellValue2(Row, "s_route_rmk")=' '; 
            sheetObj.CellValue2(Row, "s_route_note")=' ';
            ComShowMessage(ComGetMsg('PRD90103'));
        }  	    
        if(  (sheetObj.RowStatus(Row)=='U' || sheetObj.RowStatus(Row)=='I')  && (sheetObj.ColSaveName(Col) == "s_route_rmk") &&
           //  (sheetObj.CellValue(Row, "s_route_flg") == "T" ) &&  idx < 1){  // PMG 수정소스
        	  (sheetObj.CellValue(Row, "s_route_flg") == "T" ) &&  sheetObj.CellValue(Row, "s_route_rmk").trim() == ""){  
            sheetObj.SelectCell(Row, "s_route_rmk");
            sheetObj.CellValue2(Row, "s_route_rmk")='';
            sheetObj.CellValue2(Row, "s_route_note")='';
            ComShowMessage(ComGetMsg('PRD90102'));
            
        }  
        	    
	    if(sheetObj.ColSaveName(Col)=="s_route_flg") {
	        if(Val == "V") {
	            ComShowMessage(ComGetMsg('PRD90104','Validation'));

	            sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");
	            return;
	        } 
//	        if(Val == "O" && OCN_FLG !='S' ) {
//	            ComShowMessage(ComGetMsg('PRD90104','Doubt'));
//
//	            sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");
//	            return;
//	        } 	        
	        if(Val == "G" ) {
	            if(OCN_FLG !='S'){
    	            ComShowMessage(ComGetMsg('PRD90104','Guide'));
    	            sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");	                
	            }else {
	                sheetObj.CellValue2(Row,"s_prior") = 1;
	            }

	            return;
	        }
	        if(Val == "N" && OCN_FLG !='S') {
	            ComShowMessage(ComGetMsg('PRD90104','Not Used'));
	            sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");
	            return;
	        }  	        
	    }
	    
	}


	/**
	 * Sheet1 조회 후처리
	 * @return
	 */  	
	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
//        var rowCount  = sheetObj.RowCount;
//		var routFlag = '';
//
//		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
//			routFlag = sheetObj.CellValue(i, "s_route_flg");
//		
//			if(routFlag=='V' ){
//				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 204);
//			} else if(routFlag=='T') {
//			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 204, 204);
//			}
//			else if(routFlag=='A') {
//			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(204, 204, 255);
//			} else if(routFlag=='G') {
//			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(150, 190, 255);
//			} else if(routFlag=='N') {
//			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(150, 255, 150);
//			} else{
//				//sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,192);
//			}
//			
//			if (sheetObj.CellValue(i, "s_route_rmk") == "The Others") {
//				sheetObj.CellEditable(i, "s_route_note") = true;
//			}
//		}
		if(parseInt(sheetObj.Rows - sheetObj.HeaderRows)==1){
			sheetObj.SelectHighLight = false;
		} else {
			sheetObj.SelectHighLight = true;
		}
    }
    
	/**
	 * Sheet1 저장 후처리
	 * @return
	 */  
	function sheet1_OnSaveEnd(sheetObj,ErrMsg)
    {
          
        var rowCount  = sheetObj.RowCount;
		var routFlag = '';

		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
			routFlag = sheetObj.CellValue(i, "s_route_flg");
			//ComShowMessage(routFlag);
			if(routFlag=='V' ){
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 204);
			} else if(routFlag=='T') {
			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 204, 204);
			}
			else if(routFlag=='A') {
			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(204, 204, 255);
			}else if(routFlag=='G') {
			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(150, 190, 255);
			} else if(routFlag=='N') {
			    sheetObj.RowBackColor(i) = sheetObj.RgbColor(150, 255, 150);
			} else{
				//sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,255,192);
			}
		}
    }

	function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
//		alert('PageNo:'+PageNo+' OnePageRows:'+OnePageRows);
	        // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
	        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, PageNo);
	} 	
 /*
 * retrieve 를 위한 입력조건 체크 
 */
 function checkInput() {
     var formObject = document.form;
     
     var pol_port_cd = formObject.pol_port_cd.value;
     var pod_port_cd = formObject.pod_port_cd.value;
          
   	 if (pol_port_cd.length > 0 ){
    	 if(!( pol_port_cd.length ==2 || pol_port_cd.length ==5)){
  
    		ComShowMessage(ComGetMsg('PRD90121'));
    		formObject.pol_port_cd.select();
    		formObject.pol_port_cd.focus();  
    		return false;
    	 }
     }else {
    	ComShowMessage(ComGetMsg('PRD90121'));
 		formObject.pol_port_cd.select();
 		formObject.pol_port_cd.focus();  
 		return false;
     }
   	 
   	if (pod_port_cd.length > 0 ){  		

   		if(!( pod_port_cd.length ==2 || pod_port_cd.length ==5)){
   			ComShowMessage(ComGetMsg('PRD90121'));
   			formObject.pod_port_cd.select();
   			formObject.pod_port_cd.focus();  
   			return false;
   		}
   	
   	}
   	/*else {   		
   		ComShowMessage(ComGetMsg('PRD90121'));
		formObject.pod_port_cd.select();
		formObject.pod_port_cd.focus();  
		return false;
   	}*/
   	
 return true;
    
 }