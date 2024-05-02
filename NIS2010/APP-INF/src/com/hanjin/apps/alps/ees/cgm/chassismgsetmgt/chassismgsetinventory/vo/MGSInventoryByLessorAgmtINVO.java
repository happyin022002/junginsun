/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MGSInventoryByLessorAgmtINVO.java
*@FileTitle : MGSInventoryByLessorAgmtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.10 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSInventoryByLessorAgmtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSInventoryByLessorAgmtINVO> models = new ArrayList<MGSInventoryByLessorAgmtINVO>();
	
	/* Column Info */
	private String agmtRefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqTpszCdUmg = null;
	/* Column Info */
	private String eqTpszCdClg = null;
	/* Column Info */
	private String eqTpszCdTotal = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String crntOfcCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSInventoryByLessorAgmtINVO() {}

	public MGSInventoryByLessorAgmtINVO(String ibflag, String pagerows, String eqKndCd, String crntOfcCd, String vndrSeq, String agmtLstmCd, String vndrLglEngNm, String agmtNo, String agmtRefNo, String eqTpszCdTotal, String eqTpszCdUmg, String eqTpszCdClg) {
		this.agmtRefNo = agmtRefNo;
		this.ibflag = ibflag;
		this.eqTpszCdUmg = eqTpszCdUmg;
		this.eqTpszCdClg = eqTpszCdClg;
		this.eqTpszCdTotal = eqTpszCdTotal;
		this.vndrSeq = vndrSeq;
		this.agmtNo = agmtNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.crntOfcCd = crntOfcCd;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_tpsz_cd_umg", getEqTpszCdUmg());
		this.hashColumns.put("eq_tpsz_cd_clg", getEqTpszCdClg());
		this.hashColumns.put("eq_tpsz_cd_total", getEqTpszCdTotal());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("crnt_ofc_cd", getCrntOfcCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_tpsz_cd_umg", "eqTpszCdUmg");
		this.hashFields.put("eq_tpsz_cd_clg", "eqTpszCdClg");
		this.hashFields.put("eq_tpsz_cd_total", "eqTpszCdTotal");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("crnt_ofc_cd", "crntOfcCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
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
	 * @return eqTpszCdUmg
	 */
	public String getEqTpszCdUmg() {
		return this.eqTpszCdUmg;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdClg
	 */
	public String getEqTpszCdClg() {
		return this.eqTpszCdClg;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdTotal
	 */
	public String getEqTpszCdTotal() {
		return this.eqTpszCdTotal;
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
	 * @return crntOfcCd
	 */
	public String getCrntOfcCd() {
		return this.crntOfcCd;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
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
	 * @param eqTpszCdUmg
	 */
	public void setEqTpszCdUmg(String eqTpszCdUmg) {
		this.eqTpszCdUmg = eqTpszCdUmg;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdClg
	 */
	public void setEqTpszCdClg(String eqTpszCdClg) {
		this.eqTpszCdClg = eqTpszCdClg;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdTotal
	 */
	public void setEqTpszCdTotal(String eqTpszCdTotal) {
		this.eqTpszCdTotal = eqTpszCdTotal;
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
	 * @param crntOfcCd
	 */
	public void setCrntOfcCd(String crntOfcCd) {
		this.crntOfcCd = crntOfcCd;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqTpszCdUmg(JSPUtil.getParameter(request, "eq_tpsz_cd_umg", ""));
		setEqTpszCdClg(JSPUtil.getParameter(request, "eq_tpsz_cd_clg", ""));
		setEqTpszCdTotal(JSPUtil.getParameter(request, "eq_tpsz_cd_total", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCrntOfcCd(JSPUtil.getParameter(request, "crnt_ofc_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSInventoryByLessorAgmtINVO[]
	 */
	public MGSInventoryByLessorAgmtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSInventoryByLessorAgmtINVO[]
	 */
	public MGSInventoryByLessorAgmtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSInventoryByLessorAgmtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqTpszCdUmg = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_umg", length));
			String[] eqTpszCdClg = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_clg", length));
			String[] eqTpszCdTotal = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_total", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] crntOfcCd = (JSPUtil.getParameter(request, prefix	+ "crnt_ofc_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSInventoryByLessorAgmtINVO();
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqTpszCdUmg[i] != null)
					model.setEqTpszCdUmg(eqTpszCdUmg[i]);
				if (eqTpszCdClg[i] != null)
					model.setEqTpszCdClg(eqTpszCdClg[i]);
				if (eqTpszCdTotal[i] != null)
					model.setEqTpszCdTotal(eqTpszCdTotal[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (crntOfcCd[i] != null)
					model.setCrntOfcCd(crntOfcCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSInventoryByLessorAgmtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSInventoryByLessorAgmtINVO[]
	 */
	public MGSInventoryByLessorAgmtINVO[] getMGSInventoryByLessorAgmtINVOs(){
		MGSInventoryByLessorAgmtINVO[] vos = (MGSInventoryByLessorAgmtINVO[])models.toArray(new MGSInventoryByLessorAgmtINVO[models.size()]);
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
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdUmg = this.eqTpszCdUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdClg = this.eqTpszCdClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdTotal = this.eqTpszCdTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntOfcCd = this.crntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
