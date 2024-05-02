/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0169.jsp
*@FileTitle  : Vgm History
*@author     : CLT
*@version    : 1.0
*@since      : 2016/05/12
=========================================================*/
   	/* 개발자 작업	*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
//					case "btn_ConfirmCombine":
//						if(!validateForm(sheetObject,formObject,"btn_ConfirmCombine")) {
//							return false;
//						}
//						ComOpenWait(true);
//						ComBtnDisable("btn_ConfirmCombine");
//						setTimeout('comPopupOK2()', 1000);
//					break;
					case "btn_Close":
						ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
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
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
	function initControl() {
		var formObject=document.form;
	}
//	function obj_keypress(){
//	    switch(ComGetEvent("dataformat")){
//	    	case "int":
//		        //숫자만입력하기
//		        ComKeyOnlyNumber(ComGetEvent());
//		        break;
//	        case "float":
//	            //숫자+"."입력하기
//	            ComKeyOnlyNumber(ComGetEvent(), ".");
//	            break;
//	        case "eng":
//	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
//	            ComKeyOnlyAlphabet();
//	            break;
//	        case "engdn":
//	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        case "uppernum":
//	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//	        	ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        default:
//	            //숫자만입력하기(정수,날짜,시간)
//	            ComKeyOnlyNumber(ComGetEvent());
//	    }
//	}
//	/**
//     * comPopupOK
//     */
//	function comPopupOK2() {
//		var formObj=document.form;	
//		var rArray=new Array(); //행데이터를 담고 있는 배열
//	    var sRow=sheetObjects[0].FindCheckedRow("slct_flg");
//	    //가져온 행을 배열로 반든다.	 	  	 	      
//	    var arrRow=sRow.split("|"); 	   
//		var cArray=new Array();   		  	   
//	    for (idx=0; idx <= arrRow.length; idx++){	     
//			 //열데이터를 담고 있는 배열 		 	 
//	    	cArray[idx]=sheetObjects[0].GetCellValue(arrRow[idx], "bkg_no");	    	
//		}
//		// 모달창인 경우 opener를 구해온다.
//    		 
//    	var  opener=window.dialogArguments;
//    	if (!opener) opener=window.opener;  //이 코드 추가할것
//    	if (!opener) opener=parent; //이 코드 추가할것
//    	
//    	opener.callBack0974(cArray);
//    	ComOpenWait(false);
//    	ComClosePopup(); 
//	} 
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with (sheetObj) {                
	                var HeadTitle1="|Seq.|BKG No.|CNTR No.|VGM|Unit|Signatory|I/F|CLZ|USR ID|Event Date\n(Local)|Event Date\n(GMT)";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                SetConfig( { SearchMode:2, MergeSheet:1, Page:100, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                       {Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vgm_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vgm_wgt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:0,   SaveName:"esig_co_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",    ColMerge:0,   SaveName:"if_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1,  Width:50,  Align:"Center",    ColMerge:0,   SaveName:"clz_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cre_locl_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"vgm_cre_glo_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(450);
	                SetSheetWidth(750);
            	}
			break;
        }
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        case IBSEARCH:      //retrieve
            formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT                    
            sheetObj.DoSearch("ESM_BKG_0169GS.do", FormQueryString(formObj) );
        break;
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//			switch(sAction) {
//			case "btn_ConfirmCombine":
//				if (sheetObj.CheckedRows("slct_flg") == 0) {
//					ComShowMessage(msgs['BKG00155']);
//					return false;
//				}
//			}
//	        return true;
        }
    }
