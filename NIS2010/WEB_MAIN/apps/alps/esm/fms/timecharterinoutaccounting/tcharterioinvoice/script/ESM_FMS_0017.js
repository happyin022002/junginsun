/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0017.js
*@FileTitle : SDMS - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.11 정윤태
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
     * @class ESM_FMS_0017 : ESM_FMS_0017 Payments Slip 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_FMS_0017() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl        	= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
        this.eng_keypress			= eng_keypress;
        this.vsl_cd_change			= vsl_cd_change;
        this.obj_deactivate			= obj_deactivate;
        this.obj_activate			= obj_activate;
        this.obj_keypress			= obj_keypress;
        this.initConfirm			= initConfirm;
        this.formReset				= formReset;
        this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
        this.sheet1_OnClick			= sheet1_OnClick;
        this.setVvdCombo			= setVvdCombo;
        this.setVvdMakeCombo		= setVvdMakeCombo;
        this.sheet1_OnChange		= sheet1_OnChange;
        this.sheet1_OnValidation	= sheet1_OnValidation;
    }
    
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            	case "btn_save":
					alert("btn_save");
                    break;

				case "btn_confirm":
					var sRow = sheetObject.FindCheckedRow("DelChk");

		    		if (sRow == "") {
		    			ComShowCodeMessage('COM12189');
		    			return;
		    		}
		    		
		    		doActionIBSheet(sheetObject,formObject,IBSAVE);
		    		
                    break;

				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

				case "btn_new":
					if(!initConfirm()) return;
					
					formReset();
                    break;

				case "btn_close":
					window.close();
                    break;
                    
				case "from_dt_cal": 
					var cal = new ComCalendar();
					cal.select(form.from_pay_dt, 'yyyy-MM-dd');
					break;
				 
				case "to_dt_cal":
					var cal = new ComCalendar();
					cal.select(form.to_pay_dt, 'yyyy-MM-dd');	
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

        //khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //html컨트롤 이벤트초기화
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
            case 1:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정(180)
                    style.height = 300;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 3, 100);
 
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

					//var HeadTitle1 = "| |Vessel Code|VVD|VVD|VVD|Port|Damage\nType|Last Updated\nStatus|Currency|Amount|INV No.|SDMS Date|FMS\nApprovedn|Description|Report Upload";
					//var HeadTitle2 = "| |Vessel Code|VSL Code|Direction|Fin Dist|Port|Damage\nType|Last Updated\nStatus|Currency|Amount|INV No.|SDMS Date|FMS\nApprovedn|Description|Report Upload";
                    
                    var HeadTitle1 = "| |SDMS No.|VVD|VVD|VVD|Port|Damage\nType|Last Updated\nStatus|Currency|Amount|INV No.|SDMS Date|INV\nStatus|Description|Status Cd|SHP_OWNR_CO_NM|PAY_ACCT_NO|CRE_USR_ID|Org SDMS Date";
					var HeadTitle2 = "| |SDMS No.|VSL Code|Direction|Fin Dist|Port|Damage\nType|Last Updated\nStatus|Currency|Amount|INV No.|SDMS Date|INV\nStatus|Description|Status Cd|SHP_OWNR_CO_NM|PAY_ACCT_NO|CRE_USR_ID|Org SDMS Date";


                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  	true,   	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,      30,    daCenter,  	true,   	"DelChk");                    
                    InitDataProperty(0, cnt++ , dtData,      	 85,   	daCenter,  	true,    	"stv_dmg_no",     			false,          "",      dfNone,   		0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	 60,    daCenter,  	true,    	"vsl_cd", 					false,          "",      dfNone,      	0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	 60,    daCenter,  	false,   	"direction",	 			false,          "",      dfNone,   		0,     false,      true);

					InitDataProperty(0, cnt++ , dtData,       	 60,    daCenter,  	false,   	"rev_dir_cd",  				false,          "",      dfNone, 		0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 45,    daCenter,  	true,    	"vps_port_cd",     			false,          "",      dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,   	   	 60,    daCenter,  	true,   	"stv_dmg_prt_cate_cd",  	false,          "",      dfDateYmd, 	0,     false,      true);
					InitDataProperty(0, cnt++ , dtHidden,      	 90,    daCenter,  	true,    	"last_update_status",   	false,          "",      dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,   	   	 60,    daCenter,  	true,    	"pay_curr_cd",     			false,          "",      dfNone, 		0,     true,       true,	3);

					InitDataProperty(0, cnt++ , dtData,      	 80,    daRight,   	true,    	"pay_locl_amt",  			false,          "",      dfNullFloat,	2,     true,       true,	18);
					InitDataProperty(0, cnt++ , dtData,      	 110,   daLeft,  	true,    	"bil_inv_no",  				false,          "",      dfNone, 		0,     true,       true,	20);
					InitDataProperty(0, cnt++ , dtData,   	   	 70,    daCenter,  	true,   	"imsi_pay_dt",  			false,          "",      dfDateYmd, 	0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	 50,    daCenter,  	true,    	"inv_status",  			    false,          "",      dfNone, 		0,     false,      true);
					InitDataProperty(0, cnt++ , dtData,      	 310,   daLeft,	 	true,    	"stv_dmg_rmk",  			false,          "",      dfNone, 		0,     true,       true,	500);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,    daCenter,	true,    	"stv_dmg_stl_proc_sts_cd",  false,          "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,    daCenter,	true,    	"shp_ownr_co_nm",  			false,          "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,    daCenter,	true,    	"pay_acct_no",  			false,          "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,      	 30,    daCenter,	true,    	"cre_usr_id",  				false,          "",      dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	 70,    daCenter,  	true,   	"pay_dt",  					false,          "",      dfDateYmd, 	0,     false,      true);
					
					InitDataValid(0, "pay_curr_cd", vtEngUpOnly); 
               }
                break;
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,row,col) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

        	case IBSEARCH:      //조회

        		if(!validateForm(sheetObj,formObj,sAction))  return true;
        	
  				formObj.f_cmd.value = SEARCH;
  			
  				sheetObj.DoSearch("ESM_FMS_0017GS.do" , FormQueryString(formObj));

                break;

			 case IBSAVE:        //저장
			 
			    formObj.f_cmd.value = MULTI;
                 
			    var chkArrSheets = new Array(sheetObjects[0]);

			    var chkParam = sheetObj.GetSaveString(); 
				
				if (sheetObj.IsDataModified && chkParam == "") {
				    return; 
				}
				
				var prefix = "inv_";
				var prefix2 = "sdms_";
				
			 	for (var ir=1; ir<=sheetObj.LastRow; ir++){
					if(sheetObj.CellValue(ir,"DelChk") == 1) {
						sheetObj.RowStatus(ir)= "I";
						
						var row = opener.sheetObjects[0].DataInsert(-1);
						
						
						opener.sheetObjects[0].CellValue2(row,prefix+"curr_cd") = sheetObj.CellValue(ir,"pay_curr_cd");
						
						var currCd = sheetObj.CellValue(ir,"pay_curr_cd");
						ComFmsSetInitCellProperty(opener.sheetObjects[0], row, 6, "inv_amt", currCd, prefix, 2);
						
						opener.sheetObjects[0].CellValue2(row,prefix+"inv_amt") = sheetObj.CellValue(ir,"pay_locl_amt");
						opener.sheetObjects[0].CellValue2(row,prefix+"slp_tp_cd") = "N";
						opener.sheetObjects[0].CellValue2(row,prefix+"chtr_inv_dt") = sheetObj.CellValue(ir,"pay_dt");
						opener.sheetObjects[0].CellValue2(row,prefix+"to_inv_no") = sheetObj.CellValue(ir,"bil_inv_no");
						opener.sheetObjects[0].CellValue2(row,prefix+"bunker_vvd") = sheetObj.CellValue(ir,"vsl_cd")+sheetObj.CellValue(ir,"direction")+sheetObj.CellValue(ir,"rev_dir_cd");
						opener.sheetObjects[0].CellValue2(row,prefix+"inv_desc") = sheetObj.CellValue(ir,"stv_dmg_rmk");
						opener.sheetObjects[0].CellValue2(row,prefix+"sdms_no") = sheetObj.CellValue(ir,"stv_dmg_no");
						
						opener.sheetObjects[0].CellValue2(row,prefix+"flet_ctrt_no") = formObj.flet_ctrt_no.value;
						opener.sheetObjects[0].CellValue2(row,prefix+"inv_seq") = "1";
						opener.sheetObjects[0].CellValue2(row,prefix+"pop_gb") = "SDMS";
						
						opener.sheetObjects[0].CellEditable(row, prefix+"DelChk") = false;
						opener.sheetObjects[0].CellEditable(row, prefix+"curr_cd") = false;
						opener.sheetObjects[0].CellEditable(row, prefix+"inv_amt") = false;
						opener.sheetObjects[0].CellEditable(row, prefix+"chtr_inv_dt") = false;
						opener.sheetObjects[0].CellEditable(row, prefix+"to_inv_no") = false;
						opener.sheetObjects[0].InitCellProperty(row, prefix+"bunker_vvd", dtData); 
						opener.sheetObjects[0].CellEditable(row, prefix+"bunker_vvd") = false;
						opener.sheetObjects[0].CellEditable(row, prefix+"inv_desc") = true;
						
						// SDMS Grid Data 생성 부분
						
						var idx = opener.sheetObjects[1].DataInsert(-1);
						
						opener.sheetObjects[1].CellValue2(idx, prefix2+"stv_dmg_no") = sheetObj.CellValue(ir,"stv_dmg_no");
						opener.sheetObjects[1].CellValue2(idx, prefix2+"pay_curr_cd") = sheetObj.CellValue(ir,"pay_curr_cd");
						opener.sheetObjects[1].CellValue2(idx, prefix2+"pay_locl_amt") = sheetObj.CellValue(ir,"pay_locl_amt");
						opener.sheetObjects[1].CellValue2(idx, prefix2+"bil_inv_no") = sheetObj.CellValue(ir,"bil_inv_no");
						opener.sheetObjects[1].CellValue2(idx, prefix2+"pay_dt") = sheetObj.CellValue(ir,"pay_dt");
						opener.sheetObjects[1].CellValue2(idx, prefix2+"stv_dmg_rmk") = sheetObj.CellValue(ir,"stv_dmg_rmk");
						opener.sheetObjects[1].CellValue2(idx, prefix2+"stv_dmg_stl_proc_sts_cd") = "P";
						opener.sheetObjects[1].CellValue2(idx, prefix2+"shp_ownr_co_nm") = formObj.ownr_nm.value;
						opener.sheetObjects[1].CellValue2(idx, prefix2+"pay_acct_no") = formObj.cust_cnt_cd.value + formObj.cust_seq.value;
						opener.sheetObjects[1].CellValue2(idx, prefix2+"cre_usr_id") = formObj.usr_id.value;
						
						opener.inputReadOnly();
					} else {
						sheetObj.RowStatus(ir)= "R";
					}
				}
			 	
			 	var arrSheets = new Array(sheetObjects[0]);
			    var sParam = sheetObj.GetSaveString(); 
				
				if (sheetObj.IsDataModified && sParam == "") {
				    return; 
				}
        		
        		self.close();
        		
                break;

			case IBROWSEARCH:      // 조회
				
				if(col == "curr_cd") {
					formObj.f_cmd.value = SEARCH01;
	    		
	    			var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do" , FormQueryString(formObj));
	    		
	    			var currCd = ComGetEtcData(sXml, "currCd");
	   			
	    			if(typeof currCd == "undefined" || currCd == "") {
	    				ComShowMessage(ComGetMsg('FMS01142'));
	   				
						var currCdCol = sheetObj.SaveNameCol("pay_curr_cd");
						
						sheetObj.CellValue2(row,currCdCol) = "";
						sheetObj.SelectCell(row,currCdCol);
	    			} else {
	   					var currCd = sheetObj.CellValue(row, "pay_curr_cd");
	   					
	   					ComFmsSetInitCellProperty(sheetObj, row, 10, "pay_locl_amt", currCd, "", 2);
	   				}
	    			
				} else if(col == "inv_no") {
					formObj.f_cmd.value = SEARCH01;
		    		
	    			var sXml = sheetObj.GetSearchXml("ESM_FMS_0017GS.do" , FormQueryString(formObj));
	    		
	    			var invNo = ComGetEtcData(sXml, "invNo");
	   			
	    			if(typeof invNo != "undefined" && invNo != "") {
	    				ComShowMessage(ComGetMsg('FMS01181'));
	   				
						var invNoCol = sheetObj.SaveNameCol("bil_inv_no");
						
						sheetObj.CellValue2(row,invNoCol) = "";
						sheetObj.SelectCell(row,invNoCol);
	    			}
				} else {
					formObj.f_cmd.value = SEARCH02;
					
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do" , FormQueryString(formObj));
		
		   			var vvd = ComGetEtcData(sXml, "vvd");

		   			if(typeof vvd != "undefined" && vvd != "") {
		   				sheetObj.CellText(row, "rev_dir_cd") = "";
		   				
	    				var comboText = vvd;

	    				setVvdMakeCombo(sheetObj, comboText, row);
	    			} else {
	    				ComShowMessage(ComGetMsg('FMS01144'));
	    				sheetObj.SelectCell(row, "rev_dir_cd");
	    			}
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
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  , form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
    			
	    	case "bnk_yrmon":
	    		ComChkObjValid(event.srcElement);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }
     
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
    	//마스크구분자 없애기
    	ComClearSeparator(event.srcElement);
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
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
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function eng_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('upper');
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     **/
    function validateForm(sheetObj,formObj,sAction) {
        if(formObj.from_pay_dt.value != "") {
        	if(formObj.to_pay_dt.value == "") {
        		ComAlertFocus(formObj.to_pay_dt, ComGetMsg("FMS01150"));
        		return false;
        	}
        }
        
        if(formObj.to_pay_dt.value != "") {
        	if(formObj.from_pay_dt.value == "") {
        		ComAlertFocus(formObj.from_pay_dt, ComGetMsg("FMS01151"));
        		return false;
        	}
        }
        
        if(parseInt(formObj.from_pay_dt.value.trimAll('-')) > parseInt(formObj.to_pay_dt.value.trimAll('-'))) {
        	ComAlertFocus(formObj.to_pay_dt, ComGetMsg("FMS01177"));
    		return false;
        }
        
        return true;
    }


    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
    	var okYn = true;
     	
     	if(sheetObjects[0].isDataModified) {
     		var okYn = confirm(ComGetMsg('FMS00002'));
     	}
     	
     	return okYn;
    }
    
    /**
     * 화면을 초기화한다. <br>
     * @return 없음
     * @see #ComResetAll
     **/
	function formReset() {
		sheetObjects[0].removeAll();
		form.from_pay_dt.value = "";
		form.to_pay_dt.value = "";
		form.app_flg.selectedIndex = 0;
	}
	
	/**
     * DoSearch로 조회 완료후 발생하는 이벤트 <br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {String}  ErrMsg    	Error 메세지
     **/
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	for(var ir=1; ir<=sheetObj.LastRow; ir++){
    		if(ComFmsCheckCurrencyYn(sheetObj.CellValue(ir, "pay_curr_cd"))) {
				sheetObj.InitCellProperty(ir, 10, dtNull, daRight, "pay_locl_amt", "", dfNullInteger);
			}
    		
    		if(sheetObj.CellValue(ir,"inv_status") == "Yes") {
    			sheetObj.CellEditable(ir, "DelChk") = false;
    			sheetObj.CellEditable(ir, "rev_dir_cd") = false;
    			sheetObj.CellEditable(ir, "pay_curr_cd") = false;
    			sheetObj.CellEditable(ir, "pay_locl_amt") = false;
    			sheetObj.CellEditable(ir, "bil_inv_no") = false;
    			sheetObj.CellEditable(ir, "imsi_pay_dt") = false;
    			sheetObj.CellEditable(ir, "stv_dmg_rmk") = false;
    		}
    	}
    	
    	ComColFontName(sheetObj, "2"); 
    	ComColFontName(sheetObj, "3"); 
     	ComColFontName(sheetObj, "4"); 
     	ComColFontName(sheetObj, "5"); 
     	ComColFontName(sheetObj, "6"); 
 	}
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     **/
    function sheet1_OnClick(sheetObj, row, col) {
    	 
    	if(sheetObj.CellValue(row,"inv_status") == "Yes") return;
    		
    	if(sheetObj.ColSaveName(col)=="rev_dir_cd") {
    		//alert(sheetObj.CellEditable(row, "rev_dir_cd"));
    		//if(sheetObj.CellEditable(row, "rev_dir_cd") == false) return;
    		
    		var payDtCol = sheetObj.SaveNameCol("imsi_pay_dt");
    		var payDtValue = sheetObj.CellValue(row,payDtCol);
    		
    		if(payDtValue == "" || payDtValue.length < 8) {
    			ComShowMessage(ComGetMsg('FMS01182'));
    			sheetObj.SelectCell(row, "imsi_pay_dt", true, "");
    			sheetObj.ValidateFail = true;
    			
    			return;
    		}

    		var iType = sheetObj.ReadDataProperty(row, "rev_dir_cd", dpDataType);
    		
    		if(iType == 6) return;
    		
    		var direction = sheetObj.CellValue(row,"direction");
    			
    		form.direction.value = direction;
    		form.rev_yrmon.value = payDtValue.substring(0,6);
 
    		setVvdCombo(row);
    	}
    }
    
    /**
     * Vvd 정보를 가져온다 <br>
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVvdCombo(row) {
    	doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, row, "Vvd");
    }
    
    /**
     * Vvd Combo 박스를 만든다 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String}  comboText   Vvd 의 코드값
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     **/
    function setVvdMakeCombo(sheetObj, comboText, row) {
    	if(comboText != "" ) {
    		var vvdCode = comboText.substring(0,comboText.length-1);
    		var vvdText = vvdCode;
        	var comboList = vvdCode.split("|");
        	
        	var dfCode = comboList[0];
 
        	sheetObj.InitCellProperty(row, "rev_dir_cd", dtCombo); 
        	sheetObj.CellComboItem(row, "rev_dir_cd", vvdText, vvdCode);
        	
        	sheetObj.CellEditable(row, "rev_dir_cd")= true;
    	}
    }
    
    /**
     * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String} value    	sheetObj의 입력값
     **/
	function sheet1_OnChange(sheetObj,row,col,value) {
		if (sheetObj.ColSaveName(col)==("pay_curr_cd")) {
            var currCdCol = sheetObj.SaveNameCol("pay_curr_cd");
            var currCdValue = sheetObj.CellValue(row,currCdCol);
            
            if(currCdValue == "") return;
            
            if(currCdValue.length < 3) {
    			ComShowMessage(ComGetMsg('FMS01077'));
	    		sheetObj.CellValue2(row,currCdCol) = "";
				sheetObj.SelectCell(row,currCdCol);
				return;
    		}
    		
    		form.curr_cd.value = currCdValue;
    		
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, row, "curr_cd");
    		
    	} else if(sheetObj.ColSaveName(col)==("pay_locl_amt")) {
    		var payLoclAmtCol = sheetObj.SaveNameCol("pay_locl_amt");
			var payLoclAmtValue = sheetObj.CellValue(row,payLoclAmtCol);
			
			if(payLoclAmtValue <= 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
	    		sheetObj.CellValue2(row,payLoclAmtCol) = "";
				sheetObj.SelectCell(row,payLoclAmtCol);
				return;
			}
    	} else if (sheetObj.ColSaveName(col)==("bil_inv_no")) {
            var invNoCol = sheetObj.SaveNameCol("bil_inv_no");
            var invNoValue = sheetObj.CellValue(row,invNoCol);
            
            if(invNoValue == "") return;
    		
    		form.inv_no.value = invNoValue;
    		
    		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, row, "inv_no");
    		
    	} else if(sheetObj.ColSaveName(col)=="imsi_pay_dt") {
			sheetObj.CellValue(row,"rev_dir_cd") = "";
			sheetObj.CellEditable(row, "rev_dir_cd")= false;
			sheetObj.InitCellProperty(row, "rev_dir_cd", dtData); 
		}
	}
     
    /**
     * 저장함수에서 저장직전에 Vlidation을 체크하기 위해 호출되는 이벤트 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	sheetObj의 선택된 Row
     * @param {ibsheet} col     	sheetObj의 선택된 Col
     * @param {String}  value    	sheetObj의 입력값
     **/
	function sheet1_OnValidation(sheetObj,row,col,value) {
		
		if(sheetObj.CellValue(row,"DelChk") == 1) {

			if(sheetObj.CellValue(row,"rev_dir_cd") == "") {
				ComShowMessage(ComGetMsg('FMS01178'));
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(row,"rev_dir_cd");
				return false;
			}

			if(sheetObj.CellValue(row,"pay_curr_cd") == "") {
				ComShowMessage(ComGetMsg('FMS01077'));
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(row,"pay_curr_cd");
				return false;
			}
			
			if(sheetObj.CellValue(row,"pay_locl_amt") == "") {
				ComShowMessage(ComGetMsg('FMS01179'));
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(row,"pay_locl_amt");
				return false;
			}
			
			var payLoclAmtCol = sheetObj.SaveNameCol("pay_locl_amt");
			var payLoclAmtValue = sheetObj.CellValue(row,payLoclAmtCol);
			
			if(payLoclAmtValue <= 0) {
				ComShowMessage(ComGetMsg('FMS01163'));
	    		sheetObj.CellValue2(row,payLoclAmtCol) = "";
				sheetObj.SelectCell(row,payLoclAmtCol);
				return;
			}
			
			if(sheetObj.CellValue(row,"bil_inv_no") == "") {
				ComShowMessage(ComGetMsg('FMS01180'));
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(row,"bil_inv_no");
				return false;
			}
			
			if(sheetObj.CellValue(row,"stv_dmg_rmk") == "") {
				ComShowMessage(ComGetMsg('FMS01444'));
				sheetObj.ValidateFail = true;
				sheetObj.SelectCell(row,"stv_dmg_rmk");
				return false;
			}
		}
	}