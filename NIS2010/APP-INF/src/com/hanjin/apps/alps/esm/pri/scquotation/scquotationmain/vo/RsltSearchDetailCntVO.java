/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltSearchDetailCntVO.java
*@FileTitle : RsltSearchDetailCntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.26 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchDetailCntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchDetailCntVO> models = new ArrayList<RsltSearchDetailCntVO>();
	
	/* Column Info */
	private String grpLocCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rateSCnt = null;
	/* Column Info */
	private String rateCnt = null;
	/* Column Info */
	private String rateGCnt = null;
	/* Column Info */
	private String grpCmdtCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchDetailCntVO() {}

	public RsltSearchDetailCntVO(String ibflag, String pagerows, String grpLocCnt, String grpCmdtCnt, String rateCnt, String rateGCnt, String rateSCnt) {
		this.grpLocCnt = grpLocCnt;
		this.ibflag = ibflag;
		this.rateSCnt = rateSCnt;
		this.rateCnt = rateCnt;
		this.rateGCnt = rateGCnt;
		this.grpCmdtCnt = grpCmdtCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp_loc_cnt", getGrpLocCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate_s_cnt", getRateSCnt());
		this.hashColumns.put("rate_cnt", getRateCnt());
		this.hashColumns.put("rate_g_cnt", getRateGCnt());
		this.hashColumns.put("grp_cmdt_cnt", getGrpCmdtCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp_loc_cnt", "grpLocCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate_s_cnt", "rateSCnt");
		this.hashFields.put("rate_cnt", "rateCnt");
		this.hashFields.put("rate_g_cnt", "rateGCnt");
		this.hashFields.put("grp_cmdt_cnt", "grpCmdtCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grpLocCnt
	 */
	public String getGrpLocCnt() {
		return this.grpLocCnt;
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
	 * @return rateSCnt
	 */
	public String getRateSCnt() {
		return this.rateSCnt;
	}
	
	/**
	 * Column Info
	 * @return rateCnt
	 */
	public String getRateCnt() {
		return this.rateCnt;
	}
	
	/**
	 * Column Info
	 * @return rateGCnt
	 */
	public String getRateGCnt() {
		return this.rateGCnt;
	}
	
	/**
	 * Column Info
	 * @return grpCmdtCnt
	 */
	public String getGrpCmdtCnt() {
		return this.grpCmdtCnt;
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
	 * @param grpLocCnt
	 */
	public void setGrpLocCnt(String grpLocCnt) {
		this.grpLocCnt = grpLocCnt;
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
	 * @param rateSCnt
	 */
	public void setRateSCnt(String rateSCnt) {
		this.rateSCnt = rateSCnt;
	}
	
	/**
	 * Column Info
	 * @param rateCnt
	 */
	public void setRateCnt(String rateCnt) {
		this.rateCnt = rateCnt;
	}
	
	/**
	 * Column Info
	 * @param rateGCnt
	 */
	public void setRateGCnt(String rateGCnt) {
		this.rateGCnt = rateGCnt;
	}
	
	/**
	 * Column Info
	 * @param grpCmdtCnt
	 */
	public void setGrpCmdtCnt(String grpCmdtCnt) {
		this.grpCmdtCnt = grpCmdtCnt;
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
		setGrpLocCnt(JSPUtil.getParameter(request, "grp_loc_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRateSCnt(JSPUtil.getParameter(request, "rate_s_cnt", ""));
		setRateCnt(JSPUtil.getParameter(request, "rate_cnt", ""));
		setRateGCnt(JSPUtil.getParameter(request, "rate_g_cnt", ""));
		setGrpCmdtCnt(JSPUtil.getParameter(request, "grp_cmdt_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchDetailCntVO[]
	 */
	public RsltSearchDetailCntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchDetailCntVO[]
	 */
	public RsltSearchDetailCntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchDetailCntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grpLocCnt = (JSPUtil.getParameter(request, prefix	+ "grp_loc_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rateSCnt = (JSPUtil.getParameter(request, prefix	+ "rate_s_cnt", length));
			String[] rateCnt = (JSPUtil.getParameter(request, prefix	+ "rate_cnt", length));
			String[] rateGCnt = (JSPUtil.getParameter(request, prefix	+ "rate_g_cnt", length));
			String[] grpCmdtCnt = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchDetailCntVO();
				if (grpLocCnt[i] != null)
					model.setGrpLocCnt(grpLocCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rateSCnt[i] != null)
					model.setRateSCnt(rateSCnt[i]);
				if (rateCnt[i] != null)
					model.setRateCnt(rateCnt[i]);
				if (rateGCnt[i] != null)
					model.setRateGCnt(rateGCnt[i]);
				if (grpCmdtCnt[i] != null)
					model.setGrpCmdtCnt(grpCmdtCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchDetailCntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchDetailCntVO[]
	 */
	public RsltSearchDetailCntVO[] getRsltSearchDetailCntVOs(){
		RsltSearchDetailCntVO[] vos = (RsltSearchDetailCntVO[])models.toArray(new RsltSearchDetailCntVO[models.size()]);
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
		this.grpLocCnt = this.grpLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateSCnt = this.rateSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateCnt = this.rateCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateGCnt = this.rateGCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtCnt = this.grpCmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
