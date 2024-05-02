/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmAblogRptLogVO.java
*@FileTitle : FcmAblogRptLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmAblogRptLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmAblogRptLogVO> models = new ArrayList<FcmAblogRptLogVO>();
	
	/* Column Info */
	private String nisVoyDirCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String portDlayTm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String eaiIfRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pltInTm = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String voyDirCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String brthTm = null;
	/* Column Info */
	private String seaDlayTm = null;
	/* Column Info */
	private String sailTm = null;
	/* Column Info */
	private String portTm = null;
	/* Column Info */
	private String rptDt = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sailAvgSpd = null;
	/* Column Info */
	private String sailDist = null;
	/* Column Info */
	private String refNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmAblogRptLogVO() {}

	public FcmAblogRptLogVO(String ibflag, String pagerows, String rcvDt, String rcvSeq, String vslCd, String vslSlanCd, String voyDirCd, String nisVoyDirCd, String rptDt, String sailTm, String pltInTm, String brthTm, String portTm, String portDlayTm, String seaDlayTm, String sailDist, String sailAvgSpd, String refNo, String eaiIfId, String ifFlg, String eaiIfRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.nisVoyDirCd = nisVoyDirCd;
		this.vslCd = vslCd;
		this.portDlayTm = portDlayTm;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.rcvSeq = rcvSeq;
		this.vslSlanCd = vslSlanCd;
		this.eaiIfRmk = eaiIfRmk;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pltInTm = pltInTm;
		this.rcvDt = rcvDt;
		this.voyDirCd = voyDirCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.brthTm = brthTm;
		this.seaDlayTm = seaDlayTm;
		this.sailTm = sailTm;
		this.portTm = portTm;
		this.rptDt = rptDt;
		this.ifFlg = ifFlg;
		this.creUsrId = creUsrId;
		this.sailAvgSpd = sailAvgSpd;
		this.sailDist = sailDist;
		this.refNo = refNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nis_voy_dir_cd", getNisVoyDirCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("port_dlay_tm", getPortDlayTm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("eai_if_rmk", getEaiIfRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("plt_in_tm", getPltInTm());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("voy_dir_cd", getVoyDirCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("brth_tm", getBrthTm());
		this.hashColumns.put("sea_dlay_tm", getSeaDlayTm());
		this.hashColumns.put("sail_tm", getSailTm());
		this.hashColumns.put("port_tm", getPortTm());
		this.hashColumns.put("rpt_dt", getRptDt());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sail_avg_spd", getSailAvgSpd());
		this.hashColumns.put("sail_dist", getSailDist());
		this.hashColumns.put("ref_no", getRefNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nis_voy_dir_cd", "nisVoyDirCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("port_dlay_tm", "portDlayTm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("eai_if_rmk", "eaiIfRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("plt_in_tm", "pltInTm");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("voy_dir_cd", "voyDirCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("brth_tm", "brthTm");
		this.hashFields.put("sea_dlay_tm", "seaDlayTm");
		this.hashFields.put("sail_tm", "sailTm");
		this.hashFields.put("port_tm", "portTm");
		this.hashFields.put("rpt_dt", "rptDt");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sail_avg_spd", "sailAvgSpd");
		this.hashFields.put("sail_dist", "sailDist");
		this.hashFields.put("ref_no", "refNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nisVoyDirCd
	 */
	public String getNisVoyDirCd() {
		return this.nisVoyDirCd;
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
	 * @return portDlayTm
	 */
	public String getPortDlayTm() {
		return this.portDlayTm;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
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
	 * @return eaiIfRmk
	 */
	public String getEaiIfRmk() {
		return this.eaiIfRmk;
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
	 * @return pltInTm
	 */
	public String getPltInTm() {
		return this.pltInTm;
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
	 * @return voyDirCd
	 */
	public String getVoyDirCd() {
		return this.voyDirCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return brthTm
	 */
	public String getBrthTm() {
		return this.brthTm;
	}
	
	/**
	 * Column Info
	 * @return seaDlayTm
	 */
	public String getSeaDlayTm() {
		return this.seaDlayTm;
	}
	
	/**
	 * Column Info
	 * @return sailTm
	 */
	public String getSailTm() {
		return this.sailTm;
	}
	
	/**
	 * Column Info
	 * @return portTm
	 */
	public String getPortTm() {
		return this.portTm;
	}
	
	/**
	 * Column Info
	 * @return rptDt
	 */
	public String getRptDt() {
		return this.rptDt;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
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
	 * @return sailAvgSpd
	 */
	public String getSailAvgSpd() {
		return this.sailAvgSpd;
	}
	
	/**
	 * Column Info
	 * @return sailDist
	 */
	public String getSailDist() {
		return this.sailDist;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	

	/**
	 * Column Info
	 * @param nisVoyDirCd
	 */
	public void setNisVoyDirCd(String nisVoyDirCd) {
		this.nisVoyDirCd = nisVoyDirCd;
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
	 * @param portDlayTm
	 */
	public void setPortDlayTm(String portDlayTm) {
		this.portDlayTm = portDlayTm;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
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
	 * @param eaiIfRmk
	 */
	public void setEaiIfRmk(String eaiIfRmk) {
		this.eaiIfRmk = eaiIfRmk;
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
	 * @param pltInTm
	 */
	public void setPltInTm(String pltInTm) {
		this.pltInTm = pltInTm;
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
	 * @param voyDirCd
	 */
	public void setVoyDirCd(String voyDirCd) {
		this.voyDirCd = voyDirCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param brthTm
	 */
	public void setBrthTm(String brthTm) {
		this.brthTm = brthTm;
	}
	
	/**
	 * Column Info
	 * @param seaDlayTm
	 */
	public void setSeaDlayTm(String seaDlayTm) {
		this.seaDlayTm = seaDlayTm;
	}
	
	/**
	 * Column Info
	 * @param sailTm
	 */
	public void setSailTm(String sailTm) {
		this.sailTm = sailTm;
	}
	
	/**
	 * Column Info
	 * @param portTm
	 */
	public void setPortTm(String portTm) {
		this.portTm = portTm;
	}
	
	/**
	 * Column Info
	 * @param rptDt
	 */
	public void setRptDt(String rptDt) {
		this.rptDt = rptDt;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
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
	 * @param sailAvgSpd
	 */
	public void setSailAvgSpd(String sailAvgSpd) {
		this.sailAvgSpd = sailAvgSpd;
	}
	
	/**
	 * Column Info
	 * @param sailDist
	 */
	public void setSailDist(String sailDist) {
		this.sailDist = sailDist;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
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
		setNisVoyDirCd(JSPUtil.getParameter(request, prefix + "nis_voy_dir_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPortDlayTm(JSPUtil.getParameter(request, prefix + "port_dlay_tm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setEaiIfRmk(JSPUtil.getParameter(request, prefix + "eai_if_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPltInTm(JSPUtil.getParameter(request, prefix + "plt_in_tm", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setVoyDirCd(JSPUtil.getParameter(request, prefix + "voy_dir_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBrthTm(JSPUtil.getParameter(request, prefix + "brth_tm", ""));
		setSeaDlayTm(JSPUtil.getParameter(request, prefix + "sea_dlay_tm", ""));
		setSailTm(JSPUtil.getParameter(request, prefix + "sail_tm", ""));
		setPortTm(JSPUtil.getParameter(request, prefix + "port_tm", ""));
		setRptDt(JSPUtil.getParameter(request, prefix + "rpt_dt", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSailAvgSpd(JSPUtil.getParameter(request, prefix + "sail_avg_spd", ""));
		setSailDist(JSPUtil.getParameter(request, prefix + "sail_dist", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmAblogRptLogVO[]
	 */
	public FcmAblogRptLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmAblogRptLogVO[]
	 */
	public FcmAblogRptLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmAblogRptLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nisVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "nis_voy_dir_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] portDlayTm = (JSPUtil.getParameter(request, prefix	+ "port_dlay_tm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] eaiIfRmk = (JSPUtil.getParameter(request, prefix	+ "eai_if_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pltInTm = (JSPUtil.getParameter(request, prefix	+ "plt_in_tm", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] voyDirCd = (JSPUtil.getParameter(request, prefix	+ "voy_dir_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] brthTm = (JSPUtil.getParameter(request, prefix	+ "brth_tm", length));
			String[] seaDlayTm = (JSPUtil.getParameter(request, prefix	+ "sea_dlay_tm", length));
			String[] sailTm = (JSPUtil.getParameter(request, prefix	+ "sail_tm", length));
			String[] portTm = (JSPUtil.getParameter(request, prefix	+ "port_tm", length));
			String[] rptDt = (JSPUtil.getParameter(request, prefix	+ "rpt_dt", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sailAvgSpd = (JSPUtil.getParameter(request, prefix	+ "sail_avg_spd", length));
			String[] sailDist = (JSPUtil.getParameter(request, prefix	+ "sail_dist", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmAblogRptLogVO();
				if (nisVoyDirCd[i] != null)
					model.setNisVoyDirCd(nisVoyDirCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (portDlayTm[i] != null)
					model.setPortDlayTm(portDlayTm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (eaiIfRmk[i] != null)
					model.setEaiIfRmk(eaiIfRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pltInTm[i] != null)
					model.setPltInTm(pltInTm[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (voyDirCd[i] != null)
					model.setVoyDirCd(voyDirCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (brthTm[i] != null)
					model.setBrthTm(brthTm[i]);
				if (seaDlayTm[i] != null)
					model.setSeaDlayTm(seaDlayTm[i]);
				if (sailTm[i] != null)
					model.setSailTm(sailTm[i]);
				if (portTm[i] != null)
					model.setPortTm(portTm[i]);
				if (rptDt[i] != null)
					model.setRptDt(rptDt[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sailAvgSpd[i] != null)
					model.setSailAvgSpd(sailAvgSpd[i]);
				if (sailDist[i] != null)
					model.setSailDist(sailDist[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmAblogRptLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmAblogRptLogVO[]
	 */
	public FcmAblogRptLogVO[] getFcmAblogRptLogVOs(){
		FcmAblogRptLogVO[] vos = (FcmAblogRptLogVO[])models.toArray(new FcmAblogRptLogVO[models.size()]);
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
		this.nisVoyDirCd = this.nisVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDlayTm = this.portDlayTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfRmk = this.eaiIfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltInTm = this.pltInTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyDirCd = this.voyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthTm = this.brthTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDlayTm = this.seaDlayTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailTm = this.sailTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTm = this.portTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptDt = this.rptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailAvgSpd = this.sailAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDist = this.sailDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
