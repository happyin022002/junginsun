/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_1043.js
*@FileTitle  : Container Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/29
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
     * @class ESM_BKG_1043 : ESM_BKG_1043 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1043() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject1=sheetObjects[0];
		 var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display="none";
        		}    	    			
    		}
            switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				case "btn_findCovered":
					//alert("---> UI_BKG-0799");
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0799.do?func=&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0799", 900, 420, false);					
				break;																																				
				case "btn_add":
					doActionIBSheet(sheetObject2, formObject, IBINSERT);
				break;
				case "btn_del":
					doActionIBSheet(sheetObject2, formObject, IBDELETE);
				break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
				break;
				case "btn_exchange":
					//alert("---> UI_BKG-0945");
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0945.do?func=&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0945", 470, 470, false);					
				break;
				case "btn_save":
					doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;					
				case "btn_downexcel":
 					sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObject2), SheetDesign:1,Merge:1 });
				break;												
				case "btn_remark":
					//alert(srcName);
					var bkg_no=formObject.bkg_no.value;
					var url="ESM_BKG_0265.do?func=&bkg_no="+bkg_no+"&readOnly=Y";
					ComOpenWindowCenter(url, "ESM_BKG_0265", 750, 470, false);						
				break;																																				
				case "btn_dist":
					doActionIBSheet(sheetObject2, formObject, COMMAND01);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//iframe 생성 
    	CofigIframe();
		// init sheet
		if(!ComIsEmpty(document.form.bkg_no.value)){
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
		// add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);
        
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
        case "sheet1":      //sheet1 init
        with(sheetObj){

			var HeadTitle="Bkg No.|TP/SZ|CNTR Q'TY";
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
			 
			InitColumns(cols);
			
			SetEditable(0);
			SetCountPosition(0);
			
			SetSheetHeight(140);
//			SetSheetWidth(200);
        	}
			break;

        case "sheet2":      //sheet2 init
			with(sheetObj){
			
			var HeadTitle1="|Seq.|Sel.|BkgNo|CntrRtSeq|Container No.|Container No.|CHG|Cur|Rate|Rated As|Vol|Per|Amount|P/C|IN|Third|Payer|Payer|CGO|Term|Term|IMDG";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sel",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chg_ut_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rat_as_qty",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_qty",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"chg_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"frt_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"frt_incl_xcld_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_rcv_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cgo_cate_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(0);
			SetSheetHeight(280);
        	}
			break;
        case "sheet3":      //sheet3 init

			with(sheetObj){
			
			var HeadTitle="CUST_TP|CURR_CD|CHG_AMT";
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_tp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"chg_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(0);
			SetCountPosition(0);
			SetVisible(0);
        	}
			break;
			
        case "sheet4":      //sheet4 init

			with(sheetObj){
			
			var HeadTitle="CUST_TP|CUST_KEY|OFC|CNT|SEQ";
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_tp",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_key",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(0);
			SetCountPosition(0);
			SetVisible(0);
        	}
			break;


        }
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
                    formObj.f_cmd.value=SEARCH;
                     var rXml=sheetObj.GetSearchData("ESM_BKG_1043GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return false;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return false;
					}
                    var arrXml=rXml.split("|$$|");
					if(arrXml.length == 4){
						// etc data
						ComEtcDataXmlToForm(arrXml[0], formObj);
						// qty sheet
						sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
						// container sheet
						sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
						// container sheet
						sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
						// container sheet
						sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
						// Bill Type에 따른 변경
						/* 2.1. "C"일 경우 Coverd By 로 문구 변경, 텍스트 박스 보이기, 팝업버튼 숨기기
						 * 2.2. "M"일 경우 Covers로 문구 변경, 텍스트 박스 숨기기, 팝업버튼 보이기
						 * 2.3. 그외의 경우 문구 및 텍스트박스, 팝업버튼 숨기기 
						 */
						var bl_tp_cd=formObj.rt_bl_tp_cd.value;
						//alert("* bl_tp_cd : " + bl_tp_cd);
						if(bl_tp_cd == 'C'){
							document.getElementById('td_cvrd_text').innerHTML="Coverd By";
							formObj.mst_cvrd_bl_no.style.visibility="visible";
							formObj.btn_findCovered.style.visibility="hidden";
						}else if (bl_tp_cd == 'M'){
							document.getElementById('td_cvrd_text').innerHTML="Covers";
							formObj.mst_cvrd_bl_no.style.visibility="visible";
							formObj.btn_findCovered.style.visibility="visible";
						}else{
							document.getElementById('td_cvrd_text').innerHTML="";
							formObj.mst_cvrd_bl_no.style.visibility="hidden";
							formObj.btn_findCovered.style.visibility="hidden";
						}
						//
						document.getElementById('pn_amt_layer').innerHTML=getAmtTable('PN');
						document.getElementById('pn_ofc_layer').innerHTML=getOfficeTable('PN');
						document.getElementById('cn_amt_layer').innerHTML=getAmtTable('CN');
						document.getElementById('cn_ofc_layer').innerHTML=getOfficeTable('CN');
						document.getElementById('py_amt_layer').innerHTML=getAmtTable('PY');
						document.getElementById('py_ofc_layer').innerHTML=getOfficeTable('PY');
						document.getElementById('cy_amt_layer').innerHTML=getAmtTable('CY');
						document.getElementById('cy_ofc_layer').innerHTML=getOfficeTable('CY');
					}else{
						return false;
					}
				}else{
					return false;
				}
			break;
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI;
					// return xML
 					var rXml=sheetObj.GetSaveData("ESM_BKG_1043GS.do", FormQueryString(formObj));
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						/* Transaction 상태 복원 */
 						sheetObjects[1].LoadSaveData("<RESULT><TR-ALL>OK</TR-ALL><MESSAGE/></RESULT>");
						/* 성공메세지 */
						//ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false;
					}
				}else{
					return false;
				}
			break;
			case IBINSERT:        //입력
				if(validateForm(sheetObj,formObj,sAction)){
					var newrow=sheetObj.DataInsert(-1);
				}else{
					return false;
				}
			break;
			case IBDELETE:        //삭제
				ComRowHideDelete(sheetObj, "sel");
				//var idxArr = ComFindText(sheetObj, "sel", 1);
				//for(ir=0;ir<idxArr.length;ir++){
				//	
				//}
			break;
			case COMMAND01:
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=COMMAND01;
					// return xML
 					var rXml=sheetObj.GetSaveData("ESM_BKG_1043GS.do", FormQueryString(formObj));
					var rMsg=ComResultMessage(rXml);
					if(rMsg == ''){
						/* 성공메세지 */
						ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false;
					}
				}else{
					return false;
				}			
			break;
			case COMMAND04:      //booking split no조회 
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(0);
					ComSetObjValue(formObj.f_cmd, COMMAND03);
 					var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 18); 
					sheetObj.SetWaitImageVisible(1);
				}else{
					return false;
				}					
			break;
        }
		return true;
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSEARCH:      //조회
				if(ComIsEmpty(formObj.bkg_no.value) && ComIsEmpty(formObj.bl_no.value)){
					return false;
				}
			break;
			case IBSAVE:        //저장
			break;			
			case IBINSERT:        //추가
			break;			
			case IBDELETE:        //삭제
			break;
			case COMMAND01:        //배분
				if(ComIsEmpty(formObj.bkg_no.value)){
					ComShowMessage(ComGetMsg("BKG00425")); 
					return false;
				}
			break;
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;
        }
        return true;
    }
	/* --------------------------------------------------------------------
	 * Event 처리
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}
    function form1_blur(){
		//ComChkObjValid(event.srcElement);
    }
	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){                  //소문자
                	event.keyCode=keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}	
	}
    function form1_change(){
		/* 대문자 */
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
        var srcName=ComGetEvent("name");
        switch(srcName){
            case "bkg_no":
            break;
        }
    }
	function getAmtTable(type){
		var sheetObj=sheetObjects[2];
		var curr_cd=null;
		var chg_amt=null;
		var tableText=null;
		var idxArr=ComFindText(sheetObj, "cust_tp", type);
		tableText="<table width=\"100%\" class=\"grid2\">\n";
		if(idxArr.length == 0){
			tableText += "\t<tr><td width=\"40\" class=\"tr2_head\"></td><td></td></tr>"; 
			tableText += "\t<tr><td width=\"40\" class=\"tr2_head\"></td><td></td></tr>"; 
		} else if(idxArr.length == 1){
			curr_cd=sheetObj.GetCellValue(idxArr[0], "curr_cd");
			chg_amt=sheetObj.GetCellValue(idxArr[0], "chg_amt");
			tableText += "\t<tr><td width=\"40\" class=\"tr2_head\">"+curr_cd+"</td><td align=\"right\">"+ComAddComma3(chg_amt, "#,###.00")+"</td></tr>"; 
			tableText += "\t<tr><td width=\"40\" class=\"tr2_head\"></td><td></td></tr>"; 
		}else{
			for (ix=0; ix < idxArr.length; ix++) {
				curr_cd=sheetObj.GetCellValue(idxArr[ix], "curr_cd");
				chg_amt=sheetObj.GetCellValue(idxArr[ix], "chg_amt");
				tableText += "\t<tr><td width=\"40\" class=\"tr2_head\">"+curr_cd+"</td><td align=\"right\">"+ComAddComma3(chg_amt, "#,###.00")+"</td></tr>"; 
			}			
		}
		tableText += "</table>"; 
		return tableText;
	}
	function getOfficeTable(type){
		var sheetObj=sheetObjects[3];
		var cust_key=null;
		var ofc_cd=null;
		var cnt_cd=null;
		var cust_seq=null;
		var tableText=null;
		var idxArr=ComFindText(sheetObj, "cust_tp", type);
		tableText="<table width=\"100%\">\n";
		if(idxArr.length == 0){
			tableText += "\t<tr><td width=\"40\"></td><td width=\"20\"></td><td></td></tr>"; 
		}else{
			for (ix=0; ix < idxArr.length; ix++) {
				cust_key=sheetObj.GetCellValue(idxArr[ix], "cust_key");
				ofc_cd=sheetObj.GetCellValue(idxArr[ix], "ofc_cd");
				cnt_cd=sheetObj.GetCellValue(idxArr[ix], "cnt_cd");
				cust_seq=sheetObj.GetCellValue(idxArr[ix], "cust_seq");
				tableText += "\t<tr><td width=\"40\">"+ofc_cd+"</td><td width=\"20\">"+cnt_cd+"</td><td>"+cust_seq+"</td></tr>"; 
			}			
		}
		tableText += "</table>"; 
		return tableText;
	}
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	/* 개발자 작업  끝 */
