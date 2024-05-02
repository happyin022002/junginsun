/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0079.js
*@FileTitle : S_C Print View
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.08.10 변영주
* 1.0 Creation
=========================================================
* 2011.04.26 김민아 [CHM-201110238-01] SC Inquiry -> SC List Inquiry 에서 Print 기능 추가 요청 - 수정한 .mrd를 call하므로 파라미터 수정
* 2011.04.27 김민아 [선처리] RD 로딩시 조회 버튼이 비활성 되도록 수정
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
     * @class ESM_PRI_0079 : ESM_PRI_0079 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0079() {
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
    
    var rdObjects = new Array();
    var rdCnt = 0;
       
	var sheetObjects = new Array();
	var sheetCnt = 0;    
	
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	var apro_usr_flg = "";
	var amdt_seq_list = new Array();
	
    document.onclick = processButtonClick;

    function processButtonClick(){
        var formObject = document.form; 
        var Rdviewer = rdObjects[0];
        var comboObj = comboObjects[1];
        var formObj = document.form;
        
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }			
            
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;			
				case "btn_print":
					if (!confirm("인쇄하시겠습니까?")) return;
					Rdviewer.SetPrint2(4, 1, 1, 100);
				    Rdviewer.PrintDialog();
					break;

				case "btn_saveas":
					Rdviewer.SetSaveExcelOption (1); //1- Maintain formats when saving as Microsoft Excel files, 2- Allow to change formats.
  				    Rdviewer.SaveAsDialog (); // Save the current document with displaying the 'Save As' dialog box.
  				    //TODO:CHOI  - SAVE EVENT
  				    //RD 저장 이벤트 - sp_prn_evnt_tp_cd : S
  				    document.form.sp_prn_evnt_tp_cd.value="S"; 
  					doActionIBSheet(sheetObjects[0],document.form, COMMAND01);
					break;
					
				case "btn_close":
					 //TODO:CHOI - CLOSE EVENT
  				    //RD 닫기 이벤트 - sp_prn_evnt_tp_cd : C					
					document.form.sp_prn_evnt_tp_cd.value="C";
  					doActionIBSheet(sheetObjects[0],document.form, COMMAND01);
					close();
					break;
					
				case "btns_back1":
					if(comboObj.Index==0) return;
					comboObj.Index = 0;
					break;
					
				case "btns_back2":
					if(comboObj.Index==0) return;
					comboObj.Index = --comboObj.Index;
					break;
					
				case "btns_next1":
					if(comboObj.Index == comboObj.GetCount()) return;
					comboObj.Index = ++comboObj.Index;
					break;
					
				case "btns_next2":
					if(comboObj.Index == comboObj.GetCount()) return;
					comboObj.Index = comboObj.GetCount()-1;
					break;
					
				case "btn_search":
					rdObjects[0].FindDialog();
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

	/**
	* Page 를 초기 로딩할 때 수행
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     loadPage();
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/	    
    function loadPage() {
    	controlBtn(false);
    	controlChkbox(true);
		initSheet(sheetObjects[0], 1);
	   	//RD
    	initRdConfig(rdObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		//TODO:CHOI - OPEN EVENT
		//RD 오픈 이벤트 - sp_prn_evnt_tp_cd : O
		document.form.sp_prn_evnt_tp_cd.value="O";
		doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
    }
	
    function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.SetNoDataDialogInfo(0, "", "");
//		Rdviewer.DisableToolbar (1); Print button enable 2010.11.09 - HJSONG
    }

	/**
	* RD Viewer 를 초기화하기 위하여 사용함
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     initRdConfig(rdObject)
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/    
    function rdOpen(rdObject,formObj){
    	controlBtn(false);
    	controlChkbox(true);
    	
    	var Rdviewer = rdObject ;
    	
    	var prop_no = formObj.prop_no.value;
    	var amdt_seq = formObj.amdt_seq.value;    	
    	var blpl_flg = formObj.blpl_flg.checked ? "Y" : "N";
    	var sign_flg = formObj.sign_flg.checked ? "Y" : "N";
    	// 열고자 하는 RD 파일을 지정한다.
    	var path  = "apps/alps/esm/pri/screport/screport/report/ESM_PRI_0079.mrd";
    	var param = "/rp [" + prop_no + "] ["+ amdt_seq +"] ["+ blpl_flg +"] ["+ sign_flg +"] /rxlspagezoom [95]";
    	// Proposal 일 경우는 상태와 상관 없이 full print 를 보여준다 
    	if(amdt_seq=="0"){
    		path  = "apps/alps/esm/pri/screport/screport/report/ESM_PRI_0061.mrd";
    		param = "/rp [" + prop_no + "] ["+ amdt_seq +"] ["+ blpl_flg +"] ["+ sign_flg +"] [A] /rxlspagezoom [95]";
    		
    	}

//    	RD_path = "http://localhost:7001/hanjin/";
    	var df_save_nm = "";
    	if(formObj.sc_no.value == '' || formObj.sc_no.value == null ) {
    		df_save_nm = formObj.prop_no.value;
    	} else {
    		df_save_nm = formObj.sc_no.value+"_"+formObj.amdt_seq.value;
    	}    	
    	
    	Rdviewer.SetSaveDialogEx ("c:\\", df_save_nm, "xls@pdf@ppt@doc", "xls");    	
    	
    	//TODO:CHOI 
    	//6개 항목 사용 불가 
    	Rdviewer.DisableToolbar (0);//0-파일저장
    	Rdviewer.DisableToolbar (1);//1-인쇄    	
    	Rdviewer.DisableToolbar (13);//13-엑셀로보기
    	Rdviewer.DisableToolbar (15); //15-PDF로보기
    	Rdviewer.DisableToolbar (16);//16-파워포인트로보기
    	Rdviewer.DisableToolbar (17);	//17-워드로보기
    	
    	Rdviewer.FileOpen(RD_path + path, RDServer + param);
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
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(1, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false, false)
	
				var HeadTitle = "status";
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				
				Visible = false;
			}
			break;
		}
	}    
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // sc_no_list 변경시 해당 master 데이터 조회 및 화면 조회
			
				var comboObj = comboObjects[1]; 
				formObj.f_cmd.value=SEARCH01;
				var sParam = "&f_cmd="+SEARCH01+"&prop_no=" + comboObj.Code + "&amdt_seq=" + amdt_seq_list[comboObjects[1].Index];
				var sXml = sheetObj.GetSearchXml("ESM_PRI_0079GS.do", sParam);
				var arrText = ComPriXml2Array(sXml, "sc_no|amdt_seq|prop_no|eff_dt|exp_dt|file_dt|prop_ofc_cd|prop_srep_cd|prop_apro_ofc_cd|apro_usr_nm|cre_dt|apro_usr_flg|blpl_amdt_flg");
		    	if(arrText==""||arrText==undefined){
		    		ComShowCodeMessage("PRI00013");
		    		return;
		    	}
		    	var seq = comboObj.Index;
		    	formObj.sc_seq.value = ++seq;
				formObj.sc_no.value = arrText[0][0];
				formObj.amdt_seq.value = arrText[0][1];
				formObj.prop_no.value = arrText[0][2];
				formObj.ctrt_eff_dt.value = arrText[0][3];
				formObj.ctrt_exp_dt.value = arrText[0][4];
				formObj.prop_file_dt.value = arrText[0][5];
				formObj.prop_ofc_cd.value = arrText[0][6];
				comboObjects[0].Text = arrText[0][7];
				formObj.prop_srep_nm.value = comboObjects[0].Code;	
				formObj.apro_ofc_cd.value = arrText[0][8];
				formObj.apro_usr_nm.value = arrText[0][9];
				formObj.prop_cre_dt.value = arrText[0][10];
				apro_usr_flg = arrText[0][11];
//				formObj.blpl_flg.checked = arrText[0][12] == "Y" ? true : false;
				
				controlTools(formObj);
				rdOpen(rdObjects[0], document.form);				
				break;
			case IBCLEAR: // 초기화시 combo 내용 삽입
				if (validateForm(sheetObj,document.form,sAction)) {
			    	//전체 Sales Rep
					formObj.f_cmd.value = SEARCH16;
					var sParam = FormQueryString(formObj);	
					sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
					ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "nm", "cd");
				}		
				comboObjects[0].Enable = false;
				var arrPropNo = formObj.sParam.value.split(";");
				for(i=0;i<arrPropNo.length-1;i++){
					var arrItem = arrPropNo[i].split(":");
					var seq = i+1;
					comboObjects[1].InsertItem(i, seq+". "+(arrItem[1]=="" ? arrItem[0] : arrItem[1]), arrItem[0]);
					amdt_seq_list[i] = arrItem[2];
				}
				comboObjects[1].Index = 0;
				break;
				
			//TODO::CHOI	- RD 이력 저장	
			//f_cmd - COMMAND01
			//sp_prn_evnt_tp_cd : RD Open : O, RD Save : S, RD Close : C
			case COMMAND01: 
				formObj.f_cmd.value=COMMAND01;
				var sParam = FormQueryString(formObj);	
				var sXml = sheetObj.GetSaveXml("ESM_PRI_0079GS.do", sParam);                 
                formObj.prnt_scrn_evnt_seq.value = ComGetEtcData(sXml,"prnt_scrn_evnt_seq");     
                break;
                

		}
	}	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBCLEAR: // 조회
			return true;		
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			} else {
				return true;
			}
		break;			

		}
	}	

	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}	

	/**
	* 화면상의 Combo 가 변경되었을 경우의 이벤트 처리
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     sc_no_list_OnChange(comboObj, code, text)
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/	
	function sc_no_list_OnChange(comboObj, code, text) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	
	/**
	* CheckBox 의 활성화, 비활성화 셋팅<br>
	* <br><b>Example :</b>
	* <pre>
	*     controlChkbox(flag);
	* </pre>
	* @return 없음
	* @author 김민아
	* @version 2011.04.19
	*/	
	function controlChkbox(flag){
		var formObject = document.form;
		document.all.blpl_flg.disabled = flag;
		document.all.sign_flg.disabled = flag;
	}
	
	/**
	* Button 의 활성화, 비활성화 셋팅<br>
	* <br><b>Example :</b>
	* <pre>
	*     controlBtn(flag);
	* </pre>
	* @return 없음
	* @author 김민아
	* @version 2011.04.19
	*/	
	function controlBtn(flag){
		var formObject = document.form;
		if(flag){
			ComBtnEnable("btn_print");
			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_saveas");	
		}else{
			ComBtnDisable("btn_print");
			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_saveas");
		}
	}
	
	/**
	* RD Viewer 에서 Viewer 의 속성을 변경하기 위하여 사용
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     controlTools(formObj);
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/		
	function controlTools(formObj){
        var formObject = document.form;		
        var Rdviewer = rdObjects[0];
		var file_nm = formObject.sc_no.value + "_"+formObject.amdt_seq.value;
		Rdviewer.SetSaveDialogEx ("c:\\", file_nm, "pdf@xls@doc@ppt", "pdf");						
      
	}

	/**
	* RD Viewer 에서 로딩이 완료되었을 경우에 Print  버튼과 Save As 버튼을 활성화 시킴
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     ReportFinished();
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2010.03.08
	*/		
	function ReportFinished(){
		controlBtn(true);
		controlChkbox(false);
	}	
	
	/* 개발자 작업  끝 */