/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TmlVslInfoVO.java
*@FileTitle : TmlVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TmlVslInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TmlVslInfoVO> models = new ArrayList<TmlVslInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslDir = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String vslFullNm = null;
	/* Column Info */
	private String callSign = null;
	/* Column Info */
	private String vslVoy = null;
	/* Column Info */
	private String msgType = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TmlVslInfoVO() {}

	public TmlVslInfoVO(String ibflag, String pagerows, String msgType, String sndDt, String vslCd, String vslVoy, String vslDir, String callSign, String imoNo, String vslFullNm) {
		this.vslCd = vslCd;
		this.vslDir = vslDir;
		this.ibflag = ibflag;
		this.imoNo = imoNo;
		this.vslFullNm = vslFullNm;
		this.callSign = callSign;
		this.vslVoy = vslVoy;
		this.msgType = msgType;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_dir", getVslDir());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("vsl_full_nm", getVslFullNm());
		this.hashColumns.put("call_sign", getCallSign());
		this.hashColumns.put("vsl_voy", getVslVoy());
		this.hashColumns.put("msg_type", getMsgType());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_dir", "vslDir");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("vsl_full_nm", "vslFullNm");
		this.hashFields.put("call_sign", "callSign");
		this.hashFields.put("vsl_voy", "vslVoy");
		this.hashFields.put("msg_type", "msgType");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vslDir
	 */
	public String getVslDir() {
		return this.vslDir;
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
	 * @return imoNo
	 */
	public String getImoNo() {
		return this.imoNo;
	}
	
	/**
	 * Column Info
	 * @return vslFullNm
	 */
	public String getVslFullNm() {
		return this.vslFullNm;
	}
	
	/**
	 * Column Info
	 * @return callSign
	 */
	public String getCallSign() {
		return this.callSign;
	}
	
	/**
	 * Column Info
	 * @return vslVoy
	 */
	public String getVslVoy() {
		return this.vslVoy;
	}
	
	/**
	 * Column Info
	 * @return msgType
	 */
	public String getMsgType() {
		return this.msgType;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vslDir
	 */
	public void setVslDir(String vslDir) {
		this.vslDir = vslDir;
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
	 * @param imoNo
	 */
	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
	}
	
	/**
	 * Column Info
	 * @param vslFullNm
	 */
	public void setVslFullNm(String vslFullNm) {
		this.vslFullNm = vslFullNm;
	}
	
	/**
	 * Column Info
	 * @param callSign
	 */
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	
	/**
	 * Column Info
	 * @param vslVoy
	 */
	public void setVslVoy(String vslVoy) {
		this.vslVoy = vslVoy;
	}
	
	/**
	 * Column Info
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVslDir(JSPUtil.getParameter(request, "vsl_dir", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setImoNo(JSPUtil.getParameter(request, "imo_no", ""));
		setVslFullNm(JSPUtil.getParameter(request, "vsl_full_nm", ""));
		setCallSign(JSPUtil.getParameter(request, "call_sign", ""));
		setVslVoy(JSPUtil.getParameter(request, "vsl_voy", ""));
		setMsgType(JSPUtil.getParameter(request, "msg_type", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TmlVslInfoVO[]
	 */
	public TmlVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TmlVslInfoVO[]
	 */
	public TmlVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TmlVslInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslDir = (JSPUtil.getParameter(request, prefix	+ "vsl_dir", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] vslFullNm = (JSPUtil.getParameter(request, prefix	+ "vsl_full_nm", length));
			String[] callSign = (JSPUtil.getParameter(request, prefix	+ "call_sign", length));
			String[] vslVoy = (JSPUtil.getParameter(request, prefix	+ "vsl_voy", length));
			String[] msgType = (JSPUtil.getParameter(request, prefix	+ "msg_type", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TmlVslInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslDir[i] != null)
					model.setVslDir(vslDir[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (vslFullNm[i] != null)
					model.setVslFullNm(vslFullNm[i]);
				if (callSign[i] != null)
					model.setCallSign(callSign[i]);
				if (vslVoy[i] != null)
					model.setVslVoy(vslVoy[i]);
				if (msgType[i] != null)
					model.setMsgType(msgType[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTmlVslInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TmlVslInfoVO[]
	 */
	public TmlVslInfoVO[] getTmlVslInfoVOs(){
		TmlVslInfoVO[] vos = (TmlVslInfoVO[])models.toArray(new TmlVslInfoVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDir = this.vslDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullNm = this.vslFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSign = this.callSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVoy = this.vslVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgType = this.msgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
