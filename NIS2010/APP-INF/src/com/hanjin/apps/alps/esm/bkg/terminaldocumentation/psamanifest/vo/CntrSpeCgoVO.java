/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrSpeCgoVO.java
*@FileTitle : CntrSpeCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.08 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrSpeCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrSpeCgoVO> models = new ArrayList<CntrSpeCgoVO>();
	
	/* Column Info */
	private String speRf = null;
	/* Column Info */
	private String speAk = null;
	/* Column Info */
	private String speRd = null;
	/* Column Info */
	private String owInd = null;
	/* Column Info */
	private String akExist = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String speDg = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ohInd = null;
	/* Column Info */
	private String rfExist = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rfTemp = null;
	/* Column Info */
	private String olInd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrSpeCgoVO() {}

	public CntrSpeCgoVO(String ibflag, String pagerows, String cntrNo, String speDg, String speRf, String speRd, String speAk, String akExist, String ohInd, String owInd, String olInd, String rfExist, String rfTemp, String bkgNo, String cntrTpszCd) {
		this.speRf = speRf;
		this.speAk = speAk;
		this.speRd = speRd;
		this.owInd = owInd;
		this.akExist = akExist;
		this.pagerows = pagerows;
		this.speDg = speDg;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.ohInd = ohInd;
		this.rfExist = rfExist;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.rfTemp = rfTemp;
		this.olInd = olInd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spe_rf", getSpeRf());
		this.hashColumns.put("spe_ak", getSpeAk());
		this.hashColumns.put("spe_rd", getSpeRd());
		this.hashColumns.put("ow_ind", getOwInd());
		this.hashColumns.put("ak_exist", getAkExist());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spe_dg", getSpeDg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oh_ind", getOhInd());
		this.hashColumns.put("rf_exist", getRfExist());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rf_temp", getRfTemp());
		this.hashColumns.put("ol_ind", getOlInd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spe_rf", "speRf");
		this.hashFields.put("spe_ak", "speAk");
		this.hashFields.put("spe_rd", "speRd");
		this.hashFields.put("ow_ind", "owInd");
		this.hashFields.put("ak_exist", "akExist");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spe_dg", "speDg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oh_ind", "ohInd");
		this.hashFields.put("rf_exist", "rfExist");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rf_temp", "rfTemp");
		this.hashFields.put("ol_ind", "olInd");
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
	 * @return speAk
	 */
	public String getSpeAk() {
		return this.speAk;
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
	 * @return akExist
	 */
	public String getAkExist() {
		return this.akExist;
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
	 * @return ohInd
	 */
	public String getOhInd() {
		return this.ohInd;
	}
	
	/**
	 * Column Info
	 * @return rfExist
	 */
	public String getRfExist() {
		return this.rfExist;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @param speAk
	 */
	public void setSpeAk(String speAk) {
		this.speAk = speAk;
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
	 * @param akExist
	 */
	public void setAkExist(String akExist) {
		this.akExist = akExist;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param rfExist
	 */
	public void setRfExist(String rfExist) {
		this.rfExist = rfExist;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
		setSpeAk(JSPUtil.getParameter(request, prefix + "spe_ak", ""));
		setSpeRd(JSPUtil.getParameter(request, prefix + "spe_rd", ""));
		setOwInd(JSPUtil.getParameter(request, prefix + "ow_ind", ""));
		setAkExist(JSPUtil.getParameter(request, prefix + "ak_exist", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpeDg(JSPUtil.getParameter(request, prefix + "spe_dg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOhInd(JSPUtil.getParameter(request, prefix + "oh_ind", ""));
		setRfExist(JSPUtil.getParameter(request, prefix + "rf_exist", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setRfTemp(JSPUtil.getParameter(request, prefix + "rf_temp", ""));
		setOlInd(JSPUtil.getParameter(request, prefix + "ol_ind", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrSpeCgoVO[]
	 */
	public CntrSpeCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrSpeCgoVO[]
	 */
	public CntrSpeCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrSpeCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] speRf = (JSPUtil.getParameter(request, prefix	+ "spe_rf", length));
			String[] speAk = (JSPUtil.getParameter(request, prefix	+ "spe_ak", length));
			String[] speRd = (JSPUtil.getParameter(request, prefix	+ "spe_rd", length));
			String[] owInd = (JSPUtil.getParameter(request, prefix	+ "ow_ind", length));
			String[] akExist = (JSPUtil.getParameter(request, prefix	+ "ak_exist", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] speDg = (JSPUtil.getParameter(request, prefix	+ "spe_dg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ohInd = (JSPUtil.getParameter(request, prefix	+ "oh_ind", length));
			String[] rfExist = (JSPUtil.getParameter(request, prefix	+ "rf_exist", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rfTemp = (JSPUtil.getParameter(request, prefix	+ "rf_temp", length));
			String[] olInd = (JSPUtil.getParameter(request, prefix	+ "ol_ind", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrSpeCgoVO();
				if (speRf[i] != null)
					model.setSpeRf(speRf[i]);
				if (speAk[i] != null)
					model.setSpeAk(speAk[i]);
				if (speRd[i] != null)
					model.setSpeRd(speRd[i]);
				if (owInd[i] != null)
					model.setOwInd(owInd[i]);
				if (akExist[i] != null)
					model.setAkExist(akExist[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (speDg[i] != null)
					model.setSpeDg(speDg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ohInd[i] != null)
					model.setOhInd(ohInd[i]);
				if (rfExist[i] != null)
					model.setRfExist(rfExist[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rfTemp[i] != null)
					model.setRfTemp(rfTemp[i]);
				if (olInd[i] != null)
					model.setOlInd(olInd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrSpeCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrSpeCgoVO[]
	 */
	public CntrSpeCgoVO[] getCntrSpeCgoVOs(){
		CntrSpeCgoVO[] vos = (CntrSpeCgoVO[])models.toArray(new CntrSpeCgoVO[models.size()]);
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
		this.speAk = this.speAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.speRd = this.speRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.owInd = this.owInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akExist = this.akExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.speDg = this.speDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohInd = this.ohInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfExist = this.rfExist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTemp = this.rfTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olInd = this.olInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
