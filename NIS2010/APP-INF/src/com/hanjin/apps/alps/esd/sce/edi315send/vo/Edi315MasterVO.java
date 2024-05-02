/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315MasterVO.java
*@FileTitle : Edi315MasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.06.08 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315MasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315MasterVO> models = new ArrayList<Edi315MasterVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String toDir = null;
	/* Column Info */
	private String preRly = null;
	/* Column Info */
	private String toVsl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String orgConti = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String postRly = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String toVoyage = null;
	/* Column Info */
	private String destConti = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String copRailChkCd = null;
	/* Column Info */
	private String bkgCreTpCd = null;
	/* Column Info */
	private String podNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315MasterVO() {}

	public Edi315MasterVO(String ibflag, String pagerows, String cntrTpszCd, String copRailChkCd, String trunkVvd, String copStsCd, String porNodCd, String polNodCd, String podNodCd, String delNodCd, String porCd, String polCd, String podCd, String delCd, String scNo, String blTpCd, String toVsl, String toVoyage, String toDir, String preRly, String postRly, String bkgCreTpCd, String orgConti, String destConti, String rcvTermCd, String deTermCd, String dcgoFlg, String vslNm, String vslCntCd, String lloydCd) {
		this.porCd = porCd;
		this.trunkVvd = trunkVvd;
		this.lloydCd = lloydCd;
		this.toDir = toDir;
		this.preRly = preRly;
		this.toVsl = toVsl;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.dcgoFlg = dcgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.orgConti = orgConti;
		this.copStsCd = copStsCd;
		this.delNodCd = delNodCd;
		this.rcvTermCd = rcvTermCd;
		this.vslCntCd = vslCntCd;
		this.postRly = postRly;
		this.porNodCd = porNodCd;
		this.delCd = delCd;
		this.vslNm = vslNm;
		this.polNodCd = polNodCd;
		this.blTpCd = blTpCd;
		this.toVoyage = toVoyage;
		this.destConti = destConti;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.copRailChkCd = copRailChkCd;
		this.bkgCreTpCd = bkgCreTpCd;
		this.podNodCd = podNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("to_dir", getToDir());
		this.hashColumns.put("pre_rly", getPreRly());
		this.hashColumns.put("to_vsl", getToVsl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("org_conti", getOrgConti());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("post_rly", getPostRly());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("to_voyage", getToVoyage());
		this.hashColumns.put("dest_conti", getDestConti());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cop_rail_chk_cd", getCopRailChkCd());
		this.hashColumns.put("bkg_cre_tp_cd", getBkgCreTpCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("to_dir", "toDir");
		this.hashFields.put("pre_rly", "preRly");
		this.hashFields.put("to_vsl", "toVsl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("org_conti", "orgConti");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("post_rly", "postRly");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("to_voyage", "toVoyage");
		this.hashFields.put("dest_conti", "destConti");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cop_rail_chk_cd", "copRailChkCd");
		this.hashFields.put("bkg_cre_tp_cd", "bkgCreTpCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
	}
	
	/**
	 * Column Info
	 * @return toDir
	 */
	public String getToDir() {
		return this.toDir;
	}
	
	/**
	 * Column Info
	 * @return preRly
	 */
	public String getPreRly() {
		return this.preRly;
	}
	
	/**
	 * Column Info
	 * @return toVsl
	 */
	public String getToVsl() {
		return this.toVsl;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return orgConti
	 */
	public String getOrgConti() {
		return this.orgConti;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return postRly
	 */
	public String getPostRly() {
		return this.postRly;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return toVoyage
	 */
	public String getToVoyage() {
		return this.toVoyage;
	}
	
	/**
	 * Column Info
	 * @return destConti
	 */
	public String getDestConti() {
		return this.destConti;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return copRailChkCd
	 */
	public String getCopRailChkCd() {
		return this.copRailChkCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCreTpCd
	 */
	public String getBkgCreTpCd() {
		return this.bkgCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
	}
	
	/**
	 * Column Info
	 * @param toDir
	 */
	public void setToDir(String toDir) {
		this.toDir = toDir;
	}
	
	/**
	 * Column Info
	 * @param preRly
	 */
	public void setPreRly(String preRly) {
		this.preRly = preRly;
	}
	
	/**
	 * Column Info
	 * @param toVsl
	 */
	public void setToVsl(String toVsl) {
		this.toVsl = toVsl;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param orgConti
	 */
	public void setOrgConti(String orgConti) {
		this.orgConti = orgConti;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param postRly
	 */
	public void setPostRly(String postRly) {
		this.postRly = postRly;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param toVoyage
	 */
	public void setToVoyage(String toVoyage) {
		this.toVoyage = toVoyage;
	}
	
	/**
	 * Column Info
	 * @param destConti
	 */
	public void setDestConti(String destConti) {
		this.destConti = destConti;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param copRailChkCd
	 */
	public void setCopRailChkCd(String copRailChkCd) {
		this.copRailChkCd = copRailChkCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCreTpCd
	 */
	public void setBkgCreTpCd(String bkgCreTpCd) {
		this.bkgCreTpCd = bkgCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		setLloydCd(JSPUtil.getParameter(request, prefix + "lloyd_cd", ""));
		setToDir(JSPUtil.getParameter(request, prefix + "to_dir", ""));
		setPreRly(JSPUtil.getParameter(request, prefix + "pre_rly", ""));
		setToVsl(JSPUtil.getParameter(request, prefix + "to_vsl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setOrgConti(JSPUtil.getParameter(request, prefix + "org_conti", ""));
		setCopStsCd(JSPUtil.getParameter(request, prefix + "cop_sts_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setPostRly(JSPUtil.getParameter(request, prefix + "post_rly", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setToVoyage(JSPUtil.getParameter(request, prefix + "to_voyage", ""));
		setDestConti(JSPUtil.getParameter(request, prefix + "dest_conti", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCopRailChkCd(JSPUtil.getParameter(request, prefix + "cop_rail_chk_cd", ""));
		setBkgCreTpCd(JSPUtil.getParameter(request, prefix + "bkg_cre_tp_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315MasterVO[]
	 */
	public Edi315MasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315MasterVO[]
	 */
	public Edi315MasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315MasterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] toDir = (JSPUtil.getParameter(request, prefix	+ "to_dir", length));
			String[] preRly = (JSPUtil.getParameter(request, prefix	+ "pre_rly", length));
			String[] toVsl = (JSPUtil.getParameter(request, prefix	+ "to_vsl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] orgConti = (JSPUtil.getParameter(request, prefix	+ "org_conti", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] postRly = (JSPUtil.getParameter(request, prefix	+ "post_rly", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] toVoyage = (JSPUtil.getParameter(request, prefix	+ "to_voyage", length));
			String[] destConti = (JSPUtil.getParameter(request, prefix	+ "dest_conti", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] copRailChkCd = (JSPUtil.getParameter(request, prefix	+ "cop_rail_chk_cd", length));
			String[] bkgCreTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_tp_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315MasterVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (toDir[i] != null)
					model.setToDir(toDir[i]);
				if (preRly[i] != null)
					model.setPreRly(preRly[i]);
				if (toVsl[i] != null)
					model.setToVsl(toVsl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (orgConti[i] != null)
					model.setOrgConti(orgConti[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (postRly[i] != null)
					model.setPostRly(postRly[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (toVoyage[i] != null)
					model.setToVoyage(toVoyage[i]);
				if (destConti[i] != null)
					model.setDestConti(destConti[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (copRailChkCd[i] != null)
					model.setCopRailChkCd(copRailChkCd[i]);
				if (bkgCreTpCd[i] != null)
					model.setBkgCreTpCd(bkgCreTpCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315MasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315MasterVO[]
	 */
	public Edi315MasterVO[] getEdi315MasterVOs(){
		Edi315MasterVO[] vos = (Edi315MasterVO[])models.toArray(new Edi315MasterVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDir = this.toDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRly = this.preRly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVsl = this.toVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgConti = this.orgConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postRly = this.postRly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVoyage = this.toVoyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destConti = this.destConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copRailChkCd = this.copRailChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreTpCd = this.bkgCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
