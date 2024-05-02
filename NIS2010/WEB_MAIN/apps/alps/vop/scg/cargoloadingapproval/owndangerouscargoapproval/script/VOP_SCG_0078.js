/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0078.js
*@FileTitle : Time of SPCL CGO Request APVL
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.12.14 김현욱
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
     * @class vop_scg_0023 : vop_scg_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0023() {
    	this.processButtonClick      = processButtonClick;
    	this.setCarrierForm          = setCarrierForm;
    	this.setSheetObject          = setSheetObject;
    	this.loadPage                = loadPage;
    	this.btnEnabled              = btnEnabled;
    	this.sheet1_OnLoadFinish     = sheet1_OnLoadFinish;
    	this.sheet1_OnSearchEnd      = sheet1_OnSearchEnd;
    	this.sheet1_OnDblClick       = sheet1_OnDblClick;
    	this.rgn_shp_opr_cd_OnChange = rgn_shp_opr_cd_OnChange;
    	this.initSheet               = initSheet;
    	this.initControl             = initControl;
    	this.obj_focus               = obj_focus;
    	this.obj_focusout            = obj_focusout;
    	this.obj_keypress            = obj_keypress;
    	this.obj_keyup               = obj_keyup;
    	this.obj_nextfocus           = obj_nextfocus;
    	this.obj_change              = obj_change;
    	this.doActionIBSheet         = doActionIBSheet;
    	this.doActionIBCombo         = doActionIBCombo;
    	this.searchLaneCheck         = searchLaneCheck;
    	this.searchVVDCheck          = searchVVDCheck;
    	this.searchCarrierCheck      = searchCarrierCheck;
    	this.setComboObject          = setComboObject;
    	this.initCombo               = initCombo;
    	this.addComboItem            = addComboItem;
    	this.validateForm            = validateForm;
    	this.onPopupClick            = onPopupClick;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt     = 0;
    
    var comboObjects = new Array();
	var comboCnt     = 0;
	
	var cgoTypeStrs  = "DG,RF,AK,BB";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var formObj  = document.form;
        var sheetObj = sheetObjects[0];

    	try {    		
    		var eventObj = window.event.srcElement;
    		var srcName  = eventObj.getAttribute("name");

            switch(srcName) {

                case "btn_retrive":
                	doActionIBSheet(sheetObj,formObj,IBSEARCH);                	
                    break;

                case "btn_new":                	
                	ComResetAll();         
                	comboObjects[0].Index = 0;
                	ComSetFocus(formObj.rgn_shp_opr_cd);   
                    setRqtDateForm(formObj, true, "fromto");
        			document.all.crr_cd[2].value = "";                    
                    btnEnabled(sheetObj, false, 2);                	
                    break;
                    
                case "btn_Detail":
                	doActionIBSheet(sheetObjects[1],formObj,IBDOWNEXCEL);                	
                	break;

                case "btn_downExcel":
                    var paramObj = new Object();
                    paramObj.title = "Time of SPCL CGO Request APVL";
                    var url = ComScgGetPgmTitle(sheetObj, paramObj);  
                    sheetObj.SpeedDown2Excel(-1, false, false, "", url, false, false, "", false, "", "", false, "", true );
//                	sheetObj.SpeedDown2Excel(-1,false,false,"","",false,false,"Time of SPCL CGO Request APVL",false,"");                 	
                    break;
                    
                case "btn_SlanCd":
	 				onPopupClick(srcName, "Lane");
	 				break;
	 				
                case "btn_VVDpop":
	 				onPopupClick(srcName, "VVD");
	 				break;
	 				
//                case "btn_Carrier":
//                	if(document.all.crr_cd[2].checked) onPopupClick(srcName, "Carrier");
//	 				break;
	 				
                case "btn_Calendar":
                	var cal = new ComCalendarFromTo();                	
                	cal.select(formObj.from_rqst_dt, formObj.to_rqst_dt, 'yyyy-MM-dd');	                
	 				break;
	 				
//                case "crr_cd":	
//                	setCarrierForm();                	
//					break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    //VSL OPR 입력폼 조정
//    function setCarrierForm() {
//    	var cgoOprCdObj = document.getElementById("cgo_opr_cd");
//    	var carBtnObj   = document.getElementById("btn_Carrier");
//		if(document.all.crr_cd[2].checked) {
//			cgoOprCdObj.disabled  = false;
//			cgoOprCdObj.className = "input1";			
//			cgoOprCdObj.setAttribute("required", "true");
//			carBtnObj.className   = "cursor";
//			ComSetFocus(cgoOprCdObj);
//		} else {
//			cgoOprCdObj.disabled  = true;
//			cgoOprCdObj.className = "input2";			
//			cgoOprCdObj.removeAttribute("required");
//			carBtnObj.className   = "";
//		}
//    }
    
    //Period 입력폼 조정
    function setRqtDateForm(formObj, what, how) {
    	var form
    	if(what) {
    		if(how.indexOf("from") != -1) ComAddSeparator(formObj.from_rqst_dt);
    		if(how.indexOf("to") != -1) ComAddSeparator(formObj.to_rqst_dt);
    	} else {
    		if(how.indexOf("from") != -1) ComClearSeparator(formObj.from_rqst_dt);
    		if(how.indexOf("to") != -1) ComClearSeparator(formObj.to_rqst_dt);
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {    	
        for(i=0;i<sheetObjects.length;i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1,cgoTypeStrs);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
			
        }
        
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
       	 	initCombo(comboObjects[k], k + 1);
        }
        
        initControl();
        
        setRqtDateForm(document.form, true, "fromto");
        
//        setCarrierForm();
    }
     
    /**
     * 버튼 비/활성화
     */
    function btnEnabled(sheetObj, what, kind) {
    	with(sheetObj) {    		
	      	//Enable = what;
	      	if(what) {
	      		if(RowCount != 0) {
		      		ComBtnEnable("btn_downExcel");
		      		if(kind > 0) ComBtnEnable("btn_Detail");
		      		else ComBtnDisable("btn_Detail");
	      		}
	      	} else {
		      	ComBtnDisable("btn_downExcel");
		      	if(kind > 0) ComBtnDisable("btn_Detail");
	      	}
    	}
    }
    
    /**
     * sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function sheet1_OnLoadFinish(sheetObj) {	
    	 btnEnabled(sheetObj, false, 2);
    	 
    	 doActionIBCombo(comboObjects[0], 1);
    }
     
    /**
     * sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
         with (sheetObj) {	
 			if(RowCount != 0) {	
 				//1. 부분소계를 위한 RSO 더미필드의 값을 셋팅한다.
 				var preRgnShpOprCd = "";
 				var subSumYn       = false;
 				for(var rowCt=HeaderRows; rowCt<=LastRow; rowCt++) { 					
 					CellValue2(rowCt, "subSumCol3") = CellValue(rowCt, "rgn_shp_opr_cd");
 					if(preRgnShpOprCd == CellValue(rowCt, "rgn_shp_opr_cd")) subSumYn = true;
 					preRgnShpOprCd = CellValue(rowCt, "rgn_shp_opr_cd"); 
 				}
 				
 				//2. 소계를 적용할 필드와 계산된 비율을 적용할 필드들을 구성한다.
 				var sumStr = "", ratioStr = "", colNm = "", splitStr = "";
 				for(var colCt=SaveNameCol("term")+1; colCt<=LastCol; colCt++) {
 					colNm = ColSaveName(colCt);
 					splitStr = colNm.split("_");
 					
 					sumStr += colCt;
 	 				if(splitStr[0] != 'o') {
 	 					
 	 					if(colNm != 'avg_dg' && colNm != 'avg_rf' && colNm != 'avg_ak' && colNm != 'avg_bb' && colNm != 'tot_avg' && colNm != '') {
	 							ratioStr += colNm+"=((|o_"+colNm+"|/|o_t_"+splitStr[1]+"|)*100);";
	 					}else{
	 						// 각 DG, RF, AK, BB, Total AVG HRS인 경우에는 100으로 셋팅.
	 						ratioStr += colNm+"=100;";
	 					}
 					} 
 	 				
 					if(colCt != LastCol) sumStr += "|";
 				}
 				
 				//3. 전체 소계와 비율 행을 구성한다.
 				ShowSubSum("subSumCol1", sumStr, 2, false, false, SaveNameCol("term"), "term=Grand TTL");
 				ShowSubSum("subSumCol2", sumStr, 2, false, false, SaveNameCol("term"), "term=G.TTL Ratio(%);"+ratioStr);
 				
 				//4. 부분 소계와 비율 행을 구성한다.
 				if(subSumYn) {
	 				ShowSubSum("rgn_shp_opr_cd", sumStr, -1, false, false, SaveNameCol("term"), "term=S. TTL Ratio;"+ratioStr); 
	 				ShowSubSum("subSumCol3", sumStr, -1, false, false, SaveNameCol("term"), "term=Sub TTL");
 				}
 				
 				CellFont("FontBold", HeaderRows, 0, LastRow, 4) = true;
 				
 				//5. 전체 요청건수에 따라 상세목록 버튼을 조정한다.
 				//var detailCtRow = FindSubSumRow("subSumCol1").split("|")[0];
 				var detailCt = CellValue(LastRow-1 , "t_total");
  				btnEnabled(sheetObj, true, detailCt);
  			} else {
  				btnEnabled(sheetObj, false, 2);
  			}
    	 }
    }
 	
 	/**
     * sheet1 OnChange Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     */
 	function sheet1_OnDblClick(sheetObj, Row, Col, Value){	
    	with(sheetObj) {
    		//구현
      	}
 		return;
 	}
     
    /**
     * Combo 선택시 이벤트 관련
     * 포커스 이동
     */
    function scg_flg_OnCheckClick(comboObj, s_index, s_code) {    	 
         if(s_index == 0) {
     		for(var i=1; i<comboObj.GetCount(); i++) {
     			comboObj.CheckIndex(i) = comboObj.CheckIndex(s_index); 
        	}
     		if(!comboObj.CheckIndex(s_index)) comboObj.CheckIndex(1) = true;
     		else comboObj.Text = "All";
         } else {
        	var allChk   = true;
        	var allUnChk = true;
        	for(var i=1; i<comboObj.GetCount(); i++) {
        		if(!comboObj.CheckIndex(i)) allChk = false;
        		if(comboObj.CheckIndex(i)) allUnChk = false;
        	}
        	if(allChk) {
        		comboObj.CheckIndex(0) = true;
        		comboObj.Text = "All";
        	} else {
        		comboObj.CheckIndex(0) = false;
        		if(allUnChk) comboObj.CheckIndex(1) = true;
        	}
         }
    }
     
    /**
     * Combo 선택시 이벤트 관련
     * 포커스 이동
     */
    function rgn_shp_opr_cd_OnChange(comboObj , Index_Code, Text) {
          if(Text != '') ComSetFocus(document.form.option_pending[0]);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo, cgoType) {
        var cnt   = 0;
        var shtID = sheetObj.id;
        switch(shtID) {
        	case "sheet1":      
        		with (sheetObj) {
                    //높이 설정
        			style.height = 368;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false,false);
                    
                    //1. Cargo 타입 구성
                    cgoType = ComTrim(cgoType);
                    var cTarr = cgoType.split(",");
                    if(cTarr.length<=1) cTarr = cgoType.split("|");
                    var cTarrSize = cTarr.length;

                    //2. 동적 헤더 구성
                    var procHour = ComGetObjValue(document.form.proc_hour);
                    var HeadTitle1 = "|||Term";
                    for(var hCt1=0; hCt1<cTarrSize; hCt1++) {
                    	cgoType = cTarr[hCt1];
                    	HeadTitle1 += "||||"+cgoType+"|"+cgoType+"|"+cgoType+"|"+cgoType;
                    }
                    HeadTitle1 += "||||Total|Total|Total|Total";

                    var HeadTitle2 = "|||Term";
                    for(var hCt2=0; hCt2<cTarrSize; hCt2++) {
                    	HeadTitle2 += "||||TTL No.\nof Requested|Processing Time\n(within "+procHour+" hrs)|Processing Time\n(over "+procHour+" hrs)|AVG HRS";  
                    }
                    HeadTitle2 += "||||TTL No.\nof Requested|Processing Time\n(within "+procHour+" hrs)|Processing Time\n(over "+procHour+" hrs)|AVG HRS";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,     "subSumCol1",     	    false,          "1",     dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,     "subSumCol2",     	    false,          "1",     dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,     "subSumCol3",     	    false,          "",      dfNone ,      0,      false,     false);
                    //InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,     "rgn_shp_opr_cd",     	false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  true,     "term",     			false,          "",      dfNone ,      0,      false,     false);
					
                    //3. 동적 컬럼 구성                    
                    for(var cCt=0; cCt<cTarrSize; cCt++) {
                    	cgoType = cTarr[cCt].toLowerCase();
                    	
                    	InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_t_"+cgoType,     	false,          "|t_"+cgoType+"|",  	 dfInteger ,      0,      false,     false);
                    	InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_in_"+cgoType,     	false,          "|in_"+cgoType+"|",   	 dfInteger ,      0,      false,     false);
						InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_out_"+cgoType,     	false,          "|out_"+cgoType+"|",     dfInteger ,      0,      false,     false);
                    	InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "t_"+cgoType,     		false,          "",      				 dfInteger ,      0,      false,     false);
						InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "in_"+cgoType,     		false,          "",      				 dfInteger ,      0,      false,     false);
						InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "out_"+cgoType,     	false,          "",      				 dfInteger ,      0,      false,     false);
						InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "avg_"+cgoType,     	false,          "",      				 dfFloat   ,      1,      false,     false);
                    }
                    
                    var rTSumS1 = "";
                    var rTSumS2 = "";
                    var rISumS1  = "";
                    var rISumS2  = "";
                    var rOSumS1  = "";
                    var rOSumS2  = "";
                    var rOSumS3  = "";
                    for(var colCt=SaveNameCol("term"); colCt<LastCol;) {
	                    	rTSumS1  += "|"+ColSaveName(++colCt)+"|+";                    	
	                        rISumS1  += "|"+ColSaveName(++colCt)+"|+";
	                        rOSumS1  += "|"+ColSaveName(++colCt)+"|+";
	                        rTSumS2  += "|"+ColSaveName(++colCt)+"|+";
	                        rISumS2  += "|"+ColSaveName(++colCt)+"|+";
	                        rOSumS2  += "|"+ColSaveName(++colCt)+"|+";
	                        rOSumS3  += "|"+ColSaveName(++colCt)+"|";
	                        if(colCt != LastCol) rOSumS2 += "+";
                    }
                    
					InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_t_total",     		false,          rTSumS1,     dfInteger ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_in_total",     		false,          rISumS1,     dfInteger ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtHidden,      	100,   daRight,   true,     "o_out_total",     		false,          rOSumS1,     dfInteger ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "t_total",     			false,          rTSumS2,     dfInteger ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "in_total",     		false,          rISumS2,     dfInteger ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "out_total",     		false,          rOSumS2,     dfInteger ,      0,      false,     false);
					InitDataProperty(0, cnt++ , dtData,      	100,   daRight,   true,     "tot_avg",     			false,          "",     	 dfFloat   ,      1,      false,     false);
		
                }
                break;
                
            case "sheet2":      
                with (sheetObj) {
                    //높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 50);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, true, false,false);

                    var HeadTitle = "No|Lane|VVD|Pre/Trunk/Post|BKG No.|Type|REQ Seq|REQ Date|REQ ID|APVL IND|APVL Date|APVL ID|Time(hrs)";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN	=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,  true,     "no",     	    		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,     "slan_cd",     			false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "vvd_cd",     			false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "vsl_pre_pst_nm",     	false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "bkg_no",     			false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "spcl_cgo_cate_cd",       false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "spcl_cgo_apro_rqst_seq", false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "rqst_dt",     			false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "rqst_usr_id",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "auth_flg",     			false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "auth_dt",     			false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "auth_usr_id",     		false,          "",      dfNone ,      0,      false,     false);
                    InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "tret_gap",     	    	false,          "",      dfNone ,      0,      false,     false);
                    
                }
                break;
        }
    }
     
    // 이벤트 Catch Listener
    function initControl() {
         // Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
         axon_event.addListenerFormat ('focus',    'obj_focus',      form);
         axon_event.addListenerFormat ('blur',     'obj_focusout',   form);
         axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
         axon_event.addListener       ('keydown',  'ComKeyEnter',   'form');
         axon_event.addListenerForm   ('change',   'obj_change', 	 form);
    }
    
    // 업무 자바스크립트 OnFocus 이벤트 처리
    function obj_focus() {
    	switch(event.srcElement.name){ 
	    	case "from_rqst_dt": case "to_rqst_dt":	
	    		ComClearSeparator(event.srcElement);
	        	break;
    	}
    }
    
    // 업무 자바스크립트 OnFocusOut 이벤트 처리
    function obj_focusout() {
    	pastEventNum = 0;
    	var formObj = document.form;
    	with(event.srcElement) {
	    	switch(name) {
		    	case "slan_cd":
		    		searchLaneCheck();						//Lane Check
		        	break;
		    	case "skd_dir_cd":	
		    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
		    			searchVVDCheck();					//VVD Check
		    		}
		        	break;
//		    	case "cgo_opr_cd":
//		    		searchCarrierCheck(event.srcElement);	//Carrier Check
//		        	break;
		    	case "from_rqst_dt":	case "to_rqst_dt":	
		    		ComAddSeparator(event.srcElement);
		    		
		    		//조회기간 제약
		    		var fromDt = ComGetObjValue(formObj.from_rqst_dt);
		    		var toDt   = ComGetObjValue(formObj.to_rqst_dt);
		    		if(fromDt != '' && toDt != '') {
		    			if(ComGetDaysBetween(fromDt, toDt) > 365) {
		    				ComShowCodeMessage('SCG50032', 'year');
		    				value = "";
		    	 			ComSetFocus(event.srcElement);
		    			}
		    		}
		        	break;
	    	}
	    }
    } 
    
    // 업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "proc_hour":	
	    	    		ComKeyOnlyNumber(event.srcElement, '.');
	    	    		if(event.keyCode == 46) {
	    	    			if(event.srcElement.value.indexOf('.') != -1 || event.srcElement.value.length == 0) event.returnValue = false;
	    	    		}
	    	        	break;
	    	    	case "slan_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	    	case "vsl_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	        	    	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
//	    	        case "cgo_opr_cd":	
//	    	        	ComKeyOnlyAlphabet('upper');
//	    	        	break;
    	    	}
    	    	break;
    	    default:
    	    	//공통기준:영문, 숫자만을 인식
    	    	ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    }  
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {
    	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
    } 
    
    // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
    function obj_nextfocus(obj) {
    	var formObj = document.form;
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		if(obj.name == 'from_rqst_dt' || obj.name == 'to_rqst_dt') {
    			//숫자만 허용 - 마우스 키업 방지용
    			if(event.keyCode >= 48 && event.keyCode <=57 ) ComSetNextFocus(obj);
	    	} else {
	    		ComSetNextFocus(obj);
	    	}
    		
    		if(obj.name == 'vsl_cd') formObj.skd_voy_no.select();
    		else if(obj.name == 'skd_voy_no') formObj.skd_dir_cd.select();
    	}
    }
    
    // 업무 자바스크립트 OnChange 이벤트 처리
    function obj_change() {
    	var formObj = document.form;
    	with(event.srcElement) {
	    	switch(name){
		    	case "vsl_cd":		
		    		ComSetObjValue(formObj.skd_voy_no, "");
	    			ComSetObjValue(formObj.skd_dir_cd, "");
		        	break;
		    	case "skd_voy_no":		
	    			ComSetObjValue(formObj.skd_dir_cd, "");
		        	break;
//		    	case "cgo_opr_cd":		
//	    			formObj.crr_cd[2].value = ComGetObjValue(formObj.cgo_opr_cd);
//		        	break;
	    	}
    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction, source) {
        sheetObj.ShowDebugMsg = false; 
        
        setRqtDateForm(formObj, false, "fromto");
        
        switch(sAction) {        
           	case IBSEARCH:      //조회    
           		if(ComGetObjValue(formObj.proc_hour) == '.') ComSetObjValue(formObj.proc_hour, '0.')
           	
           		if(!validateForm(sheetObj,formObj,sAction)) return;
           		sheetObj.RemoveAll();
           		
           		//Form the headers of sheet1
           		initSheet(sheetObj, 1, ComGetObjValue(document.all.scg_flg));
           		
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0078GS.do", FormQueryString(formObj));
				
				sheetObj.Redraw = false;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.Redraw = true;
				break;

           case IBDOWNEXCEL:        //Detail
           		//20000만건 이상일 경우 다운로드 제약
				var detailCt = sheetObjects[0].CellValue(sheetObjects[0].LastRow-1 , "t_total");
		       	if(parseInt(detailCt) > 20000) {
		       		ComShowCodeMessage('SCG50030');	//'In view of personal computer memory, possible numbers of exporting to excel will be limited to 20000.'
		       		break;
		       	} 
           	
           		formObj.f_cmd.value = SEARCH01;
	            var saveFileName = sheetObj.SaveFileDialog("ExcelDown", "book1", "C:\\","엑셀파일(*.xls)|*.xls" );
	
	            if (saveFileName == '' || saveFileName == "<USER_CANCEL>") {
	            	return;
	            } else {
	            	ComOpenWait(true);
		        	sheetObj.DoSearch4Fx("VOP_SCG_0078GS.do", FormQueryString(formObj));
		            sheetObj.SpeedDown2Excel(-1, false, false, saveFileName );
		            ComOpenWait(false);
	            }
               	break;
        }
        
		setRqtDateForm(formObj, true, "fromto");
    }
    
    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj, comboNo) {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
        sheetObj.ShowDebugMsg = false;
        
        switch(comboNo) {
	  		case 1:    
	  			formObj.f_cmd.value = SEARCH01;
	  			
	  			sheetObj.WaitImageVisible = false;
        		//var sXml = sheetObj.GetSearchXml("VOP_SCG_0034GS.do", FormQueryString(formObj));
        		sheetObj.WaitImageVisible = true;
				//ComXml2ComboItem(sXml, formObj.rgn_shp_opr_cd, "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
        		comboObj.InsertItem(0, "All", " ");
        		comboObj.Index = 0;
        		ComSetFocus(formObj.rgn_shp_opr_cd);
        		
	  			break; 
        }
    }
     
    /**
     * Lane Check
     */
    function searchLaneCheck() {
     	var formObj  = document.form;
     	var sheetObj = sheetObjects[0];
     	
     	var slan_cd  = ComGetObjValue(formObj.slan_cd);
     	
     	if(slan_cd != '') {
	     	var sParam = Array();
	 	  	sParam[0]  = "vsl_slan_cd="+slan_cd;
	 	  	sParam[3]  = "f_cmd="+SEARCH02;
	 	  	
	 	  	sheetObj.WaitImageVisible = false;
	     	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
	     	sheetObj.WaitImageVisible = true;
	
	     	var vsl_slan_cd = ComScgXml2Array(sXml, "vsl_slan_cd");
	     	
	  	   	if(vsl_slan_cd == null) {
	  	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'	  		    
	  		    ComSetFocus(formObj.slan_cd);
	  	   	}
     	}
    }
    
    /**
     * Vessel Name 조회
     */
    function searchVVDCheck() {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	var sParam = Array();
	  	sParam[0] = "vsl_cd="+ComGetObjValue(formObj.vsl_cd);
	  	sParam[1] = "skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
	  	sParam[2] = "skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
	  	sParam[3] = "f_cmd="+SEARCH05;
	  	
	  	if(sParam.join("").length > 38) {
	  		sheetObj.WaitImageVisible = false;
	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
	    	sheetObj.WaitImageVisible = true;
	
	    	var vsl_eng_nm = ComScgXml2Array(sXml, "vsl_eng_nm");
	    	
	 	   	if(vsl_eng_nm == null) {
	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	 		    
	 		    ComSetObjValue(formObj.skd_dir_cd, "");
	 		    ComSetObjValue(formObj.skd_voy_no, "");
	 		    ComSetObjValue(formObj.vsl_cd, "");
	 		    
	 		    ComSetFocus(formObj.vsl_cd);
	 	   	}
	  	}
    }
    
//    /**
//     * Carrier Validation
//     */
//    function searchCarrierCheck(obj) {
//     	var formObj  = document.form;
//     	var sheetObj = sheetObjects[0];
//     	
//     	var sParam = Array();
// 	  	sParam[0]  = "crr_cd="+obj.value;
// 	  	sParam[3]  = "f_cmd="+SEARCH01;
//
// 	  	if(sParam.join("").length > 17) {
// 	  		sheetObj.WaitImageVisible = false;
// 	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
// 	    	sheetObj.WaitImageVisible = true;
// 	
// 	    	var crrData = ComScgXml2Array(sXml, "crr_cd");
// 	      	
// 		   	if(crrData == null) {
// 			    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
// 			    
// 			    ComSetObjValue(obj, ""); 	 		    
//	 		    ComSetFocus(obj);
// 		   	} else {
// 	 	   		ComSetNextFocus(obj);
// 	 	   	}
// 	  	}
//    }
     
    /**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
     
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	switch(comboObj.id) {
    		case "rgn_shp_opr_cd":  
    			with(comboObj) {
    				SetTitle("Code|Description");
    				SetColAlign("center|left");
    				SetColWidth("50|150");
    				DropHeight = 200;
    			}
    			break;  
	  		case "term":  
	  			addComboItem(comboObj, "M|Q|H|Y", "Monthly|Quarterly|Half-Yearly|Yearly");
	  			comboObj.SetColWidth("85");
	  			comboObj.Index = 1;
	  			break;  
	  		case "scg_flg": 
	  			var aCgoType = cgoTypeStrs.split(",");
	  			comboObj.InsertItem(0, "All", cgoTypeStrs);
	  			for (var i = 1; i<=aCgoType.length; i++){
	  	     		comboObj.InsertItem(i, aCgoType[i-1], aCgoType[i-1]);    	
	  	        }
	  			comboObj.SetColWidth("50");	  			
	  			comboObj.MultiSeparator = "|";
	  			comboObj.DropHeight = 150;
	  			comboObj.MultiSelect = true;
	  			comboObj.UseAutoComplete = false;
	  			comboObj.Index = 0;
	  			
	  			break; 
	  	}
    }
     
    /**
     * Combo 채우기
     */	
    function addComboItem(comboObj, itemValStr, itemTxtStr) {
     	var itemValArr = itemValStr.split("|");
        var itemTxtArr = itemTxtStr.split("|");
     	for (var i = 0; i<itemValArr.length; i++) {
     		comboObj.InsertItem(i, itemTxtArr[i], itemValArr[i]);    	
        }	
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
    	 switch(sAction) {
	    	case IBSEARCH:
	    		//Check requirement
		    	if(ComGetObjValue(document.all.from_rqst_dt) == '') {
    	 			ComShowCodeMessage('SCG50007', 'Period');
    	 			ComSetFocus(formObj.from_rqst_dt);
    	 			return;
		    	}
		    	if(ComGetObjValue(document.all.to_rqst_dt) == '') {
    	 			ComShowCodeMessage('SCG50007', 'Period');
    	 			ComSetFocus(formObj.to_rqst_dt);
    	 			return;
		    	}
		    	
	    		//폼 개체 안에 모든 컨트롤의 Validation을 확인
		    	if(!ComChkValid(formObj, true, false, false)) 
		    		return false;
	    				    	
	    		break;
		}
	
	    return true;
    }
    
    /**
     * 조회조건에서 팝업을 클릭시
     */
    function onPopupClick(srcName, srcType){
    	if (srcType == "Lane") {
   		 	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do', 426, 470, "sheet1_vsl_slan_cd:slan_cd", "0,0", true);
   	 	} else if (srcType == "VVD") {
   	 		//VVD 선택팝업 열기					
			var vsl_cd = ComGetObjValue(document.form.vsl_cd);
        	var sUrl = "";
        	
        	if(vsl_cd == ""){
        		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
        		ComOpenPopupWithTarget(sUrl, 463, 500, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", "0,0", true);
        	}else{
        		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
        		ComOpenPopupWithTarget(sUrl, 335, 420, "skd_voy_no:skd_voy_no|skd_dir_cd:skd_dir_cd", "0,0", true);
        	}
//   	 	} else if (srcType == "Carrier") {
//	 		ComOpenPopupWithTarget('/hanjin/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 423, 450, "crr_cd:cgo_opr_cd", "0,0,1,1,1", true);
   	 	}
    }

	/* 개발자 작업  끝 */