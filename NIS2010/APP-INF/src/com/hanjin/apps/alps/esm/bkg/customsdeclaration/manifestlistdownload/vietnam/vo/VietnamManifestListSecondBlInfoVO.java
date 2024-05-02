/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VietnamManifestListSecondBlInfoVO.java
*@FileTitle : VietnamManifestListSecondBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo;

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

public class VietnamManifestListSecondBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VietnamManifestListSecondBlInfoVO> models = new ArrayList<VietnamManifestListSecondBlInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String tsPort = null;
	/* Column Info */
	private String demensionTonnage = null;
	/* Column Info */
	private String packAge = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String grossWeight = null;
	/* Column Info */
	private String grossunit = null;
	/* Column Info */
	private String netWeight = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String finalDel = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String ajustmentBasis = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String packageUnit = null;
	/* Column Info */
	private String contType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VietnamManifestListSecondBlInfoVO() {}

	public VietnamManifestListSecondBlInfoVO(String ibflag, String pagerows, String blNo, String cntrNo, String shCustNm, String cnCustNm, String nfCustNm, String cntrSealNo, String cmdtHsCd, String cmdtDesc, String packAge, String packageUnit, String netWeight, String grossWeight, String grossunit, String demensionTonnage, String refNo, String ajustmentBasis, String podCd, String delCd, String polCd, String porCd, String finalDel, String contType, String tsPort) {
		this.porCd = porCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cmdtHsCd = cmdtHsCd;
		this.nfCustNm = nfCustNm;
		this.tsPort = tsPort;
		this.demensionTonnage = demensionTonnage;
		this.packAge = packAge;
		this.delCd = delCd;
		this.grossWeight = grossWeight;
		this.grossunit = grossunit;
		this.netWeight = netWeight;
		this.podCd = podCd;
		this.shCustNm = shCustNm;
		this.finalDel = finalDel;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.refNo = refNo;
		this.ajustmentBasis = ajustmentBasis;
		this.cntrSealNo = cntrSealNo;
		this.cnCustNm = cnCustNm;
		this.packageUnit = packageUnit;
		this.contType = contType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("ts_port", getTsPort());
		this.hashColumns.put("demension_tonnage", getDemensionTonnage());
		this.hashColumns.put("pack_age", getPackAge());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("gross_weight", getGrossWeight());
		this.hashColumns.put("grossunit", getGrossunit());
		this.hashColumns.put("net_weight", getNetWeight());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("final_del", getFinalDel());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("ajustment_basis", getAjustmentBasis());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("package_unit", getPackageUnit());
		this.hashColumns.put("cont_type", getContType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("ts_port", "tsPort");
		this.hashFields.put("demension_tonnage", "demensionTonnage");
		this.hashFields.put("pack_age", "packAge");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("gross_weight", "grossWeight");
		this.hashFields.put("grossunit", "grossunit");
		this.hashFields.put("net_weight", "netWeight");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("final_del", "finalDel");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("ajustment_basis", "ajustmentBasis");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("package_unit", "packageUnit");
		this.hashFields.put("cont_type", "contType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustNm
	 */
	public String getNfCustNm() {
		return this.nfCustNm;
	}
	
	/**
	 * Column Info
	 * @return tsPort
	 */
	public String getTsPort() {
		return this.tsPort;
	}
	
	/**
	 * Column Info
	 * @return demensionTonnage
	 */
	public String getDemensionTonnage() {
		return this.demensionTonnage;
	}
	
	/**
	 * Column Info
	 * @return packAge
	 */
	public String getPackAge() {
		return this.packAge;
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
	 * @return grossWeight
	 */
	public String getGrossWeight() {
		return this.grossWeight;
	}
	
	/**
	 * Column Info
	 * @return grossunit
	 */
	public String getGrossunit() {
		return this.grossunit;
	}
	
	/**
	 * Column Info
	 * @return netWeight
	 */
	public String getNetWeight() {
		return this.netWeight;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
	}
	
	/**
	 * Column Info
	 * @return finalDel
	 */
	public String getFinalDel() {
		return this.finalDel;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return ajustmentBasis
	 */
	public String getAjustmentBasis() {
		return this.ajustmentBasis;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return cnCustNm
	 */
	public String getCnCustNm() {
		return this.cnCustNm;
	}
	
	/**
	 * Column Info
	 * @return packageUnit
	 */
	public String getPackageUnit() {
		return this.packageUnit;
	}
	
	/**
	 * Column Info
	 * @return contType
	 */
	public String getContType() {
		return this.contType;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustNm
	 */
	public void setNfCustNm(String nfCustNm) {
		this.nfCustNm = nfCustNm;
	}
	
	/**
	 * Column Info
	 * @param tsPort
	 */
	public void setTsPort(String tsPort) {
		this.tsPort = tsPort;
	}
	
	/**
	 * Column Info
	 * @param demensionTonnage
	 */
	public void setDemensionTonnage(String demensionTonnage) {
		this.demensionTonnage = demensionTonnage;
	}
	
	/**
	 * Column Info
	 * @param packAge
	 */
	public void setPackAge(String packAge) {
		this.packAge = packAge;
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
	 * @param grossWeight
	 */
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}
	
	/**
	 * Column Info
	 * @param grossunit
	 */
	public void setGrossunit(String grossunit) {
		this.grossunit = grossunit;
	}
	
	/**
	 * Column Info
	 * @param netWeight
	 */
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}
	
	/**
	 * Column Info
	 * @param finalDel
	 */
	public void setFinalDel(String finalDel) {
		this.finalDel = finalDel;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param ajustmentBasis
	 */
	public void setAjustmentBasis(String ajustmentBasis) {
		this.ajustmentBasis = ajustmentBasis;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param cnCustNm
	 */
	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}
	
	/**
	 * Column Info
	 * @param packageUnit
	 */
	public void setPackageUnit(String packageUnit) {
		this.packageUnit = packageUnit;
	}
	
	/**
	 * Column Info
	 * @param contType
	 */
	public void setContType(String contType) {
		this.contType = contType;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setNfCustNm(JSPUtil.getParameter(request, prefix + "nf_cust_nm", ""));
		setTsPort(JSPUtil.getParameter(request, prefix + "ts_port", ""));
		setDemensionTonnage(JSPUtil.getParameter(request, prefix + "demension_tonnage", ""));
		setPackAge(JSPUtil.getParameter(request, prefix + "pack_age", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setGrossWeight(JSPUtil.getParameter(request, prefix + "gross_weight", ""));
		setGrossunit(JSPUtil.getParameter(request, prefix + "grossunit", ""));
		setNetWeight(JSPUtil.getParameter(request, prefix + "net_weight", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setShCustNm(JSPUtil.getParameter(request, prefix + "sh_cust_nm", ""));
		setFinalDel(JSPUtil.getParameter(request, prefix + "final_del", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setAjustmentBasis(JSPUtil.getParameter(request, prefix + "ajustment_basis", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCnCustNm(JSPUtil.getParameter(request, prefix + "cn_cust_nm", ""));
		setPackageUnit(JSPUtil.getParameter(request, prefix + "package_unit", ""));
		setContType(JSPUtil.getParameter(request, prefix + "cont_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VietnamManifestListSecondBlInfoVO[]
	 */
	public VietnamManifestListSecondBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VietnamManifestListSecondBlInfoVO[]
	 */
	public VietnamManifestListSecondBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VietnamManifestListSecondBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] tsPort = (JSPUtil.getParameter(request, prefix	+ "ts_port", length));
			String[] demensionTonnage = (JSPUtil.getParameter(request, prefix	+ "demension_tonnage", length));
			String[] packAge = (JSPUtil.getParameter(request, prefix	+ "pack_age", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] grossWeight = (JSPUtil.getParameter(request, prefix	+ "gross_weight", length));
			String[] grossunit = (JSPUtil.getParameter(request, prefix	+ "grossunit", length));
			String[] netWeight = (JSPUtil.getParameter(request, prefix	+ "net_weight", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] finalDel = (JSPUtil.getParameter(request, prefix	+ "final_del", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] ajustmentBasis = (JSPUtil.getParameter(request, prefix	+ "ajustment_basis", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] packageUnit = (JSPUtil.getParameter(request, prefix	+ "package_unit", length));
			String[] contType = (JSPUtil.getParameter(request, prefix	+ "cont_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new VietnamManifestListSecondBlInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (tsPort[i] != null)
					model.setTsPort(tsPort[i]);
				if (demensionTonnage[i] != null)
					model.setDemensionTonnage(demensionTonnage[i]);
				if (packAge[i] != null)
					model.setPackAge(packAge[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (grossWeight[i] != null)
					model.setGrossWeight(grossWeight[i]);
				if (grossunit[i] != null)
					model.setGrossunit(grossunit[i]);
				if (netWeight[i] != null)
					model.setNetWeight(netWeight[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (finalDel[i] != null)
					model.setFinalDel(finalDel[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (ajustmentBasis[i] != null)
					model.setAjustmentBasis(ajustmentBasis[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (packageUnit[i] != null)
					model.setPackageUnit(packageUnit[i]);
				if (contType[i] != null)
					model.setContType(contType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVietnamManifestListSecondBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VietnamManifestListSecondBlInfoVO[]
	 */
	public VietnamManifestListSecondBlInfoVO[] getVietnamManifestListSecondBlInfoVOs(){
		VietnamManifestListSecondBlInfoVO[] vos = (VietnamManifestListSecondBlInfoVO[])models.toArray(new VietnamManifestListSecondBlInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort = this.tsPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demensionTonnage = this.demensionTonnage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packAge = this.packAge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossWeight = this.grossWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossunit = this.grossunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWeight = this.netWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalDel = this.finalDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ajustmentBasis = this.ajustmentBasis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packageUnit = this.packageUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contType = this.contType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
