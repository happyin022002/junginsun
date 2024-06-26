/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListReceiveHistDetailVO.java
*@FileTitle : JapanManifestListReceiveHistDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.07
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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

public class JapanManifestListReceiveHistDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<JapanManifestListReceiveHistDetailVO> models = new ArrayList<JapanManifestListReceiveHistDetailVO>();

	/* Column Info */
	private String total = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String jpSvcCd = null;
	/* Column Info */
	private String jpBatNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rcvDt2 = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jpMsgTpCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String rcvKeyDatCtnt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanManifestListReceiveHistDetailVO() {}

	public JapanManifestListReceiveHistDetailVO(String ibflag, String pagerows, String jpMsgTpCd, String rcvDt, String rcvDt2, String rcvSeq, String jpSvcCd, String rcvKeyDatCtnt, String jpBatNo, String updUsrId, String vslCd, String skdVoyNo, String skdDirCd, String podCd, String rn, String total) {
		this.total = total;
		this.vslCd = vslCd;
		this.rn = rn;
		this.jpSvcCd = jpSvcCd;
		this.jpBatNo = jpBatNo;
		this.skdVoyNo = skdVoyNo;
		this.rcvDt2 = rcvDt2;
		this.rcvSeq = rcvSeq;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.jpMsgTpCd = jpMsgTpCd;
		this.rcvDt = rcvDt;
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("jp_svc_cd", getJpSvcCd());
		this.hashColumns.put("jp_bat_no", getJpBatNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rcv_dt2", getRcvDt2());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jp_msg_tp_cd", getJpMsgTpCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("rcv_key_dat_ctnt", getRcvKeyDatCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("jp_svc_cd", "jpSvcCd");
		this.hashFields.put("jp_bat_no", "jpBatNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rcv_dt2", "rcvDt2");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jp_msg_tp_cd", "jpMsgTpCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("rcv_key_dat_ctnt", "rcvKeyDatCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return jpSvcCd
	 */
	public String getJpSvcCd() {
		return this.jpSvcCd;
	}

	/**
	 * Column Info
	 * @return jpBatNo
	 */
	public String getJpBatNo() {
		return this.jpBatNo;
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
	 * @return rcvDt2
	 */
	public String getRcvDt2() {
		return this.rcvDt2;
	}

	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
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
	 * @return jpMsgTpCd
	 */
	public String getJpMsgTpCd() {
		return this.jpMsgTpCd;
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
	 * @return rcvKeyDatCtnt
	 */
	public String getRcvKeyDatCtnt() {
		return this.rcvKeyDatCtnt;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param jpSvcCd
	 */
	public void setJpSvcCd(String jpSvcCd) {
		this.jpSvcCd = jpSvcCd;
	}

	/**
	 * Column Info
	 * @param jpBatNo
	 */
	public void setJpBatNo(String jpBatNo) {
		this.jpBatNo = jpBatNo;
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
	 * @param rcvDt2
	 */
	public void setRcvDt2(String rcvDt2) {
		this.rcvDt2 = rcvDt2;
	}

	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
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
	 * @param jpMsgTpCd
	 */
	public void setJpMsgTpCd(String jpMsgTpCd) {
		this.jpMsgTpCd = jpMsgTpCd;
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
	 * @param rcvKeyDatCtnt
	 */
	public void setRcvKeyDatCtnt(String rcvKeyDatCtnt) {
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setJpSvcCd(JSPUtil.getParameter(request, "jp_svc_cd", ""));
		setJpBatNo(JSPUtil.getParameter(request, "jp_bat_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRcvDt2(JSPUtil.getParameter(request, "rcv_dt2", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setJpMsgTpCd(JSPUtil.getParameter(request, "jp_msg_tp_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setRcvKeyDatCtnt(JSPUtil.getParameter(request, "rcv_key_dat_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListReceiveHistDetailVO[]
	 */
	public JapanManifestListReceiveHistDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanManifestListReceiveHistDetailVO[]
	 */
	public JapanManifestListReceiveHistDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListReceiveHistDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] jpSvcCd = (JSPUtil.getParameter(request, prefix	+ "jp_svc_cd", length));
			String[] jpBatNo = (JSPUtil.getParameter(request, prefix	+ "jp_bat_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rcvDt2 = (JSPUtil.getParameter(request, prefix	+ "rcv_dt2", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jpMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "jp_msg_tp_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] rcvKeyDatCtnt = (JSPUtil.getParameter(request, prefix	+ "rcv_key_dat_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new JapanManifestListReceiveHistDetailVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (jpSvcCd[i] != null)
					model.setJpSvcCd(jpSvcCd[i]);
				if (jpBatNo[i] != null)
					model.setJpBatNo(jpBatNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rcvDt2[i] != null)
					model.setRcvDt2(rcvDt2[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jpMsgTpCd[i] != null)
					model.setJpMsgTpCd(jpMsgTpCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (rcvKeyDatCtnt[i] != null)
					model.setRcvKeyDatCtnt(rcvKeyDatCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListReceiveHistDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListReceiveHistDetailVO[]
	 */
	public JapanManifestListReceiveHistDetailVO[] getJapanManifestListReceiveHistDetailVOs(){
		JapanManifestListReceiveHistDetailVO[] vos = (JapanManifestListReceiveHistDetailVO[])models.toArray(new JapanManifestListReceiveHistDetailVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpSvcCd = this.jpSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpBatNo = this.jpBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt2 = this.rcvDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpMsgTpCd = this.jpMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvKeyDatCtnt = this.rcvKeyDatCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
