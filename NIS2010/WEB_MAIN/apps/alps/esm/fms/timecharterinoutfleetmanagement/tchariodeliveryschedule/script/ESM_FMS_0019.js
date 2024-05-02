/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0019.js
*@FileTitle : NB Delivery Schedule Creation
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
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
     * @class NB Delivery Schedule Creation : NB Delivery Schedule Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0019() {
    	this.processButtonClick		= processButtonClick;
    	this.inputReadOnly			= inputReadOnly;
    	this.setFormYardName		= setFormYardName;
    	this.setFromOwnerName		= setFromOwnerName;
    	this.setSheetOwnerName		= setSheetOwnerName;
    	this.setSheetYardName		= setSheetYardName;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_keypress		    = obj_keypress;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
    	this.initConfirm			= initConfirm;
    	this.obj_activate			= obj_activate;
    }
    
   	/* 개발자 작업	*/

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
     			case "btn_retrieve":
     				if(!initConfirm()) return;
     				if(form.btn_periodFlag[0].checked) {
     					form.periodFlag.value = "date";
     					form.vslDeDt1.value = form.vslDeDate1.value.replace(/-/g,"");
     					form.vslDeDt2.value = form.vslDeDate2.value.replace(/-/g,"");
     				} else if(form.btn_periodFlag[1].checked) {
     					form.periodFlag.value = "month";
     					form.vslDeDt1.value = form.vslDeMonth1.value.replace("-","");
     					form.vslDeDt2.value = form.vslDeMonth2.value.replace("-","");
     				} else if(form.btn_periodFlag[2].checked) {
     					form.periodFlag.value = "year";
     					form.vslDeDt1.value = form.vslDeYear1.value;
     					form.vslDeDt2.value = form.vslDeYear2.value;
     				}
     				
     				if(form.vslCdSize1.value != "" && form.vslCdSize1.value != "") {
	     				if(form.btn_vslCdSizeFlag[0].checked) {
	     					form.vslCdSizeFlag.value = "max";
	     				} else if(form.btn_vslCdSizeFlag[1].checked) {
	     					form.vslCdSizeFlag.value = "14ton";
	     				}
     				}
     				
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    		 		break;
     				
     			case "btn_new":
     				if(!initConfirm()) return;
    		 		ComResetAll();
    		 		document.getElementById("style1").style.display = "";
 					document.getElementById("style2").style.display = "none";
 					document.getElementById("style3").style.display = "none";
     				break;
     			
     			case "btn_save":
     				doActionIBSheet(sheetObject,formObject,IBSAVE);
     				break;
     				
     			case "btn_add":
					var row = sheetObject.DataInsert(-1);
     				break;
     				
     			case "btn_ins":
					var row = sheetObject.DataInsert();
					break;
     				
     			case "btn_del":
     				ComRowHideDelete(sheetObject, "DelChk");
					break;

     			case "btn_periodFlag":
     				if(form.btn_periodFlag[0].checked) {
     					document.getElementById("style1").style.display = "";
     					document.getElementById("style2").style.display = "none";
     					document.getElementById("style3").style.display = "none";     					
     				} else if(form.btn_periodFlag[1].checked) {
     					document.getElementById("style1").style.display = "none";
     					document.getElementById("style2").style.display = "";
     					document.getElementById("style3").style.display = "none";
     				} else if(form.btn_periodFlag[2].checked) {
     					document.getElementById("style1").style.display = "none";
     					document.getElementById("style2").style.display = "none";
     					document.getElementById("style3").style.display = "";
     				}
     				break;
     			
     			case "btn_vslDeDate1":
     			case "btn_vslDeMonth1":
     			case "btn_vslDeYear1":
     				var cal = new ComCalendar();

     				if(form.btn_periodFlag[0].checked) {
     					cal.setDisplayType('date');
    					cal.select(form.vslDeDate1, 'yyyy-MM-dd');
    					
     				} else if(form.btn_periodFlag[1].checked) {
     					cal.setDisplayType('month');
    					cal.select(form.vslDeMonth1, 'yyyy-MM');
    					
     				} else if(form.btn_periodFlag[2].checked) {
     					cal.setDisplayType('year');
    					cal.select(form.vslDeYear1, 'yyyy');
     				}
     				
					break;					
					
     			case "btn_vslDeDate2":
     			case "btn_vslDeMonth2":
     			case "btn_vslDeYear2":
     				var cal = new ComCalendar();

     				if(form.btn_periodFlag[0].checked) {
     					cal.setDisplayType('date');
    					cal.select(form.vslDeDate2, 'yyyy-MM-dd');

     				} else if(form.btn_periodFlag[1].checked) {
     					cal.setDisplayType('month');
    					cal.select(form.vslDeMonth2, 'yyyy-MM');

     				} else if(form.btn_periodFlag[2].checked) {
     					cal.setDisplayType('year');
     					cal.select(form.vslDeYear2, 'yyyy');
     				}

					break;

     			case "btn_yard":
     				ComOpenPopup("ESM_FMS_0082.do", 300, 340, "setFormYardName", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0082");
     				break;
     			case "btn_owner":
     				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setFromOwnerName", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0083");
     				break;

     			case "btn_ydClr":
     				form.shpYdNm.value = "";
     				form.ydSeq.value = "";
     				break;
     			case "btn_ownrClr":
     				form.ownrNm.value = "";
     				form.ownrSeq.value = "";
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
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     **/
    function inputReadOnly(flag) {
    	if(flag == "1") {
    		
    		form.btn_periodFlag[0].disabled = true;
    		form.btn_periodFlag[1].disabled = true;
    		form.btn_periodFlag[2].disabled = true;
    		
    		form.vslDeDate1.readOnly = true;
			form.vslDeDate2.readOnly = true;
			form.vslDeMonth1.readOnly = true;
			form.vslDeMonth2.readOnly = true;
			form.vslDeYear1.readOnly = true;
			form.vslDeYear2.readOnly = true;
    		form.vslCdSize1.readOnly = true;
    		form.vslCdSize2.readOnly = true;
    		
    		document.images["btn_vslDeDate1"].name = "";
    		form.btn_vslDeDate1.style.cursor = "default";
    		
    		document.images["btn_vslDeMonth1"].name = "";
    		form.btn_vslDeMonth1.style.cursor = "default";
    		
    		document.images["btn_vslDeYear1"].name = "";
    		form.btn_vslDeYear1.style.cursor = "default";
    		
    		document.images["btn_vslDeDate2"].name = "";
    		form.btn_vslDeDate2.style.cursor = "default";
    		
    		document.images["btn_vslDeMonth2"].name = "";
    		form.btn_vslDeMonth2.style.cursor = "default";
    		
    		document.images["btn_vslDeYear2"].name = "";
    		form.btn_vslDeYear2.style.cursor = "default";

    		document.images["btn_yard"].name = "";
    		form.btn_yard.style.cursor = "default";
    		
    		document.images["btn_owner"].name = "";
    		form.btn_owner.style.cursor = "default";
    		
    		form.btn_vslCdSizeFlag[0].disabled = true;
    		form.btn_vslCdSizeFlag[1].disabled = true;
    		form.shpNm.readOnly = true;

    	} else {
    		document.getElementById("style1").style.display = "";
			document.getElementById("style2").style.display = "none";
			document.getElementById("style3").style.display = "none";
				
    		form.btn_periodFlag[0].disabled = false;
    		form.btn_periodFlag[1].disabled = false;
    		form.btn_periodFlag[2].disabled = false;
    		
    		form.vslDeDate1.readOnly = false;
			form.vslDeDate2.readOnly = false;
			form.vslDeMonth1.readOnly = false;
			form.vslDeMonth2.readOnly = false;
			form.vslDeYear1.readOnly = false;
			form.vslDeYear2.readOnly = false;
    		form.vslCdSize1.readOnly = false;
    		form.vslCdSize2.readOnly = false;
    		
    		document.images["btn_vslDeDate1"].name = "btn_vslDeDate1";
    		form.btn_vslDeDate1.style.cursor = "hand";
    		
    		document.images["btn_vslDeMonth1"].name = "btn_vslDeMonth1";
    		form.btn_vslDeMonth1.style.cursor = "hand";
    		
    		document.images["btn_vslDeYear1"].name = "btn_vslDeYear1";
    		form.btn_vslDeYear1.style.cursor = "hand";
    		
    		document.images["btn_vslDeDate2"].name = "btn_vslDeDate2";
    		form.btn_vslDeDate2.style.cursor = "hand";
    		
    		document.images["btn_vslDeMonth2"].name = "btn_vslDeMonth2";
    		form.btn_vslDeMonth2.style.cursor = "hand";
    		
    		document.images["btn_vslDeYear2"].name = "btn_vslDeYear2";
    		form.btn_vslDeYear2.style.cursor = "hand";
    		
    		document.images["btn_yard"].name = "btn_yard";
    		form.btn_yard.style.cursor = "hand";
    		
    		document.images["btn_owner"].name = "btn_owner";
    		form.btn_owner.style.cursor = "hand";
    		
    		form.btn_vslCdSizeFlag[0].disabled = false;
    		form.btn_vslCdSizeFlag[1].disabled = false;
    		form.shpNm.readOnly = false;
    	}
    }

    /**
	 * Yard 팝업창에서 선택한 Ship Yard Name과 시퀀스를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setFormYardName(aryPopupData){
		form.ydSeq.value = aryPopupData[0][3];
		form.shpYdNm.value = aryPopupData[0][4];
		form.btn_ydClr.checked = true;
	}
    
    /**
	 * Owner 팝업창에서 선택한 Head Ownership Name과 시퀀스를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setFromOwnerName(aryPopupData){
        form.ownrSeq.value = aryPopupData[0][3];
        form.ownrNm.value = aryPopupData[0][4];
        form.btn_ownrClr.checked = true;
	}

    /**
	 * Yard 팝업창에서 선택한 Ship Yard Name과 시퀀스를 Sheet에 설정한다.<br>
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 */
    function setSheetYardName(aryPopupData, Row, Col, sheetIdx){
		 sheetObjects[0].CellValue2(Row, "shp_yd_nm") = aryPopupData[0][4];
		 sheetObjects[0].CellValue2(Row, "yd_seq") = aryPopupData[0][3];
    }
	 
    /**
	 * Owner 팝업창에서 선택한 Head Ownership Name과 시퀀스를 Sheet에 설정한다.<br>
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 */
	function setSheetOwnerName(aryPopupData, Row, Col, sheetIdx){
		 sheetObjects[0].CellValue2(Row, "ownr_nm") = aryPopupData[0][4];
		 sheetObjects[0].CellValue2(Row, "ownr_seq") = aryPopupData[0][3];
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
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
    	
            sheetObjects[i].ExtendLastCol = false;
    	}

    	initControl();
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
                     style.height = 302;
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

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "|Sel|Seq|Ship's Full Name|New Bulding Hull No.|Nominal TEU|14Ton Hom|Reefer|Speed|Period|Trading House|Estimated Delivery|Yard|Owner|shp_de_seq|yd_seq|ownr_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,   "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,		40,    	daCenter,  	false,   "DelChk");
                     InitDataProperty(0, cnt++ , dtDataSeq,    		40,    	daCenter,  	true,    "Seq");
                     InitDataProperty(0, cnt++ , dtData,   			150,   	daLeft,  	false,   "shp_nm",   			false,          "",      dfNone,   			0,	true,		true,		25);
                     InitDataProperty(0, cnt++ , dtData,   			250,   	daLeft,  	false,   "shp_bld_nm",     		true,         	"",      dfNone,      		0,	true,		true,		50);
                     InitDataProperty(0, cnt++ , dtData,   			100,   	daRight,   	false,   "vsl_dznd_capa",  		true,          	"",      dfInteger,  		0,	true,		true,		5);
                     InitDataProperty(0, cnt++ , dtData,   			80,   	daRight,   	false,   "bse_14ton_vsl_capa",  false,          "",      dfInteger,  		0,	true,		true,		5);
                     InitDataProperty(0, cnt++ , dtData,   			60,   	daRight,  	false,   "rf_cntr_plg_qty",     false,          "",      dfInteger,  		0,	true,		true,		6);
                     InitDataProperty(0, cnt++ , dtData,   			60,   	daRight,   	false,   "shp_spd_qty",  		false,          "",      dfNullFloat,		2,	true,		true,		8);
                     InitDataProperty(0, cnt++ , dtData,   			100,   	daLeft,  	false,   "flet_ctrt_dur_ctnt",  false,          "",      dfNone,  			0,	true,		true,		30);
                     InitDataProperty(0, cnt++ , dtData,   			100,   	daLeft,  	false,   "trd_hus_nm",     		false,          "",      dfNone,     		0,	true,		true,		25);
                     InitDataProperty(0, cnt++ , dtData,   			140,   	daCenter,  	false,   "vsl_de_dt",  			true,          	"",      dfDateYmd,			0,	true,		true);
                     InitDataProperty(0, cnt++ , dtPopup,   		150,   	daLeft,  	false,   "shp_yd_nm",     		true,          	"",      dfNone,  			0,	true,		true);
                     InitDataProperty(0, cnt++ , dtPopup,   		150,    daLeft,  	false,   "ownr_nm",     	 	true,          	"",      dfNone,     		0,	true,		true);

                     InitDataProperty(0, cnt++ , dtHidden, 			30,   	daCenter,  	false,   "shp_de_seq",   		false,          "",      dfNone,   			0,	true,		true);
                     InitDataProperty(0, cnt++ , dtHidden, 			30,    	daCenter,  	false,   "yd_seq",     	 		false,          "",      dfNone,     		0,	true,		true);
                     InitDataProperty(0, cnt++ , dtHidden, 			30,    	daCenter,  	false,   "ownr_seq",     	 	false,          "",      dfNone,     		0,	true,		true);

                     ShowButtonImage = 2;

                     DataLinkMouse("shp_yd_nm") = true;
 					 DataLinkMouse("ownr_nm") = true;
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
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		axon_event.addListenerFormat('focus', 'obj_activate', form);
	}

	/**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
	    		if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_FMS_0019GS.do", FormQueryString(formObj));
				}
    			break;

    		case IBSAVE:        //저장
		  	  	formObj.f_cmd.value = MULTI;
		  	  	sheetObj.DoSave("ESM_FMS_0019GS.do", FormQueryString(formObj));
		  	  	break;
    			
    		case IBINSERT:      // 입력
    			break;
    	}
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Duration의 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;

    	if((event.srcElement.name == "vslDeDate1") ||
    	   (event.srcElement.name == "vslDeDate2") ||
    	   (event.srcElement.name == "vslDeMonth1") ||
    	   (event.srcElement.name == "vslDeMonth2") ||
    	   (event.srcElement.name == "vslDeYear1") ||
    	   (event.srcElement.name == "vslDeYear2")) {
    		ComChkObjValid(event.srcElement);
    	} else {
    		ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력가능하게 처리한다.<br>
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
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	var	exptElems = "";
     	if(form.btn_periodFlag[0].checked) {
     		exptElems = "vslDeMonth1|vslDeMonth2|vslDeYear1|vslDeYear2";
     	} else if(form.btn_periodFlag[1].checked) {
     		exptElems = "vslDeDate1|vslDeDate2|vslDeYear1|vslDeYear2";
     	} else if(form.btn_periodFlag[2].checked) {
     		exptElems = "vslDeDate1|vslDeDate2|vslDeMonth1|vslDeMonth2";
     	}

     	if (!ComFmsChkValid(formObj, exptElems)) {
     		return false;
     	}
    	
    	if((form.vslCdSize1.value == "") && (form.vslCdSize2.value == "")) {
    		form.vslCdSizeFlag.value = "";
    	}
    	 
    	with(formObj){
    		if((vslCdSize1.value == "") &&
    		   (vslCdSize2.value != "")) {
    			// Vessel Size를 정확히 입력해주세요
    			ComAlertFocus(formObj.vslCdSize1, ComGetMsg("FMS00011", "Vessel Size"));
    			return false;
    		}
    		
    		if((vslCdSize1.value != "") &&
    		   (vslCdSize2.value == "")) {
    			// Vessel Size를 정확히 입력해주세요
    			ComAlertFocus(formObj.vslCdSize2, ComGetMsg("FMS00011", "Vessel Size"));
    			return false;
    		}

    		if(parseInt(vslCdSize1.value.replace(",","")) > parseInt(vslCdSize2.value.replace(",",""))) { 
    			vslCdSize2.value = "";
    			// To Vessel Size는 From Vessel Size보다 커야 합니다
    			ComAlertFocus(formObj.vslCdSize2, ComGetMsg("FMS00010", "To Vessel Size", "From Vessel Size"));
    			return false;
    		}
    	}

    	return true;
    }

    /**
     * IBSheet Object에서 팝업을 클릭시 Yard와 Owner 팝업창을 띄운다.<br>
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col){
		with(sheetObj) {
			var sName = ColSaveName(Col);

			if(sName == "shp_yd_nm") {
				ComOpenPopup("ESM_FMS_0082.do", 300, 340, "setSheetYardName", "1,0,1,1,1,1", false, false, Row, Col, 0, "esm_fms_0082");
			} else if (sName == "ownr_nm") {
				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setSheetOwnerName", "1,0,1,1,1,1", false, false, Row, Col, 0, "esm_fms_0083");
			}
		}
	}

    /**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
    	var okYn = true;
    	if(sheetObjects[0].isDataModified) {
    		var okYn = ComShowCodeConfirm("FMS00002");
    	}
    	
    	return okYn;
    }
    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
     */
    function obj_activate() {
        ComClearSeparator(event.srcElement);
    }
	/* 개발자 작업  끝 */