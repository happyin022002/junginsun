/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2119.js
*@FileTitle : Spot Guide RFA Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.12 공백진
* 1.0 Creation
=========================================================
* History
* 2011.05.25 이행지 [CHM-201111048-01] ALPS Error 처리-Access Date 날짜 Validation Retreive 버튼 클릭시 추가
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나 조회 가능토록 수정  
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만 자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2012.01.31 서미진 [CHM-201215924] RFA Proposal & Amendment Inquiry 화면에서 소급 권한별 조회 조건 추가
* 2012.02.08 이석준[CHM-201216074] RFA 조회시 HAMRU 산하의 BA OFFICE들이 상대방 BA RFA 조회 못하게 했던 부분을 다시 원래대로 조회 할 수 있도록 수정     
* 2012.06.25 서미진[CHM-201217633] 구주 Hinterland Operation 개선 Project : Rate (For AEE/AEW), Arbitrary (For AEE/AEW) 화면 추가 
* 2012.11.06 이은섭[CHM-201220395] - Add On Tariff 개선 프로젝트 : Rate, Arbitrary 탭 추가
* 2013.03.19 전윤주[CHM-201323647] ALPS 통합로그 SQL 오류 제거 - customer 검색 시 customer seq. 자리에 숫자가 들어오지 않는 경우 validation 처리
* 2013.12.20 서미진 [선처리 CSR] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.09.15 최성환 [CHM-201431899] Guideline RFA 생성 요청
* 2015.07.14 전지예 [CHM-201536753]Spot Guide RFA Artitrary Tab 추가 (BOMSC Only)
* 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
 * @class ESM_PRI_2019 : ESM_PRI_2019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_2019() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
}

/* 개발자 작업   */
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif"; 
var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon2.gif";

//수정 후 수정한 scope으로 focus를 이동 하기 위한 변수
var preSvcScpCd = "";
var preScustSeq = "";
var preScustCntCd = "";
var controlHidden = false;

// T/F 전환을 위한 기준 EXP_DT
var tabDivCount = 9;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */
function processButtonClick() {
    /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

    /** **************************************************** */
    var formObj = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");
        if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {              
            if (getButtonTable(srcName).disabled || window.event.srcElement.disabled) {
                return false;
            }
        }

        switch (srcName) {
        case "btn_hidden":            	
        	setControlHidden();
        	break;
        case "btn_retrieve":
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
            break;

        case "btn_new":
            doActionIBSheet(sheetObjects[0],document.form,IBCREATE);                
            break; 
            
        case "btns_calendar1": //달력버튼
            var cal = new ComCalendar();                
            cal.select(formObj.seff_dt, 'yyyy-MM-dd');
            break;
        case "btn_ctrt_cust":
            var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.scust_cnt_cd.value+"&cust_seq="+formObj.scust_seq.value, "", 640, 460, true);
            if (rtnVal != null){
                formObj.scust_cnt_cd.value = rtnVal.custCntCd;
                formObj.scust_seq.value = rtnVal.custSeq;
                formObj.sctrt_pty_nm.value = rtnVal.custNm;
            }
            break;     
        case "btn_dem_pop":            
            if (formObj.prop_no.value ==""){
                ComShowCodeMessage('PRI01021');
                return;
            }               
            var sUrl = "/hanjin/EES_DMT_2003.do?" + "prop_no="+formObj.prop_no.value+"&amdt_seq="+formObj.amdt_seq.value + "&caller=2007";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "", 1010, 700, 'findCustomer', '1,0,1,1,1,1,1', true);
            break;                   
        case "btn_afil_pop":
            if (formObj.prop_no.value ==""){
                ComShowCodeMessage('PRI01021');
                return;
            }               
            var sParam = getParameters(srcName, "");                
            var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2119_06.do?"+sParam, "", 1020, 295, true);            
            break;
        case "btn_proposal":
            if (formObj.prop_no.value ==""){
                ComShowCodeMessage('PRI01021');
                return;
            }

 			var pgmNo = "ESM_PRI_2103";
 			var pgmUrl = "/hanjin/ESM_PRI_2103.do"
    		var params = "&cond_prop_no=" + formObj.prop_no.value;
			var parentPgmNo = pgmNo.substring(0, 8)+'M001';   // ESM_PRI_M045  -- M001
 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "ESM_PRI_2103", sFeatures);  
			
        	break;
        case "btn_history":
            if (formObj.rfa_no.value ==""){
                ComShowCodeMessage('PRI02015');
                return;
            }  	            	
            if (formObj.prop_no.value ==""){
                ComShowCodeMessage('PRI01021');
                return;
            }

 			var pgmNo = "ESM_PRI_2141";
 			var pgmUrl = "/hanjin/ESM_PRI_2141.do"
    		var params = "&rfa_no_2043=" + formObj.rfa_no.value;
			var parentPgmNo = pgmNo.substring(0, 8)+'M001';   //ESM_PRI_M045  -- M001
 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
			var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
			var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "ESM_PRI_2141", sFeatures);  
        	            	
        	break;            	
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
        	ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
* IBSheet Object를 배열로 등록 <br>
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
* 배열은 소스 상단에 정의 <br>
* <br><b>Example :</b>
* <pre>
*     setSheetObject(sheetObj);
* </pre>
* @param {ibsheet} sheet_obj 필수 IBSheet Object
* @return 없음
* @author 공백진
* @version 2009.04.17
*/ 
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* IBTab Object를 배열로 등록 <br>
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
* 배열은 소스 상단에 정의 <br>
* <br><b>Example :</b>
* <pre>
*     setTabObject(tab_obj);
* </pre>
* @param {ibtab} tab_obj 필수 IBTab Object
* @return 없음
* @author 공백진
* @version 2009.04.17
*/ 
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
* IBMulti Combo Object를 배열로 등록 <br>
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
* 배열은 소스 상단에 정의 <br>
* <br><b>Example :</b>
* <pre>
*     setComboObject(combo_obj);
* </pre>
* @param {ibCombo} combo_obj 필수 IBMulti Combo Object
* @return 없음
* @author 공백진
* @version 2009.04.17
*/ 
function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
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
* @author 공백진
* @version 2009.04.17
*/
function loadPage() {

     for (var i = 0; i < sheetObjects.length; i++) { 
        ComConfigSheet(sheetObjects[i]);   
        initSheet(sheetObjects[i], i + 1);          
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (var k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
    }
    //IBMultiCombo초기화
    for(var k = 0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    
    // 로딩시 Arbitrary 탭 Disable
    setTabEnable(3, false);

    initControl();
    initFormControl();
    sheetObjects[1].DataInsert();
    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);         
 	var form = document.form;
    if("null" != form.srfa_no.value && null != form.srfa_no.value && "" != form.srfa_no.value) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
    }     
    
    if("null" != form.sprop_no.value && null != form.sprop_no.value && "" != form.sprop_no.value) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
    }
    
    form.srfa_no.focus();
}

  
 
/**
* Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
* <br><b>Example :</b>
* <pre>
*     initControl()
* </pre>
* @param 없음
* @return 없음
* @author 공백진
* @version 2009.04.17
*/  
 function initControl() {
    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
    axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
    axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
    axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
 }
 
 /**
 * OnKeyPress event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_keypress()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */ 
 function obj_keypress() {
     switch (event.srcElement.dataformat) {
         case "engup":
             if (event.srcElement.name == "srfa_no" || event.srcElement.name =="sprop_no" || event.srcElement.name =="sprop_srep_cd") {
                 ComKeyOnlyAlphabet('uppernum');
             } else {
                 ComKeyOnlyAlphabet('upper');
             }    
             break;
         case "int":
             ComKeyOnlyNumber(event.srcElement);
             break;
         case "float":
             ComKeyOnlyNumber(event.srcElement, ".");
             break;
         case "ymd":
          	ComKeyOnlyNumber(event.srcElement, "-");
          	break;                 
         default:
     }
 }    

 /**
 * OnKeyDown event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param 없음
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */       
   function obj_keydown(){
       //enter key조회
   var eleName = event.srcElement.name;
   var keyValue = null;
   if(event == undefined || event == null) {
	   keyValue = 13;
   }else{
	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
   }
   if (keyValue == 13){
       switch (eleName){
       case "srfa_no":
       case "sprop_no":
       case "seff_dt":
       case "sprop_ofc_cd":
       case "sprop_srep_cd":
       case "scust_cnt_cd":
       case "scust_seq":
        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        	   break;
           }        
       }
   }       
     

    
     /**
 * Onbeforedeactivate  event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_deactivate()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */  
function obj_deactivate() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var sheetObj1 = sheetObjects[0];
	var eleName = event.srcElement.name;

	switch (eleName) {

	case "scust_cnt_cd":
		// cust name find
		if (preScustCntCd != formObj.scust_cnt_cd.value) {
			if (formObj.scust_cnt_cd.value == "") {
				formObj.sctrt_pty_nm.value = "";
				formObj.scust_seq.value = "";
				preScustCntCd = "";
			} else {
				sCustNameFind(eleName);
				preScustCntCd = formObj.scust_cnt_cd.value;
			}
		}
		ComChkObjValid(event.srcElement);
		break;
	case "scust_seq":
		var custSeq = formObj.scust_seq.value;
		if (custSeq.length < 6 && custSeq.length != 0) {
			formObj.scust_seq.value = ComLpad(custSeq, 6, "0");
		}
		if (formObj.scust_seq.value == "" || !ComIsNumber(formObj.scust_seq.value)) { //[CHM-201323647] 숫자가 아닌 경우 clear
			formObj.sctrt_pty_nm.value = "";
			formObj.scust_cnt_cd.value = "";
			formObj.scust_seq.value = ""
			preScustSeq = "";
		} else {
			if (ComParseInt(preScustSeq) != ComParseInt(formObj.scust_seq.value)) {
				// cust name find
				if (formObj.scust_seq.value != "") {
					sCustNameFind(eleName);
				}
				preScustSeq = ComParseInt(formObj.scust_seq.value);
			}
		}

		break;
	case "seff_dt":
		ComChkObjValid(event.srcElement);
		break;

	case "prop_mvc":
		ComChkObjValid(event.srcElement);
		break;
	default:
		ComChkObjValid(event.srcElement);
	}
}   
 
/**
* OnBeforeActivate   event를 처리한다. <br>
* <br><b>Example :</b>
* <pre>
*     obj_activate()
* </pre>
* @param 없음
* @return 없음
* @author 공백진
* @version 2009.04.17
*/     
function obj_activate() {
    var formObj = document.form;
    var srcName = event.srcElement.getAttribute("name");
    ComClearSeparator (event.srcElement);
}


/**
* Sheet관련 프로세스 처리 <br>
* <br><b>Example :</b>
* <pre>
*     doActionIBSheet(sheetObj, document.form, IBSEARCH)
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @param {form} formObj 필수 html form object
* @param {int} sAction 필수 프로세스 플래그 상수
* @return 없음
* @author 공백진
* @version 2009.04.17
*/  
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	try {
		switch (sAction) {
		case IBSEARCH_ASYNC03: // 최초 조회(조회조건)
			ComOpenWait(true); // ->waiting->start
			if (!validateForm(sheetObjects[0], document.form, sAction)) {
				return false;
			}
			formObj.f_cmd.value = SEARCH10; //변경- 이전 : SEARCH
			sheetObj.doSearch("ESM_PRI_2019GS.do", FormQueryString(formObj));
			ComOpenWait(false); // ->waiting->End
			break;
			
		case IBSEARCH: // 조회 (리스트의 개별 조회)
			ComOpenWait(true); // ->waiting->start
			preSvcScpCd = sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "svc_scp_cd");
			sheetObj = sheetObjects[1];

			formObj.f_cmd.value = SEARCH11;  //변경- 이전 : SEARCH01
			var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2019GS.do", FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				sheetObjects[1].LoadSearchXml(arrXml[0]);
			clearAllTabPages();
			if (arrXml.length > 1)
				sheetObjects[2].LoadSearchXml(arrXml[1]);
			//calcMVC();
			ComOpenWait(false); // ->waiting->End
			setTabText();
			tab1_OnChange(tabObjects[0], beforetab);
			break;

		case IBCREATE: // New
			clearAllForms();
			clearAllTabPages();
			clearButtonImages();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			form.srfa_no.focus();
			break;
		case IBSEARCH_ASYNC01:
			comboObjects[0].RemoveAll();
			comboObjects[1].RemoveAll();
			comboObjects[3].RemoveAll();
			ComPriTextCode2ComboItem(scopeCdValue, scopeCdText, getComboObject(comboObjects, 'ssvc_scp_cd'), "|", "\t");
			ComPriTextCode2ComboItem(stsCdValue, stsCdText, getComboObject(comboObjects, 'sprop_sts_cd'), "|", "\t");
	        //RFA Contract Type
	        ComPriTextCode2ComboItem(rfaCtrtTpCdValue, rfaCtrtTpCdText, getComboObject(comboObjects, 'srfa_ctrt_tp_cd'),"|","\t" );
			break;

		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		if (sAction == IBCREATE || sAction == IBSEARCH_ASYNC01) {
			return;
		}
		ComOpenWait(false); // ->waiting->End
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
* @author 공백진
* @version 2009.04.17
*/
function initSheet(sheetObj, sheetNo) {

    var cnt = 0;
    var sheetID = sheetObj.id;
    switch (sheetID) {
    case "sheet0":
        with (sheetObj) {

            // 높이 설정
            style.height = 150;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 7, 100);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다

            var HeadTitle = "Seq.|RFA No.|RFA No.|Proposal No.|Customer|Customer\nType|RFA Type|Request\nOffice|Sales\nRep.|Creation\nDate|Effective\nDate|Expiration\nDate|Status";
            var headCount = ComCountHeadTitle(HeadTitle);
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtSeq,  	40,  	daCenter,  true,  "seq");
            InitDataProperty(0, cnt++ , dtData,   80,  	daCenter,  false, "rfa_no",				false, "", dfNone,    0, true, true);
            InitDataProperty(0, cnt++ , dtData,   35,  	daCenter,  false, "amdt_seq",     		false, "", dfNone,    0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	100,  	daCenter,  false, "prop_no",      		false, "", dfNone,    0, true, true);                
			InitDataProperty(0, cnt++ , dtHidden,  	240,	daLeft,		 false, "ctrt_pty_nm",  		false, "", dfNone,    0, true, true);	//SPOT
            InitDataProperty(0, cnt++ , dtHidden,   65,  	daCenter,  false, "cust_tp_nm",   		false, "", dfNone,    0, true, true);	//SPOT
            InitDataProperty(0, cnt++ , dtHidden,   60,  	daCenter,  false, "rfa_ctrt_tp_cd",   	false, "", dfNone,    0, true, true);	//SPOT
			InitDataProperty(0, cnt++ , dtData,  	130,  	daCenter,  false, "prop_ofc_cd",  	false, "", dfNone,    0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	130,  	daCenter,  false, "prop_srep_cd", 	false, "", dfNone,    0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	120,  	daCenter,  false, "cre_dt",       		false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	120,  	daCenter,  false, "eff_dt",       		false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	120,  	daCenter,  false, "exp_dt", 	   		false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++ , dtData,  	60,  	daCenter,  false, "prop_sts_nm",  	false, "", dfNone,	 0, true, true);
			WaitImageVisible = false;
        	}
        	break;        
    
    case "sheet1":
        with (sheetObj) {
    	
 //SPOT 주석 시킴
// 높이 설정
//style.height = 100;
    	
    	
            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;
            // 전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "")
                InitHostInfo(location.hostname, location.port, page_path);
            
            // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 3, 100);
            
            
            var HeadTitle  = "|rfa_no|prop_no|amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|prc_prog_sts_cd"                 
            HeadTitle += "|src_info_cd|pre_exp_dt|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|cre_dt";
            HeadTitle += "|ctrt_cust_cnt_cd|ctrt_cust_seq|ctrt_pty_nm|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|respb_sls_ofc_cd|respb_srep_cd|ctrt_cust_srep_nm|tgt_mvc_qty";
            HeadTitle += "|cntr_lod_ut_cd|unit|sls_ld_no"
            HeadTitle += "|prc_ctrt_cust_tp_nm|prop_prpr_flg|createtype|prop_apro_staff|dmdt_ft_tp_cd|act_cm|est_cm|rfa_ctrt_tp_cd";
            var headCount = ComCountHeadTitle(HeadTitle);               
            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)    
   
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);    
            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
            // SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
            // ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_no", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);                           
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt", false, "", dfDateYmd, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "eff_dt", false, "", dfDateYmd, 0, false, false);                             
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "exp_dt", false, "", dfDateYmd, 0, false, false);              
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "src_info_cd", false, "", dfNone, 0, false, false);                               
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_exp_dt", false, "", dfDateYmd, 0, false, false); // eff_dt
                                                                                                                        // - 1
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts_cd", false, "", dfNone, 0, false, false);               
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts", false, "", dfNone, 0, false, false);                
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_ofc_cd", false, "", dfNone, 0, false, false);               
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_cd", false, "", dfNone, 0, false, false);              
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_nm", false, "", dfNone, 0, false, false);              
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_ofc_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_dt", false, "", dfNone, 0, false, false);                              
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cre_dt", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_cnt_cd", false, "", dfNone, 0, false, false);               
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_seq", false, "", dfNone, 0, false, false);
           
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_nm", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm", false, "", dfNone, 0, false, false);             
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "respb_sls_ofc_cd", false, "", dfNone, 0, false, false);              
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "respb_srep_cd", false, "", dfNone, 0, false, false);             
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_srep_nm", false, "", dfNone, 0, false, false);   
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "tgt_mvc_qty", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cntr_lod_ut_cd", false, "", dfNone, 0, false, false);                                
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "unit", false, "", dfNone, 0, false, false);                              
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sls_ld_no", false, "", dfNone, 0, false, false);                 
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_nm", false, "", dfNone, 0, false, false); 
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_prpr_flg", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prop_cre_tp_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_staff", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dmdt_ft_tp_cd", false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_crnt_cm_amt", false, "", dfInteger, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_estm_cm_amt", false, "", dfInteger, 0, false, false);
            InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_ctrt_tp_cd", false, "", dfNone, 0, false, false);
            WaitImageVisible = false;
        }
        break;
        
    case "sheet2":
        with (sheetObj) {
            // 높이 설정
            style.height = 120;
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
            InitRowInfo(1, 1, 3, 100);



            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false, false)

            var HeadTitle =  "|Sel.|Prop No|Amendment Seq|SVC Scope|Duration|Duration|Target MQC|Unit";
                HeadTitle += "|Request Office|Sales Rep|Status Code|eff_dt|exp_dt|n1st_cmnc_dt";
                HeadTitle += "|Status|prc_prog_sts_cd|src_info_cd|submqcori|PRE_EXT_SCP";
            var headCount = ComCountHeadTitle(HeadTitle);
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
            // SAVENAME,
            // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
            // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
            // ALLCHECK,
            // SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
            InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
            InitDataProperty(0, cnt++, dtHidden,  90, daLeft,   false, "prop_no", 		   false, "", dfNone, 	 0, false, false);
            InitDataProperty(0, cnt++, dtHidden,  90, daLeft,   false, "amdt_seq", 		   false, "", dfNone, 	 0, false, false);
            InitDataProperty(0, cnt++, dtData,   170, daCenter, false, "svc_scp_cd", 	   false, "", dfNone, 	 0, false, true);                
            InitDataProperty(0, cnt++, dtData,   130, daCenter, false, "ctrt_eff_dt", 	   false, "", dfDateYmd, 0, false, false);
            InitDataProperty(0, cnt++, dtData,   130, daCenter, false, "ctrt_exp_dt", 	   false, "", dfDateYmd, 0, false, false); 
            InitDataProperty(0, cnt++, dtHidden,   110, daRight,  false, "tgt_mvc_qty", 	   false, "", dfInteger, 0, false, false);	//SPOT
            InitDataProperty(0, cnt++, dtHidden,    60, daCenter, false, "cntr_lod_ut_cd",   false, "", dfNone,    0, false, false);	//SPOT
            InitDataProperty(0, cnt++, dtData,   180, daCenter, false, "prop_scp_ofc_cd",  false, "", dfNone, 	 0, false, false); 
            InitDataProperty(0, cnt++, dtData,   180, daCenter, false, "prop_scp_srep_cd", false, "", dfNone, 	 0, false, false);
            InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "prop_scp_sts_cd",  false, "", dfNone, 	 0, false, false);
            InitDataProperty(0, cnt++, dtHidden,  95, daCenter, false, "eff_dt", 		   false, "", dfNone, 	 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  95, daCenter, false, "exp_dt", 		   false, "", dfNone, 	 0, true, true);
            InitDataProperty(0, cnt++, dtHidden,  95, daCenter, false, "n1st_cmnc_dt", 	   false, "", dfNone, 	 0, true, true);
            InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_scp_sts", 	   false, "", dfNone, 	 0, true, true);
            InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd",  false, "", dfNone, 	 0, true, true);
            InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", 	   false, "", dfNone, 	 0, true, true);
            InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tgt_mvc_qty_ori",  false, "", dfInteger, 0, true, true);                // PRE_EXT_SCP
            InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "pre_ext_scp", 	   false, "", dfNone, 	 0, true, true);

            InitDataValid(0, "svc_scp_cd", vtEngUpOnly);
            ShowButtonImage = 2;
            ImageList(0) = "img/btns_search_off.gif";
            ImageList(1) = "img/btns_search.gif";
            WaitImageVisible = false;
        }
        break;      
    }
}

/**
* Tab 기본 설정 탭의 항목을 설정한다.  <br>
* Tab이 다수일 경우 Tab 수만큼 case를 추가하여 Tab의 초기화모듈을 구성한다 <br>
* <br><b>Example :</b>
* <pre>
*     initTab(tabObj,1);
* </pre>
* @param {tabObj} tabObj 필수 IBTab Object
* @param {int} tabNo 필수 IBTab Object 태그의 아이디에 붙인 일련번호
* @return 없음
* @author 공백진
* @version 2009.04.17
*/   
function initTab(tabObj, tabNo) {
    switch (tabNo) {
	    case 1:
	        with (tabObj) {
	            var cnt = 0;
	            InsertTab(-1, "Rate", cnt++);
	            InsertTab(-1, "Location Group ", cnt++);
	            InsertTab(-1, "Commodity Group ", cnt++);
	            InsertTab(-1, "Arbitrary", cnt++);
	            InsertTab(-1, "Special Note", cnt++);               
	            //SPOT
	            //기존
//	            InsertTab(cnt++, "Rate", 0);
//	            InsertTab(cnt++, "Location Group ", 1);
//	            InsertTab(cnt++, "Commodity Group ", 2);
//	            InsertTab(cnt++, "Arbitrary", 3);
//	            InsertTab(cnt++, "Special Note", 4);  
	            
	            ShowIcon = true;
	            UseLargeIcon = false;
	            ImageUrl(0) = ICON_URL_NOT_EXIST;
	            ImageUrl(1) = ICON_URL_NOT_EXIST;
	            ImageUrl(2) = ICON_URL_NOT_EXIST;
	            ImageUrl(3) = ICON_URL_NOT_EXIST;
	            ImageUrl(4) = ICON_URL_NOT_EXIST;
	        }
	        break;
    }
}

/**
* Combo 기본 설정, Combo의 항목을 설정한다.  <br>
* <br><b>Example :</b>
* <pre>
*     initCombo(comboObj,1);
* </pre>
* @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
* @return 없음
* @author 공백진
* @version 2009.04.17
*/         
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "ssvc_scp_cd":
            var i=0;
            with(comboObj) {
                //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
	                  UseAutoComplete = true;
	            	  IMEMode = 0;
	            	  ValidChar(2, 0);
	            	  MaxLength = 3;
                }
                break;     
   
  
            case "sprop_sts_cd":
            var i=0;
            with(comboObj) {
                //UseEdit = true;
                // BackColor = "cyan";
                DropHeight = 200;
                MultiSelect = false;
                MaxSelect = 1;
                IMEMode = 0;
                UseAutoComplete = true;
                ValidChar(2, 1);
            }     
            break; 
            
        case "retro_active":
            var i=0;
            with(comboObj) {
                DropHeight = 100;
                MultiSelect = false;
                MaxSelect = 1;
                IMEMode = 0;
                UseAutoComplete = true;
                ValidChar(2, 1);
                InsertItem(i++, "", "");
                InsertItem(i++, "Yes", "Y");
                InsertItem(i++, "No", "N");
            }     
            break; 
        case "rfa_ctrt_tp_cd":
            var i=0;
            with(comboObj) {
                //UseEdit = true;
                // BackColor = "cyan";
                DropHeight = 200;
                MultiSelect = false;
                MaxSelect = 1;
                IMEMode = 0;
                UseAutoComplete = true;
                ValidChar(2, 0);
            }    
            break; 
    }
}



/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
* <br><b>Example :</b>
* <pre>
*     if (validateForm(sheetObj,document.form,IBSAVE)) {
*         로직처리;
*     }
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @param {form} formObj 필수 html form object
* @param {int} sAction 필수 프로세스 플래그 상수
* @return bool <br>
*          true  : 폼입력값이 유효할 경우<br>
*          false : 폼입력값이 유효하지 않을 경우
* @author 공백진
* @version 2009.04.17
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH_ASYNC03: // 조회
		// 2011.05.25 이행지 [CHM-201111048-01] Access Date 날짜 Validation Retreive 버튼 클릭시 추가
		if (!ComIsDate(formObj.seff_dt.value) && formObj.seff_dt.value != "") {
			ComShowCodeMessage("PRI00322", "Access Date");
			formObj.seff_dt.focus();
			return false;
		}
		var k = 0;
		if (ComTrim(formObj.srfa_no.value) != "") {
			k++;
		}
		if (ComTrim(formObj.sprop_no.value) != "") {
			k++;
		}
		if (ComTrim(formObj.seff_dt.value) != "") {
			k++;
		}
		if (ComTrim(formObj.ssvc_scp_cd.Code) != "") {
			k++;
		}
		if (ComTrim(formObj.scust_cnt_cd.value) != "" && ComTrim(formObj.scust_seq.value) != "") {
			k++;
		}
		if (ComTrim(formObj.srfa_ctrt_tp_cd.Code) != "") {
			k++;
		}
		if (k < 1) {
			ComShowCodeMessage("PRI01158");	//msgs['PRI01158'] = 'Please input more than 1 item among RFA No, Proposal No, Access Date, SVC scope.';
			return false;
		}
		break;
	}

	return true;
}    
    

   /**
* Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
* <br><b>Example :</b>
* <pre>
*     tab1_OnChange(tabObj, tabIndex)
* </pre>
* @param {tabObj} tabObj 필수 IBTab Object
* @param {int} tabIndex 필수 프로세스 플래그 상수
* @return 없음
* @author 공백진
* @version 2009.04.17
*/ 
function tab1_OnChange(tabObj, tabIndex) {
	if (beforetab != tabIndex || tabIndex == 0) {
		var toIndex = getFrameTabId(tabIndex);
		for ( var i = 1; i <= tabDivCount; i++) {
			document.getElementById("tabLayer" + i).style.display = 'none';
		}
		document.getElementById(toIndex.divIndex).style.display = 'inline';
	}
	beforetab = tabIndex;
	loadTabPage(tabIndex);
}

/**
 * 2012.09.20일 추가 Tab에 따른 Tab Lay 밑 URL 설정
 * 
 * @param tabIndex
 */
function getFrameTabId(tabIndex) {
	var frameId = "";
	var sUrl = "";
	var divIndex = "";
	
	switch (tabIndex) {
    	case 0: {
/*    		var index = checkArbiRate();
    		if (index == 0) {
    			frameId = "t1frame";
    			sUrl = "ESM_PRI_2119_07.do";	//Rate
    			divIndex = "tabLayer1";
    		} else if (index == 1) {
    			frameId = "t2frame";
    			sUrl = "ESM_PRI_2119_08.do";	//Rate (For AEE/AEW)
    			divIndex = "tabLayer2";
    		} else if (index == 2) {
    			frameId = "t3frame";
    			sUrl = "ESM_PRI_2119_13.do";	//Rate (For Add On Tariff)
    			divIndex = "tabLayer3";
    		}*/
    		
    		//SPOT ONLY
    		frameId = "t1frame";
			sUrl = "ESM_PRI_2119_07.do";	//Rate
			divIndex = "tabLayer1";
    		break;
    	}
    	case 1: {
    		frameId = "t4frame";
    		sUrl = "ESM_PRI_2119_02.do";	//Location Group
    		divIndex = "tabLayer4";
    		break;
    	}
    	case 2: {
    		frameId = "t5frame";
    		sUrl = "ESM_PRI_2119_03.do";	//Commodity Group
    		divIndex = "tabLayer5";
    		break;
    	}
    	case 3: {
//    		var index = checkArbiRate();
//    		if (index == 0) {
//    			frameId = "t6frame";
//    			sUrl = "ESM_PRI_2119_04.do";	//Arbitrary
//    			divIndex = "tabLayer6";
//    		} else if (index == 1) {
//    			frameId = "t7frame";
//    			sUrl = "ESM_PRI_2119_09.do";	//Arbitrary (For AEE/AEW)
//    			divIndex = "tabLayer7";
//    		} else if (index == 2) {
//    			frameId = "t8frame";
//    			sUrl = "ESM_PRI_2119_12.do";	//Arbitrary (For Add On Tariff)
//    			divIndex = "tabLayer8";
//    		}

    		//SPOT ONLY
			frameId = "t8frame";
			sUrl = "ESM_PRI_2119_12.do";	 // Arbitrary
			divIndex = "tabLayer8";
    		break;
    	}
    	case 4: {
    		frameId = "t9frame";
    		sUrl = "ESM_PRI_2119_01.do";	//Special Note
    		divIndex = "tabLayer9";
    		break;
    	}
	}
	var obj = new Object({
		'frame' : frameId,
		'url' : sUrl,
		'divIndex' : divIndex
	});
	return obj;
}

/**
* Tab변경시 화면을 Frame에 로드한다.  <br>
* <br><b>Example :</b>
* <pre>
*     loadTabPage(tabIndex)
* </pre>
* @param {tabIndex} tabIndex 필수 tab의 일련번호
* @return 없음
* @author 공백진
* @version 2009.04.17
*/      
function loadTabPage(tabIndex, wh) {
    if (tabIndex == null || tabIndex == "") {
        tabIndex = tabObjects[0].SelectedIndex;
    }
	//SPOT
	//javascript error 발생으로 아래 추가
	if(tabIndex < 0 ){
		return false;
	}
	
	var obj = getFrameTabId(tabIndex);
	var objTabWindow = document.getElementById(obj.frame).contentWindow;
	if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
		objTabWindow.location.href = obj.url;
		return true;
	}
    var sheetObj1 = sheetObjects[1];
    var sheetObj2 = sheetObjects[2];
    var sRow = sheetObj2.SelectRow;
    var sPropNo = sheetObj2.CellValue(sRow,"prop_no");
    var sAmdtSeq = sheetObj2.CellValue(sRow, "amdt_seq");
    var sSvcScpCd = sheetObj2.CellValue(sRow, "svc_scp_cd");
   
    if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sheetObj2.CellValue(sRow, "ibflag")!="I") {
    	var chide_loadFlag = eval(document.getElementById(obj.frame).contentWindow.loadFlag);
    	if(chide_loadFlag == undefined || chide_loadFlag) {
    		document.getElementById(obj.frame).contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd);
    	}
    }       
}

/**
* Tab에 로드된 모든 Sheet의 데이터를 Clear한다.  <br>
* <br><b>Example :</b>
* <pre>
*     clearAllTabPages()
* </pre>
* @param  없음
* @return 없음
* @author 공백진
* @version 2009.04.17
*/         
function clearAllTabPages() {
	for ( var i = 0; i < tabObjects[0].GetCount(); i++) {
		tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
	}

	for ( var i = 1; i <= tabDivCount; i++) {
		if (document.getElementById("t" + i + "frame").contentWindow.tabClearSheet) {
			document.getElementById("t" + i + "frame").contentWindow.tabClearSheet();
		}
	}
}

/**
* duration,Mvc,afiliate 버튼의 이미지를 초기화 한다.<br>
* <br><b>Example :</b>
* <pre>
*		clearButtonImages();
* </pre>
* @param  없음
* @return 없음
* @author 공백진
* @version 2009.05.07
*/
function clearButtonImages(){
    document.images("img_affil").src = ICON_URL_NOT_EXIST;
}

/**
 * 버튼의 색을 지정하고 Check Box를 비활성화 한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *		clearButtonImages();
 * </pre>
 * @param  없음
 * @return 없음
 * @author 공백진
 * @version 2009.05.07
 */      
function initFormControl(){
    document.getElementById("btn_afil").style.color = "black";
}    

/**
* 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
* <br><b>Example :</b>
* <pre>
*     clearAllForms()
* </pre>
* @param  없음
* @return 없음
* @author 공백진
* @version 2009.04.17
*/       
function clearAllForms(){
    
    var formObj = document.form;
    for (var i = 0; i < 3; i++){
    	comboObjects[i].Index = -1;	
    }
    formObj.srfa_no.value = "";
    formObj.sprop_no.value = "";
    formObj.seff_dt.value = "";
    formObj.svc_scp_nm.value = "";
    formObj.sprop_ofc_cd.value = "";
    formObj.sprop_srep_cd.value = "";
    formObj.scust_cnt_cd.value = "";
    formObj.scust_seq.value = "";
    formObj.sctrt_pty_nm.value = "";       

    formObj.rfa_no.value="";        
    formObj.amdt_seq.value="";        
    formObj.prop_no.value="";        
    formObj.ctrt_eff_dt.value="";
    formObj.ctrt_exp_dt.value="";
    formObj.prop_sts.value="";
    formObj.prop_ofc_cd.value="";        
    formObj.prop_srep_cd.value = "";        
    formObj.prop_srep_nm.value="";
    formObj.prop_apro_staff.value="";
    formObj.cre_dt.value="";
    formObj.ctrt_cust_cnt_cd.value="";
    formObj.ctrt_cust_seq.value="";
    formObj.ctrt_pty_nm.value="";
    formObj.prc_ctrt_cust_tp_nm.value="";
    formObj.ctrt_cust_val_sgm.value="";        
    formObj.respb_srep_cd.value = "";        
    formObj.respb_sls_ofc_cd.value="";     
    formObj.ctrt_cust_srep_nm.value="";
    formObj.tgt_mvc_qty.value="";
    formObj.prop_mvc.value="";
    formObj.prop_mvc_tp.value="";
    formObj.prs_crnt_cm_amt.value = "";
    formObj.prs_estm_cm_amt.value = "";
    formObj.prs_sum_cm_amt.value = "";    
    formObj.dmdt_ft_tp_cd.value = "";
    formObj.rfa_ctrt_tp_cd.value=""; 

    // 로딩시 Arbitrary 탭 Disable
    setTabEnable(3, false);
}

/**
* sheet의 팝업버튼이미지를 변경한다. <br>
* <br><b>Example :</b>
* <pre>
*     sheetButtonImageChange(sheetObj, Row, sw)
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @param {int} Row 필수 이미지를 변경하고자하는 해당 셀의 Row Index    
* @return {int} <br>
*          0 : 비활성 이미지<br>
*          1 : 활성 이미지
* @author 공백진
* @version 2009.04.17
*/
function sheetButtonImageChange(sheetObj, Row, sw){      
    sheetObj.PopupButtonImage(Row, "scp_dur_pop") = sw;

    }

   
    /**
 * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
 * Combo의 text값을 Html Object에 표시한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *    ssvc_scp_cd_OnBlur(comboObj);
 * </pre>
 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */ 
function ssvc_scp_cd_OnBlur(comboObj) {
	var formObj = document.form;		
	var code = comboObj.FindIndex(comboObj.Code, 0);		
	if (code != null && code != "") {
		var text = comboObj.GetText(code, 1);
		if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
			formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
		}
	}
}    

/**
* IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
* 콤보의 text로 Scope Name을 표시한다.<br> 
* <br><b>Example :</b>
* <pre>
*    ssvc_scp_cd_OnChange(comboObj, code, text);
* </pre>
* @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @param   {string} code 필수 코드
* @param   {string} text 필수 화면에 표시된 문자 
* @return 없음
* @author 공백진
* @version 2009.04.17
*/ 	
function ssvc_scp_cd_OnChange(comboObj, code, text) {
	var formObj = document.form;
	
	var arrText = text.split("|");
	if (arrText != null && arrText.length > 1) {
		formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
	}else{
		formObj.svc_scp_nm.value = "";
	}
}	

/**
* IBMulti Combo에서 KeyBoard를 눌렀을 때 발생하는 이벤트이다.<br>
* 지정된 길이가 넘어가면 focus()를 다음 Object로 넘긴다.<br>
* <br><b>Example :</b>
* <pre>
*    ssvc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift);
* </pre>
* @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @param   {string} KeyCode 필수 아스키 코드값
* @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
* @return 없음
* @author 공백진
* @version 2009.04.17
*/      	
function ssvc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
	var svcScpCdTxt = comboObj.Text;

	if (svcScpCdTxt.length > 3) {
		document.form.svc_scp_nm.focus();
	}
}

/**
* IBMulti Combo에서 모든 Item이 삭제 되었을 경우 발생하는 이벤트이다.<br>
* Scope 의 Name 의 값을 Clear한다.<br>
* <br><b>Example :</b>
* <pre>
*    ssvc_scp_cd_OnClear(comboObj);
* </pre>
* @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @return 없음
* @author 공백진
* @version 2009.04.17
*/ 	
function ssvc_scp_cd_OnClear(comboObj) {
	var formObject = document.form;
	formObject.svc_scp_nm.value = "";
	
	comboObj.Index = -1;
}  	

/**
* 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
* <br><b>Example :</b>
* <pre>
*    
* </pre>
* @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @param   {string} KeyCode 필수 아스키 코드값
* @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
* @return 없음
* @author 공백진
* @version 2009.04.17
*/
function ssvc_scp_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 13) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
	}
}     

/**
* 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
* <br><b>Example :</b>
* <pre>
*    
* </pre>
* @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @param   {string} KeyCode 필수 아스키 코드값
* @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
* @return 없음
* @author 공백진
* @version 2009.04.17
*/
function sprop_sts_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 13) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
	}
}  	

/**
* 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
* <br><b>Example :</b>
* <pre>
*    
* </pre>
* @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @param   {string} KeyCode 필수 아스키 코드값
* @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
* @return 없음
* @author 공백진
* @version 2009.04.17
*/
function srfa_ctrt_tp_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 13) {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
	}
}  	

 /**
 * OnSort 이벤트 발생시 호출되는 function <br>
 * 해당 컬럼 Sort후 데이터를 다시 조회한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *		
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int}     Col 소트가 처리된 Column Index
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */       
 function sheet0_OnSort(sheet, Col) {  
	 var row = sheet.SelectRow;
	 sheet0_OnSelectCell(sheet, -1, -1, row, 1);    	 
 }

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * sheet조회 후 sheet의 값을 Html Object의 값으로 setting 한다.<br>
 * <br><b>Example :</b>
 * <pre>
 * 	sheet0_OnSearchEnd(sheetObj, errMsg)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 공백진
 * @version 2009.05.20
 */ 
function sheet0_OnSearchEnd(sheetObj, errMsg){
    var formObj = document.form;
    formObj.prop_no.value = sheetObj.CellValue(sheetObj.SelectRow,"prop_no");
    formObj.amdt_seq.value = sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq");
    
}

/**
* OnSelectCell 이벤트 발생시 호출되는 function <br>
* Proposal No 와 Amdt Seq No로 조회한다. <br>
* <br><b>Example :</b>
* <pre>
*		sheet0_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
* @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
* @param {int} NewRow 필수 현재 선택된 셀의 Row Index
* @param {int} NewCol 필수 현재 선택된 셀의 Column Index
* @return 없음
* @author 공백진
* @version 2009.04.17
*/  
function sheet0_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {        
 	if(OldRow!=NewRow){
        var formObj = document.form;
        formObj.prop_no.value = sheetObj.CellValue(NewRow,"prop_no");
        formObj.amdt_seq.value = sheetObj.CellValue(NewRow,"amdt_seq");
 		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);

     }
 }   


/**
* OnSearchEnd 이벤트 발생시 호출되는 function <br>
* sheet조회 후 sheet의 값을 Html Object의 값으로 setting 한다.<br>
* <br><b>Example :</b>
* <pre>
* 	sheet1_OnSearchEnd(sheetObj, errMsg)
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @param {string} ErrMsg 필수 서버에서 넘어온 메세지
* @return 없음
* @author 공백진
* @version 2009.05.20
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj = document.form;
	formObj.rfa_no.value = sheetObj.CellValue(1, "rfa_no");
	formObj.prop_no.value = sheetObj.CellValue(1, "prop_no");
	formObj.amdt_seq.value = sheetObj.CellValue(1, "amdt_seq");
	formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "ctrt_eff_dt"), "ymd");
	formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "ctrt_exp_dt"), "ymd");

	formObj.prop_sts.value = sheetObj.CellValue(1, "prop_sts");
	formObj.prop_ofc_cd.value = sheetObj.CellValue(1, "prop_ofc_cd");
    // Request Office가 BOMSC일 경우 Arbitrary Tab 추가
    setTabEnable(3, (sheetObj.CellValue(1,"prop_ofc_cd") == "BOMSC") ? true : false);
   	
	formObj.prop_srep_cd.value = sheetObj.CellValue(1, "prop_srep_cd");
	formObj.prop_srep_nm.value = sheetObj.CellValue(1, "prop_srep_nm");
	formObj.prop_apro_ofc_cd.value = sheetObj.CellValue(1, "prop_apro_ofc_cd");
	formObj.prop_apro_staff.value = sheetObj.CellValue(1, "prop_apro_staff");
	formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "cre_dt"), "ymd");
	formObj.prop_apro_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "prop_apro_dt"), "ymd");
	formObj.ctrt_cust_cnt_cd.value = sheetObj.CellValue(1, "ctrt_cust_cnt_cd");
	if (sheetObj.CellValue(1, "ctrt_cust_seq") != "") {
		formObj.ctrt_cust_seq.value = ComLpad(sheetObj.CellValue(1, "ctrt_cust_seq"), 6, "0");
	} else {
		formObj.ctrt_cust_seq.value = "";
	}

	formObj.sls_ld_no.value = sheetObj.CellValue(1, "sls_ld_no");
	formObj.ctrt_pty_nm.value = sheetObj.CellValue(1, "ctrt_pty_nm");
	formObj.prc_ctrt_cust_tp_nm.value = sheetObj.CellValue(1, "prc_ctrt_cust_tp_nm");
	formObj.ctrt_cust_val_sgm.value = sheetObj.CellValue(1, "ctrt_cust_val_sgm");
	formObj.respb_sls_ofc_cd.value = sheetObj.CellValue(1, "respb_sls_ofc_cd");
	formObj.respb_srep_cd.value = sheetObj.CellValue(1, "respb_srep_cd");
	formObj.ctrt_cust_srep_nm.value = sheetObj.CellValue(1, "ctrt_cust_srep_nm");

	formObj.tgt_mvc_qty.value = ComAddComma(sheetObj.CellValue(1, "tgt_mvc_qty"));
	formObj.cntr_lod_ut_cd.value = sheetObj.CellValue(1, "unit");
	formObj.dmdt_ft_tp_cd.value = sheetObj.CellValue(1, "dmdt_ft_tp_cd");

	if (formObj.dmdt_ft_tp_cd.value != "Exception") {
		ComBtnDisable("btn_dem_pop");
		document.getElementById("btn_dem").style.color = "";
	} else {
		ComBtnEnable("btn_dem_pop");
		document.getElementById("btn_dem").style.color = "black";
	}

	// PRS
	formObj.prs_crnt_cm_amt.value = ComAddComma(sheetObj.CellValue(1, "prs_crnt_cm_amt"));
	formObj.prs_estm_cm_amt.value = ComAddComma(sheetObj.CellValue(1, "prs_estm_cm_amt"));
	formObj.prs_sum_cm_amt.value = ComAddComma(parseInt(sheetObj.CellValue(1, "prs_crnt_cm_amt")) + parseInt(sheetObj.CellValue(1, "prs_estm_cm_amt")));
	formObj.rfa_ctrt_tp_cd.value = sheetObj.CellValue(1, "rfa_ctrt_tp_cd");
} 


/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * MQC를 계산하기 위하여 추가한 컬럼에 값을 채워 넣는다.
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 공백진
 * @version 2009.05.20
 */         
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var sheetObj = sheetObjects[1];
	var formObj = document.form;
	for ( var i = 1; i <= getValidRowCount(sheetObj); i++) {
		if (preSvcScpCd == sheetObj.CellValue(i, "svc_scp_cd")) {
			sheetObj.SelectCell(i, 0);
			break;
		}
	}
}

/**
 * OnSelectCell 이벤트 발생시 호출되는 function <br>
 * 선택한 Scope에 해당하는 Terms의 데이터를 Frame에 Load 하고 Tab의 아이콘을 변경한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
 * </pre>
 * 
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
 * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
 * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
 * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */
function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	try {
		ComOpenWait(true); // ->waiting->start
		if (sheetObj.CellValue(NewRow, "svc_scp_cd") != "" && OldRow != NewRow && sheetObj.CellValue(NewRow, "ibflag") != "I") {
			comApplyStyleProposalStatusSummary(sheetObj.CellValue(NewRow, "svc_scp_cd"));
			tab1_OnChange(tabObjects[0], tabObjects[0].SelectedIndex); 
//			loadTabPage(beforetab, NewRow);
			setTabText();
		} else if (sheetObj.CellValue(NewRow, "ibflag") == "I") {
			if (NewRow != OldRow) {
				clearAllTabPages();
			}
		}
		ComOpenWait(false); // ->waiting->End
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
		ComOpenWait(false); // ->waiting->End
	}
}

 /**
  * OnPopupClick 이벤트 발생시 호출되는 function <br>
  * Scope Duration 를 호출한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibsheet} sheetObj 필수 IBSheet Object
  * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
  * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
  * @return 없음
  * @author 공백진
  * @version 2009.05.07
  */    
function sheet2_OnPopupClick(sheetObj, Row, Col)
{
    var colName = sheetObj.ColSaveName(Col);
    var formObj = document.form;
      
    switch(colName)
    {
        case "scp_dur_pop":
            if (formObj.prop_no.value ==""){
                ComShowCodeMessage('PRI01021');
                return;
            }               
            var sSvcScpCd ="&sSvcScpCd=" + sheetObj.CellValue(Row, "svc_scp_cd");
            var sParam = getParameters(colName, sSvcScpCd);                
            var rtnVal = ComPriOpenWindowCenter ("/hanjin/ESM_PRI_2010.do?"+sParam, "", 635, 320, true);
           
            if (rtnVal != null && rtnVal =="Y"){
                doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);    
            }  
            break;
    }
}           



/**
* MQC값으로 MVC 값을 계산한다.<br>
* 계산식은 MVC = MQC / Duration 유효 일수 x 7 이다. <br>
* <br><b>Example :</b>
* <pre>
*		calcMVC();
* </pre>
* @param  없음
* @return 없음
* @author 공백진
* @version 2009.05.07
*/ 
function calcMVC(){
    var formObj = document.form;
    var mqcQty = sheetObjects[1].CellValue(1, "tgt_mvc_qty");
    var sDay = formObj.ctrt_eff_dt.value;
    var eDay = formObj.ctrt_exp_dt.value;
    
    var mvcQty = 0;     
    var durDay = ComGetDaysBetween(sDay, eDay);
    if (mqcQty != "" && mqcQty != "0"){
        if (durDay != 0){
        	mvcQty = ComRound((mqcQty / durDay * 7),0);
        }        	
    }   
    formObj.prop_mvc.value = ComAddComma(mvcQty);        
    formObj.prop_mvc_tp.value = formObj.cntr_lod_ut_cd.value;
    
}   




/**
 * 입력한 Customer Sale Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *		setCustSaleRep();
 * </pre>
 * @param  없음
 * @return 없음
 * @author 공백진
 * @version 2009.05.07
 */  
function setCustSaleRep(){              
    var formObj = document.form;
    var sheetObj = sheetObjects[1];
    if (formObj.ctrt_cust_cnt_cd.value !="" && formObj.ctrt_cust_seq.value !=""){         
        formObj.f_cmd.value = COMMAND20;       
       
        sParam = FormQueryString(formObj) +"&etc1="+formObj.respb_sls_ofc_cd.value;
        sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
        ComPriXml2ComboItem(sXml, formObj.respb_srep_cd, "cd", "cd|nm");
        }
    }
 
        
    /**
* 입력한 Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다. <br>
* <br><b>Example :</b>
* <pre>
*		setRequestOfficeSaleRep();
* </pre>
* @param  없음
* @return 없음
* @author 공백진
* @version 2009.05.07
*/  
function setRequestOfficeSaleRep(){
    var formObj = document.form;
    var sheetObj = sheetObjects[1];
    
    formObj.f_cmd.value = SEARCH15;     
    var sParam = FormQueryString(formObj) +"&etc1="+formObj.prop_ofc_cd.value;
    var sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
    ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm");

}

/**
* SaleRep.의 Office Code를 조회한다.<br>
* <br><b>Example :</b>
* <pre>
*		getOfficeCd(srepCd);
* </pre>
* @param  {string} srepCd 필수 sale rep. code
* @return  string  Office Code
* @author 공백진
* @version 2009.05.07
*/  
function getOfficeCd(srepCd){       
    document.form.f_cmd.value = COMMAND21;
    var sParam = FormQueryString(document.form)+"&etc1="+srepCd;
    var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", sParam);
    var arrData = ComPriXml2Array(sXml, "cd");
    if (arrData != null && arrData.length > 0) {
        return arrData[0];
    }                                   
    return null;
}

/**
* Customer에 관련된 Html Object의 값을 clear 한다.<br>
* <br><b>Example :</b>
* <pre>
*		clearCustName();
* </pre>
* @param  없음
* @return 없음
* @author 공백진
* @version 2009.05.07
*/  
function clearCustName(){
    var formObj = document.form;
    var sheetObj = sheetObjects[1];
    
    sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd") = "";
    sheetObj.CellValue(1,"ctrt_pty_nm") = "";
    sheetObj.CellValue(1,"ctrt_cust_val_sgm_cd") = "";
    sheetObj.CellValue(1,"ctrt_cust_val_sgm") = "";
    sheetObj.CellValue(1,"respb_srep_cd") = "";
    sheetObj.CellValue(1,"respb_sls_ofc_cd") = "";
    sheetObj.CellValue(1,"prc_ctrt_cust_tp_nm") = "";

    formObj.ctrt_cust_cnt_cd.value = "";
    formObj.ctrt_cust_seq.value = "";
    formObj.ctrt_pty_nm.value = "";
    formObj.respb_srep_cd.value = "";
    formObj.ctrt_cust_val_sgm.value = "";
    formObj.respb_sls_ofc_cd.value = "";
    formObj.ctrt_cust_srep_nm.value = "";
    formObj.prc_ctrt_cust_tp_nm.value ="";
    
}


/**
 * 메인,Scope에 속해 있는 각 Terms의 상태변경,데이터 추가 에 따라 해당 Tab의 아이콘을 변경한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *    comApplyStyleProposalStatusSummary(termTpCd, svcScpCd);
 * </pre>
 * @param   {string} svcScpCd 선택   Scope 코드
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */ 
 function comApplyStyleProposalStatusSummary(svcScpCd) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH04;
	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2019GS.do", FormQueryString(formObj) + "&svc_scp_cd=" + svcScpCd);
	var arrText = ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
	var icon = "";
	var tabIdx = "";
	var imgName = "";
	var expDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
	for (i = 0; i < arrText.length; i++) {
		tabIdx = "";
		imgName = "";
		switch (arrText[i][0]) {
		case '01': //Duration,Scope Duration
			imgName = "";
			break;
		case '02': //MQC,Scope MQC
			imgName = "";
			break;
		case '05':
			imgName = "img_affil";
			break;
		case '08':
			imgName = "";
			break;
		case '13': //Group Location
			tabIdx = "1";
			break;
		case '14': //Group Commodity
			tabIdx = "2";
			break;
		case '32': //Special Note
			tabIdx = "4";
			break;
		case '52': //Arbitrary                 
			tabIdx = "3";
			break;
		case '71': //Rate   
			tabIdx = "0";
			break;
		}
		icon = ICON_URL_NOT_EXIST;
		switch (arrText[i][1]) {
		case "1":
		case "2":
		case "3":
			icon = ICON_URL_EXIST;
			break;
		}
		// 기본 : Black , Amend시 : Red, All Accept시 : Blue
		if (arrText[i][0] == "01" || arrText[i][0] == "02" || arrText[i][0] == "05" || arrText[i][0] == "08") {
			if (imgName != "")
				document.images(imgName).src = icon;
		} else {
			if (tabIdx != "")
				tabObjects[0].ImageUrl(tabIdx) = icon;
		}
	}
}
  
    
     /**
 * Pop화면 호출시 공통적으로 넘겨주는 Parameter를 생성한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *    getParameters(srcName, param);
 * </pre>
 * @param   {string} srcName 필수  Html Object Name
 * @param   {string} param   선택  화면별로 넘겨주는 Parameter
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */   
 function getParameters(srcName, param){        
     var sheetObj = sheetObjects[1];
     var sRfaNo = sheetObj.CellValue(1,"rfa_no");
     var sPropNo = sheetObj.CellValue(1,"prop_no");
     var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
     var sSvcScpCd = "";
     var aParam = "";
     var sCtrtEffDt = document.form.ctrt_eff_dt.value;
     var sCtrtExpDt = document.form.ctrt_exp_dt.value;  
     
     var sParam = "sRfaNo="+sRfaNo+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq;

     switch (srcName) {        
        case "btn_afil_pop":
            aParam = "&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt;               
            sParam += aParam;
            break;
        } 
     
     return sParam;
 }
 
 /**
 * Customer Type을 Return한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     getCustTpCd()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */      
function getCustTpCd(){
    var custTpCd = "";
    var sheetObj = sheetObjects[1];
    custTpCd = sheetObj.CellValue(1, "prc_ctrt_cust_tp_cd");
    
    return custTpCd;
}

/**
* IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
* Combo의 text값을 Html Object에 표시한다. <br>
* <br><b>Example :</b>
* <pre>
*    prop_srep_cd_OnBlur(comboObj);
* </pre>
* @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
* @return 없음
* @author 공백진
* @version 2009.04.17
*/ 
function prop_srep_cd_OnBlur(comboObj) {
    var formObj = document.form;        
    var code = comboObj.FindIndex(comboObj.Code, 0);
    
    if (code != null && code != "") {
        var text = comboObj.GetText(code, 1);
        if (text != null && text != "" && text != formObj.prop_srep_nm.value) {
            formObj.prop_srep_nm.value = comboObj.GetText(code, 1);

        }
    }
}     


/**
 * 화면의 지정된 부분을 숨기거나 표시하여 화면을 넓게 쓸수 있게한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *    setControlHidden();
 * </pre>
 * @param  없음
 * @return 없음
 * @author 공백진
 * @version 2009.04.17
 */   
function setControlHidden(){
	if (!controlHidden){
		document.all.subterms.style.display = "none";
		controlHidden = true;
	}else{
		document.all.subterms.style.display = "inline";
		controlHidden = false;
		sheet1_OnSearchEnd(sheetObjects[1], "");
	}
	try{
	    parent.syncHeight();  // 펼쳤을때 화면하단 안보이는 문제 해결
		}catch(e){}
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
 * @author 공백진
 * @version 2009.04.17
 */ 
function btnImgEnable(obj, gb) {
    if(obj.constructor == String){
        obj = document.getElementsByName(obj)[0];            
    }
    var btnStyle = obj.style;

    if (gb){           
        obj.Enable = true;
        btnStyle.cursor = "hand";
        btnStyle.filter="";
        obj.disabled = false;
    } else {         
        obj.Enable = false;            
        btnStyle.cursor = "auto";
        btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
        obj.disabled = true;   
    }    
}

/**
* Customer에 관련된 정보를 조회한다.<br>
* <br><b>Example :</b>
* <pre>
*		custNameFind(eleName);
* </pre>
* @param  {string} eleName 필수 Html Object Name
* @return 없음
* @author 공백진
* @version 2009.05.07
*/     
function sCustNameFind(eleName) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var cust_cnt_cd = formObj.scust_cnt_cd.value;
	var cust_seq = formObj.scust_seq.value;

	if (cust_cnt_cd != "" && cust_seq != "") {
		var sParam = "f_cmd=" + SEARCH02 + "&cust_cnt_cd=" + cust_cnt_cd + "&cust_seq=" + cust_seq;

		var sXml = sheetObj.GetSearchXml("ESM_PRI_2019GS.do", sParam);
		var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm|oti_no");
		if (arrText == undefined) {
			formObj.scust_cnt_cd.value = "";
			formObj.sctrt_pty_nm.value = "";
			formObj.scust_seq.value = "";
			formObj.scust_cnt_cd.focus();
		} else {
			formObj.sctrt_pty_nm.value = arrText[0][1];
		}
	}
}

/**
 * Hinterland 관련<BR>
 * Scope에 따라 적절한 Arbitrary, Rate Tab을 활성화한다.<BR>
 * <br><b>Example :</b>
 * <pre>
 * 	getTabIndex(tabInfo, tabName)
 * </pre>
 * @param {String} tabInfo Tab Information
 * @param {String} tabName Tab header name want to find.
 * @return Number tab index.
 * @author Hyuk Ryu
 * @version 2012.05.08
 */
function getTabIndex(tabInfo, tabName){
	var index = -1;
	var tabs = tabInfo.split("|");
	for(var i=0; i<tabs.length; i++){
		if(tabName == tabs[i].split(",")[1]){
			index = i;
			break;
		}
	}
	return index;
}

/**
 * Tab Text변경
 */
function setTabText() {
	//SPOT
/*	var index = checkArbiRate();
	if (index == 0 || index == 2) {
		tabObjects[0].TabText(0) = "Rate";
		tabObjects[0].TabText(3) = "Arbitrary";
	} else if (index == 1) {
		tabObjects[0].TabText(0) = "Rate For AEE/AEW";
		tabObjects[0].TabText(3) = "Arbitrary For AEE/AEW";
	}*/
}

/**
 * Hinterland 관련<BR>
 * 지정한 탭의 enable/disable을 설정한다.<BR>
 * <br><b>Example :</b>
 * <pre>
 * 	setTabEnable(tabObj, enable)
 * </pre>
 * @param {Number} tabIdx Target Tab Index
 * @param {boolean} enable Flag for enable/disable.
 * @return Number tab index.
 * @author Hyuk Ryu
 * @version 2012.05.08
 */
function setTabEnable(tabIdx, enable){
	if(tabObjects[0].TabEnable(tabIdx) != enable){
		tabObjects[0].TabEnable(tabIdx) = enable;
	}
}

 /**
 * Hinterland Project에 따른 Arbitrary/Rate 구분
 */
/*
function checkArbiRate() {
	var formObj = document.form;
	var rsltIndex = 0;
	var svcScpCd = sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "svc_scp_cd");
	var expDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
	
	if(ComCheckGuideExcepSvcScpCd(svcScpCd)) {
		rsltIndex = 0;
	} else {
	 	if (addOnEndExpDt > expDt  && expDt > endExpDt && ("AEW" == svcScpCd || "AEE" == svcScpCd)) {
			rsltIndex = 1;
		} else if(addOnEndExpDt <= expDt) {
			rsltIndex = 2;
		} else {
			rsltIndex = 0;
		}
	}
	return rsltIndex;
}
*/
/* 개발자 작업 끝 */    