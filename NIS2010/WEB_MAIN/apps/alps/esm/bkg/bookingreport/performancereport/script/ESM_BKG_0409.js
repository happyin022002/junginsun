/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0409.js
*@FileTitle : Performance Report by Error
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.10 김기종
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
     * @class ESM_BKG_0409 : ESM_BKG_0409 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0409() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수


 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
	var comboObjects = new Array();
	
  
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	} 	
	

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
				
				case "btn_new":
					ComResetAll();	
					sheetObject1.RemoveAll();
					ComSetObjValue(formObject.from_dt,"");
					ComSetObjValue(formObject.from_mt,"");
					ComSetObjValue(formObject.to_dt,"");
					ComSetObjValue(formObject.to_mt,"");
					
				break; 
				
				case "btn_downexcel":
 					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
         
         //MultiCombo초기화 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
         
         //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         initControl();
     }
      
      /**
	 	 * Combo 기본 설정 
	 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject = document.form
				initComboEditable(comboObj, comboId)
	 	}
	 	
	 //콤보 멀티 셀렉트 및 수정 여부 초기 설정
	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
	 	 		 if(comboId == "doc_part"){
	 	 			DropHeight = 150;
		 	 		MultiSelect = true;
		 	 		UseEdit = false;	 	 	
	 	 		}
	 	 		else{
	 	 			DropHeight = 150;
		 	 		MultiSelect = false;
			 	  UseEdit = false;	 	 			
	 	 			
	 	 		}
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
     	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); //- 포커스 나갈때
  	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); //- 포커스 들어갈때
  	   
     	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	
     	
     	ComSetObjValue(formObject.from_dt,ComGetNowInfo());
     	ComSetObjValue(formObject.to_dt,ComGetNowInfo());
     	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
                     style.height = 240;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     
                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

					 var HeadTitle1 = "|Seq.|Queue|PIC|SI Kind|Amend Reason|Booking No.|VVD|POL|POD|||||";
                     var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     
                     //데이터속성    [ROW, COL,  DATATYPE,   			WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	0,			daCenter,	true,	"Status");
                     InitDataProperty(0, cnt++ , dtSeq,				50,			daCenter,	true,		"Seq");
                     InitDataProperty(0, cnt++ , dtData,			120,		daCenter,	true,		"usr_grp_nm",			false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		"amd_respb_usr_id",		false,          "",      dfNone,			0,     true,       true);
                     //InitDataProperty(0, cnt++ , dtHiddenStatus,			110,		daCenter,	true,		"sr_amd_tp_nm",			false,          "",      dfNone,			0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtData,			130,		daCenter,	true,		"sr_amd_tp_nm",			false,			"",		 dfNone,			0,	   true,	   true);
                     InitDataProperty(0, cnt++ , dtData,			120,		daCenter,	true,		"rsn_nm",				false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		"bkg_no",				false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		"vvd_cd",				false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		"pol_cd",				false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		"pod_cd",				false,          "",      dfNone,			0,     true,       true);
                     
                     InitDataProperty(0, cnt++ , dtHidden,			120,		daCenter,	true,		"usr_grp_cd",			false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,			110,		daCenter,	true,		"sr_amd_rsn_tp_cd",		false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,			110,		daCenter,	true,		"sr_amd_rsn_cd",		false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,			110,		daCenter,	true,		"pre_sr_no_amd_tp_cd",	false,          "",      dfNone,			0,     true,       true);
                     InitDataProperty(0, cnt++ , dtHidden,			110,		daCenter,	true,		"sr_amd_tp_cd",			false,          "",      dfNone,			0,     true,       true);
                     
                     SelectionMode = smSelectionRow ;

                 }
                 break;
         }
     }

     // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	 var formObj = document.form;
    	 
    	 var tot_inputter	=	0;		
    	 var tot_amend           =	0;
    	 var tot_carrier         =	0;
    	 var tot_mis_typing      =	0;
    	 var tot_data_missing    =	0;
    	 var tot_rater           =	0;
    	 var tot_return          =	0;
    	 var tot_mrchant         =	0;
    	 var tot_wrong_data      =	0;
    	 var tot_unclear_fax     =	0;
    	 var tot_auditor         =	0;
    	 var tot_sc_mis_rating   =	0;
    	 var tot_bl_data_change  =	0;
    	 var tot_f_ofc           =	0;
    	 var tot_sr_vol          =	0;
    	 var tot_rfa_mis_rating  =	0;
    	 var tot_cod             =	0;
    	 var tot_sales           =	0;
    	 var tot_split_combine   =	0;
    	 var tot_f_ofc_error     =	0;
    	 
		with(sheetObj){
			
			for(var i = 1; i <= RowCount  ; i ++){
				//CellBackColor(i ,"Seq") = RgbColor(15,723,503);
				//ReadDataProperty(0, 0, dpDataType);
				//return;
				 
				/*
				Inputte		sum( if(Queue='I', 1, 0) for all DISTINCT)  
				Rater		sum( if(Queue='R', 1, 0) for all DISTINCT)  
				Audito		sum( if(Queue='A', 1, 0) for all DISTINCT)  
				F/OFC		sum( if(Queue='S', 1, 0) for all DISTINCT)  
				Amend		sum( if (S/R  Kind='A',1,0) for all )
				Return		sum( if (S/R  Kind='R',1,0) for all )
				S/R  Vol		sum( if (S/R   all )
				Carrier		sum( if (PRE_SR_NO_AMD_TP_CD='C', 1, 0) for all )
				Merchant		sum( if (PRE_SR_NO_AMD_TP_CD='M', 1, 0) for all )
				Mis-Typing		sum ( if (Error  Reason='I1',1,0) for all )
				Wrong Data		sum ( if (Error  Reason='I2',1,0) for all )
				Mis-rating (S/C		sum ( if (Error  Reason='R1',1,0) for all )
				Mis-rating (RFA)		sum ( if (Error  Reason='R2',1,0) for all )
				Sales		sum ( if (Error  Reason='F1',1,0) for all )
				F/OFC Error		sum ( if (Error  Reason='F2',1,0) for all )
				Data Missing		sum ( if (Error  Reason='DM', 1, 0) for all )
				Unclear Fax		sum ( if (Error  Reason='UF', 1, 0) for all )
				B/L Data Change		sum ( if (Error  Reason='BL', 1, 0) for all )
				COD		sum ( if (Error  Reason='CD', 1, 0) for all )
				Split / Combine		sum ( if (Error  Reason='SP', 1, 0) for all )
				*/
				
				/*1.Inputte*/
				if (CellValue(i, "usr_grp_cd") == "I"){
					tot_inputter++;
				/*2.Rater	*/
				}else if (CellValue(i, "usr_grp_cd") == "R"){
					tot_rater++;
				/*3.Audito	*/
				}else if (CellValue(i, "usr_grp_cd") == "A"){	
					tot_auditor++;
				/*4.F/OFC	*/
				}else if (CellValue(i, "usr_grp_cd") == "S"){	
					tot_f_ofc++;
				}
				
				/*1.Amend	*/
				if (CellValue(i, "sr_amd_tp_cd") == "A"){ //AMEND
					tot_sr_vol++;
					tot_amend ++; // 현재 값 없음.
				/*2.Return	*/
				}else if (CellValue(i, "sr_amd_tp_cd") == "R"){  //RETURN
					tot_sr_vol++;
					tot_return++; // 현재 값 없음.
				}
				if (CellValue(i, "sr_amd_rsn_tp_cd") == "C"){
					tot_carrier++;
				}else if (CellValue(i, "sr_amd_rsn_tp_cd") == "M"){
					tot_mrchant++;
				}
			
				
				/*1.Mis-Typing*/
				if (CellValue(i, "sr_amd_rsn_cd") == "I1"){
					tot_mis_typing++;
				/*2.Wrong Data	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "I2"){
					tot_wrong_data++;
				/*3.Mis-rating (S/C	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "R1"){	
					tot_sc_mis_rating++;
				/*4.Mis-rating (RFA)	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "R2"){	
					tot_rfa_mis_rating++;
				/*5.Sales	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "F1"){
					tot_sales++;
				/*6.F/OFC Error	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "F2"){
					tot_f_ofc_error++;
				/*7.Data Missing	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "DM"){
					tot_data_missing++;
				/*8.Unclear Fax	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "UF"){
					tot_unclear_fax++;
				/*9.B/L Data Change	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "BL"){
					tot_bl_data_change++;
				/*10.COD	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "CD"){
					tot_cod++;
				/*11.Split / Combine	*/
				}else if (CellValue(i, "sr_amd_rsn_cd") == "SP"){
					tot_split_combine++;
				}
			}
		}
		
		ComSetObjValue(formObj.tot_inputter	        ,tot_inputter      ) ;	
		ComSetObjValue(formObj.tot_amend            ,tot_amend         ) ;    
		ComSetObjValue(formObj.tot_carrier          ,tot_carrier       ) ;    
		ComSetObjValue(formObj.tot_mis_typing       ,tot_mis_typing    ) ;    
		ComSetObjValue(formObj.tot_data_missing     ,tot_data_missing  ) ;    
		ComSetObjValue(formObj.tot_rater            ,tot_rater         ) ;    
		ComSetObjValue(formObj.tot_return           ,tot_return        ) ;    
		ComSetObjValue(formObj.tot_mrchant          ,tot_mrchant       ) ;    
		ComSetObjValue(formObj.tot_wrong_data       ,tot_wrong_data    ) ;    
		ComSetObjValue(formObj.tot_unclear_fax      ,tot_unclear_fax   ) ;    
		ComSetObjValue(formObj.tot_auditor          ,tot_auditor       ) ;    
		ComSetObjValue(formObj.tot_sc_mis_rating    ,tot_sc_mis_rating ) ;    
		ComSetObjValue(formObj.tot_bl_data_change   ,tot_bl_data_change) ;    
		ComSetObjValue(formObj.tot_f_ofc            ,tot_f_ofc         ) ;    
		ComSetObjValue(formObj.tot_sr_vol           ,tot_sr_vol        ) ;    
		ComSetObjValue(formObj.tot_rfa_mis_rating   ,tot_rfa_mis_rating) ;    
		ComSetObjValue(formObj.tot_cod              ,tot_cod           ) ;    
		ComSetObjValue(formObj.tot_sales            ,tot_sales         ) ;    
		ComSetObjValue(formObj.tot_split_combine    ,tot_split_combine ) ;    
		ComSetObjValue(formObj.tot_f_ofc_error      ,tot_f_ofc_error   ) ;       
		
     }
   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

         	case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = COMMAND01;
				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0409GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.doc_part,"val", "name");
				
				if (arrXml.length > 1) 
					ComXml2ComboItem(arrXml[1], formObj.sr_amd_rsn_cd, "val", "name");
					
				if (arrXml.length > 0) 
					ComXml2ComboItem(arrXml[0], formObj.usr_grp_cd, "val", "name");
				
					
				
				formObj.usr_grp_cd.DropHeight = 150;
				formObj.usr_grp_cd.UseAutoComplete = true;
				formObj.usr_grp_cd.Index =0; 

				formObj.sr_amd_rsn_cd.DropHeight = 150;
				formObj.sr_amd_rsn_cd.UseAutoComplete = true;
				formObj.sr_amd_rsn_cd.Index =0; 
				
				break;
         	case IBSEARCH:      //조회
         	

				if(validateForm(sheetObj,formObj,sAction)){
		        	  formObj.f_cmd.value = SEARCH;
		        	  sheetObj.DoSearch("ESM_BKG_0409GS.do", FormQueryString(formObj)
								+ "&" + ComGetPrefixParam(""));
				}	  
		        break;
		        
         	case IBDOWNEXCEL:      // 입력
   				//sheetObj.Down2Excel();
         	    sheetObj.speedDown2Excel(-1);
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
      
     /**
      * ETD,ETB 기간 선택 달력 띄우기
      */
   	function callDatePop(val){
   		var cal = new ComCalendarFromTo();
   		cal.select(form.from_dt,  form.to_dt,  'yyyy-MM-dd');
   	}
   	
    
	/* 개발자 작업  끝 */