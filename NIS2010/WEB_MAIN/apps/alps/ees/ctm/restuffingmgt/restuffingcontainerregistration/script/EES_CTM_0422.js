/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0422.js
*@FileTitle : Restuffing Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.04 우경민
* 1.0 Creation
* 2011.02.28 나상보
* CHM-201109072 Restuffing Remarks 항목 수정 (CTM)
* 1. Remarks 항목 480자 입력 제한
* 2. Remarks 항목 특수문자 입력 가능하도록 수정
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
	 * @class EES_CTM_0422 : EES_CTM_0422 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
    function EES_CTM_0422() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }

   	/* 개발자 작업	*/


 // 공통전역변수
 var comboObjects = new Array();
 var comboCnt = 0;
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var cntrSts  = "";
 var sheetContainerFlg1 = false;
 var sheetContainerFlg2 = false;
 var sheetContainer1    = null;
 var sheetContainer2    = null;
 var sheetFrm           = 0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;
 var errorRow = -1;
 var errorBack = -1;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick() {
          var frm = document.form;
     	  var obj1 = sheetObjects[0];
    	  var obj2 = sheetObjects[1];

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
                 case "btn_add":
                	 // restuffing target 컨테이너 리스트 추가.
                	 // source 컨테이너의 정보를 복사해 온다.
                	 // 한 줄이라도 추가 되면 조건 정보를 수정 할 수 없도록 한다
                	 obj2.DataInsert(-1);
                	 lstRow = obj2.LastRow;
                	 obj1.CellValue(1, "cnmv_evnt_dt") = frm.p_date0.value;
                	 obj2.CellValue(lstRow, "vvd_no") = obj1.CellValue(1, "vvd_no");
                	 obj2.CellValue(lstRow, "bkg_no") = obj1.CellValue(1, "bkg_no");
                	 obj2.CellValue(lstRow, "cnmv_id_no") = obj1.CellValue(1, "cnmv_id_no");
                	 obj2.CellValue(lstRow, "cnmv_yr") = obj1.CellValue(1, "cnmv_yr");
                	 obj2.CellValue(lstRow, "reson_cd") = obj1.CellValue(1, "reson_cd");
                	 obj2.CellValue(lstRow, "org_yd_cd") = obj1.CellValue(1, "org_yd_cd");
                	 obj2.CellValue(lstRow, "save_flg") = "N";
                	 obj2.CellValue(lstRow, "xch_rmk") = frm.p_rmk.value;
                	 obj2.CellValue(lstRow, "cnmv_evnt_dt") = frm.p_date0.value;
                	 ComBtnEnable("btn_del");
                	 ComBtnDisable("btn_mvmt");
                	 frm.sheet1.Enable = false;
                	 frm.p_yard1.disabled = true;
                	 frm.p_date.disabled = true;
                	 frm.p_time.disabled = true;
                	 frm.p_reson_op.Enable = false;
                	 frm.p_yard2.Enable = false;
                	 break;

                 case "btn_del":
                	 // 추가된 target 컨테이너를 지운다. 모두 지워지면 source 컨테이너를 수정 할 수 있도록 풀어준다
                     obj2.RowDelete(obj2.SelectRow);
                     if (obj2.LastRow == 0) {
                    	 ComBtnEnable("btn_mvmt");
                    	 frm.sheet1.Enable = true;
                     }
                     break;

 		    	 case "btn_new":
                   frm.p_yard1.value = "";
                   frm.p_yard1.disabled = false;
                   frm.p_date.disabled = false;
                   frm.p_time.disabled = false;
                   frm.p_reson_op.Enable = true;
                   frm.p_yard2.Enable = true;
                   frm.p_yard2.RemoveAll();
                   frm.p_reson_op.text = "";;
                   frm.p_rmk.value = "";;
                   sheetObjects[0].RemoveAll();
                   sheetObjects[1].RemoveAll();
                   p_reson_op_OnCheckClick();
                   frm.sheet1.Enable = false;
                   frm.sheet2.Enable = false;
                   ComBtnEnable("btn_save");
                   break;

 		         case "btn_save":
 		        	 // target의 remark에 정보가 있는지 확인한다.
 		        	 // 비어있으면 에러 처리해준다
 		        	 sheetObjects[0].CellValue(1, "xch_rmk") = frm.p_rmk.value;
 		        	 if (sheetObjects[0].CellValue(1, "check_digit") == '') {
 		        		ComShowCodeMessage("CTM10004");
 		        		return;
 		        	 }
 		        	 // 사유항목의 자료가 입력 되어있는지 체크한다
 		        	 // 비어있으면 역시 에러처리한다
 		        	 if (frm.p_reson_op.text == '') {
 		        		ComShowCodeMessage("CTM10049", "reson code");
 		        		return;
 		        	 }
 		        	 // 야드가 없으면 에러처리한다
 		        	 if (frm.p_yard2.text == '') {
  		        		ComShowCodeMessage("CTM10049", "yard cd");
  		        		return;
  		        	 }
 		        	 // REMARK를 target에 등록한다.
 		        	 // Container를 체크해서 중복 컨테이너가 있는지 확인한다
 		        	 // 체크가 모두 종료되면 저장로직을 시작한다
 		        	 for (i = 1; i <= sheetObjects[1].LastRow; i++) {
 		        		 sheetObjects[1].CellValue(i, "xch_rmk") = frm.p_rmk.value;
 		        		 cntr = sheetObjects[1].CellValue(i, "cntr_no");
 		        		 if (sheetObjects[1].CellValue(i, "check_digit") == '') {
 		        			 ComShowCodeMessage("CTM10004");
	        				 return;
 		        		 }
 		        		 for (j = Number(i+1); j <= sheetObjects[1].LastRow; j++) {
 		        			 if (cntr == sheetObjects[1].CellValue(j, "cntr_no")) {
 		        				 ComShowCodeMessage("CTM20098");
 		        				 return;
 		        			 }
 		        		 }
 		        	 }
                     ComOpenWait(true);
 		        	 doActionIBSheet(obj1, frm, IBSAVE)
                     ComOpenWait(false);
                     break;

                case "btn_mvmt":
                    // Container History에서 컨테이너를 얻어오기 위한 POPUP을 호출한다.
                    // 정보를 얻어온 이후 정보를 Source에 등록하기위한 메소드를 호출한다.
                    var yardCd = frm.p_yard1.value + frm.p_yard2.text();
//                    var evntDt = frm.p_date0.value;
//                    var resnCd = frm.p_reson.value;
                    var cntrNo = sheetObjects[0].CellValue(1,"cntr_no").substring(0,10);
                    var checkDigit = sheetObjects[0].CellValue(1,"check_digit");
                    var typeSize = sheetObjects[0].CellValue(1,"cntr_tpsz_cd");
                    var sUrl = "EES_CTM_0445.do?cntrNo=" + cntrNo + "&checkDigit=" + checkDigit + "&typeSize=" + typeSize + "&yd=" + yardCd;
                    var iWidth = "720";
                    var iHeight = "500";
                    var bModal = true;
                    var rtnValue = ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);

					if (rtnValue == "") return;
					var rtnStr = rtnValue.split("|");
					if (rtnStr.length > 1) {
	                    obj1.CellValue(1, "cntr_seal_no") = rtnStr[0];
	                    obj1.CellValue(1, "chss_no") = rtnStr[1];
	                    obj1.CellValue(1, "mgst_no") = rtnStr[2];
	                    obj1.CellValue(1, "bkg_no") = rtnStr[3];
	                    obj1.CellValue(1, "vvd_cd") = rtnStr[4];
	                    obj1.CellValue(1, "org_yd_cd") = rtnStr[5];
	                    obj1.CellValue(1, "cnmv_id_no") = rtnStr[6];
                        obj1.CellValue(1, "cnmv_yr") = rtnStr[7];
	                    obj1.CellValue(1, "mvmt_sts_cd") = rtnStr[8];
	                    obj1.CellValue(1, "cntr_no") = rtnStr[9];
	                    obj1.CellValue(1, "cntr_tpsz_cd") = rtnStr[10];
	                    obj1.CellValue(1, "check_digit") = rtnStr[11];
                        obj1.CellValue(1, "save_flg") = "P";
                        obj1.CellValue(1, "cnmv_evnt_dt") = frm.p_date0.value;
	                    sheetFrm = 1;
                        for (var xx = 1; xx <= sheetObjects[1].LastRow; xx++) {
                            obj2.CellValue(xx, "vvd_no") = obj1.CellValue(1, "vvd_no");
                            obj2.CellValue(xx, "bkg_no") = obj1.CellValue(1, "bkg_no");
                            obj2.CellValue(xx, "cnmv_id_no") = obj1.CellValue(1, "cnmv_id_no");
                            obj2.CellValue(xx, "cnmv_yr") = obj1.CellValue(1, "cnmv_yr");
                            obj2.CellValue(xx, "reson_cd") = obj1.CellValue(1, "reson_cd");
                            obj2.CellValue(xx, "org_yd_cd") = obj1.CellValue(1, "org_yd_cd");
                            obj2.CellValue(xx, "save_flg") = "N";
                            obj2.CellValue(xx, "xch_rmk") = frm.p_rmk.value;
                            obj2.CellValue(xx, "cnmv_evnt_dt") = frm.p_date0.value;
                        }
                        ComBtnEnable("btn_add");
                    }
                    break;

                 case "btn_Calendar1":
   		        	var cal = new ComCalendar();;
   		        	cal.select(frm.p_date, 'yyyy-MM-dd');
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
         // khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         // IBMultiCombo초기화
         for(var k=0;k<comboObjects.length;k++){
             initCombo(comboObjects[k],k+1);
         }
         document.form.p_date.value = ComGetNowInfo();
         document.form.p_time.value = ComGetNowInfo("hm");
         document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value;
         ComBtnDisable("btn_del");
         ComBtnDisable("btn_mvmt");

         // OnKeyPress 이벤트
         setEventProcess("p_rmk");
         axon_event.addListener("keyup", "yard_Change", "p_yard1");
         axon_event.addListener("blur", "date_Change", "p_date");
         axon_event.addListener("focus", "date_focus", "p_date");
         axon_event.addListener("change", "time_Change", "p_time");
         axon_event.addListener("keypress", "obj_onkeypress", "p_rmk");
         document.form.sheet1.Enable = false;
         document.form.sheet2.Enable = false;
         document.form.p_yard1.focus();
     }


/**
 * 날짜를 체크한다. 오늘이후 일자로 입력 할수 없도록 제한한다.
 * @return
 */
      function date_Change() {
     		obj = document.form.p_date;
     		objValue = obj.value;
     		// 전체 내용중 -를 삭제.
     		objValue = ComGetMaskedValue(objValue, "ymd")
     		if (objValue != false) {
     			obj.value = objValue;
     			if (obj.name == "p_date") {
     				//document.form.p_date0.select();
     			}
     		} else {
     			ComShowCodeMessage("CTM00001");
     			// obj.value = objValue;
     			obj.select();
     			obj.focus();
     			return;
     		}
     		document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value
     		idx    = document.form.p_date0.value;
       		offSet = getDateDiff(idx);
			if (offSet >= 1) {
				ComShowCodeMessage("CTM10053");
				// alert ("Event date can't exceed+0 Days from today.");
    			obj.select();
    			obj.focus();
			}
      }


      /**
       * 시간이 변경 되었을경우 체크한다. 날짜와 세트로 동작한다
       * @return
       */
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
   			// obj.value = objValue;
   			obj.select();
   			obj.focus();
   			return;
   		}
   		document.form.p_date0.value = document.form.p_date.value + " " + document.form.p_time.value
    }


    /**
     * Reson Combo가 변경되면 하단에 TextBox를 Reson선택 개수 만큼 Visiable하고 데이타를 입력해준다.
     */
    function p_reson_op_OnBlur() {
        strRtn = document.form.p_reson_op.Text;
        if (strRtn != null && strRtn != "") {
            strTmp = strRtn.split(",");
            strRtn = "";
            idx = 0;
            for (var i=0; i < strTmp.length; i++) {
                if (i >= 4) break;
                if (i == 0) strRtn = strTmp[i];
                else strRtn += "," + strTmp[i];
                strValue = document.form.p_reson_op.GetText (strTmp[i], 1);
                obj = document.getElementById("dm"+i);
                obj.value = strValue;
                obj.style.display="";
                obj = document.getElementById("sm"+i);
                obj.value = strTmp[i];
                obj.style.display="";
                idx = i;
            }

            for (var i = idx+1; i < 4; i++) {
                obj = document.getElementById("dm"+i);
                obj.value = "";
                obj.style.display="none";
                obj = document.getElementById("sm"+i);
                obj.value = "";
                obj.style.display="none";
            }

            document.form.p_reson.value = strRtn;
            sheetObjects[0].CellValue(1, "reson_cd") = strRtn;
            for (i = 1; i <= sheetObjects[1].LastRow; i++) {
                sheetObjects[1].CellValue(i, "reson_cd") = strRtn;
            }
        }
    }


    /**
     * Reson Combo Box 선택시 (Click) 사유 항목을 초기화 하고 다시 등록할 수 있도록 데이타 작업을 한다
     * 실제 입력 되는 내용은 보여주는 텍스트가 아닌 TextBox 'p_resion' 이 Grid에 입력되서 서버로 전송된다
     * @param s_index
     * @param s_code
     * @return
     */
    function p_reson_op_OnCheckClick(s_index, s_code) {
        for (i = 0; i < 4; i++) {
            obj = document.getElementById("dm"+i);
            obj.value = '';
            obj.style.display='none';
            obj = document.getElementById("sm"+i);
            obj.value = '';
            obj.style.display='none';
        }

        strRtn = document.form.p_reson_op.Text;
        if (strRtn != null && strRtn != "") {
            strTmp = strRtn.split(",");
            strRtn = "";
            idx = 0;
            for (i = 0; i < strTmp.length; i++) {
                if (i >= 4) break;
                if (i == 0) strRtn = strTmp[i];
                else strRtn += "," + strTmp[i];
                strValue = document.form.p_reson_op.GetText (strTmp[i], 1);
                obj = document.getElementById("dm"+i);
                obj.value = strValue;
                obj.style.display='';
                obj = document.getElementById("sm"+i);
                obj.value = strTmp[i];
                obj.style.display='';
                idx = i;
            }
            document.form.p_reson.value = strRtn;
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
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboNo) {
        var formObject = document.form
        // var comboKey = COUNTRY;
        switch(comboNo) {
            case 1:
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
            case 2:
                with (comboObj) {
                    MultiSelect = true;
                    UseAutoComplete = true;
                    SetColAlign("left|left");
                    SetColWidth("30|200");
                    BackColor = "#CCFFFD";
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
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj, sheetNo) {
         var cnt = 0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 60;
//                     style.height = 100;    // 테스트용

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(18, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     // InitHeadMode(true, true, false, true, false,false)
                     InitHeadMode(true, true, true, true, false,false)
                     var HeadTitle = "|Seq.|Container No.|Container No.|TP/SZ|Seal No.|Chassis No.|STS|VVD Code|Booking No.|Booking No.|Id No.|cnmv_yr|reson_cd|org_yd|flg";

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
						// COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
						// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
						// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
						// FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daLeft,  	false,     "ibflag" );
                     InitDataProperty(0, cnt++ , dtSeq,       40,    daCenter,  false,     "SEQ");
                     InitDataProperty(0, cnt++ , dtData,      84,    daLeft,  false,     "cntr_no",   false,          "",      dfNone,  0,        true,      true,      10,     true,     true,      "");
                     InitDataProperty(0, cnt++ , dtData,      20,    daCenter,  false,     "check_digit",    false,          "",      dfNone,  0,        false,      false);
                     InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "cntr_tpsz_cd",     	false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  false,     "cntr_seal_no",     false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,      85,   daCenter,  false,     "chss_no",  false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "mvmt_sts_cd",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,      80,    daCenter,  false,     "vvd_no",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,     120,   daCenter,  false,     "bkg_no",     false,          "",      dfNone      ,  0,    true,		true);
                     InitDataProperty(0, cnt++ , dtComboEdit, 30,   daCenter,  false,     "bl_no",     false,          "",      dfNone      ,  0,    true,		true);

                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "cnmv_id_no",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "cnmv_yr",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "reson_cd",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "org_yd_cd",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "save_flg",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "xch_rmk",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "cnmv_evnt_dt",      false,          "",      dfUserFormat2      ,  0,    false,	false);

                     InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:" );
                     InitDataValid(0, "cntr_no"                , vtEngUpOther, "1234567890");
                     InitDataValid(0, "check_digit"            , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_tpsz_cd"           , vtEngUpOther, "1234567890");
                     InitDataValid(0, "mvmt_sts_cd"            , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_seal_no"           , vtEngUpOther, "1234567890");
                     InitDataValid(0, "chss_no"                , vtEngUpOther, "1234567890");

                     FocusEditMode = "-1";
 					 ShowButtonImage = 2;
 					 SelectHighLight = false;
                     WaitImageVisible = false;
                }

             break;

               case 2:      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 140;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(17, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)


                     var HeadTitle = "|Seq.|Container No.|Container No.|TP/SZ|Seal No.|Chassis No.|STS|VVD Code|Booking No.|Id No.|cnmv_yr|reson_cd|org_yd|flg";

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
						// COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
						// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
						// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
						// FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 0,     daLeft,  	false,     "ibflag" );
                     InitDataProperty(0, cnt++ , dtDataSeq,       40,    daCenter,  false,     "SEQ");
                     InitDataProperty(0, cnt++ , dtData,      84,    daLeft,  false,     "cntr_no",   false,          "",      dfNone,  0,        true,      true,      10,     true,     true,      "");
                     InitDataProperty(0, cnt++ , dtData,      20,    daCenter,  false,     "check_digit",    false,          "",      dfNone,  0,        false,      false);
                     InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "cntr_tpsz_cd",     	false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  false,     "cntr_seal_no",     false,          "",      dfNone      ,  0,    true,	true);
                     InitDataProperty(0, cnt++ , dtData,      85,   daCenter,  false,     "chss_no",  false,          "",      dfNone      ,  0,    true,	true);
                     InitDataProperty(0, cnt++ , dtData,      50,    daCenter,  false,     "mvmt_sts_cd",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  false,     "vvd_no",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtData,	 160,  daCenter,  false,     "bkg_no",     false,          "",      dfNone      ,  0,    false,	false);

                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "cnmv_id_no",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "cnmv_yr",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "reson_cd",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "org_yd_cd",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "save_flg",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "xch_rmk",      false,          "",      dfNone      ,  0,    false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,      70,   daCenter,  false,     "cnmv_evnt_dt",      false,          "",      dfUserFormat2      ,  0,    false,	false);

                     InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:" );
                     InitDataValid(0, "cntr_no"                , vtEngUpOther, "1234567890");
                     InitDataValid(0, "check_digit"            , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_tpsz_cd"           , vtEngUpOther, "1234567890");
                     InitDataValid(0, "mvmt_sts_cd"            , vtEngUpOther, "1234567890");
                     InitDataValid(0, "cntr_seal_no"           , vtEngUpOther, "1234567890");
                     InitDataValid(0, "chss_no"                , vtEngUpOther, "1234567890");

                     FocusEditMode = "-1";
 					 ShowButtonImage = 2;
 					 SelectHighLight = false;
                     WaitImageVisible = false;
                }
                 break;
         }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH://조회
                if(validateForm(sheetObj,formObj,sAction))
                    if(sheetObj.id == "sheet1")
                        sheetObj.DoSearch("UI_CTM_0422_DATA1.html");
                    else if(sheetObj.id == "sheet2")
                        sheetObj.DoSearch("UI_CTM_0422_DATA2.html");
                break;

            case SEARCH02:// 입력
                if(validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = SEARCH06;
                    xml = sheetObj.GetSearchXml ("CTMCommonGS.do", FormQueryString(formObj));
                    // sheetObj.LoadSearchXml(xml);
                    rtnValue = ComGetEtcData(xml, "rtnValue");
                    parseYardMultiCombo(rtnValue, comboObjects[1]);
                }
                break;

            case IBSAVE://저장
                if(validateForm(sheetObj,formObj,sAction)) {
                    if (sheetObjects[1].LastRow == 1 && sheetObjects[0].CellValue(1, "cntr_no") == sheetObjects[1].CellValue(1, "cntr_no")) {
                        ComShowCodeMessage("CTM20106")
                        return;
                    }
                    if (sheetObjects[1].LastRow == 0) {
                        ComShowCodeMessage("CTM20106")
                        return;
                    }
                    if (sheetObjects[0].CellValue(1, "reson_cd") == "") {
                        ComShowCodeMessage("CTM10049", "reson cd")
                        document.form.p_reson_op.focus();
                        return;
                    }
                    if (sheetObjects[0].CellValue(1, "xch_rmk") == "") {
                        ComShowCodeMessage("CTM10049", "remark")
                        document.form.p_rmk.focus();
                        return;
                    }

                    ComBtnDisable("btn_save");
                    formObj.f_cmd.value = MULTI;
                    queryString = sheetObjects[0].getSaveString() + "&" + sheetObjects[1].getSaveString() + "&" + FormQueryString(formObj);
                    rtnXml = sheetObj.GetSaveXml("EES_CTM_0422GS.do",  queryString);
                    rtn = rtnXml.split("TR-ALL");
                    if (rtn.length == 3) {
                        if (rtn[1].substring(1, 3) == "OK") {
                            ComShowCodeMessage("CTM10022", "Restuffing Creation");
                        } else {
                            ComBtnEnable("btn_save");
                            ComShowCodeMessage("CTM10024");
                        }
                    } else {
                        ComBtnEnable("btn_save");
                        ComShowCodeMessage("CTM10024");
                    }
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
            ComShowCodeMessage("CTM10022", "Release/Redelivery History");
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리. 모든 처리는 버튼 클릭시 진행되기 때문에
      * 공통에서 만들어둔 함수를 사용하지 않음.
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }


 	/**
 	 * 컨테이너 번호 변경 내역을 추적하기 위해 내용 수정 전 (setFocus) 컨테이너 번호를 저장 해둠.
 	 * Sheet1. 2에 각각 존재함
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 * @return
 	 */
 	function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
 		selectedRow = Row;
 	    if (Row < 1) return;
 	   var SaveName = sheetObj.ColSaveName(Col);
 	   if (SaveName == "cntr_no") {
 		   sheetContainer1 = sheetObj.CellValue(Row, Col);
 	    }
 	}


    /**
	 * 컨테이너 번호 변경 내역을 추적하기 위해 내용 수정 전 (setFocus) 컨테이너 번호를 저장 해둠.
	 * Sheet1. 2에 각각 존재함
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
 	function sheet2_OnBeforeEdit(sheetObj, Row, Col) {
 		selectedRow = Row;
 	    if (Row < 1) return;
 	   var SaveName = sheetObj.ColSaveName(Col);
 	   if (SaveName == "cntr_no") {
 		   sheetContainer2 = sheetObj.CellValue(Row, Col);
 	    }
 	}


 	/**
 	 * 컨테이너 번호 변경 시 유효성 체크를 위해 Key Event를 감시함.
 	 * Sheet1, 2에 각각 존재
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 * @param KeyCode
 	 * @param Shift
 	 * @return
 	 */
 	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
 		newValue = sheetObj.EditValue;
 	    if (Row < 1) return;
 	    var SaveName = sheetObj.ColSaveName(Col);
 	    if (SaveName == "cntr_no") {
			if (sheetContainer1 == newValue) {
				return;
			}
			sheetFrm = 0;
			sheetContainerFlg1 = false;
			sheetCheckValue(sheetObj, Row, Col, false, "1");
		}
	}


    /**
 	 * Mouse Click 혹은 Tab으로 Focus이동 시 전 Focus Cell이 컨테이너 였는지 체크 한 후 유효성을 검사하도록 함.
 	 * @param sheetObj
 	 * @param OldRow
 	 * @param OldCol
 	 * @param NewRow
 	 * @param NewCol
 	 * @return
 	 */
 	 function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	    var Row = OldRow;
	    var Col = OldCol;
	    newValue = sheetObj.CellValue(Row, Col);
	    var SaveName = sheetObj.ColSaveName(Col);
	    if (Row < 1) return;

	    if (SaveName == "cntr_no") {
	    	if ((sheetContainerFlg1 == false && Row >= sheetObj.HeaderRows) || (sheetContainerFlg1 == false && sheetContainer1 != newValue)) {
	    		sheetCheckValue(sheetObj, Row, Col, true, "1");
	    	}
 		 }
 	 }


  	/**
  	 * 컨테이너 번호 변경 시 유효성 체크를 위해 Key Event를 감시함.
  	 * Sheet1, 2에 각각 존재
  	 * @param sheetObj
  	 * @param Row
  	 * @param Col
  	 * @param KeyCode
  	 * @param Shift
  	 * @return
  	 */
  	function sheet2_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
 		newValue = sheetObj.EditValue;
 	    if (Row < 1) return;
 	    var SaveName = sheetObj.ColSaveName(Col);
 	    if (SaveName == "cntr_no") {
			if (sheetContainer2 == newValue) {
				return;
			}
			sheetContainerFlg2 = false;
			sheetCheckValue(sheetObj, Row, Col, false, "2");
		}
	}


  	/**
  	 * Mouse Click 혹은 Tab으로 Focus이동 시 전 Focus Cell이 컨테이너 였는지 체크 한 후 유효성을 검사하도록 함.
  	 * @param sheetObj
  	 * @param OldRow
  	 * @param OldCol
  	 * @param NewRow
  	 * @param NewCol
  	 * @return
  	 */
 	 function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)
 	 {
	    var Row = OldRow;
	    var Col = OldCol;
	    newValue = sheetObj.CellValue(Row, Col);
	    var SaveName = sheetObj.ColSaveName(Col);
	    if (Row < 1) return;
		if (NewRow == OldRow && OldCol == NewCol) {
			return;
		} else if (errorRow > 0 && (NewRow != errorRow || OldCol != NewCol)) {
			 errorRow = -1;
			 errorBack = -1;
			 return;
		} else if (errorBack == 1 && (OldRow != NewRow || OldCol != NewCol)) {
			 errorBack = -1;
			 errorRow = -1;
			 // return;
		} else {
		    if (SaveName == "cntr_no") {
		    	if ((sheetContainerFlg2 == false && Row >= sheetObj.HeaderRows) || (sheetContainerFlg2 == false && sheetContainer2 != newValue)) {
		    		sheetCheckValue(sheetObj, Row, Col, true, "2");
		    	}
	 		 }
		}
 	 }


 	 /**
 	  * 컨테이너 번호의 유효성을 검사. Sheet1, 2를 통합하고 하나로 처리 함.
 	  * @param sheetObj		:Sheet Object
 	  * @param Row			:Grid Row
 	  * @param Col			:Grid Col
 	  * @param isOut		:Focus Out과 Key Event를 구분하기 위한 Param. true : focus out
 	  * @param sheetName	:Sheet1일 때와 Sheet2일때 동작 내역이 다르기 때문에 Sheet Name을 넘겨받음
 	  * @return
 	  */
 	 function sheetCheckValue(sheetObj, Row, Col, isOut, sheetName) {
 	    var SaveName = sheetObj.ColSaveName(Col);
 	    var formObj  = document.form;

 	    switch(SaveName)
 	     {
 	         case "cntr_no":
				 // 컨테이너 번호 유효성 체크. 0406과 동일한 로직을 타고 있음. 설명은 0406 참조 .
 	        	 if (isOut)
 	        		 cntr_no = sheetObj.CellValue(Row, "cntr_no");
 	        	 else
 	        		 cntr_no = sheetObj.EditValue;

 	        	 if (sheetName == "2" && cntr_no.length < 1){
 	        		 sheetContainerFlg2 = true;
 	        		 return;
 	        	 }
 	        	 if (sheetName == "1" && cntr_no.length < 1){
 	        		 sheetContainerFlg1 = true;
 	        		 return;
 	        	 }
 	        	 if (cntr_no.length != 10 && isOut == false) {
 	        		 return;
 	        	 } else if (cntr_no.length == 11) {
 	        		 cntr_no = cntr_no.substring(0,10);
 	        		sheetObj.CellValue2(Row, "cntr_no") = cntr_no;
 	        	 }
				 // Sheet2일때만 실행하는 부분.
				 // Target은 MT인 경우만 실행 가능하고 조건의 Yard와 동일한경우에만 가능하도록 제한한다.
 	        	 if (sheetName == "2") {
 	        		 if (sheetFrm == 1) {
 	        			 if (sheetObjects[0].CellValue(1, "cntr_no") == cntr_no) {
 	        				 ComShowCodeMessage("CTM20105")
 	        				 errorRow = Row;
 	        				 errorBack = 1;
 	        				 sheetObj.SelectCell(Row, "cntr_no", true, "");
 	        				 return;
 	        			 }
 	        		 }

	 	        	 formObj.f_cmd.value = SEARCH20;
	 	        	 p_yard1 = formObj.p_yard1.value;
	 	        	 p_yard2 = formObj.p_yard2.Code;
	 	        	 queryString = "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntr_no + "&p_yard1=" + p_yard1;
	 	        	 xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
	 	        	 rtnValue = ComGetEtcData(xml, "rtnValue");
	 	        	 if (rtnValue == null) {
		 	        	 ComShowCodeMessage("CTM10004");
		 	        	 errorRow = Row;
		 	        	 errorBack = 1;
        				 sheetObj.SelectCell(Row, "cntr_no", true, "");
		 	        	 return;
	 	        	 } else {
	 	    	 		rtnStr = rtnValue.split("|");
	 	   	 			ydCd = p_yard1 + p_yard2
	 	   	 			if (sheetObjects[1].CellValue(Row, "cntr_no") == sheetObjects[0].CellValue(1, "cntr_no")) {
                            // Sheet1의 입력된 Cntr_no와 같으면 Skip한다.
	 	   	 			} else  if (rtnStr[3] != ydCd) {
	 	   	 				// 야드가 다름.
	 	   	 				ComShowCodeMessage("CTM20057");
	 	   	 				errorRow = Row;
	 	   	 				errorBack = 1;
	        				sheetObj.SelectCell(Row, "cntr_no", true, "");
	 	   	 				return;
	 	   	 			} else if (rtnStr[1] != "MT" ) {
	 	   	 				// MT가 아님
	 	   	 				ComShowCodeMessage("CTM20056");
	 	   	 				errorRow = Row;
	 	   	 				errorBack = 1;
	 	   	 				sheetObj.SelectCell(Row, "cntr_no", true, "");
	 	   	 				return;
	 	   	 			}
		 	   	 		sheetObj.CellValue(Row, "cntr_tpsz_cd") = rtnStr[2];
	 	   	 			sheetObj.CellValue(Row, "mvmt_sts_cd") = rtnStr[1];
		 	   	 		sheetObj.CellValue(Row, "cnmv_yr") = document.form.p_date0.value.substring(0,4);
		 	   	 		sheetObj.CellValue(Row, "cnmv_evnt_dt") = document.form.p_date0.value;
		 	   	 		vr = rtnStr[0].substring(10,11);
		 	   	 		if (vr != null) {
		 	   	 			sheetObj.CellValue(Row, "check_digit") = vr;
                        }
	 	   	 			sheetContainerFlg2 = true;
	 	   	 		}
 	        		 if (sheetFrm == 1) {
 	        			 if (sheetObjects[0].CelLValue(1, "cntr_no") == cntr_no) {
 	        				 ComShowCodeMessage("CTM20105")
 	        				 errorRow = Row;
 	        				 errorBack = 1;
 	        				 sheetObj.SelectCell(Row, "cntr_no");
 	        				 return;
 	        			 } else {
 	        			 }
 	        		 }

                 } else {
					 // Sheet1에서 실행 하는 부분. 특별한 제한 조건은 없다 단 서버는 동일 지역이어야 한다. VL,VD,EN,TN,MT는 원본이 될 수 없다
	 	        	 p_yard1 = formObj.p_yard1.value;
	 	        	 p_yard2 = formObj.p_yard2.Code;

	 	        	 queryString = "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntr_no + "&p_yard1=" + p_yard1;
	 	        	 xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
	 	        	 rtnValue = ComGetEtcData(xml, "rtnValue");
	 	        	 if (rtnValue == null) {
		 	        	 ComShowCodeMessage("CTM10004");
		 	        	 errorRow = Row;
		 	        	 errorBack = 1;
		 	        	 sheetObj.SelectCell(Row, "cntr_no", true, "");
		 	        	 return;
	 	        	 } else {
		 	    	 		rtnStr = rtnValue.split("|");
		 	    	 		vr = rtnStr[0].substring(10,11);
			 	   	 		if (rtnStr[3].substring(0,2) != p_yard1.substring(0,2)) {
			 	   	 			ComShowCodeMessage("CTM10007");
			 	   	 			errorRow = Row;
			 	   	 			errorBack = 1;
			 	   	 			sheetObj.SelectCell(Row, "cntr_no", true, "");
			 	   	 			return;
			 	   	 		}
		 	    	 		if (vr != null) {
			 	   	 			sheetObjects[0].CellValue(Row, "check_digit") = vr;
                            }
			 	   	 		sheetObjects[0].CellValue(Row, "cntr_tpsz_cd") = rtnStr[2];
			 	   	 		cntrSts = rtnStr[1];
			 	        	queryString = "f_cmd=" + SEARCH + "&cntr_no=" + cntr_no + "&check_digit=" + vr;
			 	        	xml = sheetObjects[0].GetSearchXml("EES_CTM_0422GS.do", queryString);
                            sheetObjects[0].LoadSearchXml(xml);
			 	        	sheetObjects[0].CellValue(1, "save_flg") = "D";
		         	        sheetObjects[0].CellValue(1, "reson_cd"    ) = formObj.p_reson.value;
		         	        sts = sheetObjects[0].CellValue(1, "mvmt_sts_cd");
		         	        if (sts == "VL" || sts == "VD" || sts == "EN" || sts == "TN" || sts == "MT") {
		         	        	ComShowCodeMessage("CTM20054");
		         	        	errorRow = Row;
		         	        	errorBack = 1;
                                sheetObj.ReDraw = false;
                                sheetObj.RowDelete(Row, false);
                                sheetObj.DataInsert();
                                sheetObj.ReDraw = true;
		         	        	sheetObj.SelectCell(Row, "cntr_no", true);
		         	        	return;
		         	        }
		         	       strRtn = ComGetEtcData(xml, "Split");
		         	       rtnVal = strRtn.split ("^^");

		         	       comboText = "";
		         	       comboVal = "";
		         	       for (xid = 0; xid < rtnVal.length-1; xid++) {
		         	    	   tmpStr = rtnVal[xid].split("|");
		         	    	   comboText = comboText + "|" + tmpStr[0] + "\t" + tmpStr[1];
		         	    	   comboVal  = comboVal + "| " + tmpStr[1] ;
		         	       }
		         	      obj1 = sheetObjects[0];
		         	      obj2 = sheetObjects[1];
		         	       for (var xx = 1; xx <= sheetObjects[1].LastRow; xx++) {
		                  	 obj2.CellValue(xx, "vvd_no") = obj1.CellValue(1, "vvd_no");
		                	 obj2.CellValue(xx, "bkg_no" ) = obj1.CellValue(1, "bkg_no");
		                	 obj2.CellValue(xx, "cnmv_id_no") = obj1.CellValue(1, "cnmv_id_no");
		                	 obj2.CellValue(xx, "cnmv_yr") = obj1.CellValue(1, "cnmv_yr");
		                	 obj2.CellValue(xx, "reson_cd") = obj1.CellValue(1, "reson_cd");
		                	 obj2.CellValue(xx, "org_yd_cd") = obj1.CellValue(1, "org_yd_cd");
		         	       }
		         	       sheetObjects[0].InitDataCombo(0, "bl_no", comboText, comboVal, "", "");    // IBSheet내 Combo 초기화
	 	        	 }
	 	        	 sheetObjects[0].CellValue(1, "cnmv_evnt_dt") = document.form.p_date0.value;
	 	        	sheetContainerFlg1 = true;
   	 				errorRow  = -1;
   	 				errorBack = -1;
 	        	 }
 	        	 break;

             case "chss_no":
		 	   		 queryString = ""; // chss_no
		 		 	 p_chassis_no = sheetObj.CellValue(Row, "chss_no");
		 			 if (p_chassis_no == '') {
		 				 rtnValue = 'OK';
		 			 } else {
		 			 	 queryString = "f_cmd=" + SEARCH08 + "&p_chassis_no=" + p_chassis_no;
		 				 xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
		 				 rtnValue = ComGetEtcData(xml, "rtnValue");
		 				 rtnName  = ComGetEtcData(xml, "rtnName");
		 			 }
		 			 if (rtnValue != 'OK') {
		 				 if (!ComShowCodeConfirm("CTM20116")) {
		 					 sheetObj.CellValue2(Row, Col) = OrgValue;
		 					 clearStatus(sheetObj, Row);
		 					 return;
		 				 } else return;
		 			 }
		 			 changeColor(sheetObj, Row);
		 			 break;

             case "mgst_no":
		 	   		 queryString = ""; // chss_no
		 		 	 mgset = sheetObj.CellValue(Row, "mgst_no");
		 			 if (mgset == '') {
		 				 rtnValue = 'OK';
		 			 } else {
		 				 queryString = "f_cmd=" + SEARCH07 + "&p_mgset=" + mgset;
		 				 xml = sheetObj.GetSearchXml ("CTMCommonGS.do", queryString);
		 				 rtnValue = ComGetEtcData(xml, "rtnValue");
		 				 rtnName  = ComGetEtcData(xml, "rtnName");
		 			 }
		 			 if (rtnValue != 'OK') {
		 				 ComShowCodeMessage("CTM20115")
		 				 sheetObj.CellValue2(Row, Col) = OrgValue;
		 				 clearStatus(sheetObj, Row);
		 				 return;
		 			 }
		 			 break;

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
         strDt = y + "" + m + "" + d ;

         if (endDt > strDt) return 999;
   	 /*
		 * var startDt = new Date(); var endDt = new
		 * Date(Number(idx.substring(0,4)),Number(idx.substring(5,7))-1,Number(idx.substring(8,10)));
		 * resultDt = Math.floor(endDt.valueOf()/(24*60*60*1000)-
		 * startDt.valueOf()/(24*60*60*1000));
		 *
		 * return resultDt;
		 */
     }


     /**
      * 오늘 날짜와 비교해서 며칠 차이가 나는지 확인한다.
      */
    function getDateDiffTim(idx) {
		 var startDt = new Date();
		 var endDt = new Date(Number(idx.substring(0,4)),Number(idx.substring(5,7))-1,Number(idx.substring(8,10)));
		 resultDt = Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));

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


    function yard_Change (event) {
        eventElement = event.srcElement;
        // alert (obj_keyup(event))
        if (eventElement.value.length < 5) return;
        if (srcValue == eventElement.value) return;
        document.form.p_yard2.RemoveAll();
        onShowErrMsg = false;
        rtn = yard_search()

        if (rtn == true && svrChk != 'S') {
            ComShowCodeMessage("CTM20072");
            // alert ("사용자와 야드의 Server 정보 불 일치");
            eventElement.value = '';
            eventElement.select();
            eventElement.focus();
            return;
        } else if (rtn == true && svrChk == 'S') {
            document.form.p_yard2.focus();
        } else {
            document.form.p_yard1.focus();
        }
    }


    /**
     * Container No Object의 값 변경 처리
     * param : combo_obj ==> 콤보오브젝트
     */
    function p_yard2_OnBlur() {
        strRtn = document.form.p_yard2.text();
        if (strRtn == '') {
            ComBtnDisable("btn_mvmt");
            document.form.sheet1.RemoveAll();
            document.form.sheet1.DataInsert(-1);
            document.form.sheet1.Enable = false;
            document.form.sheet2.RemoveAll();
            document.form.sheet2.DataInsert(-1);
            document.form.sheet2.Enable = false;
        } else {
            ComBtnEnable("btn_mvmt");
            document.form.sheet1.RemoveAll();
            document.form.sheet1.DataInsert(-1);
            document.form.sheet1.Enable = true;
            document.form.sheet2.RemoveAll();
            document.form.sheet2.DataInsert(-1);
            document.form.sheet2.Enable = true;
        }
    }


    /**
     * HTML Object의 OnKeyDown 이벤트 처리
     */
    function obj_onkeypress() {

    }


     function sheet1_OnLoadFinish() {
         doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
     }
/* 개발자 작업  끝 */