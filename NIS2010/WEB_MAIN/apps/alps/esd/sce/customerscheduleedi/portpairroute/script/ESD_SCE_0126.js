/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0126.js
*@FileTitle : ocean route information
*Open Issues :
*Change history :
*@LastModifyDate : 2013-09-17
*@LastModifier : 
*@LastVersion : 1.0 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0126 : ESD_SCE_0126 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */



function ESD_SCE_0126() {
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

        	    case "btn_downexcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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

		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress',         'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
//		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'pol_port_cd', 'pod_port_cd', 'ts_port_cd','tnk_lane_cd');
//		axon_event.addListener('keydown', 'prdComKeyDown' , 'pol_port_cd', 'pod_port_cd', 'tnk_lane_cd');
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
    
	/**
	 * tab event처리
	 * @return
	 */
//	function prdComKeyDown(){
//		var keyObj=window.event.keyCode;
//    	
//     	if(keyObj == 9){ // 탭을 할때만 처리하기 때문에, Tab Index에 해당하는 focus로 강제 이동
//     		var srcName = window.event.srcElement.getAttribute("name");
//     	    var formObject = document.form;
//     	     
//     	    var pol_port_cd = formObject.pol_port_cd.value;
//     	    var pod_port_cd = formObject.pod_port_cd.value;
//     	     
//     		var bInputChk = false;
//     		
//     		
//     		if(srcName == "pol_port_cd" && pol_port_cd.length ==5){
//     			bInputChk =inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
//     		}else if(srcName == "pod_port_cd" && pod_port_cd.length ==5){     			
//     			bInputChk = inputChkUpper(window.event.srcElement,keyObj , 'SEARCH01');
//     		}else if(srcName == "tnk_lane_cd"){
//     			bInputChk = inputChkUpper(window.event.srcElement,keyObj , 'SEARCH07');
//     		}
//     	}
//	}

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
                    InitRowInfo( 2, 1, 3, 100); //OnSearchEnd 이벤트의 PageNo가 계산된다

//                    var HeadTitle0 = "*When you upload a lot of ocean routes through 'Upload Excel' function, the columns in red are mandatory items.|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
                    var HeadTitle0 = "SEQ|Block Lane|POR|POL|Lane|1st T/S|1st T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|POD|DEL|T/Time\n(Day/Hr)|Ocean\nFlag";
                    var HeadTitle1 = "SEQ|Block Lane|POR|POL|Lane|Port|Lane|Port|Lane|Port|Lane|POD|DEL|T/Time\n(Day/Hr)|Ocean\nFlag";
                    //var HeadTitle = "SEQ|Del.|STS|POL|Lane|SVC\nType|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Remark|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||";
                    //var HeadTitle1 = "SEQ|Del.|STS|POL|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|Port|Lane|SVC\nType|POD|T/Time\n(Day/Hr)|S/Time\n(Day)|Priority|Ocean\nFlag|Rmk|F/Used|C.Date|C.User|U.Date|U.User||||||||||||||||||||||||||||||||||||";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);
//                    InitColumnInfo(64, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle0, true, true);
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [  ROW, COL,    DATATYPE,   	WIDTH, 	DATAALIGN, 	COLMERGE,	SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        	30,    	daCenter,  	true,    	"s_seq",     			false,          "",       dfNone,   	0,     true,       true);
//                    InitDataProperty(0, cnt++ , dtDelCheck,   	30,    	daCenter,  	true,    	"s_del",     			false,          "",       dfNone,	    0,     true,       true);
//                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter,  	true,    	"ibflag",  				false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,       	150,    	daCenter,  	true,    	"block_yn",     			false,          	"",		  dfNone,   	0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"por_cd",     			false,          	"",		  dfNone,   	0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"pol_cd",     			false,          	"",		  dfNone,   	0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       	60,    	daCenter,  	true,    	"lane1",    			false,           "",       dfNone,  		0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"svc_type", 			false,          "",       dfNone,  		0,     false,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"pod1", 			false,          "",       dfNone,  		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"lane2", 			false,          "",       dfNone,  		0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"ts1_type", 			false,          "",       dfNone,  		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"pod2", 			false,          "",       dfNone,  		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"lane3", 			false,          "",       dfNone,  		0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	40,    	daCenter,  	true,    	"ts2_type", 			false,          "",       dfNone,  		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"pod3", 			false,          "",       dfNone,  		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,     	"lane4", 			false,          "",       dfNone,  		0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	50,    	daCenter,  	true,    	"ts3_type", 			false,          "",       dfNone,  		0,     false,      true);
                    
                    InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,     	"pod_cd",     			false,           "",       dfNone,  		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,     	"del_cd",     			false,           "",       dfNone,  		0,     false,      true);
                    InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"fmt_tztm_hrs",   		false,          "",       dfUserFormat2,0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtHidden,     	75,    	daCenter,  	true,    	"fmt_s_time",   		false,          "",       dfUserFormat2,0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtCombo,      	60,    	daCenter,  	true,    	"prior",   			true,           "",       dfNone,  		0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      	60,    	daCenter,  	true,    	"upd_ind_cd",      	false,           "",       dfNone,  		0,     false,       true);
                    
//                    InitDataProperty(0, cnt++ , dtCombo,       	60,    	daLeft,  	true,    	"s_route_rmk",      	false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtData,       	100,    daLeft,  	true,    	"s_route_note",      	false,          "",       dfNone, 		0,     false,      false);
//					InitDataProperty(0, cnt++,  dtPopupEdit,    100,    daCenter,   true,       "s_ocn_rout_tmp_exp_dt",false,          "",       dfDateYmd,    0,     true,       true);
//                    InitDataProperty(0, cnt++ , dtHidden,      	60,    	daCenter,  	true,    	"s_f_u",      			true,           "",       dfNone,  		0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_c_date",   			false,          "",       dfDateYmd, 	0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_c_user",   			false,          "",       dfNone, 	    0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_u_date",   			false,          "",       dfDateYmd, 	0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtData,       	70,    	daCenter,  	true,    	"s_u_user",   			false,          "",       dfNone, 	   	0,     false,      true);
//  
//                    // Hidden Fields
//					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	true,    	"s_rout_seq",    		false,          "",       dfNone, 		0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtHidden,     	70,    	daCenter,  	true,    	"s_t_time",   			false,          "",       dfNone, 		0,     false,      true);
//                    InitDataProperty(0, cnt++ , dtHidden,       75,    	daCenter,  	true,    	"s_s_time",   			false,          "",       dfNone,  		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol1",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod1",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir1",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg1",    		false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol2",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod2",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir2",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg2",    		false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol3",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod3",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir3",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg3",    		false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol4",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod4",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_dir4",    			false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_fdr_flg4",    		false,          "",       dfNone, 		0,     false,      true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n1st_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n2nd_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n3rd_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n4th_tztm_hrs",      false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n1st_stay_tm_hrs",   false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n2nd_stay_tm_hrs",   false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_n3rd_stay_tm_hrs",   false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_ts_ind_cd",			false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod1_etb",      		false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol2_etb",      		false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod2_etb",      		false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol3_etb",      		false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pod3_etb",      		false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_pol4_etb",      		false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"s_lnk_cnt",      		false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	20,    	daCenter,  	true,    	"upd_ind_cd",      	false,          "",       dfNone, 		0,     true,       true);
//					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,   	"s_dup_allow",     		false,          "",       dfNone,	    0,     false,      false);
//					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,   	"s_ocn_rout_tmp_flg",   false,          "",       dfNone,	    0,     false,      false);
//					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,   	"old_ocn_rout_tmp_flg",   false,          "",       dfNone,	    0,     false,      false);

//                    InitComboNoMatchText(true);		            
//		            InitDataCombo (0, "s_prior", " |1|2|3|4|5|6|7|8|9|10", " |1|2|3|4|5|6|7|8|9|10");
//		            InitDataCombo (0, "s_f_u", " |Y|N", " |Y|N");
//		            InitDataCombo (0, "s_route_flg", " |Guide|Standard|Temporary|Validation|Not Used|Deleted", " |G|S|T|V|N|D");   // Route Flag - add 2007.12.11
//		            InitDataCombo (0, "s_route_rmk", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others");   // 20090317
		            
//		            ImageList(0) = "/hanjin/img/alps/button/btns_calendar.gif";
//		            PopupButtonImage(0, "s_ocn_rout_tmp_exp_dt") = 0;
		            
                    InitUserFormat2(0, "fmt_tztm_hrs", "##D-##H", "D|-|H" );
//                    InitUserFormat2(0, "s_fmt_s_time", "##D-##H", "D|-|H" );
		            RangeBackColor(1, 6, 1, 14) = RgbColor(222, 251, 248);   // alps
		            HeadRowHeight = 20 ;
//		            CountFormat = "[SELECTDATAROW / TOTALROWS]";
		            WaitImageVisible=false;
                }
                break;

        }
    }

      
	
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
				sheetObj.DoSearch4Post("ESD_SCE_0126GS.do", SceFrmQryString(formObj));
				ComOpenWait(false);
				break;
  

			case IBDOWNEXCEL:        //엑셀 다운로드
			    ComOpenWait(true);
//				sheetObj.Down2Excel(1,false,false,true,"","apps/alps/esd/prd/networklinkmanage/oceanroutemanage/script/ESD_SCE_0126.xml",true,false,"OceanRoute",false
//						          , "s_fmt_s_time|s_f_u|s_rout_seq|s_t_time|s_s_time|s_pol1|s_pod1|s_dir1|s_fdr_flg1|s_pol2|s_pod2"
//						            + "|s_dir2|s_fdr_flg2|s_pol3|s_pod3|s_dir3|s_fdr_flg3|s_pol4|s_pod4|s_dir4|s_fdr_flg4"
//						            + "|s_n1st_tztm_hrs|s_n2nd_tztm_hrs|s_n3rd_tztm_hrs|s_n4th_tztm_hrs|s_n1st_stay_tm_hrs|s_n2nd_stay_tm_hrs|s_n3rd_stay_tm_hrs"
//						            + "|s_ts_ind_cd|s_pod1_etb|s_pol2_etb|s_pod2_etb|s_pol3_etb|s_pod3_etb|s_pol4_etb|s_lnk_cnt|s_upd_ind_cd|s_dup_allow"
//                                   );
			
			    sheetObj.Down2Excel(1, false, false, true);
			    ComOpenWait(false);
				break;
 			
        }
    }

	/**
	 * 필수 조회 조건 체크
	 * @return 
	 */
//    function mandatoryChk(formObj) {
//
//        if(formObj.pol_port_cd.value.length !=5 && formObj.pod_port_cd.value.length !=5) {        	
//            ComShowMessage(ComGetMsg('PRD90100'));
//            return false;
//        }
//        return true;
//    }

  
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }

        return true;
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