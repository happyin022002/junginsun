/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3521.js
*@FileTitle : Inland Rates Amend Request
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
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
     * @class ESM_PRI_3521 : ESM_PRI_3521 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3521() {
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

    //데이터 변경 여부를 알기 위한 변수 메인으로 return하여 true 인 경우 메인을 재조회한다.
    var returnData = false;
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.10.28
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_ok":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					if (returnData){
	 					window.returnValue = returnData;
	 					window.close();
					}
					break;
				case "btn_close":
					window.returnValue = returnData;
					window.close();
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
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
	* @author 최성민
	* @version 2009.10.28
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
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
    * @author 최성민
    * @version 2009.05.17
    */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		if (sheetObjects[0].RowCount > 0){
			sheetObjects[0].SelectCell(1, "eff_dt");
		}
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
     * @author 최성민
     * @version 2009.05.22
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {

        case "sheet1":      //t1sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 42;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);
                var HeadTitle = "|Amend No.|Effective Date|1|2|3|4|5|6|7|8|9";
               
                var headCount = ComCountHeadTitle(HeadTitle);
               
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

				//데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
				//	  			  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
				//	  			  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
				//	  			  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]                      
                InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, 	false, 	"ibflag");
                InitDataProperty(0, cnt++, dtData,     		160,daCenter, 	true,  	"amdt_seq", 			false, 	"", dfNone, 	0,	false, 	false);
                InitDataProperty(0, cnt++, dtData,     		150,daCenter, 	true,  	"eff_dt",	 			true,  	"", dfDateYmd, 	0, 	true,  	true);
                
                InitDataProperty(0, cnt++, dtHidden, 		90, daCenter, 	false, 	"trf_pfx_cd", 			false, 	"", dfNone,    	0, 	false, 	false);
				InitDataProperty(0, cnt++, dtHidden,     	150,daCenter, 	false, 	"trf_no",				false, 	"", dfNone, 	0, 	false,  false);
                InitDataProperty(0, cnt++, dtHidden,     	150,daCenter, 	false, 	"trf_inlnd_seq",		false, 	"", dfNone, 	0, 	false,  false);
                InitDataProperty(0, cnt++, dtHidden,     	150,daCenter, 	false, 	"pub_dt",	 			false, 	"", dfDateYmd, 	0, 	false,  false);
                InitDataProperty(0, cnt++, dtHidden,     	150,daCenter, 	false, 	"exp_dt",	 			false, 	"", dfDateYmd, 	0, 	false,	false);
                InitDataProperty(0, cnt++, dtHidden,     	150,daCenter, 	false, 	"trf_inlnd_nm",			false, 	"", dfNone, 	0, 	false,	false);
                InitDataProperty(0, cnt++, dtHidden,		150,daCenter,	true,	"trf_inlnd_sts_cd",    	false,	"",	dfNone,		0,	false,	false);
                InitDataProperty(0, cnt++, dtHidden,     	150,daCenter, 	true,  	"bef_eff_dt",	 		false, 	"", dfDateYmd, 	0, 	false,  false);
                InitDataProperty(0, cnt++, dtHidden,		40,	daLeft,		false,	"upd_dt");
                
                CountPosition = 0;
				WaitImageVisible = false;
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
   * @author 최성민
   * @version 2009.05.22
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {																		
		 		case IBSEARCH: // 조회
					var sXml = dialogArguments.getSheetXml();
					sheetObj.LoadSearchXml(sXml);
					break;
			 			  
	 			case IBSAVE: // Save
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	 				if (!ComPriConfirmSave()) {
						return false;
					}

	  				ComOpenWait(true);
	  				sheetObj.CellValue2(sheetObj.SelectRow, "amdt_seq") = parseInt(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq")) + 1;
	  				sheetObj.DoAllSave("ESM_PRI_3521GS.do", "f_cmd=" + MODIFY01);	  				
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
 	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	 * @return 없음
 	 * @author 최성민
 	 * @version 2009.05.20
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		formObj.tariff_cd.value 	= sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd")+"-"+sheetObj.CellValue(sheetObj.SelectRow, "trf_no");
 		formObj.inland_nm.value 	= sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_nm");
 		
 		sheetObj.CellValue2(sheetObj.SelectRow, "bef_eff_dt") = sheetObj.CellValue(sheetObj.SelectRow, "eff_dt");
 		//sheetObj.CellValue2(sheetObj.SelectRow, "amdt_seq") = parseInt(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq")) + 1;
 		sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "I";
 		sheetObj.CellValue2(sheetObj.SelectRow, "eff_dt") = "";
 	}

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 데이터 수정 Flag에 Y로 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 최성민
     * @version 2010.10.19
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
    	 		returnData = true;
    	 	}
 	}
   
	/**
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확은을 한다.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} sheetObj update date와 key를 가진 sheet object
    * @param {String} checkTpCd update date를 check해야 하는 table이 다를 수 있다 이를 구분하는 code
    *  
    * @return boolean , true : 변경된 데이터 있음, false: 변경된 데이터 없음.
    * @author 송민석
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
    	
    	var returnValue = false;
        /////////////////////////////////////////////////////////////////////
    	
        // update date 검사
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
	        + "&key1="+sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd") 
	        + "&key2="+sheetObj.CellValue(sheetObj.SelectRow, "trf_no") 
	        + "&key3="+sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") 
	        + "&key4="+sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_seq")
	        + "&upd_dt="+sheetObj.CellValue(sheetObj.SelectRow, "upd_dt");
	        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   case "CHECK2" : //amend
	   	    var amdt_seq = parseInt(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq"));
	   		//다음 seq가 이미 생성되었는지 확인한다.
	   		amdt_seq++;
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
	        + "&key1="+sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd") 
	        + "&key2="+sheetObj.CellValue(sheetObj.SelectRow, "trf_no") 
	        + "&key3="+amdt_seq
	        + "&key4="+sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_seq")
	        + "&upd_dt="+sheetObj.CellValue(sheetObj.SelectRow, "upd_dt");
	        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
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
     * @author 최성민
     * @version 2009.04.17
     */
 	function validateForm(sheetObj, formObj, sAction) {
 		
 		switch (sAction) {
 		case IBSEARCH: // 조회
			break;
			
   		case IBSAVE:
   			var effDt = sheetObj.CellValue(sheetObj.SelectRow, "eff_dt");
   			var bExpDt = sheetObj.CellValue(sheetObj.SelectRow, "exp_dt");
   			var bEffDt = sheetObj.CellValue(sheetObj.SelectRow, "bef_eff_dt");
   			
   			if(effDt == "") {
   				ComShowCodeMessage("PRI00316", "Effective Date");
   				sheetObj.SelectCell(sheetObj.SelectRow, "eff_dt");
   				return false;
   			}  
 		 	   			
   			if(bEffDt >= effDt) {
   				ComShowCodeMessage("PRI00354", "previous amendment Seq. effective date");
   				sheetObj.SelectCell(sheetObj.SelectRow, "eff_dt");
   				return false;
   			}
   			/*
   			if(bExpDt != "" && bExpDt < effDt) {
   				ComShowCodeMessage("PRI00353", "tariff rule expiration date");
   				sheetObj.SelectCell(sheetObj.SelectRow, "eff_dt");
   				return false;
   			}
   			*/
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK2") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
               			     			
 			break;
 		}

 		return true;
 	}
   


	/* 개발자 작업  끝 */