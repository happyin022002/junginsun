/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsaBkgVO.java
*@FileTitle : PsaBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaBkgVO> models = new ArrayList<PsaBkgVO>();

	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String n3rdPodCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String ackRcvStsCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String n1stShprNm = null;
	/* Column Info */
	private String qtyModifyFlag = null;



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaBkgVO() {}

	public PsaBkgVO(String ibflag, String pagerows, String bkgNo, String bkgSeq, String vvd, String n1stShprNm, String podCd, String n1stPodCd, String n2ndPodCd, String n3rdPodCd, String sndDt, String sndUsrId, String rcvDt, String ackRcvStsCd, String fromDt, String toDt, String status, String qtyModifyFlag) {
		this.n1stPodCd = n1stPodCd;
		this.fromDt = fromDt;
		this.status = status;
		this.n2ndPodCd = n2ndPodCd;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.bkgSeq = bkgSeq;
		this.n3rdPodCd = n3rdPodCd;
		this.toDt = toDt;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.sndUsrId = sndUsrId;
		this.ackRcvStsCd = ackRcvStsCd;
		this.rcvDt = rcvDt;
		this.n1stShprNm = n1stShprNm;
		this.qtyModifyFlag = qtyModifyFlag;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("n3rd_pod_cd", getN3rdPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ack_rcv_sts_cd", getAckRcvStsCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("n1st_shpr_nm", getN1stShprNm());
		this.hashColumns.put("qty_modify_flag", getQtyModifyFlag());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("status", "status");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("n3rd_pod_cd", "n3rdPodCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ack_rcv_sts_cd", "ackRcvStsCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("n1st_shpr_nm", "n1stShprNm");
		this.hashFields.put("qty_modify_flag", "qtyModifyFlag");
//		qtyModifyFlag
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}

	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}

	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Column Info
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
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
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
	}

	/**
	 * Column Info
	 * @return n3rdPodCd
	 */
	public String getN3rdPodCd() {
		return this.n3rdPodCd;
	}

	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}

	/**
	 * Column Info
	 * @return ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return this.ackRcvStsCd;
	}

	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}

	/**
	 * Column Info
	 * @return n1stShprNm
	 */
	public String getN1stShprNm() {
		return this.n1stShprNm;
	}


	/**
	 * Column Info
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Column Info
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
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
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
	}

	/**
	 * Column Info
	 * @param n3rdPodCd
	 */
	public void setN3rdPodCd(String n3rdPodCd) {
		this.n3rdPodCd = n3rdPodCd;
	}

	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}

	/**
	 * Column Info
	 * @param ackRcvStsCd
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
	}

	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}

	/**
	 * Column Info
	 * @param n1stShprNm
	 */
	public void setN1stShprNm(String n1stShprNm) {
		this.n1stShprNm = n1stShprNm;
	}

	public String getQtyModifyFlag() {
		return qtyModifyFlag;
	}

	public void setQtyModifyFlag(String qtyModifyFlag) {
		this.qtyModifyFlag = qtyModifyFlag;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN1stPodCd(JSPUtil.getParameter(request, "n1st_pod_cd", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, "n2nd_pod_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgSeq(JSPUtil.getParameter(request, "bkg_seq", ""));
		setN3rdPodCd(JSPUtil.getParameter(request, "n3rd_pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setAckRcvStsCd(JSPUtil.getParameter(request, "ack_rcv_sts_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setN1stShprNm(JSPUtil.getParameter(request, "n1st_shpr_nm", ""));
		setQtyModifyFlag(JSPUtil.getParameter(request, "qty_modify_flag", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaBkgVO[]
	 */
	public PsaBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaBkgVO[]
	 */
	public PsaBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaBkgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] n3rdPodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ackRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_sts_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] n1stShprNm = (JSPUtil.getParameter(request, prefix	+ "n1st_shpr_nm", length));
			String[] qtyModifyFlag = (JSPUtil.getParameter(request, prefix	+ "qty_modify_flag", length));


			for (int i = 0; i < length; i++) {
				model = new PsaBkgVO();
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (n3rdPodCd[i] != null)
					model.setN3rdPodCd(n3rdPodCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ackRcvStsCd[i] != null)
					model.setAckRcvStsCd(ackRcvStsCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (n1stShprNm[i] != null)
					model.setN1stShprNm(n1stShprNm[i]);
				if (qtyModifyFlag[i] != null)
					model.setQtyModifyFlag(qtyModifyFlag[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaBkgVO[]
	 */
	public PsaBkgVO[] getPsaBkgVOs(){
		PsaBkgVO[] vos = (PsaBkgVO[])models.toArray(new PsaBkgVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodCd = this.n3rdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvStsCd = this.ackRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stShprNm = this.n1stShprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyModifyFlag = this.qtyModifyFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
