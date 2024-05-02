/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementMGTVO.java
*@FileTitle : AgreementMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.30 김창식 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo;

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
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgreementMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgreementMGTVO> models = new ArrayList<AgreementMGTVO>();
	
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String lstVerFlg = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtIssOfcCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String agmtVerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgreementMGTVO() {}

	public AgreementMGTVO(String ibflag, String pagerows, String agmtNo, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String eqKndCd, String lstVerFlg, String agmtIssOfcCd, String agmtRefNo, String currCd, String effDt, String expDt, String vndrSeq, String vndrLglEngNm, String agmtLstmCd, String chssPoolCd, String creDt) {
		this.agmtRefNo = agmtRefNo;
		this.lstVerFlg = lstVerFlg;
		this.chssPoolCd = chssPoolCd;
		this.currCd = currCd;
		this.agmtSeq = agmtSeq;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.agmtIssOfcCd = agmtIssOfcCd;
		this.effDt = effDt;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.expDt = expDt;
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
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
	 * Column Info
	 * @return lstVerFlg
	 */
	public String getLstVerFlg() {
		return this.lstVerFlg;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return agmtIssOfcCd
	 */
	public String getAgmtIssOfcCd() {
		return this.agmtIssOfcCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
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
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	

	/**
	 * Column Info
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param lstVerFlg
	 */
	public void setLstVerFlg(String lstVerFlg) {
		this.lstVerFlg = lstVerFlg;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param agmtIssOfcCd
	 */
	public void setAgmtIssOfcCd(String agmtIssOfcCd) {
		this.agmtIssOfcCd = agmtIssOfcCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
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
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setLstVerFlg(JSPUtil.getParameter(request, "lst_ver_flg", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request, "agmt_iss_ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementMGTVO[]
	 */
	public AgreementMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgreementMGTVO[]
	 */
	public AgreementMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgreementMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] lstVerFlg = (JSPUtil.getParameter(request, prefix	+ "lst_ver_flg", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_iss_ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgreementMGTVO();
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (lstVerFlg[i] != null)
					model.setLstVerFlg(lstVerFlg[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtIssOfcCd[i] != null)
					model.setAgmtIssOfcCd(agmtIssOfcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgreementMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgreementMGTVO[]
	 */
	public AgreementMGTVO[] getAgreementMGTVOs(){
		AgreementMGTVO[] vos = (AgreementMGTVO[])models.toArray(new AgreementMGTVO[models.size()]);
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
		this.lstVerFlg = this.lstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd = this.agmtIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
