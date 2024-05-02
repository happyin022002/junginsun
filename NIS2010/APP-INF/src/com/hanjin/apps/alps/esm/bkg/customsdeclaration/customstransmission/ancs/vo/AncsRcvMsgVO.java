/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsRcvMsgVO.java
*@FileTitle : AncsRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.10 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsRcvMsgVO extends RcvMsgVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsRcvMsgVO> models = new ArrayList<AncsRcvMsgVO>();
	
	/* Column Info */
	private String errDtl = null;
	/* Column Info */
	private String dclrNo = null;
	/* Column Info */
	private String number = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errDiv = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String msgstart = null;
	/* Column Info */
	private String rcvSts = null;
	/* Column Info */
	private String errLoc = null;
	/* Column Info */
	private String errCd = null;
	
	private String[] sFlatFileArry = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsRcvMsgVO() {}

	public AncsRcvMsgVO(String ibflag, String pagerows, String msgstart, String dclrNo, String msgId, String refSeq, String rcvSts, String errDiv, String number, String errLoc, String errCd, String errDesc, String errDtl) {
		this.errDtl = errDtl;
		this.dclrNo = dclrNo;
		this.number = number;
		this.pagerows = pagerows;
		this.errDiv = errDiv;
		this.ibflag = ibflag;
		this.refSeq = refSeq;
		this.errDesc = errDesc;
		this.msgId = msgId;
		this.msgstart = msgstart;
		this.rcvSts = rcvSts;
		this.errLoc = errLoc;
		this.errCd = errCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("err_dtl", getErrDtl());
		this.hashColumns.put("dclr_no", getDclrNo());
		this.hashColumns.put("number", getNumber());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("err_div", getErrDiv());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("msgstart", getMsgstart());
		this.hashColumns.put("rcv_sts", getRcvSts());
		this.hashColumns.put("err_loc", getErrLoc());
		this.hashColumns.put("err_cd", getErrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("err_dtl", "errDtl");
		this.hashFields.put("dclr_no", "dclrNo");
		this.hashFields.put("number", "number");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("err_div", "errDiv");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("msgstart", "msgstart");
		this.hashFields.put("rcv_sts", "rcvSts");
		this.hashFields.put("err_loc", "errLoc");
		this.hashFields.put("err_cd", "errCd");
		return this.hashFields;
	}
	
	
	public String[] getSFlatFileArry() {
		return sFlatFileArry;
	}

	public void setSFlatFileArry(String[] flatFileArry) {
		sFlatFileArry = flatFileArry;
	}

	/**
	 * Column Info
	 * @return errDtl
	 */
	public String getErrDtl() {
		return this.errDtl;
	}
	
	/**
	 * Column Info
	 * @return dclrNo
	 */
	public String getDclrNo() {
		return this.dclrNo;
	}
	
	/**
	 * Column Info
	 * @return number
	 */
	public String getNumber() {
		return this.number;
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
	 * @return errDiv
	 */
	public String getErrDiv() {
		return this.errDiv;
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
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
	}
	
	/**
	 * Column Info
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 * Column Info
	 * @return msgstart
	 */
	public String getMsgstart() {
		return this.msgstart;
	}
	
	/**
	 * Column Info
	 * @return rcvSts
	 */
	public String getRcvSts() {
		return this.rcvSts;
	}
	
	/**
	 * Column Info
	 * @return errLoc
	 */
	public String getErrLoc() {
		return this.errLoc;
	}
	
	/**
	 * Column Info
	 * @return errCd
	 */
	public String getErrCd() {
		return this.errCd;
	}
	

	/**
	 * Column Info
	 * @param errDtl
	 */
	public void setErrDtl(String errDtl) {
		this.errDtl = errDtl;
	}
	
	/**
	 * Column Info
	 * @param dclrNo
	 */
	public void setDclrNo(String dclrNo) {
		this.dclrNo = dclrNo;
	}
	
	/**
	 * Column Info
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param errDiv
	 */
	public void setErrDiv(String errDiv) {
		this.errDiv = errDiv;
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
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}
	
	/**
	 * Column Info
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param msgstart
	 */
	public void setMsgstart(String msgstart) {
		this.msgstart = msgstart;
	}
	
	/**
	 * Column Info
	 * @param rcvSts
	 */
	public void setRcvSts(String rcvSts) {
		this.rcvSts = rcvSts;
	}
	
	/**
	 * Column Info
	 * @param errLoc
	 */
	public void setErrLoc(String errLoc) {
		this.errLoc = errLoc;
	}
	
	/**
	 * Column Info
	 * @param errCd
	 */
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setErrDtl(JSPUtil.getParameter(request, "err_dtl", ""));
		setDclrNo(JSPUtil.getParameter(request, "dclr_no", ""));
		setNumber(JSPUtil.getParameter(request, "number", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setErrDiv(JSPUtil.getParameter(request, "err_div", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setErrDesc(JSPUtil.getParameter(request, "err_desc", ""));
		setMsgId(JSPUtil.getParameter(request, "msg_id", ""));
		setMsgstart(JSPUtil.getParameter(request, "msgstart", ""));
		setRcvSts(JSPUtil.getParameter(request, "rcv_sts", ""));
		setErrLoc(JSPUtil.getParameter(request, "err_loc", ""));
		setErrCd(JSPUtil.getParameter(request, "err_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SqlNameVO[]
	 */
	public AncsRcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SqlNameVO[]
	 */
	public AncsRcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsRcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] errDtl = (JSPUtil.getParameter(request, prefix	+ "err_dtl", length));
			String[] dclrNo = (JSPUtil.getParameter(request, prefix	+ "dclr_no", length));
			String[] number = (JSPUtil.getParameter(request, prefix	+ "number", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errDiv = (JSPUtil.getParameter(request, prefix	+ "err_div", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] msgstart = (JSPUtil.getParameter(request, prefix	+ "msgstart", length));
			String[] rcvSts = (JSPUtil.getParameter(request, prefix	+ "rcv_sts", length));
			String[] errLoc = (JSPUtil.getParameter(request, prefix	+ "err_loc", length));
			String[] errCd = (JSPUtil.getParameter(request, prefix	+ "err_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsRcvMsgVO();
				if (errDtl[i] != null)
					model.setErrDtl(errDtl[i]);
				if (dclrNo[i] != null)
					model.setDclrNo(dclrNo[i]);
				if (number[i] != null)
					model.setNumber(number[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errDiv[i] != null)
					model.setErrDiv(errDiv[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (msgstart[i] != null)
					model.setMsgstart(msgstart[i]);
				if (rcvSts[i] != null)
					model.setRcvSts(rcvSts[i]);
				if (errLoc[i] != null)
					model.setErrLoc(errLoc[i]);
				if (errCd[i] != null)
					model.setErrCd(errCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSqlNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SqlNameVO[]
	 */
	public AncsRcvMsgVO[] getSqlNameVOs(){
		AncsRcvMsgVO[] vos = (AncsRcvMsgVO[])models.toArray(new AncsRcvMsgVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.errDtl = this.errDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dclrNo = this.dclrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.number = this.number .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDiv = this.errDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgstart = this.msgstart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSts = this.rcvSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errLoc = this.errLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCd = this.errCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
