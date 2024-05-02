/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RpScpGlineCopyVO.java
*@FileTitle : RpScpGlineCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.10.12 문동규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RpScpGlineCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RpScpGlineCopyVO> models = new ArrayList<RpScpGlineCopyVO>();
	
	/* Column Info */
	private String arbOrgChk = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtCmdtCnt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String svcScpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String locChk = null;
	/* Column Info */
	private String aoLocCnt = null;
	/* Column Info */
	private String adLocCnt = null;
	/* Column Info */
	private String cmdtChk = null;
	/* Column Info */
	private String arbDesChk = null;
	/* Column Info */
	private String rateChk = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rtLocCnt = null;
	/* Column Info */
	private String ficRoutCmbTpCd = null;
	/* Column Info */
	private String bsePortDefCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RpScpGlineCopyVO() {}

	public RpScpGlineCopyVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String locChk, String cmdtChk, String arbOrgChk, String arbDesChk, String rateChk, String rtCmdtCnt, String rtLocCnt, String aoLocCnt, String adLocCnt, String propNo, String amdtSeq, String svcScpNm, String creUsrId, String updUsrId, String orgDestTpCd, String effDt, String expDt, String rfaNo, String ficRoutCmbTpCd, String bsePortDefCd) {
		this.arbOrgChk = arbOrgChk;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.rtCmdtCnt = rtCmdtCnt;
		this.orgDestTpCd = orgDestTpCd;
		this.glineSeq = glineSeq;
		this.svcScpNm = svcScpNm;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.effDt = effDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.propNo = propNo;
		this.locChk = locChk;
		this.aoLocCnt = aoLocCnt;
		this.adLocCnt = adLocCnt;
		this.cmdtChk = cmdtChk;
		this.arbDesChk = arbDesChk;
		this.rateChk = rateChk;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.rtLocCnt = rtLocCnt;
		this.bsePortDefCd = bsePortDefCd;
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("arb_org_chk", getArbOrgChk());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_cmdt_cnt", getRtCmdtCnt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("svc_scp_nm", getSvcScpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("loc_chk", getLocChk());
		this.hashColumns.put("ao_loc_cnt", getAoLocCnt());
		this.hashColumns.put("ad_loc_cnt", getAdLocCnt());
		this.hashColumns.put("cmdt_chk", getCmdtChk());
		this.hashColumns.put("arb_des_chk", getArbDesChk());
		this.hashColumns.put("rate_chk", getRateChk());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rt_loc_cnt", getRtLocCnt());
		this.hashColumns.put("fic_rout_cmb_tp_cd", getFicRoutCmbTpCd());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("arb_org_chk", "arbOrgChk");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_cmdt_cnt", "rtCmdtCnt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("svc_scp_nm", "svcScpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("loc_chk", "locChk");
		this.hashFields.put("ao_loc_cnt", "aoLocCnt");
		this.hashFields.put("ad_loc_cnt", "adLocCnt");
		this.hashFields.put("cmdt_chk", "cmdtChk");
		this.hashFields.put("arb_des_chk", "arbDesChk");
		this.hashFields.put("rate_chk", "rateChk");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rt_loc_cnt", "rtLocCnt");
		this.hashFields.put("fic_rout_cmb_tp_cd", "ficRoutCmbTpCd");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return arbOrgChk
	 */
	public String getArbOrgChk() {
		return this.arbOrgChk;
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
	 * @return rtCmdtCnt
	 */
	public String getRtCmdtCnt() {
		return this.rtCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpNm
	 */
	public String getSvcScpNm() {
		return this.svcScpNm;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return locChk
	 */
	public String getLocChk() {
		return this.locChk;
	}
	
	/**
	 * Column Info
	 * @return aoLocCnt
	 */
	public String getAoLocCnt() {
		return this.aoLocCnt;
	}
	
	/**
	 * Column Info
	 * @return adLocCnt
	 */
	public String getAdLocCnt() {
		return this.adLocCnt;
	}
	
	/**
	 * Column Info
	 * @return cmdtChk
	 */
	public String getCmdtChk() {
		return this.cmdtChk;
	}
	
	/**
	 * Column Info
	 * @return arbDesChk
	 */
	public String getArbDesChk() {
		return this.arbDesChk;
	}
	
	/**
	 * Column Info
	 * @return rateChk
	 */
	public String getRateChk() {
		return this.rateChk;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return rtLocCnt
	 */
	public String getRtLocCnt() {
		return this.rtLocCnt;
	}
	

	/**
	 * Column Info
	 * @param arbOrgChk
	 */
	public void setArbOrgChk(String arbOrgChk) {
		this.arbOrgChk = arbOrgChk;
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
	 * @param rtCmdtCnt
	 */
	public void setRtCmdtCnt(String rtCmdtCnt) {
		this.rtCmdtCnt = rtCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpNm
	 */
	public void setSvcScpNm(String svcScpNm) {
		this.svcScpNm = svcScpNm;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param locChk
	 */
	public void setLocChk(String locChk) {
		this.locChk = locChk;
	}
	
	/**
	 * Column Info
	 * @param aoLocCnt
	 */
	public void setAoLocCnt(String aoLocCnt) {
		this.aoLocCnt = aoLocCnt;
	}
	
	/**
	 * Column Info
	 * @param adLocCnt
	 */
	public void setAdLocCnt(String adLocCnt) {
		this.adLocCnt = adLocCnt;
	}
	
	/**
	 * Column Info
	 * @param cmdtChk
	 */
	public void setCmdtChk(String cmdtChk) {
		this.cmdtChk = cmdtChk;
	}
	
	/**
	 * Column Info
	 * @param arbDesChk
	 */
	public void setArbDesChk(String arbDesChk) {
		this.arbDesChk = arbDesChk;
	}
	
	/**
	 * Column Info
	 * @param rateChk
	 */
	public void setRateChk(String rateChk) {
		this.rateChk = rateChk;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param rtLocCnt
	 */
	public void setRtLocCnt(String rtLocCnt) {
		this.rtLocCnt = rtLocCnt;
	}
	
	public String getFicRoutCmbTpCd() {
		return ficRoutCmbTpCd;
	}

	public void setFicRoutCmbTpCd(String ficRoutCmbTpCd) {
		this.ficRoutCmbTpCd = ficRoutCmbTpCd;
	}

	public String getBsePortDefCd() {
		return bsePortDefCd;
	}

	public void setBsePortDefCd(String bsePortDefCd) {
		this.bsePortDefCd = bsePortDefCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setArbOrgChk(JSPUtil.getParameter(request, "arb_org_chk", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRtCmdtCnt(JSPUtil.getParameter(request, "rt_cmdt_cnt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setSvcScpNm(JSPUtil.getParameter(request, "svc_scp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setLocChk(JSPUtil.getParameter(request, "loc_chk", ""));
		setAoLocCnt(JSPUtil.getParameter(request, "ao_loc_cnt", ""));
		setAdLocCnt(JSPUtil.getParameter(request, "ad_loc_cnt", ""));
		setCmdtChk(JSPUtil.getParameter(request, "cmdt_chk", ""));
		setArbDesChk(JSPUtil.getParameter(request, "arb_des_chk", ""));
		setRateChk(JSPUtil.getParameter(request, "rate_chk", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRtLocCnt(JSPUtil.getParameter(request, "rt_loc_cnt", ""));
		setFicRoutCmbTpCd(JSPUtil.getParameter(request, "fic_rout_cmb_tp_cd", ""));
		setBsePortDefCd(JSPUtil.getParameter(request, "bse_port_def_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RpScpGlineCopyVO[]
	 */
	public RpScpGlineCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RpScpGlineCopyVO[]
	 */
	public RpScpGlineCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RpScpGlineCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] arbOrgChk = (JSPUtil.getParameter(request, prefix	+ "arb_org_chk", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtCmdtCnt = (JSPUtil.getParameter(request, prefix	+ "rt_cmdt_cnt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] svcScpNm = (JSPUtil.getParameter(request, prefix	+ "svc_scp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] locChk = (JSPUtil.getParameter(request, prefix	+ "loc_chk", length));
			String[] aoLocCnt = (JSPUtil.getParameter(request, prefix	+ "ao_loc_cnt", length));
			String[] adLocCnt = (JSPUtil.getParameter(request, prefix	+ "ad_loc_cnt", length));
			String[] cmdtChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_chk", length));
			String[] arbDesChk = (JSPUtil.getParameter(request, prefix	+ "arb_des_chk", length));
			String[] rateChk = (JSPUtil.getParameter(request, prefix	+ "rate_chk", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rtLocCnt = (JSPUtil.getParameter(request, prefix	+ "rt_loc_cnt", length));
			String[] ficRoutCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "fic_rout_cmb_tp_cd", length));
			String[] bsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_def_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RpScpGlineCopyVO();
				if (arbOrgChk[i] != null)
					model.setArbOrgChk(arbOrgChk[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtCmdtCnt[i] != null)
					model.setRtCmdtCnt(rtCmdtCnt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (svcScpNm[i] != null)
					model.setSvcScpNm(svcScpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (locChk[i] != null)
					model.setLocChk(locChk[i]);
				if (aoLocCnt[i] != null)
					model.setAoLocCnt(aoLocCnt[i]);
				if (adLocCnt[i] != null)
					model.setAdLocCnt(adLocCnt[i]);
				if (cmdtChk[i] != null)
					model.setCmdtChk(cmdtChk[i]);
				if (arbDesChk[i] != null)
					model.setArbDesChk(arbDesChk[i]);
				if (rateChk[i] != null)
					model.setRateChk(rateChk[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rtLocCnt[i] != null)
					model.setRtLocCnt(rtLocCnt[i]);
				if (ficRoutCmbTpCd[i] != null)
					model.setFicRoutCmbTpCd(ficRoutCmbTpCd[i]);
				if (bsePortDefCd[i] != null)
					model.setBsePortDefCd(bsePortDefCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRpScpGlineCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RpScpGlineCopyVO[]
	 */
	public RpScpGlineCopyVO[] getRpScpGlineCopyVOs(){
		RpScpGlineCopyVO[] vos = (RpScpGlineCopyVO[])models.toArray(new RpScpGlineCopyVO[models.size()]);
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
		this.arbOrgChk = this.arbOrgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCmdtCnt = this.rtCmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpNm = this.svcScpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locChk = this.locChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aoLocCnt = this.aoLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adLocCnt = this.adLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtChk = this.cmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbDesChk = this.arbDesChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateChk = this.rateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtLocCnt = this.rtLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRoutCmbTpCd = this.ficRoutCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd = this.bsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
