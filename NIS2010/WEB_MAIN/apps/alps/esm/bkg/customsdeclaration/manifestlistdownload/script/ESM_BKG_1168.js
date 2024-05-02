/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1168.js
*@FileTitle : ESM_BKG_1168
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.11 김보배
* 1.0 Creation
* 2015.03.09 이한나 [CHM-201534282] ISRAEL CUSTOMS MANIFEST에 L/T조건 삽입
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
	 * @class ESM_BKG_1168 : ESM_BKG_1168 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_BKG_1168() {
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
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	//전역변수
	var intervalId = "";

	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
    	
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
			var sheetObject1 = sheetObjects[0];
			var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;
	
		try { 
			
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
	           
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[1], formObject, SEARCH);
					break;
		
				case "btn_new":
					doActionIBSheet(sheetObjects[1], formObject, IBCLEAR);
					break; 
	
				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
					break; 
						
				case "btn_transmit":
					doActionIBSheet(sheetObjects[1], formObject, MULTI);
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

	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
    
	/**
	 * 콤보 Object를 comboObjects 배열에 등록
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj; 
	}
    
    
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */                    
	function loadPage() {
		var formObj = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
			//시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		
		//axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate',  document.form); //- 포커스 나갈때    	
		axon_event.addListenerForm ('change', 'obj_change',  document.form); //- change    	
	}
    
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		
		var cnt = 0;
		
		switch(sheetNo) {
		
			case 1:      //sheet1 init

				with (sheetObj) {
					// 높이 설정
					style.height = 220;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);
					
					var HeadTitle = "|flatFile";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]	
					InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter, 	false,    "ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,	  "flat_file",	false,			"",      dfNone,	0,		false,		false);
					
					CellSpeedOption="NOFORMAT";
				}
				break;
				
				
			case 2:      //sheet2 init
				with (sheetObj) {
				
				// 높이 설정
				style.height = 380;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
				MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = "Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Package|Package Unit|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|ERR_YN|";
				var HeadTitle2 = "Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Package|Package Unit|NM|AD|NM|AD|NM|AD|ERR_YN|";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 4, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
				InitHeadMode(false, false, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,		 40, daCenter,	true,  "dt_seq",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++,  dtDummyCheck,40, daCenter,	true,  "sel",		false,  "",  dfNone,  0,  true,   false);
				InitDataProperty(0, cnt++ , dtData,		 90, daCenter,	true,  "bl_no",		false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 90, daCenter,	true,  "cntr_no",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 60, daCenter,	true,  "pol_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 60, daCenter,	true,  "pod_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 50, daCenter,	true,  "b_pol_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 50, daCenter,	true,  "b_pod_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 50, daCenter,	true,  "del_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		100, daCenter,	true,  "il_eta",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 70, daCenter,	true,  "pck_qty",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 90, daCenter,	true,  "pck_tp_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		150, daLeft,	true,  "sh_nm",		false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		200, daLeft,	true,  "sh_ad",		false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		150, daLeft,	true,  "cnee_nm",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		200, daLeft,	true,  "cnee_ad",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		150, daLeft,	true,  "ntfy_nm",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		200, daLeft,	true,  "ntfy_ad",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,	 50, daCenter,	true,  "err_yn",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
				
				CountPosition = 0;
				
				SetSortDialog(false	);
				SelectHighLight= true;
				MultiSelection = true;
				SelectionMode = smSelectionRow;
				
				WordWrap = true;
			}
			break;

			
			case 3:      //sheet3 init
            with (sheetObj) {
            	
            	// 높이 설정
				style.height = 380;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
				MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = "Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Package|Package Unit|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|ERR_YN|";
				var HeadTitle2 = "Seq.|Sel.|B/L No|CNTR  No|POL|POD|B/POL|B/POD|DEL|Israel ETA|Package|Package Unit|NM|AD|NM|AD|NM|AD|ERR_YN|";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 4, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
				InitHeadMode(false, false, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,		 40, daCenter,	true,  "dt_seq",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++,  dtDummyCheck,40, daCenter,	true,  "sel",		false,  "",  dfNone,  0,  true,   false);
				InitDataProperty(0, cnt++ , dtData,		 90, daCenter,	true,  "bl_no",		false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 90, daCenter,	true,  "cntr_no",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 60, daCenter,	true,  "pol_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 60, daCenter,	true,  "pod_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 50, daCenter,	true,  "b_pol_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 50, daCenter,	true,  "b_pod_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 50, daCenter,	true,  "del_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		100, daCenter,	true,  "il_eta",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 70, daCenter,	true,  "pck_qty",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		 90, daCenter,	true,  "pck_tp_cd",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		150, daLeft,	true,  "sh_nm",		false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		200, daLeft,	true,  "sh_ad",		false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		150, daLeft,	true,  "cnee_nm",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		200, daLeft,	true,  "cnee_ad",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		150, daLeft,	true,  "ntfy_nm",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,		200, daLeft,	true,  "ntfy_ad",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,	 50, daCenter,	true,  "err_yn",	false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
				
				CountPosition = 0;
				
				SetSortDialog(false	);
				SelectHighLight= true;
				MultiSelection = true;
				SelectionMode = smSelectionRow;

			}
            break;
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

		sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
				
			case SEARCH: // 조회

				ComSetFocus(formObj.f_cmd);
				if(!validateForm(sheetObj,formObj,sAction))return;
				
				sheetObj.Redraw = false;
				sheetObjects[1].WaitImageVisible = true;

				formObj.f_cmd.value = SEARCH;
				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1168GS.do", FormQueryString(formObj));
					
				if (ComBkgErrMessage(sheetObj, sXml)) {
					formObj.vvd_nm.value    = (ComGetEtcData(sXml,"vvd_nm") != undefined ? ComGetEtcData(sXml,"vvd_nm") : "") ;
					formObj.vvd_ld.value    = (ComGetEtcData(sXml,"vvd_ld") != undefined ? ComGetEtcData(sXml,"vvd_ld") : "") ;
					formObj.vvd_call.value  = (ComGetEtcData(sXml,"vvd_call") != undefined ? ComGetEtcData(sXml,"vvd_call") : "") ;
					formObj.eta.value    	= (ComGetEtcData(sXml,"eta") != undefined ? ComGetEtcData(sXml,"eta") : "") ;
					formObj.etd.value    	= (ComGetEtcData(sXml,"etd") != undefined ? ComGetEtcData(sXml,"etd") : "") ;
					
					// Add. 2015.03.09
					formObj.ttl_bl.value   	= (ComGetEtcData(sXml,"ttl_bl") != undefined ? ComGetEtcData(sXml,"ttl_bl") : "") ;
					formObj.locl_bl.value  	= (ComGetEtcData(sXml,"locl_bl") != undefined ? ComGetEtcData(sXml,"locl_bl") : "") ;
					formObj.ts_bl.value    	= (ComGetEtcData(sXml,"ts_bl") != undefined ? ComGetEtcData(sXml,"ts_bl") : "") ;
					
					sheetObj.LoadSearchXml(sXml);
				}
				
				sheetObjects[1].CheckAll2("sel") = 0;
				formObj.p_ori_amd_cd[0].checked = true;
				
				sheetObj.Redraw = true; 
				sheetObjects[1].WaitImageVisible = false;
				break;

				
			case SEARCH01: // VVD 가 ISRAEL 을 지나는지 아닌지 확인
				
				if (!validateForm(sheetObj, formObj, sAction))	return;
				
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_1168GS.do", FormQueryString(formObj));
				var skdFlg = ComGetEtcData(sXml, "skd_flg");
		
				if (skdFlg == "N") {
					ComShowCodeMessage('BKG06149', "Israel");
					return false;
				}
				break;

				
			case IBDOWNEXCEL:
				
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);

				sheetObjects[2].RemoveAll();
				sheetObj.Copy2SheetCol(sheetObjects[2],"","",-1,-1,-1,2,true,false,"sel","");
				
				if(sheetObjects[2].RowCount) {
					sheet3_OnSearchEnd(sheetObjects[2], "");
				}
				sheetObjects[2].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "sel", "", false, "", true);
				ComOpenWait(false);
				break;
				
				
			case IBCLEAR: // 폼과 시트의 값 삭제
				
				sheetObjects[1].RemoveAll();
				formObj.reset();
				formObj.vvd_cd.focus();
				break;

				
			case MULTI: // EDI FLAT FILE 생성 및 전송
				if(!validateForm(sheetObj,formObj,sAction)) return false;
	
				if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
					return false;
				}

				// 전송할 대상 B/L존재여부를 조회한다.
			
				if (sheetObj.CheckedRows("sel") <= 0 ) {
	                ComShowCodeMessage("COM12189");
	                return;
	            }
				
				var arrRow = ComFindText(sheetObj, "sel", 1);

				var sParam = "";  
				var tempBlno = ""; //bl_no가 머지 되어있어 같은게 두번나온다 이를 체크하여 같으면 건너뛴다.
				for(var i= 0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.CellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					
					sParam +=   "ibflag=U"     +"&"+
								//"p_send_yn="   +formObj.p_send_yn.value+"&"+
					            "vsl_cd="		+formObj.vvd_cd.value.substring(0, 4)+"&"+
					            "skd_voy_no="	+formObj.vvd_cd.value.substring(4, 8)+"&"+
					            "skd_dir_cd="	+formObj.vvd_cd.value.substring(8)+"&"+
					            "bl_no="		+sheetObj.CellValue(arrRow[i], "bl_no"        )+"&"+
					            "pol_cd=" 		+formObj.pol_cd.value+"&";
						tempBlno = sheetObj.CellValue(arrRow[i], "bl_no");
				}
				
				formObj.f_cmd.value = MULTI;
				sParam += "&" + FormQueryString(formObj);

				ComOpenWait(true,true);
				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1168GS.do", sParam)
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				break;
		}
	}

	/**
	 * BackEndJob 실행결과조회<br>
	 * 
	 * @param sheetObj
	 * @param sKey
	 */
	function doActionValidationResult(sheetObj, sKey) {
		//ComShowMessage("1");
		var sXml = sheetObj.GetSearchXml("ESM_BKG_1168GS.do?f_cmd=" + SEARCH02 + "&key=" + sKey);
		var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
		
		//ComShowMessage("doActionValidationResult "+sJbStsFlg);
		
		// 에러가 발생했을 경우 대기사항을 종료한다.
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			// 성공메시지 보여주고
			ComShowCodeMessage('BKG00101');	
			return;
		} else if (sJbStsFlg == "FAIL") {
			//에러
			clearInterval(intervalId);
			ComOpenWait(false);
			// 에러메시지 보여주고
			ComShowMessage(ComResultMessage(sXml));
		}
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		
		switch(sAction) {
			
			case SEARCH: { // Retrieve
				//기본포멧체크
				if (!ComChkValid(formObj)) return false;
				break;
			}
			
			case IBDOWNEXCEL: {
				if (sheetObj.CheckedRows("sel") <= 0 ) {
					ComShowCodeMessage("COM12189");
					return false;
				}
				break;
			}
			
			case MULTI: {
				
				if (sheetObj.CheckedRows("sel") <= 0 ) {
					ComShowCodeMessage("COM12189");
					return false;
				}
//				
//				var errYN = "N";
//				var arrRow = ComFindText(sheetObj, "sel", 1);
//				
//				/*
//				 * Error BL이면 B/L 번호를 보여주고 중단한다.
//				 * */
//				var errorCnt = 0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
//				var errorBls = "";
//				
//				
//				var tempBl = "";
//				var errBlArray = new Array();
//				
//				for (var i=0; i<arrRow.length; i++) {
//					
//					if(sheetObj.CellValue(arrRow[i], "err_yn") == "Y"){
//						if(errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
//							errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] = sheetObj.CellValue(arrRow[i], "bl_no");
//							
//							errorCnt++;
//							if(errorCnt <= 10)
//								errorBls += sheetObj.CellValue(arrRow[i], "bl_no")+",";
//						}
//					}
//					
//					if (tempBl== sheetObj.CellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
//					
//					tempBl = sheetObj.CellValue(arrRow[i], "bl_no");
//					
//				}//end for
//				
//				if(errorCnt > 0){
//					errorBls = errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
//					ComShowCodeMessage("BKG01133",errorBls,"");
//					return false;
//				}
//				
				break;
			}
			
		}
		return true;
	}
	
	/**
	 * 조회조건 입력할 때 처리
	 */
	function obj_KeyUp() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		if ((srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	
	/**
	 * 폼 필드 변경시 이벤트
	 * @return
	 */
	function obj_change() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (srcName == "vvd_cd") {
//			sheetObjects[1].WaitImageVisible = true;
//			ComOpenWait(true);
			doActionIBSheet(sheetObjects[1], formObject, SEARCH01);
//			ComOpenWait(false);
//			sheetObjects[1].WaitImageVisible = false;
		}
	}
	
	/**
	 * 조회후  이벤트 처리 >>> 폰트 칼라변경
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			
			// pol별로 그룹을 묶어 pol를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
			MessageText("SubSum") = "POD";
            ShowSubSum("pod_cd", "err_yn", 0, true, false, SaveNameCol("cntr_no"));
			
			var redColor  = RgbColor(255, 0, 0);
			var blueColor  = RgbColor(0, 0, 255);
			
			for(var i= HeaderRows; i<= LastRow; i++) {
				
				ColFontUnderline("bl_no") = true;
				ColFontColor("bl_no") = blueColor;
				
				if (isError(CellValue(i,"sh_nm"))) CellFontColor(i,"sh_nm") = redColor;
				if (isError(CellValue(i,"sh_ad")))CellFontColor(i,"sh_ad") = redColor;
				
				if (isError(CellValue(i,"cnee_nm"))) CellFontColor(i,"cnee_nm") = redColor;
				if (isError(CellValue(i,"cnee_ad"))) CellFontColor(i,"cnee_ad") = redColor;
				
				if (isError(CellValue(i,"ntfy_nm"))) CellFontColor(i,"ntfy_nm") = redColor;
				if (isError(CellValue(i,"ntfy_ad"))) CellFontColor(i,"ntfy_ad") = redColor;
			}
		}//end width
		pagedMaxCnt = sheetObj.LastRow;
	}
	
	/**
	 * Excel Down 용 group 처리 메서드
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		with (sheetObj) {
			// pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
			MessageText("SubSum") = "POD";
			ShowSubSum("pod_cd", "err_yn", 0, true, false, SaveNameCol("cntr_no"));
		}
	}
	
	/**
	 * Booking Creation 화면 이동
	 * @param String cellValue
	 * return boolean 에러여부
	 */
	function isError(cellValue) {
		if(cellValue == "E") return true;
		return false;
	}
	
	/**
	 * B/L Inquiry 화면 이동
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 */
	function sheet2_OnDblClick(sheetObj, row, col) {
		var colSaveName = sheetObj.ColSaveName(col);
			switch(colSaveName) {
				case "bl_no" :
					ComBkgCall0079(sheetObj.CellValue(row, "bl_no"));
					break;
			} // end switch
	}
	
	
	
	
	/**
     * 시트를 행 다중선택 시 처리
     */
    function sheet2_OnSelectMenu(sheetObj, sAction) {

    	 //메뉴에 대한 처리 Check selected|Unheck selected|-|Check all|Uncheck all
    	  switch(sAction){
    	    case "Check selected" :
    	      var sRowStr = sheetObj.GetSelectionRows("/");
    		  
    	      //자바 스크립트 배열로 만들기
    	      var arr = sRowStr.split("/");
    	      for (i=0; i<arr.length; i++) {
    	    	  if(arr[i] < 2) continue;//header 부분
    	    	  if(sheetObj.CellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
    	    	  
    	    	  if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
    	    		  	var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(arr[i],"dt_seq"));
	  		    		for(var j =0; j <= sameRows.length ; j++) {
	  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
	  		    			sheetObj.CellValue2(sameRows[j], "sel") = 1;		  			    		
	  		    		}
	  		    		
    	    	  }else
    	    		  sheetObj.CellValue2(arr[i], "sel") = 1;
    	      }
    	      break;
    	    case "Unheck selected" :
    	    	var sRowStr = sheetObj.GetSelectionRows("/");
    	    	
    	    	//자바 스크립트 배열로 만들기
    	    	var arr = sRowStr.split("/");
    	    	for (i=0; i<arr.length; i++) {
    	    		if(arr[i] < 2) continue;//header 부분
    	    		if(sheetObj.CellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
    	    		
    	    		if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
    	    			var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(arr[i],"dt_seq"));
    	    			for(var j =0; j <= sameRows.length ; j++) {
    	    				if(sameRows[j] == undefined || sameRows[j] == "") continue;
    	    				sheetObj.CellValue2(sameRows[j], "sel") = 0;		  			    		
    	    			}
    	    			
    	    		}else
    	    			sheetObj.CellValue2(arr[i], "sel") = 0;
    	    	}
    	      
    	      break;

    	    case "Check all" :
    	    	sheetObj.CheckAll2("sel") = 1;  break;
    	    case "Uncheck all" :
    	    	sheetObj.CheckAll2("sel") = 0;  break;
    	  }
    	  
    }
    
    /**
     * sheet1 All 체크시 체크플래그 세팅
     * @param sheetObj 시트오브젝트
     * @param Button 마우스버튼 방향
     * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param X X 좌표
     * @param Y Y 좌표
     */
    function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
		startSelectedRow = sheetObj.FindText("dt_seq",sheetObj.CellValue(sheetObj.MouseRow,"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
		
		var colSaveName = sheetObj.ColSaveName(sheetObj.MouseCol);
        var check = sheetObj.CellValue(startSelectedRow,"sel") == 0?1:0;//down일때 아직 체크박스가 바뀌기 전이므로 미리 바꾸어 놓는다.
        var keySeq = sheetObj.CellValue(startSelectedRow,"dt_seq");
        
        switch(colSaveName) {
	    	case "sel" :
	    		if(startSelectedRow < 2) return;
	    		//alert(startSelectedRow +" "+check+" "+keySeq);
	    		for(i=startSelectedRow ; i<= sheetObj.LastRow ; i++) {
	    			if(eval(keySeq) < eval(sheetObj.CellValue(i, "dt_seq")) ) break;
	    				
		    		if(keySeq == sheetObj.CellValue(i, "dt_seq")) {
	    				sheetObj.CellValue(i, "sel") = check;
	    			}
	    			//alert(i+" " + keySeq+" "+sheetObj.CellValue(i, "dt_seq"));
	    		}
	    		break;
		       
        } // end switch
    }//method end
    	    
    /**
     * 시트를 클릭했을 때 처리 0127참조
     */
    function sheet2_OnClick(sheetObj, row, col) {
    	
    	var colSaveName = sheetObj.ColSaveName(col);
        switch(colSaveName) {
	    	case "sel" :
	    		if(sheetObj.CellValue(row,"bl_no") == "") return;//subsum 행이면
		        var check = sheetObj.CellValue(row,"sel") == 1 ?0:1;
	    		sheetObj.CellValue2(row, "sel") = check;//mousedown 에서 처리한것을 다시 역으로 처리하므로 이것을 다시 역으로 바꿔준다.
	    		break;
		       
        } // end switch
        
    }
    
	
    /* 개발자 작업  끝 */
