/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0172.jsp
* @FileTitle : Inquire/Edit Slot-Cost
* Open Issues :
* Change history :
* @LastModifyDate : 2009-06-11
* @LastModifier : Kim Jong Yeol
* @LastVersion : 1.0
*  2007-01-18 Kim Jong Yeol
*  1.0 최초 생성
=========================================================
* History : 2009.10.16 남궁진호 ALPS 전환 1.0 Creation
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
     * @class ESM_BSA_0172 : ESM_BSA_0172 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0172() {
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
    var headTmp = "";
    var sheet_height = 20; // sheet의 height    

	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	var comboXml = "";


    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	var sheetObject = sheetObjects[0];
    	var sheetObject1 = sheetObjects[1];
    	var sheetObject2 = sheetObjects[2];

    	

    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

    			case "btn_retrieve":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBSEARCH);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBSEARCH);	
    				}  
    				
    				break;
    			case "btn_save":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBSAVE);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBSAVE);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBSAVE);	
    				}  
    				break;

    			case "btn_downexcel":
    					if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBDOWNEXCEL);	
    				}  
    				break;	
    				
    			case "btns_calendar1":
    				 var cal = new ComCalendar();
    				cal.select(formObject.txtSDate,  'yyyy-MM-dd');
    				break;

    			case "btns_calendar2":
    				 var cal = new ComCalendar();
    				cal.select(formObject.txtEDate,  'yyyy-MM-dd');
    				break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject,"MAX",1);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				parent.syncHeight();
    				break;

    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject,"MIN",0);
    				sheetObject.style.height = sheetObject.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				parent.syncHeight();
    				break;

    			case "btng_rowcopy":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBCOPYROW);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBCOPYROW);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBCOPYROW);	
    				}  
    				break;
    			
    			case "btng_rowadd":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBINSERT);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBINSERT);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBINSERT);	
    				}  
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(head) {
    	headTmp = head;
    	for (i=0; i<sheetObjects.length; i++) {
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i], i+1, head);
    		ComEndConfigSheet(sheetObjects[i]);
    	}

    	// 멀티콤보 처리
    	loadingMode = true;
    	loadCombo();
    	
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
    	
		for(l=0;l<sheetObjects.length;l++){
			initIBCombo(sheetObjects[l]);			
		}
		loadingMode = false;
    }
     
    function loadCombo() {
     	var formObj = document.form;
 		var sXml = formObj.sXml.value;

 		var arrXml = sXml.split("|$$|");
 		comboXml = arrXml;

 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
 		if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
 		if (arrXml.length > 2)
 			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
 		document.form.sXml.value="";
     }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,head) {
    	var formObj = document.form;

    	var arrhead1 = "";
//    	var arrhead2 = "";
//    	var arrhead3 = "";
    	var head1    = "";
    	var head2    = "";
    	var head3    = "";
//    	var fixCnt = 16; //고정길이
    	var varCnt = 0;  //가변길이

    	switch(sheetNo) {

    			
    		case 1:	//sheet2 init
    			if (head == "") {
    			head = "|CRR1|CRR1|CRR2|CRR2|CRR3|CRR3";
    			}
    			arrhead1 = head.replace(/(^\s*)/g, '').split("|");
    			varCnt = arrhead1.length ;
    			with (sheetObj) {
    			    style.height = GetSheetHeight(sheet_height) ;
    			    
    				SheetWidth = mainTable1.clientWidth;
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				MergeSheet = msHeaderOnly;
    				Editable = true;
    				InitRowInfo(3, 1, 9, 100);
    				InitColumnInfo(14+(varCnt*2), 14, 0, true);
    				InitHeadMode(false, false, false, true, false, false);
    				head1 = "";
    				head2 = "";
    				haed3 = "";
    				for(k=0;k<=varCnt; k++){
    					head1 = head1 + "|D3|D3";
    					head2 = head2 + "|"+ arrhead1[k] +"|"+ arrhead1[k];
    					head3 = head3 + "|Rate|Rate Type";
    				}
    				
    				var HeadTitle0 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head1;
    				var HeadTitle1 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head2;
    				var HeadTitle2 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head3;

    				InitHeadRow(0, HeadTitle0, true);
    				InitHeadRow(1, HeadTitle1, true);
    				InitHeadRow(2, HeadTitle2, true);

    				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
    				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
    				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
    				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
    				var cnt = 0;
    				InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true, "del");
    				InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
    				InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "group", false, "", dfInteger, 0, false, false);
    				InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "maxseq", false, "", dfInteger, 0, false, false);

    				InitDataProperty(0, cnt++, dtHidden,    30, daCenter, true, "M_prc_seq",        false, "", dfNone, 0, false, true);
    				InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "M_seq_org",    false, "", dfNone, 0, false, true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_vvd_cd" ,            false, "", dfEngUpKey,9, true,  true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_bsa_fm_dt",  false, "", dfDateYmd, 0, true,  true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_bsa_to_dt",  false, "", dfDateYmd, 0, true,  true);
    				InitDataProperty(0, cnt++, dtCombo,    45, daCenter, true, "M_trd_cd",             false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    45, daCenter, true, "M_rlane_cd",           false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    40, daCenter, true, "M_dir_cd",             false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    40, daCenter, true, "M_opr",               false, "", dfNone,    0, true, true);
    				InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "M_cntr_tpsz_cd", false, "", dfNone,    0, false, false);

    				for (var n=0; n<varCnt; n++) {
    					InitDataProperty(0, cnt, dtAutoSum, 60, daRight, true, "OvrRate"+n, false, "", dfFloatOrg, 2, true, true);
    					CellBackColor(1, cnt) = RgbColor(211, 219, 255);
    					cnt++;
    					InitDataProperty(0, cnt, dtCombo, 70, daRight, true, "RateType"+n, false, "", dfNone, 0, true, true);
//    					CellBackColor(2, cnt) = RgbColor(222, 251, 248);
    					cnt++;
//    					alert(arrhead1[n]+"["+n+"]");
     				initDataCombo(0,"RateType"+n," |Rate|Void"," |R|V");
    				}

     				//InitDataCombo(0,"M_trd_cd",formObj.all.tradeCombo.value,formObj.all.tradeCombo.value);
                    //InitDataCombo(0,"M_rlane_cd", formObj.all.rlaneCombo.value, formObj.all.rlaneCombo.value);
                    //InitDataCombo(0,"M_dir_cd", formObj.all.dirCombo.value,formObj.all.dirCombo.value);
    				initDataCombo(0,"M_opr","SML|OTH","H|O");
     
//    				RangeBackColor(1, 13, 1, 15) = RgbColor(255, 248, 251);
    				HeadRowHeight = 10;
    				CountPosition = 0 ;
    				

    				//Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시할지 여부를 확인하거나 설정한다.
    				EditableColorDiff = false;
    			}
    	
    			break;
    			
    		case 2:	//sheet2 init
    			if (head == "") {
    			head = "|CRR1|CRR1|CRR2|CRR2|CRR3|CRR3";
    			}
    			arrhead1 = head.replace(/(^\s*)/g, '').split("|");
    			varCnt = arrhead1.length ;
    			with (sheetObj) {
    			    style.height = GetSheetHeight(sheet_height) ;
    			    
    				SheetWidth = mainTable1.clientWidth;
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				MergeSheet = msHeaderOnly;
    				Editable = true;
    				InitRowInfo(3, 1, 9, 100);
    				InitColumnInfo(14+(varCnt*2), 14, 0, true);
    				InitHeadMode(false, false, false, true, false, false);
    				head1 = "";
    				head2 = "";
    				haed3 = "";
    				for(k=0;k<=varCnt; k++){
    					head1 = head1 + "|D5|D5";
    					head2 = head2 + "|"+ arrhead1[k] +"|"+ arrhead1[k];
    					head3 = head3 + "|Rate|Rate Type";
    				}
    				
    				var HeadTitle0 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head1;
    				var HeadTitle1 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head2;
    				var HeadTitle2 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head3;

    				InitHeadRow(0, HeadTitle0, true);
    				InitHeadRow(1, HeadTitle1, true);
    				InitHeadRow(2, HeadTitle2, true);

    				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
    				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
    				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
    				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
    				var cnt = 0;
    				InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true, "del");
    				InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
    				InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "group", false, "", dfInteger, 0, false, false);
    				InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "maxseq", false, "", dfInteger, 0, false, false);

    				InitDataProperty(0, cnt++, dtHidden,    30, daCenter, true, "M_prc_seq",        false, "", dfNone, 0, false, true);
    				InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "M_seq_org",    false, "", dfNone, 0, false, true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_vvd_cd" ,            false, "", dfEngUpKey,9, true,  true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_bsa_fm_dt",  false, "", dfDateYmd, 0, true,  true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_bsa_to_dt",  false, "", dfDateYmd, 0, true,  true);
    				InitDataProperty(0, cnt++, dtCombo,    45, daCenter, true, "M_trd_cd",             false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    45, daCenter, true, "M_rlane_cd",           false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    40, daCenter, true, "M_dir_cd",             false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    40, daCenter, true, "M_opr",               false, "", dfNone,    0, true, true);
    				InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "M_cntr_tpsz_cd", false, "", dfNone,    0, false, false);

    				for (var n=0; n<varCnt; n++) {
    					InitDataProperty(0, cnt, dtAutoSum, 60, daRight, true, "OvrRate"+n, false, "", dfFloatOrg, 2, true, true);
    					CellBackColor(1, cnt) = RgbColor(211, 219, 255);
    					cnt++;
    					InitDataProperty(0, cnt, dtCombo, 70, daRight, true, "RateType"+n, false, "", dfNone, 0, true, true);
//    					CellBackColor(2, cnt) = RgbColor(222, 251, 248);
    					cnt++;
     				initDataCombo(0,"RateType"+n," |Rate|Void"," |R|V");
    				}

     				//InitDataCombo(0,"M_trd_cd",formObj.all.tradeCombo.value,formObj.all.tradeCombo.value);
                    //InitDataCombo(0,"M_rlane_cd", formObj.all.rlaneCombo.value, formObj.all.rlaneCombo.value);
                    //InitDataCombo(0,"M_dir_cd", formObj.all.dirCombo.value,formObj.all.dirCombo.value);
    				initDataCombo(0,"M_opr","SML|OTH","H|O");
     
//    				RangeBackColor(1, 13, 1, 15) = RgbColor(255, 248, 251);
    				HeadRowHeight = 10;
    				CountPosition = 0 ;
    				

    				//Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시할지 여부를 확인하거나 설정한다.
    				EditableColorDiff = false;
    			}
    	
    			break;
    			
    		case 3:	//sheet2 init
    				if (head == "") {
    			head = "|CRR1|CRR1|CRR2|CRR2|CRR3|CRR3";
    			}
    			arrhead1 = head.replace(/(^\s*)/g, '').split("|");
    			varCnt = arrhead1.length ;
    			with (sheetObj) {
    			    style.height = GetSheetHeight(sheet_height) ;
    			    
    				SheetWidth = mainTable3.clientWidth;
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				MergeSheet = msHeaderOnly;
    				Editable = true;
    				InitRowInfo(3, 1, 9, 100);
    				InitColumnInfo(14+(varCnt*3), 14, 0, true);
    				InitHeadMode(false, false, false, true, false, false);
    				head1 = "";
    				head2 = "";
    				haed3 = "";
    				for(k=0;k<=varCnt; k++){
    					head1 = head1 + "|D7|D7|D7";
    					head2 = head2 + "|"+ arrhead1[k] +"|"+ arrhead1[k] +"|"+ arrhead1[k];
    					head3 = head3 + "|Within Rate|Over Rate|Rate Type";
    				}
    				
    				var HeadTitle0 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head1;
    				var HeadTitle1 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head2;
    				var HeadTitle2 = "Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
    				               + head3;

    				InitHeadRow(0, HeadTitle0, true);
    				InitHeadRow(1, HeadTitle1, true);
    				InitHeadRow(2, HeadTitle2, true);

    				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
    				//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
    				//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
    				//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
    				var cnt = 0;
    				InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true, "del");
    				InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");
    				InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "group", false, "", dfInteger, 0, false, false);
    				InitDataProperty(0, cnt++, dtHidden,  40, daCenter, true, "maxseq", false, "", dfInteger, 0, false, false);

    				InitDataProperty(0, cnt++, dtHidden,    30, daCenter, true, "M_prc_seq",        false, "", dfNone, 0, false, true);
    				InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "M_seq_org",    false, "", dfNone, 0, false, true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_vvd_cd" ,            false, "", dfEngUpKey,9, true,  true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_bsa_fm_dt",  false, "", dfDateYmd, 0, true,  true);
    				InitDataProperty(0, cnt++, dtData,    70, daCenter, true, "M_bsa_to_dt",  false, "", dfDateYmd, 0, true,  true);
    				InitDataProperty(0, cnt++, dtCombo,    45, daCenter, true, "M_trd_cd",             false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    45, daCenter, true, "M_rlane_cd",           false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    40, daCenter, true, "M_dir_cd",             false, "", dfNone,    0, false, true);
    				InitDataProperty(0, cnt++, dtCombo,    40, daCenter, true, "M_opr",               false, "", dfNone,    0, true, true);
    				InitDataProperty(0, cnt++, dtHidden,  30, daCenter, true, "M_cntr_tpsz_cd", false, "", dfNone,    0, false, false);

    				for (var n=0; n<varCnt; n++) {
    					InitDataProperty(0, cnt, dtAutoSum, 73, daRight, true, "WtnRate"+n, false, "", dfFloatOrg, 2, true, true);
    					CellBackColor(1, cnt) = RgbColor(211, 219, 255);
    					cnt++;
    					InitDataProperty(0, cnt, dtAutoSum, 70, daRight, true, "OvrRate"+n, false, "", dfFloatOrg, 2, true, true);
    					CellBackColor(1, cnt) = RgbColor(211, 219, 255);
    					cnt++;
    					InitDataProperty(0, cnt, dtCombo, 70, daRight, true, "RateType"+n, false, "", dfNone, 0, true, true);
//    					CellBackColor(1, cnt) = RgbColor(222, 251, 248);
    					cnt++;
//    					CellBackColor(2, cnt) = RgbColor(222, 251, 248);
    				initDataCombo(0,"RateType"+n," |Rate|Void"," |R|V");
    				}	

     				//InitDataCombo(0,"M_trd_cd",formObj.all.tradeCombo.value,formObj.all.tradeCombo.value);
                    //InitDataCombo(0,"M_rlane_cd", formObj.all.rlaneCombo.value, formObj.all.rlaneCombo.value);
                   // InitDataCombo(0,"M_dir_cd", formObj.all.dirCombo.value,formObj.all.dirCombo.value);
    				initDataCombo(0,"M_opr","SML|OTH","H|O");
     
     
//    				RangeBackColor(1, 13, 1, 15) = RgbColor(255, 248, 251);
    				HeadRowHeight = 10;
    				CountPosition = 0 ;
    				

    				//Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시할지 여부를 확인하거나 설정한다.
    				EditableColorDiff = false;
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
  		}
  	}
  	
  	/**
 	 * 
 	 * @param sheetObj
 	 * @param formObj
 	 * @param sAction
 	 * @return
 	 */
 	function initIBCombo(sheetObj){
 		if (comboXml.length > 0){
 			comSetIBCombo(sheetObj, comboXml[0], "M_trd_cd", true, 0);
 		}
 		if (comboXml.length > 2){
 			comSetIBCombo(sheetObj, comboXml[2], "M_dir_cd",true,0);
 		}
 		if (comboXml.length > 3){
 			comSetIBCombo(sheetObj, comboXml[3], "M_rlane_cd",true,0);
 		}
 	}

    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if (!validateCond(formObj)) {
    				return false;
    			}
    			formObj.f_cmd.value = SEARCHLIST;
                sheetObj.DoSearch4Post("ESM_BSA_0172GS.do", bsaFormString(formObj,getParam(curPgmNo)));
    			break;

    		case IBSAVE:        //저장
    			if (!validateForm(sheetObj)) {
    				return false;
    			}
    			if (!validateCond2(sheetObj, headTmp)) {
    				return false;
    			}
    			
    			formObj.f_cmd.value = MULTI;
    			sheetObj.DoSave("ESM_BSA_0172GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
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

    		case IBCOPYROW:      // 행추가
    			with(sheetObj) {
        			if (RowCount > 0) {
        				var Row = DataCopy(false); //행을 복사
        				CellValue2(Row,"M_seq_org") = "";
        				CellValue2(Row,"M_prc_seq") = "";
        				
    					if (Row > HeaderRows) {
            				InitHeadMode(false, false, false, true, false, false); //Sort불가능
//            				CellValue2(Row,"M_slt_prc_seq")  = parseInt(CellValue(Row,"M_slt_prc_seq")) + 1;
                    		CellBackColor(Row, "ibflag")     = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_trd_cd")   = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_rlane_cd") = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_dir_cd")   = RgbColor(239,235,239);
                    		
            				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
//            				var index = 0;
//            				var v_num = 1;
//                            for(i=1; i<LastRow; i++){
//                                index = FindText("group", CellValue(Row,"group"), i, true);
//                                if(i == 1) v_num = CellValue(index, "M_slt_prc_seq");// 화면에 조회된 seq 에서 부터 증가시키도록 함
//                                if (index >0){// 찾은 문자열이 있을면
//                                    if(CellValue(index, "ibflag") != "D"){
//                                        CellValue(index,"M_slt_prc_seq") = v_num;
//                                        v_num++;
//                                    } else {
//                                        CellValue(index, "M_slt_prc_seq") = CellSearchValue(index, "M_slt_prc_seq");
//                                    }
//                                    i = parseInt(index);
//                                } else {
//                                    i = LastRow;
//                                }
//                            }
    //
//                    		// SEQ 가 케에 해당 하므로 현재 삽인된 행은 UPDATE가 되고  맨 마지막 행은 INSERT가 되어야한다.
//                    		// 따라서 아래와 같이 상태를 변경한다. maxseq
//                    		Cellvalue2(Row, "ibflag") = "U"; 
//                    		for(i=Row; i<=LastRow; i++){
//                    		    if(CellValue(Row,"group") == CellValue(i,"group")){
//                    		        if(parseInt(CellValue(Row,"maxseq")) < parseInt(CellValue(i,"M_slt_prc_seq"))){
//                                		if(CellValue(i, "ibflag") != "D") Cellvalue2(i, "ibflag") = "I";
//                    		        }
//                    		    }
//                    		}
    					}
        			}
    			}
    			break;
    			
    		case IBINSERT:   // 행 추가
    			sheetObj.DataInsert(-1);
    			
    			break;		

    	}
    }

    function doActionIBSheet2(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {

    		case IBSEARCH:      //조회
    			if (!validateCond(formObj)) {
    				return false;
    			}
    			formObj.f_cmd.value = SEARCHLIST02;
    			sheetObj.DoSearch4Post("ESM_BSA_0172GS.do", bsaFormString(formObj,getParam(curPgmNo)));
    			
    			break;

    		case IBSAVE:        //저장
    			if (!validateForm(sheetObj)) {
    				return false;
    			}
    			if (!validateCond2(sheetObj, headTmp)) {
    				return false;
    			}
    			formObj.f_cmd.value = MULTI02;
    			sheetObj.DoSave("ESM_BSA_0172GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
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

    		case IBCOPYROW:      // 행추가
    			with(sheetObj) {
        			if (RowCount > 0) {
        				var Row = DataCopy(false); //행을 복사
        				CellValue2(Row,"M_seq_org") = "";
        				CellValue2(Row,"M_prc_seq") = "";
        				
    					if (Row > HeaderRows) {
            				InitHeadMode(false, false, false, true, false, false); //Sort불가능
//            				CellValue2(Row,"M_slt_prc_seq")  = parseInt(CellValue(Row,"M_slt_prc_seq")) + 1;
                    		CellBackColor(Row, "ibflag")     = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_trd_cd")   = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_rlane_cd") = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_dir_cd")   = RgbColor(239,235,239);
                    		
//            				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
//            				var index = 0;
//            				var v_num = 1;
//                            
//                            for(i=1; i<LastRow; i++){
//                                index = FindText("group", CellValue(Row,"group"), i, true);
//                                if(i == 1) v_num = CellValue(index, "M_slt_prc_seq");// 화면에 조회된 seq 에서 부터 증가시키도록 함
//                                if (index >0){// 찾은 문자열이 있을면
//                                    if(CellValue(index, "ibflag") != "D"){
//                                        CellValue(index,"M_slt_prc_seq") = v_num;
//                                        v_num++;
//                                    } else {
//                                        CellValue(index, "M_slt_prc_seq") = CellSearchValue(index, "M_slt_prc_seq");
//                                    }
//                                    i = parseInt(index);
//                                } else {
//                                    i = LastRow;
//                                }
//                            }
    //
//                    		// SEQ 가 케에 해당 하므로 현재 삽인된 행은 UPDATE가 되고  맨 마지막 행은 INSERT가 되어야한다.
//                    		// 따라서 아래와 같이 상태를 변경한다. maxseq
//                    		Cellvalue2(Row, "ibflag") = "U"; 
//                    		for(i=Row; i<=LastRow; i++){
//                    		    if(CellValue(Row,"group") == CellValue(i,"group")){
//                    		        if(parseInt(CellValue(Row,"maxseq")) < parseInt(CellValue(i,"M_slt_prc_seq"))){
//                                		if(CellValue(i, "ibflag") != "D") Cellvalue2(i, "ibflag") = "I";
//                    		        }
//                    		    }
//                    		}
    					}
        			}
    			}
    			break;

    		case IBINSERT:   // 행 추가
    			with(sheetObj) {
    			 DataInsert(-1);
    			}
    			break;	
    	}
    }

    function doActionIBSheet3(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {

    		case IBSEARCH:      //조회
    			if (!validateCond(formObj)) {
    				return false;
    			}
    			formObj.f_cmd.value = SEARCHLIST03;
    			sheetObj.DoSearch4Post("ESM_BSA_0172GS.do", bsaFormString(formObj,getParam(curPgmNo)));
    			
    			break;

    		case IBSAVE:        //저장
    			if (!validateForm(sheetObj)) {
    				return false;
    			}
    			if (!validateCond2(sheetObj, headTmp)) {
    				return false;
    			}
    			formObj.f_cmd.value = MULTI03;
    			sheetObj.DoSave("ESM_BSA_0172GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, false);
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

    		case IBCOPYROW:      // 행추가
    			with(sheetObj) {
        			if (RowCount > 0) {
        				var Row = DataCopy(false); //행을 복사
        				CellValue2(Row,"M_seq_org") = "";
        				CellValue2(Row,"M_prc_seq") = "";
        				
    					if (Row > HeaderRows) {
            				InitHeadMode(false, false, false, true, false, false); //Sort불가능
//            				CellValue2(Row,"M_slt_prc_seq")  = parseInt(CellValue(Row,"M_slt_prc_seq")) + 1;
                    		CellBackColor(Row, "ibflag")     = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_trd_cd")   = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_rlane_cd") = RgbColor(239,235,239);
                    		CellBackColor(Row, "M_dir_cd")   = RgbColor(239,235,239);
                    		
//            				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
//            				var index = 0;
//            				var v_num = 1;
//                            
//                            for(i=1; i<LastRow; i++){
//                                index = FindText("group", CellValue(Row,"group"), i, true);
//                                if(i == 1) v_num = CellValue(index, "M_slt_prc_seq");// 화면에 조회된 seq 에서 부터 증가시키도록 함
//                                if (index >0){// 찾은 문자열이 있을면
//                                    if(CellValue(index, "ibflag") != "D"){
//                                        CellValue(index,"M_slt_prc_seq") = v_num;
//                                        v_num++;
//                                    } else {
//                                        CellValue(index, "M_slt_prc_seq") = CellSearchValue(index, "M_slt_prc_seq");
//                                    }
//                                    i = parseInt(index);
//                                } else {
//                                    i = LastRow;
//                                }
//                            }
    //
//                    		// SEQ 가 케에 해당 하므로 현재 삽인된 행은 UPDATE가 되고  맨 마지막 행은 INSERT가 되어야한다.
//                    		// 따라서 아래와 같이 상태를 변경한다. maxseq
//                    		Cellvalue2(Row, "ibflag") = "U"; 
//                    		for(i=Row; i<=LastRow; i++){
//                    		    if(CellValue(Row,"group") == CellValue(i,"group")){
//                    		        if(parseInt(CellValue(Row,"maxseq")) < parseInt(CellValue(i,"M_slt_prc_seq"))){
//                                		if(CellValue(i, "ibflag") != "D") Cellvalue2(i, "ibflag") = "I";
//                    		        }
//                    		    }
//                    		}
    					}
        			}
    			}
    			break;
    			
    	case IBINSERT:   // 행 추가
    			with(sheetObj) {
    			 DataInsert(-1);
    			}
    			break;	
    	}
    }

    function changeSheet( rdoType){
    		var formObj = document.form;

//    			for(var k=0; k<11; k++)
//    				if(sheetObjects[k].RowCount>0) sheetObjects[k].removeAll();
    				
    			if ( formObj.rdoType[0].checked ) { 
    			    d3_opt.style.display = "inline";
    				d5_opt.style.display = "none";
    			    d7_opt.style.display = "none";
    			

    			} else if ( formObj.rdoType[1].checked) {
    			    d3_opt.style.display = "none";
    			    d5_opt.style.display ="inline"
    			    d7_opt.style.display = "none";
    			   
    			    
    			} else if ( formObj.rdoType[2].checked) {
    				d3_opt.style.display = "none";
    				d5_opt.style.display ="none"
    			    d7_opt.style.display = "inline";
    			    
    			    		    
    			} 
    			//document.form.f_cost_yrmon.focus();
    	
    		}

    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {    	
    	with(sheetObj){
            
    		//행 전체의 배경색을 설정하거나 확인한다.
    		ColBackColor("ibflag")        = RgbColor(239,235,239);
    		ColBackColor("M_prc_seq") 	  = RgbColor(239,235,239);
    		ColBackColor("M_trd_cd")      = RgbColor(239,235,239);
    		ColBackColor("M_rlane_cd")    = RgbColor(239,235,239);
    		ColBackColor("M_dir_cd")      = RgbColor(239,235,239);
    	}
    	
        //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
        if(document.form.isExcludZero.checked) {
          for(var k=14; k<=sheetObj.LastCol; k++) {   
              if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                 sheetObj.ColHidden(k) = true;
                 sheetObj.ColHidden(k+1) = true;
              }	 
              k++
          }
        } else {
          for(var k=14; k<=sheetObj.LastCol; k++){
               if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                  sheetObj.ColHidden(k) = false;
                  sheetObj.ColHidden(k+1) = false;	  
               }          
          }	      
        }
    }
    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
    	with(sheetObj){
    		//행 전체의 배경색을 설정하거나 확인한다.
    		ColBackColor("ibflag")        = RgbColor(239,235,239);
    		ColBackColor("M_prc_seq") = RgbColor(239,235,239);
    		ColBackColor("M_trd_cd")      = RgbColor(239,235,239);
    		ColBackColor("M_rlane_cd")    = RgbColor(239,235,239);
    		ColBackColor("M_dir_cd")      = RgbColor(239,235,239);
    	}
    	
        //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
        if(document.form.isExcludZero.checked) {
          for(var k=14; k<=sheetObj.LastCol; k++) {          
              if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                 sheetObj.ColHidden(k) = true;
                 sheetObj.ColHidden(k+1) = true;
              }	 
              k++
          }
        } else {
          for(var k=14; k<=sheetObj.LastCol; k++){
               if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                  sheetObj.ColHidden(k) = false;
                  sheetObj.ColHidden(k+1) = false;
          	   }	            
          }	      
        }
    }
    function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
    	with(sheetObj){
    		//행 전체의 배경색을 설정하거나 확인한다.
    		ColBackColor("ibflag")        = RgbColor(239,235,239);
    		ColBackColor("M_prc_seq") = RgbColor(239,235,239);
    		ColBackColor("M_trd_cd")      = RgbColor(239,235,239);
    		ColBackColor("M_rlane_cd")    = RgbColor(239,235,239);
    		ColBackColor("M_dir_cd")      = RgbColor(239,235,239);
    	}
    	
        //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
        if(document.form.isExcludZero.checked) {
          for(var k=14; k<=sheetObj.LastCol; k++) {          
              if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                 sheetObj.ColHidden(k) = true;
                 sheetObj.ColHidden(k+1) = true;	 
                 sheetObj.ColHidden(k+2) = true;	 
              }
              k = k +2;
          }
        } else {
          for(var k=14; k<=sheetObj.LastCol; k++){
               if(sheetObj.CellBackColor(0, k) != sheetObj.CellBackColor(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00){
                  sheetObj.ColHidden(k) = false;
                  sheetObj.ColHidden(k+1) = false;	            
                  sheetObj.ColHidden(k+2) = false;	            
               }
          }	      
        }
    }

    /**
         * sheet 데이터 변경시 처리해주는 부분
         * vvd 변경시 First ETD 데이타를 가지고 온다.
         */
        function sheet1_OnChange(sheetObj,Row,Col,Value) {
        	 var param = "";
        	 ComOpenWait(true);

        	with(sheetObj){
        	    
        	    // 컬럼 색깔 컨트롤 
        		if (Value != 0 && CellBackColor(Row,Col) == RgbColor(255,255,0)) { //값을 바꾸면 RgbColor(255,248,251)으로 만들고
        			CellBackColor(Row,Col) = RgbColor(255,248,251);
        		} else { //값을 바뀌었는데 이전값과 동일하면 RgbColor(255,255,0) 되돌림
        			if (Value == CellSearchValue(Row,Col) && CellBackColor(Row,Col) == RgbColor(255,248,251)) {
        				CellBackColor(Row,Col) = RgbColor(255,255,0);
        			}
        		}
        		// 기간과, 상태 컨트롤 
        		if (ColSaveName(Col) == "M_bsa_fm_dt" && CellValue(Row-1,"group") == CellValue(Row,"group")) {
        			CellValue2(Row-1,"M_bsa_to_dt") = getOffsetDate(Value,-1);
        			Cellvalue2(Row-1, "ibflag") = "U";
        			if(CellValue(Row,"group") == CellValue(Row+1,"group")){
        			    CellValue2(Row,"M_bsa_to_dt") = getOffsetDate(CellValue(Row+1,"M_bsa_fm_dt"),-1);
        			}
        		}
        		
        		// DEL 상태가 변경시 SEQ와 상태 그리고 기간을 변경한다..
        		if(sheetObj.ColSaveName(Col) == "del") {
        		    // 상태가 Delete 일경우 
    				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
    				var index = 0;
    				var v_num = 1;
                    
                    for(i=1; i<LastRow; i++){
                        index = FindText("group", CellValue(Row,"group"), i, true);
                        if(i == 1) v_num = CellValue(index, "M_prc_seq"); // 조회된 처음 seq를 조회 한다.
                        if (index >0){// 찾은 문자열이 있을면
                            if(CellValue(index, "ibflag") != "D"){
                                CellValue(index,"M_prc_seq") = v_num;
                                v_num++;
                            } else {
                                CellValue(index, "M_prc_seq") = CellSearchValue(index, "M_prc_seq");
                            }
                            i = parseInt(index);
                        } else {
                            i = LastRow;
                        }
                    }
            		
            		// SEQ의 변화에 따라서 상태를 변경한다.
            		for(i=Row+1; i<=sheetObj.LastRow; i++){
            		    if(sheetObj.CellValue(Row,"group") == sheetObj.CellValue(i,"group")){
            		        if(parseInt(sheetObj.CellValue(Row,"maxseq")) < parseInt(sheetObj.CellValue(i,"M_prc_seq"))){
                        		if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.Cellvalue2(i, "ibflag") = "I";
            		        } else {
            		            if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.CellValue2(i, "ibflag") = "U";
            		        }
            		    }
            		}

        		}
//        		if (ColSaveName(Col) == "M_bsa_slt_prc_to_dt" && CellValue(Row+1,"group") == CellValue(Row,"group")) {
//        			CellValue2(Row+1,"M_bsa_slt_prc_fm_dt") = getOffsetDate(Value,1);
//        		}
        		
        	}
        	// VVD 변경시 First ETD DT를 구해온다.
        	if (sheetObj.ColSaveName(Col) == "M_vvd_cd") {
    			selRow = Row;
    			selValue = Value;
    			
    			param = param+"f_cmd="+SEARCHLIST02;
    			param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
    			param = param+"&code=etdDt";
    			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    			var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
    			getEdtDate(etdDt);
        	}
        	
        	if (sheetObj.ColSaveName(Col) == "M_trd_cd") {
           	 	ComOpenWait(false);
        		ibTrade_OnChange(sheetObj, Row, Col);
        	}        	
        	ComOpenWait(false);
        }


        //VVD --> edt-date
        
          /**
         * sheet 데이터 변경시 처리해주는 부분
         * vvd 변경시 First ETD 데이타를 가지고 온다.
         */
        function sheet2_OnChange(sheetObj,Row,Col,Value) {
        	var formObj = document.form;
       	 	var param = "";
        	ComOpenWait(true);

        	with(sheetObj){
        	    
        	    // 컬럼 색깔 컨트롤 
        		if (Value != 0 && CellBackColor(Row,Col) == RgbColor(255,255,0)) { //값을 바꾸면 RgbColor(255,248,251)으로 만들고
        			CellBackColor(Row,Col) = RgbColor(255,248,251);
        		} else { //값을 바뀌었는데 이전값과 동일하면 RgbColor(255,255,0) 되돌림
        			if (Value == CellSearchValue(Row,Col) && CellBackColor(Row,Col) == RgbColor(255,248,251)) {
        				CellBackColor(Row,Col) = RgbColor(255,255,0);
        			}
        		}
        		// 기간과, 상태 컨트롤 
        		if (ColSaveName(Col) == "M_bsa_fm_dt" && CellValue(Row-1,"group") == CellValue(Row,"group")) {
        			CellValue2(Row-1,"M_bsa_to_dt") = getOffsetDate(Value,-1);
        			Cellvalue2(Row-1, "ibflag") = "U";
        			if(CellValue(Row,"group") == CellValue(Row+1,"group")){
        			    CellValue2(Row,"M_bsa_to_dt") = getOffsetDate(CellValue(Row+1,"M_bsa_fm_dt"),-1);
        			}
        		}
        		
        		// DEL 상태가 변경시 SEQ와 상태 그리고 기간을 변경한다..
        		if(sheetObj.ColSaveName(Col) == "del") {
        		    // 상태가 Delete 일경우 
    				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
    				var index = 0;
    				var v_num = 1;
                    
                    for(i=1; i<LastRow; i++){
                        index = FindText("group", CellValue(Row,"group"), i, true);
                        if(i == 1) v_num = CellValue(index, "M_prc_seq"); // 조회된 처음 seq를 조회 한다.
                        if (index >0){// 찾은 문자열이 있을면
                            if(CellValue(index, "ibflag") != "D"){
                                CellValue(index,"M_prc_seq") = v_num;
                                v_num++;
                            } else {
                                CellValue(index, "M_prc_seq") = CellSearchValue(index, "M_prc_seq");
                            }
                            i = parseInt(index);
                        } else {
                            i = LastRow;
                        }
                    }
            		
            		// SEQ의 변화에 따라서 상태를 변경한다.
            		for(i=Row+1; i<=sheetObj.LastRow; i++){
            		    if(sheetObj.CellValue(Row,"group") == sheetObj.CellValue(i,"group")){
            		        if(parseInt(sheetObj.CellValue(Row,"maxseq")) < parseInt(sheetObj.CellValue(i,"M_prc_seq"))){
                        		if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.Cellvalue2(i, "ibflag") = "I";
            		        } else {
            		            if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.CellValue2(i, "ibflag") = "U";
            		        }
            		    }
            		}

        		}
//        		if (ColSaveName(Col) == "M_bsa_slt_prc_to_dt" && CellValue(Row+1,"group") == CellValue(Row,"group")) {
//        			CellValue2(Row+1,"M_bsa_slt_prc_fm_dt") = getOffsetDate(Value,1);
//        		}
        		
        	}
        	// VVD 변경시 First ETD DT를 구해온다.
        	if (sheetObj.ColSaveName(Col) == "M_vvd_cd") {
    			selRow = Row;
    			selValue = Value;
    			
    			param = param+"f_cmd="+SEARCHLIST02;
    			param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
    			param = param+"&code=etdDt";
    			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    			var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
    			getEdtDate(etdDt);
        	}
        	if (sheetObj.ColSaveName(Col) == "M_trd_cd") {
            	ComOpenWait(false);
        		ibTrade_OnChange(sheetObj, Row, Col);
    		}
        	
        	ComOpenWait(false);
        }


        //VVD --> edt-date
        
          /**
         * sheet 데이터 변경시 처리해주는 부분
         * vvd 변경시 First ETD 데이타를 가지고 온다.
         */
        function sheet3_OnChange(sheetObj,Row,Col,Value) {
            var formObj = document.form;
       	 	var param = "";
            ComOpenWait(true);

        	with(sheetObj){
        	    
        	    // 컬럼 색깔 컨트롤 
        		if (Value != 0 && CellBackColor(Row,Col) == RgbColor(255,255,0)) { //값을 바꾸면 RgbColor(255,248,251)으로 만들고
        			CellBackColor(Row,Col) = RgbColor(255,248,251);
        		} else { //값을 바뀌었는데 이전값과 동일하면 RgbColor(255,255,0) 되돌림
        			if (Value == CellSearchValue(Row,Col) && CellBackColor(Row,Col) == RgbColor(255,248,251)) {
        				CellBackColor(Row,Col) = RgbColor(255,255,0);
        			}
        		}
        		// 기간과, 상태 컨트롤 
        		if (ColSaveName(Col) == "M_bsa_fm_dt" && CellValue(Row-1,"group") == CellValue(Row,"group")) {
        			CellValue2(Row-1,"M_bsa_to_dt") = getOffsetDate(Value,-1);
        			Cellvalue2(Row-1, "ibflag") = "U";
        			if(CellValue(Row,"group") == CellValue(Row+1,"group")){
        			    CellValue2(Row,"M_bsa_to_dt") = getOffsetDate(CellValue(Row+1,"M_bsa_fm_dt"),-1);
        			}
        		}
        		
        		// DEL 상태가 변경시 SEQ와 상태 그리고 기간을 변경한다..
        		if(sheetObj.ColSaveName(Col) == "del") {
        		    // 상태가 Delete 일경우 
    				// 해당 그룹의 삭제된 Row를 제외하고 전체적으로 SEQ를 부여한다. 
    				var index = 0;
    				var v_num = 1;
                    
                    for(i=1; i<LastRow; i++){
                        index = FindText("group", CellValue(Row,"group"), i, true);
                        if(i == 1) v_num = CellValue(index, "M_prc_seq"); // 조회된 처음 seq를 조회 한다.
                        if (index >0){// 찾은 문자열이 있을면
                            if(CellValue(index, "ibflag") != "D"){
                                CellValue(index,"M_prc_seq") = v_num;
                                v_num++;
                            } else {
                                CellValue(index, "M_prc_seq") = CellSearchValue(index, "M_prc_seq");
                            }
                            i = parseInt(index);
                        } else {
                            i = LastRow;
                        }
                    }
            		
            		// SEQ의 변화에 따라서 상태를 변경한다.
            		for(i=Row+1; i<=sheetObj.LastRow; i++){
            		    if(sheetObj.CellValue(Row,"group") == sheetObj.CellValue(i,"group")){
            		        if(parseInt(sheetObj.CellValue(Row,"maxseq")) < parseInt(sheetObj.CellValue(i,"M_prc_seq"))){
                        		if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.CellValue2(i, "ibflag") = "I";
            		        } else {
            		            if(sheetObj.CellValue(i, "ibflag") != "D") sheetObj.CellValue2(i, "ibflag") = "U";
            		        }
            		    }
            		}

        		}
//        		if (ColSaveName(Col) == "M_bsa_slt_prc_to_dt" && CellValue(Row+1,"group") == CellValue(Row,"group")) {
//        			CellValue2(Row+1,"M_bsa_slt_prc_fm_dt") = getOffsetDate(Value,1);
//        		}
        		
        	}
        	// VVD 변경시 First ETD DT를 구해온다.
        	if (sheetObj.ColSaveName(Col) == "M_vvd_cd") {
    			selRow = Row;
    			selValue = Value;
    			
    			param = param+"f_cmd="+SEARCHLIST02;
    			param = param+"&vvd_cd="+sheetObj.CellValue(Row,Col);
    			param = param+"&code=etdDt";
    			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
    			var etdDt = GetEtcDataForExceptional(sXml, "etdDt", "0");
    			getEdtDate(etdDt);
        	}
        	if (sheetObj.ColSaveName(Col) == "M_trd_cd") {
           	 	ComOpenWait(false);
        		ibTrade_OnChange(sheetObj, Row, Col);
    		}
        	
        	ComOpenWait(false);
        }

    function getEdtDate(result) {
        	var sheetObj ;
        	var tmpRow = 0;
        	var formObj = document.form;
        
        	if(formObj.rdoType[0].checked){
        		sheetObj = sheetObjects[0];
       		}else if(formObj.rdoType[1].checked){
    	   			sheetObj = sheetObjects[1];	
       		}else if(formObj.rdoType[2].checked){
    	   			sheetObj = sheetObjects[2];	
       		}
        	if(result == null || result == "" || result == "null"){
        		ComShowMessage(ComGetMsg('BSA10027',selValue));  //msg1 + '는(은) 유효한 VVD가 아니거나 EDT Date가 존재하지 않습니다.'
        		sheetObj.SelectCell(selRow,"M_vvd_cd",true);
        	} else {
        		sheetObj.CellValue(selRow,"M_bsa_fm_dt") = result;
        	}
        }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj) {
    	with(sheetObj){
    	}

    	return true;
    }


    /**
     * 화면 조회값에 대한 유효성검증 프로세스 처리
     */
    function validateCond(formObj) {
    	with(formObj){
    	if (ComTrim(txtSDate.value) == "") {
    			//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
    			//txtSDate.focus();
    			ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
    			return false;
    		}

    		// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
    		if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
    			if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
    				//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
    				//txtEDate.focus();
    				ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
    				return false;
    			}
    		}
    		
//    		 if(formObj.cobTrade.value == ""){ 
//  	            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//  	            return false;
//  	        }
//  	        
// 	        if(formObj.cobLane.value == ""){
// 	             ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
// 	             return false;
// 	        }
    	}

    	return true;
    }

    //function validateCond2(sheetObj,head) { 
//    	var arrhead1 = "";
//    	var varCnt = 0;  //가변길이
//    	var row =sheetObj.FindStatusRow("U|I");
//    	var arrRow = Row.split(";");
//      	for (idx=0; idx<arrRow.length-1; idx++){ alert(arrRow[idx]); }
//    	var row =sheetObj.FindStatusRow("U|I");
    //	
//    	with(sheetObj){
//    	arrhead1 = head.replace(/(^\s*)/g, '').split("|");
//    	varCnt = arrhead1.length ;
//    	for (var n=0; n<varCnt; n++) {
//    	if (CellValue(row,"OvrRate"+n) == 0 && CellValue(row,"RateType"+n) == "") {
//    			alertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
//    			return false;
//    		}
    //
//    		
//    	}
    //
//    	return true;
    //}	
    //}	

    //function validateCond2(sheetObj,head) {
    // var row =sheetObj.FindStatusRow("U|D");
    // var varCnt = row.length ;
    // for (var n=0; n<varCnt; n++) {
//     	alert(n);
    // if (sheetObj.CellValue(row[n],"OvrRate"+n) == 0 && sheetObj.CellValue(row[n],"RateType"+n) == "") {
    //   alert("error");
    //   return false;
    //  }
    // }
    //
    // return true;
    //} 

    function validateCond2(sheetObj,head) {
     var arrhead1 = "";
     var varCnt = 0;  //가변길이
     var row =sheetObj.FindStatusRow("U|D|I");
     var arrRow = row.split(";");
     var formObject = document.form;
     arrhead1 = head.replace(/(^\s*)/g, '').split("|");
     varCnt = arrhead1.length ;
     
     for(i=0;i<arrRow.length-1;i++){
    	 for (n=0; n<varCnt; n++) {
//    	 	alert(sheetObj.CellValue(row[i],"OvrRate"+n) + " : "+sheetObj.CellValue(row[i],"RateType"+n));
    	  if(formObject.rdoType[0].checked){ 
    		 if ((sheetObj.CellValue(arrRow[i],"OvrRate"+n) == 0 && sheetObj.CellValue(arrRow[i],"RateType"+n) != "") ||
    		     (sheetObj.CellValue(arrRow[i],"OvrRate"+n) != 0 && sheetObj.CellValue(arrRow[i],"RateType"+n) == "") 
    		     
    		    ) {
    			  alert("Please check Rate, RateType")
    			   return false;
    		  }
    	  }else if(formObject.rdoType[1].checked){ 
    		 if ((sheetObj.CellValue(arrRow[i],"OvrRate"+n) == 0 && sheetObj.CellValue(arrRow[i],"RateType"+n) != "") ||
    		     (sheetObj.CellValue(arrRow[i],"OvrRate"+n) != 0 && sheetObj.CellValue(arrRow[i],"RateType"+n) == "") 
    		     
    		    ) {
    			  alert("Please check Rate, RateType")
    			   return false;
    		 }   
    	  }else if(formObject.rdoType[2].checked){	  
    		 if (((sheetObj.CellValue(arrRow[i],"WtnRate"+n) == 0 || sheetObj.CellValue(arrRow[i],"OvrRate"+n) == 0) && sheetObj.CellValue(arrRow[i],"RateType"+n) != "")||
    		     ((sheetObj.CellValue(arrRow[i],"WtnRate"+n) != 0 || sheetObj.CellValue(arrRow[i],"OvrRate"+n) != 0) && sheetObj.CellValue(arrRow[i],"RateType"+n) == "")
    	 		) {
    	 			alert("Please check Rate, RateType")
    			   return false;
    	 		}
    	  }
     	}
     return true;
    } 
   } 	
    /**
     * ifram을 이용하여 R.Lane 표시
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

    function ibTrade_OnChange(sheetObj, row, col) {
  		if (loadingMode == true) return; 
  		var param = "";
  		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
  		with(sheetObj) {
  			trd_cd = CellValue(row, col);
  			
  			if(trd_cd != ""){
  				param = "f_cmd="+SEARCHLIST02;
  				param = param+"&trd_cd="+trd_cd;
  				param = param+"&code=ibLane";
  				var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
  				var rlane = GetEtcDataForExceptional(sXml, "trdCd", "0");
				sheetObj.CellComboItem(row,"M_rlane_cd", rlane, rlane);
  			}
  		}
		sheetObj.WaitImageVisible = true;
  	}
	/* 개발자 작업  끝 */