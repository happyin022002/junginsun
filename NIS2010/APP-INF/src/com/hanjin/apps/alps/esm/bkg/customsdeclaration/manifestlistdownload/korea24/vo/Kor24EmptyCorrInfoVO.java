/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24EmptyCorrInfoVO.java
*@FileTitle : Kor24EmptyCorrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.13 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

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

public class Kor24EmptyCorrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24EmptyCorrInfoVO> models = new ArrayList<Kor24EmptyCorrInfoVO>();

	/* Column Info */
	private String corrReason = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsBlNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String corrCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String cltSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24EmptyCorrInfoVO() {}

	public Kor24EmptyCorrInfoVO(String ibflag, String pagerows, String subNo, String bkgNo, String blNo, String corrCd, String corrReason, String usrId, String cltSeq, String portCd, String vvdCd, String cstmsBlNo) {
		this.corrReason = corrReason;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cstmsBlNo = cstmsBlNo;
		this.vvdCd = vvdCd;
		this.subNo = subNo;
		this.usrId = usrId;
		this.corrCd = corrCd;
		this.portCd = portCd;
		this.cltSeq = cltSeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_reason", getCorrReason());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_bl_no", getCstmsBlNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("corr_cd", getCorrCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("clt_seq", getCltSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_reason", "corrReason");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_bl_no", "cstmsBlNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("corr_cd", "corrCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("clt_seq", "cltSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return corrReason
	 */
	public String getCorrReason() {
		return this.corrReason;
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
	 * @return cstmsBlNo
	 */
	public String getCstmsBlNo() {
		return this.cstmsBlNo;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return subNo
	 */
	public String getSubNo() {
		return this.subNo;
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
	 * @return corrCd
	 */
	public String getCorrCd() {
		return this.corrCd;
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
	 * @return cltSeq
	 */
	public String getCltSeq() {
		return this.cltSeq;
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
	 * Column Info
	 * @param corrReason
	 */
	public void setCorrReason(String corrReason) {
		this.corrReason = corrReason;
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
	 * @param cstmsBlNo
	 */
	public void setCstmsBlNo(String cstmsBlNo) {
		this.cstmsBlNo = cstmsBlNo;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param subNo
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo;
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
	 * @param corrCd
	 */
	public void setCorrCd(String corrCd) {
		this.corrCd = corrCd;
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
	 * @param cltSeq
	 */
	public void setCltSeq(String cltSeq) {
		this.cltSeq = cltSeq;
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
		setCorrReason(JSPUtil.getParameter(request, prefix + "corr_reason", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCstmsBlNo(JSPUtil.getParameter(request, prefix + "cstms_bl_no", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setSubNo(JSPUtil.getParameter(request, prefix + "sub_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCorrCd(JSPUtil.getParameter(request, prefix + "corr_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCltSeq(JSPUtil.getParameter(request, prefix + "clt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24EmptyCorrInfoVO[]
	 */
	public Kor24EmptyCorrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24EmptyCorrInfoVO[]
	 */
	public Kor24EmptyCorrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24EmptyCorrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] corrReason = (JSPUtil.getParameter(request, prefix	+ "corr_reason", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsBlNo = (JSPUtil.getParameter(request, prefix	+ "cstms_bl_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] corrCd = (JSPUtil.getParameter(request, prefix	+ "corr_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cltSeq = (JSPUtil.getParameter(request, prefix	+ "clt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24EmptyCorrInfoVO();
				if (corrReason[i] != null)
					model.setCorrReason(corrReason[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsBlNo[i] != null)
					model.setCstmsBlNo(cstmsBlNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (corrCd[i] != null)
					model.setCorrCd(corrCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cltSeq[i] != null)
					model.setCltSeq(cltSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24EmptyCorrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24EmptyCorrInfoVO[]
	 */
	public Kor24EmptyCorrInfoVO[] getKor24EmptyCorrInfoVOs(){
		Kor24EmptyCorrInfoVO[] vos = (Kor24EmptyCorrInfoVO[])models.toArray(new Kor24EmptyCorrInfoVO[models.size()]);
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
		this.corrReason = this.corrReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsBlNo = this.cstmsBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrCd = this.corrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltSeq = this.cltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
