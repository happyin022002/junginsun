/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JmsReceiveVO.java
*@FileTitle : JmsReceiveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.sample.jms.vo;

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
public class JmsReceiveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JmsReceiveVO> models = new ArrayList<JmsReceiveVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String srcSysCd = null;

	/* Column Info */
	private String msgCreDt = null;

	/* Column Info */
	private String msgId = null;

	/* Column Info */
	private String opCd = null;

	/* Column Info */
	private String msgEtt = null;

	/* Column Info */
	private String custCd = null;

	/* Column Info */
	private String custRqstId = null;

	/* Column Info */
	private String actCd = null;

	/* Column Info */
	private String actRsn = null;

	/* Column Info */
	private String usrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JmsReceiveVO() {}

	public JmsReceiveVO(String ibflag, String pagerows, String srcSysCd, String msgCreDt, String msgId, String opCd, String msgEtt, String custCd, String custRqstId, String actCd, String actRsn, String usrId) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.srcSysCd = srcSysCd;
		this.msgCreDt = msgCreDt;
		this.msgId = msgId;
		this.opCd = opCd;
		this.msgEtt = msgEtt;
		this.custCd = custCd;
		this.custRqstId = custRqstId;
		this.actCd = actCd;
		this.actRsn = actRsn;
		this.usrId = usrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("src_sys_cd", getSrcSysCd());
		this.hashColumns.put("msg_cre_dt", getMsgCreDt());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("msg_ett", getMsgEtt());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_rqst_id", getCustRqstId());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("act_rsn", getActRsn());
		this.hashColumns.put("usr_id", getUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("src_sys_cd", "srcSysCd");
		this.hashFields.put("msg_cre_dt", "msgCreDt");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("msg_ett", "msgEtt");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_rqst_id", "custRqstId");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("act_rsn", "actRsn");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String srcSysCd
	 */
	public void setSrcSysCd(String srcSysCd) {
		this.srcSysCd = srcSysCd;
	}
	
	/**
	 * 
	 * @return String srcSysCd
	 */
	public String getSrcSysCd() {
		return this.srcSysCd;
	}
	
	/**
	 *
	 * @param String msgCreDt
	 */
	public void setMsgCreDt(String msgCreDt) {
		this.msgCreDt = msgCreDt;
	}
	
	/**
	 * 
	 * @return String msgCreDt
	 */
	public String getMsgCreDt() {
		return this.msgCreDt;
	}
	
	/**
	 *
	 * @param String msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * 
	 * @return String msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 *
	 * @param String opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * 
	 * @return String opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 *
	 * @param String msgEtt
	 */
	public void setMsgEtt(String msgEtt) {
		this.msgEtt = msgEtt;
	}
	
	/**
	 * 
	 * @return String msgEtt
	 */
	public String getMsgEtt() {
		return this.msgEtt;
	}
	
	/**
	 *
	 * @param String custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * 
	 * @return String custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 *
	 * @param String custRqstId
	 */
	public void setCustRqstId(String custRqstId) {
		this.custRqstId = custRqstId;
	}
	
	/**
	 * 
	 * @return String custRqstId
	 */
	public String getCustRqstId() {
		return this.custRqstId;
	}
	
	/**
	 *
	 * @param String actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * 
	 * @return String actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 *
	 * @param String actRsn
	 */
	public void setActRsn(String actRsn) {
		this.actRsn = actRsn;
	}
	
	/**
	 * 
	 * @return String actRsn
	 */
	public String getActRsn() {
		return this.actRsn;
	}
	
	/**
	 *
	 * @param String usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * 
	 * @return String usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSrcSysCd(JSPUtil.getParameter(request, prefix + "src_sys_cd", ""));
		setMsgCreDt(JSPUtil.getParameter(request, prefix + "msg_cre_dt", ""));
		setMsgId(JSPUtil.getParameter(request, prefix + "msg_id", ""));
		setOpCd(JSPUtil.getParameter(request, prefix + "op_cd", ""));
		setMsgEtt(JSPUtil.getParameter(request, prefix + "msg_ett", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCustRqstId(JSPUtil.getParameter(request, prefix + "cust_rqst_id", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setActRsn(JSPUtil.getParameter(request, prefix + "act_rsn", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JmsReceiveVO[]
	 */
	public JmsReceiveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JmsReceiveVO[]
	 */
	public JmsReceiveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JmsReceiveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srcSysCd = (JSPUtil.getParameter(request, prefix	+ "src_sys_cd", length));
			String[] msgCreDt = (JSPUtil.getParameter(request, prefix	+ "msg_cre_dt", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] msgEtt = (JSPUtil.getParameter(request, prefix	+ "msg_ett", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custRqstId = (JSPUtil.getParameter(request, prefix	+ "cust_rqst_id", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] actRsn = (JSPUtil.getParameter(request, prefix	+ "act_rsn", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new JmsReceiveVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (srcSysCd[i] != null) 
					model.setSrcSysCd(srcSysCd[i]);
				if (msgCreDt[i] != null) 
					model.setMsgCreDt(msgCreDt[i]);
				if (msgId[i] != null) 
					model.setMsgId(msgId[i]);
				if (opCd[i] != null) 
					model.setOpCd(opCd[i]);
				if (msgEtt[i] != null) 
					model.setMsgEtt(msgEtt[i]);
				if (custCd[i] != null) 
					model.setCustCd(custCd[i]);
				if (custRqstId[i] != null) 
					model.setCustRqstId(custRqstId[i]);
				if (actCd[i] != null) 
					model.setActCd(actCd[i]);
				if (actRsn[i] != null) 
					model.setActRsn(actRsn[i]);
				if (usrId[i] != null) 
					model.setUsrId(usrId[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJmsReceiveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JmsReceiveVO[]
	 */
	public JmsReceiveVO[] getJmsReceiveVOs(){
		JmsReceiveVO[] vos = (JmsReceiveVO[])models.toArray(new JmsReceiveVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcSysCd = this.srcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCreDt = this.msgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgEtt = this.msgEtt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRqstId = this.custRqstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRsn = this.actRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}