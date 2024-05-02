/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4108.jsp
*@FileTitle : DEM/DET E-mail Send(Fax/Email 송부시 송부대상을 선택하는 기능(pop-up))
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.19 김태균
* 1.0 Creation
* 2011.02.23 김태균 [CHM-201109036-01] [DMT] Manual Invoice 경우 Statement of Account와 Detail에 금액이 안 보이는 현상 개선
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
     * @class EES_DMT_4108 : EES_DMT_4108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4108() {
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
	
	// RD
	var rdObjects = new Array();
	var rdCnt = 0;

	var ROWMARK		= "|";
	var FIELDMARK	= "=";
	var IBEMAILSEND	= 51;

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
	    		case "btn_email":
	        		doActionIBSheet(sheetObject1,formObject,IBEMAILSEND);
					break;
	
                case "btn_close":
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
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	
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
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height =142;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    var HeadTitle = "|Seq.|ATTN|Fax|E-mail|Tel.|Sheet|Send|cust_cntc_pnt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    	[ROW,	COL,  	DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            		InitDataProperty(0,		cnt++,	dtHiddenStatus,	30,			daCenter,	false,		"ibflag");
            		InitDataProperty(0,		cnt++,	dtSeq,			30,			daCenter,	false,		"SEQ",					false,	"",		dfNone,				-1,			false,		false);
            		InitDataProperty(0,		cnt++,	dtData,			150,		daLeft,		false,		"payr_cntc_pnt_nm",		false,	"",		dfNone,				0,			false,		false);
            		InitDataProperty(0,		cnt++,	dtHidden,		150,		daLeft,		false,		"payr_cntc_pnt_fax_no",	false,	"",		dfNone,				0,			false,		false);
            		InitDataProperty(0,		cnt++,	dtData,			150,		daLeft,		false,		"payr_cntc_pnt_eml",	false,	"",		dfNone,				0,			false,		false);
            		InitDataProperty(0,		cnt++,	dtHidden,		150,		daLeft,		false,		"payr_cntc_pnt_phn_no",	false,	"",		dfNone,				0,			false,		false);
            		InitDataProperty(0,		cnt++,	dtRadioCheck,	50,			daCenter,	false,		"sheet",				false,	"",		dfNone,				0,			false,		false);
            		InitDataProperty(0,		cnt++,	dtCheckBox,		80,			daCenter,	false,		"send",					false,	"",		dfNone,				0,			true,		true);
					InitDataProperty(0, 	cnt++,	dtHidden,	  	40,			daCenter,	false,		"cust_cntc_pnt_seq");
					
					
					Ellipsis = true;
					
					CountPosition = 0;
                }
                break;
                
        }
    }
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					if (validateForm(sheetObj,formObj,sAction)) {
						sheetObj.DoSearch("EES_DMT_4104GS.do", FormQueryString(formObj));
						ComEtcDataToForm(formObj, sheetObj);
						
						//DEFALUT CHECK - SHEET, SEND(ATTN, TEL, FAX, E-MAIL
						
						var attn 	= ComGetObjValue(formObj.dmdt_payr_cntc_pnt_nm);
						var tel		= ComGetObjValue(formObj.dmdt_payr_phn_no);
						var fax		= ComGetObjValue(formObj.dmdt_payr_fax_no);
						var email	= ComGetObjValue(formObj.dmdt_payr_n1st_eml);
						
						// 앞화면에서 넘어온 값
						var p_attn 	= ComGetObjValue(formObj.s_attn);
						var p_tel	= ComGetObjValue(formObj.s_telno);
						var p_fax	= ComGetObjValue(formObj.s_faxno);
						var p_email	= ComGetObjValue(formObj.s_email);
						var p_cust_seq = ComGetObjValue(formObj.s_cust_seq);
						
						var checkOk = false;

						if(ComGetObjValue(formObj.jspno) == "4002" ||
						   ComGetObjValue(formObj.jspno) == "4003" || 
						   ComGetObjValue(formObj.jspno) == "4004" || 
						   ComGetObjValue(formObj.jspno) == "4016") 
						{
							for(var i = 1; i < sheetObj.TotalRows+1 ; i++) 
							{
								if(p_cust_seq == "")
								{
									sheetObj.CellValue2(1, "sheet") = 1;
									checkOk = true;
									break;
								}else{
									if(p_cust_seq == sheetObj.CellValue(i, "cust_cntc_pnt_seq"))
									{
										sheetObj.CellValue2(i, "sheet") = 1;
										checkOk = true;
										break;
									}
								}
							}
							if(!checkOk)	sheetObj.CellValue2(1, "sheet") = 1;
							
						}else{
							// 앞에서 넘어온 값으로 먼저 체크한다.
							for(var i = 1; i < sheetObj.TotalRows+1 ; i++) 
							{
								if(p_attn == sheetObj.CellValue(i, "payr_cntc_pnt_nm") 
										&& p_tel == sheetObj.CellValue(i, "payr_cntc_pnt_phn_no")
										&& p_fax == sheetObj.CellValue(i, "payr_cntc_pnt_fax_no")
										&& p_email == sheetObj.CellValue(i, "payr_cntc_pnt_eml")) 
								{
									
									sheetObj.CellValue2(i, "sheet") = 1;
									checkOk = true;
									break;
								}
							}
							
							// 앞에서 넘어온 값이 없으면 Payer Info 정보로 체크를 한다.
							if(!checkOk) 
							{
							
								for(var i = 1; i < sheetObj.TotalRows+1 ; i++) 
								{
									if(attn == sheetObj.CellValue(i, "payr_cntc_pnt_nm") 
											&& tel == sheetObj.CellValue(i, "payr_cntc_pnt_phn_no")
											&& fax == sheetObj.CellValue(i, "payr_cntc_pnt_fax_no")
											&& email == sheetObj.CellValue(i, "payr_cntc_pnt_eml")) 
									{
										sheetObj.CellValue2(i, "sheet") = 1;
										break;
									}
								}
							}
						}
						sheetObj.CheckAll2("send") = 1;
					}
						
				}
				break;
        	case IBEMAILSEND:
        		//email no가 존재하지 않으면
        		var payr_emails = "";
        		var sheetObj 	= sheetObjects[0];
        		var opener 		= window.dialogArguments;
        		var openerFormObj = "";
        		
        		switch(ComGetObjValue(formObj.jspno)) {
        			case "4002":
        			case "4003":
        			case "4004":
        			case "3108":
        			case "3109":
        			case "3007":
        			case "4011":
        			case "4012":
        			case "4018":
        				openerFormObj	= opener.document.form;
        				break;
        			case "4016":
        				openerFormObj	= opener.document.form2;
        				break;
        		}
        		
        		var send_cnt = 0;
        		var total_row = sheetObj.TotalRows;
        		
        		//선택한 값 중 중복 FAX_NO는 제외함.
        		for(var i = 1; i < total_row+1 ; i++) 
        		{
					if(sheetObj.CellValue(i, "send") == "1") 
					{
						send_cnt++;
						if(sheetObj.CellValue(i, "payr_cntc_pnt_eml") == "")	continue;
						
						var dup_check = 0;
						for(var j = i+1 ;  j < total_row+1 ; j++) 
						{
							if(sheetObj.CellValue(j, "send") == 1) 
							{
								if(sheetObj.CellValue(j, "payr_cntc_pnt_eml") == "")	continue;
								
								if(sheetObj.CellValue(i, "payr_cntc_pnt_eml") == sheetObj.CellValue(j, "payr_cntc_pnt_eml")){
									dup_check++;
								}
							}
						}
						
						if(dup_check == 0) 
						{
							payr_emails += sheetObj.CellValue(i, "payr_cntc_pnt_eml") +";";
						}
					}
				}

        		if(send_cnt == 0){
        			ComShowCodeMessage("DMT01150","E-mail");
        			return;
        		}
        			
        		if(payr_emails == "") {
        			ComShowCodeMessage("DMT01091");
        			return;
        		}
        		var rcvr_emails	= payr_emails;
        		
//        		var msg1		= "";
//        		
//        		//RCV
//        		var arr_emails 	= payr_emails.split(";");
//        		var re_emails	= "";
//        		for(var i=0; i< arr_emails.length; i++) {
//        			//rcvr_emails	+= ComGetObjValue(formObj.s_cust_cd)+";"+arr_emails[i];
//        			msg1		+= arr_emails[i] +"\n\t";
//        		}
//        		//확인 메시지
//        		if (!ComShowCodeConfirm("DMT01093", msg1))	return;
        		
        		ComSetObjValue(formObj.invno,					openerFormObj.invno.value);
    			ComSetObjValue(formObj.payc,					openerFormObj.payc.value);
        		ComSetObjValue(formObj.rd_fxeml_sys_cd,			openerFormObj.rd_fxeml_sys_cd.value);
    			ComSetObjValue(formObj.rd_fxeml_file_name,		openerFormObj.rd_fxeml_file_name.value);
    			ComSetObjValue(formObj.rd_fxeml_bat_flg,		openerFormObj.rd_fxeml_bat_flg.value);
    			ComSetObjValue(formObj.rd_fxeml_title,			openerFormObj.rd_fxeml_title.value);
    			ComSetObjValue(formObj.rd_fxeml_rd_param,		openerFormObj.rd_fxeml_rd_param.value);
    			ComSetObjValue(formObj.rd_fxeml_fax_no,			"");
    			ComSetObjValue(formObj.rd_fxeml_fax_sndr_id,	openerFormObj.rd_fxeml_fax_sndr_id.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_sndr_nm,	openerFormObj.rd_fxeml_eml_sndr_nm.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_rcvr_add,	rcvr_emails);
    			ComSetObjValue(formObj.rd_fxeml_eml_atch_file,	openerFormObj.rd_fxeml_eml_atch_file.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_templt,		openerFormObj.rd_fxeml_eml_templt.value);
    			ComSetObjValue(formObj.rd_fxeml_eml_tmplt_param,openerFormObj.rd_fxeml_eml_tmplt_param.value);
    			ComSetObjValue(formObj.rd_fxeml_doc_tp,			openerFormObj.rd_fxeml_doc_tp.value);
        		
                //ComOpenWait Start
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true);
                
                if(ComGetObjValue(formObj.jspno) == "4011" || ComGetObjValue(formObj.jspno) == "4012"){//OTS화면에서 첨부파일 체크 일 경우 팩스전송을 한번 더 호출한다.
                	if(ComGetObjValue(formObj.s_cust_seq) == "Y") {
                		ComSetObjValue(formObj.creof,			openerFormObj.creof.value);
                		ComSetObjValue(formObj.f_cmd, SEARCH07);
                	}else {
                		ComSetObjValue(formObj.f_cmd, SEARCH06);
                	}
        		}else{
        			ComSetObjValue(formObj.f_cmd, SEARCH06);
        		}
        		var sXml = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
    			
        		ComShowMessage(dmtGetMsgText(sXml));
                //ComOpenWait End
                ComOpenWait(false);
                
                window.close();
        		break;
			
        }
    }

	/*
	 * 초기화
	 */
	function initControl(){
		var formObj = document.form;
		var opener = window.dialogArguments;
		
		var attn = "";
		
		switch(ComGetObjValue(formObj.jspno)){
			case "4002":
			case "4004":
				attn = opener.document.form.org_dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4016":
				attn = opener.document.form2.org_dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4003":
			case "3108":
			case "3109":
			case "3007":
			case "4011":
				attn = opener.document.form.dmdt_payr_cntc_pnt_nm.value;
				break;
			case "4012":
				attn = opener.document.form.atn_val.value;
				break;
		}
		ComSetObjValue(formObj.s_attn, attn);
		
        //ofc_cd setting
        ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.s_ofc_cd));
        //Main 조회
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
        
        
	}


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
//
//    		switch(sAction) {
//    			case IBSAVE:
//    				//1. ATTN, TEL, FAX, EMAIL이 동일하면 저장시 에러 처리를 한다.
//    				for( var i = 1; i < sheetObj.RowCount + 1; i++) {
//    					var pnt_nm = sheetObj.CellValue(i, "payr_cntc_pnt_nm");
//    					var phn_no = sheetObj.CellValue(i, "payr_cntc_pnt_phn_no");
//    					var fax_no = sheetObj.CellValue(i, "payr_cntc_pnt_fax_no");
//    					var eml    = sheetObj.CellValue(i, "payr_cntc_pnt_eml");
//    					
//    					for( j = i+1 ; j < sheetObj.RowCount + 1 ; j++) {
//    						if(pnt_nm == sheetObj.CellValue(j, "payr_cntc_pnt_nm") 
//    								&& phn_no == sheetObj.CellValue(j, "payr_cntc_pnt_phn_no")
//    								&& fax_no == sheetObj.CellValue(j, "payr_cntc_pnt_fax_no")
//    								&& eml    == sheetObj.CellValue(j, "payr_cntc_pnt_eml")
//    									) {
//    							ComShowCodeMessage("DMT00188", j);
//    							return false;
//    						}
//    					}
//    				}
//    				//1. ATTN, TEL, FAX, EMAIL이 동일하면 저장시 에러 처리를 한다.
////    				var dupRow = sheetObj.ColValueDup("payr_cntc_pnt_nm|payr_cntc_pnt_phn_no|payr_cntc_pnt_fax_no|payr_cntc_pnt_eml", false);
////    				
////    				if(dupRow != -1 ) {
////    					ComShowCodeMessage("DMT00188", dupRow);
////    					return false;
////    				}
//    				
//    				//2. ADDR 자릿수 체크
//    				if(ComGetLenByByte(ComGetObjValue(formObj.dmdt_payr_addr)) > 100) {
//    					ComShowCodeMessage("COM131901", "Address");
//    					return false;
//    				}
//    				
//    				//3. ATTN, TEL, FAX, EMAIL 전부다 공백이면 해당ROW는 저장되지 않게 한다.
//    				for( var i = 1; i < sheetObj.RowCount + 1; i++) {
//    					if(sheetObj.CellValue(i, "payr_cntc_pnt_nm") == "" 
//    							&& sheetObj.CellValue(i, "payr_cntc_pnt_phn_no") == ""
//    							&& sheetObj.CellValue(i, "payr_cntc_pnt_fax_no") == ""
//    							&& sheetObj.CellValue(i, "payr_cntc_pnt_eml") == ""
//    							) {
//    						sheetObj.RowStatus(i) = "R";
//    					}
//    				}
//    				
//    				
//    				break;
//    		}
//        }		
//
        return true;
    }

	function dmtGetMsgText(xmlStr){
	
	    try {
	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
	        xmlDoc.loadXML(xmlStr);
	
	        var xmlRoot = xmlDoc.documentElement;
	        if(xmlRoot == null) return;
	
	        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
	        if(msgNode == null) 
	         return;
	        else
	         return msgNode.firstChild.nodeValue;
	   } catch(err) { ComFuncErrMsg(err.message); }
	   
	} 
