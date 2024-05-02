/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AncsManifestModificationVO.java
*@FileTitle : AncsManifestModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.18
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.12.18 윤태승 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤태승
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsManifestModificationVO extends ManifestModificationVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsManifestModificationVO> models = new ArrayList<AncsManifestModificationVO>();
	
	/* Column Info */
	private String chkDown = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String vvdNm = null;
	/* Column Info */
	private String ssrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String msgStsCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String dnldCount = null;
	/* Column Info */
	private String bkgCount = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String daoGbn = null;
	/* Column Info */
	private String lloydTpCd = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String euStfFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsManifestModificationVO() {}

	public AncsManifestModificationVO(String ibflag, String pagerows, String dnldCount, String bkgCount, String etaDt, String sndDt, String ssrNo, String vvdNm, String vvd, String creUsrId, String bkgNo, String sndUsrId, String ediSts, String slanCd, String lloydNo, String creOfcCd, String rcvDt, String pol, String pod, String daoGbn, String lloydTpCd, String portCd, String msgStsCd, String updOfcCd, String updUsrId, String polClptIndSeq, String podClptIndSeq, String chkDown, String diff, String euStfFlg) {
		this.chkDown = chkDown;
		this.etaDt = etaDt;
		this.sndDt = sndDt;
		this.vvdNm = vvdNm;
		this.ssrNo = ssrNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.rcvDt = rcvDt;
		this.pol = pol;
		this.polClptIndSeq = polClptIndSeq;
		this.portCd = portCd;
		this.msgStsCd = msgStsCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.pod = pod;
		this.dnldCount = dnldCount;
		this.bkgCount = bkgCount;
		this.podClptIndSeq = podClptIndSeq;
		this.vvd = vvd;
		this.ediSts = ediSts;
		this.sndUsrId = sndUsrId;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.lloydNo = lloydNo;
		this.daoGbn = daoGbn;
		this.lloydTpCd = lloydTpCd;
		this.diff = diff;
		this.euStfFlg = euStfFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_down", getChkDown());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("ssr_no", getSsrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("msg_sts_cd", getMsgStsCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("dnld_count", getDnldCount());
		this.hashColumns.put("bkg_count", getBkgCount());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("dao_gbn", getDaoGbn());
		this.hashColumns.put("lloyd_tp_cd", getLloydTpCd());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("eu_stf_flg", getEuStfFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_down", "chkDown");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("ssr_no", "ssrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("msg_sts_cd", "msgStsCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("dnld_count", "dnldCount");
		this.hashFields.put("bkg_count", "bkgCount");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("dao_gbn", "daoGbn");
		this.hashFields.put("lloyd_tp_cd", "lloydTpCd");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("eu_stf_flg", "euStfFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chkDown
	 */
	public String getChkDown() {
		return this.chkDown;
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
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
	}
	
	/**
	 * Column Info
	 * @return ssrNo
	 */
	public String getSsrNo() {
		return this.ssrNo;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return msgStsCd
	 */
	public String getMsgStsCd() {
		return this.msgStsCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return dnldCount
	 */
	public String getDnldCount() {
		return this.dnldCount;
	}
	
	/**
	 * Column Info
	 * @return bkgCount
	 */
	public String getBkgCount() {
		return this.bkgCount;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
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
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return daoGbn
	 */
	public String getDaoGbn() {
		return this.daoGbn;
	}
	
	/**
	 * Column Info
	 * @return lloydTpCd
	 */
	public String getLloydTpCd() {
		return this.lloydTpCd;
	}
	
	/**
	 * Column Info
	 * @return euStfFlg
	 */
	public String getEuStfFlg() {
		return this.euStfFlg;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}

	/**
	 * Column Info
	 * @param chkDown
	 */
	public void setChkDown(String chkDown) {
		this.chkDown = chkDown;
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
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
	}
	
	/**
	 * Column Info
	 * @param ssrNo
	 */
	public void setSsrNo(String ssrNo) {
		this.ssrNo = ssrNo;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param msgStsCd
	 */
	public void setMsgStsCd(String msgStsCd) {
		this.msgStsCd = msgStsCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param dnldCount
	 */
	public void setDnldCount(String dnldCount) {
		this.dnldCount = dnldCount;
	}
	
	/**
	 * Column Info
	 * @param bkgCount
	 */
	public void setBkgCount(String bkgCount) {
		this.bkgCount = bkgCount;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
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
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param daoGbn
	 */
	public void setDaoGbn(String daoGbn) {
		this.daoGbn = daoGbn;
	}
	
	/**
	 * Column Info
	 * @param lloydTpCd
	 */
	public void setLloydTpCd(String lloydTpCd) {
		this.lloydTpCd = lloydTpCd;
	}
	
	/**
	 * Column Info
	 * @param euStfFlg
	 */
	public void setEuStfFlg(String euStfFlg) {
		this.euStfFlg = euStfFlg;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
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
		setChkDown(JSPUtil.getParameter(request, prefix + "chk_down", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setVvdNm(JSPUtil.getParameter(request, prefix + "vvd_nm", ""));
		setSsrNo(JSPUtil.getParameter(request, prefix + "ssr_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setMsgStsCd(JSPUtil.getParameter(request, prefix + "msg_sts_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setDnldCount(JSPUtil.getParameter(request, prefix + "dnld_count", ""));
		setBkgCount(JSPUtil.getParameter(request, prefix + "bkg_count", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setEdiSts(JSPUtil.getParameter(request, prefix + "edi_sts", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setDaoGbn(JSPUtil.getParameter(request, prefix + "dao_gbn", ""));
		setLloydTpCd(JSPUtil.getParameter(request, prefix + "lloyd_tp_cd", ""));
		setLloydTpCd(JSPUtil.getParameter(request, prefix + "diff", ""));
		setEuStfFlg(JSPUtil.getParameter(request, prefix + "eu_stf_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsManifestModificationVO[]
	 */
	public AncsManifestModificationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsManifestModificationVO[]
	 */
	public AncsManifestModificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsManifestModificationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkDown = (JSPUtil.getParameter(request, prefix	+ "chk_down", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm", length));
			String[] ssrNo = (JSPUtil.getParameter(request, prefix	+ "ssr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] msgStsCd = (JSPUtil.getParameter(request, prefix	+ "msg_sts_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] dnldCount = (JSPUtil.getParameter(request, prefix	+ "dnld_count", length));
			String[] bkgCount = (JSPUtil.getParameter(request, prefix	+ "bkg_count", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] daoGbn = (JSPUtil.getParameter(request, prefix	+ "dao_gbn", length));
			String[] lloydTpCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_tp_cd", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] euStfFlg = (JSPUtil.getParameter(request, prefix	+ "eu_stf_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsManifestModificationVO();
				if (chkDown[i] != null)
					model.setChkDown(chkDown[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (ssrNo[i] != null)
					model.setSsrNo(ssrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (msgStsCd[i] != null)
					model.setMsgStsCd(msgStsCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (dnldCount[i] != null)
					model.setDnldCount(dnldCount[i]);
				if (bkgCount[i] != null)
					model.setBkgCount(bkgCount[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (daoGbn[i] != null)
					model.setDaoGbn(daoGbn[i]);
				if (lloydTpCd[i] != null)
					model.setLloydTpCd(lloydTpCd[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (euStfFlg[i] != null)
					model.setEuStfFlg(euStfFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsManifestModificationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsManifestModificationVO[]
	 */
	public AncsManifestModificationVO[] getAncsManifestModificationVOs(){
		AncsManifestModificationVO[] vos = (AncsManifestModificationVO[])models.toArray(new AncsManifestModificationVO[models.size()]);
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
		this.chkDown = this.chkDown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssrNo = this.ssrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgStsCd = this.msgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnldCount = this.dnldCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCount = this.bkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daoGbn = this.daoGbn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydTpCd = this.lloydTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euStfFlg = this.euStfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
