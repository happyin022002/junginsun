/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ThailandManifestListCntrInfoVO.java
*@FileTitle : ThailandManifestListCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.29  
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.08.20 김보배 [CHM-201219455] [BKG] Thailand Manifest - 기능 보완
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ThailandManifestListCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ThailandManifestListCntrInfoVO> models = new ArrayList<ThailandManifestListCntrInfoVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String positon = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String consignee = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrTpszRmk = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ThailandManifestListCntrInfoVO() {}

	public ThailandManifestListCntrInfoVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String cntrTpszCd, String tpCd, String cntrTpszRmk, String consignee, String cntrWgt, String wgtUtCd, String status, String polCd, String positon, String cdoTemp, String imdgClssCd, String imdgUnNo, String rcFlg, String dcgoFlg) {
		this.cntrWgt = cntrWgt;
		this.positon = positon;
		this.status = status;
		this.consignee = consignee;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrTpszRmk = cntrTpszRmk;
		this.polCd = polCd;
		this.cdoTemp = cdoTemp;
		this.cntrNo = cntrNo;
		this.dcgoFlg = dcgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.tpCd = tpCd;
		this.rcFlg = rcFlg;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("positon", getPositon());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_tpsz_rmk", getCntrTpszRmk());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("positon", "positon");
		this.hashFields.put("status", "status");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_tpsz_rmk", "cntrTpszRmk");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return positon
	 */
	public String getPositon() {
		return this.positon;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return consignee
	 */
	public String getConsignee() {
		return this.consignee;
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
	 * @return cntrTpszRmk
	 */
	public String getCntrTpszRmk() {
		return this.cntrTpszRmk;
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
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param positon
	 */
	public void setPositon(String positon) {
		this.positon = positon;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
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
	 * @param cntrTpszRmk
	 */
	public void setCntrTpszRmk(String cntrTpszRmk) {
		this.cntrTpszRmk = cntrTpszRmk;
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
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
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
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setPositon(JSPUtil.getParameter(request, prefix + "positon", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrTpszRmk(JSPUtil.getParameter(request, prefix + "cntr_tpsz_rmk", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ThailandManifestListCntrInfoVO[]
	 */
	public ThailandManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ThailandManifestListCntrInfoVO[]
	 */
	public ThailandManifestListCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ThailandManifestListCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] positon = (JSPUtil.getParameter(request, prefix	+ "positon", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrTpszRmk = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_rmk", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ThailandManifestListCntrInfoVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (positon[i] != null)
					model.setPositon(positon[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrTpszRmk[i] != null)
					model.setCntrTpszRmk(cntrTpszRmk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getThailandManifestListCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ThailandManifestListCntrInfoVO[]
	 */
	public ThailandManifestListCntrInfoVO[] getThailandManifestListCntrInfoVOs(){
		ThailandManifestListCntrInfoVO[] vos = (ThailandManifestListCntrInfoVO[])models.toArray(new ThailandManifestListCntrInfoVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.positon = this.positon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszRmk = this.cntrTpszRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
