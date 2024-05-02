/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CstmsEmlListVO.java
*@FileTitle : CstmsEmlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier :
*@LastVersion : 1.0
* 2014.11.19
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo;

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

public class CstmsEmlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CstmsEmlListVO> models = new ArrayList<CstmsEmlListVO>();

	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediMsg = null;
	/* Column Info */
	private String toEmlCtnt = null;
	/* Column Info */
	private String ediMsgTpId = null;
	/* Column Info */
	private String ccEmlCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public CstmsEmlListVO() {}

	public CstmsEmlListVO(String ibflag, String pagerows, String ediMsg, String ediMsgTpId, String polCd, String podCd, String toEmlCtnt, String ccEmlCtnt) {
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.ediMsg = ediMsg;
		this.toEmlCtnt = toEmlCtnt;
		this.ediMsgTpId = ediMsgTpId;
		this.ccEmlCtnt = ccEmlCtnt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_msg", getEdiMsg());
		this.hashColumns.put("to_eml_ctnt", getToEmlCtnt());
		this.hashColumns.put("edi_msg_tp_id", getEdiMsgTpId());
		this.hashColumns.put("cc_eml_ctnt", getCcEmlCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_msg", "ediMsg");
		this.hashFields.put("to_eml_ctnt", "toEmlCtnt");
		this.hashFields.put("edi_msg_tp_id", "ediMsgTpId");
		this.hashFields.put("cc_eml_ctnt", "ccEmlCtnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return ediMsg
	 */
	public String getEdiMsg() {
		return this.ediMsg;
	}

	/**
	 * Column Info
	 * @return toEmlCtnt
	 */
	public String getToEmlCtnt() {
		return this.toEmlCtnt;
	}

	/**
	 * Column Info
	 * @return ediMsgTpId
	 */
	public String getEdiMsgTpId() {
		return this.ediMsgTpId;
	}

	/**
	 * Column Info
	 * @return ccEmlCtnt
	 */
	public String getCcEmlCtnt() {
		return this.ccEmlCtnt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param ediMsg
	 */
	public void setEdiMsg(String ediMsg) {
		this.ediMsg = ediMsg;
	}

	/**
	 * Column Info
	 * @param toEmlCtnt
	 */
	public void setToEmlCtnt(String toEmlCtnt) {
		this.toEmlCtnt = toEmlCtnt;
	}

	/**
	 * Column Info
	 * @param ediMsgTpId
	 */
	public void setEdiMsgTpId(String ediMsgTpId) {
		this.ediMsgTpId = ediMsgTpId;
	}

	/**
	 * Column Info
	 * @param ccEmlCtnt
	 */
	public void setCcEmlCtnt(String ccEmlCtnt) {
		this.ccEmlCtnt = ccEmlCtnt;
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
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiMsg(JSPUtil.getParameter(request, prefix + "edi_msg", ""));
		setToEmlCtnt(JSPUtil.getParameter(request, prefix + "to_eml_ctnt", ""));
		setEdiMsgTpId(JSPUtil.getParameter(request, prefix + "edi_msg_tp_id", ""));
		setCcEmlCtnt(JSPUtil.getParameter(request, prefix + "cc_eml_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsEmlListVO[]
	 */
	public CstmsEmlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CstmsEmlListVO[]
	 */
	public CstmsEmlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsEmlListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediMsg = (JSPUtil.getParameter(request, prefix	+ "edi_msg", length));
			String[] toEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "to_eml_ctnt", length));
			String[] ediMsgTpId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_id", length));
			String[] ccEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "cc_eml_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CstmsEmlListVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediMsg[i] != null)
					model.setEdiMsg(ediMsg[i]);
				if (toEmlCtnt[i] != null)
					model.setToEmlCtnt(toEmlCtnt[i]);
				if (ediMsgTpId[i] != null)
					model.setEdiMsgTpId(ediMsgTpId[i]);
				if (ccEmlCtnt[i] != null)
					model.setCcEmlCtnt(ccEmlCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsEmlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsEmlListVO[]
	 */
	public CstmsEmlListVO[] getCstmsEmlListVOs(){
		CstmsEmlListVO[] vos = (CstmsEmlListVO[])models.toArray(new CstmsEmlListVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsg = this.ediMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEmlCtnt = this.toEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpId = this.ediMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccEmlCtnt = this.ccEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
