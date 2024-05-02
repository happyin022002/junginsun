/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0927.js
*@FileTitle : B/L Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.07.06 박준용
* 1.0 Creation
===============================================================================
 History
 2010.10.06 이일민 [SRM-201008739] Booking 탭에 B/L Preview 추가 요청
 2010.11.04 전성진 [CHM-201005985] Booking 탭에 B/L Preview 추가 요청, Open시 메시지 제거
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
     * @class ESM_BKG_0927 : ESM_BKG_0927 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0927() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

var rControl = true; // RD Control YN

var iterator = "|$$|";

var IBSENDFAX = "IBSENDFAX";
var IBSENDEMAIL = "IBSENDEMAIL";

var emailYn = true;
var faxYn = true;

var riderYn = "N";
var houseYn = "N";
var oblIssFlg = "N";
var hblTp = "";
var por_cd;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		 var sheetObject = sheetObjects[0];
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
			var Rdviewer_face = rdObjects[0];
			var Rdviewer_rider = rdObjects[1];
			var Rdviewer_houseD = rdObjects[2];
			var Rdviewer_houseS = rdObjects[3];

            switch(srcName) {
            	case "btn_Retrieve": // btn_Retrieve
					Retrive(sheetObject);
                	break;

            	case "btn_New": // btn_New
					ComOpenWait(true);
					pageReset(formObject);
					ComOpenWait(false);
                	break;

            	case "btn_Print": // btn_Print
					RD_Print();
                	break;

            	case "btn_BlPrint": // btn_BlPrint
					//alert("UI_BKG_0743");
					Pop_ESM_BKG_0743(formObject);
                	break;
                	
				case "btn_Close": // btn_Close
					window.close();
                	break;

            	case "btn_Fax": // btn_Fax
					doActionIBSheet(sheetObject,formObject,IBSENDFAX);
                	break;

            	case "btn_Email": // btn_Email
					doActionIBSheet(sheetObject,formObject,IBSENDEMAIL);
                	break;
				
				//---------------- RD Control Button Start ----------------//

            	case "btn_RD_ZoomOut": // btn_RD_ZoomOut
					RDControl(srcName);
                	break;

            	case "btn_RD_ZoomIn": // btn_RD_ZoomIn
					RDControl(srcName);
                	break;

            	case "btn_RD_FirstPage": // btn_RD_FirstPage
					RDControl(srcName);
                	break;

            	case "btn_RD_PreviousPage": // btn_RD_PreviousPage
					RDControl(srcName);
                	break;

            	case "btn_RD_NextPage": // btn_RD_NextPage
					RDControl(srcName);
                	break;

            	case "btn_RD_LastPage": // btn_RD_LastPage
					RDControl(srcName);
                	break;

            	case "rdo_form_level":
            		formObject.form_level.value = window.event.srcElement.value;
            		Retrive(sheetObject);
            		break;
				//---------------- RD Control Button End ----------------//

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			//ComShowMessage(OBJECT_ERROR);
				alert(e.discription);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

	function RDControl(srcName) {
		//
		if (rControl) {
			//
			var formObject = document.form;
			var tabIndex = tabObjects[0].SelectedIndex;
			//alert("tabIndex : [" + tabIndex + "]");

			var Rdviewer = rdObjects[tabIndex];

			var face_obj = rdObjects[0]; // Face RD
			var rider_obj = rdObjects[1]; // Rider RD

			switch(srcName) {
            	case "btn_RD_ZoomOut": // btn_RD_ZoomOut
					//alert("ZoomOut_pre : [" + Rdviewer.ZoomRatio + "]");
					if ( tabIndex == 2 || tabIndex == 3 ) {
						//
						Rdviewer.ZoomIn();
					}
					else {
						//
						face_obj.ZoomIn();
						rider_obj.ZoomIn();
					}
					formObject.RD_Zoom.value = Rdviewer.ZoomRatio;
					//alert("ZoomOut_after : [" + Rdviewer.ZoomRatio + "]");
                	break;

            	case "btn_RD_ZoomIn": // btn_RD_ZoomIn
					//alert("ZoomOut_pre : [" + Rdviewer.ZoomRatio + "]");
					if ( tabIndex == 2 || tabIndex == 3 ) {
						//
						Rdviewer.ZoomOut();
					}
					else {
						//
						face_obj.ZoomOut();
						rider_obj.ZoomOut();
					}
					formObject.RD_Zoom.value = Rdviewer.ZoomRatio;
					//alert("ZoomOut_after : [" + Rdviewer.ZoomRatio + "]");
                	break;

            	case "btn_RD_FirstPage": // btn_RD_FirstPage
					Rdviewer.FirstPage();
                	break;

            	case "btn_RD_PreviousPage": // btn_RD_PreviousPage
					Rdviewer.PrevPage();
                	break;

            	case "btn_RD_NextPage": // btn_RD_NextPage
					Rdviewer.NextPage();
                	break;

            	case "btn_RD_LastPage": // btn_RD_LastPage
					Rdviewer.LastPage();
                	break;

            	case "RD_Zoom": // RD_Zoom
					var obj = eval("document.form." + srcName);
					if ( tabIndex == 2 || tabIndex == 3 ) {
						var zratio = formObject.zratio.value == "" ? Rdviewer.ZoomRatio : formObject.zratio.value;
						//alert("obj.value : [" + obj.value + "]");
						//alert("Rdviewer.AutoAdjust : [" + Rdviewer.AutoAdjust + "]");
						//alert("zratio : [" + zratio + "]");
						Rdviewer.AutoAdjust = 0;
						Rdviewer.ZoomRatio = obj.value.length == 0 ? zratio : obj.value;
					}
					else {
						//
						var zratio = obj.value.length == 0 ? formObject.zratio.value : obj.value;

						//alert("zratio : [" + zratio + "]");
						
						// Face
						face_obj.AutoAdjust = 0;
						face_obj.ZoomRatio = zratio;
						//alert("zratio : [" + zratio + "]\n\n" + "face_obj.ZoomRatio : [" + face_obj.ZoomRatio + "]");
						//Rider
						rider_obj.AutoAdjust = 0;
						rider_obj.ZoomRatio = zratio;
						//alert("zratio : [" + zratio + "]\n\n" + "rider_obj.ZoomRatio : [" + rider_obj.ZoomRatio + "]");
					}

					formObject.zratio.value = formObject.zratio.value.length == 0 ? zratio : formObject.zratio.value;
                	break;

            	case "RD_Zoom_Chk": // RD_Zoom_Chk
					//var zratio = formObject.RD_Zoom.value.length == 0 ? Rdviewer.ZoomRatio : formObject.RD_Zoom.value;
					var zratio = Rdviewer.ZoomRatio;
					//alert("zratio : [" + zratio + "]\n\n" + "tabIndex : [" + tabIndex + "]");
					formObject.RD_Zoom.value = zratio;
                	break;
			}
		}
		else {
			return;
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

    	 for(k=0; k < tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }

		for(i=0;i<sheetObjects.length;i++){

			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);

			//sheetObjects[i].ExtendLastCol = false;
		}

        for(i=0;i<rdObjects.length;i++){
			initRdConfig(rdObjects[i],i+1);
        }

		init_Control();

		Retrive(sheetObjects[0]);
		
		if(!(document.form.strCnt_cd.value == "KR" || document.form.strCnt_cd.value == "VN")){
			ComSetDisplay("btn_Fax1", false);
		}
	
    }

	function init_Control() {
	    //Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm  ('blur', 'obj_blur',  form);  //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_focus',    form);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerForm('keydown',         'obj_keydown', 	form);

		axon_event.addListenerForm('click',         'obj_click', 	form);
	}

	function obj_keydown(){
		var formObject = document.form;
		var obj = event.srcElement;

		var srcName = obj.name;

		if (event.keyCode == 13){ // Enter Key
			//
			switch(srcName){
				case "bkg_no": // bkg_no
					Retrive(sheetObjects[0]);
					break;

				case "bl_no": // bl_no
					Retrive(sheetObjects[0]);
					break;

				case "RD_Zoom": // RD_Zoom
					RDControl(srcName);
					break;
			}
		}
	}

	function obj_click() {
		var formObject = document.form;
		var obj = event.srcElement;

		switch(obj.name){
			case "bl_tp_cd": // bl_tp_cd
				formObject.eventSrc.value = "bl_tp_cd";
				formObject.bl_tp_cd_param.value = obj.value;
				Retrive(sheetObjects[0]);
				break;

			case "hiddenData": // hiddenData
				//alert(obj.name + "\n\n" + obj.value);
				Retrive(sheetObjects[0]);
				break;
			case "cntc_dtl_flg": // cntc_dtl_flg
				//alert(obj.name + "\n\n" + obj.value);
				if(formObject.cntc_dtl_flg.checked == true){
					formObject.cntc_dtl_flg.value = "Y";
				}else{
					formObject.cntc_dtl_flg.value = "N";
				}
				break;	
		}
	}

	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	            break;
	        case "int":
				//숫자 만입력하기
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(obj, ".");
	            break;
	        case "eng":
				//영문만입력하기
				ComKeyOnlyAlphabet();
				break;
	        case "engup":
				//영문대문자로입력하기
				var KeyCodes = "32";
				ComKeyOnlyAlphabet('uppernum', KeyCodes)
	            break;
	        case "engdn":
	            //영문소문자로입력하기
				ComKeyOnlyAlphabet('lower');
	            break;
	    }
	}

	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {

            case "sheet_search":      //sheet_search
				cnt = 0;
                with (sheetObj) {

					// 높이 설정
					style.height = 300;
					//전체 너비 설정
					SheetWidth = 1000;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					var HeadTitle1 = "ibflag|SysCd|TmplMrd|Title|TmplParam|RcvInfo|SndNm|SndEml|Filekey|RcvEml|Contents|Bkg_no|Bl_no|TmplMrdPdf|itr";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,		dtStatus,	30,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"syscd",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"tmplmrd",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"title",				false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"tmplparam",		false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"rcvinfo",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"sndnm",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"sndeml",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"filekey",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"rcveml",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"contents",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"bkg_no",			false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"bl_no",				false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"tmplmrdpdf",		false,	 "",	 dfNone,	0,	false, false, 0, false, false);
					InitDataProperty(0, cnt++ ,		dtData,		100,		daLeft,			false,		"itr",					false,	 "",	 dfNone,	0,	false, false, 0, false, false);

					CountPosition = 0;
               }
                break;
		}
	}

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "B/L Face" , -1 );
                    InsertTab( cnt++ , "Rider" , -1 );
					InsertTab( cnt++ , "NVO H/B (D)" , -1 );
					InsertTab( cnt++ , "NVO HB (S)" , -1 );

					tabObjects[0].TabEnable(0) = true; // Face 탭
					tabObjects[0].TabEnable(1) = true; // Rider 탭
					tabObjects[0].TabEnable(2) = true; // HouseD 탭
					tabObjects[0].TabEnable(3) = true; // HouseS 탭

                }
             		break;

         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

	    	objs[nItem].style.display = "Inline";
	    	objs[beforetab].style.display = "none";

	    	//--------------- 요기가 중요 --------------------------//
	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    	//------------------------------------------------------//
	    	beforetab= nItem;

			//alert("nItem : [" + nItem + "]");
			RDControl("RD_Zoom_Chk");
    }

	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);

		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);

		Rdviewer.HideToolBar();

	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObject,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          case IBSEARCH:      //조회
				formObject.f_cmd.value = SEARCH;
          		ComOpenWait(true);
          		var sXml = sheetObj.GetSearchXml("ESM_BKG_0927GS.do", FormQueryString(formObject));
          		ComOpenWait(false);
          		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F"){
          			sheetObj.LoadSearchXml(sXml);
          		}else{
          			ComOpenWait(true);
    				loadSet(formObject, sXml);
    				ComOpenWait(false);
          		}
                break;

			case IBSENDEMAIL:        // Email
				paramSet(sheetObj, formObject, IBSENDEMAIL);
				break;

			case IBSENDFAX:        // Fax
				paramSet(sheetObj, formObject, IBSENDFAX);
				break;
        }
        
    }

	function paramSet(sheetObj, formObject, strGubun) {
		var Rdviewer_face = rdObjects[0];
		var Rdviewer_rider = rdObjects[1];
		var Rdviewer_houseD = rdObjects[2];
		var Rdviewer_houseS = rdObjects[3];
		var bl_tp_cd = ComGetObjValue(formObject.bl_tp_cd);
		var cntChk = 0;
		var rdParam = "";
		var strPath = "";
		var strPdf = "";
		var bkg_no = rControl == true ? formObject.bkg_no.value : "";
		var form_dataOnly = "N";
		var hiddenData = "";
		var cntcDtl = formObject.cntc_dtl_flg.value;
		
		if ( formObject.hiddenData.checked == true ) {
			hiddenData = formObject.hiddenData.value;
		}

		// 최초 popup 호출 시 - first_bkg_no / first_bl_no 에 따로 저장
		// 파라메터로 넘어온 form_remark의 값을 체크하여 최초의 값과 나중에 입력한 값이 같을 경우 사용 그렇지 않을경우 사용하지 않는다.
		var form_remark = formObject.form_remark.value;
		if ( formObject.first_bkg_no.value != "" ) {
			if ( formObject.first_bkg_no.value != formObject.bkg_no.value ) {
				form_remark = "";
			}
		} else {
			if ( formObject.first_bl_no.value != "" && formObject.first_bl_no.value != formObject.bl_no.value ) {
				form_remark = "";
			}
		}

		form_remark = ComReplaceStr(form_remark, "\r\n", "(##)");
		form_remark = ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(form_remark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");

		// Type : "" - Original / "W" - WayBill / "D" - Draft
		// Face
			if ( formObject.bl_face.checked ) {
			// Face
			switch(bl_tp_cd) {
				case "": // Original
					formObject.form_type.value = "2";
					rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_hiddeData[" + hiddenData + "] form_mainOnly[N] form_level[(" + formObject.form_level.value + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
					rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp [] /riprnmargin";
					strPath = 0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd";
					strPdf = "Original.pdf";
					break;

				case "W": // WayBill
					formObject.form_type.value = "5";
					rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_hiddeData[" + hiddenData + "] form_mainOnly[N] form_level[(" + formObject.form_level.value + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
					rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp [] /riprnmargin";
					strPath = 0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd";
					strPdf = "WayBill.pdf";
					break;

				case "D": // Draft
					formObject.form_type.value = "4";
					rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_hiddeData[" + hiddenData + "] form_mainOnly[N] form_level[(" + formObject.form_level.value + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] form_cntcDtl[" + cntcDtl + "] ";
					rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp [] /riprnmargin";
					strPath = "ESM_BKG_0109_DBL.mrd";
					strPdf = "Draft.pdf";
					break;
			}
			cntChk++; // Face
		}
		// Rider
		if ( riderYn == "Y" && formObject.bl_rider.checked == true ) {
			cntChk++;
		}
		// HouseD
		if ( houseYn == "Y" && formObject.bl_houseD.checked == true ) {
			rdParam += iterator + "/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin";
			if(hblTp == "A")
				strPath += iterator + "ESM_BKG_0109_HBL_D.mrd";
			else
				strPath += iterator + "ESM_BKG_0109_HBL_D2.mrd";
			strPdf += iterator + "HouseD.pdf";
			cntChk++;
		}
		// HouseS
		if ( houseYn == "Y" && formObject.bl_houseS.checked == true ) {
			rdParam += iterator + "/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin";
			strPath += iterator + "ESM_BKG_0109_HBL_S.mrd";
			strPdf += iterator + "HouseS.pdf";
			cntChk++;
		}
		if ( cntChk == 0 ) {
			//alert("Print목록을 선택하세요.");
			ComShowCodeMessage("COM12113", "Print List");
			return;
		}

		var sheetObject = sheetObjects[0];

		if ( strGubun == IBSENDFAX ) {
			// Fax
			formObject.f_cmd.value = SEARCH02;
			// Sheet 사용
			var Row = sheetObject.DataInsert();

			sheetObject.CellValue2(Row, "bkg_no") = formObject.bkg_no.value;
			sheetObject.CellValue2(Row, "bl_no") = formObject.bl_no.value;
			sheetObject.CellValue2(Row, "syscd") = "BKG";
			sheetObject.CellValue2(Row, "tmplmrd") = strPath;
			sheetObject.CellValue2(Row, "batchflg") = "N";
			sheetObject.CellValue2(Row, "tmplparam") = rdParam;
			sheetObject.CellValue2(Row, "rcvinfo") = formObject.fax_no.value;
			sheetObject.CellValue2(Row, "itr") = "|$$|";
		}
		else if ( strGubun == IBSENDEMAIL ) {
			// Email
			formObject.f_cmd.value = SEARCH01;
			// Sheet 사용
			var Row = sheetObject.DataInsert();

			sheetObject.CellValue2(Row, "bkg_no") = formObject.bkg_no.value;
			sheetObject.CellValue2(Row, "bl_no") = formObject.bl_no.value;
			sheetObject.CellValue2(Row, "syscd") = "BKG";
			sheetObject.CellValue2(Row, "tmplmrd") = strPath;
			sheetObject.CellValue2(Row, "batchflg") = "N";
			sheetObject.CellValue2(Row, "tmplparam") = rdParam;
			sheetObject.CellValue2(Row, "title") = "B/L Preview"; // 타이틀
			sheetObject.CellValue2(Row, "contents") = "B/L Preview Contents"; // 메일내용
			sheetObject.CellValue2(Row, "rcveml") = formObject.email.value; // 수신이메일주소
			sheetObject.CellValue2(Row, "tmplmrdpdf") = strPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
			sheetObject.CellValue2(Row, "itr") = "|$$|";
		}
		open0221(strGubun);
	}

	function open0221(fax_email) {
		//open popup 0221
		var width = 360;
		var height = 170;
		var left = (screen.width-width)/2;
		var top = (screen.height-height)/2;
		ComOpenWindow("about:blank","ESM_BKG_0221","width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
		//send popup
		var formObject = document.form;
		var formObject3 = document.form3;
		formObject3.elements["pop_mode"   ].value = "1";
		formObject3.elements["display"    ].value = "1,0,1,1,1,1,1";
		formObject3.elements["func"       ].value = "getCOM_Fax_Email_POPUP";
		formObject3.elements["row"        ].value = "0";
		formObject3.elements["col"        ].value = "0";
		formObject3.elements["sheetIdx"   ].value = "0";
		formObject3.elements["bkg_no"     ].value = formObject.bkg_no.value;
		formObject3.elements["send_hidden"].value = "N";
		formObject3.elements["ok_hidden"  ].value = "Y";
		formObject3.elements["fax_no"     ].value = formObject.fax_no.value;
		formObject3.elements["email"      ].value = formObject.email.value;
		formObject3.elements["ui_id"      ].value = "ESM_BKG_0927";
		formObject3.elements["fax_email"  ].value = fax_email;  //fax/email 구분
		formObject3.elements["ntc_knd_cd" ].value = "W"==ComGetObjValue(formObject.bl_tp_cd) ? "WB" : ("D"==ComGetObjValue(formObject.bl_tp_cd) ? "BL" : "NN");
		formObject3.elements["form_level" ].value = formObject.form_level.value;
		formObject3.elements["form_cntcDtl" ].value = formObject.cntc_dtl_flg.value;
		formObject3.action = "/hanjin/ESM_BKG_0221.do";
		formObject3.target = "ESM_BKG_0221";
		formObject3.submit();
	}

	function FaxEmailSend(sheetObj, formObject, strGubun) {
		if (!sheetObj) {
			sheetObj = sheetObjects[0];
		}
		if (!formObject) {
	        formObject = document.form;
		}

		ComOpenWait(true);
		//var sXml = sheetObj.GetSearchXml("ESM_BKG_0927GS.do", FormQueryString(formObject));
		//sheetObj.GetSaveString();
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0927GS.do", FormQueryString(formObject) + "&" + sheetObj.GetSaveString());
		ComOpenWait(false);

		var strMsg = strGubun == IBSENDFAX ? "Fax" : "Email";

		if(sXml.substring(1, 6) == "ERROR"){
			//
			//alert(ComResultMessage(sXml).split('<||>').join('\n'));
			ComShowCodeMessage("BKG00183", formObject.bkg_no.value);
		}
		else {
			//
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);

			//alert("State : [" + State + "]");

			if ( State == "S" ) {
				ComShowCodeMessage("COM130601", strMsg);
			}
		}
		sheetObj.RemoveAll();
		return;
	}

	function Retrive(sheetObject) {
		var formObject = document.form;
		if ( validateForm(formObject) ) {
			var isMdfyBlNo = ComGetLenByByte(formObject.bl_no)-1 == ComGetObjValue(formObject.bl_no).lastIndexOf("S") ||
                             ComGetLenByByte(formObject.bl_no)-1 == ComGetObjValue(formObject.bl_no).lastIndexOf("W");
			var backupBlNo;
			if (isMdfyBlNo) {
				backupBlNo = ComGetObjValue(formObject.bl_no);
				ComSetObjValue(formObject.bl_no,ComGetObjValue(formObject.bl_no).substr(0,ComGetLenByByte(formObject.bl_no)-1));
			}
			ComOpenWait(true);
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
			sheetObjects[0].RemoveAll()
			ComOpenWait(false);
			if (isMdfyBlNo) {
				ComSetObjValue(formObject.bl_no,backupBlNo);
			}
			btnChk();
		}
	}

	function validateForm(formObject) {
		//

		if ( formObject.bkg_no.value.length == "" && formObject.bl_no.value.length == 0 ) {
//			ComShowCodeMessage("BKG00445");

			if ( formObject.bkg_no.value.length == "" ) {
				formObject.bkg_no.focus();
			}

			return false;
		}

		return true;
	}

	function loadSet(formObject, sXml) {
		search_sheet = sheetObjects[0];
		if(sXml.substring(1, 6) == "ERROR"){
			ComShowCodeMessage("BKG00183", formObject.bkg_no.value);
			for (var i=0; i < formObject.bl_tp_cd.length; i++) {
				formObject.bl_tp_cd[i].checked = false;
				formObject.bl_tp_cd[i].disabled = true;
			}
			// Face
			formObject.bl_face.checked = false;
			formObject.bl_face.disabled = true;
			// Rider
			formObject.bl_rider.checked = false;
			formObject.bl_rider.disabled = true;
			// HouseD
			formObject.bl_houseD.checked = false;
			formObject.bl_houseD.disabled = true;
			// HouseS
			formObject.bl_houseS.checked = false;
			formObject.bl_houseS.disabled = true;
			// Tab
			tabObjects[0].TabEnable(0) = false; // Face 탭
			tabObjects[0].TabEnable(1) = false; // Rider 탭
			tabObjects[0].TabEnable(2) = false; // HouseD 탭
			tabObjects[0].TabEnable(3) = false; // HouseS 탭
			tabObjects[0].SelectedIndex = 0;  // 기본적으로 Face탭을 선택한다.
			initRdConfig(rdObjects[0],1);  // RD 화면 초기화
			rControl = false;
			rdOpen(formObject, "", "N", "N");  // RD 접속
			return;
		} else {
			formObject.fax_no.value = ComGetEtcData(sXml,"fax_no");
			formObject.email.value = ComGetEtcData(sXml,"email");

			// Print
			formObject.bl_face.disabled = false;
			formObject.bl_rider.disabled = false;
			formObject.bl_houseD.disabled = false;
			formObject.bl_houseS.disabled = false;

			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);

			if ( State == "S" ) {
				// 성공 - bkg_no 또는 bl_no 값이 존재 할 경우
				rControl = true;

				// bkg_no / bl_no 값 설정
				formObject.org_bkg_no.value = formObject.bkg_no.value = ComGetEtcData(sXml,"bkg_no");
				formObject.bl_no.value = ComGetEtcData(sXml,"bl_no");

				var bl_tp_cd = formObject.bl_tp_cd_param.value;  //받아온값
				//bl_tp_cd = ComGetEtcData(sXml,"bl_tp_cd");   //DB값

				riderYn = ComGetEtcData(sXml,"rider_yn");
				houseYn = ComGetEtcData(sXml,"houseBl_yn");
				hblTp = ComGetEtcData(sXml,"hbl_tp");
				oblIssFlg = ComGetEtcData(sXml,"obl_iss_flg");
				por_cd = ComGetEtcData(sXml,"por_cd");
				if (""==bl_tp_cd) {
					formObject.bl_tp_cd[0].checked = true;
				} else if ("W"==bl_tp_cd) {
					formObject.bl_tp_cd[1].checked = true;
				} else if ("D"==bl_tp_cd) {
					if ("Y"==oblIssFlg && "bl_tp_cd"!=formObject.eventSrc.value) {
						formObject.bl_tp_cd[0].checked = true;
						bl_tp_cd = "";
					} else {
						formObject.bl_tp_cd[2].checked = true;
						bl_tp_cd = "D";
					}
				}
				if ("onload"==formObject.eventSrc.value) {
					if ("W"==bl_tp_cd) {
						formObject.bl_tp_cd[0].disabled = true;
					} else {
						formObject.bl_tp_cd[1].disabled = true;
					}
				}

				// Print
				formObject.bl_face.checked = true;

				// 탭
				if ( riderYn == "N" ) {  // Rdier 존재 하지 않음 - 체크불가능하게 설정 하고 탭 또한 선택 불가능하게 설정(RD View도 불가능)
					formObject.bl_rider.checked = false;
					formObject.bl_rider.disabled = true;
					tabObjects[0].TabEnable(1) = false; // Rider 탭
				} else {
					formObject.bl_rider.checked = true;
					formObject.bl_rider.disabled = false;
					tabObjects[0].TabEnable(1) = true; // Rider 탭
				}

				if ( houseYn == "N" ) {  // HouseBl 존재 하지 않음 - 체크불가능하게 설정 하고 탭 또한 선택 불가능하게 설정(RD View도 불가능)
					formObject.bl_houseD.checked = false;
					formObject.bl_houseD.disabled = true;
					formObject.bl_houseS.checked = false;
					formObject.bl_houseS.disabled = true;
					tabObjects[0].TabEnable(2) = false; // houseD 탭
					tabObjects[0].TabEnable(3) = false; // houseS 탭
				} else {
					formObject.bl_houseD.checked = true;
					formObject.bl_houseD.disabled = false;
					formObject.bl_houseS.checked = true;
					formObject.bl_houseS.disabled = false;
					tabObjects[0].TabEnable(2) = true; // houseD 탭
					tabObjects[0].TabEnable(3) = true; // houseS 탭
				}
				// 기본적으로 Face탭을 선택한다.
				tabObjects[0].SelectedIndex = 0;
				tabObjects[0].TabEnable(tabObjects[0].SelectedIndex) = true; // Face 탭

				rdOpen(formObject, bl_tp_cd, riderYn, houseYn);
			}
		}
	}

	function rdOpen(formObject, bl_tp_cd, riderYn, houseYn) {
		var Rdviewer_face = rdObjects[0];
		var Rdviewer_rider = rdObjects[1];
		var Rdviewer_houseD = rdObjects[2];
		var Rdviewer_houseS = rdObjects[3];

		var rdParam = "";
		var strPath = "";
		var bkg_no = rControl == true ? formObject.bkg_no.value : "";

		//var form_dataOnly = rControl == true ? "N" : "Y";

		var form_dataOnly = "N";

		var hiddenData = "";

		if ( formObject.hiddenData.checked == true ) {
			hiddenData = formObject.hiddenData.value;
		}

		var form_level = formObject.form_level.value;

		if ( form_level.split(",").length > 0 ) {
			form_level = form_level.split(",")[0];
		}

		// 최초 popup 호출 시 - first_bkg_no / first_bl_no 에 따로 저장
		// 파라메터로 넘어온 form_remark의 값을 체크하여 최초의 값과 나중에 입력한 값이 같을 경우 사용 그렇지 않을경우 사용하지 않는다.
		var form_remark = formObject.form_remark.value;
		if ( formObject.first_bkg_no.value != "" ) {
			if ( formObject.first_bkg_no.value != formObject.bkg_no.value ) {
				form_remark = "";
			}
		}
		else {
			if ( formObject.first_bl_no.value != "" && formObject.first_bl_no.value != formObject.bl_no.value ) {
				form_remark = "";
			}
		}

		form_remark = ComReplaceStr(form_remark, "\r\n", "(##)");
		form_remark = ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(form_remark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");

		// Type
		// "" - Original / "W" - WayBill / "D" - Draft

		// /rv form_bkgNo[( 'JKTZ2148104', 'PHXZ5225101', 'SLCZ9305010' )] form_type[OBL] form_printBlType[ORIGINAL] form_dataOnly[N] form_manifest[N] /riprnmargin
		// /rv form_bkgNo[( ':(BKG_NO)' )]  form_gubun[M] /riprnmargin

		// Face
		switch(bl_tp_cd) {
			case "": // Original
				formObject.form_type.value = "2";
				rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_mainOnly[Y] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp [] /riprnmargin /rwait";
				strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				break;

			case "W": // WayBill
				formObject.form_type.value = "5";
				rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_mainOnly[Y] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] /rp [] /riprnmargin /rwait";
				strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"+(0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd" : "ESM_BKG_0109_OBL_A4.mrd");
				break;

			case "D": // Draft
				formObject.form_type.value = "4";
				rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_type[" + formObject.form_type.value + "] form_dataOnly[" + form_dataOnly + "] form_manifest[" + formObject.manifest.value + "] form_usrId[" + formObject.strUsr_id.value + "] form_mainOnly[Y] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_remark["+ form_remark + "] form_Cntr[" + formObject.form_Cntr.value + "] ";
				rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC] isEncode[Y] /rp [] /riprnmargin /rwait";
				strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_DBL.mrd";
				break;
		}

		Rdviewer_face.SetMessageboxShow(1); //에러메시지만 출력함
		Rdviewer_face.FileOpen(strPath, RDServer + rdParam);
		formObject.zratio.value = Rdviewer_face.ZoomRatio;
		formObject.RD_Zoom.value = Rdviewer_face.ZoomRatio;

		// Rider
		if ( riderYn == "Y" ) {
			rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_hiddeData[" + hiddenData + "] form_level[(" + form_level + ")] form_Cntr[" + formObject.form_Cntr.value + "] ";
			rdParam += "form_CorrNo[] form_his_cntr[BKG_CONTAINER] form_his_bkg[BKG_BOOKING] form_his_mkd[BKG_BL_MK_DESC] form_his_xpt[BKG_XPT_IMP_LIC] form_his_bl[BKG_BL_DOC]  isEncode[Y]/rp [] /riprnmargin /rwait";
			if (bl_tp_cd == "D") {
				strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_DBL_Rider.mrd";
			} else {
				strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_A4_Rider.mrd";
			}
			Rdviewer_rider.SetMessageboxShow(1); //에러메시지만 출력함
			Rdviewer_rider.FileOpen(strPath, RDServer + rdParam);
			tabObjects[0].SelectedIndex = 1;
		}

		// House
		if ( houseYn == "Y" ) {
			// HouseD
			rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait";

			if(hblTp == "A")
				strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D.mrd";
			else
				strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_D2.mrd";

			Rdviewer_houseD.SetMessageboxShow(1); //에러메시지만 출력함
			Rdviewer_houseD.FileOpen(strPath, RDServer + rdParam);

			tabObjects[0].SelectedIndex = 2;

			// HouseS
			rdParam = "/rv form_bkgNo[( '" + bkg_no + "') ] form_CorrNo[] /rp [] /riprnmargin /rwait";
			strPath = RD_path+"apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_HBL_S.mrd";
			Rdviewer_houseS.SetMessageboxShow(1); //에러메시지만 출력함
			Rdviewer_houseS.FileOpen(strPath, RDServer + rdParam);
			tabObjects[0].SelectedIndex = 3;
		}
		tabObjects[0].SelectedIndex = 1;
		tabObjects[0].SelectedIndex = 2;
		tabObjects[0].SelectedIndex = 3;
		tabObjects[0].SelectedIndex = 0;
	}

	function btnChk() {
		var formObject = document.form;
		var bl_tp_cd = "";
		for (var i=0; i < formObject.bl_tp_cd.length; i++) {
			if ( formObject.bl_tp_cd[i].checked == true ) {
				bl_tp_cd = formObject.bl_tp_cd[i].value;
				break;
			}
		}
		// Email / Fax 버튼 (비)활성화 설정
		// WayBill 또는 Draft 일 경우만 활성화
		ComBtnEnable("btn_Fax");
		ComBtnEnable("btn_Email");

		// 이메일 또는 팩스번호 알림창은 최초 팝업 호출 시에만 알린다.
		if ( formObject.email.value == "" || formObject.fax_no.value == "" ) {
			if ( formObject.email.value == "" ) {
				emailYn = false;
			}
		}
	}

	function pageReset(formObject) {
		//
		formObject.reset();

		formObject.bkg_no.value = "";
		formObject.bl_no.value = "";

		// 잘못된 bkg_no가 나올 경우 - 전부 비활성화

		// Type
		for (var i=0; i < formObject.bl_tp_cd.length; i++) {
			//
			formObject.bl_tp_cd[i].checked = false;
			formObject.bl_tp_cd[i].disabled = false;
		}

		// Print
		// Face
		formObject.bl_face.checked = false;
		formObject.bl_face.disabled = false;
		// Rider
		formObject.bl_rider.checked = false;
		formObject.bl_rider.disabled = false;
		// HouseD
		formObject.bl_houseD.checked = false;
		formObject.bl_houseD.disabled = false;
		// HouseS
		formObject.bl_houseS.checked = false;
		formObject.bl_houseS.disabled = false;

		// Tab
		//tabObjects[0].TabEnable(0) = true; // Face 탭
		//tabObjects[0].TabEnable(1) = true; // Rider 탭
		//tabObjects[0].TabEnable(2) = true; // HouseD 탭
		//tabObjects[0].TabEnable(3) = true; // HouseS 탭
		// 기본적으로 Face탭을 선택한다.
		tabObjects[0].SelectedIndex = 0;

		ComBtnEnable("btn_Fax");
		ComBtnEnable("btn_Email");

		rControl = false;

		// RD 접속
		rdOpen(formObject, "", "Y", "Y");
	}

	function RD_Print() {
		var formObject = document.form;
		var cntChk = 0;
		// RD
		var Rdviewer_face = rdObjects[0];
		var Rdviewer_rider = rdObjects[1];
		var Rdviewer_houseD = rdObjects[2];
		var Rdviewer_houseS = rdObjects[3];

		if ("US"==formObject.strCnt_cd.value) {
			Rdviewer_face  .SetPrint2(4,1,1,100);
			Rdviewer_rider .SetPrint2(4,1,1,100);
			Rdviewer_houseD.SetPrint2(4,1,1,100);
			Rdviewer_houseS.SetPrint2(4,1,1,100);
		}

		// 탭이 활성화 되어 있고 Print에 체크되어 있는 RD만 프린트한다.
		// IBTab 활성화 값이 제대로 나오지 않어 체크하지 않고
		// EtcData에서 가져온 값으로 대체하여 체크한다.

		//alert("tabObjects[0].TabEnable(" + tabObjects[0].SelectedIndex + ") : ["+ tabObjects[0].TabEnable(tabObjects[0].SelectedIndex) + "]\n\n" + "formObject.bl_face.checked : [" + formObject.bl_face.checked + "]");
		//alert("beforetab : [" + beforetab + "]");
		//alert("tabObjects[0].TabEnable(0) : [" + tabObjects[0].TabEnable(0) + "]\n\n" + "tabObjects[0].TabEnable(1) : [" + tabObjects[0].TabEnable(1) + "]\n\n" + "tabObjects[0].TabEnable(2) : [" + tabObjects[0].TabEnable(2) + "]\n\n" + "tabObjects[0].TabEnable(3) : [" + tabObjects[0].TabEnable(3) + "]");

		//alert("tabObjects[0].GetCount() : [" + tabObjects[0].GetCount() + "]");

		//alert("riderYn : [" + riderYn + "]\n\n" + "formObject.bl_rider.checked : [" + formObject.bl_rider.checked + "]\n\n" + "houseYn : [" + houseYn + "]\n\n" + "formObject.bl_houseD.checked : [" + formObject.bl_houseD.checked + "]\n\n" + "formObject.bl_houseS.checked : [" + formObject.bl_houseS.checked + "]");
		//return;
		
		// Face
		if ( formObject.bl_face.checked == true ) {
			//alert("Face Print");
			Rdviewer_face.PrintDialog();
			cntChk++;
		}

		// Rider
		if ( riderYn == "Y" && formObject.bl_rider.checked == true ) {
			//alert("Rider Print");
			Rdviewer_rider.PrintDialog();
			cntChk++;
		}

		// HouseD
		if ( houseYn == "Y" && formObject.bl_houseD.checked == true ) {
			//alert("HouseD Print");
			Rdviewer_houseD.PrintDialog();
			cntChk++;
		}

		// HouseS
		if ( houseYn == "Y" && formObject.bl_houseS.checked == true ) {
			//alert("HouseS Print");
			Rdviewer_houseS.PrintDialog();
			cntChk++;
		}
		
	}

	function Pop_ESM_BKG_0743(formObject) {

		var formObject2 = document.form2;

		var hiddenData = formObject.hiddenData.checked == true ? formObject.hiddenData.value : "";
		var width = 530;
		var height = 370;
		var left = (screen.width-width)/2;
		var top = (screen.height-height)/2;

		formObject2.bkg_no.value = formObject.bkg_no.value;
		formObject2.form_manifest.value = formObject.manifest.value;
		formObject2.form_hiddeData.value = hiddenData;
		formObject2.form_remark.value = formObject.form_remark.value;

		//var param = "?bkg_no=" + formObject.bkg_no.value + "&form_manifest=" + formObject.manifest.value + "&form_hiddeData=" + hiddenData + "&form_remark=" + ComReplaceStr(formObject.form_remark.value, "\r\n", "(##)");
		ComOpenWindow("", "PopupEsmBkg0743", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);

		formObject2.action = "/hanjin/ESM_BKG_0743.do";
		formObject2.target = "PopupEsmBkg0743";
		formObject2.submit();
	}

	function unloadPage() {
		if (opener && opener.document && opener.document.tab1 &&
			opener.frames && opener.frames[opener.document.tab1.SelectedIndex] &&
			opener.frames[opener.document.tab1.SelectedIndex].document &&
			opener.frames[opener.document.tab1.SelectedIndex].document.form) {
			var openerForm = opener.frames[opener.document.tab1.SelectedIndex].document.form;
			var sendBkgNo = ComGetObjValue(document.form.org_bkg_no);
			if (openerForm.frm_t10sheet1_bkg_no) {
				openerForm.frm_t10sheet1_bkg_no.value = sendBkgNo;
			} else if (openerForm.frm_t11sheet1_bkg_no) {
				openerForm.frm_t11sheet1_bkg_no.value = sendBkgNo;
			} else if (openerForm.bkg_no) {
				openerForm.bkg_no.value = sendBkgNo;
			}
			opener.runShortcut("retrieve");
		}
	}
	/* 개발자 작업  끝 */