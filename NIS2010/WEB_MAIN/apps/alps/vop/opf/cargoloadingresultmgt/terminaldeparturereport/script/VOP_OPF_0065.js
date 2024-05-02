/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0065.js
*@FileTitle : Fleet Status
*Open Issues :
*Change history : 
*@LastModifyDate :  
*@LastModifier : 
*@LastVersion : 
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
	 * @class VOP_OPF_0065 : VOP_OPF_0065 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function VOP_OPF_0065() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
		//this.setCrrCd				= setCrrCd;
	}

/* 개발자 작업 */ 


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var sheetNames   = new Array("sheet1", "sheet2");
	var sheetInits   = new Array(   false,    false);


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj1 = sheetObjects[0];
		var shtObj2 = sheetObjects[1];
		var frmObj = document.form;

		try {
			
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
			
				case "btn_crr_cd":
	        		ComOpenPopup("ESM_FMS_0077.do", 528, 430, "setCrrCd", "1,0,1,1,1,1", true, false, 0, 0, 0, "ESM_FMS_0077");
	        		break;
	        	
	        	
				case "btn_ownerpop":
					ComOpenPopup("ESM_FMS_0083.do", 500, 375,"setOwner", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0083");
					break;
					
				/*case "btn_ownrclr":
     				form.owner_seq.value = "";
     				form.ownr_seq.value = "";
     				break;
     			*/
     			
				case "btn_calendar":
					if (!window.event.srcElement.disabled) {
						var cal = new ComCalendar();
						cal.select(frmObj.p_date, "yyyy-MM-dd");
					}
					break;
				
				case "btn_new":
					doActionIBSheet(shtObj2, frmObj, IBCLEAR);
					break;	
					
				case "btn_retrieve":
					doActionIBSheet(shtObj2, frmObj, IBSEARCH);
					break;

				case "btn_downExcel":
					shtObj2.Down2Excel(-1);
					break;

				case "btn_Print":
					rdOpenFn(); 
					break;
					
			} // end switch

		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	//From Date 날짜 세팅
    function set_from_date(){
    	var formObj = document.form;
    	var toDate = formObj.p_date.value;
    	formObj.from_date.value = toDate;
    }	

	/**
 	 * setCrrCd 입력부분(Carrier Code)<br>
 	 * @param {arry} aryPopupData
 	 */
    function setCrrCd(aryPopupData) {
    	form.carrier_cd.value = aryPopupData[0][3];
    }
    
    /**
	 * Owner 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setOwner(aryPopupData){
		form.ownr_seq.value = aryPopupData[0][3];
		form.ownr_nm.value = aryPopupData[0][4];
        //form.btn_ownrclr.checked = true;
	}
    

	/**
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(shtObj) {
		sheetObjects[sheetCnt++] = shtObj;
	}

	/**
	 * Sheet initialization function
	 * <br><b>Example : </b>
	 * <pre>
	 * </pre>
	 * @param {int} idx mandatory, Sheet Index
	 * @return {void}
	 * @author
	 * @version
	 */
	function sheetInit(idx) {
		if (sheetInits[idx] == false) {
	        ComConfigSheet (sheetObjects[idx] );
	        initSheet(sheetObjects[idx],idx+1);
	        ComEndConfigSheet(sheetObjects[idx]);
	        sheetInits[idx] = true;
	    }
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++){
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();				
	}


	/**
	* 시트 초기설정값, 헤더 정의
	* param : shtObj ==> 시트오브젝트, shtNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(shtObj, shtNo) {
		var cnt = 0;
		var sheetID = shtObj.id;
		switch (sheetID) {
			
		case "sheet1":
			with (shtObj) {
				// setting height
				style.height = 63;
				//setting width
				SheetWidth = mainTable.clientWidth;
	
				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//Merge kind [Default msNone]
				MergeSheet = msHeaderOnly;
	
				//Edit kind [Default false]
				Editable = true;
	
				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "|SML|Others|Total";
				var headCount = 4;
	
				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// setting Header Mode
				InitHeadMode(true, true, false, true, false, false);
	
				//setting Header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "tit", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "hjs", false, "", dfNone, 0, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "others",false, "",  dfNone, 0, false, true, 12, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "total", false, "", dfNone, 0, false);
				
				MultiSelection = false;
				SelectHighLight = true;
				CountPosition = 0;
			}
				break;	
		case "sheet2":
			with (shtObj) {
				var cnt = 0;
				// 높이 설정
				style.height = 422;

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
				InitRowInfo(3, 1, 3, 100);
				document.form.pagerows.value = 500;

				// 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
				InitHeadMode(false, false, false, true, false,false);

				// 컬럼 헤더타이틀
				//var HeadTitle1  = "|No|LANE|Duration\n(days)|Fleet\nStatus|Opr|TTL\nVessel\nQ'Ty|TTL\nVessel\nQ'Ty|HJS Vessel Name|TTL\nBSA|TTL\nBSA|HJS\nBSA|HJS\nBSA|Alliance\nBSA|Alliance\nBSA|Ratio|Ratio|Ratio|Ratio|Port Rotation||||||";
				//var HeadTitle2  = "|No|LANE|Duration\n(days)|Fleet\nStatus|Opr|TTL\nVessel\nQ'Ty|TTL\nVessel\nQ'Ty|HJS Vessel Name|TTL\nBSA|TTL\nBSA|HJS\nBSA|HJS\nBSA|Alliance\nBSA|Alliance\nBSA|HJS|HJS|Alliance|Alliance|Port Rotation||||||";
				//var HeadTitle3  = "|No|LANE|Duration\n(days)|Fleet\nStatus|Opr|TTL\nVessel\nQ'Ty|TTL\nVessel\nQ'Ty|HJS Vessel Name|W|E|W|E|W|E|W|E|W|E|Port Rotation||||||";
				var HeadTitle1  = "|No|LANE|Duration\n(days)|Fleet\nStatus|Opr|TTL\nVessel\nQ'Ty|TTL\nVessel\nQ'Ty|Vessel Name|Vessel Name|TTL\nBSA|TTL\nBSA|SML\nBSA|SML\nBSA|Alliance\nBSA|Alliance\nBSA|Ratio|Ratio|Ratio|Ratio|Port Rotation||||||";
				var HeadTitle2  = "|No|LANE|Duration\n(days)|Fleet\nStatus|Opr|TTL\nVessel\nQ'Ty|TTL\nVessel\nQ'Ty|Vessel Name|Vessel Name|TTL\nBSA|TTL\nBSA|SML\nBSA|SML\nBSA|Alliance\nBSA|Alliance\nBSA|SML|SML|Alliance|Alliance|Port Rotation||||||";
				var HeadTitle3  = "|No|LANE|Duration\n(days)|Fleet\nStatus|Opr|TTL\nVessel\nQ'Ty|TTL\nVessel\nQ'Ty|Own|Charter|W|E|W|E|W|E|W|E|W|E|Port Rotation||||||";
				
				var headCount = ComCountHeadTitle(HeadTitle3);  
				
				// 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
				InitColumnInfo(headCount, 10, 0, true);
				
				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				InitHeadRow(2, HeadTitle3, true);

				// Enter키를 눌렀을때 Tab키처럼 작동
				EditEnterBehavior = "tab";

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 40,      daCenter,    true,    "ibflag");    // [필수]

                InitDataProperty(0, cnt++, dtData,  	30,		daCenter,   true,    "seq",         	false,     "",    dfNone,    0,    false,     false);
				InitDataProperty(0, cnt++, dtData,   	40,		daCenter,   true,    "slan_cd",     	false,     "",    dfNone,    0,    false,     false);
				InitDataProperty(0, cnt++, dtData,   	60,    	daCenter,   true,    "svc_dur_dys",     false,     "",    dfNone,    0,    false,     false);
				InitDataProperty(0, cnt++, dtData,     130,		daRight,    true,    "fleet_status",    false,     "",    dfNone,    0,    false,     false);
				InitDataProperty(0, cnt++, dtHidden,   	40,		daCenter,   true,    "crr_cd",			false,     "",    dfNone,    0,    false,     false);
				InitDataProperty(0, cnt++, dtHidden,   	30,   	daCenter,   false,   "vsl_qty",      	false,     "",    dfNone,    0,    false,     false);				
				InitDataProperty(0, cnt++, dtData,   	50,     daCenter,   true,    "vsl_qty_ttl",     false,     "",    dfNone,    0,    false,     false);
				InitDataProperty(0, cnt++, dtData,     100,		daLeft,    	true,    "hjs_vsl_own_nm",	false,     "",    dfNone,    0,    false,     false);//Own	   crr_hjs
				InitDataProperty(0, cnt++, dtData,     100,		daLeft,    	true,    "hjs_vsl_cht_nm",	false,     "",    dfNone,    0,    false,     false);//Charter crr_oth
				InitDataProperty(0, cnt++, dtData,   	55,		daRight,    true,    "ttl_bsa_w",      	false,     "",    dfNone,    2,    false,     false);
				InitDataProperty(0, cnt++, dtData,   	55,		daRight,    true,    "ttl_bsa_e",    	false,     "",    dfNone,    2,    false,     false);
				InitDataProperty(0, cnt++, dtData,    	55,    	daRight,    true,    "hjs_bsa_w",      	false,     "",    dfNone,    2,    false,     false);
				InitDataProperty(0, cnt++, dtData,    	55,		daRight,    true,    "hjs_bsa_e",      	false,     "",    dfNone,    2,    false,     false);					
				InitDataProperty(0, cnt++, dtData,    	55,		daRight,    true,    "co_bsa_w",      	false,     "",    dfNone,    2,    false,     false);						
				InitDataProperty(0, cnt++, dtData,    	55,		daRight,    true,    "co_bsa_e",      	false,     "",    dfNone,    2,    false,     false);						
				InitDataProperty(0, cnt++, dtData,    	45,		daRight,    true,    "hjs_bsa_rto_w",   false,     "",    dfNone,    2,    false,     false);						
				InitDataProperty(0, cnt++, dtData,    	45,		daRight,    true,    "hjs_bsa_rto_e",   false,     "",    dfNone,    2,    false,     false);						
				InitDataProperty(0, cnt++, dtData,    	45,		daRight,    true,    "chtr_bsa_rto_w",  false,     "",    dfNone,    2,    false,     false);						
				InitDataProperty(0, cnt++, dtData,    	45,		daRight,    true,    "chtr_bsa_rto_e",  false,     "",    dfNone,    2,    false,     false);						
				InitDataProperty(0, cnt++, dtData,     280,		daLeft,    	true,    "port_rot",      	false,     "",    dfNone,    0,    false,     false);						
				InitDataProperty(0, cnt++, dtHidden,    20,		daLeft,    	true,    "lane_hjs",      	false,     "",    dfNone,    0,    false,     false);						
				InitDataProperty(0, cnt++, dtHidden,    20,		daLeft,    	true,    "lane_others",     false,     "",    dfNone,    0,    false,     false);						
				InitDataProperty(0, cnt++, dtHidden,    20,		daLeft,    	true,    "lane_total",      false,     "",    dfNone,    0,    false,     false);						
				InitDataProperty(0, cnt++, dtHidden,    20,		daLeft,    	true,    "ea_hjs",      	false,     "",    dfNone,    0,    false,     false);						
				InitDataProperty(0, cnt++, dtHidden,    20,		daLeft,    	true,    "ea_others",      	false,     "",    dfNone,    0,    false,     false);						
				InitDataProperty(0, cnt++, dtHidden,    20,		daLeft,    	true,    "ea_total",      	false,     "",    dfNone,    0,    false,     false);		

				WaitImageVisible = false;
				
				//SetMergeCell(0,6,3,2);
				//의도 : Row : 0, Col :6 에서 시작해서 세로로 3개, 가로로 2개 를 머지하겠다.
				//강제머지할 셀의 Row Index 0
				//강제머지할 셀의 Column Index 6
				//강제머지할 셀의 Row 개수 3
				//강제머지할 셀의 Col 개수 2
				SetMergeCell(0,8,2,2); 
				SetMergeCell(0,10,2,2);
				SetMergeCell(0,12,2,2);
				SetMergeCell(0,14,2,2);
				
				WordWrap = true;
				HeadRowHeight = 20;
			}
			break;
		}
	}


	/**
	* Form의 Conrol 초기화 및 초기 이벤트 등록
	*/
	function initControl() {
		// 기본 OnBeforeDeactivate, OnBeforeActivate, OnKeyPress 이벤트 (키입력) - CoBkk.js에 정의
		axon_event.addListenerForm("beforedeactivate", "frmObj_OnBeforeDeactivate",  document.form);
		axon_event.addListenerFormat("beforeactivate", "frmObj_OnBeforeActivate", document.form);
		axon_event.addListenerFormat("keypress", "frmObj_OnKeyPress", document.form);
	}	

	/**
	 * Form Element의  OnBeforeDeactivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeDeactivate() {
		ComChkObjValid(window.event.srcElement);
	}


	/**
	 * Form Element의 OnBeforeActivate 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
	 */
	function frmObj_OnBeforeActivate() {
		ComClearSeparator(window.event.srcElement);
	}
	
	/**
	 * Form Element의 OnKeyPress 이벤트
	 * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
	 */
	function frmObj_OnKeyPress() {
		var obj = window.event.srcElement;
		if (obj.dataformat == null) return;

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
				ComKeyOnlyNumber(obj, "-");
				break;

			case "float":
				ComKeyOnlyNumber(obj, "-.");
				break;

			case "eng":
				ComKeyOnlyAlphabet("num", "32|64|~");
				break;

			case "engup":
				ComKeyOnlyAlphabet("uppernum");
				break;

			case "engdn":
				ComKeyOnlyAlphabet("lowernum");
				break;
				
			case "engupnum":  //숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet('uppernum'); 
				break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {

			case IBSEARCH:    // 조회
				//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 임시로 막아놓음 ComChkValid%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
				//if (!ComChkValid(frmObj)) return;
				ComOpenWait(true);
				frmObj.f_cmd.value = SEARCH;
				
				shtObj.DoSearch("VOP_OPF_0065GS.do", FormQueryString(frmObj));
				ComOpenWait(false);
				break;	
				
			case IBCLEAR:
				setObjValue("vsl_type", "");
				setObjValue("ownr_nm", "");
				setObjValue("ownr_seq", "");
				setObjValue("carrier_cd", "");
				setObjValue("bsa_type", "");
				shtObj.RemoveAll();
				sheetObjects[0].RemoveAll();
				set_today_date();
				break;	
				
		}
	}
	
	function set_today_date(){
		var nowDate  = new Date();
        var nowYear  = nowDate.getYear();
        var nowMonth = nowDate.getMonth() + 1;
        var nowDay   = nowDate.getDate();

        if (nowMonth < 10) {
            nowMonth = "0" + nowMonth;
        }
        if (nowDay < 10) {
            nowDay = "0" + nowDay;
        }
        
        var thisDate = nowYear + "-" + nowMonth + "-" + nowDay;

	    var formObj = document.form;
	    formObj.p_date.value = thisDate;
	}	
	
	/**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    
	
	function sheet2_OnSearchEnd(shtObj, ErrMsg) {
		sheetObjects[0].RemoveAll();	
		
		//상단의 Total 화면에 데이터 보여주기
		sheetObjects[0].DataInsert(-1);
		sheetObjects[0].DataInsert(-1);
		
		sheetObjects[0].CellValue2(1,"tit") = "Lane";
		sheetObjects[0].CellValue2(1,"hjs") = shtObj.CellValue(3,"lane_hjs");
		sheetObjects[0].CellValue2(1,"others") = shtObj.CellValue(3,"lane_others");
		sheetObjects[0].CellValue2(1,"total") = shtObj.CellValue(3,"lane_total");
		sheetObjects[0].CellValue2(2,"tit") = "EA";
		sheetObjects[0].CellValue2(2,"hjs") = shtObj.CellValue(3,"ea_hjs");
		sheetObjects[0].CellValue2(2,"others") = shtObj.CellValue(3,"ea_others");
		sheetObjects[0].CellValue2(2,"total") = shtObj.CellValue(3,"ea_total");
		
	}	

	//RD common popup 
/*    function rdOpenFn(){
    	var formObj = document.form;
    	//var rdParam = "/rv in_p_date["+formObj.p_date.value+"] ";
    	var rdParam = "/rv in_p_date["+formObj.p_date.value+"] in_carrier_cd["+formObj.carrier_cd.value+"]  in_vsl_type["+formObj.vsl_type.value+"] in_ownr_nm["+formObj.ownr_nm.value+"] in_bsa_type["+formObj.bsa_type.value+"] in_ownr_seq["+formObj.ownr_seq.value+"] ";
    	//var strPath = "apps/alps/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_0065.mrd";   
    	var strPath = "apps/alps/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_0065_test.mrd";
    	formObj.com_mrdPath.value = strPath;
    	formObj.com_mrdArguments.value = rdParam;
    	ComOpenRDPopupModal("dialogWidth:1250px;dialogHeight:690px;status:no");
    }
*/    
	
	function rdOpenFn() {
		//alert("rdOpenFn");
		var formObj = document.form;
		var bsa_type_param = formObj.bsa_type.value;
		var vsl_type = formObj.vsl_type.value;
		
		if(formObj.bsa_type.checked == true){
			bsa_type_param = "Y";
		}else {
			bsa_type_param = "N";
		}
		//alert("bsa_type = "+bsa_type_param);
		
		/*if(vsl_type == "O"){
			vsl_type = "Owner";
		}else if(vsl_type == "C"){
			vsl_type = "Charter";
		}else if(vsl_type == "J"){
			vsl_type = "Joint Operation";
		}else if(vsl_type == ""){
			vsl_type = "ALL";
		}*/
		//alert("vsl_type  = "+vsl_type);
		
		var rdParam = "/rv in_p_date["+formObj.p_date.value+"] in_carrier_cd["+formObj.carrier_cd.value+"]  in_vsl_type["+vsl_type+"] in_ownr_nm["+formObj.ownr_nm.value+"] in_bsa_type["+bsa_type_param+"] in_ownr_seq["+formObj.ownr_seq.value+"] ";
		var strPath = "apps/alps/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_0065.mrd";
		formObj.com_mrdPath.value = strPath;
    	formObj.com_mrdArguments.value = rdParam;
    	ComOpenRDPopupModal("dialogWidth:1250px;dialogHeight:690px;status:no");
	}
    
/* 개발자 작업 끝 */
