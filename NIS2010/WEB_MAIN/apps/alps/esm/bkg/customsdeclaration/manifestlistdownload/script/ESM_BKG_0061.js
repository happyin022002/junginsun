/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0061.js
*@FileTitle : ESM_BKG-0061
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.10.21 김보배 [CHM-201327005] Split 02-[ALPS 데이터품질 - BKG validation 로직보완] 9월 대상 건에 대한 진행 요청 건
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0061() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    	this.sheet3_OnClick         = sheet3_OnClick;
    	this.sheet3_OnChange		= sheet3_OnChange;
    	this.sheet3_OnComboChange		= sheet3_OnComboChange;
    }
    

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;
 var checkAll = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var vIsCheck = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		         var sheetObject1 = sheetObjects[0];
 		         var sheetObject2 = sheetObjects[1]; 
 		         var sheetObject3 = sheetObjects[2];		         
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
     		 
             switch(srcName) {
                           
             				case "btn_save":
             					doActionIBSheet(sheetObjects[2],document.form,COMMAND03);
             				break;
             				
 							case "btn_retrieve":
 								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 								 								
 							break;
 							 
 							case "btn_downexcel": 			 								 
 								sheetObject3.SpeedDown2Excel(-1);
 							break;							
 							
 							case "btn_add": 	 
 								doActionIBSheet(sheetObjects[2],document.form,COMMAND01); 								
 							break;							
 							
 							case "btn_del":
 								doActionIBSheet(sheetObjects[2],document.form,IBDELETE); 			
 							break;							
 							
 							case "btn_trans":
 								doActionIBSheet(sheetObjects[2],document.form,IBSAVE); 		
 							break;				

 							case "btn_view":
 								doActionIBSheet(sheetObjects[2], formObject, COMMAND05);
 							break;
 							 							 
 						 
 							case "btn_reject":
 								 								
 								if(document.getElementById("btn_reject").innerText == "Reject Select")
 								{
 									document.getElementById("btn_reject").innerHTML = "Reject DeSelect";
 									sheetRejectCheck(sheetObjects[2],"R");
 								}
 								else
 								{
 									sheetRejectCheck(sheetObjects[2],"A");						 
 	 								document.getElementById("btn_reject").innerHTML = "Reject Select";
 								}
 								
 							break;	
 							
 							case "btn_confirm":
 								doActionIBSheet(sheetObjects[2],document.form,COMMAND02);
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

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
              
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);             
             
         }
        var formObject = document.form;
        
        if(formObject.cn_no.value != "" || formObject.vvd_no.value != "")
        {
        	if(formObject.vvd_no.value.length > 0)
        	{
        		formObject.vsl_cd.value = formObject.vvd_no.value.substring(0,4);
        		formObject.skd_voy_no.value = formObject.vvd_no.value.substring(4,8);
        		formObject.skd_dir_cd.value = formObject.vvd_no.value.substring(8);
        		formObject.frm_vvd_number.value = formObject.vvd_no.value;
        	}
        	formObject.frm_crn_number.value = formObject.cn_no.value;
        	
        	if(formObject.cn_no.value != "" && formObject.vvd_no.value != "")
        	{
        		var sheetObject1 = sheetObjects[0];
        		doActionIBSheet(sheetObject1,document.form,IBSEARCH);	
        	}
        	
        	formObject.frm_vvd_number.focus();
        }
        
         
        
        axon_event.addListenerForm  ('change', 'obj_change', form); 
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
		 
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
                     style.height = 128;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

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

                     var HeadTitle1 = "|Seq.|POL|POL ATD|POD|Calling\nSeq.|BDR|BDR DATE|Sub B/L TTL\n(Excl. Non-BDR)|Sub B/L TTL\n(Incl. Non-BDR)";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtSeq,				40,		daCenter,	true,	"SEQ",				false,    "",      dfNone,			0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"vps_port_cd",		false,    "",      dfNone,			0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	true,	"vps_etd_dt",		false,    "",      dfUserFormat2,	0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"pod",				false,    "",      dfNone,			0,     false,		false);                                                                                                                                                   
                     // Add. 2015.04.20
                     InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"pod_clpt_ind_seq",	false,    "",      dfNone,			0,     false,		false);                                                                                                                                                   
                     
                     InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"trnk_bdr_flg",		false,    "",      dfNone,			0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	true,	"trnk_auto_bdr_dt",	false,    "",      dfUserFormat2,	0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"excl_count",		false,    "",      dfNone,			0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"incl_count",		false,    "",      dfNone,			0,     false,		false);

 					 InitUserFormat2(0, "vps_etd_dt", "####-##-## ##:##", "-|:" );
 					 InitUserFormat2(0, "trnk_auto_bdr_dt", "####-##-## ##:##", "-|:" );

                }
                 break;
                  
                   
             case 2:      //sheet2 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 110;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

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
                     InitHeadMode(false, true, false, true, false,false);
                     //InitHeadMode(true, true,true, true, false,false);

                     var HeadTitle1 = "|TTL\n |B/L Count\n ";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,    daCenter,  false,  "ibflag");
 					 InitDataProperty(0, cnt++ , dtData,    110,   daCenter,    true,     "ttl",     		false,    "",      dfNone, 		0,     false,		false,-1,false,false);
                     InitDataProperty(0, cnt++ , dtData, 	90,   daRight,     true,     "bl_count",      false,    "",      dfNone, 		0,     false,		false,-1,false,false);
                     CountPosition = 0;

                }
                 break;                  

             case 3:      //sheet3 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 242
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

 					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(41, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true,true, true, false,false)

                     var HeadTitle1 = "||Sel.|Seq.|Kind|B/L No.|CUS|Container|F/M|POR|POL|POD|DEL|PRD|POST|Package|Package|WGT|WGT|BDR|Description|Notify Address|Send Result|Sent by|Sent Date|Response Result|Response Date|CFM IND|CFM STF|CFM Date||||||||||";
                     

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL	,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                 InitDataProperty(0, cnt++ , dtHiddenStatus,  0,   daCenter,       true,     "ibflag");
 	                 InitDataProperty(0, cnt++ , dtHidden,      110,   daCenter,       true,     "bl_no2",         false,    "",      dfNone, 		0,     true,		true);
 	                 InitDataProperty(0, cnt++,  dtDummyCheck, 	40,    daCenterTop,    true, 	 "del_chk");
 					 InitDataProperty(0, cnt++ , dtData,       	35,    daCenterTop,    true,     "seq",			   false,    "",      dfNone, 		0,     false,		false);
                     InitDataProperty(0, cnt++ , dtCombo, 		140,   daCenterTop,    true,     "kind",           false,    "",      dfNone, 		0,     true,		true);
 					 InitDataProperty(0, cnt++ , dtData,      	110,   daLeftTop,      true,     "bl_no",          false,    "",      dfNone, 		0,     false,		false);                                                                                                                                                         
                     InitDataProperty(0, cnt++ , dtCombo,      	40,    daCenterTop,    true,     "t1_doc_cd",      false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		100,   daCenter,       true,     "cntr_no",        false,    "",      dfNone, 		0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,      	40,    daCenter,	   true,     "bkg_cgo_tp_cd",  false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		50,    daCenter,       true,     "por_cd",         false,    "",      dfNone, 		0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,      	50,    dtData,	       true,     "pol_cd",         true,     "",      dfEngUpKey, 	0,     true,		false,	5,	true);                                                                                                          
                     InitDataProperty(0, cnt++ , dtData,      	50,    dtData,         true,     "pod_cd",         false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		50,    daCenter,       true,     "del_cd",         false,    "",      dfNone, 		0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,	   true,     "pre_rly_port_cd",false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		60,    daCenter,       true,     "pst_rly_port_cd",false,    "",      dfNone, 		0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,      	60,    daRight,	       true,     "pck_qty",        false,    "",      dfNone, 		0,     false,		false);
                                                                                                           
                     InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,       true,     "pck_tp_cd",      false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		60,    daRight,        true,     "cntr_mf_wgt",    false,    "",      dfNone, 		0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,      	30,    daCenter,	   true,     "cntr_wgt_ut_cd", false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		50,    daCenter,       true,     "bdr_flg",        false,    "",      dfNone, 		0,     false,		false);
                                                                                                           
 					 InitDataProperty(0, cnt++ , dtData,      	140,   daLeft,         true,     "cntr_mf_desc",   false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		140,   daLeft,         true,     "ntfy_addr",      false,    "",      dfNone, 		0,     false,		false);
                  	 InitDataProperty(0, cnt++ , dtData, 		80,    daCenter,       true,     "rtm_snd_sts_cd", false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		80,    daCenter,       true,     "snd_usr_id",     false,    "",      dfNone, 		0,     false,		false);
  
                     InitDataProperty(0, cnt++ , dtData,      	80,    daCenter,	   true,     "mf_snd_dt",      false,    "",      dfDateYmd,    0,     false,		false);
                     InitDataProperty(0, cnt++ , dtCombo,      	100,   daCenter,       true,     "rtm_re_msg_sts_cd",false,  "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		100,   daCenter,       true,     "re_msg_dt",      false,    "",      dfDateYmd,    0,     false,		false);
                     InitDataProperty(0, cnt++ , dtData,        60,    daCenter,	   true,     "dat_cfm_flg",    false,    "",      dfNone, 		0,     false,		false);
 					 InitDataProperty(0, cnt++ , dtData, 		80,    daCenter,       true,     "cstms_decl_usr_id",false,  "",      dfNone, 		0,     false,		false);

                     InitDataProperty(0, cnt++ , dtData,        80,    daCenter,	   true,     "bl_dat_cfm_dt",  false,    "",      dfDateYmd,    0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "bkg_no",         false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "bkg_no_split",   false,    "",      dfNone,       0,   false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "mt_flag",        false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "user_id",        false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "frm_crn_number", false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "bl_tp_cd",       false,    "",      dfNone,       0,     false,		false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "vsl_cd",         false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "skd_voy_no",     false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "skd_dir_cd",     false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "bigo_kind",      false,    "",      dfNone,       0,     false,		false);
                     InitDataProperty(0, cnt++ , dtHidden,      80,    daCenter,	   true,     "dif_char",       false,    "",      dfNone,       0,     false,		false);
                     
 				     InitDataCombo(0, "kind", " |Cancel|Replace|Original", " |1|5|9");
 				     InitDataCombo(0, "t1_doc_cd", " |T1|TS", "0|D|T");
 				     InitDataCombo(0, "rtm_re_msg_sts_cd", "Accept|Reject", "A|R");
 				      
 				     CountPosition = 0;
                }
                 break; 
                  
                  
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         
         switch(sAction) {

         		case COMMAND03:     // 저장
 				 	
         			if(!validateForm(sheetObj,formObj,sAction)) {
 				 		return false;
 				 	}
 				 	
         			formObj.f_cmd.value = MULTI02;
 					sheetObj.WaitImageVisible = false;
					
 					var sParam = "";					 
					
					sParam = ComSetPrifix(sheetObjects[2].GetSaveString(), "sheet3_");
					if(sParam == "") {
						ComShowCodeMessage('BKG00743');
 						return false;
					}
					
					var sheet3RowCnt = sheetObjects[2].RowCount;
    				var podCdChangeCnt = 0;
    				
    				ComOpenWait(true);
    				
			    	for (var i=1; i <= sheet3RowCnt; i++) {
			    		if(sheetObjects[2].CellValue(i, "del_chk") == 1){
			    			sheetObjects[2].CellValue(i, "del_chk") = 0;
			    		}
			    		
			    		if(sheetObjects[2].CellValue(i, "pol_cd") != sheetObjects[2].CellSearchValue(i, "pol_cd")) {
			    			podCdChangeCnt++;
			    		} else {
			    			sheetObjects[2].RowStatus(i) = "";
			    		}
			    	}
			    	
			    	if(podCdChangeCnt == 0) {
			    		ComShowCodeMessage('BKG00743');
			    		ComOpenWait(false);
 						return false;
			    	} 
					
					sParam += "&" + FormQueryString(formObj);
    				sheetObj.WaitImageVisible = false;
    				
    				
					var sXml = sheetObjects[2].GetSaveXml("ESM_BKG_0061GS.do", sParam);	
					sheetObjects[2].LoadSaveXml(sXml);
					ComOpenWait(false);
					
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					
         		break;
         			
 				case IBSEARCH:      //조회
 				 	if(!validateForm(sheetObj,formObj,sAction)) {
 				 		return false;
 				 	}  	         
 					formObj.f_cmd.value = SEARCH;
 					sheetObj.WaitImageVisible = false;
 					sheetObjects[1].WaitImageVisible = false;
 					sheetObjects[2].WaitImageVisible = false;
 					ComOpenWait(true);
 					if(formObj.cargoType.checked == true)
 						formObj.mt_flag.value = "P";
 					else formObj.mt_flag.value = "F";
 					formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
 					formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
 					formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);	
 					if(sheetObjects[2].RowCount > 0)
 					{
 						initSheet(sheetObjects[2],3);
 						initSheet(sheetObjects[1],2);
 					}
 					sXml = sheetObj.GetSearchXml("ESM_BKG_0061GS.do", FormQueryString(formObj));
					 
					var arrXml = sXml.split("|$$|");
					 
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
			   	  	}
			   	  	if (arrXml.length > 1) {
			   	  		sheetObjects[1].LoadSearchXml(arrXml[1]);
			   	  	} 
			   	  	if (arrXml.length > 2) {
			   	  		sheetObjects[2].LoadSearchXml(arrXml[2]);
			   	  	}			   	  	
			   	    ComEtcDataToForm(formObj, sheetObj);
			   	    
			   	    sheetObjects[1].DataInsert(-1);
			   	    var aa = sheetObjects[1].CellValue(1, 2);
			   	    var bb = sheetObjects[1].CellValue(2, 2);
			   	    sheetObjects[1].CellValue2(3, 1) = "Differ";
			   	    sheetObjects[1].CellValue2(3, 2) = aa - bb;
			   		ComOpenWait(false);

 				break;
 				
 				case COMMAND01: //row add
 					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					} 
 				    var  bkg_no ="";
 					sheetObj.WaitImageVisible = false;
 					ComOpenWait(true);
 				    bkg_no = sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "bkg_no"); 
 				    
 				    var sUrl = "/hanjin/ESM_BKG_1017.do?pgmNo=ESM_BKG_1017&bkg_no="+bkg_no+"&frm_crn_number="+formObj.frm_crn_number.value
								+"&vvd_no="+formObj.frm_vvd_number.value+"&pod_clpt_ind_seq="+formObj.pod_clpt_ind_seq.value;
					ComOpenWindowCenter(sUrl, "ESM_BKG_1017", 230,190, true);
					
					formObj.f_cmd.value = SEARCH;
 					
 					if(formObj.cargoType.checked == true)
 						formObj.mt_flag.value = "P";
 					else formObj.mt_flag.value = "F";
 					formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
 					formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
 					formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);	
 					if(sheetObjects[2].RowCount > 0)
 					{
 						initSheet(sheetObjects[2],3);
 						initSheet(sheetObjects[1],2);
 					}
 					sXml = sheetObj.GetSearchXml("ESM_BKG_0061GS.do", FormQueryString(formObj));
					 
					var arrXml = sXml.split("|$$|");
					 
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
			   	  	}
			   	  	if (arrXml.length > 1) {
			   	  		sheetObjects[1].LoadSearchXml(arrXml[1]);
			   	  	} 
			   	  	if (arrXml.length > 2) {
			   	  		sheetObjects[2].LoadSearchXml(arrXml[2]);
			   	  	}			   	  	
			   	    ComEtcDataToForm(formObj, sheetObj);
			   	    
			   	    sheetObjects[1].DataInsert(-1);
			   	    var aa = sheetObjects[1].CellValue(1, 2);
			   	    var bb = sheetObjects[1].CellValue(2, 2);
			   	    sheetObjects[1].CellValue2(3, 1) = "Differ";
			   	    sheetObjects[1].CellValue2(3, 2) = aa - bb;
			   	    ComOpenWait(false);
 				break;	
 				
 				case COMMAND02: //CONFIRM ALL
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					} 	
					sheetObj.WaitImageVisible = false;
 					ComOpenWait(true); 
 				    if(ComShowCodeConfirm("BKG00614")){  				    	 
 				    	formObj.f_cmd.value = MULTI; 	
 				    	for (var i=1; i <= sheetObjects[2].RowCount; i++) {
 				    		
 				    		if(sheetObjects[2].CellValue(i, "del_chk") == 1)
 				    		{
 				    			sheetObjects[2].CellValue2(i, "ibflag") = "U";
 	 							sheetObjects[2].CellValue2(i, "user_id") = formObj.user_id.value; 	 							 
 	 							sheetObjects[2].CellValue2(i, "mt_flag") =  sheetObjects[2].CellValue(i, "bkg_cgo_tp_cd"); 	 		 					
 				    		} 							 
 						} 				    	 				    	 
 				    	sheetObjects[2].DoSave("ESM_BKG_0061GS.do", FormQueryString(formObj));
 				    }
 				    
 				   formObj.f_cmd.value = SEARCH;
					
					if(formObj.cargoType.checked == true)
						formObj.mt_flag.value = "P";
					else formObj.mt_flag.value = "F";
					formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
					formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
					formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);	
					if(sheetObjects[2].RowCount > 0)
					{
						initSheet(sheetObjects[2],3);
						initSheet(sheetObjects[1],2);
					}
					sXml = sheetObj.GetSearchXml("ESM_BKG_0061GS.do", FormQueryString(formObj));
					 
					var arrXml = sXml.split("|$$|");
					 
			   	  	if (arrXml.length > 0) {			   	  		 
			   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
			   	  	}
			   	  	if (arrXml.length > 1) {
			   	  		sheetObjects[1].LoadSearchXml(arrXml[1]);
			   	  	} 
			   	  	if (arrXml.length > 2) {
			   	  		sheetObjects[2].LoadSearchXml(arrXml[2]);
			   	  	}			   	  	
			   	    ComEtcDataToForm(formObj, sheetObj);

			   	    sheetObjects[1].DataInsert(-1);
			   	    var aa = sheetObjects[1].CellValue(1, 2);
			   	    var bb = sheetObjects[1].CellValue(2, 2);
			   	    sheetObjects[1].CellValue2(3, 1) = "Differ";
			   	    sheetObjects[1].CellValue2(3, 2) = aa - bb;
			   	    ComOpenWait(false); 
				break;	
 					
 				case IBSAVE:        //전송
 					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					} 	
 				    vIsCheck = 0;
				    
				    for(i=1; i<=sheetObjects[2].RowCount; i++) {
				    	 
				    	if( i==1)
				    	{
				    		bl_no = sheetObj.CellValue(i, "bl_no"); 				    		 
				    		if(sheetObj.CellValue(i, "del_chk") == 1)
				    			vIsCheck++;
				    	}
				    	if(bl_no != sheetObj.CellValue(i, "bl_no"))
				    	{
				    		if(sheetObj.CellValue(i, "del_chk") == 1)
				    			vIsCheck++;
				    		bl_no = sheetObj.CellValue(i, "bl_no");
				    	}				    		    
				    }
				    //if (vIsCheck > 1) {
 					//	ComShowCodeMessage('BKG00733');	
 					//	return;
 					//}
 					if (vIsCheck == 0) {
 						ComShowCodeMessage('BKG00249');	
 						return;
 					}
 					
 					var vIsCheck2 = true;
 					for(i=1; i<=sheetObjects[2].RowCount; i++) {
 						if(sheetObj.CellValue(i, "del_chk") == 1 
 								&& sheetObj.CellValue(i, "dat_cfm_flg") == "N" )
 						{
 							vIsCheck2 = false;
 						}
 					}
 					
 					if (vIsCheck2 == false) {
 						ComShowCodeMessage('BKG00620');	
 						return;
 					} 					
				    
 					formObj.f_cmd.value = MULTI01;
 					for (var i=1; i <= sheetObjects[2].RowCount; i++)
 					{
 						if(sheetObjects[2].CellValue(i, "del_chk") == 1)
 						{	
						   sheetObjects[2].CellValue2(i, "ibflag") = "I";						    
						   sheetObjects[2].CellValue2(i,"vsl_cd") = formObj.vsl_cd.value;
						   sheetObjects[2].CellValue2(i,"skd_voy_no") = formObj.skd_voy_no.value;
						   sheetObjects[2].CellValue2(i,"skd_dir_cd") = formObj.skd_dir_cd.value;
						   sheetObjects[2].CellValue2(i,"dif_char") = "@@";
 						}
					} 	 
					 
					var sParam = "";					 
					var sParamSheet2 = sheetObjects[2].GetSaveString();
					if (sParamSheet2 != "") {
						sParam += "&" + ComSetPrifix(sParamSheet2, "sheet3_");
					}					 
					sParam += "&" + FormQueryString(formObj);
    				sheetObj.WaitImageVisible = false;
    				ComOpenWait(true,true);
					var sXml = sheetObjects[2].GetSaveXml("ESM_BKG_0061GS.do", sParam);	
					var key = ComGetEtcData(sXml, "KEY");
					ComOpenWait(true);
					intervalId = setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);

 				break;
 					
 				case COMMAND05:      //  bl view
 					/*var bl_no = 0; 	
 				    
 				    vIsCheck = 0;
 				    
 				    for(i=1; i<=sheetObjects[2].RowCount; i++) {
 				    	 
 				    	if( i==1)
 				    	{
 				    		bl_no = sheetObj.CellValue(i, "bl_no"); 				    		 
 				    		if(sheetObj.CellValue(i, "del_chk") == 1)
 				    			vIsCheck++;
 				    	}
 				    	if(bl_no != sheetObj.CellValue(i, "bl_no"))
 				    	{
 				    		if(sheetObj.CellValue(i, "del_chk") == 1)
 				    			vIsCheck++;
 				    		bl_no = sheetObj.CellValue(i, "bl_no");
 				    	}
 				    		    
 				    }
 					if (vIsCheck > 1) {
 						ComShowCodeMessage('BKG06059');	
 						return;
 					}
 					if (vIsCheck == 0) {
 						ComShowCodeMessage('BKG00249');	
 						return;
 					}
 					for(i=1; i<=sheetObjects[2].RowCount; i++) {
 						if(sheetObj.CellValue(i, "del_chk") == 1)
 							bl_no = sheetObj.CellValue(i, "bl_no");
 					}
 				    var frm_bl_no = bl_no;
 				    */			     
 					var sUrl = "/hanjin/ESM_BKG_0442.do?pgmNo=ESM_BKG_0442&crn_no="+formObj.frm_crn_number.value+"&frm_bl_no="+sheetObjects[2].CellValue(sheetObj.SelectRow, "bl_no")+"&pop_up=Y";
 					ComOpenWindowCenter(sUrl, "ESM_BKG_0442", 1024, 680, true);
 				break;
 				
 				case IBDELETE:      // 삭제
 					if(!validateForm(sheetObj,formObj,sAction)) {
 						return false;
 					} 
 					sheetObj.WaitImageVisible = false;
 					ComOpenWait(true);
 				 	if(ComShowCodeConfirm("BKG00592")){   
 				 		formObj.f_cmd.value = REMOVE; 
 				 		
 				 		for (var i=1; i <= sheetObjects[2].RowCount; i++) {
 				 			if(sheetObj.CellValue(i, "del_chk") == 1)
 				 			{
 							  sheetObjects[2].CellValue2(i, "ibflag") = "D";
 							  sheetObjects[2].CellValue2(i, "user_id") = formObj.user_id.value;
 							  if(formObj.cargoType.checked == true)
 								sheetObjects[2].CellValue2(i, "mt_flag") = "P";
 							  else sheetObjects[2].CellValue2(i, "mt_flag") = "F";
 				 			} 				 			
 							
 						} 			
 				 		
 				 		var sParam = "";
						 						 
						var sParamSheet2 = sheetObjects[2].GetSaveString();
						if (sParamSheet2 != "") {
							sParam += "&" + ComSetPrifix(sParamSheet2, "sheet3_");
						}
						 
						//if (sParam == "") return;
						sParam += "&" + FormQueryString(formObj);
						var sXml = sheetObj.GetSaveXml("ESM_BKG_0061GS.do", sParam);						 
    					sheetObjects[2].LoadSaveXml(sXml);
    					
 				    	//sheetObjects[2].DoSave("ESM_BKG_0061GS.do", FormQueryString(formObj));
 				    	
 				    	
 				    	formObj.f_cmd.value = SEARCH;
 	 					
 	 					if(formObj.cargoType.checked == true)
 	 						formObj.mt_flag.value = "P";
 	 					else formObj.mt_flag.value = "F";
 	 					formObj.vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
 	 					formObj.skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
 	 					formObj.skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);	
 	 					 
 	 					 
 	 					sXml = sheetObj.GetSearchXml("ESM_BKG_0061GS.do", FormQueryString(formObj));
 						 
 						var arrXml = sXml.split("|$$|");
 						 
 				   	  	if (arrXml.length > 0) {			   	  		 
 				   	  	    sheetObjects[0].LoadSearchXml(arrXml[0]);
 				   	  	}
 				   	  	if (arrXml.length > 1) {
 				   	  		sheetObjects[1].LoadSearchXml(arrXml[1]);
 				   	  	} 
 				   	  	if (arrXml.length > 2) {
 				   	  		sheetObjects[2].LoadSearchXml(arrXml[2]);
 				   	  	}			   	  	
 				   	    ComEtcDataToForm(formObj, sheetObj);
 				   	     
 				   	    sheetObjects[1].DataInsert(-1);
 				   	    var aa = sheetObjects[1].CellValue(1, 2);
 				   	    var bb = sheetObjects[1].CellValue(2, 2);
 				   	    sheetObjects[1].CellValue2(3, 1) = "Differ";
 				   	    sheetObjects[1].CellValue2(3, 2) = aa - bb;
 				    	
 				 	}
 				 	ComOpenWait(false);
 				break;
         }
     }
     
     /**
      * BackEndJob 실행결과조회.
      */
     function doActionValidationResult(sheetObj, sKey) {
    	 sheetObjects[2].WaitImageVisble = false;
    	 var sXml = sheetObj.GetSearchXml("ESM_BKG_0061GS.do?f_cmd=" + SEARCH03
     			+ "&key=" + sKey);
     	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
     	
     	// 에러가 발생했을 경우 대기사항을 종료한다.
     	if (!ComBkgErrMessage(sheetObj, sXml)) {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		return;
     	}
     	if (sJbStsFlg == "SUCCESS") {
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// 성공메시지 보여주고
     		ComShowCodeMessage('BKG00204');
     		//ComShowMessage(ComResultMessage(sXml));
     		// sheet1, sheet2 다시 조회
     		var selRow = sheetObjects[0].SelectRow;
				doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
				//doActionIBSheet(sheetObjects[0],document.form, SEARCH02, selRow);	
     		return;
     	} else if (sJbStsFlg == "FAIL") {
     		//에러
     		clearInterval(intervalId);
     		ComOpenWait(false);
     		// 에러메시지 보여주고
     		ComShowMessage(ComResultMessage(sXml));
     	}
     }     

     function  sheetRejectCheck(sheetObj,gubun)
     {    	      	  
    	 if(sheetObj.RowCount > 0 && gubun == "R")
    	 {
    		 for(i=1;i<sheetObj.RowCount+1;i++){       			  
    			 if(sheetObj.CellValue(i,"rtm_re_msg_sts_cd") == gubun)
    			     sheetObj.CellValue2(i, "del_chk") = 1;    			 
    		 }
    	 }
    	 if(sheetObj.RowCount > 0 && gubun == "A")
    	 {
    		 for(i=1;i<sheetObj.RowCount+1;i++){       			  
    			 if(sheetObj.CellValue(i, "del_chk") == 1)
    			     sheetObj.CellValue2(i, "del_chk") = 0;    			 
    		 }
    	 }
    	  
     }
     /**
      * 그리드에서 선택한 BL_NO에 대한 정보를 가져온다.
      */
     function sheet3_OnClick(sheetObj, row, col) {
    	 var formObject = document.form;    	  
    	 formObject.bl_no.value  =  sheetObj.CellValue(row, "bl_no").substring(0,12);
    	 formObject.bkg_no.value =  sheetObj.CellValue(row, "bkg_no");
    	 if(formObject.cargoType.checked == true)
    		 formObject.mt_flag.value = "P";
		 else formObject.mt_flag.value = "F";
    	 //sheetObj.CellValue2(row, "ibflag") = "I";
    	 
    	 var rowCnt = sheetObj.RowCount;
    	 var check = sheetObj.CellValue(row,"del_chk");
    	 var keyBlNo = sheetObj.CellValue(row,"bl_no");
    	 var colSaveName = sheetObj.ColSaveName(col);
    	 
    		for(i=1; i<=rowCnt+1; i++) {
    			
    			if(colSaveName != "del_chk") {
    			
    	    		if(check == 0) {
    	    			
    	    			//if(i == row)
    	    			//   continue;
    	    			 
    	    			if(keyBlNo == sheetObj.CellValue(i, "bl_no")) {
    	    				sheetObj.CellValue(i, "del_chk") = 1;    	    				 				
    	    			}    	    			     	    			     	    			    	    	
    	    		} else if(check == 1) {
    	    			    	    			 
    	    			//if(i == row)
    	    			// continue;
    	    			    	    		
    	    			if(keyBlNo == sheetObj.CellValue(i, "bl_no")) {
    	    				sheetObj.CellValue(i, "del_chk") = 0;    	    			 
    	    			}    	    			 
    	    		} 
    			} else {
    	    		if(check == 0) {
    	    			
    	    			if(i == row)
    	    			   continue;
    	    			 
    	    			if(keyBlNo == sheetObj.CellValue(i, "bl_no")) {
    	    				sheetObj.CellValue(i, "del_chk") = 1;    	    				 				
    	    			}    	    			     	    			     	    			    	    	
    	    		} else if(check == 1) {
    	    			    	    			 
    	    			if(i == row)
    	    			 continue;
    	    			    	    		
    	    			if(keyBlNo == sheetObj.CellValue(i, "bl_no")) {
    	    				sheetObj.CellValue(i, "del_chk") = 0;    	    			 
    	    			}    	    			 
    	    		}    				
    			}
    		} // end for(i)
    	  
     }
     /**
      *  
      */
     function sheet3_OnChange(sheetObj, row, col, value) {
    	 var kind = sheetObj.CellValue(row, "kind");
    	 var bl_no = sheetObj.CellValue(row, "bl_no");
    	 var status = true;
    	 if(kind == "9")
    	 {
    		 
    		 if(sheetObj.CellValue(row, "dat_cfm_flg") == "N" &&
    				 sheetObj.CellValue(row, "rtm_re_msg_sts_cd") == "")
    		 {
    			 ComShowCodeMessage('BKG00620');
    			 sheetObj.CellValue(row, "kind") = sheetObj.CellValue(row, "bigo_kind");
    			 kind = sheetObj.CellValue(row, "bigo_kind");
    			 status = false;
    		 }
    		 
    		 if(sheetObj.CellValue(row, "dat_cfm_flg") == "Y" &&
    				 (sheetObj.CellValue(row, "bigo_kind") == "5" ||
					 sheetObj.CellValue(row, "bigo_kind") == "1"))
    		 {
    			 ComShowCodeMessage('BKG00621');
    			 sheetObj.CellValue(row, "kind") = sheetObj.CellValue(row, "bigo_kind");
    			 kind = sheetObj.CellValue(row, "bigo_kind");
    			 status = false;
    		 }
    	 } 
    	 if(kind == "5")
    	 {
    		  
    		 if(sheetObj.CellValue(row, "dat_cfm_flg") == "N" &&
    				 sheetObj.CellValue(row, "rtm_re_msg_sts_cd") == "")
    		 {
    			 ComShowCodeMessage('BKG00620');
    			 sheetObj.CellValue2(row, "kind") = sheetObj.CellValue(row, "bigo_kind");
    			 kind = sheetObj.CellValue(row, "bigo_kind");
    			 status = false;
    		 }
    		 if(sheetObj.CellValue(row, "dat_cfm_flg") == "Y" &&
    				 sheetObj.CellValue(row, "rtm_re_msg_sts_cd") != "A" || 
    				 (sheetObj.CellValue(row, "bigo_kind") != "5" &&
    						 sheetObj.CellValue(row, "bigo_kind") != "9")
    			)
    		 {
    			 ComShowCodeMessage('BKG00622');
    			 sheetObj.CellValue(row, "kind") = sheetObj.CellValue(row, "bigo_kind");
    			 kind = sheetObj.CellValue(row, "bigo_kind");
    			 status = false;
    		 }
    	 } 
    	 if(kind == "1")
    	 {
    		 if(sheetObj.CellValue(row, "dat_cfm_flg") == "N" &&
    				 sheetObj.CellValue(row, "rtm_re_msg_sts_cd") == "")
    		 {
    			 ComShowCodeMessage('BKG00620');
    			 sheetObj.CellValue2(row, "kind") = sheetObj.CellValue(row, "bigo_kind");
    			 kind = sheetObj.CellValue(row, "bigo_kind");
    			 status = false;
    		 } 
    		     		 
    		 if(sheetObj.CellValue(row, "dat_cfm_flg") == "Y" &&
    				 sheetObj.CellValue(row, "rtm_re_msg_sts_cd") != "A" || 
    				 (sheetObj.CellValue(row, "bigo_kind") != "5" &&
    						 sheetObj.CellValue(row, "bigo_kind") != "9")
    			)
    		 {
    			 ComShowCodeMessage('BKG00623');
    			 sheetObj.CellValue2(row, "kind") = sheetObj.CellValue(row, "bigo_kind");
    			 kind = sheetObj.CellValue(row, "bigo_kind");
    			 status = false;
    		 }
    	 }
		 if ( status == true ) 
		 {
			 for ( var i=1 ; i<=sheetObj.RowCount+1 ; i++ )
			 {
				 if ( sheetObj.CellValue(row, "seq") == sheetObj.CellValue(i, "seq") )
				 {
					 sheetObj.CellValue(i, "kind") = kind;
				 }
			 }
		 }
     }
      /**
       * Enter 이벤트
       * @return
       */
      function obj_ComKeyEnter() {
      	
       	var formObject = document.form;
       	var srcName = window.event.srcElement.getAttribute("name");
          
       	if(srcName != "") {         		 
       		ComKeyEnter();
       	}         	         
      }
       /**
        * 조회조건 입력할 때 처리
        */
       function obj_KeyUp() {
   		var formObject = document.form;
   		var srcName = window.event.srcElement.getAttribute("name");
   		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
   		var srcValue = window.event.srcElement.getAttribute("value");

   		if (  ( srcName == "frm_crn_number" || 
   				srcName == "frm_vvd_number" || 
   				srcName == "pol_cd")         				 
   			&& ComChkLen(srcValue, srcMaxLength) == "2") 
   		{
   			ComSetNextFocus();
   		}
   	}
       
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
    	 
    	case COMMAND03: // 저장
    			return true;
    		break;
  		case IBSEARCH: // 조회
  		    
  			if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
 				ComShowCodeMessage('BKG00538');
 				formObj.frm_vvd_number.focus();
 				return false;
 			}
  			
  			if (ComIsNull(formObj.frm_vvd_number))
 			{
 				ComShowCodeMessage('BKG00554','VVD');
 				formObj.frm_vvd_number.focus();
 				return false;
 			}
  			
  			if (ComIsNull(formObj.frm_crn_number)){
  				ComShowCodeMessage('BKG00554','CRN');
 				formObj.frm_crn_number.focus();
 				return false;
  			}
 			
  			/*
  			if (formObj.frm_vvd_number.value.length == 0 && formObj.frm_crn_number.value.length == 0) {
  				ComShowCodeMessage('BKG00591');
  				formObj.frm_crn_number.focus();
  				return false;
  			}
  			      	*/	     		
  			return true;
  			break;
  			
  		case COMMAND01: // ADD
		     
			if (formObj.frm_crn_number.value.length == 0) {
				ComShowCodeMessage('BKG00607');
				formObj.frm_crn_number.focus();
				return false;
			}
			      		     		
		return true;
			break;
			
  		case COMMAND02: // confirm all
	     
  			if (formObj.frm_crn_number.value.length == 0) {
  				ComShowCodeMessage('BKG00607');
  				formObj.frm_crn_number.focus();
  				return false;
  			}
		      		     		
  		return true;
		break;
		
  		case IBDELETE: // 
	     
  			var vIsCheck = false;
			for(var i=1; i <= sheetObj.RowCount; i++) {
				if (sheetObj.CellValue(i, "del_chk") == 1) {
					vIsCheck = true;
					break;
				}
			}
			if (!vIsCheck) {
				ComShowCodeMessage('BKG00567');
				return false;
			}
		return true;
		 
  		case IBSAVE: // 저장
  		var vIsCheck = false;
		for(var i=1; i <= sheetObj.RowCount; i++) {
			if (sheetObj.CellValue(i, "del_chk") == 1) {
				vIsCheck = true;
				break;
			}
		}
		if (!vIsCheck) {
			ComShowCodeMessage('BKG00567');
			return false;
		}
  		return true;
  			 break;
  		}	
     }
     
	function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
		//alert("a");
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == IBSAVE) {
				ComShowCodeMessage('BKG00204');
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			} 
		} else {
			//ComShowCodeMessage('BKG00391');
		}
	}     
         
         