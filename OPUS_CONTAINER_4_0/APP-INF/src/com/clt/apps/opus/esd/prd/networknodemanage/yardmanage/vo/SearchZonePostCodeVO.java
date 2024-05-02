/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchZonePostCodeVO.java
*@FileTitle : SearchZonePostCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.07.22 노승배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchZonePostCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchZonePostCodeVO> models = new ArrayList<SearchZonePostCodeVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String znSeq = null;
	/* Column Info */
	private String nodeCode = null;
	/* Column Info */
	private String dstrNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchZonePostCodeVO() {}

	public SearchZonePostCodeVO(String ibflag, String pagerows, String znCd, String znSeq, String zipCd, String dstrNm, String nodeCode) {
		this.ibflag = ibflag;
		this.zipCd = zipCd;
		this.znCd = znCd;
		this.znSeq = znSeq;
		this.nodeCode = nodeCode;
		this.dstrNm = dstrNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("zn_seq", getZnSeq());
		this.hashColumns.put("node_code", getNodeCode());
		this.hashColumns.put("dstr_nm", getDstrNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("zn_seq", "znSeq");
		this.hashFields.put("node_code", "nodeCode");
		this.hashFields.put("dstr_nm", "dstrNm");
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
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
	}
	
	/**
	 * Column Info
	 * @return znSeq
	 */
	public String getZnSeq() {
		return this.znSeq;
	}
	
	/**
	 * Column Info
	 * @return nodeCode
	 */
	public String getNodeCode() {
		return this.nodeCode;
	}
	
	/**
	 * Column Info
	 * @return dstrNm
	 */
	public String getDstrNm() {
		return this.dstrNm;
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
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
	}
	
	/**
	 * Column Info
	 * @param znSeq
	 */
	public void setZnSeq(String znSeq) {
		this.znSeq = znSeq;
	}
	
	/**
	 * Column Info
	 * @param nodeCode
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	
	/**
	 * Column Info
	 * @param dstrNm
	 */
	public void setDstrNm(String dstrNm) {
		this.dstrNm = dstrNm;
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
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setZnCd(JSPUtil.getParameter(request, "zn_cd", ""));
		setZnSeq(JSPUtil.getParameter(request, "zn_seq", ""));
		setNodeCode(JSPUtil.getParameter(request, "node_code", ""));
		setDstrNm(JSPUtil.getParameter(request, "dstr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchZonePostCodeVO[]
	 */
	public SearchZonePostCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchZonePostCodeVO[]
	 */
	public SearchZonePostCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchZonePostCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd", length));
			String[] znSeq = (JSPUtil.getParameter(request, prefix	+ "zn_seq", length));
			String[] nodeCode = (JSPUtil.getParameter(request, prefix	+ "node_code", length));
			String[] dstrNm = (JSPUtil.getParameter(request, prefix	+ "dstr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchZonePostCodeVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (znSeq[i] != null)
					model.setZnSeq(znSeq[i]);
				if (nodeCode[i] != null)
					model.setNodeCode(nodeCode[i]);
				if (dstrNm[i] != null)
					model.setDstrNm(dstrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchZonePostCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchZonePostCodeVO[]
	 */
	public SearchZonePostCodeVO[] getSearchZonePostCodeVOs(){
		SearchZonePostCodeVO[] vos = (SearchZonePostCodeVO[])models.toArray(new SearchZonePostCodeVO[models.size()]);
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
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znSeq = this.znSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeCode = this.nodeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstrNm = this.dstrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
