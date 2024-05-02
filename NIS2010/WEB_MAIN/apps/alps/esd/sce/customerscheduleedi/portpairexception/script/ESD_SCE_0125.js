/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_joo_0030.js
*@FileTitle : 공동운항추정 산출
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.04 함대성
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ui_joo_0030 : ui_joo_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_sce_0125() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm; 
    }
    
   	/* 개발자 작업	*/
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var prefix = "sheet1_";
    var btnEnable = "X";	//버튼비활성

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /*
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     */
    function initControl() {
    	var form = document.form; 
    	axon_event.addListenerFormat('change',	 'obj_change',	 form); //- 변경될때
    }
    
   	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
	    		case "cust_trd_prnr_id":
	    		    form.f_cmd.value = SEARCH01;
	    			sheetObjects[0].WaitImageVisible = false;
	    			var formObj = document.form;
	    			
	    		    var sXml = sheetObj.GetSearchXml("ESD_SCE_0122GS.do" , SceFrmQryString(form));
	    		    
	    		    if(document.form.cust_trd_prnr_id.value == "" ){
	    		           //showErrMessage(getMsg("COM12114" ,"TP ID",'',''));
	    		           return false;
	    			}
	    		    
	    		    //텍스트 가져오기[partnerName]
	    		    var partnerName   = ComGetEtcData(sXml,"partnerName") == "" ? "" : ComGetEtcData(sXml,"partnerName");
	    		    var ediSvcTpNm 	  = ComGetEtcData(sXml,"ediSvcTpNm");
	    		    formObj.partnerName.value  = partnerName;
	    		    /*
	    		    if(ediSvcTpNm.substring(0,4) == "PORT"){	//CRUD버튼 활성
	    		    	//버튼 활성
	    		    	doActionBtnEnable('S');
	    		    }else{	//LANE타입이 아닌경우 partnerName조회할 수 있지만 CRUD 버튼 막는다
	    		    	//버튼 비활성
	    		    	doActionBtnEnable('X');
	    		    }*/
				   	break;
			}
	    } else {
			switch(obj.name) {
	    		case "cust_trd_prnr_id":
	        		formObj.vndr_nm.value = "";
				   	break;
			}
		}
	}
   	
    /**
     * Action 버튼의 활성/비활성을 설정한다. <br>
     * @param  invStatus String
     * @param  statusCd String
     * @return 없음
     * @author 김창식
     * @version 2009.10.12
     */	
    function doActionBtnEnable (invStatus){
    	// Invoice Confirm 버튼 활성/비활성
    	if(invStatus == 'S'){
    		//전역 변수
    		btnEnable = "S";
    	} else {
    		//전역 변수
    		btnEnable = "X";
    		
    		sheetObjects[0].RemoveAll();
    	}
    }

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch (srcName) { 
    	    case "btn_retrieve":
	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	        break;

    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

    	    case "btn_save":
	            doActionIBSheet(sheetObject,formObject,IBSAVE);
    	        break;

       	    case "btn_save_partner":
    	        doActionIBSheet(sheetObject,formObject, MULTI01);
    	        break;         	        


			case "btn_por_port_cd":
				selectPort(formObject, 'POR');
    	        break;

			case "btn_pol_port_cd":
	            selectPort(formObject, 'POL');
    	        break;

			case "btn_pod_port_cd":
	            selectPort(formObject, 'POD');
    	        break;

			case "btn_del_port_cd":
				selectPort(formObject, 'DEL');
    	        break;
    	        
			case "btn_RowAdd":
			   	if(formObject.cust_trd_prnr_id.value == ""){
			          ComShowCodeMessage("COM12114" ,"TP ID",'','');
			          return false;
			   	}
			
				var iRow = sheetObject.DataInsert();
				var i    = sheetObject.selectRow;
				//key setting
				sheetObject.CellValue2(i,prefix+"cust_trd_prnr_id") = formObject.cust_trd_prnr_id.value;
			   	//기본값 
				sheetObject.cellvalue2(i, prefix+"lnk_knt") = "1";
			break;
    	        
			case "btn_RowCopy":
				sheetObject.DataCopy();	//선택행아래 복사[Sheet]
				break;
    		} // end switch
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
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
 		
 		initControl();
     }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj, sheetNo) {
     	var cnt = 0;

     	switch (sheetNo) {
     	case 1: 
     		with (sheetObj) {
             // 높이 설정
             style.height = 260;
             //전체 너비 설정
             SheetWidth = mainTable.clientWidth;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = true;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo( 2, 1, 9, 100);

             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(23, 4, 0, true);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(true, true, false, true, false,false)

             var HeadTitle =  "SEQ|No \nUse|STS|POR|POL|Lane|Dir.|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|POD|DEL|Remarks";
             var HeadTitle1 = "SEQ|No \nUse|STS|POR|POL|Lane|Dir.|Port|Lane|Dir.|Port|Lane|Dir.|POD|DEL|Remarks";

             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle, true);
             InitHeadRow(1, HeadTitle1, true);

             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, cnt++ , dtSeq,        30,    daCenter,  true,    prefix+"seq",     		 false,          "",       dfNone,   		0,  false, false, 3,         true);
             InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  true,    prefix+"check",    	 false,          "",       dfNone,	    	0,  true,  true, 1,         true);
             InitDataProperty(0, cnt++ , dtHiddenStatus,30,   daCenter,  true,    prefix+"ibflag",  		 false,          "",       dfNone,	    	0,  false,  true,  5,         true);
             InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    prefix+"por_cd",     	 true,           "",       dfEngUpKey,  	0,  false, true,  5,         true);
             InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    prefix+"org_loc_cd",    true,           "",       dfEngUpKey,  	0,  false, true,  5,         true);
             InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"n1st_lane_cd",  false,          "",       dfEngUpKey,  	0,  true, true,  3,         false); //추가
             InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    prefix+"n1st_skd_dir_cd", false,          "",       dfEngUpKey,  	0,  true, true,  5,         false); //추가
             
             InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    prefix+"n2nd_pol_cd", 	 false,           "",       dfEngUpKey,  	0,  true, true,  5,         false); //추가
             InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"n2nd_lane_cd",  false,          "",       dfEngUpKey,  	0,  true, true,  3,         false); //추가
             InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    prefix+"n2nd_skd_dir_cd", false,          "",       dfEngUpKey,  	0,  true, true,  5,         false); //추가
             
             InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    prefix+"n3rd_pol_cd", 	  false,           "",       dfEngUpKey,  	0,  true, true,  5,         false);
             InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    prefix+"n3rd_lane_cd",   false,          "",       dfEngUpKey,  	0,  true, true,  3,         false); //추가
             InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    prefix+"n3rd_skd_dir_cd", false,          "",       dfEngUpKey,  	0,  true, true,  5,         false); //추가

             InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    prefix+"dest_loc_cd",   true,           "",       dfEngUpKey,  	0,  false, true,  5,         true);                 
             InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    prefix+"del_cd",    	 true,          "",       	dfEngUpKey,  	0,  false, true,  5,         true);
             InitDataProperty(0, cnt++ , dtData,      100,    daCenter,  true,    prefix+"usr_rmk", 	 	 false,          "",       dfNone,  		0,  true,  true, 498,         false);  //추가
             
             //hidden fields
             InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    prefix+"lnk_knt",     	 false,           "",       dfNone,  		0,  false, true,  1,         true);	 //추가
 			 InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    prefix+"cust_trd_prnr_id",true,          "",       dfNone, 		0,  false, false, 20,        false);
 			 InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,    prefix+"rout_seq",   	 false,          "",       dfNone, 		 	0,  false, false, 20,        false);
 			 
             InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,  true,    prefix+"cre_dt",   		 false,          "",   dfUserFormat2, 	0,  false, false, 12,        true);
             InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  true,    prefix+"cre_usr_id",  	 false,          "",       dfNone,     		0,  false, false, 20,        true);
             InitDataProperty(0, cnt++ , dtHidden,    100,    daCenter,  true,    prefix+"upd_dt",   		 false,          "",   dfUserFormat2, 	0,  false, false, 12,        false);
             InitDataProperty(0, cnt++ , dtHidden,     60,    daCenter,  true,    prefix+"upd_usr_id",  	 false,          "",       dfNone,  	    0,  false, false, 20,        false);
             
 			InitDataValid(0, prefix+"por_cd", 		vtEngUpOnly);
 			InitDataValid(0, prefix+"org_loc_cd", 	vtEngUpOnly);
 			InitDataValid(0, prefix+"n2nd_pol_cd", 	vtEngUpOnly);
 			InitDataValid(0, prefix+"n3rd_pol_cd", 	vtEngUpOnly);
 			InitDataValid(0, prefix+"dest_loc_cd", 	vtEngUpOnly);
 			InitDataValid(0, prefix+"del_cd", 		vtEngUpOnly);
 			 
             //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
 			InitDataCombo (0, prefix+"n1st_skd_dir_cd", " |E|W|S|N", " |E|W|S|N", "Manual");
 			InitDataCombo (0, prefix+"n2nd_skd_dir_cd", " |E|W|S|N", " |E|W|S|N", "Manual");
 			InitDataCombo (0, prefix+"n3rd_skd_dir_cd", " |E|W|S|N", " |E|W|S|N", "Manual");
 			InitUserFormat2(0,prefix+"cre_dt", "####-##-## ##:##", "-|:" );
 			InitUserFormat2(0,prefix+"upd_dt", "####-##-## ##:##", "-|:" );

 	        RangeBackColor(1, 5, 1, 9) = RgbColor(222, 251, 248);   // ENIS
 	        HeadRowHeight = 20 ;
             
     		} 
     		break;

     	}
     }
     
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) { 
    	
    	case IBSEARCH: //조회
    		if (validateForm(sheetObj, formObj, sAction)){
    			//if(!mandatoryChk(formObj)) break;
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("ESD_SCE_0125GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam(prefix));
    		}
    		break;

    	case IBSAVE: //저장 
    		if (validateForm(sheetObj, formObj, sAction)){
    			var SaveStr = ComGetSaveString(sheetObj);
    			if (SaveStr == ""){
    				ComShowCodeMessage("SCE01222");
    				return;
    			} 
    			formObj.f_cmd.value = MULTI;
    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
    			var sXml = sheetObj.GetSaveXml("ESD_SCE_0125GS.do", SaveStr + "&" + SceFrmQryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
    			sheetObj.LoadSearchXml(sXml);
    			
    	 		doActionIBSheet(sheetObj, formObj, IBSEARCH);
    	 		//document.form.cust_trd_prnr_id.focus();
    		}
    		break;
  
        case SEARCH01:
			document.getElementById('cust_trd_prnr_id').value = document.getElementById('cust_trd_prnr_id').value.toUpperCase();
            sheetObj.ShowDebugMsg = false;
          	formObj.f_cmd.value = SEARCH01; 
          	//sheetObj.DoSearch("ESD_SCE_120GS.do",SceFrmQryString(formObj));
          	var sXml = sheetObj.GetSearchXml("ESD_SCE_0120GS.do", SceFrmQryString(formObj));
    	    var partnerName = ComGetEtcData(sXml, "partnerName");
    	    
          	//var partnerName = sheetObj.EtcData("partnerName");
            document.getElementById('partnerName').value = partnerName;
            ComEtcDataToForm(formObj,sheetObj) ;            

            sheetObj.RemoveAll();
            break; 
            
       case MULTI01:
  			if(!validateForm(sheetObj,formObj,sAction)) return;        	  
            formObj.f_cmd.value = MULTI01;
            sheetObj.DoSearch4Post("ESD_SCE_0125GS.do", SceFrmQryString(formObj));

            break;
    	}
    }
   
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) {
    		case IBCREATE: //저장용 조회
    		case IBSEARCH: //조회
  			   if(formObj.cust_trd_prnr_id.value == ""){
    	           ComShowCodeMessage("COM12114" ,"TP ID",'','');
    	           return false;		   
    		   } 
    		   break;
    			
      		case IBSAVE:
   			   if(formObj.cust_trd_prnr_id.value == ""){
    	           ComShowCodeMessage("COM12114" ,"TP ID",'','');
    	           return false;		   
    		   } 
   			   
   			/*
    		   if(formObj.partnerName.value == ""){
    	           ComShowCodeMessage("COM12114" ,"TP NAME",'','');
    	           return false;
    		   }*/  
    	}
    	return true;
    }
 
    
  /**
  * 셀의 값이 바뀌었을 때 발생하는 Event
  * @param sheetObj
  * @param row
  * @param col
  * @return
  */
  function sheet1_OnChange(sheetObj , row , col, value)
  {
   	var formObj = document.form;
	var sName = sheetObj.ColSaveName(col);
	var rows = sheetObj.Rows;
	
	if(sheetObj.cellvalue(row, prefix+"n2nd_pol_cd")!="") {
		sheetObj.cellvalue2(row, prefix+"lnk_knt") = "2";
		
		if(sheetObj.cellvalue(row, prefix+"n3rd_pol_cd")!="") {
			sheetObj.cellvalue2(row, prefix+"lnk_knt") = "3";
		}
	}else{
		sheetObj.cellvalue2(row, prefix+"lnk_knt") = "1";
	}
	
	switch (sName) {
		//1 org_loc_cd
   		case prefix+"org_loc_cd" : 
   			if(row > 0 && row < rows) {
   				if(sheetObj.cellvalue(row, prefix+"por_cd") == ""){
   					sheetObj.cellvalue2(row, prefix+"por_cd") = sheetObj.cellvalue(row, prefix+"org_loc_cd");
   				}
   			}
   		break;
   		//2 dest_loc_cd
   		case prefix+"dest_loc_cd" : 
   			if(row > 0 && row < rows) {
   				if(sheetObj.cellvalue(row, prefix+"del_cd") == ""){
   					sheetObj.cellvalue2(row, prefix+"del_cd") = sheetObj.cellvalue(row, prefix+"dest_loc_cd");
   				}
   			}
   		break; 
   	 }
  }
  
  function mandatoryChk(formObj) {
	  alert(formObj.cust_trd_prnr_id.value);
	   if(formObj.cust_trd_prnr_id.value == "" ){	//|| formObj.partnerName.value == ""
          ComShowCodeMessage("COM12114" ,"TP ID",'','');
          return false;		   
	   }
      return true;
  }

  
	function getPartnerName(){
       var sheetObject = sheetObjects[0];
       /*******************************************************/
       var formObj = document.form;

	   if(formObj.cust_trd_prnr_id.value == "" ){
          ComShowCodeMessage("COM12114" ,"TP ID",'','');
          return false;		   
	   }
		doActionIBSheet(sheetObject,formObj,SEARCH01);
	
	}   

	function changeSelect(gubun) {
		var frm = document.form;
		var val = frm.select1[frm.select1.selectedIndex].value;
		frm.ts_type.value = val; 
	}

	function selectType() {
	    var frm = document.form;
       var ts_type = frm.ts_type.value;
	    var param = '?&ts_type='+ts_type;

      //comPopup('/hanjin/COM_ENS_081.do' + param, 770, 470, 'getLane', "1,0,1,1,1,1,1,1,1,1,1,1");
      
	}

	var portInd = '';
	function selectPort(frm, pt){
		portInd = pt;
		var param = '';
		if(pt == 'POR') param = '?loc_cd='+frm.por_port_cd.value;
		if(pt == 'POL') param = '?loc_cd='+frm.pol_port_cd.value;
		if(pt == 'POD') param = '?loc_cd='+frm.pod_port_cd.value;
		if(pt == 'DEL') param = '?loc_cd='+frm.del_port_cd.value;
		//ComShowCodeMessage("o param : " + param);
		comPopup('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1');
	}

	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];
		var frm = document.form;
		if(portInd == 'POR'){
			 frm.por_port_cd.value = cArray[3];
		}		
		if(portInd == 'POL'){
			 frm.pol_port_cd.value = cArray[3];
		}
		if(portInd == 'POD'){
			 frm.pod_port_cd.value = cArray[3];
		}
		if(portInd == 'DEL'){
			 frm.del_port_cd.value = cArray[3];
		}	
	}
	
   /**
	*  LOC(ROR/POL/POD/EDL) 팝업 오픈 &&&
	*
	* @param multi multi check 여부
	* @param custCd Customer Code
	* @param custNm Customer Name
	* @param ofcCd Sales Office
	* @param custSgmt Segmentation
	* 2008.6.24 LOC(ROR/POL/POD/EDL)팝업창 추가
	*/
	/*
	function openLocPopUp(multi, locCd, locDesc, contiCd, scontiCd, cntCd,
	                   locState, locEqOfc, locPortInd, sysCode){
		var param   = "" ;
		var display = getCommPopDisplay(multi) ;
	
		param  = "?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "conti_cd",     contiCd) ;
		param += getURLParam(multi, "sconti_cd",    scontiCd) ;
		param += getURLParam(multi, "cnt_cd",       cntCd) ;
		param += getURLParam(multi, "loc_state",    locState) ;
		param += getURLParam(multi, "loc_eq_ofc",   locEqOfc) ;
		param += getURLParam(multi, "loc_cd",       locCd) ;
		param += getURLParam(multi, "loc_desc",     locDesc) ;
		param += getURLParam(multi, "loc_port_ind", locPortInd) ;
		param += getURLParam(multi, "sysCode",      sysCode, "ENIS") ;
		ComOpenPopup('ESD_SCE_0109.do' + param, 800, 470, 'setValFromLocPop', display) ;
		contiCdFld    = contiCd ;
		scontiCdFld   = scontiCd ;
		cntCdFld      = cntCd ;
		locStateFld   = locState ;
		locEqOfcFld   = locEqOfc ;
		locCdFld      = locCd ;
		locDescFld    = locDesc ;
		locPortIndFld = locPortInd ;
		sysCodeFld    = sysCode ;
		multiChkYN    = multi
	}
*/
	/**
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김종옥
	 * @version 2009.06.15
	 */ 
	function obj_keypress(){
	 	obj = event.srcElement;
	 	if(obj.dataformat == null) return;
	 	 	
	 	window.defaultStatus = obj.dataformat;
	 	 
	 	switch(obj.dataformat) {
	 	    case "engup":
	 	        ComKeyOnlyAlphabet('upper');
	 	        break;
	 	}
	}    
	
	/**  
	 * Object 의 Keypress 이벤트에 대한 처리  <br>
	 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김종옥
	 * @version 2009.06.15
	 */ 
	function obj_keyup(){
		
		var formObj = document.form;
	 	obj = event.srcElement;
	 	
	 	if(obj.dataformat == null) return;
	 	 	
	 	window.defaultStatus = obj.dataformat;
	 	 
	 	switch(obj.dataformat) {
	 	    case "engup":
	 	        break; 
	 	}
	}
	/* 개발자 작업  끝 */