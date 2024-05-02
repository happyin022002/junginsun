/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1019RouteSettingVO.java
*@FileTitle : EesEqr1019RouteSettingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo;

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

public class EesEqr1019RouteSettingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1019RouteSettingVO> models = new ArrayList<EesEqr1019RouteSettingVO>();
	
	/* Column Info */
	private String rcccd = null;
	/* Column Info */
	private String dcflg = null;
	/* Column Info */
	private String chkFlg = null;
	/* Column Info */
	private String loccd = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String rccNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyBkgDsabilFlg = null;
	/* Column Info */
	private String cntrImg = null;
	/* Column Info */
	private String lodgDchgDivCd = null;
	/* Column Info */
	private String plodgDchgDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mtySplitBkgDsabilFlg = null;
	/* Column Info */
	private String sLocCd = null;
	/* Column Info */
	private String pLocCd = null;
	/* Column Info */
	private String gLocCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pRccCd = null;
	/* Column Info */
	private String usrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1019RouteSettingVO() {}

	public EesEqr1019RouteSettingVO(String ibflag, String pagerows, String cntrImg, String rcccd, String dcflg, String sLocCd, String pLocCd, String gLocCd, String locNm, String lodgDchgDivCd, String plodgDchgDivCd, String pRccCd, String loccd, String usrId, String cntrTpszCd, String mtyBkgDsabilFlg, String mtySplitBkgDsabilFlg, String chkFlg, String rccNm) {
		this.rcccd = rcccd;
		this.dcflg = dcflg;
		this.chkFlg = chkFlg;
		this.loccd = loccd;
		this.locNm = locNm;
		this.rccNm = rccNm;
		this.pagerows = pagerows;
		this.mtyBkgDsabilFlg = mtyBkgDsabilFlg;
		this.cntrImg = cntrImg;
		this.lodgDchgDivCd = lodgDchgDivCd;
		this.plodgDchgDivCd = plodgDchgDivCd;
		this.ibflag = ibflag;
		this.mtySplitBkgDsabilFlg = mtySplitBkgDsabilFlg;
		this.sLocCd = sLocCd;
		this.pLocCd = pLocCd;
		this.gLocCd = gLocCd;
		this.cntrTpszCd = cntrTpszCd;
		this.pRccCd = pRccCd;
		this.usrId = usrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcccd", getRcccd());
		this.hashColumns.put("dcflg", getDcflg());
		this.hashColumns.put("chk_flg", getChkFlg());
		this.hashColumns.put("loccd", getLoccd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("rcc_nm", getRccNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mty_bkg_dsabil_flg", getMtyBkgDsabilFlg());
		this.hashColumns.put("cntr_img", getCntrImg());
		this.hashColumns.put("lodg_dchg_div_cd", getLodgDchgDivCd());
		this.hashColumns.put("plodg_dchg_div_cd", getPlodgDchgDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mty_split_bkg_dsabil_flg", getMtySplitBkgDsabilFlg());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("p_loc_cd", getPLocCd());
		this.hashColumns.put("g_loc_cd", getGLocCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("p_rcc_cd", getPRccCd());
		this.hashColumns.put("usr_id", getUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcccd", "rcccd");
		this.hashFields.put("dcflg", "dcflg");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("loccd", "loccd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("rcc_nm", "rccNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mty_bkg_dsabil_flg", "mtyBkgDsabilFlg");
		this.hashFields.put("cntr_img", "cntrImg");
		this.hashFields.put("lodg_dchg_div_cd", "lodgDchgDivCd");
		this.hashFields.put("plodg_dchg_div_cd", "plodgDchgDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mty_split_bkg_dsabil_flg", "mtySplitBkgDsabilFlg");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("p_loc_cd", "pLocCd");
		this.hashFields.put("g_loc_cd", "gLocCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("p_rcc_cd", "pRccCd");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcccd
	 */
	public String getRcccd() {
		return this.rcccd;
	}
	
	/**
	 * Column Info
	 * @return dcflg
	 */
	public String getDcflg() {
		return this.dcflg;
	}
	
	/**
	 * Column Info
	 * @return chkFlg
	 */
	public String getChkFlg() {
		return this.chkFlg;
	}
	
	/**
	 * Column Info
	 * @return loccd
	 */
	public String getLoccd() {
		return this.loccd;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return rccNm
	 */
	public String getRccNm() {
		return this.rccNm;
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
	 * @return mtyBkgDsabilFlg
	 */
	public String getMtyBkgDsabilFlg() {
		return this.mtyBkgDsabilFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrImg
	 */
	public String getCntrImg() {
		return this.cntrImg;
	}
	
	/**
	 * Column Info
	 * @return lodgDchgDivCd
	 */
	public String getLodgDchgDivCd() {
		return this.lodgDchgDivCd;
	}
	
	/**
	 * Column Info
	 * @return plodgDchgDivCd
	 */
	public String getPlodgDchgDivCd() {
		return this.plodgDchgDivCd;
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
	 * @return mtySplitBkgDsabilFlg
	 */
	public String getMtySplitBkgDsabilFlg() {
		return this.mtySplitBkgDsabilFlg;
	}
	
	/**
	 * Column Info
	 * @return sLocCd
	 */
	public String getSLocCd() {
		return this.sLocCd;
	}
	
	/**
	 * Column Info
	 * @return pLocCd
	 */
	public String getPLocCd() {
		return this.pLocCd;
	}
	
	/**
	 * Column Info
	 * @return gLocCd
	 */
	public String getGLocCd() {
		return this.gLocCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return pRccCd
	 */
	public String getPRccCd() {
		return this.pRccCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @param rcccd
	 */
	public void setRcccd(String rcccd) {
		this.rcccd = rcccd;
	}
	
	/**
	 * Column Info
	 * @param dcflg
	 */
	public void setDcflg(String dcflg) {
		this.dcflg = dcflg;
	}
	
	/**
	 * Column Info
	 * @param chkFlg
	 */
	public void setChkFlg(String chkFlg) {
		this.chkFlg = chkFlg;
	}
	
	/**
	 * Column Info
	 * @param loccd
	 */
	public void setLoccd(String loccd) {
		this.loccd = loccd;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param rccNm
	 */
	public void setRccNm(String rccNm) {
		this.rccNm = rccNm;
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
	 * @param mtyBkgDsabilFlg
	 */
	public void setMtyBkgDsabilFlg(String mtyBkgDsabilFlg) {
		this.mtyBkgDsabilFlg = mtyBkgDsabilFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrImg
	 */
	public void setCntrImg(String cntrImg) {
		this.cntrImg = cntrImg;
	}
	
	/**
	 * Column Info
	 * @param lodgDchgDivCd
	 */
	public void setLodgDchgDivCd(String lodgDchgDivCd) {
		this.lodgDchgDivCd = lodgDchgDivCd;
	}
	
	/**
	 * Column Info
	 * @param plodgDchgDivCd
	 */
	public void setPlodgDchgDivCd(String plodgDchgDivCd) {
		this.plodgDchgDivCd = plodgDchgDivCd;
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
	 * @param mtySplitBkgDsabilFlg
	 */
	public void setMtySplitBkgDsabilFlg(String mtySplitBkgDsabilFlg) {
		this.mtySplitBkgDsabilFlg = mtySplitBkgDsabilFlg;
	}
	
	/**
	 * Column Info
	 * @param sLocCd
	 */
	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
	}
	
	/**
	 * Column Info
	 * @param pLocCd
	 */
	public void setPLocCd(String pLocCd) {
		this.pLocCd = pLocCd;
	}
	
	/**
	 * Column Info
	 * @param gLocCd
	 */
	public void setGLocCd(String gLocCd) {
		this.gLocCd = gLocCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param pRccCd
	 */
	public void setPRccCd(String pRccCd) {
		this.pRccCd = pRccCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
		setRcccd(JSPUtil.getParameter(request, prefix + "rcccd", ""));
		setDcflg(JSPUtil.getParameter(request, prefix + "dcflg", ""));
		setChkFlg(JSPUtil.getParameter(request, prefix + "chkFlg", ""));
		setLoccd(JSPUtil.getParameter(request, prefix + "loccd", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "locNm", ""));
		setRccNm(JSPUtil.getParameter(request, prefix + "rccNm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMtyBkgDsabilFlg(JSPUtil.getParameter(request, prefix + "mtyBkgDsabilFlg", ""));
		setCntrImg(JSPUtil.getParameter(request, prefix + "cntrImg", ""));
		setLodgDchgDivCd(JSPUtil.getParameter(request, prefix + "lodgDchgDivCd", ""));
		setPlodgDchgDivCd(JSPUtil.getParameter(request, prefix + "plodgDchgDivCd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMtySplitBkgDsabilFlg(JSPUtil.getParameter(request, prefix + "mtySplitBkgDsabilFlg", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "sLocCd", ""));
		setPLocCd(JSPUtil.getParameter(request, prefix + "pLocCd", ""));
		setGLocCd(JSPUtil.getParameter(request, prefix + "gLocCd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntrTpszCd", ""));
		setPRccCd(JSPUtil.getParameter(request, prefix + "pRccCd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usrId", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1019RouteSettingVO[]
	 */
	public EesEqr1019RouteSettingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1019RouteSettingVO[]
	 */
	public EesEqr1019RouteSettingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1019RouteSettingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcccd = (JSPUtil.getParameter(request, prefix	+ "rcccd", length));
			String[] dcflg = (JSPUtil.getParameter(request, prefix	+ "dcflg", length));
			String[] chkFlg = (JSPUtil.getParameter(request, prefix	+ "chk_flg", length));
			String[] loccd = (JSPUtil.getParameter(request, prefix	+ "loccd", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] rccNm = (JSPUtil.getParameter(request, prefix	+ "rcc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtyBkgDsabilFlg = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_dsabil_flg", length));
			String[] cntrImg = (JSPUtil.getParameter(request, prefix	+ "cntr_img", length));
			String[] lodgDchgDivCd = (JSPUtil.getParameter(request, prefix	+ "lodg_dchg_div_cd", length));
			String[] plodgDchgDivCd = (JSPUtil.getParameter(request, prefix	+ "plodg_dchg_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mtySplitBkgDsabilFlg = (JSPUtil.getParameter(request, prefix	+ "mty_split_bkg_dsabil_flg", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] pLocCd = (JSPUtil.getParameter(request, prefix	+ "p_loc_cd", length));
			String[] gLocCd = (JSPUtil.getParameter(request, prefix	+ "g_loc_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pRccCd = (JSPUtil.getParameter(request, prefix	+ "p_rcc_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1019RouteSettingVO();
				if (rcccd[i] != null)
					model.setRcccd(rcccd[i]);
				if (dcflg[i] != null)
					model.setDcflg(dcflg[i]);
				if (chkFlg[i] != null)
					model.setChkFlg(chkFlg[i]);
				if (loccd[i] != null)
					model.setLoccd(loccd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (rccNm[i] != null)
					model.setRccNm(rccNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtyBkgDsabilFlg[i] != null)
					model.setMtyBkgDsabilFlg(mtyBkgDsabilFlg[i]);
				if (cntrImg[i] != null)
					model.setCntrImg(cntrImg[i]);
				if (lodgDchgDivCd[i] != null)
					model.setLodgDchgDivCd(lodgDchgDivCd[i]);
				if (plodgDchgDivCd[i] != null)
					model.setPlodgDchgDivCd(plodgDchgDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mtySplitBkgDsabilFlg[i] != null)
					model.setMtySplitBkgDsabilFlg(mtySplitBkgDsabilFlg[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (pLocCd[i] != null)
					model.setPLocCd(pLocCd[i]);
				if (gLocCd[i] != null)
					model.setGLocCd(gLocCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pRccCd[i] != null)
					model.setPRccCd(pRccCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1019RouteSettingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1019ConditionVO[]
	 */
	public EesEqr1019RouteSettingVO[] getEesEqr1019RouteSettingVOs(){
		EesEqr1019RouteSettingVO[] vos = (EesEqr1019RouteSettingVO[])models.toArray(new EesEqr1019RouteSettingVO[models.size()]);
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
		this.rcccd = this.rcccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcflg = this.dcflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg = this.chkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loccd = this.loccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccNm = this.rccNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgDsabilFlg = this.mtyBkgDsabilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrImg = this.cntrImg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDchgDivCd = this.lodgDchgDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plodgDchgDivCd = this.plodgDchgDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtySplitBkgDsabilFlg = this.mtySplitBkgDsabilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocCd = this.pLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gLocCd = this.gLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRccCd = this.pRccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
