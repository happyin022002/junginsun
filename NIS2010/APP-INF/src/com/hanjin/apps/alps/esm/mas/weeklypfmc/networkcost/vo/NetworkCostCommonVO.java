/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NetworkCostCommonVO.java
*@FileTitle : NetworkCostCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
* ========================================================== 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class NetworkCostCommonVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
    private Collection<NetworkCostCommonVO> models = new ArrayList<NetworkCostCommonVO>();

    /*  테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*  테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag               = null;
    /* Page Number */
    private String pagerows             = null;

    /* event Name */
    private String eventName            = null;

    /* SC divide Name */
    private String divideName           = null;

    /* Column Info */

    /* Array Column Info */
    private String port             = null;
    private String cy               = null;
    private String h_locl_curr_cd   = null;
    private String sStatus          = null;
    private String sYM              = null;
    private String sVslCd           = null;
    private String sDlyHireAmt      = null;

    /* 내부적 사용 */
    private String rtnRow 			= null;
    private String headerCD 		= null;
    private String headerNM 		= null;
	private String error_code       = null;	
	private String error_msg        = null;	     

    public NetworkCostCommonVO() {}

    public NetworkCostCommonVO(String ibflag
                             , String pagerows
                             , String yrType
                             , String txtYearweek
                             , String txtYearWeek
                             , String selSlane
                             , String selRlane
                             , String selClass
                             , String port
                             , String cy
                             , String vsl_cd
                             , String sdate
                             , String header
                             , String selVessel
                             ) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.port = port;
        this.cy = cy;
    }

    /* 컬럼 정보 setter/getter ########### START */
    /* Column Info */
    /**
     * VO Data Value( C:Creation, U:Update, D:Delete )
     * @param ibflag
     */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }
    /**
     * VO Data Value( C:Creation, U:Update, D:Delete )
     * @return ibflag
     */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
     * Page Number
     * @param pagerows
     */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }
    /**
     * Page Number
     * @return pagerows
     */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
     * event name
     * @param eventName
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    /**
     * event name
     * @return eventName
     */
    public String getEventName() {
        return this.eventName;
    }

    /**
     * SC divide name
     * @param divideName
     */
    public void setDivideName(String divideName) {
        this.divideName = divideName;
    }
    /**
     * SC divide Number
     * @return divideName
     */
    public String getDivideName() {
        return this.divideName;
    } 
    /* 컬럼 정보  setter/getter ########### END */


    /* 배열 컬럼 정보  setter/getter ########### START */
    /**
     * Column Info
     * @param port
     */
    public void setPort(String port) {
        this.port = port;
    }
    /**
     * Column Info
     * @return port
     */
    public String getPort() {
        return this.port;
    }

    /**
     * Column Info
     * @param cy
     */
    public void setCy(String cy) {
        this.cy = cy;
    }
    /**
     * Column Info
     * @return cy
     */
    public String getCy() {
        return this.cy;
    }

    /**
     * Column Info
     * @param h_locl_curr_cd
     */
    public void setHLoclCurrCd(String h_locl_curr_cd) {
        this.h_locl_curr_cd = h_locl_curr_cd;
    }
    /**
     * Column Info
     * @return h_locl_curr_cd
     */
    public String getHLoclCurrCd() {
        return this.h_locl_curr_cd;
    }

    /**
     * Column Info
     * @param sStatus
     */
    public void setSStatus(String sStatus) {
        this.sStatus = sStatus;
    }
    /**
     * Column Info
     * @return sStatus
     */
    public String getSStatus() {
        return this.sStatus;
    }

    /**
     * Column Info
     * @param sYM
     */
    public void setSYM(String sYM) {
        this.sYM = sYM;
    }
    /**
     * Column Info
     * @return sYM
     */
    public String getSYM() {
        return this.sYM;
    }

    /**
     * Column Info
     * @param sVslCd
     */
    public void setSVslCd(String sVslCd) {
        this.sVslCd = sVslCd;
    }
    /**
     * Column Info
     * @return sVslCd
     */
    public String getSVslCd() {
        return this.sVslCd;
    }

    /**
     * Column Info
     * @param sDlyHireAmt
     */
    public void setSDlyHireAmt(String sDlyHireAmt) {
        this.sDlyHireAmt = sDlyHireAmt;
    }
    /**
     * Column Info
     * @return sDlyHireAmt
     */
    public String getSDlyHireAmt() {
        return this.sDlyHireAmt;
    }

    /* 배열 컬럼 정보  setter/getter ########### END */




    /* 내부적 사용  setter/getter  ######### START */	
    
	/**
	 * normal info
	 * @param error_code
	 */
	public void setErrorCode(String error_code) {
		this.error_code = error_code;
	}	
	/**
	 * normal info
	 * @return error_code
	 */
	public String getErrorCode() {
		return this.error_code;
	}	
	
	/**
	 * normal info
	 * @param error_msg
	 */
	public void setErrorMsg(String error_msg) {
		this.error_msg = error_msg;
	}	
	/**
	 * normal info
	 * @return error_msg
	 */
	public String getErrorMsg() {
		return this.error_msg;
	}	 
	
    /**
     * @param rtnRow
     */
    public void setRtnRow(String rtnRow) {
        this.rtnRow = rtnRow;
    }
    /**
     * @return rtnRow
     */
    public String getRtnRow() {
        return this.rtnRow;
    }
    
    /**
     * @param headerCD
     */
    public void setHeaderCD(String headerCD) {
        this.headerCD = headerCD;
    }
    /**
     * @return headerCD
     */
    public String getHeaderCD() {
        return this.headerCD;
    }  
    
    /**
     * @param headerNM
     */
    public void setHeaderNM(String headerNM) {
        this.headerNM = headerNM;
    }
    /**
     * @return headerNM
     */
    public String getHeaderNM() {
        return this.headerNM;
    }     
    /* 내부적 사용  setter/getter  ######### END */

    /**
     * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
     * @return HashMap
     */
    public HashMap<String, String> getColumnValues(){
        this.hashColumns.put("ibflag"   , getIbflag());
        this.hashColumns.put("pagerows" , getPagerows());
        return this.hashColumns;
    }

    /**
     * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
     * @return
     */
    public HashMap<String, String> getFieldNames(){
        this.hashFields.put("ibflag"        , "ibflag");
        this.hashFields.put("pagerows"      , "pagerows");
        return this.hashFields;
    }

    /**
     * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
     * @param request
     */
    public void fromRequest(HttpServletRequest request) {
        setIbflag       (JSPUtil.getParameter(request, "ibflag"     , ""));
        setPagerows     (JSPUtil.getParameter(request, "pagerows"   , ""));
    }    
         

    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return SimpleMultiVO[]
     */
    public NetworkCostCommonVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    
    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return NetworkCostCommonVO[]
     */
    public NetworkCostCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
    	NetworkCostCommonVO[] vos = null;
    	if(prefix.indexOf("#") != -1){
    		String keyName = prefix.split("#")[1];
    		vos = fromRequestGridForNoPrefix(request, keyName);
    	}
    	else{
    		vos = fromRequestGridForPrefix(request, prefix);
    	}
    	return vos;
    }
    
    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return NetworkCostCommonVO[]
     */
    public NetworkCostCommonVO[] fromRequestGridForPrefix(HttpServletRequest request, String prefix) {
        NetworkCostCommonVO model = null;

        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if(tmp == null) return null;

        int length = request.getParameterValues(prefix + "ibflag").length;

        try {
            String[] ibflag   = (JSPUtil.getParameter(request, prefix + "ibflag"  , length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));

            String[] port           = (JSPUtil.getParameter(request, prefix + "port"            , length));
            String[] cy             = (JSPUtil.getParameter(request, prefix + "cy"              , length));
            String[] h_locl_curr_cd = (JSPUtil.getParameter(request, prefix + "h_locl_curr_cd"  , length));
            String[] sStatus        = (JSPUtil.getParameter(request, prefix + "sStatus"         , length));
            String[] sYM            = (JSPUtil.getParameter(request, prefix + "sYM"             , length));
            String[] sVslCd         = (JSPUtil.getParameter(request, prefix + "sVslCd"          , length));
            String[] sDlyHireAmt    = (JSPUtil.getParameter(request, prefix + "sDlyHireAmt"     , length));

            for (int i = 0; i < length; i++) {
                model = new NetworkCostCommonVO();
                if (ibflag[i]   != null)    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)    model.setPagerows(pagerows[i]);

                if (port[i]             != null)    model.setPort(port[i]);
                if (cy[i]               != null)    model.setCy(cy[i]);
                if (h_locl_curr_cd[i]   != null)    model.setHLoclCurrCd(h_locl_curr_cd[i]);
                if (sStatus[i]          != null)    model.setSStatus(sStatus[i]);
                if (sYM[i]              != null)    model.setSYM(sYM[i]);
                if (sVslCd[i]           != null)    model.setSVslCd(sVslCd[i]);
                if (sDlyHireAmt[i]      != null)    model.setSDlyHireAmt(sDlyHireAmt[i]);

                models.add(model);
            }

        } catch (Exception e) {
            return null;
        }
        return getNetworkCostCommonVOs();
    }    

    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return NetworkCostCommonVO[]
     */
    public NetworkCostCommonVO[] fromRequestGridForNoPrefix(HttpServletRequest request, String keyName) {
        NetworkCostCommonVO model = null;

        String[] tmp = request.getParameterValues(keyName);
        if(tmp == null) return null;

        int length = request.getParameterValues(keyName).length;

        try {
        	String[] ibflag   = (JSPUtil.getParameter(request, keyName, length));
        	
            String[] port           = (JSPUtil.getParameter(request, "port"            , length));
            String[] cy             = (JSPUtil.getParameter(request, "cy"              , length));
            String[] h_locl_curr_cd = (JSPUtil.getParameter(request, "h_locl_curr_cd"  , length));
            String[] sStatus        = (JSPUtil.getParameter(request, "sStatus"         , length));
            String[] sYM            = (JSPUtil.getParameter(request, "sYM"             , length));
            String[] sVslCd         = (JSPUtil.getParameter(request, "sVslCd"          , length));
            String[] sDlyHireAmt    = (JSPUtil.getParameter(request, "sDlyHireAmt"     , length));

            for (int i = 0; i < length; i++) {
                model = new NetworkCostCommonVO();
                if (ibflag[i]   != null)    model.setIbflag(ibflag[i]);

                if (port[i]             != null)    model.setPort(port[i]);
                if (cy[i]               != null)    model.setCy(cy[i]);
                if (h_locl_curr_cd[i]   != null)    model.setHLoclCurrCd(h_locl_curr_cd[i]);
                if (sStatus[i]          != null)    model.setSStatus(sStatus[i]);
                if (sYM[i]              != null)    model.setSYM(sYM[i]);
                if (sVslCd[i]           != null)    model.setSVslCd(sVslCd[i]);
                if (sDlyHireAmt[i]      != null)    model.setSDlyHireAmt(sDlyHireAmt[i]);

                models.add(model);
            }

        } catch (Exception e) {
            return null;
        }
        return getNetworkCostCommonVOs();
    }

    /**
     * VO 배열을 반환
     * @return SimpleMultiVO[]
     */
    public NetworkCostCommonVO[] getNetworkCostCommonVOs(){
        return (NetworkCostCommonVO[])models.toArray(new NetworkCostCommonVO[models.size()]);
    }

    /**
     * VO Class의 내용을 String으로 변환
     */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try{
            for(int i = 0; i < field.length; i++){
                String[] arr = null;
                arr = getField(field, i);
                if(arr != null){
                    for(int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return ret.toString();
    }

    /**
     * 필드에 있는 값을 스트링 배열로 반환.
     * @param field
     * @param i
     * @return String[]
     */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try{
            arr = (String[]) field[i].get(this);
        }catch(Exception ex){
            arr = null;
        }
        return arr;
    }

    /**
    * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
    */
    public void unDataFormat(){
        this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }




    //추가1############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################

    /*  Velocity 변수에  값을 저장하는 Hashtable */
    private HashMap<String, Object> hashVariables = new HashMap<String, Object>();

    /**
     * 테이블 컬럼에 저장할 값을 Hashtable<"condition_name", "value"> 로 반환
     *  - 쿼리의 매개변수로 셋팅.
     *  - 가변조회 조건에 대한 값.
     *
     * @return Map
     */
    public Map<String, Object> getQueryParameter(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.putAll(getColumnValues());
        return param;
    }

    /**
     * Velocity 변수에 저장할 값을 Hashtable<"variable_name", Object> 로 반환
     *  - 쿼리의 매개변수로 셋팅.
     *  - 가변조회 조건에 대한 값.
     *
     * @return Map
     */
    public Map<String, Object> getVelocityParameter(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.putAll(getVariableValues());
        return param;
    }

    /**
     * Velocity 변수에 저장할 값을 Hashtable<"variable_name", Object> 로 반환
     * @return HashMap
     */
    public HashMap<String, Object> getVariableValues(){
        this.hashVariables.put("keyList"    , getIteratorList()==null?"":getIteratorList().iterator());
        this.hashVariables.put("keyCnt"     , getIteratorCnt()          );
        this.hashVariables.put("voKeyList"  , getIteratorVoList()==null?"":getIteratorVoList().iterator());
        this.hashVariables.put("voKeyCnt"   , getIteratorVoCnt()        );
        return this.hashVariables;
    }
    //추가1############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################


    //추가1############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
    private Collection<NetworkCostCommonVO> indirectModels = new ArrayList<NetworkCostCommonVO>();

    /**
    * NetworkCostCommonVO[] 배열을 셋팅
    */
    public void setIndirectNetworkCostCommonVOs(NetworkCostCommonVO[] vos){
        indirectModels.remove(vos);
        if(vos.length > 0){
            for(int i = 0 ; i < vos.length ; i++){
                indirectModels.add(vos[i]);
            }
        }
    }

    /**
     * VO 배열을 반환
     * @return NetworkCostCommonVO[]
     */
    public NetworkCostCommonVO[] getIndirectNetworkCostCommonVOs(){
        return (NetworkCostCommonVO[])indirectModels.toArray(new NetworkCostCommonVO[indirectModels.size()]);
    }

    //추가2############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################

    //추가3############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
    /*  테이블 컬럼의  등록 값을 저장하는  List */
    private List createList = null;

    /*  테이블 컬럼의  수정 값을 저장하는  List */
    private List updateList = null;

    /*  테이블 컬럼의  삭제 값을 저장하는  List */
    private List deleteList = null;

    /*  테이블 컬럼의 다중 값을 저장하는  List */
    private List saveList = null;

    private NetworkCostCommonVO[] m_voArray = null;

    /** 등록 리스트 Getter */
    public List getMultiCreateList(){
        return createList;
    }
    /** 등록 리스트 Setter */
    public void setMultiCreateList(List list){
        createList = list;
    }

    /** 수정 리스트 Getter */
    public List getMultiUpdateList(){
        return updateList;
    }
    /** 수정 리스트 Setter */
    public void setMultiUpdateList(List list){
        updateList = list;
    }

    /** 삭제 리스트 Getter */
    public List getMultiDeleteList(){
        return deleteList;
    }
    /** 삭제 리스트 Setter */
    public void setMultiDeleteList(List list){
        deleteList = list;
    }

    /** 삭제 리스트 Getter */
    public List getMultiSaveList(){
        return saveList;
    }
    /** 삭제 리스트 Setter */
    public void setMultiSaveList(List list){
        saveList = list;
    }

    /**
    * NetworkCostCommonVO[] 배열을 리턴
    */
    public NetworkCostCommonVO[] getNetworkCostCommonVOArray(){
        return m_voArray;
    }
    /**
    * NetworkCostCommonVO[] 배열을 셋팅
    */
    public void setNetworkCostCommonVOArray(NetworkCostCommonVO[] voArray){
        m_voArray = voArray;
    }
    //추가3############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################

    //추가4############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
    /* DB RowSet 객체  */
    private DBRowSet m_rowSet = null;

    /* DB RowSet 객체  */
    private DBRowSet[] m_rowSetArray = null;

    /* DB List 객체  */
    List<NetworkCostCommonVO> m_voList = null;

    /** DBRowSet Getter */
    public DBRowSet getRowSet() {
        return m_rowSet;
    }
    /** DBRowSet Setter */
    public void setRowSet(DBRowSet rowSet) {
        this.m_rowSet = rowSet;
    }

    /** DBRowSet Array Getter */
    public DBRowSet[] getRowSetArray() {
        return m_rowSetArray;
    }
    /** DBRowSet Array Setter */
    public void setRowSetArray(DBRowSet[] rowSetArray) {
        this.m_rowSetArray = rowSetArray;
    }

    /** DB List Getter */
    public List<NetworkCostCommonVO> getListSet() {
        return m_voList;
    }

    /** DB List Setter */
    public void setListSet(List<NetworkCostCommonVO> voList) {
        this.m_voList = voList;
    }
    //추가4############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################

    //추가5############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
    /* iterator List Info */
    private List<String> m_iteratorList = null;

    /* iterator List Info */
    private List<NetworkCostCommonVO> m_iteratorVoList = null;

    /* iterator Info */
    private Integer m_iteratorCnt = null;

    /* iterator Info */
    private String m_iteratorVoCnt = null;

    /* iterator Info */
    private String itrVoKey1 = null;

    /* iterator Info */
    private String itrVoKey2 = null;

    /**
     * iterator List Info
     * @return iteratorList
     */
    public List<String> getIteratorList() {
        return this.m_iteratorList;
    }
    /**
     * iterator List Info
     * @param iteratorList
     */
    public void setIteratorList(List<String> iteratorList) {
        this.m_iteratorList = iteratorList;
    }

    /**
     * iterator Info
     * @return iterators
     */
    public Integer getIteratorCnt() {
        return this.m_iteratorCnt;
    }
    /**
     * iterator Info
     * @param iterators
     */
    public void setIteratorCnt(Integer iteratorCnt) {
        this.m_iteratorCnt = iteratorCnt;
    }

    /**
     * iterator Info
     * @return iteratorVoCnt
     */
    public String getIteratorVoCnt() {
        return this.m_iteratorVoCnt;
    }
    /**
     * iterator Info
     * @param iteratorVoCnt
     */
    public void setIteratorVoCnt(String iteratorVoCnt) {
        this.m_iteratorVoCnt = iteratorVoCnt;
    }

    /**
     * iterator List Info
     * @return iteratorVoList
     */
    public List<NetworkCostCommonVO> getIteratorVoList() {
        return this.m_iteratorVoList;
    }
    /**
     * iterator List Info
     * @param iteratorVoList
     */
    public void setIteratorVoList(List<NetworkCostCommonVO> iteratorVoList) {
        this.m_iteratorVoList = iteratorVoList;
    }

    /**
     * iterator Info
     * @return itrVoKey1
     */
    public String getItrVoKey1() {
        return this.itrVoKey1;
    }
    /**
     * iterator Info
     * @param itrVoKey1
     */
    public void setItrVoKey1(String itrVoKey1) {
        this.itrVoKey1 = itrVoKey1;
    }

    /**
     * iterator Info
     * @return itrVoKey2
     */
    public String getItrVoKey2() {
        return this.itrVoKey2;
    }
    /**
     * iterator Info
     * @param itrVoKey2
     */
    public void setItrVoKey2(String itrVoKey2) {
        this.itrVoKey2 = itrVoKey2;
    }
    //추가5############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################

    //추가6############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
    /*  테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashIndirectColumns = new HashMap<String, String>();

    /*  Velocity 변수에  값을 저장하는 Hashtable */
    private HashMap<String, Object> hashIndirectVariables = new HashMap<String, Object>();


    /**
     * ColumnValues Info
     * @return hashIndirectColumns
     */
    public HashMap<String, String> getIndirectColumnValues() {
        return this.hashIndirectColumns;
    }
    /**
     * ColumnValues Info
     * @param hashIndirectColumns
     */
    public void setIndirectColumnValues(HashMap<String, String> hMap) {
        this.hashIndirectColumns = hMap;
    }

    /**
     * VariableValues Info
     * @return hashIndirectVariables
     */
    public HashMap<String, Object> getIndirectVariableValues() {
        return this.hashIndirectVariables;
    }
    /**
     * VariableValues Info
     * @param hashIndirectVariables
     */
    public void setIndirectVariableValues(HashMap<String, Object> hMap) {
        this.hashIndirectVariables = hMap;
    }

    /**
     * 테이블 컬럼에 저장할 값을 Hashtable<"condition_name", "value"> 로 반환
     *  - 쿼리의 매개변수로 셋팅.
     *  - 가변조회 조건에 대한 값.
     *
     * @return Map
     */
    public Map<String, Object> getIndirectQueryParameter(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.putAll(getIndirectColumnValues());
        return param;
    }

    /**
     * Velocity 변수에 저장할 값을 Hashtable<"variable_name", Object> 로 반환
     *  - 쿼리의 매개변수로 셋팅.
     *  - 가변조회 조건에 대한 값.
     *
     * @return Map
     */
    public Map<String, Object> getIndirectVelocityParameter(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.putAll(getIndirectVariableValues());
        return param;
    }
    //추가6############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################

    //추가7############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
    /*  테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap hashReqeust = null;

    /**
     * hashReqeust
     * @param HashMap hashReqeust
     */
    public void setHashReqeust(HashMap hashReqeust) {
        this.hashReqeust = hashReqeust;
    }
    /**
     * hashReqeust
     * @return HashMap hashReqeust
     */
    public HashMap getHashReqeust() {
        return this.hashReqeust;
    }

    public String[] getHashAttribute(String key){
        return (String[])hashReqeust.get(key);
    }

    /**
     * 화면에서 넘긴 request 객체의 데이터를 HashMap에 입력하여 HashMap객체를 리턴한다.
     *
     * key   : 화면의 컨트롤객체 이름
     * value : 화면의 컨트롤객체 값
     *
     * @param request
     * @return HashMap
     */
    public void requestToHashMap(HttpServletRequest request){
        HashMap hash = new HashMap();
        hashReqeust = new HashMap();
        Map map = request.getParameterMap();
        Iterator it = map.keySet().iterator();
        Object key = null;
        String[] value = null;
        StringBuffer sysOut = new StringBuffer();

        while(it.hasNext()){
            key = it.next();
            value = (String[])map.get(key);
            hashReqeust.put(key, value);
            sysOut.append("\n key[" +Utils.fillSpace((String)key, 15, " ", "right")+ "] : [");
            for(int i=0; i<value.length; i++){
                sysOut.append(value[i] );
                if(i != value.length-1)sysOut.append( " : ");
            }
            sysOut.append("]");
        }
    }
    //추가7############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################
    
    //추가#############################################################################################START
    //#####################################################################################################
    //#####################################################################################################	
	/**
	 * 여러개의 parameter 를 2개의 String 배열로 나누어주는 메소드
	 * 
	 * @param String sparameter
	 * @param String sSeperate
	 * @return List<String>
	 */
	public List<NetworkCostCommonVO> seperationParameterVo(String sparameter1, String sparameter2, String sSeperate) {
		List<String> tempArrList1 = null;
		List<String> tempArrList2 = null;
		List<NetworkCostCommonVO> arrlist = null;
		StringTokenizer st1  = null;
		StringTokenizer st2  = null;
		int j = 0;
		if( !sparameter1.equals("") && !sparameter2.equals("") ) {
			tempArrList1 = new ArrayList<String>();
			tempArrList2 = new ArrayList<String>();
			arrlist = new ArrayList<NetworkCostCommonVO>();
			st1 = new StringTokenizer(sparameter1, sSeperate);
			st2 = new StringTokenizer(sparameter2, sSeperate);

			while( st1.hasMoreTokens() ) {
				tempArrList1.add(j++, st1.nextToken());
			}
			j = 0;
			while( st2.hasMoreTokens() ) {
				tempArrList2.add(j++, st2.nextToken());
			}
			
			int cnt1 = tempArrList1.size();
			int cnt2 = tempArrList2.size();
			
			if(cnt1 == cnt2){
				for(int i=0; i<cnt1; i++){
					NetworkCostCommonVO vo = new NetworkCostCommonVO();
					vo.setItrVoKey1((String)tempArrList1.get(i));
					vo.setItrVoKey2((String)tempArrList2.get(i));
					arrlist.add(i, vo);
				}
			}
			else{
				return null;
			}
		}
		return arrlist;
	}	
	
	/**
	 * 여러개의 parameter 를 병합시켜 메소드
	 *
	 * @param String sparameter
	 * @param String sSeperat
	 * @return List<String>
	 */
	public List<String> mergeParameter(String sparameter, String sSeperate) {
		List<String> arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList<String>();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}	
	
	/**
	 * 여러개의 parameter 를 나누어주는 메소드
	 * 
	 * @param String sparameter
	 * @param String sSeperate
	 * @return List<String>
	 */
	public List<String> seperationParameter(String sparameter, String sSeperate) {
		List<String> arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList<String>();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}		
    //추가#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################	
	
	
	
    //추가#############################################################################################START
    //#####################################################################################################
    //#####################################################################################################		
    
    private HashMap<String, Object> hashEtcData = new HashMap<String, Object>();
    /**
     * EtcData Info
     * @return hashEtcData
     */
    public HashMap<String, Object> getMakeEtcData() {
        return this.hashEtcData;
    }
    /**
     * EtcData Info
     * @param hashEtcData
     */
    public void setMakeEtcData(HashMap<String, Object> hMap) {
        this.hashEtcData = hMap;
    }
    
    //추가#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################	
}
