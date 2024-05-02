/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3103.js
*@FileTitle : Correction Save History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.29 황효근
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
     * @class EES_DMT_3103 : EES_DMT_3103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3103() {
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


	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;
	
	 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
		  /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		  var sheetObject1 = sheetObjects[0];
		  /*******************************************************/
		  var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             	case "btn_Close":
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
         
         initControl();
     }
     
	function initControl() {
		axon_event.addListener('mouseover', 'btn_mouseover',	'tdGB');	// onMouseover 이벤트(말풍선)
		axon_event.addListener('mouseout',	'btn_mouseout',		'tdGB');	// onMouseout 이벤트(말풍선)
	}
	
	// 'by ETA' onMouseover 이벤트  (버튼 말풍선  보여줌)
	function btn_mouseover() {
		var bak = 'lightyellow';
		var msg = 'General/Balance Charge Type';
		var content =	"<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
    	var x = event.x+document.body.scrollLeft;
		var y = event.y+document.body.scrollTop;
		var skn = document.all("topdeck").style;
		skn.left = x;
		skn.top  = y-20;
		document.all("topdeck").innerHTML = content;
		skn.visibility = 'visible';
     }
     
     // 'by ETA' onMouseout 이벤트  (버튼 말풍선 숨김)
     function btn_mouseout() {
    	 var skn = document.all("topdeck").style;
    	 skn.visibility = 'hidden';
     }
     
     
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
 	function sheet1_OnLoadFinish() {
   		//var formObj = document.form;
   		//var sheetObj = sheetObjects[0];
   		//sheetObj.WaitImageVisible = false;
         
         doInit();
         //sheetObj.WaitImageVisible = true; 
 	}
     
 	
     function doInit() {
    	 var sheetObj = sheetObjects[0];
    	 var formObj = document.form;
    	 
    	 doActionIBSheet(sheetObj, formObj, IBSEARCH);
    	 
    	 with(sheetObj) {
	    	 var cntCd = ComGetObjValue(formObj.login_cnt_cd);
	    	 if(cntCd == 'US') {
	    		 ColHidden("web_mty_dt") = false;
	    		 ColHidden("web_mty_id") = false;
	    		 ColHidden("web_mty_nm") = false;
	    		 
	    	 } else if(SearchRows > 0) {
	    		 for(var i=TopRow; i <= LastRow; i++) {
	    			 if(CellValue(i, "web_mty_dt") != '' || CellValue(i, "web_mty_id") != '' || CellValue(i, "web_mty_nm") != '') {
	    				 ColHidden("web_mty_dt") = false;
	    				 ColHidden("web_mty_id") = false;
	    	    		 ColHidden("web_mty_nm") = false;
	    	    		 break;
	    			 }
	    		 }
	    		 
	    		 var corrHisRmk = CellValue(TopRow, "corr_his_rmk");
	    		 ComSetObjValue(formObj.corr_his_rmk, corrHisRmk);
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
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = GetSheetHeight(9);	//180;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 7, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(17, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                     var HeadTitle1 = "Seq.|Charge\nStatus|From|From|From|To|To|To|Web Empty Notification|Web Empty Notification|Web Empty Notification|UC|Creation|Creation|Creation|Creation";
                     var HeadTitle2 = "Seq.|Charge\nStatus|Date|Yard|STS|Date|Yard|STS|Web MT DT|User ID|User Name|UC|Date|User OFC|User ID|User Name";
 												
 												
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,	   	30,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,   	75,		daCenter,	true,	"chg_sts_cd",		false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"fm_mvmt_dt",		false,	"",		dfDateYmd,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	false,	"fm_yd_cd",			false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,		daCenter,	false,	"fm_mvmt_sts_cd",	false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"to_mvmt_dt",		false,	"",		dfDateYmd,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	70,		daCenter,	false,	"to_yd_cd",			false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,		daCenter,	false,	"to_mvmt_sts_cd",	false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"web_mty_dt",		false,	"",		dfDateYmd,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"web_mty_id",		false,	"",		dfNone,		0,	false,	true);
					
					InitDataProperty(0, cnt++ , dtData,   	120,	daLeft,		false,	"web_mty_nm",		false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	40,		daCenter,	true,	"uclm_flg",			false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"cre_dt",			false,	"",		dfDateYmd,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	60,		daCenter,	false,	"cre_ofc_cd",		false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	80,		daCenter,	false,	"cre_id",			false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtData,   	110,	daLeft,		false,	"cre_nm",			false,	"",		dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,	true,	"corr_his_rmk",		false,  "",		dfNone,		0,	false,  false);
					
					Ellipsis = true;
					ColHidden("web_mty_dt") = true;
					ColHidden("web_mty_id") = true;
		    		ColHidden("web_mty_nm") = true;
                 }
                 
                 break;
         }
     }

     
	// Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH:      //조회
		         //if(!validateForm(sheetObj,formObj,sAction)) return;
		         formObj.f_cmd.value = SEARCH;
		         sheetObj.DoSearch("EES_DMT_3103GS.do", FormQueryString(formObj));
		         break;
         }
     }
     
     
     // 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	 var corrHisRmk = sheetObj.CellValue(Row, "corr_his_rmk");
    	 ComSetObjValue(document.form.corr_his_rmk, corrHisRmk);
     }
     

     /**
   	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
   	 */
 	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
 		/*if(ErrMsg == '') {
 			with(sheetObj)
 			{
 				for(var i= 2; i <= LastRow; i ++) {
 					//if( CellValue(i, "fm_mvmt_sts_cd")  )
 				}
 			}
 			
 		}*/
 	}


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
    
    

	/* 개발자 작업  끝 */