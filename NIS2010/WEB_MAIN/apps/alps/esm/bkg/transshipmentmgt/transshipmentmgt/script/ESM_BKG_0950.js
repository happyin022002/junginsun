/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0950.js
*@FileTitle : Relay Vessel Group Assign by Relay Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
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
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_BKG_0950 : ESM_BKG_0950 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0950() {
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
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var closedVvds = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						if (validateForm(sheetObject,formObject,IBSEARCH)) {
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
						}
					break;

					case "btn_downexcel":
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					break;

					case "btn_selectall":
							//ComSetDisplay("btn_CheckAll",false);
							//ComSetDisplay("btn_UnCheckAll",true);
							CellCheckAll(sheetObjects[0],true,prefix1+"chk");
					break;

					case "btn_CheckAll":
						if (sheetObjects[0].Rows<2) return;
						ComSetDisplay("btn_CheckAll",false);
						ComSetDisplay("btn_UnCheckAll",true);
						CellCheckAll(sheetObjects[0],true,prefix1+"chk");
					break; 
					
					case "btn_UnCheckAll":
						ComSetDisplay("btn_CheckAll",true);
						ComSetDisplay("btn_UnCheckAll",false);
						CellCheckAll(sheetObjects[0],false,prefix1+"chk"); 
					break;  

					case "btn_vvdassign":
						if (CheckRowGrid(sheetObjects[0],prefix1+"chk")){ 
							var sRow =sheetObjects[0].FindCheckedRow(prefix1+ "chk"); 
						    var arrRow = sRow.split("|");
							if (arrRow.length==1){
								ComShowCodeMessage("BKG00155"); 
								return;
							} 
						    var formerFlg="";
							var nextFlg="";
                            sheetObjects[1].RemoveAll();
							sheetObjects[2].RemoveAll();
							for(var i=0;i<arrRow.length-1;i++){
								var iRow=sheetObjects[1].DataInsert(-1);
								sheetObjects[1].CellValue(iRow,prefix2+"bkg_no")=sheetObjects[0].CellValue(arrRow[i],prefix1+"bkg_no");
								sheetObjects[1].CellValue(iRow,prefix2+"pol_cd")=sheetObjects[0].CellValue(arrRow[i],prefix1+"pol_cd");
								sheetObjects[1].CellValue(iRow,prefix2+"pod_cd")=sheetObjects[0].CellValue(arrRow[i],prefix1+"pod_cd");
								sheetObjects[1].CellValue(iRow,prefix2+"former_vvd")=sheetObjects[0].CellValue(arrRow[i],prefix1+"former_vvd");
								sheetObjects[1].CellValue(iRow,prefix2+"next_vvd")=sheetObjects[0].CellValue(arrRow[i],prefix1+"next_vvd");
								sheetObjects[1].CellValue(iRow,prefix2+"rownum")=arrRow[i];
								if(sheetObjects[0].CellValue(arrRow[i],prefix1+"former_vsl_pre_pst_cd")=="T"){
									formerFlg="Y";
								}
								if(sheetObjects[0].CellValue(arrRow[i],prefix1+"next_vsl_pre_pst_cd")=="T"){
									nextFlg="Y";
								}
							}
							var param="?formerTrnkFlg="+formerFlg;
							param+="&nextTrnkFlg="+nextFlg;
							param+="&pgmNo=ESM_BKG_1015";
							ComOpenPopup("/hanjin/ESM_BKG_1015.do"+param, 320, 270, 'callback_0950', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						}
						
					break;

					case "btn_duration":
						if(formObject.btn_duration.disabled)return;
						var cal = new ComCalendarFromTo();
						cal.select(formObject.dur_from, formObject.dur_to,'yyyy-MM-dd');
					break;

					case "btn_relay":
						if(formObject.btn_relay.disabled)return;
					    var param="?pgmNo=COM_ENS_051";
						ComOpenPopup("COM_ENS_051.do"+param, 800, 440,"setPolCd", "1,0,1,1,1", false);
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
		 
		initDate(document.form);
		ComSetDisplay("btn_UnCheckAll",false);
		axon_event.addListenerFormat('keypress','bkg0950_keypress',document.form); 
		axon_event.addListenerForm  ('beforedeactivate', 'bkg0950_deactivate',  document.form);
		axon_event.addListenerFormat('beforeactivate',   'bkg0950_activate',    document.form);
		//doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
    }
	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.WaitImageVisible = false;  
		doActionIBSheet(sheetObj,document.form,COMMAND02);   
		sheetObj.WaitImageVisible = true;   
	}   

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 400;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "|No.|Sel.|BKG No.|B/L No.|POL|POD|Former VVD|Lane|ETB|Relay|Yard|Next VVD|Lane|ETD|Yard|Special|||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,     cnt++ , dtHiddenStatus,	    40,		daCenter,	true,	prefix1+"ibflag");
					InitDataProperty(0,		cnt++ , dtSeq,				40,		daCenter,		true,		prefix1+"seq");
					InitDataProperty(0,		cnt++ , dtCheckBox,			40,		daCenter,		true,		prefix1+"chk",				false,		"",		dfNone,		0,		true,		false);
					InitDataProperty(0,		cnt++ , dtData,				90,	daCenter,		true,		prefix1+"bkg_no",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				100,	daCenter,		true,		prefix1+"bl_no",			false,		"",		dfNone,		0,		false,		false);
					                                                                                
					InitDataProperty(0,		cnt++ , dtData,				70,		daCenter,		true,		prefix1+"pol_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				70,		daCenter,		true,		prefix1+"pod_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				90,	daCenter,		true,		prefix1+"former_vvd",		false,		"",		dfNone,		0,	false,		false);
					InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		prefix1+"former_slan_cd",	false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				70,		daCenter,		true,		prefix1+"etb",				false,		"",		dfDateYmd,	0,		false,		false);
					
					InitDataProperty(0,		cnt++ , dtData,				70,  	daCenter,		true,		prefix1+"relay",			false,		"",		dfNone,		0,		false,		false);																			   
					InitDataProperty(0,		cnt++ , dtData,				70,  	daCenter,		true,		prefix1+"former_yd_cd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				90,		daCenter,		true,		prefix1+"next_vvd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				50,		daCenter,		true,		prefix1+"next_slan_cd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		prefix1+"etd",				false,		"",		dfDateYmd,	0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				70,  	daCenter,		true,		prefix1+"next_yd_cd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtImageText,		60,		daCenter,		true,		prefix1+"spcl",				false,		"",		dfNone,		0,		false,		false);

					InitDataProperty(0,		cnt++ , dtHidden,			30,		daCenter,		true,		prefix1+"former_vsl_pre_pst_cd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,			30,		daCenter,		true,		prefix1+"next_vsl_pre_pst_cd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtHidden,			30,		daCenter,		true,		prefix1+"assign",		false,		"",		dfNone,		0,		false,		false);
					
					ImageList(0) = "img/btns_search.gif";
					InitDataImage(0,prefix1+"spcl",daRight);

			}
			break;

			 case "sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "|BKG No.|POL|POD|Former VVD|Next VVD|OLD VVD|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,     cnt++ , dtHiddenStatus,	    40,		daCenter,		true,		prefix2+"ibflag");
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix2+"bkg_no",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		prefix2+"pol_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		prefix2+"pod_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix2+"former_vvd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix2+"next_vvd",		    false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix2+"old_vvd",		    false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix2+"rownum",		    false,		"",		dfNone,		0,		false,		false);

			}
			break;
			case "sheet3":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

					var HeadTitle = "|BKG No.|POL|POD|Former VVD|Next VVD|OLD VVD|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,     cnt++ , dtHiddenStatus,	    40,		daCenter,		true,		prefix3+"ibflag");
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix3+"bkg_no",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		prefix3+"pol_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				80,		daCenter,		true,		prefix3+"pod_cd",			false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix3+"former_vvd",		false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix3+"next_vvd",		    false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix3+"old_vvd",		    false,		"",		dfNone,		0,		false,		false);
					InitDataProperty(0,		cnt++ , dtData,				110,	daCenter,		true,		prefix3+"rownum",		    false,		"",		dfNone,		0,		false,		false);

			}
			break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
		var arrPreFix = sheetObj.id+"_"; 
        switch(sAction) {
          case IBSEARCH:      //조회
		       formObj.f_cmd.value = SEARCH;
			   var sXml = sheetObj.GetSearchXml("ESM_BKG_0950GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			   
			   sheetObj.Redraw = false;    
			   sheetObj.LoadSearchXml(sXml);  
			   sheetObj.Redraw = true; 
			   //sheetObj.ColBackColor(14) = sheetObj.RgbColor(239,235,239);
			   for(var i = 1; i<=sheetObj.RowCount ;i++) {
				   if (!ComIsEmpty(sheetObj.CellValue(i,prefix1+"spcl"))){
						sheetObj.CellImage(i,prefix1+"spcl") = 0;
				   }
					
			   }
			   ComSetDisplay("btn_UnCheckAll",false);
			   ComClearObject(formObj.assignFlag);
			   sheetObj.SelectionMode = smSelectionList;
			   //if (sheetObj.Rows>1)sheetObj.SelectRow =1;
            break;
	 	   
		  case COMMAND02:			//Relay Port
				formObj.f_cmd.value = COMMAND02; 
				var params = FormQueryString(formObj);  
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0950GS.do", params);
				 
				 formObj.loc_cd.value=ComGetEtcData(sXml,"relayPort"); 
				 
				break;
		  case IBDOWNEXCEL:      // 엑셀다운  
			var rowSkip="";
			for(var i=1;i<sheetObj.Rows;i++){
				if (typeof(sheetObj.CellValue(i,arrPreFix+"chk").length) !="undefined"){
					if (i==sheetObj.Rows-1){
						rowSkip+=i;
					}else{
						rowSkip+=i+"|";
					}
				} 
			}
				 
			sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,arrPreFix+"chk|"+arrPreFix+"seq|",rowSkip);
			break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
        	switch (sAction) {
	    		case IBSEARCH: {
					if(ComIsEmpty(loc_cd)){
						ComShowCodeMessage("BKG00704");
						return false;
					}				
					if((ComIsEmpty(dur_from)&&ComIsEmpty(dur_to))
							&& ComIsEmpty(formerVVD)
							&& blankFormerVVD.checked == false) {
						ComShowCodeMessage("BKG00704");
						return false;
					}
					if(!ComIsEmpty(dur_from) && !ComIsEmpty(dur_to)){
						if (ComGetDaysBetween(dur_from.value, dur_to.value) > 30) {
							ComShowCodeMessage("BKG00756", "Duration", "30Days");
							dur_from.focus();
							return false;
						}
					}
					break;
	    		}
	    	}
        }
        return true;
    }
	
	/*
	* Relay Port Setting
	*/
	function setPolCd(aryPopupData) {
	   document.form.loc_cd.value = aryPopupData[0][3];
	}

	/*
	* Sheet onMouseUP 호출
	*/
   function sheet1_OnMouseUp(sheetObj,Button, Shift, X, Y){ 
	var sRowStr = sheetObj.GetSelectionRows("/");
	  var arr = sRowStr.split("/");
	  if (Shift==1){
			  for (var i=0; i<arr.length; i++) {
			  if (sheetObj.ColSaveName(sheetObj.SelectCol) !=prefix1+"chk" && sheetObj.CellValue(arr[i],prefix1+"chk")=="0"){
				sheetObj.CellValue2(arr[i],prefix1+"chk")="1";
			  }else if (sheetObj.ColSaveName(sheetObj.SelectCol) !=prefix1+"chk" && sheetObj.CellValue(arr[i],prefix1+"chk")=="1"){
				sheetObj.CellValue2(arr[i],prefix1+"chk")="0";
			 }
		  }
	  }
	  /*else{
		   if (sheetObj.ColSaveName(sheetObj.SelectCol) !=prefix1+"chk" && sheetObj.CellValue(sheetObj.SelectRow,prefix1+"chk")=="0"){
			sheetObj.CellValue2(sheetObj.SelectRow,prefix1+"chk")="1";
		}else if (sheetObj.ColSaveName(sheetObj.SelectCol) !=prefix1+"chk" && sheetObj.CellValue(sheetObj.SelectRow,prefix1+"chk")=="1"){
			sheetObj.CellValue2(sheetObj.SelectRow,prefix1+"chk")="0";
		}
	  }*/
	  
   }
   
    
	/*
	* Sheet OnClick 호출
	*/
	function sheet1_OnClick(sheetObj, row, col, value) {
		var col_name = sheetObj.ColSaveName(col);
		var formObject = document.form; 
		var param="";   
         
		if (col_name==prefix1+"spcl"){
			param="?bkg_no="+sheetObj.CellValue(row,prefix1+"bkg_no");  
			switch(sheetObj.CellValue(row,col).toUpperCase()) {
				case "DG":
					param+="&pgmNo=ESM_BKG_0200";
					ComOpenWindowCenter("ESM_BKG_0200.do"+param, "popup0200" , 1050, 500, false);
				break;
				case "RF":
					param+="&pgmNo=ESM_BKG_0055";
					ComOpenWindowCenter("ESM_BKG_0055.do"+param, "popup0055" , 1050, 500, false);
				break;
				case "AK":
					param+="&pgmNo=ESM_BKG_0498";
					ComOpenWindowCenter("ESM_BKG_0498.do"+param, "popup0498" , 1050, 580, false);
				break;
				case "BB":
					param+="&pgmNo=ESM_BKG_0106";
					ComOpenWindowCenter("ESM_BKG_0106.do"+param, "popup0106" , 1050, 580, false);
				break;

			}
		} 
		 
	}
	

	/**
      *  화면 날짜 입력폼 초기화 처리
      */
     function initDate(formObj){
    	 with(formObj){
    		 dur_from.value=ComGetDateAdd(ComGetNowInfo(),"D", -10);
    		 dur_to.value=ComGetNowInfo();
    	 }
     }

	 /*
	 * KeyPress Event 처리
	 */
    function bkg0950_keypress(){
		obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
	    }
	}

	/*
	 * Activate Event 처리
	 */
	function bkg0950_activate(){
    	//입력Validation 확인하기
    	switch(event.srcElement.name){ 
	    	case "dur_from":
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "dur_to":
	    		ComClearSeparator(event.srcElement);
    			break; 
    		default:
    			break;
    			 
    	}
    }
	/*
	 * Deactivate Event 처리
	 */
	function bkg0950_deactivate(){ 
    	switch(event.srcElement.name){ 
	    	case "dur_from":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "dur_to":
	    		ComAddSeparator(event.srcElement);
    			break; 
    		default:
    			break; 
    	}
    }
	
	/*
	* VVD Assign처리 후 CallBack처리
	*/
	function callback_0950(){
		var formObject = document.form;  
		if (!ComIsEmpty(formObject.assignFlag)){
			// T/S close by bayplan check
			if(!checkTsCloseByBayPlan()){
				return false;
			}
			
			formContrlEnabled(false);
			var State ="";
			formObject.f_cmd.value = COMMAND01; 
		    var params = FormQueryString(formObject);
			for(var iRow=1;iRow<sheetObjects[1].Rows;iRow++){
               sheetObjects[2].RemoveAll();
			   sheetObjects[1].Copy2SheetCol(sheetObjects[2],"","",iRow,iRow,-1,2);	
			   sheetObjects[0].SelectCell(sheetObjects[2].CellValue(1,prefix3+"rownum"),prefix1+"chk"); 
			   var param = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true))+"&closed_vvds="+closedVvds;
			   var sXml = sheetObjects[2].GetSaveXml("ESM_BKG_0950GS.do", param);
			   State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			   
               if(State == "S"){
				    if (ComIsEmpty(sheetObjects[0].CellValue(sheetObjects[2].CellValue(1,prefix3+"rownum"),prefix1+"assignFlag"))){
						sheetObjects[0].RowFontColor(sheetObjects[2].CellValue(1,prefix3+"rownum"))=sheetObjects[0].RgbColor(0, 051, 255);
						sheetObjects[0].CellFont("FontBold",sheetObjects[2].CellValue(1,prefix3+"rownum"),3,sheetObjects[2].CellValue(1,prefix3+"rownum"),14) = true;
						sheetObjects[0].CellValue2(sheetObjects[2].CellValue(1,prefix3+"rownum"),prefix1+"assign")="T";
				    }else{
						sheetObjects[0].RowFontColor(sheetObjects[2].CellValue(1,prefix3+"rownum"))=sheetObjects[0].RgbColor(0, 0, 0);
						sheetObjects[0].CellFont("FontBold",sheetObjects[2].CellValue(1,prefix3+"rownum"),3,sheetObjects[2].CellValue(1,prefix3+"rownum"),14) = false;
						sheetObjects[0].CellValue2(sheetObjects[2].CellValue(1,prefix3+"rownum"),prefix1+"assign")="";
					}
					
			   }else{
				    sheetObjects[2].LoadSearchXml(sXml);
					break;
			   } 
			   
			}
			
			if(State == "S"){
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
			}
			
			formContrlEnabled(true);
		}
		
	}
	/*
	* form관련 객체 제어
	*/
	function formContrlEnabled(flag){
		var objs   = document.form;  
		sheetObjects[1].Enable=flag;
		for(var i=0;i<objs.length; i++) { 
			if(objs[i].getAttribute("classid")==null){
				 try {
					switch( objs[i].getAttribute("type") ) { 
						case "text" :
							 objs[i].readOnly =!flag;
							  if (!flag){
								objs[i].style.background = "#E8E7EC";
							  }else{
								if(objs[i].name=="loc_cd" || objs[i].name=="loc_yd_cd"
								   ||objs[i].name=="dur_from"||objs[i].name=="dur_to"
								){
									objs[i].style.background = "#CCFFFD";
								}else{
									objs[i].style.background = "white";
								}
								
							  }

							 break;

						default:
					} // end switch
				} catch(err) { alert(err.message); }
			} 
		}
		
		if (flag){
			ComBtnEnable("btn_vvdassign");
			ComBtnEnable("btn_downexcel");
//			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_CheckAll");
			ComBtnEnable("btn_UnCheckAll");
			objs.btn_relay.disabled =!flag;
			objs.btn_duration.disabled =!flag;
		}else{
			ComBtnDisable("btn_vvdassign");
			ComBtnDisable("btn_downexcel");
//			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_CheckAll");
			ComBtnDisable("btn_UnCheckAll");
			objs.btn_relay.disabled =flag;
			objs.btn_duration.disabled =flag;
			 
		}
	}


	function checkTsCloseByBayPlan(){
		var formObj = document.form;
		closedVvds = "";
			
		var param = "f_cmd="+SEARCH01+"&assignFlag="+ComGetObjValue(formObj.assignFlag)+"&ibflag=R"
				+ "&new_vvd="+ComGetObjValue(formObj.newVvd);
		for(var iRow=1;iRow<sheetObjects[1].Rows;iRow++){
			param = param + "&bkg_no="+sheetObjects[1].CellValue(iRow,prefix2+"bkg_no")
			 if (ComGetObjValue(formObj.assignFlag) == "F"){ 
				 param = param + "&former_vvd="+sheetObjects[1].CellValue(iRow,prefix2+"old_vvd");	
			 }else if (ComGetObjValue(formObj.assignFlag) == "N"){ 
				 param = param + "&next_vvd="+sheetObjects[1].CellValue(iRow,prefix2+"old_vvd");		 
			 }
		}
				
		ComOpenWait(true);
		var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_1157GS.do?"+param);
		ComOpenWait(false);		

		closedVvds = ComGetEtcData(sXml, "closedVvds");
		if(closedVvds != null && closedVvds.length > 0){
			ComShowCodeMessage("BKG08253",closedVvds);
		}
		return true;
	}
	/* 개발자 작업  끝 */