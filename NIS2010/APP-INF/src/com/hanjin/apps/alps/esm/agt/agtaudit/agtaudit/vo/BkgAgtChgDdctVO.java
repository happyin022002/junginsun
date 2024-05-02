/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgAgtChgDdctVO.java
*@FileTitle : BkgAgtChgDdctVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.09.24 이호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgAgtChgDdctVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgAgtChgDdctVO> models = new ArrayList<BkgAgtChgDdctVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgDdctLoclAmt = null;
	/* Column Info */
	private String chgDdctAmt = null;
	/* Column Info */
	private String bkgAgmtUtCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgAgtChgDdctVO() {}

	public BkgAgtChgDdctVO(String ibflag, String pagerows, String chgCd, String bkgAgmtUtCd, String currCd, String chgDdctLoclAmt, String chgDdctAmt) {
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.chgDdctLoclAmt = chgDdctLoclAmt;
		this.chgDdctAmt = chgDdctAmt;
		this.bkgAgmtUtCd = bkgAgmtUtCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_ddct_locl_amt", getChgDdctLoclAmt());
		this.hashColumns.put("chg_ddct_amt", getChgDdctAmt());
		this.hashColumns.put("bkg_agmt_ut_cd", getBkgAgmtUtCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_ddct_locl_amt", "chgDdctLoclAmt");
		this.hashFields.put("chg_ddct_amt", "chgDdctAmt");
		this.hashFields.put("bkg_agmt_ut_cd", "bkgAgmtUtCd");
		this.hashFields.put("chg_cd", "chgCd");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return chgDdctLoclAmt
	 */
	public String getChgDdctLoclAmt() {
		return this.chgDdctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return chgDdctAmt
	 */
	public String getChgDdctAmt() {
		return this.chgDdctAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgAgmtUtCd
	 */
	public String getBkgAgmtUtCd() {
		return this.bkgAgmtUtCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param chgDdctLoclAmt
	 */
	public void setChgDdctLoclAmt(String chgDdctLoclAmt) {
		this.chgDdctLoclAmt = chgDdctLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param chgDdctAmt
	 */
	public void setChgDdctAmt(String chgDdctAmt) {
		this.chgDdctAmt = chgDdctAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgAgmtUtCd
	 */
	public void setBkgAgmtUtCd(String bkgAgmtUtCd) {
		this.bkgAgmtUtCd = bkgAgmtUtCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setChgDdctLoclAmt(JSPUtil.getParameter(request, "chg_ddct_locl_amt", ""));
		setChgDdctAmt(JSPUtil.getParameter(request, "chg_ddct_amt", ""));
		setBkgAgmtUtCd(JSPUtil.getParameter(request, "bkg_agmt_ut_cd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgAgtChgDdctVO[]
	 */
	public BkgAgtChgDdctVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgAgtChgDdctVO[]
	 */
	public BkgAgtChgDdctVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgAgtChgDdctVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgDdctLoclAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ddct_locl_amt", length));
			String[] chgDdctAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ddct_amt", length));
			String[] bkgAgmtUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_agmt_ut_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgAgtChgDdctVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgDdctLoclAmt[i] != null)
					model.setChgDdctLoclAmt(chgDdctLoclAmt[i]);
				if (chgDdctAmt[i] != null)
					model.setChgDdctAmt(chgDdctAmt[i]);
				if (bkgAgmtUtCd[i] != null)
					model.setBkgAgmtUtCd(bkgAgmtUtCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgAgtChgDdctVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgAgtChgDdctVO[]
	 */
	public BkgAgtChgDdctVO[] getBkgAgtChgDdctVOs(){
		BkgAgtChgDdctVO[] vos = (BkgAgtChgDdctVO[])models.toArray(new BkgAgtChgDdctVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctLoclAmt = this.chgDdctLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctAmt = this.chgDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAgmtUtCd = this.bkgAgmtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
