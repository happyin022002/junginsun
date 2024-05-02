/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCustomerInfoVO.java
*@FileTitle : SearchCustomerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.09 손윤석
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBkgCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorBkgCustVO> models = new ArrayList<KorBkgCustVO>();

	/* Column Info */
	private String cCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String cCustTel = null;
	/* Column Info */
	private String cCustCd = null;
	/* Column Info */
	private String cCustName = null;
	/* Column Info */
	private String cBcsTp = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorBkgCustVO() {}

	public KorBkgCustVO(String ibflag, String pagerows, String cBcsTp, String cCntCd, String cCustCd, String cCustName, String cCustAddr, String cCustTel) {
		this.cCntCd = cCntCd;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.cCustTel = cCustTel;
		this.cCustCd = cCustCd;
		this.cCustName = cCustName;
		this.cBcsTp = cBcsTp;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("c_cnt_cd", getCCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("c_cust_tel", getCCustTel());
		this.hashColumns.put("c_cust_cd", getCCustCd());
		this.hashColumns.put("c_cust_name", getCCustName());
		this.hashColumns.put("c_bcs_tp", getCBcsTp());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("c_cnt_cd", "cCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("c_cust_tel", "cCustTel");
		this.hashFields.put("c_cust_cd", "cCustCd");
		this.hashFields.put("c_cust_name", "cCustName");
		this.hashFields.put("c_bcs_tp", "cBcsTp");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cCntCd
	 */
	public String getCCntCd() {
		return this.cCntCd;
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
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}

	/**
	 * Column Info
	 * @return cCustTel
	 */
	public String getCCustTel() {
		return this.cCustTel;
	}

	/**
	 * Column Info
	 * @return cCustCd
	 */
	public String getCCustCd() {
		return this.cCustCd;
	}

	/**
	 * Column Info
	 * @return cCustName
	 */
	public String getCCustName() {
		return this.cCustName;
	}

	/**
	 * Column Info
	 * @return cBcsTp
	 */
	public String getCBcsTp() {
		return this.cBcsTp;
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
	 * @param cCntCd
	 */
	public void setCCntCd(String cCntCd) {
		this.cCntCd = cCntCd;
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
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}

	/**
	 * Column Info
	 * @param cCustTel
	 */
	public void setCCustTel(String cCustTel) {
		this.cCustTel = cCustTel;
	}

	/**
	 * Column Info
	 * @param cCustCd
	 */
	public void setCCustCd(String cCustCd) {
		this.cCustCd = cCustCd;
	}

	/**
	 * Column Info
	 * @param cCustName
	 */
	public void setCCustName(String cCustName) {
		this.cCustName = cCustName;
	}

	/**
	 * Column Info
	 * @param cBcsTp
	 */
	public void setCBcsTp(String cBcsTp) {
		this.cBcsTp = cBcsTp;
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
		setCCntCd(JSPUtil.getParameter(request, "c_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, "c_cust_addr", ""));
		setCCustTel(JSPUtil.getParameter(request, "c_cust_tel", ""));
		setCCustCd(JSPUtil.getParameter(request, "c_cust_cd", ""));
		setCCustName(JSPUtil.getParameter(request, "c_cust_name", ""));
		setCBcsTp(JSPUtil.getParameter(request, "c_bcs_tp", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCustomerInfoVO[]
	 */
	public KorBkgCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchCustomerInfoVO[]
	 */
	public KorBkgCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBkgCustVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cCntCd = (JSPUtil.getParameter(request, prefix	+ "c_cnt_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr".trim(), length));
			String[] cCustTel = (JSPUtil.getParameter(request, prefix	+ "c_cust_tel".trim(), length));
			String[] cCustCd = (JSPUtil.getParameter(request, prefix	+ "c_cust_cd".trim(), length));
			String[] cCustName = (JSPUtil.getParameter(request, prefix	+ "c_cust_name".trim(), length));
			String[] cBcsTp = (JSPUtil.getParameter(request, prefix	+ "c_bcs_tp".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new KorBkgCustVO();
				if (cCntCd[i] != null)
					model.setCCntCd(cCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (cCustTel[i] != null)
					model.setCCustTel(cCustTel[i]);
				if (cCustCd[i] != null)
					model.setCCustCd(cCustCd[i]);
				if (cCustName[i] != null)
					model.setCCustName(cCustName[i]);
				if (cBcsTp[i] != null)
					model.setCBcsTp(cBcsTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCustomerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCustomerInfoVO[]
	 */
	public KorBkgCustVO[] getSearchCustomerInfoVOs(){
		KorBkgCustVO[] vos = (KorBkgCustVO[])models.toArray(new KorBkgCustVO[models.size()]);
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
		this.cCntCd = this.cCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustTel = this.cCustTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCd = this.cCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustName = this.cCustName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBcsTp = this.cBcsTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
