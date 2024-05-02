/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferCondVO.java
*@FileTitle : TransferCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.16 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TransferCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TransferCondVO> models = new ArrayList<TransferCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String schTrnsAuthCd = null;
	/* Column Info */
	private String schDateFrom = null;
	/* Column Info */
	private String schDateDiv = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String schUsrId = null;
	/* Column Info */
	private String schOfcCd = null;
	/* Column Info */
	private String schDateTo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TransferCondVO() {}

	public TransferCondVO(String ibflag, String pagerows, String schOfcCd, String schUsrId, String pageNo, String schDateDiv, String schDateFrom, String schDateTo, String schTrnsAuthCd) {
		this.ibflag = ibflag;
		this.schTrnsAuthCd = schTrnsAuthCd;
		this.schDateFrom = schDateFrom;
		this.schDateDiv = schDateDiv;
		this.pageNo = pageNo;
		this.schUsrId = schUsrId;
		this.schOfcCd = schOfcCd;
		this.schDateTo = schDateTo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sch_trns_auth_cd", getSchTrnsAuthCd());
		this.hashColumns.put("sch_date_from", getSchDateFrom());
		this.hashColumns.put("sch_date_div", getSchDateDiv());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("sch_usr_id", getSchUsrId());
		this.hashColumns.put("sch_ofc_cd", getSchOfcCd());
		this.hashColumns.put("sch_date_to", getSchDateTo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sch_trns_auth_cd", "schTrnsAuthCd");
		this.hashFields.put("sch_date_from", "schDateFrom");
		this.hashFields.put("sch_date_div", "schDateDiv");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("sch_usr_id", "schUsrId");
		this.hashFields.put("sch_ofc_cd", "schOfcCd");
		this.hashFields.put("sch_date_to", "schDateTo");
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
	 * @return schTrnsAuthCd
	 */
	public String getSchTrnsAuthCd() {
		return this.schTrnsAuthCd;
	}
	
	/**
	 * Column Info
	 * @return schDateFrom
	 */
	public String getSchDateFrom() {
		return this.schDateFrom;
	}
	
	/**
	 * Column Info
	 * @return schDateDiv
	 */
	public String getSchDateDiv() {
		return this.schDateDiv;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return schUsrId
	 */
	public String getSchUsrId() {
		return this.schUsrId;
	}
	
	/**
	 * Column Info
	 * @return schOfcCd
	 */
	public String getSchOfcCd() {
		return this.schOfcCd;
	}
	
	/**
	 * Column Info
	 * @return schDateTo
	 */
	public String getSchDateTo() {
		return this.schDateTo;
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
	 * @param schTrnsAuthCd
	 */
	public void setSchTrnsAuthCd(String schTrnsAuthCd) {
		this.schTrnsAuthCd = schTrnsAuthCd;
	}
	
	/**
	 * Column Info
	 * @param schDateFrom
	 */
	public void setSchDateFrom(String schDateFrom) {
		this.schDateFrom = schDateFrom;
	}
	
	/**
	 * Column Info
	 * @param schDateDiv
	 */
	public void setSchDateDiv(String schDateDiv) {
		this.schDateDiv = schDateDiv;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param schUsrId
	 */
	public void setSchUsrId(String schUsrId) {
		this.schUsrId = schUsrId;
	}
	
	/**
	 * Column Info
	 * @param schOfcCd
	 */
	public void setSchOfcCd(String schOfcCd) {
		this.schOfcCd = schOfcCd;
	}
	
	/**
	 * Column Info
	 * @param schDateTo
	 */
	public void setSchDateTo(String schDateTo) {
		this.schDateTo = schDateTo;
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
		setSchTrnsAuthCd(JSPUtil.getParameter(request, "sch_trns_auth_cd", ""));
		setSchDateFrom(JSPUtil.getParameter(request, "sch_date_from", ""));
		setSchDateDiv(JSPUtil.getParameter(request, "sch_date_div", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setSchUsrId(JSPUtil.getParameter(request, "sch_usr_id", ""));
		setSchOfcCd(JSPUtil.getParameter(request, "sch_ofc_cd", ""));
		setSchDateTo(JSPUtil.getParameter(request, "sch_date_to", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TransferCondVO[]
	 */
	public TransferCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TransferCondVO[]
	 */
	public TransferCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TransferCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] schTrnsAuthCd = (JSPUtil.getParameter(request, prefix	+ "sch_trns_auth_cd", length));
			String[] schDateFrom = (JSPUtil.getParameter(request, prefix	+ "sch_date_from", length));
			String[] schDateDiv = (JSPUtil.getParameter(request, prefix	+ "sch_date_div", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] schUsrId = (JSPUtil.getParameter(request, prefix	+ "sch_usr_id", length));
			String[] schOfcCd = (JSPUtil.getParameter(request, prefix	+ "sch_ofc_cd", length));
			String[] schDateTo = (JSPUtil.getParameter(request, prefix	+ "sch_date_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TransferCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (schTrnsAuthCd[i] != null)
					model.setSchTrnsAuthCd(schTrnsAuthCd[i]);
				if (schDateFrom[i] != null)
					model.setSchDateFrom(schDateFrom[i]);
				if (schDateDiv[i] != null)
					model.setSchDateDiv(schDateDiv[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (schUsrId[i] != null)
					model.setSchUsrId(schUsrId[i]);
				if (schOfcCd[i] != null)
					model.setSchOfcCd(schOfcCd[i]);
				if (schDateTo[i] != null)
					model.setSchDateTo(schDateTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTransferCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TransferCondVO[]
	 */
	public TransferCondVO[] getTransferCondVOs(){
		TransferCondVO[] vos = (TransferCondVO[])models.toArray(new TransferCondVO[models.size()]);
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
		this.schTrnsAuthCd = this.schTrnsAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDateFrom = this.schDateFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDateDiv = this.schDateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schUsrId = this.schUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOfcCd = this.schOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDateTo = this.schDateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
