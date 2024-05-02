/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPropMnScpListVO.java
*@FileTitle : RsltPropMnScpListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.12.03 공백진 
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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropMnScpListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropMnScpListVO> models = new ArrayList<RsltPropMnScpListVO>();
	
	/* Column Info */
	private String preExpDt = null;
	/* Column Info */
	private String propScpSrepCd = null;
	/* Column Info */
	private String propScpStsCd = null;
	/* Column Info */
	private String amdScpFlg = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Column Info */
	private String reqUsrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String propScpSts = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String preExtScp = null;
	/* Column Info */
	private String tgtMvcQty = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String aproUsrFlg = null;
	/* Column Info */
	private String durDupFlg = null;
	/* Column Info */
	private String propScpOfcCd = null;
	/* Column Info */
	private String ctrtExpDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPropMnScpListVO() {}

	public RsltPropMnScpListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String propScpOfcCd, String tgtMvcQty, String cntrLodUtCd, String propScpSrepCd, String ctrtEffDt, String ctrtExpDt, String effDt, String expDt, String preExpDt, String durDupFlg, String propScpStsCd, String propScpSts, String reqUsrFlg, String aproUsrFlg, String amdScpFlg, String preExtScp) {
		this.preExpDt = preExpDt;
		this.propScpSrepCd = propScpSrepCd;
		this.propScpStsCd = propScpStsCd;
		this.amdScpFlg = amdScpFlg;
		this.ctrtEffDt = ctrtEffDt;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.cntrLodUtCd = cntrLodUtCd;
		this.reqUsrFlg = reqUsrFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.propScpSts = propScpSts;
		this.propNo = propNo;
		this.preExtScp = preExtScp;
		this.tgtMvcQty = tgtMvcQty;
		this.expDt = expDt;
		this.aproUsrFlg = aproUsrFlg;
		this.durDupFlg = durDupFlg;
		this.propScpOfcCd = propScpOfcCd;
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_exp_dt", getPreExpDt());
		this.hashColumns.put("prop_scp_srep_cd", getPropScpSrepCd());
		this.hashColumns.put("prop_scp_sts_cd", getPropScpStsCd());
		this.hashColumns.put("amd_scp_flg", getAmdScpFlg());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("req_usr_flg", getReqUsrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prop_scp_sts", getPropScpSts());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("pre_ext_scp", getPreExtScp());
		this.hashColumns.put("tgt_mvc_qty", getTgtMvcQty());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("apro_usr_flg", getAproUsrFlg());
		this.hashColumns.put("dur_dup_flg", getDurDupFlg());
		this.hashColumns.put("prop_scp_ofc_cd", getPropScpOfcCd());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("prop_scp_srep_cd", "propScpSrepCd");
		this.hashFields.put("prop_scp_sts_cd", "propScpStsCd");
		this.hashFields.put("amd_scp_flg", "amdScpFlg");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("req_usr_flg", "reqUsrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prop_scp_sts", "propScpSts");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("pre_ext_scp", "preExtScp");
		this.hashFields.put("tgt_mvc_qty", "tgtMvcQty");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("apro_usr_flg", "aproUsrFlg");
		this.hashFields.put("dur_dup_flg", "durDupFlg");
		this.hashFields.put("prop_scp_ofc_cd", "propScpOfcCd");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return preExpDt
	 */
	public String getPreExpDt() {
		return this.preExpDt;
	}
	
	/**
	 * Column Info
	 * @return propScpSrepCd
	 */
	public String getPropScpSrepCd() {
		return this.propScpSrepCd;
	}
	
	/**
	 * Column Info
	 * @return propScpStsCd
	 */
	public String getPropScpStsCd() {
		return this.propScpStsCd;
	}
	
	/**
	 * Column Info
	 * @return amdScpFlg
	 */
	public String getAmdScpFlg() {
		return this.amdScpFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
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
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
	}
	
	/**
	 * Column Info
	 * @return reqUsrFlg
	 */
	public String getReqUsrFlg() {
		return this.reqUsrFlg;
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
	 * @return propScpSts
	 */
	public String getPropScpSts() {
		return this.propScpSts;
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
	 * @return preExtScp
	 */
	public String getPreExtScp() {
		return this.preExtScp;
	}
	
	/**
	 * Column Info
	 * @return tgtMvcQty
	 */
	public String getTgtMvcQty() {
		return this.tgtMvcQty;
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
	 * @return aproUsrFlg
	 */
	public String getAproUsrFlg() {
		return this.aproUsrFlg;
	}
	
	/**
	 * Column Info
	 * @return durDupFlg
	 */
	public String getDurDupFlg() {
		return this.durDupFlg;
	}
	
	/**
	 * Column Info
	 * @return propScpOfcCd
	 */
	public String getPropScpOfcCd() {
		return this.propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	

	/**
	 * Column Info
	 * @param preExpDt
	 */
	public void setPreExpDt(String preExpDt) {
		this.preExpDt = preExpDt;
	}
	
	/**
	 * Column Info
	 * @param propScpSrepCd
	 */
	public void setPropScpSrepCd(String propScpSrepCd) {
		this.propScpSrepCd = propScpSrepCd;
	}
	
	/**
	 * Column Info
	 * @param propScpStsCd
	 */
	public void setPropScpStsCd(String propScpStsCd) {
		this.propScpStsCd = propScpStsCd;
	}
	
	/**
	 * Column Info
	 * @param amdScpFlg
	 */
	public void setAmdScpFlg(String amdScpFlg) {
		this.amdScpFlg = amdScpFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
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
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
	}
	
	/**
	 * Column Info
	 * @param reqUsrFlg
	 */
	public void setReqUsrFlg(String reqUsrFlg) {
		this.reqUsrFlg = reqUsrFlg;
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
	 * @param propScpSts
	 */
	public void setPropScpSts(String propScpSts) {
		this.propScpSts = propScpSts;
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
	 * @param preExtScp
	 */
	public void setPreExtScp(String preExtScp) {
		this.preExtScp = preExtScp;
	}
	
	/**
	 * Column Info
	 * @param tgtMvcQty
	 */
	public void setTgtMvcQty(String tgtMvcQty) {
		this.tgtMvcQty = tgtMvcQty;
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
	 * @param aproUsrFlg
	 */
	public void setAproUsrFlg(String aproUsrFlg) {
		this.aproUsrFlg = aproUsrFlg;
	}
	
	/**
	 * Column Info
	 * @param durDupFlg
	 */
	public void setDurDupFlg(String durDupFlg) {
		this.durDupFlg = durDupFlg;
	}
	
	/**
	 * Column Info
	 * @param propScpOfcCd
	 */
	public void setPropScpOfcCd(String propScpOfcCd) {
		this.propScpOfcCd = propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPreExpDt(JSPUtil.getParameter(request, "pre_exp_dt", ""));
		setPropScpSrepCd(JSPUtil.getParameter(request, "prop_scp_srep_cd", ""));
		setPropScpStsCd(JSPUtil.getParameter(request, "prop_scp_sts_cd", ""));
		setAmdScpFlg(JSPUtil.getParameter(request, "amd_scp_flg", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, "ctrt_eff_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, "cntr_lod_ut_cd", ""));
		setReqUsrFlg(JSPUtil.getParameter(request, "req_usr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setPropScpSts(JSPUtil.getParameter(request, "prop_scp_sts", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setPreExtScp(JSPUtil.getParameter(request, "pre_ext_scp", ""));
		setTgtMvcQty(JSPUtil.getParameter(request, "tgt_mvc_qty", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setAproUsrFlg(JSPUtil.getParameter(request, "apro_usr_flg", ""));
		setDurDupFlg(JSPUtil.getParameter(request, "dur_dup_flg", ""));
		setPropScpOfcCd(JSPUtil.getParameter(request, "prop_scp_ofc_cd", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, "ctrt_exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropMnScpListVO[]
	 */
	public RsltPropMnScpListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropMnScpListVO[]
	 */
	public RsltPropMnScpListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropMnScpListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] preExpDt = (JSPUtil.getParameter(request, prefix	+ "pre_exp_dt", length));
			String[] propScpSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_srep_cd", length));
			String[] propScpStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_sts_cd", length));
			String[] amdScpFlg = (JSPUtil.getParameter(request, prefix	+ "amd_scp_flg", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_ut_cd", length));
			String[] reqUsrFlg = (JSPUtil.getParameter(request, prefix	+ "req_usr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] propScpSts = (JSPUtil.getParameter(request, prefix	+ "prop_scp_sts", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] preExtScp = (JSPUtil.getParameter(request, prefix	+ "pre_ext_scp", length));
			String[] tgtMvcQty = (JSPUtil.getParameter(request, prefix	+ "tgt_mvc_qty", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] aproUsrFlg = (JSPUtil.getParameter(request, prefix	+ "apro_usr_flg", length));
			String[] durDupFlg = (JSPUtil.getParameter(request, prefix	+ "dur_dup_flg", length));
			String[] propScpOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_ofc_cd", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropMnScpListVO();
				if (preExpDt[i] != null)
					model.setPreExpDt(preExpDt[i]);
				if (propScpSrepCd[i] != null)
					model.setPropScpSrepCd(propScpSrepCd[i]);
				if (propScpStsCd[i] != null)
					model.setPropScpStsCd(propScpStsCd[i]);
				if (amdScpFlg[i] != null)
					model.setAmdScpFlg(amdScpFlg[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (reqUsrFlg[i] != null)
					model.setReqUsrFlg(reqUsrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (propScpSts[i] != null)
					model.setPropScpSts(propScpSts[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (preExtScp[i] != null)
					model.setPreExtScp(preExtScp[i]);
				if (tgtMvcQty[i] != null)
					model.setTgtMvcQty(tgtMvcQty[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (aproUsrFlg[i] != null)
					model.setAproUsrFlg(aproUsrFlg[i]);
				if (durDupFlg[i] != null)
					model.setDurDupFlg(durDupFlg[i]);
				if (propScpOfcCd[i] != null)
					model.setPropScpOfcCd(propScpOfcCd[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropMnScpListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropMnScpListVO[]
	 */
	public RsltPropMnScpListVO[] getRsltPropMnScpListVOs(){
		RsltPropMnScpListVO[] vos = (RsltPropMnScpListVO[])models.toArray(new RsltPropMnScpListVO[models.size()]);
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
		this.preExpDt = this.preExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpSrepCd = this.propScpSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpStsCd = this.propScpStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdScpFlg = this.amdScpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrFlg = this.reqUsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpSts = this.propScpSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExtScp = this.preExtScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtMvcQty = this.tgtMvcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrFlg = this.aproUsrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durDupFlg = this.durDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpOfcCd = this.propScpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
