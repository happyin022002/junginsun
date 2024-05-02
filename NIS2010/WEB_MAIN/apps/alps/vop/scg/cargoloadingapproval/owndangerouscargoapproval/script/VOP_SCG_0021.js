/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0021.js
*@FileTitle : Restrictions
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.17 김현욱
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
     * @class VOP_SCG_0021 : VOP_SCG_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_SCG_0021() {
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

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var SEARCH_METHOD = "";

    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {         
    	var sheetObject1 = sheetObjects[0];
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[1] , formObject, IBSEARCH);
					break;
					
				case "btn_New":
					doActionIBSheet(sheetObjects[1] , formObject, IBRESET);
					break;
					
				case "btn_Close":
					window.close();
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
    function setSheetObject(sheet_obj) {
    	 sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++) {

        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();   
    }
     
    /**
     * Sheet2 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
 	function sheet2_OnLoadFinish(sheetObj) {
    	 doActionIBSheet(sheetObj,document.form,IBCLEAR);  
    	 
    	 ComSetObjValue(document.form.imdg_un_no, preConds.imdg_un_no);
    	 ComSetObjValue(document.form.imdg_un_no_seq, preConds.imdg_un_no_seq);
    	 ComSetObjValue(document.form.imdg_clss_cd, preConds.imdg_clss_cd);
    	 searchUnNo(sheetObj, document.form);
    	 
    	 ComSetObjValue(document.form.pol_port_cd, preConds.pol_port_cd);
    	 ComSetObjValue(document.form.pod_port_cd, preConds.pod_port_cd);
    	 ComSetObjValue(document.form.slan_cd, preConds.slan_cd);
    	 
    	 ComSetObjValue(document.form.bkg_no, preConds.bkg_no);
    	 ComSetObjValue(document.form.vsl_cd, preConds.vsl_cd);
    	 ComSetObjValue(document.form.skd_voy_no, preConds.skd_voy_no);
    	 ComSetObjValue(document.form.skd_dir_cd, preConds.skd_dir_cd);
    	 
    	 //조회
      	 doActionIBSheet(sheetObj , document.form, IBSEARCH);
      	 
      	 //Irregular List 조회
      	 searchIrrForUnNo(preConds.imdg_un_no);
 	}
     
    // 이벤트 Catch Listener
    function initControl() {
    	var formObj = document.form;

      	axon_event.addListenerForm('keypress','obj_keypress',   form  );
    	axon_event.addListenerForm('keyup',   'obj_keyup',      form );
             	 
  	    axon_event.addListenerForm('blur',    'obj_blur',       form); 
   
        axon_event.addListener    ('click',   'img_click',   	"srch_imdg_un_no");
        axon_event.addListener    ('click',   'img_click',   	"srch_irregulars_list");  
    }
     
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;

        switch(sheetNo) { 
	     	case 1:      //t2sheet1 init
	     		with (sheetObj) {
	     			// 높이 설정
	     			style.height = 82;
	     			style.width  = 490;		          
	     			//전체 너비 설정
	     			SheetWidth = mainTable.clientWidth;
		
	     			//Host정보 설정[필수][HostIp, Port, PagePath]
	     			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
	     			//전체Merge 종류 [선택, Default msNone]
	     			MergeSheet = msHeaderOnly;
		
	     			//전체Edit 허용 여부 [선택, Default false]
	     			Editable = false;
		
	     			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	     			InitRowInfo(1, 1, 1, 100);
		
	     			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	     			InitColumnInfo(8, 0, 0, true);
		
	     			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	     			InitHeadMode(true, true, true, true, false )
		
	     			var HeadTitle1 = "|Type|Port Code|Required|Explanation";
		
	     			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	     			InitHeadRow(0, HeadTitle1, false, true);
		
	     			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	     			InitDataProperty(0, cnt++ , dtData,	        60,	    	daCenter,	true,		"crr_cd1",		false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,		    daCenter,	true,		"crr_cd2",	    false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    60,	        daCenter,	true,		"crr_cd3",		false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			60,	        daCenter,	true,		"crr_cd4",      false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			60,		    daCenter,	true,		"crr_cd5",	    false,           "",      dfNone, 			0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,         daCenter,   true,       "crr_cd6",      false,           "",      dfNone,           0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,         daCenter,   true,       "crr_cd7",      false,           "",      dfNone,           0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         60,         daCenter,   true,       "crr_cd8",      false,           "",      dfNone,           0,     true,       true);
								
                    //선택된 행의 하이라이트를 안준다.
                    SelectHighLight = false;

                    ShowButtonImage = 1;
					//DataLinkMouse = true;
					CountPosition = 0;
							
			    }
	     		break; 
            case 2:      //t2sheet1 init
               	with (sheetObj) {
                    // 높이 설정
                    style.height = 235;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 13, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle1 = "|Type|Port Code|Required|Explanation";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, false, false);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,		daCenter,	true,		"Status",		       false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    95,		daCenter,	false,		"port_type",	       false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,		    100,	daCenter,	false,		"port_cd",		       false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"imdg_cmptn_auth_cd",  false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			55,		daLeft,		true,		"txt_desc",	           false,           "",      dfNone, 			0,     true,       true);

					 
					InitDataCombo(0, "port_type", "POL|POD|Transit", "1|2|3");
						
                    //선택된 행의 하이라이트를 안준다.
                    SelectHighLight = false;

                    ShowButtonImage = 1;
					DataLinkMouse("port_cd") = true;

               }
               break;
        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, cRow, pObj) {
  		sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBCLEAR:      //초기화      
             	formObj.imdg_un_no.focus();
             	formObj.imdg_un_no.select();
             	
             	break;         
         	case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction)){
                    return;
                }

			 	formObj.f_cmd.value = SEARCH01;
			 	var param      =  FormQueryString(formObj);

			 	var sXml = sheetObj.GetSearchXml("VOP_SCG_0011GS.do", param); 
			 	var aXml =  sXml.split("|$$|");	
			 	
			 	sXml = sheetObj.GetSearchXml("VOP_SCG_0021GS.do", param); 
			 	
			 	sheetObjects[1].LoadSearchXml( sXml );
			 	sheetObj.ColFontUnderline("port_cd") = true;
			 	
			 	fnCarrierSearchEnd( aXml[0] );
			 	
			 	SEARCH_METHOD = ComGetEtcData(aXml[0], "SEARCH_METHOD"); //{class, unno}
			 
                break;

			case IBRESET:      // NEW 버튼
                fnBtnNew();
				formObj.imdg_un_no.focus(); 
				
				break;
			case IBSEARCH_ASYNC02:  //axon_event prp_shp_nm 
				if(!validateForm(sheetObj,formObj,sAction)){ 
				    return;
				}
	            formObj.f_cmd.value = SEARCH05;
	            var param                       =  FormQueryString(formObj) ;
	            var sXml                        =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);		 
	            var prp_shp_nm                  =  ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
	            var imdg_clss_cd_desc           =  ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
	            var imdg_clss_cd                =  ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd  		                 
	
	             
	            var sTotal = ComScgGetTotalValue(sXml);
	            if( sTotal == "0"){
	             	 ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
			         formObj.imdg_un_no_seq.value = '';
			         formObj.prp_shp_nm.value     = '';			         
			         formObj.imdg_un_no_seq.focus();
	            }else{
	                 formObj.prp_shp_nm.value        =  prp_shp_nm;   
	                 formObj.imdg_clss_cd_desc.value =  imdg_clss_cd_desc;
	                 formObj.imdg_clss_cd.value      =  imdg_clss_cd;
	            }
             	
             	break;
			case IBSEARCH_ASYNC03:  //CheckUnNumber
                formObj.f_cmd.value = SEARCH01;
           
                var param =  FormQueryString(formObj) ;
                var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
                var sTotal = ComScgGetTotalValue(sXml);
                if( sTotal == "0"){
             	    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
             	    formObj.imdg_un_no.value = "";
             	    formObj.imdg_un_no.focus();
                }else{
           	     	formObj.imdg_un_no_seq.focus();
           	     	
	           	    var isChk = false;
	          	    if(unData != null && unData.length > 0) {
	         	 	    for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
	         	 	    	if(formObj.imdg_un_no.value == unData[arrIdx]) isChk = true;
	         	 	    }
	          	    } 
	          	    
	          	    if(isChk) document.getElementById('srch_irregulars_list').style.color = "red";
	          	    else document.getElementById('srch_irregulars_list').style.color = "#737373";
                }
                break;		             
        }
    }
  	
  	function searchUnNo(sheetObj, formObj) {
  		formObj.f_cmd.value = SEARCH05;
     	var param                       =  FormQueryString(formObj) ;
     	var sXml                        =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);		 
     	var prp_shp_nm                  =  ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
     	var imdg_clss_cd_desc           =  ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
     	var imdg_clss_cd                =  ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd  		                 
     	formObj.prp_shp_nm.value        =  prp_shp_nm;   
     	formObj.imdg_clss_cd_desc.value =  imdg_clss_cd_desc;
     	formObj.imdg_clss_cd.value      =  imdg_clss_cd;
     
     	var  Msg =ComScgGetMessageFromXml(sXml );
     	if( Msg != ""){
        	ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
        	formObj.imdg_un_no_seq.value = '';
        	formObj.prp_shp_nm.value     = '';			         
        	formObj.imdg_un_no_seq.focus();
        	
        	return false;
     	}
     	
     	return true;
  	}
  	
  	/**
     * Irregular List for Un No. 조회
     */
    var unData;
    function searchIrrForUnNo(imdg_un_no) {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	formObj.f_cmd.value = SEARCH07;
    	sheetObj.WaitImageVisible = false;	
 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0012GS.do", FormQueryString(formObj)); 	
 	   	sheetObj.WaitImageVisible = true;	
 	   	
 	    unData = ComScgXml2Array(sXml, "imdg_un_no");
 	    
 	    var isChk = false;
 	    if(unData != null && unData.length > 0) {
	 	    for(var arrIdx=0; arrIdx<unData.length; arrIdx++) {
	 	    	if(imdg_un_no == unData[arrIdx]) isChk = true;
	 	    }
 	    } 
 	    
 	    if(isChk) document.getElementById('srch_irregulars_list').style.color = "red";
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
       	 	switch ( sAction ) {
       	 		case  IBSEARCH:
	       	 		if( !ComChkRequired(formObj) ){
	                    return false;
	                }    	        	  
       	        	break;
       	 	}
        }

        return true;
    }


    /************************************User_event*************************************************/ 	
    /**
     * Unno Help 팝업으로 Unno, seq, ClassCd 구하기 
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				선택 선택한 Row
     * @param  {Int} col				선택 선택한 Column
     * @param  {Int} sheetIdx		선택 Sheet Index
     * @return 없음
     */  
    function setUnnoAndClassCd(aryPopupData) { 
       	with(document.form) {
       		imdg_clss_cd.value       = aryPopupData[0][4]; 
       		imdg_clss_cd_desc.value  = aryPopupData[0][5];    
       		imdg_un_no.value     = aryPopupData[0][2];      
       		imdg_un_no_seq.value = aryPopupData[0][3];          		
       		prp_shp_nm.value     = aryPopupData[0][6]; 
	    }
    }
    
    /**
     *  Carrier 조회 후 처리.
     *  
     */
    function fnCarrierSearchEnd( sXml ) {
    	 if( sXml == ""){
         	return;
         }
         var total = eval( ComScgGetTotalValue(sXml) );
         var rowNum = 1;
         if( total > 0){
         	sheetObjects[0].RemoveAll();
         	sheetObjects[0].DataInsert(-1);
         }
         var j = -1;
          
         for(var i=1;i<=total;i++){
             var value = ComScgGetRowValue(sXml, i, "vsl_opr_tp_cd");    
             if ( j < sheetObjects[0].LastCol ){
                 j++;
             }else{
             	j=0;
             	sheetObjects[0].DataInsert(-1);            	
             	rowNum++;             	
             }
             sheetObjects[0].CellValue2(rowNum, j) = value;
             sheetObjects[0].DataLinkMouse(j) = true;                 
             sheetObjects[0].ColFontUnderline(j) = true;
         }
         
         for(var i=sheetObjects[1].HeaderRows;i<=sheetObjects[1].RowCount;i++){
            if ( sheetObjects[1].CellValue( i, "imdg_cmptn_auth_cd")   == "Prohibition"  ){
                 sheetObjects[1].CellFontColor( i, "imdg_cmptn_auth_cd") = sheetObjects[1].RgbColor(255, 0, 0);
            }
        
         }
    }
    
    /**
     * NEW 버튼 처리. 
     * @return
     */
    function fnBtnNew() {
   	  	var formObj = document.form;
   	  	fnNewGrid();
   	  	formObj.imdg_un_no.value         = '';	         
   	  	formObj.imdg_un_no_seq.value     = '';	
   	  	formObj.prp_shp_nm.value         = '';		
   	  	formObj.imdg_clss_cd.value       = ""; 	            	
   	  	formObj.imdg_clss_cd_desc.value  = ""; 
   	  	
   	  	document.getElementById('srch_irregulars_list').style.color = "#737373";
    }
     
    /**
     * 
     * <pre>
     *    Grid 데이타 크리어 
     * </pre>
     *
     * @param   
     * @return
     * @author jang kang cheol
     */
    function fnNewGrid() {
        for(var i=0;i<sheetObjects.length;i++){
            var cnt = sheetObjects[i].RowCount;

            for(var j=1;j<= cnt;j++ ) {
                sheetObjects[i].RowDelete(1, false);
            }
        }
    }
     
    /************************************Sheet_event*************************************************/ 	     
 	function sheet1_OnClick(sheetObj,Row,Col,Value) {
 		var formObj = document.form;
 		if( Value != ""){

			 var  imdg_clss_cd      =  formObj.imdg_clss_cd.value;
			 var  imdg_clss_cd_desc =  formObj.imdg_clss_cd_desc.value;
			 var  imdg_un_no        =  formObj.imdg_un_no.value;
			 var  imdg_un_no_seq    =  formObj.imdg_un_no_seq.value;
			 var  prp_shp_nm        =  formObj.prp_shp_nm.value; 
 			 var  sUrl              = "/hanjin/VOP_SCG_0010.do?pgmNo=VOP_SCG_0010";
 			 var  param             = "&pCrr_cd="+Value;
 			 
 			 param          += "&pImdg_clss_cd="+imdg_clss_cd;
 			 param          += "&pImdg_clss_cd_desc="+imdg_clss_cd_desc;
 			 param          += "&pImdg_un_no="+imdg_un_no;
 			 param          += "&pImdg_un_no_seq="+imdg_un_no_seq;    
             param          += "&pPrp_shp_nm="+prp_shp_nm;
             param          += "&pSearchMethod="+SEARCH_METHOD;
             sUrl += param;
             
             var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
             var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;  	
 			 var iWidth  = 1026;
 			 var iHeight = 705;             
 			 var sFeatures = "scroll:no;status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos;
 			 ComOpenWindow(sUrl,"VOP_SCG_0010",sFeatures, true);
 
 		}
	}
 	
 	function sheet2_OnClick(sheetObj,Row,Col,Value) {
 		var formObj = document.form;
        
 		if( sheetObj.ColSaveName(Col) == "port_cd" ){
            var  imdg_clss_cd      =  formObj.imdg_clss_cd.value;
            var  imdg_clss_cd_desc =  formObj.imdg_clss_cd_desc.value;
            var  imdg_un_no        =  formObj.imdg_un_no.value;
            var  imdg_un_no_seq    =  formObj.imdg_un_no_seq.value;
            var  prp_shp_nm        =  formObj.prp_shp_nm.value; 
            var sUrl = "/hanjin/VOP_SCG_0006.do?pgmNo=VOP_SCG_0006&pPort_cd="+Value;
            var  param             = "&pCrr_cd="+Value;
            
            param          += "&pImdg_clss_cd="+imdg_clss_cd;
            param          += "&pImdg_clss_cd_desc="+imdg_clss_cd_desc;
            param          += "&pImdg_un_no="+imdg_un_no;
            param          += "&pImdg_un_no_seq="+imdg_un_no_seq;    
            param          += "&pPrp_shp_nm="+prp_shp_nm;
            sUrl += param;
            

             var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
             var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0; 			
 			 var iWidth  = 1040;
 			 var iHeight = 700;
 			 var sFeatures = "status:no;help:no;dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos;
 			ComOpenWindow(sUrl, sUrl, sFeatures, true);		 
 		}
	} 

    /************************************Axon_event*************************************************/
   
    /**
     * Form Object obj_keypress 이벤트시 처리
     * @param  void
     * @return void
     */     
    function obj_keypress () {
   		var obj = event.srcElement;
 	  	switch (obj.name){          
 	  		case 'imdg_un_no':
 	    	    ComKeyOnlyNumber(obj);
 	    	    break;
 	  		case 'imdg_un_no_seq':
 	    	    ComKeyOnlyNumber(obj);
	    	    break;      	    	    
 	  	}
    }
    
    /**
     * Form Object  blur 이벤트시 처리
     * @param  void
     * @return void
     */     
    function obj_blur () {
    	var obj = event.srcElement;

	  	var formObj = document.form;
	  	switch (obj.name) {
	  		case 'imdg_un_no':
	  			if(obj.value != '') {
		  			if( !ComChkObjValid( formObj.imdg_un_no) ){
		  				return;
			        }else{
			            doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC03);                         
			        }
	  			}
		        break;
		
		    case 'imdg_un_no_seq':
		    	if(obj.value != '') {
			        if( !ComChkObjValid( formObj.imdg_un_no_seq) ){
		                return;
			        }else{
		                doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02); 	 	                  
			        }
		    	}
	            break;         
	  	  }
    }  
      
    /**
     * Form obj_keyup 이벤트시 처리
     * @param  void
     * @return void
     */ 
    function obj_keyup() {

    	 var obj = event.srcElement;	  	  
	  	 var formObj = document.form;
	  	 switch (obj.name) {
	  	 	case 'imdg_un_no':
	        	if( formObj.imdg_un_no.value.length == 4 ){
	        		formObj.imdg_un_no_seq.focus();
	        	}else{
	        		fnNewGrid();                          
	        		formObj.imdg_un_no_seq.value     = '';    
	        		formObj.prp_shp_nm.value     = '';        
	        		formObj.imdg_clss_cd.value = "";                  
	        		formObj.imdg_clss_cd_desc.value = "";                 
	        	}
	        	break;   
	  	 	case 'imdg_un_no_seq':
	  	 		fnNewGrid();                          

	  	 		formObj.prp_shp_nm.value     = '';        
	  	 		formObj.imdg_clss_cd.value = "";                  
	  	 		formObj.imdg_clss_cd_desc.value = ""; 

	  	 		break;                 
	  	}             

    }
      
    /**
     * image Button 클릭시 이벤트 처리
     * @param  void
     * @return void
     */
    function img_click() {
    	var obj = event.srcElement;
    	var formObj = document.form;
  	    if(obj.name == "srch_imdg_un_no") { 
  	    	var imdg_un_no = formObj.imdg_un_no.value;
 	    	ComOpenPopup('/hanjin/VOP_SCG_3005.do?imdg_un_no='+imdg_un_no,940, 420, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true);
 	    }
 	    if(obj.name == "srch_irregulars_list") { 
 	    	var imdg_un_no = formObj.imdg_un_no.value;
 	    	if(document.getElementById('srch_irregulars_list').style.color != 'red') imdg_un_no = "";
 	    	ComOpenWindowCenter("VOP_SCG_0012Pop.do?pgmNo=VOP_SCG_0012&pop_mode=Y&f_cmd=&imdg_un_no="+imdg_un_no, "winIrrList", "1025", "700", true);
 	    }
    }
    
	/* 개발자 작업  끝 */