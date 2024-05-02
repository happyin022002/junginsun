/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : SearchSceCntrStsMsgMvmtMapgVO.java
 *@FileTitle : SearchSceCntrStsMsgMvmtMapgVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.24
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esd.sce.common.manualinput.vo;

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
 * Creating in related Event, if server requested, it performs as a Value Object Data delivery
 * 
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SceCntrStsMsgMvmtMapgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SceCntrStsMsgMvmtMapgVO> models = new ArrayList<SceCntrStsMsgMvmtMapgVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String stndEdiStsCd = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String csmDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String csmCntCd = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SceCntrStsMsgMvmtMapgVO() {
	}

	public SceCntrStsMsgMvmtMapgVO(String ibflag, String pagerows, String actStsMapgCd, String stndEdiStsCd, String csmDesc, String effFmDt, String effToDt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String csmCntCd) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.effFmDt = effFmDt;
		this.stndEdiStsCd = stndEdiStsCd;
		this.actStsMapgCd = actStsMapgCd;
		this.effToDt = effToDt;
		this.updUsrId = updUsrId;
		this.csmDesc = csmDesc;
		this.pagerows = pagerows;
		this.csmCntCd = csmCntCd;
	}

	/**
	 * HashMap.<br>
	 * 
	 * @param String
	 * @return this.hashColumns
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("stnd_edi_sts_cd", getStndEdiStsCd());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("csm_desc", getCsmDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("csm_cnt_cd", getCsmCntCd());
		return this.hashColumns;
	}

	/**
	 * HashMap.<br>
	 * 
	 * @param String
	 * @return this.hashFields
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("stnd_edi_sts_cd", "stndEdiStsCd");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("csm_desc", "csmDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("csm_cnt_cd", "csmCntCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}

	/**
	 * Column Info
	 * 
	 * @return stndEdiStsCd
	 */
	public String getStndEdiStsCd() {
		return this.stndEdiStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}

	/**
	 * Column Info
	 * 
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return csmDesc
	 */
	public String getCsmDesc() {
		return this.csmDesc;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}

	/**
	 * Column Info
	 * 
	 * @param stndEdiStsCd
	 */
	public void setStndEdiStsCd(String stndEdiStsCd) {
		this.stndEdiStsCd = stndEdiStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}

	/**
	 * Column Info
	 * 
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param csmDesc
	 */
	public void setCsmDesc(String csmDesc) {
		this.csmDesc = csmDesc;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getCsmCntCd() {
		return csmCntCd;
	}

	public void setCsmCntCd(String csmCntCd) {
		this.csmCntCd = csmCntCd;
	}

	/**
	 * fromRequest.<br>
	 * 
	 * @param HttpServletRequest request
	 * @return none
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * fromRequest.<br>
	 * 
	 * @param HttpServletRequest request
	 * @param String prefix
	 * @return none
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setStndEdiStsCd(JSPUtil.getParameter(request, prefix + "stnd_edi_sts_cd", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCsmDesc(JSPUtil.getParameter(request, prefix + "csm_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCsmCntCd(JSPUtil.getParameter(request, prefix + "csm_cnt_cd", ""));
	}

	/**
	 * fromRequestGrid.<br>
	 * 
	 * @param HttpServletRequest request
	 * @param String prefix
	 * @return fromRequestGrid
	 */
	public SceCntrStsMsgMvmtMapgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * fromRequestGrid.<br>
	 * 
	 * @param HttpServletRequest request
	 * @param String prefix
	 * @return getSearchSceCntrStsMsgMvmtMapgVOs
	 */
	public SceCntrStsMsgMvmtMapgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceCntrStsMsgMvmtMapgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix + "eff_fm_dt", length));
			String[] stndEdiStsCd = (JSPUtil.getParameter(request, prefix + "stnd_edi_sts_cd", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix + "eff_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] csmDesc = (JSPUtil.getParameter(request, prefix + "csm_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] csmCntCd = (JSPUtil.getParameter(request, prefix + "csm_cnt_cd", length));

			for (int i = 0; i < length; i++) {
				model = new SceCntrStsMsgMvmtMapgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (stndEdiStsCd[i] != null)
					model.setStndEdiStsCd(stndEdiStsCd[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (csmDesc[i] != null)
					model.setCsmDesc(csmDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (csmCntCd[i] != null)
					model.setCsmCntCd(csmCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSceCntrStsMsgMvmtMapgVOs();
	}

	/**
	 * getSearchSceCntrStsMsgMvmtMapgVOs.<br>
	 * 
	 * @return vos
	 */
	public SceCntrStsMsgMvmtMapgVO[] getSearchSceCntrStsMsgMvmtMapgVOs() {
		SceCntrStsMsgMvmtMapgVO[] vos = (SceCntrStsMsgMvmtMapgVO[]) models.toArray(new SceCntrStsMsgMvmtMapgVO[models.size()]);
		return vos;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public void unDataFormat() {
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndEdiStsCd = this.stndEdiStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmDesc = this.csmDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmCntCd = this.csmCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
