/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_BKG_1057.js
*@FileTitle : Freight & Charge List by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
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
     * @class ESM_BKG_1057 : ESM_BKG_1057 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    
   	/* 개발자 작업	*/
 // 공통전역변수
 var rdObjects=new Array();
 var rdCnt=0;    
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1; 
 var sheetObjects=new Array();
 var sheetCnt=0;
 var tabItem=0; 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick=processButtonClick;
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject1=sheetObjects[0];
 		         var sheetObject2=sheetObjects[1];
 		         var objs=document.all.item("tabLayer");
 		         var tab1Status=objs[1].style.display;
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
				case "btn_retrieve":
				//  Actual VVD 는 Grid로 조회 안됨
						if(formObject.vvd_chk[1].checked == true){
							 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}else{
							/* Grid 항목만 조회 */
							if(tabItem == 0){
								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
 				  		    	var sheetObj=sheetObjects[0];
 				  		  		var formObj=document.form;
 				  		     	var vsl_cd=formObj.vvd_cd.value.substring(0,4);
 				  		     	var skd_voy_no=formObj.vvd_cd.value.substring(4,8);
 				  		     	var skd_dir_cd=formObj.vvd_cd.value.substring(8);
							}
							/* report 항목만 조회 */
							else{
 				  		    	var sheetObj=sheetObjects[0];
 				  		  		var formObj=document.form;
 				  		     	var vsl_cd=formObj.vvd_cd.value.substring(0,4);
 				  		     	var skd_voy_no=formObj.vvd_cd.value.substring(4,8);
 				  		     	var skd_dir_cd=formObj.vvd_cd.value.substring(8);
 				  		     	var rdPath="apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_1057.mrd";
 				  		     	var option="";
 				  		     	var where="";
 				  		     	if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
 				  		     	option="OPTION[VVD-" + formObj.vvd_cd.value + "/POL-" + formObj.pol_cd.value;
 				  		     	where=" vsl_cd"+"["+ vsl_cd +"] "+"skd_voy_no"+"["+skd_voy_no+"] "+"skd_dir_cd"+"["+ skd_dir_cd +"] "
 				  		     	if (formObj.pol_cd.value !=""){
 				  		     		option=option + "/POL_-" + formObj.pol_cd.value;
 				  		     		where=where + "pol_cd" +"["+ formObj.pol_cd.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "pol_cd[] ";
 				  		     	}
 				  		     	if (formObj.pod_cd.value !=""){
 				  		     		option=option + "/POD_-" + formObj.pod_cd.value;
 				  		     		where=where + "POD_CD" +"["+  formObj.pod_cd.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "pod_cd[] ";
 				  		     	}
 				  		     	if (formObj.por_cd.value !=""){
 				  		     		option=option + "/POR_-" + formObj.por_cd.value;
 				  		     		where=where + "POR_CD" +"["+ formObj.por_cd.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "por_cd[] ";
 				  		     	}
 				  		     	if (formObj.del_cd.value !=""){
 				  		     		option=option +"/DEL_-" + formObj.del_cd.value;
 				  		     		where=where + "DEL_CD" +"["+ formObj.del_cd.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "del_cd[] ";
 				  		     	}
 				  		     	if (formObj.sls_ofc.value !=""){
 				  		     		option=option + "BKG_OFC-" + formObj.sls_ofc.value;
 				  		     		where=where + "OB_SLS_OFC_CD" +"["+ formObj.sls_ofc.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "ob_sls_ofc_cd[] ";
 				  		     	}
 				  		     	if (formObj.bkg_ofc.value !=""){
 				  		     		option=option + "Sales_OFC-" + formObj.bkg_ofc.value;
 				  		     		where=where + "BKG_OFC_CD" +"["+formObj.bkg_ofc.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "bkg_ofc_cd[] ";
 				  		     	}
 				  		     	if (formObj.trd_cd.value !=""){
 				  		     		option=option + "Trade-" + formObj.trd_cd.value;
 				  		     		where=where + "REV_DIR_CD" +"["+formObj.trd_cd.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "rev_dir_cd[] ";
 				  		     	}
 				  		     	if (formObj.sc_no.value !=""){
 				  		     		option=option + "SC_NO-" + formObj.sc_no.value;
 				  		     		where=where + "SC_NO" +"["+formObj.sc_no.value+"] " ;
 				  		     	}else{
 				  		     		where=where + "sc_no[] ";
 				  		     	}
//			 				  		     	formObj.com_mrdArguments.value 	= "/rv " + where;
//			 				  		     	formObj.com_mrdTitle.value = "Freight &amp; Charge List by VVD";
//			 				  		     	formObj.com_mrdBodyTitle.value = "<span style='color:red'>Freight &amp; Charge List by VVD</span>";
//			 				  				var xmldata = "<?xml version=\"1.0\" encoding=\"euc-kr\"?><root><startdate>20080101</startdate><enddate>20081231</enddate><today>20090113</today><table1>	<a>		<a1>100 </a1>		<a2> 200</a2>		<a3>300 </a3>		<a4>400 </a4>		<a5>500 </a5>	</a></table1></root>";
 				  				var mrdpath=RD_path + "apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_1057.mrd";
 				  				viewer.openFile(mrdpath, RDServer + "/rv " + where, {timeout:1800});
							}
						}
// 				  		    	 }
				break; 
				case "btn_new":
					ComResetAll();
					formObject.pol_cd.required=false;
					formObject.pol_cd.className="input";
					formObject.pod_cd.required=false;
					formObject.pod_cd.className="input"; 
				break;
				case "btn_excel":
					if(tabItem == 0){
					/* Header 머지 부분을 삭제하고 Excel을 피벗할수 있도록 수정하여 ExcelDown 한다 2010.04.28 김태경 */
						for (var i=sheetObjects[1].LastRow(); i >= sheetObjects[1].HeaderRows(); i--){
							if(ComIsEmpty(sheetObjects[1].GetCellValue(i,"pod_cd"))){
								sheetObjects[1].RowDelete(i,false);
							}
						}
						if(sheetObject2.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
						}else{
							sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:0 });
						}								
					}
				break;
				case "btn_print":
					if (tabItem == 1){
						if (tab1Status == "inline") {
							viewer.print({isServerSide:true}); // 인쇄 대화상자 띄움
						} else {
							return false;
						}
					}
					break;
					 //go_Print();
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
        sheetObjects[sheetCnt++]=sheet_obj;
     }
      /**
       * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
       * 상단에 정의
       */
       function setTabObject(tab_obj) {
    		tabObjects[tabCnt++]=tab_obj;
    	}
      /**
       * Tab 기본 설정 탭의 항목을 설정한다.
       */
       function initTab(tabObj, tabNo) {
    		switch (tabNo) {
    		case 1:
    			with (tabObj) {
    				var cnt=0;
					InsertItem( "Grid", "");
					InsertItem( "Report", "");
    			}
    			break
    		}
    	}
       function tab1_OnChange(tabObj, nItem) {
          	var objs=document.all.item("tabLayer");
          	var formObj=document.form;
          	objs[nItem].style.display="Inline";
          	objs[beforetab].style.display="none";
          	// --------------- 요기가 중요 --------------------------//
          	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
          	// ------------------------------------------------------//
           tabItem=nItem;
           if(formObj.vvd_chk[1].checked == true){
        	   objs[0].style.display="Inline";
              	objs[1].style.display="none";
           }else if (formObj.vvd_chk[0].chekced == true){
        	   //아무 작업 하지 않음
           }
          	// tab Index는 0 부터 시작 함
          	// 첫번째 tab = "청구서" 인 경우 수정 된 내용을 업데이트 해준다
          	// ??? sheet1_OnAfterEdit는 없애도 될 듯 하다. 좀 지켜 보자. ^^
          	beforetab=nItem;
          }
       /**
        * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
        * 추가한다
        */
        function loadPage() {
        	// TAB 생성
        	for (k=0; k < tabObjects.length; k++) {
        		initTab(tabObjects[k], k + 1);        		
        	}
        	// IBSHEET 생성
        	for (i=0; i < sheetObjects.length; i++) {
        		ComConfigSheet(sheetObjects[i]);
        		initSheet(sheetObjects[i], i + 1);
        		ComEndConfigSheet(sheetObjects[i]);
        	}  
        	tabObjects[0].SetSelectedIndex(0);
        	initControl();
        }

      function initControl() {
    	  /* KEY PRESS 입력 받아 변환 */
    	  //** Date 구분자 **/
    	  DATE_SEPARATOR="-";
    	  var formObject=document.form;
    	  	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
    	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
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
                
                 var HeadTitle1="Seq.|CHG TP|Rated As|Rate|Per|CUR|Amount|P/C|Pay OFC.|S/C No.|RFA No.|Tariff No.|Shipper Name|Consignee Name|Customs Description|CMDT|Commodity Description|REP CMDT|REP Commodity Description";

	             SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chg_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rated_as",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rate",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"per",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cur",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"amount",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pay_ofc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tariff_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"shpr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cnee_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cmdt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0, Width:155,  Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rt_aply_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                  {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	               
	              InitColumns(cols);	
	              SetEditable(0);	           
	              SetSheetHeight(450);	
	              SetCountPosition(0);
             	}
                 break;
                 case "sheet2":      //sheet2 init
                     with(sheetObj){
                                 
	                  var HeadTitle1="Seq.|BKG No|Trade|POR|POL|POD|DEL|RD|DT|APPLY_Date|CHG TP|Rated As|Rate|Per|CUR|Amount|P/C|Pay OFC.|S/C No.|RFA No.|Tariff No.|Shipper Name|Consignee Name|Customs Description|CMDT|Commodity Description|REP CMDT|REP Commodity Description";
	
	                  SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                  InitHeaders(headers, info);
	
	                  var cols = [ {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rt_aply_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"chg_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rated_as",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rate",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"per",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cur",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"amount",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pay_ofc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tariff_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"shpr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cnee_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cmdt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rep_cmdt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rt_aply_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                      {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                   
	                  InitColumns(cols);	
	                  SetEditable(1);
	                  SetVisible(false);
                      }
	             break;
         }
     }
     
     function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	 if (sheetObj.RowCount() > 0)
    		 sheetObj.SetMergeCell(1, 1, 1, 20);
     }
     
     function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	 if (sheetObj.RowCount() > 0)
    		 sheetObj.SetMergeCell(1, 1, 1, 20);
     }
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 					case IBSEARCH:      //조회
 						if(!validateForm(sheetObj,formObj,sAction)) return;	
 							formObj.f_cmd.value=SEARCH;
 							sheetObj.SetWaitImageVisible(0);
 							ComOpenWait(true); // 대기창 보임
 							var sXml=sheetObj.GetSearchData("ESM_BKG_1057GS.do",FormQueryString(formObj));
							var arrXml=sXml.split("|$$|");
							for ( var inx=0; inx < arrXml.length; inx++) {
								sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
							}
// 								formObj.f_cmd.value = SEARCH;
// 								sheetObj.DoSearch("ESM_BKG_1057GS.do",FormQueryString(formObj));
 					break;
 					case IBSAVE:        //저장
 						if(validateForm(sheetObj,formObj,sAction))
 							alert (" Save .. ");
 					break;
 					case IBINSERT:      // 입력
 					break;
         }
         ComOpenWait(false); // 대기창 보임
     }     

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
          var formObj=document.form;
    	  switch(sAction){
    	  case IBSEARCH:
    		if(ComIsNull(formObj.vvd_cd)){
    			ComShowCodeMessage('BKG00161');
    			formObj.vvd_cd.focus();
    			return false; 		
    		}else if((formObj.vvd_chk[1].checked == true) && (ComIsNull(formObj.pol_cd) && ComIsNull(formObj.pod_cd))){
    				ComShowCodeMessage('BKG00231');
    				formObj.pol_cd.focus();
    				return false;
    		}  	  
    	  }
    	  return true;
     } 
    function setSchKey(val){ //Mandantory 항목 표시
    	var formObj=document.form;
    	if(val =='T'){
//    		tab1_OnChange(tabObjects,tabItem);
    		formObj.pol_cd.required=false;
    		formObj.pol_cd.className="input";
    		formObj.pod_cd.required=false;
    		formObj.pod_cd.className="input"; 		
    	}else if(val =='A'){
    		tab1_OnChange(tabObjects,tabItem);
    		formObj.pol_cd.required=true;
    		formObj.pol_cd.className="input1";
    		formObj.pod_cd.required=true;
    		formObj.pod_cd.className="input1";
    	}
    }
//    function changeTab(nItem){ 
//   	 
//    	
//   	 tabObjects[0].SelectedIndex = nItem;
//   	 
//    }
    //PRINT >>> Call RD
    function go_Print(){ 
 		var sheetObj=sheetObjects[0];
 		var formObj=document.form;
    	var vsl_cd=formObj.vvd_cd.value.substring(0,4);
    	var skd_voy_no=formObj.vvd_cd.value.substring(4,8);
    	var skd_dir_cd=formObj.vvd_cd.value.substring(8);
    	var rdPath="apps/opus/esm/bkg/bookingreport/performancereport/report/ESM_BKG_1057.mrd";
    	var option="";
    	var where="";
    	if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
    	option="OPTION[VVD-" + formObj.vvd_cd.value + "/POL-" + formObj.pol_cd.value;
    	where=" vsl_cd"+"["+ vsl_cd +"] "+"skd_voy_no"+"["+skd_voy_no+"] "+"skd_dir_cd"+"["+ skd_dir_cd +"] "
    	if (formObj.pol_cd.value !=""){
    		option=option + "/POL_-" + formObj.pol_cd.value;
    		where=where + "pol_cd" +"["+ formObj.pol_cd.value+"] " ;
    	}else{
    		where=where + "pol_cd[] ";
    	}
    	if (formObj.pod_cd.value !=""){
    		option=option + "/POD_-" + formObj.pod_cd.value;
    		where=where + "POD_CD" +"["+  formObj.pod_cd.value+"] " ;
    	}else{
    		where=where + "pod_cd[] ";
    	}
    	if (formObj.por_cd.value !=""){
    		option=option + "/POR_-" + formObj.por_cd.value;
    		where=where + "POR_CD" +"["+ formObj.por_cd.value+"] " ;
    	}else{
    		where=where + "por_cd[] ";
    	}
    	if (formObj.del_cd.value !=""){
    		option=option +"/DEL_-" + formObj.del_cd.value;
    		where=where + "DEL_CD" +"["+ formObj.del_cd.value+"] " ;
    	}else{
    		where=where + "del_cd[] ";
    	}
    	if (formObj.sls_ofc.value !=""){
    		option=option + "BKG_OFC-" + formObj.sls_ofc.value;
    		where=where + "OB_SLS_OFC_CD" +"["+ formObj.sls_ofc.value+"] " ;
    	}else{
    		where=where + "ob_sls_ofc_cd[] ";
    	}
    	if (formObj.bkg_ofc.value !=""){
    		option=option + "Sales_OFC-" + formObj.bkg_ofc.value;
    		where=where + "BKG_OFC_CD" +"["+formObj.bkg_ofc.value+"] " ;
    	}else{
    		where=where + "bkg_ofc_cd[] ";
    	}
    	if (formObj.trd_cd.value !=""){
    		option=option + "Trade-" + formObj.trd_cd.value;
    		where=where + "REV_DIR_CD" +"["+formObj.trd_cd.value+"] " ;
    	}else{
    		where=where + "rev_dir_cd[] ";
    	}
//    	option = option + "]";
//    	where = where + "]";
//    	alert("/rv " + where);
    	formObj.com_mrdPath.value=rdPath;
//    	/rv vsl_cd[CBRI] skd_voy_no[0035] skd_dir_cd[E] pol_cd[CNHKG] pod_cd[USLGB] por_cd[] del_cd[] ob_sls_ofc_cd[] bkg_ofc_cd[] rev_dir_cd[]
    	formObj.com_mrdArguments.value="/rv " + where;
    	formObj.com_mrdTitle.value="Freight &amp; Charge List by VVD";
    	formObj.com_mrdBodyTitle.value="<span style='color:red'>Freight &amp; Charge List by VVD</span>";
    	ComOpenRDPopup();
    }
     /* 2010.02.02 version 1.0 */
	/* 개발자 작업  끝 */
