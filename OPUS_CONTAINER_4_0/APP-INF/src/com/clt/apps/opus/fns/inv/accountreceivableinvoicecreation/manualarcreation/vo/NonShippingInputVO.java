/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NonShippingInputVO.java
*@FileTitle : NonShippingInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.16 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NonShippingInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NonShippingInputVO> models = new ArrayList<NonShippingInputVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String slpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private int iPage = 1;
	/* Column Info */
	private String userOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NonShippingInputVO() {}

	public NonShippingInputVO(String ibflag, String pagerows, String office, String gubun, String fmDt, String toDt, String acctCd, String actCustCntCd, String actCustSeq, String creUsrId, String slpNo, String userOfcCd) {
		this.toDt = toDt;
		this.office = office;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.fmDt = fmDt;
		this.actCustSeq = actCustSeq;
		this.acctCd = acctCd;
		this.actCustCntCd = actCustCntCd;
		this.slpNo = slpNo;
		this.pagerows = pagerows;
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("slp_no", getSlpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("office", "office");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("slp_no", "slpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
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
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return slpNo
	 */
	public String getSlpNo() {
		return this.slpNo;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
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
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param slpNo
	 */
	public void setSlpNo(String slpNo) {
		this.slpNo = slpNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @param iPage the iPage to set
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}
	
	public String getUserOfcCd() {
		return userOfcCd;
	}

	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setSlpNo(JSPUtil.getParameter(request, "slp_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NonShippingInputVO[]
	 */
	public NonShippingInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NonShippingInputVO[]
	 */
	public NonShippingInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NonShippingInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] slpNo = (JSPUtil.getParameter(request, prefix	+ "slp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NonShippingInputVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (slpNo[i] != null)
					model.setSlpNo(slpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNonShippingInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NonShippingInputVO[]
	 */
	public NonShippingInputVO[] getNonShippingInputVOs(){
		NonShippingInputVO[] vos = (NonShippingInputVO[])models.toArray(new NonShippingInputVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpNo = this.slpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
