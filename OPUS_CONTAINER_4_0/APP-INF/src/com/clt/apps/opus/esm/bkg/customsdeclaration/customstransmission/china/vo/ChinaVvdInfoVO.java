/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaVvdInfoVO.java
*@FileTitle : ChinaVvdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.02
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

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

public class ChinaVvdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaVvdInfoVO> models = new ArrayList<ChinaVvdInfoVO>();

	/* Column Info */
	private String etaFlg = null;
	/* Column Info */
	private String preClptCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslCallSgnPortLocCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String nxtClptCd = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String etdFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaVvdInfoVO() {}

	public ChinaVvdInfoVO(String ibflag, String pagerows, String vslCallSgnPortLocCd, String preClptCd, String nxtClptCd, String mfSndDt, String vslNm, String etdDt, String etaDt, String etbDt, String etaFlg, String etdFlg) {
		this.etaFlg = etaFlg;
		this.preClptCd = preClptCd;
		this.ibflag = ibflag;
		this.vslCallSgnPortLocCd = vslCallSgnPortLocCd;
		this.etaDt = etaDt;
		this.mfSndDt = mfSndDt;
		this.vslNm = vslNm;
		this.nxtClptCd = nxtClptCd;
		this.etbDt = etbDt;
		this.etdDt = etdDt;
		this.etdFlg = etdFlg;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta_flg", getEtaFlg());
		this.hashColumns.put("pre_clpt_cd", getPreClptCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_call_sgn_port_loc_cd", getVslCallSgnPortLocCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("nxt_clpt_cd", getNxtClptCd());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("etd_flg", getEtdFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta_flg", "etaFlg");
		this.hashFields.put("pre_clpt_cd", "preClptCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_call_sgn_port_loc_cd", "vslCallSgnPortLocCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("nxt_clpt_cd", "nxtClptCd");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("etd_flg", "etdFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return etaFlg
	 */
	public String getEtaFlg() {
		return this.etaFlg;
	}

	/**
	 * Column Info
	 * @return preClptCd
	 */
	public String getPreClptCd() {
		return this.preClptCd;
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
	 * @return vslCallSgnPortLocCd
	 */
	public String getVslCallSgnPortLocCd() {
		return this.vslCallSgnPortLocCd;
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
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
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
	 * @return nxtClptCd
	 */
	public String getNxtClptCd() {
		return this.nxtClptCd;
	}

	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}

	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return etdFlg
	 */
	public String getEtdFlg() {
		return this.etdFlg;
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
	 * @param etaFlg
	 */
	public void setEtaFlg(String etaFlg) {
		this.etaFlg = etaFlg;
	}

	/**
	 * Column Info
	 * @param preClptCd
	 */
	public void setPreClptCd(String preClptCd) {
		this.preClptCd = preClptCd;
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
	 * @param vslCallSgnPortLocCd
	 */
	public void setVslCallSgnPortLocCd(String vslCallSgnPortLocCd) {
		this.vslCallSgnPortLocCd = vslCallSgnPortLocCd;
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
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
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
	 * @param nxtClptCd
	 */
	public void setNxtClptCd(String nxtClptCd) {
		this.nxtClptCd = nxtClptCd;
	}

	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}

	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param etdFlg
	 */
	public void setEtdFlg(String etdFlg) {
		this.etdFlg = etdFlg;
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
		setEtaFlg(JSPUtil.getParameter(request, prefix + "eta_flg", ""));
		setPreClptCd(JSPUtil.getParameter(request, prefix + "pre_clpt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslCallSgnPortLocCd(JSPUtil.getParameter(request, prefix + "vsl_call_sgn_port_loc_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setNxtClptCd(JSPUtil.getParameter(request, prefix + "nxt_clpt_cd", ""));
		setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setEtdFlg(JSPUtil.getParameter(request, prefix + "etd_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaVvdInfoVO[]
	 */
	public ChinaVvdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaVvdInfoVO[]
	 */
	public ChinaVvdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaVvdInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] etaFlg = (JSPUtil.getParameter(request, prefix	+ "eta_flg", length));
			String[] preClptCd = (JSPUtil.getParameter(request, prefix	+ "pre_clpt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslCallSgnPortLocCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_port_loc_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] nxtClptCd = (JSPUtil.getParameter(request, prefix	+ "nxt_clpt_cd", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] etdFlg = (JSPUtil.getParameter(request, prefix	+ "etd_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaVvdInfoVO();
				if (etaFlg[i] != null)
					model.setEtaFlg(etaFlg[i]);
				if (preClptCd[i] != null)
					model.setPreClptCd(preClptCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCallSgnPortLocCd[i] != null)
					model.setVslCallSgnPortLocCd(vslCallSgnPortLocCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (nxtClptCd[i] != null)
					model.setNxtClptCd(nxtClptCd[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (etdFlg[i] != null)
					model.setEtdFlg(etdFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaVvdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaVvdInfoVO[]
	 */
	public ChinaVvdInfoVO[] getChinaVvdInfoVOs(){
		ChinaVvdInfoVO[] vos = (ChinaVvdInfoVO[])models.toArray(new ChinaVvdInfoVO[models.size()]);
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
		this.etaFlg = this.etaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preClptCd = this.preClptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnPortLocCd = this.vslCallSgnPortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtClptCd = this.nxtClptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdFlg = this.etdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
