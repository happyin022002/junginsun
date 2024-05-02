/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UserDefinedLanePortGroupVO.java
*@FileTitle : UserDefinedLanePortGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.03
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2012.08.03 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UserDefinedLanePortGroupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserDefinedLanePortGroupVO> models = new ArrayList<UserDefinedLanePortGroupVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String usrDefGrpNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String usePgmDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String usePgmNm = null;
	/* Column Info */
	private String dirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String portNm = null;
	/* Column Info */
	private String orgPortCd = null;
	/* Column Info */
	private String orgDirCd = null;
	/* Column Info */
	private String orgUsrDefGrpNm = null;
	/* Column Info */
	private String orgVslSlanCd = null;
	/* Column Info */
	private String ampTpCd = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UserDefinedLanePortGroupVO() {}

	public UserDefinedLanePortGroupVO(String ibflag, String pagerows, String usrId, String usrDefGrpNm, String usePgmNm, String usePgmDesc, String deltFlg, String vslSlanCd, String dirCd, String locCd, String creUsrId, String creDt, String updUsrId, String updDt, String vslSlanNm, String portCd, String portNm, String orgPortCd, String orgDirCd, String orgUsrDefGrpNm, String orgVslSlanCd, String ampTpCd) {
		this.updDt = updDt;
		this.usrDefGrpNm = usrDefGrpNm;
		this.deltFlg = deltFlg;
		this.usePgmDesc = usePgmDesc;
		this.creDt = creDt;
		this.vslSlanCd = vslSlanCd;
		this.usePgmNm = usePgmNm;
		this.dirCd = dirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.usrId = usrId;
		this.updUsrId = updUsrId;
		this.vslSlanNm = vslSlanNm;
		this.portCd = portCd;
		this.portNm = portNm;
		this.orgPortCd = orgPortCd;
		this.orgDirCd = orgDirCd;
		this.orgUsrDefGrpNm = orgUsrDefGrpNm;
		this.orgVslSlanCd = orgVslSlanCd;
		this.ampTpCd = ampTpCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("usr_def_grp_nm", getUsrDefGrpNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("use_pgm_desc", getUsePgmDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("use_pgm_nm", getUsePgmNm());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("org_port_cd", getOrgPortCd());
		this.hashColumns.put("org_dir_cd", getOrgDirCd());
		this.hashColumns.put("org_usr_def_grp_nm", getOrgUsrDefGrpNm());
		this.hashColumns.put("org_vsl_slan_cd", getOrgVslSlanCd());
		this.hashColumns.put("amp_tp_cd", getAmpTpCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("usr_def_grp_nm", "usrDefGrpNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("use_pgm_desc", "usePgmDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("use_pgm_nm", "usePgmNm");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("org_port_cd", "orgPortCd");
		this.hashFields.put("org_dir_cd", "orgDirCd");
		this.hashFields.put("org_usr_def_grp_nm", "orgUsrDefGrpNm");
		this.hashFields.put("org_vsl_slan_cd", "orgVslSlanCd");
		this.hashFields.put("amp_tp_cd", "ampTpCd");

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
	 * @return usrDefGrpNm
	 */
	public String getUsrDefGrpNm() {
		return this.usrDefGrpNm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return usePgmDesc
	 */
	public String getUsePgmDesc() {
		return this.usePgmDesc;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return usePgmNm
	 */
	public String getUsePgmNm() {
		return this.usePgmNm;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
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
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
	}
	
	/**
	 * Column Info
	 * @return orgPortCd
	 */
	public String getOrgPortCd() {
		return this.orgPortCd;
	}
	
	/**
	 * Column Info
	 * @return orgDirCd
	 */
	public String getOrgDirCd() {
		return this.orgDirCd;
	}
	
	/**
	 * Column Info
	 * @return orgUsrDefGrpNm
	 */
	public String getOrgUsrDefGrpNm() {
		return this.orgUsrDefGrpNm;
	}
	
	/**
	 * Column Info
	 * @return orgVslSlanCd
	 */
	public String getOrgVslSlanCd() {
		return this.orgVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return ampTpCd
	 */
	public String getAmpTpCd() {
		return this.ampTpCd;
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
	 * @param usrDefGrpNm
	 */
	public void setUsrDefGrpNm(String usrDefGrpNm) {
		this.usrDefGrpNm = usrDefGrpNm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param usePgmDesc
	 */
	public void setUsePgmDesc(String usePgmDesc) {
		this.usePgmDesc = usePgmDesc;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param usePgmNm
	 */
	public void setUsePgmNm(String usePgmNm) {
		this.usePgmNm = usePgmNm;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
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
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}
	
	/**
	 * Column Info
	 * @param orgPortCd
	 */
	public void setOrgPortCd(String orgPortCd) {
		this.orgPortCd = orgPortCd;
	}
	
	/**
	 * Column Info
	 * @param orgDirCd
	 */
	public void setOrgDirCd(String orgDirCd) {
		this.orgDirCd = orgDirCd;
	}
	
	/**
	 * Column Info
	 * @param orgUsrDefGrpNm
	 */
	public void setOrgUsrDefGrpNm(String orgUsrDefGrpNm) {
		this.orgUsrDefGrpNm = orgUsrDefGrpNm;
	}
	
	/**
	 * Column Info
	 * @param orgVslSlanCd
	 */
	public void setOrgVslSlanCd(String orgVslSlanCd) {
		this.orgVslSlanCd = orgVslSlanCd;
	}

	/**
	 * Column Info
	 * @param ampTpCd
	 */
	public void setAmpTpCd(String ampTpCd) {
		this.ampTpCd = ampTpCd;
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
		setUsrDefGrpNm(JSPUtil.getParameter(request, prefix + "usr_def_grp_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setUsePgmDesc(JSPUtil.getParameter(request, prefix + "use_pgm_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setUsePgmNm(JSPUtil.getParameter(request, prefix + "use_pgm_nm", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
		setOrgPortCd(JSPUtil.getParameter(request, prefix + "org_port_cd", ""));
		setOrgDirCd(JSPUtil.getParameter(request, prefix + "org_dir_cd", ""));
		setOrgUsrDefGrpNm(JSPUtil.getParameter(request, prefix + "org_usr_def_grp_nm", ""));
		setOrgVslSlanCd(JSPUtil.getParameter(request, prefix + "org_vsl_slan_cd", ""));
		setAmpTpCd(JSPUtil.getParameter(request, prefix + "amp_tp_cd", ""));

		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UserDefinedLanePortGroupVO[]
	 */
	public UserDefinedLanePortGroupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UserDefinedLanePortGroupVO[]
	 */
	public UserDefinedLanePortGroupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserDefinedLanePortGroupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] usrDefGrpNm = (JSPUtil.getParameter(request, prefix	+ "usr_def_grp_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] usePgmDesc = (JSPUtil.getParameter(request, prefix	+ "use_pgm_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] usePgmNm = (JSPUtil.getParameter(request, prefix	+ "use_pgm_nm", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] orgPortCd = (JSPUtil.getParameter(request, prefix	+ "org_port_cd", length));
			String[] orgDirCd = (JSPUtil.getParameter(request, prefix	+ "org_dir_cd", length));
			String[] orgUsrDefGrpNm = (JSPUtil.getParameter(request, prefix	+ "org_usr_def_grp_nm", length));
			String[] orgVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "org_vsl_slan_cd", length));
			String[] ampTpCd = (JSPUtil.getParameter(request, prefix	+ "amp_tp_cd", length));

			
			for (int i = 0; i < length; i++) {
				model = new UserDefinedLanePortGroupVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (usrDefGrpNm[i] != null)
					model.setUsrDefGrpNm(usrDefGrpNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (usePgmDesc[i] != null)
					model.setUsePgmDesc(usePgmDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (usePgmNm[i] != null)
					model.setUsePgmNm(usePgmNm[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (orgPortCd[i] != null)
					model.setOrgPortCd(orgPortCd[i]);
				if (orgDirCd[i] != null)
					model.setOrgDirCd(orgDirCd[i]);
				if (orgUsrDefGrpNm[i] != null)
					model.setOrgUsrDefGrpNm(orgUsrDefGrpNm[i]);
				if (orgVslSlanCd[i] != null)
					model.setOrgVslSlanCd(orgVslSlanCd[i]);
				if (ampTpCd[i] != null)
					model.setAmpTpCd(ampTpCd[i]);
				models.add(model);

			}

		} catch (Exception e) {
			return null;
		}
		return getUserDefinedLanePortGroupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UserDefinedLanePortGroupVO[]
	 */
	public UserDefinedLanePortGroupVO[] getUserDefinedLanePortGroupVOs(){
		UserDefinedLanePortGroupVO[] vos = (UserDefinedLanePortGroupVO[])models.toArray(new UserDefinedLanePortGroupVO[models.size()]);
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
		this.usrDefGrpNm = this.usrDefGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usePgmDesc = this.usePgmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usePgmNm = this.usePgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPortCd = this.orgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDirCd = this.orgDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUsrDefGrpNm = this.orgUsrDefGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVslSlanCd = this.orgVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ampTpCd = this.ampTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
