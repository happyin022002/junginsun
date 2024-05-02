/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsSearchRocsRcvHistByBlVO.java
*@FileTitle : RocsSearchRocsRcvHistByBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.09.04 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.RecieveHistLogVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearchRocsRcvHistByBlVO extends RecieveHistLogVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchRocsRcvHistByBlVO> models = new ArrayList<RocsSearchRocsRcvHistByBlVO>();
	
	/* Column Info */
	private String errCtnt = null;
	/* Column Info */
	private String msgSndDt = null;
	/* Column Info */
	private String rowcnt = null;
	/* Column Info */
	private String rtmEdiMsgTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rtmEdiErrId = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String hist = null;
	/* Column Info */
	private String vvdNumber = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearchRocsRcvHistByBlVO() {}

	public RocsSearchRocsRcvHistByBlVO(String ibflag, String pagerows, String rtmEdiMsgTpCd, String msgSndDt, String blNo, String rtmEdiErrId, String errDesc, String errCtnt, String ofcCd, String creUsrId, String rowcnt, String vvdNumber, String polCd, String podCd, String hist) {
		this.errCtnt = errCtnt;
		this.msgSndDt = msgSndDt;
		this.rowcnt = rowcnt;
		this.rtmEdiMsgTpCd = rtmEdiMsgTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.polCd = polCd;
		this.rtmEdiErrId = rtmEdiErrId;
		this.errDesc = errDesc;
		this.hist = hist;
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("err_ctnt", getErrCtnt());
		this.hashColumns.put("msg_snd_dt", getMsgSndDt());
		this.hashColumns.put("rowcnt", getRowcnt());
		this.hashColumns.put("rtm_edi_msg_tp_cd", getRtmEdiMsgTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rtm_edi_err_id", getRtmEdiErrId());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("hist", getHist());
		this.hashColumns.put("vvd_number", getVvdNumber());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("err_ctnt", "errCtnt");
		this.hashFields.put("msg_snd_dt", "msgSndDt");
		this.hashFields.put("rowcnt", "rowcnt");
		this.hashFields.put("rtm_edi_msg_tp_cd", "rtmEdiMsgTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rtm_edi_err_id", "rtmEdiErrId");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("hist", "hist");
		this.hashFields.put("vvd_number", "vvdNumber");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return errCtnt
	 */
	public String getErrCtnt() {
		return this.errCtnt;
	}
	
	/**
	 * Column Info
	 * @return msgSndDt
	 */
	public String getMsgSndDt() {
		return this.msgSndDt;
	}
	
	/**
	 * Column Info
	 * @return rowcnt
	 */
	public String getRowcnt() {
		return this.rowcnt;
	}
	
	/**
	 * Column Info
	 * @return rtmEdiMsgTpCd
	 */
	public String getRtmEdiMsgTpCd() {
		return this.rtmEdiMsgTpCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return rtmEdiErrId
	 */
	public String getRtmEdiErrId() {
		return this.rtmEdiErrId;
	}
	
	/**
	 * Column Info
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return hist
	 */
	public String getHist() {
		return this.hist;
	}
	
	/**
	 * Column Info
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	

	/**
	 * Column Info
	 * @param errCtnt
	 */
	public void setErrCtnt(String errCtnt) {
		this.errCtnt = errCtnt;
	}
	
	/**
	 * Column Info
	 * @param msgSndDt
	 */
	public void setMsgSndDt(String msgSndDt) {
		this.msgSndDt = msgSndDt;
	}
	
	/**
	 * Column Info
	 * @param rowcnt
	 */
	public void setRowcnt(String rowcnt) {
		this.rowcnt = rowcnt;
	}
	
	/**
	 * Column Info
	 * @param rtmEdiMsgTpCd
	 */
	public void setRtmEdiMsgTpCd(String rtmEdiMsgTpCd) {
		this.rtmEdiMsgTpCd = rtmEdiMsgTpCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param rtmEdiErrId
	 */
	public void setRtmEdiErrId(String rtmEdiErrId) {
		this.rtmEdiErrId = rtmEdiErrId;
	}
	
	/**
	 * Column Info
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param hist
	 */
	public void setHist(String hist) {
		this.hist = hist;
	}
	
	/**
	 * Column Info
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setErrCtnt(JSPUtil.getParameter(request, "err_ctnt", ""));
		setMsgSndDt(JSPUtil.getParameter(request, "msg_snd_dt", ""));
		setRowcnt(JSPUtil.getParameter(request, "rowcnt", ""));
		setRtmEdiMsgTpCd(JSPUtil.getParameter(request, "rtm_edi_msg_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setRtmEdiErrId(JSPUtil.getParameter(request, "rtm_edi_err_id", ""));
		setErrDesc(JSPUtil.getParameter(request, "err_desc", ""));
		setHist(JSPUtil.getParameter(request, "hist", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchRocsRcvHistByBlVO[]
	 */
	public RocsSearchRocsRcvHistByBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchRocsRcvHistByBlVO[]
	 */
	public RocsSearchRocsRcvHistByBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchRocsRcvHistByBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] errCtnt = (JSPUtil.getParameter(request, prefix	+ "err_ctnt", length));
			String[] msgSndDt = (JSPUtil.getParameter(request, prefix	+ "msg_snd_dt", length));
			String[] rowcnt = (JSPUtil.getParameter(request, prefix	+ "rowcnt", length));
			String[] rtmEdiMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "rtm_edi_msg_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rtmEdiErrId = (JSPUtil.getParameter(request, prefix	+ "rtm_edi_err_id", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] hist = (JSPUtil.getParameter(request, prefix	+ "hist", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchRocsRcvHistByBlVO();
				if (errCtnt[i] != null)
					model.setErrCtnt(errCtnt[i]);
				if (msgSndDt[i] != null)
					model.setMsgSndDt(msgSndDt[i]);
				if (rowcnt[i] != null)
					model.setRowcnt(rowcnt[i]);
				if (rtmEdiMsgTpCd[i] != null)
					model.setRtmEdiMsgTpCd(rtmEdiMsgTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rtmEdiErrId[i] != null)
					model.setRtmEdiErrId(rtmEdiErrId[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (hist[i] != null)
					model.setHist(hist[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchRocsRcvHistByBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchRocsRcvHistByBlVO[]
	 */
	public RocsSearchRocsRcvHistByBlVO[] getRocsSearchRocsRcvHistByBlVOs(){
		RocsSearchRocsRcvHistByBlVO[] vos = (RocsSearchRocsRcvHistByBlVO[])models.toArray(new RocsSearchRocsRcvHistByBlVO[models.size()]);
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
		this.errCtnt = this.errCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndDt = this.msgSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowcnt = this.rowcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtmEdiMsgTpCd = this.rtmEdiMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtmEdiErrId = this.rtmEdiErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hist = this.hist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
