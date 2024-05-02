/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1003.js
*@FileTitle : S/P Service Category Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.21
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.21 백형인
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
     * @class ESD_SPE_1003 : ESD_SPE_1003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1003() {
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
    var frm = null;
    var rhqXml = null;
    var ofcXml = null;
    var itemCnt =0;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	
	
	
	
	    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 				
	 				break;
				case "btn_vndr_seq":
					vndr_OnPopupClick("form");
			        break;	 	
				case "btn_ctrt_ofc_cd":
					ctrt_ofc_OnPopupClick();
					break;	 	
	 			case "btn_save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	 				break;
	 				
	 			case "btn_RowAdd":
	 				doActionIBSheet(sheetObjects[0],document.form,"btn_RowAdd");
	 				
	 				break;
	 				
	 			case "btn_RowDel":
	 				if(sheetObjects[0].FindCheckedRow("chk") == ""){

	 				}else if(ComShowCodeConfirm("COM12171","")){
	 					doActionIBSheet(sheetObjects[0], frm, IBDELETE);
	 				}
	 				break;
				case "btn_new":
					ComResetAll();
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	     // combo 생성
	     doActionIBCombo(frm.s_eg_rhq_cd); // Level1
         for(var k = 0; k < comboObjects.length; k++){
       	  	 initCombo(comboObjects[k], k + 1);
         }	     

         setSvcCateSheet();  // Service Category 를 조회한다.
	     initControl();
	     sheet1_OnLoadFinishLoad(sheetObjects[0])

	}
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/	
	function initControl() {
		axon_event.addListenerForm('keypress',   'obj_keypress',      frm); //- 키 눌렸을때
		axon_event.addListenerForm( 'blur'   ,   'obj_blur'    ,      frm ); //- 포커스 나갈때
		axon_event.addListener ('keydown', 'keydownEnter', 'form');
	}

	 /**
	  * HTML Control KeyDown 이벤트 호출
	  */
	 function keydownEnter() {
	 	if (event.keyCode != 13) {
	 		return;
	 	}
	 	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
	 }
	 
	/**
	* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	**/
	function obj_keypress(){
		 switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;		
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;		
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
	            break;    
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	        	//숫자만입력하기(정수,날짜,시간)
	        	ComKeyOnlyNumber(event.srcElement);            
		}	
	}

 	
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	comboObj.ValidChar(2,0);
    	comboObj.UseAutoComplete = true;       	
    	 switch(comboObj.id) {
   	  		case "s_eg_rhq_cd":
        		comboObj.DropHeight = 250;
  			break;  
   	  		case "s_eg_ofc_cd":
   	  			comboObj.DropHeight = 250;
   	  			break;  
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
	    	case 1:      //sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(8);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|Seq.";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
					
				}
				break;
	    	case 2:      //sheet2 init
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
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(8, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "ibflag||S/P Code|S/P Nmae|Reg Group|Control Office|Service Category";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
	    		InitDataProperty(0,	cnt++,	dtCheckBox,	    30,		daCenter,	false,	"chk");
				InitDataProperty(0, cnt++ , dtData,         70,  	daLeft,     true,   "sp_seq",         	   true,     "",      dfNone,          0,          true,         true,   10);
				InitDataProperty(0, cnt++ , dtData,         130,  	daLeft,     true,   "sp_name",             false,    "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "sp_grp_ofc_cd",       false,    "",      dfNone,          0,          false,        false,  10);
				InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "sp_ctrl_ofc_cd",      false,    "",      dfNone,          0,          true,         true,   5);	    		
				InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "ev_svc_cate_cd",      false,    "",      dfNone,          0,          true,         true,   5);	    		
				InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "maptype",             false,    "",      dfNone,          0,          true,         true,   5);	    		
	    		
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
	    		
	    	    }
	    		break;				

			}
		}	
	 
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_sp_seq":
				vender_change();
			break;
			case "s_ctrt_ofc_cd":
				ctrt_ofc_change();
			break;
		}
	} 	 

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
				sheetObj.ShowDebugMsg = false;
				if(validateForm(sheetObj,frm,sAction)){
					sheetObjects[0].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
//					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1003GS.do", sParam);
//					sheetObjects[1].RemoveAll();
					sheetObjects[0].loadSearchXml(sXml);
//					ComOpenWait(false);
					
					for(var i=9;i<itemCnt+9;i++){
						sheetObj.HeadCheck(1,i) = false;
						
					}					
				}
				break;
		
			// SAVE LOGIC
			case IBSAVE:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
				
            	frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
		    		ComOpenWait(true);
            	
		    		
			        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1003GS.do", sParam);
					var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					if (State != "S") {
						ComShowCodeMessage('COM130103', 'Data');
						ComOpenWait(false);
						return false;
					} else if (State == "S") {
						ComShowCodeMessage('COM130102', 'Data');
						if(frm.s_eg_rhq_cd.Code != ""){
							doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
						}
					}
					
					for(var i=9;i<itemCnt+9;i++){
						sheetObj.HeadCheck(1,i) = false;
						
					}						
					ComOpenWait(false);
		    				
				break;
			case IBDELETE :
	   	   		if(sheetObj.FindCheckedRow("chk") != ""){
	   	   			// 체크행을 찾아 매핑된 데이터이면 삭제못하게 한다.
	   	   	        var sRow   = sheetObj.FindCheckedRow("chk"); 
       	   	   	    var arrRow = sRow.split("|");
	   	            for (var idx=0; idx<arrRow.length-1; idx++){ 
	   	            	if(sheetObj.CellValue(arrRow[idx],'isflag')!="" && sheetObj.CellValue(arrRow[idx],'isflag') != "0"){
	   	            		ComShowCodeMessage('SPE10011', '');
	   	            		return;
	   	            	} 
	   	            }

					ComRowHideDelete(sheetObj,"chk"); 
				}
			    break;		
			case "btn_RowAdd":
				var iRow = sheetObj.DataInsert(-1);
				sheetObj.InitCellProperty(iRow,"sp_ctrl_ofc_cd",dtCombo);
//				if(frm.s_eg_rhq_cd.Code != ""){
//					sheetObj.CellValue2(iRow,"sp_grp_ofc_cd") = frm.s_eg_rhq_cd.Code
//				}
//				if(frm.s_eg_ofc_cd.Code != ""){
//					sheetObj.CellValue2(iRow,"sp_ctrl_ofc_cd") = frm.s_eg_ofc_cd.Code
//				}
				
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
        switch(comboObj.id) {
	    case "s_eg_rhq_cd":  
//	        frm.f_cmd.value = COMMAND01;
//
//	        rhqXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
//	        frm.s_eg_rhq_cd.RemoveAll();
//	    	ComXml2ComboItem(rhqXml, frm.s_eg_rhq_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj); 
	    	comboObj.InsertItem(0, "", "");
	    	doActionIBCombo(frm.s_eg_ofc_cd)
	    	break;  
	    case "s_eg_ofc_cd":  
	    	frm.f_cmd.value = COMMAND02;
	        // eg_rhq_cd 에 값이 있으면 GRID office 값이 변경이 된다.
	        frm.eg_rhq_cd.value = "";	    	
	    	var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	    	frm.s_eg_ofc_cd.RemoveAll();
	    	ComXml2ComboItem(sXml, frm.s_eg_ofc_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	comboObj.InsertItem(0, "", "");
	    	frm.s_eg_ofc_cd.Index=0;
	    	break;  

        }
    }
    
	// 공통코드를 조회하여 그리드를 다시 그린다.   
	function setSvcCateSheet(){
		var sheetObj = sheetObjects[1];
			frm.f_cmd.value = SEARCH03;
			// 공통 테이블에서 조회할 키
			frm.code_key.value = "CD03377"
			var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			sheetObjects[0].Reset();
			ComXmlGridMake(sXml,  "code_cd", "code_nm");
			
	}    

	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	 * Grid 로 만들어준다..<br>
	 * <b>Example :</b>
	 * 
	 * 
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
	 * @param {string} codeCol 필수, Combo의 Code컬럼명.
	 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
	 * @return 없음.
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComXmlGridMake(xmlStr,  codeCol, textCol) {
		if (xmlStr == null || xmlStr == "" ) {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
	
		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);
	
			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}
	
			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
			
			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");
	
			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
			var colListIdx = Array();
			var arrText = textCol.split("|");
			for (var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				for (var j = 0; j < arrText.length; j++) {
					if (colArr[i] == arrText[j]) {
						colListIdx[j+1] = i;
					}
				}
			}

			var headItem1 = "ibflag|Chk|save_sc_val|S/P Code|S/P Nmae|Regional Group|Control Office|Contract Office|isflag";
			var headItem2 = "ibflag|Chk|save_sc_val|S/P Code|S/P Nmae|Regional Group|Control Office|Contract Office|isflag";	
			    itemCnt =0;
			var arrColName = new Array();
			for (var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				
				var item = "";
				for (var j = 1; j < colListIdx.length; j++) {
					item += arrData[colListIdx[j]];
					if (j < colListIdx.length - 1) {
						item += "|";
					}
				}
				arrColName[itemCnt] = arrData[colListIdx[0]];
				itemCnt = itemCnt + 1;
				headItem1 = headItem1+"|Service Category";
//				headItem2 = headItem2+"|"+item;
				headItem2 = headItem2+"|"+arrData[colListIdx[0]];
			}
			
			//저장시에 사용할 Service Category 갯수
			
			var cnt = 0;
	    	with (sheetObjects[0]) {
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
				InitRowInfo(2, 1, 10, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(itemCnt+9, 9, 0, false);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, headItem1, true);
				InitHeadRow(1, headItem2, true);

				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
				InitDataProperty(0,	cnt++,	dtCheckBox,		50,		daCenter,	true,	"chk");  
				InitDataProperty(0, cnt++ , dtHidden,       100,  	daCenter,   true,   "save_sc_val",         false,    "",      dfNone,          0,          true,         true,   100);
				InitDataProperty(0, cnt++ , dtPopupEdit,    70,  	daCenter,   true,   "sp_seq",         	   true,     "",      dfNone,          0,          true,         true,   10);
				InitDataProperty(0, cnt++ , dtData,         130,  	daLeft,     true,   "sp_name",             false,    "",      dfNone,          0,          true,         true,   10);
				InitDataProperty(0, cnt++ , dtCombo,        110,  	daCenter,   true,   "sp_grp_ofc_cd",       true,     "",      dfNone,          0,          true,         true,   10);
				InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "sp_ctrl_ofc_cd",      false,    "",      dfNone,          0,          true,         true,   5);
				InitDataProperty(0, cnt++ , dtPopupEdit,    110,  	daCenter,   true,   "sp_ctrt_ofc_cd",      false,    "",      dfNone,          0,          true,         true,   10);
				InitDataProperty(0, cnt++ , dtHidden,       110,  	daCenter,   true,   "isflag",              false,    "",      dfNone,          0,          true,         true,   10);
				for (var i = 0; i < itemCnt; i++) {
					InitDataProperty(0, cnt++ , dtCheckBox, 0,  	daCenter,   true,   arrColName[i],         false,    "",      dfNone,          0,          true,         true,   5);
				}
//				InitDataProperty(0, cnt++ , dtHidden,       100,  	daCenter,   true,   "save_sc_val",         false,    "",      dfNone,          0,          true,         true,   100);
				// 저장시 사용될 컬럼을 저장한다.
				InitDataValid(0, 2, vtNumericOnly);
				InitDataValid(0, "sp_ctrl_ofc_cd", vtEngUpOnly);
				InitDataValid(0, "sp_ctrt_ofc_cd", vtEngUpOnly);
			}			
	
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	}	
	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
	 	 case IBSEARCH :
	 		 if(frm.s_eg_rhq_cd.Code  == ""){
	 			 ComShowCodeMessage('COM130201', 'Regional Group'); //Regional Group 값을 입력하셔야 합니다
	 			 return false;
	 		 }
	 		 if(frm.s_chk_all.checked  == false && frm.s_chk_map.checked  == false && frm.s_chk_unmap.checked  == false){
	 			 ComShowCodeMessage('COM130201', 'Check Box'); //Regional Group 값을 입력하셔야 합니다
	 			 return false;
	 		 }
	 		 break;
	 	 case IBSAVE :
			if(sheetObj.RowCount<1){
				ComShowCodeMessage('COM130201', 'Grid'); //Grid 값을 입력하셔야 합니다
				return false;
			}
         	if(sheetObj.GetSaveString(false, true)==""){
        		return false;
        	}	 		 
	 		 break;	 		 
	 	 } // end switch()
	 	 return true;
	  }	 

  
	  
	  function s_eg_rhq_cd_OnChange(comboObj,Index_Code, Text){   
		  sheetObjects[0].RemoveAll();
		  doActionIBCombo(frm.s_eg_ofc_cd); // RHQ
	  }
	  
	  
	  function s_eg_ofc_cd_OnChange(comboObj,Index_Code, Text){   
		  sheetObjects[0].RemoveAll();
	  }
	  

	  
	  
	  
	  /*
	   * ctrt_ofc_OnPopupClick 팝업호출
	   */
	  function ctrt_ofc_OnPopupClick() {
		  ComOpenPopup("/hanjin/COM_ENS_071.do", 770, 450, 'setCtrt_ofc_cd', '1,0,1,1,1',true); 
	  }	    

	/**
	 * ctrt_ofc_OnPopupClick 호출후 값을 받은 함수      
	 */
	 function setCtrt_ofc_cd(aryPopupData){
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			 frm.s_ctrt_ofc_cd.value = aryPopupData[0][3];
		 }      
	 }
	

		/**
		* ctrt_ofc_cd 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
		*/
	function ctrt_ofc_change(){
		var ctrtVal = frm.s_ctrt_ofc_cd.value
		   if(ctrtVal ==""){
			   return;
		   }
		   frm.f_cmd.value = COMMAND03;
		   // f_ctrt_ofc_cd 에 값이 있으면 Grid 에서 변경된 값이다.
		   frm.f_ctrt_ofc_cd.value = ctrtVal;
		   var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
		   var isflag = SpeXmlString(sXml,"isflag");
		   if(isflag==0){
			   ComShowCodeMessage('COM132202', 'Contract Office'); //사용할수 없는 Control Office 
			   frm.s_ctrt_ofc_cd.value = "";
		   }
		
	}		

		/*
		* vndr_OnPopupClick팝업호출
		*/
	function vndr_OnPopupClick(callType) {
		  var returnFun = "";
		  if(callType == "grid"){
			  returnFun = "getCOM_ENS_Rep_Gird";
		  }else{
			  returnFun = "getCOM_ENS_rep"
		  }
		  var cmdt_cd_val ="";   //향후 사용가능 예정변수
		  var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		  var cmdt_desc_val ="";   //향후 사용가능 예정변수
		  var classId ="getCOM_ENS_rep";
		  var xx1="";  //CONTI
		  var xx2="";  //SUB CONTI
		  var xx3="";  //COUNTRY
		  var xx4="";  //STATE
		  var xx5="";  //CONTROL OFFIC
		  var xx6="";  //LOC CODE
		  var xx7="";  //LOC NAME
		  var xx8="";
		  var xx9="";
			
			var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
			ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 699, 402, returnFun, '1,0,1,1,1',true);
	}	    
	  
		/**
		* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
		*/
	function getCOM_ENS_rep(rowArray) {
			for(var i=0; i<rowArray.length; i++) 
			{
				var colArray = rowArray[0];
				var colArray2 = colArray[2];
				var colArray3 = colArray[3];
				var colArray4 = colArray[4];
				
				frm.s_sp_seq.value =colArray2;
				frm.s_sp_nm.value =colArray4;
				// DB 에 넘어갈 파라미터 정의
				frm.sp_seq.value =colArray2;
	}
		}	  
	/**
	 * S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
	 */
	function getCOM_ENS_Rep_Gird(rowArray) {
		var sheetObj = sheetObjects[0];
		for(var i=0; i<rowArray.length; i++){
			var colArray = rowArray[0];
			var colArray2 = colArray[2];
			var colArray3 = colArray[3];
			var colArray4 = colArray[4];
			sheetObj.CellValue2(sheetObj.SelectRow,"sp_seq") =colArray2;
			sheetObj.CellValue2(sheetObj.SelectRow,"sp_name") =colArray4;
		}
		
		grid_Vender_Change(sheetObj, sheetObj.SelectRow, sheetObj.SaveNameCol("sp_seq") ,colArray2)
	}	  

		
		
		/**
		 * S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
		 */
	function vender_change(){
			// s/p 코드값이 변경되면 기존 저장값을 초기화 해야한다.
			if(frm.s_sp_seq.value =="" ){
				frm.s_sp_seq.value="";
				frm.s_sp_nm.value="";
				// DB 에 넘어갈 파라미터 정의
				frm.sp_seq.value="";
				return;
			}else {
				frm.f_cmd.value = COMMAND04;
				// DB 에 넘어갈 파라미터 정의
				frm.sp_seq.value=frm.s_sp_seq.value;
				var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
				var vndrNm = SpeXmlString(sXml,"vndr_nm");
				if(vndrNm==0){
					ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
					frm.s_sp_seq.value="";
					frm.s_sp_nm.value="";
					// DB 에 넘어갈 파라미터 정의
					frm.sp_seq.value="";
					return;
				}else{
					frm.s_sp_nm.value = vndrNm;
				}
			}
			
	}
		
	
	/**
 	 * sheet1의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "sp_ctrt_ofc_cd":		//Yard Code No Pop-up
					ComOpenPopup("/hanjin/COM_ENS_071.do", 770, 450, 'setESD_SPE_1001', '1,0,1,1,1',true); 
					break;
				case "sp_seq":		//Yard Code No Pop-up
					vndr_OnPopupClick("grid") 
					break;
			}
 		}
    }	  
    
 	/**
	 * COM_ENS_071 의 값을 받은 함수      
	 */
	function setESD_SPE_1001(aryPopupData){
    	 var Row=sheetObjects[0].SelectRow;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[0].CellValue(Row, "sp_ctrt_ofc_cd") 		= aryPopupData[0][3];
		 }      
    } 		    
    
      /**
      * Sheet 로딩 후 이벤트 <br>
      * body 태그의 onLoadFinish 이벤트핸들러 구현 <br>
      * @param  sheetObj
      * @return 없음
      * @author 
      * @version 2013.03.21
      */ 	  
	  function sheet1_OnLoadFinishLoad(sheetObj){
		  // RHQ 생성
		  var rhqOfcCd = ComXml2ComboString(rhqXml,  "code_cd", "code_nm");
		  sheetObj.InitDataCombo(0, "sp_grp_ofc_cd", " |" + rhqOfcCd[0], " |" + rhqOfcCd[0]);    // IBSheet내 Combo 초기화
		  
//			  // RHQ 따라 지역오피스 조회
//		      frm.f_cmd.value = COMMAND02;
//		      frm.eg_rhq_cd.value = rhqOfcCd[1].split("|")[0]; 
//		      var sXml = sheetObjects[1].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
//		      var ofcCd = ComXml2ComboString(sXml,  "eg_ofc_cd", "eg_ofc_cd");
//		      sheetObj.InitDataCombo(0, "sp_ctrl_ofc_cd", " |" + ofcCd[1], " |" + ofcCd[0]);    // IBSheet내 Combo 초기화
	      
	      

		  
	  }		
	
    /**
     * sheet1 편집처리후 이벤트
     * @param {long} row 해당 셀의 Row Index
     * @param {long} col 해당 셀의 Column Index
     * @param {string} col 해당 셀의 value 
     * 
     */
    function sheet1_OnChange(sheet, row, col ,value) {
    	if (col == sheet.SaveNameCol("sp_seq")) {
    		grid_Vender_Change(sheet, row, col ,value)
    		
    	}else if(col != sheet.SaveNameCol("ibflag") && 
    			 col != sheet.SaveNameCol("chk") && 
    			 col != sheet.SaveNameCol("sp_seq") && 
    			 col != sheet.SaveNameCol("sp_name") && 
    			 col != sheet.SaveNameCol("sp_grp_ofc_cd") &&
    			 col != sheet.SaveNameCol("sp_ctrl_ofc_cd") &&
    			 col != sheet.SaveNameCol("sp_ctrt_ofc_cd")){
    		
    		if(sheet.CellValue(row,col) == 1){
    			sheet.CellValue2(row,"save_sc_val") =sheet.CellValue(row,"save_sc_val") + sheet.ColSaveName(col)+","; 
    		}else{
    			sheet.CellValue2(row,"save_sc_val") =sheet.CellValue(row,"save_sc_val").replace(sheet.ColSaveName(col)+",",""); 
    			sheet.CellValue2(row,"save_sc_val") =sheet.CellValue(row,"save_sc_val").replace(",,",","); 
    			
    		}
    	}else if(col == sheet.SaveNameCol("sp_grp_ofc_cd")) {
    		// RHQ 따라 지역오피스 조회
    		frm.f_cmd.value = COMMAND02;
    		frm.eg_rhq_cd.value = value; 
    		var sXml = sheet.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
    		var ofcCd = ComXml2ComboString(sXml,  "eg_ofc_cd", "eg_ofc_cd");
    		sheet.CellComboItem(row, "sp_ctrl_ofc_cd", "|" + ofcCd[1], "|" + ofcCd[0]);    // IBSheet내 Combo 초기화
    	}else if(col == sheet.SaveNameCol("sp_ctrt_ofc_cd")){
    		ctrt_office_change(sheet,row, col, value)
    	}
    }
    

	
	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function grid_Vender_Change(sheetObj, row, col ,value){
		
		if(value == "" ){
			sheetObj.CellValue2(row,"sp_seq") = "";
			sheetObj.CellValue2(row,"sp_name") = "";
			sheetObj.CellValue2(row,"sp_grp_ofc_cd") = "";
			sheetObj.CellValue2(row,"sp_ctrl_ofc_cd") = "";
			return;
		}else {
			
			   // 공백을 제외하고 중복체크
			   sheetObj.SpaceDupCheck = false;
			if(sheetObj.ColValueDup("sp_seq")>0){
				ComShowCodeMessage('COM12115','S/P Code');
				sheetObj.CellValue2(row,"sp_seq") = "";
				sheetObj.CellValue2(row,"sp_name") = "";
				sheetObj.CellValue2(row,"sp_grp_ofc_cd") = "";
				sheetObj.CellValue2(row,"sp_ctrl_ofc_cd") = "";
				sheetObj.CellValue2(row,"sp_ctrt_ofc_cd") = "";
			    return;
			}
			
			frm.f_cmd.value = COMMAND04;
			frm.sp_seq.value = value;
			var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			var vndrSeq = SpeXmlString(sXml,"vndr_seq");
			var vndrNm  = SpeXmlString(sXml,"vndr_nm");
			var egRhqCd = SpeXmlString(sXml,"eg_rhq_cd");
			var egOfcCd = SpeXmlString(sXml,"eg_ofc_cd");
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				sheetObj.CellValue2(row,"sp_seq") = "";
				sheetObj.CellValue2(row,"sp_name") = "";
				sheetObj.CellValue2(row,"sp_grp_ofc_cd") = "";
				sheetObj.CellValue2(row,"sp_ctrl_ofc_cd") = "";
				sheetObj.CellValue2(row,"sp_ctrt_ofc_cd") = "";
				return;
			}else{
				sheetObj.CellValue2(row,"sp_seq")  = vndrSeq;
				sheetObj.CellValue2(row,"sp_name") = vndrNm;
				sheetObj.CellValue2(row,"sp_grp_ofc_cd")  = ""; // egRhqCd;
				sheetObj.CellValue2(row,"sp_ctrl_ofc_cd") = ""; // egOfcCd;
				sheetObj.CellValue2(row,"sp_ctrt_ofc_cd") = "";
			}
			
			// 존재하는 SP 코드인경우
			frm.f_cmd.value = COMMAND01;
			var sXml = sheetObj.GetSearchXml("ESD_SPE_1003GS.do", FormQueryString(frm));
			
    		var isflag = SpeXmlString(sXml,"isflag");
    		
    		// 등록된 데이터가 있으면 마지막으로 입력한 COL 을 초기화 한다.
 		    if(isflag != 0){
			   ComShowCodeMessage('COM12115','EG DATA');
			   sheetObj.CellValue2(row,"sp_seq") = "";
			   sheetObj.CellValue2(row,"sp_name") = "";
			   sheetObj.CellValue2(row,"sp_grp_ofc_cd") = "";
			   sheetObj.CellValue2(row,"sp_ctrl_ofc_cd") = "";
			   sheetObj.CellValue2(row,"sp_ctrt_ofc_cd") = "";
		    }				
		}
	
	}
	
	
	function chkClickEvn(chkName){
		if(chkName == "s_chk_all"){
			frm.s_chk_map.checked = false;
			frm.s_chk_unmap.checked = false;
			frm.chk_type.value = "A";
		}else if(chkName == "s_chk_map"){
			frm.s_chk_all.checked = false;
			frm.s_chk_unmap.checked = false;
			frm.chk_type.value = "B";
		}else if(chkName == "s_chk_unmap"){
			frm.s_chk_all.checked = false;
			frm.s_chk_map.checked = false;
			frm.chk_type.value = "C";
		}
	}
	
	
	/**
	* 사용자가 입력한 Control Office 코드가 존재하는 값인지 조회한다..
	*/
	function  ctrt_office_change(sheet, row, col ,value){
	   if(value ==""){
		   return;
	   }
	   frm.f_cmd.value = COMMAND03;
	   frm.s_sp_grp_ofc_cd.value = sheet.CellValue(row,"sp_grp_ofc_cd");
	   frm.f_ctrt_ofc_cd.value = value;
	   var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	   var isflag = SpeXmlString(sXml,"isflag");
	   if(isflag==0){
		   ComShowCodeMessage('COM132202', 'Contract Office'); //사용할수 없는 Control Office 
		   sheet.CellValue2(row,"sp_ctrt_ofc_cd") = "";
	   }
	}		
	
	
    function sheet1_OnClick(sheetObj, row, col, value) {
         switch(sheetObj.ColSaveName(col)) {
	   	    case "sp_ctrl_ofc_cd":  
	   	    	if(sheetObj.ReadDataProperty(row,col, dpDataType) == dtCombo) return;
	   	    	sheetObj.InitCellProperty(row,col,dtCombo)
		        frm.f_cmd.value = COMMAND02;
	   	    	var rhqCd = sheetObj.CellValue(row,"sp_grp_ofc_cd");
	   	    	if(rhqCd==""){
	   	    		return;
	   	    	}
			    frm.eg_rhq_cd.value = rhqCd; 
			    var sXml = sheetObjects[1].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			    var ofcCd = ComXml2ComboString(sXml,  "eg_ofc_cd", "eg_ofc_cd");
			    sheetObjects[0].CellComboItem(row, "sp_ctrl_ofc_cd", "|" + ofcCd[1], "|" + ofcCd[0]);    // IBSheet내 Combo 초기화		
	   	    	break;  
         }
    }
		
	
		
	
	/* 개발자 작업  끝 */