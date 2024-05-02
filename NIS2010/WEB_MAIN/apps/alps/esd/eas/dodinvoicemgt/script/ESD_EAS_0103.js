/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0103.jsp
*@FileTitle : EAS Payer Info & Fax/E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.11 KIM HYUN HWA
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
     * @class ESD_EAS_0100 Payer 정보 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0103() {
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

	var ROWMARK = "|";
	var FIELDMARK = "=";
	

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		
		/*******************************************************/
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
	    		case "btn_rowadd":
		        	if(ComIsBtnEnable(srcName)) {
		        		doActionIBSheet(sheetObject1,formObject,IBINSERT);
		        	}
					break;
	
					
				case "btn_rowdel":
					if(ComIsBtnEnable(srcName)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;    		
    		
				case "btn2_save":
					if(ComIsBtnEnable(srcName)) {
					
// 권한 check 안함.
//		        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
//		        			ComShowCodeMessage("DMT01145", "Save");
//		        			return;
//		        		}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					break;
					
                case "btn2_new":
                	initControl();
                    break;  
                     
                case "btn2_close":
                	
                	window.close();
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
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++] = combo_obj;  
	} 


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

    	var formObj = document.form;
    	
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        initControl();
        
    }

	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 * 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form;
   	    
   	    switch(comboObj.id) {  
   	    	case "payer_name": 
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = false;	
   					SetColAlign("center|left|left");        
  					SetColWidth("40|110|350");
  					DropHeight = 160;
  					MaxLength = 45; 
   		    	}
   				//doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST01);
   	    		doActionIBCombo(sheetObjects[1],formObj,IBSEARCH,SEARCHLIST01,"PAYER_NAME",comboObj);
   				break; 
   				
   	    	case "payer_addr":
   	    		with (comboObj) { 
   					MultiSelect = false;
   					UseAutoComplete = false;	

   					SetColAlign("center|left|left|center");        
					SetColWidth("40|110|600|0");
   					
					DropHeight = 160;
   		    	}
   	    		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH,SEARCHLIST02, "PAYER_ADDR",comboObj);
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
                    style.height =142;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //var HeadTitle = "|Seq.|ATTN|Tel.|Fax|E-mail|Sheet|Send|cust_cntc_pnt_seq";
                    var HeadTitle = "|Seq.|ATTN|Tel.|Fax|E-mail|Sheet|cust_cntc_pnt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,					KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,			daCenter,   false,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,			daCenter,	false,		"SEQ");
					InitDataProperty(0, cnt++ , dtComboEdit,	160,		daLeft,		false,		"cntc_pnt_nm",			false,		"",			dfNone,		0,			true,		true,		45);
					InitDataProperty(0, cnt++ , dtComboEdit,	170,		daLeft,		false,		"cntc_pnt_phn_no",		false,		"",			dfNone,		0,			true,		true,		20);	
					                               
					InitDataProperty(0, cnt++ , dtComboEdit,	170,		daLeft,   	false,		"cntc_pnt_fax_no",		false,		"",			dfNone,		0,			true,		true,		20);	
					InitDataProperty(0, cnt++ , dtComboEdit,	150,		daLeft,		false,		"cntc_pnt_eml",		false,		"",			dfNone,		0,			true,		true,		50);
					InitDataProperty(0, cnt++ , dtRadioCheck,	40,			daCenter,	false,		"sheet",    				false,		"",			dfNone,		0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtData,	  	40,			daCenter,	false,		"cust_cntc_pnt_seq");
					
					
					//기존 데이터 수정이 불가능하여 validation 없앰
					//InitDataValid(0,"payr_cntc_pnt_phn_no"	, vtNumericOther, ".-");
					//InitDataValid(0,"payr_cntc_pnt_fax_no"	, vtNumericOther, ".-");
					//InitDataValid(0,"payr_cntc_pnt_eml"		, vtEngOther, "@.-_0123456789");
					
					Ellipsis = true;
					
					CountPosition = 0;
                }
                break;
                
             case 2:
             	with (sheetObj) {
                     // 높이 설정
                     style.height = 102;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 }
                 break;
                
        }
    }
    /**
     * 예)doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST01,"PAYER_NAME",comboObj);	//Multi combo
     *    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST03,"PAYER_CNTC_PNT_NM");		//Grid combo
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @param sComboAction
     * @param sComboKey
     * @param sObj
     * @return
     */
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
    	sheetObj.ShowDebugMsg = false;
    	sheetObj.WaitImageVisible = false;
    	var formObj = document.form;
    	
    	switch(sAction) {
    	
    		case IBSEARCH:
    			if (sheetObj.id == "sheet2") {
					
					//3.조회후 결과처리
					var comboDatas;
					var comboItems;
    				
    				switch(sComboAction) {
						case SEARCHLIST01:	//PAYR_NAME LIST
		    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						
							ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("ESD_EAS_0103GS.do", FormQueryString(formObj));
							
							comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem(sObj,comboItems);						
							break;	
							
						case SEARCHLIST02:	//PAYR_ADDRESS LIST
		    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST02);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("ESD_EAS_0103GS.do", FormQueryString(formObj));
							
							comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							
							addComboItem2(sObj,comboItems);						
							break;	
    				}
						
    			}else if(sheetObj.id == "sheet1") {
					//3.조회후 결과처리
					var comboDatas;
					var comboItems;
    				
    				switch(sComboAction) {
						case SEARCHLIST03:	//ATTN	
		    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST03);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("ESD_EAS_0103GS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"cntc_pnt_nm");
							break;
							
						case SEARCHLIST04:	//TEL
		    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST04);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("ESD_EAS_0103GS.do", FormQueryString(formObj));
                           
							comboDatas = ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"cntc_pnt_phn_no");
							break;
							
						case SEARCHLIST05:	//FAX
		    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST05);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("ESD_EAS_0103GS.do", FormQueryString(formObj));
	
							comboDatas = ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"cntc_pnt_fax_no");
							break;
							
						case SEARCHLIST06:	//EMAIL
		    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST06);
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("ESD_EAS_0103GS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, sComboKey);
							addCellComboItem(sheetObj,comboDatas,"cntc_pnt_eml");
							break;
    				}
    			}
    			
    		break;
    	
    	}
    	sheetObj.WaitImageVisible = true;
    }
    
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[2]);	
    	}   		
	}
    
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[1]);
    	}   		
	}
	
	function addComboItem2(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[2]);
    	}   		
	}
    

	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다.
	 * @param sheetObj		SHEET
	 * @param comboDatas	ETCDATA
	 * @param colName		컬럼이름
	 * @return
	 */
	function addCellComboItem(sheetObj,comboDatas, colName){
		var comboTxt = "";
		var comboVal = "";
		var tempVal = "";
		
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems = comboDatas.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);//데이터 space,space,space
				
				if (comboItem[0] == undefined || comboItem[0] == ""){
					comboTxt += " \t \t";
					comboVal += " ";
				}else{
					comboTxt += comboItem[0] + "\t" + comboItem[1] + "\t" + comboItem[2];
					comboVal += comboItem[2];
				}
				
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}
			}
		}else{
			comboTxt += " \t \t";
			comboVal += " ";
		}
		sheetObj.InitDataCombo(0,		colName,	comboTxt,	comboVal,	"",				"",			2);//
	}
	
	//Payer 선택 이벤트
	function payer_addr_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		
		ComSetObjValue(formObj.cust_addr, comboObj.Code);
	}
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					if (validateForm(sheetObj,formObj,sAction)) {
						sheetObj.DoSearch("ESD_EAS_0103GS.do", FormQueryString(formObj));
						ComEtcDataToForm(formObj, sheetObj);
						
						//DEFALUT CHECK - SHEET, SEND(ATTN, TEL, FAX, E-MAIL
						
						var attn 	= ComGetObjValue(formObj.cntc_pnt_nm);
						var tel		= ComGetObjValue(formObj.cntc_pnt_phn_no);
						var fax		= ComGetObjValue(formObj.cntc_pnt_fax_no);
						var email	= ComGetObjValue(formObj.n1st_eml);
						
						// 앞화면에서 넘어온 값
						var p_attn 	= ComGetObjValue(formObj.s_attn);
						var p_tel	= ComGetObjValue(formObj.s_telno);
						var p_fax	= ComGetObjValue(formObj.s_faxno);
						var p_email	= ComGetObjValue(formObj.s_email);
						var p_cnt_cpnt_seq	= ComGetObjValue(formObj.s_cnt_cpnt_seq);

						var checkOk = false;
  
						// 앞에서 넘어온 값으로 먼저 체크한다.
						for(var i = 1; i < sheetObj.TotalRows+1 ; i++) {
					
							if(p_cnt_cpnt_seq == sheetObj.CellValue(i, "cust_cntc_pnt_seq")	) {
								sheetObj.CellValue2(i, "sheet") = 1;
								checkOk = true;
								
								break;
							}
						}
						
						// 앞에서 넘어온 값이 없으면 Payer Info 정보로 체크를 한다.
						if(!checkOk) {
						
							for(var i = 1; i < sheetObj.TotalRows+1 ; i++) {
								if(attn == sheetObj.CellValue(i, "cntc_pnt_nm") 
										&& tel == sheetObj.CellValue(i, "cntc_pnt_phn_no")
										&& fax == sheetObj.CellValue(i, "cntc_pnt_fax_no")
										&& email == sheetObj.CellValue(i, "cntc_pnt_eml")) {
									sheetObj.CellValue2(i, "sheet") = 1;

									break;
								}
							}
						}
					}
				}
				break;
			
        	case IBINSERT:	//Row Add
				if (sheetObj.id == "sheet1") { 
					sheetObj.DataInsert(-1);
				}        		
        		break;
        		
				
			case IBDELETE:	//Row Delete
				if (sheetObj.id == "sheet1") {
					if(sheetObj.CellValue(sheetObj.SelectRow, "sheet") == "1") {
						ComShowCodeMessage("EAS80006");
						return;
					}
					
					if (sheetObj.RowStatus(sheetObj.SelectRow) == 'I') {
						sheetObj.RowDelete(sheetObj.SelectRow , false);
					}
					else {
						sheetObj.RowStatus(sheetObj.SelectRow) = 'D';
						sheetObj.RowHidden(sheetObj.SelectRow) = true;
					}
				}
				break;
			
			case IBSAVE:
				ComSetObjValue(formObj.f_cmd, MULTI);
				setParameters(MULTI);
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				//Fax/E-mail의 체크 내용을 Invoice Sheet로 저장시킨다.
				var attn = "";
				var tel = "";
				var fax = "";
				var email = "";
				
				for(var i = 1; i< sheetObj.RowCount +1; i++ ){
					
					if(sheetObj.CellValue(i, "sheet") == "1") {
						attn 	= sheetObj.CellValue(i, "cntc_pnt_nm");
						tel 	= sheetObj.CellValue(i, "cntc_pnt_phn_no");
						fax 	= sheetObj.CellValue(i, "cntc_pnt_fax_no");
						email 	= sheetObj.CellValue(i, "cntc_pnt_eml");
						
						break;
					}
				}
				ComSetObjValue(formObj.cntc_pnt_nm, attn);
				ComSetObjValue(formObj.cntc_pnt_phn_no, tel);
				ComSetObjValue(formObj.cntc_pnt_fax_no, fax);
				ComSetObjValue(formObj.n1st_eml, email);
			
				
				var sParam1 = sheetObj.GetSaveString(true);
				
				sParam1 = ComSetPrifix(sParam1, "cntc_pnt");
			
				
				var sParam = sParam1 + "&"+FormQueryString(formObj);
				
                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
				
				var sXml = sheetObj.GetSaveXml("ESD_EAS_0103GS.do", sParam);
				//3.저장 후 결과처리
				sheetObj.LoadSaveXml(sXml);
                //ComOpenWait End
                ComOpenWait(false);
				
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				
				//4.저장 후 재조회 처리
				if(ComGetObjValue(formObj.success_yn) == "Y") {
					initControl();
					var attn 	= ComGetObjValue(formObj.cntc_pnt_nm);
					var tel		= ComGetObjValue(formObj.cntc_pnt_phn_no);
					var fax		= ComGetObjValue(formObj.cntc_pnt_fax_no);
					var email	= ComGetObjValue(formObj.n1st_eml);
					//선택한 값으로 sheet, send 셋팅
					for(var i = 1; i < sheetObj.TotalRows+1 ; i++) {
						if(attn == sheetObj.CellValue(i, "cntc_pnt_nm") 
								&& tel == sheetObj.CellValue(i, "cntc_pnt_phn_no")
								&& fax == sheetObj.CellValue(i, "cntc_pnt_fax_no")
								&& email == sheetObj.CellValue(i, "cntc_pnt_eml")) {
							sheetObj.CellValue2(i, "sheet") = 1;

							break;
						}
					}			

					
				}
				
				break;		

        }
    }
    
	//sheet 선택시 자동으로 send 선택 기능 추가
//    function sheet1_OnClick(sheetObj, row, col, Value){
//    	var formObj = document.form;
//    	
//    	if(sheetObj.ColSaveName(col) == "sheet") {
//    		if(Value == 0) {//클릭시 이벤트가 발생하므로 체크전의 값으로 확인됨
//    			sheetObj.CellValue(row, "send") = 1;
//    		}
//    	}
//    }	
    
    
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		if(sAction == MULTI) {
			ComSetObjValue(formObj.payr_nm, comboObjects[0].Text);
		}
	}
	
	/*
	 * 초기화
	 */
	function initControl(){
		var formObj = document.form;
		
		//combo박스 초기화
		comboObjects[0].Code = "-1";
        comboObjects[0].RemoveAll();
        comboObjects[1].Code = "-1";
        comboObjects[1].RemoveAll();

   		//ATTN 조회 후 콤보에 조회된 결과 설정
       doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST03,"PAYER_CNTC_PNT_NM");

   		//TEL 조회 후 콤보에 조회된 결과 설정
        doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST04,"PAYER_PHN_NO");
      //  alert("3");
        //FAX 조회 후 콤보에 조회된 결과 설정
        doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST05,"PAYER_FAX_NO"); 
      //  alert("4");
   		//EMAIL 조회 후 콤보에 조회된 결과 설정
       doActionIBCombo(sheetObjects[0], formObj,IBSEARCH,SEARCHLIST06,"PAYER_EMAIL");
      //  alert("5");
        //Main 조회
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
	 	// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
        //Name 조회 후 콤보에 조회된 결과 설정
        comboObjects[0].Text = ComGetObjValue(formObj.payr_nm);
        //Addr 조회 후 콤보에 조회된 결과 설정
        comboObjects[1].Code = ComGetObjValue(formObj.cust_addr);
        
        //ofc_cd setting
        ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.s_ofc_cd));
        
        //초기 SENDING 값 셋팅
//        for(var i = 1; i < sheetObjects[0].TotalRows+1 ; i++) {
//			if(sheetObjects[0].CellValue(i, "payr_cntc_pnt_fax_no") != ""  
//					|| sheetObjects[0].CellValue(i, "payr_cntc_pnt_eml") != "" 
//					) {
//				
//				sheetObjects[0].CellValue2(i, "send") = 1;
//			}
//		}
	}


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){

    		switch(sAction) {
    			case IBSAVE:
    				//1. ATTN, TEL, FAX, EMAIL이 동일하면 저장시 에러 처리를 한다.
    				for( var i = 1; i < sheetObj.RowCount + 1; i++) {
    					var pnt_nm = sheetObj.CellValue(i, "cntc_pnt_nm");
    					var phn_no = sheetObj.CellValue(i, "cntc_pnt_phn_no");
    					var fax_no = sheetObj.CellValue(i, "cntc_pnt_fax_no");
    					var eml    = sheetObj.CellValue(i, "cntc_pnt_eml");
    					
    					for( j = i+1 ; j < sheetObj.RowCount + 1 ; j++) {
    						if(pnt_nm == sheetObj.CellValue(j, "cntc_pnt_nm") 
    								&& phn_no == sheetObj.CellValue(j, "cntc_pnt_phn_no")
    								&& fax_no == sheetObj.CellValue(j, "cntc_pnt_fax_no")
    								&& eml    == sheetObj.CellValue(j, "cntc_pnt_eml")
    									) {
    							ComShowCodeMessage("EAS80005", j);
    							return false;
    						}
    					}
    				}
    				//1. ATTN, TEL, FAX, EMAIL이 동일하면 저장시 에러 처리를 한다.
//    				var dupRow = sheetObj.ColValueDup("payr_cntc_pnt_nm|payr_cntc_pnt_phn_no|payr_cntc_pnt_fax_no|payr_cntc_pnt_eml", false);
//    				
//    				if(dupRow != -1 ) {
//    					ComShowCodeMessage("DMT00188", dupRow);
//    					return false;
//    				}
    				
    				//2. ADDR 자릿수 체크
    				if(ComGetLenByByte(ComGetObjValue(formObj.cust_addr)) > 100) {
    					ComShowCodeMessage("COM131901", "Address");
    					return false;
    				}
    				
    				//3. ATTN, TEL, FAX, EMAIL 전부다 공백이면 해당ROW는 저장되지 않게 한다.
    				for( var i = 1; i < sheetObj.RowCount + 1; i++) {
    					if(sheetObj.CellValue(i, "payr_cntc_pnt_nm") == "" 
    							&& sheetObj.CellValue(i, "payr_cntc_pnt_phn_no") == ""
    							&& sheetObj.CellValue(i, "payr_cntc_pnt_fax_no") == ""
    							&& sheetObj.CellValue(i, "payr_cntc_pnt_eml") == ""
    							) {
    						sheetObj.RowStatus(i) = "R";
    					}
    				}
    				
    				
    				break;
    		}
        }		

        return true;
    }
     
	function unLoadPage() {
		if ( document.form.jspno.value == "ESD_EAS_0100" ) {
     		if(document.form.success_yn.value == "Y") {
     		
                var opener = window.dialogArguments;
                var rtnValFax = "";
                var rtnValEmail = "";
                var cntc_pnt_nm = "";
                var cntc_pnt_seq = "";
                var fax_cnt = 0;
                var email_cnt = 0;
                
                for ( var i = 1 ; i < sheetObjects[0].RowCount+1 ; i++ ) {
             	   var cntc_fax_no 		= ComTrim(sheetObjects[0].CellValue( i ,  "cntc_pnt_fax_no" ));
             	   var cntr_email_no 	= ComTrim(sheetObjects[0].CellValue( i ,  "cntc_pnt_eml" ));
             	   

                    if ( sheetObjects[0].CellValue( i , "sheet" ) == 1 ) {
                 	   cntc_pnt_nm = sheetObjects[0].CellValue( i , "cntc_pnt_nm" );
                 	   cntc_pnt_seq = sheetObjects[0].CellValue( i , "cust_cntc_pnt_seq" );
                    }
                    
                }
                
                opener.getPayerInfoData(rtnValFax, rtnValEmail, cntc_pnt_nm, cntc_pnt_seq);
                
     		}
         }
     }
