/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3522.js
*@FileTitle : Inland Rates Excel Imports
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.10 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class ESM_PRI_3522 : ESM_PRI_3522 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3522() {
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

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//업로드된 데이터 CHECK후 FLAG
	var ERR_FLG = "";
	//엑셀체크에서 나타난 오류데이터 - 탭으로 이동시 사용
	var TAB_DATA = "";
 	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {     
                if (getButtonTable(srcName).disabled || window.event.srcElement.disabled) {
                    return false;
                }
            }

			switch (srcName) {
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;

				case "btn_rowadd":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;

				case "btn_rowdelete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;

				case "btn_loadexcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break; 

				case "btn_check":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

				case "btn_close":
					window.close();
					break;

			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
   	* @author 최성민
   	* @version 2010.10.13
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 최성민
    * @version 2010.10.13
    */
	function loadPage() {
		var formObj = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			sheetObjects[i].XmlHttpVer = 2;
		}

		//컬럼세팅
		initLocationSheetColumn();
	    //버튼 초기화
	    toggleButtons("INIT");
	}
		
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
         	case "sheet1":	//location information
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 460;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 1000);

                     var HeadTitle1 = "Flag| | | | | | | | | | | | | " + 
                     		"|One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Note";
                     
                     var HeadTitle2 = "Flag|Sel.|Seq.|Loc. Code|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN <=|Weight\nMAX >=|Weight\nUnit|Type|Currency" + 
                     		"|Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Note";

                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,	daCenter,	false,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtDummyCheck,	40, daCenter,  	false,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,		40, daCenter,  	false,	"trf_inlnd_rt_seq");
 					 InitDataProperty(0, cnt++ , dtPopupEdit,  	80,	daCenter,	false,	"inlnd_rt_bse_loc_cd",			true,	"",	dfNone, 			0,     true,	true,	5);
                     InitDataProperty(0, cnt++ , dtData,		160,daLeft,		false,	"inlnd_rt_bse_loc_nm",			false,	"",	dfNone,				0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter,	false,	"inlnd_rt_bse_loc_zip_cd",		false,	"",	dfNone, 		 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtCombo,		70, daCenter,	false,	"inlnd_rt_term_cd",  			false,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,   80, daCenter, 	false,	"inlnd_rt_via_loc_cd", 			false,	"",	dfNone, 			0,     true,	true,	5);
                     InitDataProperty(0, cnt++ , dtCombo,  	    90, daCenter, 	false,	"prc_inlnd_rt_trsp_mod_cd",   	false,	"",	dfNone, 			0,     true,	true);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter,	false,	"inlnd_rt_min_lmt_wgt",     	false,	"",	dfNullFloat,	 	1,     true,	true,	5);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter,	false,	"inlnd_rt_lmt_wgt",     		false,	"",	dfNullFloat,	 	1,     true,	true,	5);
                     InitDataProperty(0, cnt++ , dtCombo,		50, daCenter,	false,	"inlnd_rt_lmt_wgt_ut_cd",		false,	"",	dfNone, 		 	0,     true,	true);
                     
                     InitDataProperty(0, cnt++ , dtCombo,		50, daCenter,	false,	"prc_cgo_tp_cd",     			false,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtCombo,		75, daCenter,	false,	"curr_cd",     					true,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_one_wy_bx_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_one_wy_20ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_one_wy_40ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_one_wy_40ft_hc_rt_amt",	false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_one_wy_45ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_bx_rt_amt",     			false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_20ft_rt_amt",			false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_40ft_rt_amt",			false,	"",	dfNullInteger, 		0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_40ft_hc_rt_amt",			false,	"",	dfNullInteger, 		0,     true,	true,	10);
                     
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	false,	"inlnd_45ft_rt_amt",			false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		200, daLeft, 	true,	"inlnd_rt_rmk",					false,	"",	dfNone, 		 	0,     true,	true,	200);
                     //InitDataProperty(0, cnt++ , dtHidden,		80, daCenter, 	true,	"src_info_cd",     				false,	"",	dfNone, 		 	0,     false,	false);
                                
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_pfx_cd");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_no");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_inlnd_seq");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"amdt_seq");                     
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_inlnd_rt_seq");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"n1st_cmnc_amdt_seq");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"upd_dt");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"cre_dt");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"cre_usr_id");
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"upd_usr_id");                     
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"input_flg");                     
                     //InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"color_flg");                     
                     
                     InitDataCombo(0, "inlnd_rt_term_cd", inlndRtTermCdComboText, inlndRtTermCdComboValue);
                     InitDataCombo(0, "prc_inlnd_rt_trsp_mod_cd", prcRrspModCdComboText, prcRrspModCdComboValue);
                     InitDataCombo(0, "inlnd_rt_lmt_wgt_ut_cd", inlndRtLmtWgtUtCdComboText, inlndRtLmtWgtUtCdComboValue);
                     InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdComboText, prcCgoTpCdComboValue);
                     InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);
                     //InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue);
                     
                     //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				 InitDataValid(0, "inlnd_rt_bse_loc_cd",            vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					 InitDataValid(0, "inlnd_rt_via_loc_cd", 			vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력
 					 
                     //InitDataValid(0, "inlnd_rt_lmt_wgt", 				vtNumericOther, ".");
 					 InitDataValid(0, "inlnd_rt_bse_loc_zip_cd", 		vtNumericOnly);
 					 
 					/*InitDataValid(0, "inlnd_20ft_rt_amt", 				vtNumericOnly);
 					 InitDataValid(0, "inlnd_40ft_rt_amt", 				vtNumericOnly);
 					 InitDataValid(0, "inlnd_40ft_hc_rt_amt", 			vtNumericOnly);
 					 InitDataValid(0, "inlnd_45ft_rt_amt", 				vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_bx_rt_amt", 		vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_20ft_rt_amt", 		vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_40ft_rt_amt", 		vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_40ft_hc_rt_amt", 	vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_45ft_rt_amt", 		vtNumericOnly);*/
 					

 					 ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";					 
			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 //CountPosition = 0;		// Total 숨김			 		 
	                 WaitImageVisible = false;
	               	                 
	                 //영역 다중 선택 가능 여부 설정하기
	                 //MultiSelection = false;
	                 
	                 //MultiSelection=false 이면 1개의 행만 선택 가능 
	                 //SelectionMode = smSelectionRow; //1
	                 
	                 //Row Height 가 늘어나는것을 방지
	                 AutoRowHeight = false;
	                 
	                 
         		}
              	break;
     	}
	}
	
  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 최성민
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {	 				
	 			case IBSEARCH: // Check
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	 				ComOpenWait(true);	 				
	 				ComShowCodeMessage("PRI06013");
	 				
	 				//엑셀파일체크시 필수입력설정을 false처리한다.
	 				setKeyField();	 				
	 				 
					//오류데이터 빨간색 처리
					checkValidationAllData(sheetObj);
	 				break;
	 				
	 			case IBSAVE: // Save						
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	 				ComOpenWait(true);	 				
	 				if (!ComPriConfirmSave()) {
	  					return false;
	  				}
	 					 				
					var sParam = "f_cmd=" + MULTI;
					sParam = sParam + "&trf_pfx_cd=" 		+ formObj.trf_pfx_cd.value;
					sParam = sParam + "&trf_no=" 			+ formObj.trf_no.value;
					sParam = sParam + "&trf_inlnd_seq=" 	+ formObj.trf_inlnd_seq.value;
					sParam = sParam + "&amdt_seq=" 			+ formObj.amdt_seq.value;
					sParam = sParam + "&n1st_cmnc_amdt_seq="+ formObj.amdt_seq.value;
					sParam = sParam + "&src_info_cd=" 		+ "NW";
					sParam = sParam + "&excel_flg=" 		+ "Y";
							
					//체크완료되면 상태값이 R이기 때문에 전체를 넘긴다.
	  				var sParamSheet1 = sheetObj.GetSaveString(true);
	  				if (sParamSheet1 != "") {
	  					sParam = sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	  				}
	  					  				
	  				var sXml = sheetObj.GetSaveXml("ESM_PRI_3522GS.do", sParam);
	  				sheetObj.LoadSaveXml(sXml);	
					
	  				////////////////////////////////////////////////////// 
	  				window.returnValue = true;
	  				window.close();
	 				break;
	 								
	        	case IBLOADEXCEL:
		        	if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
		        	}
		        	
		        	ComOpenWait(true);
		        	if (!ComShowCodeConfirm("PRI06011")) {
						return false;
					}
		        	        	
		        	sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
		        	sheetObj.CheckAll("chk") = 0;
		        	//엑셀업로드시에는 n1st_cmnc_amdt_seq 데이터가 없기때문임.
	        		changeSelectBackColor(sheetObj, document.form.amdt_seq.value, document.form.amdt_seq.value);
		        	
	        		//콤보 체크시 사용하기 위함
		    		sheetObj.Redraw = false;
		        	for ( var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
		        		if(formObj.amdt_seq.value > 0) {
		        			sheetObj.RowFontColor(i) =  sheetObj.RgbColor(255,0,0);
		        		}
		        		 
		     			if (sheetObj.CellValue(i, "inlnd_rt_term_cd") == ""
		     					&& ComTrim(sheetObj.CellText(i, "inlnd_rt_term_cd")) != "") {
		     				sheetObj.CellValue2(i, "inlnd_rt_term_cd") = sheetObj.CellText(i, "inlnd_rt_term_cd");
		     			}

		     			if (sheetObj.CellValue(i, "prc_inlnd_rt_trsp_mod_cd") == ""
		     					&& ComTrim(sheetObj.CellText(i, "prc_inlnd_rt_trsp_mod_cd")) != "") {
		     				sheetObj.CellValue2(i, "prc_inlnd_rt_trsp_mod_cd") = sheetObj.CellText(i, "prc_inlnd_rt_trsp_mod_cd");
		     			}
		     			
		     			if (sheetObj.CellValue(i, "inlnd_rt_lmt_wgt_ut_cd") == ""
		     					&& ComTrim(sheetObj.CellText(i, "inlnd_rt_lmt_wgt_ut_cd")) != "") {
		     				sheetObj.CellValue2(i, "inlnd_rt_lmt_wgt_ut_cd") = sheetObj.CellText(i, "inlnd_rt_lmt_wgt_ut_cd");
		     			}

		     			if (sheetObj.CellValue(i, "prc_cgo_tp_cd") == ""
		     					&& ComTrim(sheetObj.CellText(i, "prc_cgo_tp_cd")) != "") {
		     				sheetObj.CellValue2(i, "prc_cgo_tp_cd") = sheetObj.CellText(i, "prc_cgo_tp_cd");
		     			}
		     			
		     			sheetObj.RowStatus(i) = "R";
		        	}
		        	sheetObj.Redraw = true;
		        	 
		        	       	
		        	//버튼 컨트롤
		     		toggleButtons("LOAD");		        	
					break;
						 					  		  
	 			case IBINSERT: // Row Add
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
					var idx = sheetObj.DataInsert();						
					sheetObj.SelectCell(idx, "inlnd_rt_bse_loc_cd");					
										
		 			if(formObj.amdt_seq.value > 0) {
		 				sheetObj.RowFontColor(idx) =  sheetObj.RgbColor(255,0,0);
		 			}
					
	    			//하이라이트처리
					changeSelectBackColor(sheetObj, document.form.amdt_seq.value, document.form.amdt_seq.value);
								
	 				break;

				case IBDELETE: // Delete
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					// 선택된 ROW 리스트/////////////////////////////////					
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}	
					chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					
					for(var i=chkArr.length-1; i >= 0; i--){
						sheetObj.RowDelete(Number(chkArr[i]), false);
					}
					
					break;						
	 		}
 		} catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		} finally {
 			 ComOpenWait(false);
 		}
 	}
 		 
	 /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2010.11.05
     */
	function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
		var colname = sheetObj.ColSaveName(Col);
 	    var formObj = document.form;
 	    
      	switch(colname)
      	{  	    		
  	    	case "inlnd_rt_bse_loc_cd":
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"
  	    			//sUrl += "f_cmd="+ SEARCH01;
  	    			sUrl += "location_cmd=L";
  	   	    	
	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = rtnVal.cd;
	  				sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm") = rtnVal.nm;
	  				sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd") = rtnVal.zip_cd;
	  			}
  	  			break;
  	  			
  	    	case "inlnd_rt_via_loc_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	    			//sUrl += "&f_cmd="+ SEARCH01;
	    			sUrl += "&location_cmd=L";

	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = rtnVal.cd;
	  			}
  				break;  		
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
     * @author 최성민
     * @version 2010.11.05
     */  
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
 		switch(colName)
     	{
 			case "inlnd_rt_bse_loc_cd":
 	    		if (Value.length > 1){
 	    			var sParam = "f_cmd=" + SEARCH01;
 	    				sParam += "&loc_cd=" + Value;
 	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", sParam);
 	  				
 	  				var arrData = ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
   	  				
   	  				if (arrData != null && arrData.length > 0){	   	  				
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = arrData[0][0];
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm")	= arrData[0][1];
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd")	= arrData[0][2];
					}else{
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = "";
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm")	= "";
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd")	= "";
	  					sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");
					}	  				
 	    		}else{	 
 	    			sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = "";
					sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm")	= "";
					sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd")	= "";
  					sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");		
 	    		}
 	    		break;
 	    		
 			case "inlnd_rt_via_loc_cd":	    		
 	    		if (Value.length > 1){
 	    			var sParam = "f_cmd=" + SEARCH01;
 	    				sParam += "&loc_cd=" + Value;
 	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", sParam);
 	  				
 	  				var arrData = ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
   	  				
   	  				if (arrData != null && arrData.length > 0){
						sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = arrData[0][0];
					}else{
						sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = "";
	  					sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");
					}	  				
 	    		}else{	 
 	    			sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = "";
  					sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");		
 	    		}
 	    		break;	
     	}
 	}
 	
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
   	 * @author 최성민
   	 * @version 2011.11.08
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
    		//엑셀업로드시에는 n1st_cmnc_amdt_seq 데이터가 없기때문임.
    		changeSelectBackColor(sheetObj, document.form.amdt_seq.value, document.form.amdt_seq.value);
        }
    }
     	

    /**
     * 데이터 셀에서 눌려진 키보드가 올라올 때 발생하는 Event function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {Long} Row 필수 해당 셀의 Row Index
     * @param {Long} Col 필수 해당 셀의 Column Index
     * @param {Integer} KeyCode 필수 키보드의 아스키 값
     * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @return 없음
     * @author 최성민
     * @version 2010.12.10
     */ 
     function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {    	
         if (ERR_FLG && KeyCode == 9) {
        	 searchTabCell(sheetObj, Row, Col);
         }
     }
     

     /**
      * OnLoadExcel 이벤트 발생시 호출되는 function <br>
      * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author 최성민
      * @version 2010.11.05
      */
     /*
     function sheet1_OnLoadExcel(sheetObj)  {
    	 sheetObj.Redraw = false;
    	 for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {		
 			if (sheetObj.CellValue(i, "inlnd_rt_term_cd") == ""
 					&& ComTrim(sheetObj.CellText(i, "inlnd_rt_term_cd")) != "") {
 				sheetObj.CellValue2(i, "inlnd_rt_term_cd") = sheetObj.CellText(i, "inlnd_rt_term_cd");
 			}

 			if (sheetObj.CellValue(i, "prc_inlnd_rt_trsp_mod_cd") == ""
 					&& ComTrim(sheetObj.CellText(i, "prc_inlnd_rt_trsp_mod_cd")) != "") {
 				sheetObj.CellValue2(i, "prc_inlnd_rt_trsp_mod_cd") = sheetObj.CellText(i, "prc_inlnd_rt_trsp_mod_cd");
 			}
 			
 			if (sheetObj.CellValue(i, "inlnd_rt_lmt_wgt_ut_cd") == ""
 					&& ComTrim(sheetObj.CellText(i, "inlnd_rt_lmt_wgt_ut_cd")) != "") {
 				sheetObj.CellValue2(i, "inlnd_rt_lmt_wgt_ut_cd") = sheetObj.CellText(i, "inlnd_rt_lmt_wgt_ut_cd");
 			}

 			if (sheetObj.CellValue(i, "prc_cgo_tp_cd") == ""
 					&& ComTrim(sheetObj.CellText(i, "prc_cgo_tp_cd")) != "") {
 				sheetObj.CellValue2(i, "prc_cgo_tp_cd") = sheetObj.CellText(i, "prc_cgo_tp_cd");
 			} 			
    	 }
    	 sheetObj.Redraw = true;
     }
     */
     /**
      * 엑셀 오류데이터에서 tab키로 셀을 찾아가는 function<br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {Long} Row 필수 해당 셀의 Row Index
      * @param {Long} Col 필수 해당 셀의 Column Index
      * @return 없음
      * @author 최성민
      * @version 2010.12.10
      */ 
     function searchTabCell(sheetObj, Row, Col) {    	 
    	 var Arr = TAB_DATA.split("|");
    	 var vCell = "";
    	 var sRow = 0;
    	 var sCol = 0;

    	 for(var i=0; i<Arr.length - 1; i++) {
    		 vCell = Arr[i].split(",");
    		 sRow = parseInt(vCell[0]) + sheetObj.HeaderRows;
    		 sCol = parseInt(vCell[1]);
    		 if(Row < sRow) {  
    			 if (sheetObj.CellBackColor(sRow, sCol) == sheetObj.RgbColor(255,255,0)) {
                     sheetObj.SelectCell(sRow, sCol, false);
                     break;
                 }
    		 } else if(Row == sRow && Col-1 < sCol) {
    			 if (sheetObj.CellBackColor(sRow, sCol) == sheetObj.RgbColor(255,255,0)) {
                     sheetObj.SelectCell(sRow, sCol, false);
                     break;
                 }
    		 }
    		 
    		 if(i == Arr.length - 2) {
    			 searchTabCell(sheetObj, sheetObj.HeaderRows, 1);
    		 }
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
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function validateForm(sheetObj, formObj, sAction) {

		switch (sAction) {
		case IBSEARCH: // 체크
 			if(getValidRowCount(sheetObj) < 1) {
 				return false;
 			}
			break;
		
   		case IBSAVE: 
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObjects[0], "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;

   		case IBINSERT: // Row Add
   			
 			break;

 		case IBDELETE: // Row Delete
 			
 			if(getValidRowCount(sheetObj) < 1) {
 				return false;
 			}
 			break;
 			
    	case IBLOADEXCEL:    		
 			break;
 		}

 		return true;
 	}

 	/**
 	 * Sheet의 타이틀 제목을 초기화하는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.13
 	 */
 	function initLocationSheetColumn() {
 		var formObj = document.form;
 		var inlndColNm = formObj.inlnd_col_nm.value;
 		var sheetObj = sheetObjects[0];
 		
 		sheetObj.CellText(0, 1) = inlndColNm;
 		sheetObj.CellText(0, 2) = inlndColNm;
		sheetObj.CellText(0, 3) = inlndColNm;
		sheetObj.CellText(0, 4) = inlndColNm;
		sheetObj.CellText(0, 5) = inlndColNm;
		sheetObj.CellText(0, 6) = inlndColNm;
		sheetObj.CellText(0, 7) = inlndColNm;
		sheetObj.CellText(0, 8) = inlndColNm;
		sheetObj.CellText(0, 9) = inlndColNm;
		sheetObj.CellText(0, 10) = inlndColNm;
		sheetObj.CellText(0, 11) = inlndColNm;
		sheetObj.CellText(0, 12) = inlndColNm;
		sheetObj.CellText(0, 13) = inlndColNm;
 	}
 	
 	/**
 	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param {string} mode 필수 사용자 권한이나 모드
 	 * @param {string} flag 선택 버튼 활성화 제어
   	 * @author 최성민
   	 * @version 2010.10.13
 	 */
 	function toggleButtons(flag) {
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
 		
 		try {
 			ComBtnDisable("btn_save"); 			
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowdelete");
 			ComBtnDisable("btn_loadexcel");
 			ComBtnDisable("btn_check");
 			ComBtnEnable("btn_close");
 			 			 			
 			switch (flag) {
 			case "SUCCEED":
				ComBtnEnable("btn_save");
				break;
				
			case "FAIL":
				ComBtnEnable("btn_loadexcel");
				ComBtnEnable("btn_check"); 			
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				break;
				
			case "LOAD":
				ComBtnEnable("btn_loadexcel");
				ComBtnEnable("btn_check");	
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				break;
				
			case "INIT":
				ComBtnEnable("btn_loadexcel");	
				ComBtnEnable("btn_rowadd");
				ComBtnEnable("btn_rowdelete");
				break;
				
 	 		default:
 	 			ComBtnEnable("btn_loadexcel");	
 	 			ComBtnEnable("btn_rowadd");
 	 			ComBtnEnable("btn_rowdelete");
 	 			break;
 	 		} 			
 		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
 		}
 	}
 	
   /**
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확은을 한다.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} sheetObj update date와 key를 가진 sheet object
    * @param {String} checkTpCd update date를 check해야 하는 table이 다를 수 있다 이를 구분하는 code
    *  
    * @return boolean , true : 변경된 데이터 있음, false: 변경된 데이터 없음.
    * @author 송민석
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
    	var formObj = document.form;
    	var returnValue = false;
        /////////////////////////////////////////////////////////////////////
    	
        // update date 검사
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
	        + "&key1="+formObj.trf_pfx_cd.value
	        + "&key2="+formObj.trf_no.value
	        + "&key3="+formObj.amdt_seq.value
	        + "&key4="+formObj.trf_inlnd_seq.value
	        + "&upd_dt="+formObj.upd_dt.value;
	        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }

	        //메인에 변경사항이 없으면 DETAIL정보를 조회한다.
	        if(!returnValue && sheetObjects[0].IsDataModified) {
	        	checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND_RT&page_name=Inland Rates Location"
		        + "&key1="+formObj.trf_pfx_cd.value
		        + "&key2="+formObj.trf_no.value
		        + "&key3="+formObj.amdt_seq.value
		        + "&key4="+formObj.trf_inlnd_seq.value
		        + "&upd_dt="+formObj.dtl_upd_dt.value;
		        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
		        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
		        	sheetObj.LoadSearchXml(cXml);
		        	ComOpenWait(false); //->waiting->End
		        	returnValue = true;
		        }
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
  	
   
   /**
	* Check 버튼 이벤트 발생후 호출되는 function 으로 오류데이터가 존재할경우 SHEET배경색을 노란색으로 처리한다.<br>
	* <br><b>Example :</b>
	* <pre>
	* 
	* </pre>
	* @param {ibsheet} sheetObj 필수 IBSheet Object
	* @return 없음
	* @author 최성민
	* @version 2010.11.08
	*/
	function checkValidationAllData(sheetObj) {
		var check = "";
		TAB_DATA = ""; //탭데이터초기화
		
		// 오류셀 색지정
		var color = sheetObj.RgbColor(255, 255, 0); // 노랑
	
		sheetObj.CheckAll("chk") = 0;
		clearTooltip();
		
		//중복체크 사용안함. - Hub, Depot이 존재할 경우 운임이 다를 수 있으므로 중복체크 제거
		/* 
		if (sheetObj.IsDataModified) {
			var dupRow = sheetObj.ColValueDup("inlnd_rt_bse_loc_cd|inlnd_rt_bse_loc_zip_cd|inlnd_rt_term_cd"
					+"|inlnd_rt_via_loc_cd|prc_inlnd_rt_trsp_mod_cd|inlnd_rt_min_lmt_wgt|inlnd_rt_lmt_wgt|inlnd_rt_lmt_wgt_ut_cd"
					+"|prc_cgo_tp_cd", false);
			
			if (dupRow >= 0) {
				sheetObj.CellValue2(dupRow, "chk") = "1";
				sheetObj.SelectCell(dupRow, "seq");
				ComShowCodeMessage("PRI00302");				
				return false;
			}
		}
		*/
		
		//화면에서의 validation 체크
		//check += validateSheetData(sheetObj, color);
	
		// DB에서의 validation 체크
		//check += checkDBCodeExist(sheetObj, color);
		check = checkDBCodeExist(sheetObj, color);
					
		if (check != "") {		
			TAB_DATA = check;
			ERR_FLG = "Y";
			toggleButtons("FAIL");
		} else {
			TAB_DATA = "";
			ERR_FLG = "N";
			//모든셀 readonly 처리할것
			//sheetObj.Editable = false;
			
			for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				sheetObj.RowEditable(i) = false ;
			}
			
			toggleButtons("SUCCEED");

			//엑셀파일체크시 필수입력설정을 true처리한다.
			setKeyField();			
		}
	}
	

    /**
     * 대상 ROW 를 Amend 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} Row 필수,  선택된 셀의 Row Index
     * @param {int} Col 필수,  선택된 셀의 Col Index
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.08
     */         	
	function getTabString(sheetObj, Row, Col) {
		var sCell = "";
		sCell = Row + "," + Col + "|"; 		
		return sCell;
	}
	
	/**
	 * 화면상에서의  validation 체크하는 function <br>
	 * validate 에 걸릴경우 check 값을 return 한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {object} color 필수 IBSheet RgbColor
	 * @return check
	 * @author 최성민
	 * @version 2010.11.25
	 */
	/*
	function validateSheetData(sheetObj, color) {
		var check = "";
				
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {		
			if (sheetObj.CellValue(i, "inlnd_rt_term_cd") == ""
					&& ComTrim(sheetObj.CellText(i, "inlnd_rt_term_cd")) != "") {
				add2Tooltip(i, "inlnd_rt_term_cd", ComGetMsg("PRI00315", "Term"));
				check += getTabString(sheetObj, i, 6);
			}

			if (sheetObj.CellValue(i, "prc_inlnd_rt_trsp_mod_cd") == ""
					&& ComTrim(sheetObj.CellText(i, "prc_inlnd_rt_trsp_mod_cd")) != "") {
				add2Tooltip(i, "prc_inlnd_rt_trsp_mod_cd", ComGetMsg("PRI00315", "Trans. Mode"));
				check += getTabString(sheetObj, i, 8);
			}
			
			if (sheetObj.CellValue(i, "inlnd_rt_lmt_wgt_ut_cd") == ""
					&& ComTrim(sheetObj.CellText(i, "inlnd_rt_lmt_wgt_ut_cd")) != "") {
				add2Tooltip(i, "inlnd_rt_lmt_wgt_ut_cd", ComGetMsg("PRI00315", "Weight"));
				check += getTabString(sheetObj, i, 10);
			}

			if (sheetObj.CellValue(i, "prc_cgo_tp_cd") == ""
					&& ComTrim(sheetObj.CellText(i, "prc_cgo_tp_cd")) != "") {
				add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI00315", "Type"));
				check += getTabString(sheetObj, i, 11);
			}
			
			if (sheetObj.CellValue(i, "curr_cd") == "") {
				add2Tooltip(i, "curr_cd", ComGetMsg("PRI00315", "Currency"));
				check += getTabString(sheetObj, i, 12);
			}
			
			if(sheetObj.CellValue(i, "inlnd_rt_lmt_wgt") != "" && sheetObj.CellValue(i, "inlnd_rt_lmt_wgt_ut_cd") == ""){
				add2Tooltip(i, "inlnd_rt_lmt_wgt_ut_cd", ComGetMsg("PRI00308", "input", "weight unit"));
				check += getTabString(sheetObj, i, 10);
    		}
			
			if(sheetObj.CellValue(i, "inlnd_rt_lmt_wgt") == "" && sheetObj.CellValue(i, "inlnd_rt_lmt_wgt_ut_cd") != ""){
				add2Tooltip(i, "inlnd_rt_lmt_wgt", ComGetMsg("PRI00308", "input", "weight"));
				check += getTabString(sheetObj, i, 9);
    		}
			
            //ONE WAY, ROUND TRIP 컬럼중에 최소1개는 금액이 입력되어 있어야 한다.
    		if(sheetObj.CellValue(i, "inlnd_bx_rt_amt") == "" && sheetObj.CellValue(i, "inlnd_20ft_rt_amt") == "" 
    			&& sheetObj.CellValue(i, "inlnd_40ft_rt_amt") == "" && sheetObj.CellValue(i, "inlnd_40ft_hc_rt_amt") == ""
        		&& sheetObj.CellValue(i, "inlnd_45ft_rt_amt") == "" && sheetObj.CellValue(i, "inlnd_one_wy_bx_rt_amt") == ""
            	&& sheetObj.CellValue(i, "inlnd_one_wy_20ft_rt_amt") == "" && sheetObj.CellValue(i, "inlnd_one_wy_40ft_rt_amt") == ""
               	&& sheetObj.CellValue(i, "inlnd_one_wy_40ft_hc_rt_amt") == "" && sheetObj.CellValue(i, "inlnd_one_wy_45ft_rt_amt") == "") {
    			add2Tooltip(i, "inlnd_bx_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_20ft_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_40ft_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_40ft_hc_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_45ft_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_one_wy_bx_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_one_wy_20ft_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_one_wy_40ft_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_one_wy_40ft_hc_rt_amt", ComGetMsg("PRI00308", "input","rate"));
    			add2Tooltip(i, "inlnd_one_wy_45ft_rt_amt", ComGetMsg("PRI00308", "input","rate"));

    			check += getTabString(sheetObj, i, 13);
    		}
		
		}

		return check;
	}
	*/
	
	/**
	 * 엑셀파일을 로드한후  디비조회하여 validation 하는 함수 <br>
	 * 잘못된 데이터 존재할때 색상처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 		checkDBCodeExist(sheetObj, formObj);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {object} color 필수 IBSheet RgbColor
	 * @return check
	 * @author 최성민
	 * @version 2010.11.25
	 */
	function checkDBCodeExist(sheetObj, color) {
		var formObj = document.form;
		var check = "";
		
		//ComOpenWait(true);	
		formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj);
		var sParamSheet = "";
		//에러데이터가 존재할 경우에는 에러난 Row만 체크
		//처음 에러체크는 전체 체크
		if(ERR_FLG == "Y") {
			sParamSheet = sheetObj.GetSaveString(false);
		} else {
			sParamSheet = sheetObj.GetSaveString(true);
		}
				
		
		if (sParamSheet != "") {
			sParam = ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		}

		var sXml = sheetObj.GetSearchXml("ESM_PRI_3522GS.do", sParam);
		
		var arrErr = ComPriXml2Array(sXml, "etc1|etc2|etc4|etc5|cd|nm|etc3");
		
		////////////////////////////////////////////////////
		//에러났던 Row 상태를 R 로 초기화
		var sRow = sheetObj.FindStatusRow("U|I");
        //받은 결과를 배열로 생성한다.
        var arrRow = sRow.split(";");            
        for (var idx=0; idx<arrRow.length-1; idx++) { 
        	sheetObj.RowStatus(arrRow[idx]) = "R";
        }
		////////////////////////////////////////////////////
		
		
        if (arrErr != null && arrErr.length > 0) {        	
        	for (var i = 0; i < arrErr.length; i++) {
        		
        		if(ERR_FLG == "Y") {
        			//etc3 은 sheet의 Seq 번호
        			sheetObj.RowStatus(parseInt(arrErr[i][6]) + sheetObj.HeaderRows - 1) = "U";
        			add2Tooltip(parseInt(arrErr[i][6]) + sheetObj.HeaderRows - 1, arrErr[i][1], ComGetMsg(arrErr[i][2], "input", arrErr[i][5]));
            		check += getTabString(sheetObj, parseInt(arrErr[i][6]) - 1, parseInt(arrErr[i][3]));
        		} else {
        			sheetObj.RowStatus(parseInt(arrErr[i][0]) + sheetObj.HeaderRows) = "U";
            		//메세지가 다양할경우 다시 작성할것.
            		add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows, arrErr[i][1], ComGetMsg(arrErr[i][2], "input", arrErr[i][5]));
            		check += getTabString(sheetObj, parseInt(arrErr[i][0]), parseInt(arrErr[i][3]));
        		}
        	}
        }
		return check;
	}
	
	/**
	 * 업로드된 파일을 체후한 후 설정된 툴팁, 색상을 초기화 하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @return 없음
	 * @author 최성민
	 * @version 2010.11.25
	 */	
	function clearTooltip() {
    	var sheetObj = sheetObjects[0];
    	
    	var n = sheetObj.HeaderRows+sheetObj.RowCount;
    	var m = sheetObj.LastCol;
    	var i = sheetObj.HeaderRows;
    	var j = 0;
        for (i = sheetObj.HeaderRows ; i < n; i++) {
        	if(sheetObj.RowStatus(i) == "U") {        	
	            for (j = 0 ; j <= m ; j++) {
	                if (sheetObj.ToolTipText(i, j) != "") {
		                sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
		                sheetObj.ToolTipText(i, j) = "";
		            }	
	            }
        	}
        }
	}

    /**
     * IbSheet의 Cell단위로 툴팁, 색상을 설정하는 function<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {int} Row 필수,  선택된 셀의 Row Index
     * @param {int} Col 필수,  선택된 셀의 Col Index
     * @param {string} msg 필수, 툴팁 메세지
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.08
     */   
	function add2Tooltip(row, col, msg) {
		var sheetObj = sheetObjects[0];
	
		sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,255,0);		
		sheetObj.ToolTipText(row, col) +="\n- " +  msg;
	}
	

    /**
     * 엑셀업로드로 설정된 Flag값을 초기화하는 function<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.08
     */       
	function initExcelFlag() {
		ERR_FLG = "";
		clearTooltip();
	}
	
   /**
	* SHEET  header의 필수입력여부를 설정한다.<br>
	* <br><b>Example :</b>
	* <pre>
	*    setKeyField(true);
	* </pre>
	* @return 없음
	* @author 최성민
	* @version 2010.12.10
	*/
	function setKeyField() {
		var sheetObj = sheetObjects[0];
 		var tFlag = sheetObj.ReadDataProperty(0, 3, dpKeyField);
 		
 		if(tFlag) {
 			sheetObj.InitDataProperty(0, 3, dtPopupEdit,	80,	daCenter,	true,	"inlnd_rt_bse_loc_cd",	false,	"",	dfNone,	0,	true,	true,	5);
 			//sheetObj.InitDataProperty(0, 7, dtPopupEdit,	80, daCenter, 	true,	"inlnd_rt_via_loc_cd",	false,	"",	dfNone,	0,	true,	true,	5);
 			sheetObj.InitDataProperty(0, 13,	dtCombo,	75, daCenter,	true,	"curr_cd",     			false,	"",	dfNone,	0,	true,	true);
 		}
	}	

	/* 개발자 작업  끝 */