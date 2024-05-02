/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0595.js
*@FileTitle : Freight & Charge Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.19 김기종
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
     * @class esm_bkg_0595 : esm_bkg_0595 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0595() {
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
	 			case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;  
	 			case "btn_New":
	 				sheetObject1.RemoveAll();
 					ComResetAll();
 					break;
 					
 				case "btn_Close":
 					window.close();
 					break;
 				case "btn_CommodityPop":
 					//formObject.cmdt_cd.value,formObject.rep_cmdt_cd.value
 					comBkgCallPop0653('setCommodityCd',formObject.cmdt_cd.value,formObject.rep_cmdt_cd.value);
 					break;	
 					
 				case "btn_ComEns041Pop":
 					openWindowCustomer(formObject);
 					break;	
 				
 				case "btn_DownExcel":
 					//-------------------Excel Download 결재로직 START--------------------------
 		   	    	/*
 		   	    	 * 모듈명과 화면명 각 모듈에 맞게 하드코딩
 		   	    	 */
 					var subSysCd = "BKG";
 		   	    	var pgmNo = "ESM_BKG_0595";
 		   	    	
 		   	    chkXlsBtnPrmtBF(subSysCd, pgmNo, sheetObjects[0]);//ETC용 sheet이므로 아무렇게나 넣으셔도 됩니다.
 		   	    	if(xlsDlRstrActFlg == "N"){
 		   	    		/*
 		   	    		 * 기존 액셀 Download 소스
 		   	    		 */
 		   	    		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
 		   	    	}else if(xlsDlRstrActFlg == "Y"){
	 		   	    		if(authAproStsCd == "C" && !(authAproRqstNo==null || authAproRqstNo==undefined || authAproRqstNo==""|| authAproRqstNo.length != 30)){
	 		   	    			/*
	 	 		   	    		 * 기존 액셀 Download 소스
	 	 		   	    		 */
	 		   	    			doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
	 		   	    		}else if(authAproStsCd == "P"){
	 		   	    			//ComShowMessage("The approval for Excel Download is in progress\n[Rqst No.:"+authAproRqstNo+"]");
	 		   	    			ComShowMessage(ComGetMsg('AUTH00001', authAproRqstNo));
	 		   	    		}else{
	 		   	    			var param = "?sub_sys_cd="+subSysCd+"&target_obj_nm=AUTH_APRO_RQST_NO&pgm_no="+pgmNo;
	 		   	    			chkXlsDnPopup(param); //결재창 Popup
	 		   	    		}
 		   	    	}else{
 		   	    		ComShowMessage(ComGetMsg('AUTH00002'));
 		   	    	}
 		   	    	//-------------------Excel Download 결재로직 END--------------------------
 					break;
 					
 				case "btn_Sort":
 					
 					//sheetObjects[0].ShowSortDialog();
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
 		 doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);

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
     	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
  	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
  	   
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
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
							style.height = 302;
							//전체 너비 설정
							SheetWidth = mainTable.clientWidth;
							
							//Host정보 설정[필수][HostIp, Port, PagePath]
							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
							
							//전체Merge 종류 [선택, Default msNone]
							MergeSheet = msAll;//msPrevColumnMerge;
							
							//전체Edit 허용 여부 [선택, Default false]
							Editable = true;
							
							//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
							InitRowInfo(1, 1, 3, 100);
							
							var HeadTitle = "||Per|Charge Code|Amount|Charge Description|sorting_priority|";
							var headCount = ComCountHeadTitle(HeadTitle);
	
							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
							InitColumnInfo(headCount, 0, 0, true);
							
							// 해더에서 처리할 수 있는 각종 기능을 설정한다
							InitHeadMode(false, true, false, true, false,false);
							
							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
							InitHeadRow(0, HeadTitle, true);
							
							//데이터속성    	[ROW, 	COL,  	DATATYPE,   			WIDTH, DATAALIGN, 		COLMERGE, 	SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
							InitDataProperty(0, 	cnt++ , dtHiddenStatus,			0, 	   daCenter,    	false,    	"Status");
							InitDataProperty(0,		cnt++ , dtHidden,				70,		daCenter,		false,		"frt_chg_tp_cd",false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,					70,		daCenter,		false,		"per",			false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,					120,	daCenter,		false,		"chg_cd",		false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtAutoSum,				110,	daRight,		false,		"brate_prepaid",false,		"",		dfNullFloat,			2,		false,		true);
							InitDataProperty(0,		cnt++ , dtData,					550,	daLeft,			false,		"chg_nm",		false,		"",		dfNone,					0,		false,		true);
							
							
							InitDataProperty(0,		cnt++ , dtHidden,				70,		daCenter,		false,		"sorting_priority",false,		"",		dfNone,					0,		false,		true);
							InitDataProperty(0,		cnt++ , dtHidden,				70,		daCenter,		false,		"per_group",false,		"",		dfNone,					0,		false,		true);
							
							DataRowMerge(0) = true;
							CountPosition = 0;
							
							
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
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0595GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 2) 
					ComBkgXml2ComboItem(arrXml[2], formObj.chg_rev_tp_cd, "val", "name");
				if (arrXml.length > 1) 
					ComBkgXml2ComboItem(arrXml[1], formObj.frt_chg_tp_cd, "val", "name");
				if (arrXml.length > 0) 
					ComBkgXml2ComboItem(arrXml[0], formObj.cntr_tpsz_cd, "cntr_tpsz_cd", "cntr_tpsz_desc");
				
				formObj.cntr_tpsz_cd.DropHeight = 200;
				formObj.cntr_tpsz_cd.UseAutoComplete = true;
				
				formObj.frt_chg_tp_cd.DropHeight = 170;
				formObj.frt_chg_tp_cd.UseAutoComplete = true;
				
				formObj.cntr_tpsz_cd.InsertItem(0, '', '');
				formObj.frt_chg_tp_cd.InsertItem(0, '', '');
				formObj.chg_rev_tp_cd.InsertItem(0, '', '');
				break;
           case IBSEARCH:      //조회
 	          if(validateForm(sheetObj,formObj,sAction)){
 	        	 formObj.f_cmd.value = SEARCH;
 	        	 //sheetObj.Visible = false;
 	          	 sheetObj.DoSearch("ESM_BKG_0595GS.do", FormQueryString(formObj)
						+ "&" + ComGetPrefixParam(""));
 	          }
 	         
              break;
           case IBDOWNEXCEL:      // 입력
   				sheetObj.SpeedDown2Excel(-1);
   				break;	

         }
     }



     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
         	switch(sAction) {

					case IBSEARCH: // 조회시 확인
		         		if (!ComChkValid(formObj)) return false;
		         		break;
         	}	
         }
         return true;
     }


	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		
		var formObject = document.form;
		var sorting_priority = ComGetObjText(formObject.sorting_priority);
		
		with(sheetObj)
		{
			//ComOpenWait(true);  //대기이미지 표시			
			for (var i = 1; i <= LastRow; i ++)
			{
				if ("" == CellValue(i, "chg_nm")){
					CellValue2(i, "chg_cd") = CellValue(i, "per");
					CellAlign(i, "chg_cd") = daLeft;
					CellValue2(i, "chg_nm") = CellValue(i, "per");
					CellAlign(i, "chg_nm") = daLeft;
					CellAlign(i, "per") = daLeft;
				}
 				
			}	
		
			var colInxArray = "";
			var lastLow = LastRow;
			var insertRow = 0;
			if (lastLow==1) return;
			
			for (var j = 0; j <= LastRow; j ++)
			{
				if (j < lastLow+insertRow-1){
					if (j==0 || (CellValue(j,"chg_cd") !="" && 
								CellValue(j,"frt_chg_tp_cd") != CellValue(j+1,"frt_chg_tp_cd"))){
						
						if (j ==0){
							colInxArray = j;
							DataInsert(j);
						}else{
							colInxArray = colInxArray + ',' + (j+1);
							DataInsert(j);
						}
						insertRow++;
						
						CellValue2(j+1,"frt_chg_tp_cd") =sheetObj.CellValue(j+2,"frt_chg_tp_cd");
						CellValue2(j+1,"per") = sheetObj.CellValue(j+2,"per_group");
						CellValue2(j+1,"chg_cd") = sheetObj.CellValue(j+2,"per_group");; //sheetObj.CellValue(j+2,"frt_chg_tp_cd");
						if (sorting_priority != ''){
						CellValue2(j+1,"chg_nm") = sorting_priority +" : "+sheetObj.CellValue(j+2,"sorting_priority");
						
						}
						CellAlign(j+1, "chg_cd") = daLeft;
						CellAlign(j+1, "per") = daLeft;
						RowBackColor(j+1) = RgbColor(255,255,192);//RgbColor(192,192,192);
					}
				}else{
					break;
				}
			}
			ShowSubSum("frt_chg_tp_cd", "brate_prepaid", -1, false, false, -1, "per=S/Total");
			SumText(0, "per") = "G/Total";
			//sheetObj.SelectRow = 1;
			sheetObj.SelectCell(1,3);

			//Visible = true;	
			
		}
		
	}
	function openWindowCustomer(formObj){
		var param = FormQueryString(formObj);	
		ComOpenPopup('COM_ENS_041.do?'+param, 780, 470, 'getCOM_ENS_041', '1,0,1,1,1,1,1,1,1,1', true);
	}	
	
	function getCOM_ENS_041(aryPopupData) {
  		var formObject = document.form;
  		var customer= aryPopupData[0][3];
  		
  		ComSetObjValue(formObject.cust_cnt_cd,customer.substr(0,2));
  		ComSetObjValue(formObject.cust_seq,customer.substr(2));
  		//formObject.vsl_cd.value = aryPopupData[0][7];
  		/*
  		ComSetObjValue(formObject.cust_cnt_cd,"");
  		ComSetObjValue(formObject.cust_seq,"");*/
  		
  		//formObject.vsl_cd.value = aryPopupData[0][7];
  	} 
	function setCommodityCd(aryPopupData) {
  		var formObject = document.form;
  		formObject.cmdt_cd.value,formObject.rep_cmdt_cd.value
  		formObject.rep_cmdt_cd.value = aryPopupData[0][5];
  		formObject.cmdt_cd.value= aryPopupData[0][3];;
  		
  	} 
	
	/* 개발자 작업  끝 */