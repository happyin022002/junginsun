/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVesselInfoVO.java
*@FileTitle : SearchVesselInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.08.14 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LaneSimulationCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LaneSimulationCommonVO> models = new ArrayList<LaneSimulationCommonVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;	
	
	/* Column Info */
	private String header = null;
	
	private String v_prd_cd = null;
	private String v_trd_cd = null;
	private String v_rlane_cd = null;
	private String v_dir_cd = null;
	


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LaneSimulationCommonVO() {}

	public LaneSimulationCommonVO(String ibflag, String pagerows, String header) {
		this.header = header;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		//this.hashColumns.put("vsl_cd", getVslCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");		
		//this.hashFields.put("vsl_cd", "vslCd");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Column Info
	 * @return v_prd_cd
	 */
	public String getVPrdCd() {
		return this.v_prd_cd;
	}
	/**
	 * Column Info
	 * @param v_prd_cd
	 */
	public void setVPrdCd(String v_prd_cd) {
		this.v_prd_cd = v_prd_cd;
	}	
	
	/**
	 * Column Info
	 * @return v_trd_cd
	 */
	public String getVTrdCd() {
		return this.v_trd_cd;
	}
	/**
	 * Column Info
	 * @param v_trd_cd
	 */
	public void setVTrdCd(String v_trd_cd) {
		this.v_trd_cd = v_trd_cd;
	}		

	/**
	 * Column Info
	 * @return v_rlane_cd
	 */
	public String getVRlaneCd() {
		return this.v_rlane_cd;
	}
	/**
	 * Column Info
	 * @param v_trd_cd
	 */
	public void setVRlaneCd(String v_rlane_cd) {
		this.v_rlane_cd = v_rlane_cd;
	}		
	
	/**
	 * Column Info
	 * @return v_dir_cd
	 */
	public String getVDirCd() {
		return this.v_dir_cd;
	}
	/**
	 * Column Info
	 * @param v_trd_cd
	 */
	public void setVDirCd(String v_dir_cd) {
		this.v_dir_cd = v_dir_cd;
	}			

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVesselInfoVO[]
	 */
	public LaneSimulationCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVesselInfoVO[]
	 */
	public LaneSimulationCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LaneSimulationCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new LaneSimulationCommonVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVesselInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVesselInfoVO[]
	 */
	public LaneSimulationCommonVO[] getSearchVesselInfoVOs(){
		LaneSimulationCommonVO[] vos = (LaneSimulationCommonVO[])models.toArray(new LaneSimulationCommonVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
    //추가#############################################################################################START
    //#####################################################################################################
    //#####################################################################################################	
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;
	
	/* DB RowSet 객체  */
	private DBRowSet[] rowSetArray = null;	
	
	/* DB List 객체  */
	List<LaneSimulationCommonVO> list = null;	
	
	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/** DBRowSet Array Getter */
	public DBRowSet[] getRowSetArray() {
		return rowSetArray;
	}
	/** DBRowSet Array Setter */
	public void setRowSetArray(DBRowSet[] rowSetArray) {
		this.rowSetArray = rowSetArray;
	}	
	
	/** DB List Getter */
	public List<LaneSimulationCommonVO> getListSet() {
		return list;
	}

	/** DB List Setter */
	public void setListSet(List<LaneSimulationCommonVO> list) {
		this.list = list;
	}	
    //추가#############################################################################################END
    //#####################################################################################################
    //#####################################################################################################  	
}
