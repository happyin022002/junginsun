/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInputByBLNoVO.java
*@FileTitle : ARInvoiceInputByBLNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.08 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceInputByBLNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceInputByBLNoVO> models = new ArrayList<ARInvoiceInputByBLNoVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String revType = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invDupFlg = null;
	/* Column Info */
	private String loginOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceInputByBLNoVO() {}

	public ARInvoiceInputByBLNoVO(String ibflag, String pagerows, String blSrcNo, String bkgNo, String blTpCd, String office, String revType, String invDupFlg, String loginOfcCd) {
		this.office = office;
		this.blSrcNo = blSrcNo;
		this.revType = revType;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.blTpCd = blTpCd;
		this.pagerows = pagerows;
		this.invDupFlg = invDupFlg;
		this.loginOfcCd = loginOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("rev_type", getRevType());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_dup_flg", getInvDupFlg());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_dup_flg", "invDupFlg");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return revType
	 */
	public String getRevType() {
		return this.revType;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param revType
	 */
	public void setRevType(String revType) {
		this.revType = revType;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getInvDupFlg() {
		return invDupFlg;
	}

	public void setInvDupFlg(String invDupFlg) {
		this.invDupFlg = invDupFlg;
	}

	public String getLoginOfcCd() {
		return loginOfcCd;
	}

	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setRevType(JSPUtil.getParameter(request, "rev_type", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvDupFlg(JSPUtil.getParameter(request, "inv_dup_flg", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, "login_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceInputByBLNoVO[]
	 */
	public ARInvoiceInputByBLNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceInputByBLNoVO[]
	 */
	public ARInvoiceInputByBLNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceInputByBLNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] revType = (JSPUtil.getParameter(request, prefix	+ "rev_type".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] invDupFlg = (JSPUtil.getParameter(request, prefix	+ "inv_dup_flg".trim(), length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceInputByBLNoVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (revType[i] != null)
					model.setRevType(revType[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invDupFlg[i] != null)
					model.setInvDupFlg(invDupFlg[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceInputByBLNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceInputByBLNoVO[]
	 */
	public ARInvoiceInputByBLNoVO[] getARInvoiceInputByBLNoVOs(){
		ARInvoiceInputByBLNoVO[] vos = (ARInvoiceInputByBLNoVO[])models.toArray(new ARInvoiceInputByBLNoVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType = this.revType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDupFlg = this.invDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
