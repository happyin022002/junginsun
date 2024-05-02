/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RefNoVO.java
*@FileTitle : RefNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.27 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RefNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RefNoVO> models = new ArrayList<RefNoVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cpyDescFlg = null;
	/* Column Info */
	private String refSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgRefTpNm = null;
	/* Column Info */
	private String bkgRefTpCd = null;
	/* Column Info */
	private String custRefNoCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RefNoVO() {}

	public RefNoVO(String ibflag, String pagerows, String bkgRefTpCd, String bkgRefTpNm, String refSeq, String custRefNoCtnt, String cpyDescFlg, String bkgNo) {
		this.bkgNo = bkgNo;
		this.cpyDescFlg = cpyDescFlg;
		this.refSeq = refSeq;
		this.ibflag = ibflag;
		this.bkgRefTpNm = bkgRefTpNm;
		this.bkgRefTpCd = bkgRefTpCd;
		this.custRefNoCtnt = custRefNoCtnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cpy_desc_flg", getCpyDescFlg());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ref_tp_nm", getBkgRefTpNm());
		this.hashColumns.put("bkg_ref_tp_cd", getBkgRefTpCd());
		this.hashColumns.put("cust_ref_no_ctnt", getCustRefNoCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cpy_desc_flg", "cpyDescFlg");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ref_tp_nm", "bkgRefTpNm");
		this.hashFields.put("bkg_ref_tp_cd", "bkgRefTpCd");
		this.hashFields.put("cust_ref_no_ctnt", "custRefNoCtnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cpyDescFlg
	 */
	public String getCpyDescFlg() {
		return this.cpyDescFlg;
	}
	
	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
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
	 * @return bkgRefTpNm
	 */
	public String getBkgRefTpNm() {
		return this.bkgRefTpNm;
	}
	
	/**
	 * Column Info
	 * @return bkgRefTpCd
	 */
	public String getBkgRefTpCd() {
		return this.bkgRefTpCd;
	}
	
	/**
	 * Column Info
	 * @return custRefNoCtnt
	 */
	public String getCustRefNoCtnt() {
		return this.custRefNoCtnt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cpyDescFlg
	 */
	public void setCpyDescFlg(String cpyDescFlg) {
		this.cpyDescFlg = cpyDescFlg;
	}
	
	/**
	 * Column Info
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
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
	 * @param bkgRefTpNm
	 */
	public void setBkgRefTpNm(String bkgRefTpNm) {
		this.bkgRefTpNm = bkgRefTpNm;
	}
	
	/**
	 * Column Info
	 * @param bkgRefTpCd
	 */
	public void setBkgRefTpCd(String bkgRefTpCd) {
		this.bkgRefTpCd = bkgRefTpCd;
	}
	
	/**
	 * Column Info
	 * @param custRefNoCtnt
	 */
	public void setCustRefNoCtnt(String custRefNoCtnt) {
		this.custRefNoCtnt = custRefNoCtnt;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCpyDescFlg(JSPUtil.getParameter(request, "cpy_desc_flg", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgRefTpNm(JSPUtil.getParameter(request, "bkg_ref_tp_nm", ""));
		setBkgRefTpCd(JSPUtil.getParameter(request, "bkg_ref_tp_cd", ""));
		setCustRefNoCtnt(JSPUtil.getParameter(request, "cust_ref_no_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RefNoVO[]
	 */
	public RefNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RefNoVO[]
	 */
	public RefNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RefNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cpyDescFlg = (JSPUtil.getParameter(request, prefix	+ "cpy_desc_flg", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgRefTpNm = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_tp_nm", length));
			String[] bkgRefTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_tp_cd", length));
			String[] custRefNoCtnt = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RefNoVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cpyDescFlg[i] != null)
					model.setCpyDescFlg(cpyDescFlg[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgRefTpNm[i] != null)
					model.setBkgRefTpNm(bkgRefTpNm[i]);
				if (bkgRefTpCd[i] != null)
					model.setBkgRefTpCd(bkgRefTpCd[i]);
				if (custRefNoCtnt[i] != null)
					model.setCustRefNoCtnt(custRefNoCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRefNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RefNoVO[]
	 */
	public RefNoVO[] getRefNoVOs(){
		RefNoVO[] vos = (RefNoVO[])models.toArray(new RefNoVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpyDescFlg = this.cpyDescFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefTpNm = this.bkgRefTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefTpCd = this.bkgRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNoCtnt = this.custRefNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
