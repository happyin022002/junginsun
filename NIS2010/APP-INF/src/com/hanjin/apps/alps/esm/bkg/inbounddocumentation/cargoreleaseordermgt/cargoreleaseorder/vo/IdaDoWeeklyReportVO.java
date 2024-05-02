/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IdaDoWeeklyReportVO.java
*@FileTitle : IdaDoWeeklyReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.18 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IdaDoWeeklyReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IdaDoWeeklyReportVO> models = new ArrayList<IdaDoWeeklyReportVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String thirdWk = null;
	/* Column Info */
	private String dmdtPayTpCdDesc = null;
	/* Column Info */
	private String forthWk = null;
	/* Column Info */
	private String firstWk = null;
	/* Column Info */
	private String dmdtPayTpCd = null;
	/* Column Info */
	private String monthly = null;
	/* Column Info */
	private String fifthWk = null;
	/* Column Info */
	private String secondWk = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IdaDoWeeklyReportVO() {}

	public IdaDoWeeklyReportVO(String ibflag, String pagerows, String dmdtPayTpCd, String dmdtPayTpCdDesc, String firstWk, String secondWk, String thirdWk, String forthWk, String fifthWk, String monthly) {
		this.ibflag = ibflag;
		this.thirdWk = thirdWk;
		this.dmdtPayTpCdDesc = dmdtPayTpCdDesc;
		this.forthWk = forthWk;
		this.firstWk = firstWk;
		this.dmdtPayTpCd = dmdtPayTpCd;
		this.monthly = monthly;
		this.fifthWk = fifthWk;
		this.secondWk = secondWk;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("third_wk", getThirdWk());
		this.hashColumns.put("dmdt_pay_tp_cd_desc", getDmdtPayTpCdDesc());
		this.hashColumns.put("forth_wk", getForthWk());
		this.hashColumns.put("first_wk", getFirstWk());
		this.hashColumns.put("dmdt_pay_tp_cd", getDmdtPayTpCd());
		this.hashColumns.put("monthly", getMonthly());
		this.hashColumns.put("fifth_wk", getFifthWk());
		this.hashColumns.put("second_wk", getSecondWk());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("third_wk", "thirdWk");
		this.hashFields.put("dmdt_pay_tp_cd_desc", "dmdtPayTpCdDesc");
		this.hashFields.put("forth_wk", "forthWk");
		this.hashFields.put("first_wk", "firstWk");
		this.hashFields.put("dmdt_pay_tp_cd", "dmdtPayTpCd");
		this.hashFields.put("monthly", "monthly");
		this.hashFields.put("fifth_wk", "fifthWk");
		this.hashFields.put("second_wk", "secondWk");
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
	 * @return thirdWk
	 */
	public String getThirdWk() {
		return this.thirdWk;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayTpCdDesc
	 */
	public String getDmdtPayTpCdDesc() {
		return this.dmdtPayTpCdDesc;
	}
	
	/**
	 * Column Info
	 * @return forthWk
	 */
	public String getForthWk() {
		return this.forthWk;
	}
	
	/**
	 * Column Info
	 * @return firstWk
	 */
	public String getFirstWk() {
		return this.firstWk;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayTpCd
	 */
	public String getDmdtPayTpCd() {
		return this.dmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @return monthly
	 */
	public String getMonthly() {
		return this.monthly;
	}
	
	/**
	 * Column Info
	 * @return fifthWk
	 */
	public String getFifthWk() {
		return this.fifthWk;
	}
	
	/**
	 * Column Info
	 * @return secondWk
	 */
	public String getSecondWk() {
		return this.secondWk;
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
	 * @param thirdWk
	 */
	public void setThirdWk(String thirdWk) {
		this.thirdWk = thirdWk;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayTpCdDesc
	 */
	public void setDmdtPayTpCdDesc(String dmdtPayTpCdDesc) {
		this.dmdtPayTpCdDesc = dmdtPayTpCdDesc;
	}
	
	/**
	 * Column Info
	 * @param forthWk
	 */
	public void setForthWk(String forthWk) {
		this.forthWk = forthWk;
	}
	
	/**
	 * Column Info
	 * @param firstWk
	 */
	public void setFirstWk(String firstWk) {
		this.firstWk = firstWk;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayTpCd
	 */
	public void setDmdtPayTpCd(String dmdtPayTpCd) {
		this.dmdtPayTpCd = dmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @param monthly
	 */
	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}
	
	/**
	 * Column Info
	 * @param fifthWk
	 */
	public void setFifthWk(String fifthWk) {
		this.fifthWk = fifthWk;
	}
	
	/**
	 * Column Info
	 * @param secondWk
	 */
	public void setSecondWk(String secondWk) {
		this.secondWk = secondWk;
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
		setThirdWk(JSPUtil.getParameter(request, "third_wk", ""));
		setDmdtPayTpCdDesc(JSPUtil.getParameter(request, "dmdt_pay_tp_cd_desc", ""));
		setForthWk(JSPUtil.getParameter(request, "forth_wk", ""));
		setFirstWk(JSPUtil.getParameter(request, "first_wk", ""));
		setDmdtPayTpCd(JSPUtil.getParameter(request, "dmdt_pay_tp_cd", ""));
		setMonthly(JSPUtil.getParameter(request, "monthly", ""));
		setFifthWk(JSPUtil.getParameter(request, "fifth_wk", ""));
		setSecondWk(JSPUtil.getParameter(request, "second_wk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaDoWeeklyReportVO[]
	 */
	public IdaDoWeeklyReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaDoWeeklyReportVO[]
	 */
	public IdaDoWeeklyReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IdaDoWeeklyReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] thirdWk = (JSPUtil.getParameter(request, prefix	+ "third_wk", length));
			String[] dmdtPayTpCdDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_pay_tp_cd_desc", length));
			String[] forthWk = (JSPUtil.getParameter(request, prefix	+ "forth_wk", length));
			String[] firstWk = (JSPUtil.getParameter(request, prefix	+ "first_wk", length));
			String[] dmdtPayTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_pay_tp_cd", length));
			String[] monthly = (JSPUtil.getParameter(request, prefix	+ "monthly", length));
			String[] fifthWk = (JSPUtil.getParameter(request, prefix	+ "fifth_wk", length));
			String[] secondWk = (JSPUtil.getParameter(request, prefix	+ "second_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IdaDoWeeklyReportVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (thirdWk[i] != null)
					model.setThirdWk(thirdWk[i]);
				if (dmdtPayTpCdDesc[i] != null)
					model.setDmdtPayTpCdDesc(dmdtPayTpCdDesc[i]);
				if (forthWk[i] != null)
					model.setForthWk(forthWk[i]);
				if (firstWk[i] != null)
					model.setFirstWk(firstWk[i]);
				if (dmdtPayTpCd[i] != null)
					model.setDmdtPayTpCd(dmdtPayTpCd[i]);
				if (monthly[i] != null)
					model.setMonthly(monthly[i]);
				if (fifthWk[i] != null)
					model.setFifthWk(fifthWk[i]);
				if (secondWk[i] != null)
					model.setSecondWk(secondWk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIdaDoWeeklyReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IdaDoWeeklyReportVO[]
	 */
	public IdaDoWeeklyReportVO[] getIdaDoWeeklyReportVOs(){
		IdaDoWeeklyReportVO[] vos = (IdaDoWeeklyReportVO[])models.toArray(new IdaDoWeeklyReportVO[models.size()]);
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
		this.thirdWk = this.thirdWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayTpCdDesc = this.dmdtPayTpCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forthWk = this.forthWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstWk = this.firstWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayTpCd = this.dmdtPayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monthly = this.monthly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fifthWk = this.fifthWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.secondWk = this.secondWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
