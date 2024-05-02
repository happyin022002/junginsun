/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0146.js
*@FileTitle : BSA용 선박 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier :  
*@LastVersion : 1.0
=========================================================
* History
* 2007.07.25  
* 2009.10.23 New FrameWork 적용
* 2010.02.24 업무처리중 버튼사용 금지 처리
* 2010.04.14 FormQueryString =>masFormQueryString 변경
* 2010.06.14 [Legacy전환] UI 표준안 적용 요청 관련 수정
* 2010.12.01 MAS Architecture 위배사항 수정
* 2011.01.14 Vessel History 화면 기능보완 - 저장후 sheet 콤보 초기화 순서변경
* 2011.01.27 Create VSL Table 수정
*                  OPR, OPR2 필드 위치 변경, mandatory 처리  및 동적 메소드 적용
* 2011.08.16 [MAS]Create VSL table Operator 정보 표시
* 2016.03.16 Create Lane Table, Create Vessel Table history 자동 관리
=========================================================
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0146 : ESM_MAS_0146 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	function ESM_MAS_0146() {
	    this.processButtonClick = processButtonClick ;
	    this.loadPage           = loadPage           ;
	    this.initSheet          = initSheet          ;
	    this.initRetrieve       = initRetrieve       ;
	    this.setSheetObject     = setSheetObject     ;
	    this.getEdtDate         = getEdtDate         ;
	    this.sheet1_OnChange    = sheet1_OnChange    ;
	    this.doActionIBSheet    = doActionIBSheet    ;
	    this.validateForm       = validateForm       ;
	    this.chkValidCreate     = chkValidCreate     ;   
	}
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var sheet_height = 20; // sheet의 height

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
	 * 설  명 : 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <b>Example : </b>
	 * <pre>
	 *    processButtonClick()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
	
		try {
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
		
				case "btn_Save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			
				case "btn_Downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
			
				case "btng_Rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
			
				case "btn_Close":
					self.close();
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
	 * 설  명 :  Sheet 기본 설정 및 초기화 <br>
	 *          body 태그의 onLoad 이벤트핸들러 구현<br>
	 *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadPage(VslSubTrade) {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1,VslSubTrade);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		initRetrieve();
	}

	/**
	 * 설  명 :  시트 초기설정값, 헤더 정의 <br>
	 *          시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     initSheet(sheetObj,sheetNo,tpszValue)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {Number}	sheetNo  - Sheet Number (시트오브젝트 태그의 아이디에 붙인 일련번호)
	 * @param {String}	VslSubTrade  - VslSubTrade
	 * @param {String}	ownerShip  - ownerShip
	 * @param {String}	vslOpr  - vslOpr
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function initSheet(sheetObj, sheetNo, VslSubTrade) {
		var cnt = 0;
		var colNo = 0;
		var subColNo = 0;
		var vslText = VslSubTrade;
		var aryCD = vslText.split("|");
		if(vslText != "") subColNo = aryCD.length;
	
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					colNo = subColNo + 25;
					SheetWidth = mainTable.clientWidth;			//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);		//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;					//전체Merge 종류 [선택, Default msNone]
					Editable = true;							//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo(2 , 1, 9, 100);					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colNo, 2, 0, true);				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false);	// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle0  = "Del.|STS|SEQ|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|VVD|From|To|VSL\nClass|Port Class|Designed\nCapa.|Standard \nLoadable Capa.|crr_cd|bsa_vsl_flg|vsl_rgst_cnt_cd";
					for(j=0; j<subColNo; j++) HeadTitle0  = HeadTitle0 + "|Trade Loadable Capa. By Trade";
					HeadTitle0  = HeadTitle0 + "|cre_usr_id|trd_chk_flg|vsl_prc|vsl_prc_rto|vsl_retn_fm_dt|vsl_retn_to_dt|Update User ID|Update Time";
				
					var HeadTitle1  = "Del.|STS|SEQ|VSL|T/P|OPR\n(Operation)|OPR2\n(Owner)|VVD|From|To|VSL\nClass|Port Class|Designed\nCapa.|Standard \nLoadable Capa.|crr_cd|bsa_vsl_flg|vsl_rgst_cnt_cd|"
									+ vslText
									+ "|cre_usr_id|trd_chk_flg|vsl_prc|vsl_prc_rto|vsl_retn_fm_dt|vsl_retn_to_dt|Update User ID|Update Time";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, true);
				
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDelCheck,   30, daCenter, true, "del_check");
					InitDataProperty(0, cnt++, dtStatus,     30, daCenter, true, "ibflag");
					InitDataProperty(0, cnt++, dtData,       50, daCenter, true, "vsl_seq",         true,  "", dfNone    ,  0, false,  false);                    
					InitDataProperty(0, cnt++, dtData,       50, daCenter, true, "vsl_cd",          true,  "", dfEngUpKey,  0, false,  false, 4, true);
					InitDataProperty(0, cnt++, dtData,       40, daCenter, true, "vsl_tp_cd",       false, "", dfEngUpKey,  0, false,  false, 1);
					InitDataProperty(0, cnt++, dtCombo,      85, daCenter, true, "vop_cd",          true , "", dfNone,      0, true,  true, 3);
					InitDataProperty(0, cnt++, dtCombo,      65, daCenter, true, "vsl_oshp_cd",     true , "", dfNone,      0, true,  true, 3);
					InitDataProperty(0, cnt++, dtData,       70, daCenter, true, "vvd_cd",          false, "", dfNone,      0, true,  true);                    
					InitDataProperty(0, cnt++, dtData,       70, daCenter, true, "vsl_aply_fm_dt",  true, "", dfDateYmd,   0, true,  true);
					InitDataProperty(0, cnt++, dtData,       70, daCenter, true, "vsl_aply_to_dt",  true, "", dfDateYmd,   0, true,  true);                    
					InitDataProperty(0, cnt++, dtData,       70, daRight , true, "vsl_clss_capa",   false, "", dfInteger,   0, false,  false);
					InitDataProperty(0, cnt++, dtData,       70, daRight , true, "port_clss_capa",  false, "", dfInteger,   0, false,  false);
					InitDataProperty(0, cnt++, dtData,       70, daRight , true, "vsl_dznd_capa",   false, "", dfInteger,   0, false,  false);
					InitDataProperty(0, cnt++, dtData,      100, daRight , true, "stnd_ldb_capa",   false, "", dfFloat, 3, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "crr_cd",   false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "bsa_vsl_flg",   false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "vsl_rgst_cnt_cd",   false, "", dfNone, 0, true,  true);
					for(j=0; j<subColNo; j++){
						InitDataProperty(0, cnt++, dtData,    80, daRight,  true, aryCD[j],      false, "", dfFloat,   3, true,  true);
					}
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "cre_usr_id",   false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "trd_chk_flg",   false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "vsl_prc",   false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "vsl_prc_rto",   false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "vsl_retn_fm_dt",   false, "", dfNone, 0, true,  true);
					InitDataProperty(0, cnt++, dtHidden,      100, daRight , true, "vsl_retn_to_dt",   false, "", dfNone, 0, true,  true);
					
					InitDataProperty(0, cnt++ , dtData,	    110,	daCenter,	true,		"upd_usr_id",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	    120,	daCenter,	true,		"upd_dt",			false,		"",		dfNone,		0,		false,		false);
					HeadRowHeight  = 10;
					CountPosition  = 0 ;
					style.height = GetSheetHeight(sheet_height) ;
					InitDataValid(0, "vsl_cd", vtEngUpOnly);
					//RangeBackColor(1, 14, 1, 20) = RgbColor(222, 251, 248);
				}
				break;
		}
	}

	function initRetrieve(){
		var formObject = document.form;      
		var sheetObject = sheetObjects[0];             
		doActionIBSheet(sheetObject,formObject,IBSEARCH);            
	} 

	/**
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setSheetObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * 설  명 : VVD 가 변경되면 해당 FIRST LOADING PORT ETD DT를 가지고 온다.<br>
	 * 		(ESM_MAS_5141.jsp에서 호출하는 함수.)<br>
	 *      return된 FIRST LOADING PORT ETD DT을 sheet에 적용시키거나 에러메세지 표시.
	 *          
	 * <br><b>Example : </b>
	 * <pre>
	 *     parent.getEdtDate("<%=rtnValue%>");
	 * </pre>
	 * @param {String}	result  - 결과값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function getEdtDate(selRow,result) {
		var sheetObject1 = sheetObjects[0];
		var tmpRow = 0;
	
		if(result == null || result == "" || result == "null"){
			ComShowMessage(ComGetMsg('MAS10027',sheetObject1.CellValue(selRow,"vvd_cd")));
			sheetObject1.SelectCell(selRow, "vvd_cd",true);
		} else {
			sheetObject1.CellValue(selRow,"vsl_aply_fm_dt") = result;
		}
	}

	/**
	 * 설  명 : 셀의 값이 바뀌었을 때 발생하는 이벤트 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnChange(sheetObj, Row, Col, Val)
	 * </pre>
	 * @param {object}	sheetObj - sheet
	 * @param {Long}	Row  - 해당 셀의 Row Index
	 * @param {Long}	Col  - 해당 셀의 Column Index
	 * @param {String}	Val  - 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		with(sheetObj) {
			// FROM DATE를 변경하면 이전 데이터의 TO DATE를 변경시켜준다.
			if (ColSaveName(Col) == "vsl_aply_fm_dt") {
				if (Row > 2) {
					//Day-1 추출 로직 적용
					CellValue2(Row-1,"vsl_aply_to_dt") = ComGetDateAdd(Value, "D", -1, "-");
				}
			}
			// VVD 가 변경되면 해당 FIRST LOADING PORT ETD DT를 가지고 온다.
			if (ColSaveName(Col) == "vvd_cd") {
				var param = "f_cmd="+SEARCH01;
         		param = param + "&f_vsl_cd="+Value;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0146GS.do", param);
				var arrXml = sXml.split("|$$|");
				getEdtDate(Row,ComMasGetEtcData(arrXml[0], "rtnValue"));
				
			}
			if (sheetObj.ColSaveName(Col) == "stnd_ldb_capa") {
				// stnd_ldb_capa값이 변경되면 Trade에 값을 
				// stnd_ldb_capa값으로 초기화시킨다.
				// 단, OPR2가 'SML'가 아닐 경우만.
				if(sheetObj.CellValue(Row, "vop_cd") != "SML"){
					var num = 0;
					var header = document.form.f_header.value;
					var subTrade = header.split("|");
				
					if(header != "") num = subTrade.length;
					for(j=0;j<num; j++){
						sheetObj.CellValue(Row, subTrade[j]) = sheetObj.CellValue(Row, "stnd_ldb_capa");
					}
				}
			}
			if ( sheetObj.ColSaveNAme(Col) == "del_check"){
				if(Row == 2){
			
				}
			}
			
			//-----------------------------------------------
	        // 2011.01.25
	        // OPR(Operation) 변경시 OPR2(Owner) ComboList 재조회.
	        //-----------------------------------------------
	        if(sheetObj.ColSaveName(Col) == "vop_cd"){
	        	if(Value == "") {
	        		sheetObj.CellValue(Row, "vsl_oshp_cd") = "";
	        		sheetObj.CellComboItem(Row, "vsl_oshp_cd", " |", " |");
	        	} else {
	        		var param = "";
	        		param = param+"&f_cmd="+SEARCH02;
	        		param = param+"&f_vop_cd="+sheetObj.CellValue(Row,Col);
	        		
	        		var sXml = sheetObj.GetSearchXml("ESM_MAS_0146GS.do", param);
	        		
	        		var arrXml = sXml.split("|$$|");
	        		
	        		if (arrXml.length > 0)
	        			ComMasSetIBCombo(sheetObj, arrXml[0], "vsl_oshp_cd", true,0,Row);
	        	}
	        }
		}
	}

	/**
	 * 설  명 : Sheet관련 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	// 업무처리중 버튼사용 금지 처리		

		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0146GS.do", masFormQueryString(formObj))
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0)
					ComMasSetIBCombo(sheetObj, arrXml[0], "vop_cd", true, 0);
				
				// 2011.01.27 동적메소드로 변경하여 세팅 불필요
				//if (arrXml.length > 1)
				//	ComMasSetIBCombo(sheetObj, arrXml[1], "vsl_oshp_cd", true, 0);
				
				ComOpenWait(false);
				break;
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
			
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				var xml = sheetObj.GetSearchXml("ESM_MAS_0146GS.do", masFormQueryString(formObj))
				formObj.f_header.value = ComGetEtcData(xml, "header");

				// Header 정보를 변경하기 위해 sheet를 초기화 한다.
				//--------------------------------------------------
				// Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				sheetObj.Redraw = true;
				initSheet(sheetObj, 1, formObj.f_header.value);
				sheetObj.Visible = true;
				//--------------------------------------------------
				doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
				sheetObj.LoadSearchXml(xml);
				sheetObj.RemoveEtcData();
				
				ComOpenWait(false);
				
				checkDate(sheetObj);
				
				break;

			case IBSAVE:        //저장
				if(!chkValidCreate(sheetObj,formObj)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_MAS_0146GS.do", masFormQueryString(formObj), -1, false);
				ComOpenWait(false);
				break;

			case IBINSERT:      // 입력
				sheetObj.DataCopy(); //행복사

				var num = 0;
				for(i=1; i<=sheetObj.LastRow; i++){
					if(ComParseInt(num)<ComParseInt(sheetObj.CellValue(i, "vsl_seq")))
						num = sheetObj.CellValue(i, "vsl_seq");
				}
				num = ComParseInt(num) + 1;
				sheetObj.CellValue2(sheetObj.SelectRow , "vsl_seq") = num;
				sheetObj.CellValue2(sheetObj.SelectRow, "upd_usr_id") = "";
				sheetObj.CellValue2(sheetObj.SelectRow, "upd_dt") = "";
				break;			

			case IBDOWNEXCEL:        //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
				var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
						sheetObj.Down2Excel(0, false, false, true);
						break;
					case "DY":
						sheetObj.Down2Excel(-1, false, false, true);
						break;
					case "AN":
						sheetObj.SpeedDown2Excel(0, false, false);
						break;
					case "DN":
						sheetObj.SpeedDown2Excel(-1, false, false);
						break;
				}               
				break;
		}
	}
	
	/**
	 * 설  명 : 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     validateForm(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(formObj.f_vsl_cd.value != ""){
				if (!ComIsAlphabet(formObj.f_vsl_cd, "un")) {
					ComShowMessage(ComGetMsg("COM12114", "Vessel"));
					formObj.f_vsl_cd.select();
					return false;
				}// end if
			}// end if
		}

		return true;
	}

	/**
	 * 설  명 : 저장시 화면에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     chkValidCreate(sheetObj,formObj)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function chkValidCreate(sheetObj,formObj){
		var cntTotal = sheetObj.RowCount;
		var cntDel	= sheetObj.RowCount("D");
		var strRowNum = sheetObj.FindStatusRow("I|U");
		var arrRow = strRowNum.split(";");
		var cnt = 0;
		if(strRowNum != "") cnt = arrRow.length-1;

		if( cntTotal == cntDel) {
			ComShowCodeMessage("COM130302","all data");
			return false;
		}
		with(formObj){
			for(var i=1; i<=sheetObj.LastRow; i++){       
				var vsl_aply_fm_dt = sheetObj.CellValue(i,"vsl_aply_fm_dt");
				var vsl_aply_to_dt = sheetObj.CellValue(i,"vsl_aply_to_dt");
			
				if(sheetObj.CellValue(i,"ibflag") != "R"){
					if(vsl_aply_fm_dt == "") {
						ComShowMessage(ComGetMsg("COM12114","vsl_aply_fm_dt",""));
						sheetObj.SelectCell(i, "vsl_aply_fm_dt");
						return false;
					}
			
					if(vsl_aply_to_dt == "") {
						ComShowMessage(ComGetMsg("COM12114","vsl_aply_to_dt",""));
						sheetObj.SelectCell(i, "vsl_aply_to_dt");
						return false;
					}
				}
			}
		}
		return true;
	}
	
	function checkDate(sheetObj){
    	for(var k=2; k<=sheetObj.LastRow-1; k++){			
					var from_value = sheetObj.CellValue(k,'vsl_aply_fm_dt');				
					var year_of_from_value = from_value.substring(0,4);
					var month_of_from_value = from_value.substring(4,6);
					var day_of_from_value = from_value.substring(6,8);				
				
					var to_value = sheetObj.CellValue(k,'vsl_aply_to_dt');				
					var year_of_to_value = to_value.substring(0,4);
					var month_of_to_value = to_value.substring(4,6);
					var day_of_to_value = to_value.substring(6,8);				
					
					var from_value_of_the_next_seq = sheetObj.CellValue(k+1,'vsl_aply_fm_dt');
					var year_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(0,4);
					var month_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(4,6);
					var day_of_from_value_of_the_next_seq = from_value_of_the_next_seq.substring(6,8);				
					
					var to_value_of_the_next_seq = sheetObj.CellValue(k+1,'vsl_aply_to_dt');
					var year_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(0,4);
					var month_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(4,6);
					var day_of_to_value_of_the_next_seq = to_value_of_the_next_seq.substring(6,8);	
					
					// activated when 'To' date is earlier than 'From' date (in the same sequence)
					if( year_of_from_value > year_of_to_value ){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if( year_of_from_value == year_of_to_value && month_of_from_value > month_of_to_value ){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if( year_of_from_value == year_of_to_value && month_of_from_value == month_of_to_value && day_of_from_value > day_of_to_value ){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}					
					
					// activated when 'To' date is later than(or the same with) 'From' date of the next sequence
					if(year_of_to_value > year_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_from_value_of_the_next_seq && month_of_to_value > month_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_from_value_of_the_next_seq && month_of_to_value == month_of_from_value_of_the_next_seq && day_of_to_value >= day_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}
					
					// activated when 'To' date is later than(or the same with) 'To' date of the next sequence
					if(year_of_to_value > year_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_to_value_of_the_next_seq && month_of_to_value > month_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_to_value == year_of_to_value_of_the_next_seq && month_of_to_value == month_of_to_value_of_the_next_seq && day_of_to_value >= day_of_to_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_to_dt') = sheetObj.RgbColor(192, 0, 0);
					}
					
					// activated when 'From' date is later than(or the same with) 'From' date of the next sequence
					if(year_of_from_value > year_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_from_value == year_of_from_value_of_the_next_seq && month_of_from_value > month_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}else if(year_of_from_value == year_of_from_value_of_the_next_seq && month_of_from_value == month_of_from_value_of_the_next_seq && day_of_from_value >= day_of_from_value_of_the_next_seq){
						sheetObj.CellBackColor(k,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
						sheetObj.CellBackColor(k+1,'vsl_aply_fm_dt') = sheetObj.RgbColor(192, 0, 0);
					}
		} // the end of the for loop 
    }