/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HandlingOfcInputVO.java
*@FileTitle : HandlingOfcInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.03 전용진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HandlingOfcInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<HandlingOfcInputVO> models = new ArrayList<HandlingOfcInputVO>();

	/* Column Info */
	private String porcd = null;
	/* Column Info */
	private String bkgnosplit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custcntcd = null;
	/* Column Info */
	private String bkgno = null;
	/* Column Info */
	private String polcd = null;
	/* Column Info */
	private String custseq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public HandlingOfcInputVO() {}

	public HandlingOfcInputVO(String ibflag, String pagerows, String bkgno, String bkgnosplit, String custcntcd, String custseq, String polcd, String porcd) {
		this.porcd = porcd;
		this.bkgnosplit = bkgnosplit;
		this.ibflag = ibflag;
		this.custcntcd = custcntcd;
		this.bkgno = bkgno;
		this.polcd = polcd;
		this.custseq = custseq;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("porcd", getPorcd());
		this.hashColumns.put("bkgnosplit", getBkgnosplit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("custcntcd", getCustcntcd());
		this.hashColumns.put("bkgno", getBkgno());
		this.hashColumns.put("polcd", getPolcd());
		this.hashColumns.put("custseq", getCustseq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("porcd", "porcd");
		this.hashFields.put("bkgnosplit", "bkgnosplit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("custcntcd", "custcntcd");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("polcd", "polcd");
		this.hashFields.put("custseq", "custseq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return porcd
	 */
	public String getPorcd() {
		return this.porcd;
	}

	/**
	 * Column Info
	 * @return bkgnosplit
	 */
	public String getBkgnosplit() {
		return this.bkgnosplit;
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
	 * @return custcntcd
	 */
	public String getCustcntcd() {
		return this.custcntcd;
	}

	/**
	 * Column Info
	 * @return bkgno
	 */
	public String getBkgno() {
		return this.bkgno;
	}

	/**
	 * Column Info
	 * @return polcd
	 */
	public String getPolcd() {
		return this.polcd;
	}

	/**
	 * Column Info
	 * @return custseq
	 */
	public String getCustseq() {
		return this.custseq;
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
	 * @param porcd
	 */
	public void setPorcd(String porcd) {
		this.porcd = porcd;
	}

	/**
	 * Column Info
	 * @param bkgnosplit
	 */
	public void setBkgnosplit(String bkgnosplit) {
		this.bkgnosplit = bkgnosplit;
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
	 * @param custcntcd
	 */
	public void setCustcntcd(String custcntcd) {
		this.custcntcd = custcntcd;
	}

	/**
	 * Column Info
	 * @param bkgno
	 */
	public void setBkgno(String bkgno) {
		this.bkgno = bkgno;
	}

	/**
	 * Column Info
	 * @param polcd
	 */
	public void setPolcd(String polcd) {
		this.polcd = polcd;
	}

	/**
	 * Column Info
	 * @param custseq
	 */
	public void setCustseq(String custseq) {
		this.custseq = custseq;
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
		setPorcd(JSPUtil.getParameter(request, "porcd", ""));
		setBkgnosplit(JSPUtil.getParameter(request, "bkgnosplit", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustcntcd(JSPUtil.getParameter(request, "custcntcd", ""));
		setBkgno(JSPUtil.getParameter(request, "bkgno", ""));
		setPolcd(JSPUtil.getParameter(request, "polcd", ""));
		setCustseq(JSPUtil.getParameter(request, "custseq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HandlingOfcInputVO[]
	 */
	public HandlingOfcInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return HandlingOfcInputVO[]
	 */
	public HandlingOfcInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HandlingOfcInputVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] porcd = (JSPUtil.getParameter(request, prefix	+ "porcd".trim(), length));
			String[] bkgnosplit = (JSPUtil.getParameter(request, prefix	+ "bkgnosplit".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custcntcd = (JSPUtil.getParameter(request, prefix	+ "custcntcd".trim(), length));
			String[] bkgno = (JSPUtil.getParameter(request, prefix	+ "bkgno".trim(), length));
			String[] polcd = (JSPUtil.getParameter(request, prefix	+ "polcd".trim(), length));
			String[] custseq = (JSPUtil.getParameter(request, prefix	+ "custseq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new HandlingOfcInputVO();
				if (porcd[i] != null)
					model.setPorcd(porcd[i]);
				if (bkgnosplit[i] != null)
					model.setBkgnosplit(bkgnosplit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custcntcd[i] != null)
					model.setCustcntcd(custcntcd[i]);
				if (bkgno[i] != null)
					model.setBkgno(bkgno[i]);
				if (polcd[i] != null)
					model.setPolcd(polcd[i]);
				if (custseq[i] != null)
					model.setCustseq(custseq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHandlingOfcInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HandlingOfcInputVO[]
	 */
	public HandlingOfcInputVO[] getHandlingOfcInputVOs(){
		HandlingOfcInputVO[] vos = (HandlingOfcInputVO[])models.toArray(new HandlingOfcInputVO[models.size()]);
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
		this.porcd = this.porcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnosplit = this.bkgnosplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custcntcd = this.custcntcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno = this.bkgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polcd = this.polcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custseq = this.custseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
