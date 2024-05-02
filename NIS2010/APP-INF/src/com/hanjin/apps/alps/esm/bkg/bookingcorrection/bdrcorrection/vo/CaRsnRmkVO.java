/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CaRsnRmkVO.java
*@FileTitle : CaRsnRmkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaRsnRmkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaRsnRmkVO> models = new ArrayList<CaRsnRmkVO>();
	
	/* Column Info */
	private String caRsnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String umchSubTpCd = null;
	/* Column Info */
	private String intgCdValDpDesc = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String rdnStsCd = null;
	/* Column Info */
	private String rdnAcptFlg = null;
	/* Column Info */
	private String umchSubTpCdHid = null;
	/* Column Info */
	private String rdnNo = null;
	/* Column Info */
	private String rvisSeq = null;
	/* Column Info */
	private String bkgCorrRmk = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CaRsnRmkVO() {}

	public CaRsnRmkVO(String ibflag, String pagerows, String caRsnCd, String bkgCorrRmk, String rdnNo, String rvisSeq, String rdnAcptFlg, String umchTpCd, String umchSubTpCdHid, String umchSubTpCd, String intgCdValDpDesc, String rdnStsCd) {
		this.caRsnCd = caRsnCd;
		this.ibflag = ibflag;
		this.umchSubTpCd = umchSubTpCd;
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.umchTpCd = umchTpCd;
		this.rdnStsCd = rdnStsCd;
		this.rdnAcptFlg = rdnAcptFlg;
		this.umchSubTpCdHid = umchSubTpCdHid;
		this.rdnNo = rdnNo;
		this.rvisSeq = rvisSeq;
		this.bkgCorrRmk = bkgCorrRmk;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("umch_sub_tp_cd", getUmchSubTpCd());
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("rdn_sts_cd", getRdnStsCd());
		this.hashColumns.put("rdn_acpt_flg", getRdnAcptFlg());
		this.hashColumns.put("umch_sub_tp_cd_hid", getUmchSubTpCdHid());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("rvis_seq", getRvisSeq());
		this.hashColumns.put("bkg_corr_rmk", getBkgCorrRmk());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("umch_sub_tp_cd", "umchSubTpCd");
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("rdn_sts_cd", "rdnStsCd");
		this.hashFields.put("rdn_acpt_flg", "rdnAcptFlg");
		this.hashFields.put("umch_sub_tp_cd_hid", "umchSubTpCdHid");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("rvis_seq", "rvisSeq");
		this.hashFields.put("bkg_corr_rmk", "bkgCorrRmk");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
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
	 * @return umchSubTpCd
	 */
	public String getUmchSubTpCd() {
		return this.umchSubTpCd;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @return umchTpCd
	 */
	public String getUmchTpCd() {
		return this.umchTpCd;
	}
	
	/**
	 * Column Info
	 * @return rdnStsCd
	 */
	public String getRdnStsCd() {
		return this.rdnStsCd;
	}
	
	/**
	 * Column Info
	 * @return rdnAcptFlg
	 */
	public String getRdnAcptFlg() {
		return this.rdnAcptFlg;
	}
	
	/**
	 * Column Info
	 * @return umchSubTpCdHid
	 */
	public String getUmchSubTpCdHid() {
		return this.umchSubTpCdHid;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
	}
	
	/**
	 * Column Info
	 * @return rvisSeq
	 */
	public String getRvisSeq() {
		return this.rvisSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrRmk
	 */
	public String getBkgCorrRmk() {
		return this.bkgCorrRmk;
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
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
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
	 * @param umchSubTpCd
	 */
	public void setUmchSubTpCd(String umchSubTpCd) {
		this.umchSubTpCd = umchSubTpCd;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @param umchTpCd
	 */
	public void setUmchTpCd(String umchTpCd) {
		this.umchTpCd = umchTpCd;
	}
	
	/**
	 * Column Info
	 * @param rdnStsCd
	 */
	public void setRdnStsCd(String rdnStsCd) {
		this.rdnStsCd = rdnStsCd;
	}
	
	/**
	 * Column Info
	 * @param rdnAcptFlg
	 */
	public void setRdnAcptFlg(String rdnAcptFlg) {
		this.rdnAcptFlg = rdnAcptFlg;
	}
	
	/**
	 * Column Info
	 * @param umchSubTpCdHid
	 */
	public void setUmchSubTpCdHid(String umchSubTpCdHid) {
		this.umchSubTpCdHid = umchSubTpCdHid;
	}
	
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
	}
	
	/**
	 * Column Info
	 * @param rvisSeq
	 */
	public void setRvisSeq(String rvisSeq) {
		this.rvisSeq = rvisSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrRmk
	 */
	public void setBkgCorrRmk(String bkgCorrRmk) {
		this.bkgCorrRmk = bkgCorrRmk;
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
		setCaRsnCd(JSPUtil.getParameter(request, prefix + "ca_rsn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUmchSubTpCd(JSPUtil.getParameter(request, prefix + "umch_sub_tp_cd", ""));
		setIntgCdValDpDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", ""));
		setUmchTpCd(JSPUtil.getParameter(request, prefix + "umch_tp_cd", ""));
		setRdnStsCd(JSPUtil.getParameter(request, prefix + "rdn_sts_cd", ""));
		setRdnAcptFlg(JSPUtil.getParameter(request, prefix + "rdn_acpt_flg", ""));
		setUmchSubTpCdHid(JSPUtil.getParameter(request, prefix + "umch_sub_tp_cd_hid", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setRvisSeq(JSPUtil.getParameter(request, prefix + "rvis_seq", ""));
		setBkgCorrRmk(JSPUtil.getParameter(request, prefix + "bkg_corr_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaRsnRmkVO[]
	 */
	public CaRsnRmkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaRsnRmkVO[]
	 */
	public CaRsnRmkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaRsnRmkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] umchSubTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_sub_tp_cd", length));
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] rdnStsCd = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_cd", length));
			String[] rdnAcptFlg = (JSPUtil.getParameter(request, prefix	+ "rdn_acpt_flg", length));
			String[] umchSubTpCdHid = (JSPUtil.getParameter(request, prefix	+ "umch_sub_tp_cd_hid", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] rvisSeq = (JSPUtil.getParameter(request, prefix	+ "rvis_seq", length));
			String[] bkgCorrRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaRsnRmkVO();
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (umchSubTpCd[i] != null)
					model.setUmchSubTpCd(umchSubTpCd[i]);
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (rdnStsCd[i] != null)
					model.setRdnStsCd(rdnStsCd[i]);
				if (rdnAcptFlg[i] != null)
					model.setRdnAcptFlg(rdnAcptFlg[i]);
				if (umchSubTpCdHid[i] != null)
					model.setUmchSubTpCdHid(umchSubTpCdHid[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (rvisSeq[i] != null)
					model.setRvisSeq(rvisSeq[i]);
				if (bkgCorrRmk[i] != null)
					model.setBkgCorrRmk(bkgCorrRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaRsnRmkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaRsnRmkVO[]
	 */
	public CaRsnRmkVO[] getCaRsnRmkVOs(){
		CaRsnRmkVO[] vos = (CaRsnRmkVO[])models.toArray(new CaRsnRmkVO[models.size()]);
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
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchSubTpCd = this.umchSubTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpDesc = this.intgCdValDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsCd = this.rdnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnAcptFlg = this.rdnAcptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchSubTpCdHid = this.umchSubTpCdHid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisSeq = this.rvisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrRmk = this.bkgCorrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
