/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PkupWdVO.java
*@FileTitle : PkupWdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.15 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupWdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupWdVO> models = new ArrayList<PkupWdVO>();
	
	/* Column Info */
	private String pkupNtcFomCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pkupNtcSndTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pkupNtcSeq = null;
	/* Column Info */
	private String btmRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eclzOblCpyFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupWdVO() {}

	public PkupWdVO(String ibflag, String pagerows, String pkupNtcSndTpCd, String ofcCd, String delCd, String pkupNtcSeq, String pkupNtcFomCd, String eclzOblCpyFlg, String btmRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.pkupNtcFomCd = pkupNtcFomCd;
		this.updDt = updDt;
		this.pkupNtcSndTpCd = pkupNtcSndTpCd;
		this.delCd = delCd;
		this.creDt = creDt;
		this.pkupNtcSeq = pkupNtcSeq;
		this.btmRmk = btmRmk;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.eclzOblCpyFlg = eclzOblCpyFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pkup_ntc_fom_cd", getPkupNtcFomCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pkup_ntc_snd_tp_cd", getPkupNtcSndTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pkup_ntc_seq", getPkupNtcSeq());
		this.hashColumns.put("btm_rmk", getBtmRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eclz_obl_cpy_flg", getEclzOblCpyFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pkup_ntc_fom_cd", "pkupNtcFomCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pkup_ntc_snd_tp_cd", "pkupNtcSndTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pkup_ntc_seq", "pkupNtcSeq");
		this.hashFields.put("btm_rmk", "btmRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eclz_obl_cpy_flg", "eclzOblCpyFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcFomCd
	 */
	public String getPkupNtcFomCd() {
		return this.pkupNtcFomCd;
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
	 * @return pkupNtcSndTpCd
	 */
	public String getPkupNtcSndTpCd() {
		return this.pkupNtcSndTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcSeq
	 */
	public String getPkupNtcSeq() {
		return this.pkupNtcSeq;
	}
	
	/**
	 * Column Info
	 * @return btmRmk
	 */
	public String getBtmRmk() {
		return this.btmRmk;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return eclzOblCpyFlg
	 */
	public String getEclzOblCpyFlg() {
		return this.eclzOblCpyFlg;
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
	 * @param pkupNtcFomCd
	 */
	public void setPkupNtcFomCd(String pkupNtcFomCd) {
		this.pkupNtcFomCd = pkupNtcFomCd;
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
	 * @param pkupNtcSndTpCd
	 */
	public void setPkupNtcSndTpCd(String pkupNtcSndTpCd) {
		this.pkupNtcSndTpCd = pkupNtcSndTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcSeq
	 */
	public void setPkupNtcSeq(String pkupNtcSeq) {
		this.pkupNtcSeq = pkupNtcSeq;
	}
	
	/**
	 * Column Info
	 * @param btmRmk
	 */
	public void setBtmRmk(String btmRmk) {
		this.btmRmk = btmRmk;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param eclzOblCpyFlg
	 */
	public void setEclzOblCpyFlg(String eclzOblCpyFlg) {
		this.eclzOblCpyFlg = eclzOblCpyFlg;
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
		setPkupNtcFomCd(JSPUtil.getParameter(request, "pkup_ntc_fom_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPkupNtcSndTpCd(JSPUtil.getParameter(request, "pkup_ntc_snd_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPkupNtcSeq(JSPUtil.getParameter(request, "pkup_ntc_seq", ""));
		setBtmRmk(JSPUtil.getParameter(request, "btm_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEclzOblCpyFlg(JSPUtil.getParameter(request, "eclz_obl_cpy_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupWdVO[]
	 */
	public PkupWdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupWdVO[]
	 */
	public PkupWdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupWdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pkupNtcFomCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_fom_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pkupNtcSndTpCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_snd_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pkupNtcSeq = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_seq", length));
			String[] btmRmk = (JSPUtil.getParameter(request, prefix	+ "btm_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] eclzOblCpyFlg = (JSPUtil.getParameter(request, prefix	+ "eclz_obl_cpy_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupWdVO();
				if (pkupNtcFomCd[i] != null)
					model.setPkupNtcFomCd(pkupNtcFomCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pkupNtcSndTpCd[i] != null)
					model.setPkupNtcSndTpCd(pkupNtcSndTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pkupNtcSeq[i] != null)
					model.setPkupNtcSeq(pkupNtcSeq[i]);
				if (btmRmk[i] != null)
					model.setBtmRmk(btmRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eclzOblCpyFlg[i] != null)
					model.setEclzOblCpyFlg(eclzOblCpyFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupWdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupWdVO[]
	 */
	public PkupWdVO[] getPkupWdVOs(){
		PkupWdVO[] vos = (PkupWdVO[])models.toArray(new PkupWdVO[models.size()]);
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
		this.pkupNtcFomCd = this.pkupNtcFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSndTpCd = this.pkupNtcSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSeq = this.pkupNtcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btmRmk = this.btmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eclzOblCpyFlg = this.eclzOblCpyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
