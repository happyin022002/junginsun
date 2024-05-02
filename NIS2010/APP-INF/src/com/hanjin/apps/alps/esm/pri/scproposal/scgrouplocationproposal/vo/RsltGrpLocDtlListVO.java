/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltGrpLocDtlListVO.java
*@FileTitle : RsltGrpLocDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo;

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

public class RsltGrpLocDtlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltGrpLocDtlListVO> models = new ArrayList<RsltGrpLocDtlListVO>();
	
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String grpLocSeq = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String srcInfoDtl = null;
	/* Column Info */
	private String locNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rankSeq = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String prcProgStsDtl = null;
	/* Column Info */
	private String grpLocDtlSeq = null;
	/* Column Info */
	private String expDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltGrpLocDtlListVO() {}

	public RsltGrpLocDtlListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String grpLocSeq, String grpLocDtlSeq, String locCd, String locNm, String rankSeq, String n1stCmncAmdtSeq, String effDt, String expDt, String srcInfoCd, String srcInfoDtl, String prcProgStsCd, String prcProgStsDtl, String acptDt, String acptUsrNm) {
		this.acptDt = acptDt;
		this.amdtSeq = amdtSeq;
		this.acptUsrNm = acptUsrNm;
		this.svcScpCd = svcScpCd;
		this.grpLocSeq = grpLocSeq;
		this.srcInfoCd = srcInfoCd;
		this.srcInfoDtl = srcInfoDtl;
		this.locNm = locNm;
		this.pagerows = pagerows;
		this.rankSeq = rankSeq;
		this.prcProgStsCd = prcProgStsCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.effDt = effDt;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.prcProgStsDtl = prcProgStsDtl;
		this.grpLocDtlSeq = grpLocDtlSeq;
		this.expDt = expDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("grp_loc_seq", getGrpLocSeq());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("src_info_dtl", getSrcInfoDtl());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rank_seq", getRankSeq());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prc_prog_sts_dtl", getPrcProgStsDtl());
		this.hashColumns.put("grp_loc_dtl_seq", getGrpLocDtlSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("grp_loc_seq", "grpLocSeq");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("src_info_dtl", "srcInfoDtl");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rank_seq", "rankSeq");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prc_prog_sts_dtl", "prcProgStsDtl");
		this.hashFields.put("grp_loc_dtl_seq", "grpLocDtlSeq");
		this.hashFields.put("exp_dt", "expDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
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
	 * @return acptUsrNm
	 */
	public String getAcptUsrNm() {
		return this.acptUsrNm;
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
	 * @return grpLocSeq
	 */
	public String getGrpLocSeq() {
		return this.grpLocSeq;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return srcInfoDtl
	 */
	public String getSrcInfoDtl() {
		return this.srcInfoDtl;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return rankSeq
	 */
	public String getRankSeq() {
		return this.rankSeq;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsDtl
	 */
	public String getPrcProgStsDtl() {
		return this.prcProgStsDtl;
	}
	
	/**
	 * Column Info
	 * @return grpLocDtlSeq
	 */
	public String getGrpLocDtlSeq() {
		return this.grpLocDtlSeq;
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
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
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
	 * @param acptUsrNm
	 */
	public void setAcptUsrNm(String acptUsrNm) {
		this.acptUsrNm = acptUsrNm;
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
	 * @param grpLocSeq
	 */
	public void setGrpLocSeq(String grpLocSeq) {
		this.grpLocSeq = grpLocSeq;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param srcInfoDtl
	 */
	public void setSrcInfoDtl(String srcInfoDtl) {
		this.srcInfoDtl = srcInfoDtl;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param rankSeq
	 */
	public void setRankSeq(String rankSeq) {
		this.rankSeq = rankSeq;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsDtl
	 */
	public void setPrcProgStsDtl(String prcProgStsDtl) {
		this.prcProgStsDtl = prcProgStsDtl;
	}
	
	/**
	 * Column Info
	 * @param grpLocDtlSeq
	 */
	public void setGrpLocDtlSeq(String grpLocDtlSeq) {
		this.grpLocDtlSeq = grpLocDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
		setAcptDt(JSPUtil.getParameter(request, prefix + "acpt_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, prefix + "acpt_usr_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setGrpLocSeq(JSPUtil.getParameter(request, prefix + "grp_loc_seq", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setSrcInfoDtl(JSPUtil.getParameter(request, prefix + "src_info_dtl", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRankSeq(JSPUtil.getParameter(request, prefix + "rank_seq", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, prefix + "prc_prog_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setPrcProgStsDtl(JSPUtil.getParameter(request, prefix + "prc_prog_sts_dtl", ""));
		setGrpLocDtlSeq(JSPUtil.getParameter(request, prefix + "grp_loc_dtl_seq", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltGrpLocDtlListVO[]
	 */
	public RsltGrpLocDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltGrpLocDtlListVO[]
	 */
	public RsltGrpLocDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltGrpLocDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] grpLocSeq = (JSPUtil.getParameter(request, prefix	+ "grp_loc_seq", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] srcInfoDtl = (JSPUtil.getParameter(request, prefix	+ "src_info_dtl", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rankSeq = (JSPUtil.getParameter(request, prefix	+ "rank_seq", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] prcProgStsDtl = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_dtl", length));
			String[] grpLocDtlSeq = (JSPUtil.getParameter(request, prefix	+ "grp_loc_dtl_seq", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltGrpLocDtlListVO();
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (grpLocSeq[i] != null)
					model.setGrpLocSeq(grpLocSeq[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (srcInfoDtl[i] != null)
					model.setSrcInfoDtl(srcInfoDtl[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rankSeq[i] != null)
					model.setRankSeq(rankSeq[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (prcProgStsDtl[i] != null)
					model.setPrcProgStsDtl(prcProgStsDtl[i]);
				if (grpLocDtlSeq[i] != null)
					model.setGrpLocDtlSeq(grpLocDtlSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltGrpLocDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltGrpLocDtlListVO[]
	 */
	public RsltGrpLocDtlListVO[] getRsltGrpLocDtlListVOs(){
		RsltGrpLocDtlListVO[] vos = (RsltGrpLocDtlListVO[])models.toArray(new RsltGrpLocDtlListVO[models.size()]);
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
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocSeq = this.grpLocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoDtl = this.srcInfoDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rankSeq = this.rankSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsDtl = this.prcProgStsDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocDtlSeq = this.grpLocDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
