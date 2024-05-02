/*=========================================================
* * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0214.js
*@FileTitle  :  Doc Performance Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author CLT
     */
    /**
     * @extends 
     * @class ESM_BKG_0214 : ESM_BKG_0214 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0214() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.setMainTableObject=setMainTableObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* 개발자 작업	*/
 // 공통전역변수
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var combo1=null;
 var comboCnt=0;
 var mainTableObjects=new Array();
 var mainTableCnt=0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[getActSheetIdx()], formObject, IBSEARCH);
 					break;
				break;
				case "btn_new":
					for(i=0;i<sheetObjects.length;i++){
						sheetObjects[i].RemoveAll();
					}
 					ComResetAll();
 					ComSetObjValue(formObject.fr_dt,ComGetNowInfo());
 			    	ComSetObjValue(formObject.to_dt,ComGetNowInfo());
				break; 
				case "btn_downexcel":
					if (ComGetObjValue(formObject.report_type)=="ofc"){
	            		doActionIBSheet(sheetObjects[getActSheetIdx()],formObject,IBDOWNEXCEL);
	            	}else if (ComGetObjValue(formObject.report_type)=="bl"){
	            		doActionIBSheet(sheetObjects[getActSheetIdx()+1],formObject,IBDOWNEXCEL);
	            	}
				break;
				case "btn_t1office":
					alert(srcName);
				break;				
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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
     function setmainTableObject(mainTable_obj){
       	mainTableObjects[mainTableCnt++]=mainTable_obj;
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
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
         //IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
		    initCombo(comboObjects[k]);
		}
		//B/L List Sheet Table Visible 처리
		
		setSheetVisble(0);
		
        initControl();
 		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
 		setDocUser();
		document.all.item("lbPct").style.display="block";
		document.all.item("lbEta").style.display="none";
		document.all.item("lbGoto1").style.display="none";
		document.all.item("lbGoto2").style.display="none";
     }
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 배열에서 순번
      */
     function initControl() {
     	//** Date 구분자 **/
     	DATE_SEPARATOR="-";
     	var formObject=document.form;
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
//  	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
//     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	combo1=comboObjects[0];
 		comboCnt=comboObjects.length;
 	    ComSetObjValue(formObject.fr_dt,ComGetNowInfo());
    	ComSetObjValue(formObject.to_dt,ComGetNowInfo());    	
     }
     function setSheetVisble(inx){
    	// TABLE
    	for(var k=0; k< mainTable.length; k++){
 		    mainTable[k].style.display="none";
 		}
    	mainTable[inx].style.display="";
    	/* Pre-Auditing 항목만 PCT 항목 숨김 */
//    	if("Pre-Auditing" == tabObjects[0].TabText(inx)){
//    		sheetObjects[7].ColHidden("port_clz_dt") = true;
//    	}
    	/* Pre-Auditing 항목만 PCT 항목 숨김을 해제 하고 ETD, TVVD 사이로 변경 */
    	if("Pre-Auditing" == tabObjects[0].GetTabTitle(inx)){
    		if(sheetObjects[7].SaveNameCol("port_clz_dt") == 12){
    			sheetObjects[7].MoveColumnPos(12,8);
    		}
    	}
    	if("CNEE Code Accuracy" == tabObjects[0].GetTabTitle(inx)){
			document.all.item("lbPct").style.display="none";
			document.all.item("lbEta").style.display="block";
			document.all.item("lbGoto1").style.display="block";
			document.all.item("lbGoto2").style.display="block"; 	
    	} else {
			document.all.item("lbPct").style.display="block";
			document.all.item("lbEta").style.display="none";   
			document.all.item("lbGoto1").style.display="none"; 	
			document.all.item("lbGoto2").style.display="none"; 		
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
 		if (sheetID == 't1sheet1' || sheetID == 't1sheet2' 
       	 || sheetID == 't1sheet3' || sheetID == 't1sheet4' || sheetID == 't1sheet5' 
         || sheetID == 't1sheet6' || sheetID == 't1sheet7' ){
 		    with(sheetObj){
 		       
		 		      var HeadTitle1="||Region|GSO|B.Office|Count|Ratio";
		 		      var headCount=ComCountHeadTitle(HeadTitle1);
		 		      (headCount, 0, 0, true);
		
		 		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		 		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		 		      InitHeaders(headers, info);
		
		 		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
		 		             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Radio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"region",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gso",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ratio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		 		       
		 		      InitColumns(cols);
		 		      SetSheetHeight(320);
		 		      SetEditable(1);
 		            }
                return;
         }
         if ( sheetID == 't1sheet8' 
        	 || sheetID == 't1sheet9' || sheetID == 't1sheet10' || sheetID == 't1sheet11' 
        	 || sheetID == 't1sheet12'|| sheetID == 't1sheet13' || sheetID == 't1sheet14'){
         }else{
        	 return;
         }
         var tabColTitle="";
//         alert(sheetID);
         switch(sheetID) {
         /* 
         	case "t1sheet7":
         		tabColTitle="Contract|ETD";
         		break;
         	case "t1sheet8":
         		tabColTitle="BKG STS|ETD";
         		break;
         	case "t1sheet9":
         		tabColTitle="CNTR|ETD";
         		break;
         	case "t1sheet10":
         		tabColTitle="CNEE|ETD";
         		break;
         	case "t1sheet11":
         		tabColTitle="RATE|ETD";
         		break;
         	case "t1sheet12":
         		tabColTitle="RELEASE|ETA";
         		break;
          */	
        	case "t1sheet8":
         		tabColTitle="CNTR|ETD";
         		break;
         	case "t1sheet9":
         		tabColTitle="CNEE|ETD";
         		break;
         	case "t1sheet10":
         		tabColTitle="RATE|ETD";
         		break;
         	case "t1sheet11":
         		tabColTitle="Pre-Auditing|ETD";
         		break;
        	case "t1sheet12":
         		tabColTitle="Evaluation|ETA";
         		break;
         	case "t1sheet13":
         		tabColTitle="RATE|ETD";
         		break;
         	case "t1sheet14":
         		tabColTitle="RELEASE|ETA";
         		break;
         }		
         with(sheetObj){             
		           var HeadTitle1="";
		           if(sheetID == "t1sheet12"){
		           HeadTitle1="|Seq.|Booking No|B/L No.|B.OFC|S.OFC|"+tabColTitle+"|T.VVD|Lane|POR|POL|POD|BDR|History|Validate Time";
		           } else {
		           HeadTitle1="|Seq.|Booking No|B/L No.|B.OFC|S.OFC|"+tabColTitle+"|T.VVD|Lane|POR|POL|POD|PCT|History|Batch Time";
		           }
		           var headCount=ComCountHeadTitle(HeadTitle1);
		           (headCount, 0, 0, true);
		
		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		           InitHeaders(headers, info);
		
		           var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
		                  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                  {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		                  {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",    ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"bkg_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ob_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"docp_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"port_clz_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"dpcs_smry_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"batch_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		            
		           InitColumns(cols);
		
		           SetEditable(1);
		           SetDataLinkMouse("bkg_no",1);
		           SetColFontUnderline("bkg_no",1);
		           SetSheetHeight(320);
           }
     }
     function getActSheetIdx(){
    	var index=tabObjects[0].GetSelectedIndex()* 2;
    	return index;
     }
     function getClassBlList(){
    	var lsClass; 
    	/* 2011.01.21 유지훈씨 요청 Pre-Auditing 신규 추가 및 Container Confirm, CNEE Code, Rating 여부만 남겨둠 
         * 추후 다시 추가 될 가능성이 있어 삭제 하지 않음 
         */
    	/*
     	if (tabObjects[0].GetSelectedIndex()== 0){
			lsClass="4";
		}else if (tabObjects[0].GetSelectedIndex()== 1){
			lsClass="1";
		}else if (tabObjects[0].GetSelectedIndex()== 2){
			lsClass="6";
		}else if (tabObjects[0].GetSelectedIndex()== 3){
			lsClass="7";
		}else if (tabObjects[0].GetSelectedIndex()== 4){
			lsClass="2";
		}else if (tabObjects[0].GetSelectedIndex()== 5){
			lsClass="3";
		}
		*/
     	if (tabObjects[0].GetSelectedIndex()== 0){
			lsClass="6";
		}else if (tabObjects[0].GetSelectedIndex()== 1){
			lsClass="7";
		}else if (tabObjects[0].GetSelectedIndex()== 2){
			lsClass="2";
		}else if (tabObjects[0].GetSelectedIndex()== 3){
			lsClass="9";
		}else if (tabObjects[0].GetSelectedIndex()== 4){
			lsClass="10";
		}
     	return lsClass;
     }
     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         var lsClass;
         switch(sAction) {
         	case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0214GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) 
					ComXml2ComboItem(arrXml[0], region, "val", "val|val");
				//formObj.region.DropHeight = 150;
//				region.index=0;
				region.SetSelectIndex(-1);
				break;
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
           			formObj.f_cmd.value=SEARCH;
           			ComSetObjValue(formObj.class_type,getClassBlList());
           			sheetObjects[getActSheetIdx()+1].SetWaitImageVisible(0);
           			sheetObjects[getActSheetIdx()].SetWaitImageVisible(0);
           			ComOpenWait(true);  //대기이미지 표시
           			var sXml=sheetObj.GetSearchData("ESM_BKG_0214GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					sheetObjects[getActSheetIdx()].RemoveAll();
					sheetObjects[getActSheetIdx()+1].RemoveAll();
					ComOpenWait(false); //대기이미지 숨김
//					if (arrXml.length > 1) 
//						sheetObjects[getActSheetIdx()+1].LoadSearchXml(arrXml[1]); 
					if (arrXml.length > 0) {
						sheetObjects[getActSheetIdx()].LoadSearchData(arrXml[0],{Sync:1} );
//no support[check again]CLT 						if(sheetObjects[getActSheetIdx()].Rows > 0){
						if(sheetObjects[getActSheetIdx()].SearchRows()>0){
							t1sheet1_OnClick(sheetObjects[getActSheetIdx()], 1, 0, 0);
						}
					}
				}
           		break;
			case IBROWSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
	       			formObj.f_cmd.value=SEARCH01;
	       			ComSetObjValue(formObj.class_type,getClassBlList());
	       			ComOpenWait(true);  //대기이미지 표시
	       			var sXml=sheetObj.GetSearchData("ESM_BKG_0214GS.do", FormQueryString(formObj));
					sheetObjects[getActSheetIdx()+1].RemoveAll();
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) 
						sheetObj.LoadSearchData(arrXml[0],{Sync:1} );
					ComOpenWait(false); //대기이미지 숨김
	          	} 
	       		break;
			case IBDOWNEXCEL:      // 다운로드
				if(sheetObj.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
//					 sheetObj.Down2Excel({ HiddenColumn:{HiddenColumn:-1}});
					 sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					 break;	
				}	
				
   				
         }		
     }
     function gotoCustCodeErrReport(){
	  	var sUrl="/opuscntr/ESM_BKG_0941_POP.do";
	  	sUrl += "?parentPgmNo=ESM_BKG_M001";
	  	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0941.do";
	  	sUrl += "&mainPage=true&pgmNo=ESM_BKG_0941";
		ComOpenWindowCenter(sUrl, "ESM_BKG_0941", 1024, 730, false, 'yes');
     }
 	 function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		if (sheetObj.GetCellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.GetCellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.GetCellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet2_OnClick(sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		if (sheetObj.GetCellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_gso_cd,"");
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.GetCellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.GetCellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet3_OnClick(sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		if (sheetObj.GetCellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.GetCellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.GetCellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet4_OnClick(sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		if (sheetObj.GetCellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.GetCellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.GetCellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet5_OnClick(sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		if (sheetObj.GetCellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.GetCellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.GetCellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet6_OnClick(sheetObj, Row, Col, Value) {
 		var formObj=document.form;
 		if (sheetObj.GetCellValue(Row, "bkg_ofc_cd") != ''){
 			ComSetObjValue(formObj.sel_bkg_ofc_cd,sheetObj.GetCellValue(Row, "bkg_ofc_cd"));
 			ComSetObjValue(formObj.sel_gso_cd,sheetObj.GetCellValue(Row, "gso"));
 			doActionIBSheet(sheetObjects[getActSheetIdx()+1], formObj, IBROWSEARCH);
 		}
 	 }
 	function t1sheet7_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet8_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet9_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet10_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet11_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet12_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet13_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName=sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(rowIdx, colName));
 		}
  	}
 	function t1sheet7_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");
  	}
 	function t1sheet8_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet9_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet10_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet11_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");	 
  	}
 	function t1sheet12_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no"); 
  	}
 	function t1sheet13_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no"); 
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
                     /* 2011.01.21 유지훈씨 요청 Pre-Auditing 신규 추가 및 Container Confirm, CNEE Code, Rating 여부만 남겨둠 
                      * 추후 다시 추가 될 가능성이 있어 삭제 하지 않음 
                      */
                     /*
InsertItem( "Contract No" , "");
                     //InsertTab( cnt++ , "TRO Confirm" , -1 );
InsertItem( "Booking Clearance" , "");
InsertItem( "Container Confirm" , "");
InsertItem( "CNEE Code" , "");
InsertItem( "Rating" , "");
InsertItem( "B/L Release" , "");
                     */
                     InsertItem( "Container Confirm" , "");
                     InsertItem( "CNEE Code" , "");
                     InsertItem( "Rating" , "");
                     InsertItem( "Pre-Auditing", "");
                     InsertItem( "CNEE Code Accuracy", "");
                 }
              break;
          }
     }
     function tab1_OnClick(tabObj, nItem){
    	 setSheetVisble(nItem);
    	 //doActionIBSheet(sheetObjects[nItem+8],document.form,IBROWSEARCH);
     }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
          	switch(sAction) {
 		     	case IBSEARCH: // 조회시 확인
 			  		if (!ComChkValid(formObj)) return false;
 			  		/*if (ComGetObjValue(formObj.search_opt) == "A" 
 			  			&& ComGetObjValue(formObj.bkg_ofc_cd) == "" 
						&& ComGetObjValue(formObj.ob_sls_ofc_cd)=="" 
							&& ComGetObjValue(formObj.gso)=="" ) {
 			  			ComShowCodeMessage('BKG00626', '\n\n[GSO,Booking Office,Sales Office] , One must have value');
 			  			return false;
 			  		}*/
 			  		if (!ComIsNull(formObj.fr_dt)&& !ComIsNull(formObj.to_dt)&& ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 31){  			  			  			  			
	         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
	         			formObj.fr_dt.focus();
	         			return false;
	         		}
// 			  		if(ComGetObjValue(formObj.fr_dt).substring(0,4)!= ComGetObjValue(formObj.to_dt).substring(0,4)&& getClassBlList() == "9"){  			  				 	 			  			
////	         			ComShowCodeMessage("BKG08250");//Pre-audit data for 2012 and 2013 cannot be searched together due to different evaluation logic.
//	         			alert("Pre-audit data for 2012 and 2013 cannot be searched together due to different evaluation logic.");
//	         			
//	         			formObj.fr_dt.focus();
//	         			return false;
// 			  		} 
// 			  		if(ComGetObjValue(formObj.fr_dt).substring(0,4) != "2013"&& getClassBlList() == "10"){ 			  			
////	         			ComShowCodeMessage("BKG08251");//Invalid ETA. Please insert the ETA from “2013-01-01
//	         			alert("Invalid ETA. Please insert the ETA from “2013-01-01");
//	         			formObj.fr_dt.focus();
//	         			return false;			  			
// 			  		}
 			  		break; 
          	}	
          }		
          return true;
     }
     /**
	  * 콤보 초기설정값
	  * @param {IBMultiCombo} comboObj  comboObj
	  */
	  function initCombo(comboObj) {
	  	comboObj.SetDropHeight(500);
	  	SetMaxSelect(0);
	  }  
	/**
	* from,to 기간 선택 달력 띄우기
	*/
	function callDatePop(val){
		var cal=new ComCalendarFromTo();
		if (val == 'BKG_DATE'){
		cal.select(form.fr_dt,  form.to_dt,  'yyyy-MM-dd');
		}
	}
	/**
     * 조회조건에 Search Key required clear
     */
	function clearKeyRequired(){
		var formObject=document.form;
		formObject.fr_dt.required=null;
		formObject.fr_dt.className="input";
		formObject.to_dt.required=null;
		formObject.to_dt.className="input";
		formObject.vvd_cd.required=null;
		formObject.vvd_cd.className="input";
		formObject.pol_cd.required=null;
		formObject.pol_cd.className="input";
		formObject.bkg_ofc_cd.required=null;
		formObject.bkg_ofc_cd.className="input";
		formObject.ob_sls_ofc_cd.required=null;
		formObject.ob_sls_ofc_cd.className="input";
		formObject.gso.required=null;
		formObject.gso.className="input";
		region.required=null;
		region.SetBackColor("#FFFFFF" );//"#ffffff";
//		region.SetBackColor("255,255,255" );//"#ffffff";
	}
	/**
     * 조회조건에 따른 Search Key 변경
     */
  	function setSchKey(val){
  		var formObject=document.form;
  		clearKeyRequired();
  		if (val == "A"){
			formObject.fr_dt.required=true;
			formObject.fr_dt.className="input1";
			formObject.to_dt.required=true;
			formObject.to_dt.className="input1";
			formObject.bkg_ofc_cd.className="input1";
			formObject.ob_sls_ofc_cd.className="input1";
			formObject.gso.className="input1";
			//formObject.region.className = "input1";
			region.SetBackColor("#CCFFFD");
				//formObject.region.required = true;
  		}else if (val == "B"){
  			formObject.vvd_cd.required=true;
			formObject.vvd_cd.className="input1";
  			formObject.pol_cd.required=true;
			formObject.pol_cd.className="input1";
  		}else if (val == "C"){
  			formObject.fr_dt.required=true;
			formObject.fr_dt.className="input1";
			formObject.to_dt.required=true;
			formObject.to_dt.className="input1";
			formObject.pol_cd.required=true;
			formObject.pol_cd.className="input1";
  		}
  	}
     /*
      * Login 한  User Check  
      */
    function setDocUser(){
    	var input_text="";
     	var output_text="";
     	try{
		 		var param=param + "&f_cmd=" + SEARCH08 + "&input_text=" + input_text;
		 		var sXml=sheetObjects[1].GetSearchData("ESM_Booking_UtilGS.do", param);
		 		output_text=ComGetEtcData(sXml, "output_text");
    		if ('Y' == output_text) {
    			for(i=1;i<sheetObjects.length;i++){
    				sheetObjects[i].SetColHidden("port_clz_dt",0);
        			sheetObjects[i].SetColHidden("dpcs_smry_rmk",0);
        			sheetObjects[i].SetColHidden("batch_dt",0);
    			}
    		}else{
    			for(i=1;i<sheetObjects.length;i++){
	    			sheetObjects[1].SetColHidden("port_clz_dt",1);
	    			sheetObjects[1].SetColHidden("dpcs_smry_rmk",1);
	    			sheetObjects[1].SetColHidden("batch_dt",1);
    			}
    		}
    	} catch (ex) {
    		ComShowCodeMessage("COM12111");
    		return false;
    	}
    }
/*
  	 function obj_deactivate(){
  	     ComChkObjValid(event.srcElement);   // 포커스 나갈때 기간체크도 실시함..
  	 }
  	 function obj_activate(){
  	     ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기..
  	 }*/
	/* 개발자 작업  끝 */
 