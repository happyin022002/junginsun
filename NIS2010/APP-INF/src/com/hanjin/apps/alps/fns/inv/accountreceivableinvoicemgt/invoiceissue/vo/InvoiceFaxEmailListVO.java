/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceFaxEmailListVO.java
*@FileTitle : InvoiceFaxEmailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.09.01 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvoiceFaxEmailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceFaxEmailListVO> models = new ArrayList<InvoiceFaxEmailListVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String invRefNo = null;
	/* Column Info */
	private String custEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String invIssRmk = null;
	/* Column Info */
	private String custFaxNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String fAdd = null;
	/* Column Info */
	private String fDel = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String attachView = null;
	/* Column Info */
	private String attachView2 = null;
	/* Column Info */
	private String fCopy = null;
	/* Column Info */
	private String invIssCmbFlg = null;
	/* Column Info */
	private String loclPoNo = null;
	/* Column Info */
	private String invEmlSplitFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvoiceFaxEmailListVO() {}

	public InvoiceFaxEmailListVO(String ibflag, String pagerows, String invNo, String vvd, String custCd, String custNm, String invRefNo, String arIfNo, String blSrcNo, String custEml, String custFaxNo, String invRmk, String invIssRmk, String portCd, String fAdd, String fDel, String invSeq, String ioBndCd, String attachView, String attachView2, String fCopy, String invIssCmbFlg, String loclPoNo, String invEmlSplitFlg) {
		this.blSrcNo = blSrcNo;
		this.custNm = custNm;
		this.invRefNo = invRefNo;
		this.custEml = custEml;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.custCd = custCd;
		this.arIfNo = arIfNo;
		this.invRmk = invRmk;
		this.invIssRmk = invIssRmk;
		this.custFaxNo = custFaxNo;
		this.portCd = portCd;
		this.fAdd = fAdd;
		this.fDel = fDel;
		this.invSeq = invSeq;
		this.ioBndCd = ioBndCd;
		this.attachView = attachView;
		this.attachView2 = attachView2;
		this.fCopy = fCopy;
		this.invIssCmbFlg = invIssCmbFlg;
		this.loclPoNo = loclPoNo;
		this.invEmlSplitFlg = invEmlSplitFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("inv_ref_no", getInvRefNo());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("inv_iss_rmk", getInvIssRmk());
		this.hashColumns.put("cust_fax_no", getCustFaxNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("f_add", getFAdd());
		this.hashColumns.put("f_del", getFDel());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("attach_view", getAttachView());
		this.hashColumns.put("attach_view2", getAttachView2());
		this.hashColumns.put("f_copy", getFCopy());
		this.hashColumns.put("inv_iss_cmb_flg", getInvIssCmbFlg());
		this.hashColumns.put("locl_po_no", getLoclPoNo());
		this.hashColumns.put("inv_eml_split_flg", getInvEmlSplitFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("inv_iss_rmk", "invIssRmk");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("f_add", "fAdd");
		this.hashFields.put("f_del", "fDel");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("attach_view", "attachView");
		this.hashFields.put("attach_view2", "attachView2");
		this.hashFields.put("f_copy", "fCopy");
		this.hashFields.put("inv_iss_cmb_flg", "invIssCmbFlg");
		this.hashFields.put("locl_po_no", "loclPoNo");
		this.hashFields.put("inv_eml_split_flg", "invEmlSplitFlg");
		
		return this.hashFields;
	}
	
	
	/**
	 * @return the loclPoNo
	 */
	public String getLoclPoNo() {
		return loclPoNo;
	}

	/**
	 * @param loclPoNo the loclPoNo to set
	 */
	public void setLoclPoNo(String loclPoNo) {
		this.loclPoNo = loclPoNo;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return invRefNo
	 */
	public String getInvRefNo() {
		return this.invRefNo;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return invIssRmk
	 */
	public String getInvIssRmk() {
		return this.invIssRmk;
	}
	
	/**
	 * Column Info
	 * @return custFaxNo
	 */
	public String getCustFaxNo() {
		return this.custFaxNo;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return fAdd
	 */
	public String getFAdd() {
		return this.fAdd;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param invRefNo
	 */
	public void setInvRefNo(String invRefNo) {
		this.invRefNo = invRefNo;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param invIssRmk
	 */
	public void setInvIssRmk(String invIssRmk) {
		this.invIssRmk = invIssRmk;
	}
	
	/**
	 * Column Info
	 * @param custFaxNo
	 */
	public void setCustFaxNo(String custFaxNo) {
		this.custFaxNo = custFaxNo;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param fAdd
	 */
	public void setFAdd(String fAdd) {
		this.fAdd = fAdd;
	}
	
	/**
	 * @return the fDel
	 */
	public String getFDel() {
		return fDel;
	}

	/**
	 * @param del the fDel to set
	 */
	public void setFDel(String del) {
		fDel = del;
	}

	/**
	 * @return the invSeq
	 */
	public String getInvSeq() {
		return invSeq;
	}

	/**
	 * @param invSeq the invSeq to set
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}

	/**
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * @param ioBndCd the ioBndCd to set
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * @return the attachView
	 */
	public String getAttachView() {
		return attachView;
	}

	/**
	 * @param attachView the attachView to set
	 */
	public void setAttachView(String attachView) {
		this.attachView = attachView;
	}

	/**
	 * @return the attachView2
	 */
	public String getAttachView2() {
		return attachView2;
	}

	/**
	 * @param attachView2 the attachView2 to set
	 */
	public void setAttachView2(String attachView2) {
		this.attachView2 = attachView2;
	}

	/**
	 * @return the fCopy
	 */
	public String getFCopy() {
		return fCopy;
	}

	/**
	 * @param copy the fCopy to set
	 */
	public void setFCopy(String copy) {
		fCopy = copy;
	}

	/**
	 * @return the invIssCmbFlg
	 */
	public String getInvIssCmbFlg() {
		return invIssCmbFlg;
	}

	/**
	 * @param invIssCmbFlg the invIssCmbFlg to set
	 */
	public void setInvIssCmbFlg(String invIssCmbFlg) {
		this.invIssCmbFlg = invIssCmbFlg;
	}

		
	/**
	 * @return the invEmlSplitFlg
	 */
	public String getInvEmlSplitFlg() {
		return invEmlSplitFlg;
	}

	/**
	 * @param invEmlSplitFlg the invEmlSplitFlg to set
	 */
	public void setInvEmlSplitFlg(String invEmlSplitFlg) {
		this.invEmlSplitFlg = invEmlSplitFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setInvRefNo(JSPUtil.getParameter(request, "inv_ref_no", ""));
		setCustEml(JSPUtil.getParameter(request, "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setInvIssRmk(JSPUtil.getParameter(request, "inv_iss_rmk", ""));
		setCustFaxNo(JSPUtil.getParameter(request, "cust_fax_no", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setFAdd(JSPUtil.getParameter(request, "f_add", ""));
		setFDel(JSPUtil.getParameter(request, "f_del", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setAttachView(JSPUtil.getParameter(request, "attach_view", ""));
		setAttachView2(JSPUtil.getParameter(request, "attach_view2", ""));
		setFCopy(JSPUtil.getParameter(request, "f_copy", ""));
		setInvIssCmbFlg(JSPUtil.getParameter(request, "inv_iss_cmb_flg", ""));
		setLoclPoNo(JSPUtil.getParameter(request, "locl_po_no", ""));
		setInvEmlSplitFlg(JSPUtil.getParameter(request, "inv_eml_split_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceFaxEmailListVO[]
	 */
	public InvoiceFaxEmailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceFaxEmailListVO[]
	 */
	public InvoiceFaxEmailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvoiceFaxEmailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] invRefNo = (JSPUtil.getParameter(request, prefix	+ "inv_ref_no", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] invIssRmk = (JSPUtil.getParameter(request, prefix	+ "inv_iss_rmk", length));
			String[] custFaxNo = (JSPUtil.getParameter(request, prefix	+ "cust_fax_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] fAdd = (JSPUtil.getParameter(request, prefix	+ "f_add", length));
			String[] fDel = (JSPUtil.getParameter(request, prefix	+ "f_del", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] attachView = (JSPUtil.getParameter(request, prefix	+ "attach_view", length));
			String[] attachView2 = (JSPUtil.getParameter(request, prefix	+ "attach_view2", length));
			String[] fCopy = (JSPUtil.getParameter(request, prefix	+ "f_copy", length));
			String[] invIssCmbFlg = (JSPUtil.getParameter(request, prefix	+ "inv_iss_cmb_flg", length));
			String[] loclPoNo = (JSPUtil.getParameter(request, prefix	+ "locl_po_no", length));
			String[] invEmlSplitFlg = (JSPUtil.getParameter(request, prefix	+ "inv_eml_split_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvoiceFaxEmailListVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (invRefNo[i] != null)
					model.setInvRefNo(invRefNo[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (invIssRmk[i] != null)
					model.setInvIssRmk(invIssRmk[i]);
				if (custFaxNo[i] != null)
					model.setCustFaxNo(custFaxNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (fAdd[i] != null)
					model.setFAdd(fAdd[i]);
				if (fDel[i] != null)
					model.setFDel(fDel[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (attachView[i] != null)
					model.setAttachView(attachView[i]);
				if (attachView2[i] != null)
					model.setAttachView2(attachView2[i]);
				if (fCopy[i] != null)
					model.setFCopy(fCopy[i]);
				if (invIssCmbFlg[i] != null)
					model.setInvIssCmbFlg(invIssCmbFlg[i]);
				if (loclPoNo[i] != null)
					model.setLoclPoNo(loclPoNo[i]);
                if (invEmlSplitFlg[i] != null)
                    model.setInvEmlSplitFlg(invEmlSplitFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvoiceFaxEmailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceFaxEmailListVO[]
	 */
	public InvoiceFaxEmailListVO[] getInvoiceFaxEmailListVOs(){
		InvoiceFaxEmailListVO[] vos = (InvoiceFaxEmailListVO[])models.toArray(new InvoiceFaxEmailListVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo = this.invRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssRmk = this.invIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo = this.custFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAdd = this.fAdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDel = this.fDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView = this.attachView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachView2 = this.attachView2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCopy = this.fCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCmbFlg = this.invIssCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclPoNo = this.loclPoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEmlSplitFlg = invEmlSplitFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
