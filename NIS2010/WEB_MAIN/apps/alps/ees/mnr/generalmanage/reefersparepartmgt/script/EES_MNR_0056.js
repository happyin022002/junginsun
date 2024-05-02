	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0056.js 
	 *@FileTitle : Standard Reefer Spare Parts List of the vsl
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.09.02
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 *  2009.08.25 권영법
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
	 * @class ees_mnr_0056 : ees_mnr_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0056() {
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


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[0];
         
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_New":
					doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
					break;
					
				case "btn_calendar":
					var cal = new ComCalendarFromTo();
				    cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				    break;			
								
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
					
				case "btn_spare_type_list":
					ComOpenPopup("EES_MNR_0198.do", 950, 430, '', '0,1', true);					

					break;	
				case "btn_workorder_history":
					formObject.vsl_cd2.value=sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_vsl_cd");
					ComOpenPopup("EES_MNR_0194.do", 950, 420, '', '0,1', true);
					break;	
					
				case "btn_Lane":
					ComOpenPopup("COM_ENS_081.do", 780, 420, 'setPopUpParam_COM_ENS_081', '0,1', true);
					break;				
					
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
					break;
					
				case "btn_delete":
					if(sheetObjects[0].FindCheckedRow("del_chk") == ""){ 
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;             	   
					}
					if(ComShowCodeConfirm("MNR00026")){
						ComRowHideDelete(sheetObjects[0], "del_chk");
						calReq=0;
					}
					break;
					
				case "btn_DownExcel":
					sheetObjects[0].SpeedDown2Excel();
					break;
					
				case "btn_LoadExcel":
					ComOpenPopup("/hanjin/EES_MNR_0219.do", 698, 535, 'setPopUpParam_EES_MNR_0219', '1,0', true); 
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
    	 MnrWaitControl(true);
    	 initControl();
        for(i=0;i<sheetObjects.length;i++)
        {
	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
        }

        initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
    }

 	/**
 	 * 멀티 콤보 초기화 
 	 * @return
 	 */
 	function initCombo() {
 		var formObject = document.form

 		with (formObject.combo_spr_tp_cd) {
 	
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
            case 1:      // sheet1 init
                with (sheetObj) {
				// 높이 설정
				style.height = 380;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet =  msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 10, 100);
				
				var HeadTitle1 = "|Sel|Seq|Vessel Code|Vessel Name|Lane|Spare Type|Supply Date|Check Date|Discharge Date|Remark(s)";
													
				var headCount = ComCountHeadTitle(HeadTitle1);									
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				var prefix = "sheet1_";
				InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,	prefix+	"ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,    		40,     daCenter,   true,           "del_chk",      false,	"", dfNone,		0, true,  true);
				InitDataProperty(0, cnt++ , dtDataSeq,	   		40,		daCenter,	true,		    "Seq");
				InitDataValid(   0,    cnt,  vtEngUpOther, "0123456789");  
				InitDataProperty(0,	cnt++,	dtPopupEditFormat,	80,		daCenter,	true,	prefix+	"vsl_cd",		false,	"",	dfEngUpKey,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,				200,	daCenter,	true,	prefix+	"vsl_eng_nm",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtPopupEditFormat,	60,		daCenter,	true,	prefix+	"lane_cd",		false,	"",	dfNone,		0,	true,	true);
				InitDataProperty(0,	cnt++,	dtCombo,			85,		daCenter,	true,	prefix+"spr_tp_cd",		false,	"",	dfNone,		0,	true,	true);
				
				InitDataProperty(0,	cnt++,	dtPopupEditFormat,	90,		daCenter,	true,	prefix+	"spr_spl_dt",	false,	"",	dfDateYmd,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtPopupEditFormat,	90,		daCenter,	true,	prefix+	"spr_chk_dt",	false,	"",	dfDateYmd,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtPopupEditFormat,	92,		daCenter,	true,	prefix+	"dchg_dt",		false,	"",	dfDateYmd,	0,	true,	true);
				InitDataProperty(0,	cnt++,	dtData,		        100,	daLeft,		true,	prefix+	"invt_rmk",		false,	"",	dfNone,		0,	true,	true, 4000);
				
				ImageList(0) = "img/btns_detail.gif";
				ImageList(1) = "img/btns_calendar.gif";
			    //전반적인 팝업 버튼 이미지를 설정한다.

			    PopupButtonImage(0, 4) = 0;
			    PopupButtonImage(0, 7) = 1;
			    PopupButtonImage(0, 8) = 1;
			    PopupButtonImage(0, 9) = 1;
				ShowButtonImage = 2;   
			}
			break;
            case 2: 
        		with (sheetObj) {
        			//Host정보 설정[필수][HostIp, Port, PagePath]
        			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        		}	 
        		break;
   
        }
    }

  	function initControl() {       
  		//Axon 이벤트 처리1. 이벤트catch  
  		var formObject = document.form;       
  		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
  		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
  		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
  		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
  	}
					
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
  	
  	//Axon 이벤트 처리2. 이벤트처리함수   
  	function obj_deactivate(){      
  		ComChkObjValid(event.srcElement); 
  	} 
  	
  	function obj_activate(){   
  		ComClearSeparator(event.srcElement);
  	}        
  	
  	function obj_change(){	     
  		var obj      = event.srcElement; 
  		var formObj  = document.form; 
  		var sheetObj = sheetObjects[0]; 
  	
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) {      
  			case "empty":   
  				break;   
  			}       
  		} 
  	}    
  	
  	function obj_keypress(){   
  		obj = event.srcElement;    
  		keys = event.keyCode;
  		if(obj.dataformat == null) return; 
  		window.defaultStatus = obj.dataformat;
  		var formObj  = document.form; 
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) {      
  			case "empty":   
  				break;   
  			}       
  		}				 			              
  		switch(obj.dataformat) {   
  		case "ymd":   
  		case "int":       
  			ComKeyOnlyNumber(obj); 
  			break;     
  		case "float":    
  			ComKeyOnlyNumber(obj, "-.");
  			break; 
  		case "eng":   
  			ComKeyOnlyAlphabet();
  			break;   
  		case "engup":  
  			ComKeyOnlyAlphabet('uppernum');           
  			break; 
  		}         
  	}     

    function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet1_";
		MnrWaitControl(false);
		nowLoad = 0;
	}     
	
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 
	
				ComShowCodeMessage("MNR00009", "Reefer Spare Parts Inventory");
				formObj.vsl_cd.value="";
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
	}	   	
	
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) == "sheet1_spr_spl_dt" ||
				sheetObj.ColSaveName(Col) == "sheet1_dchg_dt" ||
				sheetObj.ColSaveName(Col) == "sheet1_spr_chk_dt" )
		{
			var cal = new ComCalendarGrid();     
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd'); 
		}else if(sheetObj.ColSaveName(Col) == "sheet1_vsl_cd")
		{
			MnrWaitControl(true);
			ComOpenPopup("COM_ENS_0A1.do", 620, 460, 'setPopUpParam_COM_ENS_0A1', '0,1', true);
			MnrWaitControl(false); 
		}else if(sheetObj.ColSaveName(Col) == "sheet1_lane_cd")
		{
			MnrWaitControl(true);
			ComOpenPopup("COM_ENS_081.do", 780, 420, 'setPopUpParamSheet_COM_ENS_081', '0,1', true);
			MnrWaitControl(false); 
		}
	}  
	

	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "sheet1_vsl_cd"){
			MnrWaitControl(true);
			var formObj=document.form;
			var checkVsl=sheetObjects[0].CellValue(Row,"sheet1_vsl_cd");
			sheetObjects[0].CellValue2(Row,"sheet1_vsl_cd")=checkVsl.toUpperCase();
			checkVsl=checkVsl.toUpperCase();
    
			//맞는 EQ_NUMBER Equipment Information 를 표시한다.
			setVesselInfo(sheetObjects[1],Row,checkVsl);	 
			return; 	   
		}
	}    
	
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		var formObj = document.form;
		if(OldRow !=NewRow)
		{
			if(sheetObj.CellValue(NewRow,"sheet1_ibflag")== "I"){ 
				sheetObj.CellBackColor(NewRow,"sheet1_vsl_cd") = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
				sheetObj.CellEditable(NewRow,"sheet1_vsl_cd") = true;
			}else{
				sheetObj.CellBackColor(NewRow,"sheet1_vsl_cd") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);	
				sheetObj.CellEditable(NewRow,"sheet1_vsl_cd") = false;
			}
			return;
		}	 	
	}	

	/**
	 * 그리드 Vessel Code(VSL_CD) 입력값에 대한 고유성검증 프로세스 처리
	 */
	function sheet1_vsl_cd_UniqueCheck(sheetObj,formObj,Row){
			formObj.f_cmd.value = SEARCH; 
			formObj.vsl_cd.value=sheetObj.CellValue(Row,"sheet1_vsl_cd");
			formObj.spr_tp_cd.value="";
		
			var sParam = "";
			var aryPrefix = new Array("sheet1_");
		
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		
			var sXml   = sheetObj.GetSearchXml("EES_MNR_0056GS.do", sParam);
			arrDataSearchDbXml = sXml.split("|$$|");
		
			for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
				var Slength=arrDataSearchDbXml[i].indexOf("TOTAL='");
				var intSize=arrDataSearchDbXml[i].substring(Slength + 7,Slength + 8);
			}   
			
			if(intSize>0)
			{
				return false;
			}
		return true;
	}
	
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBCLEAR:  //NEW
				MnrWaitControl(true);
				formObj.f_gubuns.value = "";
				formObj.vsl_slan_cd.value = "";
				formObj.cost_ofc_cd.value = currOfcCd;
				formObj.tocal.value = ComGetNowInfo();
				formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -90);
				
				//Combo 세팅
				costDtlCode = "";
				costDtlDesc = "";
				formObj.combo_spr_tp_cd.RemoveAll();
				formObj.combo_spr_tp_cd.Code2="-1";
				var sCondition = new Array (
						new Array("MnrGenCd","CD00031", "CUSTOM8") //Spare Type
					   ,new Array("MnrGenCd","CD00031",  "COMMON") // Sheet Spare Type

					);   
				var comboList = MnrComSearchCombo(sheetObj,sCondition);
				var code,Texts="";
				for(var i=0; i<comboList.length; i++)
				{	
					if(comboList[i] != null)
					{
	                    if(i==0){
	                    	formObj.combo_spr_tp_cd.InsertItem(0, "All" ," ");
						}
						for(var j = 0; j < comboList[i].length;j++)
						{   
							var xmlVal = comboList[i][j].split("|");  
							if(i==0){
								formObj.combo_spr_tp_cd.InsertItem(j + 1, xmlVal[1] ,xmlVal[0].substring(1));
							}else if(i==1){
								costDtlCode = costDtlCode + xmlVal[0].substring(1) + "|";
								costDtlDesc = costDtlDesc + xmlVal[1] + "|";
							}
						}	
						if(i==1){
							costDtlCode = costDtlCode.substring(0, costDtlCode.length - 1);
							costDtlDesc = costDtlDesc.substring(0, costDtlDesc.length - 1);
							sheetObjects[0].InitDataCombo(0, "sheet1_spr_tp_cd", costDtlDesc, costDtlCode, costDtlCode.substring(0,costDtlCode.indexOf("|")) );
						}
					}
					else
					{
						if(i==0){
							ComShowCodeMessage("MNR00005", "Spare Type  ");
						}
					}
				}		
				formObj.combo_spr_tp_cd.Index=0;
				sheetObjects[0].RemoveAll();
				MnrWaitControl(false);        
				break;
				
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction))return;
				
				MnrWaitControl(true);
				nowLoad = 1;
				formObj.f_gubuns.value = "";
				sheetObjects[0].RemoveAll();
			    formObj.f_cmd.value = SEARCH; 
			    formObj.vsl_cd2.value="";
				formObj.spr_tp_cd.value=formObj.combo_spr_tp_cd.Code;
			
				var sParam = "";
				var aryPrefix = new Array("sheet1_");
			
				sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			
				var sXml   = sheetObj.GetSearchXml("EES_MNR_0056GS.do", sParam);
				arrDataSearchDbXml = sXml.split("|$$|");
			
				for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
					sheetObjects[i].Redraw = false;
					sheetObjects[i].WaitImageVisible = false;
					sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
					sheetObjects[i].Redraw = true;
				}   
			
				break;		

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				formObj.f_cmd.value = MULTI;
			
				var aryPrefix = new Array("sheet1_");
				var sParam = ComGetSaveString(sheetObjects, true, true);
				if (sParam == "")
				{
					MnrWaitControl(false);
					return false;
				}
			
				sParam += "&" + FormQueryString(formObj) + "&"
				+ ComGetPrefixParam(aryPrefix);
			
				var sXml = sheetObj.GetSaveXml("EES_MNR_0056GS.do", sParam);
			
				sheetObjects[0].LoadSaveXml(sXml);
			
				break;

			case IBINSERT:      // 입력
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				var row = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(row, "sheet1_spr_tp_cd") = "";
				MnrWaitControl(false);
                break;
        }
    }
		
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
			with(formObj){
				//저장(확정)시
				if(sAction==IBSAVE)
				{
					//1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
					var rCnt=sheetObj.RowCount;
					if(rCnt<=0)
					{
						//ComShowCodeMessage("MNR00072");
						return false;             	   
					}
		
					for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
					{
						//2.Vessel Code를 Mandatory에 대한 체크를 수행 한다.
						var strSel =ComTrimAll(sheetObj.CellValue(i, "sheet1_vsl_cd")," ");
						if(strSel=="")
						{
							ComShowCodeMessage("MNR00036","Vessel Code");
							sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
							return false; 
						}

						//3.Vessel Code DB및 입력값의  대한 중복체크를 수행 한다.     		
						if(sheetObj.CellValue(i, "sheet1_ibflag")=="I")
						{
							var startUnique=sheetObj.FindText("sheet1_vsl_cd",sheetObj.CellValue(i, "sheet1_vsl_cd"),1);
							if(startUnique != i && startUnique != -1)
							{
								ComShowCodeMessage("MNR00006","Vessel Code");
								sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
								return false; 
							}							
							if(i<sheetObj.LastRow)
							{
								var endUnique=sheetObj.FindText("sheet1_vsl_cd",sheetObj.CellValue(i, "sheet1_vsl_cd"),i + 1);
								if(endUnique != i && endUnique != -1)
								{
									ComShowCodeMessage("MNR00006","Vessel Code");
									sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
									return false; 
								}						
							}
							
							if(!sheet1_vsl_cd_UniqueCheck(sheetObj,formObj,i))
							{
								ComShowCodeMessage("MNR00006","Vessel Code");
								sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
								return false; 
							}
						}
						
						//2.LAND Code를 Mandatory에 대한 체크를 수행 한다.
						var strSel =ComTrimAll(sheetObj.CellValue(i, "sheet1_lane_cd")," ");
						if(strSel=="")
						{
							ComShowCodeMessage("MNR00172","Lane Code");
							sheetObj.SelectCell(i, "sheet1_lane_cd",true);
							return false; 
						}
						
						//4.LANE 존재에 대한 체크를 수행 한다.    
						var returnValue=MnrGeneralCodeCheck(sheetObj,"LANE",sheetObj.CellValue(i, "sheet1_lane_cd"))
					
						if(returnValue==null)
						{
							ComShowCodeMessage("MNR00159","Lane Code");
							sheetObj.CellValue(i, "sheet1_lane_cd")="";
							sheetObj.SelectCell(i, "sheet1_lane_cd",true);
							return false; 
						}
						//4.Spare Type를 빈값에 대한 체크를 수행 한다.    				
						var strInput =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_tp_cd")," ");
						if(strInput=="")
						{
							ComShowCodeMessage("MNR00172","Spare Type");
							sheetObj.SelectCell(i, "sheet1_spr_tp_cd",true);
							return false; 
						}  
						
						//4 Date를 빈값에 대한 체크를 수행 한다.    				
						var strSplInput =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_spl_dt")," ");
						var strChgInput =ComTrimAll(sheetObj.CellValue(i, "sheet1_dchg_dt")," ");
						var strChkInput =ComTrimAll(sheetObj.CellValue(i, "sheet1_spr_chk_dt")," ");
						if(strSplInput=="" && strChgInput=="" && strChkInput=="")
						{
							ComShowCodeMessage("MNR00172"," One Of Supply Date,Discharge Date,Check Date");
							sheetObj.SelectCell(i, "sheet1_spr_spl_dt",true);
							return false; 
						}    				
					}
				}
			
				//조회시
				else if(sAction==IBSEARCH)
				{
					var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
					if(sRow != "") // sheet 수정내용 있음
					{                               	
						if(!ComShowCodeConfirm("MNR00007"))
						{
							return false;
						}
					}
				}
			}
			return true;
    }

    function setPopUpParam_COM_ENS_081(array) {

    	if(array == null)return;
    	var formObj = document.form;
    	var str = array + "";
    	var arr = str.split(",");
 
    	formObj.vsl_slan_cd.value = arr[3];
    }     
    
    function setPopUpParamSheet_COM_ENS_081(array) {

    	if(array == null)return;
    	var formObj = document.form;
    	var str = array + "";
    	var arr = str.split(",");
 
    	sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_lane_cd") = arr[3];
    }

    function setPopUpParam_COM_ENS_0A1(array) {
    	if(array == null)return;
    	var str = array + "";	
    	var arr = str.split(',');
    	var Row=sheetObjects[0].SelectRow;
    	sheetObjects[0].CellValue2(Row,"sheet1_vsl_cd")=arr[3];
		var checkVsl=sheetObjects[0].CellValue(Row,"sheet1_vsl_cd");
		sheetObjects[0].CellValue2(Row,"sheet1_vsl_cd")=checkVsl.toUpperCase();
		checkVsl=checkVsl.toUpperCase();

		//맞는 EQ_NUMBER Equipment Information 를 표시한다.
		setVesselInfo(sheetObjects[1],Row,checkVsl);	
    }  	
	
	function setVesselInfo(sheetObj,Row,vsl_cd){
		var formObj = document.form;
		var sXml = MnrComVesselInfoSearch(sheetObj,vsl_cd);
		var retArr =  MnrXmlToArray(sXml); 
		//0vsl_eng_nm|1 ibflag|2 skd_dir_cd| 3 skd_voy_no|4 pagerows|5 vsl_slan_cd|6 vsl_cd|
		//0 imm_ext|1 mvmt_dt|2 dv_cur|3 rpr_yd|4 sp_name|5 flg_rmk|6 manu_dt|7 pagerows|8 dv_value|9 ibflag|10 off_hire|11 mvmt_cd|12 dsp_flag|13 hngr_flg_yd|14 lessor_nm|15 hngr_rck_cd|16 crnt_yd_cd|17 lstm_cd|18 eq_no|19 hngr_flg_dt|20 bar_atch_knt|21 status|22 bar_tp_cd|23 dmg_flag|24 cost|25 eq_type|26 rpr_type|27 eq_tpsz_cd|28 rpr_dt						
		if(retArr != null){  
			//TpSz	
			sheetObjects[0].CellValue2(Row,"sheet1_vsl_eng_nm")=retArr[0][0];
			sheetObjects[0].CellValue2(Row,"sheet1_lane_cd")=retArr[0][5];
			//Lane	
			if(retArr[0][5]=="")
			{
				ComShowCodeMessage("MNR00254",vsl_cd + " of Veseel Code","Lane");
				//Vessel Name	
				sheetObjects[0].CellValue2(Row,"sheet1_vsl_eng_nm")="";
				//Lane	
				sheetObjects[0].CellValue2(Row,"sheet1_lane_cd")="";
				sheetObjects[0].CellValue2(Row,"sheet1_vsl_cd")="";     
				sheetObjects[0].SelectCell(Row,"sheet1_vsl_cd"); 
			}
			
			sheetObjects[0].SelectCell(Row,"sheet1_spr_tp_cd");  

		} else {	  
			
			//TpSz	
			sheetObjects[0].CellValue2(Row,"sheet1_vsl_eng_nm")="";
			//Lane	
			sheetObjects[0].CellValue2(Row,"sheet1_lane_cd")="";

			ComShowCodeMessage("MNR00165",vsl_cd,"Vessel Code");          				
			sheetObjects[0].CellValue2(Row,"sheet1_vsl_cd")="";     
			sheetObjects[0].SelectCell(Row,"sheet1_vsl_cd");  

		}	
		MnrWaitControl(false);
		calReq=0;
	}		