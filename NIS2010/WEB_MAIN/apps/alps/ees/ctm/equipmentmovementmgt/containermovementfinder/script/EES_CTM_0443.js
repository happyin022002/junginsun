/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0443.js
*@FileTitle : Cargo Location message
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.18 우경민
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
     * @class EES_CTM_0443 : EES_CTM_0443 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0443() {
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

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");


            switch(srcName) {

                 case "btn_close":
 										window.close();
                     break;


                 case "btn_downexcel":
                	 sheetObjects[0].Down2Excel(-1);
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
          //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
         }
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
              case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 370;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 4, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(13, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "Seq|F/M|Sight Code|Current|Current|Current|Service\nProvider|Mode|Final Destination|Final Destination|Final Destination|Train/Truck|Flatcar";
                     var HeadTitle2 = "Seq|F/M|Sight Code|Location|Status|Event Date|Service\nProvider|Mode|Location|Status|Event Date|Train/Truck|Flatcar";
//                     sTipFM = "\n F : Full\n M : Empty";
                     sTipFM = "";
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtSeq,		40,   daCenter,    true,    	"Seq");
                     InitDataProperty(0, cnt++ , dtData,    30,   daCenter,    false,     "full_mty_cd",     false,          "",      dfNone        ,    0,      false,      true,      0,       false,      true,       sTipFM );
                     InitDataProperty(0, cnt++ , dtData,	90,   daCenter,  	true,     "clm_sght_abbr_nm",   		false,          "",      dfNone,    		0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	90,   daCenter,    true,     "arr_loc_nm",    		false,          "",      dfNone, 				0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	50,   daCenter,  	true,     "arr_ste_cd",   			false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	100,  daCenter,    true,     "arr_dt", 			false,          "",      dfUserFormat2,	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	100,  daCenter,    true,     "clm_crr_nm",    		false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	50,   daCenter,  	true,     "trsp_mod_tp_cd",   				false,          "",      dfNone,  			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	90,   daCenter,  	true,     "dep_loc_nm",   		false,          "",      dfNone,    		0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	50,   daCenter,    true,     "dep_ste_cd",    		false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	100,  daCenter,  	true,     "dep_dt",   	false,          "",      dfUserFormat2, 0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	80,   daCenter,    true,     "trn_no",    	false,          "",      dfNone,      	0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,	80,   daCenter,  	true,     "fcar_no",   			false,          "",      dfNone,  			0,     true,       true);
                     InitUserFormat2(0, "arr_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "dep_dt", "####-##-## ##:##", "-|:" );
                     CountPosition = 0;

                }
                 break;


         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
           case IBSEARCH:      //조회
 	          if(validateForm(sheetObj,formObj,sAction))
  	         	  ComOpenWait(true);
	         	  sheetObj.WaitImageVisible = false;
 	        	  formObj.f_cmd.value = SEARCH;
           		  sheetObj.DoSearch("EES_CTM_0443GS.do", FormQueryString(formObj));
  	         	  ComOpenWait(false);
   	         	  sheetObj.WaitImageVisible = true;
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





 /*


 	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg)
 	{
 		sheetObj.ShowSubSum("a", "a", 0 , true, false, 3, "0=;1=;2=;");

 		var sRow = sheetObj.FindSubSumRow("a");
 		var arrRow = sRow.split("|");

 		for(idx =0; idx < arrRow.length-1 ; idx++)
 		{
 			if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="A" )
 			{
 				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Auto Calculated Cost";
 			}else if(sheetObj.CellValue(parseInt(arrRow[idx])+1, "a") =="M" )
 			{
 				sheetObj.CellValue2(arrRow[idx],"d") = "▶ Manual Input Cost";
 			}
 		}
 	}

 	*/

	/* 개발자 작업  끝 */