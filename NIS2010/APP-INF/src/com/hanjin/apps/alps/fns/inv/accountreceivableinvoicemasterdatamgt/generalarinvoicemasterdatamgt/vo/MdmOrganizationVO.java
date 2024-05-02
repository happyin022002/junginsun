/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MdmOrganizationVO.java
*@FileTitle : MdmOrganizationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2010.01.13 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmOrganizationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmOrganizationVO> models = new ArrayList<MdmOrganizationVO>();
	
	/* Column Info */
	private String fincRgnCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String asaCrTermDys = null;
	/* Column Info */
	private String arCurrCd = null;
	/* Column Info */
	private String repType = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String arCtrCd = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String bilCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subAgnFlg = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fxCurrRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arAgnStlCd = null;
	/* Column Info */
	private String invPfxCd = null;
	/* Column Info */
	private String soIfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmOrganizationVO() {}

	public MdmOrganizationVO(String ibflag, String pagerows, String fincRgnCd, String deltFlg, String asaCrTermDys, String arCurrCd, String repType, String arHdQtrOfcCd, String arCtrCd, String obCrTermDys, String arOfcCd, String bilCurrCd, String fxCurrRt, String ofcCd, String ibCrTermDys, String arAgnStlCd, String invPfxCd, String soIfCd, String subAgnFlg) {
		this.fincRgnCd = fincRgnCd;
		this.deltFlg = deltFlg;
		this.asaCrTermDys = asaCrTermDys;
		this.arCurrCd = arCurrCd;
		this.repType = repType;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.arCtrCd = arCtrCd;
		this.obCrTermDys = obCrTermDys;
		this.arOfcCd = arOfcCd;
		this.bilCurrCd = bilCurrCd;
		this.pagerows = pagerows;
		this.subAgnFlg = subAgnFlg;
		this.ibCrTermDys = ibCrTermDys;
		this.ofcCd = ofcCd;
		this.fxCurrRt = fxCurrRt;
		this.ibflag = ibflag;
		this.arAgnStlCd = arAgnStlCd;
		this.invPfxCd = invPfxCd;
		this.soIfCd = soIfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("finc_rgn_cd", getFincRgnCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("asa_cr_term_dys", getAsaCrTermDys());
		this.hashColumns.put("ar_curr_cd", getArCurrCd());
		this.hashColumns.put("rep_type", getRepType());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ar_ctr_cd", getArCtrCd());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("bil_curr_cd", getBilCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_agn_flg", getSubAgnFlg());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("fx_curr_rt", getFxCurrRt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
		this.hashColumns.put("inv_pfx_cd", getInvPfxCd());
		this.hashColumns.put("so_if_cd", getSoIfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("finc_rgn_cd", "fincRgnCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("asa_cr_term_dys", "asaCrTermDys");
		this.hashFields.put("ar_curr_cd", "arCurrCd");
		this.hashFields.put("rep_type", "repType");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ar_ctr_cd", "arCtrCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("bil_curr_cd", "bilCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_agn_flg", "subAgnFlg");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("fx_curr_rt", "fxCurrRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
		this.hashFields.put("inv_pfx_cd", "invPfxCd");
		this.hashFields.put("so_if_cd", "soIfCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fincRgnCd
	 */
	public String getFincRgnCd() {
		return this.fincRgnCd;
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
	 * @return asaCrTermDys
	 */
	public String getAsaCrTermDys() {
		return this.asaCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return arCurrCd
	 */
	public String getArCurrCd() {
		return this.arCurrCd;
	}
	
	/**
	 * Column Info
	 * @return repType
	 */
	public String getRepType() {
		return this.repType;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return arCtrCd
	 */
	public String getArCtrCd() {
		return this.arCtrCd;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
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
	 * @return bilCurrCd
	 */
	public String getBilCurrCd() {
		return this.bilCurrCd;
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
	 * @return subAgnFlg
	 */
	public String getSubAgnFlg() {
		return this.subAgnFlg;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return fxCurrRt
	 */
	public String getFxCurrRt() {
		return this.fxCurrRt;
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
	 * @return arAgnStlCd
	 */
	public String getArAgnStlCd() {
		return this.arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @return invPfxCd
	 */
	public String getInvPfxCd() {
		return this.invPfxCd;
	}
	
	/**
	 * Column Info
	 * @return soIfCd
	 */
	public String getSoIfCd() {
		return this.soIfCd;
	}
	

	/**
	 * Column Info
	 * @param fincRgnCd
	 */
	public void setFincRgnCd(String fincRgnCd) {
		this.fincRgnCd = fincRgnCd;
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
	 * @param asaCrTermDys
	 */
	public void setAsaCrTermDys(String asaCrTermDys) {
		this.asaCrTermDys = asaCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param arCurrCd
	 */
	public void setArCurrCd(String arCurrCd) {
		this.arCurrCd = arCurrCd;
	}
	
	/**
	 * Column Info
	 * @param repType
	 */
	public void setRepType(String repType) {
		this.repType = repType;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param arCtrCd
	 */
	public void setArCtrCd(String arCtrCd) {
		this.arCtrCd = arCtrCd;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
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
	 * @param bilCurrCd
	 */
	public void setBilCurrCd(String bilCurrCd) {
		this.bilCurrCd = bilCurrCd;
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
	 * @param subAgnFlg
	 */
	public void setSubAgnFlg(String subAgnFlg) {
		this.subAgnFlg = subAgnFlg;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param fxCurrRt
	 */
	public void setFxCurrRt(String fxCurrRt) {
		this.fxCurrRt = fxCurrRt;
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
	 * @param arAgnStlCd
	 */
	public void setArAgnStlCd(String arAgnStlCd) {
		this.arAgnStlCd = arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @param invPfxCd
	 */
	public void setInvPfxCd(String invPfxCd) {
		this.invPfxCd = invPfxCd;
	}
	
	/**
	 * Column Info
	 * @param soIfCd
	 */
	public void setSoIfCd(String soIfCd) {
		this.soIfCd = soIfCd;
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
		setFincRgnCd(JSPUtil.getParameter(request, prefix + "finc_rgn_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAsaCrTermDys(JSPUtil.getParameter(request, prefix + "asa_cr_term_dys", ""));
		setArCurrCd(JSPUtil.getParameter(request, prefix + "ar_curr_cd", ""));
		setRepType(JSPUtil.getParameter(request, prefix + "rep_type", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setArCtrCd(JSPUtil.getParameter(request, prefix + "ar_ctr_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setBilCurrCd(JSPUtil.getParameter(request, prefix + "bil_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSubAgnFlg(JSPUtil.getParameter(request, prefix + "sub_agn_flg", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFxCurrRt(JSPUtil.getParameter(request, prefix + "fx_curr_rt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArAgnStlCd(JSPUtil.getParameter(request, prefix + "ar_agn_stl_cd", ""));
		setInvPfxCd(JSPUtil.getParameter(request, prefix + "inv_pfx_cd", ""));
		setSoIfCd(JSPUtil.getParameter(request, prefix + "so_if_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmOrganizationVO[]
	 */
	public MdmOrganizationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmOrganizationVO[]
	 */
	public MdmOrganizationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmOrganizationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fincRgnCd = (JSPUtil.getParameter(request, prefix	+ "finc_rgn_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] asaCrTermDys = (JSPUtil.getParameter(request, prefix	+ "asa_cr_term_dys", length));
			String[] arCurrCd = (JSPUtil.getParameter(request, prefix	+ "ar_curr_cd", length));
			String[] repType = (JSPUtil.getParameter(request, prefix	+ "rep_type", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] arCtrCd = (JSPUtil.getParameter(request, prefix	+ "ar_ctr_cd", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] bilCurrCd = (JSPUtil.getParameter(request, prefix	+ "bil_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subAgnFlg = (JSPUtil.getParameter(request, prefix	+ "sub_agn_flg", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fxCurrRt = (JSPUtil.getParameter(request, prefix	+ "fx_curr_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix	+ "ar_agn_stl_cd", length));
			String[] invPfxCd = (JSPUtil.getParameter(request, prefix	+ "inv_pfx_cd", length));
			String[] soIfCd = (JSPUtil.getParameter(request, prefix	+ "so_if_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmOrganizationVO();
				if (fincRgnCd[i] != null)
					model.setFincRgnCd(fincRgnCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (asaCrTermDys[i] != null)
					model.setAsaCrTermDys(asaCrTermDys[i]);
				if (arCurrCd[i] != null)
					model.setArCurrCd(arCurrCd[i]);
				if (repType[i] != null)
					model.setRepType(repType[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (arCtrCd[i] != null)
					model.setArCtrCd(arCtrCd[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (bilCurrCd[i] != null)
					model.setBilCurrCd(bilCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subAgnFlg[i] != null)
					model.setSubAgnFlg(subAgnFlg[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fxCurrRt[i] != null)
					model.setFxCurrRt(fxCurrRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arAgnStlCd[i] != null)
					model.setArAgnStlCd(arAgnStlCd[i]);
				if (invPfxCd[i] != null)
					model.setInvPfxCd(invPfxCd[i]);
				if (soIfCd[i] != null)
					model.setSoIfCd(soIfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmOrganizationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmOrganizationVO[]
	 */
	public MdmOrganizationVO[] getMdmOrganizationVOs(){
		MdmOrganizationVO[] vos = (MdmOrganizationVO[])models.toArray(new MdmOrganizationVO[models.size()]);
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
		this.fincRgnCd = this.fincRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaCrTermDys = this.asaCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCurrCd = this.arCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repType = this.repType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCtrCd = this.arCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilCurrCd = this.bilCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subAgnFlg = this.subAgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxCurrRt = this.fxCurrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAgnStlCd = this.arAgnStlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPfxCd = this.invPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfCd = this.soIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
