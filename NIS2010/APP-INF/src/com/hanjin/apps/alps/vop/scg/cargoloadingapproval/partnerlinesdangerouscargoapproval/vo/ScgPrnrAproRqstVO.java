/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPrnrAproRqstVO.java
*@FileTitle : ScgPrnrAproRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.23
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.05.23 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPrnrAproRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPrnrAproRqstVO> models = new ArrayList<ScgPrnrAproRqstVO>();
	
	/* Column Info */
	private String spclCgoRqstSeq = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String meFlag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bBFlag = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String reeferFlag = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoOprCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String awkFlg = null;
	/*	Column Info	*/
	private  String	 eaiIfFlg   =  null;
	/*	Column Info	*/
	private  String	 eaiEvntDt   =  null;
	/*	Column Info	*/
	private  String	 eaiIfId   =  null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPrnrAproRqstVO() {}

	public ScgPrnrAproRqstVO(String ibflag, String pagerows, String updDt, String spclCgoRqstSeq, String vslCd, String rgnShpOprCd, String meFlag, String etaDt, String podClptIndSeq, String creDt, String skdVoyNo, String crrCd, String skdDirCd, String bkgRefNo, String podCd, String cgoOprCd, String creUsrId, String dgFlg, String polCd, String slanCd, String awkFlg, String polClptIndSeq, String updUsrId, String reeferFlag, String bBFlag,String eaiIfFlg,String eaiEvntDt,String eaiIfId)	{
		this.spclCgoRqstSeq = spclCgoRqstSeq;
		this.vslCd = vslCd;
		this.etaDt = etaDt;
		this.meFlag = meFlag;
		this.creDt = creDt;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.polClptIndSeq = polClptIndSeq;
		this.updUsrId = updUsrId;
		this.bBFlag = bBFlag;
		this.updDt = updDt;
		this.rgnShpOprCd = rgnShpOprCd;
		this.podClptIndSeq = podClptIndSeq;
		this.skdVoyNo = skdVoyNo;
		this.reeferFlag = reeferFlag;
		this.skdDirCd = skdDirCd;
		this.bkgRefNo = bkgRefNo;
		this.podCd = podCd;
		this.cgoOprCd = cgoOprCd;
		this.creUsrId = creUsrId;
		this.dgFlg = dgFlg;
		this.slanCd = slanCd;
		this.awkFlg = awkFlg;
		this.eaiIfFlg  = eaiIfFlg ;
		this.eaiEvntDt  = eaiEvntDt ;
		this.eaiIfId  = eaiIfId ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("me_flag", getMeFlag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("b_b_flag", getBBFlag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("reefer_flag", getReeferFlag());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("awk_flg", getAwkFlg());
		this.hashColumns.put("eai_if_flg", getEaiIfFlg());		
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());		
		this.hashColumns.put("eai_if_id", getEaiIfId());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("me_flag", "meFlag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("b_b_flag", "bBFlag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("reefer_flag", "reeferFlag");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_opr_cd", "cgoOprCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("awk_flg", "awkFlg");
		this.hashFields.put("eai_if_flg", "eaiIfFlg");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return spclCgoRqstSeq
	 */
	public String getSpclCgoRqstSeq() {
		return this.spclCgoRqstSeq;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return meFlag
	 */
	public String getMeFlag() {
		return this.meFlag;
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
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return bBFlag
	 */
	public String getBBFlag() {
		return this.bBFlag;
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
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return reeferFlag
	 */
	public String getReeferFlag() {
		return this.reeferFlag;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRefNo
	 */
	public String getBkgRefNo() {
		return this.bkgRefNo;
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
	 * @return cgoOprCd
	 */
	public String getCgoOprCd() {
		return this.cgoOprCd;
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
	 * @return dgFlg
	 */
	public String getDgFlg() {
		return this.dgFlg;
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
	 * @return awkFlg
	 */
	public String getAwkFlg() {
		return this.awkFlg;
	}
	

	/**
	 * Column Info
	 * @param spclCgoRqstSeq
	 */
	public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
		this.spclCgoRqstSeq = spclCgoRqstSeq;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param meFlag
	 */
	public void setMeFlag(String meFlag) {
		this.meFlag = meFlag;
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
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param bBFlag
	 */
	public void setBBFlag(String bBFlag) {
		this.bBFlag = bBFlag;
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
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param reeferFlag
	 */
	public void setReeferFlag(String reeferFlag) {
		this.reeferFlag = reeferFlag;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRefNo
	 */
	public void setBkgRefNo(String bkgRefNo) {
		this.bkgRefNo = bkgRefNo;
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
	 * @param cgoOprCd
	 */
	public void setCgoOprCd(String cgoOprCd) {
		this.cgoOprCd = cgoOprCd;
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
	 * @param dgFlg
	 */
	public void setDgFlg(String dgFlg) {
		this.dgFlg = dgFlg;
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
	 * @param awkFlg
	 */
	public void setAwkFlg(String awkFlg) {
		this.awkFlg = awkFlg;
	}
	
	/**
	* Column Info
	* @param  eaiIfFlg
	*/
	public void	setEaiIfFlg( String	eaiIfFlg ) {
		this.eaiIfFlg =	eaiIfFlg;
	}
 
	/**
	 * Column Info
	 * @return	eaiIfFlg
	 */
	 public	String	getEaiIfFlg() {
		 return	this.eaiIfFlg;
	 } 
 	/**
	* Column Info
	* @param  eaiEvntDt
	*/
	public void	setEaiEvntDt( String	eaiEvntDt ) {
		this.eaiEvntDt =	eaiEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	eaiEvntDt
	 */
	 public	String	getEaiEvntDt() {
		 return	this.eaiEvntDt;
	 } 
 	/**
	* Column Info
	* @param  eaiIfId
	*/
	public void	setEaiIfId( String	eaiIfId ) {
		this.eaiIfId =	eaiIfId;
	}
 
	/**
	 * Column Info
	 * @return	eaiIfId
	 */
	 public	String	getEaiIfId() {
		 return	this.eaiIfId;
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
		setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setMeFlag(JSPUtil.getParameter(request, prefix + "me_flag", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBBFlag(JSPUtil.getParameter(request, prefix + "b_b_flag", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setReeferFlag(JSPUtil.getParameter(request, prefix + "reefer_flag", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setAwkFlg(JSPUtil.getParameter(request, prefix + "awk_flg", ""));
		setEaiIfFlg(JSPUtil.getParameter(request,	"eai_if_flg", ""));
		setEaiEvntDt(JSPUtil.getParameter(request,	"eai_evnt_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request,	"eai_if_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrAproRqstVO[]
	 */
	public ScgPrnrAproRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPrnrAproRqstVO[]
	 */
	public ScgPrnrAproRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPrnrAproRqstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rqst_seq", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] meFlag = (JSPUtil.getParameter(request, prefix	+ "me_flag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bBFlag = (JSPUtil.getParameter(request, prefix	+ "b_b_flag", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] reeferFlag = (JSPUtil.getParameter(request, prefix	+ "reefer_flag", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoOprCd = (JSPUtil.getParameter(request, prefix	+ "cgo_opr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] awkFlg = (JSPUtil.getParameter(request, prefix	+ "awk_flg", length));
			String[] eaiIfFlg =	(JSPUtil.getParameter(request, prefix +	"eai_if_flg".trim(),	length));
			String[] eaiEvntDt =	(JSPUtil.getParameter(request, prefix +	"eai_evnt_dt".trim(),	length));
			String[] eaiIfId =	(JSPUtil.getParameter(request, prefix +	"eai_if_id".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPrnrAproRqstVO();
				if (spclCgoRqstSeq[i] != null)
					model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (meFlag[i] != null)
					model.setMeFlag(meFlag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bBFlag[i] != null)
					model.setBBFlag(bBFlag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (reeferFlag[i] != null)
					model.setReeferFlag(reeferFlag[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoOprCd[i] != null)
					model.setCgoOprCd(cgoOprCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (awkFlg[i] != null)
					model.setAwkFlg(awkFlg[i]);
				if ( eaiIfFlg[i] !=	null)
					model.setEaiIfFlg( eaiIfFlg[i]);
				if ( eaiEvntDt[i] !=	null)
					model.setEaiEvntDt( eaiEvntDt[i]);
				if ( eaiIfId[i] !=	null)
					model.setEaiIfId( eaiIfId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPrnrAproRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPrnrAproRqstVO[]
	 */
	public ScgPrnrAproRqstVO[] getScgPrnrAproRqstVOs(){
		ScgPrnrAproRqstVO[] vos = (ScgPrnrAproRqstVO[])models.toArray(new ScgPrnrAproRqstVO[models.size()]);
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
		this.spclCgoRqstSeq = this.spclCgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meFlag = this.meFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bBFlag = this.bBFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reeferFlag = this.reeferFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoOprCd = this.cgoOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkFlg = this.awkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfFlg =	this.eaiIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt =	this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId =	this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
