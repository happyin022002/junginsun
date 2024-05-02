/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0083.js
*@FileTitle  : Weekly L/F by POL/POD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
    // 공통전역변수
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var param="";
    var bse_dt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    var init_year='';
    var init_week='';
    var init_duration='';
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	/*******************************************************/
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObject.reset();
    				resetAll(); 
					document.form.full_flg.value='F';
    				formObject.year.value=init_year;
					formObject.week.value=init_week;  
					formObject.temp_duration.value=init_duration;
					SpcSearchOptionWeek("week",false,document.form.year.value);
					SpcSearchOptionTrade("trade");
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("rlane_cd"); // 0207 SHKIM    
    				break;
    			case "btn_downexcel":
    				if(sheetObject.RowCount() < 1){//no data
    					ComShowCodeMessage("COM132501");
    				}else{
    					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				}
    				
    				break;
    			case "btn_bsa":
    				var sUrl="/hanjin/ESM_SPC_0084.do";
  		          	ComOpenPopup(sUrl, 600, 400, "", "0,0", true, false, "", "", "","BSA INPUT"); 
    				break;    				
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
    	comObjects[comboCnt++]=combo_obj;
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
     	SpcSearchOptionYear("year");
     	SpcSearchOptionWeek("week");
     	SpcSearchOptionDuration("temp_duration", 5, 3);
     	SpcSearchOptionTrade("trade");
     	SpcSearchOptionSubTrade("subtrade", true, true);
     	SpcSearchOptionLane("rlane_cd");
     	SpcSearchOptionBound("bound",false,true,false,false);
    	for(i=0;i<sheetObjects.length;i++) {
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	var sheetResizeFull=true;
    	document_onresize();
    	sheetObjects[0].SetWaitImageVisible(0);
    	doActionIBSheet(sheetObjects[0],document.form,SEARCHLIST01);	//헤더 주차 조회  	
    	document.form.year.focus();
    	document.form.full_flg.value='F';
    	init_year=document.form.year.value; // 년 초기화용
    	init_week=document.form.week.value; // 주차 초기화용
    	init_duration=document.form.temp_duration.value; // 기간 초기화용
    }
    /**
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initCombo (comboObj, comboNo) {
    }
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle1) {
       var cnt=0;
       with (sheetObj) {
	       switch (sheetObj.id) {
           case "sheet1":      //t1sheet1 init
               var colCnt=0;
               if (headTitle1==null || headTitle1 =="") {
	               headTitle1="Sub Trade\n/Lane|POL|POD|200701|200701|200701|200701|200701|200701|200701|200701|200701|200701|200701|200701|200702|200702|200702|200702|200702|200702|200702|200702|200702|200702|200702|200702|200703|200703|200703|200703|200703|200703|200703|200703|200703|200703|200703|200703|200704|200704|200704|200704|200704|200704|200704|200704|200704|200704|200704|200704|200705|200705|200705|200705|200705|200705|200705|200705|200705|200705|200705|200705|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|||||";
	               headTitle2="Sub Trade\n/Lane|POL|POD|COM|COM|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|COM|COM|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|COM|COM|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|COM|COM|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|COM|COM|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|COM|COM|COS|COS|KKL|KKL|YML|YML|OTH|OTH|POL TTL|POL TTL|||||";
	               headTitle3="Sub Trade\n/Lane|POL|POD|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|TEU|WGT|||||";
	               (63, 0, 0, true);
	               colCnt=5;
               } else {
            	   colCnt=eval(document.form.duration.value);
               }
               headCnt=headTitle1.split("|").length;
               (headCnt, 3, 0, true);
               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
               var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:headTitle1, Align:"Center"},{ Text:headTitle2, Align:"Center"},{ Text:headTitle3, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub_rlane_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                                       if ( document.form.polpod_flg.value == 'POD' ) {    //POD별 조회면 POL,POD 순서를 바꿔준다.
                                    	   cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                                    	   cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               } else {
            	   cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
            	   cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               }
               for(var i=1 ; i <= 5 ; i++){
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_com_qty",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_com_wgt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_cos_qty",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_cos_wgt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_kkl_qty",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_kkl_wgt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_yml_qty",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_yml_wgt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_oth_qty",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_oth_wgt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_pol_qty",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	               cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wk"+i+"_pol_wgt",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               }
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_com_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_com_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_cos_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_cos_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_kkl_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_kkl_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_yml_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_yml_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_oth_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_oth_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_pol_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"gtl_pol_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"level",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lvl0",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"grp_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"width",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
               for ( var i=21; i<headCnt-6; i++ ) {	  //최초 로딩시 3주차 까지 view
               sheetObj.SetColHidden(i,1);
               }
               InitColumns(cols);
               SetEditable(0);
               SetSheetHeight(350);
               SetFocusEditMode(default_edit_mode);
               sheetObj.ShowTreeLevel(0,1);
               //InitTreeInfo("level", "level", "#0000FFNAN");	
	           sheetObj.SetColHidden(headCnt-1,1);//width컬럼 hidden처리
	           break;
	       }
       }
    }
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
	        case IBSEARCH:      //조회 
				if(!validateForm(sheetObj,formObj,sAction)){
		            return false;
		        }
	        	document.form.duration.value=document.form.temp_duration.value;	//temp 값을  duration에 세팅
	        	if ( document.form.vvd.value !='' ) {	//vvd값이 있을경우 1주차로 처리한다.
	        		document.form.duration.value='1'; 	        		
	        	}
	        	sheetObj.RemoveAll();
		        sheetObj.ReDraw=false;
		        sheetObj.SetWaitImageVisible(1);
		        doActionIBSheet(sheetObj,document.form,SEARCHLIST01);	//헤더 주차 조회 
		        formObj.f_cmd.value=SEARCHLIST;
		        var param=SpcFormString(formObj,'f_cmd,year,week,duration,rlane_cd,pol_cd,trade,subtrade,rhq,bound,operator,vvd,full_flg,polpod_flg');
		        sheetObj.DoSearch("ESM_SPC_0083GS.do", param);
		        break;
	        case SEARCHLIST01:      //헤더 조회 및 세팅
				form.f_cmd.value=SEARCHLIST01;
	        	document.form.duration.value=document.form.temp_duration.value;	//temp 값을  duration에 세팅
	        	if ( document.form.vvd.value !='' ) {	//vvd값이 있을경우 1주차로 처리한다.
	        		document.form.duration.value='1'; 	        		
	        	}
	        	var sXml=sheetObj.GetSearchData("ESM_SPC_0083GS.do" , FormQueryString(form));
				//헤더 데이터를 설정한다.
				bse_dt=ComGetEtcData(sXml,"bse_dt");
				var headTitle='';
    			for ( var i=0; i<bse_dt.split("|").length; i++ ) {
    				for ( var j=0; j<12; j++ ) {
        				headTitle=headTitle + bse_dt.split("|")[i]+"|";
    				}
    			} 
    			headTitle="Sub Trade\n/Lane|POL|POD|"+headTitle+"G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL|G. TTL";
    			var headTitleCnt=headTitle.split("|").length;
    			for ( var i=0; i<headTitleCnt; i++ ) {
    				sheetObj.SetCellValue(0,i,headTitle.split("|")[i],0);
    			}
    			if ( document.form.polpod_flg.value == 'POD' ) {	//POD 조회시 헤더 변경
        			sheetObj.SetCellValue(0,1,"POD",0);
        			sheetObj.SetCellValue(0,2,"POL",0);
        			sheetObj.SetCellValue(1,1,"POD",0);
        			sheetObj.SetCellValue(1,2,"POL",0);
        			sheetObj.SetCellValue(1,"wk1_pol_qty","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk1_pol_wgt","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk2_pol_qty","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk2_pol_wgt","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk3_pol_qty","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk3_pol_wgt","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk4_pol_qty","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk4_pol_wgt","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk5_pol_qty","POD TTL",0);
        			sheetObj.SetCellValue(1,"wk5_pol_wgt","POD TTL",0);
        			sheetObj.SetCellValue(1,"gtl_pol_qty","POD TTL",0);
        			sheetObj.SetCellValue(1,"gtl_pol_wgt","POD TTL",0);
    			} else if ( document.form.polpod_flg.value == 'POL' ) {	//POD별 조회면 POL,POD 헤더 변경 순서를 바꿔준다.
        			sheetObj.SetCellValue(0,1,"POL",0);
        			sheetObj.SetCellValue(0,2,"POD",0);
        			sheetObj.SetCellValue(1,1,"POL",0);
        			sheetObj.SetCellValue(1,2,"POD",0);
        			sheetObj.SetCellValue(1,"wk1_pol_qty","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk1_pol_wgt","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk2_pol_qty","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk2_pol_wgt","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk3_pol_qty","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk3_pol_wgt","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk4_pol_qty","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk4_pol_wgt","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk5_pol_qty","POL TTL",0);
        			sheetObj.SetCellValue(1,"wk5_pol_wgt","POL TTL",0);
        			sheetObj.SetCellValue(1,"gtl_pol_qty","POL TTL",0);
        			sheetObj.SetCellValue(1,"gtl_pol_wgt","POL TTL",0);
    			}
				var colCnt=eval(document.form.duration.value);
    			var totalCnt=5*12+12+3;		//5*12(5주차)+12(G TTL)+3(LINE,POL,POD) : 총 COL갯수
    			var focCnt=colCnt*12+2;	//
    			for ( var i=0; i<=totalCnt; i++ ) {
    				if ( i > focCnt ) {
    					sheetObj.SetColHidden(i,1);
    				} else {
    					sheetObj.SetColHidden(i,0);
    				}
    			}
    			var gTtlFlag=false;
    			if ( document.form.vvd.value.trim() !='' || document.form.duration.value =='1' ) {	//vvd값이 있을경우 G. TTL 부분 히든처리
    				gTtlFlag=true;
    			}
    			sheetObj.SetColHidden("gtl_com_qty",gTtlFlag);
    			sheetObj.SetColHidden("gtl_com_wgt",gTtlFlag);
    			sheetObj.SetColHidden("gtl_cos_qty",gTtlFlag);
    			sheetObj.SetColHidden("gtl_cos_wgt",gTtlFlag);
    			sheetObj.SetColHidden("gtl_kkl_qty",gTtlFlag);
    			sheetObj.SetColHidden("gtl_kkl_wgt",gTtlFlag);
    			sheetObj.SetColHidden("gtl_yml_qty",gTtlFlag);
    			sheetObj.SetColHidden("gtl_yml_wgt",gTtlFlag);
    			sheetObj.SetColHidden("gtl_oth_qty",gTtlFlag);
    			sheetObj.SetColHidden("gtl_oth_wgt",gTtlFlag);
    			sheetObj.SetColHidden("gtl_pol_qty",gTtlFlag);
    			sheetObj.SetColHidden("gtl_pol_wgt",gTtlFlag);
    			showWeight(document.form.check_weight);	//체크박스 선택시 weight 컬럼을 펼칠지 여부
    			break;
	        case IBDOWNEXCEL:        //엑셀 다운로드
				for(var Row=2; Row<=sheetObj.LastRow(); Row++){	//엑셀 다운로드시 재정렬(문자,숫자 혼용시 랜덤하게 정렬됨)
					var alignFlg="";
					if ( sheetObj.GetCellValue(Row, "lvl0") == '9') {	//VVD자리가 아닐때 정렬 문제 수정
						alignFlg=daCenter;
					} else {
						alignFlg=daRight;
					}					
					for ( var i=1; i<=eval(document.form.duration.value); i++ ) {
					 sheetObj.SetCellAlign(Row,"wk"+i+"_com_qty")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_com_wgt")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_cos_qty")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_cos_wgt")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_kkl_qty")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_kkl_wgt")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_yml_qty")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_yml_wgt")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_oth_qty")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_oth_wgt")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_pol_qty")=alignFlg;
					 sheetObj.SetCellAlign(Row,"wk"+i+"_pol_wgt")=alignFlg;
					}
					sheetObj.SetCellAlign(Row,"gtl_com_qty","Right");
					sheetObj.SetCellAlign(Row,"gtl_com_wgt","Right");
					sheetObj.SetCellAlign(Row,"gtl_cos_qty","Right");
					sheetObj.SetCellAlign(Row,"gtl_cos_wgt","Right");
					sheetObj.SetCellAlign(Row,"gtl_kkl_qty","Right");
					sheetObj.SetCellAlign(Row,"gtl_kkl_wgt","Right");
					sheetObj.SetCellAlign(Row,"gtl_yml_qty","Right");
					sheetObj.SetCellAlign(Row,"gtl_yml_wgt","Right");
					sheetObj.SetCellAlign(Row,"gtl_oth_qty","Right");
					sheetObj.SetCellAlign(Row,"gtl_oth_wgt","Right");
					sheetObj.SetCellAlign(Row,"gtl_pol_qty","Right");
					sheetObj.SetCellAlign(Row,"gtl_pol_wgt","Right");
				}	   

				sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
		      	break;
    	}
    }
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	var trade=comObjects[0].GetSelectCode();
    	var rhq=formObj.rhq.value;
    	var vvd=formObj.vvd.value;
    	if ( vvd.trim() == '' ) {	//vvd값이 없을때만 체크
	    	if(trade == "") {
	    		ComShowMessage(getMsg("SPC90114", "Trade"));
	    		//comObjects[0].focus();
	    		return false;
	    	}
	    	if(rhq == "") {
	    		ComShowMessage(getMsg("SPC90114", "RHQ"));
	    		//formObj.rhq.focus();
	    		return false;
	    	}
    	}
    	return true;
    }
    /*
    * 셀을 클릭했을때 발생하는 이벤트 <br> 
    */
    function sheet1_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "pol":
    		if(sheetObj.GetCellValue(row, col) == "+"){
    			sheetObj.SetRowExpanded(row,1);
   				sheetObj.SetCellValue(row, col,"-",0);
    		}else if(sheetObj.GetCellValue(row, col) == "-"){
    			sheetObj.SetRowExpanded(row,0);
   				sheetObj.SetCellValue(row, col,"+",0);
    		}
    		break;
    	case "pod":
    		if(sheetObj.GetCellValue(row, col) == "+"){
    			sheetObj.SetRowExpanded(row,1);
   				sheetObj.SetCellValue(row, col,"-",0);
    		}else if(sheetObj.GetCellValue(row, col) == "-"){
    			sheetObj.SetRowExpanded(row,0);
   				sheetObj.SetCellValue(row, col,"+",0);
    		}
    		break;
    	}
    }    
    /**
     * sheet1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	sheetObj.ShowTreeLevel(1);
    	showPol(document.form.check_pol);	//체크박스 선택시 pol 컬럼을 펼칠지 여부
    	showPod(document.form.check_pod);	//체크박스 선택시 pod 컬럼을 펼칠지 여부
    	showWeight(document.form.check_weight);	//체크박스 선택시 weight 컬럼을 펼칠지 여부
    	for(var Row=2; Row<=sheetObj.LastRow(); Row++){
			sheetObj.SetCellAlign(Row,"sub_rlane_cd","CenterTop");//정렬 버그 수정
			sheetObj.SetCellAlign(Row,"pol","CenterTop");//정렬 버그 수정
			sheetObj.SetCellAlign(Row,"pod","CenterTop");//정렬 버그 수정
			if ( sheetObj.GetCellValue(Row, "lvl0") == '9') {	//VVD
				for ( var i=1; i<=5; i++ ) {	//화면 정렬버그 및 excel 정렬버그 수정
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_com_qty","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_com_wgt","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_cos_qty","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_cos_wgt","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_kkl_qty","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_kkl_wgt","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_yml_qty","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_yml_wgt","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_oth_qty","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_oth_wgt","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_pol_qty","Center");
	    			sheetObj.SetCellAlign(Row,"wk"+i+"_pol_wgt","Center");
				}
			}
    	}
    	if ( bse_dt.split("|").length == 1 ) {	//Duration이 1주차(vvd값이 있을시)라면  히든width=100 설정
    		sheetObj.SetColHidden("width",0);
    		sheetObj.SetColWidth("width",100);
    	} else {
    		sheetObj.SetColHidden("width",1);
    	}
    	if ( document.form.polpod_flg.value =='POL' ) {    //POL 조회시 
    		document.getElementById("pol").innerHTML='POL';
			document.getElementById("pod").innerHTML='POD';
		} else if ( document.form.polpod_flg.value =='POD' ) {	//POD별 조회면 POL,POD 순서를 바꿔준다.
    		document.getElementById("pol").innerHTML='POD';
			document.getElementById("pod").innerHTML='POL';
		}
    	sheetObj.RenderSheet(1);
	}
    /*
     * 체크박스 선택시 pol 컬럼을 펼칠지 여부
  	 */
  	function showPol(obj){   
  		type=obj.checked;
  		sheetObj=sheetObjects[0];
		var row=0;
		var findTxt="";
		var replTxt="";
  		if ( type ) {
  			sheetObj.ShowTreeLevel(1);
  			findTxt="+";
  			replTxt="-";
  		} else {
  			sheetObj.ShowTreeLevel(0,1);
  			findTxt="-";
  			replTxt="+";
  		}
		while((row=sheetObj.FindText("pol", findTxt, row)) > 0){
			sheetObj.SetCellValue(row, "pol",replTxt,0);
		}
  	}      
    /*
     * 체크박스 선택시 pod 컬럼을 펼칠지 여부
     */
    function showPod(obj){   
    	type=obj.checked;
  		sheetObj=sheetObjects[0];
		var row=0;
		var findTxt="";
		var replTxt="";
  		if ( type ) {
  			sheetObj.ShowTreeLevel(2,2);
  			findTxt="+";
  			replTxt="-";
  		} else {
  			sheetObj.ShowTreeLevel(1,1);
  			findTxt="-";
  			replTxt="+";
  		}
		while((row=sheetObj.FindText("pod", findTxt, row)) > 0){
			sheetObj.SetCellValue(row, "pod",replTxt,0);
		}
  	}
    /*
     * 체크박스 선택시 weight 컬럼을 펼칠지 여부
     */
    function showWeight(obj){   
    	type=obj.checked;
  		sheetObj=sheetObjects[0];
  		sheetObj.SetRowHidden(2,!type);
		for ( var i=1; i<=eval(document.form.duration.value); i++ ) {
//			sheetObj.SetColHidden("wk"+i+"_com_wgt",!type);
//			sheetObj.SetColHidden("wk"+i+"_cos_wgt",!type);
//			sheetObj.SetColHidden("wk"+i+"_kkl_wgt",!type);
//			sheetObj.SetColHidden("wk"+i+"_yml_wgt",!type);
//			sheetObj.SetColHidden("wk"+i+"_oth_wgt",!type);
//			sheetObj.SetColHidden("wk"+i+"_pol_wgt",!type);
		}
		if ( document.form.vvd.value.trim() !='' || document.form.duration.value =='1' ) {	//vvd값이 있을경우 G. TTL 부분 히든처리
			type=false;
		}
		sheetObj.SetColHidden("gtl_com_wgt",!type);
		sheetObj.SetColHidden("gtl_cos_wgt",!type);
		sheetObj.SetColHidden("gtl_kkl_wgt",!type);
		sheetObj.SetColHidden("gtl_yml_wgt",!type);
		sheetObj.SetColHidden("gtl_oth_wgt",!type);
		sheetObj.SetColHidden("gtl_pol_wgt",!type);
  	}
    /*
     * Sub Trade OnChange시
     */
    function subtrade_OnChange(comObj,value,text ){  
//    	 if(text == '||ALL'){   optionAllReset2("subtrade",document.form.trade.Code,"true"); return; } // 0207 SHKIM
    	SpcSearchOptionLane("rlane_cd",true,false,'',document.form.trade.GetSelectCode(),value,true);	// 0207 SHKIM
   	 	if(value == "") return;
     	var arrTrade=text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].SetSelectCode(arrTrade[0],false);
    		comObjects[2].SetSelectCode('',false);
    	} else {
    		comObjects[0].SetSelectCode(comObj.GetText(value,0),false);
    		comObjects[2].SetSelectCode('',false);
    	}   
//    	SpcSearchOptionLane("rlane_cd",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
    } 
    /*
     * lane OnChange시
     */     
    function rlane_cd_OnChange(comObj,value,text ){
    	var arrLane=text.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].SetSelectCode(arrLane[0],false);
    		comObjects[1].SetSelectCode(arrLane[1],false);
    	} else {
    		comObjects[0].SetSelectCode(comObj.GetText(value,0),false);
    		comObjects[1].SetSelectCode(comObj.GetText(value,1),false);
    	}	     	
    }     
    function initDataValue_trade(){
     	var sheetObj=document.getElementById("trade");
     	with(sheetObj){
     		Index2=0;
     	}
     }
     function initDataValue_subtrade(){
     	var sheetObj=document.getElementById("subtrade");
     	with(sheetObj){
     		Index2=0;
     	}
     }
     function initDataValue_rlane_cd(){
     	var sheetObj=document.getElementById("rlane_cd");
     	with(sheetObj){
     		Index2=0;
     	}
     }    
     function trade_OnChange(comObj,value,text ){
//    	if(text == '|ALL'){	optionAllReset2("trade",value,"true");   return;} // 0207 SHKIM
//     	if(value == "" ) return;
     	var repTrade=comObj.GetText(value,0);  
     	comObjects[1].SetSelectCode("",false);//sub trade
     	comObjects[2].SetSelectCode("",false);// lane
     	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("rlane_cd",true,false,'',value,'',true);	// 0207 SHKIM
     }      
     /**
      * Start Week 의 year 변경시
      * Start Week 의 year 변경시 주차 변경
      */
     function checkWeek(){
     	SpcSearchOptionWeek("week",false,document.form.year.value);
     }        
	/* 개발자 작업  끝 */
