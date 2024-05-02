/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgListForUsaTmlEdiVO.java
*@FileTitle : BkgListForUsaTmlEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.10.05 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForUsaTmlEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForUsaTmlEdiVO> models = new ArrayList<BkgListForUsaTmlEdiVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String sp = null;
	/* Column Info */
	private String ack = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bkgDate = null;
	/* Column Info */
	private String tmlErrMsg = null;
	/* Column Info */
	private String ackDate = null;
	/* Column Info */
	private String vvdHistory = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String sendDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String sendUsrNm = null;
	/* Column Info */
	private String fM = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String sendUsrId = null;
	/* Column Info */
	private String fH = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgListForUsaTmlEdiVO() {}

	public BkgListForUsaTmlEdiVO(String ibflag, String pagerows, String bkgNo, String bkgStsCd, String fM, String sp, String tVvd, String vvdHistory, String etb, String lane, String polCd, String ydCd, String bkgDate, String ack, String sendDate, String ackDate, String sendUsrId, String sendUsrNm, String tmlErrMsg, String fH) {
		this.etb = etb;
		this.sp = sp;
		this.ack = ack;
		this.bkgStsCd = bkgStsCd;
		this.bkgDate = bkgDate;
		this.tmlErrMsg = tmlErrMsg;
		this.ackDate = ackDate;
		this.vvdHistory = vvdHistory;
		this.pagerows = pagerows;
		this.lane = lane;
		this.sendDate = sendDate;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.tVvd = tVvd;
		this.sendUsrNm = sendUsrNm;
		this.fM = fM;
		this.ydCd = ydCd;
		this.sendUsrId = sendUsrId;
		this.fH = fH;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("sp", getSp());
		this.hashColumns.put("ack", getAck());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bkg_date", getBkgDate());
		this.hashColumns.put("tml_err_msg", getTmlErrMsg());
		this.hashColumns.put("ack_date", getAckDate());
		this.hashColumns.put("vvd_history", getVvdHistory());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("send_date", getSendDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("send_usr_nm", getSendUsrNm());
		this.hashColumns.put("f_m", getFM());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("send_usr_id", getSendUsrId());
		this.hashColumns.put("f_h", getFH());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("sp", "sp");
		this.hashFields.put("ack", "ack");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bkg_date", "bkgDate");
		this.hashFields.put("tml_err_msg", "tmlErrMsg");
		this.hashFields.put("ack_date", "ackDate");
		this.hashFields.put("vvd_history", "vvdHistory");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("send_date", "sendDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("send_usr_nm", "sendUsrNm");
		this.hashFields.put("f_m", "fM");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("send_usr_id", "sendUsrId");
		this.hashFields.put("f_h", "fH");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return sp
	 */
	public String getSp() {
		return this.sp;
	}
	
	/**
	 * Column Info
	 * @return ack
	 */
	public String getAck() {
		return this.ack;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDate
	 */
	public String getBkgDate() {
		return this.bkgDate;
	}
	
	/**
	 * Column Info
	 * @return tmlErrMsg
	 */
	public String getTmlErrMsg() {
		return this.tmlErrMsg;
	}
	
	/**
	 * Column Info
	 * @return ackDate
	 */
	public String getAckDate() {
		return this.ackDate;
	}
	
	/**
	 * Column Info
	 * @return vvdHistory
	 */
	public String getVvdHistory() {
		return this.vvdHistory;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return sendDate
	 */
	public String getSendDate() {
		return this.sendDate;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return sendUsrNm
	 */
	public String getSendUsrNm() {
		return this.sendUsrNm;
	}
	
	/**
	 * Column Info
	 * @return fM
	 */
	public String getFM() {
		return this.fM;
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
	 * @return sendUsrId
	 */
	public String getSendUsrId() {
		return this.sendUsrId;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param sp
	 */
	public void setSp(String sp) {
		this.sp = sp;
	}
	
	/**
	 * Column Info
	 * @param ack
	 */
	public void setAck(String ack) {
		this.ack = ack;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDate
	 */
	public void setBkgDate(String bkgDate) {
		this.bkgDate = bkgDate;
	}
	
	/**
	 * Column Info
	 * @param tmlErrMsg
	 */
	public void setTmlErrMsg(String tmlErrMsg) {
		this.tmlErrMsg = tmlErrMsg;
	}
	
	/**
	 * Column Info
	 * @param ackDate
	 */
	public void setAckDate(String ackDate) {
		this.ackDate = ackDate;
	}
	
	/**
	 * Column Info
	 * @param vvdHistory
	 */
	public void setVvdHistory(String vvdHistory) {
		this.vvdHistory = vvdHistory;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param sendDate
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param sendUsrNm
	 */
	public void setSendUsrNm(String sendUsrNm) {
		this.sendUsrNm = sendUsrNm;
	}
	
	/**
	 * Column Info
	 * @param fM
	 */
	public void setFM(String fM) {
		this.fM = fM;
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
	 * @param sendUsrId
	 */
	public void setSendUsrId(String sendUsrId) {
		this.sendUsrId = sendUsrId;
	}
	
	public String getFH() {
		return fH;
	}

	public void setFH(String fh) {
		fH = fh;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setSp(JSPUtil.getParameter(request, "sp", ""));
		setAck(JSPUtil.getParameter(request, "ack", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setBkgDate(JSPUtil.getParameter(request, "bkg_date", ""));
		setTmlErrMsg(JSPUtil.getParameter(request, "tml_err_msg", ""));
		setAckDate(JSPUtil.getParameter(request, "ack_date", ""));
		setVvdHistory(JSPUtil.getParameter(request, "vvd_history", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setSendDate(JSPUtil.getParameter(request, "send_date", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
		setSendUsrNm(JSPUtil.getParameter(request, "send_usr_nm", ""));
		setFM(JSPUtil.getParameter(request, "f_m", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setSendUsrId(JSPUtil.getParameter(request, "send_usr_id", ""));
		setFH(JSPUtil.getParameter(request, "f_h", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForUsaTmlEdiVO[]
	 */
	public BkgListForUsaTmlEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForUsaTmlEdiVO[]
	 */
	public BkgListForUsaTmlEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForUsaTmlEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] sp = (JSPUtil.getParameter(request, prefix	+ "sp", length));
			String[] ack = (JSPUtil.getParameter(request, prefix	+ "ack", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bkgDate = (JSPUtil.getParameter(request, prefix	+ "bkg_date", length));
			String[] tmlErrMsg = (JSPUtil.getParameter(request, prefix	+ "tml_err_msg", length));
			String[] ackDate = (JSPUtil.getParameter(request, prefix	+ "ack_date", length));
			String[] vvdHistory = (JSPUtil.getParameter(request, prefix	+ "vvd_history", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] sendDate = (JSPUtil.getParameter(request, prefix	+ "send_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] sendUsrNm = (JSPUtil.getParameter(request, prefix	+ "send_usr_nm", length));
			String[] fM = (JSPUtil.getParameter(request, prefix	+ "f_m", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] sendUsrId = (JSPUtil.getParameter(request, prefix	+ "send_usr_id", length));
			String[] fH = (JSPUtil.getParameter(request, prefix	+ "f_h", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForUsaTmlEdiVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (sp[i] != null)
					model.setSp(sp[i]);
				if (ack[i] != null)
					model.setAck(ack[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bkgDate[i] != null)
					model.setBkgDate(bkgDate[i]);
				if (tmlErrMsg[i] != null)
					model.setTmlErrMsg(tmlErrMsg[i]);
				if (ackDate[i] != null)
					model.setAckDate(ackDate[i]);
				if (vvdHistory[i] != null)
					model.setVvdHistory(vvdHistory[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (sendDate[i] != null)
					model.setSendDate(sendDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (sendUsrNm[i] != null)
					model.setSendUsrNm(sendUsrNm[i]);
				if (fM[i] != null)
					model.setFM(fM[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (sendUsrId[i] != null)
					model.setSendUsrId(sendUsrId[i]);
				if (fH[i] != null)
					model.setFH(fH[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForUsaTmlEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForUsaTmlEdiVO[]
	 */
	public BkgListForUsaTmlEdiVO[] getBkgListForUsaTmlEdiVOs(){
		BkgListForUsaTmlEdiVO[] vos = (BkgListForUsaTmlEdiVO[])models.toArray(new BkgListForUsaTmlEdiVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sp = this.sp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ack = this.ack .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDate = this.bkgDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlErrMsg = this.tmlErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDate = this.ackDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdHistory = this.vvdHistory .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDate = this.sendDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendUsrNm = this.sendUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fM = this.fM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendUsrId = this.sendUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fH = this.fH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
