/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsTransmitHistCondVO.java
*@FileTitle : RocsTransmitHistCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.09.03 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsTransmitHistCondVO extends TransmitHistCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsTransmitHistCondVO> models = new ArrayList<RocsTransmitHistCondVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vpsEtaEndDt = null;
	/* Column Info */
	private String vpsEtaStartDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String totime = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String fromtime = null;
	/* Column Info */
	private String msgType = null;
	/* Column Info */
	private String dateGubun = null;
	/* Column Info */
	private String podClptIndSeq = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsTransmitHistCondVO() {}

	public RocsTransmitHistCondVO(String ibflag, String pagerows, String msgType, String blNo, String polCd, String podCd, String vpsEtaStartDt, String dateGubun, String fromtime, String vpsEtaEndDt, String totime, String vslCd, String skdVoyNo, String skdDirCd, String userId
			                     , String podClptIndSeq) {
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.vpsEtaEndDt = vpsEtaEndDt;
		this.vpsEtaStartDt = vpsEtaStartDt;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.totime = totime;
		this.userId = userId;
		this.fromtime = fromtime;
		this.msgType = msgType;
		this.dateGubun = dateGubun;
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vps_eta_end_dt", getVpsEtaEndDt());
		this.hashColumns.put("vps_eta_start_dt", getVpsEtaStartDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("totime", getTotime());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("fromtime", getFromtime());
		this.hashColumns.put("msg_type", getMsgType());
		this.hashColumns.put("date_gubun", getDateGubun());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vps_eta_end_dt", "vpsEtaEndDt");
		this.hashFields.put("vps_eta_start_dt", "vpsEtaStartDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("totime", "totime");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("fromtime", "fromtime");
		this.hashFields.put("msg_type", "msgType");
		this.hashFields.put("date_gubun", "dateGubun");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaEndDt
	 */
	public String getVpsEtaEndDt() {
		return this.vpsEtaEndDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaStartDt
	 */
	public String getVpsEtaStartDt() {
		return this.vpsEtaStartDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return totime
	 */
	public String getTotime() {
		return this.totime;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return fromtime
	 */
	public String getFromtime() {
		return this.fromtime;
	}
	
	/**
	 * Column Info
	 * @return msgType
	 */
	public String getMsgType() {
		return this.msgType;
	}
	
	/**
	 * Column Info
	 * @return dateGubun
	 */
	public String getDateGubun() {
		return this.dateGubun;
	}

	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaEndDt
	 */
	public void setVpsEtaEndDt(String vpsEtaEndDt) {
		this.vpsEtaEndDt = vpsEtaEndDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaStartDt
	 */
	public void setVpsEtaStartDt(String vpsEtaStartDt) {
		this.vpsEtaStartDt = vpsEtaStartDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param totime
	 */
	public void setTotime(String totime) {
		this.totime = totime;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param fromtime
	 */
	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}
	
	/**
	 * Column Info
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	/**
	 * Column Info
	 * @param dateGubun
	 */
	public void setDateGubun(String dateGubun) {
		this.dateGubun = dateGubun;
	}

	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVpsEtaEndDt(JSPUtil.getParameter(request, "vps_eta_end_dt", ""));
		setVpsEtaStartDt(JSPUtil.getParameter(request, "vps_eta_start_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTotime(JSPUtil.getParameter(request, "totime", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setFromtime(JSPUtil.getParameter(request, "fromtime", ""));
		setMsgType(JSPUtil.getParameter(request, "msg_type", ""));
		setDateGubun(JSPUtil.getParameter(request, "date_gubun", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsTransmitHistCondVO[]
	 */
	public RocsTransmitHistCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsTransmitHistCondVO[]
	 */
	public RocsTransmitHistCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsTransmitHistCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vpsEtaEndDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_end_dt", length));
			String[] vpsEtaStartDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_start_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] totime = (JSPUtil.getParameter(request, prefix	+ "totime", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] fromtime = (JSPUtil.getParameter(request, prefix	+ "fromtime", length));
			String[] msgType = (JSPUtil.getParameter(request, prefix	+ "msg_type", length));
			String[] dateGubun = (JSPUtil.getParameter(request, prefix	+ "date_gubun", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsTransmitHistCondVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vpsEtaEndDt[i] != null)
					model.setVpsEtaEndDt(vpsEtaEndDt[i]);
				if (vpsEtaStartDt[i] != null)
					model.setVpsEtaStartDt(vpsEtaStartDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (totime[i] != null)
					model.setTotime(totime[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (fromtime[i] != null)
					model.setFromtime(fromtime[i]);
				if (msgType[i] != null)
					model.setMsgType(msgType[i]);
				if (dateGubun[i] != null)
					model.setDateGubun(dateGubun[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsTransmitHistCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsTransmitHistCondVO[]
	 */
	public RocsTransmitHistCondVO[] getRocsTransmitHistCondVOs(){
		RocsTransmitHistCondVO[] vos = (RocsTransmitHistCondVO[])models.toArray(new RocsTransmitHistCondVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaEndDt = this.vpsEtaEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaStartDt = this.vpsEtaStartDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totime = this.totime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromtime = this.fromtime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgType = this.msgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateGubun = this.dateGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
