/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3514.js
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
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
     * @class ESM_PRI_3514 : ESM_PRI_3514 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3514() {
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

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

    var uploadObjects = new Array();
	var uploadCnt = 0;
	
	var LOC_MAX_SEQ = 0;	//Location Information MAX SEQ값을 조회하여 세팅한다.
	
	var MAX_UPD_DT = "";	//최근 업데이트 날짜

	//저장 메세지를 구분하기 위해 사용됨.
	var supressConfirm = false;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];

        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {     
                if (getButtonTable(srcName).disabled || window.event.srcElement.disabled) {
                    return false;
                }
            }

			switch (srcName) {
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCREATE);
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
					break;

				case "btn_amend":
					doActionIBSheet(sheetObject1,formObject,MODIFY01);
					break;

				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;

				case "btn_delete":
					doActionIBSheet(sheetObject1,formObject,REMOVE01);
					break;

				case "btn_request":
					doActionIBSheet(sheetObject1,formObject,MODIFY02);
					break;

				case "btn_approve":
					doActionIBSheet(sheetObject1,formObject,MODIFY03);
					break;

				case "btn_publish":
					doActionIBSheet(sheetObject1,formObject,MODIFY04);					
					break;

				case "btn_cancel":
					doActionIBSheet(sheetObject1,formObject,REMOVE02);
					break;

				case "btn_fileadd":
					doActionIBSheet(sheetObject2,formObject,MODIFY05);
					break;

				case "btn_filedelete":
					doActionIBSheet(sheetObject2,formObject,REMOVE03);
					break;

				case "btn_filesave":
					doActionIBSheet(sheetObject2,formObject,MODIFY06);
					break;
					
				case "btn_rowadd":
					doActionIBSheet(sheetObject3,formObject,IBINSERT);
					break;

				case "btn_rowdelete":
					doActionIBSheet(sheetObject3,formObject,IBDELETE);
					break;

				case "btn_rowamend":
					doActionIBSheet(sheetObject3,formObject,MODIFY07);
					break;
				case "btn_amendcancel":
					doActionIBSheet(sheetObject3,formObject,MODIFY08);
					break;

	            case "btns_calendar1": //달력버튼	    				    			
	                var cal = new ComCalendar();
	                cal.select(formObject.eff_dt, 'yyyy-MM-dd');
	                break;

	            case "btns_calendar2": //달력버튼	    				    			
	                var cal = new ComCalendar();
	                cal.select(formObject.exp_dt, 'yyyy-MM-dd');
	                break;

				case "btn_downexcel":
					doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
					break;

				case "btn_loadexcel":
					doActionIBSheet(sheetObject3,formObject,IBLOADEXCEL);
					break; 

				case "btn_rowsearch":
					doActionIBSheet(sheetObject3,formObject,IBSEARCH_ASYNC05);
					break;
					
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
   	* @author 최성민
   	* @version 2010.10.13
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
  /**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
   	* @author 최성민
   	* @version 2010.10.13
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

  /**
	* IBUpload Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setUploadObject(uploadObj);
	* </pre>
	* @param {ibupload} uploadObj 필수 IBUpload Object
	* @return 없음
   	* @author 최성민
   	* @version 2010.10.13
	*/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}


   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 최성민
    * @version 2010.10.13
    */
	function loadPage() {
		var formObj = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			//sheetObjects[i].XmlHttpVer = 2;
		}

	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }

        //UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/ESM_PRI_3514GS.do");
		    
		    //2. Upload 초기화
		    //initUpload(uploadObjects[i],i+1);
		}

        //각종 확인 메시지의 표시를 표시할지 여부를 설정한다.
        uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";

	    //Axon 이벤트 초기화
	    initControl();
	    
	    //버튼 초기화
	    toggleButtons();
	           
	    //Tariff Code Combo 세팅
	    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd'));
	    ComPriTextCode2ComboItem(aproOfcCdComboValue, aproOfcCdComboText, getComboObject(comboObjects, 'apro_ofc_cd'));	
	    ComPriTextCode2ComboItem(trfInlndAmdtTCdComboValue, trfInlndAmdtTCdComboText, getComboObject(comboObjects, 'trf_inlnd_amdt_tp_cd'));	
	    	        
	    if (formObj.trf_inlnd_seq.value != "") {//Inquiry 에서 조회           
            
	  	   
	    	var trfPfxCd 	= formObj.trf_pfx_cd.value;
	    	var trfNo 		= formObj.trf_no.value;
	    	var trfInlndSeq	= formObj.trf_inlnd_seq.value;
	    	var trfCd 		= trfPfxCd + "-" + trfNo;	    	
	    	comboObjects[0].Code = trfCd;
	    	tariff_cd_OnBlur(comboObjects[0]);
	    	comboObjects[1].Code = trfInlndSeq;
        }else{
        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        }		
	}
	
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */ 	    
     function initControl() {
    	 //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
         axon_event.addListenerForm('beforeactivate', 'obj_onActivate', document.form);
         axon_event.addListenerForm('beforedeactivate', 'obj_onDeactivate', document.form);
         axon_event.addListenerForm ('click', 'obj_onClick', document.form);
         axon_event.addListenerFormat ('keypress', 'obj_onKeypress', document.form);      
         axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);  
     }
	
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
         	case "sheet1":	//hidden
         		with (sheetObj) {
         			
                     // 높이 설정
                     //style.height = 60;
                     //전체 너비 설정
                     //SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     //if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     //MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     //Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);

                     var HeadTitle = "Flag|TRF_PFX_CD|TRF_NO|TRF_INLND_SEQ|AMDT_SEQ|TRF_INLND_NM|EFF_DT|EXP_DT|RQST_OFC_CD|APRO_OFC_CD|TRF_INLND_STS_CD" +
                     				 "|TRF_INLND_STS_NM|ATCH_FILE_ID|ATCH_FILE_NM|AMDT_TP|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT|PUB_DT|BEF_PUB_DT|APRO_FLG";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,	false,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtData,	50,		daCenter,	false,	"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtData,	50,  	daCenter,	false,	"trf_no");
                     InitDataProperty(0, cnt++ , dtData,	50,  	daCenter,	false,	"trf_inlnd_seq");
                     InitDataProperty(0, cnt++ , dtData,	50,  	daCenter,	false,	"amdt_seq");
                     InitDataProperty(0, cnt++ , dtData,  	50,   	daCenter, 	false,	"trf_inlnd_nm");
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter,	false,	"eff_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter, 	false,	"exp_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter, 	false,	"rqst_ofc_cd");
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter, 	false,	"apro_ofc_cd");
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter, 	false,	"trf_inlnd_sts_cd");
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter, 	false,	"trf_inlnd_sts_nm");
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter, 	false,	"atch_file_id");
                     InitDataProperty(0, cnt++ , dtData,	70,  	daCenter, 	false,	"atch_file_nm");
                     InitDataProperty(0, cnt++ , dtData,	40,  	daCenter, 	false,	"trf_inlnd_amdt_tp_cd");

                     InitDataProperty(0, cnt++ , dtHidden,	40,  	daCenter, 	false,	"cre_usr_id");
                     InitDataProperty(0, cnt++ , dtHidden,	40,  	daCenter, 	false,	"cre_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,  60,   	daCenter, 	false,	"upd_usr_id");
                     
                     InitDataProperty(0, cnt++ , dtHidden,	70,		daCenter,	false,	"upd_dt");
                     InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	false,	"pub_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,	70,		daCenter,	false,	"bef_pub_dt",  			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtHidden,	70,		daCenter,	false,	"apro_flg");
                     
	                 WaitImageVisible = false;	                 
	                 //Row Height 가 늘어나는것을 방지
	                 AutoRowHeight = false;
         		}
              	break;

         	case "sheet2":	//upload
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 25;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|File Name|Download|1|2|3|4|5|6";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false, true);

					 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,40,		daCenter,	false,		"ibflag");
					 InitDataProperty(0, cnt++ , dtPopup,      	130,    daLeft,     false,      "atch_file_nm", 	true,    	"",	dfNone,	0,	false,	true,	50);
					 InitDataProperty(0, cnt++ , dtImage,		20,		daCenter,	false,		"file_dn",	false,      "",	dfNone,	0,	false,	false);
										 
					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"file_path_url");
					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"atch_file_id");
					 InitDataProperty(0, cnt++ , dtHidden,	   	50,		daCenter,	false,		"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtHidden,		50,  	daCenter,	false,		"trf_no");
                     InitDataProperty(0, cnt++ , dtHidden,		50,  	daCenter,	false,		"trf_inlnd_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		50,  	daCenter,	false,		"amdt_seq");
					
					 ImageList(0)= "/hanjin/img/ico_attach.gif";
					 DataLinkMouse("file_dn") = true;
					 ToolTipOption = "balloon:true;width:1000;icon:1;title:File Name";
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet3":	//location information
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 300;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 500);

                     var HeadTitle1 = "Flag| | | | | | | | | | | | | " + 
                     		"|One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Source|Note" +
                     		"|1|2|3|4|5|6|7|8|9|10|11|12";
                     
                     var HeadTitle2 = "Flag|Sel.|Seq.|Loc. Code|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN <=|Weight\nMAX >=|Weight\nUnit|Type|Currency" + 
                     		"|Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Source|Note" +
		              		"|1|2|3|4|5|6|7|8|9|10|11|12";

                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,	daCenter,	true,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtDummyCheck,	40, daCenter,  	true,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,		40, daCenter,  	true,	"seq");
 					 InitDataProperty(0, cnt++ , dtPopupEdit,  	80,	daCenter,	true,	"inlnd_rt_bse_loc_cd",			true,	"",	dfNone, 			0,     true,	true,	5);
                     InitDataProperty(0, cnt++ , dtData,		160,daLeft,		true,	"inlnd_rt_bse_loc_nm",			false,	"",	dfNone,				0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"inlnd_rt_bse_loc_zip_cd",		false,	"",	dfNone, 		 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtCombo,		70, daCenter,	true,	"inlnd_rt_term_cd",  			false,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtPopupEdit,   80, daCenter, 	true,	"inlnd_rt_via_loc_cd", 			false,	"",	dfNone, 			0,     true,	true,	5);
                     InitDataProperty(0, cnt++ , dtCombo,  	    90, daCenter, 	true,	"prc_inlnd_rt_trsp_mod_cd",   	false,	"",	dfNone, 			0,     true,	true);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_min_lmt_wgt",     	false,	"",	dfNullFloat,	 	1,     true,	true,	5);
                     
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_lmt_wgt",     		false,	"",	dfNullFloat,	 	1,     true,	true,	5);
                     InitDataProperty(0, cnt++ , dtCombo,		50, daCenter,	true,	"inlnd_rt_lmt_wgt_ut_cd",		false,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtCombo,		50, daCenter,	true,	"prc_cgo_tp_cd",     			false,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtCombo,		75, daCenter,	true,	"curr_cd",     					true,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_one_wy_bx_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_one_wy_20ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_one_wy_40ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_one_wy_40ft_hc_rt_amt",	false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_one_wy_45ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_bx_rt_amt",     			false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_20ft_rt_amt",			false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_40ft_rt_amt",			false,	"",	dfNullInteger, 		0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_40ft_hc_rt_amt",			false,	"",	dfNullInteger, 		0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter, 	true,	"inlnd_45ft_rt_amt",			false,	"",	dfNullInteger, 	 	0,     true,	true,	10);
                     InitDataProperty(0, cnt++ , dtCombo,		80, daCenter, 	true,	"src_info_cd",     				false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		200, daLeft, 	true,	"inlnd_rt_rmk",     			false,	"",	dfNone, 		 	0,     true,	true,	100);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_no");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_inlnd_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"amdt_seq");                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_inlnd_rt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"n1st_cmnc_amdt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"upd_dt");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"cre_dt");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"cre_usr_id");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"upd_usr_id");                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"input_flg");                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"color_flg");                     
                     
                     InitDataCombo(0, "inlnd_rt_term_cd", inlndRtTermCdComboText, inlndRtTermCdComboValue);
                     InitDataCombo(0, "prc_inlnd_rt_trsp_mod_cd", prcRrspModCdComboText, prcRrspModCdComboValue);
                     InitDataCombo(0, "inlnd_rt_lmt_wgt_ut_cd", inlndRtLmtWgtUtCdComboText, inlndRtLmtWgtUtCdComboValue);
                     InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdComboText, prcCgoTpCdComboValue);
                     InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);
                     InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue);
                     
                     //2011-02-16 서미진 loc_cd에 영문대문자 + 숫자 입력할 수 있게 수정
                     InitDataValid(0, "inlnd_rt_bse_loc_cd", 			vtEngUpOther, "0123456789");
 					 InitDataValid(0, "inlnd_rt_via_loc_cd", 			vtEngUpOther, "0123456789");
                     //InitDataValid(0, "inlnd_rt_lmt_wgt", 				vtNumericOther, ".");
 					 InitDataValid(0, "inlnd_rt_bse_loc_zip_cd", 		vtNumericOnly);
 					 
 					/*InitDataValid(0, "inlnd_20ft_rt_amt", 				vtNumericOnly);
 					 InitDataValid(0, "inlnd_40ft_rt_amt", 				vtNumericOnly);
 					 InitDataValid(0, "inlnd_40ft_hc_rt_amt", 			vtNumericOnly);
 					 InitDataValid(0, "inlnd_45ft_rt_amt", 				vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_bx_rt_amt", 		vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_20ft_rt_amt", 		vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_40ft_rt_amt", 		vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_40ft_hc_rt_amt", 	vtNumericOnly);
 					 InitDataValid(0, "inlnd_one_wy_45ft_rt_amt", 		vtNumericOnly);*/
 					

 					 ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";					 
			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 					 		 
			 		 //CountPosition = 0;		// Total 숨김			 		 
	                 WaitImageVisible = false;
	               	                 
	                 //영역 다중 선택 가능 여부 설정하기
	                 //MultiSelection = false;
	                 
	                 //MultiSelection=false 이면 1개의 행만 선택 가능 
	                 //SelectionMode = smSelectionRow; //1
	                 
	                 //Row Height 가 늘어나는것을 방지
	                 AutoRowHeight = false;
	                 
	                 ///////////////////////////////////////////////////
	                 //시트에서 스크롤시 화면 업데이트 속도를 향상시킨다.
	                 //IsBufferdScroll = true;
	                 
	                 ScrollTrack = false;
	                 MassOfSearch = 0;
	                 
	                 //CountFormat = "[SELECTDATAROW / TOTALROWS]";
	                 ///////////////////////////////////////////////////

         		}
              	break;
               	
         	case "sheet4":	//download
         		with (sheetObj) {
                     // 높이 설정
                     //style.height = 300;
                     //전체 너비 설정
                     //SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     //if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     //Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     var HeadTitle1 = "Flag| | | | | | | | | | | | | " + 
		              		"|One Way|One Way|One Way|One Way|One Way|Round Trip|Round Trip|Round Trip|Round Trip|Round Trip|Source|Note" +
		              		"|1|2|3|4|5|6|7|8|9|10|11|12";
		                     
                     var HeadTitle2 = "Flag|Sel.|Seq.|Loc. Code|Description|Zip\nCode|Term|Via|Trans.\nMode|Weight\nMIN <=|Weight\nMAX >=|Weight\nUnit|Type|Currency" + 
                     		"|Box|20'|40'|HC|45'|Box|20'|40'|HC|45'|Source|Note" +
		              		"|1|2|3|4|5|6|7|8|9|10|11|12";

                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,30,	daCenter,	true,	"ibflag");
 					 InitDataProperty(0, cnt++ , dtDummyCheck,	40, daCenter,  	true,	"chk");
                     InitDataProperty(0, cnt++ , dtDataSeq,		40, daCenter,  	true,	"seq");
 					 InitDataProperty(0, cnt++ , dtPopupEdit,  	80,	daCenter,	true,	"inlnd_rt_bse_loc_cd",			true,	"",	dfNone, 			0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		160,daLeft,		true,	"inlnd_rt_bse_loc_nm",			false,	"",	dfNone,				0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		60, daCenter,	true,	"inlnd_rt_bse_loc_zip_cd",		false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,		70, daCenter,	true,	"inlnd_rt_term_cd",  			false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtPopupEdit,   80, daCenter, 	true,	"inlnd_rt_via_loc_cd", 			false,	"",	dfNone, 			0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,  	    90, daCenter, 	true,	"prc_inlnd_rt_trsp_mod_cd",    	false,	"",	dfNone, 			0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_min_lmt_wgt",     	false,	"",	dfNullFloat,	 	1,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter,	true,	"inlnd_rt_lmt_wgt",     		false,	"",	dfNullFloat,	 	1,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,		50, daCenter,	true,	"inlnd_rt_lmt_wgt_ut_cd",		false,	"",	dfNone, 		 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtCombo,		50, daCenter,	true,	"prc_cgo_tp_cd",     			false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,		70, daCenter,	true,	"curr_cd",     					false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_one_wy_bx_rt_amt",		false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_one_wy_20ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_one_wy_40ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_one_wy_40ft_hc_rt_amt",	false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_one_wy_45ft_rt_amt",		false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_bx_rt_amt",     			false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_20ft_rt_amt",			false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_40ft_rt_amt",			false,	"",	dfNullInteger, 		0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_40ft_hc_rt_amt",			false,	"",	dfNullInteger, 		0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		50, daCenter, 	true,	"inlnd_45ft_rt_amt",			false,	"",	dfNullInteger, 	 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,		80, daCenter, 	true,	"src_info_cd",     				false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,		200, daLeft, 	true,	"inlnd_rt_rmk",     			false,	"",	dfNone, 		 	0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_no");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_inlnd_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"amdt_seq");                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"trf_inlnd_rt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"n1st_cmnc_amdt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"upd_dt");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"cre_dt");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"cre_usr_id");
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"upd_usr_id");                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"input_flg");                     
                     InitDataProperty(0, cnt++ , dtHidden,		40,	daLeft,		true,	"color_flg");                     
                     
                     InitDataCombo(0, "inlnd_rt_term_cd", inlndRtTermCdComboText, inlndRtTermCdComboValue);
                     InitDataCombo(0, "prc_inlnd_rt_trsp_mod_cd", prcRrspModCdComboText, prcRrspModCdComboValue);
                     InitDataCombo(0, "inlnd_rt_lmt_wgt_ut_cd", inlndRtLmtWgtUtCdComboText, inlndRtLmtWgtUtCdComboValue);
                     InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdComboText, prcCgoTpCdComboValue);
                     InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);
                     InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue);
                     
                     					 
			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 //CountPosition = 0;		// Total 숨김	
			 					 		 
	                 WaitImageVisible = false;
	               	                 
	                 //영역 다중 선택 가능 여부 설정하기
	                 //MultiSelection = false;
	                 
	                 //MultiSelection=false 이면 1개의 행만 선택 가능 
	                 //SelectionMode = smSelectionRow; //1
	                 
	                 //Row Height 가 늘어나는것을 방지
	                 //AutoRowHeight = false;
         		}
              	break;
     	}
	}
	
   /**
    * IBCOMBO를 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo의 순번
    * @return 없음
    * @author 최성민
    * @version 2010.10.13
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "tariff_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 8;
	            	UseAutoComplete = true;
	            	ValidChar(2, 3);	//영어 대문자, 숫자+특수문자 포함
	            }
	            break;
	        case "inlnd_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 50;
	            	UseAutoComplete = false;

	            	ValidChar(1, 3);	//영문만 입력
	            }
	            break;	 
	        case "trf_inlnd_amdt_tp_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 1;
	            	UseAutoComplete = true;

	            	ValidChar(2, 0);	//영문만 입력
	            }
	            break;	      
	        case "apro_ofc_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 5;
	            	UseAutoComplete = true;

	            	ValidChar(1, 0);	//영문만 입력
	            }
	            break;	      
	    }
	}

  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 최성민
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {
	 			case IBSEARCH: // 조회
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	  				ComOpenWait(true);
	  				sheetObjects[2].CheckAll("chk") = 0;
	  				sheetObjects[2].headCheck(1, 1) = false;
	  				formObj.search_view_yn.checked = false;
	  				
		 			formObj.f_cmd.value = SEARCH01;
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3514GS.do", FormQueryString(formObj));
	  				
	  				if(sXml != "") {
	  					ComPriXml2ComboItemList(sXml, formObj.inlnd_cd, "trf_inlnd_seq", "trf_inlnd_nm", true);
	  				}
	  				
	 				break;
	 				
	 			case IBSEARCH_ASYNC01: // 조회
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	  				ComOpenWait(true);
	  				sheetObjects[2].CheckAll("chk") = 0;
	  				sheetObjects[2].headCheck(1, 1) = false;
	  				formObj.search_view_yn.checked = false;
	  				
		 			formObj.f_cmd.value = SEARCH02;
		 			var sParam = FormQueryString(formObj) + "&etc2="+formObj.ofc_cd.value;	
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3514GS.do", sParam);
	  				var arrXml = sXml.split("|$$|");
	  				
	  				sheetObj.Redraw = false;
	  				if (arrXml.length > 0) {
                    	sheetObjects[0].LoadSearchXml(arrXml[0]);
                    	arrXml[0] = ComDeleteMsg(arrXml[0]);
                    	sheetObjects[2].LoadSearchXml(arrXml[1]);
	  				}

	  				LOC_MAX_SEQ = parseInt(ComGetEtcData(arrXml[0],"LOC_MAX_SEQ"),10);	
	  				
	  				//최근 업데이트 날짜
	  				MAX_UPD_DT = ComGetEtcData(arrXml[0],"MAX_UPD_DT");
	  				
	  				sheetObj.Redraw = true;
	  				
	  				//Attach file 
	  				searchSheetAttachedFile(arrXml[0]);
	  				
	  				toggleButtons();

	  				ComOpenWait(false);

	  		 		//폼 컨트롤
	  				//comboObjects 를 Enable 처리할때는 ComOpenWait(false) 호출 후에 처리해야 한다.
	  		 		controlFormEnable(sheetObj);	  		 			  				
	 				break;
	 				
	 			case IBSEARCH_ASYNC02: // 메인만 재조회
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	  				ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH02;		 			
		 			var sParam = FormQueryString(formObj) + "&etc1=ONLY_MAIN";	  					  				
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3514GS.do", sParam);				
	  				sheetObj.LoadSearchXml(sXml);
	  				ComOpenWait(false);

	  				//Attach file 
	  				searchSheetAttachedFile(sXml);
	  				
	  				toggleButtons();
	  		 		//폼 컨트롤
	  				//comboObjects 를 Enable 처리할때는 ComOpenWait(false) 호출 후에 처리해야 한다.
	  		 		controlFormEnable(sheetObj);	  		 		
	 				break;
	 					 				
	 			case IBSEARCH_ASYNC04: // Detail 재조회
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 					 				
	  				ComOpenWait(true);
	  				
	  				var sheetM = sheetObjects[0];
	  				var sheetD = sheetObjects[2];
	  				var seqMain = sheetM.CellValue(sheetM.HeaderRows, "amdt_seq");
	  		 		var stsMain = sheetM.CellValue(sheetM.HeaderRows, "trf_inlnd_sts_cd");
	  		 		var ofcMain = sheetM.CellValue(sheetM.HeaderRows, "rqst_ofc_cd");

	  		 		sheetD.CheckAll("chk") = 0;
	  				sheetD.headCheck(1, 1) = false;
	  				formObj.search_view_yn.checked = false;
	  				
		 			formObj.f_cmd.value = SEARCH02;		 			
		 			var sParam = FormQueryString(formObj) + "&etc1=ONLY_DETAIL&etc2="+formObj.ofc_cd.value;
		 			
	  				var sXml = sheetD.GetSearchXml("ESM_PRI_3514GS.do", sParam); 
	  				LOC_MAX_SEQ = parseInt(ComGetEtcData(sXml,"LOC_MAX_SEQ"),10); 
	  				//최근 업데이트 날짜
	  				MAX_UPD_DT = ComGetEtcData(sXml,"MAX_UPD_DT");		  				
	  				sheetD.LoadSearchXml(sXml);
	  				
	  				toggleButtons();
	 				break;
	 				
	 			case IBSEARCH_ASYNC07: // View Amend Delete
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 					 				
	  				ComOpenWait(true);	  	
	  				sheetObj.CheckAll("chk") = 0;		
	  				sheetObj.headCheck(1, 1) = false;
	  				
		 			formObj.f_cmd.value = SEARCH02;		 			
		 			var sParam = FormQueryString(formObj) + "&etc1=CHECK_VIEW&etc2="+formObj.ofc_cd.value;
		 			
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3514GS.do", sParam); 
	  				LOC_MAX_SEQ = parseInt(ComGetEtcData(sXml,"LOC_MAX_SEQ"),10); 
	  				//최근 업데이트 날짜
	  				MAX_UPD_DT = ComGetEtcData(sXml,"MAX_UPD_DT");		  				
	  				sheetObj.LoadSearchXml(sXml);
	  				
	  				toggleButtons();
	 				break;
	 				
	 			case IBSEARCH_ASYNC06: // MAX SEQ
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	  				ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH05;
		 			//var sParam = FormQueryString(formObj);	 
		 			var sParam = "f_cmd="+SEARCH05;		 			
		 			var sParamSheet = sheetObjects[0].GetSaveString(true);
	  				if (sParamSheet != "") {
	  					sParam = sParam + "&" + sParamSheet;
	  				}
		 					 			
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3514GS.do", sParam);	
	  				var maxSeq = parseInt(ComGetEtcData(sXml,"MAX_SEQ"),10) + 1;
	  				
	  				return maxSeq;
	 				break;
	 				
	 		    case IBCREATE: // New	            	3
	                if (!validateForm(sheetObj,document.form,sAction)) {
	                    return false;
	                }

	                //모든 객체 리셋
	                ComResetAll();
	                //resetObjectValue("0");
	                
	                sheetObj.DataInsert();
	                sheetObj.CellValue2(sheetObj.HeaderRows, "trf_inlnd_sts_cd")= "I";
	                sheetObj.CellValue2(sheetObj.HeaderRows ,"amdt_seq")= "0";
	                sheetObj.CellValue2(sheetObj.HeaderRows ,"rqst_ofc_cd")= formObj.ofc_cd.value;
	                	             
	                //sheet3 title reset
	                initLocationSheetColumn();	
	                sheetObjects[2].CheckAll("chk") = 0;
	                sheetObjects[2].headCheck(1, 1) = false;
	                //최근업데이트 날짜 초기화
	                MAX_UPD_DT = "";
	                
	                toggleButtons();
	                
	                formObj.tariff_cd.focus();

	                break;
	             
	 			case IBSAVE: // Save
	 				
	 				ComOpenWait(true);
	  				sheetObjects[2].CheckAll("chk") = 0;
	  				
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	 				if (!supressConfirm && !ComPriConfirmSave()) {
	  					return false;
	  				}
	 				
	 				///////////////////////////////////////////////
	 				// rates seq max 값 세팅
	 				// Rates Name Seq 는 화면에서 세팅해야함 - 메인, 디테일 데이터를 한번에 저장함.
	 				var trfInlndSeq = sheetObj.CellValue(sheetObj.HeaderRows, "trf_inlnd_seq");	 				
	 				if(trfInlndSeq == "") {
		 				
		 				var maxSeq = doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC06);
		 				if(maxSeq < 0) {
		 					return false;
		 				}
		 				
		 				ComOpenWait(true);
		 				sheetObj.CellValue2(sheetObj.HeaderRows, "trf_inlnd_seq") = maxSeq;
		 				formObj.trf_inlnd_seq.value = maxSeq;
		 				
		 				for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
		 					sheetObjects[2].CellValue2(i, "trf_inlnd_seq") = maxSeq;
		 				}
	 				}
	 					 				
		    		//IBUpload에 파일 추가하기
					var upObj = uploadObjects[0];
					upObj.Files="";	//-먼저기존파일을 모두 지운후 추가함
					setFileUpload(sheetObjects[1]);
		            		
	  				formObj.f_cmd.value = MULTI01;
	  				var sParam = FormQueryString(formObj);
	
	  				var sParamSheet1 = sheetObjects[0].GetSaveString(true);
	  				if (sParamSheet1 != "") {
	  					sParam = sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	  				}
	  				
	  				var sParamSheet2 = sheetObjects[2].GetSaveString();
	  				if (sParamSheet2 != "") {
	  					sParam = sParam + "&" + ComPriSetPrifix(sParamSheet2, "sheet3_");
	  				}
	  				
	  				var sXml = "";
	  				//서버에 request전달하고, reponse 받기		                
		            if (upObj.LocalFiles == "") {
		                //*******파일이 없는 경우 IBSheet 이용하기********
		                sXml = sheetObj.GetSaveXml("ESM_PRI_3514GS.do", sParam);
		            } else {
		                //*******파일이 있는 경우 IBUpload 이용하기*******
		                upObj.ExtendParam = sParam;
		                upObj.ParamDecoding = true;
		                sXml = upObj.DoUpload(true);
		                
		            }
		            
	  				//메인정보가 변경됬을 경우 화면 재조회 
	  				if (sheetObj.RowStatus(sheetObj.HeaderRows) == "I") {
		  				//////////////////////////////////
		  				// 추가저장시 재조회
		  				var comboObj = comboObjects[1];
		  				var inlandName = comboObj.Text;
		 				
		 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
		 					 				
		 				var code = comboObj.FindIndex(inlandName, 0);	 			
		 				if (code == null || code == "" || code == "X") {
		 					comboObj.Index = -1;
		 				} else {
		 					comboObj.Code = code; //onChange 이벤트 발생
		 				}
		  				//////////////////////////////////
	  				} else if(sheetObj.RowStatus(sheetObj.HeaderRows) == "U") {
	  					var comboObj = comboObjects[1];
	  					var sCode = sheetObj.CellValue(sheetObj.HeaderRows, "trf_inlnd_seq");
	  					//Inland Rates Name 수정시 화면 재조회 없이 콤보를 세팅한다.
	  					if(comboObj.Text != comboObj.GetText(sCode, 0)) {
		  					comboObj.SetText(sCode, 0, comboObj.Text);
	  					}
	  						  					
	  					//업데이트 날짜관련해서...
	  					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	  				}
	  							  			
	  				sheetObjects[2].LoadSaveXml(sXml);
		  			sXml = ComDeleteMsg(sXml);
	  				sheetObjects[0].LoadSaveXml(sXml);

	  				//최근 업데이트 날짜
	  				MAX_UPD_DT = ComGetEtcData(sXml,"MAX_UPD_DT");
	  				
	  				toggleButtons();
	  				return true;
	 				break;
	 			
	 				
				case REMOVE01: // Delete
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI00002")) {
						return false;
					}
					
	  				ComOpenWait(true);
	  				
					formObj.f_cmd.value = REMOVE01;
					var sParam = FormQueryString(formObj);
	 				var sParamSheet = sheetObj.GetSaveString(true);
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}
	  				
					var sXml = sheetObj.GetSaveXml("ESM_PRI_3514GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);
					
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
						return false;
				    }					

					///////////////////////////////////////////
					//tariff Code를 제외한 나머지는 모두 reset
					var comboObj = comboObjects[0];
					//var trfNm = formObj.trf_nm.value
					var comboCode = comboObj.Code;
					//var comboText = comboCode+"|"+trfNm;
				
					//reset
					doActionIBSheet(sheetObj, formObj, IBCREATE);
					comboObj.Code2 = comboCode;
					//tariff_cd_OnChange(comboObj, comboCode, comboText);
					tariff_cd_OnBlur(comboObj);
					formObj.inlnd_cd.focus();
					///////////////////////////////////////////
					break;
					
				case MODIFY01: // Amend
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
			            
					var sUrl = "/hanjin/ESM_PRI_3521.do";
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3521", 450, 220, true);

		            if (rtnVal) {
		            	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		            }				
					break;
										
				case MODIFY02: // Request
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}

					//수정사항이 존재할경우 저장후 REQUEST 처리한다.
		   			if (sheetObj.IsDataModified || sheetObjects[2].IsDataModified) {
		   				var rslt = false;		   				
		   				if (ComShowCodeConfirm("PRI00006")) {
							supressConfirm = true;
							rslt = doActionIBSheet(sheetObj,document.form,IBSAVE);
							supressConfirm = false;
						}
		   				
		   				if (!rslt) {
		   					return false;
		   				}
					}
					
					
					if (!ComShowCodeConfirm("PRI06001")) {
						return false;
					}
					
	  				ComOpenWait(true);					
					//sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "Q";
					
					var sParam = "f_cmd=" + MODIFY02;
	 				var sParamSheet = sheetObj.GetSaveString(true);
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}

					var sXml = sheetObj.GetSaveXml("ESM_PRI_3514GS.do", sParam);
					
					sheetObj.LoadSaveXml(sXml);
					
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
						return false;
				    }
					
	 				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);	 				
					
					break;
								
				case MODIFY03: // Approve
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI06002")) {
						return false;
					}
					
	  				ComOpenWait(true);					
					//sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "A";
					
					var sParam = "f_cmd=" + MODIFY03;
	 				var sParamSheet = sheetObj.GetSaveString(true);
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}
	  				
					var sXml = sheetObj.GetSaveXml("ESM_PRI_3514GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);
					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
						return false;
				    }
					
	 				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);					
					break;				
					
				case REMOVE02: // Cancel
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI00015")) {
						return false;
					}

	  				ComOpenWait(true);		
	  				
	  				var stsCd = sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_sts_cd");
	  				/*
					if(sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_sts_cd") == "Q") {
						sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "I";
					} else if(sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_sts_cd") == "A") {
						sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "Q";
					} else if(sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_sts_cd") == "I") { //Amend cancel
						sheetObj.CellValue2(sheetObj.SelectRow, "trf_inlnd_sts_cd") = "X";
					}
	  				*/
					var sParam = "f_cmd=" + REMOVE02;
	 				var sParamSheet = sheetObj.GetSaveString(true);
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}

					var sXml = sheetObj.GetSaveXml("ESM_PRI_3514GS.do", sParam);					
					sheetObj.LoadSaveXml(sXml);	

					if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
						return false;
				    }
					
					if(stsCd == "A") {
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
					} else {
						doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
					}
					
								
					break;	
				
	        	case IBDOWNEXCEL:
	        		if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
	        		
	        		ComOpenWait(true);
		 			formObj.f_cmd.value = SEARCH03;
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3514GS.do", FormQueryString(formObj));	  				
	  				sheetObj.LoadSearchXml(sXml);
                    	  				
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "chk", "", false, "", true);
					//sheetObj.Down2Excel(-1);
					break;
								
	        	case IBLOADEXCEL:
		        	if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
		        	}
		        	
		        	var sheetM = sheetObjects[0];		        	
					var sUrl = "/hanjin/ESM_PRI_3522.do?";
					sUrl += "trf_pfx_cd=" + sheetM.CellValue(sheetM.HeaderRows, "trf_pfx_cd");
					sUrl += "&trf_no=" + sheetM.CellValue(sheetM.HeaderRows, "trf_no");
					sUrl += "&trf_inlnd_seq=" + sheetM.CellValue(sheetM.HeaderRows, "trf_inlnd_seq");
					sUrl += "&amdt_seq=" + sheetM.CellValue(sheetM.HeaderRows, "amdt_seq");
					sUrl += "&etc1=" + sheetObj.CellText(0, 1);
					sUrl += "&upd_dt=" + sheetM.CellValue(sheetM.HeaderRows, "upd_dt");
					sUrl += "&etc2=" + MAX_UPD_DT;
						
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3522", 1000, 600, true);

		  			if (rtnVal != null){
		  				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
		  			}
		  			
					break;
									
				case MODIFY04: // Publish
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
			            
					var sUrl = "/hanjin/ESM_PRI_3517.do";
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3517", 500, 220, true);
		            if (rtnVal) {
						doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC02);
		            }		            
					break;		
	 			
	 			case MODIFY05: // 파일 추가	
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 					 				
	 				var Row = sheetObj.DataInsert(-1);
	 				sheetObj.CellValue2(Row, "trf_pfx_cd") 		= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "trf_pfx_cd");
	 				sheetObj.CellValue2(Row, "trf_no") 			= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "trf_no");
	 				sheetObj.CellValue2(Row, "trf_inlnd_seq") 	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "trf_inlnd_seq");
	 				sheetObj.CellValue2(Row, "amdt_seq") 		= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "amdt_seq");
	 				sheetObj.SelectCell(Row, "atch_file_nm",true);
	 				
	 				break;
	 				
	 			case REMOVE03: // 파일 삭제 	
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	 				var sheetMain = sheetObjects[0];
	 				if(sheetMain.CellValue(sheetMain.HeaderRows,"atch_file_id") == "") {
	 					sheetObj.RemoveAll();
	 					toggleButtons();
	 				} else {	 				
		 				sheetObj.RowHidden(sheetObj.SelectRow)= true;
						sheetObj.RowStatus(sheetObj.SelectRow)= "D";
						
						if(sheetObj.RowStatus(sheetObj.SelectRow)== "D") {
							//저장 로직 수행할것.
							var returnVal = doActionIBSheet(sheetObj, document.form, MODIFY06);
							
							if(!returnVal) {
								sheetObj.RowHidden(sheetObj.SelectRow)= false;
								sheetObj.RowStatus(sheetObj.SelectRow)= "R";
							}
						}
	 				}
	 				break;
	 				
				case MODIFY06: // FILE save
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}					

	 				if (!ComPriConfirmSave()) {
	  					return false;
	  				}
					    
					formObj.f_cmd.value = MULTI02;					
					//1.IBUpload에 파일 추가하기
					var upObj = uploadObjects[0];					
					upObj.Files="";	//-먼저기존파일을 모두 지운후 추가함
					setFileUpload(sheetObj);
					
					//2.Form 데이터 QueryString으로 묶기
		            //var sParam = ComGetSaveString(sheetObj);
		            //if (sParam == "") return;
		            var sParam = "f_cmd=" + MULTI02;
		            
		            //3.IBSheet 데이터 QueryString으로 묶기
	 				var sParamSheet = sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}

		            ComOpenWait(true);
		           
		            //4. 서버에 request전달하고, reponse 받기		                
		            if (upObj.LocalFiles == "") {
		                //*******파일이 없는 경우 IBSheet 이용하기********//*
		                var sXml = sheetObj.GetSaveXml("ESM_PRI_3514GS.do", sParam);
		            } else {
		                //*******파일이 있는 경우 IBUpload 이용하기********//*
		                upObj.ExtendParam = sParam;
		                upObj.ParamDecoding = true;
		                var sXml = upObj.DoUpload(true);
		            }
		            		            
		            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);		            		            
		            //5. IBSHeet로 XML 로드하기
		            sheetObj.LoadSaveXml(sXml);
		            
		            return true;
		            break;	
	 					  		  
	 			case IBINSERT: // Row Add
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	 				var sheetMain		= sheetObjects[0];
	  				var trf_pfx_cd      = sheetMain.CellValue(sheetMain.HeaderRows, "trf_pfx_cd");
					var trf_no     		= sheetMain.CellValue(sheetMain.HeaderRows, "trf_no");
					var trf_inlnd_seq   = sheetMain.CellValue(sheetMain.HeaderRows, "trf_inlnd_seq");
					var amdt_seq 		= sheetMain.CellValue(sheetMain.HeaderRows, "amdt_seq");
					var max_seq 		= parseInt(ComPriGetMaxExceptDelete(sheetObj, "trf_inlnd_rt_seq"));
					
					var idx = sheetObj.DataInsert();										
					sheetObj.CellValue2(idx, "trf_pfx_cd") = trf_pfx_cd;
					sheetObj.CellValue2(idx, "trf_no") = trf_no;
					sheetObj.CellValue2(idx, "trf_inlnd_seq") = trf_inlnd_seq;	
					sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;
					sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
					sheetObj.CellValue2(idx, "trf_inlnd_rt_seq") = (max_seq > LOC_MAX_SEQ)? max_seq + 1 : LOC_MAX_SEQ + 1;
					sheetObj.CellValue2(idx, "src_info_cd") = "NW";
					
					sheetObj.SelectCell(idx, "inlnd_rt_bse_loc_cd");					
					toggleButtons();					

		 			if(sheetObj.CellValue(idx, "amdt_seq") > 0) {
		 				sheetObj.RowFontColor(idx) =  sheetObj.RgbColor(255,0,0);
		 			}
					
	    			//하이라이트처리
					changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
								
	 				break;

				case IBDELETE: // Delete
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					var amdtSeq = sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq");
					// 선택된 ROW 리스트/////////////////////////////////
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}	
					chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
						
					var sRow = 0;
					
					for(var j=0;j < chkArr.length;j++){						
						if(sheetObj.CellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")== amdtSeq 
								&& sheetObj.CellValue(Number(chkArr[j])+sRow, "src_info_cd") == "AM"){
							ComShowCodeMessage("PRI00313");
							sheetObj.SelectCell(Number(chkArr[j])+sRow, "seq");
			                return false;
						}
					}

					for(var j=0;j < chkArr.length;j++){
						
						if(sheetObj.CellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")!= amdtSeq){
							setSheetAmendRow(sheetObj,formObj,Number(chkArr[j])+sRow, "AD");							
							sRow++;								
						}
						
						if(sheetObj.CellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")== amdtSeq 
								&& sheetObj.CellValue(Number(chkArr[j])+sRow, "src_info_cd") == "AM"){
							sheetObj.CellValue2(Number(chkArr[j])+sRow, "src_info_cd") = "AD";
							sheetObj.CellValue2(Number(chkArr[j])+sRow, "chk") = 0;
						} else if (sheetObj.CellValue(Number(chkArr[j])+sRow, "n1st_cmnc_amdt_seq")== amdtSeq 
								&& sheetObj.CellValue(Number(chkArr[j])+sRow, "src_info_cd") == "AD"){
							sheetObj.CellValue2(Number(chkArr[j])+sRow, "chk") = 0;
						}
					}
					
					deleteRowCheck(sheetObj, "chk");
					toggleButtons();
					break;
					
				case MODIFY07: // Row Amend
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");					
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{			
							setSheetAmendRow(sheetObj,formObj,chkArr[0], "AM");
						}
					}else{ 
						setSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow, "AM");
					}
					sheetObj.SelectCell(sheetObj.SelectRow, "inlnd_rt_bse_loc_cd");
					toggleButtons();
					break;	

				case MODIFY08: // Amend Cancel
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}	

					var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							setSheetAmendRow(sheetObj,formObj,chkArr[0], "");
						}
					}else{ 
						setSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow, "");
					}
					toggleButtons();
					break;
					
				case IBSEARCH_ASYNC05: // 조회
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}	 				
	  				//ComOpenWait(true);
	 				var Row = sheetObj.FindText("inlnd_rt_bse_loc_nm", formObj.search_row.value, 0, 0, false);
	 				
	 				if(Row > -1) {
	 					sheetObj.SelectCell(Row, 2);
	 				} else {
	 					ComShowCodeMessage("PRI00018");
	 				}
	 				break;	 				
	 		}
 		} catch(e){

 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		} finally {
 			 ComOpenWait(false);
 		}
 	}
 		
	/**
     * 파일 선택하기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		//파일선택 다이얼로그 표시하기
		var fileName = sheetObj.OpenFileDialog("Open File");
		
		//선택된 파일명이 있는 경우 처리하기
		if(fileName.indexOf("\\") !=-1) {
			//선택된 파일의 전체 경로를 숨겨진 셀에 설정하기
			sheetObj.CellValue2(Row, "file_path_url")= fileName;

			//선택된 파일의 이름만 팝업 셀에 설정하기
			sheetObj.CellValue2(Row, Col)= fileName.substr(fileName.lastIndexOf("\\")+1);
			//sheetObj.CellValue2(Row, Col)= fileName;
			
			//파일업로드는 메인 수정으로 보기때문에 flag를 'U'처리해야한다.
			//데이터는 의미없음
			sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "atch_file_nm") = fileName;
			
		} else {	
			sheetObj.RemoveAll();
		}
		toggleButtons();
	}
		
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		if(sheetObj.ColSaveName(Col)!="file_dn" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, "atch_file_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "atch_file_id");
		return;
	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */
	function sheet2_OnDblClick(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col)!= "atch_file_nm" || sheetObj.RowStatus(Row)=="I") return;
		
		if(sheetObj.CellText(Row, "atch_file_id") == "") return;
		
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, "atch_file_id");
		return;
	}
	
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 최성민
     * @version 2010.11.01
     */ 		
	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {		
		if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			toggleButtons();
		}
	}
	

    /**
     * 마우스가 Sheet 위에서 움직일 때 발생하는 Event function <br>
     * Sheet의 어떤 영역이든 마우스가 이동 중일 때 Event가 발생한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {Integer} Button 필수 마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {Long} X 필수 X 좌표
     * @param {Long} Y 필수 Y 좌표
     * @return 없음
     * @author 최성민
     * @version 2010.11.01
     */
	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y)  {
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		if(Row == 1 && (Col == 1 || Col == 2)) {
			sheetObj.ToolTipText(Row, Col) = sheetObj.CellText(Row, "atch_file_nm");
		}
	}
	 
	 /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 최성민
     * @version 2010.11.05
     */
	function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
		var colname = sheetObj.ColSaveName(Col);
 	    var formObj = document.form;
 	    
      	switch(colname)
      	{  	    		
  	    	case "inlnd_rt_bse_loc_cd":
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?"
  	    			//sUrl += "f_cmd="+ SEARCH01;
  	    			sUrl += "location_cmd=L";
  	   	    	
	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = rtnVal.cd;
	  				sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm") = rtnVal.nm;
	  				sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd") = rtnVal.zip_cd;
	  			}
  	  			break;
  	  			
  	    	case "inlnd_rt_via_loc_cd":	
  	    		var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	    			//sUrl += "&f_cmd="+ SEARCH01;
	    			sUrl += "&location_cmd=L";

	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = rtnVal.cd;
	  			}
  				break;  		
      	}
	}
	

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 최성민
     * @version 2010.11.05
     */  
 	function sheet3_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
 		switch(colName)
     	{
 			case "inlnd_rt_bse_loc_cd":
 	    		if (Value.length > 1){
 	    			var sParam = "f_cmd=" + SEARCH01;
 	    				sParam += "&loc_cd=" + Value;
 	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", sParam);
 	  				
 	  				var arrData = ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
   	  				
   	  				if (arrData != null && arrData.length > 0){	   	  				
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = arrData[0][0];
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm")	= arrData[0][1];
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd")	= arrData[0][2];
					}else{
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = "";
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm")	= "";
						sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd")	= "";
	  					sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");
					}	  				
 	    		}else{	 
 	    			sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_cd") = "";
					sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_nm")	= "";
					sheetObj.CellValue2(Row, "inlnd_rt_bse_loc_zip_cd")	= "";
  					sheetObj.SelectCell(Row, "inlnd_rt_bse_loc_cd");		
 	    		}
 	    		break;
 	    		
 			case "inlnd_rt_via_loc_cd":	    		
 	    		if (Value.length > 1){
 	    			var sParam = "f_cmd=" + SEARCH01;
 	    				sParam += "&loc_cd=" + Value;
 	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_4026GS.do", sParam);
 	  				
 	  				var arrData = ComPriXml2Array(sXml, "loc_cd|loc_nm|zip_cd");
   	  				
   	  				if (arrData != null && arrData.length > 0){
						sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = arrData[0][0];
					}else{
						sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = "";
	  					sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");
					}	  				
 	    		}else{	 
 	    			sheetObj.CellValue2(Row, "inlnd_rt_via_loc_cd") = "";
  					sheetObj.SelectCell(Row, "inlnd_rt_via_loc_cd");		
 	    		}
 	    		break;	
     	}
 	}
 	 	
 	/**
 	 * Sheet Cell Editable을 일괄적으로 변경하는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 	 * @param {string} flag 필수 설정할 flag값
 	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
 	 */	
 	function inputSheetEditable(sheetObj, Row, flag) {
 		 sheetObj.CellEditable(Row,"inlnd_rt_bse_loc_cd") = flag; 	
 		 sheetObj.CellEditable(Row,"inlnd_rt_bse_loc_zip_cd") = flag;
		 sheetObj.CellEditable(Row,"inlnd_rt_term_cd") = flag;
		 sheetObj.CellEditable(Row,"inlnd_rt_via_loc_cd") = flag;
		 sheetObj.CellEditable(Row,"prc_inlnd_rt_trsp_mod_cd") = flag;
		 sheetObj.CellEditable(Row,"inlnd_rt_lmt_wgt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_rt_min_lmt_wgt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_rt_lmt_wgt_ut_cd") = flag;
		 sheetObj.CellEditable(Row,"prc_cgo_tp_cd") = flag;
		 sheetObj.CellEditable(Row,"curr_cd") = flag;
		 sheetObj.CellEditable(Row,"inlnd_bx_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_20ft_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_40ft_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_40ft_hc_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_45ft_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_one_wy_bx_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_one_wy_20ft_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_one_wy_40ft_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_one_wy_40ft_hc_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_one_wy_45ft_rt_amt") = flag;
		 sheetObj.CellEditable(Row,"inlnd_rt_rmk") = flag;
		 
		 
 	}
 	
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
   	 * @author 최성민
   	 * @version 2011.11.08
     */         
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
        	changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        	
     		//버튼 컨트롤
     		toggleButtons();
        }
    }
     
	/**
     * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function setFileUpload(sheetObj) {
		//트랜잭션 상태가 "입력"인 행을 찾아 온다.
		var sRow = sheetObj.FindStatusRow("I");
		var upObj = uploadObjects[0];
		var arrRow = sRow.split(";");
		
		for (var idx=0; idx<arrRow.length-1; idx++){ 
			var row = arrRow[idx];
			
			//파일 경로 가져오기
			var sFile = sheetObj.CellValue(row, "file_path_url");		
			//if (sFile=="") alert("[setFileUpload] 파일경로가 정확하지 않습니다.");
			
			//IBUpload에 파일 추가하기
			var ret = upObj.AddFile(sFile);
		}
	}
 	 	
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Row를 선택할때마다 권한별 버튼을 컨트롤한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */	
 	function setAuthButtonControl(sheetObj, NewRow, NewCol)  {
 		var formObj = document.form;
		var ofcCd = formObj.strofc_cd.value;
		
		//Amend Cancel
		if(ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd")) {
			ComBtnDisable("btn_amendcancel");
		}
		
		//Request 
		if(ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd")) {
			ComBtnDisable("btn_request");
		}
		
		//Approve 
		if(ofcCd != sheetObj.CellValue(NewRow, "apro_ofc_cd")) {
			ComBtnDisable("btn_approve");
		}

		//Cancel
		if(ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd") && ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd")) {
			ComBtnDisable("btn_cancel");
		} 	
 	}

     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function validateForm(sheetObj, formObj, sAction) {

		switch (sAction) {
		case IBCREATE: // New
			break;

 		case IBSEARCH: // 조회
 			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			} 			
			break;
			
 		case IBSEARCH_ASYNC01: // 조회
 			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
 			
 			if (comboObjects[1].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Inland Rates Name");
 				formObj.inlnd_cd.focus();
				return false;
			} 			
			break;
			
 		case IBSEARCH_ASYNC03: // 체크
 			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
 			
 			if (comboObjects[1].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Inland Rates Name");
 				formObj.inlnd_cd.focus();
				return false;
			}  			
			break;
			
 		case IBSEARCH_ASYNC04: // 조회
 			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
 			
 			if (comboObjects[1].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Inland Rates Name");
 				formObj.inlnd_cd.focus();
				return false;
			} 			
			break;
			
		
   		case IBSAVE: 	
   			if (comboObjects[0].Code == "") {
				return false;
			}
   			
   			if (sheetObj.RowStatus(sheetObj.SelectRow) == "I" && comboObjects[1].Text == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			} else if (sheetObj.RowStatus(sheetObj.SelectRow) == "U" && comboObjects[1].Text == "") {
				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}
   			
			if (!sheetObjects[0].IsDataModified && !sheetObjects[2].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			/*			
			if ((sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "")
					|| (sheetObjects[2].IsDataModified && sheetObjects[2].GetSaveString() == "")){
				return false;
			}
			*/
			
   			if (sheetObj.CellValue(sheetObj.SelectRow, "eff_dt") == "") {
   				ComShowCodeMessage("PRI00316", "Effective Date");
   				formObj.eff_dt.focus();
				return false;
			}

   			if (sheetObj.CellValue(sheetObj.SelectRow, "apro_ofc_cd") == "") {
   				ComShowCodeMessage("PRI00316", "Approval Office");
   				formObj.apro_ofc_cd.focus();
				return false;
			}

   			//날짜 체크	
            if(sheetObj.CellValue(sheetObj.SelectRow, "exp_dt") != "") {
            	if(sheetObj.CellValue(sheetObj.SelectRow, "eff_dt") >= sheetObj.CellValue(sheetObj.SelectRow, "exp_dt")) {
            		ComShowCodeMessage("PRI00345");
            		formObj.exp_dt.focus();
 					return false;
            	}
            }
          
            //중복체크 사용안함. - Hub, Depot이 존재할 경우 운임이 다를 수 있으므로 중복체크 제거
            /*
			if (sheetObjects[2].IsDataModified) {
				var dupRow = ComPriAmendDupRows(sheetObjects[2], "inlnd_rt_bse_loc_cd|inlnd_rt_bse_loc_zip_cd|inlnd_rt_term_cd"
						+"|inlnd_rt_via_loc_cd|prc_inlnd_rt_trsp_mod_cd|inlnd_rt_min_lmt_wgt|inlnd_rt_lmt_wgt|inlnd_rt_lmt_wgt_ut_cd"
						+"|prc_cgo_tp_cd|amdt_seq", formObj.amdt_seq.value);
				
				if (dupRow >= 0) {
					sheetObjects[2].CellValue2(dupRow, "chk") = "1";
					sheetObjects[2].SelectCell(dupRow, "seq");
		            ComShowCodeMessage("PRI00302");
		            return false;
				}
			}
           */
            
            
            var sheetLoc = sheetObjects[2];
            //인자->I|U, 결과->1;3;4;5;6;
            var sRow = sheetLoc.FindStatusRow("I|U");
            //받은 결과를 배열로 생성한다.
            var arrRow = sRow.split(";");            
            for (var idx=0; idx<arrRow.length-1; idx++) { 
            	
            	if (sheetLoc.CellValue(arrRow[idx], "inlnd_rt_bse_loc_cd") == "") {
       				ComShowCodeMessage("PRI00316", "Loc. Code");
       				sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_bse_loc_cd");
    				return false;
    			}
            	/*
            	if (sheetLoc.CellValue(arrRow[idx], "inlnd_rt_via_loc_cd") == "") {
       				ComShowCodeMessage("PRI00316", "Via");
       				sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_via_loc_cd");
    				return false;
    			}
            	*/
            	if (sheetLoc.CellValue(arrRow[idx], "curr_cd") == "") {
       				ComShowCodeMessage("PRI00316", "Currency");
       				sheetLoc.SelectCell(arrRow[idx], "curr_cd");
    				return false;
    			}
            	
            	//ONE WAY, ROUND TRIP 컬럼중에 최소1개는 금액이 입력되어 있어야 한다.
            	//엑셀파일에 요금이 없는 데이터가 존재하기 때문에 제외
            	/*
            	if(sheetLoc.CellValue(arrRow[idx], "inlnd_bx_rt_amt") == "" && sheetLoc.CellValue(arrRow[idx], "inlnd_20ft_rt_amt") == "" 
        			&& sheetLoc.CellValue(arrRow[idx], "inlnd_40ft_rt_amt") == "" && sheetLoc.CellValue(arrRow[idx], "inlnd_40ft_hc_rt_amt") == ""
            		&& sheetLoc.CellValue(arrRow[idx], "inlnd_45ft_rt_amt") == "" && sheetLoc.CellValue(arrRow[idx], "inlnd_one_wy_bx_rt_amt") == ""
                	&& sheetLoc.CellValue(arrRow[idx], "inlnd_one_wy_20ft_rt_amt") == "" && sheetLoc.CellValue(arrRow[idx], "inlnd_one_wy_40ft_rt_amt") == ""
                   	&& sheetLoc.CellValue(arrRow[idx], "inlnd_one_wy_40ft_hc_rt_amt") == "" && sheetLoc.CellValue(arrRow[idx], "inlnd_one_wy_45ft_rt_amt") == "") {
        			ComShowCodeMessage("PRI00308", "input","rate");
        			sheetLoc.SelectCell(arrRow[idx], "inlnd_one_wy_bx_rt_amt");
        			return false;
        		}
        		*/
            	
            	
            	var tMin = sheetLoc.CellValue(arrRow[idx], "inlnd_rt_min_lmt_wgt");
            	var tMax = sheetLoc.CellValue(arrRow[idx], "inlnd_rt_lmt_wgt");
            	var tUnit = sheetLoc.CellValue(arrRow[idx], "inlnd_rt_lmt_wgt_ut_cd");
        		// weight 입력시 단위도 입력되어야 한다. 
        		if((tMax != "" || tMin != "") && tUnit == ""){
        			ComShowCodeMessage("PRI00308", "input","weight unit");
        			sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_lmt_wgt_ut_cd");
        			return false;
        		}

        		//  단위 입력시 weight도 입력되어야 한다. 
        		if(tUnit != "" && (tMax == "" && tMin == "")){
        			ComShowCodeMessage("PRI00308", "input","weight");
        			sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_lmt_wgt");
        			return false;
        		}

        		//  min > max 불가
        		if(tMax != "" && tMin != "" && tUnit != ""){
        			if(Number(tMin) > Number(tMax)) {
        				ComShowCodeMessage("PRI08008");
            			sheetLoc.SelectCell(arrRow[idx], "inlnd_rt_lmt_wgt");
            			return false;
        			}
        		}
            }

			   			            
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;

 		case MODIFY01: // Amend
 			if (comboObjects[0].Code == "") {
 				return false;
 			}

   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}	
			break;

 		case MODIFY02: // Request
 			if (comboObjects[0].Code == "") {
 				return false;
 			}

   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}
   			
            if(formObj.exp_dt.value != "") {
            	if(ComGetUnMaskedValue(formObj.eff_dt, "ymd") > ComGetUnMaskedValue(formObj.exp_dt, "ymd")) {
            		ComShowCodeMessage("PRI00346");
 					return false;
            	}
            }
            /*
            if (sheetObjects[0].IsDataModified) {
				ComShowCodeMessage("PRI01057");
				return false;
			}
            */ 	            
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////            
 			break;

 		case MODIFY03: // Approve 
 			if (comboObjects[0].Code == "") {
 				return false;
 			}

   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}
 			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
			break;

   		case IBINSERT: // Row Add
   			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			} 
 			break;

 		case IBDELETE: // Row Delete
 			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
 			
 			if(getValidRowCount(sheetObj) < 1) {
 				return false;
 			}
 			
 			//선택된 ROW가 100이하만 가능
 			if(sheetObj.CheckedRows("chk") > 100) {
 				ComShowCodeMessage("PRI00333","Over 100 rows");
 				return false;
 			}
 			break;
 			
 		case REMOVE01: // Remove
 			if (comboObjects[0].Code == "") {
 				return false;
 			}

   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}
 			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;
 		
 		case REMOVE02: // Cancel
 			if (comboObjects[0].Code == "") {
 				return false;
 			}

   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}
 			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;
 		
 		case IBDOWNEXCEL: // Cancel
 			if (comboObjects[0].Code == "") {
 				return false;
 			}

   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}
 			break;

    	case IBLOADEXCEL:
    		if (comboObjects[0].Code == "") {
 				return false;
 			}

   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}	
 			break;

 		case MODIFY05: // 파일 추가 	
 			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
 			
   			if (getValidRowCount(sheetObj) == 1) {
   				return false;
   			}
 			break;
 			
 		case REMOVE03: // 파일 삭제
   			if (getValidRowCount(sheetObj) == 0) {
   				return false;
   			}
 			break;
 					
 				
 		case MODIFY06: // Upload Save
   			if (comboObjects[1].Code == "") {
   				ComShowCodeMessage("PRI00316", "Inland Rates Name");
   				formObj.inlnd_cd.focus();
				return false;
			}
 			
 			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
 			 			
 			if(sheetObj.RowStatus(sheetObj.HeaderRows) != "D" && sheetObj.CellValue(sheetObj.HeaderRows, "atch_file_id") != "" ) {
 				return false;
 			}
 			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObjects[0], "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;
 		}

 		return true;
 	}



 	/**
 	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;

 		if(sheetObj.RowCount > 0) {
 			formObj.amdt_seq.value = sheetObj.CellValue(1, "amdt_seq");
 			formObj.trf_inlnd_sts_nm.value = sheetObj.CellValue(1, "trf_inlnd_sts_nm");
 			formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "cre_dt"), "ymd");
 			formObj.eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "eff_dt"), "ymd");
 			formObj.exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "exp_dt"), "ymd");
 			formObj.pub_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "pub_dt"), "ymd");
 			formObj.rqst_ofc_cd.value = sheetObj.CellValue(1, "rqst_ofc_cd");
 			formObj.cre_usr_id.value = sheetObj.CellValue(1, "cre_usr_id");
 			comboObjects[3].Code2 = sheetObj.CellValue(1, "apro_ofc_cd");
 			comboObjects[2].Code2 = sheetObj.CellValue(1, "trf_inlnd_amdt_tp_cd");
 			
 			initLocationSheetColumn(); 
 		}
 	} 	

 	/**
 	 * Sheet의 타이틀 제목을 초기화하는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.13
 	 */
 	function initLocationSheetColumn() {
 		var formObj = document.form;
 		var sheetM = sheetObjects[0];
 		var sheetD = sheetObjects[2];
 		var sheetExcel = sheetObjects[3];
 		var colName = " ";
 		
 		if(comboObjects[1].Code != "") {
 			colName = comboObjects[0].Code + " " + formObj.trf_nm.value + " - " + sheetM.CellValue(1, "trf_inlnd_nm");
 		}
 		
 		sheetD.CellText(0, 1) = colName;
 		sheetD.CellText(0, 2) = colName;
		sheetD.CellText(0, 3) = colName;
		sheetD.CellText(0, 4) = colName;
		sheetD.CellText(0, 5) = colName;
		sheetD.CellText(0, 6) = colName;
		sheetD.CellText(0, 7) = colName;
		sheetD.CellText(0, 8) = colName;
		sheetD.CellText(0, 9) = colName;
		sheetD.CellText(0, 10) = colName;
		sheetD.CellText(0, 11) = colName;
		sheetD.CellText(0, 12) = colName;
		sheetD.CellText(0, 13) = colName;
		
		sheetExcel.CellText(0, 1) = colName;
		sheetExcel.CellText(0, 2) = colName;
		sheetExcel.CellText(0, 3) = colName;
		sheetExcel.CellText(0, 4) = colName;
		sheetExcel.CellText(0, 5) = colName;
		sheetExcel.CellText(0, 6) = colName;
		sheetExcel.CellText(0, 7) = colName;
		sheetExcel.CellText(0, 8) = colName;
		sheetExcel.CellText(0, 9) = colName;
		sheetExcel.CellText(0, 10) = colName;
		sheetExcel.CellText(0, 11) = colName;
		sheetExcel.CellText(0, 12) = colName;
		sheetExcel.CellText(0, 13) = colName;
 	}
 	
 	/**
 	 * 폼객체의 사용 가능/불가능 상태를 변경하는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.13
 	 */
 	function controlFormEnable(sheetObj) {
 		var formObj = document.form;
 		var comboObj = comboObjects[3];
 		var comboObj2 = comboObjects[2];
 		var stsCd = sheetObj.CellValue(sheetObj.HeaderRows, "trf_inlnd_sts_cd");
 		var amdtSeq = sheetObj.CellValue(sheetObj.HeaderRows, "amdt_seq");
 	
 		var ofcCd = formObj.ofc_cd.value;
 		var rqstOfcCd 	= sheetObj.CellValue(sheetObj.HeaderRows, "rqst_ofc_cd"); 		
 		
 		if(stsCd == "I" && ofcCd == rqstOfcCd) {
 			if(amdtSeq > 0) {
 				formObj.eff_dt.readOnly = true;
 				formObj.eff_dt.className = "input2";
 			} else {
 				formObj.eff_dt.readOnly = false;
 				formObj.eff_dt.className = "input1";
 			}
 			formObj.exp_dt.readOnly = false;
 			formObj.exp_dt.className = "input";
 			comboObj.Enable = true; 
 			comboObj2.Enable = true;
 			
 		} else {			
 			//ComEnableObject(formObj.eff_dt, false);
 			//ComEnableObject(formObj.exp_dt, false);
 			formObj.eff_dt.readOnly = true;
 			formObj.exp_dt.readOnly = true;
 			formObj.eff_dt.className = "input2";
 			formObj.exp_dt.className = "input2";
 			comboObj.Enable = false;
 			comboObj2.Enable = false; 
 		}
 	}

 	/**
 	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param {string} mode 필수 사용자 권한이나 모드
   	 * @author 최성민
   	 * @version 2010.10.13
 	 */
 	function toggleButtons() {
 		var formObj = document.form;
 		var sheet1 = sheetObjects[0];
 		var sheet2 = sheetObjects[1];
 		var sheet3 = sheetObjects[2];
 		var combo2 = comboObjects[1];
 		var ofcCd = formObj.ofc_cd.value;
 		
 		var sts 	= sheet1.CellValue(sheet1.HeaderRows, "trf_inlnd_sts_cd");
 		var fileId 	= sheet1.CellValue(sheet1.HeaderRows, "atch_file_id");
 		var amdtNo 	= sheet1.CellValue(sheet1.HeaderRows, "amdt_seq");
 		var seq 	= sheet1.CellValue(sheet1.HeaderRows, "trf_inlnd_seq");
 		var rqstOfcCd 	= sheet1.CellValue(sheet1.HeaderRows, "rqst_ofc_cd");
 		var aproOfcCd	= sheet1.CellValue(sheet1.HeaderRows, "apro_ofc_cd");
 		 		
 		var amdtSeq 	= sheet3.CellValue(sheet3.SelectRow, "amdt_seq");
 		var n1stSeq 	= sheet3.CellValue(sheet3.SelectRow, "n1st_cmnc_amdt_seq");
 		var srcInfoCd 	= sheet3.CellValue(sheet3.SelectRow, "src_info_cd");
 		
 		try {
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnDisable("btn_save");
 			
 			ComBtnDisable("btn_amend");
 			ComBtnDisable("btn_delete");
 			ComBtnDisable("btn_request");
 			ComBtnDisable("btn_approve");
 			ComBtnDisable("btn_publish");
 			ComBtnDisable("btn_cancel");
 			
 			btnImgEnable(formObj.btns_calendar1, true);
 			btnImgEnable(formObj.btns_calendar2, true);
 			 			 			
 			ComSetDisplay("btn_fileadd",true);
 			ComBtnDisable("btn_fileadd");
 			ComSetDisplay("btn_filedelete",false);
 			ComBtnDisable("btn_filedelete");
 			
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowdelete");
 			ComBtnDisable("btn_rowamend");
 			ComBtnDisable("btn_amendcancel");
 			ComBtnDisable("btn_loadexcel");
 			
			if(getValidRowCount(sheet2) > 0) {
				ComSetDisplay("btn_fileadd",false);
				ComSetDisplay("btn_filedelete",true);	 					
			}				 
				
 			if(sheet3.RowCount > 0) {
				ComBtnEnable("btn_downexcel");
			} else {
				ComBtnDisable("btn_downexcel");
			}
 			
 			//checkbox control
 			if(Number(amdtNo) == 0) {
 				formObj.search_view_yn.disabled = true;
 			} else {
 				formObj.search_view_yn.disabled = false;
 			}
 			
 			switch (sts) {
 	 		case "I":

 	 			if(ofcCd == rqstOfcCd) {  			
 	 				ComBtnEnable("btn_save");
 	 			} else if(ofcCd != rqstOfcCd) {
 	 				btnImgEnable(formObj.btns_calendar1, false);
 	 				btnImgEnable(formObj.btns_calendar2, false);
 	 				return;
 	 			}
 	 			
 	 			if(seq != "") {
	 	 			if(amdtNo == 0) {
	 	 				ComBtnEnable("btn_delete");
	 	 			} else {
	 	 				btnImgEnable(formObj.btns_calendar1, false);
	 	 				ComBtnEnable("btn_cancel");
	 	 			}
	 	 			
	 	 			ComBtnEnable("btn_request");
	 	 			
 	 				if(fileId != "" || getValidRowCount(sheet2) > 0) {
 	 					ComBtnEnable("btn_filedelete");
 	 				} else {
 	 					ComBtnEnable("btn_fileadd");
 	 				}
 	 				
 					if(!formObj.search_view_yn.checked && (amdtNo == 0 || amdtSeq == amdtNo)) {
	 	 				ComBtnEnable("btn_rowadd");
	 	 				ComBtnEnable("btn_rowdelete");
 	 				}

 	 				if(amdtSeq != n1stSeq && amdtNo == amdtSeq && (srcInfoCd == "AM" || srcInfoCd == "NW")) {
 	 	 				ComBtnEnable("btn_rowamend");
 	 				} else if(amdtSeq == n1stSeq && amdtNo == amdtSeq && srcInfoCd == "AM") {
 	 	 				ComBtnEnable("btn_amendcancel");
 	 	 				ComBtnDisable("btn_rowdelete");
 	 	 			} else if(amdtSeq == n1stSeq && amdtNo == amdtSeq && srcInfoCd == "AD") {
 	 	 				ComBtnEnable("btn_amendcancel");
 	 	 				ComBtnDisable("btn_rowdelete");
 	 	 			}
 	 				ComBtnEnable("btn_loadexcel");
 	 				
 	 			} else {
 					ComBtnEnable("btn_rowadd");
 	 				ComBtnEnable("btn_rowdelete");
 	 				ComBtnEnable("btn_fileadd");
 	 			}
 	 			break;
 	 		case "Q":
 	 			if(ofcCd == rqstOfcCd) {  
 	 				ComBtnEnable("btn_cancel"); 
 	 			}
 	 			
 	 			if(sheet1.CellValue(sheet1.HeaderRows, "apro_flg") == "Y") {
 	 				ComBtnEnable("btn_approve"); 
 	 				ComBtnEnable("btn_cancel");
 	 			}
 	 			
 	 			/* 	 			
 	 			if(ofcCd == aproOfcCd) {  			
 	 				ComBtnEnable("btn_approve"); 
 	 				ComBtnEnable("btn_cancel");
 	 			}
 	 			*/
 				btnImgEnable(formObj.btns_calendar1, false);
 				btnImgEnable(formObj.btns_calendar2, false);
 	 			break; 	 			
 	 			
 			case "A":
 				ComBtnEnable("btn_publish");
 				 	 			
 				if(sheet1.CellValue(sheet1.HeaderRows, "apro_flg") == "Y") {
 					ComBtnEnable("btn_cancel");
 	 			}
 				/*
 	 			if(ofcCd == aproOfcCd) {  
 	 				ComBtnEnable("btn_cancel"); 
 	 			}	
 				*/
 				
 				btnImgEnable(formObj.btns_calendar1, false);
 				btnImgEnable(formObj.btns_calendar2, false);
 	 			break;
 	 	
 	 		case "F":
 	 			ComBtnEnable("btn_amend");

 				btnImgEnable(formObj.btns_calendar1, false);
 				btnImgEnable(formObj.btns_calendar2, false);
 	 			break;
 	 		default:
 	 			break;
 	 		}
 			
 		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
 		}
 	}
 	
   	/**
   	 * OnChange 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function tariff_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   		var sheetObj = sheetObjects[0];
   		
   		var arrText = text.split("|");
   		if (arrText != null && arrText.length > 1) {   			
   			
   			//리셋
   			resetObjectValue("1");
   			
            sheetObj.DataInsert();
            sheetObj.CellValue2(sheetObj.HeaderRows, "trf_inlnd_sts_cd")= "I";
            sheetObj.CellValue2(sheetObj.HeaderRows ,"amdt_seq")= "0";
            sheetObj.CellValue2(sheetObj.HeaderRows ,"rqst_ofc_cd")= formObj.ofc_cd.value;
            //최근업데이트 날짜 초기화
            MAX_UPD_DT = "";
   			
   			formObj.trf_nm.value = comboObj.GetText(code, 1);   			
			var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
			
			sheetObj.CellValue2(sheetObj.HeaderRows, "trf_pfx_cd") = arr[0];
			sheetObj.CellValue2(sheetObj.HeaderRows, "trf_no") = arr[1];
		
 			doActionIBSheet(sheetObj, document.form, IBSEARCH);
 			
 			//폼 컨트롤
			//comboObjects 를 Enable 처리할때는 ComOpenWait(false) 호출 후에 처리해야 한다.
	 		controlFormEnable(sheetObj);
 			
	 		toggleButtons();
	 		
   		}
   	}
	  
   	/**
   	 * OnClear 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function tariff_cd_OnClear(comboObj) {
   		var formObj = document.form;
   		formObj.trf_nm.value = "";   		
   		comboObj.Index = -1;
   	}
   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    tariff_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */   	
   	function tariff_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		var sheetObj = sheetObjects[0];
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);
   		
   		if (code != null && code != "") {
   	   		var arr = code.split("-");				
   			formObj.trf_pfx_cd.value = arr[0];
   			formObj.trf_no.value = arr[1];

			sheetObj.CellValue2(sheetObj.HeaderRows, "trf_pfx_cd") = arr[0];
			sheetObj.CellValue2(sheetObj.HeaderRows, "trf_no") = arr[1];

   			var text = comboObj.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.trf_nm.value) {
   				formObj.trf_nm.value = comboObj.GetText(code, 1);
   				
   	 			doActionIBSheet(sheetObj, document.form, IBSEARCH);   	 			
   			}
   		}
   	}
   	
	
   	/**
   	 * OnChange 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function inlnd_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   		var sheetObj = sheetObjects[0];
   		
   		if (text != null) {
   			if(comboObj.Index == -1) {
   				sheetObj.CellValue2(sheetObj.HeaderRows, "trf_inlnd_nm") = text;
   			} else {   	
   	   			//formObj.trf_inlnd_seq.value = code; // 멀티콤보에서 아래버튼으로 자동검색시 code값을 못가져옴.
   	   			formObj.trf_inlnd_seq.value = comboObj.Code;
   	   			sheetObj.CellValue2(sheetObj.HeaderRows, "trf_inlnd_seq") = comboObj.Code;
   				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);
   			}
   		}
   	}

   	/**
   	 * OnClear 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function inlnd_cd_OnClear(comboObj) {
   		var formObj = document.form;		
   		comboObj.Index = -1;
   	}
   	   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    inlnd_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */   	
   	function inlnd_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		var sheetObj = sheetObjects[0];
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);   	
   		
   		if (code != null && code != "" && code != -1) {
   			formObj.trf_inlnd_seq.value = comboObj.Code;
	   		sheetObj.CellValue2(sheetObj.HeaderRows, "trf_inlnd_seq") = comboObj.Code;
   		}
   		
   		//New버튼 누른상태에서 Tariff Code선택하고 Inland Rates Name를 클릭하고 나서 포커스를 다른 OBJECT로 
   		//옮긴다음 다시 포커스를  Inland Rates Name로 옮긴다음에 입력할경우에 대응하기 위함.
   		if(code == -1 && comboObj.Text != "") {
   			sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "trf_inlnd_nm") = comboObj.Text;
   		}
   	}
   	
	
   	/**
   	 * OnChange 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function apro_ofc_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   	   		
   		if (text != null) {   			
   			changeSheetData( sheetObjects[0], "apro_ofc_cd");
   		}
   	}

   	/**
   	 * OnClear 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function apro_ofc_cd_OnClear(comboObj) {
   		var formObj = document.form;		
   		comboObj.Index = -1;
   	}
   	   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    apro_ofc_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */   	
   	function apro_ofc_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);   		
   		if (code != null && code != "") {
   			//doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
   		}
   	}
   	
	
   	/**
   	 * OnChange 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function trf_inlnd_amdt_tp_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   	   		
   		if (text != null) {   			
   			changeSheetData( sheetObjects[0], "trf_inlnd_amdt_tp_cd");
   		}
   	}

   	/**
   	 * OnClear 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function trf_inlnd_amdt_tp_cd_OnClear(comboObj) {
   		var formObj = document.form;		
   		comboObj.Index = -1;
   	}
   	   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    trf_inlnd_amdt_tp_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */   	
   	function trf_inlnd_amdt_tp_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);   		
   		if (code != null && code != "") {
   			//doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
   		}
   	}
   
   	/**
   	 * 메인 조회시 Attached file이 존재할경우 Attached File Sheet에 값을 세팅하는 function<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    searchSheetAttachedFile(sXml);
   	 * </pre>
   	 * @param   {String} sXml 필수 xml Sheet data
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.29
   	 */   	
   	function searchSheetAttachedFile(sXml) {
   		var sheetMain = sheetObjects[0];
   		var sheetFile = sheetObjects[1];

   		//Attach file 
		if(sheetMain.CellValue(sheetMain.HeaderRows, "atch_file_id") != "") {
			ComPriXml2Sheet(sheetFile, sXml);
			sheetFile.CellValue2(1, "file_dn") = 0;
		} else {
			sheetFile.RemoveAll();
		}	
   	}
	   
   /**
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확은을 한다.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} sheetObj update date와 key를 가진 sheet object
    * @param {String} checkTpCd update date를 check해야 하는 table이 다를 수 있다 이를 구분하는 code
    *  
    * @return boolean , true : 변경된 데이터 있음, false: 변경된 데이터 없음.
    * @author 최성민
    * @version 2010.12.20
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
    	
    	var returnValue = false;
        /////////////////////////////////////////////////////////////////////
    	
        // update date 검사
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
	        + "&key1="+sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd") 
	        + "&key2="+sheetObj.CellValue(sheetObj.SelectRow, "trf_no") 
	        + "&key3="+sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") 
	        + "&key4="+sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_seq")
	        + "&upd_dt="+sheetObj.CellValue(sheetObj.SelectRow, "upd_dt");
	        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        
	        //메인에 변경사항이 없으면 DETAIL정보를 조회한다.
	        if(!returnValue && sheetObjects[2].IsDataModified) {
	        	checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND_RT&page_name=Inland Rates Location"
		        + "&key1="+sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd") 
		        + "&key2="+sheetObj.CellValue(sheetObj.SelectRow, "trf_no") 
		        + "&key3="+sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") 
		        + "&key4="+sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_seq")
		        + "&upd_dt="+ MAX_UPD_DT;
		        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
		        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
		        	sheetObj.LoadSearchXml(cXml);
		        	ComOpenWait(false); //->waiting->End
		        	returnValue = true;
		        }
	        }
	        break;
	   case "CHECK2" : //amend
	   	    var amdt_seq = parseInt(sheetObj.CellValue(1, "amdt_seq"));
	   		//다음 seq가 이미 생성되었는지 확인한다.
	   		amdt_seq++;
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
	        + "&key1="+sheetObj.CellValue(sheetObj.HeaderRows, "trf_pfx_cd") 
	        + "&key2="+sheetObj.CellValue(sheetObj.HeaderRows, "trf_no") 
	        + "&key3="+amdt_seq
	        + "&key4="+sheetObj.CellValue(sheetObj.HeaderRows, "trf_inlnd_seq")
	        + "&upd_dt="+sheetObj.CellValue(sheetObj.HeaderRows, "upd_dt");
	        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
  	     
    /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_onKeypress()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */
	function obj_onKeypress() {
       switch (event.srcElement.dataformat) {  
	        case "engup":
	            if (event.srcElement.name == "rule_no") {
	                ComKeyOnlyAlphabet('uppernum',"45");
	            }    
	            break;
           case "int":
               ComKeyOnlyNumber(event.srcElement);
               break;
           case "float":
               ComKeyOnlyNumber(event.srcElement, ".");
               break;
           case "ymd":
           	ComKeyOnlyNumber(event.srcElement, "-");
               break;
           default:
       }
   }  
	
   /**
    * OnKeyDown event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param 없음
    * @return 없음
   	* @author 최성민
   	* @version 2010.10.13
    */  
	function obj_onKeydown(){
	 	var eleName = event.srcElement.name;
	 	
	 	if (eleName == "search_row"){
		 	var keyValue = null;
			if(event == undefined || event == null) {
		    	keyValue = 13;
			}else{
		    	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		  	}
		   	if (keyValue == 13){
		    	doActionIBSheet(sheetObjects[2],document.form, IBSEARCH_ASYNC05);
		  	}
		}
	}
	
   /**
    * onClick event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param 없음
    * @return 없음
   	* @author 최성민
   	* @version 2010.10.13
    */  
	function obj_onClick(){
	 	var eleName = event.srcElement.name;
	 	
	 	if (eleName == "search_view_yn"){
	 		if(sheetObjects[2].IsDataModified) {
	 			ComShowCodeMessage("PRI01057");
				return false;
	 		}
	 		
	 		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC07);
		}
	}

  /**
   * OnBeforeActivate   event를 처리한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *     obj_activate()
   * </pre>
   * @param 없음
   * @return 없음
   * @author 최성민
   * @version 2010.10.13
   */   
   function obj_onActivate() {
       var formObj = document.form;
       var srcName = event.srcElement.getAttribute("name");
       ComClearSeparator (event.srcElement);
   }
   
   
  /**
   * Onbeforedeactivate  event를 처리한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *     obj_onDeactivate()
   * </pre>
   * @param 없음
   * @return 없음
   * @author 최성민
   * @version 2010.10.13
   */   
   function obj_onDeactivate() {
       var eleName = event.srcElement.name;
       switch(eleName){          
           case "eff_dt":
        	   changeSheetData( sheetObjects[0], eleName );
               ComChkObjValid(event.srcElement);   
               break;
           case "exp_dt":
        	   changeSheetData( sheetObjects[0], eleName );
               ComChkObjValid(event.srcElement);   
               break;
           case "cre_dt":
        	   changeSheetData( sheetObjects[0], eleName );
               ComChkObjValid(event.srcElement);   
               break;
           case "pub_dt":
        	   changeSheetData( sheetObjects[0], eleName );
               ComChkObjValid(event.srcElement);   
               break;
       }
   }  
   
       
   /**
    * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
    * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *   changeSheetData( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} colNm 필수 Html Object의 name
    * @return 없음
    * @author 최성민
    * @version 2010.11.01
    */  
    function changeSheetData( sheetObj, colNm ){
        var eleValue = "";

        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                case "eff_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;
                case "exp_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                default:
                    eleValue = document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.CellValue2(sheetObj.HeaderRows, colNm) = eleValue;     

        }else{
            sheetObj.CellValue2(sheetObj.HeaderRows, colNm) = document.getElementById(colNm).Code;
        }
    }
    
 	
   	/**
   	 * Tariff Code OnChange 이벤트 발생시 reset 처리하는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {string} flagInfo 필수 0:전체 리셋, 1:tariff code 제외하고 모두 리셋
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */  	
   	function resetObjectValue(flagInfo) {
   		var formObj = document.form;
   		var sheetObj1 = sheetObjects[0];
   		var sheetObj2 = sheetObjects[1];
   		var sheetObj3 = sheetObjects[2];
   		   		
   		formObj.amdt_seq.value = "";
   		formObj.trf_inlnd_sts_nm.value = "";
   		formObj.eff_dt.value = "";
   		formObj.exp_dt.value = "";
   		formObj.cre_dt.value = "";
   		formObj.pub_dt.value = "";
   		formObj.rqst_ofc_cd.value = formObj.ofc_cd.value;
   		formObj.cre_usr_id.value = formObj.usr_id.value;
   		formObj.search_row.value = "";
   		
   		if(flagInfo == "0") {
   			comboObjects[0].Index = -1;
   			formObj.trf_nm.value = "";
   		}
   		comboObjects[1].Index = -1;
   		comboObjects[2].Index = -1;
   		comboObjects[3].Index = -1;
   		   		
   		sheetObjects[0].RemoveAll();
   		sheetObjects[1].RemoveAll();
   		sheetObjects[2].RemoveAll();
   		
   		initLocationSheetColumn();
   	}

	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetObj sheetObject
   	 * @author 최성민
   	 * @version 2010.10.13
	 */
    function getSheetXml() { 
    	var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var sXml = "";
        var sCol = "";
        var sValue = "";
        
        sCol = "trf_pfx_cd|trf_no|trf_inlnd_seq|amdt_seq";
        sValue = sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd")
        	+ "|" + sheetObj.CellValue(sheetObj.SelectRow, "trf_no")
        	+ "|" + sheetObj.CellValue(sheetObj.SelectRow, "trf_inlnd_seq")
        	+ "|" + sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq");
        
        sXml = ComPriSheet2Xml(sheetObj, null, sCol, sValue);
        
        return sXml;
    }

    /**
     * 대상 ROW 를 Amend 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} Row 필수,  선택된 셀의 Row Index
     * @param {string} srcInfo 선택, M : Update Amend, D : Delete Amend
     * @param {string} excelFlg 선택, 엑셀업로드시 'Y'
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.11.08
     */         
  	function setSheetAmendRow(sheetObj, formObj, Row, srcInfo){
		var amdt_seq = formObj.amdt_seq.value;

        // chebox 를 이용할 경우 해당 chk 를 제거
        sheetObj.CellValue(Row,"chk")=0;
      
		//Amend Cancel
		if(srcInfo==""){
			var bf_row = Row-1;
			
			//신규row
			sheetObj.RowDelete(Row, false);
			//기존row
			sheetObj.RowEditable(bf_row) = true;
        	inputSheetEditable(sheetObj, bf_row, false);
        	sheetObj.RowStatus(bf_row) = "U";
	        sheetObj.SelectCell(bf_row, "chk");
			sheetObj.CellValue2(bf_row,"amdt_seq")=amdt_seq;
			sheetObj.CellFont("FontStrikethru", bf_row, 1, bf_row, sheetObj.LastCol)=false;
			 
		}else{
			if(sheetObj.CellValue(Row, "n1st_cmnc_amdt_seq")!= amdt_seq){

		        // DataCopy/ Insert 기준 row 를 잡기 위해 Row 설정
		        sheetObj.SelectRow = Row;

				var idx = sheetObj.DataCopy();     // 신규 row
		        var idx2 = idx-1;                  // 기존 row
		        //신규row
		        sheetObj.CellValue2(idx, "src_info_cd") = srcInfo;
		        sheetObj.CellValue2(idx,"n1st_cmnc_amdt_seq")= amdt_seq;
		        //sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
		        sheetObj.RowFontColor(idx) =  sheetObj.RgbColor(255,0,0);
		        sheetObj.RowStatus(idx) = "U";
		        
		        if(srcInfo=="AM") {
		        	sheetObj.RowEditable(idx) = true;
		        	inputSheetEditable(sheetObj, idx, true);
		        	    	
		        } else if(srcInfo=="AD") {
		        	sheetObj.RowEditable(idx) = true;
		        	inputSheetEditable(sheetObj, idx, false);	        	
		        } 
		        
		        //기존row
		        sheetObj.CellValue2(idx2,"amdt_seq")=amdt_seq-1;
		        sheetObj.CellFont("FontStrikethru", idx2, 1, idx2, sheetObj.LastCol)=true;
		        sheetObj.RowStatus(idx2) = "R"; // 기존 Row 의 상태를 R로 변경해서 저장되지 않도록 함
		        sheetObj.RowEditable(idx2) = false;		        	
		       
			} 
			/*
			else {
				if(srcInfo=="AD"){					
					sheetObj.RowStatus(Row) = "D";
					sheetObj.RowHidden(Row) = true;	        
					
				}
			}
			*/
		}

        changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
  	}
	
   /**
	* 이미지로 된 버튼을 활성, 비활성화 한다.<br>
	* <br><b>Example :</b>
	* <pre>
	*    btnImgEnable(obj, gb);
	* </pre>
	* @param  {form} obj 필수 Html Object
	* @param  {bool} gb  필수 true : 활성화 false : 비활성화
	* @return 없음
	* @author 최성민
	* @version 2010.11.08
	*/ 
	function btnImgEnable(obj, gb) {
		if(obj.constructor == String){
	        obj = document.getElementsByName(obj)[0];        
	    }
	    var btnStyle = obj.style;
	    
	    if (gb){
	        obj.Enable = true;
	        btnStyle.cursor = "hand";
	        btnStyle.filter="";
	        obj.disabled = false;
	    } else {
	        obj.Enable = false;        
	        btnStyle.cursor = "auto";
	        btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
	        obj.disabled = true;
	    }
	}
	

    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array형태로 변환한다. <br>
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComPriXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
     *
     * 결과: 35X 3 크기의 결과 Array.
     * </pre>
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
     * @param {string} colList 필수, XML문자열에서 추출하고자하는 컬럼명(Savename). "|"로 연결한다.
     * @return array   [조회된row수 X 컬럼수] 크기의 string array.
   	 * @author 최성민
   	 * @version 2010.11.08
     */
    function ComPriXml2ComboItemList(xmlStr, cmbObj, codeCol, textCol, bClear) {
        if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
            return;
        }
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
            return;
        }

        try {
            if (bClear != false) {
                cmbObj.RemoveAll();
            }

            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);
        
            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null) {
                return;
            }

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);           
            if (dataNode == null || dataNode.attributes.length < 2) {
                return;
            }

            var col = dataNode.getAttribute("COLORDER");
            var colArr = col.split("|");
               
            var sep = dataNode.getAttribute("COLSEPARATOR");
            var total = dataNode.getAttribute("TOTAL");

            var dataChildNodes = dataNode.childNodes;
            if (dataChildNodes == null) {
                return;
            }

            var colListIdx = Array();
            var arrText = textCol.split("|");
            for (var i = 0; i < colArr.length; i++) {
                if (colArr[i] == codeCol) {
                    colListIdx[0] = i;
                }
                for (var j = 0; j < arrText.length; j++) {
                    if (colArr[i] == arrText[j]) {
                        colListIdx[j+1] = i;
                    }
                }
            }

            for (var i = 0; i < dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) {
                    continue;
                }

                var arrData = null;
                if (sep == null || sep == "") {
                    arrData = new Array();
                    var trChildNodes = dataChildNodes[i].childNodes;
                    for (var j = 0; j < trChildNodes.length; j++) {
                        if (trChildNodes[j].nodeType != 1) {
                            continue;
                        }
                        arrData.push(trChildNodes[j].firstChild.nodeValue);
                    }
                } else {
                    arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                }

                var item = "";
                for (var j = 1; j < colListIdx.length; j++) {
                    item += arrData[colListIdx[j]];
                    if (j < colListIdx.length - 1) {
                        item += "|";
                    }
                }
                cmbObj.InsertItem(-1, item, arrData[colListIdx[0]]);
            }

        } catch (err) {
            ComFuncErrMsg(err.message);
        }
    }
    
    

    /**
     * IBSheet에서 Amend를 고려한 중복체크를 실행한다.
     * 이전 Amend Sequence를 가진 행이나, Amend Delete(AD)된 행은 제외하고 체크한다.
     * 중복된 행이 없으면 -1을, 중복된 행이 있으면 해당 행의 row Index를 반환한다.(0 이상 값)  <br>
     * <br><b>Example :</b>
     * <pre>
     *     var dupRow = ComPriAmendDupRows(sheetObj, "prc_cmdt_tp_cd|prc_cmdt_def_cd", formObj.amdt_seq.value);
     *     if (dupRow >= 0) {
     *         sheetObj.SelectRow = dupRow;
     *         ComShowCodeMessage("PRI00302");
     *         return false;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {string}  sCol        필수, 중복검사시 기준이 되는 컬럼의 SaveName. "|"로 연결
     * @param {string}  amdtSeq     필수, 현재 amend sequence.(document.form.amdt_seq.value)
     * @return int <br>
     *         -1   : 중복된 행이 없을 경우
     *         0이상 : 중복된 Row의 Row Index
     * @author 최성민
     * @version 2010.12.20
     */
    function ComPriAmendDupRows(sheetObj, sCol, amdtSeq) {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                return;
            }
            if (sCol == undefined || sCol == null || sCol == "") {
                return;
            }

            var dupRow = sheetObj.ColValueDupRows(sCol, false, true);
            if (dupRow == null || dupRow == "") {
                return -1;
            }
            
            //중복되는 모든ROW
            var rowArr = dupRow.replace("|", ",").split(",");
 			
 			//Amend Delete된 데이터는 제외시킨다.
 			for(var i=0; i<rowArr.length; i++) {
 				if(sheetObj.CellValue(rowArr[i], "amdt_seq") != amdtSeq 
 						|| sheetObj.CellValue(rowArr[i], "src_info_cd") == "AD") {
 					rowArr.splice(i, 1);
 				}
 			}
 			
 			var dupValue = "";
			var tmpValue = "";
 			for(var i=0; i<rowArr.length; i++) {
 				dupValue  = sheetObj.CellValue(rowArr[i], "inlnd_rt_bse_loc_cd")
 				+ sheetObj.CellValue(rowArr[i], "inlnd_rt_bse_loc_zip_cd") 
 				+ sheetObj.CellValue(rowArr[i], "inlnd_rt_term_cd")
 				+ sheetObj.CellValue(rowArr[i], "inlnd_rt_via_loc_cd")
 				+ sheetObj.CellValue(rowArr[i], "prc_inlnd_rt_trsp_mod_cd")
 				+ sheetObj.CellValue(rowArr[i], "inlnd_rt_min_lmt_wgt")
 				+ sheetObj.CellValue(rowArr[i], "inlnd_rt_lmt_wgt")
 				+ sheetObj.CellValue(rowArr[i], "inlnd_rt_lmt_wgt_ut_cd")
 				+ sheetObj.CellValue(rowArr[i], "prc_cgo_tp_cd");
 				
 				for(var j=0; j<rowArr.length; j++) {
 					tmpValue  = sheetObj.CellValue(rowArr[j], "inlnd_rt_bse_loc_cd")
 	 				+ sheetObj.CellValue(rowArr[j], "inlnd_rt_bse_loc_zip_cd") 
 	 				+ sheetObj.CellValue(rowArr[j], "inlnd_rt_term_cd")
 	 				+ sheetObj.CellValue(rowArr[j], "inlnd_rt_via_loc_cd")
 	 				+ sheetObj.CellValue(rowArr[j], "prc_inlnd_rt_trsp_mod_cd")
 	 				+ sheetObj.CellValue(rowArr[j], "inlnd_rt_min_lmt_wgt")
 	 				+ sheetObj.CellValue(rowArr[j], "inlnd_rt_lmt_wgt")
 	 				+ sheetObj.CellValue(rowArr[j], "inlnd_rt_lmt_wgt_ut_cd")
 	 				+ sheetObj.CellValue(rowArr[j], "prc_cgo_tp_cd"); 	 
 					
 					if(i != j) {
 	 					if(dupValue == tmpValue) {
 	 						return rowArr[j];
 	 					}
 	 				}
 				}
 			}

            return -1;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	
	/* 개발자 작업  끝 */