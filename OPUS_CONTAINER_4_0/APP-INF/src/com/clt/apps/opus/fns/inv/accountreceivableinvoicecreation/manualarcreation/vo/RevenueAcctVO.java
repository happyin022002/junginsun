/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueAcctVO.java
*@FileTitle : RevenueAcctVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.02 박정진 
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

public class RevenueAcctVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevenueAcctVO> models = new ArrayList<RevenueAcctVO>();
	
	/* Column Info */
	private String revCd = null;
	/* Column Info */
	private String repChgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String acctEngNm = null;
	/* Column Info */
	private String acctKrnNm = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RevenueAcctVO() {}

	public RevenueAcctVO(String ibflag, String pagerows, String acctCd, String acctEngNm, String revCd, String chgCd, String repChgCd, String acctKrnNm) {
		this.revCd = revCd;
		this.repChgCd = repChgCd;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.acctEngNm = acctEngNm;
		this.acctKrnNm = acctKrnNm;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_cd", getRevCd());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("acct_krn_nm", getAcctKrnNm());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_cd", "revCd");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("acct_krn_nm", "acctKrnNm");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revCd
	 */
	public String getRevCd() {
		return this.revCd;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	
	/**
	 * Column Info
	 * @return acctKrnNm
	 */
	public String getAcctKrnNm() {
		return this.acctKrnNm;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @param revCd
	 */
	public void setRevCd(String revCd) {
		this.revCd = revCd;
	}
	
	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
	}
	
	/**
	 * Column Info
	 * @param acctKrnNm
	 */
	public void setAcctKrnNm(String acctKrnNm) {
		this.acctKrnNm = acctKrnNm;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
		setRevCd(JSPUtil.getParameter(request, "rev_cd", ""));
		setRepChgCd(JSPUtil.getParameter(request, "rep_chg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
		setAcctKrnNm(JSPUtil.getParameter(request, "acct_krn_nm", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevenueAcctVO[]
	 */
	public RevenueAcctVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevenueAcctVO[]
	 */
	public RevenueAcctVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevenueAcctVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revCd = (JSPUtil.getParameter(request, prefix	+ "rev_cd", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			String[] acctKrnNm = (JSPUtil.getParameter(request, prefix	+ "acct_krn_nm", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevenueAcctVO();
				if (revCd[i] != null)
					model.setRevCd(revCd[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (acctKrnNm[i] != null)
					model.setAcctKrnNm(acctKrnNm[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevenueAcctVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevenueAcctVO[]
	 */
	public RevenueAcctVO[] getRevenueAcctVOs(){
		RevenueAcctVO[] vos = (RevenueAcctVO[])models.toArray(new RevenueAcctVO[models.size()]);
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
		this.revCd = this.revCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctKrnNm = this.acctKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
