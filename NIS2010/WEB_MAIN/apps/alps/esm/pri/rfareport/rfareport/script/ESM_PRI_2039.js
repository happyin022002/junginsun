/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2039.js
*@FileTitle : RFA Proposal Creation - Draft
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.15 변영주
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
     * @class ESM_PRI_2039 : ESM_PRI_2039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2039() {
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
	
	var prop_srep_cd = "";
	
    document.onclick = processButtonClick;

    function processButtonClick(){
        var formObject = document.form; 
        var Rdviewer = rdObjects[0];
        
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }			
            
			switch (srcName) {
				case "btn_retrieve":
			    	rdOpen(rdObjects[0], document.form);
					break;
		
				case "btn_print":
					if (!confirm("인쇄하시겠습니까?")) return;
					    Rdviewer.PrintDialog();
					break;
					
				case "btn_downexcel":
					Rdviewer.ViewExportFile(2); 
					break;
					
				case "btn_close":
					close(); 
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

    function loadPage() {
    	initSheet(sheetObjects[0], 1);
	   	//RD
    	initRdConfig(rdObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
		Rdviewer.SetNoDataDialogInfo(0, "", "");
    }

    function rdOpen(rdObject,formObj){
    	var Rdviewer = rdObject ;
    	// 열고자 하는 RD 파일을 지정한다.

    	if(formObj.ret_tp_rdo[0].checked == true){
    		path  = "apps/alps/esm/pri/rfareport/rfareport/report/ESM_PRI_2039.mrd";
    	}else{
    		path  = "apps/alps/esm/pri/rfareport/rfareport/report/ESM_PRI_2062.mrd";
    	}
    	var param = "/rp [" + formObj.prop_no.value + "] ["+formObj.amdt_seq_t.value +"]";
    	
    	var df_save_nm = "";
    	if(formObj.rfa_no.value == '' || formObj.rfa_no.value == null ) {
    		df_save_nm = formObj.prop_no.value;
    	} else {
    		df_save_nm = formObj.rfa_no.value+"_"+formObj.amdt_seq_t.value;
    	}
    	
    	Rdviewer.SetSaveDialogEx ("c:\\", df_save_nm, "xls@pdf@ppt@doc", "xls");
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
			case IBSEARCH: // 화면 로딩시 Tab Count 조회
				formObj.f_cmd.value=SEARCH01;
				var sParam = "&prop_no="+formObj.prop_no.value;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2039GS.do", FormQueryString(document.form)+sParam);
				var arrText = ComPriXml2Array(sXml, "rfa_no|prop_no|amdt_seq");
		    	if(arrText==""||arrText==undefined){
		    		ComShowCodeMessage("PRI00013");
		    		return;
		    	}					
				formObj.rfa_no.value = arrText[0][0];
				formObj.prop_no_t.value = arrText[0][1];
				formObj.amdt_seq_t.value = arrText[0][2];
				if(arrText[0][2]=="0"){
					formObj.ret_tp_rdo[1].disabled   = true;					
				}
				controlTools(formObj);
				rdOpen(rdObjects[0], document.form);				
				break;
		}
	}	

	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	
	function controlTools(formObj){
        var Rdviewer = rdObjects[0];
		var usr_srep_cd = formObj.usr_srep_cd.value;
		return;
		if(usr_srep_cd!=prop_srep_cd){
			Rdviewer.DisableToolbar(0);
			Rdviewer.DisableToolbar(3);
			Rdviewer.DisableToolbar(13);
			Rdviewer.DisableToolbar(14);
			Rdviewer.DisableToolbar(16);
			Rdviewer.DisableToolbar(17);
		}
	}

	/* 개발자 작업  끝 */