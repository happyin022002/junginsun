/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0503.js
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 08
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
* 
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완 
* 2011.04.26 진마리아 CHM-201110282-01 로직 변경 요청(Engine Power 단위 BHP/KW 항목구분)
* 2012.04.02 진마리아 CHM-201217105-01 Local Vessel name 칼럼 추가 요청건
* 2012.10.08 이혜민   CHM-201220560-01 Vessel Particular Inquiry 조회 방법 수정 요청 (ENTER 키로 조회 가능)
* 2014.03.17 박다은 	 CHM-201428939-01 vessel particular - performance
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
     * @class vop_vsk_0503 : vop_vsk_0503 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0503() {
          this.processButtonClick     = tprocessButtonClick;
          this.setSheetObject         = setSheetObject;
          this.loadPage               = loadPage;
          this.initSheet              = initSheet;
          this.initControl            = initControl;
          this.doActionIBSheet        = doActionIBSheet;
          this.setTabObject           = setTabObject;
          this.validateForm           = validateForm;
    }
     
          /* 개발자 작업    */

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var comboList;
var comboObjects = new Array();
var combo1 = null
var combo2 = null;
var combo3 = null;
var combo4 = null;
var combo5 = null;
var combo6 = null;


var comboCnt = 0; 
var tmpVslCd = "";

////::2007816::////
var gUsrAuth		= "";
var gUsrAuthPerf	= "";
///////////////////


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         
         
         /*******************************************************/
         var formObject = document.form;
         var objs = document.all.item("tabLayer");
                      
          try {
                 var srcName = window.event.srcElement.getAttribute("name");

                        switch(srcName) {

                            case "btn_Retrieve":
                            	
                            	formObject.h_vsl_slan_cd.value = "";
                            	formObject.h_pf_skd_tp_cd.value = "";
                            	
                                if( objs[0].style.display == "inline" ){
                                          doActionIBSheet(sheetObject1,formObject,IBSEARCH);   //tab1
                                }else if( objs[1].style.display == "inline" ){
                                          doActionIBSheet(sheetObject1,formObject,IBSEARCH);   //tab1
                                }else if( objs[2].style.display == "inline" ){
                                          doActionIBSheet(sheetObject3,formObject,IBSEARCH);   //tab3sheet2
                                          doActionIBSheet(sheetObject2,formObject,IBSEARCH);   //tab3sheet1
                                          doActionIBSheet(sheetObject4,formObject,IBSEARCH);   //tab3sheet3
                                          doActionIBSheet(sheetObject4,formObject,SEARCH01);   //tab3sheet3
                                }
                                break;
                                
                            case "btn_Save":
                            	if(formObject.vsl_cd.value == ""){
                            		ComShowCodeMessage('VSK50013');
                            		formObject.vsl_cd.focus();
                            		return;	
                            	} 

//                            	if( objs[2].style.display == "inline" ){
                            		doActionIBSheet(sheetObject2,formObject,IBSAVE);
            						ComShowCodeMessage("COM130102", "Data");
            					    doActionIBSheet(sheetObject3, formObject, SEARCH01);
//                            	}
                            	break;

                            case "btn_New":
                                if( objs[0].style.display == "inline" ){
                                          doActionIBSheet(sheetObject1,formObject,IBCLEAR);   //tab1
                                }else if( objs[1].style.display == "inline" ){
                                          doActionIBSheet(sheetObject1,formObject,IBCLEAR);   //tab2
                                }else if( objs[2].style.display == "inline" ){
                                          doActionIBSheet(sheetObject2,formObject,IBCLEAR);   //tab3
                                }
                                break;

                            case "btn_Excel":
                                 if( objs[0].style.display == "inline" ){
                                           //sheetObject1.Down2Excel(-1);
                                           var vVesselCode = formObject.vsl_cd.value; //vessel Code
                                           sheetObject1.Down2Excel(-1,false,false,true,"","",false,false,vVesselCode,false,"","",false,true,"");
                                 }else if( objs[1].style.display == "inline" ){
                                           sheetObject1.Down2Excel(-1);
                                 }else if( objs[2].style.display == "inline" ){
                                	var sReportPageUrl	= "apps/alps/vop/vsk/vesseloperationsupportmgt/vesselinformationmgt/jsp/VOP_VSK_0503ExcelDown.jsp";
                                	 
                					var vsl_cd		    		= formObject.vsl_cd.value;                                                                                                                                                                     
                					var vsl_slan_cd             = formObject.vsl_slan_cd.value;                                      
                					var pf_spd                  = formObject.pf_spd.value;
                					var avg_slip                = formObject.avg_slip.value;
                					var pf_net_spd              = formObject.pf_net_spd.value;
                					var pf_foc_qty              = formObject.pf_foc_qty.value;
                					var avg_act_foc_qty         = formObject.avg_act_foc_qty.value;
                					var ctcl_rpm_no 	    	= formObject.ctcl_rpm_no.value; 
                					var ctcl_to_rpm_no 	    	= formObject.ctcl_to_rpm_no.value;
                					var op_min_rpm_no           = formObject.op_min_rpm_no.value;
                					var op_min_spd              = formObject.op_min_spd.value;
                					var slw_stmng_flg           = combo2.Text;
                					var spr_slw_stmng_flg       = combo3.Text;
                					var fuel_sav_eq_flg         = combo4.Text;
                					var in_hld_per_tr_knt	    = formObject.in_hld_per_tr_knt.value;
                					var in_hld_per_row_knt      = formObject.in_hld_per_row_knt.value;
                					var htch_cvr_in_hld_knt     = formObject.htch_cvr_in_hld_knt.value;
                					var on_deck_per_tr_knt      = formObject.on_deck_per_tr_knt.value;
                					var on_deck_per_row_knt     = formObject.on_deck_per_row_knt.value;
                					var bow_hgt                 = formObject.bow_hgt.value;
                					var trsm_hgt		    	= formObject.trsm_hgt.value;          
                					var shp_idx_scre            = formObject.shp_idx_scre.value;
                					var amp_tp_cd		        = combo5.Text;
                					
                					
                					var param = "?vsl_cd="+vsl_cd;
                						param = param+ "&vsl_slan_cd="+vsl_slan_cd;                                          
                						param = param+ "&pf_spd="+pf_spd;                
                						param = param+ "&avg_slip="+avg_slip;                
                						param = param+ "&pf_net_spd="+pf_net_spd;              
                						param = param+ "&pf_foc_qty="+pf_foc_qty;              
                						param = param+ "&avg_act_foc_qty="+avg_act_foc_qty;         
                						param = param+ "&ctcl_rpm_no="+ctcl_rpm_no; 	
                						param = param+ "&ctcl_to_rpm_no="+ctcl_to_rpm_no; 
                						param = param+ "&op_min_rpm_no="+op_min_rpm_no;           
                						param = param+ "&op_min_spd="+op_min_spd;              
                						param = param+ "&slw_stmng_flg="+slw_stmng_flg;           
                						param = param+ "&spr_slw_stmng_flg="+spr_slw_stmng_flg;       
                						param = param+ "&fuel_sav_eq_flg="+fuel_sav_eq_flg;         
                						param = param+ "&in_hld_per_tr_knt="+in_hld_per_tr_knt;	
                						param = param+ "&in_hld_per_row_knt="+in_hld_per_row_knt;       
                						param = param+ "&htch_cvr_in_hld_knt="+htch_cvr_in_hld_knt;     
                						param = param+ "&on_deck_per_tr_knt="+on_deck_per_tr_knt;      
                						param = param+ "&on_deck_per_row_knt="+on_deck_per_row_knt;     
                						param = param+ "&bow_hgt="+bow_hgt;                 
                						param = param+ "&trsm_hgt="+trsm_hgt;		
                						param = param+ "&shp_idx_scre="+shp_idx_scre;
                						param = param+ "&amp_tp_cd="+amp_tp_cd;

                					
                						if(sheetObject2.RowCount != 0){
                                	 	sheetObject2.Down2Excel(-1, true, false, true, "", sReportPageUrl+param);
                						}
                						if(sheetObject3.RowCount != 0){
                                	 	sheetObject3.SpeedDown2Excel(-1, true);
                						}
                                	 	if(sheetObject4.RowCount != 0){
                                	 	sheetObject4.Down2Excel(-1, true);
                                	 	}	
                                	 
                                 }
                                 break;
                            
                            case "btn_vsl_cd":
                                  //var sUrl = "/hanjin/VOP_VSK_0219.do";
                                  //ComOpenPopupWithTarget(sUrl, 460, 490, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", "0,0", true);
                                  var sUrl = "/hanjin/COM_ENS_0A1.do";
                                  ComOpenPopupWithTarget(sUrl, 618, 470, "vsl_cd:vsl_cd|vsl_eng_nm:vsl_eng_nm", '0,0,1,1,1,1,1,1,1,1', true);
                                 break;
                                 
                            case "btn_LoadExcel":
                                var sUrl = "/hanjin/VOP_VSK_9503.do";
                                ComOpenPopupWithTarget(sUrl, 900, 600, "", '0,0,1,1,1,1,1,1,1,1', true);
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
          if(document.form.strUsr_Auth.value == "authed"){
                    document.getElementById("rollDevided").style.display = 'block';
                    document.getElementById("rollDevided2").style.display = 'block';
          }
                    
          for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
          }

          for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
          }

          for(i=0;i<sheetObjects.length;i++){
        	  //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
          }

            combo1 = comboObjects[0]
            combo2 = comboObjects[1]
            combo3 = comboObjects[2]
            combo4 = comboObjects[3]
            combo5 = comboObjects[4]
            combo6 = comboObjects[5]
            comboCnt = comboObjects.length;
                     
            initControl();
            setComboList();
            
            ////::2007816::////
            gUsrAuth		= document.form.strUsr_Auth.value;
            gUsrAuthPerf	= document.form.strUsr_Auth_Perf.value;
            
    }

           /**
            * Combo 기본 설정 
            * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
            * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
            */ 
           function initCombo(comboObj, comboNo) {
                     var i=0;
              switch(comboObj.id) {
                 case "year":  
                     with(comboObj) {
                          comboObj.DropHeight=300;
                          comboObj.BackColor = "#CCFFFD";
                          for(var j=6; j<=20 ; j++)
                          {
                            if(j < 10 )
                                InsertItem(i++,  "200"+j,  "200"+j);
                            else
                                InsertItem(i++,  "20"+j,  "20"+j);
                          }
                     
                          //Code = document.form.nowYear.value;
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
                  style.height = 300;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;
                  
                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                  
                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msAll;
                  
                  //전체Edit 허용 여부 [선택, Default false]
                  Editable = false;
                  
                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo(1, 2, 20, 100);
                  
                  var HeadTitle1 = "1|1|1|1";
                  var headCount = ComCountHeadTitle(HeadTitle1);
                  
                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, true);
                  
                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(true, true, false, true, false,false)
                  
                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle1, true, true);
                  
                  var prefix="t1sheet1_";
                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtData,                200,      daLeft,             false,                prefix+"name1",             false,               "",                   dfNone,            0,                   true,                true);
                  InitDataProperty(0, cnt++ , dtData,                150,      daLeft,             false,                prefix+"val1",              false,               "",                   dfNone,            0,                   true,                true);
                  InitDataProperty(0, cnt++ , dtData,                200,      daLeft,             false,                prefix+"name2",             false,               "",                   dfNone,            0,                   true,                true);
                  InitDataProperty(0, cnt++ , dtData,                150,      daLeft,             false,                prefix+"val2",              false,               "",                   dfNone,            0,                   true,                true);
               }
               break;

            case "t3sheet1":
                with (sheetObj) {
                                                                                                        // 높이 설정
                  style.height = 185;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;
                  
                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                  
                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msHeaderOnly;
                  
                          //전체Edit 허용 여부 [선택, Default false]
                  Editable = false;
                  
                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo(1, 1, 3, 100);
                  
                  var HeadTitle1 = "ibflag |Lowest Sp'd Leg|Lowest Sp'd In P/F|Lowest Sp'd DIST";
                  var headCount = ComCountHeadTitle(HeadTitle1);
                  
                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                  InitColumnInfo(headCount, 0, 0, false);
                  
                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(true, true, false, true, false,false)
                  
                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle1, true);
                  
                  var prefix="t3sheet1_";
                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  InitDataProperty(0, cnt++ , dtHiddenStatus,        52,       daCenter,           true,                prefix+"ibflag");
                  InitDataProperty(0, cnt++ , dtData,                107,      daCenter,           true,                prefix+"low_port_pair",     false,               "",                   dfNone,                    0,                   true,                true);
                  InitDataProperty(0, cnt++ , dtData,                113,      daRight,            true,                prefix+"lnk_spd",         	false,               "",                   dfFloat,                   0,                   true,                true);
                  InitDataProperty(0, cnt++ , dtData,                105,      daRight,            true,                prefix+"lnk_dist",        	false,               "",                   dfInteger,                 0,                   true,                true);
                 
                  CountPosition = 0;
            }                                                                                                                                                                                    
                  break;    
                                          
            case "t3sheet2":
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
            	Editable = false;
            	
            	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            	InitRowInfo(1, 1, 3, 100);
            	
            	var HeadTitle1 = "ibflag |Bound|BSA|Load|Load Fact\n(3VVD)|AVG Ballast\n(3VVD)|Ave.Draft\n(3VVD)";
            	var headCount = ComCountHeadTitle(HeadTitle1);
            	
            	
            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            	InitColumnInfo(headCount, 0, 0, false);
            	
            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	InitHeadMode(true, true, false, true, false,false)
            	
            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            	InitHeadRow(0, HeadTitle1, true);

            	var prefix="t3sheet2_";
            	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++ , dtHiddenStatus,        52,       daCenter,           true,                prefix+"ibflag");
            	InitDataProperty(0, cnt++ , dtData,                52,       daCenter,           true,                prefix+"vsl_slan_dir_cd",            		false,               "",                   dfNone,                     0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                80,       daRight,            true,                prefix+"avg_bsa_capa_qty",         		false,               "",                   dfFloat,                    0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                80,       daRight,            true,                prefix+"avg_ttl_load_teu_qty",        	false,               "",                   dfFloat,                    0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                80,       daRight,            true,                prefix+"avg_load_fact_ratio",       		false,               "",                   dfFloat,                    0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                80,       daRight,            true,                prefix+"avg_last_port_blst_qty",         	false,               "",                   dfFloat,                    0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                80,       daRight,            true,                prefix+"avg_last_port_drft_qty",         	false,               "",                   dfFloat,                    0,                   true,                true);            	
            	
            	CountPosition = 0;
            
            }                                                                                                                                                                                    
            	break;                         
            	
            case "t3sheet3":
            	with (sheetObj) {
            	// 높이 설정
            	style.height = 180;
            	//전체 너비 설정
            	SheetWidth = mainTable.clientWidth;
            	
            	//Host정보 설정[필수][HostIp, Port, PagePath]
            	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            	
            	//전체Merge 종류 [선택, Default msNone]
            	MergeSheet = msHeaderOnly;
            	
            	//전체Edit 허용 여부 [선택, Default false]
            	Editable = false;
            	
            	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            	InitRowInfo(3, 1, 3, 100);
            	
            	var HeadTitle1 = "ibflag | Lane |Declared BSA|Declared BSA|Declared BSA|Declared BSA|Declared BSA|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Head Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul|Back Haul";
            	var HeadTitle2 = "ibflag | Lane |H/C Occupation|H/C Occupation|Wt/TEW|Wt/TEW| Wt |H/C Occupation|H/C Occupation|H/C Occupation|H/C Occupation|Wt/TEW\n(Actual)|Wt|H/C Occupation|H/C Occupation|H/C Occupation|H/C Occupation|Wt/TEW\n(Actual)|Wt";
            	var HeadTitle3 = "ibflag | Lane |Included|Excluded|Contract|Actual| Wt |Hold|Deck|Included|Excluded|Wt/TEW\n(Actual)|Wt|Hold|Deck|Included|Excluded|Wt/TEW\n(Actual)|Wt";
            	var headCount = ComCountHeadTitle(HeadTitle2);
            	
            	
            	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            	InitColumnInfo(headCount, 0, 0, false);
            	
            	// 해더에서 처리할 수 있는 각종 기능을 설정한다
            	InitHeadMode(true, true, false, true, false,false)
            	
            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            	InitHeadRow(0, HeadTitle1, true);
            	InitHeadRow(1, HeadTitle2, true);
            	InitHeadRow(2, HeadTitle3, true);
            	
            	var prefix="t3sheet3_";
            	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++ , dtHiddenStatus,        52,       daCenter,          true,                prefix+"ibflag");
            	InitDataProperty(0, cnt++ , dtData,                55,       daCenter,          true,                prefix+"vsl_slan_cd" ,       	false,               "",                   dfNone,                    0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"hc_incl_bsa_qty",    	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"hc_xcld_bsa_qty",    	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"ctrt_bsa_ut_wgt",    	false,               "",                   dfFloat,                   0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"act_bsa_ut_wgt",     	false,               "",                   dfFloat,                   0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                65,       daRight,           true,                prefix+"ttl_bsa_wgt",        	false,               "",                   dfFloat,                   0,                   true,                true);
            	
            	InitDataProperty(0, cnt++ , dtData,                42,       daRight,           true,                prefix+"hd_hul_hc_hld_qty"  ,  false,     	     	 "",        	       dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                42,       daRight,           true,                prefix+"hd_hul_hc_deck_qty",   false,     	     	 "",        	   	   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"hd_hul_hc_incl_qty", 	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"hd_hul_hc_xcld_qty", 	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"hd_hul_act_ut_wgt",  	false,               "",                   dfFloat,                   0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                65,       daRight,           true,                prefix+"hd_hul_ttl_wgt",     	false,               "",                   dfFloat,                   0,                   true,                true);
            	
            	InitDataProperty(0, cnt++ , dtData,                42,       daRight,           true,                prefix+"bak_hul_hc_hld_qty", 	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                42,       daRight,           true,                prefix+"bak_hul_hc_deck_qty",	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"bak_hul_hc_incl_qty",	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"bak_hul_hc_xcld_qty",	false,               "",                   dfInteger,                 0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                55,       daRight,           true,                prefix+"bak_hul_act_ut_wgt", 	false,               "",                   dfFloat,                   0,                   true,                true);
            	InitDataProperty(0, cnt++ , dtData,                65,       daRight,           true,                prefix+"bak_hul_ttl_wgt",    	false,               "",                   dfFloat,                   0,                   true,                true);            
            	CountPosition = 0;
            
            }                                                                                                                                                                                    
            	break;                                                                                                                                                                               
                                                                                                                                                                                                                               
            case "t10sheet1":                                                                                                                                                                                                  
                with (sheetObj) {                                                                                                                                                                                              
                  WaitImageVisible = false;                                                                                                                                                                                    
                }                                                                                                                                                                                                              
                break;                                                                                                                                                                                                         
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
                     sheetObj.ShowDebugMsg = false;
        switch(sAction) {
               case IBSEARCH:             //조회
                    if(validateForm(sheetObj,formObj,sAction))
                       if ( sheetObj.id == "t1sheet1"){
                          formObj.f_cmd.value = SEARCH01;
                          //sheetObj.RowMerge(1) = true;
                           var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t1sheet1_");
                           var sXml = sheetObj.GetSearchXml("VOP_VSK_0503GS.do", sParam);

                           //input BOX 값 채운다
                           if(ComGetEtcData(sXml, "vsl_cd") != "null" ){ 
                                     setXmlEtcDataToForm(formObj, sXml);
                           }else{
                                     setClearDataToForm(formObj, 1);
                           }
                           //정보를 t1Sheet에 채운다.
                           if(sXml.length>0){
                               //정보를 t1Sheet에 채운다.
                               sheetObj.DataRowMerge(0) = true;
                               sheetObj.DataRowMerge(1) = true;
                               sheetObj.LoadSearchXml(sXml);
                           }
                                                   
                        }else if ( sheetObj.id == "t3sheet2"){
                        formObj.f_cmd.value = SEARCH04;
                        var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet2_");
                        var sXml = sheetObj.GetSearchXml("VOP_VSK_0503GS.do", sParam);
                        
                        //input BOX 값 채운다
                        if(ComGetEtcData(sXml, "vsl_cd") != "null" ){ 
       			         	formObj.vsl_slan_cd.value       = ComGetEtcData(sXml, "vsl_slan_cd");  
       			         	formObj.pf_spd.value          	= ComAddComma(ComReplaceStr(ComGetEtcData(sXml, "pf_spd"), ",", ""));
       			         	formObj.avg_slip.value          = ComAddComma(ComReplaceStr(ComGetEtcData(sXml, "avg_slip"), ",", ""));
       			         	formObj.pf_net_spd.value        = ComAddComma(ComReplaceStr(ComGetEtcData(sXml, "pf_net_spd"), ",", ""));
       			         	formObj.pf_foc_qty.value        = ComAddComma(ComReplaceStr(ComGetEtcData(sXml, "pf_foc_qty"), ",", ""));
       			         	formObj.avg_act_foc_qty.value   = ComAddComma(ComReplaceStr(ComGetEtcData(sXml, "avg_act_foc_qty"), ",", ""));
       			         	
                        }else{
          			         formObj.vsl_slan_cd.value          = "";                  
                			 formObj.pf_spd.value               = "";
                			 formObj.avg_slip.value             = "";
                			 formObj.pf_net_spd.value           = "";
                			 formObj.pf_foc_qty.value           = "";
                			 formObj.avg_act_foc_qty.value      = "";
                        }
                        
                        //정보를 t3sheet2 에 채운다.
                        if(sXml.length>0){ 
                           sheetObj.LoadSearchXml(sXml);
                        }
                        
                        formObj.h_vsl_slan_cd.value = ComGetEtcData(sXml, "vsl_slan_cd");
                        formObj.h_pf_skd_tp_cd.value = ComGetEtcData(sXml, "pf_skd_tp_cd");
                        
                        
                     }else if( sheetObj.id == "t3sheet1"){
                         formObj.f_cmd.value = SEARCH05;
                         var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_");
                         var sXml = sheetObj.GetSearchXml("VOP_VSK_0503GS.do", sParam);
                         
                         //정보를 t3sheet1 에 채운다.
                         if(sXml.length>0){ 
                            sheetObj.LoadSearchXml(sXml);
                         }
                     }else if(sheetObj.id == "t3sheet3"){
                    	 formObj.f_cmd.value = SEARCH06; //Loadable 조회
                         var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet3_");
                         var sXml = sheetObj.GetSearchXml("VOP_VSK_0503GS.do", sParam);
                         
                         //정보를 t3sheet3 에 채운다.
                         if(sXml.length>0){ 
                            sheetObj.LoadSearchXml(sXml);
                         }
                     }
                     break;
                            
               case IBSAVE:
                   ComOpenWait(true);
                   formObj.f_cmd.value = MULTI01;
              	   var sXml = sheetObj.GetSaveXml("VOP_VSK_0503GS.do", FormQueryString(formObj));
                   ComOpenWait(false);
                   
                   break;  
            	   
               case SEARCH01:
                   formObj.f_cmd.value = SEARCH07;
                   var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet2_");
                   var sXml = sheetObj.GetSearchXml("VOP_VSK_0503GS.do", sParam);
                   
                   //input BOX 값 채운다
                   if(ComGetEtcData(sXml, "vsl_cd") != "null" ){ 
            			 formObj.ctcl_rpm_no.value          = ComAddComma(ComReplaceStr(ComGetEtcData(sXml, "ctcl_rpm_no"), ",", ""));
            			 formObj.ctcl_to_rpm_no.value          = ComAddComma(ComReplaceStr(ComGetEtcData(sXml, "ctcl_to_rpm_no"), ",", ""));
            			 formObj.op_min_rpm_no.value        = ComGetEtcData (sXml, "op_min_rpm_no");
            			 formObj.op_min_spd.value           = ComGetEtcData (sXml, "op_min_spd");
            			 formObj.vsl_lod_rto.value          = ComGetEtcData (sXml, "vsl_lod_rto");
            			 
              			 formObj.in_hld_per_tr_knt.value    = ComGetEtcData (sXml, "in_hld_per_tr_knt");
            			 formObj.in_hld_per_row_knt.value   = ComGetEtcData (sXml, "in_hld_per_row_knt");
            			 formObj.htch_cvr_in_hld_knt.value  = ComGetEtcData (sXml, "htch_cvr_in_hld_knt");
            			 formObj.on_deck_per_tr_knt.value   = ComGetEtcData (sXml, "on_deck_per_tr_knt");
            			 formObj.on_deck_per_row_knt.value  = ComGetEtcData (sXml, "on_deck_per_row_knt");
            			 formObj.bow_hgt.value              = ComGetEtcData (sXml, "bow_hgt");
            			 formObj.trsm_hgt.value             = ComGetEtcData (sXml, "trsm_hgt");
            			 formObj.shp_idx_scre.value         = ComGetEtcData (sXml, "shp_idx_scre");
            			 combo2.Text                        = ComGetEtcData (sXml, "slw_stmng_flg");
            			 combo3.Text                        = ComGetEtcData (sXml, "spr_slw_stmng_flg");
            			 combo4.Text                        = ComGetEtcData (sXml, "fuel_sav_eq_flg");
            			 var temp 							= ComGetEtcData (sXml, "amp_tp_cd");
            			 if(temp == "C")           			 combo5.Text    = "CNTR";
            			 else if(temp == "F")      			 combo5.Text    = "FIXED";
            			 else							     combo5.Text	= "N/A";
            			 

                   }else{
          			 	formObj.ctcl_rpm_no.value          = "";
          			 	formObj.ctcl_to_rpm_no.value       = "";
          			 	formObj.op_min_rpm_no.value        = "";
          			 	formObj.op_min_spd.value           = "";
          			 	formObj.vsl_lod_rto.value		   = ""; 
          			 	formObj.in_hld_per_tr_knt.value    = "";
          			 	formObj.in_hld_per_row_knt.value   = "";
          			 	formObj.htch_cvr_in_hld_knt.value  = "";
          			 	formObj.on_deck_per_tr_knt.value   = "";
          			 	formObj.on_deck_per_row_knt.value  = "";
          			 	formObj.bow_hgt.value              = "";
          			 	formObj.trsm_hgt.value             = "";
          			 	formObj.shp_idx_scre.value         = "";
          			 	combo2.Text                        = "";
          			 	combo3.Text                        = "";
          			 	combo4.Text                        = "";
          			 	combo5.Text                        = "";

             }
    			 
    			 break;
                   
               case IBCLEAR:               // 입력
                    //if(validateForm(sheetObj,formObj,sAction))
                    tmpVslCd = "";
                    if ( sheetObj.id == "t1sheet1")
                    {
                     formObj.vsl_eng_nm.value = "";
                     formObj.vsl_locl_nm.value = "";
                     setClearDataToForm(formObj, 0);
                     sheetObj.RemoveAll();
                    }else if (sheetObj.id == "t3sheet1")
                    {
                     formObj.vsl_cd.value = "";
                     formObj.vsl_eng_nm.value = "";
                     formObj.vsl_locl_nm.value = "";
                     formObj.upd_dt.value = "";
                     formObj.upd_usr_id.value = "";
                     
			         formObj.vsl_slan_cd.value          = "";                       
        			 formObj.pf_spd.value               = "";
        			 formObj.avg_slip.value             = "";
        			 formObj.pf_net_spd.value           = "";
        			 formObj.pf_foc_qty.value           = "";
        			 formObj.avg_act_foc_qty.value      = "";
        			 formObj.ctcl_rpm_no.value          = "";
        			 formObj.ctcl_to_rpm_no.value          = "";
        			 formObj.op_min_rpm_no.value        = "";
        			 formObj.op_min_spd.value           = "";

        			 formObj.in_hld_per_tr_knt.value    = "";
        			 formObj.in_hld_per_row_knt.value   = "";
        			 formObj.htch_cvr_in_hld_knt.value  = "";
        			 formObj.on_deck_per_tr_knt.value   = "";
        			 formObj.on_deck_per_row_knt.value  = "";
        			 formObj.bow_hgt.value              = "";
        			 formObj.trsm_hgt.value             = "";
        			 formObj.shp_idx_scre.value         = "";
        			 combo2.Index                       = 0;
        			 combo3.Index                       = 1;
        			 combo4.Index                       = 0;
        			 combo5.Index                       = 0;

                     
                     comboObjects[0].RemoveAll();
//                     comboObjects[4].RemoveAll();

                     initCombo(comboObjects[0], 1);
                     sheetObj.RemoveAll();
                     sheetObjects[2].RemoveAll();
                     sheetObjects[3].RemoveAll();
                     }
                     break;
        }
    }

           function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
                     if(sheetObj.RowCount > 0){
                        sheetObj.CellAlign(1,0) = daCenter;
                        sheetObj.CellAlign(1,1) = daCenter;
                        sheetObj.CellAlign(1,2) = daCenter;
                        sheetObj.CellAlign(1,3) = daCenter;
                        
                        sheetObj.CellAlign(2,0) = daLeft;
                        sheetObj.CellAlign(2,1) = daLeft;
                        sheetObj.CellAlign(2,2) = daRight;
                        sheetObj.CellAlign(2,3) = daRight;
                        
                        sheetObj.CellFont("FontSize", 1,0) = 15;
                        sheetObj.CellFont("FontBold", 1,0) = true;             
                        
                        sheetObj.CellBackColor(1,0) = sheetObj.RgbColor(204, 255, 204);
                        sheetObj.CellBackColor(1,1) = sheetObj.RgbColor(204, 255, 204);
                        sheetObj.CellBackColor(1,2) = sheetObj.RgbColor(204, 255, 204);
                        sheetObj.CellBackColor(1,3) = sheetObj.RgbColor(204, 255, 204);
                        
                        for(var i=3 ; i<39 ; i++){
                            for(var j=0 ; j<4 ; j++){
                               sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(255, 255, 153);
                                }
                        }
                     }
           }    
    
    /**
     * EtcData의 값을 Form에 셋팅한다.
     */
    function setXmlEtcDataToForm(formObj, sXml) {

          var iMatchCnt = 0;
          try {
                    var elements = formObj.elements;

                    // 사용가능한 HTML컨트롤을 배열로 생성한다.
                    for ( var i = 0; i < elements.length; i++) {
                               var sValue, eNmPrefix, eName;
                               if (elements[i].classid == undefined) {
                                          eName = elements[i].name;         // Html오브젝트인경우
                               } else {
                                          eName = elements[i].id;   // IBMultiCombo인경우
                               }
                               
                               //예외항목들
                               if (eName == "")
                                          continue;
                               
                               //set_XXXX Hidden 오브젝트인 경우 'set_' Prefix를 Trim후 값 가져오기
                               eNmPrefix = eName.substring(0,4);
                               if(eNmPrefix == 'set_') eName = eName.substring(4,eName.length);

                               sValue = ComGetEtcData(sXml, eName);
                               
                        // 입력값에 천단위 구분자(",")를 포함
                               if (eName == "cntr_dzn_capa" || eName == "cntr_op_capa" || eName == "cntr_pnm_capa" || eName == "cntr_vsl_clss_capa"
                                || eName == "dpl_capa" || eName == "dwt_wgt" || eName == "lgt_shp_tong_wgt" 
                                || eName == "grs_rgst_tong_wgt" || eName == "pnm_gt_wgt" || eName == "suz_gt_wgt" || eName == "net_rgst_tong_wgt" || eName == "pnm_net_tong_wgt" || eName == "suz_net_tong_wgt" || eName =="madn_voy_suz_net_tong_wgt"
                                || eName == "foil_capa" || eName == "doil_capa" || eName == "frsh_wtr_capa" || eName == "blst_tnk_capa" || eName == "foil_csm" || eName == "doil_csm" || eName == "frsh_wtr_csm"
                                || eName == "mn_eng_bhp_pwr" || eName == "mn_eng_rpm_pwr" || eName == "gnr_bhp_pwr" || eName == "gnr_rpm_pwr" || eName == "bwthst_bhp_pwr" || eName == "bwthst_rpm_pwr"
                                || eName == "n1st_hir_rt_n1st_amt"|| eName == "n1st_hir_rt_n2nd_amt" || eName == "n2nd_hir_rt_n1st_amt"|| eName == "n2nd_hir_rt_n2nd_amt" 
                                || eName == "pf_foc_qty" || eName == "avg_act_foc_qty")
                                 sValue = ComAddComma(sValue);                                 
                               
                               // 해당이름의 EtcData가 없는 경우 다음 항목 찾기
                               if (sValue == undefined)
                                          continue;

                               // radio인 경우 같은이름으로 여러개 있는 경우
                               if (elements[i].type == "radio") {
                                          var eRadio = document.all[eName];
                                          // 첫번째 radio만 체크하고 나머지 건너뛰기
                                          if (eRadio.length > 1)
                                                    i += (eRadio.length - 1);

                                          if (sValue != undefined) {
                                                    ComSetObjValue(eRadio, sValue);
                                                    iMatchCnt++;
                                          }
                                          continue;
                               }

                               // radio인 경우를 제외하고 모두 여기서 값이 설정된다.
                               ComSetObjValue(elements[i], sValue);

                               iMatchCnt++;
                    }// for
                    
                    // Main Engine이 KW의 단위를 쓰는 경우가 존재하여, BHP/KW 단위를 함께 표기한다.
                    if(formObj.mn_eng_kw_pwr.value>0){
                               formObj.mn_eng_bhp_pwr.value = ComAddComma(formObj.mn_eng_kw_pwr.value) + " [KW]";
                    }else{
                               formObj.mn_eng_bhp_pwr.value = formObj.mn_eng_bhp_pwr.value + " [BHP]";
                    }
                    if(formObj.gnr_bhp_pwr.value != ""){
                               formObj.gnr_bhp_pwr.value = formObj.gnr_bhp_pwr.value + " [BHP]";
                    }
                    if(formObj.bwthst_bhp_pwr.value != ""){
                               formObj.bwthst_bhp_pwr.value = formObj.bwthst_bhp_pwr.value + " [BHP]";
                    }
          } catch (err) {
                    ComFuncErrMsg(err.message);
          }

          return iMatchCnt;
    }    
    
    
    /**
     * EtcData의 값을 Form에 셋팅한다.
     */
    function setClearDataToForm(formObj, exCnt) {

          var iMatchCnt = 0;
          try {
                    var elements = formObj.elements;

                    // 사용가능한 HTML컨트롤을 배열로 생성한다.
                    for ( var i = 0; i < elements.length; i++) {
                               var sValue, eNmPrefix, eName;
                               if (elements[i].classid == undefined) {
                                          eName = elements[i].name;         // Html오브젝트인경우
                               } else {
                                          eName = elements[i].id;   // IBMultiCombo인경우
                               }

                               //예외항목들
                               if (eName=="" || eName=="vsl_eng_nm" || eName=="inc_del_vsl" || eName=="vsl_locl_nm")                          
                            	   continue;
                               
                               //exCnt 예외 항목 1 보다 크면 적용
                               if ( exCnt == 1 ){
                              if (eName == "vsl_cd"){
                                         continue;
                              }
                               }else if( exCnt == 2 ){
                              //exCnt 예외 항목 2 보다 크면 적용
                                        if (eName == "vsl_cd" || eName == "year"){
                                        continue;                                         
                              }
                               }
                                          
                               
                               // radio인 경우 같은이름으로 여러개 있는 경우
                               if (elements[i].type == "radio") {
                                          var eRadio = document.all[eName];
                                          // 첫번째 radio만 체크하고 나머지 건너뛰기
                                          if (eRadio.length > 1)
                                                    i += (eRadio.length - 1);

                                          if (sValue != undefined) {
                                                    ComSetObjValue(eRadio, sValue);
                                                    iMatchCnt++;
                                          }
                                          continue;
                               }

                               // radio인 경우를 제외하고 모두 여기서 값이 설정된다.
                               ComSetObjValue(elements[i], "");

                               iMatchCnt++;
                    }// for
          } catch (err) {
                    ComFuncErrMsg(err.message);
          }

          return iMatchCnt;
    } 
    
    /* initControl() */
    function initControl() {
          axon_event.addListenerFormat('keypress', 'obj_keypress', form);
          axon_event.addListenerFormat('keyup', 'obj_keyup', form);
          axon_event.addListenerForm('blur', 'obj_deactivate', form); 
  	   	  axon_event.addListenerForm('keydown', 'obj_keydown', form); 
  	   	  axon_event.addListenerForm('activate', "obj_activate", form);
  	   	  axon_event.addListenerForm('blur', 'obj_blur', form);
  	   	  
    }
    
    function obj_mousedown(){
                     document.getElementById("span1").title = 'ererer';
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
          if(obj.name == null) return;
           
          switch(obj.name) {
              case "vsl_cd":
                  ComKeyOnlyAlphabet('uppernum');
                  break;
                  
              case "ctcl_rpm_no":
              case "op_min_rpm_no":
              case "op_min_spd":
              case "in_hld_per_tr_knt":
              case "in_hld_per_row_knt":
              case "htch_cvr_in_hld_knt":
              case "on_deck_per_tr_knt":
              case "on_deck_per_row_knt":
              case "bow_hgt":
              case "trsm_hgt":
              case "shp_idx_scre":
            	  VskKeyOnlyNumber(obj, ".");
                  break;  
            	  
          }
    }    
    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 이혜민
     * @version 2012.10.04
     */ 
     function obj_keyup() {
          var formObj = document.form;
          var obj = event.srcElement;
          var val = obj.value;

          switch (obj.name) {
          case "vsl_cd":
                    
                    if (val == "") {
                               formObj.vsl_eng_nm.value = "";
                               formObj.vsl_locl_nm.value = "";
                               tmpVslCd = "";
                    }
                    if (!obj || val == "" || ComChkLen(val, 4) != 2) {
                               break;
                    }

                    var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
                    if(keyValue != 13 && tmpVslCd != formObj.vsl_cd.value) {
                               getVslName(formObj);
                               tmpVslCd = formObj.vsl_cd.value;
                    }else{
                               VskKeyEnter();
                    }
                    break;
                    
          case "ctcl_rpm_no":
        	  document.form.ctcl_rpm_no.value = ComAddComma(ComReplaceStr(document.form.ctcl_rpm_no, ",", ""));
        	  break;
        	  
          case "ctcl_to_rpm_no":
        	  document.form.ctcl_to_rpm_no.value = ComAddComma(ComReplaceStr(document.form.ctcl_to_rpm_no, ",", ""));
        	  break;
        	  
          case "op_min_rpm_no":
          case "op_min_spd":
          case "in_hld_per_tr_knt":
          case "in_hld_per_row_knt":
          case "htch_cvr_in_hld_knt":
          case "on_deck_per_tr_knt":
          case "on_deck_per_row_knt":
          case "bow_hgt":
          case "trsm_hgt":
          case "shp_idx_scre":
                VskKeyNumberPointVaild(obj);
                break;
          }
    }

   /**
    * GET Vessel Code Full Name
    */
    function getVslName(){
          var formObj = document.form;
          obj = event.srcElement;
           
          switch(obj.name) {
              case "vsl_cd":
                    
                  if(formObj.vsl_cd.value.length == 4 ){
                   formObj.vsl_eng_nm.value = "";
                   formObj.vsl_locl_nm.value = "";
                   setClearDataToForm(formObj, 2);

                   combo2.Index = 0;
                   combo3.Index = 1;
                   combo4.Index = 0;
                   combo5.Index = 0;
                   
                   sheetObjects[0].RemoveAll();
                   sheetObjects[1].RemoveAll();
                   sheetObjects[2].RemoveAll();
                   sheetObjects[3].RemoveAll();
                                          
                   //vsl_locl_nm을 함께 가져오기 위해, 로직 수정
                   formObj.f_cmd.value = SEARCH02;
                   var vslXml = sheetObjects[2].GetSearchXml("VOP_VSK_0503GS.do", FormQueryString(formObj));
                                                     
                   var sVslEngNm = ComGetEtcData(vslXml, "vsl_eng_nm");
                   var sVslLoclNm = ComGetEtcData(vslXml, "vsl_locl_nm");

                   if(isNull(sVslEngNm)){
                      formObj.vsl_cd.value = "";
                      formObj.vsl_eng_nm.value = "";
                      formObj.vsl_locl_nm.value = "";
                      ComAlertFocus(formObj.vsl_cd, ComGetMsg('VSK50023'));
                   }else{
                     formObj.vsl_eng_nm.value = sVslEngNm;
                     formObj.vsl_locl_nm.value = sVslLoclNm;
                     }
                  }
                  break;
          }
    }
    
    //업무 자바스크립트 Onblur 이벤트 처리
    function obj_deactivate(){
          var elementObj = event.srcElement;
                     var formObj = document.form;
                     
        //입력Validation 확인 및 마스킹 처리
        //ComChkObjValid(event.srcElement);
          switch(elementObj.name){                     
                    case "vsl_cd":
                               if(!isNull(elementObj.value)){
                                          if(elementObj.maxLength != elementObj.value.length){
                                             ComShowCodeMessage("VSK50022");
                                             ComAlertFocus(formObj.vsl_cd, "");
                                          }
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
     * Combo Object를 배열로 등록
     */    
    function setComboObject(combo_obj){
             comboObjects[comboCnt++] = combo_obj;
           }
 
           
           
    function setComboList(formObj) {    
        	
       		var combo2Str = ["Y","N"];		// Slow Steaming
    		var combo2Val = ["Y","N"];
    			combo2.RemoveAll();
    			for(var i=0 ; i < combo2Str.length ; i++){
    				combo2.InsertItem(i,combo2Str[i],combo2Val[i]);
    			}
    			combo2.DropHeight = 100;
    			combo2.SetColWidth("50");
    			combo2.Index = 0;
    			
    		var combo3Str = ["Y","N"];		// Super Slow steaming
    		var combo3Val = ["Y","N"];
    			combo3.RemoveAll();
    			for(var i=0 ; i < combo3Str.length ; i++){
    				combo3.InsertItem(i,combo3Str[i],combo3Val[i]);
    			}
    			combo3.DropHeight = 100;
    			combo3.SetColWidth("50");
    			combo3.Index = 1;
    			
    		var combo4Str = ["Y","N"];		// Fuel Saving Equip
    		var combo4Val = ["Y","N"];
    			combo4.RemoveAll();
    			for(var i=0 ; i < combo4Str.length ; i++){
    				combo4.InsertItem(i,combo4Str[i],combo4Val[i]);
    			}
    			combo4.DropHeight = 100;
    			combo4.SetColWidth("50");
    			combo4.Index = 0;
    			
    		var combo5Str = ["N/A","CNTR","FIXED"];		// Fuel Saving Equip
    		var combo5Val = [" ","C","F"];
    			combo5.RemoveAll();
    			for(var i=0 ; i < combo5Str.length ; i++){
    				combo5.InsertItem(i,combo5Str[i],combo5Val[i]);
    			}
    			combo5.DropHeight = 100;
    			combo5.SetColWidth("80");
    			combo5.Index = 0;
    			
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
                    InsertTab( cnt++ , "Particular I" , -1 );
                    InsertTab( cnt++ , "Particular II" , -1 );
                    InsertTab( cnt++ , "Performance" , -1 );
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
                    //formObject.vsl_cd.value = "";
                    //formObject.vsl_eng_nm.value = "";
                    formObject.vsl_cd.className = "input1";
                    comboObjects[0].RemoveAll();
                    comboObjects[0].Enable = false;
                    initCombo(comboObjects[0], 1);
                    
                    //::jsk::2014-03-20:://
                    ComBtnEnable('btn_Save');
                    ComBtnEnable('btn_LoadExcel');                    	

                    break;
                    
                    case 1:
                    //formObject.vsl_cd.value = "";
                    //formObject.vsl_eng_nm.value = "";
                    formObject.vsl_cd.className = "input1";
                    comboObjects[0].RemoveAll();
                    comboObjects[0].Enable = false;
                    initCombo(comboObjects[0], 1);
                    
                    //::jsk::2014-03-20:://
                    ComBtnEnable('btn_Save');
                    ComBtnEnable('btn_LoadExcel');                  
                    
                    break;
                    
                    case 2:
                    //formObject.vsl_cd.value = "";
                    //formObject.vsl_eng_nm.value = "";
                    formObject.vsl_cd.className = "input1";
                    comboObjects[0].RemoveAll();
                    comboObjects[0].Enable = false;
                    initCombo(comboObjects[0], 1);     
                    
                    //::jsk::2014-03-20:://
                    ////if(document.form.strUsr_Auth_Perf.value != "authed"){
                    if(gUsrAuthPerf != "authed"){	
                        ComBtnDisable('btn_Save');
                        ComBtnDisable('btn_LoadExcel');
                    }else{
                        ComBtnEnable('btn_Save');
                        ComBtnEnable('btn_LoadExcel');                    	
                    }
                    
                    break;
        }
               
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        if (sheetObj.id == "t1sheet1" || sheetObj.id == "t1sheet2" || sheetObj.id == "t3sheet1" || sheetObj.id == "t3sheet2" || sheetObj.id == "t3sheet3")
        {
                    if(ComIsEmpty(formObj.vsl_cd.value))
                    {
                        if(sheetObj.id == "t3sheet2" || sheetObj.id == "t3sheet3"){ 
                           return false;
                        }else{
                      	  ComShowCodeMessage('VSK50013');
                          ComAlertFocus(formObj.vsl_cd, "");
                          return false;
                        }
                    }
        	}
        }

        return true;
    }
    
//           function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
//                     document.form.upd_dt.value = sheetObj.CellValue(NewRow, "t3sheet1_upd_dt");
//                     document.form.upd_usr_id.value = sheetObj.CellValue(NewRow, "t3sheet1_upd_usr_id");
//           }
//           
//           function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
//                     if(sheetObj.RowCount > 0){
//                    document.form.upd_dt.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_dt");
//                    document.form.upd_usr_id.value = sheetObj.CellValue(sheetObj.SelectRow, "t3sheet1_upd_usr_id");
//                     }
//           } 

    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        return true;
        }
        else{
        return false;
        }
    }     
    
    
    function msgset(strmsg, value){
                     document.getElementById(strmsg).title = value;
           }
    

           /* 개발자 작업  끝 */
