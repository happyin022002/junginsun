/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelSearchRcvHisVO.java
*@FileTitle : IsraelSearchRcvHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.09.11 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo;

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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IsraelSearchRcvHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IsraelSearchRcvHisVO> models = new ArrayList<IsraelSearchRcvHisVO>();
	
	/* Column Info */
	private String rjctRsnRmk = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ackDt = null;
	/* Column Info */
	private String eurCstmsRjctCd = null;
	/* Column Info */
	private String cstmsErrId = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cstmsErrMsg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eurAckRcvStsCd = null;
	/* Column Info */
	private String rjctDt = null;
	/* Column Info */
	private String ackKndId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IsraelSearchRcvHisVO() {}

	public IsraelSearchRcvHisVO(String ibflag, String pagerows, String ackKndId, String eurAckRcvStsCd, String ackDt, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String eurCstmsRjctCd, String rjctRsnRmk, String rjctDt, String cstmsErrId, String cstmsErrMsg) {
		this.rjctRsnRmk = rjctRsnRmk;
		this.vslCd = vslCd;
		this.ackDt = ackDt;
		this.eurCstmsRjctCd = eurCstmsRjctCd;
		this.cstmsErrId = cstmsErrId;
		this.skdVoyNo = skdVoyNo;
		this.cstmsErrMsg = cstmsErrMsg;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.eurAckRcvStsCd = eurAckRcvStsCd;
		this.rjctDt = rjctDt;
		this.ackKndId = ackKndId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ack_dt", getAckDt());
		this.hashColumns.put("eur_cstms_rjct_cd", getEurCstmsRjctCd());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eur_ack_rcv_sts_cd", getEurAckRcvStsCd());
		this.hashColumns.put("rjct_dt", getRjctDt());
		this.hashColumns.put("ack_knd_id", getAckKndId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ack_dt", "ackDt");
		this.hashFields.put("eur_cstms_rjct_cd", "eurCstmsRjctCd");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eur_ack_rcv_sts_cd", "eurAckRcvStsCd");
		this.hashFields.put("rjct_dt", "rjctDt");
		this.hashFields.put("ack_knd_id", "ackKndId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rjctRsnRmk
	 */
	public String getRjctRsnRmk() {
		return this.rjctRsnRmk;
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
	 * @return ackDt
	 */
	public String getAckDt() {
		return this.ackDt;
	}
	
	/**
	 * Column Info
	 * @return eurCstmsRjctCd
	 */
	public String getEurCstmsRjctCd() {
		return this.eurCstmsRjctCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrId
	 */
	public String getCstmsErrId() {
		return this.cstmsErrId;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrMsg
	 */
	public String getCstmsErrMsg() {
		return this.cstmsErrMsg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return eurAckRcvStsCd
	 */
	public String getEurAckRcvStsCd() {
		return this.eurAckRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @return rjctDt
	 */
	public String getRjctDt() {
		return this.rjctDt;
	}
	
	/**
	 * Column Info
	 * @return ackKndId
	 */
	public String getAckKndId() {
		return this.ackKndId;
	}
	

	/**
	 * Column Info
	 * @param rjctRsnRmk
	 */
	public void setRjctRsnRmk(String rjctRsnRmk) {
		this.rjctRsnRmk = rjctRsnRmk;
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
	 * @param ackDt
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}
	
	/**
	 * Column Info
	 * @param eurCstmsRjctCd
	 */
	public void setEurCstmsRjctCd(String eurCstmsRjctCd) {
		this.eurCstmsRjctCd = eurCstmsRjctCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrId
	 */
	public void setCstmsErrId(String cstmsErrId) {
		this.cstmsErrId = cstmsErrId;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrMsg
	 */
	public void setCstmsErrMsg(String cstmsErrMsg) {
		this.cstmsErrMsg = cstmsErrMsg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param eurAckRcvStsCd
	 */
	public void setEurAckRcvStsCd(String eurAckRcvStsCd) {
		this.eurAckRcvStsCd = eurAckRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @param rjctDt
	 */
	public void setRjctDt(String rjctDt) {
		this.rjctDt = rjctDt;
	}
	
	/**
	 * Column Info
	 * @param ackKndId
	 */
	public void setAckKndId(String ackKndId) {
		this.ackKndId = ackKndId;
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
		setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAckDt(JSPUtil.getParameter(request, prefix + "ack_dt", ""));
		setEurCstmsRjctCd(JSPUtil.getParameter(request, prefix + "eur_cstms_rjct_cd", ""));
		setCstmsErrId(JSPUtil.getParameter(request, prefix + "cstms_err_id", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEurAckRcvStsCd(JSPUtil.getParameter(request, prefix + "eur_ack_rcv_sts_cd", ""));
		setRjctDt(JSPUtil.getParameter(request, prefix + "rjct_dt", ""));
		setAckKndId(JSPUtil.getParameter(request, prefix + "ack_knd_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IsraelSearchRcvHisVO[]
	 */
	public IsraelSearchRcvHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IsraelSearchRcvHisVO[]
	 */
	public IsraelSearchRcvHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IsraelSearchRcvHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix	+ "rjct_rsn_rmk", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ackDt = (JSPUtil.getParameter(request, prefix	+ "ack_dt", length));
			String[] eurCstmsRjctCd = (JSPUtil.getParameter(request, prefix	+ "eur_cstms_rjct_cd", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eurAckRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "eur_ack_rcv_sts_cd", length));
			String[] rjctDt = (JSPUtil.getParameter(request, prefix	+ "rjct_dt", length));
			String[] ackKndId = (JSPUtil.getParameter(request, prefix	+ "ack_knd_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new IsraelSearchRcvHisVO();
				if (rjctRsnRmk[i] != null)
					model.setRjctRsnRmk(rjctRsnRmk[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ackDt[i] != null)
					model.setAckDt(ackDt[i]);
				if (eurCstmsRjctCd[i] != null)
					model.setEurCstmsRjctCd(eurCstmsRjctCd[i]);
				if (cstmsErrId[i] != null)
					model.setCstmsErrId(cstmsErrId[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cstmsErrMsg[i] != null)
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eurAckRcvStsCd[i] != null)
					model.setEurAckRcvStsCd(eurAckRcvStsCd[i]);
				if (rjctDt[i] != null)
					model.setRjctDt(rjctDt[i]);
				if (ackKndId[i] != null)
					model.setAckKndId(ackKndId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIsraelSearchRcvHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IsraelSearchRcvHisVO[]
	 */
	public IsraelSearchRcvHisVO[] getIsraelSearchRcvHisVOs(){
		IsraelSearchRcvHisVO[] vos = (IsraelSearchRcvHisVO[])models.toArray(new IsraelSearchRcvHisVO[models.size()]);
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
		this.rjctRsnRmk = this.rjctRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDt = this.ackDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurCstmsRjctCd = this.eurCstmsRjctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurAckRcvStsCd = this.eurAckRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctDt = this.rjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackKndId = this.ackKndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
