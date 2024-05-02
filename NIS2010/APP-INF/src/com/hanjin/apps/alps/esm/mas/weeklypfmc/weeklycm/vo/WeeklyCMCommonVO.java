/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMCommonVO.java
*@FileTitle : WeeklyCMCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
public class WeeklyCMCommonVO extends AbstractValueObject {	
	
	private static final long serialVersionUID = 1L;
	
	private Collection<WeeklyCMCommonVO> models = new ArrayList<WeeklyCMCommonVO>();

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();	
	
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
	private String rlane_cd             = null;
	private String dir_cd               = null;
	private String trd_cd               = null;
	private String ioc_cd               = null;	
	private String ibDel                = null;
	private String ibSel                = null;	


    /* 내부적 사용 */
	private String error_code           = null;	
	private String error_msg            = null;	
	private String return_vsl_cd        = null;	
	private String year                 = null;
	private String fm_wk                = null;
	private String to_wk                = null;
	private String diffWk               = null;
	


	public WeeklyCMCommonVO() {}

	public WeeklyCMCommonVO(String ibflag
                      , String pagerows) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}

	/* Basic Info setter/getter ########### START */
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
	/* Basic Info setter/getter ########### END */
	
	/* 컬럼 정보 setter/getter ########### START */
	/**
	 * Condition info
	 * @param ibDel
	 */
	public void setIbDel(String ibDel) {
		this.ibDel = ibDel;
	}	
	/**
	 * Condition info
	 * @return ibDel
	 */
	public String getIbDel() {
		return this.ibDel;
	}	
	
	/**
	 * Condition info
	 * @param ibSel
	 */
	public void setIbSel(String ibSel) {
		this.ibDel = ibSel;
	}	
	/**
	 * Condition info
	 * @return ibSel
	 */
	public String getIbSel() {
		return this.ibSel;
	}		
	
	/* 컬럼 정보  setter/getter ########### END */
	
	
    /* 배열 컬럼 정보  setter/getter ########### START */
	/**
	 * Condition info
	 * @param rlane_cd
	 */
	public void setRlaneCd(String rlane_cd) {
		this.rlane_cd = rlane_cd;
	}	
	/**
	 * Condition info
	 * @return rlane_cd
	 */
	public String getRlaneCd() {
		return this.rlane_cd;
	}
	
	/**
	 * Condition info
	 * @param dir_cd
	 */
	public void setDirCd(String dir_cd) {
		this.dir_cd = dir_cd;
	}	
	/**
	 * Condition info
	 * @return dir_cd
	 */
	public String getDirCd() {
		return this.dir_cd;
	}
	
	/**
	 * Condition info
	 * @param trd_cd
	 */
	public void setTrdCd(String trd_cd) {
		this.trd_cd = trd_cd;
	}	
	/**
	 * Condition info
	 * @return trd_cd
	 */
	public String getTrdCd() {
		return this.trd_cd;
	}
	
	/**
	 * Condition info
	 * @param ioc_cd
	 */
	public void setIocCd(String ioc_cd) {
		this.ioc_cd = ioc_cd;
	}	
	/**
	 * Condition info
	 * @return ioc_cd
	 */
	public String getIocCd() {
		return this.ioc_cd;
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
	 * normal info
	 * @param return_vsl_cd
	 */
	public void setReturnVslCd(String return_vsl_cd) {
		this.return_vsl_cd = return_vsl_cd;
	}	
	/**
	 * normal info
	 * @return return_vsl_cd
	 */
	public String getReturnVslCd() {
		return this.return_vsl_cd;
	}	
	
	/**
	 * normal info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}	
	/**
	 * normal info
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}	
	
	/**
	 * normal info
	 * @param fm_wk
	 */
	public void setFmWk(String fm_wk) {
		this.fm_wk = fm_wk;
	}	
	/**
	 * normal info
	 * @return fm_wk
	 */
	public String getFmWk() {
		return this.fm_wk;
	}

	/**
	 * normal info
	 * @param to_wk
	 */
	public void setToWk(String to_wk) {
		this.to_wk = to_wk;
	}	
	/**
	 * normal info
	 * @return to_wk
	 */
	public String getToWk() {
		return this.to_wk;
	}	
	
	/**
	 * normal info
	 * @param diffWk
	 */
	public void setDiffWk(String diffWk) {
		this.diffWk = diffWk;
	}	
	/**
	 * normal info
	 * @return diffWk
	 */
	public String getDiffWk() {
		return this.diffWk;
	}		
    /* 내부적 사용  setter/getter  ######### END */	
	
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
	}


    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return WeeklyCMCommonVO[]
     */
    public WeeklyCMCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
    	WeeklyCMCommonVO[] vos = null;
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
     * @return WeeklyCMCommonVO[]
     */
    public WeeklyCMCommonVO[] fromRequestGridForPrefix(HttpServletRequest request, String prefix) {
    	WeeklyCMCommonVO model = null;

        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if(tmp == null) return null;

        int length = request.getParameterValues(prefix + "ibflag").length;

        try {
            String[] ibflag   = (JSPUtil.getParameter(request, prefix + "ibflag"  , length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));

            String[] xxxx   = (JSPUtil.getParameter(request, "xxxx", length));

            for (int i = 0; i < length; i++) {
                model = new WeeklyCMCommonVO();
                if (ibflag[i]   != null)    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)    model.setPagerows(pagerows[i]);

                //if (xxxx[i] != null)        model.setXxxx(xxxx[i]);

                models.add(model);
            }

        } catch (Exception e) {
            return null;
        }
        return getWeeklyCMCommonVOs();
    }

    /**
     * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
     * @param request
     * @param prefix
     * @return WeeklyCMCommonVO[]
     */
    public WeeklyCMCommonVO[] fromRequestGridForNoPrefix(HttpServletRequest request, String keyName) {
    	WeeklyCMCommonVO model = null;

        String[] tmp = request.getParameterValues(keyName);
        if(tmp == null) return null;

        int length = request.getParameterValues(keyName).length;

        try {
            String[] ibflag   = (JSPUtil.getParameter(request, keyName, length));
            String[] pagerows = (JSPUtil.getParameter(request, "pagerows", length));

            String[] rlane_cd = (JSPUtil.getParameter(request, "rlane_cd", length));
            String[] dir_cd   = (JSPUtil.getParameter(request, "dir_cd"  , length));
            String[] trd_cd   = (JSPUtil.getParameter(request, "trd_cd"  , length));
            String[] ioc_cd   = (JSPUtil.getParameter(request, "ioc_cd"  , length));
            String[] ibDel    = (JSPUtil.getParameter(request, "ibDel"   , length));
            String[] ibSel    = (JSPUtil.getParameter(request, "ibSel"   , length));

            for (int i = 0; i < length; i++) {
                model = new WeeklyCMCommonVO();
                if (ibflag[i]   != null) model.setIbflag(ibflag[i]);
                if (pagerows[i] != null) model.setPagerows(pagerows[i]);

                if (rlane_cd[i] != null) model.setRlaneCd(rlane_cd[i]);
                if (dir_cd  [i] != null) model.setDirCd  (dir_cd  [i]);
                if (trd_cd  [i] != null) model.setTrdCd  (trd_cd  [i]);
                if (ioc_cd  [i] != null) model.setIocCd  (ioc_cd  [i]);
                if (ibDel   [i] != null) model.setIbDel  (ibDel   [i]);
                if (ibSel   [i] != null) model.setIbSel  (ibSel   [i]);

                models.add(model);
            }

        } catch (Exception e) {
            return null;
        }
        return getWeeklyCMCommonVOs();
    }
	
	/**
	 * VO 배열을 반환
	 * @return WeeklyCMCommonVO[]
	 */
	public WeeklyCMCommonVO[] getWeeklyCMCommonVOs(){
		return (WeeklyCMCommonVO[])models.toArray(new WeeklyCMCommonVO[models.size()]);
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
	private Collection<WeeklyCMCommonVO> indirectModels = new ArrayList<WeeklyCMCommonVO>();
	
	/**
	* WeeklyCMCommonVO[] 배열을 셋팅
	*/
	public void setIndirectWeeklyCMCommonVOs(WeeklyCMCommonVO[] vos){
		indirectModels.remove(vos);
        if(vos.length > 0){
            for(int i = 0 ; i < vos.length ; i++){
            	indirectModels.add(vos[i]);
            }
        }
	}
	
	/**
	 * VO 배열을 반환
	 * @return WeeklyCMCommonVO[]
	 */
	public WeeklyCMCommonVO[] getIndirectWeeklyCMCommonVOs(){
		return (WeeklyCMCommonVO[])indirectModels.toArray(new WeeklyCMCommonVO[indirectModels.size()]);
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
	
	private List updateList2 = null;
	
	private List updateList3 = null;
	
	/*	테이블 컬럼의  삭제 값을 저장하는  List */
	private List deleteList = null;
	
	private WeeklyCMCommonVO[] m_voArray = null;
    
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

	/** 수정 리스트 Getter */
	public List getMultiUpdateList2(){	
		return updateList2;
	}
	/** 수정 리스트 Setter */
	public void setMultiUpdateList2(List list){	
		updateList2 = list;
	}
	
	/** 수정 리스트 Getter */
	public List getMultiUpdateList3(){	
		return updateList3;
	}
	/** 수정 리스트 Setter */
	public void setMultiUpdateList3(List list){	
		updateList3 = list;
	}	
	
	/** 삭제 리스트 Getter */
	public List getMultiDeleteList(){		
		return deleteList;
	}
	/** 삭제 리스트 Setter */
	public void setMultiDeleteList(List list){	
		deleteList = list;
	}	
	
	/**
	* WeeklyCMCommonVO[] 배열을 리턴
	*/
	public WeeklyCMCommonVO[] getWeeklyCMCommonVOArray(){
		return m_voArray;
	}	
	/**
	* WeeklyCMCommonVO[] 배열을 셋팅
	*/
	public void setWeeklyCMCommonVOArray(WeeklyCMCommonVO[] voArray){
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
	List<WeeklyCMCommonVO> m_voList = null;	
	
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
	public List<WeeklyCMCommonVO> getListSet() {
		return m_voList;
	}

	/** DB List Setter */
	public void setListSet(List<WeeklyCMCommonVO> voList) {
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
	private List<WeeklyCMCommonVO> m_iteratorVoList = null;	
	
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
	public List<WeeklyCMCommonVO> getIteratorVoList() {
		return this.m_iteratorVoList;
	}
	/**
	 * iterator List Info
	 * @param iteratorVoList
	 */
	public void setIteratorVoList(List<WeeklyCMCommonVO> iteratorVoList) {
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
	public List<WeeklyCMCommonVO> seperationParameterVo(String sparameter1, String sparameter2, String sSeperate) {
		List<String> tempArrList1 = null;
		List<String> tempArrList2 = null;
		List<WeeklyCMCommonVO> arrlist = null;
		StringTokenizer st1  = null;
		StringTokenizer st2  = null;
		int j = 0;
		if( !sparameter1.equals("") && !sparameter2.equals("") ) {
			tempArrList1 = new ArrayList<String>();
			tempArrList2 = new ArrayList<String>();
			arrlist = new ArrayList<WeeklyCMCommonVO>();
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
					WeeklyCMCommonVO vo = new WeeklyCMCommonVO();
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
    //추가10#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################
	
    //추가#############################################################################################START
    //#####################################################################################################
    //#####################################################################################################	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, Object> hashProcedure = new HashMap<String, Object>();	
	
	
	/**
	 * VariableValues Info
	 * @return hashProcedure
	 */
	public HashMap<String, Object> getProcedureValues() {
		return this.hashProcedure;
	}
	/**
	 * VariableValues Info
	 * @param hashIndirectVariables
	 */
	public void setProcedureValues(HashMap<String, Object> hMap) {
		this.hashProcedure = hMap;
	}	

	/**
	 * Velocity 변수에 저장할 값을 Hashtable<"variable_name", Object> 로 반환
	 *  - 쿼리의 매개변수로 셋팅.
	 *  - 가변조회 조건에 대한 값.
	 * 
	 * @return Map
	 */			
	public Map<String, Object> getProcedureParameter(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.putAll(getProcedureValues());
		return param;
	}		
    //추가#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################	
	
    //추가#############################################################################################START
    //#####################################################################################################
    //#####################################################################################################	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private Map<String, Object> hashProcedureReturns = new HashMap<String, Object>();	

	/**
	 * VariableValues Info
	 * @return hashProcedureReturns
	 */
	public Map<String, Object> getProcedureRetuns() {
		return this.hashProcedureReturns;
	}
	/**
	 * VariableValues Info
	 * @param hashProcedureReturns
	 */
	public void setProcedureRetuns(Map<String, Object> hMap) {
		this.hashProcedureReturns = hMap;
	}		
    //추가#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################		
	
}
