/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_4013.jsp 
*@FileTitle  : Creation Operation Days popup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/07/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
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
        switch(srcName) {
    	    case "btn_Close":
    	    	ComClosePopup(); 
    	        break;
    	    case "btn_Save":
	            doActionIBSheet(sheetObject,formObject,IBSAVE);
    	        break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Change period when the month, week changed
 */
function setPeriod(obj){
    ComCoaSetPeriod(obj);
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

    for(i=0;i<sheetObjects.length;i++) {
	    //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
	    //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }
}
   /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet2 init
            with(sheetObj){
                  var HeadTitle="||" ;
                  var HeadTitle1="||" ;

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"},
                              { Text:HeadTitle1, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dummy",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                   
                  InitColumns(cols);

                  SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
                  SetVisible(false);
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
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet 관 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			
            if (ComShowConfirm(ComGetMsg('COA10020')) == true) { 
                ComOpenWait(true);
                
                setTimeout( function () {
                	formObj.f_cmd.value=MULTI01;
                    var sParam = sheetObj.GetSaveString(1);
                    if (sheetObj.IsDataModified() && sParam == "") return;
                    sParam = sParam + "&" + FormQueryString(formObj);
                    var sXml = sheetObj.GetSaveData("ESM_COA_4013GS.do", sParam );
    	            sheetObj.LoadSaveData(sXml, {Sync:1});
                    
                    var err_cd = ComGetEtcData(sXml, "err_cd");
                    var err_msg = ComGetEtcData(sXml, "err_msg");	                        
    	            if ( err_cd == "undefined" || err_cd == "" || err_cd == undefined ){
    	                return false;
    	            }	                
                    if (err_cd == "00000") {
                        ComShowMessage(ComGetMsg('COA10018','Creation Operation Days')); 
                    } else {
                        ComShowMessage("["+err_cd+"]:"+err_msg);
                    }
                    sheetObj.SetEtcData("err_cd","");
                    sheetObj.SetEtcData("err_msg","");
                    
                    ComOpenWait(false);
                }, 100);
            }
        break;
	}
}
   /**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
    	case IBSAVE:
    		if(formObj.f_fm_wk.value=="" || formObj.f_to_wk.value==""){
    			ComShowCodeMessage('COA10009','Period','YYYY-WW');
    			return false;
    		}
	  		if(formObj.f_fm_wk.value.length > 0) {
	  	  		if(!ComIsDate(formObj.f_fm_wk , "yw")){
	  	  			ComShowMessage(ComGetMsg('COM12180'));
	  	  			ComSetFocus(formObj.f_fm_wk);
	  	  			return false;	
	  	  		}
	  		}   
	  		if(formObj.f_to_wk.value.length > 0) {
	  	  		if(!ComIsDate(formObj.f_to_wk , "yw")){
	  	  			ComShowMessage(ComGetMsg('COM12180'));
	  	  			ComSetFocus(formObj.f_to_wk);
	  	  			return false;	
	  	  		}
	  		}	
			//Date Validation : fm_date > to_date
			if(parseInt(formObj.f_to_wk.value) < parseInt(formObj.f_fm_wk.value)) {
				ComShowMessage("End must be greater than start");
				ComSetFocus(formObj.f_to_wk);
		  		return false;
			}		  		
//    		var yrdif=(formObj.f_to_yrmm.value.substring(0,4)-formObj.f_fm_yrmm.value.substring(0,4))*52;
//    		var wkdif=formObj.f_to_yrmm.value.substring(5)-formObj.f_fm_yrmm.value.substring(5);
//    		var duration=yrdif+wkdif;
//    		if(formObj.f_cost_type.value=="acm_oth" && duration>4){
//    			ComShowCodeMessage('COA10073', '5')
//    			return false;
//    		}
    }
    return true;
}