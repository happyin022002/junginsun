/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaResultCntrVO.java
*@FileTitle : UsaResultCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.10 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaResultCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaResultCntrVO> models = new ArrayList<UsaResultCntrVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String oldCntrCFlag = null;
	/* Column Info */
	private String qty69 = null;
	/* Column Info */
	private String ircQty = null;
	/* Column Info */
	private String oldCntrCflag = null;
	/* Column Info */
	private String hold = null;
	/* Column Info */
	private String inBl = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldHoldRemark = null;
	/* Column Info */
	private String icrSeq = null;
	/* Column Info */
	private String remv = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaResultCntrVO() {}

	public UsaResultCntrVO(String ibflag, String pagerows, String oldCntrCflag, String oldHoldRemark, String inVvd, String inPod, String oldCntrCFlag, String qty69, String ircQty, String inBl, String icrSeq, String hold, String remv) {
		this.inVvd = inVvd;
		this.inPod = inPod;
		this.oldCntrCFlag = oldCntrCFlag;
		this.qty69 = qty69;
		this.ircQty = ircQty;
		this.oldCntrCflag = oldCntrCflag;
		this.hold = hold;
		this.inBl = inBl;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.oldHoldRemark = oldHoldRemark;
		this.icrSeq = icrSeq;
		this.remv = remv;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("old_cntr_c_flag", getOldCntrCFlag());
		this.hashColumns.put("qty69", getQty69());
		this.hashColumns.put("irc_qty", getIrcQty());
		this.hashColumns.put("old_cntr_cflag", getOldCntrCflag());
		this.hashColumns.put("hold", getHold());
		this.hashColumns.put("in_bl", getInBl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_hold_remark", getOldHoldRemark());
		this.hashColumns.put("icr_seq", getIcrSeq());
		this.hashColumns.put("remv", getRemv());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("old_cntr_c_flag", "oldCntrCFlag");
		this.hashFields.put("qty69", "qty69");
		this.hashFields.put("irc_qty", "ircQty");
		this.hashFields.put("old_cntr_cflag", "oldCntrCflag");
		this.hashFields.put("hold", "hold");
		this.hashFields.put("in_bl", "inBl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_hold_remark", "oldHoldRemark");
		this.hashFields.put("icr_seq", "icrSeq");
		this.hashFields.put("remv", "remv");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
	}
	
	/**
	 * Column Info
	 * @return oldCntrCFlag
	 */
	public String getOldCntrCFlag() {
		return this.oldCntrCFlag;
	}
	
	/**
	 * Column Info
	 * @return qty69
	 */
	public String getQty69() {
		return this.qty69;
	}
	
	/**
	 * Column Info
	 * @return ircQty
	 */
	public String getIrcQty() {
		return this.ircQty;
	}
	
	/**
	 * Column Info
	 * @return oldCntrCflag
	 */
	public String getOldCntrCflag() {
		return this.oldCntrCflag;
	}
	
	/**
	 * Column Info
	 * @return hold
	 */
	public String getHold() {
		return this.hold;
	}
	
	/**
	 * Column Info
	 * @return inBl
	 */
	public String getInBl() {
		return this.inBl;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return oldHoldRemark
	 */
	public String getOldHoldRemark() {
		return this.oldHoldRemark;
	}
	
	/**
	 * Column Info
	 * @return icrSeq
	 */
	public String getIcrSeq() {
		return this.icrSeq;
	}
	
	/**
	 * Column Info
	 * @return remv
	 */
	public String getRemv() {
		return this.remv;
	}
	

	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
	}
	
	/**
	 * Column Info
	 * @param oldCntrCFlag
	 */
	public void setOldCntrCFlag(String oldCntrCFlag) {
		this.oldCntrCFlag = oldCntrCFlag;
	}
	
	/**
	 * Column Info
	 * @param qty69
	 */
	public void setQty69(String qty69) {
		this.qty69 = qty69;
	}
	
	/**
	 * Column Info
	 * @param ircQty
	 */
	public void setIrcQty(String ircQty) {
		this.ircQty = ircQty;
	}
	
	/**
	 * Column Info
	 * @param oldCntrCflag
	 */
	public void setOldCntrCflag(String oldCntrCflag) {
		this.oldCntrCflag = oldCntrCflag;
	}
	
	/**
	 * Column Info
	 * @param hold
	 */
	public void setHold(String hold) {
		this.hold = hold;
	}
	
	/**
	 * Column Info
	 * @param inBl
	 */
	public void setInBl(String inBl) {
		this.inBl = inBl;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param oldHoldRemark
	 */
	public void setOldHoldRemark(String oldHoldRemark) {
		this.oldHoldRemark = oldHoldRemark;
	}
	
	/**
	 * Column Info
	 * @param icrSeq
	 */
	public void setIcrSeq(String icrSeq) {
		this.icrSeq = icrSeq;
	}
	
	/**
	 * Column Info
	 * @param remv
	 */
	public void setRemv(String remv) {
		this.remv = remv;
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
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setInPod(JSPUtil.getParameter(request, prefix + "in_pod", ""));
		setOldCntrCFlag(JSPUtil.getParameter(request, prefix + "old_cntr_c_flag", ""));
		setQty69(JSPUtil.getParameter(request, prefix + "qty69", ""));
		setIrcQty(JSPUtil.getParameter(request, prefix + "irc_qty", ""));
		setOldCntrCflag(JSPUtil.getParameter(request, prefix + "old_cntr_cflag", ""));
		setHold(JSPUtil.getParameter(request, prefix + "hold", ""));
		setInBl(JSPUtil.getParameter(request, prefix + "in_bl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldHoldRemark(JSPUtil.getParameter(request, prefix + "old_hold_remark", ""));
		setIcrSeq(JSPUtil.getParameter(request, prefix + "icr_seq", ""));
		setRemv(JSPUtil.getParameter(request, prefix + "remv", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaResultCntrVO[]
	 */
	public UsaResultCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaResultCntrVO[]
	 */
	public UsaResultCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaResultCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] oldCntrCFlag = (JSPUtil.getParameter(request, prefix	+ "old_cntr_c_flag", length));
			String[] qty69 = (JSPUtil.getParameter(request, prefix	+ "qty69", length));
			String[] ircQty = (JSPUtil.getParameter(request, prefix	+ "irc_qty", length));
			String[] oldCntrCflag = (JSPUtil.getParameter(request, prefix	+ "old_cntr_cflag", length));
			String[] hold = (JSPUtil.getParameter(request, prefix	+ "hold", length));
			String[] inBl = (JSPUtil.getParameter(request, prefix	+ "in_bl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldHoldRemark = (JSPUtil.getParameter(request, prefix	+ "old_hold_remark", length));
			String[] icrSeq = (JSPUtil.getParameter(request, prefix	+ "icr_seq", length));
			String[] remv = (JSPUtil.getParameter(request, prefix	+ "remv", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaResultCntrVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (oldCntrCFlag[i] != null)
					model.setOldCntrCFlag(oldCntrCFlag[i]);
				if (qty69[i] != null)
					model.setQty69(qty69[i]);
				if (ircQty[i] != null)
					model.setIrcQty(ircQty[i]);
				if (oldCntrCflag[i] != null)
					model.setOldCntrCflag(oldCntrCflag[i]);
				if (hold[i] != null)
					model.setHold(hold[i]);
				if (inBl[i] != null)
					model.setInBl(inBl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldHoldRemark[i] != null)
					model.setOldHoldRemark(oldHoldRemark[i]);
				if (icrSeq[i] != null)
					model.setIcrSeq(icrSeq[i]);
				if (remv[i] != null)
					model.setRemv(remv[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaResultCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaResultCntrVO[]
	 */
	public UsaResultCntrVO[] getUsaResultCntrVOs(){
		UsaResultCntrVO[] vos = (UsaResultCntrVO[])models.toArray(new UsaResultCntrVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCntrCFlag = this.oldCntrCFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty69 = this.qty69 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ircQty = this.ircQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCntrCflag = this.oldCntrCflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hold = this.hold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBl = this.inBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldHoldRemark = this.oldHoldRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icrSeq = this.icrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remv = this.remv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
