/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0024.js
*@FileTitle : Vessel Charter / Lay up Expense
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
	 * @author 
	 */

	/**
	 * @extends
	 * @class User Management : User Management 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_COA_0024() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	    this.setYrWk()  		= setYrWk()  ;
	}

/* 개발자 작업 */


	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var sheetNames   = new Array("sheet1", "sheet2");
	var sheetInits   = new Array(   false,    false);
	var searFlg;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;


	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var shtObj = sheetObjects[0];
		var frmObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {					
				case "btn_rowadd":
					doActionIBSheet(shtObj,frmObj,IBINSERT);
					break;
									
				case "btn_retrieve":
					doActionIBSheet(shtObj, frmObj, IBSEARCH);
					break;

				case "btn_downexcel":
	  				doActionIBSheet(shtObj,frmObj,IBDOWNEXCEL);
				break;          
				
				case "btn_weekcopy":		//팝업창(Week Copy)		
			  	     var display = "0,1";
			  	       ComOpenPopup("ESM_COA_9001.do?classId=ESM_COA_0024&rlane_cd="+document.form.rlane_cd.value+"&prev_week="+prevWeek, 250, 200, "AverageUcCopy", display, true, false);
			  	    break;
				
				case "btn_save":
					doActionIBSheet(shtObj,frmObj,IBSAVE);
					break;
					
                case "btn_close":
                    window.close();
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
		
		//Title 불러오기
		if (document.form.rlane_cd.value == "CDMCO") {									//Vessel Charter
			document.getElementById("div_title").innerHTML = "<img src='img/icon_title_dot.gif' align='absmiddle'>&nbsp;Vessel Charter";
		} else if (document.form.rlane_cd.value == "CNTLY") {								//Lay Up
			document.getElementById("div_title").innerHTML = "<img src='img/icon_title_dot.gif' align='absmiddle'>&nbsp;Lay Up Expense";
		}
		
		initControl();

	    doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form, IBSEARCH); 
		
		// ※※※ sheet1_OnLoadFinish 메서드 반드시 참조 ※※※
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
				style.height = 338;
				//setting width
				SheetWidth = mainTable.clientWidth;
	
				//setting Host information[mandatory][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				//Merge kind [Default msNone]
				MergeSheet = msPrevColumnMerge;
	
				//Edit kind [Default false]
				Editable = true;
	
				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "|DEL|Vessel||Account|SUN|MON|TUE|WED|THU|FRI|SAT|TTL|||||";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// setting Header Mode
				InitHeadMode(false, false, false, true, false, false);//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
	
				//setting Header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				//data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"merge_cd",		true,	"",		dfNone,		0,	false,	true ); 
				
				InitDataProperty(0, cnt++, dtDelCheck,     30,     daCenter,    true,   "del_chk" ); 
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "vsl_cd", true, "", dfEngUpKey, 0, false,	 true, 4);
				InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "vsl_cd_ttl", true, "", dfEngUpKey, 0, true,	 true, 4);		//hidden
				InitDataProperty(0, cnt++, dtData, 160, daLeft, false, "stnd_cost_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "sun_cost_amt",false, "",  dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "mon_cost_amt", false, "", dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "tue_cost_amt", false, "",  dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "wed_cost_amt", false, "",  dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "thu_cost_amt", false, "",  dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "fri_cost_amt", false, "",  dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "sat_cost_amt", false, "",  dfInteger, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 75, daRight, false, "ttl_amt", false, "|sun_cost_amt|+|mon_cost_amt|+|tue_cost_amt|+|wed_cost_amt|+|thu_cost_amt|+|fri_cost_amt|+|sat_cost_amt|",  dfInteger, 0, true, true);		

				InitDataProperty(0, cnt++, dtHidden, 75, daCenter, false,	"stnd_cost_cd", false,	"",	dfNone,	0,	true,	true);	//hidden
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false,	"cost_yrmon",	false,	"",	dfNone,	0,	false,	false);	//hidden
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false,	"rlane_cd",	false,	"",	dfNone,	0,	false,	false);	//hidden
				InitDataProperty(0, cnt++, dtHidden, 40, daCenter, false,	"dp_seq",	false,	"",	dfNone,	0,	false,	false);	//hidden
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
				
				CountPosition = 0;
				WaitImageVisible = false;  	
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
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(shtObj, frmObj, sAction, CondParam, PageNo) {
		switch (sAction) {
		
	    	case IBCLEAR:          //조회
	    		// 부모창에서 넘어온 cost_yrmon값이 없으면 실행
	    		if (frmObj.cost_yrmon.value == "") {
		    		shtObj.WaitImageVisible = false;
					ComOpenWait(true);
					frmObj.f_cmd.value = INIT;
					
					var sXml = shtObj.GetSearchXml("ESM_COA_0021GS.do", coaFormQueryString(frmObj));
					var arrXml = sXml.split("|$$|");
					
					if (0 < arrXml.length) {
					   prevWeek = ComGetEtcData(arrXml[0],"prevWeek");
					   fYear = ComGetEtcData(arrXml[0], "fYear"); 
					}
	    		} else {
	    			fYear = frmObj.cost_yrmon.value.substr(0,4);
	    			prevWeek = frmObj.cost_yrmon.value.substr(4,2);
	    		}
	    		setYrWk(fYear,prevWeek);
					
				ComOpenWait(false);
				break;

			case IBSEARCH:    // 조회
                if (!validateForm(shtObj,frmObj,sAction)) {
                    return false;
                }
				ComOpenWait(true);
				shtObj.Redraw = false;
				frmObj.f_cmd.value = SEARCH;
				shtObj.DoSearch("ESM_COA_0024GS.do", FormQueryString(frmObj));
				shtObj.Redraw = true;
				ComOpenWait(false);
				break;
			
			case IBINSERT: 		//Row Add
				var costYrmon = ComGetUnMaskedValue(frmObj.f_yearweek, "ym");
				var rowCount = shtObj.SelectRow;
				var rlaneCd = frmObj.rlane_cd.value;
				
				var cost_nm = ["Vessel Charter Revenue", "Port EXP", "Canal Transit Fee", "Bunker", "Crew EXP", "Insurance", "Lubricant EXP", "Store Supply EXP", "Vessel M&R", "Depreciations", "Telecom ExP", "Other Operation Fixed Exp", "Time Charterage", "Space Charterage"]
				var cost_cd = ["43101011", "53101000", "53102000", "53200000", "54100000", "54250000", "54300000", "54200000", "54150000", "54450000", "54180000", "54550000", "54350000", "54400000"]
				
				shtObj.Redraw = false;
				
				// TTL 데이터들이 존재한다면...
				var ttlChk = "";
				for (i=0; i<shtObj.LastRow; i++) {
					if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
						if (shtObj.CellValue(i, "vsl_cd") == "TTL" && shtObj.CellValue(i, "stnd_cost_cd") == "43101011") {
							ttlChk = "T";
							break;
						}
					} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
						if (shtObj.CellValue(i, "vsl_cd") == "TTL" && shtObj.CellValue(i, "stnd_cost_cd") == "53101000") {
							ttlChk = "T";
							break;
						}
					}
					if (ttlChk == "T") break;
				}
				
				if (ttlChk == "T") {			//TTL 값이 있으면...	
					if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
						for (i=13; i>=0; i--) {
							shtObj.DataInsert(0);
							shtObj.CellValue2(shtObj.SelectRow, "vsl_cd") = " ";
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_nm") = cost_nm[i];
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_cd") = cost_cd[i];
							shtObj.CellValue2(shtObj.SelectRow, "merge_cd") = rowCount;
							shtObj.CellValue2(shtObj.SelectRow, "cost_yrmon") = costYrmon;
							shtObj.CellValue2(shtObj.SelectRow, "rlane_cd") = rlaneCd;
							shtObj.CellValue2(shtObj.SelectRow, "dp_seq") = i+1;
						}
					} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
						for (i=13; i>=1; i--) {
							shtObj.DataInsert(0);
							shtObj.CellValue2(shtObj.SelectRow, "vsl_cd") = " ";
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_nm") = cost_nm[i];
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_cd") = cost_cd[i];
							shtObj.CellValue2(shtObj.SelectRow, "merge_cd") = rowCount;
							shtObj.CellValue2(shtObj.SelectRow, "cost_yrmon") = costYrmon;
							shtObj.CellValue2(shtObj.SelectRow, "rlane_cd") = rlaneCd;
							shtObj.CellValue2(shtObj.SelectRow, "dp_seq") = i;
						}						
					}
				} else {
					if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
						for (i=0; i<14; i++) {
							shtObj.DataInsert(-1);
							shtObj.CellValue2(shtObj.SelectRow, "vsl_cd") = " ";
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_nm") = cost_nm[i];
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_cd") = cost_cd[i];
							shtObj.CellValue2(shtObj.SelectRow, "merge_cd") = rowCount;
							shtObj.CellValue2(shtObj.SelectRow, "cost_yrmon") = costYrmon;
							shtObj.CellValue2(shtObj.SelectRow, "rlane_cd") = rlaneCd;
							shtObj.CellValue2(shtObj.SelectRow, "dp_seq") = i+1;
						}
					} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
						for (i=1; i<14; i++) {
							shtObj.DataInsert(-1);
							shtObj.CellValue2(shtObj.SelectRow, "vsl_cd") = " ";
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_nm") = cost_nm[i];
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_cd") = cost_cd[i];
							shtObj.CellValue2(shtObj.SelectRow, "merge_cd") = rowCount;
							shtObj.CellValue2(shtObj.SelectRow, "cost_yrmon") = costYrmon;
							shtObj.CellValue2(shtObj.SelectRow, "rlane_cd") = rlaneCd;
							shtObj.CellValue2(shtObj.SelectRow, "dp_seq") = i;
						}
					}
					
				}				

				//TTL이 없으면 만들어준다.
				if (ttlChk != "T" && shtObj.LastRow > 1) {			//TTL 값이 없으면...
					var curr = shtObj.LastRow;
					if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
						var j = 0;
						for (i=curr; i<curr+14; i++) {
							shtObj.DataInsert(-1);
							shtObj.CellValue2(shtObj.SelectRow, "vsl_cd") = "TTL";
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_nm") = cost_nm[j];
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_cd") = cost_cd[j];
							shtObj.CellValue2(shtObj.SelectRow, "merge_cd") = rowCount;
							shtObj.CellValue2(shtObj.SelectRow, "cost_yrmon") = costYrmon;
							shtObj.CellValue2(shtObj.SelectRow, "rlane_cd") = rlaneCd;
							shtObj.CellValue2(shtObj.SelectRow, "dp_seq") = j+1;
							j = j + 1;
							
							shtObj.RowEditable(i+1) = false;
						}
					} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
						var j = 1;
						for (i=curr; i<curr+13; i++) {
							shtObj.DataInsert(-1);
							shtObj.CellValue2(shtObj.SelectRow, "vsl_cd") = "TTL";
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_nm") = cost_nm[j];
							shtObj.CellValue2(shtObj.SelectRow, "stnd_cost_cd") = cost_cd[j];
							shtObj.CellValue2(shtObj.SelectRow, "merge_cd") = rowCount;
							shtObj.CellValue2(shtObj.SelectRow, "cost_yrmon") = costYrmon;
							shtObj.CellValue2(shtObj.SelectRow, "rlane_cd") = rlaneCd;
							shtObj.CellValue2(shtObj.SelectRow, "dp_seq") = j;	
							j = j + 1;
							shtObj.RowEditable(i+1) = false;
						}
					}
				}
				
				//Row Add 후 소계보여주기위함.
				amt_calc(shtObj)
				
				shtObj.Redraw = true;
				
				break;	

			case IBSAVE:    // 저장     
				//저장할 데이터 있는지 체크
				if (shtObj.LastRow < 2) {
					ComShowCodeMessage("COA00007");	//There is no contents to save
					return;
				}
				// Vessel 입력여부 체크
				if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
					for (i=0; i<shtObj.LastRow-14; i++) {
						if (shtObj.CellValue(i, "stnd_cost_nm") == "Vessel Charter Revenue") {
							stNo = i;
							if (shtObj.CellValue(i, "vsl_cd").length != 4 || shtObj.CellValue(i, "vsl_cd") == " ") {
								ComShowCodeMessage("COA10068", "Vessel");		// {?msg1} must be inputted
								for (j=stNo; j<stNo+14; j++) {
									shtObj.CellValue2(j, "vsl_cd") = " ";
								}
								shtObj.SelectCell(stNo, "vsl_cd");
								return;
							}
						}
					}
				} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
					for (i=0; i<shtObj.LastRow-13; i++) {
						if (shtObj.CellValue(i, "stnd_cost_nm") == "Port EXP") {
							stNo = i;
							if (shtObj.CellValue(i, "vsl_cd").length != 4 || shtObj.CellValue(i, "vsl_cd") == " ") {
								ComShowCodeMessage("COA10068", "Vessel");		// {?msg1} must be inputted
								for (j=stNo; j<stNo+13; j++) {
									shtObj.CellValue2(j, "vsl_cd") = " ";
								}
								shtObj.SelectCell(stNo, "vsl_cd");
								return;
							}
						}
					}
				}
								
				if (!ComShowCodeConfirm("COA00006")) {		// Do you want to save?
					return false;
				}
				
					ComOpenWait(true);
					frmObj.f_cmd.value = MULTI;
					
					shtObj.DoAllSave("ESM_COA_0024GS.do", FormQueryString(frmObj));
					doActionIBSheet(shtObj, frmObj, IBSEARCH); 
					ComOpenWait(false);
					
				break;

            case IBDOWNEXCEL:	//엑셀 다운로드
  				var excelType = selectDownExcelMethod(shtObj);
  				switch (excelType) {
  					case "AY":SP
  						shtObj.Down2Excel(0, false, false, true);
//  						sheetObjects[0].Down2Excel(0, false, false, true);
  						break;
  					case "DY":
  						shtObj.Down2Excel(-1, false, false, true);
//  						sheetObjects[0].Down2Excel(-1, false, false, true);
  						break;
  					case "AN":
  						shtObj.SpeedDown2Excel(0, false, false);
//  						sheetObjects[0].SpeedDown2Excel(0, false, false);
  						break;
  					case "DN":
  						shtObj.SpeedDown2Excel(-1, false, false);
//  						sheetObjects[0].SpeedDown2Excel(-1, false, false);
  						break;
  				}
		}
	}


	/**
	 * IBSeet Object 인스턴스가 생성 완료될때 발생하는 Event
	 * (***** 최초 페이지 로드 발생하는 Event (중요) *****)
	 */
	function sheet1_OnLoadFinish(shtObj) {
		//sheet0 (QTY List)
//		doActionIBSheet(shtObj, document.form, SEARCH01);			
	}
    
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		//조회값이 있으면(row수가 2 이상이면)->TTL이 있는 상황..
		if (sheetObj.LastRow > 2) {
			searFlg = "S";
		}
		amt_calc(sheetObj);
		
		//TTL 값은 수정불가하도록...
		for (i=1;i<sheetObj.LastRow; i++) {
			if (document.form.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
				if (sheetObj.CellValue(i, "vsl_cd") == "TTL" && sheetObj.CellValue(i, "stnd_cost_cd") == "43101011") {
					for (j=i; j<i+14; j++) {
						sheetObj.RowEditable(j) = false;
					}
				}
			} else if (document.form.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
				if (sheetObj.CellValue(i, "vsl_cd") == "TTL" && sheetObj.CellValue(i, "stnd_cost_cd") == "53101000") {
					for (j=i; j<i+13; j++) {
						sheetObj.RowEditable(j) = false;
					}
				}
			}
		}
	}
	
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     */
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;

 		switch(colName)
     	{ 			
     		case "del_chk":
     			//첫번째 컬럼 선택시 header 변경 등의 수정
     			var cur_merge_cd = sheetObj.CellValue(Row, "merge_cd");
     			var rcnt = sheetObj.RowCount + sheetObj.HeaderRows;
     	
     			if (formObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
	     			if(sheetObj.CellValue(Row, Col) == 1) {
	     				 for (i=1; i<14; i++) {			//해당 Vessel의 가장아래, 또는 가장위의 row를 선택할 경우 최대 13개까지 체크하여 비교
	     					if(Row-i > 0 && (sheetObj.CellValue(Row-i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-i, Col) = 1;
	         				if(Row+i < rcnt && (sheetObj.CellValue(Row+i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+i, Col) = 1;
	     				 }
	     			} else {
	    				 for (i=1; i<14; i++) {
	      					if(Row-i > 0 && (sheetObj.CellValue(Row-i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-i, Col) = 0;
	          				if(Row+i < rcnt && (sheetObj.CellValue(Row+i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+i, Col) = 0;
	      				 }
	     			}
     			} else if (formObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
	     			if(sheetObj.CellValue(Row, Col) == 1) {
	     				 for (i=1; i<13; i++) {			//해당 Vessel의 가장아래, 또는 가장위의 row를 선택할 경우 최대 13개까지 체크하여 비교
	     					if(Row-i > 0 && (sheetObj.CellValue(Row-i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-i, Col) = 1;
	         				if(Row+i < rcnt && (sheetObj.CellValue(Row+i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+i, Col) = 1;
	     				 }
	     			} else {
	    				 for (i=1; i<13; i++) {
	      					if(Row-i > 0 && (sheetObj.CellValue(Row-i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-i, Col) = 0;
	          				if(Row+i < rcnt && (sheetObj.CellValue(Row+i, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+i, Col) = 0;
	      				 }
	     			}
     			}
 				break; 	
 				
 				// Row Add 일때만 해당
     		case "vsl_cd":
     			var celltxt  = sheetObj.EditValue;
     			 var celltxt1 = sheetObj.CellValue(Row, "vsl_cd");
     			 if (celltxt == "" && celltxt1 != ""){
     				 celltxt = celltxt1;
     			 } 
     			 
     			 //Vessel이 4자리 입력되면 유효한 Vessel 값인지 확인
     			 if (colName == "vsl_cd" && celltxt.length == 4){
     				// Vessle 중복여부 체크
     				var curVsl = "";		//현재 vsl
     				var cmpVsl = "";		//비교할 vsl
     				var stNo;
     				
     				for (i=sheetObj.LastRow; i>0; i--) {
     					if (formObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
	     					if (sheetObj.CellValue(i, "stnd_cost_cd") == "43101011") {		//vessel charter revenue만 체크함
	     						stNo = i;
	     					
	     						curVsl = sheetObj.CellValue(i, "vsl_cd")+" "+sheetObj.CellValue(i,"stnd_cost_cd");	//현재 Vessel + vessel 값
	     						for (j=stNo-1; j>0; j--) {												//다음줄부터 체크
	     							if (sheetObj.CellValue(j, "stnd_cost_cd") == "43101011") {						//그다음에 나오는 vessel charter revenue 값 찾음
	     								cmpVsl = sheetObj.CellValue(j, "vsl_cd")+" "+sheetObj.CellValue(j,"stnd_cost_cd");		//비교할 Vessel + vessel charter revenue
	     								if (curVsl == cmpVsl) {
	     		    						 ComShowCodeMessage("COA10015", "Vessel");
	     		    						 for (k=j; k<j+14; k++) {
	     		    							sheetObj.CellValue2(k, "vsl_cd") = " ";
	     		    						 }
	     									return;
	     								}
	     							}
	     						}
	     					}
     					} else if (formObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
	     					if (sheetObj.CellValue(i, "stnd_cost_cd") == "53101000") {		//Port EXP만 체크함
	     						stNo = i;
	     					
	     						curVsl = sheetObj.CellValue(i, "vsl_cd")+" "+sheetObj.CellValue(i,"stnd_cost_cd");	//현재 Vessel + vessel 값
	     						for (j=stNo-1; j>0; j--) {												//다음줄부터 체크
	     							if (sheetObj.CellValue(j, "stnd_cost_cd") == "53101000") {						//그다음에 나오는 vessel charter revenue 값 찾음
	     								cmpVsl = sheetObj.CellValue(j, "vsl_cd")+" "+sheetObj.CellValue(j,"stnd_cost_cd");		//비교할 Vessel + vessel charter revenue
	     								if (curVsl == cmpVsl) {
	     		    						 ComShowCodeMessage("COA10015", "Vessel");
	     		    						 for (k=j; k<j+13; k++) {
	     		    							sheetObj.CellValue2(k, "vsl_cd") = " ";
	     		    						 }
	     									return;
	     								}
	     							}
	     						}
	     					}
     					}
     				}
     				
	     			var param = "f_cmd="+SEARCH01;
	 				param = param + "&vsl_cd="+sheetObj.CellValue(Row, Col);
	 				
	 				var sXml = sheetObj.GetSearchXml("ESM_COA_0024GS.do", param);
	 				
	 				if (ComGetEtcData(sXml, "vsl_cnt") == 0) {
	 					ComShowCodeMessage("COA10071", sheetObj.CellValue(Row, Col));
	 					if (formObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
		 					for (i=0; i<14; i++) {
		 						sheetObj.CellValue2(Row+i, Col) = " ";
		 					}
	 					} else if (formObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
		 					for (i=0; i<13; i++) {
		 						sheetObj.CellValue2(Row+i, Col) = " ";
		 					}
	 					}
	     				 Value = "";
	     				 sheetObj.SelectCell(Row, Col);
     					 return;
	 				} 				
     			 } else {
     				if (formObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
	     				 for (i=Row; i<Row+14; i++) {
		     				 sheetObj.CellValue2(i, Col) = " ";
		     				 Value = "";
	     				 }
     				} else if (formObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
	     				 for (i=Row; i<Row+13; i++) {
		     				 sheetObj.CellValue2(i, Col) = " ";
		     				 Value = "";
	     				 }
     				}
     				 sheetObj.SelectCell(Row, Col);
 					 return;
     			 }
 				
 				//첫 row에 입력한 Vessel을 나머지 라인에도 적용
     			if (formObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
	 				for (i=1; i<14; i++) {
	 					sheetObj.CellValue2(Row+i, Col) = Value;
	 				}
     			} else if (formObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
	 				for (i=1; i<13; i++) {
	 					sheetObj.CellValue2(Row+i, Col) = Value;
	 				}
     			}
     			
 				break; 	

     		case "sun_cost_amt":
//     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "sun_cost_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);	
 				break; 	
 				
     		case "mon_cost_amt":
     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "mon_cost_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);
 				break; 	
 				
     		case "tue_cost_amt":
     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "tue_cost_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);
 				break; 	
 				
     		case "wed_cost_amt":
     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "wed_cost_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);
 				break; 	
 				
     		case "thu_cost_amt":
     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "thu_cost_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);
 				break; 	
 				
     		case "fri_cost_amt":
     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "fri_cost_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);
 				break; 	
 				
     		case "sat_cost_amt":
     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "sat_cost_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);
 				break; 	
 				
     		case "ttl_amt":
     			// 값이 변하면 TTL에 값도 변경되도록...
     			accnt_calc(sheetObj, "ttl_amt");
     			
     			//subtotal 값 계산하기 (Vessel Charter Revenue - 나머지)
     			amt_calc(sheetObj);
 				break; 	
 				
 				
     	}
 	}
 	
 	//같은 ACCOUNT 끼리 계산
 	function accnt_calc(sheetObj, cols) {
 			var frmObj = document.form;
 			
			// 값이 변하면 TTL에 값도 변경되도록...
			var costSum1 = 0;
			var costSum2 = 0;
			var costSum3 = 0;
			var costSum4 = 0;
			var costSum5 = 0;
			var costSum6 = 0;
			var costSum7 = 0;
			var costSum8 = 0;
			var costSum9 = 0;
			var costSum10 = 0;
			var costSum11 = 0;
			var costSum12 = 0;
			var costSum13 = 0;
			var costSum14 = 0;
			var ttlNo;
			for (i=1; i<sheetObj.LastRow; i++) {
				if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
					if (sheetObj.CellValue(i, "vsl_cd") != "TTL") {
						if (sheetObj.CellValue(i, "stnd_cost_cd") == "43101011") {
							costSum1 = costSum1 + eval(sheetObj.CellValue(i, cols));
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "53101000") {
							costSum2 = costSum2 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "53102000") {
							costSum3 = costSum3 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "53200000") {
							costSum4 = costSum4 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54100000") {
							costSum5 = costSum5 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54250000") {
							costSum6 = costSum6 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54300000") {
							costSum7 = costSum7 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54200000") {
							costSum8 = costSum8 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54150000") {
							costSum9 = costSum9 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54450000") {
							costSum10 = costSum10 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54180000") {
							costSum11 = costSum11 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54550000") {
							costSum12 = costSum12 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54350000") {
							costSum13 = costSum13 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54400000") {
							costSum14 = costSum14 + eval(sheetObj.CellValue(i, cols));     						
						}
					} 
					if (sheetObj.CellValue(i, "vsl_cd") == "TTL" && sheetObj.CellValue(i, "stnd_cost_cd") == "43101011") {
						ttlNo = i
					}
				} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
					if (sheetObj.CellValue(i, "vsl_cd") != "TTL") {
						if (sheetObj.CellValue(i, "stnd_cost_cd") == "53101000") {
							costSum1 = costSum1 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "53102000") {
							costSum2 = costSum2 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "53200000") {
							costSum3 = costSum3 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54100000") {
							costSum4 = costSum4 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54250000") {
							costSum5 = costSum5 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54300000") {
							costSum6 = costSum6 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54200000") {
							costSum7 = costSum7 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54150000") {
							costSum8 = costSum8 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54450000") {
							costSum9 = costSum9 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54180000") {
							costSum10 = costSum10 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54550000") {
							costSum11 = costSum11 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54350000") {
							costSum12 = costSum12 + eval(sheetObj.CellValue(i, cols));     						
						} else if (sheetObj.CellValue(i, "stnd_cost_cd") == "54400000") {
							costSum13 = costSum13 + eval(sheetObj.CellValue(i, cols));     						
						}
					} 
					if (sheetObj.CellValue(i, "vsl_cd") == "TTL" && sheetObj.CellValue(i, "stnd_cost_cd") == "53101000") {
						ttlNo = i
					}
				}
			}
			
			if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
				for (i=ttlNo; i<ttlNo+14; i++) {
					sheetObj.CellValue2(i, cols) = eval("costSum"+(i-ttlNo+1));
				}
			} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
				for (i=ttlNo; i<ttlNo+13; i++) {
					sheetObj.CellValue2(i, cols) = eval("costSum"+(i-ttlNo+1));
				}				
			}
 	}
 	
 	// 화면에는 +값으로 보여주며 계산은 Vessel Charte Revenue에서 나머지를 빼서 계산해야 하는 부분
 	function amt_calc(sheetObj) {
 		var frmObj = document.form;
 		
		// Vessel Charter 화면인 경우,  Vessel Charter Revenue값에서 나머지Account 항목들을 모두 빼야하므로 나머지Account 값을 모두 -(음수)로 만든다.
 		if (document.form.rlane_cd.value == "CDMCO") {
			var stNo;
			for (i=1; i<sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i, "stnd_cost_cd") == "43101011") {
					stNo = i;
					
					for (j=stNo+1; j<stNo+14; j++) {
						sheetObj.CellValue2(j, "sun_cost_amt") = sheetObj.CellValue(j, "sun_cost_amt") - (sheetObj.CellValue(j, "sun_cost_amt") * 2);
						sheetObj.CellValue2(j, "mon_cost_amt") = sheetObj.CellValue(j, "mon_cost_amt") - (sheetObj.CellValue(j, "mon_cost_amt") * 2);
						sheetObj.CellValue2(j, "tue_cost_amt") = sheetObj.CellValue(j, "tue_cost_amt") - (sheetObj.CellValue(j, "tue_cost_amt") * 2);
						sheetObj.CellValue2(j, "wed_cost_amt") = sheetObj.CellValue(j, "wed_cost_amt") - (sheetObj.CellValue(j, "wed_cost_amt") * 2);
						sheetObj.CellValue2(j, "thu_cost_amt") = sheetObj.CellValue(j, "thu_cost_amt") - (sheetObj.CellValue(j, "thu_cost_amt") * 2);
						sheetObj.CellValue2(j, "fri_cost_amt") = sheetObj.CellValue(j, "fri_cost_amt") - (sheetObj.CellValue(j, "fri_cost_amt") * 2);
						sheetObj.CellValue2(j, "sat_cost_amt") = sheetObj.CellValue(j, "sat_cost_amt") - (sheetObj.CellValue(j, "sat_cost_amt") * 2);
						sheetObj.CellValue2(j, "ttl_amt") = sheetObj.CellValue(j, "ttl_amt") - (sheetObj.CellValue(j, "ttl_amt") * 2);
					}
				}
			}
 		}
		
		//계산식을 실행한다
		sheetObj.MessageText("SubSum") = "TTL";
		for (i=1; i<sheetObj.LastRow; i++) {
			if (frmObj.rlane_cd.value == "CDMCO") {	//Vessel Charter화면
				if (sheetObj.CellValue(i, "vsl_cd") == "TTL" && sheetObj.CellValue(i, "stnd_cost_cd") == "43101011") {
					if (sheetObj.CellValue(i, "vsl_cd_ttl") != "") {
						sheetObj.ShowSubSum("vsl_cd_ttl", "5|6|7|8|9|10|11|12", -1, false, false, 4);
					}
				} else {				
					if (sheetObj.CellValue(i, "vsl_cd_ttl") == "") {
						sheetObj.ShowSubSum("vsl_cd", "5|6|7|8|9|10|11|12", -1, false, false, 4);
					}
				}
			} else if (frmObj.rlane_cd.value == "CNTLY") {	//Lay Up Expense화면
				if (sheetObj.CellValue(i, "vsl_cd") == "TTL" && sheetObj.CellValue(i, "stnd_cost_cd") == "53101000") {
					if (sheetObj.CellValue(i, "vsl_cd_ttl") != "") {
						sheetObj.ShowSubSum("vsl_cd_ttl", "5|6|7|8|9|10|11|12", -1, false, false, 4);
					}
				} else {				
					if (sheetObj.CellValue(i, "vsl_cd_ttl") == "") {
						sheetObj.ShowSubSum("vsl_cd", "5|6|7|8|9|10|11|12", -1, false, false, 4);
					}
				}
			}
		}
		
		// TTL이 두번 보이는데 필요한 TTL만 보이고 불필요한 ROW는 삭제
		if (searFlg=="S") {						//조회시 TTL이 있을때만 시행 (TTL없을때는 새로 TTL을 add row하는데 이때는 적용하지 않음)
			for (i=1; i<sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i, "stnd_cost_nm") == "TTL : " || sheetObj.CellValue(i, "stnd_cost_nm") == "TTL : TTL") {
					sheetObj.RowDelete(i, false);
				}
			}
			sheetObj.RowDelete(sheetObj.LastRow, false);
		}
		
		//Vessel Charger 화면인 경우, 화면에 다시 -(음수)가 아닌 정상적인 값을 보여준다.
		if (document.form.rlane_cd.value == "CDMCO") {
			var stNo1;
			for (i=1; i<sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i, "stnd_cost_cd") == "43101011") {
					stNo1 = i;
					
					for (j=stNo1+1; j<stNo1+14; j++) {
						sheetObj.CellValue2(j, "sun_cost_amt") = sheetObj.CellValue(j, "sun_cost_amt") - (sheetObj.CellValue(j, "sun_cost_amt") * 2);
						sheetObj.CellValue2(j, "mon_cost_amt") = sheetObj.CellValue(j, "mon_cost_amt") - (sheetObj.CellValue(j, "mon_cost_amt") * 2);
						sheetObj.CellValue2(j, "tue_cost_amt") = sheetObj.CellValue(j, "tue_cost_amt") - (sheetObj.CellValue(j, "tue_cost_amt") * 2);
						sheetObj.CellValue2(j, "wed_cost_amt") = sheetObj.CellValue(j, "wed_cost_amt") - (sheetObj.CellValue(j, "wed_cost_amt") * 2);
						sheetObj.CellValue2(j, "thu_cost_amt") = sheetObj.CellValue(j, "thu_cost_amt") - (sheetObj.CellValue(j, "thu_cost_amt") * 2);
						sheetObj.CellValue2(j, "fri_cost_amt") = sheetObj.CellValue(j, "fri_cost_amt") - (sheetObj.CellValue(j, "fri_cost_amt") * 2);
						sheetObj.CellValue2(j, "sat_cost_amt") = sheetObj.CellValue(j, "sat_cost_amt") - (sheetObj.CellValue(j, "sat_cost_amt") * 2);
						sheetObj.CellValue2(j, "ttl_amt") = sheetObj.CellValue(j, "ttl_amt") - (sheetObj.CellValue(j, "ttl_amt") * 2);
					}
				}
			}
		}
 		
 	}
 	
 	 /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//공통 체크	       
    	with(formObj){        	
        	if(!ComIsDate(f_yearweek, "yw")){
        		ComShowMessage(ComGetMsg("COM12114", "Week"));
				f_yearweek.focus();
				return false;
        	}
        } 
        return true;
    }
    	
    function fnYearWeekSet(obj){
        obj.value = ComGetMaskedValue(obj.value,"yw");
        
        setPeriod(obj);
    }
    
    /**
     * 입력창에 지정한 주 셋팅
     * 사용 : setYrWk('2013','25')
     *
     * @param Previous Week's year
     * @param Previous Week
     * @return NONE
     */    
    function setYrWk(fYear, prevWeek){
    	var formObj = document.form;
    	with(formObj){
    		var nowYear = fYear;
            f_yearweek.value = nowYear+prevWeek;	
            
            if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;

    		// 기간 표시   
            setPeriod(f_yearweek);    		
    	}
    	
        fnYearWeekSet(document.getElementById("f_yearweek"));
    }
    
    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){		
        ComCoaSetPeriod2(obj);
    }  

/* 개발자 작업 끝 */
