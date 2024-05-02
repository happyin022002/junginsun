/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgSrEmlEdtVO.java
*@FileTitle : BkgSrEmlEdtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.28  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgSrEmlEdtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgSrEmlEdtVO> models = new ArrayList<BkgSrEmlEdtVO>();
	
	/* Column Info */
	private String vgmCutOff = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String dum2 = null;
	/* Column Info */
	private String dum1 = null;
	/* Column Info */
	private String etbEtdDt = null;
	/* Column Info */
	private String polPodCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String cargo = null;
	/* Column Info */
	private String doc = null;
	/* Column Info */
	private String cnOfcFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgSrEmlEdtVO() {}

	public BkgSrEmlEdtVO(String ibflag, String pagerows, String vslNm, String bkgNo, String polPodCd, String etbEtdDt, String cargo, String dum1, String dum2, String remark, String doc, String cnOfcFlg, String vgmCutOff) {
		this.vgmCutOff = vgmCutOff;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.remark = remark;
		this.dum2 = dum2;
		this.dum1 = dum1;
		this.etbEtdDt = etbEtdDt;
		this.polPodCd = polPodCd;
		this.vslNm = vslNm;
		this.cargo = cargo;
		this.doc = doc;
		this.cnOfcFlg = cnOfcFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vgm_cut_off", getVgmCutOff());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("dum2", getDum2());
		this.hashColumns.put("dum1", getDum1());
		this.hashColumns.put("etb_etd_dt", getEtbEtdDt());
		this.hashColumns.put("pol_pod_cd", getPolPodCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("cargo", getCargo());
		this.hashColumns.put("doc", getDoc());
		this.hashColumns.put("cn_ofc_flg", getCnOfcFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vgm_cut_off", "vgmCutOff");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("dum2", "dum2");
		this.hashFields.put("dum1", "dum1");
		this.hashFields.put("etb_etd_dt", "etbEtdDt");
		this.hashFields.put("pol_pod_cd", "polPodCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("cargo", "cargo");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("cn_ofc_flg", "cnOfcFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vgmCutOff
	 */
	public String getVgmCutOff() {
		return this.vgmCutOff;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return dum2
	 */
	public String getDum2() {
		return this.dum2;
	}
	
	/**
	 * Column Info
	 * @return dum1
	 */
	public String getDum1() {
		return this.dum1;
	}
	
	/**
	 * Column Info
	 * @return etbEtdDt
	 */
	public String getEtbEtdDt() {
		return this.etbEtdDt;
	}
	
	/**
	 * Column Info
	 * @return polPodCd
	 */
	public String getPolPodCd() {
		return this.polPodCd;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return cnOfcFlg
	 */
	public String getCnOfcFlg() {
		return this.cnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return cargo
	 */
	public String getCargo() {
		return this.cargo;
	}
	
	/**
	 * Column Info
	 * @return doc
	 */
	public String getDoc() {
		return this.doc;
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
	 * @param vgmCutOff
	 */
	public void setVgmCutOff(String vgmCutOff) {
		this.vgmCutOff = vgmCutOff;
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
	 * @param cnOfcFlg
	 */
	public void setCnOfcFlg(String cnOfcFlg) {
		this.cnOfcFlg = cnOfcFlg;
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
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param dum2
	 */
	public void setDum2(String dum2) {
		this.dum2 = dum2;
	}
	
	/**
	 * Column Info
	 * @param dum1
	 */
	public void setDum1(String dum1) {
		this.dum1 = dum1;
	}
	
	/**
	 * Column Info
	 * @param etbEtdDt
	 */
	public void setEtbEtdDt(String etbEtdDt) {
		this.etbEtdDt = etbEtdDt;
	}
	
	/**
	 * Column Info
	 * @param polPodCd
	 */
	public void setPolPodCd(String polPodCd) {
		this.polPodCd = polPodCd;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Column Info
	 * @param doc
	 */
	public void setDoc(String doc) {
		this.doc = doc;
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
		setVgmCutOff(JSPUtil.getParameter(request, prefix + "vgm_cut_off", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setDum2(JSPUtil.getParameter(request, prefix + "dum2", ""));
		setDum1(JSPUtil.getParameter(request, prefix + "dum1", ""));
		setEtbEtdDt(JSPUtil.getParameter(request, prefix + "etb_etd_dt", ""));
		setPolPodCd(JSPUtil.getParameter(request, prefix + "pol_pod_cd", ""));
		setCnOfcFlg(JSPUtil.getParameter(request, prefix + "cn_ofc_flg", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setCargo(JSPUtil.getParameter(request, prefix + "cargo", ""));
		setDoc(JSPUtil.getParameter(request, prefix + "doc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgSrEmlEdtVO[]
	 */
	public BkgSrEmlEdtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgSrEmlEdtVO[]
	 */
	public BkgSrEmlEdtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgSrEmlEdtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vgmCutOff = (JSPUtil.getParameter(request, prefix	+ "vgm_cut_off", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] dum2 = (JSPUtil.getParameter(request, prefix	+ "dum2", length));
			String[] dum1 = (JSPUtil.getParameter(request, prefix	+ "dum1", length));
			String[] etbEtdDt = (JSPUtil.getParameter(request, prefix	+ "etb_etd_dt", length));
			String[] polPodCd = (JSPUtil.getParameter(request, prefix	+ "pol_pod_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] cargo = (JSPUtil.getParameter(request, prefix	+ "cargo", length));
			String[] doc = (JSPUtil.getParameter(request, prefix	+ "doc", length));
			String[] cnOfcFlg = (JSPUtil.getParameter(request, prefix	+ "cn_ofc_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgSrEmlEdtVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (dum2[i] != null)
					model.setDum2(dum2[i]);
				if (dum1[i] != null)
					model.setDum1(dum1[i]);
				if (etbEtdDt[i] != null)
					model.setEtbEtdDt(etbEtdDt[i]);
				if (polPodCd[i] != null)
					model.setPolPodCd(polPodCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (cnOfcFlg[i] != null)
					model.setCnOfcFlg(cnOfcFlg[i]);
				if (cargo[i] != null)
					model.setCargo(cargo[i]);
				if (doc[i] != null)
					model.setDoc(doc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vgmCutOff[i] != null)
					model.setVgmCutOff(vgmCutOff[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgSrEmlEdtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgSrEmlEdtVO[]
	 */
	public BkgSrEmlEdtVO[] getBkgSrEmlEdtVOs(){
		BkgSrEmlEdtVO[] vos = (BkgSrEmlEdtVO[])models.toArray(new BkgSrEmlEdtVO[models.size()]);
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
		this.vgmCutOff = this.vgmCutOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dum2 = this.dum2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dum1 = this.dum1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbEtdDt = this.etbEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodCd = this.polPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnOfcFlg = this.cnOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargo = this.cargo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc = this.doc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
