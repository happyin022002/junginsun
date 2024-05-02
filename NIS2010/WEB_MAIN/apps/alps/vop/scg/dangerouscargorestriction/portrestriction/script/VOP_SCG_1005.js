/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_1005.js
*@FileTitle : SAVE DG Restriction by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.03 장강철 jkc
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
     * @class vop_scg_1005 : vop_scg_1005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_1005() {
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

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          
          var sheetObject1 = sheetObjects[0];
          
          /*******************************************************/
          var formObject = document.form;

     //	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 				case "btn_rowAdd":
 					
					doActionIBSheet(sheetObject1,document.form,IBINSERT); 					
 					break;
 					
 				case "btn_delete":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
 					break;
 					
 				case "btn_save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
 					break;
 					
 					

 				case "btn_close":
 					window.close();
 					break;

             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
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
 		 //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 	         
 		 //doActionIBSheet(sheetObjects[0],document.form,IBINSERT);         
 		
	 
 		
        // axon_event.addListenerForm('keyup',   'obj_keyup',   	form) 
     }
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
      }

   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height =120;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);



                      var HeadTitle = "|sel|Port Code||Name|Save As Type|Save As Type|Save As Type|Save As Type|Class||UN No./Seq.|UN No./Seq.";
                     //var HeadTitle = "|sel|Port Code||Name|Save As Type|Save As Type|Save As Type|Save As Type||||";                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo( HeadTitle.split("|").length  , 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     var prefix = "sheet1_";
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,     30,     daCenter,       false,  prefix+"ibflag"        );
                     InitDataProperty(0, cnt++ , dtCheckBox,         30,     daCenter,       false,  prefix+"sel"           );                                  
                     InitDataProperty(0, cnt++ , dtPopupEdit,        95,     daCenter,       false,  prefix+"port_cd",                       true,  "",         dfEngUpKey,                 0,                      true,           true,5);
                     InitDataProperty(0, cnt++ , dtHidden,           30,       daLeft,       false,  prefix+"imdg_port_rstr_seq",            false,  "",             dfNone,                 0,                      true,           true);
                     InitDataProperty(0, cnt++ , dtData,            140,       daLeft,       false,  prefix+"port_cd_nm",                    false,  "",             dfNone,                 0,                      false,           false);
                     InitDataProperty(0, cnt++ , dtCheckBox,         20,     daCenter,       false,  prefix+"sav_type_class_flag",           false,  "",             dfNone,                 0,                      false,           false);
                     InitDataProperty(0, cnt++ , dtData,             50,     daCenter,       false,  prefix+"sav_type_class_label",          false,  "",             dfNone,                 0,                      false,           false);
                     InitDataProperty(0, cnt++ , dtCheckBox,         20,     daCenter,       false,  prefix+"sav_type_unno_flag",            false,  "",             dfNone,                 0,                      false,           false);
                     InitDataProperty(0, cnt++ , dtData,             50,     daCenter,       false,  prefix+"sav_type_unno_label",           false,  "",             dfNone,                 0,                      false,           false);
                     
                     
                     InitDataProperty(0, cnt++ , dtData,             50,     daCenter,       false,  prefix+"imdg_clss_cd",                  false,  "",             dfNone,                 0,                      false,           false);
                     InitDataProperty(0, cnt++ , dtHidden ,          50,     daCenter,       false,  prefix+"imdg_clss_cd_txt",              false,  "",             dfNone,                 0,                      true,           true);                     
                     InitDataProperty(0, cnt++ , dtData,             60,     daCenter,       false,  prefix+"imdg_un_no",                    false,  "",             dfNone,                 0,                     false,           false, 4);
                     InitDataProperty(0, cnt++ , dtData,             10,     daCenter,       false,  prefix+"imdg_un_no_seq",                false,  "",             dfNone,                 0,                     false,           false, 2);
                     
//                     if(document.form.strOpt.value == 'class'){
//                         InitDataProperty(0, 9, dtCombo,            50,     daCenter,       false,  prefix+"imdg_clss_cd",                  true,   "",             dfNone,                 0,                      true,           true);
//                     }else if(document.form.strOpt.value == 'unno'){
//	                    	 
//                    	  InitDataProperty(0, 11 , dtData,            60,     daCenter,       false,  prefix+"imdg_un_no",                  true,   "",             dfNumber,                 0,                      true,           true,4);
//                          InitDataProperty(0, 12 , dtPopupEdit,       10,     daCenter,       false,  prefix+"imdg_un_no_seq",              true,  "",              dfNumber,                 0,                       true,           true, 2);
//      					  //InitDataValid(0, "sheet1_imdg_un_no", vtNumericOnly);
//     					 // InitDataValid(0, "sheet1_imdg_un_no_seq", vtNumericOnly);                           
//                     }
 					//InitDataCombo(0, prefix+"imdg_clss_cd", "1|2|3|4|5|", "1|2|3|4|5|");
 					ShowButtonImage = 2;
 					InitDataValid(0, "sheet1_port_cd", vtEngUpOther, "0123456789" );
 					
 					
 					BasicImeMode    =  imeEng;
 					FocusStyle = fsSolid;
 					MultiSelection=false;
 			   }
                 break;

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, cRow) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
           
            case COMMAND02:      //CLASS 코드 조회
 
            
                 break;
            case IBSEARCH:      //조회
            
//                 formObj.f_cmd.value = SEARCH01;
//                 var param =  FormQueryString(formObj);
//                 var sXml   =  sheetObj.GetSearchXml("VOP_SCG_1005GS.do", param);
//                 var strCombo = ComXml2ComboString( sXml, "imdg_clss_cd", "imdg_clss_cd_txt"  );
 
                 formObj.f_cmd.value = SEARCH02;      //SEARCH02            
                 var param =  FormQueryString(formObj);
 
                 //var sXml  = sheetObj.GetSearchXml("VOP_SCG_0005GS.do", param);//SEARCH02
                 var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);                 
                 var strCombo = ComXml2ComboString( sXml, "imdg_clss_cd", "imdg_clss_cd_txt"  );
     
                 sheetObj.InitDataCombo(0,  "sheet1_imdg_clss_cd",  " |"+strCombo[0],  " |"+strCombo[1]);
                
         		 doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                 break;

 			 case IBSAVE:        //저장

                 if(!validateForm(sheetObj,formObj,sAction)){ 
            	      return;
                 }
			     formObj.f_cmd.value = MULTI01;
				 var aryPrefix       =  new Array("sheet1_");
	             var sParam = ComGetSaveString(sheetObjects);
 
     
	             if( sParam == ""){ return;}
	             sParam  +=  "&"+FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );

				 var sXml   =  sheetObj.GetSaveXml( "VOP_SCG_1005GS.do", sParam);
				 sheetObj.LoadSaveXml(sXml);
				 
				 var rslt = ComGetEtcData(sXml, "row");
				 if(rslt != '-1') {
					 sheetObj.SelectCell(parseInt(rslt)+1, 2);
					 for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
						 sheetObj.RowStatus(i) = "I";
					 }
				 }
				 
                 break;

 			case IBINSERT:      // 입력
 
		         with (sheetObj){
                     //sheetObj.InitDataCombo(0, "sheet1_imdg_clss_cd", "1|2|3|4|5|", "1|2|3|4|5|"); 				
 				     DataInsert(-1);
 				     initRow(sheetObj, LastRow);
 				    // CellValue2(LastRow, "sheet1_sel"  ) = 1;
 				     SelectCell(LastRow, "sheet1_port_cd" )
			     }
 				 break;

 			case IBDELETE:      // 삭제
		    	 with (sheetObj){
 		
                     //var cnt = CheckedRows("sheet1_sel");
 				    var cnt = RowCount;
 				    for(var i=0;i<cnt;i++){ 
                        for(var j=1;j<= cnt;j++ ){
                            if(  CellValue(j, "sheet1_sel")  == 1 ){
                                RowDelete(j, false);
                            }
                        } 
 				    }
		    	 } 			
 
                 break; 			
            case IBSEARCH_ASYNC01:      //조회   PORT_NM구하기
				 formObj.f_cmd.value = SEARCH09;;
				 var aryPrefix       =  new Array("sheet1_");
	             var param           =  "f_cmd="+formObj.f_cmd.value+"&port_cd="+sheetObj.CellValue( cRow, "sheet1_port_cd");
				 var sXml            =  sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", param);
				 var port_cd_nm      =  ComGetEtcData(sXml,"port_cd_nm"); 
				 var sMsg            =  getMessage(sXml);
				 if(sMsg != ""){
					 ComShowMessage(sMsg); 
					 sheetObj.CellValue2(cRow, "sheet1_port_cd") = "";					 
					 sheetObj.CellValue2(cRow, "sheet1_port_cd_nm") = "";
					 sheetObj.SelectCell(cRow, "sheet1_port_cd");
                     return;
				 }				 
				 sheetObj.CellValue2(cRow, "sheet1_port_cd_nm")   = port_cd_nm;
	             break;
	             
//            case IBSEARCH_ASYNC02:      //조회   prp_shp_nm 구하기
//                 formObj.f_cmd.value =  SEARCH06;
//                 var imdg_un_no      =  sheetObj.CellText( cRow, "sheet1_imdg_un_no");
//                 var imdg_un_no_seq  =  sheetObj.CellText( cRow, "sheet1_imdg_un_no_seq");
//                 var param        =  "f_cmd="+formObj.f_cmd.value+"&imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq;
//                 var sXml         =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
//                 var prp_shp_nm   =  ComGetEtcData(sXml,"prp_shp_nm");  
//  
//     		     var msg =  ComScgGetMessageFromXml(sXml); 	
//    		     if( msg != "" ){
//    		    	ComShowMessage(msg);
// 
//    		     }
//
//    		     var imdg_clss_cd =  ComGetEtcData(sXml,"imdg_clss_cd");   
// 
//                 sheetObj.CellText( cRow, "sheet1_imdg_clss_cd") = imdg_clss_cd;
//                 sheetObj.CellText( cRow, "sheet1_imdg_clss_cd_txt") = imdg_clss_cd;                 
//	             break;
	             
         }
     }
     function getMessage(sXml){
 	    if ( sXml == null  || sXml == "" ) return;

 	    try {
 	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
 	        xmlDoc.loadXML(sXml);

 	        var xmlRoot = xmlDoc.documentElement;
 	        if(xmlRoot == null) return;
  
 	        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
 	      
 	        if(msgNode == null) return "";

 	        return msgNode.firstChild.nodeValue;
 	    } catch(err) { ComFuncErrMsg(err.message); }
 	}
     function initRow(sheetObj, Row){ 
    	 var formObj =  document.form;
    	 sheetObj.CellValue2(Row, "sheet1_sav_type_class_label") = "Class";
    	 sheetObj.CellValue2(Row, "sheet1_sav_type_unno_label")  = "UN No.";
    	 
    	 //sheetObj.CellValue2(Row, "sheet1_sav_type_unno_label")  = "UN No.";
    	 
    	 sheetObj.CellValue2(Row, "sheet1_imdg_clss_cd")         =  formObj.imdg_clss_cd.value;
    	 sheetObj.CellValue2(Row, "sheet1_imdg_un_no")           =  formObj.imdg_un_no.value;
    	 sheetObj.CellValue2(Row, "sheet1_imdg_un_no_seq")       =  formObj.imdg_un_no_seq.value;
    //	 sheetObj.CellValue2(Row, "sheet1_sav_type_unno_label")  = "UN No.";
 
    	 
    	 var strOpt = formObj.strOpt.value;
    	 
    	 with(sheetObj){
  		 
	    	 if( strOpt == "class"){
//
//	    		 CellEditable(Row, "sheet1_sav_type_class_flag")  = true;
//	    		 CellEditable(Row, "sheet1_sav_type_unno_flag")   = false;    	
//	    		 
//	    		 CellEditable(Row, "sheet1_imdg_un_no")       = false;
//	    		 CellEditable(Row, "sheet1_imdg_un_no_seq")   = false;
//	    		 CellEditable(Row, "sheet1_imdg_clss_cd")     = true;	    		 
//	    		 
	    		 
	        	 sheetObj.CellValue2(Row, "sheet1_sav_type_class_flag")  =  1;	    		 
	    		 
	    	 }
	    	 if( strOpt == "unno"){
//	    		 CellEditable(Row, "sheet1_sav_type_unno_flag")  = true;
//	    		 CellEditable(Row, "sheet1_sav_type_class_flag") = false;
//	    		 
//	    		 CellEditable(Row, "sheet1_imdg_un_no")      = true;
//	    		 CellEditable(Row, "sheet1_imdg_un_no_seq")  = true;
//	    		 CellEditable(Row, "sheet1_imdg_clss_cd")     = false;
	        	 sheetObj.CellValue2(Row, "sheet1_sav_type_unno_flag")  =  1;	    		    		 
	    	 }
    	 }
	 }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
 
               switch(sAction) {
 				   case IBSAVE:
 					    
//    			    	for(var i=1;i<=sheetObj.RowCount;i++){
//    			    		 if( sheetObj.CellValue(i,"sheet1_port_cd_nm") == "" ){// PORT_CD NAME 미 입력시
//	 					          ComShowCodeMessage("SCG01001","Port Cd" );
//    			    		      sheetObj.SelectCell(i, "sheet1_port_cd");
//    			    		      return;
// 					    	  }
//                        }
 					    if(  formObj.strOpt.value == "class"){//class_cd 선택시
 	 					    var strCode    = formObj.port_cd.value+"|"+formObj.imdg_clss_cd.value;
 					    	for(var i=1;i<=sheetObj.RowCount;i++){
//                                if( sheetObj.CellValue(i,"sheet1_imdg_clss_cd") == "" ){//class_cd 미 입력시
//                                	ComShowCodeMessage("SCG00302","(Row:"+i+")");
//                                }
	 	 					    var rowStrCode = sheetObj.CellValue(i,"sheet1_port_cd")+"|"+sheetObj.CellValue(i,"sheet1_imdg_clss_cd");
	 	 					    if( strCode == rowStrCode ){
	 	 					    	ComShowCodeMessage("SCG50005",'Data');
	 	 					    	sheetObj.SelectRow = i;
	 	 					    	return false;
	 	 					    }
	 					    }
 					    }
 					    if(  formObj.strOpt.value == "unno"){
 	 					    var strCode    = formObj.port_cd.value+"|"+formObj.imdg_un_no.value+"|"+formObj.imdg_un_no_seq.value;
	 					    for(var i=1;i<=sheetObj.RowCount;i++){
	 	 					    var rowStrCode = sheetObj.CellValue(i,"sheet1_port_cd")+"|"+sheetObj.CellValue(i,"sheet1_imdg_un_no")+"|"+sheetObj.CellValue(i,"sheet1_imdg_un_no_seq");
	 	 					    if( strCode == rowStrCode){
	 	 					    	ComShowCodeMessage("SCG00302","(Row:"+i+")");
	 	 					    	sheetObj.SelectRow = i;
	 	 					    	return false;
	 	 					    }
	 					    }
 					    }
 	                   if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
                            return false;   
                        }
 					    break;
 

             } // end switch
         }

         return true;
     }

 	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		with(sheetObj)
		{
	   	    if(ColSaveName(Col) == "sheet1_port_cd"){
                 var port_cd = CellValue(Row, Col);
                 ComOpenPopup('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 427, 495, "setPortNm", "0,0", true,false,Row, Col, 0, "COM_ENS_051");
	   	    } 
 
	   	    if(ColSaveName(Col) == sheetObj.id+"_imdg_un_no_seq"){
          
    	    	 ComOpenPopup('/hanjin/VOP_SCG_3005.do',940, 397, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false, Row, Col, 0);	    	
	    	}   	   	    
 		}
 	}
 
    /**
     * Unno Help 팝업으로 Unno, seq, ClassCd 구하기 
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				선택 선택한 Row
     * @param  {Int} col				선택 선택한 Column
     * @param  {Int} sheetIdx		선택 Sheet Index
     * @return 없음
     */  
     function setUnnoAndClassCd(aryPopupData,row, col, seetIdx){
        var prefix =  sheetObjects[seetIdx].id+"_";
    	with( sheetObjects[seetIdx] ){
 
    		CellText  ( row, prefix+"imdg_clss_cd")       = aryPopupData[0][4];//class cd 
    		CellValue2( row, prefix+"imdg_clss_cd_txt")   = aryPopupData[0][4];
    		CellValue2( row, prefix+"imdg_un_no")         = aryPopupData[0][2];      
    		CellValue2( row, prefix+"imdg_un_no_seq")     = aryPopupData[0][3];          		
    		CellValue2( row, prefix+"prp_shp_nm")         = aryPopupData[0][6]; 
    	}
     } 	
    /**
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     */   
    function setPortNm(aryPopupData, row, col, sheetIdx){
 
    	with(sheetObjects[0]){
    		CellValue2( row , col) = aryPopupData[0][2];
    		CellValue2( row , "sheet1_port_cd_nm") = aryPopupData[0][3];    		
    	}
    }
 
 
  	
  	// 셀의 값이 바뀌었을 때 발생하는 이벤트
  	function sheet1_OnChange(sheetObj, Row, Col, Value)
  	{  
 
  		with(sheetObj)
  		{
 
  			switch(sheetObj.ColSaveName(Col) )
 			{
				case  sheetObj.id+"_port_cd":
	  		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, Row);  	
 					break;  			
 				case sheetObj.id+"_imdg_clss_cd":
 	                CellValue2(Row, "sheet1_imdg_clss_cd_txt") =  CellText(Row, "sheet1_imdg_clss_cd" );
 					break;
 
// 				case sheetObj.id+"_imdg_un_no_seq": 	
//	  		 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02, Row);  	 					
// 					break;
 					
 			}  			 
  		}
  	}
 
  	  	
	/* 개발자 작업  끝 */