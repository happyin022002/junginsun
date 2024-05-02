/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0460.js
*@FileTitle : VL/VD update status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.09.25 우경민
* 1.0 Creation
* --------------------------------------------------------
* History
* 2013.07.02 김상수 [CHM-201325058-01] BKG/MVMT VL/VD unmatch Inquiry 기준 값 변경(Yard ->Location)
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
     * @class EES_CTM_0460 : EES_CTM_0460 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0460() {
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
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

				case "btn_Retrieve":
						if (checkFormField())
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
							break;

				case "btn_Detl":
	               	 row = sheetObjects[0].SelectRow ;
	               	 if (row < 2) return;
	               	 etdDt  = sheetObjects[0].CellText(row, "etd");
	            	 stsCd = document.form.p_status.value;
	            	 yard  = sheetObjects[0].CellValue(row, "port");
	            	 vvdCd = sheetObjects[0].CellValue(row, "vvd");
	            	 url = "EES_CTM_0413.do?etdDt=" + etdDt + "&stsCd=" + stsCd + "&yard=" + yard + "&vvdCd=" + vvdCd;
                	 rtnValue = ComOpenPopup(url, 1020, 682, "", "0,1");
					break;

				case "btn_New":
						document.form.reset();
						sheetObjects[0].RemoveAll();
						break;

				case "btn_Calendar2":
 		        	var cal = new ComCalendarFromTo();
		        	    cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
 		        	 break;

				case "sel_port":
					if (formObject.sel_port[0].checked) {
	 		        	formObject.p_yard1.className = "input1";
					} else {
	 		        	formObject.p_yard1.className = "input";
	 		        	formObject.p_yard1.value = "";
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
         // CTM-COMMON (& 예외처리)
         setEventProcess("p_vvd");
         // OnKeyPress 이벤트 (공통function)
         axon_event.addListener("blur", "vvd_change", "p_vvd");
         axon_event.addListener("keyup", "vvd_keyUp", "p_vvd");
         axon_event.addListener("keypress", "obj_keypress", "p_vvd");
         document.form.p_date1.focus();
     }
	 /**
	  * VVD Code에서 Focus가 빠져 나갈 때 9자리가 입력 되지 않았을 경우 Focus를 VVD에 고정함
	  * @param event
	  */
      function vvd_change(event) {
      	eventElement = event.srcElement;
      	var vvdCode = eventElement.value;
      	if (vvdCode == '') return;
      	if (vvdCode.length != 9) {
      		eventElement.select();
      		eventElement.focus();
      	}

      }

	 /**
	  * VVD Code에서 Keyboard Event가 발생하면 길이를 체크 한 후 유효성 검사를 진행 함
	  * @param event
	  */
      function vvd_keyUp(event) {
      	eventElement = event.srcElement;
      	var vvdCode = eventElement.value;
      	if (vvdCode.length == 9) {
      		vvd_check(event);
      	}
      }
	 /**
	  * VVD Code의 유효성 검사
	  */
      function vvd_check() {
      	formObj = document.form;
      	sheetObj = sheetObjects[0];
  		strQuery  =  "f_cmd=" + SEARCH02 + "&p_vvd=" + formObj.p_vvd.value
  		if (formObj.p_status.value = "VL")
  			strQuery  =  strQuery + "&p_pol=" + formObj.p_yard1.value;
  		else
  			strQuery  =  strQuery + "&p_pod=" + formObj.p_yard1.value;
  		rtnXml = sheetObj.GetSearchXml("EES_CTM_0406GS.do",  strQuery );

  		rtnValue = ComGetEtcData(rtnXml, "rtnStr");
  		rtnStr = rtnValue.split("|");

  		status = document.form.p_status.value;
  		if (rtnStr.length == 2) {
  			if (status == 'VL' || status == 'VD') {
  				str = rtnStr[0];
  			}
  			etaEtdPass = true;
  		} else {
  			etaEtdPass = false;
  			ComShowCodeMessage("CTM20073");
  			//alert ("VVD Code is Not Exists")
  			formObj.p_vvd.select();
  			formObj.p_vvd.focus();
  			return false;
  		}
  		return true;
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
                     style.height = 460;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|VVD Code|Lane|ETA(VD) or ETD(VL)|Port|Full|Full|Full|Full|Full|Empty|Empty|Empty|Empty|Empty";
                     var HeadTitle2 = "|Seq.|VVD Code|Lane|ETA(VD) or ETD(VL)|Port|Plan (BKG)|EDI|Manual|Total|Result|Plan (BKG)|EDI|Manual|Total|Result";

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle2), 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                     InitDataProperty(0, cnt++, dtHiddenStatus, 0,     daLeft,      false,   "ibflag" );
                     InitDataProperty(0, cnt++, dtDataSeq,      30,    daRight,     false,   "SEQ");
                     InitDataProperty(0, cnt++, dtData,         70,    daCenter,    true,    "vvd");
                     InitDataProperty(0, cnt++, dtData,         40,    daCenter,    true,    "lane");
                     InitDataProperty(0, cnt++, dtData,         120,   daCenter,    true,    "etd");
                     InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "port");

                     InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,    "bkg1");
                     InitDataProperty(0, cnt++, dtData,         57,    daCenter,    true,    "edi1");
                     InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "man1");
                     InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "total1");
                     InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "result1");

                     InitDataProperty(0, cnt++, dtData,         80,    daCenter,    true,    "bkg2");
                     InitDataProperty(0, cnt++, dtData,         57,    daCenter,    true,    "edi2");
                     InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "man2");
                     InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "total2");
                     InitDataProperty(0, cnt++, dtData,         60,    daCenter,    true,    "result2");

                     RequestTimeOut = 6000;
                     CountPosition = 0;
                     HeadRowHeight = 24;
                     SetMergeCell (0,1, 2,1);
                 }
                 break;

         }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                    if (ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "M", 1),'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
                        ComShowCodeMessage("CTM30012", "1 month");
                        return;
                    }
                    //Area 선택 시 조회기간 7일 이내로 제한 로직 추가]
                    if(ComGetObjValue(formObj.sel_port) == "AREA"){
	                    if(ComGetDaysBetween(ComGetUnMaskedValue(formObj.p_date1.value, 'ymd'),ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) > 6){
	                    	ComShowCodeMessage("CTM30012", "7 days");
	                    	formObj.p_date1.focus();
	                    	return;
	                    }
                    }
                    sheetObj.RemoveAll();
                    ComBtnDisable("btn_Retrieve");
                    ComBtnDisable("btn_New");
                    // BackEnd Job 호출. backend job의 호출 Command 는 COMMAND1, SEARCH SEARCHLIST  순서이다(공통 표준은 아님.)
                    ComOpenWait(true);
                    sheetObj.WaitImageVisible = false;
                    formObj.f_cmd.value = COMMAND01;
                    var sXml = sheetObj.GetSearchXml("EES_CTM_0460GS.do", FormQueryString(formObj));
                    var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey")
                    // timer에 설정된 3000은 3000miliSec임. 3초.
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value = backendJobKey;
                        sheetObj.WaitImageVisible = false;
                        sheetObj.RequestTimeOut = 10000;
                        // setInterval에 의해 3초마다 한번씩 getBackEndJobStatus을 호출하게 된다
                        timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
                    }
                }
                break;
        }
    }


    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
     		if (sAction == IBSEARCH) {
    	          if (cancelDate == false){
    	        	  return false;
    	          }
     		}
        }
        return true;
    }


    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        sheetObj.CellBackColor(i, "EventDate") = sheetObj.RgbColor(204, 255, 253);
    }


    /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     */
    function getBackEndJobStatus() {
        formObj = document.form;
        var sheetObject1 = sheetObjects[0];
        formObj.f_cmd.value = SEARCH;
        sheetObject1.WaitImageVisible = false;
        var sXml = sheetObject1.GetSearchXml("EES_CTM_0460GS.do", FormQueryString(formObj));
        var jobState = ComGetEtcData(sXml, "jb_sts_flg")

        if (jobState == "3") {
            getBackEndJobLoadFile();
            clearInterval(timer);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
        } else if (jobState == "4") {
            // BackEndJob을 실패 하였습니다.
            ComShowCodeMessage('CTM10024');
            ComOpenWait(false);
            clearInterval(timer);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
        } else if (jobState == "5") {
            // 이미 BackEndJob 결과 파일을 읽었습니다.
            ComShowCodeMessage('CTM10024');
            ComOpenWait(false);
            clearInterval(timer);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
        }
     }


    /**
     * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital)
     */
    function getBackEndJobLoadFile() {
        formObj = document.form;
        formObj.f_cmd.value = SEARCHLIST;
        var sheetObj = sheetObjects[0];
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        var sXml = sheetObj.DoSearch4Fx("EES_CTM_0460GS.do", FormQueryString(formObj));
        ComOpenWait(false);
    }


    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event<br>
     * @param {shtObj} String : 해당 IBSheet Object
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     */
    function sheet1_OnDblClick(shtObj, Row, Col) {
        var etdDt = shtObj.CellText(Row, "etd");
        var stsCd = document.form.p_status.value;
        var port = shtObj.CellValue(Row, "port");
        var vvdCd = shtObj.CellValue(Row, "vvd");
        
        //restuff, ttl 체크 시 EES_CTM_0413 화면으로 체크여부 보내기
        var restuff;
        if(document.form.restuff.checked){
        	restuff = "Y";
        }else{
        	restuff = "N";
        }
        var ttl;
        if(document.form.ttl.checked){
        	ttl = "Y";
        }else{
        	ttl = "N";
        }
        var url = "EES_CTM_0413.do?etdDt=" + etdDt + "&stsCd=" + stsCd + "&yard=" + port + "&vvdCd=" + vvdCd + "&restuff=" + restuff + "&ttl=" + ttl +"&flg=Y";
        rtnValue = ComOpenPopup(url, 1020, 682, "", "0,1");
    }

/* 개발자 작업  끝 */