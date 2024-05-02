/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0078.js
*@FileTitle : Contract Parties Information Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.05 공백진
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
     * @class ESM_PRI_0078 : ESM_PRI_0078 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0078() {
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
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
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
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Close":
					window.close();
					break;
				case "prc_ctrt_pty_tp_cd":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
         
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);
		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      
//      /**
//       * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event<br>
//       * <br><b>Example :</b>
//       * <pre>
//       *    
//       * </pre>
//       * @param {ibsheet} sheetObj 필수 IBSheet Object
//       * @return 없음
//       * @author 공백진
//       * @version 2009.04.17
//       */      
//      function sheet1_OnLoadFinish(sheetObj) {
//          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC10);
// 		  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//      }          
//      


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
         var amdt_seq = document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 170;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 4, 100);
                     var HeadTitle = "|sel|prop_no|amdt_seq|prc_ctrt_pty_tp_cd|cust_cnt_cd|cust_seq|ctrt_cust_val_sgm_cd|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|"
                    	 HeadTitle += "Contract Party|Address|Signature|Title|EFF Date|EXP Date|Source|Source|Status|Status|Accept Staff/Team|Accept Date|acpt_usr_id|acpt_ofc_cd|n1st_cmnc_amdt_seq";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,	false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);


//                   데이터속성           	 [ROW,		  COL,		  DATATYPE,   WIDTH,	  DATAALIGN,              
//			  			  			 COLMERGE,	  SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, 
//		  				  			 POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, 	  FULLINPUT, 
//			  			  			 SORTENABLE, TOOLTIP, 	  ALLCHECK,   SAVESTATUS, FORMATFIX] 
 				     InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 					 InitDataProperty(0, cnt++, dtDummyCheck,   45,  daCenter, false, "chk");
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "prop_no",  	        false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "amdt_seq", 	        false, "", dfNone,    0, false, false);  
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "prc_ctrt_pty_tp_cd",  false, "", dfNone,    0, false, false);					 
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "cust_cnt_cd", 		false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "cust_seq", 			false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "ctrt_cust_val_sgm_cd",false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "ctrt_cust_srep_cd", 	false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtHidden,  70,  daCenter, false, "ctrt_cust_sls_ofc_cd",false, "", dfNone,    0, false, false);
					 InitDataProperty(0, cnt++, dtData,    110,	daCenter, false, "ctrt_pty_nm",		    false, "", dfNone,	  0, false, false);
					 InitDataProperty(0, cnt++, dtData,    180, daLeft,	  false, "ctrt_pty_addr",	    false, "", dfNone,	  0, false, false);
					 InitDataProperty(0, cnt++, dtData,    90,  daLeft,	  false, "ctrt_pty_sgn_nm",	    false, "", dfNone,	  0, false, false);
					 InitDataProperty(0, cnt++, dtData,    90,  daLeft,	  false, "ctrt_pty_sgn_tit_nm", false, "", dfNone,	  0, false, false);									     
					 InitDataProperty(0, cnt++, dtData,    70,  daCenter, false, "eff_dt",        		false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtData,    70,  daCenter, false, "exp_dt",   		    false, "", dfDateYmd, 0, false, false);
				     InitDataProperty(0, cnt++, dtCombo,   85,  daCenter, false, "src_info_cd", 	    false, "", dfNone, 	  0, false, false);	
				     InitDataProperty(0, cnt++, dtHidden,  90,  daCenter, false, "src_info_dtl",        false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtCombo,   60,  daCenter, false, "prc_prog_sts_cd",     false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  90,  daCenter, false, "prc_prog_sts_dtl",    false, "", dfNone, 	  0, false, false);	
				     InitDataProperty(0, cnt++, dtData,    120, daLeft  , false, "acpt_usr_nm",    	 	false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtData,    75,  daCenter, false, "acpt_dt", 		    false, "", dfDateYmd, 0, false, false);				     
				     InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, false, "acpt_usr_id", 	    false, "", dfNone, 	  0, false, false);
				     InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, false, "acpt_ofc_cd", 	    false, "", dfNone, 	  0, false, false);				     
				     InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "n1st_cmnc_amdt_seq",  false, "", dfNone, 	  0, false, false);
 					 WordWrap = true; 		
 					 ColHidden("chk") = true;
 					 WaitImageVisible = false;
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
	   	 		case IBSEARCH_ASYNC10:
	  				document.form.prc_ctrt_pty_tp_cd[0].checked = true;
	  		        //srcInfocd		        
	  	 			sheetObj.InitDataCombo(0,"src_info_cd", srcInfoCdText, srcInfoCdValue);
	  		        //status
	  	 			sheetObj.InitDataCombo(0,"prc_prog_sts_cd", stsCdText, stsCdValue);
	
	   				break;
	   	 		case IBSEARCH_ASYNC20: // option  처리
	  				formObj.f_cmd.value = SEARCH11;
	   	 			var eleName = "";
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_0078GS.do" , FormQueryString(formObj));
	  				var arrData = ComPriXml2Array(sXml, "cd|etc1");
	  				for (var i = 0; i < arrData.length; i++) {
	  					if (arrData[i][0] == "H" ){
	  						eleName = "tp2";
	  					}else{
	  						eleName = "tp1";
	  					}	
	  					document.getElementById(eleName).style.fontWeight = "bold";
	  					switch (arrData[i][1]){
	  						case "0":
	  			 				document.getElementById(eleName).style.fontWeight = "";
	  			 				document.getElementById(eleName).style.color = "black";
	  							break;
	  						case "1":
	  			 				document.getElementById(eleName).style.color = "black";
	  							break;
	  					}
	
	  				}
	   	 		
	  				break;	
	   	 		case IBSEARCH:      //조회			
	   	 			ComOpenWait(true); //->waiting->start
	   				formObj.f_cmd.value = SEARCH;
	   				sheetObj.DoSearch("ESM_PRI_0078GS.do", FormQueryString(formObj));
	   				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC20);
	   				ComOpenWait(false); //->waiting->End
	   				break;
	   	
	            }//end switch        	  
          } catch (e) {
             	if (e == "[object Error]") {
                     ComShowMessage(OBJECT_ERROR);
                 } else {
                     ComShowMessage(e);
                 }
            }finally{
  	          if (sAction == IBSEARCH_ASYNC01 || sAction == IBSEARCH_ASYNC20) {
  	        	  return;
  	          }
  	          ComOpenWait(false); //->waiting->End
          }

       
      }

      /**
       * OnClick 이벤트 발생시 호출되는 function <br>
       * User Info PopUp을 호출한다. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
       * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
       * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
       * @return 없음
       * @author 공백진
       * @version 2009.06.03
       */  	           
       function sheet1_OnClick(sheetObj, Row, Col, Value) {

  	    var colname = sheetObj.ColSaveName(Col);
       	switch(colname)
       	{
   	    	case "acpt_usr_nm":
//   	    		ComUserPopup(sheetObj.CellValue(Row,"acpt_usr_id"));
   	    		break;
       	}    	 

      } 	
      
      

	/* 개발자 작업  끝 */