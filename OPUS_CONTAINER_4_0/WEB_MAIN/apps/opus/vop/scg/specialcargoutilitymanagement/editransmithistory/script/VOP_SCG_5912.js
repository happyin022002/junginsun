/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_SCG_5912.js
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
            	case "btn_apvl_dtl":
            		parent.popCall();
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
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            //
        }
        initControl();
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
     function initControl() {
     	var formObject=document.form;
         //Axon 이벤트 처리1. 이벤트catch(개발자변경)        
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
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
                
               var HeadTitle1  = "No|BaseMerge|EDI \nStatus|DG Ref No|IMDG|IMDG";
                   HeadTitle1 += "|PKG \nGroup|PSN|Cargo \nStatus|Sequence|Sequence|Weight(KGS)|Weight(KGS)|I/F Date";
               var HeadTitle2  = "No|BaseMerge|EDI \nStatus|DG Ref No|UN No|Class";
                   HeadTitle2 += "|PKG \nGroup|PSN|Cargo \nStatus|CNTR|CGO|Gross|Net|I/F Date";
               
               var headCount = ComCountHeadTitle(HeadTitle1);
              
               SetConfig( { SearchMode:2, MergeSheet:9, Page:20, DataRowMerge:0 } );

               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle1, Align:"Center"},
                               { Text:HeadTitle2, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [
                           {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rank_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"edi_msg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dcgo_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd_ctnt",   KeyField:0,   CalcLogic:"",   Format:"",	        PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd_ctnt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prp_shp_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_sts_cd_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seq",            KeyField:0,   CalcLogic:"",   Format:"",       		PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt_ctnt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
                           {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"net_wgt_ctnt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
                           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"if_date",             KeyField:0,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                           {Type:"Text",      Hidden:1,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"bkg_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                    ];
                    InitColumns(cols);
                    SetEditable(0);
                    
                    SetColProperty("edi_msg_sts_cd"   , {ComboText:"Original|Update|Cancel", ComboCode:"N|U|R"} );
                    SetColProperty("dcgo_sts_cd_ctnt" , {ComboText:"New|Update|Cancelled", ComboCode:"N|U|X"} );
               SetSheetHeight(450);
             }
             break;
         }
     }
    /* Sheet관련 프로세스 처리 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve again	    		
				formObj.f_cmd.value=SEARCH;
				
				var xml=sheetObj.GetSearchData("VOP_SCG_5912GS.do", FormQueryString(formObj));
	 			
	 			sheetObj.LoadSearchData(xml,{Sync:0} );
     		    break; 
        }
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            /*if(formObj.cnt_cd.value == "") {
              showErrMessage("You must input Country code");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value.length < 2) {
              showErrMessage("Country code must be 2 characters");
              setFocus(formObj.cnt_cd);
              return false;
            }
            if(formObj.cnt_cd.value == "US" && formObj.loc_state.value == "") {
              showErrMessage("You must input State");
              setFocus(formObj.loc_state);
              return false;
            }*/     
        }
        return true;
    }