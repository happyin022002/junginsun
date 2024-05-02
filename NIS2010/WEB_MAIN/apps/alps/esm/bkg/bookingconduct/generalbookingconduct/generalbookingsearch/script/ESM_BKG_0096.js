/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0096.js
*@FileTitle : Yard Assign by CNTR
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.28 최영희
* 1.0 Creation
*----------------------------------------------------------
* History
* 2010.09.07 김영철 [CHM-201005693-01] Booking Fax/EDI - Yard Assign by CNTR 수정 요청 (PSA EDI 관련)
* 									 Booking Copy, Cancel 시에 자동전송되도록 수정요청.
* 2010.10.07 김영철 [] P/UP CY와 TP/SZ가 동일하면 아래 메세지를 보여주도록 함.
*  - [BKG06124]Please input data in one row for same TP/SZ and P/UP CY
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
     * @class ESM_BKG_0096 : ESM_BKG_0096 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0096() {
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
var arrTpSz = new Array();
var arrQty = new Array();
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
        var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
    	try {
			switch(srcName) {
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				
				case "btn_close":
					window.close();
				break;
				
				case "btn_add":
					sheetObject1.DataInsert(-1);
					sheetObject1.CellValue(sheetObject1.Rows-1, "bkg_no") = formObject.bkg_no.value;					
				break;
				
				case "btn_delete":
					ComRowHideDelete(sheetObject1, "chk");
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
					style.height = 160;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel.|TP/SZ|Q'ty|P/Up CY|BKG_NO|BKG_SEQ|PSA_SER_NO|SUB_PSA_SER_NO|PSA_IF_CD";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
													
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++ , dtHiddenStatus,	10,		daCenter,	true,		"ibflag");
					InitDataProperty(0,		cnt++ , dtCheckBox,	40,			daCenter,	true,		"chk",				false,		"",		dfNone,					0,		true,		true);
					InitDataProperty(0,		cnt++ , dtData,	    80,			daCenter,	true,		"cntr_tpsz_cd",     false,		"",		dfEngUpKey,				0,		false,		true,   2);
					InitDataProperty(0,		cnt++ , dtData,		120,		daCenter,	true,		"cntr_qty",			true,		"",		dfFloat,				2,		false,		true);
					InitDataProperty(0,		cnt++ , dtData,		180,		daCenter,	true,		"yd_cd",   		 	true,		"",		dfEngUpKey,				0,		true,		true,   7);
					InitDataProperty(0,		cnt++ , dtHidden,	0,			daCenter,	true,		"bkg_no",   		false,		"",		dfEngUpKey,				0,		true,		true,   7);
					InitDataProperty(0,		cnt++ , dtHidden,	0,			daCenter,	true,		"bkg_seq",  		false,		"",		dfEngUpKey,				0,		true,		true,   7);
					InitDataProperty(0,		cnt++ , dtHidden,	0,			daCenter,	true,		"psa_ser_no",  		false,		"",		dfEngUpKey,				0,		true,		true,   7);
					InitDataProperty(0,		cnt++ , dtHidden,	0,			daCenter,	true,		"sub_psa_ser_no",  	false,		"",		dfEngUpKey,				0,		true,		true,   7);
					InitDataProperty(0,		cnt++ , dtHidden,	0,			daCenter,	true,		"psa_if_cd",  		false,		"",		dfEngUpKey,				0,		true,		true,   7);

				}
			break;


		}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var params = FormQueryString(formObj);
				params = params  + "&" + ComGetSaveString(sheetObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0096GS.do", params);
				sheetObj.Redraw = false;    
			    sheetObj.LoadSearchXml(sXml);  
			    sheetObj.Redraw = true;
				setFormData(formObj, sheetObj);
				ComOpenWait(false);
			break;
			
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = MULTI;
				var params = ComGetSaveString(sheetObj, true, true);
				if (params.length > 0) {
					params = "f_cmd="+MULTI+"&"+params; 
					if (params)
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0096GS.do", params);
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					ComOpenWait(false);
					if(State == "S") {
						setParentToSheet(sheetObj);
					}else{
						sheetObj.LoadSearchXml(sXml);
					}				
				}
			break;
				 
					
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    		case IBSAVE:
    			var cntrSheet = sheetObjects[0];
    			var cntrCount = cntrSheet.RowCount + 1;
    			for (ir = 1; ir < cntrCount; ir++) {
    				if (ComTrim(sheetObj.CellValue(ir, "ibflag")) != 'D') {
						if (ComTrim(sheetObj.CellValue(ir, "cntr_tpsz_cd")) == '') {
							ComShowMessage(ComGetMsg("BKG01101", "TP/SZ"));
							return false;
						}
						if (ComTrim(sheetObj.CellValue(ir, "cntr_qty")) == '0') {
							ComShowMessage(ComGetMsg("BKG01101", "Qty"));
							return false;
						}
						if (ComTrim(sheetObj.CellValue(ir, "yd_cd")) == '') {
							ComShowMessage(ComGetMsg("BKG01101", "P/UP CY"));
							return false;
						}
    				}
				}

    			for (i = 1; i < cntrCount; i++) {
					if (ComTrim(sheetObj.CellValue(i, "ibflag")) != 'D') {
						for (j = 1; j < cntrCount; j++) {
							if (ComTrim(sheetObj.CellValue(j, "ibflag")) != 'D') {
								if (ComTrim(sheetObj.CellValue(i, "cntr_tpsz_cd")) == ComTrim(sheetObj.CellValue(j, "cntr_tpsz_cd")) 
								 && ComTrim(sheetObj.CellValue(i, "yd_cd")) == ComTrim(sheetObj.CellValue(j, "yd_cd")) && i != j ) {
									ComShowMessage(ComGetMsg("BKG06124"));
									return false;
								}
							}
	    				}
					}    				
    			}
    			
    			break;
    		}
    	}
        return true;
    }

    /*
	* Data를 Form에 대입
	*/
	function setFormData(formObj,sheetObj){
		ComSetObjValue(formObj.bkg_no,sheetObj.EtcData("bkg_no"));
		ComSetObjValue(formObj.bkg_qty,sheetObj.EtcData("bkg_qty"));
		ComSetObjValue(formObj.yd_cd,sheetObj.EtcData("yd_cd"));
		
		with(sheetObj){
			for(var iRow=1;iRow<Rows;iRow++){ 
				arrTpSz[iRow-1]= CellValue(iRow,"cntr_tpsz_cd");
				arrQty[iRow-1]= CellValue(iRow,"cntr_qty");
			}
			 
		}
		
	}

	/*
	* Popup sheet내용을 Main sheet으로 돌려준다
	*/
	function setParentToSheet(sheetObj){
		var formObj = document.form;
		var parentObj = window.dialogArguments.document.form;
		var parentRefSheet = eval(window.dialogArguments.sheetObjects[formObj.callSheetIdx.value]);
		if (parentObj) {
			with(sheetObj){
				parentRefSheet.RemoveAll();
				for(var iRow=1;iRow<Rows;iRow++){
					parentRefSheet.DataInsert(-1);
					parentRefSheet.CellValue2(iRow,"cntr_tpsz_cd")=CellValue(iRow,"cntr_tpsz_cd");
					parentRefSheet.CellValue2(iRow,"op_cntr_qty")=CellValue(iRow,"cntr_qty");
					parentRefSheet.CellValue2(iRow,"full_rtn_yd_cd")=CellValue(iRow,"yd_cd");
				}
			}
		}

		window.close();
		var calllFunc = formObj.calllFunc.value;
		if(calllFunc != ''){
			eval('window.dialogArguments.'+calllFunc)();
		}

	}
    
	/*
	* Sheet1 OnAfterEdit 이벤트 처리
	*/
	function sheet1_OnAfterEdit(sheetObj,Row,Col){
//	    var sTpSz=false;
//		with(sheetObj){
//			for(var idx=0;idx<arrTpSz.length;idx++){ 
//				if (arrTpSz[idx]==CellValue(Row,"cntr_tpsz_cd")){
//					sTpSz=true;
//					if (qtyCheck(sheetObj,arrTpSz[idx],arrQty[idx])){
//						ComShowCodeMessage("BKG00642");
//						break;
//					}
//				}
//			}
//			if (!sTpSz){
//				ComShowCodeMessage("BKG00062");
//				CellValue2(Row,"cntr_tpsz_cd")="";
//			}
//		}
//		 
	}
	
	/*
	* Tp/Sz에 대한 Qty 수량 체크
	*/
	function qtyCheck(sheetObj,cntrTpSz,qty){
		var bFlag=false;
		var fQty=qty;
		with(sheetObj){
			for(var iRow=1;iRow<Rows;iRow++){
				if (cntrTpSz==CellValue(iRow,"cntr_tpsz_cd")){
					fQty=ComRound(fQty)-ComRound(CellValue(iRow,"cntr_qty"));
					if (ComRound(fQty)<0){ 
						CellValue2(iRow,"cntr_qty")=0;
						bFlag=true;
						break;
					}
				}
			}
		}
		return bFlag
	}
	
	/* 개발자 작업  끝 */