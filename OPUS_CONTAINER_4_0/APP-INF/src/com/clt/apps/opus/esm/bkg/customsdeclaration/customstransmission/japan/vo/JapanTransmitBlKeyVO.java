/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanTransmitBlKeyVO.java
*@FileTitle : JapanTransmitBlKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier :
*@LastVersion : 1.0
* 2009.06.01
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanTransmitBlKeyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<JapanTransmitBlKeyVO> models = new ArrayList<JapanTransmitBlKeyVO>();

	/* Column Info */
	private String inMsgFlag = null;
	/* Column Info */
	//private String blNoChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inCallSgnNo = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inMsgTp = null;
	/* Column Info */
	//private String blNoTp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public JapanTransmitBlKeyVO() {}

	//public BlKeyVO(String ibflag, String pagerows, String blNo, String blNoTp, String blNoChk, String blSplitNo, String inMsgTp, String inMsgFlag, String inCallSgnNo, String inVvdCd) {
	public JapanTransmitBlKeyVO(String ibflag, String pagerows, String blNo, String blSplitNo, String inMsgTp, String inMsgFlag, String inCallSgnNo, String inVvdCd) {
		this.inMsgFlag = inMsgFlag;
		//this.blNoChk = blNoChk;
		this.ibflag = ibflag;
		this.inCallSgnNo = inCallSgnNo;
		this.inVvdCd = inVvdCd;
		this.inMsgTp = inMsgTp;
		//this.blNoTp = blNoTp;
		this.blNo = blNo;
		this.blSplitNo = blSplitNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_msg_flag", getInMsgFlag());
		//this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_msg_tp", getInMsgTp());
		//this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_msg_flag", "inMsgFlag");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_msg_tp", "inMsgTp");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inMsgFlag
	 */
	public String getInMsgFlag() {
		return this.inMsgFlag;
	}

	/**
	 * Column Info
	 * @return blNoChk
	 */
	//public String getBlNoChk() {
	//	return this.blNoChk;
	//}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return inCallSgnNo
	 */
	public String getInCallSgnNo() {
		return this.inCallSgnNo;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return inMsgTp
	 */
	public String getInMsgTp() {
		return this.inMsgTp;
	}

	/**
	 * Column Info
	 * @return blNoTp
	 */
	//public String getBlNoTp() {
	//	return this.blNoTp;
	//}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
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
	 * @param inMsgFlag
	 */
	public void setInMsgFlag(String inMsgFlag) {
		this.inMsgFlag = inMsgFlag;
	}

	/**
	 * Column Info
	 * @param blNoChk
	 */
	//public void setBlNoChk(String blNoChk) {
	//	this.blNoChk = blNoChk;
	//}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * @param inCallSgnNo
	 */
	public void setInCallSgnNo(String inCallSgnNo) {
		this.inCallSgnNo = inCallSgnNo;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param inMsgTp
	 */
	public void setInMsgTp(String inMsgTp) {
		this.inMsgTp = inMsgTp;
	}

	/**
	 * Column Info
	 * @param blNoTp
	 */
	//public void setBlNoTp(String blNoTp) {
	//	this.blNoTp = blNoTp;
	//}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
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
		setInMsgFlag(JSPUtil.getParameter(request, "in_msg_flag", ""));
		//setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInCallSgnNo(JSPUtil.getParameter(request, "in_call_sgn_no", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setInMsgTp(JSPUtil.getParameter(request, "in_msg_tp", ""));
		//setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlSplitNo(JSPUtil.getParameter(request, "bl_split_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlKeyVO[]
	 */
	public JapanTransmitBlKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BlKeyVO[]
	 */
	public JapanTransmitBlKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanTransmitBlKeyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inMsgFlag = (JSPUtil.getParameter(request, prefix	+ "in_msg_flag".trim(), length));
			//String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "in_call_sgn_no".trim(), length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd".trim(), length));
			String[] inMsgTp = (JSPUtil.getParameter(request, prefix	+ "in_msg_tp".trim(), length));
			//String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new JapanTransmitBlKeyVO();
				if (inMsgFlag[i] != null)
					model.setInMsgFlag(inMsgFlag[i]);
				//if (blNoChk[i] != null)
				//	model.setBlNoChk(blNoChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inCallSgnNo[i] != null)
					model.setInCallSgnNo(inCallSgnNo[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inMsgTp[i] != null)
					model.setInMsgTp(inMsgTp[i]);
				//if (blNoTp[i] != null)
				//	model.setBlNoTp(blNoTp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlKeyVO[]
	 */
	public JapanTransmitBlKeyVO[] getBlKeyVOs(){
		JapanTransmitBlKeyVO[] vos = (JapanTransmitBlKeyVO[])models.toArray(new JapanTransmitBlKeyVO[models.size()]);
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
		this.inMsgFlag = this.inMsgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCallSgnNo = this.inCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMsgTp = this.inMsgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
