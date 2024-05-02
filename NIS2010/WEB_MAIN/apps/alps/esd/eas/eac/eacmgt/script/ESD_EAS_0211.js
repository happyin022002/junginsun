/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0211.js
*@FileTitle : Rejection Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
     * @class ESD_EAS_0211 : ESD_EAS_0211 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0211() {
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

	//공통전역변수

    
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	var rdObjects = new Array();
	var rdCnt = 0;	
	
	var frm = null;

    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
     * IBMultiCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
   	 comboObjects[comboCnt++] = combo_obj;
    }	


	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;	

	 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick(){
	      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	      var sheetObject1 = sheetObjects[0];

	      /*******************************************************/
	      var formObject = document.form;

	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btng_send":
					doActionIBSheet(sheetObject1,formObject,"btng_send");
					break;
                case "btng_print":
                	rdObjects[0].PrintDialog();
                	break;
                case "btng_close":
                	window.close();
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
		var sheetObj = sheetObjects[0];
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
	   }
	    
		 frm.f_cmd.value = SEARCH01;
		 var sParam = FormQueryString(frm);
		 var sXml = sheetObj.GetSaveXml("ESD_EAS_0211GS.do", sParam);
		 sheetObj.LoadSearchXml(sXml);

	}
	
	function initControl() {
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
	}
	
	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "ntc_cc_rcv_eml":
				if(frm.ntc_cc_rcv_eml.value !="" && !EasIsEmailAddr(frm.ntc_cc_rcv_eml.value)){
					// 메일주소를 확인하세요
					ComShowCodeMessage("EAS90084"); // E-mail address check
					frm.ntc_cc_rcv_eml.focus();
					return;
				}
			break;
		}
	}		
	

	function emlUseFlgChk(){
		var sheetObj = sheetObjects[0];
		if(frm.eac_eml_use_flg.checked){
	    	 if(sheetObj.CellValue(1,'vndr_eml') != ""){
	    		 frm.eac_eml.value = "("+sheetObj.CellValue(1,'vndr_eml')+")";
	    	 }else{
	    		 frm.eac_fax.value =""
	    	 }
	    	 
		}else{
 		   frm.eac_eml.value = "";
		}
	}
	
	function emlFaxFlgChk(){
		var sheetObj = sheetObjects[0];
	      if(frm.eac_fax_use_flg.checked){
	    	 if(sheetObj.CellValue(1,'fax_no') != ""){
	    		 frm.eac_fax.value = "("+sheetObj.CellValue(1,'fax_no')+")";
	    	 }else{
	    		 frm.eac_fax.value =""
	    	 }
		  }else{
			 frm.eac_fax.value = "";
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
					style.height = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = 7;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 1, 100);

					var HeadTitle1 = "|SEQ";
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   	true,   "ibflag",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "eml_subj_ctnt",        false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "eml_ctnt",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "vndr_eml",             false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "phn_no",              	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "fax_no",              	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "eac_eml_use_flg",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "eac_fax_use_flg",      false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "ntc_cc_rcv_eml",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "usr_eml",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtData,          30,  	daCenter,   true,   "snd_yn",       false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
					
//					SetMergeCell(0, 30, 2, 2); 
//					SetMergeCell(0, 32, 2, 2); 
					
//					InLineColor = RgbColor(255,255,255); 
//					OutLineColor = RgbColor(255,255,255); 
					
				}
				break;
			}
		}
	 

	 /**
	  * rd 환경을 초기화한다.
	  */
	 function rdInit(rdObj){
	 	rdObj.AutoAdjust = true;
//	 	rdObj.HideToolbar();
	 	rdObj.SetSaveDialogEx("", "", "pdf", "pdf");
	 	rdObj.DisableToolbar(13);
	 	rdObj.DisableToolbar(14);
	 	rdObj.DisableToolbar(16);
	 	rdObj.DisableToolbar(17);
	 	rdObj.HideStatusbar();
	 	rdObj.ViewShowMode(0);
	 	rdObj.setbackgroundcolor(255,255,255);
	 	rdObj.SetPageLineColor(255,255,255);
	 }
	 
	   /**
	    * rd를 open한다
	    * @param sheetObj
	    * @param Row
	    * @return
	    */
		function rdView() {
			
			var Rdviewer = rdObjects[0] ;
			// 디버그 용 파라미터
			var rdParam = "/rdebugmode [1] /rp ["+frm.ofc_cd.value+"]["+frm.usr_id.value+"]["+frm.eac_no.value+"]["+sheetObjects[0].CellValue(1,'snd_yn')+"]";
//			var rdParam = "/rp ["+frm.ofc_cd.value+"]["+frm.usr_id.value+"]["+frm.eac_no.value+"]";
			var rdPath = RD_path+'/apps/alps/esd/eas/eac/eacmgt/report/ESD_EAS_0211.mrd';
				frm.rd_param.value =rdParam ; 
				frm.rd_path.value = rdPath;
				frm.rd_name.value = "ESD_EAS_0211.mrd";
//			var rdParam = "/rp ["+frm.ofc_cd.value+"]["+frm.usr_id.value+"]["+frm.eac_no.value+"]";
				Rdviewer.FileOpen(rdPath, RDServer + rdParam);
		} 

		 

		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
			sheetObj.ShowDebugMsg = false;
			
			switch (sAction) {

				// SEARCH LOGIC
				case "btng_send":
					if(!validateForm(sheetObj,frm,sAction)) return false;
					if (!ComShowCodeConfirm('EAS90083')) return;// Do you send the rejection notice to S/P?
					ComOpenWait(true);
					 frm.f_cmd.value = MULTI01;
					 var sParam = FormQueryString(frm);
					 var sXml = sheetObj.GetSaveXml("ESD_EAS_0211GS.do", sParam);
					 
					 var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					 if (State != "S") {
						 ComShowCodeMessage('EAS90056'); //Rejection notice Send - Fail!
						 ComOpenWait(false);
						 return false;
					 } else if (State == "S") {
						 var parentObj = window.dialogArguments;
						 var iNtcSeq = parentObj.document.form.ntc_his_seq.value;
						 if (iNtcSeq == "") iNtcSeq = 0;
						 iNtcSeq = parseInt(iNtcSeq) + 1;
						 ComSetObjValue(parentObj.document.form.ntc_his_seq, iNtcSeq);
						 parentObj.ComBtnEnable("btng_history"); // parent history 버튼 활성화
						 ComShowCodeMessage('EAS90055'); //Rejection notice has been sent.
					 }
					 ComOpenWait(false);
				break;
			
			}
		}
		
		/**
		* 화면 폼입력값에 대한 유효성검증 프로세스 처리
		*/
		function validateForm(sheetObj,frm,sAction){
			switch(sAction) {
			case "btng_send" : 
				if (frm.eac_eml_use_flg.checked == false && frm.eac_fax_use_flg.checked == false) {
					ComShowCodeMessage('EAS90054');
					return false;
				}

				if(frm.ntc_cc_rcv_eml.value !="" && !EasIsEmailAddr(frm.ntc_cc_rcv_eml.value)){
					// 메일주소를 확인하세요
					ComShowCodeMessage("EAS90074"); // E-mail address check
					frm.ntc_cc_rcv_eml.focus();
					return false;
				}
				
				if(frm.eac_eml_use_flg.checked && frm.eac_eml.value ==""){
					ComShowCodeMessage("EAS90074"); // E-mail address check
					return false;
				}
				if(frm.eac_fax_use_flg.checked && frm.eac_fax.value ==""){
					ComShowCodeMessage("EAS90080"); // fax number check 
					return false;
				}
				
				if(frm.eac_eml_use_flg.checked && sheetObj.CellValue(1,'usr_eml') ==""){
					ComShowCodeMessage("COM130201", "your email address in Personnel Config"); // Please input Mail Subject.
					return false;
				}
				
				if(frm.eac_eml_use_flg.checked && sheetObj.CellValue(1,'eml_subj_ctnt') ==""){
					ComShowCodeMessage("COM130201", "mail subject in EAC Registration (Rejection Notice Tab)"); // Please input Mail Subject.
					return false;
				}
				
				if(frm.eac_eml_use_flg.checked && sheetObj.CellValue(1,'eml_ctnt') ==""){
					ComShowCodeMessage("COM130201", "Body of mail in EAC Registration (Rejection Notice Tab)"); // Please input Mail Subject.
					return false;
				}
				
				break;
			}
			return true;
		}
		
		
		/**
		* Sheet1 의 OnSearchEnd 이벤트처리 <br>
		* @param  {object} sheetObj	필수	 Sheet Object
		* @param  {string} ErrMsg		필수 String
		* @return 없음
		* @version 2014.11.18
		*/ 
		function sheet1_OnSearchEnd(sheetObj, ErrMsg){
			   if(sheetObj.CellValue(1,'eac_eml_use_flg') == "Y"){
			    	frm.eac_eml_use_flg.checked =true
			    	if(sheetObj.CellValue(1,'vndr_eml') != ""){
			    		frm.eac_eml.value = "("+sheetObj.CellValue(1,'vndr_eml')+")";
			    	} 
			    	
			   }else{
			    	frm.eac_eml_use_flg.checked =false
			    	frm.eac_eml.value = "";
			    	
			   }
			    
			   if(sheetObj.CellValue(1,'eac_fax_use_flg') == "Y"){
			      frm.eac_fax_use_flg.checked =true
			      if(sheetObj.CellValue(1,'fax_no') != ""){
			         frm.eac_fax.value = "("+sheetObj.CellValue(1,'fax_no')+")";
			      } 
			   }else{
			      frm.eac_fax_use_flg.checked =false
			   }
			   
			   frm.ntc_cc_rcv_eml.value = sheetObj.CellValue(1,'ntc_cc_rcv_eml')
			   
			   initControl();
			   rdInit(rdObjects[0]);
			   rdView();
		}		
		
	/* 개발자 작업  끝 */