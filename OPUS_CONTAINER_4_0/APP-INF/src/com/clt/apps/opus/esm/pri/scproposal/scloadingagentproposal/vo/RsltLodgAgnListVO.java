/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltLodgAgnListVO.java
*@FileTitle : RsltLodgAgnListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.07 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltLodgAgnListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltLodgAgnListVO> models = new ArrayList<RsltLodgAgnListVO>();
	
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lodgAgnSeq = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String mnlInpFlg = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltLodgAgnListVO() {}

	public RsltLodgAgnListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String lodgAgnSeq, String custCntCd, String custSeq, String mnlInpFlg, String custNm, String custAddr, String custLocCd, String n1stCmncAmdtSeq, String effDt, String expDt, String prcProgStsCd, String srcInfoCd, String acptOfcCd, String acptDt, String acptUsrNm) {
		this.acptDt = acptDt;
		this.acptOfcCd = acptOfcCd;
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.acptUsrNm = acptUsrNm;
		this.svcScpCd = svcScpCd;
		this.srcInfoCd = srcInfoCd;
		this.custAddr = custAddr;
		this.custSeq = custSeq;
		this.custLocCd = custLocCd;
		this.pagerows = pagerows;
		this.prcProgStsCd = prcProgStsCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.lodgAgnSeq = lodgAgnSeq;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
		this.mnlInpFlg = mnlInpFlg;
		this.expDt = expDt;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_loc_cd", getCustLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lodg_agn_seq", getLodgAgnSeq());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("mnl_inp_flg", getMnlInpFlg());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_loc_cd", "custLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lodg_agn_seq", "lodgAgnSeq");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("mnl_inp_flg", "mnlInpFlg");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
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
	 * @return acptOfcCd
	 */
	public String getAcptOfcCd() {
		return this.acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return acptUsrNm
	 */
	public String getAcptUsrNm() {
		return this.acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custLocCd
	 */
	public String getCustLocCd() {
		return this.custLocCd;
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
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
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
	 * @return lodgAgnSeq
	 */
	public String getLodgAgnSeq() {
		return this.lodgAgnSeq;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlg
	 */
	public String getMnlInpFlg() {
		return this.mnlInpFlg;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @param acptOfcCd
	 */
	public void setAcptOfcCd(String acptOfcCd) {
		this.acptOfcCd = acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param acptUsrNm
	 */
	public void setAcptUsrNm(String acptUsrNm) {
		this.acptUsrNm = acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custLocCd
	 */
	public void setCustLocCd(String custLocCd) {
		this.custLocCd = custLocCd;
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
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
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
	 * @param lodgAgnSeq
	 */
	public void setLodgAgnSeq(String lodgAgnSeq) {
		this.lodgAgnSeq = lodgAgnSeq;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlg
	 */
	public void setMnlInpFlg(String mnlInpFlg) {
		this.mnlInpFlg = mnlInpFlg;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAcptDt(JSPUtil.getParameter(request, "acpt_dt", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, "acpt_ofc_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, "acpt_usr_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, "src_info_cd", ""));
		setCustAddr(JSPUtil.getParameter(request, "cust_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustLocCd(JSPUtil.getParameter(request, "cust_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, "prc_prog_sts_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLodgAgnSeq(JSPUtil.getParameter(request, "lodg_agn_seq", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setMnlInpFlg(JSPUtil.getParameter(request, "mnl_inp_flg", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltLodgAgnListVO[]
	 */
	public RsltLodgAgnListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltLodgAgnListVO[]
	 */
	public RsltLodgAgnListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltLodgAgnListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custLocCd = (JSPUtil.getParameter(request, prefix	+ "cust_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lodgAgnSeq = (JSPUtil.getParameter(request, prefix	+ "lodg_agn_seq", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] mnlInpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltLodgAgnListVO();
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custLocCd[i] != null)
					model.setCustLocCd(custLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lodgAgnSeq[i] != null)
					model.setLodgAgnSeq(lodgAgnSeq[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (mnlInpFlg[i] != null)
					model.setMnlInpFlg(mnlInpFlg[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltLodgAgnListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltLodgAgnListVO[]
	 */
	public RsltLodgAgnListVO[] getRsltLodgAgnListVOs(){
		RsltLodgAgnListVO[] vos = (RsltLodgAgnListVO[])models.toArray(new RsltLodgAgnListVO[models.size()]);
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
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLocCd = this.custLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgAgnSeq = this.lodgAgnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg = this.mnlInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}