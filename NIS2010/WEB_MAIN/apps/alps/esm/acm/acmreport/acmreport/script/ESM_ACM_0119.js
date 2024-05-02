/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_ACM_0119.js
*@FileTitle : Agent Commission CSR Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 박다은
*@LastVersion : 1.0
* 1.0 Creation
*
* 2014.06.11 박다은 [CHM-201428456] Comm 모듈의 ACM 발행 CSR Detail 기능 로직 변경
=========================================================*/

/** 
 * 공통전역변수
 */
var sheetObjects = new Array();
var sheetCnt = 0;

/** 
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
	    //시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	    
	    //마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

    var formObj = document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0
				
				//전체 너비 설정
				SheetWidth = 0
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택][Default msNone]
				MergeSheet = msHeaderOnly;
	
			    //전체Edit 허용 여부[선택][Default false]
				Editable = false;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(9, 0, 0, true);
	
				//해더기능설정[선택][SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false) ;
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//				var HeadTitle = "Cost Office|Confirmed Date|Vender Name|No of INV|INV Currency|Total Amount|Payment Due Date|ASA No";
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,      40,    daCenter,  false,    "tj_ofc_cd",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      200,   daCenter,  false,    "inv_dt",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData, 		100,   daRight,   false,    "vndr_seq",       false,    "",         dfNone,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData, 		100,   daRight,   false,    "vndr_locl_lang_nm",       false,    "",         dfNone,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData, 		100,   daRight,   false,    "attr_ctnt1",       false,    "",         dfNone,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData, 		100,   daRight,   false,    "csr_curr_cd",       false,    "",         dfNone,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData, 		100,   daRight,   false,    "csr_amt",       false,    "",         dfNone,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData, 		100,   daRight,   false,    "inv_term_dt",       false,    "",         dfNone,    2,          false,      false);
				InitDataProperty(0, cnt++, dtData, 		100,   daRight,   false,    "attr_ctnt2",       false,    "",         dfNone,    2,          false,      false);
				CountPosition = 0;
			}
			break;
		case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(11);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택][Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부[선택][Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);

				//해더기능설정[선택][SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false) ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "SEQ|Invoice No|Net Amount|Tax Amount|Total Amount";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,      40,    daCenter,  false,    "seq",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,      200,   daCenter,  false,    "inv_no",       false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSumEx, 100,   daRight,   false,    "net_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSumEx, 100,   daRight,   false,    "tax_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSumEx, 100,   daRight,   false,    "tot_amt",       false,    "",         dfFloat,    2,          false,      false);
				CountPosition = 0;
			}
			break;
	}
}

/** 
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 */
function processButtonClick(){
	var formObj = document.form;
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_close":
				window.close();
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	switch(sAction) {
	    case IBSEARCH:		//조회
//			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH01;
			sheetObject.DoSearch4Post("ESM_ACM_0119GS.do", agtQryStr(formObj));
			
			formObj.ofccd.value 	= sheetObject.CellValue(1, "tj_ofc_cd");
			formObj.confdt.value 	= sheetObject.CellValue(1, "inv_dt");
			formObj.vndrno.value 	= sheetObject.CellValue(1, "vndr_seq");
			formObj.vndrnm.value 	= sheetObject.CellValue(1, "vndr_locl_lang_nm");
			formObj.cnt.value 		= sheetObject.CellValue(1, "attr_ctnt1");
			formObj.currcd.value 	= sheetObject.CellValue(1, "csr_curr_cd");
			formObj.totamt.value 	= sheetObject.CellValue(1, "csr_amt");
			formObj.paydt.value 	= sheetObject.CellValue(1, "inv_term_dt");
			formObj.asano.value 	= sheetObject.CellValue(1, "attr_ctnt2");
			
			formObj.f_cmd.value = SEARCH02;
			sheetObject1.DoSearch4Post("ESM_ACM_0119GS.do", agtQryStr(formObj));
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//		if (!isNumber(iPage)) {
//			return false;
//		}
	}

	return true;
}
	

/**
 * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. 빈값은 넣어주지 않는다.<br>
 * @param{form}	str	 Form 객체  
 * @param{exElmNms}	str	  exElmNms값들은 form elemente name으로 구성하지 않을 값들이다. 
 */	 
 function agtQryStr(form, exElmNms) {

     if (typeof form != "object" || form.tagName != "FORM") {
         alert("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
         return "";
     }

     var name = new Array(form.elements.length);
     var value = new Array(form.elements.length);
     var j = 0;
     var plain_text="";

     //사용가능한 컨트롤을 배열로 생성한다.
     len = form.elements.length;
     for (i = 0; i < len; i++) {
       //클래스 아이디로 제품을 구분함-아래는 HTMl제품
       if(form.elements[i].classid==undefined){
     	  //전송전에 폼의 마스크를 제거한다.
//     	  ComClearSeparator(form.elements[i]);
       switch (form.elements[i].type) {
         case "button":
         case "reset":
         case "submit":
           break;
         case "radio":
         case "checkbox":
                     if (form.elements[i].checked == true) {
                         name[j] = form.elements[i].name;
                         value[j] = form.elements[i].value;
                         j++;
                     }
                     break;
             case "select-one":
                     name[j] = form.elements[i].name;
                     var ind = form.elements[i].selectedIndex;
                     if(ind >= 0) {
                         if (form.elements[i].options[ind].value != '')
                             value[j] = form.elements[i].options[ind].value;
                         else
                             value[j] = '';
                     } else {
                         value[j] = "";
                     }
                     j++;
                     break;
             case "select-multiple":
                     name[j] = form.elements[i].name;
                     var llen = form.elements[i].length;
                     var increased = 0;
                     for( k = 0; k < llen; k++) {
                         if (form.elements[i].options[k].selected) {
                             name[j] = form.elements[i].name;
                             if (form.elements[i].options[k].value != '')
                                 value[j] = form.elements[i].options[k].value;
                             else
                                 value[j] = '';
                             j++;
                             increased++;
                         }
                     }
                     if(increased > 0) {
                         j--;
                     } else {
                         value[j] = "";
                     }
                     j++;
                     break;
                 default :
                     if(form.elements[i].value.length >0 ) {
                    	 if(exElmNms!=null && exElmNms!='' && exElmNms!=undefined){
                    		 if(!checkExElm(form.elements[i].name, exElmNms)){
 		                    	name[j] = form.elements[i].name;
		                     	value[j] = form.elements[i].value;
		                     	j++;
                    		 }
                    	 } else {
	                    	name[j] = form.elements[i].name;
	                     	value[j] = form.elements[i].value;
	                     	j++;
                    	 }
                     }
         }
 	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//       ComAddSeparator(form.elements[i]);
     //IB에서 제공하는 컨트롤의 값을 조합한다.
     }else{
       switch(form.elements[i].classid){
         case "CLSID:BFED6FBB-30E3-4402-B5D6-C31F40B56A0E":  // IBMaskEdit 경우
           name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
                 value[j] = form.elements[i].Value;
                 j++;
           break;
         case CLSID_IBMCOMBO: // IBMultiCombo 경우
           name[j] = form.elements[i].name==""?form.elements[i].id:form.elements[i].name;
           		if(form.elements[i].UseCode)
           			value[j] = form.elements[i].Code;
           		else
           			value[j] = form.elements[i].Text;
                 j++;
                 break;
       }
     }
     }

     // QueryString을 조합한다.
     //   1) Explorer 5.5 이상일 경우, encodeURIComponent() 를 이용하여 URL Encode
     //   2) 기타 경우는 IB Sheet 를 이용하여 URL Encode
     var webBrowserName = navigator.appName;
     var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                         navigator.appVersion.indexOf("MSIE") + 8)

     if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
         for (i = 0; i < j; i++) {
             // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
             if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
         }
     } else {
         var tmpUrlEncodeSheet    = document.getElementById("formquerystring");

         if( tmpUrlEncodeSheet == undefined || tmpUrlEncodeSheet == null || tmpUrlEncodeSheet == '')
         {
             //인코딩을 위해 숨겨진IBSheet를 만든다.
             var sTag = ComGetSheetObjectTag("formquerystring");
             form.insertAdjacentHTML('afterEnd', sTag);
         }

         for (i = 0; i < j; i++) {
             // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
             if (name[i] != '') plain_text += name[i]+ "=" + formquerystring.UrlEncoding(value[i]) + "&";
         }
     }


   //마지막에 &를 없애기 위함
   if (plain_text != "")
     plain_text = plain_text.substr(0, plain_text.length -1);
     return plain_text;
 }
