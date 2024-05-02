/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1083.js
*@FileTitle : B/L Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESM_BKG_1083 : business script for ESM_BKG_1083 
     */
    function ESM_BKG_1083() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    


// Common global variable

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1; 

var sheetObjects = new Array();
var sheetCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
    function processButtonClick(){
         /* */
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn_excel":
					sheetObject.SpeedDown2Excel(-1);
				break;  

                case "btn_close":
					window.close();
                break;



            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("not available");
    		} else {
    			alert(e);
    		}
    	}
    }

    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;
			
    }



    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

    }


  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    // setting height
                    style.height = 450;
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[mandatory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind [optional, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //Edit kind [optional, Default false]
                    Editable = true;

                    //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(27, 0, 0, true);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq|B/L NO|VVD|POR|POL|POD|DEL|S.Rep|Shipper|Shipper Name|Load|CM|CMPB|D-1|D-2|D-3|D-4|D-5|D-6|D-7|D-8|D-9|D-10|D-11|D-12|D-13|D-14";

                    //Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,	40,		daCenter,	false,		"seq");		
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	true,		"bl_no",		false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	true,		"vvd",			false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"por_cd",		false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"pol_cd",		false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"pod_cd",		false,	"",      dfNone,	0,		true,		true);
			
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		"del_cd",		false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	50,		daCenter,	true,		"ob_srep_cd",	false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	70,		daLeft,		true,		"cust_cd",		false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,	130,	daLeft,		true,		"cust_nm",		false,	"",      dfNone,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	70,		daRight,	false,		"load",			true,	"",      dfFloat,	1,		true,		true);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	70,		daRight,	false,		"cm",			true,	"",      dfInteger,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	70,		daRight,	false,		"cmpb",			true,	"",      dfInteger,	0,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_1",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_2",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_3",			false,	"",      dfFloat,	1,		true,		true);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_4",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_5",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_6",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_7",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_8",			false,	"",      dfFloat,	1,		true,		true);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_9",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_10",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_11",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_12",			false,	"",      dfFloat,	1,		true,		true);
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_13",			false,	"",      dfFloat,	1,		true,		true);
			
					InitDataProperty(0, cnt++ , dtAutoSum,	50,		daRight,	false,		"d_14",			false,	"",      dfFloat,	1,		true,		true);
													
					//CountPosition = 0;															
               }
                break;

        }
    }

  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

          case IBSEARCH:      //retrieve
					
			sheetObj.WaitImageVisible = false;
    		ComOpenWait(true);
    										
	    	formObj.f_cmd.value = SEARCH;   
	    	sheetObj.DoSearch("ESM_BKG_1083GS.do",FormQueryString(formObj));
	    	
	    	ComOpenWait(false);	    	
          break;
        }
    }
    // handling event after retrieving
  	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
  		var formObj = document.form;
  		
  		with(sheetObj){
  			if (RowCount > 0){
			    SumText(0, "seq") = "";
				SumText(0, "cust_nm") = "TOTAL";
				if(SumValue(0,"load") > 0){
					SumValue(0,"cmpb") = CutDecimalPoint(SumValue(0,"cm") /SumValue(0,"load"),0) ;
				}
  			}
  		}
  	}	

