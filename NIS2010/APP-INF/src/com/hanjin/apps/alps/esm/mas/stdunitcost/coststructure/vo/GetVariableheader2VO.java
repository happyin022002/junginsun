/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetVariableheader2VO.java
*@FileTitle : GetVariableheader2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.23 장영석 
* 1.0 Creation
* ========================================================== 
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetVariableheader2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetVariableheader2VO> models = new ArrayList<GetVariableheader2VO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String code = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetVariableheader2VO() {}

	public GetVariableheader2VO(String ibflag, String pagerows, String code, String name) {
		this.ibflag = ibflag;
		this.name = name;
		this.code = code;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("name", "name");
		this.hashFields.put("code", "code");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setName(JSPUtil.getParameter(request, "name", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetVariableheader2VO[]
	 */
	public GetVariableheader2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetVariableheader2VO[]
	 */
	public GetVariableheader2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetVariableheader2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetVariableheader2VO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetVariableheader2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetVariableheader2VO[]
	 */
	public GetVariableheader2VO[] getGetVariableheader2VOs(){
		GetVariableheader2VO[] vos = (GetVariableheader2VO[])models.toArray(new GetVariableheader2VO[models.size()]);
		return vos;
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
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
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

    //추가3############################################################################################## END
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
}
