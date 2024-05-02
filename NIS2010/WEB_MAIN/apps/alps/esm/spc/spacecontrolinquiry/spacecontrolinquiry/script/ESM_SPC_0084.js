/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0084.js
*@FileTitle : BSA INPUT
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2011.03.03 원종규
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
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
     * @class ESM_SPC_0084 : ESM_SPC_0084 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0084() {
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
    var comboObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var param    = "";
	var prefix = "sheet1_";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var sheetObj  = sheetObjects[0];
    	var formObj  = document.form;
    	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObj,formObj,IBSEARCH);
    				break;
    				
				case "btn_save":
					doActionIBSheet(sheetObj, formObj, IBSAVE);					
					break;
					
				case "btn_vvd":
					var vslCd = ComGetObjValue(formObj.vsl_cd);
					var sUrl = "";
	
					if (vslCd == "") {
						sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
						ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
					} else {
						sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslCd;
						ComOpenPopup(sUrl, 335, 425, "setCallBackVVD", "0,0", true);
					}
					break;	
				
				case "t1btn_RowAdd":
					var row = sheetObj.DataInsert(-1); // -1은 가장 밑에 줄에 row 추가	
					sheetObj.CellValue2(row, prefix+"trd_cd") 		= formObj.trd_cd.Code;
					sheetObj.CellValue2(row, prefix+"sub_trd_cd") 	= formObj.sub_trd_cd.Code;
					sheetObj.CellValue2(row, prefix+"vsl_cd") 		= formObj.vsl_cd.value;
					sheetObj.CellValue2(row, prefix+"skd_voy_no") 	= formObj.skd_voy_no.value;
					sheetObj.CellValue2(row, prefix+"skd_dir_cd") 	= formObj.skd_dir_cd.value;

					//sheetObj.SelectCell(row, prefix+"pod_cd");
		 			
					break;
	
				case "t1btn_Delete":
					ComRowHideDelete(sheetObj, prefix+"del_chk");

					break;				
				
				case "btn_close":
					window.close();
					break;	

    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
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
     * IBSheet Object를 배열로 등록
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
    	SpcSearchOptionTrade("trd_cd", true, true);
    	SpcSearchOptionSubTrade("sub_trd_cd", true, true);
    	
    	// IBMultiCombo초기화
 		for ( var k = 0; k < comboObjects.length; k++) {
 			initCombo(comboObjects[k], k + 1);
 		} 

    	for(i=0;i<sheetObjects.length;i++) {
    		//시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	var sheetResizeFull = true;
    	document_onresize();   	
   	
    	//Axon Event Listener 등록
		initControl();
    	//ComSetFocus(document.form.trd_cd); 	
    }
     
 	/**
 	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 	 **/
 	function initControl() {
 		var formObj = document.form;
 		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
 		axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
 		axon_event.addListenerForm  ('change',   'obj_change',   form);
 		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
 		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
 		
 		formObj.trd_cd.focus();
 		UF_afterRetrieve("N");
 	} 
 	
	/**
	 * 필수 입력후 자동 다음 포커스 OnKeyUp 이벤트 처리 <br>
	 **/
	function obj_keyup() {
		 if(event.keyCode != 9) obj_nextfocus(event.srcElement);
	}

	//인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {

		var formObj = document.form;
		
		var objMaxLength = obj.getAttribute("maxlength");
		var objValue     = obj.getAttribute("value");
		
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			if (obj.name == 'skd_dir_cd') document.all.noname.focus();
			else ComSetNextFocus(obj);
			
			if (obj.name == 'vsl_cd') {
				ComSetObjValue(formObj.skd_voy_no, "");
				ComSetObjValue(formObj.skd_dir_cd, "");
			} else if (obj.name == 'skd_voy_no') {
				ComSetObjValue(formObj.skd_dir_cd, "");
			}
		}
		
	}
	
	/**
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
	 **/
	function obj_blur() {
		var formObj  = document.form;
		ComChkObjValid(event.srcElement);
		
		with (event.srcElement) {	
			switch (name) {	
				case "skd_dir_cd":	
					if (value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {						
						//VVD Info 가져오기
						searchVVDInfo();
					}		
					
					break;
					
				default:
					break;
			}
		}
	} 
	
	/**
	 * VVD 정보 조회 <br>
	 **/
	function searchVVDInfo() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		var comboObj = comboObjects[0];
		
		//관련항목 초기화
		resetForCondition(formObj, "ALL");
	
		formObj.f_cmd.value = SEARCH05;
		
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));		
		var vvdData = ComXml2Array(sXml, "vsl_eng_nm|vsl_slan_cd|vsl_slan_nm");

		if (vvdData == null) {
			ComShowCodeMessage("COM132201", 'Data');
			
			//관련항목 초기화
			resetForCondition(formObj, "ALL");
			ComSetObjValue(formObj.vsl_cd,     "");
			ComSetObjValue(formObj.skd_voy_no, "");
			ComSetObjValue(formObj.skd_dir_cd, "");
			
			//포커스 이동
			ComSetFocus(formObj.vsl_cd);
		} else {			
			//ComSetObjValue(formObj.vsl_eng_nm,  vvdData[0][0]);
			//ComSetObjValue(formObj.slan_cd,     vvdData[0][1]);
			//ComSetObjValue(formObj.slan_nm,     vvdData[0][2]);
			
			//POL 가져오기
			/* 
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_SPC_0080GS.do", FormQueryString(formObj));
			var sPol = ComGetEtcData(sXml, "sPol");
			
			if (sPol != undefined) {
				var arrPol = sPol.split("|");
				var polCd = ""; //yd_code + clpt_ind_seq
				
				for (var cCt=0; cCt<arrPol.length; cCt++) {
					polCd = arrPol[cCt];
					if(polCd != '') polCd = polCd.substring(0, polCd.length-1); 
					comboObj.InsertItem(cCt, polCd, arrPol[cCt]);
				}
			}*/

			//포커스 이동
			ComSetFocus(formObj.btn_Retrieve);

		}
		sheetObj.WaitImageVisible = true;
	}
	 
    /**
	 * VVD/POL 변경시 관련항목 초기화 <br>
	 **/
	function resetForCondition(formObj, what) {	
		//var comboObj = comboObjects[0];
		
		//VVD
		if(what.indexOf("ALL") != -1) {			
				//ComSetObjValue(formObj.vsl_eng_nm, "");
				//ComSetObjValue(formObj.slan_cd,    "");
				//ComSetObjValue(formObj.slan_nm,    "");	
				
				for (var sheetCt=0; sheetCt<sheetObjects.length; sheetCt++) {	
					sheetObjects[sheetCt].RemoveAll();
				}
				UF_afterRetrieve("N");
		} 
	} 
	
	/**
	 * 조회조건 입력시 Validation <br>
	 **/
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
			case "engup":
				switch (event.srcElement.name) {
					case "vsl_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;
					case "skd_voy_no":
						//숫자입력하기
						ComKeyOnlyNumber(event.srcElement);
						break;
					case "skd_dir_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "trd_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
					case "sub_trd_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('upper');
						break;
				}
				break;
				
			default: //공통기준:영문, 숫자만을 인식		
				ComKeyOnlyAlphabet("num");
				break;
		}
	}
	 
	/**
	 * VVD  데이터 수정시. <br>
	 **/
	function obj_change() {
		var formObj  = document.form;		
		
		with (event.srcElement) {
			switch (name) {
				case "vsl_cd": case "skd_voy_no":	

					if(name == 'vsl_cd') ComSetObjValue(formObj.skd_voy_no, "");
					ComSetObjValue(formObj.skd_dir_cd, "");
					//관련항목 초기화					
					resetForCondition(formObj, "ALL");
					break;
					
				case "trd_cd": case "sub_trd_cd": 
					resetForCondition(formObj, "ALL");
					break;
					
			}
		}
	} 
	 
	/**
	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVSL(rtnObjs) {
		var formObj  = document.form;
		if (rtnObjs) {
			var rtnDatas = rtnObjs[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.vsl_cd, rtnDatas[1]);
	
					// 포커스 이동
					ComSetFocus(formObj.skd_voy_no);
				}
			}
		}
	}

	/**
	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
	 */
	function setCallBackVVD(obj) {
		var formObj  = document.form;
		var comboObj = comboObjects[0];
		if (obj) {
			var rtnDatas = obj[0];
			if (rtnDatas) {
				if (rtnDatas.length > 0) {
					ComSetObjValue(formObj.skd_voy_no, rtnDatas[2]);
					ComSetObjValue(formObj.skd_dir_cd, rtnDatas[3]);
					
					//VVD Info 가져오기
					searchVVDInfo();
				}
			}
		}
	}
	 
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	
         var cnt = 0;
 		 var sheetID = sheetObj.id;
 				
         switch(sheetID) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 200;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 2, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(12, 0, 0, true);

                     //해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle  = "||Seq|Operator|Name|Basic Slot(TEU)|BSA SEQ|TRD|SUBTRD|VSL|VOY|DIR";
                   
 					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
                     InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,	WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++,  dtCheckBox, 30,	daCenter, 	false, 	prefix+"del_chk", 			false, 	"",     dfNone, 	0,  true, 	true);
                    InitDataProperty(0, cnt++ , dtDataSeq,	70,	daCenter,	true,	prefix+"seq",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,130,	daCenter,	true,	prefix+"crr_cd",		true,	"",		dfEngUpKey,	0,	false,	true,	3);
                    InitDataProperty(0, cnt++ , dtHidden,	100,	daLeft,		true,	prefix+"crr_nm",		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtAutoSumEx,70,	daCenter,	true,	prefix+"bsa_capa",		true,	"",		dfNullInteger,	0,	true,	true,	5);                             
                    InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	prefix+"bsa_seq",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	prefix+"trd_cd",		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	prefix+"sub_trd_cd",	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	prefix+"vsl_cd",		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	prefix+"skd_voy_no",	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,	30,		daCenter,	true,	prefix+"skd_dir_cd",	false,	"",		dfNone,		0,	false,	false);
                    
                    InitDataValid(0, prefix+"crr_cd", vtEngUpOnly);
				   }
                 break; 
         }
    }    
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
    }
    
    function sheet1_OnChange(sheetObj, Row, Col, Value) {        
        switch(sheetObj.ColSaveName(Col)) {	               
        	case prefix+"crr_cd":

        		var formObj = document.form;
         		formObj.f_cmd.value = SEARCH01;	
                
                 var sParam = Array();
                 var sCrr_cd = sheetObj.CellValue( Row, Col);
	    	  	  	sParam[0] = "crr_cd="+sCrr_cd;
	    	  	  	sParam[1] = "f_cmd="+SEARCH01;
	    	  	  	
    	  	     var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&"));
    	  	     var crrData = ComXml2Array(sXml, "crr_cd");

    	  		  if(crrData == "" || crrData == undefined || crrData == null){
    	  			  ComShowCodeMessage("COM132201","Data");	//'{?msg1} is invalid.'
    	  			  sheetObj.CellValue2( Row, Col) = sheetObj.CellSearchValue(Row, Col); 
    	  			  sheetObj.CellValue2( Row, prefix+"crr_cd") = sheetObj.CellSearchValue(Row, prefix+"crr_cd");
    	  			  sheetObj.SelectCell( Row, Col);	                             
                  }else{	                        	
                	  sheetObj.CellValue2( Row, prefix+"crr_cd") = crrData;
                	  sheetObj.SelectCell( Row, prefix+"bsa_capa");
                  }
    	  		  
             break;    
        }
    }
    
    /**
     * Sheet1 OnPopupClick 이벤트 처리  
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col)
    {
        with(sheetObj)
        {
            if( sheetObj.ColSaveName(Col) ==  prefix+'crr_cd' ){
                ComOpenPopup('/hanjin/COM_ENS_0N1.do',  770, 480, "PopupCallback_CrrCd", "1,0,0", true, false, Row, Col, 0);
            }
        }
    }  
    function PopupCallback_CrrCd(aryPopupData,row, col, seetIdx){ 
    		var formObj = document.form;
    		sheetObjects[seetIdx].CellValue2(row, col) = aryPopupData[0][3];  
    		sheetObjects[seetIdx].CellValue2(row, prefix+'crr_nm') = aryPopupData[0][4];
    }
    
	/**
	* IBCOMBO 초기화. <br>
	**/
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "trd_cd": 
				var i=0;
				with(comboObj) {
					//BackColor = "#CCFFFF";
					//DropHeight = 200;
					//MultiSelect = false;
					//MaxSelect = 1;					
                    //UseAutoComplete = true;  
					MaxLength = 3;
                    ValidChar(2,0);
				}				
				break;
			case "sub_trd_cd":
				var i=0;
				with(comboObj) {
					//BackColor = "#CCFFFF";
					//DropHeight = 200;
					//MultiSelect = false;
					//MaxSelect = 1;					
                    //UseAutoComplete = true;  
					MaxLength = 2;
                    ValidChar(2,0);
				}			
				break;
		}
	} 
    
    // Sheet1관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	
    	switch(sAction) {
    		case IBSEARCH:      //조회    		
    			formObj.f_cmd.value = SEARCH;
    			if(!validateForm(sheetObj,formObj,sAction)){return;}    			
           	
            	var param = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
            	var sXml = sheetObj.GetSearchXml("ESM_SPC_0084GS.do", param);
				sheetObj.LoadSearchXml(sXml);
				UF_afterRetrieve("Y");
				
    			break;
    			
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)){ return;}
				sheetObj.WaitImageVisible=false;
	            ComOpenWait(true);
	            formObj.f_cmd.value = MULTI;
	            
	            try{                        	
                    var sXml = sheetObj.GetSaveXml("ESM_SPC_0084GS.do", ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix) );                    	
                    	sheetObj.LoadSaveXml( sXml );

                    if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){   
        					doActionIBSheet(sheetObj, document.form, IBSEARCH);
        			}
                    ComOpenWait(false);
                    
                }finally{
                	ComOpenWait(false);
                }
                break;    		
    	}
    }  
   
     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            switch(sAction) { 
                case IBSAVE:
                    var sParam     =  ComGetSaveString(sheetObj );
                    if( sParam == ""){
                        return false;
                    }
                    break;
                
                case IBSEARCH:                	
                	var sTrd_cd 	= formObj.trd_cd.Code;
                	var sSub_trd_cd = formObj.sub_trd_cd.Code;
                	var sVsl_cd 	= formObj.vsl_cd.value;
                	var sSkd_voy_no = formObj.skd_voy_no.value;
                	var sSkd_dir_cd = formObj.skd_dir_cd.value;                	
                	
                	if( sTrd_cd=="" || sSub_trd_cd=="" || sVsl_cd=="" || sSkd_voy_no=="" || sSkd_dir_cd=="" ){
                		ComShowMessage(getMsg("SPC90114", "Trade|Sub Trade|VVD"));  
                		UF_afterRetrieve("N");
                		return false;
                	}           
                    break; 
                    
            } // end switch
        }
        return true;
    }  
    
    function getEtcDataFromXml(xml, str){
    	var pos = xml.indexOf("ETC KEY=\""+str+"\"");
    	if(pos < 0) return "";
		pos = xml.indexOf(">", pos + 1);
		if(pos < 0) return "";
		var epos = xml.indexOf("</ETC>", pos + 1);
		var rtn = "";
		if(epos < 0){
			rtn = xml.substring(pos + 1);
		}
		else{
			rtn = xml.substring(pos + 1, epos);
		}
		return rtn;
	}
    
    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     **************************
    function initData_operator(codes, names){
    	var sheetObj = document.getElementById("operator");
    	var cnt      = 0;
    	with(sheetObj){
    		RemoveAll();
    		SetTitle("Carrier");
    		//SetColWidth("60|250");
    		SetColAlign("left");
    		//ShowCol     = 0;
    		MultiSelect = false;
    		MaxSelect   = 1;
    		DropHeight  = 190;
    		
    		if(codes == undefined || codes == null){
    			return;
    		}
    		
    		if(codes.length > 2){
    			InsertItem(-1, "|ALL", "");
    		}
    		
    		var selectCode = "";
    		for(var i = 0 ; i < codes.length - 1 ; i++){
    			var txt = names[i].split("~");
    			if(txt[1] == "1"){
    				selectCode = codes[i];
    			}
    			InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		}
    		
    		if(selectCode != ""){
    			Code = selectCode;
    		} else {
    			Index = 0;
    		}
    		Enable = (GetCount() > 1);
    		Enable = !(Index > 1);
    	}
    }     
    *************/
     
     /*
      * Sub Trade OnChange시
      */
     function sub_trd_cd_OnChange(comObj,value,text ){
//    	if(text == '||ALL'){   
//			SpcSearchOptionTrade("trd_cd", true, true);
//	    	SpcSearchOptionSubTrade("sub_trd_cd", true, true); return;
//		} // 0207 SHKIM
    	if(value == "") return;
    	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comboObjects[0].Code2 = arrTrade[0];
    	} else {
    		comboObjects[0].Code2 = comObj.GetText(value,0);  
    	}      	
     	
      	//초기화
    	var formObj  = document.form;
     	resetForCondition(formObj, "ALL");
  
     } 
    
    /*
     * Trade OnChange시
     */
    function trd_cd_OnChange(comObj,value,text ){ 
//    	if(text == '|ALL'){	optionAllResetLoc("trd_cd",value);   return;} // 0207 SHKIM
//    	if(value == "") return;
    	var formObj  = document.form;
     	//초기화
    	resetForCondition(formObj, "ALL");
    	SpcSearchOptionSubTrade("sub_trd_cd",true,true,"","",value);			// 0207 SHKIM
    } 
    
	/**
	* Reset 
	* @param deltFlg
	* @return
	*/
	function UF_afterRetrieve(deltFlg){			
		if (deltFlg == undefined || deltFlg == null){
			deltFlg = "";
		}
			switch(deltFlg) {			
				case "N":
					ComBtnDisable("t1btn_RowAdd");
					break;
				case "Y":
					ComBtnEnable("t1btn_RowAdd");
					break;
				case "A":
					ComBtnDisable("t1btn_RowAdd");
					break;
			}
	}
	/** 공통으로 넘김.
 	 * 2012.02.07 SHKIM ALL RESET
 	 */
 	function optionAllResetLoc(gubun,value){
 		if("trd_cd" == gubun){
 			SpcSearchOptionTrade("trd_cd", true, true);
 			SpcSearchOptionSubTrade("sub_trd_cd"); 			
 		}else{	// 예외처리.
 			SpcSearchOptionTrade("trade", true, true);
 			SpcSearchOptionSubTrade("subtrade"); 			
 		}
 	}

	/* 개발자 작업  끝 */