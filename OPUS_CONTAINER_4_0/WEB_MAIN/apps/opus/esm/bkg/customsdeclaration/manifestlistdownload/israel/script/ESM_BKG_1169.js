/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1169.js
*@FileTitle  : ESM_BKG_1169
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
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
	 * @class ESM_BKG_1169 : ESM_BKG_1169 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
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
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					case "btn_new":
	           			doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
	           			break;
					case "btn_calendar":
		                var cal=new ComCalendarFromTo();
		                cal.select(formObject.s_vps_eta_dt, formObject.e_vps_eta_dt, 'yyyy-MM-dd');
						break;
					case "btn_exceldown":
						doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
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
		//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm("click","obj_click", document.form);
    	//초기셋팅
    	initPage();
     }
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
    	 var cnt=0;
         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {
                     // 높이 설정
            	
            	 var HeadTitle1="|Seq.|Acknowledge Type|Acknowledge Result|Acknowledge Date|B/L No.|VVD|Reject Code|Reject Reason|Reject Date|Error Code|Error Message";
            	 
            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	              {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"ack_knd_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:"eur_ack_rcv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"ack_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eur_cstms_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:1,   SaveName:"rjct_rsn_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rjct_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cstms_err_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:1,   SaveName:"cstms_err_msg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	  
            	 InitColumns(cols);
            	 SetSheetHeight(535);
            	 SetEditable(1);
            	 SetWaitImageVisible(0);
            	 SetColProperty("ack_dt", {Format:"YmdHm"} );
            	 SetColProperty("rjct_dt", {Format:"YmdHm"} );
            	 //SetAutoRowHeight(0);
            	 //SetDataRowHeight(22);
                }
                break;
         }
     }
     /**
      * 최초 init
      * @return
      */
     function initPage() {
 		document.form.s_vps_eta_dt.value=ComGetDateAdd(null, 'd', -7, '-');
		document.form.e_vps_eta_dt.value=ComGetNowInfo('ymd','-');
     }
   // Sheet관련 프로세스 처리
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	     	case IBSEARCH:      //조회
	     		if(!validateForm(sheetObj,formObj,sAction)) return false;
	     		ComOpenWait(true);
	     		formObj.f_cmd.value=SEARCH;
	     		var sParam=FormQueryString(formObj);
	     		//ComShowMessage("sParam : " + sParam);
 	     		sheetObj.DoSearch("ESM_BKG_1169GS.do",sParam );
	     		ComOpenWait(false);
	     		break;
	     	case IBCLEAR: // 폼과 시트의 값 삭제
	     		sheetObjects[0].RemoveAll();
				formObj.reset();
				initPage();
				break;
			case "btn_exceldown":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel({ HiddenColumn:1});
					}

 				
				break;
	     }
	 }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
 	    switch(sAction) {
			case IBSEARCH: { // 조회
				//기본포멧체크
//				if (!ComChkValid(formObj)) return false;
//				
//    			var etaDt = formObj.s_vps_eta_dt.value + formObj.e_vps_eta_dt.value;
//    			var blNo = formObj.bl_no.value;
//    			
//				//ComShowMessage("[" + etaDt + "][" + blNo +"]["+ cntrNo + "]");
//    			if(etaDt == "" && blNo == "") {
//					//ComShowMessage("Acknowledge Date 또는 BL No 또는 Container No중 반드시 1개 이상 입력해야합니다.");
//    				ComShowCodeMessage("BKG06091");
//					ComSetFocus(formObj.s_vps_eta_dt);
//					return false;
//    			}
    			if(formObj.cond_gubun.value == "1" && formObj.s_vps_eta_dt.value.length > 0 && !ComIsDate(formObj.s_vps_eta_dt.value, "ymd"))
      			{
      				ComShowCodeMessage('BKG00377');
      				formObj.s_vps_eta_dt.focus();
      				return false;
      			}
           		if(formObj.cond_gubun.value == "1" && formObj.e_vps_eta_dt.value.length > 0 && !ComIsDate(formObj.e_vps_eta_dt.value, "ymd"))
      			{
      				ComShowCodeMessage('BKG00377');
      				formObj.e_vps_eta_dt.focus();
      				return false;
      			}
           		if (formObj.cond_gubun.value == "1" && ComChkPeriod(formObj.s_vps_eta_dt.value, formObj.e_vps_eta_dt.value) < 1 )
    			{
    				//alert("기간이 정확하지 않습니다.");
    				ComShowCodeMessage('BKG00377');
    				formObj.s_vps_eta_dt.focus();
    				return false;				
    			}
           		if(formObj.cond_gubun.value == "1")
           		{
           			var iDays=ComGetDaysBetween(formObj.s_vps_eta_dt.value, formObj.e_vps_eta_dt.value);
           			if(iDays > 14)
           			{
           				ComShowCodeMessage('BKG40014','2');
           				return false;
           			}
           		}
//	           	if(formObj.cond_gubun.value == "2" && ComGetLenByByte(formObj.bl_no) > 0 ) // Toyota B/L
//	    		     {
//	    		    	ComShowCodeMessage('BKG00709');
//	     				formObj.bl_no.focus();
//	     				return false;
//	    		     }
           		if(formObj.cond_gubun.value == "2" && ComGetLenByByte(formObj.bl_no) == 0)
           		{
           			ComShowCodeMessage('BKG00709');
    				formObj.bl_no.focus();
    				return false;
           		}
           		if( ComGetLenByByte(formObj.pol_cd) > 0 && ComGetLenByByte(formObj.pol_cd) < 5)
    		     {
    		    	ComShowCodeMessage('BKG00711');
    				formObj.pol_cd.focus();
    				return false;
    		     }
           		if( ComGetLenByByte(formObj.pod_cd) > 0 && ComGetLenByByte(formObj.pod_cd) < 5)
    		     {
    		    	ComShowCodeMessage('BKG00712');
    				formObj.pod_cd.focus();
    				return false;
    		     }
           		if(ComGetLenByByte(formObj.vvd) > 0 && ComGetLenByByte(formObj.vvd) < 9)
     		     {
     		    	ComShowCodeMessage('BKG00710');
      				formObj.vvd.focus();
      				return false;
     		     }
           		return true;
				break;
			}
 	    } // end switch()
         return true;
     }
     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
     	var formObject=document.form;
     	var srcName=ComGetEvent("name");
     	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
     	var srcValue=window.event.srcElement.getAttribute("value");
     	if (srcName=="bl_no" && ComChkLen(srcValue, srcMaxLength) == "2") {
     		ComSetNextFocus();
     	}
     }
     /**
      * 시트를 클릭했을 때 처리
      */
     function sheet1_OnClick(sheetObj, row, col) {
     	var rowCnt=sheetObj.RowCount();
     	var colSaveName=sheetObj.ColSaveName(col);
     	/* Row Focus 색상 및 글자  기본값으로 변경 */
     //no support[implemented common]CLT 	sheetObj.SelectFontBold=false;
     //no support[implemented common]CLT 	sheetObj.SelectBackColor="16186087";
     	switch(colSaveName) {
     		/* 긴 문자열 MemoPad 처리*/
     		case "rjct_rsn_rmk" :
     		case "cstms_err_msg" :
     			if(sheetObj.GetCellValue(row,col) == "") return false;
     			ComShowMemoPad(sheetObj, null, null, true, 420, 150);
     			break;
     	} // end switch
     }
     /**
      * 화면에서 검색조건으로 radio버트 선택에 따라서 검색조건 화면 화성화 비활성화 작업
      * @return
      */
     function obj_click(){
    	 for(var i=0; i < document.form.gubun.length; i++) {
    		    if(document.form.gubun[i].checked) {
    		      if(document.form.gubun[i].value == 1)
    		      {
    		    	  document.form.bl_no.disabled=true;
    		    	  document.form.bl_no.value="";
    		    	  document.form.s_vps_eta_dt.disabled=false;
    		    	  document.form.e_vps_eta_dt.disabled=false;
    		    	  document.form.cond_gubun.value="1";
    		      }
    		      if(document.form.gubun[i].value == 2)
    		      {
    		    	  document.form.bl_no.disabled=false;
    		    	  document.form.s_vps_eta_dt.disabled=true;
    		    	  document.form.e_vps_eta_dt.disabled=true;
    		    	  document.form.cond_gubun.value="2";
    		      }
    		 }
        }
     }  
