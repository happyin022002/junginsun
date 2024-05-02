/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0014.js
*@FileTitle : Expense Report by Office
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.22
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.22 전재홍
* 1.0 Creation
* @History
* 2009-03-27 전재홍 : Volume Incentive 및 Other Carrier 조회 옵션 조건 추가
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
* 2012.02.23 황효근 [CHM-201216046] [LEA] ALPS 결산 Result 및 Expense Report 화면 조정관련3
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
     * @class ESD_LEA_0014 : ESD_LEA_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0014() {
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
    	   	        sheetObject.RemoveAll();
    	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            break;
    	
    	   	    case "btng_downexcel":
    				//lea_form2sheet(formObject,sheetObject);
    				//조회조건도 Excel로 넘겨주기위해 각각의 Sheet로 넘김.
    				//sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
    				//sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
//    		        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	    	sheetObject. ExcelOption= "NOCOLOR";
        	    	sheetObject.SpeedDown2Excel(true);
        	    	sheetObject. ExcelOption= "";   
    	   	        break;
    	   	        
                case "btns_calendar1":
       	         	var cal = new ComCalendar();
       	         	cal.setDisplayType('month');
       	         	cal.select(formObject.frm_rev_yrmon_from, 'yyyy-MM');
       	         	break;

                case "btns_calendar2":
       	         	var cal = new ComCalendar();
       	         	cal.setDisplayType('month');
       	         	cal.select(formObject.frm_rev_yrmon_to, 'yyyy-MM');
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

            	//시작 환경 설정 함수 이름 변경
            	ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
                
                //마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            var sheetObject = sheetObjects[0];
            var formObj = document.form;
            
            sheetObject.RemoveAll();
            dateSetup();
            
            doActionIBSheet(sheetObject,formObj,COMMAND01); // Office별 권한 채크를 위해 생성
            doActionIBSheet(sheetObject,formObj,COMMAND02); // 로그인 Office별 Search Rhq Office
            
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
    					style.height = 325;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(18, 4, 0, true);

                       // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, false, false, true, false,false);
                        
                      //헤더 툴팁
                        var sTipVol = "The count of CNTRs uploaded/designated while invoices are processed";
                        var sTipEstCo = "Cost estimated at COA from the BKG creation stage";
                        var sTipActCo = "Actually invoiced amount of A/P interfaced CSR";
                        var sTipAcclCo = "To be invoiced amount in estimation";
                        var sTipCfnCo = "Finalized cost consisting of 'Actual Cost' plus 'Accrual Cost'";
                        var sTipCoDf = "Difference between 'Confirmed Cost' and 'Estimated Cost'";
                        
                        // 해더 타이틀

                        var HeadTitle  = "Rev.\n Month|RHQ|Parent\nOffice|Control\nOffice|Cost Type Ⅰ|Cost Type Ⅱ|Cost\n Code|Acct\n Code|1st\n Node|2nd\n Node|3rd\n Node|4th\n Node|Volume|Estimated\n Cost|Actual Cost\n (Invoice)|Accrual\n Cost|Confirmed\n Cost|Cost Diff" ;
                                            		
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, false, false);
                        InitHeadRow(1, HeadTitle, false, false);
                        
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData ,	70,		daCenter,	true ,	"rev_yrmon"			,	false,          "",       dfDateYm ,   		0,     false,	false);   
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,	true ,  "rhq_cd"          	,	false,          "",       dfNone ,   		0,     false,	false); 
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,	true ,	"ctrl_ofc_cd"		,	false,          "",       dfNone ,   		0,     false,	false); 
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,	true ,  "sub_ofc_cd"		,	false,          "",       dfNone ,   		0,     false,	false); 
    					InitDataProperty(0, cnt++ , dtData ,	90,    	daCenter,	true ,	"mn_cost_tp_nm"		,	false,          "",       dfNone ,   		0,     false,	false);                                               
    					InitDataProperty(0, cnt++ , dtData ,	250,   	daLeft,		true ,	"sub_cost_tp_nm"	,	false,          "",       dfNone ,   		0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"coa_cost_src_cd"	,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"acct_cd"			,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n1st_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n2nd_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n3rd_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtData ,	70,    	daCenter,   true ,	"n4th_nod_cd"		,	false,          "",       dfNone ,          0,     false,	false);
    					InitDataProperty(0, cnt++ , dtAutoSum ,	70,    	daRight ,  	true ,	"cntr_qty"			,	false,          "",       dfFloat ,			2,     false,	false,	-1	,	false	,	true			,	sTipVol); 
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"estm_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false,	-1	,	false	,	true			,	sTipEstCo);  
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"act_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false ,	-1	,	false	,	true			,	sTipActCo); 
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"adj_accl_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false,	-1	,	false	,	true			,	sTipAcclCo);                                              
    					InitDataProperty(0, cnt++ , dtAutoSum ,	90,    	daRight ,  	true ,	"cfm_cost_amt",	false,          "",       dfFloat ,			2,     false,	false,	-1	,	false	,	true			,	sTipCfnCo);           
    					InitDataProperty(0, cnt++ , dtAutoSum , 90,    	daRight ,  	true ,	"dif_cost_amt"		,	false,          "",       dfFloat ,			2,     false,	false,	-1	,	false	,	true			,	sTipCoDf); 

                        RangeBackColor(1, 6, 1, 8) = RgbColor(222, 251, 248);   // ENIS
                        ToolTipOption = "balloon:true; width:420; backcolor:#ffffff; forecolor:#14358B; icon:0;";
                        HeadRowHeight = 20 ;
                        HeadRowHeight = 21 ;
                      //  style.height = GetSheetHeight(13) ;
                    }
                    break;
            }
        }
        
        /* Sheet관련 프로세스 처리 */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {
            	case IBSEARCH:      //조회
            			if(validateForm(sheetObj,formObj,sAction)) {
	    			    	formObj.f_cmd.value = SEARCH;
	    			    	
	    			    	var ofcType = ComGetObjValue(formObj.ofc_type);
    			    		var usrOfccd = ComGetObjValue(formObj.usr_ofc_cd);
    			            
	    			    	if(ComGetObjValue(formObj.f_ctrl_ofc_cd) == '') { // Ctrl_Ofc 가 All
	    			    		if(ofcType == 'HT' || ofcType == 'HQ')
	    			    			formObj.bind_ofc_cd.value = ComGetObjValue(formObj.f_rhq_cd);
	    			    		else
	    			    			formObj.bind_ofc_cd.value = usrOfccd;
	    			    	}
	    			    	
//	    			    	var bindSubOfcCd = '';
//	    			    	if(ComGetObjValue(formObj.f_sub_ofc_cd) == '') { // Sub Office: All
//	    			    		if(ComGetObjValue(formObj.f_ctrl_ofc_cd) == '') {
//	    			    			if(ofcType == 'HT' || ofcType == 'HQ')
//	    			    				bindSubOfcCd = '';
//	    			    			else
//	    			    				bindSubOfcCd = usrOfccd;
//	    			    		} else {
//	    			    			bindSubOfcCd = ComGetObjValue(formObj.f_ctrl_ofc_cd);
//	    			    		}
//	    			    	}
//	    			    	ComSetObjValue(formObj.bind_sub_ofc_cd, bindSubOfcCd);
	    			    	
	    			    	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0014GS.do", leaFormQueryString(formObj));
	    				    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
            			}
    	                break;
    	                
                case COMMAND01: // Office_Type 조회
	             	   if(validateForm(sheetObj,formObj,sAction)){
	 				    	formObj.f_cmd.value = COMMAND01;
	 				    	
	 				    	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0014GS.do", leaFormQueryString(formObj));
	 				    	
	 				    	var ofcType = ComGetEtcData(searchXml, "OFC_TP_CD"); // HT, HQ, OTH
	 				    	formObj.ofc_type.value = ofcType;
	 						  
	 					    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
	             	   	}
	             	   	break;
             	   		
                case COMMAND02: // 로그인 Office에 대한 Rhq Office 조회 (미사용)
                	   if(validateForm(sheetObj,formObj,sAction)) {
                		  formObj.f_cmd.value = COMMAND02;
  						  
  						  var searchXml = sheetObj.GetSearchXml("ESD_LEA_0014GS.do", leaFormQueryString(formObj));
  						  
  						  var accRhqOfcCd = ComGetEtcData(searchXml, "Account_Rhq_Offiice");
  						  formObj.acct_rhq_ofc_cd.value = accRhqOfcCd;
  						  
  						  if(searchXml != "") sheetObj.LoadSearchXml(searchXml,false);
                	   }
              	   		break;
              	
                case COMMAND03:
                	var ctrlOfcCd;
//                	var ofcType = formObj.ofc_type.value;
//                	var usrOfcCd = formObj.usr_ofc_cd.value;
                	
                	// 본사 OFC가 아니고, 로그인 OFC가 RHQ_OFC 가 아니면
//                	if(ofcType != 'HT' && ofcType != 'HQ') 
//                		ctrlOfcCd = usrOfcCd;
//                	else
                		ctrlOfcCd = ComGetObjValue(formObj.f_ctrl_ofc_cd);
                	
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

    			case IBDOWNEXCEL:	// excel down		
    				//if(validateForm(sheetObj,formObj,sAction))
    				//mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge],  [SaveAsName],[ReportPageUrl],[HideExcelMsg],
    	            //     				[WriteTreeLevel], [WorkSheetName], [FocusFirstSheet]) 		
    				sheetObj.Down2Excel(-1,	false,	false,	true,	"",	"",	false,	false, "",	true);
    				break;
            }
        }

        
        /**
         * 조회 함수를 이용하여 조회가 완료되고 발생하는 이벤트
         */
    	function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    	{
    		sheetObj.ColHidden("rhq_cd") = false;
    		sheetObj.ColHidden("ctrl_ofc_cd") = false;
    	    sheetObj.ColHidden("sub_ofc_cd") = false;

    	    if( document.form.f_report.value == '1' ){
    	    	sheetObj.ColHidden("ctrl_ofc_cd") = true;
    		    sheetObj.ColHidden("sub_ofc_cd") = true;
    		    
    		    //sheetObj.ShowSubSum( "rhq_cd"   , "12|13|14|15|16|17", -1, true, false , 1 ,"rev_yrmon=%s;rhq_cd=%s;mn_cost_tp_nm=Sub Total");
     	    }
    	    
//    	    else  {
//    	    	sheetObj.ShowSubSum( "ctrl_ofc_cd"   , "13|14|15|16|17", -1 , true, false , 1 ,"rev_yrmon=%s;rhq_cd=%s;ctrl_ofc_cd=%s;sub_ofc_cd=Sub Total");
//    	    }
    	}
    		
    	
        function validateForm(sheetObj,formObj,sAction){
        	var rtn = true;
            with(formObj){
            	if((12*(formObj.frm_rev_yrmon_to.value.substr(0,4) - formObj.frm_rev_yrmon_from.value.substr(0,4))
                 		+ (formObj.frm_rev_yrmon_to.value.substr(5,2) - formObj.frm_rev_yrmon_from.value.substr(5,2))+1)>3)	
            	{
            		ComShowMessage(ComGetMsg("LEA90028","3"));
            		
            		rtn = false;
            	}else if( formObj.f_cost_type_f.value == "0" && formObj.f_cost_type_m.value == "0" &&
        				formObj.f_cost_type_c.value == "0" && formObj.f_cost_type_fv.value == "0" && formObj.f_cost_type_ev.value == "0") {
        			ComShowMessage(ComGetMsg("COM12113", "Check Box"));
        			ComSetFocus(formObj.f_cost_type_f);
        			rtn = false;
        		}else if ( formObj.frm_rev_yrmon_from.value =="" ) {
        			ComShowMessage(ComGetMsg("LEA90001"));
        			ComSetFocus(formObj.frm_rev_yrmon_from);
        			rtn = false;		
        		}else if((12*(formObj.frm_rev_yrmon_to.value.substr(0,4) - formObj.frm_rev_yrmon_from.value.substr(0,4))
                 		+ (formObj.frm_rev_yrmon_to.value.substr(5,2) - formObj.frm_rev_yrmon_from.value.substr(5,2))+1)>13)	
            	{
            		ComShowMessage(ComGetMsg("LEA90028","12"));
            		
            		rtn = false;
            	}else {
        			rtn = true;
        		}
            }
            return rtn;
        }

           		
    	/**
    	* rhq, office조건 활성화/비활성화
    	*/
    	function changeReport(tp) {
    		var sheetObj = sheetObjects[0];
    		var formObj = document.form;
    		var ofcType = formObj.ofc_type.value;
    		
    	    if(tp == '1') {	// //Office 비활성화, RHQ만 선택 가능
    	    	ComSetObjValue(formObj.f_ctrl_ofc_cd, "");
    	    	ComSetObjValue(formObj.f_sub_ofc_cd, "");
				
				// 본사 ofc 이거나, 로그인 ofc 가 RHQ 이면
				if(ofcType == 'HT' || ofcType == 'HQ') {
					clearSubOfcCombo();
				} else {
					ComSetObjValue(formObj.f_sub_ofc_cd, "");
				}
            	
            	formObj.f_ctrl_ofc_cd.disabled = true;
    	        formObj.f_sub_ofc_cd.disabled = true;
    	        sheetObj.ColHidden("ctrl_ofc_cd") = true;
        	    sheetObj.ColHidden("sub_ofc_cd") = true;
        	    
    	    } else if(tp == '2') {//RHQ 필수 선택(All 불가), Office 선택 가능
            	formObj.f_ctrl_ofc_cd.disabled = false;
            	formObj.f_sub_ofc_cd.disabled = false;
    	        sheetObj.ColHidden("ctrl_ofc_cd") = false;
        	    sheetObj.ColHidden("sub_ofc_cd") = false;
    	        
        	    changeRHQCd1(formObj.f_rhq_cd.value);
    	    }
    	}     

/*    	function changeRHQCd(rhqCd) {
    			if (document.form.f_report.value == '1') {			
    				document.form.f_ctrl_ofc_cd.disabled = true;				
    			}else {
    				var formObj = document.form;			
    				formObj.target = "frmHidden";
    				formObj.action = "apps/alps/esm/coa/common/jsp/ESM_COA_5150.jsp?code=" + rhqCd;
    				formObj.submit();
    			}
    	}	*/
    	
        /**
         * Group combo 데이타를 재조회한다.
         */
        function changeRHQCd1(code){
			if (document.form.f_report.value == '1') {			
				document.form.f_ctrl_ofc_cd.disabled = true;
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
				formObj.param2.value = "f_ctrl_ofc_cd";  // cboNm
				formObj.param3.value = "";    // defaultValue
				formObj.param4.value = " style='width:80' class='input' onChange='changeCtrlOfc(this.value)'";   // addProperties
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
    		document.form.f_cost_type_fv.value = (document.form.f_cost_type_fv.checked == true ?"1":"0");
    		document.form.f_cost_type_ev.value = (document.form.f_cost_type_ev.checked == true ?"1":"0");
    		document.form.f_cost_type_c.value = (document.form.f_cost_type_c.checked == true ?"1":"0");
    		document.form.f_cost_type_u.value = (document.form.f_cost_type_u.checked == true ?"1":"0");
    	}
    	
        function checkOption(arg){
        	  var formObj = document.form;
        	  
    		  if(arg == 'full' || arg == 'empty' || arg == 'chassis' || arg == 'fVol' || arg == 'eVol'){
    			  formObj.f_cost_type_u.checked = false;
    		  }else if(arg == 'un'){
    			  formObj.f_cost_type_f.checked = false;
    			  formObj.f_cost_type_m.checked = false;
    			  formObj.f_cost_type_c.checked = false;
    			  formObj.f_cost_type_fv.checked = false;
    			  formObj.f_cost_type_ev.checked = false;
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
        	
        	ComAddComboItem(formObj.f_ctrl_ofc_cd, "All", "");
        	formObj.f_sub_ofc_cd.disabled = true;
        }
        
        
    	/**
         * 화면 로딩시 Date Setup
         */
        function dateSetup() {
            if(document.form.frm_rev_yrmon_to.value.substr(5,2)== '01'){
           	 	document.form.frm_rev_yrmon_from.value = ((document.form.frm_rev_yrmon_to.value.substr(0,4)-1) + "-11");
            }else if(document.form.frm_rev_yrmon_to.value.substr(5,2)== '02'){
           	 	document.form.frm_rev_yrmon_from.value = ((document.form.frm_rev_yrmon_to.value.substr(0,4)-1) + "-12");
            }else if(document.form.frm_rev_yrmon_to.value.substr(5,2)== '12'){
           	 	document.form.frm_rev_yrmon_from.value = ((document.form.frm_rev_yrmon_to.value.substr(0,4)) + "-10");
            }else{
           	 	document.form.frm_rev_yrmon_from.value = ((document.form.frm_rev_yrmon_to.value.substr(0,4)) + "-0" + (document.form.frm_rev_yrmon_to.value.substr(5,2)-2));
            }
        }

	/* 개발자 작업  끝 */