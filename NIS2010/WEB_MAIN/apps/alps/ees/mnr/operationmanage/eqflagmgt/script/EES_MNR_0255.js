/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_MNR_0255.js
*@FileTitle : Hanger Rack & Bar Installation/Removal Load Excel_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.14
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2011.09.14 신혜정
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
     * @class ees_mnr_0255 : ees_mnr_0255 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0255() {
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
	//검증작업을 한 데이타만 부모화면으로 이동가능
	var verifyCheck = false;
	var comboListGrid =new Array();
	var programId     = "";    

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
		        case "btn_new":  
                    doActionIBSheet(sheetObject1, formObject, IBCLEAR);
                    break;   

                case "btn_downExcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
				
                    break;          		     
 	 
                case "btn_loadExcel":
					doActionIBSheet(sheetObject1, formObject, IBLOADEXCEL);
				
                    break;          		     
 	 
		        case "btn_ok":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);					
					break;         
				
				case "btn_close":
					doActionIBSheet(sheetObject1, formObject, "doClose");
					break;
				
				//Verify
		        case "btn_retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH); 
                    break;        
				
		        case "btn_RowDel":
                    doActionIBSheet(sheetObject1, formObject, IBDELETE); 
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
    	//버튼 설정
    	MnrWaitControl(true);

		//set Opener Program Id
		programId = document.form.program_id.value;
		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+ 1);
            ComEndConfigSheet(sheetObjects[i]);
        }	
		//set SheetCombo
		setSheetCombo(sheetObjects[0]);
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param	{IBSheet}	sheetObj	초기설정될 시트오브젝트 
     * @param	{String}	sheetNo		시트오브젝트 태그의 아이디에 붙인 일련번호
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 350;
		
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 10, 100);

					var HeadTitle1 = "|Del|Seq.|EQ No.|TP/SZ|MVMT|Yard|Flag|Hanger Rack Type|Tariff Type|Tariff Desc|Hanger Bar\nType|Installation\nBar Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Remark(s)|Recently Worked\nInfomation|Inventory apply\nOffice|Verify Result";
					var HeadTitle2 = "|Del|Seq.|EQ No.|TP/SZ|MVMT|Yard|Flag|Hanger Rack Type|Tariff Type|Tariff Desc|Hanger Bar\nType|Installation\nBar Qty|Sound|Repairable|Missing|disposal|Remark(s)|Recently Worked\nInfomation|Inventory apply\nOffice|Verify Result";					

					var headCount = ComCountHeadTitle(HeadTitle1) + 6;
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,     40,	    daCenter,	 false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,  	true,  	"del_check",	false,  "", dfNone,			0,	true,	true);  			//del
					InitDataProperty(0, cnt++ , dtSeq,              30,     daCenter,    true,  "Seq");
					InitDataProperty(0, cnt++ , dtData,				80,	    daCenter,	 true,	"eq_no",						false,	"",		dfNone,			2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,	    daCenter,	 true,	"eq_tpsz_cd",					false,	"",		dfNone,			2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				50,		daCenter,	 true,	"mvmt_cd",						false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				70,		daCenter,	 true,	"mnr_hngr_flg_yd_cd",			false,	"",		dfNone,	    	2,			false,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,			40,		daCenter,	 true,	"mnr_hngr_flg",					false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			160,	daLeft,	 	 true,	"mnr_hngr_rck_cd",				false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			140,	daLeft,	     true,	"mnr_hngr_trf_cd",				false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				130,	daLeft,	   	 true,	"mnr_hngr_trf_otr_desc",		false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,			100,	daLeft,	     true,	"mnr_hngr_bar_tp_cd",			false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				100,	daRight,	 true,	"hngr_bar_atch_knt",			false,	"",		dfInteger,		2,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"act_invt_qty",					false,	"",		dfInteger,	    2,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"mnr_hngr_dmg_qty",				false,	"",		dfInteger,	    2,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"mnr_lost_hngr_qty",			false,	"",		dfInteger,	    2,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				70,		daRight,	 true,	"mnr_disp_hngr_qty",			false,	"",		dfInteger,	    2,			false,		false, 6);
					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,	     true,	"mnr_sts_rmk",					false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				110,	daLeft,	     true,	"wo_no",						false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,				100,	daLeft,	     true,	"cre_ofc_cd",					false,	"",		dfNone,	        2,			false,		false);
					InitDataProperty(0, cnt++ , dtData,     		200,    daLeft,      true, 	"verify_result",   				false, "",		dfNone,			0,	false,	false);				//Message Name
									
					//Hidden Col 
					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"eq_knd_cd",					false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"mnr_ord_ofc_cty_cd",			false,	"",		dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"mnr_ord_seq",					false,	"",		dfNone,			0,  		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"ofc_cd",						false,	"",		dfNone,			0,  		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"mnr_sts_flg",					false,	"",		dfNone,			0,  		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			100,	daCenter,	 false,	"copy_row_num",					false,	"",		dfNone,			0,  		false,		false);
										
					//SELECT 로우 배경색                  
					EditableColorDiff = false;     
					MultiSelection = true;                                    
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음            
					SelectHighLight = false;           
					//선택시 볼드 사용하지 않음             
					CountPosition = 0;
					//Grid Combo의 값에  맞지 않는 값이 들어올경우 Text로 보여줌.    
					InitComboNoMatchText(true);    
					
					PopupImage  =  "/hanjin/img/btns_search.gif";	 	 
					ShowButtonImage = 2;		 	 
					CountPosition = 2;					
                }
				break;

			default:
				break;
        }
    }

	/** 
	 * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 * @param    {IBSheet}	sheet_obj	배열로 등록될 IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			//초기화
			case IBCLEAR:	
				//버튼 ,프로그레스바 설정
				MnrWaitControl(true);
		    	sheetObj.RemoveAll();
				//버튼 ,프로그레스바 설정
				MnrWaitControl(false);
				break;

			//Load Excel
			case IBLOADEXCEL:
				var rtnLoad = sheetObj.LoadExcel(-1, 1, "", -1, 1002, "", false,false,"");
				if(!rtnLoad) {
					ComOpenWait(false);
					return;
				}  //취소
				  
				if(sheetObj.RowCount > 999){
					ComShowCodeMessage("MNR00366");
					sheetObj.CellValue(1001, "del_check")= "1";
					ComRowHideDelete(sheetObj, "del_check");
				}
				//no match combo 설정 
				setNoMatchCombo(sheetObj);
				break;
				
            //format down excel
			case IBDOWNEXCEL:
				sheetObj.RemoveAll();
				var Row = sheetObj.DataInsert(-1);
				sheetObj.Down2Excel(true, false,false,true, "", "/apps/alps/ees/mnr/operationmanage/eqflagmgt/xml/EES_MNR_0255_FORMAT.xml");
				sheetObj.CellValue(Row, "del_check")= "1";
				ComRowHideDelete(sheetObj, "del_check");				
			    break;			

			//OK
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)){
				   	formObj.mnr_flg_tp_cd.value = coMnrFlgHangerTypeCd;
					formObj.f_cmd.value = MULTI;	   
										
					var sParam = sheetObj.GetSaveString(false, false);	
					sParam = ComSetPrifix(sParam,"sheet1_");
						
					//멘덴토리 체크				
			    	if(sParam == "" && sheetObj.IsDataModified){
						return;	
					}
					
					if(!sheetObj.IsDataModified){
						return;	
					}			
					sParam += "&" + FormQueryString(formObj);		
					var sXml = sheetObj.GetSaveXml("EES_MNR_0109GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);
				}	
				break;
			
			//Close
			case "doClose":
				window.close();
				break;
			
			//Verify
			case IBSEARCH:				
				
				if(validateForm(sheetObj,formObj,sAction)) {
					
					formObj.f_cmd.value = SEARCH;
					var sParam = sheetObj.GetSaveString(true);
				
					sParam = ComSetPrifix(sParam,"sheet0_");
					if (sParam == ""){
						ComOpenWait(false);
						return;
					}
					
				    sParam += "&" + FormQueryString(formObj);
					var sXml = sheetObj.GetSaveXml("EES_MNR_0255GS.do", sParam);
				    sheetObj.LoadSearchXml(sXml);
					verifyCheck = true; 
					setNoMatchCombo(sheetObj); //no match combo 설정
				}				
				break;
			
			//행삭제
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
			    	MnrRowDelete(sheetObj, "del_check");
				}    
				break;
			
			default:
				break;
        }
    }

	/**
	 * 저장후 결과메세지 표시
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */
	//저장  버튼 클릭시 발생시킬 메세지 
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {			 	            
			ComShowCodeMessage("MNR00023",ErrMsg); // Data saved successfully.
			// 팝업 닫고, 부모창 New 이벤트, eq_no 넘겨 셋팅, Retrieve 이벤트 
			comPopupOK_190(sheetObj);
						
      	} else {  
      		ComShowCodeMessage("MNR00008",ErrMsg);            	
		}   
	}	       
    
	/**
	 * Verify 후 셀 색상 적용 및 delete 체크 선택
	 * @param errMsg
	 */
	function sheet1_OnSearchEnd(ErrMsg) {
		sheetObjects[0].ColBackColor("verify_result") = sheetObjects[0].rgbcolor(206,255,255);
		for(var i=sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
			
			if(sheetObjects[0].CellValue(i, "verify_result") == "SUCCESS") {	
				sheetObjects[0].CellFontColor(i, "verify_result") = sheetObjects[0].RgbColor(0, 0, 255);
			} else {
				sheetObjects[0].CellFontColor(i, "verify_result") = sheetObjects[0].RgbColor(255, 0, 0);
				
			}
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
			//Verify버튼 클릭시
			if(sAction==IBSEARCH) {
				//중복체크
				var Row = sheetObj.ColValueDup("eq_no", false);
				if(Row>0){
					ComShowCodeMessage("MNR00006",(Row - 1) + " row ");
					sheetObj.SelectCell(Row, "eq_no", true);  
					return false;
				}
			}
			//OK버튼 클릭시
			else if(sAction==IBSAVE) {	
				//Verify을 하지 않은 경우
				if(!verifyCheck){  
					ComShowCodeMessage("MNR00157");
					return false;          		 	  
				} 				
			    //Error Data 가 존재할때
		    	for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
		    		var verifyResult = sheetObj.CellValue(i, "verify_result");
		    		if(verifyResult != "SUCCESS") {
						//Verify 성공하지 못한 Data 가 존재합니다.
		    			ComShowCodeMessage("MNR00301");
		    			sheetObj.SelectCell(i, "verify_result"); 
		    			return false;
		    		}else{
		    			sheetObj.RowStatus(i) = "U";
		    		}
		    	}	
		    	
				for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
					if(sheetObj.RowStatus(i)=="U"){
						if(sheetObj.CellValue(i,  "mnr_hngr_rck_cd") == ""){
							ComShowCodeMessage("MNR00003","Hanger Rack Type");
							sheetObj.SelectCell(i, "mnr_hngr_rck_cd",true);
							return false;			
						}	
							
						if(sheetObj.CellValue(i,  "mnr_hngr_bar_tp_cd") == ""){
							ComShowCodeMessage("MNR00003","Hanger Bar Type");
							sheetObj.SelectCell(i, "mnr_hngr_bar_tp_cd",true);
							return false;	
						}	
						
						if(sheetObj.CellValue(i,  "mnr_hngr_trf_cd") == ""){
							ComShowCodeMessage("MNR00003","Mnr_Hngr_Trf_Cd");	
							sheetObj.SelectCell(i, "mnr_hngr_trf_cd",true);		
							return false;	
						}	
						
						if (sheetObj.CellValue(i,"mnr_hngr_flg") =="0") {	//제거인 경우에만 체크
							//install qty 체크
							var hngrBarAtchKnt = parseInt(sheetObj.CellValue(i,"hngr_bar_atch_knt")); 
							var actInvtQty = parseInt(sheetObj.CellValue(i,"act_invt_qty"));
							var mnrHngrDmgQty = parseInt(sheetObj.CellValue(i,"mnr_hngr_dmg_qty"));
							var mnrLostHngrQty = parseInt(sheetObj.CellValue(i,"mnr_lost_hngr_qty"));
							var mnrDispHngrQty = parseInt(sheetObj.CellValue(i,"mnr_disp_hngr_qty"));	
													
							if(hngrBarAtchKnt != (actInvtQty + mnrHngrDmgQty + mnrLostHngrQty + mnrDispHngrQty)){
								ComShowCodeMessage("MNR00356");					
								sheetObj.SelectCell(i, "act_invt_qty",true);			 
								return false;	
							}	
						} else {	
							if (sheetObj.CellValue(i,"hngr_bar_atch_knt") == "0") {
								ComShowCodeMessage("MNR00359");					
								sheetObj.SelectCell(i, "hngr_bar_atch_knt",true);				 
								return false;
							}			
						}	
					}
				}		
			}	
			//행삭제 버튼 클릭시
			else if(sAction==IBDELETE) {
				//DEL checkBox의 체크된 값이 하나도 없을때
				if(sheetObj.FindCheckedRow("del_check") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
			}
		}
        return true;
    }

/* ********* User Functions ************* */	
        
  	/**
     * 팝업 닫고, 부모창 New 이벤트, eq_no 넘겨 셋팅, Retrieve 이벤트 
     * @param	{IBSheet}	sheetObj	시트오브젝트 
     */
	function comPopupOK_190(sheetObj) {
		
		var frm = opener.document.form;
		
		// 부모창에 넘길 eqNoList 셋팅
		var eqNoList = "";	  
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){			
			if(sheetObj.CellValue(i,"verify_result") == "SUCCESS"){
				if(eqNoList != ""){	eqNoList += ",";}
				eqNoList += sheetObj.CellValue(i,"eq_no");
				
			}
		}
		
		// 부모창 eq no 에 셋팅
		frm.eq_list.value = eqNoList;
		// 부모창 조회 이벤트 함수 호출
		opener.setAterLoadExcel();
		window.close();
	}

	/**
	 * 쉬트의 콤보데이터들을 조회하고 세팅한다.
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setSheetCombo(sheetObj){
		//콤보 값 세팅			
		var sCondition = new Array (		 		 
			new Array("MnrGenCd","CD00092", "COMMON"),   //Tariff Type 
			new Array("MnrGenCd","CD00021", "COMMON"),   //Hanger Rack Type  
			new Array("MnrGenCd","CD00022", "COMMON")   //Hanger Bar Type 
		)						 			
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
														
		var sheetComboText = "";  
		var sheetComboCode = "";
		var sheetComboDefault = new Array();
		var comboSaveNames = new Array(); 
		comboSaveNames[0] = "mnr_hngr_trf_cd";	
		comboSaveNames[1] = "mnr_hngr_rck_cd";
		comboSaveNames[2] = "mnr_hngr_bar_tp_cd";	 	
      
		for(var i = 0; i < comboList.length;i++){ 
		 	if(comboList[i] != null){ 
				sheetComboText = ""; 
				sheetComboCode = "";	
				sheetComboDefault = "";
		 		for(var j = 0; j < comboList[i].length;j++){
					var tempText = comboList[i][j].split("|");    
					if(comboSaveNames[i] == "mnr_hngr_rck_cd" && tempText[0] == "A"){
						sheetComboDefault[i] = "R";
						continue;
					}	
											 
					sheetComboText +=  tempText[1] + "|";  
					sheetComboCode +=  tempText[0] + "|";  
					if(j == 0){	
						sheetComboDefault[i] = tempText[0];          	
					}
				}						
				sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
		     	sheetComboText = 	MnrDelLastDelim(sheetComboText); 
											
				sheetObjects[0].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault[i]);
			}				      
		}
	}

	/** 
	 * no match combo 설정
	 *      엑셀로드시 쉬트 콤보에 일치하지 않는 값이 들어올때 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function setNoMatchCombo(sheetObj) {
		sheetObj.Redraw = false;
		for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){        
			//no match combo 설정 
			var rckCd	= sheetObj.CellValue(i, "mnr_hngr_rck_cd");
			var trfCd 	= sheetObj.CellValue(i, "mnr_hngr_trf_cd");
			var barTpCd = sheetObj.CellValue(i, "mnr_hngr_bar_tp_cd");
			
			if(rckCd=="") {
				rckCd = sheetObj.CellText(i,"mnr_hngr_rck_cd");  
				sheetObj.CellValue2(i,"mnr_hngr_rck_cd") = rckCd; 
			}
			if(trfCd=="") {
				trfCd = sheetObj.CellText(i,"mnr_hngr_trf_cd");  
				sheetObj.CellValue2(i,"mnr_hngr_trf_cd") = trfCd; 
			}
			if(barTpCd=="") {
				barTpCd = sheetObj.CellText(i,"mnr_hngr_bar_tp_cd");  
				sheetObj.CellValue2(i,"mnr_hngr_bar_tp_cd") = barTpCd; 
			}
		}
		sheetObj.Redraw = true;
	}
	