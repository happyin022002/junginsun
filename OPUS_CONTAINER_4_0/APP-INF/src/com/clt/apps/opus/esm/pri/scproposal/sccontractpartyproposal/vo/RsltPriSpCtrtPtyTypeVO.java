/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpCtrtPtyTypeVO.java
*@FileTitle : RsltPriSpCtrtPtyTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.08 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpCtrtPtyTypeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpCtrtPtyTypeVO> models = new ArrayList<RsltPriSpCtrtPtyTypeVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcnt = null;
	/* Column Info */
	private String nm = null;
	/* Column Info */
	private String cd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpCtrtPtyTypeVO() {}

	public RsltPriSpCtrtPtyTypeVO(String ibflag, String pagerows, String cd, String nm, String rcnt) {
		this.ibflag = ibflag;
		this.rcnt = rcnt;
		this.nm = nm;
		this.cd = cd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcnt", getRcnt());
		this.hashColumns.put("nm", getNm());
		this.hashColumns.put("cd", getCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcnt", "rcnt");
		this.hashFields.put("nm", "nm");
		this.hashFields.put("cd", "cd");
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
	 * @return rcnt
	 */
	public String getRcnt() {
		return this.rcnt;
	}
	
	/**
	 * Column Info
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}
	
	/**
	 * Column Info
	 * @return cd
	 */
	public String getCd() {
		return this.cd;
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
	 * @param rcnt
	 */
	public void setRcnt(String rcnt) {
		this.rcnt = rcnt;
	}
	
	/**
	 * Column Info
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	/**
	 * Column Info
	 * @param cd
	 */
	public void setCd(String cd) {
		this.cd = cd;
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
		setRcnt(JSPUtil.getParameter(request, "rcnt", ""));
		setNm(JSPUtil.getParameter(request, "nm", ""));
		setCd(JSPUtil.getParameter(request, "cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpCtrtPtyTypeVO[]
	 */
	public RsltPriSpCtrtPtyTypeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpCtrtPtyTypeVO[]
	 */
	public RsltPriSpCtrtPtyTypeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpCtrtPtyTypeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rcnt = (JSPUtil.getParameter(request, prefix	+ "rcnt".trim(), length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm".trim(), length));
			String[] cd = (JSPUtil.getParameter(request, prefix	+ "cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpCtrtPtyTypeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcnt[i] != null)
					model.setRcnt(rcnt[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpCtrtPtyTypeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpCtrtPtyTypeVO[]
	 */
	public RsltPriSpCtrtPtyTypeVO[] getRsltPriSpCtrtPtyTypeVOs(){
		RsltPriSpCtrtPtyTypeVO[] vos = (RsltPriSpCtrtPtyTypeVO[])models.toArray(new RsltPriSpCtrtPtyTypeVO[models.size()]);
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
		this.rcnt = this.rcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
