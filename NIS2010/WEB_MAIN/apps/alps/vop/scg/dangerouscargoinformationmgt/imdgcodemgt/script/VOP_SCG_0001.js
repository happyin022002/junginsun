/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0001.js
*@FileTitle : UN Number (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.14 이도형
* 1.0 Creation
* =========================================================
*History
* 2013.05.08 김현화 [CHM-201324585]DG Packing Instruction 기능 적용. 
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
     * @class vop_scg_0001 : vop_scg_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
		this.obj_keypress			= obj_keypress;    	    	
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

	var comboObjNm = new Array();
	
	var tabIndex = 0;
    var tabLoad = new Array();
    tabLoad[0]= 0;
    tabLoad[1]= 0;
    tabLoad[2]= 0;
    tabLoad[3]= 0;

	var objNmSeq = new Array();
	objNmSeq[0] = "n1st";
	objNmSeq[1] = "n2nd";
	objNmSeq[2] = "n3rd";
	objNmSeq[3] = "n4th";
	objNmSeq[4] = "n5th";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/          
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	var formObject = document.form;
    	/*******************************************************/

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
    			case "btn_Retrieve":
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    				break;
 					
 				case "btn_New":
 					clearAll();
 					break;

 				case "btn_Copy":
         			ComShowCodeMessage('SCG50028');
 					copy();
 					break;

 				case "btn_Delete":
    				doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
 					break;

 				case "btn_Save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					break;

 				case "btn_SeqPrev":
 					unNoSeqPrev();
 					break;

 				case "btn_SeqNext":
 					unNoSeqNext();
 					break;

 				case "btn_AutoCreation":
 					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC07);	//AutoCreation
 					//AutoCreation한 내용을 Auto Segregation테이블에 복사한다.
 					sheetObjects[1].Copy2SheetCol(sheetObjects[2]);

 					break;

 				case "btn_imdg_spcl_provi_no1": case "btn_imdg_spcl_provi_no2": case "btn_imdg_spcl_provi_no3": case "btn_imdg_spcl_provi_no4": case "btn_imdg_spcl_provi_no5": case "btn_imdg_spcl_provi_no6": case "btn_imdg_spcl_provi_no7": case "btn_imdg_spcl_provi_no8":
	 				onPopupClick(srcName);
 					break;

 				case "frm_segr_as_for_imdg_clss_flg":
 					segrClssFlg();
 					break;

 				case "frm_away_fm_imdg_clss_flg":
 					awayClssFlg();
 					break;
 					
 				case "frm_sprt_fm_imdg_clss_flg":
 					sprtClssFlg();
 					break;

 				case "frm_sprt_hld_fm_imdg_clss_flg":
 					sprtHldClssFlg();
 					break;
 					
 				case "frm_sprt_lon_fm_imdg_clss_flg":
 					sprtLonClssFlg();
 					break;

 				case "frm_away_fm_imdg_segr_grp_flg":
 					awaySegrGrpFlg();
 					break;

 				case "frm_sprt_fm_imdg_segr_grp_flg":
 					sprtSegrGrpFlg();
 					break;
 					
 				case "btns_n1st_imdg_pck_instr_cd": case "btns_n2nd_imdg_pck_instr_cd": case "btns_n3rd_imdg_pck_instr_cd":
 					openFile(srcName);
 					break;
 					
 				case "btns_n1st_imdg_pck_provi_cd": case "btns_n2nd_imdg_pck_provi_cd": case "btns_n3rd_imdg_pck_provi_cd":  case "btns_n4th_imdg_pck_provi_cd": case "btns_n5th_imdg_pck_provi_cd":
 					openFile(srcName);
 					break;
 					
 				case "btns_n1st_imdg_ibc_instr_cd": case "btns_n2nd_imdg_ibc_instr_cd": case "btns_n3rd_imdg_ibc_instr_cd":  case "btns_n4th_imdg_ibc_instr_cd": case "btns_n5th_imdg_ibc_instr_cd":
 					openFile(srcName);
 					break;
 					
 				case "btns_n1st_imdg_ibc_provi_cd": case "btns_n2nd_imdg_ibc_provi_cd": case "btns_n3rd_imdg_ibc_provi_cd":  case "btns_n4th_imdg_ibc_provi_cd": case "btns_n5th_imdg_ibc_provi_cd":
 					openFile(srcName);
 					break;
 					
 				case "btns_n1st_imdg_un_tnk_instr_cd": case "btns_n2nd_imdg_un_tnk_instr_cd":
 					openFile(srcName);
 					break;
 					
 				case "btns_n1st_imdg_tnk_instr_provi_cd": case "btns_n2nd_imdg_tnk_instr_provi_cd": case "btns_n3rd_imdg_tnk_instr_provi_cd":  case "btns_n4th_imdg_tnk_instr_provi_cd": case "btns_n5th_imdg_tnk_instr_provi_cd":
 					openFile(srcName);
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
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }

     /**
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
      **/
     function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
     }


     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
    	 // combo
    	 combo1 = comboObjects[0];
    	 comboCnt = comboObjects.length;	                      

         for(i=0;i<sheetObjects.length;i++){
        	 //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

         // IBMultiCombo초기화
         for(var k=0; k<comboObjects.length; k++){
        	 initCombo(comboObjects[k], k + 1);
         }
         
         //html컨트롤 이벤트초기화
         initControl();

     }

     function sheet1_OnLoadFinish(sheetObj) {
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	//UN Class
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);	//Excepted Q'ty, Away from SG/Separated from SG 
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08);	//Marine pollutant
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC09);	//Packing group
         sheetObjects[1].DataInsert(-1);
         //팝업여부와 초기 조회
         if(preConds.pop_yn == 'Y') {
        	 //체크박스 활성
        	 sheetObjects[0].ColHidden(1) = false;
        	 //초기 조건 셋팅
	         if(preConds.imdg_un_no != '' || preConds.imdg_un_no_seq != '') {	         	
	         	if(preConds.imdg_un_no != '') ComSetObjValue(document.form.imdg_un_no, preConds.imdg_un_no);
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
	         	if(preConds.imdg_un_no_seq != '') ComSetObjValue(document.form.imdg_un_no_seq, preConds.imdg_un_no_seq);	            
	         	//PopUp일경우 Creation 버튼 비활성화 시킨다.	
	         	ComBtnDisable('btn_Copy');
	            ComBtnDisable('btn_Delete');
	            ComBtnDisable('btn_Save');
	         	//조회
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	         }
         }
     }

     /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

    	 var cnt = 0;
    	 var sheetID = sheetObj.id;

         switch(sheetID) {

         case "sheet1":
        	 with (sheetObj) {

      			// 높이 설정
      			style.height = 0;
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
      			InitColumnInfo(169, 0, 0, true);

     			// 해더에서 처리할 수 있는 각종 기능을 설정한다
     			InitHeadMode(true, true, false, true, false,false)
      			
      			//UN No.|Seq.|Proper Shipping Name
                var HeadTitle1  = "|Sel|UN No.|Seq.|SML\nRes.|PSN|Class or Division|Class or Division|Subsidiary risk(s)|Subsidiary risk(s)|" 
                	HeadTitle1 += "Subsidiary risk(s)|Subsidiary risk(s)|Mrn P|SRL R|PakGrp|Special Provisions|Special Provisions|Special Provisions|Special Provisions|Special Provisions|"
                	HeadTitle1 += "Special Provisions|Special Provisions|Special Provisions|Limited Q'ty|Limited Q'ty|Limited Q'ty Desc|Exc Q'ty|Exc Q'ty Desc|EmS No.|Stwg Cd|"
                	HeadTitle1 += "F Point|ERG|ERG|PSA No.|BPT|BPT|BPT|BPT|LPK|SLPA|"
     				HeadTitle1 += "PPT Desc|RQ|PIZ Cd|TOXIC|Dangerous when wet|Port Rest.|OPR Rest.|Extend Class.|HCDG|Depends on Q'ty |" 
     				HeadTitle1 += "HCDG\nRemarks|Packing Instructions|Packing Instructions|Packing Instructions|Packing provisions|Packing provisions|Packing provisions|Packing provisions|Packing provisions|IBC Instructions|" 
     				HeadTitle1 += "IBC Instructions|IBC Instructions|IBC Instructions|IBC Instructions|IBC provisions|IBC provisions|IBC provisions|IBC provisions|IBC provisions|UN Tank Instructions|" 
 					HeadTitle1 += "UN Tank Instructions|Tank Special Provisions|Tank Special Provisions|Tank Special Provisions|Tank Special Provisions|Tank Special Provisions|Packaging|Intermediate Bulk|Tank|Stowage and Segregation|" 
					HeadTitle1 += "Clear of Living Q'tr|Foodstuffs|Source of Heat|Segregation as for|Segregation as for|Away from Class|Away from Class|Separated from Class|Separated from Class|Separated by comptmnt or hold fm Class|" 
     				HeadTitle1 += "Separated by comptmnt or hold fm Class|Separated longtdn’ly fm Class|Separated longtdn’ly fm Class|Segregation Groups|Segregation Groups|Segregation Groups|Segregation Groups|Away from SG|Away from SG|Separated from SG|" 
     				HeadTitle1 += "Separated from SG|Classification|Technical Name|Concentration (%)|Packing Method|Control Temp (℃)|Emergency Temp (℃)";
     			
                var HeadTitle2  = "|Sel|UN No.|Seq.|SML\nRes.|PSN|Class|CompGrp|Class1|Class2|" 
                	HeadTitle2 += "Class3|Class4|Mrn P|SRL R|PakGrp|ProviNo1|ProviNo2|ProviNo3|ProviNo4|ProviNo5|" 
                	HeadTitle2 += "ProviNo6|ProviNo7|ProviNo8|Q'ty|UtCd|Limited Q'ty Desc|Exc Q'ty|Exc Q'ty Desc|EmS No.|Stwg Cd|"
                	HeadTitle2 += "F Point|ERG1|ERG2|PSA No.|BPT1|BPT2|BPT3|BPT4|LPK|SLPA|"
            		HeadTitle2 += "PPT Desc|RQ|PIZ Cd|TOXIC|Dangerous when wet|Port Rest.|OPR Rest.|Extend Class.|HCDG|Depends on Q'ty |" 
        			HeadTitle2 += "HCDG\nRemarks|Packing Instructions1|Packing Instructions2|Packing Instructions3|Packing provisions1|Packing provisions2|Packing provisions3|Packing provisions4|Packing provisions5|IBC Instructions1|" 
                	HeadTitle2 += "IBC Instructions2|IBC Instructions3|IBC Instructions4|IBC Instructions5|IBC provisions1|IBC provisions2|IBC provisions3|IBC provisions4|IBC provisions5|UN Tank Instructions1|" 
                	HeadTitle2 += "UN Tank Instructions2|Tank Special Provisions1|Tank Special Provisions2|Tank Special Provisions3|Tank Special Provisions4|Tank Special Provisions5|Packaging|Intermediate Bulk|Tank|Stowage and Segregation|" 
                	HeadTitle2 += "Clear of Living Q'tr|Foodstuffs|Source of Heat|flg|Class|flg|Class|flg|Class|flg|" 
                	HeadTitle2 += "Class|flg|Class|Groups1|Groups2|Groups3|Groups4|flg|Class|flg|" 
                	HeadTitle2 += "Class|Classification|Technical Name|Concentration (%)|Packing Method|Control Temp (℃)|Emergency Temp (℃)";

      			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
      			InitHeadRow(0, HeadTitle1, true);
      			InitHeadRow(1, HeadTitle2, true);

    			var prefix = "sheet1_";
 	 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	 			InitDataProperty(0, cnt++ , dtStatus,		30,    	daCenter,  	true,  "ibflag");
 	 			InitDataProperty(0, cnt++ , dtDelCheck, 	30,    	daCenter,   true,  "del_chk",					false,  "",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50,		daCenter,   true,  "imdg_un_no", 				false,	"",      dfNone,	0,     true,		true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_un_no_seq",  			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50,		daCenter,   true,  "imdg_crr_rstr_expt_nm", 	false,	"",      dfNone,	0,     true,		true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50,		daCenter,   true,  "prp_shp_nm", 				true,	"",      dfNone,	0,     true,		true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_clss_cd",  			true,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_comp_grp_cd", 			false,	"",      dfNone,    0,     true,    	true);            		 
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_subs_rsk_lbl_cd1", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_subs_rsk_lbl_cd2", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_subs_rsk_lbl_cd3", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_subs_rsk_lbl_cd4", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_mrn_polut_cd", 	 	false,	"",      dfNone,    0,     true,    	true); 	 			
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_subs_rsk_lbl_rmk", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_pck_grp_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no1", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no2", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no3", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no4", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no5", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no6", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no7", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_spcl_provi_no8", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_lmt_qty", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_lmt_qty_meas_ut_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_lmt_qty_desc", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_expt_qty_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_expt_qty_desc", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_emer_no", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_stwg_cate_cd", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "flsh_pnt_temp_ctnt", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "emer_rspn_gid_no", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "emer_rspn_gid_chr_no", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "psa_no", 					false,	"",      dfNone,    0,     true,    	true); 	 			
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_bom_port_trst_no", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_bom_port_trst_no", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_bom_port_trst_no", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_bom_port_trst_no", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "pkg_auth_no", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "lk_port_auth_no", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_sbst_ppt_desc", 		false,	"",      dfNone,    0,     true,    	true);
 	 			//TAB2
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "cfr_rpt_qty", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "cfr_psn_inh_zn_cd", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "cfr_toxc_cd", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "cfr_dg_wet_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "cfr_rstr_port_nm", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "cfr_rstr_opr_nm", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "cfr_xtd_clss_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_flg", 					false,	"",      dfNone,    0,     true,    	true); 	 			
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_dpnd_qty_flg", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_rmk", 					false,	"",      dfNone,    0,     true,    	true);
 	 			//TAB3
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_pck_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_pck_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_pck_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_pck_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_pck_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_pck_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_pck_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_pck_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_ibc_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_ibc_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_ibc_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_ibc_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_ibc_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_ibc_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_ibc_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_ibc_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_ibc_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_ibc_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_un_tnk_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_un_tnk_instr_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_tnk_instr_provi_cd",	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_tnk_instr_provi_cd",	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_tnk_instr_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_tnk_instr_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_tnk_instr_provi_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_pck_rstr_desc", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_intmd_bc_rstr_desc", 		false,	"",      dfNone,    0,     true,    	true); 	 			
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_tnk_rstr_desc", 			false,	"",      dfNone,    0,     true,    	true);
 	 			//TAB4
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "segr_desc", 					false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,    		50, 	daCenter, 	true,  "clr_liv_qtr_stwg_flg", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_fd_stuf_stwg_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_ht_src_stwg_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "segr_as_for_imdg_clss_flg", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,    		50, 	daCenter, 	true,  "segr_as_for_imdg_clss_cd", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "away_fm_imdg_clss_flg", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "away_fm_imdg_clss_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "sprt_fm_imdg_clss_flg", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "sprt_fm_imdg_clss_cd",			false,	"",      dfNone,    0,     true,    	true);

 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "sprt_hld_fm_imdg_clss_flg", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "sprt_hld_fm_imdg_clss_cd", 		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "sprt_lon_fm_imdg_clss_flg", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "sprt_lon_fm_imdg_clss_cd",		false,	"",      dfNone,    0,     true,    	true);
 	 			
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_tnk_rstr_desc1", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_tnk_rstr_desc2", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_tnk_rstr_desc3", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "hcdg_tnk_rstr_desc4", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "away_fm_imdg_segr_grp_flg", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "away_dp_seq", 					false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "sprt_fm_imdg_segr_grp_flg", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "sprt_dp_seq", 					false,	"",      dfNone,    0,     true,    	true);
 	 			//TAB5
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_org_ract_tp_cd", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_tec_nm", 					false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_conc_rt_ctnt", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_pck_mzd_cd", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_ctrl_temp", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "imdg_emer_temp", 				false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_subs_rsk_lbl_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_subs_rsk_lbl_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_subs_rsk_lbl_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_subs_rsk_lbl_cd", 	false,	"",      dfNone,    0,     true,    	true);
 	 			//HIDDEN COLUMN
 	 			InitDataProperty(0, cnt++ , dtCheckBox,    	50, 	daCenter, 	true,  "imdg_un_no_hld_flg", 			false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "upd_usr_id", 					false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "upd_dt", 						false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "upd", 							false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_pck_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_pck_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_pck_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_pck_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_pck_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_pck_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_pck_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_pck_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_ibc_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_ibc_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_ibc_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_ibc_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_ibc_instr_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_ibc_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_ibc_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_ibc_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_ibc_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_ibc_provi_file",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_un_tnk_instr_file",	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_un_tnk_instr_file",	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_tnk_instr_provi_file",false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_tnk_instr_provi_file",false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_tnk_instr_provi_file",false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_tnk_instr_provi_file",false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_tnk_instr_provi_file",false,	"",      dfNone,    0,     true,    	true);
 	 			
	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_pck_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_pck_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_pck_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_pck_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_pck_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_pck_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_pck_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_pck_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_ibc_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_ibc_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_ibc_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_ibc_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_ibc_instr_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_ibc_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_ibc_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_ibc_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_ibc_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_ibc_provi_seq",		false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_un_tnk_instr_seq",	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_un_tnk_instr_seq",	false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n1st_imdg_tnk_instr_provi_seq", false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n2nd_imdg_tnk_instr_provi_seq", false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n3rd_imdg_tnk_instr_provi_seq", false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n4th_imdg_tnk_instr_provi_seq", false,	"",      dfNone,    0,     true,    	true);
 	 			InitDataProperty(0, cnt++ , dtData,        	50, 	daCenter, 	true,  "n5th_imdg_tnk_instr_provi_seq", false,	"",      dfNone,    0,     true,    	true);

        	 }
             break;                 
         
         case "sheet2":      //sheet2 init
        	 with (sheetObj) {
        		 // 높이 설정
        		 style.height = 42;
        		 //전체 너비 설정
        		 SheetWidth = mainTable.clientWidth;

        		 //Host정보 설정[필수][HostIp, Port, PagePath]
        		 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        		 
        		 //전체Merge 종류 [선택, Default msNone]
        		 MergeSheet = msNone;
        		 
        		 //전체Edit 허용 여부 [선택, Default false]
        		 Editable = true;
        		 
        		 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        		 InitRowInfo( 1, 1, 3, 100);
        		 
        		 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		 InitColumnInfo(22, 0, 0, true);
        		 
        		 // 해더에서 처리할 수 있는 각종 기능을 설정한다
        		 InitHeadMode(true, true, true, true, false,false)

        		 var HeadTitle = "|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9|upd";
        		 
        		 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        		 InitHeadRow(0, HeadTitle, true);

        		 
        		 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        		 InitDataProperty(0, cnt++ , dtHiddenStatus,	30, 	daCenter,	false,	"ibflag");
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_11",	false,	"",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_12",   false,	"",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_15",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_13",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_16",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_14",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_21",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_22",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_23",   false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_3",    false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_41",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_42",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_43",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_51",   false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_52",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_61",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_62",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_7",    false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_8",    false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_9",    false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	false,	"upd",     		false,	"",      dfNone, 			0,     true,       true);
        		 
        		 InitDataValid(0, 1, vtNumericOther, "X*");
        		 InitDataValid(0, 2, vtNumericOther, "X*");
        		 InitDataValid(0, 3, vtNumericOther, "X*");
        		 InitDataValid(0, 4, vtNumericOther, "X*");
        		 InitDataValid(0, 5, vtNumericOther, "X*");
        		 InitDataValid(0, 6, vtNumericOther, "X*");
        		 InitDataValid(0, 7, vtNumericOther, "X*");
        		 InitDataValid(0, 8, vtNumericOther, "X*");
        		 InitDataValid(0, 9, vtNumericOther, "X*");
        		 InitDataValid(0, 10, vtNumericOther, "X*");
        		 InitDataValid(0, 11, vtNumericOther, "X*");
        		 InitDataValid(0, 12, vtNumericOther, "X*");
        		 InitDataValid(0, 13, vtNumericOther, "X*");
        		 InitDataValid(0, 14, vtNumericOther, "X*");
        		 InitDataValid(0, 15, vtNumericOther, "X*");
        		 InitDataValid(0, 16, vtNumericOther, "X*");
        		 InitDataValid(0, 17, vtNumericOther, "X*");
        		 InitDataValid(0, 18, vtNumericOther, "X*");
        		 InitDataValid(0, 19, vtNumericOther, "X*");
        		 InitDataValid(0, 20, vtNumericOther, "X*");

        		 SelectHighLight = false; 	// HighLight를 표시하지 않는다.
        		 CountPosition = 0;			// 건수 정보를 표시하지 않는다.
        	 }
        	 break;
        	 
         case "sheet3":      //sheet3 init
        	 with (sheetObj) {
        		 // 높이 설정
        		 style.height = 0;
        		 //전체 너비 설정
        		 SheetWidth = mainTable.clientWidth;

        		 //Host정보 설정[필수][HostIp, Port, PagePath]
        		 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        		 
        		 //전체Merge 종류 [선택, Default msNone]
        		 MergeSheet = msNone;
        		 
        		 //전체Edit 허용 여부 [선택, Default false]
        		 Editable = true;
        		 
        		 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        		 InitRowInfo( 1, 1, 3, 100);
        		 
        		 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		 InitColumnInfo(22, 0, 0, true);
        		 
        		 // 해더에서 처리할 수 있는 각종 기능을 설정한다
        		 InitHeadMode(true, true, true, true, false,false)

        		 var HeadTitle = "|1.1|1.2|1.5|1.3|1.6|1.4|2.1|2.2|2.3|3|4.1|4.2|4.3|5.1|5.2|6.1|6.2|7|8|9|upd";
        		 
        		 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        		 InitHeadRow(0, HeadTitle, true);

        		 
        		 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
        		 InitDataProperty(0, cnt++ , dtHiddenStatus,	30, 	daCenter,	false,	"ibflag");
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_11",	false,	"",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_12",   false,	"",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_15",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_13",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_16",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_14",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_21",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_22",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_23",   false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_3",    false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_41",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_42",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_43",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_51",   false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_52",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_61",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_62",   false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_7",    false,  "",      dfNone, 			0,     true,       true,	1);
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_8",    false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtData,			48.5,	daCenter,	false,	"clss_cd_9",    false,  "",      dfNone, 			0,     true,       true,	1); 						
        		 InitDataProperty(0, cnt++ , dtHidden,			30,		daCenter,	false,	"upd",     		false,	"",      dfNone, 			0,     true,       true);
        		 
        		 InitDataValid(0, 1, vtNumericOther, "X*");
        		 InitDataValid(0, 2, vtNumericOther, "X*");
        		 InitDataValid(0, 3, vtNumericOther, "X*");
        		 InitDataValid(0, 4, vtNumericOther, "X*");
        		 InitDataValid(0, 5, vtNumericOther, "X*");
        		 InitDataValid(0, 6, vtNumericOther, "X*");
        		 InitDataValid(0, 7, vtNumericOther, "X*");
        		 InitDataValid(0, 8, vtNumericOther, "X*");
        		 InitDataValid(0, 9, vtNumericOther, "X*");
        		 InitDataValid(0, 10, vtNumericOther, "X*");
        		 InitDataValid(0, 11, vtNumericOther, "X*");
        		 InitDataValid(0, 12, vtNumericOther, "X*");
        		 InitDataValid(0, 13, vtNumericOther, "X*");
        		 InitDataValid(0, 14, vtNumericOther, "X*");
        		 InitDataValid(0, 15, vtNumericOther, "X*");
        		 InitDataValid(0, 16, vtNumericOther, "X*");
        		 InitDataValid(0, 17, vtNumericOther, "X*");
        		 InitDataValid(0, 18, vtNumericOther, "X*");
        		 InitDataValid(0, 19, vtNumericOther, "X*");
        		 InitDataValid(0, 20, vtNumericOther, "X*");

        		 CountPosition = 0;		// 건수 정보를 표시하지 않는다.
        	 }
        	 break;        	 
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
            case IBSEARCH:      //조회
         		if(validateForm(sheetObj,formObj,sAction)) {
	        		formObj.f_cmd.value = SEARCH;
	        		
	    			var sXml = sheetObj.GetSearchXml("VOP_SCG_0001GS.do", FormQueryString(formObj));
	    			
	    			var arrXml = sXml.split("|$$|");
	    			
	    			for(var inx=0; inx<arrXml.length; inx++){
	    				sheetObjects[inx].LoadSearchXml(arrXml[inx]);
	    			}
	    			//Segregation Sheet에 조회된 데이타가 없으면 초기화 한다.
					if(arrXml[1].indexOf("TOTAL='0'") > 0){
          				sheetObjects[1].DataInsert(-1);
	    			}

	    			//Subsidiary risk(s) 셋팅
	    			var subRskLblList = ComGetEtcData(arrXml[0], "subRskLblList").split("|");
	    			for(var i=1 ; i < subRskLblList.length+1 ; i++ ) {
	    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,"imdg_subs_rsk_lbl_cd"+i) = subRskLblList[i-1];
	    				if (i == 1) {
		    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,"n1st_imdg_subs_rsk_lbl_cd") = subRskLblList[i-1];
	    				}else if (i == 2) {
		    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,"n2nd_imdg_subs_rsk_lbl_cd") = subRskLblList[i-1];
	    				}else if (i == 3) {
		    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,"n3rd_imdg_subs_rsk_lbl_cd") = subRskLblList[i-1];
	    				}else if (i == 4) {
		    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,"n4th_imdg_subs_rsk_lbl_cd") = subRskLblList[i-1];
	    				}
	    			}
					
	    			//Special Provisions 셋팅
	    			var spclProviList = ComGetEtcData(arrXml[0], "spclProviList").split("|");
	    			var spclProviDpSeq = null;
	    			for(var i=1 ; i < spclProviList.length+1 ; i++ ) {
	    				spclProviDpSeq = spclProviList[i-1].split("^");
	    				if (i==spclProviDpSeq[1]){
	    					sheetObjects[0].CellValue(sheetObj.LastRow,"imdg_spcl_provi_no"+i) = spclProviDpSeq[0];
	    				}
	    			}

	    			//Segregation Groups 셋팅
	    			var segrGrpDtlList = ComGetEtcData(arrXml[0], "segrGrpDtlList").split("|");
	    			for(var i=1 ; i < segrGrpDtlList.length+1 ; i++ ) {
	    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,"hcdg_tnk_rstr_desc"+i) = segrGrpDtlList[i-1];
	    			}

	    			//Away from Class/Separated from Class 셋팅
	    			var clssCdList = ComGetEtcData(arrXml[0], "clssCdList").split("|");
	    			var clssCode = null;
	    			var j = 1;
	    			var k = 1;
	    			var l = 1;
	    			var m = 1;
	    			var strAwayClssCode = "";
	    			var strSprtClssCode = "";
	    			var strSprtHldClssCode = "";
	    			var strSprtLonClssCode = "";
	    			for(var i=0 ; i < clssCdList.length ; i++ ) {
	    				clssCode = clssCdList[i].split("^");
	    				if (1==clssCode[1]) {
		    				if (j==clssCode[2]){
		    					if (j != 1) {
		    						strAwayClssCode += "/";
		    					}
		    					strAwayClssCode += clssCode[0];
		    				}
		    				j++;
	    				}else if (2==clssCode[1]){
		    				if (k==clssCode[2]){
		    					if (k != 1) {
		    						strSprtClssCode += "/";
		    					}
		    					strSprtClssCode += clssCode[0];
		    				}
		    				k++;
	    				}else if (3==clssCode[1]){
		    				if (l==clssCode[2]){
		    					if (l != 1) {
		    						strSprtHldClssCode += "/";
		    					}
		    					strSprtHldClssCode += clssCode[0];
		    				}
		    				l++;
	    				}else if (4==clssCode[1]){
		    				if (m==clssCode[2]){
		    					if (m != 1) {
		    						strSprtLonClssCode += "/";
		    					}
		    					strSprtLonClssCode += clssCode[0];
		    				}
		    				m++;
	    				}
	    			}
					sheetObjects[0].CellValue(sheetObj.LastRow,"away_fm_imdg_clss_cd") 	= strAwayClssCode;
					sheetObjects[0].CellValue(sheetObj.LastRow,"sprt_fm_imdg_clss_cd") 	= strSprtClssCode;
					sheetObjects[0].CellValue(sheetObj.LastRow,"sprt_hld_fm_imdg_clss_cd")= strSprtHldClssCode;
					sheetObjects[0].CellValue(sheetObj.LastRow,"sprt_lon_fm_imdg_clss_cd") 	= strSprtLonClssCode	    			
	    			//Away from SG/Separated from SG 셋팅
	    			var segrGrpList = ComGetEtcData(arrXml[0], "segrGrpList").split("|");
	    			var segrGrpCode = null;
	    			var j = 1;
	    			var k = 1;
	    			var strAwaySegrGrpCode = "";
	    			var strSprtSegrGrpCode = "";
	    			for(var i=0 ; i < segrGrpList.length ; i++ ) {
	    				segrGrpCode = segrGrpList[i].split("^");
	    				if (1==segrGrpCode[1]) {
		    				if (j==segrGrpCode[2]){
		    					if (j != 1) {
		    						strAwaySegrGrpCode += "/";
		    					}
		    					strAwaySegrGrpCode += segrGrpCode[0];
		    				}
		    				j++;
	    				}else if (2==segrGrpCode[1]){
		    				if (k==segrGrpCode[2]){
		    					if (k != 1) {
		    						strSprtSegrGrpCode += "/";
		    					}
		    					strSprtSegrGrpCode += segrGrpCode[0];
		    				}
		    				k++;
	    				}
	    			}
					sheetObjects[0].CellValue(sheetObj.LastRow,"away_dp_seq") = strAwaySegrGrpCode;
					sheetObjects[0].CellValue(sheetObj.LastRow,"sprt_dp_seq") = strSprtSegrGrpCode;
	    			
	    			//Sheet에서 html로 이동시킨다.
	    			ComScgCopyRowToForm(sheetObj, formObj, sheetObj.LastRow, "frm_");

	    			if (sheetObjects[0].CellValue(sheetObjects[0].LastRow,"imdg_mrn_polut_cd") == "") comboObjects[6].Text = "Blank";
	    			if (sheetObjects[0].CellValue(sheetObjects[0].LastRow,"imdg_pck_grp_cd") == "") comboObjects[7].Text = "Blank";
	    			
	    			formObj.frm_imdg_tec_nm_desc.value = formObj.frm_imdg_tec_nm.value;

	    			//조회된 값이 있을경우 비활성화된 콤보를 활성화 시킨다.
	    			if (formObj.frm_segr_as_for_imdg_clss_flg.checked == true) {
	    	  			comboObjects[10].Enable = true;
	    			}else{
	    	  			comboObjects[10].Enable = false;
	    			}
	    			if (formObj.frm_away_fm_imdg_clss_flg.checked == true) {
	    	  			comboObjects[11].Enable = true;
	    			}else{
	    	  			comboObjects[11].Enable = false;
	    			}
	    			if (formObj.frm_sprt_fm_imdg_clss_flg.checked == true) {
	    	  			comboObjects[12].Enable = true;
	    			}else{
	    	  			comboObjects[12].Enable = false;
	    			}
	    			if (formObj.frm_sprt_hld_fm_imdg_clss_flg.checked == true) {
	    	  			comboObjects[13].Enable = true;
	    			}else{
	    	  			comboObjects[13].Enable = false;
	    			}
	    			if (formObj.frm_sprt_lon_fm_imdg_clss_flg.checked == true) {
	    	  			comboObjects[14].Enable = true;
	    			}else{
	    	  			comboObjects[14].Enable = false;
	    			}
	    			if (formObj.frm_away_fm_imdg_segr_grp_flg.checked == true) {
	    	  			comboObjects[15].Enable = true;
	    			}else{
	    	  			comboObjects[15].Enable = false;
	    			}
	    			if (formObj.frm_sprt_fm_imdg_segr_grp_flg.checked == true) {
	    	  			comboObjects[16].Enable = true;
	    			}else{
	    	  			comboObjects[16].Enable = false;
	    			}

	    			if(arrXml[1].indexOf("TOTAL='0'") < 0){
		         		//AutoCreation을 호출해 Auto Segregation테이블에 AutoCreation값을 셋팅한다.
		         		doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC07);	//AutoCreation
	         		}
	    			
         		}
         		
        	   	break;
        	   	
            case IBDELETE:	//삭제
            	if (sheetObjects[0].LastRow > 1 && sheetObjects[0].CellValue(sheetObj.LastRow,"imdg_un_no") != "") {
	            	if(ComShowCodeConfirm('SCG50002', 'data')){
	            		sheetObjects[0].CellValue(sheetObjects[0].LastRow,"del_chk") = 1;

	            		if (sheetObj.LastRow < 2 || sheetObjects[0].CellValue(sheetObj.LastRow,"imdg_un_no") == "") {
	          				sheetObjects[0].DataInsert(-1);
	          			}

	            		//html에 있는 데이타를 Sheet로 이동시킨다.
	          			ComScgCopyFormToRow(formObj, sheetObj, sheetObj.LastRow, "frm_");
						sheetObjects[0].CellValue(sheetObjects[0].LastRow,"imdg_un_no") = formObj.imdg_un_no.value;
						sheetObjects[0].CellValue(sheetObjects[0].LastRow,"imdg_un_no_seq") = formObj.imdg_un_no_seq.value;
	          			
						sheetObjects[0].CellValue(sheetObjects[0].LastRow,"upd") = "U";
						sheetObjects[1].CellValue(sheetObjects[1].LastRow,"upd") = "U";

	          			formObj.f_cmd.value = MULTI;
	          			
	 	          		var sParam = ComGetSaveString(sheetObjects);
	  	                if (sParam == "") return;
	  	                sParam += "&" + FormQueryString(formObj);
	 	          		sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_"); 
	 	          	    sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_"); 
	 	          		
	 	          		var sXml = sheetObj.GetSaveXml("VOP_SCG_0001GS.do", sParam);
		                sheetObj.LoadSaveXml(sXml);

		                clearAll();
	            	}
            	}
            	break;

            case IBSAVE:	//저장
            	if(validateForm(sheetObj,formObj,sAction)) {
     				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
            		if (sheetObj.LastRow < 2 || sheetObjects[0].CellValue(sheetObj.LastRow,"imdg_un_no") == "") {
          				sheetObjects[0].DataInsert(-1);
          			}

            		//html에 있는 데이타를 Sheet로 이동시킨다.
          			ComScgCopyFormToRow(formObj, sheetObj, sheetObj.LastRow, "frm_");
					sheetObjects[0].CellValue(sheetObjects[0].LastRow,"imdg_un_no") = formObj.imdg_un_no.value;
					sheetObjects[0].CellValue(sheetObjects[0].LastRow,"imdg_un_no_seq") = formObj.imdg_un_no_seq.value;
          			
					sheetObjects[0].CellValue(sheetObjects[0].LastRow,"upd") = "U";
					sheetObjects[1].CellValue(sheetObjects[1].LastRow,"upd") = "U";

          			formObj.f_cmd.value = MULTI;
          			
 	          		var sParam = ComGetSaveString(sheetObjects);
  	                if (sParam == "") return;
  	                sParam += "&" + FormQueryString(formObj);
 	          		sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_"); 
 	          	    sParam += "&" + ComSetPrifix(sheetObjects[1].GetSaveString(), "sheet2_"); 
 	          		
 	          		var sXml = sheetObj.GetSaveXml("VOP_SCG_0001GS.do", sParam);
	                sheetObj.LoadSaveXml(sXml);
	                var befNo = formObj.imdg_un_no.value;
	                var befSeq = formObj.imdg_un_no_seq.value;
					clearBody();
		         	//조회
		            formObj.imdg_un_no.value = befNo;
		            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
		            formObj.imdg_un_no_seq.value = befSeq;
		            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

            	}
            	break;

 			case IBSEARCH_ASYNC01:   //UN Class.조회	

				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
				//Class
				ComXml2ComboItem(sXml, formObj.frm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd|imdg_clss_cd_desc");
				//Subsidiary Risk(s)
				ComXml2ComboItem(sXml, formObj.frm_imdg_subs_rsk_lbl_cd1, "imdg_clss_cd", "imdg_clss_cd");
				ComXml2ComboItem(sXml, formObj.frm_imdg_subs_rsk_lbl_cd2, "imdg_clss_cd", "imdg_clss_cd");
				ComXml2ComboItem(sXml, formObj.frm_imdg_subs_rsk_lbl_cd3, "imdg_clss_cd", "imdg_clss_cd");
				ComXml2ComboItem(sXml, formObj.frm_imdg_subs_rsk_lbl_cd4, "imdg_clss_cd", "imdg_clss_cd");

				//Extend Class.
				ComXml2ComboItem(sXml, formObj.frm_cfr_xtd_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
				//Segregation as for
				ComXml2ComboItem(sXml, formObj.frm_segr_as_for_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
				//Away from Class
				ComXml2ComboItem(sXml, formObj.frm_away_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
				//Separated from Class
				ComXml2ComboItem(sXml, formObj.frm_sprt_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
				//Separated by comptmnt or hold fm Class
				ComXml2ComboItem(sXml, formObj.frm_sprt_hld_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
				//Separated longtdn’ly fm Class
				ComXml2ComboItem(sXml, formObj.frm_sprt_lon_fm_imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd");
				
	    		break;

 			case IBSEARCH_ASYNC02:   //Excepted Q'ty 조회

				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0001GS.do", FormQueryString(formObj));
    			var arrXml = sXml.split("|$$|");
    			//Excepted Q'ty
    			ComXml2ComboItem(arrXml[0], formObj.frm_imdg_expt_qty_cd, "imdg_expt_qty_cd", "imdg_expt_qty_cd", "Y");
				//Away from SG
				ComXml2ComboItem(arrXml[1], formObj.frm_away_dp_seq, "imdg_segr_grp_no", "imdg_segr_grp_no");
				//Separated from SG
				ComXml2ComboItem(arrXml[1], formObj.frm_sprt_dp_seq, "imdg_segr_grp_no", "imdg_segr_grp_no");

				break;

 			case IBSEARCH_ASYNC03:   //Division of Class 조회

				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0047GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.frm_imdg_comp_grp_cd, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
				break;

 			case IBSEARCH_ASYNC04:   //UN No.조회
         		if(validateForm(sheetObj,formObj,sAction)) {
	                formObj.f_cmd.value = SEARCH01;
	    		    var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
	    		    var arrData = ComScgXml2Array(sXml, "imdg_un_no_seq|imdg_un_no_seq_max|imdg_un_no_seq_min|imdg_un_no_seq_cnt|upd_dt");

	    		    if (arrData != null && arrData.length > 0) {
	    		    	if (Col != "" && Col != null ) {
	    		    		formObj.imdg_un_no_seq.value = Col;
	    		    	}else{
		    		    	formObj.imdg_un_no_seq.value = arrData[0][0];	    		    		
	    		    	}
	   					formObj.imdg_un_no_seq_max.value = arrData[0][1];
	   					formObj.imdg_un_no_seq_min.value = arrData[0][2];
	   					formObj.imdg_un_no_seq_cnt.value = arrData[0][3];
					}else{
			 			if (ComShowCodeConfirm("SCG50027", formObj.imdg_un_no.value)) {
		   					formObj.imdg_un_no_seq.value = "1";
		   					formObj.imdg_un_no_seq_max.value = "";
		   					formObj.imdg_un_no_seq_min.value = "";
		   					formObj.imdg_un_no_seq_cnt.value = "";
		   					formObj.frm_prp_shp_nm.focus();
			 			}else{
		   					formObj.imdg_un_no.value = "";
		   					formObj.imdg_un_no_seq.value = "";
		   					formObj.imdg_un_no_seq_max.value = "";
		   					formObj.imdg_un_no_seq_min.value = "";
		   					formObj.imdg_un_no_seq_cnt.value = "";
		   					formObj.imdg_un_no.focus();
			 			}
					}
         		}
	    		break;

 			case IBSEARCH_ASYNC05:   //Special Provisions 체크
				formObj.f_cmd.value = SEARCH03;
    		    var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj)+"&imdg_spcl_provi_no="+event.srcElement.value);
    		    var arrData = ComScgXml2Array(sXml, "imdg_spcl_provi_no");
    		    if (arrData != null && arrData.length > 0) {
				}else{
					ComShowCodeMessage("SCG50008", 'Special Provisions Creation');
					event.srcElement.value = "";
    	 			ComSetFocus(event.srcElement);
				}
				break;

 			case IBSEARCH_ASYNC06:   //Packing / IBC / Tank Instructions & Provisions 체크
				formObj.f_cmd.value = SEARCH;
    		    var sXml = sheetObj.GetSearchXml("VOP_SCG_0042GS.do", FormQueryString(formObj)+"&imdg_pck_instr_cd="+event.srcElement.value);
    		    var arrData = ComScgXml2Array(sXml, "file_sav_id");
    		    if (arrData != null && arrData.length > 0) { 
    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,event.srcElement.name.replace("frm_","").replace('_cd','_file')) = arrData;
    				sheetObjects[0].CellValue(sheetObjects[0].LastRow,event.srcElement.name.replace("frm_","").replace('_cd','_seq')) = 1;
				}else{
					ComShowCodeMessage('SCG50008', 'Packing Instruction/Provision Creation');
					event.srcElement.value = "";
    	 			ComSetFocus(event.srcElement);
				}
				break;
	    		
 			case IBSEARCH_ASYNC07:   //Segregation Auto Creation
	 			if(!validateForm(sheetObj,formObj,sAction))return;
        		formObj.f_cmd.value = SEARCH02;
        		var param = "&msg_flg=Y";
        		if (sheetObj.id == "sheet3") param = "&msg_flg=N"; 
        		sheetObj.DoSearch("VOP_SCG_0001GS.do", FormQueryString(formObj)+param);
				sheetObjects[1].CellValue(sheetObjects[1].LastRow,"upd") = "U";
        	   	break;
	    		
 			case IBSEARCH_ASYNC08:   //Marine pollutant 조회

				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0039GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.frm_imdg_mrn_polut_cd, "imdg_mrn_polut_cd", "imdg_mrn_polut_cd");
				comboObjects[6].InsertItem(0, 'Blank','  '); 
				comboObjects[6].Text = "Blank";
				break;

 			case IBSEARCH_ASYNC09:   //Marine pollutant 조회

				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0040GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.frm_imdg_pck_grp_cd, "imdg_pck_grp_cd", "imdg_pck_grp_cd");
				comboObjects[7].SetText(1, 0, 'I'); 
				comboObjects[7].SetText(2, 0, 'II'); 
				comboObjects[7].SetText(3, 0, 'III'); 
				comboObjects[7].InsertItem(0, 'Blank','  '); 
				comboObjects[7].Text = "Blank";
				break;

 			case IBROWSEARCH:   //Packing / IBC / Tank Instructions & Provisions 체크
 				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0046GS.do" , FormQueryString(formObj)+"&imdg_segr_tp_cd=C"+"&imdg_segr_cd="+sheetObj.CellValue(Row,Col));				
    		    var arrData = ComScgXml2Array(sXml, "imdg_segr_cd");
    		    if (arrData != null && arrData.length > 0) {
				}else{
					ComShowCodeMessage("SCG50010", 'Data');
				    sheetObj.SelectCell(1, Col, true, "");
					return false;
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


     //업무 자바스크립트 OnKeyPress 이벤트 Catch
     function initControl() {
    	 axon_event.addListener('keydown',	'ComKeyEnter', 			'form');
    	 axon_event.addListener('change',	'clss_OnChange', 		'frm_imdg_clss_cd');
    	 axon_event.addListener('change', 	'subsRskLbl1_OnChange', 'frm_imdg_subs_rsk_lbl_cd1');
    	 axon_event.addListener('change', 	'subsRskLbl2_OnChange', 'frm_imdg_subs_rsk_lbl_cd2');
    	 axon_event.addListener('change', 	'subsRskLbl3_OnChange', 'frm_imdg_subs_rsk_lbl_cd3');
    	 axon_event.addListener('change', 	'subsRskLbl4_OnChange', 'frm_imdg_subs_rsk_lbl_cd4');
    	 axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
    	 axon_event.addListenerForm('keyup',	'obj_keyup', 	document.form);
    	 axon_event.addListenerForm('blur', 	'obj_blur', 	document.form); 
     }
     
     /**
      * Combo 기본 설정
      * Combo의 항목을 설정한다.
      */
     function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "frm_imdg_clss_cd":
	            with(comboObj) {
	            	SetTitle("Class|Definition");
	            	SetColWidth("50|700");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;	        
	        case "frm_imdg_comp_grp_cd":
	            with(comboObj) {
	            	SetTitle("Compatibility Group");
	            	SetColWidth("150");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	        		Enable = false;	            	
	            }
	            break;
	        case "frm_imdg_subs_rsk_lbl_cd1":
	            with(comboObj) {
	            	SetColWidth("50");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_imdg_subs_rsk_lbl_cd2":
	            with(comboObj) {
	            	SetColWidth("50");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_imdg_subs_rsk_lbl_cd3":
	            with(comboObj) {
	            	SetColWidth("50");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_imdg_subs_rsk_lbl_cd4":
	            with(comboObj) {
	            	SetColWidth("50");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_imdg_mrn_polut_cd":
	            with(comboObj) {
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_imdg_pck_grp_cd":
	            with(comboObj) {
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_imdg_expt_qty_cd":
	            with(comboObj) {
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_cfr_xtd_clss_cd":
	            with(comboObj) {
	            	SetColWidth("50");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            }
	            break;
	        case "frm_segr_as_for_imdg_clss_cd":
	            with(comboObj) {
	            	SetColWidth("50");
	            	DropHeight = 190;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	        		Enable = false;
	            }
	            break;
	        case "frm_away_fm_imdg_clss_cd":
	            with(comboObj) {
	    	    	MultiSeparator = "/";
	            	DropHeight = 150;
	            	MultiSelect = true;
	            	UseAutoComplete = false;
	        		Enable = false;	            	
	            }
	            break;
	        case "frm_sprt_fm_imdg_clss_cd":
	            with(comboObj) {
	    	    	MultiSeparator = "/";
	            	DropHeight = 150;
	            	MultiSelect = true;
	            	UseAutoComplete = false;
	        		Enable = false;	            	
	            }
	            break;
	        case "frm_sprt_hld_fm_imdg_clss_cd":
	            with(comboObj) {
	    	    	MultiSeparator = "/";
	            	DropHeight = 150;
	            	MultiSelect = true;
	            	UseAutoComplete = false;
	        		Enable = false;	            	
	            }
	            break;
	        case "frm_sprt_lon_fm_imdg_clss_cd":
	            with(comboObj) {
	    	    	MultiSeparator = "/";
	            	DropHeight = 150;
	            	MultiSelect = true;
	            	UseAutoComplete = false;
	        		Enable = false;	            	
	            }
	            break;
	        case "frm_away_dp_seq":
	            with(comboObj) {
	    	    	MultiSeparator = "/";
	            	DropHeight = 150;
	            	MultiSelect = true;
	            	UseAutoComplete = false;
	        		Enable = false;	            	
	            }
	            break;
	        case "frm_sprt_dp_seq":
	            with(comboObj) {
	    	    	MultiSeparator = "/";
	                MultiSelect = true;
	            	DropHeight = 150;
	            	UseAutoComplete = false;
	        		Enable = false;	            	
	            }
	            break;
	    }
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
    	 			InsertTab( cnt++ , "Substance Details" , -1 );
    	 			InsertTab( cnt++ , "CFR/Others" , -1 );
    	 			InsertTab( cnt++ , "Packing/IBC/Tank Instruction & Provision & Restrictions" , -1 );
    	 			InsertTab( cnt++ , "Stowage and Segregation" , -1 );
    	 			InsertTab( cnt++ , "Organic Peroxides & Self-Reactive Substances" , -1 );
    	 		}
    	 	break;
    	 }
     }

     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem) {
    	 var objs = document.all.item("tabLayer");

    	 objs[nItem].style.display = "Inline";
    	 objs[beforetab].style.display = "none";

    	 //--------------- 요기가 중요 --------------------------//
    	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	 //------------------------------------------------------//
    	 beforetab= nItem;
    	 tabIndex = nItem;
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
    	 	case IBSEARCH: // 조회
    	 		if (formObj.imdg_un_no.value == "") {
    	 			ComShowCodeMessage('SCG50007', 'UN No.');
    	 			ComSetFocus(formObj.imdg_un_no);
    	 			return;
    	 		}
    	 		if (formObj.imdg_un_no_seq.value == "") {
    	 			ComShowCodeMessage('SCG50007', 'substance details');
    	 			ComSetFocus(formObj.imdg_un_no_seq);
    	 			return;
    	 		}
    	 		break;
    	 		
    	 	case IBSAVE: // 저장
    	 		if (formObj.imdg_un_no.value == "") {
    	 			ComShowCodeMessage('SCG50007', 'UN No.');
    	 			ComSetFocus(formObj.imdg_un_no);
    	 			return;
    	 		}
    	 		if (formObj.imdg_un_no_seq.value == "") {
    	 			ComShowCodeMessage('SCG50007', 'substance details');
    	 			ComSetFocus(formObj.imdg_un_no_seq);
    	 			return;
    	 		}
    	 		if (formObj.frm_prp_shp_nm.value == "") {
    	 			ComShowCodeMessage('SCG50007', 'proper shipping name');
    	 			ComSetFocus(formObj.frm_prp_shp_nm);
    	 			return;
    	 		}
// 2013.05.08 DHN 내용 추가    	 		
//    	 		if (formObj.frm_prp_shp_nm.value.length >500) {
//    	 			ComShowCodeMessage('COM12133', 'Proper Shipping Name', '500 letters', 'shorter');
//    	 			ComSetFocus(formObj.frm_prp_shp_nm);
//    	 			return;
//    	 		} 
    	 		
    	 		if (comboObjects[0].Code == "") {
    	 			ComShowCodeMessage('SCG50007', 'Class');
    	 			ComSetFocus(formObj.frm_imdg_clss_cd);
    	 			return;
    	 		}
    	 		//Segregation 필수 입력 삭제 (2009-09-24 서동호부장님 요청)
    	 		/*
    	 		j = 0;
    	 		for (var i=1; i<=20; i++){
    	 			if (sheetObjects[1].CellValue(1,i) == "") {
        	 			ComShowCodeMessage('SCG60001');
        	 			tabObjects[0].selectedIndex = 3;
        	 			sheetObjects[1].SelectCell(1, i);
        	 			return;
    	 			}
    	 		}
    	 		*/
    	 		break;    	  
    	 	case IBSEARCH_ASYNC07: // Auto Creation조회
    	 		if (comboObjects[0].Code == "") {
    	 			ComShowCodeMessage('SCG50007', 'Class');
    	 			tabObjects[0].selectedIndex = 0;
    	 			ComSetFocus(comboObjects[0]);
    	 			return;
    	 		}
    	 		break;    	  			
    	 }
    	 return true;     
     }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
     function sheet2_OnChange(sheetObj,Row, Col, Value){
    	 if (Col !=21) {
    		 doActionIBSheet(sheetObj, document.form, IBROWSEARCH, Col, Row);
        	 obj_CellFontColor();
    	 }
     }

     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
     function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
    	 obj_CellFontColor();
     }
     /**
      * IBSheet Object에서 입력값이 변경된 경우
      */
     function obj_CellFontColor() {
    	 //AutoCreation에서 가져온 값고 수기 입력한값(Table)중 틀린 값이 있으면 붉은색으로 표시한다.
    	 for (var i = 1; i <21; i++ ) {
    		 if (sheetObjects[1].CellValue(1, i) != sheetObjects[2].CellValue(1, i)) {
    			 sheetObjects[1].CellFontColor(1, i) = sheetObjects[1].RgbColor(255, 0, 0);
    		 }else{
    			 sheetObjects[1].CellFontColor(1, i) = sheetObjects[1].RgbColor(0, 0, 0);    			 
    		 }
    	 }
     }
     
     /**
      * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
      **/
     function obj_keypress(){
    	 var formObj = document.form;
    	 switch(event.srcElement.dataformat){
    	 	case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
	        case "eng":
	            ComKeyOnlyAlphabet(); 
	            break;
	        case "engup":
	        	//영문 대문자만 입력하기
	          	ComKeyOnlyAlphabet('uppernum');
	            break;   
		}
    	switch(event.srcElement.name){
			case "imdg_un_no":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "frm_imdg_lmt_qty":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
    		case "frm_flsh_pnt_temp_ctnt":
    			//숫자,- 만입력하기
    			ComKeyOnlyNumber(event.srcElement,"-~to ");
    			break;
    		case "frm_imdg_ctrl_temp":
    			//숫자,- 만입력하기
    			ComKeyOnlyNumber(event.srcElement,"-.");
    			break;
    		case "frm_imdg_emer_temp":
    			//숫자,- 만입력하기
    			ComKeyOnlyNumber(event.srcElement,"-.");
    			break;
	        case "frm_imdg_lmt_qty_desc":
	        	//영문 대문자만 입력하기
	          	ComKeyOnlyAlphabet('uppernum',"0123456789");
	            break;
	        case "frm_imdg_expt_qty_desc":
	        	//영문 대문자만 입력하기
	          	ComKeyOnlyAlphabet('uppernum',"0123456789");
	            break;
    	}
     }

     function obj_keyup(){
    	 ComKeyEnter('LengthNextFocus');
    	 var formObj = document.form;
    	 switch(event.srcElement.name){
    	 	case "frm_imdg_ctrl_temp":
				var point = event.srcElement.value.split(".");
				if (point[2] != undefined && point[2] == '') {
					event.srcElement.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);					
				}
//				if (event.srcElement.value.split(".").length > 1 ) {
//					formObj.frm_imdg_ctrl_temp.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);
//				}
//				if (point[2] != undefined) {
//					formObj.frm_imdg_ctrl_temp.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);
//				}
				break;			
			case "frm_imdg_emer_temp":
				var point = event.srcElement.value.split(".");
				if (point[2] != undefined && point[2] == '') {
					event.srcElement.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);					
				}
//				if (point[1].length > 1 ) {
//					formObj.frm_imdg_emer_temp.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);
//				}
//				if (point[2] != undefined) {
//					formObj.frm_imdg_emer_temp.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);
//				}
				break;
			case "frm_cfr_rpt_qty":
				var point = event.srcElement.value.split(".");
				if (point[2] != undefined && point[2] == '') {
					event.srcElement.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);					
				}
//				if (point[1].length > 3 ) {
//					formObj.frm_cfr_rpt_qty.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);
//				}
//				if (point[2] != undefined) {
//					formObj.frm_cfr_rpt_qty.value = event.srcElement.value.substring(0,event.srcElement.value.length-1);
//				}
				break;
	    }
     }
     
     function obj_blur() {
    	 var formObj = document.form;
    	 switch(event.srcElement.name){
    	 	case "imdg_un_no":
    	 		var length = formObj.imdg_un_no.value.length;
    	 		if (length == 4) {
    	 			clearBody();
    	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);	 			
    	 		}else if (length > 0){
         			ComShowCodeMessage('SCG50006',"UN No.", "4");
         			event.srcElement.focus();
         			event.srcElement.select();
    	 		}
    	 		break;
			case "frm_imdg_spcl_provi_no1": case "frm_imdg_spcl_provi_no2": case "frm_imdg_spcl_provi_no3": case "frm_imdg_spcl_provi_no4": case "frm_imdg_spcl_provi_no5": case "frm_imdg_spcl_provi_no6": case "frm_imdg_spcl_provi_no7": case "frm_imdg_spcl_provi_no8":
				if (event.srcElement.value != "") {
					for(i=1; i<9; i++){
						if (event.srcElement.name != eval("formObj.frm_imdg_spcl_provi_no"+i+".name")){
							if (event.srcElement.value == eval("formObj.frm_imdg_spcl_provi_no"+i+".value")) {
					    		ComShowCodeMessage('SCG50005', 'Data');
								event.srcElement.value = "";
			    	 			ComSetFocus(event.srcElement);
								return;
							}
						}
					}
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
				}
				break;
			case "frm_n1st_imdg_pck_instr_cd": case "frm_n2nd_imdg_pck_instr_cd": case "frm_n3rd_imdg_pck_instr_cd":
				if (event.srcElement.value != "") {
					for(i=0; i<3; i++){
						if (event.srcElement.name != eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_instr_cd.name")){
							if (event.srcElement.value == eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_instr_cd.value")) {
					    		ComShowCodeMessage('SCG50005', 'Data');
								event.srcElement.value = "";
			    	 			ComSetFocus(event.srcElement);
			    	 			return;
							}
						}
					}
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
				break;
			case "frm_n1st_imdg_pck_provi_cd": case "frm_n2nd_imdg_pck_provi_cd": case "frm_n3rd_imdg_pck_provi_cd":  case "frm_n4th_imdg_pck_provi_cd": case "frm_n5th_imdg_pck_provi_cd":
				if (event.srcElement.value != "") {
					for(i=0; i<5; i++){
						if (event.srcElement.name != eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_provi_cd.name")){
							if (event.srcElement.value == eval("formObj.frm_"+objNmSeq[i]+"_imdg_pck_provi_cd.value")) {
					    		ComShowCodeMessage('SCG50005', 'Data');
								event.srcElement.value = "";
			    	 			ComSetFocus(event.srcElement);
			    	 			return;
							}
						}
					}
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
				break;
			case "frm_n1st_imdg_ibc_instr_cd": case "frm_n2nd_imdg_ibc_instr_cd": case "frm_n3rd_imdg_ibc_instr_cd": case "frm_n4th_imdg_ibc_instr_cd": case "frm_n5th_imdg_ibc_instr_cd":
				if (event.srcElement.value != "") {
					for(i=0; i<5; i++){
						if (event.srcElement.name != eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_instr_cd.name")){
							if (event.srcElement.value == eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_instr_cd.value")) {
					    		ComShowCodeMessage('SCG50005', 'Data');
								event.srcElement.value = "";
			    	 			ComSetFocus(event.srcElement);
			    	 			return;
							}
						}
					}
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
				break;
			case "frm_n1st_imdg_ibc_provi_cd": case "frm_n2nd_imdg_ibc_provi_cd": case "frm_n3rd_imdg_ibc_provi_cd": case "frm_n4th_imdg_ibc_provi_cd": case "frm_n5th_imdg_ibc_provi_cd":
				if (event.srcElement.value != "") {
					for(i=0; i<5; i++){
						if (event.srcElement.name != eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_provi_cd.name")){
							if (event.srcElement.value == eval("formObj.frm_"+objNmSeq[i]+"_imdg_ibc_provi_cd.value")) {
					    		ComShowCodeMessage('SCG50005', 'Data');
								event.srcElement.value = "";
			    	 			ComSetFocus(event.srcElement);
			    	 			return;
							}
						}
					}
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
				break;
			case "frm_imdg_un_tnk_instr_cd":
				if (event.srcElement.value != "") {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
				break;
			case "frm_n1st_imdg_tnk_instr_provi_cd": case "frm_n2nd_imdg_tnk_instr_provi_cd": case "frm_n3rd_imdg_tnk_instr_provi_cd":  case "frm_n4th_imdg_tnk_instr_provi_cd": case "frm_n5th_imdg_tnk_instr_provi_cd":
				if (event.srcElement.value != "") {
					for(i=0; i<5; i++){
						if (event.srcElement.name != eval("formObj.frm_"+objNmSeq[i]+"_imdg_tnk_instr_provi_cd.name")){
							if (event.srcElement.value == eval("formObj.frm_"+objNmSeq[i]+"_imdg_tnk_instr_provi_cd.value")) {
					    		ComShowCodeMessage('SCG50005', 'Data');
								event.srcElement.value = "";
			    	 			ComSetFocus(event.srcElement);
			    	 			return;
							}
						}
					}
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
				break;
			case "frm_imdg_tec_nm":
				if (formObj.frm_imdg_tec_nm.value != ""){
					formObj.frm_imdg_tec_nm_desc.value = formObj.frm_imdg_tec_nm.value;
				}
				break;
	    	}
    	 ComChkObjValid(event.srcElement);
	}

    function clss_OnChange(comboObj, code, text) {
    	var formObj = document.form;
    	var code = code.split("|");
    	code = code[0];
    	if (code == "1" || code == "1.1" || code == "1.2" || code == "1.3" || code == "1.4" || code == "1.5" || code == "1.6" ){
    		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
  			comboObjects[1].Enable = true;
    		comboObjects[1].Code = "A";
  		}else{
    		comboObjects[1].Code = "";
  			comboObjects[1].Enable = false;
  		}
    }

    function subsRskLbl1_OnChange(comboObj, code, text) {
    	var formObj = document.form;
    	if (code!="" && (code == comboObjects[3].Code || code == comboObjects[4].Code || code == comboObjects[5].Code)) {
    		ComShowCodeMessage('SCG50005', 'Data');
    		comboObjects[2].Code = "";
    	}else{
    		formObj.frm_n1st_imdg_subs_rsk_lbl_cd.value = code;
    	}
    }
    
    function subsRskLbl2_OnChange(comboObj, code, text) {
    	var formObj = document.form;
    	if (code!="" && (code == comboObjects[2].Code || code == comboObjects[4].Code || code == comboObjects[5].Code)) {
    		ComShowCodeMessage('SCG50005', 'Data');
    		comboObjects[3].Code = "";
    	}else{
    		formObj.frm_n2nd_imdg_subs_rsk_lbl_cd.value = code;
    	}
    }
    
    function subsRskLbl3_OnChange(comboObj, code, text) {
    	var formObj = document.form;
    	if (code!="" && (code == comboObjects[2].Code || code == comboObjects[3].Code || code == comboObjects[5].Code)) {
    		ComShowCodeMessage('SCG50005', 'Data');
    		comboObjects[4].Code = "";
    	}else{
    		formObj.frm_n3rd_imdg_subs_rsk_lbl_cd.value = code;
    	}
    }
    
    function subsRskLbl4_OnChange(comboObj, code, text) {
    	var formObj = document.form;
    	if (code!="" && (code == comboObjects[2].Code || code == comboObjects[3].Code || code == comboObjects[4].Code)) {
    		ComShowCodeMessage('SCG50005', 'Data');
    		comboObjects[5].Code = "";
    	}else{
    		formObj.frm_n4th_imdg_subs_rsk_lbl_cd.value = code;
    	}
    }
    
    function unNoSeqPrev() {
 		var formObj = document.form;
 		var unNo 	= formObj.imdg_un_no.value;
 		var unNoSeq = parseInt(formObj.imdg_un_no_seq.value);
 		var maxSeq 	= parseInt(formObj.imdg_un_no_seq_max.value);
 		var minSeq 	= parseInt(formObj.imdg_un_no_seq_min.value);
 		var totCnt 	= formObj.imdg_un_no_seq_cnt.value;
 		var exptNm 	= formObj.frm_imdg_crr_rstr_expt_nm.value;
 		var updId 	= formObj.frm_upd_usr_id.value;
 		var updDt 	= formObj.frm_upd_dt.value;
 		if (formObj.imdg_un_no_seq.value == "" ) {
 			ComShowCodeMessage('SCG50007', 'UN No.');
 			ComSetFocus(formObj.imdg_un_no);
 			return;
 		}else if (unNoSeq > 1){
			if (sheetObjects[0].CellValue(2,"imdg_un_no") != undefined) {
 				ComResetAll();
 				formObj.imdg_un_no.value = unNo;
 				formObj.imdg_un_no_seq_max.value = maxSeq;
 				formObj.imdg_un_no_seq_min.value = minSeq;
 				formObj.imdg_un_no_seq_cnt.value = totCnt;
 				formObj.frm_imdg_crr_rstr_expt_nm.value = exptNm;
 				//formObj.frm_upd_usr_id.value = updId;
 				formObj.frm_upd_dt.value = updDt;	 					
        		if (sheetObjects[1].LastRow < 1 ) {
      				sheetObjects[1].DataInsert(-1);
      			}
			}
 	 		formObj.imdg_un_no_seq.value = unNoSeq-1;
 		}else{
 			
 		}
 	}

 	function unNoSeqNext() {
 		var formObj = document.form;
 		var unNo 	= formObj.imdg_un_no.value;
 		var unNoSeq = formObj.imdg_un_no_seq.value;
 		var maxSeq 	= parseInt(formObj.imdg_un_no_seq_max.value);
 		var minSeq 	= parseInt(formObj.imdg_un_no_seq_min.value);
 		var totCnt 	= formObj.imdg_un_no_seq_cnt.value;
 		var exptNm 	= formObj.frm_imdg_crr_rstr_expt_nm.value;
 		//var updId 	= formObj.frm_upd_usr_id.value;
 		var updDt 	= formObj.frm_upd_dt.value;
 		
 		if (maxSeq > 0) {
	 		if (formObj.imdg_un_no_seq.value == "" ) {
	 			ComShowCodeMessage('SCG50007', 'substance details');
	 			ComSetFocus(formObj.imdg_un_no);
	 			return;
	 		}else if (parseInt(formObj.imdg_un_no_seq.value)+1 > maxSeq ){
	 			if (ComShowCodeConfirm("SCG50025")) {
	 				if (sheetObjects[0].CellValue(2,"imdg_un_no") != undefined) {
		 				ComResetAll();
		 				formObj.imdg_un_no.value = unNo;
		 				formObj.imdg_un_no_seq_max.value = maxSeq;
		 				formObj.imdg_un_no_seq_min.value = minSeq;
		 				formObj.imdg_un_no_seq_cnt.value = totCnt;
		 				formObj.frm_imdg_crr_rstr_expt_nm.value = exptNm;
		 				//formObj.frm_upd_usr_id.value = updId;
		 				formObj.frm_upd_dt.value = updDt;
	            		if (sheetObjects[1].LastRow < 1 ) {
	          				sheetObjects[1].DataInsert(-1);
	          			}
	 				}
	 				formObj.imdg_un_no_seq.value = maxSeq+1;
 				}
	 		}else{
 				if (sheetObjects[0].CellValue(2,"imdg_un_no") != undefined) {
	 				ComResetAll();
	 				formObj.imdg_un_no.value = unNo;
	 				formObj.imdg_un_no_seq_max.value = maxSeq;
	 				formObj.imdg_un_no_seq_min.value = minSeq;
	 				formObj.imdg_un_no_seq_cnt.value = totCnt;
	 				formObj.frm_imdg_crr_rstr_expt_nm.value = exptNm;
	 				//formObj.frm_upd_usr_id.value = updId;
	 				formObj.frm_upd_dt.value = updDt;	 					
            		if (sheetObjects[1].LastRow < 1 ) {
          				sheetObjects[1].DataInsert(-1);
          			}
 				}
	 	 		formObj.imdg_un_no_seq.value = parseInt(unNoSeq)+1; 			
	 		}
 		}
 	}

 	function clearAll() {
 		var formObj = document.form;
 		formObj.reset();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[1].DataInsert(-1);
        for(var k=0; k<comboObjects.length; k++){
        	comboObjects[k].RemoveAll();
        	initCombo(comboObjects[k], k + 1);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	//UN Class
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);	//Excepted Q'ty, Away from SG/Separated from SG 
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08);	//Marine pollutant
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC09);	//Packing group
 	}

 	function clearBody() {
 		var formObj = document.form;
 		formObj.frm_hcdg_flg.checked = false;
 		formObj.frm_hcdg_dpnd_qty_flg.checked = false;
 		formObj.frm_imdg_un_no_hld_flg.checked = false;
 		formObj.frm_segr_as_for_imdg_clss_flg.checked = false;		
 		formObj.frm_away_fm_imdg_clss_flg.checked = false;
 		formObj.frm_sprt_fm_imdg_clss_flg.checked = false;
 		formObj.frm_sprt_hld_fm_imdg_clss_flg.checked = false;
 		formObj.frm_sprt_lon_fm_imdg_clss_flg.checked = false;
 		formObj.frm_away_fm_imdg_segr_grp_flg.checked = false;
 		formObj.frm_sprt_fm_imdg_segr_grp_flg.checked = false;

		//조회된 값이 있을경우 비활성화된 콤보를 활성화 시킨다.
		if (formObj.frm_segr_as_for_imdg_clss_flg.checked == true) {
  			comboObjects[10].Enable = true;
		}else{
  			comboObjects[10].Enable = false;
		}
		if (formObj.frm_away_fm_imdg_clss_flg.checked == true) {
  			comboObjects[11].Enable = true;
		}else{
  			comboObjects[11].Enable = false;
		}
		if (formObj.frm_sprt_fm_imdg_clss_flg.checked == true) {
  			comboObjects[12].Enable = true;
		}else{
  			comboObjects[12].Enable = false;
		}
		if (formObj.frm_sprt_hld_fm_imdg_clss_flg.checked == true) {
  			comboObjects[13].Enable = true;
		}else{
  			comboObjects[13].Enable = false;
		}
		if (formObj.frm_sprt_lon_fm_imdg_clss_flg.checked == true) {
  			comboObjects[14].Enable = true;
		}else{
  			comboObjects[14].Enable = false;
		}
		if (formObj.frm_away_fm_imdg_segr_grp_flg.checked == true) {
  			comboObjects[15].Enable = true;
		}else{
  			comboObjects[15].Enable = false;
		}
		if (formObj.frm_sprt_fm_imdg_segr_grp_flg.checked == true) {
  			comboObjects[16].Enable = true;
		}else{
  			comboObjects[16].Enable = false;
		}
 		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[0].DataInsert(-1);
		sheetObjects[1].DataInsert(-1);
		sheetObjects[0].CellValue(sheetObjects[0].LastRow,"upd_usr_id") = formObj.frm_upd_usr_id.value;
		sheetObjects[0].CellValue(sheetObjects[0].LastRow,"upd_dt") = formObj.frm_upd_dt.value;
		//Sheet에서 html로 이동시킨다.
		ComScgCopyRowToForm(sheetObjects[0], formObj, sheetObjects[0].LastRow, "frm_");
		sheetObjects[0].RemoveAll();
		comboObjects[6].Text = "Blank";
		comboObjects[7].Text = "Blank";
 	}
 	
 	function copy(){
 		var formObj = document.form;
 		var length = formObj.imdg_un_no.value.length;
 		if (length == 4) {
 	 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);	 			
 		}
		sheetObjects[0].RemoveAll();
 	}

 	function segrClssFlg(){
 		var formObj = document.form;
 		if (formObj.frm_segr_as_for_imdg_clss_flg.checked == true) {
  			comboObjects[10].Enable = true;
 		}else{
 			comboObjects[10].Enable = false;
 			comboObjects[10].Code = "";
 		}
 	}
 	
 	function awayClssFlg(){
 		var formObj = document.form;
 		if (formObj.frm_away_fm_imdg_clss_flg.checked == true) {
  			comboObjects[11].Enable = true;
 		}else{
 			comboObjects[11].Enable = false;
 			comboObjects[11].Code = ""; 			
 		}
 	}
 	
 	function sprtClssFlg(){
 		var formObj = document.form;
 		if (formObj.frm_sprt_fm_imdg_clss_flg.checked == true) {
  			comboObjects[12].Enable = true;
 		}else{
 			comboObjects[12].Enable = false;
 			comboObjects[12].Code = ""; 			
 		}
 	}
 	
 	function sprtHldClssFlg(){
 		var formObj = document.form;
 		if (formObj.frm_sprt_hld_fm_imdg_clss_flg.checked == true) {
  			comboObjects[13].Enable = true;
 		}else{
 			comboObjects[13].Enable = false;
 			comboObjects[13].Code = ""; 			
 		}
 	}
 	
 	function sprtLonClssFlg(){
 		var formObj = document.form;
 		if (formObj.frm_sprt_lon_fm_imdg_clss_flg.checked == true) {
  			comboObjects[14].Enable = true;
 		}else{
 			comboObjects[14].Enable = false;
 			comboObjects[14].Code = ""; 			
 		}
 	}
 	
 	function awaySegrGrpFlg(){
 		var formObj = document.form;
 		if (formObj.frm_away_fm_imdg_segr_grp_flg.checked == true) {
  			comboObjects[15].Enable = true;
 		}else{
 			comboObjects[15].Enable = false;
 			comboObjects[15].Code = ""; 			
 		}
 	}
 	
 	function sprtSegrGrpFlg(){
 		var formObj = document.form;
 		if (formObj.frm_sprt_fm_imdg_segr_grp_flg.checked == true) {
  			comboObjects[16].Enable = true;
 		}else{
 			comboObjects[16].Enable = false;
 			comboObjects[16].Code = "";
 		}
 	}
 	
    /**
     * Packing / IBC / Tank Instructions & Provisions 에서 파일 열시 클릭시
     */
 	function openFile(srcName) {
// 		var formObj = document.form;
// 		var objName = srcName.replace('btns_','').replace('_cd','_file');

// 		if (sheetObjects[0].CellValue(sheetObjects[0].LastRow,objName) != "" ) {
// 			location.href = "/hanjin/FileDownload?key="+sheetObjects[0].CellValue(sheetObjects[0].LastRow,objName);
//		}else{
//    		ComShowCodeMessage('SCG50004', 'Data');
//		}
// 2013.05.08 김현화 [CHM-201324585]DG Packing Instruction 기능 적용- pop 화면에서 처리하도록 수정
 		var formObj = document.form;
 		var objName = srcName.replace('btns_','frm_').replace('_file', '_cd');
 		var objName2 = srcName.replace('btns_','frm_').replace('_cd', '_seq');

 		//ComOpenPopupWithTarget('/hanjin/VOP_SCG_0060Pop.do?imdg_pck_instr_cd='+eval("formObj."+objName+".value"), 1025, 693, "imdg_pck_instr_cd:"+objName, "0,1,1,0,1,1,1", true);
 		ComOpenPopupWithTarget('/hanjin/VOP_SCG_0060Pop.do?imdg_pck_instr_cd='+eval("formObj."+objName+".value")+'&imdg_pck_instr_seq='+eval("formObj."+objName2+".value"), 1025, 683, "sheet1_imdg_pck_instr_cd:"+objName+"|sheet1_imdg_pck_instr_seq:"+objName2, "0,1,0,0,0,1,1,1,1", true);
		
 		
 			
 	}

    /**
     * IBSheet Object에서 팝업을 클릭시
     */
    function onPopupClick(srcName){
 		var formObj = document.form;
 		var objName = event.srcElement.name.replace('btn_','frm_');
 		ComOpenPopupWithTarget('/hanjin/VOP_SCG_0059Pop.do?imdg_spcl_provi_no='+eval("formObj."+objName+".value"), 1025, 693, "imdg_spcl_provi_no:"+objName, "1,0,1,1,1,1,1", true);
    }
 	
 	/* 개발자 작업  끝 */