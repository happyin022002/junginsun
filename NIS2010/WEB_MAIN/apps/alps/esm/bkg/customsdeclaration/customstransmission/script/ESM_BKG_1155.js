/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1155.jsp
*@FileTitle : Myanmar Customs Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.09
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.08.10 윤태승
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
 * @class ESM_BKG-1155 : ESM_BKG-1155 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1155() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.tsTpCd_OnChange=tsTpCd_OnChange;
}
/* 개발자 작업 */
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
				case "btn_down_excel":
					
						doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
					
					break;
				
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
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
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * 
      * @param {IBMultiCombo}
      *            combo_obj IBMultiCombo Object
      */
     function setComboObject(combo_obj) {
     	comboObjects[comboCnt++] = combo_obj;
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
                     InsertTab( cnt++ , "B/L Info" , -1 );
                     InsertTab( cnt++ , "CNTR Info" , -1 );
                 }
              break;

          }
     }
      
     /**
      * 콤보 초기설정값
      * 
      * @param {IBMultiCombo}
      * comboObj comboObj
      */
     function initCombo(comboObj) {
         switch(comboObj.id) {
         	case "s_status": 
         		doActionIBSheet(sheetObjects[0],document.form,"setCombo");
         		
                comboObj.Code = "9";
                comboObj.SetColWidth("50|550|0");
                comboObj.DropHeight= 350;
                comboObj.ColBackColor(0) = "#eeeeee";
                break;
                
      	    default:
      	    	comboObj.MultiSelect = false;
      			comboObj.UseCode = true;
      			comboObj.LineColor = "#ffffff";
      			comboObj.SetColAlign("left|left");
      			comboObj.MultiSeparator = "|";
      	    	break;
          }
     }



    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);           
        }
        
		initControl();
    }
  
     /**
      * 조회조건 입력할 때 처리
      */
     function obj_KeyUp() {
    	  var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	  var formObject = document.form;
	     var srcName = window.event.srcElement.getAttribute("name");
	     var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	     var srcValue = window.event.srcElement.getAttribute("value");
	     if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
	     	ComSetNextFocus();
	     }
     }
     
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {int}
	 *            sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		//** Date 구분자 **/
		DATE_SEPARATOR = "-";
  	
		var formObject = document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListenerForm("change", "obj_OnChange", document.form);
		
	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

		var sheetID = sheetObj.id;
				
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

	            	var cnt = 0;
                    // 높이 설정
                    style.height = 340;
                    
                    //전체 너비 설정
                    SheetWidth = 400;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    var HeadTitle1 = "|Sel.|Seq.|VVD|B/L No|CNTR No|TP|FA|RD|LS|B/POR|V/POL|V/POD|V/POD|B/DEL|B/DEL|CNEE|Notify Party|Weight|Weight|Measure|Measure|Package|Package|RF|S.Date|vsl_nm|vsl_callsign|etd|eta|trsm_sts|tpsz_20_chk|tpsz_40_chk|tpsz_tot_chk|pol_gubun|bkg_no";
					var headCount = ComCountHeadTitle(HeadTitle1);					

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ ROW,  COL,    DATATYPE,     WIDTH,    DATAALIGN, COLMERGE, SAVENAME, 	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		 40,	daCenter,	false,	"sel");
					InitDataProperty(0, cnt++ , dtDataSeq,		 30,	daCenter,	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,		     80,	daCenter,	false,	"vvd",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 90,	daCenter,	false,	"bl_no",   	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,	false,	"cntr_no",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 20,	daCenter,	false,	"cntr_tpsz_cd",   	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"sf",  		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 20,	daCenter,	false,	"rd", 	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 20,	daCenter,	false,	"ls",  	false,		"", 	dfNone,		0,			false,		false);	
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"b_por",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"v_pol",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 70,	daCenter,	true,	"v_pod",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"v_pod_cd",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"b_del",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"b_del_cd",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"cnee",		false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"cust_nm",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daRight,	false,	"act_wgt",		false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"wgt_ut_cd",	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,		     60,	daRight,	false,	"meas_qty",		false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"meas_ut_cd",   false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daRight,	false,	"pck_qty",		false,		"", 	dfNumber,	0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	false,	"pck_tp_cd",	false,		"", 	dfNone,		0,			false,		false);
					
					InitDataProperty(0, cnt++ , dtData,			 30,	daCenter,	false,	"rf",   false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			 60,	daCenter,	false,	"s_date",  false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 50,	daCenter,	false,	"vsl_nm",  false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 50,	daCenter,	false,	"vsl_callsign",  false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 50,	daCenter,	false,	"etd",  false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 50,	daCenter,	false,	"eta",  false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"trsm_sts",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"tpsz_20_chk",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"tpsz_40_chk",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"tpsz_tot_chk",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"pol_gubun",  	false,		"", 	dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		 70,	daCenter,	false,	"bkg_no",  	false,		"", 	dfNone,		0,			false,		false);
					
					WaitImageVisible = false;  
					CountPosition = 2;	
					//sheetObj.InitUserFormat(0, "etd", "####-##-##", "-" );dfUserFormat
					//sheetObj.InitUserFormat(0, "eta", "####-##-##", "-" );

            }
               break;



        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case "setCombo": // Status id 콤보값 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1155GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.s_status, "val", "name");
				break;
				
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1155GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				if (document.form.pol_gubun(0).checked)
	 	    	{
					
	 	    		document.form.frm_pol_cd.value = document.form.frm_port_cd.value;
	 	    		document.form.frm_pod_cd.value = "";
	 	    	} else {
	 	    		
	 	    		document.form.frm_pol_cd.value = "";
	 	    		document.form.frm_pod_cd.value = document.form.frm_port_cd.value;
	 	    	}
				
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				//sheetObjects[1].LoadSearchXml(arrXml[1]);
				break;
				
			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.Down2Excel(-1, false, false, true);
				
				break;
					
			case MULTI:        //Transmit
				if( ! validateForm(sheetObj,formObj,sAction)) return;
				var idx = 0;
				for( idx = 0+parseInt(sheetObj.HeaderRows); idx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
					sheetObj.CellValue2(idx,"trsm_sts") = comboObjects[0].Code
					if(sheetObj.CellValue(idx, "sel") == 1) {
						sheetObj.RowStatus(idx)= "U";
					}else{
						sheetObj.RowStatus(idx)= "";
					}
				}
//				for( idx = 0+parseInt(sheetObjects[1].HeaderRows); idx < sheetObjects[1].RowCount+parseInt(sheetObjects[1].HeaderRows); idx++ ){
//					sheetObjects[1].RowStatus(idx)= "U";
//				}
				formObj.f_cmd.value = MULTI;
				ComOpenWait(true); 
				var sParam = "";
				var sParamSheet1 = sheetObjects[0].GetSaveString();
				

				if (sParamSheet1 != "") {
					sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
				}
				
				sParam = sParam + "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1155GS.do", sParam);
				
				var key = ComGetEtcData(sXml, "KEY");

				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

				break;
        }
  	}
        
    /**
     * BackEndJob 실행결과조회.
     */
    function doActionValidationResult(sheetObj, sKey) {

    	var sXml = sheetObj.GetSearchXml("ESM_BKG_1155GS.do?f_cmd=" + SEARCH01 + "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
    	

    	// 에러가 발생했을 경우 대기사항을 종료한다.
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 성공메시지 보여주고
    		ComShowCodeMessage('BKG00101');	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComResultMessage(sXml));
    	}

    }
    

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;
				
			case MULTI:
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;

			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount == 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;	
    	}
        return true;
    }
	    /**
	     * 조회완료후 이벤트
	     */
		function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	    	 
	    	 var tpsz_20_chk_cnt = 0;
	    	 var tpsz_40_chk_cnt = 0;
	    	 var tpsz_tot_chk_cnt = 0;
	    	 var bl_cnt = 1;
	    	 var old_bkg_no = '';
	    	 
	    	 var startRow1 = sheetObj.HeaderRows;
   			 var endRow1 = sheetObj.HeaderRows + sheetObj.RowCount;
   			
   			 for(var j = 0; j <sheetObj.RowCount; j++ ){
   				 if ( j == 0 ){
   					old_bkg_no = sheetObj.CellValue(j,"bkg_no");
   				 }else if ( sheetObj.CellValue(j,"bkg_no") != old_bkg_no ){
   					 ++bl_cnt;
   					old_bkg_no = sheetObj.CellValue(j,"bkg_no");
   				 }
   			 }
   			 
   			 
   			 if ( sheetObj.RowCount > 0){
				document.form.bl_tot_cnt.value = bl_cnt;
		    	document.form.vsl_nm.value = sheetObj.CellValue(2,"vsl_nm");
		    	document.form.vsl_callsign.value = sheetObj.CellValue(2,"vsl_callsign");
		    	document.form.etd.value = sheetObj.CellValue(2,"etd").substring(0,4)+"-"+sheetObj.CellValue(2,"etd").substring(4,6)+"-"+sheetObj.CellValue(2,"etd").substring(6,8);
		    	document.form.eta.value = sheetObj.CellValue(2,"eta").substring(0,4)+"-"+sheetObj.CellValue(2,"eta").substring(4,6)+"-"+sheetObj.CellValue(2,"eta").substring(6,8);
    		}else{
				document.form.bl_tot_cnt.value = "0";
		    	document.form.vsl_nm.value = "";
		    	document.form.vsl_callsign.value = "";
		    	document.form.etd.value = "";
		    	document.form.eta.value = "";
    		}
	
			for(var i = startRow1; i < endRow1; i++) {
			
	 	
	 			if(!ComIsEmpty(sheetObj.CellValue(i,"tpsz_20_chk"))) { tpsz_20_chk_cnt++; }
	 			if(!ComIsEmpty(sheetObj.CellValue(i,"tpsz_40_chk"))) { tpsz_40_chk_cnt++; }
	 			if(!ComIsEmpty(sheetObj.CellValue(i,"tpsz_tot_chk"))) { tpsz_tot_chk_cnt++; }
	 		
	 			
	 		}
			
			document.form.tpsz_20_chk.value = tpsz_20_chk_cnt;
	    	document.form.tpsz_40_chk.value = tpsz_40_chk_cnt;
	    	document.form.tpsz_tot_chk.value = tpsz_tot_chk_cnt;
	    	
	    	if (document.form.pol_gubun(0).checked){
	    	for(var j = startRow1; j < endRow1; j++) {
	    		sheetObj.CellValue2(j,"pol_gubun") = "1";
	    	}
	    	}
	   
	     }
	     

  

     
     
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
    	var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
    }

