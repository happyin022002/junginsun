/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RoutLocCdVO.java
*@FileTitle : RoutLocCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.05.15 조정민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RoutLocCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RoutLocCdVO> models = new ArrayList<RoutLocCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String chkConvCd = null;
	/* Column Info */
	private String frmOrgLocCd = null;
	/* Column Info */
	private String chkOrgCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String porApplFlg = null;
	/* Column Info */
	private String preRlyPortApplFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pstRlyPortApplFlg = null;
	/* Column Info */
	private String chkFlg = null;
	/* Column Info */
	private String chkLocation = null;
	/* Column Info */
	private String convLocCd = null;
	/* Column Info */
	private String delApplFlg = null;
	/* Column Info */
	private String polApplFlg = null;
	/* Column Info */
	private String frmConvLocCd = null;
	/* Column Info */
	private String chkScpCd = null;
	/* Column Info */
	private String scpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String podApplFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RoutLocCdVO() {}

	public RoutLocCdVO(String ibflag, String pagerows, String orgLocCd, String svcScpCd, String convLocCd, String scpCd, String frmOrgLocCd, String frmConvLocCd, String chkScpCd, String chkOrgCd, String chkConvCd, String chkLocation, String chkFlg, String porApplFlg, String polApplFlg, String podApplFlg, String delApplFlg, String preRlyPortApplFlg, String pstRlyPortApplFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.orgLocCd = orgLocCd;
		this.chkConvCd = chkConvCd;
		this.frmOrgLocCd = frmOrgLocCd;
		this.chkOrgCd = chkOrgCd;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.porApplFlg = porApplFlg;
		this.preRlyPortApplFlg = preRlyPortApplFlg;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.pstRlyPortApplFlg = pstRlyPortApplFlg;
		this.chkFlg = chkFlg;
		this.chkLocation = chkLocation;
		this.convLocCd = convLocCd;
		this.delApplFlg = delApplFlg;
		this.polApplFlg = polApplFlg;
		this.frmConvLocCd = frmConvLocCd;
		this.chkScpCd = chkScpCd;
		this.scpCd = scpCd;
		this.updUsrId = updUsrId;
		this.podApplFlg = podApplFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("chk_conv_cd", getChkConvCd());
		this.hashColumns.put("frm_org_loc_cd", getFrmOrgLocCd());
		this.hashColumns.put("chk_org_cd", getChkOrgCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("por_appl_flg", getPorApplFlg());
		this.hashColumns.put("pre_rly_port_appl_flg", getPreRlyPortApplFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pst_rly_port_appl_flg", getPstRlyPortApplFlg());
		this.hashColumns.put("chk_flg", getChkFlg());
		this.hashColumns.put("chk_location", getChkLocation());
		this.hashColumns.put("conv_loc_cd", getConvLocCd());
		this.hashColumns.put("del_appl_flg", getDelApplFlg());
		this.hashColumns.put("pol_appl_flg", getPolApplFlg());
		this.hashColumns.put("frm_conv_loc_cd", getFrmConvLocCd());
		this.hashColumns.put("chk_scp_cd", getChkScpCd());
		this.hashColumns.put("scp_cd", getScpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pod_appl_flg", getPodApplFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("chk_conv_cd", "chkConvCd");
		this.hashFields.put("frm_org_loc_cd", "frmOrgLocCd");
		this.hashFields.put("chk_org_cd", "chkOrgCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("por_appl_flg", "porApplFlg");
		this.hashFields.put("pre_rly_port_appl_flg", "preRlyPortApplFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pst_rly_port_appl_flg", "pstRlyPortApplFlg");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("chk_location", "chkLocation");
		this.hashFields.put("conv_loc_cd", "convLocCd");
		this.hashFields.put("del_appl_flg", "delApplFlg");
		this.hashFields.put("pol_appl_flg", "polApplFlg");
		this.hashFields.put("frm_conv_loc_cd", "frmConvLocCd");
		this.hashFields.put("chk_scp_cd", "chkScpCd");
		this.hashFields.put("scp_cd", "scpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pod_appl_flg", "podApplFlg");
		return this.hashFields;
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
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}
	
	/**
	 * Column Info
	 * @return chkConvCd
	 */
	public String getChkConvCd() {
		return this.chkConvCd;
	}
	
	/**
	 * Column Info
	 * @return frmOrgLocCd
	 */
	public String getFrmOrgLocCd() {
		return this.frmOrgLocCd;
	}
	
	/**
	 * Column Info
	 * @return chkOrgCd
	 */
	public String getChkOrgCd() {
		return this.chkOrgCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return porApplFlg
	 */
	public String getPorApplFlg() {
		return this.porApplFlg;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortApplFlg
	 */
	public String getPreRlyPortApplFlg() {
		return this.preRlyPortApplFlg;
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
	 * @return pstRlyPortApplFlg
	 */
	public String getPstRlyPortApplFlg() {
		return this.pstRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @return chkFlg
	 */
	public String getChkFlg() {
		return this.chkFlg;
	}
	
	/**
	 * Column Info
	 * @return chkLocation
	 */
	public String getChkLocation() {
		return this.chkLocation;
	}
	
	/**
	 * Column Info
	 * @return convLocCd
	 */
	public String getConvLocCd() {
		return this.convLocCd;
	}
	
	/**
	 * Column Info
	 * @return delApplFlg
	 */
	public String getDelApplFlg() {
		return this.delApplFlg;
	}
	
	/**
	 * Column Info
	 * @return polApplFlg
	 */
	public String getPolApplFlg() {
		return this.polApplFlg;
	}
	
	/**
	 * Column Info
	 * @return frmConvLocCd
	 */
	public String getFrmConvLocCd() {
		return this.frmConvLocCd;
	}
	
	/**
	 * Column Info
	 * @return chkScpCd
	 */
	public String getChkScpCd() {
		return this.chkScpCd;
	}
	
	/**
	 * Column Info
	 * @return scpCd
	 */
	public String getScpCd() {
		return this.scpCd;
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
	 * @return podApplFlg
	 */
	public String getPodApplFlg() {
		return this.podApplFlg;
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
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}
	
	/**
	 * Column Info
	 * @param chkConvCd
	 */
	public void setChkConvCd(String chkConvCd) {
		this.chkConvCd = chkConvCd;
	}
	
	/**
	 * Column Info
	 * @param frmOrgLocCd
	 */
	public void setFrmOrgLocCd(String frmOrgLocCd) {
		this.frmOrgLocCd = frmOrgLocCd;
	}
	
	/**
	 * Column Info
	 * @param chkOrgCd
	 */
	public void setChkOrgCd(String chkOrgCd) {
		this.chkOrgCd = chkOrgCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param porApplFlg
	 */
	public void setPorApplFlg(String porApplFlg) {
		this.porApplFlg = porApplFlg;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortApplFlg
	 */
	public void setPreRlyPortApplFlg(String preRlyPortApplFlg) {
		this.preRlyPortApplFlg = preRlyPortApplFlg;
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
	 * @param pstRlyPortApplFlg
	 */
	public void setPstRlyPortApplFlg(String pstRlyPortApplFlg) {
		this.pstRlyPortApplFlg = pstRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @param chkFlg
	 */
	public void setChkFlg(String chkFlg) {
		this.chkFlg = chkFlg;
	}
	
	/**
	 * Column Info
	 * @param chkLocation
	 */
	public void setChkLocation(String chkLocation) {
		this.chkLocation = chkLocation;
	}
	
	/**
	 * Column Info
	 * @param convLocCd
	 */
	public void setConvLocCd(String convLocCd) {
		this.convLocCd = convLocCd;
	}
	
	/**
	 * Column Info
	 * @param delApplFlg
	 */
	public void setDelApplFlg(String delApplFlg) {
		this.delApplFlg = delApplFlg;
	}
	
	/**
	 * Column Info
	 * @param polApplFlg
	 */
	public void setPolApplFlg(String polApplFlg) {
		this.polApplFlg = polApplFlg;
	}
	
	/**
	 * Column Info
	 * @param frmConvLocCd
	 */
	public void setFrmConvLocCd(String frmConvLocCd) {
		this.frmConvLocCd = frmConvLocCd;
	}
	
	/**
	 * Column Info
	 * @param chkScpCd
	 */
	public void setChkScpCd(String chkScpCd) {
		this.chkScpCd = chkScpCd;
	}
	
	/**
	 * Column Info
	 * @param scpCd
	 */
	public void setScpCd(String scpCd) {
		this.scpCd = scpCd;
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
	 * @param podApplFlg
	 */
	public void setPodApplFlg(String podApplFlg) {
		this.podApplFlg = podApplFlg;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setChkConvCd(JSPUtil.getParameter(request, prefix + "chk_conv_cd", ""));
		setFrmOrgLocCd(JSPUtil.getParameter(request, prefix + "frm_org_loc_cd", ""));
		setChkOrgCd(JSPUtil.getParameter(request, prefix + "chk_org_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPorApplFlg(JSPUtil.getParameter(request, prefix + "por_appl_flg", ""));
		setPreRlyPortApplFlg(JSPUtil.getParameter(request, prefix + "pre_rly_port_appl_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPstRlyPortApplFlg(JSPUtil.getParameter(request, prefix + "pst_rly_port_appl_flg", ""));
		setChkFlg(JSPUtil.getParameter(request, prefix + "chk_flg", ""));
		setChkLocation(JSPUtil.getParameter(request, prefix + "chk_location", ""));
		setConvLocCd(JSPUtil.getParameter(request, prefix + "conv_loc_cd", ""));
		setDelApplFlg(JSPUtil.getParameter(request, prefix + "del_appl_flg", ""));
		setPolApplFlg(JSPUtil.getParameter(request, prefix + "pol_appl_flg", ""));
		setFrmConvLocCd(JSPUtil.getParameter(request, prefix + "frm_conv_loc_cd", ""));
		setChkScpCd(JSPUtil.getParameter(request, prefix + "chk_scp_cd", ""));
		setScpCd(JSPUtil.getParameter(request, prefix + "scp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPodApplFlg(JSPUtil.getParameter(request, prefix + "pod_appl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RoutLocCdVO[]
	 */
	public RoutLocCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RoutLocCdVO[]
	 */
	public RoutLocCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RoutLocCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] chkConvCd = (JSPUtil.getParameter(request, prefix	+ "chk_conv_cd", length));
			String[] frmOrgLocCd = (JSPUtil.getParameter(request, prefix	+ "frm_org_loc_cd", length));
			String[] chkOrgCd = (JSPUtil.getParameter(request, prefix	+ "chk_org_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] porApplFlg = (JSPUtil.getParameter(request, prefix	+ "por_appl_flg", length));
			String[] preRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_appl_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pstRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_appl_flg", length));
			String[] chkFlg = (JSPUtil.getParameter(request, prefix	+ "chk_flg", length));
			String[] chkLocation = (JSPUtil.getParameter(request, prefix	+ "chk_location", length));
			String[] convLocCd = (JSPUtil.getParameter(request, prefix	+ "conv_loc_cd", length));
			String[] delApplFlg = (JSPUtil.getParameter(request, prefix	+ "del_appl_flg", length));
			String[] polApplFlg = (JSPUtil.getParameter(request, prefix	+ "pol_appl_flg", length));
			String[] frmConvLocCd = (JSPUtil.getParameter(request, prefix	+ "frm_conv_loc_cd", length));
			String[] chkScpCd = (JSPUtil.getParameter(request, prefix	+ "chk_scp_cd", length));
			String[] scpCd = (JSPUtil.getParameter(request, prefix	+ "scp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] podApplFlg = (JSPUtil.getParameter(request, prefix	+ "pod_appl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RoutLocCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (chkConvCd[i] != null)
					model.setChkConvCd(chkConvCd[i]);
				if (frmOrgLocCd[i] != null)
					model.setFrmOrgLocCd(frmOrgLocCd[i]);
				if (chkOrgCd[i] != null)
					model.setChkOrgCd(chkOrgCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (porApplFlg[i] != null)
					model.setPorApplFlg(porApplFlg[i]);
				if (preRlyPortApplFlg[i] != null)
					model.setPreRlyPortApplFlg(preRlyPortApplFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pstRlyPortApplFlg[i] != null)
					model.setPstRlyPortApplFlg(pstRlyPortApplFlg[i]);
				if (chkFlg[i] != null)
					model.setChkFlg(chkFlg[i]);
				if (chkLocation[i] != null)
					model.setChkLocation(chkLocation[i]);
				if (convLocCd[i] != null)
					model.setConvLocCd(convLocCd[i]);
				if (delApplFlg[i] != null)
					model.setDelApplFlg(delApplFlg[i]);
				if (polApplFlg[i] != null)
					model.setPolApplFlg(polApplFlg[i]);
				if (frmConvLocCd[i] != null)
					model.setFrmConvLocCd(frmConvLocCd[i]);
				if (chkScpCd[i] != null)
					model.setChkScpCd(chkScpCd[i]);
				if (scpCd[i] != null)
					model.setScpCd(scpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (podApplFlg[i] != null)
					model.setPodApplFlg(podApplFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRoutLocCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RoutLocCdVO[]
	 */
	public RoutLocCdVO[] getRoutLocCdVOs(){
		RoutLocCdVO[] vos = (RoutLocCdVO[])models.toArray(new RoutLocCdVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkConvCd = this.chkConvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmOrgLocCd = this.frmOrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOrgCd = this.chkOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porApplFlg = this.porApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortApplFlg = this.preRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortApplFlg = this.pstRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg = this.chkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLocation = this.chkLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convLocCd = this.convLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delApplFlg = this.delApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polApplFlg = this.polApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmConvLocCd = this.frmConvLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkScpCd = this.chkScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scpCd = this.scpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podApplFlg = this.podApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
