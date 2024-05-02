/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPaymentSlipListVO.java
*@FileTitle : SearchPaymentSlipListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.01 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPaymentSlipListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPaymentSlipListVO> models = new ArrayList<SearchPaymentSlipListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpSeqNum = null;
	/* Column Info */
	private String bunkerVvd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String slpEffDt = null;
	/* Column Info */
	private String keyNumber = null;
	/* Column Info */
	private String slpLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPaymentSlipListVO() {}

	public SearchPaymentSlipListVO(String ibflag, String pagerows, String slpSeqNum, String acctCd, String vndrSeq, String ctrCd, String slpLocCd, String slpEffDt, String csrAmt, String bunkerVvd, String keyNumber, String csrDesc) {
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.vndrSeq = vndrSeq;
		this.csrDesc = csrDesc;
		this.acctCd = acctCd;
		this.slpSeqNum = slpSeqNum;
		this.bunkerVvd = bunkerVvd;
		this.csrAmt = csrAmt;
		this.slpEffDt = slpEffDt;
		this.keyNumber = keyNumber;
		this.slpLocCd = slpLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_seq_num", getSlpSeqNum());
		this.hashColumns.put("bunker_vvd", getBunkerVvd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("slp_eff_dt", getSlpEffDt());
		this.hashColumns.put("key_number", getKeyNumber());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_seq_num", "slpSeqNum");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("slp_eff_dt", "slpEffDt");
		this.hashFields.put("key_number", "keyNumber");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
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
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNum
	 */
	public String getSlpSeqNum() {
		return this.slpSeqNum;
	}
	
	/**
	 * Column Info
	 * @return bunkerVvd
	 */
	public String getBunkerVvd() {
		return this.bunkerVvd;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return slpEffDt
	 */
	public String getSlpEffDt() {
		return this.slpEffDt;
	}
	
	/**
	 * Column Info
	 * @return keyNumber
	 */
	public String getKeyNumber() {
		return this.keyNumber;
	}
	
	/**
	 * Column Info
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
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
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNum
	 */
	public void setSlpSeqNum(String slpSeqNum) {
		this.slpSeqNum = slpSeqNum;
	}
	
	/**
	 * Column Info
	 * @param bunkerVvd
	 */
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param slpEffDt
	 */
	public void setSlpEffDt(String slpEffDt) {
		this.slpEffDt = slpEffDt;
	}
	
	/**
	 * Column Info
	 * @param keyNumber
	 */
	public void setKeyNumber(String keyNumber) {
		this.keyNumber = keyNumber;
	}
	
	/**
	 * Column Info
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setSlpSeqNum(JSPUtil.getParameter(request, "slp_seq_num", ""));
		setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setSlpEffDt(JSPUtil.getParameter(request, "slp_eff_dt", ""));
		setKeyNumber(JSPUtil.getParameter(request, "key_number", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPaymentSlipListVO[]
	 */
	public SearchPaymentSlipListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPaymentSlipListVO[]
	 */
	public SearchPaymentSlipListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPaymentSlipListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpSeqNum = (JSPUtil.getParameter(request, prefix	+ "slp_seq_num", length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] slpEffDt = (JSPUtil.getParameter(request, prefix	+ "slp_eff_dt", length));
			String[] keyNumber = (JSPUtil.getParameter(request, prefix	+ "key_number", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPaymentSlipListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpSeqNum[i] != null)
					model.setSlpSeqNum(slpSeqNum[i]);
				if (bunkerVvd[i] != null)
					model.setBunkerVvd(bunkerVvd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (slpEffDt[i] != null)
					model.setSlpEffDt(slpEffDt[i]);
				if (keyNumber[i] != null)
					model.setKeyNumber(keyNumber[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPaymentSlipListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPaymentSlipListVO[]
	 */
	public SearchPaymentSlipListVO[] getSearchPaymentSlipListVOs(){
		SearchPaymentSlipListVO[] vos = (SearchPaymentSlipListVO[])models.toArray(new SearchPaymentSlipListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNum = this.slpSeqNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd = this.bunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpEffDt = this.slpEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyNumber = this.keyNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
