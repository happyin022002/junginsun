/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0072.js
*@FileTitle : BDR Status Report 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
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
     * @extends 
     * @class esm_bkg_0072  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0072() {
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
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		
     		var srcName = window.event.srcElement.getAttribute("name");
     		
 			switch(srcName) {
 				case "btn_RowAdd":
 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
 					break;
 				case "btn_RowDelete":
 					ComRowHideDelete(sheetObject1,"sheet1_del_chk");
 					break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_Print":
 					goPrint();
 					break;
 				case "btn_Save":
 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
 					break;
 				case "btn_DownExcel":
 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					break;

        case "btn_bdrdate":
	 					var cal = new ComCalendar();
	 	        cal.select(formObject.bdr_dt, 'yyyy-MM-dd');
					 break;
        case "btn_period":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.from_dt, formObject.to_dt,'yyyy-MM-dd');
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
 				ComConfigSheet (sheetObjects[i] );
 				initSheet(sheetObjects[i],i+1);
 				ComEndConfigSheet(sheetObjects[i]);
       }
       initControl();	
 			//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
 			
    }
     
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');//enter key event 검색되게
    }

		function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      default:
	    }
	}  
	
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }   
    
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "to_dt":
	    		ComClearSeparator(event.srcElement);
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
         switch(sheetObj.id) {

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
                 Editable = false;

                            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);

								var HeadTitle1 = " |OFFICE|BKG NO|STS|LANE|VVD|VVD|VVD|POR|POL|POD|DEL|PRE|POST|B/L NO|ETD DATE|BDR DATE\n(BKG POL Local Time)|Est.BDR DATE";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			 					
			 					var prefix = "sheet1_";

								InitDataProperty(0, cnt++ , dtHiddenStatus,	0, daCenter,	false, 	 prefix + "ibflag");
								InitDataProperty(0, cnt++ , dtData,	 		 85,   daCenter,  true,    prefix + "bkg_ofc_cd",    	false,    "",  dfNone, 	0, false,	false);
								InitDataProperty(0, cnt++ , dtData,      100,   daCenter,  true,    prefix + "bkg_no",          false,    "",  dfNone, 	0, false,	false);
								InitDataProperty(0, cnt++ , dtData, 	50,   daCenter,  true,    prefix + "bkg_sts_cd",     false,    "",  dfNone, 	0, false,	false);
								InitDataProperty(0, cnt++ , dtData, 	60,   daCenter,  true,    prefix + "slan_cd",        false,    "",  dfNone, 	0, false,	false);

								InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    prefix + "vsl_cd",          false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    prefix + "skd_voy_no",      false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData, 	20,   daCenter,  true,    prefix + "skd_dir_cd",      false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData,   	 60,   daCenter,	true,    prefix + "por_cd",          false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData, 	 	 60,   daCenter,  true,    prefix + "pol_cd",          false,    "",  dfNone, 0, false,	false);
                
								InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    prefix + "pod_cd",          false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    prefix + "del_cd",          false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    prefix + "pre_rly_port_cd", false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData,      60,   daCenter,  true,    prefix + "pst_rly_port_cd", false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  true,    prefix + "bl_no",           false,    "",  dfNone, 0, false,	false);
								
								InitDataProperty(0, cnt++ , dtData,   	 100,  daCenter,  true,    prefix + "etd_dt",          false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData, 	 140,  daCenter,  true,    prefix + "bdr_dt", 		     false,    "",  dfNone, 0, false,	false);
								InitDataProperty(0, cnt++ , dtData,   	 100,  daCenter,	true,    prefix + "ebdr_dt",         false,    "",  dfNone, 0, false,	false);

			 					//InitUserFormat2(0, prefix +	"upd_dt", "####-##-##", "-|:" );
			 					
			 					//CountPosition = 0;
 						}
 				
 					break;
         
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //조회
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = SEARCH;
	
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0072GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));

							sheetObjects[0].Redraw = false;    
							sheetObjects[0].WaitImageVisible = false;	
							sheetObjects[0].LoadSearchXml(sXml); 
							sheetObjects[0].Redraw = true; 
							
							//formObj.runtime.value = ComGetEtcData(sXml, "runtime"); 
			 			//	if ("sheet1" == sheetObj.id) sheetObj.DoSearch("ESM_BKG_0071GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			 				break;
			 				
			 			case SEARCH01:      //조회
							if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0071GS.do", FormQueryString(formObj));
							var arrXml = sXml.split("|$$|");
						  var arrData = ComXml2ComboItem(arrXml[0], formObj.slan_cd, "vsl_slan_cd", "vsl_slan_cd");
						  var arrData = ComXml2ComboItem(arrXml[1], formObj.skd_dir_cd, "val", "val");
						  
							break;
			
			 			case IBSAVE:        //저장
			 				if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = MULTI;
			 				if ("sheet1" == sheetObj.id) {
			 					var result = sheetObj.DoSave("ESM_BKG_0320GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
								if(result) {
									formObj.f_cmd.value = SEARCH;
									sheetObj.DoSearch("ESM_BKG_0320GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
								}
			 				}
			 				break;
			
						case IBINSERT:      // 입력
							sheetObj.DataInsert(-1);
							break;
							
						case IBDOWNEXCEL:   // 엑셀다운로드
							sheetObj.SpeedDown2Excel(1);
							break;
			
			    }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
    		
					if(!ComIsDate(formObj.from_dt.value)){
						ComShowCodeMessage('BKG00921')
     				formObj.from_dt.focus();
						return false;	  		
					}
					
					if(!ComIsDate(formObj.to_dt.value)){
						ComShowCodeMessage('BKG00921')
     				formObj.to_dt.focus();
						return false;	  		
					}
					
	    		if (ComIsNull(formObj.ofc_cd.value)) {
     					ComShowCodeMessage('BKG00922');
     					formObj.ofc_cd.focus();
     					return false;
		  		}
	    		
	    		if (!ComIsNull(formObj.from_dt) && !ComIsNull(formObj.to_dt) && ComGetDaysBetween(formObj.from_dt.value, formObj.to_dt.value) > 31){
	           		 
         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
         			formObj.from_dt.focus();
         			return false;
         		}
		  		
	  			break;
	  			
    		case IBSAVE:
    			var prefix = "sheet1_";
    			for(var i=sheetObj.HeaderRows; i <= sheetObj.RowCount+ sheetObj.HeaderRows-1 ; i++) {
	  				var vUsrId = sheetObj.CellValue(i, prefix+"usr_id");
	  				if (sheetObj.CellValue(i, prefix+"ibflag") != "R") {
	  					if (ComIsNull(vUsrId)) {
	      					ComShowCodeMessage('BKG00768','User ID');
	      					return false;
	  					}
	  				}
	  			}
	  			break;
    	 }
         return true;
     }
     
			/**
      * 화면 skf폼입력값에 대한 유효성검증 프로세스 처리
      */     
		function dateCheckUsa(dateobj){
			
			var arrMon = {Jan:'01',Feb:'02',Mar:'03',Apr:'04',May:'05',Jun:'06',Jul:'07',Aug:'08',Sep:'09',Oct:'10',Nov:'11',Dec:'12'}
			var date=dateobj.value;
			if(date =="") return true;//null이면 체크 안함
			// 			
			var reg = /(^\d{2})([A-Za-z]{3})(\d{2})/;   // 정규식
				
			if(reg.test(date)){//일월년 형식입력 확인
				var day  = RegExp.$1;
				var mon  = RegExp.$2;
				var year = RegExp.$3;
				
				if(arrMon[mon] == undefined){//월이 잘 못 입력됐을 경우.
					return false;
				}
				
				if(year >= 50){//50년보다 크면 1950 아니면 21세기
					if(ComIsDate('19'+year+arrMon[mon]+day))
						return true;
				}else{
					if(ComIsDate('20'+year+arrMon[mon]+day))
						return true;
				}
				
			}//일월년 형식입력 확인 끝
				
		  return false;
	}


    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var prefix = "sheet1_";
    	var formObject = document.form;
    	if (sheetObj.ColSaveName(Col) == prefix+"usr_id"){
    		formObject.ch_usr_id.value = Value;
    		doActionIBSheet(sheetObj,formObject,SEARCH01,Row,Col);
    	}
    }

    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }
    
    /*
	* RD 프린터 함수
	* @param string : 없음
	* @author 김기종
	* @version 2009.09.14
	*/
    
    function goPrint()
 	{		
 		var sheetObj= sheetObjects[0];
 		var formObj = document.form;
 		var rdPath  = "apps/alps/esm/bkg/bookingreport/performancereport/report/ESM_BKG_0859.mrd";
 		var where   = "";
 		var param   = new Array("period_type","from_dt","to_dt","ofc_cd","status_cd");
 		if(!validateForm(sheetObj,formObj,IBSEARCH)) return;
 		if (sheetObj.RowCount < 1) {
			ComShowCodeMessage("BKG00495");
		}
 		//where  = "PERIOD_TYPE[]" + "FROM_DT[]" + "TO_DT[]" + "OFC_CD[]"+"STATUS_CD[]"+"PERIOD[]";
 		
 		where  = getParam(param);
 		formObj.com_mrdPath.value 		= rdPath;
 		
 		formObj.com_mrdArguments.value 	= "/rv "  + where + " /riprnmargin /rwait";
 		formObj.com_mrdTitle.value = "BDR Status Report";
 		formObj.com_mrdDisableToolbar.value = "";
		formObj.com_mrdBodyTitle.value = "<span style=&quot;color:red&quot;>BDR Status Report</span>";
		ComOpenRDPopup();
 	}
    /*
	* RD 프린터 넘겨주는 파라미터 가져오는 함수
	* @param string : 넘겨줄 Param Name
	* @return string : RD로 넘겨줄 RV방식의 PARAM 
	* @author 김기종
	* @version 2009.09.14
	*/
    function getParam(param){
    	var formObj = document.form;
    	var rParam = "";
    	for(i=0;i<param.length;i++){
    		rParam += param[i]+"["+ComGetObjValue(eval("document.form."+param[i])) + "] ";
    	}
    	return rParam;
    }		
	/* 개발자 작업  끝 */    