/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057_12.js
*@FileTitle : Amendment History Inquiry - Special Note
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.07 최성민
* 1.0 Creation
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
     * @class ESM_PRI_0057_12 : ESM_PRI_0057_12 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0057_12() {
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
	
	var sChgCdVisiable = "";
	
	var delTotal = false;//DETAIL의 마지막 ROW를 삭제할때 사용되는 FLAG

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
		
        loadSts = true;
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

					var HeadTitle = "|Sel.|Seq.|dp_seq|Item|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq|||";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		40,    	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++ , dtDataSeq, 		30, 	daCenter, 	false,	"seq");
					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtCombo,   		100,   	daLeft,  	false,	"note_clss_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,     	700,   	daLeft,  	false,	"note_tit_nm",   	false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "src_info_cd");    
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "prc_prog_sts_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");

	                InitDataCombo(0, "note_clss_cd", noteClssCdComboText, noteClssCdComboValue);  
	                
                    AutoRowHeight = false;
 					WaitImageVisible = false;

	                //Edit 불가능 한 셀 구분하기
	                UnEditableColor = RgbColor(0,0,0);
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

					var HeadTitle = "|Sel.|dp_seq|Seq.|Surcharge|Content|Conversion|Conversion|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date" +
									"|note_seq|note_ctnt_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq|note_conv_mapg_id|note_chg_tp_cd|n1st_cmnc_amdt_seq";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		40,    	daCenter,  	false,	"chk");
					InitDataProperty(0, cnt++ , dtHidden,		50,   	daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtDataSeq, 		30, 	daCenter, 	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,   		100,  	daCenter,	false, 	"chg_cd", 					false,	"",	dfNone, 	0,		false,		false, 3);
 					InitDataProperty(0, cnt++ , dtData,     	350,    daLeft,		false, 	"note_ctnt",   				false,	"",	dfNone, 	0, 		false, 		false);
 					
 					InitDataProperty(0, cnt++ , dtDummyCheck,  	70,		daCenter,	false, 	"note_conv_flg", 			false,	"",	dfNone,		0, 		false, 		false, -1, false, false, "", false);
 					InitDataProperty(0, cnt++ , dtPopup, 	  	20,		daRight,	false, 	"note_conv_mapg_id_pop",  	false,	"",	dfNone,		0, 		false, 		false);
 					InitDataProperty(0, cnt++ , dtData,      	75,    daCenter, 	false,	"eff_dt",  					false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtData,      	75,    daCenter, 	false, 	"exp_dt",   	   			false,	"",	dfDateYmd, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtCombo,     	70, 	daCenter, 	false, 	"src_info_cd", 				false,	"",	dfNone, 	0, 		false, 		false);
 					
 					InitDataProperty(0, cnt++ , dtCombo,     	70,    daCenter, 	false, 	"prc_prog_sts_cd", 			false,	"",	dfNone, 	0, 		false,  	false);
 					InitDataProperty(0, cnt++ , dtData,      	140,	daLeft,  	false,	"acpt_usr_nm",				false,	"",      dfNone, 			0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,  	false,	"acpt_dt",					false,	"",      dfDateYmd, 		0,     false,      false);
					 
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_seq");
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_ctnt_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
					
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_conv_mapg_id");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_chg_tp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");

	                InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");            
	                InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue, "", "I");
	                

	                //Edit 불가능 한 셀 구분하기
	                UnEditableColor = RgbColor(0,0,0);
	                
 					ColHidden("chg_cd") = true;
 					AutoRowHeight = false;
 					ShowButtonImage = 2;
 					WaitImageVisible = false;
 				}
                 break;
         }
     }
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
		if (OldRow != NewRow) {			
			formObj.note_seq.value = sheetM.CellValue(adjNewRow, "note_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
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
					formObj.f_cmd.value = SEARCH01;
					formObj.note_tp_cd.value = "P";
					//CONVERSION CHECK 메인에서 직접 호출
					//formObj.con_chk.value = parent.getConversionValue(); 
					
					if(formObj.amdt_seq.value == 0 && formObj.con_chk.value == "0") {
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						return false;
					}
					
					sheetObj.DoSearch("ESM_PRI_0057_12GS.do" , FormQueryString(formObj));
	  				break;
	  				
	  			case IBSEARCHAPPEND: // 조회
	  				ComOpenWait(true);
	  				formObj.f_cmd.value = SEARCH02;
	  				formObj.note_tp_cd.value = "P";
	  				sheetObj.DoSearch("ESM_PRI_0057_12GS.do" , FormQueryString(formObj));  				
					manageMasterChange(sheetObjects[0], sheetObjects[0].SelectRow, null);	
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
    * OnClick 이벤트 발생시 호출되는 function <br>
    * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
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
 	    
      	switch(colname)
      	{
      		case "note_ctnt":
	    		ComShowMemoPad(sheetObj, Row, Col, true, 350);
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
  		var colName = sheetObj.ColSaveName(Col);
  		var formObj = document.form;
  		//var ctrtExpDt = parent.getCtrtExpDate();
				  		
  		if (colName == "note_conv_mapg_id_pop") {	
  			if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "D") {
  				ComPriOpenPopup('EES_DMT_2001.do?prop_no=' + formObj.prop_no.value + '&caller=2007', 1024, 700, 'findCustomer', '1,0,1,1,1,1,1', true);
  			} else if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "C") { //[CHM-201327107] CHSS 노트 항목 추가
				ComOpenPopup('EES_CGM_1209.do?prop_no=' + formObj.prop_no.value, 1024, 580, '', '1,0,1,1,1,1,1', true);		
			} else {
  				  				
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
  					//sParam += "&exp_dt=" + sheetObj.CellValue( Row, "exp_dt");
  					//sParam += "&exp_dt=" + ctrtExpDt;
  					sParam += "&master_seq=" + sheetObjects[0].SelectRow;
  					sParam += "&detail_seq=" + sheetObjects[1].SelectRow;
  					sParam += "&con_chk=" + formObj.con_chk.value; 
  															
  					var sUrl = "/hanjin/ESM_PRI_0102.do?"+sParam;			
  					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0102", 1020, 625, true);
  				
  					var array = new Array();
					if(rtnVal != null && rtnVal.length > 0) {
						//CONVERSION 화면에서 CONTENTS별 저장이 가능하기때문에 FOR문절 사용
						for(var i=0; i < rtnVal.length; i++) {
							//CONVERSION 화면에서 선택ROW가 변동가능하기 때문에 FOR문절 사용
							for(var j = sheetObj.HeaderRows; j <= sheetObj.LastRow; j++) {
								if(sheetObj.CellValue(j, "note_seq") == rtnVal[i].master_seq 
										&& sheetObj.CellValue(j, "note_ctnt_seq") == rtnVal[i].detail_seq
	  									&& sheetObj.CellValue(j, "amdt_seq") == rtnVal[i].amdt_seq ) {
									sheetObj.CellValue2(j, "note_conv_flg") = rtnVal[i].note_conv_flg;
									sheetObj.CellValue2(j, "note_chg_tp_cd") = rtnVal[i].note_chg_tp_cd;
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
 		var sLgcyIfFlg	= formObj.lgcy_if_flg.value;
		//DETAIL의 모든 로우의 SOURCE가 AD일경우 MASTER에 색처리		
		for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if(sheetObj.CellValue(i,"amdt_seq") > 0 && sLgcyIfFlg != "Y") {
				if(sheetObj.CellValue(i,"src_info_cd") == 'AD') {
					sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
					sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
				} else if(sheetObj.CellValue(i,"src_info_cd") == 'AM' || sheetObj.CellValue(i,"src_info_cd") == 'NW') {
					sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
				} 
			}
		}
		//하이라이트 처리
		changeSelectBackColor4Master(sheetObj, document.form);
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
    	 var sLgcyIfFlg		= formObj.lgcy_if_flg.value;
     	 var noteClssCd		= sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd");
     		    	 
     	 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
     		     		 
     		  // AMDT_SEQ가 다르면 DISABLE
     		  if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq){ 
     			  sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
     			  
     			  sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = false;
     		  } else {
     			  sheetObj.CellEditable(i,"note_conv_mapg_id_pop") = true;
     		  }
 			 	
     		  if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && sLgcyIfFlg != "Y"){
     			  sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
     		  }     		  
 	  		
     		
 	    	 	  		     		  
     		  //InitDataProperty에서 ALLCHECK:FALSE 일경우에 EDITABLE FALSE가 안먹임
     		  sheetObj.CellEditable(i,"note_conv_flg") = false;
     	 }
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
			
			if(noteClssCd == "S") {
				sheetObjects[1].ColHidden("chg_cd") = false;
			} else {
				sheetObjects[1].ColHidden("chg_cd") = true;
			}

  			//하이라이트 처리
  			changeSelectBackColor4Master(sheetObjects[0], document.form);
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
	  * @param {string} sConChk 필수 Conversion check 값
	  * @return 없음
	  * @author 최성민
	  * @version 2009.05.21
	  */ 
	 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
	 	var formObject = document.form;
	 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	 		formObject.prop_no.value = sPropNo;
	 		formObject.amdt_seq.value = sAmdtSeq;
	 		formObject.svc_scp_cd.value = sSvcScpCd;
	 		formObject.con_chk.value = sConChk;
 			formObject.lgcy_if_flg .value = sLgcyIfFlg ;

	 		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
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
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
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
  
    var loadSts = false;
    /**
     * 메인에서 호출하는 function <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *loadFinishCheck()
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.05.19
     */
    function loadFinishCheck(){
        return loadSts;
    }        
	/* 개발자 작업  끝 */