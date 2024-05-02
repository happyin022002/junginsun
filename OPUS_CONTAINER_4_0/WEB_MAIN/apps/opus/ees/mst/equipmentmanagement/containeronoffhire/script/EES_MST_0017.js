/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0017.js
*@FileTitle  : ERP Interface - OW Master / Term Change
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
*/

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
 * @class ees_mst_0017 : ees_mst_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
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
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_retrieve":
				    if (formObject.de_yrmon.value.length < 7) {
			    	   ComShowCodeMessage("MST00001","Delivery Month");
			      	   return;
			    	}
			        if (formObject.type[0].checked == true){
			        	sheetObject2.RemoveAll();
			        	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			        }
			        else {
			        	sheetObject1.RemoveAll();
			        	doActionIBSheet(sheetObject2,document.form,IBSEARCH);
			        }
				break;
				
				case "btn_new":
					 sheetObject1.RemoveAll();
					 sheetObject2.RemoveAll();
					 sheetObjects[2].RemoveAll();
					// sheetObjects[3].RemoveAll();
					tabObjects[0].selectedIndex=0;
					formObject.type[0].checked=true;
					formObject.if_cd.value="0";
					formObject.de_yrmon.value="";
			        //첫번째 IBShseet의 데이터만 먼저 조회한다.
				    var today=new Date();
				    if (window.DOMParser)
			    	{
				    	if (today.getMonth() < 9){
					    	formObject.de_yrmon.value=String(today.getFullYear())+ "-0" + String(today.getMonth()+1);
					    } else {
					    	formObject.de_yrmon.value=String(today.getFullYear())+ "-" + String(today.getMonth()+1);
					    }
			    	}
				    else
				    	{
				    		if (today.getMonth() < 9){
						    	formObject.de_yrmon.value=String(today.getFullYear())+ "-0" + String(today.getMonth()+1);
						    } else {
						    	formObject.de_yrmon.value=String(today.getFullYear())+ "-" + String(today.getMonth()+1);
						    }
				    	}
					sheetObject1.SetHeaderCheck(0,"sel",0);
					sheetObject2.SetHeaderCheck(0,"sel",0);
					MstComBtnControl(false, "btn_t1cntrlist");
					MstComBtnControl(false, "btn_t2cntrlist");
				break;
				
				case "btn_save":
			        if (formObject.type[0].checked == true){
			        	//선택된것만 저장 대상으로 선별한다.
		        		var iCheckRow=sheetObject1.FindCheckedRow("sel");
		        		//가져온 행을 배열로 반든다.
		        		/*var arrRow=iCheckRow.split("|");
		        		for(var i=1; i <= sheetObject1.RowCount(); i++){
		        			sheetObject1.SetRowStatus(i,"R");
		        		}
		        		for (var idx=0; idx<arrRow.length-1; idx++){
		        			sheetObject1.SetRowStatus(arrRow[idx],"U");
		        		}*/
			        	doActionIBSheet(sheetObject1,document.form,IBSAVE);
			        }
			        else{
			        	//선택된것만 저장 대상으로 선별한다.
		        		var iCheckRow=sheetObject2.FindCheckedRow("sel");
		        		//가져온 행을 배열로 반든다.
		        		/*alert(iCheckRow);
		        		var arrRow=iCheckRow.split("|");
		        		for(var i=1; i <= sheetObject2.RowCount(); i++){
		        			sheetObject2.SetRowStatus(i,"R");
		        		}
		        		alert(arrRow.length);
		        		for (var idx=0; idx<sheetObject2.RowCount(); idx++){
		        			alert(">>>"+idx);
		        			sheetObject2.SetRowStatus(idx,"U");
		        		}*/
			        	doActionIBSheet(sheetObject2,document.form,IBSAVE);
			        }
				break;
				
				case "btn_t1downexcel":
					if(sheetObject1.RowCount() < 1){//no data
		        	     ComShowCodeMessage("COM132501");
		        	} else{
		        	    	//sheetObject1.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
		        		sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
		        	}
				break;
				
				case "btn_t1cntrlist":
					var formObj = document.form;
					formObj.f_cmd.value = "";
		    		ComOpenWindowCenter("/opuscntr/EES_MST_0055.do?"+ FormQueryString(formObj), "EES_MST_0055", 885, 455);

		    		break;

				case "btn_t2downexcel":
					if(sheetObject2.RowCount() < 1){//no data
		        	     ComShowCodeMessage("COM132501");
		        	} else{
		        		//sheetObject2.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
		        		sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
		        	}
				break;
				
				case "btn_t2cntrlist":
					var formObj=document.form;
					formObj.f_cmd.value="";
		    		ComOpenWindowCenter("/opuscntr/EES_MST_0055.do?"+ FormQueryString(formObj), "EES_MST_0055", 885,455);
					break;
				
				case "btn_Calendar":
					popCalendar('calendarPopup2');
					
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
    
    function t1sheet1_OnSaveEnd(sheetObj , ErrMsg) { 
    	/*var formObject=document.form; 
    	alert("1");
    	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    	alert("2");*/
    }
    
    function t2sheet1_OnSaveEnd(sheetObj , ErrMsg) { 
    	/*var formObject=document.form; 
    	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);*/
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        //탭 초기화하기
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        //IBSheet 초기화하기
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		 // axon_event.addListenerFormat('keydown',	      'obj_keydown',	 form); //- 키 눌렸을때
		 // axon_event.addListenerFormat('keypress',         'obj_keypress',	 form); //- 키 눌렸을때
		 // axon_event.addListenerForm('keydown',	'ComKeyEnter',	    form); //- 키 눌렸을때
		 axon_event.addListenerForm('click', 'obj_click', form); //- 키 눌렸을때
		 document.form.de_yrmon.value="";
		 var formObject=document.form;
		 var today=new Date();
		 if (window.DOMParser){
			if (today.getMonth() < 9){
		    	formObject.de_yrmon.value=String(today.getFullYear())+ "-0" + String(today.getMonth()+1);
		    } else {
		    	formObject.de_yrmon.value=String(today.getFullYear())+ "-" + String(today.getMonth()+1);
		    }
		}else{
			if (today.getMonth() < 9){
				formObject.de_yrmon.value=String(today.getFullYear())+ "-0" + String(today.getMonth()+1);
			} else {
				formObject.de_yrmon.value=String(today.getFullYear())+ "-" + String(today.getMonth()+1);
			}
		}
		    
		 // document.form.de_yrmon.focus();
		 t1sheet1_OnLoadFinish(t1sheet1);
    }
    
    /**
	 * calling event after Load-Finish
	 */
    function t1sheet1_OnLoadFinish(sheetObj) {
		// setting button befor retrieve
		MstComBtnControl(false, "btn_t1cntrlist");
		MstComBtnControl(false, "btn_t2cntrlist");
    }
    
   	//Axon 이벤트 처리2. 이벤트처리함수
  	/**
 	* Key-Change Event 처리
	*/
	function obj_click() {
		var obj_name=ComGetEvent("name");
		var formObj=document.form;
		if (obj_name == "type") {
			if (formObj.type[0].checked == true){
				tabObjects[0].SetSelectedIndex(0);
			} else {
				tabObjects[0].SetSelectedIndex(1);
			}
		}
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
            case "t1sheet1":      // t1sheet1 init
                with(sheetObj){
	              var HeadTitle1="||Lot No.|TP/SZ|S/N Range|ORG Q'ty|Active Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|Spec No.|ORG AGMT No.|ORG Lessor|ORG Lessor Name|Manufacturer|M/Facture Place|Creation Date|Result|A|B|C|D|E";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"lot_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ser_range",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Int",       Hidden:0,  Width:100,   Align:"Right",  ColMerge:0,   SaveName:"act_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_aqz_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:"acct_qty_mzd_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cntr_invst_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	                     {Type:"Popup",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_curr_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center", ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:200,   Align:"Center", ColMerge:0,   SaveName:"org_vndr_lgl_eng_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"lot_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"fa_if_grp_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"fa_if_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lot_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lot_pln_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetColProperty('acct_qty_mzd_cd', {ComboText:acct_qty_mzd_cdText, ComboCode:acct_qty_mzd_cdCode} );
		              SetColProperty(0 ,"cntr_invst_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		             // SetSheetHeight(380);
		              resizeSheet();
              }
            break;
            
            case "t1sheet2":      // t1sheet1 init
                with(sheetObj){
	              var HeadTitle1="||Lot No.|TP/SZ|S/N Range|ORG Q'ty|Active Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|Spec No.|ORG AGMT No.|ORG Lessor|ORG Lessor Name|Manufac turer|M/Facture Place|Creation Date|Result|A|B|C|D|E";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"lot_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ser_range",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cntr_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"act_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_aqz_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:"acct_qty_mzd_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_invst_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_curr_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                    
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"org_vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lot_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"fa_if_grp_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"fa_if_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lot_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lot_pln_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetColProperty('acct_qty_mzd_cd', {ComboText:acct_qty_mzd_cdText, ComboCode:acct_qty_mzd_cdCode} );
		              SetColProperty(0 ,"cntr_invst_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	              SetSheetHeight(150);
              }
            break;
            
            case "t2sheet1":      // t2sheet1 init
                with(sheetObj){
	              var HeadTitle1="||Term Change Seq.|S/N Range|TP/SZ|Active Q'ty|Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|ORG AGMT No.|ORG Lessor|ORG Lessor Name|AGMT No.|Lessor|Lessor Name|Creation Date|Created By|Result|A|B|C";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
	                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"term_cng_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sn_rng",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

	                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"act_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

	                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cntr_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_aqz_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:"acct_qty_mzd_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:0,   SaveName:"cntr_invst_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
	                     {Type:"Popup",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,  SaveName:"org_agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"org_vndr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	                     {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fa_if_grp_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"fa_if_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	              InitColumns(cols);
	              SetEditable(1);
	              SetColProperty('acct_qty_mzd_cd', {ComboText:acct_qty_mzd_cdText, ComboCode:acct_qty_mzd_cdCode} );
		          SetColProperty(0 ,"cntr_invst_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	              SetSheetHeight(380);
              }


                break;
            case "t2sheet2":      // t2sheet1 init
                with(sheetObj){
	              var HeadTitle1="|Sel.|Term Change Seq.|S/N Range|TP/SZ|Active Q'ty|Q'ty|ACQ AMT|Asset Kind|Investment Code|Currency|ORG AGMT No.|ORG Lessor|ORG Lessor Name|AGMT No.|Lessor|Lessor Name|Creation Date|Created By|Result|A|B|C";
	              var headCount=ComCountHeadTitle(HeadTitle1);
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
	                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"term_cng_seq" },
	                    
	                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sn_rng",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

	                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"act_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

	                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cntr_qty",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_aqz_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0, Width:115,  Align:"Center",  ColMerge:0,   SaveName:"acct_qty_mzd_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"GeneralAsset|FinancialLease|DeferredPurchase", ComboCode:"0|1|2"},
	                     {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"cntr_invst_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"org_agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"org_vndr_lgl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
	                     {Type:"Text",      Hidden:1,  Width:670,  Align:"Center",  ColMerge:0,   SaveName:"fa_if_grp_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"fa_if_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	          		InitColumns(cols);
	          		SetEditable(1);
	                SetSheetHeight(150);
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
			        if (formObj.type[0].checked == true)
			            formObj.hid_type.value="0"
			        else
			        	formObj.hid_type.value="1";
			        sheetObj.SetWaitImageVisible(0);
			        ComOpenWait(true);
			        formObj.f_cmd.value=SEARCH;
					if (sheetObj.id == "t1sheet1")
						sheetObj.DoSearch("EES_MST_0017GS.do", FormQueryString(formObj) );
					else if (sheetObj.id == "t2sheet1")
						sheetObj.DoSearch("EES_MST_0017GS.do", FormQueryString(formObj) );
					ComOpenWait(false);
					for (var i=1; i <= sheetObj.RowCount(); i++){
						sheetObj.SetMinimumValue(i, "cntr_aqz_amt",0);
						var grpstscd=sheetObj.GetCellValue(i, "fa_if_grp_sts_cd");
						if (grpstscd == "Sending" || grpstscd == "Completed" || grpstscd == "Error"){
							sheetObj.SetCellEditable(i,"sel",0);
						}
					}
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					 sheetObjects[2].RemoveAll();
					// sheetObjects[3].RemoveAll();
					formObj.f_cmd.value=MULTI;
					if(ComShowCodeConfirm("COM130101")){
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
					    sheetObj.DoSave("EES_MST_0017GS.do", FormQueryString(formObj), -1, false);
					    ComOpenWait(false);
					}
					//doActionIBSheet(sheetObj,document.form,IBSEARCH);
				}
			break;
			
			case IBINSERT:      // 입력
			break;
        }
    }
//   function obj_keypress(){
//        obj=ComGetEvent();
//        if(obj.dataformat == null) return;
//        window.defaultStatus=obj.dataformat;
//        switch(obj.dataformat) {
//            case "ym":
//                if(obj.name=="de_yrmon") ComKeyOnlyNumber(this, "-");
//            break;
//        }
//    }
// 	function obj_keydown() {
// 		var obj=ComGetEvent();
// 		var vKeyCode=event.keyCode;
// 		var formObj=document.form;
// 		if (obj.name == "de_yrmon") {
//	  		if (vKeyCode == 13) {
//			    if (formObj.de_yrmon.value.length < 6) {
//			    	ComShowCodeMessage("MST00001","Delivery Month");
//			      	return;
//			    }
//				sheetObjects[0].RemoveAll();
//				sheetObjects[1].RemoveAll();
//				if (formObj.type[0].checked == true)
//				   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH)
//				else
//				   doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
//	  		}
// 		}
// 	}
    /*
    * Calendar Display
    */
    function popCalendar(type){
    	var formObj=document.form;
        var cal=new ComCalendar();
        cal.setDisplayType('month');
        cal.select(formObj.de_yrmon, "yyyy-MM");
    }
 	/**
	 * Sheet의 OnPopupClick Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[1];
		if ( aryPopupData.length > 0 ) {
			sheetObj.SetCellValue(Row,Col,aryPopupData[0][2]);
		}
	}
	function setPopData_Currency1(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			sheetObj.SetCellValue(Row,Col,aryPopupData[0][2]);
		}
	}
    /**
     * 아이비시트 팝업 클릭시 이벤트
     */
    function t2sheet1_OnPopupClick(sheetObj, Row,Col,Value){
    	 if (sheetObj.ColSaveName(Col) == "cntr_curr_cd"){
    		 var param="cnt_cd=&curr_cd="+sheetObj.GetCellValue(Row,Col)+"&curr_desc=";
        	 ComOpenPopup('/opuscntr/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 700, 450, 'setPopData_Currency', '0,0,1', true, true, Row, "cntr_curr_cd", 1);
    	 }
    }
    function t1sheet1_OnPopupClick(sheetObj, Row,Col,Value){
     	 if (sheetObj.ColSaveName(Col) == "cntr_curr_cd"){
     		 var param="cnt_cd=&curr_cd="+sheetObj.GetCellValue(Row,Col)+"&curr_desc=";
         	 ComOpenPopup('/opuscntr/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 700, 450, 'setPopData_Currency1', '0,0,1', true, true, Row, "cntr_curr_cd", 1);
     	 }
    }
    function t1sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
			var sMsg=ComGetMsg("MST01025", "", "", "");
			ComShowMessage (sMsg);
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        }
    }
    
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj = document.form;
    		MstComBtnControl(false, "btn_t1cntrlist");
    		formObj.term_cng_seq.value = "";
    	}
    }
    
	function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
			case "sel":
				var vt1Check = FindCheckedRow("sel").split("|");
				var vt1CheckCount = 0;
				var vt1LotNo = "";
				
				for(var i=0; i < vt1Check.length; i++) {
					if(vt1Check[i] != "") {
						vt1LotNo += GetCellValue(vt1Check[i], "lot_no") +"|";
						vt1CheckCount++;
					}
				}
				ComSetObjValue(formObj.lot_no,  vt1LotNo.substr(0,vt1LotNo.length -1));
				MstComBtnControl(vt1CheckCount != 0, "btn_t1cntrlist");
			break;

			}
		}
 	}

    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj = document.form;
    		MstComBtnControl(false, "btn_t2cntrlist");
    		formObj.lot_no.value = "";
    	}
    }
    
    function t2sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
			var sMsg=ComGetMsg("MST01025", "", "", "");
			ComShowMessage (sMsg);
			doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
        }
    }
    
	function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "sel":
					var vt2Check=FindCheckedRow("sel").split("|");
					var vt2CheckCount = 0;
					var vt2TermCngSeq = "";
					
					for(var i=0; i < vt2Check.length; i++) {
						if(vt2Check[i] != "") {
							vt2TermCngSeq += GetCellValue(vt2Check[i], "term_cng_seq") +"|";
							vt2CheckCount++;
						}
					}
					ComSetObjValue(formObj.term_cng_seq,  vt2TermCngSeq.substr(0,vt2TermCngSeq.length -1));
					MstComBtnControl(vt2CheckCount != 0, "btn_t2cntrlist");
				break;

			}
		}
 	}
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "OW Master" , "");
                    InsertItem( "Term Change Master" , "");
                }
            break;
        }
        tabObj.SetSelectedIndex(0);
    }
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem){
    	formObject = document.form;
    	
    	if (nItem == "0" && formObject.type[0].checked == false)
    		formObject.type[0].checked = true
    	else if (nItem == "1" && formObject.type[1].checked == false)
    		formObject.type[1].checked = true;
    	
    	var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	for(var i = 0; i< objs.length; i++){
       	  if(i != nItem){
	        	   objs[i].style.display="none";
	        	   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
       	  }
    	}
//    	beforetab=nItem;
//    	var objs = document.all.item("tabLayer");
//      	objs[nItem].style.display="Inline";
//      	objs[beforetab].style.display="none";
//      	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
//      	beforetab=nItem;
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
    function setsheetRowColorBlack1(cnt){
   	 	 var formObj=document.form;
	   	 for (var i=1; i <= 15; i++){
	   		 sheetObjects[2].SetCellFontColor(cnt,i,"#000000");
	   	 }
    }
    function setsheetRowColorBlack2(cnt){
  	 	 var formObj=document.form;
	   	 for (var i=1; i <= 12; i++){
	   		 sheetObjects[3].SetCellFontColor(cnt,i,"#000000");
	   	 }
    }
    function setsheetRowColorRed1(cnt){
	   	 var formObj=document.form;
	   	 for (var i=1; i <= 15; i++){
	   		 sheetObjects[2].SetCellFontColor(cnt,i,"#FF0000");
	   	 }
    }
    function setsheetRowColorRed2(cnt){
	   	 var formObj=document.form;
	   	 for (var i=1; i <= 12; i++){
	   		 heetObjects[3].SetCellFontColor(cnt,i,"#FF0000");
	   	 }
    }
    
	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}