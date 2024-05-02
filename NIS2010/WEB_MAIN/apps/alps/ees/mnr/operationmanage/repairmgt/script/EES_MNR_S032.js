	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_S032.js 
	 *@FileTitle : Repair Result creatioln by W/O
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.29
	 *@LastModifier : 손흥식
	 *@LastVersion : 1.0
	 *  2009.09.29 손흥식
	 *  2009.11.030  권영법
	 * 1.0 Creation
		=========================================================*/
	/****************************************************************************************
		  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
							[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
							기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends 
	 * @class EES_MNR_S032 : EES_MNR_S032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_S032() {
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
	
	//공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var costDtlCode = "";
	var costDtlDesc = "";
	var OrgCostType = "";
	var nowLoad = 0;
	
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	
	//Calculate 요청
	var calReq = 0;
	
	//삭제 calculate 계산
	var calDel = "";
	
	//조회시 쉬트 콤보 동기화를 변수
	var arrDataSearchDbXml;
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_WONo":
				ComOpenPopup("EES_MNR_0211.do", 720, 380, 'setPopUpParam_EES_MNR_0211', '0,0', true);
				break;
			case "btn_retrive":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
	
			case "btn_clear":
				doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_downExcel":
				sheetObject.SpeedDown2Excel(-1);
				break;
			case "btn_calendar":
				var cal = new ComCalendarFromTo();
				cal.setDiffDomain(true);
				cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				break;
			case "btn_loadExcel":
				//2010-04-15 : W/O No 없는 upload 에러를 막기위함.
				/*  
				allSheetClr();  
				ComOpenPopup('/hanjin/EES_MNR_S232.do?eq_type=' + comboValue, 798, 511, 'getEES_MNR_S232', '1,0,1,1,1,1,1,1,1,1,1,1', false);
				*/ 
               break;     

			case "btn_Print":
				if(sheetObjects[0].RowCount == 0){  
					ComShowCodeMessage("MNR00310"); 			
				} else {
					//있다면  RD 호출		
					var prefix = "sheet1_";	
					var mnr_ord_ofc_cty_cd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix +"mnr_ord_ofc_cty_cd");
					var mnrOrdSeq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix + "mnr_ord_seq");
					mnrOrdSeq = mnrOrdSeq.substr(3,mnrOrdSeq.length);
					var rdParam = '/rv mnr_ord_ofc_cty_cd['+ mnr_ord_ofc_cty_cd +'] mnr_ord_seq[' + mnrOrdSeq + '] user_nm[' + self_usr_nm + ']';
					formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd';	
					formObject.com_mrdArguments.value =	rdParam;
					ComOpenRDPopup();  	 
				}			
				break;	
							
			case "btn_Detail":	
				if(sheetObjects[0].RowCount == 0){ 
					ComShowCodeMessage("MNR00309");				
				} else {		
					//견적서 팝업 호출  
					var prefix = "sheet1_"; 
					if(MnrNullToBlank(sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix + "eq_no")) != ''){
						var rqstEqNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix + "eq_no");    
						var rprRqstSeq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix + "rpr_rqst_seq");
						var rprRqstVerNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix + "rpr_rqst_ver_no");    
						var eqKndCd = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix + "eq_knd_cd"); 
										 									
						ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
					}	 	  
				}	
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;
		initControl();    
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}
	
		initCombo();
		
		formObj.tocal.value  = ComGetNowInfo();
		formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -7);
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Send");
		//2010-04-15 : W/O No 없는 upload 에러를 막기위함. 
		ComBtnDisable("btn_loadExcel");
	}
		
	/**
	 * getEES_MNR_S232 의 값을 받은 함수  
	 * @param Array[][]     aryPopupData		[0]EQNO   [1]YARD  [2]FLAGDATE 	  	
	 * @param Array[]       arrRetVal 	        [0]EQ_TYPE    [1]FLAG or UNFLAG
	 */
	
	function getEES_MNR_S232(rArray){

   	 var formObj = document.form;	    
		 var firstSelect = 0;  
		

   	 var mnr_dmg_flg = "0";    

		 for(var i = 0;i <  rArray.length;i++){    
		 	 var Row = sheetObjects[0].DataInsert(-1);  
			 if(i == 0)  
			 	 firstSelect = Row;    
			sheetObjects[0].RowStatus(Row) = "U"; 
			sheetObjects[0].CellValue2(Row,"sheet1_pig_eng_nm") = rArray[i][0]; 
			sheetObjects[0].CellValue2(Row,"sheet1_eq_no") = rArray[i][1]; 
			sheetObjects[0].CellValue2(Row,"sheet1_eq_tpsz_cd") = rArray[i][2];
			sheetObjects[0].CellValue2(Row,"sheet1_mnr_ord_seq") = rArray[i][3]; 	
			sheetObjects[0].CellValue2(Row,"sheet1_yd_cd") = rArray[i][4]; 
			sheetObjects[0].CellValue2(Row,"sheet1_rqst_dt") = rArray[i][5];
			sheetObjects[0].CellValue2(Row,"sheet1_cre_dt") = rArray[i][6];
			sheetObjects[0].CellValue2(Row,"sheet1_rpr_sts_cd_nm") = rArray[i][7]; 
			sheetObjects[0].CellValue2(Row,"sheet1_upd_usr_id") = rArray[i][8];
			sheetObjects[0].CellValue2(Row,"sheet1_rpr_rslt_dt") = rArray[i][9];
			sheetObjects[0].CellValue2(Row,"sheet1_rpr_rslt_days") = rArray[i][10]; 
			sheetObjects[0].CellValue2(Row,"sheet1_ord_dtl_rmk") = rArray[i][11];
			sheetObjects[0].CellValue2(Row,"sheet1_ord_dtl_seq") = rArray[i][12];
			sheetObjects[0].CellValue2(Row,"sheet1_mnr_dmg_flg") = rArray[i][13]; 
			sheetObjects[0].CellValue2(Row,"sheet1_eq_knd_cd") = rArray[i][14];

			// sheetObjects[0].CellValue2(Row,"eq_tpsz_cd") = rArray[i][3];   	
		 } 
		

   }    
	
	function allSheetClr(){   
		//쉬트 초기화        
		for(i=0;i<sheetObjects.length;i++){
			shtClear(sheetObjects[i]);      			
		}  
	}
	
	// 프리폼스타일의 타이틀및 디자인 설정
    function shtClear(sheetObj)
    {
           var shtID = sheetObj.id;

           switch(shtID) 
           {
		   			case "sheet1":
					
						with(sheetObj)
                        {
						 	RemoveAll();
						}	 
					break;
           }
		   sheetObj.Redraw;     
    }
	function setPopUpParam_EES_MNR_0211(array) {
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";	
		var arr = str.split(',');
	
		formObj.mnr_ord_seq.value = arr[4];
	
		if(formObj.mnr_ord_seq.value.length > 3){
			//alert(formObj.mnr_ord_seq.value);
			//doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
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
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
		case 1:
			with (tabObj) {
			}
			break;
		}
	}
		
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo() {
	
		var formObject = document.form
	
		with (formObject.combo_rpr_rslt_sts) {
	
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("100");
			DropHeight = 160;
	
			Enable = true;
		}
	
		with (formObject.combo_eq_knd_cd) {
	
			MultiSeparator = "|";
			SetColAlign("left");
			SetColWidth("80");
			DropHeight = 160;
	
			Enable = true;
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 368;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 3, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(22, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
	
			var HeadTitle = "|Seq|S/P|EQ No.|TP/SZ|W/O No.|Estimate No|W/O Amount|Repair Yard|Input Date|W/O Date|Estimate Status|Repair Creation\n User|Repair Creation\n Date|Days fm W/O\n to Repair|Remark(s) ";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			var prefix = "sheet1_"; 
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,	true,		prefix+	"ibflag");
			InitDataProperty(0, cnt++ , dtDataSeq,				30,     daCenter,  	true,    	"Seq",     					false,          "",      dfNone    );
			InitDataProperty(0, cnt++ , dtHidden,    			50,     daLeft,    	true,    	prefix +"pig_eng_nm",     	false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,     			75,     daCenter,  	false,     	prefix +"eq_no",     		false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,     			40,     daCenter,  	false,      prefix +"eq_tpsz_cd",     	false,          "",      dfNone, 	0,  false , false      );
	
			InitDataProperty(0, cnt++ , dtData,      			50,     daCenter,  	false,     	prefix +"mnr_ord_seq",     	false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			80,    	daCenter,  	false,     	prefix +"rqst_ref_no",     	false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			80,    	daRight,  	false,     	prefix +"mnr_wrk_amt",     	false,          "",      dfFloat, 	2,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			73,     daCenter,  	false,     	prefix +"yd_cd",     		false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			67,     daCenter,  	false,     	prefix +"rqst_dt",     		false,          "",      dfDateYmd, 0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			65,     daCenter,  	false,     	prefix +"cre_dt",     		false,          "",      dfDateYmd, 0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			98,     daCenter,  	false,    	prefix +"rpr_sts_cd_nm",    false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			100,    daCenter,  	false,    	prefix +"upd_usr_id",     	false,          "",      dfNone, 	0,  false , false      );
	
			InitDataProperty(0, cnt++ , dtPopupEditFormat,      100,    daCenter,  	true,      	prefix+"rpr_rslt_dt",     	false,          "",      dfDateYmd,	0,	true  ,	true	    );         
			InitDataProperty(0, cnt++ , dtData,      			80,     daRight,   	false,    	prefix +"rpr_rslt_days",    false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtData,      			80,     daCenter,  	false,    	prefix +"ord_dtl_rmk",     	false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtHidden,      			100,    daCenter,  	false,    	prefix +"ord_dtl_seq",     	false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtHidden,      			100,    daCenter,  	false,    	prefix +"mnr_dmg_flg",     	false,          "",      dfNone, 	0,  false , false      );
			InitDataProperty(0, cnt++ , dtHidden,      			100,    daCenter,  	false,    	prefix +"eq_knd_cd",     	false,          "",      dfNone, 	0,  false , false      );

			InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  false,    prefix +"rpr_rqst_seq",     false,          "",      dfNone, 0,  false , false      );
			InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  false,    prefix +"rpr_rqst_ver_no",     false,          "",      dfNone, 0,  false , false      );
			InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  false,    prefix +"mnr_ord_ofc_cty_cd",     false,          "",      dfNone, 0,  false , false      );
			
				
			PopupImage  =  "/hanjin/img/btns_calendar.gif";
			ShowButtonImage = 2;        
		}
		break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			formObj.f_gubuns.value = "";
			formObj.mnr_ord_seq.value="";
			formObj.cost_ofc_cd.value = currOfcCd;
			formObj.rqst_ref_no.value = "";
			formObj.eq_no.value = "";
			
			//Combo 세팅
			formObj.combo_eq_knd_cd.RemoveAll();
			formObj.combo_rpr_rslt_sts.RemoveAll();
			formObj.combo_eq_knd_cd.Code2 = "-1";
			formObj.combo_rpr_rslt_sts.Code2 = "-1"; 
			var sCondition = new Array (
					new Array("MnrGenCd","CD00002", "COMMON") //EQ Type
				   ,new Array("MnrGenCd","CD00030", "COMMON") //Repair Completion Status
				);   
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			var code,Texts="";
			for(var i=0; i<comboList.length; i++)
			{	
				if(comboList[i] != null)
				{
                    if(i==1){
            			formObj.combo_rpr_rslt_sts.InsertItem(0, "All" ,"");
					}
					for(var j = 0; j < comboList[i].length;j++)
					{   
						var xmlVal = comboList[i][j].split("|");  
						if(i==0){
							formObj.combo_eq_knd_cd.InsertItem(j, xmlVal[1] ,xmlVal[0]);
						}else if(i==1){
							formObj.combo_rpr_rslt_sts.InsertItem(j + 1, xmlVal[1] ,xmlVal[0]);
						}
					}	
				}
				else
				{
					if(i==0){
						ComShowCodeMessage("MNR00005", "EQ Type  ");
					}else if(i==1){
						ComShowCodeMessage("MNR00005", "Repair Completion Status  ");
					}
				}
			}		
			formObj.combo_eq_knd_cd.Code = "U";
			formObj.combo_rpr_rslt_sts.Index = 0;
			
			sheetObjects[0].RemoveAll();
			MnrWaitControl(false);
			ComBtnDisable("btn_loadExcel");
			comboValue = "U";
			
			
		break;	
		
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad = 1;
			formObj.f_gubuns.value = "";
			sheetObjects[0].RemoveAll();
			MnrWaitControl(true);
			formObj.f_cmd.value = SEARCH; 
		
			formObj.eq_knd_cd.value=formObj.combo_eq_knd_cd.Code;
			formObj.rpr_rslt_sts.value=formObj.combo_rpr_rslt_sts.Code;
		
			var sParam = "";
			var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_");
		
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		
			var sXml   = sheetObj.GetSearchXml("EES_MNR_S032GS.do", sParam);
			arrDataSearchDbXml = sXml.split("|$$|");
		
			for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
				sheetObjects[i].Redraw = false;
				if (i > 0) {
					sheetObjects[i].WaitImageVisible = false;
				}
				sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
				sheetObjects[i].Redraw = true;
				if (i>0) break;
			}   
	
		break;
	
		case IBSAVE:        //저장
			if(nowLoad != 0) return;
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
		
			formObj.f_cmd.value = MULTI;
		
			var aryPrefix = new Array("sheet1_", "sheet2_");
			var sParam = ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
			{
				MnrWaitControl(false);
				ComBtnDisable("btn_loadExcel");
				return false;
			}
		
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
		
			var sXml = sheetObj.GetSaveXml("EES_MNR_S032GS.do", sParam);
			sheetObjects[0].LoadSaveXml(sXml);
			formObj.f_gubuns.value = "";
			
		break;
	
		case IBSEARCH_ASYNC01:
			if( ComGetObjText(formObj.vndr_seq) == "" ) {
				ComShowCodeMessage("MNR00172","Service Provider Seq ");
				ComSetFocus(formObj.vndr_seq); 
				return false;  
			}     
			break;    			
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet1_";
		MnrWaitControl(false);
		ComBtnDisable("btn_loadExcel");
		nowLoad = 0;
	}
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 
	
				ComShowCodeMessage("MNR00078");
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	
			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
		ComBtnDisable("btn_loadExcel");
	}	     
	
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) != "sheet1_rpr_rslt_dt") return;
	
		var cal = new ComCalendarGrid();     
		cal.setDiffDomain(true);
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');  
	}  
	
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		with(formObj){
			//조회시
			if(sAction==IBSEARCH)
			{
				if(formObj.combo_eq_knd_cd.Index == "-1"){
					ComShowCodeMessage("MNR00036","EQ Type");    
					ComSetFocus(formObj.combo_eq_knd_cd);     
					return false;
				}
	
				if(formObj.fromcal.value.length <10){
					ComShowCodeMessage("MNR00036","W/O Issue Date");    
					ComSetFocus(formObj.fromcal);     
					return false;
				}
	
				if(formObj.tocal.value.length <10){
					ComShowCodeMessage("MNR00036","W/O Issue Date");    
					ComSetFocus(formObj.tocal);     
					return false;
				}

				var arrWoNo = formObj.mnr_ord_seq.value.split(",");
				if(arrWoNo!=""){
					for(i=0;i<arrWoNo.length;i++){
						if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
							ComShowCodeMessage("MNR00010","W/O No");
							return false;
						}
					}
				}				
			}
			else if(sAction==IBSAVE)
			{
				var strClinetDate=ComGetNowInfo().split("-");
				strClinetDate=strClinetDate.join("");
								
				var rCnt=sheetObj.RowCount;

				for(var i=1;i<=rCnt;i++)
				{
					//2. 해당 Cost Detail Type 빈값일 경우
					var strRprRsltDt =ComTrimAll(sheetObj.CellValue(i, "sheet1_rpr_rslt_dt")," ");
					if(strRprRsltDt=="")strRprRsltDt=0;
					if(!(strRprRsltDt <= strClinetDate))
					{
						ComShowCodeMessage("MNR00237");
						sheetObj.SelectCell(i, "sheet1_rpr_rslt_dt",true);
						return false; 
					}
				}
			}
			return true;
		}
	}
	
	function initControl() {        
		//Axon 이벤트 처리1. 이벤트catch 
		var formObject = document.form;       
		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',    'obj_activate',    formObject,	'agmt_no');             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
	}                           
	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){         
		ComChkObjValid(event.srcElement); 
	}        
	
	function obj_activate(){   
		var obj = event.srcElement;       
		//버그성 agmt_no 일단 막아놈       
		if(obj.name != "agmt_no"){        
			ComClearSeparator(event.srcElement);
	
		} else {      
			obj.style.imeMode = "disabled" ;
		}           
	}  
	
	function obj_change(){     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
	
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
			case "vndr_seq":  
				doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				//formObj.trf_no.value = "";    
				break;  
			case "agmt_no":    
				formObj.agmt_no.value = formObj.agmt_no.value.substring(0,3) + ComLpad(formObj.agmt_no.value.substring(3,formObj.agmt_no.value.length), 6, "0");   
				doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				break;        
			}       
		} else {
			switch(obj.name) {      
			case "vndr_seq":  
				formObj.vndr_nm.value = "";
				break;  	
			case "agmt_no":  
				//combo1 세팅      
				comboObjects[0].RemoveAll();     
				comboObjects[0].InsertItem(0, '1|' + ComGetNowInfo('ymd') + ' ' + ComGetNowInfo("hms"),'1');
				defVerCode = '1';         
				comboObjects[0].Code = defVerCode;     
				formObj.agmt_ver_no.value = defVerCode;         
				break;  	
			}  		
		}
	}      
	
	function obj_keypress(){ 
		obj = event.srcElement; 
		if(obj.dataformat == null) return;
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
		case "ymd":
		case "ym":
		case "hms":
		case "hm":
		case "jumin":
		case "saupja":
			ComKeyOnlyNumber(obj);  
			break; 
		case "int":      
			ComKeyOnlyNumber(obj); 		
			break; 
		case "float":    
			ComKeyOnlyNumber(obj, "-."); 
			break;  
		case "eng": 
			ComKeyOnlyAlphabet(); break;     
		case "engup":           
			if(obj.name=="vndr_seq"){ 
				ComKeyOnlyNumber(obj);     
			} else {
				ComKeyOnlyAlphabet('uppernum');	
			}                 
			break;     
		case "engdn": 
			//포멧 처리를 하지 않기 위해   
			if(obj.name == "phn_no" || obj.name == "fax_no"){  
				ComKeyOnlyNumber(obj, "-");	 
			}	else if(obj.name=="mnr_prnr_eml") {  
				MnrKeyOnlyAlphabet('lowereml');     
			} 	else {
				ComKeyOnlyAlphabet('lower');  	
			}      
			break; 
		}  		  
	} 	
	
