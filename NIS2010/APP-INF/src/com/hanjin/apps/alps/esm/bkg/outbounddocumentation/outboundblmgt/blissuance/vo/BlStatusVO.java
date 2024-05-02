/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlStatusVO.java
*@FileTitle : BlStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.11.10 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlStatusVO> models = new ArrayList<BlStatusVO>();
	
	/* Column Info */
	private String chgPpdInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String doChkInd = null;
	/* Column Info */
	private String chgPpdThirdInd = null;
	/* Column Info */
	private String chgReady = null;
	/* Column Info */
	private String mkReady = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String ratChkFlg = null;
	/* Column Info */
	private String vslChkFlg = null;
	/* Column Info */
	private String audFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlStatusVO() {}

	public BlStatusVO(String ibflag, String pagerows, String chgReady, String mkReady, String chgPpdInd, String chgPpdThirdInd, String doChkInd, String bkgStsCd, String ratChkFlg, String vslChkFlg, String audFlg) {
		this.chgPpdInd = chgPpdInd;
		this.ibflag = ibflag;
		this.doChkInd = doChkInd;
		this.chgPpdThirdInd = chgPpdThirdInd;
		this.chgReady = chgReady;
		this.mkReady = mkReady;
		this.bkgStsCd = bkgStsCd;
		this.ratChkFlg = ratChkFlg;
		this.vslChkFlg = vslChkFlg;
		this.audFlg = audFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_ppd_ind", getChgPpdInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("do_chk_ind", getDoChkInd());
		this.hashColumns.put("chg_ppd_third_ind", getChgPpdThirdInd());
		this.hashColumns.put("chg_ready", getChgReady());
		this.hashColumns.put("mk_ready", getMkReady());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("rat_chk_flg", getRatChkFlg());
		this.hashColumns.put("vsl_chk_flg", getVslChkFlg());
		this.hashColumns.put("aud_flg", getAudFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_ppd_ind", "chgPpdInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("do_chk_ind", "doChkInd");
		this.hashFields.put("chg_ppd_third_ind", "chgPpdThirdInd");
		this.hashFields.put("chg_ready", "chgReady");
		this.hashFields.put("mk_ready", "mkReady");
		this.hashFields.put("rat_chk_flg", "ratChkFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("vsl_chk_flg", "vslChkFlg");
		this.hashFields.put("aud_flg", "audFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgPpdInd
	 */
	public String getChgPpdInd() {
		return this.chgPpdInd;
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
	 * @return doChkInd
	 */
	public String getDoChkInd() {
		return this.doChkInd;
	}
	
	/**
	 * Column Info
	 * @return ratChkFlg
	 */
	public String getRatChkFlg() {
		return this.ratChkFlg;
	}
	
	/**
	 * Column Info
	 * @return chgPpdThirdInd
	 */
	public String getChgPpdThirdInd() {
		return this.chgPpdThirdInd;
	}
	
	/**
	 * Column Info
	 * @return chgReady
	 */
	public String getChgReady() {
		return this.chgReady;
	}
	
	/**
	 * Column Info
	 * @return mkReady
	 */
	public String getMkReady() {
		return this.mkReady;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return vslChkFlg
	 */
	public String getVslChkFlg() {
		return this.vslChkFlg;
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
	 * @param chgPpdInd
	 */
	public void setChgPpdInd(String chgPpdInd) {
		this.chgPpdInd = chgPpdInd;
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
	 * @param doChkInd
	 */
	public void setDoChkInd(String doChkInd) {
		this.doChkInd = doChkInd;
	}
	
	/**
	 * Column Info
	 * @param vslChkFlg
	 */
	public void setVslChkFlg(String vslChkFlg) {
		this.vslChkFlg = vslChkFlg;
	}
	
	/**
	 * Column Info
	 * @param chgPpdThirdInd
	 */
	public void setChgPpdThirdInd(String chgPpdThirdInd) {
		this.chgPpdThirdInd = chgPpdThirdInd;
	}
	
	/**
	 * Column Info
	 * @param chgReady
	 */
	public void setChgReady(String chgReady) {
		this.chgReady = chgReady;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param mkReady
	 */
	public void setMkReady(String mkReady) {
		this.mkReady = mkReady;
	}
	
	/**
	 * Column Info
	 * @param ratChkFlg
	 */
	public void setRatChkFlg(String ratChkFlg) {
		this.ratChkFlg = ratChkFlg;
	}
	
	
	
	public String getAudFlg() {
		return audFlg;
	}

	public void setAudFlg(String audFlg) {
		this.audFlg = audFlg;
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
		setChgPpdInd(JSPUtil.getParameter(request, "chg_ppd_ind", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDoChkInd(JSPUtil.getParameter(request, "do_chk_ind", ""));
		setVslChkFlg(JSPUtil.getParameter(request, "vsl_chk_flg", ""));
		setChgPpdThirdInd(JSPUtil.getParameter(request, "chg_ppd_third_ind", ""));
		setChgReady(JSPUtil.getParameter(request, "chg_ready", ""));
		setMkReady(JSPUtil.getParameter(request, "mk_ready", ""));
		setRatChkFlg(JSPUtil.getParameter(request, "rat_chk_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setAudFlg(JSPUtil.getParameter(request, "aud_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlStatusVO[]
	 */
	public BlStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlStatusVO[]
	 */
	public BlStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgPpdInd = (JSPUtil.getParameter(request, prefix	+ "chg_ppd_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] doChkInd = (JSPUtil.getParameter(request, prefix	+ "do_chk_ind", length));
			String[] chgPpdThirdInd = (JSPUtil.getParameter(request, prefix	+ "chg_ppd_third_ind", length));
			String[] chgReady = (JSPUtil.getParameter(request, prefix	+ "chg_ready", length));
			String[] mkReady = (JSPUtil.getParameter(request, prefix	+ "mk_ready", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] ratChkFlg = (JSPUtil.getParameter(request, prefix	+ "rat_chk_flg", length));
			String[] vslChkFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_chk_flg", length));
			String[] audFlg = (JSPUtil.getParameter(request, prefix	+ "aud_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlStatusVO();
				if (chgPpdInd[i] != null)
					model.setChgPpdInd(chgPpdInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (doChkInd[i] != null)
					model.setDoChkInd(doChkInd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (chgPpdThirdInd[i] != null)
					model.setChgPpdThirdInd(chgPpdThirdInd[i]);
				if (chgReady[i] != null)
					model.setChgReady(chgReady[i]);
				if (mkReady[i] != null)
					model.setMkReady(mkReady[i]);
				if (ratChkFlg[i] != null)
					model.setRatChkFlg(ratChkFlg[i]);
				if (vslChkFlg[i] != null)
					model.setVslChkFlg(vslChkFlg[i]);
				if (audFlg[i] != null)
					model.setAudFlg(audFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlStatusVO[]
	 */
	public BlStatusVO[] getBlStatusVOs(){
		BlStatusVO[] vos = (BlStatusVO[])models.toArray(new BlStatusVO[models.size()]);
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
		this.chgPpdInd = this.chgPpdInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doChkInd = this.doChkInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgPpdThirdInd = this.chgPpdThirdInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgReady = this.chgReady .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkReady = this.mkReady .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratChkFlg = this.ratChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslChkFlg = this.vslChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audFlg = this.audFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
