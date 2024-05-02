/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoolExpenseTrendMGTVO.java
*@FileTitle : PoolExpenseTrendMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.12 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PoolExpenseTrendMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PoolExpenseTrendMGTVO> models = new ArrayList<PoolExpenseTrendMGTVO>();
	
	/* Column Info */
	private String invAmount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String chssPoolNm = null;
	/* Column Info */
	private String debit = null;
	/* Column Info */
	private String credit = null;
	/* Column Info */
	private String estAmount = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PoolExpenseTrendMGTVO() {}

	public PoolExpenseTrendMGTVO(String ibflag, String pagerows, String chssPoolCd, String mvmtDt, String chssPoolNm, String estAmount, String invAmount, String credit, String debit) {
		this.invAmount = invAmount;
		this.ibflag = ibflag;
		this.chssPoolCd = chssPoolCd;
		this.chssPoolNm = chssPoolNm;
		this.debit = debit;
		this.credit = credit;
		this.estAmount = estAmount;
		this.mvmtDt = mvmtDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_amount", getInvAmount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("chss_pool_nm", getChssPoolNm());
		this.hashColumns.put("debit", getDebit());
		this.hashColumns.put("credit", getCredit());
		this.hashColumns.put("est_amount", getEstAmount());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_amount", "invAmount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("chss_pool_nm", "chssPoolNm");
		this.hashFields.put("debit", "debit");
		this.hashFields.put("credit", "credit");
		this.hashFields.put("est_amount", "estAmount");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invAmount
	 */
	public String getInvAmount() {
		return this.invAmount;
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return chssPoolNm
	 */
	public String getChssPoolNm() {
		return this.chssPoolNm;
	}
	
	/**
	 * Column Info
	 * @return debit
	 */
	public String getDebit() {
		return this.debit;
	}
	
	/**
	 * Column Info
	 * @return credit
	 */
	public String getCredit() {
		return this.credit;
	}
	
	/**
	 * Column Info
	 * @return estAmount
	 */
	public String getEstAmount() {
		return this.estAmount;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
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
	 * @param invAmount
	 */
	public void setInvAmount(String invAmount) {
		this.invAmount = invAmount;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param chssPoolNm
	 */
	public void setChssPoolNm(String chssPoolNm) {
		this.chssPoolNm = chssPoolNm;
	}
	
	/**
	 * Column Info
	 * @param debit
	 */
	public void setDebit(String debit) {
		this.debit = debit;
	}
	
	/**
	 * Column Info
	 * @param credit
	 */
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	/**
	 * Column Info
	 * @param estAmount
	 */
	public void setEstAmount(String estAmount) {
		this.estAmount = estAmount;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
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
		setInvAmount(JSPUtil.getParameter(request, "inv_amount", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setChssPoolNm(JSPUtil.getParameter(request, "chss_pool_nm", ""));
		setDebit(JSPUtil.getParameter(request, "debit", ""));
		setCredit(JSPUtil.getParameter(request, "credit", ""));
		setEstAmount(JSPUtil.getParameter(request, "est_amount", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoolExpenseTrendMGTVO[]
	 */
	public PoolExpenseTrendMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PoolExpenseTrendMGTVO[]
	 */
	public PoolExpenseTrendMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoolExpenseTrendMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invAmount = (JSPUtil.getParameter(request, prefix	+ "inv_amount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] chssPoolNm = (JSPUtil.getParameter(request, prefix	+ "chss_pool_nm", length));
			String[] debit = (JSPUtil.getParameter(request, prefix	+ "debit", length));
			String[] credit = (JSPUtil.getParameter(request, prefix	+ "credit", length));
			String[] estAmount = (JSPUtil.getParameter(request, prefix	+ "est_amount", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PoolExpenseTrendMGTVO();
				if (invAmount[i] != null)
					model.setInvAmount(invAmount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (chssPoolNm[i] != null)
					model.setChssPoolNm(chssPoolNm[i]);
				if (debit[i] != null)
					model.setDebit(debit[i]);
				if (credit[i] != null)
					model.setCredit(credit[i]);
				if (estAmount[i] != null)
					model.setEstAmount(estAmount[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoolExpenseTrendMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoolExpenseTrendMGTVO[]
	 */
	public PoolExpenseTrendMGTVO[] getPoolExpenseTrendMGTVOs(){
		PoolExpenseTrendMGTVO[] vos = (PoolExpenseTrendMGTVO[])models.toArray(new PoolExpenseTrendMGTVO[models.size()]);
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
		this.invAmount = this.invAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolNm = this.chssPoolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.debit = this.debit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.credit = this.credit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estAmount = this.estAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
