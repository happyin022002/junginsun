/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchSimVesselListConditionVO.java
*@FileTitle : searchSimVesselListConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.08.06 윤진영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimVesselListConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimVesselListConditionVO> models = new ArrayList<SearchSimVesselListConditionVO>();
	
	/* Column Info */
	private String fSimDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String fSimNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimVesselListConditionVO() {}

	public SearchSimVesselListConditionVO(String ibflag, String pagerows, String dirCd, String fSimDt, String fSimNo, String sectNo) {
		this.fSimDt = fSimDt;
		this.ibflag = ibflag;
		this.sectNo = sectNo;
		this.dirCd = dirCd;
		this.fSimNo = fSimNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_sim_dt", getFSimDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("f_sim_no", getFSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_sim_dt", "fSimDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("f_sim_no", "fSimNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fSimDt
	 */
	public String getFSimDt() {
		return this.fSimDt;
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
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return fSimNo
	 */
	public String getFSimNo() {
		return this.fSimNo;
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
	 * @param fSimDt
	 */
	public void setFSimDt(String fSimDt) {
		this.fSimDt = fSimDt;
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
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param fSimNo
	 */
	public void setFSimNo(String fSimNo) {
		this.fSimNo = fSimNo;
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
		setFSimDt(JSPUtil.getParameter(request, "f_sim_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSectNo(JSPUtil.getParameter(request, "f_sect_no", ""));
		setDirCd(JSPUtil.getParameter(request, "f_skd_dir_cd", ""));
		setFSimNo(JSPUtil.getParameter(request, "f_sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchSimVesselListConditionVO[]
	 */
	public SearchSimVesselListConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchSimVesselListConditionVO[]
	 */
	public SearchSimVesselListConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimVesselListConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fSimDt = (JSPUtil.getParameter(request, prefix	+ "f_sim_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "f_sect_no", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] fSimNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimVesselListConditionVO();
				if (fSimDt[i] != null)
					model.setFSimDt(fSimDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (fSimNo[i] != null)
					model.setFSimNo(fSimNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchSimVesselListConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchSimVesselListConditionVO[]
	 */
	public SearchSimVesselListConditionVO[] getsearchSimVesselListConditionVOs(){
		SearchSimVesselListConditionVO[] vos = (SearchSimVesselListConditionVO[])models.toArray(new SearchSimVesselListConditionVO[models.size()]);
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
		this.fSimDt = this.fSimDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSimNo = this.fSimNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
