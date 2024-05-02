/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0066.js
*@FileTitle : Organic Peroxides & Self-Reactive Substances (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.18 장강철 jkc
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
     * @class vop_scg_0066 : vop_scg_0066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0066() {
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
 	         var sheetObject = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
 												
		            case "btn1_Excel":
    		              var paramObj = new Object();
    		              paramObj.title = "Organic Peroxides and Self-Reactive Substances";
                          paramObj.columnwidth = "2:6|3:5|4:15|5:40|6:10|7:10|8:10|9:10|10:10";
    		              paramObj.datarowheight   = "0:25";
    		              var url = ComScgGetPgmTitle(sheetObjects[0], paramObj);  
    		              sheetObjects[0].SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
    		              //sheetObjects[0].SpeedDown2Excel(-1); 
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
         initControl();
 		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet( sheetObj,document.form,IBSEARCH);
      }      
      function initControl() {
          var form = document.form;
          axon_event.addListenerForm('keypress','obj_keypress',    form  );
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
 
      }          
      /**
      * Form Object obj_keypress 이벤트시 처리
      * @param  void
      * @return void
      */     
      function obj_keypress (){
          var obj = event.srcElement;
 
          switch (obj.name){
 
               case 'imdg_un_no':
                    ComKeyOnlyNumber(obj);
 
                    break;
                    
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
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 456;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(11, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "|No.|UN No/Seq.|UN No/Seq.|Classification|Technical Names|Concentration\n(%)|Packing\nMethod|Control\nTemp(℃)|Emergency\nTemp(℃)|Subsidiary\nRisks";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	10,    	daCenter,	true,    "ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,      	30,    daCenter);
                     InitDataProperty(0, cnt++ , dtData,   		  	50,    	daCenter,	true,    "imdg_un_no", 				false,     "",      dfNone,      0,     true,    true);
                     InitDataProperty(0, cnt++ , dtData,	   	  	30,    	daCenter,	true,    "imdg_un_no_seq");
                     InitDataProperty(0, cnt++ , dtData,		 	130,	daLeft,   	true,    "imdg_org_ract_tp_cd", 	false,     "",      dfNone,      0,     true,    true);
                     InitDataProperty(0, cnt++ , dtData,		 	340,    daLeft,   	true,    "imdg_tec_nm", 	  		false,     "",      dfNone,      0,     true,    true);
                     InitDataProperty(0, cnt++ , dtData,   		  	95,    	daLeft,   	true,    "imdg_conc_rt_ctnt", 		false,     "",      dfNone,      0,     true,    true); 
                     InitDataProperty(0, cnt++ , dtData,   		  	65,    	daCenter,	true,    "imdg_pck_mzd_cd", 		false,     "",      dfNone,      0,     true,    true);
                     InitDataProperty(0, cnt++ , dtData,   		  	75,    	daCenter,   true,    "imdg_ctrl_temp", 			false,     "",      dfNone,      0,     true,    true);
                     InitDataProperty(0, cnt++ , dtData,   		  	85,    	daCenter,   true,    "imdg_emer_temp", 			false,     "",      dfNone,      0,     true,    true);
                     InitDataProperty(0, cnt++ , dtData,   		  	60,    	daCenter,   true,    "imdg_subs_rsk_lbl_cd", 	false,     "",      dfNone,      0,     true,    true);
                     
                                                                                                     
 					//InitDataCombo(0, "Classification", "Organic Peroxides|Self-Reactive Substance", "1|2");
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
 
                    var param =  FormQueryString(formObj);
 
					if(sheetObj.id == "sheet1")
						sheetObj.DoSearch("VOP_SCG_0066GS.do",param);
 					
 					break;
 					
 
         }
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