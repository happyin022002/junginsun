/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustInfoVO.java
*@FileTitle : KorCustInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.03 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCustInfoVO> models = new ArrayList<KorCustInfoVO>();

	/* Column Info */
	private String sNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String nAddr = null;
	/* Column Info */
	private String nNm = null;
	/* Column Info */
	private String cNm = null;
	/* Column Info */
	private String cAddr = null;
	/* Column Info */
	private String sAddr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCustInfoVO() {}

	public KorCustInfoVO(String ibflag, String pagerows, String sNm, String sAddr, String cNm, String cAddr, String nNm, String nAddr, String custNm) {
		this.sNm = sNm;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.nAddr = nAddr;
		this.nNm = nNm;
		this.cNm = cNm;
		this.cAddr = cAddr;
		this.sAddr = sAddr;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_nm", getSNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("n_addr", getNAddr());
		this.hashColumns.put("n_nm", getNNm());
		this.hashColumns.put("c_nm", getCNm());
		this.hashColumns.put("c_addr", getCAddr());
		this.hashColumns.put("s_addr", getSAddr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_nm", "sNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("n_addr", "nAddr");
		this.hashFields.put("n_nm", "nNm");
		this.hashFields.put("c_nm", "cNm");
		this.hashFields.put("c_addr", "cAddr");
		this.hashFields.put("s_addr", "sAddr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return sNm
	 */
	public String getSNm() {
		return this.sNm;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}

	/**
	 * Column Info
	 * @return nAddr
	 */
	public String getNAddr() {
		return this.nAddr;
	}

	/**
	 * Column Info
	 * @return nNm
	 */
	public String getNNm() {
		return this.nNm;
	}

	/**
	 * Column Info
	 * @return cNm
	 */
	public String getCNm() {
		return this.cNm;
	}

	/**
	 * Column Info
	 * @return cAddr
	 */
	public String getCAddr() {
		return this.cAddr;
	}

	/**
	 * Column Info
	 * @return sAddr
	 */
	public String getSAddr() {
		return this.sAddr;
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
	 * @param sNm
	 */
	public void setSNm(String sNm) {
		this.sNm = sNm;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * Column Info
	 * @param nAddr
	 */
	public void setNAddr(String nAddr) {
		this.nAddr = nAddr;
	}

	/**
	 * Column Info
	 * @param nNm
	 */
	public void setNNm(String nNm) {
		this.nNm = nNm;
	}

	/**
	 * Column Info
	 * @param cNm
	 */
	public void setCNm(String cNm) {
		this.cNm = cNm;
	}

	/**
	 * Column Info
	 * @param cAddr
	 */
	public void setCAddr(String cAddr) {
		this.cAddr = cAddr;
	}

	/**
	 * Column Info
	 * @param sAddr
	 */
	public void setSAddr(String sAddr) {
		this.sAddr = sAddr;
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
		setSNm(JSPUtil.getParameter(request, "s_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setNAddr(JSPUtil.getParameter(request, "n_addr", ""));
		setNNm(JSPUtil.getParameter(request, "n_nm", ""));
		setCNm(JSPUtil.getParameter(request, "c_nm", ""));
		setCAddr(JSPUtil.getParameter(request, "c_addr", ""));
		setSAddr(JSPUtil.getParameter(request, "s_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCustInfoVO[]
	 */
	public KorCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCustInfoVO[]
	 */
	public KorCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCustInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sNm = (JSPUtil.getParameter(request, prefix	+ "s_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] nAddr = (JSPUtil.getParameter(request, prefix	+ "n_addr", length));
			String[] nNm = (JSPUtil.getParameter(request, prefix	+ "n_nm", length));
			String[] cNm = (JSPUtil.getParameter(request, prefix	+ "c_nm", length));
			String[] cAddr = (JSPUtil.getParameter(request, prefix	+ "c_addr", length));
			String[] sAddr = (JSPUtil.getParameter(request, prefix	+ "s_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new KorCustInfoVO();
				if (sNm[i] != null)
					model.setSNm(sNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (nAddr[i] != null)
					model.setNAddr(nAddr[i]);
				if (nNm[i] != null)
					model.setNNm(nNm[i]);
				if (cNm[i] != null)
					model.setCNm(cNm[i]);
				if (cAddr[i] != null)
					model.setCAddr(cAddr[i]);
				if (sAddr[i] != null)
					model.setSAddr(sAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCustInfoVO[]
	 */
	public KorCustInfoVO[] getKorCustInfoVOs(){
		KorCustInfoVO[] vos = (KorCustInfoVO[])models.toArray(new KorCustInfoVO[models.size()]);
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
		this.sNm = this.sNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nAddr = this.nAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nNm = this.nNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNm = this.cNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cAddr = this.cAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAddr = this.sAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
