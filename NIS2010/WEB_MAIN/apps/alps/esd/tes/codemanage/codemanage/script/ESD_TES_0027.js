/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_027.js
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-01
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-01 jongbaemoon
* 1.0 최초 생성
=========================================================*/

/**
 * @fileoverview Cost Code Creation 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author SM LINE
 */

/**
 * @extends Tes
 * @class ESD_TES_0027 : Cost Code Creation 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TES_0027() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/*  공통전역변수 ------------------------------------------------------------- */
//위 기본정보, 아래 SHEET의 저장상태 
var comboObjects = new Array();
var comboCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param {ibsheet} sheet_obj 	IBSheet Object
	 * @return
	 */     
	function setSheetObject(sheet_obj){	
	   sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBCombo Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param {combo}	combo_obj	combo object
	 * @return
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * @return
	 */
	function loadPage() {
	    for(i=0;i<sheetObjects.length;i++){
	    	ComConfigSheet (sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
		
        for(i=0;i< comboObjects.length;i++){
            initCombo (comboObjects[i],i+1);
        }
        
        document.form.lgs_cost_cd.focus();
        
	    tes_getComboItem('acct_cd', 1, SEARCHLIST06, '', '');
	}

	/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	***************************************************************************************/
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
		
	function processButtonClick(){
//		try {
			var srcName = window.event.srcElement.getAttribute("name");
			// form 이름에 주의하시기 바랍니다. 
			with(document.form) {
				switch (srcName) {
					// 버튼 이름으로 case를 넣어 주셔야 합니다. 
					case "btn_retrieve":
						if(fnChkForm()){					
							retrieve();
						}
						break;
						
					case "btn_new":
						fncNew();
						break;
						
					case "btng_delete":
						if(fnChkForm('REMOVE')){																			
							window.showModalDialog("ESD_TES_9090.do?openerUIName=0027&gb=REMOVE", window, "dialogWidth:308px; dialogHeight:170px; help:no; status:no; resizable:no;");
						}
						break;
					case "btng_save":		
						if(fnChkForm(document.form.gb.value)){															
							// 설계상 OPT NO 중복 체크하도록 되어있는거 같은데 로직 구현되어 있지 않아서 추가함.(2010-03-24)
							window.showModalDialog("ESD_TES_9090.do?openerUIName=0027&gb="+document.form.gb.value+"&lgs_cost_cd="+document.form.lgs_cost_cd.value+"&lgs_cost_opt_no="+document.form.lgs_cost_opt_no.value, window, "dialogWidth:308px; dialogHeight:170px; help:no; status:no; resizable:no;");
						}												
						break;
//					case "btng_modify":										
//						if(document.form.lgs_cost_full_nm.value == null || document.form.lgs_cost_full_nm.value == "") {
//							ComShowMessage("Input cost abbr nm.");
//							document.form.lgs_cost_full_nm.focus();
//							return false;
//						}
//									
//						if(document.form.lgs_cost_abbr_nm.value == null || document.form.lgs_cost_abbr_nm.value == "") {
//							ComShowMessage("Input cost code.");
//							document.form.lgs_cost_abbr_nm.focus();
//							return false;
//						}
//
//						if(document.form.lgs_cost_opt_no.value == null || document.form.lgs_cost_opt_no.value == "") {
//							ComShowMessage("Input cost opt no.");
//							document.form.lgs_cost_opt_no.focus();
//							return false;
//						}				
//						
//						if (!ComIsNumber(document.form.lgs_cost_opt_no)){
//					 		  	ComShowMessage(ComGetMsg('TES15009'));
//					 		  	document.form.lgs_cost_opt_no.value="";
//					 		  	document.form.lgs_cost_opt_no.focus();
//					 		  	return false;				   					
//						}						
//					
//						if(fnChkForm()){
//							//openWindow("ESD_TES_9090.do?gb=MODIFY", "userpassword", "width=300,height=150,menubar=0,status=0,scrollbars=0,resizable=0");								
//							window.showModalDialog("ESD_TES_9090.do?openerUIName=027&gb=MODIFY", window, "dialogWidth:308px; dialogHeight:170px; help:no; status:no; resizable:no;");
//						}												
//						break;						
				} // end switch
			}// end with
//		} catch(e) {
//			if( e = "[object Error]") {
//				ComShowMessage(ComGetMsg('TES21025'));
//			} else {
//				ComShowMessage(e);
//			}
//		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {int} sheetNo 	시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 							시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @return
	 */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {

        case 1: 
        with (sheetObj) {
			// 높이 설정
			style.height = 240;
								
			//전체 너비 설정
			SheetWidth = 1024;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

		   //전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 9, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(17, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			var HeadTitle = "status|lgs_cost_cd|lgs_cost_full_nm|lgs_cost_subj_cd|lgs_cost_dtl_cd|lgs_cost_cd_clss_lvl|lgs_cost_opt_no|lgs_cost_abbr_nm|acct_cd|lgs_cost_rmk|thrp_flg|crr_acct_cd|delt_flg|cre_usr_id|cre_dt|upd_usr_id|upd_dt";
            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 데이터속성 	[ROW, COL, DATATYPE, 	WIDTH, DATAALIGN, COLMERGE, SAVENAME, 				KEYFIELD,	 CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus, 	80, daCenter, false,	"ibflag", false, "");
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_cd"         ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_full_nm"    ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_subj_cd"    ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_dtl_cd"     ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_cd_clss_lvl",    false,          "",       dfNone,      0,     false,      false);
            
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_opt_no"     ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_abbr_nm"    ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "acct_cd"             ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "lgs_cost_rmk"        ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "thrp_flg"            ,    false,          "",       dfNone,      0,     false,      false);
            
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "crr_acct_cd"         ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "delt_flg"            ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "cre_usr_id"          ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "cre_dt"              ,    false,          "",       dfNone,      0,     false,      false);
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "upd_usr_id"          ,    false,          "",       dfNone,      0,     false,      false);
            
            InitDataProperty(0, cnt++ , dtData,       80,    daLeft,  false,    "upd_dt"              ,    false,          "",       dfNone,      0,     false,      false);

		}
        break;
        }
	 }
	
	/**
	 * Combo 기본 설정 Combo의 항목을 설정한다.
	 * @param {combo}	comboObj	combo object
	 * @param {int}		comboNo		combo index
	 * @param {array}	keyArr		key array
	 * @param {array}	valueArr	value array
	 * @return
	 */
	function initCombo( comboObj, comboNo, keyArr, valueArr ) {

		var cnt = 0;
		switch (comboNo) {
		case 1:
			with (comboObj) {
				SetColAlign("center");
				SetColWidth("90");
				DropHeight = 150;
	
				var key='';
				var val='';
				for ( var i = 0; keyArr != undefined && keyArr != null && i < keyArr.length; i++) {
					
					if( keyArr[i]!=undefined && keyArr[i]!=null ) key = keyArr[i];
					else  key = '';
					
					if( valueArr[i]!=undefined && valueArr[i]!=null ) val = valueArr[i];
					else  val = '';
					
					InsertItem( cnt++, new String(key), new String(key) );
					
				}
	
			}
			break;
		}
	}	 
	 
	/**
	 * Retrieve 버튼을 클릭 시 처리되는 업무
	 * @param 
	 * @return
	 */
	function retrieve(){
		var formObj = document.form;
		doActionSheet(sheetObjects[0], formObj, IBSEARCH);	
	}
	
	/**
	 * Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		실행할 액션 구분 값
	 * @return
	 */
	 function doActionSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg = false;
       switch(sAction) {

          case IBSEARCH:      //조회
		    formObj.f_cmd.value = SEARCH;
//          	sheetObj.DoSearch4Post("ESD_TES_0027.do", tesFrmQryStr(formObj));
          	var arrXml = sheetObj.GetSearchXml("ESD_TES_0027GS.do", tesFrmQryStr(formObj)).split("|$$|");	
			
			for (var i=0; arrXml!=null && i<arrXml.length; i++) {
				sheetObjects[i].LoadSearchXml(arrXml[i]); 
			}
		    
//		    ComDebug(arrXml);		
		    break;
		    
      }
   }
   
	 /**
	  * 조회가 완료되고 발생하는 이벤트
	  * @param {sheet}	sheet		ibsheet
	  * @param {string}	ErrMsg			error message
	  * @return
	  */
	function sheet_OnSearchEnd(sheet, ErrMsg) {

		var formObj = document.form;
		if (sheet.RowCount == 1) {
			formObj.lgs_cost_cd.value          = sheet.CellValue(1, "lgs_cost_cd");
			formObj.lgs_cost_cd.readOnly 		= true;
			
			formObj.lgs_cost_full_nm.value     = sheet.CellValue(1, "lgs_cost_full_nm");
			formObj.lgs_cost_abbr_nm.value     = sheet.CellValue(1, "lgs_cost_abbr_nm");
			formObj.lgs_cost_opt_no.value      = sheet.CellValue(1, "lgs_cost_opt_no");
			
			formObj.acct_cd.Code               = sheet.CellValue(1, "acct_cd");
			formObj.crr_acct_cd.value          = sheet.CellValue(1, "crr_acct_cd");
			
			formObj.lgs_cost_rmk.value         = sheet.CellValue(1, "lgs_cost_rmk");
			formObj.lgs_cost_cd_clss_lvl.value = sheet.CellValue(1, "lgs_cost_cd_clss_lvl");
			formObj.lgs_cost_subj_cd.value     = sheet.CellValue(1, "lgs_cost_subj_cd");
			formObj.lgs_cost_dtl_cd.value      = sheet.CellValue(1, "lgs_cost_dtl_cd");
			formObj.cre_usr_id.value           = sheet.CellValue(1, "cre_usr_id");
			formObj.cre_dt.value               = sheet.CellValue(1, "cre_dt");
			formObj.upd_dt.value               = sheet.CellValue(1, "upd_dt");
			
			formObj.gb.value='MODIFY';
		} else if (sheet.RowCount < 1) {
			ComShowMessage(ComGetMsg('TES21017'));
			fncNew();
		}
	}
	  
	/**
	 * main hidden sheet 저장 완료되고 발생하는 이벤트
	 * @param {ibsheet}	sheet		sheet
	 * @param {string}	ErrMsg		error message
	 * @return
	 */	
	function sheet_OnSaveEnd(sheet, ErrMsg) {	
		if (sheet.RowCount < 1) {
			fncNew();
		}
	}
	
	/**
	 * 유효성체크
	 * @param theForm
	 * @return
	*/
	function fnChkForm(tp) {
		if( tp == 'ADD' ){
			
			if(document.form.lgs_cost_cd.value == null || document.form.lgs_cost_cd.value == "") {
				ComShowMessage(ComGetMsg('TES15004'));
				document.form.lgs_cost_cd.focus();
				return false;
			}		
					
			if(document.form.lgs_cost_cd.value.length == 1 || document.form.lgs_cost_cd.value.length == 3 || document.form.lgs_cost_cd.value.length == 5) {							
				ComShowMessage(ComGetMsg('TES15005'));
				document.form.lgs_cost_cd.focus();
				return false;
			}	
												
			var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        for (var inx = 0; inx < document.form.lgs_cost_cd.value.length; inx++) {
	           if (chars.indexOf(document.form.lgs_cost_cd.value.charAt(inx)) == -1) {
	            	ComShowMessage(ComGetMsg('TES15003'));
	            	document.form.lgs_cost_cd.value="";
	            	document.form.lgs_cost_cd.focus();
	               return false;
	           } // end if
	        } // end for						 
									
			if(document.form.lgs_cost_full_nm.value == null || document.form.lgs_cost_full_nm.value == "") {
				ComShowMessage(ComGetMsg('TES15006'));
				document.form.lgs_cost_full_nm.focus();
				return false;
			}
						
			if(document.form.lgs_cost_abbr_nm.value == null || document.form.lgs_cost_abbr_nm.value == "") {
				ComShowMessage(ComGetMsg('TES15007'));
				document.form.lgs_cost_abbr_nm.focus();
				return false;
			}
	
			if(document.form.lgs_cost_opt_no.value == null || document.form.lgs_cost_opt_no.value == "") {
				ComShowMessage(ComGetMsg('TES15008'));
				document.form.lgs_cost_opt_no.focus();
				return false;
			}		
	
			if (!ComIsNumber(document.form.lgs_cost_opt_no)){
		 		  	ComShowMessage(ComGetMsg('TES15009'));
		 		  	document.form.lgs_cost_opt_no.value="";
		 		  	document.form.lgs_cost_opt_no.focus();
		 		  	return false;				   					
			}	
			
		} else if( tp == 'MODIFY') {
			
			if(document.form.lgs_cost_full_nm.value == null || document.form.lgs_cost_full_nm.value == "") {
				ComShowMessage("Input cost abbr nm.");
				document.form.lgs_cost_full_nm.focus();
				return false;
			}
						
			if(document.form.lgs_cost_abbr_nm.value == null || document.form.lgs_cost_abbr_nm.value == "") {
				ComShowMessage("Input cost code.");
				document.form.lgs_cost_abbr_nm.focus();
				return false;
			}
	
			if(document.form.lgs_cost_opt_no.value == null || document.form.lgs_cost_opt_no.value == "") {
				ComShowMessage("Input cost opt no.");
				document.form.lgs_cost_opt_no.focus();
				return false;
			}				
			
			if (!ComIsNumber(document.form.lgs_cost_opt_no)){
	 		  	ComShowMessage(ComGetMsg('TES15009'));
	 		  	document.form.lgs_cost_opt_no.value="";
	 		  	document.form.lgs_cost_opt_no.focus();
	 		  	return false;				   					
			}				
			
		} else if( tp =='REMOVE') {

			if(document.form.lgs_cost_cd.value == null || document.form.lgs_cost_cd.value == "") {
				ComShowMessage(ComGetMsg('TES15001'));
				document.form.lgs_cost_cd.focus();
				return false;
			}
			
			if(document.form.lgs_cost_cd.value.length == 1 || document.form.lgs_cost_cd.value.length == 3 || document.form.lgs_cost_cd.value.length == 5) {							
				ComShowMessage(ComGetMsg('TES15002'));
				document.form.lgs_cost_cd.focus();
				return false;
			}	
												
			var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        for (var inx = 0; inx < document.form.lgs_cost_cd.value.length; inx++) {
	           if (chars.indexOf(document.form.lgs_cost_cd.value.charAt(inx)) == -1) {
	            	ComShowMessage(ComGetMsg('TES15003'));
	            	document.form.lgs_cost_cd.value="";
	            	document.form.lgs_cost_cd.focus();
	               return false;
	           } // end if
	        } // end for	
	        
		} else {	//조회
			if(document.form.lgs_cost_cd.value == null || document.form.lgs_cost_cd.value == "") {
				ComShowMessage(ComGetMsg('TES15004'));
				document.form.lgs_cost_cd.focus();
				return false;
			}			
		}
		
		return true;
	}
	
	/**
	 * 삭제
	 * @return
	 */
	function deleteOk(){	
		var formObj = document.form;
		formObj.f_cmd.value = REMOVE;
		var sSaveXml = sheetObjects[0].GetSaveXml( "ESD_TES_0027GS.do", sheetObjects[0].GetSaveString(false, false) + '&' + tesFrmQryStr(formObj));
		sheetObjects[0].LoadSaveXml(sSaveXml);
		
		fncNew();		
	}

	/**
	 * 입력
	 * @return
	 */
	function addOk(){	

		var formObj = document.form;
		formObj.f_cmd.value = ADD;
		
		var sXml = sheetObjects[0].GetSaveXml( "ESD_TES_0027GS.do", tesFrmQryStr(formObj) + '&' + sheetObjects[0].GetSaveString(false, false));
		
		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i].LoadSearchXml(arrXml[i]); 
		}			
	}
	
	/**
	 * 입력불가능한 [Cost Code] 입력되어서 항목 초기화 하고 메시지 띄움
	 * 메세지 - 입력불가능한 cost code입니다. 다시 입력하십시요..'
	 * @return
	 */
	function addNo(){	
		document.form.lgs_cost_cd.value = "";
		document.form.lgs_cost_cd.focus();
		ComShowMessage(ComGetMsg('TES90101'));		
	}	
	
	/**
	 * 수정
	 * @return
	 */
	function modifyOk(){
		var formObj = document.form;
		formObj.f_cmd.value = MODIFY;
		var sXml = sheetObjects[0].GetSaveXml( "ESD_TES_0027GS.do", sheetObjects[0].GetSaveString(false, false) + '&' + tesFrmQryStr(formObj));
		
		var arrXml = sXml.split("|$$|"); 
		
		for (var i=0; arrXml!=null && i<arrXml.length; i++) {
			sheetObjects[i].LoadSearchXml(arrXml[i]); 
		}		
	}
	
	/**
	 * [Cost Code] 항목 입력시 작동
	 * 입력된 [Cost Code]값에 따라 [Cost Class], [Subject Code], [Detail Code] 항목값 설정
	 * @return
	 */
	function autowrite(){
		document.form.lgs_cost_cd.value = document.form.lgs_cost_cd.value.toUpperCase();
		document.form.lgs_cost_subj_cd.value = document.form.lgs_cost_cd.value.substring(0,2).toUpperCase();
		document.form.lgs_cost_dtl_cd.value = document.form.lgs_cost_cd.value.substring(0,4).toUpperCase();
		
		var cost_cd_len=0;
		cost_cd_len  = document.form.lgs_cost_cd.value.length;
		
		if(cost_cd_len==2){
			document.form.lgs_cost_cd_clss_lvl.value = "S";
		}
		else if(cost_cd_len==4) {
			document.form.lgs_cost_cd_clss_lvl.value = "D";
		}
		else if(cost_cd_len==6){
			document.form.lgs_cost_cd_clss_lvl.value = "A";
		}
		else{
			document.form.lgs_cost_cd_clss_lvl.value = "";
		}		
		
		sheetObjects[0].CellValue2(2,"lgs_cost_cd")=document.form.lgs_cost_cd.value;
	}
	
	/**
	 * sheet 와 입력받는 각 항목들 동기화
	 * @param {object} obj	text box
	 * @return
	 */
	function syncData(obj){
		eval( "sheetObjects[0].CellValue2(1,'"+obj.name+"') = '"+obj.value+"'" );
	}
	
	/**
	 * sheet 와 입력받는 각 항목들 동기화
	 * @param {object} obj	text area
	 * @return
	 */
	function syncDataRmk(obj){
		sheetObjects[0].CellValue2(1,"lgs_cost_rmk") = obj.value;
	}
	
	/**
	 * acct cd 변경시 발생하는 이벤트
	 * @param {int}		Index_Code	index
	 * @param {string}	Text		code value
	 * @return
	 */
	function acct_cd_OnChange(Index_Code, Text) {

		var formObj = document.form;
		var sheet = sheetObjects[0];
		if (sheet.RowCount == 1) {
			sheet.CellValue2(1,"acct_cd") = formObj.acct_cd.Code;
		}
	}

	 /**
	  * 화면 초기화
	  * @return
	  */
	function fncNew(){
		sheetObjects[0].RemoveAll();
		document.form.reset();
		document.form.lgs_cost_cd.readOnly = false;
		document.form.lgs_cost_cd.focus();
		tes_getComboItem('acct_cd', 1, SEARCHLIST06, '', '');
	}

	
	
	