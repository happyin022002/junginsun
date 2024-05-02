/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0018.js
*@FileTitle : Requested Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.15 김진일
* 1.0 Creation
* 
* History
* 2012.02.01 진마리아 CHM-201215859-01 전도금 비용 수정 기능 추가 요청건(spp로부터 입력받는 전도금을 alps 화면을 통해 수정하여 저장 가능하도록)
* 2012.03.09 진마리아 CHM-201216307-01 Canal invoice 화면 변경 및 File download 기능 개발
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
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
     * @class vop_pso_0018 : vop_pso_0018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0018() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {

	    		case "btns_calendar":
	    			openCalendar("ymd");
	    			break;
	    		case "btn_Close":
	    			self.close();
	    			break;
	    		case "btn_BankInformation":
	    			ComOpenPopup('VOP_PSO_0203.do?vndrSeq='+formObject.vndr_seq.value, 620, 300,'', '1,0,1,1,1,1,1,1', true, true);
	    			break;
	    		case "btn_DownExcel":
	    			/*
	    			if (sheetObject1.RowCount <= 0) {
	    				// There is no related data!
	    				ComCodeMsgByNoRelatedData();
	    				return;
	    			} else {
	    				if (sheetObject1.RowCount > 0) {
	    					//sheetObject1.Down2Excel(1,true,true,true,"","",false,false,"Requested Advance Payment");
	    					sheetObject1.Down2Excel(-1,false,true,true,"","",false,false,"Requested Advance Payment");
	    				}
	    			} 
	    			*/
	    			f_DownExcel();
	    			break;
	
	    		case "btn_Confirm":
	    			
	    			//alert(srcName);
	    			//이미 inv_vo가 있으면 button click안되게
	//  			alert("["+formObject.inv_no.value+"]");
	//  			if(formObject.inv_no.value != ""&&formObject.inv_no.value != undefined){
	//  			ComShowCodeMessage("PSO01001");
	//  			break;
	//  			}
	//  			for(var j=sheetObject1.HeaderRows ; j<=sheetObject1.RowCount;j++)//강제로 Insert로 만든다
	//  			sheetObject1.CellValue2(j,0) = "I";
	    			if(!ComShowCodeConfirm("PSO00041", "confirm")){
	    				return;
	    			}
	    			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
	    			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC01);
	    			break;
	
	    		case "btn_Reject":
	    			if(!ComShowCodeConfirm("PSO00041", "reject")){
	    				return;
	    			}
	    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
	    			break;

	    		case "btn_Print":
	    			if (sheetObjects[0].RowCount == 0){
	    				ComShowMessage("Retrieve at first.");
	    				return;
	    			}
//	    			if(!ComShowCodeConfirm("PSO00041", "print")){
//	    				return;
//	    			}
	    			rdOpen( formObject);
	    			break;
	    			
	    		case "btn_CreateCSR":
	    			//						alert(srcName);
	//  			ComShowMessage("Under Construction!!!");
	    			break;
	
	    		case "btn_Print":
	    			//						alert(srcName);
	    			break;
	    			
	    		case "btn_Save":
	    			doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
	    			break;

    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    function openCalendar(mode) {
		switch (mode) {
		case "ymd":
			var cal = new ComCalendar();
			cal.setDisplayType('date');
			cal.select(document.form.due_dt, "yyyy-MM-dd");
			break;
		default:
			break;
		}
	}

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

//            for(i=0;i<sheetObjects.length;i++){
//            		doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
//            }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
//			sheetObjects[0].RowEditable(2) = true;
//			sheetObjects[0].CellEditable(2, 6) = true;
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat('blur', 'obj_deactivate', form);
		axon_event.addListenerFormat('focus', 'obj_activate', form);
    }

  //Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate() {
		ComChkObjValid(event.srcElement);
	}
	
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
    function obj_keypress() {
		obj = event.srcElement;
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
	
		if (obj.dataformat == null)
			return;
	
		if (keyValue === 13) {
			//필수 입력 조건인 WorkMonth의 값이 설정 되어있는가를 확인한다.
			var formObject = document.form;
			if (formObject.revyrmon.value === ""
					|| formObject.revyrmon.value === undefined) {
				ComShowCodeMessage("PSO00003", "Work Month");
				formObject.revyrmon.focus();
				return;
			}
			//IBCOMBO에 설정된 값을 vndr_seq파라미터에 셋팅한다.
			formObject.vndr_seq.value = comboObjects[0].Code;
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	
			return true;
		}
	
		window.defaultStatus = obj.dataformat;
	
		switch (obj.dataformat) {
		case "ymd":
		case "ym":
		case "hms":
		case "hm":
		case "jumin":
		case "saupja":
			ComKeyOnlyNumber(obj);
			break;
		case "int":
			if (obj.name == "txtInt")
				ComKeyOnlyNumber(obj, "-")
			else
				ComKeyOnlyNumber(obj);
			break;
		case "float":
			ComKeyOnlyNumber(obj, "-.");
			break;
		case "eng":
			ComKeyOnlyAlphabet();
			break;
		case "engup":
			if (obj.name == "txtEngUp2")
				ComKeyOnlyAlphabet('uppernum')
			else if(obj.name==="vsl_slan_cd") 
				ComKeyOnlyAlphabet('uppernum');	//영대문자와 숫자
			else
				ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
			if (obj.name == "txtEngDn2")
				ComKeyOnlyAlphabet('lowernum')
			else
				ComKeyOnlyAlphabet('lower');
			break;
		}
	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 var sheetid = sheetObj.id;
    	 switch(sheetid) {

	    	 case "sheet1":
	    		 with (sheetObj) {
	    			 // 높이 설정
	    			 style.height = 262;
	    			 //전체 너비 설정
	    			 SheetWidth = mainTable.clientWidth;
	
	    			 //Host정보 설정[필수][HostIp, Port, PagePath]
	    			 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	    			 //전체Merge 종류 [선택, Default msNone]
	    			 MergeSheet = msHeaderOnly;
	
	    			 //전체Edit 허용 여부 [선택, Default false]
	    			 Editable = true;
	
	    			 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			 InitRowInfo(1, 1, 3, 100);
	
	//  			 var HeadTitle1 = "|Seq.|COST CODE|ITEM|AMOUNT($)|Remark|Tariff Amount|Diff.|Detail"; //ORG .. BUT DETAIL DEL.
	    			 var HeadTitle1 = "|Seq.|COST CODE|ITEM|AMOUNT($)|Remark|Tariff Amount|Diff.|Formula|Formula Expression|Hidden1|Hidden2|Hidden3|h4|h5|h6|h7|h8|h9|h10|vvd|callSeq|org rqst amt";
	    			 var headCount = ComCountHeadTitle(HeadTitle1);
	
	    			 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			 InitColumnInfo(headCount, 6, 0, true);
	
	    			 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			 InitHeadMode(false, true, false, true, false,false);
	
	    			 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			 InitHeadRow(0, HeadTitle1, true);
	
	    			 var prefix = "sheet1_"
	    				 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			 InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	true,		prefix+"ibflag");
	    			 InitDataProperty(0, cnt++ , dtSeq,					50,		daCenter,	true,		"Seq");
	    			 InitDataProperty(0, cnt++ , dtData,				60,	    daCenter,	true,		prefix+"lgs_cost_cd",				false,		"",	dfNone,				0,		false,	true);
	    			 InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		true,		prefix+"lgs_cost_full_nm",						false,		"",	dfNone,				0,		false,	true);
	    			 InitDataProperty(0, cnt++ , dtAutoSum,				110,	daRight,	true,		prefix+"rqst_amt",					false,		"",	dfNullFloat,	2,		false,	true);
	    			 InitDataProperty(0, cnt++ , dtData,				290,	daLeft,		true,		prefix+"diff_rmk" ,					false,		"",	dfEngKey,				0,		true,	true);
	    			 InitDataProperty(0, cnt++ , dtAutoSum,				100,	daRight,	true,		prefix+"calc_amt",		false,		"",	dfNullFloat,	2,		false,		true);
	    			 InitDataProperty(0, cnt++ , dtData,				100,	daRight,	true,		"Diff",						false,		"|sheet1_rqst_amt|-|sheet1_calc_amt|",	dfNullFloat,	2,		false,		true);
	    			 InitDataProperty(0, cnt++ , dtData,				160,	daLeft,		true,		prefix+"dflt_xpr_desc",					false,		"",	dfNone,				0,		false,		true);
	    			 InitDataProperty(0, cnt++ , dtData,				60,		daLeft,		true,		prefix+"sys_xpr_desc",					false,		"",	dfNone,				0,		false,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	true,		prefix+"yd_chg_no",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	true,		prefix+"yd_chg_ver_seq",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	true,		prefix+"yd_cd",					false,		"",	dfNone,				0,		true,		true);
	
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"suz_net_tong_wgt",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"locl_xch_rt",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"tr_vol_val",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				60,	daCenter,	true,		prefix+"due_dt",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"inv_no",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"cntr_pnm_capa",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"inv_rgst_no",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"vvd",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"call_seq",					false,		"",	dfNone,				0,		true,		true);
	    			 InitDataProperty(0, cnt++ , dtHidden,				0,	daCenter,	true,		prefix+"org_rqst_amt",				false,		"",dfNullFloat,	2,		true,	true);
	
	
	    			 InitDataValid(0, prefix+"diff_rmk", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
	
	//  			 ImageList(0) = "img/btng_detail.gif";		// Detail
	    			 Ellipsis  = true;
	
	    		 }
	    		 break;
	    		 
	    	 case "sheet2":
	    		 with (sheetObj) {
	    			 // 높이 설정
	    			 style.height = 120;
	    			 //전체 너비 설정
	    			 SheetWidth = mainTable.clientWidth;
	
	    			 //Host정보 설정[필수][HostIp, Port, PagePath]
	    			 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	    			 //전체Merge 종류 [선택, Default msNone]
	    			 MergeSheet = msHeaderOnly;
	
	    			 //전체Edit 허용 여부 [선택, Default false]
	    			 Editable = false;
	
	    			 SelectHighLight = false;
	
	    			 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			 InitRowInfo(1,1, 7, 100);
	
	    			 var HeadTitle1 = "AGENT BANK ACCOUNT DETAILS AS UNDER|AGENT BANK ACCOUNT DETAILS AS UNDER";
	    			 var headCount = ComCountHeadTitle(HeadTitle1);
	
	    			 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			 InitColumnInfo(headCount, 0, 0, true);
	
	    			 // 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			 InitHeadMode(false, false, false, true, false,false);
	
	    			 Rows= 7;
	
	    			 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			 InitHeadRow(0, HeadTitle1, true);
	
	    			 //데이터속성    [ROW, COL,  	DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, 	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			 InitDataProperty(0, cnt++ , dtData,	150,	daCenter,	true,	"key",			false,		"",			dfNone,			0,			true,		true,		-1,			false,	false);
	    			 InitDataProperty(0, cnt++ , dtData,	240,	daLeft,		true,	"value",		false,		"",			dfNone,			0,			true,		true,		-1,			false,	false);
	
	    			 CountPosition = 0;
	    		 }
	    		 break;

    	 }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible=false;
        switch(sAction) {

          case IBSEARCH:      //조회
            formObj.f_cmd.value = SEARCH;
           	if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					ComOpenWait(true);
					sheetObj.DoSearch("VOP_PSO_0018GS.do", FormQueryString(formObj)
							+ "&" + ComGetPrefixParam("sheet1_"));
					

					// 조회 후 SCNT,SDR,TIER, LimitedtimeSurcharge 항목 설정.
					if (sheetObj.RowCount > 0) {
						formObj.inv_no.value = sheetObj.CellValue(1,
								"sheet1_inv_no");
						formObj.scnt.value = sheetObj.CellValue(1,
								"sheet1_suz_net_tong_wgt");
						formObj.sdr.value = sheetObj.CellValue(1,
								"sheet1_locl_xch_rt");
						formObj.tier.value = sheetObj.CellValue(1,
								"sheet1_tr_vol_val");
						formObj.due_dt.value = sheetObj.CellValue(1,
								"sheet1_due_dt");
						formObj.cntr_pnm_capa.value = sheetObj.CellValue(1,
								"sheet1_cntr_pnm_capa");// 2009.12.15.AllowanceTEU
						// add
						formObj.inv_rgst_no.value = sheetObj.CellValue(1,
								"sheet1_inv_rgst_no");// 2009.12.15.inv_rgst_no
						// add
						formObj.due_dt.value = sheetObj.CellValue(1,
								"sheet1_due_dt");// 2010.02.17.due_dt
//							alert(sheetObj.CellValue(1,"sheet1_due_dt"));
						
						for ( var i = 0; i < sheetObj.RowCount; i++) {
							sheetObj.CellValue2(i + 1, "sheet1_lgs_cost_cd") = sheetObj
									.CellValue(i + 1, "sheet1_lgs_cost_cd")
									.substring(0, 4);
						}
						
						/*
						 * Button Control
						 * formObj.sts.value : 12 => Paid
							    	           10 => Confirmed
						*/
						//if (formObj.sts.value == "12"){	//Paid
							//ComShowObject(document.getElementById("tb_btn_Confirm"), false);
							//ComShowObject(document.getElementById("tb_btn_Reject"), false);
						//}
						
						//[2010.05.13:jmh] Excel에서 Bank Info를 보여주기 위해
						f_SetBankInfo();
					}
					ComOpenWait(false);
				}
			}
			break;
          case IBSEARCH_ASYNC01: //Confirm btn click
          //sheetObj.ShowDebugMsg = true;
          	//alert(1);//
          	//formObj.f_cmd.value = COMMAND01;	//[2010.05.11:jmh]
          	formObj.f_cmd.value = MULTI01;		//[2010.05.11:jmh]
          	if(validateForm(sheetObj,formObj,sAction)){
				if ( sheetObj.id == "sheet1"){
					//첫 레코드의 due_dt 를 form 에 설정된 due_dt로 update한다.
					sheetObj.CellValue2(1,"sheet1_due_dt") = formObj.due_dt.value;// 2010.02.17.due_dt
					var SaveStr = ComGetSaveString(sheetObj, true, true); // 배열입니다.
					var sXml = sheetObj.GetSaveXml("VOP_PSO_0018GS.do",SaveStr + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
					var etcVal =  ComGetEtcData(sXml, "invoiceNo");
					
					/*[2010.03.21:jmh] close
					if(etcVal==="undefined" || etcVal===undefined) break;//유저가 강제 킬했을 경우 처리 
					formObj.inv_no.value = etcVal;//구해온 InvoiceNo셋팅
					ComShowCodeMessage("PSO01003");
					this.close();
					var opener = window.dialogArguments;
					opener.setAdvPyStatus("A", formObj.row.value, formObj.col.value, formObj.due_dt.value);
					*/
					
					//[2010.03.21:jmh] add, instead of top
					if(etcVal===undefined || etcVal===null || etcVal===""){
						sheetObj.LoadSaveXml(sXml);
					} else{
						formObj.inv_no.value = etcVal;//구해온 InvoiceNo셋팅
						ComShowCodeMessage("PSO01003");
//						this.close();//2012.01.20 김기원 차장님의 요청으로 창을 닫지 않고 진행할 수 있도록 한다.
						formObj.sts.value="10";//Confirm된 상태의 sts로 바꾼다.
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_Confirm");
						ComBtnDisable("btn_Reject");
						var opener = window.dialogArguments;
						opener.setAdvPyStatus("A", formObj.row.value, formObj.col.value, formObj.due_dt.value);						
					}
				}	
          	}
          	break;
          case IBSEARCH_ASYNC03: //Reject btn click
          //sheetObj.ShowDebugMsg = true;
          //formObj.f_cmd.value = COMMAND03;	//[2010.05.11:jmh]
          formObj.f_cmd.value = MODIFY;			//[2010.05.11:jmh]
          if(validateForm(sheetObj,formObj,sAction)){
        	  if ( sheetObj.id == "sheet1"){
        		  var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
        		  var sXml = sheetObj.GetSaveXml("VOP_PSO_0018GS.do",SaveStr + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
        		  var etcVal =  ComGetEtcData(sXml, "calcelResult");
        		  if(etcVal==="OK"){
        			  ComShowCodeMessage("PSO01002");
        			  this.close();
        			  var opener = window.dialogArguments;
        			  opener.setAdvPyStatus("R", formObj.row.value, formObj.col.value);

        		  }
        		  else
        			  ComShowMessage("failed to reject");
        		  //formObj.inv_no.value = etcVal;//구해온 InvoiceNo셋팅
        	  }	
          }
          break;
          
          case IBSAVE:
        	  if(validateForm(sheetObj,formObj,sAction)){
        		  ComOpenWait(true);
        		  formObj.f_cmd.value = MULTI;
        		  var SaveStr = ComGetSaveString(sheetObj, true, true);//전부
        		  var sXml = sheetObj.GetSaveXml("VOP_PSO_0018GS.do",SaveStr + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
        		  if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F"){
        			  ComOpenWait(false);
        			  ComShowMessage("failed to save");
        		  }else{
        			  setOrgCondition(sheetObj);
        			  ComOpenWait(false);
        			  ComShowCodeMessage("COM130102", "Data");
        		  }
        	  }
        	  break;
        }
    }
        

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction){
    	 case IBSEARCH_ASYNC01:
    		 if(!ComIsDate(formObj.due_dt.value)){
    			 ComShowMessage("Please Input correct Date");
    			 ComSetFocus(formObj.due_dt);
    			 return false;
    		 }
    		 break;
    		 
    	 case IBSAVE:
    		 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    			 if(sheetObj.CellValue(i, "sheet1_org_rqst_amt")!=sheetObj.CellValue(i, "sheet1_rqst_amt") && sheetObj.CellValue(i, "sheet1_diff_rmk")==""){
    				 ComShowCodeMessage('COM12130', 'Changed Amount', 'Remark');
    				 sheetObj.SelectCell(i, "sheet1_diff_rmk");
    				 return false;
    			 }
    		 }
    		 break;
    	 }
        return true;
    }


	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			var row = LastRow;
			SumText(0, "Seq") = "";
			SumText(0, "sheet1_lgs_cost_full_nm") = "Advance Payment TTL Amount:";
			CellAlign(row, "sheet1_lgs_cost_full_nm") = daRight;
			SumText(0, "Remark") = "Tariff TTL Amount ";
			CellAlign(row, "Remark") = daRight;
			
			for(var i=HeaderRows; i<HeaderRows+RowCount; i++){
				CellValue2(i, "sheet1_org_rqst_amt") = CellValue(i, "sheet1_rqst_amt");
				//org_rqst_amt는 rqst amt 변경시 변경여부를 알기 위해 존재
			}
		}
		setDiffTotal(sheetObj);
		setAmountEnable();
	}

	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		 
		switch (sheetObj.ColSaveName(Col)) {
		 	case "sheet1_rqst_amt" :
	 			if(Value!="" && Value!=sheetObj.CellValue(Row, "sheet1_org_rqst_amt")){
	 				if(sheetObj.CellValue(Row, Col)<sheetObj.CellValue(Row, "sheet1_calc_amt")/2){
	 					ComShowMessage("Request Amount is too small.");
	 				}
	 				sheetObj.CellBackColor(Row, "sheet1_diff_rmk") = sheetObj.RgbColor(255,255,051);
	 				sheetObj.SelectCell(Row, "sheet1_diff_rmk");
	 			}else{
	 				sheetObj.CellBackColor(Row, "sheet1_diff_rmk") = sheetObj.RgbColor(255,255,255);
	 			}
	 			setDiffTotal(sheetObj);
	 			break;
		}
	}
	
    function f_SetBankInfo(){
		var sXml = sheetObjects[0].GetSearchXml("VOP_PSO_0203GS.do", "vndrSeq=" + document.form.vndr_seq.value);
		var bankInfo = ComGetEtcData(sXml, "BANKINFO");
		//alert(bankInfo);	 
    	var data = bankInfo.split("@"); //2009.07.02 SPP에서 구분자를 @로 사용해서 이것으로 변경
    	var arrHead = ["To", "Favour", "Account Number", "Through", "Account Number", "Swift Code"];
    	for(var i=0; i<data.length; i++ ){
    		sheetObjects[1].CellBackColor(i+1, "key") = sheetObjects[1].HeadBackColor;
    		sheetObjects[1].CellFont("FontBold", i+1, "key") = sheetObjects[1].HeadFontBold;
    		sheetObjects[1].CellFont("FontColor", i+1, "key") = sheetObjects[1].HeadFontColor;
    		sheetObjects[1].CellValue2(i+1, "key")   = arrHead[i];
    		sheetObjects[1].CellValue2(i+1, "value") = data[i];
    	}
    }
    
    function f_DownExcel(){
		/* SpeedDown2Excel([Mode], [UseOpenFile], [NewSheet], [SaveAsName],[ReportPageUrl],[HideExcelMsg],[WriteTreeLevel], [WorkSheetName],[FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect], [IncludeImageType]) 
		 * [Mode] 내려 받기 종류 옵션. Default=0  -1이면 DataType이 dtStatus, dtHiddenStatus, dtDelCheck, dtDelCehckEx, dtHidden, dtResult에 해당하는 컬럼의 데이터는 내려 받지 않는다.
		 */
		var formObj = document.form;
		if(sheetObjects[0].RowCount == 0){
			return;
		}
		
		var initRowCount = sheetObjects[0].RowCount;

		var paramObj = new Object();
		//paramObj.title  = "Requested Advance Payment" + "\\n(" + formObj.vvd2.value + ")";
		paramObj.title  = "Requested Advance Payment" + " (VVD : " + formObj.vvd2.value + ")";
		
		var url = ComJooGetPgmTitle(sheetObjects[0], paramObj);   
		if(initRowCount == 0){
			sheetObjects[0].DataInsert(-1);
		}
		sheetObjects[0].Down2Excel(-1, false, false, true, "", url, false, false, "Requested_Advance_Payment", false, "sheet1_lgs_cost_cd");	//sheet1_lgs_cost_cd 제외
		if(initRowCount == 0){
			sheetObjects[0].RowDelete(sheetObjects[0].HeaderRows, false);
		}
		sheetObjects[1].Down2Excel(-1, true,  false, true, "", "", false, false, "Requested_Advance_Payment", false);
		
    }
    
    /**
     * 
     * <pre>
     *    Excel Title 
     * </pre>
     *
     * @param   sheetObj
     * @param   paramObj
     *          - Attribute : title         : 제목명          (default : 화면제목명);
     *                      : align         : Title 가로 정렬 {"center", "left", "right"}, (default:center)
     *                      : cols          : 타이틀 칼럼수   (default : Sheet Cols수(단, hidden Type 제외 )
     *                      : orientation   : 용지방향        {Landscape,Portrait}(default : Landscape )
     *                      : columnwidth   : 특정 Col Width  (default : 자동) ex)지정필요시, 3 col 30, 4 col 50 일때, 3:30|4:50 
     *                      : datarowheight : 특정 Row Height (default : 20) ex)지정필요시, 3 Row 30, 4 Row 50 일때, 3:30|4:50
     *                                        양식 타이틀이 아닌, 그리드 타이틀부터 1, ex2)그리드 타이틀 row Height을 50으로 변경시
     *                                        paramObj.datarowheight="1:50"
     * @author jang kang cheol
     */
    function ComJooGetPgmTitle(sheetObj, paramObj){
    	var doc   = document.all;
    	var pageUrl = "FNS_JOO_EXCEL.do?";

    	/*************************** 제목처리 **********************************/
    	var sTitle = "";
    	/*************************** 정렬처리 **********************************/
    	var sTalign = "center,left,right";
    	var sAlign = "";
    	/*************************** Col수 처리 **********************************/
    	var sCols  = "";
    	var iCols = 0;
    	/*************************** 용지방향 처리 **********************************/        
    	var sOrientation = "";

    	/*************************** 특정지정 컬럼들 width 처리 **********************************/        
    	var sColumnwidth = "";

    	/*************************** 특정지정 Row 들 Height 처리 **********************************/        
    	var sDatarowheight = "";


    	if(paramObj.title == undefined ){
    		sTitle     = doc.title.innerHTML.replace("&nbsp;","");
    		sTitle     = sTitle.replace("&amp;"," ");
    	}else{
    		sTitle     = paramObj.title;
    	}
    	if(paramObj.align == undefined ){
    		sAlign="center"; 
    	}else if(sTalign.indexOf(paramObj.align) == -1 ){
    		sAlign = "left";
    	}else{
    		sAlign = paramObj.align;
    	}
    	if(paramObj.cols == undefined ){
    		for(var i=0; i<= sheetObj.LastCol; i++){
    			if ( sheetObj.ReadDataProperty(0, i, dpDataType) != dtHidden 
    					&& 
    					sheetObj.ReadDataProperty(0, i, dpDataType) != dtHiddenStatus
    			){
    				iCols++;
    			}
    		}
    	}else{
    		iCols = eval(paramObj.cols);
    	}

    	if(paramObj.orientation == undefined ){
    		sOrientation = "Landscape";
    	}else{
    		sOrientation = paramObj.orientation;
    	}

    	if(paramObj.columnwidth == undefined ){
    		sColumnwidth = "";
    	}else{
    		sColumnwidth = paramObj.columnwidth;
    	}

    	if(paramObj.datarowheight == undefined ){
    		sDatarowheight = "";
    	}else{
    		sDatarowheight = paramObj.datarowheight;
    	}        

    	var sUrl = pageUrl+"title="+sTitle+"&align="+sAlign+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
    	return sUrl;
    }     

    /**
     * 
     * @param formObj
     */
    function rdOpen(formObj){
        var queryStr = "/rp ";
        queryStr += " ["+formObj.vvd.value+"]"; //$1
        queryStr += " ["+formObj.yd_cd.value+"]";//$2
        queryStr += " ["+formObj.vndr_seq.value+"]";//$3
        queryStr += " ["+formObj.rev_yrmon.value+"]";//$4
        queryStr += " ["+formObj.call_seq.value+"]";//$5
        queryStr += " ["+formObj.sts.value+"]";//$6
        queryStr += " ["+formObj.inv_no.value+"]";//$7
        queryStr += " ["+formObj.scnt.value+"]";//$8
        queryStr += " ["+formObj.sdr.value+"]";//$9
        queryStr += " ["+formObj.tier.value+"]";//$10
        queryStr += " ["+formObj.cntr_pnm_capa.value+"]";//$11
        queryStr += " ["+formObj.rqst_amt_sum.value+"]";//$12
        queryStr += " ["+formObj.due_dt.value+"]";//$13
        queryStr += " ["+formObj.trns_dt.value+"]";//$14
        queryStr += " ["+formObj.ofc_cd.value+"]";//$15
        queryStr += " ["+formObj.usr_nm.value+"]";//$16
//alert(queryStr);
//        formObj.com_mrdPath.value = "alps/vop/pso/estimateinvoiceaudit/canaltransitfeeestimate/report/VOP_PSO_0018.mrd";
        formObj.com_mrdPath.value = "rpt/report/VOP_PSO_0018.mrd";
        formObj.com_mrdArguments.value = queryStr;
        ComOpenRDPopupModal();
    }

    /*
     * Requested 상태인 경우, amt를 변경하고 save할 수 있도록 한다.
     */
	function setAmountEnable(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if(document.form.sts.value!="10" && document.form.sts.value!="12"){
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				sheetObj.CellEditable(i, "sheet1_rqst_amt") = true;
			}
		}
	}
	
	/*
	 * Request amt를 변경함에 따른 diff의 글자색을 변경한다.
	 */
	function setDiffTotal(sheetObj){
		with(sheetObj){
			for (var i = 1; i <= LastRow; i ++)
			{
				if (CellValue(i, "Diff") > 0)
					CellFontColor(i, "Diff") = RgbColor(255, 0, 0);		// 빨강
				else if (CellValue(i, "Diff") < 0)
					CellFontColor(i, "Diff") = RgbColor(0, 0, 255);		// 파랑
				else
					CellFontColor(i, "Diff") = RgbColor(0, 0, 0);		// 검정
			}
			//Sum의 값을 Confirm시 사용해야되므로. 
			document.form.rqst_amt_sum.value  = CellValue(LastRow, "sheet1_rqst_amt");
			document.form.calc_amt_sum.value = CellValue(LastRow, "sheet1_calc_amt");
		}
		
	}
	
	/*
	 * Confirm 이후 창을 닫지 않으며, 재조회하지 않기 위해(시간이 오래 걸리므로) 환경을 재조회한 것과 같이 한다.
	 */
	function setOrgCondition(sheetObj){
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			sheetObj.CellValue2(i, "sheet1_org_rqst_amt") = sheetObj.CellValue(i, "sheet1_rqst_amt");
			sheetObj.CellBackColor(i, "sheet1_diff_rmk") = sheetObj.RgbColor(255,255,255);
		}
		setDiffTotal(sheetObj);
	}

	/* 개발자 작업  끝 */