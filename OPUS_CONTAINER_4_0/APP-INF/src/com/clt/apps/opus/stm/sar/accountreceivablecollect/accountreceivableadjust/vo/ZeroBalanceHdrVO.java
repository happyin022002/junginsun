/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ZeroBalanceHdrVO.java
*@FileTitle : ZeroBalanceHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

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

public class ZeroBalanceHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ZeroBalanceHdrVO> models = new ArrayList<ZeroBalanceHdrVO>();
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String otsAdjSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String adjNo = null;
	/* Column Info */
	private String adjTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ZeroBalanceHdrVO() {}

	public ZeroBalanceHdrVO(String ibflag, String pagerows, String otsAdjSeq, String adjNo, String adjTpCd, String creUsrId, String rhqCd, String otsOfcCd, String blNo, String invNo) {
		this.invNo = invNo;
		this.otsAdjSeq = otsAdjSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.otsOfcCd = otsOfcCd;
		this.rhqCd = rhqCd;
		this.adjNo = adjNo;
		this.adjTpCd = adjTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ots_adj_seq", getOtsAdjSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("adj_no", getAdjNo());
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ots_adj_seq", "otsAdjSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("adj_no", "adjNo");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return otsAdjSeq
	 */
	public String getOtsAdjSeq() {
		return this.otsAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return adjNo
	 */
	public String getAdjNo() {
		return this.adjNo;
	}
	
	/**
	 * Column Info
	 * @return adjTpCd
	 */
	public String getAdjTpCd() {
		return this.adjTpCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param otsAdjSeq
	 */
	public void setOtsAdjSeq(String otsAdjSeq) {
		this.otsAdjSeq = otsAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param adjNo
	 */
	public void setAdjNo(String adjNo) {
		this.adjNo = adjNo;
	}
	
	/**
	 * Column Info
	 * @param adjTpCd
	 */
	public void setAdjTpCd(String adjTpCd) {
		this.adjTpCd = adjTpCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOtsAdjSeq(JSPUtil.getParameter(request, prefix + "ots_adj_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setAdjNo(JSPUtil.getParameter(request, prefix + "adj_no", ""));
		setAdjTpCd(JSPUtil.getParameter(request, prefix + "adj_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ZeroBalanceHdrVO[]
	 */
	public ZeroBalanceHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ZeroBalanceHdrVO[]
	 */
	public ZeroBalanceHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ZeroBalanceHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] otsAdjSeq = (JSPUtil.getParameter(request, prefix	+ "ots_adj_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] adjNo = (JSPUtil.getParameter(request, prefix	+ "adj_no", length));
			String[] adjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ZeroBalanceHdrVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (otsAdjSeq[i] != null)
					model.setOtsAdjSeq(otsAdjSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (adjNo[i] != null)
					model.setAdjNo(adjNo[i]);
				if (adjTpCd[i] != null)
					model.setAdjTpCd(adjTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getZeroBalanceHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ZeroBalanceHdrVO[]
	 */
	public ZeroBalanceHdrVO[] getZeroBalanceHdrVOs(){
		ZeroBalanceHdrVO[] vos = (ZeroBalanceHdrVO[])models.toArray(new ZeroBalanceHdrVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAdjSeq = this.otsAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNo = this.adjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd = this.adjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
