/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorIftsaiVslVO.java
*@FileTitle : KorIftsaiVslVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.30 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorIftsaiVslVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorIftsaiVslVO> models = new ArrayList<KorIftsaiVslVO>();

	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String laneNm = null;
	/* Column Info */
	private String sendCnt = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String vpsCallInd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String callSg = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorIftsaiVslVO() {}

	public KorIftsaiVslVO(String ibflag, String pagerows, String callSg, String laneNm, String sendCnt, String callSeq, String vslNm, String remark, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String vpsCallInd) {
		this.vslCd = vslCd;
		this.laneNm = laneNm;
		this.sendCnt = sendCnt;
		this.remark = remark;
		this.callSeq = callSeq;
		this.vpsCallInd = vpsCallInd;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.callSg = callSg;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("lane_nm", getLaneNm());
		this.hashColumns.put("send_cnt", getSendCnt());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("vps_call_ind", getVpsCallInd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("call_sg", getCallSg());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("lane_nm", "laneNm");
		this.hashFields.put("send_cnt", "sendCnt");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("vps_call_ind", "vpsCallInd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("call_sg", "callSg");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * @return laneNm
	 */
	public String getLaneNm() {
		return this.laneNm;
	}

	/**
	 * Column Info
	 * @return sendCnt
	 */
	public String getSendCnt() {
		return this.sendCnt;
	}

	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * Column Info
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
	}

	/**
	 * Column Info
	 * @return vpsCallInd
	 */
	public String getVpsCallInd() {
		return this.vpsCallInd;
	}

	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}

	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return callSg
	 */
	public String getCallSg() {
		return this.callSg;
	}

	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * @param laneNm
	 */
	public void setLaneNm(String laneNm) {
		this.laneNm = laneNm;
	}

	/**
	 * Column Info
	 * @param sendCnt
	 */
	public void setSendCnt(String sendCnt) {
		this.sendCnt = sendCnt;
	}

	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Column Info
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
	}

	/**
	 * Column Info
	 * @param vpsCallInd
	 */
	public void setVpsCallInd(String vpsCallInd) {
		this.vpsCallInd = vpsCallInd;
	}

	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}

	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param callSg
	 */
	public void setCallSg(String callSg) {
		this.callSg = callSg;
	}

	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLaneNm(JSPUtil.getParameter(request, prefix + "lane_nm", ""));
		setSendCnt(JSPUtil.getParameter(request, prefix + "send_cnt", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setCallSeq(JSPUtil.getParameter(request, prefix + "call_seq", ""));
		setVpsCallInd(JSPUtil.getParameter(request, prefix + "vps_call_ind", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCallSg(JSPUtil.getParameter(request, prefix + "call_sg", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorIftsaiVslVO[]
	 */
	public KorIftsaiVslVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorIftsaiVslVO[]
	 */
	public KorIftsaiVslVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorIftsaiVslVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] laneNm = (JSPUtil.getParameter(request, prefix	+ "lane_nm", length));
			String[] sendCnt = (JSPUtil.getParameter(request, prefix	+ "send_cnt", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] vpsCallInd = (JSPUtil.getParameter(request, prefix	+ "vps_call_ind", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] callSg = (JSPUtil.getParameter(request, prefix	+ "call_sg", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));

			for (int i = 0; i < length; i++) {
				model = new KorIftsaiVslVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (laneNm[i] != null)
					model.setLaneNm(laneNm[i]);
				if (sendCnt[i] != null)
					model.setSendCnt(sendCnt[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (vpsCallInd[i] != null)
					model.setVpsCallInd(vpsCallInd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (callSg[i] != null)
					model.setCallSg(callSg[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorIftsaiVslVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorIftsaiVslVO[]
	 */
	public KorIftsaiVslVO[] getKorIftsaiVslVOs(){
		KorIftsaiVslVO[] vos = (KorIftsaiVslVO[])models.toArray(new KorIftsaiVslVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneNm = this.laneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendCnt = this.sendCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsCallInd = this.vpsCallInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSg = this.callSg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
