/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0035.js
*@FileTitle : Budget Expense Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.08 김진일
* 1.0 Creation
* 
* History
* 2011.04.12 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완 - vsl popup 호출로직 수정
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
     * @class VOP_PSO_0035 : VOP_PSO_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_PSO_0035() {
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

    var isShift = false;
    var arrChk = [0, 0, false];	//sheet1의 chk 컬럼을 하나만 선택할 수 있도록.. [현재 Row, 이전 Row, checked]
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

             var sheetObject1 = sheetObjects[0];
             var sheetObject2 = sheetObjects[1];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
                	case "btn_DownExcel":
                		sheetObject1.SpeedDown2Excel(-1);
                		break;
	                case "btns_search":
	                	openLaneCode();
	                	break;
	                case "btns_calendar_s":
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	    	            cal.select(form.txtsdate, "yyyy-MM");
	                	break;
	                case "btns_calendar_e":
	                	var cal = new ComCalendar();
	                	cal.setDisplayType('month');
	                	cal.select(form.txtedate, "yyyy-MM");
	                	break;
	                case "btn_vvd_search":
						var vsl_cd = formObject.vsl_cd.value;
	                	var sUrl = "";
	                	
	                	if(vsl_cd == ""){
	                		sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y";
	                		ComOpenPopup(sUrl, 460, 493, "getVslCdData", "0,0", true);
	                	}else{
	                		sUrl = "/hanjin/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
	                		ComOpenPopup(sUrl, 340, 393, "getVvdData", "0,0", true);
	                	}
					break;

	              case "btn_retrieve":
	            	  doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	            	  break;
	
	              case "btn_new":
	            	  clearSearchCondition();
	            	  break;
	              
	              case "btn_creation":
	            	  if(arrChk[2] == false){	//Checked된 Row가 없을 경우,
	            		  ComShowCodeMessage("PSO00039");
	            		  return;
	            	  }

					if(!ComShowCodeConfirm("PSO00041", "create")){
						return;
					}
						
	            	  doActionIBSheet(sheetObject1,formObject,IBSAVE);
	            	  doActionIBSheet(sheetObject1,formObject,IBSEARCH);//Creation Button Click 후 재 조회
	            	  break;
	              case "btn_detail":
	            	  if(sheetObjects[0].SelectRow>0){
	            		  var selRow = sheetObject1.SelectRow; 
	            		  var prefix = "sheet1_";
		            	  var turl = "/hanjin/VOP_PSO_0213.do?sdt="+formObject.txtsdate.value
		            	              +"&edt="+formObject.txtedate.value
		            	              +"&vslCd="+sheetObject1.CellValue(selRow, prefix+"vsl_cd")
		            	              +"&skdVoyNo="+sheetObject1.CellValue(selRow, prefix+"skd_voy_no")
		            	              +"&skdDirCd="+sheetObject1.CellValue(selRow, prefix+"skd_dir_cd")
		            	              +"&revYrmon="+sheetObject1.CellValue(sheetObject1.SelectRow, prefix+"expn_yrmon")
		            	              +"&psoBztpCd=1" //2009.12.07 add 
		            	              ;
//		            	  alert(turl);
						  ComOpenPopup( turl , 1020, 630, '', 'none', true, true);
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
     * VVD관련 데이터 설정 
     * @param obj
     * @return
     */
    function getVslCdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value = rtnDatas[1];
				}
			}
    	}
    }

	function getVvdData(obj){
    	if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value = rtnDatas[2];
					document.form.skd_dir_cd.value = rtnDatas[3];
				}
			}
    	}
    }
    /**
     * 조회 조건을 clear 한다. 
     * @return
     */
    function clearSearchCondition(){
    	var formObj = document.form;
//    	formObj.match_flag[0].checked = true; //ALL을 checked
//    	setToday(formObj.budget_year, "y");
//       	 //focusSetting
//       	 formObj.budget_year.focus();
//       	 formObj.budget_year.select();
    	//form reset 
    	formObj.reset();
    	setToday(document.form.txtsdate, "ym");//올해 설정
      	setToday(document.form.txtedate, "ym");//올해 설정
      	//grid remove 
      	sheetObjects[0].RemoveAll();
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

        for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

//        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
        //Control초기화 
        initControl();
    }
         
    /**
     * Control관련 초기화 처리
     * @return
     */
    function initControl(){
//        	 //budget_year의 value를 올해 로 설정한다.
//        	 var formObj = document.form;
//        	 setToday(formObj.budget_year, "y");
//        	 //focusSetting
//        	 formObj.budget_year.focus();
//        	 formObj.budget_year.select();
//        
//              axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
////              axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
//              axon_event.addListenerFormat('focus', 	'obj_activate',    	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	 
    	axon_event.addListener ('keydown', 'obj_keydown', 'form');
      	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
       	axon_event.addListenerForm('keyup', 'obj_keyup', form); //Focus이동관련
       	axon_event.addListenerFormat('beforeactivate', 	'obj_focus',    	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
       	axon_event.addListenerFormat('beforedeactivate',  	'obj_blur',  	form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
      	//budget year필드를 올해로 설정
      	//alert(setToday("y"));
      	setToday(document.form.txtsdate, "ym");//올해 설정
      	setToday(document.form.txtedate, "ym");//올해 설정
          
          
 	}
    function obj_keydown(){
       	isShift = event.shiftKey ? true : false;
       	ComKeyEnter();
    }
    /**
    * onBlur처리 
    * @return
    */
    function obj_blur(){
		  var formObj = document.form;
		  obj = event.srcElement;      	
		   	 
		   	 with(formObj){
		   		 if(obj.name=="txtsdate" || obj.name=="txtedate"){
				 var creDtFr = ComReplaceStr(txtsdate.value,"-","");
				 var creDtTo = ComReplaceStr(txtedate.value,"-","");
		        	
				 switch(obj.name) {
		    	    	case "txtsdate":	// Agreement From Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtsdate.value='';
		    	    				txtsdate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	    			
		    	            break;
		    	            
		    	    	case "txtedate":	// Agreement To Date
		    	    		if(creDtFr != '' && creDtTo != ''){
		    	    			if(creDtFr > creDtTo){
		    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
		    	    				txtedate.value='';
		    	    				txtedate.focus();
		    	    				return false;
		    	    			}
		    	    		}
		    	           	break;	
		        	}
		        
				ComChkObjValid(event.srcElement);
			 }
		   }
		   	 return true;	
    }

    /**
     * onFocus처리 
     * @return
     */
    function obj_focus(){
           ComClearSeparator(event.srcElement);
    }
    /**
     * keypress처리 함수
     * @return
     */
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
    	            ComKeyOnlyNumber(obj);
    	            break;
    	        case "int":
    	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
    	            else ComKeyOnlyNumber(obj);
    	            break;
    	        case "float":
    	            ComKeyOnlyNumber(obj, "-.");
    	            break;
    	        case "eng":
    	            ComKeyOnlyAlphabet(); break;
    	        case "engup":
    	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum');
    	            else if(obj.name==="vsl_slan_cd" || obj.name==="vsl_cd") ComKeyOnlyAlphabet('uppernum');
    	            else if(obj.name==="vndr_lgl_eng_nm") toUpper();//소문자만 대문자로.
    	            else ComKeyOnlyAlphabet('upper');
    	            break;
    	        case "engdn":
    	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
    	            else ComKeyOnlyAlphabet('lower');
    	            break;
    	    }
    	}
    /**
      * KEYUP의 경우 FOCUS이동 처리를 한다. 
      * @return
      */
    function obj_keyup() {
  		var eleObj = event.srcElement;
  		var formObj = document.form;
  		
 		//KEYTYPE이 마우스 클릭이면 리턴.
 		if (!event.keyCode) return true;
 		
		if(event.keyCode === 9 || isShift ){
// 				alert(event.keyCode);
			return true;
		}
		
  		switch (eleObj.name) {
  		case "txtsdate":
  			if (eleObj.value.length == 6) {
  				formObj.txtedate.focus();
  			}
  			break;
  		case "txtedate":
  			if (eleObj.value.length == 6) {
  				formObj.vsl_slan_cd.focus();
  			}
  			break;
  		case "vsl_slan_cd":
  			if (eleObj.value.length == 3) {
  				formObj.vsl_cd.focus();
  			}
  			break;
  		case "vsl_cd":
  			if (eleObj.value.length == 4) {
  				formObj.skd_voy_no.focus();
  			}
  			break;
  		case "skd_voy_no":
  			if (eleObj.value.length == 4) {
  				formObj.skd_dir_cd.focus();
  			}
  			break;
  		default:
  			break;
  	
  		}
  	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    			var sheetid = sheetObj.id;
          switch(sheetid) {

    				case "sheet1":
    					with (sheetObj) {
    							// 높이 설정
    							style.height = 440;
    							
    							//전체 너비 설정
    							SheetWidth = mainTable.clientWidth;

    							//Host정보 설정[필수][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//전체Merge 종류 [선택, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//전체Edit 허용 여부 [선택, Default false]
    							Editable = true;

    							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							//InitRowInfo(2, 1, 3, 100);
    							InitRowInfo(1, 1, 3, 100);

    							var HeadTitle1 = "|Seq.|REV.Month|LANE|ERR|CHK|VVD|Vessel Class|Amount|Remark|vslCd|skdVoyNo|skdDirCd";
//    							var HeadTitle2 = "|Seq.|LANE|Amount|VVD|Amount|VVD|Diff.";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// 해더에서 처리할 수 있는 각종 기능을 설정한다
    							InitHeadMode(true, true, false, true, false,false);

    							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);
//    							InitHeadRow(1, HeadTitle2, true); 
    							
    							var prefix = "sheet1_";
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  								KEYFIELD,	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,		prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,		40,	daCenter,	true,		prefix+"dataseq");
    							InitDataProperty(0, cnt++ , dtData,		150,	daCenter,	true,		prefix+"expn_yrmon",	false,		"",			dfNone,			0,		false,		false);
    							InitDataProperty(0, cnt++ , dtData,		150,	daCenter,	true,		prefix+"vsl_slan_cd",	false,		"",			dfNone,			0,		false,		false);
    							InitDataProperty(0, cnt++ , dtCheckBox,		60,	daCenter,	true,		prefix+"err",			false,		"",			dfNone,			0,		false,		false);
    							InitDataProperty(0, cnt++ , dtCheckBox,		60,	daCenter,	true,		prefix+"chk",			false,		"",			dfInteger,		0,		true,		false);
    							InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		prefix+"vvd",			false,		"",			dfNone,			0,		false,		false);
    							InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		prefix+"vsl_cls",		false,		"",			dfNone,			0,		false,		false);
    							InitDataProperty(0, cnt++ , dtData,		150,	daRight,	true,		prefix+"amt",			false,		"",			dfNullFloat,	2,		false,		false);
    							InitDataProperty(0, cnt++ , dtData,		200,	daLeft,	true,		prefix+"rmk",			false,		"",			dfNone,			0,		false,		false);
    							
    							InitDataProperty(0, cnt++ , dtHidden,	20,	    daCenter,	true,		prefix+"vsl_cd",		false,		"",			dfNone,			0,		false,		false);
    							InitDataProperty(0, cnt++ , dtHidden,	20,	    daCenter,	true,		prefix+"skd_voy_no",	false,		"",			dfNone,			0,		false,		false);
    							InitDataProperty(0, cnt++ , dtHidden,	20,	    daCenter,	true,		prefix+"skd_dir_cd",	false,		"",			dfNone,			0,		false,		false);
    							
    						}
    						break;

    						
            }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            sheetObj.WaitImageVisible=false;
            switch(sAction) {

              case IBSEARCH:      //조회
               	if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch("VOP_PSO_0035GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						var bgColor = sheetObj.RgbColor(255,255,255);
						sheetObj.ColBackColor(1) = bgColor;
						sheetObj.ColBackColor(2) = bgColor;
						sheetObj.ColBackColor(3) = bgColor;
						sheetObj.ColBackColor(4) = bgColor;
						sheetObj.ColBackColor(6) = bgColor;
						sheetObj.ColBackColor(7) = bgColor;
						sheetObj.ColBackColor(8) = bgColor;
						sheetObj.ColBackColor(9) = bgColor;
						ComOpenWait(false);
					}					
               	}
   				break;

			 case IBSAVE:        //저장
				 if(validateForm(sheetObj,formObj,sAction)){
					 ComOpenWait(true);
					 formObj.f_cmd.value = MULTI;
					 var SaveStr = ComGetSaveString(new Array(sheetObj)); // 배열입니다.
					 if(SaveStr.length <= 0 ) return;
					 var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
					 var sXml = sheetObj.GetSaveXml("VOP_PSO_0035GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					 ComOpenWait(false);
					 sheetObj.LoadSaveXml(sXml);
				 }
				 break;
            }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
            }

            return true;
    }

            
/*
 * sheet1의 chk 컬럼을 하나만 선택할 수 있도록
 */            
function sheet1_OnBeforeCheck(sheetObj, Row, Col){
	var formObj = document.form;
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
	 	 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "chk" :
			var valChk = sheetObj.CellValue(Row, Col);
			arrChk[1] = arrChk[0];	
			arrChk[0] = Row;	
			
			if(arrChk[1] != 0 && arrChk[0] != arrChk[1]){
				sheetObj.CellValue(arrChk[1], Col) = false;	//previous
			}

			arrChk[2] = valChk == true ? false : true;	//checked
			
			//formObj.xxx.value = arrChk[0] + ", " + arrChk[1] + ", " + arrChk[2]; 
		break;
	}
}

	/* 개발자 작업  끝 */