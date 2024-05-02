/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnrAcctVO.java
*@FileTitle : OwnrAcctVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.03.11 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.ownersaccount.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */

public class OwnrAcctVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OwnrAcctVO> models = new ArrayList<OwnrAcctVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String spcode = null;
	/* Column Info */
	private String csrStatus = null;
	/* Column Info */
	private String spdeleted = null;
	/* Column Info */
	private String spname = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String preFr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String preTo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String dateGubun = null;
	/* Column Info */
	private String myCsr = null;
	/* Column Info */
	private String supplier = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OwnrAcctVO() {}

	public OwnrAcctVO(String ibflag, String pagerows, String dateGubun, String preFr, String preTo, String office, String myCsr, String supplier, String vslCd, String locCd, String csrNo, String csrStatus, String spcode, String spname, String spdeleted, String usrId) {
		this.office = office;
		this.vslCd = vslCd;
		this.csrNo = csrNo;
		this.spcode = spcode;
		this.csrStatus = csrStatus;
		this.spdeleted = spdeleted;
		this.spname = spname;
		this.pagerows = pagerows;
		this.preFr = preFr;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.preTo = preTo;
		this.usrId = usrId;
		this.dateGubun = dateGubun;
		this.myCsr = myCsr;
		this.supplier = supplier;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("spcode", getSpcode());
		this.hashColumns.put("csr_status", getCsrStatus());
		this.hashColumns.put("spdeleted", getSpdeleted());
		this.hashColumns.put("spname", getSpname());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_fr", getPreFr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("pre_to", getPreTo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("date_gubun", getDateGubun());
		this.hashColumns.put("my_csr", getMyCsr());
		this.hashColumns.put("supplier", getSupplier());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("spcode", "spcode");
		this.hashFields.put("csr_status", "csrStatus");
		this.hashFields.put("spdeleted", "spdeleted");
		this.hashFields.put("spname", "spname");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_fr", "preFr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pre_to", "preTo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("date_gubun", "dateGubun");
		this.hashFields.put("my_csr", "myCsr");
		this.hashFields.put("supplier", "supplier");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return spcode
	 */
	public String getSpcode() {
		return this.spcode;
	}
	
	/**
	 * Column Info
	 * @return csrStatus
	 */
	public String getCsrStatus() {
		return this.csrStatus;
	}
	
	/**
	 * Column Info
	 * @return spdeleted
	 */
	public String getSpdeleted() {
		return this.spdeleted;
	}
	
	/**
	 * Column Info
	 * @return spname
	 */
	public String getSpname() {
		return this.spname;
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
	 * @return preFr
	 */
	public String getPreFr() {
		return this.preFr;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return preTo
	 */
	public String getPreTo() {
		return this.preTo;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return dateGubun
	 */
	public String getDateGubun() {
		return this.dateGubun;
	}
	
	/**
	 * Column Info
	 * @return myCsr
	 */
	public String getMyCsr() {
		return this.myCsr;
	}
	
	/**
	 * Column Info
	 * @return supplier
	 */
	public String getSupplier() {
		return this.supplier;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param spcode
	 */
	public void setSpcode(String spcode) {
		this.spcode = spcode;
	}
	
	/**
	 * Column Info
	 * @param csrStatus
	 */
	public void setCsrStatus(String csrStatus) {
		this.csrStatus = csrStatus;
	}
	
	/**
	 * Column Info
	 * @param spdeleted
	 */
	public void setSpdeleted(String spdeleted) {
		this.spdeleted = spdeleted;
	}
	
	/**
	 * Column Info
	 * @param spname
	 */
	public void setSpname(String spname) {
		this.spname = spname;
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
	 * @param preFr
	 */
	public void setPreFr(String preFr) {
		this.preFr = preFr;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param preTo
	 */
	public void setPreTo(String preTo) {
		this.preTo = preTo;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param dateGubun
	 */
	public void setDateGubun(String dateGubun) {
		this.dateGubun = dateGubun;
	}
	
	/**
	 * Column Info
	 * @param myCsr
	 */
	public void setMyCsr(String myCsr) {
		this.myCsr = myCsr;
	}
	
	/**
	 * Column Info
	 * @param supplier
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setSpcode(JSPUtil.getParameter(request, prefix + "spcode", ""));
		setCsrStatus(JSPUtil.getParameter(request, prefix + "csr_status", ""));
		setSpdeleted(JSPUtil.getParameter(request, prefix + "spdeleted", ""));
		setSpname(JSPUtil.getParameter(request, prefix + "spname", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreFr(JSPUtil.getParameter(request, prefix + "pre_fr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setPreTo(JSPUtil.getParameter(request, prefix + "pre_to", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setDateGubun(JSPUtil.getParameter(request, prefix + "date_gubun", ""));
		setMyCsr(JSPUtil.getParameter(request, prefix + "my_csr", ""));
		setSupplier(JSPUtil.getParameter(request, prefix + "supplier", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OwnrAcctVO[]
	 */
	public OwnrAcctVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OwnrAcctVO[]
	 */
	public OwnrAcctVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OwnrAcctVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] spcode = (JSPUtil.getParameter(request, prefix	+ "spcode", length));
			String[] csrStatus = (JSPUtil.getParameter(request, prefix	+ "csr_status", length));
			String[] spdeleted = (JSPUtil.getParameter(request, prefix	+ "spdeleted", length));
			String[] spname = (JSPUtil.getParameter(request, prefix	+ "spname", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preFr = (JSPUtil.getParameter(request, prefix	+ "pre_fr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] preTo = (JSPUtil.getParameter(request, prefix	+ "pre_to", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] dateGubun = (JSPUtil.getParameter(request, prefix	+ "date_gubun", length));
			String[] myCsr = (JSPUtil.getParameter(request, prefix	+ "my_csr", length));
			String[] supplier = (JSPUtil.getParameter(request, prefix	+ "supplier", length));
			
			for (int i = 0; i < length; i++) {
				model = new OwnrAcctVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (spcode[i] != null)
					model.setSpcode(spcode[i]);
				if (csrStatus[i] != null)
					model.setCsrStatus(csrStatus[i]);
				if (spdeleted[i] != null)
					model.setSpdeleted(spdeleted[i]);
				if (spname[i] != null)
					model.setSpname(spname[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preFr[i] != null)
					model.setPreFr(preFr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (preTo[i] != null)
					model.setPreTo(preTo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (dateGubun[i] != null)
					model.setDateGubun(dateGubun[i]);
				if (myCsr[i] != null)
					model.setMyCsr(myCsr[i]);
				if (supplier[i] != null)
					model.setSupplier(supplier[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOwnrAcctVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OwnrAcctVO[]
	 */
	public OwnrAcctVO[] getOwnrAcctVOs(){
		OwnrAcctVO[] vos = (OwnrAcctVO[])models.toArray(new OwnrAcctVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcode = this.spcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrStatus = this.csrStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spdeleted = this.spdeleted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spname = this.spname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preFr = this.preFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTo = this.preTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateGubun = this.dateGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.myCsr = this.myCsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supplier = this.supplier .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
