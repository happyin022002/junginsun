/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2141_01.js
*@FileTitle : Amendment History Inquiry - Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.08 공백진
* 1.0 Creation
 =========================================================
 * History
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청
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
 * @class ESM_PRI_2141_01 : ESM_PRI_2141_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_2141_01() {
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
 
// /**
// * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
// * <br><b>Example :</b>
// * <pre>
// *    
// * </pre>
// * @param {ibsheet} sheetObj 필수 IBSheet Object
// * @return 없음
// * @author 공백진
// * @version 2009.04.17
// */      
//function sheet1_OnLoadFinish(sheetObj) {   
//	 sheetObj.WaitImageVisible = false;   
//	 parent.loadTabPage();
//     sheetObj.WaitImageVisible = true;  
//}  
     


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
                style.height = 200;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 7, 100);

                var HeadTitle1 = "|Seq.|Duration|Duration|Effective Date|Expiry Date|Source|Status|Accepted|Accepted||";
                var HeadTitle2 = "|Seq.|Duration|Duration|Effective Date|Expiry Date|Source|Status|By|On||";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ ,	dtHiddenStatus,	40,	 daCenter, true,  "ibflag");
                InitDataProperty(0, cnt++ ,	dtSeq,			50,	 daCenter, true,  "seq");
                InitDataProperty(0, cnt++ , dtData,			100, daCenter, true,  "ctrt_eff_dt",	  	false, "", dfDateYmd, 0, false,	true);
                InitDataProperty(0, cnt++ , dtData,			100, daCenter, true,  "ctrt_exp_dt",	  	false, "", dfDateYmd, 0, false,	true);
				InitDataProperty(0, cnt++ , dtData,			100, daCenter, true,  "eff_dt",			  	false, "", dfDateYmd, 0, false,	true);
				InitDataProperty(0, cnt++ , dtData,			100, daCenter, true,  "exp_dt",			  	false, "", dfDateYmd, 0, false,	true);
				InitDataProperty(0, cnt++ , dtData,			100, daCenter, true,  "src_info_nm",      	false, "", dfNone,	  0, false,	true);
                InitDataProperty(0, cnt++ , dtData,			80,	 daCenter, true,  "prc_prog_sts_nm", 	false, "", dfNone,	  0, false,	true);
				InitDataProperty(0, cnt++ , dtData,			180, daLeft, false, "acpt_usr_nm",	  	false, "", dfNone,	  0, false,	true);
                InitDataProperty(0, cnt++ , dtData,			100, daCenter, false, "acpt_dt",		  	false, "", dfDateYmd, 0, false,	true);
                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "amdt_seq",      	    false, "", dfNone,	  0, false,	true);
                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "n1st_cmnc_amdt_seq", false, "", dfNone,	  0, false,	true);

				CountPosition = 0;		// Total 없음.
				 SetMergeCell (0, 2, 2, 2);
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
		     	formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_2041_01GS.do", FormQueryString(formObj));
				ComOpenWait(false); //->waiting->End
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
  * OnSearchEnd 이벤트 발생시 호출되는 function <br>
  * Sheet의 Font Style을 지정한다.
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
		formObj.eff_dt.value = sheetObj.CellValue(sheetObj.RowCount,"eff_dt");
		var sCols = "";
		searchEndFont(sheetObj, sCols);
     
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
 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk) {
 	var formObject = document.form;

 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
 		formObject.prop_no.value = sPropNo;
 		formObject.amdt_seq.value = sAmdtSeq;
 		formObject.svc_scp_cd.value = sSvcScpCd;

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
	
	sheetObjects[0].Editable = flag;
}
  	     
/**
 * sheet 조회 후 font 설정을 변경한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 *     searchEndFont(sheetObj, "ctrt_exp_dt");
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} colName 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
 * @return 없음
 * @author 공백진
 * @version 2009.06.12
 */
function searchEndFont(sheetObj, sCols){
      var arrCols  = sCols.split("|");
      var amdt_seq = document.form.amdt_seq.value;

      if(amdt_seq==0){
          return;
      }

      for(i = 2 ; i < sheetObj.Rows; i++){
    	  if(sheetObj.CellValue(i, "amdt_seq") != amdt_seq){
              sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol) = true;
              for (j = 0; j < arrCols.length; j++){
                  sheetObj.CellEditable(i,arrCols[j]) = false;
              }
          }
          else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
              sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
              if (sheetObj.CellValue(i, "src_info_cd") != "AD"){
                  for (j = 0; j < arrCols.length; j++){
                      sheetObj.CellEditable(i,arrCols[j]) = true;
                  }
              }
          }
      }
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