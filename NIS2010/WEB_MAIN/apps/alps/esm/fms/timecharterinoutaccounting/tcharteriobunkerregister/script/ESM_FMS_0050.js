/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName 		: ESM_FMS_0050.js
*@FileTitle 	: BunkerDataManagement
*Open Issues 	:
*Change history :
*@LastModifyDate: 2011.03.18
*@LastModifier 	: 유재민
*@LastVersion 	: 1.0
* 2009.03.26 정윤태
* 1.0 Creation
* 
* 2010.11.24 이상민 [CHM-201007233-01] 수정 및 추가 
* vessel code 입력시 keypress : eng_keypress -> engnum_keypress
* 
* 2011.03.18 유재민 [CHM-201109295-01] Location 조회불가건 수정 보완 요청
* 
* --------------------------------------------------------------------------------
* 2016.02.01 손진환 [CHM-201639985] Inquiry 화면 불필요 Validation정리 
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
     * @class BunkerDataManagement : BunkerDataManagement 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0050() {
		this.processButtonClick	    = processButtonClick;
		this.setSheetObject 	    = setSheetObject;
		this.loadPage 			    = loadPage;
		this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
		this.initSheet 			    = initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 	    = doActionIBSheet;
		this.setTabObject 		    = setTabObject;
		this.validateForm 		    = validateForm;
		this.sheet1_OnChangeSum	    = sheet1_OnChangeSum;
		this.setVslCd			    = setVslCd;
		this.sheet1_OnPopupClick    = sheet1_OnPopupClick;
		this.setProgramNo		    = setProgramNo;
		this.rowRemove			    = rowRemove;
		this.clearAll			    = clearAll;
		this.obj_deactivate		    = obj_deactivate;
		this.obj_keypress		    = obj_keypress;
		this.eng_keypress		    = eng_keypress;
		this.vsl_cd_change		    = vsl_cd_change;
		this.setVvdCombo		    = setVvdCombo;
		this.setTypeMakeCombo	    = setTypeMakeCombo;
		this.setUomMakeCombo	    = setUomMakeCombo;
		this.inputReadOnly		    = inputReadOnly;
		this.sheet1_OnChange	    = sheet1_OnChange;
		this.sheet1_OnClick		    = sheet1_OnClick;
		this.setVvdCombo		    = setVvdCombo;
		this.setVvdMakeCombo	    = setVvdMakeCombo;
		this.setLocationCd		    = setLocationCd;
		this.setContractNo		    = setContractNo;
		this.initConfirm			= initConfirm;
		this.rowChangeYn			= rowChangeYn;
	}
    
    // 공통전역변수  
    var tabObjects = new Array();
    var tabCnt     = 0;
    var beforetab  = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    //2017.05.15 contract type 콤보로 변경
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var vslCombo = "";
    var vvdCombo = "";

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
                	if(!initConfirm()) return;
                	
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

				case "btn_new":
					if(!initConfirm()) return;
					
					vslCombo = "";
					
					clearAll();
					
                    break;

				case "btn_save":
					if(!vslCheck()) return;
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;

				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                    break;
	
				case "btn_print":
					alert("btn_print");
                    break;

				case "btn_add":
					
					if(!validateForm(sheetObject,formObject)) return;
					if(!vslCheck()) return;
					
					setVslCdCombo(row);
					
					var row = sheetObject.DataInsert(-1);
					
					sheetObject.CellText(row,"bnk_yrmon") = formObject.bnk_yrmon.value;
					sheetObject.CellText(row,"flet_ctrt_no") = formObject.flet_ctrt_no.value;
					
//					inputReadOnly();
					
                    break;
	
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					if(!vslCheck()) return;
					
					setVslCdCombo(row);
					
					var row = sheetObject.DataInsert();

					sheetObject.CellText(row,"bnk_yrmon") = formObject.bnk_yrmon.value;
					sheetObject.CellText(row,"flet_ctrt_no") = formObject.flet_ctrt_no.value;
	
//					inputReadOnly();
					
					break;

				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) {
						rowRemove(sheetObject);
					}
                    break;
                    
				case "bnk_yrmon_cal":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.bnk_yrmon, 'yyyy-MM');
					
					sheetObject.RemoveAll();
                    break;
                    
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 440,"setVslCd", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0022");
					break;
					 
				case "contract_no":
					 if(formObject.vsl_cd.value == "") {
						 ComAlertFocus(formObject.vsl_cd, ComGetMsg('FMS01231'));
						 return;
					 }
					 
					 ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vsl_cd.value, 520, 405,"setContractNo", "1,0,1,1,1", false, false, 0, 0, 0, "ESM_FMS_0023");
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

    //2017.05.15 contract type 콤보로 변경
    function setComboObject(combo_obj){          
        comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
        	ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        //마지막 컬럼을 전체 너='비에 맞춘다.
        sheetObjects[0].ExtendLastCol = false;

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();   
    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) { 
    	sheetObj.WaitImageVisible = false;   
    	
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
		
		sheetObj.WaitImageVisible = true; 
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

                    // 높이 설정(230)
                    style.height = 380;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //var HeadTitle = "|Seq|Sel|Type|Vessel Code|Acct Code|Item|Del/Re Date|Del/Re Port|UOM|Quantity|Price(USD)|Amount|VVD|Contract No|Bnk Seq|Account Item|Bnk Yrmon";
                    var HeadTitle = "|Seq|Sel|Type|Vessel Code|Acct Code|Item|Del/Redel Date|Del/Redel Port|UOM|Quantity|Price(USD)|Amount|VVD|Update User|Attach|CSR No|Contract No|Bnk Seq|Account Item|Bnk Yrmon";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,       0,    daCenter,  false,   "Seq");
					InitDataProperty(0, cnt++ , dtDummyCheck,  40,    daCenter,  false,   "DelChk");
                    InitDataProperty(0, cnt++ , dtCombo,       45,    daCenter,  false,   "bnk_tp_cd",    	false,          				"",      dfNone,      	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,       85,    daCenter,  false,   "vsl_cd",         false,          				"",      dfEngUpKey,  	4,     true,       true);
					InitDataProperty(0, cnt++ , dtData,        85,    daCenter,  false,   "acct_cd",     	false,          				"",      dfNone,      	0,     false,      false);	
					InitDataProperty(0, cnt++ , dtPopup,       75,    daLeft,    false,   "acct_itm_nm",   	true,          					"",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,        120,   daCenter,  false,   "bnk_dt",     	true,          					"",      dfUserFormat2, 0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,   110,   daCenter,  false,   "port_cd",     	true,        					"",      dfEngUpKey,    5,     true,       true, 5);
					InitDataProperty(0, cnt++ , dtCombo,       55,    daCenter,  false,   "flet_meas_ut_cd",true,        					"",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,        85,    daRight,   false,   "bnk_qty",     	true,       					"",      dfNullFloat, 	3,     true,       true, 12);
					InitDataProperty(0, cnt++ , dtData,        88,    daRight,   false,   "bnk_prc_amt",  	true,         					"",      dfNullFloat, 	4,     true,       true, 17);
					InitDataProperty(0, cnt++ , dtAutoSum,     82,    daRight,   false,   "bnk_amt",     	true,   						"",      dfNullFloat, 	4,     true,       true, 17);
					InitDataProperty(0, cnt++ , dtData,        80,    daCenter,  false,   "bunker_vvd",    	true,          				    "",      dfNone, 	  	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,        100,   daCenter,  false,   "upd_usr_id",    	false,          			    "",      dfNone, 	  	0,     false,      false);
					InitDataProperty(0, cnt++ , dtPopup,        80,   daCenter,  false,   "atch_file_lnk_cnt",    	false,          		"",      dfNone, 	  	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,        140,   daCenter,  false,   "csr_no",    		false,          			    "",      dfNone, 	  	0,     false,      false);
					
					InitDataProperty(0, cnt++ , dtHidden,	   30,    daCenter,  false,   "flet_ctrt_no",   false,          				"",      dfNone,      	0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   30,    daCenter,  false,   "bnk_seq",        false,          				"",      dfNone,      	0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   30,    daCenter,  false,   "acct_itm_seq",   false,          				"",      dfNone,      	0,     true,       false);
					InitDataProperty(0, cnt++ , dtHidden,	   30,    daCenter,  false,   "bnk_yrmon",      false,          				"",      dfNone,      	0,     true,       false);

					InitUserFormat2(0, "bnk_dt", "####-##-## ##:##", "-|:" );
					InitDataValid(0, "port_cd", vtEngUpOther, "0123456789");
					
					DataLinkMouse("acct_itm_nm") = true;
					DataLinkMouse("port_cd") = true;
					
					ShowButtonImage = 1;
					
					//CountPosition = 0;
					//FitColWidth("3|4|3|6|8|7|10|10|10|6|8|10|8.5|10");
					FitColWidth("0|1.8|3|4.5|7.5|6.5|15.6|10.7|10.5|5|7|11.5|9.5|10");
					
               }
                break;
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
    	sheetObj.ShowDebugMsg = false;

        switch(sAction) {

        	case IBSEARCH:      //조회
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
       	   	  		formObj.f_cmd.value = SEARCH;
       	   	  		
       	   	  		var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(""));
       	   	  		
       	   	  		var arrXml = sXml.split("|$$|");
 
//       	   	  		inputReadOnly("Search");
       	   	  		
		       	   	var vslCd = ComGetEtcData(sXml, "vslCd");

			   		if(typeof vslCd != "undefined" && vslCd != "") {
			   				
		  				var comboText = vslCd;
		
		  				setVslCdMakeCombo(sheetObj, comboText);
		  			}
			   		
			   		if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
       	   	  	}
       	   	  	break;

        	case IBSAVE:        //저장
        		if(validateForm(sheetObj,formObj,sAction)) {
        			formObj.f_cmd.value = MULTI;
        			
        			sheetObj.DoSave("ESM_FMS_0050GS.do", FormQueryString(formObj));
        		}
                break;
                
			case IBROWSEARCH:   //조회	
				
				if(gubun != "ComCd") {
					if(formObj.vsl_cd.value == "") return;
				}
		    	
				if(gubun == "vslCd") {
					if (vslCombo != "") return;
					
					formObj.f_cmd.value = SEARCH01;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		
		   			var vslCd = ComGetEtcData(sXml, "vslCd");

		   			if(typeof vslCd != "undefined" && vslCd != "") {
		   				
	    				var comboText = vslCd;

	    				setVslCdMakeCombo(sheetObj, comboText, row);
	    			}
				} else if(gubun == "Vvd") {
					if (vvdCombo != "") return;
					
					formObj.f_cmd.value = SEARCH02;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		
		   			var vvd = ComGetEtcData(sXml, "vvd");

		   			if(typeof vvd != "undefined" && vvd != "") {
		   				
	    				var comboText = vvd;

	    				setVvdMakeCombo(sheetObj, comboText, row);
	    			} else {
	    				ComShowMessage(ComGetMsg('FMS01232'));
	    				sheetObj.SelectCell(row, "vsl_cd");
	    			}
				} else if(gubun == "LocCd") {
					formObj.f_cmd.value = SEARCH03;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		
		   			var locCd = ComGetEtcData(sXml, "locCd");

		   			if(typeof locCd == "undefined" || locCd == "") {
		   				ComShowMessage(ComGetMsg('FMS01233'));
                        sheetObj.CellValue2(row,"port_cd") = "";
                        sheetObj.SelectCell(row,"port_cd");
	    			}
		   		//2017.05.15 contract type 콤보로 변경	
				/*
				} else if(gubun == "Contract") {
					formObj.f_cmd.value = SEARCH04;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		
		   			var ctrtType = ComGetEtcData(sXml, "ctrtType");

		   			if(typeof ctrtType != "undefined" && ctrtType != "") {
		   				formObj.flet_ctrt_tp_cd.value = ctrtType;
	    			}
	    		*/
				} else if(gubun == "ComCd") {
					//2017.05.15 contract type 콤보로 변경
					formObj.f_cmd.value = SEARCH04;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0001GS.do" , FormQueryString(formObj));
		   			
		   			var fletCtrtTpCd   = ComGetEtcData(sXml, "fletCtrtTpCd");
		   			var fletCtrtTpNm   = ComGetEtcData(sXml, "fletCtrtTpNm");
		   			
		   			if(typeof fletCtrtTpCd != "undefined" && fletCtrtTpCd != "") {
	    				var comboCode = fletCtrtTpCd;
	    				var comboText = fletCtrtTpNm;

	    				setDataCombo(comboObjects[0], comboText, comboCode);
	    			}
		   			
					formObj.f_cmd.value = SEARCH05;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0050GS.do" , FormQueryString(formObj));
		
		   			var bnkType = ComGetEtcData(sXml, "bnkType");
		   			var uomCode = ComGetEtcData(sXml, "uomCode");
		   			var uomText = ComGetEtcData(sXml, "uomText");

		   			if(typeof bnkType != "undefined" && bnkType != "") {
		   				
	    				var comboText = bnkType;

	    				setTypeMakeCombo(sheetObj, comboText);
	    			}
		   			
		   			if(typeof uomCode != "undefined" && uomCode != "") {
		   				
	    				var comboCode = uomCode;
	    				var comboText = uomText;

	    				setUomMakeCombo(sheetObj, comboText, comboCode);
	    			}
				} else {
					formObj.f_cmd.value = SEARCH01;
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		
		   			var vslEngNm = ComGetEtcData(sXml, "vslEngNm");
		   			
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value = vslEngNm;
		   				initDefaultContractNo();  //선박 대 계약 자동 매치
					} else {
						formObj.vsl_cd.value = "";
						formObj.vsl_eng_nm.value = "";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg('FMS01234'));
						return;
					}
				}
				break;
			case IBSEARCH_ASYNC02: //선박 대 계약 자동 매치		
				if(formObj.vsl_cd.value == "") return;	

				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vsl_cd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll;  

				var sXml = sheetObj.GetSearchXml("FMS_COMGS.do",f_query);
	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			var varFletCtrtTpCd = ComGetEtcData(sXml, "flet_ctrt_tp_cd");	//2017.05.15 contract type 콤보로 변경
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.flet_ctrt_no.value = varFletCtrtNo;
					formObj.flet_ctrt_tp_cd.Code2 = varFletCtrtTpCd;	//2017.05.15 contract type 콤보로 변경
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
	   			
	   			//2017.05.15 contract type 콤보로 변경
				//if(formObj.flet_ctrt_no.value != ""){
				//	contract_no_change();
				//}
	   			
				break;	
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	화면 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj의 입력값
     * @return {boolean} 정상 여부
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction) {
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        return true;
    }
    
    /**
     * IBSheet Object 합 구하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} sheetObj    IBSheet Row
     **/
	function sheet1_OnChangeSum(sheetObj, Row) {
		sheetObj.SumText(0,"Seq") = "";
		sheetObj.SumText(0,"DelChk") = "";
		sheetObj.SumText(0,"bnk_tp_cd") = "";
		sheetObj.SumText(0,"bnk_prc_amt") = "Sub-Total Amount";
	}
    
	/**
	 * Vessel Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value = aryPopupData[0][2];
		form.vsl_eng_nm.value = aryPopupData[0][3];

		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
		initDefaultContractNo(); //선박 대 계약 자동 매치
	}



    /**
	 * programNo 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setProgramNo(aryPopupData, row, col, sheetIdx){
		sheetObjects[0].CellValue2(row,col) = aryPopupData[0][2];
		sheetObjects[0].CellValue2(row,"acct_cd") = aryPopupData[0][3];
		sheetObjects[0].CellValue2(row,"acct_itm_seq") = aryPopupData[0][4];
	}

	/**
	 * Del/Re Port 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setPortCd(aryPopupData, row, col, sheetIdx){
		sheetObjects[0].CellValue2(row,col) = aryPopupData[0][3];
	}
	
	/**
     * IBSheet Row 삭제하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     **/
	function rowRemove(sheetObj) {
		ComRowHideDelete(sheetObj, "DelChk");
	}
	
	/**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
	function clearAll() {
		ComResetAll();
		inputReadOnly("New");
	}
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "-";
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        
        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Vessel Code 입력 시 영문 대문자만 입력하기
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Vessel Code 입력 후 Name 정보 가져오기

        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
    			
	    	case "bnk_yrmon":
	    		ComChkObjValid(event.srcElement);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }
     
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
     	ComClearSeparator(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }
    
     /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
      **/
     //* 2010.11.24 이상민 [CHM-201007233-01] vessel code는 engnum_keypress를 사용한다
     function engnum_keypress() {
         //영대문자 자동변환
         ComKeyOnlyAlphabet('uppernum');
     } 
    /**
     * VslCd변경 시 해당 Name 을 가져온다. <br>
     **/
    function vsl_cd_change() {
    	sheetObjects[0].RemoveAll();
    	
    	form.vsl_eng_nm.value = "";
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
    }
    
    /**
     * vslCd 정보를 가져온다 <br>
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVslCdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "vslCd", row);
    }
    
    /**
     * vslCd Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   vslCd 의 코드값
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVslCdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		var vslCdCode = comboText.substring(0,comboText.length-1);
    		var valCdText = vslCdCode;
        	var comboList = comboText.split("|");
        	vslCombo = vslCdCode;
        	
        	sheetObj.InitDataCombo(0, "vsl_cd", valCdText, vslCdCode);
    	}
    }
    
    /**
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	if(flag == "New") {
    		form.bnk_yrmon.readOnly = false;
	    	form.vsl_cd.readOnly = false;
	    	
	    	document.images["bnk_yrmon_cal"].name = "bnk_yrmon_cal";
	    	document.images["contract_no"].name = "contract_no";
	    	document.images["btn_vslpop"].name = "btn_vslpop";
	    	
	    	form.bnk_yrmon_cal.style.cursor = "hand";
	    	form.contract_no.style.cursor = "hand";
	    	form.btn_vslpop.style.cursor = "hand";
	    	
    	} else {
	    	if(sheetObjects[0].RowCount == 1 || flag == "Search") {
		    	form.bnk_yrmon.readOnly = true;
		    	form.vsl_cd.readOnly = true;
		    	
		    	document.images["bnk_yrmon_cal"].name = "no_bnk_yrmon_cal";
		    	document.images["contract_no"].name = "no_contract_no";
		    	document.images["btn_vslpop"].name = "no_btn_vslpop";
		    	
		    	form.bnk_yrmon_cal.style.cursor = "default";
		    	form.contract_no.style.cursor = "default";
		    	form.btn_vslpop.style.cursor = "default";
	    	}
    	}
    }
    
    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnChange(sheetObj,row,col,value) {
		if(sheetObj.ColSaveName(col)=="bnk_dt") {
			var bnkDtCol = sheetObj.SaveNameCol("bnk_dt");
    		var bnkDtValue = sheetObj.CellValue(row,bnkDtCol);
    		var bnkYrmon = form.bnk_yrmon.value.trimAll("-");
    		
    		if(bnkDtValue.length < 8) {
    			//ComShowCodeMessage('FMS01235');
    			//sheetObj.SelectCell(row, "bnk_dt", true, "");
    			
    			sheetObj.SelectCell(row,"bnk_dt");
    			sheetObj.CellValue(row,"bnk_dt") = "";
    			return false;
    			//sheetObj.ValidateFail = true;
    			
    		} else if(bnkDtValue.substring(0,6) != bnkYrmon) {
    			ComShowCodeMessage('FMS01236');
    			//sheetObj.SelectCell(row, "bnk_dt", true, "");
    			sheetObj.CellValue(row,"bnk_dt") = "";
    			sheetObj.SelectCell(row,"bnk_dt");
    			return false;
    			//sheetObj.ValidateFail = true;
    		}
    		
    		dateTimeOnChange(sheetObj,row,col,value);
    		
    		sheetObj.CellValue(row,"bunker_vvd") = "";
			sheetObj.CellEditable(row, "bunker_vvd")= false;
			sheetObj.InitCellProperty(row, "bunker_vvd", dtData);
    		
		} else if(sheetObj.ColSaveName(col)=="vsl_cd") {
			sheetObj.CellValue(row,"bunker_vvd") = "";
			sheetObj.CellEditable(row, "bunker_vvd")= false;
			sheetObj.InitCellProperty(row, "bunker_vvd", dtData); 
			
		} else if(sheetObj.ColSaveName(col)=="port_cd") {
			var portCdCol = sheetObj.SaveNameCol("port_cd");
    		var portCdValue = sheetObj.CellValue(row,portCdCol);
    		
    		if(portCdValue == "") return;
    		
    		form.curr_port_cd.value = portCdValue;
			setLocationCd(row);
		} else if(sheetObj.ColSaveName(col)=="bnk_qty" || sheetObj.ColSaveName(col)=="bnk_prc_amt") {
     		//Amount가 자동계산 컬럼이었는데 수량,단가 입력시 자동계산되어지고 수정가능하도록 변경됨
     		if (sheetObj.CellValue(row, "bnk_qty") != "" && sheetObj.CellValue(row, "bnk_prc_amt") != "") {
     			sheetObj.CellValue(row, "bnk_amt") = sheetObj.CellValue(row, "bnk_qty")*sheetObj.CellValue(row, "bnk_prc_amt");
     		} else {
     			sheetObj.CellValue(row, "bnk_amt") = "";
     		}
    	}

	}
     
    /**
     * IBSheet 입력값에 대한 날짜 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     * @param {String}  prefix   	변수 구분값
     * @see #sheet_chekPeriod
     **/
 	function dateTimeOnChange(sheetObj,row,col,value) {
 		if (sheetObj.ReadDataProperty(row,col,dpDataFormat) != dfDateYmd && sheetObj.ReadDataProperty(row,col,dpDataFormat) != dfUserFormat2) return;

 		if (value=="") return;
 		
 		//년월일시분 validation check
 		var sText = sheetObj.CellText(row,col);
 		
		if (!ComIsDateTime(sText, "", "hm")) {
			ComShowMessage(ComGetMsg('FMS01066', sheetObj.CellText(0,col)));
			//ComShowMessage(sheetObj.CellText(0,col) + " is not valid date-time. Please enter a correct date-time. \n\n Format : YYYY-MM-DD HH:MM");
			sheetObj.SelectCell(row,col,true,sText);
			return;
		}
 		
 	}
    
	/**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnClick(sheetObj, row, col) {
    	if(sheetObj.ColSaveName(col)=="bunker_vvd") {
    		var bnkDtCol = sheetObj.SaveNameCol("bnk_dt");
    		var bnkDtValue = sheetObj.CellValue(row,bnkDtCol);
    		
    		if(bnkDtValue == "" || bnkDtValue.length < 8) {
    			ComShowMessage(ComGetMsg('FMS01235'));
    			sheetObj.SelectCell(row, "bnk_dt", true, "");
    			sheetObj.ValidateFail = true;
    			
    			return;
    		}

    		var iType = sheetObj.ReadDataProperty(row, "bunker_vvd", dpDataType);

    		if(iType == 6) return;
    		
    		var vslCdCol = sheetObj.SaveNameCol("vsl_cd");
    		var vslCdValue = sheetObj.CellValue(row,vslCdCol);

    		form.curr_vsl_cd.value = vslCdValue;
    		
    		form.bunker_dt.value = bnkDtValue.substring(0,8);
    		
    		setVvdCombo(row);
    	}
    }
    
    /**
     * Vvd 정보를 가져온다 <br>
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVvdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "Vvd", row);
    }
    
    /**
     * Vvd Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Vvd 의 코드값
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVvdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		var vvdCode = comboText.substring(0,comboText.length-1);
    		var vvdText = vvdCode;
        	var comboList = comboText.split("|");
        	
        	sheetObj.InitCellProperty(row, "bunker_vvd", dtCombo); 
        	sheetObj.CellComboItem(row, "bunker_vvd", vvdText, vvdCode);
        	sheetObj.CellEditable(row, "bunker_vvd")= true;
    	}
    }
    
    /**
     * Type Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 코드값
     **/
    function setTypeMakeCombo(sheetObj, comboText) {
    	if(comboText != "" ) {
    		var typeCode = comboText.substring(0,comboText.length-1);
    		var typeText = typeCode;
        	var comboList = comboText.split("|");
        	
        	sheetObj.InitDataCombo(0, "bnk_tp_cd", typeText, typeCode);
    	}
    }
    
    /**
     * Uom Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Type 의 코드에 해당하는 Name
     * @param {String}  comboCode   Type 의 코드값
     **/
    function setUomMakeCombo(sheetObj, comboText, comboCode) {
    	if(comboText != "" ) {
    		var typeText = comboText.substring(0,comboText.length-1);
    		var typeCode = comboCode.substring(0,comboCode.length-1);
        	
        	sheetObj.InitDataCombo(0, "flet_meas_ut_cd", typeText, typeCode);
    	}
    }
    
    /**
     * Location Code 정보를 가져온다 <br>
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setLocationCd(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'LocCd', row);
    }
    
    /**
	 * Contract No 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.flet_ctrt_no.value = aryPopupData[0][3];
		form.flet_ctrt_tp_cd.Code2 = aryPopupData[0][5];	//2017.05.15 contract type 콤보로 변경
		//contract_no_change();		//2017.05.15 contract type 콤보로 변경
	}
	
	/**
     * Contract No 선택 시 해당 Name 을 가져온다. <br>
     **/
	//2017.05.15 contract type 콤보로 변경
    //function contract_no_change() {
    //	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'Contract');
    //}
    
    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
    	var okYn = true;
    	
    	if(ComIsModifiedSheets(sheetObjects[0])) {
    		var okYn = confirm(ComGetMsg('FMS00002'));
    	}
    	
    	//if(sheetObjects[0].isDataModified) {
    		//var okYn = confirm("입력 및 변경된 데이터가 있습니다.\n\n계속 진행하시겠습니까?");
    	//}
    	
    	return okYn;
    }
    
    /**
     * 이벤트 발생시 변경사항이 있는지 체크 <br>
     * @return {boolean} changeYn   row 의 변경사항이 발생하면 changeYn:true 아니면 changeYn:false
     **/
    function rowChangeYn() {
    	var changeYn = false;

    	for(var ir=1; ir<=sheetObjects[0].LastRow; ir++){
    		if(sheetObjects[0].RowStatus(ir) != "R") {
    			changeYn = true;
    			break;
    		}
		}
    	
    	return changeYn;
    }
     
    /**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	ErrMsg    	Error메세지
     **/
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	sheetObj.SumText(0,"Seq") = "";
    	sheetObj.SumText(0,"DelChk") = "";
    	
 		ComColFontName(sheetObj, "4"); 
 		ComColFontName(sheetObj, "8"); 
 		ComColFontName(sheetObj, "13");
 	}
 	
 	 //선박 대 계약 자동 매치
    function initDefaultContractNo(){
    	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);  
      } 
    
	/**
	 * .<br>
	 * 
	 * @param {int} Row 행번호
	 * @param {int} Col 컬럼번호
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		switch (sheetObj.ColSaveName(Col)) {

			case "atch_file_lnk_cnt":
				var editable = "Y";

				var fileId = sheetObj.CellValue(Row, "atch_file_flet_lnk_id");

				fmsFileUploadPopUp(sheetObj, Row, editable, fileId);
				break;
				
			case "acct_itm_nm":
				ComOpenPopup("ESM_FMS_0076.do?flet_acct_cate_cd=BU", 550, 455, "setProgramNo", "1,0,1,1,1,1", false, false, Row, Col, 0, "ESM_FMS_0076");
				break;
				
			case "port_cd":	
				ComOpenPopup("COM_ENS_051.do", 720, 480, "setPortCd", "1,0,1,1,1,1", true, false, Row, Col, 0, "COM_ENS_051");
				break;

		}
	}
	
	/** 
	 * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	 * @param {int} x 필수, X 좌표
	 * @param {int} y 필수, Y 좌표
	 * @return 없음
	 */   
	function sheet1_OnMouseMove(sheetObj, button, shift, x, y){
		with(sheetObj){

			if(ColSaveName(MouseCol) ==  "atch_file_lnk_cnt" ||
			   ColSaveName(MouseCol) ==  "acct_itm_nm" ||
			   ColSaveName(MouseCol) ==  "port_cd") {
				if(sheetObj.CellEditable(sheetObj.MouseRow, sheetObj.MouseCol)) {
					sheetObj.MousePointer = "Hand";
				} 
			} else {
				MousePointer = "Default";
			} 	
		}
	}
	
	/**
	 * FMS File Upload 팝업 오픈
	 */
	function fmsFileUploadPopUp(sheetObj, Row, edit_able, fileId) {
		
		flet_ctrt_no =  sheetObj.CellValue(Row, "flet_ctrt_no");
		bnk_seq      =  sheetObj.CellValue(Row, "bnk_seq");

		var param = "?atch_file_flet_lnk_id="+ fileId +
					 "&vsl_cd= "+ flet_ctrt_no +
					 "&vnor_seq= "+ bnk_seq +
					 "&edit_able= "+ "Y" +
					 "&tab_gubun= "+ "sheet1" +
					 "&row="+Row
		 
		ComOpenPopup("/hanjin/ESM_FMS_0092.do" + param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");	 
	}

	//2017.05.15 contract type 콤보로 변경
	function setDataCombo(comboObj, comboText, comboCode) {
		
        switch(comboObj.id) {
            case "flet_ctrt_tp_cd":
            	
            	if(comboText != "" ) {
	            	var comboTextList = comboText.split("|");
	            	var comboCodeList = comboCode.split("|");
	            	
	            	for(var i=0; i < comboTextList.length-1; i++) {
	            		comboObj.InsertItem(i, comboTextList[i], comboCodeList[i]);
	            	}
	            	
	            	comboObj.Code = comboCodeList[0];
	            	
	            	comboObj.BackColor = "#CCFFFD";
            	}
                break;
                
        } 
    }

	//2017.05.15 contract type 콤보로 변경
	function flet_ctrt_tp_cd_OnChange(idx_cd, text) {
		
		if(form.vsl_cd.value == "") return;	
	
		var f_query = "";					
		f_query += "f_cmd=" + SEARCH01; 
		f_query += "&vsl_cd="+form.vsl_cd.value;	 			
		f_query += "&type_flag="+text;  
	
		var sXml = sheetObjects[0].GetSearchXml("FMS_COMGS.do",f_query);
		var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
			
		if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
			form.flet_ctrt_no.value = varFletCtrtNo;
		}else{
			ComShowCodeMessage("FMS20001","Agreement");
			clearAll();
			return;
		}
			
	}
	
	//조회시 VESSEL MANDATORY 제외 2017.05.17
	function vslCheck() {
		if(form.vsl_cd.value == "") {
			ComShowCodeMessage("FMS00004","Vessel Code");
			return false;
		}
		return true;
	}