/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0062.js
*@FileTitle : TP/SZ Volume Calculation Terms
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.07 이현주
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
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
     * @class ESM_SPC_0062 : ESM_SPC_0062 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0062() {
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
 var comObjects = new Array();
 var sheetCnt = 0;
 var comboCnt = 0;
 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;
 //retrive check
 var check_retrive = false;
 var tab_retrives = new Array(2);

 //sheetResizeFull = true;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          /*******************************************************/
          var sheetObject = sheetObjects[0];
          var sheetObject1 = sheetObjects[1];

          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
         	    case "btn_retrieve":
//     	            for(var i = 0 ; i < sheetObjects.length; i++){
// 				        tab_retrives[i] = false;
// 				    }
 				    
 				    check_retrive = true;
 				    
     	            if(beforetab==0){
     	            	tab_retrives[0] = true;
     	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);    	            	
     	            }else if(beforetab==1){
     	            	tab_retrives[1] = true;
     	            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);    	            	
     	            }
         	        break;
         	        
         	    case "btn_new":
 					if(checkModifiedSheet(sheetObject)) {
 						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
 							return;
 						}
 					}
 	            	//공통함수사용: 화면을 초기화
 					resetAll(); 
 					for(var i = 0 ; i < sheetObjects.length ; i++){
 				        tab_retrives[i] = false;
 				    }
 				    check_retrive = false;
 					break;
 					    
                 case "btn_downexcel":
     	            if(beforetab==0){
     	            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
     	            }else if(beforetab==1){
     	            	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
     	            }
                     break;

                 case "btn_save":
 					if(beforetab==0){
     	            	doActionIBSheet(sheetObject,formObject,IBSAVE);
     	            }else if(beforetab==1){
     	            	doActionIBSheet(sheetObject1,formObject,IBSAVE);
     	            }
 					break;
 				case "btn_downexcel":
 					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
 					break;
 				case "btng_rowadd":
 					if(beforetab==1){
     	            	doActionIBSheet(sheetObject1,formObject,IBINSERT);
     	            }
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

 	
 	/**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj){
 		comObjects[comboCnt++] = combo_obj;
     }
     

     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i]);

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         var sheetResizeFull = true;
 		document_onresize();

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }
     	tab_retrives[0] = false;
 		tab_retrives[1] = false;
 		check_retrive = true;
 		
		initSheetCombo_lane();
		initSheetCombo_bound();

 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }

     function initSheetCombo_lane() {
    	 var sheetObject  = sheetObjects[1];
         
         var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=");
         
         var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
         arrData[0] = "00000|" + arrData[0];
         arrData[1] = "\t\tALL\t|" + arrData[1];
         sheetObject.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
     }
     
     function initSheetCombo_bound() {
    	 var sheetObject  = sheetObjects[1];
         
         var bound = " |E|W|S|N";
         sheetObject.InitDataCombo(0, "dir_cd", bound, bound);
     }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                     with (sheetObj) {
                     // 높이 설정
                     //style.height = 280;
                     style.height = GetSheetHeight(22);
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
                     FocusEditMode = default_edit_mode;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 5, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(11, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "STS|SEQ|Type|Within Sub Alloc|Within Sub Alloc|Within Sub Alloc|Within Sub Alloc|Over Sub Alloc|Over Sub Alloc|Over Sub Alloc|Over Sub Alloc";
                     var HeadTitle2 = "STS|SEQ|Type|20'|40'|HC|45'|20'|40'|HC|45'";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtStatus,  30,    daCenter,  true,      "ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq, 50,    daCenter,  true,      "",      false,          "",             dfNone,   0,     false,       true);
                     InitDataProperty(0, cnt++ , dtData,    100,    daCenter,  true,     "vsl_own_ind_cd",     true,          "",      dfNone,      0,     false,       true,          2, 	true, false);
                     InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "teu_20ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "teu_40ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "teu_40ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "teu_45ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
 					 InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "ovr_teu_20ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "ovr_teu_40ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "ovr_teu_40ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    80,    daRight,   false,     "ovr_teu_45ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
     				
     				 MaximumValue(0,"teu_20ft_conv_rto") = "4.0";
     				 MaximumValue(0,"teu_40ft_conv_rto") = "4.0";
     				 MaximumValue(0,"teu_40ft_hc_conv_rto") = "4.0";
     				 MaximumValue(0,"teu_45ft_hc_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_20ft_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_40ft_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_40ft_hc_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_45ft_hc_conv_rto") = "4.0";
     				
                }
                 break;
             case 2:     //sheet2 init
                 with (sheetObj) {
                     // 높이 설정
                     //style.height = 257;
                     style.height = GetSheetHeight(21);
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
 					 FocusEditMode = default_edit_mode;
 					
                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 5, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "Del.|STS|SEQ|Lane|Bound|Operator|Within Sub Alloc|Within Sub Alloc|Within Sub Alloc|Within Sub Alloc|Over Sub Alloc|Over Sub Alloc|Over Sub Alloc|Over Sub Alloc";
                     var HeadTitle2 = "Del.|STS|SEQ|Lane|Bound|Operator|20'|40'|HC|45'|20'|40'|HC|45'";
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++,  dtDelCheck, 30,   daCenter,  true,			"");
                     InitDataProperty(0, cnt++ , dtStatus,  30,    daCenter,  true,      "ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq, 50,    daCenter,  true,      "",      false,          "",             dfNone,   0,     true,       true);
                     InitDataProperty(0, cnt++ , dtCombo,   100,   daCenter,  true,      "rlane_cd",     true,          "",      dfNone,      0,     false,       true,          5);
                     InitDataProperty(0, cnt++ , dtCombo,   80,    daCenter,  true,      "dir_cd",     true,          "",      dfNone,      0,     false,       true,          1);
                     InitDataProperty(0, cnt++ , dtData,    80,    daCenter,  true,      "crr_cd",     true,          "",      dfEngUpKey,      0,     false,       true,          4);
                     InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "teu_20ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "teu_40ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "teu_40ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "teu_45ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
 					 InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "ovr_teu_20ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "ovr_teu_40ft_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "ovr_teu_40ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                     InitDataProperty(0, cnt++ , dtData,    60,    daRight,   false,     "ovr_teu_45ft_hc_conv_rto",     false,          "",     dfFloat,      2,     true,       true,          3);
                    
// 					 initSheetCombo_lane(sheetObj, 0, 3);
// 					 initSheetCombo_bound(sheetObj, 0, 4);	
 					 MaximumValue(0,"teu_20ft_conv_rto") = "4.0";
     				 MaximumValue(0,"teu_40ft_conv_rto") = "4.0";
     				 MaximumValue(0,"teu_40ft_hc_conv_rto") = "4.0";
     				 MaximumValue(0,"teu_45ft_hc_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_20ft_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_40ft_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_40ft_hc_conv_rto") = "4.0";
     				 MaximumValue(0,"ovr_teu_45ft_hc_conv_rto") = "4.0";					
               }
                 break;

         }
     }
     
  
     // Sheet1관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;

         switch(sAction) {

             case IBSEARCH:      //조회
                 if(beforetab==0){	
                		formObj.f_cmd.value = SEARCHLIST01;
                		tab_retrives[0] = true;
                		//sheetObj.DoSearch4Post("ESM_SPC_0062GS.do", FormQueryString(formObj));
                		sheetObj.DoSearch4Post("ESM_SPC_0062GS.do", "f_cmd=" + formObj.f_cmd.value);
                 }else if(beforetab==1){
                 	    formObj.f_cmd.value = SEARCHLIST02;	
                 	    tab_retrives[1] = true;
                 	    //sheetObj.DoSearch4Post("ESM_SPC_0062GS.do", FormQueryString(formObj));
                 	   sheetObj.DoSearch4Post("ESM_SPC_0062GS.do", "f_cmd=" + formObj.f_cmd.value);
                 }
                 break;

             case IBDOWNEXCEL:        //엑셀 다운로드
                 sheetObj.SpeedDown2Excel(-1);
                 break;
             
             case IBSAVE:		//저장					
 			    if(beforetab==0){	
                		formObj.f_cmd.value = MULTI01;
                 }else if(beforetab==1){
                 	var tran_rows = sheetObj.FindStatusRow("I|U");
 				    if(!checkFormat(sheetObj,tran_rows)) {
 				        return false;
 				    }
                 	formObj.f_cmd.value = MULTI02;	
                 }
 				//var rtn = doSaveSheet(sheetObj, "ESM_SPC_0062GS.do", FormQueryString(formObj));
                var rtn = doSaveSheet(sheetObj, "ESM_SPC_0062GS.do", "f_cmd=" + formObj.f_cmd.value);
 				break;
 				
 			case IBINSERT:      // 입력				
             	var Row = sheetObj.DataInsert();
 				break;
 				
 			case IBDOWNEXCEL:		 //엑셀 다운로드
 				sheetObj.Down2Excel();
 				break;    
         }
     }

   
     /**
      * IBTab Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++] = tab_obj;
 		 tab_retrives[tabCnt++] = false;
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
                     InsertTab( cnt++ , "Standard" , -1 );
                     InsertTab( cnt++ , "Exception" , -1 );
                 }
              break;

          }
     }

      
     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var formObj = document.form;
         var objs = document.all.item("tabLayer");
 				
     	 objs[nItem].style.display = "Inline";
     	 objs[beforetab].style.display = "none";

     	 //--------------- 요기가 중요 --------------------------//
     	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	 //------------------------------------------------------//
     	 beforetab= nItem;
     	 if(check_retrive && !tab_retrives[beforetab]){  
             if(beforetab==0){	
 				sheetObjects[0].Redraw = false;
 				tab_retrives[0] = true;
            	formObj.f_cmd.value = SEARCHLIST01;
            	//sheetObjects[0].DoSearch4Post("ESM_SPC_0062GS.do", FormQueryString(formObj));
            	sheetObjects[0].DoSearch4Post("ESM_SPC_0062GS.do", "f_cmd=" + formObj.f_cmd.value);
             	sheetObjects[0].Redraw = true; 		
             }else if(beforetab==1){
             	sheetObjects[1].Redraw = false;
             	tab_retrives[1] = true;
 			    formObj.f_cmd.value = SEARCHLIST02;	
             	//sheetObjects[1].DoSearch4Post("ESM_SPC_0062GS.do", FormQueryString(formObj));
             	sheetObjects[1].DoSearch4Post("ESM_SPC_0062GS.do", "f_cmd=" + formObj.f_cmd.value);
             	sheetObjects[1].Redraw = true; 	             	        	
             }	
     	 }
     }
     

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     /* validation check
 	 * 
 	 */
 	function checkFormat(sheetObj, trans_rows){
    		var arrRow = trans_rows.split(";");
    
    		for(var idx = 0; idx < arrRow.length-1; idx++) {          
      		var rlane_cd = sheetObj.CellValue(arrRow[idx], "rlane_cd");
      		var dir_cd = sheetObj.CellValue(arrRow[idx], "dir_cd");  
 			var crr_cd = sheetObj.CellValue(arrRow[idx], "crr_cd");

       		if(rlane_cd == "") {              	
       			ComShowMessage(getMsg("SPC90117", "Lane"));
          		sheetObj.SelectCell(arrRow[idx], "rlane_cd", true);
          		return false;   
       		} 

       		if(dir_cd == "0"|| dir_cd == "") {              	
       			ComShowMessage(getMsg("SPC90117", "Bound"));
          		sheetObj.SelectCell(arrRow[idx], "dir_cd", true);
          		return false;   
       		} 
       		if(crr_cd == "") {              	
       			ComShowMessage(getMsg("SPC90117", "Operator"));
          		sheetObj.SelectCell(arrRow[idx], "crr_cd", true);
          		return false;   
       		}     
    		}
    		return true;
 	} 
     

      
	/* 개발자 작업  끝 */