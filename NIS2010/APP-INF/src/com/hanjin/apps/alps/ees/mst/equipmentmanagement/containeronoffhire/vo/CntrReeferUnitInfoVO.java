/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrReeferUnitInfoVO.java
*@FileTitle : CntrReeferUnitInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.20
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.10.20 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrReeferUnitInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrReeferUnitInfoVO> models = new ArrayList<CntrReeferUnitInfoVO>();
	
	/* Column Info */
	private String rfMkrNm = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String ceflg = null;
	/* Column Info */
	private String minTemp = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String rfMdlNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String maxTemp = null;
	/* Column Info */
	private String rfMkrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aeflg = null;
	/* Column Info */
	private String eeflg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String beflg = null;
	/* Column Info */
	private String deflg = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String rfRfrNo = null;
	/* Column Info */
	private String usrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrReeferUnitInfoVO() {}

	public CntrReeferUnitInfoVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String lstmCd, String onhDt, String agmtNo, String vndrSeq, String rfMkrSeq, String rfMkrNm, String rfMdlNm, String rfRfrNo, String minTemp, String maxTemp, String aeflg, String beflg, String ceflg, String deflg, String eeflg, String usrId) {
		this.rfMkrNm = rfMkrNm;
		this.agmtNo = agmtNo;
		this.ceflg = ceflg;
		this.minTemp = minTemp;
		this.onhDt = onhDt;
		this.rfMdlNm = rfMdlNm;
		this.pagerows = pagerows;
		this.maxTemp = maxTemp;
		this.rfMkrSeq = rfMkrSeq;
		this.ibflag = ibflag;
		this.aeflg = aeflg;
		this.eeflg = eeflg;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.beflg = beflg;
	    this.deflg = deflg;
		this.lstmCd = lstmCd;
		this.rfRfrNo = rfRfrNo;
		this.usrId = usrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_mkr_nm", getRfMkrNm());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ceflg", getCeflg());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aeflg", getAeflg());
		this.hashColumns.put("eeflg", getEeflg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("beflg", getBeflg());
		this.hashColumns.put("deflg", getDeflg());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("rf_rfr_no", getRfRfrNo());
		this.hashColumns.put("usr_id", getUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_mkr_nm", "rfMkrNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aeflg", "aeflg");
		this.hashFields.put("eeflg", "eeflg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("beflg", "beflg");
		this.hashFields.put("deflg", "deflg");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("rf_rfr_no", "rfRfrNo");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rfMkrNm
	 */
	public String getRfMkrNm() {
		return this.rfMkrNm;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return ceflg
	 */
	public String getCeflg() {
		return this.ceflg;
	}
	
	/**
	 * Column Info
	 * @return minTemp
	 */
	public String getMinTemp() {
		return this.minTemp;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return rfMdlNm
	 */
	public String getRfMdlNm() {
		return this.rfMdlNm;
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
	 * @return maxTemp
	 */
	public String getMaxTemp() {
		return this.maxTemp;
	}
	
	/**
	 * Column Info
	 * @return rfMkrSeq
	 */
	public String getRfMkrSeq() {
		return this.rfMkrSeq;
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
	 * @return aeflg
	 */
	public String getAeflg() {
		return this.aeflg;
	}
	
	/**
	 * Column Info
	 * @return eeflg
	 */
	public String getEeflg() {
		return this.eeflg;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return deflg
	 */
	public String getDeflg() {
		return this.deflg;
	}
	
	/**
	 * Column Info
	 * @return beflg
	 */
	public String getBeflg() {
		return this.beflg;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return rfRfrNo
	 */
	public String getRfRfrNo() {
		return this.rfRfrNo;
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
	 * @param rfMkrNm
	 */
	public void setRfMkrNm(String rfMkrNm) {
		this.rfMkrNm = rfMkrNm;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param ceflg
	 */
	public void setCeflg(String ceflg) {
		this.ceflg = ceflg;
	}
	
	/**
	 * Column Info
	 * @param minTemp
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param rfMdlNm
	 */
	public void setRfMdlNm(String rfMdlNm) {
		this.rfMdlNm = rfMdlNm;
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
	 * @param maxTemp
	 */
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	/**
	 * Column Info
	 * @param rfMkrSeq
	 */
	public void setRfMkrSeq(String rfMkrSeq) {
		this.rfMkrSeq = rfMkrSeq;
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
	 * @param aeflg
	 */
	public void setAeflg(String aeflg) {
		this.aeflg = aeflg;
	}
	
	/**
	 * Column Info
	 * @param eeflg
	 */
	public void setEeflg(String eeflg) {
		this.eeflg = eeflg;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param beflg
	 */
	public void setBeflg(String beflg) {
		this.beflg = beflg;
	}
	
	/**
	 * Column Info
	 * @param deflg
	 */
	public void setDeflg(String deflg) {
		this.deflg = deflg;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param rfRfrNo
	 */
	public void setRfRfrNo(String rfRfrNo) {
		this.rfRfrNo = rfRfrNo;
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
		setRfMkrNm(JSPUtil.getParameter(request, prefix + "rf_mkr_nm", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCeflg(JSPUtil.getParameter(request, prefix + "ceflg", ""));
		setMinTemp(JSPUtil.getParameter(request, prefix + "min_temp", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setRfMdlNm(JSPUtil.getParameter(request, prefix + "rf_mdl_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMaxTemp(JSPUtil.getParameter(request, prefix + "max_temp", ""));
		setRfMkrSeq(JSPUtil.getParameter(request, prefix + "rf_mkr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAeflg(JSPUtil.getParameter(request, prefix + "aeflg", ""));
		setEeflg(JSPUtil.getParameter(request, prefix + "eeflg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setBeflg(JSPUtil.getParameter(request, prefix + "beflg", ""));
		setDeflg(JSPUtil.getParameter(request, prefix + "deflg", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setRfRfrNo(JSPUtil.getParameter(request, prefix + "rf_rfr_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchCntrReeferUnitInfoListVO[]
	 */
	public CntrReeferUnitInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchCntrReeferUnitInfoListVO[]
	 */
	public CntrReeferUnitInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrReeferUnitInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfMkrNm = (JSPUtil.getParameter(request, prefix	+ "rf_mkr_nm", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] ceflg = (JSPUtil.getParameter(request, prefix	+ "ceflg", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] rfMdlNm = (JSPUtil.getParameter(request, prefix	+ "rf_mdl_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] rfMkrSeq = (JSPUtil.getParameter(request, prefix	+ "rf_mkr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aeflg = (JSPUtil.getParameter(request, prefix	+ "aeflg", length));
			String[] eeflg = (JSPUtil.getParameter(request, prefix	+ "eeflg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] beflg = (JSPUtil.getParameter(request, prefix	+ "beflg", length));
			String[] deflg = (JSPUtil.getParameter(request, prefix	+ "deflg", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] rfRfrNo = (JSPUtil.getParameter(request, prefix	+ "rf_rfr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrReeferUnitInfoVO();
				if (rfMkrNm[i] != null)
					model.setRfMkrNm(rfMkrNm[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (ceflg[i] != null)
					model.setCeflg(ceflg[i]);
				if (minTemp[i] != null)
					model.setMinTemp(minTemp[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (rfMdlNm[i] != null)
					model.setRfMdlNm(rfMdlNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (maxTemp[i] != null)
					model.setMaxTemp(maxTemp[i]);
				if (rfMkrSeq[i] != null)
					model.setRfMkrSeq(rfMkrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aeflg[i] != null)
					model.setAeflg(aeflg[i]);
				if (eeflg[i] != null)
					model.setEeflg(eeflg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (beflg[i] != null)
					model.setBeflg(beflg[i]);
				if (deflg[i] != null)
					model.setDeflg(deflg[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (rfRfrNo[i] != null)
					model.setRfRfrNo(rfRfrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrReeferUnitInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchCntrReeferUnitInfoListVO[]
	 */
	public CntrReeferUnitInfoVO[] getCntrReeferUnitInfoVOs(){
		CntrReeferUnitInfoVO[] vos = (CntrReeferUnitInfoVO[])models.toArray(new CntrReeferUnitInfoVO[models.size()]);
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
		this.rfMkrNm = this.rfMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg = this.ceflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm = this.rfMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq = this.rfMkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeflg = this.aeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeflg = this.eeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beflg = this.beflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deflg = this.deflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRfrNo = this.rfRfrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
