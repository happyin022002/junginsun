/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsRcvHisListCondVO.java
*@FileTitle : CndCstmsRcvHisListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.11.24 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsRcvHisListCondVO extends CstmsRcvHisListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsRcvHisListCondVO> models = new ArrayList<CndCstmsRcvHisListCondVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String eRcvDt = null;
	/* Column Info */
	private String sRcvDt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String eRcvTm = null;
	/* Column Info */
	private String sRcvTm = null;
	/* Column Info */
	private String rcvMsgTpId = null;
	/* Column Info */
	private String rcvDtFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsRcvHisListCondVO() {}

	public CndCstmsRcvHisListCondVO(String ibflag, String pagerows, String polCd, String vvdCd, String rcvMsgTpId, String rcvDtFlg, String sRcvDt, String eRcvDt, String podCd, String blNo, String sRcvTm, String eRcvTm) {
		this.podCd = podCd;
		this.eRcvDt = eRcvDt;
		this.sRcvDt = sRcvDt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.eRcvTm = eRcvTm;
		this.sRcvTm = sRcvTm;
		this.rcvMsgTpId = rcvMsgTpId;
		this.rcvDtFlg = rcvDtFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("e_rcv_dt", getERcvDt());
		this.hashColumns.put("s_rcv_dt", getSRcvDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("e_rcv_tm", getERcvTm());
		this.hashColumns.put("s_rcv_tm", getSRcvTm());
		this.hashColumns.put("rcv_msg_tp_id", getRcvMsgTpId());
		this.hashColumns.put("rcv_dt_flg", getRcvDtFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("e_rcv_dt", "eRcvDt");
		this.hashFields.put("s_rcv_dt", "sRcvDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("e_rcv_tm", "eRcvTm");
		this.hashFields.put("s_rcv_tm", "sRcvTm");
		this.hashFields.put("rcv_msg_tp_id", "rcvMsgTpId");
		this.hashFields.put("rcv_dt_flg", "rcvDtFlg");
		this.hashFields.put("bl_no", "blNo");
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
	 * @return eRcvDt
	 */
	public String getERcvDt() {
		return this.eRcvDt;
	}
	
	/**
	 * Column Info
	 * @return sRcvDt
	 */
	public String getSRcvDt() {
		return this.sRcvDt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return eRcvTm
	 */
	public String getERcvTm() {
		return this.eRcvTm;
	}
	
	/**
	 * Column Info
	 * @return sRcvTm
	 */
	public String getSRcvTm() {
		return this.sRcvTm;
	}
	
	/**
	 * Column Info
	 * @return rcvMsgTpId
	 */
	public String getRcvMsgTpId() {
		return this.rcvMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return rcvDtFlg
	 */
	public String getRcvDtFlg() {
		return this.rcvDtFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param eRcvDt
	 */
	public void setERcvDt(String eRcvDt) {
		this.eRcvDt = eRcvDt;
	}
	
	/**
	 * Column Info
	 * @param sRcvDt
	 */
	public void setSRcvDt(String sRcvDt) {
		this.sRcvDt = sRcvDt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param eRcvTm
	 */
	public void setERcvTm(String eRcvTm) {
		this.eRcvTm = eRcvTm;
	}
	
	/**
	 * Column Info
	 * @param sRcvTm
	 */
	public void setSRcvTm(String sRcvTm) {
		this.sRcvTm = sRcvTm;
	}
	
	/**
	 * Column Info
	 * @param rcvMsgTpId
	 */
	public void setRcvMsgTpId(String rcvMsgTpId) {
		this.rcvMsgTpId = rcvMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param rcvDtFlg
	 */
	public void setRcvDtFlg(String rcvDtFlg) {
		this.rcvDtFlg = rcvDtFlg;
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
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setERcvDt(JSPUtil.getParameter(request, "e_rcv_dt", ""));
		setSRcvDt(JSPUtil.getParameter(request, "s_rcv_dt", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setERcvTm(JSPUtil.getParameter(request, "e_rcv_tm", ""));
		setSRcvTm(JSPUtil.getParameter(request, "s_rcv_tm", ""));
		setRcvMsgTpId(JSPUtil.getParameter(request, "rcv_msg_tp_id", ""));
		setRcvDtFlg(JSPUtil.getParameter(request, "rcv_dt_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsRcvHisListCondVO[]
	 */
	public CndCstmsRcvHisListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsRcvHisListCondVO[]
	 */
	public CndCstmsRcvHisListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsRcvHisListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] eRcvDt = (JSPUtil.getParameter(request, prefix	+ "e_rcv_dt", length));
			String[] sRcvDt = (JSPUtil.getParameter(request, prefix	+ "s_rcv_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] eRcvTm = (JSPUtil.getParameter(request, prefix	+ "e_rcv_tm", length));
			String[] sRcvTm = (JSPUtil.getParameter(request, prefix	+ "s_rcv_tm", length));
			String[] rcvMsgTpId = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_tp_id", length));
			String[] rcvDtFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_dt_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsRcvHisListCondVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (eRcvDt[i] != null)
					model.setERcvDt(eRcvDt[i]);
				if (sRcvDt[i] != null)
					model.setSRcvDt(sRcvDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (eRcvTm[i] != null)
					model.setERcvTm(eRcvTm[i]);
				if (sRcvTm[i] != null)
					model.setSRcvTm(sRcvTm[i]);
				if (rcvMsgTpId[i] != null)
					model.setRcvMsgTpId(rcvMsgTpId[i]);
				if (rcvDtFlg[i] != null)
					model.setRcvDtFlg(rcvDtFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsRcvHisListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsRcvHisListCondVO[]
	 */
	public CndCstmsRcvHisListCondVO[] getCndCstmsRcvHisListCondVOs(){
		CndCstmsRcvHisListCondVO[] vos = (CndCstmsRcvHisListCondVO[])models.toArray(new CndCstmsRcvHisListCondVO[models.size()]);
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
		this.eRcvDt = this.eRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRcvDt = this.sRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eRcvTm = this.eRcvTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRcvTm = this.sRcvTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgTpId = this.rcvMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDtFlg = this.rcvDtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
