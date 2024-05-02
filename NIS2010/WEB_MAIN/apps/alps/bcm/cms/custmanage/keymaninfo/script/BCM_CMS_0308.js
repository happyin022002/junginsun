/*=========================================================

*Hipluscard 2017
*@FileName : esm_bkg_0308.js
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.10
*@LastModifier : 임진영
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

function esm_bkg_0243() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
}

/* 개발자 작업    */
//공통전역변수
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      var formObj = document.form;
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {
				case "btn_close"://Close 버튼 클릭
					window.close();
				break;

				case "btn_save"://KeyMan Info 저장
					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
				break;
				
		        case "birth_btn":
		            var cal = new ComCalendar();
		            cal.select(formObj.birth_dt, 'yyyy-MM-dd');
		        break;
		        
		        case "wed_anvrsry_btn":
		            var cal = new ComCalendar();
		            cal.select(formObj.wed_anvrsry_dt, 'yyyy-MM-dd');
		        break;
		        
				case "btn_com_ens_041":
					   var param="";
		    		   ComOpenPopup('/hanjin/COM_ENS_041.do?' + param, 780, 500, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
				break;
				
				case "btn_com_ens_043":
					   var param="";
		    		   ComOpenPopup('/hanjin/COM_ENS_043.do?' + param, 780, 500, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
				break;


         } 
 }

 function loadPage(){
	 var formObj = document.form;
	 for(i=0;i<sheetObjects.length;i++){
	        //khlee-시작 환경 설정 함수 이름 변경
	            ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	            ComEndConfigSheet(sheetObjects[i]);
	  }
	 initControl();
	 //화면 로딩시 param 으로 넘어온 데이터를 세팅한다.
	 fncInitData();
 }

function initControl(){
	var formObject = document.form;
	axon_event.addListenerForm  ("change", "form_onChange", formObject);
	axon_event.addListener("beforedeactivate", 'obj_deactivate', formObject);
	axon_event.addListenerForm('keyup','obj_keyup', formObject);
	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); 

}

function bkg_keypress() {
	switch (event.srcElement.dataformat) {
		case "ymd":
			// number
			ComKeyOnlyNumber(event.srcElement, "-");
			break;
		case "engup":
			// 영문대문자
			ComKeyOnlyAlphabet('upper');
			break;
		case "engupnum":
			// 숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "num":
			// 숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		default:
	}
}

function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}

 /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt = 0;
     switch(sheetObj.id) {
     //조회할 용도로 사용
         //저장할 데이터용도로 사용
         case "sheet1":      // sheet2 init
             with (sheetObj) {
                 // 높이 설정
                 style.height = 117;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msAll;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(4, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, false, true, false,false)
                 var HeadTitle = "||Srep name|Cust name";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

				var sheetName = "sheet1_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,	false,		sheetName + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,	false,		sheetName + "Seq",				false,		"",	dfNone,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtHidden,            80,        daCenter,    false,        sheetName + "srep_nm",          false,        "",    dfNone,        0,        false,        false);
                InitDataProperty(0, cnt++ , dtHidden,            80,        daCenter,    false,        sheetName + "cust_nm",          false,        "",    dfNone,        0,        false,        false);

				DataRowMerge(0) = true;

            }
             break;
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 410;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					var HeadTitle = "|First Name|Last Name|Mr/Ms|Job Title|S.Rep|Customer|work Fax#|keyman_seq|In charge of|Department|Significance|Birthday|Wedding Anniversary|Single/Married|Spouse Name|Email|Character|Work Phone|Mobile Phone|Home Phone|Cust Cnt Code|Cust seq";
					var headCount = ComCountHeadTitle(HeadTitle);
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
					// SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
					// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE,
					// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "sheet2_";
					InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false, prefix + "ibflag");
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "fst_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix + "last_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "per_title", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 110, daCenter, true, prefix + "job_title", false, "", dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix + "srep_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 200, daCenter, true, prefix + "cust_lgl_eng_nm", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 160, daCenter, true, prefix + "fax_ph_num", false, "", dfNone, 0, false, false);
					//hidden DATA
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "keyman_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "pager_pin", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "occupation", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "eye_color", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "birth_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "wed_anvrsry_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "hair_color", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "spouse_name", false, "", dfNone, 0, false, false);

					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "email_addr", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "con_manager_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,   100, daCenter, true, prefix + "work_ph_num", false, "", dfNone, 0, false, false);

					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "cell_ph_num", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "home_ph_num", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "cust_cnt_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "cust_seq", false, "", dfNone, 0, false, false);
					//InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, prefix + "", false, "", dfNone, 0, false, false);

				}
				break;

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
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSAVE:
			if (ComIsNull(formObj.fst_name)) {
				ComShowCodeMessage("SAM00009", "First Name");
				formObj.fst_name.focus();
				return false;
			}else if (ComIsNull(formObj.last_name)) {
				ComShowCodeMessage("SAM00009", "Last Name");
				formObj.last_name.focus();
				return false;
			}else if (ComIsNull(formObj.cust_cd)) {
				ComShowCodeMessage("SAM00009","Customer Code");
				formObj.cust_cd.focus();
				return false;
			}
			break;
	}
     return true;
 }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;


		switch(sAction) {
				case SEARCH01: // 조회
					if (!validateForm(sheetObj, formObj, sAction))
						return;
					
					formObj.f_cmd.value = SEARCH;
					//formObj.cust_seq.value=formObj.cust_cd.value.substring(2,8);
					//formObj.cust_cnt_cd.value=formObj.cust_cd.value.substring(0,2);
					//form.cust_cd.value=aryPopupData[0][3];
					var sXml = sheetObj.GetSearchXml("BCM_CMS_0307GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
					sheetObjects[1].Redraw = false;
					sheetObjects[1].WaitImageVisible = false;
					sheetObjects[1].LoadSearchXml(sXml);
					sheetObjects[1].Redraw = true;
					// if ("sheet1" == sheetObj.id)
					// sheetObj.DoSearch("ESM_BKG_0071GS.do",FormQueryString(formObj) +
					// "&" + ComGetPrefixParam("sheet1_"));
					break;

				case IBSAVE:        //저장
					if(validateForm(sheetObj,formObj,sAction)) {
		 				formObj.f_cmd.value = MULTI;
		 				sheetObjects[0].WaitImageVisible = false;
		 				ComOpenWait(true); //대기이미지 표시
		 				var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0308GS.do", FormQueryString(formObj));
		 				sheetObj.LoadSaveXml(SaveXml);
		 				ComOpenWait(false); //대기이미지 숨김
		 			}
		            break;

				break;
				
				case IBSEARCH:      //조회
	                if(validateForm(sheetObj,formObj,sAction)) {
	                	 formObj.f_cmd.value = SEARCH;
	                     selectVal = FormQueryString(formObj);
	                    //	alert("확인"+selectVal);
//	                     sheetObj.UseZipFile = true;
	                     var sXml = sheetObj.GetSearchXml("COM_ENS_043GS.do", selectVal+ "&" + ComGetPrefixParam("sheet1_"));
	                     sheetObj.LoadSearchXml(sXml);

	                }else{
	                	return true;
	                }
	           
	           break;
	           
				case SEARCH09:      //Customer Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH09;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        
				        if(result=="" ){
				        	ComShowCodeMessage("COM130402", "Customer Code");
				        	formObj.cust_cnt_cd.value="";
				        	formObj.cust_seq.value="";
				        	formObj.cust_cd.value="";
				        }else{
				        	formObj.f_cmd.value = SEARCH;
		                     selectVal = FormQueryString(formObj);
		                     var sXml = sheetObj.GetSearchXml("COM_ENS_041GS.do", selectVal+ "&" + ComGetPrefixParam("sheet1_"));
		                     sheetObj.LoadSearchXml(sXml);
				        }
					}
				break;
				
				case SEARCH10:      //Srep Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH10;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        ;
				        if(result=="" ){
				        	ComShowCodeMessage("COM130402", "Srep Code");
				        	formObj.srep_cd.value="";
		
				        }else{
				        	doActionIBSheet(sheetObjects[0],formObj, IBSEARCH);
				        }
						ComOpenWait(false);
					}
				break;

	    }
	}
/**
 * 화면 로딩시 param 으로 넘어온 데이터를 세팅한다.
 * @return
 */
function fncInitData(){
	var formObj = document.form;
	var ibflag = dialogArguments.document.form.ibflag.value;
	formObj.ibflag.value =ibflag;
	if(ibflag=="U"){
		var valObj = document.getElementById("keyman_seq");
		valObj.value = arrColValues;//text box 에 값을 설정
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
	}
	var srep_cd = formObj.srep_cd.value;
	if(!srep_cd == ""){
		doActionIBSheet(sheetObjects[0],formObj, IBSEARCH);
	}

}
/**
 *
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	if(sheetObj.RowCount > 0){
		if(sheetObj.CellValue(1,"sheet1_srep_nm")!=""){
			formObj.srep_nm.value = sheetObj.CellValue(1,"sheet1_srep_nm");
		}else{
			formObj.cust_lgl_eng_nm.value = sheetObj.CellValue(1,"sheet1_cust_nm");
		}
	}
	ComOpenWait(false);
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    //Grid의 Data를 Html의 인자값으로 Copy한다.
    ComCopyRowToForm(sheetObjects[1], 1, document.form, "sheet2_");
}

function checkNull(obj){

	var objNull = document.getElementById(obj.id+ "_null");

	if(obj.value == '') {
		objNull.checked=true;
	}else{
		objNull.checked=false;
	}
}

/**
 * Carrier Code Pop up to read from. <br>
 */ 
function setCallBack0B2(aryPopupData) {
	var form=document.form;
	//alert("setCallBack0B2  aryPopupData"+aryPopupData);
	form.cust_seq.value=aryPopupData[0][3].substring(2,8);
	form.cust_cnt_cd.value=aryPopupData[0][3].substring(0,2);
	form.cust_cd.value=aryPopupData[0][3];
	form.cust_lgl_eng_nm.value=aryPopupData[0][4];
	//doActionIBSheet(sheetObjects[0], form, SEARCH);
}


/**Carrier Code Pop up to read from. <br>
*/ 
function setCallBack0B3(aryPopupData) {
	var form=document.form;
	form.srep_cd.value=aryPopupData[0][4];
	form.srep_nm.value=aryPopupData[0][5];
}

function form_onChange(evt,el) {
  	var formObj = document.form;
  	var xml = "";
  	var srcName;
  	var srcValue;
	var srcObj;
  	if (el) {
  		srcObj = el;
  		srcName = el.getAttribute("name");
  		srcValue = el.getAttribute("value");
  		
  	} else {
  		srcObj = window.event.srcElement;
  		srcName = srcObj.getAttribute("name");
  		srcValue = srcObj.getAttribute("value");
  		if(srcName != "cust_cd" && formObj.ibflag.value != 'I'){
  			formObj.ibflag.value="U";
  		}
  	}
  	switch(srcName) {
  		case "cust_cd":
	  		if(formObj.cust_cd.value.length>2){	   
	  			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
	  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
           		if(formObj.cust_seq.value.match(/[^0-9]{1}/)){
           			  ComShowCodeMessage("CCD00039", "Customer Code");
           			  formObj.cust_cd.value='';
           			  formObj.cust_lgl_eng_nm.value='';
           			  
           			  return false;
           		}  
           		var custlpad="";
           		if (formObj.cust_seq.value.length <6 ){
           			for(i=1; i <= 6- formObj.cust_seq.value.length; i++){
           				 custlpad=custlpad+"0" ;
           			}
           			formObj.cust_cd.value=formObj.cust_cnt_cd.value+custlpad+formObj.cust_seq.value ;
           		}
           		doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
    			if(formObj.cust_cd.value.length==0){
//            			document.form.cust_cd.focus();
        		}else{
    				//formObj.ibflag.value="U";
    				formObj.cust_cd.readOnly=true;		
    				//doActionIBSheet(sheetObject1, formObj, SEARCH);
        		}
    		}
	  		break;
  		case "srep_cd":
           		if(formObj.srep_cd.value.length > 5){
           			  ComShowCodeMessage("CCD00033", "Srep Code");
           			  formObj.srep_cd.value='';
           			  formObj.srep_nm.value='';
           			  return false;
           		}  
           		doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
    			if(formObj.srep_cd.value.length==0){
            			//document.form.con_manager_name.focus();
        		}else{
    				//formObj.ibflag.value="U";
    				formObj.srep_cd.readOnly=true;		
//            				document.form.cust_lgl_eng_nm.focus();
        		}
	  		break;
  	}

}

function ComCopyRowToForm(sheetobj, row, formObj, prefix){
    //함수의 인자 유효성 확인-시작
    if (sheetobj==null || typeof sheetobj != "object" || sheetobj.tagName != "OBJECT") {
      return alert("ComCopyRowToForm 함수의 sheetobj 인자는 IBSheet Object가 아닙니다.");
    } else if (formObj==null || typeof formObj != "object" || formObj.tagName != "FORM") {
      return alert("ComCopyRowToForm 함수의 formObj 인자는 FORM 태그가 아닙니다.");
    }
    //HTML컨트롤의 name 앞에 붙는 글자
    //if (!prefix == null) prefix = "";
    if (row == null || row == 0) row = sheetobj.SelectRow;

    // Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
    for(col=0;col<=sheetobj.LastCol;col++){
      //컬럼의 별명을 문자열로 가져온다.
      var col_alias  = sheetobj.ColSaveName(col);

      if(col_alias == '') continue;
      
      var cell_value = sheetobj.CellValue(row,col);
      var col_alias = col_alias.split(prefix);
      var frmchild   = document.form.elements(col_alias[1]);
      
      if(frmchild == undefined)continue;
      
      var sType = frmchild.type;
      // radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
      if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;

      // 타입별로 값을 설정한다.
      switch(sType) {
      	case undefined:
        case "button":
        case "reset":
        case "submit":
        	break;
        case "radio":
          for (idx=0; idx<frmchild.length; idx++) {
            if(frmchild[idx].value == cell_value) {
              frmchild[idx].checked=true;
              break;
            }
          }
        break;
        case "checkbox":
          frmchild.checked = (cell_value==1 || cell_value=='Y');
        break;
        default :
        frmchild.value = cell_value;
      }//end of switch
    }//end of for(col)
    var cust_cnt_cd = sheetObjects[1].CellValue(1, prefix+"cust_cnt_cd");
    var cust_seq = sheetObjects[1].CellValue(1, prefix+"cust_seq");
    document.form.elements("cust_cd").value = cust_cnt_cd + cust_seq;
  }
    /* 개발자 작업  끝 */
