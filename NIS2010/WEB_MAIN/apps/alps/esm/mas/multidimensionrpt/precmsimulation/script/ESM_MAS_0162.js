/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_MAS_0162.js
*@FileTitle : Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : Young-Heon Lee
*@LastVersion : 1.0
* 2016.06.22 Young-Heon Lee
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
     * @class ESM_MAS_0162 : ESM_MAS_0162 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0162() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;
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
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 
 
	 /** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     *
	 * @return 없음
	 */ 
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
 		 var sheetObject2 = sheetObjects[1];

          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            
            	case "btn_SchgDtl": 
            		doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
            		break;

                 case "btn_Add":
                	 doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                     break; 
                      
                 case "btn_Delete":
                	 doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
 					 break;

                 case "btn_Save":
                	 doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                     break;
                     
                 case "btn_downexcel":
 					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
 					break;
 					
 				 case "btn_Close":
 					 self.close();
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
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * </pre>
      *
   	 * @param  {object}   sheet_obj 필수, sheet Object
   	 * @return 없음
   	 */ 
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     /**                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
      * IBMultiCombo Object를 배열로 등록 <br>                                                                                                                                                                                                                                                                                                                                                                                                                                       
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>                                                                                                                                                                                                                                                                                                                                                                                      
      * 배열은 소스 상단에 정의 <br>                                                                                                                                                                                                                                                                                                                                                                                                                                                 
      * <br><b>Example :</b>                                                                                                                                                                                                                                                                                                                                                                                                                                                         
      * <pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
      *     setComboObject(combo_Obj);                                                                                                                                                                                                                                                                                                                                                                                                                                               
      * </pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
      * @param {ibcombo} combo_obj 필수 IBMultiCombo Object                                                                                                                                                                                                                                                                                                                                                                                                                          
      * @return 없음                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
      * @author 김재연                                                                                                                                                                                                                                                                                                                                                                                                                                                               
      * @version 2009.07.28                                                                                                                                                                                                                                                                                                                                                                                                                                                          
      */                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
     function setComboObject(combo_obj) {                                                                                                                                                                                                                                                                                                                                                                              
  		comboObjects[comboCnt++] = combo_obj;                                                                                                                                                                                                                                                                                                                                                                                                                               
  	}


   	/** 
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * </pre>
   	 * 
   	 * @return 없음
   	 */ 
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         ComOpenWait(true);
         loadInitData();
         
         initButtons();
         ComOpenWait(false);
     }
       
     /**  
      * 화면 loading시 최초 버튼 상태를 설정한다.
      *  
      * <br><b>Example :</b>
      * <pre>
      *   initButtons();
      * </pre>
      * 
      * @return 없음
      */    
     function initButtons(){
    	 ComBtnDisable("btn_Add");
    	 ComBtnDisable("btn_Delete");
     }
     /**  
      * 화면 loading시 필요한 최초 데이터를 조회해서<br>
      * 화면에 Setting 해 놓는다.
      *  
      * <br><b>Example :</b>
      * <pre>
      *   loadInitData();
      * </pre>
      * 
      * @return 없음
      */       
     function loadInitData( ){
    	 var formObj = document.form;
    	 var idx = sheetObjects[0].DataInsert(-1);
    	 sheetObjects[0].CellValue2(idx, "por_cd") = formObj.por_cd.value;
    	 sheetObjects[0].CellValue2(idx, "pol_cd") = formObj.pol_cd.value;
    	 sheetObjects[0].CellValue2(idx, "pod_cd") = formObj.pod_cd.value;
    	 sheetObjects[0].CellValue2(idx, "del_cd") = formObj.del_cd.value;
    	 
    	 sheetObjects[0].CellValue2(idx, "r_term") = ComGetObjValue(formObj.r_term);
    	 sheetObjects[0].CellValue2(idx, "d_term") = ComGetObjValue(formObj.d_term);
    	 if (ComGetObjValue(formObj.cntr_tpsz_cd) == "D2" || ComGetObjValue(formObj.cntr_tpsz_cd) == "D4" || ComGetObjValue(formObj.cntr_tpsz_cd) == "D5" || ComGetObjValue(formObj.cntr_tpsz_cd) == "D7") {
    		 sheetObjects[0].CellValue2(idx, "cntr_tpsz_cd") = ComGetObjValue(formObj.cntr_tpsz_cd);
    	 }
    	 sheetObjects[0].CellValue2(idx, "prc_cgo_tp_cd") = "DR";
    	 sheetObjects[0].CellValue2(idx, "cntr_qty") = formObj.cntr_qty.value;

    	 doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
    	 
    	 var comboObj = comboObjects[0];
    	 
    	 comboObj.DropHeight = 200;
    	 comboObj.MultiSelect = false;
    	 comboObj.MaxSelect = 1;
    	 comboObj.UseAutoComplete = true;
    	 
    	 if (formObj.por_cd.value != "" && formObj.del_cd.value != "") {
    		 getSvcScpCd(formObj.por_cd.value, formObj.del_cd.value);
    	 }
     }
     /**  
     * Combo에서 필요한 코드를 조회해서 Combo에 Set한다.
     * 화면에 Setting 해 놓는다.
     *  
     * <br><b>Example :</b>
     * <pre>
     *   initCombo(formObj);
     * </pre>
     * 
     * @param {object} formObj 필수, html document form Object
     * @return 없음
     */         
     function initCombo(formObj){
    	var scgDtlSheetObj = sheetObjects[1];
    	
   	 	//surcharge scope cd combo
		formObj.f_cmd.value = COMMAND12;
		var sXml = scgDtlSheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+ComGetObjValue(formObj.svc_scp_cd));
		setIBCombo(scgDtlSheetObj,sXml,"chg_cd",true,0,"","",true);
		
    	 //currency combo
		formObj.f_cmd.value = COMMAND16;
		var sXml = scgDtlSheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		setIBCombo(scgDtlSheetObj,sXml,"curr_cd",true,0,"USD");
			
		// per combo
		formObj.f_cmd.value = COMMAND18;
		sXml = scgDtlSheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		setIBCombo(scgDtlSheetObj, sXml, "rat_ut_cd", true, 0);
     }
     

   	/** 
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {String} sheetNo 필수, sheet의 ID
   	 * @return 없음
   	 */ 
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;
         sheetObj.WaitImageVisible = false;
         switch(sheetObj.id) {
              case "sheet1":      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 90;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     MultiSelection = false;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Route|Route|Route|Route|R/D Term|R/D Term|Type/Size|Cargo Type|Qty.|OFT|Total\nSurcharge|Total\nRevenue";
 					var HeadTitle2 = "|POR|POL|POD|DEL|R|D|Type/Size|Cargo Type|Qty.|OFT|Total\nSurcharge|Total\nRevenue";
 					var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);


                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                    
 					InitDataProperty(0, cnt++ , dtData,				60,   	daCenter,  	true,		"por_cd",   			false,          "",      dfNone,      		0,			false,      true, 5);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"pol_cd",   			false,          "",      dfNone,      		0,			false,      true, 5);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"pod_cd",   			false,          "",      dfNone,      		0,			false,      true, 5);
 					InitDataProperty(0, cnt++ , dtData,    			60,   	daCenter,  	true,		"del_cd",   			false,          "",      dfNone,      		0,			false,      true, 5);
 					InitDataProperty(0, cnt++ , dtCombo,    			40,   	daCenter,  	true,		"r_term",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtCombo,    			40,   	daCenter,  	true,		"d_term",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtCombo,    			65,   	daCenter,  	true,		"cntr_tpsz_cd",   			false,          "",      dfNone,      		0,			false,      true);
 					InitDataProperty(0, cnt++ , dtData,    			80,   	daCenter,  	true,		"prc_cgo_tp_cd",   			false,          "",      dfNone,      		0,			false,      false);
 					InitDataProperty(0, cnt++ , dtData,    			40,   	daCenter,  	true,		"cntr_qty",   			false,          "",      dfNone,      		0,			true,      true);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daRight,  	true,		"oft_amt",   			false,          "",      dfFloat,      	2,			true,       true);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daRight,  	true,		"tot_surcharge",   			false,          "",      dfFloat,      	2,			false,       false);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daRight,  	true,		"tot_rev",   			false,          "",      dfFloat,      	2,			false,       false);
 					
 					InitDataValid(0, "por_cd", vtEngUpOnly);
 					InitDataValid(0, "pol_cd", vtEngUpOnly);
 					InitDataValid(0, "pod_cd", vtEngUpOnly);
 					InitDataValid(0, "del_cd", vtEngUpOnly);
 					InitDataValid(0, "cntr_qty", vtNumericOnly);
 					InitDataCombo(0, "cntr_tpsz_cd", "D2|D4|D5|D7", "D2|D4|D5|D7");

 					CountPosition = 0;
                }
                break;

 			   case "sheet2":      //sheet2 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 260;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     MultiSelection = false;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 15, 100);

                     var HeadTitle1 = "|Sel.|Seq.|Surcharge\nCode|Per|Cur.|Total Amount|Total Amount|Total Amount|Application|";
 					 var HeadTitle2 = "|Sel.|Seq.|Surcharge\nCode|Per|Cur.|Local|USD|Tariff|Application|";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);
					
					

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                     
 					InitDataProperty(0, cnt++ , dtCheckBox,		40,   	daCenter,  	true,		"del_chk",   			false,          "",      dfNone,      		0,			true,		true);
 					InitDataProperty(0, cnt++ , dtSeq,    			40,   	daCenter,  	true,		"seq",   			false,          "",      dfNone,      		0,			false,		true);
 					InitDataProperty(0, cnt++ , dtComboEdit,    			80,   	daCenter,  	true,		"chg_cd",   			true,          "",      dfNone,      		0,			false,      true,3);
 					InitDataProperty(0, cnt++ , dtCombo,    			60,   	daCenter,  	true,		"rat_ut_cd",   			true,          "",      dfNone,      		0,			false,      true,2);
 					InitDataProperty(0, cnt++ , dtCombo,    			80,   	daCenter,  	true,		"curr_cd",   			true,          "",      dfNone,      		0,			false,      true,3);
 					InitDataProperty(0, cnt++ , dtData,			100,   	daRight,  	true,		"scg_amt",   			true,          "",      dfFloat,      	2,			false,       true,12);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daRight,  	true,		"adj_scg_usd_amt",   			false,          "",      dfFloat,      	2,			false,      false);
 					InitDataProperty(0, cnt++ , dtData,    			100,   	daRight,  	true,		"trf_scg_amt",   			false,          "",      dfFloat,      	2,			false,      false);
 					InitDataProperty(0, cnt++ , dtCombo,    			0,   	daCenter,  	true,		"trf_rmk",   			false,          "",      dfNone,      		0,			true,      true);
 					InitDataProperty(0, cnt++ , dtHidden,				0,   	daCenter,  	true,		"svc_scp_cd",   			false,          "",      dfNone,      		0,			false,      false);

 					InitDataValid(0, "chg_cd", vtEngUpOnly);	// 영문대문자만 입력
 					InitDataCombo(0, "trf_rmk", " |Inclusive|Fixed rate", "0|1|2");

 					CountPosition = 0;
                }
                break;
         }
     }


  	/** 
     * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * </pre>
  	 * @param {object} sheetObj 필수, sheet Object
  	 * @param {object} formObj 필수, html document form Object
  	 * @param {int} sAction 필수, action의 구분
  	 * @return 없음
  	 */    
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
         
         	case IBCLEAR:        //저장
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0162GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					var arrData = ComXml2ComboString(arrXml[0], "code", "name");
					sheetObjects[0].CellComboItem(2, "r_term", arrData[0], arrData[0]);
				if (arrXml.length > 1)
					var arrData = ComXml2ComboString(arrXml[0], "code", "name");
					sheetObjects[0].CellComboItem(2, "d_term", arrData[0], arrData[0]);
//				if (arrXml.length > 2)
//					ComMasSetIBCombo(sheetObjects[0], arrXml[2], "cntr_tpsz_cd", false, 0);
				ComOpenWait(false);
				break;

 			case IBSEARCH:      //조회
 				ComOpenWait(true);
 				if( !validateForm(sheetObjects[0], document.form, sAction) ){
 					ComOpenWait(false);
 					return false;
 				}
 				formObj.f_cmd.value = SEARCH;
 				var sheetObject = sheetObjects[0];
 				formObj.por_def_cd.value = sheetObject.CellValue(2, "por_cd");
 				formObj.pol_def_cd.value = sheetObject.CellValue(2, "pol_cd");
 				formObj.pod_def_cd.value = sheetObject.CellValue(2, "pod_cd");
 				formObj.del_def_cd.value = sheetObject.CellValue(2, "del_cd");
 				formObj.prc_rcv_term_cd.value = sheetObject.CellValue(2, "r_term");
 				formObj.prc_de_term_cd.value = sheetObject.CellValue(2, "d_term");
 				formObj.rat_ut_cd.value = sheetObject.CellValue(2, "cntr_tpsz_cd");
 				formObj.prc_cgo_tp_cd.value = sheetObject.CellValue(2, "prc_cgo_tp_cd");
 				formObj.cntr_qty.value = sheetObject.CellValue(2, "cntr_qty");
 				formObj.eff_dt.value = ComGetNowInfo('ymd', '-');
 				formObj.exp_dt.value = formObj.eff_dt.value;
 				
 				sheetObj.DoSearch("ESM_MAS_0162GS.do", masFormQueryString(formObj));
 				if (sheetObj.CellValue(2, "svc_scp_cd") != "") {
 					initCombo(formObj);
 				}
 				ComOpenWait(false);
                break;

 			case IBSAVE:        //저장
 				if (sheetObj.CellValue(sheetObj.LastRow,"tot_rev") != 0) {
 					comPopupSend(sheetObj, formObj);
 				}
				break;
				
 			case IBINSERT:      // 입력
 				var idx = sheetObj.DataInsert(-1);
 				sheetObj.CellValue2(idx, "trf_rmk") = 2;
				
				break;
 			case IBDELETE: //삭제
 				var arrRow = sheetObj.FindCheckedRow("del_chk").split("|");
 				var totalSchg = 0.0;
            	
            	for(var i = 0 ; i < arrRow.length - 1 ; i++) {
            		sheetObj.RowDelete(arrRow[i] - i, false);
            	}
            	
           		totalSchg = calcTotalValue(sheetObj,"adj_scg_usd_amt");
        		sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_surcharge") = totalSchg;
        		sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_rev") = eval(sheetObjects[0].Cellvalue(2, "oft_amt")) + totalSchg;
				break;
				
 			case IBDOWNEXCEL :
 				if (sheetObjects[1].RowCount > 0) {
 					sheetObjects[0].Down2Excel(-1, false, false, true);
 					sheetObjects[1].Down2Excel(-1, true, false, true);
 				} else {
 					sheetObjects[0].Down2Excel(-1);
 				}
 				break;
         }
     }

     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */    
   	function sheet1_OnChange(sheetObj,row,col,value){
		var colname = sheetObj.ColSaveName(col);
		if (colname == "por_cd" || colname == "del_cd") {
			if (sheetObj.Cellvalue(row, "por_cd") != "" && sheetObj.Cellvalue(row, "del_cd") != "") {
				getSvcScpCd(sheetObj.Cellvalue(row, "por_cd"), sheetObj.Cellvalue(row, "del_cd"));
			}
		}
   		if (colname == "oft_amt") {
   			sheetObj.CellValue2(row,"tot_rev") = calcTotalValue(sheetObjects[1], "adj_scg_usd_amt") + eval(sheetObj.Cellvalue(row, "oft_amt"));
   		}
   	}
     
     /** 
      * sheet의 내용이 변경 되었을때 자동 호출됨 
      * <br><b>Example :</b>
      * <pre>
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경된 row index
      * @param {int} col 필수, 변경된 col index
      * @param {string} value 필수, 변경된 cell의 값
      * @return 없음
      */    
   	function sheet2_OnChange(sheetObj,row,col,value) {
		var colname = sheetObj.ColSaveName(col);  
   		if (colname == "curr_cd" || colname == "scg_amt" || colname == "trf_rmk") {
   			if (colname == "trf_rmk") {
   				if (sheetObj.Cellvalue(row, "trf_rmk") == "1") {
   	   				sheetObj.CellEditable(row,"scg_amt") = false;
   	   				sheetObj.Cellvalue2(row, "scg_amt") = 0;
   	   			} else if (sheetObj.Cellvalue(row, "trf_rmk") == "2") {
   	   				sheetObj.CellEditable(row,"scg_amt") = true;
   	   			} else {
   	   				sheetObj.CellEditable(row,"scg_amt") = false;
   	   			}
   			}
   			//현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
   			getLocalAmtToUSD(sheetObj,row);
   			sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_surcharge") = calcTotalValue(sheetObj,"adj_scg_usd_amt");
   			sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_rev") = eval(sheetObjects[0].Cellvalue(2, "oft_amt")) + eval(sheetObjects[0].CellValue(sheetObjects[0].LastRow,"tot_surcharge"));
   		}
   	}
   	
   	
   
 	/** 
     * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {object} sheetObj 필수, sheet Object
	 * @param {String} ErrMsg 필수, sheet의 결과 메시지
	 * @return 없음
	 */      	
 	function sheet2_OnSearchEnd(sheetObj, ErrMsg)  {
 		ComBtnEnable("btn_Add");
   		ComBtnEnable("btn_Delete");
   		var totalSchg = 0.0;
   		totalSchg = calcTotalValue(sheetObj,"adj_scg_usd_amt");
		sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_surcharge") = totalSchg;
		sheetObjects[0].CellValue2(sheetObjects[0].LastRow,"tot_rev") = eval(sheetObjects[0].Cellvalue(2, "oft_amt")) + totalSchg;
	}       	
 
  	 
     /** 
      * 현재 조회중인 데이터를 생성한 년월을 이용해서 Local Amt를 USD로 환산해준다. 
      * 
      * <br><b>Example :</b>
      * <pre>
      *       getLocalAmtToUSD(sheetObj,row);
      * </pre>
      * @param {object} sheetObj 필수, sheet Object
      * @param {int} row 필수, 변경하고자 하는 row index
      * @return 없음
      */     	 
   	function getLocalAmtToUSD(sheetObj,row){
			//USD이면 DB조회가 필요 없다.
		if(  sheetObj.CellText(row,"curr_cd") == "USD"){
			sheetObj.Cellvalue2(row,"adj_scg_usd_amt") = sheetObj.Cellvalue(row,"scg_amt")
		}else{
   	    	//USD AMOUNT
 	      	var formObj = document.form
			var formParam = "f_cmd="+COMMAND03+"&etc1="+sheetObj.CellText(row,"curr_cd");
			formParam = formParam + "&etc2="+sheetObj.Cellvalue(row,"scg_amt");
			formParam = formParam + "&etc3="+ComGetNowInfo('ymd').replace(/-/gi,"");
			var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", formParam);
			var arrData = ComXml2ComboString(sXml, "cd", "nm");
			sheetObj.Cellvalue2(row,"adj_scg_usd_amt") = arrData[1];
		}
   	}
 
    /** 
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *      if (!validateForm(sheetObj,document.form,sAction)) {
     *          return false;
     *       }
   	 * </pre>
   	 * @param {object} sheetObj 필수, sheet Object
   	 * @param {object} formObj 필수, html document form Object
   	 * @param {int} sAction 필수, action의 구분
     *
   	 * @return boolean, true: 유효, false: 비유효
   	 */          
     function validateForm(sheetObj, formObj, sAction) {
         switch (sAction) {
         case IBSEARCH:
        	 if (sheetObj.CellValue(2, "por_cd") == "") {
    			 ComShowCodeMessage("COM12114", "POR");
    			 return false;
    		 } else if(sheetObj.CellValue(2, "del_cd") == "") {
    			 ComShowCodeMessage("COM12114", "DEL");
    			 return false;
    		 } else if(ComGetObjValue(formObj.svc_scp_cd) == "") {
    			 ComShowCodeMessage("COM12114", "SVC Scope");
    			 return false;
    		 } else if (sheetObj.CellValue(2, "cntr_qty") == "") {
    			 ComShowCodeMessage("COM12114", "Qty.");
    			 return false;
    		 }
         break;
         case IBSAVE: // 저장
         break;
         }
         return true;
     }
      
   	 
     /** 
     * sheet의 해당 컬럼의 총합을 계산하는데 ibflag가 I/R/U 인것만 합산한다. 
     * 
     * <br><b>Example :</b>
     * <pre>
     *      amt =  calcTotalValue(sheetObj,"adj_scg_usd_amt"); // 계산된 숫자값
     * </pre>
     * @param {object} sheetObj 필수, sheet Object
     * @param {String} col 필수, 변경하고자 하는 column name
     * @return float, 해당 컬럼의 총합
     */     
      function calcTotalValue(sheetObj,col){
    	   var allRows = sheetObj.FindStatusRow("I|R|U");
   	   	   var arAllRows = allRows.split(";");
   	   	   var totalValue = 0.0;
	   	   for (var idx=0; idx<arAllRows.length-1; idx++){ 
	   		   totalValue = totalValue + eval(sheetObj.CellValue(arAllRows[idx],col));
	   	   }
	   	   return totalValue;
      }
      
     function setIBCombo(sheetObj, sXml, title, iBlank, sCol, dCode, dText, bFlag){
         var showCol = 0;
         if (bFlag == undefined || bFlag == ""){
             bFlag = false;
         }
         if (sCol != undefined && sCol !=""){
             showCol = sCol;
         }
         if (iBlank == undefined || iBlank == ""){
             iBlank = false;
         }
         var arrData = ComXml2ComboString(sXml, "cd", "nm");
         if (bFlag == true && arrData != null){
             var arrCode = arrData[0].split("|");
             var arrName = arrData[1].split("|");
             var conData = "";
             for(i=0; i < arrName.length;i++){
                 if(i==0){
                     arrName[i] = arrCode[i]+"\t"+arrName[i];
                 }else{
                     arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                 }
                 conData = conData.concat(arrName[i]);
             }
             arrData[1] = conData;
         }
         if(iBlank){
             if (arrData != null){
                 arrData[0] = " |" + arrData[0];
                 arrData[1] = " |" + arrData[1];
             }
         }
         if (arrData != null){
             sheetObj.InitDataCombo(0,title, arrData[1], arrData[0],dText, dCode, showCol);
         }
     }
     
     /**
      * POR Code와 DEL Code로 Service Scope Code 조회
      */     
     function getSvcScpCd(por, del) {
    	 var formObj = document.form;
    	 formObj.f_cmd.value = SEARCH01;
    	 formObj.org_cd.value = sheetObjects[0].CellValue(2, "por_cd");
    	 formObj.dest_cd.value = sheetObjects[0].CellValue(2, "del_cd");
    	 var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_4017GS.do", masFormQueryString(formObj));
    	 
    	 var arrXml = sXml.split("|$$|");
    	 if (arrXml.length > 0)
    		 ComXml2ComboItem(arrXml[0], formObj.svc_scp_cd, "svc_scp_cd", "svc_scp_cd|svc_scp_nm");
    	 comboObjects[0].Index = 0;
//    	 ComSetObjValue(formObj.svc_scp_cd, 1);
     }
     
     /**
      * 화면정보를 Main에 전달한다.
      */     
     function comPopupSend(sheetObj, formObj){
     	var calllFunc = formObj.calllFunc.value;
     	var colsCnt = sheetObj.LastCol + 1;
     	var arrData = null;
     	arrData = new Array(colsCnt);
     	for(var i = 0; i < arrData.length ; i++) {
     		arrData[i] = sheetObj.CellValue(2, i);
     	}
     	eval('window.dialogArguments.'+calllFunc)(arrData);
 		window.close();
     }
       
	/* 개발자 작업  끝 */