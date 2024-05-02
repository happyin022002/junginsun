/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0001_005.js
*@FileTitle : S/C GOH Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.16 공백진
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class S/C GOH Guideline Creation : S/C GOH Guideline Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0001_05() {
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
    var enableFlag = true;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.04.16
     */
    function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

            var sheetObject1 = sheetObjects[0];
             /*******************************************************/
            var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");
         		if (srcName != null && srcName !="" && srcName.indexOf("btn") == 0 
							&& getButtonDisableStatus(srcName)){
					return;
				}    		
                switch(srcName) {
					case "btn_Retrieve":
						if (validateForm(sheetObject1,formObject,IBSEARCH)) {
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						}
						break;						

    				case "btn_Save":	
    					if(enableFlag && validateForm(sheetObject1,formObject,IBSAVE)) {
    						doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					}    						
						break;						
    				case "btn_Add":
    					if (enableFlag && validateForm(sheetObject1,formObject,IBINSERT)) {
    						doActionIBSheet(sheetObject1,formObject,IBINSERT);
    					}
						break;
    				case "btn_DownExcel":
    					
    					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
    						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    					}
    					break;    					

    				case "btn_Copy":
    					if (enableFlag && validateForm(sheetObject1,formObject,IBCOPYROW)) {
    						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);			
    					}
    					break;		
    				case "btn_Del":
    					
    					if (enableFlag && validateForm(sheetObject1,formObject,IBDELETE)) { 
    						doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
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
     * @author 공백진
     * @version 2009.04.17
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);            
        toggleButtons("CLEAR");         
        parent.loadTabPage();
    }
     
//     /**
//      * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
//      * <br><b>Example :</b>
//      * <pre>
//      *    
//      * </pre>
//      * @param {ibsheet} sheetObj 필수 IBSheet Object
//      * @return 없음
//      * @author 공백진
//      * @version 2009.04.17
//      */      
//     function sheet1_OnLoadFinish(sheetObj) {   
//
//         doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);            
//         toggleButtons("CLEAR");         
//         parent.loadTabPage();
// 
//     }         
     

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
     * @author 공백진
     * @version 2009.04.17
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|Sel.|Seq.|dbSeq.|Type|Point|Description|Bar Type|Per|Cur.|Rate|svcscpcd|glineseq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);



//             데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//							  	  COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//				 			  	  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//							  	  SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX]                                                
	                InitDataProperty(0, cnt++ , dtHiddenStatus,30, daCenter,   false, "ibflag"); 
	                InitDataProperty(0, cnt++,  dtDummyCheck,  40, daCenter,   false, "chk");
	                InitDataProperty(0, cnt++ , dtDataSeq,	   30,  daCenter,  false, "seq");
	                InitDataProperty(0, cnt++ , dtHidden,	   40,  daCenter,  false, "goh_chg_seq");
	                InitDataProperty(0, cnt++ , dtCombo,	   90,  daCenter,  false, "rout_pnt_loc_tp_cd",  true,  "",  dfNone, 	  0,  true,  true);
                    InitDataProperty(0, cnt++ , dtPopupEdit,   90,  daCenter,  false, "rout_pnt_loc_def_cd", true,  "",  dfNone, 	  0,  true,  true,	5);
                    InitDataProperty(0, cnt++ , dtData,       280,  daLeft,	   false, "loc_des",  		     false,  "",  dfNone,	  0,  false, false);
					InitDataProperty(0, cnt++ , dtCombo,       90,  daCenter,  false, "prc_hngr_bar_tp_cd",  true,  "",  dfNone, 	  0,  true,  true);
                    InitDataProperty(0, cnt++ , dtCombo,  	  100,  daCenter,  false, "rat_ut_cd",      	 true,  "",  dfNone, 	  0,  true,  true);
                    InitDataProperty(0, cnt++ , dtCombo,      100,  daCenter,  false, "curr_cd",             true,  "",  dfNone, 	  0,  true,  true);
                    InitDataProperty(0, cnt++ , dtData,       110,  daRight,   false, "frt_rt_amt",       	 true,  "",  dfNullFloat, 2,  true,  true, 9);
	                InitDataProperty(0, cnt++ , dtHidden,      40,  daCenter,  false, "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,      40,  daCenter,  false, "gline_seq");                        

	                //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력
                    
					ShowButtonImage = 2;
					WaitImageVisible = false;
               }
               break;
            }
        }
         
      
    /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  	
	function sheet1_OnChange(sheetObj, Row, Col, Value){
      	var colname = sheetObj.ColSaveName(Col);  
      	var formObj = document.form
      	switch(colname)
      	{
  	    	case "rout_pnt_loc_def_cd":
  	    		if (Value.length==2){
  	    			formObj.f_cmd.value = SEARCH07;
  	    			formObj.cd.value=sheetObj.Cellvalue(Row,Col);    	 				
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));	  			
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	  				
  					if (arrData[1] != ""){
  						sheetObj.CellValue2(Row,"loc_des") = arrData[1];
  						sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "C" ;
  					}else{
  						ComShowCodeMessage("PRI00315");
  						locationCellClear(sheetObj,Row);
  					}	  				
  	    		}else if(Value.length==5){
  	    			formObj.f_cmd.value = SEARCH05;
  	    			formObj.cd.value=sheetObj.Cellvalue(Row,Col);  	
	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));	  			
	  				var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
	  				if (arrData != null && arrData.length > 0) {
	  					sheetObj.CellValue2(Row, "loc_des") = arrData[0][1];
	  					sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = "L" ;
  					}else{  	
  						ComShowCodeMessage("PRI00315");
  						locationCellClear(sheetObj,Row);
					}	
  	    		}else{
  	    			ComShowCodeMessage("PRI00315");
  	    			locationCellClear(sheetObj,Row);
   			
  	    		}
  	    		break;
 	    	case "rout_pnt_loc_tp_cd": 	    	
 	    		locationCellClear(sheetObj,Row);
 	    		break;  
	    	case "frt_rt_amt":
            	if (sheetObj.CellValue(Row,Col) < 0){
            		sheetObj.CellValue2(Row, Col) = 0;
            	}		
	    		break;	 	    		
      	}
      }  
    
    /**
     * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		locationCellClear(sheetObj,Row)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  	    
  	function locationCellClear(sheetObj,Row){
  		sheetObj.CellValue2(Row,"loc_des")= ""; 		
  		sheetObj.CellValue2(Row,"rout_pnt_loc_def_cd")= "";  		
  		sheetObj.SelectCell(Row,"rout_pnt_loc_def_cd");
  	}    

    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 		
   	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			parent.setTabStyle();
		}
	}      
     
      
     	
   /**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * Location PopUp을 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  	      	 
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var locTpCd = sheetObj.CellValue(Row,"rout_pnt_loc_tp_cd");
      	switch(colName)
      	{
  	    	case "rout_pnt_loc_def_cd":
	  	  		var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&loc_tp_cd="+ locTpCd +"&location_cmd=LC&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  			var tpCd = "C";
	  			if (rtnVal != null){
	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
	  				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;	
	  				if (rtnVal.cd.length == 5){
	  					tpCd = "L";
	  				}
	  				sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = tpCd;
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
     * @author 공백진
     * @version 2009.04.17
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        try{
            switch(sAction) {
	    		case IBCLEAR: // 화면 로딩시 코드 조회
	    			//currency combo
	    			sheetObj.InitDataCombo(0,"curr_cd", currCdComboText, currCdComboValue,"USD");
	    			// per combo
	    			sheetObj.InitDataCombo(0,"rat_ut_cd", perCdComboText, perCdComboValue);
	    			//공통  bar type
	    			sheetObj.InitDataCombo(0,"prc_hngr_bar_tp_cd", barCdComboText, barCdComboValue);
					
					//공통 - type				
					sheetObj.InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE1[1], LOCATION_TYPE1[0], " ", " ", 0);
									 					
					break;
				case IBSEARCH:      //조회
 					ComOpenWait(true); //->waiting->start 				
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_PRI_0001_05GS.do", FormQueryString(formObj));
					ComOpenWait(false); //->waiting->End
	                break;
				case IBSAVE:        //저장
 					ComOpenWait(true); //->waiting->start 
					formObj.f_cmd.value = MULTI;	
					var sParam = FormQueryString(formObj);
					var sParamSheet = sheetObj.GetSaveString();	
					if (!sheetObj.IsDataModified && sParamSheet == "") {					
						ComShowCodeMessage("PRI00301");
						return false;
					}		
					if (sParamSheet == ""){
						return false;
					}					
		            if (!ComPriConfirmSave()) {
		                return false;
		            }					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_0001_05GS.do", sParam+"&"+sParamSheet);
					sheetObj.LoadSaveXml(sXml); 	
					ComOpenWait(false); //->waiting->End
	                break;
	                
				case IBINSERT:      // 입력
				    sheetObj.DataAutoTrim = false;
			        var Row = sheetObj.DataInsert();		        
					sheetObj.CellValue(Row, "svc_scp_cd") = formObj.svc_scp_cd.value;				
					sheetObj.CellValue(Row, "gline_seq") = formObj.gline_seq.value;	
					sheetObj.CellValue(Row,"goh_chg_seq") = parseInt(ComPriGetMax(sheetObj, "goh_chg_seq"))+ 1;
					sheetObj.CellValue(Row, "frt_rt_amt") = "0.00";
					sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
					//ComPriGetMax(sheetObj, sCol)  goh_chg_seq
					break;
				case IBDOWNEXCEL:      // 입력
					ComOpenWait(true); //->waiting->start
//					sheetObj.Down2Excel(-1);
					sheetObj.Down2Excel(-1, false, false,true,"","",false,false,"",false,"chk");
					ComOpenWait(false); //->waiting->End
					break;
				case IBCOPYROW: // Row Copy
					var Row = sheetObj.DataCopy();
				    sheetObj.CellValue(Row,"goh_chg_seq") = parseInt(ComPriGetMax(sheetObj, "goh_chg_seq"))+ 1;
					break;					
				case IBDELETE: // Delete
					//deleteRowCheck(sheetObj, "chk", "del_chk");
					deleteRowCheck(sheetObj, "chk" ,true);
					break;					
	            }        	
        } catch (e) {
       		if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         }finally{
	          	if ( sAction == IBCLEAR || sAction == IBDELETE || sAction == IBINSERT
	          			|| sAction == IBCOPYROW) {
	          		return;
	          	}
	          	ComOpenWait(false); //->waiting->End
         }

    }

  
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 공백진
     * @version 2009.04.17
     */
    function validateForm(sheetObj,formObj,sAction){
 		switch (sAction) {
		case IBSEARCH: // 조회		
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				ComShowCodeMessage('PRI08001');
				return false;
			} else {
				return true;
			}
			break;
	
		case IBSAVE: // 저장
			if (sheetObjects[0].IsDataModified ) {
		        if (parent.document.form.cfm_flg.value == "Yes"){
		    	    ComShowCodeMessage("PRI00105");
		    	    return false;
		        }				
				 var rowM = sheetObjects[0].ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rat_ut_cd|prc_hngr_bar_tp_cd");				 
				 if (rowM >= 0) {				 
					 ComShowCodeMessage("PRI00303", "G.O.H Sheet", rowM);
					 sheetObjects[0].SelectCell(rowM, "rout_pnt_loc_def_cd");
				     return false;
				 }
				 var mRow = getValidRowCount(sheetObj);
					for (i = 1; i <= mRow; i++){						
						if (sheetObj.CellValue(i, "frt_rt_amt") <= 0.00){							
							ComShowCodeMessage('PRI00321',"Rate","0.00");		
							sheetObj.SelectCell(i,"frt_rt_amt");
							return false;
						}
					}				 
				 
			}    		
			return true;
			break;
			
		case IBINSERT: // Row Add
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
	       if (!getMainStatus()){
	    	   return false;
	       }		
			break;
			
		case IBCOPYROW: // Row Copy
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
	       if (!getMainStatus()){
	    	   return false;
	       }		
			break;
			
		case IBDELETE: // Delete
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
	       if (!getMainStatus()){
	    	   return false;
	       }		
			break;
        case IBDOWNEXCEL: // 엑셀조회
	        if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	        	ComShowCodeMessage('PRI08001');
	        	return false;
	        }
        	if (sheetObj.IsDataModified == true){
        		ComShowCodeMessage('PRI00309','G.O.H');
        		return false;
        	}
	        break;				
		}        

        return true;
    }
     /**
      * parent 화면의 상태로 edit여부를 판단한다. function <br>
      * <br><b>Example :</b>
      * <pre>
      * getMainStatus())
      * </pre>
      * @param 없음
      * @return {Boolean} true(수정가능,메인의 상태는 No) false(수정불가능,메인의상태는 Yes)
      * @author 공백진
      * @version 2009.04.17
      */    
     function getMainStatus(){
     	var mainStatus = parent.document.form.cfm_flg.value;
     	var editStatus = true;
     	if (mainStatus == "Yes"){
     		editStatus = false;
     	}
     	return editStatus;
     }     

  /**
   * 화면의 상태에 따라 버튼을 활성,비활성화 한다. function <br>
   * <br><b>Example :</b>
   * <pre>
   *  toggleButtons(mode)
   * </pre>
   * @param {String} 화면의 상태 값 필수 
   * @author 공백진
   * @version 2009.04.17
   */  
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_DownExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Del");
			break;
		case "INIT":
			ComBtnEnable("btn_Retrieve");
			if (getMainStatus()){
				ComBtnEnable("btn_Save");
			}else{
				ComBtnDisable("btn_Save");
			}
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_Add");
			ComBtnEnable("btn_Copy");
			ComBtnEnable("btn_Del");
			break;
		case "READONLY":
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnDisable("btn_Add");
			ComBtnDisable("btn_Copy");
			ComBtnDisable("btn_Del");
			break;
		}
	}     
  	 
   /**
    * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
    * 화면이 보여지며 조회를 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sSvcScpCd 필수 svc_scp_cd 값
    * @param {string} sGlineSeq 필수 gline_seq 값
    * @param {string} isAproUsr 필수 권한 값
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject = document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;    			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
            if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag = true;
            } else {
            	enableFlag = false;
            }
            tabEnableSheet(enableFlag);							
		}
		
	
	}
    /**
    * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * tabClearSheet()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 	
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";    		
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
 
    /**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 		  
	function tabEnableSheet(flag) {
			var formObject = document.form;		
			sheetObjects[0].Editable = flag;
			enableFlag = flag;
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}			
	}   	 
      
	 
	/* 개발자 작업  끝 */