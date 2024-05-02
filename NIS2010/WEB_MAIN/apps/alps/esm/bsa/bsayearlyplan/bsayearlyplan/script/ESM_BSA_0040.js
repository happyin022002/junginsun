/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0040.js
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.17 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가 - BSA I/F 버튼추가
* 2011.05.23 최윤성 [CHM-201110969-01] BSA Creation 화면 기능 보완 - Save Validation 추가
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
     * @class ESM_BSA_0040 : ESM_BSA_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0040() {
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



    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    	/**
    	 * @extends 
    	 * @class ESM_BSA_0040 : ESM_BSA_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    	 */
    	function ESM_BSA_0040() {
    	    this.processButtonClick		= processButtonClick;
    	    this.loadPage 				= loadPage;
    	    this.initSheet 				= initSheet;
    	    this.setSheetObject 		= setSheetObject;
    	    this.sheet1_OnChange 		= sheet1_OnChange;
    	    this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    	    this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
    	    this.doActionIBSheet 		= doActionIBSheet;
    	}

    	// 공통전역변수
    	var sheetObjects = new Array();
    	var sheetCnt = 0;
    	
    	var sheet_selno = ""; //현재선택된 SHEET
    	
    	var JOINT_OPERATING  = "";
    	var SPACE_CHARTERING = "";
    	
    	var splitPos1 = new Array(0, 3, 6, 9, 12, 15);
    	var splitPos2 = new Array(0, 3, 6, 9, 12, 15);
    	
    	var fixCnt1 = 19; //Sheet1 고정길이  (※주의: EsmBsa0040ViewAdapter 에서도 수정할 것)
    	var fixCnt2 = 17; //Sheet2 고정길이  (※주의: ESM_BSA_021GS2.jsp에서도 수정할 것)
    	
    	var LOGIC_fnl_capa = "";
    	var LOGIC_sub_capa  = "";
    	
    	var selRow = 0;
    	var selValue = "";
    	
    	var sheet_height1 = 20; // sheet1의 height
    	var sheet_height2 = 20; // sheet2의 height
    	var zoomFlag1 = "close"; // Zoom Flag #1
    	var zoomFlag2 = "close"; // Zoom Flag #2
    	
    	var first_load1 = true;  //최초 Load시만 sheet1 height 조정
    	var first_load2 = true;  //최초 Load시만 sheet2 height 조정
    	
    	
    	var comboObjects = new Array();
    	var comboCnt = 0;
    	var loadingMode = false;
    	
    	/**
    	* Sheet 기본 설정 및 초기화
    	* body 태그의 onLoad 이벤트핸들러 구현
    	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	*/
    	function loadPage(headText1,headText2,headText3,headText4) {
    		var head1 = "";
    		var head2 = "";
    		
    		for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet(sheetObjects[i]);
    			if (i==0) {
    				head1 = headText1;
    				head2 = headText2;
    			} else {
    				head1 = headText3;
    				head2 = headText4;
    			}
    			initSheet(sheetObjects[i],i+1,head1,head2);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		JOINT_OPERATING  = document.form.rdoOp_cd[0].value;
    		SPACE_CHARTERING = document.form.rdoOp_cd[1].value;
    		document.getElementById("tabLayer2").style.display = "none";
    		//tabLayer2.style.display = "none";
    		sheet_selno = JOINT_OPERATING; //현재선택된 SHEET (첫번째 쉬트)
    		set_Zoom();
    		
    		// 멀티콤보 처리
    		loadingMode = true;
    		loadCombo();
    		
    		for(k=0;k<comboObjects.length;k++){
    			initCombo(comboObjects[k],comboObjects[k].id);
    		}
    		loadingMode = false;
    	}
    	
    	function loadCombo() {
        	var formObj = document.form;
     		var sXml = formObj.sXml.value;

     		var arrXml = sXml.split("|$$|");
     		
     		if (arrXml.length > 0)
    			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
    		if (arrXml.length > 1)
    			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
    		if (arrXml.length > 2)
    			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
     		document.form.sXml.value="";
         }
    	
    	/**
    	* IBSheet Object를 배열로 등록
    	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    	* 배열은 소스 상단에 정의
    	*/
    	function setSheetObject(sheet_obj) {
    		sheetObjects[sheetCnt++] = sheet_obj;
    	}
    	
    	/**
    	* IBCombo Object를 배열로 등록
    	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    	* 배열은 소스 상단에 정의
    	*/
    	function setComboObject(combo_obj){
    		comboObjects[comboCnt++] = combo_obj;
    	}
    	
    	
    	/**
    	* IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
    	*/
    	function setIBMultiCombo(sheetObj, sXml ,objName){
    		if (sXml == undefined || sXml == ""){
    			return;
    		}
    		var arrData = ComCoaXml2SheetMultiComboString(sXml, "code", "code");
    		sheetObj.InitDataCombo(0,objName, arrData[1], arrData[0],"","");		
    	}
    	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    	document.onclick = processButtonClick;
    	
    	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick() {
    		var sheetObject1 = sheetObjects[0];
    		var sheetObject2 = sheetObjects[1];
    		var formObject = document.form;
    		
    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    		
    			switch(srcName) {		
    				case "btn_retrieve":
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
    					}
    					break;
    		
    				case "btn_save":
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						doActionIBSheet2(sheetObject2,formObject,IBSAVE);
    					}
    					break;
    		
    				case "btn_downexcel":
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
    					}
    					break;
    		
    				case "btns_calendar1":
    					var cal = new ComCalendar();
    					cal.select(formObject.txtSDate, 'yyyy-MM-dd');
    					break;
    		
    				case "btns_calendar2":
    					var cal = new ComCalendar();
    					cal.select(formObject.txtEDate, 'yyyy-MM-dd');
    					break;
    		
    				case "rdoOp_cd":
    					if (formObject.rdoOp_cd[0].checked) { //JO 선택시
    						document.getElementById("tabLayer1").style.display= "inline";
    					document.getElementById("tabLayer2").style.display= "none";
    					sheet_selno = formObject.rdoOp_cd[0].value; //'J'
    					//doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    					} else if (formObject.rdoOp_cd[1].checked) { //SC 선택시
    						document.getElementById("tabLayer1").style.display= "none";
    					document.getElementById("tabLayer2").style.display= "inline";
    					sheet_selno = formObject.rdoOp_cd[1].value; //'S'
    					//doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
    					}
    					set_Zoom();
    					break;
    		
    				case "rdoType":
    					var checkedIdx = -1;
    					var obj = formObject.rdoType;
    					for(var i=0; i<obj.length; i++) {
    						if (obj[i].checked) {
    							checkedIdx = i;
    							break;
    						}
    					}
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						sheetObject1.LeftCol = (fixCnt1-1) + splitPos1[checkedIdx];
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						sheetObject2.LeftCol = (fixCnt2-1) + splitPos2[checkedIdx];
    					}
    					break;
    		
    				case "bu_zoom_in1": //next
    				case "bu_zoom_in2":
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						sheet_height1 = getSheetHeightCnt(sheetObject1,"MAX",1);
    					sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
    					zoomFlag1 = "open";
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						sheet_height2 = ComGetSheetViewRows(sheetObject2,"MAX",1);
    					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
    					zoomFlag2 = "open";
    					}
    					set_Zoom();
    					parent.syncHeight();
    					break;
    		
    				case "bu_zoom_out1": //next
    				case "bu_zoom_out2":
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						sheet_height1 = getSheetHeightCnt(sheetObject1,"MIN",0);
    					sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
    					zoomFlag1 = "close";
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						sheet_height2 = ComGetSheetViewRows(sheetObject2,"MIN",0);
    					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
    					zoomFlag2 = "close";
    					}
    					set_Zoom();
    					parent.syncHeight();
    					break;
    					
    				case "btng_bsaif":
    					var opCd = "";
    					if (formObject.rdoOp_cd[0].checked) { //JO 선택시
    						opCd = formObject.rdoOp_cd[0].value;
    					} else if (formObject.rdoOp_cd[1].checked) { //SC 선택시
    						opCd = formObject.rdoOp_cd[1].value;
    					}
    					
    					var param = "?cobTrade="  + comboObjects[0].Code
    					          + "&cobLane="   + comboObjects[1].Code
    					          + "&opCd="      + opCd
    					          + "&ctrtprice=" + "contract";
    					
    					var rtn = window.showModalDialog("ESM_BSA_0045.do" + param, "BSA Data IF", "dialogWidth:400px;dialogHeight:315px");
    					
    					if (rtn == "reLoad") {
    						if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
        						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
        					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
        						doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
        					}
    					}
    					break;
    		
    				case "btng_rowadd":
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						doActionIBSheet(sheetObject1,formObject,IBINSERT);
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						doActionIBSheet2(sheetObject2,formObject,IBINSERT);
    					}
    					break;
    		
    				case "btng_rowdel":
    					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    						doActionIBSheet(sheetObject1,formObject,IBDELETE);
    					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    						doActionIBSheet2(sheetObject2,formObject,IBDELETE);
    					}
    					break;
    					
    				case "btng_creation":
    					var param = "?cobTrade=" + comboObjects[0].Code
								+   "&cobLane=" + comboObjects[1].Code
								+   "&cobDir=" + comboObjects[2].Code;
    					ComOpenWindowCenter("ESM_BSA_0044.do"+param, "BSA Creation ALL", '600', '200', true, 'no')
    					break;
    		
    			} // end switch
    		} catch(e) {
    			if( e == "[object Error]") {
    				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e);
    			}
    		}
    	}
    	
    	
    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo,head1,head2) {
    		var formObj = document.form;
    		var head0    = "";
    		var arrHead1 = "";
    		var arrHead2 = "";
    		var varCnt = 0;
    		
    		var cnt = 0;
    		var HeadTitle0 = "";
    		var HeadTitle1 = "";
    		var HeadTitle2 = "";
    		var n = 0;
    		
    		var bsaOpJbCd1 = formObj.bsa_op_jb_cd.value.replace(/(^\s*)/g, '').split("|");
    		var bsaOpJbCd2 = formObj.bsa_op_jb_cd2.value.replace(/(^\s*)/g, '').split("|");
    		
    		switch(sheetNo) {
    			case 1:      //sheet1 init
    				if (head1 == "" && head2 == "") {
    					head1 = "|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA|Joint Operating Carrier's BSA"
    						+ "|Lease|Lease|Lease"
    						+ "|Charter in|Charter in|Charter in"
    						+ "|Additional Lease|Additional Lease|Additional Lease"
    						+ "|Additional Chater in|Additional Chater in|Additional Chater in";
    						head2 = "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3";
    				}
    		
    				arrHead1 = head1.replace(/(^\s*)/g, '').split("|");
    				arrHead2 = head2.replace(/(^\s*)/g, '').split("|");
    				
    				varCnt = arrHead2.length - 1;
    		
    				with (sheetObj) {
    					if (first_load1 == true) { style.height = GetSheetHeight(sheet_height1); }
    					first_load1 = false;
    		
    					SheetWidth = mainTable1.clientWidth;
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					MergeSheet = msHeaderOnly;
    		
    					Editable = true;
    					InitRowInfo(3, 1, 9, 100);
    					InitColumnInfo(fixCnt1 + varCnt, 16, 0, true);
    					InitHeadMode(true, true, false, true, false, false);
    		
    					for (j=1; j<=varCnt; j++) {
    						if(bsaOpJbCd1[j]== "001"){
    							head0 += "|Basic Slots";
    							n++;
    						}else{
    							head0 += "|Chartered Slots";
    						}
    					}
    		
    					HeadTitle0 = "STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|SML\nFinal|SML\nInclude Sub|☆|ownr_vsl_wgt"
    								+ head0 + "|DESC";
    					HeadTitle1 = "STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|SML\nFinal|SML\nInclude Sub|☆|ownr_vsl_wgt"
    								+ head1 + "|DESC";
    					HeadTitle2 = "STS|GRP|SEQ|VVD|From|To|Trade|S.TRD|R.Lane|Dir.|OPR|VSL Capa.|vsl_capa|Loadable\nCapacity|SML\nFinal|SML\nInclude Sub|☆|ownr_vsl_wgt"
    								+ head2 + "|DESC";
    		
    					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle0, true);
    					InitHeadRow(1, HeadTitle1, true);
    					InitHeadRow(2, HeadTitle2, false);
    					
    					SetMergeCell(0, 18, 2, n); 
    		
    		
    					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
    					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
    					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
    					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
    					cnt = 0;
    					InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
    					
    					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "bsa_group",            false, "", dfInteger, 0, false, false);
    					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "bsa_seq",              false, "", dfInteger, 0, false, true, 3);
    					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "vvd_cd",               false, "", dfNone,    0, true,  true, 9);
    					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_fm_dt",            false, "", dfDateYmd, 0, true,  true);
    					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_to_dt",            false, "", dfDateYmd, 0, true,  true);
    					
    					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "trd_cd",               false, "", dfNone,    0, false, false, 3);
    					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "sub_trd_cd",           false, "", dfNone,    0, false, false, 2);
    					InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "rlane_cd",             false, "", dfNone,    0, false, false, 5);
    					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "dir_cd",               false, "", dfNone,    0, false, false, 1);
    					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "vop_cd",               false, "", dfNone,    0, false, false, 3);
    					
    					InitDataProperty(0, cnt++, dtHidden,  70, daRight,  true, "",                       false, "", dfInteger,  3, false, false);
    					InitDataProperty(0, cnt++, dtHidden,  70, daRight,  true, "vsl_capa",             false, "", dfFloatOrg, 3, false, false);
    					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "bsa_capa",             false, "", dfInteger,  3, false, false);
    					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "fnl_hjs_bsa_capa",     false, LOGIC_fnl_capa, dfInteger, 0, false, false);
    					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "hjs_bsa_bfr_sub_capa", false, LOGIC_sub_capa, dfInteger, 0, false, false);
    					
    					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "ownr_vsl_wgt",         false, "", dfInteger,   0, false, false);
    					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "upd_usr_id",           false, "", dfNone,    0, false, false);
    		
    					for (n=0; n<varCnt; n++) {
    						InitDataProperty(0, cnt, dtAutoSum, 50, daRight, true, "crr_bsa_capa"+n, false, "", dfInteger, 0, true, true);
    						if (arrHead1[n+1] == "Basic Leased" || arrHead1[n+1] == "Additional Leased") {
    							CellBackColor(2, cnt) = RgbColor(196, 210, 255);
    						} else {
    							CellBackColor(2, cnt) =RgbColor(211, 219, 255);
    						}
    						cnt++;
    					}
    		
    					InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "jo_desc", false, "", dfNone, 0, true, true, 1000);
    					
    					InitDataValid(0, "dir_cd",  1, "NEWS");       //vtCharOnly=1
    					InitDataValid(0, "vvd_cd",  6, "1234567890"); //vtEngOther=6
    					//InitDataValid(0, "jo_desc", 8, "&/<>");       //vtExceptChar=8
    					
    					HeadRowHeight = 10;
    					CountPosition  = 0 ;
    				}
    				break;
    		
    			case 2:      //sheet2 init
    				if (head1 == "" && head2 == "") {
    					head1 = "|from which carrier|from which carrier|from which carrier"
    						+ "|Sub Lease|Sub Lease|Sub Lease"
    						+ "|Sub Chater in|Sub Chater in|Sub Chater in"
    						+ "|Additional Lease|Additional Lease|Additional Lease"
    						+ "|Additional Chater in|Additional Chater in|Additional Chater in";
    					head2 = "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3"
    						+ "|CRR1|CRR2|CRR3";
    				}
    		
    				arrHead1 = head1.replace(/(^\s*)/g, '').split("|");
    				arrHead2 = head2.replace(/(^\s*)/g, '').split("|");
    				
    				varCnt = arrHead2.length - 1;
    		
    				with (sheetObj) {
    					if (first_load2 == true) { style.height = GetSheetHeight(sheet_height2); }
    					first_load2 = false;
    		
    					SheetWidth = mainTable2.clientWidth;
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					MergeSheet = msHeaderOnly;
    					Editable = true;
    					InitRowInfo(2, 1, 9, 100);
    					InitColumnInfo(fixCnt2 + varCnt, 14, 0, true);
    					InitHeadMode(true, true, false, true, false, false);
    		
    					HeadTitle0 = "STS|GRP|SEQ|VVD|From|To.|Trade|R.Lane|Dir.|VSL Chk|Seq|VSL\nCode|Final\nSML BSA|SML BSA\nBefore Sub|☆|★"
    							+ head1 + "|DESC";
    					HeadTitle1 = "STS|GRP|SEQ|VVD|From|To.|Trade|R.Lane|Dir.|VSL Chk|Seq|VSL\nCode|Final\nSML BSA|SML BSA\nBefore Sub|☆|★"
    							+ head2 + "|DESC";
    		
    					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle0, true);
    					InitHeadRow(1, HeadTitle1, false);
    		
    					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
    					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
    					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
    					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
    					cnt = 0;
    					InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
    		
    					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "bsa_group",            false, "", dfInteger, 0, false, false);
    					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "bsa_seq",              false, "", dfInteger, 0, false, true, 3);
    					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "vvd_cd",               false, "", dfNone,    0, true,  true, 11);
    					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_fm_dt",            false, "", dfDateYmd, 0, true,  true);
    					InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "bsa_to_dt",            false, "", dfDateYmd, 0, true,  true);
    					
    					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "trd_cd",               false, "", dfNone,    0, false, false, 3);
    					InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "rlane_cd",             false, "", dfNone,    0, false, false, 5);
    					InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "dir_cd",               false, "", dfNone,    0, false, false, 1);
    					InitDataProperty(0, cnt++, dtCheckBox,55, daCenter, true, "vsl_bsa_chk_flg",      false, "", dfNone,    0, true,  true);
    					InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "vsl_seq",              false, "", dfInteger, 0, false, true, 3);
    					
    					InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "vsl_cd",               false, "", dfNone,    0, false, false, 4);
    					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "hjs_fnl_bsa_capa",     false, LOGIC_fnl_capa, dfInteger, 0, false, false);
    					InitDataProperty(0, cnt++, dtAutoSum, 70, daRight,  true, "hjs_bsa_bfr_sub_capa", false, LOGIC_sub_capa, dfInteger, 0, false, false);
    					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "vsl_mlt_inp_flg",      false, "", dfNone,    0, false, false);
    					InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true, "upd_usr_id",           false, "", dfNone,    0, false, false);
    		
    					for (n=0; n<varCnt; n++) {
    						InitDataProperty(0, cnt, dtAutoSum, 50, daRight, true, "crr_bsa_capa"+n, false, "", dfInteger, 0, true, true);
    						if (arrHead1[n+1] == "Sub Lease" || arrHead1[n+1] == "Additional Lease") {
    							CellBackColor(1, cnt) = RgbColor(196, 210, 255);
    						} else {
    							CellBackColor(1, cnt) = RgbColor(211, 219, 255);
    						}
    						cnt++;
    					}
    		
    					InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "scht_desc", false, "", dfNone, 0, true, true, 100);
    					
    					InitDataValid(0, "dir_cd",    1, "NEWS");       //vtCharOnly=1
    					InitDataValid(0, "vvd_cd",    6, "1234567890"); //vtEngOther=6
    					InitDataValid(0, "vsl_cd",    9);               //vtEngUpOnly=9
    					//InitDataValid(0, "scht_desc", 8, "&/<>");       //vtExceptChar=8
    					
    					
    					HeadRowHeight = 10;
    					CountPosition = 0;
    				}
    				break;
    		}
    	}
    	
    	
    	
    	/**
    	* 콤보 항목을 설정한다. by.yjjeon
    	*/
    	function initCombo (comboObj, comboNo) {
    		with (comboObj) {
    			DropHeight = 300;
    			comboObj.InsertItem(0, 'All' ,''); 
    			Index = 0;

    			switch (comboObj.id){
    				case "cobTrade":
    	            	MaxLength = 3;
    	            	UseAutoComplete = true;
    	            	ValidChar(2, 1);	//영문대문자+숫자					
    					break;
    				case "cobLane":
    	            	MaxLength = 5;
    	            	UseAutoComplete = true;
    	            	ValidChar(2, 1);	//영문대문자+숫자
    					break;
    				case "cobDir":
    	            	MaxLength = 1;
    	            	UseAutoComplete = true;
    	            	ValidChar(2, 0);	//영문만 입력
    					break;					
    			}
    		}
    	}
    	
    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		
    		switch(sAction) {		
    			case IBSEARCH:      //조회
    				sheetObj.WaitImageVisible = true;
    				if (!validateCond(formObj, sAction)) {
    					return false;
    				}
    				formObj.f_cmd.value = SEARCHLIST01;
    				var sXml = sheetObj.GetSearchXml("ESM_BSA_0040GS.do", bsaFormString(formObj,getParam(curPgmNo)));
    				//var gXml = xml.split("|$$|");
    				var head1 = GetEtcDataForExceptional(sXml, "head1");
    				var head2 = GetEtcDataForExceptional(sXml, "head2");
    				var head3 = GetEtcDataForExceptional(sXml, "head3");
    				LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
    				LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
    				if (head1 != "" && head2 != "") {
    					formObj.bsa_op_jb_nm1.value=head1;
    					formObj.jHeader.value=head2;
    					formObj.bsa_op_jb_cd.value=head3;
    					sheetObj.Redraw = false;
    					sheetObj.Visible = false;
    					sheetObj.RemoveAll();
    					sheetObj.Reset();
    					ComConfigSheet(sheetObjects[0]);
    					initSheet(sheetObj, 1, head1, head2);
    					sheetObj.Visible = true;
    					sheetObj.Redraw = true;
    					sheetObj.LoadSearchXml(sXml);
    					sheetObj.RemoveEtcData(); // ETC 데이타 삭제
    				}
    				sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
    		
    				setOffsetPos(head1);
    				break;
    		
    			case IBSAVE:        //저장
    				if (!validateForm(sheetObj)) {
    					return false;
    				}
    				formObj.f_cmd.value = MULTI01;
    				sheetObj.DoSave("ESM_BSA_0040GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    				//sheetObj.EtcData("comment");
    				break;
    		
    			case IBDOWNEXCEL:   //엑셀 다운로드
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
    			case IBINSERT:      //행추가
    				with(sheetObj) {
    					if (RowCount > 0) {
    						SelectRow = getMaxRow(sheetObj);
    					
    						var Row = DataCopy(false); //행을 복사
    						if (Row > HeaderRows) {
    							InitHeadMode(false, true, false, true, false, false); //Sort불가능
    							CellValue2(Row,"bsa_seq") = parseInt(CellValue(Row,"bsa_seq")) + 1;
    					
    							//이전Row가 있으면 이전Row의 bsa_to_dt를 수정 못하게 함
    							var grpRow = getFindRow(sheetObj,Row,-1);
    							if (grpRow != -1) {
    								CellEditable(grpRow,"bsa_to_dt") = false;
    							}
    						}
    					} //end of if
    				}
    				break;
    			case IBDELETE:      //행삭제
    				with(sheetObj) {
    					if (SelectRow > 0 && RowCount > 0) {
    						var currRow = SelectRow;
    						var stat = RowStatus(currRow);
    						
    						if (getMaxRow(sheetObj) != currRow) { //지우려는 대상Row가 최대값인 경우에만 삭제가 가능
    							ComShowMessage(ComGetMsg('BSA10029')); //같은 그룹내의 최대값만 삭제할 수 있습니다.
    						} else {
    							var grpRow = getFindRow(sheetObj,currRow,-1);
    							RowStatus(currRow) = "D";
    							if (stat != "I") { //추가 중인 ROW가 아닌 경우
    								if (ComShowConfirm(ComGetMsg('BSA10028')) == true) { //정보를 삭제 하시겠습니까?
    									if (grpRow != -1) {
    										//이전Row의 bsa_to_dt를 수정가능하게 함
    										CellEditable(grpRow,"bsa_to_dt") = true;
    										//현Row의 bsa_to_dt를 이전Row의 bsa_to_dt로 복사함
    										CellValue2(grpRow,"bsa_to_dt") = CellValue(currRow,"bsa_to_dt");
    									} 
    									formObj.f_cmd.value = REMOVE01;
    									DoSave("ESM_BSA_0040GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    									//RowDelete(currRow,false);
    								} else {
    									RowStatus(currRow) = stat; //원래값으로 복구
    								}
    							} else { //추가 중인 경우
    								if (grpRow != -1) {
    									//이전Row의 bsa_to_dt를 수정가능하게 함
    									CellEditable(grpRow,"bsa_to_dt") = true;
    								}
    							}
    						}
    					}
    				}
    				break;
    		
    			case IBCREATE:      //생성
    				if (!validateCond(formObj, sAction)) {
    					return false;
    				}
    			
	    			var param = "";
	    			param = "f_cmd="+SEARCHLIST01;
	    			param = param+"&trd_cd="+trd_cd;
	    			param = param+"&code=rLane";
	    			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
	    			
	    			var arrXml = sXml.split("|$$|");
	    			if (arrXml.length > 0)
	    				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
    			
    	
    				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { //정보를 생성 하시겠습니까?
    					formObj.f_cmd.value = MULTI03;
    					sheetObj.DoSearch4Post("ESM_BSA_0040GS.do", bsaFormString(formObj,getParam(curPgmNo)));
    					var err_cd = sheetObj.EtcData("err_cd");
    					var err_msg = sheetObj.EtcData("err_msg");
    				
    					//재조회 ------------------------------------------------------- START
    					formObj.f_cmd.value = SEARCHLIST01;
    					var sXml = sheetObj.GetSearchXml("ESM_BSA_0040GS.do", bsaFormString(formObj,getParam(curPgmNo)));
    					var head1 = GetEtcDataForExceptional(sXml, "head1");
    					var head2 = GetEtcDataForExceptional(sXml, "head2");
    					var head3 = GetEtcDataForExceptional(sXml, "head3");
    					LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
    					LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
    					if (head1 != "" && head2 != "") {
    						formObj.bsa_op_jb_nm1.value=head1;
    						formObj.jHeader.value=head2;
    						formObj.bsa_op_jb_cd.value=head3;
    						sheetObj.Redraw = false;
    						sheetObj.Visible = false;
    						sheetObj.RemoveAll();
    						sheetObj.Reset();
    						ComConfigSheet(sheetObjects[0]);
    						initSheet(sheetObj, 1, head1, head2);
    						sheetObj.Visible = true;
    						sheetObj.Redraw = true;
    						sheetObj.LoadSearchXml(sXml);
    						sheetObj.RemoveEtcData(); // ETC 데이타 삭제
    					}
    					sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
    				
    					setOffsetPos(head1);
    					//재조회 ------------------------------------------------------- END
    				
    					if (err_cd == "00000") {
    						ComShowMessage(ComGetMsg('BSA10018','CREATION')); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
    					}
    				}
    				break;
    		}
    	}
    	
    	// Sheet관련 프로세스 처리
    	function doActionIBSheet2(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
    		var grpRow = 0;
    	
    		switch(sAction) {
    			case IBSEARCH:      //조회
    				if (!validateCond(formObj, sAction)) {
    					return false;
    				}
    				formObj.f_cmd.value = SEARCHLIST02;
    				var sXml = sheetObj.GetSearchXml("ESM_BSA_0040GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
    				var head1 = GetEtcDataForExceptional(sXml, "head1");
    				var head2 = GetEtcDataForExceptional(sXml, "head2");
    				var head3 = GetEtcDataForExceptional(sXml, "head3");
    				LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
    				LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
    				if (head1 != "" && head2 != "") {
    					formObj.bsa_op_jb_nm2.value=head1;
    					formObj.sHeader.value=head2;
    					formObj.bsa_op_jb_cd2.value=head3;
    					sheetObj.Redraw = false;
    					sheetObj.Visible = false;
    					sheetObj.RemoveAll();
    					sheetObj.Reset();
    					ComConfigSheet(sheetObjects[1]);
    					initSheet(sheetObj, 2, head1, head2);
    					sheetObj.Visible = true;
    					sheetObj.Redraw = true;
    					sheetObj.LoadSearchXml(sXml);
    					sheetObj.RemoveEtcData(); // ETC 데이타 삭제
    				}
    				sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
    				
    				setOffsetPos(head1);
    				break;
    	
    			case IBSAVE:        //저장
    				if (!validateForm(sheetObj)) {
    					return false;
    				}
    				formObj.f_cmd.value = MULTI02;        
    				sheetObj.DoSave("ESM_BSA_0040GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    				break;
    	
    			case IBDOWNEXCEL:   //엑셀 다운로드
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
    	
    			case IBINSERT:      // 행추가
    				with(sheetObj) {
    					if (RowCount > 0) {
    						SelectRow = getMaxRow(sheetObj);
    						
    						var Row = DataCopy(false); //행을 복사
    						if (Row > HeaderRows) {
    							InitHeadMode(false, true, false, true, false, false); //Sort불가능
    							CellValue2(Row,"bsa_seq") = parseInt(CellValue(Row,"bsa_seq")) + 1;
    							CellValue2(Row,"vsl_seq") = 1; //최초 시작이므로 항상 '1'로 샛팅
    							//이전Row가 있으면 이전Row의 bsa_to_dt를 수정 못하게 함
    							var grpRow = getFindRow(sheetObj,Row,-1);
    							if (grpRow != -1) {
    								CellEditable(grpRow,"bsa_to_dt") = false;
    							}
    							
    							//체크박스별 vsl_cd의 CellEditable 셋팅
    							if (CellValue(Row,"vsl_bsa_chk_flg") == "1") {
    								CellEditable(Row,"vsl_cd") = true;
    							} else if (CellValue(Row,"vsl_bsa_chk_flg") == "0") {
    								CellEditable(Row,"vsl_cd") = false;
    							}
    						}
    					} //end of if
    				}
    				break;
    	
    			case IBDELETE:      //행삭제
    				with(sheetObj) {
    					if (SelectRow > 0 && RowCount > 0) {
    						var currRow = SelectRow;
    						var stat = RowStatus(SelectRow);
    						
    						if (getMaxRow(sheetObj) != currRow) { //지우려는 대상Row가 최대값인 경우에만 삭제가 가능
    							ComShowMessage(ComGetMsg('BSA10029')); //같은 그룹내의 최대값만 삭제할 수 있습니다.
    						} else {
    							var grpRow = getFindRow(sheetObj,currRow,-1);
    							RowStatus(currRow) = "D";
    							if (stat != "I") { //추가 중인 ROW가 아닌 경우
    								if (ComShowConfirm(ComGetMsg('BSA10028')) == true) { //정보를 삭제 하시겠습니까?
    									if (grpRow != -1) {
    										//이전Row의 bsa_to_dt를 수정가능하게 함
    										CellEditable(grpRow,"bsa_to_dt") = true;
    										//현Row의 bsa_to_dt를 이전Row의 bsa_to_dt로 복사함
    										CellValue2(grpRow,"bsa_to_dt") = CellValue(currRow,"bsa_to_dt");
    									}
    									
    									formObj.f_cmd.value = REMOVE02;
    									DoSave("ESM_BSA_0040GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
    									
    									//RowDelete(currRow,false);
    								} else {
    									RowStatus(currRow) = stat; //원래값으로 복구
    								}
    							} else { //추가 중인 경우
    								if (grpRow != -1) {
    									//이전Row의 bsa_to_dt를 수정가능하게 함
    									CellEditable(grpRow,"bsa_to_dt") = true;
    								}
    							}
    						}
    					}
    				}
    				break;
    	
    			case IBCREATE:      //생성
    				if (!validateCond(formObj, sAction)) {
    					return false;
    				}
    			
    				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { //정보를 생성 하시겠습니까?
    					formObj.f_cmd.value = MULTI04;
    					sheetObj.DoSearch4Post("ESM_BSA_0040GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
    					var err_cd = sheetObj.EtcData("err_cd");
    					var err_msg = sheetObj.EtcData("err_msg");
    					
    					//재조회 ------------------------------------------------------- START
    					formObj.f_cmd.value = SEARCHLIST02;
    					var sXml = sheetObj.GetSearchXml("ESM_BSA_0040GS2.do", bsaFormString(formObj,getParam(curPgmNo)));
    					var head1 = GetEtcDataForExceptional(sXml, "head1");
    					var head2 = GetEtcDataForExceptional(sXml, "head2");
    					var head3 = GetEtcDataForExceptional(sXml, "head3");
    					LOGIC_fnl_capa = GetEtcDataForExceptional(sXml, "logic1");
    					LOGIC_sub_capa = GetEtcDataForExceptional(sXml, "logic2");
    					if (head1 != "" && head2 != "") {
    						formObj.bsa_op_jb_nm2.value=head1;
    						formObj.sHeader.value=head2;
    						formObj.bsa_op_jb_cd2.value=head3;
    						sheetObj.Redraw = false;
    						sheetObj.Visible = false;
    						sheetObj.RemoveAll();
    						sheetObj.Reset();
    						ComConfigSheet(sheetObjects[1]);
    						initSheet(sheetObj, 2, head1, head2);
    						sheetObj.Visible = true;
    						sheetObj.Redraw = true;
    						sheetObj.LoadSearchXml(sXml);
    						sheetObj.RemoveEtcData(); // ETC 데이타 삭제
    					}
    					sheetObj.InitHeadMode(true, true, false, true, false, false); //Sort가능
    					
    					setOffsetPos(head1);
    					//재조회 ------------------------------------------------------- END
    					
    					if (err_cd == "00000") {
    					ComShowMessage(ComGetMsg('BSA10018','CREATION')); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
    					}
    				}
    				break;
    		}
    	}
    	
    	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    		with(sheetObj){
    			SumText(0,0) = "" ;
    			SumText(0,"vvd_cd") = "TOTAL" ;
    		}
    			
    		//isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
    		if(document.form.isExcludZero.checked) {
    			for(var k=0; k<=sheetObj.LastCol; k++) {
    				if(sheetObj.CellBackColor(1, k) != sheetObj.CellBackColor(2, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
    				sheetObj.ColHidden(k) = true;	 
    			}
    		} else {
    			for(var k=0; k<=sheetObj.LastCol; k++){
    				if(sheetObj.CellBackColor(1, k) != sheetObj.CellBackColor(2, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
    				sheetObj.ColHidden(k) = false;
    			}
    		}
    	}
    	
    	function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
    		with(sheetObj){
    			SumText(0,0) = "" ;
    			SumText(0,"vvd_cd") = "TOTAL" ;
    		}
    		
    		//isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
    		if(document.form.isExcludZero.checked) {
    			for(var k=0; k<=sheetObj.LastCol; k++) {
    				if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
    				sheetObj.ColHidden(k) = true;	 
    			}
    		} else {
    			for(var k=0; k<=sheetObj.LastCol; k++){
    				if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
    					sheetObj.ColHidden(k) = false;	            
    				}	      
    		}		
    	}
    	
    	function sheet1_OnChange(sheetObj,Row,Col,Value) {
    		var formObj = document.form;
    		var grpRow = -1;
    		var param="";
    		
    		with(sheetObj) {
    		
    			if (ColSaveName(Col) == "bsa_fm_dt") {
    				grpRow = getFindRow(sheetObj,Row,-1);
    				if (grpRow != -1) {
    					//Day-1 추출 로직 적용
    					CellValue2(grpRow,"bsa_to_dt") = getOffsetDate(Value,-1);
    				}
    			}
    			if (ColSaveName(Col) == "vvd_cd") {
    				selRow = Row;
    				selValue = Value;
    				
    				param = param+"f_cmd="+SEARCHLIST02;
    				param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
    				param = param+"&code=etdDt";
    				var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    				var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
    				getEdtDate(etdDt);
    			}
    		}
    	}
    	
    	function sheet2_OnChange(sheetObj,Row,Col,Value) {
    		var formObj = document.form;
    		var grpRow = -1;
    		var param="";
    		
    		with(sheetObj){
    			if (ColSaveName(Col) == "bsa_fm_dt") {
    				grpRow = getFindRow(sheetObj,Row,-1);
    				if (grpRow != -1) {
    				//Day-1 추출 로직 적용
    				CellValue2(grpRow,"bsa_to_dt") = getOffsetDate(Value,-1);
    				}
    			}
    			if (ColSaveName(Col) == "vsl_bsa_chk_flg") {
    				if (CellValue(Row,"vsl_bsa_chk_flg") == "1") {
    					CellEditable(Row,"vsl_cd") = true;
    				} else if (CellValue(Row,"vsl_bsa_chk_flg") == "0") {
    					CellEditable(Row,"vsl_cd") = false;
    				}
    			}
    			if (ColSaveName(Col) == "vvd_cd") {
    				selRow = Row;
    				selValue = Value;
    		
    				param = param+"f_cmd="+SEARCHLIST02;
    				param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
    				param = param+"&code=etdDt";
    				var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    				var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
    				getEdtDate(etdDt);
    			}
    		}
    	}
    	
    	
    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj) {
    		with(sheetObj){
    			// From 날짜가 To 날짜보다 큰 경우
    			var cnt = sheetObj.RowCount + 3;
    			
    			for(i = 3; i < cnt; i++){
    				if(sheetObj.CellValue(i, "bsa_fm_dt") > sheetObj.CellValue(i, "bsa_to_dt")) {
    					ComShowCodeMessage('BSA10045');
    					return false;
    				}	
    			}
    			
    			// 동일한 Trade/Lane/Direction/Operator/Vessel Capa의 From/To 날짜가 중복되는 경우
    			var dup = "";
    			
    			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    				dup = sheetObj.ColValueDupRows("trd_cd|rlane_cd|dir_cd|vop_cd|vsl_capa", true, true);
    			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    				dup = sheetObj.ColValueDupRows("trd_cd|rlane_cd|dir_cd|hjs_fnl_bsa_capa", true, true);
    			}
    			
    			if(dup != "") {
    				var arrRow1 = dup.split("|");
    				var arrRow2 = arrRow1[0].split(",");	// 최초의 기준행 배열
    				var arrRow3 = arrRow1[1].split(",");	// 중복행 배열
    				
    				// 기준행을 기준으로 중복행 에서 중복 체크
    				for(i=0; i < arrRow2.length; i++) {
    					for(j=0; j < arrRow3.length; j++) {
    						
    						// 기준 행보다 작은 중복행 제외
    						if(arrRow2[i] < arrRow3[j]) {
    							
    							// 중복행 배열에서 기준행과 같은 행 찾기
    							if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    								if(    sheetObj.CellValue(arrRow2[i], "trd_cd")   == sheetObj.CellValue(arrRow3[j], "trd_cd")
    									&& sheetObj.CellValue(arrRow2[i], "rlane_cd") == sheetObj.CellValue(arrRow3[j], "rlane_cd")
    									&& sheetObj.CellValue(arrRow2[i], "dir_cd")   == sheetObj.CellValue(arrRow3[j], "dir_cd")
    									&& sheetObj.CellValue(arrRow2[i], "vop_cd")   == sheetObj.CellValue(arrRow3[j], "vop_cd")
    									&& sheetObj.CellValue(arrRow2[i], "vsl_capa") == sheetObj.CellValue(arrRow3[j], "vsl_capa") ) {
    									
    									if(sheetObj.CellValue(arrRow3[j], "bsa_fm_dt") <= sheetObj.CellValue(arrRow2[i], "bsa_to_dt")) {
    										ComShowCodeMessage('BSA10045');
    										return false;
    									}
    								}	
    							} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    								if(    sheetObj.CellValue(arrRow2[i], "trd_cd")           == sheetObj.CellValue(arrRow3[j], "trd_cd")
    									&& sheetObj.CellValue(arrRow2[i], "rlane_cd")         == sheetObj.CellValue(arrRow3[j], "rlane_cd")
    									&& sheetObj.CellValue(arrRow2[i], "dir_cd")           == sheetObj.CellValue(arrRow3[j], "dir_cd")
    									&& sheetObj.CellValue(arrRow2[i], "hjs_fnl_bsa_capa") == sheetObj.CellValue(arrRow3[j], "hjs_fnl_bsa_capa") ) {
    									
    									if(sheetObj.CellValue(arrRow3[j], "bsa_fm_dt") <= sheetObj.CellValue(arrRow2[i], "bsa_to_dt")) {
    										ComShowCodeMessage('BSA10045');
    										return false;
    									}
    								}
    							}	
    						}
    					}
    				}
    				
    				// 중복행 배열 내에서 중복 체크
    				for(i=0; i < arrRow3.length; i++) {
    					for(j=i+1; j < arrRow3.length; j++) {
    						// 중복행 배열에서 기준행과 같은 행 찾기
    						if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    							if(    sheetObj.CellValue(arrRow3[i], "trd_cd")   == sheetObj.CellValue(arrRow3[j], "trd_cd")
    								&& sheetObj.CellValue(arrRow3[i], "rlane_cd") == sheetObj.CellValue(arrRow3[j], "rlane_cd")
    								&& sheetObj.CellValue(arrRow3[i], "dir_cd")   == sheetObj.CellValue(arrRow3[j], "dir_cd")
    								&& sheetObj.CellValue(arrRow3[i], "vop_cd")   == sheetObj.CellValue(arrRow3[j], "vop_cd")
    								&& sheetObj.CellValue(arrRow3[i], "vsl_capa") == sheetObj.CellValue(arrRow3[j], "vsl_capa") ) {
    								
    								if(sheetObj.CellValue(arrRow3[j], "bsa_fm_dt") <= sheetObj.CellValue(arrRow3[i], "bsa_to_dt")) {
    									ComShowCodeMessage('BSA10045');
    									return false;
    								}
    							}
    						} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    							if(    sheetObj.CellValue(arrRow3[i], "trd_cd")           == sheetObj.CellValue(arrRow3[j], "trd_cd")
    								&& sheetObj.CellValue(arrRow3[i], "rlane_cd")         == sheetObj.CellValue(arrRow3[j], "rlane_cd")
    								&& sheetObj.CellValue(arrRow3[i], "dir_cd")           == sheetObj.CellValue(arrRow3[j], "dir_cd")
    								&& sheetObj.CellValue(arrRow3[i], "hjs_fnl_bsa_capa") == sheetObj.CellValue(arrRow3[j], "hjs_fnl_bsa_capa") ) {
    								
    								if(sheetObj.CellValue(arrRow3[j], "bsa_fm_dt") <= sheetObj.CellValue(arrRow3[i], "bsa_to_dt")) {
    									ComShowCodeMessage('BSA10045');
    									return false;
    								}
    							}
    						}	
    					}
    				}
    			}
    		}
    	
    		return true;
    	}
    	
    	/**
    	* 화면 조회값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateCond(formObj, sAction) {
    		with(formObj){	
    			if (ComTrim(txtSDate.value) == "") {
    				//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
    				//formObj.txtSDate.focus();
    				ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
    	
    				return false;
    			}
    	
    			if (sAction == IBCREATE) { } //생성시에만 체크	
    			// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
    			if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
    				if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
    					//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
    					//txtEDate.focus();
    					ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
    					return false;
    				}
    			}
    		}
    	
    		return true;
    	}
    	
    	//화면의 Enter-Key 처리
    	function keyEnter_loc(){
    		var sheetObject1 = sheetObjects[0];
    		var sheetObject2 = sheetObjects[1];
    		var formObject = document.form;
    		if (event.keyCode == 13) {
    			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    				doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
    			}
    		}
    	}
    	
    	//rdoType별 위치이동
    	function setOffsetPos(head) {
    		var shead = head.split("|");
    		var idx = 0;
    		var cnt = 0;
    		var old = shead[0];
    		for(var i=1; i<shead.length; i++) {
    			if (old != shead[i]) {
    				if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    					splitPos1[idx] = cnt;
    				} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    					splitPos2[idx] = cnt;
    				}
    				idx = idx + 1;
    			}
    			cnt = cnt + 1;
    			old = shead[i];
    		}
    		if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			splitPos1[idx] = cnt;
    		} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			splitPos2[idx] = cnt;
    		}
    	}
    	
    	//sheet의 현재선택된 Row의 상/하위(offset 만큼) Row를 리턴
    	function getFindRow(sheetObj, Row, offset) {
    		var rtnRow = -1;
    		var bsa_group = "";
    		var bsa_seq   = -1;
    		var col1 = 0;
    		var col2 = 0;
    		var tmp = 0;
    		
    		with(sheetObj) {
    			bsa_group = CellValue(Row,"bsa_group");
    			bsa_seq   = parseInt(CellValue(Row,"bsa_seq")) + offset;
    			
    			for (var i=HeaderRows; i<LastRow; i++) {
    				col1 = FindText("bsa_group", bsa_group, tmp);
    				if (col1 == -1) { break; } //Not Found
    				
    				col2 = FindText("bsa_seq", bsa_seq, col1);
    				if (col1 == col2) { //Found
    					rtnRow = col2;
    					break;
    				}
    				tmp = col1 + 1;
    			}
    		}
    	
    		return rtnRow;
    	}
    	
    	//VVD --> edt-date
    	function getEdtDate(result) {
    		var sheetObject1 = sheetObjects[0];
    		var sheetObject2 = sheetObjects[1];
    		var tmpRow = 0;
    		
    		if(result == null || result == "" || result == "null"){
    			ComShowMessage(ComGetMsg('BSA10027',selValue));  //msg1 + '는(은) 유효한 VVD가 아니거나 EDT Date가 존재하지 않습니다.'
    			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    				sheetObject1.SelectCell(selRow,"vvd_cd",true);
    			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    				sheetObject2.SelectCell(selRow,"vvd_cd",true);
    			}
    		} else {
    			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    				sheetObject1.CellValue(selRow,"bsa_fm_dt") = result;
    			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    				sheetObject2.CellValue(selRow,"bsa_fm_dt") = result;
    			}
    		}
    	}
    	
    	//Grouping별 Max값을 추출
    	function getMaxRow(sheetObj) {
    		var bsa_group = "";
    		var bsa_seq = 0;
    		var tmpSeq = 0;
    		var tmpRow = 0;
    		var maxRow = 0;
    		var tmp = 0;
    		
    		with(sheetObj) {
    			if (SelectRow > 0) {
    				maxRow = SelectRow;
    				bsa_group = CellValue(SelectRow,"bsa_group");
    				for (var i=HeaderRows; i<LastRow; i++) {
    					tmpRow = FindText("bsa_group", bsa_group, tmp);
    					if (tmpRow == -1) {
    						break;
    					} else {
    						tmpSeq = parseInt(CellValue(tmpRow,"bsa_seq"));
    						if (bsa_seq <= tmpSeq) {
    							bsa_seq = tmpSeq;  //최대값
    							maxRow = tmpRow;  //최대값이 위치한 Row
    						}
    					}
    					tmp = tmpRow + 1;
    				} //end of for
    			}
    		} //end of with
    		
    		return maxRow;
    	}
    	
    	//화면의 Zoom 처리
    	function set_Zoom() {
    		if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
    			if (zoomFlag1 == "open") {
    				div_zoom_in1.style.display  = "none";  
    				div_zoom_out1.style.display = "inline";
    			} else if (zoomFlag1 == "close") {
    				div_zoom_in1.style.display  = "inline"; 
    				div_zoom_out1.style.display = "none";
    			}
    			div_zoom_in2.style.display  = "none";
    			div_zoom_out2.style.display = "none";
    		
    		} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
    			div_zoom_in1.style.display  = "none";
    			div_zoom_out1.style.display = "none";
    			if (zoomFlag2 == "open") {
    				div_zoom_in2.style.display  = "none";  
    				div_zoom_out2.style.display = "inline";
    			} else if (zoomFlag2 == "close") {
    				div_zoom_in2.style.display  = "inline"; 
    				div_zoom_out2.style.display = "none";
    			}		
    		}
    	}
    	
    	
   	
    	//추가------------------------------------------------------------------------------------------------------
    	
    	/**
    	* IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 ETC-DATA로 넣은 KEY의 값을 리턴한다.
    	* <br><b>Example :</b>
    	* <pre>
    	*     xmlStr = mySheet.GetSearchXml("list.jsp");
    	*     sValue = ComGetEtcData(xmlStr, "UserId");
    	*     예를 들어 xmlStr의 내용이 아래와 같다면 sValue의 값은 "ibs006"이 된다.
    	*     xmlStr ======================================================
    	*       &lt;?xml version='1.0' ?&gt;
    	*       &lt;SHEET&gt;
    	*         &lt;ETC-DATA&gt;
    	*              &lt;ETC KEY="UserId"&gt;ibs006&lt;/ETC&gt;
    	*              &lt;ETC KEY="UserName"&gt;khlee&lt;/ETC&gt;
    	*         &lt;/ETC-DATA&gt;
    	*       &lt;/SHEET&gt;
    	*     xmlStr ======================================================
    	* </pre>
    	* @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
    	* @param   {string} etcName    필수,xml 문자열에서 추출하고자하는 ETC Key이름
    	* @return  string, ETC-DATA로 넣은 KEY의 값
    	* @version 3.4.0.50
    	*/
    	function GetEtcDataForExceptional0040(xmlStr,etcName){
    		if(xmlStr == null  || xmlStr == "" || etcName == null || etcName == "") return;
    		
    		try {
    			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
    			xmlDoc.loadXML(xmlStr);
    			
    			var xmlRoot = xmlDoc.documentElement;
    			if(xmlRoot == null) return;
    			
    			var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
    			if(etcDataNode == null) return;
    			
    			var etcNodes = etcDataNode.childNodes;
    			if(etcDataNode == null) return;
    			
    			for(var i=0;i<etcNodes.length;i++){
    				if(etcNodes[i].nodeType!=1 || etcNodes[i].attributes.length == 0) continue;
    				
    				if(etcNodes[i].attributes(0).text==etcName) {
    					if (etcNodes[i].firstChild==null) {
    						return "";
    					} else {
    						return etcNodes[i].firstChild.nodeValue;
    					}
    				}
    			}
    		} catch(err) { ComFuncErrMsg(err.message); }
    	}
    	
    	function ComAddSeparator_Local(obj, sFormat) {
    		try {
    			//obj.value = obj.value.substring(0, obj.value.indexOf("-")) + obj.value.substring(obj.value.indexOf("-")+1, obj.value.length);
    		} catch(err) { ComFuncErrMsg(err.message); }
    	}
    	/**
    	* trade코드 변경시 rLane 리스트를 리플래쉬 한다.
    	*/
    	function cobTrade_OnChange(obj) {
    		if (loadingMode == true) return; 
    		var formObj = document.form;
    		var sheetObj = sheetObjects[0];
    		var param = "";
    		var trd_cd = "";
    		sheetObj.WaitImageVisible = false;
    		
    		if(obj.Text != ""){
    			trd_cd = obj.Code;
    			param = "f_cmd="+SEARCHLIST01;
    			param = param+"&trd_cd="+trd_cd;
    			param = param+"&code=rLane";
    			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    			
    			var arrXml = sXml.split("|$$|");
    			if (arrXml.length > 0)
    				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
    			formObj.cobLane.Index = 0;
    		}
    		sheetObj.WaitImageVisible = true;
    	}
	/* 개발자 작업  끝 */