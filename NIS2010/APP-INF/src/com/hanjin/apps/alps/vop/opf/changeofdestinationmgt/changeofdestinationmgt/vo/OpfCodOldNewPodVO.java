/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfCodOldNewPodVO.java
*@FileTitle : OpfCodOldNewPodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpfCodOldNewPodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfCodOldNewPodVO> models = new ArrayList<OpfCodOldNewPodVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldPodClptSeq = null;
	/* Column Info */
	private String newPodClptSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfCodOldNewPodVO() {}

	public OpfCodOldNewPodVO(String ibflag, String pagerows, String oldPodClptSeq, String newPodClptSeq, String cntrTpszCd, String cntrQty) {
		this.ibflag = ibflag;
		this.oldPodClptSeq = oldPodClptSeq;
		this.newPodClptSeq = newPodClptSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrQty = cntrQty;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_pod_clpt_seq", getOldPodClptSeq());
		this.hashColumns.put("new_pod_clpt_seq", getNewPodClptSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_pod_clpt_seq", "oldPodClptSeq");
		this.hashFields.put("new_pod_clpt_seq", "newPodClptSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return oldPodClptSeq
	 */
	public String getOldPodClptSeq() {
		return this.oldPodClptSeq;
	}
	
	/**
	 * Column Info
	 * @return newPodClptSeq
	 */
	public String getNewPodClptSeq() {
		return this.newPodClptSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
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
	 * @param oldPodClptSeq
	 */
	public void setOldPodClptSeq(String oldPodClptSeq) {
		this.oldPodClptSeq = oldPodClptSeq;
	}
	
	/**
	 * Column Info
	 * @param newPodClptSeq
	 */
	public void setNewPodClptSeq(String newPodClptSeq) {
		this.newPodClptSeq = newPodClptSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldPodClptSeq(JSPUtil.getParameter(request, prefix + "old_pod_clpt_seq", ""));
		setNewPodClptSeq(JSPUtil.getParameter(request, prefix + "new_pod_clpt_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfCodOldNewPodVO[]
	 */
	public OpfCodOldNewPodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfCodOldNewPodVO[]
	 */
	public OpfCodOldNewPodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfCodOldNewPodVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldPodClptSeq = (JSPUtil.getParameter(request, prefix	+ "old_pod_clpt_seq", length));
			String[] newPodClptSeq = (JSPUtil.getParameter(request, prefix	+ "new_pod_clpt_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfCodOldNewPodVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldPodClptSeq[i] != null)
					model.setOldPodClptSeq(oldPodClptSeq[i]);
				if (newPodClptSeq[i] != null)
					model.setNewPodClptSeq(newPodClptSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfCodOldNewPodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfCodOldNewPodVO[]
	 */
	public OpfCodOldNewPodVO[] getOpfCodOldNewPodVOs(){
		OpfCodOldNewPodVO[] vos = (OpfCodOldNewPodVO[])models.toArray(new OpfCodOldNewPodVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodClptSeq = this.oldPodClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodClptSeq = this.newPodClptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
