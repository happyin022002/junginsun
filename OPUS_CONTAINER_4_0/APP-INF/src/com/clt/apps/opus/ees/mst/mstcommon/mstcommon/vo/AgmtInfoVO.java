/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgmtInfoVO.java
*@FileTitle : AgmtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.11 이호선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgmtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgmtInfoVO> models = new ArrayList<AgmtInfoVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String lseFreeDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String agmtLstVerSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String lstmCd = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgmtInfoVO() {}

	public AgmtInfoVO(String ibflag, String pagerows, String agmtNo, String agmtCtyCd, String agmtSeq, String agmtLstVerSeq, String vndrSeq, String lstmCd, String ofcCd, String currCd, String refNo, String vndrLglEngNm, String effDt, String expDt, String lseFreeDys, String vndrAbbrNm) {
		this.currCd = currCd;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.lseFreeDys = lseFreeDys;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.agmtLstVerSeq = agmtLstVerSeq;
		this.vndrSeq = vndrSeq;
		this.agmtCtyCd = agmtCtyCd;
		this.refNo = refNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.expDt = expDt;
		this.lstmCd = lstmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("lse_free_dys", getLseFreeDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("agmt_lst_ver_seq", getAgmtLstVerSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("lse_free_dys", "lseFreeDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("agmt_lst_ver_seq", "agmtLstVerSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return lseFreeDys
	 */
	public String getLseFreeDys() {
		return this.lseFreeDys;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return agmtLstVerSeq
	 */
	public String getAgmtLstVerSeq() {
		return this.agmtLstVerSeq;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	

	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param lseFreeDys
	 */
	public void setLseFreeDys(String lseFreeDys) {
		this.lseFreeDys = lseFreeDys;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param agmtLstVerSeq
	 */
	public void setAgmtLstVerSeq(String agmtLstVerSeq) {
		this.agmtLstVerSeq = agmtLstVerSeq;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setLseFreeDys(JSPUtil.getParameter(request, "lse_free_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setAgmtLstVerSeq(JSPUtil.getParameter(request, "agmt_lst_ver_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgmtInfoVO[]
	 */
	public AgmtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgmtInfoVO[]
	 */
	public AgmtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgmtInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] lseFreeDys = (JSPUtil.getParameter(request, prefix	+ "lse_free_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] agmtLstVerSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_lst_ver_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgmtInfoVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (lseFreeDys[i] != null)
					model.setLseFreeDys(lseFreeDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (agmtLstVerSeq[i] != null)
					model.setAgmtLstVerSeq(agmtLstVerSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgmtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgmtInfoVO[]
	 */
	public AgmtInfoVO[] getAgmtInfoVOs(){
		AgmtInfoVO[] vos = (AgmtInfoVO[])models.toArray(new AgmtInfoVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseFreeDys = this.lseFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstVerSeq = this.agmtLstVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
