/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanReceiveLogCondVO.java
*@FileTitle : JapanReceiveLogCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.01
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
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

public class JapanReceiveLogCondVO extends ReceiveLogCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<JapanReceiveLogCondVO> models = new ArrayList<JapanReceiveLogCondVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String jpMsgTpCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Page Number */
	private String pagerows = null;

	private String iPage           	= null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanReceiveLogCondVO() {}

	public JapanReceiveLogCondVO(String ibflag, String pagerows, String jpMsgTpCd, String rcvDt, String rcvSeq) {
		this.ibflag = ibflag;
		this.jpMsgTpCd = jpMsgTpCd;
		this.rcvDt = rcvDt;
		this.rcvSeq = rcvSeq;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jp_msg_tp_cd", getJpMsgTpCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jp_msg_tp_cd", "jpMsgTpCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("rcv_seq", "rcvSeq");
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
	 * @return jpMsgTpCd
	 */
	public String getJpMsgTpCd() {
		return this.jpMsgTpCd;
	}

	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}

	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	public String getIPage() {
		return iPage;
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
	 * @param jpMsgTpCd
	 */
	public void setJpMsgTpCd(String jpMsgTpCd) {
		this.jpMsgTpCd = jpMsgTpCd;
	}

	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}

	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void setIPage(String iPage) {
		this.iPage = iPage;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setJpMsgTpCd(JSPUtil.getParameter(request, "jp_msg_tp_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage( JSPUtil.getParameter(request, "iPage", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanReceiveLogCondVO[]
	 */
	public JapanReceiveLogCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanReceiveLogCondVO[]
	 */
	public JapanReceiveLogCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanReceiveLogCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jpMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "jp_msg_tp_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new JapanReceiveLogCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jpMsgTpCd[i] != null)
					model.setJpMsgTpCd(jpMsgTpCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanReceiveLogCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanReceiveLogCondVO[]
	 */
	public JapanReceiveLogCondVO[] getJapanReceiveLogCondVOs(){
		JapanReceiveLogCondVO[] vos = (JapanReceiveLogCondVO[])models.toArray(new JapanReceiveLogCondVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpMsgTpCd = this.jpMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
