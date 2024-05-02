/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : esm_bkg_0004.js
*@FileTitle : Customer Advisory Body Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.01
*@LastModifier : Lee In Young
*@LastVersion : 1.0
* 2011.07.01 Lee In Young
* 1.0 Creation
===============================================================================
* History
* 2012.03.22 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
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
     * @class esm_bkg_0004 : esm_bkg_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0004() {
    	this.processButtonClick		= processButtonClick;
        this.setSheetObject         = setSheetObject;
    	this.loadPage 				= loadPage;
        this.initSheet              = initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;

    var opener = window.dialogArguments;
    
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          /*******************************************************/ 
         var shtCnt = 0;
         var sheet1 = sheetObjects[0];

         var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             	case "btn_retrieve":
             		if(validateForm(formObject, SEARCH)){
             			doActionIBSheet(formObject,SEARCH); 
             		}
             		 break;
				case "btn_save":
					formObject.btn_type.value = "save";
			        if(validateForm(formObject, MULTI)){
			        	doActionIBSheet(formObject,MULTI); 
			        }
		        	break;
				
	            case "btn_close":
	 	             self.close();
	     	         break;
	     	         
	            case "btn_attach":
	            	 attachDoc(true);
	     	         break;
	            case "btn_delete":
	            	 attachDoc(false);
	     	         break;     
	            case "btn_select":
	            	formObject.rmk_use_flg.value = "Y";
	            	formObject.btn_type.value = "select";
	            	if(validateForm(formObject, MULTI)){
			        	 doActionIBSheet(formObject,MULTI); 
			         }
	            	break;
	
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }

     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      * @param sheet_obj
      */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 콤보 Object를 comboObjects 배열에 등록
     * 
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }
    
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
  			initSheet(sheetObjects[i],i+1);
  			ComEndConfigSheet(sheetObjects[i]);
		}
        
    	var comboObjMaxLen = comboObjects.length;
    	for (i = 0; i < comboObjMaxLen; i++) {
    		// IBCombo 초기화
        	initCombo(comboObjects[i], i + 1);
    	}
        
        initControl();
        // 화면 로딩시 조회
        doActionIBSheet(document.form, SEARCH);
        document.form.pre_eml_subj_ctnt_seq.value = sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq");
        document.form.sel_seq.value = sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq");
        document.form.rmk_use_flg.value = "";
        document.form.search_type.value = "";        
        
        
     }

     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 배열에서 순번
      */
     function initControl() {
     	var formObject = document.form;

        axon_event.addListenerForm('keydown', 'obj_KeyEnter', formObject);
        axon_event.addListenerForm("blur", "form_onBlur", formObject);
        axon_event.addListenerForm ('change', 'obj_change',  document.form); //- change
    
     }
      
     function form_onBlur() {
//    	 var srcName = event.srcElement.getAttribute("name");
//    	 switch(srcName){
//  			case "ofc_cd":
//  				if( document.form.ofc_cd.value != "" ){
//	  				doActionIBSheet(document.form, SEARCH01);
//	  				
//	  				if( document.form.exist_ofc_cd_flg.value != "Y" ){
//		  				ComShowCodeMessage("BKG01107");
//		  				ComSetFocus(document.form.ofc_cd);
//	  				}
//  				}
//  				break;
//  		 }
  	}
      

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      * @param sheetObj
      * @param sheetNo
      */
     function initSheet(sheetObj,sheetNo){

         var cnt = 0;
         var sheetID = sheetObj.id;
         switch(sheetID) {
         	case "sheet1":      //sheet1
		         with (sheetObj) {
		             // 높이 설정
		             style.height = 220;
		             //전체 너비 설정
		             SheetWidth = mainTable.clientWidth;
		
		             //Host정보 설정[필수][HostIp, Port, PagePath]
		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		             //전체Merge 종류 [선택, Default msNone]
		             MergeSheet = msNone;
		
		             //전체Edit 허용 여부 [선택, Default false]
		             Editable = true;
		
		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		             InitRowInfo( 1, 1, 9, 50);
		
		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		             InitColumnInfo(11, 0, 0, true);
		
		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
		             InitHeadMode(true, true, true, true, false,false);
		             var HeadTitle = "|VVD|CRE DT|RMK|SUBJECT|DELT FLAG|rmk_use_flg|eml_subj_ctnt_seq|file_path_rmk|file_nm|file_desc";
		
		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		             InitHeadRow(0, HeadTitle, true);
		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
		             InitDataProperty(0, cnt++ , dtData,       		30,    	daCenter,  	false,    	"vvd",          	false,          "",       dfNone,   	0,     		false,      true);
					 InitDataProperty(0, cnt++ , dtData,		   	40,   	daCenter,   false,  	"cre_dt",		    false,  		"",    	  dfNone,		0,  		true,  		true);
		             InitDataProperty(0, cnt++ , dtData,      		200,    daCenter,  	false,    	"impt_ntc_rmk",     false,          "",       dfNone,     	0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		200,    daCenter,  	false,    	"eml_subj_ctnt",    false,          "",       dfNone,     	0,     		false,      true);
		             InitDataProperty(0, cnt++ , dtData,      		40,   	daCenter,  	false,   	"delt_flg",    		false,          "",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		40,   	daCenter,  	false,   	"rmk_use_flg",    	false,          "",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		40,   	daCenter,  	false,   	"eml_subj_ctnt_seq",false,          "",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		40,   	daCenter,  	false,   	"file_path_rmk",	false,          "",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		40,   	daCenter,  	false,   	"file_nm",			false,          "",       dfNone,     	0,     		true,       true);
		             InitDataProperty(0, cnt++ , dtData,      		40,   	daCenter,  	false,   	"file_desc",		false,          "",       dfNone,     	0,     		true,       true);
		         }
		         break;
         	case "sheet2":      //sheet1
		         with (sheetObj) {
		             // 높이 설정
		             style.height = 60;
		             //전체 너비 설정
		             SheetWidth = mainTable.clientWidth;
		
		             //Host정보 설정[필수][HostIp, Port, PagePath]
		             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		             //전체Merge 종류 [선택, Default msNone]
		             MergeSheet = msNone;
		
		             //전체Edit 허용 여부 [선택, Default false]
		             Editable = false;
		
		             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		             InitRowInfo( 1, 1, 9, 50);
		
		             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		             InitColumnInfo(3, 0, 0, true);
		
		             // 해더에서 처리할 수 있는 각종 기능을 설정한다
		             InitHeadMode(true, true, true, true, false,false);
		             var HeadTitle = "||";
		
		             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		             InitHeadRow(0, HeadTitle, true, true);
		             //데이터속성    [	ROW, COL,   DATATYPE,		WIDTH,  DATAALIGN, 	COLMERGE,   SAVENAME,   		KEYFIELD, 	CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
		             InitDataProperty(0, cnt++ , dtHidden,       	100,    daCenter,  	false,    	"file_sav_id",          	false,          "",       dfNone,   	0,     		false,      true);
					 InitDataProperty(0, cnt++ , dtData,		   	40,   	daLeft,   	false,  	"file_upld_nm",		    false,  		"",    	  dfNone,		0,  		true,  		true);
					 CountPosition = 4;
					 
		         }
		         break;  
         }
     }
         
       /** 
        * Sheet관련 프로세스 처리
        * @param formObj
        * @param sAction
        */
         function doActionIBSheet(formObj,sAction) {
             switch(sAction) {
             	
    			case SEARCH:    //조회
    				formObj.f_cmd.value = SEARCH;
					sheetObjects[0].DoSearch("ESM_BKG_0004GS.do", FormQueryString(formObj));
					
					formObj.f_cmd.value = SEARCH02;
					sheetObjects[1].DoSearch("ESM_BKG_0004GS.do", FormQueryString(formObj));
					
   					break;
    			
    			case MULTI:		// 저장
    				formObj.f_cmd.value = MULTI;
    				// Form Value => Sheet Value
    				sheetObjects[0].CellValue( 1, "impt_ntc_rmk") = formObj.impt_ntc_rmk.value;
    				sheetObjects[0].CellValue( 1, "eml_subj_ctnt") = formObj.eml_subj_ctnt.value;
    		 		sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq") = formObj.eml_subj_ctnt_seq.text;
    				sheetObjects[0].CellValue( 1, "rmk_use_flg") = formObj.rmk_use_flg.value;
    				sheetObjects[0].CellValue( 1, "file_path_rmk") = formObj.file_path_rmk.value;
    				sheetObjects[0].CellValue( 1, "file_desc") = formObj.file_desc.checked==true?'Y':'N';
    				
    				var sParam = FormQueryString(formObj);
                    sheetObjects[0].DoSave("ESM_BKG_0004GS.do", sParam, -1, false);

                    //부모 창에 ofc_cd / selected seq. 항목 설정
                    opener.document.form.ofc_cd.value = document.form.ofc_cd.value;
                    opener.document.form.sel_seq.value = document.form.sel_seq.value;
                    doActionIBSheet(formObj,SEARCH);
                    formObj.rmk_use_flg.value = "";
                    break;
                    
    			case SEARCH01:    //조회
					formObj.f_cmd.value = SEARCH01;
    				var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0004GS.do", FormQueryString(formObj));
					formObj.exist_ofc_cd_flg.value = ComGetEtcData(sXml,"existOfcCdFlg");
					break;
             }
         }

         /**
          * 화면 폼입력값에 대한 유효성검증 프로세스 처리
          * @param formObj
          * @param sAction 
          */
         function validateForm(formObj,sAction){
        	  switch(sAction) {
        	  	case SEARCH:      //조회
        	  		//DIR Code 체크
        	  		if(ComIsNull(formObj.dir_cd)){
        	  			ComShowCodeMessage("BKG00115");
        	  			ComSetFocus(formObj.dir_cd);
        	  			return false;
        	  		}
        	  	
        	  		//Office Code 체크1
	        	  	if( formObj.ofc_cd.value == "" ){
	    	  			ComShowCodeMessage("BKG00922");
						ComSetFocus(formObj.ofc_cd);
						return false;
	    	  		}
	        	  	
	        	  	//Office Code 체크2
	        	  	doActionIBSheet(document.form, SEARCH01);
	  				if( document.form.exist_ofc_cd_flg.value != "Y" ){
		  				ComShowCodeMessage("BKG01107");
		  				ComSetFocus(document.form.ofc_cd);
		  				return false;
	  				}
	  				
        	  		return true;
        	  		break;
        	  	case MULTI:      //저장
        	  		if(ComIsNull(formObj.dir_cd)){
        	  			ComShowCodeMessage("BKG00115");
        	  			ComSetFocus(formObj.dir_cd);
        	  			return false;
        	  		} else if (ComIsNull(formObj.eml_subj_ctnt)){
        	  			ComShowCodeMessage("BKG00104","Subject");
        	  			ComSetFocus(formObj.eml_subj_ctnt);
        	  			return false;
        	  		}
        	  		// Subject나 RMK의 변경이 있는지 체크
    				if(sheetObjects[0].CellValue( 1, "impt_ntc_rmk") == formObj.impt_ntc_rmk.value &&
    				   sheetObjects[0].CellValue( 1, "eml_subj_ctnt") == formObj.eml_subj_ctnt.value &&
//    				   sheetObjects[0].CellValue( 1, "rmk_use_flg") == formObj.rmk_use_flg.value &&
    				   sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq") == formObj.eml_subj_ctnt_seq.text &&
    				   sheetObjects[0].CellValue( 1, "file_path_rmk") == formObj.file_path_rmk.text &&
    				   //formObj.attach_doc_yn.value == "" &&
    				   formObj.btn_type.value == "save"){
    					ComShowCodeMessage("BKG00743");
    					ComSetFocus(formObj.impt_ntc_rmk);
    					formObj.rmk_use_flg.value = "";
    					return false;
    				}
        	  		
    				//Office Code 체크1
        	  		if( formObj.ofc_cd.value == "" ){
        	  			ComShowCodeMessage("BKG00922");
    					ComSetFocus(formObj.ofc_cd);
    					return false;
        	  		}
        	  		
        	  		//Office Code 체크2
	        	  	doActionIBSheet(document.form, SEARCH01);
	  				if( document.form.exist_ofc_cd_flg.value != "Y" ){
		  				ComShowCodeMessage("BKG01107");
		  				ComSetFocus(document.form.ofc_cd);
		  				return false;
	  				}
	  				
	  				if (document.form.btn_type.value == "save") {
	  					if(document.form.eml_subj_ctnt_seq.text == document.form.sel_seq.value){
	  						formObj.rmk_use_flg.value = "Y";
	  					}
	  				}
	  				
	  				// Save 가 되지 않은 템플릿 Select 시에 경고 메시지
	  		    	if (document.form.btn_type.value == "select") {
	  		    		
	  		    		if(sheetObjects[0].CellValue( 1, "impt_ntc_rmk") != formObj.impt_ntc_rmk.value ||
	  		    			sheetObjects[0].CellValue( 1, "eml_subj_ctnt") != formObj.eml_subj_ctnt.value){
	  	    					ComShowCodeMessage("BKG00178");
	  	    					ComSetFocus(formObj.impt_ntc_rmk);
	  	    					formObj.rmk_use_flg.value = "";
	  	    					return false;
	  	    			}
	  		    		
	  		    		if(document.form.eml_subj_ctnt_seq.text == document.form.sel_seq.value){
	  		    			ComShowCodeMessage("BKG02215");
	  		    			formObj.rmk_use_flg.value = "";
  	    					return false;
	  		    		}
	  		    		
	  		    	}
        	  		return true;
        	  		break;
        	  }
         }

     /**
 	 * 조회 완료후 실행
 	 * Fax,Email에서 공통으로 사용하는 Customer Name을 해당 시트에 셋팅.
 	 * @param sheetObj
 	 * @param ErrMsg
 	 */
 	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
 		
 		var formObject = document.form;
 	    var maxRow = sheetObj.LastRow;
 	    var cellValue = "";
 	    for(i=1;i <=maxRow ; i++){
 	    		
			formObject.cre_dt.value = sheetObj.CellValue( i, "cre_dt");
			formObject.impt_ntc_rmk.value = sheetObj.CellValue( i, "impt_ntc_rmk");
			formObject.eml_subj_ctnt.value = sheetObj.CellValue( i, "eml_subj_ctnt");
			formObject.delt_flg.value = sheetObj.CellValue( i, "delt_flg");
			formObject.file_path_rmk.value = sheetObj.CellValue( i, "file_path_rmk");
			
			if(sheetObj.CellValue( i, "file_desc") == 'Y')
				formObject.file_desc.checked = true;
			else
				formObject.file_desc.checked = false;
			
			if( document.form.file_path_rmk.value != "" ){
				//document.form.attach_doc_yn.value = "Y (Del)";
				setDisplayTp("DEL");
			} else {
				//document.form.attach_doc_yn.value = "";
				sheetObjects[1].RemoveAll();
				setDisplayTp("ATTACH");
			}
			
			if( document.form.keys.value != "" ){
				sheetObjects[0].RowStatus(i) = "U";
			}
			
			if( sheetObj.CellValue(i, "eml_subj_ctnt_seq") != '' ){
				document.form.eml_subj_ctnt_seq.Code = sheetObj.CellValue(i, "eml_subj_ctnt_seq");
			}
	    		
 	    }

 	    // 결과가 없는 경우
 	    if(formObject.cre_dt.value == ""){
 	    	if(formObject.search_type.value == 'parents'){
 	    		document.form.eml_subj_ctnt_seq.Code = "1";
 	    	}
 	    	ComShowCodeMessage("BKG03055");
 	    	return false;
 	    }
 	   
 	    // 처음에 팝업으로 호출될 때는 현재 선택되어있는 값을 조회하지만 
 	    // 그 이후 콤보박스에서 선택된 seq 의 값을 보여주기 위해 플래그 Null 로 변경
 	    formObject.rmk_use_flg.value = "";
 	}
 	
 	
 	
 	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
 		with (sheetObj) {
 			var color1 = RgbColor(129, 0, 129);
 			ColFontUnderline("file_upld_nm") = true;
 			DataLinkMouse("file_upld_nm") = true;
 			ColFontColor("file_upld_nm") = color1;
 		}
 	}
 	
 	
 	function sheet2_OnMouseDown(Button, Shift, X, Y) {
 		var sheetObj = sheetObjects[1];
 		var m_row = sheetObj.MouseRow;
 		var m_col = sheetObj.MouseCol;

 		try {
 			if (m_col == 2 && sheetObj.RowCount > 0) {
 				
 				// 파일이 존재시 다운로드 받는다.
 				var key_id = sheetObj.CellValue(m_row, "file_sav_id"); 				
 				var exist = fnSaveFileExist(key_id , sheetObj);		
 				
 				// 서버에 파일존재유무확인 
 				if(eval(exist)){ 					
 					hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;

 				}else{
 					ComShowMessage(ComGetMsg("BKG08127"));
 				}
 			}
 		} catch (ex) {
 			return false;
 		}
 	}
 	/**
 	 * 파일존재유무판단  
 	 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 	 * param :file_id
 	 * return :boolean
 	 */
 	function fnSaveFileExist(file_id,sheetObj) {
 		var formObj = document.form;
 		var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
 		var output_text = ComGetEtcData(sXml, "output_text");
 		return output_text;
 	}
 	
 	
 	
 	/**
  	 * File Attach
  	 * E-Mail에서 파일 첨부하고자 하는 파일 업로드 기능 세팅 
  	 * @param attachFlg
  	 */
 	function attachDoc(attachFlg){
  		var idx = 0;
  		var formObject = document.form;
  		
 		if( attachFlg == true ){ //파일 첨부
 			var returnValue = openUpload("BKG");
 			
            if( returnValue != undefined && returnValue != "" ){
                //document.form.attach_doc_yn.value = "Y (Del)";
                setDisplayTp("DEL");
                document.form.keys.value = returnValue; 
                document.form.file_path_rmk.value = returnValue;
                for( idx = 0+parseInt(sheetObjects[0].HeaderRows); idx < sheetObjects[0].RowCount+parseInt(opener.sheetObjects[0].HeaderRows); idx++ ){
                	sheetObjects[0].RowStatus(idx) = "U";
                }
                
                formObject.f_cmd.value = SEARCH02;
				sheetObjects[1].DoSearch("ESM_BKG_0004GS.do", FormQueryString(formObject));
                
            }
            
            //부모 창에 File Attach 항목 설정
//            for( idx = 0+parseInt(opener.sheetObjects[0].HeaderRows); idx < opener.sheetObjects[0].RowCount+parseInt(opener.sheetObjects[0].HeaderRows); idx++ ){
//           	 opener.sheetObjects[0].CellValue2( idx, "file_key") = document.form.keys.value;
//            }
 		} else{ //파일 첨부 삭제
 			//document.form.attach_doc_yn.value = "";
 	        document.form.keys.value = "";
 	        document.form.file_path_rmk.value = "";
 	        sheetObjects[1].RemoveAll(); 	        
 	        setDisplayTp("ATTACH");
 	        
 	        //부모 창에 File Attach 항목 설정
// 	        var idx = 0;
// 	        for( idx = 0+parseInt(opener.sheetObjects[0].HeaderRows); idx < opener.sheetObjects[0].RowCount+parseInt(opener.sheetObjects[0].HeaderRows); idx++ ){
// 	        	opener.sheetObjects[0].CellValue2( idx, "file_key") = document.form.keys.value;
// 	        }
 		}
 	}
 	
 	
 	/**
 	 * Combo Object 초기화
 	 * 
 	 * @param comboObj
 	 * @param comNo
 	 * @return
 	 */
 	function initCombo(comboObj, comNo) {

 		// alert("comboObj ID : " + comboObj.id);
 		var i = 0;

 		switch (comboObj.id) {
 			case "eml_subj_ctnt_seq": {
 				i = 0;
 		
 				with (comboObj) {
 					InsertItem(i++, "1", "1");
 					InsertItem(i++, "2", "2");
 					InsertItem(i++, "3", "3");
 					InsertItem(i++, "4", "4");
 					InsertItem(i++, "5", "5");
 					InsertItem(i++, "6", "6");
 					InsertItem(i++, "7", "7");
 					InsertItem(i++, "8", "8");
 					InsertItem(i++, "9", "9");
 					InsertItem(i++, "10", "10");
 					InsertItem(i++, "11", "11");
 					InsertItem(i++, "12", "12");
 					InsertItem(i++, "13", "13");
 					InsertItem(i++, "14", "14");
 					InsertItem(i++, "15", "15");
 					InsertItem(i++, "16", "16");
 					InsertItem(i++, "17", "17");
 					InsertItem(i++, "18", "18");
 					InsertItem(i++, "19", "19");
 					InsertItem(i++, "20", "20");
 				}
 				break;
 			}
 		} // end switch
 	}

 	
 	/**
     * 시퀀스 리스트 콤보 변경시 이벤트
     * @param comboObj
     * @param value
     * @param text
     * @return
     */
    function eml_subj_ctnt_seq_OnChange(comboObj,value,text) {
    	var formObj = document.form;
    	if(formObj.search_type.value != 'parents'){
    		sheetObjects[1].RemoveAll();
    		formObj.f_cmd.value = SEARCH;
    		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0004GS.do", FormQueryString(formObj));
    		sheetObjects[0].LoadSearchXml(sXml);
    		
    		formObj.f_cmd.value = SEARCH02;
			sheetObjects[1].DoSearch("ESM_BKG_0004GS.do", FormQueryString(formObj));
    		
    	}
    }
    
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function obj_change() {
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	if (srcName == "ofc_cd") {
    		formObj.search_type.value = "parents";
    		formObj.rmk_use_flg.value = "Y";
    		formObj.eml_subj_ctnt_seq.Code = "";
    		
    		formObj.f_cmd.value = SEARCH;
    		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0004GS.do", FormQueryString(formObj));
    		sheetObjects[0].LoadSearchXml(sXml);
    		
    		formObj.sel_seq.value = sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq");
    		formObj.pre_eml_subj_ctnt_seq.value = sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq");
    		formObj.rmk_use_flg.value = "";
    		formObj.search_type.value = "";
    	}
    	
    	if (srcName == "impt_ntc_rmk") {
//    		validateCols('', '92', formObj.impt_ntc_rmk, 'Remark');
    		validateLen('', '92', formObj.impt_ntc_rmk, 'Remark');
    	}
    }
    
    function obj_KeyEnter() {
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	if (event.keyCode == 13 && srcName == "ofc_cd"){
    		ComSetFocus(document.form.eml_subj_ctnt);
    	}
    }
    
    
    /**
     * Select 후 현재 Seq. 값 재설정
     * @param sheetObj
     * @param errMessage
     */
    function sheet1_OnSaveEnd(sheetObj,errMessage){
    	var formObj = document.form;
    	if (formObj.btn_type.value == "select") {
    		formObj.sel_seq.value = sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq");
    		formObj.pre_eml_subj_ctnt_seq.value = sheetObjects[0].CellValue( 1, "eml_subj_ctnt_seq");
    	}
    	formObj.rmk_use_flg.value = "";
    }
    
    
    function setDisplayTp(displayTp){
    	if(displayTp == "DEL"){
        	document.getElementById("attach_button").style.display="none";
    	    document.getElementById("delete_button").style.display="block";    		
    	}else{
        	document.getElementById("attach_button").style.display="block";
    	    document.getElementById("delete_button").style.display="none";
    		
    	}
    }
    
    /*
     * TextArea 글자수,Row수 제한 Validation 체크
     * @param rows : 최대Row수
     * @param cols : 한Row에 표시될 최대글자수
     * @param obj : Textarea Object
     * @author 김병규
     * @version 2009.09.01
     */
      function validateLen(rows, cols, obj, custTp){
          var str       = obj.value;
          var displayText;
          var parseCols = parseInt(cols);
          var rowArr = str.split("\n");

          for(var i =0 ; i < rowArr.length ; i++){
              if(countLineBreaks(rowArr[i]) > 0){
                  if(rowArr[i].length > parseCols+1){
                      var loopCnt;
                      if(rowArr[i].length%parseCols > 0){
                          loopCnt = rowArr[i].length/parseCols + 1;
                      }else{
                          loopCnt = rowArr[i].length/parseCols;
                      }
                      for(var j = 0 ; j < Math.floor(loopCnt) ; j++){
                          if(i < 1){
                              if(j < 1){
                                  displayText = rowArr[i].substring(0,parseCols*(j+1));
                              }else{
                                  displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                              }
                          }else{
                              displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                          }
                      }
                      if(countLineBreaks(displayText) > 0){
                          displayText = displayText.substring(0,displayText.length-1);
                      }
                  }else{
                      if(i < 1){
                          displayText = rowArr[i];
                      }else{
                          displayText = displayText + "\n" + rowArr[i];
                      }
                  }
              }else{
                  if(rowArr[i].length > parseCols){
                      var loopCnt;
                      if(rowArr[i].length%parseCols > 0){
                          loopCnt = rowArr[i].length/parseCols + 1;
                      }else{
                          loopCnt = rowArr[i].length/parseCols;
                      }
                      for(var j = 0 ; j < Math.floor(loopCnt) ; j++){
                          if(i < 1){
                              if(j < 1){
                                  displayText = rowArr[i].substring(0,parseCols*(j+1));
                              }else{
                                  displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                              }
                          }else{
                              displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                          }
                      }
                  }else{
                      if(i < 1){
                          displayText = rowArr[i];
                      }else{
                          displayText = displayText + "\n" + rowArr[i];
                      }
                  }
              }
          }

          obj.value = displayText;
          return true;
      }

	/* 개발자 작업  끝 */
     