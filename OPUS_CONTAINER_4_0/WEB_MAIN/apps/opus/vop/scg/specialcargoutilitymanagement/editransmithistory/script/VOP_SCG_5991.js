/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_SCG_5991.js
*@FileTitle : Carrier
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/03
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 공통전역변수 */
var ipageNo=1 ;
var sheetObjects=new Array();
var sheetCnt=0;
var selectVal;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var tabIndex=0;
var noDataMsg = "There is no data to search.";
var pTrsmBndCd = "";
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */    
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			/***********************************************************************************************************
           		이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
            	공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.        
			 **********************************************************************************************************/
			/*
           		이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
           		메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
           		(순서상도 form[1]이 되겠죠?) 
           		그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
            	document.form.f_cmd.value=INSERT;   이런식의 코딩은 지양해주십시오.
			 */
			switch(srcName) {
            	case "btn_Close":
            		ComClosePopup(); 
            		break;
			} // end switch
		}catch(e) {            
			/*
        		자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
        		물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
			 */
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
    /**
     * register IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * comSheetObject(id)에서 호출한다
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화 
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(arg) {
    	pTrsmBndCd = arg;
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            //
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
   
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "IFTMBF" , "");
					InsertItem( "APERAK" , "");
                }
             break;
         }
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) {
         
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {
                
               var HeadTitle1  = "Contents|Contents|Contents|Contents";
               
               SetConfig( { SearchMode:2, MergeSheet:9, Page:20, DataRowMerge:0 } );

               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle1, Align:"Center"}];
               InitHeaders(headers, info);

               var cols = [
                           {Type:"Text", Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,  SaveName:"trsm_bnd_cd",        KeyField:0,  CalcLogic:"",  Format:"",  PointCount:0,  UpdateEdit:0,  InsertEdit:0 },
                           {Type:"Text", Hidden:1,  Width:130,  Align:"Center",  ColMerge:0,  SaveName:"bkg_ref_no",         KeyField:0,  CalcLogic:"",  Format:"",  PointCount:0,  UpdateEdit:0,  InsertEdit:0 },
                           {Type:"Text", Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,  SaveName:"prnr_spcl_cgo_seq",  KeyField:0,  CalcLogic:"",  Format:"",  PointCount:0,  UpdateEdit:0,  InsertEdit:0 },
                           {Type:"Text", Hidden:1,  Width:45,   Align:"Center",  ColMerge:0,  SaveName:"flt_file_dat_ctnt",  KeyField:0,  CalcLogic:"",  Format:"",  PointCount:0,  UpdateEdit:0,  InsertEdit:0 }
                           ];
                    InitColumns(cols);
                    SetEditable(0);
               SetSheetHeight(450);
             }
             break;
         }
     }
     
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
	        case IBSEARCH: //retrieve again
	        	var noIftmbfData = true;
	        	var noAperakData = true;
	        	var iftmbf  = "I";
	        	var aperak  = "O";
				formObj.f_cmd.value=SEARCH;
				var xml=sheetObj.GetSearchData("VOP_SCG_5991GS.do", FormQueryString(formObj));
		 		sheetObj.LoadSearchData(xml,{Sync:1} );
	 			if(pTrsmBndCd == "O") { // Send의 경우 TrsmBndCd를 반대로 검색
	 				iftmbf = "O";
	 				aperak = "I";
	 			}
		 		for(var row = sheetObj.HeaderRows();row<=sheetObj.RowCount();row++) {
		 			var content = "";
		 			var trsmBndCd = sheetObj.GetCellValue(row, "trsm_bnd_cd");
		 			var fltFileDatCtnt = sheetObj.GetCellValue(row, "flt_file_dat_ctnt");
		 			var inline = replaceAll(fltFileDatCtnt,"\n","@temp@");
		 			var start = -1;
		 			var point = 0;
		 			var base = 0;
		 			
		 			for(var i=0;i<inline.length;i++) {
		 				var tmp = inline.substr(i,1);
		 				var pos = -1;
		 				if(tmp == "{" || tmp == "}") {
		 					pos = inline.substring(i).indexOf("@temp@");
		 				}
		 				if(pos < 0) {
		 					content +=tmp;
		 				} else {
		 					content += "<B>" + inline.substr(i, pos) + "</B>";
		 					i = i + pos - 1;
		 					pos = -1;
		 				}
		 			}
		 			if(content == "") {
		 				content = inline;
		 			}
		 			// content
		 			if(trsmBndCd == iftmbf){
		 				document.getElementById("IFTMBF_MSG").innerHTML=makeDisp(content);
		 				noIftmbfData = false;
		 			} 
		 			if(trsmBndCd == aperak){
		 				document.getElementById("APERAK_MSG").innerHTML=makeDisp(content);
		 				noAperakData = false;
		 			}
		 		}
		 		if(noIftmbfData) {
		 			document.getElementById("IFTMBF_MSG").innerHTML=noDataMsg;
		 		}
		 		if(noAperakData) {
		 			document.getElementById("APERAK_MSG").innerHTML=noDataMsg;
		 		}
	     	break; 
        }
    }

    function makeDisp(inline) {
    	var content = "";
    	var arrLine = inline.split("@temp@");
    	
		for(var i=0;i<arrLine.length;i++) {
			var str = arrLine[i];
			if(str.length >= 3 && str.substr(0,3) == '$$$') {
				str = "<B>" + str + "</B>";
			}
			var tmp = str.split(':');
			if(tmp.length > 1) {
				// font Blue
				if(tmp[0] == 'BKGNBR'     || tmp[0] == 'VSL_CALLSIGN'|| tmp[0] == 'VSL_LLOYDCODE'
				|| tmp[0] == 'CONSORT_VOY'|| tmp[0] == 'POL_CD'      || tmp[0] == 'POD_CD'
				|| tmp[0] == 'ITEM_SEQ'   || tmp[0] == 'IMO_AMDT_NO' || tmp[0] == 'FLASH'
			    || tmp[0] == 'ORG_MSG_TP') { 
					str = tmp[0] + ":<FONT COLOR='Blue'><B>" + tmp[1] + "</B></FONT>";
				}
				// font Red
				if(tmp[0] == 'BRACE'       || tmp[0] == 'CNTR_NO'     || tmp[0] == 'DG_REF'
				|| tmp[0] == 'PROP_SHIP_NM'|| tmp[0] == 'TECH_NM'     || tmp[0] == 'UN_NBR'
				|| tmp[0] == 'IMO_CLASS'   || tmp[0] == 'PKG_GROUP'   || tmp[0] == 'DG_CNTRNBR'
				|| tmp[0] == 'REFNBR'      || tmp[0] == 'ORG_MSG_KEY' || tmp[0] == 'MSG_ACK_TP'
				|| tmp[0] == 'MSG_R_CD'    || tmp[0] == 'MSG_R_REASON'|| tmp[0] == 'MSG_ACK_RSLT') { 
					str = tmp[0] + ":<FONT COLOR='Red'><B>" + tmp[1] + "</B></FONT>";
				}
				// font Red (Line)
				if(tmp[0] == 'BRAC') { 
					str = "<FONT COLOR='Red'><B>" + str + "</B></FONT>";
				}
			} 
			content = content + str;
			if(i < arrLine.length - 1) {
				content = content + "<BR>";
			} 
		}
		return content;
    }
    
    function replaceAll(str, ori, rep) {
    	return str.split(ori).join(rep);
    }
    
    /**
     * Related event when clicking Tab
     * selected tab element activates.
     */
    function tab1_OnChange(tabObj , nItem){
   	 var formObj=document.form;
   	 var objs=document.all.item("tabLayer");
   	 var tabSelectedIdx=ComGetObjValue(formObj.tabSelectedIdx);
   	 objs[nItem].style.display="Inline";
   	 objs[beforetab].style.display="none";
   	 //--------------- important point --------------------------//
   	 objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
   	 //------------------------------------------------------//
   	 beforetab=nItem;
   	 tabIndex=nItem;
   	 ComSetObjValue(formObj.tabSelectedIdx, nItem);
   	 resizeSheet();
    }
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }