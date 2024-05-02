/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0028.js	 	
*@FileTitle : M&R Repair Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.30	
*@LastModifier : 조경완	
*@LastVersion : 1.0
* 2009.07.01 박명신  
* 1.0 Creation
* -----------------------------------------------------------------------------
* History
* 2011.05.12 김종옥 [CHM-201110509-01] ALPS MNR-Repair-> MNR Repair Inquiry 로직 변경 요청. W/O Type 추가
*            조회조건 W/O Type에 ALL 추가 및 C.OFC 멀티 입력 기능 추가
* 2012.10.30 조경완 [CHM-201220821-01] ALPS MNR-Repair-Repair Inquiry시에 조회 조건과 조회된 data간의 차이 건   
* 									 1.조회 조건(기간) 적용 오류 수정
* 									 2.by eq, by period 추가  
* 2014-03-25 Ticket : CHM-201429421 Title : (M&R) Repair Inquiry 기능 개선 요청 TD : Jonghee HAN, DEV : Jonghee HAN -> Popup UI 조건 변경 W/O Type : ALL, Status : ALL, Input Date : Menu Open 기준
* 2015-07002 박정민: CHM-201535636 : Split01-EAC Auto Audit - TRS 설계 및 개발 요청 
EAS MNR 자동심사에서 link되도록 수정
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
     * @class EES_MNR_0028 : EES_MNR_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */ 
    function EES_MNR_0028() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.obj_keyup              = obj_keyup;
    }
    
/* 개발자 작업	*/  	
// 공통전역변수   
var tabObjects = new Array(); 
var tabCnt = 0 ;  
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0; 

var msgFlag = "";

var tpmWoType = "";

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
				case "btn_calendar":          
					var cal = new ComCalendarFromTo();
					cal.select(formObject.fm_est_dt, formObject.to_est_dt, 'yyyy-MM-dd');
                	break; 	 
										
				case "btn_Print":
					if(sheetObjects[1].RowCount == 0){ 
						ComShowCodeMessage("MNR00310"); 			
					} else {
						//있다면  RD 호출
						if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != '' && sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq") != ''){
							var mnr_ord_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq");    
							var mnr_ord_ofc_cty_cd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd");
							var user_nm = formObject.user_nm.value;    
							var rdParam = '/rv mnr_ord_ofc_cty_cd['+ mnr_ord_ofc_cty_cd +'] mnr_ord_seq[' + mnr_ord_seq + '] user_nm[' + user_nm + ']';
							
							// W/O Type ALL 팝업 구분
							var vMnrWoTpCd= ComTrim(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "mnr_wo_tp_cd"));
							
							if(vMnrWoTpCd == 'SPL'){ 
								formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0183.mrd';
								formObject.com_mrdBodyTitle.value = "Simple Work Order";
							} else if(vMnrWoTpCd == "EXT"){
								formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0187.mrd';
								formObject.com_mrdBodyTitle.value = "Extra Work Order";
							} else if(vMnrWoTpCd == "RFS"){
								formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0231.mrd';
								formObject.com_mrdBodyTitle.value = "Reefer Spare Part Work Order";
							} else {  	
								formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd';
								formObject.com_mrdBodyTitle.value = "Repair Work Order";
							} 				
							formObject.com_mrdArguments.value =	rdParam;
							ComOpenRDPopup();
						} else { 			
							var eqno 	= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no");
							var seq 	= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_seq"); 
							var verNo 	= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_ver_no");
													  	  
							formObject.com_mrdPath.value = 'apps/alps/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0181.mrd';
							var rdParam = '/rv rqst_eq_no[' + eqno + '] rpr_rqst_seq[' + seq + '] rpr_rqst_ver_no[' + verNo + '] is_tpb[N]';
							formObject.com_mrdArguments.value =	rdParam;
							formObject.com_mrdBodyTitle.value = "Repair Estimate";
							ComOpenRDPopup();
						}					
					}			
					break;
										
				case "btn_New":  
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
					break;
							
				case "btn_DownExcel": 
					sheetObjects[1].SpeedDown2Excel(-1);	 
					break;		
						
				case "btn_Retrieve": 	
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					break;	
	
				case "btn_Detail":  
					if(sheetObjects[1].RowCount == 0){ 
						ComShowCodeMessage("MNR00309");			
					} else { 
					    // W/O Type ALL 팝업 구분
						var vMnrWoTpCd= ComTrim(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "mnr_wo_tp_cd"));
					
						//견적서 팝업 호출 
						//if(vMnrWoTpCd == 'EST'){
						if(vMnrWoTpCd == "" || vMnrWoTpCd == "EST"){ 
							if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no")) != ''){
								var rqstEqNo = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rqst_eq_no");    
								var rprRqstSeq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_seq");
								var rprRqstVerNo = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"rpr_rqst_ver_no");    
								var eqKndCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"eq_knd_cd"); 
								 	 									
								ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
							}    			
						} else {
							//work order 팝업호출    
							var mnrOrdOfcCtyCd= sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd");    
							var mnrOrdSeq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq");	
							var costOfcCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"cost_ofc_cd");	
							             		 			 	
							retArray = MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);      
							if(retArray == null){                   
								ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);       				
								return;       
							}  
			 				 	 	
							if(vMnrWoTpCd == 'SPL'){ 
								if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != ''
									&& MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq")) != ''){
									ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 670, '', '0,0', true);   
								}   
							} else if(vMnrWoTpCd == 'EXT'){ 
								if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != ''
									&& MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq")) != ''){
									ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 530, '', '0,0', true);   
								}    
							} else if(vMnrWoTpCd == 'RFS'){ 
								if(MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_ofc_cty_cd")) != ''
									&& MnrNullToBlank(sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"mnr_ord_seq")) != ''){
									ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq+'&cost_ofc_cd='+costOfcCd, 900, 500, '', '0,0', true);   
								}    
							}
						}  
					}	
					break;
					
				//멀티입력
				case "eq_no_multi1":  
					rep_Multiful_inquiry("rqst_eq_no"); 
					break;	
					
				//멀티입력
				case "eq_no_multi2": 
					if(formObject.wo_type.Code == "EST" || formObject.wo_type.Code == "ALL"){ 
						rep_Multiful_inquiry("rqst_ref_no"); 
					}      
					break; 	

				//멀티입력
				case "eq_no_multi3": 
				    rep_Multiful_inquiry("wo_no"); 
					break;	
				
				//멀티입력
				case "eq_no_multi4": 
				    rep_Multiful_inquiry("cost_ofc_cd"); 
					break;
				
				case "btn_vndr":      
					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
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
		MnrWaitControl(true);
		initControl();   
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        } 
		
		for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);   
	    }	   
		
		//**************** 조건별 초기 조건 작업 ***************/
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		 
		//추가 요청사항 콜 시스템별 서비스 			
		if(ComGetObjValue(formObj.from_sys) == "MST" || ComGetObjValue(formObj.from_sys) == "CGM" || ComGetObjValue(formObj.from_sys) == "EAS"){
			formObj.wo_type.Code = "ALL";
			formObj.status_cd.Code = "ALL";
//			formObj.wo_type.Code = "EST";
//			//MST만 CGM은 ALL  
//			if(ComGetObjValue(formObj.from_sys) == "MST"){
//				formObj.status_cd.Code = "WC";   		
//			}   
			ComSetObjValue(formObj.rqst_eq_no,formObj.eq_no.value);
			ComSetObjValue(formObj.wo_no,formObj.work_order_no.value);
			formObj.fm_est_dt.value = "2011-01-01";
			formObj.to_est_dt.value = ComGetNowInfo("ymd", "-");
			formObj.cost_ofc_cd.value = "";
//			formObj.fm_est_dt.value  = 	"";	         
//			formObj.to_est_dt.value  = 	""; 
			//한번 조회 해줌	    	            
			doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
		}
    }
	
	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
							
        switch(sheetObj.id) { 
			case "sheet1": 		
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}		 
					
            case "sheet2":      // sheet1 init
                with (sheetObj) {
                    // 높이 설정 
                    style.height = 380;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(34, 5, 0, true); 
													
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
	
                    var HeadTitle1 = "|Seq.|W/O Type|Service Provider|EQ No.|T/S|Est Date|Estimate No|Curr.|Est Amount|System Verify Result|DMG Flag|TPB|W/O No.|W/O Issue DT|W/O Send Method|W/O Send DT|Cost Type|W/O Amount|VVD|Yard|Invoice No|Invoice Amount|Status|C.OFC|Creation User|Remark(s)|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 
					InitDataProperty(0, cnt++,  dtHiddenStatus,	0,    	daCenter,  	false,  "ibflag"); 
					//InitDataProperty(0, cnt++ , dtCheckBox,	40,   	daCenter,	true,	"del_chk");		
					InitDataProperty(0, cnt++ , dtSeq,       	30,		daCenter,  	false,  "Seq",     				false,     "",    	dfNone     );
					InitDataProperty(0, cnt++ , dtData,   		100,	daLeft,  	false,	"mnr_wo_tp_nm", 		false,      "",     dfNone,    			0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			160,	daLeft,		false,	"vndr_nm",				false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daLeft,		false,	"rqst_eq_no",			false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"eq_tpsz_cd",			false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"est_dt",				false,		"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			114,	daLeft,		false,	"rqst_ref_no",			false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,	 		60,		daCenter,  	false,	"curr_cd",				false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daRight,	false,	"total_amt",			false,		"",		dfNullFloat,		2,	false,	false);
					InitDataProperty(0,	cnt++,	dtCombo,	 	140,	daLeft,    	false,	"mnr_vrfy_tp_cd",		false,		"",		dfNone,				0,	false,	false);	
					InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"dmg_flag",				false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"n3pty_flg",			false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daLeft,		false,	"wo_no",				false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			85,		daCenter,	false,	"iss_dt",				false,		"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0,	cnt++,	dtCombo,	 	120,	daLeft,    	false,	"trsm_mod_cd",			false,		"",		dfNone,				0,	false,	false);	
					InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	false,	"mnr_ord_snd_dt",		false,		"",		dfDateYmd,			0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			100,	daLeft,		false,	"cost_cd_nm",			false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			95,		daRight,	false,	"mnr_wrk_amt",			false,		"",		dfNullFloat,		2,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"vvd",					false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"spr_prt_spl_yd_cd",	false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			80,		daLeft,		false,	"inv_no",				false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			95,		daRight,	false,	"inv_amt",				false,		"",		dfNullFloat,		2,	false,	false);
					InitDataProperty(0,	cnt++,	dtCombo,	 	150,	daLeft,    	false,	"status",				false,		"",		dfNone,				0,	false,	false);	
					InitDataProperty(0,	cnt++,	dtData,			95,		daLeft,		false,	"cost_ofc_cd",			false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtData,			95,		daLeft,		false,	"cre_usr_id",			false,		"",		dfNone,				0,	false,	false);
					InitDataProperty(0,	cnt++,	dtCombo,	 	150,	daLeft,    	false,	"ord_hdr_rmk",			false,		"",		dfNone,				0,	false,	false);	
										
					//MNR_RPR_RQST_HDR	키값  rqst_eq_no	rpr_rqst_seq  rpr_rqst_ver_no	
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rpr_rqst_seq",    	false,      "",     dfNone,    			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "rpr_rqst_ver_no", 	false,      "",     dfNone,    			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "eq_knd_cd", 			false,      "",     dfNone,    			0,	true,	true);
					//W/O키값 
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_ord_ofc_cty_cd",	false,      "",     dfNone,    			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "mnr_ord_seq", 		false,      "",     dfNone,    			0,	true,	true);
					//추가 요청 
					InitDataProperty(0, cnt++ , dtHidden,   	0,		daCenter,  	false,   "cost_cd", 			false,      "",     dfNone,    			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,   	60,		daCenter,  	false,	 "mnr_wo_tp_cd", 		false,      "",     dfNone,    			0,	false,	false);
				}						
         		break;
        }		
    }
	
    // Sheet관련 프로세스 처리 
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {	
				
          case IBSEARCH:      //목록조회    
                 if(validateForm(sheetObj,formObj,sAction)){    
						formObj.f_cmd.value = SEARCH;  
						if(formObj.temp_tpb_only.checked){
							formObj.tpb_only.value = "Y"; 
						} else {
							formObj.tpb_only.value = "N";  
						} 
						
						var sParam = FormQueryString(formObj);
						//ComDebug(sParam);     			
         				sheetObj.DoSearch4Post("EES_MNR_0028GS.do",sParam); 
				  } 	        
                break; 		
			case IBSEARCH_ASYNC01:	//조회(sevice provider No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					if(Number(formObj.vndr_seq.value)){
						//서비스 프로바이더 조회     
						var sCondition = new Array (  
							new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
						)                             
						//조회 값이 있다면 세팅
						var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
						if(comboList[0] != null){  
							var tempText = comboList[0][0].split("|");  
							formObj.vndr_nm.value  = tempText[1];   
						} else {        
							ComShowCodeMessage("MNR00005", "Service Provider");              
							ComSetObjValue(formObj.vndr_nm, "");  
							ComSetObjValue(formObj.vndr_seq, ""); 
							ComSetFocus(formObj.vndr_seq);
						}  
					} else {        
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_nm, "");  
						ComSetObjValue(formObj.vndr_seq, ""); 
						ComSetFocus(formObj.vndr_seq);
					}  
				}	
				break;	      	 	
				 			
			case IBCLEAR:      // 초기화 
				MnrWaitControl(true);
				sheetObj.WaitImageVisible=false;
				//START 
				formObj.reset(); 
					
				//콤보 초기화	  
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].Code = "-1"; 
					comboObjects[i].RemoveAll();	 	       
				}	 
						
				var sCondition = new Array (		 		 
					//MultiCombo  
					new Array("MnrGenCd","CD00020", "COMMON"),
					new Array("MnrGenCd","","CUSTOM9"),
					//쉬트 콤보 
					new Array("MnrGenCd","CD00028", "COMMON"),	
					new Array("MnrGenCd","CD00004", "COMMON"),
					new Array("MnrGenCd","CD00016", "COMMON")   	    
				)				 			
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
										
				//*** W/O Type		
				var comboDefValue = "";
				//[CHM-201110509-01] W/O Type ALL 추가
				formObj.wo_type.InsertItem(0,"ALL","ALL");
				if(comboList[0] != null){ 	       
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						formObj.wo_type.InsertItem(j+1 , tempText[1] ,tempText[0]);
						if(j == 0){	 	
							comboDefValue = tempText[0];  
						}	  	 		 
					}     			  	    
				}  		
				formObj.wo_type.Code = "ALL"; //comboDefValue; 
						
				//*** EQ_TYPE	
				if(comboList[1] != null){	
					formObj.eq_knd_cd.InsertItem(0, 'ALL' ,'ALL');        
					for(var j = 1; j < comboList[1].length + 1;j++){ 
						var tempText = comboList[1][j - 1].split("|");	  
						formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}			    
				} 
						  	 
				var defEqType = formObj.default_eq_type.value;
				defEqType = MnrNullToBlank(defEqType);
				 
				if(defEqType != ""){
					formObj.eq_knd_cd.Code = defEqType;
				} else {
					formObj.eq_knd_cd.Code = 'ALL'; 
				}
												
				var sheetComboText = "";  
				var sheetComboCode = "";
				var sheetComboDefault = new Array();
										
				var comboSaveNames = new Array(); 
				comboSaveNames[0] = "status";
				comboSaveNames[1] = "mnr_vrfy_tp_cd"; 
				comboSaveNames[2] = "trsm_mod_cd";          
					      
				for(var i = 2; i < comboList.length;i++){
				 	if(comboList[i] != null){
							
						sheetComboText = ""; 
						sheetComboCode = "";	
						sheetComboDefault = ""; 
						   
				 		for(var j = 0; j < comboList[i].length;j++){ 
							var tempText = comboList[i][j].split("|");    
							 
							sheetComboText +=  tempText[1] + "|";  
							sheetComboCode +=  tempText[0] + "|";  
							if(j == 0){
								sheetComboDefault[i - 2] = tempText[0];           	
							} 		   
						}		
							
						sheetComboCode = 	MnrDelLastDelim(sheetComboCode); 																				
				     	sheetComboText = 	MnrDelLastDelim(sheetComboText);
				     	if(i == 2){ // SPP 및 Upper Office Request 관련 코드 추가
				     		sheetComboText += "Default(SPP Save)|Estimate Request (SPP)|Estimate Cancel(SPP)|Upper Office Request";
				     		sheetComboCode +=  "SS|SR|SC|HU";  
				     	}
						
						sheetObjects[1].InitDataCombo (0, comboSaveNames[i - 2], sheetComboText, sheetComboCode ,sheetComboDefault[i - 2]); 
					}				      
				}
					
				//2101-0405 자기 오피스를 기본으로 표시요청    
				formObj.cost_ofc_cd.value = selfOfcCd;    
				
				setEnableSwitch(ComGetObjValue(formObj.srch_type));
										     											
//				formObj.fm_est_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7);
//				formObj.to_est_dt.value = ComGetNowInfo("ymd");
												
				//END 
				sheetObj.WaitImageVisible = true; 
				MnrWaitControl(false);  
                break;
        }
    }

	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){	     
    	comboObjects[comboCnt++] = combo_obj;  
	} 
	
	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    var formObject = document.form
		 		    
	    switch(comboNo) {      
			   default :   
		           with (comboObj) { 
				       SetColAlign("left");	         
					   DropHeight = 200;	 	     
			       }    	   
	           break;	 	
	     } 		
	} 
		   
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
						
                }
             break;
         }	
    }
			
	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index 
	 */	
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;     
		if ( aryPopupData.length > 0 ) { 
			formObj.vndr_seq.value = ComLpad(aryPopupData[0][2],6,"0");   
			formObj.vndr_nm.value  = aryPopupData[0][4];
		}		
	}
				
	/** 
	 * rep_Multiful_inquiry의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) { 
 		var formObj = document.form; 	 
 		var tempText = "";       
 		//초기화     
		eval("document.form." + return_val + ".value = '';"); 
 
 		for(var i=0; i < rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//마지막에 ,를 없애기 위함      
		tempText = MnrDelLastDelim(tempText);		
 			     
 		eval("document.form." + return_val + ".value = '" + tempText + "';"); 
 	} 
	
	function sheet2_OnDblClick(sheetObj,Row,Col){
		var formObj = document.form;
		var vMnrWoTpCd= ComTrim(sheetObjects[1].CellValue(Row,"mnr_wo_tp_cd"));

		if(vMnrWoTpCd == "" || vMnrWoTpCd == "EST"){  
			if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"rqst_eq_no")) != ''){
				//있다면 팝업호출 
				var rqstEqNo = sheetObjects[1].CellValue(Row,"rqst_eq_no");    
				var rprRqstSeq = sheetObjects[1].CellValue(Row,"rpr_rqst_seq");
				var rprRqstVerNo = sheetObjects[1].CellValue(Row,"rpr_rqst_ver_no");    
				var eqKndCd = sheetObjects[1].CellValue(Row,"eq_knd_cd"); 
				ComOpenPopup('/hanjin/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);   		
			}  		 			
		} else { 
			//work order 팝업호출    
			var mnrOrdOfcCtyCd= sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd");    
			var mnrOrdSeq = sheetObjects[1].CellValue(Row,"mnr_ord_seq");	
			 		  
			retArray = MnrGeneralCodeCheck(sheetObjects[0],"WORKORD",mnrOrdOfcCtyCd + "," + mnrOrdSeq);
			 				 	  			
			if(retArray == null){                   
				ComShowCodeMessage("MNR00165","This Work Order : " + mnrOrdOfcCtyCd + mnrOrdSeq);       				
				return;       
			} 
		    	  	 	 
			if(vMnrWoTpCd == 'SPL'){ 
				if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0226.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 670, '', '0,0', true);   
				}    
			}else if(vMnrWoTpCd == 'EXT'){ 
				if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0227.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 530, '', '0,0', true);   
				}     
			}else if(vMnrWoTpCd == 'RFS'){ 
				if(MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_ofc_cty_cd")) != ''
					&& MnrNullToBlank(sheetObjects[1].CellValue(Row,"mnr_ord_seq")) != ''){
					ComOpenPopup('EES_MNR_0228.do?mnr_ord_ofc_cty_cd='+mnrOrdOfcCtyCd+'&mnr_ord_seq='+mnrOrdSeq, 900, 500, '', '0,0', true);   
				}    
			}
		}  	
	}
			
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") {  
			if(msgFlag == "Cancel"){
				ComShowCodeMessage("MNR00104"); 
			} else {
				ComShowCodeMessage("MNR00105");  
			}			
		} else {	
			/*		
			if(msgFlag == "Cancel"){
				ComShowCodeMessage("MNR00008",ErrMsg);
			} else {
				ComShowCodeMessage("MNR00027",ErrMsg);
			} 	
			*/    
		}  	 		      
	}
			
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */ 
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");
			
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";
			
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){ 	       
        	switch(sAction) { 	 
				case IBSEARCH: 
					if (!ComChkValid(formObj)) return false;
					
					//input date 30일 넘지 않게 2010-0405
					if(ComGetObjValue(formObj.srch_type) == "P"){
						var inputDateBet = ComGetDaysBetween(formObj.fm_est_dt.value, formObj.to_est_dt.value)
						if(inputDateBet > 30){  
							ComShowCodeMessage("MNR00335");   	   
							formObj.fm_est_dt.value = ComGetDateAdd(formObj.to_est_dt.value, "D", -30);
							return false;
						}
					}
					
					//추가 요청사항 멘덴토리 벨리데이션 
					//Input Date OR EQ No OR Est No OR  W/O No
					var chkEstDt = 0;
					var chkEqNo = 0;
					var chkWoNo = 0; 
					var chkRefNo = 0;
					
					if(ComGetObjValue(formObj.fm_est_dt) != "" && ComGetObjValue(formObj.to_est_dt) != ""){
						chkEstDt++;   
					} 
					if(ComGetObjValue(formObj.rqst_eq_no) != ""){
						chkEqNo++;   
					} 
					if(ComGetObjValue(formObj.wo_no) != ""){
						chkWoNo++;    
					} 
					if(ComGetObjValue(formObj.rqst_ref_no) != ""){
						chkRefNo++;    
					} 	
					
					if((chkEstDt + chkEqNo + chkWoNo + chkRefNo) == 0){
						ComShowCodeMessage("MNR00264"); 
						return false;   	
					}	   
					
					if(ComGetObjValue(formObj.srch_type) == "E"){
						if(ComGetObjValue(formObj.rqst_eq_no) == ""){
							ComShowCodeMessage("MNR00084");
							return false;
						}
					}
					
					var arrWoNo = formObj.wo_no.value.split(",");
					if(arrWoNo!=""){
						for(i=0;i<arrWoNo.length;i++){
							if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
								ComShowCodeMessage("MNR00010","W/O No");
								return false;
							}
						}
					}
		
				 	break; 					
			}   
		}
        return true;
    }
	
    /**
	* wo_type 값에 대한 status_cd 콤보의 재설정
	*/
	function resetStatusCdCombo(type,formObj){
		formObj.status_cd.removeAll(); 
		formObj.status_cd.DropHeight = 200;
		
		var sCondition = new Array (
			new Array("MnrGenCd","CD00028", "COMMON")
		)	
		
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
		  
		if(comboList[0] != null){ 	
			formObj.status_cd.InsertItem(0,"ALL","ALL");   
			if(type == "EST" || type == "ALL"){  
				for(var j = 0; j < comboList[0].length;j++){ 
					var tempText = comboList[0][j].split("|");   
					formObj.status_cd.InsertItem(j + 1, tempText[1] ,tempText[0]);
				}        			  	    
			} else {
				var tempCnt = 1;  
				for(var j = 0; j < comboList[0].length;j++){ 
					var tempText = comboList[0][j].split("|"); 
					if(tempText[0].substring(0,1) != 'H'){    
						formObj.status_cd.InsertItem(tempCnt, tempText[1] ,tempText[0]);
						tempCnt++;	
					}  		 
				}  	 	         			  	    
			}	
			formObj.status_cd.Code = "ALL";   
		}
	}		
					
	/**
	* wo_type 콤보 이벤트 
	*/				
	function wo_type_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        


		sheetObjects[1].RemoveAll(); 
		
		resetStatusCdCombo(comboObj.Code,formObj); 
		
		
		if(comboObj.Code == 'ALL'){
			sheetObjects[1].ReturnColumnPos();
			sheetObjects[1].ColHidden("rqst_eq_no") = false; 		
			sheetObjects[1].ColHidden("eq_tpsz_cd") = false; 		
			sheetObjects[1].ColHidden("est_dt") = false; 		
			sheetObjects[1].ColHidden("rqst_ref_no") = false; 		
			sheetObjects[1].ColHidden("curr_cd") = false; 		
			sheetObjects[1].ColHidden("total_amt") = false; 		
			sheetObjects[1].ColHidden("mnr_vrfy_tp_cd") = false; 		
			sheetObjects[1].ColHidden("dmg_flag") = false; 		
			sheetObjects[1].ColHidden("n3pty_flg") = false;
			 
			 //추가 요청사항 견적서는 다 감춤 
			MnrFormSetReadOnly(formObj,false,"rqst_ref_no");
				
			sheetObjects[1].ColHidden("mnr_wrk_amt") = false;
			sheetObjects[1].ColHidden("vvd") = false; 
			sheetObjects[1].ColHidden("spr_prt_spl_yd_cd") = false; 
			sheetObjects[1].ColHidden("cost_cd_nm") = false; 
			ComSetObjValue(formObj.rqst_ref_no,""); 
		} else if(comboObj.Code == 'EST'){ 
			sheetObjects[1].ReturnColumnPos();
			sheetObjects[1].ColHidden("rqst_eq_no") = false; 		
			sheetObjects[1].ColHidden("eq_tpsz_cd") = false; 		
			sheetObjects[1].ColHidden("est_dt") = false; 		
			sheetObjects[1].ColHidden("rqst_ref_no") = false; 		
			sheetObjects[1].ColHidden("curr_cd") = false; 		
			sheetObjects[1].ColHidden("total_amt") = false; 		
			sheetObjects[1].ColHidden("mnr_vrfy_tp_cd") = false; 		
			sheetObjects[1].ColHidden("dmg_flag") = false; 		
			sheetObjects[1].ColHidden("n3pty_flg") = false;
			 
			 //추가 요청사항 견적서는 다 감춤 
			sheetObjects[1].ColHidden("mnr_wrk_amt") = true;
			sheetObjects[1].ColHidden("vvd") = true; 
			sheetObjects[1].ColHidden("spr_prt_spl_yd_cd") = true; 
			sheetObjects[1].ColHidden("cost_cd_nm") = true;
			ComSetObjValue(formObj.rqst_ref_no,""); 
			MnrFormSetReadOnly(formObj,false,"rqst_ref_no");  
		} else {           
		
			sheetObjects[1].ColHidden("rqst_eq_no") = true; 		
			sheetObjects[1].ColHidden("eq_tpsz_cd") = true; 		
			sheetObjects[1].ColHidden("est_dt") = true; 		
			sheetObjects[1].ColHidden("rqst_ref_no") = true; 		
			//sheetObjects[1].ColHidden("curr_cd") = true; 		
			sheetObjects[1].ColHidden("total_amt") = true; 		
			sheetObjects[1].ColHidden("mnr_vrfy_tp_cd") = true; 		
			sheetObjects[1].ColHidden("dmg_flag") = true; 		
			sheetObjects[1].ColHidden("n3pty_flg") = true; 
				
			//추가 요청사항
			//Simple/Extra/reefer 일때만 mnr_wrk_amt
			sheetObjects[1].ColHidden("mnr_wrk_amt") = false;
			
			//리퍼일때만  vvd/yard
			if(comboObj.Code == 'RFS'){
				sheetObjects[1].ColHidden("vvd") = false; 
				sheetObjects[1].ColHidden("spr_prt_spl_yd_cd") = false; 
			} else { 	
				sheetObjects[1].ColHidden("vvd") = true; 
				sheetObjects[1].ColHidden("spr_prt_spl_yd_cd") = true; 
			}	 		
			 	
			//Simple/Extra일때만 cost_cd_nm
			if(comboObj.Code == 'SPL' || comboObj.Code == 'EXT'){
				sheetObjects[1].ColHidden("cost_cd_nm") = false; 
			} else {	
				sheetObjects[1].ColHidden("cost_cd_nm") = true;
			}
						
			ComSetObjValue(formObj.rqst_ref_no,""); 
			MnrFormSetReadOnly(formObj,true,"rqst_ref_no");   

			//wo_type변경시  Curr컬럼 이동
			if(tpmWoType == 'SPL' && comboObj.Code == 'EXT'){
			}else if(tpmWoType == 'EXT' && comboObj.Code == 'SPL'){
			}else{
				sheetObjects[1].MoveColumnPos("curr_cd", "cost_cd_nm");
			}
		}     
		tpmWoType = comboObj.Code;
	}    
	
	function obj_onclick(){
		var formObj = document.form;
		var obj	 = event.srcElement;
		if ( obj.name == "srch_type" ) {
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			setEnableSwitch(ComGetObjValue(obj));
		}
	}
	
	function setEnableSwitch(value) {
		var formObj = document.form;

		if ( value == "E" ) {
			formObj.fm_est_dt.value = "2011-01-01";
			formObj.to_est_dt.value = ComGetNowInfo("ymd");
			document.getElementById("rqst_eq_no").className = "input1";
			comboObjects[0].enable = false;
			comboObjects[1].enable = false;
			comboObjects[2].enable = false;
			//콤보 초기화	  
			for(var i = 0; i < comboObjects.length;i++){ 
				comboObjects[i].Index = 0; 	       
			}
		} else if ( value == "P" ) {
			formObj.fm_est_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7);
			formObj.to_est_dt.value = ComGetNowInfo("ymd");
			document.getElementById("rqst_eq_no").className = "input";
			comboObjects[0].enable = true;
			comboObjects[1].enable = true;
			comboObjects[2].enable = true;
		} 
	}
	
	function initControl() {        
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',		formObject); 			//- 변경될때.
		axon_event.addListenerForm ('click'	   , 'obj_onclick'   , 	formObject);
		axon_event.addListenerFormat('keyup',	 'obj_keyup',	formObject); //- 키 올라올때
	}             
		   	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
		
	function obj_change(){	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {       
	    		case "vndr_seq":  
					formObj.vndr_seq.value = ComLpad(formObj.vndr_seq.value,6,"0");  
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;	   
			}       
	    } else {
			switch(obj.name) {      
	    		case "vndr_seq":    
					ComSetObjValue(formObj.vndr_nm,"")
				   	break;   	
			}  		
		}
	}    
	        
	function obj_keypress(){   
	    obj = event.srcElement;     
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
					 	 		              
	    switch(obj.dataformat) {   
	        case "ymd":   
	        case "int":       
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "float":    
	            ComKeyOnlyNumber(obj, "-.");
	            break; 
	        case "eng":    
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup":  
				if(obj.name == "vndr_seq"){
					ComKeyOnlyAlphabet('uppernum');	
				} else {
					ComKeyOnlyAlphabet('uppernum','44'); 
				}
	            break; 
	    }         
	}
	
	/**
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "rqst_eq_no":
  				if(event.keyCode == '13'){
	  				doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
	  				break;
  				}
  		}
  	}
	/* 개발자 작업  끝 */