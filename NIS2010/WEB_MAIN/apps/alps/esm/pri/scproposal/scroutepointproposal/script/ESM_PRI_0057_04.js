/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057_04.js
*@FileTitle : Amendment History Inquiry - Origin/Destination
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.21 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
* *2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
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
 * @class ESM_PRI_0057_04 : ESM_PRI_0057_04 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_0057_04() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var tabLoad = new Array();
tabLoad[0]= 0;
tabLoad[1]= 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.10.28
 */
function processButtonClick(){
     /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

     var sheetObject1 = sheetObjects[0];
     
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
       	if (getButtonTable(srcName).disabled) {
       		return false;
       	}
       }
        switch(srcName) {
	
			case "btn_retrieve":
				if(validateForm(sheetObject1,formObject,IBSEARCH)) {
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				} 
			break;
        } // end switch
	}catch(e) {
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
 * @author 최성민
 * @version 2009.10.28
 */
function setSheetObject(sheet_obj){

   sheetObjects[sheetCnt++] = sheet_obj;

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
 * @author 최성민
 * @version 2009.05.17
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++){

    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
    // khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

	initControl();    
	loadSts = true;
	parent.loadTabPage();
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
 * @author 최성민
 * @version 2009.05.22
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
	 var sheetID = sheetObj.id;

    switch(sheetID) {

        case "sheet1":

        	 with (sheetObj) {
                 // 높이 설정
                 style.height = 280;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 // Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 // 전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msNone;

                // 전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 var HeadTitle = "|Sel.|Seq.|amdt_seq|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date" +
                 		"|1|2|3|4|5|6";
                 var headCount = ComCountHeadTitle(HeadTitle);

                 // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,
					// HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);

                 // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
					// COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC,
					// DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
					// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
					// ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
				 InitDataProperty(0, cnt++ , dtHidden,     	40,    	daCenter,  	false,	"chk");
                 InitDataProperty(0, cnt++ , dtDataSeq,   	30,    	daCenter,  	false, 	"seq");
                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
                 InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false, 	"rout_pnt_seq");
                 InitDataProperty(0, cnt++ , dtCombo,     	90,   	daCenter,  	false,	"rout_pnt_loc_tp_cd",	false,	"",      dfNone, 			0,     false,       false);
				 
                 InitDataProperty(0, cnt++ , dtData, 		90,   	daCenter,  	false,	"rout_pnt_loc_def_cd",	false,	"",      dfNone, 			0,     false,       false, 5);
                 InitDataProperty(0, cnt++ , dtData,      	280,   	daLeft, 	false,	"rout_pnt_loc_def_nm",	false,	"",      dfNone, 			0,     false,      false);
				 InitDataProperty(0, cnt++ , dtData,      	75,    	daCenter,  	false,	"eff_dt",    	  		false,	"",      dfDateYmd, 		0,     false,      false);
                 InitDataProperty(0, cnt++ , dtData,      	75,    	daCenter,  	false,	"exp_dt",      			false,	"",      dfDateYmd, 		0,     false,      false);
				 InitDataProperty(0, cnt++ , dtCombo,      	60,    	daCenter,  	false,	"src_info_cd",			false,	"",      dfNone, 			0,     false,      false);
				 
				 InitDataProperty(0, cnt++ , dtCombo,      	60,		daCenter,  	false,	"prc_prog_sts_cd",		false,	"",      dfNone, 			0,     false,      false);
				 InitDataProperty(0, cnt++ , dtData,      	140,	daLeft,  	false,	"acpt_usr_nm",			false,	"",      dfNone, 			0,     false,      false);
				 InitDataProperty(0, cnt++ , dtData,      	50,		daCenter,  	false,	"acpt_dt",				false,	"",      dfDateYmd, 		0,     false,      false);
				 
				 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "svc_scp_cd");
                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "prop_no");
                 InitDataProperty(0, cnt++ , dtHidden,    	 	40, 	daCenter,  	false,  "org_dest_tp_cd"); 
                 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"src_info_dtl");
				 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"prc_prog_sts_dtl");
				 InitDataProperty(0, cnt++ , dtHidden, 			80, 	daCenter, 	false, 	"n1st_cmnc_amdt_seq");

				 InitDataCombo(0, "rout_pnt_loc_tp_cd", LOCATION_TYPE1[1], LOCATION_TYPE1[0], " ", " ", 0);
				 InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");            
				 InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue, "", "I");
                
                 //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 				 InitDataValid(0,  "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

				 ShowButtonImage = 2;
                 WaitImageVisible = false;
				 
            }
             break;
    }
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
 * @author 최성민
 * @version 2009.05.22
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	try {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	     case IBSEARCH_ASYNC01: 
	 		ComOpenWait(true);
	    	formObj.f_cmd.value = SEARCH02;	 	        
			var sXml = sheetObj.GetSearchXml("ESM_PRI_0057_04GS.do" , FormQueryString(formObj));
			var arrData = ComPriXml2Array(sXml, "org_dest_tp_cd|amend_cnt");
			
			var origin = 0;
			var destin = 0;
			var oriRed = false;
			var destRed = false;
			if(arrData != null && arrData.length > 0) {
				for(var i=0; i<arrData.length; i++ ){
					if(arrData[i][0] == "D") {
						destin ++;
						if(arrData[i][1] > 0) {
							destRed = true;
						}
					} else {
						origin ++;
						if(arrData[i][1] > 0) {
							oriRed = true;
						}
					}
				}
			}
			
			if(origin == 0 && destin > 0) {
				formObj.org_dest_tp_cd[1].checked = true;
			} else {
				formObj.org_dest_tp_cd[0].checked = true;
			}
			

	    	var sLgcyIfFlg = formObj.lgcy_if_flg.value;
			
			if(origin > 0) {
				document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
				if(oriRed && sLgcyIfFlg != "Y") {
					document.getElementById("org_dest_tp_cd1").style.color = "blue";
				} else {
					document.getElementById("org_dest_tp_cd1").style.color = "black";
				}
			} else {
				document.getElementById("org_dest_tp_cd1").style.fontWeight = ""; 	
				document.getElementById("org_dest_tp_cd1").style.color = "black";
			}
			
			if(destin > 0) {
				document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
				if(destRed && sLgcyIfFlg != "Y") {
					document.getElementById("org_dest_tp_cd2").style.color = "blue";
				} else {
					document.getElementById("org_dest_tp_cd2").style.color = "black";
				}
			}else {
				document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
				document.getElementById("org_dest_tp_cd2").style.color = "black";
			}
			break;
		
	    case IBSEARCH: // 조회
			ComOpenWait(true);
	     	formObj.f_cmd.value = SEARCH01;
			sheetObj.DoSearch("ESM_PRI_0057_04GS.do", FormQueryString(formObj));
			break;
	    }
	}catch(e){
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}finally {
		ComOpenWait(false);
	}
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
* @author 최성민
* @version 2009.10.28
*/
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;

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
  * @returns bool <br>
  *          true  : 폼입력값이 유효할 경우<br>
  *          false : 폼입력값이 유효하지 않을 경우
  * @author 최성민
  * @version 2009.04.17
  */
 function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
	case IBSEARCH: // 조회		
  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
			return false;
		}
		break;    
	}
   return true;
 }
    

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 * @return 없음
 * @author 최성민
 * @version 2009.04.17
 **/
function initControl() {    	
	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm  ('click', 'obj_OnClick', form); 
}

 /**
  * HTML Control의 onClick이벤트에서 Validation을 체크한다. <br>
  * @return 없음
  * @author 최성민
  * @version 2009.04.17
  **/
function obj_OnClick(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	
	if (event.srcElement.name == "org_dest_tp_cd") {   	   			
		formObj.org_dest_tp_cd.value = ComGetObjValue(formObj.org_dest_tp_cd);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		
	}
}
   		
/**
* OnSearchEnd 이벤트 발생시 호출되는 function <br>
* <br><b>Example :</b>
* <pre>
* 
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @param {string} ErrMsg 필수 서버에서 넘어온 메세지
* @return 없음
* @author 최성민
* @version 2009.05.20
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg){
	manageCellEditable (sheetObj);
}  
     	    
/**
 * SHEET의 CELL 수정권한을 제어하는 function <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 * 	manageCellEditable (sheetObj);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return 없음
 * @author 최성민
 * @version 2009.04.17
 */
 function manageCellEditable (sheetObj) {
	    	  		
	 var formObj 		= document.form;
	 var amdt_seq 		= formObj.amdt_seq.value;
	 var sLgcyIfFlg		= formObj.lgcy_if_flg.value;
	
	 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
		  
		  if(sheetObj.CellValue(i,"amdt_seq") != amdt_seq){ 
			  sheetObj.CellFont("FontStrikethru", i, "chk", i, sheetObj.LastCol)=true;
		  }
			
		  if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") ==  amdt_seq && sLgcyIfFlg != "Y"){
			  sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);	
		  }
	 }
 }

 
 /**
  * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
  * 화면이 보여지며 조회를 한다.<br>
  * <br><b>Example :</b>
  * <pre>
  * tabLoadSheet("ACE", "1")
  * </pre>
  * @param {string} sPropNo 필수 prop_no 값
  * @param {string} sAmdtSeq 필수 amdt_seq 값
  * @param {string} sSvcScpCd 필수 svc_scp_cd 값
  * @param {string} sConChk 필수 Conversion check 값
  * @return 없음
  * @author 최성민
  * @version 2009.05.21
  */ 
 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
 	var formObject = document.form;
 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
 		formObject.prop_no.value = sPropNo;
 		formObject.amdt_seq.value = sAmdtSeq;
 		formObject.svc_scp_cd.value = sSvcScpCd;
 		formObject.con_chk.value = sConChk;
 		formObject.con_flg.value = sConChk;
		formObject.lgcy_if_flg .value = sLgcyIfFlg ;

		document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
		document.getElementById("org_dest_tp_cd1").style.color = "black";  	  			
		document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
		document.getElementById("org_dest_tp_cd2").style.color = "black";
	
		// 페이지로딩시 데이터가 존재하는 ROUTE TYPE을 자동으로 선택하게 한다.
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
 		
 	}
 }
	
/**
 * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
 * <br><b>Example :</b>
 * <pre>
 * tabClearSheet()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 최성민
 * @version 2009.05.20
 */ 
function tabClearSheet() {
	var formObject = document.form;

	formObject.prop_no.value = "";
	formObject.amdt_seq.value = "";
	formObject.svc_scp_cd.value = "";
	
	sheetObjects[0].RemoveAll();
}

var enableFlag = true;

/**
 * 메인에서 호출하는 function <br>
 * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * tabEnableSheet(flag)
 * </pre>
 * 
 * @param {boolean}
 *            flag 필수 메인화면에서 넘긴다.
 * @return 없음
 * @author 최성민
 * @version 2009.04.17
 */
function tabEnableSheet(flag) {
	var formObject = document.form;
	
	enableFlag = flag;
}
  	     
var loadSts = false;
/**
 * 메인에서 호출하는 function <br>
 *  <br>
 * <br><b>Example :</b>
 * <pre>
 *loadFinishCheck()
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.05.19
 */
function loadFinishCheck(){
    return loadSts;
}     


    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 문동규
     * @version 2009.04.17
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }

   	/* 개발자 작업  끝 */