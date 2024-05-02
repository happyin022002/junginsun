/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsPreAudCrteListVO.java
*@FileTitle : TrsPreAudCrteListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.05.27 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsPreAudCrteListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsPreAudCrteListVO> models = new ArrayList<TrsPreAudCrteListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trspCrrModNm = null;
	/* Column Info */
	private String expnAudCrteTpCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String expnPrmtRtoRsn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mdlCd = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expnMaxPrmtRto = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String audOfcCd = null;
	/* Column Info */
	private String expnAudTgtFlg = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrsPreAudCrteListVO() {}

	public TrsPreAudCrteListVO(String ibflag, String pagerows, String mdlCd, String rhqOfcCd, String audOfcCd, String expnAudCrteTpCd, String cgoTpCd, String trspCrrModCd, String trspCrrModNm, String expnAudTgtFlg, String expnMaxPrmtRto, String creOfcCd, String updUsrId, String updDt, String expnPrmtRtoRsn) {
		this.updDt = updDt;
		this.trspCrrModNm = trspCrrModNm;
		this.expnAudCrteTpCd = expnAudCrteTpCd;
		this.cgoTpCd = cgoTpCd;
		this.expnPrmtRtoRsn = expnPrmtRtoRsn;
		this.pagerows = pagerows;
		this.mdlCd = mdlCd;
		this.rhqOfcCd = rhqOfcCd;
		this.ibflag = ibflag;
		this.expnMaxPrmtRto = expnMaxPrmtRto;
		this.creOfcCd = creOfcCd;
		this.audOfcCd = audOfcCd;
		this.expnAudTgtFlg = expnAudTgtFlg;
		this.trspCrrModCd = trspCrrModCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsp_crr_mod_nm", getTrspCrrModNm());
		this.hashColumns.put("expn_aud_crte_tp_cd", getExpnAudCrteTpCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("expn_prmt_rto_rsn", getExpnPrmtRtoRsn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mdl_cd", getMdlCd());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("expn_max_prmt_rto", getExpnMaxPrmtRto());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("aud_ofc_cd", getAudOfcCd());
		this.hashColumns.put("expn_aud_tgt_flg", getExpnAudTgtFlg());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsp_crr_mod_nm", "trspCrrModNm");
		this.hashFields.put("expn_aud_crte_tp_cd", "expnAudCrteTpCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("expn_prmt_rto_rsn", "expnPrmtRtoRsn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mdl_cd", "mdlCd");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("expn_max_prmt_rto", "expnMaxPrmtRto");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("aud_ofc_cd", "audOfcCd");
		this.hashFields.put("expn_aud_tgt_flg", "expnAudTgtFlg");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return trspCrrModNm
	 */
	public String getTrspCrrModNm() {
		return this.trspCrrModNm;
	}
	
	/**
	 * Column Info
	 * @return expnAudCrteTpCd
	 */
	public String getExpnAudCrteTpCd() {
		return this.expnAudCrteTpCd;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return expnPrmtRtoRsn
	 */
	public String getExpnPrmtRtoRsn() {
		return this.expnPrmtRtoRsn;
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
	 * @return mdlCd
	 */
	public String getMdlCd() {
		return this.mdlCd;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
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
	 * @return expnMaxPrmtRto
	 */
	public String getExpnMaxPrmtRto() {
		return this.expnMaxPrmtRto;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return audOfcCd
	 */
	public String getAudOfcCd() {
		return this.audOfcCd;
	}
	
	/**
	 * Column Info
	 * @return expnAudTgtFlg
	 */
	public String getExpnAudTgtFlg() {
		return this.expnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModNm
	 */
	public void setTrspCrrModNm(String trspCrrModNm) {
		this.trspCrrModNm = trspCrrModNm;
	}
	
	/**
	 * Column Info
	 * @param expnAudCrteTpCd
	 */
	public void setExpnAudCrteTpCd(String expnAudCrteTpCd) {
		this.expnAudCrteTpCd = expnAudCrteTpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param expnPrmtRtoRsn
	 */
	public void setExpnPrmtRtoRsn(String expnPrmtRtoRsn) {
		this.expnPrmtRtoRsn = expnPrmtRtoRsn;
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
	 * @param mdlCd
	 */
	public void setMdlCd(String mdlCd) {
		this.mdlCd = mdlCd;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
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
	 * @param expnMaxPrmtRto
	 */
	public void setExpnMaxPrmtRto(String expnMaxPrmtRto) {
		this.expnMaxPrmtRto = expnMaxPrmtRto;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param audOfcCd
	 */
	public void setAudOfcCd(String audOfcCd) {
		this.audOfcCd = audOfcCd;
	}
	
	/**
	 * Column Info
	 * @param expnAudTgtFlg
	 */
	public void setExpnAudTgtFlg(String expnAudTgtFlg) {
		this.expnAudTgtFlg = expnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTrspCrrModNm(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_nm", ""));
		setExpnAudCrteTpCd(JSPUtil.getParameter(request, prefix + "expn_aud_crte_tp_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setExpnPrmtRtoRsn(JSPUtil.getParameter(request, prefix + "expn_prmt_rto_rsn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMdlCd(JSPUtil.getParameter(request, prefix + "mdl_cd", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpnMaxPrmtRto(JSPUtil.getParameter(request, prefix + "expn_max_prmt_rto", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setAudOfcCd(JSPUtil.getParameter(request, prefix + "aud_ofc_cd", ""));
		setExpnAudTgtFlg(JSPUtil.getParameter(request, prefix + "expn_aud_tgt_flg", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsPreAudCrteListVO[]
	 */
	public TrsPreAudCrteListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsPreAudCrteListVO[]
	 */
	public TrsPreAudCrteListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsPreAudCrteListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trspCrrModNm = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_nm", length));
			String[] expnAudCrteTpCd = (JSPUtil.getParameter(request, prefix	+ "expn_aud_crte_tp_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] expnPrmtRtoRsn = (JSPUtil.getParameter(request, prefix	+ "expn_prmt_rto_rsn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mdlCd = (JSPUtil.getParameter(request, prefix	+ "mdl_cd", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expnMaxPrmtRto = (JSPUtil.getParameter(request, prefix	+ "expn_max_prmt_rto", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] audOfcCd = (JSPUtil.getParameter(request, prefix	+ "aud_ofc_cd", length));
			String[] expnAudTgtFlg = (JSPUtil.getParameter(request, prefix	+ "expn_aud_tgt_flg", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsPreAudCrteListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trspCrrModNm[i] != null)
					model.setTrspCrrModNm(trspCrrModNm[i]);
				if (expnAudCrteTpCd[i] != null)
					model.setExpnAudCrteTpCd(expnAudCrteTpCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (expnPrmtRtoRsn[i] != null)
					model.setExpnPrmtRtoRsn(expnPrmtRtoRsn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mdlCd[i] != null)
					model.setMdlCd(mdlCd[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expnMaxPrmtRto[i] != null)
					model.setExpnMaxPrmtRto(expnMaxPrmtRto[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (audOfcCd[i] != null)
					model.setAudOfcCd(audOfcCd[i]);
				if (expnAudTgtFlg[i] != null)
					model.setExpnAudTgtFlg(expnAudTgtFlg[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsPreAudCrteListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsPreAudCrteListVO[]
	 */
	public TrsPreAudCrteListVO[] getTrsPreAudCrteListVOs(){
		TrsPreAudCrteListVO[] vos = (TrsPreAudCrteListVO[])models.toArray(new TrsPreAudCrteListVO[models.size()]);
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
		this.trspCrrModNm = this.trspCrrModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudCrteTpCd = this.expnAudCrteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnPrmtRtoRsn = this.expnPrmtRtoRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlCd = this.mdlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnMaxPrmtRto = this.expnMaxPrmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audOfcCd = this.audOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudTgtFlg = this.expnAudTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
