/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SIWebServiceVO.java
*@FileTitle : SIWebServiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.25
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.25 Do Soon Choi 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author Do Soon Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SIWebServiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SIWebServiceVO> models = new ArrayList<SIWebServiceVO>();
	
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String mnlUpldRsn = null;
	/* Column Info */
	private String siAudFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgUpldStsCd = null;
	/* Column Info */
	private String cmpbRtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sysUpldFlg = null;
	/* Column Info */
	private String chgMod = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String mnlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SIWebServiceVO() {}

	public SIWebServiceVO(String ibflag, String pagerows, String mnlFlg, String mnlUpldRsn, String xterSndrId, String xterRqstNo, String xterRqstSeq, String bkgNo, String blNo, String chgMod, String bkgUpldStsCd, String sysUpldFlg, String cmpbRtFlg, String siAudFlg) {
		this.xterSndrId = xterSndrId;
		this.mnlUpldRsn = mnlUpldRsn;
		this.siAudFlg = siAudFlg;
		this.blNo = blNo;
		this.bkgUpldStsCd = bkgUpldStsCd;
		this.cmpbRtFlg = cmpbRtFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.sysUpldFlg = sysUpldFlg;
		this.chgMod = chgMod;
		this.xterRqstSeq = xterRqstSeq;
		this.xterRqstNo = xterRqstNo;
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("mnl_upld_rsn", getMnlUpldRsn());
		this.hashColumns.put("si_aud_flg", getSiAudFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
		this.hashColumns.put("cmpb_rt_flg", getCmpbRtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sys_upld_flg", getSysUpldFlg());
		this.hashColumns.put("chg_mod", getChgMod());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("mnl_upld_rsn", "mnlUpldRsn");
		this.hashFields.put("si_aud_flg", "siAudFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
		this.hashFields.put("cmpb_rt_flg", "cmpbRtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sys_upld_flg", "sysUpldFlg");
		this.hashFields.put("chg_mod", "chgMod");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("mnl_flg", "mnlFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return mnlUpldRsn
	 */
	public String getMnlUpldRsn() {
		return this.mnlUpldRsn;
	}
	
	/**
	 * Column Info
	 * @return siAudFlg
	 */
	public String getSiAudFlg() {
		return this.siAudFlg;
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
	 * @return bkgUpldStsCd
	 */
	public String getBkgUpldStsCd() {
		return this.bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @return cmpbRtFlg
	 */
	public String getCmpbRtFlg() {
		return this.cmpbRtFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return sysUpldFlg
	 */
	public String getSysUpldFlg() {
		return this.sysUpldFlg;
	}
	
	/**
	 * Column Info
	 * @return chgMod
	 */
	public String getChgMod() {
		return this.chgMod;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}
	

	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param mnlUpldRsn
	 */
	public void setMnlUpldRsn(String mnlUpldRsn) {
		this.mnlUpldRsn = mnlUpldRsn;
	}
	
	/**
	 * Column Info
	 * @param siAudFlg
	 */
	public void setSiAudFlg(String siAudFlg) {
		this.siAudFlg = siAudFlg;
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
	 * @param bkgUpldStsCd
	 */
	public void setBkgUpldStsCd(String bkgUpldStsCd) {
		this.bkgUpldStsCd = bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @param cmpbRtFlg
	 */
	public void setCmpbRtFlg(String cmpbRtFlg) {
		this.cmpbRtFlg = cmpbRtFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param sysUpldFlg
	 */
	public void setSysUpldFlg(String sysUpldFlg) {
		this.sysUpldFlg = sysUpldFlg;
	}
	
	/**
	 * Column Info
	 * @param chgMod
	 */
	public void setChgMod(String chgMod) {
		this.chgMod = chgMod;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
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
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setMnlUpldRsn(JSPUtil.getParameter(request, prefix + "mnl_upld_rsn", ""));
		setSiAudFlg(JSPUtil.getParameter(request, prefix + "si_aud_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
		setCmpbRtFlg(JSPUtil.getParameter(request, prefix + "cmpb_rt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSysUpldFlg(JSPUtil.getParameter(request, prefix + "sys_upld_flg", ""));
		setChgMod(JSPUtil.getParameter(request, prefix + "chg_mod", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setMnlFlg(JSPUtil.getParameter(request, prefix + "mnl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SIWebServiceVO[]
	 */
	public SIWebServiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SIWebServiceVO[]
	 */
	public SIWebServiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SIWebServiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] mnlUpldRsn = (JSPUtil.getParameter(request, prefix	+ "mnl_upld_rsn", length));
			String[] siAudFlg = (JSPUtil.getParameter(request, prefix	+ "si_aud_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_sts_cd", length));
			String[] cmpbRtFlg = (JSPUtil.getParameter(request, prefix	+ "cmpb_rt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sysUpldFlg = (JSPUtil.getParameter(request, prefix	+ "sys_upld_flg", length));
			String[] chgMod = (JSPUtil.getParameter(request, prefix	+ "chg_mod", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SIWebServiceVO();
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (mnlUpldRsn[i] != null)
					model.setMnlUpldRsn(mnlUpldRsn[i]);
				if (siAudFlg[i] != null)
					model.setSiAudFlg(siAudFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgUpldStsCd[i] != null)
					model.setBkgUpldStsCd(bkgUpldStsCd[i]);
				if (cmpbRtFlg[i] != null)
					model.setCmpbRtFlg(cmpbRtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sysUpldFlg[i] != null)
					model.setSysUpldFlg(sysUpldFlg[i]);
				if (chgMod[i] != null)
					model.setChgMod(chgMod[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSIWebServiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SIWebServiceVO[]
	 */
	public SIWebServiceVO[] getSIWebServiceVOs(){
		SIWebServiceVO[] vos = (SIWebServiceVO[])models.toArray(new SIWebServiceVO[models.size()]);
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
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlUpldRsn = this.mnlUpldRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siAudFlg = this.siAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsCd = this.bkgUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbRtFlg = this.cmpbRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysUpldFlg = this.sysUpldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgMod = this.chgMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
