/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0504.js
*@FileTitle : Port Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.26 김종옥
* 1.0 Creation
* 
* History
* 2011.03.14 진마리아 CHM-201109291-01 Location Code(숫자포함)의 Validation 체크로직 수정
* 2014.06.16 -- SKD_DIR_CD 추가 (SUZ 운하의 Tier Surcharge가 Bound별 Tier Surcharge Rate를 등록 가능하도록 칼럼 추가
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
     * @class vop_vsk_0504 : vop_vsk_0504 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0504() {
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
    var set_day = 30;
       
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;     

    var t5sheet1Flg = true;
    var t3Dfs = "";
    var tabNowCnt = 0; 
	var fastFlg = false;
	var rhqChangeFlg = true;
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4]; 
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];
		var sheetObject8 = sheetObjects[7];         
		var sheetObject9 = sheetObjects[8];
		var sheetObject10 = sheetObjects[9];
		
        /*******************************************************/
        var formObject = document.form;
		var objs = document.all.item("tabLayer");
         
    	try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {

				case "btn_Calendar":
					if( objs[1].style.display == "inline" ){
						var cal = new ComCalendar();
                    	cal.setDisplayType('year');
                    	cal.select(formObject.cel_year, 'yyyy');
					}
					break;
					
				case "btn_Retrieve":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH,true);   //tab1
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSEARCH,true);   //tab2
					}else if( objs[2].style.display == "inline" ){
						//ComShowCodeMessage('VSK50016');
						doActionIBSheet(sheetObject3,formObject,IBSEARCH,true);   //tab3
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBSEARCH,true);   //tab4
    				}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject5,formObject,IBSEARCH,true);   //tab5
					}else if( objs[5].style.display == "inline" ){
						doActionIBSheet(sheetObject7,formObject,IBSEARCH,true);   //tab6    							
					}else if( objs[6].style.display == "inline" ){
						doActionIBSheet(sheetObject8,formObject,IBSEARCH,true);   //tab7    							
					}else{
						doActionIBSheet(sheetObject1,formObject,IBSEARCH,true);   //tab1
					}
					break;

				case "btn_New":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBCLEAR,true);   //tab1
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBCLEAR,true);   //tab2
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBCLEAR,true);   //tab3
					}else if( objs[3].style.display == "inline" ){
						doActionIBSheet(sheetObject4,formObject,IBCLEAR,true);   //tab4
    				}else if( objs[4].style.display == "inline" ){
						doActionIBSheet(sheetObject5,formObject,IBCLEAR,true);   //tab5
					}else if( objs[5].style.display == "inline" ){
						doActionIBSheet(sheetObject7,formObject,IBCLEAR,true);   //tab6    							
					}else if( objs[6].style.display == "inline" ){
						doActionIBSheet(sheetObject8,formObject,IBCLEAR,true);   //tab7    							
					}else{
						doActionIBSheet(sheetObject1,formObject,IBCLEAR,true);   //tab1
					}
					break;

				case "btn_Save":
					if( objs[0].style.display == "inline" )
						doActionIBSheet(sheetObject1,formObject,IBSAVE,false);
					else if( objs[1].style.display == "inline" )
						doActionIBSheet(sheetObject2,formObject,IBSAVE,false);
					else if( objs[2].style.display == "inline" )
						doActionIBSheet(sheetObject3,formObject,IBSAVE,false);
					else if( objs[3].style.display == "inline" )
						doActionIBSheet(sheetObject4,formObject,IBSAVE,false);
					else if( objs[4].style.display == "inline" )
						doActionIBSheet(sheetObject5,formObject,IBSAVE,false);
					else if( objs[5].style.display == "inline" )
						doActionIBSheet(sheetObject7,formObject,IBSAVE,false);
					else if( objs[6].style.display == "inline" )
						doActionIBSheet(sheetObject8,formObject,IBSAVE,false);    							
					else
						doActionIBSheet(sheetObject1,formObject,IBSAVE,false);
					
					break;
						

				case "btn_loc_cd":	//Location 조회 팝업
					if(formObject.btn_loc_cd.className == ""){
						break;
					}
					var cnt_cd = "";
					var loc_cd = formObject.loc_cd.value;
			    	var sUrl = "/hanjin/VOP_VSK_0043.do";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
					if(rVal){
						formObject.loc_cd.value = rVal;
						loc_cd_onchange();
					}					
					
					break; 											
    							
    /**		TAB 1		**/
				case "btn_t1add":
					if(validateForm(sheetObject1,formObject,IBSEARCH))
					{
						//t1sheet1_yd_cd 콤보 데이타 체크 없으면 add 안됨.
						if(sheetObject1.GetComboInfo(0,"t1sheet1_yd_cd", "Text") == ""){
							ComShowCodeMessage("VSK50011");
							ComAlertFocus(formObject.loc_cd, "");
							return ;							
						}

						//초기 입력 t1sheet1_yd_nm 자동 입력
						/*var sText = sheetObject1.GetComboInfo(0,"t1sheet1_yd_cd", "Text");
						var arrText = sText.split("|");
						var arrTemp = arrText[0].split("\t");*/
						
						var inx = sheetObject1.DataInsert(-1);
						/*fastFlg = false;
						sheetObject1.CellValue(inx, "t1sheet1_yd_nm") = arrTemp[1];
						fastFlg = false;
						sheetObject1.CellValue(inx, "t1sheet1_temp_yd_cd") = arrTemp[0];*/
						sheetObject1.SelectCell(inx, "t1sheet1_yd_cd", true);
						fastFlg = true;
					}	
					break;

				case "btn_t1insert":
					if(validateForm(sheetObject1,formObject,IBSEARCH))
					{
						//t1sheet1_yd_cd 콤보 데이타 체크 없으면 add 안됨.
						if(sheetObject1.GetComboInfo(0,"t1sheet1_yd_cd", "Text") == ""){
							ComShowCodeMessage("VSK50011");
							ComAlertFocus(formObject.loc_cd, "");
							return ;							
						}						
						//초기 입력 t1sheet1_yd_nm 자동 입력
						/*var sText = sheetObject1.GetComboInfo(0,"t1sheet1_yd_cd", "Text");
						var arrText = sText.split("|");
						var arrTemp = arrText[0].split("\t");*/
						
						var inx = sheetObject1.DataInsert();
						/*fastFlg = false;
						sheetObject1.CellValue(inx, "t1sheet1_yd_nm") = arrTemp[1];
						fastFlg = false;
						sheetObject1.CellValue(inx, "t1sheet1_temp_yd_cd") = arrTemp[0];*/
						sheetObject1.SelectCell(inx, "t1sheet1_yd_cd", true);
						fastFlg = true;
					}
					break;

				case "btn_t1del":
					//sheetObject1.RowHidden(sheetObject1.SelectRow) = true;
					//sheetObject1.RowStatus(sheetObject1.SelectRow) = "D";
					ComRowHideDelete(sheetObject1,"t1sheet1_del_chk");
					break;
						
				case "btn_t1downexcel":
					sheetObject1.Down2Excel(1,false,false,true,"","",false,false,"",false,"t1sheet1_upd_usr_id|t1sheet1_upd_dt|t1sheet1_temp_yd_cd","",false,false,"");
					break;								

    /**		TAB 2		**/
				case "btn_t2add":
					var inx = sheetObject2.DataInsert(-1);
					//sheetObject2.CellValue(inx, "t2sheet1_hol_st_dt") = formObject.nowDateTime.value;
					//sheetObject2.CellValue(inx, "t2sheet1_hol_end_dt") = formObject.nowDateTime.value;
					sheetObject2.SelectCell(inx, "t2sheet1_loc_cd", true);
					break;

				case "btn_t2insert":
					var inx = sheetObject2.DataInsert();
					//sheetObject2.CellValue(inx, "t2sheet1_hol_st_dt") = formObject.nowDateTime.value;
					//sheetObject2.CellValue(inx, "t2sheet1_hol_end_dt") = formObject.nowDateTime.value;
					sheetObject2.SelectCell(inx, "t2sheet1_loc_cd", true);
					break;

				case "btn_t2del":
					//sheetObject2.RowHidden(sheetObject2.SelectRow) = true;
					//sheetObject2.RowStatus(sheetObject2.SelectRow) = "D";
					ComRowHideDelete(sheetObject2,"t2sheet1_del_chk");
					break;
						
				case "btn_t2downexcel":
					sheetObject2.Down2Excel(-1);
					break; 
						
    /**		TAB 3		**/
				case "btn_t3add":
					if(validateForm(sheetObject3,formObject,IBSEARCH))
					{
						var inx = sheetObject3.DataInsert(-1);
						fastFlg = false;
						sheetObject3.CellValue(inx, "t3sheet1_fm_loc_cd") = formObject.loc_cd.value;
						fastFlg = false;
		            	/*var arrT3Dfs = t3Dfs.split("|");		            	
		            	sheetObject3.CellValue(inx, "t3sheet1_gmt_td_hrs") = arrT3Dfs[0];
		            	fastFlg = false;*/
		            	sheetObject3.CellValue(inx, "t3sheet1_temp_to_loc_cd") = sheetObject3.CellValue(inx, "t3sheet1_to_loc_cd");
		            	sheetObject3.SelectCell(inx, "t3sheet1_to_loc_cd", true);
		            	fastFlg = true;
		            	
					}
					break;

				case "btn_t3insert":
					if(validateForm(sheetObject3,formObject,IBSEARCH))
					{
						var inx = sheetObject3.DataInsert();
						fastFlg = false;
						sheetObject3.CellValue(inx, "t3sheet1_fm_loc_cd") = formObject.loc_cd.value;
						fastFlg = false;
		            	/*var arrT3Dfs = t3Dfs.split("|");
		            	sheetObject3.CellValue(inx, "t3sheet1_gmt_td_hrs") = arrT3Dfs[0];
		            	fastFlg = false;*/
		            	sheetObject3.CellValue(inx, "t3sheet1_temp_to_loc_cd") = sheetObject3.CellValue(inx, "t3sheet1_to_loc_cd");
		            	sheetObject3.SelectCell(inx, "t3sheet1_to_loc_cd", true);
		            	fastFlg = true;
					}	
					break;

				case "btn_t3del":
					//var inx = sheetObject3.RowDelete(sheetObject3.SelectRow, false);
					//sheetObject3.RowHidden(sheetObject3.SelectRow) = true;
					//sheetObject3.RowStatus(sheetObject3.SelectRow) = "D";
					ComRowHideDelete(sheetObject3,"t3sheet1_del_chk");
					break;
						
				case "btn_t3downexcel":
					sheetObject3.Down2Excel(-1);
					break;
    								
    /**		TAB 4		**/
				case "btn_t4add":
					var inx = sheetObject4.DataInsert(-1);
					sheetObject4.CellValue(inx, "t4sheet1_temp_loc_cd") = sheetObject4.CellValue(inx, "t4sheet1_loc_cd");
					sheetObject4.SelectCell(inx, "t4sheet1_loc_cd", true);
					break;

				case "btn_t4insert":
					var inx = sheetObject4.DataInsert();
					sheetObject4.CellValue(inx, "t4sheet1_temp_loc_cd") = sheetObject4.CellValue(inx, "t4sheet1_loc_cd");
					sheetObject4.SelectCell(inx, "t4sheet1_loc_cd", true);
					sheetObject4.SelectCell(inx, 2, true);
					break;

				case "btn_t4del":
					//sheetObject4.RowHidden(sheetObject4.SelectRow) = true;
					//sheetObject4.RowStatus(sheetObject4.SelectRow) = "D";
					ComRowHideDelete(sheetObject4,"t4sheet1_del_chk");
					break;
						
				case "btn_t4downexcel":
					sheetObject4.Down2Excel(-1);
					break;
    																								
    /**		TAB 5		**/
				case "btn_t5add":
					if(validateForm(sheetObject5,formObject,IBSEARCH))
					{	
						var inx = sheetObject5.DataInsert(-1);
						sheetObject5.CellValue(inx, "t5sheet1_loc_cd") = formObject.loc_cd.value;
						//sheetObject6.CellValue(1, "t5sheet2_loc_cd") = formObject.loc_cd.value;
						sheetObject5.SelectCell(inx, "t5sheet1_loc_cd", true);
					}
					break;

				case "btn_t5insert":
					if(validateForm(sheetObject5,formObject,IBSEARCH))
					{
						var inx = sheetObject5.DataInsert();
						sheetObject5.CellValue(inx, "t5sheet1_loc_cd") = formObject.loc_cd.value;
						//sheetObject6.CellValue(1, "t5sheet2_loc_cd") = formObject.loc_cd.value;
						sheetObject5.SelectCell(inx, "t5sheet1_loc_cd", true);
					}	
					break;

				case "btn_t5del":
					ComRowHideDelete(sheetObject5,"t5sheet1_del_chk");
					break; 
					
				case "btn_t5downexcel":
					sheetObject5.Down2Excel(1,false,false,true,"","",false,false,"",false,"t5sheet1_del_chk|t5sheet1_Seq|t5sheet1_upd_usr_id|t5sheet1_upd_dt|t5sheet1_port_seq","",false,false,"");
					sheetObject6.Down2Excel(1,true,false,true,"","",false,false,"",false,"t5sheet2_Seq","",false,false,"");
					break;					
    								
    /**		TAB 6		**/
				case "btn_t6add":
					var inx = sheetObject7.DataInsert(-1);
					fastFlg = false;
					sheetObject7.CellValue(inx, "t6sheet1_trsp_mod_cd") = formObject.trsp_mod_cd.value;
					fastFlg = false;
					sheetObject7.CellValue(inx, "t6sheet1_temp_loc_cd") = sheetObject7.CellValue(inx, "t6sheet1_loc_cd");
					sheetObject7.SelectCell(inx, "t6sheet1_loc_cd", true);
					fastFlg = true;
					break;

				case "btn_t6insert":
					var inx = sheetObject7.DataInsert();
					fastFlg = false;
					sheetObject7.CellValue(inx, "t6sheet1_trsp_mod_cd") = formObject.trsp_mod_cd.value;
					fastFlg = false;
					sheetObject7.CellValue(inx, "t6sheet1_temp_loc_cd") = sheetObject7.CellValue(inx, "t6sheet1_loc_cd");
					sheetObject7.SelectCell(inx, "t6sheet1_loc_cd", true);
					fastFlg = true;
					break;

				case "btn_t6del":
					//sheetObject7.RowHidden(sheetObject7.SelectRow) = true;
					//sheetObject7.RowStatus(sheetObject7.SelectRow) = "D";
					ComRowHideDelete(sheetObject7,"t6sheet1_del_chk");
					break;
    							
				case "btn_t6downexcel":
					sheetObject7.Down2Excel(1,false,false,true,"","",false,false,"",false,"t6sheet1_trsp_mod_cd|t6sheet1_upd_usr_id|t6sheet1_upd_dt|t5sheet1_temp_loc_cd","",false,false,"");
					break;
					
    /**		TAB 7		**/
				case "btn_t7add":
					var inx = sheetObject8.DataInsert(-1);
					fastFlg = false;
					sheetObject8.CellValue(inx, "t7sheet1_trsp_mod_cd") = formObject.trsp_mod_cd.value;
					fastFlg = false;
					sheetObject8.CellValue(inx, "t7sheet1_temp_loc_cd") = sheetObject8.CellValue(inx, "t7sheet1_loc_cd");
					sheetObject8.SelectCell(inx, "t7sheet1_loc_cd", true);
					fastFlg = true;
					break;

				case "btn_t7insert":
					var inx = sheetObject8.DataInsert();
					fastFlg = false;
					sheetObject8.CellValue(inx, "t7sheet1_trsp_mod_cd") = formObject.trsp_mod_cd.value;
					fastFlg = false;
					sheetObject8.CellValue(inx, "t7sheet1_temp_loc_cd") = sheetObject8.CellValue(inx, "t7sheet1_loc_cd");
					sheetObject8.SelectCell(inx, "t7sheet1_loc_cd", true);
					fastFlg = true;
					break;

				case "btn_t7del":
					//sheetObject8.RowHidden(sheetObject8.SelectRow) = true;
					//sheetObject8.RowStatus(sheetObject8.SelectRow) = "D";
					ComRowHideDelete(sheetObject8,"t7sheet1_del_chk");
					
				break;
				
				case "btn_t7downexcel":
					sheetObject8.Down2Excel(1,false,false,true,"","",false,false,"",false,"t7sheet1_lmt_axl_wgt|t7sheet1_trsp_mod_cd|t7sheet1_upd_usr_id|t7sheet1_upd_dt|t7sheet1_temp_loc_cd","",false,false,"");
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for(i=0;i<sheetObjects.length;i++){
           // doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        
 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        //initCombo(comboObjects[c], c+1);
 	    }            

        initControl();
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.id) {
			case "rhq":
				with(comboObj) {
					comboObj.DropHeight=125;
					comboObj.BackColor = "#CCFFFD";
					InsertItem(i++,  "ALL",  "^");
					InsertItem(i++,  "PHXRA", "PHXRA");
					InsertItem(i++,  "HAMRU", "HAMRU");
					InsertItem(i++,  "SHARC", "SHARC");
					InsertItem(i++,  "SINRS", "SINRS");
					InsertItem(i++,  "SELSC", 	"SELSC");
					InsertItem(i++,  "TYOSC", 	"TYOSC");
					InsertItem(i++,  "VVOIA", 	"VVOIA");
					
					comboObj.Code = "^";
	        	}
				break;

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

                case "t1sheet1":
                    with (sheetObj) {
    										// 높이 설정
                        style.height = 315;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 3, 100);

                        var HeadTitle1 = "|Sel.|TMNL Code|TMNL Name|Alongside|Depth (M)|Depth (M)|Draft (M)|Draft (M)|Air Draft (M)|Length of Turning\nBasin (M)|Berth\nLength|Pilot Maneuvering In/Out|Pilot Maneuvering In/Out|Remark(s)|||";
                        var HeadTitle2 = "|Sel.|TMNL Code|TMNL Name|Alongside|Channel|Berth|Anytime|Max|Air Draft (M)|Length of Turning\nBasin (M)|Berth\nLength|Distance (NM)|Time (Hr)|Remark(s)";
                        
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true); 
                                      
                        var prefix="t1sheet1_";
                        //데이터속성            [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE, SAVENAME,          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,	true,	prefix+"del_chk");
                        InitDataProperty(0, cnt++ , dtComboEdit,80,	 	daCenter,	true,	prefix+"yd_cd",			true,		"",	dfNone,		0,		false,		true,	7);
                        InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		true,	prefix+"yd_nm",			false,		"",	dfNone,		0,		false,		false);
                        InitDataProperty(0, cnt++ , dtCombo,	100,	daCenter,	true,	prefix+"alsd_cd",		false,		"",	dfNone,		0,		true,		true);
                        InitDataProperty(0, cnt++ , dtData,		65,		daRight,	true,	prefix+"chnl_dpth",		false,		"",	dfFloat,	2,		true,		true,	5);
                        InitDataProperty(0, cnt++ , dtData,		65,		daRight,	true,	prefix+"brth_dpth",		false,		"",	dfFloat,	2,		true,		true,	5);
                        InitDataProperty(0, cnt++ , dtData,		65,		daRight,	true,	prefix+"at_drft_dpth",	false,		"",	dfFloat,	2,		true,		true,	5);
                        InitDataProperty(0, cnt++ , dtData,		65,		daRight,	true,	prefix+"max_drft_dpth",	false,		"",	dfFloat,	2,		true,		true,	5);
                        InitDataProperty(0, cnt++ , dtData,		80,		daRight,	true,	prefix+"ad_len",	    false,		"",	dfFloat,	2,		true,		true,	9);
                        InitDataProperty(0, cnt++ , dtData,		110,	daRight,	true,	prefix+"turn_bsn_len",	false,		"",	dfFloat,	2,		true,		true,	9);
                        InitDataProperty(0, cnt++ , dtData,		65,		daRight,	true,	prefix+"brth_len",		false,		"",	dfFloat,	1,		true,		true,	8);
                        InitDataProperty(0, cnt++ , dtData,		85,		daRight,	true,	prefix+"plt_mnvr_dist",		false,	"",	dfFloat,	1,		true,		true,	7);
                        InitDataProperty(0, cnt++ , dtData,		70,		daRight,	true,	prefix+"plt_mnvr_tm_hrs",	false,	"",	dfFloat,	1,		true,		true,	5);
                        InitDataProperty(0, cnt++ , dtHidden,	150,	daLeft,		true,	prefix+"mnvr_rmk",		false,		"",	dfNone,		0,		true,		true,	1000);
                        InitDataProperty(0, cnt++ , dtHidden,	150,	daLeft,		true,	prefix+"upd_usr_id",	false,		"",	dfNone,		0,		true,		true);
                        InitDataProperty(0, cnt++ , dtHidden,	150,	daLeft,		true,	prefix+"upd_dt",		false,		"",	dfNone,		0,		true,		true);
                        
                        InitDataProperty(0, cnt++ , dtHidden,	80,	 	daCenter,	true,	prefix+"temp_yd_cd",	false,		"",	dfNone,		0,		false,		true);

                        InitDataCombo(0, prefix+"alsd_cd",  " |Mostly Starboard|Starboard Only|PORT Only|Mostly Port|BOTH",  " |MS|OS|OP|MP|BO");
    										
                        InitDataValid(0, prefix+"yd_cd", vtEngUpOther, "0123456789"); 
					
    								}
    								break;

                case "t2sheet1":
                    with (sheetObj) {
    										// 높이 설정
                        style.height = 380;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msNone;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                        var HeadTitle1 = "|Sel.|Seq.|Port|Hol Seq.|Start Date|End Date|Holiday Description|Remark(s)||";
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);                 

                        var prefix="t2sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	true,		prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,	true,		prefix+"del_chk");
    					InitDataProperty(0, cnt++ , dtDataSeq,			30,		daCenter,	true,		prefix+"Seq");
                        InitDataProperty(0, cnt++ , dtComboEdit,		80,	 	daCenter,	true,		prefix+"loc_cd",		true,		"",		dfNone,		0,		false,		true, 5);
    					InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,		true,		prefix+"hol_seq",		false,		"",		dfNone,			0,		true,		true);
                        InitDataProperty(0, cnt++ , dtPopupEdit,		140,	daCenter,	false,		prefix+"hol_st_dt",		true,		"",		dfUserFormat2,	0,		true,		true);
                        InitDataProperty(0, cnt++ , dtPopupEdit,		140,	daCenter,	false,		prefix+"hol_end_dt",	true,		"",		dfUserFormat2,	0,		true,		true);
                        InitDataProperty(0, cnt++ , dtData,				310,	daLeft,		false,		prefix+"hol_nm",		true,		"",		dfNone,			0,		true,		true,  200);
                        InitDataProperty(0, cnt++ , dtData,				140,	daLeft,		false,		prefix+"hol_rmk",		false,		"",		dfNone,			0,		true,		true,  1000);
                        InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,		true,		prefix+"upd_usr_id",	false,		"",		dfNone,			0,		true,		true);
                        InitDataProperty(0, cnt++ , dtHidden,			150,	daLeft,		true,		prefix+"upd_dt",		false,		"",		dfNone,			0,		true,		true);
                        
                        InitUserFormat2(0, prefix+"hol_st_dt", "####-##-## ##:##", "-|:" );
                        InitUserFormat2(0, prefix+"hol_end_dt", "####-##-## ##:##", "-|:" );
                        InitDataValid(0,   prefix+"loc_cd", vtEngUpOther, "0123456789");
                        
                        //PopupImage  =  "/img/btns_calendar.gif";
                        ShowButtonImage = 2;

    								}
    								break;

                case "t3sheet1":
                    with (sheetObj) {
    										// 높이 설정
                        style.height = 380;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 3, 100);

                        var HeadTitle1 = "|Sel.|Seq.||To Port|Time Diff.(Hrs)|Distance |Distance |Shortest Distance|Shortest Distance|||";
                        var HeadTitle2 = "|Sel.|Seq.||To Port|Time Diff.(Hrs)|Distance|Description|Distance|Description"; 
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);
                        
                        var prefix="t3sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
    					InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	true,		prefix+"Seq");
                        InitDataProperty(0, cnt++ , dtHidden,		80,		daLeft,		true,		prefix+"fm_loc_cd",		false,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtComboEdit,	120,	daCenter,	true,		prefix+"to_loc_cd",		true,		"",		dfNone,		0,		false,	true, 5);
                        InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		prefix+"gmt_td_hrs",	true,		"",		dfFloat,	1,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		prefix+"stnd_dist",		true,		"",		dfFloat,	1,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,			200,	daLeft,	  	true,		prefix+"stnd_dist_desc",false,		"",		dfNone,		0,		true,	true, 500);
                        InitDataProperty(0, cnt++ , dtData,			140,	daRight,	true,		prefix+"shrt_dist",		false,		"",		dfFloat,	1,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,		prefix+"shrt_dist_desc",false,		"",		dfNone,		0,		true,	true, 500);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_usr_id",	false,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_dt",		false,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,		prefix+"temp_to_loc_cd", false,		"",		dfNone,		0,		false,	true);

                        InitDataValid(0,   prefix+"to_loc_cd", vtEngUpOther, "0123456789");
    								}
    								break;

                case "t4sheet1":
                    with (sheetObj) {
    										// 높이 설정
                        style.height = 380;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msNone;

                      	 //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                        var HeadTitle1 = "|Sel.|Port|Document Hour|Dead Hour|Dead Hour Description|Remark(s)|||";
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)
                        
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        var prefix="t4sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
                        InitDataProperty(0, cnt++ , dtComboEdit,	100,	daCenter,	true,		prefix+"loc_cd",		true,		"",		dfNone,		0,		false,	true, 5);
                        InitDataProperty(0, cnt++ , dtData,			105,	daCenter,	false,		prefix+"doc_hrs",		true,		"",		dfFloat,	1,		true,	true, 5);
                        InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		prefix+"dead_hrs",		true,		"",		dfFloat,	1,		true,	true, 5);
                        InitDataProperty(0, cnt++ , dtData,			395,	daLeft,		false,		prefix+"dead_hr_desc",	true,		"",		dfNone,		0,		true,	true,	500);
                        InitDataProperty(0, cnt++ , dtData,			70,		daLeft,		false,		prefix+"doc_rmk",		false,		"",		dfNone,		0,		true,	true,	1000);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_usr_id",	false,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_dt",		false,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		prefix+"temp_loc_cd",	false,		"",		dfNone,		0,		true,	true);

                        InitDataValid(0,   prefix+"loc_cd", vtEngUpOther, "0123456789");
    								}
    								break;

                case "t5sheet1":
                    with (sheetObj) {
    										// 높이 설정
                        style.height = 320;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 3, 100);

                        var HeadTitle1 = "|Sel.|Port|Bound|Convoy or\nGroup|Limit Time without Surcharge|Limit Time with Surcharge|Limit Time with Surcharge|Limit Time with Surcharge|Remark(s)|||";
                        var HeadTitle2 = "|Sel.|Port|Bound|Convoy or\nGroup|Limit Time without Surcharge|L/Time|L/Time|Surcharge %|Remark(s)|||";
                        
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        var prefix="t5sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
                        InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"loc_cd",				true,		"",		dfNone,		0,		false,	false);
                        InitDataProperty(0, cnt++ , dtCombo,		60,		daLeft,		true,		prefix+"svc_scp_bnd_cd",		true,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtCombo,		80,		daLeft,		true,		prefix+"cnl_tz_seq_cd",			true,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtData,			200,	daCenter,	true,		prefix+"scg_expt_lmt_hrmnt",	true,		"",		dfTimeHm,	0,		true,	true);
                        InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"scg_fm_lmt_hrmnt",		true,		"",		dfTimeHm,	0,		true,	true);
                        InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"scg_to_lmt_hrmnt",		true,		"",		dfTimeHm,	0,		true,	true);
                        InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"lmt_tm_scg_rto",		true,		"",		dfFloat,	2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix+"cnl_rmk",				false,		"",		dfNone,		0,		true,	true, 1000);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		false,		prefix+"upd_usr_id",			false,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		false,		prefix+"upd_dt",				false,		"",		dfNone,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtHidden,		50,		daLeft,		false,		prefix+"port_seq",				false,		"",		dfNone,		0,		true,	true);
                        
                        InitDataCombo(0, prefix+"svc_scp_bnd_cd",  " |North|South",  " |N|S");
                        InitDataCombo(0, prefix+"cnl_tz_seq_cd",  " |First|Second",  " |1|2");
                        
    								}
    								break;

                case "t5sheet2":
                    with (sheetObj) {
                    	WaitImageVisible = false;
    					// 높이 설정
                        style.height = 100;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msNone;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                        var HeadTitle1 = "|Port / Tier|Bound|1 Tier|2 Tier|3 Tier|4 Tier|5Tier|6 Tier|7 Tier|8 Tier|9 Tier";

                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        var prefix="t5sheet2_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"loc_cd",			true,		"",		dfNone,			0,		false,	false);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"skd_dir_cd",		false,		"",		dfNone,			0,		false,	false);                        
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no1",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no2",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no3",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no4",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no5",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no6",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no7",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no8",		false,		"",		dfFloat,		2,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,		prefix+"vsl_tr_no9",		false,		"",		dfFloat,		2,		true,	true, 7);

                        CountPosition = 0;
    								}
    								break;

                case "t6sheet1":
                    with (sheetObj) {
    										// 높이 설정
                        style.height = 310;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 3, 100);

                        //var HeadTitle1 = "|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|";
                        //HeadTitle1 += "Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|||||";
                        //var HeadTitle2 = "|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Weight per Axial\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)";
                        var HeadTitle1 = "|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|";
                        HeadTitle1 += "Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|||";    												
                        var HeadTitle2 = "|Sel.|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Weight per Axial\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)||Remark(s)";

                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        var prefix="t6sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
                        InitDataProperty(0, cnt++ , dtComboEdit,	80,		daCenter,	true,		prefix+"loc_cd",		true,		"",	dfNone,		0,		false,	true, 5);
                        InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"lmt_20ft_wgt",	false,		"",	dfFloat,	1,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"lmt_40ft_wgt",	false,		"",	dfFloat,	1,		true,	true, 7);
                        InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"lmt_axl_wgt",	false,		"",	dfFloat,	1,		true,	true, 7);
                        
                        InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,		prefix+"lmt_len",		false,		"",	dfFloat,	1,		true,	true, 8);
                        InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,		prefix+"lmt_wdt",		false,		"",	dfFloat,	1,		true,	true, 8);
                        InitDataProperty(0, cnt++ , dtData,			95,		daRight,	false,		prefix+"lmt_hgt",		false,		"",	dfFloat,	1,		true,	true, 6);
                        InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,		prefix+"lmt_ovr_len",	false,		"",	dfFloat,	1,		true,	true, 8);
                        InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,		prefix+"lmt_ovr_wdt",	false,		"",	dfFloat,	1,		true,	true, 8);
                        InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,		prefix+"lmt_ovr_hgt",	false,		"",	dfFloat,	1,		true,	true, 6);

                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"trsp_mod_cd",	false,		"",	dfNone,	0,		true,		true);                        
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"trsp_rmk",		false,		"",	dfNone,	0,		true,		true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_usr_id",	false,		"",	dfNone,	0,		true,		true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_dt",		false,		"",	dfNone,	0,		true,		true);
                        
                        InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix+"temp_loc_cd",	false,		"",	dfNone,		0,		false,	true);
                        
                        InitDataValid(0,   prefix+"loc_cd", vtEngUpOther, "0123456789");
    								}
    								break;

                case "t7sheet1":
                    with (sheetObj) {
    										// 높이 설정
                        style.height = 308;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 3, 100);

                        //var HeadTitle1 = "|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|";
                        //HeadTitle1 += "Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck||||||";
                        //var HeadTitle2 = "|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)";
                        var HeadTitle1 = "|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|";
                        HeadTitle1 += "Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|Max Permissible Cargo Weight / Size for Truck|";
                        var HeadTitle2 = "|Sel.|Port|Weight for 20 ft\n(Kgs)|Weight for 40 ft\n(Kgs)|Max \nLength(M)|Max \nWidth(M)|Max \nHeight(M)|Over \nLength(Cm)|Over \nWidth(Cm)|Over \nHeight(Cm)|||Remark(s)";
                        
                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);

                        var prefix="t7sheet1_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk");
                        InitDataProperty(0, cnt++ , dtComboEdit,	110,	daCenter,	true,		prefix+"loc_cd",		true,		"",	dfNone,		0,		false,	true, 5);
                        InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,		prefix+"lmt_20ft_wgt",	false,		"",	dfFloat,	1,		true,		true, 7);
                        InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,		prefix+"lmt_40ft_wgt",	false,		"",	dfFloat,	1,		true,		true, 7);
                        InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,		prefix+"lmt_len",		false,		"",	dfFloat,	1,		true,		true, 8);
                        InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,		prefix+"lmt_wdt",		false,		"",	dfFloat,	1,		true,		true, 8);
                        InitDataProperty(0, cnt++ , dtData,			110,	daRight,	false,		prefix+"lmt_hgt",		false,		"",	dfFloat,	1,		true,		true, 6);
                        InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"lmt_ovr_len",	false,		"",	dfFloat,	1,		true,		true, 8);
                        InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,		prefix+"lmt_ovr_wdt",	false,		"",	dfFloat,	1,		true,		true, 8);
                        InitDataProperty(0, cnt++ , dtData,			90,		daRight,	false,		prefix+"lmt_ovr_hgt",	false,		"",	dfFloat,	1,		true,		true, 6);
                        InitDataProperty(0, cnt++ , dtHidden,		110,	daRight,	false,		prefix+"lmt_axl_wgt",	false,		"",	dfFloat,	1,		true,		true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"trsp_mod_cd",	false,		"",	dfNone,	0,		true,		true);                        
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"trsp_rmk",		false,		"",	dfNone,	0,		true,		true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_usr_id",	false,		"",	dfNone,	0,		true,		true);
                        InitDataProperty(0, cnt++ , dtHidden,		150,	daLeft,		true,		prefix+"upd_dt",		false,		"",	dfNone,	0,		true,		true);
                        
                        InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix+"temp_loc_cd",	false,		"",	dfNone,		0,		false,	true);
                        
                        InitDataValid(0,   prefix+"loc_cd", vtEngUpOther, "0123456789");
    								}
    								break;
                case "t10sheet1":    				
                    with (sheetObj) {
                    	WaitImageVisible = false;
                    }
                    break;
                    
                case "t5sheet3":
                    with (sheetObj) {
                    	WaitImageVisible = false;
    					// 높이 설정
                        style.height = 60;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msNone;

                       	//전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(1, 1, 3, 100);

                        var HeadTitle1 = "|loc_cd|skd_dir_cd|tr_seq|tr_scg_rto";

                        var headCount = ComCountHeadTitle(HeadTitle1);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);

                        var prefix="t5sheet3_";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
                        InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"loc_cd",		true,		"",		dfNone,			0,		false,	false);
                        InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	false,		prefix+"skd_dir_cd",	true,		"",		dfNone,			0,		false,	false);
                        //InitDataProperty(0, cnt++ , dtData,		99,	daCenter,	false,		prefix+"vsl_tr_no",		false,		"",		dfInteger,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtData,		99,	daCenter,	false,		prefix+"tr_seq",		false,		"",		dfInteger,		0,		true,	true);
                        InitDataProperty(0, cnt++ , dtData,		99,	daCenter,	false,		prefix+"tr_scg_rto",	false,		"",		dfFloat,		2,		true,	true);

                        CountPosition = 0;
    								}
    								break;                    
            }
        }

    		// Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction, sQuest) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
    			case IBSEARCH:		//조회
    					if(validateForm(sheetObj,formObj,sAction))
    							if ( sheetObj.id == "t1sheet1")
    							{	
    								//formObj.f_cmd.value = SEARCH;
    								//sheetObj.DoSearch("VOP_VSK_0504GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_")); 	
    								formObj.f_cmd.value = SEARCH;
    								var arr = new Array("t1sheet1_", "");
    								//var arr = new Array("t1sheet1_");
    								var sXml = sheetObj.GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
    								var arrXml = sXml.split("|$$|");

    								for(var i = 0; i<arrXml.length; i++){
    									//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 2, dtData,80,	daCenter,true,"t1sheet1_yd_cd",	false,"",dfNone,	0,false,true);
    									if( i == 0 )
    									{	
    										sheetObj.LoadSearchXml(arrXml[i]); 
    									}
    									//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 2, dtComboEdit,80,daCenter,true,"t1sheet1_yd_cd",false,"",dfNone,0,false,true,7);
    									
    									var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
    									if(arrCombo != null){
    										var vInitDataComboName = "";
    										var arrVal = arrCombo[0].split("|");
    										var arrName = arrCombo[1].split("|");
    										for(var j=0; j<arrVal.length ; j++)
    										{
    											if(j == 0)
    										    	vInitDataComboName = vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
    											else
    												vInitDataComboName = vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
    										}
    									
    										//sheetObj.InitDataCombo(0, "t1sheet1_yd_cd", vInitDataComboName, arrCombo[0], arrVal[0]);
    										sheetObj.InitDataCombo(0, "t1sheet1_yd_cd", " |"+vInitDataComboName, " |"+arrCombo[0]);
    									}
    								}

    							}else if (sheetObj.id == "t2sheet1")
    							{	
    								formObj.f_cmd.value = SEARCH01;
    								var arr = new Array("t2sheet1_", "");
    								var sXml = sheetObj.GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
    								var arrXml = sXml.split("|$$|");

    								for(var i = 0; i<arrXml.length; i++){ 
    									var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
    									if(arrCombo != null){
    										sheetObj.InitDataCombo(0, "t2sheet1_loc_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
    									} 
    									
    									if( i==0 ){
    										sheetObj.LoadSearchXml(arrXml[0]); 
    									}
    								}    										
    							}else if ( sheetObj.id == "t3sheet1")
    							{
    								formObj.f_cmd.value = SEARCH02;
    								var arr = new Array("t3sheet1_", "");
    								var sXml = sheetObj.GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
    								var arrXml = sXml.split("|$$|");
    								for(var i = 0; i<arrXml.length; i++){ 
      										//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 4, dtData,	120,daCenter,true,"t3sheet1_to_loc_cd",	false,"",dfNone,0,false,true);

    									if(i == 0)
    									{	
    										sheetObj.LoadSearchXml(arrXml[0]); 
    									}
    									//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 4, dtComboEdit,120,daCenter,true,"t3sheet1_to_loc_cd",	false,"",dfNone,0,false,true, 5);
    									sheetObj.InitDataCombo(0, "t3sheet1_to_loc_cd", "", "");  //콤보 초기화
    									var arrCombo = ComVskXml2ComboString(arrXml[1], "val", "name", "df");
    									if(arrCombo != null){
    										sheetObj.InitDataCombo(0, "t3sheet1_to_loc_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
    										t3Dfs = arrCombo[2];
    									}    							
    								} 
    							}else if ( sheetObj.id == "t4sheet1")
    							{
    								formObj.f_cmd.value = SEARCH03;
    								var arr = new Array("t4sheet1_", "");
    								var sXml = sheetObj.GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
    								var arrXml = sXml.split("|$$|");

    								for(var i = 0; i<arrXml.length; i++){ 
    									//콤보 타입 변경
    									sheetObj.InitDataProperty(0,2,dtData,100,daCenter,true,	"t4sheet1_loc_cd",false,"",dfNone,0,false,true);
    									if(i == 0){
    										sheetObj.LoadSearchXml(arrXml[0]); 
										}

    									//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 2, dtComboEdit,100,daCenter,	true,"t4sheet1_loc_cd",false,"",dfNone,	0,false,true, 5);
    									sheetObj.InitDataCombo(0, "t4sheet1_loc_cd", "", "");  //콤보 초기화
										var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
										if(arrCombo != null){
											sheetObj.InitDataCombo(0, "t4sheet1_loc_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
										}    								} 
    							}else if ( sheetObj.id == "t5sheet1")
    							{
    								formObj.f_cmd.value = SEARCH04;
    								var arr = new Array("t5sheet1_", "t5sheet2_", "t5sheet3_");
    								var sXml = sheetObj.GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
    								var arrXml = sXml.split("|$$|");

    								//for(var i = 0; i<arrXml.length; i++){ 
    								//	sheetObjects[4+i].LoadSearchXml(arrXml[i]);
    								//}
    								
    								sheetObjects[4].LoadSearchXml(arrXml[0]);
    								sheetObjects[5].LoadSearchXml(arrXml[1]);
    								sheetObjects[9].LoadSearchXml(arrXml[2]);
    							}else if ( sheetObj.id == "t6sheet1")
    							{
    								formObj.f_cmd.value = SEARCH05;
    								var arr = new Array("t6sheet1_", "");
    								var sXml = sheetObj.GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
    								var arrXml = sXml.split("|$$|");

    								for(var i = 0; i<arrXml.length; i++){ 
      									//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 2, dtData,80,daCenter,	true,"t6sheet1_loc_cd",	false,"",dfNone,0,false,true);

    									if(i == 0)
    									{
    										sheetObj.LoadSearchXml(arrXml[0]); 
    									}
    									
    									//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 2, dtComboEdit,80,daCenter,true,"t6sheet1_loc_cd",	false,"",dfNone,0,false,true,5);
    									sheetObj.InitDataCombo(0, "t6sheet1_loc_cd", "", "");  //콤보 초기화
    									var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
    									if(arrCombo != null){
    										sheetObj.InitDataCombo(0, "t6sheet1_loc_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
    									}    											
    								}
    								
    							}else if ( sheetObj.id == "t7sheet1")
    							{
    								formObj.f_cmd.value = SEARCH06;
    								var arr = new Array("t7sheet1_", "");
    								var sXml = sheetObj.GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr));
    								var arrXml = sXml.split("|$$|");

    								for(var i = 0; i<arrXml.length; i++){ 
      										//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 2, dtData,	80,daCenter,true,"t7sheet1_loc_cd",	false,"",dfNone,0,false,true);
    									
    									if(i == 0)
    									{
    										sheetObj.LoadSearchXml(arrXml[0]); 
    									}
    									
    									//콤보 타입 변경
    									sheetObj.InitDataProperty(0, 2, dtComboEdit,80,	daCenter,true,"t7sheet1_loc_cd",false,"",dfNone,0,false,true, 5);
    									sheetObj.InitDataCombo(0, "t7sheet1_loc_cd", "", "");  //콤보 초기화
    									var arrCombo = ComXml2ComboString(arrXml[1], "val", "name");
    									if(arrCombo != null){
    										sheetObj.InitDataCombo(0, "t7sheet1_loc_cd", " |"+arrCombo[0], " |"+arrCombo[1]);
    									}    											
   										
    								} 
    							} 
    					break;

    			case IBSAVE:			//저장
    					if(validateForm(sheetObj,formObj,sAction))
							if ( sheetObj.id == "t1sheet1")
							{
								//필수 체크
								var idxNul = sheetObj.FindText("t1sheet1_yd_cd", " ");
								if(idxNul > 1){
									ComShowCodeMessage("VSK50010",idxNul-1, "TMNL Code");
								    sheetObj.SelectCell(idxNul, "t1sheet1_yd_cd", true);
								    return ;
								}
								
				            	// Port 중복체크
				            	var idxDub = sheetObj.ColValueDup("t1sheet1_yd_cd");
				            	if(idxDub > -1){
				            		ComShowCodeMessage("VSK50303","Port", idxDub-1);
				            		sheetObj.SelectCell(idxDub, "t1sheet1_yd_cd", true);
				            		return ;
				            	}
				            	
								formObj.f_cmd.value = MULTI;
								sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_"), -1, sQuest);
							}else if (sheetObj.id == "t2sheet1")
							{
								//필수 체크
								var idxNul = sheetObj.FindText("t2sheet1_loc_cd", " ");
								if(idxNul > 1){
									ComShowCodeMessage("VSK50010",idxNul, "Port");
								    sheetObj.SelectCell(idxNul, "t2sheet1_loc_cd", true);
								    return ;
								}
								
								formObj.f_cmd.value = MULTI01;
								sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_"), -1, sQuest);
							}else if (sheetObj.id == "t3sheet1")
							{
								//필수 체크
								var idxNul = sheetObj.FindText("t3sheet1_to_loc_cd", " ");
								if(idxNul > 1){
									ComShowCodeMessage("VSK50010",idxNul-1, "TMNL Code");
								    sheetObj.SelectCell(idxNul, "t3sheet1_to_loc_cd", true);
								    return ;
								}
								// Port 중복체크
				            	var idxDub = sheetObj.ColValueDup("t3sheet1_to_loc_cd");
				            	if(idxDub > -1){
				            		ComShowCodeMessage("VSK50303","Port", idxDub-1);
				            		sheetObj.SelectCell(idxDub, "t3sheet1_to_loc_cd", true);
				            		return ;
				            	}										
								
								formObj.f_cmd.value = MULTI02;
								sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_"), -1, sQuest);
							}else if (sheetObj.id == "t4sheet1")
							{
								//필수 체크
								var idxNul = sheetObj.FindText("t4sheet1_loc_cd", " ");
								if(idxNul > 1){
									ComShowCodeMessage("VSK50010",idxNul, "Port");
								    sheetObj.SelectCell(idxNul, "t4sheet1_loc_cd", true);
								    return ;
								}
								
								// Port 중복체크									
					   			var idxDub = sheetObj.ColValueDup("t4sheet1_loc_cd");
					   			if(idxDub > -1){
					   				ComShowCodeMessage("VSK50303","Port", idxDub);
					   				sheetObj.SelectCell(idxDub, "t4sheet1_loc_cd", true);
					   				return ;
					   			}
								
								formObj.f_cmd.value = MULTI03;
								sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t4sheet1_"), -1, sQuest);
								
							}else if (sheetObj.id == "t5sheet1")
							{
								//L / Time 같은시간 체크
								//alert(sheetObj.RowCount);
								/*for(var z=2 ; z<=sheetObj.RowCount+1 ; z++){
									if( sheetObj.CellValue(z, "t5sheet1_scg_fm_lmt_hrmnt")!=""){
										//alert(sheetObj.CellValue(z, "t5sheet1_scg_fm_lmt_hrmnt")+"=="+sheetObj.CellValue(z, "t5sheet1_scg_to_lmt_hrmnt"));
						    			if(sheetObj.CellValue(z, "t5sheet1_scg_fm_lmt_hrmnt") == sheetObj.CellValue(z, "t5sheet1_scg_to_lmt_hrmnt")){
						    				ComShowCodeMessage("VSK50304");
						    				sheetObj.SelectCell(z, "t5sheet1_scg_to_lmt_hrmnt", true);
						    				return ;
						    			}
									}
								}*/
								
								// L/Time 중복체크 From ~ To								
					   			/*var idxDub = sheetObj.ColValueDup("t5sheet1_scg_fm_lmt_hrmnt|t5sheet1_scg_to_lmt_hrmnt");
					   			if(idxDub > -1){
					   				ComShowCodeMessage("VSK50303","L/Time", idxDub);
					   				sheetObj.SelectCell(idxDub, 5, true);
					   				return ;
					   			}*/
							
								formObj.f_cmd.value = MULTI04;
								var sParam =  ComGetSaveString(sheetObjects, true, true);
								if( sParam == ""){ return;}
//								sheetObj.GetSaveXml("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + sParam , true);
								sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t5sheet1_"), -1, sQuest);
								
								/*formObj.f_cmd.value = MULTI04;
								var sParam =  sheetObjects[9].GetSaveString(true, true);
								if( sParam == ""){ return;}
								sheetObj.DoAllSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + sParam, true);*/
							}else if (sheetObj.id == "t6sheet1")
							{
								//필수 체크
								var idxNul = sheetObj.FindText("t6sheet1_loc_cd", " ");
								if(idxNul > 1){
									ComShowCodeMessage("VSK50010",(idxNul-1), "Port");
								    sheetObj.SelectCell(idxNul, "t6sheet1_loc_cd", true);
								    return ;
								}
								
								// Port 중복체크								
				    			var idxDub = sheetObj.ColValueDup("t6sheet1_loc_cd");
				    			if(idxDub > -1){
				        			var idxDub2 =idxDub-1;
				    				ComShowCodeMessage("VSK50303","Port", idxDub2);
				    				sheetObj.SelectCell(idxDub, "t6sheet1_loc_cd", true);
				    				return ;
				    			}	
								
								formObj.f_cmd.value = MULTI05;
								sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t6sheet1_"), -1, sQuest);
							}else if (sheetObj.id == "t7sheet1")
							{
								//mySheet.FindText(Col, SearchText, [StartRow], [FullMatch], [CaseSensitive]) 
								//필수 체크
								var idxNul = sheetObj.FindText("t7sheet1_loc_cd", " ");
								if(idxNul > 1){
									ComShowCodeMessage("VSK50010",(idxNul-1), "Port");
								    sheetObj.SelectCell(idxNul, "t7sheet1_loc_cd", true);
								    return ;
								}
								
								// Port 중복체크
				    			var idxDub = sheetObj.ColValueDup("t7sheet1_loc_cd");
				    			if(idxDub > -1){
				    				var idxDub2 = idxDub-1;
				    				ComShowCodeMessage("VSK50303","Port", idxDub2);
				    				sheetObj.SelectCell(idxDub, "t7sheet1_loc_cd", true);
				    				return ;
				    			}
				    			
								formObj.f_cmd.value = MULTI06;
								sheetObj.DoSave("VOP_VSK_0504GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t7sheet1_"), -1, sQuest);																																																	
							}	
    					break; 

    			case IBCLEAR:		// 입력
    					//if(validateForm(sheetObj,formObj,sAction))
    						//해당 시트 변경사항 개수
    				
    						//btnNewFlg = true;  //New Botton 클릭 확인 플래그
    						
							var statsCnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");    						
							if ( sheetObj.id == "t1sheet1")
							{
								if(statsCnt > 0 )
								{
									if(ComShowCodeConfirm("VSK50012")){
    									formObj.loc_cd.value = "";
    									formObj.in_rhq.value = "";
    									formObj.upd_dt.value = "";
    									formObj.upd_usr_id.value = "";            		
    									sheetObj.RemoveAll();
    									document.form.mnvr_rmk.value = "";
									}
								}else{
    								//if(ComShowCodeConfirm("VSK50004")){
    									formObj.loc_cd.value = "";
    									formObj.in_rhq.value = "";
    									formObj.upd_dt.value = "";
    									formObj.upd_usr_id.value = "";            		
    									sheetObj.RemoveAll();
    									document.form.mnvr_rmk.value = "";
    								//}
    							}
							}else if (sheetObj.id == "t2sheet1")
							{
								if(statsCnt > 0 )
								{
									if(ComShowCodeConfirm("VSK50012")){
					            		formObj.loc_cd.value = "";
					            		comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
									}
								}else{
	    							//if(ComShowCodeConfirm("VSK50004")){
					            		formObj.loc_cd.value = "";
					            		comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
									//}
    							}
							}else if (sheetObj.id == "t3sheet1")
							{
								if(statsCnt > 0 )
								{
									if(ComShowCodeConfirm("VSK50012")){
	    								formObj.loc_cd.value = "";
	    								formObj.in_rhq.value = "";
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
									}
								}else{
	    							//if(ComShowCodeConfirm("VSK50004")){
	    								formObj.loc_cd.value = "";
	    								formObj.in_rhq.value = "";
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
	    							//}
								}	
							}else if (sheetObj.id == "t4sheet1")
							{
								if(statsCnt > 0 )
								{
									if(ComShowCodeConfirm("VSK50012")){
	    								formObj.loc_cd.value = "";
	    								comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
									}
								}else{	
	    							//if(ComShowCodeConfirm("VSK50004")){
	    								formObj.loc_cd.value = "";
	    								comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
	    							//}
								}
							}else if (sheetObj.id == "t5sheet1")
							{
								if(statsCnt > 0 )
								{
									if(ComShowCodeConfirm("VSK50012")){
	    								//formObj.loc_cd.value = "";
	    								formObj.in_rhq.value = "";
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
					            		sheetObjects[5].RemoveAll();
									}
								}else{
									//if(ComShowCodeConfirm("VSK50004")){
	    								//formObj.loc_cd.value = "";
	    								//formObj.in_rhq.value = "";
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
					            		sheetObjects[5].RemoveAll();
	    							//}
								}
							}else if (sheetObj.id == "t6sheet1")
							{
								if(statsCnt > 0 )
								{
									if(ComShowCodeConfirm("VSK50012")){
	    								formObj.loc_cd.value = "";
	    								comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";
					            		sheetObj.RemoveAll();
					            		document.form.trsp_rmk_td.value = "";
									}
								}else{	
	    							//if(ComShowCodeConfirm("VSK50004")){
	    								formObj.loc_cd.value = "";
	    								comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";
					            		sheetObj.RemoveAll();
					            		document.form.trsp_rmk_td.value = "";
	    							//}
								}	
							}else if (sheetObj.id == "t7sheet1")
							{
								if(statsCnt > 0 )
								{
									if(ComShowCodeConfirm("VSK50012")){
	    								formObj.loc_cd.value = "";
	    								comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
					            		document.form.trsp_rmk_rd.value = "";
									}
								}else{	
	    							//if(ComShowCodeConfirm("VSK50004")){
	    								formObj.loc_cd.value = "";
	    								comboObjects[0].RemoveAll();
					            		initCombo(comboObjects[0], 1);
					            		formObj.upd_dt.value = "";
					            		formObj.upd_usr_id.value = "";            		
					            		sheetObj.RemoveAll();
					            		document.form.trsp_rmk_rd.value = "";
	    							//}
								}
							}
							formObj.cel_year.value = formObj.nowYear.value;
    					break;
            
            }
        }

        function initControl() {
        	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        	axon_event.addListenerFormat('keyup', 'obj_keyup', form);
        	axon_event.addListener('change', 'loc_cd_onchange', 'loc_cd', '');            //loc_cd 변경 Event
        	axon_event.addListener('change', 'loc_cd_onchangeMax5', 'loc_cd', '');            //loc_cd 변경 Event
        	axon_event.addListener('mousedown', 'obj_mousedown',  "btn_New");   
        	axon_event.addListener('keyup', 'mnvr_rmk_onchange', 'mnvr_rmk', form);      //mnvr_rmk 변경 Event
        	axon_event.addListener('keyup', 'trsp_rmk_td_onchange', 'trsp_rmk_td', '');  //trsp_rmk_td 변경 Event      	
        	axon_event.addListener('keyup', 'trsp_rmk_rd_onchange', 'trsp_rmk_rd', '');  //trsp_rmk_rd 변경 Event
        	//axon_event.addListener('keydown', 'obj_KeyEnter', 'form');
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
        }

        /*function obj_KeyEnter(){
            var formObject = document.form;
    		var objs = document.all.item("tabLayer");
    		
    		var sheetObject1 = sheetObjects[0];
    		var sheetObject2 = sheetObjects[1];
    		var sheetObject3 = sheetObjects[2];
    		var sheetObject4 = sheetObjects[3];
    		var sheetObject5 = sheetObjects[4]; 
    		var sheetObject6 = sheetObjects[5];
    		var sheetObject7 = sheetObjects[6];
    		var sheetObject8 = sheetObjects[7];   
    		
    		if( event.keyCode == 13 && formObject.loc_cd.value.length == 5 ){
				if( objs[0].style.display == "inline" ){
					doActionIBSheet(sheetObject1,formObject,IBSEARCH,true);   //tab1
				}else if( objs[1].style.display == "inline" ){
					doActionIBSheet(sheetObject2,formObject,IBSEARCH,true);   //tab2
				}else if( objs[2].style.display == "inline" ){
					//ComShowCodeMessage('VSK50016');
					doActionIBSheet(sheetObject3,formObject,IBSEARCH,true);   //tab3
				}else if( objs[3].style.display == "inline" ){
					doActionIBSheet(sheetObject4,formObject,IBSEARCH,true);   //tab4
				}else if( objs[4].style.display == "inline" ){
					doActionIBSheet(sheetObject5,formObject,IBSEARCH,true);   //tab5
				}else if( objs[5].style.display == "inline" ){
					doActionIBSheet(sheetObject7,formObject,IBSEARCH,true);   //tab6    							
				}else if( objs[6].style.display == "inline" ){
					doActionIBSheet(sheetObject8,formObject,IBSEARCH,true);   //tab7    							
				}
        	}
        }*/
        
        /**
         * IBTab Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++] = tab_obj;

        }

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
                        InsertTab( cnt++ , "Maneuvering" , -1 );
                        InsertTab( cnt++ , "Terminal Non-Working" , -1 );
                        InsertTab( cnt++ , "Distance" , -1 );
                        InsertTab( cnt++ , "Doc.&Dead Hrs" , -1 );
                        InsertTab( cnt++ , "Canal" , -1 );
                        InsertTab( cnt++ , "Trucking" , -1 );
                        InsertTab( cnt++ , "Railroad" , -1 );
                    }
                 break;

             }
        }

        /**
         * Tab 클릭시 이벤트 관련
         * 선택 전 탭의 변경사항 저장 유무 확인 한다.
         */
        function sheet_Cud_Click(tabObj)
        {
            var formObject = document.form;
        	if(tabNowCnt > 0){
        		if( tabNowCnt < 6 ){
        			var beforCnt = tabNowCnt-1; // sheet6, sheet7은 sheetObjects[] 1크게 되어 있다.
        		}else{
        			var beforCnt = tabNowCnt;
        		}
        		
        		var statsCnt = sheetObjects[beforCnt].RowCount("I") + sheetObjects[beforCnt].RowCount("U") + sheetObjects[beforCnt].RowCount("D");
        		if(statsCnt > 0){
        			if(ComShowCodeConfirm("VSK50009", tabObj.TabText(tabNowCnt-1))){
        				doActionIBSheet(sheetObjects[beforCnt],formObject,IBSAVE, false);
        			}else{
        				sheetObjects[beforCnt].RemoveAll();
        				//Canal Dtail Sheet 초기화
        				if(beforCnt == 0){
        					document.form.mnvr_rmk.value = "";
        				}else if(beforCnt == 4){
        					sheetObjects[beforCnt+1].RemoveAll();
        				}else if(beforCnt == 5){
        					document.form.trsp_rmk_td.value = "";
        				}else if(beforCnt == 6){
        					document.form.trsp_rmk_rd.value = "";
        				}
        			}
        		}	
        	}	
        }        

        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         */
        function tab1_OnChange(tabObj , nItem)
        {
            var objs = document.all.item("tabLayer");
            var formObject = document.form;
            
    	   	objs[nItem].style.display = "Inline";
    	   	objs[beforetab].style.display = "none";

   	    	//--------------- 요기가 중요 --------------------------//
   	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
   	    	//------------------------------------------------------//
   	    	beforetab= nItem;

            switch(nItem) {
            	case 0:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value = "";
            		formObject.loc_cd.className = "input1";
            		formObject.loc_cd.readOnly = false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display = "none";
        			document.all.item("inputRhq").style.display = "inline";
        			formObject.in_rhq.value = "";
            		formObject.upd_dt.value = "";
            		formObject.upd_usr_id.value = "";
            		formObject.cel_year.className = "input2";
            		formObject.cel_year.readOnly = true;
            		ComEnableObject(document.all.btn_Calendar, false);            		
            		tabNowCnt = 1;
            		break;
            	case 1:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value = "";
            		formObject.loc_cd.className = "input";
            		formObject.loc_cd.readOnly = false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display = "inline";
        			document.all.item("inputRhq").style.display = "none";
            		formObject.upd_dt.value = "";
            		formObject.upd_usr_id.value = "";
            		comboObjects[0].RemoveAll();
            		comboObjects[0].Enable = true;
            		initCombo(comboObjects[0], 1);            		
            		formObject.cel_year.value = formObject.nowYear.value;
            		formObject.cel_year.className = "input";
            		formObject.cel_year.readOnly = false;
            		ComEnableObject(document.all.btn_Calendar, true);            		
            		setPort_Grid_Combo(1);
            		tabNowCnt = 2;
            		break;
            	case 2:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value = "";
            		formObject.loc_cd.className = "input1";
            		formObject.loc_cd.readOnly = false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display = "none";
        			document.all.item("inputRhq").style.display = "inline";
        			formObject.in_rhq.value = "";
            		formObject.upd_dt.value = "";
            		formObject.upd_usr_id.value = "";            		
            		formObject.cel_year.className = "input2";
            		formObject.cel_year.readOnly = true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		tabNowCnt = 3;            		
            		break;
            	case 3:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value = "";
            		formObject.loc_cd.className = "input";
            		formObject.loc_cd.readOnly = false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display = "inline";
        			document.all.item("inputRhq").style.display = "none";
            		formObject.upd_dt.value = "";
            		formObject.upd_usr_id.value = "";            		
            		comboObjects[0].RemoveAll();
            		comboObjects[0].Enable = true;
            		initCombo(comboObjects[0], 1);
            		formObject.cel_year.className = "input2";
            		formObject.cel_year.readOnly = true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		setPort_Doc_Combo(3);
            		tabNowCnt = 4;
            		break;
            	case 4:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value = "EGSUZ";
            		formObject.loc_cd.className = "input2";
            		formObject.loc_cd.readOnly = true;
            		initBtn_loc_cd(false);
            		formObject.btn_loc_cd.Disabled = true;
        			document.all.item("comboRhq").style.display = "none";
        			document.all.item("inputRhq").style.display = "inline";
        			formObject.in_rhq.value = "HAMRU";
            		formObject.upd_dt.value = "";
            		formObject.upd_usr_id.value = "";
            		formObject.cel_year.className = "input2";
            		formObject.cel_year.readOnly = true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		tabNowCnt = 5;
            		break;
            	case 5:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value = "";
            		formObject.loc_cd.className = "input";
            		formObject.loc_cd.readOnly = false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display = "inline";
        			document.all.item("inputRhq").style.display = "none";            		
            		formObject.upd_dt.value = "";
            		formObject.upd_usr_id.value = "";            		
            		comboObjects[0].RemoveAll();
            		comboObjects[0].Enable = true;
            		initCombo(comboObjects[0], 1);
            		formObject.cel_year.className = "input2";
            		formObject.cel_year.readOnly = true;
            		ComEnableObject(document.all.btn_Calendar, false);
            		formObject.trsp_mod_cd.value = "TD";
            		setPortTrsp_Grid_Combo(6);
            		tabNowCnt = 6;
            		break;            		
            	case 6:
            		sheet_Cud_Click(tabObj);
            		formObject.loc_cd.value = "";
            		formObject.loc_cd.className = "input";
            		formObject.loc_cd.readOnly = false;
            		initBtn_loc_cd(true);
        			document.all.item("comboRhq").style.display = "inline";
        			document.all.item("inputRhq").style.display = "none";               		
            		formObject.upd_dt.value = "";
            		formObject.upd_usr_id.value = "";
            		comboObjects[0].RemoveAll();
            		comboObjects[0].Enable = true;
            		initCombo(comboObjects[0], 1);
            		formObject.cel_year.className = "input2";
            		formObject.cel_year.readOnly = true;
            		formObject.trsp_mod_cd.value = "RD";
            		ComEnableObject(document.all.btn_Calendar, false);
            		setPortTrsp_Grid_Combo(7);
            		tabNowCnt = 7;
            		break;
            	
            }
        }
    
        /**
         *  선택된 탭에 따라 Port Code 조회 팝업 버튼 Class style 변경 
         * @return
         */
        function initBtn_loc_cd(Flag){
        	if(Flag){
        		document.all.btn_loc_cd.src =  '/hanjin/img/btns_search.gif';	 
        		document.all.btn_loc_cd.className='cursor';
        	}else{
        	    document.all.btn_loc_cd.src =  '/hanjin/img/btns_search_off.gif';	 
        	    document.all.btn_loc_cd.className='';
        	}
        }
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            	if (sheetObj.id == "t1sheet1")
            	{
    				if(ComIsEmpty(formObj.loc_cd.value))
    				{
    					ComShowCodeMessage('VSK50008');
    					ComAlertFocus(formObj.loc_cd, "");
    					return false;
    				}	
            	}else if (sheetObj.id == "t3sheet1")
            	{
    				if(ComIsEmpty(formObj.loc_cd.value))
    				{
    					ComShowCodeMessage('VSK50008');
    					ComAlertFocus(formObj.loc_cd, "");
    					return false;
    				}
    				
    				
            	}else if (sheetObj.id == "t5sheet1")
            	{
    				if(ComIsEmpty(formObj.loc_cd.value))
    				{
    					ComShowCodeMessage('VSK50008');
    					ComAlertFocus(formObj.loc_cd, "");
    					return false;
    				}	
            	} 
            }

            return true;
        }
        
        var checkyDcDFlg1 = false;  //Tmml Code 체크 플러그        
    	function t1sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			if(!checkyDcDFlg1){
    				sheetObj.SelectCell(Row, "t1sheet1_yd_cd", true);
    			}
    		}
    	}
        
    	function t1sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    		//alert("OldCol="+OldCol+"NewCol="+NewCol);
    		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t1sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t1sheet1_upd_usr_id");
    		document.form.mnvr_rmk.value = sheetObj.CellValue(NewRow, "t1sheet1_mnvr_rmk");
    		
    		if(OldCol == 2){
    			if(!checkyDcDFlg1){
    				sheetObj.SelectCell(NewRow, "t1sheet1_yd_cd", true);
    			}
    		}
    	}
    	
    	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount > 0){
        		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_upd_dt");	
        		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_upd_usr_id");
    			document.form.mnvr_rmk.value = sheetObj.CellValue(sheetObj.SelectRow, "t1sheet1_mnvr_rmk");
    		}
    	}        

       	// Port 중복체크 및 TMNL Code 선택시 TMNL Name 입력
    	function t1sheet1_OnChange(sheetObj, Row, Col, Value){
    		
    		if(fastFlg){
    			if(Col == 2){
    				checkyDcDFlg1 = false;

    				//유효 TMNL Code 체크
    				var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode = sCode.split("|");

    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checkyDcDFlg1 = true;
    					}
    				}

    				//유효 TMNL Code 없을 경우 TMNL Code 이동
    				if(!checkyDcDFlg1){
    					//7자리 체크 및 유효 TMNL Code 체크 
    					if(sheetObj.CellValue(Row, "t1sheet1_yd_cd") != "" ){
    						if(sheetObj.CellValue(Row, "t1sheet1_yd_cd").length < 7){
    							ComShowCodeMessage("VSK50018");
    						}else{
    							ComShowCodeMessage("VSK50020");
    						}
    					}
    					sheetObj.CellValue(Row, "t1sheet1_yd_cd") = "";
    					sheetObj.SelectCell(Row, "t1sheet1_yd_cd", true);
    				}
    				
    				if(checkyDcDFlg1){
	    				var sText = sheetObj.GetComboInfo(Row, Col, "Text");
	    				var arrText = sText.split("|");
	    				var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	    				var vText = arrText[idx].split("\t");
	    			
	    				sheetObj.CellValue(Row, "t1sheet1_yd_nm") = vText[1];
	    			
	    				var idxDub = sheetObj.ColValueDup("t1sheet1_yd_cd");
	    				if(idxDub > -1){
	    					var idxDub2 =idxDub-1;
	    					ComShowCodeMessage("VSK50303","Port", idxDub2);
	    				}else{
	    					sheetObj.CellValue(Row, "t1sheet1_temp_yd_cd")=Value;
	    				}
    				}
    			}
    		}
    	}    	
    	
        var checklLocCdFlg2 = false;  //Loc Code 2 체크 플러그      
    	function t2sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 3){
    			if(!checklLocCdFlg2){
    				sheetObj.SelectCell(Row, "t2sheet1_loc_cd", true);
    			}
    		}
    	} 
    	
    	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    		//alert("OldCol="+OldCol+"NewCol="+NewCol);
    		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t2sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t2sheet1_upd_usr_id");
    		if(OldCol == 3){
    			if(!checklLocCdFlg2){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}
    	
    	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount > 0){
        		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t2sheet1_upd_dt");
        		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t2sheet1_upd_usr_id");
    		}
    	}        

    	function t2sheet1_OnChange(sheetObj, Row, Col, Value){
			if(Col == 3){
				checklLocCdFlg2 = false;

				//유효 TMML Code 체크
				var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
				var arrCode = sCode.split("|");

				for(var i=0 ; i<arrCode.length ; i++){
					if(arrCode[i] == Value ){
						checklLocCdFlg2 = true;
					}
				}

				//유효 Loc Code 없을 경우 Loc Code 이동
				if(!checklLocCdFlg2){
					//5자리 체크 및 유효 Port Code 체크 
					if(sheetObj.CellValue(Row, "t2sheet1_loc_cd") != "" ){
						if(sheetObj.CellValue(Row, "t2sheet1_loc_cd").length < 5){
							ComShowCodeMessage("VSK50014");
						}else{
							ComShowCodeMessage("VSK50015");
						}
					}					
					sheetObj.CellValue(Row, "t2sheet1_loc_cd") = "";
					sheetObj.SelectCell(Row, "t2sheet1_loc_cd", true);
				}
			}else if(Col==5){
				if(!ComIsDateTime(sheetObj.CellValue(Row, "t2sheet1_hol_st_dt"), "ymd", "hm") && sheetObj.CellValue(Row, "t2sheet1_hol_st_dt") != ""){
					ComShowCodeMessage("VSK50031", "YYYY-MM-DD hh:mm");
					sheetObj.CellValue(Row, "t2sheet1_hol_st_dt") = "";
					sheetObj.SelectCell(Row, "t2sheet1_hol_st_dt", true);
				}
			}else if(Col==6){
				if(!ComIsDateTime(sheetObj.CellValue(Row, "t2sheet1_hol_end_dt"), "ymd", "hm") && sheetObj.CellValue(Row, "t2sheet1_hol_end_dt") != ""){
					ComShowCodeMessage("VSK50031", "YYYY-MM-DD hh:mm");
					sheetObj.CellValue(Row, "t2sheet1_hol_end_dt") = "";
					sheetObj.SelectCell(Row, "t2sheet1_hol_end_dt", true);
				}
			}
    	} 
    	
    	function t2sheet1_OnSaveEnd(sheetObj, ErrMsg){
    		var formObject = document.form;
    		if(sheetObj.RowCount > 0){
    			doActionIBSheet(sheetObj,formObject,IBSEARCH,true);   //tab2
    		}
    	}     	   	
    	
    	var checklLocCdFlg3 = false;  //Loc Code 3 체크 플러그  
    	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 4){
    			if(!checklLocCdFlg3){
    				sheetObj.SelectCell(Row, "t3sheet1_to_loc_cd", true);
    			}
    		}
    	}
    	
    	function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    		//alert("OldCol="+OldCol+"NewCol="+NewCol);
    		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t3sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t3sheet1_upd_usr_id");
    		
    		if(OldCol == 4){
    			if(!checklLocCdFlg3){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}

    	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount > 0){
        		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_dt");
        		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_usr_id");
    		}
    	}    	

        function t3sheet1_OnChange(sheetObj, Row, Col, Value){
            if(fastFlg){
            	if(Col == 4)
            	{	
            		checklLocCdFlg3 = false;

    				//유효 TMML Code 체크
    				var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode = sCode.split("|");

    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checklLocCdFlg3 = true;
    					}
    				}

    				//유효 Loc Code 없을 경우 Loc Code 이동
    				if(!checklLocCdFlg3){
    					//5자리 체크 및 유효 Port Code 체크 
    					if(sheetObj.CellValue(Row, "t3sheet1_to_loc_cd") != "" ){
    						if(sheetObj.CellValue(Row, "t3sheet1_to_loc_cd").length < 5){
    							ComShowCodeMessage("VSK50014");
    						}else{
    							ComShowCodeMessage("VSK50015");
    						}
    					}    					
    					sheetObj.CellValue(Row, "t3sheet1_to_loc_cd") = "";
    					sheetObj.SelectCell(Row, "t3sheet1_to_loc_cd", true);
    				}
    				
    				if(checklLocCdFlg3){
	            		var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	            		if(idx > 0){
	            			var arrT3Dfs = t3Dfs.split("|");
	            			sheetObj.CellValue(Row, "t3sheet1_gmt_td_hrs") = arrT3Dfs[idx-1];
	            		}else{
	            			sheetObj.CellValue(Row, "t3sheet1_gmt_td_hrs") = "";
	            		}
	            		
	            		// Port 중복체크
	            		var idxDub = sheetObj.ColValueDup("t3sheet1_to_loc_cd");
	            		if(idxDub > -1){
	            			ComShowCodeMessage("VSK50303","Port", idxDub-1);
	            		}else{
	       					sheetObj.CellValue(Row, "t3sheet1_temp_to_loc_cd")=Value;
	            		}
    				}
            	}	
            }
        }    	
    	
        
        var checklLocCdFlg4 = false;  //Loc Code 4 체크 플러그        
    	function t4sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			if(!checklLocCdFlg4){
    				sheetObj.SelectCell(Row, "t4sheet1_loc_cd", true);
    			}
			}
    	} 
        
    	function t4sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t4sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t4sheet1_upd_usr_id");
    		
    		if(OldCol == 2){
    			if(!checklLocCdFlg4){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}
    	
    	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount > 0){
        		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t4sheet1_upd_dt");
        		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t4sheet1_upd_usr_id");
    		}
    	}    	
    	
    	// Port 중복체크
    	function t4sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			checklLocCdFlg4 = false;

				//유효 TMML Code 체크
				var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
				var arrCode = sCode.split("|");

				for(var i=0 ; i<arrCode.length ; i++){
					if(arrCode[i] == Value ){
						checklLocCdFlg4 = true;
					}
				}
    			
				//유효 Loc Code 없을 경우 Loc Code 이동
				if(!checklLocCdFlg4){
					//5자리 체크 및 유효 Port Code 체크 
					if(sheetObj.CellValue(Row, "t4sheet1_loc_cd") != "" ){
						if(sheetObj.CellValue(Row, "t4sheet1_loc_cd").length < 5){
							ComShowCodeMessage("VSK50014");
						}else{
							ComShowCodeMessage("VSK50015");
						}
					} 					
					sheetObj.CellValue(Row, "t4sheet1_loc_cd") = "";
					sheetObj.SelectCell(Row, "t4sheet1_loc_cd", true);
				}
				
				if(checklLocCdFlg4){
					var idxDub = sheetObj.ColValueDup("t4sheet1_loc_cd");
	    			if(idxDub > -1){
	    				ComShowCodeMessage("VSK50303","Port", idxDub);
	    			}else{
    					sheetObj.CellValue(Row, "t4sheet1_temp_loc_cd")=Value;
	    			}
				}
    		}	
    	}
    	
    	function t5sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
			document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t5sheet1_upd_dt");
			document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t5sheet1_upd_usr_id");
    	}
    	
    	function t5sheet2_OnChange(sheetObj, Row, Col, Value){
    		// kjh change function :: suz 운하 tier를 bound별로 수정삭제가 가능하도록  
    		var tmp = 0;
    		if( Row == 1 ){
    			tmp = 0;
    		}else{
    			tmp = 9;
    		}
    		sheetObjects[9].CellValue(Col+tmp-2, "t5sheet3_tr_scg_rto")  = Value;
    	}    	
    	
    	function t5sheet1_OnSaveEnd(sheetObj,ErrMsg){
    		var formObject = document.form;
    		doActionIBSheet(sheetObjects[4],formObject,IBSEARCH, true);   //tab5
    	}
    	
        var checklLocCdFlg6 = false;  //Loc Code 6 체크 플러그        
    	function t6sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col == 2){
    			if(!checklLocCdFlg6){
    				sheetObj.SelectCell(Row, "t6sheet1_loc_cd", true);
    			}
    		}
    	} 
    	
        function t6sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
        	//alert("OldCol="+OldCol+"NewCol="+NewCol);
    		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t6sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t6sheet1_upd_usr_id");
    		document.form.trsp_rmk_td.value = sheetObj.CellValue(NewRow, "t6sheet1_trsp_rmk");
    		
    		if(OldCol == 2){
    			if(!checklLocCdFlg6){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}
    	}

    	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount > 0){
        		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t6sheet1_upd_dt");
        		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t6sheet1_upd_usr_id");
        		document.form.trsp_rmk_td.value = sheetObj.CellValue(sheetObj.SelectRow, "t6sheet1_trsp_rmk");
    		}
    	}   	
    	    
    	// Port 중복체크
    	function t6sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(fastFlg){
    			if(Col == 2){
    				checklLocCdFlg6 = false;

    				//유효 TMML Code 체크
    				var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode = sCode.split("|");

    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checklLocCdFlg6 = true;
    					}
    				}

    				//유효 Loc Code 없을 경우 Loc Code 이동
    				if(!checklLocCdFlg6){
    					//5자리 체크 및 유효 Port Code 체크 
    					if(sheetObj.CellValue(Row, "t6sheet1_loc_cd") != "" ){
    						if(sheetObj.CellValue(Row, "t6sheet1_loc_cd").length < 5){
    							ComShowCodeMessage("VSK50014");
    						}else{
    							ComShowCodeMessage("VSK50015");
    						}
    					}     					
    					sheetObj.CellValue(Row, "t6sheet1_loc_cd") = "";
    					sheetObj.SelectCell(Row, "t6sheet1_loc_cd", true);
    				}
    				
    				if(checklLocCdFlg6){
		    			var idxDub = sheetObj.ColValueDup("t6sheet1_loc_cd");
		    			if(idxDub > -1){
		        			var idxDub2 =idxDub-1;
		    				ComShowCodeMessage("VSK50303","Port", idxDub2);
		    			}else{
		    				//if(Col == 2)
		    					sheetObj.CellValue(Row, "t6sheet1_temp_loc_cd")=Value;
		    			}
    				}
    			}
    		}
    	}
    	
        var checklLocCdFlg7 = false;  //Loc Code 7 체크 플러그        
    	function t7sheet1_OnClick(sheetObj, Row, Col, Value){
    		if(Col==2){
    			if(!checklLocCdFlg7){
    				sheetObj.SelectCell(Row, "t7sheet1_loc_cd", true);
				}
    		}
    	} 
    	
    	function t7sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    		document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t7sheet1_upd_dt");
    		document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t7sheet1_upd_usr_id");
    		document.form.trsp_rmk_rd.value = sheetObj.CellValue(NewRow, "t7sheet1_trsp_rmk");
    		
    		if(OldCol == 2){
    			if(!checklLocCdFlg7){
    				sheetObj.SelectCell(NewRow, OldCol, true);
    			}
    		}    		
    	}

    	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
    		if(sheetObj.RowCount > 0){
        		document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t7sheet1_upd_dt");
        		document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t7sheet1_upd_usr_id");
        		document.form.trsp_rmk_rd.value = sheetObj.CellValue(sheetObj.SelectRow, "t7sheet1_trsp_rmk");
    		}
    	}
    	 
    	// Port 중복체크
    	function t7sheet1_OnChange(sheetObj, Row, Col, Value){
    		if(fastFlg){
    			
    			if(Col == 2){
    				checklLocCdFlg7 = false;

    				//유효 TMML Code 체크
    				var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
    				var arrCode = sCode.split("|");

    				for(var i=0 ; i<arrCode.length ; i++){
    					if(arrCode[i] == Value ){
    						checklLocCdFlg7 = true;
    					}
    				}

    				//유효 Loc Code 없을 경우 Loc Code 이동
    				if(!checklLocCdFlg7){
    					//5자리 체크 및 유효 Port Code 체크 
    					if(sheetObj.CellValue(Row, "t7sheet1_loc_cd") != "" ){
    						if(sheetObj.CellValue(Row, "t7sheet1_loc_cd").length < 5){
    							ComShowCodeMessage("VSK50014");
    						}else{
    							ComShowCodeMessage("VSK50015");
    						}
    					}     					
    					sheetObj.CellValue(Row, "t7sheet1_loc_cd") = "";
    					sheetObj.SelectCell(Row, "t7sheet1_loc_cd", true);
    				}
    				
    				if(checklLocCdFlg7){
		    			var idxDub = sheetObj.ColValueDup("t7sheet1_loc_cd");
		    			if(idxDub > -1){
		    				var idxDub2 = idxDub-1;
		    				ComShowCodeMessage("VSK50303","Port", idxDub2);
		    			}else{
		    				//if(Col == 2)
		    					sheetObj.CellValue(Row, "t7sheet1_temp_loc_cd")=Value;
		    			}
    				}
    			}
    		}
    	}
    	
    	// [t2sheet1] 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
    	function t2sheet1_OnPopupClick(sheetObj, Row, Col)
    	{
    		with(sheetObj)
    		{
   			    var cal = new ComCalendarGrid();
    			if (sheetObj.ColSaveName(Col) == "t2sheet1_hol_st_dt") {
    			    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd HH:mm');
    		    }else if (sheetObj.ColSaveName(Col) == "t2sheet1_hol_end_dt") {
       			    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd HH:mm');
    		    }
    		}
    	}
    	
    	function loc_cd_onchangeMax5(){
    		var formObj = document.form;
    		
    		//Port Code 5자리 체크
    		if(formObj.loc_cd.value != ""){
    			//alert("LOC_CD = "+formObj.loc_cd.value);
    			if(formObj.loc_cd.value.length < 5 ){
    				ComShowCodeMessage("VSK50014");
    				ComAlertFocus(formObj.loc_cd, "");
    				//ComAlertFocus(formObj.upd_dt, "");
    				return ;
    			}
    		}
    	}
    	
    	var checkMouseFlg = false;
    	function obj_mousedown(){
    		var formObj = document.form;
    		doActionIBSheet(sheetObjects[beforetab],formObj,IBCLEAR,true);   //tab1
    	}
    	
    	
    	function loc_cd_onchange(){
    		var formObj = document.form;
    		
    		//Port Code 5자리 체크
    		/*if(formObj.loc_cd.value != ""){
    			//alert("LOC_CD = "+formObj.loc_cd.value);
    			if(formObj.loc_cd.value.length < 5 ){
    				ComShowCodeMessage("VSK50014");
    				ComAlertFocus(formObj.loc_cd, "");
    				return ;
    			}
    		}*/
    		
    		var objs = document.all.item("tabLayer");
			if( objs[0].style.display == "inline")
			{
	    		formObj.f_cmd.value = SEARCH07;
	    		var sXml = sheetObjects[8].GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj));
				var sVal = ComGetEtcData(sXml, "cmbVal");
				var sName = ComGetEtcData(sXml, "cmbName");

				if( sVal != "")
				{	
					//콤보 타입 변경
					sheetObjects[0].InitDataProperty(0, 2 , dtComboEdit,	80,	 	daCenter,	true,	"t1sheet1_yd_cd",	true,		"",	dfNone,	0,	false,	true, 7);

					var vInitDataComboName = "";
					var arrVal = sVal.split("|");
					var arrName = sName.split("|");
	
					for(var j=0; j<arrVal.length ; j++)
					{
						if(j == 0)
							vInitDataComboName = vInitDataComboName + arrVal[j] +"\t"+ arrName[j];
						else
							vInitDataComboName = vInitDataComboName + "|"+arrVal[j] +"\t"+ arrName[j];
					}
				
					sheetObjects[0].InitDataCombo(0, "t1sheet1_yd_cd", " |"+vInitDataComboName, " |"+sVal);
				}
				else
				{
					//ComShowMessage(ComVskGetMessageFromXml(sXml));					
   					//ComAlertFocus(formObj.loc_cd, ComGetMsg('VSK50015'));
					//sheetObjects[0].InitDataCombo(0, "t1sheet1_yd_cd", "", "", "");
				}
				
				setRhq_Combo(0);  /* RHQ Text 가져옴 */
				//ComAlertFocus(formObj.upd_dt, ""); //Focus 이동
			}else if( objs[1].style.display == "inline")
			{
				setRhq_Combo(1);  /* RHQ 콤보 가져옴 */
				//ComAlertFocus(formObj.upd_dt, "");
			}else if( objs[2].style.display == "inline")
			{
				setRhq_Combo(2); /* RHQ Text 가져옴 */
				formObj.f_cmd.value = SEARCH10;
				var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj));
				var sVal = ComGetEtcData(sXml, "cmbVal");
				var sName = ComGetEtcData(sXml, "cmbName");
				//DF 전역변수 세팅
				t3Dfs = ComGetEtcData(sXml, "cmbDf");	

				if( sVal != "")
				{
					sheetObjects[2].InitDataCombo(0, "t3sheet1_to_loc_cd", " |"+sVal, " |"+sName);
				}
			}else if( objs[3].style.display == "inline")
			{
				setRhq_Combo(3);   /* RHQ 콤보 가져옴 */
				setPort_Doc_Combo(3);		
			}else if( objs[4].style.display == "inline")
			{
				setRhq_Combo(4); /* RHQ Text 가져옴 */
			}else if( objs[5].style.display == "inline")
			{
				setRhq_Combo(5);   /* RHQ 콤보 가져옴 */
			}else if( objs[6].style.display == "inline")
			{
				setRhq_Combo(6);  /* RHQ 콤보 가져옴 */					
			}
    	}
    	
    	function mnvr_rmk_onchange(){
    		sheetObjects[0].CellValue(sheetObjects[0].SelectRow , "t1sheet1_mnvr_rmk") = document.form.mnvr_rmk.value;
    	}    	

    	function trsp_rmk_td_onchange(){
    		sheetObjects[6].CellValue(sheetObjects[6].SelectRow , "t6sheet1_trsp_rmk") = document.form.trsp_rmk_td.value;
    	}    	

    	function trsp_rmk_rd_onchange(){
    		sheetObjects[7].CellValue(sheetObjects[7].SelectRow , "t7sheet1_trsp_rmk") = document.form.trsp_rmk_rd.value;
    	}    	
    	
        function rhq_OnChange(comObj,index,text)
        {
        	var formObj = document.form;
			var objs = document.all.item("tabLayer");
			
			if(objs[1].style.display == "inline")
			{
				//if(rhqChangeFlg)
				formObj.loc_cd.value = "";
				rhqChangeFlg = true;
				setPort_Grid_Combo(1);
			}else if(objs[3].style.display == "inline")
			{
				//if(rhqChangeFlg)
				formObj.loc_cd.value = "";
				rhqChangeFlg = true;
				setPort_Doc_Combo(3);
			}else if(objs[5].style.display == "inline")
			{
				//if(rhqChangeFlg)
				formObj.loc_cd.value = "";
				rhqChangeFlg = true;
				
				setPortTrsp_Grid_Combo(6);
			}else if(objs[6].style.display == "inline")
			{
				formObj.loc_cd.value = "";
				rhqChangeFlg = true;
				
				setPortTrsp_Grid_Combo(7);
			}
        }
        
        /* RHQ 콤보 가져옴 */
    	function setRhq_Combo(tabCnt){
		    var formObj = document.form;
			formObj.f_cmd.value = SEARCH08;
			var sRhqXml = sheetObjects[8].GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sRhqVal = ComGetEtcData(sRhqXml, "cmbVal");
			var sRhqName = ComGetEtcData(sRhqXml, "cmbName");
	
			if( sRhqVal != "")
			{
				var arrRhqVal = sRhqVal.split("|");
				var arrRhqName = sRhqName.split("|");
				
				for(var i=0; i<arrRhqVal.length ; i++)
				{
					rhqChangeFlg = false;
					if(tabCnt==1 || tabCnt==3 || tabCnt== 5 || tabCnt==6){
						comboObjects[0].Code2 = arrRhqVal[0];
					}else{
						formObj.in_rhq.value = arrRhqVal[0];
					}
				}
				
				//Rhq 값에 따라 grid Combo 생성
				if(tabCnt == 1)
					setPort_Grid_Combo(1);
				else if(tabCnt == 3)
					setPort_Doc_Combo(3);
				else if(tabCnt == 5)
					setPortTrsp_Grid_Combo(6);
				else if(tabCnt == 6)
					setPortTrsp_Grid_Combo(7);
			}else{
				//ComAlertFocus(formObj.loc_cd, ComGetMsg('VSK50015'));
				//[2010.03.15] 김기용 차장 요청으로 Port초기화함.
				ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
				ComClearObject(formObj.loc_cd);
				
				if(tabCnt == 0 || tabCnt == 2){
					ComClearObject(formObj.in_rhq);
				}else if(tabCnt == 1 || tabCnt == 3 || tabCnt == 5 || tabCnt == 6){
					comboObjects[0].Code2 = "^";
				}
			}
    	}

        /* RHQ 콤보 선택따라 Port 콤보 가져옴 */
    	function setPort_Grid_Combo(tabCnt){

    		var formObj = document.form;
			formObj.f_cmd.value = SEARCH09;

			var sXml = sheetObjects[8].GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sVal = ComGetEtcData(sXml, "cmbVal");
			var sName = ComGetEtcData(sXml, "cmbName");

			//sheetObjects[tabCnt].InitDataCombo(0, "t"+(tabCnt+1)+"sheet1_loc_cd", "", "");
			
			if( sVal != "")
			{
				if(tabCnt == 1){
					//sheetObjects[1].RemoveAll();
					sheetObjects[1].InitDataCombo(0, "t2sheet1_loc_cd", " |"+sVal, " |"+sName);
				}
				/*else if(tabCnt == 3){
					//sheetObjects[3].RemoveAll();
					sheetObjects[3].InitDataCombo(0, "t4sheet1_loc_cd", " |"+sVal, " |"+sName);
				}*/
			}    	
    	}
    	
        /* RHQ 콤보 선택따라 Port 콤보 가져옴 */
    	function setPort_Doc_Combo(tabCnt){

    		var formObj = document.form;
			formObj.f_cmd.value = SEARCH12;

			var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sVal = ComGetEtcData(sXml, "cmbVal");
			var sName = ComGetEtcData(sXml, "cmbName");
			
			if( sVal != "")
			{
				if(tabCnt == 3){
					sheetObjects[3].InitDataCombo(0, "t4sheet1_loc_cd", " |"+sVal, " |"+sName);
				}
			} else {
				if(tabCnt == 3){
					sheetObjects[3].InitDataCombo(0, "t4sheet1_loc_cd", "", "");  //콤보 초기화
				}
			}
    	}    	
    	
        /* RHQ 콤보 가져옴 */
    	function setPortTrsp_Grid_Combo(tabCnt){
    		var formObj = document.form;
    		formObj.f_cmd.value = SEARCH11;

			var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0504GS.do", FormQueryString(formObj));
			var sVal = ComGetEtcData(sXml, "cmbVal");
			var sName = ComGetEtcData(sXml, "cmbName");

			if( sVal != "")
			{
				if(tabCnt == 6){
					//sheetObjects[6].RemoveAll();
					sheetObjects[6].InitDataCombo(0, "t6sheet1_loc_cd", " |"+sVal, " |"+sName);
				}else if(tabCnt == 7){
					//sheetObjects[7].RemoveAll();
					sheetObjects[7].InitDataCombo(0, "t7sheet1_loc_cd", " |"+sVal, " |"+sName);
				}
			} else {
				if(tabCnt == 6){
					sheetObjects[6].InitDataCombo(0, "t6sheet1_loc_cd", "", "");  //콤보 초기화
				}else if(tabCnt == 7){
					sheetObjects[7].InitDataCombo(0, "t7sheet1_loc_cd", "", "");  //콤보 초기화
				}
			}
    	}
    	
    	/**
    	 *  sXml에서 MESSAGE 내용을 추출 
    	 * @param sXml
    	 * @return Sring MESSAGE
    	 * @author jkc
    	 */
    	function ComVskGetMessageFromXml(sXml){
    		if ( sXml == null  || sXml == "" ) return;
    		try {
    			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
    			xmlDoc.loadXML(sXml);

    			var xmlRoot = xmlDoc.documentElement;
    			if(xmlRoot == null) return;
   
    			var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
    			if(msgNode == null) return "";

    			return msgNode.firstChild.nodeValue;
    		} catch(err) { ComFuncErrMsg(err.message); }
    	}
    	
    	/**
    	 *  sXml에서 DF 내용을 추출 
    	 */    	
    	function ComVskXml2ComboString(xmlStr, codeCol, textCol, val1) {

    		var rtnArr = new Array();
    		
    		if (xmlStr == null || xmlStr == "") {
    			return;
    		}
    		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
    			return;
    		}
    	
    		try {
    			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
    			xmlDoc.loadXML(xmlStr);
    	
    			var xmlRoot = xmlDoc.documentElement;
    			if (xmlRoot == null) {
    				return;
    			}
    	
    			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
    			if (dataNode == null || dataNode.attributes.length < 3) {
    				return;
    			}
    	
    			var col = dataNode.getAttribute("COLORDER");
    			var colArr = col.split("|");
    			var sep = dataNode.getAttribute("COLSEPARATOR");
    			var total = dataNode.getAttribute("TOTAL");
    	
    			var dataChildNodes = dataNode.childNodes;
    			if (dataChildNodes == null) {
    				return;
    			}
    			
    			var colListIdx = Array();
    			for ( var i = 0; i < colArr.length; i++) {
    				if (colArr[i] == codeCol) {
    					colListIdx[0] = i;
    				}
    				if (colArr[i] == textCol) {
    					colListIdx[1] = i;
    				}
    				if (colArr[i] == val1) {
    					colListIdx[2] = i;
    				}
    			}
    			
    			var sCode = "";
    			var sText = "";
    			var sVal1 = "";
    			for ( var i = 0; i < dataChildNodes.length; i++) {
    				if (dataChildNodes[i].nodeType != 1) {
    					continue;
    				}
    				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
    				
    				sCode += arrData[colListIdx[0]];
    				sText += arrData[colListIdx[1]];
    				sVal1 += arrData[colListIdx[2]];
    				
    				if (i != dataChildNodes.length - 1) {
    					sCode += "|";
    					sText += "|";
    					sVal1 += "|";
    				}
    			}
    			rtnArr.push(sCode);
    			rtnArr.push(sText);
    			rtnArr.push(sVal1);
    		} catch (err) {
    			ComFuncErrMsg(err.message);
    		}
    	
    		return rtnArr;
    	}
    	
        /** 
         * Object 의 Keypress 이벤트에 대한 처리  <br>
         * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
         * @param  없음
         * @return 없음
         * @author 김종옥
         * @version 2009.06.15
         */ 
        function obj_keypress(){
         	obj = event.srcElement;
         	if(obj.dataformat == null) return;
         	 	
         	window.defaultStatus = obj.dataformat;
         	 
         	switch(obj.dataformat) {
         	    case "engup":
         	        //if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
         	        ComKeyOnlyAlphabet('upper');
         	        break;
         	    case "engdn":
         	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
         	        else ComKeyOnlyAlphabet('lower');
         	        break;
                case "ymd":
                	ComKeyOnlyNumber(event.srcElement);
                    break;           	        
                case "uppernum":
                	ComKeyOnlyAlphabet('uppernum');
                	break;
         	}
        } 
        
        /** 
         * Object 의 Keypress 이벤트에 대한 처리  <br>
         * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
         * @param  없음
         * @return 없음
         * @author 김종옥
         * @version 2009.06.15
         */ 
        function obj_keyup(){
         	obj = event.srcElement;
         	if(obj.dataformat == null) return;
         	 	
         	window.defaultStatus = obj.dataformat;
         	 
         	switch(obj.dataformat) {
         	    case "engup":
         	        if(document.form.loc_cd.value.length == 5 ){    	        	
         	        	loc_cd_onchange();
         	        }
         	        break;
         	    case "engdn":
         	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
         	        else ComKeyOnlyAlphabet('lower');
         	        break;
         	}
        }         
	/* 개발자 작업  끝 */