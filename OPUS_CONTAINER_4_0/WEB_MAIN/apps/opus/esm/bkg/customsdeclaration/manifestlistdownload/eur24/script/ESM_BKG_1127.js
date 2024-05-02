/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1127.js
*@FileTitle  : Transmit / Receive History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/18
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
     * @class ESM_BKG_1127 : ESM_BKG_1127 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1127() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.sheet1_OnKeyUp=sheet1_OnKeyUp;
    }
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    //전역변수
    var intervalId="";
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj; 
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
    	var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
	        //시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
	        //마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//화면에서 필요한 이벤트
		initControl();
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
     function initControl() {
     	var formObject=document.form;
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm  ('change', 'bkg_change', formObject);
        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
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
   	    var formObject=document.form
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
	 		if(comboId == "p_pofe" ){
	 			SetMultiSelect(0);
	 			SetUseEdit(0);
	 			//BackColor = "#CCFFFD";
	 		}
 		}
 	} 
/*********************** KEY EVENT START ********************/ 	 
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
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "p_vvd_cd":
				break;
	    	case "p_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "p_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }           
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
	}       
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function bkg_change(){
    }
     /**
      * Booking Creation 화면 이동
      * @param sheetObj Sheet
      * @param Row Row Index
      * @param Col Col Index
      */
     function sheet1_OnDblClick(sheetObj, row, col) {
	        var colSaveName=sheetObj.ColSaveName(col);
	        switch(colSaveName) {
	        	case "bl_no" :
	        	//	ComBkgCall0079(sheetObj.CellValue(row, "bkg_no"));
		    	break;
	        } // end switch
     }	
    /**
     * 조회후  이벤트 처리 >>> ToolTipText설정
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with (sheetObj) {
        	var blueColor="#0000FF";
            for(var i=HeaderRows(); i<= LastRow(); i++) {
            	if(GetCellValue(i,"by_name") != ""){
            		SetToolTipText(i,"by_id",GetCellValue(i,"by_name"));
            		SetCellFontColor(i,"by_id",blueColor);
            	}
            }
        }//end width
    }	    
 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick=processButtonClick;
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
            switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
 					break;
 				default:
					break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				//formObj.p_pofe.value = formObj.p_pofe_temp.text;
//				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				sheetObj.RemoveAll();
 				var sXml=sheetObj.GetSearchData("ESM_BKG_1127GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
//				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				break;
			default:
				break;
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	    	case IBSEARCH:
	    		//기본포멧체크
    			if (ComIsNull(formObj.p_bl_no)) {
    				ComShowCodeMessage('BKG00104','B/L_No');
 					formObj.p_bl_no.focus();
 					return false;    
    			}
				break;
	    }
        return true;
    }
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    }
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function obj_change() {
    }
    /**
     * 시트를 클릭했을 때 처리 0127참조
     */
    function sheet1_OnClick(sheetObj, row, col) {
        var colSaveName=sheetObj.ColSaveName(col);
        var check=sheetObj.GetCellValue(row,"sel");
        var keySeq=sheetObj.GetCellValue(row,"dt_seq");
        switch(colSaveName) {
	    	case "msg_img":
	    		if( sheetObj.GetCellValue(row,"msg_img") == 'img/btns_search.gif' ){
	    		 //ComShowMemoPad(sheetObj, row, "rcv_msg", true, 300, 150);	//편집불가능
	    			var edi_rcv_dt=sheetObj.GetCellValue(row, "edi_rcv_dt");
	    			var edi_rcv_seq=sheetObj.GetCellValue(row, "edi_rcv_seq");
			       var cnt_cd=form.p_cstms_port_cd.value.substring(0,2);
			       ComOpenWindowCenter("/opuscntr/ESM_BKG_1128.do?pgmNo=ESM_BKG_1128&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1104", 540, 600, false);
			       break;
	    	 }
	    	break;
        } // end switch
    }    
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
		     
		      var HeadTitle1="|Seq.|Type|Message|VVD|EU POL|Time|Time|RCV_MSG|Result|Result|MRN|By|By|BY_NAME|edi_rcv_dt|edi_rcv_seq";
		      var HeadTitle2="|Seq.|Type|Message|VVD|EU POL|GMT|Local|RCV_MSG|Result|Result|MRN|By|By|BY_NAME|edi_rcv_dt|edi_rcv_seq";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"type_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"msg_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cstms_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"gmt_time",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"local_time",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_msg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"msg_img",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mrn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"by_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"by_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"by_name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(0);
		      SetCountPosition(0);
		      SetImageList(0,"img/btns_search.gif");
		      SetImageList(1,"img/blank.gif");
		      SetShowButtonImage(0);
		      SetMergeCell(0, 9, 2, 2); //result
		      SetMergeCell(0, 12, 2, 2); //by
		      SetSheetHeight(372);
		      }

				break;
		}//end switch
 	}     
    /* 개발자 작업  끝 */
