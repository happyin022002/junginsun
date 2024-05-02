/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcCustVO.java
*@FileTitle : ArrNtcCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcCustVO> models = new ArrayList<ArrNtcCustVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String repCmdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCntcTpCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String addr = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String mdmName = null;
	/* Column Info */
	private String blNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcCustVO() {}
/**
 * 
 * @param ibflag
 * @param pagerows
 * @param custCd
 * @param mdmName
 * @param blNm
 * @param addr
 * @param repCmdt
 * @param phnNo
 * @param faxNo
 * @param ntcEml
 * @param custTpCd
 * @param custCntcTpCd
 */
	public ArrNtcCustVO(String ibflag, String pagerows, String custCd, String mdmName, String blNm, String addr, String repCmdt, String phnNo, String faxNo, String ntcEml, String custTpCd, String custCntcTpCd) {
		this.phnNo = phnNo;
		this.ntcEml = ntcEml;
		this.repCmdt = repCmdt;
		this.ibflag = ibflag;
		this.custCntcTpCd = custCntcTpCd;
		this.custCd = custCd;
		this.faxNo = faxNo;
		this.addr = addr;
		this.custTpCd = custTpCd;
		this.mdmName = mdmName;
		this.blNm = blNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("rep_cmdt", getRepCmdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cntc_tp_cd", getCustCntcTpCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("addr", getAddr());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("mdm_name", getMdmName());
		this.hashColumns.put("bl_nm", getBlNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("rep_cmdt", "repCmdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cntc_tp_cd", "custCntcTpCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("addr", "addr");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("mdm_name", "mdmName");
		this.hashFields.put("bl_nm", "blNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
	}
	
	/**
	 * Column Info
	 * @return repCmdt
	 */
	public String getRepCmdt() {
		return this.repCmdt;
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
	 * @return custCntcTpCd
	 */
	public String getCustCntcTpCd() {
		return this.custCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return addr
	 */
	public String getAddr() {
		return this.addr;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return mdmName
	 */
	public String getMdmName() {
		return this.mdmName;
	}
	
	/**
	 * Column Info
	 * @return blNm
	 */
	public String getBlNm() {
		return this.blNm;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
	}
	
	/**
	 * Column Info
	 * @param repCmdt
	 */
	public void setRepCmdt(String repCmdt) {
		this.repCmdt = repCmdt;
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
	 * @param custCntcTpCd
	 */
	public void setCustCntcTpCd(String custCntcTpCd) {
		this.custCntcTpCd = custCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param addr
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param mdmName
	 */
	public void setMdmName(String mdmName) {
		this.mdmName = mdmName;
	}
	
	/**
	 * Column Info
	 * @param blNm
	 */
	public void setBlNm(String blNm) {
		this.blNm = blNm;
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
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setRepCmdt(JSPUtil.getParameter(request, "rep_cmdt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustCntcTpCd(JSPUtil.getParameter(request, "cust_cntc_tp_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setAddr(JSPUtil.getParameter(request, "addr", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setMdmName(JSPUtil.getParameter(request, "mdm_name", ""));
		setBlNm(JSPUtil.getParameter(request, "bl_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcCustVO[]
	 */
	public ArrNtcCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcCustVO[]
	 */
	public ArrNtcCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no".trim(), length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml".trim(), length));
			String[] repCmdt = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd".trim(), length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd".trim(), length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no".trim(), length));
			String[] addr = (JSPUtil.getParameter(request, prefix	+ "addr".trim(), length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd".trim(), length));
			String[] mdmName = (JSPUtil.getParameter(request, prefix	+ "mdm_name".trim(), length));
			String[] blNm = (JSPUtil.getParameter(request, prefix	+ "bl_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcCustVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (repCmdt[i] != null)
					model.setRepCmdt(repCmdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCntcTpCd[i] != null)
					model.setCustCntcTpCd(custCntcTpCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (addr[i] != null)
					model.setAddr(addr[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (mdmName[i] != null)
					model.setMdmName(mdmName[i]);
				if (blNm[i] != null)
					model.setBlNm(blNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcCustVO[]
	 */
	public ArrNtcCustVO[] getArrNtcCustVOs(){
		ArrNtcCustVO[] vos = (ArrNtcCustVO[])models.toArray(new ArrNtcCustVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdt = this.repCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd = this.custCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addr = this.addr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmName = this.mdmName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNm = this.blNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
