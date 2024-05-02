/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0036.js 
*@FileTitle : Document Transmision
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.03 함형석
* 1.0 Creation  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * 
     * @author 한진해운  
     */ 
										
    /**
     * @extends  
     * @class EES_MNR_0036 : EES_MNR_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0036() {
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

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

var workOrderType = "";

var transmissionTypeText = " |";
var transmissionTypeCode = " |";

var transmissionTypeNotEDIText = " |";
var transmissionTypeNotEDICode = " |";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];

		var rdObject = rdObjects[0];

		/*******************************************************/
		var formObject = document.form;

    	try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Print":
					printRd(rdObjects[0]);
					break;

				case "btn_DOCSend":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                	break;

				case "btn_Close":
					window.close();
                	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		initRdConfig(rdObjects[0]);
		

		//sheetObj.WaitImageVisible = false;
		
		var formObject = document.form;
		var tempText = mnrOrdSeq.split("|"); 
		var mnr_ord_seq="";
		var mnr_ord_ofc_cty_cd="";
		
		for(var j = 0; j < tempText.length;j++){ 
			if(j>0){
				mnr_ord_seq += "," + tempText[j].substr(3, tempText[j].length);
				mnr_ord_ofc_cty_cd += "," + tempText[j].substr(0, 3);
			}else{
				mnr_ord_seq += tempText[j].substr(3, tempText[j].length);
				mnr_ord_ofc_cty_cd += tempText[j].substr(0, 3);
			}
		}

		formObject.mnr_ord_seq.value = mnr_ord_seq;
		formObject.mnr_ord_ofc_cty_cd.value = mnr_ord_ofc_cty_cd;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		
		//sheetObj.WaitImageVisible = true;
		MnrWaitControl(false);
				
    }

  	/**
     * RD 초기설정값
     * @param	{RdObject}	rdObject	프로세스 처리될 RD오브젝트 
     */
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = true;
		Rdviewer.HideToolbar();
		Rdviewer.HideStatusBar();
		Rdviewer.ViewShowMode(0);
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 82;
                    
					//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle = "|Sel|Seq.|W/O No|W/O Type|Service Provider|Transmission Type|DOC Subject|E-mail|Memo|Fax";
					var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount + 3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
                    
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"sel",				true,		"",				dfNone,		0,			true,		true);
                    InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"Seq");
                    InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"mnr_ord_seq",		true,      	"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"wo_type",			true,      	"",				dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,		"vndr_lgl_eng_nm",	true,      	"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		130,	daCenter,	true,		"trsm_mod_cd",		true,      	"",				dfNone,		0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,			160,	daLeft,		true,		"doc_subject",		true,      	"",				dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"mnr_prnr_eml",		false,     	"",				dfNone,		0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"memo",				false,     	"",				dfNone,		0,			true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		true,		"fax_no",			false,     	"",				dfNone,		0,			true,		true);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"wo_type_code",		true,      	"",				dfNone,		0,			false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"edi_id",			true,      	"",				dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"mnr_grp_tp_cd",	true,      	"",				dfNone,		0,			false,		false);
                   
					InitDataValid(0,  "mnr_prnr_eml", vtEngDnOther,"0123456789@.-_;");
					
					CountPosition = 0;
          		}
                break;
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
    * sheet1에서 클릭이벤트를 처리한다.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
		
		if (Col == "2" || Col == "3" || Col == "4" || Col == "5"){	
			rdView(sheetObj,Row);
		}
	}

   /**
    * sheet1에서 SaveEnd이벤트를 처리한다.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){  
		if(sheetObjects[0].RowCount>0){
	    	for(i=sheetObjects[0].LastRow; i > 0 ; i--){
				if(sheetObj.CellValue(i, "wo_type_code")!="EST"){
				  sheetObj.CellComboItem(i, "trsm_mod_cd", transmissionTypeNotEDIText, transmissionTypeNotEDICode, 0) 
				}
	    	}
			rdView(sheetObjects[0],"1");
		}	 	       
	}
	
   /**
    * sheet1에서 SaveEnd이벤트를 처리한다.
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") { 		   
			ComShowCodeMessage("MNR00075"); 
			
			//모든 Work Order를 다 보냇다면 자동으로 닫힌다. 
			var isSelfClose = "Y";
			for(var x = 1 ; x <= sheetObj.RowCount;x++){  
				if(sheetObj.CellValue(x,"sel") == "0"){
					isSelfClose = "N";	
				}				
			}	 
			 	
			if(isSelfClose == "Y"){ 
				window.close(); 
			}
		} else { 
			ComShowCodeMessage("MNR00076",ErrMsg);
		}			       
	}

  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;     
					var param = "f_cmd="  +  formObj.f_cmd.value + "&mnr_ord_seq=" + formObj.mnr_ord_seq.value + "&mnr_ord_ofc_cty_cd=" + formObj.mnr_ord_ofc_cty_cd.value; 
					sheetObj.DoSearch4Post("EES_MNR_0036GS.do",param);
				}	
				break;
					
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
					var param = "f_cmd="  +  formObj.f_cmd.value + "&mnr_ord_seq=" + formObj.mnr_ord_seq.value + "&mnr_ord_ofc_cty_cd=" + formObj.mnr_ord_ofc_cty_cd.value; 
					chksave=sheetObj.DoSave("EES_MNR_0036GS.do", param, -1, false); 
				}
				break;

			case IBCLEAR:        //초기화

				//공통콤보 정보를 가져온다.  
				
				var sCondition = new Array (
					//CSR : CHM-201538671, MNR W/O 전송 시 Transmission Code Fax 옵션 중지 관련 	
					//new Array("MnrGenCd","CD00016", "COMMON")	//Transmission Type						
					new Array("MnrGenCd","CD00097", "COMMON")	//Transmission Type (W/O). FAX 없음
				); 
					
				var comboList = MnrComSearchCombo(sheetObj,sCondition);   
					
				//콤보 설정
				for(var i = 0; i < comboList.length;i++){
					if(comboList[i] != null){
						//쉬트콤보별 초기화
						for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");
							
							//WO Type이 Estimate이 아닐때 EDI항목 제거하기 위해
							if(tempText[0]=="E"){
								transmissionTypeText += tempText[1] + "|";
								transmissionTypeCode += tempText[0] + "|";
							}else{
								transmissionTypeText += tempText[1] + "|";
								transmissionTypeCode += tempText[0] + "|";
								
								transmissionTypeNotEDIText += tempText[1] + "|";
								transmissionTypeNotEDICode += tempText[0] + "|";
							}
						}
						//Transmission Type
						if(i==0) {
							sheetObjects[0].InitDataCombo(0, "trsm_mod_cd", transmissionTypeText, transmissionTypeCode, transmissionTypeCode);
						}						
					}
				}
                break;
        }
    }
		
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) { 	
				case IBSAVE: 
					var chkYn="";
					if(sheetObjects[0].CellValue(i, "sel")=="1"){
						if (!ComChkValid(formObj)) return false;
					}
					for(var i = 1; i <= sheetObjects[0].rowcount;i++){
						if(sheetObjects[0].CellValue(i, "sel")=="1" && sheetObjects[0].CellValue(i, "trsm_mod_cd")=="M" && sheetObjects[0].CellValue(i, "mnr_prnr_eml")==""){
							ComShowCodeMessage("MNR00003");
							sheetObjects[0].SelectCell(i, "mnr_prnr_eml");
							return false;
						}
						if(sheetObjects[0].CellValue(i, "sel")=="1" && sheetObjects[0].CellValue(i, "trsm_mod_cd")=="F" && sheetObjects[0].CellValue(i, "fax_no")==""){
							ComShowCodeMessage("MNR00003");
							sheetObjects[0].SelectCell(i, "fax_no");
							return false;
						}	
						if(sheetObjects[0].CellValue(i, "sel")=="1" && sheetObjects[0].CellValue(i, "trsm_mod_cd")=="E" && sheetObjects[0].CellValue(i, "edi_id")==""){
							ComShowCodeMessage("MNR00036","EDI");
							return false;
						}		
						if(sheetObjects[0].CellValue(i, "sel")=="1" && sheetObjects[0].CellValue(i, "trsm_mod_cd")=="M"){
							if(ComIsEmailAddr(sheetObjects[0].CellValue(i, "mnr_prnr_eml"))==false){
								ComShowCodeMessage("MNR00036","EMAIL");
								return false;				
							}
						}		
						if(sheetObjects[0].CellValue(i, "sel")=="1"){
							chkYn = "1";
						}
					}	
					if(chkYn!="1"){
						ComShowCodeMessage("MNR00036","Work Order No");
        				return false;		
					}			
				 	break;	
			}		
        }
        return true;
    }

   /**
    * rd를 open한다
    * @param sheetObj
    * @param Row
    * @return
    */
	function rdView(sheetObj,Row) {
		var Rdviewer = rdObjects[0] ;
		var wo_no=sheetObj.CellValue(Row, "mnr_ord_seq");
		var memo=sheetObj.CellValue(Row, "memo");
		var subject=sheetObj.CellValue(Row, "doc_subject");
				
		var rdParam = '/rv mnr_ord_ofc_cty_cd['+ wo_no.substr(0, 3) +'] mnr_ord_seq['+ wo_no.substr(3, wo_no.length) +'] user_nm[' + self_usr_nm + '] memo[' + memo + '] subject[' + subject + ']';
		// 열고자 하는 RD 파일을 지정한다.
		//var RD_path2 = "http://localhost:7001/hanjin/";
		if(sheetObj.CellValue(Row, "wo_type_code")=="SPL"){
			Rdviewer.FileOpen(RD_path+'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0183.mrd', RDServer + rdParam);
		}else if(sheetObj.CellValue(Row, "wo_type_code")=="EXT"){
			Rdviewer.FileOpen(RD_path+'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0187.mrd', RDServer + rdParam);
		}else if(sheetObj.CellValue(Row, "wo_type_code")=="RFS"){
			Rdviewer.FileOpen(RD_path+'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0231.mrd', RDServer + rdParam);
		}else{
			Rdviewer.FileOpen(RD_path+'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd', RDServer + rdParam);
		} 
	}
  	/**
     * RD 인쇄 처리
     * @param	{RdObject}	rdObject	프로세스 처리될 RD오브젝트 
     */
	function printRd(rdObject){
	    var Rdviewer = rdObject ;
	    Rdviewer.PrintDialog (); //인쇄 대화상자 띄우고 인쇄
	}	