/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PriScPfxMapgListVO.java
 *@FileTitle : PriScPfxMapgListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.30
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.04.30 문동규 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.primasterdata.scprefix.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 문동규
 * @since J2EE 1.5
 */

public class PriScPfxMapgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PriScPfxMapgListVO> models = new ArrayList<PriScPfxMapgListVO>();

	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String scontiNm = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String scPfxCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String svcScpNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String scPfxDesc = null;
	/* Column Info */
	private String scontiCd = null;
	/* Page Number */
	private String pagerows = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * 
	 */
	public PriScPfxMapgListVO() {
	}

	/**
	 * @param ibflag
	 * @param pagerows
	 * @param svcScpCd
	 * @param svcScpNm
	 * @param scontiCd
	 * @param scontiNm
	 * @param scPfxCd
	 * @param scPfxDesc
	 * @param creUsrId
	 * @param creDt
	 * @param updUsrId
	 * @param updDt
	 */
	public PriScPfxMapgListVO(String ibflag, String pagerows, String svcScpCd, String svcScpNm, String scontiCd,
			String scontiNm, String scPfxCd, String scPfxDesc, String creUsrId, String creDt, String updUsrId,
			String updDt) {
		this.updUsrId = updUsrId;
		this.scontiNm = scontiNm;
		this.ibflag = ibflag;
		this.updDt = updDt;
		this.scPfxCd = scPfxCd;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.svcScpNm = svcScpNm;
		this.svcScpCd = svcScpCd;
		this.scPfxDesc = scPfxDesc;
		this.scontiCd = scontiCd;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues () {
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sc_pfx_cd", getScPfxCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("svc_scp_nm", getSvcScpNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("sc_pfx_desc", getScPfxDesc());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames () {
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sc_pfx_cd", "scPfxCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("svc_scp_nm", "svcScpNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sc_pfx_desc", "scPfxDesc");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * @return
	 */
	public String getUpdUsrId () {
		return this.updUsrId;
	}

	/**
	 * @return
	 */
	public String getScontiNm () {
		return this.scontiNm;
	}

	/**
	 * @return
	 */
	public String getIbflag () {
		return this.ibflag;
	}

	/**
	 * @return
	 */
	public String getUpdDt () {
		return this.updDt;
	}

	/**
	 * @return
	 */
	public String getScPfxCd () {
		return this.scPfxCd;
	}

	/**
	 * @return
	 */
	public String getCreDt () {
		return this.creDt;
	}

	/**
	 * @return
	 */
	public String getCreUsrId () {
		return this.creUsrId;
	}

	/**
	 * @return
	 */
	public String getSvcScpNm () {
		return this.svcScpNm;
	}

	/**
	 * @return
	 */
	public String getSvcScpCd () {
		return this.svcScpCd;
	}

	/**
	 * @return
	 */
	public String getScPfxDesc () {
		return this.scPfxDesc;
	}

	/**
	 * @return
	 */
	public String getScontiCd () {
		return this.scontiCd;
	}

	/**
	 * @return
	 */
	public String getPagerows () {
		return this.pagerows;
	}

	/**
	 * @param updUsrId
	 */
	public void setUpdUsrId (String updUsrId) {
		this.updUsrId = updUsrId;
		// this.updUsrId=true;
	}

	/**
	 * @param scontiNm
	 */
	public void setScontiNm (String scontiNm) {
		this.scontiNm = scontiNm;
		// this.scontiNm=true;
	}

	/**
	 * @param ibflag
	 */
	public void setIbflag (String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	/**
	 * @param updDt
	 */
	public void setUpdDt (String updDt) {
		this.updDt = updDt;
		// this.updDt=true;
	}

	/**
	 * @param scPfxCd
	 */
	public void setScPfxCd (String scPfxCd) {
		this.scPfxCd = scPfxCd;
		// this.scPfxCd=true;
	}

	/**
	 * @param creDt
	 */
	public void setCreDt (String creDt) {
		this.creDt = creDt;
		// this.creDt=true;
	}

	/**
	 * @param creUsrId
	 */
	public void setCreUsrId (String creUsrId) {
		this.creUsrId = creUsrId;
		// this.creUsrId=true;
	}

	/**
	 * @param svcScpNm
	 */
	public void setSvcScpNm (String svcScpNm) {
		this.svcScpNm = svcScpNm;
		// this.svcScpNm=true;
	}

	/**
	 * @param svcScpCd
	 */
	public void setSvcScpCd (String svcScpCd) {
		this.svcScpCd = svcScpCd;
		// this.svcScpCd=true;
	}

	/**
	 * @param scPfxDesc
	 */
	public void setScPfxDesc (String scPfxDesc) {
		this.scPfxDesc = scPfxDesc;
		// this.scPfxDesc=true;
	}

	/**
	 * @param scontiCd
	 */
	public void setScontiCd (String scontiCd) {
		this.scontiCd = scontiCd;
		// this.scontiCd=true;
	}

	/**
	 * @param pagerows
	 */
	public void setPagerows (String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	/**
	 * @param request
	 */
	public void fromRequest (HttpServletRequest request) {
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setScPfxCd(JSPUtil.getParameter(request, "sc_pfx_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSvcScpNm(JSPUtil.getParameter(request, "svc_scp_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setScPfxDesc(JSPUtil.getParameter(request, "sc_pfx_desc", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * @param request
	 * @return
	 */
	public PriScPfxMapgListVO[] fromRequestGrid (HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * @param request
	 * @param prefix
	 * @return
	 */
	public PriScPfxMapgListVO[] fromRequestGrid (HttpServletRequest request, String prefix) {
		PriScPfxMapgListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
			String[] scontiNm = (JSPUtil.getParameter(request, prefix + "sconti_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
			String[] scPfxCd = (JSPUtil.getParameter(request, prefix + "sc_pfx_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
			String[] svcScpNm = (JSPUtil.getParameter(request, prefix + "svc_scp_nm".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] scPfxDesc = (JSPUtil.getParameter(request, prefix + "sc_pfx_desc".trim(), length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix + "sconti_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new PriScPfxMapgListVO();
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (scPfxCd[i] != null)
					model.setScPfxCd(scPfxCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (svcScpNm[i] != null)
					model.setSvcScpNm(svcScpNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (scPfxDesc[i] != null)
					model.setScPfxDesc(scPfxDesc[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
		}
		return getPriScPfxMapgListVOs();
	}

	/**
	 * @return
	 */
	public PriScPfxMapgListVO[] getPriScPfxMapgListVOs () {
		PriScPfxMapgListVO[] vos = (PriScPfxMapgListVO[]) models.toArray(new PriScPfxMapgListVO[models.size()]);
		return vos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString () {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField (Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

	/**
	 * DataFormat 설정
	 */
	public void onDataFormat () {
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiNm = this.scontiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scPfxCd = this.scPfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpNm = this.svcScpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scPfxDesc = this.scPfxDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
