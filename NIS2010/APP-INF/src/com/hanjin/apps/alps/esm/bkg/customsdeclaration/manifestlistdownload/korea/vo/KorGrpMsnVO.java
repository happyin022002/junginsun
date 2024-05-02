/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorGrpMsnVO.java
*@FileTitle : KorGrpMsnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.17 박상훈 
* 1.0 Creation
* 2011.12.09 김종호 [CHM-201114963] [BKG] warehouse Assign by B/L 수정 요청
* 2012.01.10 박성호 [선처리] [BKG]  BKG_CSTMS_KR_MF_SEQ_NO.VIA_WEB_FLG 처리 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorGrpMsnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorGrpMsnVO> models = new ArrayList<KorGrpMsnVO>();
	
	/* Column Info */
	private String grpPod = null;
	/* Column Info */
	private String grpMrn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grpEtd = null;
	/* Column Info */
	private String grpVvd = null;
	/* Column Info */
	private String grpMrnChk = null;
	/* Column Info */
	private String grpPol = null;
	/* Column Info */
	private String grpEta = null;
	/* Column Info */
	private String grpEtaDtl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String viaWebFlg = null;
	/* Column Info */
	private String viaWebDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorGrpMsnVO() {}

	public KorGrpMsnVO(String ibflag, String pagerows, String grpMrn, String grpMrnChk, String grpVvd, String grpPol, String grpPod, String grpEtd, String grpEta, String grpEtaDtl, String updUsrId, String updDt, String viaWebFlg, String viaWebDt) {
		this.grpPod = grpPod;
		this.grpMrn = grpMrn;
		this.ibflag = ibflag;
		this.grpEtd = grpEtd;
		this.grpVvd = grpVvd;
		this.viaWebDt = viaWebDt;
		this.grpMrnChk = grpMrnChk;
		this.grpPol = grpPol;
		this.grpEta = grpEta;
		this.grpEtaDtl = grpEtaDtl;
		this.pagerows = pagerows;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.viaWebFlg = viaWebFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp_pod", getGrpPod());
		this.hashColumns.put("grp_mrn", getGrpMrn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_etd", getGrpEtd());
		this.hashColumns.put("grp_vvd", getGrpVvd());
		this.hashColumns.put("via_web_dt", getViaWebDt());
		this.hashColumns.put("grp_mrn_chk", getGrpMrnChk());
		this.hashColumns.put("grp_pol", getGrpPol());
		this.hashColumns.put("grp_eta", getGrpEta());
		this.hashColumns.put("grp_eta_dtl", getGrpEtaDtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("via_web_flg", getViaWebFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp_pod", "grpPod");
		this.hashFields.put("grp_mrn", "grpMrn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_etd", "grpEtd");
		this.hashFields.put("grp_vvd", "grpVvd");
		this.hashFields.put("via_web_dt", "viaWebDt");
		this.hashFields.put("grp_mrn_chk", "grpMrnChk");
		this.hashFields.put("grp_pol", "grpPol");
		this.hashFields.put("grp_eta", "grpEta");
		this.hashFields.put("grp_eta_dtl", "grpEtaDtl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("via_web_flg", "viaWebFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grpPod
	 */
	public String getGrpPod() {
		return this.grpPod;
	}
	
	/**
	 * Column Info
	 * @return grpMrn
	 */
	public String getGrpMrn() {
		return this.grpMrn;
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
	 * @return grpEtd
	 */
	public String getGrpEtd() {
		return this.grpEtd;
	}
	
	/**
	 * Column Info
	 * @return grpVvd
	 */
	public String getGrpVvd() {
		return this.grpVvd;
	}
	
	/**
	 * Column Info
	 * @return grpMrnChk
	 */
	public String getGrpMrnChk() {
		return this.grpMrnChk;
	}
	
	/**
	 * Column Info
	 * @return grpPol
	 */
	public String getGrpPol() {
		return this.grpPol;
	}
	
	/**
	 * Column Info
	 * @return grpEta
	 */
	public String getGrpEta() {
		return this.grpEta;
	}
	
	/**
	 * Column Info
	 * @return grpEtaDtl
	 */
	public String getGrpEtaDtl() {
		return this.grpEtaDtl;
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
	 * @return viaWebFlg
	 */
	public String getViaWebFlg() {
		return this.viaWebFlg;
	}
	
	/**
	 * Column Info
	 * @return viaWebDt
	 */
	public String getViaWebDt() {
		return this.viaWebDt;
	}
	
	/**
	 * Column Info
	 * @param grpPod
	 */
	public void setGrpPod(String grpPod) {
		this.grpPod = grpPod;
	}
	
	/**
	 * Column Info
	 * @param grpMrn
	 */
	public void setGrpMrn(String grpMrn) {
		this.grpMrn = grpMrn;
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
	 * @param grpEtd
	 */
	public void setGrpEtd(String grpEtd) {
		this.grpEtd = grpEtd;
	}
	
	/**
	 * Column Info
	 * @param grpVvd
	 */
	public void setGrpVvd(String grpVvd) {
		this.grpVvd = grpVvd;
	}
	
	/**
	 * Column Info
	 * @param grpMrnChk
	 */
	public void setGrpMrnChk(String grpMrnChk) {
		this.grpMrnChk = grpMrnChk;
	}
	
	/**
	 * Column Info
	 * @param grpPol
	 */
	public void setGrpPol(String grpPol) {
		this.grpPol = grpPol;
	}
	
	/**
	 * Column Info
	 * @param grpEta
	 */
	public void setGrpEta(String grpEta) {
		this.grpEta = grpEta;
	}
	
	/**
	 * Column Info
	 * @param grpEtaDtl
	 */
	public void setGrpEtaDtl(String grpEtaDtl) {
		this.grpEtaDtl = grpEtaDtl;
	}
	
	/**
	 * Column Info
	 * @param viaWebDt
	 */
	public void setViaWebDt(String viaWebDt) {
		this.viaWebDt = viaWebDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the updDt
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * @param updDt the updDt to set
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param viaWebFlg
	 */
	public void setViaWebFlg(String viaWebFlg) {
		this.viaWebFlg = viaWebFlg;
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
		setGrpPod(JSPUtil.getParameter(request, prefix + "grp_pod", ""));
		setGrpMrn(JSPUtil.getParameter(request, prefix + "grp_mrn", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGrpEtd(JSPUtil.getParameter(request, prefix + "grp_etd", ""));
		setViaWebDt(JSPUtil.getParameter(request, prefix + "via_web_dt", ""));
		setViaWebFlg(JSPUtil.getParameter(request, prefix + "via_web_flg", ""));
		setGrpVvd(JSPUtil.getParameter(request, prefix + "grp_vvd", ""));
		setGrpMrnChk(JSPUtil.getParameter(request, prefix + "grp_mrn_chk", ""));
		setGrpPol(JSPUtil.getParameter(request, prefix + "grp_pol", ""));
		setGrpEta(JSPUtil.getParameter(request, prefix + "grp_eta", ""));
		setGrpEtaDtl(JSPUtil.getParameter(request, prefix + "grp_eta_dtl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorGrpMsnVO[]
	 */
	public KorGrpMsnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorGrpMsnVO[]
	 */
	public KorGrpMsnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorGrpMsnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grpPod = (JSPUtil.getParameter(request, prefix	+ "grp_pod", length));
			String[] grpMrn = (JSPUtil.getParameter(request, prefix	+ "grp_mrn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grpEtd = (JSPUtil.getParameter(request, prefix	+ "grp_etd", length));
			String[] viaWebDt = (JSPUtil.getParameter(request, prefix	+ "via_web_dt", length));
			String[] viaWebFlg = (JSPUtil.getParameter(request, prefix	+ "via_web_flg", length));
			String[] grpVvd = (JSPUtil.getParameter(request, prefix	+ "grp_vvd", length));
			String[] grpMrnChk = (JSPUtil.getParameter(request, prefix	+ "grp_mrn_chk", length));
			String[] grpPol = (JSPUtil.getParameter(request, prefix	+ "grp_pol", length));
			String[] grpEta = (JSPUtil.getParameter(request, prefix	+ "grp_eta", length));
			String[] grpEtaDtl = (JSPUtil.getParameter(request, prefix	+ "grp_eta_dtl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorGrpMsnVO();
				if (grpPod[i] != null)
					model.setGrpPod(grpPod[i]);
				if (grpMrn[i] != null)
					model.setGrpMrn(grpMrn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpEtd[i] != null)
					model.setGrpEtd(grpEtd[i]);
				if (viaWebDt[i] != null)
					model.setViaWebDt(viaWebDt[i]);
				if (viaWebFlg[i] != null)
					model.setViaWebFlg(viaWebFlg[i]);
				if (grpVvd[i] != null)
					model.setGrpVvd(grpVvd[i]);
				if (grpMrnChk[i] != null)
					model.setGrpMrnChk(grpMrnChk[i]);
				if (grpPol[i] != null)
					model.setGrpPol(grpPol[i]);
				if (grpEta[i] != null)
					model.setGrpEta(grpEta[i]);
				if (grpEtaDtl[i] != null)
					model.setGrpEtaDtl(grpEtaDtl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorGrpMsnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorGrpMsnVO[]
	 */
	public KorGrpMsnVO[] getKorGrpMsnVOs(){
		KorGrpMsnVO[] vos = (KorGrpMsnVO[])models.toArray(new KorGrpMsnVO[models.size()]);
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
		this.grpPod = this.grpPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpMrn = this.grpMrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpEtd = this.grpEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaWebDt = this.viaWebDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaWebFlg = this.viaWebFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpVvd = this.grpVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpMrnChk = this.grpMrnChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpPol = this.grpPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpEta = this.grpEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpEtaDtl = this.grpEtaDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
