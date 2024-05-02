/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CODNoticeVO.java
*@FileTitle : CODNoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.12.24 장석현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CODNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CODNoticeVO> models = new ArrayList<CODNoticeVO>();
	
	/* Column Info */
	private String rcvrUsrNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String msgCtnt = null;
	/* Column Info */
	private String rcvrUsrId = null;
	/* Column Info */
	private String sndrUsrId = null;
	/* Column Info */
	private String sndrUsrNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CODNoticeVO() {}

	public CODNoticeVO(String ibflag, String pagerows, String sndrUsrId, String sndrUsrNm, String msgCtnt, String rcvrUsrId, String rcvrUsrNm, String cntrNo, String bkgNo) {
		this.rcvrUsrNm = rcvrUsrNm;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.msgCtnt = msgCtnt;
		this.rcvrUsrId = rcvrUsrId;
		this.sndrUsrId = sndrUsrId;
		this.sndrUsrNm = sndrUsrNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcvr_usr_nm", getRcvrUsrNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("msg_ctnt", getMsgCtnt());
		this.hashColumns.put("rcvr_usr_id", getRcvrUsrId());
		this.hashColumns.put("sndr_usr_id", getSndrUsrId());
		this.hashColumns.put("sndr_usr_nm", getSndrUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcvr_usr_nm", "rcvrUsrNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("msg_ctnt", "msgCtnt");
		this.hashFields.put("rcvr_usr_id", "rcvrUsrId");
		this.hashFields.put("sndr_usr_id", "sndrUsrId");
		this.hashFields.put("sndr_usr_nm", "sndrUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcvrUsrNm
	 */
	public String getRcvrUsrNm() {
		return this.rcvrUsrNm;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return msgCtnt
	 */
	public String getMsgCtnt() {
		return this.msgCtnt;
	}
	
	/**
	 * Column Info
	 * @return rcvrUsrId
	 */
	public String getRcvrUsrId() {
		return this.rcvrUsrId;
	}
	
	/**
	 * Column Info
	 * @return sndrUsrId
	 */
	public String getSndrUsrId() {
		return this.sndrUsrId;
	}
	
	/**
	 * Column Info
	 * @return sndrUsrNm
	 */
	public String getSndrUsrNm() {
		return this.sndrUsrNm;
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
	 * @param rcvrUsrNm
	 */
	public void setRcvrUsrNm(String rcvrUsrNm) {
		this.rcvrUsrNm = rcvrUsrNm;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param msgCtnt
	 */
	public void setMsgCtnt(String msgCtnt) {
		this.msgCtnt = msgCtnt;
	}
	
	/**
	 * Column Info
	 * @param rcvrUsrId
	 */
	public void setRcvrUsrId(String rcvrUsrId) {
		this.rcvrUsrId = rcvrUsrId;
	}
	
	/**
	 * Column Info
	 * @param sndrUsrId
	 */
	public void setSndrUsrId(String sndrUsrId) {
		this.sndrUsrId = sndrUsrId;
	}
	
	/**
	 * Column Info
	 * @param sndrUsrNm
	 */
	public void setSndrUsrNm(String sndrUsrNm) {
		this.sndrUsrNm = sndrUsrNm;
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
		setRcvrUsrNm(JSPUtil.getParameter(request, "rcvr_usr_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMsgCtnt(JSPUtil.getParameter(request, "msg_ctnt", ""));
		setRcvrUsrId(JSPUtil.getParameter(request, "rcvr_usr_id", ""));
		setSndrUsrId(JSPUtil.getParameter(request, "sndr_usr_id", ""));
		setSndrUsrNm(JSPUtil.getParameter(request, "sndr_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CODNoticeVO[]
	 */
	public CODNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CODNoticeVO[]
	 */
	public CODNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CODNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcvrUsrNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_usr_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] msgCtnt = (JSPUtil.getParameter(request, prefix	+ "msg_ctnt", length));
			String[] rcvrUsrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_usr_id", length));
			String[] sndrUsrId = (JSPUtil.getParameter(request, prefix	+ "sndr_usr_id", length));
			String[] sndrUsrNm = (JSPUtil.getParameter(request, prefix	+ "sndr_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CODNoticeVO();
				if (rcvrUsrNm[i] != null)
					model.setRcvrUsrNm(rcvrUsrNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (msgCtnt[i] != null)
					model.setMsgCtnt(msgCtnt[i]);
				if (rcvrUsrId[i] != null)
					model.setRcvrUsrId(rcvrUsrId[i]);
				if (sndrUsrId[i] != null)
					model.setSndrUsrId(sndrUsrId[i]);
				if (sndrUsrNm[i] != null)
					model.setSndrUsrNm(sndrUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCODNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CODNoticeVO[]
	 */
	public CODNoticeVO[] getCODNoticeVOs(){
		CODNoticeVO[] vos = (CODNoticeVO[])models.toArray(new CODNoticeVO[models.size()]);
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
		this.rcvrUsrNm = this.rcvrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCtnt = this.msgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrUsrId = this.rcvrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrUsrId = this.sndrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrUsrNm = this.sndrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
