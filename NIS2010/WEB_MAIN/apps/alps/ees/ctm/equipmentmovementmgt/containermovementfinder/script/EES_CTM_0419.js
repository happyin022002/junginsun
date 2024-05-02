/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0419.js
*@FileTitle : VL/VD EDI Test Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.31 우경민
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
     * @class EES_CTM_0419 : EES_CTM_0419 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0419() {
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


 		         case "btn_retrieve":
                     if (checkFormField())
                    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                	 break;

 		         case "btn_new":
 					formObject.reset();
 					sheetObject1.RemoveAll();
 					sheetObject2.RemoveAll();
 									break;

 		         case "btn_downexcel":
 		        	sheetObjects[0].Down2Excel(-1);
 									break;

 		         case "btn_detail":
					 // DETAIL POPUP. 그리드 두개에 대해 각각 설정한다
 		        	 var row = sheetObjects[0].SelectRow;
 		        	 if (row < 1) return;
 		        	 cntr_no = sheetObjects[0].CellValue(row, "cntr_no");
 		        	 tpsz_cd = sheetObjects[0].CellValue(row, "cntr_tpsz_cd");
 		        	 cntrNo = cntr_no.substring(0,10);
 		        	 checkDigit = cntr_no.substring(10,11);
 		        	 sUrl = "EES_CTM_0408.do?p_cntrno=" + cntrNo + "&check_digit=" + checkDigit + "&ctnr_tpsz_cd=" + tpsz_cd;
 		        	 iWidth = "1020";
 		             iHeight = "682";
 		             bModal = false;
					 obj = ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);
 		        	 break;
 		         case "btn_downexcel2":
  		        	sheetObjects[1].Down2Excel(-1);
  									break;

 		         case "btn_edimsg":
					// EDI POPUP. 그리드 두개에 대해 각각 설정한다
 		        	var row = sheetObjects[1].SelectRow;
 		        	if (row < 1) return;
 					cntr_no = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cntr_no").substring(0,10);
 					chk_dgt = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cntr_no").substring(10,11);
                    sts_cd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "mvmt_sts_cd");
 					evnt_dt = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "evnt_dt").substring(0,10);
 					svr_id = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "svr_id");
 					sUrl = "EES_CTM_0404.do?pCntrno=" + cntr_no + "&pDate1=" + evnt_dt + "&pDate2=" + evnt_dt + "&ediMvmtStsCd=" + sts_cd + "&mvmtEdiRsltCd=ALL&mvmtEdiMsgAreaCd=" + svr_id + "&checkDigit=" + chk_dgt;
		        	 iWidth = "1020";
 		             iHeight = "682";
 		             bModal = false;
					 obj = ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);
 					break;


 		         case "btn_detail2":
					 // DETAIL POPUP. 그리드 두개에 대해 각각 설정한다
 		        	 var row = sheetObjects[1].SelectRow;
 		        	 if (row < 1) return;
 		        	 cntr_no = sheetObjects[1].CellValue(row, "cntr_no");
 		        	 tpsz_cd = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");
 		        	 cntrNo = cntr_no.substring(0,10);
 		        	 checkDigit = cntr_no.substring(10,11);
 		        	 sUrl = "EES_CTM_0408.do?p_cntrno=" + cntrNo + "&check_digit=" + checkDigit + "&ctnr_tpsz_cd=" + tpsz_cd;
 		        	 iWidth = "1020";
 		             iHeight = "682";
 		             bModal = false;
					 obj = ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);
 		        	 break;

				// MATCH. UNMATCH. TOTAL은 XML을 새로 만든 후 일괄 LoadSearchXml을 통해 화면으로 출력한다
				// 하나씩 선택 해서 Visible을 설정 할 경우 처리 속도가 현저히 떨어지기 때문에
				// 처리 방식을 변경 함.
 		         case "btn_unmatch":
 		        	if (sheetObjects[1].LastRow == 0) return;

 		        	//ComOpenWait(true);
 		        	var sxml = CtmMakeHiddenXml(sheetObjects[0], "1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
 		        	sheetObjects[0].LoadSearchXml(sxml);

 		        	var sxml = CtmMakeHiddenXml(sheetObjects[1], "1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|evnt_dt|svr_id|mat");
 		        	//ComDebug(sxml);
 		        	sheetObjects[1].LoadSearchXml(sxml);

 		        	 document.form.u1.className = 'Obj1';
 		        	 document.form.u2.className = 'Obj1';
		        	 document.form.m1.className = 'Obj2';
 		        	 document.form.m2.className = 'Obj2';
 		        	 document.form.l1.className = 'Obj2';
 		        	 document.form.l2.className = 'Obj2';
					break;

 		         case "btn_match":
 		        	if (sheetObjects[0].LastRow == 0) return;

 		        	//ComOpenWait(true);
 		        	var sxml = CtmMakeHiddenXml(sheetObjects[0], "0", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
 		        	//ComDebug(sxml);
 		        	sheetObjects[0].LoadSearchXml(sxml);

 		        	var sxml = CtmMakeHiddenXml(sheetObjects[1], "0", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|evnt_dt|svr_id|mat");
 		        	//ComDebug(sxml);
 		        	sheetObjects[1].LoadSearchXml(sxml);

 		        	document.form.m1.className = 'Obj1';
 		        	 document.form.m2.className = 'Obj1';
 		        	 document.form.u1.className = 'Obj2';
 		        	 document.form.u2.className = 'Obj2';
 		        	 document.form.l1.className = 'Obj2';
 		        	 document.form.l2.className = 'Obj2';

					break;

 		         case "btn_total":
 		        	 sheetObjects[0].ColHidden("Seq") = false;
 		        	 sheetObjects[1].ColHidden("Seq") = false;
  		        	 sheetObjects[0].ColHidden("sno") = true;
 		        	 sheetObjects[1].ColHidden("sno") = true;
  		        	//ComOpenWait(true);
  		        	var sxml = CtmMakeHiddenXml(sheetObjects[0], "-1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|mat");
  		        	//ComDebug(sxml);
  		        	sheetObjects[0].LoadSearchXml(sxml);

  		        	var sxml = CtmMakeHiddenXml(sheetObjects[1], "-1", "HidSta|Seq|sno|cntr_no|cntr_tpsz_cd|full_fg|mvmt_sts_cd|org_yd_cd|bkg_no|evnt_dt|svr_id|mat");
  		        	//ComDebug(sxml);
  		        	sheetObjects[1].LoadSearchXml(sxml);

 		        	 document.form.l1.className = 'Obj1';
 		        	 document.form.l2.className = 'Obj1';
		        	 document.form.m1.className = 'Obj2';
 		        	 document.form.m2.className = 'Obj2';
 		        	 document.form.u1.className = 'Obj2';
 		        	 document.form.u2.className = 'Obj2';
					 break;

             } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }


     /**
      * 조회조건에 대한 Validation 정리
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function checkValidation(formObject) {
    	 return true;
     }


     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj) {
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
         setEventProcess();
         axon_event.addListener('blur', 'getEtaEtdTime', 'vls_cd');
         axon_event.addListener('blur', 'getEtaEtdTime', 'pol_cd');
         axon_event.addListener( 'click' , 'flgslt_click', "flgrslt" );
         document.form.vls_cd.focus();
     }


    /**
     * 라이오 버튼 클릭시 ETA/ETD 재 조회
     */
    function flgslt_click() {
        getEtaEtdTime();
    }


    /**
     * ETA/ETD 재 조회
     */
    function getEtaEtdTime() {
        formObj = document.form;
        if (formObj.pol_cd.value == "") return;
        if (formObj.vls_cd.value == "") return;
        strQuery  =  "f_cmd=" + SEARCH02 + "&p_vvd=" + formObj.vls_cd.value;
        if (formObj.flgrslt[0].checked) {
            strQuery  =  strQuery + "&p_pol=" + formObj.pol_cd.value;
        } else {
            strQuery  =  strQuery + "&p_pod=" + formObj.pol_cd.value;
        }
        var rtnXml = sheetObjects[0].GetSearchXml("EES_CTM_0406GS.do",  strQuery);
        if (ComGetEtcData(rtnXml, "rtnStr").indexOf("|") > -1) {
            var rtnStr =  ComGetEtcData(rtnXml, "rtnStr").split("|");
            if (formObj.flgrslt[0].checked) {
                str = rtnStr[0];
            } else {
                str = rtnStr[1];
            }
            formObj.eta_etd.value = str;
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
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 382;
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

                     var HeadTitle1 = "|Seq.|Seq.|Container No.|TP/SZ|F/M|STS|ORG YD|Booking No.";


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,  daCenter,  true,     "HidSta");
                     InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  true,     "Seq");
                     InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  true,     "sno");
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,     "cntr_no",  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "cntr_tpsz_cd",     			false,          "",      dfNone, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "full_fg",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "mvmt_sts_cd",   			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  true,     "org_yd_cd",   			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,     "bkg_no",  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  true,     "mat");
                     CountPosition = 0;
                }
                 break;


             case 2:      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 382;
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
                     InitColumnInfo(12, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|Seq.|Container No.|TP/SZ|F/M|STS|ORG YD|MSG|EVNT_DT|SVR_ID";


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);


                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,  daCenter,  true,     "HidSta");
                     InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  true,     "Seq");
                     InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  true,     "sno");
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  true,     "cntr_no",  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "cntr_tpsz_cd",     			false,          "",      dfNone, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "full_fg",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      40,    daCenter,  true,     "mvmt_sts_cd",   			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      65,    daCenter,  true,     "org_yd_cd",   			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "bkg_no",			  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      30,    daCenter,  true,     "evnt_dt",			  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      30,    daCenter,  true,     "svr_id",			  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtHidden,    30,    daCenter,  true,     "mat");

 					CountPosition = 0;
                }
                 break;

         }
     }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch (sAction) {

            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                    ComOpenWait(true);
                    sheetObjects[0].WaitImageVisible = false;
                    sheetObjects[1].WaitImageVisible = false;

                    sheetObjects[0].ColHidden("Seq") = false;
                    sheetObjects[1].ColHidden("Seq") = false;
                    sheetObjects[0].ColHidden("sno") = true;
                    sheetObjects[1].ColHidden("sno") = true;
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DataAutoTrim = false;
                    xml = sheetObj.GetSearchXml("EES_CTM_0419GS.do", FormQueryString(formObj));
                    rtnValue = xml.split("|$$|");
                    sheetObjects[0].LoadSearchXml(rtnValue[0]);
                    sheetObjects[1].LoadSearchXml(rtnValue[1]);
                    var data0 = sheetObjects[0].GetRangeText(sheetObjects[0].HeaderRows, 3, sheetObjects[0].LastRow, 3);
                    var data1 = sheetObjects[1].GetRangeText(sheetObjects[1].HeaderRows, 3, sheetObjects[1].LastRow, 3);
                    var arrData0 = data0.split("^");
                    var countA = 0;
                    var matchA = "";
                    // Search가 완료 되면 Grid 두개의 내용을 String으로 만들고 Data가 반대편 Grid에 있는지 체크한다
                    // 존재 하는 경우 1로 그렇지 않은 경우 0으로 미리 설정 해둔다. (나중에 하나씩 체크한는 것보다 빠름)
                    if (sheetObjects[0].CellValue(1,3) != '') {
                        for(var i = 0 in arrData0) {
                            if (data1.indexOf(arrData0[i]) != -1) {
                                countA ++;
                                sheetObjects[0].CellValue2(Number(i) + 1, "mat") = "1";
                            } else {
                                sheetObjects[0].CellValue2(Number(i) + 1, "mat") = "0";
                            }
                        }
                        formObj.l1.value = sheetObjects[0].LastRow;
                    } else {
                        formObj.l1.value = 0;
                    }
                    document.form.m1.value = countA;

                    var arrData1 = data1.split("^");
                    var countB = 0;
                    var matchB = "";
                    // Search가 완료 되면 Grid 두개의 내용을 String으로 만들고 Data가 반대편 Grid에 있는지 체크한다
                    // 존재 하는 경우 1로 그렇지 않은 경우 0으로 미리 설정 해둔다. (나중에 하나씩 체크한는 것보다 빠름)
                    if (sheetObjects[1].CellValue(1,3) != '') {
                        for (var i = 0 in arrData1) {
                            if (data0.indexOf(arrData1[i]) != -1) {
                                countB ++;
                                sheetObjects[1].CellValue2(Number(i) + 1, "mat") = "1";
                            } else {
                                sheetObjects[1].CellValue2(Number(i) + 1, "mat") = "0";
                            }
                        }
                        formObj.l2.value = sheetObjects[1].LastRow;
                    } else {
                        formObj.l2.value = 0;
                    }
                    document.form.m2.value = countB;
                    formObj.u1.value = formObj.l1.value - countA;
                    formObj.u2.value = formObj.l2.value - countB;
                    ComOpenWait(false);
                    sheetObjects[0].WaitImageVisible = true;
                    sheetObjects[1].WaitImageVisible = true;

                }
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
	 /**
	  * 기준 칼럼의 값에 따라 XML String을 만들어서 리턴한다. Row단위로 Hide시키는것보다 빠름
	  * @param sheet_obj
	  * @param pMatch     : MATCH는 Grid값이 1이기 때문에 0을 UNMATCH는 1을 가진다 TOTAL은 -1을 가진다
	  * @saveColName      : 기준 칼럼
	  */
       function CtmMakeHiddenXml(sheet_obj, pMatch, saveColName)  {
             try {
                 var allXml = "";
                 var sColSep = "•";
                 var sColOrder = "";
                 if (saveColName!=undefined && saveColName != null && saveColName!="") {
                     sColOrder = " COLORDER='" + saveColName + "' ";
                 }

                 allXml = "<?xml version='1.0'  ?>\n"
                        + "<SHEET>\n"
                 allXml += "  <DATA " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
                 var aryTRs = "";
                 var sheetText = sheet_obj.GetRangeText(sheet_obj.HeaderRows,0,sheet_obj.LastRow,sheet_obj.LastCol,sColSep,"^");
                 var aryTRs = sheetText.split("^");
                 for (var i in aryTRs) {
                    if(sheet_obj.CellValue(parseInt(i)+sheet_obj.HeaderRows, "mat") == pMatch)
                   	 aryTRs[i] = "<TR HIDDEN=\"TRUE\"><![CDATA["+aryTRs[i]+"]]></TR>";
                    else
                   	 aryTRs[i] = "<TR><![CDATA["+aryTRs[i]+"]]></TR>";
                 }
                 allXml += aryTRs.join("\n");
                 allXml += "  </DATA>\n"
                        +  "</SHEET>";
                 return allXml;
             } catch(err) { ComFuncErrMsg(err.message); }
       }

	/* 개발자 작업  끝 */