/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_0141.js
*@FileTitle : MOT/SSE Tariff 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
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
     * @class ESM_PRI_0141 : ESM_PRI_0141 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

   	/* 개발자 작업	*/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var sheet1;
    var sheet2;
    var motTrfSeqList;
    var isAproUsr=false;
    var selectedMotTrfSeq;
    var selectedIdx;
	var motDstBsePortCdValue="";
	var motDstBsePortCdText="";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
	
	
    /** 
     * IBSheet Object를 sheetObjects 배열로 등록 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj IBSheet Object
     * @return 없음
     * @see #
     * @author 김대호
     * @version 2009.09.04
     */ 
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
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
     * @version 2009.09.04
     */ 
    function loadPage() {
        var form=document.form;
        sheet1=sheetObjects[0];
        sheetCnt=sheetObjects.length ;
        //IBSheet 초기화
        for(i=0;i<sheetCnt;i++){
            ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
        }
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    initControl();
	    
		doActionIBSheet(sheet1, document.form, IBSEARCH_ASYNC10);
		
		// 당일 날짜로 default setting
		gCurrDate=ComGetDateAdd(null, "D", 0)
		ComPriTextCode2ComboItem ( motOrgBsePortCdValue, motOrgBsePortCdText, getComboObject(comboObjects, 'f_org_cd') ,"|","\t"  );
		ComPriTextCode2ComboItem ( motCntrTpCdValue, motCntrTpCdText, getComboObject(comboObjects, 'f_cntr_tp_cd') ,"|","\t"  );
		ComPriTextCode2ComboItem ( motCmdtTpCdValue, motCmdtTpCdText, getComboObject(comboObjects, 'f_cmdt_tp_cd') ,"|","\t" );
		ComPriTextCode2ComboItem ( motCntrSzCdValue, motCntrSzCdText, getComboObject(comboObjects, 'f_cntr_sz_cd') ,"|","\t" );
        sheet1.SetWaitImageVisible(0);
    }
    
    function initControl() {
    	
    	axon_event.addListenerForm('focus', 'obj_activate', document.form);
		axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
		//axon_event.addListenerForm('change', 'obj_change', document.form);
		//axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
		axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
    }
    
    
     /**
      * OnKeyDown event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param 없음
      * @return 없음
      * @author 강효진
      * @version 2010.04.26
      */       
     function obj_keydown(){
        //enter key조회
        var eleName=event.srcElement.name;
        if (eleName == "exec_dt" ){
            var keyValue=null;
            if(event == undefined || event == null) {
         	   keyValue=13;
            }else{
         	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            }
            if (keyValue == 13){
         	   doActionIBSheet( sheet1, document.form, IBSEARCH );
            }
        }
     }
 	/**
 	 * OnBeforeActivate   event를 처리한다. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     obj_activate()
 	 * </pre>
 	 * @param 없음
 	 * @return 없음
 	 * @author 박성수
 	 * @version 2009.04.17
 	 */
 	function obj_activate() {
 		var formObject=document.form;
 	    var srcName=ComGetEvent("name");
 	    if (srcName == "eff_dt_hidden" && formObject.eff_dt_hidden.value != "") {
 	    	var effDt=formObject.eff_dt_hidden.value;
 	    	formObject.eff_dt.value=formObject.eff_dt_hidden.value;
     		comboObjects[1].SetText(selectedMotTrfSeq, 0, effDt); 
 			comboObjects[1].SetText(selectedMotTrfSeq, 4, effDt);
 			formObject.eff_dt_hidden.value="";
 	    } else if (srcName == "scope_year") {
 	    } else if ( srcName == "file_dt") {
			var fileDt=formObject.file_dt.value; 
			fileDt=fileDt.replace(/-/gi, "");
			formObject.file_dt.value=fileDt;
	    }
 	}	
     /** 
      * Object 의 Onbeforedeactivate 이벤트핸들러 <br>
      * 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param  없음  
      * @return 없음
      * @see #
      * @author 강효진
      * @version 2010.04.23
      */ 
     function obj_deactivate() {
        ComChkObjValid(event.srcElement);
  		var formObject=document.form;
 	    var srcName=ComGetEvent("name");
 	    if ( srcName="file_dt" ) {
 	    	var fileDt=formObject.file_dt.value;
 			if (ComIsDate(fileDt) || fileDt == "" ) {
 				if ( fileDt != "" ) {
	 				fileDt=fileDt.replace(/-/gi, "");
	 				fileDt=fileDt.substring(0, 4) + "-" + fileDt.substring(4, 6) + "-" + fileDt.substring(6, 8); 
	 				document.form.file_dt.value=fileDt;
 				}
 			} else {
 				ComShowCodeMessage("COM12134", "File Date");
 				document.form.file_dt.value="";
 				return false;
 			}
 	    }
     }
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
     * @version 2009.09.04
     */ 
    function initSheet(sheetObj, sheetNo) {
    	
    	with(sheetObj){
             var cnt=0;
			 var sheetID=sheetObj.id;
			 
			 switch(sheetID) {
				 
			 	 case "sheet1":
				 SetSheetHeight(450);
				 //no support[check again]CLT 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				 //SetAutoRowHeight(0);
				
				 var HeadTitle = "|Sel.|Del Check|Seq.|svc_scp_cd|mot_trf_seq|rt_seq|Carrier|Lane|Origin\n(POR)|Dest\n(DEL)|CNTR\nType" +
					"|CMDT\nType|Size|Rate|Commission||BAF|CAF|O.THC|D.THC|*APS|*CSR|*PSC|*PCC|*PCS|*STF|D.ACT|D.DDC|D.DDF|D.NFC|O.ENS|O/D|T.DIS|T.GOH|T.WSC|Remark(s)";
				 var headCount=ComCountHeadTitle(HeadTitle);
				
				 SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				 var headers = [ { Text:HeadTitle, Align:"Center"} ];
				 InitHeaders(headers, info);
				
				 var cols = [ 	{Type:"Status",    	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								{Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
								{Type:"DelCheck",  	Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
								{Type:"Text",      	Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      	Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      	Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mot_trf_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      	Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"carrier",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Text",      	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mot_file_lane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Combo", 	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mot_trf_org_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Combo", 	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mot_trf_dest_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Combo", 	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mot_trf_cntr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Combo", 	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mot_trf_cmdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Combo", 	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mot_trf_cntr_sz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mot_trf_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"blnk1",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int"  ,      Hidden:0, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"blnk2",               KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"baf_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"caf_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"othc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dthc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"aps_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"csr_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"psc_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pcc_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pcs_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"stf_amt",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dact_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dddc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dddf_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"dnfc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"oens_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"od_amt",              KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"tdis_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"tgoh_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Int"  ,      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"twsc_amt",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"text",      	Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"mot_trf_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
								  
				 InitColumns(cols);
				
				 SetEditable(1);
				 SetColProperty("mot_trf_org_cd", 		{ComboText:motOrgBsePortCdText, ComboCode:motOrgBsePortCdValue} );
				 SetColProperty("mot_trf_dest_cd", 		{ComboText:motDstBsePortCdText, ComboCode:motDstBsePortCdValue} );
				 SetColProperty("mot_trf_cntr_tp_cd", 	{ComboText:motCntrTpCdText, ComboCode:motCntrTpCdValue} );
				 SetColProperty("mot_trf_cmdt_tp_cd", 	{ComboText:motCmdtTpCdText, ComboCode:motCmdtTpCdValue} );
				 SetColProperty("mot_trf_cntr_sz_cd", 	{ComboText:motCntrSzCdText, ComboCode:motCntrSzCdValue} );
				 SetEllipsis(1);
				 SetCountPosition(0);
				
				 //conversion of function[check again]CLT                     InitDataValid(0, "mot_trf_rt_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "baf_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "caf_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "othc_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "dthc_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "aps_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "csr_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "psc_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "pcc_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "pcs_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "stf_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "dact_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "dddc_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "dddf_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "dnfc_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "oens_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "od_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "tdis_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "tgoh_amt", vtNumericOnly);
				 //conversion of function[check again]CLT                     InitDataValid(0, "twsc_amt", vtNumericOnly);
				 SetColHidden("del_chk",1);
				 SetShowButtonImage(2);
				 break;
			 
			 } //switch end
			 
    	} //with end
    	
    }
    
    
    document.onclick=processButtonClick;
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function processButtonClick() {
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheet1,document.form,IBSEARCH);
				break;
			/*
			case "btn_new":
				doActionIBSheet(sheet1,document.form,IBCREATE);
				break;
			*/
            case "btn_new":
            	removeAll(document.form);
  				break;
            case "btn_save":
            	if (validateForm(sheet1,document.form,IBSAVE)) {
   					doActionIBSheet(sheet1, formObject, IBSAVE);
   				}	
   				break;                    
			case "btn_confirm":
				doActionIBSheet(sheet1,document.form,IBSEARCH_ASYNC01);
				break;
			case "btn_confirmcancel":
				doActionIBSheet(sheet1,document.form,IBSEARCH_ASYNC02);
				break;
			case "btn_delete":
				doActionIBSheet(sheet1,document.form,IBSEARCH_ASYNC03);
				break;
			case "btn_loadexcel":
				doActionIBSheet(sheet1,document.form,IBLOADEXCEL);
				break;
			case "btn_downexcel":
				doActionIBSheet(sheet1,document.form,IBDOWNEXCEL);
				break;
            case "btns_calendar": //달력버튼
    			if (comboObjects[0].GetSelectCode()== "") {
    				ComShowCodeMessage('PRI08002');
    				return false;
    			}
                var cal=new ComCalendar();
                cal.select(formObject.eff_dt_hidden, 'yyyy-MM-dd');
                break;
            case "btn_add":
            	doActionIBSheet(sheet1, formObject, IBINSERT);
					break;
            case "btn_del":
            	doActionIBSheet(sheet1, formObject, IBDELETE);
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
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
     * @version 2009.09.04
     */ 
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH: //조회
				if (validateForm(sheet1,document.form,IBSEARCH) == false ) return;
				ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_PRI_0141GS.do", FormQueryString(formObj) );
                ComOpenWait(false);
                break;
			case IBSEARCH_ASYNC10: // 화면 로딩시 Service Scope 조회
				comboObjects[0].RemoveAll();
				formObj.f_cmd.value=SEARCH01;
			
				var sXml=sheetObj.GetSearchData("ESM_PRI_0141GS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
				break;
			
			case IBSEARCH_ASYNC11: // Service Scope 선택시, Effective Date, Filing Date, Confirm Date, Confirm Flag 조회
				
				
				
				formObj.f_cmd.value=COMMAND15;
				var sParam = FormQueryString(formObj) + "&prc_ctrt_tp_cd=S&svc_scp_cd=" + comboObjects[0].SetSelectCode+ "&usr_id=" + formObj.usr_id.value;
			
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrAuth=ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr=true;
				} else {
					isAproUsr=false;
				}
				comboObjects[1].RemoveAll();
				comboObjects[1].InsertItem(0, "|||", "X");
				comboObjects[1].SetSelectCode("X");

				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("ESM_PRI_0141GS.do", FormQueryString(formObj));
				var arrXml=sXml.split ( "|$$|" );
				if ( arrXml.length > 0 ) {
					ComPriXml2ComboItem(arrXml[0], mot_trf_seq, "mot_trf_seq", "eff_dt|file_dt|cfm_dt|cfm_flg|eff_dt", false);
				}
                //f_dest_cd
				comboObjects[7].RemoveAll();
				if ( arrXml.length > 1 ) {
					var arrMotDstBsePortCd=ComPriXml2ComboString ( arrXml[1], "cd", "cd");
					motDstBsePortCdText=" |"+arrMotDstBsePortCd[0];
					motDstBsePortCdValue=" |"+arrMotDstBsePortCd[0];
	                sheetObjects[0].SetColProperty("mot_trf_dest_cd", {ComboText:motDstBsePortCdText, ComboCode:motDstBsePortCdValue} );
	                ComPriTextCode2ComboItem(motDstBsePortCdValue, motDstBsePortCdText, getComboObject(comboObjects, 'f_dest_cd') ,"|","\t" );
				}
                //f_lane_cd
				comboObjects[2].RemoveAll();
                if ( arrXml.length > 2 ){
                	var arrMotFileLaneCd=ComPriXml2Array ( arrXml[2], "cd|nm");
                	if(arrMotFileLaneCd == null || arrMotFileLaneCd == undefined) return;
                	var motFileLaneValue=" ";
                	var motFileLaneText=" \t "
                	for ( var i=0; i < arrMotFileLaneCd.length; i++ ) {
                		motFileLaneValue += "|" + arrMotFileLaneCd[i][0];
                		motFileLaneText += "|" + arrMotFileLaneCd[i][0] + "\t" + arrMotFileLaneCd[i][1];
                	}
	                ComPriTextCode2ComboItem( motFileLaneValue, motFileLaneText, getComboObject(comboObjects, 'f_lane_cd') ,"|","\t" );
                }
                
                
                break;
            case IBLOADEXCEL:      //download excel
            	sheetObj.RemoveAll();
			
            	sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",WorkSheetName:"",Append:false,ColumnMapping:""});
            	
				break;
            case IBDOWNEXCEL:      //download excel
            	if ( sheetObj.RowCount() <= 0) return;            	
            	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(            	sheetObj), SheetDesign:1,Merge:1 });
	           	break;
            case IBSEARCH_ASYNC01:        //Confirm
            case IBSEARCH_ASYNC02:        //Confirm Cancel
         	    formObj.f_cmd.value=MULTI;
    			formObj.cfm_flg.value=( sAction == IBSEARCH_ASYNC01 ? "Yes" : "No" );
 				var sParam=FormQueryString(formObj);
 				if (!ComPriConfirmSave()) {
 					return false;
 				}
 				try {
 					ComOpenWait(true);
 					var sXml=sheet1.GetSaveData("ESM_PRI_0141GS.do", sParam);
 					sheet1.LoadSaveData(sXml);
 					ComOpenWait(false);
 				} catch (e) {
       	            if (e == "[object Error]") {
       	                ComShowMessage(OBJECT_ERROR);
       	            } else {
       	                ComShowMessage(e.message);
       	            }
       	       } finally {
       	    	   ComOpenWait(false);
       	       }	
 			   doActionIBSheet(sheet1,document.form,IBSEARCH);
        	   break;
            case IBSEARCH_ASYNC03:        // 삭제 
         	    formObj.f_cmd.value=MULTI01;
 				var sParam=FormQueryString(formObj);
 				if (!ComPriConfirmSave()) {
 					return false;
 				}
 				try {
 					ComOpenWait(true);					
 					var sXml=sheet1.GetSaveData("ESM_PRI_0141GS.do", sParam);
 					sheet1.LoadSaveData(sXml);
 					ComOpenWait(false);
 				} catch (e) {
       	            if (e == "[object Error]") {
       	                ComShowMessage(OBJECT_ERROR);
       	            } else {
       	                ComShowMessage(e.message);
       	            }
       	       } finally {
       	    	   ComOpenWait(false);
       	       }	
       	       if ( comboObjects[1].GetSelectCode()!= "X" ) {
    	    	   doActionIBSheet ( sheet1, document.form, IBSEARCH_ASYNC11);
    	    	   if ( comboObjects[1].GetItemCount() > 1 ){
    	    		   comboObjects[1].SetSelectIndex(1);
    	    	   }
    	       } 
        		 break;
            case IBSAVE:        //저장
         	    formObj.f_cmd.value=MULTI;
 				var sParam=FormQueryString(formObj);
 				var sParamSheet1=ComPriSetPrifix ( sheet1.GetSaveString(), "sheet1_");
 				if (sheet1.IsDataModified()&& sParamSheet1 == "") {
 					return;
 				}
 				sParam += "&" + sParamSheet1;
 				if (!ComPriConfirmSave()) {
 					return false;
 				}
 				try {
 					ComOpenWait(true);
 					var sXml=sheet1.GetSaveData("ESM_PRI_0141GS.do", sParam);
 					sheet1.LoadSaveData(sXml);
 					ComOpenWait(false);
 				} catch (e) {
       	            if (e == "[object Error]") {
       	                ComShowMessage(OBJECT_ERROR);
       	            } else {
       	                ComShowMessage(e.message);
       	            }
       	       } finally {
       	    	   ComOpenWait(false);
       	       }	
       	       if ( comboObjects[1].GetSelectCode()== "X" ) {
       	    	   var effDt=formObj.eff_dt.value;
       	    	   doActionIBSheet ( sheet1, document.form, IBSEARCH_ASYNC11);
       	    	   var idx=comboObjects[1].FindItem( effDt, 0, true );
       	    	   if ( idx != -1 ){
       	    		   comboObjects[1].SetSelectCode(idx);
       	    	   }
       	       } else {
       	    	   doActionIBSheet(sheet1,document.form,IBSEARCH);
       	       }
        		 break;
            case IBINSERT: // Row Add
            	var idx=sheetObj.DataInsert();
           		break;
           	 case IBDELETE: // Delete
           		deleteRowCheck(sheetObj, "chk", true);
           		break;	 
        }
    }
 	/**
      * OnSearchEnd 시 발생한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} ErrMsg    
      * @return 없음
      * @author 이승준
      * @version 2009.06.10
      */
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg)  {
  		var formObj=document.form;
  		if ( formObj.inq_tp_cd.value == "2") {
  			sheetObj.SetColHidden( "bkg_src_tp_cd" ,0);
  			sheetObj.SetColHidden( "bkg_no" ,0);
  		} else {
  			sheetObj.SetColHidden( "bkg_src_tp_cd" ,1);
  			sheetObj.SetColHidden( "bkg_no" ,1);
  		}
  	}
	/**
	 * 콤보 초기설정값 정의 <br>
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initCombo(comboObj, comboNo);
	 * </pre>
	 * @param {ibcombo} sheetObj 필수 IBSheet Object
	 * @param {int} ComboNo 필수 IBCombo Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "svc_scp_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetMaxLength(3);
	            	SetImeMode("inactive");
	            	ValidChar(2);

	            }
	            break;
	        case "mot_trf_seq":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(0);
	            	
	            	// 마지막 컬럼은 hidden(size = 0)으로 처리.
					SetColWidth(0, "80");
					SetColWidth(1, "100");
					SetColWidth(2, "0");
					SetColWidth(3, "0");
					SetColWidth(4, "0");
					SetImeMode("inactive");
					ValidChar(2,1);

	            }
	            break;
	    }
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         로직처리;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "X" ) {
				return false;
			}
			return true;
			break;
		case IBCREATE: // New
			return true;
			break;
		case IBSAVE: // Save
			if (!ComChkValid(formObj)) {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			if (comboObjects[0].GetSelectCode()== "") {
				ComShowCodeMessage('PRI00308', 'select', 'Service Scope');
				return false;
			}
			if (formObj.eff_dt.value == "") {
				ComShowCodeMessage('PRI00308', 'input', 'Effective Date');
				return false;
			}
			if (formObj.file_dt.value == "") {
				ComShowCodeMessage('PRI00308', 'input', 'File Date');
				return false;
			}
			if (formObj.eff_dt.value <= formObj.file_dt.value) {
				ComShowCodeMessage('PRI00354', 'File Date');
				return false;
			}
			return true;
			break;
		case IBSEARCH_ASYNC01: // Confirm
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			if (subDataCnt <= 0) {
				ComShowCodeMessage("PRI08005");
				return false;
			}
			return true;
			break;
		case IBSEARCH_ASYNC02: // Cancel Confirm
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() != "YES") {
				return false;
			}
			return true;
			break;
		case IBDELETE: // Delete
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			return true;
			break;
		case IBCOPYROW: // Copy
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			return true;
			break;
		}
	}
	/**
	 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == MULTI01) {
				ComPriSaveCompleted();
			} else if (document.form.f_cmd.value == MULTI02) {
				ComPriConfirmCompleted();
			} else if (document.form.f_cmd.value == MULTI03) {
				ComPriCancelConfirmCompleted();
			} else if (document.form.f_cmd.value == MULTI04) {
				ComPriDeleteCompleted();
			}
		}
	}
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function svc_scp_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		var formObj=document.form;
		var arrText=NewText.split("|");
		// SVC_SCP 바뀌면 svc_scp_nm세팅하고 Duration 재조회.
		if (arrText != null && arrText.length >= 1) {
			selectedMotTrfSeq=null;
			setSvcScpCdName(false, NewCode);
		}
	}
	function svc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var svcScpCdTxt=comboObj.GetSelectText();
		// 3자(Scope의 길이)이상 입력하면 focus out.
		if (svcScpCdTxt.length > 3) {
			document.form.svc_scp_nm.focus();
		}
	}
	function svc_scp_cd_OnClear(comboObj) {
		var formObject=document.form;
		formObject.svc_scp_nm.value="";
		//comboObj.SetSelectIndex(-1);
		comboObjects[0].SetSelectIndex(-1);
	}
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    ssvc_scp_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
//	function svc_scp_cd_OnBlur(comboObj) {
//		setSvcScpCdName(true, null);
//	}
	
	
	/**
	 * set Name of SVC_SCP_CD.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    setSvcScpCdName(true, null);
	 * </pre>
	 * @param   {Boolen} isOnBlur 필수 true/false
	 * @param   {String} val 선택 svc_scp_cd value
	 * @return 없음
	 * @version 2014.09.30
	 */
	function setSvcScpCdName(isOnBlur, val) {
		var formObj=document.form;		
		var code="";
		if(isOnBlur) {
			code = comboObjects[0].FindItem(comboObjects[0].GetSelectCode(), 0);
		}else{
			code = val;
		}
		// 키보드입력을 통해 SVC_SCP 바꾸고 focus out했을때 Duration 재조회
		if (code != null && code != "") {
			var text=comboObjects[0].GetText(code, 1);
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value=comboObjects[0].GetText(code, 1);
				doActionIBSheet(sheet1, document.form, IBSEARCH_ASYNC11);
			}
		}
	}
	
	
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function mot_trf_seq_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		var formObj=document.form;
		selectedMotTrfSeq=NewCode;
		if (NewCode == "" || NewText == "" ) {
			return;
		}
		var effDt=comboObj.GetText(NewCode, 0);
		var fileDt=comboObj.GetText(NewCode, 1);
		var cfmDt=comboObj.GetText(NewCode, 2);
		var cfmFlg=comboObj.GetText(NewCode, 3);
		formObj.eff_dt.value=effDt;
		formObj.file_dt.value=fileDt;
		formObj.cfm_dt.value=cfmDt;
		formObj.cfm_flg.value=cfmFlg
		if (NewCode == null || NewCode == "" || NewCode == "X") {
			return true;
		}
		doActionIBSheet(sheet1, document.form, IBSEARCH);
	}
	function mot_trf_seq_OnClear(comboObj) {
		var formObj=document.form;
		//comboObj.SetSelectCode("X");
		comboObjects[1].SetSelectCode("X");
		formObj.eff_dt.value="";
		formObj.file_dt.value="";
		formObj.cfm_flg.value="";
		formObj.cfm_dt.value="";
		//formObj.cre_usr_nm.value = "";
		//formObj.cre_ofc_cd.value = "";
		//clearAllTabPages();
		removeAll(formObj);
	}
	function mot_trf_seq_OnKeyUp(comboObj, KeyCode, Shift) {
		var selEffDt=comboObj.GetSelectText();
		// 숫자 외의 것이 있다면(문자가 입력된것이 있다면), ""로 relace하고 다시 세팅.
		if (selEffDt.search(/[^0-9]/gi) >= 0) {
			selEffDt=selEffDt.replace(/[^0-9]/gi, "");
			comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
		}
		// 날짜 8자 입력하면 focus out.
		if (selEffDt.length == 8) {
			if ( ComIsDate(selEffDt)) {
				selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8);
				comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
			}
			document.form.file_dt.focus();
		}
	}
	function mot_trf_seq_OnFocus(comboObj) {
		var selEffDt=comboObj.GetSelectText();
		// 날짜부분의 하이픈 제거.
		if (selEffDt != null && selEffDt != "") {
			selEffDt=selEffDt.replace(/-/gi, "");
			comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
		}
	}
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    ssvc_scp_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function mot_trf_seq_OnBlur(comboObj) {
		var selEffDt=comboObj.GetSelectText();
		var formObj=document.form;
		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
			return false;
		}
		// 올바른 날짜가 맞다면, 하이픈 다시 넣어주기.
		if (ComIsDate(selEffDt)) {
			selEffDt=selEffDt.replace(/-/gi, "");
			selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
			document.form.eff_dt.value=selEffDt;
			comboObj.SetText(selectedMotTrfSeq, 4, selEffDt);
		} else {
			ComShowCodeMessage("COM12134", "Effective Date");
			document.form.mot_trf_seq.focus();
			return false;
		}
	}
    /**
     * 화면 전체를 리셋한다.<br>
     * 데이터가 변경된 경우 저장한다.
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {form} formObj 
     * @param {String} gubun    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
	function removeAll(formObj) {
		if (sheet1.IsDataModified()) {
			if (ComShowCodeConfirm("PRI00006")) {
				doActionIBSheet(sheet1, formObj, IBSAVE);
			} else {
		 		sheet1.RemoveAll();
			}
		} else {	
	 		sheet1.RemoveAll();
		}
	}
	/**
    * sheet를 클릭시 발생한다.<br>
    * 체크박스를 언체크 한다.
    * <br><b>Example :</b>
    * <pre>
    *     sheet1_OnClick(sheetObj, Row, Col, Value)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 
    * @param {int} Col   
    * @param {String} Value   
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function sheet1_OnClick(sheetObj, Row, Col, Value)  {
 	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 	    var formObj=document.form;
 	    var colname=sheetObj.ColSaveName(Col);
      	switch(colname)
      	{
      		case "mot_trf_rmk":
	    		sheetObj.SetCellEditable(Row,"mot_trf_rmk",0);
	    		ComShowMemoPad(sheetObj, Row, Col, false, 550);
	    		break; 
      		case "chk" :
    			if (Value == "0") {
    				sheetObj.SetCellValue(Row, "del_chk","0");
    			}
    			break;
      	}      	
	}
	/**
    * OnSaveEnd 시 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     searchConditionReset(formObj,gubun)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {String} ErrMsg    
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
//	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
//		if (ErrMsg == "") {
//			ComPriSaveCompleted();
//		}
//	}
	
	
	
	
	/* 개발자 작업  끝 */