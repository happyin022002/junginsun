/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0012.js
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.15 장창수
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
     * @class fns_tot_012 : fns_tot_012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_tot_0012() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject			= setComboObject;
    }

	 // 공통전역변수
	
	 var sheetObjects = new Array();
	 var sheetCnt = 0;
	 var closing_yn = "N";
	 var last_day = "";
	 
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
                case "btn_Down_Excel":
	                sheetObject1.Down2Excel();
                break;
 				case "btn_Close":

						self.close();
				
                break;
               
 			    case "btn_Modify":
 			    	 if(modify_yn == "Y"){
	 			    	 if(closing_yn == "N"){
		 			    	   for(var i=1; i<=sheetObject1.RowCount("R"); i++){
		 			    	       sheetObject1.CellEditable(i,"sheet1_voy_dys") = true;
		                       }
		 			    	   
		 			    	  if(sheetObject1.CellValue(1,"sheet1_trd_cd") != "YYY" && sheetObject1.CellValue(1,"sheet1_trd_cd") != "ZZZ") {
		 			    		  sheetObject1.CellEditable(1,"sheet1_ldb_capa_qty") = true;
		 			    	  }
	 			    	 }
	 			    	 
	 			    	for(var i=1; i<=sheetObject1.RowCount("R"); i++){
		 				   	if(sheetObject1.CellValue(i,"sheet1_trd_cd") != "YYY" && sheetObject1.CellValue(i,"sheet1_trd_cd") != "ZZZ") {
		 				   		sheetObject1.CellEditable(i,"sheet1_ldb_capa_qty") = true;
		 				 	}
	 			    	} 
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
    function loadPage(stlClzFlg) {
    	 
    	  var formObject = document.form;
         //IBSheet 초기화하기
         for(i=0;i<sheetObjects.length;i++){

             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
             
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }
         
         //alert(stlClzFlg);
         
         closing_yn = stlClzFlg;
         modify_yn = formObject.modify_yn.value;
         //alert("modify_yn ::: "+modify_yn);
  		 if(modify_yn == "Y"){
   			
  	  		 if(closing_yn == "Y"){
  	  			
  	  			ComBtnDisable("btn2_Modify");
  	  		 }else{
  	  			ComBtnEnable("btn2_Modify");
  	  		 }

   		 }else{
   			ComBtnDisable("btn2_Modify");
   		 }

  		
  		  //alert("load 끝");
         //첫번째 IBShseet의 데이터만 먼저 조회한다.
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }
      
    /**
       * Sheet 기본 설정 및 초기화
       * body 태그의 unonLoad 이벤트핸들러 구현
       * 화면을 브라우저가 닫힐때 처리해야 하는 기능을 추가한다
       */
    function unloadPage() {
    	  
    	  var sheetObject1 = sheetObjects[0];
    	  var iCheckRow = sheetObject1.CheckedRows("radio");
 			
		 if(iCheckRow>0){
				    comPopupOK();
		 }
      }
      
      

    /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
    function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      // t1sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 250;
                     
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle1 = "||TRADE|LANE|VVD|PORT|LOAD\nCAPA|SUPPLY\n(BSA)|S/Charter\n(BSA)|Actual\nLoad|CAPA\nDiff.|USE(%)|ETD|DAY|Taxable\nAmount|||||||||||||||";
 					

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);


                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     
                     var prefix = "sheet1_";		 
                    	 
                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    	 InitDataProperty(0, cnt++, dtStatus    ,  0, daCenter, true, prefix+"ibflag"   );
                     InitDataProperty(0, cnt++, dtData      , 50, daCenter, true, "dd"                        , false, "", dfNone   , 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 50, daCenter, true, prefix+"trd_cd"             , false, "", dfNone   , 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 70, daCenter, true, prefix+"slan_cd"            , false, "", dfNone   , 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      ,100, daCenter, true, prefix+"vvd"                , false, "", dfNone   , 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 70, daCenter, true, prefix+"port_cd"            , false, "", dfNone   , 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 70, daRight , true, prefix+"ldb_capa_qty"       , false, "", dfInteger, 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 70, daRight , true, prefix+"bsa_capa"           , false, "", dfInteger, 0,	false, false);
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daRight , true, prefix+"chtr_bsa_capa"      , false, "", dfInteger, 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 70, daRight , true, prefix+"act_bsa_capa"       , false, "", dfInteger, 0,	false, false);
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter, true, prefix+"capa_diff"          , false, "", dfNone   , 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 80, daRight , true, prefix+"usg_rt"             , false, "", dfFloat  , 2,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 80, daCenter, true, prefix+"etd_dt"             , false, "", dfDateYmd, 0,	false, false);
                     InitDataProperty(0, cnt++, dtData      , 60, daRight , true, prefix+"voy_dys"            , false, "", dfInteger, 0,	false, false, 3);
                     InitDataProperty(0, cnt++, dtData      ,110, daRight , true, prefix+"tong_tax_amt"       , false, "", dfInteger, 0,	false, false);
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"stl_yrmon"          , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"tong_stl_bat_jb_seq", false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"vsl_cd"             , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"port_seq"           , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"vsl_dznd_capa"      , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"tong_flet_tp_cd"    , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"per_ton_rev"        , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"old_voy_dys"        , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"last_row_yn"        , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"dys_diff"           , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"total_voy_dys"      , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"total_tax_amt"      , false, "", dfNone   );
                     InitDataProperty(0, cnt++, dtHidden    ,  0, daCenter,false, prefix+"to_vvd_stl_dt"      , false, "", dfNone   ); 					
                     InitDataProperty(0, cnt++, dtHidden    , 80, daLeft, true,   prefix+"vsl_svc_tp_nm"      , false, "", dfNone   , 0,	false, false);
                     InitDataProperty(0, cnt++, dtRadioCheck,  0, daCenter,false, "radio"                     , false, "", dfNone   , 0,  true,  true);


                    sheetObj.ColHidden("radio") = true;
             }
                 break;
         }
    }

    /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * @param {ibsheet} sheetObj    IBSheet Object
       * @param {int}     sheetNo     sheetObjects 배열에서 순번
       **/
    function initControl() {
    	  
      	//** Date 구분자 **/
      	DATE_SEPARATOR = "-";
      	var formObject = document.form;
      	
         //Axon 이벤트 처리1. 이벤트catch
     	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
     	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리

    }
      
    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
      ComChkObjValid(event.srcElement);
          
    }

    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }

    /*
    * 팝업이 아닌 선박코드 수기 입력시 호출하여 선박명, 
    * FMS_Del_date와 FMS_Re_Del_date에 셋팅한다. <br>
    */    
    function sheet1_OnChange(sheetObj,Row, Col, Value){
    	var prefix = "sheet1_";
    	var sName = sheetObj.ColSaveName(Col);

   	 	if(sName == prefix+"voy_dys"){
             
   	 	    calculate_data(sheetObj, Row, Col, Value);
   	 	    sheetObj.CellValue2(Row,"radio") = 1;
   	 	}
   	 	
   	   if(sName == prefix+"ldb_capa_qty"){
         
	 	    calculate_ldb_capa(sheetObj, Row, Col, Value);
	 	    sheetObj.CellValue2(Row,"radio") = 1;
	 	}
    }    

    /*
     * 수정된 day(일수)로 taxable amount를 재계산하고 운항일자 변경 
     * 
     */
     
    function calculate_data(sheetObj, row, col, val){
    	 
    	 var formObj = document.form;
         var prefix = "sheet1_";		 

    	 var ldb_capa_qty    = ComParseInt(sheetObj.CellValue(row,prefix+"ldb_capa_qty"));
         var bsa_capa        = ComParseInt(sheetObj.CellValue(row,prefix+"bsa_capa"));
         var chtr_bsa_capa   = ComParseInt(sheetObj.CellValue(row,prefix+"chtr_bsa_capa"));
         var act_bsa_capa	 = ComParseInt(sheetObj.CellValue(row,prefix+"act_bsa_capa"));		 
		 var vsl_dznd_capa   = ComParseInt(sheetObj.CellValue(row,prefix+"vsl_dznd_capa"));
         var tong_flet_tp_cd =             sheetObj.CellValue(row,prefix+"tong_flet_tp_cd" );
         var per_ton_rev     = ComParseInt(sheetObj.CellValue(row,prefix+"per_ton_rev"));
		 var old_voy_dys     = ComParseInt(sheetObj.CellValue(row,prefix+"old_voy_dys"));  
		 var voy_dys         = ComParseInt(sheetObj.CellValue(row,prefix+"voy_dys"));
		 var trdCd           =             sheetObj.CellValue(row,prefix+"trd_cd");
		 //var usage         = ComParseInt(sheetObj.CellValue(row,prefix+"usg_rt"));

         var taxable_amt = 0;

          
		if (!ComShowCodeConfirm('TOT00052')){
			sheetObj.CellValue2(row,col) = old_voy_dys;  
			return;
		}

	     //마지막행 체크
        if(row == sheetObj.LastRow){
        	 sheetObj.CellValue2(row,23) = "Y";        	 
        }		

        if(bsa_capa>act_bsa_capa){
   		    usage = ComRound((bsa_capa+chtr_bsa_capa)/ldb_capa_qty*100,3);
     	 }else{
   		    usage = ComRound((act_bsa_capa+chtr_bsa_capa)/ldb_capa_qty*100,3);
   	      }
        
         // Taxable Amount 구하기
         //2010.06.10 H.D.Park YYY,ZZZ인 경우는 무조건 100% 이므로 단순히 per_ton_rev * 일수를 해주면 된다.
         if (trdCd == "YYY" || trdCd == "ZZZ"){
        	 taxable_amt = ComParseInt(per_ton_rev * ComParseInt(voy_dys), 0) ;
         }else{
        	 taxable_amt = ComParseInt(per_ton_rev * ComParseInt(voy_dys)* (usage/100),0) ;
         }
         //alert("taxable_amt : "+taxable_amt);
         sheetObj.CellValue2(row,14) = taxable_amt;  
        
        // days, taxable_amt 합계 구하기
         var t_taxable_amt = 0;
         var t_day = 0;
         var t_old_day = 0;
         
        for(var j=1;j<=sheetObj.LastRow;j++){
        	// alert("status : "+sheetObj.RowStatus(j));
        	 t_day = t_day + ComParseInt(sheetObj.CellValue(j,13));
        	 t_old_day = t_old_day+ ComParseInt(sheetObj.CellValue(j,22));
         	 t_taxable_amt = t_taxable_amt+ ComParseInt(sheetObj.CellValue(j,14));
         }
      //alert("t_taxable_amt : "+t_taxable_amt);
         var dys_diff = t_day - t_old_day;


	     //마지막행 체크
       //  if(row == sheetObj.LastRow){
        //	 sheetObj.CellValue2(row,22) = "Y";        	 
       //  }
         sheetObj.CellValue2(row,24) = dys_diff;  
         sheetObj.CellValue2(row,25) = t_day;  
         sheetObj.CellValue2(row,26) = t_taxable_amt;  
         
       //alert("dys_diff : "+dys_diff+" t_taxable_amt : "+t_taxable_amt+" t_day : "+t_day+" t_old_day : "+t_old_day+"  dys_diff : "+dys_diff);
		 formObj.f_cmd.value = MULTI;
		 
		 var SaveStr = ComGetSaveString(sheetObjects);
		 if (SaveStr == ""){
				ComShowCodeMessage('TOT00011');
				return;
		 }
		 sheetObj.WaitImageVisible=false;
     	 ComOpenWait(true);
     	 
		 formObj.f_cmd.value = MULTI;
   		 var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
		 var sXml = sheetObj.GetSaveXml("FNS_TOT_0012GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		 sheetObj.LoadSaveXml(sXml);
		 ComOpenWait(false);
		 sheetObj.CellValue2(row,22) = voy_dys;
		 
  
    }    
 
    /*
     * 수정된 LOAD CAPS로  사용율 및 taxable amount를 재계산
     * 
     */
     
    function calculate_ldb_capa(sheetObj, row, col, val){
    	 
    	 var formObj = document.form;
         var prefix = "sheet1_";	
         
	  	 if (!ComShowCodeConfirm('TOT00086')){
	  		var vsl_dznd_capa   = ComParseInt(sheetObj.CellValue(row,prefix+"vsl_dznd_capa"));
	  		
			sheetObj.CellValue2(row,col) = vsl_dznd_capa;  
			return ;
		 }
		
	  	var ldb_capa_qty    = ComParseInt(sheetObj.CellValue(row,prefix+"ldb_capa_qty"));
	  	
	  	if(sheetObj.CellValue(row,prefix+"vsl_svc_tp_nm") != "Joint Operation") {
		  	for(var i=1; i<sheetObj.RowCount+1;i++){ 
		  		
		  		if(sheetObj.CellValue(i,prefix+"vsl_svc_tp_nm") != "Joint Operation") {
		  			sheetObj.CellValue2(i, 6) = ldb_capa_qty;
		  	    }
		  	   //sheetObj.CellValue2(i+1, 6) = ldb_capa_qty;
		  	}
	  	}
	  	else {
	  		sheetObj.CellValue2(row, 6) = ldb_capa_qty;
	  	}
	  	
	  	for(var i=1; i<sheetObj.RowCount+1;i++) {
        	 
	  		if(sheetObj.CellValue(row,prefix+"vsl_svc_tp_nm") != "Joint Operation") {
    	         row = i;
	  		}
    	     else {
    	    	 row = row;
	  		 }    
     
	    	 var ldb_capa_qty    = ComParseInt(sheetObj.CellValue(row,prefix+"ldb_capa_qty"));
	         var bsa_capa        = ComParseInt(sheetObj.CellValue(row,prefix+"bsa_capa"));
	         var chtr_bsa_capa   = ComParseInt(sheetObj.CellValue(row,prefix+"chtr_bsa_capa"));
	         var act_bsa_capa	 = ComParseInt(sheetObj.CellValue(row,prefix+"act_bsa_capa"));		 
	         var per_ton_rev     = ComParseInt(sheetObj.CellValue(row,prefix+"per_ton_rev"));
			 var voy_dys         = ComParseInt(sheetObj.CellValue(row,prefix+"voy_dys"));
			 var trdCd           =             sheetObj.CellValue(row,prefix+"trd_cd");

	         var capa = 0;
	         var usage = 0;
	         var taxable_amt = 0;
 
	         capa = ldb_capa_qty;
	         
        	 if(bsa_capa>act_bsa_capa){
        		 usage = ComRound((bsa_capa+chtr_bsa_capa)/capa*100,3);
        		
        	 }else{
        		 usage = ComRound((act_bsa_capa+chtr_bsa_capa)/capa*100,3);
        	 }
	        	 
	         /*}*/
	         // Taxable Amount 구하기
	         //2010.06.10 H.D.Park YYY,ZZZ인 경우는 무조건 100% 이므로 단순히 per_ton_rev * 일수를 해주면 된다.
	         if (trdCd == "YYY" || trdCd == "ZZZ"){
	        	 taxable_amt = ComParseInt(per_ton_rev * ComParseInt(voy_dys), 0) ;
	         }else{
	        	 taxable_amt = ComParseInt(per_ton_rev * ComParseInt(voy_dys)* (usage/100),0) ;
	         }
	         
	         /*alert("row : "+row); 
	         alert("rowact_bsa_capa : "+act_bsa_capa); 
	         alert("usage : "+usage); 
	         alert("taxable_amt : "+taxable_amt);*/
	         
	         sheetObj.CellValue2(row,11) = usage;  
	         sheetObj.CellValue2(row,14) = taxable_amt;  
	        
			 var SaveStr = ComGetSaveString(sheetObjects);
			 if (SaveStr == ""){
					ComShowCodeMessage('TOT00011');
					return;
			 }
			 
			 sheetObj.WaitImageVisible=false;
			 /*alert("row = "+row)
			 alert("LastRow = "+sheetObj.LastRow)*/
			
			 if(sheetObj.CellValue(row,prefix+"vsl_svc_tp_nm") == "Joint Operation") {
				 ComOpenWait(true);
		     	 
				 formObj.f_cmd.value = MULTI01;
		   		 var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
				 var sXml = sheetObj.GetSaveXml("FNS_TOT_0012GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				 sheetObj.LoadSaveXml(sXml);
				 ComOpenWait(false);
				 return;
			 }
			 
			 if(sheetObj.CellValue(row,prefix+"vsl_svc_tp_nm") != "Joint Operation") {
				 if(row == sheetObj.LastRow){
			     	 ComOpenWait(true);
			     	 
					 formObj.f_cmd.value = MULTI01;
			   		 var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
					 var sXml = sheetObj.GetSaveXml("FNS_TOT_0012GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					 sheetObj.LoadSaveXml(sXml);
					 ComOpenWait(false);
				 }	
			 }	 
         }		 
    }    
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {
				case IBSEARCH:      //조회
	             if (validateForm(sheetObj, formObj, sAction)){
	             	
	                 if ( sheetObj.id == "sheet1"){
	     				 formObj.f_cmd.value = SEARCH;
	     				 var prefix = "sheet1_";	//prefix 문자열 배열
	                    
		    			var sXml = sheetObj.GetSearchXml("FNS_TOT_0012GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		    			
		    			sheetObjects[0].LoadSearchXml(sXml);
		    			
		    			for(var i=0; i<sheetObjects[0].RowCount0;i++){
		    				sheetObjects[0].CellValue(i,prefix+"trd_cd")
		    			} 
	                 }
	                 
	             }
				
			    break;

                case IBSAVE:        //저장
		
                break;

         }
    }

    /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
    function validateForm(sheetObj,formObj,sAction){
         /*
         with(formObj){
             if (!isNumber(formObj.iPage)) {
                 return false;
             }
         }
         */

         return true;
    }

    /**
      * 아이비시트 팝업 클릭시 이벤트
      */
    function t1sheet1_OnPopupClick(sheetObj, Row,Col,Value)
    {
         switch(sheetObj.ColSaveName(Col)) {
             case "MDate":
                 alert("MDate_popup_click");
                 break;
         }
    }


	/* 개발자 작업  끝 */