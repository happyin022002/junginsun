/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrInfoForFlatFileVO.java
*@FileTitle : CntrInfoForFlatFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.07.17 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrInfoForFlatFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrInfoForFlatFileVO> models = new ArrayList<CntrInfoForFlatFileVO>();
	
	/* Column Info */
	private String rdterm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrnbr = null;
	/* Column Info */
	private String cntrts = null;
	/* Column Info */
	private String ldmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrInfoForFlatFileVO() {}

	public CntrInfoForFlatFileVO(String ibflag, String pagerows, String rdterm, String cntrts, String cntrnbr, String ldmt) {
		this.rdterm = rdterm;
		this.ibflag = ibflag;
		this.cntrnbr = cntrnbr;
		this.cntrts = cntrts;
		this.ldmt = ldmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rdterm", getRdterm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("cntrts", getCntrts());
		this.hashColumns.put("ldmt", getLdmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rdterm", "rdterm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("cntrts", "cntrts");
		this.hashFields.put("ldmt", "ldmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rdterm
	 */
	public String getRdterm() {
		return this.rdterm;
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
	 * @return cntrnbr
	 */
	public String getCntrnbr() {
		return this.cntrnbr;
	}
	
	/**
	 * Column Info
	 * @return cntrts
	 */
	public String getCntrts() {
		return this.cntrts;
	}
	
	/**
	 * Column Info
	 * @return ldmt
	 */
	public String getLdmt() {
		return this.ldmt;
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
	 * @param rdterm
	 */
	public void setRdterm(String rdterm) {
		this.rdterm = rdterm;
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
	 * @param cntrnbr
	 */
	public void setCntrnbr(String cntrnbr) {
		this.cntrnbr = cntrnbr;
	}
	
	/**
	 * Column Info
	 * @param cntrts
	 */
	public void setCntrts(String cntrts) {
		this.cntrts = cntrts;
	}
	
	/**
	 * Column Info
	 * @param ldmt
	 */
	public void setLdmt(String ldmt) {
		this.ldmt = ldmt;
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
		setRdterm(JSPUtil.getParameter(request, "rdterm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrnbr(JSPUtil.getParameter(request, "cntrnbr", ""));
		setCntrts(JSPUtil.getParameter(request, "cntrts", ""));
		setLdmt(JSPUtil.getParameter(request, "ldmt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrInfoForFlatFileVO[]
	 */
	public CntrInfoForFlatFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrInfoForFlatFileVO[]
	 */
	public CntrInfoForFlatFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrInfoForFlatFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rdterm = (JSPUtil.getParameter(request, prefix	+ "rdterm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] cntrts = (JSPUtil.getParameter(request, prefix	+ "cntrts", length));
			String[] ldmt = (JSPUtil.getParameter(request, prefix	+ "ldmt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrInfoForFlatFileVO();
				if (rdterm[i] != null)
					model.setRdterm(rdterm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrnbr[i] != null)
					model.setCntrnbr(cntrnbr[i]);
				if (cntrts[i] != null)
					model.setCntrts(cntrts[i]);
				if (ldmt[i] != null)
					model.setLdmt(ldmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrInfoForFlatFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrInfoForFlatFileVO[]
	 */
	public CntrInfoForFlatFileVO[] getCntrInfoForFlatFileVOs(){
		CntrInfoForFlatFileVO[] vos = (CntrInfoForFlatFileVO[])models.toArray(new CntrInfoForFlatFileVO[models.size()]);
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
		this.rdterm = this.rdterm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrts = this.cntrts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldmt = this.ldmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
