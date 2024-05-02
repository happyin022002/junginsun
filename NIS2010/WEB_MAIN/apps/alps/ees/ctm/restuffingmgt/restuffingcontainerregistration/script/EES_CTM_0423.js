/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0423.js
*@FileTitle : Restuffing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.27 우경민
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
     * @class Restuffing Inquiry : Restuffing Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0423() { 
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


 var comboObjects = new Array();
 var comboCnt = 0;
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
 		         case "btn_retrieve":
 		        	 if (!checkFormField()) return;
 		        	 if (checkValidation(formObject))
 		        		 doActionIBSheet(sheetObject,formObject,IBSEARCH)
 					break;
 		         case "btn_new":
 		        	formObject.reset();
 		        	loadPage();
 		        	comboObjects[0].RemoveAll();
 					break;
 		         case "btn_Calendar1":
 		         case "btn_Calendar2":
 		        	var cal = new ComCalendarFromTo();
		        	    cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
 		        	 break;
 		         case "btn_Combo":
// 		        	 formObject.p_reson.style.display ='none';
//		        	 itm = document.all.item("m_combo");
//		        	 itm.style.display = '';
 		         	 break;
 		         case "btn_downExcel":
 		        	sheetObject.Down2Excel(-1);
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
        return true
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

         // IBMultiCombo초기화
         for(var k=0;k<comboObjects.length;k++){
             initCombo(comboObjects[k],k+1);
         }

        cdate = new Date();
   		maxYr = cdate.getFullYear();

        // CTM-COMMON (& 예외처리)
        setEventProcess("cntrno_disp");
        // OnKeyPress 이벤트 (공통function)
        axon_event.addListener("keypress", "obj_keypress", "cntrno_disp");
        // OnKeyUp 이벤트 (자체function)
        axon_event.addListener("keyup", "obj_onkeyup", "cntrno_disp");

        doActionIBSheet(sheetObjects[0],document.form,SEARCH02);

        document.form.p_yard1.focus();
      }


    /**
  	 * Combo 기본 설정
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initCombo(comboObj, comboNo) {
  		var formObject = document.form
  		//var comboKey = COUNTRY;
  		switch(comboNo) {
  			case 1:
  				with (comboObj) {
  					MultiSelect = false;
  					SetColAlign("left|left");
  					SetColWidth("30|200");
  					BackColor = "#EFEFEF";
  					FontColor = "#373737";
  					ColBackColor(0) = "#EFEFEF";
  					ColFontColor(0) = "#373737";
  					ColBackColor(1) = "#EFEFEF";
  					ColFontColor(1) = "#373737";
  					DropHeight = 160;
  				}
  				break;
  			case 2:
  				with (comboObj) {
  					MultiSelect = true;
  					SetColAlign("left|left");
  					SetColWidth("30|200");
  					BackColor = "#EFEFEF";
  					FontColor = "#373737";
  					ColBackColor(0) = "#EFEFEF";
  					ColFontColor(0) = "#373737";
  					ColBackColor(1) = "#EFEFEF";
  					ColFontColor(1) = "#373737";
  					DropHeight = 160;
  				}
  				break;
  		}
  	}


    /**
     * p_yard2 Object의 OnKeyDown이벤트 처리
     */
    function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
      * Container No Object의 값 변경 처리
      * param : combo_obj ==> 콤보오브젝트
      */
     function p_reson_op_OnBlur() {
    	 strRtn = document.form.p_reson_op.text();
    	 strTmp = strRtn.split(",");
    	 strRtn = "";
    	 for (i = 0; i < strTmp.length; i++) {
    		 if (i == 0) strRtn = "'" + strTmp[i] + "'";
    		 else strRtn += ",'" + strTmp[i] + "'";
    	 }
    	 if (strRtn == '\'\'') strRtn = '';
    	 document.form.p_reson.value = strRtn;
     }


    /**
     * p_reson_op Object의 OnKeyDown이벤트 처리
     */
    function p_reson_op_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
                     style.height = 460;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(30, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|Object|Object|Object|Object|Object|Object|Replaced|Replaced|Replaced|Replaced|Replaced|Replaced|Date|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Reason|Yard|Office|Remark(s)";
                     var HeadTitle2 = "|Seq.|Container No.|T/S|STS|CYC|Booking No.|Booking No.|Container No.|T/S|STS|CYC|Booking No.|Booking No.|Date|BE|CM|DM|DP|ET|OD|OT|OW|OZ|RC|RP|SM|Yard|Office|Remark(s)";


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,  daCenter,  true,     "HidSta");
                     InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  true,     "Seq");
                     InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  true,     "cntr_no",  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      32,    daCenter,  true,     "cntr_tpsz_cd",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      32,    daCenter,  true,     "cnmv_sts_cd",     		false,          "",      dfNone, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      32,    daCenter,  true,     "cnmv_cyc_no",     		false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  true,     "bkg_no",   	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,     "bkg_no_split",  	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      85,    daCenter,  true,     "xch_cntr_no", 	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      32,    daCenter,  true,     "xch_cntr_tpsz_cd",   			false,          "",      dfNone, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      32,    daCenter,  true,     "pre_cnmv_sts_cd",   			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      32,    daCenter,  true,     "xch_cntr_cyc_no",   			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  true,     "bkg_no",   	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,     "bkg_no_split",   	false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      100,   daLeft,  true,     "dt",     		false,          "",      dfDateYmd, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "be",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "cm",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "dm",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "dp",     			false,          "",      dfNone, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "et",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "od",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "ot",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "ow",    			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "oz",    			false,          "",      dfNone, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "rc",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "rp",    			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      30,    daCenter,  true,     "sm",     			false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      60,    daLeft,  true,     "org_yd_cd",     		false,          "",      dfNone, 	0,		true,		true);
                     InitDataProperty(0, cnt++ , dtData,      60,    daLeft,  true,     "xch_ofc_cd",    	false,          "",      dfNone, 	0,		true,		true);

                     InitDataProperty(0, cnt++ , dtData,      180,    daLeft,  true,     "xch_rmk",     	false,          "",      dfNone, 	0,		true,		true);

                     CountPosition = 0;
                     FrozenCols = 3;
                }
                 break;
         }
     }


   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
    	 sheetObj.ShowDebugMsg = false;

         switch(sAction) {

            case IBSEARCH:      //조회
                if (validateForm(sheetObj,formObj,sAction)) {
                    if(sheetObj.id == "sheet1") {
                        ComOpenWait(true);
                        sheetObj.WaitImageVisible = false;
                        formObj.f_cmd.value = SEARCH01;
                        sheetObj.DoSearch("EES_CTM_0423GS.do", FormQueryString(formObj));
                        ComOpenWait(false);
                        sheetObj.WaitImageVisible = true;
                    }
                }
                break;

            case SEARCH02:      // 입력
                if(validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = SEARCH06;
                    xml = sheetObj.GetSearchXml ("CTMCommonGS.do", FormQueryString(formObj));
                    rtnValue = ComGetEtcData(xml, "rtnValue");
                    parseYardMultiCombo(rtnValue, comboObjects[1]);
                }
                break;
         }

     }


    /**
     * HTML Object의 OnKeyUp이벤트 처리
     */
    function obj_onkeyup(event) {
        srcValue = event.srcElement.value;    // CoCtm.js의 공통스크립트의 자동실행 방지용
        var frmObj = document.form;
        var sheetObj = sheetObjects[0];
        switch(event.srcElement.name) {
            case "cntrno_disp":
            // cntrno_disp에 입력되는 값의 length에 따른 처리
            	frmObj.cntrno_disp.value = frmObj.cntrno_disp.value.toUpperCase();
                var cntrnoDisp = frmObj.cntrno_disp;
                if (cntrnoDisp.value.length > 1) {
                    frmObj.p_cntrno.value = cntrnoDisp.value;
                    if (cntrnoDisp.value.length > 9) {
                        // p_cntrno에 10글자가 채워지면 CTM공통함수의 cntr_search() 호출
                        if (!cntr_search()) {
                            cntrnoDisp.select();
                            cntrnoDisp.focus();
                        } else {
                            // 정상적인 경우 CTM공통함수의 setFocusIndex호출(다음 Element에 Focus)
                            setFocusIndex(event.srcElement, 1);
                        }
                    } else {
                        frmObj.check_digit.value = "";
                    }
                } else {
                    frmObj.p_cntrno.value = "";
                    frmObj.check_digit.value = "";
                }
                break;
        }
        onShowErrMsg = false;    // CoCtm.js의 공통스크립트의 자동실행 방지용
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             /* Date format이 validation이 실패한 경우 경우 return false로 service 호출을 막음 */
//             if (sAction == IBSEARCH) {
//              if (cancelDate == false) return false;
//             }
         	var tmpobjValue = formObj.p_date1.value;
        	var tmpobjValue2 = formObj.p_date2.value;
            // 전체 내용중 -를 삭제.
        	
        	tmpobjValue = ComGetUnMaskedValue(tmpobjValue, "ymd");
            tmpobjValue2 = ComGetUnMaskedValue(tmpobjValue2, "ymd");
            if (!ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue) || !ComIsDate(tmpobjValue2) || !ComIsDate(tmpobjValue2)) {
				return false;
            } else {
                    date1 = document.getElementById("p_date1").value;
                    date2 = document.getElementById("p_date2").value;
                    date1 = ComGetUnMaskedValue(date1, "ymd");
                    date2 = ComGetUnMaskedValue(date2, "ymd");
                    if (date1 == '' || date2 == '') return;
                    if (date1 > date2) {
                    	ComShowCodeMessage("CTM10114");
                    	formObj.p_date1.focus();
                        return false;
                    }

            }
         }

         return true;
     }


	/* 개발자 작업  끝 */