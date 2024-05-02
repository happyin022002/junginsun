/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5003.js
*@FileTitle : Invoice Interface to A/R - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.09 최성환
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
     * @class EES_DMT_5003 : EES_DMT_5003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_5003() {
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
	
	var IBARIF		= 52;	
	
 	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

 	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
 	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	 
		var sheetObject1 = sheetObjects[0];
 	 
 	 /*******************************************************/
		
		var formObj = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var srcObj = window.event.srcElement;

			switch(srcName) {
 				case "btn_hold":
 					if(ComIsBtnEnable(srcName)) {
 	 					openPopupWindow(sheetObject1, formObj, srcName);
					}
 					break;
					
	 			case "btn_arif":
	 				if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1, formObj, IBARIF);
					}
 					break;
					
	 			case "btn_detail":
	 				if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
					}
	 				break;
	 				
	 			case "btn_downexcel":
	 				sheetObject1.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'chk_box'); 
	 				
	 				break;	 				
	 			
	 			case "btn_close":
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
    * IBSheet Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	 	 /*********************************************
          * 팝업으로 호출시 처리 Title 정의
          **********************************************/
//		 var spanObj = document.getElementById("title");
//		 spanObj.innerText = "  Invoice Interface to A/R - Detail";
		 for(i=0;i<sheetObjects.length;i++){
			 //khlee-시작 환경 설정 함수 이름 변경
			 ComConfigSheet (sheetObjects[i] );
			 initSheet(sheetObjects[i],i+1);
			 //khlee-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	 	
		//html컨트롤 이벤트초기화
		initControl();
		
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		//hold 버튼 권한 여부 / 권한이 있으면 hold 버튼이 보이고 / 그외는 버튼 자체를 숨김
		//처리 취소 : 5002화면에서 hold_auth 값을 파람값으로 직접 전달 함으로 필요 없어짐.
//		var holdAuthDiv = document.getElementById("hold_auth_div");
//		if(holdAuthority(ComGetObjValue(formObj.usr_ofc_cd))){
//			ComSetObjValue(formObj.hold_auth,"Y");
//			holdAuthDiv.style.display = "block"; //block
//		} else {
//			ComSetObjValue(formObj.hold_auth,"N");
//			holdAuthDiv.style.display = "none";  //none
//			//alert(ComGetObjValue(formObj.hold_auth));
//		}
		
	}
   
	//Init Control
	function initControl() {
        axon_event.addListenerForm  ('blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
        axon_event.addListenerFormat('focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress' , 'obj_keypress'  , document.form);  //- 키보드 입력할때
	}


	
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// 영문대+숫자 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
		    	// 영문대+숫자+예외문자
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //숫자 만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
	}
	
	function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기
         var obj = event.srcElement;
	}
     
	function obj_focus() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {

		 var cnt = 0;

		 switch(sheetNo) {
		 	case 1:      // sheet1 init
		 		with (sheetObj) {
                    // 높이 설정
                    style.height = 450;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                     // Ctrl키를 눌러 다중행 선택가능 2010.03.19 드래그 멀티선택기능
                     MultiSelection = true;
                     SelectionMode = smSelectionList;
                     
                    var HeadTitle  = "||Seq.|INV No.|A/R|Over Days|Cur.|Billing AMT|TAX AMT|Payable AMT|Type|BKG No.|B/L No.|Reference No.|DMDT_INV_STS_CD|DMDT_INV_TP_CD";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE,		SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,   	daCenter,   true,     	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,	30,			daCenter,	true,		"chk_box");
					InitDataProperty(0, cnt++ , dtSeq,		30,			daCenter,	false,		"seq");
					InitDataProperty(0, cnt++ , dtData,		90,			daCenter,	false,		"dmdt_inv_no",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		30,			daCenter,	false,		"dmdt_ar_if_cd",	false,		"",			dfNone,			0,		false,		false);
					                                                                                                          
					InitDataProperty(0, cnt++ , dtData,		65,			daCenter,	false,		"over_days",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,			daCenter,	false,		"inv_curr_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	100,		daRight,	false,		"inv_chg_amt",		false,		"",			dfFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	100,		daRight,	false,		"tax_amt",			false,		"",			dfFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	100,		daRight,	false,		"inv_amt",			false,		"",			dfFloat,		2,		false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		50,			daCenter,	false,		"dmdt_trf_cd",		false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,			daLeft,		false,		"bkg_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,			daLeft,		false,		"bl_no",			false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,			daCenter,	false,		"cr_inv_no",		false,		"",			dfNone,			0,		false,		false);
					//HIDDEN 데이터가 'R' OR 'T' - EES_DMT_4002 ,'M' - EES_DMT_4004로 이동 
					InitDataProperty(0, cnt++ , dtHidden,	0,			daCenter,	false,		"dmdt_inv_sts_cd",	false,		"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	0,			daCenter,	false,		"dmdt_inv_tp_cd",	false,		"",			dfNone,			0,		false,		false);
					
					ToolTipOption = "balloon:true;width:50;";
					ToolTipText(0,"over_days") = "Over Days from Invoice Issued date";
					ToolTipText(0,"cr_inv_no") = "Reference Invoice No for Credit Note";
 					CountPosition = 2;
		 		}
		 		break;

	        }
	}
  	  
	function retAftARIF(){
		//처리 완료 후 재조회
		ComSetObjValue(formObj.chk_hold, "Y");
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	 		case IBSEARCH:      //조회			
		 		//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
		        ComOpenWait(true);
	 		
 				formObj.f_cmd.value = SEARCH;
	 			sheetObj.DoSearch4Post("EES_DMT_5003GS.do",	FormQueryString(formObj));
	 			
	 			//ComOpenWait End
				ComOpenWait(false);
				
	 			break;
	 			
	 		case IBARIF:
        		setParameters(COMMAND01);
        		if(!validateForm(sheetObj,formObj,sAction)) return;
        		
        		//confirm 처리...Do you want to interface the selected invoices?
        		if(!ComShowCodeConfirm('DMT00186'))
                return false;
        		
        		//ComOpenWait Start
				sheetObj.WaitImageVisible=false;
		        ComOpenWait(true);
		        
				var sParam = sheetObjects[0].GetSaveString(false) +"&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("EES_DMT_5003GS.do", sParam);
				
				//ComOpenWait End
				ComOpenWait(false);
				
				//3.저장 후 결과처리
				sheetObj.LoadSaveXml(sXml);

				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				
				//처리 완료 후 재조회
				ComSetObjValue(formObj.chk_hold, "Y");
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				
        		break;     	
		}
	}

	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
				case IBARIF:
					if(sheetObj.CheckedRows("chk_box") == 0) {
	    				ComShowCodeMessage('DMT00140', 'invoice');  
	         			return;
		     		}
					
					//Grid Check
					var selectedCnt = 0;
					for (var i = 1 ; i < sheetObj.TotalRows + 1; i++) {
						if(sheetObj.CellValue(i, "chk_box") == 1) {
							//Invoice no 필수 입력 체크
							if(sheetObj.CellValue(i, "dmdt_inv_sts_cd") == "I" || sheetObj.CellValue(i, "dmdt_inv_sts_cd") == "C") {
								if(sheetObj.CellValue(i, "dmdt_ar_if_cd") == "Y") {
									ComShowCodeMessage("DMT02002", "Invoice No.");
									return false;
								}
							}else{
								ComShowCodeMessage("DMT02002", "Invoice No.");
								return false;
							}
							
							//2010.03.19 - 100건 이상 처리 못함.
							selectedCnt++
							if(selectedCnt > 100){
								ComShowCodeMessage("DMT01141"); //Limited up to 100 invoices at a time
								return false;
							} 
						}
					}
					break;
    		}
        }

        return true;
    }	
	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		//Retrieve Setting
		ComSetObjValue(formObj.f_cmd, sAction);							//Command
		
	}
	
    /**
	 * IBSheet 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(ErrMsg == '') {
			var formObj = document.form;
			var fCmd = formObj.f_cmd.value;
			
			if(fCmd == SEARCH) {
				//check 해제
				sheetObj.CheckAll("chk_box") = 0;
				sheetObj.SumText(0, "seq") = "TTL";
				
				var invQty	= 0;
				var billAmt = 0;
				var taxAmt 	= 0;
				var payAmt 	= 0;

				//첫음 페이지 로딩시에 check를 해제 하므로서 아래 계산 로직이 필요 없어짐.. 그냥 디폴트 값으로 셋팅.
//				for(var i=sheetObj.TopRow; i <= sheetObj.SearchRows; i++) {
//				
//					//[로직] 각각의 Coincidence와 Discrepancy의 cntr의 갯수와 amt의 총계를 구함
//					billAmt += parseFloat(sheetObj.CellValue(i, "inv_chg_amt"));
//					taxAmt 	+= parseFloat(sheetObj.CellValue(i, "tax_amt"));
//					payAmt 	+= parseFloat(sheetObj.CellValue(i, "inv_amt"));
//					invQty	+= 1;
//					
//				} //End of the for loop
				
				formObj.inv_chg_amt.value	= ComAddComma2(ComRound(billAmt, 2)+'', "#,###.00");
				formObj.tax_amt.value 		= ComAddComma2(ComRound(taxAmt, 2)+'', "#,###.00");
				formObj.inv_amt.value 		= ComAddComma2(ComRound(payAmt, 2)+'', "#,###.00");
				formObj.inv_qty.value 		= invQty;

			}
		}
	}
	 
	//check all 2010.03.19 멀티 선택 사항 내용으로 변경 아래 모듈로 대체.
//    function sheet1_OnClick(sheetObj, row, col, Value){
//        if(sheetObj.ColSaveName(col) == "chk_box"){
//        	ComSyncAllCheck(sheetObj, col, Value);           
//        }
//    }	
	
    /**
     * IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event<br>
     * @param {sheetObj} String : 해당 IBSheet셀 명
     * @param {Row} Long : 해당 셀의 Row Index
     * @param {Col} Long : 해당 셀의 Column Index
     * @param {Value} String : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
     * @param {CellX} Long : 해당셀의 X좌표
     * @param {CellY} Long : 해당셀의 Y좌표
     * @param {CellW} Long : 해당셀의 가로 넓이값
     * @param {CellH} Long : 해당셀의 세로 높이값
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
        with(sheetObj) {
            if (ColSaveName(Col) != "chk_box") {
                // row클릭시 해당 Check Box도 체크
                // "/" 구분자로 연결하여 선택된 행번 가져오기, 결과:"3/4/5"
                var sRowStr = GetSelectionRows("/");
                var arr = sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {

                        if (CellEditable(arr[i], "chk_box")) {
                        	// 토글 기능
                        	if(CellValue(arr[i], "chk_box") == '0'){
                        		CellValue2(arr[i], "chk_box") = '1';
                        	} else {
                        		CellValue2(arr[i], "chk_box") = '0';
                        	}
            				
                        } //if (CellEditable(arr[i], "chk_box")) {
                    } //for (i=0; i<arr.length; i++) {
                    
                    // AllCheck box 상태 동기화
                    if (CheckedRows("chk_box") == RowCount) {
                    	HeadCheck(0, "chk_box") = true;
                    } else {
                    	HeadCheck(0, "chk_box") = false;
                    }
                }
            } else {
            	//Check box 클릭시  AllCheck box 상태 동기화 처리
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
                
		//toggle 후에 계산 로직 재처리.
 
        var invChgAmt 	= 0;
		var taxAmt 		= 0;
		var invAmt 		= 0;        
		
		var iCnt	= sheetObj.CheckedRows("chk_box");
		
		var chkRows = sheetObj.FindCheckedRow("chk_box").split("|");
        for(var i=0; i < chkRows.length-1; i++) {
			//Billing AMT
			invChgAmt 	= invChgAmt + parseFloat(sheetObj.CellValue(chkRows[i], "inv_chg_amt"));
			//Tax AMT
			taxAmt 		= taxAmt + parseFloat(sheetObj.CellValue(chkRows[i], "tax_amt"));
			//Payable AMT
			invAmt 		= invAmt + parseFloat(sheetObj.CellValue(chkRows[i], "inv_amt"));
        }
		
		ComSetObjValue(formObj.inv_chg_amt, DmtComSetComma(invChgAmt));
		ComSetObjValue(formObj.tax_amt, DmtComSetComma(taxAmt));
		ComSetObjValue(formObj.inv_amt, DmtComSetComma(invAmt));
		ComSetObjValue(formObj.inv_qty, iCnt);
		
    }  
	
   /**
    * Detail Sheet check box 클릭시 금액 계산
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnChange (sheetObj, Row, Col, Value) {
    	
    	var formObj 	= document.form;
        var invChgAmt 	= 0;
		var taxAmt 		= 0;
		var invAmt 		= 0;        
		
		var iCnt	= sheetObj.CheckedRows("chk_box");
		
		var chkRows = sheetObj.FindCheckedRow("chk_box").split("|");
        for(var i=0; i < chkRows.length-1; i++) {
			//Billing AMT
			invChgAmt 	= invChgAmt + parseFloat(sheetObj.CellValue(chkRows[i], "inv_chg_amt"));
			//Tax AMT
			taxAmt 		= taxAmt + parseFloat(sheetObj.CellValue(chkRows[i], "tax_amt"));
			//Payable AMT
			invAmt 		= invAmt + parseFloat(sheetObj.CellValue(chkRows[i], "inv_amt"));
        }
		
		ComSetObjValue(formObj.inv_chg_amt, DmtComSetComma(invChgAmt));
		ComSetObjValue(formObj.tax_amt, DmtComSetComma(taxAmt));
		ComSetObjValue(formObj.inv_amt, DmtComSetComma(invAmt));
		ComSetObjValue(formObj.inv_qty, iCnt);
		
//		var sName = sheetObj.ColSaveName(Col);
//		if(sName == "chk_box") {	//checkbox
//			if(Value == 1) {
//				alert(Row +":"+ Col +":"+ Value);
//				//Billing AMT
//				var invChgAmt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float")) + parseFloat(sheetObj.CellValue(Row, "inv_chg_amt"));
//				ComSetObjValue(formObj.inv_chg_amt, DmtComSetComma(invChgAmt));
//				
//				//Tax AMT
//				var taxAmt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tax_amt),"float")) + parseFloat(sheetObj.CellValue(Row, "tax_amt"));
//				ComSetObjValue(formObj.tax_amt, DmtComSetComma(taxAmt));
//				
//				//Payable AMT
//				var invAmt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.inv_amt),"float")) + parseFloat(sheetObj.CellValue(Row, "inv_amt"));
//				ComSetObjValue(formObj.inv_amt, DmtComSetComma(invAmt));
//				
//			} else if(Value == 0) {
//				alert(Row +":"+ Col +":"+ Value);
//				//Billing AMT
//				var invChgAmt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.inv_chg_amt),"float")) - parseFloat(sheetObj.CellValue(Row, "inv_chg_amt"));
//				ComSetObjValue(formObj.inv_chg_amt, DmtComSetComma(invChgAmt));
//				
//				//Tax AMT
//				var taxAmt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.tax_amt),"float")) - parseFloat(sheetObj.CellValue(Row, "tax_amt"));
//				ComSetObjValue(formObj.tax_amt, DmtComSetComma(taxAmt));
//				
//				//Payable AMT
//				var invAmt 	= parseFloat(ComGetUnMaskedValue(ComGetObjValue(formObj.inv_amt),"float")) - parseFloat(sheetObj.CellValue(Row, "inv_amt"));
//				ComSetObjValue(formObj.inv_amt, DmtComSetComma(invAmt));
//			}
//			
//			var iCnt = 0;
//			for(var i=sheetObj.TopRow; i <= sheetObj.SearchRows; i++) {
//				if(sheetObj.CellValue(i,"chk_box") == 1) {
//					iCnt++;
//				}
//			}
//			ComSetObjValue(formObj.inv_qty, iCnt);
//			
//		}
	}  
	
//    function DmtComSetComma(data){
//    	return ComAddComma2(ComRound(data, 2)+'' ,"#,###.00");
//    }
    // 숫자에 , 포맷 셋팅 : ComAddComma2(ComRound(totAmt, 2)+'', "#,###.00");
	function setComma(){
    	var formObj = document.form;

    	var invChgAmt	= ComAddComma2(ComRound(ComGetObjValue(formObj.inv_chg_amt), 2)+'' ,"#,###.00");
		var taxAmt		= ComAddComma2(ComRound(ComGetObjValue(formObj.tax_amt), 2)+''     ,"#,###.00");
		var invAmt		= ComAddComma2(ComRound(ComGetObjValue(formObj.inv_amt), 2)+''     ,"#,###.00");
		
		ComSetObjValue(formObj.inv_chg_amt, invChgAmt);
		ComSetObjValue(formObj.tax_amt, taxAmt);
		ComSetObjValue(formObj.inv_amt, invAmt);
    	
    }
	
	/*
	 * 더블클릭 팝업(5003)
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		
		openPopupWindow(sheetObj, document.form, "btn_detail");
	}
	
	/**
	 * 팝업 호출
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		
		 if (srcName == "btn_detail") {
 			var invTpCd = sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_inv_tp_cd");
 			
 			if (invTpCd == "M") {
 				//4004
 				var url = "EES_DMT_4004P.do"
 					+"?dmdt_inv_no="+sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_inv_no")
 					+"&caller=5003";
 				var returnValue = ComOpenWindowCenter(url, "EES_DMT_4004P", "1036","738", true);
 				if (returnValue == "Y") {
					//처리 완료 후 재조회
					ComSetObjValue(formObj.chk_hold, "Y");
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				} 				
 			}
 			else {
 				//4002
 				var url = "EES_DMT_4002.do"
 					+"?group_by=1"
 					+"&chg_type="
 					+"&ofc_cd="+ComGetObjValue(formObj.ofc_cd)
 					+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
 					+"&dmdt_trf_cd="+sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_trf_cd") 
 					+"&invoice_no="+sheetObj.CellValue(sheetObj.SelectRow,  "dmdt_inv_no")
 					+"&cntr_no="
 					+"&invoice_issue=2"	
 					;
 				var returnValue = ComOpenWindowCenter(url, "EES_DMT_4002", EES_DMT_4002_WIDTH, EES_DMT_4002_HEIGHT, true);
 				if (returnValue == "Y") {
					//처리 완료 후 재조회
					ComSetObjValue(formObj.chk_hold, "Y");
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
 			} 
		 }// End of the "btn_detail" action
		 else if(srcName == "btn_hold") {
			var dmdtInvNo = "";
			for(var i=1; i <= sheetObj.RowCount; i++) {
				//alert(sheetObj.CellValue(i, "chk_box")+"|"+sheetObj.CellValue(i,  "dmdt_inv_no"));
				if(sheetObj.CellValue(i, "chk_box") == "1"){
					dmdtInvNo += ","+sheetObj.CellValue(i,  "dmdt_inv_no");
				}			
			}
			dmdtInvNo = dmdtInvNo.substring(1);
			if(dmdtInvNo == ''){
				ComShowCodeMessage('DMT00140', 'invoice');  
     			return;
			}
//			alert(dmdtInvNo);
			ComOpenPopupWithTarget('/hanjin/EES_DMT_5101.do?invoiceNo='+dmdtInvNo, 540, 400, "", "0,1,1,1,1,1,1", true);
		 }
	} 
   /**
	* Hold 권한 대상 - 로그인 오피스코드와 동일할 경우에만 Hold 버튼 활성화 및 처리가능.
	* @param ofcCd
	* @return boolean
	*/ 
	function holdAuthority(ofcCd){
		//권한 대상
		var props   = new Array("SELCON", "NYCRAO", "NYCRA");//SELCON/NYCRAO/NYCRA 
		for(var j=0; j<props.length; j++){
			 if(ofcCd == props[j]){
				 return true;
			 }
		}
//		return true; //테스트 시 사용.
		return false;
	}
	/* 개발자 작업  끝 */