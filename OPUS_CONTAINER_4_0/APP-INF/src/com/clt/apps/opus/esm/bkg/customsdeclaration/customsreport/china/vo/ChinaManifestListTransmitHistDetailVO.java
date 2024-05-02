/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaManifestListTransmitHistDetailVO.java
*@FileTitle : ChinaManifestListTransmitHistDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.26
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.12.26 박성진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaManifestListTransmitHistDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaManifestListTransmitHistDetailVO> models = new ArrayList<ChinaManifestListTransmitHistDetailVO>();

	/* Column Info */
	private String total = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String ackDt = null;
	/* Column Info */
	private String upDt = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String ackCont = null;
	/* Column Info */
	private String ediRefId = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ackTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String sendIndicator = null;
	/* Column Info */
	private String sendIndicatorNm = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaManifestListTransmitHistDetailVO() {}

	public ChinaManifestListTransmitHistDetailVO(String ibflag, String pagerows, String total, String rn, String ackDt, String upDt, String sndOfcCd, String ackCont, String ediRefId, String sndDt, String podCd, String sndUsrId, String polCd, String ackTp, String vvdCd, String sendIndicator, String sendIndicatorNm, String rhq) {
		this.total = total;
		this.rn = rn;
		this.ackDt = ackDt;
		this.upDt = upDt;
		this.sndOfcCd = sndOfcCd;
		this.ackCont = ackCont;
		this.ediRefId = ediRefId;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ackTp = ackTp;
		this.ibflag = ibflag;
		this.sndUsrId = sndUsrId;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.sendIndicator = sendIndicator;
		this.sendIndicatorNm = sendIndicatorNm;
		this.rhq = rhq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("ack_dt", getAckDt());
		this.hashColumns.put("up_dt", getUpDt());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("ack_cont", getAckCont());
		this.hashColumns.put("edi_ref_id", getEdiRefId());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ack_tp", getAckTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("send_indicator", getSendIndicator());
		this.hashColumns.put("send_indicator_nm", getSendIndicatorNm());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("ack_dt", "ackDt");
		this.hashFields.put("up_dt", "upDt");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("ack_cont", "ackCont");
		this.hashFields.put("edi_ref_id", "ediRefId");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ack_tp", "ackTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("send_indicator", "sendIndicator");
		this.hashFields.put("send_indicator_nm", "sendIndicatorNm");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}

	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}

	/**
	 * Column Info
	 * @return ackDt
	 */
	public String getAckDt() {
		return this.ackDt;
	}

	/**
	 * Column Info
	 * @return upDt
	 */
	public String getUpDt() {
		return this.upDt;
	}

	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}

	/**
	 * Column Info
	 * @return ackCont
	 */
	public String getAckCont() {
		return this.ackCont;
	}

	/**
	 * Column Info
	 * @return ediRefId
	 */
	public String getEdiRefId() {
		return this.ediRefId;
	}

	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return ackTp
	 */
	public String getAckTp() {
		return this.ackTp;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return sendIndicator
	 */
	public String getSendIndicator() {
		return this.sendIndicator;
	}

	/**
	 * Column Info
	 * @return sendIndicatorNm
	 */
	public String getSendIndicatorNm() {
		return this.sendIndicatorNm;
	}

	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}


	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}

	/**
	 * Column Info
	 * @param ackDt
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}

	/**
	 * Column Info
	 * @param upDt
	 */
	public void setUpDt(String upDt) {
		this.upDt = upDt;
	}

	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}

	/**
	 * Column Info
	 * @param ackCont
	 */
	public void setAckCont(String ackCont) {
		this.ackCont = ackCont;
	}

	/**
	 * Column Info
	 * @param ediRefId
	 */
	public void setEdiRefId(String ediRefId) {
		this.ediRefId = ediRefId;
	}

	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param ackTp
	 */
	public void setAckTp(String ackTp) {
		this.ackTp = ackTp;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param sendIndicator
	 */
	public void setSendIndicator(String sendIndicator) {
		this.sendIndicator = sendIndicator;
	}

	/**
	 * Column Info
	 * @param sendIndicatorNm
	 */
	public void setSendIndicatorNm(String sendIndicatorNm) {
		this.sendIndicatorNm = sendIndicatorNm;
	}

	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setAckDt(JSPUtil.getParameter(request, prefix + "ack_dt", ""));
		setUpDt(JSPUtil.getParameter(request, prefix + "up_dt", ""));
		setSndOfcCd(JSPUtil.getParameter(request, prefix + "snd_ofc_cd", ""));
		setAckCont(JSPUtil.getParameter(request, prefix + "ack_cont", ""));
		setEdiRefId(JSPUtil.getParameter(request, prefix + "edi_ref_id", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setAckTp(JSPUtil.getParameter(request, prefix + "ack_tp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setSendIndicator(JSPUtil.getParameter(request, prefix + "send_indicator", ""));
		setSendIndicatorNm(JSPUtil.getParameter(request, prefix + "send_indicator_nm", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaManifestListTransmitHistDetailVO[]
	 */
	public ChinaManifestListTransmitHistDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaManifestListTransmitHistDetailVO[]
	 */
	public ChinaManifestListTransmitHistDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaManifestListTransmitHistDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] ackDt = (JSPUtil.getParameter(request, prefix	+ "ack_dt", length));
			String[] upDt = (JSPUtil.getParameter(request, prefix	+ "up_dt", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] ackCont = (JSPUtil.getParameter(request, prefix	+ "ack_cont", length));
			String[] ediRefId = (JSPUtil.getParameter(request, prefix	+ "edi_ref_id", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ackTp = (JSPUtil.getParameter(request, prefix	+ "ack_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] sendIndicator = (JSPUtil.getParameter(request, prefix	+ "send_indicator", length));
			String[] sendIndicatorNm = (JSPUtil.getParameter(request, prefix	+ "send_indicator_nm", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaManifestListTransmitHistDetailVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (ackDt[i] != null)
					model.setAckDt(ackDt[i]);
				if (upDt[i] != null)
					model.setUpDt(upDt[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (ackCont[i] != null)
					model.setAckCont(ackCont[i]);
				if (ediRefId[i] != null)
					model.setEdiRefId(ediRefId[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ackTp[i] != null)
					model.setAckTp(ackTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (sendIndicator[i] != null)
					model.setSendIndicator(sendIndicator[i]);
				if (sendIndicatorNm[i] != null)
					model.setSendIndicatorNm(sendIndicatorNm[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaManifestListTransmitHistDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaManifestListTransmitHistDetailVO[]
	 */
	public ChinaManifestListTransmitHistDetailVO[] getChinaManifestListTransmitHistDetailVOs(){
		ChinaManifestListTransmitHistDetailVO[] vos = (ChinaManifestListTransmitHistDetailVO[])models.toArray(new ChinaManifestListTransmitHistDetailVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDt = this.ackDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upDt = this.upDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackCont = this.ackCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRefId = this.ediRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackTp = this.ackTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendIndicator = this.sendIndicator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendIndicatorNm = this.sendIndicatorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
