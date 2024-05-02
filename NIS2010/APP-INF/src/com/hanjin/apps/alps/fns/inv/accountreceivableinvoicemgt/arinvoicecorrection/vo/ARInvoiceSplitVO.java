/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceSplitVO.java
*@FileTitle : ARInvoiceSplitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.11 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceSplitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceSplitVO> models = new ArrayList<ARInvoiceSplitVO>();
	
	private ARInvoiceCorrectionVO aRInvoiceCorrectionVO = null;
	
	private List<ARInvoiceCorrectionVO> aRInvoiceCorrectionVOs = null;
	
	private ARInvoiceCustomerVO aRInvoiceCustomerVO = null;
	
	private List<ARInvoiceCustomerVO> aRInvoiceCustomerVOs = null;
	
	private List<ARInvoiceChargeCorrectionVO> listInvoiceChargeCorrectionVO = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArAmtVO invArAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArAmtVO> invArAmtVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArChgVO invArChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArChgVO> invArChgVOs;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArCntrVO invArCntrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArCntrVO> invArCntrVOs;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArMnVO invArMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArMnVO> invArMnVOs;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArIfNoVO invArIfNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<InvArIfNoVO> invArIfNoVOs;	
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String splitFlag = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String ifNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceSplitVO() {}

	public ARInvoiceSplitVO(String ibflag, String pagerows, String maxSeq, String splitFlag, String otsSmryCd, String userId, String ifNo ) {
		this.ibflag = ibflag;
		this.maxSeq = maxSeq;
		this.splitFlag = splitFlag;
		this.otsSmryCd = otsSmryCd;
		this.userId = userId;
		this.ifNo = ifNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("split_flag", getSplitFlag());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("split_flag", "splitFlag");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	
	/**
	 * @return the invArIfNoVO
	 */
	public InvArIfNoVO getInvArIfNoVO() {
		return invArIfNoVO;
	}

	/**
	 * @param invArIfNoVO the invArIfNoVO to set
	 */
	public void setInvArIfNoVO(InvArIfNoVO invArIfNoVO) {
		this.invArIfNoVO = invArIfNoVO;
	}

	/**
	 * @return the invArIfNoVOs
	 */
	public List<InvArIfNoVO> getInvArIfNoVOs() {
		return invArIfNoVOs;
	}

	/**
	 * @param invArIfNoVOs the invArIfNoVOs to set
	 */
	public void setInvArIfNoVOs(List<InvArIfNoVO> invArIfNoVOs) {
		this.invArIfNoVOs = invArIfNoVOs;
	}

	/**
	 * @return the ifNo
	 */
	public String getIfNo() {
		return ifNo;
	}

	/**
	 * @param ifNo the ifNo to set
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}

	/**
	 * @return the splitFlag
	 */
	public String getSplitFlag() {
		return splitFlag;
	}

	/**
	 * @param splitFlag the splitFlag to set
	 */
	public void setSplitFlag(String splitFlag) {
		this.splitFlag = splitFlag;
	}

	/**
	 * @return the otsSmryCd
	 */
	public String getOtsSmryCd() {
		return otsSmryCd;
	}

	/**
	 * @param otsSmryCd the otsSmryCd to set
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the invArCntrVO
	 */
	public InvArCntrVO getInvArCntrVO() {
		return invArCntrVO;
	}

	/**
	 * @return the invArAmtVO
	 */
	public InvArAmtVO getInvArAmtVO() {
		return invArAmtVO;
	}

	/**
	 * @param invArAmtVO the invArAmtVO to set
	 */
	public void setInvArAmtVO(InvArAmtVO invArAmtVO) {
		this.invArAmtVO = invArAmtVO;
	}

	/**
	 * @return the invArAmtVOs
	 */
	public List<InvArAmtVO> getInvArAmtVOs() {
		return invArAmtVOs;
	}

	/**
	 * @param invArAmtVOs the invArAmtVOs to set
	 */
	public void setInvArAmtVOs(List<InvArAmtVO> invArAmtVOs) {
		this.invArAmtVOs = invArAmtVOs;
	}

	/**
	 * @return the invArChgVO
	 */
	public InvArChgVO getInvArChgVO() {
		return invArChgVO;
	}

	/**
	 * @param invArChgVO the invArChgVO to set
	 */
	public void setInvArChgVO(InvArChgVO invArChgVO) {
		this.invArChgVO = invArChgVO;
	}

	/**
	 * @return the invArChgVOs
	 */
	public List<InvArChgVO> getInvArChgVOs() {
		return invArChgVOs;
	}

	/**
	 * @param invArChgVOs the invArChgVOs to set
	 */
	public void setInvArChgVOs(List<InvArChgVO> invArChgVOs) {
		this.invArChgVOs = invArChgVOs;
	}

	/**
	 * @return the invArCntrVOs
	 */
	public List<InvArCntrVO> getInvArCntrVOs() {
		return invArCntrVOs;
	}

	/**
	 * @param invArCntrVOs the invArCntrVOs to set
	 */
	public void setInvArCntrVOs(List<InvArCntrVO> invArCntrVOs) {
		this.invArCntrVOs = invArCntrVOs;
	}

	/**
	 * @return the invArMnVO
	 */
	public InvArMnVO getInvArMnVO() {
		return invArMnVO;
	}

	/**
	 * @param invArMnVO the invArMnVO to set
	 */
	public void setInvArMnVO(InvArMnVO invArMnVO) {
		this.invArMnVO = invArMnVO;
	}

	/**
	 * @return the invArMnVOs
	 */
	public List<InvArMnVO> getInvArMnVOs() {
		return invArMnVOs;
	}

	/**
	 * @param invArMnVOs the invArMnVOs to set
	 */
	public void setInvArMnVOs(List<InvArMnVO> invArMnVOs) {
		this.invArMnVOs = invArMnVOs;
	}

	/**
	 * @param invArCntrVO the invArCntrVO to set
	 */
	public void setInvArCntrVO(InvArCntrVO invArCntrVO) {
		this.invArCntrVO = invArCntrVO;
	}

	/**
	 * @return the aRInvoiceCorrectionVOs
	 */
	public List<ARInvoiceCorrectionVO> getARInvoiceCorrectionVOs() {
		return aRInvoiceCorrectionVOs;
	}

	/**
	 * @param invoiceCorrectionVOs the aRInvoiceCorrectionVOs to set
	 */
	public void setARInvoiceCorrectionVOs(
			List<ARInvoiceCorrectionVO> invoiceCorrectionVOs) {
		aRInvoiceCorrectionVOs = invoiceCorrectionVOs;
	}

	/**
	 * @return the aRInvoiceCustomerVOs
	 */
	public List<ARInvoiceCustomerVO> getARInvoiceCustomerVOs() {
		return aRInvoiceCustomerVOs;
	}

	/**
	 * @param invoiceCustomerVOs the aRInvoiceCustomerVOs to set
	 */
	public void setARInvoiceCustomerVOs(List<ARInvoiceCustomerVO> invoiceCustomerVOs) {
		aRInvoiceCustomerVOs = invoiceCustomerVOs;
	}

	/**
	 * @return the aRInvoiceCustomerVO
	 */
	public ARInvoiceCustomerVO getARInvoiceCustomerVO() {
		return aRInvoiceCustomerVO;
	}

	/**
	 * @param invoiceCustomerVO the aRInvoiceCustomerVO to set
	 */
	public void setARInvoiceCustomerVO(ARInvoiceCustomerVO invoiceCustomerVO) {
		aRInvoiceCustomerVO = invoiceCustomerVO;
	}

	/**
	 * @return the aRInvoiceCorrectionVO
	 */
	public ARInvoiceCorrectionVO getARInvoiceCorrectionVO() {
		return aRInvoiceCorrectionVO;
	}

	/**
	 * @param invoiceCorrectionVO the aRInvoiceCorrectionVO to set
	 */
	public void setARInvoiceCorrectionVO(ARInvoiceCorrectionVO invoiceCorrectionVO) {
		aRInvoiceCorrectionVO = invoiceCorrectionVO;
	}

	/**
	 * @return the listInvoiceChargeCorrectionVO
	 */
	public List<ARInvoiceChargeCorrectionVO> getListInvoiceChargeCorrectionVO() {
		return listInvoiceChargeCorrectionVO;
	}

	/**
	 * @param listInvoiceChargeCorrectionVO the listInvoiceChargeCorrectionVO to set
	 */
	public void setListInvoiceChargeCorrectionVO(
			List<ARInvoiceChargeCorrectionVO> listInvoiceChargeCorrectionVO) {
		this.listInvoiceChargeCorrectionVO = listInvoiceChargeCorrectionVO;
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
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
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
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
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
		setMaxSeq(JSPUtil.getParameter(request, "max_seq", ""));
		setSplitFlag(JSPUtil.getParameter(request, "split_flag", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, "ots_smry_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setIfNo(JSPUtil.getParameter(request, "if_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceSplitVO[]
	 */
	public ARInvoiceSplitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceSplitVO[]
	 */
	public ARInvoiceSplitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceSplitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] splitFlag = (JSPUtil.getParameter(request, prefix	+ "split_flag", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceSplitVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (splitFlag[i] != null)
					model.setSplitFlag(splitFlag[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceSplitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceSplitVO[]
	 */
	public ARInvoiceSplitVO[] getARInvoiceSplitVOs(){
		ARInvoiceSplitVO[] vos = (ARInvoiceSplitVO[])models.toArray(new ARInvoiceSplitVO[models.size()]);
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
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlag = this.splitFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
