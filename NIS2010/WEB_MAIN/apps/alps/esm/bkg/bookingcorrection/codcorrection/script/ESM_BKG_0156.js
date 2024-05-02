/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0156.js
*@FileTitle : COD Application at BKG Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.27 최영희
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.11.12 조정민 [CHM-201220900] [BKG] [COD Application] Approval RSO 자동지정 (Re-handling port 대륙으로 일치)
* 2012.11.14 조정민 [CHM-201220900] [CHM-201221045] COD Application시 AK, BB 제외로직에 D7 컨테이너 허용 요청
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
     * @class ESM_BKG_0156 : ESM_BKG_0156 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0156() {
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
var comboObjects = new Array();
var comboCnt = 0;

var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var prefix4="sheet4_";
var prefix5="sheet5_";
var prefix6="sheet6_";
var prefix7="sheet7_";
var prefix9="sheet9_";
var iTop=0;
var ifTop=0;
var arrCodRqstSeq = null;
var arrRqstRsnXml = null;

//POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크하는 변수
var do_hld_flg = null; 
var cr_chk_flg = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
 
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject  = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
		 var sheetObject2 = sheetObjects[2];
		 var sheetObject3 = sheetObjects[3];
		 var sheetObject4 = sheetObjects[4];		 
         /*******************************************************/
         var formObj = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");
            

            switch(srcName) { 
				case "btn_remark":
					document.getElementById('codRemarkView').style.left =200; 
					if(iTop==0){
						document.getElementById('codRemarkView').style.top =AnchorPosition_getPageOffsetTop(document.getElementById('codRemarkView'))+10;
					}
					document.getElementById('codRemarkView').style.visibility="visible";
					document.getElementById('codRemarkView').style.overflow="visible";
					document.getElementById('codRemarkView').width=400;
	                document.getElementById('codRemarkView').height=260;
					document.frames("codRemarkIfrm").document.forms[0].diff_rmk.value=ComGetObjValue(formObj.codRemark); 
					iTop++;
				break; 
	   
				case "btn_pc":
					var sRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
					if (sRow.length<1){
						ComShowCodeMessage("BKG00239");
						return false;
					}
					doActionIBSheet(sheetObjects[8],document.form,COMMAND08);
					if (formObj.pctl_no.value==null||formObj.pctl_no.value==""||formObj.pctl_no.value.length<20){
						ComShowCodeMessage("BKG00309");
						return false;
					} else {
						if(formObj.cod_mnl_flg.value!="Y"){
							ComShowCodeMessage("BKG02046");
						}
					}
				break;
	  
				case "btn_calculation":
					if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
						 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
						ComShowCodeMessage("BKG00048");
						return false;
					}
					  
					if (ComChkLen(ComGetObjValue(formObj.cod_rhnd_port_cd),7)!=2){
						ComShowCodeMessage("BKG00740");
						return false;
					}
					
					doActionIBSheet(sheetObjects[2],document.form,COMMAND05);						
				break;
				
				case "btn_Inquiry":
					var sUrl = "/hanjin/VOP_OPF_0207.do?isPop=R";
					ComOpenPopup(sUrl, 500, 260, "", "0,0", true);
				break;
	  
				case "btn_history":
					if(ComIsEmpty(formObj.bkg_no)||ComIsEmpty(formObj.cod_rqst_seq)){
						return;
				    }
					var param="?bkg_no="+ComGetObjValue(formObj.bkg_no);
				    	param+="&cod_rqst_seq="+ComGetObjValue(formObj.cod_rqst_seq);
						param+="&pgmNo=ESM_BKG_0981";
					ComOpenPopup("/hanjin/ESM_BKG_0981.do"+param, 800, 280, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
				break;
	  
				case "btn_reject":
					document.getElementById('codRemarkView1').style.left =650; 
					if(ifTop==0){
						document.getElementById('codRemarkView1').style.top =AnchorPosition_getPageOffsetTop(document.getElementById('codRemarkView1'))-180;
					}
					document.getElementById('codRemarkView1').style.visibility="visible";
					document.getElementById('codRemarkView1').style.overflow="visible";
					document.getElementById('codRemarkView1').width=400;
	                document.getElementById('codRemarkView1').height=260;
					document.frames("codRemarkIfrm1").document.forms[0].diff_rmk.value=ComGetObjValue(formObj.codRjctRsnRmk); 
					ifTop++;
					 
				break;
	  
				case "btn_retrieve":
					formObj.rob_flag.checked=false;
					if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					groupMailClear();
					if(ComIsEmpty(formObj.cod_rqst_seq)||
						ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)){
						doActionIBSheet(sheetObjects[0],formObj,COMMAND01); 
					}
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					
				break;
				
				case "btn_new":
					 initVal(formObj,"N");
				break;
				
				case "btn_save":
					if (validateForm(sheetObjects[1],formObj,IBSAVE)){
						doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
					}
				break;
				
				case "btn_add":
					if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					for(var i=0;i<sheetObjects.length;i++){
						sheetObjects[i].RemoveAll();
					}
					
					groupMailClear();
					var iseq=formObj.cod_rqst_seq[formObj.cod_rqst_seq.length-1].value;
					ComAddComboItem(formObj.cod_rqst_seq, (ComParseInt(iseq)+1),(ComParseInt(iseq)+1));
	                ComSetObjValue(formObj.cod_rqst_seq,(ComParseInt(iseq)+1));
					if(ComIsEmpty(formObj.bkg_no) && ComIsEmpty(formObj.bl_no)){
						ComShowCodeMessage("BKG00273");
						return;
					}
					  
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					ComSetObjValue(formObj.saveModeCd,"C");
					formObj.rgn_cd.index="";
					formObj.cod_rqst_rsn_cd.index="";
					btnEnable(formObj);				 
				break;
	
				case "btn_del":
					if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="Y"
				        || ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"
						|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"
						|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="R"){
						ComShowCodeMessage("BKG00751");
						return;
					}
					 
					if(ComIsEmpty(formObj.codStsCd) && ComGetObjValue(formObj.saveModeCd)=="C"
					   && ComParseInt(ComGetObjValue(formObj.cod_rqst_seq))>1){ 
						formObj.cod_rqst_seq.selectedIndex=formObj.cod_rqst_seq.selectedIndex-1;
						formObj.cod_rqst_seq.options[formObj.cod_rqst_seq.selectedIndex+1]=null;
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}else if(ComGetObjValue(formObj.saveModeCd)=="U"){
						doActionIBSheet(sheetObjects[0],document.form,REMOVE);
					}
				break;
	   
				case "btn_request":
					if (formObj.rob_flag.checked) {
	    				formObj.rob_flag.value = "Y";
	    			} else {
	    				formObj.rob_flag.value = "N";
	    			}
					if (validateForm(sheetObjects[1],formObj,COMMAND02)){
						if (validateForm(sheetObjects[1],formObj,IBSAVE)){
							//auto cod, t/s가 아닐 경우 p/c를 다시 실행함
				            if(ComGetObjValue(formObj.cod_rqst_rsn_cd) == "AU"
				            	|| ComGetObjValue(formObj.cod_rqst_rsn_cd) == "TS"){
				            	// searchRehandlingPort
				            	doActionIBSheet(sheetObjects[0],formObj,COMMAND09);
				            } else {
				            	// P/C click
				            	doActionIBSheet(sheetObjects[8],formObj,COMMAND08);
				            }

							if (ComIsNull(formObj.pctl_no) || "null"==formObj.pctl_no.value){
								ComShowCodeMessage("BKG00309");
								return false;
							}
							if (ComGetObjValue(formObj.cod_mnl_flg)=="Y"){
								//manual request
								doActionIBSheet(sheetObjects[8],document.form,COMMAND11);							
							} else {
								// normal request
								doActionIBSheet(sheetObjects[8],document.form,COMMAND02);
							}
						}
					}
				break;        
	
	    		case "btn_approve":
					if(ComGetObjValue(formObj.cod_mnl_flg)==null||ComGetObjValue(formObj.cod_mnl_flg)!="Y"){
						ComShowCodeMessage("BKG02041");
						return false;
					}						
					doActionIBSheet(sheetObjects[8],document.form,COMMAND12);
	    		break;
	    		
				case "btn_cancel":
					if (validateForm(sheetObjects[1],formObj,COMMAND03)){						
						if (ComGetObjValue(formObj.cod_mnl_flg)=="Y"){
							doActionIBSheet(sheetObjects[8],document.form,COMMAND13);							
						} else {
							doActionIBSheet(sheetObjects[8],document.form,COMMAND03);
						}
					}
				break;
				
				case "btn_bkg_main": 
					 if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){
						ComShowCodeMessage("BKG00384");
						return;
					 }
				     if (ComGetObjValue(formObj.codStsCd).toUpperCase()!="Y"){
						ComShowCodeMessage("BKG00748");
						return;
					 } 
					 if(ComIsEmpty(formObj.bkg_no)){
					 	return;
				     }
	
			    	 //bdr 지났을 경우 c/a issue 처리
			    	 //정상적으로  pop-up에서 select해야 pop-up으로 진행한다.				    	 
				     ComSetObjValue(formObj.ca_rsn_cd, "");					        		
				     ComSetObjValue(formObj.ca_remark, "");		
					 comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "S");
					 if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
						 doActionIBSheet(sheetObjects[0],formObj,COMMAND10);
					 }
				break;
	
				case "btn_confirm":					
					if (validateForm(sheetObjects[1],formObj,COMMAND07)){
						var sRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
						var arrRow = sRow.split("|");				 
						if ((arrRow.length-1) ==(sheetObjects[0].Rows-1)){ //Cntr 체크박스가 다 체크되었을 경우

							//auto cod가 아닐 때만 P/C 실행
					        if(ComGetObjValue(formObj.cod_rqst_rsn_cd) != "AU"
					        	&& ComGetObjValue(formObj.cod_rqst_rsn_cd) != "TS"){
					        	//p/c를 다시 실행함							
								doActionIBSheet(sheetObjects[8],formObj,COMMAND08);
					        }
						
						    if (formObj.bdr_flag.checked){ 
						    	//bdr 지났을 경우 c/a issue 처리
							    ComSetObjValue(formObj.ca_rsn_cd, "");					        		
							    ComSetObjValue(formObj.ca_remark, "");
						    	comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "C"); 
								if(!ComIsNull(formObj.ca_rsn_cd.value) && formObj.ca_rsn_cd.value!=null && formObj.ca_rsn_cd.value!='null'){
						    		doActionIBSheet(sheetObjects[8],formObj,COMMAND07);
						    	}
						    } else {
						    	//bdr 이전일 경우 pop-up 없이 진행
						  		doActionIBSheet(sheetObjects[8],formObj,COMMAND07);
						    }
						}else{				
							var param=""; 			
							//cod split으로 진행
							param="?bkg_no="+ComGetObjValue(formObj.bkg_no);
							param+="&cod_rqst_seq="+ComGetObjValue(formObj.cod_rqst_seq);
							param+="&cod_rqst_rsn_cd="+ComGetObjValue(formObj.cod_rqst_rsn_cd);
							param+="&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
							param+="&pgmNo=ESM_BKG_0997";
							param+=setCntrSpc();
	
							ComOpenPopup("/hanjin/ESM_BKG_0997.do"+param, 605, 530, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
						} 
					}
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
     * Combo Object를 배열로 등록
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
  	   var formObj = document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		
		setCodReason_Combo(); // 콤보 세팅
		
		formObj.cod_rjct_cd.BackColor="#eeeeee";
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_request");
		ComBtnDisable("btn_cancel");
		ComBtnDisable("btn_bkg_main");
		ComBtnDisable("btn_confirm");
		ComBtnDisable("btn_approve");
		 
		if (ComGetObjValue(formObj.popFlg)=="S"){
			doActionIBSheet(sheetObjects[0],formObj,COMMAND01);
			// pop-up으로 open시 아래 오류가 있어서 주석 처리함
//			[ComSetObjValue Error] selected 속성을 설정할 수 없습니다. 지정되지 않은 오류입니다.
//			ComSetObjValue(document.form.cod_rqst_seq,document.form.oldCodRqstSeq.value);
            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		} 
		else if(ComGetObjValue(formObj.popFlg)=="C"){
			//auto COD의 경우 가장 마지막 cod seq를 조회한다
			doActionIBSheet(sheetObjects[0],formObj,COMMAND01);
			
			if(arrCodRqstSeq != null){
				ComSetObjValue(formObj.cod_rqst_seq, arrCodRqstSeq[arrCodRqstSeq.length - 1]);
			
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			}
		}
		axon_event.addListenerFormat('keypress','bkg0156_keypress', formObj);   
		axon_event.addListenerForm('blur', 'bkg0156_blur', formObj);
		axon_event.addListenerForm('change','bkg0156_change', formObj);	
		axon_event.addListenerForm('change','cod_rhnd_port_cd_OnChange', formObj);
		ComSetFocus(formObj.bkg_no);
		
		// POD가 변경된 경우 Msg Popup표시
		if(ComGetObjValue(formObj.changePodFlg) == "Y"){
			ComShowCodeMessage("BKG95127");
		// DEL이 변경된 경우 Msg Popup표시
		} else if(ComGetObjValue(formObj.changeDelFlg) == "Y"){
			ComShowCodeMessage("BKG95128");
		}
    }

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetId = sheetObj.id;

		switch(sheetId) {
			case "sheet1":      //sheet1 init CNTR LIST
				with (sheetObj) {
                    // 높이 설정
                    style.height = 80;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(18, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = " ||Seq.|Sel.|CNTR No.|Type|Weight|Weight|ST|DG|BB|AK|RF|SOC|Stowage|||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix1+"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,	    10,	    daCenter,		false,		prefix1+"reserved_cntr_flg",false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtSeq,			45,		daCenter,		false,		prefix1+"seq");
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		false,		prefix1+"chk",		        false,			"",      dfNone,			0,		true);
					InitDataProperty(0, cnt++ , dtData,			145,	daCenter,		false,		prefix1+"cntr_no",			false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		prefix1+"cntr_tpsz_cd",		false,			"",      dfNone,			0,		false);

					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		true,		prefix1+"cntr_wgt",			false,			"",      dfNone,			2,		false);
					InitDataProperty(0, cnt++ , dtData,			60,	    daCenter,		true,		prefix1+"wgt_ut_cd",		false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtData,			60,	    daCenter,		true,		prefix1+"mvmt_sts_cd",		false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		false,		prefix1+"dcgo_flg",			false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		false,		prefix1+"bb_cgo_flg",		false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		false,		prefix1+"awk_cgo_flg",		false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		false,		prefix1+"rc_flg",			false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,		false,		prefix1+"soc_flg",			false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		prefix1+"cntr_stwg_no",		false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtHidden,	    10,	    daCenter,		false,		prefix1+"dg_eml_ctnt",		false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtHidden,	    10,	    daCenter,		false,		prefix1+"rf_eml_ctnt",		false,			"",      dfNone,			0,		false);
					InitDataProperty(0, cnt++ , dtHidden,	    10,	    daCenter,		false,		prefix1+"ak_eml_ctnt",		false,			"",      dfNone,			0,		false);
				}
				break;
			
			case "sheet2":      //sheet2 init OLD&NEW ROUTE
				with (sheetObj) {
                    // 높이 설정
                    style.height = 90;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(17, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    var HeadTitle1 = "|BKG Route|POR|POR|POL|POL|POD|POD|DEL|DEL|D|PRE|PRE|POST|POST|T/VVD|Details";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix2+"ibflag"); 
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		false,		prefix2+"bkgroute",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	  	false,		prefix2+"por_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	  	false,		prefix2+"por_nod_cd",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix2+"pol_cd",		false,			"",      dfNone,			0,		false,		false,  5);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,		prefix2+"pol_nod_cd",	false,			"",      dfNone,			0,		false,		false,2);
					
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix2+"pod_cd",		false,			"",      dfEngUpKey,		0,		true,		true,  5);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,		prefix2+"pod_nod_cd",	false,			"",      dfEngUpKey,		0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix2+"del_cd",		false,			"",      dfEngUpKey,		0,		true,		true,  5);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,		prefix2+"del_nod_cd",	false,			"",      dfEngUpKey,		0,		true,		true, 2);

					InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,		false,		prefix2+"de_term_cd",	false,			"",		 dfNone,			0,		true,		true, 2);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix2+"pre_cd",		false,			"",      dfEngUpKey,		0,		false,		false,  5);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,		prefix2+"pre_nod_cd",	false,			"",      dfEngUpKey,		0,		false,		false, 2);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix2+"pst_cd",	    false,			"",      dfEngUpKey,		0,		false,		false,  5);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		false,		prefix2+"pst_nod_cd",	false,			"",      dfEngUpKey,		0,		false,		false, 2);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		false,		prefix2+"tvvd", 		false,			"",      dfEngUpKey,		0,		true,		true,  9);
					//InitDataProperty(0, cnt++ , dtPopup,		60,		daCenter,		false,		prefix2+"detail",		false,			"",      dfNone,			0,		true,		false);
					InitDataProperty(0, cnt++ , dtImage,		 0,		daCenter,	    true,		prefix2+"detail",		false,			"",		 dfNone,			0,		false,		true);
							 
					ImageList(0) = "img/btng_ts_route.gif"; 
					
					CountPosition = 0;
				}
				break;

			case "sheet3":      //sheet3 init CHARGE
				with (sheetObj) {
                    // 높이 설정
                    style.height = 68;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    var HeadTitle1 = "|Seq.|CHG|Currency|Rate|Rated as|Per|Amount|Term|CGO|Type||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix3+"ibflag");
					InitDataProperty(0, cnt++ , dtData,		    45,		daCenter,		false,		prefix3+"cost_cd_rqst_seq", false,			"",      dfNone,			0,		false,		false); 
					InitDataProperty(0, cnt++ , dtPopup,	    80,		daCenter,  		false,		prefix3+"chg_cd",			false,			"",      dfNone,			0,		true,		false);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,		false,		prefix3+"curr_cd",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		false,		prefix3+"chg_ut_amt",		false,			"",      dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		false,		prefix3+"rat_as_qty",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		prefix3+"rat_ut_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		false,		prefix3+"chg_amt",			false,			"",      dfNullFloat,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix3+"frt_term_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		prefix3+"cgo_cate_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		prefix3+"cntr_cgo_tp_cd",	false,			"",      dfNone,			0,		false,		false);

					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,		false,		prefix3+"bkg_no",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,		false,		prefix3+"cod_rqst_seq",		false,			"",      dfNone,			0,		false,		false);

					CountPosition = 0;
					ShowButtonImage = 2;	
				}
				break;
        
			case "sheet4":      //sheet4 init
				with (sheetObj) {
                    // 높이 설정
                    style.height = 68;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    var HeadTitle1 = "|Total|Total";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix4+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,		false,		prefix4+"curr_cd",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			150,	daRight,		false,		prefix4+"sumamt",			false,			"",      dfNullFloat,	2,		false,		false);
					
					CountPosition = 0;
				}
				break;
			
			case "sheet5":      //sheet5 init
				with (sheetObj) {
                    // 높이 설정
                    style.height = 42;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Status|Date|By|Office|Now Read|Previous";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		prefix5+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		prefix5+"cod_sts_cd",		false,			"",      dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		prefix5+"update_date",		false,			"",      dfUserFormat2,	0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		prefix5+"update_by",		false,			"",      dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		false,		prefix5+"update_ofc",		false,			"",      dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			280,	daCenter,		false,		prefix5+"now_read",			false,			"",      dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			280,	daCenter,		false,		prefix5+"previous",			false,			"",      dfNone,		0,		false,		false);

					InitUserFormat2(0, prefix5+"update_date", "####-##-##", "-|:" );
					CountPosition = 0;
				}
				break;
			
			case "sheet6":      //old route
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 350;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Cd|Seq|Pol1|Pod1|PolSeq|PodSeq|VslCd|SkdVoyNo|SkdDirCd|SlanCd|||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,		false,	prefix6+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,				55,		daCenter,		false,	prefix6+"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix6+"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
                    
                    InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix6+"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix6+"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			90,    	daCenter,  		false,  prefix6+"pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			90,    	daCenter,  		false,  prefix6+"pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix6+"vsl_cd",				false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix6+"skd_voy_no",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix6+"skd_dir_cd",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix6+"slan_cd",				false,		"",	dfNone,		0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,   		50,    	daCenter,  		false,  prefix6+"bkg_no");
					InitDataProperty(0, cnt++ , dtHidden,   		50,    	daCenter,  		false,  prefix6+"cod_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,   		50,    	daCenter,  		false,  prefix6+"vvd_op_cd");
					CountPosition = 0;
               }
                break;
			case "sheet7":		// new route
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 350;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(14, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Cd|Seq|Pol1|Pod1|PolSeq|PodSeq|VslCd|SkdVoyNo|SkdDirCd|SlanCd|||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,		false,	prefix7+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,				55,		daCenter,		false,	prefix7+"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix7+"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
                    
                    InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix7+"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix7+"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			90,    	daCenter,  		false,  prefix7+"pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			90,    	daCenter,  		false,  prefix7+"pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix7+"vsl_cd",				false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix7+"skd_voy_no",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				90,		daLeft,			false,	prefix7+"skd_dir_cd",			false,		"",	dfNone,		0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	prefix7+"slan_cd",				false,		"",	dfNone,		0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,   		50,    	daCenter,  		false,  prefix7+"bkg_no");
					InitDataProperty(0, cnt++ , dtHidden,   		50,    	daCenter,  		false,  prefix7+"cod_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,   		50,    	daCenter,  		false,  prefix7+"vvd_op_cd");

					CountPosition = 0;
               }
                break;
			case "sheet8"://t/s route
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 350;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,		false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtData,				55,		daCenter,		false,	"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	"pol_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				50,		daLeft,			false,	"pod_cd",				false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				30,		daLeft,			false,	"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,				100,	daLeft,			false,	"bkg_vvd_cd",			false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  "pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,   			30,    	daCenter,  		false,  "pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
                    CountPosition = 0;
               }
                break; 

			case "sheet9":
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = 350;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(3, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false)
					
					var HeadTitle = "|TP/SZ|Vol.";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,		false,		prefix9+"ibflag");
					InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		prefix9+"c_tpsz",				false,		"",	dfNone,		0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	false,		prefix9+"c_qty",				false,		"",	dfNullFloat,	2,		true,		true, 5);
					
					CountPosition = 0;					
				}
				break;      
        }
    }
	
	/*
	* sheet image setting
	*/
	function sheet_imageSet(sheetObj,Col){
		sheetObj.ColHidden(prefix2+"detail")=false;
		for(var i=1;i<sheetObj.Rows;i++){
			sheetObj.CellValue(i,Col)=0;
		}
	}

  // Sheet관련 프로세스 처리
     
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	var arrPreFix = new Array("sheet1_","sheet3_","sheet4_","sheet5_","sheet6_","sheet7_");
    	switch(sAction) {        	
          	case IBSEARCH:      //조회
          		sheetObjects[5].Rows=1;
			   	sheetObjects[6].Rows=1;
			   	sheetObjects[7].Rows=1;

			   	formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var param = "f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value+"&bl_no="+formObj.bl_no.value+"&cod_rqst_seq="+formObj.cod_rqst_seq.value+ "&"+ComGetPrefixParam(arrPreFix);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0156GS.do", param);
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				var arrXml = sXml.split("|$$|");
				for(var i = 0; i < arrXml.length; i++){					
					if(i==0){
						sheetObjects[i].LoadSearchXml(arrXml[i]);						
					} else {  
						sheetObjects[i+1].LoadSearchXml(arrXml[i]);
					} 
				}
				
				// Search 결과값이 있을 경우에만 이하의 값들을 셋팅.
				if(State != "F"){					
		   			for(var iRow=1;iRow<sheetObjects[0].Rows;iRow++){
		   				if (sheetObjects[0].CellValue(iRow,prefix1+"reserved_cntr_flg")=="1"){
		   					sheetObjects[0].CellEditable(iRow,prefix1+"chk")=false;
		   					sheetObjects[0].CellBackColor(iRow,prefix1+"reserved_cntr_flg")=sheetObjects[0].CellBackColor(iRow,prefix1+"cntr_no");
		   				}
			   		}
			   		
					if(sheetObjects[1].Rows<2){
						sheetObjects[1].DataInsert(); 
						sheetObjects[1].DataInsert(); 
					}
					 
					sheetObjects[1].CellEditable(1,prefix2+"pod_cd")    = false;
					sheetObjects[1].CellEditable(1,prefix2+"pod_nod_cd")= false;
					sheetObjects[1].CellEditable(1,prefix2+"del_cd")    = false;
					sheetObjects[1].CellEditable(1,prefix2+"del_nod_cd")= false;
					sheetObjects[1].CellEditable(1,prefix2+"de_term_cd")= false;
					sheetObjects[1].CellEditable(1,prefix2+"tvvd")      = false;
					//sheetObjects[1].CellEditable(1,prefix2+"detail")=true;
					//sheetObjects[1].CellEditable(2,prefix2+"detail")=true;
	
					sheetObjects[1].CellValue2(1,prefix2+"bkgroute") = "OLD";
					sheetObjects[1].CellValue2(2,prefix2+"bkgroute") = "NEW";
					sheetObjects[1].CellValue2(1,prefix2+"detail")   = 0;
					sheetObjects[1].CellValue2(2,prefix2+"detail")   = 0;
					//sheetObjects[1].CellBackColor(1,prefix2+"detail") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					//sheetObjects[1].CellBackColor(2,prefix2+"detail") = sheetObjects[1].CellBackColor(2,prefix2+"bkgroute");
					 
					sheetObjects[1].CellBackColor(2,prefix2+"por_nod_cd") =sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(2,prefix2+"pol_nod_cd") =sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(2,prefix2+"pre_nod_cd") =sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(2,prefix2+"pst_nod_cd") =sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					 
					sheetObjects[1].CellBackColor(1,prefix2+"pod_cd") 	  = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"pod_nod_cd") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"pol_cd") 	  = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"pol_nod_cd") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"del_cd") 	  = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"del_nod_cd") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"pre_cd")     = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"pre_nod_cd") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"pst_cd")     = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"pst_nod_cd") = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
					sheetObjects[1].CellBackColor(1,prefix2+"tvvd")       = sheetObjects[1].CellBackColor(1,prefix2+"bkgroute");
				
					// cod reason combo 초기화
					formObj.cod_rqst_rsn_cd.RemoveAll();
					ComXml2ComboItem(arrRqstRsnXml, formObj.cod_rqst_rsn_cd, "val", "name|desc");
					
					setFormData(formObj,sheetObj);
					 
					if (ComIsNull(formObj.oldCodRqstSeq)){
						ComSetObjValue(formObj.saveModeCd,"C");
	                }else{
						ComSetObjValue(formObj.saveModeCd,"U");
					}
	
					if (ComGetObjValue(document.form.popFlg)!="S"){
						btnEnable(formObj);
					}
					
					if(!ComIsNull(formObj.codRjctRsnRmk)){
						ComBtnColor("btn_reject","blue");	
					} else {
						ComBtnColor("btn_reject","#737373");					
					}
	
					//Old Route
					if (sheetObjects[5].TotalRows==0){
						sheetObjects[5].Rows=1;  
					}else{ 
						for(var iRow=1;iRow<sheetObjects[5].Rows;iRow++){
							sheetObjects[5].CellValue2(iRow, prefix6+"bkg_no")=ComGetObjValue(formObj.bkg_no);
							sheetObjects[5].CellValue2(iRow, prefix6+"cod_rqst_seq")=ComGetObjValue(formObj.cod_rqst_seq);
							sheetObjects[5].CellValue2(iRow, prefix6+"vvd_op_cd")="O";
						}
					}
					//New Route
					if (sheetObjects[6].TotalRows==0 && sheetObjects[5].TotalRows!=0){
						sheetObjects[6].RemoveAll(); 
	                    sheetObjects[5].Copy2SheetCol(sheetObjects[6],"","",-1,-1,-1,1,false,false);
						for(var iRow=1;iRow<sheetObjects[6].Rows;iRow++){
							sheetObjects[6].CellValue2(iRow, prefix7+"vvd_op_cd")="N";
						}
					}else if (sheetObjects[6].TotalRows==0){
						sheetObjects[6].Rows=1;
					}else{ 
						for(var iRow=1;iRow<sheetObjects[6].Rows;iRow++){
							sheetObjects[6].CellValue2(iRow, prefix7+"bkg_no")=ComGetObjValue(formObj.bkg_no);
							sheetObjects[6].CellValue2(iRow, prefix7+"cod_rqst_seq")=ComGetObjValue(formObj.cod_rqst_seq);
							sheetObjects[6].CellValue2(iRow, prefix7+"vvd_op_cd")="N";
						}
					}
					if (!ComIsEmpty(formObj.codRemark)){  
						ComBtnColor("btn_remark","blue");
					} else {
						ComBtnColor("btn_remark","#737373");					
					}	 					
		            
		            if (ComGetObjValue(formObj.auto_cod_flg) != "Y"){
		            	formObj.cod_rqst_rsn_cd.DeleteItem("AU");
		            	formObj.cod_rqst_rsn_cd.DeleteItem("TS");
			            if(ComGetObjValue(formObj.cod_rqst_rsn_cd) == "AU"
			            	|| ComGetObjValue(formObj.cod_rqst_rsn_cd) == "TS"){
			            	formObj.cod_rqst_rsn_cd.index=""; 
			            }		            	
		            }
				}
				ComSetObjValue(formObj.route_modify_flag,"");
			break;
		  
          	case IBSAVE:        //저장
          		
          		// ROUTE DETAIL 에 POL 이 KR 이 있는 경우만 하단의 로직을 실행 2014.05.20 
				if(sheetObjects[7].RowCount > 0 && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
					var krRow = sheetObjects[7].FindText("pod_cd", "KR", 0, 0);
					if(krRow != -1){
						var krVvdCd  = sheetObjects[7].CellValue(krRow,"bkg_vvd_cd");
						var krPodLoc = sheetObjects[7].CellValue(krRow,"pod_cd");

						if(krVvdCd.length > 0 && krPodLoc.length > 0){
							var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", "f_cmd="+SEARCH15+"&vvd_cd="+krVvdCd+"&pod_loc="+krPodLoc);
							var krDlCnt = ComGetEtcData(sXml, "kr_cstms_dl_cnt");
							if(krDlCnt!="" && krDlCnt.length>0 && krDlCnt>0){
								ComShowCodeMessage("BKG08312", krVvdCd);
							}
						}
					}
				}
          		
          		
		        if (ComGetObjValue(formObj.saveModeCd).toUpperCase()=="C"){
					formObj.f_cmd.value = ADD; 
		        }else if (ComGetObjValue(formObj.saveModeCd).toUpperCase()=="U"){
					formObj.f_cmd.value = MODIFY; 
				}
				RouteData();
				var params = FormQueryString(formObj);
            	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
				params = params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				
            	sheetObj.LoadSearchXml(sXml);
                if(State == "S"){
					ComSetObjValue(formObj.saveModeCd,"U");
					if (!ComIsEmpty(formObj.codRemark)){  
						ComBtnColor("btn_remark","blue");
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}				 
            break;

          	case REMOVE:
          		formObj.f_cmd.value = REMOVE; 
				var params = "f_cmd="+REMOVE + "&bkg_no="+formObj.bkg_no.value
											   +"&bl_no="+formObj.bl_no.value
											   +"&cod_rqst_seq="+formObj.cod_rqst_seq.value
											   +"&popFlg="+formObj.popFlg.value
											   +"&cod_rqst_rsn_cd="+ComGetObjValue(formObj.cod_rqst_rsn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&rgn_cd="+ComGetObjValue(formObj.rgn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&codStsCd="+formObj.codStsCd.value
											   +"&cod_mnl_flg="+formObj.cod_mnl_flg.value;
//          		var params = FormQueryString(formObj);

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
			
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				sheetObj.LoadSearchXml(sXml);
	            if(State == "S"){
					var iseq=formObj.cod_rqst_seq[formObj.cod_rqst_seq.selectedIndex].value;
					if (iseq !=1){
						formObj.cod_rqst_seq.options[formObj.cod_rqst_seq.selectedIndex]=null;
						ComSetObjValue(formObj.cod_rqst_seq,formObj.cod_rqst_seq.selectedIndex-1);
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			break;

          	case COMMAND01:			//Sequence Combo
				formObj.f_cmd.value = COMMAND01; 

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);

				var params = "f_cmd="+COMMAND01+"&bkg_no="+formObj.bkg_no.value
											   +"&bl_no="+formObj.bl_no.value
											   +"&cod_rqst_seq="+formObj.cod_rqst_seq.value;
//          		params = FormQueryString(formObj);
				var sXml =sheetObj.GetSearchXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				
				var arrVal= ComXml2ComboString(sXml, "val", "name");  
				ComboList(arrVal);
				break;

          	case COMMAND02:		//Request Click	   
				RouteData();
          		if (validateForm(sheetObjects[1],formObj,IBSAVE)==false){
          			return false;
          		}
          		
          		formObj.f_cmd.value = MODIFY; // 저장
				var params = FormQueryString(formObj);
		    	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
				params = params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
		
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State == "S"){		
			        formObj.f_cmd.value = COMMAND02;
	          		params = FormQueryString(formObj);
	
					sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
					ComOpenWait(false);

					State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
		            if(State == "S"){
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						setEmlCtnt(sXml);
						groupMailset("R");
					} 
		            else {
						sheetObj.LoadSaveXml(sXml);
					}
				} else {
					sheetObj.LoadSaveXml(sXml);
				}
				break;

          	case COMMAND03:		//Cancel Click	
          		formObj.f_cmd.value = COMMAND03; 
				var params = "f_cmd="+COMMAND03+"&bkg_no="+formObj.bkg_no.value
											   +"&bl_no="+formObj.bl_no.value
											   +"&cod_rqst_seq="+formObj.cod_rqst_seq.value
											   +"&popFlg="+formObj.popFlg.value
											   +"&cod_rqst_rsn_cd="	+ComGetObjValue(formObj.cod_rqst_rsn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&rgn_cd="+ComGetObjValue(formObj.rgn_cd)
											   +"&bdr_flag="+formObj.bdr_flag.value
											   +"&codStsCd="+formObj.codStsCd.value
											   +"&cod_mnl_flg="+formObj.cod_mnl_flg.value;
//          		params = FormQueryString(formObj);

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				sheetObj.LoadSearchXml(sXml);
	            if(State == "S"){
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					setEmlCtnt(sXml);
					groupMailset("C");
				}
				break;

          	case COMMAND05:		//Calculation Click	
          		var iCheckRow= sheetObjects[0].FindCheckedRow(prefix1+"chk");
          		var arrRow = iCheckRow.split("|");
          		if(arrRow.length < 2){
          			ComShowCodeMessage("BKG00188");
          			return;
          		}
          		formObj.f_cmd.value = COMMAND05; 
          		RouteData();
          		var params = FormQueryString(formObj);
          		params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
          		params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
          		params = params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
          		params = params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
          		params = params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));
          		params = params + "&" + ComGetPrefixParam(new Array("sheet3_"));

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
          		var sXml = sheetObj.GetSearchXml("ESM_BKG_0156GS.do", params);
          		ComOpenWait(false);
			 
          		var arrXml = sXml.split("|$$|");
          		sheetObj.LoadSearchXml(arrXml[0]);
          		if(sheetObj.Rows>1){
          			var idx = 0;
	          		var currCd  = "XXX";
	          		var arrCurrCd  = new Array();
	          		var arrCurrAmt = new Array();
	          		for(i=1;i<sheetObj.Rows;i++){
	          			if(currCd != sheetObj.CellValue(i, prefix3+"curr_cd")){
	          				currCd = sheetObj.CellValue(i, prefix3+"curr_cd");
	          				idx++;
	          				arrCurrCd[idx]  = sheetObj.CellValue(i, prefix3+"curr_cd");
	          				arrCurrAmt[idx] = 0;
	          			}
          				arrCurrAmt[idx] = arrCurrAmt[idx]+ComParseInt(sheetObj.CellValue(i, prefix3+"chg_amt"));
	          		}
	          		sheetObjects[3].RemoveAll();
	          		for(i=1;i<idx+1;i++){
	          			sheetObjects[3].DataInsert(-1);	          			
	          			sheetObjects[3].CellValue2(i, prefix4+"curr_cd")   = arrCurrCd[i];
	          			sheetObjects[3].CellValue2(i, prefix4+"sumamt") = arrCurrAmt[i];	          			
	          		}
          		}

          		break;
          	case COMMAND06:		//Complete COD CA	
				formObj.f_cmd.value = COMMAND06; 			
				var params = FormQueryString(formObj);

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);       
				sheetObj.LoadSearchXml(sXml);
	            if(State == "S"){     	 
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					setEmlCtnt(sXml);
					groupMailset("F");
	            }
				break;
          	case COMMAND07:		//Confirm Click	
				formObj.f_cmd.value = COMMAND07; 
          		RouteData();
          		var params = FormQueryString(formObj);
          		params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
          		params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
          		params = params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
          		params = params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
          		params = params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//          		params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	            if(State == "S"){
	            	
            	    //자동 Cargo Release 처리            		
        		    //Hold B/L 인가 , CR 전송한 적이 있는가				    		
			    	chagnePodCondition();
	            	
	            	//POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
				    old_pod_cd = sheetObjects[1].CellValue(1,prefix2+"pod_cd");
				    new_pod_cd = sheetObjects[1].CellValue(2,prefix2+"pod_cd");
				    
				    //POD=US 인 경우에만 처리  
				    if ( old_pod_cd.substring(0,2) == "US" && new_pod_cd.substring(0,2) == "US"  ) {
				    	if ( do_hld_flg == "N"  && cr_chk_flg == "Y" ) { 
					    	podChange(old_pod_cd,new_pod_cd);
				    	}
				    }
				    
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					setEmlCtnt(sXml);
					groupMailset("F");					
				} else {
					sheetObj.LoadSearchXml(sXml);
				}
				break;

          	case COMMAND08:		//PC Click	
				formObj.f_cmd.value = COMMAND08;
	
				var arrPreFix = new Array("sheet6_","sheet7_","sheet9_");
				RouteData();
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
				params = params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
				params = params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true)); 
				params = params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
//				params = params + "&" + ComSetPrifix(sheetObjects[7].GetSaveString(true));

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
	    		pcBtnColor("RED");
			    formObj.pctl_no.value = null;
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params+ "&rob_flg" + formObj.rob_flag.value + "&" + ComGetPrefixParam(arrPreFix));
	    		ComOpenWait(false);
	    		
	    		var arrXml = sXml.split("|$$|");
			    var isPctlNoPop = "N";
				isPctlNoPop = ComGetEtcData(arrXml[0], "IsPctlNoPop")
				
	            if(isPctlNoPop == "Y"){            	
	    			sheetObjects[8].LoadSearchXml(arrXml[2]);
					// ESD_PRD_0080 화면 호출
					var url = "ESD_PRD_0080.do?f_cmd=3&pc_mode=R";
					url = url + "&bkg_no="+	ComGetObjValue(formObj.bkg_no);
					url = url + "&por="   +	ComGetEtcData(arrXml[0], "por");
					url = url + "&por_n=" +	ComGetEtcData(arrXml[0], "por_n");
					url = url + "&pol="   + ComGetEtcData(arrXml[0], "pol");
					url = url + "&pol_n=" + ComGetEtcData(arrXml[0], "pol_n");
					url = url + "&pod="   + sheetObjects[1].CellValue(2,prefix2+"pod_cd");
					url = url + "&pod_n=" + sheetObjects[1].CellValue(2,prefix2+"pod_cd")+sheetObjects[1].CellValue(2,prefix2+"pod_nod_cd");
					url = url + "&del="   + sheetObjects[1].CellValue(2,prefix2+"del_cd");
					url = url + "&del_n=" + sheetObjects[1].CellValue(2,prefix2+"del_cd")+sheetObjects[1].CellValue(2,prefix2+"del_nod_cd");
					url = url + "&t_vvd=" + sheetObjects[1].CellValue(2,prefix2+"tvvd");				
	
					for(i = 1 ; i < sheetObjects[6].Rows; i++){				
						url = url + "&pol" + i + "="   + sheetObjects[6].CellValue(i, prefix7+"pol_yd_cd").substring(0,5);
						url = url + "&pol" + i + "_n=" + sheetObjects[6].CellValue(i, prefix7+"pol_yd_cd");
						url = url + "&pod" + i + "_c=" + sheetObjects[6].CellValue(i, prefix7+"pol_clpt_ind_seq");
						url = url + "&pod" + i + "="   + sheetObjects[6].CellValue(i, prefix7+"pod_yd_cd").substring(0,5);
						url = url + "&pod" + i + "_n=" + sheetObjects[6].CellValue(i, prefix7+"pod_yd_cd");
						url = url + "&pod" + i + "_c=" + sheetObjects[6].CellValue(i, prefix7+"pod_clpt_ind_seq");
						url = url + "&vvd" + i + "="   + sheetObjects[6].CellValue(i, prefix7+"vsl_cd") + sheetObjects[6].CellValue(i, prefix7+"skd_voy_no") + sheetObjects[6].CellValue(i, prefix7+"skd_dir_cd");				
					}
					url = url + "&rcv_t=" + ComGetEtcData(arrXml[0], "rcv_t");
					url = url + "&del_t=" + sheetObjects[1].CellValue(2,prefix2+"de_term_cd");
					url = url + "&shpr="  + ComGetEtcData(arrXml[0], "shpr");
					url = url + "&cngn="  + ComGetEtcData(arrXml[0], "cngn");
					url = url + "&com="     + ComGetEtcData(arrXml[0], "com");
					url = url + "&rep_com=" + ComGetEtcData(arrXml[0], "rep_com");
					url = url + "&wgt="     + ComGetEtcData(arrXml[0], "wgt");
					url = url + "&wgt_un="  + ComGetEtcData(arrXml[0], "wgt_un");
					url = url + "&bkg_ofc=" + ComGetEtcData(arrXml[0], "bkg_ofc");
					url = url + "&org_sal_ofc=" + ComGetEtcData(arrXml[0], "org_sal_ofc"); 
					
					url = url + "&m_pu=" + ComGetEtcData(arrXml[0], "m_pu");
					url = url + "&f_rt=" + ComGetEtcData(arrXml[0], "f_rt");
					
					url = url + "&sc="  + ComGetEtcData(arrXml[0], "sc");
					url = url + "&rfa=" + ComGetEtcData(arrXml[0], "rfa");
					
					url = url + "&cgo_tp=" + ComGetEtcData(arrXml[0], "cgo_tp");
					url = url + "&dg_f=" + ComGetEtcData(arrXml[0], "dg_f");
					url = url + "&rf_f=" + ComGetEtcData(arrXml[0], "rf_f");
					url = url + "&ak_f=" + ComGetEtcData(arrXml[0], "ak_f");
					url = url + "&bb_f=" + ComGetEtcData(arrXml[0], "bb_f");
					url = url + "&rd_f=" + ComGetEtcData(arrXml[0], "rd_f");
					url = url + "&hg_f=" + ComGetEtcData(arrXml[0], "hg_f");
					url = url + "&soc_f="+ ComGetEtcData(arrXml[0], "soc_f");
					url = url + "&pm_f=" + ComGetEtcData(arrXml[0], "pm_f");
	
	    			for(i = 1 ; i < sheetObjects[8].Rows ; i++){
	    				url = url + "&c_tpsz="+sheetObjects[8].CellValue(i, prefix9+"c_tpsz");
	    				url = url + "&c_qty=" +sheetObjects[8].CellValue(i, prefix9+"c_qty");  
	    			}		    			
//	    			alert(url);
	    			ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080","1,0,1,1,1", true);
	    			
	    			if(ComGetObjValue(formObj.pctl_no).length>=20){
	    				doActionIBSheet(sheetObjects[0],formObj,COMMAND09);
	    			} else {
	            		pcBtnColor("RED");
	    			}
	            } else {
					var State = ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key);
		            if(State == "S"){         	
		        		setNewRouteFromPrd(sXml, formObj);
		        		btnEnable(formObj);
		            } else {
						sheetObj.LoadSearchXml(sXml);
					}
	    		} 
	        	break;
		   case COMMAND09:		//searchRehandlingPort(0080화면에서 call back 후)
				formObj.f_cmd.value = COMMAND09; 
				var arrPreFix = new Array("sheet6_","sheet7_");
				var params = FormQueryString(formObj);

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params+ "&" + ComGetPrefixParam(arrPreFix));
				ComOpenWait(false);
				
	    		var arrXml = sXml.split("|$$|");			    
			    var State = ComGetEtcData(arrXml[0], ComWebKey.Trans_Result_Key);
	            if(State == "S"){
	        		setNewRouteFromPrd(sXml, formObj);
	    		} else {
					sheetObj.LoadSearchXml(sXml);
//	    			ComShowCodeMessage("BKG00740");
	        		pcBtnColor("RED");
	    		}
	            btnEnable(formObj);
	    		break;

		   	case COMMAND10:		//Start COD C/a (booking creation)	   	
				formObj.f_cmd.value = COMMAND10; 
				var params = FormQueryString(formObj);

				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				
	            if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S"){
		        	var sUrl = "/hanjin/ESM_BKG_0079_P.do";
		        	sUrl += "?pgmNo=ESM_BKG_0079&mainPage=false&isPop=Y";
		        	sUrl += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
		        	ComOpenWindowCenter(sUrl, "ESM_BKG_0079", 1024, 700, true, 'yes'); 	
//		       		 var param="?bkg_no="+ComGetObjValue(formObj.bkg_no)+"&mainPage=true";
//		       		 param+="&isPop=Y";
//		       		 param+="&pgmNo=ESM_BKG_0079";
////		       		 ComOpenWindowCenter(sUrl, sWinName, iWidth, iHeight, bModal, "yes")
//		       		 ComOpenWindowCenter("/hanjin/ESM_BKG_0079_P.do"+param, "ESM_BKG_0079", 1024, 700, true, "yes");
	            }
		   		break;

		   	case COMMAND11:		//manual request
		   	case COMMAND12:		//manual Approve
		   	case COMMAND13:		//manual cancel
		   		if(sAction==COMMAND11){
					RouteData();
	          		if (validateForm(sheetObjects[1],formObj,IBSAVE)==false){
	          			return false;
	          		}
	          		
	          		formObj.f_cmd.value = MODIFY; // 저장
					var params = FormQueryString(formObj);
			    	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));
					params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
					params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true));//chg
					params = params + "&" + ComSetPrifix(sheetObjects[4].GetSaveString(true));
					params = params + "&" + ComSetPrifix(sheetObjects[5].GetSaveString(true));
					params = params + "&" + ComSetPrifix(sheetObjects[6].GetSaveString(true));
			
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
					var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					if(State != "S"){
						sheetObj.LoadSaveXml(sXml);
						return false;
					}
		   		}
	   			formObj.f_cmd.value = sAction;
				var params = "f_cmd="+sAction+"&bkg_no="			+formObj.bkg_no.value
											   +"&bl_no="			+formObj.bl_no.value
											   +"&cod_rqst_seq="	+formObj.cod_rqst_seq.value
											   +"&popFlg="			+formObj.popFlg.value
											   +"&cod_rqst_rsn_cd="	+ComGetObjValue(formObj.cod_rqst_rsn_cd)
											   +"&bdr_flag="		+formObj.bdr_flag.value
											   +"&rgn_cd="			+ComGetObjValue(formObj.rgn_cd)
											   +"&bdr_flag="		+formObj.bdr_flag.value
											   +"&codStsCd="		+formObj.codStsCd.value
											   +"&cod_mnl_flg="		+formObj.cod_mnl_flg.value;
//				var params = FormQueryString(formObj);
				
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	            if(State == "S"){
					ComShowMessage(ComResultMessage(sXml));
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					//manual action일 경우 g/w 메일 보내지 않음
//					if(sAction == COMMAND11){
//						setEmlCtnt(sXml);
//						groupMailset("R");
//			        }else if(sAction == COMMAND13){
//						setEmlCtnt(sXml);
//						groupMailset("C");
//					}
				} else {
					sheetObj.LoadSearchXml(sXml);
				}
		   		break;
		   		
		   	case COMMAND14:		//search Rso
				formObj.f_cmd.value = COMMAND14; 
				var params = FormQueryString(formObj);
				
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0156GS.do", params);
				ComOpenWait(false);
				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "F"){
					sheetObj.LoadSaveXml(sXml);
					formObj.cod_rhnd_port_cd.value = '';
					ComSetFocus(document.form.cod_rhnd_port_cd);
				}
				
				formObj.rgn_cd.Code = ComGetEtcData(sXml, "rgn_cd");
				break;	
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
       switch(sAction) {
			case IBSAVE:
				 if (ComIsEmpty(formObj.saveModeCd.value)){
				    return false;
				 }	  
				 if (sheetObjects[0].FindCheckedRow(prefix1+"chk").length<1){
					 ComShowCodeMessage("BKG00239");
					 return false;
				 }
				 if (ComChkLen(sheetObj.CellValue(2,prefix2+"por_cd"),5)!=2){
					ComShowCodeMessage("BKG00006");
					return false;
				 }
				 
				 if (ComChkLen(sheetObj.CellValue(2,prefix2+"pol_cd"),5)!=2){
					ComShowCodeMessage("BKG00288");
					return false;
				 }

				 if (ComChkLen(sheetObj.CellValue(2,prefix2+"pod_cd"),5)!=2){
					ComShowCodeMessage("BKG00289");
					return false;
				 }
				 if (ComChkLen(sheetObj.CellValue(2,prefix2+"del_cd"),5)!=2){
					ComShowCodeMessage("BKG00290");
					return false;
				 }
								 
				 if (ComChkLen(ComGetObjValue(formObj.cod_rqst_rsn_cd),2)!=2){
					ComShowCodeMessage("BKG00742");
					return false;
				 }
				 
				 if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
					 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
					ComShowCodeMessage("BKG00048");
					return false;
				 }

				 var iCheckRow= sheetObjects[0].FindCheckedRow(prefix1+"chk");
				 var arrRow = iCheckRow.split("|");
				 var cntrVar="";
				 var iLine=0;

				 if (!ComIsEmpty(iCheckRow)){ 
					 for(var i=0;i<arrRow.length-1;i++){						 
//						 if (sheetObjects[0].CellValue(arrRow[i],prefix1+"bb_cgo_flg") == "1" 
//							 || ( sheetObjects[0].CellValue(arrRow[i],prefix1+"awk_cgo_flg") == "1"
//							 && sheetObjects[0].CellValue(arrRow[i],prefix1+"cntr_tpsz_cd") != "D7")){

						 if (sheetObjects[0].CellValue(arrRow[i],prefix1+"bb_cgo_flg") == "1"){
							 if (ComParseInt(i)%3==0){
								 cntrVar+=sheetObjects[0].CellValue(arrRow[i],prefix1+"cntr_no");
							 }else{
								 cntrVar+=","+sheetObjects[0].CellValue(arrRow[i],prefix1+"cntr_no");
							 }
							 iLine++;
							 if (ComParseInt(iLine)%3==0){
								 iLine=0;
								 cntrVar+="\n";
							 } 
						 }
					 }
						 
				 }


				 
				 if(cntrVar != ""){
					 ComShowCodeMessage("BKG02020",cntrVar);
					 return false;
				 }
				 
//		  		 if(ComIsNull(ComGetObjValue(formObj.pctl_no))){
//		  		 	 ComShowCodeMessage("BKG00309");
//		  			 break;
//		  	 	 }

				 if (ComChkLen(ComGetObjValue(formObj.cod_rhnd_port_cd),7)!=2){
					ComShowCodeMessage("BKG00740");
					return false;
				 }

				 if (ComChkLen(ComGetObjValue(formObj.rgn_cd),3)!=2){
					ComShowCodeMessage("BKG00741");
					return false;
				 }
				 if (ComIsEmpty(formObj.cod_rqst_seq)){
					ComAddComboItem(formObj.cod_rqst_seq,"1","1");
				 }
				  
			break;
		case COMMAND02://request	
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"
				|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"){
				ComShowCodeMessage("BKG00749");
				return;
			}
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="R"){
				ComShowCodeMessage("BKG00750");
				return;
			}
			if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
				 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
				ComShowCodeMessage("BKG00048");
				return false;
			} 
            var sRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
			if (sRow.length<1){
				ComShowCodeMessage("BKG00239");
				return false;
			}
			break
		case COMMAND03://cancel
			if (!ComShowCodeConfirm("BKG00670", "")) {
				return;
			}
			
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"
				|| ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"){
				ComShowCodeMessage("BKG00747");
				return;
			}
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){
				ComShowCodeMessage("BKG00384");
				return;
			}
			if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
				 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
				ComShowCodeMessage("BKG00048");
				return false;
			} 
			var sRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
			if (sRow.length<1){
				ComShowCodeMessage("BKG00239");
				return false;
			}
			break
		case COMMAND07: //confirm
			if (!ComShowCodeConfirm("BKG00614", "")) {
				return;
			}
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()!="Y"){
				ComShowCodeMessage("BKG00748"); 
				return;
			} 
			  
			if (ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){
				ComShowCodeMessage("BKG00384");
				return;
			}

			if (ComGetObjValue(formObj.confirmFlg)=="1"){
				ComShowCodeMessage("BKG02011");
				return;
			}
			 
			if(ComGetObjValue(formObj.bkg_no)!=ComGetObjValue(formObj.oldBkgNo)
				 || ComGetObjValue(formObj.bl_no)!=ComGetObjValue(formObj.oldBlNo)){
				ComShowCodeMessage("BKG00048");
				return false;
			}
			  
			var sRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
			var arrRow = sRow.split("|");
			if ((arrRow.length-1)<1){
				ComShowCodeMessage("BKG00239");
				return false;
			}
			break;
        }
        return true;
    }
	
	/*
	* Change Event 처리
	*/
	function bkg0156_change(){
		var formObj = document.form;
		obj = event.srcElement;
		if (obj.name=="cod_rqst_seq"){
			if(!ComIsEmpty(formObj.cod_rqst_seq)){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
		} else if (obj.name=="bkg_no"){
			formObj.bl_no.value = "";
		} else if(obj.name=="bl_no"){
			formObj.bkg_no.value = "";
		}
	}

	/*
	 * KeyPress Event 처리
	 */
    function bkg0156_keypress(){
		obj = event.srcElement;  
	    var formObj = document.form;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup": 
				 ComKeyOnlyAlphabet('uppernum'); 
	            break; 
			 case "eng": 
				 ComKeyOnlyAlphabet('upper');
	            break; 
	    }
		var btnObj=null;
		switch(obj.name){  
			case "bkg_no": 
			case "bl_no": 	
				if(event.keyCode == 13 && (formObj.bkg_no.value.length > 10 || formObj.bl_no.value.length == 12 )){
					btnObj = document.getElementById("btn_retrieve");
					if (btnObj) { 
						btnObj.fireEvent("onclick"); 
					}
				}
				break;
//			 case "bl_no": 	
//				if(ComIsEmpty(obj.value)) { 
//					return; 
//				}
//				if(event.keyCode == 13 && obj.value.length > 10){
//					btnObj = document.getElementById("btn_retrieve");
//					if (btnObj) { 
//						btnObj.fireEvent("onclick");
//					}
//				}
//				break;
		}
	}
	
	/*
	* Change Event처리
	*/
	function bkg0156_blur(){
		obj = event.srcElement; 
		var formObj = document.form; 
		
	    switch(obj.name){ 
			case "bkg_no": 
				if (!ComIsEmpty(formObj.oldBkgNo)&&!ComIsEmpty(formObj.bkg_no) 
				    &&ComGetObjValue(formObj.oldBkgNo)!=ComGetObjValue(formObj.bkg_no)){
				    ComClearObject(formObj.bl_no);
					initVal(formObj,""); 
				}				
				break;
	        case "bl_no": 	 
				if (!ComIsEmpty(formObj.oldBlNo)&&!ComIsEmpty(formObj.bl_no)
				    &&ComGetObjValue(formObj.oldBlNo)!=ComGetObjValue(formObj.bl_no)){
				    ComClearObject(formObj.bkg_no);
					initVal(formObj,""); 
			    }
	            break;
	    }
	}

	/*
	* Sequence 조회 데이터로 콤보박스생성
	*/
    function ComboList(arrVal){  
		 if(typeof(arrVal)=="undefined" && ComIsEmpty(document.form.bkg_no) && ComIsEmpty(document.form.bl_no)){
			 return;
		 } else if (typeof(arrVal)=="undefined" &&(!ComIsEmpty(document.form.bkg_no) || !ComIsEmpty(document.form.bl_no))){
			 var objCbo = document.getElementById("cod_rqst_seq");
			 ComClearCombo(objCbo);		
			 opt = document.createElement("option"); 
			 opt.setAttribute("value", "1");  
			 opt.innerHTML="1";  
			 objCbo.appendChild(opt);
			 return;
		 }
		 var objCbo = document.getElementById("cod_rqst_seq");
		 ComClearCombo(objCbo);		 
		 var arr_value = arrVal[0].split("|"); 
		 if (arr_value.length >0){
			 var opt = document.createElement("option"); 
			 var arr_text = "";   
			// opt.setAttribute("value", "");  
			// opt.innerHTML=arr_text;  
			// objCbo.appendChild(opt);
			 for(var i = 0; i <= arr_value.length-1; i++) {
				opt = document.createElement("option"); 
				arr_text = arr_value[i];   
				opt.setAttribute("value", arr_text);  
				opt.innerHTML=arr_text;  
				objCbo.appendChild(opt);
			 }
		 } 
		 arrCodRqstSeq = arr_value;
	}
	
	/* COD Reason,Staus 콤보 가져옴 */
	function setCodReason_Combo(){
	    var formObj = document.form;
	    var sRhqXml = "";
		if (ComGetObjValue(document.form.popFlg)=="S"){
			// pop-up때 code 다시 조회
			formObj.f_cmd.value = ""; 
			sRhqXml =sheetObj.GetSearchXml("ESM_BKG_0156GS.do", FormQueryString(formObj));
		} else {
			sRhqXml = ComGetObjValue(formObj.sXml);
		}
		
		var arrXml = sRhqXml.split("|$$|");
		arrRqstRsnXml = arrXml[0];
		ComXml2ComboItem(arrXml[0], comboObjects[0], "val", "name|desc");
		ComXml2ComboItem(arrXml[1], comboObjects[1], "rgn_shp_opr_cd", "rgn_shp_opr_cd|rgn_shp_opr_desc");
		ComXml2ComboItem(arrXml[2], comboObjects[2], "cod_rjct_cd", "cod_rjct_cd|cod_rjct_desc");
				
		if (arrXml[3] !=null && arrXml[3].length > 0) {
			var arrCombo = ComXml2ComboString(arrXml[3], "val", "name");
			sheetObjects[1].InitDataCombo(0, prefix2+"de_term_cd", arrCombo[0], arrCombo[0], "");
		}
	}

	/*
	* 변수 초기화
	*/
	function initVal(formObj,flag){
		for(var i=0;i<sheetObjects.length;i++){
			sheetObjects[i].RemoveAll();
		 }
		 ComSetObjValue(formObj.saveModeCd,"");
		 
		 formObj.rgn_cd.index="";
		 formObj.cod_rqst_rsn_cd.index=""; 
		 formObj.codRjctCd.value="-1"; 
		 formObj.cod_rjct_cd.index="";		 
         formObj.bdr_flag.checked=false;
         formObj.rob_flag.checked=false;
         
		 ComClearObject(formObj.pctl_no);
		 ComClearObject(formObj.map_seq);
		 ComClearObject(formObj.oldBkgNo);
		 ComClearObject(formObj.oldBlNo);
		 
         if (flag=="N"){
        	 ComClearObject(formObj.bkg_no);
		     ComClearObject(formObj.bl_no);
			 ComClearObject(formObj.bkgStsCd);
         }		 

		 ComClearCombo(formObj.cod_rqst_seq);
		 
		 ComClearObject(formObj.oldCodRqstSeq);
		 ComClearObject(formObj.cod_auth_flg);
		 ComClearObject(formObj.codRemark);
		 ComClearObject(formObj.cod_rhnd_port_cd);
		 ComClearObject(formObj.codStsCd);
		 ComClearObject(formObj.codRjctRsnRmk); 
		 ComClearObject(formObj.confirmFlg); 
		 ComClearObject(formObj.cod_mnl_flg);		 

		 ComBtnColor("btn_remark","#c0c0c0");
		 
		 ComBtnDisable("btn_request");
		 ComBtnDisable("btn_approve");
		 ComBtnDisable("btn_del");
		 ComBtnDisable("btn_cancel");
		 ComBtnDisable("btn_bkg_main");
		 ComBtnDisable("btn_confirm");
		 pcBtnColor("BLACK");
		 groupMailClear();
	}
	
	/*
	* BKG Route값 대입
	*/
    function RouteData(){
		var formObj = document.form;
		if (!ComIsEmpty(sheetObjects[1].CellValue(1,prefix2+"tvvd"))){
			ComSetObjValue(formObj.oldVslCd,sheetObjects[1].CellValue(1,prefix2+"tvvd").substring(0,4));
			ComSetObjValue(formObj.oldSkdVoyNo,sheetObjects[1].CellValue(1,prefix2+"tvvd").substring(4,8));
			ComSetObjValue(formObj.oldSkdDirCd,sheetObjects[1].CellValue(1,prefix2+"tvvd").substring(8));
		}
		ComSetObjValue(formObj.oldPorYdCd,sheetObjects[1].CellValue(1,prefix2+"por_cd")+sheetObjects[1].CellValue(1,prefix2+"por_nod_cd"));
		ComSetObjValue(formObj.oldPolYdCd,sheetObjects[1].CellValue(1,prefix2+"pol_cd")+sheetObjects[1].CellValue(1,prefix2+"pol_nod_cd"));
		ComSetObjValue(formObj.oldPodYdCd,sheetObjects[1].CellValue(1,prefix2+"pod_cd")+sheetObjects[1].CellValue(1,prefix2+"pod_nod_cd"));
		ComSetObjValue(formObj.oldDelYdCd,sheetObjects[1].CellValue(1,prefix2+"del_cd")+sheetObjects[1].CellValue(1,prefix2+"del_nod_cd"));
		
		if (!ComIsEmpty(sheetObjects[1].CellValue(2,prefix2+"tvvd"))){
			ComSetObjValue(formObj.newVslCd,sheetObjects[1].CellValue(2,prefix2+"tvvd").substring(0,4));
			ComSetObjValue(formObj.newSkdVoyNo,sheetObjects[1].CellValue(2,prefix2+"tvvd").substring(4,8));
			ComSetObjValue(formObj.newSkdDirCd,sheetObjects[1].CellValue(2,prefix2+"tvvd").substring(8));
		}
		ComSetObjValue(formObj.newPorYdCd, sheetObjects[1].CellValue(2,prefix2+"por_cd")+sheetObjects[1].CellValue(2,prefix2+"por_nod_cd"));
		ComSetObjValue(formObj.newPolYdCd, sheetObjects[1].CellValue(2,prefix2+"pol_cd")+sheetObjects[1].CellValue(2,prefix2+"pol_nod_cd"));
		ComSetObjValue(formObj.newPodYdCd, sheetObjects[1].CellValue(2,prefix2+"pod_cd")+sheetObjects[1].CellValue(2,prefix2+"pod_nod_cd"));
		ComSetObjValue(formObj.newDelYdCd, sheetObjects[1].CellValue(2,prefix2+"del_cd")+sheetObjects[1].CellValue(2,prefix2+"del_nod_cd"));
		ComSetObjValue(formObj.newDeTermCd,sheetObjects[1].CellValue(2,prefix2+"de_term_cd"));
		
	}

	/*
	* Data를 Form에 대입
	*/
	function setFormData(formObj,sheetObj){
		ComSetObjValue(formObj.oldBkgNo,sheetObj.EtcData("bkg_no"));
		ComSetObjValue(formObj.bkg_no,sheetObj.EtcData("bkg_no"));
		ComSetObjValue(formObj.oldBlNo,sheetObj.EtcData("bl_no"));
		ComSetObjValue(formObj.bl_no,sheetObj.EtcData("bl_no"));
		ComSetObjValue(formObj.oldCodRqstSeq,sheetObj.EtcData("cod_rqst_seq"));
		if (sheetObj.EtcData("bdr_flag")=="Y"){
			formObj.bdr_flag.checked=true;
		}else{
			formObj.bdr_flag.checked=false;
		}
		ComSetObjValue(formObj.max_seq,	        sheetObj.EtcData("max_seq"));
		ComSetObjValue(formObj.cod_rqst_seq,	sheetObj.EtcData("cod_rqst_seq"));
		ComSetObjValue(formObj.cod_auth_flg,	sheetObj.EtcData("cod_auth_flg"));
		ComSetObjValue(formObj.rgn_cd,			sheetObj.EtcData("rgn_cd"));
		ComSetObjValue(formObj.cod_rqst_rsn_cd,	sheetObj.EtcData("cod_rqst_rsn_cd"));
		ComSetObjValue(formObj.codRemark,		sheetObj.EtcData("codRemark"));
		ComSetObjValue(formObj.cod_rhnd_port_cd,sheetObj.EtcData("cod_rhnd_port_cd"));
		ComSetObjValue(formObj.codStsCd,		sheetObj.EtcData("codStsCd"));
		ComSetObjValue(formObj.cod_rjct_cd,		sheetObj.EtcData("cod_rjct_cd"));
		ComSetObjValue(formObj.confirmFlg,		sheetObj.EtcData("confirmFlg")); 
		ComSetObjValue(formObj.cod_mnl_flg,		sheetObj.EtcData("cod_mnl_flg")); 
		ComSetObjValue(formObj.auto_cod_flg,	sheetObj.EtcData("auto_cod_flg")); 
		changeObjectColor(ComGetObjValue(formObj.cod_mnl_flg), "Y", "cod_mnl_flg", "red", "black"); 

		if (ComIsEmpty(sheetObj.EtcData("cod_rjct_cd"))){
			ComSetObjValue(formObj.codRjctCd,"-1");
		}else{			 
			ComSetObjValue(formObj.codRjctCd,	sheetObj.EtcData("cod_rjct_cd")); 
			ComSetObjValue(formObj.cod_rjct_cd,	sheetObj.EtcData("cod_rjct_cd")); 			 
		}
		ComSetObjValue(formObj.codRjctRsnRmk,	sheetObj.EtcData("codRjctRsnRmk"));		
		ComSetObjValue(formObj.bkgStsCd,		sheetObj.EtcData("bkgStsCd"));
		 
		with(sheetObjects[1]){
			CellValue2(1,prefix2+"por_cd")     = sheetObj.EtcData("oldPorCd");
			CellValue2(1,prefix2+"por_nod_cd") = sheetObj.EtcData("oldPorNodCd");
			CellValue2(1,prefix2+"pol_cd")     = sheetObj.EtcData("oldPolCd");
			CellValue2(1,prefix2+"pol_nod_cd") = sheetObj.EtcData("oldPolNodCd");
			CellValue2(1,prefix2+"pod_cd")     = sheetObj.EtcData("oldPodCd");
			CellValue2(1,prefix2+"pod_nod_cd") = sheetObj.EtcData("oldPodNodCd");
			CellValue2(1,prefix2+"del_cd")     = sheetObj.EtcData("oldDelCd");
			CellValue2(1,prefix2+"del_nod_cd") = sheetObj.EtcData("oldDelNodCd");
			CellValue2(1,prefix2+"de_term_cd") = sheetObj.EtcData("oldDeTermCd");
            CellValue2(1,prefix2+"pre_cd")     = sheetObj.EtcData("oldPreCd");
			CellValue2(1,prefix2+"pre_nod_cd") = sheetObj.EtcData("oldPreNodCd");
			CellValue2(1,prefix2+"pst_cd")     = sheetObj.EtcData("oldPstCd");
			CellValue2(1,prefix2+"pst_nod_cd") = sheetObj.EtcData("oldPstNodCd");
			CellValue2(1,prefix2+"tvvd")       = sheetObj.EtcData("oldTvvd");

			if (sheetObjects[6].Rows ==0){
				CellValue2(2,prefix2+"por_cd")		= sheetObj.EtcData("oldPorCd");
				CellValue2(2,prefix2+"por_nod_cd") 	= sheetObj.EtcData("oldPorNodCd");
				CellValue2(2,prefix2+"pol_cd")		= sheetObj.EtcData("oldPolCd");
				CellValue2(2,prefix2+"pol_nod_cd") 	= sheetObj.EtcData("oldPolNodCd");
				CellValue2(2,prefix2+"pod_cd") 		= sheetObj.EtcData("oldPodCd");
				CellValue2(2,prefix2+"pod_nod_cd") 	= sheetObj.EtcData("oldPodNodCd");
				CellValue2(2,prefix2+"del_cd") 		= sheetObj.EtcData("oldDelCd");
				CellValue2(2,prefix2+"del_nod_cd") 	= sheetObj.EtcData("oldDelNodCd");
				CellValue2(2,prefix2+"de_term_cd")  = sheetObj.EtcData("oldDeTermCd");
				pcBtnColor("RED");
			}else{
				CellValue2(2,prefix2+"por_cd")		= sheetObj.EtcData("newPorCd");
				CellValue2(2,prefix2+"por_nod_cd") 	= sheetObj.EtcData("newPorNodCd");
				CellValue2(2,prefix2+"pol_cd") 		= sheetObj.EtcData("newPolCd");
				CellValue2(2,prefix2+"pol_nod_cd") 	= sheetObj.EtcData("newPolNodCd");
				CellValue2(2,prefix2+"pod_cd") 		= sheetObj.EtcData("newPodCd");
				CellValue2(2,prefix2+"pod_nod_cd") 	= sheetObj.EtcData("newPodNodCd");
				CellValue2(2,prefix2+"del_cd") 		= sheetObj.EtcData("newDelCd");
				CellValue2(2,prefix2+"del_nod_cd") 	= sheetObj.EtcData("newDelNodCd");
				CellValue2(2,prefix2+"de_term_cd")  = sheetObj.EtcData("newDeTermCd");
				if(ComIsEmpty(sheetObj.EtcData("pctl_no"))){
					pcBtnColor("RED");
					ComSetObjValue(formObj.pctl_no,"");
					ComSetObjValue(formObj.map_seq,"");
				} else {
					pcBtnColor("BLACK");
					ComSetObjValue(formObj.pctl_no,sheetObj.EtcData("pctl_no"));
					ComSetObjValue(formObj.map_seq,sheetObj.EtcData("map_seq"));
				}
	 	    }
			if (ComIsEmpty(sheetObj.EtcData("newPorCd"))){
				CellValue2(2,prefix2+"por_cd")= sheetObj.EtcData("oldPorCd");
			}else{
				CellValue2(2,prefix2+"por_cd")= sheetObj.EtcData("newPorCd");
			}
			
			if (ComIsEmpty(sheetObj.EtcData("newPorCd"))){
				CellValue2(2,prefix2+"por_nod_cd") = sheetObj.EtcData("oldPorNodCd");
			}else{
				CellValue2(2,prefix2+"por_nod_cd") = sheetObj.EtcData("newPorNodCd");
			}
			
			if (ComIsEmpty(sheetObj.EtcData("newPolCd"))){
				CellValue2(2,prefix2+"pol_cd") = sheetObj.EtcData("oldPolCd");
			}else{
				CellValue2(2,prefix2+"pol_cd") = sheetObj.EtcData("newPolCd");
			}
			
			if (ComIsEmpty(sheetObj.EtcData("newPolCd"))){
				CellValue2(2,prefix2+"pol_nod_cd") = sheetObj.EtcData("oldPolNodCd");
			}else{
				CellValue2(2,prefix2+"pol_nod_cd") = sheetObj.EtcData("newPolNodCd");
			}
			
			if (ComIsEmpty(sheetObj.EtcData("newPodCd"))){
				CellValue2(2,prefix2+"pod_cd") = sheetObj.EtcData("oldPodCd");
			}else{
				CellValue2(2,prefix2+"pod_cd") = sheetObj.EtcData("newPodCd");
			}
			
			if (ComIsEmpty(sheetObj.EtcData("newPodCd"))){
				CellValue2(2,prefix2+"pod_nod_cd") = sheetObj.EtcData("oldPodNodCd");
			}else{
				CellValue2(2,prefix2+"pod_nod_cd") = sheetObj.EtcData("newPodNodCd");
			}
			
			if (ComIsEmpty(sheetObj.EtcData("newDelCd"))){
				CellValue2(2,prefix2+"del_cd") = sheetObj.EtcData("oldDelCd");
			}else{
				CellValue2(2,prefix2+"del_cd") = sheetObj.EtcData("newDelCd");
			}

			if (ComIsEmpty(sheetObj.EtcData("newDelCd"))){
				CellValue2(2,prefix2+"del_nod_cd") = sheetObj.EtcData("oldDelNodCd");
			}else{
				CellValue2(2,prefix2+"del_nod_cd") = sheetObj.EtcData("newDelNodCd");
			}			
			if (ComIsEmpty(sheetObj.EtcData("newDeTermCd"))){
				CellValue2(2,prefix2+"de_term_cd") = sheetObj.EtcData("oldDeTermCd");
			}else{
				CellValue2(2,prefix2+"de_term_cd") = sheetObj.EtcData("newDeTermCd");
			}			
			
            CellValue2(2,prefix2+"pre_cd") = sheetObj.EtcData("newPreCd");
			CellValue2(2,prefix2+"pre_nod_cd") = sheetObj.EtcData("newPreNodCd");
			CellValue2(2,prefix2+"pst_cd") = sheetObj.EtcData("newPstCd");
			CellValue2(2,prefix2+"pst_nod_cd") = sheetObj.EtcData("newPstNodCd");

			if (ComIsEmpty(sheetObj.EtcData("newTvvd"))){
				CellValue2(2,prefix2+"tvvd") =sheetObj.EtcData("oldTvvd");
			}else{
				CellValue2(2,prefix2+"tvvd") =sheetObj.EtcData("newTvvd");
			}			
		 }
		
		// 2017.09.04 iylee POD가 변경되었는지 DEL이 변경되었는지 여부
		if(sheetObj.EtcData("oldPodCd") != sheetObj.EtcData("newPodCd")){
			ComSetObjValue(formObj.changePodFlg,"Y");
		}
		if(sheetObj.EtcData("oldDelCd") != sheetObj.EtcData("newDelCd")){
			ComSetObjValue(formObj.changeDelFlg,"Y");
		}
	}

	function setNewRouteFromPrd(sXml, formObj){	
		var arrXml = sXml.split("|$$|");
		var State = ComGetEtcData(arrXml[0], ComWebKey.Trans_Result_Key);
		if(State != "S"){
			ComSetObjValue(formObj.pctl_no, "");
			ComSetObjValue(formObj.map_seq, "");
			ComSetObjValue(formObj.cod_mnl_flg, "");  

			pcBtnColor("RED");
			return;
		} else {
			pcBtnColor("BLACK");
		}
		
		// request 이후에는 pctl_no만 바꿔준다
		if (!ComIsNull(formObj.codStsCd)&&"R"==ComGetObjValue(formObj.codStsCd)){
			ComSetObjValue(formObj.pctl_no, ComGetEtcData(arrXml[0], "pctl_no"));
			ComSetObjValue(formObj.map_seq, ComGetEtcData(arrXml[0], "map_seq"));			
			return
		}
		for(var i = 0; i < arrXml.length; i++){
			sheetObjects[i + 5].Redraw = false;  
			sheetObjects[i + 5].LoadSearchXml(arrXml[i]);
			sheetObjects[i + 5].Redraw = true
		}
		
		ComSetObjValue(formObj.cod_rhnd_port_cd, sheetObjects[5].EtcData("cod_rhnd_port_cd"));
		ComSetObjValue(formObj.pctl_no,          sheetObjects[5].EtcData("pctl_no"));
		ComSetObjValue(formObj.map_seq,          sheetObjects[5].EtcData("map_seq"));
		ComSetObjValue(formObj.cod_mnl_flg,      sheetObjects[5].EtcData("cod_mnl_flg"));
		if(sheetObjects[5].EtcData("rgn_cd")!=null){
			if(sheetObjects[5].EtcData("rgn_cd").length==3){
				ComSetObjValue(formObj.rgn_cd,			 sheetObjects[5].EtcData("rgn_cd"));
			}
		}
		
		changeObjectColor(ComGetObjValue(formObj.cod_mnl_flg), "Y", "cod_mnl_flg", "red", "black"); 
		
		for(iRow=1;iRow<sheetObjects[0].Rows;iRow++){
			if(sheetObjects[0].CellValue(iRow, prefix1+"chk")==1){
				if(sheetObjects[5].EtcData(sheetObjects[0].CellValue(iRow,prefix1+"cntr_no"))!="undefined"){
					sheetObjects[0].CellValue2(iRow,prefix1+"cntr_stwg_no") = sheetObjects[5].EtcData(sheetObjects[0].CellValue(iRow,prefix1+"cntr_no"));
				}
			}
		}
		
		for(var iRow=1;iRow<sheetObjects[5].Rows;iRow++){
			sheetObjects[5].CellValue2(iRow, prefix6+"bkg_no")      = ComGetObjValue(formObj.bkg_no);
			sheetObjects[5].CellValue2(iRow, prefix6+"cod_rqst_seq")= ComGetObjValue(formObj.cod_rqst_seq);
			sheetObjects[5].CellValue2(iRow, prefix6+"vvd_op_cd")   = "O";
		}

		for(var iRow=1;iRow<sheetObjects[6].Rows;iRow++){
			sheetObjects[6].CellValue2(iRow, prefix7+"bkg_no")      = ComGetObjValue(formObj.bkg_no);
			sheetObjects[6].CellValue2(iRow, prefix7+"cod_rqst_seq")= ComGetObjValue(formObj.cod_rqst_seq);
			sheetObjects[6].CellValue2(iRow, prefix7+"vvd_op_cd")   = "N";
		}
		with(sheetObjects[1]){
			CellValue2(2,prefix2+"tvvd")        = sheetObjects[5].EtcData("newTvvd");
			CellValue2(2,prefix2+"pod_cd") 		= sheetObjects[5].EtcData("newPodCd");
			CellValue2(2,prefix2+"pod_nod_cd") 	= sheetObjects[5].EtcData("newPodNodCd");
			CellValue2(2,prefix2+"del_cd") 		= sheetObjects[5].EtcData("newDelCd");
			CellValue2(2,prefix2+"del_nod_cd") 	= sheetObjects[5].EtcData("newDelNodCd");
			CellValue2(2,prefix2+"pre_cd")      = sheetObjects[5].EtcData("newPreCd");
			CellValue2(2,prefix2+"pre_nod_cd")  = sheetObjects[5].EtcData("newPreNodCd");
			CellValue2(2,prefix2+"pst_cd")      = sheetObjects[5].EtcData("newPstCd");
			CellValue2(2,prefix2+"pst_nod_cd")  = sheetObjects[5].EtcData("newPstNodCd");
		}
		return true;
	}

	/*
	* eml의 항목들을 setting
	*/
	function setEmlCtnt(sXml){
		var formObj = document.form;
		
		formObj.eml_header.value 		= ComGetEtcData(sXml, "header");
		formObj.rhnd_vvd.value 			= ComGetEtcData(sXml, "rhnd_vvd");
		formObj.rhnd_vvd_nm.value 		= ComGetEtcData(sXml, "vsl_nm");
		formObj.rhnd_vvd_voyage.value 	= ComGetEtcData(sXml, "voyage_no");
		formObj.rhnd_port_cd.value 		= ComGetEtcData(sXml, "new_pod");
		formObj.rhnd_vvd_old_pol.value 		= ComGetEtcData(sXml, "old_pol");
		formObj.rhnd_vvd_old_pol_nm.value 	= ComGetEtcData(sXml, "old_pol_nm");
		formObj.rhnd_vvd_old_pod.value 		= ComGetEtcData(sXml, "old_pod");
		formObj.rhnd_vvd_old_pod_nm.value 	= ComGetEtcData(sXml, "old_pod_nm");
		formObj.rhnd_vvd_new_pod.value 		= ComGetEtcData(sXml, "new_pod");
		formObj.rhnd_vvd_new_pod_nm.value 	= ComGetEtcData(sXml, "new_pod_nm");
	}
	
	/*
	* T/S Route 호출시 전달 Sheet에 값대입
	*/
	function RouteToSheet(sheetObj,prefix){
		if (ComIsEmpty(sheetObj.CellValue(1,prefix+"vsl_pre_pst_cd"))){
			return;
		}
		sheetObjects[7].RemoveAll(); 
		sheetObjects[7].Rows = 	sheetObj.Rows;
		for(var iRow=1;iRow<sheetObj.Rows;iRow++){
			with(sheetObjects[7]){			
				CellValue2(iRow,"vsl_pre_pst_cd") =sheetObj.CellValue(iRow,prefix+"vsl_pre_pst_cd");
				CellValue2(iRow,"vsl_seq")=sheetObj.CellValue(iRow,prefix+"vsl_seq");
				CellValue2(iRow,"pol_cd")=sheetObj.CellValue(iRow,prefix+"pol_yd_cd").substring(0,5);
				if (!ComIsEmpty(sheetObj.CellValue(iRow,prefix+"pol_yd_cd"))){
					CellValue2(iRow,"pol_yd_cd")=sheetObj.CellValue(iRow,prefix+"pol_yd_cd").substring(5,8);
				}
				
				CellValue2(iRow,"pod_cd")=sheetObj.CellValue(iRow,prefix+"pod_yd_cd").substring(0,5);
				if (!ComIsEmpty(sheetObj.CellValue(iRow,prefix+"pod_yd_cd"))){
					CellValue2(iRow,"pod_yd_cd")=sheetObj.CellValue(iRow,prefix+"pod_yd_cd").substring(5,8);
				}
				 
				CellValue2(iRow,"bkg_vvd_cd")=sheetObj.CellValue(iRow,prefix+"vsl_cd")+sheetObj.CellValue(iRow,prefix+"skd_voy_no")+sheetObj.CellValue(iRow,prefix+"skd_dir_cd");
				CellValue2(iRow,"pol_clpt_ind_seq")=sheetObj.CellValue(iRow,prefix+"pol_clpt_ind_seq");
				CellValue2(iRow,"pod_clpt_ind_seq")=sheetObj.CellValue(iRow,prefix+"pod_clpt_ind_seq");
			}
		}
	}

	function sheet2_OnClick(sheetObj,row, col, Value, CellX, CellY, CellW, CellH){
		var col_name = sheetObj.ColSaveName(col);
		var formObj = document.form; 
		 
		ComSetObjValue(formObj.bkg_por_cd,   sheetObj.CellValue(row,prefix2+"por_cd"));	
		ComSetObjValue(formObj.bkg_por_yd_cd,sheetObj.CellValue(row,prefix2+"por_nod_cd"));
		ComSetObjValue(formObj.bkg_pol_cd,   sheetObj.CellValue(row,prefix2+"pol_cd"));
		ComSetObjValue(formObj.bkg_pol_yd_cd,sheetObj.CellValue(row,prefix2+"pol_nod_cd"));
		ComSetObjValue(formObj.bkg_pod_cd,   sheetObj.CellValue(row,prefix2+"pod_cd"));
		ComSetObjValue(formObj.bkg_pod_yd_cd,sheetObj.CellValue(row,prefix2+"pod_nod_cd"));
		ComSetObjValue(formObj.bkg_del_cd,   sheetObj.CellValue(row,prefix2+"del_cd"));
		ComSetObjValue(formObj.bkg_del_yd_cd,sheetObj.CellValue(row,prefix2+"del_nod_cd"));		

		var param="?bkg_no="+ComGetObjValue(formObj.bkg_no);
			param+="&bkgTrunkVvd="+sheetObjects[1].CellValue(2,prefix2+"tvvd");
			param+="&ca_flg=";
			param+="&pgmNo=ESM_BKG_0092";
		if(row==1){
			param+="&displayOnly=Y";
			RouteToSheet(sheetObjects[5],prefix6);
		}else{
			if(!ComIsNull(formObj.codStsCd)){
				param+="&displayOnly=Y";				
			}
			RouteToSheet(sheetObjects[6],prefix7);
			formObj.routeRow.value=sheetObjects[6].LastRow;
		}
		param+="&callSheetIdx=7";

		switch(col_name) {		
			case prefix2+"detail":
				ComOpenPopup("/hanjin/ESM_BKG_0092.do"+param, 700, 490, 'callBack0092','1,0,1,1,1', true);
			break;
		}  
	}

	function sheet2_OnChange(sheetObj,Row, Col, Value){
		with(sheetObj){
			pcBtnColor("RED");
			if (ColSaveName(Col)==prefix2+"pod_cd"){
				sheetObjects[1].CellValue2(2,prefix2+"pod_nod_cd") 	= "";
			}
			if (ColSaveName(Col)==prefix2+"del_cd"){
				sheetObjects[1].CellValue2(2,prefix2+"del_nod_cd") 	= "";
			}
			if (ColSaveName(Col)==prefix2+"pod_cd" ||ColSaveName(Col)==prefix2+"pod_nod_cd"){
				sheetObjects[6].CellValue(sheetObjects[6].LastRow,prefix7+"pod_yd_cd")=ComRpad(CellValue(Row,prefix2+"pod_cd"),5," ")+CellValue(Row,prefix2+"pod_nod_cd");
			}
			if (ColSaveName(Col)==prefix2+"tvvd"){
				if(Value==null||Value.length==0){
					for(var i=0;i<sheetObjects[6].Rows;i++){
						if(sheetObjects[6].CellValue(i, prefix7+"vsl_pre_pst_cd")=="T"){
							sheetObjects[6].CellValue(i, prefix7+"vsl_cd")    ="";
							sheetObjects[6].CellValue(i, prefix7+"skd_voy_no")="";
							sheetObjects[6].CellValue(i, prefix7+"skd_dir_cd")="";
							sheetObjects[6].CellValue(i, prefix7+"slan_cd")   ="";
						}						
					}
				} else {
					for(var i=0;i<sheetObjects[6].Rows;i++){
						if(sheetObjects[6].CellValue(i, prefix7+"vsl_pre_pst_cd")=="T"){
							sheetObjects[6].CellValue(i, prefix7+"vsl_cd")    =Value.substring(0,4);
							sheetObjects[6].CellValue(i, prefix7+"skd_voy_no")=Value.substring(4,8);
							sheetObjects[6].CellValue(i, prefix7+"skd_dir_cd")=Value.substring(8,9);
							sheetObjects[6].CellValue(i, prefix7+"slan_cd")   ="";
						}						
					}					 
				}
				var formObj = document.form;
				ComSetObjValue(formObj.route_modify_flag,"Y");
			}
		}
	}
	
	/*
	* ESM_BKG_0975 팝업창 호출
	*/
	function sheet3_OnPopupClick(sheetObj, row, col){
		var col_name = sheetObj.ColSaveName(col);
		var formObj = document.form; 
		switch(col_name) {
			case prefix3+"chg_cd":
				var url = "ESM_BKG_0975.do?isPop=Y&pgmNo=ESM_BKG_0975";
				url+="&chg_cd="+sheetObj.CellValue(row, prefix3+"chg_cd");
				ComOpenWindowCenter(url, "ESM_BKG_0975", 650, 630, false);
			break;
		} 		
	}

	/*
	* Reject Reason Combo Change
	*/
	function cod_rjct_cd_OnChange(comboObj, code, text){
		var formObj = document.form; 
		comboObj.Code2 =ComGetObjValue(formObj.codRjctCd);
	}
	
	function cod_rhnd_port_cd_OnChange(){
		var formObj = document.form; 
		//search Rso
		doActionIBSheet(sheetObjects[0],formObj,COMMAND14);
	}
   
	/*
	* 그룹웨어메일 변수 초기화
   	*/
	function groupMailClear(){
		var formObj = document.form;
		ComClearObject(formObj.gw_subject);
		ComClearObject(formObj.gw_contents); 
		var args = document.getElementsByName("gw_args");
	   
		for(var i=0;i<args.length;i++){
			args[i].value="";
		}
	}

	/*
	 * 그룹웨어메일 변수 대입
	 */
	function groupMailset(status){
		var formObj = document.form;
		var emlSubject="";
		var emlHeader="";
		var emlContent1="";
		var emlContent2="";
		var cntrNoList="";
		var emlSpclContent=""; 
		var emlBody="";
		
		if(status=="R"){
			emlSubject = "COD Application";
			emlHeader = "Please be advised that COD application has been received as followings:<BR>\n";
		} else if(status=="F"){
			emlSubject = "COD Confirm Notice";
			emlHeader = "Please be advised that below COD has been confirmed by Booking Office:<BR>\n";
		} else if(status=="C"){
			emlSubject = "COD Cancel Notice";
			emlHeader = "Please be advised that below COD application has been withdrawn:<BR>\n";
		}
		emlSubject = formObj.eml_header.value; 
		
		emlContent1= "* Vessel : " + formObj.rhnd_vvd_nm.value + "<BR>\n" +
					 "* Voyage : " + formObj.rhnd_vvd_voyage.value + "<BR>\n" +
					 "* BKG No : " + formObj.bkg_no.value + "<BR>\n" +
					 "* Container No. :\n"
		
        var sRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
		var checkRow = sRow.split("|");
		cntrNoList = "<table border=1><tr align=center>" + 
					 "<td width=120>Container No.</td>" +
					 "<td width=60>TPSZ</TD>" +
					 "<td width=100>Weight</TD>" +
					 "<td width=40>DG</TD>" +
					 "<td width=40>RF</TD>" +
					 "<td width=40>AK</TD>" +
					 "<td width=40>BB</TD>" +
					 "<td width=40>SOC</TD></TR>\n";
		for(var i=0;i<checkRow.length-1;i++){
			cntrNoList = cntrNoList + 
					"<tr align=center>" +
					"<td>"+  sheetObjects[0].CellValue(checkRow[i],prefix1+"cntr_no")     +"</td>" +
					"<td>"+  sheetObjects[0].CellValue(checkRow[i],prefix1+"cntr_tpsz_cd")+"</td>" +
					"<td>"+  sheetObjects[0].CellValue(checkRow[i],prefix1+"cntr_wgt")    +"</td>" +
					"<td>"+((sheetObjects[0].CellValue(checkRow[i],prefix1+"dcgo_flg")==0)?"N":"Y")+"</td>" +
					"<td>"+((sheetObjects[0].CellValue(checkRow[i],prefix1+"rc_flg")  ==0)?"N":"Y")+"</td>" +
					"<td>"+((sheetObjects[0].CellValue(checkRow[i],prefix1+"awk_cgo_flg")  ==0)?"N":"Y")+"</td>" +
					"<td>"+"N"+"</td>" +
					"<td>"+((sheetObjects[0].CellValue(checkRow[i],prefix1+"soc_flg") ==0)?"N":"Y")+"</td>" +
					"</tr>\n";
		}
		cntrNoList = cntrNoList + "</table>\n";

		emlContent2 = "* Port of Loading on VVD : " + formObj.rhnd_vvd_old_pol.value.substring(0,5) + "(" + formObj.rhnd_vvd_old_pol_nm.value + ")" + "<BR>\n" + 
					  "* OLD Port of Discharging on VVD : " + formObj.rhnd_vvd_old_pod.value.substring(0,5) + "(" + formObj.rhnd_vvd_old_pod_nm.value + ")" + "<BR>\n" +
					  "* NEW Port of Discharging on VVD : " + formObj.rhnd_vvd_new_pod.value.substring(0,5) + "(" + formObj.rhnd_vvd_new_pod_nm.value + ")" + "<BR>\n";
		
		var dgEmlCtnt = "";
		var rfEmlCtnt = "";
		var akEmlCtnt = "";
		for(var i=0;i<checkRow.length-1;i++){
			if(sheetObjects[0].CellValue(checkRow[i], prefix1+"dcgo_flg")=="1"){
				dgEmlCtnt = dgEmlCtnt + sheetObjects[0].CellValue(checkRow[i], prefix1+"dg_eml_ctnt");
			}

			if(sheetObjects[0].CellValue(checkRow[i], prefix1+"rc_flg")=="1"){
				rfEmlCtnt = rfEmlCtnt + sheetObjects[0].CellValue(checkRow[i], prefix1+"rf_eml_ctnt");
			}
			
			if(sheetObjects[0].CellValue(checkRow[i], prefix1+"awk_cgo_flg")=="1"){
				akEmlCtnt = akEmlCtnt + sheetObjects[0].CellValue(checkRow[i], prefix1+"ak_eml_ctnt");
			}
		}

		if(dgEmlCtnt!=null && dgEmlCtnt.length>10){
			emlSpclContent = emlSpclContent + 
					   "----------------------------------------------------------------------------------------------" +"\n"+ 
					   "<BR>" +"\n"+
					   "[ Dangerous Cargo ]<BR>" + dgEmlCtnt + "<BR>\n";
		}
		if(rfEmlCtnt!=null && rfEmlCtnt.length>10){
			emlSpclContent = emlSpclContent + 
					   "----------------------------------------------------------------------------------------------" +"\n"+ 
					   "<BR>" +"\n"+
					   "[ Reefer Cargo ]<BR>" +
					   "<table width=765 border=1>" +
					   "<TR><td width=120>Container No</TD><td width=400>Commodity</TD><td width=120>Temperature</TD><TD width=120>Ventilation</TD><TR>" + 
					   rfEmlCtnt + "\n"
					   "</table><BR>\n";
		}

		if(akEmlCtnt!=null && akEmlCtnt.length>10){
			emlSpclContent = emlSpclContent + 
					   "----------------------------------------------------------------------------------------------" +"\n"+ 
					   "<BR>" +"\n"+
					   "[ Awkward Cargo ]<BR>" + akEmlCtnt + "<BR>\n";
		}
			
		emlBody = emlHeader + "<BR>" + 
					emlContent1 + "<BR>" + 
					cntrNoList + "<BR>" + 
					emlContent2 + "<BR>";

		if(emlSpclContent.length>0){
			emlBody = emlBody + "<BR>" + 
					"[ Special Cargo Information ]" + "<BR>\n" +
					emlSpclContent + "<BR>";
		}
					
//		alert(emlSubject+"\n\n"+emlBody);
  		ComBkgGroupMailset(sheetObjects[0], formObj, emlSubject, emlBody);
   }

   /*
   * CntroNo,SpcCarGo 파라메트 생성함수
   */
   function setCntrSpc(){
	   var sCntr="";
	   var sDg="";
	   var sBb="";
	   var sAk="";
	   var sRf="";
	   var rtn="";
	   
	   with(sheetObjects[0]){
		   for(var i=1;i<Rows;i++){
			    if (CellValue(i,prefix1+"chk")==1){
					sCntr+=CellValue(i,prefix1+"cntr_no")+"~";
					if (CellValue(i,prefix1+"dcgo_flg")==1){
						sDg+=CellValue(i,prefix1+"cntr_no")+"~";
					}
					if (CellValue(i,prefix1+"bb_cgo_flg")==1){
						sBb+=CellValue(i,prefix1+"cntr_no")+"~";
					}
					if (CellValue(i,prefix1+"awk_cgo_flg")==1){
						sAk+=CellValue(i,prefix1+"cntr_no")+"~";
					} 
					if (CellValue(i,prefix1+"rc_flg")==1){
						sRf+=CellValue(i,prefix1+"cntr_no")+"~";
					}  
			    }
		   }
	   }
	   rtn="&codCntrNo="+sCntr+"&codDg="+sDg+"&codBb="+sBb+"&codAk="+sAk+"&codRF="+sRf;
	   return rtn;
   }
   	
//   /*
//   	* Remark PopUp 후 값이 있으면 버튼 색상변경
//   	*/
//   	function btnColor(){ 
//	   if (!ComIsEmpty(document.form.codRemark)){
//		   ComBtnColor("btn_remark","blue");
//	   }else{
//		   ComBtnColor("btn_remark","#737373");	
//	   }
//	   
//   	}

	function pcBtnColor(color){
		var formObj = document.form;
		if(ComGetObjValue(document.form.popFlg)!="C"){
			if(color=="RED"){
				ComBtnColor("btn_pc","red");
				ComSetObjValue(formObj.pctl_no,"");
				ComSetObjValue(formObj.map_seq,"");			
			} else {
				ComBtnColor("btn_pc","#737373");
			}
		}
	}
	
	/*
	* 조건에 따른버튼 활성화
	*/
    function btnEnable(formObj){
		//disable
		// cod remark, retrieve, new, history, add는 항상 가능 
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_del");
		ComBtnDisable("btn_request");
		ComBtnDisable("btn_approve");
		ComBtnDisable("btn_cancel");
		ComBtnDisable("btn_confirm");
		ComBtnDisable("btn_pc");
		ComBtnDisable("btn_main");
		ComBtnDisable("btn_bkg_main");	
		ComBtnDisable("btn_calculation");
		if (ComGetObjValue(formObj.saveModeCd) =="U"){
			ComBtnEnable("btn_calculation");
		}
		if (ComGetObjValue(formObj.auto_cod_flg) == "Y"){
			ComBtnDisable("btn_pc"); 
			ComBtnDisable("btn_bkg_main");	
			ComBtnDisable("btn_calculation");
			// POD가 변경됐을 때
			if(ComGetObjValue(formObj.changePodFlg) == "Y"){
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_request");
			// DEL만 변경됐을 때
			} else if(ComGetObjValue(formObj.changeDelFlg) == "Y"){
				ComBtnEnable("btn_save");
			}
				
		} else if (ComIsNull(formObj.codStsCd)){
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_del");		
			ComBtnEnable("btn_pc");
			if (ComGetObjValue(formObj.saveModeCd) =="U"){
				ComBtnEnable("btn_request");
			}
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="M"){//Manual
			if(ComGetObjValue(formObj.cod_mnl_flg).toUpperCase()=="Y"){
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_approve");
				ComBtnEnable("btn_cancel");
				ComBtnEnable("btn_pc");
			}
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="R"){//REQUEST
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_cancel");			
			ComBtnEnable("btn_pc");
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="Y"){//APPROVE
			ComBtnEnable("btn_cancel");
			ComBtnEnable("btn_confirm");
			//모든 cntr이 선택되있고, bdr일 때만 bkg main 비활성화
        	var sRow = sheetObjects[0].FindCheckedRow(prefix1+"chk");
        	var checkRow = sRow.split("|");
			if((checkRow.length-1)==(sheetObjects[0].Rows-1)){
				if (formObj.bdr_flag.checked){ 
					ComBtnEnable("btn_bkg_main");	
				}
			}
		}else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="W"){//WAIT
			ComBtnEnable("btn_cancel");			
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="C"){//CANCEL

		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="N"){//REJECT
			
		} else if(ComGetObjValue(formObj.codStsCd).toUpperCase()=="F"){//FIRM
			
		}
		if(ComIsNull(ComTrim(ComGetObjValue(formObj.codStsCd)))){
			sheetObjects[1].Editable = true;
		} else {
			sheetObjects[1].Editable = false;			
		}
		// auto c/a case
        if(ComGetObjValue(formObj.cod_rqst_rsn_cd) == "AU"
        	|| ComGetObjValue(formObj.cod_rqst_rsn_cd) == "TS"){
			ComBtnDisable("btn_pc");
			ComBtnDisable("btn_bkg_main");	
		}
	}	 
	
    /**
    * CA Reason 후속 처리 : CaReasonModify
    */ 
    function setCAReasonCallBack(arrPopupData) {
        var formObj = document.form;
   		var srcName = window.event.srcElement.getAttribute("name");
   		
    	//01. CA ReasonCd, Remark 입력정보 받아서,
    	var strRsnCd  = nullToBlank(arrPopupData[0][2]);
    	var strRemark = nullToBlank(arrPopupData[0][3]);
        
    	//02. modifyCaReason(e) call
        formObj.ca_rsn_cd.value = strRsnCd;
        formObj.ca_remark.value = strRemark;		
    }

	// ESD_PRD_018 호출후 Return 받는값.(PCTL_NO)
	function callBackEsdPrd0080(pctlNo){
		var formObj = document.form;
		if(pctlNo.length<20){
			ComSetObjValue(formObj.pctl_no,"");
			ComSetObjValue(formObj.map_seq,"");
			pcBtnColor("RED");
		} else {
			var arrXml = pctlNo.split("|");
			ComSetObjValue(formObj.pctl_no,arrXml[0]);
			if(arrXml.length>1) ComSetObjValue(formObj.map_seq, arrXml[1]);
			pcBtnColor("BLACK");
		}
	}    	

	/**
     * Route Detail 처리 후 작업 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0092();
     * </pre>
     * @param Popup에서 전달받은 값
     */
    function callBack0092(){    
    	var formObj = document.form;
		var sheetObj = sheetObjects[7];
		if(sheetObj.Rows==1){
			sheetObjects[1].CellValue2(2,prefix2+"pre_cd") 		= "";
    		sheetObjects[1].CellValue2(2,prefix2+"pre_nod_cd") 	= "";
    		sheetObjects[1].CellValue2(2,prefix2+"pst_cd") 		= "";
    		sheetObjects[1].CellValue2(2,prefix2+"pst_nod_cd") 	= "";
    		
			sheetObjects[6].RemoveAll();
    		sheetObjects[6].DataInsert(0);
    		sheetObjects[6].CellValue2(1,prefix7+"vsl_pre_pst_cd") = "T";
    		sheetObjects[6].CellValue2(1,prefix7+"vsl_seq")        = "1";
    		sheetObjects[6].CellValue2(1,prefix7+"pol_yd_cd")      = sheetObjects[1].CellValue(2,prefix2+"pol_cd") + sheetObjects[1].CellValue(2,prefix2+"pol_nod_cd");
			sheetObjects[6].CellValue2(1,prefix7+"pod_yd_cd")	   = sheetObjects[1].CellValue(2,prefix2+"pod_cd") + sheetObjects[1].CellValue(2,prefix2+"pod_nod_cd");
			sheetObjects[6].CellValue2(1,prefix7+"vsl_cd") 		   = sheetObjects[1].CellValue(2,prefix2+"tvvd").substring(0,4);
			sheetObjects[6].CellValue2(1,prefix7+"skd_voy_no") 	   = sheetObjects[1].CellValue(2,prefix2+"tvvd").substring(4,8);
			sheetObjects[6].CellValue2(1,prefix7+"skd_dir_cd") 	   = sheetObjects[1].CellValue(2,prefix2+"tvvd").substring(8);
			return;
		}
		
		for(var iRow=1;iRow<sheetObj.Rows;iRow++){ 
			if(ComTrim(sheetObj.CellValue(iRow,"pol_cd")).length!=5||ComTrim(sheetObj.CellValue(iRow,"pod_cd")).length!=5){
				sheetObj.RowDelete(iRow,false);		
			}
		}
		
		// 01. PrePostCd가 'T' 인 Vvd를 Main에 넣는다.
		sheetObjects[1].CellValue2(2,prefix2+"tvvd")=sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd");

		// 01-01. PRE RELAY 입력
		if(sheetObj.Rows>1){
	    	if(sheetObj.FindText("vsl_pre_pst_cd","T") > 1){
	    		sheetObjects[1].CellValue2(2,prefix2+"pre_cd") 		= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_cd");
	    		sheetObjects[1].CellValue2(2,prefix2+"pre_nod_cd") 	= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_yd_cd");
	    	}
		}
		// 01-02. POST REPAY 입력
		if(sheetObj.FindText("vsl_pre_pst_cd","T")>0){
	    	if(sheetObj.FindText("vsl_pre_pst_cd","T")+1 < sheetObj.Rows){
	    		sheetObjects[1].CellValue2(2,prefix2+"pst_cd") 		= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_cd");
	    		sheetObjects[1].CellValue2(2,prefix2+"pst_nod_cd") 	= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_yd_cd");
	    	} else {
	    		sheetObjects[1].CellValue2(2,prefix2+"pst_cd") 		= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_cd");
    			sheetObjects[1].CellValue2(2,prefix2+"pst_nod_cd") 	= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_yd_cd");
	    	}
     	} else {
     		sheetObjects[1].CellValue2(2,prefix2+"pst_cd") 		= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_cd");
     		sheetObjects[1].CellValue2(2,prefix2+"pst_nod_cd") 	= sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_yd_cd");
    	}
		if (ComGetObjValue(formObj.bkg_pod_cd)!=sheetObj.CellValue(sheetObj.RowCount,"pod_cd") 
			|| ComGetObjValue(formObj.bkg_pod_yd_cd)!=sheetObj.CellValue(sheetObj.RowCount,"pod_yd_cd")
			|| ComParseInt(formObj.routeRow.value)!=sheetObj.LastRow){
		} 
    	// 02. Main POD가 없다면 마지막데이터의 POD를 넣는다.
		sheetObjects[1].CellValue2(2,prefix2+"pod_cd") 		= sheetObj.CellValue(sheetObj.RowCount,"pod_cd");
		sheetObjects[1].CellValue2(2,prefix2+"pod_nod_cd") 	= sheetObj.CellValue(sheetObj.RowCount,"pod_yd_cd");
        
		sheetObjects[6].Rows = sheetObj.Rows;
		sheetObjects[6].RemoveAll();
		for(var iRow=1;iRow<sheetObj.Rows;iRow++){
			sheetObjects[6].DataInsert(-1);
			sheetObjects[6].CellValue2(iRow,prefix7+"vsl_pre_pst_cd") 	= sheetObj.CellValue(iRow,"vsl_pre_pst_cd");
			sheetObjects[6].CellValue2(iRow,prefix7+"vsl_seq") 			= sheetObj.CellValue(iRow,"vsl_seq");
			sheetObjects[6].CellValue2(iRow,prefix7+"pol_yd_cd") 		= sheetObj.CellValue(iRow,"pol_cd")+sheetObj.CellValue(iRow,"pol_yd_cd");
			sheetObjects[6].CellValue2(iRow,prefix7+"pod_yd_cd") 		= sheetObj.CellValue(iRow,"pod_cd")+sheetObj.CellValue(iRow,"pod_yd_cd");
			sheetObjects[6].CellValue2(iRow,prefix7+"pol_clpt_ind_seq") = sheetObj.CellValue(iRow,"pol_clpt_ind_seq");
			sheetObjects[6].CellValue2(iRow,prefix7+"pod_clpt_ind_seq") = sheetObj.CellValue(iRow,"pod_clpt_ind_seq");
			sheetObjects[6].CellValue2(iRow,prefix7+"vsl_cd") 			= sheetObj.CellValue(iRow,"bkg_vvd_cd").substring(0,4);
			sheetObjects[6].CellValue2(iRow,prefix7+"skd_voy_no") 		= sheetObj.CellValue(iRow,"bkg_vvd_cd").substring(4,8);
			sheetObjects[6].CellValue2(iRow,prefix7+"skd_dir_cd") 		= sheetObj.CellValue(iRow,"bkg_vvd_cd").substring(8);
			sheetObjects[6].CellValue2(iRow,prefix7+"bkg_no") 			= ComGetObjValue(formObj.oldBkgNo);
			sheetObjects[6].CellValue2(iRow,prefix7+"cod_rqst_seq") 	= ComGetObjValue(formObj.cod_rqst_seq);
			sheetObjects[6].CellValue2(iRow,prefix7+"vvd_op_cd") 		= "N";
		}	
		
		ComSetObjValue(formObj.route_modify_flag,"Y");
    }       
	
	function callBackCaCancel(){
		//message 처리
	}
	
	function callBackCaConfirm(){
		//Complete COD CA
		doActionIBSheet(sheetObjects[8],document.form,COMMAND06);	
	}

   /*
   	* ESM_BKG_0997에서 호출하는 함수
   	*/
   	function callSearch(){
   		//Complete COD CA
		doActionIBSheet(sheetObjects[8],document.form,COMMAND06);	
   	}
   	
   	
    /*
     * 자동 Cargo Release 처리
    	* POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
    	*/
    	function chagnePodCondition(){
    	   	
 	    var formObj = document.form;
 	    var sheetObjCgoRlse = sheetObjects[0];
 	    var bl_no = formObj.bl_no.value;
 	    
 	    formObj.f_cmd.value = SEARCH05;
 	    var params = FormQueryString(formObj);
 	    var sXml = sheetObjCgoRlse.GetSearchXml("ESM_BKG_0909GS.do", params);
 	    
 	    //Hold B/L 인가    
 	    do_hld_flg = ComGetEtcData(sXml, "do_hld_flg");
 	    
 	    //CR 전송한 적이 있는가  
 	    cr_chk_flg = ComGetEtcData(sXml, "cr_chk_flg");
     
 	}
 	 
     /*
     * 자동 Cargo Release 처리
    	* POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
    	*/
    	function podChange(old_pod_cd,new_pod_cd){
    	
 	    var formObj = document.form;
 	    var sheetObjCgoRlse = sheetObjects[0];
 	    var bl_no = formObj.bl_no.value;
 	       		
 	    //HOLD되지 않고, CR발송된 적이 있음. CR처리 가능한 조건
 		if ( do_hld_flg == "N"  && cr_chk_flg == "Y" ) {
 			
 			formObj.f_cmd.value = MULTI02;
 			var params = "?bl_no="+bl_no+"&new_pod_cd="+new_pod_cd+"&old_pod_cd="+old_pod_cd+"&event_id=D&"+FormQueryString(formObj);
 			ComOpenWait(true);
 			var sXml = sheetObjCgoRlse.GetSaveXml("ESM_BKG_0909GS.do", params) ;
 			ComOpenWait(false);
 				
 			if ("ERROR"==sXml.substring(1,6)){
 				ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
 			} else {
 				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
 					ComShowCodeMessage("BKG00166");
 					return;
 				}
 			}
 		}	
 					    
    }
				
    
//  /*
//  	* COD cntr_no에 대해 이전 순번에 대해 체크 못하게 하는 함수
//  	*/
//  	function gridChk(){
//  		with(sheetObjects[0]){
//  			for(var iRow=1;iRow<Rows;iRow++){
//  				if (CellValue(iRow,prefix1+"reserved_cntr_flg")=="1"){
//  					CellEditable(iRow,prefix1+"chk")=false;
//  					CellBackColor(iRow,prefix1+"reserved_cntr_flg")=CellBackColor(iRow,prefix1+"cntr_no");
//  				}
//  			}
//  		}
//  	}

	/*
	* Sheet 화면 깜박거리 없애는 처리
	*/
//	function sheet5_OnLoadFinish(sheetObj) {  
		/*if (ComGetObjValue(document.form.popFlg)=="S"){
//			sheetObjects[0].WaitImageVisible = false;  
//			doActionIBSheet(sheetObjects[0],document.form,COMMAND01);   
//			document.form.cod_rqst_seq.selectedIndex=document.form.oldCodRqstSeq.value;
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
//			sheetObjects[0].WaitImageVisible = true;   
		}*/
//	}
	
	
// 이전 버전 MAIL FORMAT
//	for(var iRow=1;iRow<sheetObjects[5].Rows;iRow++){
//		if (iRow==1){
//			oldRoute +="   - "+iRow+"st VVD : "; 
//		}else if (iRow==2){
//			oldRoute +="   - "+iRow+"nd VVD : "; 
//		}else if (iRow==3){
//			oldRoute +="   - "+iRow+"rd VVD : "; 
//		}else{
//			oldRoute +="   - "+iRow+"th VVD : "; 
//		}
//
//        oldRoute +=sheetObjects[5].CellValue(iRow,prefix6+"vsl_cd"); 
//		oldRoute +=sheetObjects[5].CellValue(iRow,prefix6+"skd_voy_no");
//        oldRoute +=sheetObjects[5].CellValue(iRow,prefix6+"skd_dir_cd"); 
//		oldRoute +="     POL : "+sheetObjects[5].CellValue(iRow,prefix6+"pol_yd_cd");
//		oldRoute +="     POD : "+sheetObjects[5].CellValue(iRow,prefix6+"pod_yd_cd")+"\n";
//	}
//	
//	for(var iRow=1;iRow<sheetObjects[6].Rows;iRow++){
//		if (iRow==1){
//			newRoute +="   - "+iRow+"st VVD : ";         
//		}else if (iRow==2){
//			newRoute +="   - "+iRow+"nd VVD : "; 
//		}else if (iRow==3){
//			newRoute +="   - "+iRow+"rd VVD : "; 
//		}else{
//			newRoute +="   - "+iRow+"th VVD : "; 
//		}			
//
//        newRoute +=sheetObjects[6].CellValue(iRow,prefix7+"vsl_cd"); 
//		newRoute +=sheetObjects[6].CellValue(iRow,prefix7+"skd_voy_no");
//        newRoute +=sheetObjects[6].CellValue(iRow,prefix7+"skd_dir_cd"); 
//		newRoute +="     POL : "+sheetObjects[6].CellValue(iRow,prefix7+"pol_yd_cd");
//		newRoute +="     POD : "+sheetObjects[6].CellValue(iRow,prefix7+"pod_yd_cd")+"\n";
//	}
	
//	emlContent = "Please be advised that <" + title + "> has been received as followings :<BR>" +"\n"+
//				   "<BR>" +"\n"+
//				   "• BKG No : " + ComGetObjValue(formObj.bkg_no) + "<BR><BR>" +"\n"+
//				   "• Container No. : " + cntrNoList + "<BR>" +"\n"+
//				   "<BR>" +"\n"+
//				   "• Now Reads (Old Route)<BR>" + oldRoute + "<BR>" +"\n"+
//				   "<BR>" +"\n"+
//				   "<BR>" +"\n"+
//				   "• Should Read (New Route)<BR>" + newRoute + "<BR>" +"\n"+
//				   "<BR>" +"\n"+
//				   "<BR>" +"\n"+
//				   "• Re-Handling Port : " + ComGetObjValue(formObj.cod_rhnd_port_cd) + "<BR>" +"\n"+ 
//				   "<BR>";	
	/* 개발자 작업  끝 */
	
	