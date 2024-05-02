/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgSendHistoryVO.java
*@FileTitle : DgSendHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.07
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

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

public class DgSendHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DgSendHistoryVO> models = new ArrayList<DgSendHistoryVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eurEdiMsgTpId = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String autoSndTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String msgFuncId = null;
	/* Column Info */
	private String eurDgDeclTpCd = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String keyVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DgSendHistoryVO() {}

	public DgSendHistoryVO(String ibflag, String pagerows, String eurEdiMsgTpId, String msgSndNo, String sndDt, String sndUsrId, String autoSndTpCd, String msgFuncId, String eurDgDeclTpCd, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String creUsrId, String creDt, String updUsrId, String updDt, String vvdCd, String keyVal, String msgDesc) {
		this.updDt = updDt;
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.vslCd = vslCd;
		this.msgDesc = msgDesc;
		this.autoSndTpCd = autoSndTpCd;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.sndDt = sndDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sndUsrId = sndUsrId;
		this.vvdCd = vvdCd;
		this.msgFuncId = msgFuncId;
		this.eurDgDeclTpCd = eurDgDeclTpCd;
		this.msgSndNo = msgSndNo;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.keyVal = keyVal;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("auto_snd_tp_cd", getAutoSndTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("msg_func_id", getMsgFuncId());
		this.hashColumns.put("eur_dg_decl_tp_cd", getEurDgDeclTpCd());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("key_val", getKeyVal());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("auto_snd_tp_cd", "autoSndTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("msg_func_id", "msgFuncId");
		this.hashFields.put("eur_dg_decl_tp_cd", "eurDgDeclTpCd");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("key_val", "keyVal");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * @return eurEdiMsgTpId
	 */
	public String getEurEdiMsgTpId() {
		return this.eurEdiMsgTpId;
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
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}

	/**
	 * Column Info
	 * @return autoSndTpCd
	 */
	public String getAutoSndTpCd() {
		return this.autoSndTpCd;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return msgFuncId
	 */
	public String getMsgFuncId() {
		return this.msgFuncId;
	}

	/**
	 * Column Info
	 * @return eurDgDeclTpCd
	 */
	public String getEurDgDeclTpCd() {
		return this.eurDgDeclTpCd;
	}

	/**
	 * Column Info
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * @return keyVal
	 */
	public String getKeyVal() {
		return this.keyVal;
	}


	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param eurEdiMsgTpId
	 */
	public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
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
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	/**
	 * Column Info
	 * @param autoSndTpCd
	 */
	public void setAutoSndTpCd(String autoSndTpCd) {
		this.autoSndTpCd = autoSndTpCd;
	}

	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param msgFuncId
	 */
	public void setMsgFuncId(String msgFuncId) {
		this.msgFuncId = msgFuncId;
	}

	/**
	 * Column Info
	 * @param eurDgDeclTpCd
	 */
	public void setEurDgDeclTpCd(String eurDgDeclTpCd) {
		this.eurDgDeclTpCd = eurDgDeclTpCd;
	}

	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param keyVal
	 */
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setEurEdiMsgTpId(JSPUtil.getParameter(request, "eur_edi_msg_tp_id", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setAutoSndTpCd(JSPUtil.getParameter(request, "auto_snd_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setMsgFuncId(JSPUtil.getParameter(request, "msg_func_id", ""));
		setEurDgDeclTpCd(JSPUtil.getParameter(request, "eur_dg_decl_tp_cd", ""));
		setMsgSndNo(JSPUtil.getParameter(request, "msg_snd_no", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setKeyVal(JSPUtil.getParameter(request, "key_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgSendHistoryVO[]
	 */
	public DgSendHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DgSendHistoryVO[]
	 */
	public DgSendHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgSendHistoryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] autoSndTpCd = (JSPUtil.getParameter(request, prefix	+ "auto_snd_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] msgFuncId = (JSPUtil.getParameter(request, prefix	+ "msg_func_id", length));
			String[] eurDgDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "eur_dg_decl_tp_cd", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] keyVal = (JSPUtil.getParameter(request, prefix	+ "key_val", length));

			for (int i = 0; i < length; i++) {
				model = new DgSendHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eurEdiMsgTpId[i] != null)
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (autoSndTpCd[i] != null)
					model.setAutoSndTpCd(autoSndTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (msgFuncId[i] != null)
					model.setMsgFuncId(msgFuncId[i]);
				if (eurDgDeclTpCd[i] != null)
					model.setEurDgDeclTpCd(eurDgDeclTpCd[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (keyVal[i] != null)
					model.setKeyVal(keyVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgSendHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgSendHistoryVO[]
	 */
	public DgSendHistoryVO[] getDgSendHistoryVOs(){
		DgSendHistoryVO[] vos = (DgSendHistoryVO[])models.toArray(new DgSendHistoryVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndTpCd = this.autoSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncId = this.msgFuncId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgDeclTpCd = this.eurDgDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyVal = this.keyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
