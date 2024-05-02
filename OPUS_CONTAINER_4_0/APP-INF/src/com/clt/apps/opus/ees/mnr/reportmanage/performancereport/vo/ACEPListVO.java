/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ACEPListVO.java
*@FileTitle : ACEPListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.22 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ACEPListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ACEPListVO> models = new ArrayList<ACEPListVO>();
	
	/* Column Info */
	private String rprDt = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String nextAuditDt = null;
	/* Column Info */
	private String overMonth = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ACEPListVO() {}

	public ACEPListVO(String ibflag, String pagerows, String eqNo, String eqTpszCd, String locCd, String ydCd, String onhDt, String rprDt, String overMonth, String nextAuditDt) {
		this.rprDt = rprDt;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.ydCd = ydCd;
		this.nextAuditDt = nextAuditDt;
		this.overMonth = overMonth;
		this.onhDt = onhDt;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rpr_dt", getRprDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("next_audit_dt", getNextAuditDt());
		this.hashColumns.put("over_month", getOverMonth());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rpr_dt", "rprDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("next_audit_dt", "nextAuditDt");
		this.hashFields.put("over_month", "overMonth");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rprDt
	 */
	public String getRprDt() {
		return this.rprDt;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return nextAuditDt
	 */
	public String getNextAuditDt() {
		return this.nextAuditDt;
	}
	
	/**
	 * Column Info
	 * @return overMonth
	 */
	public String getOverMonth() {
		return this.overMonth;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @param rprDt
	 */
	public void setRprDt(String rprDt) {
		this.rprDt = rprDt;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param nextAuditDt
	 */
	public void setNextAuditDt(String nextAuditDt) {
		this.nextAuditDt = nextAuditDt;
	}
	
	/**
	 * Column Info
	 * @param overMonth
	 */
	public void setOverMonth(String overMonth) {
		this.overMonth = overMonth;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
		setRprDt(JSPUtil.getParameter(request, "rpr_dt", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setNextAuditDt(JSPUtil.getParameter(request, "next_audit_dt", ""));
		setOverMonth(JSPUtil.getParameter(request, "over_month", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ACEPListVO[]
	 */
	public ACEPListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ACEPListVO[]
	 */
	public ACEPListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ACEPListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rprDt = (JSPUtil.getParameter(request, prefix	+ "rpr_dt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] nextAuditDt = (JSPUtil.getParameter(request, prefix	+ "next_audit_dt", length));
			String[] overMonth = (JSPUtil.getParameter(request, prefix	+ "over_month", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ACEPListVO();
				if (rprDt[i] != null)
					model.setRprDt(rprDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (nextAuditDt[i] != null)
					model.setNextAuditDt(nextAuditDt[i]);
				if (overMonth[i] != null)
					model.setOverMonth(overMonth[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getACEPListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ACEPListVO[]
	 */
	public ACEPListVO[] getACEPListVOs(){
		ACEPListVO[] vos = (ACEPListVO[])models.toArray(new ACEPListVO[models.size()]);
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
		this.rprDt = this.rprDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextAuditDt = this.nextAuditDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overMonth = this.overMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
