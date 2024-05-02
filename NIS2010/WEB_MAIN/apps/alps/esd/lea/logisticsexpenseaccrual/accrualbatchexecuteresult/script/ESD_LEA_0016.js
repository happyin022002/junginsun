/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0016.js
*@FileTitle : Accessorial Cost Budget Management
*Open Issues :
*Change history :2015.04.09 현성길 최초생성
*@LastModifyDate : 2015.04.09
*@LastModifier : 현성길
*@LastVersion : 1.0
* 2015.04.09 현성길
* 1.0 Creation
* 2016.02.03 화면오류 로직보완
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
     * @class ESD_LEA_0016 : ESD_LEA_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0016() {
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

    /* 공통전역변수 */
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    	
    	    var sheetObject = sheetObjects[0];
    	
    	    var formObject = document.form;
    	
    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			
    	       switch(srcName) {
    	
    	   	    case "btn_retrieve":
    	   	        setLastyr();
    	   	    	initSheet(sheetObjects[0],1);
                
    	   	        sheetObject.RemoveAll();
    	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);	    		
    	            break;
    	
    	   	    case "btng_downexcel":
    				//sheetObject. ExcelOption= "NOCOLOR";
        	    	sheetObject.SpeedDown2Excel(true);
        	    	//sheetObject. ExcelOption= "";   
    	   	        break;
    	   	        
                case "btns_calendar1":
       	         	var cal = new ComCalendar();
       	         	cal.setDisplayType('month');
       	         	cal.select(formObject.gl_mon_from, 'yyyy-MM');
       	         	break;

                case "btns_calendar2":
       	         	var cal = new ComCalendar();
       	         	cal.setDisplayType('month');
       	         	cal.select(formObject.gl_mon_to, 'yyyy-MM');
       	         	break;
                case "btn_budget":  	
   
               	//var classId = "ESD_LEA_0022";
                //	var param = '?pgmNo=FNS_INV_0022&ar_if_no='+arIfNo+'&ar_ofc_cd='+arOfcCd+'&classId='+classId;
                	//ComOpenWindow('/hanjin/ESD_LEA_0022.do', 'ESD_LEA_0022', 'width=880 height=480');
                   	ComOpenWindowCenter('/hanjin/ESD_LEA_0022.do', 'ESD_LEA_0022', "878", "490");
					
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
        	
        	   dateSetup();
               setLastyr();

        	for(i=0;i<sheetObjects.length;i++){
            	//시작 환경 설정 함수 이름 변경
            	ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                //마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }

             var sheetObject = sheetObjects[0];
             var formObj = document.form;
             sheetObject.RemoveAll();
             changeReport("1");
          
             doActionIBSheet(sheetObject,formObj,COMMAND01); // Office별 권한 채크를 위해 생성
             doActionIBSheet(sheetObject,formObj,COMMAND02); // 로그인 Office별 Search Rhq Office 
      
             var usrOfccd = ComGetObjValue(formObj.usr_ofc_cd);
             var usrRhqOfccd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
             
             ComAddComboItem(formObj.f_sub_ofc_cd, "All", "");
           
             statusLoad();
            
        }

       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
              switch(sheetNo) {
                case 1:      //IBSheet1 init
                    with (sheetObj) {
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;
                        
                     // 높이 설정
    					style.height =380;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(27, 6, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, false, false, true, false,false);
                      
                        var HeadTitle1  = "RHQ|Control\nOffice|System|Cost Type Ⅰ|Cost Type Ⅱ|Cost\n Code|Cost\n Description|Budget|" +
                        	 		document.form.gl_mon_from.value + "\n~" +document.form.gl_mon_to.value + "|"+
                        	 		document.form.lstyr_from.value + "\n~" +document.form.lstyr_to.value + "|Month|Month|Month|Month|Month|Month|Month|Month|Month|Month|Month|Month|Vs.Budget|Vs.Budget%|Vs.Prev.Yr|Total Budget|Vs.Total Budget%" ;
                        var HeadTitle2 = "RHQ|Control\nOffice|System|Cost Type Ⅰ|Cost Type Ⅱ|Cost\n Code|Cost\n Description|Budget|" +
            	 		document.form.gl_mon_from.value + "\n~" +document.form.gl_mon_to.value + "|"+
            	 		document.form.lstyr_from.value + "\n~" +document.form.lstyr_to.value + "|1|2|3|4|5|6|7|8|9|10|11|12|Vs.Budget|Vs.Budget%|Vs.Prev.Yr|Total Budget|Vs.Total Budget%" ;
                                    		
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true, false);
                        InitHeadRow(1, HeadTitle2, true, false);
                
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtData ,      60,   daCenter,	true ,  "rhq_cd"          ,	false,    "",    dfNone ,     0,     false,	false); 
                        InitDataProperty(0, cnt++ , dtData ,      60,   daCenter,	true ,	"ctrl_ofc_cd"	  ,	false,    "",    dfNone ,     0,     false,	false); 
                        InitDataProperty(0, cnt++ , dtData ,      55,   daCenter,	true ,	"cost_src_sys_cd" ,	false,    "",    dfNone ,     0,     false,	false); 
                        InitDataProperty(0, cnt++ , dtData ,      80,   daCenter,	true ,	"mn_cost_tp_nm"   ,	false,    "",    dfNone ,     0,     false,	false);                                               
                        InitDataProperty(0, cnt++ , dtData ,     140,   daLeft,	    true ,	"sub_cost_tp_nm"  ,	false,    "",    dfNone ,     0,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      60,   daCenter,   true ,	"coa_cost_src_cd" ,	false,    "",    dfNone ,     0,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,     220,   daLeft,     true ,	"cost_desc"		  ,	false,    "",    dfNone ,     0,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon_bud"		  ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"prd_sum"		  ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"lstyr_sum"		  ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon1"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon2"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon3"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon4"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon5"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon6"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon7"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon8"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon9"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon10"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon11"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"mon12"		      ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"diff_bud"		  ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"diff_bud_rto"	  ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"diff_lstyr"	  ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,      90,   daRight,    true ,	"ttl_bud"		  ,	false,    "",    dfFloat ,    2,     false,	false);
                        InitDataProperty(0, cnt++ , dtData ,     100,   daRight,    true ,	"ttl_bud_rto"	  ,	false,    "",    dfFloat ,    2,     false,	false);

                       // RangeBackColor(1, 6, 1, 8) = RgbColor(222, 251, 248);   // ENIS
                       // HeadRowHeight = 35 ;
                        
 
                    }
                    break;
            }
        }
        
        /* Sheet관련 프로세스 처리 */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {
            	
            case IBSEARCH:      //조회
		    	var ofcType = ComGetObjValue(formObj.ofc_type);
	    		var usrOfccd = ComGetObjValue(formObj.usr_ofc_cd);
	    		
		    	if(ComGetObjValue(formObj.f_ofc_cd) == '') { // Ctrl_Ofc 가 All
		    		if(ofcType == 'HT' || ofcType == 'HQ')
		    			formObj.bind_ofc_cd.value = ComGetObjValue(formObj.f_rhq_cd);
		    		else
		    			formObj.bind_ofc_cd.value = usrOfccd;
		    	}
            		
            		if(validateForm(sheetObj,formObj,sAction)) {
    		    	formObj.f_cmd.value = SEARCH;
    		    	
//    		    	var ofcType = ComGetObjValue(formObj.ofc_type);
//		    		var usrOfccd = ComGetObjValue(formObj.usr_ofc_cd);
		    		
//			    	if(ComGetObjValue(formObj.f_ofc_cd) == '') { // Ctrl_Ofc 가 All
//			    		if(ofcType == 'HT' || ofcType == 'HQ')
//			    			formObj.bind_ofc_cd.value = ComGetObjValue(formObj.f_rhq_cd);
//			    		else
//			    			formObj.bind_ofc_cd.value = usrOfccd;
//			    	}
//			    	
			    
    		    	
    		    	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0016GS.do", leaFormQueryString(formObj));
    			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
            		}
            		
           		
                    break;
                
                case COMMAND01:
              	   	//if(validateForm(sheetObj,formObj,sAction)){
  				    	formObj.f_cmd.value = COMMAND01;
  						  
  				    	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0016GS.do", leaFormQueryString(formObj));
  				    	
  				    	var ofcType = ComGetEtcData(searchXml, "OFC_TP_CD");
  				    	formObj.ofc_type.value = ofcType;
  						  
  					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
          	   		//}
          	   		break;
               
                case COMMAND02:
      
               	   // if(validateForm(sheetObj,formObj,sAction)){
 				    	formObj.f_cmd.value = COMMAND02;
 
 						var searchXml = sheetObj.GetSearchXml("ESD_LEA_0016GS.do", leaFormQueryString(formObj));
 						
 						var accRhqOfcCd = ComGetEtcData(searchXml, "Account_Rhq_Offiice");
						formObj.acct_rhq_ofc_cd.value = accRhqOfcCd;
 						  
 					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
         	   		//}
         	   		break;
             	   		
                case COMMAND03:
                	var ctrlOfcCd;
                		ctrlOfcCd = ComGetObjValue(formObj.f_ofc_cd);
                	
            	 	var params		= "f_cmd=" + COMMAND03 + "&ctrl_ofc_cd=" + ctrlOfcCd;
            	 	var searchXml	= sheetObj.GetSearchXml("ESD_LEA_COM.do", params);
            	 	
            	 	var subOfcCds = ComGetEtcData(searchXml, "sub_ofc_cd");
            	 	clearSubOfcCombo();
            	 	
            	 	if (subOfcCds != undefined && subOfcCds != '') {
            	 		var arrSubOfcCd = subOfcCds.split("|");
            	 		for(var i=0; i < arrSubOfcCd.length; i++) {
            	 			var subOfcCd = arrSubOfcCd[i];
            	 			ComAddComboItem(formObj.f_sub_ofc_cd, subOfcCd, subOfcCd);
            	 		}
    				}
            	 	break;   		
    			case IBDOWNEXCEL:			
    				sheetObj.Down2Excel(-1,	false,	false,	true,	"",	"",	false,	false, "",	true);
    				break;
            }
        }
    
    		
        function validateForm(sheetObj,formObj,sAction){
        	var rtn = true;
            with(formObj){
            	if(formObj.gl_mon_from.value.substr(5,2) - formObj.gl_mon_to.value.substr(5,2) >0
            	   &&formObj.gl_mon_from.value.substr(0,4) == formObj.gl_mon_to.value.substr(0,4) )	
            	{
            		ComShowMessage(ComGetMsg("LEA90030","from_month","to_month"));
            		rtn = false;
            	}else if( formObj.f_cost_type_f.checked == false && formObj.f_cost_type_m.checked == false ) {
        			ComShowMessage(ComGetMsg("COM12113", "Check Box"));
        			rtn = false;
        		}
        		else if ( formObj.gl_mon_from.value =='' || formObj.gl_mon_to.value == '') {
        			ComShowMessage(ComGetMsg("LEA90001"));
        			ComSetFocus(formObj.gl_mon_from);
        			rtn = false;		
        		}else if(formObj.gl_mon_from.value.substr(0,4) != formObj.gl_mon_to.value.substr(0,4)){
        			ComShowMessage(ComGetMsg("LEA90031"));
        			rtn = false;
        		}
        		else {
        			rtn = true;
        		}
            }
            if (sAction == IBSEARCH){
            	if (formObj.f_rhq_cd.value ==""){
            		ComShowMessage(ComGetMsg("COM130403","RHQ"));
            		ComSetFocus(formObj.f_rhq_cd);
            		rtn = false;
            	}
            }
            return rtn;
        }
       
    	/**
    	* rhq, office조건 활성화/비활성화
    	*/
    	function changeReport(tp){
    		var formObj = document.form;
    		var sheetObj = sheetObjects[0];
    		var ofcType = formObj.ofc_type.value;
    		    sheetObj.RemoveAll();
    		
    	    if(tp == '1') {// //Office 비활성화, RHQ만 선택 가능
    	    	ComSetObjValue(formObj.f_ofc_cd, "");
    	    	ComSetObjValue(formObj.f_sub_ofc_cd, "");
    	    	
    	    	// 본사 ofc 이거나, 로그인 ofc 가 RHQ 이면
				if(ofcType == 'HT' || ofcType == 'HQ') {
					clearSubOfcCombo();
				} else {
					ComSetObjValue(formObj.f_sub_ofc_cd, "");
				}
            	
            	formObj.f_ofc_cd.display = "All";
            	formObj.f_ofc_cd.disabled = true;
            	formObj.f_sub_ofc_cd.disabled = true;
            	sheetObj.ColHidden("ctrl_ofc_cd")=true;
            	sheetObj.ColHidden("sub_ofc_cd")=true;
    	        
    	    } else if(tp == '2') {//RHQ 필수 선택(All 불가), Office 선택 가능
            	formObj.f_ofc_cd.disabled = false;
            	formObj.f_sub_ofc_cd.disabled = false;
            	sheetObj.ColHidden("ctrl_ofc_cd")=false;
            	sheetObj.ColHidden("sub_ofc_cd")=false;
            	
    	        changeRHQCd1(formObj.f_rhq_cd.value);
    	    }
    	}     
    	
        /**
         * Group combo 데이타를 재조회한다.
         */
        function changeRHQCd1(code){

			if (document.form.f_report.value == '1') {			
				document.form.f_ofc_cd.disabled = true;				
			}else {        	
				var formObj = document.form;
				var usrOfcCd = formObj.usr_ofc_cd.value;
				var ofcType = formObj.ofc_type.value; // 본사 OFC: 1, 0
				
				// 본사 ofc 이거나, 로그인 ofc 가 RHQ 이면
				if(ofcType == 'HT' || ofcType == 'HQ') {
					
				} else {
					code = usrOfcCd;
				}
            
				formObj.f_cmd.value = "";
				formObj.param1.value = "div_office"; // divId
				formObj.param2.value = "f_ofc_cd";  // cboNm
				formObj.param3.value = "";    // defaultValue
				formObj.param4.value = " style='width:80' class='input' onChange='changeCtrlOfc(this.value)' ";   // addProperties
				formObj.param5.value = "lgsOFC";     // workName
				formObj.param6.value = code; // param(userId)
				formObj.param7.value = "All";            // allYN
				formObj.param8.value = "";             // addOption
				formObj.target = "frmHidden";
				formObj.action = "ESD_LEA_COMBO.do";
				formObj.submit();
				
				if(ofcType == 'HT') { // 본사 OFC 이면
					clearSubOfcCombo();
				}
			}
        }
        
        
        /**
         * 로그인 Office가 'SELCOL' 인 경우에 한해, Logistics Office 선택시 그에 따른 Sub Office List 를 조회한다.
         */
        function changeCtrlOfc(ofcCd) {
        	var formObj = document.form;
        	
        	if(ofcCd == '') {
        		clearSubOfcCombo();
        	} else {
        		doActionIBSheet(sheetObjects[0], formObj, COMMAND03);
        	}
        }
    	
    	/**
         * Sub Office Combobox 를 초기화한다.
         */
        function clearSubOfcCombo() {
        	var formObj = document.form;
        	ComClearCombo(formObj.f_sub_ofc_cd);
	 		ComAddComboItem(formObj.f_sub_ofc_cd, "All", "");
        }
        

    	/*
    	 * Cost Type check 값을 Cookie에 Set 프로세스
    	*/
    	function lea_setCookieAcclType(){
//    		setCookie("form_lea_cost_type_m",(document.form.f_cost_type_m.checked == true ?"1":"0"));
//    		setCookie("form_lea_cost_type_f",(document.form.f_cost_type_f.checked == true ?"1":"0"));
    		document.form.f_cost_type_m.value = (document.form.f_cost_type_m.checked == true ?"1":"0");
    		document.form.f_cost_type_f.value = (document.form.f_cost_type_f.checked == true ?"1":"0");
    	}
    	
     
    	/**
         * 화면 로딩시 Date Setup
         */
        function dateSetup() {
            if(document.form.gl_mon_to.value.substr(5,2)== '01'){
           	 //document.form.gl_mon_from.value = ((document.form.gl_mon_to.value.substr(0,4)-1) + "-11");
           	 document.form.gl_mon_from.value = document.form.gl_mon_to.value;
            }else if(document.form.gl_mon_to.value.substr(5,2)== '02'){
           	 //document.form.gl_mon_from.value = ((document.form.gl_mon_to.value.substr(0,4)-1) + "-12");
           	document.form.gl_mon_from.value = (document.form.gl_mon_to.value.substr(0,4) + "-01");
            }else if(document.form.gl_mon_to.value.substr(5,2)== '12'){
           	 document.form.gl_mon_from.value = ((document.form.gl_mon_to.value.substr(0,4)) + "-10");
            }else
            {
           	 document.form.gl_mon_from.value = ((document.form.gl_mon_to.value.substr(0,4)) + "-0" + (document.form.gl_mon_to.value.substr(5,2)-2));
            }
        }
        
        function sheetControl(){
        	var sheetObject = sheetObjects[0];
        	if(document.form.f_vndr.checked ==false){
        		sheetObjects[0].ColHidden("vndr_seq")=true;
        		sheetObjects[0].ColHidden("vndr_lgl_eng_nm")=true;
        	}else if(document.form.f_vndr.checked==true){
        		sheetObjects[0].ColHidden("vndr_seq")=false;
        		sheetObjects[0].ColHidden("vndr_lgl_eng_nm")=false;
        	}
        }
        
        function statusLoad() {
        	var formObj = document.form;
        	var sheetObj = sheetObjects[0];
        	sheetObj.ColHidden("ctrl_ofc_cd") = true;
    	    sheetObj.ColHidden("sub_ofc_cd") = true;
    	    formObj.f_rhq_cd.value = formObj.acct_rhq_ofc_cd.value;
    	    
    	    var ofcType = formObj.ofc_type.value;
    	    
    	    if(ofcType == 'HT') { // 본사 OFC
        		formObj.f_rhq_cd.disabled = false;
        	} else {
        		formObj.f_rhq_cd.disabled = true;
        	}
    	    ComAddComboItem(formObj.f_ofc_cd, "All", "");
        	formObj.f_sub_ofc_cd.disabled = true;
        }

        
        function initControl() {
            var formObject = document.form;
            axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
            axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때
            axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
            axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//            ComBtnDisable("btn_Split");
        }
        
        
       function setLastyr() {
    	
    	    var formObj = document.form;

	    	var lstyear_from = parseInt(formObj.gl_mon_from.value.substr(0,4)) - 1 ;
	    	var lstyear_to = parseInt(formObj.gl_mon_to.value.substr(0,4)) - 1;
	    	
	    	var lst_from = lstyear_from +"-"+formObj.gl_mon_from.value.substr(5,2);
	    	var lst_to = lstyear_to +"-"+ formObj.gl_mon_to.value.substr(5,2);
	    	formObj.lstyr_from.value = lst_from;
	    	formObj.lstyr_to.value = lst_to;

       }

       function sheet1_OnSearchEnd(sheetObj,ErrMsg){
   		// 큰 분류부터 순서대로 해야 함.
  		    sheetObj.MessageText("SubSum") = "Total";
   			sheetObj.SubSumBackColor = sheetObj.RgbColor(178,220,255);
   			sheetObj.SumFontBold = true;
   			sheetObj.ShowSubSum("rhq_cd", "7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24|25", -1,false,false,"0","23=(|8|/|7|)*100;26=(|8|/|25|)*100"  );

		if (document.form.f_report.value == "2"){
       		sheetObj.MessageText("SubSum") = "Office";
   			sheetObj.SubSumBackColor = sheetObj.RgbColor(178,235,244);
   			sheetObj.SumFontBold = true;
   			//sheetObj.ShowSubSum("ctrl_ofc_cd", "7|8|9|10|12|13", -1,false,false,"1","11=(|8|/|7|)*100;14=(|8|/|13|)*100"  );
   			sheetObj.ShowSubSum("ctrl_ofc_cd", "7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24|25", -1,false,false,"1","23=(|8|/|7|)*100;26=(|8|/|25|)*100"  );
	    }
   		
   		sheetObj.MessageText("SubSum") = "SYS";
   		sheetObj.SubSumBackColor = sheetObj.RgbColor(250,244,192);
   		sheetObj.SumFontBold = true;
   		//sheetObj.ShowSubSum("cost_src_sys_cd", "7|8|9|10|12|13", -1, false,false,"2","11=(|8|/|7|)*100;14=(|8|/|13|)*100"  );
   		sheetObj.ShowSubSum("cost_src_sys_cd", "7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24|25", -1, false,false,"2","23=(|8|/|7|)*100;26=(|8|/|25|)*100"  );
  		
   		sheetObj.MessageText("SubSum") = "CostType";
   		sheetObj.SubSumBackColor = sheetObj.RgbColor(250,243,255);
   		sheetObj.SumFontBold = true;
   		//sheetObj.ShowSubSum("sub_cost_tp_nm", "7|8|9|10|12|13", -1,false,false,"4","11=(|8|/|7|)*100;14=(|8|/|13|)*100" );
   		sheetObj.ShowSubSum("sub_cost_tp_nm", "7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24|25", -1,false,false,"4","23=(|8|/|7|)*100;26=(|8|/|25|)*100" );
   		
   		    var mon_f = "";
   		    var mon_t = "";
   		    var tr_f = document.form.gl_mon_from.value.substring(5,6) ;
   		    var tr_t = document.form.gl_mon_to.value.substring(5,6) ;
   		    if (tr_f == "0"){
	   		    mon_f = parseInt(document.form.gl_mon_from.value.substring(6,7)) ;
   		    }else{
   		        mon_f = parseInt(document.form.gl_mon_from.value.substring(5,7)) ;
   		    } 

   		   if (tr_t == "0"){
	   		    mon_t = parseInt(document.form.gl_mon_to.value.substring(6,7)) ;
		    }else{
		        mon_t = parseInt(document.form.gl_mon_to.value.substring(5,7)) ;
		    }
	   		  sheetObj.ColHidden("mon1") = false ;  
	   		  sheetObj.ColHidden("mon2") = false ; 
		      sheetObj.ColHidden("mon3") = false ; 
		      sheetObj.ColHidden("mon4") = false ; 
		      sheetObj.ColHidden("mon5") = false ; 
		      sheetObj.ColHidden("mon6") = false ; 
		      sheetObj.ColHidden("mon7") = false ; 
		      sheetObj.ColHidden("mon8") = false ; 
		      sheetObj.ColHidden("mon9") = false ; 
		      sheetObj.ColHidden("mon10") = false ; 
		      sheetObj.ColHidden("mon11") = false ;
		      sheetObj.ColHidden("mon12") = false ;
		      
           for (var i=1; i < 13; i++ ){
        	   var coln = "mon"+i ;
        	   if ( i < mon_f || i > mon_t ){
             	      sheetObj.ColHidden(coln) = true ; 
        	   }
           }

       }
       
	/* 개발자 작업  끝 */