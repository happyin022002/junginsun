/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaMiHiHeadFootCondVO.java
*@FileTitle : UsaMiHiHeadFootCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.13 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaMiHiHeadFootCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaMiHiHeadFootCondVO> models = new ArrayList<UsaMiHiHeadFootCondVO>();
	
	/* Column Info */
	private String vslLloyd = null;
	/* Column Info */
	private String locAmsport = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String crrBatNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String trspMsgTpCd = null;
	/* Column Info */
	private String lineCount = null;
	/* Column Info */
	private String polName = null;
	/* Column Info */
	private String masterBlCnt = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String sndDt = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaMiHiHeadFootCondVO() {}

	public UsaMiHiHeadFootCondVO(String ibflag, String pagerows, String trspMsgTpCd, String vvd, String vslFlag, String vslEngNm, String blCnt, String vslLloyd, String locAmsport, String vpsEtaDt, String vpsEtdDt, String lineCount, String masterBlCnt, String polName, String podName, String crrBatNo, String sndDt) {
		this.vslLloyd = vslLloyd;
		this.locAmsport = locAmsport;
		this.vpsEtdDt = vpsEtdDt;
		this.vslFlag = vslFlag;
		this.crrBatNo = crrBatNo;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.podName = podName;
		this.vslEngNm = vslEngNm;
		this.trspMsgTpCd = trspMsgTpCd;
		this.lineCount = lineCount;
		this.polName = polName;
		this.masterBlCnt = masterBlCnt;
		this.blCnt = blCnt;
		this.sndDt = sndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_lloyd", getVslLloyd());
		this.hashColumns.put("loc_amsport", getLocAmsport());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("crr_bat_no", getCrrBatNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("trsp_msg_tp_cd", getTrspMsgTpCd());
		this.hashColumns.put("line_count", getLineCount());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("master_bl_cnt", getMasterBlCnt());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("snd_dt", getSndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_lloyd", "vslLloyd");
		this.hashFields.put("loc_amsport", "locAmsport");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("crr_bat_no", "crrBatNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("trsp_msg_tp_cd", "trspMsgTpCd");
		this.hashFields.put("line_count", "lineCount");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("master_bl_cnt", "masterBlCnt");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("snd_dt", "sndDt");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslLloyd
	 */
	public String getVslLloyd() {
		return this.vslLloyd;
	}
	
	/**
	 * Column Info
	 * @return locAmsport
	 */
	public String getLocAmsport() {
		return this.locAmsport;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return crrBatNo
	 */
	public String getCrrBatNo() {
		return this.crrBatNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return podName
	 */
	public String getPodName() {
		return this.podName;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return trspMsgTpCd
	 */
	public String getTrspMsgTpCd() {
		return this.trspMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @return lineCount
	 */
	public String getLineCount() {
		return this.lineCount;
	}
	
	/**
	 * Column Info
	 * @return polName
	 */
	public String getPolName() {
		return this.polName;
	}
	
	/**
	 * Column Info
	 * @return masterBlCnt
	 */
	public String getMasterBlCnt() {
		return this.masterBlCnt;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}	

	/**
	 * Column Info
	 * @param vslLloyd
	 */
	public void setVslLloyd(String vslLloyd) {
		this.vslLloyd = vslLloyd;
	}
	
	/**
	 * Column Info
	 * @param locAmsport
	 */
	public void setLocAmsport(String locAmsport) {
		this.locAmsport = locAmsport;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param crrBatNo
	 */
	public void setCrrBatNo(String crrBatNo) {
		this.crrBatNo = crrBatNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param podName
	 */
	public void setPodName(String podName) {
		this.podName = podName;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param trspMsgTpCd
	 */
	public void setTrspMsgTpCd(String trspMsgTpCd) {
		this.trspMsgTpCd = trspMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @param lineCount
	 */
	public void setLineCount(String lineCount) {
		this.lineCount = lineCount;
	}
	
	/**
	 * Column Info
	 * @param polName
	 */
	public void setPolName(String polName) {
		this.polName = polName;
	}
	
	/**
	 * Column Info
	 * @param masterBlCnt
	 */
	public void setMasterBlCnt(String masterBlCnt) {
		this.masterBlCnt = masterBlCnt;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
	}

	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslLloyd(JSPUtil.getParameter(request, "vsl_lloyd", ""));
		setLocAmsport(JSPUtil.getParameter(request, "loc_amsport", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setVslFlag(JSPUtil.getParameter(request, "vsl_flag", ""));
		setCrrBatNo(JSPUtil.getParameter(request, "crr_bat_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodName(JSPUtil.getParameter(request, "pod_name", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setTrspMsgTpCd(JSPUtil.getParameter(request, "trsp_msg_tp_cd", ""));
		setLineCount(JSPUtil.getParameter(request, "line_count", ""));
		setPolName(JSPUtil.getParameter(request, "pol_name", ""));
		setMasterBlCnt(JSPUtil.getParameter(request, "master_bl_cnt", ""));
		setBlCnt(JSPUtil.getParameter(request, "bl_cnt", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaMiHiHeadFootCondVO[]
	 */
	public UsaMiHiHeadFootCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaMiHiHeadFootCondVO[]
	 */
	public UsaMiHiHeadFootCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaMiHiHeadFootCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslLloyd = (JSPUtil.getParameter(request, prefix	+ "vsl_lloyd", length));
			String[] locAmsport = (JSPUtil.getParameter(request, prefix	+ "loc_amsport", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] crrBatNo = (JSPUtil.getParameter(request, prefix	+ "crr_bat_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] trspMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_msg_tp_cd", length));
			String[] lineCount = (JSPUtil.getParameter(request, prefix	+ "line_count", length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name", length));
			String[] masterBlCnt = (JSPUtil.getParameter(request, prefix	+ "master_bl_cnt", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaMiHiHeadFootCondVO();
				if (vslLloyd[i] != null)
					model.setVslLloyd(vslLloyd[i]);
				if (locAmsport[i] != null)
					model.setLocAmsport(locAmsport[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (crrBatNo[i] != null)
					model.setCrrBatNo(crrBatNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (trspMsgTpCd[i] != null)
					model.setTrspMsgTpCd(trspMsgTpCd[i]);
				if (lineCount[i] != null)
					model.setLineCount(lineCount[i]);
				if (polName[i] != null)
					model.setPolName(polName[i]);
				if (masterBlCnt[i] != null)
					model.setMasterBlCnt(masterBlCnt[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaMiHiHeadFootCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaMiHiHeadFootCondVO[]
	 */
	public UsaMiHiHeadFootCondVO[] getUsaMiHiHeadFootCondVOs(){
		UsaMiHiHeadFootCondVO[] vos = (UsaMiHiHeadFootCondVO[])models.toArray(new UsaMiHiHeadFootCondVO[models.size()]);
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
		this.vslLloyd = this.vslLloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locAmsport = this.locAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBatNo = this.crrBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMsgTpCd = this.trspMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineCount = this.lineCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masterBlCnt = this.masterBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
