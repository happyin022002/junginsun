/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0049.js
*@FileTitle : Inquiry by Customized Condition
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.25
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.08.25 김종준
* 1.0 Creation
* 
* 2015.07.06[CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결)
* 2015.07.15 MAS 연동 로직 보완 요청
=========================================================
* History
* 2011.08.25 김종준 [CHM-201113071] control by HO/RHQ 화면과 COA 링크 팝업 추가
* 2011.09.14 이행지 [CHM-201113449-01] COA 링크 화면 보완
* SPC기능보완요청 - COA pop 및 가이드 존재시 Alloc셀 활성화
* 2014.07.04 Arie Im [CHM-201431038] SPC기능보완요청 - COA pop 및 가이드 존재시 Alloc셀 활성화
* 2015.07.15 [CHM-201537094]MAS CMB 산출 로직 변경 적용에 묶어서 처리 - 팝업 더블클릭시 수행되도록 수정
* 2015.08.11 ESM_COA_0057GS -> ESM_MAS_0057GS
=========================================================
*/
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
     * @class ESM_SPC_0049 : ESM_SPC_0049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0049() {
    	this.processButtonClick		= processButtonClick;
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
	var comboObjects = new Array();
	var comboCnt = 0;
	loadingMode = false;
	
	var formObj = document.form;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	function processButtonClick(){
		var sheetObj = sheetObjects[0];
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
					break;
				case "btn_downexcel":
        	        doActionIBSheet(sheetObj, document.form, IBDOWNEXCEL);
        	        break;
				case "btn_close":
					close();
					break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * 설  명 :  Sheet 기본 설정 및 초기화 <br>
	 *          body 태그의 onLoad 이벤트핸들러 구현<br>
	 *          화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function loadPage(title, col_nm) {
		loadingMode = true;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1, title, col_nm);
			ComEndConfigSheet(sheetObjects[i]);
		}
		sheetObjects[0].Redraw = false;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);           
		}		
		
		doActionIBSheet(sheetObjects[0],document.form,IBRESET);
		/*
		doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH);	// 12.03.13 SHKIM
		var locFProVw = document.form.f_pro_vw.Code ;
		// [S] 12.03.13 SHKIM
		if(locFProVw==null || locFProVw==""){
			document.form.f_pro_vw.Code2  = 'P'; // 기본값 세팅 
		}
		// [E] 12.03.13 SHKIM
		*/	
		sheetObjects[0].Redraw = true;
		loadingMode = false;

		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
	/**
	 * 설  명 : IBSheet Object를 배열로 등록 <br>
	 *         향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
	 *         배열은 소스 상단에 정의<br>
	 * <b>Example : </b>
	 * <pre>
	 *    setComboObject(sheet_obj)
	 *    </pre>
	 * @param {object}	sheet_obj - Sheet Object
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	
	
    /**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
	
	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo, title, col_nm) {
        var cnt = 0;
        var colCnt = 0;
        var varCnt = 0;
        var colTotNum = 0;
        var aryTitle = new Array();
        var t1 = "";
        var colWidth = 0;
        var colWidth1 = 0;
        var formObj = document.form;
        var colTmp = 0;

        if(title != ""){
            var tNM = title.split("|");
            var tCnt = tNM.length;
            for(var j=0; j<tCnt ; j++) {
                t1 = t1+ tNM[j] + "|";
            }
        }
        aryTitle = col_nm.split("|");
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    if(t1 != "") colCnt = aryTitle.length;
                    colTotNum = colCnt + 22 + varCnt+2 ;
                    colTotNum = colTotNum + colTmp
                    SheetWidth = mainTable.clientWidth;             //전체 너비 설정
                    colWidth1 = 78;
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                      //전체Merge 종류 [선택, Default msNone]
                    Editable = false;                               //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 50);                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    //MassOfSearch = 1;                               //대량데이타조회시
                    InitColumnInfo(colTotNum, 0, 0, true);          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(true, true, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

                    var HeadTitle =t1  ;
                    HeadTitle =  "BKG NO|STS|SC NO|RFA NO|C.CUST NM|BKG SHPR NM|WEIGHT|VGM|"+HeadTitle+"TP/SZ|LOAD|REV|DEM/DET|CM COST|CM|OP COST|BKG OP|RPB(TEU)||CM CPB(TEU)|CMB(TEU)|Estimated\nCMPB\n(RA CMPB)||OP CPB(TEU)|OPB(TEU)" ;
                    InitHeadRow(0, HeadTitle, true);                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,     90,         daCenter, true,  "bkg_no",   false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     30,         daCenter, true,  "aloc_sts_cd",   false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,         daCenter, true,  "sc_no",   false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     80,         daCenter, true,  "rfa_no",   false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     100,         daLeft, true,  "cust_nm",   false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     100,         daLeft, true,  "bkg_shpr_nm",   false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtData,     65,         daRight, true,  "bkg_cgo_wgt",   false,  "", dfFloatOrg,      2,  false,  false,    6);
                    InitDataProperty(0, cnt++ , dtData,     65,         daRight, true,  "vgm_wgt",   false,  "", dfFloatOrg,      2,  false,  false,    6);
                    //동적 레이아웃 시작
                    for(var j=0; j<colCnt ; j++) {
                        if (aryTitle[j] == "CMDT_DESC" ||aryTitle[j] == "SC_DESC"||aryTitle[j] == "SHPR_CNT_CD" ){
                             InitDataProperty(0, cnt++ , dtData,  190,    daLeft,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        } else if ( aryTitle[j] == "BL_NO" || aryTitle[j] == "REP_CMDT_DESC" || aryTitle[j] == "SC_CUST_NM" || aryTitle[j] == "SHPR_NM" || aryTitle[j] == "CNEE_NM" || aryTitle[j] == "NTFY_NM"){
                           InitDataProperty(0, cnt++ , dtData,  colWidth1,    daLeft,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        } else if (aryTitle[j] == "MST_RFA_ROUT_ID"){
                            InitDataProperty(0, cnt++ , dtData,  130,    daCenter,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        } else {
                           InitDataProperty(0, cnt++ , dtData,  colWidth1,    daCenter,   true, aryTitle[j],  false,  "",  dfNone,  0, false, false,    6);
                        }
                    }                    
                    InitDataProperty(0, cnt++ , dtData,     40,         daCenter, true,  "tpsz_code",  false,  "", dfNone,      0,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  50,  daRight,  true,  "load",       false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "rev",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "dmdt",       false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmc",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm",         false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opc",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op",         false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "g_rpb",      false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm_cost",    false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmcost",     false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmb",        false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoAvg,  colWidth1,  daRight,  true,  "b_cmpb",     false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op_cost",    false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opcost",     false,  "", dfFloatOrg,  2,  false,  false);
                    InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opb",        false,  "", dfFloatOrg,  2,  false,  false);

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(17) ;
                    // Profit Level에 따라서 컬럼을 보여준다
                    //------------------------------------
                    ColHidden("cm_cost") = true;
                    ColHidden("op_cost") = true;
                    changeViewColumn();

                }
                break;
        }
    }
    
	/**
	 * 설  명 : Sheet관련 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     doActionIBSheet(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;	
		
		switch(sAction) {
			case IBSEARCH:		// Loading시 조회
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				} else {
					formObj.f_cmd.value = SEARCHLIST01;					
	                var xml = sheetObj.GetSearchXml("ESM_SPC_0049GS.do", FormQueryString(formObj));
	                sheetObj.LoadSearchXml4Sax(xml, false, -1, false);					
				}
				
				break;
			case IBCLEAR:          //조회
				formObj.f_cmd.value = IBCLEAR;
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0049GS.do" , FormQueryString(form));
				var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
	            var arrXml = sXml.split("|$$|");    
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");

				var slctItmFomCd = ComGetEtcData(sXml,"slctItmFomCd").split("|");
				var slctItmFomNm = ComGetEtcData(sXml,"slctItmFomNm").split("|");

    			//멀티콤보초기화
    			with (form.f_selgroup) {
    				InsertItem(0 , '','');
    				for ( var i=1; i<=slctItmFomCd.length; i++) {
    					
    					InsertItem(i, slctItmFomNm[i-1], slctItmFomCd[i-1]);
    				}
    			}          
    			formObj.f_selgroup.Index = 0;
    			break;
    			
			case IBROWSEARCH:   
				// COA 공통 코드 조회를 위해 독립적 프로세스 구성		
    			//var sXml1 = sheetObj.GetSearchXml("ESM_COA_0061GS.do", FormQueryString(form));
    			var sXml1 = sheetObj.GetSearchXml("ESM_MAS_0057GS.do", FormQueryString(form));
				var arrXml = sXml1.split("|$$|");
    			if (arrXml.length > 0)
    			if (arrXml.length > 1){
					ComXml2ComboItem(arrXml[1], formObj.f_pro_vw, "code", "name");
    			}
    			
				break;
            case IBRESET:          //Header 정보를 조회한다.
	            formObj.f_cmd.value = SEARCH01;
	            sheetObj.DoSearch4Post("ESM_SPC_0049GS3.do", FormQueryString(formObj));
	            formObj.f_header.value   = sheetObj.EtcData("header");
	            formObj.f_headernm.value = sheetObj.EtcData("headerNM");
	            sheetObj.RemoveEtcData();
	            chkChgInitSheet();
	            initHeader(sheetObj, formObj);
	
	            break;	
            case IBDOWNEXCEL:        //엑셀 다운로드
	            sheetObj.Down2Excel(-1, false, false, true);
	            break;
		}

		return true;
	}
	/**
	 * 설  명 : 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     validateForm(sheetObj,formObj,sAction)
	 * </pre>
	 * @param {object}	sheetObj - Sheet Object
	 * @param {form}	formObj  - From Object
	 * @param {String}	sAction  - 프로세스 종류 
	 * @see #링크연결
	 * @author 작성자
	 * @version 2009.01.01
	 */
	function validateForm(sheetObj, formObj, sAction){
		switch(sAction){
			case IBSEARCH:
				break;
		}
		return true;
	}

    /**
     * 조회후 Total 항목중 재계산해야 하는 항목 계산.
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	var formObj = document.form;

        if(eval(sheetObj.SumValue(0, "load")) > 0){

        	sheetObj.SumValue(0, "g_rpb")  = eval(sheetObj.SumValue(0, "rev")       + "/" + sheetObj.SumValue(0, "load")).toFixed(2);

            sheetObj.SumValue(0, "cmcost") = eval(sheetObj.SumValue(0, "cm_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
            sheetObj.SumValue(0, "opcost") = eval(sheetObj.SumValue(0, "op_cost")   + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
            sheetObj.SumValue(0, "cmb")    = eval(sheetObj.SumValue(0, "cm")        + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
            sheetObj.SumValue(0, "opb")    = eval(sheetObj.SumValue(0, "op")        + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
        } else {
            sheetObj.SumValue(0, "g_rpb")  = "0";
            sheetObj.SumValue(0, "cmcost") = "0";
            sheetObj.SumValue(0, "opcost") = "0";
            sheetObj.SumValue(0, "cmb")    = "0";
            sheetObj.SumValue(0, "opb")    = "0";
        }
    }
     
     /**
     * f_selgroup 변경시 sheet의 Header정보를 변경
     */
    function f_selgroup_OnChange(obj, code){
    	 if (loadingMode == true) return;
    	 chgHeader();
    	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
    /**
     * Group combo 변경시 sheet의 Header정보를 변경시킨다.
     */
    function chgHeader(){
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        doActionIBSheet(sheetObj,formObj,IBRESET);
    }
     /**
 	 * Profit View 변경시  컬럼을변경
 	 */
 	function f_pro_vw_OnChange() {
 		var sheetObj = sheetObjects[0];
 		var formObj = document.form;
 		
 		changeViewColumn();
 		
 		// Profit View 변경시 조회된 내역 초기화 및 재조회
 		if (getIbComboObjValue(formObj.f_pro_vw) == "R") {
 			sheetObj.CellValue(0, "cm") = "BKG CM";
 			sheetObj.RemoveAll();
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 		} else {
 			sheetObj.CellValue(0, "cm") = "CM";
 			sheetObj.RemoveAll();
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 		}
 	} 
	 /**
	 * Profit Level에 따라서 컬럼을 보여준다
	 */
	function changeViewColumn() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		if (getIbComboObjValue(formObj.f_pro_lvl) != "") { 
			if (getIbComboObjValue(formObj.f_pro_lvl) == "O" && getIbComboObjValue(formObj.f_pro_vw) == "R") {
				sheetObj.ColHidden("opc") = true;
				sheetObj.ColHidden("op") = true;
				sheetObj.ColHidden("opcost") = true;
				sheetObj.ColHidden("opb") = true;
			} else {
				sheetObj.ColHidden("opc") = true;
				sheetObj.ColHidden("op") = true;
				sheetObj.ColHidden("opcost") = true;
				sheetObj.ColHidden("opb") = true;
			}

			if (getIbComboObjValue(formObj.f_pro_vw) == "R") {
				sheetObj.CellValue(0, "cm") = "BKG CM";
			} else {
				sheetObj.CellValue(0, "cm") = "CM";
			}
		}
	}     
	
	function getIbComboObjValue(obj){
		if (ComGetObjValue(obj) == "All" ){
	  		return "";
	  	}
	  	return ComGetObjValue(obj);
	}

    /**
    * Popup이 닫힌 후 group combo를 변경 시킨다.
    */
   function chgGroup(param){
    	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    	document.form.f_selgroup.Index = eval(param);
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }    
   
   /**
    * 59번 화면이 닫희면서 sheet의 header목록을 변경위해서 sheet를 초기화한다..
    */
   function chgInitSheet(){
       var sheetObj = sheetObjects[0];
       var formObj = document.form;
       initHeader(sheetObj, formObj);
   }
    
    /**
     * header목록중 BKG_NO|SC_NO|RFA_NO|SC_CUST_NM|BKG_SHPR_NM|BKG_CGO_WGT|VGM_WGT 부분은 초기값에서 제외한다.
     */
    function chkChgInitSheet(){
        var formObj = document.form;
        var headernm = "";
        var header = "";
        var f_headernm = formObj.f_headernm.value;
        var f_header = formObj.f_header.value;
        var str_f_headernm = f_headernm.split("|"); 
        var str_f_header = f_header.split("|"); 
        if ( str_f_headernm.length > 0 ) {
	        for ( var i=0; i<str_f_headernm.length; i++ ) {
	        	if ( str_f_headernm[i] == "BKG_NO"
	        		|| str_f_headernm[i] == "SC_NO"
	           		|| str_f_headernm[i] == "RFA_NO"
	           		|| str_f_headernm[i] == "SC_CUST_NM"
	           		|| str_f_headernm[i] == "BKG_SHPR_NM"
	        		|| str_f_headernm[i] == "BKG_CGO_WGT"
		        	|| str_f_headernm[i] == "VGM_WGT") {
	        		continue;
	        	} 
        		headernm = headernm + str_f_headernm[i] + "|";
         	   	header = header + str_f_header[i] + "|";
	        }
	        headernm = headernm.substring(0,headernm.length-1);
	        header = header.substring(0,header.length-1);
        }
        formObj.f_headernm.value = headernm;
        formObj.f_header.value = header;
    }
    
   /**
    * sheet를 초기화 시킨다.
    */
   function initHeader(sheetObj, formObj){
     // Header 정보를 변경하기 위해 sheet를 초기화 한다.
     //--------------------------------------------------
     // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
     sheetObj.Redraw = false;
     sheetObj.RemoveAll();
     sheetObj.Reset();
     initSheet(sheetObj, 1, formObj.f_header.value, formObj.f_headernm.value);
     sheetObj.Redraw = true;
     //--------------------------------------------------
   }
   
   
   /**
    * 멀티콤보 항목을 설정한다.
    */
   function initCombo(comboObj, comboId) {
       with (comboObj) {
		   if (comboId ==  "f_cntr_tpsz_cd") {    // Type/Size
		       	MultiSelect = true;
		       	MultiSeparator = ",";
		        ValidChar(2, 1);
	       } else if (comboId ==  "f_selgroup") {
	           ValidChar(2, 1);
	       } 
           IMEMode = 0;
           DropHeight = 200;
           Index = 0;
       }
   }
   
   /**
    * Type/Size 콤보를 클릭할 때 전체체크
    * @param comboObj
    * @param index
    * @param code
    * @return
    */
   function f_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
   	if (code == "" || code == "All") {
   		var bChk = comboObj.CheckIndex(index);
   		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
   			comboObj.CheckIndex(i) = bChk;
       	}
      }else{
      	comboObj.CheckIndex(0) = false;
      }
   }

   /**
    * Type per TEU/ Type per Box 에 따라서 header정보를 변경시켜준다.
    */
   function changeType(){
       var sheetObj = sheetObjects[0];
       var formObj = document.form;
       initHeader(sheetObj, formObj);
   }
   
	/**
    * 시트를 클릭했을 때 처리
    */
	function sheet1_OnDblClick(sheetObj, row, col) {	
		var colSaveName = sheetObj.ColSaveName(col);
		switch(colSaveName) {
			case "b_cmpb" :
				//cmpb 팝업 오픈
				var sUrl = "/hanjin/ESM_SPC_0122.do";
				var param = '?bkg_no=' + sheetObj.CellValue(row, "bkg_no");
				window.open(sUrl+param, "BKGCmpb", "height=340px,width=500px,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
			break;
			case "bkg_no" :
				ComOpenWindowCenter("/hanjin/ESM_BKG_0079_Q.do?" +
						"bkg_no="+ sheetObj.CellValue(row, "bkg_no") + "&" +
						"pop_mode=1"
						,"ESM_BKG_0079_Q", 1005, 680);
			break;
				
		}
	}
   
	/* 개발자 작업  끝 */