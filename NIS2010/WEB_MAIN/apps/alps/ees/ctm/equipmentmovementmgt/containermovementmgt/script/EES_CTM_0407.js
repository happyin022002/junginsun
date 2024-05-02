/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : EES_CTM_0407.js
 * @FileTitle : Domestic MVMT
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.07.20
 * @LastModifier : 우경민
 * @LastVersion : 1.0
 * 2009.07.20 우경민 1.0 Creation
 * 2015.10.20 Sang-Hyun Kim 1.1 [CHM-201538334] CTM : OP-> CP 변경 logic추가 by 양양선 부장님
 *  - 이전 단계가 OP일 경우 Domestic movement가 추가되면 OP -> CP 변경 후 정상 로직 처리하도록 수정
 */

/**
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 */


    /**
     * @extends
     * @class EES_CTM_0407 : EES_CTM_0407 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0407() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var comboObjects = new Array();
 var comboCnt = 0;

 var sheetContainerFlg = null;
 var sheetBkgValue = "";
 var crntBkgValue = false;
 var sheetBkgValueFlg = null;
 var selectedRow = null;
 var etaEtdPass = true;
 var focusCheck = true;

 // 오류가 난 행에서 다른 오류 행을 클릭 했을 경우 무한루프에 빠지는 것을 방지.
 var errorRow = -1;
 var errorBack = -1;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var frmObj = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {


 		        case "btn_add":
		        	 var stsCond = frmObj.p_status.value ;
 		        	 var frmObj = document.form;
 		        	 if (checkFormField()) {
 		        		 if (frmObj.p_yard2.Code == '') {
 		        			 ComShowCodeMessage("CTM10049", "yard cd");
 		        			 frmObj.p_yard1.focus();
 		        			 return;
 		        		 }

 		        		 var Row = sheetObject.DataInsert(-1);
 		        		 sheetObject.CellValue(Row, "cnmv_evnt_dt") = frmObj.p_date0.value;
 		        		 sheetObject.CellValue(Row, "org_yd_cd") = frmObj.p_yard1.value + document.getElementById("p_yard2").Code;
 		        		 sheetObject.CellValue(Row, "mvmt_sts_cd") = frmObj.p_status.value;
 		        		 sheetObject.CellValue(Row, "cnmv_yr") = frmObj.p_date0.value.substring(0,4);
 	 		        	 if (stsCond == 'VL' || stsCond == 'VD') {
 	 		        		 sheetObj.CellEditable(Row, 7) = false;
 	 		        		 sheetObj.CellEditable(Row, "cnmv_evnt_dt") = false;
 	 		        	 } else {
 	 		        		 sheetObj.CellEditable(Row, 7) = true;
 	 		        		 sheetObj.CellEditable(Row, "cnmv_evnt_dt") = true;
 	 		        	 }

 	 		        	 sheetObj.SelectCell(Row, 3);
 	                     setElementDisable(true);
 		        	 }

                     break;
                 case "btn_delete":
                	 var sRowStr = sheetObject.FindCheckedRow("del_chk");
                	 // 자바 스크립트 배열로 만들기
                	 var arr = sRowStr.split("|");
                	 var stsCond = frmObj.p_status.value ;
                	 var delTarget = new Array();
                	 for (i=0; i<arr.length - 1; i++) {
                		 delTarget[i] = arr[i];    // 삭제를 위해 선택row의 Status를 D로 변경
                	 }

                	 for (i = delTarget.length; i >= 0; i--) {
                		 if (delTarget[i])
                			 sheetObject.RowDelete(delTarget[i], false);
                	 }
                     break;

                 case "btn_loadExcel":
                     if (sheetObject.LastRow >= 1) {
                    	 if (ComShowCodeConfirm("CTM20110") != true)
                    		 return;
                    	 else
                    		 sheetObject.RemoveAll();
                     }
                	 rtn = sheetObject.LoadExcel();
                     if (rtn == true) {
	                     checkValidation();
	                     setElementDisable(true);
                     }
                    break;

                 case "btn_new":
                     sheetObject.RemoveAll();
                     document.form.p_yard2.RemoveAll();
	               	 document.getElementsByName("p_yard1")[0].value = "";
                     srcValue = "";
                     sheetContainer = "";
                     status = document.form.p_status.value;
            		 // 날짜를 초기화 한다. 현재 시간을 event 시간으로 입력.
            		 strTime = new Date();
            		 y = strTime.getYear();
            		 m = strTime.getMonth() + 1;
            		 d = strTime.getDate();
            		 if (m < 10) m = "0" + m;
            		 if (d < 10) d = "0" + d;
            		 document.form.p_date.value = y + "-" + m + "-" + d;

                     digital = new Date();
                     hours = digital.getHours();
                     minutes = digital.getMinutes();
                     if (minutes < 10) minutes = "0" + minutes;
                     if (hours < 10) hours = "0" + hours;
                     document.form.p_time.value = hours + ":" + minutes;
                     document.form.p_date0.value = document.form.p_date.value + " " +  document.form.p_time.value;
                     setElementDisable(false);
                     break;

                 case "btn_save":
                     doActionIBSheet(sheetObject,frmObj,IBSAVE);
                     break;
  		         case "btn_Calendar1":
                     if (!window.event.srcElement.disabled) {
                         frmObj = document.form;
                         var cal = new ComCalendar();;
                         cal.select(frmObj.p_date, 'yyyy-MM-dd');
                         if (!document.layers && !document.all) return;
                         digital = new Date();
                         hours = digital.getHours();
                         minutes = digital.getMinutes();
                         if (minutes < 10) minutes = "0" + minutes;
                         if (hours < 10) hours = "0" + hours;
                         frmObj.p_time.value = hours + ":" + minutes;
                         frmObj.p_date0.value = frmObj.p_date.value + " " + frmObj.p_time.value;

                         frmObj.p_date.focus();
                         //cal.ComCalendar_select(frmObj.p_date0, 'yyyyMMdd');
                     }
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
         // IBMultiCombo초기화
         for(var k=0;k<comboObjects.length;k++){
             initCombo(comboObjects[k],k+1);
         }

         setEventProcess("p_status", "p_yard1", "p_date0", "p_date", "p_time");
         axon_event.addListener('change', 'status_Change', 'p_status');
         axon_event.addListener('keyup', 'yard_Change', 'p_yard1');
         axon_event.addListener('blur', 'date_Change', 'p_date');
         axon_event.addListener('focus', 'date_focus', 'p_date');
         axon_event.addListener('change', 'time_Change', 'p_time');

         axon_event.addListener('keypress', 'obj_FormatString', "p_status", "p_yard1", "p_date0", "p_date", "p_time");

         document.form.p_status.focus();
         sheetObj = sheetObjects[0];
		 // 날짜를 초기화 한다. 현재 시간을 event 시간으로 입력.
		 strTime = new Date();
		 y = strTime.getYear();
		 m = strTime.getMonth() + 1;
		 d = strTime.getDate();
		 if (m < 10) m = "0" + m;
		 if (d < 10) d = "0" + d;
		 document.form.p_date.value = y + "-" + m + "-" + d;

         digital = new Date();
         hours = digital.getHours();
         minutes = digital.getMinutes();
         if (minutes < 10) minutes = "0" + minutes;
         if (hours < 10) hours = "0" + hours;
         document.form.p_time.value = hours + ":" + minutes;
         document.form.p_date0.value = document.form.p_date.value + " " +  document.form.p_time.value;

     }

      /**
       * 콤보 Text, Value셋팅
       * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
       * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다
       */
      function initCombo(comboObj, comboId) {
          var frmObj = document.form;
          with (comboObj) {
              UseCode = true;
              switch(comboId) {
                  default:
        				with (comboObj) {
    					MultiSelect = false;
    					UseAutoComplete = true;
    					SetColAlign("left|left");
    					SetColWidth("30|200");
    					BackColor = "#CCFFFD";
    					FontColor = "#373737";
    					ColBackColor(0) = "#7F9DB9";
    					ColFontColor(0) = "#373737";
    					ColBackColor(1) = "#EFEFEF";
    					ColFontColor(1) = "#373737";
    					DropHeight = 160;
    				}
    				break;

              }
          }

      }
      /**
      * IBCombo Object를 배열로 등록
      * param : combo_obj ==> 콤보오브젝트
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
         comboObjects[comboCnt++] = combo_obj;
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
                     style.height = 402;
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
                     InitColumnInfo(21, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     var HeadTitle = "|Seq.||Container No.|Container No.|T/S|STS|Event Date|Seal No.|Chassis No.|M.G Set|S/P|Mode|Return YD|Return YD|Remark(s)|Error Message|OrgYd|StsCd|cnmv_yr ";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]



                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daLeft,  	false,     "ibflag" );
                     InitDataProperty(0, cnt++ , dtDataSeq,      40,    daRight,   false,     "SEQ");
                     InitDataProperty(0, cnt++ , dtDummyCheck,     30,    daCenter,  false,     "del_chk",     	false,          "",      dfNone      );
                     InitDataProperty(0, cnt++ , dtData,      		84,    daLeft,  false,     "cntr_no",   false,          "",      dfNone,  0,        true,      true,      10,     true,     true,      "");
                     InitDataProperty(0, cnt++ , dtData,      		20,    daCenter,  false,     "check_digit",     			false,          "",      dfNone     , 0, false, false );
                     InitDataProperty(0, cnt++ , dtData,      		28,    daCenter,  false,     "cntr_tpsz_cd",     			false,          "",      dfNone      ,  0,        false,      false,      10,     false,     true,      "type/size");
                     InitDataProperty(0, cnt++ , dtData,      		28,    daCenter,  false,     "prev_sts_cd",     		false,          "",      dfNone      ,  0,        false, false);
                     InitDataProperty(0, cnt++ , dtData,      		100,   daCenter,  false,     "cnmv_evnt_dt",   false,          "",      dfUserFormat2 ,   0, false, false  );
                     InitDataProperty(0, cnt++ , dtData,      		84,    daCenter,  false,     "cntr_seal_no",     		false,          "",      dfNone      );
                     InitDataProperty(0, cnt++ , dtData,      		93,    daCenter,  false,     "chss_no",     false,          "",      dfNone      );
                     InitDataProperty(0, cnt++ , dtData,      		85,    daCenter,  false,     "mgst_no",     			false,          "",      dfNone      );
                     InitDataProperty(0, cnt++ , dtPopup,     		56,    daCenter,  false,     "vndr_seq",     			false,          "",      dfNone      , true, true);
                     InitDataProperty(0, cnt++ , dtData,      		37,    daCenter,  false,     "mvmt_trsp_mod_cd",     		false,          "",      dfNone      );
                     InitDataProperty(0, cnt++ , dtData,      		70,    daCenter,  false,     "dest_yd_cd",     	false,          "",      dfNone      );
                     InitDataProperty(0, cnt++ , dtData,      		37,    daCenter,  false,     "spcl_cgo_flg",     		false,          "",      dfNone      ,  0,        true,      true,      10,     false,     true,      "Special");
                     InitDataProperty(0, cnt++ , dtData,      		130,   daLeft,    false,     "cnmv_rmk",     	false,          "",      dfNone      ,  0,        true,      true,		30);
                     InitDataProperty(0, cnt++ , dtData,      		230,   daLeft,    false,     "errMsg",     	false,          "",      dfNone      ,  0,        true,      true,		30);
                     InitDataProperty(0, cnt++ , dtHidden,      	130,   daCenter,  false,     "org_yd_cd",     	false,          "",      dfNone      ,  0,        true,      true,		30);
                     InitDataProperty(0, cnt++ , dtHidden,     		130,   daCenter,  false,     "mvmt_sts_cd",     	false,          "",      dfNone      ,  0,        true,      true,		30);
                     InitDataProperty(0, cnt++ , dtHidden,     		130,   daCenter,  false,     "cnmv_yr",     	false,          "",      dfNone      ,  0,        true,      true,		30);
                     InitDataProperty(0, cnt++ , dtHidden,     		130,   daCenter,  false,     "saveChk",     	false,          "",      dfNone      ,  0,        true,      true,		30);

                     InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:" );
                     InitDataValid(0, "cntr_no"                , vtEngUpOther, "1234567890");
                     InitDataValid(0, "check_digit"            , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_tpsz_cd"           , vtEngUpOther, "1234567890");
                     InitDataValid(0, "prev_sts_cd"            , vtEngUpOther, "1234567890");

                     InitDataValid(0, "cntr_seal_no"           , vtEngUpOther, "1234567890");
                     InitDataValid(0, "chss_no"                , vtEngUpOther, "1234567890");
                     InitDataValid(0, "mgst_no"                , vtEngUpOther, "1234567890");
                     InitDataValid(0, "mvmt_trsp_mod_cd"       , vtEngUpOther, "1234567890");
                     InitDataValid(0, "dest_yd_cd"             , vtEngUpOther, "1234567890");
                     InitDataValid(0, "spcl_cgo_flg"           , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cnmv_rmk"               , vtEngUpOther, "1234567890");

 					 CountPosition = 0;
 					 FrozenCols = 5;
 					 SelectHighLight = false;

                }
                 break;



         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,frmObj,sAction) {
         sheetObj.ShowDebugMsg = false;


          switch(sAction)
         {

              case IBSAVE:        //저장
               if(validateForm(sheetObj,frmObj,sAction))
            	   idx = 1;
	        	   startId = 1;
	        	   endId = startId + 10;
/*
	        	   while (idx <= sheetObj.LastRow) {
	            	   if (sheetObj.LastRow < endId) endId = sheetObj.LastRow;

	        		   for (idx = startId; idx <= endId; idx++) {
	        			   sheetObj.CellValue2(idx, "saveChk") = "1";
	        		   }
*/
	        	   	   ComOpenWait(true);
	        	   	   sheetObj.WaitImageVisible = false;
	            	   frmObj.f_cmd.value = MULTI;

	            	   rtnXml = sheetObj.GetSaveXml("EES_CTM_0407GS.do",  sheetObj.GetSaveString() + "&" + FormQueryString(frmObj) );
	                   rtnStr = ComGetEtcData(rtnXml, "rtnStr");
	                   rtnStrV = rtnStr.split("^^")

	                   for (i = 0; i < rtnStrV.length-1; i++) {
	                	   sheetObj.CellValue(Number(i) + 1, "errMsg") = rtnStrV[i];
	                	   sheetObj.CellValue(Number(i) + 1, "saveChk") = "";
	                   }
	            	   for (idx = sheetObj.LastRow; idx >= 1; idx--) {
	            		   if (sheetObj.CellValue(idx, "errMsg") == '' || sheetObj.CellValue(idx, "errMsg") == 'null') {
	            			   sheetObj.RowDelete(idx, false);
	            		   }
	            	   }
	            	   if (sheetObj.LatRow > 0) ComShowCodeMessage("CTM20113");
	        	   	   ComOpenWait(false);
	        	   	   sheetObj.WaitImageVisible = true;
                 break;

         }

     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,frmObj,sAction){
         with(frmObj){
//             if (!isNumber(frmObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }


	 function sheet_OnPopupClick(sheetObj, Row,Col)
	 {
	     alert("Popup [" + Row + ", " + Col + "]");
	 }



     function date_Change() {

    		obj = document.form.p_date;
    		objValue = obj.value;
    		// 전체 내용중 -를 삭제.
    		if (objValue == '' || objValue.length < 8) return;
    		objValue = ComGetMaskedValue(objValue, "ymd")
    		if (objValue != false) {
    			obj.value = objValue;
    			if (obj.name == "p_date") {
    				//document.form.p_date0.select();
    			}
    		} else {
    			ComShowCodeMessage("CTM00001");
    			//obj.value = objValue;
    			obj.select();
    			obj.focus();
    			return;
    		}
    		document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value
    		idx    = document.form.p_date0.value;
    		offSet = getTimeDiff(idx);
    		status = document.form.p_status.value

			if (offSet >= 1)  {
				//alert ("Event date can't exceed+0 Days from today.");
				ComShowCodeMessage("CTM20053");
    			obj.select();
    			obj.focus();
			}
     }
     function time_Change() {

 		obj = document.form.p_time;
 		objValue = obj.value;
 		// 전체 내용중 -를 삭제.
 		objValue = ComGetMaskedValue(objValue, "hm")
 		if (objValue != false) {
 			obj.value = objValue;
 			if (obj.name == "p_time") {
 				//document.form.p_date0.select();
 			}
 		} else {
 			ComShowCodeMessage("CTM00001");
 			//obj.value = objValue;
 			obj.select();
 			obj.focus();
 			return;
 		}
 		document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value
 		idx    = document.form.p_date0.value;
 		offSet = getDateDiff(idx);
 		status = document.form.p_status.value

 		if (status == 'VL' || status == 'VD') {
 			if (offSet > 7) {
 				//alert ("Event date can't exceed+7 days from today.");
 				ComShowCodeMessage("CTM10054");
 				obj.select();
 				obj.focus();
 			}
 		} else {
				if (offSet >= 1) {
					//alert ("Event date can't exceed+0 Days from today.");
					ComShowCodeMessage("CTM20053");
	    			obj.select();
	    			obj.focus();
				}
 		}
  }

     /**
      * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
      */
    function getDateDiff(idx) {

    	  endDt = idx.substring(0,4) + idx.substring(5,7) + idx.substring(8,10);
          strTime = new Date();
      	  y = strTime.getYear();
      	  m = strTime.getMonth() + 1;
      	  d = strTime.getDate();
      	  h = strTime.getHours();
      	  n =strTime.getMinutes();
      	  if (m < 10) m = "0" + m;
      	  if (d < 10) d = "0" + d;
      	  if (h < 10) h = "0" + h;
      	  if (n < 10) n = "0" + n;
          strDt = y + m + d ;
          if (endDt > strDt) return 999;

    /*
		 var startDt = new Date();
		 var endDt = new Date(Number(idx.substring(0,4)),Number(idx.substring(5,7))-1,Number(idx.substring(8,10)));
		 resultDt = Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));
	*/
		 return resultDt;
     }


   /**
    * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
    */
  function getTimeDiff(idx) {

			 var startDt = new Date();
			 var endDt = new Date(Number(idx.substring(0,4)),Number(idx.substring(5,7))-1,Number(idx.substring(8,10)), Number(idx.substring(11,13)), Number(idx.substring(14,16)));
			 resultDt = Math.floor(endDt.valueOf()/(60*60*1000)- startDt.valueOf()/(60*60*1000));

			 return resultDt;
   }

    /**
     * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
     */
   function dateTimeDiff(idx1, idx2) {

	   		 var startDt = new Date(Number(idx1.substring(0,4)),Number(idx1.substring(5,7))-1,Number(idx1.substring(8,10)), Number(idx1.substring(11,13)), Number(idx1.substring(14,16)));
 			 var endDt   = new Date(Number(idx2.substring(0,4)),Number(idx2.substring(5,7))-1,Number(idx2.substring(8,10)), Number(idx2.substring(11,13)), Number(idx2.substring(14,16)));
 			 resultDt = Math.floor(endDt.valueOf()/(60*60*1000)- startDt.valueOf()/(60*60*1000));

 			 return resultDt;
    }

    function yard_Change (event) {
    	  eventElement = event.srcElement;
    	  //alert (obj_keyup(event))
    	  if (eventElement.value.length < 5) return;
    	  if (srcValue == eventElement.value) return;
    	  document.form.p_yard2.RemoveAll();
    	  onShowErrMsg = false;
    	  rtn = yard_search()
    	  if (rtn == true && svrChk != 'S') {
    		  //alert ("사용자와 야드의 Server 정보 불 일치");
    		  ComShowCodeMessage("CTM20072");
    		  eventElement.focus();
    		  eventElement.select();
    		  return;
    	  }

    	  //alert (srcValue + ":" +  eventElement.value + "::::" + rtn)
    	  if (rtn == true) {
    		  // 커서 이동
    		  status = document.form.p_status.value;
    		  if (status == 'VL')
    			  document.form.p_pol.value = eventElement.value;
    		  else if (status == 'VD')
    			  document.form.p_pod.value = eventElement.value;

    		  if (curKeyCode == '9') {
	   				// 탭키가 실행되어진 상태이다. 초기화 시키고 종료한다.
	   				curKeyCode = "";
	   				srcValue = event.srcElement.value;
	   			} else {
	   				objTmp = setFocusIndex (eventElement, 1)
	   				try {
	   					objTmp.focus();
	   				} catch (e) {}
		   			curKeyCode = "";
		   			srcValue = event.srcElement.value;
		   			return;

	   			}
    	  } else if (rtn == false){
    		  eventElement.focus();
    		  eventElement.select();
    	  }

		  if (status == 'VL')
			  document.form.p_pol.value = eventElement.value;
		  else if (status == 'VD')
			  document.form.p_pod.value = eventElement.value;

      }
      function status_Change(event) {
    	  frmObj = document.form;
    	  sheetObj = sheetObjects[0];

    	  eventValue = event.srcElement.value;

    	  switch(eventValue) {
    	  case "CP":
    	  case "CO":
    	  case "CI":
    	  case "CD":
    	  case "CM":
    	  case "CE":
    	  case "CT":
    		  clearYard();
    		  break;
    	  }

    	  srcValue = "";
    	  document.form.p_yard1.focus();
      }
      function clearYard() {
    	  frmObj = document.form;
    	  frmObj.p_yard1.value = "";
    	  frmObj.p_yard2.RemoveAll();
    	  sheetObjects[0].RemoveAll();
      }

      function checkValidation() {
    	  p_yardValue = document.getElementById("p_yard2").Code;
          var frmObj  = document.form;
          var status   = frmObj.p_status.value;
          for (idx = 1; idx <= sheetObj.LastRow; idx++) {
        	  cntr_no = sheetObj.CellValue(idx, "cntr_no");
        	  checkDigit = "";
      	    if (cntr_no.length == 11) {
    		 	checkDigit = cntr_no.substring(10,11);
    	 		cntr_no = cntr_no.substring(0,10);

    		 	sheetObj.CellValue(idx, "cntr_no") = cntr_no;
    		 	sheetObj.CellValue(idx, "check_digit") = checkDigit;
    	 	} else if (cntr_no.length == 0)
    	 		sheetObj.CelLValue2(idx, "errMsg") = ("ERR");
     	 	cnmvEvntDt = sheetObj.CellValue(idx, "cnmv_evnt_dt");
     	 	if (cnmvEvntDt == '') {
     	 		sheetObj.CellValue2(idx, "cnmv_evnt_dt") = document.form.p_date0.value;
     	 	}

        	  p_yard1 = frmObj.p_yard1.value;
        	  p_yard2 = frmObj.p_yard2.Code;
        	  sheetObj.CellValue2(idx, "org_yd_cd") = frmObj.p_yard1.value + document.getElementById("p_yard2").Code
        	  sheetObj.CellValue2(idx, "cnmv_sts_cd") = frmObj.p_status.value;
        	  sheetObj.CellValue2(idx, "mvmt_sts_cd") = frmObj.p_status.value;
        	  sheetObj.CellValue2(idx, "cnmv_yr") = frmObj.p_date0.value.substring(0,4);

        	  frmObj.f_cmd.value = SEARCH20;
        	  queryString = "f_cmd=" + SEARCH20 + "&p_cntrno=" + cntr_no + "&p_yard1=" + frmObj.p_yard1.value;

        	  xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
        	  rtnValue = ComGetEtcData(xml, "rtnValue");
        	  val = ComGetEtcData(xml, "TRANS_RESULT_KEY");

        	  if (rtnValue == null || val == 'F') {
        		  sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM10004");
        		  clearGridForErr(sheetObj, idx, "E");
        		  continue;
        	  }	else {
        		  rtnStr = rtnValue.split("|");
        		  sheetObj.CellValue(idx, "cntr_tpsz_cd") = rtnStr[2];
        		  sheetObj.CellValue(idx, "prev_sts_cd") = rtnStr[1];
        		  vr = rtnStr[0].substring(10,11);
        		  if (vr != null)
        			  sheetObj.CellValue(idx, "check_digit") = vr;
        		  if (vr != checkDigit && checkDigit != "") {
        			  sheetObj.CellValue2 (idx, "errMsg") = "Container check digit error" + checkDigit + ":" + vr;
        			  sheetObj.CellValue(idx, "cntr_tpsz_cd") = "";
        			  sheetObj.CellValue(idx, "prev_sts_cd") = "";
        			  sheetObj.CellValue(idx, "check_digit") = "";
        			  clearGridForErr(sheetObj, idx, "E");
        			  continue;
        		  }
      	 		if (rtnStr[4] == 'I') {
  				    sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM10005");
				    clearGridForErr(sheetObj, idx, "E");
    			    continue;
    			}
    	 		if (rtnStr[8] == '0' && status != 'CM') {
  				    sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM20119");
				    clearGridForErr(sheetObj, idx, "E");
    			    continue;
    			}

        		  switch (status) {
        		  case "CM" :
        			  if (rtnStr[5] == 'Y' && (rtnStr[1] == 'MT' || rtnStr[1].substring(0,1) == 'C')) {

        			  } else if (rtnStr[5] != 'Y'){
        				  sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM10007");
        				  clearGridForErr(sheetObj, idx, "E");
            			  continue;
        			  } else {
        				  sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM20117");
        				  clearGridForErr(sheetObj, idx, "E");
            			  continue;
        			  }
        			  break;
        		  default :
        			  if (rtnStr[5] != 'Y') {
        				  sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM10007");
        				  clearGridForErr(sheetObj, idx, "E");
        				  continue;
        			  } else if (rtnStr[5] != 'Y' && (rtnStr[1] != 'CP' || rtnStr[1] != 'CO')) {
        				  if (svrID != 'DUS') {
        					  sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM10007");
        					  clearGridForErr(sheetObj, idx, "E");
        					  continue;
        				  }
        			  } else {
        				  if (rtnStr[1] == 'MT' || rtnStr[1].substring(0,1) == 'C' || rtnStr[1].substring(0,1) == 'I' || rtnStr[1] == 'OP') {
        				  } else {
        					  sheetObj.CelLValue2(idx, "errMsg") = ComGetMsg("CTM20117");
        					  clearGridForErr(sheetObj, idx, "E");
        					  continue;
        				  }
        			  }
        		  	  break;

        		  }

        	  }
          }
      }

      function sheet_OnPopupClick(sheetObj, Row,Col)
      {

          sUrl = "UI_CTM_0435.do";
          iWidth = "620";
          iHeight = "420";
          sFunc = "getServiceProvider";
          sDisplay = "1,0";
          bModal = true;
          sTargetObjList = "vndr_seq";
          iRow = Row;
          iCol = Col;
          iSheetIdx = "";
          sWinName = "Logis Service Provider";
          sheetRow = Row;
          sheetCol = Col;
          ComOpenPopup(sUrl, iWidth, iHeight, 'getVndr', '1,0,1,1,1,1,1');

      }

      function getVndr(aryPopupData, row, col, sheetIdx) {
      	 var frmObj = document.form;
      	 var vndrSeq = "";
      	 var vndrNm = "";
      	 var i = 0;

      	 for(i = 0; i < aryPopupData.length; i++){
      		 vndrSeq = vndrSeq + aryPopupData[i][2];

      		 if(aryPopupData.length == 1){
      			 vndrNm = vndrNm + aryPopupData[i][4];
      		 }

      		 if(i < aryPopupData.length - 1){
      			 vndrSeq = vndrSeq + ",";
      		 }
      	 }

      	 sheetObjects[0].CellValue2(sheetRow, "vndr_seq") = vndrSeq;
      }

      function sheet_OnBeforeEdit(sheetObj, Row, Col) {
      	selectedRow = Row;
          if (Row < 1) return;
      	if (Col == 3) {
      	   sheetContainer = sheetObj.CellValue(Row, Col);
        } else {
          	sheetContainer = "";
          	sheetBkgValue = "";
          	sheetContainerFlg = true;
          	sheetBkgValueFlg = true;
        }
      }

      function sheet_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {

		// 아직 Focus Out이 일어나지 않았음으로 EditValue를 받아서 값을 비교함.
		newValue = sheetObj.EditValue;
		var SaveName = sheetObj.ColSaveName(Col);
		// Validation후 에러가 났을 경우 errorRow에 Line 번호를 저장한다.
		// Error로 인해 값이 변경 될 경우 다시 체크하지 않도록 하기 위해 errorBack에 에러표시해둠
		errorRow = -1;
		errorBack = -1;
		if (Row < 1)
			return;
		if (SaveName == "cntr_no") {
			sheetContainerFlg = false

			if (Row >= sheetObj.HeaderRows) {
				if ((errorRow == Row && newValue.length < 10)) // 에러행과 이전 행이 동일 하고 현재 입력중인 값의 길이가 10자 미만일 경우 그대로 종료한다
					return;
				else if (KeyCode == 86)  {  // 에러 행과 이전 행이 동일하고 컨트롤키가 눌렸을 경우 종료한다
				//	return;
				} else if (Shift != 0)						   // Shift키가 눌린 경우 아직 값이 입력된게 아니기 때문에 종료한다
					return;
				else if (KeyCode < 48 || (KeyCode > 57 && KeyCode < 65) ||  (KeyCode > 90 && KeyCode < 96) || KeyCode > 105) // 키 코드가 유효하지 않을 경우 그리드에 입력되지 못하기 때문에 종료한다
					return;
				if (sheetContainer == newValue && sheetContainerFlg == true) // 이전에 저장했던 값과 현재 값이 동일하고 에러체크를 통과했을 경우 종료한다
					return;
				sheetCheckValue(sheetObj, Row, Col, false);
				return;
			}
		} else if (SaveName == "bkg_no") {
			sheetBkgValueFlg = false;
		}

      }


		function sheet_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
		{
			  // 만일 errorRow가 -1이 아니면 이전라인에서 에러가 발생 한것으로 간주하고 현재 로직을 취소한다.

			  if (NewRow == OldRow && OldCol == NewCol) {
				  return;
			  } else if (errorRow > 0 && (NewRow != errorRow || OldCol != NewCol)) {
				 errorRow = -1;
				 errorBack = -1;
				 return;
			  } else if (errorBack == 1 && (OldRow != NewRow || OldCol != NewCol)) {
				 errorBack = -1;
				 errorRow = -1;
				 //return;
			  } else {
				 var Row = OldRow;
				 var Col = OldCol;

				 newValue = sheetObj.CellValue(Row, Col);
				 var SaveName = sheetObj.ColSaveName(Col);
				 if (Row < 1) return;
				    // 이전 선택 항목이 컨테이너번호이고 내용이 채워져있고 타입사이즈가 비어있는 경우 무조건 실행하도록 한다.
				    if (SaveName == "cntr_no" && sheetObj.CellValue(Row, "cntr_no") != '' && sheetObj.CellValue(Row, "cntr_tpsz_cd") == '') {
						sheetCheckValue(sheetObj, Row, Col, true);
				    } else if (SaveName == "cntr_no") {
				    	if ((sheetContainerFlg == false && Row >= sheetObj.HeaderRows) || (sheetContainerFlg == false && sheetContainer != newValue)) {
				    		sheetCheckValue(sheetObj, Row, Col, true);
				    	}
				    } else if (SaveName == "dest_yd_cd"){
				    	sheetCheckValue(sheetObj, Row, Col, true);
				    } else if (SaveName == "mvmt_trsp_mod_cd") {
				    	sheetCheckValue(sheetObj, Row, Col, true);
				    } else if (SaveName == "cnmv_evnt_dt"){
				          strTime = new Date();
			          	  y = strTime.getYear();
			          	  m = strTime.getMonth() + 1;
			          	  d = strTime.getDate();
			          	  h = strTime.getHours();
			          	  n =strTime.getMinutes();
			          	  if (m < 10) m = "0" + m;
			          	  if (d < 10) d = "0" + d;
			          	  if (h < 10) h = "0" + h;
			          	  if (n < 10) n = "0" + n;
			              strDt = y + "-" + m + "-" + d + " " + h + ":" + n;
			    		  p_date = sheetObj.CellText(Row, "cnmv_evnt_dt");
			    		  offSet = dateTimeDiff(strDt, p_date);
			    		  stsCd = document.form.p_status.value;
			    		  if (stsCd != 'VL' && stsCd != 'VD') {
				    		  if (offSet == "NaN" || offSet > 1) {
					              strTime = new Date();

				              	  y = strTime.getYear();
				              	  m = strTime.getMonth() + 1;
				              	  d = strTime.getDate();
				              	  h = strTime.getHours();
				              	  n =strTime.getMinutes();
				              	  if (m < 10) m = "0" + m;
				              	  if (d < 10) d = "0" + d;
				              	  if (h < 10) h = "0" + h;
				              	  if (n < 10) n = "0" + n;
				                  strDt = y + "-" + m + "-" + d + " " + h + ":" + n;
					              p_date = frmObj.p_date0.value;

					              rValue = dateTimeDiff(strDt, p_date);
					              if (rValue > 3) {
										//alert ("Event date can't exceed+0 Days from today.");
										sheetObj.SelectCell(Row, "cnmv_evnt_dt", true);
										return;
					              }
				    		  }
			    		  }
				    } else if (SaveName == "chss_no"){
				    	if (sheetObj.CellValue(Row, Col) == '') return;
				    	sheetCheckValue(sheetObj, Row, Col, true);
				    } else if (SaveName == "mgst_no"){
				    	if (sheetObj.CellValue(Row, Col) == '') return;
				    	sheetCheckValue(sheetObj, Row, Col, true);
				    }
			 }
		}


       function sheetCheckValue(sheetObj, Row, Col, isOut) {
          var SaveName = sheetObj.ColSaveName(Col);
          var frmObj  = document.form;
          var status   = frmObj.p_status.value;
          switch(SaveName)
           {
               case "cntr_no":
              	 if (isOut)
              		 cntr_no = sheetObj.CellValue(Row, "cntr_no");
              	 else
              		 cntr_no = sheetObj.EditValue;

              	 if (cntr_no.length < 1){
              		 sheetContainerFlg = true;
              		 return;
              	 }
              	 	if (cntr_no.length != 10 && isOut == false) return;

              	 	frmObj.f_cmd.value = SEARCH20;
              	 	p_yard1 = frmObj.p_yard1.value;
              	 	p_yard2 = frmObj.p_yard2.Code;
              	 	queryString = "f_cmd=" + SEARCH20 + "&p_cntrno=" + cntr_no + "&p_yard1=" + p_yard1;

              	 	xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
              	 	rtnValue = ComGetEtcData(xml, "rtnValue");
              	 	val = ComGetEtcData(xml, "TRANS_RESULT_KEY");

              	 	if (rtnValue == null || val == 'F') {
              	 		ComShowCodeMessage("CTM10004");
              	 		clearGridForErr(sheetObj, Row, "E");
              	 		sheetContainerFlg = false;
              	 		sheetObj.SelectCell(Row, Col, true);
              	 		return;
              	 	}
              	 	else {
              	 		rtnStr = rtnValue.split("|");
              	 		sheetObj.CellValue(Row, "cntr_tpsz_cd") = rtnStr[2];
              	 		sheetObj.CellValue(Row, "prev_sts_cd") = rtnStr[1];
            				if (status == "VL" || status == "VD") {
            					sheetObj.CellEditable(i, "cnmv_evnt_dt") = false;
            				} else {
            					sheetObj.CellEditable(i, "cnmv_evnt_dt") = true;
            				}

              	 		vr = rtnStr[0].substring(10,11);
              	 		if (vr != null)
              	 			sheetObj.CellValue(Row, "check_digit") = vr;
              	 		/*******************************************************
              	 		 *  컨테이너 상태를 체크한다.
              	 		 ******************************************************/
              	 		p_yardValue = document.getElementById("p_yard2").Code;
    	 				if (rtnStr[4] == 'I') {
    	 					ComShowCodeMessage("CTM10005");
                  	 		clearGridForErr(sheetObj, Row, "E");
          	 				sheetObj.SelectCell(Row, Col, true);
          	 				return;
    	 				}
    	 		 		if (rtnStr[8] == '0' && status != 'MT') {
          	 				ComShowCodeMessage("CTM20119");
                  	 		clearGridForErr(sheetObj, Row, "E");
          	 				sheetObj.SelectCell(Row, Col, true);
          	 				return;
    	 				}

              	 		switch (status) {
            	 		/**
            	 		 *    rtnStr[0] : 컨테이너 번호
            	 		 *    rtnStr[1] : 컨테이너 현재 상태
            	 		 *    rtnStr[2] : 컨테이너 타입/사이즈
            	 		 *    rtnStr[3] : 컨테이너의 현재 야드
            	 		 *    rtnStr[4] : 컨테이너 ACTIVE 여부
            	 		 *    rtnStr[5] : 사용자 서버 & 컨테이너 지역 동일 여부
            	 		 *    rtnStr[6] : 컨테이너 반출 여부
            	 		 *    rtnStr[7] : 신규컨테이너 여부
            	 		 */
            	 		 //CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, HJS_CRE_FLG, IMDT_EXT_FLG, NEW_FLG
              	 		case "CM" :
              	 			if (rtnStr[5] == 'Y' && (rtnStr[1] == 'MT' || rtnStr[1].substring(0,1) == 'C')) {

              	 			} else if (rtnStr[5] != 'Y'){
              	 				//alert ("Container Is Not Located In This Country!");
              	 				ComShowCodeMessage("CTM10007");
                      	 		clearGridForErr(sheetObj, Row, "E");
              	 				sheetObj.SelectCell(Row, Col, true);
              	 				return;
              	 			} else {
              	 				//alert ("This Is Not A Adequate Container");
              	 				ComShowCodeMessage("CTM20117");
                      	 		clearGridForErr(sheetObj, Row, "E");
              	 				sheetObj.SelectCell(Row, Col, true);
              	 				return;
              	 			}
              	 			 break;
              	 		default :
              	 			if (rtnStr[5] != 'Y') {
              	 				//alert ("Illegal Server ID!");
              	 				ComShowCodeMessage("CTM10007");
                      	 		clearGridForErr(sheetObj, Row, "E");
              	 				sheetObj.SelectCell(Row, Col, true);
              	 				return;
              	 			} else if (rtnStr[5] != 'Y' && (rtnStr[1] != 'CP' || rtnStr[1] != 'CO')) {
              	 				if (svrID != 'DUS' && svrID != 'USA') {
                  	 				//alert ("Illegal Server ID!");
                  	 				ComShowCodeMessage("CTM10007");
                          	 		clearGridForErr(sheetObj, Row, "E");
                  	 				sheetObj.SelectCell(Row, Col, true);
                  	 				return;
              	 				}
              	 			} else {
              	 				if (rtnStr[1] == 'MT' || rtnStr[1].substring(0,1) == 'C' || rtnStr[1].substring(0,1) == 'I' || rtnStr[1] == 'OP') {

              	 				} else {
	              	 				//alert ("This Is Not A Adequate Container");
	              	 				ComShowCodeMessage("CTM20117");
	                      	 		clearGridForErr(sheetObj, Row, "E");
	              	 				sheetObj.SelectCell(Row, Col, true);
	              	 				return;
              	 				}
              	 			}
              	 			 break;


              	 		}
              	 	}
              		sheetContainerFlg = true;
              		clearGridForErr(sheetObj, Row, "S");
                   break;
               case "dest_yd_cd" :

           	 	ydCd = sheetObj.CellValue(Row, "dest_yd_cd");
           	 	if (ydCd.length < 1) return;
        			queryString = "f_cmd=" + SEARCH14 + "&p_yard1=" + ydCd;
   	    		xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
   	    		rtnValue = ComGetEtcData(xml, "rtnValue");
   	    		if (rtnValue == null) {
   	    			ComShowCodeMessage ("CTM10001");
   	    			sheetObj.SelectCell(Row, Col, true);
   	    		}

           	 	break;
	            case "mvmt_trsp_mod_cd" :
	           	 val = sheetObj.CellValue(Row, "mvmt_trsp_mod_cd");
	           	 if (val == '') return;
	           	 if (val != 'T' && val != 'R' && val != 'B') {
	           		 ComShowCodeMessage("CTM10016");
	           		 sheetObj.SelectCell(Row, Col, true);
	           	 }
	           	 break;
	            case "mgst_no":
	       		 queryString = ""; // chss_no
	       	 	 mgset = sheetObj.CellValue(Row, "mgst_no");
	       		 queryString = "f_cmd=" + SEARCH07 + "&p_mgset=" + mgset;
	       		 xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
	       		 rtnValue = ComGetEtcData(xml, "rtnValue");
	       		 rtnName  = ComGetEtcData(xml, "rtnName");
	       		 if (rtnValue != 'OK') {
	       			 ComShowCodeMessage("CTM20115");
	       			 sheetObj.CellValue2(Row, Col) = "";
	      				 sheetObj.SelectCell(Row, Col);
	       		 }
	       		 break;
	            case "chss_no":
	       		 queryString = ""; // chss_no
	       	 	 p_chassis_no = sheetObj.CellValue(Row, "chss_no");
	       		 queryString = "f_cmd=" + SEARCH08 + "&p_chassis_no=" + p_chassis_no;
	       		 xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
	       		 rtnValue = ComGetEtcData(xml, "rtnValue");
	       		 rtnName  = ComGetEtcData(xml, "rtnName");
	       		 if (rtnValue != 'OK') {
	       			 if (!ComShowCodeConfirm("CTM20116")) {
	       				 sheetObj.CellValue2(Row, Col) = "";
	       				 sheetObj.SelectCell(Row, Col);
	       				 return;
	       			 }
	       		 }
	       		 break;
	          }
       }

       function clearGridForErr(sheetObj, Row) {
      	sheetContainerFlg = false;
      	sheetObj.CellValue2(Row, "cntr_tpsz_cd") = "";
       	sheetObj.CellValue2(Row, "check_digit") = "";
       	sheetObj.CellValue2(Row, "prev_sts_cd") = "";
       	setErr(Row);
	 	errorRow = Row;
	 	errorBack = 1;
      }

      function clearGridForErr(sheetObj, Row, Tp) {
    		if (Tp == "E") {
    			sheetContainerFlg = false;
   				sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
   			 	sheetObj.CellValue(Row, "cntr_tpsz_cd") = "";
   			 	sheetObj.CellValue(Row, "prev_sts_cd") = "";

    		 	focusCheck = false;
    		 	setErr(Row);
    		 	errorRow = Row;
    		 	errorBack = 1;
    		} else {
    			//sheetObj.RowBackColor(Row) = sheetObj.RgbColor(241,241,241);
    			sheetObj.Redraw = false;
    			sheetObj.RowBackColor(Row) = 0;
    			for (xx = 1; xx <= sheetObj.LastCol; xx++) {
    				if (!sheetObj.CellEditable(Row, xx))
    					sheetObj.CellBackColor(Row, xx) = sheetObj.RgbColor(241,241,241);;
    			}
    			sheetObj.Redraw = true;
    			errorRow = -1;
    			errorBack = -1;
    		}
    	}

      function setErr(Row) {
    		sheetObj.RowBackColor(Row) = sheetObj.RgbColor(240, 200, 200);
      }
      function setElementDisable(disableType) {
      	 var docForm = document.form;
     	 DomSetFormObjDisable(docForm, disableType);
     		if (disableType) disableType = false;
        		else disableType = true;
        		docForm.p_yard2.Enable = disableType;
     	/*
    		var len = docForm.elements.length - 1;
    		var formElement = null;
    		var elementName = null;
    		for (i = 0 ; i <= len ; i++) {
    			formElement = docForm.elements[i];
    			elementName = getSrcElementName(formElement);
 			if (elementName.substring(0,5) != 'sheet' ) formElement.disabled = disableType;
     	 }
    		if (disableType) disableType = false;
    		else disableType = true;
    		document.form.p_yard2.Enable = disableType;
    		*/
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
      function sheet_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
          if (sheetObj.ColSaveName(Col) != "del_chk") {
              // row클릭시 해당 Check Box도 체크
              with(sheetObj) {
                  // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                  var sRowStr = GetSelectionRows("/");
                  var arr = sRowStr.split("/");

                  if (arr.length > 1) {
                      for (i=0; i<arr.length; i++) {
                          if (CellEditable(Row, "del_chk")) {
                              CellValue(arr[i], "del_chk") = "1";    // 선택된 행의 CheckBox 체크
                          }
                      }
                  }
              }
          }
      }

      /* 개발자 작업  끝 */