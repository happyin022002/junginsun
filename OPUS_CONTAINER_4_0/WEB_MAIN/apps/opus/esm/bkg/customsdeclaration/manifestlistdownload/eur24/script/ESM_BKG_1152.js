/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1152.js
*@FileTitle  : Europe Advanced Manifest - EXS Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/29
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @extends 
     * @class ESM_BKG_1152 : ESM_BKG_1152 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1152() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.sheet1_OnKeyUp=sheet1_OnKeyUp;
    }
   	/* 개발자 작업	*/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
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
    	var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//화면에서 필요한 이벤트
		initControl();
		sheet1_OnSearchEnd(sheetObjects[0], 'ErrMsg');	
	}
    function initControl() {
    	var formObject=document.form;
     	axon_event.addListenerForm  ('click', 'bkg_click',  formObject); //- onClick     
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm  ('change', 'bkg_change', formObject);
        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerFormat('keyup', 'obj_KeyUp', formObject); //- 키보드 입력할때
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
 		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);        
    }
/*********************** KEY EVENT START ********************/ 	 
  
	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var formObj=document.form;    	
	    switch (ComGetEvent("name")) {
	    	case "p_from_dt":
	    		ComAddSeparator(event.srcElement);
				break;	    		
	    	case "p_to_dt":
	    		ComAddSeparator(event.srcElement);
				break;	    		
	    }
    }           
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "p_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "p_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
		}
	}       
	function div_init(){
		sheetObjects[0]=sheetObjects[0].Reset();
		initSheet(sheetObjects[0],1);
		//sheetObjects[0].SetRangeBackColor(1,7,2,14,"#CBD2F8");
		form.div_sent_bl_cnt.value="";
		form.div_acc_bl_cnt.value="";
		form.div_rej_bl_cnt.value="";
		form.div_nrcv_bl_cnt.value="";
		form.div_donld_bl_cnt.value="";
		form.div_hold_bl_cnt.value="";
		form.div_rel_bl_cnt.value="";
		form.div_total_bl.value="";
		form.div_total_vvd.value="";
		form.div_total_amd_cnt.value="";
	}
	function bkg_click(){
		switch(event.srcElement.name){	
		case "p_rhq_gb":
			if(document.form.p_rhq_gb[0].checked){
				// 초기화
				document.getElementById("p_pol_ofc").style.display="";
				document.getElementById("p_bkg_ofc").style.display="none";
				div_init();
			} else if(document.form.p_rhq_gb[1].checked){
				// 초기화
				document.getElementById("p_pol_ofc").style.display="none";
				document.getElementById("p_bkg_ofc").style.display="";
				div_init();
			}
			break;
		}
	}
	
	
     /**
      * 조회후 이벤트 처리 >>> 폰트 칼라변경
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {
             var redColor="#FF0000";
             for(var i=HeaderRows(); i<= LastRow(); i++) {
            	 if (GetCellValue(i,"exs_snt_rejt") != "0") {
                 	SetCellFontColor(i,"exs_snt_rejt",redColor);
                }
            	 if (GetCellValue(i,"exs_snt_donl") != "0") {
                 	SetCellFontColor(i,"exs_snt_donl",redColor);
                }
            	 if (GetCellValue(i,"exs_snt_nrcv") != "0") {
                 	SetCellFontColor(i,"exs_snt_nrcv",redColor);
                }
            	 if (GetCellValue(i,"exs_snt_hold") != "0") {
                 	SetCellFontColor(i,"exs_snt_hold",redColor);
                }
            	 if (GetCellValue(i,"exs_unsnt_cnt") != "0") {
                 	SetCellFontColor(i,"exs_unsnt_cnt",redColor);
                }
             }
             ColumnSort("1|2|3|4|5|6");
         }//end width
     }	     
 	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 	document.onclick=processButtonClick;
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
          var srcName=ComGetEvent("name");
          switch(srcName) {
          	case "btn_Retrieve":
          		doActionIBSheet(sheetObject1,formObject,IBSEARCH);
          		break;
          	case "btn_New":
          		formObject.reset();
          		document.getElementById("p_pol_ofc").style.display="";
          		document.getElementById("p_bkg_ofc").style.display="none";
          		div_init();
          		break;
 			case "btn_DownExcel":
				if(sheetObject1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
					return;
				}
  				sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol( 				sheetObject1), SheetDesign:1,Merge:1 });
 				break;
 			case "btn_date":	
 				var cal=new ComCalendarFromTo();
 				cal.setEndFunction("endDateSet");
 				cal.select(formObject.p_from_dt, formObject.p_to_dt,'yyyy-MM-dd');
 				break;
          } // end switch
     }
	 function endDateSet(){
		 if (ComIsNull(form.p_from_mt)) {
			form.p_from_mt.value="00:00";
		 }
		 if (ComIsNull(form.p_to_mt)) {
			 form.p_to_mt.value="23:59";
		 }
	  }
	 /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCLEAR: // 화면 로딩시 코드 조회
        		sheetObj.RemoveAll();
			break;
			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
//				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				sheetObj.RemoveAll();
 				var sXml=sheetObj.GetSearchData("ESM_BKG_1152GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(ComGetEtcData(sXml,"total_bl_cnt") == undefined){
					formObj.div_sent_bl_cnt.value="0";
					formObj.div_acc_bl_cnt.value="0";
					formObj.div_rej_bl_cnt.value="0";
					formObj.div_donld_bl_cnt.value="0";
					formObj.div_nrcv_bl_cnt.value="0";
					formObj.div_hold_bl_cnt.value="0";
					formObj.div_rel_bl_cnt.value="0";
					formObj.div_total_bl.value="0";
					formObj.div_total_vvd.value="0";
					formObj.div_total_amd_cnt.value="0";
				}else{
					formObj.div_sent_bl_cnt.value=ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_acc_bl_cnt.value=ComGetEtcData(sXml,"acc_bl_cnt");
					formObj.div_rej_bl_cnt.value=ComGetEtcData(sXml,"rej_bl_cnt");
					formObj.div_donld_bl_cnt.value=ComGetEtcData(sXml,"donld_bl_cnt");
					formObj.div_nrcv_bl_cnt.value=ComGetEtcData(sXml,"nrcv_bl_cnt");
					formObj.div_hold_bl_cnt.value=ComGetEtcData(sXml,"hold_bl_cnt");
					formObj.div_rel_bl_cnt.value=ComGetEtcData(sXml,"rels_bl_cnt");
					formObj.div_total_bl.value=ComGetEtcData(sXml,"total_bl_cnt");
					formObj.div_total_vvd.value=ComGetEtcData(sXml,"total_vvd_cnt");
					formObj.div_total_amd_cnt.value=ComGetEtcData(sXml,"total_amd_cnt");
				}
//				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				
				formObj.div_rej_bl_cnt.style.color="#FF0000";
				formObj.div_nrcv_bl_cnt.style.color="#FF0000";
				formObj.div_donld_bl_cnt.style.color="#FF0000";
				formObj.div_hold_bl_cnt.style.color="#FF0000";
				
				break;
        }//end switch
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    			if (!ComIsNull(formObj.p_from_mt)) {
    				var from_mt_temp="";
    				var arr_mt=formObj.p_from_mt.value.split(":")
    				if(ComIsNull(arr_mt[0])){
    					from_mt_temp="00:";
    				}else{
    					if(eval(arr_mt[0])> 23 ) from_mt_temp="23:";
    					else from_mt_temp=eval(arr_mt[0])< 10 ? "0"+eval(arr_mt[0])+":":arr_mt[0]+":";
    				}
    				if(ComIsNull(arr_mt[1])){
    					from_mt_temp +="00";
    				}else{
    					if(eval(arr_mt[1])> 59 ) from_mt_temp +="59";
    					else from_mt_temp += eval(arr_mt[1])< 10 ? "0"+eval(arr_mt[1]):arr_mt[1];
    				}
    				formObj.p_from_mt.value=from_mt_temp;
    			}
    			if (!ComIsNull(formObj.p_to_mt)) {
    				var to_mt_temp="";
    				var arr_mt2=formObj.p_to_mt.value.split(":")
    				if(ComIsNull(arr_mt2[0])){
    					to_mt_temp="00:";
    				}else{
    					if(eval(arr_mt2[0])> 23 ) to_mt_temp="23:";
    					else to_mt_temp=eval(arr_mt2[0])< 10 ? "0"+eval(arr_mt2[0])+":":arr_mt2[0]+":";
    				}
    				if(ComIsNull(arr_mt2[1])){
    					to_mt_temp +="00";
    				}else{
    					if(eval(arr_mt2[1])> 59 ) to_mt_temp +="59";
    					else to_mt_temp += eval(arr_mt2[1])< 10 ? "0"+eval(arr_mt2[1]):arr_mt2[1];
    				}
    				formObj.p_to_mt.value=to_mt_temp;
    			}
	    		if ( (!ComIsNull(formObj.p_from_dt) && !ComIsNull(formObj.p_to_dt)) ) {
	    			if( ComGetDaysBetween(formObj.p_from_dt.value,formObj.p_to_dt.value) +1 > 31){
		    			ComShowCodeMessage('COM132001','Send/Received Date','31 Days');
		    			formObj.p_from_dt.focus();
		    			return false;
		    		}
	    			return true;
	    		}
	    		//기본포멧체크
    			if (ComIsNull(formObj.p_vvd)) {
		    		if (ComIsNull(formObj.p_from_dt)) {
		    			ComShowCodeMessage('BKG00104','From Date');
		    			formObj.p_from_dt.focus();
		    			return false;    
		    		}
	    			if (ComIsNull(formObj.p_to_dt)) {
	    				ComShowCodeMessage('BKG00104','To Date');
	 					formObj.p_to_dt.focus();
	 					return false;    
	    			}
    			}
				break;
	    }
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
    	if ((srcName == "p_vvd" || srcName == "p_pol") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){

		      var HeadTitle1="";
		      var HeadTitle2="";
		      var HeadTitle3="";
		      if(document.form.p_rhq_gb[0].checked){
		      HeadTitle1="|VVD|LANE|EU POL|B.POL|POL OFC|B/L Count|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)";
		      HeadTitle2="|VVD|LANE|EU POL|B.POL|POL OFC|B/L Count|Sent|Sent|Sent|Sent|Sent|Sent|Unsent|Amend";
		      HeadTitle3="|VVD|LANE|EU POL|B.POL|POL OFC|B/L Count|Acpt|Rjct|DNL|N.rcvd|Hold|RLS|Unsent|Amend";
		      } else if (document.form.p_rhq_gb[1].checked){
		      HeadTitle1="|VVD|LANE|EU POL|B.POL|BKG OFC|B/L Count|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)|EXS (B/L)";
		      HeadTitle2="|VVD|LANE|EU POL|B.POL|BKG OFC|B/L Count|Sent|Sent|Sent|Sent|Sent|Sent|Unsent|Amend";
		      HeadTitle3="|VVD|LANE|EU POL|B.POL|BKG OFC|B/L Count|Acpt|Rjct|DNL|N.rcvd|Hold|RLS|Unsent|Amend";
		      }
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"},
		                  { Text:HeadTitle3, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lane",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"eu_pol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_tot_cnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exs_snt_accp",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exs_snt_rejt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exs_snt_donl",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exs_snt_nrcv",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exs_snt_hold",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exs_snt_rels",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exs_unsnt_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exs_amd_cnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetCountPosition(0);
		      SetSheetHeight(400);
		            }

				break;
		}//end switch
 	}     
    /* 개발자 작업  끝 */
