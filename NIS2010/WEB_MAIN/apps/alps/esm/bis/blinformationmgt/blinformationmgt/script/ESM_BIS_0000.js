/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BIS_0000.jsp
*@FileTitle : BIS-B/L Information
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김태경
*@LastVersion : 1.0
*2010.01.22 김태경
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
     * @class ESM_BIS_0000 : ESM_BIS_0000 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BIS_0000() {
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

 						case "btn_Retrieve":
 								doActionIBSheet(sheetObject1,document.form,IBSEARCH);
 							break;

 						case "btn_If":
 								doActionIBSheet(sheetObject1,document.form,COMMAND01);
 							break;
 						case "btn_All_If":
 								doActionIBSheet(sheetObject1,document.form,COMMAND02);
							break;


 				} // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			alert("지금은 사용하실 수가 없습니다 ");
     		} else {
     			alert(e);
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
             initControl();
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);

         }
 		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

     }
     function initControl() {
    	  /* KeyPress Event 받아서 format 변환 */
   	  DATE_SEPARATOR ="-";
   	  
   	  var formObject = document.form;
   	  axon_event.addListenerFormat('keypress','obj_KeyPress',formObject);
   	  ComSetObjValue(formObject.from_dt,ComGetNowInfo()) // 맨처음 로드시 오늘 날짜로 셋팅
   	  ComSetObjValue(formObject.to_dt,ComGetNowInfo())
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
                     style.height = 342;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 10, 100);

                  var HeadTitle1 = "|Sel.|BKG No|BDR FLG|BIS SYS FLG|OBL ISS FLG|OBL PRN FLG|OBL RLSE FLG|OBL SRND FLG|OBL RDEM FLG|CHG FLG";
                  var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                   
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
 					InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "Check", false, "", dfNone, 0, true, true);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"bkg_no",		false,	"",		dfNone,				0,			false,		false);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"bdr_flg",		false,	"",		dfNone,				0,			false,		false);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"bis_sys_flg",		false,	"",		dfNone,				0,			false,		false);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"obl_iss_flg",		false,	"",		dfNone,				0,			false,		false);
			 		
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"obl_prn_flg",		false,	"",		dfNone,				0,			false,		false);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"obl_rlse_flg",		false,	"",		dfNone,				0,			false,		false);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"obl_srnd_flg",		false,	"",		dfNone,				0,			false,		false);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"obl_rdem_flg",		false,	"",		dfNone,				0,			false,		false);
			 		InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	false,	"chg_flg",		false,	"",		dfNone,				0,			false,		false);
 										
 		
 		CountPosition = 2;

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
					  formObj.f_cmd.value = SEARCH;
            		  sheetObj.doSearch("ESM_BIS_0000GS.do",FormQueryString(formObj));
                 break;
            case COMMAND01:
            		formObj.f_cmd.value = MULTI01;
            		var sParam = ComGetSaveString(sheetObjects[0]);
            		sParam += "&"  + FormQueryString(formObj); 
            		var SaveXml = sheetObj.GetSaveXml("ESM_BIS_0000GS.do", sParam);
					sheetObj.LoadSaveXml(SaveXml);
					
					var State = ComGetEtcData(SaveXml,"TRANS_RESULT_KEY");
					if ( State == "S" ) {
						ComShowMessage(ComGetMsg("BKG06071"));
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
            case COMMAND02: 
            		formObj.f_cmd.value = MULTI02;
            		
            		var SaveXml = sheetObj.GetSaveXml("ESM_BIS_0000GS.do",FormQueryString(formObj));
            		sheetObj.LoadSaveXml(SaveXml);
					
					var State = ComGetEtcData(SaveXml,"TRANS_RESULT_KEY");
					if ( State == "S" ) {
						ComShowMessage(ComGetMsg("BKG06071"));
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            	break ;
         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction){
    	 	case IBSEARCH:
    	 		if(ComIsNull(formObj.to_dt)){
    	 			ComShowCodeMessage('BKG08029');
    	 			formObj.from_dt.focus();
    	 			return false;
    	 		}
    	 		if(ComIsNull(formObj.from_dt)){
    	 			ComShowCodeMessage('BKG08029');
    	 			formObj.to_dt.focus();
    	 			return false;
    	 		}  	 		
    	 }

         return true;
     }


 		function sheet1_OnSearchEnd(sheetObj, ErrMsg)
 		{
 			with(sheetObj)
 			{
 				SumText(0, "Office") = SumText(0, "Regional");
 				RowMerge(LastRow) = true;
 				SumText(0, "Percent") = Math.round( SumValue(0, "PFMC") / SumValue(0, "Budget") * 100 ) + "%";
 				CellAlign(LastRow, "Percent") = daCenter;
 				
 				
 			}
 		}
 	    function callDatePop(val){
 	    	var cal = new ComCalendarFromTo();
 	    	if (val == 'BKG_DATE'){
 	    		cal.select(form.from_dt, form.to_dt, 'yyyy-MM-dd');
 	    	}
 	    }
 	    function changedate(val){
 	    	var dt = val.value;
 	    	if(!ComIsDate(dt)){
 	    		ComShowCodeMessage('BKG00921');
 	    		return false;
 	    	}
 	    }
    
	/* 개발자 작업  끝 */
        