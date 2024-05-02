/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APInterfaceStatusVO.java
*@FileTitle : APInterfaceStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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

public class APInterfaceStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APInterfaceStatusVO> models = new ArrayList<APInterfaceStatusVO>();
	
	/* Column Info */
	private String apIfCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctAplyDtlSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APInterfaceStatusVO() {}

	public APInterfaceStatusVO(String ibflag, String pagerows, String apIfCd, String updUsrId, String rctAplyDtlSeq) {
		this.apIfCd = apIfCd;
		this.ibflag = ibflag;
		this.rctAplyDtlSeq = rctAplyDtlSeq;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_if_cd", getApIfCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_aply_dtl_seq", getRctAplyDtlSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_if_cd", "apIfCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_aply_dtl_seq", "rctAplyDtlSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apIfCd
	 */
	public String getApIfCd() {
		return this.apIfCd;
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
	 * @return rctAplyDtlSeq
	 */
	public String getRctAplyDtlSeq() {
		return this.rctAplyDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param apIfCd
	 */
	public void setApIfCd(String apIfCd) {
		this.apIfCd = apIfCd;
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
	 * @param rctAplyDtlSeq
	 */
	public void setRctAplyDtlSeq(String rctAplyDtlSeq) {
		this.rctAplyDtlSeq = rctAplyDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setApIfCd(JSPUtil.getParameter(request, prefix + "ap_if_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctAplyDtlSeq(JSPUtil.getParameter(request, prefix + "rct_aply_dtl_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APInterfaceStatusVO[]
	 */
	public APInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APInterfaceStatusVO[]
	 */
	public APInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APInterfaceStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apIfCd = (JSPUtil.getParameter(request, prefix	+ "ap_if_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctAplyDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rct_aply_dtl_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new APInterfaceStatusVO();
				if (apIfCd[i] != null)
					model.setApIfCd(apIfCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctAplyDtlSeq[i] != null)
					model.setRctAplyDtlSeq(rctAplyDtlSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPInterfaceStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APInterfaceStatusVO[]
	 */
	public APInterfaceStatusVO[] getAPInterfaceStatusVOs(){
		APInterfaceStatusVO[] vos = (APInterfaceStatusVO[])models.toArray(new APInterfaceStatusVO[models.size()]);
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
		this.apIfCd = this.apIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyDtlSeq = this.rctAplyDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
