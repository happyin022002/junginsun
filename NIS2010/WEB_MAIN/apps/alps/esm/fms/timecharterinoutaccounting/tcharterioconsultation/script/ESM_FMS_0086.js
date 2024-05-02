/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0086.js
*@FileTitle : Tax Evidence
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.03 정윤태
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
     * @class ESM_FMS_0086 : ESM_FMS_0086 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0086() {
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
        this.setOfcCd				= setOfcCd;
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

				case "btn_close":
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

    }
     
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	CoFmsGetBizCombo('FORM', document.form, sheetObj, 'ofc_cd', 'ofc_nm', '11', 'ESM_FMS_0022GS.do', '');
        
        doActionIBSheet(sheetObj, document.form, IBSEARCH);
		
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
                	
                    // 높이 설정
                    style.height = 120;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
 
 					var HeadTitle1 = " |순번|품명|공급가액|세액|합계";
 					var headCount = ComCountHeadTitle(HeadTitle1);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		80,		daCenter,	true,		"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,      	40,		daCenter,	false,		"tax_dtl_ser_no",	false,		"",		dfNone,				0,		false,		true);
					//InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	true,   	"DelChk");
					InitDataProperty(0, cnt++ , dtData,      	  	440,	daLeft,		true,		"itm_nm",			false,		"",		dfNone,				0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		"spl_amt",			false,		"",		dfNullInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,   	   		100,	daRight,	true,		"tax_amt",			false,		"",		dfNullInteger,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		"total_amt",		false,		"",		dfNullInteger,		0,		false,		false);

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

			case IBSEARCH:      //조회

				formObj.f_cmd.value = SEARCH;
  				
  				var sXml = sheetObj.GetSearchXml("ESM_FMS_0086GS.do" , FormQueryString(formObj));
  				
  				var arrXml = sXml.split("|$$|");
	       		
	       		if (arrXml.length > 0) {
	       			sheetObj.LoadSearchXml(arrXml[0]);
	       		}
  				
	   			var taxInvYrmon = ComGetEtcData(sXml, "taxInvYrmon");
	   			var ofcCd = ComGetEtcData(sXml, "ofcCd");
	   			var docEvidTpCd = ComGetEtcData(sXml, "docEvidTpCd");
	   			var taxVatTpCd = ComGetEtcData(sXml, "taxVatTpCd");
	   			var taxNaidFlg = ComGetEtcData(sXml, "taxNaidFlg");
	   			var taxDivCd = ComGetEtcData(sXml, "taxDivCd");
	   			var faFlg = ComGetEtcData(sXml, "faFlg");
	   			var taxPlCd = ComGetEtcData(sXml, "taxPlCd");
	   			var taxNslFlg = ComGetEtcData(sXml, "taxNslFlg");
	   			var splRgstNo = ComGetEtcData(sXml, "splRgstNo");
	   			var ownrNm = ComGetEtcData(sXml, "ownrNm");
	   			var coNm = ComGetEtcData(sXml, "coNm");
	   			var bzctNm = ComGetEtcData(sXml, "bzctNm");
	   			var bztpNm = ComGetEtcData(sXml, "bztpNm");
	   			var splAddr = ComGetEtcData(sXml, "splAddr");
	   			var issDt = ComGetEtcData(sXml, "issDt");
	   			var splAmt = ComGetEtcData(sXml, "splAmt");
	   			var taxAmt = ComGetEtcData(sXml, "taxAmt");
	   			var totalAmt = ComGetEtcData(sXml, "totalAmt");
	   			
	   			if(typeof taxInvYrmon != "undefined" && taxInvYrmon != "" ) {
	   				formObj.tax_inv_yrmon.value = taxInvYrmon;
	   				
	   				setOfcCd(ofcCd);
	   				
	   				if(typeof docEvidTpCd != "undefined" && docEvidTpCd != "" ) {
		   				if(docEvidTpCd == "PAPER") {
		   					formObj.tax_iss_cd[1].checked = true;
		   				} else {
		   					formObj.tax_iss_cd[0].checked = true;
		   				}
	   				}
	   			
		   			//Evidence Type : TAX 인 경우
		   			if(typeof taxVatTpCd != "undefined" && taxVatTpCd != "" ) {
		   				if(taxVatTpCd == "1") {
		   					formObj.tax_vat_tp_cd[0].checked = true;
		   				} else {
		   					formObj.tax_vat_tp_cd[1].checked = true;
		   				}
		   				
		   				if(taxPlCd == "1") {
			   				formObj.tax_pl_cd[0].checked = true;
			   			} else {
			   				formObj.tax_pl_cd[1].checked = true;
			   			}
		   				
		   			//Evidence Type : CI 인 경우
		   			} else {
		   				document.all.l_evid_tp_cd.style.display = "none";
		   	        	
		   				formObj.tax_pl_cd[0].checked = true;
		   	        	
		   	        	sheetObjects[0].ColHidden("tax_amt") = true;
		   			}
		   			
		   			if(taxDivCd == "1") {
		   				formObj.tax_div_cd[0].checked = true;
		   			} else {
		   				formObj.tax_div_cd[1].checked = true;
		   			}
		   			
		   			formObj.spl_rgst_no.value = splRgstNo;
		   			
		   			if(typeof ownrNm != "undefined" && ownrNm != "" ) {
		   				formObj.ownr_nm.value = ownrNm;
		   			}
		   			
		   			if(typeof coNm != "undefined" && coNm != "" ) {
		   				formObj.co_nm.value = coNm;
		   			}
		   			
		   			if(typeof bzctNm != "undefined" && bzctNm != "" ) {
		   				formObj.bzct_nm.value = bzctNm;
		   			}
		   			
		   			if(typeof bztpNm != "undefined" && bztpNm != "" ) {
		   				formObj.bztp_nm.value = bztpNm;
		   			}
		   			
		   			if(typeof splAddr != "undefined" && splAddr != "" ) {
		   				formObj.spl_addr.value = splAddr;
		   			}
		   			
		   			formObj.iss_dt.value = issDt;
		   			formObj.spl_amt.value = splAmt;
		   			formObj.tax_amt.value = taxAmt;
		   			formObj.total_amt.value = totalAmt;
	   			} else {
	   				setOfcCd(ofcCd);
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
        
        /*
        if(form.evid_tp_cd.value == "4") {
        	document.all.l_evid_tp_cd.style.display = "none";
        	
        	form.tax_pl_cd[0].checked = true;
        	
        	sheetObjects[0].ColHidden("txd_tax_amt") = true;
        }
        */
        
        //CoFmsGetBizCombo('FORM', document.form, sheetObjects[0], 'ofc_cd', 'ofc_nm', '11', 'ESM_FMS_0022GS.do', '');
        
        //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        
        /*
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
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "tax_inv_yrmon": 
	    	case "iss_dt": 	
	    	//case "spl_rgst_no":
	    		
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
     * Office Code 세팅 하기. <br>
     * @return {없음}
     **/
    function setOfcCd(ofcCd) {
    	if(typeof ofcCd == "undefined" || ofcCd == "") {
    		var length = form.ofc_cd.length;
    		
    		for(var i=0; i<length; i++){ 
        		form.ofc_cd.options.remove(0); 
        	}
    		
    	} else {
	    	var length = form.ofc_cd.length;
			
			if(length > 0) {
				for(var i=0; i<length; i++) {
					if(form.ofc_cd.options[i].value == ofcCd) {
						form.ofc_cd.selectedIndex = i;
						break;
					}
				}
			}
    	}
		
		form.ofc_cd.disabled = true;
    }