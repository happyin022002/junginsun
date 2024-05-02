/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsCgoRlseHisVO.java
*@FileTitle : UsCgoRlseHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.10.12 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsCgoRlseHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsCgoRlseHisVO> models = new ArrayList<UsCgoRlseHisVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String cgorEvntNm = null;
	/* Column Info */
	private String cgorTeamCdDesc = null;
	/* Column Info */
	private String mrnTmlEdiSndCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String evntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doHldFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsCgoRlseHisVO() {}

	public UsCgoRlseHisVO(String ibflag, String pagerows, String blNo, String evntDt, String frtCltFlg, String oblRdemFlg, String cstmsClrCd, String mrnTmlEdiSndCd, String cgorTeamCdDesc, String cgorEvntNm, String usrNm, String doHldFlg) {
		this.ibflag = ibflag;
		this.cstmsClrCd = cstmsClrCd;
		this.frtCltFlg = frtCltFlg;
		this.usrNm = usrNm;
		this.cgorEvntNm = cgorEvntNm;
		this.cgorTeamCdDesc = cgorTeamCdDesc;
		this.mrnTmlEdiSndCd = mrnTmlEdiSndCd;
		this.oblRdemFlg = oblRdemFlg;
		this.blNo = blNo;
		this.evntDt = evntDt;
		this.pagerows = pagerows;
		this.doHldFlg = doHldFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("cgor_evnt_nm", getCgorEvntNm());
		this.hashColumns.put("cgor_team_cd_desc", getCgorTeamCdDesc());
		this.hashColumns.put("mrn_tml_edi_snd_cd", getMrnTmlEdiSndCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cgor_evnt_nm", "cgorEvntNm");
		this.hashFields.put("cgor_team_cd_desc", "cgorTeamCdDesc");
		this.hashFields.put("mrn_tml_edi_snd_cd", "mrnTmlEdiSndCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_hld_flg", "doHldFlg");
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
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return cgorEvntNm
	 */
	public String getCgorEvntNm() {
		return this.cgorEvntNm;
	}
	
	/**
	 * Column Info
	 * @return cgorTeamCdDesc
	 */
	public String getCgorTeamCdDesc() {
		return this.cgorTeamCdDesc;
	}
	
	/**
	 * Column Info
	 * @return mrnTmlEdiSndCd
	 */
	public String getMrnTmlEdiSndCd() {
		return this.mrnTmlEdiSndCd;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return this.doHldFlg;
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
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param cgorEvntNm
	 */
	public void setCgorEvntNm(String cgorEvntNm) {
		this.cgorEvntNm = cgorEvntNm;
	}
	
	/**
	 * Column Info
	 * @param cgorTeamCdDesc
	 */
	public void setCgorTeamCdDesc(String cgorTeamCdDesc) {
		this.cgorTeamCdDesc = cgorTeamCdDesc;
	}
	
	/**
	 * Column Info
	 * @param mrnTmlEdiSndCd
	 */
	public void setMrnTmlEdiSndCd(String mrnTmlEdiSndCd) {
		this.mrnTmlEdiSndCd = mrnTmlEdiSndCd;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, "cstms_clr_cd", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setCgorEvntNm(JSPUtil.getParameter(request, "cgor_evnt_nm", ""));
		setCgorTeamCdDesc(JSPUtil.getParameter(request, "cgor_team_cd_desc", ""));
		setMrnTmlEdiSndCd(JSPUtil.getParameter(request, "mrn_tml_edi_snd_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoHldFlg(JSPUtil.getParameter(request, "do_hld_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsCgoRlseHisVO[]
	 */
	public UsCgoRlseHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsCgoRlseHisVO[]
	 */
	public UsCgoRlseHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsCgoRlseHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] cgorEvntNm = (JSPUtil.getParameter(request, prefix	+ "cgor_evnt_nm", length));
			String[] cgorTeamCdDesc = (JSPUtil.getParameter(request, prefix	+ "cgor_team_cd_desc", length));
			String[] mrnTmlEdiSndCd = (JSPUtil.getParameter(request, prefix	+ "mrn_tml_edi_snd_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsCgoRlseHisVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (cgorEvntNm[i] != null)
					model.setCgorEvntNm(cgorEvntNm[i]);
				if (cgorTeamCdDesc[i] != null)
					model.setCgorTeamCdDesc(cgorTeamCdDesc[i]);
				if (mrnTmlEdiSndCd[i] != null)
					model.setMrnTmlEdiSndCd(mrnTmlEdiSndCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsCgoRlseHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsCgoRlseHisVO[]
	 */
	public UsCgoRlseHisVO[] getUsCgoRlseHisVOs(){
		UsCgoRlseHisVO[] vos = (UsCgoRlseHisVO[])models.toArray(new UsCgoRlseHisVO[models.size()]);
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
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorEvntNm = this.cgorEvntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorTeamCdDesc = this.cgorTeamCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnTmlEdiSndCd = this.mrnTmlEdiSndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
