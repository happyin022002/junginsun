/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0057_01.js
*@FileTitle : Amendment History Inquiry - MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.08 공백진
* 1.0 Creation
* 
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
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
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
 * @author 공백진
 * @version 2009.04.17
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++){
    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
    // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }                      
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
 * @author 공백진
 * @version 2009.04.17
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;
	 var sheetID = sheetObj.id;

    switch(sheetID) {

        case "sheet1":
            with (sheetObj) {

                // 높이 설정
                style.height = 122;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 7, 100);
                
                var HeadTitle1 = "|Seq.|Unit|Proposal|C/Offer|Final|EFF Date|EXP Date|Souce|Status|Accept Staff/Team|Accept Date||";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ ,	dtHiddenStatus,	40,	 daCenter, true,  "ibflag");
                InitDataProperty(0, cnt++ ,	dtSeq,			30,	 daCenter, true,  "seq");
                InitDataProperty(0, cnt++ , dtData,			60,	 daCenter, false, "cntr_lod_ut_nm",	  false, "", dfNone,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtData,			90,	 daCenter, false, "prop_scp_mqc_qty", false, "", dfNone,	0,	false,	true,		6);
                InitDataProperty(0, cnt++ , dtData,			90, daCenter, false, "coffr_mqc_qty",	  false, "", dfNone,	0,	false,	true,		6);
                InitDataProperty(0, cnt++ , dtData,			90,	 daCenter, false, "fnl_mqc_qty", 	  false, "", dfNone,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			90, daCenter, false, "eff_dt",			  false, "", dfDateYmd,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			90, daCenter, false, "exp_dt",			  false, "", dfDateYmd,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			90, daCenter, true,  "src_info_nm",      false, "", dfNone,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtData,			80,	 daCenter, true,  "prc_prog_sts_nm",  false, "", dfNone,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			140, daLeft, false, "acpt_usr_nm",	  false, "", dfNone,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtData,			100, daCenter, false, "acpt_dt",		  false, "", dfDateYmd,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "amdt_seq",         false, "", dfNone,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "n1st_cmnc_amdt_seq",      false, "", dfNone,	0,	false,	true);

				CountPosition = 0;		// Total 없음.
				WaitImageVisible = false;
			}
            break;
        case "sheet2":

            with (sheetObj) {

                // 높이 설정
                style.height = 122;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 7, 100);
                
                var HeadTitle1 = "|Seq.|Sub MQC|EFF Date|EXP Date|Souce|Status|Accept Staff/Team|Accept Date||";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ ,	dtHiddenStatus,	40,	 daCenter, true,  "ibflag");
                InitDataProperty(0, cnt++ ,	dtSeq,			50,	 daCenter, true,  "seq");
                InitDataProperty(0, cnt++ , dtData,			90,	 daCenter, false, "sub_mqc_ctnt", 	  false, "", dfNone,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			100, daCenter, false, "eff_dt",			  false, "", dfDateYmd,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			100, daCenter, false, "exp_dt",			  false, "", dfDateYmd,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			100, daCenter, true,  "src_info_nm",      false, "", dfNone,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtData,			80,	 daCenter, true,  "prc_prog_sts_nm",  false, "", dfNone,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtData,			140, daLeft, false, "acpt_usr_nm",	  false, "", dfNone,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtData,			100, daCenter, false, "acpt_dt",		  false, "", dfDateYmd,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "amdt_seq",         false, "", dfNone,	0,	false,	true);
                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "n1st_cmnc_amdt_seq",      false, "", dfNone,	0,	false,	true);

				CountPosition = 0;		// Total 없음.
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
 * @author 공백진
 * @version 2009.04.17
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
    try{
        switch(sAction) {	
		    case IBSEARCH: // 조회
		    	ComOpenWait(true); //->waiting->start
		     	formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_PRI_0057_02GS.do", FormQueryString(formObj));
							
				break;
		    case IBSEARCH_ASYNC01: // 조회
		    	ComOpenWait(true); //->waiting->start
		     	formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch("ESM_PRI_0057_02GS.do", FormQueryString(formObj));
				if (sheetObj.RowCount > 0) {
					document.getElementById("sub_mqc").style.display = "inline";
				}else{
					document.getElementById("sub_mqc").style.display = "none";
				}
				break;	    					
	    }    	
    } catch (e) {
       	if (e == "[object Error]") {
             ComShowMessage(OBJECT_ERROR);
         } else {
             ComShowMessage(e);
         }
     }finally{
     	ComOpenWait(false); //->waiting->End
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
  * OnSearchEnd 이벤트 발생시 호출되는 function <br>
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
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj = document.form;
		var sCols = "";
		searchEndFontChange(sheetObj, sCols, document.form.lgcy_if_flg.value);
     
	} 
  
  /**
   * OnSelectCell 이벤트 발생시 호출되는 function <br>
   * <br><b>Example :</b>
   * <pre>
   *		
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
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
       if (OldRow != NewRow) {
           changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
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
   * @author 공백진
   * @version 2009.05.20
   */ 		
 	function sheet2_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		var sCols = "";
 		searchEndFontChange(sheetObj, sCols, document.form.lgcy_if_flg.value);
      
 	}   
   
   /**
    * OnSelectCell 이벤트 발생시 호출되는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *		
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
 	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
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
  * @param {string} sLgcyIfFlg 필수 lgcy_if_flg 값
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
 		formObject.lgcy_if_flg.value = sLgcyIfFlg;
 		formObject.con_flg.value = sConChk;
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
 	
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
	sheetObjects[1].RemoveAll();
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
	sheetObjects[0].Editable = flag;
}
var loadSts = false;

/**
* parent 화면에서 탭 화면이 Frame에 Load 되었는지 확인하는 function <br>
* <br><b>Example :</b>
* <pre>
* 		loadFinishCheck()
* </pre>
* @param 없음
* @return bool  loadSts  <br>
* 				true  : load 완료
* 				false : load 미완료
* @author 공백진
* @version 2009.05.20
*/ 
function loadFinishCheck(){
    return loadSts;
}     
  	     
  
   	/* 개발자 작업  끝 */