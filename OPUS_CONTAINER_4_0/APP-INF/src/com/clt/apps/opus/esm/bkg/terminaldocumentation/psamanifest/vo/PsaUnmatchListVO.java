/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsaUnmatchListVO.java
*@FileTitle : PsaUnmatchListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.16
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

public class PsaUnmatchListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaUnmatchListVO> models = new ArrayList<PsaUnmatchListVO>();

	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlyPort = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String transTpCd = null;
	/* Page Number */
	private String pagerows = null;


	private PsaImportVO[] psaImportVOs = null;
	private PsaUnmatchBkgCntrVO[] psaUnmatchBkgCntrVOs = null;
	private PsaUnmatchPsaCntrVO[] psaUnmatchPsaCntrVOs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaUnmatchListVO() {}

	public PsaUnmatchListVO(String ibflag, String pagerows, String vvd, String rlyPort, String etdDt, String transTpCd, String bkgNo, String cntrNo) {
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.rlyPort = rlyPort;
		this.cntrNo = cntrNo;
		this.etdDt = etdDt;
		this.transTpCd = transTpCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rly_port", getRlyPort());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("trans_tp_cd", getTransTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rly_port", "rlyPort");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("trans_tp_cd", "transTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * @return the psaImportVOs
	 */
	public PsaImportVO[] getPsaImportVOs() {
		return psaImportVOs;
	}

	/**
	 * @param psaImportVOs the psaImportVOs to set
	 */
	public void setPsaImportVOs(PsaImportVO[] psaImportVOs) {
		this.psaImportVOs = psaImportVOs;
	}

	/**
	 * @return the psaUnmatchBkgCntrVOs
	 */
	public PsaUnmatchBkgCntrVO[] getPsaUnmatchBkgCntrVOs() {
		return psaUnmatchBkgCntrVOs;
	}

	/**
	 * @param psaUnmatchBkgCntrVOs the psaUnmatchBkgCntrVOs to set
	 */
	public void setPsaUnmatchBkgCntrVOs(PsaUnmatchBkgCntrVO[] psaUnmatchBkgCntrVOs) {
		this.psaUnmatchBkgCntrVOs = psaUnmatchBkgCntrVOs;
	}

	/**
	 * @return the psaUnmatchPsaCntrVOs
	 */
	public PsaUnmatchPsaCntrVO[] getPsaUnmatchPsaCntrVOs() {
		return psaUnmatchPsaCntrVOs;
	}

	/**
	 * @param psaUnmatchPsaCntrVOs the psaUnmatchPsaCntrVOs to set
	 */
	public void setPsaUnmatchPsaCntrVOs(PsaUnmatchPsaCntrVO[] psaUnmatchPsaCntrVOs) {
		this.psaUnmatchPsaCntrVOs = psaUnmatchPsaCntrVOs;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return rlyPort
	 */
	public String getRlyPort() {
		return this.rlyPort;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return transTpCd
	 */
	public String getTransTpCd() {
		return this.transTpCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param rlyPort
	 */
	public void setRlyPort(String rlyPort) {
		this.rlyPort = rlyPort;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param transTpCd
	 */
	public void setTransTpCd(String transTpCd) {
		this.transTpCd = transTpCd;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRlyPort(JSPUtil.getParameter(request, "rly_port", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setTransTpCd(JSPUtil.getParameter(request, "trans_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaUnmatchListVO[]
	 */
	public PsaUnmatchListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaUnmatchListVO[]
	 */
	public PsaUnmatchListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaUnmatchListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlyPort = (JSPUtil.getParameter(request, prefix	+ "rly_port", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] transTpCd = (JSPUtil.getParameter(request, prefix	+ "trans_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new PsaUnmatchListVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlyPort[i] != null)
					model.setRlyPort(rlyPort[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (transTpCd[i] != null)
					model.setTransTpCd(transTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaUnmatchListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaUnmatchListVO[]
	 */
	public PsaUnmatchListVO[] getPsaUnmatchListVOs(){
		PsaUnmatchListVO[] vos = (PsaUnmatchListVO[])models.toArray(new PsaUnmatchListVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPort = this.rlyPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTpCd = this.transTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
