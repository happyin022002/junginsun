/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsaUnmatchBKGVO.java
*@FileTitle : PsaUnmatchBKGVO
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

public class PsaUnmatchBKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaUnmatchBKGVO> models = new ArrayList<PsaUnmatchBKGVO>();

	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String transTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rlyPort = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaUnmatchBKGVO() {}

	public PsaUnmatchBKGVO(String ibflag, String pagerows, String bkgNo, String cntrTpCd, String cntrSzCd, String stwgCd, String portCd, String special, String imdgClssCd, String vvd, String transTpCd, String rlyPort, String cntrNo) {
		this.cntrSzCd = cntrSzCd;
		this.transTpCd = transTpCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rlyPort = rlyPort;
		this.cntrTpCd = cntrTpCd;
		this.cntrNo = cntrNo;
		this.stwgCd = stwgCd;
		this.special = special;
		this.portCd = portCd;
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("trans_tp_cd", getTransTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rly_port", getRlyPort());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("trans_tp_cd", "transTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rly_port", "rlyPort");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("special", "special");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return rlyPort
	 */
	public String getRlyPort() {
		return this.rlyPort;
	}

	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
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
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}

	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
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
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param rlyPort
	 */
	public void setRlyPort(String rlyPort) {
		this.rlyPort = rlyPort;
	}

	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
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
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}

	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
		setTransTpCd(JSPUtil.getParameter(request, "trans_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRlyPort(JSPUtil.getParameter(request, "rly_port", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntr_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setStwgCd(JSPUtil.getParameter(request, "stwg_cd", ""));
		setSpecial(JSPUtil.getParameter(request, "special", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaUnmatchBKGVO[]
	 */
	public PsaUnmatchBKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaUnmatchBKGVO[]
	 */
	public PsaUnmatchBKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaUnmatchBKGVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] transTpCd = (JSPUtil.getParameter(request, prefix	+ "trans_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rlyPort = (JSPUtil.getParameter(request, prefix	+ "rly_port", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));

			for (int i = 0; i < length; i++) {
				model = new PsaUnmatchBKGVO();
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (transTpCd[i] != null)
					model.setTransTpCd(transTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rlyPort[i] != null)
					model.setRlyPort(rlyPort[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaUnmatchBKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaUnmatchBKGVO[]
	 */
	public PsaUnmatchBKGVO[] getPsaUnmatchBKGVOs(){
		PsaUnmatchBKGVO[] vos = (PsaUnmatchBKGVO[])models.toArray(new PsaUnmatchBKGVO[models.size()]);
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
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTpCd = this.transTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPort = this.rlyPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
