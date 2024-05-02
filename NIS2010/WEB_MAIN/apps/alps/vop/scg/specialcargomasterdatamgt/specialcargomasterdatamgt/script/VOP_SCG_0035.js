/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0035.js
*@FileTitle : Target Lane for SPCL CGO APVL (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.25 장강철 jkc
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
     * @class vop_scg_0035 : vop_scg_0035 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0035() {
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
 var gRow = 0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 							case "btn_retrieve":
 								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 							break;
 							
 							case "btn_add":						
 								sheetObject.DataInsert(-1);
 								sheetObject.SelectCell( sheetObject.LastRow ,"sheet1_vsl_slan_cd");
 							break;
 							
 							case "btn_insert":
 								sheetObject.DataInsert();
 								sheetObject.SelectCell( sheetObject.SelectRow ,"sheet1_vsl_slan_cd"); 								
 							break; 
 							
 							case "btn_delete":
 								doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
 							break;	

 							case "btn_copy":
 								doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
 							break;	
 							
 							case "btn_save":
 								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
 		// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
      }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 460;
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

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(6, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "|Sel.|No.|Target Lane|Full Name|Service Type";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     var prefix="sheet1_";
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,	daCenter,    false,	  prefix+"ibflag"        );    
                     InitDataProperty(0, cnt++ , dtCheckBox,	 30,	daCenter,	  true,	  prefix+"del_chk"       ,      false,	   "",      dfNone,				0,	    true,	 true);
                     InitDataProperty(0, cnt++ , dtDataSeq,   	 30, 	daCenter);
                     InitDataProperty(0, cnt++ , dtPopupEdit ,  150,    daCenter,     false,  prefix+"vsl_slan_cd"   ,      true ,     "",     dfEngUpKey,         0,      false,   true, 3, true);
                     InitDataProperty(0, cnt++ , dtData,        300,    daLeft,       true,   prefix+"vsl_slan_nm"   ,      false,     "",      dfNone,             0,      false,    false);
                     InitDataProperty(0, cnt++ , dtData,        430,    daLeft  ,	  true,   prefix+"svc_type_name" ,      false,     "",      dfNone,             0,      false,    false);
                     InitDataValid(0, "sheet1_vsl_slan_cd", vtEngUpOther, '1234567890');
                     ShowButtonImage = 1;
                     BasicImeMode    = 2;           
                   	 
                }
                 break;
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, cRow, slan_cd) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
 					case IBSEARCH:      //조회
							formObj.f_cmd.value = SEARCH;
							var aryPrefix = new Array("sheet1_");
                            var param =  FormQueryString(formObj) +"&spcl_cgo_rqst_tgt_lane_flg=Y" +"&" + ComGetPrefixParam( aryPrefix );
 
							var sXml = sheetObj.GetSearchXml("VOP_SCG_0035GS.do", param);
							sheetObj.Redraw = false;    							
							sheetObj.LoadSearchXml( sXml ); 
							sheetObj.Redraw = true;    							
 					break;
 
 					
					case IBDELETE:      // 삭제
   
						if (sheetObj.id == 'sheet1') {   
							 ComRowHideDelete(sheetObj, "sheet1_del_chk");
				   	   	}
					break;
					
					case IBSAVE:        //저장
						if(!validateForm(sheetObj,formObj,sAction)){
							return;
						}
						formObj.f_cmd.value = MULTI;	
						var sParam = ComGetSaveString(sheetObjects);
		              
					    if (sParam == "") return;
					    sParam += "&" + FormQueryString(formObj);
 
						var aryPrefix = new Array("sheet1_");
					    var sXml = sheetObj.GetSaveXml("VOP_SCG_0035GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
					    sheetObj.LoadSaveXml(sXml);     
	                break;
	
					case IBINSERT:      // 입력				
					    break;
					    
					case IBCOPYROW:	 
 
					    if (sheetObj.id == "sheet1") {
						    var row = sheetObj.DataCopy();
						    sheetObj.RowStatus(row) = "I";
					    }; 
					break;	
					case IBSEARCH_ASYNC01:	 
		  
						 formObj.f_cmd.value = SEARCH01;
						 var aryPrefix = new Array("sheet1_");
			 
				 		 var sXml = sheetObj.GetSearchXml("VOP_SCG_0035GS.do", FormQueryString(document.form)+"&vsl_slan_cd="+slan_cd+"&tml_prod_rpt_flg=&" + ComGetPrefixParam( aryPrefix ) );
				     	 var VslSlanCd_info = ComGetEtcData(sXml,"VslSlanCd"); 
				     	 if( VslSlanCd_info != ""){
				     		 var aVslSlanCd_info = VslSlanCd_info.split("|");
				     		    
				     		 sheetObj.CellValue2( cRow,"sheet1_svc_type_name") = aVslSlanCd_info[2];
				     	 }
					break;	
 	
         }
     }
     /** 
      * Sheet vsl_slan_cd의 정보 조회 <br>
      * @param  없음
      * @return 없음
      * @author 장강철
      * @version 2009.05.21
      */  
     function sheet1_OnChange(sheetObj, row, col) {
    	  
    	 if( sheetObj.ColSaveName(col) == "sheet1_vsl_slan_cd" ){
			 if( sheetObj.CellValue.length != 3 ){
    	    	 ComShowCodeMessage("SCG50006", "Lane Code", "3");	
    	    	 sheetObj.SelectCell(row, "sheet1_vsl_slan_cd");
    	    	 return;
			 }    		 
    		 getVslSlanCd(sheetObj, row, col );
    	 }
     }
     /** 
     * Sheet vsl_slan_cd의 정보 조회 <br>
     * @param  없음
     * @return 없음
     * @author 장강철
     * @version 2009.05.21
     */  
    function getVslSlanCd(sheetObj, row, col) {
   	     var vsl_slan_cd  = sheetObj.CellValue(row,"sheet1_vsl_slan_cd");
         document.form.f_cmd.value = SEARCH01;
		 var aryPrefix = new Array("sheet1_");
      
 		 var sXml = sheetObj.GetSearchXml("VOP_SCG_0035GS.do", FormQueryString(document.form)+"&vsl_slan_cd="+vsl_slan_cd+"&tml_prod_rpt_flg="+"&" + ComGetPrefixParam( aryPrefix ) );
     	 var VslSlanCd_info = ComGetEtcData(sXml,"VslSlanCd");   
	     var msg =  ComScgGetMessageFromXml(sXml); 	
	     if( msg != "" ){
	    	ComShowMessage(msg);
	    	sheetObj.CellValue2( row, "sheet1_vsl_slan_cd") = "";
	    	sheetObj.SelectCell( row, "sheet1_vsl_slan_cd") ;	    	
	    	return; 
	     }     	 
     	 setVslSlanCd(row, VslSlanCd_info);
 		
    }
     /** 
      * VslSlanCd  결과 처리  <br>
      * @param  없음
      * @return 없음
      * @author 장강철
      * @version 2009.05.21
      */  
 	function setVslSlanCd(cRow, VslSlanCd_info) {
   	   var sheetObject = sheetObjects[0];
 
   	   var aVslSlanCd_info = VslSlanCd_info.split("|");
 	   sheetObject.CellValue2(cRow,"sheet1_vsl_slan_cd")  =  aVslSlanCd_info[0];
 	   sheetObject.CellValue2(cRow,"sheet1_vsl_slan_nm")  =  aVslSlanCd_info[1];    
 	   sheetObject.CellValue2(cRow,"sheet1_svc_type_name") =  aVslSlanCd_info[2];
 	   if( aVslSlanCd_info != 0 ){
 	      // sheetObject.CellValue2(cRow,"sheet1_del_chk")          =  1;
 	   }
 	}
 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
 
               switch (sAction) {
                   case IBSAVE : 
						var Row = sheetObj.ColValueDup("sheet1_vsl_slan_cd",false);
						if( Row != -1){
            	    		 ComShowCodeMessage("SCG50005","Data");
							 //sheetObj.SelectRow = Row;
	            	    	 sheetObj.SelectCell(Row, "sheet1_vsl_slan_cd");							 
							 return false;
						}
	                     if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
	                         return false;   
	                     }
				   break;
               }            	    	 
         }

         return true;
     }

 		function sheet1_OnPopupClick(sheetObj, Row, Col)
 		{
 			with(sheetObj)
 			{
 	            gRow = Row;
 				ComOpenPopup('/hanjin/VOP_VSK_0202.do', 426, 475, "setVslSlanCdPopup", "0,0", true, false, Row, Col, 0);
 	 		}
 		}
     /** 
      * VslSlanCd 팝업에서 선택한 값 Setting. <br>
      * @param  없음
      * @return 없음
      * @author 장강철
      * @version 2009.05.21
      */       
     function setVslSlanCdPopup(aryPopupData){
	   var sheetObject = sheetObjects[0];
	   sheetObject.CellValue2(gRow,"sheet1_vsl_slan_cd")   =  aryPopupData[0][1];
	   sheetObject.CellValue2(gRow,"sheet1_vsl_slan_nm"    )   =  aryPopupData[0][2];
	   sheetObject.CellValue2(gRow,"sheet1_vsl_svc_tp_cd"  )   =  aryPopupData[0][3];	   
	   sheetObject.SelectCell(gRow, "sheet1_vsl_slan_cd");  
	    
	   doActionIBSheet( sheetObject,document.form,IBSEARCH_ASYNC01, gRow, aryPopupData[0][1] );
 
	   gRow =0;
     }  		
	/* 개발자 작업  끝 */