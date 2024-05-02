/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_10.js
*@FileTitle : S/C Proposal Special Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.09 최성민
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2011.01.14 최성민 [CHM-201108327-01] Item 중복체크시 Amend Delete 된 Row 는 중복에서 제외
* 2013.07.01 전윤주 [CHM-201325096] S/C Conversion 신규 Rule Code 생성 요청 - FAR, FAD Rule code 신규 생성
* 2013.10.16 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
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
     * @class ESM_PRI_0003_10 : ESM_PRI_0003_10 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0003_10() {
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

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	
	var sChgCdVisiable = "";	//SHEET에서 보여줄 CHARGE COMBO 코드리스트 
	
	var amendSaveFlag = false; //AMEND처리후 CONVERSION 팝업클릭시 저장메세지 호출하기 위함.
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
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
        var sheetObject2 = sheetObjects[1];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
			switch (srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
		
				case "btn_save":
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
					
				case "btn_acceptall":
					if(validateForm(sheetObject2,formObject,MODIFY01)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY01);
					}
					break;
					
				case "btn_cancelall":
					if(validateForm(sheetObject2,formObject,MODIFY02)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY02);
					}
					break;
					
				case "btn_glinecopy":
					if(validateForm(sheetObject1,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					}
					break;
					
				case "btn_rowadd1":
					if(validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
					
				case "btn_rowadd2":
					if(validateForm(sheetObject2,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
					break;
		
				case "btn_delete1":
					if(validateForm(sheetObject1,formObject,IBDELETE) && doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC05)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
					
				case "btn_delete2":
					if(validateForm(sheetObject2,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
					break;
					
				case "btn_amend":
					if(validateForm(sheetObject2,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND01);
					}
					break;
					
				case "btn_amendcancel":
					if(validateForm(sheetObject2,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND02);
					}
					break;
					
				case "btn_accept":
					if(validateForm(sheetObject2,formObject,MODIFY03)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY03);
					}
					break;	
					
				case "btn_acceptcancel":
					if(validateForm(sheetObject2,formObject,MODIFY04)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY04);
					}
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

		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		
        buttonControl();
        parent.loadTabPage();
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

			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel.|Seq.|dp_seq|Item|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq||||";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,    	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++ , dtDataSeq, 		50, 	daCenter, 	false,	"seq");
					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtCombo,   		100,   	daLeft,  	false,	"note_clss_cd",		true,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,     	700,   	daLeft,  	false,	"note_tit_nm",   	true,	"",	dfNone,	0,	true,	true);

					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "src_info_cd");    
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "prc_prog_sts_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "dp_fix_flg");
	                 
	                InitDataCombo(0, "note_clss_cd", noteClssCdComboText, noteClssCdComboValue); 

                    InitDataValid(0, "note_tit_nm", vtEngOther, PRI_VALID_CHAR);  // 한글제외
                    AutoRowHeight = false;
                    
                    WaitImageVisible = false;

				}
				break;

             case "sheet2":
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
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel.|dp_seq|Seq.|Surcharge|Content|Content|Conversion|Conversion|EFF Date|EXP Date|Source|Status" +
									"|note_seq|note_ctnt_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq|Mapping ID|prev_note_conv_mapg_id" +
									"|note_chg_tp_cd|n1st_cmnc_amdt_seq|action_mode|bef_eff_dt|bef_exp_dt";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,    	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtDataSeq, 		30, 	daCenter, 	false,	"seq");
					InitDataProperty(0, cnt++ , dtComboEdit,   	100,  	daCenter,	false, 	"chg_cd", 					false,	"",	dfNone, 	0,		true,		true, 3);
 					InitDataProperty(0, cnt++ , dtData,     	350,    daLeft,		false, 	"note_ctnt",   				true,	"",	dfNone, 	0, 		false, 		false);
 					
 					InitDataProperty(0, cnt++ , dtPopup, 	  	20,		daRight,	false, 	"note_ctnt_pop",  			false,	"",	dfNone,		0, 		true, 		true);
 					InitDataProperty(0, cnt++ , dtDummyCheck,  	80,		daCenter,	false, 	"note_conv_flg", 			false,	"",	dfNone,		0, 		false, 		false, -1, false, false, "", false);
 					InitDataProperty(0, cnt++ , dtPopup, 	  	20,		daRight,	false, 	"note_conv_mapg_id_pop",  	false,	"",	dfNone,		0, 		false, 		false);
 					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter, 	false,	"eff_dt",  					false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtData,      	80,    daCenter, 	false, 	"exp_dt",   	   			false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtCombo,     	80, 	daCenter, 	false, 	"src_info_cd", 				false,	"",	dfNone, 	0, 		false, 		false);
 					
 					InitDataProperty(0, cnt++ , dtCombo,     	80,    daCenter, 	false, 	"prc_prog_sts_cd", 			false,	"",	dfNone, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_ctnt_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
					
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_conv_mapg_id",		true);
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prev_note_conv_mapg_id");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_chg_tp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "action_mode"); // AMEND 시 CONVERSION의 EFF_DT, EXP_DT를 업데이트하기 위함.
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "bef_eff_dt");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "bef_exp_dt");
 					
	                InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");            
	                InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue, "", "I");
	                
 					CellFontColor(0, "Conversion") = RgbColor(255, 0, 0);
 					InitDataValid(0, "chg_cd", vtEngUpOnly);
 					ColHidden("chg_cd") = true;
 					AutoRowHeight = false;
 					ShowButtonImage = 2;
 					
 					WaitImageVisible = false;
 					
 				}
                 break;

         }
     }

	var isFiredNested = false;
	var supressConfirm = false;
   /**
    * SHEET의 ROW을 클릭할때 호출되는 function <br>
    * sheet의 Row를 선택하면 해당 Row를 해당하는 자식SHEET를 조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM 필수 HTML태그(Object) 오브젝트
    * @param {ibsheet} sheetD 필수 HTML태그(Object) 오브젝트
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} appendRow 필수 SHEET Row 추가 유무
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified) {
								
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested = true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (sheetD.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (appendRow) {
				isFiredNested = true;
				var idx = sheetM.DataInsert();
				isFiredNested = false;
				return idx;
			} else {
				formObj.note_seq.value = sheetM.CellValue(adjNewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
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
	  				ComOpenWait(true);
	  				if(sheetObjects[0].RowCount > 0) {
		  				for (var i = 0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}
	  				}
					formObj.f_cmd.value = SEARCH01;
					formObj.note_tp_cd.value = "P";
					sheetObj.DoSearch("ESM_PRI_0003_10GS.do" , FormQueryString(formObj));
	  				break;
	  				
	  			case IBSEARCHAPPEND: // 조회
	
					ComOpenWait(true);
		  			// CHARGE CODE LIST와  조회된 데이터 중에서 CHARGE CODE LIST에 없는 코드의 조합으로 InitDataCombo를 세팅한다.
					var sCd = sheetObj.GetComboInfo(0,"chg_cd","Code");
					var sNm = sheetObj.GetComboInfo(0,"chg_cd","Text");				  						
					////////////////////////////////////////////////////////////////////////////////
	
	  				formObj.f_cmd.value = SEARCH02;
	  				formObj.note_tp_cd.value = "P";
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_10GS.do", FormQueryString(formObj));
	  				
	  				var arrData = ComPriXml2Array(sXml, "chg_cd");			
	  				
					if (arrData != null && arrData.length > 0) {
						
						for(var i=0; i<arrData.length; i++){
							
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.InitDataCombo(0,4, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
					}
					sheetObj.LoadSearchXml(sXml);
					
					manageMasterChange(sheetObjects[0], sheetObjects[0].SelectRow, null);
	  				break;
	  		
	  			case IBSAVE: // 저장
	  				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	  				
	  				/* DEM/DET, Chassis Note가 존재할경우 CONVERSION에 데이터가 없으면 저장할수 없다. */
					var dmtYN = false;					
					for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
						if(sheetObj.CellValue(i, "note_clss_cd") == "D" && sheetObj.RowStatus(i) != "D") {
							
							//Title 이 DEM/DET때 Content 의 Source 에 AD가 아닌게 존재하면 저장불가
							for(var j = sheetObjects[1].HeaderRows; j <= sheetObjects[1].LastRow; j++) {
								if(sheetObjects[1].CellValue(j, "amdt_seq") == formObj.amdt_seq.value && sheetObjects[1].CellValue(j, "src_info_cd") != "AD") {
									dmtYN = true;
									break;
								}
							}
							break;
						}
					}			
					if(dmtYN) {
						var count = getDmtScExptGrpCount();
						if(count < 1) {
							ComShowCodeMessage("PRI01090");
							return false;
						}
					}
					//CHSS Exception check
					var chssYN = false;
					for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
						if(sheetObj.CellValue(i, "note_clss_cd") == "C" && sheetObj.RowStatus(i) != "D") {
							
							//item이 chassis 일 때 Content 의 Source 에 AD가 아닌게 존재하면 exception validation check
							for(var j = sheetObjects[1].HeaderRows; j <= sheetObjects[1].LastRow; j++) {
								if(sheetObjects[1].CellValue(j, "amdt_seq") == formObj.amdt_seq.value && sheetObjects[1].CellValue(j, "src_info_cd") != "AD") {
									chssYN = true;
									break;
								}
							}
							break;
						}
					}
					
					if(chssYN) {
						var count = getChssScExptGrpCount();
						if(count < 1) {
							ComShowCodeMessage("PRI01150");
							return false;
						}
					}					

	  			    if (!supressConfirm && !ComPriConfirmSave()) {
	  					return false;
	  				}

	  				ComOpenWait(true);
	
					
	  			    ////////////////////////////////////////////////////////////////////////////////////
	  				// DP_SEQ 설정
	  			    // AMEND 가 존재하는 데이터는 DP_SEQ를 변경하지 않는다. - 계약서상의 순서가 변경되면 안됨.
	  			    var tRow = sheetObjects[0].FindStatusRow("I|D");
	  			    var tStatus = tRow.split(";");
	  			    if(tStatus.length-1 > 0) {
				    	//SEQ-1의 DP_SEQ MAX값 
		  			    formObj.f_cmd.value = SEARCH03;
		  			    
		  			    var sXml = "";
		  			    //루프를 사용한 이유는 DP_SEQ를 가져오지 못하는 경우를 대비하기 위함.
		  				for (var i = 0, n = 10 ; i < n ; i++) {
		  					sXml = sheetObj.GetSearchXml("ESM_PRI_0003_10GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}
		  				
		  				//이전 SEQ의 MAX값을 가져온다.
						var maxDpSeq = parseInt(ComGetEtcData(sXml,"TITLE_MAX_DP_SEQ"),10);
						
						for(var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
							if(sheetObjects[0].CellValue(i, "dp_fix_flg") != "Y" && sheetObjects[0].RowStatus(i) != "D") {
								maxDpSeq ++;
								sheetObjects[0].CellValue2(i, "dp_seq") = maxDpSeq;
							}
			  			}
	  			    }
	  			   
	  			    var cRow = sheetObjects[1].FindStatusRow("I|D");
				    var cStatus = cRow.split(";");
				    if(cStatus.length-1 > 0) {
				    	//SEQ-1의 DP_SEQ MAX값 
		  			    formObj.f_cmd.value = SEARCH04;
		  			    formObj.note_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_seq");
		  			    
		  			    var sXml = "";		  				
		  				for (var i = 0, n = 10 ; i < n ; i++) {
		  					sXml = sheetObj.GetSearchXml("ESM_PRI_0003_10GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}

		  				//이전 SEQ의 MAX값을 가져온다.
						var maxDtlDpSeq = parseInt(ComGetEtcData(sXml,"CONTENT_MAX_DP_SEQ"),10);
		  				
						for(var i = sheetObjects[1].HeaderRows; i <= sheetObjects[1].LastRow; i++) {
							if(sheetObjects[1].CellValue(i, "prev_note_conv_mapg_id") == "" && sheetObjects[1].RowStatus(i) != "D") {
								maxDtlDpSeq ++;
								sheetObjects[1].CellValue2(i, "dp_seq") = maxDtlDpSeq;
							}
			  			}
				    }
				    /////////////////////////////////////////////////////////////////////////////////////
	
	  				formObj.f_cmd.value = MULTI01;
	  				formObj.note_tp_cd.value = "P";
	  				var sParam = FormQueryString(formObj);
	
	  				var sParamSheet1 = sheetObjects[0].GetSaveString();
	  				if (sParamSheet1 != "") {
	  					sParam = sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	  				}
	  				
	  				var sParamSheet2 = sheetObjects[1].GetSaveString();
	  				if (sParamSheet2 != "") {
	  					sParam = sParam + "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	  				}
	  				
	  				
	  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_10GS.do", sParam); 
	  				//LoadSaveXml의 순서를 거꾸로 해야 한다. - DELETE저장시 문제발생함.
	  				sheetObjects[1].LoadSaveXml(sXml);
	  				sXml = ComDeleteMsg(sXml);
	  				sheetObjects[0].LoadSaveXml(sXml);
  				
	  				formObj.master_del_chk.value = "N";
	  				if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
	  					return false;
	  				} else {
	  					if (getValidRowCount(sheetObjects[1]) <= 0) {
	  						doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, false);
						}
	  					return true;
	  				}
	  				break;
	  				
	  			case IBINSERT: // Row Add
	
					var eff_dt 		 = formObj.eff_dt.value;
					var exp_dt 		 = formObj.exp_dt.value;
					var amdt_seq 	 = formObj.amdt_seq.value;
				
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
				
					//DELETE가 아니면 N처리
					formObj.master_del_chk.value = "N";				
					
					if (sheetObj.id == "sheet1") {
						var idx = doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, true);
						
						if (idx < 0) {
							return false;
						}
						sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
						sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
						sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
						sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;
						sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
						sheetObj.CellValue2(idx, "src_info_cd") = "NW";
						
						sheetObj.CellValue2(idx, "note_seq") = parseInt(ComPriGetMax(sheetObj, "note_seq")) + 1;
						sheetObj.CellValue2(idx, "note_tp_cd") = "P"; //special
						sheetObj.SelectCell(idx, "note_clss_cd");
						
						sheetObjects[1].RemoveAll();					
					}
					
					if (sheetObj.id == "sheet2") {

						if(sheetObjects[0].RowCount==0){
							ComShowCodeMessage("PRI01004");
							return;							
						}
						
						//MAPPING ID 생성
						var sNoteConvMapgId = getSYSGUID();		
						if(sNoteConvMapgId == "" || sNoteConvMapgId == null || sNoteConvMapgId == undefined) {
							return;
						}
						
						if(amdt_seq == 0){
							var idx = sheetObj.DataInsert();
							
							sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
							sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
							sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
							sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
							sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
							sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;	
							sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							
							var note_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_seq");
							sheetObj.CellValue2(idx, "note_seq") = note_seq;
							sheetObj.CellValue2(idx, "note_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1;
							sheetObj.CellValue2(idx, "note_tp_cd") = "P"; //special
							sheetObj.CellValue2(idx, "note_conv_mapg_id") = sNoteConvMapgId;
							
							if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "S") {
								sheetObj.SelectCell(idx, "chg_cd");
							} else {
								sheetObj.SelectCell(idx, "note_ctnt");
							}
							
							sheetObj.CellBackColor(idx,"note_ctnt") = sheetObj.RgbColor(255,255,255);
							//InitDataProperty에서 ALLCHECK:FALSE 일경우에 EDITABLE FALSE가 안먹임
							sheetObj.CellEditable(idx,"note_conv_flg") = false;
	
						}else{
							// insert Amend 중 Amend pair 사이에 끼어들게 되는 경우를 제외							
							if(sheetObj.SearchRows!=0 && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!= amdt_seq ){	
								ComShowCodeMessage("PRI01002");
							 	return;
							}							
							
							var idx = sheetObj.DataInsert();	   // 신규 row			
							sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;						
							sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;
							sheetObj.CellValue2(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
							sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
							sheetObj.CellValue2(idx, "exp_dt") = exp_dt;
							sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = formObj.amdt_seq.value;	
							sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							
							var note_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_seq");
							sheetObj.CellValue2(idx, "note_seq") = note_seq;
							sheetObj.CellValue2(idx, "note_ctnt_seq") = parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1;
							sheetObj.CellValue2(idx, "note_tp_cd") = "P"; //special
							sheetObj.CellValue2(idx, "note_conv_mapg_id") = sNoteConvMapgId;
							
							if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "S") {
								sheetObj.SelectCell(idx, "chg_cd");
							} else {
								sheetObj.SelectCell(idx, "note_ctnt");
							}
	
							sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
							sheetObj.CellBackColor(idx,"note_ctnt") = sheetObj.RgbColor(255,255,255);
							//InitDataProperty에서 ALLCHECK:FALSE 일경우에 EDITABLE FALSE가 안먹임
							sheetObj.CellEditable(idx,"note_conv_flg") = false;
							
			    			//하이라이트처리
							changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
														
						}
					
						sheetObj.CellEditable(idx,"note_conv_mapg_id_pop") = true;
						//MASTER 색상 변경
						manageMasterColor(sheetObjects[0], sheetObjects[1]);
					}
	  				break;
	  				
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}				
					var amdt_seq = formObj.amdt_seq.value;
					
					// 선택된 ROW 리스트/////////////////////////////////
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}	
					chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					////////////////////////////////////////////////////
					
					if (sheetObj.id == "sheet1") {
						if(amdt_seq=="0"){
							if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
							
				        	var delCnt = deleteRowCheck(sheetObj, "chk");
							if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
								sheetObjects[1].RemoveAll();
							}
							
						} else {
							
							for(var i=0;i < chkArr.length;i++){
								//MASTER에 src_info_cd가 NW가 아니면 AMEND데이터가 존재하는것임.
								//선택 ROW에 선을 긋고 빨간색 처리
								if(sheetObj.CellValue(chkArr[i], "src_info_cd") != "NW") {
									//DETAIL에서 AMEND처리시 변경될 컬럼들을 MASTER에 임시저장하고 서버에서 DETAIL에 적용한다.
									sheetObj.CellValue2(chkArr[i], "src_info_cd") = "AD";
									sheetObj.CellValue2(chkArr[i], "prc_prog_sts_cd") = "I";
									////////////////////////////////////////////////////////
									//SHEET에서 삭제처리하지 않음.
									sheetObj.CellValue2(chkArr[i], "chk") = "0";
									sheetObj.RowStatus(chkArr[i]) = "U";
									////////////////////////////////////////////////////////
									sheetObj.CellFont("FontStrikethru", chkArr[i], 1, chkArr[i], sheetObj.LastCol)=true;
									sheetObj.CellFont("FontColor", chkArr[i], 1, chkArr[i], sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
								}
							}
							////////////////////////////////////////////////////////////////
							// AMEND된 데이터를 AMEND CANCE처리												
							sheetObjects[1].CheckAll2("chk") = "1";
							var chkArrDtl = ComPriSheetCheckedRows(sheetObjects[1], "chk");
							
							for(var i=0; chkArrDtl != null && i<chkArrDtl.length;i++){
						    	if(sheetObjects[1].CellValue(Number(chkArrDtl[i]),"n1st_cmnc_amdt_seq") == amdt_seq 
									&& (sheetObjects[1].CellValue(Number(chkArrDtl[i]),"src_info_cd") == "AM" )){
			  						//2009.09.28일변경- 이전 MAPPING ID에 해당하는 데이터를 가져와서 현재 AMDT_SEQ에 해당하는 MAPPING ID를 세팅한다.
			  						//1. CONVERSION의 데이터를 원복하기 위해서 임시로 MAPPING ID를 TEMP에 저장한다.
						    		sheetObjects[1].CellValue2(Number(chkArrDtl[i])-1, "note_conv_mapg_id") = sheetObjects[1].CellValue(Number(chkArrDtl[i]), "note_conv_mapg_id");
			  						
			  						//2. AMEND CANCEL 처리
						    		comSheetAmendCancelRow(sheetObjects[1],formObj,Number(chkArrDtl[i]),"M", "note_ctnt");
						    		sheetObjects[1].CellEditable(Number(chkArrDtl[i])-1, "chk") = true;
						    		
								}
						    }
							
							//AMEND가 아닌 데이터를 AMEND DELETE처리
							sheetObjects[1].CheckAll2("chk") = "1";
							
							var chkArrDtl = ComPriSheetCheckedRows(sheetObjects[1], "chk");
							var sRow = 0;
							
						    for(var i=0; chkArrDtl != null && i<chkArrDtl.length;i++){
						    	if(sheetObjects[1].CellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
						    		//AMEND DELETE
									comSheetAmendRow(sheetObjects[1],formObj,Number(chkArrDtl[i])+sRow,"D","note_ctnt");
						    		sRow++;	
						    		sheetObjects[1].CellValue2(Number(chkArrDtl[i])+sRow, "note_conv_flg") = "0";
						    		
								} else if(sheetObjects[1].CellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")==amdt_seq 
									&& (sheetObjects[1].CellValue(Number(chkArrDtl[i])+sRow,"src_info_cd") == "AD" )) {								
									sheetObjects[1].CellValue2(Number(chkArrDtl[i])+Number(sRow), "chk") = "0";
								}
						    }
						    //
						    ///////////////////////////////////////////////////////////////////
						    
							//나머지 삭제처리
							deleteRowCheck(sheetObjects[1], "chk");	
							
	
							if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
							
				        	var delCnt = deleteRowCheck(sheetObj, "chk");
							if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
								sheetObjects[1].RemoveAll();
							}
							
							
						}
						
						//MASTER에서의 DELETE임을 체크하는 FLAG
						//서버단에서 UDPATE/DELETE시 사용됨.
						formObj.master_del_chk.value = "Y";
						
					} else if (sheetObj.id == "sheet2") {
						
						if(amdt_seq=="0"){
							for(i=0;i < chkArr.length;i++){
								if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd") != "I"){
									//comChangeValue(sheetObj, "chk", "0", "chk", "1");
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
							
							deleteRowCheck(sheetObj, "chk", true);		
						} else {
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.CellValue(chkArr[i],"amdt_seq")!=amdt_seq 
										||(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq &&
												(sheetObj.CellValue(chkArr[i],"src_info_cd") =="AM" || sheetObj.CellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd") != "I"))){
									//comChangeValue(sheetObj, "chk", "0", "chk", "1");
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
		
							var sRow = 0;
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.CellValue(Number(chkArr[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									//AMEND DELETE
									comSheetAmendRow(sheetObj,formObj,Number(chkArr[i])+sRow,"D","note_ctnt|note_ctnt_pop");
						    		sRow++;	
						    		
						    		sheetObj.CellValue2(Number(chkArr[i])+sRow,"note_conv_flg") = "0";
								}
							}
							//나머지 삭제처리
							deleteRowCheck(sheetObj, "chk");
						}
						formObj.master_del_chk.value = "N";
					}
					

					//DETAIL의 모든 ROW를 삭제할경우 체크
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00020')){
			  				ComOpenWait(true);
			  				//MASTER에 체크되어 있는 데이터를 언체크한다.
							sheetObjects[0].CheckAll2("chk") = 0;
							sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "chk") = "1";
					    								
							if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
							
							var delCnt = deleteRowCheck(sheetObjects[0], "chk");

							if (delCnt > 0 && sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) == "D") {
								sheetObjects[1].RemoveAll();
							}
						}
					}
									
					//Conversion Delete 처리
					manageConvButton (sAction);
					
					//MASTER 색상 변경
					manageMasterColor(sheetObjects[0], sheetObjects[1]);
					
					break;
	  			  									
	  			case MODIFY01: // Accept All
		  			if(ComShowCodeConfirm("PRI01015")) {
		  				var amdtSeq = formObj.amdt_seq.value;
		  				//현재 보이는 SHEET의 STATUS를 변경한다.
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "A", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "I|"+amdtSeq);
	
		  				ComOpenWait(true);
		  				formObj.f_cmd.value = MULTI02;
		  				var sParam = FormQueryString(formObj);
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_10GS.do", sParam);
		  				
		  				sheetObj.LoadSaveXml(sXml);
					}
	  				break;
	  			
	  			case MODIFY02: // Cancel All
		  			if(ComShowCodeConfirm("PRI01010")) {
		  				var amdtSeq = formObj.amdt_seq.value;
		  				//현재 보이는 SHEET의 STATUS를 변경한다.
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "I", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "A|"+amdtSeq);
	
		  				ComOpenWait(true);
		  				formObj.f_cmd.value = MULTI03;
		  				var sParam = FormQueryString(formObj);
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_10GS.do", sParam);
		  				sheetObj.LoadSaveXml(sXml);
					}
	  				break;			
	
	  			case MODIFY03: // Accept
		  			if(ComShowCodeConfirm("PRI00008")) {
		  				formObj.f_cmd.value = MULTI04;
		  				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0003_10GS.do");
		  			}
	   				break;	
	  				
	  				
	  			case MODIFY04: // Accept Cancel
	  				if(ComShowCodeConfirm("PRI00009")) {	
	  					formObj.f_cmd.value = MULTI05;
		  				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0003_10GS.do");
	  				}
	  				break;			
	  				
	  			case COMMAND01: // Amend
	  				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{
	  						var trueYN = comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","note_ctnt");
	  						if(trueYN) {
	  							//MASTER 색상 변경
	  							manageMasterColor(sheetObjects[0], sheetObjects[1]);
	  							//Conversion Delete 처리
	  							manageConvButton (sAction);
	  	  					}
	  					}
	  				}else{ 
	  					var trueYN = comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M","note_ctnt");
	  					if(trueYN) {
							//MASTER 색상 변경
							manageMasterColor(sheetObjects[0], sheetObjects[1]);
							//Conversion Delete 처리
							manageConvButton (sAction);
	  					}
	  				}
	  				sheetObj.SelectCell(sheetObj.SelectRow, "note_ctnt", false);
	  						
	  				break;			
	  			
	  			case COMMAND02: // Amend Cancel
	  			
	  				var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{	  						
							if(sheetObj.CellValue(chkArr[0],"prc_prog_sts_cd")!="I"){
								ComShowCodeMessage("PRI01002");
								return;
							}
							
	  						
	  						//2009.09.28일변경- 이전 MAPPING ID에 해당하는 데이터를 가져와서 현재 AMDT_SEQ에 해당하는 MAPPING ID를 세팅한다.
	  						//1. CONVERSION의 데이터를 원복하기 위해서 임시로 MAPPING ID를 TEMP에 저장한다.
	  						sheetObj.CellValue2(sheetObj.SelectRow-1, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow, "note_conv_mapg_id");
	  						
	  						//2. AMEND CANCEL 처리
	  						var trueYN = comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "note_ctnt");
	  						
	  						if(trueYN) {
		  						//MASTER 색상 변경
		  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
		  								
		  						//3. Conversion Delete & update
		  						manageConvButton (sAction);
	  						}
	  						
	  					}
	  				}else{ 
	  					if(sheetObj.CellValue(sheetObj.SelectRow,"prc_prog_sts_cd")!="I"){
							ComShowCodeMessage("PRI01002");
							return;
						}
						
						//2009.09.28일변경- 이전 MAPPING ID에 해당하는 데이터를 가져와서 현재 AMDT_SEQ에 해당하는 MAPPING ID를 세팅한다.
						//1. CONVERSION의 데이터를 원복하기 위해서 임시로 MAPPING ID를 TEMP에 저장한다.
						sheetObj.CellValue2(sheetObj.SelectRow-1, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow, "note_conv_mapg_id");
						
						//2. AMEND CANCEL 처리
						var trueYN = comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", "note_ctnt");
						
						if(trueYN) {
							//MASTER 색상 변경
	  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
	  								
	  						//3. Conversion Delete & update
	  						manageConvButton (sAction);
						}
	  				}
	  	
	  				break;				
	  				
				case IBSEARCH_ASYNC05: // 조회 - Group 삭제시 detail Accepted 여부
					if (validateForm(sheetObj,document.form,sAction)) {

				    	//공통 Source
						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
				    	
						if(chkArr.length == 0){
							sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
						}						
						
						/* Note Seq - Start  ***********************************************/
						var tNoteSeq = "";
						for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {							
							if(sheetObj.CellValue(i, "chk") == "1") {
								tNoteSeq += sheetObj.CellValue(i, "note_seq") + ",";
							}
						}						
						tNoteSeq = tNoteSeq.slice(0, -1);
						/* Note Seq - end    ***********************************************/
												
						formObj.f_cmd.value = SEARCH05;
		  				formObj.note_seq.value = tNoteSeq;
		  				var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_10GS.do", FormQueryString(formObj));		  				
						var arrDesc = ComPriXml2Array(sXml, "note_seq|note_ctnt");
						var rsltCnt = ComPriGetRowCountFromXML(sXml);

						var txt = "";
						var desc = "";
	
						if(rsltCnt <= 0){
							return true;
						}
						for(i=0;i<arrDesc.length;i++){
							if(desc!=arrDesc[i][0]){
								txt += "\n["+arrDesc[i][0]+"] : \n   ";
							}
							txt += "-" + arrDesc[i][1]+" ";
							desc = arrDesc[i][0];
						}
	
						ComShowCodeMessage("PRI01132", txt);	
						return false;
					
					}
					return true;
					break;	
					
				/*	
				case IBSEARCH_ASYNC05: // 조회 - Group 삭제시 detail Accepted 여부
					if (validateForm(sheetObj,document.form,sAction)) {

				    	//공통 Source
						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
				    	
						if(chkArr.length == 0){
							sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
						}						
						var sParam = "f_cmd="+SEARCH05+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_10GS.do", sParam);
						var arrDesc = ComPriXml2Array(sXml, "note_seq|note_ctnt");
						var rsltCnt = ComPriGetRowCountFromXML(sXml);

						var txt = "";
						var desc = "";
	
						if(rsltCnt <= 0){
							return true;
						}
						for(i=0;i<arrDesc.length;i++){
							if(desc!=arrDesc[i][0]){
								txt += "\n["+arrDesc[i][0]+"] : \n   ";
							}
							txt += "-" + arrDesc[i][1]+" ";
							desc = arrDesc[i][0];
						}
	
						ComShowCodeMessage("PRI01132", txt);	
						return false;
					}
					return true;
					break;
				*/		  	
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
    * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
    * sheet1의 전체체크를 컨트롤한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */	
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
    /**
    * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
    * sheet2의 전체체크를 컨트롤한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */	
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}
    /**
    * OnClick 이벤트 발생시 호출되는 function <br>
    * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {
			//하이라이트 처리
			changeSelectBackColor4Master(sheetObj, document.form);
		}

		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
		
	}

    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.04.17
     */         
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    } 
  	
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2009.06.18
     */
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
 	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 	    var formObj = document.form;
 	    var colname = sheetObj.ColSaveName(Col);  	 
 	    var amdtSeq = formObj.amdt_seq.value;
 	    var propStsCd = formObj.prop_sts_cd.value;
 	    
      	switch(colname)
      	{
      		case "note_ctnt":
	    		sheetObj.CellEditable(Row,"note_ctnt") = false;
	    		if(propStsCd == "I" && sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") == "I"){
		    		if (amdtSeq == 0){
		    			sheetObj.CellBackColor(Row,"note_ctnt") = sheetObj.RgbColor(255,255,255);
		    			readOnly = false; 	    			
		    		}
					else if(sheetObj.CellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq){
						if (sheetObj.CellValue(Row , "src_info_cd") != "AD"){
							if (propStsCd =="I"){
								readOnly = false;
								sheetObj.CellBackColor(Row,"note_ctnt") = sheetObj.RgbColor(255,255,255);
							}else{
								readOnly = true;
								sheetObj.CellBackColor(Row,"note_ctnt") = -1;
							}						
						}else{// src_info_cd 가 AD이면 수정금지
							readOnly = true;
							sheetObj.CellBackColor(Row,"note_ctnt") = -1;
						}
					}else{
						readOnly = true;
						sheetObj.CellBackColor(Row,"note_ctnt") = -1;
					}
	    		} else {
	    			readOnly = true;
	    			sheetObj.CellBackColor(Row,"note_ctnt") = -1;
	    		}
	    		
	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 350, 200, 3999);
	    		break;      	
      	}
	}    
     
	
    /**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * Location PopUp을 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.05.07
    */ 
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName 	= sheetObj.ColSaveName(Col);
		var formObj 	= document.form;
  		var effDt 		= formObj.eff_dt.value;
  		var expDt 		= formObj.exp_dt.value;
  		var propStsCd 	= formObj.prop_sts_cd.value;
  		var convCfmFlg = "";
  				
		if (colName == "note_ctnt_pop") {
			var sParam = FormQueryString(formObj);
			var sUrl = "/hanjin/ESM_PRI_0089.do?" + sParam;
            sUrl += "&note_clss_cd=" + sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "note_clss_cd");
            sUrl += "&chg_cd=" + sheetObj.CellValue(Row, "chg_cd");
            
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0089", 600, 375, true);
            
            if (rtnVal != null) {
            	if (rtnVal.ctnt != null && rtnVal.ctnt != "" && rtnVal.ctnt != undefined) {
            		sheetObj.CellValue2(Row, "note_ctnt") = rtnVal.ctnt;
            	}
            	if (rtnVal.chgcd != null && rtnVal.chgcd != "" && rtnVal.chgcd != undefined) {
            		if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "S") {
            			sheetObj.CellValue2(Row, "chg_cd") = rtnVal.chgcd;
            		}
            	}
            }
		}
		
		if (colName == "note_conv_mapg_id_pop") {	
			if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "D") {
				ComPriOpenPopup('EES_DMT_2001.do?prop_no=' + formObj.prop_no.value + '&caller=000310', 1024, 700, 'findCustomer', '1,0,1,1,1,1,1', true);
			} else if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "C") { //[CHM-201327107] CHSS 노트 항목 추가
				ComOpenPopup('EES_CGM_1209.do?prop_no=' + formObj.prop_no.value, 1024, 580, '', '1,0,1,1,1,1,1', true);		
			} else {
				///////////////////////////////////////////////////////////
				//저장후 호출					
				if((amendSaveFlag && sheetObj.IsDataModified)) {
					var rslt = false;
					if (ComShowCodeConfirm("PRI00006")) {
						supressConfirm = true;
						rslt = doActionIBSheet(sheetObj,document.form,IBSAVE);
						supressConfirm = false;
					}
					
					if (rslt) {
						amendSaveFlag = false;
					} else {
						return false;
					}
				}
				
				if(!ComIsNull(sheetObj.CellValue(Row, "note_conv_mapg_id"))) {
					var sParam = "";
					sParam += "svc_scp_cd=" + formObj.svc_scp_cd.value;
					sParam += "&prop_no=" + formObj.prop_no.value;
					sParam += "&amdt_seq=" + formObj.amdt_seq.value;
					sParam += "&note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
					sParam += "&note_seq=" + sheetObj.CellValue( Row, "note_seq");
					sParam += "&note_ctnt_seq=" + sheetObj.CellValue( Row, "note_ctnt_seq");
					sParam += "&note_tp_cd=" + sheetObj.CellValue( Row, "note_tp_cd");
					sParam += "&eff_dt=" + sheetObj.CellValue( Row, "eff_dt");
					sParam += "&exp_dt=" + sheetObj.CellValue( Row, "exp_dt");;
					sParam += "&master_seq=" + sheetObjects[0].SelectRow;
					sParam += "&detail_seq=" + sheetObjects[1].SelectRow;
					sParam += "&prop_sts_cd=" + formObj.prop_sts_cd.value;
															
					var sUrl = "/hanjin/ESM_PRI_0032.do?"+sParam;			
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0032", 1020, 625, true);
		  
					var array = new Array();
					if(rtnVal != null && rtnVal.length > 0) {
						//CONVERSION 화면에서 CONTENTS별 저장이 가능하기때문에 FOR문절 사용
								  				
						for(var i=0; i < rtnVal.length; i++) {
							//CONVERSION 화면에서 선택ROW가 변동가능하기 때문에 FOR문절 사용
							for(var j = sheetObj.HeaderRows; j <= sheetObj.LastRow; j++) {
								if(sheetObj.CellValue(j, "note_seq") == rtnVal[i].master_seq 
										&& sheetObj.CellValue(j, "note_ctnt_seq") == rtnVal[i].detail_seq
	  									&& sheetObj.CellValue(j, "amdt_seq") == rtnVal[i].amdt_seq ) {
									var prevStatus = sheetObj.RowStatus(j);
									sheetObj.CellValue2(j, "note_conv_flg") = rtnVal[i].note_conv_flg;
									sheetObj.CellValue2(j, "note_chg_tp_cd") = rtnVal[i].note_chg_tp_cd;
									sheetObj.RowStatus(j) = prevStatus;
								}
							}
						}
					}
					
					
				} else {
					ComShowCodeMessage("PRI08015");
				}
			}
		}
    }
	
    
	   /**
	    * OnChange 이벤트 발생시 호출되는 function <br>
	    * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *
	    * </pre>
	    * @param {ibsheet} sheetObj 필수 IBSheet Object
	    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	    * @return 없음
	    * @author 최성민
	    * @version 2009.04.17
	    */  
		function sheet1_OnChange(sheetObj, Row, Col, Value) {
			var colName = sheetObj.ColSaveName(Col);
			var formObj = document.form;
			var reqUsrFlg = formObj.req_usr_flg.value;
			var aproUsrFlg = formObj.apro_usr_flg.value;
			var propStsCd = formObj.prop_sts_cd.value;
			
			if (colName == "note_clss_cd") {
				
				for(var i=1; i<= sheetObjects[1].RowCount; i++) {
					var rowStatus = sheetObjects[1].RowStatus(i);
					sheetObjects[1].CellValue2(i,"chg_cd") = "";
					sheetObjects[1].RowStatus(i) = rowStatus;
				}
								
				if (Value == "S") {
	 				sheetObjects[1].ColHidden("chg_cd") = false;
	 				sheetObjects[1].InitDataProperty(0, 4, dtComboEdit,100,daCenter,false, 	"chg_cd",true,	"",	dfNone,0,true,true, 3);
				} else {
					sheetObjects[1].ColHidden("chg_cd") = true;
					sheetObjects[1].InitDataProperty(0, 4, dtComboEdit,100,daCenter,false, 	"chg_cd",false,	"",	dfNone,0,true,true, 3);
					
				}
				
				if(Value == "O") {
					sheetObj.CellValue2(Row,"note_tit_nm") = "";
				} else {
					sheetObj.CellValue2(Row,"note_tit_nm") = sheetObj.CellText(Row, "note_clss_cd");
				}
				
				
				if(propStsCd != "I") {
				  	sheetObj.CellEditable(Row,"note_clss_cd") = false;
					sheetObj.CellEditable(Row,"note_tit_nm") = false;
				}
				
				
				if (Value == "D") {
					for(var i=sheetObjects[1].HeaderRows; sheetObjects[1].RowCount>0 && i<= sheetObjects[1].LastRow; i++) {
						if(sheetObjects[1].CellValue(i,"note_conv_flg") == "1") {
							ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
							sheetObj.CellValue2(sheetObj.SelectRow, "note_clss_cd") = "";
							sheetObj.CellValue2(sheetObj.SelectRow, "note_tit_nm") = "";
							sheetObj.SelectCell(sheetObj.SelectRow, "note_clss_cd");
							return false;
						}
					}
				}
				
				
				// Item 이 변경될때 체크하는것으로 변경됨.
				//12.28 Others 는 중복체크에서 제외
				//2011.01.14 AMEND DELETE된 데이터는 중복체크에서 제외
				for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
					var iValue = sheetObj.CellValue(i, "note_clss_cd");					
					if(sheetObj.RowStatus(i) == "D" || sheetObj.CellFont("FontStrikethru", i, "note_clss_cd")) {
						continue;
					}
					
					for(var j = sheetObj.HeaderRows; j <= sheetObj.LastRow; j++) {
						if(sheetObj.RowStatus(j) == "D" || sheetObj.CellFont("FontStrikethru", j, "note_clss_cd")) {
							continue;
						}
						
						var jValue = sheetObj.CellValue(j, "note_clss_cd");
						if(i != j) {
							if(iValue == jValue && iValue != "O") {
								ComShowCodeMessage("PRI00303", "Sheet1", sheetObj.SelectRow);
								sheetObj.CellValue2(sheetObj.SelectRow, "note_clss_cd") = "";
								sheetObj.CellValue2(sheetObj.SelectRow, "note_tit_nm") = "";
								sheetObj.SelectCell(sheetObj.SelectRow, "note_clss_cd");
								return false;
							}
						}
					}
				}

			}
		}
	    
	   /**
	    * OnChange 이벤트 발생시 호출되는 function <br>
	    * COMMBO에 없는 코드를 입력할 경우 서버를 검색해서 데이터가 존재하면 코드값을 화면에 출력하는 function  <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *
	    * </pre>
	    * @param {ibsheet} sheetObj 필수 IBSheet Object
	    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	    * @return 없음
	    * @author 최성민
	    * @version 2009.04.17
	    */  
	    function sheet2_OnChange(sheetObj, Row, Col, Value) {
			var colName = sheetObj.ColSaveName(Col);
			var formObj = document.form;
			
			switch(colName)
	    	{
				case "chg_cd":					
					if (Value != null && Value != "" && Value.length == 3) {
						var sCode = sheetObj.GetComboInfo(0, "chg_cd", "Code");
						var sText = sheetObj.GetComboInfo(0, "chg_cd", "Text");

						if (sChgCdVisiable.indexOf("|"+Value) < 0) {
							formObj.f_cmd.value = COMMAND09;
							sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
							
							var arrData = ComPriXml2Array(sXml, "cd|nm");
							if (arrData != null && arrData.length > 0) {
								sCode += "|" + Value;
								sText += "|" + Value;
								sheetObj.InitDataCombo(0, "chg_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
								
								ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
							} else {
								sheetObj.CellValue2(Row, "chg_cd") = "";
							}
						}
					} else {
						sheetObj.CellValue2(Row, "chg_cd") = "";
					}
					break;
	    	}
			
		}
	    
  	    /**
 	     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
 	     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     * 
 	     * </pre>
 	     * @param {ibsheet} sheetObj 필수 IBSheet Object
 	     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	     * @return 없음
 	     * @author 최성민
 	     * @version 2009.06.22
 	     */ 		
 	   	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
 	    	var formObj = document.form;
 	    	 	    	
 	    	//저장후 값 초기화
 	    	for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
 	    		
 	    		var rowStatus = sheetObj.RowStatus(i);
 	    		sheetObj.CellValue2(i, "action_mode") = "";
 	    		sheetObj.RowStatus(i) = rowStatus;
 	    	}
 	    	
			//Main 의 Amendment Summary 관련 function
			parent.comUpdateProposalStatusSummary("32", formObj.svc_scp_cd.value);	
 		}
	    
		/**
	     * MASTER의 ROW를 선택할때 DETAIL의 화면 처리하는 function <br>
	     * <br><b>Example :</b>
	     * <pre>
	     * manageMasterChange(sheetObj, Row, Col);
	     * </pre>
	     * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	     * @return 없음
	     * @author 최성민
	     * @version 2009.05.20
	     */ 
	    function manageMasterChange(sheetObj, Row, Col) {
	    	var noteClssCd = sheetObj.CellValue(Row, "note_clss_cd");
			var formObj = document.form;
			var propStsCd = formObj.prop_sts_cd.value;
			
			var reqUsrFlg = formObj.req_usr_flg.value;
			var aproUsrFlg = formObj.apro_usr_flg.value;
			
			//MASTER의 ITEM 카테고리에서 SURCHARGE를 선택했을경우 DETAIL화면에 SURCHARGE항목 표시
			if(noteClssCd == "S") {
				sheetObjects[1].ColHidden("chg_cd") = false;
				sheetObjects[1].InitDataProperty(0, 4, dtComboEdit,100,daCenter,false, 	"chg_cd",true,	"",	dfNone,0,true,true, 3);
			} else {
				sheetObjects[1].ColHidden("chg_cd") = true;
				sheetObjects[1].InitDataProperty(0, 4, dtComboEdit,100,daCenter,false, 	"chg_cd",false,	"",	dfNone,0,true,true, 3);
			}
						
			if(propStsCd != "I") {
			  	sheetObj.CellEditable(Row,"note_clss_cd") = false;
				sheetObj.CellEditable(Row,"note_tit_nm") = false;
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
      * @author 최성민
      * @version 2009.04.17
      */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
	
		case IBSAVE: // 저장
			var sheetM = sheetObjects[0];
			var sheetD = sheetObjects[1];
			
			if (!sheetM.IsDataModified && !sheetD.IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
				
			if (sheetM.RowStatus(sheetM.SelectRow) != "D" && getValidRowCount(sheetD) <= 0) {
				ComShowCodeMessage("PRI00319", "Special Note");
				return false;
			}

			if (sheetM.IsDataModified && sheetM.GetSaveString() == "") {
				return false;
			}
			
			if (sheetD.IsDataModified && sheetD.GetSaveString() == "") {
				return false;
			}		

			
			//2011.01.14 중복체크
			//OTHER를 제외한 나머지 ITEM중에서 중복조사
			//삭제되거나 AMEND DELETE된 데이터는 제외
			for(var i = sheetM.HeaderRows; i <= sheetM.LastRow; i++) {
				var iValue = sheetM.CellValue(i, "note_clss_cd");					
				if(sheetM.RowStatus(i) == "D" || sheetM.CellFont("FontStrikethru", i, "note_clss_cd")) {
					continue;
				}
				
				//SHEET의 아래에서부터 조사
				for(var j = sheetM.LastRow; j >= sheetM.HeaderRows; j--) {
					if(sheetM.RowStatus(j) == "D" || sheetM.CellFont("FontStrikethru", j, "note_clss_cd")) {
						continue;
					}
					
					var jValue = sheetM.CellValue(j, "note_clss_cd");
					if(i != j) {
						if(iValue == jValue && iValue != "O") {
							ComShowCodeMessage("PRI00303", "Sheet1", j);
							return false;
						}
					}
				}
			}
			
			break;
			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 

			if (sheetObj.id == "sheet2" && getValidRowCount(sheetObjects[0]) == 0) {
				ComShowCodeMessage("PRI01004");
				return false;					
			}

			break;
			
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 
			
			if (getValidRowCount(sheetObj) == 0) {
				return false;					
			}
			
			break;
			
		case IBCOPYROW: //g/l copy
			if(sheetObjects[0].RowCount > 0) {
				return false;
			}
			break;
			
		case MODIFY01: // Accept All
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}

  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;
			
  		case MODIFY02: // Cancel
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}

  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;	
			
		case MODIFY03: // Accept
		
			// 선택된 ROW 리스트/////////////////////////////////
			var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
		
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
			
				if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
				}
			}
			break;
			
		case MODIFY04: // Accept cancel
			// 선택된 ROW 리스트/////////////////////////////////
			var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
		
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
		
				if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
					ComShowCodeMessage("PRI01038");
					return false;
				}
			}
			break;	
			
			
  		case COMMAND01: // Amend	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			
			break;
			
  		case COMMAND02: // Amend Cancel	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			
			break;

		case IBSEARCH_ASYNC05: // 조회
			return true;
			break;	
	
//		case IBSEARCH_ASYNC06: // 조회
//			return true;
//			break;			

		}
		return true;
	}

 	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
     * @param {string} sPropStsCd 필수 pro_sts_cd 값
     * @param {string} sEffDt 필수 eff_dt 값
     * @param {string} sExpDt 필수 exp_dt 값
     * @param {string} sPreExpDt 필수 pre_exp_dt 값
     * @return 없음
     * @author 최성민
     * @version 2009.05.21
     */ 
	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
		var formObject = document.form;
		if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
			formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
			formObject.prop_no.value = sPropNo;
			formObject.amdt_seq.value = sAmdtSeq;
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.pre_amdt_seq.value = sPreAmdtSeq; 
			formObject.prop_sts_cd.value = sPropStsCd; 
			formObject.eff_dt.value = sEffDt;
			formObject.exp_dt.value = sExpDt;
			formObject.pre_exp_dt.value = sPreExpDt ;
			formObject.req_usr_flg.value = sIsReqUsr ;
			formObject.apro_usr_flg.value = sIsAproUsr ;
 			formObject.lgcy_if_flg .value = sLgcyIfFlg ;
 			formObject.dur_dup_flg.value = "Y" ;

			//SURCHARGE
			initComboChargeCode(sheetObjects[1], formObject);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			
			//조회하고 버튼 설정
			buttonControl();
			
		}
	}

	/**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 최성민
     * @version 2009.05.20
     */ 
	function tabClearSheet() {
		var formObject = document.form;

		formObject.prop_no.value = "";
		formObject.amdt_seq.value = "";
		formObject.svc_scp_cd.value = "";
		formObject.pre_amdt_seq.value = "";
		formObject.prop_sts_cd.value = "";
		formObject.eff_dt.value = "";
		formObject.exp_dt.value = "";
		formObject.pre_exp_dt.value = "";
		formObject.req_usr_flg.value = "";
		formObject.apro_usr_flg.value = "";
		formObject.lgcy_if_flg .value = "";
		formObject.dur_dup_flg.value = "";
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();

		buttonControl("CLEAR");
	}
	
	var enableFlag = true;

	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
		sheetObjects[1].Editable = flag;
	}
	
    /**
    * DETAIL의 SOURCE CODE에 따라 색상 변경하는 function <br>
    * 
    * <br><b>Example :</b>
    * <pre>
    * manageMasterColor(sheetM, sheetD);
    * </pre>
    * @param {object} IBSheet  
    * @param {object} IBSheet
    * @return 없음
    * @author 최성민
    * @version 2009.06.10
    */ 	
    function manageMasterColor(sheetM, sheetD) {
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetD);
    	var formObj = document.form;
    	var amdt_seq = formObj.amdt_seq.value;
		
		//AMEND 지정
		var amend_check = false;
		//ALL AMEND DELETE
		var amend_delete_check = false;
		
		try {
  			if(row_count > 0){
  				
  				amend_delete_check = true;
  				
	  			for(var i=1 ; i <= row_count; i++){
	  				
  					if(sheetD.CellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
  						if(sheetD.CellValue(i,"src_info_cd") !="AD") {
  							amend_delete_check = false;
	  	  				}
  						
  						if(sheetD.CellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
	  	  					amend_check = true;
	  	  				}
  					}
	  			}
	  			
	  			if(amdt_seq == "0"){
	  				amend_delete_check = false;
	  			}
	  			
	  			if(amend_delete_check) {
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=true;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);  
	  			} else if(amend_check){
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(255,0,0);
	  			} else {
	  				sheetM.CellFont("FontStrikethru", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=false;
	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= sheetM.RgbColor(0,0,0);
	  			}
	  			

	  			//하이라이트 처리
	  			changeSelectBackColor4Master(sheetObjects[0], formObj);
  			}
		}catch(e) {}
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
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		 manageCellEditable (sheetObj);
		 amendSaveFlag = false;
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
		var formObj 	= document.form;
		var propStsCd 	= formObj.prop_sts_cd.value;
   	 	var sLgcyIfFlg	= formObj.lgcy_if_flg.value;
		formObj.master_del_chk.value = "N";
		
		if (errMsg == ""&& sheetObj.RowCount>0) {
			
			//DETAIL의 모든 로우의 SOURCE가 AD일경우 MASTER에 색처리
			
			for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
											
				if(sheetObj.CellValue(i,"amdt_seq") > 0 && sLgcyIfFlg != "Y") {
					if(sheetObj.CellValue(i,"src_info_cd") == 'AD') {
						sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
						sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
					} else if(sheetObj.CellValue(i,"src_info_cd") == 'AM' || sheetObj.CellValue(i,"src_info_cd") == 'NW') {
						sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
					}
					
					//현재 seq 에 추가된 데이터일경우 Item 은 변경가능
					if(sheetObj.CellValue(i,"src_info_cd") != 'NW') {
						sheetObj.CellEditable(i,"note_clss_cd") = false;
						sheetObj.CellEditable(i,"note_tit_nm") = false;
					}
				}
				
				if(propStsCd != "I") {
				  	sheetObj.CellEditable(i,"note_clss_cd") = false;
					sheetObj.CellEditable(i,"note_tit_nm") = false;
				}				
			}
			
			//하이라이트 처리
			changeSelectBackColor4Master(sheetObj, formObj);
		}
	}
 
	 
	/**
     * SHEET의 CELL 수정권한을 제어하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     * 	manageCellEditable (sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */
     function manageCellEditable (sheetObj) {
	  		
    	 var formObj 		= document.form;
    	 var amdtSeq 		= formObj.amdt_seq.value;
    	 var reqUsrFlg 		= formObj.req_usr_flg.value;
    	 var aproUsrFlg 	= formObj.apro_usr_flg.value;
    	 var propStsCd 		= formObj.prop_sts_cd.value;
    	 var sLgcyIfFlg		= formObj.lgcy_if_flg.value;
    	 var noteClssCd		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd");

    	 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
    		     		 
    		  // AMDT_SEQ가 다르면 DISABLE
    		  if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq){ 
    			  sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
    			  sheetObj.CellEditable(i,"chk") = false;
    			  sheetObj.CellEditable(i,"note_ctnt") = false;
    			  sheetObj.CellEditable(i,"note_ctnt_pop") = false;
    			  sheetObj.CellEditable(i,"note_conv_flg") = false;
    			  sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = true;
    		  }
			 	
    		  if(amdtSeq == 0) {
    			  sheetObj.CellBackColor(i,"note_ctnt") = sheetObj.RgbColor(255,255,255);
    			  sheetObj.CellEditable(i,"chg_cd") = true;
    			  sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = true;
    		  } else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && amdtSeq > 0 && sLgcyIfFlg != "Y"){
    			  	sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);				
					sheetObj.CellEditable(i,"chg_cd") = true;
					sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = true;
					sheetObj.CellBackColor(i,"note_ctnt") = sheetObj.RgbColor(255,255,255);
    		  } else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && amdtSeq > 0){
    			  	sheetObj.CellEditable(i,"chg_cd") = false;
					sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = true;
					sheetObj.CellBackColor(i,"note_ctnt") = -1;
    		  }
    		  
    		  if(sheetObj.CellValue(i,"src_info_cd") == "AD" || sheetObj.CellValue(i,"prc_prog_sts_cd") != "I") {
    			  sheetObj.CellEditable(i,"chg_cd") = false;
    			  sheetObj.CellBackColor(i,"note_ctnt") = -1;
    			  sheetObj.CellEditable(i,"note_ctnt_pop") = false;
    		  }
    		  
	  		  
    		  if(propStsCd != "I") {
    			  	sheetObj.CellEditable(i,"chg_cd") = false;
					sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = true;
					sheetObj.CellEditable(i,"note_ctnt_pop") = false;
					sheetObj.CellBackColor(i,"note_ctnt") = -1;
    		  }
    		 
	  		  //DEM/DET의 경우에는 STATUS에 상관없이 활성화.	  		 
	  		  if(noteClssCd == "D"){
	  			if(aproUsrFlg=="true" || reqUsrFlg=="true" ){
	  				sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = true;
	  			} else {
	  				sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = false;
	  			}
	  		  }
	  		     		  
    		  //InitDataProperty에서 ALLCHECK:FALSE 일경우에 EDITABLE FALSE가 안먹임
    		  sheetObj.CellEditable(i,"note_conv_flg") = false;
    		
    	 }
     }

  	/**
      * CODE COMBO 선택시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
      * RULE코드를 선택하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
      * CHARGE코드를 선택하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @return 없음
      * @author 최성민
      * @version 2009.07.02
      */	
 	function insertChargeRuleType(sheetObj, Row) {
 		var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "FAR" && chgRuleDefCd != "FAD"	) {//[CHM-201325096]FAR, FAD 추가
 			
 			//CHARGE
 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C"; 
 			sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
 		} else {
 			//RULE
 			sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R"; 
 			sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
 		}
 	}

  	/**
    * SURCHARGE 코드를 초기세팅하는  function <br>
    * SCOPE CODE별로 SURCHARGE목록을 가져온다.  <br>
    * <br><b>Example :</b>
    * <pre>
    *	initComboChargeCode(sheetObj, formObj);
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {form} formObj	필수 form Object
    * @return 없음
    * @author 최성민
    * @version 2009.07.02
    */
	function initComboChargeCode(sheetObj, formObj) {
		var sCd = "";
		var sNm = "";
		formObj.f_cmd.value = COMMAND12;
		var tXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
		var arrData = ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
		    var arrCode = arrData[0].split("|");
		    var arrName = arrData[1].split("|");
		    var conData = "";

		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i] = arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData = conData.concat(arrName[i]);
		    }
		
		    arrData[1] = conData;
		}
					
		if (arrData != null){
			sCd = " |" + arrData[0];
			sNm = " |" + arrData[1];			        
		} else {
			sCd = " |";
			sNm = " |";
		}
		sChgCdVisiable = sNm;
		
		sheetObj.InitDataCombo(0,4, sNm, sCd,"", "", 0, "", "", sChgCdVisiable);
	}
    
  	/**
    * SHEET의 데이터를 XML파일로 로드하는 function
    * <br><b>Example :</b>
    * <pre>
    *	getSheetXml(sheetObj);
    * </pre>
    * @param {int} sheetNo 필수 IBSheet Object index
    * @return {string} sXml 필수 xml형식
    * @author 최성민
    * @version 2009.07.02
    */	   
    function getSheetXml(sheetNo) {
    	var sXml = ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sXml;
    }
    
    /**
     * DMT S/C EXCEPTION GROUP의 PROP_NO가 존재하는지 조회하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param 없음
     * @return sValue EtcData
     * @author 최성민
     * @version 2009.08.13
     */       
     function getDmtScExptGrpCount() {
     	var formObj = document.form;
     	formObj.f_cmd.value = COMMAND39;
 		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
 		var sValue = ComGetEtcData(sXml,"PROP_NO_COUNT");
 		return sValue;
     }
     
     /**
      * CHSS S/C EXCEPTION GROUP의 PROP_NO가 존재하는지 조회하는 function <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param 없음
      * @return sValue EtcData
      * @author 전윤주
      * @version 2013.11.07
      */       
      function getChssScExptGrpCount() {
      	var formObj = document.form;
      	formObj.f_cmd.value = COMMAND41;
  		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
  		var sValue = ComGetEtcData(sXml,"PROP_NO_COUNT");
  		return sValue;
      }
     
     /**
      * 1. AMEND, AMEND CANCEL, DELETE 시에 MAPPING ID를 관리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {int} sAction 필수 Button Action
      * @return 없음
      * @author 최성민
      * @version 2009.06.22
      */ 
   	 function manageConvButton (sAction) {
   		var sheetObj = sheetObjects[1];
   		var formObj = document.form;
 		var amdtSeq = formObj.amdt_seq.value;
 		var effDt 	= formObj.eff_dt.value;
 		var expDt 	= formObj.exp_dt.value;
 				
 		var ibFlag = sheetObj.RowStatus(sheetObj.SelectRow);
 				
 				
 		
 		if(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") == amdtSeq) {
 			
 			if(sAction == COMMAND01 && amdtSeq == sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) { 		
 				//AMEND
 				
 				var cStatus = sheetObj.RowStatus(sheetObj.SelectRow-1);
 				sheetObj.CellValue2(sheetObj.SelectRow-1, "note_conv_mapg_id") = sheetObj.CellValue(sheetObj.SelectRow-1, "prev_note_conv_mapg_id");
 				sheetObj.RowStatus(sheetObj.SelectRow-1) = cStatus;
 				sheetObj.CellValue2(sheetObj.SelectRow, "action_mode") = COMMAND01;
 				
 				//CONVERSION POPUP 클릭가능하게
 				sheetObj.RowEditable(sheetObj.SelectRow-1) = true;
 				sheetObj.CellEditable(sheetObj.SelectRow-1, "chk") = false;
 				sheetObj.CellEditable(sheetObj.SelectRow-1, "chg_cd") = false;
 				sheetObj.CellEditable(sheetObj.SelectRow-1, "note_ctnt") = false;
 				sheetObj.CellEditable(sheetObj.SelectRow-1, "note_ctnt_pop") = false;
 				sheetObj.CellEditable(sheetObj.SelectRow-1, "note_conv_flg") = false;
 				sheetObj.CellEditable(sheetObj.SelectRow-1, "note_conv_mapg_id_pop") = true;
 				 				
 				amendSaveFlag = true;
 			
 			} else if(sAction == COMMAND02 && amdtSeq != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
 				//AMEND CANCEL
 				
 				sheetObj.CellValue2(sheetObj.SelectRow, "action_mode") = COMMAND02;
 				sheetObj.CellEditable(sheetObj.SelectRow, "note_conv_mapg_id_pop") = true;
 				sheetObj.CellEditable(sheetObj.SelectRow, "chk") = true;
 				
 				amendSaveFlag = true;
 			
 			} else if(sAction == IBDELETE) {
 				//AMEND DELETE
 				
 				for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
 					if(sheetObj.CellValue(i, "src_info_cd") == "AD" && sheetObj.RowStatus(i) == "U" && amdtSeq == sheetObj.CellValue(i, "n1st_cmnc_amdt_seq")) {
 						var cStatus = sheetObj.RowStatus(i-1);
 						sheetObj.CellValue2(i-1, "note_conv_mapg_id") = sheetObj.CellValue(i-1, "prev_note_conv_mapg_id");
 						sheetObj.RowStatus(i-1) = cStatus;
 						
 		 				sheetObj.CellValue2(i, "action_mode") = IBDELETE;
 		 				sheetObj.CellEditable(i, "note_conv_mapg_id_pop") = true;
 		 				
 		 				sheetObj.RowEditable(i-1) = true;
 		 				sheetObj.CellEditable(i-1, "chk") = false;
 		 				sheetObj.CellEditable(i-1, "chg_cd") = false;
 		 				sheetObj.CellEditable(i-1, "note_ctnt") = false;
 		 				sheetObj.CellEditable(i-1, "note_ctnt_pop") = false;
 		 				sheetObj.CellEditable(i-1, "note_conv_flg") = false;
 		 				sheetObj.CellEditable(i-1, "note_conv_mapg_id_pop") = true;
 		 				
 		 				amendSaveFlag = true;
 					}
 				}				
 			}
 		}
   	 }
   	   
      /**
        * ITEM에 DEM/DET을 추가했을경우 저장하지 않고 TAB이동시 저장 메세지를 호출하기 위해 MAIN에 값을 리턴한다.<br>
        * 버튼을 제어한다. <br>
        * <br><b>Example :</b>
        * <pre>
        * getDemDetSaveCheck()
        * </pre>
        * @param 없음
        * @return returnValue 
        * @author 최성민
        * @version 2010.01.13
        */
      function getDemDetSaveCheck() {
    	  var returnValue = "Y";
    	  for (var i = sheetObjects[0].HeaderRows; sheetObjects[0].RowCount > 0 && i <= sheetObjects[0].LastRow; i++) {
    		  if((sheetObjects[0].RowStatus(i) == "I" || sheetObjects[0].RowStatus(i) == "U") 
    				  && sheetObjects[0].CellValue(i, "note_clss_cd") == "D") {
    			  returnValue = "N";
    		  }
    	  }

    	  if (returnValue == "N") {
    		  if (ComShowCodeConfirm("PRI00006")) {
    			  supressConfirm = true;
    			  if (validateForm(sheetObjects[0],document.form,IBSAVE)) {
    				  var rslt = doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
    				  
    				  if(rslt) {
            			  returnValue = "Y";
            		  }
    			  }
    			  supressConfirm = false;
    		  } else {
    			  returnValue = "Y";
    		  }
    	  }

    	  return returnValue;
      }
      
     /**
      * SYS_GUID()값을 리턴하는 function <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param 없음
      * @return sValue EtcData
      * @author 최성민
      * @version 2009.08.13
      */       
      function getSYSGUID() {
      	var formObj = document.form;
      	formObj.f_cmd.value = COMMAND38;
      	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
      	var sValue = ComGetEtcData(sXml,"SYS_GUID");
      	return sValue;
      }
      	     
    
	/**
     * 버튼 권한 컨트롤 function <br>
     * 버튼을 제어한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl(mode)
     * </pre>
     * @param  {string} mode 필수 사용자 권한이나 모드
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */
  	function buttonControl(mode){
 		var formObj = document.form;
 		var req_usr_flg = formObj.req_usr_flg.value;
 		var apro_usr_flg = formObj.apro_usr_flg.value;
 		var amdt_seq = formObj.amdt_seq.value;
 		var sts = formObj.prop_sts_cd.value;
 		var row_cnt = sheetObjects[0].RowCount;
 		try{		
 				ComBtnDisable("btn_retrieve");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_acceptall");
				ComBtnDisable("btn_cancelall");
				ComBtnDisable("btn_rowadd1");
				ComBtnDisable("btn_delete1");
				ComBtnDisable("btn_rowadd2");
				ComBtnDisable("btn_delete2");
				ComBtnDisable("btn_accept");
				ComBtnDisable("btn_acceptcancel");
				
				if(amdt_seq > 0){
					showButton("btn_amend");
					showButton("btn_amendcancel");
					ComBtnDisable("btn_amendcancel");
					ComBtnDisable("btn_amend");
				} else {
					hiddenButton("btn_amend");
					hiddenButton("btn_amendcancel");
				}

				if(mode == "CLEAR") {
					return;
				}
				
 			switch(sts) {
 				case 'I':   // Initial
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg=="true" || req_usr_flg=="true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_rowadd1");
 						ComBtnEnable("btn_delete1");
 						ComBtnEnable("btn_rowadd2");
 						ComBtnEnable("btn_delete2");
 						ComBtnEnable("btn_amend");
 						ComBtnEnable("btn_amendcancel");
 						
 						if(amdt_seq > 0){
 							showButton("btn_amend");
 							showButton("btn_amendcancel");
 						}
 					}				
 					break;
 					
 				case 'Q':   // Requested
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg=="true" ){
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}
 					break;
 					
 				case 'R':   // Returned
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg=="true" || req_usr_flg=="true" ){
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}				
 					break;
 					
 				case 'A':   // Approved
 	 				ComBtnEnable("btn_retrieve");
 				case 'F':   // Filed
 	 				ComBtnEnable("btn_retrieve");
 				case 'C':   // Cancled
 	 				ComBtnEnable("btn_retrieve");
 					break;		
 			}	
 			
 		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
 		}
 	}
    
	/* 개발자 작업  끝 */