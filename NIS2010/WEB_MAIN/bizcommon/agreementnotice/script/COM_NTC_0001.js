/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COM_NTC_0001.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.01.27 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================
* History
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
     * @class COM_NTC_0001 : COM_NTC_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function COM_NTC_0001() {
    	this.processButtonClick			= tprocessButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initControl           		= initControl;
    	this.doActionIBSheet 			= doActionIBSheet;
    	this.validateForm 				= validateForm;
    	this.searchTariffCodeName     	= searchTariffCodeName;
        this.sheet1_OnChange 			= sheet1_OnChange;
        this.initControl                = initControl;
    }
    
   	/* 개발자 작업	*/

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

    // Text입력시 영문을 제외하고 허용가능한 character
    var NOT_INPUT_KOR = "01234567890 !@#$%^&*()-=\\_+|[]{},.<>/?;':`~\"\r\n\t";
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @return 없음
     * @author 서미진
     * @version 2010.10.13
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];       
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				case "btn_save": // save
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
				case "btn_retrieve": //조회
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
		
	            case "btn_down_excel":    
	            	doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
	                break;
					
				case "btn_rowadd": //row Add 
	                doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
					
				case "btn_rowdelete": //row delete
					doActionIBSheet(sheetObject1, formObject, IBDELETE);					
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
    * IBCOMBO를 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo의 순번
    * @return 없음
    * @author 서미진
    * @version 2010.10.13
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "ofc_tp_cd":
	            var i = 0;
	            with (comboObj) {
	                DropHeight = 100;
	                UseAutoComplete = true;
	                InsertItem(i++, "ALL", "ALL");
	            }
	            break;    

	    }
	}


  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
    * @author 서미진
    * @version 2010.10.13
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
    * @author 서미진
    * @version 2010.10.13
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}	
 

   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 서미진
    * @version 2010.10.13
    */
	function loadPage() {
		var formObj = document.form;
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);	
		}
	    // combo
	    doActionIBSheet(sheetObjects[0],formObj,SEARCH01);
	    doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    comboObjects[1].Index = 0;
	}

	function conv_job_cd_seq(seq){
		var retval = '';
		if (seq == '1'){
			retval = seq + 'st';
		} else if (seq == '2'){
			retval = seq + 'nd';
		} else if (seq == '3'){
			retval = seq + 'rd';
		} else {
			retval = seq + 'th';
		}
		return retval; 
	}
	
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 서미진
     * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
     	case "sheet1":
     		with (sheetObj) {
                 // 높이 설정
                 style.height = 400;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 100, 100);

//                 var HeadTitle = "ibflag|Chk|System|Office Level|Contract Office|Agreement No.|agmt_mapg_no|User1|User1|Job Code|User2|User2|Job Code|User3|User3|Job Code|User4|User4|Job Code|User5|User5|Job Code|User6|User6|Job Code|User7|User7|Job Code|Contract\nUpdate User|root_pgm_no|Job Code1|Job Code2|Job Code3|Job Code4|Job Code5|Job Code6|Job Code7";
                 var HeadTitle = "ibflag|Chk|System|Office Level|Contract Office|Agreement No.|agmt_mapg_no";
                 for (var i=1; i<=usr_max_knt; i++){
                	 HeadTitle = HeadTitle + "|User"+i+"|User"+i+"|Job Code";
                 }
                 HeadTitle = HeadTitle + "|Contract\nUpdate User|root_pgm_no";
                 for (var i=1; i<=usr_max_knt; i++){
                	 HeadTitle = HeadTitle + "|Job Code"+i;
                 }
                 HeadTitle = HeadTitle + "|ntc_usr_id_list_ctnt|ntc_usr_id_jb_cd_list_ctnt";
                 
                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// 
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, 	dtHiddenStatus,		30, 	daCenter, 	false, 	"ibflag"); 
                 InitDataProperty(0, cnt++,  	dtCheckBox, 		40, 	daCenter, 	true, 	"chk");           
                 InitDataProperty(0, cnt++, 	dtCombo, 		    200, 	daCenter, 	false, 	"sys_cd", 	  		true,  "", dfNone,   0,    false, false);                                
                 InitDataProperty(0, cnt++ , 	dtCombo,			90,		daCenter,	false,	"ofc_tp_cd",	  	true,  "", dfNone,   0 ,   false, true);
                 InitDataProperty(0, cnt++ , 	dtData,				110,	daCenter,	false,	"ctrt_ofc_cd",		true,  "", dfNone,   0 ,   false, true, 6);
                 InitDataProperty(0, cnt++ , 	dtData,				110,	daCenter,	false,	"agmt_no", 			false, "", dfNone,   0 ,   false, true);
                 InitDataProperty(0, cnt++ , 	dtHidden,			80,		daLeft,		false,	"agmt_mapg_no");
                 for (var i=1; i<=usr_max_knt; i++){
                	 InitDataProperty(0, cnt++ , 	dtData,				80,		daLeft,		false,	"ntc_usr_id"+i,  	false, "", dfNone,   0 ,   true, true, 20);
                	 InitDataProperty(0, cnt++ , 	dtData,				80,		daLeft,		false,	"ntc_usr_id"+i+"_nm",   false, "", dfNone,   0 ,   false, false);
                	 InitDataProperty(0, cnt++ , 	dtCombo,			90,		daCenter,	false,	"ntc_n"+conv_job_cd_seq(i)+"_usr_id_jb_cd",  	false,  "", dfNone,   0 ,   true, true);
                 }
                 InitDataProperty(0, cnt++ , 	dtHidden,	    	30,		daCenter,	false,	"ctrt_cre_usr_count",   	false, "", dfNone,   0 ,  true,  true);
                 InitDataProperty(0, cnt++ , 	dtHidden,			80,		daLeft,		false,	"root_pgm_no",   	false, "", dfNone,   0 ,   false, false);
                 for (var i=1; i<=usr_max_knt; i++){
                	 InitDataProperty(0, cnt++ , 	dtHidden,		    90,		daCenter,	false,	"ntc_n"+conv_job_cd_seq(i)+"_usr_id_jb_cd_flg",  	false,  "", dfNone,   0 ,   false, true);
                 }
                 InitDataProperty(0, cnt++ , 	dtHidden,	    	20,		daLeft,	false,	"ntc_usr_id_list_ctnt",   	false, "", dfNone,   0 ,  true,  true);
                 InitDataProperty(0, cnt++ , 	dtHidden,	    	20,		daLeft,	false,	"ntc_usr_id_jb_cd_list_ctnt",   	false, "", dfNone,   0 ,  true,  true);
                 
                 InitDataValid(0, "ctrt_ofc_cd", vtEngUpOnly);
                 InitDataValid(0, "agmt_no", vtEngUpOther, "01234567890");
                 for (var i=1; i<=usr_max_knt; i++){
                	 InitDataValid(0, "ntc_usr_id"+i, vtEngOther, NOT_INPUT_KOR );	 
                 }
                 
                 WaitImageVisible = false;   
                 ShowButtonImage = 2;
                 Ellipsis = true;
     		}
          	break;
     	}
	}

	
  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 서미진
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   var code_cd ="";
	   var code_nm ="";
	   try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {		
		 		case IBSEARCH: // Retrieve 		
		 			if (!validateForm(sheetObj,formObj,sAction)) {
		 				return false;
		 			}
		 			ComOpenWait(true); //->waiting->start   
		 			sheetObj.CheckAll("chk") = "0"; // header unchecked
		 			formObj.f_cmd.value = SEARCH;	 			
		 			var sXml = sheetObj.GetSearchXml("COM_NTC_0001GS.do", FormQueryString(formObj));
		 			sheetObj.LoadSearchXml(sXml);
		 			for (var j = 1; j <= sheetObj.RowCount; j++){
		 				for (var i=1; i<=usr_max_knt; i++){
		 					sheetObj.CellComboItem(j, 'ntc_n'+conv_job_cd_seq(i)+'_usr_id_jb_cd', " |", " |");
		 				}
		 	        	  var code = sheetObj.CellValue(j, "ofc_tp_cd");
		 	        	  if (code == 'BB'){
		 	        		 code_cd = " |BBG|BBS|BBO|BBA|PIC";
		 	        		 code_nm = " |General Manager|Sales Manager|Operation Manager|Administrator|Person In Charge";
		 	        	  }else{
		 	        		 code_cd = " |VP|MGR|PIC";
		 	        		 code_nm = " |Vice President|Manager|Person In Charge"; 
		 	        	  }
		 	        	  
		 	        	  var tmp_sts_val = null;
		 	        	  for (var i=1; i<=usr_max_knt; i++){
		 	        		  tmp_sts_val = sheetObj.CellValue(j,'ibflag');
		 	        		  sheetObj.CellComboItem(j,'ntc_n'+conv_job_cd_seq(i)+'_usr_id_jb_cd', code_nm, code_cd);
		 	        		  sheetObj.CellValue2(j,'ntc_n'+conv_job_cd_seq(i)+'_usr_id_jb_cd') = sheetObj.CellValue(j,'ntc_n'+conv_job_cd_seq(i)+'_usr_id_jb_cd_flg');
		 	        		  sheetObj.CellValue2(j,'ibflag') = tmp_sts_val;
		 	        	  }
		 			}
		 			
		 			ComOpenWait(false); //->waiting->End
	 		 		break;	
 		 		
		 		case SEARCH01: // System Name Combo	 						
		 			formObj.f_cmd.value = SEARCH01;	 			
		 			var sXml = sheetObj.GetSearchXml("COM_NTC_0001GS.do", FormQueryString(formObj));
		 			ComXml2ComboItem(sXml, formObj.sys_cd, "cd", "nm");  
		 			var arrData = ComXml2ComboString(sXml, "cd", "nm");
		    		sheetObj.InitDataCombo (0,'sys_cd',arrData[1],arrData[0]);
		    	    formObj.sys_cd.focus(); 	
	 		 		break;	
		 		
		 		case SEARCH02: // Office Level Combo
		 			formObj.f_cmd.value = SEARCH02;	 			
		 			var sXml = sheetObj.GetSearchXml("COM_NTC_0001GS.do", FormQueryString(formObj));
		    		ComXml2ComboItem(sXml, formObj.ofc_tp_cd, "cd", "nm");     	
		    		var arrData = ComXml2ComboString(sXml, "cd", "nm");
                    sheetObj.InitDataCombo (0,'ofc_tp_cd',arrData[1],arrData[0]);
                    // 해당 job Code 수집을 해와서  셋팅 
                    var sParam = "&f_cmd=" + formObj.f_cmd.value + "&code_gubun=BB";
                    var sXml1 = sheetObj.GetSearchXml("COM_NTC_0001GS.do", sParam);
		    		//ComXml2ComboItem(sXml1, formObj.ofc_tp_cd, "cd", "nm");     	
		    		var arrData1 = ComXml2ComboString(sXml1, "cd", "nm");
		    		
		    		for (var i=1; i<=usr_max_knt; i++){
		    			sheetObj.InitDataCombo (0, 'ntc_n'+conv_job_cd_seq(i)+'_usr_id_jb_cd'," |"+ arrData1[1], " |"+arrData1[0]);
		    		}
	 		 		break;			 
	 		 		
		 		case IBINSERT: // Row Add
		 			if(formObj.sys_cd.Code ==""){
		 				ComShowMessage('Please retrieve first to row add.');
		 				return false;
		 			}
		 			var maxRow = sheetObj.DataInsert(-1);
		 			sheetObj.CellValue2(maxRow, 'sys_cd') = formObj.sys_cd.Code;
		 			programNoMap(sheetObj, maxRow);
		 			sheetObj.SelectCell(maxRow, 'ofc_tp_cd');
		 			break; 
		 			
				case IBDOWNEXCEL:
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
					break;		 			
		 			
		 		case IBDELETE:      // Row delete	
		 			if (sheetObj.RowCount == 0){
		 				ComShowMessage('There is no data to delete.'); 
		 				return false;
		 			}
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
		        	}		        	
		        	ComRowHideDelete(sheetObj, "chk");	 			
	 		 		break;				 			
		 			
		 		case IBSAVE: // save
		 			if (!validateForm(sheetObj,document.form,sAction)) {		 				
						return false;
					} 					
		 			formObj.f_cmd.value = MULTI01;
		 			conv_usrinfo2ctnt(sheetObj);
			 		var sParam = sheetObj.GetSaveString(false, true);
			 		sParam += "&" + FormQueryString(formObj);
		 			var sXml = sheetObj.GetSaveXml("COM_NTC_0001GS.do", sParam);	
		 			var sav = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     	    if(sav != "F" ){
		     	    	ComShowCodeMessage('COM130102','Data'); // 'Data was saved successfully.'
		     	    	doActionIBSheet(sheetObj, formObj, IBSEARCH);
		       	    }
		 			break;								    
	 		}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
			 ComOpenWait(false);
		}
	}

 	
	 /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         로직처리;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 
	 * @version 
	 */
	function validateForm(sheetObj, formObj, sAction) {  	 
		 switch (sAction) {		
	    	 case IBSEARCH: // Retrieve
	    		 if(formObj.sys_cd.Code == "") {
	    			 ComShowCodeMessage('COM130403',"System"); // 'Mandatory field is missing. Please enter System.'
	    			 ComSetFocus(formObj.sys_cd);
	    			 return false;
				 }
	    	 	 break;
		 
	    	 case IBSAVE: // save
	    		 //저장할 데이터가 있는지 확인
	        	 if(!sheetObj.IsDataModified){	            		 
	                 ComShowCodeMessage('COM130503'); // 'There is no updated data to save.'
	                 return false;
	        	 }	            	

		    	 //mandatory check
		    	 for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		    		 if (sheetObj.CellValue( i, "ibflag") =="I" || sheetObj.CellValue( i, "ibflag") =="U"||
		    		     sheetObj.CellValue( i, "ibflag") =="D") {
		    			 // system
		    			 if(sheetObj.CellValue( i, "sys_cd") ==""){
		    				 ComShowCodeMessage('COM130403',"System"); // 'Mandatory field is missing. Please enter System.'
		    				 sheetObj.SelectCell( i, "sys_cd");
		    				 return false;
		    			 }
		    			 // office level
		    			 if(sheetObj.CellValue( i, "ofc_tp_cd") ==""){
		    				 ComShowCodeMessage('COM130403',"Office level"); // 'Mandatory field is missing. Please enter Office level.'
		    				 sheetObj.SelectCell( i, "ofc_tp_cd");
		    				 return false;
		    			 }
		    			 // Office
		    			 if(sheetObj.CellValue( i, "ctrt_ofc_cd") ==""){
		    				 ComShowCodeMessage('COM130403',"Contract Office"); // 'Mandatory field is missing. Please enter Contract Office.'
		    				 sheetObj.SelectCell( i, "ctrt_ofc_cd");
		    				 return false;
		    			 } 
		    		 }
		    	 }		    	 
		    	 // dup chcek
		    	 var duprows = sheetObj.ColValueDupRows("sys_cd|ofc_tp_cd|ctrt_ofc_cd|agmt_mapg_no", false);
		    	 if(duprows != ""){
		    		 ComShowCodeMessage('COM131302',"Data"); // 'Data is duplicated.'
		    		 return false;		    		 
		    	 }
	    	 	 break;
		 }
		return true;
	}

	/**
	 *  usrid와 usrjobcd를 ctnt에 모은다. - 저장시 작업한다.
	 */
	function conv_usrinfo2ctnt(sheetObj){
		var ntc_usr_id_list_ctnt = "";
		var ntc_usr_id_jb_cd_list_ctnt = "";
		for (var irow=1; irow<=sheetObj.RowCount; irow++) {
			if (sheetObj.CellValue(irow,"ibflag")=='I' || sheetObj.CellValue(irow,"ibflag")=='U' || sheetObj.CellValue(irow,"ibflag")=='D'){
				for (var i=1; i<=usr_max_knt; i++){
					ntc_usr_id_list_ctnt = ntc_usr_id_list_ctnt + (ComIsEmpty(sheetObj.CellValue(irow,"ntc_usr_id"+i))?"#":sheetObj.CellValue(irow,"ntc_usr_id"+i)) + (i<usr_max_knt?"|":"");
					ntc_usr_id_jb_cd_list_ctnt = ntc_usr_id_jb_cd_list_ctnt + (ComIsEmpty(sheetObj.CellValue(irow,"ntc_n"+conv_job_cd_seq(i)+"_usr_id_jb_cd"))?"#":sheetObj.CellValue(irow,"ntc_n"+conv_job_cd_seq(i)+"_usr_id_jb_cd")) + (i<usr_max_knt?"|":"");
				}
				sheetObj.CellValue2(irow,"ntc_usr_id_list_ctnt") = ntc_usr_id_list_ctnt;
				sheetObj.CellValue2(irow,"ntc_usr_id_jb_cd_list_ctnt") = ntc_usr_id_jb_cd_list_ctnt;
				ntc_usr_id_list_ctnt = "";
				ntc_usr_id_jb_cd_list_ctnt = ""; 
			}
		}
	}

	/**
	 * sys_cd 변경되면 grid의 모든 Data를 삭제
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function sys_cd_OnChange(Index_Code, Text){
		sheetObjects[0].RemoveAll();
	}

 /**
  * sheet1_OnChange
  */  
  function sheet1_OnChange(sheetObj, Row, Col) {
      var colName = sheetObj.ColSaveName(Col);
      var formObj = document.form;
      var is_ntc_usr_id_onchange = false; // USR_ID 중 하나인지
      for (var i=1; i<=usr_max_knt; i++){
    	  if (("ntc_usr_id"+i)==colName){
    		  is_ntc_usr_id_onchange = true;
    		  break;
    	  }
      }
      var is_ntc_usr_jc_onchange = false; // USR_JOB_CD 중 하나인지
      for (var i=1; i<=usr_max_knt; i++){
    	  if (("ntc_n"+conv_job_cd_seq(i)+"_usr_id_jb_cd")==colName){
    		  is_ntc_usr_jc_onchange = true;
    		  break;
    	  }
      }
      if (is_ntc_usr_id_onchange){
    	  // dup check
    	  var usr_no = colName.substr(10);
    	  if(sheetObj.CellValue(Row,colName) != ""){
    		  var ntc_usr_id_list_ctnt = "";
        	  for(var i=1; i<=usr_max_knt; i++){ // 1 ~ usr_max_knt까지 중복으로 입력된 USR ID가 존재하는지 검사한다.
        		  /** USR ID가 변경될 때만 USR ID를 모아서 '|'로 붙여 지정된 column에 밀어넣는다. **/
	    		  ntc_usr_id_list_ctnt = ntc_usr_id_list_ctnt + (ComIsEmpty(sheetObj.CellValue(Row,"ntc_usr_id"+i))?"#":sheetObj.CellValue(Row,"ntc_usr_id"+i)) + (i<usr_max_knt?"|":"");
        		  if(i == usr_no){
        			  continue;
        		  }else{
        			  if(sheetObj.CellValue(Row,colName) == sheetObj.CellValue(Row,"ntc_usr_id"+i)){
        				  ComShowCodeMessage('COM131302','User'+usr_no); // 'User# is duplicated.'
                    	  sheetObj.CellValue2(Row, colName) = ""; 
                    	  sheetObj.SelectCell(Row, colName);
                    	  return false;
        			  }
        		  }
        	  }
        	  sheetObj.CellValue2(Row, "ntc_usr_id_list_ctnt") = ntc_usr_id_list_ctnt;
        	  formObj.f_cmd.value = SEARCH03;
        	  var sParam = "&f_cmd=" + formObj.f_cmd.value + "&cd=" + sheetObj.CellValue(Row, colName)
        	             + "&nm=" + sheetObj.CellValue(Row, "ctrt_ofc_cd"); 
	 		  var sXml = sheetObj.GetSearchXml("COM_NTC_0001GS.do", sParam);
	 		  // user exist check
              if( ComGetEtcData(sXml,"user_name")  == "" ){
//      			ComShowCodeMessage('PRI07006'); 
            	  sheetObj.CellValue2(Row, colName) = "";
            	  sheetObj.CellValue2(Row, colName+"_nm") = "";
            	  return false;
              }else{
            	  sheetObj.CellValue(Row, colName+"_nm") = ComGetEtcData(sXml,"user_name");
              }
    	  }else{
    		  sheetObj.CellValue2(Row, colName+"_nm") = "";
    	  }
      } else if (is_ntc_usr_jc_onchange){
    	  if(sheetObj.CellValue(Row,colName) != ""){
    		  var ntc_usr_id_jb_cd_list_ctnt = "";
    		  for(var i=1; i<=usr_max_knt; i++){ 
    			  ntc_usr_id_jb_cd_list_ctnt = ntc_usr_id_jb_cd_list_ctnt + (ComIsEmpty(sheetObj.CellValue(Row,"ntc_n"+conv_job_cd_seq(i)+"_usr_id_jb_cd"))?"#":sheetObj.CellValue(Row,"ntc_n"+conv_job_cd_seq(i)+"_usr_id_jb_cd")) + (i<usr_max_knt?"|":"");
    		  }
    		  sheetObj.CellValue2(Row, "ntc_usr_id_jb_cd_list_ctnt") = ntc_usr_id_jb_cd_list_ctnt;
    	  }
      } else {
          switch(colName)
          {
              case "sys_cd":      
            	  programNoMap(sheetObj, Row);
    			  sheetObj.CellValue2(Row,"agmt_no") = "";
    			  sheetObj.CellValue2(Row,"agmt_mapg_no") = "";
            	  break;  
            	  
              case "ctrt_ofc_cd":      
            	  formObj.f_cmd.value = SEARCH04;	 			
            	  var sParam = "&f_cmd=" + formObj.f_cmd.value + "&cd=" + sheetObj.CellValue(Row, colName)
            	             +"&nm=" + sheetObj.CellValue(Row, "ofc_tp_cd"); 
    	 		  var sXml = sheetObj.GetSearchXml("COM_NTC_0001GS.do", sParam);	 		  
                  if( ComGetEtcData(sXml,"officeVal")  == "" ){
//          			ComShowCodeMessage('PRI07006'); 
                	  sheetObj.CellValue2(Row, colName) = "";
                	  return false;
                  }        
                  break; 
                  
              case "agmt_no":
            	  if(!validate_agreement(sheetObj, Row)){
    				  ComShowCodeMessage('COM132201','Agreement No.');  // 'Agreement No. is invalid.';
    				  sheetObj.CellValue2(Row, colName) = "";
    				  sheetObj.CellValue2(Row,"agmt_mapg_no") = "";
    				  sheetObj.SelectCell(Row, colName);
    				  return false;
            	  }	
            	  var origin_agreeNo = sheetObj.CellValue(Row, "agmt_no"); 
            	  var trim_agreeNo = origin_agreeNo.substring(0,3)+ComLtrim(origin_agreeNo.substring(3,origin_agreeNo.length),"0");
            	  var check_agreeNo = "";
            	  if(sheetObj.CellValue(Row, "sys_cd")!="ACM"||sheetObj.CellValue(Row, "sys_cd")!="FMS"){
            		  check_agreeNo = trim_agreeNo;
            	  }else{
            		  check_agreeNo = origin_agreeNo;
            	  }
            	  formObj.f_cmd.value = SEARCH05;
            	  var sParam = "&f_cmd=" + formObj.f_cmd.value + "&sys_cd=" + sheetObj.CellValue(Row, "sys_cd")
    			             +"&agmt_no=" + check_agreeNo; 
    			  var sXml = sheetObj.GetSearchXml("COM_NTC_0001GS.do", sParam);	 		  
    			  if( ComGetEtcData(sXml,"agmt_mapg_no")  == "" || ComGetEtcData(sXml,"agmt_mapg_no")  == "null"){
    				  ComShowCodeMessage('COM132201','Agreement No.');  // 'Agreement No. is invalid.';
    				  sheetObj.CellValue2(Row, colName) = "";
    				  sheetObj.CellValue2(Row,"agmt_mapg_no") = "";
    				  sheetObj.SelectCell(Row, colName);
    				  return false;
    			  }else{
    				  sheetObj.CellValue(Row,"agmt_mapg_no") = ComGetEtcData(sXml,"agmt_mapg_no");
    			  }          	  
            	  break; 
            	  
              case "ofc_tp_cd":
            	  formObj.f_cmd.value = SEARCH02;
            	  var code = sheetObj.CellValue(Row, "ofc_tp_cd");
            	  // 해당 job Code 수집을 해와서  셋팅 
                  var sParam = "&f_cmd=" + formObj.f_cmd.value + "&code_gubun=" + code;
                  var sXml1 = sheetObj.GetSearchXml("COM_NTC_0001GS.do", sParam);
    	    	  var arrData1 = ComXml2ComboString(sXml1, "cd", "nm");
    	    	  
    	    	  for (var i=1; i<=usr_max_knt; i++){
    	    		  sheetObj.CellComboItem(Row, 'ntc_n'+conv_job_cd_seq(i)+'_usr_id_jb_cd', " |"+ arrData1[1], " |"+arrData1[0]);	    		  
    	    	  }
    	    	  
    	    	  break;
          }    	  
      }
  } 
  
  
  /**
   * Program No mapping
   * 
   * PSO : Port S/O의 경우에는 특정 계약 번호 입력 못하도록 회색 처리
   */
  function programNoMap(sheetObj, Row){
	  sheetObj.CellEditable(Row, 'agmt_no') = true; 
	  if(sheetObj.CellValue(Row, 'sys_cd') == 'PSO'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'VOP_PSO_M001';
		  sheetObj.CellEditable(Row, 'agmt_no') = false;
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'CHS'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'EES_CGM_M001';
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'LSE'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'EES_LSE_M001';
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'FMS'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'ESM_FMS_M001';
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'MNR'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'EES_MNR_M001';
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'MGS'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'EES_CGM_M019';
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'TES'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'ESD_TES_M001';
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'TRS'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'ESD_TRS_M001';
	  }else if(sheetObj.CellValue(Row, 'sys_cd') == 'ACM'){
		  sheetObj.CellValue(Row, 'root_pgm_no') = 'ESM_ACM_M001';
	  }
  }
  
  
  /**
   * OnPopupClick 이벤트 발생시 호출되는 function <br>
   * Sheet1 Popup버튼 클릭시 팝업화면 호출. 팝업화면에서 수정된 결과는 해당 sheet의 내용을 조합하여 Sheet1에 다시 Update해준다.
   * 
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
   * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
   * @return 없음
   * @author 서미진
   * @version 2014.02.07
   */
  function sheet1_OnPopupClick(sheetObj, Row, Col) {
  	var colName = sheetObj.ColSaveName(Col);
  	var formObj = document.form;

  	if (colName == "ctrt_cre_usr_count") {
  		if(sheetObj.CellValue(Row,Col) > 0){
	  		var sUrl = "/hanjin/COM_NTC_0002.do?" + "&sys_cd=" + sheetObj.CellValue(Row,'sys_cd')
	  		         + "&ctrt_ofc_cd=" + sheetObj.CellValue(Row,'ctrt_ofc_cd')
	  		         + "&agmt_mapg_no=" + sheetObj.CellValue(Row,'agmt_mapg_no') 
	  		         + "&ofc_tp_cd=" + sheetObj.CellValue(Row,'ofc_tp_cd') ;
	  		ComOpenWindowCenter(sUrl, "COM_NTC_0002", 800, 320, true);
  		}
  	}
  }
  
  /**
   * OnClick 이벤트 발생시 호출되는 function <br>
   */  	           
   function sheet1_OnClick(sheetObj, Row, Col, Value) {
	   var colname = sheetObj.ColSaveName(Col);
	   switch(colname) {
	   case "ctrt_cre_usr_count":      			
	  		if(sheetObj.CellValue(Row,Col) > 0){
		  		var sUrl = "/hanjin/COM_NTC_0002.do?" + "&sys_cd=" + sheetObj.CellValue(Row,'sys_cd')
		  		         + "&ctrt_ofc_cd=" + sheetObj.CellValue(Row,'ctrt_ofc_cd')
		  		         + "&agmt_mapg_no=" + sheetObj.CellValue(Row,'agmt_mapg_no') 
		  		         + "&ofc_tp_cd=" + sheetObj.CellValue(Row,'ofc_tp_cd') ;
		  		ComOpenWindowCenter(sUrl, "COM_NTC_0002", 800, 320, true);
	  		}
   		}
   } 
   
   /**
    * Agreement No. check validation
    */  
    function validate_agreement(sheetObj, Row) {   
    	var sys = sheetObj.CellValue(Row, "sys_cd");
    	var agreNo = sheetObj.CellValue(Row, "agmt_no");
    	if(sys == "ACM"){
    		// 1.최소 3자리 
    		if(agreNo.length < 3){
    			return false;
    		}
    	}else if(sys != "FMS"){
    		// 1.최소 4자리 
    		if(agreNo.length < 4){
    			return false;
    		}
    		// 2.앞에 3자리 잘라서 영문 대문자로 들어왔는지 확인
    		if(!ComIsAlphabet(agreNo.substring(0,3))){
    			return false;
    		}    		
    		// 3. 4자리째부터 숫자인지 확인
    		if(!ComIsNumber(agreNo.substring(3,agreNo.length))){
    			return false;
    		}       		
    	}
    	return true;
    }
    
  