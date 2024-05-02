/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0034.js
*@FileTitle  : Hire Revenue Retrieve / Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     */
    /**
     * @extends 
     * @class TEU Range Target : TEU Range Target 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   	/* 개발자 작업	*/
    var sheetObjects=new Array();
    var sheetCnt=0;
	var localopener=window.dialogArguments;
	if (!localopener) localopener=window.opener;  //이 코드 추가할것
	if (!localopener) localopener=parent; //이 코드 추가할것
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    	        case "btn_Confirm":
    	        	var aryData=new Array();
    	        	var iDataIdx=0;
    	        	
    	        	var sCheckedRow=sheetObject.FindCheckedRow(1);
    	        	var arrRow=sCheckedRow.split("|"); //result : "1|3|5|"
    	        	for (var idx= 0; idx < arrRow.length; idx++){
    					var sSelGrpNo = sheetObject.GetCellValue(arrRow[idx], "grp_no");
    					
    					for (var row=sheetObject.HeaderRows(); row <= sheetObject.LastRow(); row++){
    						var tmpGrpNo = sheetObject.GetCellValue(row, "grp_no");
    						var tmpConfirmFlg = sheetObject.GetCellValue(row, "confirm_flg");
    						//동일 그룹일때 Del 체크 및 Delete.
    						if(sSelGrpNo == tmpGrpNo && "Y" != tmpConfirmFlg){

    	    	        		var hirRevenueData={
    	    	        				to_yrmon : "",
    	    	        				ppay_hir_no : "",
    	    	        				acct_itm_nm : "",
    	    	        				acct_cd : "",
    	    	        				cust_cnt_cd : "",
    	    	        				cust_seq : "",
    	    	        				curr_cd : "",
    	    	        				inv_amt : "",
    	    	        				inv_desc : "",
    	    	        				ar_ctr_cd : "",
    	    	        				loc_cd : "",
    	    	        				to_inv_no : "",
    	    	        				eff_dt : "",
    	    	        				exp_dt : "",
    	    	        				inv_seq : "",
    	    	        				flet_ctrt_no : "",
    	    	        				flet_iss_tp_cd : "",
    	    	        				inv_dtl_seq : "",
    	    	        				ori_inv_desc : ""
    	    	        		};
    							hirRevenueData.to_yrmon=sheetObject.GetCellValue(row,"to_yrmon");
    							hirRevenueData.ppay_hir_no=sheetObject.GetCellValue(row,"ppay_hir_no");
    							hirRevenueData.acct_itm_nm=sheetObject.GetCellValue(row,"acct_itm_nm");
    							hirRevenueData.acct_cd=sheetObject.GetCellValue(row,"acct_cd");
    							hirRevenueData.cust_cnt_cd=sheetObject.GetCellValue(row,"cust_cnt_cd");
    							hirRevenueData.cust_seq=sheetObject.GetCellValue(row,"cust_seq");
    							hirRevenueData.curr_cd=sheetObject.GetCellValue(row,"curr_cd");
    							hirRevenueData.inv_amt=sheetObject.GetCellValue(row,"inv_amt");
    							hirRevenueData.inv_desc=sheetObject.GetCellValue(row,"inv_desc");
    							hirRevenueData.ar_ctr_cd=sheetObject.GetCellValue(row,"ar_ctr_cd");
    							hirRevenueData.loc_cd=sheetObject.GetCellValue(row,"loc_cd");
    							hirRevenueData.to_inv_no=sheetObject.GetCellValue(row,"to_inv_no");
    							hirRevenueData.eff_dt=sheetObject.GetCellValue(row,"eff_dt");
    							hirRevenueData.exp_dt=sheetObject.GetCellValue(row,"exp_dt");
    							hirRevenueData.inv_seq=sheetObject.GetCellValue(row,"inv_seq");
    							hirRevenueData.flet_ctrt_no=sheetObject.GetCellValue(row,"flet_ctrt_no");
    							hirRevenueData.flet_iss_tp_cd=sheetObject.GetCellValue(row,"flet_iss_tp_cd");
    							hirRevenueData.inv_dtl_seq=sheetObject.GetCellValue(row,"inv_dtl_seq");
    							hirRevenueData.ori_inv_desc=sheetObject.GetCellValue(row,"ori_inv_desc");
    	    	        		aryData[iDataIdx++]=hirRevenueData;
    	    	        		
    	    	        		//이미 선택된 데이타 체크 flag
    	    	        		sheetObject.GetCellValue(row, "confirm_flg", "Y", 0);
    						}
    					}
    					
    	        	}
    	        	/*
    	        	for(var i=0; i<sheetObject.LastRow();i++) {
    	        		var row=i+1;
    	        		if(sheetObject.GetCellValue(row,"check") == 0) {
    	        			continue;
    	        		}
    	        		var hirRevenueData={
    	        				to_yrmon : "",
    	        				ppay_hir_no : "",
    	        				acct_itm_nm : "",
    	        				acct_cd : "",
    	        				cust_cnt_cd : "",
    	        				cust_seq : "",
    	        				curr_cd : "",
    	        				inv_amt : "",
    	        				inv_desc : "",
    	        				ar_ctr_cd : "",
    	        				loc_cd : "",
    	        				to_inv_no : "",
    	        				eff_dt : "",
    	        				exp_dt : "",
    	        				inv_seq : "",
    	        				flet_ctrt_no : "",
    	        				flet_iss_tp_cd : "",
    	        				inv_dtl_seq : ""
    	        		};
						hirRevenueData.to_yrmon=sheetObject.GetCellValue(row,"to_yrmon");
						hirRevenueData.ppay_hir_no=sheetObject.GetCellValue(row,"ppay_hir_no");
						hirRevenueData.acct_itm_nm=sheetObject.GetCellValue(row,"acct_itm_nm");
						hirRevenueData.acct_cd=sheetObject.GetCellValue(row,"acct_cd");
						hirRevenueData.cust_cnt_cd=sheetObject.GetCellValue(row,"cust_cnt_cd");
						hirRevenueData.cust_seq=sheetObject.GetCellValue(row,"cust_seq");
						hirRevenueData.curr_cd=sheetObject.GetCellValue(row,"curr_cd");
						hirRevenueData.inv_amt=sheetObject.GetCellValue(row,"inv_amt");
						hirRevenueData.inv_desc=sheetObject.GetCellValue(row,"inv_desc");
						hirRevenueData.ar_ctr_cd=sheetObject.GetCellValue(row,"ar_ctr_cd");
						hirRevenueData.loc_cd=sheetObject.GetCellValue(row,"loc_cd");
						hirRevenueData.to_inv_no=sheetObject.GetCellValue(row,"to_inv_no");
						hirRevenueData.eff_dt=sheetObject.GetCellValue(row,"eff_dt");
						hirRevenueData.exp_dt=sheetObject.GetCellValue(row,"exp_dt");
						hirRevenueData.inv_seq=sheetObject.GetCellValue(row,"inv_seq");
						hirRevenueData.flet_ctrt_no=sheetObject.GetCellValue(row,"flet_ctrt_no");
						hirRevenueData.flet_iss_tp_cd=sheetObject.GetCellValue(row,"flet_iss_tp_cd");
						hirRevenueData.inv_dtl_seq=sheetObject.GetCellValue(row,"inv_dtl_seq");
    	        		aryData[idx++]=hirRevenueData;
    	        	}*/
    	        	localopener.setHireStatement(aryData);
    				ComClosePopup(); 
    	        	break;
    	        case "btn_Close":
    	        	ComClosePopup(); 
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
     *IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     *Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
    	}
    	sheet1_OnLoadFinish(sheet1);
    }
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
 function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		sheetObj.SetWaitImageVisible(1);
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
    		case 1:
    		    with(sheetObj){
    	        
    	      var HeadTitle1="|Sel|Hire No.|Rev.Month|Item Name|Account Code|Prefix|Numeric Code|Cur.|Approval|Description|||||||flet_ctrt_no|flet_iss_tp_cd|inv_dtl_seq|confirm_flg|";
    	      var headCount=ComCountHeadTitle(HeadTitle1);

    	      SetConfig( { SearchMode:0, MergeSheet:2, Page:20, DataRowMerge:1 } );

    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ 
    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"grp_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"check",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },    	                  
    	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ppay_hir_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_yrmon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             
    	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"acct_itm_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"inv_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ar_ctr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"to_inv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"exp_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"inv_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"flet_ctrt_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"flet_iss_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"inv_dtl_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"confirm_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ori_inv_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
    	       
    	      InitColumns(cols);

    	      SetEditable(1);
    	      //SetSheetHeight(300);
    	      resizeSheet();
    	            }


    			break;
            }
    }
    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다.<br>
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if(validateForm(sheetObj,formObj,sAction))
    				formObj.f_cmd.value=SEARCH;
     	   			sheetObj.DoSearch("ESM_FMS_0034GS.do", FormQueryString(formObj) );
    			break;
    		case IBSAVE:        //저장
    			if(validateForm(sheetObj,formObj,sAction))
    				alert (" Save .. ");
    			break;
    		case IBINSERT:      // 입력
    			break;
    	}
    }
    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	return true;
    }

    function resizeSheet(){
	    for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	 }
