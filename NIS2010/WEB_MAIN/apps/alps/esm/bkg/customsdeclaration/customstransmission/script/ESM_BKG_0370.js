/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0370.js
 *@FileTitle : Mexico Customs Transmit
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16  
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.09.16  김도완
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
 * @class ESM_BKG-0370 : ESM_BKG-0370 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0370() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}
/* 개발자 작업 */
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;
var intervalId = "";


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
					doActionIBSheet(sheetObject,document.form,IBSEARCH);
				break; 
				
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
				break;                     

				case "search_flg":
			    	//초기화
			 		var objCbo = document.getElementById("pod_cd");
			 		objCbo.RemoveAll();
			 		formObject.pol_cd.value = "";
				break; 		
				case "search_cargo":
			    	//초기화
			 		var objCbo = document.getElementById("pod_cd");
			 		objCbo.RemoveAll();
			 		formObject.pol_cd.value = "";
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

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		initControl();
		for(var i = 0; i < form.search_flg.length; i++){
			if(form.search_flg[i].checked){
				// click 이벤트를 실행시키기 위해 이벤트를 발생시킨다.
				form.search_flg[i].click();
			}
		}
		
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
      
    //Axon 이벤트 처리2. 이벤트처리함수
      function obj_blur() {
 	   
 	   
 		   if(document.form.vvd.value!="" && document.form.pol_cd.value!="" ){
 			  doActionIBSheet(sheetObjects[0],document.form, COMMAND01);
               }

      }
    
   
     
       /*
   	* VVD 조회 데이터로 콤보박스생성
   	*/
       function ComboList(arrVal){
   		 if(typeof(arrVal)=="undefined") return;
   		 var objCbo = document.getElementById("pod_cd");
   		 ComClearCombo(objCbo);		 
   		 var arr_value = arrVal[0].split("|"); 
   		 if (arr_value.length >0)
   		 {
   			 var opt = document.createElement("option"); 
   			 var arr_text = "";   
   			 opt.setAttribute("value", "");  
   			 opt.innerHTML=arr_text;  
   			 objCbo.appendChild(opt);
   			 for(var i = 0; i <= arr_value.length-1; i++) {
   				opt = document.createElement("option"); 
   				arr_text = arr_value[i];   
   				opt.setAttribute("value", arr_text);  
   				opt.innerHTML=arr_text;  
   				objCbo.appendChild(opt);

   			 }
   		 }else{
   			 //var opt = document.createElement("option"); 
   			 //var arr_text = "All";   
   			 //opt.setAttribute("value", arr_text);  
   			 //opt.innerHTML=arr_text;  
   			 //objCbo.appendChild(opt);
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
		axon_event.addListenerForm("blur", "obj_blur", formObject);
		axon_event.addListenerFormat('keypress',       'obj_KeyPress',    formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
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
                    style.height = 400;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 4, 100);

                    var HeadTitle1 = "|Seq.|VVD|B/L No.|BKG No.|R|D|T/S|POR|V.POL|V.POD|DEL|WGT|WGT|PKG|FRT|STOW|RF|Send Date||||";
					var headCount = ComCountHeadTitle(HeadTitle1);					

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,	30,		daCenter,	false,	"seq");     
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"vvd",		false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		false,	"bl_no",	false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		false,	"bkg_no",	false,	"", dfNone,	0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"r",  		false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	false,	"d",  		false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	false,	"ts",     	false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"por_cd",   false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"pol_cd",  	false,	"", dfNone,	0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"pod_cd",   false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"del_cd",  	false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	false,	"act_wgt",	false,	"", dfNumber,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	false,	"wgt_ut_cd",false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	false,	"pck_qty",	false,	"", dfNumber,	0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"frt_term_cd",  false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"stwg_cd",  false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	false,	"rc_flg",  	false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	false,	"snd_dt",  	false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	90,		daCenter,	false,	"o_bl_no",  false,	"", dfNone,	0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,	90,		daCenter,	false,	"cpol",  	false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	90,		daCenter,	false,	"cpod",  	false,	"", dfNone,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	90,		daCenter,	false,	"stwg_desc",  false,"", dfNone,	0,	false,		false);
										
					CountPosition = 2;	
               }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
					
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH;	  			
	  		
				sheetObj.DoSearch("ESM_BKG_0370GS.do", FormQueryString(formObj));
				
				if(sheetObj.EtcData("vsl_eng_nm") != undefined){
					form.vsl_eng_nm.value = sheetObj.EtcData("vsl_eng_nm");
				}
				if(sheetObj.EtcData("call_sign") != undefined)
					form.call_sgn_no.value = sheetObj.EtcData( "call_sign");
				if(sheetObj.EtcData("eta") != undefined)
//					if(form.pod_cd.value != ""){
					if(form.pod_cd.Text != ""){
						form.eta.value = sheetObj.EtcData("eta");
						form.etd.value = "";
					}else{
						form.eta.value = "";
						form.etd.value = sheetObj.EtcData("eta");
					}
				if(sheetObj.EtcData("etd") != undefined){
					if(sheetObj.EtcData("etd") != ""){
						form.etd.value = sheetObj.EtcData("etd");
					}
				}
					
					
				
					
			break;
					
			case MULTI:        //Transmit
				if( ! validateForm(sheetObj,formObj,sAction)) return;
				
				for(var i = 1; i < sheetObj.rowCount+1; i++){
					sheetObj.RowStatus(i)= "U";
				}
				
				if(ComShowCodeConfirm("BKG40056", sheetObj.CellValue(1, "vvd"), sheetObj.CellValue(1, "cpol"), sheetObj.CellValue(1, "cpod"))){
						
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObj)+ "&" + FormQueryString(formObj);
					
					sheetObj.WaitImageVisible = false;
    				ComOpenWait(true,true);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0370GS.do", sParam);
					
					var key = ComGetEtcData(sXml, "KEY");
    				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
    				
					for(var i = 1; i < sheetObj.rowCount+1; i++){
						sheetObj.RowStatus(i)= "";
					}
				}
				
			break;	
			
			case COMMAND01:			//POD Combo
			formObj.f_cmd.value = COMMAND01; 
			var sXml =sheetObj.GetSearchXml("ESM_BKG_0370GS.do", FormQueryString(formObj));
			ComBkgXml2ComboItem(sXml,formObj.pod_cd,"val", "name");
			if (ComIsEmpty(formObj.pod_cd)) {
       			ComSetObjValue(formObj.pod_cd,formObj.pod_cd.Text);
       		}
			break;
        }
  	}
        
    /**
     * BackEndJob 실행결과조회.
     */
    function doActionValidationResult(sheetObj, sKey) {
    	
    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0370GS.do?f_cmd=" + SEARCH03
    			+ "&key=" + sKey);
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
				var sFlgVal = "";
				for(var i = 0; i < form.search_flg.length; i++){
					if(form.search_flg[i].checked){
						sFlgVal = form.search_flg[i].value;
						break;
					}
				}
				if(sFlgVal == "O"){
					if(form.pol_cd.value == ""){
						ComShowCodeMessage("BKG00626", "Please input POL to retrieve O/B");
						return false;
					}					
				}else if(sFlgVal == "T"){
					if(form.pod_cd.index < 0 && form.pol_cd.value == ""){
						ComShowCodeMessage("BKG00626", "Please input POL or POD to retrieve T/S");
						return false;
					}							
				}else if(sFlgVal == "I"){
					if(form.pod_cd.index < 0 || form.pol_cd.value == ""){
						ComShowCodeMessage("BKG00626", "Please input POL and POD to retrieve I/B");
						return false;
					}	
				}
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
		form.total_bl.value = "";
		var totBlCnt = 0;
		if(sheetObj.RowCount > 0)
		{
			var idx = 0;
			// Distinct한 BL 번호의 갯수를 구한다.
			for(var i = 1; i < sheetObj.RowCount + 1; i++)
			{				
				idx = 0;
				if(i == 1)
				{
					totBlCnt++;
				}else
				{
					idx = sheetObj.FindText("bl_no", sheetObj.CellValue(i, "bl_no"), 1);
					if(idx == i)
					{
						totBlCnt++;
					}
				}
				sheetObj.ToolTipText(i, "stwg_cd") = sheetObj.CellValue(i, "stwg_desc");
			}			
		}
		form.total_bl.value = ComAddComma(totBlCnt);
	}
     
     /**
      * Booking Creation 화면 이동
      * @param sheetObj Sheet
      * @param Row Row Index
      * @param Col Col Index
      */
     function sheet1_OnDblClick(sheetObj, Row, Col) {
     	var srcCol = sheetObj.ColSaveName(Col);
     	if (srcCol != "bl_no" && srcCol != "bkg_no") return;
     	
     	ComBkgCall0079two(sheetObj.CellValue(Row, "bl_no"));

     }
     
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_Clicked() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if(srcName == "search_flg"){
	    	if(srcValue == "O"){
	    		form.pol_cd.className = "input1";
	    		form.pod_cd.BackColor = "255,255,255" ;
	    	}else if (srcValue == "T"){
	    		form.pol_cd.className = "input";
	    		form.pod_cd.BackColor = "255,255,255" ;
	    	}else{
	    		form.pol_cd.className = "input1";
	    		form.pod_cd.BackColor = "#CCFFFD" ;
	    		
	    	}
    	}
    } 
     
     
   
