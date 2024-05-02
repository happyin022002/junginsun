/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SoProcVO.java
*@FileTitle : SoProcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2009.09.11 최종혁 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SoProcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SoProcVO> models = new ArrayList<SoProcVO>();
	
	/* Column Info */
	private String actCustFctryPstCd = null;
	/* Column Info */
	private String actCustFctryPhnNo = null;
	/* Column Info */
	private String actCustEml = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String rtnValue = null;
	/* Column Info */
	private String actCustFctryNm = null;
	/* Column Info */
	private String actCustFctryPicNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCustFctryAddr = null;
	/* Column Info */
	private String actCustRmk = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String actCustAddrSeq = null;
	/* Column Info */
	private String actCustFctryFaxNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SoProcVO() {}

	public SoProcVO(String ibflag, String pagerows, String rtnValue, String actCustCntCd, String actCustSeq, String actCustAddrSeq, String actCustFctryPstCd, String actCustFctryNm, String actCustFctryAddr, String actCustFctryPhnNo, String actCustFctryFaxNo, String actCustFctryPicNo, String actCustEml, String actCustRmk) {
		this.actCustFctryPstCd = actCustFctryPstCd;
		this.actCustFctryPhnNo = actCustFctryPhnNo;
		this.actCustEml = actCustEml;
		this.actCustSeq = actCustSeq;
		this.rtnValue = rtnValue;
		this.actCustFctryNm = actCustFctryNm;
		this.actCustFctryPicNo = actCustFctryPicNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.actCustFctryAddr = actCustFctryAddr;
		this.actCustRmk = actCustRmk;
		this.actCustCntCd = actCustCntCd;
		this.actCustAddrSeq = actCustAddrSeq;
		this.actCustFctryFaxNo = actCustFctryFaxNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cust_fctry_pst_cd", getActCustFctryPstCd());
		this.hashColumns.put("act_cust_fctry_phn_no", getActCustFctryPhnNo());
		this.hashColumns.put("act_cust_eml", getActCustEml());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("rtn_value", getRtnValue());
		this.hashColumns.put("act_cust_fctry_nm", getActCustFctryNm());
		this.hashColumns.put("act_cust_fctry_pic_no", getActCustFctryPicNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cust_fctry_addr", getActCustFctryAddr());
		this.hashColumns.put("act_cust_rmk", getActCustRmk());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("act_cust_addr_seq", getActCustAddrSeq());
		this.hashColumns.put("act_cust_fctry_fax_no", getActCustFctryFaxNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cust_fctry_pst_cd", "actCustFctryPstCd");
		this.hashFields.put("act_cust_fctry_phn_no", "actCustFctryPhnNo");
		this.hashFields.put("act_cust_eml", "actCustEml");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("rtn_value", "rtnValue");
		this.hashFields.put("act_cust_fctry_nm", "actCustFctryNm");
		this.hashFields.put("act_cust_fctry_pic_no", "actCustFctryPicNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cust_fctry_addr", "actCustFctryAddr");
		this.hashFields.put("act_cust_rmk", "actCustRmk");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("act_cust_addr_seq", "actCustAddrSeq");
		this.hashFields.put("act_cust_fctry_fax_no", "actCustFctryFaxNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actCustFctryPstCd
	 */
	public String getActCustFctryPstCd() {
		return this.actCustFctryPstCd;
	}
	
	/**
	 * Column Info
	 * @return actCustFctryPhnNo
	 */
	public String getActCustFctryPhnNo() {
		return this.actCustFctryPhnNo;
	}
	
	/**
	 * Column Info
	 * @return actCustEml
	 */
	public String getActCustEml() {
		return this.actCustEml;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return rtnValue
	 */
	public String getRtnValue() {
		return this.rtnValue;
	}
	
	/**
	 * Column Info
	 * @return actCustFctryNm
	 */
	public String getActCustFctryNm() {
		return this.actCustFctryNm;
	}
	
	/**
	 * Column Info
	 * @return actCustFctryPicNo
	 */
	public String getActCustFctryPicNo() {
		return this.actCustFctryPicNo;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return actCustFctryAddr
	 */
	public String getActCustFctryAddr() {
		return this.actCustFctryAddr;
	}
	
	/**
	 * Column Info
	 * @return actCustRmk
	 */
	public String getActCustRmk() {
		return this.actCustRmk;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return actCustAddrSeq
	 */
	public String getActCustAddrSeq() {
		return this.actCustAddrSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustFctryFaxNo
	 */
	public String getActCustFctryFaxNo() {
		return this.actCustFctryFaxNo;
	}
	

	/**
	 * Column Info
	 * @param actCustFctryPstCd
	 */
	public void setActCustFctryPstCd(String actCustFctryPstCd) {
		this.actCustFctryPstCd = actCustFctryPstCd;
	}
	
	/**
	 * Column Info
	 * @param actCustFctryPhnNo
	 */
	public void setActCustFctryPhnNo(String actCustFctryPhnNo) {
		this.actCustFctryPhnNo = actCustFctryPhnNo;
	}
	
	/**
	 * Column Info
	 * @param actCustEml
	 */
	public void setActCustEml(String actCustEml) {
		this.actCustEml = actCustEml;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param rtnValue
	 */
	public void setRtnValue(String rtnValue) {
		this.rtnValue = rtnValue;
	}
	
	/**
	 * Column Info
	 * @param actCustFctryNm
	 */
	public void setActCustFctryNm(String actCustFctryNm) {
		this.actCustFctryNm = actCustFctryNm;
	}
	
	/**
	 * Column Info
	 * @param actCustFctryPicNo
	 */
	public void setActCustFctryPicNo(String actCustFctryPicNo) {
		this.actCustFctryPicNo = actCustFctryPicNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param actCustFctryAddr
	 */
	public void setActCustFctryAddr(String actCustFctryAddr) {
		this.actCustFctryAddr = actCustFctryAddr;
	}
	
	/**
	 * Column Info
	 * @param actCustRmk
	 */
	public void setActCustRmk(String actCustRmk) {
		this.actCustRmk = actCustRmk;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param actCustAddrSeq
	 */
	public void setActCustAddrSeq(String actCustAddrSeq) {
		this.actCustAddrSeq = actCustAddrSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustFctryFaxNo
	 */
	public void setActCustFctryFaxNo(String actCustFctryFaxNo) {
		this.actCustFctryFaxNo = actCustFctryFaxNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCustFctryPstCd(JSPUtil.getParameter(request, "act_cust_fctry_pst_cd", ""));
		setActCustFctryPhnNo(JSPUtil.getParameter(request, "act_cust_fctry_phn_no", ""));
		setActCustEml(JSPUtil.getParameter(request, "act_cust_eml", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setRtnValue(JSPUtil.getParameter(request, "rtn_value", ""));
		setActCustFctryNm(JSPUtil.getParameter(request, "act_cust_fctry_nm", ""));
		setActCustFctryPicNo(JSPUtil.getParameter(request, "act_cust_fctry_pic_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActCustFctryAddr(JSPUtil.getParameter(request, "act_cust_fctry_addr", ""));
		setActCustRmk(JSPUtil.getParameter(request, "act_cust_rmk", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setActCustAddrSeq(JSPUtil.getParameter(request, "act_cust_addr_seq", ""));
		setActCustFctryFaxNo(JSPUtil.getParameter(request, "act_cust_fctry_fax_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SoProcVO[]
	 */
	public SoProcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SoProcVO[]
	 */
	public SoProcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SoProcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCustFctryPstCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_fctry_pst_cd", length));
			String[] actCustFctryPhnNo = (JSPUtil.getParameter(request, prefix	+ "act_cust_fctry_phn_no", length));
			String[] actCustEml = (JSPUtil.getParameter(request, prefix	+ "act_cust_eml", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] rtnValue = (JSPUtil.getParameter(request, prefix	+ "rtn_value", length));
			String[] actCustFctryNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_fctry_nm", length));
			String[] actCustFctryPicNo = (JSPUtil.getParameter(request, prefix	+ "act_cust_fctry_pic_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCustFctryAddr = (JSPUtil.getParameter(request, prefix	+ "act_cust_fctry_addr", length));
			String[] actCustRmk = (JSPUtil.getParameter(request, prefix	+ "act_cust_rmk", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] actCustAddrSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_addr_seq", length));
			String[] actCustFctryFaxNo = (JSPUtil.getParameter(request, prefix	+ "act_cust_fctry_fax_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SoProcVO();
				if (actCustFctryPstCd[i] != null)
					model.setActCustFctryPstCd(actCustFctryPstCd[i]);
				if (actCustFctryPhnNo[i] != null)
					model.setActCustFctryPhnNo(actCustFctryPhnNo[i]);
				if (actCustEml[i] != null)
					model.setActCustEml(actCustEml[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (rtnValue[i] != null)
					model.setRtnValue(rtnValue[i]);
				if (actCustFctryNm[i] != null)
					model.setActCustFctryNm(actCustFctryNm[i]);
				if (actCustFctryPicNo[i] != null)
					model.setActCustFctryPicNo(actCustFctryPicNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCustFctryAddr[i] != null)
					model.setActCustFctryAddr(actCustFctryAddr[i]);
				if (actCustRmk[i] != null)
					model.setActCustRmk(actCustRmk[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (actCustAddrSeq[i] != null)
					model.setActCustAddrSeq(actCustAddrSeq[i]);
				if (actCustFctryFaxNo[i] != null)
					model.setActCustFctryFaxNo(actCustFctryFaxNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSoProcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SoProcVO[]
	 */
	public SoProcVO[] getSoProcVOs(){
		SoProcVO[] vos = (SoProcVO[])models.toArray(new SoProcVO[models.size()]);
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
		this.actCustFctryPstCd = this.actCustFctryPstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFctryPhnNo = this.actCustFctryPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustEml = this.actCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnValue = this.rtnValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFctryNm = this.actCustFctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFctryPicNo = this.actCustFctryPicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFctryAddr = this.actCustFctryAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustRmk = this.actCustRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustAddrSeq = this.actCustAddrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFctryFaxNo = this.actCustFctryFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
