/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0007.js
*@FileTitle  : Sales Activity Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var userAuth="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        try {
            var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            var formObject=document.form;
            switch (srcName) {
//            	case "btn_office_code": 
//            		if(!document.getElementById(srcName).disabled){
//            		ComOpenPopup("/opuscntr/COM_ENS_071.do?pgmNo=COM_ENS_071", 770, 440, "callBackComEns071", '1,0,1,1,1,1,1', true);
//            		}
//            		break;   
                case "btn_retrieve": 
                	sheetObjects[0].RemoveAll();
                	
               	 	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		//조회
                    break ;         
                case "btn_plan_dt":	
                	if(!document.getElementById(srcName).disabled){
                		var cal=new ComCalendar();
                		cal.select(formObject.plan_dt, 'yyyy-MM-dd');
                	}
                	break ;
                case "btn_customer_code":   
                	if(!document.getElementById(srcName).disabled){
	                	var formObj=document.form;
	                	var sUrl="COM_ENS_041.do?cust_cd=" + formObj.cus_code.value +"&main_page=false";
			         	var rVal=ComOpenPopup(sUrl, 770, 490, "getCOM_ENS_041_cust_nm", "0,0,1,1,1,1", true);
                	}
		         	break
                case "btn_sls_report": 
                	var nowRow=sheetObjects[0].GetSelectRow();
                	if (nowRow < 1 || sheetObjects[0].GetCellValue(nowRow,"cus_code") < 1 ){
                        ComShowCodeMessage('COM130402', "Customer Code");
                        return;
                    }	
	           		var row=sheetObjects[0].GetSelectRow();
	           		var pgmNo="ESM_SAM_0008";
	   	 			var pgmUrl="/opuscntr/ESM_SAM_0008.do"
	   	 			var pSrep_cd="";
	   	 			var pCus_cd="";
	   	 			var pAct_no="";
	   	 			pSrep_cd=sheetObjects[0].GetCellValue(row, "sls_code");
	   	 			pCus_cd=sheetObjects[0].GetCellValue(row, "cus_code");
	   	 			pAct_no=sheetObjects[0].GetCellValue(row, "activity_no");
	   	 			var params="&srep_cd=" + pSrep_cd + "&cust_cd=" + pCus_cd + "&sls_act_seq="  + pAct_no;
	   				var parentPgmNo=pgmNo.substring(0, 8)+'M001';   
	   	 			var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
	   				var sFeatures="status=no, width=1024, height=750, resizable=yes, scrollbars=yes";   
	   				var winObj=window.open(pgmUrl+"?parentPgmNo=" + parentPgmNo + src);  
          	 		break
                case "btn_new":   
               	 	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);		//New
                    break 
                case "btn_new_down": 
						if(userAuth == ''){                    //Sales Rep일 경우
							purpose1.SetSelectCode("");
			                purpose2.SetSelectCode("");
			                channel.SetSelectCode("");
	                		formObject.cus_code.value="";
	 						formObject.cus_name.value="";
							formObject.srep_cmt_desc.value="";
							formObject.plan_dt.value="";
							formObject.actual_dt.value="";				
						}else                                    //Manager 일 경우
						formObject.sls_mgr_cmt_desc.value="";
                    break 
                case "btn_create":
                	if(formObject.office_cd.value.length < 5) {
        				ComShowCodeMessage("COM130403", "Office Code"); // Office Code is null
        				ComSetFocus(document.form.office_cd);					
        				return false;
        			}else if(formObject.sales_rep_cd.value.length != 5) {
        				ComShowCodeMessage('COM130403', "Sales Rep Code"); // Sales Rep Code is null
        				ComSetFocus(document.form.sales_rep_cd);					
        				return false;
        			}
                						
               	 	doActionIBSheet(sheetObjects[0], document.form, IBINSERT);		//Insert               	 	
	                
                    break ;
                case "btn_save":  
                	var nowRow=sheetObjects[0].GetSelectRow();
                	if( createRow != -1) nowRow = createRow;
                	if (nowRow < 1 || sheetObjects[0].GetCellValue(nowRow,"cus_code") < 1 ){
		                    ComShowCodeMessage('COM130402', "Data");
		                    return;
		               }else if(formObject.cus_code.value =="") {
	        				ComShowCodeMessage('COM130403', "Customer Code"); // Customer Code is null
	        				ComSetFocus(document.form.cus_code);					
	        				return false;
	        			}else if(formObject.plan_dt.value =="") {
	        				ComShowCodeMessage("COM130403", "Plan Date"); // Office Code is null
	        				ComSetFocus(document.form.plan_dt);					
	        				return false;
	        			}else if(formObject.plan_dt.value !="" && formObject.plan_dt.value < formObject.cre_dt.value) {
	        				ComShowCodeMessage("COM12133", "Created Date", "Planned Date", "smaller"); 
	        				ComSetFocus(document.form.plan_dt);					
	        				return false;
	        			}else if(purpose1.GetSelectCode()=="") {
	        				ComShowCodeMessage('COM130403', "Purpose"); // Purpose is null
	        				ComSetFocus(document.form.purpose1);		
	        				return false;
	        			}else if(purpose2.GetSelectCode()=="") {
	        				ComShowCodeMessage('COM130403', "Purpose"); // Purpose is null
	        				ComSetFocus(document.form.purpose2);		
	        				return false;
	        			}else if(channel.GetSelectCode()=="") {
	        				ComShowCodeMessage('COM130403', "Channel"); // Channel is null
	        				ComSetFocus(document.form.channel);	
	        				return false;
	        			}
                    ComOpenWait(true);
                    doActionIBSheet(sheetObjects[0], document.form, MULTI);    // 저장
                    ComOpenWait(false);
                    break;
//              2014.08.01 김용습 - 달력 스타일 변경
//                case "btns_calendar1": //달력버튼
//	            	cal=new ComCalendar();
//	                cal.select(formObject.from_date, 'yyyy-MM-dd');
//	                break;
//                case "btns_calendar2": //달력버튼                  
//	            	cal=new ComCalendar();
//	            	cal.select(formObject.to_date, 'yyyy-MM-dd');
//	            	break;	            	
                case "btn_Calendar":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
                    break; 
	            	
             } // end switch
        } catch(e) {
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
    function setSheetObject(sheetObj) {
       sheetObjects[sheetCnt++]=sheetObj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObject=document.form;
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();	
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }   
        doActionIBCombo(sheetObjects[0], formObject, SEARCH);
        userAuth=checkUserAuth(formObject,sheetObjects[0]);
        checkUserCodeName(); 	
        if(formObject.open_page.value == "2"){
        	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
        ComBtnDisable("btn_create");
        ComBtnDisable("btn_new_down");
        ComBtnDisable("btn_save");
        btnImgEnable(formObject.btn_office_code, false);
    	purpose1.SetEnable(0);
    	purpose2.SetEnable(0);
    	channel.SetEnable(0);
    }
	     /**
	  	* IBCombo Object를 배열로 등록 <br>
	  	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	  	* 배열은 소스 상단에 정의 <br>
	  	* <br><b>Example :</b>
	  	* <pre>
	  	*     setComboObject(comboObj);
	  	* </pre>
	  	* @param {ibcombo} combo_obj 필수 IBCombo Object
	  	* @return 없음
	      * @author 이관샨
	      * @version 2011.05.23
	  	*/
	  	function setComboObject(combo_obj){
	  		comboObjects[comboCnt++]=combo_obj;
	  	}
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        switch (sheetNo) {
        case 1:    //sheet[1] init
	             var cnt=0;
	             with (sheetObj) {
	                 var HeadTitle1="|Activity\nNo.|Sales Rep.|Sales Rep.|Customer|Customer|MGR\nComment|Purpose|Call\nReport|Planned Date|Actual Date|||||||";
	                 var HeadTitle2="|Activity\nNo.|Code|Name|Code|Name|MGR\nComment|Purpose|Call\nReport|Planned Date|Actual Date|||||||";
	                 var headCount=ComCountHeadTitle(HeadTitle2);

	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle1, Align:"Center"},
	                             { Text:HeadTitle2, Align:"Center"} ];
	                 InitHeaders(headers, info);

	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"activity_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_code",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:85,  Align:"Left",    ColMerge:1,   SaveName:"sls_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cus_code",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:435,  Align:"Left",    ColMerge:1,   SaveName:"cus_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"mgr_comment",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"purpose",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"call_report",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"plan_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"actual_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"srep_cmt_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sls_mgr_cmt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"channel",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"purpose1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 },
	                        {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"purpose2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:false,UpdateEdit:0 } ];
	                  
	                 InitColumns(cols);
 	                 SetEditable(1);
	                 SetColProperty("plan_dt", {Format:"####-##-##"} );
	                 SetColProperty("actual_dt", {Format:"####-##-##"} );
 					 SetWaitImageVisible(0);
 					 SetAutoRowHeight(0);
 					 SetSheetHeight(210);
 					 SetCellBackColor(1, 2, "#555555");
 					 SetCellBackColor(1, 3, "#555555");
 					 SetCellBackColor(1, 4, "#555555");
 					 SetCellBackColor(1, 5, "#555555");
             	}
             	break;
        }
    }
     /**
	     * OnSelectCell 이벤트 발생시 호출되는 function <br>
	     * 클릭시 하단 조회 <br>
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
		 * @author 서미진
		 * @version 2010.11.02
	 	 */
	  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	//function sheet1_OnClick(sheetObj,NewRow, NewCol)  {
	   		//if (OldRow != NewRow) {
				var formObj=document.form;
				if(sheetObj.RowCount()>0){
					formObj.cus_code.value=sheetObj.GetCellValue(NewRow, "cus_code");
					formObj.cre_dt.value=sheetObj.GetCellValue(NewRow, "cre_dt");
					formObj.cre_usr_id.value=sheetObj.GetCellValue(NewRow, "cre_usr_id");
					formObj.cus_name.value=sheetObj.GetCellValue(NewRow, "cus_name");
					formObj.srep_cmt_desc.value=sheetObj.GetCellValue(NewRow, "srep_cmt_desc");
					formObj.sls_mgr_cmt_desc.value=sheetObj.GetCellValue(NewRow, "sls_mgr_cmt_desc");
					formObj.plan_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(NewRow, "plan_dt"),"ymd");
					formObj.actual_dt.value=ComGetMaskedValue(sheetObj.GetCellValue(NewRow, "actual_dt"),"ymd");
					ComSetObjValue(purpose1, sheetObj.GetCellValue(NewRow, "purpose1"));
					ComSetObjValue(purpose2, sheetObj.GetCellValue(NewRow, "purpose2"));
					ComSetObjValue(channel, sheetObj.GetCellValue(NewRow, "channel"));
			 		if(formObj.plan_dt.value == ''){
			 			formObj.plan_dt.value=ComGetNowInfo('ymd', '-');
			 			}
			 		if(formObj.cre_usr_id.value == ''){
			 			formObj.cre_usr_id.value=formObj.usr_id.value ;
				 		}
			 		if(formObj.cre_dt.value == ''){
			 			formObj.cre_dt.value=ComGetNowInfo('ymd', '-') ;
				 		}
				}
		   		checkUserCodeName();
		   		 if(formObj.srep_cd.value == formObj.sales_rep_cd.value){		
			 		 ComBtnEnable("btn_create");
				 }else{
					 ComBtnDisable("btn_create");
				 }
		   		 
		   		createRow = NewRow;
	   		//}	   		
	  	}
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction) {
    	try {
    		sheetObj.ShowDebugMsg(false);
    		switch (sAction) {
    		case IBSEARCH:    // sheet1 조회	
	        	if (!validateForm(sheetObj,document.form,sAction)) {
	        		return false;
	        	}
	        	ComOpenWait(true);
	 			frmObj.f_cmd.value=SEARCH;
	 			var sParam=FormQueryString(frmObj);
	 				var sXml=sheetObj.GetSearchData("ESM_SAM_0007GS.do", sParam );
		 			frmObj.cus_code.value="";	 			 		
			 		frmObj.cre_dt.value="";
			 		frmObj.cre_usr_id.value="";
			 		frmObj.cus_name.value="";
			 		frmObj.srep_cmt_desc.value="";
			 		frmObj.sls_mgr_cmt_desc.value="";
			 		frmObj.plan_dt.value="";
			 		frmObj.actual_dt.value="";
			 		purpose1.SetSelectText("");
			 		purpose2.SetSelectText("");
			 		channel.SetSelectText("");
			 		sheetObj.LoadSearchData(sXml,{Sync:1} );
			 		checkUserCodeName(); 	
			 		if(frmObj.srep_cd.value == frmObj.sales_rep_cd.value){		
				 		 ComBtnEnable("btn_create");
					 }else{
						 ComBtnDisable("btn_create");
					 }
			 		createRow =-1;
			 		ComOpenWait(false);
			 		
			 		break;
    		case IBCLEAR:    //New	
    			createRow = -1;
	 			frmObj.reset();
	 			sheetObj.RemoveAll();
	 			purpose1.SetSelectText("");
	 			purpose2.SetSelectText("");
	 			channel.SetSelectText("");
	 			search_type.SetSelectCode("P");
	 			combo_status.SetSelectCode("");
	 	        ComBtnDisable("btn_create");
	 	        ComBtnDisable("btn_new_down");
	 	        ComBtnDisable("btn_save");
	 	        break;
    		 case MULTI:    // sheet1 저장
    		 if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}	
				if (!ComShowCodeConfirm("COM130101", "Data")) {
				    return false;
				}		
	 			frmObj.f_cmd.value=MULTI;   
	 			var sParam=sheetObj.GetSaveString(false);
//	 			sParam += "&f_cmd=" + frmObj.f_cmd.value;   
	 			
 				var sXml=sheetObj.GetSaveData("ESM_SAM_0007GS.do", sParam + "&f_cmd=" + frmObj.f_cmd.value);
	 			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	 			createRow = -1;
		     	   if(sav == "S"  ){
		     		  ComShowCodeMessage("COM130102", "Data");
		     		  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		       	   }else{
		       		  ComShowCodeMessage("COM130103", "Data");
		       		  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		       	   }
		     	  if(userAuth == ''){
		     		  ComBtnEnable("btn_create");
		     	  }
	 			break;
    		 case SEARCH01:
    			 var formObject=document.form;
    	         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    	         var sheetObject1=sheetObjects[0];
    	         /*******************************************************/
    	     		try {
    	     		var srcName=ComGetEvent("name");
    	     		if(ComGetBtnDisable(srcName)) return false;
    	             switch(srcName) {                
    		              	case "office_cd":
    		              		if(formObject.office_cd.value.length>0){	
    		              			formObject.f_cmd.value=SEARCH02;
    		    		 			var sParam="f_cmd="       +formObject.f_cmd.value
    		    		 						+ "&hidden_ofc_cd=" +formObject.office_cd.value;
    		    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0007GS.do", sParam);
    		    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    		        		        if(hidden_ofc_cd == ""){
    		        		        	formObject.office_cd.value="";
    		        		        	ComShowCodeMessage("COM130402", "Office Code"); 		
    		        		        	ComSetFocus(document.form.office_cd);		
    		        		        } 
    		              		}
    		              		break;
    		              	case "sales_rep_cd":
    		              		if(formObject.sales_rep_cd.value.length>0){	
    		              			formObject.f_cmd.value=SEARCH03;
    		    		 			var sParam="f_cmd="       +formObject.f_cmd.value
    		    		 						+ "&hidden_ofc_cd=" +formObject.sales_rep_cd.value;
    		    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0007GS.do", sParam);
    		    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    		        		        if(hidden_ofc_cd == ""){
    		        		        	formObject.sales_rep_cd.value="";
    		        		        	ComShowCodeMessage("COM130402", "Sales Rep Code"); 		
    		        		        	ComSetFocus(document.form.sales_rep_cd);
    		        		        	return false;
    		        		        } 
    		        		        srepCd=hidden_ofc_cd;
    		        		        checkSRepCd(srepCd);
    		              		}
    		              		break;
    	             			}   // end switch
    					}catch(e) {
    		          		if( e == "[object Error]") {
    		          			ComShowMessage(OBJECT_ERROR);
    		          		} else {
    		          			ComShowMessage(e.message);
    		          		}
    		          	}  		
    					break;
    		 case SEARCH02:
    			 var formObject=document.form;
    	            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
    	            var sheetObject1=sheetObjects[0];
    	            /*******************************************************/
    	        		try {
    	        		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    	                switch(srcName) {  
    	   	              	case "customer_cd":
    	   	              		if(formObject.customer_cd.value.length>0){	        	
    	   	              			formObject.f_cmd.value=SEARCH04;
    	   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
    	   	    		 						+ "&hidden_ofc_cd=" +formObject.customer_cd.value;
    	   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0007GS.do", sParam);
    	   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
    	   	        		        if(hidden_ofc_cd == undefined){
    	   	        		        	formObject.customer_cd.value="";
    	   	        		        	ComShowCodeMessage("COM130402", "Customer Code"); 		
    	   	        		        	ComSetFocus(document.form.customer_cd);		
    	   	        		        } else {
    	   	        		        	formObject.customer_cd.value=hidden_ofc_cd;
    	   	        		        }
    	   	              		}
    	   	              		break;
    	   	             case "cus_code":
 	   	              		if(formObject.cus_code.value.length>0){	
 	   	              			formObject.f_cmd.value=SEARCH04;
 	   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
 	   	    		 						+ "&hidden_ofc_cd=" +formObject.cus_code.value;
 	   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0007GS.do", sParam);
 	   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
 	   	        		        if(hidden_ofc_cd == undefined){
 	   	        		        	formObject.cus_code.value="";
 	   	        		        	formObject.cus_name.value="";
 	   	        		        	ComShowCodeMessage("COM130402", "Customer Code"); 		
 	   	        		        	ComSetFocus(document.form.cus_code);		
 	   	        		        }else{
 	   	        		        		formObject.f_cmd.value=SEARCH08;
 	   	        		        		var Xml=sheetObj.GetSearchData("ESM_SAM_0007GS.do", FormQueryString(formObject));
	   	        		        		var pcus_code=(ComGetEtcData(Xml, "cus_code") == undefined) ? "" : ComGetEtcData(Xml, "cus_code");
	   	        		        		if(pcus_code != "null"){
	   	        		        			formObject.f_cmd.value=SEARCH07;
	   	        		        			var Xml=sheetObj.GetSearchData("ESM_SAM_0007GS.do", FormQueryString(formObject));
	 	   	        		        		var cus_name=(ComGetEtcData(Xml, "cus_name") == undefined) ? "" : ComGetEtcData(Xml, "cus_name");
	   	        		        			formObject.cus_code.value=hidden_ofc_cd;
		 	   	        		        	if(cus_name == "null") {   	        		        		
			 	   				    			ComShowCodeMessage("COM130402", "Customer Name");
			 	   				    			formObject.cus_name.value="";
			 	   				    		}else{
			 	   				    			formObject.cus_name.value=cus_name;
			 	   					    	}	
	   	        		        		}else{
	   	        		        			formObject.cus_code.value="";
		 	   				    			formObject.cus_name.value="";
	   	        		        			ComShowCodeMessage("COM132201", "Customer Code");
		 	   				    			ComSetFocus(formObject.cus_code);	
	   	        		        		}	
 	   	        		        }
 	   	              		}else{
 	   	              			formObject.cus_name.value="";
 	   	              		}
 	   	              		break;
    	        		}   // end switch
    	   				}catch(e) {
    	   	          		if( e == "[object Error]") {
    	   	          			ComShowMessage(OBJECT_ERROR);
    	   	          		} else {
    	   	          			ComShowMessage(e.message);
    	   	          		}
    	   	          	}  	
    	   				break;
    		 case SEARCH03:
     			var formObject=document.form;
 	            /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
 	            var sheetObject1=sheetObjects[0];
 	            /*******************************************************/
 	        		try {
 	        		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
 	                switch(srcName) {  
 	   	              	case "team_cd":
 	   	              		if(formObject.team_cd.value.length>0){	
 	   	              			formObject.f_cmd.value=SEARCH06;
 	   	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
 	   	    		 						+ "&hidden_ofc_cd=" +formObject.team_cd.value;
 	   	    		 			var sXml=sheetObject1.GetSearchData("ESM_SAM_0007GS.do", sParam);
 	   	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
 	   	        		        if(hidden_ofc_cd == ""){
 	   	        		        	formObject.team_cd.value="";
 	   	        		        	ComShowCodeMessage("COM130402", "Team Code"); 		
 	   	        		        	ComSetFocus(document.form.team_cd);		
 	   	        		        } 
 	   	              		}
 	   	              		break    
 	        		}   // end switch
 	   				}catch(e) {
 	   	          		if( e == "[object Error]") {
 	   	          			ComShowMessage(OBJECT_ERROR);
 	   	          		} else {
 	   	          			ComShowMessage(e.message);
 	   	          		}
 	   	          	}  	
 	   				break
		 	 case IBINSERT: // Row Add		 		 
		 		addRow();
		 	 	ComBtnEnable("btn_new_down");
		 	 	ComBtnDisable("btn_create");
 			 break; 
        }
    }catch(e){
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
       }
    }
    /**
     * 모든 콤보 박스 조회
     * 공통 부분 완성되면 추가 작업 요
     */
   	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
   		switch (sAction) {
   			case SEARCH: // load page 시
   				var formObj=document.form;
   			    var param="f_cmd="+SEARCH+"&scr_no="+"0007";
   			    var sXml=sheetObj.GetSearchData("ESM_SAM_COMGS.do",param);
   	     		var rtnValue=sXml.split("|$$|");
   	     		samActSubTypeCombo=rtnValue[3];			//samActSubTypeCombo
   	     		for(var i=0; i<rtnValue.length; i++){
   	     			if(i!=3){
						var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
						var cdName=comboXml[0].split("|");
						var cdValue=comboXml[1].split("|");
						for (var j=0; j < cdName.length; j++) {
							comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);			
	 					}
   	     			}
   	     		}
     		break;		
   		}
   		search_type.SetSelectCode("P");
     }
     /**
      * COM_ENS_071 : 팝업에서 선택한 값 한개 받기 
      * @author 서미진
 	 * @version 2011.02.21
      */
     function getCOM_ENS_041_cust_nm(rowArray) {    	
     	var formObject=document.form;
     	var sheetObj=sheetObjects[0];
     	var colArray=rowArray[0];	
//     	obj=event.srcElement;	
     	formObject.f_cmd.value=SEARCH08;
     	formObject.cus_code.value=colArray[3];
     	var Xml=sheetObj.GetSearchData("ESM_SAM_0007GS.do", FormQueryString(formObject));
   		var pcus_code=(ComGetEtcData(Xml, "cus_code") == undefined) ? "" : ComGetEtcData(Xml, "cus_code");
   		if(pcus_code != "null"){
   			formObject.f_cmd.value=SEARCH07;
   			var Xml=sheetObj.GetSearchData("ESM_SAM_0007GS.do", FormQueryString(formObject));
        		var cus_name=(ComGetEtcData(Xml, "cus_name") == undefined) ? "" : ComGetEtcData(Xml, "cus_name");
        		formObject.cus_code.value=colArray[3];
        		com_change_sheet(sheetObjects[0], "cus_code" );	
	        	if(cus_name == "null") {   	        		        		
	    			ComShowCodeMessage("COM130402", "Customer Name");
	    			formObject.cus_name.value="";
	    		}else{
	    			formObject.cus_name.value=colArray[4];
		    	}	
   		}else{
   			formObject.cus_code.value="";
    			formObject.cus_name.value="";
   			ComShowCodeMessage("COM132201", "Customer Code");
    			ComSetFocus(formObject.cus_code);	
   		}	
     }
    /**
     * 콤보 초기설정값, 헤더 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 이관샨
     * @version 2011.06.22
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "purpose1":
            case "purpose2":
            case "channel":
                var i=0;
                with(comboObj) {
                    SetDropHeight(260);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                }
                break; 
        }
    }   	
    /**
     * Office Code. OnKeyPress 시 호출된다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchOfficeName
     * </pre>
     * @param {sheetObj} sheetObj
     * @return 없음
     * @author 이관샨
     * @version 2011.06.16
     */
    function searchOfficeCodeName(obj) {   
    }
      /**
       * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
       * <br><b>Example :</b>
       * <pre>
       *    btnImgEnable(obj, gb);
       * </pre>
       * @param  {form} obj 필수 Html Object
       * @param  {bool} gb  필수 true : 활성화 false : 비활성화
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */ 
       function btnImgEnable(obj, gb) {
           if(obj.constructor == String){
               obj=document.getElementsByName(obj)[0];        
           }
           var btnStyle=obj.style;
           if (gb){
//               obj.SetEnable(1);
               btnStyle.cursor="hand";
               btnStyle.filter="";
               obj.disabled=false;
           } else {
//               obj.SetEnable(0);
               btnStyle.cursor="auto";
               btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
               obj.disabled=true;
           }
       }
     /**
      * Office Inquiry(공통Popup) 호출후 Return받는 함수. <br>
      * callBackComEns071(arrBal);
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
      */    	
      function callBackComEns071(rArray){
      		var formObj=document.form;
      		if(rArray != null){
      			ComSetObjValue(formObj.office_cd, ComLpad(rArray[0][3],6,""));  				    			   			
      		}
      }
 /**
  * User Auth를 확인하여 able, disable 상태 및 버튼 컨트롤
  * @author 서미진
  * @version 2012.02.15
  */
 function checkUserCodeName() {   
    	 var formObject=document.form;    		 
  		// Actual Date exist.
 		 if(formObject.actual_dt.value != ""){
 			 ComBtnDisable("btn_create");
 			 ComBtnDisable("btn_new_down");
 			 ComBtnDisable("btn_save");   			 
        	purpose1.SetEnable(0);
        	purpose2.SetEnable(0);
        	channel.SetEnable(0);
//        	ComSetObjValue(formObject.inland_rates, "");
//        	ComSetObjValue(formObject.inland_rates, "");
//        	ComSetObjValue(formObject.inland_rates, "");
        	formObject.srep_cmt_desc.readOnly=true;
        	formObject.srep_cmt_desc.setAttribute("className","input2");
        	formObject.cus_code.readOnly=true;  
        	formObject.cus_code.setAttribute("className","input2");
        	formObject.plan_dt.readOnly=true;  
        	formObject.plan_dt.setAttribute("className","input2");
        	formObject.sls_mgr_cmt_desc.readOnly=true;
        	formObject.sls_mgr_cmt_desc.setAttribute("className","input2");
        	btnImgEnable(formObject.btn_plan_dt, false);
            btnImgEnable(formObject.btn_customer_code, false);     			 
 		 }else { 
 	  		// Actual Date is null
    		 // case 1. Manager 
    		 if(userAuth != ''){		 
		 		    ComBtnEnable("btn_sls_report");
		        	ComBtnEnable("btn_new_down");
		        	ComBtnEnable("btn_save");
		        	formObject.srep_cmt_desc.readOnly=true;
		        	formObject.srep_cmt_desc.setAttribute("className","input2");
		        	formObject.cus_code.readOnly=true;  
		        	formObject.cus_code.setAttribute("className","input2");
		        	formObject.plan_dt.readOnly=true;  
		        	formObject.plan_dt.setAttribute("className","input2");
		        	btnImgEnable(formObject.btn_plan_dt, false);
		            btnImgEnable(formObject.btn_customer_code, false); 
		        	purpose1.SetEnable(0);
 		        	purpose2.SetEnable(0);
 		        	channel.SetEnable(0);
		        	formObject.sls_mgr_cmt_desc.readOnly=false;
		        	formObject.sls_mgr_cmt_desc.setAttribute("className","input");
		        	formObject.sales_rep_cd.readOnly=false;
		        	formObject.sales_rep_cd.setAttribute("className","input1");   
    		 }
    		 // case 2. Sales Rep  		 
    		 if(formObject.srep_cd.value == formObject.sales_rep_cd.value){		
		 		    ComBtnEnable("btn_create");
		 		    ComBtnEnable("btn_sls_report");
		        	ComBtnEnable("btn_new_down");
		        	ComBtnEnable("btn_save");
 		        	purpose1.SetEnable(1);
 		        	purpose2.SetEnable(1);
 		        	channel.SetEnable(1);
 		          	formObject.srep_cmt_desc.readOnly=false;
 		        	formObject.srep_cmt_desc.setAttribute("className","input");
 		        	formObject.plan_dt.readOnly=false;  
 		        	formObject.plan_dt.setAttribute("className","input1");
		        	formObject.cus_code.readOnly=false;  
		        	formObject.cus_code.setAttribute("className","input1");
		        	btnImgEnable(formObject.btn_plan_dt, true);
		        	btnImgEnable(formObject.btn_customer_code, true); 
		        	formObject.sales_rep_cd.readOnly=true;
		        	formObject.sales_rep_cd.setAttribute("className","input2");   
		        	formObject.sls_mgr_cmt_desc.readOnly=true;
		        	formObject.sls_mgr_cmt_desc.setAttribute("className","input2");
		        	formObject.sales_rep_cd.readOnly=true;
		        	formObject.sales_rep_cd.setAttribute("className","input2");   			 
    		 }
    		// case 3. Manager + Sales Rep 
    		 if(userAuth != '' && formObject.srep_cd.value == formObject.sales_rep_cd.value){		 
		        	formObject.sls_mgr_cmt_desc.readOnly=false;
		        	formObject.sls_mgr_cmt_desc.setAttribute("className","input");
		        	formObject.sales_rep_cd.readOnly=false;
		        	formObject.sales_rep_cd.setAttribute("className","input1");   
    		 }
   		}
}
      /**
       * Srep Cd 확인<br>
       * <br><b>Example :</b>
       * <pre>
       *     촏차
       * </pre>
       * @param {sheetObj} sheetObj
       * @return 없음
       * @author 이관샨
       * @version 2011.06.22
       */
      function checkSRepCd(srepCd) {   
	     	 var formObject=document.form;
	     	 var pSrepCd=formObject.srep_cd.value;
	     	 if(srepCd != pSrepCd){	 
		     		sheetObjects[0].RemoveAll();
        			purpose1.SetSelectCode("");
        			purpose2.SetSelectCode("");
        			channel.SetSelectCode("");
        			search_type.SetSelectCode("P");
        			combo_status.SetSelectCode("");
        			formObject.srep_cmt_desc.value="";
        			formObject.sls_mgr_cmt_desc.value="";
        			formObject.plan_dt.value="";
        			formObject.actual_dt.value="";
        			formObject.cus_code.value="";
        			formObject.cus_name.value="";
        			formObject.cre_dt.value="";
        			formObject.cre_usr_id.value="";
		     		btnImgEnable(formObject.btn_plan_dt, false);
		            btnImgEnable(formObject.btn_customer_code, false);
		            ComBtnDisable("btn_create");
		            ComBtnDisable("btn_new_down");
		            ComBtnDisable("btn_save");
	     	 }else{
	     		 	ComBtnEnable("btn_create");
	     	 } 
      }
      /**
       * Purpose2 동적 콤보 
       * load시 생성된 xml정보로 Purpose1변경할 때마다 Purpose2콤보를 생성
       * @returns 없음
       * @author 서미진
       * @version 2011.06.21
       */
      function purpose1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
    	 comboObjects[3].RemoveAll();
         var formObj=document.form;          
         var purCd=purpose1.GetSelectCode();
 		 var cdName=ComXmlString(samActSubTypeCombo, "cd_desc").toString().split("|");
		 var cdValue=ComXmlString(samActSubTypeCombo, "cd").toString().split("|");
		 var cdPurpose1=ComXmlString(samActSubTypeCombo, "cd_etc").toString().split("|"); 
		 var cdDesc="";
		 var cd="";
		 var j=0;
		 for (var i=0; i < cdName.length; i++) {	 
			 if(purCd == cdPurpose1[i]){							 
					 comboObjects[3].InsertItem(j, cdName[i], cdValue[i]);	
					 j++;
			 }	 
		 } 
		 //purpose1 콤보 
		 var sheetObj=sheetObjects[0];
         var arrText=newText.split("|");
	     if (arrText != null && arrText.length > 1) {
	      		formObj.purpose1.value=comboObj.GetText(newCode, 1);
      		}
          com_change_sheet(sheetObj, "purpose1" );
      	}
      /**
       * Purpose 콤보 
       *
       * @returns 없음
       * @author 이관샨
       * @version 2011.06.21
       */
      function purpose2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
    	   var formObj=document.form;
           var sheetObj=sheetObjects[0];
           var arrText=newText.split("|");
       	if (arrText != null && arrText.length > 1) {
       		formObj.purpose2.value=comboObj.GetText(newCode, 1);
       	}
           com_change_sheet(sheetObj, "purpose2" );
       	}
       /**
        * Channel 콤보 
        * 
        * @returns 없음
        * @author 이관샨
        * @version 2011.06.21
        */
       function channel_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, code, text) {
     	   var formObj=document.form;
            var sheetObj=sheetObjects[0];
            var arrText=newText.split("|");
        	if (arrText != null && arrText.length > 1) {
        		formObj.channel.value=comboObj.GetText(newCode, 1);
        	}
            com_change_sheet(sheetObj, "channel" );
    	}
 /**
  * 필드 데이타가 CHANGE될 경우 이벤트
  */
 function obj_change(){
	  var formObject=document.form;
	  try {
		  var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		  switch(srcName){
//		      case "office_cd":
			  case "sales_rep_cd":
				  	doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
					break;
		      case "customer_cd":
			  case "cus_code":
				  	doActionIBSheet(sheetObjects[0], formObject, SEARCH02);
					break;
			  case "team_cd":
				  	doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
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
      * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     initControl()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이관샨
      * @version 2011.06.03
      */    
       function initControl() {
	       //Axon 이벤트 처리1. 이벤트catch(개발자변경)      
	      axon_event.addListenerForm('blur', 'obj_deactivate', document.form);   
//		  axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		  axon_event.addListenerForm('change', 'obj_change', form);
		  axon_event.addListener('keydown', 'ComKeyEnter', 'form');
       } 
   /**
    * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
    * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *   com_change_sheet( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} colNm 필수 Html Object의 name
    * @return 없음
    * @author 김민아
 	* @version 2010.10.13
    */  
    function com_change_sheet( sheetObj, colNm ){
    	
    	if(createRow == -1){
    		//create없이 save할 때 타는 로직    			
    		var nowRow = sheetObj.GetSelectRow();
        	
        	var formObj=document.form;
            var eleValue="";
            if(nowRow != -1){
    	        if(document.getElementById(colNm).type=="text"){
    	            switch(colNm){
    	                default:
    	                    eleValue=document.getElementById(colNm).value;     
    	                    break;                  
    	            }           
    	            sheetObj.SetCellValue(nowRow,colNm,eleValue);
    	        }else{
    	        	sheetObj.SetCellValue(nowRow,colNm,document.getElementById(colNm).value);
            	}
            }
    		
    	}else{
    		//create시 타는 로직
    		var nowRow = createRow;
    		
    		var formObj=document.form;
            var eleValue="";
            if(nowRow != -1){
    	        if(document.getElementById(colNm).type=="text"){
    	            switch(colNm){
    	                default:
    	                    eleValue=document.getElementById(colNm).value;     
    	                    break;                  
    	            }           
    	            sheetObj.SetCellValue(nowRow,colNm,eleValue);
    	        }else{
    	        	sheetObj.SetCellValue(nowRow,colNm,document.getElementById(colNm).value);
            	}
            }
    	}
    }   
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
   	 switch (sAction) {
    		case IBSEARCH: // 조회
    			if(frmObj.office_cd.value.length < 5) {
    				ComShowCodeMessage("COM130403", "Office Code"); // Office Code is null
    				ComSetFocus(document.form.office_cd);					
    				return false;
//    			}else if(frmObj.sales_rep_cd.value.length != 5) {
//    				ComShowCodeMessage('COM130403', "Sales Rep Code"); // Sales Rep Code is null
//    				ComSetFocus(document.form.sales_rep_cd);					
//    				return false;
    			}
    		break;
   	 	} 
   	 return true;
     }
     /**
      * OnKeyPress event를 처리한다. <br>
      * @author 서미진
      * @version 2011.02.22
      */     
    function obj_keypress() {	   
 	 	obj=event.srcElement;	 	
 	 	keyValidation(obj);
        var formObj=document.form;
        var eleObj=window.event.srcElement;
        var srcName=eleObj.getAttribute("name");
        switch(srcName) {
           case "plan_dt":						//날짜형식에 맞게 입력 되도록
           		checkDateForm(formObj.plan_dt);
           break;
       }
    } 	
      /**
       * Onbeforedeactivate  event를 처리한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_deactivate()
       * </pre>
       * @param 없음
       * @return 없음
       * @author 김민아
       * @version 2010.10.13
       */   
       function obj_deactivate() {
           var formObj=document.form;
           var sheetObj=sheetObjects[0];   
           var eleName=ComGetEvent('name');
           switch(eleName){     
               default:      
            	   com_change_sheet( sheetObj, eleName );
           }          
       } 
	      /**
	 * 키보드로 입력되는 값 제어
	 * @param obj
	 */
	function keyValidation(obj){
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		switch(obj.dataformat){
			// 정수형 숫자
		    case "num": 
		    case "ymd":
		    case "yyyy":
		    case "hm":
		        ComKeyOnlyNumber();
		    break;
		    // 실수형 숫자
		    case "float":
		        ComKeyOnlyNumber(event.srcElement, ".");
		    break;
		    // 영문자
		    case "eng":
		        ComKeyOnlyAlphabet();
		    break;
		    // 영소문자
		    case "engdn":
		        ComKeyOnlyAlphabet('lower');
		    break;
		    // 영대문자
		    case "engup": 
		        ComKeyOnlyAlphabet('upper');
		    break;
		    //영대문자+숫자
		    case "uppernum": 
		    	ComKeyOnlyAlphabet('uppernum');
		    break;
		    //영문+숫자+공통특수문자(./()@&-', _)
		    case "engnum": 
		   	  	ComKeyOnlyAlphabet('num', "32|38|39|40|41|44|45|46|47|64|95");
		    break;
		    //숫자+"-" 입력가능
		    case "fax":
	     	case "tel":
	     		ComKeyOnlyNumber(event.srcElement, "-");
	     	break;
	     	//숫자+"-._@" 입력가능
	     	case "email":
	     		ComKeyOnlyAlphabet('num', "45|46|64|95");
	     	break;
	     	 case "engupspecial": // 영문대문자 + Space + &-,.
	         ComKeyOnlyAlphabet('uppernum', "32|38|39|40|41|44|45|46|47|64|95");
	         break;
	     	case "engupbracket": // 영문대문자 + Space + &-,.[]
	        ComKeyOnlyAlphabet('uppernum', "32|38|39|40|41|44|45|46|47|64|95|91|93");
	        break;
	     	//영문+숫자+공통특수문자+한글 등등
	     	default:
	     		if ((keyValue >= 33 && keyValue <= 37) ||(keyValue >= 42 && keyValue <= 43) || (keyValue >= 58 && keyValue <= 63) || (keyValue >= 91 && keyValue <= 94))
	     		{
	     			event.keyCode=false;
	     		}
		    break;
		}
	}
	/**
	 * DATE 값이 변경 되었을 때 값의 유효성을 체크
	 */
	function checkDateForm() {
		ComKeyOnlyNumber(obj);
		var srcValue=obj.value;
	 	if (srcValue.length == 4) {
	 		obj.value=srcValue.substring(0,4) + "-"
	 	}
	 	if (srcValue.length == 7) {
	 		obj.value=srcValue.substring(0,7) + "-"
	 	}
	}
      /**
       * sheet1의 add row 에 대한 처리
       * 새로운 row를 추가한다.
       * @author 이관샨
       * @version 2011.06.17
       */
	  var createRow =-1; 
      function addRow() {
 	 			var maxRow=sheet1.DataInsert(-1);
 	 			sheet1_OnSelectCell(sheet1, 0 , "2",  maxRow, 2);
 	 			sheet1.SetSelectRow(-1);
 	 			createRow = maxRow;
 	 			sheet1.SetRowHidden(maxRow,1);
 	 			sheet1.SetCellValue(maxRow, "activity_no",createRow - 1);
 	 			sheet1.SetCellValue(maxRow, "sls_code",document.form.sales_rep_cd.value);
 	 			sheet1.SetCellValue(maxRow, "sls_name",sheet1.GetCellValue(maxRow, "sls_name"));
 	 			sheet1.SetCellValue(maxRow, "cus_code",document.form.cus_code.value);
 	 			sheet1.SetCellValue(maxRow, "cre_dt",document.form.cre_dt.value);
 	 			sheet1.SetCellValue(maxRow, "cre_usr_id",document.form.cre_usr_id.value);
 	 			sheet1.SetCellValue(maxRow, "cus_name",document.form.cus_name.value);
 	 			sheet1.SetCellValue(maxRow, "srep_cmt_desc",document.form.srep_cmt_desc.value);
 	 			sheet1.SetCellValue(maxRow, "sls_mgr_cmt_desc",document.form.sls_mgr_cmt_desc.value);
 	 			sheet1.SetCellValue(maxRow, "plan_dt",document.form.plan_dt.value);
 	 			sheet1.SetCellValue(maxRow, "actual_dt",document.form.actual_dt.value);
	           
	            return true;
      }
	/* 개발자 작업  끝 */