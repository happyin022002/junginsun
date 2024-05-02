/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaBkgQtyTmpVO.java
*@FileTitle : PsaBkgQtyTmpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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

public class PsaBkgQtyTmpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaBkgQtyTmpVO> models = new ArrayList<PsaBkgQtyTmpVO>();

	/* Column Info */
	private String speRf = null;
	/* Column Info */
	private String cntrtsCd = null;
	/* Column Info */
	private String speRd = null;
	/* Column Info */
	private String owInd = null;
	/* Column Info */
	private String cntrSz = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String speDg = null;
	/* Column Info */
	private String cntrHeight = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ohInd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String rfTemp = null;
	/* Column Info */
	private String olInd = null;
	/* Column Info */
	private String humidNo = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaBkgQtyTmpVO() {}

	public PsaBkgQtyTmpVO(String ibflag, String pagerows, String cntrSz, String cntrHeight, String speRf, String speRd, String rfTemp, String ohInd, String owInd, String olInd, String speDg, String cntrtsCd, String ydCd, String humidNo) {
		this.speRf = speRf;
		this.cntrtsCd = cntrtsCd;
		this.speRd = speRd;
		this.owInd = owInd;
		this.cntrSz = cntrSz;
		this.pagerows = pagerows;
		this.speDg = speDg;
		this.cntrHeight = cntrHeight;
		this.ibflag = ibflag;
		this.ohInd = ohInd;
		this.ydCd = ydCd;
		this.rfTemp = rfTemp;
		this.olInd = olInd;
		this.humidNo = humidNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spe_rf", getSpeRf());
		this.hashColumns.put("cntrts_cd", getCntrtsCd());
		this.hashColumns.put("spe_rd", getSpeRd());
		this.hashColumns.put("ow_ind", getOwInd());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spe_dg", getSpeDg());
		this.hashColumns.put("cntr_height", getCntrHeight());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oh_ind", getOhInd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("rf_temp", getRfTemp());
		this.hashColumns.put("ol_ind", getOlInd());
		this.hashColumns.put("humid_no", getHumidNo());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spe_rf", "speRf");
		this.hashFields.put("cntrts_cd", "cntrtsCd");
		this.hashFields.put("spe_rd", "speRd");
		this.hashFields.put("ow_ind", "owInd");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spe_dg", "speDg");
		this.hashFields.put("cntr_height", "cntrHeight");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oh_ind", "ohInd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("rf_temp", "rfTemp");
		this.hashFields.put("ol_ind", "olInd");
		this.hashFields.put("humid_no", "humidNo");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return speRf
	 */
	public String getSpeRf() {
		return this.speRf;
	}

	/**
	 * Column Info
	 * @return cntrtsCd
	 */
	public String getCntrtsCd() {
		return this.cntrtsCd;
	}

	/**
	 * Column Info
	 * @return speRd
	 */
	public String getSpeRd() {
		return this.speRd;
	}

	/**
	 * Column Info
	 * @return owInd
	 */
	public String getOwInd() {
		return this.owInd;
	}

	/**
	 * Column Info
	 * @return cntrSz
	 */
	public String getCntrSz() {
		return this.cntrSz;
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
	 * @return speDg
	 */
	public String getSpeDg() {
		return this.speDg;
	}

	/**
	 * Column Info
	 * @return cntrHeight
	 */
	public String getCntrHeight() {
		return this.cntrHeight;
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
	 * @return ohInd
	 */
	public String getOhInd() {
		return this.ohInd;
	}

	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}

	/**
	 * Column Info
	 * @return rfTemp
	 */
	public String getRfTemp() {
		return this.rfTemp;
	}

	/**
	 * Column Info
	 * @return olInd
	 */
	public String getOlInd() {
		return this.olInd;
	}


	/**
	 * Column Info
	 * @param speRf
	 */
	public void setSpeRf(String speRf) {
		this.speRf = speRf;
	}

	/**
	 * Column Info
	 * @param cntrtsCd
	 */
	public void setCntrtsCd(String cntrtsCd) {
		this.cntrtsCd = cntrtsCd;
	}

	/**
	 * Column Info
	 * @param speRd
	 */
	public void setSpeRd(String speRd) {
		this.speRd = speRd;
	}

	/**
	 * Column Info
	 * @param owInd
	 */
	public void setOwInd(String owInd) {
		this.owInd = owInd;
	}

	/**
	 * Column Info
	 * @param cntrSz
	 */
	public void setCntrSz(String cntrSz) {
		this.cntrSz = cntrSz;
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
	 * @param speDg
	 */
	public void setSpeDg(String speDg) {
		this.speDg = speDg;
	}

	/**
	 * Column Info
	 * @param cntrHeight
	 */
	public void setCntrHeight(String cntrHeight) {
		this.cntrHeight = cntrHeight;
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
	 * @param ohInd
	 */
	public void setOhInd(String ohInd) {
		this.ohInd = ohInd;
	}

	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	/**
	 * Column Info
	 * @param rfTemp
	 */
	public void setRfTemp(String rfTemp) {
		this.rfTemp = rfTemp;
	}

	/**
	 * Column Info
	 * @param olInd
	 */
	public void setOlInd(String olInd) {
		this.olInd = olInd;
	}

	public String getHumidNo() {
		return humidNo;
	}

	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
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
		setSpeRf(JSPUtil.getParameter(request, prefix + "spe_rf", ""));
		setCntrtsCd(JSPUtil.getParameter(request, prefix + "cntrts_cd", ""));
		setSpeRd(JSPUtil.getParameter(request, prefix + "spe_rd", ""));
		setOwInd(JSPUtil.getParameter(request, prefix + "ow_ind", ""));
		setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpeDg(JSPUtil.getParameter(request, prefix + "spe_dg", ""));
		setCntrHeight(JSPUtil.getParameter(request, prefix + "cntr_height", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOhInd(JSPUtil.getParameter(request, prefix + "oh_ind", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setRfTemp(JSPUtil.getParameter(request, prefix + "rf_temp", ""));
		setOlInd(JSPUtil.getParameter(request, prefix + "ol_ind", ""));
		setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaBkgQtyTmpVO[]
	 */
	public PsaBkgQtyTmpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaBkgQtyTmpVO[]
	 */
	public PsaBkgQtyTmpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaBkgQtyTmpVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] speRf = (JSPUtil.getParameter(request, prefix	+ "spe_rf", length));
			String[] cntrtsCd = (JSPUtil.getParameter(request, prefix	+ "cntrts_cd", length));
			String[] speRd = (JSPUtil.getParameter(request, prefix	+ "spe_rd", length));
			String[] owInd = (JSPUtil.getParameter(request, prefix	+ "ow_ind", length));
			String[] cntrSz = (JSPUtil.getParameter(request, prefix	+ "cntr_sz", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] speDg = (JSPUtil.getParameter(request, prefix	+ "spe_dg", length));
			String[] cntrHeight = (JSPUtil.getParameter(request, prefix	+ "cntr_height", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ohInd = (JSPUtil.getParameter(request, prefix	+ "oh_ind", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] rfTemp = (JSPUtil.getParameter(request, prefix	+ "rf_temp", length));
			String[] olInd = (JSPUtil.getParameter(request, prefix	+ "ol_ind", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));


			for (int i = 0; i < length; i++) {
				model = new PsaBkgQtyTmpVO();
				if (speRf[i] != null)
					model.setSpeRf(speRf[i]);
				if (cntrtsCd[i] != null)
					model.setCntrtsCd(cntrtsCd[i]);
				if (speRd[i] != null)
					model.setSpeRd(speRd[i]);
				if (owInd[i] != null)
					model.setOwInd(owInd[i]);
				if (cntrSz[i] != null)
					model.setCntrSz(cntrSz[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (speDg[i] != null)
					model.setSpeDg(speDg[i]);
				if (cntrHeight[i] != null)
					model.setCntrHeight(cntrHeight[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ohInd[i] != null)
					model.setOhInd(ohInd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (rfTemp[i] != null)
					model.setRfTemp(rfTemp[i]);
				if (olInd[i] != null)
					model.setOlInd(olInd[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaBkgQtyTmpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaBkgQtyTmpVO[]
	 */
	public PsaBkgQtyTmpVO[] getPsaBkgQtyTmpVOs(){
		PsaBkgQtyTmpVO[] vos = (PsaBkgQtyTmpVO[])models.toArray(new PsaBkgQtyTmpVO[models.size()]);
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
		this.speRf = this.speRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtsCd = this.cntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.speRd = this.speRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.owInd = this.owInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz = this.cntrSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.speDg = this.speDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHeight = this.cntrHeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohInd = this.ohInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTemp = this.rfTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olInd = this.olInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
