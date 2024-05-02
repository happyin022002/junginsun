/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EES_CTM_0461.js
*@FileTitle : US AMS Location
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 우경민
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
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends
     * @class EES_CTM_0461 : EES_CTM_0461 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0461() {
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
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var formObj = document.form;

//     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 		         case "btn_add":
 		        	 	sheetObject.DataInsert();
						break;

 				 case "btn_del":
                	 // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                    	 var sRowStr = sheetObject.FindCheckedRow("del_chk");
                    	 // 자바 스크립트 배열로 만들기

                    	 var arr = sRowStr.split("|");

							for (i = arr.length - 2; i >= 0; i--) {
                    	      if (sheetObject.RowStatus(arr[i]) == "I") {
    	                		  sheetObject.RowDelete(arr[i], false);    // 삭제를 위해 선택row의 Status를 D로 변경
                    	      } else {
    	                		  sheetObject.RowStatus(arr[i]) = "D";    // 삭제를 위해 선택row의 Status를 D로 변경
    	                	      sheetObject.RowHidden(arr[i]) = true;    // 선택row를 숨김
                    	      }
                    	 }
 						break;

                 case "btn_downexcel":
    				sheetObject.WaitImageVisible = false;
    				ComOpenWait(true);
                	sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "Sel");
	   				ComOpenWait(false);
					sheetObject.WaitImageVisible = true;
                    break;

 		         case "btn_Save":
    				sheetObject.WaitImageVisible = false;
    				ComOpenWait(true);
 		        	doActionIBSheet(sheetObject, document.form, IBSAVE);
	   				ComOpenWait(false);
					sheetObject.WaitImageVisible = true;
					break;


             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			alert("지금은 사용하실 수가 없습니다 ");
//     		} else {
//     			alert(e);
//     		}
//     	}
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
                     style.height = 462;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(10, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "||Seq.|AMS Location|Location|Location Name|Creation Date|Creation User|Update Date|Update User";


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,      daCenter,    false,    "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,   30,     daCenter,    false,    "del_chk",         false,    "",    dfNone);
                     InitDataProperty(0, cnt++ , dtSeq,          30,     daCenter,    false,    "SEQ");
                     InitDataProperty(0, cnt++ , dtData,         105,    daCenter,    true,     "loc_ams_port_cd", true,     "",    dfNone,        0,    false,    true,    5);
                     InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    true,     "loc_cd",          true,     "",    dfNone,        0,    true,     true,    5);
                     InitDataProperty(0, cnt++ , dtData,         250,    daCenter,    false,    "loc_nm",          false,    "",    dfNone,        0,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cre_dt",          false,    "",    dfUserFormat2, 0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "cre_usr_id",      false,    "",    dfNone,        0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         105,    daCenter,    false,    "upd_dt",          false,    "",    dfUserFormat2, 0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    false,    "upd_usr_id",      false,    "",    dfNone,        0,    false,    false);

                     InitUserFormat2(0, "upd_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
                     InitDataValid(0, "loc_ams_port_cd", vtEngUpOther, "1234567890");
                     InitDataValid(0, "loc_cd", vtEngUpOther, "1234567890");

                     CountPosition = 0;
                 }
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;


          switch(sAction)
         {

            case IBSEARCH:      //조회
				 sheetObj.WaitImageVisible = false;
				 ComOpenWait(true);
            	 formObj.f_cmd.value = SEARCH;
				 sheetObj.DoSearch("EES_CTM_0461GS.do", FormQueryString(formObj));
				 ComOpenWait(false);
				 sheetObj.WaitImageVisible = true;
                 break;

              case IBSAVE:        //저장
              	 if(validateForm(sheetObj,formObj,sAction)) {
              		formObj.f_cmd.value = MULTI;
              		sheetObj.DoSave("EES_CTM_0461GS.do", FormQueryString(formObj));
              	 }
                 break;
         }

     }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 다시 조회 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            ComShowCodeMessage("CTM10022", "US AMS Location");
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }


 	     /**
 	      * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
 	      * @param {sheetObj} String : 해당 IBSheet셀 명
 	      * @param {Row} Long : 해당 셀의 Row Index
 	      * @param {Col} Long : 해당 셀의 Column Index
 	      * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 	      * @param {CellX} Long : 해당셀의 X좌표
 	      * @param {CellY} Long : 해당셀의 Y좌표
 	      * @param {CellW} Long : 해당셀의 가로 넓이값
 	      * @param {CellH} Long : 해당셀의 세로 높이값
 	      */
 	     function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
 	         if (sheetObj.ColSaveName(Col) != "del_chk") {
 	             // row클릭시 해당 Check Box도 체크
 	             with(sheetObj) {
 	                 // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
 	                 var sRowStr = GetSelectionRows("/");
 	                 var arr = sRowStr.split("/");
 	                 if (arr.length > 1) {
// 	                     ComOpenWait(true);
 	                     for (i=0; i<arr.length; i++) {
 	                         if (CellEditable(Row, "del_chk")) {
 	                             CellValue2(arr[i], "del_chk") = "1";    // 선택된 행의 CheckBox 체크
 	                         }
 	                     }
// 	                     ComOpenWait(false);
 	                 }
 	             }
 	         }
 	     }


		/**
		 * Sheet가 변경 되었을때 Col에 따라  PORT의 내용이 유효한지 검사한다.
		 * 변경된 칼럼이 LOC 라면 동일한 자료가 중복 등록 되었는지도 검사한다.
		 * PORT 와 LOC가 각각 Unique로 설정되어 있어 각각 중복 체크한다
		 * @param sheetObj
		 * @param Row
		 * @param Col
		 * @param Value
		 */
 	    function sheet1_OnChange(sheetObj, Row, Col, Value) {
 	    	var SaveName = sheetObj.ColSaveName(Col);
 	    	if (SaveName == "loc_ams_port_cd") {
 	    		var coCtmXml = sheetObj.GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH19 + "&code_value=" + Value + "&column_nm=LOC_AMS_PORT_CD&table_nm=CTM_AMS_LOC");
 	    		var rtnValue = ComGetEtcData(coCtmXml, "rtnValue");
 	    		if (rtnValue) {
 	    			if (rtnValue == "1") {
 	    				ComShowCodeMessage("CTM30011", "")
 	    				sheetObj.CellValue2(Row, Col) = "";
 	    				sheetObj.SelectCell(Row, Col, true);
 	    				return;
 	    			} else {
 	    				return;
 	    			}
 	    		} else {
 	    			return;
 	    		}

 	    	} else if (SaveName == "loc_cd") {
 	    		var coCtmXml = sheetObj.GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH05 + "&p_yard1=" + Value);
 	    		var rtnValue = ComGetEtcData(coCtmXml, "rtnValue");
 	    		if (rtnValue == null || rtnValue == '' || rtnValue == 'undefined') {
 	    			sheetObj.LoadSearchXml(coCtmXml)
	    			sheetObj.CellValue2(Row, Col) = "";
 	    			sheetObj.CellValue2(Row, "loc_nm") = "";
 	    			sheetObj.SelectCell(Row, Col, true);
 	    		} else {
 	    			sheetObj.CellValue2(Row, "loc_nm") = rtnValue;
/*
 	    			findValue = false;
 	    			for (i = 1; i <= sheetObj.LastRow; i++) {
 	    				if (i != Row && Value == sheetObj.CellValue(i, "loc_cd")) {
 	    					findValue = true;
 	    					break;
 	    				}
 	    			}
 	    			if (findValue == false)
 	    				sheetObj.CellValue2(Row, "loc_nm") = rtnValue;
 	    			else {
 	    				ComShowCodeMessage("CTM30011", "")
 	    				sheetObj.CellValue2(Row, Col) = "";
 	    				sheetObj.SelectCell(Row, Col, true);
 	    			}
 */
 	    		}
 	    	}
 	    }
	/* 개발자 작업  끝 */