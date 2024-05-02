/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaScacReportDetailVO.java
*@FileTitle : UsaScacReportDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.19 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
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

public class UsaScacReportDetailVO extends ScacReportDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaScacReportDetailVO> models = new ArrayList<UsaScacReportDetailVO>();
	
	/* Column Info */
	private String nvoccCbl = null;
	/* Column Info */
	private String hbl = null;
	/* Column Info */
	private String nvoccPodCd = null;
	/* Column Info */
	private String nvoccSkdVoyNo = null;
	/* Column Info */
	private String podErr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scacNm = null;
	/* Column Info */
	private String mbl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hjsScac = null;
	/* Column Info */
	private String mfRspnRcvFlg = null;
	/* Column Info */
	private String scac = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cstmsPodCd = null;
	/* Column Info */
	private String nvoccVslNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaScacReportDetailVO() {}

	public UsaScacReportDetailVO(String ibflag, String pagerows, String scac, String scacNm, String nvoccCbl, String hbl, String nvoccVslNm, String nvoccSkdVoyNo, String cstmsPodCd, String nvoccPodCd, String mbl, String hjsScac, String mfRspnRcvFlg, String rcvDt, String podErr) {
		this.nvoccCbl = nvoccCbl;
		this.hbl = hbl;
		this.nvoccPodCd = nvoccPodCd;
		this.nvoccSkdVoyNo = nvoccSkdVoyNo;
		this.podErr = podErr;
		this.pagerows = pagerows;
		this.scacNm = scacNm;
		this.mbl = mbl;
		this.ibflag = ibflag;
		this.hjsScac = hjsScac;
		this.mfRspnRcvFlg = mfRspnRcvFlg;
		this.scac = scac;
		this.rcvDt = rcvDt;
		this.cstmsPodCd = cstmsPodCd;
		this.nvoccVslNm = nvoccVslNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nvocc_cbl", getNvoccCbl());
		this.hashColumns.put("hbl", getHbl());
		this.hashColumns.put("nvocc_pod_cd", getNvoccPodCd());
		this.hashColumns.put("nvocc_skd_voy_no", getNvoccSkdVoyNo());
		this.hashColumns.put("pod_err", getPodErr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scac_nm", getScacNm());
		this.hashColumns.put("mbl", getMbl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hjs_scac", getHjsScac());
		this.hashColumns.put("mf_rspn_rcv_flg", getMfRspnRcvFlg());
		this.hashColumns.put("scac", getScac());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cstms_pod_cd", getCstmsPodCd());
		this.hashColumns.put("nvocc_vsl_nm", getNvoccVslNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nvocc_cbl", "nvoccCbl");
		this.hashFields.put("hbl", "hbl");
		this.hashFields.put("nvocc_pod_cd", "nvoccPodCd");
		this.hashFields.put("nvocc_skd_voy_no", "nvoccSkdVoyNo");
		this.hashFields.put("pod_err", "podErr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scac_nm", "scacNm");
		this.hashFields.put("mbl", "mbl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hjs_scac", "hjsScac");
		this.hashFields.put("mf_rspn_rcv_flg", "mfRspnRcvFlg");
		this.hashFields.put("scac", "scac");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cstms_pod_cd", "cstmsPodCd");
		this.hashFields.put("nvocc_vsl_nm", "nvoccVslNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nvoccCbl
	 */
	public String getNvoccCbl() {
		return this.nvoccCbl;
	}
	
	/**
	 * Column Info
	 * @return hbl
	 */
	public String getHbl() {
		return this.hbl;
	}
	
	/**
	 * Column Info
	 * @return nvoccPodCd
	 */
	public String getNvoccPodCd() {
		return this.nvoccPodCd;
	}
	
	/**
	 * Column Info
	 * @return nvoccSkdVoyNo
	 */
	public String getNvoccSkdVoyNo() {
		return this.nvoccSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return podErr
	 */
	public String getPodErr() {
		return this.podErr;
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
	 * @return scacNm
	 */
	public String getScacNm() {
		return this.scacNm;
	}
	
	/**
	 * Column Info
	 * @return mbl
	 */
	public String getMbl() {
		return this.mbl;
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
	 * @return hjsScac
	 */
	public String getHjsScac() {
		return this.hjsScac;
	}
	
	/**
	 * Column Info
	 * @return mfRspnRcvFlg
	 */
	public String getMfRspnRcvFlg() {
		return this.mfRspnRcvFlg;
	}
	
	/**
	 * Column Info
	 * @return scac
	 */
	public String getScac() {
		return this.scac;
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
	 * @return cstmsPodCd
	 */
	public String getCstmsPodCd() {
		return this.cstmsPodCd;
	}
	
	/**
	 * Column Info
	 * @return nvoccVslNm
	 */
	public String getNvoccVslNm() {
		return this.nvoccVslNm;
	}
	

	/**
	 * Column Info
	 * @param nvoccCbl
	 */
	public void setNvoccCbl(String nvoccCbl) {
		this.nvoccCbl = nvoccCbl;
	}
	
	/**
	 * Column Info
	 * @param hbl
	 */
	public void setHbl(String hbl) {
		this.hbl = hbl;
	}
	
	/**
	 * Column Info
	 * @param nvoccPodCd
	 */
	public void setNvoccPodCd(String nvoccPodCd) {
		this.nvoccPodCd = nvoccPodCd;
	}
	
	/**
	 * Column Info
	 * @param nvoccSkdVoyNo
	 */
	public void setNvoccSkdVoyNo(String nvoccSkdVoyNo) {
		this.nvoccSkdVoyNo = nvoccSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param podErr
	 */
	public void setPodErr(String podErr) {
		this.podErr = podErr;
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
	 * @param scacNm
	 */
	public void setScacNm(String scacNm) {
		this.scacNm = scacNm;
	}
	
	/**
	 * Column Info
	 * @param mbl
	 */
	public void setMbl(String mbl) {
		this.mbl = mbl;
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
	 * @param hjsScac
	 */
	public void setHjsScac(String hjsScac) {
		this.hjsScac = hjsScac;
	}
	
	/**
	 * Column Info
	 * @param mfRspnRcvFlg
	 */
	public void setMfRspnRcvFlg(String mfRspnRcvFlg) {
		this.mfRspnRcvFlg = mfRspnRcvFlg;
	}
	
	/**
	 * Column Info
	 * @param scac
	 */
	public void setScac(String scac) {
		this.scac = scac;
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
	 * @param cstmsPodCd
	 */
	public void setCstmsPodCd(String cstmsPodCd) {
		this.cstmsPodCd = cstmsPodCd;
	}
	
	/**
	 * Column Info
	 * @param nvoccVslNm
	 */
	public void setNvoccVslNm(String nvoccVslNm) {
		this.nvoccVslNm = nvoccVslNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNvoccCbl(JSPUtil.getParameter(request, "nvocc_cbl", ""));
		setHbl(JSPUtil.getParameter(request, "hbl", ""));
		setNvoccPodCd(JSPUtil.getParameter(request, "nvocc_pod_cd", ""));
		setNvoccSkdVoyNo(JSPUtil.getParameter(request, "nvocc_skd_voy_no", ""));
		setPodErr(JSPUtil.getParameter(request, "pod_err", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setScacNm(JSPUtil.getParameter(request, "scac_nm", ""));
		setMbl(JSPUtil.getParameter(request, "mbl", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHjsScac(JSPUtil.getParameter(request, "hjs_scac", ""));
		setMfRspnRcvFlg(JSPUtil.getParameter(request, "mf_rspn_rcv_flg", ""));
		setScac(JSPUtil.getParameter(request, "scac", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setCstmsPodCd(JSPUtil.getParameter(request, "cstms_pod_cd", ""));
		setNvoccVslNm(JSPUtil.getParameter(request, "nvocc_vsl_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaScacReportDetailVO[]
	 */
	public UsaScacReportDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaScacReportDetailVO[]
	 */
	public UsaScacReportDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaScacReportDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nvoccCbl = (JSPUtil.getParameter(request, prefix	+ "nvocc_cbl", length));
			String[] hbl = (JSPUtil.getParameter(request, prefix	+ "hbl", length));
			String[] nvoccPodCd = (JSPUtil.getParameter(request, prefix	+ "nvocc_pod_cd", length));
			String[] nvoccSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_skd_voy_no", length));
			String[] podErr = (JSPUtil.getParameter(request, prefix	+ "pod_err", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scacNm = (JSPUtil.getParameter(request, prefix	+ "scac_nm", length));
			String[] mbl = (JSPUtil.getParameter(request, prefix	+ "mbl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hjsScac = (JSPUtil.getParameter(request, prefix	+ "hjs_scac", length));
			String[] mfRspnRcvFlg = (JSPUtil.getParameter(request, prefix	+ "mf_rspn_rcv_flg", length));
			String[] scac = (JSPUtil.getParameter(request, prefix	+ "scac", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] cstmsPodCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pod_cd", length));
			String[] nvoccVslNm = (JSPUtil.getParameter(request, prefix	+ "nvocc_vsl_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaScacReportDetailVO();
				if (nvoccCbl[i] != null)
					model.setNvoccCbl(nvoccCbl[i]);
				if (hbl[i] != null)
					model.setHbl(hbl[i]);
				if (nvoccPodCd[i] != null)
					model.setNvoccPodCd(nvoccPodCd[i]);
				if (nvoccSkdVoyNo[i] != null)
					model.setNvoccSkdVoyNo(nvoccSkdVoyNo[i]);
				if (podErr[i] != null)
					model.setPodErr(podErr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scacNm[i] != null)
					model.setScacNm(scacNm[i]);
				if (mbl[i] != null)
					model.setMbl(mbl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hjsScac[i] != null)
					model.setHjsScac(hjsScac[i]);
				if (mfRspnRcvFlg[i] != null)
					model.setMfRspnRcvFlg(mfRspnRcvFlg[i]);
				if (scac[i] != null)
					model.setScac(scac[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cstmsPodCd[i] != null)
					model.setCstmsPodCd(cstmsPodCd[i]);
				if (nvoccVslNm[i] != null)
					model.setNvoccVslNm(nvoccVslNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaScacReportDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaScacReportDetailVO[]
	 */
	public UsaScacReportDetailVO[] getUsaScacReportDetailVOs(){
		UsaScacReportDetailVO[] vos = (UsaScacReportDetailVO[])models.toArray(new UsaScacReportDetailVO[models.size()]);
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
		this.nvoccCbl = this.nvoccCbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbl = this.hbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccPodCd = this.nvoccPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccSkdVoyNo = this.nvoccSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podErr = this.podErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacNm = this.scacNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbl = this.mbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsScac = this.hjsScac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRspnRcvFlg = this.mfRspnRcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scac = this.scac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPodCd = this.cstmsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccVslNm = this.nvoccVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
