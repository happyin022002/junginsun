/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltDmdtExptHisListVO.java
*@FileTitle : RsltDmdtExptHisListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.24 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltDmdtExptHisListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltDmdtExptHisListVO> models = new ArrayList<RsltDmdtExptHisListVO>();
	
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String prcProgStsNm = null;
	/* Column Info */
	private String srcInfoNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String dmdtFtTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltDmdtExptHisListVO() {}

	public RsltDmdtExptHisListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String srcInfoNm, String prcProgStsNm, String dmdtFtTpCd, String acptUsrNm, String acptDt, String n1stCmncAmdtSeq, String effDt, String expDt) {
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.acptDt = acptDt;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.acptUsrNm = acptUsrNm;
		this.prcProgStsNm = prcProgStsNm;
		this.srcInfoNm = srcInfoNm;
		this.expDt = expDt;
		this.dmdtFtTpCd = dmdtFtTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("prc_prog_sts_nm", getPrcProgStsNm());
		this.hashColumns.put("src_info_nm", getSrcInfoNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dmdt_ft_tp_cd", getDmdtFtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("prc_prog_sts_nm", "prcProgStsNm");
		this.hashFields.put("src_info_nm", "srcInfoNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dmdt_ft_tp_cd", "dmdtFtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return acptUsrNm
	 */
	public String getAcptUsrNm() {
		return this.acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsNm
	 */
	public String getPrcProgStsNm() {
		return this.prcProgStsNm;
	}
	
	/**
	 * Column Info
	 * @return srcInfoNm
	 */
	public String getSrcInfoNm() {
		return this.srcInfoNm;
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
	 * @return dmdtFtTpCd
	 */
	public String getDmdtFtTpCd() {
		return this.dmdtFtTpCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param acptUsrNm
	 */
	public void setAcptUsrNm(String acptUsrNm) {
		this.acptUsrNm = acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsNm
	 */
	public void setPrcProgStsNm(String prcProgStsNm) {
		this.prcProgStsNm = prcProgStsNm;
	}
	
	/**
	 * Column Info
	 * @param srcInfoNm
	 */
	public void setSrcInfoNm(String srcInfoNm) {
		this.srcInfoNm = srcInfoNm;
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
	 * @param dmdtFtTpCd
	 */
	public void setDmdtFtTpCd(String dmdtFtTpCd) {
		this.dmdtFtTpCd = dmdtFtTpCd;
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
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcptDt(JSPUtil.getParameter(request, "acpt_dt", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, "n1st_cmnc_amdt_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, "acpt_usr_nm", ""));
		setPrcProgStsNm(JSPUtil.getParameter(request, "prc_prog_sts_nm", ""));
		setSrcInfoNm(JSPUtil.getParameter(request, "src_info_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setDmdtFtTpCd(JSPUtil.getParameter(request, "dmdt_ft_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltDmdtExptHisListVO[]
	 */
	public RsltDmdtExptHisListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltDmdtExptHisListVO[]
	 */
	public RsltDmdtExptHisListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltDmdtExptHisListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] prcProgStsNm = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_nm", length));
			String[] srcInfoNm = (JSPUtil.getParameter(request, prefix	+ "src_info_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] dmdtFtTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ft_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltDmdtExptHisListVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (prcProgStsNm[i] != null)
					model.setPrcProgStsNm(prcProgStsNm[i]);
				if (srcInfoNm[i] != null)
					model.setSrcInfoNm(srcInfoNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (dmdtFtTpCd[i] != null)
					model.setDmdtFtTpCd(dmdtFtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltDmdtExptHisListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltDmdtExptHisListVO[]
	 */
	public RsltDmdtExptHisListVO[] getRsltDmdtExptHisListVOs(){
		RsltDmdtExptHisListVO[] vos = (RsltDmdtExptHisListVO[])models.toArray(new RsltDmdtExptHisListVO[models.size()]);
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
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsNm = this.prcProgStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoNm = this.srcInfoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtFtTpCd = this.dmdtFtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}