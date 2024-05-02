/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1109.js
*@FileTitle : Europe Advanced Manifest - ENS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
* 1.1 2015.04.24 신영재 checkbox 선택 후 save 시 data delete 현상 개선
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
     * @class ESM_BKG_1109 : ESM_BKG_1109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1109() {
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

    
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var comboObjects = new Array();
    var comboCnt = 0;
	
    //전역변수
    var intervalId = "";
    
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 콤보 Object를 comboObjects 배열에 등록
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
    	var formObj = document.form;
    	
		for(i=0;i<sheetObjects.length;i++){
	        //시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
	        //마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
	    
	      //MultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
	    
		
		//화면에서 필요한 이벤트
		initControl();

	}
    
     function initControl() {
     	var formObject = document.form;

         axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
         axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
         axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
         axon_event.addListenerForm ('change', 'bkg_change', formObject);
         //axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
     }
          
     
 	/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
	* @param {String} comboId 필수,combo ID
	* @return 없음. 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form
			initComboEditable(comboObj, comboId)
 	}
 	
	
	/** 
	* 콤보 멀티 셀렉트 및 수정 여부 초기 설정 <br> 
	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
	* @param {String} comboId 필수,combo ID
	* @return 없음.
	*/ 
 	
	function initComboEditable(combo, comboId) {
		with (combo) {
			MultiSelect = false;
			UseEdit = false;
		}
	} 	
/** ********************* KEY EVENT START ******************* */ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;
	      case "custname":
	        //영문,숫자,공백,기타문자(.,등)
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            
	      default:
	      break;
	    }
	}  

	
	var preVvd;//이전에 조회했던 VVD에서 Focus Out 되면 재조회 하지 않는다.
	var prePodCd;
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
    		case "p_to_dt":
    			ComClearSeparator(event.srcElement);
				break;  		
			default:
				break;
	    }
    }           

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "p_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "p_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}  
	
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function bkg_change(){
    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_cnt_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
				break;
			default:
				break;
	    }
    }
    
    /*############################# combo onchage start ########################*/
    /**
    	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
    	 * 입력값을 upper로 변경하여 재등록 한다.
    	 * @param comboObj
    	 * @return
    	 */
    	function p_port_OnChange(comboObj) {
    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
    	}
    	
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if ((srcName == "p_vvd" || srcName == "p_pol" || srcName == "p_pod") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		//ComSetNextFocus();
    	}
    	
    }
    
	    /**
	     * 시트를 클릭했을 때 처리 0127참조
	     */
	    function sheet1_OnClick(sheetObj, row, col) {
	    	/*
	    	var rowCnt = sheetObj.RowCount;
	        var colSaveName = sheetObj.ColSaveName(col);
	        switch(colSaveName) {
		    	case "port_cd" :
		    		if(sheetObj.CellValue(row, "ibflag") == "I") return;
		    		//alert(sheetObj.CellValue(row, "ports_cd"));
		    		//sheetObj.InitDataCombo(0,"port_cd",sheetObj.CellValue(row, "ports_cd"),
		    		//sheetObj.InitDataCombo(0,"port_cd",sheetObj.CellValue(row, "ports_cd"),sheetObj.CellValue(row, "ports_cd"), "", "",0);
		    		break;
		    	case "tml_cd" :
		    		if(sheetObj.CellValue(row, "ibflag") == "I") return;
		    		//alert(sheetObj.CellValue(row, "ports_cd"));
		    		//sheetObj.InitDataCombo(0,"port_cd",sheetObj.CellValue(row, "ports_cd"),
		    		//sheetObj.CellComboItem(row,"tml_cd",sheetObj.CellValue(row, "tmls_cd"),sheetObj.CellValue(row, "tmls_cd"));
		    		break;
	        } // end switch
	        */
	        
	    }
	    
	      /**
	      *  조회 후 처리
	      * @param sheetObj Sheet
	      * @param ErrMsg String
	      */
	     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	     /*	
			for ( var i= sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				sheetObj.CellComboItem(i,"port_cd",sheetObj.CellValue(i, "ports_cd"),sheetObj.CellValue(i, "ports_cd"));
				sheetObj.CellValue(i,"port_cd") = sheetObj.CellValue(i, "port_cd");
				sheetObj.CellComboItem(i,"tml_cd",sheetObj.CellValue(i, "tmls_cd"),sheetObj.CellValue(i, "tmls_cd"));
			}
			*/
	     }	    
	    
 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick = processButtonClick;
 	
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
     	
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1 = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	//try {
     		var srcName = window.event.srcElement.getAttribute("name");
                                            
            switch(srcName) {

 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;

 				case "btn_Save":
 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
 					break;
 							 
				case "btn_RowAdd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
					break;
				case "btn_RowDelete":
					var iCheckRow = sheetObject1.FindCheckedRow("sel");
					var arrRow = iCheckRow.split("|");
					//alert(arrRow);
					if (iCheckRow == "") {
						ComShowCodeMessage('COM12189');
						return;
					}
	
					ComRowHideDelete(sheetObject1, "sel");
					break;

 				
 					
             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
     }
          
    
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

			case IBSEARCH : // 조회
				//if(!validateForm(sheetObj,formObj,sAction)) return;
			
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.RemoveAll();
				
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1109GS.do", FormQueryString(formObj));
					
				sheetObj.LoadSearchXml(sXml);
				sheetObj.Redraw = true;
				sheetObj.WaitImageVisible = false;
				
				break;
			case IBINSERT: // 입력					
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				sheetObj.DataInsert(-1);
				break;
			case IBSAVE:
				if (!sheetObj.IsDataModified)return;
				var sParam = sheetObj.GetSaveString(true);
				if(sParam =="" )return;
				
				if (!validateForm(sheetObj, formObj, sAction)) return;
				
				formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1109GS.do", sParam+"&f_cmd="+formObj.f_cmd.value);
				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				
				if ( State == "F" ) {
					var errMsg = ComGetEtcData(sXml,"Exception")
			    	var rmsg = errMsg.split("<||>");
			    	if(rmsg[3] != undefined && rmsg[3].length > 0) {
			    		ComShowMessage(rmsg[3]);
			    	}else{
			    		sheetObjects[0].LoadSaveXml(sXml);
			    	}				    	
					
				}else{
					sheetObj.LoadSaveXml(sXml);
					
					formObj.f_cmd.value = SEARCH; //재조회
					sParam += "&" + FormQueryString(formObj);
					sXml = sheetObj.GetSaveXml("ESM_BKG_1109GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);
				}
				break;
			case SEARCH01 : // p_port 조회
				formObj.f_cmd.value = SEARCH01;
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1109GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.p_port, "port_cd", "port_cd");
				break;
			case SEARCH02 : // Terminal 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml =  sheetObj.GetSearchXml("ESM_BKG_1109GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.p_tml, "yd_cd", "yd_cd");
				break;
	
				
        }

        
    }
    

	   /**
     * Save시 유효성 체크 function <br>
     * 유효하지 않으면 처리를 중단한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} rowIdx 행 인덱스
     * @param {int} colIdx 열 인덱스
     * @param String value  값
     * @return 없음
     * @version 2010.12.13
     */ 	
	function sheet1_OnValidation(sheetObj,rowIdx,colIdx,value) {
		
	  if(sheetObj.CellValue(rowIdx, "ibflag") == 'D' || sheetObj.CellValue(rowIdx, "ibflag") == 'R' ) return;
	  
	  if(colIdx == sheetObj.SaveNameCol("ct_email")){
			if (!ComIsNull(value) && !ComIsEmailAddr(value)) {
				ComShowCodeMessage("BKG95001"," enter correct 'Email Address'",""); 
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		}
  
	  /*
	  else if(colIdx == sheetObj.SaveNameCol("ct_tel")){
			if (!ComIsNull(value) && !ComIsNumber(value, "-"))  {
				ComShowCodeMessage("BKG95001"," enter correct 'Tel No'","(Format:123-1234-1234)"); 
                sheetObj.ValidateFail = true;
                sheetObj.SelectCell(rowIdx, colIdx);
			}
			
		}else if(colIdx == sheetObj.SaveNameCol("ct_fax")){
			if (!ComIsNull(value) && !ComIsNumber(value, "-"))  {
				ComShowCodeMessage("BKG95001"," enter correct 'Fax No'","(Format:123-1234-1234)"); 
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(rowIdx, colIdx);
			}
		}
		*/

     }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
	    switch(sAction) {
	    	case IBSEARCH:
				break;
	    	case IBSAVE:
	    		
				if (sheetObj.RowCount("I") + sheetObj.RowCount("U") == 0) {
					return true; // 신규세팅과 기존세팅이 각각 하나 이상이어야 중복확인 한다.
				}
			
				//삭제된거 제외 중복체크
				var duprow = sheetObj.ColValueDup("port_cd|tml_cd", false); 
				if(duprow > 0){
					ComShowCodeMessage("COM131302","Port Code("+sheetObj.CellValue(duprow,"port_cd")+"),Terminal("+sheetObj.CellValue(duprow,"tml_cd")+")");
					sheetObj.SelectCell(duprow, "tml_cd");
					return false;
				}

				//생성,수정시 중복된 Port Code가 있는지 확인한다.
				var statusCode = "";
				//마지막 데이타는 체크할 필요 없다.
				var temp_term_cd = "";
				//데이타 길이 체크
				for ( var index = sheetObj.HeaderRows; index <= sheetObj.LastRow; index++) {
					statusCode = sheetObj.CellValue(index, "ibflag");
					if (statusCode == "D" || statusCode == "R") continue;
					if(statusCode == "I" && ComTrim(sheetObj.CellValue(index, "port_cd")).length != 5){
						ComShowCodeMessage("BKG95018","Port("+sheetObj.CellValue(index, "port_cd")+")","5");
						sheetObj.SelectCell(index, "port_cd");
						return false;
					}
					temp_term_cd = ComTrim(sheetObj.CellValue(index, "tml_cd"));
					if(temp_term_cd != "ALL" && temp_term_cd.length != 7 ){
						ComShowCodeMessage("BKG95018","Terminal("+temp_term_cd+")","7( or 'ALL')");
						sheetObj.SelectCell(index, "tml_cd");
						return false;
					}
				}
				
				//ALL체크
				for ( var index = sheetObj.HeaderRows; index <= sheetObj.LastRow -1; index++) {
					statusCode = sheetObj.CellValue(index, "ibflag");
					if (statusCode == "D") continue;
					if(dupAllCheckTmlcd(sheetObj, sheetObj.CellValue(index, "port_cd"),ComTrim(sheetObj.CellValue(index, "tml_cd")), index)){
						sheetObj.SelectCell(index, "tml_cd");
						return false;
					}
				}

				break;
	    }
        return true;

    }
    
    
    /**
     * Port Code,Terminal 중복 확인
     * @param sheetObj
     * @param p_port_cd
     * @param p_tml_cd
     * @param p_index
     * @return
     */
    function dupAllCheckTmlcd(sheetObj, p_port_cd,p_tml_cd, p_index) {
    	//생성,수정시 중복된 Port Code가 있는지 확인한다.
		var statusCode = "";
		var temp_term_cd="";
		for(var i= p_index +1; i<= sheetObj.LastRow; i++) {
			statusCode = sheetObj.CellValue(i, "ibflag");
			if (statusCode == "D")continue;
			temp_term_cd = ComTrim(sheetObj.CellValue(i, "tml_cd"));
			if( p_tml_cd == "ALL" && p_port_cd == sheetObj.CellValue(i, "port_cd") ||
				temp_term_cd == "ALL" && p_port_cd == sheetObj.CellValue(i, "port_cd")	
			   ){
				ComShowCodeMessage("COM131302","Port Code("+p_port_cd+"),Terminal(ALL - Terminal must not exists but 'ALL')");
				return true;
			}

		}
		
		return false;
    }
      

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
			
			case "sheet1":
					with (sheetObj) {

						// 높이 설정
						style.height = 390;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
						MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(2, 1, 3, 100);
						
						var HeadTitle1 = "|Seq.|Sel.|Country|Port|Terminal|Custom Code|SVC|SVC|SVC|SVC|Contact Info|Contact Info|Contact Info|Contact Info|Contact Info|ports_cd|tmls_cd";
						var HeadTitle2 = "|Seq.|Sel.|Country|Port|Terminal|Custom Code|EXS|ENS|A/N|D/R|Name|Position|Email|Tel|Fax|ports_cd|tmls_cd";
				        var headCount = ComCountHeadTitle(HeadTitle1);
						
						
						headCount = ComCountHeadTitle(HeadTitle1);
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 7, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
						InitHeadMode(false, false, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						
				           //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
						InitDataProperty(0, cnt++ , dtSeq,			40,	daCenter,  true,  "dt_seq",	    false,  "",  dfNone,	 0, false, false);
						InitDataProperty(0, cnt++,  dtCheckBox,     40, daCenter,  true,  "sel",        false,  "",  dfNone,     0, true,  true );
						InitDataProperty(0, cnt++ , dtData,         80, daCenter,  true,  "cnt_cd",     false,  "",  dfEngUpKey, 0, false, false,2);
						InitDataProperty(0, cnt++ , dtData,         70, daCenter,  true,  "port_cd",    true,   "",  dfEngUpKey, 0, false, true,5);
						InitDataProperty(0, cnt++ , dtData,         90, daCenter,  true,  "tml_cd",     true,   "",  dfEngUpKey, 0, false,  true,7);
						InitDataProperty(0, cnt++ , dtData,         100, daCenter,  true,  "customs_cd",true,   "",  dfEngUpKey, 0, true,  true,20);
						
						InitDataProperty(0, cnt++ , dtCheckBox,     40, daCenter,  true,  "svc_exs_yn");
						InitDataProperty(0, cnt++ , dtCheckBox,     40, daCenter,  true,  "svc_ens_yn");
						InitDataProperty(0, cnt++ , dtCheckBox,     40, daCenter,  true,  "svc_an_yn");
						InitDataProperty(0, cnt++ , dtCheckBox,     40, daCenter,  true,  "svc_dr_yn");
						InitDataProperty(0, cnt++ , dtData,         80, daCenter,  true,  "ct_name",     false,   "",  dfNone, 0, true,  true,35);
						InitDataProperty(0, cnt++ , dtData,         80, daCenter,  true,  "ct_position", false,   "",  dfNone, 0, true,  true,35);
						InitDataProperty(0, cnt++ , dtData,         150, daCenter,  true,  "ct_email",    false,   "",  dfNone, 0, true,  true,35);
						InitDataProperty(0, cnt++ , dtData,         100, daCenter,  true,  "ct_tel",      false,   "",  dfNone, 0, true,  true,35);
						InitDataProperty(0, cnt++ , dtData,         100, daCenter,  true,  "ct_fax",      false,   "",  dfNone, 0, true,  true,35);
						
						InitDataProperty(0, cnt++ , dtHidden,       60, daCenter,  true,  "ports_cd");
						InitDataProperty(0, cnt++ , dtHidden,       60, daCenter,  true,  "tmls_cd");
						CountPosition = 0;
						InitDataValid(0, "cnt_cd", vtEngUpOnly);
						InitDataValid(0, "port_cd", vtEngUpOnly);
						InitDataValid(0, "tml_cd", vtEngUpOther, "1234567890");
						InitDataValid(0, "customs_cd", vtEngUpOther, "1234567890");
						
						
						//영문과 "1", "2", "3", "9" ,'@' 글자도 입력하기
						InitDataValid(0, "ct_name", vtEngOther, "1234567890. ");
						
						//영문과 "1", "2", "3", "9" ,'@' 글자도 입력하기
						InitDataValid(0, "ct_email", vtEngOther, "1234567890@_-.");
						//숫자와 "-", "," 입력하기
						InitDataValid(0, "ct_tel", vtNumericOther, "-,");
						InitDataValid(0, "ct_fax", vtNumericOther, "-,");
					}
				break;
		}//end switch
 	}     
	
    /* 개발자 작업  끝 */
