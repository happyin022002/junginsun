/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : IHCCostTariffInterfaceListVO.java
*@FileTitle : IHCCostTariffInterfaceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.15
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.10.15 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IHCCostTariffInterfaceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IHCCostTariffInterfaceListVO> models = new ArrayList<IHCCostTariffInterfaceListVO>();
	
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ihcCostTrfNo = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String prcIoBndCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String ficPropStsCdNm = null;
	/* Column Info */
	private String rowNo = null;
	/* Column Info */
	private String ficPropStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IHCCostTariffInterfaceListVO() {}

	public IHCCostTariffInterfaceListVO(String ibflag, String pagerows, String creDt, String ihcCostTrfNo, String rhqCd, String ihcTrfNo, String costTrfNo, String amdtSeq, String svcScpCd, String cntNm, String effDt, String chk, String cntCd, String prcIoBndCd, String effFmDt, String ficPropStsCdNm, String rowNo, String ficPropStsCd, String orgDestTpCd) {
		this.creDt = creDt;
		this.ihcCostTrfNo = ihcCostTrfNo;
		this.rhqCd = rhqCd;
		this.ihcTrfNo = ihcTrfNo;
		this.costTrfNo = costTrfNo;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.effDt = effDt;
		this.chk = chk;
		this.cntCd = cntCd;
		this.prcIoBndCd = prcIoBndCd;
		this.effFmDt = effFmDt;
		this.ficPropStsCdNm = ficPropStsCdNm;
		this.rowNo = rowNo;
		this.ficPropStsCd = ficPropStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ihc_cost_trf_no", getIhcCostTrfNo());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("prc_io_bnd_cd", getPrcIoBndCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("fic_prop_sts_cd_nm", getFicPropStsCdNm());
		this.hashColumns.put("row_no", getRowNo());
		this.hashColumns.put("fic_prop_sts_cd", getFicPropStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ihc_cost_trf_no", "ihcCostTrfNo");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("prc_io_bnd_cd", "prcIoBndCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("fic_prop_sts_cd_nm", "ficPropStsCdNm");
		this.hashFields.put("row_no", "rowNo");
		this.hashFields.put("fic_prop_sts_cd", "ficPropStsCd");
		return this.hashFields;
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
	 * @return ihcCostTrfNo
	 */
	public String getIhcCostTrfNo() {
		return this.ihcCostTrfNo;
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
	 * @return ihcTrfNo
	 */
	public String getIhcTrfNo() {
		return this.ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return prcIoBndCd
	 */
	public String getPrcIoBndCd() {
		return this.prcIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return ficPropStsCdNm
	 */
	public String getFicPropStsCdNm() {
		return this.ficPropStsCdNm;
	}
	
	/**
	 * Column Info
	 * @return rowNo
	 */
	public String getRowNo() {
		return this.rowNo;
	}
	
	/**
	 * Column Info
	 * @return ficPropStsCd
	 */
	public String getFicPropStsCd() {
		return this.ficPropStsCd;
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
	 * @param ihcCostTrfNo
	 */
	public void setIhcCostTrfNo(String ihcCostTrfNo) {
		this.ihcCostTrfNo = ihcCostTrfNo;
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
	 * @param ihcTrfNo
	 */
	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param prcIoBndCd
	 */
	public void setPrcIoBndCd(String prcIoBndCd) {
		this.prcIoBndCd = prcIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param ficPropStsCdNm
	 */
	public void setFicPropStsCdNm(String ficPropStsCdNm) {
		this.ficPropStsCdNm = ficPropStsCdNm;
	}
	
	/**
	 * Column Info
	 * @param rowNo
	 */
	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}
	
	/**
	 * Column Info
	 * @param ficPropStsCd
	 */
	public void setFicPropStsCd(String ficPropStsCd) {
		this.ficPropStsCd = ficPropStsCd;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIhcCostTrfNo(JSPUtil.getParameter(request, prefix + "ihc_cost_trf_no", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPrcIoBndCd(JSPUtil.getParameter(request, prefix + "prc_io_bnd_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setFicPropStsCdNm(JSPUtil.getParameter(request, prefix + "fic_prop_sts_cd_nm", ""));
		setRowNo(JSPUtil.getParameter(request, prefix + "row_no", ""));
		setFicPropStsCd(JSPUtil.getParameter(request, prefix + "fic_prop_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IHCCostTariffInterfaceListVO[]
	 */
	public IHCCostTariffInterfaceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IHCCostTariffInterfaceListVO[]
	 */
	public IHCCostTariffInterfaceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IHCCostTariffInterfaceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ihcCostTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_cost_trf_no", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] prcIoBndCd = (JSPUtil.getParameter(request, prefix	+ "prc_io_bnd_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] ficPropStsCdNm = (JSPUtil.getParameter(request, prefix	+ "fic_prop_sts_cd_nm", length));
			String[] rowNo = (JSPUtil.getParameter(request, prefix	+ "row_no", length));
			String[] ficPropStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_prop_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IHCCostTariffInterfaceListVO();
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ihcCostTrfNo[i] != null)
					model.setIhcCostTrfNo(ihcCostTrfNo[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (prcIoBndCd[i] != null)
					model.setPrcIoBndCd(prcIoBndCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (ficPropStsCdNm[i] != null)
					model.setFicPropStsCdNm(ficPropStsCdNm[i]);
				if (rowNo[i] != null)
					model.setRowNo(rowNo[i]);
				if (ficPropStsCd[i] != null)
					model.setFicPropStsCd(ficPropStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIHCCostTariffInterfaceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IHCCostTariffInterfaceListVO[]
	 */
	public IHCCostTariffInterfaceListVO[] getIHCCostTariffInterfaceListVOs(){
		IHCCostTariffInterfaceListVO[] vos = (IHCCostTariffInterfaceListVO[])models.toArray(new IHCCostTariffInterfaceListVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCostTrfNo = this.ihcCostTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcIoBndCd = this.prcIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficPropStsCdNm = this.ficPropStsCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNo = this.rowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficPropStsCd = this.ficPropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
