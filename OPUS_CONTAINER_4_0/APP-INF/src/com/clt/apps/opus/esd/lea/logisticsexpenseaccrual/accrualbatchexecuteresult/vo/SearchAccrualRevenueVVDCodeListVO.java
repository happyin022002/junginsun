/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualRevenueVVDCodeListVO.java
*@FileTitle : SearchAccrualRevenueVVDCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전재홍 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualRevenueVVDCodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualRevenueVVDCodeListVO> models = new ArrayList<SearchAccrualRevenueVVDCodeListVO>();
	
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String estmVvdHdrId = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String frmExeYrmon = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmBcDivCd = null;
	/* Column Info */
	private String frmRevYrmonFrom = null;
	/* Column Info */
	private String revVvdNo = null;
	/* Column Info */
	private String frmRevYrmonTo = null;
	/* Column Info */
	private String estmIocDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualRevenueVVDCodeListVO() {}

	public SearchAccrualRevenueVVDCodeListVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String revVvdNo, String rlaneCd, String estmVvdTpCd, String estmIocDivCd, String estmVvdHdrId, String estmBcDivCd, String frmExeYrmon, String frmRevYrmonFrom, String frmRevYrmonTo) {
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.estmVvdHdrId = estmVvdHdrId;
		this.rlaneCd = rlaneCd;
		this.frmExeYrmon = frmExeYrmon;
		this.pagerows = pagerows;
		this.estmVvdTpCd = estmVvdTpCd;
		this.ibflag = ibflag;
		this.estmBcDivCd = estmBcDivCd;
		this.frmRevYrmonFrom = frmRevYrmonFrom;
		this.revVvdNo = revVvdNo;
		this.frmRevYrmonTo = frmRevYrmonTo;
		this.estmIocDivCd = estmIocDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("estm_vvd_hdr_id", getEstmVvdHdrId());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("frm_exe_yrmon", getFrmExeYrmon());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_bc_div_cd", getEstmBcDivCd());
		this.hashColumns.put("frm_rev_yrmon_from", getFrmRevYrmonFrom());
		this.hashColumns.put("rev_vvd_no", getRevVvdNo());
		this.hashColumns.put("frm_rev_yrmon_to", getFrmRevYrmonTo());
		this.hashColumns.put("estm_ioc_div_cd", getEstmIocDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("estm_vvd_hdr_id", "estmVvdHdrId");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("frm_exe_yrmon", "frmExeYrmon");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_bc_div_cd", "estmBcDivCd");
		this.hashFields.put("frm_rev_yrmon_from", "frmRevYrmonFrom");
		this.hashFields.put("rev_vvd_no", "revVvdNo");
		this.hashFields.put("frm_rev_yrmon_to", "frmRevYrmonTo");
		this.hashFields.put("estm_ioc_div_cd", "estmIocDivCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return estmVvdHdrId
	 */
	public String getEstmVvdHdrId() {
		return this.estmVvdHdrId;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return frmExeYrmon
	 */
	public String getFrmExeYrmon() {
		return this.frmExeYrmon;
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
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
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
	 * @return estmBcDivCd
	 */
	public String getEstmBcDivCd() {
		return this.estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @return frmRevYrmonFrom
	 */
	public String getFrmRevYrmonFrom() {
		return this.frmRevYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @return revVvdNo
	 */
	public String getRevVvdNo() {
		return this.revVvdNo;
	}
	
	/**
	 * Column Info
	 * @return frmRevYrmonTo
	 */
	public String getFrmRevYrmonTo() {
		return this.frmRevYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return estmIocDivCd
	 */
	public String getEstmIocDivCd() {
		return this.estmIocDivCd;
	}
	

	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param estmVvdHdrId
	 */
	public void setEstmVvdHdrId(String estmVvdHdrId) {
		this.estmVvdHdrId = estmVvdHdrId;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param frmExeYrmon
	 */
	public void setFrmExeYrmon(String frmExeYrmon) {
		this.frmExeYrmon = frmExeYrmon;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
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
	 * @param estmBcDivCd
	 */
	public void setEstmBcDivCd(String estmBcDivCd) {
		this.estmBcDivCd = estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @param frmRevYrmonFrom
	 */
	public void setFrmRevYrmonFrom(String frmRevYrmonFrom) {
		this.frmRevYrmonFrom = frmRevYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @param revVvdNo
	 */
	public void setRevVvdNo(String revVvdNo) {
		this.revVvdNo = revVvdNo;
	}
	
	/**
	 * Column Info
	 * @param frmRevYrmonTo
	 */
	public void setFrmRevYrmonTo(String frmRevYrmonTo) {
		this.frmRevYrmonTo = frmRevYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param estmIocDivCd
	 */
	public void setEstmIocDivCd(String estmIocDivCd) {
		this.estmIocDivCd = estmIocDivCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setEstmVvdHdrId(JSPUtil.getParameter(request, "estm_vvd_hdr_id", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setFrmExeYrmon(JSPUtil.getParameter(request, "frm_exe_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, "estm_vvd_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEstmBcDivCd(JSPUtil.getParameter(request, "estm_bc_div_cd", ""));
		setFrmRevYrmonFrom(JSPUtil.getParameter(request, "frm_rev_yrmon_from", ""));
		setRevVvdNo(JSPUtil.getParameter(request, "rev_vvd_no", ""));
		setFrmRevYrmonTo(JSPUtil.getParameter(request, "frm_rev_yrmon_to", ""));
		setEstmIocDivCd(JSPUtil.getParameter(request, "estm_ioc_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualRevenueVVDCodeListVO[]
	 */
	public SearchAccrualRevenueVVDCodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualRevenueVVDCodeListVO[]
	 */
	public SearchAccrualRevenueVVDCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualRevenueVVDCodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] estmVvdHdrId = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_hdr_id", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] frmExeYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_exe_yrmon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmBcDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_bc_div_cd", length));
			String[] frmRevYrmonFrom = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_from", length));
			String[] revVvdNo = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_no", length));
			String[] frmRevYrmonTo = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon_to", length));
			String[] estmIocDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_ioc_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualRevenueVVDCodeListVO();
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (estmVvdHdrId[i] != null)
					model.setEstmVvdHdrId(estmVvdHdrId[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (frmExeYrmon[i] != null)
					model.setFrmExeYrmon(frmExeYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmBcDivCd[i] != null)
					model.setEstmBcDivCd(estmBcDivCd[i]);
				if (frmRevYrmonFrom[i] != null)
					model.setFrmRevYrmonFrom(frmRevYrmonFrom[i]);
				if (revVvdNo[i] != null)
					model.setRevVvdNo(revVvdNo[i]);
				if (frmRevYrmonTo[i] != null)
					model.setFrmRevYrmonTo(frmRevYrmonTo[i]);
				if (estmIocDivCd[i] != null)
					model.setEstmIocDivCd(estmIocDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualRevenueVVDCodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualRevenueVVDCodeListVO[]
	 */
	public SearchAccrualRevenueVVDCodeListVO[] getSearchAccrualRevenueVVDCodeListVOs(){
		SearchAccrualRevenueVVDCodeListVO[] vos = (SearchAccrualRevenueVVDCodeListVO[])models.toArray(new SearchAccrualRevenueVVDCodeListVO[models.size()]);
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
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdHdrId = this.estmVvdHdrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmExeYrmon = this.frmExeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmBcDivCd = this.estmBcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonFrom = this.frmRevYrmonFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdNo = this.revVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmonTo = this.frmRevYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmIocDivCd = this.estmIocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
