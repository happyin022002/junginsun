/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0418.js
*@FileTitle : Cargo Manifest print by B/L No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.10.08 박준용
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
     * @class esm_bkg_bl_test : esm_bkg_bl_test 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_bl_test() {
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

var prefix1 = "sheet1_";
var prefixS = "sheetS_";

var iterator = "|$$|";

var multiSeparator = "|";

var IBPRINT = "IBPRINT";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject = sheetObjects[0];
		 var sheetObjectS = sheetObjects[1];
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_Print": // Print
					doActionIBSheet(sheetObjectS, formObject, IBPRINT);
                	break;
            	case "btn_New": // New
	        		ComClearObject(formObject.elements["mode"]);
	        		ComClearObject(formObject.elements["vvd_cd"]);
	        		ComClearObject(formObject.elements["port_cd"]);
        			initSheet(sheetObject,1);
        			initSheet(sheetObjectS,2);
            		break;

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
            ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		init_Control();
	
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

			case "sheet1":
				with (sheetObj) {

					// 높이 설정
					style.height = 340;
					//전체 너비 설정
					SheetWidth = sheetMainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					var HeadTitle1 = " |B/L No. or BKG No.";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++ , dtHiddenStatus,80,daLeft,true,	prefix1 + "ibflag", false, "", dfNone, 0, true,	true, 13);
					//InitDataProperty(0, cnt++ , dtStatus,80,daLeft,true,	prefix1 + "ibflag", false, "", dfNone, 0, true,	true, 13);
					InitDataProperty(0, cnt++ , dtData,80,daLeft,true,	prefix1 + "bl_no", false, "", dfEngUpKey, 0, true,	true, 13);

					CountPosition = 0;

				}
				var formObject = document.form;

				// row 50개 생성 후 
				// input_bl_no.value 값을 초기 Row에 설정 후
				// 타이틀 제거

				for (var i=1; i<=50; i++) {
					//
					sheetObj.DataInsert(-1);
					sheetObj.CellValue(i, prefix1 + "ibflag") = "R";
				}

				sheetObj.SelectCell(sheetObj.HeaderRows, prefix1 + "bl_no");

				//sheetObj.CellValue(1, prefix1 + "bl_no") = formObject.input_bl_no.value;
				//sheetObj.SelectCell(1, prefix1 + "bl_no");

				//sheetObj.RowHidden(0) = true;

				break;

            case "sheet_search":      //sheet_search
				cnt = 0;
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

					var HeadTitle2 = "ibflag";
					var headCount = ComCountHeadTitle(HeadTitle2);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,		dtStatus,		30,		daCenter,		false,		prefixS + "ibflag");

					CountPosition = 0;
               }
                break;
		}
	}

	function init_Control() {
	    //Axon 이벤트 처리1. 이벤트catch
	    //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form, "rdoCity"); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerForm  ('blur', 'obj_blur',  form);  //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_focus',    form);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerForm('keydown',         'obj_keydown', 	form);
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

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObject,sAction) {

        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

          case IBPRINT:      //조회

				if ( validateForm(sheetObjects[0], formObject, sAction) ) {
					formObject.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0418GS.do", FormQueryString(formObject) + "&" + sheetObjects[0].GetSaveString() + "&" + ComGetPrefixParam(prefix1));

					if(sXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(sXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(sXml));
					} else {

						var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);

						if ( State == "S" ) {
							var rVesselSkd = "";
							var rVvd = "";
							var rBkgBlNo = "";
							var rBkgNos = "";
							var error_index = 0;

							rVesselSkd = ComGetEtcData(sXml,"bVesselSkd");
							rVvd = ComGetEtcData(sXml,"bVvd");
							rBkgBlNo = ComGetEtcData(sXml,"bBkgBlNo");
							rBkgNos = ComGetEtcData(sXml,"bkgNos");

							if ( rVesselSkd != "" ) {
								ComShowCodeMessage(rVesselSkd);
							} else if ( rVvd != "" ) {
								ComShowCodeMessage(rVvd);
							} else if ( rBkgBlNo != "" ) {
								ComShowCodeMessage(rBkgBlNo);
								// Error idx
								if ( rBkgNos.split("_").length == 2 ) {
									error_index = rBkgNos.split("_")[1];
									sheetObjects[0].SelectCell(eval(error_index) + 1, prefix1 + "bl_no");
								}
							} else {
								var param = "?bkg_no="+rBkgNos
								       +"&mode_type="+ComGetObjValue(formObject.mode)
								       +"&vvd_cd="+ComGetObjValue(formObject.vvd_cd)
								       +("I"==ComGetObjValue(formObject.mode) ? "&pol_cd=&pod_cd=" : "&pod_cd=&pol_cd=")+ComGetObjValue(formObject.port_cd);
								ComOpenPopup("/hanjin/ESM_BKG_0064.do"+param, 300, 200, "", "1,0,1,1,1,1,1,1,1,1", false,false, 0, 0, 0,"print_option");
								/*
								var param = FormQueryString(formObject) + "&bkg_no=" + rBkgNos;
								var pUrl = "/hanjin/ESM_BKG_0064.do?" + param;
								//alert("pUrl : [" + pUrl + "]");
								//ComOpenWindow(pUrl, "PopupEsmBkg0064", "width=530, height=340, scrollbars=no", false);
								ComOpenWindow(pUrl, "PopupEsmBkg0064", "dialogWidth:306px; dialogHeight:259px", true);
								*/
							}
						}

					}
				}

                break;

			case IBSAVE:        //저장
          		if(validateForm(sheetObj,formObject,sAction))

                  alert (" Save .. ");

				break;

			case IBINSERT:      // 입력

                break;

			case IBDOWNEXCEL:      // 엑셀다운로드
				sheetObj.SpeedDown2Excel(-1);
			break;
        }
        
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObject,sAction){
		//

		with(formObject){
			// vvd
			if ( vvd_cd.value.trimAll().length == 0 || vvd_cd.value.trimAll().length != 9 ) {
				ComShowCodeMessage("BKG00115");

				vvd_cd.focus();

				return false;
			}
			else {
				// form_vslCd- vvd_cd(1~4)
				// form_voyNo- vvd_cd(5~8)
				// form_dirCd- vvd_cd(9)
				
				var vvd = vvd_cd.value.trimAll();
				form_vslCd.value = vvd.substring(0, 4);
				form_voyNo.value = vvd.substring(4, 8);
				form_dirCd.value = vvd.substring(8, 9);

				//alert("vvd : [" + vvd + "]\n\n" + "vslCd : [" + vslCd + "]\n\n" + "voyNo : [" + voyNo + "]\n\n" + "dirCd : [" + dirCd + "]");
			}

			// Port
			if ( port_cd.value.trimAll().length == 0 || port_cd.value.trimAll().length != 5 ) {
				ComShowCodeMessage("BKG00424");

				port_cd.focus();

				return false;
			}

			var blNos = "";

			// B/L No BKG No
			for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++ ) {
				//
				if ( sheetObj.CellValue(i, prefix1 + "bl_no") != "" ) {
					//
					blNos += sheetObj.CellValue(i, prefix1 + "bl_no") + multiSeparator;
				}
			} // end of for

			if (blNos != "") {
				blNos = blNos.substring(0, eval(blNos.lengthByte()) - 1);
			}
			else {
				ComShowCodeMessage("BKG00425");

				sheetObj.SelectCell(sheetObj.HeaderRows, prefix1 + "bl_no");

				return false;
			}

			return true;

		}
	}

	/* 개발자 작업  끝 */