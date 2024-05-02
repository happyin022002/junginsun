/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0004.js
*@FileTitle : Segregation Table (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.28 이도형
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
     * @class vop_scg_0004 : vop_scg_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0004() {
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

    var tabLoad = new Array();
    tabLoad[0]= 0;
    tabLoad[1]= 0;


    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	var formObject = document.form;          
    	/*******************************************************/

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

     			case "btn_Retrieve":
     				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;

 				case "btn_DownExcel":
 					switch(tabIndex) {
 					case 0:
 		                var paramObj = new Object();
 		                paramObj.title = "Between Various Classes";
 	                    paramObj.columnwidth = "1:10|2:5|3:5|4:5|5:5|6:5|7:5|8:5|9:5|10:5|11:5|12:5|13:5|14:5|15:5|16:5|17:5|18:5|19:5|20:5|21:5";
 		                var url = ComScgGetPgmTitle(sheetObjects[0], paramObj); 
 		               sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url );
// 	 					sheetObjects[0].Down2Excel();
 						break;
 					case 1:
 		                var paramObj = new Object();
 		                paramObj.title = "Within Class 1";
 	                    paramObj.columnwidth = "1:10|2:8|3:8|4:8|5:8|6:8|7:8|8:8|9:8|10:8|11:8|12:8|13:8|14:8";
 	                    paramObj.datarowheight   = "0:25";
 		                var url = ComScgGetPgmTitle(sheetObjects[1], paramObj); 
 		                sheetObjects[1].SpeedDown2Excel(-1, false,false, "", url );
// 	 					sheetObjects[1].Down2Excel();
 						break;
 					}
 					break;

				case "btns_Numbers&Symbols":
					ComOpenWindowCenter("VOP_SCG_1003_01.do", "VOP_SCG_1003_01", 705, 345, true);
					break;

				case "btns_PermittedMixedStowageOfClass1":
					ComOpenWindowCenter("VOP_SCG_1003_02.do", "VOP_SCG_1003_02", 705, 390, true);
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
    		 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
     }

     function t1sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

    	 var cnt = 0;

         switch(sheetNo) {
         	case 1:      //t1sheet1 init
         		with (sheetObj) {
         			// 높이 설정
         			style.height = 440;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msNone;

         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = false;

         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 1, 1, 20, 100);

         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(22, 0, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(false, false, true, true, false,false)

         			var HeadTitle = "|Class|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9";

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);


         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   	daCenter,  false,   	"Status");
         			InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"row_imdg_clss_cd",	false,  "",      dfNone, 			0,     false,      	true,	3);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_11",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			46,		daCenter,	false,	"clss_cd_12",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_15",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			46,		daCenter,	false,	"clss_cd_13",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_16",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			46,		daCenter,	false,	"clss_cd_14",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_21",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			46,		daCenter,	false,	"clss_cd_22",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_23",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			46,		daCenter,	false,	"clss_cd_3",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_41",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			46,		daCenter,	false,	"clss_cd_42",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_43",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			46,		daCenter,	false,	"clss_cd_51",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_52",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_61",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_62",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_7",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_8",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	false,	"clss_cd_9",     	false,  "",      dfNone, 			0,     false,       true,	1);
         			
                }
                 break;

         	case 2:      //t2sheet1 init
         		with (sheetObj) {
         			// 높이 설정
         			style.height = 410;
         			//전체 너비 설정
         			SheetWidth = mainTable.clientWidth;

         			//Host정보 설정[필수][HostIp, Port, PagePath]
         			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         			//전체Merge 종류 [선택, Default msNone]
         			MergeSheet = msNone;
         			
         			//전체Edit 허용 여부 [선택, Default false]
         			Editable = false;
         			
         			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         			InitRowInfo( 1, 1, 3, 100);
         			
         			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         			InitColumnInfo(15, 0, 0, true);

         			// 해더에서 처리할 수 있는 각종 기능을 설정한다
         			InitHeadMode(false, false, true, true, false,false)

         			var HeadTitle = "|Compatibility\ngrorp|A|B|C|D|E|F|G|H|J|K|L|N|S";

         			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			InitHeadRow(0, HeadTitle, true);         			

         			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   	daCenter,  	false,	"Status");
         			InitDataProperty(0, cnt++ , dtData,			125,	daCenter,	false,	"row_imdg_comp_grp_cd",	false,  "",      dfNone, 			0,     false,      	true,	1);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_a",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_b",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_c",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_d",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_e",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_f",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_g",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_h",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_j",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_k",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_l",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_n",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	false,	"segr_cd_s",     		false,  "",      dfNone, 			0,     false,       true,	2);
         			
         		}
         		break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case IBSEARCH:      //조회
 				formObj.f_cmd.value = SEARCH;
    			var sXml = sheetObj.GetSearchXml("VOP_SCG_0004GS.do", FormQueryString(formObj));    			
    			var arrXml = sXml.split("|$$|");
			
    			for(var inx=0; inx<arrXml.length; inx++){
    				sheetObjects[inx].LoadSearchXml(arrXml[inx]);
    			}
    			break;
         }
     }

     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
     }

     /**
      * Tab 기본 설정
      * 탭의 항목을 설정한다.
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt  = 0 ;
                     InsertTab( cnt++ , "Between Various Classes" , -1 );
                     InsertTab( cnt++ , "Within Class 1" , -1 );
                 }
              break;
          }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs = document.all.item("tabLayer");
         objs[nItem].style.display = "Inline";
         objs[beforetab].style.display = "none";

         //--------------- 요기가 중요 --------------------------//
         objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab= nItem;
         tabIndex = nItem;
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }


	/* 개발자 작업  끝 */