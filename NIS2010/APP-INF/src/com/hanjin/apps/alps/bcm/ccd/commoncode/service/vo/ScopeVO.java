/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchScpCodeVO.java
*@FileTitle : SearchScpCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo;
 
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScopeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScopeVO> models = new ArrayList<ScopeVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmcFileFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String confFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String svcScpBndCd = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String svcScpNm = null;
	/* Column Info */
	private String rqstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String modiCostCtrCd = null;
	
	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;
	
	private String modiSvcGrpCd = null;
	private String dmntFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScopeVO() {}

	public ScopeVO(String ibflag, String pagerows, String svcScpNm, String svcScpBndCd, String confFlg, String fmcFileFlg, String trfPfxCd, String trfNo, String deltFlg, String svcScpCd, String userId, String rqstNo, String modiCostCtrCd, String creUsrId, String creDt, String updUsrId, String updDt, String modiSvcGrpCd, String dmntFlg) {
		this.ibflag = ibflag;
		this.fmcFileFlg = fmcFileFlg;
		this.deltFlg = deltFlg;
		this.confFlg = confFlg;
		this.svcScpCd = svcScpCd;
		this.trfNo = trfNo;
		this.userId = userId;
		this.svcScpBndCd = svcScpBndCd;
		this.trfPfxCd = trfPfxCd;
		this.svcScpNm = svcScpNm;
		this.rqstNo = rqstNo;
		this.pagerows = pagerows;
		this.modiCostCtrCd = modiCostCtrCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.modiSvcGrpCd = modiSvcGrpCd;
		this.dmntFlg = dmntFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmc_file_flg", getFmcFileFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("conf_flg", getConfFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("svc_scp_bnd_cd", getSvcScpBndCd());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("svc_scp_nm", getSvcScpNm());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("modi_cost_ctr_cd", getModiCostCtrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("modi_svc_grp_cd", getModiSvcGrpCd());
		this.hashColumns.put("dmnt_flg", getDmntFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmc_file_flg", "fmcFileFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("conf_flg", "confFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("svc_scp_bnd_cd", "svcScpBndCd");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("svc_scp_nm", "svcScpNm");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("modi_cost_ctr_cd", "modiCostCtrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("modi_svc_grp_cd", "modiSvcGrpCd");
		this.hashFields.put("dmnt_flg", "dmntFlg");
		return this.hashFields;
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
	 * @return fmcFileFlg
	 */
	public String getFmcFileFlg() {
		return this.fmcFileFlg;
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
	 * @return confFlg
	 */
	public String getConfFlg() {
		return this.confFlg;
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
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
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
	 * @return svcScpBndCd
	 */
	public String getSvcScpBndCd() {
		return this.svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpNm
	 */
	public String getSvcScpNm() {
		return this.svcScpNm;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fmcFileFlg
	 */
	public void setFmcFileFlg(String fmcFileFlg) {
		this.fmcFileFlg = fmcFileFlg;
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
	 * @param confFlg
	 */
	public void setConfFlg(String confFlg) {
		this.confFlg = confFlg;
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
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
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
	 * @param svcScpBndCd
	 */
	public void setSvcScpBndCd(String svcScpBndCd) {
		this.svcScpBndCd = svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpNm
	 */
	public void setSvcScpNm(String svcScpNm) {
		this.svcScpNm = svcScpNm;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getModiCostCtrCd() {
		return modiCostCtrCd;
	}

	public void setModiCostCtrCd(String modiCostCtrCd) {
		this.modiCostCtrCd = modiCostCtrCd;
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

	public String getModiSvcGrpCd() {
		return modiSvcGrpCd;
	}

	public void setModiSvcGrpCd(String modiSvcGrpCd) {
		this.modiSvcGrpCd = modiSvcGrpCd;
	}

	public String getDmntFlg() {
		return dmntFlg;
	}

	public void setDmntFlg(String dmntFlg) {
		this.dmntFlg = dmntFlg;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmcFileFlg(JSPUtil.getParameter(request, prefix + "fmc_file_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setConfFlg(JSPUtil.getParameter(request, prefix + "conf_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setSvcScpBndCd(JSPUtil.getParameter(request, prefix + "svc_scp_bnd_cd", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setSvcScpNm(JSPUtil.getParameter(request, prefix + "svc_scp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqstNo", ""));
		setModiCostCtrCd(JSPUtil.getParameter(request, prefix + "modi_cost_ctr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setModiSvcGrpCd(JSPUtil.getParameter(request, prefix + "modi_svc_grp_cd", ""));
		setDmntFlg(JSPUtil.getParameter(request, prefix + "dmnt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScpCodeVO[]
	 */
	public ScopeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScpCodeVO[]
	 */
	public ScopeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScopeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmcFileFlg = (JSPUtil.getParameter(request, prefix	+ "fmc_file_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] confFlg = (JSPUtil.getParameter(request, prefix	+ "conf_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] svcScpBndCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_bnd_cd", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] svcScpNm = (JSPUtil.getParameter(request, prefix	+ "svc_scp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqstNo", length));
			String[] modiCostCtrCd = (JSPUtil.getParameter(request, prefix	+ "modi_cost_ctr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] modiSvcGrpCd = (JSPUtil.getParameter(request, prefix	+ "modi_svc_grp_cd", length));
			String[] dmntFlg = (JSPUtil.getParameter(request, prefix	+ "dmnt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScopeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmcFileFlg[i] != null)
					model.setFmcFileFlg(fmcFileFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (confFlg[i] != null)
					model.setConfFlg(confFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (svcScpBndCd[i] != null)
					model.setSvcScpBndCd(svcScpBndCd[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (svcScpNm[i] != null)
					model.setSvcScpNm(svcScpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (modiCostCtrCd[i] != null)
					model.setModiCostCtrCd(modiCostCtrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (modiSvcGrpCd[i] != null)
					model.setModiSvcGrpCd(modiSvcGrpCd[i]);
				if (dmntFlg[i] != null)
					model.setDmntFlg(dmntFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScpCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScpCodeVO[]
	 */
	public ScopeVO[] getSearchScpCodeVOs(){
		ScopeVO[] vos = (ScopeVO[])models.toArray(new ScopeVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcFileFlg = this.fmcFileFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confFlg = this.confFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpBndCd = this.svcScpBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpNm = this.svcScpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiCostCtrCd = this.modiCostCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiSvcGrpCd = this.modiSvcGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmntFlg = this.dmntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
