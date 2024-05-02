/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionCustomerVO.java
*@FileTitle : SCExceptionCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.29  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCExceptionCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCExceptionCustomerVO> models = new ArrayList<SCExceptionCustomerVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String actCustFlg = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCExceptionCustomerVO() {}

	public SCExceptionCustomerVO(String ibflag, String pagerows, String propNo, String scNo, String scExptVerSeq, String scExptGrpSeq, String custCntCd, String custSeq, String custCd, String custNm, String custTp, String actCustFlg, String creUsrId, String creOfcCd, String creDt, String updUsrId, String updOfcCd, String updDt) {
		this.updDt = updDt;
		this.actCustFlg = actCustFlg;
		this.custNm = custNm;
		this.creDt = creDt;
		this.scExptVerSeq = scExptVerSeq;
		this.scExptGrpSeq = scExptGrpSeq;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.custTp = custTp;
		this.creUsrId = creUsrId;
		this.propNo = propNo;
		this.creOfcCd = creOfcCd;
		this.scNo = scNo;
		this.custCd = custCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("act_cust_flg", getActCustFlg());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("act_cust_flg", "actCustFlg");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return actCustFlg
	 */
	public String getActCustFlg() {
		return this.actCustFlg;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param actCustFlg
	 */
	public void setActCustFlg(String actCustFlg) {
		this.actCustFlg = actCustFlg;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setActCustFlg(JSPUtil.getParameter(request, "act_cust_flg", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, "sc_expt_ver_seq", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, "sc_expt_grp_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustTp(JSPUtil.getParameter(request, "cust_tp", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCExceptionCustomerVO[]
	 */
	public SCExceptionCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCExceptionCustomerVO[]
	 */
	public SCExceptionCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCExceptionCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] actCustFlg = (JSPUtil.getParameter(request, prefix	+ "act_cust_flg", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCExceptionCustomerVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (actCustFlg[i] != null)
					model.setActCustFlg(actCustFlg[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCExceptionCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCExceptionCustomerVO[]
	 */
	public SCExceptionCustomerVO[] getSCExceptionCustomerVOs(){
		SCExceptionCustomerVO[] vos = (SCExceptionCustomerVO[])models.toArray(new SCExceptionCustomerVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFlg = this.actCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
