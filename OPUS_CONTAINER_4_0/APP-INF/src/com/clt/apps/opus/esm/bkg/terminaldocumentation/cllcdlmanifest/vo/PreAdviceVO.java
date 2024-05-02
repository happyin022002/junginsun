/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PreAdviceVO.java
*@FileTitle : PreAdviceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.03
*@LastModifier :
*@LastVersion : 1.0
* 2012.09.03
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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

public class PreAdviceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PreAdviceVO> models = new ArrayList<PreAdviceVO>();

	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sPolCd = null;
	/* Column Info */
	private String sPorCd = null;
	/* Column Info */
	private String opFmDt = null;
	/* Column Info */
	private String opToDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sFullRtnYdNodCd = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String sFullRtnYdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PreAdviceVO() {}

	public PreAdviceVO(String ibflag, String pagerows, String sVvd, String sPolCd, String sFullRtnYdCd, String sFullRtnYdNodCd, String vvd, String polCd, String podCd, String delCd, String sPorCd, String opFmDt, String opToDt) {
		this.podCd = podCd;
		this.vvd = vvd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.sPolCd = sPolCd;
		this.sPorCd = sPorCd;
		this.opFmDt = opFmDt;
		this.opToDt = opToDt;
		this.delCd = delCd;
		this.sFullRtnYdNodCd = sFullRtnYdNodCd;
		this.sVvd = sVvd;
		this.sFullRtnYdCd = sFullRtnYdCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_pol_cd", getSPolCd());
		this.hashColumns.put("s_por_cd", getSPorCd());
		this.hashColumns.put("op_fm_dt", getOpFmDt());
		this.hashColumns.put("op_to_dt", getOpToDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("s_full_rtn_yd_nod_cd", getSFullRtnYdNodCd());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("s_full_rtn_yd_cd", getSFullRtnYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_pol_cd", "sPolCd");
		this.hashFields.put("s_por_cd", "sPorCd");
		this.hashFields.put("op_fm_dt", "sOpFmDt");
		this.hashFields.put("op_to_dt", "sOpToDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("s_full_rtn_yd_nod_cd", "sFullRtnYdNodCd");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("s_full_rtn_yd_cd", "sFullRtnYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return sPolCd
	 */
	public String getSPolCd() {
		return this.sPolCd;
	}
	/**
	 * Column Info
	 * @return sPorCd
	 */
	public String getSPorCd() {
		return this.sPorCd;
	}
	/**
	 * Column Info
	 * @return opFmDt
	 */
	public String getOpFmDt() {
		return this.opFmDt;
	}
	/**
	 * Column Info
	 * @return opToDt
	 */
	public String getOpToDt() {
		return this.opToDt;
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
	 * @return sFullRtnYdNodCd
	 */
	public String getSFullRtnYdNodCd() {
		return this.sFullRtnYdNodCd;
	}

	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}

	/**
	 * Column Info
	 * @return sFullRtnYdCd
	 */
	public String getSFullRtnYdCd() {
		return this.sFullRtnYdCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param sPolCd
	 */
	public void setSPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
	}
	/**
	 * Column Info
	 * @param sPorCd
	 */
	public void setSPorCd(String sPorCd) {
		this.sPorCd = sPorCd;
	}
	/**
	 * Column Info
	 * @param opFmDt
	 */
	public void setOpFmDt(String opFmDt) {
		this.opFmDt = opFmDt;
	}
	/**
	 * Column Info
	 * @param opToDt
	 */
	public void setOpToDt(String opToDt) {
		this.opToDt = opToDt;
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
	 * @param sFullRtnYdNodCd
	 */
	public void setSFullRtnYdNodCd(String sFullRtnYdNodCd) {
		this.sFullRtnYdNodCd = sFullRtnYdNodCd;
	}

	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}

	/**
	 * Column Info
	 * @param sFullRtnYdCd
	 */
	public void setSFullRtnYdCd(String sFullRtnYdCd) {
		this.sFullRtnYdCd = sFullRtnYdCd;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSPolCd(JSPUtil.getParameter(request, prefix + "s_pol_cd", ""));
		setSPorCd(JSPUtil.getParameter(request, prefix + "s_por_cd", ""));
		setOpFmDt(JSPUtil.getParameter(request, prefix + "op_fm_dt", ""));
		setOpToDt(JSPUtil.getParameter(request, prefix + "op_to_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSFullRtnYdNodCd(JSPUtil.getParameter(request, prefix + "s_full_rtn_yd_nod_cd", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setSFullRtnYdCd(JSPUtil.getParameter(request, prefix + "s_full_rtn_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreAdviceVO[]
	 */
	public PreAdviceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PreAdviceVO[]
	 */
	public PreAdviceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreAdviceVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sPolCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_cd", length));
			String[] sPorCd = (JSPUtil.getParameter(request, prefix	+ "s_por_cd", length));
			String[] opFmDt = (JSPUtil.getParameter(request, prefix	+ "op_fm_dt", length));
			String[] opToDt = (JSPUtil.getParameter(request, prefix	+ "op_to_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] sFullRtnYdNodCd = (JSPUtil.getParameter(request, prefix	+ "s_full_rtn_yd_nod_cd", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] sFullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "s_full_rtn_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new PreAdviceVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sPolCd[i] != null)
					model.setSPolCd(sPolCd[i]);
				if (sPorCd[i] != null)
					model.setSPorCd(sPorCd[i]);
				if (opFmDt[i] != null)
					model.setOpFmDt(opFmDt[i]);
				if (opToDt[i] != null)
					model.setOpToDt(opToDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sFullRtnYdNodCd[i] != null)
					model.setSFullRtnYdNodCd(sFullRtnYdNodCd[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (sFullRtnYdCd[i] != null)
					model.setSFullRtnYdCd(sFullRtnYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreAdviceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreAdviceVO[]
	 */
	public PreAdviceVO[] getPreAdviceVOs(){
		PreAdviceVO[] vos = (PreAdviceVO[])models.toArray(new PreAdviceVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolCd = this.sPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPorCd = this.sPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opFmDt = this.opFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opToDt = this.opToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFullRtnYdNodCd = this.sFullRtnYdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFullRtnYdCd = this.sFullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
