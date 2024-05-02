/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0044.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
* ------------------------------------------------------
* HISTORY 
* 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가. 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    
    /**
     * @extends 
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0044() {
    	
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	
    }
    
    
    
   	/* 개발자 작업	*/
    

    // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         var sheetObject1 = sheetObjects[0];
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
       		var isOpen = false;
       		var sUrl = "";
       		var sId = "";
    		var srcName = window.event.srcElement.getAttribute("name");
    		var vvdValue   = formObject.vvd.value;
        	var ssrNoValue = formObject.ssr_no.value;

            switch(srcName) {

				case "btn_new":
					formObject.reset();
					formObject.pod.Index2=0;
					break;
				case "btn_vvdListForSSRCreation":
					sUrl = "ESM_BKG_0551.do&pgmNo=ESM_BKG_0551&id=ESM_BKG_0551&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId = "ESM_BKG_0551"
					break;
				case "btn_ssrViewForCusrep":
					sUrl = "ESM_BKG_0494.do&mainPage=true&pgmNo=ESM_BKG_0494&id=ESM_BKG_0494&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue + "&pod="+form.pod.Code;
					sId = "ESM_BKG_0494"
					break;
				case "btn_blListForCuscar":
					sUrl = "ESM_BKG_0063.do&pgmNo=ESM_BKG_0063&id=ESM_BKG_0063&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue+ "&pod="+form.pod.Code;
					sId = "ESM_BKG_0063"
					break;
				case "btn_blView":
					sUrl = "ESM_BKG_0045.do&mainPage=true&pgmNo=ESM_BKG_0045&id=ESM_BKG_0045&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId = "ESM_BKG_0045"
					break;
				case "btn_cusrepHistoryByVvd":
					sUrl = "ESM_BKG_0186.do&mainPage=true&pgmNo=ESM_BKG_0186&id=ESM_BKG_0186&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId = "ESM_BKG_0186"
					break;
				case "btn_cuscarHisByBl":
					sUrl = "ESM_BKG_0183.do&mainPage=true&pgmNo=ESM_BKG_0183&id=ESM_BKG_0183&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId = "ESM_BKG_0183"
					break;
				case "btn_codeValidate":
					sUrl = "ESM_BKG_1054.do&mainPage=true&pgmNo=ESM_BKG_1054-1&id=ESM_BKG_1054&vvd=" + vvdValue + "&pod_cd="+form.pod.Code;
					sId = "ESM_BKG_1054"
						break;
				case "btn_notyLetter":
					sUrl = "ESM_BKG_0672.do&mainPage=true&pgmNo=ESM_BKG_0672-01&id=ESM_BKG_0672&vvd=" + vvdValue + "&pod_cd="+form.pod.Code;
					sId = "ESM_BKG_0672"
					break;
				case "btn_interCustomDataMgnt":
					sUrl = "ESM_BKG_0240.do&mainPage=true&pgmNo=ESM_BKG_0240&id=ESM_BKG_0240&vvd=" + vvdValue + "&ssr_no=" + ssrNoValue;
					sId = "ESM_BKG_0240"
					break;
                     
            } // end switch
            if (sId != "") module_pop(sUrl, sId);
    	}catch(e) {
    		if( e == "[object Error]" ) {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    function module_pop(url, id) {
        try {
            var iWidth = 1040;
            var iHeight = 700;
            var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
            var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
            var sFeatures = "status=no, width="+iWidth+", height="+iHeight+", resizable=yes, scrollbars=yes, left="+leftpos+", top="+toppos;
            //var winObj = window.open("/hanjin/nis2010Main.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + url, id, sFeatures);
            var winObj = window.open("/hanjin/alpsMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^" + url, id, sFeatures);
            winObj.focus();
            //var sUrl = "/hanjin/nis2010Main.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^hanjin^ESM_BKG_0442.do&pgmNo=ESM_BKG_0442.do?crn_no="+formObj.frm_crn_number.value;
        } catch(err) { alert(err.message); }
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
     * 콤보 Object를 comboObjects 배열에 등록
     * 
     * @param combo_obj
     * @return
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
    	for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
				
    	
	      //MultiCombo초기화 
 	    for(var k=0;k < comboObjects.length;k++){
 	        initCombo(comboObjects[k],comboObjects[k].id);
 	    }

        initControl();
        
        doActionIBSheet(sheetObjects[0], form, COMMAND11);
    }

    function initControl() {
    	//화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    /**
     * Combo Object 초기화
     * 
     * @param comboObj
     * @param comNo
     * @return
     */
    function initCombo(comboObj, comNo) {
    	switch (comboObj.id) {
    		case "pod":
    			with (comboObj) {
    				BackColor = "#CCFFFD";
    				Style = 1;//0 -편집 가능,1 -편집 불가능
    			}
    			break;
    	} // end switch
    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	
    	var vvdValue   = formObject.vvd.value;
    	var ssrNoValue = formObject.ssr_no.value;
    	if (ComChkLen(vvdValue, 9) == "2" || ComChkLen(ssrNoValue, 6) == "2" ) {
    		document.form.f_cmd.value = SEARCH;
        	sheetObjects[0].DoSearch("ESM_BKG_0044GS.do?vvd="+vvdValue+"&ssr_no="+ssrNoValue, FormQueryString(document.form));
        	
        	vvdValue   = sheetObjects[0].CellValue( 1, 2 );
        	ssrNoValue = sheetObjects[0].CellValue( 1, 3 );
        	var vvdNm  = sheetObjects[0].CellValue( 1, 4 );
        	var eta    = sheetObjects[0].CellValue( 1, 5 );

        	formObject.vvd.value = vvdValue;
        	formObject.ssr_no.value = ssrNoValue; 
        	formObject.eta.value = eta; 
        	
        	//if(vvdValue != '')
        	//	formObject.pol_cd.focus();
        		
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
        	case 1:
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 0; // mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|SEQ|VVD|SSR_NO|POL|ENG_NM|ETA";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,    daCenter,  false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,	 		 45,    daCenter,    true,     "SEQ",     		false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,    true,     "vvd",     		false,    "",      dfNone, 		0,     false,		false);
                    InitDataProperty(0, cnt++ , dtData, 		 155,   daCenter,    true,     "ssr_no",      false,    "",      dfNone, 		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      60,    daCenter,    true,     "vvd_nm",       	false,    "",      dfNone, 		0,     false,		false);
                                                                                                                                                 
                    InitDataProperty(0, cnt++ , dtData,      55,    daCenter,    true,     "eta_dt",       	false,    "",      dfNone, 		0,     false,		false);

               }
                break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        
    	sheetObj.ShowDebugMsg = false;
    	var formObject = document.form;
    	var vvdValue   = formObject.vvd.value;
    	var ssrNoValue = formObject.ssr_no.value;
    	var pod        = formObject.pod.Code;
    	
    	var param = '?vvd=' + vvdValue + '&ssr_no=' + ssrNoValue + '&pod=' + pod ;  
        
        switch(sAction) {
        
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_BKG_0044GS.do", FormQueryString(formObj));
					
					//상위 시트가 조회되면 첫째 로우 의 값으로 두번째 시트를 조회한다.
					var pol = sheetObj.CellValue( 1, 2 );
					var vvd = document.form.vvd.value;
			    	sheetObjects[0].DoSearch("ESM_BKG_0044GS.do?vvd="+vvd+"&pol_cd="+pol, FormQueryString(document.form));
				}
				break;
			case COMMAND11 : //  PORT 조회
				
				formObj.f_cmd.value = SEARCH11;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
				ComXml2ComboItem(sXml, formObj.pod, "pod_cd", "pod_cd");
				formObj.pod.Code = form.in_pod.value;
				
				if(formObj.pod.Index < 0) formObj.pod.Index2 = 0;
				
				ComOpenWait(false);
				
				break;		
				
		
        }
    }

    

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        	switch (sAction) {
	 		case IBSEARCH: // 조회
	 			if (formObj.vvd.value == "" || (formObj.ssr_no.value == "" ) ) 
	 			{
	 				ComShowCodeMessage('BKG00626','VVD or SSR NO');
	 				formObj.vvd.focus();
	 				return false;
	 			}
	 							
	 			return true;
	 		break;
	 		case COMMAND01:
	 			return true;
	 		break;
 		 			
        	}
        }
        
    /**
     * 시트를 더블클릭했을 때 처리
     * @param row
     * @param col
     * @return
     */    
    function sheet1_OnDblClick(sheetObj, row, col) {
    	var pol = sheetObj.CellValue( row, 2 );
    	var vvd = document.form.vvd.value;
    	document.form.f_cmd.value = SEARCH02;
    	sheetObjects[1].DoSearch("ESM_BKG_0044GS.do?vvd="+vvd+"&pol_cd="+pol, FormQueryString(document.form));
    }        

    /**
     * 시트를 클릭했을 때 처리
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	for(var i=1; i <= sheetObj.RowCount; i++) {
    		sheetObj.RowBackColor(i) = sheetObj.UnEditableColor;
		}
    	sheetObj.RowBackColor(row) = sheetObj.SelectBackColor;
    }
    
    /**
     * 시트를 키보드로 이동할때 처리
     */
    function sheet1_OnKeyUp(row, col, KeyCode, Shift) {
    	sheet1_OnClick(sheetObjects[0], col, 0);
    }
 		
	/* 개발자 작업  끝 */    