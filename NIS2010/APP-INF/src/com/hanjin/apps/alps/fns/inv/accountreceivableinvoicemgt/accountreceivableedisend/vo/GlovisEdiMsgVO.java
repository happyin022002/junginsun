/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GlovisEdiMsgVO.java
*@FileTitle : GlovisEdiMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.11.29 이석준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;
   
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
 * @author 이석준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GlovisEdiMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GlovisEdiMsgVO> models = new ArrayList<GlovisEdiMsgVO>();
	
	/* Column Info */
	private String msgver = null;
	/* Column Info */
	private String snddat = null;
	/* Column Info */
	private String msgnum = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hdrMsg = null;
	/* Column Info */
	private String internalHeader = null;
	/* Column Info */
	private String seqnum = null;
	/* Column Info */
	private String detailMsg = null;
	/* Column Info */
	private String header = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlovisEdiMsgVO() {}

	public GlovisEdiMsgVO(String ibflag, String pagerows, String seqnum, String internalHeader, String header, String msgver, String msgnum, String snddat, String hdrMsg, String detailMsg) {
		this.msgver = msgver;
		this.snddat = snddat;
		this.msgnum = msgnum;
		this.ibflag = ibflag;
		this.hdrMsg = hdrMsg;
		this.internalHeader = internalHeader;
		this.seqnum = seqnum;
		this.detailMsg = detailMsg;
		this.header = header;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msgver", getMsgver());
		this.hashColumns.put("snddat", getSnddat());
		this.hashColumns.put("msgnum", getMsgnum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hdr_msg", getHdrMsg());
		this.hashColumns.put("internal_header", getInternalHeader());
		this.hashColumns.put("seqnum", getSeqnum());
		this.hashColumns.put("detail_msg", getDetailMsg());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msgver", "msgver");
		this.hashFields.put("snddat", "snddat");
		this.hashFields.put("msgnum", "msgnum");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hdr_msg", "hdrMsg");
		this.hashFields.put("internal_header", "internalHeader");
		this.hashFields.put("seqnum", "seqnum");
		this.hashFields.put("detail_msg", "detailMsg");
		this.hashFields.put("header", "header");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgver
	 */
	public String getMsgver() {
		return this.msgver;
	}
	
	/**
	 * Column Info
	 * @return snddat
	 */
	public String getSnddat() {
		return this.snddat;
	}
	
	/**
	 * Column Info
	 * @return msgnum
	 */
	public String getMsgnum() {
		return this.msgnum;
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
	 * @return hdrMsg
	 */
	public String getHdrMsg() {
		return this.hdrMsg;
	}
	
	/**
	 * Column Info
	 * @return internalHeader
	 */
	public String getInternalHeader() {
		return this.internalHeader;
	}
	
	/**
	 * Column Info
	 * @return seqnum
	 */
	public String getSeqnum() {
		return this.seqnum;
	}
	
	/**
	 * Column Info
	 * @return detailMsg
	 */
	public String getDetailMsg() {
		return this.detailMsg;
	}
	
	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
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
	 * @param msgver
	 */
	public void setMsgver(String msgver) {
		this.msgver = msgver;
	}
	
	/**
	 * Column Info
	 * @param snddat
	 */
	public void setSnddat(String snddat) {
		this.snddat = snddat;
	}
	
	/**
	 * Column Info
	 * @param msgnum
	 */
	public void setMsgnum(String msgnum) {
		this.msgnum = msgnum;
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
	 * @param hdrMsg
	 */
	public void setHdrMsg(String hdrMsg) {
		this.hdrMsg = hdrMsg;
	}
	
	/**
	 * Column Info
	 * @param internalHeader
	 */
	public void setInternalHeader(String internalHeader) {
		this.internalHeader = internalHeader;
	}
	
	/**
	 * Column Info
	 * @param seqnum
	 */
	public void setSeqnum(String seqnum) {
		this.seqnum = seqnum;
	}
	
	/**
	 * Column Info
	 * @param detailMsg
	 */
	public void setDetailMsg(String detailMsg) {
		this.detailMsg = detailMsg;
	}
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
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
		setMsgver(JSPUtil.getParameter(request, prefix + "msgver", ""));
		setSnddat(JSPUtil.getParameter(request, prefix + "snddat", ""));
		setMsgnum(JSPUtil.getParameter(request, prefix + "msgnum", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHdrMsg(JSPUtil.getParameter(request, prefix + "hdr_msg", ""));
		setInternalHeader(JSPUtil.getParameter(request, prefix + "internal_header", ""));
		setSeqnum(JSPUtil.getParameter(request, prefix + "seqnum", ""));
		setDetailMsg(JSPUtil.getParameter(request, prefix + "detail_msg", ""));
		setHeader(JSPUtil.getParameter(request, prefix + "header", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlovisEdiMsgVO[]
	 */
	public GlovisEdiMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlovisEdiMsgVO[]
	 */
	public GlovisEdiMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlovisEdiMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgver = (JSPUtil.getParameter(request, prefix	+ "msgver", length));
			String[] snddat = (JSPUtil.getParameter(request, prefix	+ "snddat", length));
			String[] msgnum = (JSPUtil.getParameter(request, prefix	+ "msgnum", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hdrMsg = (JSPUtil.getParameter(request, prefix	+ "hdr_msg", length));
			String[] internalHeader = (JSPUtil.getParameter(request, prefix	+ "internal_header", length));
			String[] seqnum = (JSPUtil.getParameter(request, prefix	+ "seqnum", length));
			String[] detailMsg = (JSPUtil.getParameter(request, prefix	+ "detail_msg", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlovisEdiMsgVO();
				if (msgver[i] != null)
					model.setMsgver(msgver[i]);
				if (snddat[i] != null)
					model.setSnddat(snddat[i]);
				if (msgnum[i] != null)
					model.setMsgnum(msgnum[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hdrMsg[i] != null)
					model.setHdrMsg(hdrMsg[i]);
				if (internalHeader[i] != null)
					model.setInternalHeader(internalHeader[i]);
				if (seqnum[i] != null)
					model.setSeqnum(seqnum[i]);
				if (detailMsg[i] != null)
					model.setDetailMsg(detailMsg[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlovisEdiMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlovisEdiMsgVO[]
	 */
	public GlovisEdiMsgVO[] getGlovisEdiMsgVOs(){
		GlovisEdiMsgVO[] vos = (GlovisEdiMsgVO[])models.toArray(new GlovisEdiMsgVO[models.size()]);
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
		this.msgver = this.msgver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snddat = this.snddat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgnum = this.msgnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrMsg = this.hdrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internalHeader = this.internalHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqnum = this.seqnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailMsg = this.detailMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
