/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0044.js
*@FileTitle : BSA Creation/Update(Yearly Plan) Creation Button Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.31
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.31 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.31 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
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
     * @class ESM_BSA_0044 : ESM_BSA_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0044() {
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
	
	var sheet_selno = ""; //현재선택된 SHEET
	
	var JOINT_OPERATING  = "";
	var SPACE_CHARTERING = "";
	
	var LOGIC_fnl_capa = "";
	var LOGIC_sub_capa  = "";
	
	var selRow = 0;
	var selValue = "";
	
	var sheet_height1 = 20; // sheet1의 height
	var sheet_height2 = 20; // sheet2의 height
	var zoomFlag1 = "close"; // Zoom Flag #1
	var zoomFlag2 = "close"; // Zoom Flag #2
	
	var first_load1 = true;  //최초 Load시만 sheet1 height 조정
	var first_load2 = true;  //최초 Load시만 sheet2 height 조정
	
	
	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		var formObj = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		

 		var sXml = formObj.sXml.value;
 		var arrXml = sXml.split("|$$|"); 		

    	formObj.txtYear.value = ComGetNowInfo("yy");
		formObj.txtFmWeek.value = ComGetEtcData(arrXml[0], "prevWeek"); 
        formObj.txtToWeek.value = ComGetEtcData(arrXml[0], "prevWeek"); 
        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		
		// 멀티콤보 처리
		loadingMode = true;
		loadCombo(arrXml);

		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode = false;
		
		//
		formObj.cobTrade.Code	= formObj.trade.value;
		formObj.cobLane.Code	= formObj.lane.value;
		formObj.cobDir.Code		= formObj.dir.value;
	}
	

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
		
			switch(srcName) {
				case "rdoOp_cd":
					if (formObject.rdoOp_cd[0].checked) { //JO 선택시
						document.getElementById("tabLayer1").style.display= "inline";
					document.getElementById("tabLayer2").style.display= "none";
					sheet_selno = formObject.rdoOp_cd[0].value; //'J'
					//doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else if (formObject.rdoOp_cd[1].checked) { //SC 선택시
						document.getElementById("tabLayer1").style.display= "none";
					document.getElementById("tabLayer2").style.display= "inline";
					sheet_selno = formObject.rdoOp_cd[1].value; //'S'
					//doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
					}
					set_Zoom();
					break;
		
				case "rdoType":
					var checkedIdx = -1;
					var obj = formObject.rdoType;
					for(var i=0; i<obj.length; i++) {
						if (obj[i].checked) {
							checkedIdx = i;
							break;
						}
					}
					if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
						sheetObject1.LeftCol = (fixCnt1-1) + splitPos1[checkedIdx];
					} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
						sheetObject2.LeftCol = (fixCnt2-1) + splitPos2[checkedIdx];
					}
					break;
				case "btn_Creation":
					doActionIBSheet(sheetObject, formObject,IBCREATE);
					break;
                    
                case "btn_Close":
                	window.close();
                	break;
			} // end switch
		} catch(e) {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	
	function loadCombo(arrXml) {
    	var formObj = document.form;
        
 		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
		if (arrXml.length > 3)
			ComXml2ComboItem(arrXml[3], formObj.cobIOC, "code", "code");
 		document.form.sXml.value="";
    }
	
	/**
	* 시트 초기설정값, 헤더 정의
	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	*/
	function initSheet(sheetObj,sheetNo) {
		var formObj = document.form;
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					if (first_load1 == true) { style.height = GetSheetHeight(sheet_height1); }
					first_load1 = false;
		
					SheetWidth = mainTable.clientWidth;
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					MergeSheet = msHeaderOnly;
		
					Editable = true;
					InitRowInfo(1, 1, 1, 100);
					InitColumnInfo(1, 0, 0, true);
					InitHeadMode(true, true, false, true, false, false);
		
					HeadTitle0 = "STS";
		
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
		
		
					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					cnt = 0;
					InitDataProperty(0, cnt++, dtStatus,  30, daCenter, true, "ibflag");

				}
				break;
		}
	}
	
	/**
	* 콤보 항목을 설정한다.
	*/
	function initCombo (comboObj, comboNo) {
		with (comboObj) {
			DropHeight = 300;
			comboObj.InsertItem(0, 'All' ,''); 
			Index = 0;
			
			switch (comboObj.id){
				case "cobTrade":
	            	MaxLength = 3;
	            	UseAutoComplete = false;
	            	ValidChar(2, 1);	//영문대문자+숫자					
					break;
				case "cobLane":
	            	MaxLength = 5;
	            	UseAutoComplete = false;
	            	ValidChar(2, 1);	//영문대문자+숫자
					break;
				case "cobDir":
	            	MaxLength = 1;
	            	UseAutoComplete = false;
	            	ValidChar(2, 0);	//영문만 입력
					break;					
			}
		}
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObject, formObj,sAction) {
		switch(sAction) {		
			case IBCREATE:      //생성
				if (!validateForm(formObj, formObj, sAction)) {
					return false;
				}

				sheetObject.WaitImageVisible = false;
				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { //정보를 생성 하시겠습니까?
					formObj.f_cmd.value = MULTI01;
					ComOpenWait(true);
					var xml = sheetObject.GetSearchXml("ESM_BSA_0044GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
					ComOpenWait(false);
					if ( xml != null && xml != ''){
						var statusCode = ComGetEtcData(xml, "BatchStatus" );
						switch(statusCode){
							case "4":
								ComShowCodeMessage("COM12116", "BSA Creation Excution");
								break;
							case "5":
								ComShowCodeMessage("COM12151", "BSA Creation Excution");
								break;
							case "6":
								ComShowCodeMessage("BSA00003", "BSA Creation");
								break;
							default: break;							
						}
					}
				}
				break;
		}
	}
	
	//화면의 Enter-Key 처리
	function keyEnter_loc(){
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;
		if (event.keyCode == 13) {
			if (sheet_selno == JOINT_OPERATING) { //첫번째 SHEET 이면
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			} else if (sheet_selno == SPACE_CHARTERING) { //두번째 SHEET 이면
				doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
			}
		}
	}
	/**
	 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
	 */
	function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var param = "";
		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
		if(obj.Text != ""){
			trd_cd = obj.Code;
			param = "f_cmd="+SEARCHLIST01;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=rLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
			formObj.cobLane.Index = 0;
		}
		sheetObj.WaitImageVisible = true;
	}
	 
	 /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
	function setPeriod(obj){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var param = "";
        var gubun = "";
        var fm_wk ="";
        var to_wk ="";

        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            formObj.txtFmWeek.value = "";
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "txtFmWeek") return false;
        }

//        if(chkValidSearch()){
            if(formObj.txtFmWeek.value != ""){
            	gubun = "5";
            } else if(formObj.txtFmWeek.value == "") {
            	gubun = "3";
            }
            formObj.param2.value = formObj.txtYear.value;
            formObj.param5.value = "";
            formObj.param6.value = "";
            formObj.param7.value = formObj.txtFmWeek.value;
            formObj.param8.value = formObj.txtToWeek.value;
            fm_wk = formObj.txtFmWeek.value;
            to_wk = formObj.txtToWeek.value;
            
            param = param+"f_cmd="+SEARCHLIST02;
			param = param+"&gubun="+gubun;
			param = param+"&fm_wk="+fm_wk;
			param = param+"&to_wk="+to_wk;
			param = param+"&year="+eval(formObj.txtYear.value);
			param = param+"&code=period";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			var period = GetEtcDataForExceptional(sXml, "period", "0");
			document.getElementById("div_period").innerHTML = "<div id=\"div_period\">("+ period +")</div>";
//        }
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			// Year Check
			if (txtYear.value == "") {
				ComShowCodeMessage("COM12114", "Year", "");
			    txtYear.focus();
				return false;
			}

			// Week Check
			if(txtFmWeek.value == ""  && txtToWeek.value == ""){
				ComShowCodeMessage("COM12138", "From Week", "To Week");
			    return false;
			}

			if(txtFmWeek.value == "") {
				ComShowMessage(ComGetMsg("COM12114","From Week",""));
				txtFmWeek.focus();
				return false;
			}
			
			if(txtFmWeek.value.length != 2) {
				ComShowMessage(ComGetMsg("COM12114","From Week",""));
				txtFmWeek.focus();
				return false;
			}
			
			if(txtToWeek.value == "") {
				ComShowMessage(ComGetMsg("COM12114","To Week",""));
				txtToWeek.focus();
				return false;
			}
			
			if(txtToWeek.value.length != 2) {
				ComShowMessage(ComGetMsg("COM12114","To Week",""));
				txtToWeek.focus();
				return false;
			}
			if (txtFmWeek.value != "" && txtToWeek.value != "") {
	    		if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
	    			ComAlertFocus(txtToWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
	        		return false;
	    		}
			}
			// Trade, Rlane Check
			if ( cobTrade.Code == "" || cobTrade.Code == "All"){
				ComShowCodeMessage("COM12114", "Trade", "");
				cobTrade.focus();
				return false;
			}
			if ( cobLane.Code == "" || cobLane.Code == "All"){
				ComShowCodeMessage("COM12114", "Lane", "");
				cobLane.focus();
				return false;
			}

		}
		return true;
	}
	
	/* 개발자 작업  끝 */