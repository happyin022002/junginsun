/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_PSO_0037.js
 *@FileTitle : Tariff Value Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.31
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2009.12.23 정명훈
 * 1.0 Creation
 * 
 * History
 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
 * 2011.06.07 진마리아 CHM-201111397-01 Compulsory Flag Check 보완
 * 2011.07.11 진마리아 CHM-201112149-01 Compulsory Flag 의 checking/unchecking이 모든 Tariff에 대해 변경/저장이 가능하도록 로직 변경
 * 2011.10.31 진마리아 선처리(SRM-201121014) [VOP-PSO] Tariff Value Management 화면 로직 변경
 * 2011.11.23 진마리아 CHM-201114406-01 Tariff Value Management 화면 로직 변경(EDIT_ENBL_FLG 추가)
 * 2014.03.12 박다은   CHM-201429104 	   [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
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
 * @class VOP_PSO_0237 : VOP_PSO_0237 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0237() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;  
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

﻿// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;


var yardSheetDataRows = 1;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
		
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
		case "btn_Save":
			
			doActionIBSheet(sheetObject1,formObject,IBSAVE);

			break;
			
		case "btn_add":										
			sheetObject1.DataInsert(-1);
		
			break;
			
		case "btn_del":		
			for (var i=sheetObject1.LastRow; i>=sheetObject1.HeaderRows; i--) { 
				if (sheetObject1.CellValue(i, "sheet1_del_chk") == 1) {
					sheetObject1.RowDelete(i, false);							
				}
			} 
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
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* IBCombo Object를 배열로 등록
* param : combo_obj ==> 콤보오브젝트
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++] = combo_obj;  
}


/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	var formObject = document.form;

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}


	initControl(sheetObjects[0]);  
	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	
	for(i=2;i<=sheetObj.LastRow;i++) {	
		vndrseq = sheetObj.CellValue(i, "sheet1_vndr_seq");
    	sheetObj.CellValue2(i, "sheet1_vndr_seq2") = vndrseq;	
	}
}

/**
* Form의 Conrol 를 초기화 시킨다. <br>
*/
function initControl(sheetObj){
	// Form 객체 선언
	formObj = document.form;
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListenerForm  ('blur', 'obj_blur', form);
	axon_event.addListenerForm  ('keyup', 'obj_keyup', form); 
	axon_event.addListenerForm  ('change', 'obj_change', form);
}



function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

		case "sheet1":
			with (sheetObj) {
				// 높이 설정
				style.height = 330;
	
				MultiSelection = false;
	
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = "|Del|From|From|From|From|From|From|TO|TO|TO|||||";
				var HeadTitle2 = "|Del|Account|S/P|Base|Surcharge|Discount|Regular|Account|S/P|Name|||||";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				var prefix = "sheet1_";
	
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+"ibflag" );
			    InitDataProperty(0, cnt++ , dtDummyCheck, 	40,     daCenter,   true,       prefix+"del_chk");
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"acct_cd",  		false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"vndr_seq",  	false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			70,  	daCenter,	true,		prefix+"base",  		false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"surcharge",     false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"discount",  	false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,		    70,		daCenter,	true,		prefix+"regular",  		false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"acct_cd2" ,  	false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		prefix+"vndr_seq2",  	false,	"",			dfNone,			0,		true,   true, 6);
				InitDataProperty(0, cnt++ , dtData,			100,	daLeft,  	true,		prefix+"vndr_nm",   	false,	"",			dfNone,			0,		false,  false);
				
				//InitDataProperty(0, cnt++ , dtHidden,		50,	    daCenter,  	true,		prefix+"base2",  		false,	"",			dfNone,			0,		true,   true);
				//InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,  	true,		prefix+"surcharge2",    false,	"",			dfNone,			0,		true,   true);
				//InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"discount2",  	false,	"",			dfNone,			0,		true,   true);
				//InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,		prefix+"regular2",  	false,	"",			dfNone,			0,		true,   true);
				InitDataProperty(0, cnt++ , dtHidden,	    120,	daCenter,	true,		prefix+"yd_chg_no",  	false,	"",			dfNone,			0,		true,   true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,		prefix+"yd_chg_ver_seq",false,	"",			dfNone,			0,		true,   true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,		prefix+"new_yd_chg_no", false,	"",			dfNone,			0,		true,   true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,		prefix+"yd_cd",  		false,	"",			dfNone,			0,		true,   true);
				InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,		prefix+"cost_cd",  		false,	"",			dfNone,			0,		true,   true);
				
				InitDataValid(0, prefix+"vndr_seq2", vtNumericOnly);
			}
			break;
		
	}
}	

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // Main 조회
			var aryPrefix = new Array("sheet1_");   
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH;
						
			ComOpenWait(true);

			sheetObjects[0].WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml = sXml.split("|$$|");
			sheetObjects[0].Redraw = false;
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			sheetObjects[0].Redraw = true;
			ComOpenWait(false);
	
		break;
		
		case IBSAVE:      // Main 조회
			
		     var duprows1 = sheetObjects[0].ColValueDupRows("sheet1_acct_cd|sheet1_vndr_seq2");
		//	 var arrRow = duprows1.split(",");
			//  for (idx=0; idx<arrRow.length-1; idx++){ alert(arrRow[idx] + "행"); }


			if(duprows1 !="" ) { 
				 alert('Please check doubled account code..');
				 return;
			}

			
			if(formObj.new_yd_cd1.value =="" && formObj.new_yd_cd2.value =="" && formObj.new_yd_cd3.value =="" &&
					formObj.new_yd_cd4.value =="" && formObj.new_yd_cd5.value ==""){
				 alert("Please input Yard code..");
				 return;
			}
			
			  ComOpenWait(true); 
		   	  var sParam =  ComGetSaveString(sheetObjects);
		       if( sParam == ""){ return;}
	           formObj.f_cmd.value = MULTI;   
	           sParam += "&" + FormQueryString(formObj);
	           var aryPrefix = new Array("sheet1_");
			   var sXml = sheetObjects[0].GetSaveXml("VOP_PSO_0237GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
			  
			   sheetObjects[0].LoadSaveXml(sXml);//Hidden Object 에 로드
			   ComOpenWait(false);
	           break;
		
	}
}	
 

function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;
	//var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "ym": case "ymd":
			ComKeyOnlyNumber(obj);
			break;
		case "num":
			if(obj.name=="vndr_seq"){
				//ComKeyOnlyNumber(obj,",");
				ComKeyOnlyNumber(obj);	//[2009.08.24:jmh]
			} else {
				ComKeyOnlyNumber(obj);
			}
			break;
		case "eng":
			ComKeyOnlyAlphabet(); 
			break;
		case "engup":
			if(obj.name=="vsl_slan_cd"){
				ComKeyOnlyAlphabet('uppernum');
			} else {
				ComKeyOnlyAlphabet('upper');
			}
			
			break;
		case "engdn":
			if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
			else ComKeyOnlyAlphabet('lower');
			break;
		case "uppernum":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}




/**
 * IBSheet Popup Event
 */
function sheet1_OnPopupClick(sheetObj,Row,Col){
	var prefix = "sheet1_";
	switch (sheetObj.ColSaveName(Col)) {
			
		case prefix + "copy" :
			var formObj = document.form;		
			
		   	var theURL = "VOP_PSO_0213.do?vvd="					+ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd)
										+"&pol_cd="             +ComGetObjValue(formObj.pol_cd)
										+"&pol_clpt_ind_seq="  	+ComGetObjValue(formObj.pol_clpt_ind_seq);
		   	
		   	var winName = "Tariff Copy";
		   	var features = "scroll:yes;status:no;resizable=yes;help:no;dialogWidth:900px;dialogHeight:550px";
		   	ComOpenWindow(theURL,winName,features,true);
		break;
	}
	

}


function obj_blur(){
		var formObj = document.form;
	    var sheetObject = sheetObjects[0];
		var srcName = window.event.srcElement.getAttribute("name");

	    switch(srcName) {
	            case "new_yd_cd1":
	              if(formObj.new_yd_cd1.value != "") { 
	                	formObj.f_cmd.value = COMMAND03;// YD_CD VALIDATION
	    			    var param = FormQueryString(formObj) + "&new_yd_cd=" + formObj.new_yd_cd1.value; 
	    			    var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", param );
	    		        var item1 = ComGetEtcData(sXml, "ydcd"); //yard code
	    			
	    		        if(item1 == 0) { 
	    				  formObj.new_yd_cd1.focus();
	    				  alert("Please check yard code..");
	    				  formObj.new_yd_cd1.value = "";
	    				  return;  }
	    			
	    			    if((formObj.new_yd_cd1.value == formObj.new_yd_cd2.value) ||(formObj.new_yd_cd1.value == formObj.new_yd_cd3.value) 
	    			      ||(formObj.new_yd_cd1.value == formObj.new_yd_cd4.value)||(formObj.new_yd_cd1.value == formObj.new_yd_cd5.value))
	    			     { 
	    			    	formObj.new_yd_cd1.focus();
	    				    alert("Please check yard code..");
	    				    formObj.new_yd_cd1.value = "";
	    				    return;
	    			      }
	                }		
	          	    
	              break;
	           
	            case "new_yd_cd2":
	            	 if(formObj.new_yd_cd2.value != ""){ 
	                 	formObj.f_cmd.value = COMMAND03;// YD_CD VALIDATION
	    		    	var param2 = FormQueryString(formObj) + "&new_yd_cd=" + formObj.new_yd_cd2.value; 
	    			    var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", param2 );
	    			    var item2 = ComGetEtcData(sXml, "ydcd"); //yard code
	    	
	        			if(item2 == 0 && formObj.new_yd_cd2.value != "") { 
	    	    			formObj.new_yd_cd2.focus();
	    	        		alert("Please check yard code..");
	    			    	formObj.new_yd_cd2.value = "";
	    				    return;   }
	    			
	    			    if((formObj.new_yd_cd2.value == formObj.new_yd_cd1.value) ||(formObj.new_yd_cd2.value == formObj.new_yd_cd3.value) 
	    			       ||(formObj.new_yd_cd2.value == formObj.new_yd_cd4.value)||(formObj.new_yd_cd2.value == formObj.new_yd_cd5.value)) { 
	    				    formObj.new_yd_cd2.focus();
	    				    alert("Please check yard code..");
	    				    formObj.new_yd_cd2.value = "";
	    				    return; }
	            	 }
		                break;
		        
	            case "new_yd_cd3":
	            	if(formObj.new_yd_cd3.value != ""){ 
	            	    formObj.f_cmd.value = COMMAND03;// YD_CD VALIDATION
	    		     	var param3 = FormQueryString(formObj) + "&new_yd_cd=" + formObj.new_yd_cd3.value; 
	    			    var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", param3 );
	    		        var item3 = ComGetEtcData(sXml, "ydcd"); //yard code
	    			
	    		         if(item3 == 0 && formObj.new_yd_cd3.value != "") { 
	    				    formObj.new_yd_cd3.focus();
	    	    		    alert("Please check yard code..");
	    				    formObj.new_yd_cd3.value = "";
	    				    return;}
		  	        
	    			     if((formObj.new_yd_cd3.value == formObj.new_yd_cd1.value) ||(formObj.new_yd_cd3.value == formObj.new_yd_cd3.value) 
	   	    		 	 ||(formObj.new_yd_cd3.value == formObj.new_yd_cd4.value)||(formObj.new_yd_cd3.value == formObj.new_yd_cd5.value)) {
	   	    		     	  formObj.new_yd_cd3.focus();
	   	    				  alert("Please check yard code..");
	   	    				  formObj.new_yd_cd3.value = "";
	   	    				  return; }
	            	    }
		          	break; 
	          	
	            case "new_yd_cd4":
	            	if(formObj.new_yd_cd4.value != ""){ 
	            	   formObj.f_cmd.value = COMMAND03;// YD_CD VALIDATION
	    		    	var param4 = FormQueryString(formObj) + "&new_yd_cd=" + formObj.new_yd_cd4.value; 
	    			    var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", param4 );
	    		   	    var item4 = ComGetEtcData(sXml, "ydcd"); //yard code
	    			
	    		   	     if(item4 == 0 && formObj.new_yd_cd4.value != "") { 
	    				    formObj.new_yd_cd4.focus();
	    				    alert("Please check yard code..");
	    				    formObj.new_yd_cd4.value = "";
	    				    return;   }
	    			
	    			     if((formObj.new_yd_cd4.value == formObj.new_yd_cd1.value) ||(formObj.new_yd_cd4.value == formObj.new_yd_cd2.value) 
		   	    			 ||(formObj.new_yd_cd4.value == formObj.new_yd_cd3.value)||(formObj.new_yd_cd4.value == formObj.new_yd_cd5.value)){ 
		   	    				formObj.new_yd_cd4.focus();
		   	    				alert("Please check yard code..");
		   	    				formObj.new_yd_cd4.value = "";
		   	    				return;  }
	            	  }
		          	break;
		          	
	            case "new_yd_cd5":
	            	if(formObj.new_yd_cd5.value != ""){ 
	            	   formObj.f_cmd.value = COMMAND03;// YD_CD VALIDATION
	    			   var param5 = FormQueryString(formObj) + "&new_yd_cd=" + formObj.new_yd_cd5.value; 
	    			   var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", param5 );
	    		       var item5 = ComGetEtcData(sXml, "ydcd"); //yard code
	    			
	    		        if(item5 == 0 && formObj.new_yd_cd5.value != "") {
	    				   formObj.new_yd_cd5.focus();
	    				   alert("Please check yard code..");
	    				   formObj.new_yd_cd5.value = "";
	    				   return;	}
		  	        
	    			    if((formObj.new_yd_cd5.value == formObj.new_yd_cd1.value) ||(formObj.new_yd_cd5.value == formObj.new_yd_cd2.value) 
		   	    			 ||(formObj.new_yd_cd5.value == formObj.new_yd_cd3.value)||(formObj.new_yd_cd5.value == formObj.new_yd_cd4.value))
		   	    			{ 
		   	    				formObj.new_yd_cd5.focus();
		   	    				alert("Please check yard code..");
		   	    				formObj.new_yd_cd5.value = "";
		   	    				return;
		   	    			}
	            	}
		          	break;  	
	        } 
		}


function sheet1_OnChange(sheetObj,Row,Col) {
	var formObj = document.form;
	var prefix = "sheet1_";
	
	switch (sheetObj.ColSaveName(Col)) {
		
		case prefix + "vndr_seq2":
			formObj.f_cmd.value = COMMAND01;// VENDOR VALIDATION
			var param = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
			param = param + "&vndr_seq2=" + sheetObj.CellValue(Row, Col); 
			var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", param );
			
			var items = ComGetEtcData(sXml, "vendor"); //Service Provider Name
	
		if( items == "" || items == undefined ){
			ComShowCodeMessage('PSO00014','');
			sheetObj.CellValue2(Row,Col) = ""; 
			sheetObj.CellValue2(Row,Col+1) = ""; 
			}
		else  sheetObj.CellValue2(Row,Col+1) = items;
//		else
//		 {  sheetObj.CellValue2(Row,Col+1) = items;
//		
//		    formObj.f_cmd.value = COMMAND02;// TARIFF 존재여부
//		    var param2 = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//			param2 = param2 + "&vndr_seq2=" + sheetObj.CellValue(Row, Col); 
//			var sXml = sheetObj.GetSearchXml("VOP_PSO_0237GS.do", param2 );
//			var cnt = ComGetEtcData(sXml, "tariff"); //Service Provider Name
//		    
//			if(cnt != "0") { 
//				 alert("Already registered vendor's tariff..");
//				 sheetObj.CellValue2(Row,Col) = ""; 
//				 sheetObj.CellValue2(Row,Col+1) = "";        
//			    }       
//		  }
		
	    break;
	    	
	}
}


	