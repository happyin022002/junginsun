/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChinaOfficeInfoVO.java
*@FileTitle : ChinaOfficeInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.04 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaOfficeInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaOfficeInfoVO> models = new ArrayList<ChinaOfficeInfoVO>();

	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String autoDpChkFlg = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String agnEml = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String vndrDeltFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgBlckFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String agnNm = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String fincOfcCd = null;
	/* Column Info */
	private String dirPayOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaOfficeInfoVO() {}

	public ChinaOfficeInfoVO(String ibflag, String pagerows, String chnAgnCd, String agnNm, String vndrSeq, String vndrLglEngNm, String fincOfcCd, String deltFlg, String vndrDeltFlg, String bkgBlckFlg, String vndrCntCd, String ofcCd, String diffRmk, String custCntCd, String custSeq, String autoDpChkFlg, String agnEml, String arOfcCd, String dirPayOfcCd, String updUsrId) {
		this.vndrCntCd = vndrCntCd;
		this.deltFlg = deltFlg;
		this.autoDpChkFlg = autoDpChkFlg;
		this.vndrLglEngNm = vndrLglEngNm;
		this.agnEml = agnEml;
		this.custSeq = custSeq;
		this.arOfcCd = arOfcCd;
		this.vndrDeltFlg = vndrDeltFlg;
		this.pagerows = pagerows;
		this.bkgBlckFlg = bkgBlckFlg;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.agnNm = agnNm;
		this.vndrSeq = vndrSeq;
		this.chnAgnCd = chnAgnCd;
		this.fincOfcCd = fincOfcCd;
		this.dirPayOfcCd = dirPayOfcCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("auto_dp_chk_flg", getAutoDpChkFlg());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("agn_eml", getAgnEml());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("vndr_delt_flg", getVndrDeltFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_blck_flg", getBkgBlckFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("agn_nm", getAgnNm());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("finc_ofc_cd", getFincOfcCd());
		this.hashColumns.put("dir_pay_ofc_cd", getDirPayOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("auto_dp_chk_flg", "autoDpChkFlg");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agn_eml", "agnEml");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("vndr_delt_flg", "vndrDeltFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_blck_flg", "bkgBlckFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("agn_nm", "agnNm");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("finc_ofc_cd", "fincOfcCd");
		this.hashFields.put("dir_pay_ofc_cd", "dirPayOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return autoDpChkFlg
	 */
	public String getAutoDpChkFlg() {
		return this.autoDpChkFlg;
	}

	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @return agnEml
	 */
	public String getAgnEml() {
		return this.agnEml;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	/**
	 * Column Info
	 * @return vndrDeltFlg
	 */
	public String getVndrDeltFlg() {
		return this.vndrDeltFlg;
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
	 * @return bkgBlckFlg
	 */
	public String getBkgBlckFlg() {
		return this.bkgBlckFlg;
	}

	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}

	/**
	 * Column Info
	 * @return agnNm
	 */
	public String getAgnNm() {
		return this.agnNm;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}

	/**
	 * Column Info
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
	}

	/**
	 * Column Info
	 * @return fincOfcCd
	 */
	public String getFincOfcCd() {
		return this.fincOfcCd;
	}

	/**
	 * Column Info
	 * @return dirPayOfcCd
	 */
	public String getDirPayOfcCd() {
		return this.dirPayOfcCd;
	}

	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param autoDpChkFlg
	 */
	public void setAutoDpChkFlg(String autoDpChkFlg) {
		this.autoDpChkFlg = autoDpChkFlg;
	}

	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @param agnEml
	 */
	public void setAgnEml(String agnEml) {
		this.agnEml = agnEml;
	}

	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * Column Info
	 * @param vndrDeltFlg
	 */
	public void setVndrDeltFlg(String vndrDeltFlg) {
		this.vndrDeltFlg = vndrDeltFlg;
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
	 * @param bkgBlckFlg
	 */
	public void setBkgBlckFlg(String bkgBlckFlg) {
		this.bkgBlckFlg = bkgBlckFlg;
	}

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}

	/**
	 * Column Info
	 * @param agnNm
	 */
	public void setAgnNm(String agnNm) {
		this.agnNm = agnNm;
	}

	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * Column Info
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
	}

	/**
	 * Column Info
	 * @param fincOfcCd
	 */
	public void setFincOfcCd(String fincOfcCd) {
		this.fincOfcCd = fincOfcCd;
	}

	/**
	 * Column Info
	 * @param dirPayOfcCd
	 */
	public void setDirPayOfcCd(String dirPayOfcCd) {
		this.dirPayOfcCd = dirPayOfcCd;
	}

	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAutoDpChkFlg(JSPUtil.getParameter(request, prefix + "auto_dp_chk_flg", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setAgnEml(JSPUtil.getParameter(request, prefix + "agn_eml", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setVndrDeltFlg(JSPUtil.getParameter(request, prefix + "vndr_delt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgBlckFlg(JSPUtil.getParameter(request, prefix + "bkg_blck_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setAgnNm(JSPUtil.getParameter(request, prefix + "agn_nm", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setChnAgnCd(JSPUtil.getParameter(request, prefix + "chn_agn_cd", ""));
		setFincOfcCd(JSPUtil.getParameter(request, prefix + "finc_ofc_cd", ""));
		setDirPayOfcCd(JSPUtil.getParameter(request, prefix + "dir_pay_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaOfficeInfoVO[]
	 */
	public ChinaOfficeInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaOfficeInfoVO[]
	 */
	public ChinaOfficeInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaOfficeInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] autoDpChkFlg = (JSPUtil.getParameter(request, prefix	+ "auto_dp_chk_flg", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] agnEml = (JSPUtil.getParameter(request, prefix	+ "agn_eml", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] vndrDeltFlg = (JSPUtil.getParameter(request, prefix	+ "vndr_delt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgBlckFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_blck_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] agnNm = (JSPUtil.getParameter(request, prefix	+ "agn_nm", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] fincOfcCd = (JSPUtil.getParameter(request, prefix	+ "finc_ofc_cd", length));
			String[] dirPayOfcCd = (JSPUtil.getParameter(request, prefix	+ "dir_pay_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaOfficeInfoVO();
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (autoDpChkFlg[i] != null)
					model.setAutoDpChkFlg(autoDpChkFlg[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (agnEml[i] != null)
					model.setAgnEml(agnEml[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (vndrDeltFlg[i] != null)
					model.setVndrDeltFlg(vndrDeltFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgBlckFlg[i] != null)
					model.setBkgBlckFlg(bkgBlckFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (agnNm[i] != null)
					model.setAgnNm(agnNm[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (fincOfcCd[i] != null)
					model.setFincOfcCd(fincOfcCd[i]);
				if (dirPayOfcCd[i] != null)
					model.setDirPayOfcCd(dirPayOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaOfficeInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaOfficeInfoVO[]
	 */
	public ChinaOfficeInfoVO[] getChinaOfficeInfoVOs(){
		ChinaOfficeInfoVO[] vos = (ChinaOfficeInfoVO[])models.toArray(new ChinaOfficeInfoVO[models.size()]);
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
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoDpChkFlg = this.autoDpChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnEml = this.agnEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrDeltFlg = this.vndrDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlckFlg = this.bkgBlckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnNm = this.agnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincOfcCd = this.fincOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirPayOfcCd = this.dirPayOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
