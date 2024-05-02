/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0039.js
*@FileTitle : Proposal Amendment Draft Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.06.25 변영주
* 1.0 Creation
=========================================================
* 2015.06.15 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한) 
* 2015.09.21 최성환 [CHM-201537786] SC 다운로드 보안 강화_1차 보완
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
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
     * @class ESM_PRI_0039 : ESM_PRI_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0039() {
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
    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	 /*
	  *  숨겨진 기능인 super user 권한을 가졌는지 여부 
	  */
//	 var FILE_CANCEL_ID  = "0010244";
//	 var FILE_CANCEL_ID2 = "0010593";
//	 var FILE_CANCEL_ID3 = "0660082";
//	 var FILE_CANCEL_ID4 = "0810022";
//	 var FILE_CANCEL_ID5 = "0810071";
//	 var FILE_CANCEL_ID6 = "0810273";
//	 var FILE_CANCEL_ID7 = "Clairelee";
//	 var FILE_CANCEL_ID8 = "0260062"; // CHM-201431827 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID9 = "1110071"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID10 = "1110093"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID11 = "0310064"; // CHM-201537788 Filed Cancel 권한 부여 요청 추가

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		/** **************************************************** */
		var formObj = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }		

			switch (srcName) {
	
			case "btn_retrieve1":
				formObj.cd_tp.value = "1";
				formObj.cd1.value = formObj.sc_no.value;
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
			case "btn_retrieve2":
				formObj.cd_tp.value = "2";
				formObj.cd1.value = formObj.prop_no.value;
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
			case "btn_retrieve3":
				formObj.cd_tp.value = "3";
				formObj.cd1.value = formObj.apro_ofc_cd.value;
				formObj.cd2.value = formObj.apro_usr_nm.value;
				formObj.eff_dt.value = ComGetUnMaskedValue(formObj.auth_dur_eff_dt.value,"ymd");
				formObj.exp_dt.value = ComGetUnMaskedValue(formObj.auth_dur_exp_dt.value,"ymd");
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
			case "btn_retrieve4":
				formObj.cd_tp.value = "4";
				formObj.cd1.value = formObj.prop_ofc_cd.value;
				formObj.cd2.value = comboObjects[0].Code;
				formObj.eff_dt.value = ComGetUnMaskedValue(formObj.srep_dur_eff_dt.value,"ymd");
				formObj.exp_dt.value = ComGetUnMaskedValue(formObj.srep_dur_exp_dt.value,"ymd");
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
			case "btn_open":
				var sheetObj = sheetObjects[0];
				
				//조회전이거나 결과값이 없을 경우
				if(sheetObjects[0].CellValue(1,"prop_no")==undefined) return;
				
				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
				var txt = "";
				
				//현재 화면에서 RD 호출 하는 화면으로 화면ID 전달 
                var sSpScrnEvntPgmCd = "ESM_PRI_0039"; 

				if(chkArr.length==0){
					txt = sheetObj.CellValue(sheetObj.SelectRow,"prop_no")+ ":" + sheetObj.CellValue(sheetObj.SelectRow,"sc_no")+ ":" + sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq") + ";";
				} 
				for(i=0;i<chkArr.length;i++){
					txt += sheetObj.CellValue(chkArr[i],"prop_no")+ ":" + sheetObj.CellValue(chkArr[i],"sc_no")+ ":" + sheetObj.CellValue(chkArr[i],"amdt_seq") + ";";
					
				}

				//TODO:CHOI
				//[CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한) _ Draft Print
				// ESM_PRI_0003.js. buttonControl와 동일한 권한 참고
				var returnValue = checkPrintOpenAuthInfo(txt);
				if(returnValue == "Y" ){
					// print Popup open
					ComOpenWindowCenter("/hanjin/ESM_PRI_0079.do?sParam="+txt  +"&sp_scrn_evnt_pgm_cd=" + sSpScrnEvntPgmCd , "", 1024, 768, true);	
				} else { 
					//경고 : 권한이 없음.(경고 메세지 요청)
					ComShowCodeMessage('PRI01164', returnValue); //("You are not the authorized user");
				}	
				break;
				
//			case "btn_open2":
//				var sheetObj = sheetObjects[0];
//				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
//				var txt = "";
//			
//				var sParam = "&prop_no="+sheetObj.CellValue(sheetObj.SelectRow,"prop_no")+"&amdt_seq="+sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq");
//				ComOpenWindowCenter("/hanjin/ESM_PRI_0061.do?"+sParam, "", 1024, 795, true);				
//				break;				
				
			case "ret_tp_rdo":
				for(idx = 0; idx < formObj.ret_tp_rdo.length; idx++) {
					if(formObj.ret_tp_rdo[idx].checked == true) {
						var kind = formObj.ret_tp_rdo[idx].value;
						changeKind(kind-1);
						break;
					}
				}
			break;

            case "btns_calendar1": //달력버튼
            case "btns_calendar2":
	            var cal = new ComCalendarFromTo();
	            cal.select(document.form.auth_dur_eff_dt, document.form.auth_dur_exp_dt, 'yyyy-MM-dd');
	        break;

            case "btns_calendar3": //달력버튼
            case "btns_calendar4":
	            var cal = new ComCalendarFromTo();
	            cal.select(document.form.srep_dur_eff_dt, document.form.srep_dur_exp_dt, 'yyyy-MM-dd');
	        break;	        
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
	 
		for (var i = 0; i < sheetObjects.length; i++) {	
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);			
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);        
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	}
	 
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			
		case IBSEARCH: // 조회
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH01;
			var cd_tp = formObj.cd_tp.value;
			var cd1 = formObj.cd1.value;
			var cd2 = formObj.cd2.value;
			var eff_dt = formObj.eff_dt.value;
			var exp_dt = formObj.exp_dt.value;
			
			var sParam = FormQueryString(formObj)+"&cd_tp="+cd_tp+"&cd1="+cd1+"&cd2="+cd2+"&eff_dt="+eff_dt+"&exp_dt="+exp_dt;

			sheetObj.DoSearch("ESM_PRI_0039GS.do" , sParam);
			break;		
			
		case IBSEARCH_ASYNC01: //
			supressflg = true;
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH02;
			
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0039GS.do", FormQueryString(formObj));

			var arrDesc = ComPriXml2Array(sXml, "prop_no|amdt_seq|eff_dt|exp_dt");
			if(arrDesc==null){
				if(formObj.ret_tp_rdo[0].checked == true){
					formObj.sc_no.value="";
					formObj.sc_no.focus();
				}else if(formObj.ret_tp_rdo[1].checked == true){
					formObj.prop_no.value="";
					formObj.prop_no.focus();
				}
			}else{
				if(formObj.ret_tp_rdo[0].checked == true){
					formObj.amdt_seq.value=arrDesc[0][1];
					formObj.sc_dur_eff_dt.value=arrDesc[0][2];
					formObj.sc_dur_exp_dt.value=arrDesc[0][3];
					formObj.cd_tp.value = "1";
					formObj.cd1.value = formObj.sc_no.value;
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}else if(formObj.ret_tp_rdo[1].checked == true){
					formObj.prop_dur_eff_dt.value=arrDesc[0][2];
					formObj.prop_dur_exp_dt.value=arrDesc[0][3];
					formObj.cd_tp.value = "2";
					formObj.cd1.value = formObj.prop_no.value;
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			}
			supressflg = false;
			break;
		
		case IBSEARCH_ASYNC02: // Sale Rep 설정
			var etc1 = formObj.prop_ofc_cd.value;
			formObj.f_cmd.value = SEARCH15;
			var sParam = FormQueryString(formObj)+"&etc1="+etc1;
		
			sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm");
			break;	
		}
	}	 
    
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
		
		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 420;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;				

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				var HeadTitle  = "|Sel.|Seq.|S/C No.|AMD No.|Proposal No.|Customer Name|Request Office|MQC|EFF Date|EXP Date|Filed Date";
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter, 	 false, "status");
				InitDataProperty(0, cnt++ , dtCheckBox,      50,    daCenter, 	 false, "chk");                    
                InitDataProperty(0, cnt++ , dtSeq,    		 30,    daCenter, 	 true,  "Seq");
				InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	 false,	"sc_no",  	false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	 false,	"amdt_seq", 	false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 95,	daCenter,	 false,	"prop_no",  false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 260,	daLeft,		 false,	"ctrt_pty_nm",    	false,	"",		dfNone,		0,		false,	false); 
				InitDataProperty(0, cnt++ , dtData,			 95,	daCenter,	 false,	"prop_ofc_cd",  	false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 50,	daCenter,	 false,	"fnl_mqc_qty",    	false,	"",		dfNone,		0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,	 false,	"eff_dt",  false,	"",		dfDateYmd,	0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,	 false,	"exp_dt",  false,	"",		dfDateYmd,	0,		false,	false);
				InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	 false,	"file_dt",false,	"",		dfDateYmd,	0,		false,	false);
				
			}
			break;		

		}
	}		
	
		/**
		* 대상 combo 리스트 대상을 초기화한다.
		* . <br>
		* <br><b>Example :</b>
		* <pre>
		*     initCombo(comboObj, comboNo);
		* </pre>
		* @return 없음
		* @author 변영주
		* @version 2009.05.17
		*/		 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "prop_srep_cd":
	            var i=0;
	            with(comboObj) {
	            	//BackColor = "cyan";
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            }
	            break;
	    }
	}			

	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {

		var sc_no = formObj.sc_no.value;
		var prop_no = formObj.prop_no.value;
		var amdt_seq = formObj.amdt_seq.value;
		
		switch (sAction) {
		case IBSEARCH: // 조회
	
			if (sc_no == null && prop_no == null) {
				return false;
			}
			return true;
			break;
		}
	}
			
	 
		/**
		* Radio 버튼이 변경되었을 경우의 이벤트를 수행한다
		* . <br>
		* <br><b>Example :</b>
		* <pre>
		*     changeKind(nItem);
		* </pre>
		* @return 없음
		* @author 변영주
		* @version 2009.05.17
		*/		 
    function changeKind(nItem)
    {
        var objs = document.all.item("SearchLayer");

		for (var i = 0; i < objs.length; i ++){
			if (i != nItem) 
				objs[i].style.display = "none";
			else
				objs[nItem].style.display = "Inline";
		}
    }
	 
	/**
	* Srep Code 가  변경되었을 경우의 이벤트를 수행한다
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     changeKind(nItem);
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/	    
	function prop_srep_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var arrText = text.split("|");
		formObj.prop_srep_nm.value = arrText[1];
	}	    
	
	/**
	* 화면상의 오브젝트에 이벤트가 발생했을 경우에 수행
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     obj_activate() ;
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/		
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);
    }
    
    var supressFlg = false;
    
	/**
	* 화면상의 오브젝트에 이벤트가 종료되었을 경우에 수행
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     obj_deactivate();
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/	    
    function obj_deactivate() {
    	if(supressFlg) return;
        var formObj = document.form;
        var sheetObj = sheetObjects[0]; 
        var eleName = event.srcElement.name;
        switch(eleName){
            case "sc_no":
            	if(formObj.sc_no.value=="") return;
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                break;
            case "prop_no":
            	if(formObj.prop_no.value=="") return;
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                break;
            case "auth_dur_eff_dt":
                ComChkObjValid(event.srcElement);   
                break;
            case "auth_dur_exp_dt":
                ComChkObjValid(event.srcElement);   
                break;
            case "prop_dur_eff_dt":
            	break;
            case "prop_dur_exp_dt":
            	break;
            case "sc_dur_eff_dt":
            	break;
            case "sc_dur_exp_dt":
            	break;            	
            default:
                ComChkObjValid(event.srcElement);       
        }
        
    }  
	
	/**
	* UI 상에서 Key가 눌러졌을 경우 수행함
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     obj_keypress();
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/	    
    function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                if (event.srcElement.name == "sc_no" ||event.srcElement.name == "prop_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else {
                    ComKeyOnlyAlphabet('upper');
                }    
                break;
            default:
        }
    }      
	
    /**
     * OnKeyDown event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 변영주
     * @version 2010.01.08
     */        
   function obj_keydown(){
       //enter key조회
       var eleName = event.srcElement.name;
       var formObj = document.form;       
       var keyValue = null;
       if(event == undefined || event == null) {
    	   keyValue = 13;
       }else{
    	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
       }
       if (keyValue == 13){
           switch (eleName) {
		       case "sc_no":
		    	   	if(formObj.sc_no.value=="") return;
		    	       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
		    	       break;
	    	   case "prop_no":
		    	   	if(formObj.prop_no.value=="") return;
		    	       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
		    	       break;       
           }
       }
   }	
	
   
   /**
    * [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한)
    * S/C Proposal & Amendment Creation 화면의 PRINT 버튼 사용시 기준으로 동일하게 아래 대상으로 권한 적용(ESM_PRI_0003.js. buttonContro 참고)<br>
    * @param  txt
    * @return {string} <br>
    * @author 최성환
    * @version 2015.06.15
    */ 
	function checkPrintOpenAuthInfo(txt){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var rValue = "";
	   
		var arrPropNo = txt.split(";");
		var scNo 		= "";
		var propNo 	= "";
		var amdtSeq 	= "";
		for(var i=0 ; i < arrPropNo.length -1 ; i++)
		{
			var arrItem = arrPropNo[i].split(":");
			propNo = arrItem[0];
			scNo = arrItem[1];
			amdtSeq = arrItem[2];
	   
			formObj.f_cmd.value = SEARCH03;
			var sParam 	= "sc_no=" + scNo + "&prop_no=" + propNo + "&amdt_seq="+amdtSeq;
				  sParam   += "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0039GS.do", sParam);
			var stsCd 			= ComGetEtcData(sXml, "stsCd");
			var reqUsrFlg 		= ComGetEtcData(sXml, "reqUsrFlg");
			var aproUsrFlg 	= ComGetEtcData(sXml, "aproUsrFlg");
			var allUsrFlg 		= ComGetEtcData(sXml, "allUsrFlg");
			var maxPropUsrId = ComGetEtcData(sXml, "maxPropUsrId");
			
	 		//요건
	 		//※ 현재 Amd 회차 별 R.OFC 의 S.Rep 코드가 부여된 ID 유저에 해당 Amd 회차에 대해 활성화되고
	 		//   있으나, 마지막 회차의 R.OFC/S.Rep 코드의 ID 유저는 전(全) 회차에 대해 다운로드 할 수 있도록    보완 필요.
	 		//if (로그인 사용자가 = 마지막 회차의 R.OFC/S.Rep 코드의 ID 유저 일 경우) - 전회차 다운로드가능함
//			alert(stsCd + "||" + formObj.in_usr_id.value + "||"+maxPropUsrId);
			if(formObj.in_usr_id.value == maxPropUsrId){
				rValue = "Y";
				return rValue; 
			}
			
			var fileCancelAuth = checkFileCancelUser();
			
//	        if (!(stsCd =="F" && ( formObj.in_usr_id.value == FILE_CANCEL_ID  || formObj.in_usr_id.value == FILE_CANCEL_ID2 || formObj.in_usr_id.value == FILE_CANCEL_ID3
//							           ||formObj.in_usr_id.value == FILE_CANCEL_ID4 || formObj.in_usr_id.value == FILE_CANCEL_ID5 || formObj.in_usr_id.value == FILE_CANCEL_ID6 
//							           ||formObj.in_usr_id.value == FILE_CANCEL_ID7 || formObj.in_usr_id.value == FILE_CANCEL_ID8 || formObj.in_usr_id.value == FILE_CANCEL_ID9
//							           ||formObj.in_usr_id.value == FILE_CANCEL_ID10 ||formObj.in_usr_id.value == FILE_CANCEL_ID11) ))
			if (!(stsCd == "F" && (fileCancelAuth =="Y")))
			{ //Filed이고 허가된 유저이면 로직 적용 안함. 위 로직 변형
	        	if(reqUsrFlg !="Y" && aproUsrFlg !="Y")
	        	{
//	    			rValue = "N";   
	    			rValue = "[Proposal No. : "+propNo + "][Amend No. : " + amdtSeq + "]" ;
	    			return rValue;  //권한 없을시 바로 리턴함.
	        	}
	        }
			switch(stsCd) {
				case 'I':   // Initial              
	                if(reqUsrFlg=="Y"||aproUsrFlg=="Y"){
	                	rValue = "Y";
	                }
	                break;
	                
	            case 'Q':   // Requested
	            	rValue = "Y";           
	                break;
	                
	            case 'R':   // Returned
	                if (amdt_seq =="0"){
//		    			rValue = "N";  
		    			rValue = "[Proposal No. : "+propNo + "][Amend No. : " + amdtSeq + "]" ;
	                	return rValue;  //권한 없을시 바로 리턴함.
	                }else{ 
	                	rValue = "Y";
	                }
	                break;
	                
	            case 'A':   // Approved
	            	rValue = "Y";           
	                break;
	                
	            case 'F':   // Filed
	            	rValue = "Y";
	                break;                    
	        }
			//loop 속에서 한건이라도 권한이 없을 경우 바로 리턴 처리함.
			if(rValue != "Y" ){
				return rValue;  //한건이라도 권한 없을시 바로 리턴함.
			}
		}
		return rValue;  
	}        
	
	function checkFileCancelUser(){
		   var formObj = document.form;
		   var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCH33;                                                                                                                                                                                                                                                                                                                                                                                                        
			sXml = sheetObj.GetSearchXml("PRICommonGS.do",                                                                                                                                                                                                                                                                                                                                                                                   
					FormQueryString(formObj));                                                                                                                                                                                                                                                                                                                                                                        
			var fileCancelAuth = ComGetEtcData(sXml, "fileCancelAuth");      
			return fileCancelAuth;
	   }
	
	
	/* 개발자 작업  끝 */