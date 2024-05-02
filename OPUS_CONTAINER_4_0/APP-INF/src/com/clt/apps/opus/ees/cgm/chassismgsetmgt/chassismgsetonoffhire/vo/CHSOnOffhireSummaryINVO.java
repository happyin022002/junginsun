/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSEqOnOffhireSummaryINVO.java
*@FileTitle : CHSEqOnOffhireSummaryINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.01 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSOnOffhireSummaryINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSOnOffhireSummaryINVO> models = new ArrayList<CHSOnOffhireSummaryINVO>();
	
	/* Column Info */
	private String strGubun = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String evntDtStr = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String evntDtEnd = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSOnOffhireSummaryINVO() {}
    
	/**
	 * 컬럼에 대응되는 변수 저장 
	 * @param ibflag
	 * @param pagerows
	 * @param evntDtStr
	 * @param evntDtEnd
	 * @param eqAsetStsCd
	 * @param strGubun
	 * @param location
	 * @param sccCd
	 * @param stsEvntYdCd
	 * @param agmtLstmCd
	 * @param kind
	 * @param vndrSeq
	 */
	public CHSOnOffhireSummaryINVO(String ibflag, String pagerows, String evntDtStr, String evntDtEnd, String eqAsetStsCd, String strGubun, String location, String sccCd, String stsEvntYdCd, String agmtLstmCd, String kind, String vndrSeq) {
		this.strGubun = strGubun;
		this.ibflag = ibflag;
		this.sccCd = sccCd;
		this.eqAsetStsCd = eqAsetStsCd;
		this.location = location;
		this.evntDtStr = evntDtStr;
		this.vndrSeq = vndrSeq;
		this.stsEvntYdCd = stsEvntYdCd;
		this.agmtLstmCd = agmtLstmCd;
		this.evntDtEnd = evntDtEnd;
		this.kind = kind;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("str_gubun", getStrGubun());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("evnt_dt_str", getEvntDtStr());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("evnt_dt_end", getEvntDtEnd());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("str_gubun", "strGubun");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("location", "location");
		this.hashFields.put("evnt_dt_str", "evntDtStr");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("evnt_dt_end", "evntDtEnd");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return strGubun
	 */
	public String getStrGubun() {
		return this.strGubun;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return evntDtStr
	 */
	public String getEvntDtStr() {
		return this.evntDtStr;
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
	 * @return stsEvntYdCd
	 */
	public String getStsEvntYdCd() {
		return this.stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return evntDtEnd
	 */
	public String getEvntDtEnd() {
		return this.evntDtEnd;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @param strGubun
	 */
	public void setStrGubun(String strGubun) {
		this.strGubun = strGubun;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param evntDtStr
	 */
	public void setEvntDtStr(String evntDtStr) {
		this.evntDtStr = evntDtStr;
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
	 * @param stsEvntYdCd
	 */
	public void setStsEvntYdCd(String stsEvntYdCd) {
		this.stsEvntYdCd = stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param evntDtEnd
	 */
	public void setEvntDtEnd(String evntDtEnd) {
		this.evntDtEnd = evntDtEnd;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
		setStrGubun(JSPUtil.getParameter(request, "str_gubun", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, "eq_aset_sts_cd", ""));
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setEvntDtStr(JSPUtil.getParameter(request, "evnt_dt_str", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, "sts_evnt_yd_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEvntDtEnd(JSPUtil.getParameter(request, "evnt_dt_end", ""));
		setKind(JSPUtil.getParameter(request, "kind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSEqOnOffhireSummaryINVO[]
	 */
	public CHSOnOffhireSummaryINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSEqOnOffhireSummaryINVO[]
	 */
	public CHSOnOffhireSummaryINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSOnOffhireSummaryINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] strGubun = (JSPUtil.getParameter(request, prefix	+ "str_gubun".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd".trim(), length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd".trim(), length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location".trim(), length));
			String[] evntDtStr = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_str".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd".trim(), length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd".trim(), length));
			String[] evntDtEnd = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_end".trim(), length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSOnOffhireSummaryINVO();
				if (strGubun[i] != null)
					model.setStrGubun(strGubun[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (evntDtStr[i] != null)
					model.setEvntDtStr(evntDtStr[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (evntDtEnd[i] != null)
					model.setEvntDtEnd(evntDtEnd[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSEqOnOffhireSummaryINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSEqOnOffhireSummaryINVO[]
	 */
	public CHSOnOffhireSummaryINVO[] getCHSEqOnOffhireSummaryINVOs(){
		CHSOnOffhireSummaryINVO[] vos = (CHSOnOffhireSummaryINVO[])models.toArray(new CHSOnOffhireSummaryINVO[models.size()]);
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
		this.strGubun = this.strGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtStr = this.evntDtStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtEnd = this.evntDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
