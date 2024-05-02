/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1215.jsp
*@FileTitle : Booking Allocation Master Table
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.30
*@LastModifier : 최문환
*@LastVersion : 1.0
* 2013.12.30 최문환
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
     * @class ESM_BKG_1215 : ESM_BKG_1215 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1215() {
    	this.processButtonClick		= processButtonClick;
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
	var comboCnt = 0;
	
	//최초 Allocation Type를 불러온 후 저장 할 변수
	var typeListXml = new Array();
	var groupCmdtListXml = new Array();
	
	//Delete시 Validation을 위한 HeadCount 변수와 SelRow변수
	var delSelRow ="";
	var delHeadCount ="";
	var delStat ="";
	
	//T.LANE VALIDATION시 대상을 폼으로 볼지 시트로 볼지 결정하는 변수
	var sheetFlag ="";
	
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

				case "btn_Retrieve":
					if(formObject.dirty_flag.value == 'Y' && formObject.screenName.value == 'ESM_BKG_1215' && confirm(ComGetMsg("BKG00254"))){
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				
				case "btn_rowadd":
					doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;																	
	
				case "btn_rowdel":	
					
					if(sheetObject1.LastRow =="1"){
						//아무것도 없는 상태에서 삭제를 시도할 경우 대상이 없음을 알린다.
		            	ComShowMessage(ComGetMsg("BKG03055"));
					}else if(!validateForm(sheetObject1,formObject,IBDELETE) && delStat == "0"){
						//insert만 하고 바로지울 경우 경고없이 지운다. 
						sheetObject1.RowDelete(delSelRow,false);
					} else if(!validateForm(sheetObject1,formObject,IBDELETE) && delStat == "1"){
						//특정 Raw를 추가후 정보를 입력하고 저장하지 않고 지울경우 Confirm을 한다.. 
						sheetObject1.RowDelete(delSelRow,true);
					} else if(validateForm(sheetObject1,formObject,IBDELETE)){
						//일반적으로 data를 지울경우 변경사항이 있을 경우 변경사항에 대한 저장여부를 물어보고 삭제여부를 물어본다.
						if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00254"))){
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
						}
						if(confirm(ComGetMsg("BKG00535"))){
							doActionIBSheet(sheetObject1, formObject, IBDELETE);
						}
					}
				break;	
				
				case "btn_copy":
					doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
					break;
				
				case "btn_excel":
					 sheetObjects[0].SpeedDown2Excel(-1);
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 최문환
     * @version 2014.01.07
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;			
    }

    /**
     * 콤보 초기설정값
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @return 없음
     * @author 최문환
     * @version 2014.01.07
     */
  	 function initComboSetVal(sheetObj,formObj){
  	 	formObj.f_cmd.value = SEARCH01;
  	 	
  	 	var sXml = sheetObj.GetSearchXml("ESM_BKG_1215GS.do", FormQueryString(formObj));
  		var arrXml = sXml.split("|$$|");
  		//Row Add를 위하여 typeListXml[0]에 조회 결과를 저장해 둔다.
  		typeListXml[0] = arrXml[0];
  		
  		ComXml2ComboItem(arrXml[0], formObj.bkg_aloc_tp_cd, "val", "name");
  		formObj.bkg_aloc_tp_cd.InsertItem(0, "ALL", "A");
  		formObj.bkg_aloc_tp_cd.Index = 0;
  		
  		formObj.bkg_aloc_tp_cd.DropHeight = 150;
  		formObj.bkg_aloc_tp_cd.UseAutoComplete = true;
  		

  		formObj.f_cmd.value = SEARCH04;
  	 	
  	 	var sXml = sheetObj.GetSearchXml("ESM_BKG_1215GS.do", FormQueryString(formObj));
  		var arrXml = sXml.split("|$$|");
  		groupCmdtListXml[0] = arrXml[0];
  		//ComXml2ComboItem(arrXml[0], "scg_grp_cmdt_seq", "cd", "nm");
  		ComSetIBCombo(sheetObj, arrXml, "scg_grp_cmdt_seq", true, 0, "", "", true);
  		//ComSetIBCombo(sheetObj, arrXml, "scg_grp_cmdt_desc", "", 1, "", "", true);
  		
  		//arrXml[9] = ComReplaceStr(arrXml[9], "val|ibflag|desc|name|", "cd|ibflag|desc|nm|");
    	//ComSetIBCombo(sheetObj, arrXml[9], prefix+"inp_pic_usr_id", "", 1, "", "", true);
  		//ComXml2ComboItem(arrXml[0], formObj.bkg_aloc_tp_cd, "cd", "nm");
  		
  	 }
  	 
  	/**
  	 * Sheet 기본 설정 및 초기화 <br>
  	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
  	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *     loadPage();
  	 * </pre>
  	 * @return 없음
  	 * @author 최문환
  	 * @version 2014.01.07
  	 */                   
    function loadPage() {

		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		initComboSetVal(sheetObjects[0],document.form);
		//조회시 IBShhet의 콤보에 코드값이 아닌 Name으로 보이기 위해 콤보를설정한다
		setTypeList();
		// add listener
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
	}
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 최문환
     * @version 2014.01.07
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
				
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "|Seq|TYPE|T.LANE|BD|Trunk\nPOL|Trunk\nPOD|VVD|POR/NODE|POR/NODE|POR/NODE|POR/NODE|POL/NODE|POL/NODE|POL/NODE|T/S|T/S|T/S|T/S|T/S|T/S|POD/NODE|POD/NODE|POD/NODE|DEL/NODE|DEL/NODE|DEL/NODE|DEL/NODE|CNTR\nTYPE|RHQ|L.OFC|S/C No.|RFA No.|C. Cust Code|BKG\nShipper Code|ALLOCATION|%\nTHRESHOLD|Group COMMODITY|Group COMMODITY|COMMODITY|COMMODITY|SVC|REMARK|Update User|Update Date|ALLOC_SEQ";
					var HeadTitle2 = "|Seq|TYPE|T.LANE|BD|Trunk\nPOL|Trunk\nPOD|VVD|Country|LOC|NODE|SCC|Country|LOC|NODE|LANE|BD|POL\n Country|POL|POD\n Country|POD|Country|LOC|NODE|Country|LOC|NODE|SCC|CNTR\nTYPE|RHQ|L.OFC|S/C No.|RFA No.|C. Cust Code|BKG\nShipper Code|ALLOCATION|%\nTHRESHOLD|CODE|NAME|CODE|NAME|SVC|REMARK|Update User|Update Date|ALLOC_SEQ";

					var headCount = ComCountHeadTitle(HeadTitle2);
					
					delHeadCount = headCount;
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    FrozenCols = 5;
                                        
                    //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 20,    daCenter,  true,     "ibflag");
                    InitDataProperty(0,	cnt++, dtSeq,		   50, 	  daCenter,	true,	   "seq",				 true,		"",		dfNone,		0,		false,		 true);
                    InitDataProperty(0, cnt++, dtCombo,    	   80,    daCenter,  true,     "bkg_aloc_tp_cd",    false,    "",         dfNone,     0,           true,      true,     1);
                    InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "trnk_slan_cd",    	false,    "",         dfNone,     0,           true,      true,     3);
                    InitDataProperty(0, cnt++, dtData,         50,    daCenter,  true,     "trnk_dir_cd",      	false,    "",         dfNone,     0,           true,      true,     1);
                    InitDataProperty(0, cnt++, dtPopup,       100,    daCenter,  true,     "trunk_pol_cd",     	false,    "",         dfNone,     0,           true,      true,     100);
                    InitDataProperty(0, cnt++, dtPopup,       100,    daCenter,  true,     "trunk_pod_cd",     	false,    "",         dfNone,     0,           true,      true,     100);
                    InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,     "vvd",      		    false,    "",         dfNone,     0,           true,      true,     9);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "bkg_por_cnt_cd",    false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "por_cd",      		false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "por_nod_cd",      	false,    "",         dfNone,     0,           true,      true,     7);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "bkg_por_scc_cd",   	false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "bkg_pol_cnt_cd",    false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "pol_cd",      		false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "pol_nod_cd",      	false,    "",         dfNone,     0,           true,      true,     7);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "n1st_ts_slan_cd",   false,    "",         dfNone,     0,           true,      true,     3);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "n1st_ts_dir_cd",    false,    "",         dfNone,     0,           true,      true,     1);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,	 true,     "n1st_ts_pol_cnt_cd",false,    "",         dfNone,     0,           true,      true,     2);
                    InitDataProperty(0, cnt++, dtPopup,        100,   daCenter,	 true,     "n1st_ts_pol_cd",    false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "n1st_ts_pod_cnt_cd",false,    "",         dfNone,     0,           true,      true,     2);
                    InitDataProperty(0, cnt++, dtPopup,        100,   daCenter,  true,     "n1st_ts_pod_cd",    false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "bkg_pod_cnt_cd",    false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "pod_cd",      		false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "pod_nod_cd",      	false,    "",         dfNone,     0,           true,      true,     7);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "bkg_del_cnt_cd",    false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "del_cd",      		false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "del_nod_cd",      	false,    "",         dfNone,     0,           true,      true,     7);
                    InitDataProperty(0, cnt++, dtData,         70,    daCenter,  true,     "bkg_del_scc_cd",    false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "cntr_tpsz_cd",      false,    "",         dfNone,     0,           true,      true,     3);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "sls_rhq_cd",      	false,    "",         dfNone,     0,           true,      true,     5);
                    InitDataProperty(0, cnt++, dtData,         55,    daCenter,  true,     "ob_sls_ofc_cd",     false,    "",         dfNone,     0,           true,      true,     6);
                    InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,     "sc_no",      		false,    "",         dfNone,     0,           true,      true,    20);
                    InitDataProperty(0, cnt++, dtData,         80,    daCenter,  true,     "rfa_no",      		false,    "",         dfNone,     0,           true,      true,    20);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,  true,     "ctrt_cust_cnt_cd",  false,    "",         dfNone,     0,           true,      true,     8);
                    InitDataProperty(0, cnt++, dtData,         90,    daCenter,  true,     "cust_cnt_cd",      	false,    "",         dfNone,     0,           true,      true,     8);
                    InitDataProperty(0, cnt++, dtData,         90,     daRight,  true,     "aloc_lod_qty",      false,    "",         dfNone,     0,           true,      true,     6);
                    InitDataProperty(0, cnt++, dtData,         90,     daRight,  true,     "aloc_lod_qty_rto",  false,    "",    dfNullFloat,     2,           true,      true,     6);
                    InitDataProperty(0, cnt++, dtCombo,        60,    daCenter,  true,     "scg_grp_cmdt_seq",  false,    "",         dfNone,     0,           true,      true,     6);
                    InitDataProperty(0, cnt++, dtData,        100,      daLeft,  true,     "scg_grp_cmdt_desc",	false,    "",         dfNone,     0,          false,     false,   300);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,     "cmdt_cd",      		false,    "",         dfNone,     0,           true,      true,     6);
                    InitDataProperty(0, cnt++, dtData,        100,      daLeft,  true,     "cmdt_nm",      		false,    "",         dfNone,     0,          false,     false,   300);
                    InitDataProperty(0, cnt++, dtCombo,        60,    daCenter,  true,     "aloc_svc_cd",      	false,    "",         dfNone,     0,           true,      true,     1);
                    InitDataProperty(0, cnt++, dtData,        150,      daLeft,  true,     "bkg_aloc_rmk",      false,    "",         dfNone,     0,           true,      true,  4000);				
					InitDataProperty(0,	cnt++, dtData,		  120,	  daCenter,	 true,	   "upd_usr_id",		false,	  "",		  dfNone,	  0,		  false,  	 false);
 					InitDataProperty(0,	cnt++, dtData,		  120,	  daCenter,	 true,	   "upd_dt",			false,	  "",	   dfNone,     0,		  false,	 false);
                    InitDataProperty(0, cnt++, dtHidden,       30,    daCenter,  true,     "bkg_aloc_seq",		false, 	  "", 		  dfNone,     0,          false,     false);
                    InitDataCombo(0, "aloc_svc_cd", "Auto|Manual", "A|M");
                    InitDataValid(0, "cmdt_cd", vtNumericOnly);
                    //InitDataValid(0, "scg_grp_cmdt_seq", vtNumericOnly);
                    /*SetMergeCell(0, SaveNameCol("ctrt_cust_cnt_cd"), 2, 2); 
                    SetMergeCell(0, SaveNameCol("cust_cnt_cd"), 2, 2); 
                    InitDataValid(0, "cust_seq", vtNumericOnly);*/

            	}
                break;
               
        }
    }

  /**
    * Sheet관련 프로세스 처리 <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {form} formObj 필수 html form object
    * @param {int} sAction 필수 프로세스 플래그 상수
    * @return 없음
    * @author 최문환
    * @version 2014.01.07
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        
			case IBSEARCH:      //조회
					formObj.f_cmd.value = SEARCH;		
					sheetObj.DoSearch("ESM_BKG_1215GS.do", FormQueryString(formObj));
					// 데이터 변경 여부 체크
					formObj.dirty_flag.value = 'N';
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;	
					sheetObj.DoSave("ESM_BKG_1215GS.do", FormQueryString(formObj));
                }else{
					return false;					
				}
			break;

			case IBINSERT:      //Row 추가
				var newRow = sheetObj.DataInsert(-1);
				sheetEnable(sheetObj,newRow);
				svcType(sheetObj);
 
			    // 데이터 변경 여부 체크
				formObj.dirty_flag.value = 'Y';
				sheetObj.SelectCell(newRow,"trnk_slan_cd");
			break;
			
			case IBDELETE:        //삭제
				
				formObj.f_cmd.value = REMOVE;
				var sParam = FormQueryString(formObj)+"&"+"bkg_aloc_seq="+sheetObj.CellValue(sheetObj.SelectRow, "bkg_aloc_seq");	
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1215GS.do", sParam);						 
				var rMsg = ComResultMessage(sXml);
				
				if(rMsg == ''){
					sheetObj.LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
					// show message
					ComShowMessage(ComGetMsg("BKG00593"));
				} else {
					ComShowMessage(rMsg);
					return false;
				}				
			break;
			
			case IBCOPYROW: // Row Copy                                                                                                                                                                                                                                                                                                                                                                                                                                   
                
				/*if(sheetObj.CheckedRows("check") > 1) {                                                                                                                                                                                                                                                                                                                                                                                                   
					copyMultyRow(sheetObj);                                                                                                                                                                                                                                                                                                                                                                                                         
				} 
				else{*/
				var oldIdx = sheetObj.SelectRow;  
				var newIdx = sheetObj.DataCopy();    
				sheetObj.CellValue2(newIdx, "bkg_aloc_seq") = 0;
					/*if(newIdx > 0) {                 
						sheetObj.CellValue2(oldIdx, "check") = 0;
					}                                                                                                                                                                                                                                                                                                                                                                                                                               
				}      */                                                                                                                                                                                                                                                                                                                                                                                                                                 
				break;  
			
			case SEARCH03: //Commodity Name 조회				
				var sParam = "f_cmd="+ SEARCH03 + "&cmdt_cd="+sheetObj.CellValue(sheetObj.SelectRow, "cmdt_cd");
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1215GS.do", sParam);
//				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
					sheetObj.CellValue2(sheetObj.SelectRow, "cmdt_nm") = ComGetEtcData(sXml,"cmdt_nm");
//				}			
			break;
			
			case SEARCH05: //Commodity Name 조회				
				var sParam = "f_cmd="+ SEARCH05 + "&cmdt_cd="+sheetObj.CellValue(sheetObj.SelectRow, "scg_grp_cmdt_seq");
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1215GS.do", sParam);
//				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
					sheetObj.CellValue2(sheetObj.SelectRow, "scg_grp_cmdt_desc") = ComGetEtcData(sXml,"scg_grp_cmdt_desc");
//				}			
			break;

        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
     * @author 최문환
     * @version 2014.01.07
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {

            case IBSAVE:
				if(/*formObj.dirty_flag.value == 'N' ||*/ sheetObj.GetSaveString() == ""){
					ComShowMessage(ComGetMsg("BKG00737"));
					return false;
				}
				//alert(sheetObj.GetSaveString());
				with(sheetObj){	
					if(formObj.dirty_flag.value == 'Y'){							
					    for (i=HeaderRows ; i<= LastRow; i++) {
					    	if(CellValue(i, "ibflag") == "I" || CellValue(i, "ibflag") == "U"){
					    		if(CellValue(i, "bkg_aloc_tp_cd") == "T"){
					    			if(CellValue(i, "trnk_slan_cd") == ""){
					    				ComShowMessage(ComGetMsg("BKG00887","T.LANE"));
					    				SelectCell(i,"trnk_slan_cd");
					    				return false;
					    			}
					    			
					    			if(CellValue(i, "aloc_lod_qty_rto") == "" || CellValue(i, "aloc_lod_qty_rto") == ""){
					    				ComShowMessage(ComGetMsg("BKG00887","THERSHOLD"));
					    				SelectCell(i,"aloc_lod_qty_rto");
					    				return false;
					    			}
						    	}
					    		if(CellValue(i, "bkg_aloc_tp_cd") == "S"){
					    			if(CellValue(i, "n1st_ts_slan_cd") == ""){
					    				ComShowMessage(ComGetMsg("BKG00887","T/S Lane"));
					    				SelectCell(i,"n1st_ts_slan_cd");
					    				return false;
					    			}
					    			if(CellValue(i, "aloc_lod_qty") == "" ){
					    				ComShowMessage(ComGetMsg("BKG00887","Allocation QTY"));
					    				SelectCell(i,"aloc_lod_qty");
					    				return false;
					    			}
						    	}
					    		if(CellValue(i, "bkg_aloc_tp_cd") == "E"){
					    			if(CellValue(i, "cntr_tpsz_cd") == ""){
					    				ComShowMessage(ComGetMsg("BKG00887","CNTR TYPE"));
					    				SelectCell(i,"cntr_tpsz_cd");
					    				return false;
					    			}
						    	}
					    		if(CellValue(i, "bkg_aloc_tp_cd") == "M"){
					    			if(CellValue(i, "cmdt_cd") == "" && CellValue(i, "scg_grp_cmdt_seq") == ""){
					    				ComShowMessage(ComGetMsg("BKG00887","COMMODITY CODE"));
					    				SelectCell(i,"cmdt_cd");
					    				return false;
					    			}
						    	}
					    		if(CellValue(i, "bkg_aloc_tp_cd") == "C"){
					    			if(CellValue(i, "sc_no") == "" 
					    				&& CellValue(i, "rfa_no") == ""
					    				&& CellValue(i, "ctrt_cust_cnt_cd") == ""
					    				&& CellValue(i, "cust_cnt_cd") == ""){
					    				ComShowMessage(ComGetMsg("BKG00887","S/C No or RFA No or Contract Code or BKG Shipper Code"));
					    				SelectCell(i,"sc_no");
					    				return false;
					    			}
						    	}
					    		
				    			if(CellValue(i, "aloc_svc_cd") == ""){
				    				ComShowMessage(ComGetMsg("BKG00887","SVC"));
				    				SelectCell(i,"aloc_svc_cd");
				    				return false;
				    			}

					    	}
					    }
					}
				}
			break;	
			
            case IBDELETE:
            	delStat = "";
            	delSelRow = sheetObj.SelectRow;            	
            	//선택한 행이 Insert한 경우이며 Data 가 없을 경우 바로 지운다.
            	if(sheetObj.CellValue(delSelRow, "bkg_aloc_seq") ==""){
            		var rowData ="";
            		for(var i=3; i <= delHeadCount-1; i++){
            			if(sheetObj.CellValue(delSelRow, i) != "" && sheetObj.ColSaveName(i) !="aloc_svc_cd"){
            					rowData = "N";          				
            			}
            		}
            		if(rowData ==""){
            			//지우고자 하는 행에 Data가 없는 경우 바로 지운다.            			
            			delStat = "0";
            			return false;
            		}else {
            			//지우고자 하는 행에 Data가 있음에도 지우면 삭제 여부 알림창을 띄움.
            			delStat = "1";
            			return false;
            		}            		
            	}
            	//Detele 대상 로우외에 변동사항이 없다면 dirty_flag를 N으로 변경시킨다.
            	formObj.dirty_flag.value = 'N';
    			for(var i=2; i <= sheetObj.RowCount+1; i++){
    				if(i != delSelRow){
    					if(sheetObj.CellValue(i, "ibflag") == "I" || sheetObj.CellValue(i, "ibflag") == "U"){
            				formObj.dirty_flag.value = "Y";
            			}
    				}                			
        		}
			break;
        }

        return true;
    }
     
    /**
     * Event 처리 <br>
     * </pre>
     * @return 없음
     * @author 최문환
     * @version 2014.01.07
     */
	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		switch(event.srcElement.dataformat){
			case "engupnum":
				ComKeyOnlyAlphabet("uppernum");
			break;
		}	
	}
	
	/**
     * Sheet에 콤보를 설정 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     setTypeList()
     * </pre>
     * @return 없음
     * @author 최문환
     * @version 2014.01.07
     */
	function setTypeList(){
    	setIBCombo(sheetObjects[0], typeListXml[0], "bkg_aloc_tp_cd", false, "", "","","desc");
    }
	
	/**
     * bkg_aloc_tp_cd에 따라 SVC 열의 값을 자동으로 기입한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     svcType(sheetObject[0])
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최문환
     * @version 2014.01.07
     */
	function svcType(sheetObj){
		if(sheetObj.CellValue(sheetObj.SelectRow, "bkg_aloc_tp_cd") == "T"){
			sheetObj.CellValue2(sheetObj.SelectRow, "aloc_svc_cd") = "A";
		} else{
			sheetObj.CellValue2(sheetObj.SelectRow, "aloc_svc_cd") = "M";
		}
	}
	
	/**
     * bkg_aloc_tp_cd 별로 셀의 활성화 여부를 설정한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheetEnable(sheetObject[0])
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최문환
     * @version 2014.01.07
     */
	function sheetEnable(sheetObj,i){
		with(sheetObj){
	    	for(j=3; j<=delHeadCount; j++){
	    		CellEditable(i,j)  = true; 
	    	}
	    	if(CellValue(i, "bkg_aloc_tp_cd") == "T"){
	    		//CellEditable(i,"vvd")          	   = false;      		
	    		CellEditable(i,"por_cd")           = false;
	    		CellEditable(i,"pol_cd")           = false;
	    		CellEditable(i,"por_nod_cd")       = false;      	
	    		CellEditable(i,"bkg_por_scc_cd")   = false;      		
	    		CellEditable(i,"pol_nod_cd")       = false;      	
	    		CellEditable(i,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cd")   = false;    
	    		CellEditable(i,"n1st_ts_slan_cd")  = false;
	    		CellEditable(i,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_dir_cd")  = false;
	    		CellEditable(i,"pod_cd")           = false;      		
	    		CellEditable(i,"pod_nod_cd")       = false;      	
				CellEditable(i,"del_cd")           = false;      		
				CellEditable(i,"del_nod_cd")       = false;      	
				CellEditable(i,"bkg_del_scc_cd")   = false;    
				CellEditable(i,"cntr_tpsz_cd")     = false;      
				CellEditable(i,"sc_no")            = false;  
				CellEditable(i,"rfa_no")           = false;
				CellEditable(i,"ctrt_cust_cnt_cd") = false;
				CellEditable(i,"cust_cnt_cd")      = false; 
				CellEditable(i,"ctrt_cust_seq")    = false;
				CellEditable(i,"cust_seq")         = false;
				CellEditable(i,"cmdt_cd")          = false;
				CellEditable(i,"cmdt_nm")          = false;
				CellEditable(i,"scg_grp_cmdt_seq") = false;
				CellEditable(i,"aloc_lod_qty")     = false; 
				//CellEditable(i,"aloc_svc_cd")      = false;      	
				CellEditable(i,"bkg_aloc_rmk")     = false;	  
				CellEditable(i,"bkg_por_cnt_cd")   = false;
				CellEditable(i,"bkg_pol_cnt_cd")   = false;
				CellEditable(i,"bkg_pod_cnt_cd")   = false;
				CellEditable(i,"bkg_del_cnt_cd")   = false;
	    	}
	    	if(CellValue(i, "bkg_aloc_tp_cd") == "S"){
	    		CellEditable(i,"cntr_tpsz_cd")     = false;      
				CellEditable(i,"sc_no")            = false; 
				CellEditable(i,"rfa_no")           = false;
				CellEditable(i,"ctrt_cust_cnt_cd") = false;
				CellEditable(i,"cust_cnt_cd")      = false;
				CellEditable(i,"ctrt_cust_seq")    = false;
				CellEditable(i,"cust_seq")         = false;
				CellEditable(i,"cmdt_cd")          = false;
				CellEditable(i,"cmdt_nm")          = false;
				CellEditable(i,"scg_grp_cmdt_seq") = false;
				CellEditable(i,"bkg_aloc_rmk")     = false;
				CellEditable(i,"trunk_pol_cd")     = false;
				CellEditable(i,"trunk_pod_cd")     = false;      
	    	}
	    	if(CellValue(i, "bkg_aloc_tp_cd") == "E"){
				CellEditable(i,"sc_no")            = false; 
				CellEditable(i,"rfa_no")           = false;
				CellEditable(i,"ctrt_cust_cnt_cd") = false;
				CellEditable(i,"cust_cnt_cd")      = false;
				CellEditable(i,"ctrt_cust_seq")    = false;
				CellEditable(i,"cust_seq")         = false;
				CellEditable(i,"cmdt_cd")          = false;
				CellEditable(i,"scg_grp_cmdt_seq") = false;
				CellEditable(i,"aloc_lod_qty")     = false;      
				CellEditable(i,"aloc_lod_qty_rto") = false;
				CellEditable(i,"cmdt_nm")          = false;
				CellEditable(i,"cmdt_cd")          = false;	
				CellEditable(i,"scg_grp_cmdt_seq") = false;
				CellEditable(i,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_dir_cd")   = false;
	    		CellEditable(i,"trunk_pol_cd")     = false;
				CellEditable(i,"trunk_pod_cd")     = false; 
				CellEditable(i,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cd")   = false;    
	    	}
	    	if(CellValue(i, "bkg_aloc_tp_cd") == "M"){
	    		CellEditable(i,"bkg_rhq_cd")       = false;      	
				CellEditable(i,"sc_no")            = false; 
				CellEditable(i,"rfa_no")           = false;
				CellEditable(i,"ctrt_cust_cnt_cd") = false;
				CellEditable(i,"cust_cnt_cd")      = false;	
				CellEditable(i,"ctrt_cust_seq")    = false;
				CellEditable(i,"cust_seq")         = false;
				CellEditable(i,"cmdt_nm")          = false;
				CellEditable(i,"aloc_lod_qty")     = false;      
				CellEditable(i,"aloc_lod_qty_rto") = false;
				CellEditable(i,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_dir_cd")  = false;
	    		CellEditable(i,"trunk_pol_cd")     = false;
				CellEditable(i,"trunk_pod_cd")     = false; 
				CellEditable(i,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cd")   = false;    
	    	}
	    	if(CellValue(i, "bkg_aloc_tp_cd") == "C"){
	    		CellEditable(i,"cmdt_nm")          = false;	
	    		CellEditable(i,"aloc_lod_qty")     = false;      
				CellEditable(i,"aloc_lod_qty_rto") = false;
				CellEditable(i,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(i,"n1st_ts_dir_cd")  = false;
	    		CellEditable(i,"trunk_pol_cd")     = false;
				CellEditable(i,"trunk_pod_cd")     = false; 
				CellEditable(i,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(i,"n1st_ts_pod_cd")   = false;    
	    	}
	    	CellEditable(i,"upd_usr_id")          = false;	
	    	CellEditable(i,"upd_dt")              = false;	
		  		
		}
	}
	
	/**
	 * 화면 시트값의 변화에 따라 수행될 동작을 정의한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @returns 없음
	 * @author 최문환
	 * @version 2014.01.07
	 */
	function sheet1_OnChange(sheetObj, row, col, val) {
		
		var formObj = document.form;
		var val_type = "";
		var val_value = "";
		
		// 데이터 변경 여부 체크
		formObj.dirty_flag.value = 'Y';
		sheetFlag ="Y";
		
		/* ColSaveName */
		var col_save_name = sheetObj.ColSaveName(col);
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		/* 대문자 */
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}
		//bkg_aloc_tp_cd변경시 SVC값과 셀의 활성화여부를 결정한다
		if(col_save_name == "bkg_aloc_tp_cd"){
			sheetEnable(sheetObj,row);
			svcType(sheetObj);
		}
		//trnk_slan_cd, trnk_dir_cd, trnk_dir_cd 변경시 값의 적정성을 Validation한다.
		if (col_save_name == "trnk_slan_cd" || col_save_name == "n1st_ts_slan_cd") {
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "LANE";
        		val_value = sheetObj.CellValue(row,col_save_name);
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}
        } else if(col_save_name == "trnk_dir_cd" || col_save_name == "n1st_ts_dir_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "BOUND";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "cmdt_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "COMMODITY";
        		val_value = sheetObj.CellValue(row,"cmdt_cd");  
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		} else {
        			doActionIBSheet(sheetObj,formObj,SEARCH03);
        		}
        	}else{
        		sheetObj.CellValue2(row,"cmdt_nm") = "";
        	}	
        } else if(col_save_name == "scg_grp_cmdt_seq"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "GRP_COMMODITY";
        		val_value = sheetObj.CellValue(row,"scg_grp_cmdt_seq");  
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		} else {
        			doActionIBSheet(sheetObj,formObj,SEARCH05);
        		}
        	}else{
        		sheetObj.CellValue2(row,"scg_grp_cmdt_desc") = "";
        	}
        		
        } else if(col_save_name == "ob_sls_ofc_cd" || col_save_name == "sls_rhq_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        	formObj.ofc_cd.value = sheetObj.CellValue(row,col);
	        	formObj.ofc_ty.value = 1;
	        	formObj.f_cmd.value  = SEARCH01;
	        	var sParam = FormQueryString(formObj);
	        	var sXml = sheetObj.GetSaveXml("ESM_BKG_0741GS.do", sParam);
	   	     
		   	     if (ComGetEtcData(sXml,"check") == "N"){
		   	    	 ComShowCodeMessage("BKG01107");//사용가능한 Office Code가 아닙니다.
		   	    	 sheetObj.SelectCell(row, col, true, '');
		       	 }
        	}
        } else if(col_save_name == "vvd") {
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        	if (sheetObj.CellValue(row,col).length != 9){
					 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
					 sheetObj.SelectCell(row, col, true, '');
	        	}
	        	formObj.f_cmd.value = SEARCH01;   
	        	formObj.vvd_sig.value = sheetObj.CellValue(row,col);
				 
				 var searchXml = sheetObj.GetSearchXml("ESM_BKG_0632GS.do" , FormQueryString(formObj));
				 if (ComGetEtcData(searchXml,"lane") == "none"){
					 ComShowCodeMessage("BKG00163");//VVD is NOT Registered
					 sheetObj.SelectCell(row, col, true, '');
				 }
        	}
        } else if(col_save_name == "ctrt_cust_cnt_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "CUSTOMER";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "cust_cnt_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "CUSTOMER";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "cntr_tpsz_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "CNTR TPSZ";
        		val_value = sheetObj.CellValue(row,col_save_name);
        		if (sheetObj.CellValue(row,col_save_name) == "ALL" && sheetObj.CellValue(row,"bkg_aloc_tp_cd") != "E"){
        			ComShowCodeMessage('BKG00993',val_type + " : " + val_value);
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        			
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "sc_no"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "SC NO";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "rfa_no"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "RFA NO";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}
        } else if(col_save_name == "por_cd" || col_save_name == "pol_cd" || col_save_name == "n1st_ts_pol_cd" ||
        		  col_save_name == "n1st_ts_pod_cd" || col_save_name == "pod_cd" ||
        		  col_save_name == "del_cd"){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
        		val_type = "Location";
        		val_value = sheetObj.CellValue(row,col_save_name); 
        		if(!searchValidationData(sheetObj, val_type, val_value)) {
        			sheetObj.CellValue2(row,col_save_name) = "";
        			sheetObj.SelectCell(row, col);
        		}
        	}	
        } else if(col_save_name == "n1st_ts_pol_cnt_cd" || col_save_name == "n1st_ts_pod_cnt_cd" 
        	      || col_save_name == "bkg_por_cnt_cd" || col_save_name == "bkg_pol_cnt_cd"
        	      || col_save_name == "bkg_pod_cnt_cd" || col_save_name == "bkg_del_cnt_cd"){
		    	if(sheetObj.CellValue(row,col_save_name)!="" ){
		    		val_type = "CNT";
		    		val_value = sheetObj.CellValue(row,col_save_name); 
		    		if(!searchValidationData(sheetObj, val_type, val_value)) {
		    			sheetObj.CellValue2(row,col_save_name) = "";
		    			sheetObj.SelectCell(row, col);
		    		}
		    	}
    	}else if(col_save_name == "bkg_por_scc_cd" || col_save_name == "bkg_del_scc_cd" ){
        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	    		val_type = "SCC";
	    		val_value = sheetObj.CellValue(row,col_save_name); 
	    		if(!searchValidationData(sheetObj, val_type, val_value)) {
	    			sheetObj.CellValue2(row,col_save_name) = "";
	    			sheetObj.SelectCell(row, col);
	    		}
	    	}	
	    } else if(col_save_name == "por_nod_cd" || col_save_name == "pol_nod_cd" ||
      		  col_save_name == "pod_nod_cd" || col_save_name == "del_nod_cd") {
	    	if(sheetObj.CellValue(row,col_save_name)!="" ){
	    		val_type = "NODE";
	    		val_value = sheetObj.CellValue(row,col_save_name); 
	    		if(!searchValidationData(sheetObj, val_type, val_value)) {
	    			sheetObj.CellValue2(row,col_save_name) = "";
	    			sheetObj.SelectCell(row, col);
	    		}
	    	}	
	    }
		
 	}
	
	/**
	 * 저장시 시트의 값에 따른 Validation을 실시한다.<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} lane_cd  
	 * @param {String} dir_cd  
	 * @param {String} cmdt_cd 
	 * @returns bool <br>
	 *          true  : 폼입력값이 유효할 경우<br>
	 *          false : 폼입력값이 유효하지 않을 경우
	 * @author 최문환
	 * @version 2014.01.07
	 */
	function searchValidationData(sheetObj, val_type, val_value) {
		var formObj = document.form;
		var sParam  = "";

		//sheetFlag Y이면 시트에 입력된값을 기준으로 Validation하고 ""이면 FormObject를 기준으로 Validation한다.		
    	if(sheetFlag == "Y"){
    		sParam = "f_cmd=102&" + "&val_type="+val_type+"&val_value="+val_value;
    	} else{
    		formObj.f_cmd.value = SEARCH02;
    		sParam = FormQueryString(formObj);    		
    	}
    	
    	sheetFlag = "";
    	
    	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1215GS.do", sParam);    	
    	var val_cnt  = ComGetEtcData(sXml, "val_cnt");

		if(val_cnt < 1 && val_cnt != ""){
			ComShowCodeMessage('BKG00993',val_type + " : " + val_value);			
			return false;
		}
		 
		return true;
	}
	
	/**
	 * IBSheet 저장 함수를 이용하여 저장이 완료되고 발생하는 Event<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} ErrMsg 저장 후 메시지
	 * @return 없음
	 * @author 최문환
	 * @version 2014.01.07
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if (ErrMsg == "") {
			doActionIBSheet(sheetObj,document.form,IBSEARCH);
			formObj.dirty_flag.value = 'N';
		}
    }
	
	/**
	 * IBSheet 저장 함수를 이용하여 조회가 완료되고 발생하는 Event<br>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} ErrMsg 저장 후 메시지
	 * @return 없음
	 * @author 최문환
	 * @version 2014.01.07
	 */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	with(sheetObj){
    		for (i=HeaderRows ; i<= LastRow; i++) {
    			if(sheetObj.CellValue(i, "ibflag") != "I"){
    				CellEditable(i,"bkg_aloc_tp_cd") = false;
    			}    			
  			}
  		}
    }    
    
	/**
	 * IBSheet 선택 Cell 변경 Event<br>
	 * @return 없음
	 * @author 최문환
	 * @version 2014.01.07
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, row, col){
    	with(sheetObj){
    		//alert(CellValue(row, "bkg_aloc_tp_cd"));
	    	if(CellValue(row, "bkg_aloc_tp_cd") == "T"){
	    		//CellEditable(row,"vvd")          = false;      		
	    		CellEditable(row,"por_cd")           = false;
	    		CellEditable(row,"pol_cd")           = false;
	    		CellEditable(row,"por_nod_cd")       = false;      	
	    		CellEditable(row,"bkg_por_scc_cd")   = false;      		
	    		CellEditable(row,"pol_nod_cd")       = false;      	
	    		CellEditable(row,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cd")   = false;    
	    		CellEditable(row,"n1st_ts_slan_cd")  = false; 
	    		CellEditable(row,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_dir_cd")  = false;
	    		CellEditable(row,"pod_cd")           = false;      		
	    		CellEditable(row,"pod_nod_cd")       = false;      	
				CellEditable(row,"del_cd")           = false;      		
				CellEditable(row,"del_nod_cd")       = false;      	
				CellEditable(row,"bkg_del_scc_cd")   = false;    
				CellEditable(row,"cntr_tpsz_cd")     = false;      
				CellEditable(row,"sc_no")            = false; 
				CellEditable(row,"rfa_no")           = false;
				CellEditable(row,"ctrt_cust_cnt_cd") = false;
				CellEditable(row,"cust_cnt_cd")      = false; 
				CellEditable(row,"ctrt_cust_seq")    = false;
				CellEditable(row,"cust_seq")         = false;
				CellEditable(row,"cmdt_cd")          = false;
				CellEditable(row,"cmdt_nm")          = false;
				CellEditable(row,"scg_grp_cmdt_seq")   = false;
				CellEditable(row,"aloc_lod_qty")     = false; 
				//CellEditable(row,"aloc_svc_cd")      = false;      	
				CellEditable(row,"bkg_aloc_rmk")     = false;	 
				CellEditable(row,"bkg_aloc_rmk")     = false;	  
				CellEditable(row,"bkg_por_cnt_cd")   = false;
				CellEditable(row,"bkg_pol_cnt_cd")   = false;
				CellEditable(row,"bkg_pod_cnt_cd")   = false;
				CellEditable(row,"bkg_del_cnt_cd")   = false;
	    	}
	    	if(CellValue(row, "bkg_aloc_tp_cd") == "S"){
	    		CellEditable(row,"cntr_tpsz_cd")     = false;      
				CellEditable(row,"sc_no")            = false;
				CellEditable(row,"rfa_no")           = false; 
				CellEditable(row,"ctrt_cust_cnt_cd") = false;
				CellEditable(row,"cust_cnt_cd")      = false;
				CellEditable(row,"ctrt_cust_seq")    = false;
				CellEditable(row,"cust_seq")         = false;
				CellEditable(row,"cmdt_cd")          = false;
				CellEditable(row,"cmdt_nm")          = false;
				CellEditable(row,"scg_grp_cmdt_seq")   = false;
				CellEditable(row,"bkg_aloc_rmk")     = false;		
				CellEditable(row,"trunk_pol_cd")     = false;
				CellEditable(row,"trunk_pod_cd")     = false; 
	    	}
	    	if(CellValue(row, "bkg_aloc_tp_cd") == "E"){
				CellEditable(row,"sc_no")            = false;
				CellEditable(row,"rfa_no")           = false;
				CellEditable(row,"ctrt_cust_cnt_cd") = false;
				CellEditable(row,"cust_cnt_cd")      = false;
				CellEditable(row,"ctrt_cust_seq")    = false;
				CellEditable(row,"cust_seq")         = false;
				CellEditable(row,"aloc_lod_qty")     = false;      
				CellEditable(row,"aloc_lod_qty_rto") = false;
				CellEditable(row,"cmdt_nm")          = false;
				CellEditable(row,"cmdt_cd")          = false;
				CellEditable(row,"scg_grp_cmdt_seq")   = false;
				CellEditable(row,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_dir_cd")  = false;
	    		CellEditable(row,"trunk_pol_cd")     = false;
				CellEditable(row,"trunk_pod_cd")     = false; 
				CellEditable(row,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cd")   = false;    
	    	}
	    	if(CellValue(row, "bkg_aloc_tp_cd") == "M"){
				CellEditable(row,"sc_no")            = false;
				CellEditable(row,"rfa_no")           = false;
				CellEditable(row,"ctrt_cust_cnt_cd") = false;
				CellEditable(row,"cust_cnt_cd")      = false;	
				CellEditable(row,"ctrt_cust_seq")    = false;
				CellEditable(row,"cust_seq")         = false;
				CellEditable(row,"cmdt_nm")          = false;
				CellEditable(row,"aloc_lod_qty")     = false;      
				CellEditable(row,"aloc_lod_qty_rto") = false;
				CellEditable(row,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_dir_cd")  = false;
	    		CellEditable(row,"trunk_pol_cd")     = false;
				CellEditable(row,"trunk_pod_cd")     = false; 
				CellEditable(row,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cd")   = false; 
	    	}
	    	if(CellValue(row, "bkg_aloc_tp_cd") == "C"){
	    		CellEditable(row,"cmdt_nm")          = false;	
	    		CellEditable(row,"aloc_lod_qty")     = false;      
				CellEditable(row,"aloc_lod_qty_rto") = false;
				CellEditable(row,"n1st_ts_pol_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cnt_cd")   = false;    
	    		CellEditable(row,"n1st_ts_dir_cd")  = false;
	    		CellEditable(row,"trunk_pol_cd")     = false;
				CellEditable(row,"trunk_pod_cd")     = false; 
				CellEditable(row,"n1st_ts_pol_cd")   = false;    
	    		CellEditable(row,"n1st_ts_pod_cd")   = false; 
	    	}
	    	CellEditable(row,"upd_usr_id")          = false;	
	    	CellEditable(row,"upd_dt")          = false;	
    	}
    }      
    
	/**
     * 시트를 클릭했을 때 처리
     */
	function sheet1_OnClick(sheetObj, row, col) {
	    	
		var colSaveName = sheetObj.ColSaveName(col);
		
		switch(colSaveName) {
			case "bkg_aloc_rmk" :
				//document.form.dirty_flag.value = 'Y';
	    		/* 긴 문자열 MemoPad 처리*/
				if (sheetObj.CellValue(row,"bkg_aloc_tp_cd") != 'T') {
	    			sheetObj.CellEditable(row, col) = false;
	    			ComShowMemoPad(sheetObj, row, col, false, 250, 100);
	    			sheetObj.CellEditable(row, col) = true;
				} 
    		break;
		}
	}    
	
    /**
     * sheet1에서 이미지버튼을 클릭한 경우 를 처리한다.
     * gubun A인경우 C1T0W 가 아닌경우
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
     function sheet1_OnPopupClick(sheetObj, row, col){
     	 var colSaveName = sheetObj.ColSaveName(col);
 	 	 switch(colSaveName) {
			 case "trunk_pol_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"trnk_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"trnk_dir_cd");
					param = param + "&loc_cd_tp=" + "TPOL";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"trunk_pol_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_BKG_1215";
					ComOpenPopup('/hanjin/ESM_BKG_1214.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;
			 case "trunk_pod_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"trnk_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"trnk_dir_cd");
					param = param + "&loc_cd_tp=" + "TPOD";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"trunk_pod_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_BKG_1215";
					ComOpenPopup('/hanjin/ESM_BKG_1214.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;	 
			 case "n1st_ts_pol_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"n1st_ts_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"n1st_ts_dir_cd");
					param = param + "&loc_cd_tp=" + "SPOL";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"n1st_ts_pol_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_BKG_1215";
					ComOpenPopup('/hanjin/ESM_BKG_1214.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;
			 case "n1st_ts_pod_cd":
	    			var param = "";
					param = param + "?trnk_slan_cd=" + sheetObj.CellValue(row,"n1st_ts_slan_cd");
					param = param + "&trnk_dir_cd=" + sheetObj.CellValue(row,"n1st_ts_dir_cd");
					param = param + "&loc_cd_tp=" + "SPOD";
					param = param + "&loc_multi_cd=" + sheetObj.CellValue(row,"n1st_ts_pod_cd");
					param = param + "&org_sheet=" + "0";
					param = param + "&org_row=" + row;
					param = param + "&org_ui_id=" + "ESM_BKG_1215";
					ComOpenPopup('/hanjin/ESM_BKG_1214.do' + param, 340,420,'', '1,0,1,1,1,1,1,1', true);
	    		  break;	    		  
	    		  
 		 }
    	//var bkg_aloc_seq = 
 		/*var sUrl = "/hanjin/ESD_SCE_0124.do";
 		var rout_rcv_dt = sheetObj.CellValue(Row,  sheetObj.SaveNameCol(prefix1+"rout_rcv_dt"));
 		var rout_seq = sheetObj.CellValue(Row,  sheetObj.SaveNameCol(prefix1+"rout_seq"));
 		var param = "?gubun=A&rout_rcv_dt="+rout_rcv_dt+"&rout_seq="+rout_seq;
 		ComOpenPopup(sUrl + param, 428, 430, "", "none",true);*/
     }
	
	/* 개발자 작업  끝 */