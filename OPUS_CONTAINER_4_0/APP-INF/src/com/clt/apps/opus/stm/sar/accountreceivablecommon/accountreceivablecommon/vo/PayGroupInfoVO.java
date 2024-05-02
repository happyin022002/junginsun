/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PayGroupInfoVO.java
*@FileTitle : PayGroupInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.11  
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

public class PayGroupInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayGroupInfoVO> models = new ArrayList<PayGroupInfoVO>();
	
	/* Column Info */
	private String payGrpLuCd = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Column Info */
	private String attrCateNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PayGroupInfoVO() {}

	public PayGroupInfoVO(String ibflag, String pagerows, String attrCtnt2, String payGrpLuCd, String attrCtnt7, String apCtrCd, String attrCateNm) {
		this.payGrpLuCd = payGrpLuCd;
		this.attrCtnt2 = attrCtnt2;
		this.ibflag = ibflag;
		this.attrCtnt7 = attrCtnt7;
		this.apCtrCd = apCtrCd;
		this.attrCateNm = attrCateNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payGrpLuCd
	 */
	public String getPayGrpLuCd() {
		return this.payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
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
	 * @return attrCtnt7
	 */
	public String getAttrCtnt7() {
		return this.attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
	}
	
	/**
	 * Column Info
	 * @return attrCateNm
	 */
	public String getAttrCateNm() {
		return this.attrCateNm;
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
	 * @param payGrpLuCd
	 */
	public void setPayGrpLuCd(String payGrpLuCd) {
		this.payGrpLuCd = payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
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
	 * @param attrCtnt7
	 */
	public void setAttrCtnt7(String attrCtnt7) {
		this.attrCtnt7 = attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
	}
	
	/**
	 * Column Info
	 * @param attrCateNm
	 */
	public void setAttrCateNm(String attrCateNm) {
		this.attrCateNm = attrCateNm;
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
		setPayGrpLuCd(JSPUtil.getParameter(request, prefix + "pay_grp_lu_cd", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setAttrCateNm(JSPUtil.getParameter(request, prefix + "attr_cate_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayGroupInfoVO[]
	 */
	public PayGroupInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayGroupInfoVO[]
	 */
	public PayGroupInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayGroupInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_grp_lu_cd", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] attrCateNm = (JSPUtil.getParameter(request, prefix	+ "attr_cate_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayGroupInfoVO();
				if (payGrpLuCd[i] != null)
					model.setPayGrpLuCd(payGrpLuCd[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (attrCateNm[i] != null)
					model.setAttrCateNm(attrCateNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayGroupInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayGroupInfoVO[]
	 */
	public PayGroupInfoVO[] getPayGroupInfoVOs(){
		PayGroupInfoVO[] vos = (PayGroupInfoVO[])models.toArray(new PayGroupInfoVO[models.size()]);
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
		this.payGrpLuCd = this.payGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm = this.attrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
