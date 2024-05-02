/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTCommonVO.java
*@FileTitle : SalesRPTCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
========================================================== 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정  
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.Utils;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SalesRPTCommonVO extends AbstractValueObject {	
	
	private Collection<SalesRPTCommonVO> models = new ArrayList<SalesRPTCommonVO>();

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();	
	
	/* Basic Info */
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag       		= null;
	/* Page Number */
	private String pagerows     		= null;
	
	/* event Name */
	private String eventName     		= null;	

	/* SC divide Name */
	private String divideName     		= null;	
	
    /* Column Info */
    
    /* Array Column Info */
    private String rpt_itm_cd          = null;
    private String rpt_itm_desc        = null;
    private String rpt_itm_col_nm      = null;
    
    /* 내부적 사용 */		
	private String selGroup     		= null;	
	private String header     		    = null;
	private String headerNM     		= null;    

    
	/* 내부 set/get */
	public SalesRPTCommonVO() {}

	public SalesRPTCommonVO(String ibflag
                      , String pagerows) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}

	/* 필수 정보 ########## START */
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
	/* 필수 정보 ########## END */
	
	
	/* 파라메타 정보 ########## START */
	/**
	 * column info
	 * @param selGroup
	 */
	public void setSelGroup(String selGroup) {
		this.selGroup = selGroup;
	}	
	/**
	 * column info
	 * @return selGroup
	 */
	public String getSelGroup() {
		return this.selGroup;
	}	
	
	
	/**
	 * column info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}	
	/**
	 * column info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}	
	
	/**
	 * column info
	 * @param headerNM
	 */
	public void setHeaderNM(String headerNM) {
		this.headerNM = headerNM;
	}	
	/**
	 * column info
	 * @return headerNM
	 */
	public String getHeaderNM() {
		return this.headerNM;
	}
	/* 파라메타 정보 ########## END */
	
	
	/* 파라메타  배열 정보 ########## START */
	
	/**
	 * column info
	 * @param rpt_itm_cd
	 */
	public void setRptItmCd(String rpt_itm_cd) {
		this.rpt_itm_cd = rpt_itm_cd;
	}	
	/**
	 * column info
	 * @return rpt_itm_cd
	 */
	public String getRptItmCd() {
		return this.rpt_itm_cd;
	}	
	
	/**
	 * column info
	 * @param rpt_itm_desc
	 */
	public void setRptItmDesc(String rpt_itm_desc) {
		this.rpt_itm_desc = rpt_itm_desc;
	}	
	/**
	 * column info
	 * @return rpt_itm_desc
	 */
	public String getRptItmDesc() {
		return this.rpt_itm_desc;
	}	
	
	/**
	 * column info
	 * @param rpt_itm_col_nm
	 */
	public void setRptItmColNm(String rpt_itm_col_nm) {
		this.rpt_itm_col_nm = rpt_itm_col_nm;
	}	
	/**
	 * column info
	 * @return rpt_itm_col_nm
	 */
	public String getRptItmColNm() {
		return this.rpt_itm_col_nm;
	}		
	
	/* 파라메타 정보 ########## END */
	
	/* 단순 set/get 정보 ########## START */
	
	/* 단순 set/get 정보 ########## END */
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */	
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */	
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag  (JSPUtil.getParameter(request, "ibflag"  , ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));	
			
	    setDivideName     (JSPUtil.getParameter(request, "divideName"         , ""));	
	}
			

	
    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return SalesRPTCommonVO[]
     */
    public SalesRPTCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
    	SalesRPTCommonVO[] vos = null;
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
     * @return SalesRPTCommonVO[]
     */
    public SalesRPTCommonVO[] fromRequestGridForPrefix(HttpServletRequest request, String prefix) {
    	SalesRPTCommonVO model = null;

        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if(tmp == null) return null;

        int length = request.getParameterValues(prefix + "ibflag").length;

        try {
            String[] ibflag   = (JSPUtil.getParameter(request, prefix + "ibflag"  , length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));

            String[] xxxx   = (JSPUtil.getParameter(request, "xxxx", length));

            for (int i = 0; i < length; i++) {
                model = new SalesRPTCommonVO();
                if (ibflag[i]   != null)    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)    model.setPagerows(pagerows[i]);

                //if (xxxx[i] != null)        model.setXxxx(xxxx[i]);

                models.add(model);
            }

        } catch (Exception e) {
            return null;
        }
        return getSalesRPTCommonVOs();
    }

    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return SalesRPTCommonVO[]
     */
    public SalesRPTCommonVO[] fromRequestGridForNoPrefix(HttpServletRequest request, String keyName) {
    	
    	SalesRPTCommonVO model = null;

        String[] tmp = request.getParameterValues(keyName);
        if(tmp == null) return null;

        int length = request.getParameterValues(keyName).length;

        try {
            String[] ibflag   = (JSPUtil.getParameter(request, keyName, length));
            String[] pagerows = (JSPUtil.getParameter(request, "pagerows", length));	            
            
            String[] rpt_itm_cd   = (JSPUtil.getParameter(request, "rpt_itm_cd", length));
            String[] rpt_itm_desc = (JSPUtil.getParameter(request, "to", length));
            String[] rpt_itm_col_nm   = (JSPUtil.getParameter(request, "rpt_itm_col_nm", length));

            for (int i = 0; i < length; i++) {
                model = new SalesRPTCommonVO();
                if (ibflag[i]   != null) model.setIbflag(ibflag[i]);
                if (pagerows[i] != null) model.setPagerows(pagerows[i]);
                
                if (rpt_itm_cd[i]     != null) model.setRptItmCd(rpt_itm_cd[i]);
                if (rpt_itm_desc[i]   != null) model.setRptItmDesc(rpt_itm_desc[i]);
                if (rpt_itm_col_nm[i] != null) model.setRptItmColNm(rpt_itm_col_nm[i]);

                models.add(model);
            }

        } catch (Exception e) {
            return null;
        }
        return getSalesRPTCommonVOs();
    }	

	/**
	 * VO 배열을 반환
	 * @return SalesRPTCommonVO[]
	 */
	public SalesRPTCommonVO[] getSalesRPTCommonVOs(){
		return (SalesRPTCommonVO[])models.toArray(new SalesRPTCommonVO[models.size()]);
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
    
	/*	Velocity 변수에  값을 저장하는 Hashtable */
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
		this.hashVariables.put("keyList" 	, getIteratorList()==null?"":getIteratorList().iterator());
		this.hashVariables.put("keyCnt" 	, getIteratorCnt() 	        );
		this.hashVariables.put("voKeyList"  , getIteratorVoList()==null?"":getIteratorVoList().iterator());
		this.hashVariables.put("voKeyCnt"   , getIteratorVoCnt() 	    );
		return this.hashVariables;
	}		
    //추가1############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################  	
    
    
    //추가1############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################  	
	private Collection<SalesRPTCommonVO> indirectModels = new ArrayList<SalesRPTCommonVO>();
	
	/**
	* SalesRPTCommonVO[] 배열을 셋팅
	*/
	public void setIndirectSalesRPTCommonVOs(SalesRPTCommonVO[] vos){
		indirectModels.remove(vos);
        if(vos.length > 0){
            for(int i = 0 ; i < vos.length ; i++){
            	indirectModels.add(vos[i]);
            }
        }
	}
	
	/**
	 * VO 배열을 반환
	 * @return SalesRPTCommonVO[]
	 */
	public SalesRPTCommonVO[] getIndirectSalesRPTCommonVOs(){
		return (SalesRPTCommonVO[])indirectModels.toArray(new SalesRPTCommonVO[indirectModels.size()]);
	}	
	
    //추가2############################################################################################## END
    //#####################################################################################################
    //##################################################################################################### 
	
    //추가3############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################  	
	/*	테이블 컬럼의  등록 값을 저장하는  List */
	private List createList = null;
	private List createList2 = null;
	
	/*	테이블 컬럼의  수정 값을 저장하는  List */
	private List updateList = null;
	
	/*	테이블 컬럼의  삭제 값을 저장하는  List */
	private List deleteList = null;
	private List deleteList2 = null;
	
	private SalesRPTCommonVO[] m_voArray = null;
    
	/** 등록 리스트 Getter */
	public List getMultiCreateList(){	
		return createList;
	}
	/** 등록 리스트 Setter */
	public void setMultiCreateList(List list){	
		createList = list;
	}
	
	/** 등록 리스트 Getter */
	public List getMultiCreateList2(){	
		return createList2;
	}
	/** 등록 리스트 Setter */
	public void setMultiCreateList2(List list){	
		createList2 = list;
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
	public List getMultiDeleteList2(){		
		return deleteList2;
	}
	/** 삭제 리스트 Setter */
	public void setMultiDeleteList2(List list){	
		deleteList2 = list;
	}		
	
	/**
	* SalesRPTCommonVO[] 배열을 리턴
	*/
	public SalesRPTCommonVO[] getSalesRPTCommonVOArray(){
		return m_voArray;
	}	
	/**
	* SalesRPTCommonVO[] 배열을 셋팅
	*/
	public void setSalesRPTCommonVOArray(SalesRPTCommonVO[] voArray){
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
	List<SalesRPTCommonVO> m_voList = null;	
	
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
	public List<SalesRPTCommonVO> getListSet() {
		return m_voList;
	}

	/** DB List Setter */
	public void setListSet(List<SalesRPTCommonVO> voList) {
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
	private List<SalesRPTCommonVO> m_iteratorVoList = null;	
	
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
	public List<SalesRPTCommonVO> getIteratorVoList() {
		return this.m_iteratorVoList;
	}
	/**
	 * iterator List Info
	 * @param iteratorVoList
	 */
	public void setIteratorVoList(List<SalesRPTCommonVO> iteratorVoList) {
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
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashIndirectColumns = new HashMap<String, String>();
	
	/*	Velocity 변수에  값을 저장하는 Hashtable */
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
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
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
		// requestToHashMap(HttpServletRequest request)
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
	
    //추가8############################################################################################# START
    //#####################################################################################################
    //##################################################################################################### 
	private String M_bsa_seq_arry = null;
	
	public String getMBsaSeq_ArrayStr() {
		return M_bsa_seq_arry;
	}
	public void setMBsaSeq_ArrayStr(String M_bsa_seq) {
		this.M_bsa_seq_arry = M_bsa_seq;
	}	

	private void fromRequestException1(HttpServletRequest request){
		String[] tmp = request.getParameterValues("M_ibflag");
  		if(tmp != null){
	  		int length2 = request.getParameterValues("M_ibflag").length;		
			setMBsaSeq_ArrayStr(JSPUtil.getParameter(request, "M_bsa_seq", length2)[0]); 
  		}			
	}
    //추가8############################################################################################## END
    //#####################################################################################################
    //##################################################################################################### 
	
    //추가9############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
	
	/* iterator List Info */
	private List<HashMap<String, Object>> D_crr_bsa_capa_A = new ArrayList<HashMap<String, Object>>();
	
	private String bsa_op_jb_cd1_length = null;	
	
	private void fromRequestException2(HttpServletRequest request){
		//예외적인 처리--------------------------------------------------------------------START
		int length = request.getParameterValues("ibflag").length;
		try {			
            setBsaOpJbCd1Length (JSPUtil.getParameter(request, "bsa_op_jb_cd1_length", ""));
            
            int d_capa_len = Integer.parseInt((getBsaOpJbCd1Length()==null || getBsaOpJbCd1Length()=="")?"0":getBsaOpJbCd1Length());

            if(d_capa_len > 0){
	            for(int i=0; i<d_capa_len; i++){
	            	String[] D_crr_bsa_capa_temp = (JSPUtil.getParameter(request, "D_crr_bsa_capa"+i, length));
	            	HashMap<String, Object> hMap = new HashMap<String, Object>();
	            	hMap.put("D_crr_bsa_capa"+i, D_crr_bsa_capa_temp);
	            	D_crr_bsa_capa_A.add(hMap);
	            }
            }	
                       
		} catch (Exception e) {
			D_crr_bsa_capa_A =  null;
		} 
		//예외적인 처리--------------------------------------------------------------------END		
	}
	
	public String getBsaOpJbCd1Length() {
		return bsa_op_jb_cd1_length;
	}
	public void setBsaOpJbCd1Length(String bsa_op_jb_cd1_length) {
		this.bsa_op_jb_cd1_length = bsa_op_jb_cd1_length;
	}

	public List<HashMap<String, Object>> getDCrrBsaCapaA() {
		return D_crr_bsa_capa_A;
	}
	public void setDCrrBsaCapaA(List<HashMap<String, Object>> D_crr_bsa_capa_A) {
		this.D_crr_bsa_capa_A = D_crr_bsa_capa_A;
	}		
		
    //추가9############################################################################################## END
    //#####################################################################################################
    //##################################################################################################### 	

    //추가10#############################################################################################START
    //#####################################################################################################
    //#####################################################################################################	
	/**
	 * 여러개의 parameter 를 2개의 String 배열로 나누어주는 메소드
	 * 
	 * @param String sparameter
	 * @param String sSeperate
	 * @return List<String>
	 */
	public List<SalesRPTCommonVO> seperationParameterVo(String sparameter1, String sparameter2, String sSeperate) {
		List<String> tempArrList1 = null;
		List<String> tempArrList2 = null;
		List<SalesRPTCommonVO> arrlist = null;
		StringTokenizer st1  = null;
		StringTokenizer st2  = null;
		
		int j = 0;
		if( !sparameter1.equals("") && !sparameter2.equals("") ) {
			tempArrList1 = new ArrayList<String>();
			tempArrList2 = new ArrayList<String>();
			arrlist = new ArrayList<SalesRPTCommonVO>();
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
					SalesRPTCommonVO vo = new SalesRPTCommonVO();
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
	 * @param List<String>
	 * @param String sSeperat
	 * @return String
	 */
	public String mergeParameterForList(List<String> list, String sSeperate) {
		StringBuffer strBuff = new StringBuffer();

		if(list == null){ return ""; }

		int listCnt = list.size();
		if(listCnt > 0){
			for(int i=0; i<listCnt; i++){
				if(i==0){
					strBuff.append((String)list.get(i));
				}
				else{
					strBuff.append(sSeperate);
					strBuff.append((String)list.get(i));
				}
			}
		}
		return strBuff.toString();
	}	
	
	/**
	 * 여러개의 parameter 를 병합시켜 메소드
	 *
	 * @param String[] array
	 * @param String sSeperat
	 * @return String
	 */
	public String mergeParameterForArray(String[] array, String sSeperate) {
		StringBuffer strBuff = new StringBuffer();

		if(array == null){ return ""; }

		int len = array.length;
		if(len > 0){
			for(int i=0; i<len; i++){
				if(i==0){
					strBuff.append(array[i]);
				}
				else{
					strBuff.append(sSeperate);
					strBuff.append(array[i]);
				}
			}
		}
		return strBuff.toString();
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
    //추가10#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################		
		
	
}
