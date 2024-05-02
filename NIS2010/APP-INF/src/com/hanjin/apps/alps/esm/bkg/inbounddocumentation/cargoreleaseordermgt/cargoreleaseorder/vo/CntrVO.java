/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrVO.java
*@FileTitle : CntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.08.25 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrVO> models = new ArrayList<CntrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String freeDt = null;
	/* Column Info */
	private String dticEndDt = null;
	/* Column Info */
	private String sizeType = null;
	/* Column Info */
	private String dtFtDays = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrVO() {}

	public CntrVO(String ibflag, String pagerows, String cntrNo, String sizeType, String freeDt, String dticEndDt, String dtFtDays) {
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.freeDt = freeDt;
		this.dticEndDt = dticEndDt;
		this.sizeType = sizeType;
		this.dtFtDays = dtFtDays;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("free_dt", getFreeDt());
		this.hashColumns.put("dtic_end_dt", getDticEndDt());
		this.hashColumns.put("size_type", getSizeType());
		this.hashColumns.put("dt_ft_days", getDtFtDays());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("free_dt", "freeDt");
		this.hashFields.put("dtic_end_dt", "dticEndDt");
		this.hashFields.put("size_type", "sizeType");
		this.hashFields.put("dt_ft_days", "dtFtDays");
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return freeDt
	 */
	public String getFreeDt() {
		return this.freeDt;
	}
	
	/**
	 * Column Info
	 * @return dticEndDt
	 */
	public String getDticEndDt() {
		return this.dticEndDt;
	}
	
	/**
	 * Column Info
	 * @return sizeType
	 */
	public String getSizeType() {
		return this.sizeType;
	}
	
	/**
	 * Column Info
	 * @return dtFtDays
	 */
	public String getDtFtDays() {
		return this.dtFtDays;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param freeDt
	 */
	public void setFreeDt(String freeDt) {
		this.freeDt = freeDt;
	}
	
	/**
	 * Column Info
	 * @param dticEndDt
	 */
	public void setDticEndDt(String dticEndDt) {
		this.dticEndDt = dticEndDt;
	}
	
	/**
	 * Column Info
	 * @param sizeType
	 */
	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}
	
	/**
	 * Column Info
	 * @param dtFtDays
	 */
	public void setDtFtDays(String dtFtDays) {
		this.dtFtDays = dtFtDays;
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
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFreeDt(JSPUtil.getParameter(request, "free_dt", ""));
		setDticEndDt(JSPUtil.getParameter(request, "dtic_end_dt", ""));
		setSizeType(JSPUtil.getParameter(request, "size_type", ""));
		setDtFtDays(JSPUtil.getParameter(request, "dt_ft_days", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrVO[]
	 */
	public CntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrVO[]
	 */
	public CntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] freeDt = (JSPUtil.getParameter(request, prefix	+ "free_dt", length));
			String[] dticEndDt = (JSPUtil.getParameter(request, prefix	+ "dtic_end_dt", length));
			String[] sizeType = (JSPUtil.getParameter(request, prefix	+ "size_type", length));
			String[] dtFtDays = (JSPUtil.getParameter(request, prefix	+ "dt_ft_days", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (freeDt[i] != null)
					model.setFreeDt(freeDt[i]);
				if (dticEndDt[i] != null)
					model.setDticEndDt(dticEndDt[i]);
				if (sizeType[i] != null)
					model.setSizeType(sizeType[i]);
				if (dtFtDays[i] != null)
					model.setDtFtDays(dtFtDays[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrVO[]
	 */
	public CntrVO[] getCntrVOs(){
		CntrVO[] vos = (CntrVO[])models.toArray(new CntrVO[models.size()]);
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
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDt = this.freeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dticEndDt = this.dticEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sizeType = this.sizeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtFtDays = this.dtFtDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
