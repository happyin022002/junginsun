/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CanalTransitScheduleVO.java
*@FileTitle : CanalTransitScheduleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.25
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2011.11.25 Park Yeon-Jin 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Park Yeon-Jin
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTransitScheduleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTransitScheduleVO> models = new ArrayList<CanalTransitScheduleVO>();
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String nxtPortEta = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String nxtPortClptSeq = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tgtYrmon = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String svcScpBndCd = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String tgtVvdExistFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTransitScheduleVO() {}

	public CanalTransitScheduleVO(String ibflag, String pagerows, String svcScpBndCd, String bound, String vslCd, String skdDirCd, String vvd, String vslEngNm, String vslSlanCd, String vpsPortCd, String clptSeq, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String nxtPortCd, String nxtPortClptSeq, String nxtPortEta, String tgtVvdExistFlg, String iPage, String rn, String laneCd, String vndrSeq, String tgtYrmon) {
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.rn = rn;
		this.vpsEtdDt = vpsEtdDt;
		this.nxtPortEta = nxtPortEta;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.nxtPortCd = nxtPortCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.nxtPortClptSeq = nxtPortClptSeq;
		this.vpsPortCd = vpsPortCd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.tgtYrmon = tgtYrmon;
		this.vslEngNm = vslEngNm;
		this.vndrSeq = vndrSeq;
		this.iPage = iPage;
		this.svcScpBndCd = svcScpBndCd;
		this.bound = bound;
		this.tgtVvdExistFlg = tgtVvdExistFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("nxt_port_eta", getNxtPortEta());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("nxt_port_clpt_seq", getNxtPortClptSeq());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tgt_yrmon", getTgtYrmon());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("svc_scp_bnd_cd", getSvcScpBndCd());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("tgt_vvd_exist_flg", getTgtVvdExistFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("nxt_port_eta", "nxtPortEta");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("nxt_port_clpt_seq", "nxtPortClptSeq");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tgt_yrmon", "tgtYrmon");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("svc_scp_bnd_cd", "svcScpBndCd");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("tgt_vvd_exist_flg", "tgtVvdExistFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return nxtPortEta
	 */
	public String getNxtPortEta() {
		return this.nxtPortEta;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return nxtPortClptSeq
	 */
	public String getNxtPortClptSeq() {
		return this.nxtPortClptSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return tgtYrmon
	 */
	public String getTgtYrmon() {
		return this.tgtYrmon;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	
	/**
	 * Column Info
	 * @return svcScpBndCd
	 */
	public String getSvcScpBndCd() {
		return this.svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return tgtVvdExistFlg
	 */
	public String getTgtVvdExistFlg() {
		return this.tgtVvdExistFlg;
	}
	

	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param nxtPortEta
	 */
	public void setNxtPortEta(String nxtPortEta) {
		this.nxtPortEta = nxtPortEta;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param nxtPortClptSeq
	 */
	public void setNxtPortClptSeq(String nxtPortClptSeq) {
		this.nxtPortClptSeq = nxtPortClptSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param tgtYrmon
	 */
	public void setTgtYrmon(String tgtYrmon) {
		this.tgtYrmon = tgtYrmon;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param svcScpBndCd
	 */
	public void setSvcScpBndCd(String svcScpBndCd) {
		this.svcScpBndCd = svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param tgtVvdExistFlg
	 */
	public void setTgtVvdExistFlg(String tgtVvdExistFlg) {
		this.tgtVvdExistFlg = tgtVvdExistFlg;
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
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setNxtPortEta(JSPUtil.getParameter(request, prefix + "nxt_port_eta", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setNxtPortClptSeq(JSPUtil.getParameter(request, prefix + "nxt_port_clpt_seq", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTgtYrmon(JSPUtil.getParameter(request, prefix + "tgt_yrmon", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setSvcScpBndCd(JSPUtil.getParameter(request, prefix + "svc_scp_bnd_cd", ""));
		setBound(JSPUtil.getParameter(request, prefix + "bound", ""));
		setTgtVvdExistFlg(JSPUtil.getParameter(request, prefix + "tgt_vvd_exist_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTransitScheduleVO[]
	 */
	public CanalTransitScheduleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTransitScheduleVO[]
	 */
	public CanalTransitScheduleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTransitScheduleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] nxtPortEta = (JSPUtil.getParameter(request, prefix	+ "nxt_port_eta", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] nxtPortClptSeq = (JSPUtil.getParameter(request, prefix	+ "nxt_port_clpt_seq", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tgtYrmon = (JSPUtil.getParameter(request, prefix	+ "tgt_yrmon", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] svcScpBndCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_bnd_cd", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] tgtVvdExistFlg = (JSPUtil.getParameter(request, prefix	+ "tgt_vvd_exist_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTransitScheduleVO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (nxtPortEta[i] != null)
					model.setNxtPortEta(nxtPortEta[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (nxtPortClptSeq[i] != null)
					model.setNxtPortClptSeq(nxtPortClptSeq[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tgtYrmon[i] != null)
					model.setTgtYrmon(tgtYrmon[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (svcScpBndCd[i] != null)
					model.setSvcScpBndCd(svcScpBndCd[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (tgtVvdExistFlg[i] != null)
					model.setTgtVvdExistFlg(tgtVvdExistFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTransitScheduleVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTransitScheduleVO[]
	 */
	public CanalTransitScheduleVO[] getCanalTransitScheduleVOs(){
		CanalTransitScheduleVO[] vos = (CanalTransitScheduleVO[])models.toArray(new CanalTransitScheduleVO[models.size()]);
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
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortEta = this.nxtPortEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortClptSeq = this.nxtPortClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtYrmon = this.tgtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpBndCd = this.svcScpBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtVvdExistFlg = this.tgtVvdExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
