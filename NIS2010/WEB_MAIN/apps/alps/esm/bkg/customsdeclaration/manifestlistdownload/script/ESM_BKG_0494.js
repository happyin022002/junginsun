/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0494.js
*@FileTitle : Customer Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.16 정재엽
* 1.0 Creation
* -----------------------------------------------------
* History
* 2011.10.24 김보배 [CHM-201114022] [BKG] ANCS > BL inquiry< Download 버튼 제거
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
    function esm_bkg_0494() {
    	
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    	this.sheet1_OnKeyUp         = sheet1_OnKeyUp;
    	this.setDataCombo			= setDataCombo;
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
 
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */                    
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	doActionIBSheet(sheetObjects[0],document.form, INIT);
    	
    	//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'obj_KeyDown', 'form');
    	
    	initComboSetVal(sheetObjects[0],document.form);
    	
    	if( document.form.pod.value != '' ){
    		document.form.frm_pod.Code = document.form.pod.value;
    	}
    	
    	if( document.form.vvd.value != '' ){
    		doActionIBSheet(sheetObjects[0],document.form,SEARCH);
    	}
    	//if( document.form.popup.value == 'y' ){
       // 	document.getElementById("navi").style.display = "none";
        //	//document.getElementById("headtitle").innerHTML="<tr><td class='title'><img src='img/icon_title_dot.gif' align='absmiddle'><span id='title'></span></td></tr>"
       // }
    	//document.form.vvd.value = 'AENA0052W';
    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if(srcName != 'frm_remark'){
	    	if (event.keyCode == 13) {
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH);
	    	}
    	}
		if (ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
    	}
    }
    
    
    
    
    
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
					doActionIBSheet(sheetObject,document.form,SEARCH);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,MULTI);
				break;
				
				case "btn_new":
					doActionIBSheet(sheetObject,formObject,COMMAND03);
				break;	
				
				case "btn_transmission":
					doActionIBSheet(sheetObject,formObject,MULTI01);
				break;	
				case "btn_cusrep":
					ComOpenWindow2("ESM_BKG_0186.do?vvd=" + formObject.vvd.value , "", "width=1000,height=540");
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
     * 페이지에 생성된 IBMultiCombo Object를 comboObjects 배열에 등록한다. <br>
     * comboObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComComboObject} 함수에 의해서 IBMultiCombo Object가 생성되면서 자동 호출된다. <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){          
       comboObjects[comboCnt++] = combo_obj;
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
	 * Berth Code 데이타를 가져온다.
	 */
    //pod를 하드코딩에서 콤보로 변경 후 pod에 따라 Berth Code를 변경시키기 위해 변수를 추가 함. 2012.03.16
    var berth_combo_list= new Array();
	function initComboSetVal(sheetObj,formObj){
		formObj.f_cmd.value = SEARCH01;
		formObj.slan_cd.UseEdit = true;
 	
		var hrdCdgId = 'ANR_CSTMS_BRTH_CD'; 
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0494GS.do?hrd_cdg_id="+hrdCdgId, FormQueryString(formObj));
	    berth_combo_list = ComBkgXml2Array(sXml, "attr_ctnt2|attr_ctnt1");
//		ComBkgXml2ComboItem(sXml, formObj.slan_cd, "attr_ctnt1", "attr_ctnt2"); // pod onChange에서 처리함
		form.frm_pod.BackColor = "#CCFFFD";
		form.frm_pod.Style = 1;//0 -편집 가능,1 -편집 불가능
		doActionIBSheet(sheetObjects[0], formObj, COMMAND11);
	}	
	

	/*
	 * 2012.03.16
	 * input에서 콤보로 바뀌면서 onchange 부분을 따로 처리함 */
	function frm_pod_OnChange(comboObj,code,text) {
		var formObject = document.form;
		formObject.slan_cd.RemoveAll(); 
	    for(var i in berth_combo_list){
	    	if( berth_combo_list[i][1].substring(0,5) == code){
	    		formObject.slan_cd.InsertItem(-1, berth_combo_list[i][1], berth_combo_list[i][0]);//맨 마지막에 추가 text,code순
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
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 0;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = "|user_date";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(22, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                                        
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,	0,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"user_date",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"eta_call_date",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"berth_code",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"bkg_ttl",		false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"remark",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vsl_flag",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"lloyd_type",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vsl_name",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"crsrep",			false,	"",	dfNone,	0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"last_edi",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"pagerows",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"ssr_no",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"vvd",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"demdet_free_time",			false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"ibflag",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"lloyd_no",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"dnld_ttl",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"user_id",		false,	"",	dfNone,	0,	false,	false);
	            	InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"prv_prot",		false,	"",	dfNone,	0,	false,	false);
				
	            	InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"pod",		false,	"",	dfNone,	0,	false,	false);
	            	InitDataProperty(0, cnt++ , dtData,	0,	daCenter,	false,	"lloyd_tp_cd",		false,	"",	dfNone,	0,	false,	false);
                }
                break;
            }
        }
    
    
     // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        
    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
			case SEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					
  				  	ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch("ESM_BKG_0494GS.do", FormQueryString(formObj));
					//var sXml = sheetObj.GetSearchXml("ESM_BKG_0494GS.do", FormQueryString(formObj));
					
					if(sheetObj.RowCount > 0){
						IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
						
						// Retrieve시 조회된 ssr_no 값 셋팅
						formObj.old_ssr_no.value = sheetObj.CellSearchValue(1,"ssr_no");
						
						var diff = formObj.frm_bkg_ttl.value - formObj.frm_dnld_ttl.value;
						if (diff < 0) 
							diff = (diff * -1);
						formObj.frm_diff.value = diff;
						

						var bethCd = sheetObj.CellValue(1,3);
						var accept = sheetObj.CellValue(1,9);
						var accept_A = "<select style='width:120;' name='transflag'><option value='R'>Replace</option><option value='C'>Cancel</option></select>";
						var accept_N = "<select style='width:120;' name='transflag'><option value='O' selected='selected'>Original</option></select>";
						
						if( accept == 'A' )
							document.getElementById('trans_sel').innerHTML = accept_A ;
						else
							document.getElementById('trans_sel').innerHTML = accept_N ;
						    //document.getElementById("headtitle").innerHTML=

						//2012.03.19
						formObj.slan_cd.Code = bethCd; 
						/*
						if( 'S913' == bethCd )
							ComSetObjValue(formObj.slan_cd,"BEANRD8 (HNN913)");
						else if( '1742' == bethCd )
							ComSetObjValue(formObj.slan_cd,"BEANRY1 (AIT1742)");
						else if( '1700' == bethCd )
							ComSetObjValue(formObj.slan_cd,"BEANRY2 (AGT1700)");
						else if( 'S869' == bethCd )
							ComSetObjValue(formObj.slan_cd,"BEANRY5 (HNN869)");
						*/
						
						var accept = sheetObj.CellValue(1,"crsrep");
						if( 'A' != accept )
				     		document.form.anr_msg_sts_cd.src = 'img/btng_icon_r.gif'; 
				     	else
				     		document.form.anr_msg_sts_cd.src = 'img/btng_icon_b.gif';
						
					} else {
						//조회된 데이가 없을경우 모든 필드값을 ""으로 세팅한다. 조회조건 제외하고.
						for(var i=0; i<formObj.getElementsByTagName("input").length; i++) {
							if (formObj.getElementsByTagName("input")[i].name != "vvd_cd" &&
								formObj.getElementsByTagName("input")[i].name != "pod_cd") {
								formObj.getElementsByTagName("input")[i].value="";
							}
						}
					}
					ComOpenWait(false);
				}
				break;
			
			case MULTI:        
				if(validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
					sheetObj.CellValue2(1, "ibflag") = "I";
					sheetObj.DoSave("ESM_BKG_0494GS.do", FormQueryString(formObj));
					doActionIBSheet(sheetObj, document.form, SEARCH);
					ComOpenWait(false);
				}
				break;
			case MULTI01:      
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI01;
					sheetObj.CellValue2(1, "ibflag") = "I";
					var sParam = ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) ;
	    	        ComOpenWait(true);
	    	        var SaveXml = sheetObj.GetSaveXml("ESM_BKG_0494GS.do?msg_tp_cd='R'", sParam);
	    	        ComOpenWait(false);
	    	        sheetObj.LoadSaveXml(SaveXml);

					state = sheetObj.EtcData("TRANS_RESULT_KEY");
					if (state == "S")
						doActionIBSheet(sheetObj, document.form, SEARCH);
				}
				break;
				
			case COMMAND01:
				if(validateForm(sheetObj,formObj,sAction)) {
					if(ComShowCodeConfirm("BKG00447")) {
						formObj.f_cmd.value = ADD;
						IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
						sheetObj.CellValue2(1,"ibflag") = "U";
						sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
					}
				}
				break;
				
			case COMMAND02:
				if(validateForm(sheetObj,formObj,sAction)) {
					if(ComShowCodeConfirm("COM12165", "Vessel Arrival Manifest")) {
						formObj.f_cmd.value = ADD;
						IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
						sheetObj.CellValue2(1,"ibflag") = "U";
						//삭제 flag 세팅
						sheetObj.CellValue2(1,"del_flag") = "D";
						sheetObj.DoSave("ESM_BKG_0015GS.do", FormQueryString(formObj), -1, false);
    				}
				}
				break;
				
			case COMMAND03:
				var remark = formObj.frm_remark.value;
				sheetObj.RemoveAll();
				formObj.reset();
				comboObjects[0].Code = ""
					
				formObj.frm_remark.value = remark;
				formObj.frm_pod.Index2 = 0;
				break;
			case COMMAND11 : //  PORT 조회
				
				formObj.f_cmd.value = SEARCH11;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0000_1GS.do", FormQueryString(formObj)+"&cnt_cd=BE&cstms_div_id=EUR_BE_PORT_LIST");
				ComXml2ComboItem(sXml, formObj.frm_pod, "pod_cd", "pod_cd");
				formObj.frm_pod.Index=0;
				ComOpenWait(false);
				
				break;					
            }
        }
        
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        	switch(sAction) {
    		
    		case SEARCH:      //조회
    			if (!ComChkValid(formObj))	return false;
    			
    			if ( ComChkLen(formObj.vvd.value, 9) != "2" ) 
     			{
     				//ComShowCodeMessage('BKG00715', 'VVD');
    				ComShowCodeMessage('BKG00626', 'VVD');
    				formObj.vvd.focus();
     				return false;
     			}
			break;
    		case MULTI:      //저장
    			if (!ComChkValid(formObj))	return false;
    			
    			if ( formObj.vvd.value == "" ) 
     			{
    				ComShowCodeMessage('BKG01101', 'VVD');
     				formObj.vvd.focus();
     				return false;
     			}
			break;
    		case MULTI01:      //전송
    			if (!ComChkValid(formObj))	return false;
    			
    			if ( formObj.vvd.value == "" ) 
     			{
    				ComShowCodeMessage('BKG01101', 'VVD');
     				formObj.vvd.focus();
     				return false;
     			}
			break;
			
        	}	
            return true;
        }
    		
 		
	/* 개발자 작업  끝 */    