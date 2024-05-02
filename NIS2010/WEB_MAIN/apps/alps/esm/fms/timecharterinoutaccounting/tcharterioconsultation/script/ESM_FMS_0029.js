/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0029.js
*@FileTitle : Tex Evidence
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.20 정윤태
* 1.0 Creation
* 
* * 2012.07.03 전상화 [CHM-201218893] 수정 
* 전표 생성 시에 세금 증빙 공급가액 기능 보완
* 전표 생성의 세금에서 증빙 공급가액 계산 방법(Click Event) 수정

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
     * @class ESM_FMS_0029 : ESM_FMS_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0029() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl        	= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
        this.eng_keypress			= eng_keypress;
        this.spl_rgst_no_change		= spl_rgst_no_change;
        this.obj_deactivate			= obj_deactivate;
        this.obj_activate			= obj_activate;
        this.obj_keypress			= obj_keypress;
        this.eng_num_keypress		= eng_num_keypress;
        this.sheet1_OnChange		= sheet1_OnChange;
        this.setCalculation			= setCalculation;
        this.rowRemove				= rowRemove;
        this.gridReset				= gridReset;
        this.setTaxEvidenceData		= setTaxEvidenceData;
    }

	// 공통전역변수
	
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
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

	        	case "btn_rowAdd":
	        		
	        		if(sheetObjects[0].rowCount < 4) {
	        			var row = sheetObject.DataInsert(-1);
	        		}
					break;
						
				case "btn_rowDel":
					//if(checkBoxCheckYn(sheetObject, "DelChk")) {
	            	rowRemove(sheetObject, "txd_");
	            	//}
					break;
					
				case "btn_confirm":
					
					if(form.tax_iss_cd[0].checked == false
			           && form.tax_iss_cd[1].checked == false) {
			        	ComShowCodeMessage("FMS01479");
			        	return false;
			        }
					
					if(!ComChkValid(formObject)) return false;
					
					if(sheetObjects[0].rowCount == 0) {
						ComShowCodeMessage("FMS00007");
						return;
					}
					
					if(!validateForm()) return false; 
					
					var prefix = "tax_";
															
					if(opener.sheetObjects[1].rowCount > 0) {
						opener.sheetObjects[1].RemoveAll();
						opener.sheetObjects[2].RemoveAll();
					}
					
					var row = opener.sheetObjects[1].DataInsert(-1);
					
					opener.sheetObjects[1].CellValue(row,prefix+"tax_inv_yrmon") = formObject.tax_inv_yrmon.value;
					opener.sheetObjects[1].CellValue(row,prefix+"ofc_cd") = formObject.ofc_cd.value;
					
					var tax_iss_cd = "ELECTRONIC";
					if(formObject.tax_iss_cd[0].checked) {
						tax_iss_cd = formObject.tax_iss_cd[0].value;
					} else {
						tax_iss_cd = formObject.tax_iss_cd[1].value;
					}
					opener.sheetObjects[1].CellValue(row,prefix+"tax_iss_cd") = tax_iss_cd;

					var tax_vat_tp_cd = "1";
					if(formObject.tax_vat_tp_cd[0].checked) {
						tax_vat_tp_cd = formObject.tax_vat_tp_cd[0].value;
					} else {
						tax_vat_tp_cd = formObject.tax_vat_tp_cd[1].value;
					}
					opener.sheetObjects[1].CellValue(row,prefix+"tax_vat_tp_cd") = tax_vat_tp_cd;
					
					opener.sheetObjects[1].CellValue(row,prefix+"tax_naid_flg") = "N";
					
					var tax_div_cd = "1";
					if(formObject.tax_div_cd[0].checked) {
						tax_div_cd = formObject.tax_div_cd[0].value;
					} else {
						tax_div_cd = formObject.tax_div_cd[1].value;
					}
					opener.sheetObjects[1].CellValue(row,prefix+"tax_div_cd") = tax_div_cd;
					
					opener.sheetObjects[1].CellValue(row,prefix+"fa_flg") = "N";
					
					if(formObject.evid_tp_cd.value == "1") {
						var tax_pl_cd = "1";
						if(formObject.tax_pl_cd[0].checked) {
							tax_pl_cd = formObject.tax_pl_cd[0].value;
						} else {
							tax_pl_cd = formObject.tax_pl_cd[1].value;
						}
						opener.sheetObjects[1].CellValue(row,prefix+"tax_pl_cd") = tax_pl_cd;
					}
					
					opener.sheetObjects[1].CellValue(row,prefix+"tax_nsl_flg") = "N";
					
					opener.sheetObjects[1].CellValue(row,prefix+"spl_rgst_no") = formObject.spl_rgst_no.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"ownr_nm") = formObject.ownr_nm.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"co_nm") = formObject.co_nm.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"bzct_nm") = formObject.bzct_nm.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"bztp_nm") = formObject.bztp_nm.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"spl_addr") = formObject.spl_addr.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"iss_dt") = formObject.iss_dt.value;					
					
					opener.sheetObjects[1].CellValue(row,prefix+"spl_amt") = formObject.spl_amt.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"tax_amt") = formObject.tax_amt.value;
					
					opener.sheetObjects[1].CellValue(row,prefix+"total_amt") = formObject.total_amt.value;
					
					prefix = "txd_";
					for(var ir=1; ir<=sheetObjects[0].LastRow; ir++) {
						var row = opener.sheetObjects[2].DataInsert(-1);
						
						opener.sheetObjects[2].CellValue(row,prefix+"itm_nm") = sheetObjects[0].CellValue(ir,prefix+"itm_nm");
						opener.sheetObjects[2].CellValue(row,prefix+"spl_amt") = sheetObjects[0].CellValue(ir,prefix+"spl_amt");
						opener.sheetObjects[2].CellValue(row,prefix+"tax_amt") = sheetObjects[0].CellValue(ir,prefix+"tax_amt");
						opener.sheetObjects[2].CellValue(row,prefix+"total_amt") = sheetObjects[0].CellValue(ir,prefix+"total_amt");
					}
					
//					if(form.own_gubun.value != 'own'){
						opener.form.evid_tp_cd.disabled = true;
//					}
					opener.form.csr_curr_cd.readOnly = true;
					
					var evidTpCd = formObject.evid_tp_cd.value;
					var taxCnt = sheetObjects[0].RowCount;
											
					if(taxCnt > 0 && evidTpCd == "1") {
						opener.setMakeTaxEvidence(formObject.tax_amt.value.replace(/,/g,""));
					}
					
					self.close();
					
					break;
						
				case "btn_new":
					ComResetAll();
					setOfcCd();
					break;

				case "btn_close":
					window.close();
					break;
					
				case "tax_inv_yrmon_cal" :
					 var cal = new ComCalendar();
					 cal.setDisplayType('month');
	                 cal.select(form.tax_inv_yrmon, 'yyyy-MM');
	                 break;
	                 
				case "iss_dt_cal": 
	        		var cal = new ComCalendar();
	        		cal.select(form.iss_dt, 'yyyy-MM-dd');
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
        initControl();
        
        sheetObjects[0].ExtendLastCol = false;

        if (document.form.vndrSeq.value != ""){
        	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }

    }
     
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	CoFmsGetBizCombo('FORM', document.form, sheetObj, 'ofc_cd', 'ofc_nm', '11', 'ESM_FMS_0022GS.do', '');
        
        if(opener.sheetObjects[1].rowCount > 0) {
        	setTaxEvidenceData();
        } else {
        	setOfcCd();
        }
		
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
            case 1:
                with (sheetObj) {
                	
                	var prefix = "txd_";
                	
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath] 
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
 
 					var HeadTitle1 = " |Sel|순번|품명|공급가액|세액|합계";
 					var headCount = ComCountHeadTitle(HeadTitle1);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		80,		daCenter,	true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	true,   	prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtDataSeq,      	40,		daCenter,	false,		prefix + "tax_dtl_ser_no",	false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	  	440,	daLeft,		true,		prefix + "itm_nm",			true,		"",		dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "spl_amt",			true,		"",		dfNullInteger,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,   	   		100,	daRight,	true,		prefix + "tax_amt",			true,		"",		dfNullInteger,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "total_amt",		false,		"",		dfNullInteger,		0,		false,		false);
					//InitDataProperty(0, cnt++ , dtData,   	   	100,	daRight,	true,		prefix + "tax_amt",			false,		"|txd_spl_amt|*0.1",				dfNullInteger,		0,		false,		false);
					//InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "total_amt",		false,		"|txd_spl_amt|+|txd_tax_amt|",		dfNullInteger,		0,		false,		false);

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
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
		sheetObj.ShowDebugMsg = false;

        switch(sAction) {

	        case IBSEARCH:      // 사업자 등록 번호 조회

	        	var param = "f_cmd=" + SEARCH03 + "&s_value=" + formObj.vndrSeq.value;
	   			
	   			var sXml = sheetObj.GetSaveXml("FMS_COMGS.do", param);
	   			var rgst_no = ComGetEtcData(sXml, "rgst_no");
	   			
	   			if(typeof rgst_no != "undefined" && rgst_no != "") {
	   				formObj.spl_rgst_no.value = rgst_no;
	   				doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'spl_rgst_no');
	   			}	
	   			
	   			break;

			case IBROWSEARCH:      //조회
			    
				if(!ComIsSaupjaNo(formObj.spl_rgst_no)) {
					formObj.spl_rgst_no.value = "";
					
					return false;
				}
			
		    	formObj.f_cmd.value = SEARCH12;
				
	   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , FormQueryString(formObj));
	
	   			var ownrNm = ComGetEtcData(sXml, "ownrNm");
	   			var coNm = ComGetEtcData(sXml, "coNm");
	   			var bzctNm = ComGetEtcData(sXml, "bzctNm");
	   			var bztpNm = ComGetEtcData(sXml, "bztpNm");
	   			var splAddr = ComGetEtcData(sXml, "splAddr");
	   			var vndrSeq = ComGetEtcData(sXml, "vndrSeq");
	   			
	   			if(typeof vndrSeq == "undefined" || vndrSeq == "" ) {
	   				formObj.spl_rgst_no.value = "";
	   				ComAlertFocus(formObj.spl_rgst_no, ComGetMsg("FMS01453"));
	   				return;
	   			}
	   			
	   			if(typeof ownrNm != "undefined" && ownrNm != "" ) {
					formObj.ownr_nm.value = ownrNm;

				} else {
					formObj.ownr_nm.value = "";
					return;
				}
	   			
	   			if(typeof coNm != "undefined" && coNm != "" ) {
					formObj.co_nm.value = coNm;

				} else {
					formObj.co_nm.value = "";
					return;
				}
	   			
	   			if(typeof bzctNm != "undefined" && bzctNm != "" ) {
					formObj.bzct_nm.value = bzctNm;

				} else {
					formObj.bzct_nm.value = "";
					return;
				}
	   			
	   			if(typeof bztpNm != "undefined" && bztpNm != "" ) {
					formObj.bztp_nm.value = bztpNm;

				} else {
					formObj.bztp_nm.value = "";
					return;
				}
	   			
	   			if(typeof splAddr != "undefined" && splAddr != "" ) {
					formObj.spl_addr.value = splAddr;

				} else {
					formObj.spl_addr.value = "";
					return;
				}
			
	   			break;
        }
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
    	axon_event.addListener  ('change', 'spl_rgst_no_change', 'spl_rgst_no');	//Vessel Code 입력 후 Name정보 가져오기
    	
        axon_event.addListenerForm  ('blur'            ,'obj_deactivate', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
        if(form.evid_tp_cd.value == "4") {
        	document.all.l_evid_tp_cd.style.display = "none";
        	
        	form.tax_pl_cd[0].checked = true;
        	
        	sheetObjects[0].ColHidden("txd_tax_amt") = true;
        }
        
        /*
        CoFmsGetBizCombo('FORM', document.form, sheetObjects[0], 'ofc_cd', 'ofc_nm', '11', 'ESM_FMS_0022GS.do', '');
        
        if(opener.sheetObjects[1].rowCount > 0) {
        	setTaxEvidenceData();
        } else {
        	setOfcCd();
        }
        */
    }
    
    //Axon 이벤트 처리2. 이벤트처리함수 --- start
    
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
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
			case "engup":
	            ComKeyOnlyAlphabet('upper');
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
    function eng_num_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){

    	if(event.srcElement.name == "iss_dt") {
    		var tax_inv_yrmon = form.tax_inv_yrmon.value.trimAll('-');
    		
    		if(tax_inv_yrmon == "") {
    			ComAlertFocus(form.tax_inv_yrmon, ComGetMsg('FMS01469'));
    			form.iss_dt.value = "";
    			return;
    		} else {
	    		var iss_dt = form.iss_dt.value.trimAll('-');
	    		
	    		if(iss_dt != "") {
		    		if(tax_inv_yrmon.substring(0,6) != iss_dt.substring(0,6)) {
		    			
		    			form.iss_dt.value = "";
		    			ComAlertFocus(form.iss_dt, ComGetMsg('FMS01468'));
		    			return;
		    		}
	    		}
    		}
    	}
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "tax_inv_yrmon": 
	    	case "iss_dt": 	
	    	case "spl_rgst_no":
	    		
	    		ComChkObjValid(event.srcElement);
	    	
    		break;
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
     * 사업자 등록 번호 변경 시 체크한다. <br>
     **/
    function spl_rgst_no_change() {
    	
    	ComChkObjValid(event.srcElement);
    	
    	form.ownr_nm.value = "";
   		form.co_nm.value = "";
   		form.bzct_nm.value = "";
   		form.bztp_nm.value = "";
   		form.spl_addr.value = "";
    	 
    	if (form.spl_rgst_no.value != "") {
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'spl_rgst_no');
       	}
    }
     
    /**
     * IBSheet Object 합 구하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} sheetObj    IBSheet Row
     **/
 	function sheet1_OnChangeSum(sheetObj, Row) {
 		//sheetObj.SumText(0,"Seq") = "";
 		alert("sum=>"+sheetObj.SumText(0,"txd_spl_amt"));
 		//sheetObj.SumText(0,"bnk_prc_amt") = "Sub-Total Amount";
 	}
 	
 	/**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
	function sheet1_OnChange(sheetObj,row,col,value) {

		var prefix = "txd_";
		
		if(sheetObj.ColSaveName(col)==prefix + "spl_amt") {
	  		var splAmtCol = sheetObjects[0].SaveNameCol(prefix+"spl_amt");
	  		var splAmtValue = sheetObjects[0].CellValue(row,splAmtCol);
	  		
	  		if(form.tax_pl_cd[0].checked) {
	  			sheetObjects[0].CellValue(row,prefix+"tax_amt") = 0;
	  			sheetObjects[0].CellValue(row,prefix+"total_amt") = sheetObjects[0].CellValue(row,prefix+"spl_amt");
	  		} else {
	  			sheetObjects[0].CellValue(row,prefix+"tax_amt") = sheetObjects[0].CellValue(row,prefix+"spl_amt") * 0.1;
	  			sheetObjects[0].CellValue(row,prefix+"total_amt") = parseInt(sheetObjects[0].CellValue(row,prefix+"spl_amt")) + parseInt(sheetObjects[0].CellValue(row,prefix+"spl_amt")) * 0.1; 
	  		}
		}
		
		if(sheetObj.ColSaveName(col)==prefix + "tax_amt") {
	  		var splAmtCol = sheetObjects[0].SaveNameCol(prefix+"spl_amt");
	  		var splAmtValue = sheetObjects[0].CellValue(row,splAmtCol);
	  		
	  		if(form.tax_pl_cd[0].checked) {
	  			sheetObjects[0].CellValue(row,prefix+"tax_amt") = 0;
	  			sheetObjects[0].CellValue(row,prefix+"total_amt") = sheetObjects[0].CellValue(row,prefix+"spl_amt");
	  		} else {
	  			sheetObjects[0].CellValue(row,prefix+"total_amt") = parseInt(sheetObjects[0].CellValue(row,prefix+"spl_amt")) + parseInt(sheetObjects[0].CellValue(row,prefix+"tax_amt"));	  			
	  			form.tax_amt.value = parseInt(sheetObjects[0].CellValue(row,prefix+"tax_amt"));
	  		}
		}		
		
		
		setCalculation(prefix, col);
		
		/*
		var total_spl_amt = 0;
		
		for(var ir=1; ir<=sheetObjects[0].LastRow; ir++) {
			if(sheetObj.ColSaveName(col)==prefix + "spl_amt") {
		  		var splAmtCol = sheetObjects[0].SaveNameCol(prefix+"spl_amt");
		  		var splAmtValue = sheetObjects[0].CellValue(ir,splAmtCol);
		  		
		  		total_spl_amt += parseInt(splAmtValue);
			}
		}

		form.spl_amt.value = ComAddComma(total_spl_amt);
		
		if(form.tax_pl_cd[0].checked) {
			form.tax_amt.value = 0;
			form.total_amt.value = ComAddComma(total_spl_amt);
		} else {
			form.tax_amt.value = ComAddComma(total_spl_amt * 0.1);
			form.total_amt.value = ComAddComma(total_spl_amt + total_spl_amt * 0.1);
		}
		*/
		
	}
    
    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  prefix     	sheetObj의 구분값
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @return {없음}
     **/
    function setCalculation(prefix, col) {
    	var total_spl_amt = 0;
    	var total_tax_amt = 0;
    	var total_total_amt = 0;
    	
		for(var ir=1; ir<=sheetObjects[0].LastRow; ir++) {
			// IF조건 주석처럼. Editor 2012.07.02.
			//if(sheetObjects[0].ColSaveName(col)==prefix + "spl_amt") {
				var splAmtCol = sheetObjects[0].SaveNameCol(prefix+"spl_amt");					
				var splAmtValue = sheetObjects[0].CellValue(ir,splAmtCol);				
		  		total_spl_amt += parseInt(splAmtValue);
		  		
				var taxAmtCol = sheetObjects[0].SaveNameCol(prefix+"tax_amt");					
				var taxAmtValue = sheetObjects[0].CellValue(ir,taxAmtCol);				
				total_tax_amt += parseInt(taxAmtValue);
		  		
				var totalAmtCol = sheetObjects[0].SaveNameCol(prefix+"total_amt");					
				var totalAmtValue = sheetObjects[0].CellValue(ir,totalAmtCol);				
				total_total_amt += parseInt(totalAmtValue);		  		
		  		
			//}
		}

		form.spl_amt.value = ComAddComma(total_spl_amt);			// 공급가액
		
		
		if(form.tax_pl_cd[0].checked) {
			form.tax_amt.value = 0;														// 세액
			form.total_amt.value = ComAddComma(total_spl_amt);			// 총합계
		} else {
//			form.tax_amt.value = ComAddComma(total_spl_amt * 0.1);
//			form.total_amt.value = ComAddComma(total_spl_amt + total_spl_amt * 0.1);
			
			form.tax_amt.value = ComAddComma(total_tax_amt);
			form.total_amt.value = ComAddComma(total_total_amt);
			
		}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @return {boolean}
     **/
    function validateForm(){
    	var prefix = "txd_"; 
    	
        for(var ir=1; ir<=sheetObjects[0].LastRow; ir++) {

    		var itmNmCol = sheetObjects[0].SaveNameCol(prefix+"itm_nm");
	  		var itmNmValue = sheetObjects[0].CellValue(ir,itmNmCol);

	  		var splAmtCol = sheetObjects[0].SaveNameCol(prefix+"spl_amt");
	  		var splAmtValue = sheetObjects[0].CellValue(ir,splAmtCol);

	  		var taxAmtCol = sheetObjects[0].SaveNameCol(prefix+"tax_amt");
	  		var taxAmtValue = sheetObjects[0].CellValue(ir,taxAmtCol);
	  		
	  		
	  		if(itmNmValue == "") {
	  			ComShowCodeMessage("FMS01449");
	  			sheetObjects[0].SelectCell(ir,prefix+"itm_nm");
	  			sheetObjects[0].ValidateFail = true;
	  			return;
	  			
	  		} else if(splAmtValue == "") {
	  			ComShowCodeMessage("FMS01450");
	  			sheetObjects[0].SelectCell(ir,prefix+"spl_amt");
	  			sheetObjects[0].ValidateFail = true;
	  			return;

	  		} else if(taxAmtValue == "") {
	  			alert("Please input Tax amount.");
	  			sheetObjects[0].SelectCell(ir,prefix+"tax_amt");
	  			sheetObjects[0].ValidateFail = true;
	  			return;	  			
	  			
	  		} else if(itmNmValue != "") {
	  			
	  			if(form.tax_div_cd[0].checked) {
	  				if(parseInt(splAmtValue) <= 0) {
			  			ComShowCodeMessage("FMS01451");
			  			sheetObjects[0].SelectCell(ir,prefix+"spl_amt");
			  			sheetObjects[0].ValidateFail = true;
			  			return;	
	  				}
	  			} else {
	  				if(parseInt(splAmtValue) >= 0) {
			  			ComShowCodeMessage("FMS01452");
			  			sheetObjects[0].SelectCell(ir,prefix+"spl_amt");
			  			sheetObjects[0].ValidateFail = true;
			  			return;	
	  				}
	  			}
	  		}
    	}
        
        if(form.tax_iss_cd[0].checked == false
           && form.tax_iss_cd[1].checked == false) {
        	ComShowCodeMessage("FMS01479");
        	return;
        }
        
        var tax_inv_yrmon = form.tax_inv_yrmon.value.trimAll('-');
        var iss_dt = form.iss_dt.value.trimAll('-');
        
        if(tax_inv_yrmon.substring(0,6) != iss_dt.substring(0,6)) {
			
			form.iss_dt.value = "";
			ComAlertFocus(form.iss_dt, ComGetMsg('FMS01468'));
			return;
		}
        
        if(form.tax_div_cd[0].checked) { //[CHM-201322549] add 2013.02.12 //흑자 일 경우만
			// add 2012.07.02.
		    if( parseInt( form.spl_amt.value ) <= 0) {
				ComShowCodeMessage("FMS01450");
				return;
		    }	
		}
  		
        return true;
    }
    
    /**
     * row 삭제하기. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	변수 구분값
     * @return {없음}
     **/
 	function rowRemove(sheetObj, prefix) {
 		var sRow = sheetObj.FindCheckedRow(prefix + "DelChk");
 		if (sRow == "") return;
 		
 		//가져온 행을 배열로 반든다.
 		var arrRow = sRow.split("|"); //결과 : "1|3|5|"
 		for (var idx=arrRow.length-2; idx>=0; idx--){
 			var row = arrRow[idx];
 			
 			sheetObj.RowHidden(row)= true;
 			sheetObj.RowStatus(row)= "D";
 		}
 		
 		setCalculation(prefix, 4);
 	}
    
    /**
     * Grid 초기화 하기. <br>
     * @return {없음}
     **/
    function gridReset() {
    	sheetObjects[0].RemoveAll();
    }
    
    /**
     * Office Code 세팅 하기. <br>
     * @return {없음}
     **/
    function setOfcCd() {
    	var length = form.ofc_cd.length;
		
		if(length > 0) {
			for(var i=0; i<length; i++) {
				if(form.ofc_cd.options[i].value == "SELAAG") {
					form.ofc_cd.selectedIndex = i;
					break;
				}
			}
		}
    }
    
    /**
     * Main 페이지의 Hidden Data를 세팅한다. <br>
     * @return {없음}
     **/
    function setTaxEvidenceData() {    	
    	var prefix = "tax_";
    	
    	var csr_no = opener.form.csr_no.value;
    	
    	form.tax_inv_yrmon.value = opener.sheetObjects[1].CellText(1,prefix+"tax_inv_yrmon");
    	
    	var ofc_cd = opener.sheetObjects[1].CellValue(1,prefix+"ofc_cd")
    	var length = form.ofc_cd.length;
		
		if(length > 0) {
			for(var i=0; i<length; i++) {
				if(form.ofc_cd.options[i].value == ofc_cd) {
					form.ofc_cd.selectedIndex = i;
					break;
				}
			}
		}
		
		var tax_iss_cd = opener.sheetObjects[1].CellValue(1,prefix+"tax_iss_cd");
		
		if(tax_iss_cd == "PAPER") {
			form.tax_iss_cd[1].checked = true;
		} else {
			form.tax_iss_cd[0].checked = true;
		}

		var tax_vat_tp_cd = opener.sheetObjects[1].CellValue(1,prefix+"tax_vat_tp_cd");
		
		if(tax_vat_tp_cd == "1") {
			form.tax_vat_tp_cd[0].checked = true;
		} else {
			form.tax_vat_tp_cd[1].checked = true;
		}
		
		var tax_div_cd = opener.sheetObjects[1].CellValue(1,prefix+"tax_div_cd");
		
		if(tax_div_cd == "1") {
			form.tax_div_cd[0].checked = true;
		} else {
			form.tax_div_cd[1].checked = true;
		}
		
		if(form.evid_tp_cd.value == "1") {
			
			var tax_pl_cd = opener.sheetObjects[1].CellValue(1,prefix+"tax_pl_cd");
			
			if(tax_pl_cd == "1") {
				form.tax_pl_cd[0].checked = true;
			} else {
				form.tax_pl_cd[1].checked = true;
			}
		}
		
		form.spl_rgst_no.value = opener.sheetObjects[1].CellText(1,prefix+"spl_rgst_no");
		
		form.ownr_nm.value = opener.sheetObjects[1].CellValue(1,prefix+"ownr_nm");
		
		form.co_nm.value = opener.sheetObjects[1].CellValue(1,prefix+"co_nm");
		
		form.bzct_nm.value = opener.sheetObjects[1].CellValue(1,prefix+"bzct_nm");
		
		form.bztp_nm.value = opener.sheetObjects[1].CellValue(1,prefix+"bztp_nm");
		
		form.spl_addr.value = opener.sheetObjects[1].CellValue(1,prefix+"spl_addr");
		
		form.iss_dt.value = opener.sheetObjects[1].CellText(1,prefix+"iss_dt");
		
		form.spl_amt.value = opener.sheetObjects[1].CellText(1,prefix+"spl_amt");
		
		form.tax_amt.value = opener.sheetObjects[1].CellText(1,prefix+"tax_amt");
		
		form.total_amt.value = opener.sheetObjects[1].CellText(1,prefix+"total_amt");
		
		prefix = "txd_";
				
		for(var ir=1; ir<=opener.sheetObjects[2].LastRow; ir++) {
			var row = sheetObjects[0].DataInsert(-1);
			
			
			if(csr_no != "") {		    	
		    	
				ComBtnDisable("btn_rowAdd");
				ComBtnDisable("btn_rowDel");
				ComBtnDisable("btn_confirm");
				ComBtnDisable("btn_new");
				
				form.tax_inv_yrmon.readOnly = true;
				form.spl_rgst_no.readOnly = true;
				form.iss_dt.readOnly = true;
				
				form.ofc_cd.disabled = true;
				form.tax_vat_tp_cd[0].disabled = true;
				form.tax_div_cd[0].disabled = true;
				form.tax_pl_cd[0].disabled = true;
				
				form.tax_vat_tp_cd[1].disabled = true;
				form.tax_div_cd[1].disabled = true;
				form.tax_pl_cd[1].disabled = true;
				
				document.images["iss_dt_cal"].name = "no_iss_dt_cal";
		    	form.iss_dt_cal.style.cursor = "default";
		    	
		    	document.images["tax_inv_yrmon_cal"].name = "no_tax_inv_yrmon_cal";
		    	form.tax_inv_yrmon_cal.style.cursor = "default";
				
				sheetObjects[0].CellEditable(ir,prefix+"DelChk") = false;
				sheetObjects[0].CellValue(ir,prefix+"itm_nm") = opener.sheetObjects[2].CellValue(ir,prefix+"itm_nm");
				sheetObjects[0].CellValue(ir,prefix+"spl_amt") = opener.sheetObjects[2].CellValue(ir,prefix+"spl_amt");
				
				sheetObjects[0].CellEditable(ir, prefix+"itm_nm") = false;
				sheetObjects[0].CellEditable(ir, prefix+"spl_amt") = false;
			} else {				
				sheetObjects[0].CellValue(ir,prefix+"itm_nm") = opener.sheetObjects[2].CellValue(ir,prefix+"itm_nm");
				sheetObjects[0].CellValue(ir,prefix+"spl_amt") = opener.sheetObjects[2].CellValue(ir,prefix+"spl_amt");
			}			
			sheetObjects[0].CellValue(ir,prefix+"tax_amt") = opener.sheetObjects[2].CellValue(ir,prefix+"tax_amt");			
			sheetObjects[0].CellValue(ir,prefix+"total_amt") = opener.sheetObjects[2].CellValue(ir,prefix+"total_amt");			
		}
	
		// 임시
		if(form.own_gubun.value == 'own'){
			ComBtnEnable("btn_rowAdd");
			ComBtnEnable("btn_rowDel");
			ComBtnEnable("btn_confirm");
			ComBtnEnable("btn_new");			
			
		}	
    }