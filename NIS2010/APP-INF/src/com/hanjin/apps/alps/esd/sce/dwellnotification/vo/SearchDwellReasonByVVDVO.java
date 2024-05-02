/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchDwellReasonByVVDVO.java
*@FileTitle : SearchDwellReasonByVVDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDwellReasonByVVDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDwellReasonByVVDVO> models = new ArrayList<SearchDwellReasonByVVDVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String etdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String updUsrNm1 = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String dwllRsn = null;
	/* Column Info */
	private String updOfcCd1 = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId1 = null;
	/* Column Info */
	private String dwllRsnSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String custValue1 = null;
	/* Column Info */
	private String custValue2 = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDwellReasonByVVDVO() {}

	public SearchDwellReasonByVVDVO(String ibflag, String pagerows, String dwllRsnSeq, String slanCd, String vvd, String etaDt, String etdDt, String dwllRsn, String updDt, String updUsrId, String updUsrNm, String updOfcCd, String vpsPortCd, String updUsrId1, String updOfcCd1, String updUsrNm1 ,String custValue1 ,String custValue2) {
		this.updDt = updDt;
		this.etaDt = etaDt;
		this.etdDt = etdDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.updUsrNm1 = updUsrNm1;
		this.slanCd = slanCd;
		this.dwllRsn = dwllRsn;
		this.updOfcCd1 = updOfcCd1;
		this.updUsrNm = updUsrNm;
		this.updUsrId1 = updUsrId1;
		this.dwllRsnSeq = dwllRsnSeq;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.custValue1 = custValue1;
		this.custValue2 = custValue2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_usr_nm1", getUpdUsrNm1());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("dwll_rsn", getDwllRsn());
		this.hashColumns.put("upd_ofc_cd1", getUpdOfcCd1());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id1", getUpdUsrId1());
		this.hashColumns.put("dwll_rsn_seq", getDwllRsnSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("cust_value1", getCustValue1());
		this.hashColumns.put("cust_value2", getCustValue1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_usr_nm1", "updUsrNm1");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("dwll_rsn", "dwllRsn");
		this.hashFields.put("upd_ofc_cd1", "updOfcCd1");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id1", "updUsrId1");
		this.hashFields.put("dwll_rsn_seq", "dwllRsnSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("cust_value1", "custValue1");
		this.hashFields.put("cust_value2", "custValue2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return updUsrNm1
	 */
	public String getUpdUsrNm1() {
		return this.updUsrNm1;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return dwllRsn
	 */
	public String getDwllRsn() {
		return this.dwllRsn;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd1
	 */
	public String getUpdOfcCd1() {
		return this.updOfcCd1;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId1
	 */
	public String getUpdUsrId1() {
		return this.updUsrId1;
	}
	
	/**
	 * Column Info
	 * @return dwllRsnSeq
	 */
	public String getDwllRsnSeq() {
		return this.dwllRsnSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param updUsrNm1
	 */
	public void setUpdUsrNm1(String updUsrNm1) {
		this.updUsrNm1 = updUsrNm1;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param dwllRsn
	 */
	public void setDwllRsn(String dwllRsn) {
		this.dwllRsn = dwllRsn;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd1
	 */
	public void setUpdOfcCd1(String updOfcCd1) {
		this.updOfcCd1 = updOfcCd1;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId1
	 */
	public void setUpdUsrId1(String updUsrId1) {
		this.updUsrId1 = updUsrId1;
	}
	
	/**
	 * Column Info
	 * @param dwllRsnSeq
	 */
	public void setDwllRsnSeq(String dwllRsnSeq) {
		this.dwllRsnSeq = dwllRsnSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
/**
	 * @return the custValue1
	 */
	public String getCustValue1() {
		return custValue1;
	}

	/**
	 * @param custValue1 the custValue1 to set
	 */
	public void setCustValue1(String custValue1) {
		this.custValue1 = custValue1;
	}

	/**
	 * @return the custValue2
	 */
	public String getCustValue2() {
		return custValue2;
	}

	/**
	 * @param custValue2 the custValue2 to set
	 */
	public void setCustValue2(String custValue2) {
		this.custValue2 = custValue2;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUpdUsrNm1(JSPUtil.getParameter(request, prefix + "upd_usr_nm1", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setDwllRsn(JSPUtil.getParameter(request, prefix + "dwll_rsn", ""));
		setUpdOfcCd1(JSPUtil.getParameter(request, prefix + "upd_ofc_cd1", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setUpdUsrId1(JSPUtil.getParameter(request, prefix + "upd_usr_id1", ""));
		setDwllRsnSeq(JSPUtil.getParameter(request, prefix + "dwll_rsn_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setCustValue1(JSPUtil.getParameter(request, prefix + "cust_value1", ""));
		setCustValue2(JSPUtil.getParameter(request, prefix + "cust_value2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDwellReasonByVVDVO[]
	 */
	public SearchDwellReasonByVVDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDwellReasonByVVDVO[]
	 */
	public SearchDwellReasonByVVDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDwellReasonByVVDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updUsrNm1 = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm1", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] dwllRsn = (JSPUtil.getParameter(request, prefix	+ "dwll_rsn", length));
			String[] updOfcCd1 = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd1", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId1 = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id1", length));
			String[] dwllRsnSeq = (JSPUtil.getParameter(request, prefix	+ "dwll_rsn_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] custValue1 = (JSPUtil.getParameter(request, prefix	+ "cust_value1", length));
			String[] custValue2 = (JSPUtil.getParameter(request, prefix	+ "cust_value2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDwellReasonByVVDVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updUsrNm1[i] != null)
					model.setUpdUsrNm1(updUsrNm1[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (dwllRsn[i] != null)
					model.setDwllRsn(dwllRsn[i]);
				if (updOfcCd1[i] != null)
					model.setUpdOfcCd1(updOfcCd1[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId1[i] != null)
					model.setUpdUsrId1(updUsrId1[i]);
				if (dwllRsnSeq[i] != null)
					model.setDwllRsnSeq(dwllRsnSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (custValue1[i] != null)
					model.setCustValue1(custValue1[i]);
				if (custValue2[i] != null)
					model.setCustValue2(custValue2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDwellReasonByVVDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDwellReasonByVVDVO[]
	 */
	public SearchDwellReasonByVVDVO[] getSearchDwellReasonByVVDVOs(){
		SearchDwellReasonByVVDVO[] vos = (SearchDwellReasonByVVDVO[])models.toArray(new SearchDwellReasonByVVDVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm1 = this.updUsrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllRsn = this.dwllRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd1 = this.updOfcCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId1 = this.updUsrId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllRsnSeq = this.dwllRsnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custValue1 = this.custValue1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custValue2 = this.custValue2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
