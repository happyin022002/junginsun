/*=========================================================
*Copyright(c) 2016 CyberLogitec 
*@FileName : ESD_EAS_0369.js
*@FileTitle : Futile Trip Container
*Open Issues :
*Change history :
*@LastModifyDate : 2016-03-29
*@LastModifier : Seong-pill Hong
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class ESD_EAS_0369 : 예)Multiple Repair CNTR by Period 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0369() { 
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	    this.initCombo				= initCombo;
		this.getBackEndJobStatus = getBackEndJobStatus;
		this.getBackEndJobLoadFile = getBackEndJobLoadFile;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code
	
	var timer = null;
	var sheetNum = null;
	
	var fdateArry = new Array(); //빠른 조회를 위해, 조회조건을 7일 단위로 쪼개서 담들 Array 시작일
	var tdateArry = new Array(); //빠른 조회를 위해, 조회조건을 7일 단위로 쪼개서 담들 Array 종료일
	var arrCnt = 0;//위 Array의 Count
	var errFlag4 = "N"; //backend job의 4번 error flag 
	var errFlag5 = "N"; //backend job의 5번 error flag

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_retrieve":
				sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				initForm();
				break;
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_mailretrieve":
				sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
				break;
			case "btn_loc_cd":
				var param="?loc_cd="+ComGetObjValue(formObject.loc_cd); 
			    param+="&pgmNo=COM_ENS_061";
		        ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 780, 470, 'getLocation', '1,0,1,1,1,1,1,1,1,1,1,1', true);	
				break;
            case "btn_start_dt":
            	var cal = new ComCalendar();
	            cal.select(formObject.fdate_tmp, "yyyy-MM-dd");
            	break;
            case "btn_end_dt":
            	var cal = new ComCalendar();
            	cal.select(formObject.tdate_tmp, "yyyy-MM-dd");
            	break;  			
			case "cntr_no_multi1":  
				rep_Multiful_inquiry("cntr_no"); 
				break;	
				
			case "btn_cntr_inquiry" :
				
				var pCntrno = "";
				if(sheetObject.SelectRow > -1){
					pCntrno = sheetObject.CellValue(sheetObject.SelectRow,"cntr_no");
				}
				
				var checkDigit = "";
				var ctnrTpszCd = "";
				var pDate2 = ComGetDateAdd(formObject.fdate_tmp, "M", 6, "-");
				var pDate1 = formObject.fdate_tmp.value;
				ComOpenPopup('/hanjin/EES_CTM_0408.do?p_cntrno='+pCntrno+'&checkDigit='+checkDigit+'&ctnrTpszCd='+ctnrTpszCd+'&p_date2='+pDate2+'&p_date1='+pDate1, 1024, 650, '', '0,0', true, false);
				break;
			case "btn_repair" :
				var pCntrno = "";
				if(sheetObject.SelectRow > -1){
					pCntrno = sheetObject.CellValue(sheetObject.SelectRow,"cntr_no");
				}
				//ComOpenPopup('/hanjin/EES_MNR_0028.do?rqst_eq_no='+rqstEqNo+"&rqst_ref_no="+rqstRefNo+"&pop_flag=Y", 1024, 950, '', '0,0', true, false);
				ComOpenWindow('EES_MNR_0028.do?eq_no='+pCntrno+'&from_sys=EAS', 'EES_MNR_0028', 'width=1024,height=650');
				break;
			case "btn_service_order" :
				var pCntrno = "";
                var pOfcCd = "";
				if(sheetObject.SelectRow > -1){
                    pOfcCd = sheetObject.CellValue(sheetObject.SelectRow,"ofc_cd");
					pCntrno = sheetObject.CellValue(sheetObject.SelectRow,"cntr_no");
				}
				//ComOpenPopup('/hanjin/EES_CTM_0408.do?rqst_eq_no='+rqstEqNo+"&rqst_ref_no="+rqstRefNo+"&pop_flag=Y", 1024, 950, '', '0,0', true, false);
				ComOpenWindowCenter("ESD_TRS_0019.do?s_so_ofc_cd=" + pOfcCd + "&s_eq_no=" + pCntrno, "so_inquiry", "1030", "690", true, "no");
				break;
			case "btn_bkg_inquiry" :
				
				var bkg_no   = sheetObject.CellValue(sheetObject.SelectRow,"bkg_no");
				var isPop   = "Y";
				var openTab = "";
				var tro_tab  = "";
				var shortcutTab = "";
				
				ComOpenPopup('/hanjin/ESM_BKG_0079_Q.do?bkg_no='+bkg_no+'&isPop='+isPop+'&openTab='+openTab+'&tro_tab='+tro_tab+'&shortcutTab='+shortcutTab, 1024, 750, '', '0,0', true, false);
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
			} else {
				ComShowMessage(e);
			}
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
		
		var formObj = document.form;

		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
			comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
		}
		
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		initControl();
		initForm();

	}
	
	function initForm(){
		var formObj = document.form;
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		formObj.reset();
		
		formObj.fdate_tmp.value = ComGetDateAdd(null, "d", -31, "-");
		formObj.tdate_tmp.value = ComGetDateAdd(null, "d", 0, "-");
		
		/*formObj.fdate_tmp.value = "2015-01-01";
		formObj.tdate_tmp.value = "2015-01-31";
		
		formObj.loc_cd.value = "MYPKG";
		formObj.yd_cd.value = "TM";
		
		formObj.mvmt_sts_cd.value = "ID,MT,TN,MT,OP,";*/
	}
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
  	}
	
	function initCombo(comboObj, no){
		var formObj = document.form;
		var comboId = comboObj.id;
		switch(comboId){
			case "cntr_tpsz_cd":
				comboObj.MultiSelect = true; 
				getEasIbComboList(formObj.cntr_tpsz_cd , cntr_tpsz_cdCode , cntr_tpsz_cdText , 'ALL');
			break;
		}
	}


	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;

		switch(sheetNo) {

			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(20);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					
					var HeadTitle = "SEQ|Container No.|CNTR Type|Status|Event Date|Update Date(S)|Cycle|F/M|VVD Code|BKG Number|Orgin Yard Code|User Name|Office|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,		40,		daCenter,	true,	"seq",				false,          "",       dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"cntr_no",			false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"cntr_tpsz_cd",		false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"mvmt_sts_cd",		false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daCenter,	true,	"cnmv_evnt_dt",		false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		120,	daCenter,	true,	"upd_locl_dt",		false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,		daCenter,	true,	"cnmv_cyc_no",		false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,		daCenter,	true,	"fcntr_flg",		false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	true,	"vvd",				false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	true,	"bkg_no",			false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"org_yd_cd",		false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		90,		daCenter,	true,	"usr_nm",			false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"ofc_cd",			false,          "",	      dfNone,	0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		100,	daCenter,	true,	"cnmv_rmk",			false,          "",	      dfNone,	0,     false,       true);
					
				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
			    if(validateForm(sheetObj, formObj, sAction)){
			    	if(fdateArry.length == 0){
			    		var cntrNo = formObj.cntr_no.value;
			    		if(cntrNo != null && cntrNo != "" && cntrNo.length != 0){
			    			fdateArry[0] = formObj.fdate_tmp.value;
			    			tdateArry[0] = formObj.tdate_tmp.value;
			    		}else{
			    			var dayBt = ComGetDaysBetween(formObj.fdate_tmp, formObj.tdate_tmp);
			    			if(dayBt == 0) dayBt++; 
//			    			var div = Math.round(dayBt / 7);
//			    			if(div == 0) div++;
//			    			for(var i=0;i<div;i++){
//			    				var fpday = (i * 7);
//			    				var tpday = ((i+1) * 7) - 1;
			    			for(var i=0;i<dayBt;i++){
			    				var fpday = i;
			    				var tpday = i;
			    				if(i == 0){
			    					fdateArry[i] = formObj.fdate_tmp.value;
			    				}else{
			    					fdateArry[i] = ComGetDateAdd(formObj.fdate_tmp, "D", fpday, "-");
			    				}
			    				
			    				if(i == (dayBt-1)){
			    					tdateArry[i] = formObj.tdate_tmp.value;
			    				}else{
			    					tdateArry[i] = ComGetDateAdd(formObj.fdate_tmp, "D", tpday, "-");
			    				}//else
			    			}//for
			    		}//else
			    		
			    		
			    		sheetObj.WaitImageVisible=false;
		    			ComOpenWait(true);
			    	}//if
			    	
		    		formObj.fdate.value = fdateArry[arrCnt];
		    		formObj.tdate.value = tdateArry[arrCnt];
		    		
					formObj.f_cmd.value = SEARCH;
	    			
	    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0369GS.do",EasFrmQryString(formObj));
	    			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
	    			
	    			if (backendJobKey.length > 0) {
						formObj.backendjob_key.value = backendJobKey;
						sheetObj.RequestTimeOut = 600;
						timer = setInterval(getBackEndJobStatus, 3000);
						sheetNum = sheetObj;
					}
			    }
				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
				
			case IBSEARCH_ASYNC01:
				if(validateForm(sheetObj, formObj, sAction)){
					ComOpenWait(true);
		    		formObj.fdate.value = formObj.fdate_tmp.value;
		    		formObj.tdate.value = formObj.tdate_tmp.value;
		    		formObj.f_cmd.value = SEARCH01;
	    			var sXml = sheetObj.GetSearchXml("ESD_EAS_0369GS.do",EasFrmQryString(formObj));
	    			ComOpenWait(false);
	    			ComShowMessage("CNTR List has been sent to e-mail successfully");
			    }
				break;
		}
	}


	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "fdate_tmp":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "tdate_tmp":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "fdate_tmp":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;	
		case "tdate_tmp":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			break;
		}
	}

	
	function obj_keypress(){
		obj = event.srcElement;
		if(obj.dataformat == null) return;
	
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			case "num":
				ComKeyOnlyNumber(obj);
				break;
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				if(obj.name=="vsl_cd"){
					ComKeyOnlyAlphabet('uppernum');
				} else {
					ComKeyOnlyAlphabet('upper');
				}
				
				break;
			case "engdn":
				if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
				else ComKeyOnlyAlphabet('lower');
				break;
			case "uppernum":
				ComKeyOnlyAlphabet('uppernum');
				break;
		}
	}
	
	function obj_change(){
		var obj = event.srcElement;
		var formObj = document.form;
		
		if(obj.name == "mvmt_sts_cd1"){
			var val1 = obj.value;
			var val2 = formObj.mvmt_sts_cd2.value;
			var val3 = formObj.mvmt_sts_cd3.value;
			var val4 = formObj.mvmt_sts_cd4.value;
			var val5 = formObj.mvmt_sts_cd5.value;
			
			if(val1 == null || val1 == ""){
				formObj.mvmt_sts_cd.value = "";
				formObj.mvmt_sts_cd2.value = "";
				formObj.mvmt_sts_cd3.value = "";
				formObj.mvmt_sts_cd4.value = "";
				formObj.mvmt_sts_cd5.value = "";
			}else{
				formObj.mvmt_sts_cd.value = val1 + ",";
				if(val2 != null && val2 != ""){
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + ",";
					if(val3 != null && val3 != ""){
						formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + ",";
						if(val4 != null && val4 != ""){
							formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + ",";
							if(val5 != null && val5 != ""){
								formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + "," + val5 + ",";
							}
						}
					}
				}
			}
		}else if(obj.name == "mvmt_sts_cd2"){
			var val1 = formObj.mvmt_sts_cd1.value;
			var val2 = obj.value;
			var val3 = formObj.mvmt_sts_cd3.value;
			var val4 = formObj.mvmt_sts_cd4.value;
			var val5 = formObj.mvmt_sts_cd5.value;
			
			if(val1 == null || val1 == ""){
				formObj.mvmt_sts_cd1.value = val2;
				obj.value = ""; 
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + ",";
				return false;
			}else{
				if(val2 != null && val2 != ""){
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + ",";
					if(val3 != null && val3 != ""){
						formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + ",";
						if(val4 != null && val4 != ""){
							formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + ",";
							if(val5 != null && val5 != ""){
								formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + "," + val5 + ",";
							}
						}
					}
				}else{
					formObj.mvmt_sts_cd.value = val1 + ",";
					formObj.mvmt_sts_cd3.value = "";
					formObj.mvmt_sts_cd4.value = "";
					formObj.mvmt_sts_cd5.value = "";
				}
			}
		}else if(obj.name == "mvmt_sts_cd3"){
			var val1 = formObj.mvmt_sts_cd1.value;
			var val2 = formObj.mvmt_sts_cd2.value;
			var val3 = obj.value;
			var val4 = formObj.mvmt_sts_cd4.value;
			var val5 = formObj.mvmt_sts_cd5.value;
			
			if(val1 == null || val1 == ""){
				formObj.mvmt_sts_cd1.value = val3; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + ",";
				return false;
			}
			if(val2 == null || val2 == ""){
				formObj.mvmt_sts_cd2.value = val3; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + "," + formObj.mvmt_sts_cd2.value + ",";
				return false;
			}else{
				if(val3 != null && val3 != ""){
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + ",";
					if(val4 != null && val4 != ""){
						formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + ",";
						if(val5 != null && val5 != ""){
							formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + "," + val5 + ",";
						}
					}
				}else{
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + ",";
					formObj.mvmt_sts_cd4.value = "";
					formObj.mvmt_sts_cd5.value = "";
				}
			}
		}else if(obj.name == "mvmt_sts_cd4"){
			var val1 = formObj.mvmt_sts_cd1.value;
			var val2 = formObj.mvmt_sts_cd2.value;
			var val3 = formObj.mvmt_sts_cd3.value;
			var val4 = obj.value;
			var val5 = formObj.mvmt_sts_cd5.value;
			
			if(val1 == null || val1 == ""){
				formObj.mvmt_sts_cd1.value = val4; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + ",";
				return false;
			}
			if(val2 == null || val2 == ""){
				formObj.mvmt_sts_cd2.value = val4; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + "," + formObj.mvmt_sts_cd2.value + ",";
				return false;
			}
			if(val3 == null || val3 == ""){
				formObj.mvmt_sts_cd3.value = val4; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + "," + formObj.mvmt_sts_cd2.value + "," + formObj.mvmt_sts_cd3.value + ",";
				return false;
			}else{
				if(val4 != null && val4 != ""){
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + ",";
					if(val5 != null && val5 != ""){
						formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + "," + val5 + ",";
					}
				}else{
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + ",";
					formObj.mvmt_sts_cd5.value = "";
				}
				
			}
		}else if(obj.name == "mvmt_sts_cd5"){
			var val1 = formObj.mvmt_sts_cd1.value;
			var val2 = formObj.mvmt_sts_cd2.value;
			var val3 = formObj.mvmt_sts_cd3.value;
			var val4 = formObj.mvmt_sts_cd4.value;
			var val5 = obj.value;
			
			if(val1 == null || val1 == ""){
				formObj.mvmt_sts_cd1.value = val5; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + ",";
				return false;
			}
			if(val2 == null || val2 == ""){
				formObj.mvmt_sts_cd2.value = val5; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + "," + formObj.mvmt_sts_cd2.value + ",";
				return false;
			}
			if(val3 == null || val3 == ""){
				formObj.mvmt_sts_cd3.value = val5; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + "," + formObj.mvmt_sts_cd2.value + "," + formObj.mvmt_sts_cd3.value + ",";
				return false;
			}
			if(val4 == null || val4 == ""){
				formObj.mvmt_sts_cd4.value = val5; 
				obj.value = "";
				formObj.mvmt_sts_cd.value = formObj.mvmt_sts_cd1.value + "," + formObj.mvmt_sts_cd2.value + "," + formObj.mvmt_sts_cd3.value + ","+ formObj.mvmt_sts_cd4.value + ",";
				return false;
			}else{
				if(val5 != null && val5 != ""){
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + "," + val5 + ",";
				}else{
					formObj.mvmt_sts_cd.value = val1 + "," + val2 + "," + val3 + "," + val4 + ",";
				}
			}
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		var formObj = document.form;
		var result = true ;
		
		switch(sAction) {
			case IBSEARCH:
				// The period cannot exceed 90 days.
				if(ComGetDaysBetween(formObj.fdate_tmp, formObj.tdate_tmp) < 0){
					ComShowMessage(msgs['EAS90027']);
					formObj.tdate_tmp.value = ComGetDateAdd(formObj.fdate_tmp.value, "d", +10, "-");
					ComSetFocus(formObj.fdate_tmp);
					return false;
				} else if(ComGetDaysBetween(formObj.fdate_tmp, formObj.tdate_tmp) > 31){
					ComShowMessage("The period cannot exceed 1 months");
					
					ComSetFocus(formObj.fdate_tmp);
					return false;
				}
				
				if(ComIsNull(formObj.loc_cd)){
					ComShowCodeMessage("COM130201", "Location");
					ComSetFocus(formObj.loc_cd);
					return false;
				}
				if(ComIsNull(formObj.yd_cd)){
					ComShowCodeMessage("COM130201", "Yard");
					ComSetFocus(formObj.yd_cd);
					return false;
				}
				
				if(ComIsNull(formObj.mvmt_sts_cd)){
					ComShowCodeMessage("COM130201", "CNTR MVMT");
					ComSetFocus(formObj.mvmt_sts_cd);
					return false;
				}
				break;
			case IBSEARCH_ASYNC01:
				// The period cannot exceed 90 days.
				if(ComGetDaysBetween(formObj.fdate_tmp, formObj.tdate_tmp) < 0){
					ComShowMessage(msgs['EAS90027']);
					formObj.tdate_tmp.value = ComGetDateAdd(formObj.fdate_tmp.value, "d", +10, "-");
					ComSetFocus(formObj.fdate_tmp);
					return false;
				} else if(ComGetDaysBetween(formObj.fdate_tmp, formObj.tdate_tmp) > 31){
					ComShowMessage("The period cannot exceed 1 months");
					
					ComSetFocus(formObj.fdate_tmp);
					return false;
				}
				if(ComIsNull(formObj.loc_cd)){
					ComShowCodeMessage("COM130201", "Location");
					ComSetFocus(formObj.loc_cd);
					return false;
				}
				if(ComIsNull(formObj.yd_cd)){
					ComShowCodeMessage("COM130201", "Yard");
					ComSetFocus(formObj.yd_cd);
					return false;
				}
				
				if(ComIsNull(formObj.mvmt_sts_cd)){
					ComShowCodeMessage("COM130201", "CNTR MVMT");
					ComSetFocus(formObj.mvmt_sts_cd);
					return false;
				}
				
				if(ComIsNull(formObj.eml_snd_addr)){
					ComShowCodeMessage("COM130201", "EMAIL");
					ComSetFocus(formObj.eml_snd_addr);
					return false;
				}
				
				break;
		}
		return result;
	}
	
	
	 /*
	 * Location 정보를 가져오는 함수
	 */
	function getLocation(rowArray){
		var formObject = document.form;
		var colArray = rowArray[0]; 
		formObject.loc_cd.value= colArray[3].substring(0,5);
        formObject.yd_cd.value = colArray[3].substring(5); 
	}
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetNum.GetSearchXml("ESD_EAS_0369GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
		} else if (jobState == "4") {
			arrCnt = 0;
			fdateArry = new Array();
			tdateArry = new Array();
			errFlag4 = "N";
			errFlag5 = "N";
			
			ComShowCodeMessage("EAS90207");
			ComOpenWait(false);
			sheetNum.WaitImageVisible = true;
			clearInterval(timer);
		} else if (jobState == "5") {
			errFlag5 = "Y";
			arrCnt = arrCnt+1;
			if(fdateArry.length <= arrCnt){
				arrCnt = 0;
				fdateArry = new Array();
				tdateArry = new Array();
				errFlag4 = "N";
				errFlag5 = "N";
				
				ComShowCodeMessage("EAS90208");
				clearInterval(timer);
			}else{
				clearInterval(timer);
				doActionIBSheet(sheetNum,formObj,IBSEARCH);
			}
		}
	}
	
	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		
		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetNum.GetSearchXml("ESD_EAS_0369GS.do", FormQueryString(form));
		sheetNum.LoadSearchXml(sXml, true);
		arrCnt = arrCnt+1;
		if(fdateArry.length <= arrCnt){
			arrCnt = 0;
			fdateArry = new Array();
			tdateArry = new Array();
			ComOpenWait(false);
			clearInterval(timer);
			
			if(errFlag4 == "Y"){
				ComShowCodeMessage("EAS90207");
			}
			
			if(errFlag5 == "Y"){
				ComShowCodeMessage("EAS90208");
			}
			
			errFlag4 = "N";
			errFlag5 = "N";
			
		}else{
			clearInterval(timer);
			doActionIBSheet(sheetNum,formObj,IBSEARCH);
		}
	}
	function rep_Multiful_inquiry(input_obj)
	{
			var formObject = document.form;
			var cmdt_cd_val ="";   //향후 사용가능 예정변수
			var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
			var cmdt_desc_val ="";   //향후 사용가능 예정변수
			var classId ="getMnr_Multi";
			var xx1=input_obj;  //CONTI
			var xx2="";  //SUB CONTI
			var xx3="";  //COUNTRY
			var xx4="";  //STATE
			var xx5="";  //CONTROL OFFIC
			var xx6="";  //LOC CODE
			var xx7="";  //LOC NAME
			var xx8="";
			var xx9="";

			var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('EES_MNR_MULTI.do' + param, 400, 330, 'getMnr_Multi', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	
	/** 
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj = document.form; 	 
 		var tempText = "";       
 		//초기화     
		eval("document.form." + return_val + ".value = '';"); 
 
 		for(var i=0; i < rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//마지막에 ,를 없애기 위함      
		tempText = MnrDelLastDelim(tempText);		
 			     
 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
 	} 
	
	
	/**
	 * 반복문으로  생성된 라스트 Delim을 제거
	 * ex)
	 * '1,2,3,4,5,' => '1,2,3,4,5'
	 * @param {String} str 		제거 대상 String
	 * @return {String} str 	제거된 String
	 * @author 박명신
	 * @version 2009.06.04
	 */
	function MnrDelLastDelim(str){
		//마지막에 &를 없애기 위함
		if (str != ""){
			 str = str.substr(0, str.length - 1);
		}
		return str;
	}
