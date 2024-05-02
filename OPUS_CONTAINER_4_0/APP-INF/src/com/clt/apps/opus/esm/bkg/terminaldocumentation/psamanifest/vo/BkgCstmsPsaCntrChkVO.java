/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsPsaCntrChkVO.java
*@FileTitle : BkgCstmsPsaCntrChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.22
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsPsaCntrChkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgCstmsPsaCntrChkVO> models = new ArrayList<BkgCstmsPsaCntrChkVO>();

	/* Column Info */
	private String undDeckTpId = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String transTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdNm = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlyPort = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgCstmsPsaCntrChkVO() {}

	public BkgCstmsPsaCntrChkVO(String ibflag, String pagerows, String vvd, String rlyPort, String transTpCd, String undDeckTpId, String cntrTpCd, String cntrSzCd, String vvdNm, String special, String portCd, String userId, String cntrNo) {
		this.undDeckTpId = undDeckTpId;
		this.cntrSzCd = cntrSzCd;
		this.transTpCd = transTpCd;
		this.pagerows = pagerows;
		this.vvdNm = vvdNm;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.rlyPort = rlyPort;
		this.cntrTpCd = cntrTpCd;
		this.cntrNo = cntrNo;
		this.userId = userId;
		this.special = special;
		this.portCd = portCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("und_deck_tp_id", getUndDeckTpId());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("trans_tp_cd", getTransTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rly_port", getRlyPort());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("und_deck_tp_id", "undDeckTpId");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("trans_tp_cd", "transTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rly_port", "rlyPort");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("special", "special");
		this.hashFields.put("port_cd", "portCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return undDeckTpId
	 */
	public String getUndDeckTpId() {
		return this.undDeckTpId;
	}

	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
	}

	/**
	 * Column Info
	 * @return transTpCd
	 */
	public String getTransTpCd() {
		return this.transTpCd;
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
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
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
	 * @return rlyPort
	 */
	public String getRlyPort() {
		return this.rlyPort;
	}

	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}


	/**
	 * Column Info
	 * @param undDeckTpId
	 */
	public void setUndDeckTpId(String undDeckTpId) {
		this.undDeckTpId = undDeckTpId;
	}

	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}

	/**
	 * Column Info
	 * @param transTpCd
	 */
	public void setTransTpCd(String transTpCd) {
		this.transTpCd = transTpCd;
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
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
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
	 * @param rlyPort
	 */
	public void setRlyPort(String rlyPort) {
		this.rlyPort = rlyPort;
	}

	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUndDeckTpId(JSPUtil.getParameter(request, "und_deck_tp_id", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
		setTransTpCd(JSPUtil.getParameter(request, "trans_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdNm(JSPUtil.getParameter(request, "vvd_nm", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRlyPort(JSPUtil.getParameter(request, "rly_port", ""));
		setCntrTpCd(JSPUtil.getParameter(request, "cntr_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setSpecial(JSPUtil.getParameter(request, "special", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsPsaCntrChkVO[]
	 */
	public BkgCstmsPsaCntrChkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgCstmsPsaCntrChkVO[]
	 */
	public BkgCstmsPsaCntrChkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsPsaCntrChkVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] undDeckTpId = (JSPUtil.getParameter(request, prefix	+ "und_deck_tp_id", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] transTpCd = (JSPUtil.getParameter(request, prefix	+ "trans_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlyPort = (JSPUtil.getParameter(request, prefix	+ "rly_port", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));

			for (int i = 0; i < length; i++) {
				model = new BkgCstmsPsaCntrChkVO();
				if (undDeckTpId[i] != null)
					model.setUndDeckTpId(undDeckTpId[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (transTpCd[i] != null)
					model.setTransTpCd(transTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlyPort[i] != null)
					model.setRlyPort(rlyPort[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsPsaCntrChkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsPsaCntrChkVO[]
	 */
	public BkgCstmsPsaCntrChkVO[] getBkgCstmsPsaCntrChkVOs(){
		BkgCstmsPsaCntrChkVO[] vos = (BkgCstmsPsaCntrChkVO[])models.toArray(new BkgCstmsPsaCntrChkVO[models.size()]);
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
		this.undDeckTpId = this.undDeckTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTpCd = this.transTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPort = this.rlyPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
