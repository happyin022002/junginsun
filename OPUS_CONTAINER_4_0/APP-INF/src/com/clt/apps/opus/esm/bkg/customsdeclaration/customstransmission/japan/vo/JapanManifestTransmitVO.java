/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestTransmitVO.java
*@FileTitle : JapanManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.02
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
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

public class JapanManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private Collection<JapanManifestTransmitVO> models = new ArrayList<JapanManifestTransmitVO>();

	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inCallSgnNo = null;
	/* Column Info */
	private String inCyOprCd = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inVpsEtaDt = null;
	/* Column Info */
	private String blNumber = null;
	/* Column Info */
	private String inMsgFlag = null;
	/* Column Info */
	//private String blNoChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	//private String blNoTp = null;
	/* Column Info */
	private String inMsgTp = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String inVoyageNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanManifestTransmitVO() {}

	//public JapanManifestTransmitVO(String ibflag, String pagerows, String inVvdCd, String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inPodCd, String inPolCd, String inMsgTp, String inMsgFlag, String inCallSgnNo, String inVpsEtaDt, String inCyOprCd, String blNumber, String blNo, String blNoTp, String blNoChk, String blSplitNo) {
	public JapanManifestTransmitVO(String ibflag, String pagerows, String inVvdCd, String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inPodCd, String inPolCd, String inMsgTp, String inMsgFlag, String inCallSgnNo, String inVpsEtaDt, String inCyOprCd, String blNumber, String blNo, String blSplitNo, String inVoyageNo) {
		this.inSkdVoyNo = inSkdVoyNo;
		this.inSkdDirCd = inSkdDirCd;
		this.inCallSgnNo = inCallSgnNo;
		this.inCyOprCd = inCyOprCd;
		this.inVslCd = inVslCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.inVpsEtaDt = inVpsEtaDt;
		this.blNumber = blNumber;
		this.inMsgFlag = inMsgFlag;
		//this.blNoChk = blNoChk;
		this.ibflag = ibflag;
		this.inPolCd = inPolCd;
		this.inVvdCd = inVvdCd;
		//this.blNoTp = blNoTp;
		this.inMsgTp = inMsgTp;
		this.inPodCd = inPodCd;
		this.blSplitNo = blSplitNo;
		this.inVoyageNo = inVoyageNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
		this.hashColumns.put("in_cy_opr_cd", getInCyOprCd());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_vps_eta_dt", getInVpsEtaDt());
		this.hashColumns.put("bl_number", getBlNumber());
		this.hashColumns.put("in_msg_flag", getInMsgFlag());
		//this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		//this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("in_msg_tp", getInMsgTp());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("in_voyage_no", getInVoyageNo());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
		this.hashFields.put("in_cy_opr_cd", "inCyOprCd");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_vps_eta_dt", "inVpsEtaDt");
		this.hashFields.put("bl_number", "blNumber");
		this.hashFields.put("in_msg_flag", "inMsgFlag");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("in_msg_tp", "inMsgTp");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("in_voyage_no", "inVoyageNo");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}

	/**
	 * Column Info
	 * @return inCallSgnNo
	 */
	public String getInCallSgnNo() {
		return this.inCallSgnNo;
	}

	/**
	 * Column Info
	 * @return inCyOprCd
	 */
	public String getInCyOprCd() {
		return this.inCyOprCd;
	}

	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
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
	 * @return inVpsEtaDt
	 */
	public String getInVpsEtaDt() {
		return this.inVpsEtaDt;
	}

	/**
	 * Column Info
	 * @return blNumber
	 */
	public String getBlNumber() {
		return this.blNumber;
	}

	/**
	 * Column Info
	 * @return inMsgFlag
	 */
	public String getInMsgFlag() {
		return this.inMsgFlag;
	}

	/**
	 * Column Info
	 * @return blNoChk
	 */
	//public String getBlNoChk() {
	//	return this.blNoChk;
	//}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return blNoTp
	 */
	//public String getBlNoTp() {
	//	return this.blNoTp;
	//}

	/**
	 * Column Info
	 * @return inMsgTp
	 */
	public String getInMsgTp() {
		return this.inMsgTp;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}

	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
	}


	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}

	/**
	 * Column Info
	 * @param inCallSgnNo
	 */
	public void setInCallSgnNo(String inCallSgnNo) {
		this.inCallSgnNo = inCallSgnNo;
	}

	/**
	 * Column Info
	 * @param inCyOprCd
	 */
	public void setInCyOprCd(String inCyOprCd) {
		this.inCyOprCd = inCyOprCd;
	}

	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
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
	 * Column Info
	 * @param inVpsEtaDt
	 */
	public void setInVpsEtaDt(String inVpsEtaDt) {
		this.inVpsEtaDt = inVpsEtaDt;
	}

	/**
	 * Column Info
	 * @param blNumber
	 */
	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
	}

	/**
	 * Column Info
	 * @param inMsgFlag
	 */
	public void setInMsgFlag(String inMsgFlag) {
		this.inMsgFlag = inMsgFlag;
	}

	/**
	 * Column Info
	 * @param blNoChk
	 */
	//public void setBlNoChk(String blNoChk) {
	//	this.blNoChk = blNoChk;
	//}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param blNoTp
	 */
	//public void setBlNoTp(String blNoTp) {
	//	this.blNoTp = blNoTp;
	//}

	/**
	 * Column Info
	 * @param inMsgTp
	 */
	public void setInMsgTp(String inMsgTp) {
		this.inMsgTp = inMsgTp;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
	}

	public String getInVoyageNo() {
		return inVoyageNo;
	}

	public void setInVoyageNo(String inVoyageNo) {
		this.inVoyageNo = inVoyageNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInSkdVoyNo(JSPUtil.getParameter(request, "in_skd_voy_no", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, "in_skd_dir_cd", ""));
		setInCallSgnNo(JSPUtil.getParameter(request, "in_call_sgn_no", ""));
		setInCyOprCd(JSPUtil.getParameter(request, "in_cy_opr_cd", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInVpsEtaDt(JSPUtil.getParameter(request, "in_vps_eta_dt", ""));
		setBlNumber(JSPUtil.getParameter(request, "bl_number", ""));
		setInMsgFlag(JSPUtil.getParameter(request, "in_msg_flag", ""));
		//setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		//setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setInMsgTp(JSPUtil.getParameter(request, "in_msg_tp", ""));
		setInPodCd(JSPUtil.getParameter(request, "in_pod_cd", ""));
		setBlSplitNo(JSPUtil.getParameter(request, "bl_split_no", ""));
		setInVoyageNo(JSPUtil.getParameter(request, "in_voyage_no", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestTransmitVO[]
	 */
	public JapanManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanManifestTransmitVO[]
	 */
	public JapanManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestTransmitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no".trim(), length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd".trim(), length));
			String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "in_call_sgn_no".trim(), length));
			String[] inCyOprCd = (JSPUtil.getParameter(request, prefix	+ "in_cy_opr_cd".trim(), length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] inVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "in_vps_eta_dt".trim(), length));
			String[] blNumber = (JSPUtil.getParameter(request, prefix	+ "bl_number".trim(), length));
			String[] inMsgFlag = (JSPUtil.getParameter(request, prefix	+ "in_msg_flag".trim(), length));
			//String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd".trim(), length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd".trim(), length));
			//String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));
			String[] inMsgTp = (JSPUtil.getParameter(request, prefix	+ "in_msg_tp".trim(), length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd".trim(), length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no".trim(), length));
			String[] inVoyageNo = (JSPUtil.getParameter(request, prefix	+ "in_voyage_no".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new JapanManifestTransmitVO();
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inCallSgnNo[i] != null)
					model.setInCallSgnNo(inCallSgnNo[i]);
				if (inCyOprCd[i] != null)
					model.setInCyOprCd(inCyOprCd[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inVpsEtaDt[i] != null)
					model.setInVpsEtaDt(inVpsEtaDt[i]);
				if (blNumber[i] != null)
					model.setBlNumber(blNumber[i]);
				if (inMsgFlag[i] != null)
					model.setInMsgFlag(inMsgFlag[i]);
				//if (blNoChk[i] != null)
				//	model.setBlNoChk(blNoChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				//if (blNoTp[i] != null)
				//	model.setBlNoTp(blNoTp[i]);
				if (inMsgTp[i] != null)
					model.setInMsgTp(inMsgTp[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (inVoyageNo[i] != null)
					model.setInVoyageNo(inVoyageNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestTransmitVO[]
	 */
	public JapanManifestTransmitVO[] getJapanManifestTransmitVOs(){
		JapanManifestTransmitVO[] vos = (JapanManifestTransmitVO[])models.toArray(new JapanManifestTransmitVO[models.size()]);
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
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCallSgnNo = this.inCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCyOprCd = this.inCyOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVpsEtaDt = this.inVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNumber = this.blNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMsgFlag = this.inMsgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMsgTp = this.inMsgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVoyageNo = this.inVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
