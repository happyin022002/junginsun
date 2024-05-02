/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IntgCustSearchVO.java
*@FileTitle : IntgCustSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class IntgCustSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IntgCustSearchVO> models = new ArrayList<IntgCustSearchVO>();
	
	/* Column Info */
	private String custSeqIb = null;
	/* Column Info */
	private String custStsCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String custLglEngNmIb = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loginOfcCd = null;
	/* Column Info */
	private String custCntCdIb = null;
	/* Column Info */
	private String ctyCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custCntCdExt = null;
	/* Column Info */
	private String ofcCdIb = null;
	
	/* Column Info */
	private String steCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IntgCustSearchVO() {}
/**
 * 
 * @param ibflag
 * @param pagerows
 * @param custSeq
 * @param custStsCd
 * @param custLglEngNm
 * @param ofcCd
 * @param ctyCd
 * @param stsCd
 * @param custCntCd
 * @param custCntCdIb
 * @param custSeqIb
 * @param custLglEngNmIb
 * @param loginOfcCd
 * @param steCd
 */
	public IntgCustSearchVO(String ibflag, String pagerows, String custSeq, String custStsCd, String custLglEngNm, String ofcCd, String ctyCd, String stsCd, String custCntCd, String custCntCdIb, String custSeqIb, String custLglEngNmIb, String loginOfcCd, String custCntCdExt, String ofcCdIb, String steCd) {
		this.custSeqIb = custSeqIb;
		this.custStsCd = custStsCd;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.stsCd = stsCd;
		this.custLglEngNmIb = custLglEngNmIb;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.loginOfcCd = loginOfcCd;
		this.custCntCdIb = custCntCdIb;
		this.ctyCd = ctyCd;
		this.custCntCd = custCntCd;
		this.custCntCdExt = custCntCdExt;
		this.ofcCdIb = ofcCdIb;
		this.steCd = steCd;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_seq_ib", getCustSeqIb());
		this.hashColumns.put("cust_sts_cd", getCustStsCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("cust_lgl_eng_nm_ib", getCustLglEngNmIb());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		this.hashColumns.put("cust_cnt_cd_ib", getCustCntCdIb());
		this.hashColumns.put("cty_cd", getCtyCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_cnt_cd_ext", getCustCntCdExt());
		this.hashColumns.put("ofc_cd_ib", getOfcCdIb());
		this.hashColumns.put("ste_cd", getSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_seq_ib", "custSeqIb");
		this.hashFields.put("cust_sts_cd", "custStsCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("cust_lgl_eng_nm_ib", "custLglEngNmIb");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("cust_cnt_cd_ib", "custCntCdIb");
		this.hashFields.put("cty_cd", "ctyCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_cnt_cd_ext", "custCntCdExt");
		this.hashFields.put("ofc_cd_ib", "ofcCdIb");
		this.hashFields.put("ste_cd", "steCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return custSeqIb
	 */
	public String getCustSeqIb() {
		return this.custSeqIb;
	}
	
	/**
	 * Column Info
	 * @return custStsCd
	 */
	public String getCustStsCd() {
		return this.custStsCd;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNmIb
	 */
	public String getCustLglEngNmIb() {
		return this.custLglEngNmIb;
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
	 * @return loginOfcCd
	 */
	public String getLoginOfcCd() {
		return this.loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCdIb
	 */
	public String getCustCntCdIb() {
		return this.custCntCdIb;
	}
	
	/**
	 * Column Info
	 * @return ctyCd
	 */
	public String getCtyCd() {
		return this.ctyCd;
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
	 * @return custCntCdExt
	 */
	public String getCustCntCdExt() {
		return this.custCntCdExt;
	}	
	/**
	 * Column Info
	 * @return ofcCdIb
	 */
	public String getOfcCdIb() {
		return this.ofcCdIb;
	}	
	/**
	 * Column Info
	 * @param custSeqIb
	 */
	public void setCustSeqIb(String custSeqIb) {
		this.custSeqIb = custSeqIb;
	}
	
	/**
	 * Column Info
	 * @param custStsCd
	 */
	public void setCustStsCd(String custStsCd) {
		this.custStsCd = custStsCd;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNmIb
	 */
	public void setCustLglEngNmIb(String custLglEngNmIb) {
		this.custLglEngNmIb = custLglEngNmIb;
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
	 * @param loginOfcCd
	 */
	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCdIb
	 */
	public void setCustCntCdIb(String custCntCdIb) {
		this.custCntCdIb = custCntCdIb;
	}
	
	/**
	 * Column Info
	 * @param ctyCd
	 */
	public void setCtyCd(String ctyCd) {
		this.ctyCd = ctyCd;
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
	 * @param custCntCdExt
	 */
	public void setcustCntCdExt(String custCntCdExt) {
		this.custCntCdExt = custCntCdExt;
	}	
	/**
	 * Column Info
	 * @param custCntCdExt
	 */
	public void setOfcCdIb(String ofcCdIb) {
		this.ofcCdIb = ofcCdIb;
	}	
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustSeqIb(JSPUtil.getParameter(request, "cust_seq_ib", ""));
		setCustStsCd(JSPUtil.getParameter(request, "cust_sts_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setCustLglEngNmIb(JSPUtil.getParameter(request, "cust_lgl_eng_nm_ib", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, "login_ofc_cd", ""));
		setCustCntCdIb(JSPUtil.getParameter(request, "cust_cnt_cd_ib", ""));
		setCtyCd(JSPUtil.getParameter(request, "cty_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setcustCntCdExt(JSPUtil.getParameter(request, "cust_cnt_cd_ext", ""));
		setOfcCdIb(JSPUtil.getParameter(request, "ofc_cd_ib", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IntgCustSearchVO[]
	 */
	public IntgCustSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IntgCustSearchVO[]
	 */
	public IntgCustSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IntgCustSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custSeqIb = (JSPUtil.getParameter(request, prefix	+ "cust_seq_ib", length));
			String[] custStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_sts_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] custLglEngNmIb = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm_ib", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd", length));
			String[] custCntCdIb = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd_ib", length));
			String[] ctyCd = (JSPUtil.getParameter(request, prefix	+ "cty_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custCntCdExt = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd_ext", length));
			String[] ofcCdIb = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_ib", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));			
			
			
			for (int i = 0; i < length; i++) {
				model = new IntgCustSearchVO();
				if (custSeqIb[i] != null)
					model.setCustSeqIb(custSeqIb[i]);
				if (custStsCd[i] != null)
					model.setCustStsCd(custStsCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (custLglEngNmIb[i] != null)
					model.setCustLglEngNmIb(custLglEngNmIb[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				if (custCntCdIb[i] != null)
					model.setCustCntCdIb(custCntCdIb[i]);
				if (ctyCd[i] != null)
					model.setCtyCd(ctyCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custCntCdExt[i] != null)
					model.setcustCntCdExt(custCntCdExt[i]);
				if (ofcCdIb[i] != null)
					model.setOfcCdIb(ofcCdIb[i]);
				if (steCd[i] != null)
					model.setOfcCdIb(steCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIntgCustSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IntgCustSearchVO[]
	 */
	public IntgCustSearchVO[] getIntgCustSearchVOs(){
		IntgCustSearchVO[] vos = (IntgCustSearchVO[])models.toArray(new IntgCustSearchVO[models.size()]);
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
		this.custSeqIb = this.custSeqIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStsCd = this.custStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNmIb = this.custLglEngNmIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdIb = this.custCntCdIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyCd = this.ctyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdExt = this.custCntCdExt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdIb = this.ofcCdIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}
}
