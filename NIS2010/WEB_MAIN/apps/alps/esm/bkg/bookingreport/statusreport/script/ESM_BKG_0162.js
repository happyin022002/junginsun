/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0162.js
*@FileTitle : Container List on Stowage & B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.16 김기종
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
     * @class esm_bkg_0162 : esm_bkg_0162 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0162() {
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

 var comboObjects = new Array();
 var combo1 = null;
 var comboCnt = 0;
 
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

				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;

				case "btn_downexcel":
					sheetObject1.Down2Excel();
				break;	
				
				case "btn_history":
					var srow =sheetObject1.SelectRow;
					var tmp = sheetObject1.CellValue(srow, "cntr_no");
					
					if (tmp == "" || tmp.length != 11 ){
						ComShowCodeMessage('BKG40055');
						return;
					}
					
					var cntrNo = (tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
                    var checkDigit = (tmp != null && tmp.length>10) ? tmp.substring(10) : '';
					var typeSize = sheetObject1.CellValue(srow, "cntrts_cd");
					
					var url = "EES_CTM_0411.do?func=&cntrNo="+cntrNo+"&checkDigit="+checkDigit+"&typeSize="+typeSize;
					ComOpenWindowCenter(url, "EES_CTM_0411", 1010, 650, false);
					break;

				case "btn_print":
					alert(srcName);
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
 		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		initControl();
 		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
 		//IBMultiCombo초기화
		for(var j=0; j<comboObjects.length; j++){
		    initCombo(comboObjects[j]);
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
     	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
     	
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     }

     /**
	  * 콤보 초기설정값
	  * @param {IBMultiCombo} comboObj  comboObj
	  */
	  function initCombo(comboObj) {
		var formObj = document.form;  
	  	comboObj.DropHeight = 250;
	  	comboObj.UseAutoComplete = true;
	  	comboObj.index =0;
	  	
	  	switch(comboObj.id) {
	  		case "bkg_cgo_ty_cd": 
	  			ComSetObjValue(formObj.bkg_cgo_ty_cd,"U");
	  			break;
	  		case "sp_cntr_ty_cd": 
	  			ComSetObjValue(formObj.sp_cntr_ty_cd,"AL");	
	  			break;
	  		case "cgo_tp": 
	  			ComSetObjValue(formObj.cgo_tp,"ALL");
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
					 MergeSheet = msPrevColumnMerge + msHeaderOnly; //msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					 Editable = false;
					
					 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					 InitRowInfo( 2, 1, 3, 100);
					
					
					 // 해더에서 처리할 수 있는 각종 기능을 설정한다
					 InitHeadMode(true, true, false, true, false,false)
					
					 var HeadTitle1 = "Seq.|Container No.|T/P|Load|BKG No.|F/M|B/L No.|COD Reason|COD Reason|B/L|B/L|STWG|STWG|Stowage|Special Container|Special Container|Special Container|Special Container|Special Container|H B/L";
					 var HeadTitle2 = "Seq.|Container No.|T/P|Load|BKG No.|F/M|B/L No.|COD Reason|COD Reason|POL|POD|POL|POD|Stowage|DG|BB|AK|RF|PC|H B/L";
					 
					 
					 var headCount = ComCountHeadTitle(HeadTitle1);
					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 InitColumnInfo(headCount, 0, 0, true);
					 
					 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					 InitHeadRow(0, HeadTitle1, true);
					 InitHeadRow(1, HeadTitle2, true);
					                     
					 //데이터속성    [ ROW, COL,  	 DATATYPE,   WIDTH,   DATAALIGN,    COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtData,	   40,     daCenter,    true,     "seq");     
					 InitDataProperty(0, cnt++ , dtData,	  110,     daCenter,    true,     "cntr_no",              false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData, 	   40,     daCenter,	true,     "cntrts_cd",            false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData,       50,     daCenter,    true,     "flg",                  false,    "",      dfNone, 		0,     false,	false);
					                                                                                                                                      
					 InitDataProperty(0, cnt++ , dtData,      115,     daCenter,    true,     "bkg_no",               false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData, 	   45,     daCenter,    true,     "cgo_tp",		          false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData,   	  110,     daCenter,	true,     "bl_no",                false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData,   	   80,     daCenter,	true,     "cod_rqst_rsn_cd",      false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,    100,     daCenter,	true,     "cod_rqst_rsn_nm",      false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData, 	   60,     daCenter,   	true,     "bk_pol",               false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData,       60,     daCenter,    true,     "bk_pod",               false,    "",      dfNone, 		0,     false,	false);
					                                                                                                                                      
					 InitDataProperty(0, cnt++ , dtData,       60,     daCenter,    true,     "bay_pol",              false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData, 	   60,     daCenter,    true,     "bay_pod",              false,    "",      dfDateYmd,	0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData,       70,     daCenter,    true,     "stwg",                 false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData,   	   30,     daCenter,	true,     "dg",     	          false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData, 	   30,     daCenter,	true,     "bb",    		          false,    "",      dfNone, 		0,     false,	false);
					                                                                                                  
					 InitDataProperty(0, cnt++ , dtData,   	   30,     daCenter,	true,     "ak",     	          false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData, 	   30,     daCenter,	true,     "rf",    		          false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtData,   	   30,     daCenter,	true,     "pc",     	          false,    "",      dfNone, 		0,     false,	false);
					 InitDataProperty(0, cnt++ , dtHidden,     30,     daCenter,	true,     "hbl",     	          false,    "",      dfNone, 		0,     false,	false);
					                                                                                                                
                                                                                                                  
                }
                 break;
                  
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
	         case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value = COMMAND01;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0162GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					
					if (arrXml.length > 4) 
						ComXml2ComboItem(arrXml[4], formObj.cgo_tp, "val", "val");
					if (arrXml.length > 3) 
						ComXml2ComboItem(arrXml[3], formObj.sp_cntr_ty_cd, "val", "name");
					if (arrXml.length > 2) 
						ComXml2ComboItem(arrXml[2], formObj.bkg_cgo_ty_cd, "val", "name");
					if (arrXml.length > 1) 
						ComXml2ComboItem(arrXml[1], formObj.stwg_status, "val", "name");
					if (arrXml.length > 0) 
						ComXml2ComboItem(arrXml[0], formObj.bound_type, "val", "name");
					
					break;
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH;
		        	  sheetObj.DoSearch("ESM_BKG_0162GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));
				}	  
		        break;
						
			break;
			
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
				case IBSEARCH: // 저장시 확인
	         		if (!ComChkValid(formObj)) return false;
	         		break;
        	 }	
         }
         return true;
     }
 	function bound_type_OnChange(comboObj,value,text){
 		var formObj = document.form;
 		var bound = value;
 		
 		if(bound =='I')
 		{
 			pol.innerHTML = "POD";
 		}
 		else if(bound =='O')
 		{
 			pol.innerHTML = "POL" ;
 		}
 	}

 	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		with (sheetObj)
 		var redColor = RgbColor(255,0,0);
 		var sheetObj = sheetObjects[0];

 		for(var i = 2; i < sheetObj.Rows; i++){
 			
 			if(sheetObj.CellValue(i,"hbl") =="Y") {
 				sheetObj.CellFontColor(i, "bkg_no") = redColor;
 			}
 			if(sheetObj.CellValue(i,"flg") =="No") {
 				sheetObj.CellFontColor(i, "cntr_no") = redColor;
 				sheetObj.CellFontColor(i, "flg") = redColor;
 			}
 		}
 	}
 	
 	
	/* 개발자 작업  끝 */