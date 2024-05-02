/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PsaManifestCmInfoVO.java
*@FileTitle : PsaManifestCmInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class PsaManifestCmInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaManifestCmInfoVO> models = new ArrayList<PsaManifestCmInfoVO>();
	
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String commodityCd = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsPckTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String measUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PsaManifestCmInfoVO() {}

	public PsaManifestCmInfoVO(String ibflag, String pagerows, String cntrNo, String cntrMfSeq, String pckQty, String cstmsPckTpCd, String cntrMfWgt, String wgtUtCd, String measQty, String measUtCd, String cmdtHsCd, String commodityCd, String cntrMfMkDesc) {
		this.cntrMfWgt = cntrMfWgt;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.commodityCd = commodityCd;
		this.cntrMfSeq = cntrMfSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cstmsPckTpCd = cstmsPckTpCd;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.cmdtHsCd = cmdtHsCd;
		this.measUtCd = measUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("commodity_cd", getCommodityCd());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_pck_tp_cd", getCstmsPckTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("commodity_cd", "commodityCd");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_pck_tp_cd", "cstmsPckTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc
	 */
	public String getCntrMfMkDesc() {
		return this.cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return commodityCd
	 */
	public String getCommodityCd() {
		return this.commodityCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
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
	 * @return cstmsPckTpCd
	 */
	public String getCstmsPckTpCd() {
		return this.cstmsPckTpCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	

	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc
	 */
	public void setCntrMfMkDesc(String cntrMfMkDesc) {
		this.cntrMfMkDesc = cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param commodityCd
	 */
	public void setCommodityCd(String commodityCd) {
		this.commodityCd = commodityCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
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
	 * @param cstmsPckTpCd
	 */
	public void setCstmsPckTpCd(String cstmsPckTpCd) {
		this.cstmsPckTpCd = cstmsPckTpCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setCommodityCd(JSPUtil.getParameter(request, prefix + "commodity_cd", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCstmsPckTpCd(JSPUtil.getParameter(request, prefix + "cstms_pck_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaManifestCmInfoVO[]
	 */
	public PsaManifestCmInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaManifestCmInfoVO[]
	 */
	public PsaManifestCmInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaManifestCmInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] commodityCd = (JSPUtil.getParameter(request, prefix	+ "commodity_cd", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsPckTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pck_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaManifestCmInfoVO();
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (commodityCd[i] != null)
					model.setCommodityCd(commodityCd[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsPckTpCd[i] != null)
					model.setCstmsPckTpCd(cstmsPckTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaManifestCmInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaManifestCmInfoVO[]
	 */
	public PsaManifestCmInfoVO[] getPsaManifestCmInfoVOs(){
		PsaManifestCmInfoVO[] vos = (PsaManifestCmInfoVO[])models.toArray(new PsaManifestCmInfoVO[models.size()]);
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
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodityCd = this.commodityCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPckTpCd = this.cstmsPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
