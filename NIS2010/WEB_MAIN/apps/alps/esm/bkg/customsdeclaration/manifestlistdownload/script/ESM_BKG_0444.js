/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0444.js
*@FileTitle : ESM_BKG-0444
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.01 임재택
* 1.0 Creation
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
    function esm_bkg_0444() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick         = sheet1_OnClick;
    	this.sheet1_OnKeyUp         = sheet1_OnKeyUp; 
    	this.sheet1_OnDblClick         = sheet1_OnDblClick;    	
    }
    
 // 공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet1Flag = 0;
    var sheet2Flag = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		         var sheetObject1 = sheetObjects[0];
    		         var sheetObject2 = sheetObjects[1];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

    							case "btn_retrieve":
    								doActionIBSheet(sheetObject1, formObject, IBSEARCH, "RE");
    							break;
    							
    							case "btn_new":
    								sheetObject1.RemoveAll();
    								sheetObject2.RemoveAll();
    							break;							
    							
    							case "btn_downexcel":
    								sheetObject1.SpeedDown2Excel(0,false,false,"","",false,false,"",false,"ibflag|Chk|vsl_call_ref_sts_cd","",false,"");
    							break;				

    							case "btn_print":
    								alert(srcName);
    							break;
    							
    							case "btn_bl":
    								doActionIBSheet(sheetObject1, formObject, COMMAND01);
    							break;	
    							
    							case "btn_list":
    								doActionIBSheet(sheetObject1, formObject, COMMAND03);
    							break;
    							
    							case "btn_calendar": //달력버튼
    					        	// 조회전 일땐 사용못하게 ...
    					            var cal = new ComCalendarFromTo();
    					            cal.select(formObject.vps_eta_start_dt,formObject.vps_eta_end_dt, 'yyyy-MM-dd');
    					        break;	
    					            
    							case "btn_addLane":
    								doActionIBSheet(sheetObject1,formObject,COMMAND04);
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
            
            axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
        	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
        	 
            
            var formObject = document.form;
            
            if(formObject.cn_no.value != "" || formObject.vvd_no.value != "")
            {
            	if(formObject.vvd_no.value.length > 0)
            	{
            		formObject.vsl_cd.value = formObject.vvd_no.value.substring(0,4);
            		formObject.skd_voy_no.value = formObject.vvd_no.value.substring(4,8);
            		formObject.skd_dir_cd.value = formObject.vvd_no.value.substring(8);
            		formObject.vvd_number.value = formObject.vvd_no.value;
            	}
            	 
            	formObject.frm_crn_number.value = formObject.cn_no.value;
            	
            	var sheetObject1 = sheetObjects[0];
            	doActionIBSheet(sheetObject1,document.form,IBSEARCH);	
            	formObject.frm_crn_number.focus();
            }
                                
        	formObject.vps_eta_start_dt.focus();
        	        
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
                case "sheet1":      //sheet1 init
                    with (sheetObj) {
                        // 높이 설정
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
                        InitRowInfo( 1, 1, 3, 100);

    					          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(14, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        var HeadTitle1 = "|Check|Seq.|Lane|CRN|VVD|Call Date|Vessel Name|POD|Calling\n Seq|User ID|Creation Status|Created Date|";
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	  0,    daCenter,  false,  "ibflag");
    	                InitDataProperty(0, cnt++ , dtRadioCheck,	 40,    daCenter,    false,  "Chk");
                        InitDataProperty(0, cnt++ , dtSeq,	 	 30,    daCenter,    true,     "Seq",     	false,    "",      dfNone, 		0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,    true,     "slan_cd",     	false,    "",      dfNone, 		0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData, 	 95,    daCenter,    true,     "vsl_call_ref_no",       false,    "",      dfNone, 		0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      95,    daCenter,    true,     "vvd_number",       false,    "",      dfNone, 		0,     false,		false);
                                                                                                                                                       
                        InitDataProperty(0, cnt++ , dtData,      80,    daCenter,    true,     "vps_eta_dt",  false,    "",      dfNone, 0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData, 	200,    daLeft,    true,     "vsl_eng_nm",    false,    "",      dfNone, 		0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData,   	 80,    daCenter,	 true,     "vps_port_cd",      	false,    "",      dfNone, 		0,     false,		false);
                        
                        InitDataProperty(0, cnt++ , dtData,      55,    daCenter,    true,     "pod_clpt_ind_seq",       false,    "",      dfNone, 		0,     false,		false);
                        
                        InitDataProperty(0, cnt++ , dtData, 	 95,    daCenter,    true,     "cstms_decl_usr_id",    false,    "",      dfNone, 		0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      95,    daCenter,    true,     "vsl_call_ref_sts_cd_nm",  false,    "",      dfNone, 		0,     false,		false);                                                      
    					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,    true,     "bl_cre_dt",   false,    "",      dfNone, 0,     false,		false);
    					InitDataProperty(0, cnt++ , dtHidden,    60,    daCenter,    true,     "vsl_call_ref_sts_cd",   false,    "",      dfNone, 0,     false,		false);


                   }
                    break;
                     
                      
                case "sheet2":      //sheet1 init
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
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 3, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(10, 10, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, false, false, true, false,false)

                        var HeadTitle1 = "|Check|Seq.|POL|POD ATD|POD|BDR|BDR DATE|Sub B/L TTL\n(Excl. Non-BDR)|Sub B/L TTL\n(Incl. Non-BDR)|";
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,	    0,     daCenter,    false,    "ibflag");
    	                InitDataProperty(0, cnt++ , dtRadioCheck,	 	40,    daCenter,    false,    "Chk");
                        InitDataProperty(0, cnt++ , dtSeq,	 		 	60,    daCenter,    true,     "Seq",     	false,    "",      dfNone, 		0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      		60,    daCenter,    true,     "vps_port_cd",     	false,    "",      dfNone, 		0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData, 		 	120,   daCenter,    true,     "vps_etd_dt",       false,    "",      dfUserFormat2, 		0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      		70,    daCenter,    true,     "pod",       false,    "",      dfNone, 		0,     false,		false);
                                                                                                                                                       
                        InitDataProperty(0, cnt++ , dtData,      		70,    daCenter,    true,     "trnk_bdr_flg",  			false,    "",      dfNone, 		0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData, 	 		120,   daCenter,    true,     "trnk_auto_bdr_dt",    	false,    "",      dfUserFormat2, 		0,     false,		false);
                        InitDataProperty(0, cnt++ , dtData,   	 		130,    daRight,	true,     "excl_count",      	false,    "",      dfNone, 		0,     false,		false);
    		            InitDataProperty(0, cnt++ , dtData,   	 		95,    daRight,	    true,     "incl_count",      	false,    "",      dfNone, 		0,     false,		false);


    		            InitUserFormat2(0, "vps_etd_dt", "####-##-## ##:##", "-|:" );
    					InitUserFormat2(0, "trnk_auto_bdr_dt", "####-##-## ##:##", "-|:" );
                   }
                    break;                  
                     
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction,gubun) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

    			case IBSEARCH:      //조회
    			     if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					  }
    				  sheetObj.WaitImageVisible = false;
    				  sheetObjects[1].WaitImageVisible = false;
    				  ComOpenWait(true);
    			      sheetObjects[0].RemoveAll(); 
    			      sheetObjects[1].RemoveAll(); 
    				  formObj.f_cmd.value = SEARCH;
    				  //sheet1Flag = 0;
    				  sheet2Flag = 0;    				   
    	       	 	  formObj.vsl_cd.value = formObj.vvd_number.value.substring(0,4);
    	       	 	  formObj.skd_voy_no.value = formObj.vvd_number.value.substring(4,8);
    	       	 	  formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8);
    				 
    			      sheetObj.DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObj) );
    			      
    			      
    			      if ( sheet1Flag == 0 )
    			    	  sheet1Flag = 1;
    			      //alert(sheet1Flag);
    			      if ( gubun == "PR" )
    			    	  sheetObjects[0].SelectCell(sheet1Flag,1);
    			      //Add.
    			      formObj.pod_clpt_ind_seq.value = sheetObjects[0].CellValue(1, "pod_clpt_ind_seq"); // Add. 2015.04.13
    			      
    			      goDblClick(sheetObjects[0].SelectRow, sheetObjects[0].SelectCol);
    			      ComOpenWait(false);
    			break;
    					
    			case COMMAND01:        //B/L Create
    			    
    				
    				if(!validateForm(sheetObj,formObj,sAction)) {
    					return false;
    				}
    			    //alert(sheet1Flag + "--"+ sheet2Flag);
    			    formObj.f_cmd.value = MULTI;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    			    //alert(sheetObjects[0].CellValue( sheet1Flag, 4 ));
    			    formObj.vsl_cd.value     = sheetObjects[0].CellValue( sheet1Flag, "vvd_number" ).substring(0,4);
    			    formObj.skd_voy_no.value = sheetObjects[0].CellValue( sheet1Flag, "vvd_number" ).substring(4,8);
    			    formObj.skd_dir_cd.value = sheetObjects[0].CellValue( sheet1Flag, "vvd_number" ).substring(8);
    				//Add.
    			    formObj.pod_clpt_ind_seq.value = sheetObjects[0].CellValue( sheet1Flag, "pod_clpt_ind_seq" ); // add. 2015.04.13
    	        	
    				if(ComShowCodeConfirm("BKG00573")){  
    					sheetObjects[1].DoSave("ESM_BKG_0444GS.do", FormQueryString(formObj) );	
    				}
    				ComOpenWait(false);
    				//sheetObjects[0].RemoveAll(); 
 			        //sheetObjects[1].RemoveAll();  
 			        //sheet1Flag = 0;
 			        sheet2Flag = 0;
    				formObj.f_cmd.value = SEARCH;   
    				 
   	       	 	  	formObj.vsl_cd.value = formObj.vvd_number.value.substring(0,4);
   	       	 	  	formObj.skd_voy_no.value = formObj.vvd_number.value.substring(4,8);
   	       	 	  	formObj.skd_dir_cd.value = formObj.vvd_number.value.substring(8);
   	       	 	  	sheetObjects[0].SelectCell(sheet1Flag,1);
   	       	 	  	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "PR");
   	       	 	  	//sheetObj.DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObj) );  			       
  			         
    			break;
    			
    			case COMMAND03:        //
    				if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
    				var sUrl = "/hanjin/ESM_BKG_0061.do?pgmNo=ESM_BKG_0061&crn_no="+sheetObjects[0].CellValue( sheet1Flag, "vsl_call_ref_no" )+"&pop_up=Y"
    						+ "&vvd_no="+sheetObjects[0].CellValue(sheet1Flag, "vvd_number");
    				ComOpenWindowCenter(sUrl, "ESM_BKG_0061", 1024, 660, true);
					 
				break;
				
    			case COMMAND04:
					ComOpenWindowCenter("ESM_BKG_1135.do" , "1095", 400, 280, true);
				break;
    				 
            }
        }

        /**
         * sheet1에서 클릭한 vvd정보를 가지고 portlist list정보를가지고온다.
         */
        function sheet1_OnDblClick(sheetObj, row, col) { 
        	var formObject = document.form;
        	formObject.f_cmd.value = SEARCH01;
        	
			//ComOpenWait(true);
        	formObject.frm_slan_cd.value = sheetObjects[0].CellValue( row, "vsl_call_ref_sts_cd_nm" );
        	formObject.lane_cd.value = sheetObjects[0].CellValue( row, "slan_cd" );
        	formObject.crn_number.value = sheetObjects[0].CellValue( row, "vsl_call_ref_no" );
        	formObject.vsl_call_ref_no.value = sheetObjects[0].CellValue( row, "vsl_call_ref_no" );
        	sheetObjects[0].CellValue2( row, "Chk" ) = 1; 
        	sheetObjects[0].CellValue2( row, "ibflag" ) = "U";
        	formObject.vsl_cd.value     = sheetObjects[0].CellValue( row, 5 ).substring(0,4);
        	formObject.skd_voy_no.value = sheetObjects[0].CellValue( row, 5 ).substring(4,8);
        	formObject.skd_dir_cd.value = sheetObjects[0].CellValue( row, 5 ).substring(8);

        	formObject.pod_clpt_ind_seq.value = sheetObjects[0].CellValue( row, "pod_clpt_ind_seq" ); // add. 2015.04.13
        	
        	sheetObjects[1].DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObject) );	 	    	 	   
        	sheet1Flag = row;  
        	//ComOpenWait(false);
        }
        
        /**
         * sheet1에서 클릭한 vvd정보를 가지고 portlist list정보를가지고온다.
         */
        function goDblClick(row, col) { 
        	var formObject = document.form;
        	formObject.f_cmd.value = SEARCH01;
			//sheetObj.WaitImageVisible = false;
			//ComOpenWait(true);
        	formObject.frm_slan_cd.value = sheetObjects[0].CellValue( row, "vsl_call_ref_sts_cd_nm" );
        	formObject.lane_cd.value = sheetObjects[0].CellValue( row, "slan_cd" );
        	formObject.crn_number.value = sheetObjects[0].CellValue( row, "vsl_call_ref_no" );
        	formObject.vsl_call_ref_no.value = sheetObjects[0].CellValue( row, "vsl_call_ref_no" );
        	sheetObjects[0].CellValue2( row, "Chk" ) = 1; 
        	sheetObjects[0].CellValue2( row, "ibflag" ) = "U";
        	formObject.vsl_cd.value     = sheetObjects[0].CellValue( row, 5 ).substring(0,4);
        	formObject.skd_voy_no.value = sheetObjects[0].CellValue( row, 5 ).substring(4,8);
        	formObject.skd_dir_cd.value = sheetObjects[0].CellValue( row, 5 ).substring(8);
        	
        	formObject.pod_clpt_ind_seq.value = sheetObjects[0].CellValue( row, "pod_clpt_ind_seq" ); // add. 2015.04.13
        	
        	sheetObjects[1].DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObject) );	 	    	 	   
        	sheet1Flag = row;    
        	//ComOpenWait(false);
        }        
         /**
          * 
          * @param sheetObj
          * @param row
          * @param col
          * @return
          */
         function sheet1_OnClick(sheetObj, row, col) { 
         	var formObject = document.form;         	 
         	formObject.frm_slan_cd.value = sheetObjects[0].CellValue( row, "vsl_call_ref_sts_cd_nm" );
         	formObject.lane_cd.value = sheetObjects[0].CellValue( row, "slan_cd" );
         	formObject.crn_number.value = sheetObjects[0].CellValue( row, "vsl_call_ref_no" );
         	formObject.vsl_call_ref_no.value = sheetObjects[0].CellValue( row, "vsl_call_ref_no" );
         	sheetObjects[0].CellValue2( row, "Chk" ) = 1; 
         	sheetObjects[0].CellValue2( row, "ibflag" ) = "U";
         	formObject.vsl_cd.value     = sheetObjects[0].CellValue( row, 5 ).substring(0,4);
         	formObject.skd_voy_no.value = sheetObjects[0].CellValue( row, 5 ).substring(4,8);
         	formObject.skd_dir_cd.value = sheetObjects[0].CellValue( row, 5 ).substring(8);
         	
         	formObject.pod_clpt_ind_seq.value = sheetObjects[0].CellValue( row, "pod_clpt_ind_seq" ); // add. 2015.04.13
        	
         	sheet1Flag = row;        	
         }
         /**
          * 
          * @param sheetObj
          * @param row
          * @param col
          * @return
          */
         function sheet2_OnClick(sheetObj, row, col) { 
         	var formObject = document.form;   
         	sheetObjects[1].CellValue2( row, "Chk" ) = "1";
         	if(sheetObjects[1].RowCount > 0)
	 	    {
	 	    	sheetObjects[1].CellValue2( row, "ibflag" ) = "U";	 	    	
	 	    }
         	formObject.pol_cd.value = sheetObjects[1].CellValue( row, "vps_port_cd" )
 	 	    sheet2Flag = row;
         } 



/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
       switch (sAction) {
       		case IBSEARCH: // 조회
       		if(formObj.vps_eta_start_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_start_dt.value, "ymd"))
  			{
  				ComShowCodeMessage('BKG00377');
  				formObj.vps_eta_start_dt.focus();
  				return false;
  			}
       		if(formObj.vps_eta_end_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_end_dt.value, "ymd"))
  			{
  				ComShowCodeMessage('BKG00377');
  				formObj.vps_eta_end_dt.focus();
  				return false;
  			}
       		if ( ComChkPeriod(formObj.vps_eta_start_dt.value, formObj.vps_eta_end_dt.value) < 1 )
			{
				//alert("기간이 정확하지 않습니다.");
				ComShowCodeMessage('BKG00626','기간이 정확하지 않습니다.');
				formObj.vps_eta_start_dt.focus();
				return false;				
			}
       		
       		if (formObj.frm_crn_number.value == "" && formObj.vvd_number.value == "" 
       			&& (formObj.vps_eta_start_dt.value == "" || formObj.vps_eta_end_dt.value == "") ) 
			{
				ComShowCodeMessage('BKG00564');
				formObj.vps_eta_start_dt.focus();
				return false;
			} 
       	       		     		
       		return true;
       			break;
       			
       		case COMMAND01: // ADD
     		     
     			 
       			if (formObj.frm_slan_cd.value  == "Cancel") {
       				ComShowCodeMessage('BKG00572');       				 
       				return false;
       			}  
       		    
       			if(sheet1Flag != 0)
       			{       			 
       				if(sheetObjects[0].CellValue( sheet1Flag, "vsl_call_ref_no" ) == "")
       				{
       					ComShowCodeMessage('BKG00569');      				 
           				return false;
       				}
       			}
       			if(sheet1Flag == 0)
       			{       				 
       				ComShowCodeMessage('BKG00567');       				 
       				return false;
       			}
       			if(sheet2Flag == 0)
       			{
       				ComShowCodeMessage('BKG00568');       				 
       				return false;
       			}
     			      		     		
     		return true;
     			break;
     			
       	
       		case COMMAND03: // B/L list
       		     
       		    if(sheet1Flag == 0)
				{
					ComShowCodeMessage('BKG00567');       				 
					return false;
				}
				if (sheetObjects[0].CellValue( sheet1Flag, "vsl_call_ref_sts_cd_nm" )  == "Cancel") {
					ComShowCodeMessage('BKG00572');				 
					return false;
				}				 			      		     
       		return true;
 		break;
     		
       		 
       		}	
        }  
/**
* HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
**/
function obj_KeyUp() {
	     
	    var formObject = document.form;        
	    var srcName = window.event.srcElement.getAttribute("name");
	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	    var srcValue = window.event.srcElement.getAttribute("value");
	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
	    	ComSetNextFocus();        	    		
	    }
}
/**
 * Enter 이벤트
 * @return
 */
function obj_ComKeyEnter() {
	
 	var formObject = document.form;
 	var srcName = window.event.srcElement.getAttribute("name");
    
 	if(srcName != "fax_no" && srcName != "cust_eml" 
 		&& srcName != "shpr_addr1" && srcName != "cnee_addr1" && srcName != "ntfy_addr1"
 		&& srcName != "shpr_addr2" && srcName != "cnee_addr2" && srcName != "ntfy_addr2" && srcName != "") {         		 
 		ComKeyEnter();
 	}         	         
}
 /**
  * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
  **/
 function obj_activate(){
	//입력Validation 확인하기
	 var formObj = document.form;
	switch(event.srcElement.name){
		case "vps_eta_start_dt":
			//ComClearSeparator(event.srcElement);
			formObj.vps_eta_start_dt.value = formObj.vps_eta_start_dt.value.replace(eval("/-/gi"), "");
			break;	
    	case "vps_eta_end_dt":
    		//ComClearSeparator(event.srcElement);
    		formObj.vps_eta_end_dt.value = formObj.vps_eta_end_dt.value.replace(eval("/-/gi"), "");
			break;
		default:
			break;
			//return;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_deactivate(){
	//if (event.srcElement.getAttribute("required") != null) return;
	
    //입력Validation 확인하기
	switch(event.srcElement.name){
	
    	case "vps_eta_start_dt":
    		//ComAddSeparator(event.srcElement);
    		 ComChkObjValid(event.srcElement);
			break;
    	case "vps_eta_end_dt":
    		//ComAddSeparator(event.srcElement);
    		 ComChkObjValid(event.srcElement);
			break;
		default:
			break;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}  