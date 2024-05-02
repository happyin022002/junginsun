/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPropCustInfoVO.java
*@FileTitle : RsltPropCustInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.08.06 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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

public class RsltPropCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropCustInfoVO> models = new ArrayList<RsltPropCustInfoVO>();
	
	/* Column Info */
	private String respbSrepCd = null;
	/* Column Info */
	private String ctrtPtySgnTitNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String respbSlsOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String ctrtCustValSgm = null;
	/* Column Info */
	private String ctrtPtyAddr = null;
	/* Column Info */
	private String ctrtCustSrepNm = null;
	/* Column Info */
	private String ctrtPtySgnNm = null;
	/* Column Info */
	private String prcCtrtCustTpNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ctrtCustValSgmCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPropCustInfoVO() {}

	public RsltPropCustInfoVO(String ibflag, String pagerows, String custCntCd, String custSeq, String prcCtrtCustTpCd, String prcCtrtCustTpNm, String ctrtPtyNm, String ctrtPtyAddr, String ctrtCustValSgmCd, String ctrtCustValSgm, String respbSrepCd, String ctrtCustSrepNm, String respbSlsOfcCd, String ctrtPtySgnNm, String ctrtPtySgnTitNm) {
		this.respbSrepCd = respbSrepCd;
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.respbSlsOfcCd = respbSlsOfcCd;
		this.ibflag = ibflag;
		this.ctrtPtyNm = ctrtPtyNm;
		this.ctrtCustValSgm = ctrtCustValSgm;
		this.ctrtPtyAddr = ctrtPtyAddr;
		this.ctrtCustSrepNm = ctrtCustSrepNm;
		this.ctrtPtySgnNm = ctrtPtySgnNm;
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
		this.custCntCd = custCntCd;
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("respb_srep_cd", getRespbSrepCd());
		this.hashColumns.put("ctrt_pty_sgn_tit_nm", getCtrtPtySgnTitNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("respb_sls_ofc_cd", getRespbSlsOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("ctrt_cust_val_sgm", getCtrtCustValSgm());
		this.hashColumns.put("ctrt_pty_addr", getCtrtPtyAddr());
		this.hashColumns.put("ctrt_cust_srep_nm", getCtrtCustSrepNm());
		this.hashColumns.put("ctrt_pty_sgn_nm", getCtrtPtySgnNm());
		this.hashColumns.put("prc_ctrt_cust_tp_nm", getPrcCtrtCustTpNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ctrt_cust_val_sgm_cd", getCtrtCustValSgmCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("respb_srep_cd", "respbSrepCd");
		this.hashFields.put("ctrt_pty_sgn_tit_nm", "ctrtPtySgnTitNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("respb_sls_ofc_cd", "respbSlsOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("ctrt_cust_val_sgm", "ctrtCustValSgm");
		this.hashFields.put("ctrt_pty_addr", "ctrtPtyAddr");
		this.hashFields.put("ctrt_cust_srep_nm", "ctrtCustSrepNm");
		this.hashFields.put("ctrt_pty_sgn_nm", "ctrtPtySgnNm");
		this.hashFields.put("prc_ctrt_cust_tp_nm", "prcCtrtCustTpNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ctrt_cust_val_sgm_cd", "ctrtCustValSgmCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return respbSrepCd
	 */
	public String getRespbSrepCd() {
		return this.respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtySgnTitNm
	 */
	public String getCtrtPtySgnTitNm() {
		return this.ctrtPtySgnTitNm;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return respbSlsOfcCd
	 */
	public String getRespbSlsOfcCd() {
		return this.respbSlsOfcCd;
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
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgm
	 */
	public String getCtrtCustValSgm() {
		return this.ctrtCustValSgm;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyAddr
	 */
	public String getCtrtPtyAddr() {
		return this.ctrtPtyAddr;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepNm
	 */
	public String getCtrtCustSrepNm() {
		return this.ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtySgnNm
	 */
	public String getCtrtPtySgnNm() {
		return this.ctrtPtySgnNm;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpNm
	 */
	public String getPrcCtrtCustTpNm() {
		return this.prcCtrtCustTpNm;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustValSgmCd
	 */
	public String getCtrtCustValSgmCd() {
		return this.ctrtCustValSgmCd;
	}
	

	/**
	 * Column Info
	 * @param respbSrepCd
	 */
	public void setRespbSrepCd(String respbSrepCd) {
		this.respbSrepCd = respbSrepCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtySgnTitNm
	 */
	public void setCtrtPtySgnTitNm(String ctrtPtySgnTitNm) {
		this.ctrtPtySgnTitNm = ctrtPtySgnTitNm;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param respbSlsOfcCd
	 */
	public void setRespbSlsOfcCd(String respbSlsOfcCd) {
		this.respbSlsOfcCd = respbSlsOfcCd;
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
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgm
	 */
	public void setCtrtCustValSgm(String ctrtCustValSgm) {
		this.ctrtCustValSgm = ctrtCustValSgm;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyAddr
	 */
	public void setCtrtPtyAddr(String ctrtPtyAddr) {
		this.ctrtPtyAddr = ctrtPtyAddr;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepNm
	 */
	public void setCtrtCustSrepNm(String ctrtCustSrepNm) {
		this.ctrtCustSrepNm = ctrtCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtySgnNm
	 */
	public void setCtrtPtySgnNm(String ctrtPtySgnNm) {
		this.ctrtPtySgnNm = ctrtPtySgnNm;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtCustTpNm
	 */
	public void setPrcCtrtCustTpNm(String prcCtrtCustTpNm) {
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustValSgmCd
	 */
	public void setCtrtCustValSgmCd(String ctrtCustValSgmCd) {
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRespbSrepCd(JSPUtil.getParameter(request, "respb_srep_cd", ""));
		setCtrtPtySgnTitNm(JSPUtil.getParameter(request, "ctrt_pty_sgn_tit_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, "prc_ctrt_cust_tp_cd", ""));
		setRespbSlsOfcCd(JSPUtil.getParameter(request, "respb_sls_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setCtrtCustValSgm(JSPUtil.getParameter(request, "ctrt_cust_val_sgm", ""));
		setCtrtPtyAddr(JSPUtil.getParameter(request, "ctrt_pty_addr", ""));
		setCtrtCustSrepNm(JSPUtil.getParameter(request, "ctrt_cust_srep_nm", ""));
		setCtrtPtySgnNm(JSPUtil.getParameter(request, "ctrt_pty_sgn_nm", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request, "prc_ctrt_cust_tp_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCtrtCustValSgmCd(JSPUtil.getParameter(request, "ctrt_cust_val_sgm_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropCustInfoVO[]
	 */
	public RsltPropCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropCustInfoVO[]
	 */
	public RsltPropCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropCustInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] respbSrepCd = (JSPUtil.getParameter(request, prefix	+ "respb_srep_cd", length));
			String[] ctrtPtySgnTitNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_tit_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] respbSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_sls_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] ctrtCustValSgm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm", length));
			String[] ctrtPtyAddr = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_addr", length));
			String[] ctrtCustSrepNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_nm", length));
			String[] ctrtPtySgnNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_sgn_nm", length));
			String[] prcCtrtCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ctrtCustValSgmCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_val_sgm_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropCustInfoVO();
				if (respbSrepCd[i] != null)
					model.setRespbSrepCd(respbSrepCd[i]);
				if (ctrtPtySgnTitNm[i] != null)
					model.setCtrtPtySgnTitNm(ctrtPtySgnTitNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (respbSlsOfcCd[i] != null)
					model.setRespbSlsOfcCd(respbSlsOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (ctrtCustValSgm[i] != null)
					model.setCtrtCustValSgm(ctrtCustValSgm[i]);
				if (ctrtPtyAddr[i] != null)
					model.setCtrtPtyAddr(ctrtPtyAddr[i]);
				if (ctrtCustSrepNm[i] != null)
					model.setCtrtCustSrepNm(ctrtCustSrepNm[i]);
				if (ctrtPtySgnNm[i] != null)
					model.setCtrtPtySgnNm(ctrtPtySgnNm[i]);
				if (prcCtrtCustTpNm[i] != null)
					model.setPrcCtrtCustTpNm(prcCtrtCustTpNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ctrtCustValSgmCd[i] != null)
					model.setCtrtCustValSgmCd(ctrtCustValSgmCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropCustInfoVO[]
	 */
	public RsltPropCustInfoVO[] getRsltPropCustInfoVOs(){
		RsltPropCustInfoVO[] vos = (RsltPropCustInfoVO[])models.toArray(new RsltPropCustInfoVO[models.size()]);
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
		this.respbSrepCd = this.respbSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnTitNm = this.ctrtPtySgnTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSlsOfcCd = this.respbSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgm = this.ctrtCustValSgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyAddr = this.ctrtPtyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepNm = this.ctrtCustSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtySgnNm = this.ctrtPtySgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm = this.prcCtrtCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmCd = this.ctrtCustValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
