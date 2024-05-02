/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0044.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/26
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0044() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.sheet1_OnDblClick=sheet1_OnDblClick;
    }
    // 공통전역변수
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
       		var isOpen=false;
       		var sUrl="";
       		var sId="";
    		var srcName=ComGetEvent("name");
    		var vvdValue=formObject.vvd.value;
        	var ssrNoValue=formObject.ssr_no.value;
            switch(srcName) {
				case "btn_new":
					formObject.reset();
					pod.SetSelectIndex(0,false);
					break;
				case "btn_vvdListForSSRCreation":
//					sUrl="ESM_BKG_0551.do&pgmNo=ESM_BKG_0551&id=ESM_BKG_0551&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sUrl="ESM_BKG_0551.do?pgmNo=ESM_BKG_0551&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId="ESM_BKG_0551"
					break;
				case "btn_ssrViewForCusrep":
//					sUrl="ESM_BKG_0494.do&mainPage=true&pgmNo=ESM_BKG_0494&id=ESM_BKG_0494&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue + "&pod="+form.pod.GetSelectCode();
					sUrl="ESM_BKG_0494.do?pgmNo=ESM_BKG_0494&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue + "&pod="+pod.GetSelectCode();;
					sId="ESM_BKG_0494"
					break;
				case "btn_blListForCuscar":
//					sUrl="ESM_BKG_0063.do&pgmNo=ESM_BKG_0063&id=ESM_BKG_0063&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue+ "&pod="+form.pod.GetSelectCode();
					sUrl="ESM_BKG_0063.do?pgmNo=ESM_BKG_0063&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue+ "&pod="+pod.GetSelectCode();;
					sId="ESM_BKG_0063"
					break;
				case "btn_blView":
//					sUrl="ESM_BKG_0045.do&mainPage=true&pgmNo=ESM_BKG_0045&id=ESM_BKG_0045&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sUrl="ESM_BKG_0045.do?pgmNo=ESM_BKG_0045&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId="ESM_BKG_0045"
					break;
				case "btn_cusrepHistoryByVvd":
//					sUrl="ESM_BKG_0186.do&mainPage=true&pgmNo=ESM_BKG_0186&id=ESM_BKG_0186&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sUrl="ESM_BKG_0186.do?pgmNo=ESM_BKG_0186&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId="ESM_BKG_0186"
					break;
				case "btn_cuscarHisByBl":
//					sUrl="ESM_BKG_0183.do&mainPage=true&pgmNo=ESM_BKG_0183&id=ESM_BKG_0183&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sUrl="ESM_BKG_0183.do?pgmNo=ESM_BKG_0183&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId="ESM_BKG_0183"
					break;
				case "btn_codeValidate":
//					sUrl="ESM_BKG_1054.do&mainPage=true&pgmNo=ESM_BKG_1054-1&id=ESM_BKG_1054&vvd=" + vvdValue + "&pod_cd="+form.pod.GetSelectCode();
					sUrl="ESM_BKG_1054.do?pgmNo=ESM_BKG_1054-1&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&pod_cd="+pod.GetSelectCode();
					sId="ESM_BKG_1054"
						break;
				case "btn_notyLetter":
//					sUrl="ESM_BKG_0672.do&mainPage=true&pgmNo=ESM_BKG_0672-01&id=ESM_BKG_0672&vvd=" + vvdValue + "&pod_cd="+form.pod.GetSelectCode();
					sUrl="ESM_BKG_0672.do?pgmNo=ESM_BKG_0672-01&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&pod_cd="+pod.GetSelectCode();
					sId="ESM_BKG_0672"
					break;
				case "btn_interCustomDataMgnt":
//					sUrl="ESM_BKG_0240.do&mainPage=true&pgmNo=ESM_BKG_0240&id=ESM_BKG_0240&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sUrl="ESM_BKG_0240.do?pgmNo=ESM_BKG_0240&mainPage=true&parentPgmNo=ESM_BKG_M001&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId="ESM_BKG_0240"
					break;
            } // end switch
            if (sId != "") module_pop(sUrl, sId);
    	}catch(e) {
    		if( e == "[object Error]" ) {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    function module_pop(url, id) {
        try {
            var iWidth=1040;
            var iHeight=700;
            var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
            var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
//            var sFeatures="status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
//            var winObj=window.open("/opuscntr/opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^" + url, id, sFeatures);
//            var winObj=window.open(url, id, sFeatures);
            var winObj = window.open(url);
            winObj.focus();
            //var sUrl = "/opuscntr/nis2010Main.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0442.do&pgmNo=ESM_BKG_0442.do?crn_no="+formObj.frm_crn_number.value;
        } catch(err) { alert(err.message); }
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
     * 콤보 Object를 comboObjects 배열에 등록
     * 
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
    	for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	      //MultiCombo초기화 
 	    for(var k=0;k < comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].options.id);
 	    }
        initControl();
        doActionIBSheet(sheetObjects[0], form, COMMAND11);
    }
    function initControl() {
    	//화면에서 필요한 이벤트
	var formObj=document.form;
	    axon_event.addListenerForm('change', 'obj_change', formObj);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * Combo Object 초기화
     * 
     * @param comboObj
     * @param comNo
     * @return
     */
    function initCombo(comboObj, comNo) {
    	switch (comboObj.options.id) {
    		case "pod":
    			with (comboObj) {
    				SetBackColor("#CCFFFD");
    				Style=1;//0 -편집 가능,1 -편집 불가능
    			}
    			break;
    	} // end switch
    }
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_change() {
    	var formObject=document.form;
    	var vvdValue=formObject.vvd.value;
    	var ssrNoValue=formObject.ssr_no.value;
    	if (ComChkLen(vvdValue, 9) == "2" || ComChkLen(ssrNoValue, 6) == "2" ) {
    		document.form.f_cmd.value=SEARCH;
         	sheetObjects[0].DoSearch("ESM_BKG_0044GS.do?vvd=+"+vvdValue+"&ssr_no="+ssrNoValue, FormQueryString(document.form),{Sync:2});
         	var vvdVal=sheetObjects[0].GetCellValue( 1, 2 );
         	var ssrNoVal=sheetObjects[0].GetCellValue( 1, 3 );
         	var vvdNm=sheetObjects[0].GetCellValue( 1, 4 );
         	var eta=sheetObjects[0].GetCellValue( 1, 5 );
         	
         	if(sheetObjects[0].RowCount()>0){
         		formObject.vvd.value=vvdVal;
         		formObject.ssr_no.value=ssrNoVal;
         		formObject.eta.value=eta; 
         	}else {
         		formObject.ssr_no.value="";
         		formObject.eta.value ="";
         	}
         	
         	// ie11 version 테스트로 인해  
/*         	if(vvdVal != "-1") {
         		formObject.vvd.value=vvdVal;
         	}
         	else { //if there doesn't exist data matched by vvd, reset form values
         		formObject.ssr_no.value="";
         		formObject.eta.value ="";
         	}
         		
         	if(ssrNoVal != "-1")
         		formObject.ssr_no.value=ssrNoVal; 
         	
         	if(eta != "-1") formObject.eta.value=eta; */

        	//if(vvdValue != '')
        	//	formObject.pol_cd.focus();
    	}
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:
        	    with(sheetObj){
              var HeadTitle1="|SEQ|VVD|SSR_NO|POL|ENG_NM|ETA";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:155,  Align:"Center",  ColMerge:1,   SaveName:"ssr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vvd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetVisible(0);
        		}
                break;
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	var formObject=document.form;
    	var vvdValue=formObject.vvd.value;
    	var ssrNoValue=formObject.ssr_no.value;
//    	var pod=pod.GetSelectCode();
    	var param='?vvd=' + vvdValue + '&ssr_no=' + ssrNoValue + '&pod=' + pod ;  
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_BKG_0044GS.do", FormQueryString(formObj),{Sync:2} );
					//상위 시트가 조회되면 첫째 로우 의 값으로 두번째 시트를 조회한다.
 					var pol=sheetObj.GetCellValue( 1, 2 );
					var vvd=document.form.vvd.value;
 			    	sheetObjects[0].DoSearch("ESM_BKG_0044GS.do?vvd="+vvd+"&pol_cd="+pol, FormQueryString(document.form) );
				}
				break;
			case COMMAND11 : //  PORT 조회
				formObj.f_cmd.value=SEARCH11;
				ComOpenWait(true);
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
				ComXml2ComboItem(sXml, pod, "pod_cd", "pod_cd");
				pod.SetSelectCode(form.in_pod.value);
				if(pod.GetSelectIndex()< 0) pod.SetSelectIndex(0,false);
				ComOpenWait(false);
				break;		
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        	switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if (formObj.vvd.value == "" || (formObj.ssr_no.value == "" ) ) 
	 			{
	 				ComShowCodeMessage('BKG00626','VVD or SSR NO');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case COMMAND01:
	 			return true;
	 		break;
        	}
        }
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */    
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var pol=sheetObj.GetCellValue( row, 2 );
    	var vvd=document.form.vvd.value;
    	document.form.f_cmd.value=SEARCH02;
     	sheetObjects[1].DoSearch("ESM_BKG_0044GS.do?vvd=+"+vvd+"&pol_cd="+pol, FormQueryString(document.form) );
    }        
    /**
     * 시트를 클릭했을 때 처리
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	for(var i=1; i <= sheetObj.RowCount(); i++) {
 		sheetObj.RowBackColor(i)=sheetObj.UnEditableColor;
		}
 	sheetObj.SetRowBackColor(row,sheetObj.SelectBackColor);
    }
    /**
     * 시트를 키보드로 이동할때 처리
     */
    function sheet1_OnKeyUp(row, col, KeyCode, Shift) {
    	sheet1_OnClick(sheetObjects[0], col, 0);
    }