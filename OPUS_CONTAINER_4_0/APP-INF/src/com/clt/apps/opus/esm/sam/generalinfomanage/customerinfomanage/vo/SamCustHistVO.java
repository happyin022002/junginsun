/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SamCustHistVO.java
*@FileTitle : SamCustHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.06.16 박찬민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박찬민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamCustHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamCustHistVO> models = new ArrayList<SamCustHistVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aNewValDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldValDesc = null;
	/* Column Info */
	private String cngItmCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String custHisSeq = null;
	/* Column Info */
	private String aCngItmCd = null;
	/* Column Info */
	private String aOldValDesc = null;
	/* Column Info */
	private String newValDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamCustHistVO() {}

	public SamCustHistVO(String ibflag, String pagerows, String custHisSeq, String cngItmCd, String oldValDesc, String newValDesc, String updDt, String userId, String aOldValDesc, String aNewValDesc, String aCngItmCd, String custCd) {
		this.updDt = updDt;
		this.aNewValDesc = aNewValDesc;
		this.ibflag = ibflag;
		this.oldValDesc = oldValDesc;
		this.cngItmCd = cngItmCd;
		this.custCd = custCd;
		this.userId = userId;
		this.custHisSeq = custHisSeq;
		this.aCngItmCd = aCngItmCd;
		this.aOldValDesc = aOldValDesc;
		this.newValDesc = newValDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("a_new_val_desc", getANewValDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_val_desc", getOldValDesc());
		this.hashColumns.put("cng_itm_cd", getCngItmCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cust_his_seq", getCustHisSeq());
		this.hashColumns.put("a_cng_itm_cd", getACngItmCd());
		this.hashColumns.put("a_old_val_desc", getAOldValDesc());
		this.hashColumns.put("new_val_desc", getNewValDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("a_new_val_desc", "aNewValDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_val_desc", "oldValDesc");
		this.hashFields.put("cng_itm_cd", "cngItmCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cust_his_seq", "custHisSeq");
		this.hashFields.put("a_cng_itm_cd", "aCngItmCd");
		this.hashFields.put("a_old_val_desc", "aOldValDesc");
		this.hashFields.put("new_val_desc", "newValDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return aNewValDesc
	 */
	public String getANewValDesc() {
		return this.aNewValDesc;
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
	 * @return oldValDesc
	 */
	public String getOldValDesc() {
		return this.oldValDesc;
	}
	
	/**
	 * Column Info
	 * @return cngItmCd
	 */
	public String getCngItmCd() {
		return this.cngItmCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return custHisSeq
	 */
	public String getCustHisSeq() {
		return this.custHisSeq;
	}
	
	/**
	 * Column Info
	 * @return aCngItmCd
	 */
	public String getACngItmCd() {
		return this.aCngItmCd;
	}
	
	/**
	 * Column Info
	 * @return aOldValDesc
	 */
	public String getAOldValDesc() {
		return this.aOldValDesc;
	}
	
	/**
	 * Column Info
	 * @return newValDesc
	 */
	public String getNewValDesc() {
		return this.newValDesc;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param aNewValDesc
	 */
	public void setANewValDesc(String aNewValDesc) {
		this.aNewValDesc = aNewValDesc;
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
	 * @param oldValDesc
	 */
	public void setOldValDesc(String oldValDesc) {
		this.oldValDesc = oldValDesc;
	}
	
	/**
	 * Column Info
	 * @param cngItmCd
	 */
	public void setCngItmCd(String cngItmCd) {
		this.cngItmCd = cngItmCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param custHisSeq
	 */
	public void setCustHisSeq(String custHisSeq) {
		this.custHisSeq = custHisSeq;
	}
	
	/**
	 * Column Info
	 * @param aCngItmCd
	 */
	public void setACngItmCd(String aCngItmCd) {
		this.aCngItmCd = aCngItmCd;
	}
	
	/**
	 * Column Info
	 * @param aOldValDesc
	 */
	public void setAOldValDesc(String aOldValDesc) {
		this.aOldValDesc = aOldValDesc;
	}
	
	/**
	 * Column Info
	 * @param newValDesc
	 */
	public void setNewValDesc(String newValDesc) {
		this.newValDesc = newValDesc;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setANewValDesc(JSPUtil.getParameter(request, prefix + "a_new_val_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldValDesc(JSPUtil.getParameter(request, prefix + "old_val_desc", ""));
		setCngItmCd(JSPUtil.getParameter(request, prefix + "cng_itm_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCustHisSeq(JSPUtil.getParameter(request, prefix + "cust_his_seq", ""));
		setACngItmCd(JSPUtil.getParameter(request, prefix + "a_cng_itm_cd", ""));
		setAOldValDesc(JSPUtil.getParameter(request, prefix + "a_old_val_desc", ""));
		setNewValDesc(JSPUtil.getParameter(request, prefix + "new_val_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamCustHistVO[]
	 */
	public SamCustHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamCustHistVO[]
	 */
	public SamCustHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamCustHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aNewValDesc = (JSPUtil.getParameter(request, prefix	+ "a_new_val_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldValDesc = (JSPUtil.getParameter(request, prefix	+ "old_val_desc", length));
			String[] cngItmCd = (JSPUtil.getParameter(request, prefix	+ "cng_itm_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] custHisSeq = (JSPUtil.getParameter(request, prefix	+ "cust_his_seq", length));
			String[] aCngItmCd = (JSPUtil.getParameter(request, prefix	+ "a_cng_itm_cd", length));
			String[] aOldValDesc = (JSPUtil.getParameter(request, prefix	+ "a_old_val_desc", length));
			String[] newValDesc = (JSPUtil.getParameter(request, prefix	+ "new_val_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamCustHistVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aNewValDesc[i] != null)
					model.setANewValDesc(aNewValDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldValDesc[i] != null)
					model.setOldValDesc(oldValDesc[i]);
				if (cngItmCd[i] != null)
					model.setCngItmCd(cngItmCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (custHisSeq[i] != null)
					model.setCustHisSeq(custHisSeq[i]);
				if (aCngItmCd[i] != null)
					model.setACngItmCd(aCngItmCd[i]);
				if (aOldValDesc[i] != null)
					model.setAOldValDesc(aOldValDesc[i]);
				if (newValDesc[i] != null)
					model.setNewValDesc(newValDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamCustHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamCustHistVO[]
	 */
	public SamCustHistVO[] getSamCustHistVOs(){
		SamCustHistVO[] vos = (SamCustHistVO[])models.toArray(new SamCustHistVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aNewValDesc = this.aNewValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldValDesc = this.oldValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngItmCd = this.cngItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custHisSeq = this.custHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCngItmCd = this.aCngItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aOldValDesc = this.aOldValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newValDesc = this.newValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
