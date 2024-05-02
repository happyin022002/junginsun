/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0724.js
*@FileTitle : Roll Over Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.14 최영희
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
     * @class ESM_BKG_0724 : ESM_BKG_0724 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0724() {
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
var prefix1="sheet1_";
var sheetObjects = new Array();
var sheetCnt = 0;
var rdObjects = new Array();
var rdCnt = 0;
var asCodeList = "";
var asTextList = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var rdObject = rdObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

					case "btn_save": 
						 
						if (ComGetObjValue(formObject.modifyFlag)!="Y"){
							return false;
					    }
						/*if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix1+"roll_ovr_rsn_cd")==""){
							ComShowCodeMessage("BKG00107"); 
							return false;
						}*/
						 
						if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix1+"newdate").substring(0,9)==sheetObjects[0].CellValue(sheetObjects[0].SelectRow,prefix1+"predate").substring(0,9)){
							ComShowCodeMessage("BKG00152");
							return false;
						}
						doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
						ComSetObjValue(formObject.modifyFlag,"N");
						break;
						
					case "btn_print":
						param=RdParam(sheetObjects[0],formObject);
					    rdOpen(rdObjects[0], formObject,param);
						break;
						
					case "btn_close":
						 
						if (ComGetObjValue(formObject.modifyFlag)=="Y"){
						    if (ComShowConfirm(ComGetMsg("BKG00168"))){
								window.close();
						    } 
						}else{
							window.close();
						}
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
    function loadPage(asCode,asText) {
        asCodeList = " |"+asCode;
		asTextList = " |"+asText;
		 
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1,asCodeList,asTextList);
			ComEndConfigSheet(sheetObjects[i]);
		}
		 
		initRdConfig(rdObjects[0]); 
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	}

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
	function sheet1_OnLoadFinish(sheetObj) {   
		sheetObj.WaitImageVisible = false;  
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
		sheetObj.WaitImageVisible = true;   
	} 


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo,asCodeList,asTextList) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 200;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle1 = " |||Now|Previous|Reason of Roll Over|Reason of Roll Over|Reason of Roll Over|Remark(s)|roll_ovr_seq";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix1+"upd_usr_nm",			false,		"",      dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix1+"title",				false,		"",      dfEngUpKey,	0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			180,	daCenter,	true,		prefix1+"newdate",				false,		"",      dfEngUpKey,	0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			180,	daCenter,	true,		prefix1+"predate",				false,		"",      dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		150,	daCenter,	true,		prefix1+"roll_ovr_rsn_cd",		false,		"",      dfNone,		0,		true,	true);
																																	   
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		prefix1+"upd_usr_id",			false,		"",      dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix1+"evnt_dt",					false,		"",      dfNone,	0,	    false,	false);
					InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	false,		prefix1+"diff_rmk",				false,		"",      dfEngUpKey,	0,		true,	true);
					InitDataProperty(0, cnt++ , dtHidden,		  0,	daCenter,	false,		prefix1+"roll_ovr_seq",			false,		"",      dfNone,		0,		false,	false);
					
					InitDataCombo(0,  prefix1+"roll_ovr_rsn_cd",  asTextList,asCodeList);
					CountPosition = 0;
               }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix = new Array("sheet1_");
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH; 
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0724GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			sheetObj.Redraw = false; 
			sheetObj.LoadSearchXml(sXml); 
			sheetObj.Redraw = true;  
			setFormData(formObj,sheetObj);
			ComClearObject(formObj.modifyFlag);
          break;

		  case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI;  
			var sParam = ComSetPrifix(sheetObjects[0].GetSaveString(true)); 
			if (sParam == "") return;  
			sParam += "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0724GS.do", sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			sheetObj.LoadSaveXml(sXml);     
			
			if(State == "S"){
				ComClearObject(formObj.modifyFlag);
			}
		  break; 
        }
        
    }

	
	/*
	* Data를 Form에 대입
	*/
	function setFormData(formObj,sheetObj){
		//ComSetObjValue(formObj.bkg_no,sheetObj.EtcData("bkg_no"));
		ComSetObjValue(formObj.bl_no,sheetObj.EtcData("bl_no"));
		ComSetObjValue(formObj.vvd,sheetObj.EtcData("vvd"));
		ComSetObjValue(formObj.pol,sheetObj.EtcData("pol"));
		ComSetObjValue(formObj.etb,sheetObj.EtcData("etb"));
		ComSetObjValue(formObj.etd,sheetObj.EtcData("etd"));

		for(var iRow=1;iRow<sheetObj.Rows;iRow++){
			sheetObj.CellValue2(iRow,prefix1+"title")="VVD/ETA";
			sheetObj.CellValue2(iRow,prefix1+"ibflag")="R";
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }
	
	/*
	* 시트 셀의 OnChange이벤트 처리
	*/
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		if (sName==prefix1+"diff_rmk" || sName==prefix1+"roll_ovr_rsn_cd"){
			ComSetObjValue(formObj.modifyFlag,"Y");
		}
	}
	
	/*
	* 시트의 OnMouseMove 이벤트 처리
	*/
	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){
		var col  = sheetObj.MouseCol;
        var row  = sheetObj.MouseRow;
        var sName   = sheetObj.ColSaveName(col);
		if (sName==prefix1+"upd_usr_id"){
			sheetObj.MouseToolTipText = sheetObj.CellValue(row,prefix1+"upd_usr_nm" );
		}else{
			sheetObj.MouseToolTipText = "";
		}
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		 sheetObj.CellFontUnderline(1,	"upd_usr_id") = true;
	}

	/*
	*Rd 설정
	*/
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	/*
	* Rd 파라함수
	*/
	function RdParam(sheetObject,formObj) { 
		var strResult = ""; 
		var strParam="";
		strParam ="'"+ComGetObjValue(formObj.bkg_no)+"'";

		strResult= rdParamSet(strParam);	
		return strResult; 
	}

	/*
	* Rd 오픈
	*/
	function rdOpen(rdObject, formObject, param){
		var Rdviewer = rdObject;
		var rdParam = "/rv " + "BKG_NO['"+ComGetObjValue(formObject.bkg_no)+"']" + " /riprnmargin /rwait";
		 
		// 열고자 하는 RD 파일을 지정한다.
		var strPath = RD_path+"apps/alps/esm/bkg/bookingconduct/generalbookingconduct/generalbookingsearch/report/ESM_BKG_0816.mrd";
//		alert(rdParam + "\n\n" + strPath);
 
		Rdviewer.FileOpen(strPath, RDServer + rdParam);  
		Rdviewer.CMPrint();		
	}
	/* 개발자 작업  끝 */