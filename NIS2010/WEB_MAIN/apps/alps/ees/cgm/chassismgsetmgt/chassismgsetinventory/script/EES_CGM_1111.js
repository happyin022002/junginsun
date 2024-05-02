/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1111.js
*@FileTitle : Utilization Factor by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.11 조재성
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/


    /**
     * @extends 
     * @class EES_CGM_1111 : EES_CGM_1111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1111() {
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

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.11
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

				case "btn_retrieve":
			      	 	//검색전 Sheet Object 초기화
			      	 	sheetObject1.RemoveAll();
			      	 	sheetObject2.RemoveAll();
	    				ComBtnDisable("btn_save");
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);

            			formObject.loc_cd.focus(); //조회후 focus는 location으로 가게 만든다.             			
            			break;
				case "btn_new":
					document.form.loc_cd.value  = "";
					initControl();
					
				break;
					
				case "btn_save":
					if(ComIsBtnEnable("btn_save")){	
						doActionIBSheet(sheetObject1, formObject, IBSAVE);	
					}
					break;
				
                case "btns_crnt_loc_cd":	// Location Popup
	                var tmp = "SCC";
	            	if(tmp == "RCC"){
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);
	            	} else if(tmp == "LCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
	            	} else if(tmp == "SCC") {
	            		//ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
	            		ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 460, "callBackLocation", "1,0,1,1,1,1,1", true, false);
	            		//ComOpenPopup('/hanjin/COM_ENS_051.do', 1000, 450, "callBackLocation", "0,1,1,1,1,1,1", true, false);	            		
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
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheet_obj	필수
     * @return 없음
     * @author 조재성
     * @version 2009.08.11
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.11
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
    }

    /**
     * Sheet 로딩 후 기본 설정 및 초기화 <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.10.20
     */     
    function sheet1_OnLoadFinish(sheetObj) {
        var formObject = document.form;    	
        sheetObj.WaitImageVisible = false;

      	// axon event 등록
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change' , 'loc_cd');  
      	axon_event.addListener('click', 'cntr_dry_rf_ind_cd_click','cntr_dry_rf_ind_cd');
        axon_event.addListener('keyup', 'enterFire', 'loc_cd');
      	axon_event.addListenerForm('keyup', 'obj_keyup', form);
      	
        
        initControl();
        
        sheetObj.WaitImageVisible = true; 
    }
    
     /**
      * Sheet1 의 Double Click 할 경우 상세정보 화면표시 <br>
      * @author 조재성 / update select sheet 1
      * @version 2009.08.13
      */   
     function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	  	var sheetObj2 = sheetObjects[1];
	  	var formObject = document.form;
	  	
		for(i=1; i<sheetObj2.rowCount+1; i++){
			if(sheetObj2.RowStatus(i) != "R")
			{
				//수정된사항이 있으므로 저장할지 물어본다. 
				if ( ComShowCodeConfirm("CGM10047") ){ 
					doActionIBSheet(sheetObj, formObject, IBSAVE);
					doActionIBSheet(sheetObj2, formObject, IBSEARCH);
					sheetObj.SelectCell(Row, Col);
					return;
                }else{
                    	break;
                }
 			}
 		}
 		doActionIBSheet(sheetObj2, formObject, IBSEARCH);
 		sheetObj.SelectCell(Row, Col);
     }
     
      /**
       * Sheet1 의 cell을 edit 할 경우 <br>
       * @author 조재성
       * @version 2009.08.12
       */   
      function sheet1_OnChange(sheetObj, Row, Col)
      {
 	  	var formObj = document.form;
 	  	var tmpTotal = 0;
 	  	
 	  	if(Col == 3)
 	  	{
 	  		//alert("test>>>>"+ Row + ":"+ Col + ": "+ sheetObj.RowCount);
 	  		for(var i=1; i<= sheetObj.RowCount; i++)
 	  		{
 	  			tmpTotal+=parseInt(sheetObj.CellValue(i,Col));
 	  		}
 	  		formObj.total_unit.value = tmpTotal; 
 	  		sheetObj.RowStatus(Row)="U";
 	  	}
      }  

      /**
      * Sheet2 의 cell을 edit 할 경우 <br>
      * @author 조재성
      * @version 2009.08.12
      */   
     function sheet2_OnChange(sheetObj, Row, Col)
     {
	  	var formObject = document.form;
	  	
	  	//alert("test>>>>"+ Row + ":"+ Col + ": "+ sheetObj.RowCount);
	  	if(Col == 3 || Col == 4)
	  	{
	  		sheetObj.RowStatus(Row)="U";
	  		
	  		if(Col == 4)
	  		{
	  			// 100보다 큰수를 입력하면 100으로 설정해준다. 
	  			if(parseInt(sheetObj.CellValue(Row,Col))>100)
	  			{
	  				sheetObj.CellValue2(Row,Col) = "100";
	  			}
	  		}
	  	}
     }        
 
      
      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  없음
       * @return 없음
       * @author 조재성
       * @version 2009.08.11
       */
     function initControl(){
      	 var formObj = document.form;
      	 var sheetObj = sheetObjects[0];
      	 var sheetObj2 = sheetObjects[1];
      	 
      	 
      	 // Form Object 초기화
      	 with(formObj){
      		 //loc_cd.value ="";
      		 yd_cd.value = "";
      		 total_unit.value = "";
         }
      	 
      	 // Sheet Object 초기화
      	 sheetObj.RemoveAll();
         sheetObj2.RemoveAll();
         
		 ComBtnDisable("btn_save");
    	 
		 formObj.loc_cd.focus(); //초기화시  focus는 location으로 가게 만든다.
     }

 /**
  * 시트 초기설정값, 헤더 정의 <br>
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
  * @param  {object} sheetObj	필수	 Sheet Object
  * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
  * @return 없음
  * @author 조재성
  * @version 2009.08.11
 */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
				var sheetID = sheetObj.id;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 422;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);
                    
                    var HeadTitle1 = "||Yard|Unit(s)";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix = "sheet1_";
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	prefix + "ibflag");
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	prefix + "Status");
                    InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,	prefix + "yd_cd",			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	prefix + "eg5_pre_knt_qty",	false,	"",		dfInteger,	0,	true,	true);
                    CountPosition = 0;
                    EditableColorDiff = false;
			}
		break;

        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 422;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);
                
                var HeadTitle1 = "||Container Status|Container Status|Ratio (%)";
                
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                var prefix = "sheet2_";
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix+ "ibflag");
                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		prefix+ "Status");
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+ "cnmv_sts_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0, cnt++ , dtCombo,		200,	daCenter,	false,		prefix+ "cntr_psn_sts_cd",	false);
			
				InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,		prefix+ "chss_usg_rto",		false,	"",	dfNone,		0,	true,	true);
				
				CountPosition = 0;
				EditableColorDiff = false;
				
				//popup 초기화
				//InitDataCombo(0, prefix+"cntr_psn_sts_cd", "Wheeled Containers|Grounded Containers| ", "Wheeled Containers|Grounded Containers|");
				InitDataValid(0, prefix+"chss_usg_rto", vtNumericOnly);
				
				
				popupCall();					

            }
            break;

        }
    }

   
   /**
    * 시트2 초기설정값, 헤더 정의 <br>
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
    * @param  {object} sheetObj	필수	 Sheet Object
    * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
    * @return 없음
    * @author 조재성
    * @version 2009.08.12
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

					case IBSEARCH:      //조회
						if(validateForm(sheetObj,formObj,sAction))
						{
							if(sheetObj.id == "sheet1")
							{
					 	        // Form Object 값 설정
						    	formObj.f_cmd.value = SEARCH;
					 			var sXml = sheetObj.GetSearchXml("EES_CGM_1111GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
					 			sheetObj.LoadSearchXml(sXml);
					 			
					 			for(i=1; i<sheetObj.rowCount+1; i++){
					 				sheetObj.RowStatus(i) = "R";
					 			}
					 			
							}else if(sheetObj.id == "sheet2")
							{
								var sheetObj1 = sheetObjects[0];
								var sheetObj2 = sheetObjects[1];
			                    var prefix = "sheet1_";								
					 	        // Form Object 값 설정
						    	formObj.f_cmd.value = SEARCH01;
						    	if(parseInt(sheetObj1.SelectRow) >0)
						    	{
						    		formObj.yd_cd.value = sheetObj1.cellValue(parseInt(sheetObj1.SelectRow) , prefix+ "yd_cd");
						    		var sXml = sheetObj.GetSearchXml("EES_CGM_1111GS.do" , FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
						    		sheetObj.LoadSearchXml(sXml);
						    		
						 			for(i=1; i<sheetObj2.rowCount+1; i++){
						 				sheetObj2.RowStatus(i) = "R";
						 			}
						 			
						    		if(sheetObj2.RowCount > 0){
						    		    ComBtnEnable("btn_save");
						    		}
						    	}
						    	
							}
					 			
						}
					break;
					
					case IBSAVE:        //저장
						if(validateForm(sheetObj,formObj,sAction))
						{
							formObj.f_cmd.value = MULTI;
							var sParam = "";
							var sParam1 = sheetObjects[0].GetSaveString(true); 
							var sParam2 = sheetObjects[1].GetSaveString(true); 

							sParam = sParam1 +  "&" + sParam2 +  "&"  + FormQueryString(formObj);
							
							var sXml = sheetObj.GetSaveXml("EES_CGM_1111GS.do", sParam);
							
							sheetObj.LoadSaveXml(sXml);
						   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
						   	if(sCheckResult == COM_VALIDATION_FALSE){
						   		//alert("FAIL");
						   	}else
						   	{
						   		//alert("SUCCESS"); 저장에 성공했으므로, 상태를 읽기상태로 모두 바꾸어 준다. 
						   		for(var i = 1; i <= sheetObjects[1].RowCount; i++)
						   		{
						   			sheetObjects[1].RowStatus(i)="R";
						   		}
						   		ComShowCodeMessage("CGM00003"); 
						   	}
						   	
						}
					break;
					
					case IBINSERT:      // 입력
					break;

        	case IBSEARCH_ASYNC08:
    	       	//formObj.f_cmd.value = SEARCH;
    	   		//var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
    	   			    			
		   		formObj.f_cmd.value = SEARCH17;
		    	var location = "SCC";
		    	if(location == "RCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "RCC";
		    		formObj.eq_orz_cht_rcc_cd.value = formObj.loc_cd.value;
		    	}else if(location == "LCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "LCC";
		    		formObj.eq_orz_cht_lcc_cd.value = formObj.loc_cd.value;
		    	}else if(location == "SCC")
		    	{
		    		formObj.eq_orz_cht_chktype.value = "SCC";
		    		formObj.eq_orz_cht_scc_cd.value = formObj.loc_cd.value;
		    	}else
		    	{
		    		formObj.eq_orz_cht_chktype.value = "";
		    		formObj.eq_orz_cht_scc_cd.value = "";
		    	}
	     		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
	     		
    	   		// 데이터 건수
    	        var dataCount = ComGetTotalRows(sXml);
    	        if(dataCount==0){
    	        	ComShowCodeMessage('CGM10009','location cd');
    		   		formObj.loc_cd.value = "";
    	        }
      	        formObj.loc_cd.focus(); //validation후 focus는 location으로 가게 만든다.    	        
    	   		break;
        }
    }

    /**
    * sheet2 cntr_psn_sts_cd 콤보박스 초기화 <br>
    * @param  없음
    * @return 없음
    * @author 조재성
    * @version 2009.08.12
    */
	 function popupCall(){
	 	var formObj = document.form;
	 	var sheetObj  = sheetObjects[1];
	 	var prefix = "sheet2_";
	 	sheetObj.InitDataCombo(0, prefix+"cntr_psn_sts_cd", "Wheeled Containers|Grounded Containers|","W|G|");
	 }    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type 
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 조재성
     * @version 2009.08.11
     */ 
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction){
    			case IBSEARCH:
    				if(loc_cd.value == ''){
    					ComShowCodeMessage('CGM10004','Location');
    					loc_cd.focus();
    					return false;
    				} else {
    					if(loc_cd.value.length != 5) // Location 자리수 고정 size=5
    					{
    						ComShowCodeMessage('CGM10044','SCC(5)');
    						loc_cd.focus();
    						return false;
    					}
    				}

    				break;
                }
    	}
        return true;
    }

    /**
     * 콜백 함수. <br>
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 조재성
     * @version 2009.08.12
     */   
    function callBackLocation(aryPopupData, row, col, sheetIdx){
         	 
        var formObj = document.form;
        var location = "SCC";
        var crntLocCd = "";
        var i = 0;
        
        for(i = 0; i < aryPopupData.length; i++){
        	if(location == 'RCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][11];
        	} else if(location == 'LCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][10];
        	} else if(location == 'SCC'){
        		crntLocCd = crntLocCd + aryPopupData[i][8];
        	}
         		
        	if(i < aryPopupData.length - 1){
        		crntLocCd = crntLocCd + ",";
         	}
        }
         	 
        formObj.loc_cd.value = crntLocCd;
         	 
    }	

    /**
     * Sheet1 의 OnSearchEnd 이벤트처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {string} ErrMsg		필수 String
     * @return 없음
     * @author 조재성
     * @version 2009.07.16
     */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	var prefix = "sheet1_";
    	with(sheetObj)
    	{
            var totVal = 0;
     		for(var i = 1; i <= RowCount; i++){
     			totVal += parseInt(cellValue(i, prefix+"eg5_pre_knt_qty"));
     		}	
     		document.form.total_unit.value = totVal;
    	}
    }

     /** 
      * Object 의 Keypress 이벤트에 대한 처리  <br>
      * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.07.17
      */ 
     function obj_keypress(){
       	obj = event.srcElement;
       	if(obj.dataformat == null) return;
       	 	
       	window.defaultStatus = obj.dataformat;
       	 
       	switch(obj.dataformat) {
       	 	case "ym": case "ymd":
       	 		ComKeyOnlyNumber(obj);
       	 		break;
       	 	case "int":
       	 		if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj,",");
       	 		else ComKeyOnlyNumber(obj);
       	        break;
       	 	case "float":
  	            ComKeyOnlyNumber(obj, "-.");
  	            break;    
       	    case "eng":
      	    	if(obj.name=="vndr_seq") 
      	    		ComKeyOnlyNumber(obj,",");
      	    	else 
      	    		ComKeyOnlyAlphabet();
       	        break;
       	    case "engup":
      	        if(obj.name=="loc_cd") ComKeyOnlyAlphabet('upper');//ComKeyOnlyAlphabet('uppernum');
      	        else if(obj.name=="crnt_yd_cd") ComKeyOnlyAlphabet('uppernum',"44");
       	        else ComKeyOnlyAlphabet('upper');
       	        break;
       	    case "engdn":
       	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
       	        else ComKeyOnlyAlphabet('lower');
       	        break;
       	}
     } 
     
     /** 
      * Object 의 change 이벤트에 대한 처리  <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.12
      */  
     function obj_change(){
     	 var formObj = document.form;
     	 var sheetObj = sheetObjects[0]; 
     	 obj = event.srcElement;
     	 switch(obj.name){

    	 	case "loc_cd":
    	 		break;
     	 }   
     }
      
  /** 
   * cntr_dry_rf_ind_cd 의 click 이벤트에 대한 처리  <br>
   * @param  없음
   * @return 없음
   * @author 조재성
   * @version 2009.08.12
   */  
   function   cntr_dry_rf_ind_cd_click(){
	   initControl();
   }
      
   /** 
     * Object 의 obj_focusout 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 조재성
     * @version 2009.08.12
     */  
    function obj_focusout(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;

    }

     /** 
      * 기본조건 입력 후 ENTER키 적용 <br>
      * @param  없음
      * @return 없음
      * @author 조재성
      * @version 2009.08.14
      */ 
   function enterFire() {
	   var formObj = document.form;
	   var sheetObj = sheetObjects[0];
	   if(event.keyCode == 13)
	   {
		   if(validateForm(sheetObj,formObj,IBSEARCH))
		   {
			   ComKeyEnter('search');
		   }
	   }
   }        

/**
 * 유효값체크 로직(자리수에 맞춰서)
 * @author 조재성 2009.09.30
 */
function obj_keyup(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0];
    	 obj = event.srcElement;
    	 switch(obj.name){
	 	 	case "loc_cd":
		 		var crntLocCd = ComTrimAll(formObj.loc_cd.value);
		   		var arrCrntLocCd = crntLocCd.split(",");
		   		
		   		for(var i = 0; i < arrCrntLocCd.length; i++){
		   		// 입력오류 체크 (예> ,,)
		 			if(arrCrntLocCd[i] == ''){
		 				ComShowCodeMessage('CGM10009','Location');
		 				formObj.loc_cd.value = "";
		 				ComSetFocus(formObj.loc_cd);
		 				break;
		 			}else
		 			{
		    	 		//if(formObj.loc_cd.value != ''){
		    	 		if(formObj.loc_cd.value.length == 5){
		    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
		    	 		}
		 			}
		   		}
		 		break; 
    	 }
}   
	/* 개발자 작업  끝 */