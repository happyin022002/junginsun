/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0010.js
*@FileTitle  : Customer Code grouping
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업	*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//  버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var formObj=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    		case "btn_Sales_Office":	//////////////////////////////////////////////////////
    			var dispaly='1,0,1,1,1,1,1,1,1,1,1,1';
				var classId="COM_ENS_071";
				var param='?classId='+classId;
				var chkStr=dispaly.substring(0,3);
				// radio PopUp
				if(chkStr == "1,0") {
					//ComOpenPopup('/opuscntr/COM_ENS_071.do' + param,  770,  450, 'getCOM_ENS_071_ofc_cd', dispaly, true);
					var locSalesOffice=formObj.ofc_cd.value;
					locSalesOffice="";
					var sUrl="COM_ENS_071.do?ofc_cd=" + locSalesOffice +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 615, "getCOM_ENS_071_ofc_cd", "0,0", true);
				} else {
					//ComShowMessage(ComGetMsg('TES10004')); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
					return;
				}
    			break;
    		case "btn_Group_Code":	//////////////////////////////////////////////////
    			var dispaly='0,0';//'1,1,1,1,1,1,1,1,1,1,1,1';
				var classId="ESM_SAM_0903";
				var locOfcCd=formObj.ofc_cd.value;
				var locCustGrpId=formObj.cust_grp_id.value;
//				var param='?classId='+classId+'&cust_grp_id='+locCustGrpId+'&ofc_cd='+locOfcCd;	
//				ComOpenPopup('ESM_SAM_0903_POP.do' + param,  789,  465, 'getGroupCode', dispaly, true);
				var param='?classId='+classId+'&cust_grp_id='+locCustGrpId+'&ofc_cd='+locOfcCd;				
				ComOpenPopup('ESM_SAM_0903_POP.do' + param,  850,  450, 'getGroupCode', dispaly, true);
    			break;
    		case "btn_Srep_Cd_Pop":	//////////////////////////////////////////////////
//    			var dispaly = "0,1,1,1,1,1,1,1,1,1";    // Row PopUp
// 	    		var classId = "ESM_SAM_0005";
// 	     	    var sheet = "0";
// 	     	    //var row = sheetObjects[3].SelectRow
// 	     	    var pOfcCd = formObj.ofc_cd.value;
// 	     	    var param = '?sheet='+sheet+'&classId='+classId+'&opn=5' + "&ofc_cd=" + pOfcCd;
// 	  			//ComOpenPopup('ESM_SAM_0005.do' + param, 1000, 600, 'getsrepflg', dispaly, true, false);  
// 	     	    ComOpenPopup('ESM_SAM_0005.do' + param, 1000, 600, 'getsrepflg', "1,0", true);
 	     	    var sUrl="/opuscntr/COM_COM_0008.do?srep_cd=" + formObj.srep_cd.value + '&mdm_yn=Y&delt_flg=N'; //20130528 공통팝업으로 변경
// 	     	    2014.07.31 김용습 - 팝업창 크기 조절
 	     	    var rVal=ComOpenPopup(sUrl, 770, 405, "getsrepflg", "1,0,1", true);
    			break;
    		
//    		2014.07.30 김용습 - 달력 스타일 바꿈
//    		case "btn_Calendar1":
//				var cal=new ComCalendar();
//				cal.select(formObj.str_cre_dt, 'yyyy-MM-dd');
//            	break;
//    		case "btn_Calendar2":
//				var cal=new ComCalendar();
//				cal.select(formObj.end_cre_dt, 'yyyy-MM-dd');
//            	break;	            	
    		case "btn_Calendar":
                var cal=new ComCalendarFromTo();
                cal.select(formObj.str_cre_dt, formObj.end_cre_dt, 'yyyy-MM-dd');
                break;                
                
    		case "btn_retrieve":
    			sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
    			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    			// 강제로 값을 세팅 한다. OpnPg = 0010 
    			var locCount=sheetObjects[0].RowCount();
    			for(var i=1 ; i<=locCount ; i++ ){
    				sheetObjects[0].SetCellValue(i,"opn_pg",'0010');
    			}
    			break;
    		case "btn_New":
    			sheetObjects[0].RemoveAll();
    			sheetObjects[1].RemoveAll();
    			formObj.reset();
    			break;
    		case "btn_Group_Code_Assign":
    			var countTot=sheetObjects[0].RowCount();
    			if(countTot == null || countTot == '' ||countTot < 1 ){ 
    				ComShowCodeMessage("SAM00001", "row","data"); 
    				return;
    			}
    			// 체크 여부
    			var locChecked=0;
    			for( i=1 ; i<=sheetObjects[0].RowCount(); i++ ){
    				if(sheetObjects[0].GetCellValue(i,1) == '1'){
    					locChecked++;
    				}
    			}
    			if(locChecked < 1){
    				ComShowCodeMessage("COM12113","customer."); //msgs['COM12113']='Please select {?msg1}';
					return;					
    			}
    			var dispaly='1,0,1,1,1,1,1,1,1,1,1,1';
				var classId="ESM_SAM_0902";
				var param='?classId='+classId+'&cust_grp_id='+document.form.cust_grp_id.value;
				var chkStr=dispaly.substring(0,3);
//				2014.07.31 김용습 - 팡업창 크기 조절
				ComOpenPopup('ESM_SAM_0902.do' + param,  470,  200, '', dispaly, true);//팝업에서 본 화면의 OnColChange function을 직접 호출해줌
    			break;
    		case "btn_Save":
    			doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
    			break;
    		case "btn_Excel":
    			doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
    			break;
//    		case "btn_Direct":
    		case "btn_DownExcel":	
//    			doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
//저장이 아닌 download로 변경. 2013-05-24 (타화면과 통일성을 위해)
				if(sheetObjects[1].RowCount()> 0 ){
					sheetObjects[1].Down2Excel( 
//							{DownCols: makeHiddenSkipCol(					sheetObjects[1]), SheetDesign:1,Merge:1 }
							{ HiddenColumn:0, SheetDesign:1,CheckBoxOnValue:'Y', CheckBoxOffValue:' '}
					);
				} else {
					ComShowCodeMessage("COM132501");
				}
    			break;
    		}
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * ESM_SAM_0005 : Coverage Tab의 Srep_cd 정보를 가져오는 Function
     * @author 박찬민
     * @version 2011.06.02
     * 현재 팝업 미완성으로 Function 미완성 
     */
    function getsrepflg(rowArray, row, col) {
   	    var sheetObj=sheetObjects[0];
   		var colArray=rowArray[0];
   		document.form.srep_cd.value=colArray[2];
    }
/**
 * IBSheet Object를 배열로 등록, IBMulti Combo Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 이창원
 * @version 2011.05.21
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
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
    * @author 이창원
	* @version 2011.05.21
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		//IBMultiCombo초기화
		for(var k=0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
		initControl();
		checkUserCodeName();
	}
	function initControl(){
		var formObj=document.form;
		axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
    	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form); 
    	axon_event.addListenerForm('change', 'obj_change', form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
     * User Auth 확인<br>
     * <br><b>Example :</b>
     * <pre>
     *     촏차
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author SHKIM
     * @version 2012.02.13
     */
    function checkUserCodeName() {   
    	var formObject=document.form;
	   	var sheetObject1=sheetObjects[0];
	   	if(formObject.usr_id.value.length>0){
   	 		var userAuth=checkUserAuth(formObject,sheetObject1);
	        //if(userAuth == 'SAM01'){ // SAM01
	        	formObject.ofc_cd.readOnly=false;		//Sales Office - ofc_cd, Sales Rep - srep_cd
	        	formObject.ofc_cd.setAttribute("className","input");
//	        	var btn_Sales_Office_s=document.getElementById("btn_Sales_Office_s");
//	        	btn_Sales_Office_s.style.display="block";
	        	$('#btn_Sales_Office').show();
	        	formObject.srep_cd.readOnly=false;
	        	formObject.srep_cd.setAttribute("className","input");
//	        	var btn_Srep_Cd_Pop_s=document.getElementById("btn_Srep_Cd_Pop_s");
//	        	btn_Srep_Cd_Pop_s.style.display="block";
	        	$('#btn_Srep_Cd_Pop').show();
	        //}else{
	        	//formObject.ofc_cd.readOnly 	=  true;		//Sales Office - ofc_cd, Sales Rep - srep_cd
	        	//formObject.ofc_cd.setAttribute("className","input2");
	        	//var btn_Sales_Office_s = document.getElementById("btn_Sales_Office_s");
	        	//btn_Sales_Office_s.style.display = "none";
	        	//formObject.srep_cd.readOnly =  true;	//Sales Office - ofc_cd, Sales Rep - srep_cd
	        	//formObject.srep_cd.setAttribute("className","input2");
	        	//var btn_Srep_Cd_Pop_s = document.getElementById("btn_Srep_Cd_Pop_s");
	        	//btn_Srep_Cd_Pop_s.style.display = "none";	
	        //}
   	 	}
    }
    /**
     * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, gb);
     * </pre>
     * @param  {form} obj 필수 Html Object
     * @param  {bool} gb  필수 true : 활성화 false : 비활성화
     * @return 없음
     * @author SHKIM
     * @version 2012.02.21
     */ 
     function btnImgEnable(obj, gb) {
         if(obj.constructor == String){
             obj=document.getElementsByName(obj)[0];        
         }
         var btnStyle=obj.style;
         if (gb){
             obj.SetEnable(1);
             btnStyle.cursor="hand";
             btnStyle.filter="";
             obj.disabled=false;
         } else {
             obj.SetEnable(0);
             btnStyle.cursor="auto";
             btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
             obj.disabled=true;
         }
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
	 * @author shkim
	 * @version 2012.02.28
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		        var HeadTitle="|SEL|Cust. Code|Customer Name|Group ID|Abbreviation|Location|Pri. S.Rep.|Sales Office|Last Update|Cust. Seq|Cust Cnt Cd|Opn Pg " ;
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               
//		               2014.08.13 김용습 - 'Too many letters or numbers.' 오류 해결 법 -> 맨 오른쪽 끝 EditLen 부분 삭제
//		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},		               
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_abbr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"srep_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"opn_pg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(1);
		        SetColProperty(0 ,"cust_grp_id", {AcceptKeys:"E|N|[- ]"});
		        SetSheetHeight(440);
		        resizeSheet();
			}
			break;
		case 2:
			with (sheetObj) {
		        var HeadTitle="|SEL|CUSTOMER CODE|CUSTOMER SEQUENCE|CONTAINER DIVISION FLAG|BULK DIVISION FLAG|CUSTOMER GROUP ID|CUSTOMER LEGAL ENGLISH NAME|CUSTOMER LOCAL LANGUAGE NAME|CUSTOMER ABBREVIATION NAME|REVISION CONTAINER CUSTOMER TYPE CODE|BULK CUSTOMER TYPE CODE|INDIVIDUAL CORPORATION DIVISION CODE|OFFICE CODE|FOUNDATION DATE|CUSTOMER REGISTER NUMBER|FINANCE STATUS LEVEL CODE|LOCATION CODE|CAPITAL CURRENCY CODE|CAPITAL AMOUNT|LISTED STOCK FLAG|EMPLOYEE COUNT|VENDOR SEQUENCE|CUSTOMER REMARK|VALUE BASE SEGMENTATION CLASS CODE|NEEDS BASE SEGMENTATION CLASS CODE1|NEEDS BASE SEGMENTATION CLASS CODE2|NEEDS BASE SEGMENTATION CLASS CODE3|CUSTOMER STATUS CODE|CRM ROW ID|NVOCC COM SCAC CODE|NVOCC BOND NUMBER|NVOCC LICENSE NUMBER|NVOCC BOND AMOUNT|NVOCC BOND START EFFECTIVE DATE|NVOCC BOND END EFFECTIVE DATE|INDUSTRY DESCRIPTION|CURRENT VOLUME COUNT|COMPETITOR DESCRIPTION|SPECIAL REQUIREMENT DESCRIPTION|PREFERENCE SERVICE DESCRIPTION|PREFERENCE SERVICE DETAIL DESCRIPTION|PREFERENCE GROUP COMMODITY CODE|PREFERENCE CONTAINER TYPE SIZE CODE|PREFERENCE REPRESENTATIVE COMMODITY CODE|SALES REPRESENTATIVE CODE|C-TPAT SVI NUMBER|FREIGHT FORWARD FMC NUMBER|KEY ACCOUNT FLAG|KEY ACCOUNT START EFFECTIVE DATE|KEY ACCOUNT END EFFECTIVE DATE|KEY ACCOUNT MANAGER USER ID|KEY ACCOUNT MANAGER USER NAME|SUBSIDIARY COMPANY CODE|SUBSIDIARY COMPANY FROM DATE|SUBSIDIARY COMPANY TO DATE|BOOKING ALERT REASON|BOOKING ALERT FROM DATE|BOOKING ALERT TO DATE|BOOKING ALERT MESSAGE|BOOKING ALERT CREATE USER ID|BOOKING ALERT CREATE DATE|MODIFIED CUSTOMER COUNTRY CODE|MODIFIED CUSTOMER SEQUENCE|BEFORE OFFICE CODE|BEFORE OFFICE CHANGE DATE|REFUND PSEUDO VENDOR SEQUENCE|CREATE USER ID|CREATE DATE|UPDATE USER ID|UPDATE DATE|DELETE FLAG|SALES DELETE EFFECTIVE DATE|TOBE MERGED CUSTOMER COUNTRY CODE|TOBE MERGED CUSTOMER SEQUENCE|NAMED CUSTOMER FLAG|MULTIPLE TRADE ACCOUNT FLAG|OTI ORGANIZATION NUMBER|REEFER ACCOUNT FLAG " ;
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"cust_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_div_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"blk_div_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cust_locl_lang_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_abbr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"cntr_cust_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"blk_cust_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"indiv_corp_div_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fndt_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_rgst_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"finc_sts_lvl_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"capi_curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"capi_amt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lstk_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"empe_knt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vbs_clss_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"nbs_clss_cd1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"nbs_clss_cd2",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"nbs_clss_cd3",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"crm_row_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nvocc_co_scac_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nvocc_bd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nvocc_lic_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"nvocc_bd_amt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"nvocc_bd_st_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"nvocc_bd_end_eff_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"indus_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"crnt_vol_knt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cmpt_desc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"spcl_req_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prf_svc_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prf_svc_dtl_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"prf_grp_cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prf_cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prf_rep_cmdt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"srep_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cts_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"frt_fwrd_fmc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"key_acct_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"key_acct_st_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"key_acct_end_eff_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"subs_co_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"modi_cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"modi_cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rfnd_psdo_vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bfr_ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bfr_ofc_cng_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eai_evnt_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"key_acct_mgr_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"key_acct_mgr_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sls_delt_eff_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"flet_mgmt_ownr_cust_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_iss_curr_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_iss_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"nmd_cust_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_alt_rsn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_alt_fm_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_alt_to_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_alt_msg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"bkg_alt_cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_alt_cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eai_if_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mlt_trd_acct_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(1);
		        SetColProperty(0 ,"cust_grp_id", {AcceptKeys:"E|N|[- ]"});
		        SetSheetHeight(152);
			}
			break;
		}
	}
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, SEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author SHKIM
	 * @version 2012.02.21
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			var sheetObject=sheetObjects[0];
			sheetObj.SetWaitImageVisible(0);
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {	
			case IBSEARCH:	  //조회
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("ESM_SAM_0010GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
					ComOpenWait(false);
				}
				break;
			case SEARCH01: // ! 초기화 (기본값 조회)
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("ESM_SAM_0004GS.do", FormQueryString(formObj));
				var cust_grp_nm=(ComGetEtcData(sXml, "cust_grp_nm") == undefined) ? "" : ComGetEtcData(sXml, "cust_grp_nm");
				sheetObj.SetWaitImageVisible(0);
				if(cust_grp_nm == "") {
					ComShowCodeMessage("COM130402", "cust_grp_nm");
					//formObj.cust_grp_id.value="";	//formObj.cust_grp_nm.value="";	//sheetObjects[0].RemoveAll();
//	 				formObj.cust_grp_id.focus();
				}else{
					//document.form.cust_grp_nm.value =cust_grp_nm;
				}			
				break;
			case IBSAVE:	// SAVE 저장.
				if(sheetObj.RowCount()> 0){
					if(validateForm(sheetObj,formObj,sAction)){
						var formSaveObj=document.formSave;
						formSaveObj.f_cmd.value=MULTI;
						//var params = FormQueryString(formSaveObj);
						var prefix="sheet1_";
						var chkPara=""; var chkParaSub="";
						var cnt=0;
						for( i=1 ; i<=sheetObjects[0].RowCount(); i++ ){
							// 1. SEL - 체크되면 1, 안되면 0			, 2. Cust.Code, 3. Customer Name
							if(sheetObjects[0].GetCellValue(i,1) == '1'){
								cnt++;
								if(sheetObjects[0].GetCellValue(i,4) == null || sheetObjects[0].GetCellValue(i,4) == ''){
            						ComShowCodeMessage("COM12114","Group ID"); return;	//msgs['COM12114']='Please check {?msg1}';
            					}
								chkPara="&"+"ibflag=U"
								+"&"+"seq="+sheetObjects[0].GetCellValue(i,1)
								+"&"+"cust_cd="+sheetObjects[0].GetCellValue(i,'cust_cd')
								+"&"+"cust_lgl_eng_nm="+sheetObjects[0].GetCellValue(i,'cust_lgl_eng_nm')
								+"&"+"cust_grp_id="+sheetObjects[0].GetCellValue(i,'cust_grp_id')
								+"&"+"cust_abbr_nm="+sheetObjects[0].GetCellValue(i,'cust_abbr_nm')
								+"&"+"loc_cd="+sheetObjects[0].GetCellValue(i,'loc_cd')
								+"&"+"ofc_cd="+sheetObjects[0].GetCellValue(i,'ofc_cd')
								+"&"+"upd_dt="+sheetObjects[0].GetCellValue(i,'upd_dt')
								+"&"+"cust_seq="+sheetObjects[0].GetCellValue(i,'cust_seq')
								+"&"+"cust_cnt_cd="+sheetObjects[0].GetCellValue(i,'cust_cnt_cd')
            								+"&"+"opn_pg=0010"
            								;
            					chkParaSub=chkParaSub + chkPara;
            				}
            			}
						if(cnt>0){
							var params=FormQueryString(formSaveObj) + "" + chkParaSub;
							//var params = FormQueryString(formSaveObj) + "&" + sheetObj.GetSaveString(false, true, prefix+"ibflag")+ "";
							if(ComShowConfirm(ComGetMsg("COM130101","Data"))){ //Do you want to save Data?
								ComOpenWait(true);
								var sXml=sheetObj.GetSaveData("ESM_SAM_0010GS.do", params);	//
								ComOpenWait(false);
								var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
								if(result != "F"){
									ComShowCodeMessage("COM130102", "Data");	//msgs['COM130102']='{?msg1} was saved successfully.';
									doActionIBSheet(sheetObj, formObj, IBSEARCH);
								}else{
									ComShowCodeMessage("COM130103", "Data"); //Failed to save Data.  Please try again.
								}
							}
						}else{
							ComShowCodeMessage("COM130503");
						}
					}
				}
				break;
			case IBDOWNEXCEL:	// EXCEL 보여줌.
				ComOpenWait(true);
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1,CheckBoxOnValue:'Y', CheckBoxOffValue:' '});//sheetObj.Down2Excel(-1});
				}
				ComOpenWait(false);
					break;
//			case IBINSERT: // B/L List DownLoad
//				if(sheetObj.RowCount > 0){
//					if(ComShowConfirm("Do you want to save EXCEL DOWN?")){	//ComShowCodeMessage("COM130101", "EXCEL DOWN")
//						ComOpenWait(true);
//						var sheetObj = document.sheet2;
//						var SaveFileName = sheetObj.SaveFileDialog("ExcelDown", "book1", "C:\\","엑셀파일(*.xls)|*.xls" );
//		                if (SaveFileName == '' || SaveFileName == "<USER_CANCEL>") { ComShowCodeMessage("COM12113", "PATH"); return; }
//						sheetObj.Down2Excel(-1, false,false,true, SaveFileName);
//						ComShowCodeMessage("COM130102", "EXCEL");
//						ComOpenWait(false);				
//					}
//				}else{
//					ComShowCodeMessage("COM130103", "EXCEL");
//				}
//				break; 
			}	
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
 /**
    * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
    **/
	function obj_Keypress(){
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		var srcValue=event.srcElement.getAttribute("value");
		switch(event.srcElement.dataformat) {
		case "int":
		case "ymd":
			//숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "eng":
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			ComKeyOnlyAlphabet('upper');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "engupspecial": // 영문대문자 + Space + &-,.
        	ComKeyOnlyAlphabet('uppernum', "32|38|39|40|41|44|45|46|47|64|95");
		default:
//			ComKeyOnlyNumber(event.srcElement);
		}
	}
    function obj_deactivate(){
    	obj=event.srcElement;
    	var formObj=document.form;
  		if(obj.name=="str_cre_dt" || obj.name=="end_cre_dt"){
  			var creDtFr=ComReplaceStr(formObj.str_cre_dt.value,"-","");
  			var creDtTo=ComReplaceStr(formObj.end_cre_dt.value,"-","");
  			switch(ComGetEvent("name")) {
      			case "str_cre_dt":
      			if(creDtFr != '' && creDtTo != ''){
      				if(creDtFr > creDtTo){
      					ComShowCodeMessage('COM12133','To date','From date','greater');
      					formObj.str_cre_dt.value='';
//      					formObj.str_cre_dt.focus();
      					return false;
      				}
      			}
      			break;
      			case "end_cre_dt":
      			if(creDtFr != '' && creDtTo != ''){
      				if(creDtFr > creDtTo){
      					ComShowCodeMessage('COM12133','To date','From date','greater');
      					formObj.end_cre_dt.value='';
//      					formObj.end_cre_dt.focus();
      					return false;
      				}
      			}
      			break;	
  			}
  			ComChkObjValid(event.srcElement);
		}
	}
    function obj_activate(){
    	ComClearSeparator(event.srcElement);
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		 switch (sAction) {
		 case IBSEARCH:
			/* 필수 조회 조건 없애고, 	  Sales Office=ofc_cd
			 					, Sales Rep=srep_cd
			 					, Country=cust_cnt_cd
			 					, Creation Date=str_cre_dt , end_cre_dt
			 					중에 1개는 꼭 조회 조건으로 입력
			 					ComTrim(obj, sChar)
			*/			 
			var locCustLglEngNm=ComTrim(formObj.cust_lgl_eng_nm.value);
			if(	locCustLglEngNm==null 		|| locCustLglEngNm=='')	{
				var locOfcCd=formObj.ofc_cd.value;
				var locSrepCd=formObj.srep_cd.value;
				var locCustCntCd=formObj.cust_cnt_cd.value;
				var locStrCreDt=formObj.str_cre_dt.value;
				var locEndCreDt=formObj.end_cre_dt.value;
				var locNulCnt=0;
				if(	locOfcCd==null 		|| locOfcCd=='')	{	locNulCnt++;		}
				if(	locSrepCd==null 	|| locSrepCd=='')	{	locNulCnt++;		}
				if(	locCustCntCd==null 	|| locCustCntCd==''){	locNulCnt++;		}
				if(	locStrCreDt==null 	|| locStrCreDt=='')	{	locNulCnt++;		}
				if(	locEndCreDt==null 	|| locEndCreDt=='')	{	locNulCnt++;		}
				if(	locNulCnt > 4){
					ComShowCodeMessage("SAM00005", "Abbreviation", "3");  //"Sales Office,Sales Rep,Country,Creation Date 중 하나를 선택하십시오. Please select at least one among [Sales Office], [Sales Rep], [Country] and [Creation Date]	
					return false ; 
				} 
			}
			/* 12.03.04 조건 체크 변경 
			var cust_lgl_eng_nm_leg=formObj.cust_lgl_eng_nm.value.length; 
			if(cust_lgl_eng_nm_leg < 3) {
				var aaa='Customer Name';
				var bbb='3';
				//ComShowCodeMessage("COM12111"); //COM12144	COM12160	COM12172
				//ComShowCodeMessage("COM130402", "cust_grp_nm");
				ComShowCodeMessage("SAM00002", "Customer Name", "3",''); 	//ComShowMessage ComShowCodeMessage	COM12174 SAM00002 Customer Name 최소 문자 3자리이상.
	 			return false;
	 		}
			var cust_abbr_nm=formObj.cust_abbr_nm.value.length; 
			if(	cust_abbr_nm > 0 && cust_abbr_nm < 3) {
				ComShowCodeMessage("SAM00002", "Abbreviation", "3"); 	//Abbreviation 최소 문자 3자리이상.
 				return false;
 			}
 			*/
  		break;
  	}
  	return true;
  }
	/**
     * 필드 데이타가 CHANGE될 경우 이벤트
     */
    function obj_change(){
    	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    	if (srcName == "cust_grp_id")  {
    		//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    	}
    }
    /**
     * COM_ENS_071 : 팝업에서 선택한 값 한개 받기 
     * @author SHKIM 
	 * @version 2012.02.15
     */
    function getCOM_ENS_071_ofc_cd(rowArray) {    
    	document.form.ofc_cd.value=rowArray[0][1];		//OFC_CD -- Sales Office 
    }
    /**
     * ESM_SAM_0902 : 팝업에서 선택한 값  cust_grp_nm,cust_abbr_nm,overwrite
     * @author SHKIM 
	 * @version 2012.02.15
     */
    function OnColChange(locCustGrpId, locCustAbbrNm, locOverwrite) {    
    	var total=sheetObjects[0].GetTotalRows();
    	for(i=1 ; i <= total ; i++){
    		if(sheetObjects[0].GetCellValue(i,1) == '1'){ // 1 checked, 0 not
	    		sheetObjects[0].SetCellValue(i,4,locCustGrpId);
	    		sheetObjects[0].SetCellBackColor(i,4,"#FFFF80");
	    		
//    			sheetObjects[0].SetCellFont("FontBold", i,4,1);
//				sheetObjects[0].SetCellFont("FontSize", i,4,9);
//				sheetObjects[0].SetCellFont("FontItalic", i,4,1);
	    		sheetObjects[0].SetCellFontBold(i,4,1);
	    		sheetObjects[0].SetCellFontSize(i,4,14);
	    		sheetObjects[0].SetCellFontItalic(i,4,1);
  			  
	    		//sheetObjects[0].CellBackColor(i,"cust_grp_id") = "#FFFF80"
	    		if(locOverwrite == 'On'){
	    			sheetObjects[0].SetCellValue(i,5,locCustAbbrNm);
	    			sheetObjects[0].SetCellBackColor(i,5,"#FFFF80");
	    			
//					sheetObjects[0].SetCellFont("FontBold", i,5,1);
//					sheetObjects[0].SetCellFont("FontSize", i,5,9);
//					sheetObjects[0].SetCellFont("FontItalic", i,5,1);
	    			sheetObjects[0].SetCellFontBold(i,5,1);
	    			sheetObjects[0].SetCellFontSize(i,5,14);
	    			sheetObjects[0].SetCellFontItalic(i,5,1);
					
	    			//sheetObjects[0].CellBackColor(i,"cust_abbr_nm") = "#FFFF80"
	    		}
    		}
    	}
    }
    /**
     * ESM_SAM_0093 : 팝업에서 선택한 값 한개 받기 
     * @author SHKIM 
	 * @version 2012.02.15
     */
    function getGroupCode(rowArray) {    
    	document.form.cust_grp_id.value=rowArray[0][3];		//Group Code
    }
    /* 개발자 작업  끝 */
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
