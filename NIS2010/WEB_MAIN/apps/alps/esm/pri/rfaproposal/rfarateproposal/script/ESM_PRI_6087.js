/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_6087.js
*@FileTitle : RFA Proposal/Amendment Surcharge View All
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.21 송민석
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
     * @class ESM_PRI_6087 : ESM_PRI_6087 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6087() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;
 
    var ACCESS_TEXT = "[Access date: {?msg1}]";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /** 
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     *
     * @return 없음
     */ 
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject1 = sheetObjects[0];

             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                	if (getButtonTable(srcName).disabled) {
                		return false;
                	}
                }   
               switch(srcName) {

                    case "btn2_Retrieve":
                   	 doActionIBSheet(sheetObject1,document.form,IBSEARCH);
                        break; 
                    case "btn1_Close":
    					 self.close();
                        break; 
            		case "view_items" :
            			changeColHidden(sheetObject1, formObject.view_items );
            			changeFrozenCol(sheetObject1, formObject.view_items );
            			
           			break;
             		case "btn2_DownExcel":
             			ComPriShowDialogExcel(sheetObject1,ComGetMsg("PRI03002"));
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
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         *
         * @param  {object}   sheet_obj 필수, sheet Object
         * @return 없음
         */ 
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;
    			
        }



        /** 
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * 
         * @return 없음
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            

           ComOpenWait(true);
           changeColHidden(sheetObjects[0], document.form.view_items )
           changeFrozenCol( sheetObjects[0], document.form.view_items  );
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	   
    	   ComOpenWait(false);
        }
         
      

 
 

        /** 
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {String} sheetNo 필수, sheet의 ID
         * @return 없음
         */ 
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
            sheetObj.WaitImageVisible = false;
            switch(sheetNo) {
                 case 1:      //sheet1 init
                    with (sheetObj) {

                        // 높이 설정
                        style.height = 302;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msPrevColumnMerge + msHeaderOnly;

                       //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo(2, 1, 15, 100);

                        var HeadTitle1 = "|Seq.|CMDT\nGroup|Actual\nCutomer|Commodity\nNote|rout_seq|Route\nNote"
                        				+"|Contract Route|Contract Route|Contract Route|Contract Route|Per|CGO\nType|Cur.|Rate"
                        				+"|Applicable Route\n(For est.surcharge)|Applicable Route\n(For est.surcharge)|Applicable Route\n(For est.surcharge)|Applicable Route\n(For est.surcharge)|Estimated\nSurcharge\n(USD)"
                        				+"|Surcharge|Surcharge|Surcharge|Amount|Amount|Amount";
                        				
    					 var HeadTitle2 = "|Seq.|CMDT\nGroup|Actual\nCutomer|Commodity\nNote|rout_seq|Route\nNote"
    						 			+"|Origin|O.VIA|D.VIA|Dest.|Per|CGO\nType|Cur.|Rate"
    						 			+"|POR|POL|POD|DEL|Estimated\nSurcharge\n(USD)"
    						 			+"|Code|Per|Cur.|Tariff|Contract|(USD)";

    					 var headCount = ComCountHeadTitle(HeadTitle1);
                        
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(headCount, 0, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false)

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
    					InitHeadRow(1, HeadTitle2, true);
    					
                        //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD,	CALCULOGIC, DATAFORMAT,		POINTCOUNT, UPDATEEDIT,		INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,   true,   	"ibflag");
                        
    					InitDataProperty(0, cnt++ , dtData,    			30,   	daCenter,  	true,		"seq",   			false,          "",      dfNone,      		0,			false,       true);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"prc_cmdt_def_nm",   			false,          "",      dfNone,      		0,			false,       false);

    					// Actual Customer
    					InitDataProperty(0, cnt++ , dtData,    			55,   	daLeft,  	true,		"act_cust_nm",   			false,          "",      dfNone,      		0,			false,       false);

    					// CNote 시작
    					InitDataProperty(0, cnt++ , dtData,    			75,   	daLeft,  	true,		"cnote_ctnt",   			false,          "",      dfNone,      		0,			false,       false);
    					// CNote 끝
    					//rnote 가 같을경우 merge 방지
    					InitDataProperty(0, cnt++ , dtHidden,    			65,   	daLeft,  	true,		"rout_seq",   			false,          "",      dfNone,      		0,			false,       false);
    					// RNote 시작
    					InitDataProperty(0, cnt++ , dtData,    			75,   	daLeft,  	true,		"rnote_ctnt",   			false,          "",      dfNone,      		0,			false,       false);
    					// RNote 끝
    					//Contract Route 시작
    					InitDataProperty(0, cnt++ , dtData,    			65,   	daLeft,  	true,		"org_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"org_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"dest_rout_via_port_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			65,   	daLeft,  	true,		"dest_rout_pnt_loc_def_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					//Contract Route 끝
    					//RATE 정보 시작
    					InitDataProperty(0, cnt++ , dtData,    			35,   	daCenter,  	true,		"rat_ut_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			35,   	daCenter,  	true,		"prc_cgo_tp_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			35,   	daCenter,  	true,		"rate_curr_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		60,   	daRight,  	true,		"frt_rt_amt",   			false,          "",      dfNullFloat,      	2,			false,       false);
    					//RATE 정보 끝
    					//Applicable Route(For est.surcharge) 시작
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"por_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"pol_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"pod_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    			50,   	daLeft,  	true,		"del_cd",   			false,          "",      dfNone,      		0,			false,       false);
    					//Applicable Route(For est.surcharge) 끝
    					//Estimated Surcharge
    					InitDataProperty(0, cnt++ , dtData,    		70,   	daRight,  	true,		"tot_surcharge",   			false,          "",      dfNullFloat,      	2,			false,       false);
    					
    					//Surcharge 시작
    					InitDataProperty(0, cnt++ , dtData,    		35,   	daCenter,  	true,		"chg_cd",   			false,          "",      dfNone,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		35,   	daCenter,  	true,		"bkg_rat_ut_cd",   			false,          "",      dfNone,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		35,   	daCenter,  	true,		"surcharge_curr_cd",   			false,          "",      dfNone,      	2,			false,       false);
    					//Surcharge 끝
    					//Amount 시작
    					InitDataProperty(0, cnt++ , dtData,    		65,   	daRight,  	true,		"trf_scg_amt",   			false,          "",      dfNullFloat,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		65,   	daRight,  	true,		"adj_scg_amt",   			false,          "",      dfNullFloat,      	2,			false,       false);
    					InitDataProperty(0, cnt++ , dtData,    		65,   	daRight,  	true,		"adj_scg_usd_amt",   			false,          "",      dfNullFloat,      	2,			false,       false);
    					//Amount 끝
    					
    					 
    					CountPosition = 0;
    					
    					//풍선도움말
    					ToolTipOption="balloon:true;width:320;icon:1";
    					FrozenCols = 15;
    					//Ellipsis = true;
    					WordWrap  = true;
    					SelectHighLight   = false;


                   }
                   break;
            }
        }

        /** 
         * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {object} formObj 필수, html document form Object
         * @param {int} sAction 필수, action의 구분
         * @return 없음
         */ 
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

    			case IBSEARCH:      //조회
    			
    				ComOpenWait(true);
	   				if(validateForm(sheetObj,formObj,sAction)){}
	   		        formObj.f_cmd.value = SEARCH;
	   		        sheetObj.DoSearch("ESM_PRI_6087GS.do", FormQueryString(formObj));

	   		        ComOpenWait(false);
	   		        
	   	            break;

            }
        }

        /** 
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         * <br><b>Example :</b>
         * <pre>
         *      if (!validateForm(sheetObj,document.form,sAction)) {
         *          return false;
         *       }
         * </pre>
         * @param {object} sheetObj 필수, sheet Object
         * @param {object} formObj 필수, html document form Object
         * @param {int} sAction 필수, action의 구분
         *
         * @return boolean, true: 유효, false: 비유효
         */  
        function validateForm(sheetObj,formObj,sAction){


            return true;
        }
         
         
         /**  
         *   Item의 값에 따라 sheet의 특정필드들을 가변적으로 보여준다.<BR>
         *  
         * <br><b>Example :</b>
         * <pre>
         *   changeColHidden(sheetObjects[0], formObj.frm_summary_items);
         * </pre>
         * 
         * @param {object} sheetObj 필수, sheet Object
         * @param {object} checkObj 필수, View Items Checkbox Object
         * 
         * @return 없음
         */    
         function changeColHidden(sheetObj, checkObj ){
      	   var formObj = document.form;
      	   var colList = new Array( );
      	   colList["AR"] = "por_cd|pol_cd|pod_cd|del_cd"; //Applicable Route
      	   colList["CN"] = "cnote_ctnt"; //Commodity Note
      	   colList["RN"] = "rnote_ctnt";//Route Note
 
	     
    	   if(checkObj[0].checked){
    		   showHideColumns(sheetObj,colList["AR"],false);
    	   }else{
    		   showHideColumns(sheetObj,colList["AR"],true);
    	   }
    	   if(checkObj[1].checked){
    		   showHideColumns(sheetObj,colList["CN"],false);
    	   }else{
    		   showHideColumns(sheetObj,colList["CN"],true);
    	   }
    	   if(checkObj[2].checked){
    		   showHideColumns(sheetObj,colList["RN"],false);
    	   }else{
    		   showHideColumns(sheetObj,colList["RN"],true);
    	   }    	   
  
 
         }
         
         /**  
         *   Item의 값에 따라 sheet의 고정틀 위치를 가변적으로 보여준다.<BR>
         *  
         * <br><b>Example :</b>
         * <pre>
         *   changeFrozenCol(sheetObjects[0], formObj.frm_summary_items);
         * </pre>
         * 
         * @param {object} sheetObj 필수, sheet Object
         * @param {object} checkObj 필수, View Items Checkbox Object
         * 
         * @return 없음
         */    
		function changeFrozenCol(sheetObj, checkObj ){
			var formObj = document.form;
					     
			
				
			if(checkObj[1].checked || checkObj[2].checked ){
				sheetObj.FrozenCols = sheetObj.SaveNameCol("act_cust_nm")+1;
			}else if(checkObj[0].checked){
				sheetObj.FrozenCols = sheetObj.SaveNameCol("frt_rt_amt")+1;
			}    	   
			  
		 
		}
         /**  
          *  '|'로 연결된 column명 list에 해당하는 sheet의 column들을<BR>
          *  flg값에 따라 보여주거나 숨긴다.<BR>
          *  
          * <br><b>Example :</b>
          * <pre>
          *   showHideColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt",false ); // 해당 컬럼들을 보여준다.
          *   showHideColumns(sheetObject1, "cust_tp_cd|prop_apro_ofc_cd|respb_srep_cd|ctrt_eff_dt|ctrt_exp_dt",true ); // 해당 컬럼들을 숨긴다.
          * </pre>
          * 
          * @param {object} sheetObj 필수, sheet Object
          * @param {string} strColList 필수, 숨기고 싶은 column을 '|'로 연결한 string
          * @param {boolean} flg 필수, true: 숨김, false : 보여줌
          * @return 없음
          */     
          function showHideColumns(sheetObj, strColList,flg ){
       	   if( strColList == undefined) return;
       	   if( strColList == "" ) return;
       	   var arrColList = strColList.split("|");
       	   for( var i = 0 ; i < arrColList.length ; i ++){
       		   sheetObj.ColHidden(arrColList[i]) = flg;
       	   }
          }
         
            
     	/**
     	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     	 * <br><b>Example :</b>
     	 * <pre>
     	 * 
     	 * </pre>
     	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     	 * @return 없음
     	 * @author 송민석
     	 * @version 2010.04.20
     	 */
         function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        	 
             if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            	 var access_date = sheetObj.EtcData("access_date");

            	 var msg = "";
            	 if(  access_date != "" ){
            		 msg = ComReplaceStr( ComReplaceStr(ACCESS_TEXT, "{?msg1}", access_date));
            	 }
            	 document.getElementById("access_text").innerText = msg;
            	 changeCellColor(sheetObj);
             }
         }
     	 function changeCellColor(sheetObj){
             with(sheetObj){
            	 var pink =  RgbColor(250,188,250);// 분홍 계열
            	 var yellow = RgbColor(252,247,150);// 노랑계열
	      			//CNote, Rnote, Surcharge Code, Contract Amount
	      			ColBackColor("cnote_ctnt") = pink;
	      			ColBackColor("rnote_ctnt") = pink;
	      			ColBackColor("chg_cd") = pink;
	      			ColBackColor("adj_scg_amt") = pink;
	      			
	      			
	      			//Rate, Estimated Surcharge
	      			ColBackColor("frt_rt_amt") = yellow;
	      			ColBackColor("tot_surcharge") = yellow;
             }
     	 }
                  

	/* 개발자 작업  끝 */