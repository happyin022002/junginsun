/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_7011.js
*@FileTitle : DEM/DET User Role Match
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : Lim Chang Bin
*@LastVersion : 1.0
* 2013.07.16 Lim Chang Bin
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
     * @class EES_DMT_7011 : EES_DMT_7011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_7011() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

    //  업무전역변수
    var tmp_type_cd = "";
    var tmp_type_nm = "";
    
    var arrMultiCombo;//멀티콤보 세팅할 변수
    
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
                        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                        break;
                    case "btn_new":
                    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
                        break;
                    case "btn_save":
                    	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                        break;
                    case "btn_RowAdd": 
                    	doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                        break;
                    case "btn_RowDelete":
                    	ComRowHideDelete(sheetObjects[0],"del_chk");
                        break;
                    case "btn_downExcel":
                        sheetObjects[0].speedDown2Excel(-1);
                        break;
                    case "btn_ofc_cd":
                		ComOpenPopup('COM_ENS_071.do', 770, 470, "getDmdtOfcCd", "1,0,1,1,1,1,1", true);
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
    
    /*
   	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
   	 */
    function getDmdtOfcCd(aryPopupData) {
    	document.form.dmdt_ofc_cd.value = aryPopupData[0][3];
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
    	// IBMultiCombo초기화 
    	for(var k=0;k<comboObjects.length;k++){
    		initCombo(comboObjects[k],k+1);
    	}
    	
    	//html컨트롤 이벤트초기화
	    for(i=0;i<sheetObjects.length;i++){
	    	ComConfigSheet (sheetObjects[i] );
	    	initSheet(sheetObjects[i],i+1);
	    	ComEndConfigSheet(sheetObjects[i]);
	    }
    
	    initControl();
    }
    
    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}
   
    // 이벤트 처리 함수 선언
    function initControl() {
        axon_event.addListenerFormat('keypress','obj_keypress', document.form);         //- 키보드 입력할때
        axon_event.addListenerForm('change', 'obj_change', form);
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');    // 'Incl. CNTR Column' CheckBox 클릭시
    }
     
    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
         switch(event.srcElement.dataformat){
            case "engup":
                // 영문대
                ComKeyOnlyAlphabet('upper');
                break;
    	 	case "engnum":
		    	// 영대문자+숫자 
         		ComKeyOnlyAlphabet('uppernum');
		        break;
            case "int":
                //숫자 만입력하기
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                // 숫자만입력하기(정수,날짜,시간)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
	
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "dmdt_expt_apro_tp_cd":
				with(comboObj) {

			   	 	DropHeight = 200;
			   	 	
				    //DMT Role Code
			    	var type_cd = form.type_cd.value;
			    	var type_nm = form.type_nm.value;
			    	
			    	type_cd = "|"+type_cd;
			    	type_nm = "All|"+type_nm;
			    	
			    	var arr_type_cd = type_cd.split("|");
			    	var arr_type_nm = type_nm.split("|");
	
				    with (form.dmdt_expt_apro_tp_cd) {
				   	 	for ( var i=0; i<arr_type_cd.length; i++) {
				   	 			InsertItem(i, arr_type_nm[i], arr_type_cd[i]);
				   	 	}	   	 
				    } 
				    
				}
			
			break;
			case "ofc_lvl":
				with(comboObj) {

		   	 	DropHeight = 200;
		   	 	
			    //DMT Role Code
		    	var ofc_lvl_cd = form.ofc_lvl_cd.value;
		    	var ofc_lvl_nm = form.ofc_lvl_nm.value;
		    	
		    	var arr_ofc_lvl_cd = ofc_lvl_cd.split("|");
		    	var arr_ofc_lvl_nm = ofc_lvl_nm.split("|");

			    with (form.ofc_lvl) {
			   	 	for ( var i=0; i<arr_ofc_lvl_cd.length; i++) {
			   	 			InsertItem(i, arr_ofc_lvl_nm[i], arr_ofc_lvl_cd[i]);
			   	 	}	   	 
			    } 
			    
			}
		
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
        var formObject = document.form;
        
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 425;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "||Type|Office Level|Control OFC|dmdt_seq|Customer|Add Days|Total Days|Tariff DC|Ratio(%)|Amount($)|Branch OFC|Branch OFC|Regional HQ|Regional HQ|Regional HQ|Head OFC|Head OFC|Update|Update";
                    var HeadTitle2 = "||Type|Office Level|Control OFC|dmdt_seq|Customer|Add Days|Total Days|Tariff DC|Ratio(%)|Amount($)|BBG|Deputy|PIC|V.P|Deputy|HO|Deputy|User|Time";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false); 

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty( 0 , cnt++ , dtHiddenStatus	, 30	, daCenter	, false	, "ibflag");
                    InitDataProperty( 0	, cnt++ , dtCheckBox		, 30	, daCenter	, true 	, "del_chk");
                    InitDataProperty( 0 , cnt++ , dtCombo 			, 60  	, daCenter  , true 	, "dmdt_expt_apro_tp_cd"    		, true 	, "" , dfNone,	0, false,	true	);
                    InitDataProperty( 0 , cnt++ , dtCombo 			, 90  	, daCenter 	, true 	, "ofc_lvl"    						, true 	, "" , dfNone,	0, false,	true	);
                    InitDataProperty( 0 , cnt++ , dtData 			, 90  	, daCenter 	, true 	, "dmdt_ofc_cd"    					, true 	, "" , dfEngUpKey,	0, false,	true	);
                    InitDataProperty( 0 , cnt++ , dtHidden 			, 120  	, daCenter 	, true 	, "dmdt_seq"    					, true 	, "" , dfNone,	0, false,	true	);
                    InitDataProperty( 0 , cnt++ , dtHidden 			, 100  	, daCenter 	, true 	, "cust_cd"    						, true 	, "" , dfNone,	0, false,	true	);
                    InitDataProperty( 0 , cnt++ , dtData 			, 100  	, daCenter 	, true 	, "ft_add_dys"    					, false , "" , dfNullInteger,	0, true,	true	,2);
                    InitDataProperty( 0 , cnt++ , dtData 			, 100  	, daCenter 	, true 	, "ft_ttl_dys"    					, false	, "" , dfNullInteger,	0, true,	true	,2);
                    InitDataProperty( 0 , cnt++ , dtCheckBox		, 100  	, daCenter 	, true 	, "dc_flg"    						, false	, "" , dfNone,	0, true,	true	);
                    InitDataProperty( 0 , cnt++ , dtData 			, 80  	, daCenter 	, true 	, "dc_rto"    						, false	, "" , dfNullFloat,	2, true,	true	,4);
                    InitDataProperty( 0 , cnt++ , dtData 			, 80  	, daCenter 	, true 	, "dc_amt"    						, false	, "" , dfNullFloat,	2, true,	true	,13);
                    InitDataProperty( 0 , cnt++ , dtCheckBox 		, 80  	, daCenter 	, true 	, "dmdt_brnc_flg"    				, false	, "" , dfNone,	0, true,	true	);
                    InitDataProperty( 0 , cnt++ , dtHidden 			, 120  	, daCenter 	, true 	, "dmdt_brnc_subst_id"    			, false	, "" , dfNone,	0, false,	false	);
                    InitDataProperty( 0 , cnt++ , dtCheckBox 		, 60  	, daCenter 	, true 	, "dmdt_rhq_pic_flg"    			, false	, "" , dfNone,	0, false,	false	);
                    InitDataProperty( 0 , cnt++ , dtCheckBox 		, 60  	, daCenter 	, true 	, "dmdt_rhq_flg"    				, false , "" , dfNone,	0, true,	true	);
                    InitDataProperty( 0 , cnt++ , dtHidden 			, 120  	, daCenter 	, true 	, "dmdt_rhq_subst_id"    			, false	, "" , dfNone,	0, false,	false	);
                    InitDataProperty( 0 , cnt++ , dtCheckBox 		, 80  	, daCenter 	, true 	, "dmdt_ho_flg"	    				, false	, "" , dfNone,	0, true,	true	);
                    InitDataProperty( 0 , cnt++ , dtHidden			, 120  	, daCenter 	, true 	, "dmdt_ho_subst_id"    			, false	, "" , dfNone,	0, false,	false	);
                    InitDataProperty( 0 , cnt++ , dtData 			, 120  	, daCenter 	, true 	, "upd_usr_id"    					, false	, "" , dfNone,	0, false,	false	);
                    InitDataProperty( 0 , cnt++ , dtData 			, 120  	, daCenter 	, true 	, "upd_dt"    						, false	, "" , dfNone,	0, false,	false	);

                    InitDataCombo(0, 2, formObject.type_nm.value, formObject.type_cd.value);    // IBSheet내 Combo 초기화
                    InitDataCombo(0, 3, formObject.ofc_lvl_nm.value, formObject.ofc_lvl_cd.value);    // IBSheet내 Combo 초기화
                    
                }
                
            break;
        }
    }

// Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
            case IBSEARCH:      //조회
//                if(!validateForm(sheetObj,formObj,sAction)) return;
                
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("EES_DMT_7011GS.do", FormQueryString(formObj));
                
                for(var ir=2;ir< sheetObj.RowCount+2;ir++){
                	if ( sheetObj.CellValue(ir, "dmdt_expt_apro_tp_cd") == "D"){
        	  			sheetObj.CellEditable(ir,"dc_flg") = false;
        	  			sheetObj.CellEditable(ir,"dc_rto") = true;
        	  			sheetObj.CellEditable(ir,"dc_amt") = true; 	
                	} else if ( sheetObj.CellValue(ir, "dmdt_expt_apro_tp_cd") == "B"){
        	  			sheetObj.CellEditable(ir,"dc_flg") = true;
        	  			sheetObj.CellEditable(ir,"dc_rto") = false;
        	  			sheetObj.CellEditable(ir,"dc_amt") = false;
                	}
                	if ( sheetObj.CellValue(ir, "ofc_lvl") == "A"){
		  	  			sheetObj.CellEditable(ir,"dmdt_ho_subst_id") = true;
                	} else if ( sheetObj.CellValue(ir, "ofc_lvl") == "R"){
      					sheetObj.InitCellProperty(ir,"dmdt_ofc_cd",dtCombo);
      					sheetObj.CellComboItem(ir,"dmdt_ofc_cd","NYCRA|HAMRU|SHARC|SINRS|SELIB|TYOIB|VVOIA","NYCRA|HAMRU|SHARC|SINRS|SELIB|TYOIB|VVOIA");
      					
		  	  			sheetObj.CellEditable(ir,"dmdt_rhq_subst_id") = true;
		  	  			sheetObj.CellEditable(ir,"dmdt_ho_subst_id") = true;
                	} else if ( sheetObj.CellValue(ir, "ofc_lvl") == "B"){
	  					sheetObj.CellEditable(ir,"dmdt_brnc_subst_id") = true;
		  	  			sheetObj.CellEditable(ir,"dmdt_rhq_subst_id") = true;
		  	  			sheetObj.CellEditable(ir,"dmdt_ho_subst_id") = true;
                	}
                	
                }                

                break;
                
            case IBCLEAR:	// 화면 초기화 작업
            	
            	ComResetAll();		//sheet 초기화.
            	var comboObj = comboObjects[0]
            	comboObj.Code = "";

            	for(var i = 0 ; i < comboObj.GetCount() ; i++) {
            		comboObj.CheckIndex(i) = true;
    	    	}

            	break;
            	            	
            case IBINSERT:
            	var row = sheetObj.DataInsert(-1);
            	
            	sheetObj.Cellvalue2(row, 'dmdt_ofc_cd') = 'All';            	
            	sheetObj.Cellvalue2(row, 'cust_cd') = 'All';            	
              	
            	sheetObj.Cellvalue2(row, 'dmdt_rhq_pic_flg') = 1;
            	
            	sheet1_OnChange (sheetObj, row, 2, sheetObj.Cellvalue(row, 2));

            	sheetObj.CellEditable(row, 'dmdt_ofc_cd') = false; 
            	
            	sheetObj.CellEditable(row,"dmdt_brnc_subst_id") = false;

            	sheetObj.CellEditable(row,"dmdt_rhq_subst_id") = false;

            	sheetObj.CellEditable(row,"dmdt_ho_subst_id") = false;
  				
            	break;
            	
            case IBSAVE:
            	
                if(!validateForm(sheetObj,formObj,sAction)) return;
            	
            	var sParam = ComGetSaveString(sheetObj);
            	if (sParam == "") return;
            	
        		var dataChangeFlag = false;
            	var ttlCnt = sheetObj.RowCount;	            	

            	for(var i=1; i<=ttlCnt + 1; i++){
				   //Insert & Delete 일 경우 서비스를 호출한다.
				   if(sheetObj.CellValue(i,"ibflag") == "I" || sheetObj.CellValue(i,"ibflag") == "D" || sheetObj.CellValue(i,"ibflag") == "U"){
					   dataChangeFlag = true;
					   break;
				   }
				}
            	
            	if (!dataChangeFlag) {
            		ComShowCodeMessage("DMT01113");
            		return; //바뀐 데이터가 없을 경우 리턴한다.
            	}
				
            	if (!ComShowCodeConfirm("COM130101")) return;
            		
            	formObj.f_cmd.value = MULTI;
            	
            	var sParam = ComGetSaveString(sheetObj, false);
			    sParam += "&" + FormQueryString(formObj);
			               	
            	var sXml = sheetObj.GetSaveXml("EES_DMT_7011GS.do", sParam);
            	
            	//조회 후 결과처리
				var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				sheetObj.LoadSaveXml(sXml);
				
				if ( svcResult == "S" ) {
					// 저장 성공시에만 재조회 실행.
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
                
            	break;
         }
     }
 	
     /**
      * 체크박스 전체해제시에 알림 및 버튼 활성화 여부
      * @param sheetObj
      * @param Row
      * @param Col
      * @param Value
      * @return
      */
  	function sheet1_OnChange (sheetObj, Row, Col, Value) {
  		var formObj 		= document.form;
		var sName 			= sheetObj.ColSaveName(Col);
  		if(sName == "dmdt_expt_apro_tp_cd") {
  			if(Value == "D"){
	  			sheetObj.CellEditable(Row,"dc_flg") = false;
	  			sheetObj.CellEditable(Row,"dc_rto") = true;
	  			sheetObj.CellEditable(Row,"dc_amt") = true; 	
	  			
	  			sheetObj.CellValue2(Row,"dc_flg") = 0;
	  			sheetObj.CellValue2(Row,"dc_rto") = "";
	  			sheetObj.CellValue2(Row,"dc_amt") = "";
	  			
  			} else if(Value == "B" || Value == "S") {
	  			sheetObj.CellEditable(Row,"dc_flg") = true;
	  			sheetObj.CellEditable(Row,"dc_rto") = false;
	  			sheetObj.CellEditable(Row,"dc_amt") = false;	  
	  			
	  			sheetObj.CellValue2(Row,"dc_flg") = 0;
	  			sheetObj.CellValue2(Row,"dc_rto") = "";
	  			sheetObj.CellValue2(Row,"dc_amt") = "";
  			}
  		} else if (sName == "ofc_lvl"){
  			if(Value == "A"){
  				sheetObj.CellEditable(Row,"dmdt_ofc_cd") = false;
  				sheetObj.CellValue2(Row,"dmdt_ofc_cd") = "All";
  			} else {
  				sheetObj.CellEditable(Row,"dmdt_ofc_cd") = true;
  				if(Value == "R"){
  					sheetObj.InitCellProperty(Row,"dmdt_ofc_cd",dtCombo);
  					sheetObj.CellComboItem(Row,"dmdt_ofc_cd","NYCRA|HAMRU|SHARC|SINRS|SELIB|TYOIB|VVOIA","NYCRA|HAMRU|SHARC|SINRS|SELIB|TYOIB|VVOIA");

  					sheetObj.CellEditable(Row,"dmdt_brnc_subst_id") = false;
  	  				sheetObj.CellValue2(Row,"dmdt_brnc_subst_id") = "";
  					sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = true;
  	  				sheetObj.CellValue2(Row,"dmdt_rhq_subst_id") = "";
  	  			} else if(Value == "B"){
  					sheetObj.InitCellProperty(Row,"dmdt_ofc_cd",dtPopupEdit);
  					sheetObj.CellValue2(Row,"dmdt_ofc_cd") = "";
  					if ( (sheetObj.CellValue(Row,"dmdt_brnc_flg") == "1" || sheetObj.CellValue(Row,"dmdt_brnc_flg") == "Y" ) ){
	  					sheetObj.CellEditable(Row,"dmdt_brnc_subst_id") = true;
		  	  			sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = true;
		  	  			sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = true;
  					} else {
  						sheetObj.CellEditable(Row,"dmdt_brnc_subst_id") = false;
	  	  				sheetObj.CellValue2(Row,"dmdt_brnc_subst_id") = "";
		  	  			sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = false;
	  	  				sheetObj.CellValue2(Row,"dmdt_rhq_subst_id") = "";
		  	  			sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = false;
	  	  				sheetObj.CellValue2(Row,"dmdt_ho_subst_id") = "";
  					}
  					if ( (sheetObj.CellValue(Row,"dmdt_rhq_flg") == "1" || sheetObj.CellValue(Row,"dmdt_rhq_flg") == "Y" ) ){
	  					sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = true;
	  					sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = true;
  					} else {
	  					sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = false;
	  	  				sheetObj.CellValue2(Row,"dmdt_rhq_subst_id") = "";
	  					sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = false;
	  	  				sheetObj.CellValue2(Row,"dmdt_ho_subst_id") = "";
  					}
  					if ( (sheetObj.CellValue(Row,"dmdt_ho_flg") == "1" || sheetObj.CellValue(Row,"dmdt_ho_flg") == "Y" ) ){
	  					sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = true;
  					} else {
	  					sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = false;
	  	  				sheetObj.CellValue2(Row,"dmdt_ho_subst_id") = "";
  					}
  	  			}
  			}
  			
  		} else if (sName == "dmdt_brnc_flg"){
  			if(( Value == "1" || Value == "Y") && sheetObj.CellValue(Row,"ofc_lvl") == "B"){
  				sheetObj.CellEditable(Row,"dmdt_brnc_subst_id") = true;
  				sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = true;
  				sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = true;
  			} else {
  				sheetObj.CellEditable(Row,"dmdt_brnc_subst_id") = false;
  				sheetObj.CellValue(Row,"dmdt_brnc_subst_id") = "";
  				sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = false;
  				sheetObj.CellValue(Row,"dmdt_rhq_subst_id") = "";
  				sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = false;
  				sheetObj.CellValue(Row,"dmdt_ho_subst_id") = "";
  			}
  		} else if (sName == "dmdt_rhq_flg"){
  			if(( Value == "1" || Value == "Y" ) && ( sheetObj.CellValue(Row,"ofc_lvl") == "B" || sheetObj.CellValue(Row,"ofc_lvl") == "R" )){
  				sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = true;
  				sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = true;
  			} else {
  				sheetObj.CellEditable(Row,"dmdt_rhq_subst_id") = false;
  				sheetObj.CellValue(Row,"dmdt_rhq_subst_id") = "";
  				sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = false;
  				sheetObj.CellValue(Row,"dmdt_ho_subst_id") = "";
  			}
  		} else if (sName == "dmdt_ho_flg"){
  			if((Value == "1" || Value == "Y" )){
  				sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = true;
  			} else {
  				sheetObj.CellEditable(Row,"dmdt_ho_subst_id") = false;
  				sheetObj.CellValue(Row,"dmdt_ho_subst_id") = "";
  			}
  		} else if (sName == "cust_cd"){
  			if( Value.toUpperCase() != "ALL" && Value.toUpperCase() != "" ){
  				if ( eval(Value.substr(2)) > 0 ){
  					sheetObj.CellValue(Row,"cust_cd") = Value.substr(0,2).toUpperCase()+eval(Value.substr(2));
  				} else {
  					sheetObj.CellValue(Row,"cust_cd") = "All";
  				}
  			} else {
  				sheetObj.CellValue(Row,"cust_cd") = "All";
  			}
  		} else if (sName == "ft_add_dys"){
  			if ( Value == 0 )
  				sheetObj.CellValue(Row,"ft_add_dys") = "";
  		} else if (sName == "ft_ttl_dys"){
  			if ( Value == 0 )
  				sheetObj.CellValue(Row,"ft_ttl_dys") = "";
  		} else if (sName == "dc_rto"){
  			if ( Value == 0 )
  				sheetObj.CellValue(Row,"dc_rto") = "";
  		} else if (sName == "dc_amt"){
  			if ( Value == 0 )
  				sheetObj.CellValue(Row,"dc_amt") = "";
  		}
  	}
  	
    //Sheet1 체크 이벤트
    function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
    	var sName 			= sheetObj.ColSaveName(Col);
    	if(sName == "dmdt_ofc_cd" && sheetObj.CellValue(Row,"ofc_lvl") == "B") {
    		ComOpenPopup('COM_ENS_071.do', 770, 470, "getCtrtOfcCd", "1,0,1,1,1,1,1", true);
    	} else if ( sName == "dmdt_brnc_subst_id" && ( sheetObj.CellValue(Row,"dmdt_brnc_flg") == "1" || sheetObj.CellValue(Row,"dmdt_brnc_flg") == "Y" ) && sheetObj.CellValue(Row,"ofc_lvl") == "B"){
    		ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setBrncUsrId", "1,0,1,1,1,1,1", true);
    	} else if ( sName == "dmdt_rhq_subst_id" && ( sheetObj.CellValue(Row,"dmdt_rhq_flg") == "1" || sheetObj.CellValue(Row,"dmdt_rhq_flg") == "Y" ) && sheetObj.CellValue(Row,"ofc_lvl") == "B"){
    		ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setRhqcUsrId", "1,0,1,1,1,1,1", true);
    	} else if ( sName == "dmdt_ho_subst_id"  && ( sheetObj.CellValue(Row,"dmdt_ho_flg") == "1" || sheetObj.CellValue(Row,"dmdt_ho_flg") == "Y" )  && sheetObj.CellValue(Row,"ofc_lvl") == "B"){
    		ComOpenPopup('/hanjin/COM_ENS_091.do', 770, 570, "setHoUsrId", "1,0,1,1,1,1,1", true);
    	} else if ( sName == "cust_cd" && sheetObj.RowStatus(Row) == 'I'){
    		ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
    	}
    }
    
    /*
   	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
   	 */
    function getCtrtOfcCd(aryPopupData) {
    	var selectRow = sheetObjects[0].SelectRow;
    	sheetObjects[0].CellValue2(selectRow, "dmdt_ofc_cd") = aryPopupData[0][3];
    }	
  
	function setBrncUsrId(aryPopupData){
		var selectRow = sheetObjects[0].SelectRow;
    	sheetObjects[0].CellValue2(selectRow, "dmdt_brnc_subst_id") = aryPopupData[0][4];
 	} 
	
	function setRhqcUsrId(aryPopupData){
		var selectRow = sheetObjects[0].SelectRow;
    	sheetObjects[0].CellValue2(selectRow, "dmdt_rhq_subst_id") = aryPopupData[0][4];
 	} 
	
	function setHoUsrId(aryPopupData){
		var selectRow = sheetObjects[0].SelectRow;
    	sheetObjects[0].CellValue2(selectRow, "dmdt_ho_subst_id") = aryPopupData[0][4];
 	} 
	
	function getCustCd(aryPopupData) {
		var selectRow = sheetObjects[0].SelectRow;
		sheetObjects[0].CellValue(selectRow, "cust_cd") = aryPopupData[0][3];
    }
    
    function keyPress() {
        var eventKey = window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    
    document.onkeypress = keyPress ; 

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {        	
        	case IBSAVE:
        		
        		for(var ir=2;ir< sheetObj.RowCount+2;ir++){
        			if(sheetObj.RowStatus(ir) == 'I'){
        				for(var i=ir+1;i< sheetObj.RowCount+2;i++){        					
        					if(sheetObj.CellValue(ir, "dmdt_expt_apro_tp_cd") == sheetObj.CellValue(i, "dmdt_expt_apro_tp_cd")
        					&& sheetObj.CellValue(ir, "ofc_lvl") == sheetObj.CellValue(i, "ofc_lvl")
        					&& sheetObj.CellValue(ir, "dmdt_ofc_cd") == sheetObj.CellValue(i, "dmdt_ofc_cd")
        					&& sheetObj.CellValue(ir, "cust_cd") == sheetObj.CellValue(i, "cust_cd")){
        						ComShowCodeMessage('DMT00144', "Approval Setup");
    		        			sheetObj.SelectCell(i, "dmdt_expt_apro_tp_cd");
    		        			return false;
        					}
        				}
						var params = "dmdt_expt_apro_tp_cd=" + sheetObj.CellValue(ir, "dmdt_expt_apro_tp_cd");
						params = params + "&" + "ofc_lvl=" + sheetObj.CellValue(ir, "ofc_lvl");
						params = params + "&" + "dmdt_ofc_cd=" + sheetObj.CellValue(ir, "dmdt_ofc_cd");
						params = params + "&" + "cust_cd=" + sheetObj.CellValue(ir, "cust_cd");
						
						params += "&&f_cmd=" + SEARCH01;

		        		var sXml = sheetObj.GetSaveXml("EES_DMT_7011GS.do", params);
		        		
		        		if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
		        			sheetObj.LoadSaveXml(sXml);
		        			sheetObj.SelectCell(ir, "dmdt_expt_apro_tp_cd");
		        			return false;
		        		} else if (ComGetEtcData(sXml, "VAL_FLAG") != "N") {
		        			ComShowCodeMessage('DMT00144', "Approval Setup");
		        			sheetObj.SelectCell(ir, "dmdt_expt_apro_tp_cd");
		        			return false;
		        		}
					}
        		}
        		
				for(var ir=2;ir< sheetObj.RowCount+2;ir++){
					
					if(sheetObj.RowStatus(ir) == 'D') continue;
					
					if(ComIsEmpty(sheetObj.CellValue(ir, "dmdt_expt_apro_tp_cd"))){
						ComShowCodeMessage('DMT05014', "Type");
						sheetObj.SelectCell(ir, "dmdt_expt_apro_tp_cd");
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(ir, "ofc_lvl"))){
						ComShowCodeMessage('DMT05014', "Office Level");
						sheetObj.SelectCell(ir, "ofc_lvl");
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(ir, "dmdt_ofc_cd"))){
						ComShowCodeMessage('DMT05014', "Control OFC");
						sheetObj.SelectCell(ir, "dmdt_ofc_cd");
						return false;
					}
					if(ComIsEmpty(sheetObj.CellValue(ir, "cust_cd"))){
						ComShowCodeMessage('DMT05014', "Csutomer");
						sheetObj.SelectCell(ir, "cust_cd");
						return false;
					}		
					
					if(ComIsEmpty(sheetObj.CellValue(ir, "ft_add_dys")) && ComIsEmpty(sheetObj.CellValue(ir, "ft_ttl_dys")) &&
						ComIsEmpty(sheetObj.CellValue(ir, "dc_flg")) && ComIsEmpty(sheetObj.CellValue(ir, "dc_rto")) && ComIsEmpty(sheetObj.CellValue(ir, "dc_amt"))){
						ComShowCodeMessage('DMT05014', "Add Days or Total Days or Tariff DC or Ratio or Amount");
						sheetObj.SelectCell(ir, "ft_add_dys");
						return false;
					}
					if((sheetObj.CellValue(ir, "dmdt_brnc_flg") == "0" ||sheetObj.CellValue(ir, "dmdt_brnc_flg") == "N") 
						&& ( sheetObj.CellValue(ir, "dmdt_rhq_flg") == "0" || sheetObj.CellValue(ir, "dmdt_rhq_flg") == "N" )
						&& ( sheetObj.CellValue(ir, "dmdt_ho_flg") == "0" || sheetObj.CellValue(ir, "dmdt_ho_flg") == "N" ) ){
						ComShowCodeMessage('DMT05014', "BBG or V.P or HO");
						sheetObj.SelectCell(ir, "dmdt_brnc_flg");
						return false;
					}
				}
        	break;
        }
        return true;
    }
 
    

    /* 개발자 작업  끝 */ 