/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_0040.js
*@FileTitle : Real Customer Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.09.23 
* 1.0 Creation
=========================================================
* History
* 2011.11.10 서미진 [CHM-201114405] Location 정보 추가로 입력할 수 있도록 처리
* 2013.10.17 전윤주 [CHM-201327149] S/C의 Real Customer 상 영업사원 변경 시 변경 영업사원의 소속 Office 연동 변경 로직 추가.
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
     * @class ESM_PRI_0040 : ESM_PRI_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0040() {
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

	var sheetObjects = new Array();
	var sheetCnt = 0;   
	var formObject = document.form;
	var MULTI_SVC_SCP_CD = "TPW|ACW|TAE|ASE|MME|SAS";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;	
	
    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 서미진
     * @version 2011.09.23
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
    }    

    /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
    * @author 서미진
    * @version 2011.09.30
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
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
     * @author 서미진
     * @version 2011.09.23
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
     	case "sheet1":
     		with (sheetObj) {
                 // 높이 설정
                 style.height = 150;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 30, 50);

                 var HeadTitle = "|Sel.|Customer\nCode|Customer\nCode|Customer Name|Customer Type||Customer Class|Location|Office|Sales Rep.|Sales Rep.\nName|Main Real\nCustomer|||";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// dtHiddenStatus
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus, 	40, daCenter, false, "ibflag"); 
                 InitDataProperty(0, cnt++, dtCheckBox,   		40, daCenter, false, "chk");                
                 InitDataProperty(0, cnt++, dtData, 				30, daLeft, false, "cust_cnt_cd", true, "", dfNone, 0, true, true, 2);
                 InitDataProperty(0, cnt++, dtPopupEdit, 		60, daLeft, false, "cust_seq", true, "", dfNone, 0, true, true, 6);
                 InitDataProperty(0, cnt++, dtData, 				250, daLeft, false, "real_cust_nm", false, "", dfNone, 0, false, false);              
                 InitDataProperty(0, cnt++, dtCombo, 			100, daCenter, false, "prc_ctrt_cust_tp_cd", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtHidden, 			10, daLeft, false, "cust_val_sgm_cd", false, "", dfNone, 0, false, false);
                 InitDataProperty(0, cnt++, dtData,				100, daCenter, false, "real_cust_val_sgm", false, "", dfNone, 0, false, false);           
                 InitDataProperty(0, cnt++, dtPopupEdit, 		110, daCenter, false, "cust_loc_cd", false, "", dfEngUpKey, 0, true, true, 5, true);
                 InitDataProperty(0, cnt++, dtData, 				80, daCenter, false, "cust_sls_ofc_cd", false, "", dfNone, 0, false, false);              
                 InitDataProperty(0, cnt++, dtCombo, 			80, daCenter, false, "cust_srep_cd", true, "", dfNone, 0, true, true);             
                 InitDataProperty(0, cnt++, dtData, 				90, daLeft, false, "real_cust_srep_nm", false, "", dfNone, 0, false, false);                    
                 InitDataProperty(0, cnt++, dtRadioCheck,   	90, daCenter, false, "rep_cust_flg", false, "", dfNone, 0, true, true);    		      
                 
                 InitDataProperty(0, cnt++, dtHidden, 				30, daLeft, false, "amdt_seq", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtHidden, 				90, daLeft, false, "prop_no", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtHidden, 				30, daLeft, false, "real_cust_seq", false, "", dfNone, 0, true, true);        
                 
                 WaitImageVisible = false;   		
                 
                 InitDataValid(0,  "cust_cnt_cd",	vtEngUpOnly);		// 영문대문자만 입력
                 InitDataValid(0,  "cust_seq",	vtNumericOnly);			// 숫자만 입력
                 InitDataValid(0, 	 "cust_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
                 
                 InitDataCombo(0, "prc_ctrt_cust_tp_cd", custTpCdText, custTpCdValue);  //Customer Class combo
     		}
          	break;
          	
     	case "sheet2":
     		with (sheetObj) {
                 // 높이 설정
                 style.height = 150;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 30, 50);

                 var HeadTitle = "PROP_NO|AMDT_SEQ|CUST_CNT_CD|CUST_SEQ|CUST_LOC_CD";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// dtHiddenStatus
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtData, 				90, daLeft, false, "prop_no", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtData, 				90, daLeft, false, "amdt_seq", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtData, 				90, daLeft, false, "cust_cnt_cd", false, "", dfNone, 0, true, true);        
                 InitDataProperty(0, cnt++, dtData, 				90, daLeft, false, "cust_seq", false, "", dfNone, 0, true, true);               
                 InitDataProperty(0, cnt++, dtData, 				90, daLeft, false, "cust_loc_cd", false, "", dfNone, 0, true, true);               
                 WaitImageVisible = false;   		
     		}
     		break;
    	
     	}
	}
 
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @return 없음
     * @author 서미진
     * @version 2011.09.30
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];       
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				case "btn_save": 		//저장
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
				case "btn_retrieve": 		//조회
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btn_close": //Close 
					window.close();
					break;
					
				case "btn_rowadd": //row 추가 
	                doActionIBSheet(sheetObject1, formObject,	IBINSERT);
					break;
					
				case "btn_rowdelete": //row 삭제
					doActionIBSheet(sheetObject1, formObject,	IBDELETE);					
					break;								
					
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>			 
   * 
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 서미진
   * @version 2011.09.30
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {	
	 			case IBSEARCH: // 조회
		 			formObj.f_cmd.value = SEARCH;	
		 			var sXml = sheetObj.GetSearchXml("ESM_PRI_0040GS.do", FormQueryString(formObj));
		 			var arrText = ComPriXml2Array(sXml, "cust_srep_cd");
		 			sheetObj.LoadSearchXml(sXml);
		 			var row_count = sheetObj.RowCount("R"); 
		 			if(row_count != 0){
		 				for(var i = 1; i <row_count+1 ;i++){
		 					setRealCustSaleRep(i);

		 					sheetObj.CellValue(i,"cust_srep_cd") = arrText[i-1][0];      
		 					sheetObj.RowStatus(i) = "";      
		 				}
		 			}		
	 				break;	

	 			case SEARCH02: // 조회
		 			formObj.f_cmd.value = SEARCH02;			 			
		 			var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0040GS.do", FormQueryString(formObj));
		 			sheetObjects[1].LoadSearchXml(sXml);
	 				break;		

		 		case IBINSERT: // Row Add		 		
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}		 			 		
		 			sheetObj.DataInsert(-1);
		 			sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") = document.form.amdt_seq.value;
		 			sheetObj.CellValue(sheetObj.SelectRow, "prop_no") = document.form.prop_no.value;       
		 			sheetObj.CellValue(sheetObj.SelectRow, "prc_ctrt_cust_tp_cd") = "";       
	 		 		break;	
	 		 		
		 		case IBDELETE:      // Row 삭제	 				
        			var sRowStr = sheetObj.FindCheckedRow("chk");
                    var arrRow  = sRowStr.split("|");

                    //한건만 삭제
                    if(sRowStr == ""){
                    	var preStatus = sheetObj.RowStatus(sheetObj.SelectRow);

                    	sheetObj.RowStatus(sheetObj.SelectRow) = "D";      
                    	if(preStatus != "I"){
                    		sheetObj.RowHidden(sheetObj.SelectRow)= true;
                    	}
                		return false;
                    }                   
                    //다건 체크박스 삭제
                    if(arrRow.length > 0){
                    	for (var idx = arrRow.length-2; idx >= 0; idx--){
                    		sheetObj.RowStatus(arrRow[idx]) = "D";   
                    		sheetObj.RowHidden(arrRow[idx])= true;
                    	}
                    }
	 		 		break;		 		 		
		 			
		 		case IBSAVE: // 저장		 			
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}	
		 			
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);           
					if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
					    return;
					}
	     	 		var rtnObject = new Object(); 
	     	 		var sRow = sheetObj.FindCheckedRow("rep_cust_flg");
	     		    var arrRow = sRow.split("|");
	     		    var Row = arrRow[0]
	     		                     
		 			formObj.f_cmd.value = MULTI;				 			
			 		var sParam = sheetObj.GetSaveString(false, true);
			 		sParam += "&" + FormQueryString(formObj);    
		 			var sXml = sheetObj.GetSaveXml("ESM_PRI_0040GS.do", sParam);	
		 			
		 			var sav = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     	    if(sav != "F" ){                
		     		    rtnObject.custNm 	= sheetObj.CellValue(Row, "real_cust_nm");		
		     	 		rtnObject.custTpCd 	= sheetObj.CellValue(Row, "prc_ctrt_cust_tp_cd");	
		     	 		rtnObject.custCntCd = sheetObj.CellValue(Row, "cust_cnt_cd");
		     	 		rtnObject.custSeq 	= sheetObj.CellValue(Row, "cust_seq");
		     	 		rtnObject.custSrepCd 	= sheetObj.CellValue(Row, "cust_srep_cd");		
		     	 		window.returnValue = rtnObject;
		     	 	    self.close();                 		     		                     
		       	    }
	 		 		break;			 							    
	 		}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
			 ComOpenWait(false);
		}
	}		

	 /**
     * OnPopupClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
     * @return 없음
  	 * @author 서미진
  	 * @version 2011.09.30
     */
     function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var colname = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
      	switch(colname)
      	{
      		case "cust_seq":     	
      			var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N", "ESM_PRI_4014", 640, 465, true);
      			
	      			if (rtnVal != null){
	    			  sheetObj.CellValue2(Row, "cust_cnt_cd")  = rtnVal.custCntCd;
	    			  sheetObj.CellValue2(Row, "cust_seq")  = rtnVal.custSeq;
	    			  sheetObj.CellValue2(Row, "real_cust_nm")  = rtnVal.custNm; 
	    			  
	    			  realCustNameFind("cust_cnt_cd");
	    			  setRealCustSaleRep(Row);	
	      			}
  				break;
  				
  			
   	    	case "cust_loc_cd":
	    		var locationCmd = "L";
	    		var loc_cd = sheetObj.CellValue(Row, Col);
	  	  		var sUrl = "/hanjin/ESM_PRI_4026.do?location_cmd=" + locationCmd;
	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	  			
		  			if (rtnVal != null&&loc_cd!=rtnVal.cd){
		  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
		  			}
	    		break;	
      	}
     } 	
 
     /**
      * Real Customer에 관련된 정보를 조회한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *		realCustNameFind(eleName);
      * </pre>
      * @param  {string} eleName 필수 Html Object Name
      * @return 없음
      * @author 공백진
      * @version 2009.05.07
      */      
      function realCustNameFind(eleName){
          var formObj = document.form;
          var sheetObj = sheetObjects[0];
          var nowRow = sheetObj.SelectRow;
          var cust_cnt_cd = sheetObj.CellValue(nowRow, "cust_cnt_cd");
          var cust_seq = sheetObj.CellValue(nowRow, "cust_seq");
          
          if(cust_cnt_cd != ""  && cust_seq !=""){
              var sParam = "f_cmd="+SEARCH01+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;       
              var sXml = sheetObj.GetSearchXml("ESM_PRI_0040GS.do", sParam);
              var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm|loc_cd");
              
              if(arrText==undefined){
            	  sheetObj.CellValue(nowRow, "cust_cnt_cd") = "";
            	  sheetObj.CellValue(nowRow, "cust_seq") = "";
              }else{
                  sheetObj.CellValue(nowRow,"prc_ctrt_cust_tp_cd") = arrText[0][0];
                  sheetObj.CellValue(nowRow,"real_cust_nm") = arrText[0][1];
                  sheetObj.CellValue(nowRow,"cust_val_sgm_cd") = arrText[0][3];
                  sheetObj.CellValue(nowRow,"real_cust_val_sgm") = arrText[0][4];          
                  sheetObj.CellValue(nowRow,"cust_srep_cd") = arrText[0][5];
                  sheetObj.CellValue(nowRow,"cust_sls_ofc_cd") = arrText[0][6];
                  sheetObj.CellValue(nowRow,"real_cust_srep_nm") = arrText[0][7];
                  sheetObj.CellValue(nowRow,"cust_loc_cd") = arrText[0][8];
              }
          }
      }        

  /**
   * OnChange 이벤트 발생시 호출되는 function <br>
   * Amend Seq.가 0일 경우 Main Duration을 변경할 경우 Main의 Effective,Expire Date도 변경한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
   * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
   * @return 없음
   * @author 서미진
   * @version 2010.11.01
   */  
   function sheet1_OnChange(sheetObj, Row, Col) {
          var colName = sheetObj.ColSaveName(Col);
          var formObj = document.form;
            
          switch(colName)
          {                  	
              case "cust_srep_cd":           	  
            	  var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
					if(idx != -1){
		            	  var sText = sheetObj.GetComboInfo(Row, Col, "Text");
		
		            	  //각각 배열로 구성한다.
		            	  var arrText = sText.split("|");		
		            	  sheetObj.CellValue2(Row,"real_cust_srep_nm") = arrText[idx].split("	")[1] ;         
					} 
                  break;  
            	  
              case "cust_seq":
            	  if( sheetObj.CellValue(Row,"cust_seq") !=""  ){
					  var custSeq = sheetObj.CellValue(Row,"cust_seq");
					  var len = custSeq.length;
					  var str = "";
					  for(var i = 0 ; i < 6-len ; i++){
						  str += "0";
					  }
					  str = str + custSeq;
					  sheetObj.CellValue2(Row,"cust_seq") = str;
				   }
            	  
              case "cust_cnt_cd":
        		  realCustNameFind("cust_seq");	
        		  setRealCustSaleRep(Row);
        		  break;  
        		  
              case "cust_loc_cd":	  
      				formObj.f_cmd.value = SEARCH05;
      				formObj.cd.value = sheetObj.CellValue(Row,"cust_loc_cd");       				
      				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
      				var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
	    			if(arrDesc==null){	    			
	    				sheetObj.CellValue2(Row,"cust_loc_cd")="";
	    				sheetObj.SelectCell(Row,"cust_loc_cd",true);
	    				return;				
	    			}
            	  break;  	  
          }
   }   
   
   /**
    * sheet1 콤보선택 변경시 발생하는 sheet1_OnComboChange 이벤트핸들러
    * S.rep을 변경해도 office가 변경되지 않는 버그 해결을 위해 추가된 함수 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param  {IBSheet} sheetObj : 시트오브젝트
    * @param  {IBSheet} Row : 변경된 행 정보
    * @param  {IBSheet} Col : 변경된 컬럼정보
    * @param  {IBSheet} Code : 콤보코드값
    * @param  {IBSheet} Text : 콤보텍스트값
    * @return 없음
    * @see #
    * @author 전윤주
    * @version 2013.09.10
    */
   function sheet1_OnComboChange(sheetObj, Row, Col, Code, Text) {
       var form = document.form;       
       var colName = sheetObj.ColSaveName(Col);
       switch(colName) {
           case "cust_srep_cd":
        	   var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
				if(idx != -1){
	            	  var sText = sheetObj.GetComboInfo(Row, Col, "Text");
	
	            	  //각각 배열로 구성한다.
	            	  var arrText = sText.split("|");            	  
	            	  sheetObj.CellValue2(Row,"cust_sls_ofc_cd") = arrText[idx].split("	")[2] ;
				}
              
               break;         
       }
   }
 
   
     /**
      * 입력한 Real Customer Sale Office 에 따른 Sales Rep을 조회하여 <br>
      * IBMulti Combo에 Setting한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *		setRealCustSaleRep();
      * </pre>
      * @param  없음
      * @return 없음
      * @author 공백진
      * @version 2009.05.07
      */
       function setRealCustSaleRep(Row){
   		  var formObj = document.form;
   		  var sheetObj = sheetObjects[0];
   		  if (sheetObj.CellValue(Row,"cust_cnt_cd") != ""  && sheetObj.CellValue(Row,"cust_seq") !=""){
   		      formObj.f_cmd.value = SEARCHLIST;    		      
   		      var sParam = FormQueryString(formObj) +"&etc1="+sheetObj.CellValue(Row, "cust_sls_ofc_cd")
		      +"&etc2="+sheetObj.CellValue(Row, "cust_cnt_cd")+"&etc3="+ sheetObj.CellValue(Row, "cust_seq");
   		      var sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
   		      var arrXml = sXml.split("|$$|");
   	          var arrData = ComPriXml2ComboString(arrXml[0], "cd", "nm");
   	          var arrData2 =  ComPriXml2Array(sXml, "etc1"); //s.rep의 office 정보  	          

              if (arrData !=null && arrData.length > 0){
                  var arrCode = arrData[0].split("|");
                  var arrText = arrData[1].split("|");        
                  var aText = " \t \t |";
                  for (var i = 0;i < arrXml.length; i++){             
	                  if (arrCode != null && arrCode.length > 0){         
	                      for (var j = 0; j < arrCode.length; j++){
	                          aText += arrCode[j]+"\t"+arrText[j]+"\t"+arrData2[j]+"|";
	                      }
	                  }
	                  sheetObjects[0].CellComboItem(Row, "cust_srep_cd",aText," |"+arrData[0],0);
	              }
              }

          }else{  
              sheetObj.CellComboItem(Row,"cust_srep_cd", " ", " ");
        	  sheetObj.CellValue2(Row,"real_cust_nm" )= "";
        	  sheetObj.CellValue2(Row,"prc_ctrt_cust_tp_cd" )= "";
        	  sheetObj.CellValue2(Row,"cust_val_sgm_cd" )= "";
        	  sheetObj.CellValue2(Row,"real_cust_val_sgm" )= "";
        	  sheetObj.CellValue2(Row,"cust_sls_ofc_cd" )= "";
        	  sheetObj.CellValue2(Row,"cust_srep_cd" )= "";
        	  sheetObj.CellValue2(Row,"real_cust_srep_nm" )= "";
        	  sheetObj.CellValue2(Row,"rep_cust_flg" )= "";
        	  sheetObj.CellValue2(Row,"cust_loc_cd" )= "";       	  
          }   
       }         
  
       /**
        * Scope의 Request Office 에 따른 Sales Rep을 조회하여 sheet Combo에 Setting한다.<br>
        * <br><b>Example :</b>
        * <pre>
        *		setSheetRequestOfficeSaleRep(sheetObj, Row, offCd);
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int}     Row      필수 선택한 Row Index
        * @param {string}  offCd    필수 Scope의 Request Office code
        * @return 없음
        * @author 공백진
        * @version 2009.05.07
        */           
       function setSheetRequestOfficeSaleRep(sheetObj, Row, offCd){
           var formObj = document.form;        
           formObj.f_cmd.value = SEARCH15;        
           var sParam = FormQueryString(formObj) +"&etc1="+ offCd;        
           var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",sParam);    
           var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
           if (arrData !=null && arrData.length > 0){
               var arrCode = arrData[0].split("|");
               var arrText = arrData[1].split("|");        
               var aText = "";
               if (arrCode != null && arrCode.length > 0){         
                   for (var i = 0; i < arrCode.length; i++){
                       aText += arrCode[i]+"\t"+arrText[i]+"|";
                   }
               }
               sheetObj.CellComboItem(Row,"prop_scp_srep_cd",aText,arrData[0],0);
           }else{
           	sheetObj.CellComboItem(Row,"prop_scp_srep_cd", " ", " ");
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
     * @author 서미진
     * @version 2011.09.30
     */
 	function validateForm(sheetObj, formObj, sAction) {
    	 
    	 switch (sAction) {
	 
    	 	 case IBINSERT : 
    	 		 var arrSvcScpCd =svcScpCd.split("|");
    	 		 var cnt = sheetObj.RowCount("R|U|I");
    	 		 var availableFlg = false;
    	 		 if( cnt > 0 ){
    	 			for(var i = 0 ; i < arrSvcScpCd.length ; i++){
    	 				if( MULTI_SVC_SCP_CD.indexOf(arrSvcScpCd[i]) >= 0 ){
    	 					availableFlg = true;
    	 					break;
    	 				}
    	 			}
    	 		 }else{
    	 			availableFlg = true;
    	 		 }
    	 		 
    	 		 if(availableFlg == false){
	                 ComShowCodeMessage('PRI01141');
	                 return false;
    	 		 }
    	 		 return true;
    	 		 
    	 		 break;
	    	 case IBSAVE: // 저장
	    	 		var cnt = sheetObjects[0].RowCount("R|I|U");
	    	 		var loc_count = sheetObjects[1].RowCount("R");
	    	 		var sheet1_cnt = sheetObjects[0].RowCount("");
	    	 
		    		if( cnt != 0 ){
		    		 	var checked = sheetObjects[0].CheckedRows("rep_cust_flg");	
		     	 		var sRow = sheetObjects[0].FindCheckedRow("rep_cust_flg");
		     		    var arrRow = sRow.split("|");
		     		    var Row = arrRow[0]
		            	if(checked == 0 || sheetObjects[0].CellValue(Row, "ibflag") =="D" ){ 
			                 ComShowCodeMessage('PRI01140');  // You should select one Main customer
			                 return false;
		            	 }
	
		             //저장할 데이터가 있는지 확인
		            	if(!sheetObjects[0].IsDataModified){	            		 
			                 ComShowCodeMessage('PRI00301'); 
			                 return false;
		            	 }	 
		            	
			             //중복 데이터 체크
				        //sheetObj.SpaceDupCheck = false;           
			            var dupRow = sheetObj.ColValueDup("cust_cnt_cd|cust_seq", false);
		          
			            if (dupRow>0) {
			            	sheetObj.SelectRow = dupRow;
			                ComShowCodeMessage("PRI00342","Customer Code");
			                ComSetFocus(sheetObj.ColValueDupRows("cust_cnt_cd"));	
			                return false;
			            }
			            
			            //affiliate와 L/Agent Location code와 Real Customer의 Location code가 일치하는지 비교		            
			            if(loc_count > 0){
			            	for (var i = 1 ; i < loc_count+1 ; i++){  		
			            		for (var j = 1 ; j < sheet1_cnt+1 ; j++){ 
			            			if(sheetObjects[0].CellValue(j, "ibflag") != "D"){		            				
				            			if(sheetObjects[1].CellValue(i, "cust_cnt_cd") == sheetObjects[0].CellValue(j, "cust_cnt_cd") &&
				            			   sheetObjects[1].CellValue(i, "cust_seq") == sheetObjects[0].CellValue(j, "cust_seq")	){      			            				
				            				if(sheetObjects[1].CellValue(i, "cust_loc_cd") != sheetObjects[0].CellValue(j, "cust_loc_cd")){
				    			                ComShowCodeMessage("PRI01142");
				    			                sheetObjects[0].SelectCell(j,"cust_loc_cd",true);
				    			                return false;
				            				}
				            			}
			            			}
			            		}
			            	}
			            }
		    		}
				    break;	    	    	 
    	 }
 		return true;  
 	}
	/* 개발자 작업  끝 */