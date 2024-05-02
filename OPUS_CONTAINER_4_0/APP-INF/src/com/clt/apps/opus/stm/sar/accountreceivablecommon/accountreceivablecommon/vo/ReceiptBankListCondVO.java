/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptBankListCondVO.java
*@FileTitle : ReceiptBankListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class ReceiptBankListCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptBankListCondVO> models = new ArrayList<ReceiptBankListCondVO>();
	
	/* Column Info */
	private String rctDtFm = null;
	/* Column Info */
	private String rctUnpayStsFlg = null;
	/* Column Info */
	private String rctOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctDtTo = null;
	/* Column Info */
	private String rctDpsDtTo = null;
	/* Column Info */
	private String rctDpsDtFm = null;
	/* Column Info */
	private String rctStsCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptBankListCondVO() {}

	public ReceiptBankListCondVO(String ibflag, String pagerows, String rctDtFm, String rctDtTo, String rctDpsDtFm, String rctDpsDtTo, String rctOfcCd, String rctStsCd, String rctUnpayStsFlg) {
		this.rctDtFm = rctDtFm;
		this.rctUnpayStsFlg = rctUnpayStsFlg;
		this.rctOfcCd = rctOfcCd;
		this.ibflag = ibflag;
		this.rctDtTo = rctDtTo;
		this.rctDpsDtTo = rctDpsDtTo;
		this.rctDpsDtFm = rctDpsDtFm;
		this.rctStsCd = rctStsCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_dt_fm", getRctDtFm());
		this.hashColumns.put("rct_unpay_sts_flg", getRctUnpayStsFlg());
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_dt_to", getRctDtTo());
		this.hashColumns.put("rct_dps_dt_to", getRctDpsDtTo());
		this.hashColumns.put("rct_dps_dt_fm", getRctDpsDtFm());
		this.hashColumns.put("rct_sts_cd", getRctStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_dt_fm", "rctDtFm");
		this.hashFields.put("rct_unpay_sts_flg", "rctUnpayStsFlg");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_dt_to", "rctDtTo");
		this.hashFields.put("rct_dps_dt_to", "rctDpsDtTo");
		this.hashFields.put("rct_dps_dt_fm", "rctDpsDtFm");
		this.hashFields.put("rct_sts_cd", "rctStsCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rctDtFm
	 */
	public String getRctDtFm() {
		return this.rctDtFm;
	}
	
	/**
	 * Column Info
	 * @return rctUnpayStsFlg
	 */
	public String getRctUnpayStsFlg() {
		return this.rctUnpayStsFlg;
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
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
	 * @return rctDtTo
	 */
	public String getRctDtTo() {
		return this.rctDtTo;
	}
	
	/**
	 * Column Info
	 * @return rctDpsDtTo
	 */
	public String getRctDpsDtTo() {
		return this.rctDpsDtTo;
	}
	
	/**
	 * Column Info
	 * @return rctDpsDtFm
	 */
	public String getRctDpsDtFm() {
		return this.rctDpsDtFm;
	}
	
	/**
	 * Column Info
	 * @return rctStsCd
	 */
	public String getRctStsCd() {
		return this.rctStsCd;
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
	 * @param rctDtFm
	 */
	public void setRctDtFm(String rctDtFm) {
		this.rctDtFm = rctDtFm;
	}
	
	/**
	 * Column Info
	 * @param rctUnpayStsFlg
	 */
	public void setRctUnpayStsFlg(String rctUnpayStsFlg) {
		this.rctUnpayStsFlg = rctUnpayStsFlg;
	}
	
	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
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
	 * @param rctDtTo
	 */
	public void setRctDtTo(String rctDtTo) {
		this.rctDtTo = rctDtTo;
	}
	
	/**
	 * Column Info
	 * @param rctDpsDtTo
	 */
	public void setRctDpsDtTo(String rctDpsDtTo) {
		this.rctDpsDtTo = rctDpsDtTo;
	}
	
	/**
	 * Column Info
	 * @param rctDpsDtFm
	 */
	public void setRctDpsDtFm(String rctDpsDtFm) {
		this.rctDpsDtFm = rctDpsDtFm;
	}
	
	/**
	 * Column Info
	 * @param rctStsCd
	 */
	public void setRctStsCd(String rctStsCd) {
		this.rctStsCd = rctStsCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRctDtFm(JSPUtil.getParameter(request, prefix + "rct_dt_fm", ""));
		setRctUnpayStsFlg(JSPUtil.getParameter(request, prefix + "rct_unpay_sts_flg", ""));
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctDtTo(JSPUtil.getParameter(request, prefix + "rct_dt_to", ""));
		setRctDpsDtTo(JSPUtil.getParameter(request, prefix + "rct_dps_dt_to", ""));
		setRctDpsDtFm(JSPUtil.getParameter(request, prefix + "rct_dps_dt_fm", ""));
		setRctStsCd(JSPUtil.getParameter(request, prefix + "rct_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptBankListCondVO[]
	 */
	public ReceiptBankListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptBankListCondVO[]
	 */
	public ReceiptBankListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptBankListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctDtFm = (JSPUtil.getParameter(request, prefix	+ "rct_dt_fm", length));
			String[] rctUnpayStsFlg = (JSPUtil.getParameter(request, prefix	+ "rct_unpay_sts_flg", length));
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctDtTo = (JSPUtil.getParameter(request, prefix	+ "rct_dt_to", length));
			String[] rctDpsDtTo = (JSPUtil.getParameter(request, prefix	+ "rct_dps_dt_to", length));
			String[] rctDpsDtFm = (JSPUtil.getParameter(request, prefix	+ "rct_dps_dt_fm", length));
			String[] rctStsCd = (JSPUtil.getParameter(request, prefix	+ "rct_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptBankListCondVO();
				if (rctDtFm[i] != null)
					model.setRctDtFm(rctDtFm[i]);
				if (rctUnpayStsFlg[i] != null)
					model.setRctUnpayStsFlg(rctUnpayStsFlg[i]);
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctDtTo[i] != null)
					model.setRctDtTo(rctDtTo[i]);
				if (rctDpsDtTo[i] != null)
					model.setRctDpsDtTo(rctDpsDtTo[i]);
				if (rctDpsDtFm[i] != null)
					model.setRctDpsDtFm(rctDpsDtFm[i]);
				if (rctStsCd[i] != null)
					model.setRctStsCd(rctStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptBankListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptBankListCondVO[]
	 */
	public ReceiptBankListCondVO[] getReceiptBankListCondVOs(){
		ReceiptBankListCondVO[] vos = (ReceiptBankListCondVO[])models.toArray(new ReceiptBankListCondVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.rctDtFm = this.rctDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUnpayStsFlg = this.rctUnpayStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtTo = this.rctDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDtTo = this.rctDpsDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDtFm = this.rctDpsDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctStsCd = this.rctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
