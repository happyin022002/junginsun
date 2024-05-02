/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0509.js
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.25 장석현
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
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
     * @class vop_vsk_0007 : vop_vsk_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0509() {
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
    
   	/* 개발자 작업	*/


// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var marrPrefix = new Array("t1sheet1_", "t2sheet1_", "t3sheet1_", "t4sheet1_");
var marrTabTitle = new Array("G/Crane", "F/Crane", "Gang Structure", "Berth Window");

//요일 Array{}
var marrWeekNm = new Array("sun", "mon", "tue", "wed", "thu", "fri", "sat");
var mQuestion = true;
var mClearData = true;
var mPreviousTab = 0;
var mCheckKey = true;
var mCheckValue = false;
var mEditRow = 0;
var arrGCraneCombo = new Array();
var arrSearchCond = new Array("", "", "");
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;



// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "ComOpenPopupWithTarget":
						ComOpenPopup("VOP_VSK_0043.do", 422, 520, "setPolCd", "0,0", true);
						break;

					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
						break;

					case "btn_New":
						clearFormNData();
						moveFocus(beforetab);
						break;
						
					case "VskOpenPopupPortGantryCraneHandlingInfoAttachFile":
						//alert(sheetObjects[0].CellValue(2, "t1sheet1_yd_cd"));
						var	tml_cd	= sheetObjects[0].CellValue(2, "t1sheet1_yd_cd");
						if(tml_cd == 'undefined' || tml_cd == '' || tml_cd == null ){
							ComShowCodeMessage("VSK00021", "G/Crane TMNL Code");
							return;
						}
						
						var sParam	= "port_cd="+tml_cd.substring(0,5)+"&editmode=readonly";
						////alert('sParam === ['+sParam+']');
						
						ComOpenPopup("VOP_VSK_2507.do?"+sParam, 740, 393, "", "0,0", true);
        				//ComOpenPopupWithTarget('VOP_VSK_2507.do?' + sParam, 740, 393, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
        				//alert('aft');
        				//var fileCount = ComOpenPopupWithTarget('/hanjin/VOP_OPF_9036.do?' + sParam, 740, 393, "vsl_cd:vsl_cd", "0,1,1,1,1,1,1", true);
						break;							
									
					case "btn_DownExcel":
						
						//alert(tabObjects[0].SelectedIndex);
						switch(tabObjects[0].SelectedIndex)
						{
							case 0:
								sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,"",false,"t1sheet1_del_chk|t1sheet1_upd_usr_id|t1sheet1_upd_dt","",false,false,"");
								break;
							case 1:
								sheetObject2.Down2Excel(-1, false, false, true, "", "", false, false, "",false, "t2sheet1_del_chk|t2sheet1_upd_usr_id|t2sheet1_upd_dt",	"", false, false, "") ;
								break;
							case 2:
								sheetObject3.Down2Excel(-1, false, false, true, "", "", false, false, "",false, "t3sheet1_del_chk|t3sheet1_upd_usr_id|t3sheet1_upd_dt",	"", false, false, "") ;		
								break;
							case 3:
								var deleteCol = "t4sheet1_del_chk|t4sheet1_loc_cd|t4sheet1_etb_dy_cd|t4sheet1_etb_tm_hrmnt|t4sheet1_etd_dy_cd|t4sheet1_etd_tm_hrmnt|t4sheet1_upd_usr_id|t4sheet1_upd_dt";
								
								//24시의 데이터를 지워주자....
								for(var cnt = sheetObject4.SaveNameCol("t4sheet1_etd_tm_" + marrWeekNm[0] + "_00"); 
										cnt <= sheetObject4.SaveNameCol("t4sheet1_etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_23"); cnt++){
									deleteCol += "|" + sheetObject4.ColSaveName(cnt);
								}
								sheetObject4.Down2Excel(-1, false, false, true, "", "", false, false, "",false, deleteCol,"", false, false, "") ;
								break;
						}	//end of inner switch
						
					
/*					case "btn_t1DownExcel1":
						//alert('btn_t1DownExcel1');
						sheetObject1.Down2Excel(1, false, false, true, "", "", false, false, "",
												false, "t1sheet1_del_chk|t1sheet1_upd_usr_id|t1sheet1_upd_dt", 
												"", false, false, "") ;
						break;

					case "btn_t2DownExcel1":

						sheetObject2.Down2Excel(1, false, false, true, "", "", false, false, "",
												false, "t2sheet1_del_chk|t2sheet1_upd_usr_id|t2sheet1_upd_dt", 
												"", false, false, "") ;
						break;
							
					case "btn_t3DownExcel1":

						sheetObject3.Down2Excel(1, false, false, true, "", "", false, false, "",
												false, "t3sheet1_del_chk|t3sheet1_upd_usr_id|t3sheet1_upd_dt", 
												"", false, false, "") ;
						break;
							
					case "btn_t4DownExcel1":
						var deleteCol = "t4sheet1_del_chk|t4sheet1_loc_cd|t4sheet1_etb_dy_cd|t4sheet1_etb_tm_hrmnt|t4sheet1_etd_dy_cd|t4sheet1_etd_tm_hrmnt|t4sheet1_upd_usr_id|t4sheet1_upd_dt";
						
						//24시의 데이터를 지워주자....
						for(var cnt = sheetObject4.SaveNameCol("t4sheet1_etd_tm_" + marrWeekNm[0] + "_00"); 
								cnt <= sheetObject4.SaveNameCol("t4sheet1_etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_23"); cnt++){
							deleteCol += "|" + sheetObject4.ColSaveName(cnt);
						}
						sheetObject4.Down2Excel(1, false, false, true, "", "", false, false, "",
												false, deleteCol, 
												"", false, false, "") ;
						break;*/

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
    * 초기 이벤트 등록 
    */
    function initControl() {
    	axon_event.addListener('change', 'gntr_rmk_onchange', 'gntr_rmk', '');		//Remark변경시에 처리되는 로직...
    	axon_event.addListener('change', 'fltg_rmk_onchange', 'fltg_rmk', '');		//Remark변경시에 처리되는 로직...
    	axon_event.addListener('keyup', 'loc_cd_onkeyup', 'loc_cd', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('keypress', 'loc_cd_onkeypress', 'loc_cd', '');			//Port Cd변경시에 처리되는 로직...
		axon_event.addListener('blur', 'loc_cd_onblur', 'loc_cd', '');			//Port Cd변경시에 처리되는 로직...
    	
		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',			'obj_activate',		form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',        'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
    }
    
    function dateFormat(n, digits) {
    	var zero = '';
    	n = n.toString();

    	if (n.length < digits) {
    		for (i = 0; i < digits - n.length; i++)
    	    zero += '0';
    	}
    	return zero + n;
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparator(event.srcElement);
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
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

		for(k=0; k < tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		/*for(i=0;i<sheetObjects.length;i++){
        	doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }*/
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}


		initControl();
		portCdInit();

		document.form.loc_cd.focus();
		document.t3sheet1.SetMergeCell(0, 2, 2, 1);
		document.t3sheet1.SetMergeCell(0, 7, 2, 1);
		
        //팝업여부와 초기 조회
        if(preConds.pop_yn == 'Y') {
       	 //초기 조건 셋팅
	         if(preConds.loc_cd != '') {	         	
	         	if(preConds.loc_cd != '') ComSetObjValue(document.form.loc_cd, preConds.loc_cd);
	         	//조회
	         	loc_cd_onkeyup();
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	         }
        }
		
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {

            case "t1sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 340;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|TMNL Code|TMNL Name|Max Weight with\nSpreader (Ton)|Max Weight without\nSpreader (Ton)|Clearance between\nLegs (M)|Reach\nRows|Tier|G/Crane Q’ty|G/Crane Q’ty|Remark|spcl-remark|file-knt|upd_usr_id|upd_usr_id";
					var HeadTitle2 = "|TMNL Code|TMNL Name|Max Weight with\nSpreader (Ton)|Max Weight without\nSpreader (Ton)|Clearance between\nLegs (M)|Reach\nRows|Tier|Total gang in TMNL|Max gang per Vessel|Remark|spcl-remark|file-knt|upd_usr_id|upd_usr_id";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t1sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtComboEdit,			100,	daCenter,	true,		prefix + "yd_cd",					false,		"",		dfNone,			0,		false,		true, 7);
					InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		true,		prefix + "yd_nm",					false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					120,	daRight,	true,		prefix + "grs_max_wgt",				false,		"",		dfFloat,		1,		true,		true, 12);
					InitDataProperty(0, cnt++ , dtData,					120,	daRight,	true,		prefix + "net_max_wgt",				false,		"",		dfFloat,		1,		true,		true, 12);
					InitDataProperty(0, cnt++ , dtData,					120,	daRight,	true,		prefix + "clr_btwn_leg_wdt",		false,		"",		dfFloat,		1,		true,		true, 12);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,	true,		prefix + "crn_rch_row_knt",			false,		"",		dfInteger,		0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		prefix + "cntr_tr_knt",				false,		"",		dfInteger,		0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,					150,	daRight,	true,		prefix + "ttl_gntr_crn_qty",		false,		"",		dfInteger,		0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtData,					100,	daRight,	true,		prefix + "vsl_gntr_crn_max_qty",	false,		"",		dfInteger,		0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "gntr_rmk",				false,		"",		dfNone,			0,		true,		true, 1000);
					
					InitDataProperty(0, cnt++ , dtHidden,				200,	daRight,	true,		prefix + "spcl_cgo_hndl_rmk",		false,		"",		dfNone,			0,		true,		true, 4000);
					InitDataProperty(0, cnt++ , dtHidden,				50,		daCenter,	true,		prefix + "atch_file_knt",			false,		"",		dfNone,			0,		true,		true, 5);
					
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_usr_id",				false,		"",		dfNone,			0,		true,		true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_dt",					false,		"",		dfNone,			0,		true,		true, 1000);
					//소주점이 길지 않을 시. 처리..
					//InitDataProperty(0, cnt++ , dtData,					120,	daRight,	true,		prefix + "grs_max_wgt",				true,		"",		dfNullFloat,	3,		true,		true, 12);
					//InitDataValid(0, prefix + "grs_max_wgt", vtNumericOther, ".");
					//InitDataCombo(0, "TMNLCode", "KRPUSGC| ", "KRPUSGC|");

					InitDataValid(0, prefix + "yd_cd", vtEngUpOther, "0123456789");
				}
				break;
            case "t2sheet1":
                with (sheetObj) {                                                                                                                                                                                                                 
										// 높이 설정                                                                                                                                                                                              
                    style.height = 340;                                                                                                                                                                                                           
                    //전체 너비 설정                                                                                                                                                                                                              
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]                                                                                                                                                                                 
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);                                                                                                                                       

                    //전체Merge 종류 [선택, Default msNone]                                                                                                                                                                                       
                    //MergeSheet = msHeaderOnly;                                                                                                                                                                                                           
					MergeSheet = msAll;

                   	//전체Edit 허용 여부 [선택, Default false]                                                                                                                                                                                    
                    Editable = false;                                                                                                                                                                                                              
                                                                                                                                                                                                                                                  
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]                                                                                                                                                                
                    InitRowInfo(1, 1, 3, 100);                                                                                                                                                                                                    
                                                                                                                                                                                                                                                  
					var HeadTitle1 = "|Port|Seq.|Handling Cargo Weight (Ton)|Handling Cargo Height (M)|Crane Reach (M)|Handling Cost|Remark(s)|upd_usr_id|upd_usr_id";                                                                              
					var headCount = ComCountHeadTitle(HeadTitle1);                                                                                                                                                            
                                                                                                                                                                                                                                                  
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]                                                                                                                                                          
                    InitColumnInfo(headCount, 0, 0, true);                                                                                                                                                                                        
                                                                                                                                                                                                                                                  
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다                                                                                                                                                                               
                    InitHeadMode(true, true, false, true, false,false)                                                                                                                                                                            
                                                                                                                                                                                                                                                  
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]                                                                                                                                                                 
                    InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                             
                                                                                                                                                                                                                                                  
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t2sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		prefix + "ibflag");                                                                                                                                 
					InitDataProperty(0, cnt++ , dtComboEdit,			80,		daCenter,	true,		prefix + "loc_cd",				false,		"",	dfNone,			0,	false,	true, 5);
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	false,		prefix + "crn_seq",				false,		"",	dfInteger,		1,	false,	false);
					InitDataProperty(0, cnt++ , dtData,					200,	daRight,	false,		prefix + "max_hndl_cgo_wgt",	false,		"",	dfFloat,		1,	true,	true, 13);
					InitDataProperty(0, cnt++ , dtData,					200,	daRight,	false,		prefix + "max_hndl_cgo_hgt",	false,		"",	dfFloat,		1,	true,	true, 12);
					InitDataProperty(0, cnt++ , dtData,					180,	daRight,	false,		prefix + "max_rch_len",			false,		"",	dfFloat,		1,	true,	true, 12);        
					InitDataProperty(0, cnt++ , dtData,					180,	daLeft,		false,		prefix + "hndl_cost_rmk",		false,		"",	dfNone,			0,	true,	true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				105,	daLeft,		false,		prefix + "fltg_rmk",			false,		"",	dfNone,			0,	true,	true, 1000);    
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_usr_id",			false,		"",		dfNone,			0,		true,		true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_dt",				false,		"",		dfNone,			0,		true,		true, 1000);

					InitDataValid(0, prefix + "loc_cd", vtEngUpOther, "0123456789");
				}
				break;

            case "t3sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msHeaderOnly;
					MergeSheet = msAll;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Port|Seq.|Gang Working Time|Gang Working Time|Break/Meal Time (Standard)|Break/Meal Time (Standard)|Remark(s)|upd_usr_id|upd_usr_id";
					var HeadTitle2 = "|Port|Seq.|From|To|From|To|Remark(s)|upd_usr_id|upd_usr_id";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t3sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		prefix + "ibflag");                                                                                                                                 
					InitDataProperty(0, cnt++ , dtComboEdit,			80,		daCenter,	true,		prefix + "loc_cd",				false,		"",	dfNone,			0,		false,		true, 5);
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	false,		prefix + "crn_seq",				false,		"",	dfInteger,		1,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					150,	daCenter,	false,		prefix + "gng_wrk_st_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					150,	daCenter,	false,		prefix + "gng_wrk_end_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					150,	daCenter,	false,		prefix + "gng_nwork_st_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					150,	daCenter,	false,		prefix + "gng_nwork_end_hrmnt",	false,		"",	dfTimeHm,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					180,	daLeft,		false,		prefix + "gng_rmk",				false,		"",	dfNone,			0,		true,		true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_usr_id",			false,		"",	dfNone,			0,		true,		true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_dt",				false,		"",	dfNone,			0,		true,		true, 1000);

					InitDataValid(0, prefix + "loc_cd", vtEngUpOther, "0123456789");
				}
				break;
            case "t4sheet1":
                with (sheetObj) {
					// 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|loc_cd|TMNL Code|TMNL Name|Lane Code|Bound|Carrier|etb_dy_cd|etb_tm_hrmnt|etd_dy_cd|etd_tm_hrmnt|upd_usr_id|upd_usr_id|brth_seq";
					
					//요일별로 시간 헤더세팅...
					/*
					for(var weekCnt = 0; weekCnt < marrWeekNm.length; weekCnt++){
						for(var hourCnt = 0; hourCnt < 24; hourCnt++){
							HeadTitle1 = HeadTitle1 + "|" + marrWeekNm[weekCnt].toUpperCase();
						}
					}
					*/


					//요일별로 오전/오후 헤더세팅...
					for(var weekCnt = 0; weekCnt < marrWeekNm.length; weekCnt++){
						HeadTitle1 = HeadTitle1 + "|" + marrWeekNm[weekCnt].toUpperCase();
						HeadTitle1 = HeadTitle1 + "|" + marrWeekNm[weekCnt].toUpperCase();
					}

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 11, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "t4sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,		false,		prefix + "loc_cd",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtComboEdit,			85,		daCenter,	false,		prefix + "yd_cd",		true,	"",	dfNone,			0,	false,	false, 7);
					InitDataProperty(0, cnt++ , dtData,					90,		daLeft,		false,		prefix + "yd_nm",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtPopupEdit,			80,		daLeft,		false,		prefix + "ref_slan_nm",	false,	"",	dfEngUpKey,		0,	true,	true, 20);
					InitDataProperty(0, cnt++ , dtCombo,				60,		daCenter,	false,		prefix + "skd_dir_cd",	false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtPopupEdit,			70,		daLeft,		false,		prefix + "crr_cd",		false,	"",	dfEngUpKey,		0,	true,	true, 4);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_usr_id",				false,		"",		dfNone,			0,		true,		true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "upd_dt",					false,		"",		dfNone,			0,		true,		true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				100,	daRight,	true,		prefix + "brth_seq",				false,		"",		dfNone,			0,		true,		true, 1000);
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,		false,		prefix + "etb_dy_cd",	false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,		false,		prefix + "etb_tm_hrmnt",false,	"",	dfUserFormat2,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,		false,		prefix + "etd_dy_cd",	false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtHidden,				0,		daLeft,		false,		prefix + "etd_tm_hrmnt",false,	"",	dfUserFormat2,	0,	true,	true);
/*
					InitDataProperty(0, cnt++ , dtData,					50,		daLeft,		false,		prefix + "etb_dy_cd",	false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,					50,		daLeft,		false,		prefix + "etb_tm_hrmnt",false,	"",	dfUserFormat2,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,					50,		daLeft,		false,		prefix + "etd_dy_cd",	false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,					50,		daLeft,		false,		prefix + "etd_tm_hrmnt",false,	"",	dfUserFormat2,	0,	true,	true);

					//요일별로 시간 칼럼세팅...
					for(weekCnt = 0; weekCnt < marrWeekNm.length; weekCnt++){
						for(hourCnt = 0; hourCnt < 24; hourCnt++){
							var col_nm = "";
							if(hourCnt < 10)
								col_nm = prefix + "etd_tm_" + marrWeekNm[weekCnt] + "_0" + hourCnt;
							else
								col_nm = prefix + "etd_tm_" + marrWeekNm[weekCnt] + "_" + hourCnt;

							InitDataProperty(0, cnt++ , dtData,			18,		daCenter,	false,		col_nm,					false,	"",	dfNone,	0,	false,	false, 2);
						}
					}
*/
					//요일별로 시간 헤더세팅...
					for(var weekCnt = 0; weekCnt < marrWeekNm.length; weekCnt++){
						InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		prefix + "etd_tm_" + marrWeekNm[weekCnt] + "_am",					false,	"",	dfNone,	0,	false,	false, 4);
						InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		prefix + "etd_tm_" + marrWeekNm[weekCnt] + "_pm",					false,	"",	dfNone,	0,	false,	false, 4);
					}

					InitUserFormat2(0, prefix + "etb_tm_hrmnt", "##:##", "-|:" );
					InitUserFormat2(0, prefix + "etd_tm_hrmnt", "##:##", "-|:" );
					
					sheetHeaderBackColor(sheetObj, 
										prefix  + "etd_tm_" + marrWeekNm[0] + "_am",  
										prefix  + "etd_tm_" + marrWeekNm[0] + "_pm",
										sheetObj.RgbColor(255, 125, 125)
										);

					sheetHeaderBackColor(sheetObj, 
										prefix  + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_am",  
										prefix  + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_pm",
										sheetObj.RgbColor(125, 125, 255)
										);
					ShowButtonImage = 2;
					SelectHighLight = false;

					InitDataValid(0, prefix + "yd_cd", vtEngUpOther, "0123456789");
				}
				
				break;

            case "sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 50;
                    //전체 너비 설정
                    SheetWidth = 50;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Value|Name";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					var prefix = "sheet1_";
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "val");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "name");
				}
				break;
        }
    }

	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "por_rhq":    //R/D Term-post
				var i=0;
				with(comboObj) {
					style.width = 90;
					DropHeight = 150;
					InsertItem(i++,  "ALL",		"%");
					InsertItem(i++,  "PHXRA",   "PHXRA");
					InsertItem(i++,  "HAMRU",   "HAMRU");
					InsertItem(i++,  "SHARC",   "SHARC");
					InsertItem(i++,  "SINRS",	"SINRS");
					InsertItem(i++,  "SELSC", "SELSC");
					InsertItem(i++,  "TYOSC", "TYOSC");					
					InsertItem(i++,  "VVOIA", 	"VVOIA");
					
					BackColor = "#CCFFFD";

					Code = "%";
				}
				break;
			case "flt_type":    //R/D Term-post
				var i=0;
				with(comboObj) {
					style.width = 230;
					DropHeight = 150;
					MaxSelect = 1;

					Code = "%";
				}
				break;
		}
	}
		// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
				sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:		//조회
					if(validateForm(sheetObj,formObj,sAction)){
						//조회 조건 변동되었고, 시트에 값이 변동 되었을때..
						if(arrSearchCond[0] != ""){
							var changeYn = false;

							if(arrSearchCond[0] != formObj.loc_cd.value)
								changeYn = true;

							if(arrSearchCond[1] != (enablePorRhq.style.display == "inline" ? document.form.por_rhq.Code : document.form.por_rhq_diable.value))
								changeYn = true;
							
							//변동되었을시에...
							if(changeYn){
								removeSheet();
							}
						}

						if ( sheetObj.id == "t1sheet1"){
							formObj.f_cmd.value = SEARCH01;
							var arr = new Array("t1sheet1_", "");

							var sXml = sheetObj.GetSearchXml("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.Redraw = true; 

/*
							var arrXml = sXml.split("|$$|");

							if(arrXml.length > 1){
								var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
								
								//콤보를 세팅...
								arrGCraneCombo = arrCombo;
								
								if(arrCombo != null){
									sheetObj.InitDataCombo(0, "t1sheet1_yd_cd", " |" + arrCombo[1], " |" + arrCombo[0]);
								}

								sheetObj.Redraw = false;    
								sheetObj.WaitImageVisible = false;	
								sheetObj.LoadSearchXml(arrXml[0]); 
								sheetObj.Redraw = true; 
							}
*/
						}else if ( sheetObj.id == "t2sheet1"){
							formObj.f_cmd.value = SEARCH02;
							var arr = new Array("t2sheet1_", "");
							var sXml = sheetObj.GetSearchXml("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
							var arrXml = sXml.split("|$$|");
							
							var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
							sheetObj.InitDataCombo(0, "t2sheet1_loc_cd", " |" + arrCombo[1],  " |" + arrCombo[0]);

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(arrXml[0]); 
							sheetObj.Redraw = true; 
						}else if ( sheetObj.id == "t3sheet1"){
							formObj.f_cmd.value = SEARCH03;
							var arr = new Array("t3sheet1_", "");
							var sXml = sheetObj.GetSearchXml("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
							var arrXml = sXml.split("|$$|");

							var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
							sheetObj.InitDataCombo(0, "t3sheet1_loc_cd", " |" + arrCombo[1],  " |" + arrCombo[0]);

							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchXml(arrXml[0]); 
							sheetObj.Redraw = true; 
						}else if ( sheetObj.id == "t4sheet1"){
							formObj.f_cmd.value = SEARCH04;
							var arr = new Array("t4sheet1_", "");

							var sXml = sheetObj.GetSearchXml("VOP_VSK_0507GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arr));
							//var arrXml = sXml.split("|$$|");

							//if(arrXml.length > 1){
								/*
								var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");

								if(arrCombo != null){
									sheetObj.InitDataCombo(0, "t4sheet1_yd_cd", " |" + arrCombo[1], " |" + arrCombo[0]);
								}
								*/

								sheetObj.Redraw = false;    
								sheetObj.WaitImageVisible = false;	
								sheetObj.LoadSearchXml(sXml); 
								sheetObj.Redraw = true; 
								
								//쉬트 색상칠하기..
								if(sheetObj.RowCount > 0){
									var prefix = "t4sheet1_";
									for(var cnt = 1; cnt <= sheetObj.RowCount; cnt++){
										//시작과 끝의 AM/PM
										var amPmS = parseInt(sheetObj.CellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2)) < 12 ? "am" : "pm";
										var amPmE = parseInt(sheetObj.CellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2)) < 12 ? "am" : "pm";
										var colName3 = prefix +  "etd_tm_" + sheetObj.CellValue(cnt, prefix + "etb_dy_cd").toLowerCase() + "_"  + amPmS;
										var colName4 = prefix +  "etd_tm_" + sheetObj.CellValue(cnt, prefix + "etd_dy_cd").toLowerCase() + "_"  + amPmE;

										//sheetSetBackColor(sheetObj, cnt, colName1, colName2);
										sheetSetBackColor(sheetObj, cnt, colName3, colName4);
										sheetSetForeColor(sheetObj, cnt, colName3, colName4);

										for(var col = sheetObj.SaveNameCol(prefix + "etd_tm_" + marrWeekNm[0] + "_am"); 
												col <= sheetObj.SaveNameCol(prefix + "etd_tm_" + marrWeekNm[marrWeekNm.length - 1] + "_pm"); col++){
											sheetObj.CellValue(cnt, col) = "    ";
										}
										
										if(colName3 == colName4){
											sheetObj.CellValue(cnt, colName3) = sheetObj.CellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2) + "/" + sheetObj.CellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2);
										}else{
											sheetObj.CellValue(cnt, colName3) = sheetObj.CellValue(cnt, prefix + "etb_tm_hrmnt").substring(0, 2);
											sheetObj.CellValue(cnt, colName4) = sheetObj.CellValue(cnt, prefix + "etd_tm_hrmnt").substring(0, 2);
										}

										sheetObj.RowStatus(cnt) = "R";
									}		//End For 색상 칠하기.
								}		//End if 데이터가 있으면.
							//}		//End if(전체 데이터가 정상이면.
						}		//End if 4번째 시트면..

						arrSearchCond[0] = formObj.loc_cd.value;
						arrSearchCond[1] = (enablePorRhq.style.display == "inline" ? document.form.por_rhq.Code : document.form.por_rhq_diable.value);
					}		//End if  Validate가 참이면.


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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++] = combo_obj;
	}

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
					for(; cnt < marrTabTitle.length; cnt++){
						InsertTab( cnt , marrTabTitle[cnt] , -1 );
					}

                }
             		break;

         }
    }


    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
		/*var statsCnt = sheetObjects[beforetab].RowCount("I") + sheetObjects[beforetab].RowCount("U") + sheetObjects[beforetab].RowCount("D");
		if(statsCnt > 0){
			if(ComShowCodeConfirm("VSK50009", marrTabTitle[beforetab])){
				mClearData = false;
				mQuestion = false;
				doActionIBSheet(sheetObjects[beforetab], document.form, IBSAVE);
			}else{
				mClearData = true;
			}
		}*/

        var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
		
		if(nItem == 0 || nItem == 3){
			document.all.item("disablePorRhq").style.display = "inline";
			document.all.item("enablePorRhq").style.display = "none";
			document.form.loc_cd.className = "input1";
		}else{
			document.all.item("disablePorRhq").style.display = "none";
			document.all.item("enablePorRhq").style.display = "inline";
			document.form.loc_cd.className = "input";
		}

		moveFocus(nItem);
	}
	
	/**
	 *	Sheet Event Start
	 */
	function t1sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.gntr_rmk.value = sheetObj.CellValue(Row, "t1sheet1_gntr_rmk");
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t1sheet1_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t1sheet1_upd_usr_id");
	}

	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			document.form.gntr_rmk.value = sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_gntr_rmk");
			document.form.spcl_cgo_hndl_rmk.value 	= sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_spcl_cgo_hndl_rmk");
			document.form.atch_file_knt.value 		= sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_atch_file_knt");			
			document.form.upd_dt_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_upd_dt");
			document.form.upd_id_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_upd_usr_id");
		}
	}

	function t2sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.fltg_rmk.value = sheetObj.CellValue(Row, "t2sheet1_fltg_rmk");
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t2sheet1_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t2sheet1_upd_usr_id");
	}

	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			document.form.fltg_rmk.value = sheetObj.CellValue(sheetObj.SelectRow, "t2sheet1_fltg_rmk");
			document.form.upd_dt_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t2sheet1_upd_dt");
			document.form.upd_id_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t2sheet1_upd_usr_id");
		}
	}

	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t3sheet1_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t3sheet1_upd_usr_id");
	}

	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			document.form.upd_dt_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_dt");
			document.form.upd_id_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_usr_id");
		}
	}

	function t4sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t4sheet1_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t4sheet1_upd_usr_id");
	}

	function t4sheet1_OnDblClick(sheetObj, Row, Col){
		if(Col > sheetObj.SaveNameCol("t4sheet1_upd_dt"))
			ComOpenPopupWithTarget('/hanjin/VOP_VSK_0703.do?enableForm=N', 500, 275, "loc_cd:loc_cd", "0,1,1,1,1,1,1", true);
	}

	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount > 0){
			document.form.upd_dt_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t4sheet1_upd_dt");
			document.form.upd_id_view.value = sheetObj.CellValue(sheetObj.SelectRow, "t4sheet1_upd_usr_id");
		}
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if(sheetObj.RowCount > 0){
			if(document.form.f_cmd.value == SEARCH05){
				if(beforetab == 1){
					sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "t2sheet1_crn_seq") = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_val");
					sheetObjects[1].SelectCell(sheetObjects[1].SelectRow, "t2sheet1_max_hndl_cgo_wgt", true);
				}else if(beforetab == 2){
					sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "t3sheet1_crn_seq") = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_val");
					sheetObjects[2].SelectCell(sheetObjects[2].SelectRow, "t3sheet1_gng_wrk_st_hrmnt", true);
				}
			}else if(document.form.f_cmd.value == SEARCH06){
				document.por_rhq.Code = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_val");
				document.form.por_rhq_diable.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_val");
			}
		}else{
			if(document.form.f_cmd.value == SEARCH06){
				/*ComShowCodeMessage('COM12114','Port');
				ComAlertFocus(document.form.loc_cd, "");*/
				
				//[2010.03.15] 김기용 차장 요청으로 Port초기화함.
				ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
				ComClearObject(formObj.loc_cd);
				ComClearObject(formObj.por_rhq_diable);
				document.por_rhq.Code = "%";				
				
				sheetObjects[0].InitDataCombo(0, "t1sheet1_yd_cd", "", "", "");
			}else if(document.form.f_cmd.value == SEARCH03){
				ComShowCodeMessage("VSK50028");
				sheetObjects[3].SelectCell(mEditRow, "t4sheet1_slan_cd", true);
			}else if(document.form.f_cmd.value == SEARCH04){
				ComShowCodeMessage("VSK50030");
				sheetObjects[3].SelectCell(mEditRow, "t4sheet1_crr_cd", true);
			}
		}
	}

	/**
	 *	Sheet Event End
	 */

	/**
	 * vsl_opr_tp_cd 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setLaneInfo(aryPopupData, Row, Col, sheetIdx){
		mCheckValue = false;
		sheetObjects[3].CellValue2(Row,Col) = aryPopupData[0][3];
	}
	
	/**
	 * vsl_opr_tp_cd 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setVslOprTpCd(aryPopupData, Row, Col, sheetIdx){
		mCheckValue = false;
		sheetObjects[3].CellValue2(Row,Col) = aryPopupData[0][3];
	}
	/**
	 *	Form Event Start
	 */
	function por_rhq_OnChange(){
		if(document.all.item("enablePorRhq").style.display == "inline" && !mCheckKey){
			document.form.loc_cd.value = "";
		}
	}

	function por_rhq_OnKeyDown(comboObj, KeyCode, Shift){
		if(KeyCode == 13){
			doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
		}

	}

	function loc_cd_onkeyup(){
		document.form.f_cmd.value = SEARCH06;
		if(document.form.loc_cd.value.length == 5){
			sheetObjects[4].DoSearch("VOP_VSK_0507GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_"));
		}
		mCheckKey = true;
	}
	function loc_cd_onblur(){
		mCheckKey = false;
	}
	

	function loc_cd_onkeypress(){
		ComKeyOnlyAlphabet('uppernum');
		if(document.form.loc_cd.value.length == 5 && event.keyCode == 13){
			doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
		}else if(document.form.loc_cd.value == "" && (beforetab == 1 || beforetab == 2) && event.keyCode == 13){
			doActionIBSheet(sheetObjects[beforetab], document.form, IBSEARCH);
		}
	}

	function portCdInit(){
		/*
		Form에 comboCd를 Hidden으로 추가하여. 해당 코드를 code1,code2,code3으로 추가하고..
		arr의 Array를 그 길이 만큼 추가하여 주시면. 됩니다.
		*/
		document.form.f_cmd.value = SEARCH01;
		var arr = new Array("", "");
		document.form.comboCd.value = "CD00593,CD02121";
		var sXml = sheetObjects[1].GetSearchXml("VOP_VSK_VOSIGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(arr));
		var arrXml = sXml.split("|$$|");

		if(arrXml.length > 1){
			arrCombo = ComXml2ComboString(arrXml[0], "val", "name");
			sheetObjects[3].InitDataCombo(0, "t4sheet1_skd_dir_cd", " |" + arrCombo[0],  " |" + arrCombo[1]);
		}
	}
	/**
	 *	Form Event End
	 */

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
				case IBSEARCH:
					if(beforetab == 0 || beforetab == 3){
						if(loc_cd.value == ''){
							ComShowCodeMessage('COM12114','Port');
							loc_cd.focus();
							
							return false;
						}	
					}

					if(beforetab == 1 || beforetab == 2){
						if(document.por_rhq.Code == ''){
							ComShowCodeMessage('COM12114','RHQ');
							ComAlertFocus(document.form.por_rhq, "");
							return false;
						}	
					}
				break;			
			}
		}

        return true;
    }

	function sheetSetBackColor(sheet, Row, Col, Col2){
		var startRow = sheet.SaveNameCol(Col);
		var endRow = sheet.SaveNameCol(Col2);

		var prefix = "t4sheet1_";
		if(startRow <= endRow){
			for(var cnt = startRow; cnt <= endRow; cnt++){
				sheet.CellBackColor(Row, cnt) = sheet.RgbColor(0, 128, 192);
			}
		}else{
			for(var cnt = startRow; cnt <= sheet.LastCol; cnt++){
				sheet.CellBackColor(Row, cnt) = sheet.RgbColor(0, 128, 192);
			}
			
			var newStart = parseInt(sheet.SaveNameCol(prefix + "etd_tm_hrmnt")) + 1;
			for(var cnt = newStart; cnt <= endRow; cnt++){
				sheet.CellBackColor(Row, cnt) = sheet.RgbColor(0, 128, 192);
			}
		}
	}

	function sheetSetForeColor(sheet, Row, Col, Col2){
		var startRow = sheet.SaveNameCol(Col);
		var endRow = sheet.SaveNameCol(Col2);

		sheet.CellFontColor(Row, startRow) = sheet.RgbColor(255, 255, 255);
		sheet.CellFontColor(Row, endRow) = sheet.RgbColor(255, 255, 255);
	}

	function sheetHeaderBackColor(sheet, Col, Col2, bgColor){
		var startCol = sheet.SaveNameCol(Col);
		var endCol = sheet.SaveNameCol(Col2);

		for(var cnt = startCol; cnt <= endCol; cnt++){
			sheet.CellBackColor(0, cnt) = bgColor;
		}
	}

	function duplCheck(sheetObj,Row, Col, Value, chkCol){
		var dupRow = sheetObj.ColValueDup(chkCol, true);
		//중복여부를 체크하되 공백인 셀은 제외
		
		if(sheetObj.id == "t1sheet1"){
			if(dupRow != -1 && sheetObj.CellValue(dupRow, chkCol) != '') {
				ComShowCodeMessage('VSK50016'); 
				sheetObj.CellValue(Row, Col) = "";
				return;
			}
		}else if(sheetObj.id == "t4sheet1"){
			if(dupRow != -1 && sheetObj.CellValue(dupRow, chkCol) != '') {
				ComShowCodeMessage('VSK50016');  
				var arrCheckCol = chkCol.split("|");
				
				for(var cnt = 0; cnt < arrCheckCol.length; cnt++){
					sheetObj.CellValue(Row, arrCheckCol[cnt]) = "";
				}

				return;
			}
		}
	}
	
	function clearFormNData(){
		var formObject = document.form;
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();

		with(formObject){
			loc_cd.value = "";
			por_rhq.Code = "%";
			por_rhq_diable.value = "";
			upd_dt_view.value = "";
			upd_id_view.value = "";
			gntr_rmk.value = "";
			fltg_rmk.value = "";
		}
	}
	
	function removeSheet(){
		var formObject = document.form

		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();

		with(formObject){
			upd_dt_view.value = "";
			upd_id_view.value = "";
			gntr_rmk.value = "";
			fltg_rmk.value = "";
		}
	}

	function moveFocus(nItem){
		switch(nItem){
			case 0:
				document.form.loc_cd.focus();
				break;
			case 1:
				ComAlertFocus(document.form.por_rhq, "");
				//document.form.por_rhq.Code = "%";
				break;
			case 2:
				ComAlertFocus(document.form.por_rhq, "");
				//document.form.por_rhq.Code = "%";
				break;
			case 3:
				document.form.loc_cd.focus();
				break;
		}
	}
	
	function yardCdCellComboInit(sheetObj, Row){
		with(sheetObj){
			var code = " |" + arrGCraneCombo[0];
			var val  = " |" + arrGCraneCombo[1];
			
			for(var cnt = HeaderRows; cnt <= RowCount; cnt++){
				if(cnt != Row && RowStatus(cnt) == "R"){
					//코드 없애기...
					code = ComReplaceStr(code, "|" + CellValue(cnt, "t1sheet1_yd_cd"), "");
					
					//텍스트 찾기..
					var sText = sheetObj.GetComboInfo(cnt, "t1sheet1_yd_cd", "Text");

					var arrText = sText.split("|");
					var idx = sheetObj.GetComboInfo(cnt, "t1sheet1_yd_cd", "SelectedIndex");
					//텍스트 없애기..
					val = ComReplaceStr(val, "|" + arrText[idx], "");
				}
			}

			CellComboItem(Row, "t1sheet1_yd_cd", val, code);
		}
	}
	function changeSheet(){
		var statsCnt = 0;
		var changeSheet = "";
		for(var cnt = 0; cnt < sheetObjects.length; cnt++){
			var changeSheetCnt = sheetObjects[cnt].RowCount("I") + sheetObjects[cnt].RowCount("U") + sheetObjects[cnt].RowCount("D");
			
			if(changeSheetCnt > 0){
				statsCnt += changeSheetCnt;
				changeSheet += changeSheet == "" ? marrTabTitle[cnt] : ", " + marrTabTitle[cnt];
			}
		}

		return statsCnt;
	}

    /**
	 * Pol Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
    function setPolCd(aryPopupData){
		document.form.loc_cd.value = aryPopupData[0][2];
		loc_cd_onkeyup();
    }

	/* 개발자 작업  끝 */