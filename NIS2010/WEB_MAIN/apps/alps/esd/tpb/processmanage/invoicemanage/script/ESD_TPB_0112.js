/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0112.js
*@FileTitle : Invoice Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-05
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.1
* 2008-09-12 O Wan-Ki 1.0 최초 생성
* 2009-10-05 Park Sung-Jin 1.1 ALPS Migration 작업
* 2013-07-23 CHM-201325643 [ALPS 데이터품질 - TPB validation 로직보완] 7월 대상 건에 대한 진행 요청 건
* 2015-02-26 KIM HYUN HWA[CHM-201534232] Email 입력 가능하도록 수정.
* 2015-10-19 KIM HYUN HWA[CHM-201538459] Fax 기능 Combo box에서 제거
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI01=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESD_TPB_0112 : ESD_TPB_0112 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0112() {
    	this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.setTabObject           = setTabObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;        
        this.initControl            = initControl;
        this.initTab                = initTab;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
    
   	/* 개발자 작업	*/
   	// 공통전역변수
	
	var curTab = 1;
	var beforetab = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0 ;
	
	// RD
	var rdObjects = new Array();
	var rdCnt = 0;
	
	var intervalId = "";
	
	/**
	 * IBSheet Object를 배열로 등록
	 * ComSheetObject(id)에서 호출한다
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
	
	/**
	 * Sheet 기본 설정 및 초기화 
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		//RD
		initRdConfig(rdObjects[0]);
		rdOpen(rdObjects[0], document.form);

		//Sheet
		for(i=0;i<sheetObjects.length;i++){
		   //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

        for(p=0;p< comboObjects.length;p++){
            initCombo(comboObjects[p],p+1);
        }

		try {
			document.form.s_n3pty_inv_if_tp_cd.onchange = s_n3pty_inv_if_tp_cd_OnChange;
		} catch(e){}
		var optionItem = document.getElementById("s_n3pty_inv_if_tp_cd");
		//MICROSOFT(US-071995) 인 경우 EDI 전송기능사용.
		//AMAZON(SC_NO:'AEN002016') EDI 기능 추가   CA-011597,US-083405 ,US-085445, US-085447, US-085449, US-085450, US-085596
		var edi_flag ="N";
		if(document.form.snd_edi_cd.value == "US071995" ){
			document.form.receiver_id.value  = "MCRSHJSC"; 
			edi_flag ="Y" ;
		}
		
		if(  document.form.snd_edi_cd.value == "CA011597" || document.form.snd_edi_cd.value == "CA11597"
		   ||document.form.snd_edi_cd.value == "US083405" || document.form.snd_edi_cd.value == "US83405"
		   ||document.form.snd_edi_cd.value == "US085445" || document.form.snd_edi_cd.value == "US85445"
		   ||document.form.snd_edi_cd.value == "US085447" || document.form.snd_edi_cd.value == "US85447"
		   ||document.form.snd_edi_cd.value == "US085449" || document.form.snd_edi_cd.value == "US85449"
		   ||document.form.snd_edi_cd.value == "US085450" || document.form.snd_edi_cd.value == "US85450"
		   ||document.form.snd_edi_cd.value == "US085596" || document.form.snd_edi_cd.value == "US85596" ){
			document.form.receiver_id.value  = "AMAZON";
			edi_flag ="Y" ;
		}

		if(edi_flag =="N"){
			if(optionItem.length>4) {
		       optionItem.remove(4);
			}
		}
		
        // Fax 기능 제거. 2015-10-08 
		  optionItem.remove(3);
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 280;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "result1|result2";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,       70,     daCenter, false,  "ibflag",        false,          "",    dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,       70,     daCenter, false,    "dummy",        false,          "",    dfNone,    0,     false,       true);

					DataInsert();
				}
				break;
		}
	}

    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initCombo (comboObj, comboNo) {

        switch(comboNo) {
            case 1:
               with (comboObj) {
				   Enable = false;
				   SetTitle("E-Mail Address|Available");
				   SetColWidth("200|100");
				   ItemHeight = 7;
				   DropHeight = 150;
				   DisabledBackColor = "#EEEEEE";
				   SetColAlign("left|center");
	    	   }
               break;
         }
    }
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	function processButtonClick(){

		var sheetObject = sheetObjects[curTab-1];
        var rdObject = rdObjects[0] ;
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			// form 이름에 주의하시기 바랍니다. 

				switch (srcName) {
					// 버튼 이름으로 case를 넣어 주셔야 합니다. 
//					case "btn_printN" :
//						doActionIBSheet(sheetObject,formObject,MODIFY);
//						break;
//					case "btn_printY" :
//						ComShowCodeMessage("TPB90010","Issue ","","");
//						return;
//						break;
					case "btn_issue" :
					    // 테스트 환경에서만 
//				        var s_n3pty_inv_if_tp_cd = document.all.s_n3pty_inv_if_tp_cd.value;
//				        // ComShowMessage(document.all.s_n3pty_inv_if_tp_cd.value);
//					    if (s_n3pty_inv_if_tp_cd=="E"||s_n3pty_inv_if_tp_cd=="F"){
//                            ComShowMessage("It can not be issued by FAX/E-Mail!!! (TEST Environment)");
//					        return;
//					    }
					    var val = document.form.s_n3pty_inv_if_tp_cd.value;
		
					    if (val=="T"){
							doActionIBSheet(sheetObject,formObject,MULTI01);
					    }else{
					    	
					    	//CHM-201325643 [ALPS 데이터품질 - TPB validation 로직보완] 7월 대상 건에 대한 진행 요청 건
					    	if ( val=="E" ){	
						    	//if(formObject.combo1.Text != ""  && !ComIsEmailAddr(formObject.combo1.Text)){
							   	if((formObject.combo1.Text != ""  && !ComIsEmailAddr(formObject.combo1.Text)) || formObject.s_contact_info.value == "" ){
						    		ComShowCodeMessage("TPB90028");
					                return;
						    	}
					    	}
				    	
					    	doActionIBSheet(sheetObject,formObject,MODIFY);		
							
					    }
						break;
					case "btn_print_only" :
						rdObject.PrintDialog();
						break;
					case "btn_erpInterface" :
						if( ComShowConfirm(ComGetMsg("TPB90008","","","")) ){	
							doActionIBSheet(sheetObject,formObject,ADD);
						}					
					    break;
					case "btn_first" :
						First_OnClick();
						break;
					case "btn_back" :
						Prev_OnClick();
						break;
					case "btn_next" :
						Next_OnClick();
						break;
					case "btn_last" :
						Last_OnClick();
						break;
					case "btn_zoomIn" :
						ZoomIn_OnClick();
						break;
					case "btn_zoomOut" :
						ZoomOut_OnClick();
						break;

					case "btn_load_id":
						var bkg_no =  'ZHO600287500' //formObject.bkg_no.value;
						
						var url = "ESM_BKG_0367_01.do?func=callbackPOOtherNo&popUpTpCd=B&bkg_no=" + bkg_no +"&ca_flg= N";
						ComOpenWindow(url, "ESM_BKG_0367_01", "dialogWidth:800px;dialogHeight:520px", true);
					break;	
						
	    
				} // end switch

		} catch(e) {
			if( e = "[object Error]") {
				ComShowCodeMessage('COM12111');
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case MODIFY:		//저장
//				if(document.all.btn_print.disabled){
//					ComShowCodeMessage("TPB90010","Issue ","","");
//					return;
//				}
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if( !ComShowConfirm(ComGetMsg("COM12147","Issue","","")) ){
					return;
				}
//				document.all.btn_print.disabled = true;
				
				formObj.f_cmd.value = MODIFY;
				sheetObj.DoSave("ESD_TPB_0112GS.do", tpbFrmQryStr(formObj),"ibflag",false);
//				document.all.btn_print.style.display = "none"; /// Added In 2008-01-04
				break;
			case MULTI01:				 //Transmit
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				if( !ComShowConfirm(ComGetMsg("COM12147","Issue","","")) ){
					return;
				}				
				
				formObj.f_cmd.value = MULTI01;

				var sXml = sheetObj.GetSearchXml("ESD_TPB_0112GS.do", FormQueryString(formObj));
				//var sXml = sheetObj.DoSave("ESD_TPB_0112GS.do", tpbFrmQryStr(formObj));
				var key = ComGetEtcData(sXml, "KEY");

				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);	
				
				break;
			case ADD:		//ERP
			
				formObj.f_cmd.value = ADD;
				div_processing_show(); // show processing image
				sheetObj.DoSave("ESD_TPB_0112GS.do", tpbFrmQryStr(formObj),"ibflag",false);
				div_processing_hide(); // hide processing image
				break;
		}
	}
	
    
    /**
     * BackEndJob 실행결과조회.
     */
    function doActionValidationResult(sheetObj, sKey) {

    	var sXml = sheetObj.GetSearchXml("ESD_TPB_0112GS.do?f_cmd=" + SEARCH01 + "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");


    	// 에러가 발생했을 경우 대기사항을 종료한다.
    	if (!ComTpbErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 성공메시지 보여주고
    		ComShowCodeMessage('TPB00079');	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComResultMessage(sXml));
    	}

    }	
     
     /**
      * 반환받은 XML이 에러일 경우 SheetObj에 메시지를 보내고, false를 반환한다.
      * @author Park Mangeon
      * @param SheetObj
      * @param xmlStr
      * @return
      */
       function ComTpbErrMessage(SheetObj, xmlStr){
          if(xmlStr == null  || xmlStr == "" ) return true;
          try {
            var vPrefix = xmlStr.substring(1,6);

             if (vPrefix == "ERROR") {
              SheetObj.LoadSearchXml(xmlStr);
              return false;
             } else {
              return true;
             }

          } catch(err) { ComFuncErrMsg(err.message); }
       }

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		ComEtcDataToForm(document.form, sheetObj);
		if(errMsg==null || errMsg == ''){
			var s_clt_agn_flg = sheetObj.EtcData("s_clt_agn_flg");
			var s_n3pty_inv_sts_cd = sheetObj.EtcData("s_n3pty_inv_sts_cd");
			var s_issue_yn = sheetObj.EtcData("s_issue_yn");
			var s_erpif_yn = sheetObj.EtcData("s_erpif_yn");
//alert("s_issue_yn==>"+s_issue_yn);
//alert("s_erpif_yn==>"+s_erpif_yn);
			// ERP I/F 되었을 경우는 버튼 disable
			if(s_erpif_yn != 'Y'){
//				ComShowCodeMessage('COM12149','ERP Interface','','');
				//document.getElementById('btn_erpInterface_t').style.display = 'none';
	  			document.all.btn_erpif_left.style.display = "none";
	  		    document.all.btn_erpif.style.display = "none";
	  		    document.all.btn_erpif_right.style.display = "none";
			} 

          // ISSUE 되었을 경우는 버튼 disable
			if(s_issue_yn != 'Y'){
				//document.getElementById('btn_issue_t').style.display = 'none';
	  			document.all.btn_issue_left.style.display = "none";
	  		    document.all.btn_issue.style.display = "none";
	  		    document.all.btn_issue_right.style.display = "none";
			} 
			
			if ( document.all.f_cmd.value == ADD ) {
				//document.getElementById('btn_erpInterface_t').style.display = 'none';
	  			document.all.btn_erpif_left.style.display = "none";
	  		    document.all.btn_erpif.style.display = "none";
	  		    document.all.btn_erpif_right.style.display = "none";
				ComShowCodeMessage('COM12149','ERP Interface','','');
			}
            // ISSUE 되었을 경우
			else if ( document.all.f_cmd.value == MODIFY ) {
				//document.getElementById('btn_issue_t').style.display = 'none';
	  			document.all.btn_issue_left.style.display = "none";
	  		    document.all.btn_issue.style.display = "none";
	  		    document.all.btn_issue_right.style.display = "none";
				ComShowCodeMessage('COM12149','Issue Type','','');
				
				// hard copy 
				if(document.form.s_n3pty_inv_if_tp_cd.value == 'H'){
					rdObjects[0].PrintDialog();
				}
			}
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(!ComChkValid(formObj)) return false;

			/// contact info check
			var n3pty_inv_if_tp_cd = formObj.s_n3pty_inv_if_tp_cd.value;
			var contact_info = formObj.s_contact_info.value;
			if ( ComTrim(contact_info).length == 0 ){
				if( n3pty_inv_if_tp_cd=="E" ) {
					ComShowCodeMessage("TPB90028");
					return false;
				} else if ( n3pty_inv_if_tp_cd=="F" ) {
					ComShowCodeMessage("TPB90027");
					return false; 
				}
			}
			
			formObj.s_n3pty_inv_if_tp_nm.value 
				= formObj.s_n3pty_inv_if_tp_cd.options[formObj.s_n3pty_inv_if_tp_cd.selectedIndex].text;
		}
		
		return true;
	}
	
	/**
	 * s_n3pty_inv_if_tp_cd onchange 이벤트 
	 */
	function s_n3pty_inv_if_tp_cd_OnChange(){
		var val = document.form.s_n3pty_inv_if_tp_cd.value;
		// ComShowMessage(val);
		if ( val=='E' ){
			document.getElementById("comboset1").style.display = "block";
			document.getElementById("comboset2").style.display = "none";
			getEmailContactPoint();
			comboObjects[0].Enable = true;
			comboObjects[0].UseEdit = true;
		} else if ( val=='F' ){
			document.getElementById("comboset1").style.display = "block";
			document.getElementById("comboset2").style.display = "none";
			// Fax 기능 사용 안함. 
			//getFaxContactPoint();
			comboObjects[0].Enable = true;
			comboObjects[0].UseEdit = true;
		}  else if ( val=='T' ){
			document.getElementById("comboset1").style.display = "none";
			document.getElementById("comboset2").style.display = "block";
			getEdiContactPoint();
			comboObjects[0].Enable = true;
			comboObjects[0].UseEdit = false;
		} else {
			document.getElementById("comboset1").style.display = "block";
			document.getElementById("comboset2").style.display = "none";
			document.form.s_contact_info.value = "";
			comboObjects[0].Enable = false;
			comboObjects[0].RemoveAll();
		}
	}

	/*
	 * Email선택시 Combo처리 
	 */	
	function getEmailContactPoint(){
		var comboObj = comboObjects[0];
		comboObj.RemoveAll();
		comboObj.SetTitle("E-Mail Address|Avaiable");
		// comboObj.SetColWidth("200|100");
	
		var idx = 0;

		comboObj.InsertItem(idx++, "<<Select>>|","0" );
		for(var i=0;i<emailRnArr.length;i++){ // emailRnArr  emailCntcInfoArr  emailValidYnArr  
			comboObj.InsertItem(idx++, emailCntcInfoArr[i]+"|"+emailValidYnArr[i], emailCntcInfoArr[i]);
		}
		comboObj.Code = "0";
	}	

	/*
	 * Fax선택시 Combo처리 
	 */	
	function getFaxContactPoint(){
		var comboObj = comboObjects[0];
		comboObj.RemoveAll();
		comboObj.SetTitle("Fax No.|Avaiable");
		// comboObj.SetColWidth("200|100");

		var idx = 0;

		comboObj.InsertItem(idx++, "<<Select>>|","0" );
		for(var i=0;i<faxnoRnArr.length;i++){ // emailRnArr  emailCntcInfoArr  emailValidYnArr  
			comboObj.InsertItem(idx++, faxnoCntcInfoArr[i]+"|"+faxnoValidYnArr[i], faxnoRnArr[i]);
		}
		comboObj.Code = "0";
	}	

		/*
		 * edi선택시 Combo처리 
		 */	
		function getEdiContactPoint(){
			var comboObj = comboObjects[1];
			comboObj.RemoveAll();
//			comboObj.InsertItem(0, "<<Select>>","0" );
			comboObj.InsertItem(0, "New", "N");
			comboObj.InsertItem(1, "Update", "U");
			comboObj.InsertItem(2, "Cancelled", "C")
			comboObj.Index="0";

		}	
	/*
	 * combo1 OnChange 이벤트 처리 
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		// ComShowMessage(Text + " / " + Index_Code );
		document.form.s_contact_info.value = ""; 
		if ( Index_Code != "0" ){
			if ( comboObj.GetText(Index_Code, 1) == "Yes" ) {
				// document.form.s_contact_info.value = Text; 
				document.form.s_contact_info.value = comboObj.GetText(Index_Code, 0);
			} else {
				var val = document.form.s_n3pty_inv_if_tp_cd.value;
				var eval = document.form.combo1.Text ;
				if ( val == "E" ){
					
					  if(ComIsEmailAddr(eval)){
					     document.form.s_contact_info.value = document.form.combo1.Text;
					  }else{
					   ComShowCodeMessage("TPB90028");
					  }
				} else if (val == "F"){
					//alert(" "+eval.length);
					if(eval.length > 6 ){
						document.form.s_contact_info.value = document.form.combo1.Text;
					}else{
					   ComShowCodeMessage("TPB90027");
				    }
				}
			}
		}
	}
	
	// show processing image 
    function div_processing_show(){
    	document.all.div_processing.style.display = ''; 
    	// setTimeout("div_processing_hide();", 1000);
    }
    
	// hide processing image 
    function div_processing_hide(){
    	document.all.div_processing.style.display = 'none'; 
    }	
    

	function initRdConfig(rdObject){

	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = true;
		// Rdviewer.HideToolbar(); // show tool bar ... In 2008-09-12

        // Added Option  ... In 2008-09-12
    	Rdviewer.SetSaveDialogEx("", "", "pdf", "pdf");
    	Rdviewer.DisableToolbar(13);
    	Rdviewer.DisableToolbar(14);
    	Rdviewer.DisableToolbar(16);
    	Rdviewer.DisableToolbar(17);

		Rdviewer.HideStatusbar();
		Rdviewer.ViewShowMode(2);

		Rdviewer.setbackgroundcolor(255,255,255);
		Rdviewer.SetPageLineColor(255,255,255);
	}

	function rdOpen(rdObject,formObject) {
		
	    var Rdviewer = rdObject ;

		var s_bil_loc = formObject.s_bil_loc.value;
		var s_his_seq = formObject.s_his_seq.value;
		if (s_bil_loc == '') s_bil_loc = "L";
		if (s_his_seq =='') s_his_seq = formObject.s_n3pty_inv_his_seq.value;
	    var rdParam = "/rp [" + formObject.s_n3pty_inv_no.value + "] " +		//$1
						  "[" + formObject.s_dao_n3pty_bil_tp_cd.value + "] " +	//$2
						  "[" + s_bil_loc + "] " +   						    //$3
						  "[" + s_his_seq + "] " +   							//$4
						  "[Y]";
//						  "/rfonttype60";   		
	    //alert("rdParam====>"+rdParam);

	    //var rdParam = "/rp [PUS091TR001] [CD] [L] [1] [Y]"
        //prompt('', rdParam);

		//배율
		//Rdviewer.AutoAdjust = false;
		//Rdviewer.ZoomRatio = 130;

		//if(s_his_seq == ""){
		//	Rdviewer.FileOpen( RD_path + "apps/alps/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112Form.mrd", RDServer + rdParam);
		//}else{
			Rdviewer.FileOpen( RD_path + "apps/alps/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112.mrd", RDServer + rdParam);
	        //Rdviewer.FileOpen( "http://127.0.0.1:7001/hanjin/apps/alps/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112.mrd", RDServer + rdParam);
			//Rdviewer.FileOpen( "http://localhost:7001/hanjin/" + "apps/alps/esd/tpb/processmanage/invoicemanage/report/REP_ESD_TPB_0112.mrd", RDServer + rdParam);
		//}
		
	}


//---------- RD Control 관련 버튼--------------------------------

	function Save_OnClick() {
		rdObjects[0].SaveAsDialog();
	}

	function Print_OnClick() {
		rdObjects[0].PrintDialog();
	}

	function First_OnClick() {
		rdObjects[0].FirstPage();
	}

	function Prev_OnClick() {
		rdObjects[0].PrevPage();
	}

	function Next_OnClick() {
		var p = rdObjects[0].NextPage();
	}

	function Last_OnClick() {
		rdObjects[0].LastPage();
	}

	function ZoomIn_OnClick() {
		rdObjects[0].ZoomIn();
	}

	function ZoomOut_OnClick() {
		rdObjects[0].ZoomOut();
	}

	function Close_OnClick() {
		window.close();
	}

//---------- RD Control 관련 버튼--------------------------------

    /**
     * 결과 XML로 부터 MESSAGE를 추출하는 함수.
     *
     * @param 결과XML <br>
     * @returns String <br>
     * @author 김영출
     */
  function ComResultMessage(xmlStr){
        if (xmlStr == null || xmlStr == '') return '';

        var xValue = '';
          try {
              /* XML Parsing */
              var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
              xmlDoc.async = "false";
              xmlDoc.loadXML(xmlStr);
              /* get message */
              //xValue = xmlDoc.documentElement.getElementsByTagName("MESSAGE").item(0).text
              var el_messages = xmlDoc.documentElement.getElementsByTagName("MESSAGE");
              if(el_messages != null && el_messages.length > 0) {
                xValue = el_messages.item(0).text;
              }else{
                xValue = '';
              }
          } catch(err) {
              xValue = err.message;
          }
        return xValue;
  }
	/* 개발자 작업  끝 */