/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaYardCdVO.java
*@FileTitle : PsaYardCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.16
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

public class PsaYardCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaYardCdVO> models = new ArrayList<PsaYardCdVO>();

	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String psaSerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subPsaSerNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String psaIfCd = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaYardCdVO() {}

	public PsaYardCdVO(String ibflag, String pagerows, String psaSerNo, String subPsaSerNo, String psaIfCd, String bkgNo, String bkgSeq, String cntrTpszCd, String cntrQty, String ydCd, String usrId) {
		this.bkgNo = bkgNo;
		this.psaSerNo = psaSerNo;
		this.ibflag = ibflag;
		this.subPsaSerNo = subPsaSerNo;
		this.usrId = usrId;
		this.ydCd = ydCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrQty = cntrQty;
		this.psaIfCd = psaIfCd;
		this.bkgSeq = bkgSeq;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("psa_ser_no", getPsaSerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_psa_ser_no", getSubPsaSerNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("psa_if_cd", getPsaIfCd());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("psa_ser_no", "psaSerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_psa_ser_no", "subPsaSerNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("psa_if_cd", "psaIfCd");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return psaSerNo
	 */
	public String getPsaSerNo() {
		return this.psaSerNo;
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
	 * @return subPsaSerNo
	 */
	public String getSubPsaSerNo() {
		return this.subPsaSerNo;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}

	/**
	 * Column Info
	 * @return psaIfCd
	 */
	public String getPsaIfCd() {
		return this.psaIfCd;
	}

	/**
	 * Column Info
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param psaSerNo
	 */
	public void setPsaSerNo(String psaSerNo) {
		this.psaSerNo = psaSerNo;
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
	 * @param subPsaSerNo
	 */
	public void setSubPsaSerNo(String subPsaSerNo) {
		this.subPsaSerNo = subPsaSerNo;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * Column Info
	 * @param psaIfCd
	 */
	public void setPsaIfCd(String psaIfCd) {
		this.psaIfCd = psaIfCd;
	}

	/**
	 * Column Info
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPsaSerNo(JSPUtil.getParameter(request, prefix + "psa_ser_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubPsaSerNo(JSPUtil.getParameter(request, prefix + "sub_psa_ser_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setPsaIfCd(JSPUtil.getParameter(request, prefix + "psa_if_cd", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaYardCdVO[]
	 */
	public PsaYardCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaYardCdVO[]
	 */
	public PsaYardCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaYardCdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] psaSerNo = (JSPUtil.getParameter(request, prefix	+ "psa_ser_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subPsaSerNo = (JSPUtil.getParameter(request, prefix	+ "sub_psa_ser_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] psaIfCd = (JSPUtil.getParameter(request, prefix	+ "psa_if_cd", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new PsaYardCdVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (psaSerNo[i] != null)
					model.setPsaSerNo(psaSerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subPsaSerNo[i] != null)
					model.setSubPsaSerNo(subPsaSerNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (psaIfCd[i] != null)
					model.setPsaIfCd(psaIfCd[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaYardCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaYardCdVO[]
	 */
	public PsaYardCdVO[] getPsaYardCdVOs(){
		PsaYardCdVO[] vos = (PsaYardCdVO[])models.toArray(new PsaYardCdVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaSerNo = this.psaSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subPsaSerNo = this.subPsaSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaIfCd = this.psaIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
