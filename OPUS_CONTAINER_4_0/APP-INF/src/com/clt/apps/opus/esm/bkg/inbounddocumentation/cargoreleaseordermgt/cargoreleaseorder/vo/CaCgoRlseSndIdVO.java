/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CaCgoRlseSndIdVO.java
*@FileTitle : CaCgoRlseSndIdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.07.30 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class CaCgoRlseSndIdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaCgoRlseSndIdVO> models = new ArrayList<CaCgoRlseSndIdVO>();
	
	/* Column Info */
	private String msgTp = null;
	/* Column Info */
	private String ediMsgId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String ediRcvId = null;
	/* Column Info */
	private String ediYard = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaCgoRlseSndIdVO() {}

	public CaCgoRlseSndIdVO(String ibflag, String pagerows, String ediMsgId, String ediRcvId, String ediYard, String ediSndId, String msgTp) {
		this.msgTp = msgTp;
		this.ediMsgId = ediMsgId;
		this.ibflag = ibflag;
		this.ediSndId = ediSndId;
		this.ediRcvId = ediRcvId;
		this.ediYard = ediYard;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_tp", getMsgTp());
		this.hashColumns.put("edi_msg_id", getEdiMsgId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("edi_rcv_id", getEdiRcvId());
		this.hashColumns.put("edi_yard", getEdiYard());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_tp", "msgTp");
		this.hashFields.put("edi_msg_id", "ediMsgId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("edi_rcv_id", "ediRcvId");
		this.hashFields.put("edi_yard", "ediYard");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgTp
	 */
	public String getMsgTp() {
		return this.msgTp;
	}
	
	/**
	 * Column Info
	 * @return ediMsgId
	 */
	public String getEdiMsgId() {
		return this.ediMsgId;
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
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
	}
	
	/**
	 * Column Info
	 * @return ediRcvId
	 */
	public String getEdiRcvId() {
		return this.ediRcvId;
	}
	
	/**
	 * Column Info
	 * @return ediYard
	 */
	public String getEdiYard() {
		return this.ediYard;
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
	 * @param msgTp
	 */
	public void setMsgTp(String msgTp) {
		this.msgTp = msgTp;
	}
	
	/**
	 * Column Info
	 * @param ediMsgId
	 */
	public void setEdiMsgId(String ediMsgId) {
		this.ediMsgId = ediMsgId;
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
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
	}
	
	/**
	 * Column Info
	 * @param ediRcvId
	 */
	public void setEdiRcvId(String ediRcvId) {
		this.ediRcvId = ediRcvId;
	}
	
	/**
	 * Column Info
	 * @param ediYard
	 */
	public void setEdiYard(String ediYard) {
		this.ediYard = ediYard;
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
		setMsgTp(JSPUtil.getParameter(request, prefix + "msg_tp", ""));
		setEdiMsgId(JSPUtil.getParameter(request, prefix + "edi_msg_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiSndId(JSPUtil.getParameter(request, prefix + "edi_snd_id", ""));
		setEdiRcvId(JSPUtil.getParameter(request, prefix + "edi_rcv_id", ""));
		setEdiYard(JSPUtil.getParameter(request, prefix + "edi_yard", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaCgoRlseSndIdVO[]
	 */
	public CaCgoRlseSndIdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaCgoRlseSndIdVO[]
	 */
	public CaCgoRlseSndIdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaCgoRlseSndIdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgTp = (JSPUtil.getParameter(request, prefix	+ "msg_tp", length));
			String[] ediMsgId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] ediRcvId = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_id", length));
			String[] ediYard = (JSPUtil.getParameter(request, prefix	+ "edi_yard", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaCgoRlseSndIdVO();
				if (msgTp[i] != null)
					model.setMsgTp(msgTp[i]);
				if (ediMsgId[i] != null)
					model.setEdiMsgId(ediMsgId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (ediRcvId[i] != null)
					model.setEdiRcvId(ediRcvId[i]);
				if (ediYard[i] != null)
					model.setEdiYard(ediYard[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaCgoRlseSndIdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaCgoRlseSndIdVO[]
	 */
	public CaCgoRlseSndIdVO[] getCaCgoRlseSndIdVOs(){
		CaCgoRlseSndIdVO[] vos = (CaCgoRlseSndIdVO[])models.toArray(new CaCgoRlseSndIdVO[models.size()]);
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
		this.msgTp = this.msgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgId = this.ediMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvId = this.ediRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediYard = this.ediYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
