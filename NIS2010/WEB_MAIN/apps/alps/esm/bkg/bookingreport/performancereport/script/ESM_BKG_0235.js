/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0235.js
*@FileTitle : e-S/I Performance Report by e-Mail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
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
     * @class ESM_BKG_0235 : ESM_BKG_0235 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0235() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setTabObject 			= setTabObject;    	
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var comboObjects = new Array();
 var combo1 = null;
 var comboCnt = 0;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var paramDateTemp = "";
 var mergeFlg = false;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 /*********************** TAB START ********************/
 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;
 /*********************** TAB START ********************/
 

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
          var sheetObject2 = sheetObjects[1];
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {

 				case "btn_Retrieve":
 					
 					ComBtnEnable("btn_Retrieve2");
 					ComBtnEnable("btn_DownReport");
 					// 시트[0], 시트[1] 초기화
 					sheetObjects[0].RemoveAll();
 					sheetObjects[1].RemoveAll();
 					
 					if (tabObjects[0].SelectedIndex == 1) {
 						tabObjects[0].SelectedIndex = 0;
 						setSheetVisble(0);
 					}
 					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
 					
					break;
					
 				case "btn_Retrieve2":
 					
 					// 시트[1] 초기화
 					sheetObjects[1].RemoveAll();
 					
					// detail버튼을 disable 한다.
 					//formObject.btn_Retrieve2.disabled = true;
 					doActionIBSheet(sheetObjects[0],formObject,MULTI01);
 					break;
 				case "btn_DownReport":
 					doActionIBSheet(sheetObjects[0],formObject,COMMAND01);
 					break;

 				case "btn_DownExcel":
 					
 					if (tabObjects[0].SelectedIndex == 0) {
 						doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL); 		
 					} else {
 						doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL); 		
 					}
					break;
	            case "btn_New":
	            	tabObjects[0].SelectedIndex = 0;
	            	setSheetVisble(0);
	            	sheetObjects[0].RemoveAll();
	            	sheetObjects[1].RemoveAll();
 					ComResetAll();
 					setDuration('M');
 					formObject.region_cd.index = 0;
 					ComBtnEnable("btn_Retrieve2");

 					break;
 					
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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

     function setComboObject(combo_obj){
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
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

        setSheetVisble(0);
          
        for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
        }
         
 	    for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
         initControl();
         
//         form.duration_year.value ="2014";
//		form.duration_month.value = "12";
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
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
  	    axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	
     	combo1 = comboObjects[0];
 		comboCnt = comboObjects.length;

 		// IBMultiCombo초기화
 	    for(var k=0; k<comboObjects.length; k++){
 	        initCombo(comboObjects[k]);
 	    }
 	    makeHtmlDuration("M");
 	    //setReportType("BR");
     	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
     	
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
 								style.height = 400;
 								//전체 너비 설정
 								SheetWidth = mainTable[0].clientWidth;
 								
 								//Host정보 설정[필수][HostIp, Port, PagePath]
 								if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 								
 								//전체Merge 종류 [선택, Default msNone]
 								MergeSheet = msAll; //msPrevColumnMerge + msHeaderOnly;
 								//MergeSheet = msPrevColumnMerge + msHeaderOnly;
 								
 								//전체Edit 허용 여부 [선택, Default false]
 								Editable = true;
 								
 								//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 								InitRowInfo(2, 1, 3, 100);
 								
 								var HeadTitle1 = "|DPCS|Region|Booking Office|Booking Office|Booking Office|Month|S/I|S/I|S/I|S/I|S/I";
 								var HeadTitle2 = "|DPCS|Region|GSO|Detail|Office|Month|TTL BKG|SI|E-Mail|Web SI Auto|SI Auto Total";
 								var headCount = ComCountHeadTitle(HeadTitle1);
 		
 								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 								InitColumnInfo(headCount, 0, 0, true);
 								
 								// 해더에서 처리할 수 있는 각종 기능을 설정한다
 								InitHeadMode(false, false, true, true, false,false);
 								
 								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 								InitHeadRow(0, HeadTitle1, true);
 								InitHeadRow(1, HeadTitle2, true);
 								
 								//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 								InitDataProperty(0,		cnt++ , dtHiddenStatus,		30,		daCenter,		true,	"hdnStatus");
 								InitDataProperty(0,		cnt++ , dtData,				100,		daCenter,		true,	"dpcs",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,				100,		daCenter,		true,	"region_cd",				false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,				100,		daCenter,		true,	"gso",						false,		"",		dfNone,					0,		false,		true);
 								if (mergeFlg) { 
 									InitDataProperty(0, 		cnt++ , dtCheckBox,		60,			daCenter,		true,	"checkbox",				false,		"",		dfNone,					0,		true,		true);
 								} else {
 									InitDataProperty(0, 		cnt++ , dtCheckBox,		60,			daCenter,		false,	"checkbox",				false,		"",		dfNone,					0,		true,		true);
 								}
 								InitDataProperty(0,		cnt++ , dtData,				150,		daCenter,		true,	"ofc_cd",					false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtData,				100,		daCenter,		true,	"duration",					false,		"",		dfDateYm,				0,		false,		true);
 								//InitDataProperty(0,		cnt++ , dtData,				100,		daCenter,		false,	"week",					false,		"",		dfNone,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			100,		daRight,		false,	"bkg_ttl",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			100,		daRight,		false,	"si_ttl",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			100,		daRight,		false,	"si_eml",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			100,		daRight,		false,	"si_uld",					false,		"",		dfInteger,					0,		false,		true);
 								InitDataProperty(0,		cnt++ , dtAutoSum,			100,		daRight,		false,	"si_auto_bkg_cnt",			false,		"",		dfInteger,					0,		false,		true);
 								//InitDataProperty(0,		cnt++ , dtData,				200,		daCenter,		false,	"si_rmk",					false,		"",		dfNone,					0,		false,		true);
 								
 								FrozenCols =7;
 								//CountPosition = 0;
 		
 						}
 						break;
 						
 					case "sheet2":
 						with (sheetObj) {
 							
 							// 높이 설정
 							style.height = 400;
 							//전체 너비 설정
 							SheetWidth = mainTable[0].clientWidth;
 							
 							//Host정보 설정[필수][HostIp, Port, PagePath]
 							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 							
 							//전체Merge 종류 [선택, Default msNone]
 							MergeSheet = msAll; //msPrevColumnMerge + msHeaderOnly;
 							
 							//전체Edit 허용 여부 [선택, Default false]
 							Editable = false;
 							
 							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 							InitRowInfo(2, 1, 3, 100);
 							
 							var HeadTitle1 = "DPCS|Region|Booking Office|Booking Office|S/I|S/I|S/I|S/I";
 							var HeadTitle2 = "DPCS|Region|GSO|Office|BKG NO|SI CNT|E-MAIL|Web SI Auto";
 							var headCount = ComCountHeadTitle(HeadTitle1);
 							
 							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 							InitColumnInfo(headCount, 0, 0, true);
 							
 							// 해더에서 처리할 수 있는 각종 기능을 설정한다
 							InitHeadMode(false, true, false, true, false,false);
 							
 							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 							InitHeadRow(0, HeadTitle1, true);
 							InitHeadRow(1, HeadTitle2, true);
 							
 							//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 							InitDataProperty(0,		cnt++ , dtData,				120,		daCenter,		true,	"dpcs",				false,		"",		dfNone,					0,		false,		true);
 							InitDataProperty(0,		cnt++ , dtData,				150,		daCenter,		true,	"region_cd",				false,		"",		dfNone,					0,		false,		true);
 							InitDataProperty(0,		cnt++ , dtData,				150,		daCenter,		true,	"gso",						false,		"",		dfNone,					0,		false,		true);
 							InitDataProperty(0,		cnt++ , dtData,				150,		daCenter,		true,	"ofc_cd",					false,		"",		dfNone,					0,		false,		true);
 							//InitDataProperty(0,		cnt++ , dtData,				100,		daCenter,		true,	"duration",				false,		"",		dfDateYm,				0,		false,		true);
 							
 							InitDataProperty(0,		cnt++ , dtData,			170,		daCenter,		false,	"bkg_no",					false,		"",		dfNone,					0,		false,		true);
 							//InitDataProperty(0,		cnt++ , dtAutoSum,		70,		daRight,		false,	"bkg_cnt",				false,		"",		dfInteger,					0,		false,		true);
 							InitDataProperty(0,		cnt++ , dtAutoSum,		120,		daRight,		false,	"si_cnt",					false,		"",		dfInteger,					0,		false,		true);
 							InitDataProperty(0,		cnt++ , dtAutoSum,			120,		daRight,		false,	"eml_flg",					false,		"",		dfInteger,					0,		false,		true);
 							InitDataProperty(0,		cnt++ , dtAutoSum,			120,		daRight,		false,	"uld_flg",					false,		"",		dfInteger,					0,		false,		true);
 							//InitDataProperty(0,		cnt++ , dtData,			120,		daCenter,		false,	"fax_flg",					false,		"",		dfNone,					0,		false,		true);
 							//InitDataProperty(0,		cnt++ , dtData,			200,		daCenter,		false,	"eml",						false,		"",		dfNone,					0,		false,		true);
 							//InitDataProperty(0,		cnt++ , dtData,			100,		daRight,		false,	"fax_no",					false,		"",		dfNone,					0,		false,		true);
 							
 							FrozenCols = 4;
 							//CountPosition = 0;
 							
 						}
 						break;
 			}
 	}

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0227_1GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 2) 
					//ComXml2ComboItem(arrXml[2], formObj.bkg_cust_tp_cd, "val", "name");
				if (arrXml.length > 1) 
					ComXml2ComboItem(arrXml[1], formObj.region_cd, "val", "val|name");
				
				//ComSetObjValue(formObj.bkg_cust_tp_cd,"S");
				formObj.region_cd.InsertItem(0, 'ALL', 'ALL');
				formObj.region_cd.index = 0;
				break;
				
           case IBSEARCH:      //조회
        	   	if(validateForm(sheetObj,formObj,sAction)) {

        	   		
        	   		formObj.f_cmd.value = SEARCH;
        	   		var queryParam = FormQueryString(formObj);
        	   		mergeFlg = false;
        	   		
        	   		// 날짜를 설정한다.
        	   		if (ComGetObjValue(formObj.duration_opt) == "M" ) {
        	   			var year = formObj.duration_year.value;
        	   			var month = formObj.duration_month.value;
        	   			//마지막 날짜 구하기
        	   			var lastDay = new Date(year, month,0).getDate();
        	   			        	   			
        	   			var duration_from = year+month+'01';
        	   			var duration_to = year+month+lastDay;
        	   			paramDateTemp =  "&duration_from_dt="+duration_from+"&duration_to_dt="+duration_to;        	   			
        	   			queryParam = queryParam + paramDateTemp;
        	   		} else {
        	   			
        	   			var duration_from = formObj.duration_from_dt.value;
        	   			var duration_to = formObj.duration_to_dt.value;
        	   			
        	   			// week 기간이 두달 걸치게 되는지를 체크한다.
        	   			if (duration_from.substring(6,7) != duration_to.substring(6,7)) {
        	   				mergeFlg = true;
        	   			}
        	   			
        	   			paramDateTemp =  "&duration_from_dt="+duration_from+"&duration_to_dt="+duration_to;    
        	   		}
        	   		
        	   		//alert( queryParam );
        	   		initSheet(sheetObj,0);
        	   		
        	   		sheetObj.DoSearch("ESM_BKG_0235GS.do", queryParam + "&" + ComGetPrefixParam(""));
        	   	}	
                break;
                
           case MULTI01:
        
        	   if(!validateForm(sheetObj,formObj,sAction)) {
        		   return;
        	   }
    	   
    		    ComBtnDisable("btn_Retrieve2");
    		    ComBtnDisable("btn_DownReport");
   		    	tabObjects[0].SelectedIndex = 1;
   	   			formObj.f_cmd.value = MULTI;
   	   		
        	   	// 1. 체크박스에 체크가 되었는지 확인
				var selRows =sheetObj.FindCheckedRow("checkbox");
				var idxArr = selRows.split("|");		
				var queryParam = FormQueryString(formObj);
				
				var ofc_cd ="";
				var old_ofc_cd = "";
				var new_ofc_cd = "";
				
				for (ir=0;ir<idxArr.length;ir++) {
					if(idxArr[ir] == '') {
						continue;
					}
					new_ofc_cd = sheetObj.CellValue(idxArr[ir], "ofc_cd");
					
					if (new_ofc_cd == old_ofc_cd) {
						
						// 만약 마지막이면 마지막 , 를 삭제한다.
						if (ir == (idxArr.length - 2)) {
							ofc_cd = ofc_cd.substring(0,ofc_cd.length -1);
						}
						continue;
						
					} else {
						old_ofc_cd = new_ofc_cd;
					}
					
					ofc_cd = ofc_cd + "'" + new_ofc_cd+ "'";
					if (ir < (idxArr.length - 2)) {
						ofc_cd = ofc_cd + ",";	
					} 
				}
				
				if (ofc_cd == "") {
					// 일단 에러체크
					ComShowMessage(ComGetMsg("BKG00249"));
					return false;
				}
				queryParam = queryParam + "&ofc_cd="+ofc_cd; 
				queryParam = queryParam + paramDateTemp;
				
				setSheetVisble(1);
				//alert(ofc_cd)
				sheetObjects[1].DoSearch("ESM_BKG_0235GS.do", queryParam	+ "&" + ComGetPrefixParam(""));
				
				
				break;
           case COMMAND01:
        	   
        	   if(!validateForm(sheetObj,formObj,sAction)) {
        		   return;
        	   }
        	   // 1. 체크박스에 체크가 되었는지 확인
        	   var selRows =sheetObj.FindCheckedRow("checkbox");
        	   if (ComIsNull(selRows)) {
        		   // 일단 에러체크
        		   ComShowMessage(ComGetMsg("BKG00249"));
        		   return false;
        	   }
        	   
        	   ComOpenWait(true);
        	   ComBtnDisable("btn_DownReport");
        	   
    		   formObj.f_cmd.value = COMMAND01;
    		   
    		   var idxArr = selRows.split("|");		
    		   var queryParam = FormQueryString(formObj);
    		   
    		   var ofc_cd ="";
    		   var old_ofc_cd = "";
    		   var new_ofc_cd = "";
    		   
    		   for (ir=0;ir<idxArr.length;ir++) {
    			   if(idxArr[ir] == '') {
    				   continue;
    			   }
    			   new_ofc_cd = sheetObj.CellValue(idxArr[ir], "ofc_cd");
    			   
    			   if (new_ofc_cd == old_ofc_cd) {
    				   
    				   // 만약 마지막이면 마지막 , 를 삭제한다.
    				   if (ir == (idxArr.length - 2)) {
    					   ofc_cd = ofc_cd.substring(0,ofc_cd.length -1);
    				   }
    				   continue;
    				   
    			   } else {
    				   old_ofc_cd = new_ofc_cd;
    			   }
    			   
    			   ofc_cd = ofc_cd + "'" + new_ofc_cd+ "'";
    			   if (ir < (idxArr.length - 2)) {
    				   ofc_cd = ofc_cd + ",";	
    			   } 
    		   }
    		   
    		   if (ofc_cd == "") {
    			   // 일단 에러체크
    			   ComShowMessage(ComGetMsg("BKG00249"));
    			   ComBtnEnable("btn_DownReport");
        		   ComOpenWait(false);
    			   return false;
    		   }
    		   queryParam = queryParam + "&ofc_cd="+ofc_cd; 
    		   queryParam = queryParam + paramDateTemp;
    		   
    		   document.location.href = "ESM_BKG_0235DL.do?"+ queryParam	+ "&" + ComGetPrefixParam("");
    		
    		   ComBtnEnable("btn_DownReport");
    		   ComOpenWait(false);
        	   
        	   break;
                
           case IBDOWNEXCEL:      // 다운로드
  				sheetObj.SpeedDown2Excel(-1);
  				break;			
         }
     }

     function tab1_OnClick(tabObj, nItem){
    	 
    	 var formObj = document.form; 
    	 
    	if (nItem == 0) {
    		ComBtnEnable("btn_Retrieve2");
    		ComBtnEnable("btn_DownReport");
    	} else {
    		ComBtnDisable("btn_Retrieve2");
    		ComBtnDisable("btn_DownReport");
    	} 
    	 
 	 	setSheetVisble(nItem);
     }
     
     function setSheetVisble(inx){
  		for(var k=0; k< mainTable.length; k++){
  		    mainTable[k].style.display ="none";
  		}
  		mainTable[inx].style.display ="";
      }
   

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
         	switch(sAction) {
		     	case IBSEARCH: // 조회시 확인

	     		if (ComGetObjValue(formObj.duration_opt) == "D" ) {
	     			
		     		if (!ComIsNull(formObj.duration_from_dt) 
				  			&& !ComIsNull(formObj.duration_to_dt) 
				  			&& ComGetDaysBetween(formObj.duration_from_dt.value, formObj.duration_to_dt.value) > 31){
		           		 
	         			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
	         			formObj.duration_from_dt.focus();
	         			return false;
	         		}
		     		
		     		// madatory check
		     		if (!ComChkValid(formObj)) return false;
		     		
	     		} else {  // ComGetObjValue(formObj.duration_opt) == "M" 
		     	
			     	// year check
			     	if(isNaN(formObj.duration_year.value)) { 
			     		ComShowCodeMessage("BKG00714");//'"Please Check Date"
			     		formObj.duration_year.focus();
			     		return false;
			     	}
	
			     	// year check
			     	if (formObj.duration_year.value.length != 4) {
			     		ComShowCodeMessage("BKG00108");//"Please enter Year ccorrectly.\nFormat : YYYY"
			     		formObj.duration_year.focus();
			     		return false;
			     	} 
			    
			     	// month check
			     	if(isNaN(formObj.duration_month.value)) { 
			     		ComShowCodeMessage("BKG00714");//'"Please Check Date"
			     		formObj.duration_month.focus();
			     		return false;
			     	}
			     	
			     	if (formObj.duration_month.value > 12 || formObj.duration_month.value < 1) {
			     		ComShowCodeMessage("BKG50471");//"Please check the date range!"
			     		formObj.duration_month.focus();
			     		return false;
			     	} 
			     	
			     	if (formObj.duration_month.value.length == 1 &&  formObj.duration_month.value < 10) {
			     		formObj.duration_month.value = '0'+formObj.duration_month.value;
			     	} 
	     		}
			  	break;
			  	
		     	case MULTI01:
		     		
		     		// 체크박스 설정
					var selRows =sheetObj.FindCheckedRow("checkbox");
					if (selRows.length == 0) {
						ComShowMessage(ComGetMsg("BKG00249"));
						return false;
					}
				break;
         	}	
         }		
         return true;
     }

    function initTab(tabObj,tabNo) {
        switch(tabNo) {
	        case 1:
	           with (tabObj) {
	               var cnt  = 0 ;
	               InsertTab( cnt++ , "Summary" , -1 );
	               InsertTab( cnt++ , "Detail" , -1 );	
	           }
	        break;
	    }
    }
     
    
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)	{
		sheetObj.ShowSubSum("dpcs", "bkg_ttl|si_ttl|si_eml|si_uld|si_auto_bkg_cnt", -1 , true, false, 6, "6=Sub Total(DPCS)");
		sheetObj.ShowSubSum("region_cd", "bkg_ttl|si_ttl|si_eml|si_uld|si_auto_bkg_cnt", -1 , true, false, 6, "1=%s;6=Sub Total(Region)");
		sheetObj.ShowSubSum("gso", "bkg_ttl|si_ttl|si_eml|si_uld|si_auto_bkg_cnt",  -1 , true, false, 6, "1=%s;2=%s;6=Sub Total(GSO)");
		if (mergeFlg) {
			sheetObj.ShowSubSum("ofc_cd", "bkg_ttl|si_ttl|si_eml|si_uld|si_auto_bkg_cnt",  -1 , true, false, 6, "1=%s;2=%s;3=%s;6=Sub Total(OFC_CD)");
		}
		//sheetObj.ShowSubSum("duration", "bkg_ttllsi_ttl|si_eml",  -1 , true, false, 6, "1=%s;2=%s;3=%s;4=%s;6=Sub Total(MONTH)");
	}
	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg)	{
		sheetObj.ShowSubSum("dpcs", "si_cnt|eml_flg|uld_flg", -1 , true, false, 4, "4=Sub Total(DPCS)");
		sheetObj.ShowSubSum("region_cd", "si_cnt|eml_flg|uld_flg", -1 , true, false, 4, "0=%s;4=Sub Total(Region)");
		sheetObj.ShowSubSum("gso", "si_cnt|eml_flg|uld_flg",  -1 , true, false, 4, "0=%s;1=%s;4=Sub Total(GSO)");
		sheetObj.ShowSubSum("ofc_cd", "si_cnt|eml_flg|uld_flg",  -1 , true, false, 4, "0=%s;1=%s;2=%s;4=Sub Total(OFC_CD)");
	}
    
	
	/**
     * 콤보 초기설정값
     * @param {IBMultiCombo} comboObj  comboObj
     */
     function initCombo(comboObj) {
     	comboObj.DropHeight = 150;
     	
     }  
     
     
     function sheet1_OnChange(o,r,c,v){

    	 try{
    		//머지된 영역의 값을 동일하게 세팅해 주자.
    		if(sheetObjects[0].ColSaveName(c)=="checkbox") {
    			
    			// 1. 현재의 ofc_Cd를 취득한다.
    			
	    		var chgValue = v;
	    		//머지시작점
	    		var mergeStartRow = parseInt((sheetObjects[0].GetMergedStartCell(r,5)).split(",")[0]);
	    		//머지끝점
	    		var mergeEndRow = parseInt((sheetObjects[0].GetMergedEndCell(r,5)).split(",")[0]);

	    		for(var x=mergeStartRow;x<=mergeEndRow;x++){
	    			sheetObjects[0].CellValue2(x,"checkbox") = chgValue; 
	    		}
    		}
		}catch(e){
			alert(e.message);
		}
     }
     
     
 	/**
      * from,to 기간 선택 달력 띄우기
      */
   	function callDatePop(val){
   		var cal = new ComCalendarFromTo();
   		if (val == 'BKG_DATE'){
   			cal.select(form.duration_from_dt,  form.duration_to_dt,  'yyyy-MM-dd');
   		}
   	}	
  
  	/**
     * from,to 기간 자동 세팅
     */
  	function setDuration(val){
  		var formObject = document.form;
  		makeHtmlDuration(val);
  		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
  	}
  	
  	/**
     * duration에 따른 html적용.
     */
  	
  	function makeHtmlDuration(val){
  		var formObject = document.form;
  		var html = "";

  		if (val == "M"){
  			html = "<td width=\"30\">Year&nbsp;</td>";
			html += "<td width=\"60\">";
			html += "	<input type=\"text\" name=\"duration_year\" style=\"width:40;\" class=\"input1\"  dataformat=\"yy\" caption=\"Year\" maxlength=\"4\"  required >";
			html += "</td>";
			html += "&nbsp;<td width=\"40\">Month&nbsp;</td>";
			html += "<td width=\"60\">";
			html += "<input type=\"text\" name=\"duration_month\" style=\"width:20;\" class=\"input1\"  dataformat=\"mm\" caption=\"Month\" maxlength=\"2\"  required>";
			html += "</td>";
  		}else if (val == "D"){
  			html = "<td width=\"250\">";
  			html += "<input type=\"text\" name=\"duration_from_dt\" style=\"width:75;\" class=\"input1\"  dataformat=\"ymd\" caption=\"Start Date\" maxlength=\"10\"  required cofield=\"duration_to_dt\">";
  			html += "&nbsp;~&nbsp;";
  			html += "<input type=\"text\" name=\"duration_to_dt\" style=\"width:75;\" class=\"input1\"   dataformat=\"ymd\" caption=\"End Date\" maxlength=\"10\"  required cofield=\"duration_from_dt\">&nbsp;";
  			html += "<img class=\"cursor\" src=\"img/btns_calendar.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"  style=\"cursor:hand\" onClick=\"callDatePop('BKG_DATE')\">";
  			html += "</td>";
  		}

		duration.innerHTML =html;	
		
		if (val == "M") {
  			ComSetObjValue(formObject.duration_year,ComGetNowInfo().substr(0,4));
  			ComSetObjValue(formObject.duration_month,ComGetNowInfo().substr(5,2));
  		}
		
  		setSheetDurationTitle(val);
  	}
  	
  	/**
     * sheet title month, week변경 설정.
     */
  	function setSheetDurationTitle(duration){
  		var formObject = document.form;
  		var sheetObj;
  		sheetObj = sheetObjects[0];
  		sheetObj.CellValue2(0, "duration") = "Month";
  		sheetObj.CellValue2(1, "duration") = "Month";

  	}
  	
     function formQueryString(){
    	 var formObj = document.form;
    	 formObj.f_cmd.value = SEARCH;   
    	 return FormQueryString(formObj);
     }
 	 
	/* 개발자 작업  끝 */