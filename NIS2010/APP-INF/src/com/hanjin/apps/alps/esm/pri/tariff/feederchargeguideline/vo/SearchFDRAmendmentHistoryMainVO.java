/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchFDRAmendmentHistoryMainVO.java
*@FileTitle : SearchFDRAmendmentHistoryMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.06
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.12.06 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFDRAmendmentHistoryMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFDRAmendmentHistoryMainVO> models = new ArrayList<SearchFDRAmendmentHistoryMainVO>();
	
	/* Column Info */
	private String fdrTrfNoFormat = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String detailTp = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsr = null;
	/* Column Info */
	private String cfmUsr = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String fdrTrfNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFDRAmendmentHistoryMainVO() {}

	public SearchFDRAmendmentHistoryMainVO(String ibflag, String pagerows, String amdtSeq, String fdrTrfNoFormat, String fdrTrfNo, String effDt, String expDt, String creDt, String creUsr, String cfmDt, String cfmUsr, String svcScpCd, String orgDestTpCd, String rhqCd, String detailTp) {
		this.fdrTrfNoFormat = fdrTrfNoFormat;
		this.rhqCd = rhqCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.detailTp = detailTp;
		this.cfmDt = cfmDt;
		this.creDt = creDt;
		this.orgDestTpCd = orgDestTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.creUsr = creUsr;
		this.cfmUsr = cfmUsr;
		this.expDt = expDt;
		this.fdrTrfNo = fdrTrfNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fdr_trf_no_format", getFdrTrfNoFormat());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("detail_tp", getDetailTp());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr", getCreUsr());
		this.hashColumns.put("cfm_usr", getCfmUsr());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("fdr_trf_no", getFdrTrfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fdr_trf_no_format", "fdrTrfNoFormat");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("detail_tp", "detailTp");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr", "creUsr");
		this.hashFields.put("cfm_usr", "cfmUsr");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("fdr_trf_no", "fdrTrfNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fdrTrfNoFormat
	 */
	public String getFdrTrfNoFormat() {
		return this.fdrTrfNoFormat;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return detailTp
	 */
	public String getDetailTp() {
		return this.detailTp;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return creUsr
	 */
	public String getCreUsr() {
		return this.creUsr;
	}
	
	/**
	 * Column Info
	 * @return cfmUsr
	 */
	public String getCfmUsr() {
		return this.cfmUsr;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return fdrTrfNo
	 */
	public String getFdrTrfNo() {
		return this.fdrTrfNo;
	}
	

	/**
	 * Column Info
	 * @param fdrTrfNoFormat
	 */
	public void setFdrTrfNoFormat(String fdrTrfNoFormat) {
		this.fdrTrfNoFormat = fdrTrfNoFormat;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param detailTp
	 */
	public void setDetailTp(String detailTp) {
		this.detailTp = detailTp;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param creUsr
	 */
	public void setCreUsr(String creUsr) {
		this.creUsr = creUsr;
	}
	
	/**
	 * Column Info
	 * @param cfmUsr
	 */
	public void setCfmUsr(String cfmUsr) {
		this.cfmUsr = cfmUsr;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param fdrTrfNo
	 */
	public void setFdrTrfNo(String fdrTrfNo) {
		this.fdrTrfNo = fdrTrfNo;
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
		setFdrTrfNoFormat(JSPUtil.getParameter(request, prefix + "fdr_trf_no_format", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDetailTp(JSPUtil.getParameter(request, prefix + "detail_tp", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCreUsr(JSPUtil.getParameter(request, prefix + "cre_usr", ""));
		setCfmUsr(JSPUtil.getParameter(request, prefix + "cfm_usr", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setFdrTrfNo(JSPUtil.getParameter(request, prefix + "fdr_trf_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFDRAmendmentHistoryMainVO[]
	 */
	public SearchFDRAmendmentHistoryMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFDRAmendmentHistoryMainVO[]
	 */
	public SearchFDRAmendmentHistoryMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFDRAmendmentHistoryMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fdrTrfNoFormat = (JSPUtil.getParameter(request, prefix	+ "fdr_trf_no_format", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] detailTp = (JSPUtil.getParameter(request, prefix	+ "detail_tp", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creUsr = (JSPUtil.getParameter(request, prefix	+ "cre_usr", length));
			String[] cfmUsr = (JSPUtil.getParameter(request, prefix	+ "cfm_usr", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] fdrTrfNo = (JSPUtil.getParameter(request, prefix	+ "fdr_trf_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFDRAmendmentHistoryMainVO();
				if (fdrTrfNoFormat[i] != null)
					model.setFdrTrfNoFormat(fdrTrfNoFormat[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (detailTp[i] != null)
					model.setDetailTp(detailTp[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsr[i] != null)
					model.setCreUsr(creUsr[i]);
				if (cfmUsr[i] != null)
					model.setCfmUsr(cfmUsr[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (fdrTrfNo[i] != null)
					model.setFdrTrfNo(fdrTrfNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFDRAmendmentHistoryMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFDRAmendmentHistoryMainVO[]
	 */
	public SearchFDRAmendmentHistoryMainVO[] getSearchFDRAmendmentHistoryMainVOs(){
		SearchFDRAmendmentHistoryMainVO[] vos = (SearchFDRAmendmentHistoryMainVO[])models.toArray(new SearchFDRAmendmentHistoryMainVO[models.size()]);
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
		this.fdrTrfNoFormat = this.fdrTrfNoFormat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailTp = this.detailTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsr = this.creUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsr = this.cfmUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrTrfNo = this.fdrTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
