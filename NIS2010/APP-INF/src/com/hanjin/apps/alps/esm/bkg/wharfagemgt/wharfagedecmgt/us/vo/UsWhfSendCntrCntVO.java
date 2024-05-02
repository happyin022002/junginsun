/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWhfSendCntrCntVO.java
*@FileTitle : UsWhfSendCntrCntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.09.04 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsWhfSendCntrCntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsWhfSendCntrCntVO> models = new ArrayList<UsWhfSendCntrCntVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cnt45e = null;
	/* Column Info */
	private String cnt40e = null;
	/* Column Info */
	private String cnt40f = null;
	/* Column Info */
	private String cnt20f = null;
	/* Column Info */
	private String cnt20e = null;
	/* Column Info */
	private String cnt45f = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsWhfSendCntrCntVO() {}

	public UsWhfSendCntrCntVO(String ibflag, String pagerows, String seq, String cnt20f, String cnt20e, String cnt40f, String cnt40e, String cnt45f, String cnt45e) {
		this.ibflag = ibflag;
		this.seq = seq;
		this.cnt45e = cnt45e;
		this.cnt40e = cnt40e;
		this.cnt40f = cnt40f;
		this.cnt20f = cnt20f;
		this.cnt20e = cnt20e;
		this.cnt45f = cnt45f;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cnt_45e", getCnt45e());
		this.hashColumns.put("cnt_40e", getCnt40e());
		this.hashColumns.put("cnt_40f", getCnt40f());
		this.hashColumns.put("cnt_20f", getCnt20f());
		this.hashColumns.put("cnt_20e", getCnt20e());
		this.hashColumns.put("cnt_45f", getCnt45f());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cnt_45e", "cnt45e");
		this.hashFields.put("cnt_40e", "cnt40e");
		this.hashFields.put("cnt_40f", "cnt40f");
		this.hashFields.put("cnt_20f", "cnt20f");
		this.hashFields.put("cnt_20e", "cnt20e");
		this.hashFields.put("cnt_45f", "cnt45f");
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return cnt45e
	 */
	public String getCnt45e() {
		return this.cnt45e;
	}
	
	/**
	 * Column Info
	 * @return cnt40e
	 */
	public String getCnt40e() {
		return this.cnt40e;
	}
	
	/**
	 * Column Info
	 * @return cnt40f
	 */
	public String getCnt40f() {
		return this.cnt40f;
	}
	
	/**
	 * Column Info
	 * @return cnt20f
	 */
	public String getCnt20f() {
		return this.cnt20f;
	}
	
	/**
	 * Column Info
	 * @return cnt20e
	 */
	public String getCnt20e() {
		return this.cnt20e;
	}
	
	/**
	 * Column Info
	 * @return cnt45f
	 */
	public String getCnt45f() {
		return this.cnt45f;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param cnt45e
	 */
	public void setCnt45e(String cnt45e) {
		this.cnt45e = cnt45e;
	}
	
	/**
	 * Column Info
	 * @param cnt40e
	 */
	public void setCnt40e(String cnt40e) {
		this.cnt40e = cnt40e;
	}
	
	/**
	 * Column Info
	 * @param cnt40f
	 */
	public void setCnt40f(String cnt40f) {
		this.cnt40f = cnt40f;
	}
	
	/**
	 * Column Info
	 * @param cnt20f
	 */
	public void setCnt20f(String cnt20f) {
		this.cnt20f = cnt20f;
	}
	
	/**
	 * Column Info
	 * @param cnt20e
	 */
	public void setCnt20e(String cnt20e) {
		this.cnt20e = cnt20e;
	}
	
	/**
	 * Column Info
	 * @param cnt45f
	 */
	public void setCnt45f(String cnt45f) {
		this.cnt45f = cnt45f;
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
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setCnt45e(JSPUtil.getParameter(request, "cnt_45e", ""));
		setCnt40e(JSPUtil.getParameter(request, "cnt_40e", ""));
		setCnt40f(JSPUtil.getParameter(request, "cnt_40f", ""));
		setCnt20f(JSPUtil.getParameter(request, "cnt_20f", ""));
		setCnt20e(JSPUtil.getParameter(request, "cnt_20e", ""));
		setCnt45f(JSPUtil.getParameter(request, "cnt_45f", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsWhfSendCntrCntVO[]
	 */
	public UsWhfSendCntrCntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsWhfSendCntrCntVO[]
	 */
	public UsWhfSendCntrCntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsWhfSendCntrCntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cnt45e = (JSPUtil.getParameter(request, prefix	+ "cnt_45e", length));
			String[] cnt40e = (JSPUtil.getParameter(request, prefix	+ "cnt_40e", length));
			String[] cnt40f = (JSPUtil.getParameter(request, prefix	+ "cnt_40f", length));
			String[] cnt20f = (JSPUtil.getParameter(request, prefix	+ "cnt_20f", length));
			String[] cnt20e = (JSPUtil.getParameter(request, prefix	+ "cnt_20e", length));
			String[] cnt45f = (JSPUtil.getParameter(request, prefix	+ "cnt_45f", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsWhfSendCntrCntVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cnt45e[i] != null)
					model.setCnt45e(cnt45e[i]);
				if (cnt40e[i] != null)
					model.setCnt40e(cnt40e[i]);
				if (cnt40f[i] != null)
					model.setCnt40f(cnt40f[i]);
				if (cnt20f[i] != null)
					model.setCnt20f(cnt20f[i]);
				if (cnt20e[i] != null)
					model.setCnt20e(cnt20e[i]);
				if (cnt45f[i] != null)
					model.setCnt45f(cnt45f[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsWhfSendCntrCntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsWhfSendCntrCntVO[]
	 */
	public UsWhfSendCntrCntVO[] getUsWhfSendCntrCntVOs(){
		UsWhfSendCntrCntVO[] vos = (UsWhfSendCntrCntVO[])models.toArray(new UsWhfSendCntrCntVO[models.size()]);
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
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt45e = this.cnt45e .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt40e = this.cnt40e .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt40f = this.cnt40f .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt20f = this.cnt20f .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt20e = this.cnt20e .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt45f = this.cnt45f .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
