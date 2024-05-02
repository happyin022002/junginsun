/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchSlaneCodeVO.java
*@FileTitle : SearchSlaneCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24  
* 1.0 Creation
=========================================================*/
 
package com.clt.apps.opus.bcm.ccd.commoncode.service.vo;

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

public class SLaneDirVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SLaneDirVO> models = new ArrayList<SLaneDirVO>();
	
	/* Column Info */
	private String vslSvcTpCd = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String stEffDt = null;
	/* Column Info */
	private String vslTpCd = null;
	/* Column Info */
	private String endEffDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vslSlanDirSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String fdrDivCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String addFlg = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String dirDeltFlg = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String modiVipTeamCd = null;
	/* Column Info */
	private String modiVslSlanDirCd = null;
	
	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SLaneDirVO() {}

	public SLaneDirVO(String ibflag, String pagerows, String vslSlanNm, String vslSvcTpCd, String vslTpCd, String fdrDivCd, String stEffDt, String endEffDt, String coCd, String deltFlg, String vslSlanDirCd, String vslSlanDirSeq, String dirDeltFlg, String userId, String addFlg, String vslSlanCd, String rqstNo, String modiVipTeamCd, String modiVslSlanDirCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslSvcTpCd = vslSvcTpCd;
		this.coCd = coCd;
		this.deltFlg = deltFlg;
		this.stEffDt = stEffDt;
		this.vslTpCd = vslTpCd;
		this.endEffDt = endEffDt;
		this.vslSlanCd = vslSlanCd;
		this.vslSlanDirSeq = vslSlanDirSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vslSlanNm = vslSlanNm;
		this.fdrDivCd = fdrDivCd;
		this.userId = userId;
		this.addFlg = addFlg;
		this.vslSlanDirCd = vslSlanDirCd;
		this.dirDeltFlg = dirDeltFlg;
		this.rqstNo = rqstNo;
		this.modiVipTeamCd = modiVipTeamCd;
		this.modiVslSlanDirCd = modiVslSlanDirCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("st_eff_dt", getStEffDt());
		this.hashColumns.put("vsl_tp_cd", getVslTpCd());
		this.hashColumns.put("end_eff_dt", getEndEffDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vsl_slan_dir_seq", getVslSlanDirSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("fdr_div_cd", getFdrDivCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("add_flg", getAddFlg());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("dir_delt_flg", getDirDeltFlg());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("modi_vip_team_cd", getModiVipTeamCd());
		this.hashColumns.put("modi_vsl_slan_dir_cd", getModiVslSlanDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("st_eff_dt", "stEffDt");
		this.hashFields.put("vsl_tp_cd", "vslTpCd");
		this.hashFields.put("end_eff_dt", "endEffDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vsl_slan_dir_seq", "vslSlanDirSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("fdr_div_cd", "fdrDivCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("add_flg", "addFlg");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("dir_delt_flg", "dirDeltFlg");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("modi_vip_team_cd", "modiVipTeamCd");
		this.hashFields.put("modi_vsl_slan_dir_cd", "modiVslSlanDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
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
	 * @return stEffDt
	 */
	public String getStEffDt() {
		return this.stEffDt;
	}
	
	/**
	 * Column Info
	 * @return vslTpCd
	 */
	public String getVslTpCd() {
		return this.vslTpCd;
	}
	
	/**
	 * Column Info
	 * @return endEffDt
	 */
	public String getEndEffDt() {
		return this.endEffDt;
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
	 * @return vslSlanDirSeq
	 */
	public String getVslSlanDirSeq() {
		return this.vslSlanDirSeq;
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
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return fdrDivCd
	 */
	public String getFdrDivCd() {
		return this.fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return addFlg
	 */
	public String getAddFlg() {
		return this.addFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return dirDeltFlg
	 */
	public String getDirDeltFlg() {
		return this.dirDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}

	/**
	 * Column Info
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
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
	 * @param stEffDt
	 */
	public void setStEffDt(String stEffDt) {
		this.stEffDt = stEffDt;
	}
	
	/**
	 * Column Info
	 * @param vslTpCd
	 */
	public void setVslTpCd(String vslTpCd) {
		this.vslTpCd = vslTpCd;
	}
	
	/**
	 * Column Info
	 * @param endEffDt
	 */
	public void setEndEffDt(String endEffDt) {
		this.endEffDt = endEffDt;
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
	 * @param vslSlanDirSeq
	 */
	public void setVslSlanDirSeq(String vslSlanDirSeq) {
		this.vslSlanDirSeq = vslSlanDirSeq;
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
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param fdrDivCd
	 */
	public void setFdrDivCd(String fdrDivCd) {
		this.fdrDivCd = fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param addFlg
	 */
	public void setAddFlg(String addFlg) {
		this.addFlg = addFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param dirDeltFlg
	 */
	public void setDirDeltFlg(String dirDeltFlg) {
		this.dirDeltFlg = dirDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	public String getModiVipTeamCd() {
		return modiVipTeamCd;
	}

	public void setModiVipTeamCd(String modiVipTeamCd) {
		this.modiVipTeamCd = modiVipTeamCd;
	}

	public String getModiVslSlanDirCd() {
		return modiVslSlanDirCd;
	}

	public void setModiVslSlanDirCd(String modiVslSlanDirCd) {
		this.modiVslSlanDirCd = modiVslSlanDirCd;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setVslSvcTpCd(JSPUtil.getParameter(request, prefix + "vsl_svc_tp_cd", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setStEffDt(JSPUtil.getParameter(request, prefix + "st_eff_dt", ""));
		setVslTpCd(JSPUtil.getParameter(request, prefix + "vsl_tp_cd", ""));
		setEndEffDt(JSPUtil.getParameter(request, prefix + "end_eff_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVslSlanDirSeq(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslSlanNm(JSPUtil.getParameter(request, prefix + "vsl_slan_nm", ""));
		setFdrDivCd(JSPUtil.getParameter(request, prefix + "fdr_div_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setAddFlg(JSPUtil.getParameter(request, prefix + "add_flg", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_cd", ""));
		setDirDeltFlg(JSPUtil.getParameter(request, prefix + "dir_delt_flg", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
		setModiVipTeamCd(JSPUtil.getParameter(request, prefix + "modi_vip_team_cd", ""));
		setModiVslSlanDirCd(JSPUtil.getParameter(request, prefix + "modi_vsl_slan_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlaneCodeVO[]
	 */
	public SLaneDirVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlaneCodeVO[]
	 */
	public SLaneDirVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SLaneDirVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] stEffDt = (JSPUtil.getParameter(request, prefix	+ "st_eff_dt", length));
			String[] vslTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_tp_cd", length));
			String[] endEffDt = (JSPUtil.getParameter(request, prefix	+ "end_eff_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vslSlanDirSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] fdrDivCd = (JSPUtil.getParameter(request, prefix	+ "fdr_div_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] addFlg = (JSPUtil.getParameter(request, prefix	+ "add_flg", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] dirDeltFlg = (JSPUtil.getParameter(request, prefix	+ "dir_delt_flg", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] modiVipTeamCd = (JSPUtil.getParameter(request, prefix	+ "modi_vip_team_cd", length));
			String[] modiVslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "modi_vsl_slan_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SLaneDirVO();
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (stEffDt[i] != null)
					model.setStEffDt(stEffDt[i]);
				if (vslTpCd[i] != null)
					model.setVslTpCd(vslTpCd[i]);
				if (endEffDt[i] != null)
					model.setEndEffDt(endEffDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vslSlanDirSeq[i] != null)
					model.setVslSlanDirSeq(vslSlanDirSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (fdrDivCd[i] != null)
					model.setFdrDivCd(fdrDivCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (addFlg[i] != null)
					model.setAddFlg(addFlg[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (dirDeltFlg[i] != null)
					model.setDirDeltFlg(dirDeltFlg[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (modiVipTeamCd[i] != null)
					model.setModiVipTeamCd(modiVipTeamCd[i]);
				if (modiVslSlanDirCd[i] != null)
					model.setModiVslSlanDirCd(modiVslSlanDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSlaneCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSlaneCodeVO[]
	 */
	public SLaneDirVO[] getSearchSlaneCodeVOs(){
		SLaneDirVO[] vos = (SLaneDirVO[])models.toArray(new SLaneDirVO[models.size()]);
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
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stEffDt = this.stEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTpCd = this.vslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEffDt = this.endEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirSeq = this.vslSlanDirSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrDivCd = this.fdrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addFlg = this.addFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirDeltFlg = this.dirDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiVipTeamCd = this.modiVipTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiVslSlanDirCd = this.modiVslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
