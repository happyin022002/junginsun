/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2041_07.js
*@FileTitle : Amendment History Inquiry - Affiliate Company
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.15 김대호
* 1.0 Creation
=========================================================
* History
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청
=========================================================*/
/**
 * @fileoverview Amendment History Inquiry - Affiliate Company 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends  
 * @class ESM_PRI_2041_07 : ESM_PRI_2041_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_2141_07() {
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.processButtonClick		= processButtonClick;
	this.doActionIBSheet 		= doActionIBSheet;
}
    
//===================================================================================
//전역변수
//===================================================================================
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;

var comboObjects = new Array();
var comboCnt = 0;
//업무전역변수
//===================================================================================
//페이지 초기화
//===================================================================================
/** 
* IBSheet Object를 sheetObjects 배열로 등록 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj IBSheet Object
* @return 없음
* @see #
* @author 김대호
* @version 2009.09.15
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.09.15
*/ 
function loadPage() {
	var form = document.form;	
    sheet1 = sheetObjects[0];
    sheetCnt = sheetObjects.length ;
    //IBSheet 초기화
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }

    loadSts = true;
	  doActionIBSheet(sheet1, form, IBCLEAR);
	  parent.loadTabPage();
}


///**
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
//	  doActionIBSheet(sheet1, form, IBCLEAR);
//	  parent.loadTabPage();
//}   

/** 
* Sheet 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBSheet} sheetObj : 시트오브젝트
* @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
* @return 없음
* @see #
* @author 김대호
* @version 2009.09.15
*/ 
function initSheet(sheetObj, sheetNo) {
	var form = document.form;
	var cnt = 0;
	var sheetID = sheetObj.id;
	
    var amdtSeq = form.amdt_seq.value;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
		            //높이 설정
		            style.height = 200;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly; //msHeaderOnly
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(2, 1, 7, 100);
		            var HeadTitle1 = "|Seq.|Customer Code|Customer Code|Customer Name|Location|EFF Date|EXP Date|Souce|Status|Accepted|Accepted||";
		            var HeadTitle2 = "|Seq.|Customer Code|Customer Code|Customer Name|Location|EFF Date|EXP Date|Souce|Status|By|On||";
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(false, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            InitHeadRow(1, HeadTitle2, true);
					//데이터속성     ROW , COL   ,DATATYPE       ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
		            InitDataProperty(0, cnt++ ,	dtHiddenStatus,	40,	 daCenter, true,  "ibflag");
		            InitDataProperty(0, cnt++ ,	dtSeq,			50,	 daCenter, true,  "seq");
					InitDataProperty(0 ,cnt++  ,dtData         ,40     ,daCenter   ,true    ,"cust_cnt_cd"      ,false   ,""        ,dfNone         ,0         ,false      ,false      ,2);      // Customer code
					InitDataProperty(0 ,cnt++  ,dtData         ,60     ,daCenter   ,true    ,"cust_seq"         ,false   ,""        ,dfNone         ,0         ,false      ,false      ,6);      // Customer code
									                 
					InitDataProperty(0 ,cnt++  ,dtData         ,200    ,daLeft     ,true    ,"cust_nm"          ,false   ,""        ,dfNone         ,0         ,false     ,false     ,100);    // Customer Name
					
					InitDataProperty(0 ,cnt++  ,dtData         ,70     ,daCenter   ,true    ,"cust_loc_cd"      ,false   ,""        ,dfNone         ,0         ,false     ,false     ,5);      // Location
					InitDataProperty(0 ,cnt++  ,dtData         ,80     ,daCenter   ,true    ,"eff_dt"           ,false   ,""        ,dfDateYmd      ,0         ,false     ,false       );      // Effective Date
					InitDataProperty(0 ,cnt++  ,dtData         ,80     ,daCenter   ,true    ,"exp_dt"           ,false   ,""        ,dfDateYmd      ,0         ,false     ,false       );      // Effective Date
					InitDataProperty(0 ,cnt++  ,dtCombo        ,60     ,daCenter   ,true   ,"src_info_cd"      ,false   ,""        ,dfNone         ,0         ,false     ,false       );      // Source
					InitDataProperty(0 ,cnt++  ,dtCombo        ,60     ,daCenter   ,true   ,"prc_prog_sts_cd"  ,false   ,""        ,dfNone         ,0         ,false     ,false       );      // Status
					InitDataProperty(0 ,cnt++  ,dtData         ,150    ,daLeft   ,false   ,"acpt_usr_nm"      ,false   ,""        ,dfNone         ,0         ,false     ,false       );
					InitDataProperty(0 ,cnt++  ,dtData         ,80     ,daCenter   ,false   ,"acpt_dt"          ,false   ,""        ,dfDateYmd      ,0         ,false     ,false       );
	                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "amdt_seq",      false, "", dfNone,	0,	false,	true);
	                InitDataProperty(0, cnt++ , dtHidden,		100, daCenter, true,  "n1st_cmnc_amdt_seq",      false, "", dfNone,	0,	false,	true); 
                     Ellipsis = true;
//                     CountPosition = 0;		// Total 없음.                     
                     SetMergeCell (0, 2, 2, 2);  
                     WaitImageVisible = false;

	      	}
	      	break;
	      	
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
 * @author 김대호
 * @version 2009.05.21
 */ 
function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk) {
	//alert(sPropNo +"<>"+ sAmdtSeq +"<>"+ sSvcScpCd +"<>"+ sConChk);
	var form = document.form;
	if (form.prop_no.value != sPropNo || form.svc_scp_cd.value != sSvcScpCd || form.amdt_seq.value != sAmdtSeq) {
		form.prop_no.value = sPropNo;
		form.amdt_seq.value = sAmdtSeq;
		form.svc_scp_cd.value = sSvcScpCd;
        doActionIBSheet(sheet1, form, IBSEARCH);
	}
}	

//===================================================================================
//버튼 이벤트 처리
//===================================================================================
document.onclick = processButtonClick;

/** 
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.09.15
*/ 
function processButtonClick(){
	var form = document.form;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	    	case "btn_retrieve":
    			doActionIBSheet(sheet1, form, IBSEARCH);
	    		break;

	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
}

//===================================================================================
//Axson Event Handler
//===================================================================================
//===================================================================================
//UI Object Event Handler
//===================================================================================
//===================================================================================
//서버 조회/저장
//===================================================================================
/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.09.15
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	   
	sheet1.ShowDebugMsg = false;
	try{
		switch(sAction) {
		case IBCLEAR: //화면로딩시
			formObj.f_cmd.value = COMMAND13;
			//공통 Source//공통 Status
			formObj.cd.value = "CD02064:N:CD01719:N";
			//code|desc일 경우는 Y
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do" , FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if ( arrXml[0] != null)	setIBCombo(sheetObj,arrXml[0],"src_info_cd", false, 0, "NW"); 				
			if ( arrXml[1] != null)	setIBCombo(sheetObj,arrXml[1],"prc_prog_sts_cd", false, 0, "I");			
			break;
	
        case IBSEARCH: //조회
        	ComOpenWait(true); //->waiting->start
        	formObj.f_cmd.value = SEARCH01;
 			sheet1.DoSearch("ESM_PRI_2041_07GS.do", FormQueryString(formObj));
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
* sheet 조회 후 font 설정을 변경한다.  <br>
* <br><b>Example :</b>
* <pre>
*     searchEndFontChange(sheetObj, "ctrt_exp_dt");
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

	
	sheetObjects[0].RemoveAll();
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

