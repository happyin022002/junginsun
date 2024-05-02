/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaMiTransmitHistoryDetailVO.java
*@FileTitle : UsaMiTransmitHistoryDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.28 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaMiTransmitHistoryDetailVO extends AmsReportListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaMiTransmitHistoryDetailVO> models = new ArrayList<UsaMiTransmitHistoryDetailVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String totBl = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String ieBl = null;
	/* Column Info */
	private String sndUsrOfcCd = null;
	/* Column Info */
	private String mibBl = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaMiTransmitHistoryDetailVO() {}

	public UsaMiTransmitHistoryDetailVO(String ibflag, String pagerows, String sndDt, String trsmMsgTpId, String sndUsrOfcCd, String sndUsrId, String vvd, String polCd, String podCd, String totBl, String ieBl, String mibBl) {
		this.podCd = podCd;
		this.vvd = vvd;
		this.totBl = totBl;
		this.polCd = polCd;
		this.sndUsrId = sndUsrId;
		this.ibflag = ibflag;
		this.trsmMsgTpId = trsmMsgTpId;
		this.ieBl = ieBl;
		this.sndUsrOfcCd = sndUsrOfcCd;
		this.mibBl = mibBl;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("tot_bl", getTotBl());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("ie_bl", getIeBl());
		this.hashColumns.put("snd_usr_ofc_cd", getSndUsrOfcCd());
		this.hashColumns.put("mib_bl", getMibBl());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("tot_bl", "totBl");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("ie_bl", "ieBl");
		this.hashFields.put("snd_usr_ofc_cd", "sndUsrOfcCd");
		this.hashFields.put("mib_bl", "mibBl");
		this.hashFields.put("snd_dt", "sndDt");
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return totBl
	 */
	public String getTotBl() {
		return this.totBl;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return ieBl
	 */
	public String getIeBl() {
		return this.ieBl;
	}
	
	/**
	 * Column Info
	 * @return sndUsrOfcCd
	 */
	public String getSndUsrOfcCd() {
		return this.sndUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mibBl
	 */
	public String getMibBl() {
		return this.mibBl;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param totBl
	 */
	public void setTotBl(String totBl) {
		this.totBl = totBl;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param ieBl
	 */
	public void setIeBl(String ieBl) {
		this.ieBl = ieBl;
	}
	
	/**
	 * Column Info
	 * @param sndUsrOfcCd
	 */
	public void setSndUsrOfcCd(String sndUsrOfcCd) {
		this.sndUsrOfcCd = sndUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mibBl
	 */
	public void setMibBl(String mibBl) {
		this.mibBl = mibBl;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setTotBl(JSPUtil.getParameter(request, "tot_bl", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, "trsm_msg_tp_id", ""));
		setIeBl(JSPUtil.getParameter(request, "ie_bl", ""));
		setSndUsrOfcCd(JSPUtil.getParameter(request, "snd_usr_ofc_cd", ""));
		setMibBl(JSPUtil.getParameter(request, "mib_bl", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaMiTransmitHistoryDetailVO[]
	 */
	public UsaMiTransmitHistoryDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaMiTransmitHistoryDetailVO[]
	 */
	public UsaMiTransmitHistoryDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaMiTransmitHistoryDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] totBl = (JSPUtil.getParameter(request, prefix	+ "tot_bl".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id".trim(), length));
			String[] ieBl = (JSPUtil.getParameter(request, prefix	+ "ie_bl".trim(), length));
			String[] sndUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_usr_ofc_cd".trim(), length));
			String[] mibBl = (JSPUtil.getParameter(request, prefix	+ "mib_bl".trim(), length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaMiTransmitHistoryDetailVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (totBl[i] != null)
					model.setTotBl(totBl[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (ieBl[i] != null)
					model.setIeBl(ieBl[i]);
				if (sndUsrOfcCd[i] != null)
					model.setSndUsrOfcCd(sndUsrOfcCd[i]);
				if (mibBl[i] != null)
					model.setMibBl(mibBl[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaMiTransmitHistoryDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaMiTransmitHistoryDetailVO[]
	 */
	public UsaMiTransmitHistoryDetailVO[] getUsaMiTransmitHistoryDetailVOs(){
		UsaMiTransmitHistoryDetailVO[] vos = (UsaMiTransmitHistoryDetailVO[])models.toArray(new UsaMiTransmitHistoryDetailVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBl = this.totBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieBl = this.ieBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrOfcCd = this.sndUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mibBl = this.mibBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
