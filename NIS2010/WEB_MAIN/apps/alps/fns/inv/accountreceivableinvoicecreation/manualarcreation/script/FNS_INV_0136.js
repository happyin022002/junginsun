/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FNS_INV_0136.js
*@FileTitle : China Region VAT Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.27
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.27 임옥영
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
     * @class FNS_INV_0136 : FNS_INV_0136 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0136() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
//    	this.sheet1_OnClick         = sheet1_OnClick;
    	this.sheet1_OnChange        = sheet1_OnChange;
    }
    
   	/* 개발자 작업	*/
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	
    var ROWMARK = "|";
    var FIELDMARK = "^";

	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			
				case "btn_Import":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break;
				
				case "btn_Validate":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
		
				case "btn_New": 
					sheetObject.Reset();
					initSheet(sheetObject,1); 
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}


    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function loadPage() {
		//데이터 로딩시 curr_cd 세팅
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);

		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);			
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

     }

	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		var cnt = 0;
		switch(sheetNo) {
					
			case 1:      //sheet1 init
					with (sheetObj) {
				
						//높이 설정
						style.height = 440;
						//전체 너비 설정
						SheetWidth =  mainTable.clientWidth;
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msNone;
		
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
					
						var HeadTitle = "Sts|check|SEQ|BL No|AR Office|Customer|Rev\nType|Rev\nSource|LCL VVD|SCOPE|Bound|POL|POD|Charge|Currency|Rate|Rate as|Per|Amount	|Validation\nResult|Sailing Dt|Sail Arr Dt|Eff Dt|Due Dt" +
								"|CustCntCd|CustSeq|UserId|UserNm|CityCd|LocalTime|SvrId" + 
								"|crTermDys|custCrFlg|invCustCntCd|invCustSeq|subsCoCd|xchRtN3rdTpCd|xchRtUsdTpCd|xchRtDt|usdXchRt|invXchRt|invXchRtDt|acctXchRtYrmon|invCoaRgnCd|invCoaCtrCd|revCoaAcctCd"	;
		
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 1, 1, 500, 500);
		
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
		
						//해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, true, true, false, false);
		
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, false);
		
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,     daCenter,  false,  "ibflag");
						InitDataProperty(0, cnt++ , dtCheckBox,  40,   	daCenter,  false,   "check",		   				false,    "",    dfNone, 		0,     true,       true);
						InitDataProperty(0, cnt++ , dtSeq,    		40,   	daCenter,  true,   "seq",		   				false,    "",    dfInteger, 	0,     false,      false,	3);
						//필수입력항목bl_no, ar_ofc_cd, cust_code,trf_rt_amt
						InitDataProperty(0, cnt++ , dtData,    		90,   	daLeft, 		true,   "bl_no",					false,    "",    dfNone, 		0,     true,       true,	12,	false);
						InitDataProperty(0, cnt++ , dtData,    		60,   	daLeft,  		true,   "ar_ofc_cd",  			false,    "",    dfNone, 		0,     true,       true,	6);
						InitDataProperty(0, cnt++ , dtData,    		70,   	daLeft,  		true,   "cust_code", 				false,    "",    dfNone, 		0,     true,       true,	8);
						InitDataProperty(0, cnt++ , dtData,    		40,   	daLeft,  		true,   "rev_tp_cd",  			false,    "",    dfNone, 		0,     false,      false,	1,		true);
						InitDataProperty(0, cnt++ , dtComboEdit, 50,   	daLeft,		true,   "rev_src_cd",				false,    "",    dfNone, 		0,     true,       true,	2, 		true);
						InitDataProperty(0, cnt++ , dtData,    		70,   	daLeft, 		true,   "lcl_vvd",					false,    "",    dfNone, 		0,     true,       true,	9, 		true);
						InitDataProperty(0, cnt++ , dtData,    		50,   	daLeft,  		true,   "svc_scp_cd",			false,    "",    dfNone, 		0,     false,      false	,3, 	true);
						InitDataProperty(0, cnt++ , dtData,    		40,   	daLeft,  		true,   "io_bnd_cd",				false,    "",    dfNone, 		0,     false,      false,	1, 		true);
						InitDataProperty(0, cnt++ , dtData,    		50,   	daLeft,  		true,   "pol_cd",					false,    "",    dfNone, 		0,     false,      false,	5, 		true);
						InitDataProperty(0, cnt++ , dtData,    		50,   	daLeft,  		true,   "pod_cd",					false,    "",    dfNone, 		0,     false,      false,	5, 		true);
						InitDataProperty(0, cnt++ , dtData,    		50,   	daLeft,  		true,   "chg_cd",					false,    "",    dfNone, 		0,     false,      false,	3, 		true);
						InitDataProperty(0, cnt++ , dtComboEdit, 60,   	daLeft,  		true,   "lcl_curr",					false,    "",    dfNone, 		0,     true,       true,	3);
						InitDataProperty(0, cnt++ , dtData,    		100,  daLeft,  		true,   "trf_rt_amt",				false,    "",     dfFloat, 		3,     true,       true,	18);
						InitDataProperty(0, cnt++ , dtData,    		50,   	daLeft,  		true,   "rat_as_cntr_qty",		false,    "",    dfNone, 		0,     false,      false, 	1);
						InitDataProperty(0, cnt++ , dtData,    		50,   	daLeft,  		true,   "per_tp_cd",				false,    "",    dfNone, 		0,     false,      false, 	1);
						InitDataProperty(0, cnt++ , dtData,    		100,  	daLeft,  		true,   "chg_amt",				false,    "|trf_rt_amt|*|rat_as_cntr_qty|",    dfFloat, 3, false,  false,18);
						InitDataProperty(0, cnt++ , dtData,    		120,  daLeft,  		true,   "error_msg",				false,    "",    dfNone, 		0,     true,      true);
						//
						InitDataProperty(0, cnt++ , dtData,    		90,   	daLeft,  		true,   "sailing_dt",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtData,    		90,   	daLeft,  		true,   "sail_arr_dt",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtData,    		90,   	daLeft,  		true,   "eff_dt",					false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtData,    		90,   	daLeft,  		true,   "due_dt",					false,    "",    dfNone, 		0,     false,      false);
						//Hidden |CustCntCd|CustSeq|UserId|UserNm|CityCd|LocalTime|SvrId
						

						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "cust_cnt_cd",			false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "cust_seq",				false,    "",    dfInteger, 	0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "user_id",					false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "user_nm",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "city_cd",					false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "local_time",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "svr_id",					false,    "",    dfNone, 		0,     false,      false);
						//Hidden |crTermDys|custCrFlg|invCustCntCd|invCustSeq|subsCoCd|xchRtN3rdTpCd|xchRtUsdTpCd	|xchRtDt	|usdXchRt|invXchRt|invXchRtDt|acctXchRtYrmon|invCoaRgnCd|invCoaCtrCd|revCoaAcctCd
						
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "cr_term_dys",			false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "cust_cr_flg",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "inv_cust_cnt_cd",		false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "inv_cust_seq",			false,    "",    dfInteger, 	0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "subs_co_cd",			false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "xch_rt_n3rd_tp_cd",	false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "xch_rt_usd_tp_cd",	false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "xch_rt_dt",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "usd_xch_rt",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "inv_xch_rt",				false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "inv_xch_rt_dt",			false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "acct_xch_rt_yrmon",	false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "inv_coa_rgn_cd",		false,    "",    dfNone, 		0,     false,      false);
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "inv_coa_ctr_cd",		false,    "",    dfNone, 		0,     false,      false);	
						InitDataProperty(0, cnt++ , dtHidden,    		50,   	daLeft,  		true,   "rev_coa_acct_cd",	false,    "",    dfNone, 		0,     false,      false);				
	                    
						sheetObj.Rows = 501;
						WaitImageVisible = false;
		                CountPosition = 4;		                
		                
		                InitDataCombo(0, "rev_src_cd", "IV|IC", "IV|IC", "IV");
		                InitDataCombo(0, "lcl_curr", document.form.curr_combo_name.value.substring(1), document.form.curr_combo_value.value.substring(1), "CNY","CNY");
		                
		                InitDataValid(0, "bl_no", vtEngUpOther, "1234567890");
	                    InitDataValid(0, "cust_code", vtEngUpOther, "1234567890");
	                    InitDataValid(0, "ar_ofc_cd", vtEngUpOnly); //ar_ofc_cd
	                    
	        			InitDataValid(0,    "chg_cd",   vtEngUpOther, "1234567890/");
	        			InitDataValid(0,    "per_tp_cd",   vtEngUpOther, "1234567890");
	        			
	        			hColor = RgbColor(191,239,255);
	        			// 191;239;255
	        			// 0,255,255

	        			CellBackColor(0, "bl_no") = hColor;
	        			CellBackColor(0, "cust_code") = hColor;
	        			CellBackColor(0, "ar_ofc_cd") = hColor;
	        			CellBackColor(0, "trf_rt_amt") = hColor;
	        			//CellFontColor(0, "trf_rt_amt") = hColor;

			}
				break;
		}
	}

	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeyPress();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objKeyPress() {
		switch(event.srcElement.dataformat){
		case "float":
			// 숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, "."); break;
	
		case "int":
			// 숫자만 입력하기
			ComKeyOnlyNumber(event.srcElement); break;
	
		case "engup":
	
			switch(event.srcElement.name){
	
			case "cust_cnt_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('upper'); break;		
	
			case "lcl_vvd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "svc_scp_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('upper'); break;	
	
			case "trunk_vvd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "por_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "pol_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "pod_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "del_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "bl_no":
				//영문대문자+숫자입력하기
				ComKeyOnlyAlphabet('uppernum'); 
	
				break;
			case "mst_if_no" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
				
			}
	
			break;              
	
		default:
			//숫자만입력하기
			//ComKeyOnlyNumber(event.srcElement);
		}
	}     
  	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	}

	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
		case IBSEARCH_ASYNC01: // cur_cd 조회하여 form에 세팅.
			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0136GS.do", FormQueryString(formObj));
			addCellComboItem(sheetObj,ComGetEtcData(sXml, "currInfo"),"lcl_curr",true);	
			ComBtnDisable("btn_Save");
			break;	

		case IBLOADEXCEL:		//엑셀 업로드
			
			sheetObj.LoadExcel(-1, 1, "", -1, 502, "", false);
			sheetObj.Redraw=false;
			importEnd(sheetObj);
			sheetObj.Redraw=true;
			sheetObj.SelectCell(1,2);
			ComBtnDisable("btn_Save");
			
 			break;
 			
		case IBSEARCH:      //조회

			formObj.f_cmd.value = SEARCHLIST;
            var dupchk = sheetObj.ColValueDupRows("bl_no", true, false, 1, sheetObj.rowCount); //중복된 모든 BL 찾는다.

            if(dupchk.length > 0){
            	ComShowCodeMessage("COM12115", "BL No " + dupchk+"row");
            	
            	var s_data =dupchk;  // 잘라야 되는 값..
            	var array_data = s_data.split(",");  // split 함수사용
            	var dup_row = "";

            	//중복 BL check 해제
    			for (var i = 0; i < array_data.length; i++) {
    				dup_row = array_data[i].split(",");  				
    			    //행의 배경색을 회색으로 설정한다.
    				sheetObj.RowBackColor(dup_row) = sheetObj.RgbColor(192,192,192);  				
    				sheetObj.CellValue(dup_row, "check") = "D";
    			}
    			
//            	break;
            }
            
            if(!validateForm(sheetObj,formObj,sAction)) 
            break;

            // 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.DoSave("FNS_INV_0136GS.do", FormQueryString(formObj), "check", false);
			ComOpenWait(false)
			afterValidate(sheetObj);
            
			break;
            
		case IBSAVE:      //Creation
            formObj.f_cmd.value = MULTI;
            if(!validateForm(sheetObj,formObj,sAction)) return false;
            // 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var result = sheetObj.DoSave("FNS_INV_0136GS.do", FormQueryString(formObj), "check", true);
			//sheetObj.DoAllSave("FNS_INV_0136GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			ComBtnDisable("btn_Save");

			ComShowCodeMessage("INV00051");
			
            break;	
         }
     }

	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author 임옥영
	 * @version 2013.09.23
	 */
     function validateForm(sheetObj,formObj,sAction){    	 
    	var rtvalue = true;

    	with(sheetObj){ 
    		
        	//체크박스가 체크된 행번호
        	var iCheckRow = sheetObj.FindCheckedRow("check");
        	var arrRow = iCheckRow.split("|"); 
        	var blNo = "";
        	var check = "0";
        	var custCode = sheetObj.CellValue(i, "cust_code");
        	
        	if(arrRow.length>1) {      		   		
	        	for(idx=0; idx<arrRow.length-1; idx++){//
	       			var i = arrRow[idx];
	       			blNo = sheetObj.CellValue(i, "bl_no");			
		       		//ComShowCodeMessage("INV00073"), INV00004 mandatory
		 			//Mandantoyr 항목 검증 bl_no, ar_ofc_cd, cust_code,trf_rt_amt
	   	    		if(blNo == "" ) {
		 				//ComShowCodeMessage("INV00168");
		 				ComShowCodeMessage("COM130201", "BL No");
		 				sheetObj.SelectCell(i, "bl_no", false);
		 				rtvalue = false;
		 				break;
		 			}  else if(blNo.length > 12) {
	 					ComShowCodeMessage("COM131901", "BL No");
		 				sheetObj.SelectCell(i, "bl_no", false);
		 				rtvalue = false;
		 				break;
	 				} else if(sheetObj.CellValue(i, "ar_ofc_cd") == "" ) {
		 				//ComShowCodeMessage("INV00168");
		 				ComShowCodeMessage("COM130201", "AR\nOffice");
		 				sheetObj.SelectCell(i, "ar_ofc_cd", false);
		 				rtvalue = false;
		 				break;
		 			}  else if(custCode == "" ) {
		 				//ComShowCodeMessage("INV00144");
		 				ComShowCodeMessage("COM130201", "Actual Customer Code");
		 				sheetObj.SelectCell(i, "cust_code", false);
		 				rtvalue = false;
		 				break;
		 			}   else if(custCode.length < 8 ) {
		 				//ComShowCodeMessage("INV00144");
		 				ComShowCodeMessage("COM131901", "Actual Customer Code");
		 				sheetObj.SelectCell(i, "cust_code", false);
		 				rtvalue = false;
		 				break;
		 			} else if(sheetObj.CellValue(i, "trf_rt_amt") == 0 ) {
		 				//ComShowCodeMessage("INV00162");
		 				ComShowCodeMessage("COM130201", "Rate");
		 				sheetObj.SelectCell(i, "trf_rt_amt", false);
		 				rtvalue = false;
		 				break;
		 			} else {
		 				rtvalue = true;
		 			}
	   	    		
	       		}
       		} else {
       			ComShowCodeMessage("COM12114", "Check box");
 				sheetObj.SelectCell(1, "check", false);
 				rtvalue = false;
       		}
      	}
      	return rtvalue;
	 }

//  	/** 
//  	 * sheet1 조회후 User Name 세팅 <br>
//  	 * <br><b>Example :</b>
//  	 * <pre>
//  	 * </pre>
//  	 * @param  {IBSheet} sheetObj : 시트오브젝트  
//  	 * @param  ErrMsg: ErrMsg 
//  	 * @return true, false
//  	 * @see #
//  	 * @author 임옥영
//  	 * @version 2013.09.23
//  	 */
// 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
//	}
 	
 	/** 
  	 * sheet1 import 후 BL No, AR Office, Actual Customer, Rate 미 입력시 Error <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param  {IBSheet} sheetObj : 시트오브젝트  
  	 * @see #
  	 * @author 임옥영
  	 * @version 2013.09.23
  	 */
 	function importEnd(sheetObj) { 		 
		if(sheetObj.ROWCount > 500) {//업로드된 데이터가 500개가 넘으면 에러
			ComShowCodeMessage('INV00172');
			sheetObj.Reset();
			initSheet(sheetObj,1);//ibsheet 초기화			
		} else if(sheetObj.ROWCount <= 500){//업로드된 데이터가 500개가 안되면 나머지 채워줌
			setDefaultDatas(sheetObj);
//			for( i=sheetObj.ROWCount;i <500;i++) {
//				sheetObjects[0].DataInsert(-1);
//			}
		}		
	}
 	
 	/** 
  	 * sheet1 import 후 Default Value Setting <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param  {IBSheet} sheetObj : 시트오브젝트  
  	 * @see #
  	 * @author 임옥영
  	 * @version 2013.09.23
  	 */
 	function setDefaultDatas(sheetObj){
 		for(i=1; i<=sheetObj.ROWCount;i++){
 			if(sheetObj.CellValue(i, "bl_no") != ""){
 				setDefaultData(sheetObj, i);
 			}
 		}
 		
 	}

 	/** 
  	 * 한 row의  Default Value Setting <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param  {IBSheet} sheetObj : 시트오브젝트  
  	 * @param  row : row  
  	 * @see #
  	 * @author 임옥영
  	 * @version 2013.09.23
  	 */
 	function setDefaultData(sheetObj, row) {
			//rev_tp_cd = "M",rev_src_cd="IV" lcl_vvd=' ', svc_scp_cd="IAA" io_bnd_cd = 'O', chg_cd='TVA', lcl_curr='CNY',rat_as_cntr_qty=1 per_tp_cd='BL'
			if(sheetObj.CellValue(row, "rev_tp_cd") == "" ) sheetObj.CellValue2(row, "rev_tp_cd") = "M";
			if(sheetObj.CellValue(row, "rev_src_cd") == "" ) sheetObj.CellValue2(row, "rev_src_cd") = "IV";
			//if(sheetObj.CellValue(i, "lcl_vvd") == "" ) sheetObj.CellValue2(i, "lcl_vvd") = " "; 화면구동값???
			if(sheetObj.CellValue(row, "svc_scp_cd") == "" ) sheetObj.CellValue2(row, "svc_scp_cd") = "IAA"; 
			if(sheetObj.CellValue(row, "io_bnd_cd") == "") sheetObj.CellValue2(row, "io_bnd_cd") = "O";
			if(sheetObj.CellValue(row, "chg_cd") == "" ) sheetObj.CellValue2(row, "chg_cd") = "TVA";
			if(sheetObj.CellValue(row, "lcl_curr") == "" ) sheetObj.CellValue2(row, "lcl_curr") = "CNY";
			if(sheetObj.CellValue(row, "rat_as_cntr_qty") == "") sheetObj.CellValue2(row, "rat_as_cntr_qty") = "1";
			if(sheetObj.CellValue(row, "per_tp_cd") == "" ) sheetObj.CellValue2(row, "per_tp_cd") = "BL";
			//Hidden값 세팅 user_id, user_nm
			sheetObj.CellValue2(row, "user_id") = document.form.user_id.value;
			sheetObj.CellValue2(row, "user_nm") = document.form.user_nm.value;		
			
			var tmpCust = sheetObj.CellValue(i, "cust_code");
			var tmpSeq = "";
			var tmpCd = ""; 
			
			if(tmpCust != "") {
				tmpCd = tmpCust.substring(0, 2);				
				if(tmpCust.length<8){//8자리 이하의 경우 customer seq를 6자리로 맞춰준다.
					tmpSeq = ComLpad( tmpCust.substring(2), 6, "0");
				} else tmpSeq = tmpCust.substring(2);
				
				sheetObj.CellValue2(row, "cust_code") = tmpCd + tmpSeq;
				sheetObj.CellValue2(row, "cust_cnt_cd") = tmpCd;
				sheetObj.CellValue2(row, "cust_seq") = tmpSeq;
				sheetObj.CellValue2(row, "inv_cust_cnt_cd") = tmpCd;
				sheetObj.CellValue2(row, "inv_cust_seq") = tmpSeq;
			}
 	}
	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     addCellComboItem(sheetObj,comboValues,colName,isCellCombo);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} comboValues combo 로 생성할 values
	 * @param {String} colName combo 가 위치할 GRID 내 column 명
	 * @param {String} isCellCombo  일반 combo 와 cell combo 구분 flag 
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
	
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
	
				if (comboItem[0] != "") {
					comboTxt += comboItem[0];
					//comboVal += comboItem[0];
					if (comboItem[1] != undefined) {
						comboVal += comboItem[0] +"^"+ comboItem[1];
					} else {
						comboVal += comboItem[0];
					}
	
				}
	
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		document.form.curr_combo_name.value = comboTxt;
		//document.form.curr_combo_value.value = comboVal;	
		document.form.curr_combo_value.value = comboTxt;
	}	
	
	
	/**
	 * 업무 자바스크립트 OnChange 이벤트 Catch <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    
	 * </pre>
	 * @param sheetObj sheetObj
	 * @param Row Row
	 * @param Col Col
	 * @param Value Value
	 * @return 없음
	 * @author 정휘택
	 * @version 2013.10.2
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
		if(sheetObj.ColSaveName(Col)=="bl_no") {			
			setDefaultData(sheetObj, Row);
			sheetObj.SelectCell(Row, "bl_no", false);
		} else if(sheetObj.ColSaveName(Col)=="cust_code"){//customer code 변경시 hidden값 변경
			
			var tmpCust = sheetObj.CellValue(Row, Col);
			var tmpSeq = "";
			var tmpCd = ""; 
					
			if(tmpCust != "") {
				tmpCd = tmpCust.substring(0, 2);
				
				if(tmpCust.length<8){//8자리 이하의 경우 customer seq를 6자리로 맞춰준다.
					tmpSeq = ComLpad( tmpCust.substring(2), 6, "0");
				} else tmpSeq = tmpCust.substring(2);
				
				sheetObj.CellValue2(Row, "cust_code") = tmpCd + tmpSeq;
				sheetObj.CellValue2(Row, "cust_cnt_cd") = tmpCd;
				sheetObj.CellValue2(Row, "cust_seq") = tmpSeq;
				sheetObj.CellValue2(Row, "inv_cust_cnt_cd") = tmpCd;
				sheetObj.CellValue2(Row, "inv_cust_seq") = tmpSeq;
			}
		}
	}
    
	/**
	 * Validate후에 결과에 따라 체크박스 선택 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    
	 * </pre>
	 * @param sheetObj sheetObj
	 * @return 없음
	 * @author 임옥영
	 * @version 2013.10.2
	 */
	function afterValidate(sheetObj){
//		sheetObj.CheckAll2("check") = "1";
		var errMsg = "";
		for(i=1;i<=sheetObj.ROWCount;i++) {
			if(sheetObj.CellValue(i, "bl_no") != "") {
				errMsg = sheetObj.CellValue(i, "error_msg");
				if(errMsg == ""){
					sheetObj.CellValue2(i, "check") = "1";
					ComBtnEnable("btn_Save");
				} else {
					sheetObj.CellValue2(i, "check") = "0";
					ComBtnEnable("btn_Save");
				}
			}
		}
	}
/* 개발자 작업  끝 */