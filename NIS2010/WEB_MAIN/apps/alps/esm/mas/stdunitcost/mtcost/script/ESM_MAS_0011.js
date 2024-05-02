/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0011.js
*@FileTitle : EQ Repo Cost Route별 Detail Movement 조회
*Open Issues :
*Change history : 
*@LastModifyDate : 2013.07.09
*@LastModifier : KIM SUJUNG
*@LastVersion : 
* 1.0 최초 생성 
* Change history : 
=========================================================*/ 
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCH=3;
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
     * @class ESM_MAS_0011 : ESM_MAS_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0011() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo 				= initCombo;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.reSearch   			= reSearch;
    	this.changeSearchSheet 		= changeSearchSheet;
    	this.settingHiddenDate 		= settingHiddenDate;
    }

    
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
	var curTab = 1;
	var beforetab = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array(); // IB Combo 쓰기 위해서 변수 선언 
	var comboCnt = 0;
	var loadingMode = false;
  
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				 ComShowCodeMessage(OBJECT_ERROR);
			} else {
				 ComShowCodeMessage(e);
			}
		}
	}


	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(fromEcc) {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode = true;
    	
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		// 멀티콤보 처리
		// ---------------------------------------------
		for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
		loadingMode = false;
	}	
  	

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		var cnt = 0;
  		switch(sheetNo) {
  			case 1:	//sheet1 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(20) ;
  					
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(47, 6, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					
  					if(document.form.f_cost_loc_grp_cd.value == "Y")
  						var HeadTitle = "ECC_CD|ORI_DEST|TP/SZ|LAST YARD\nWITHIN CONTI|LAST MVMT\nWITHIN CONTI|Q'TY|%|FROM|TO|SEQ|YARD1|YARD2|YARD3|YARD4|YARD5|YARD6|YARD7|YARD8|YARD9|YARD10|Node\nCost1|Node\nCost2|Node\nCost3|Node\nCost4|Node\nCost5|Node\nCost6|Node\nCost7|Node\nCost8|Node\nCost9|Node\nCost10|Link\nCost1|Link\nCost2|Link\nCost3|Link\nCost4|Link\nCost5|Link\nCost6|Link\nCost7|Link\nCost8|Link\nCost9|Link\nCost10|STV U/C|TRS U/C|TTL U/C|STV AMT|TRS AMT|TTL AMT||";
  					else
  						var HeadTitle = "ECC_CD|ORI_DEST|TP/SZ|LAST LOC\nWITHIN CONTI|LAST MVMT\nWITHIN CONTI|Q'TY|%|FROM|TO|SEQ|LOC1|LOC2|LOC3|LOC4|LOC5|LOC6|LOC7|LOC8|LOC9|LOC10|Node\nCost1|Node\nCost2|Node\nCost3|Node\nCost4|Node\nCost5|Node\nCost6|Node\nCost7|Node\nCost8|Node\nCost9|Node\nCost10|Link\nCost1|Link\nCost2|Link\nCost3|Link\nCost4|Link\nCost5|Link\nCost6|Link\nCost7|Link\nCost8|Link\nCost9|Link\nCost10|STV U/C|TRS U/C|TTL U/C|STV AMT|TRS AMT|TTL AMT||";
  						
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"ecc_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"ori_dest_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");

  					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"lst_yd_in_conti");
  					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"lst_mvmt_in_conti");
  					InitDataProperty(0, cnt++ , dtData,		50,	daRight,	true,	"ttl_cntr_qty");
  					InitDataProperty(0, cnt++ , dtData,		50,	daRight,	true,	"ttl_cntr_rt",	false,"",dfFloat,	2);
  					
  					
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"n1st_yd_cd");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"lst_yd_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"rout_seq");
  					
  					// Yard
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd1");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd2");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd3");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd4");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd5");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd6");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd7");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd8");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"yd_cd9");
  					InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"yd_cd10");
  					
  					// Stvg Unit Cost
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt1",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt2",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt3",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt4",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt5",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt6",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt7",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt8",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt9",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_ttl_amt10",   false,"",dfFloat,	2);
  					                                                                                
  					// Trans Unit Cost                                                               
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt1",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt2",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt3",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt4",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt5",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt6",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt7",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt8",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt9",	false,"",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_ttl_amt10",   false,"",dfFloat,	2);
  					
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve",	false,"|mty_stvg_ttl_amt1|+|mty_stvg_ttl_amt2|+|mty_stvg_ttl_amt3|+|mty_stvg_ttl_amt4|+|mty_stvg_ttl_amt5|+|mty_stvg_ttl_amt6|+|mty_stvg_ttl_amt7|+|mty_stvg_ttl_amt8|+|mty_stvg_ttl_amt9|+|mty_stvg_ttl_amt10|",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans",	false,"|mty_trsp_ttl_amt1|+|mty_trsp_ttl_amt2|+|mty_trsp_ttl_amt3|+|mty_trsp_ttl_amt4|+|mty_trsp_ttl_amt5|+|mty_trsp_ttl_amt6|+|mty_trsp_ttl_amt7|+|mty_trsp_ttl_amt8|+|mty_trsp_ttl_amt9|+|mty_trsp_ttl_amt10|",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"ttl_uc_amt",	false,"|calcu_steve|+|calcu_trans|",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve_ttl",	false,"(|mty_stvg_ttl_amt1|+|mty_stvg_ttl_amt2|+|mty_stvg_ttl_amt3|+|mty_stvg_ttl_amt4|+|mty_stvg_ttl_amt5|+|mty_stvg_ttl_amt6|+|mty_stvg_ttl_amt7|+|mty_stvg_ttl_amt8|+|mty_stvg_ttl_amt9|+|mty_stvg_ttl_amt10|) * |ttl_cntr_qty|",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans_ttl",	false,"(|mty_trsp_ttl_amt1|+|mty_trsp_ttl_amt2|+|mty_trsp_ttl_amt3|+|mty_trsp_ttl_amt4|+|mty_trsp_ttl_amt5|+|mty_trsp_ttl_amt6|+|mty_trsp_ttl_amt7|+|mty_trsp_ttl_amt8|+|mty_trsp_ttl_amt9|+|mty_trsp_ttl_amt10|) * |ttl_cntr_qty|",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"ttl_amt",	false,"|calcu_steve_ttl|+|calcu_trans_ttl|",dfFloat,	2);
  					InitDataProperty(0, cnt++ , dtHidden,	90,	daRight,	true,	"mty_ttl_uc_amt");
  					
  				}
  				break;

  		}
  	}
  	
  	/**
     * 콤보 항목을 설정한다. by.yjjeon
     */
    function initCombo (comboObj, comboNo) {
        with (comboObj) {
            SetColAlign("left");
            SetColWidth("40");
 			ValidChar(2, 1);	//영문만 입력
            InsertItem(0,  "", " ");                  
            sfirstText = Text;
            //UseEdit=true;
            DropHeight = 300; 
            Text = "";                    
        }
    }

    /**
  	 * IBSheet Object를 배열로 등록
  	 * comSheetObject(id)에서 호출한다
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  	}
  	
  	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의 by.yjjeon
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }	

  	/**
  	* Sheet관련 프로세스 처리 MT ECC
  	*/
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0011GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_ecc_cd, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_cntr_tpsz_cd, "code", "code");
				
				ComOpenWait(false);
				break;
				
  			case IBSEARCH:	//조회
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  				// 업무처리중 버튼사용 금지 처리
  				sheetObj.WaitImageVisible = false;
  				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				
				sheetObj.DoSearch4Post("ESM_MAS_0011GS.do", masFormQueryString(formObj));
  				ComOpenWait(false);
  				
  				//Qty의 Sum 값과 각 Node, Link Amount 의 Sum에서 Qty의 Sum으로 나눈값 세팅
  				sheetObj.ShowSubSum(0, "5", 1, false, false, -1, "0= ");  				
  				sheetObj.CellValue2(1,"ttl_uc_amt") = sheetObj.CellValue(2,"mty_ttl_uc_amt");
  				
				break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
  				var excelType = selectDownExcelMethod(sheetObj);
  				switch (excelType) {
  					case "AY":
  						sheetObj.Down2Excel(0, false, false, true);
  						break;
  					case "DY":
  						sheetObj.Down2Excel(-1, false, false, true);
  						break;
  					case "AN":
  						sheetObj.SpeedDown2Excel(0, false, false);
  						break;
  					case "DN":
  						sheetObj.SpeedDown2Excel(-1, false, false);
  						break;
  				}

  				break;

  		}

  	}

     /**
  	 * 화면 조회값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		if(formObj.f_cost_yrmon.value == "") {
  			ComShowCodeMessage('MAS10002', 'YYYY-MM');
  			ComSetFocus(formObj.f_cost_yrmon);
  			return false;	
  		}
  		
  		if (formObj.f_ecc_cd.Text == ""){
  			ComShowCodeMessage('MAS10002', 'ECC Code');
  			ComSetFocus(formObj.f_cost_yrmon);			
  			formObj.f_ecc_cd.focus();			
  			return false;
  		}
  		
  		if (formObj.f_cntr_tpsz_cd.Text == ""){
  			ComShowCodeMessage('MAS10002', 'Type/Size');
  			ComSetFocus(formObj.f_cost_yrmon);			
  			formObj.f_cntr_tpsz_cd.focus();			
  			return false;
  		}
  		
  		if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
  			ComShowCodeMessage('COM12180');
  			ComSetFocus(formObj.f_cost_yrmon);
  			return false;	
  		} else {
  				return true;
  		}
  		
  		return true;
  	}

  	/**
  	 * origin/dest radio 버튼 클릭 시
  	 */
  	function reSearch(){		
  		var formObject = document.form;
  		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
  	}
  	
  	/**
  	 * Yard/Location 변경 시
  	 */
  	function reSearch1(){		
  		var formObject = document.form;
  		initSheet(sheetObjects[0], 1);
  		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
  	}
  	
  	/**
  	* keyEnter를 눌렀을때 쉬트 Retrieve
  	*/
  	function changeSearchSheet(){

  		if(event.keyCode == 13){
  		   var fObj = document.form;
		   doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
  		}
  	}
  	
  	/**
  	 * 쉬트의 Hidden 값에 대한 처리
   	 */
  	function settingHiddenDate(divname){
  		var ym = document.form.f_cost_yrmon.value;
  		ym = ym.replace(/\/|\-|\./g,"");
  		var year	= ym.substring(0,4);
  		var month = ym.substring(4,6);
  		y = ComParseInt(year);
  		m = ComParseInt(month);
  		if(m>=3){	m = m-2;}
  		else {//전년도로 변화
  			y = y-1;
  			if(m==1) m=11;
  			else if(m==2) m=12;
  		}

  		year = y + '';
  		if(m<10) month = '0' + m;
  		else month = m + '';
  		var tmp = year + month + ' ~ ' + ym;
  		document.getElementById(divname).innerHTML = "" + tmp;
  	}
  	

 	function setPeriod(obj){
  		
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];

  		if(obj == null){
            return;
        }
  		
  		if(obj.value == ""){
            if(obj.name == "f_cost_yrmon" ){
                formObj.f_cost_yrmon.value = "";
            } 
            document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
            return false;
        } else {
            if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
            	document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
            	return false;	
            }
        }
  		
  		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0011GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");

		if (0<arrXml.length) {
			document.getElementById("div_period").innerHTML = "( "+ComGetEtcData(arrXml[0], "period") +" )";
		}
		
		if (ComGetEtcData(arrXml[0], "period") == ""){
			document.getElementById("div_period").innerHTML = "( YYYY-MM ~ YYYY-MM )";
		}
	}
 	
 	/**
 	 * SearchEnd
 	 * 
 	 * Within Conti 선택 시 From/To/Seq 항목 숨김처리
 	 * @param sheetObj
 	 * @param errMsg
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		
 		if(formObj.f_excl_sts[0].checked){
			sheetObj.ColHidden("n1st_yd_cd")= true;
			sheetObj.ColHidden("lst_yd_cd") = true;
 			sheetObj.ColHidden("rout_seq")  = true;
 		}else{
			sheetObj.ColHidden("n1st_yd_cd")= false;
			sheetObj.ColHidden("lst_yd_cd") = false;
 			sheetObj.ColHidden("rout_seq")  = false;
 		}
 	}
