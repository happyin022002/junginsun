/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSLostResultMGTVO.java
*@FileTitle : CHSLostResultMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.18 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSLostResultMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSLostResultMGTVO> models = new ArrayList<CHSLostResultMGTVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String sf4 = null;
	/* Column Info */
	private String cb4 = null;
	/* Column Info */
	private String agreement = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gn5 = null;
	/* Column Info */
	private String zt4 = null;
	/* Column Info */
	private String stsEvntLocCd = null;
	/* Column Info */
	private String sl2 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ta2 = null;
	/* Column Info */
	private String gn4 = null;
	/* Column Info */
	private String eg5 = null;
	/* Column Info */
	private String eg8 = null;
	/* Column Info */
	private String sf2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSLostResultMGTVO() {}

	public CHSLostResultMGTVO(String ibflag, String pagerows, String agreement, String stsEvntLocCd, String agmtLstmCd, String vndrLglEngNm, String total, String sf2, String sl2, String ta2, String sf4, String gn4, String cb4, String gn5, String eg5, String eg8, String zt4, String vndrSeq) {
		this.total = total;
		this.sf4 = sf4;
		this.cb4 = cb4;
		this.agreement = agreement;
		this.vndrLglEngNm = vndrLglEngNm;
		this.agmtLstmCd = agmtLstmCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.gn5 = gn5;
		this.zt4 = zt4;
		this.stsEvntLocCd = stsEvntLocCd;
		this.sl2 = sl2;
		this.vndrSeq = vndrSeq;
		this.ta2 = ta2;
		this.gn4 = gn4;
		this.eg5 = eg5;
		this.eg8 = eg8;
		this.sf2 = sf2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("sf4", getSf4());
		this.hashColumns.put("cb4", getCb4());
		this.hashColumns.put("agreement", getAgreement());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gn5", getGn5());
		this.hashColumns.put("zt4", getZt4());
		this.hashColumns.put("sts_evnt_loc_cd", getStsEvntLocCd());
		this.hashColumns.put("sl2", getSl2());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ta2", getTa2());
		this.hashColumns.put("gn4", getGn4());
		this.hashColumns.put("eg5", getEg5());
		this.hashColumns.put("eg8", getEg8());
		this.hashColumns.put("sf2", getSf2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("sf4", "sf4");
		this.hashFields.put("cb4", "cb4");
		this.hashFields.put("agreement", "agreement");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gn5", "gn5");
		this.hashFields.put("zt4", "zt4");
		this.hashFields.put("sts_evnt_loc_cd", "stsEvntLocCd");
		this.hashFields.put("sl2", "sl2");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ta2", "ta2");
		this.hashFields.put("gn4", "gn4");
		this.hashFields.put("eg5", "eg5");
		this.hashFields.put("eg8", "eg8");
		this.hashFields.put("sf2", "sf2");
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
	 * @return sf4
	 */
	public String getSf4() {
		return this.sf4;
	}
	
	/**
	 * Column Info
	 * @return cb4
	 */
	public String getCb4() {
		return this.cb4;
	}
	
	/**
	 * Column Info
	 * @return agreement
	 */
	public String getAgreement() {
		return this.agreement;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return gn5
	 */
	public String getGn5() {
		return this.gn5;
	}
	
	/**
	 * Column Info
	 * @return zt4
	 */
	public String getZt4() {
		return this.zt4;
	}
	
	/**
	 * Column Info
	 * @return stsEvntLocCd
	 */
	public String getStsEvntLocCd() {
		return this.stsEvntLocCd;
	}
	
	/**
	 * Column Info
	 * @return sl2
	 */
	public String getSl2() {
		return this.sl2;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ta2
	 */
	public String getTa2() {
		return this.ta2;
	}
	
	/**
	 * Column Info
	 * @return gn4
	 */
	public String getGn4() {
		return this.gn4;
	}
	
	/**
	 * Column Info
	 * @return eg5
	 */
	public String getEg5() {
		return this.eg5;
	}
	
	/**
	 * Column Info
	 * @return eg8
	 */
	public String getEg8() {
		return this.eg8;
	}
	
	/**
	 * Column Info
	 * @return sf2
	 */
	public String getSf2() {
		return this.sf2;
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
	 * @param sf4
	 */
	public void setSf4(String sf4) {
		this.sf4 = sf4;
	}
	
	/**
	 * Column Info
	 * @param cb4
	 */
	public void setCb4(String cb4) {
		this.cb4 = cb4;
	}
	
	/**
	 * Column Info
	 * @param agreement
	 */
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param gn5
	 */
	public void setGn5(String gn5) {
		this.gn5 = gn5;
	}
	
	/**
	 * Column Info
	 * @param zt4
	 */
	public void setZt4(String zt4) {
		this.zt4 = zt4;
	}
	
	/**
	 * Column Info
	 * @param stsEvntLocCd
	 */
	public void setStsEvntLocCd(String stsEvntLocCd) {
		this.stsEvntLocCd = stsEvntLocCd;
	}
	
	/**
	 * Column Info
	 * @param sl2
	 */
	public void setSl2(String sl2) {
		this.sl2 = sl2;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ta2
	 */
	public void setTa2(String ta2) {
		this.ta2 = ta2;
	}
	
	/**
	 * Column Info
	 * @param gn4
	 */
	public void setGn4(String gn4) {
		this.gn4 = gn4;
	}
	
	/**
	 * Column Info
	 * @param eg5
	 */
	public void setEg5(String eg5) {
		this.eg5 = eg5;
	}
	
	/**
	 * Column Info
	 * @param eg8
	 */
	public void setEg8(String eg8) {
		this.eg8 = eg8;
	}
	
	/**
	 * Column Info
	 * @param sf2
	 */
	public void setSf2(String sf2) {
		this.sf2 = sf2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setSf4(JSPUtil.getParameter(request, "sf4", ""));
		setCb4(JSPUtil.getParameter(request, "cb4", ""));
		setAgreement(JSPUtil.getParameter(request, "agreement", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGn5(JSPUtil.getParameter(request, "gn5", ""));
		setZt4(JSPUtil.getParameter(request, "zt4", ""));
		setStsEvntLocCd(JSPUtil.getParameter(request, "sts_evnt_loc_cd", ""));
		setSl2(JSPUtil.getParameter(request, "sl2", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setTa2(JSPUtil.getParameter(request, "ta2", ""));
		setGn4(JSPUtil.getParameter(request, "gn4", ""));
		setEg5(JSPUtil.getParameter(request, "eg5", ""));
		setEg8(JSPUtil.getParameter(request, "eg8", ""));
		setSf2(JSPUtil.getParameter(request, "sf2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSLostResultMGTVO[]
	 */
	public CHSLostResultMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSLostResultMGTVO[]
	 */
	public CHSLostResultMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSLostResultMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] sf4 = (JSPUtil.getParameter(request, prefix	+ "sf4", length));
			String[] cb4 = (JSPUtil.getParameter(request, prefix	+ "cb4", length));
			String[] agreement = (JSPUtil.getParameter(request, prefix	+ "agreement", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gn5 = (JSPUtil.getParameter(request, prefix	+ "gn5", length));
			String[] zt4 = (JSPUtil.getParameter(request, prefix	+ "zt4", length));
			String[] stsEvntLocCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_loc_cd", length));
			String[] sl2 = (JSPUtil.getParameter(request, prefix	+ "sl2", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ta2 = (JSPUtil.getParameter(request, prefix	+ "ta2", length));
			String[] gn4 = (JSPUtil.getParameter(request, prefix	+ "gn4", length));
			String[] eg5 = (JSPUtil.getParameter(request, prefix	+ "eg5", length));
			String[] eg8 = (JSPUtil.getParameter(request, prefix	+ "eg8", length));
			String[] sf2 = (JSPUtil.getParameter(request, prefix	+ "sf2", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSLostResultMGTVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (sf4[i] != null)
					model.setSf4(sf4[i]);
				if (cb4[i] != null)
					model.setCb4(cb4[i]);
				if (agreement[i] != null)
					model.setAgreement(agreement[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gn5[i] != null)
					model.setGn5(gn5[i]);
				if (zt4[i] != null)
					model.setZt4(zt4[i]);
				if (stsEvntLocCd[i] != null)
					model.setStsEvntLocCd(stsEvntLocCd[i]);
				if (sl2[i] != null)
					model.setSl2(sl2[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ta2[i] != null)
					model.setTa2(ta2[i]);
				if (gn4[i] != null)
					model.setGn4(gn4[i]);
				if (eg5[i] != null)
					model.setEg5(eg5[i]);
				if (eg8[i] != null)
					model.setEg8(eg8[i]);
				if (sf2[i] != null)
					model.setSf2(sf2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSLostResultMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSLostResultMGTVO[]
	 */
	public CHSLostResultMGTVO[] getCHSLostResultMGTVOs(){
		CHSLostResultMGTVO[] vos = (CHSLostResultMGTVO[])models.toArray(new CHSLostResultMGTVO[models.size()]);
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
		this.sf4 = this.sf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cb4 = this.cb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agreement = this.agreement .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gn5 = this.gn5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zt4 = this.zt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntLocCd = this.stsEvntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sl2 = this.sl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ta2 = this.ta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gn4 = this.gn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eg5 = this.eg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eg8 = this.eg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sf2 = this.sf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
