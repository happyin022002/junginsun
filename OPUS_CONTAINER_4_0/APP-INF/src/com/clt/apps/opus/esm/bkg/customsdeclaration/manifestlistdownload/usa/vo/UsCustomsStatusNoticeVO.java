/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsCustomsStatusNoticeVO.java
*@FileTitle : UsCustomsStatusNoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class UsCustomsStatusNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsCustomsStatusNoticeVO> models = new ArrayList<UsCustomsStatusNoticeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hndlOfcAddr = null;
	/* Column Info */
	private String autoSndFlgRadio = null;
	/* Column Info */
	private String cstmsNtcMsg1s = null;
	/* Column Info */
	private String hndlOfcEml = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntcMsgTpCd = null;
	/* Column Info */
	private String autoSndFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cstmsNtcMsg = null;
	/* Column Info */
	private String cstmsNtcMsg1r = null;
	/* Column Info */
	private String ntcMsgTpCd1s = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ntcMsgTpCd1r = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsCustomsStatusNoticeVO() {}

	public UsCustomsStatusNoticeVO(String ibflag, String pagerows, String hndlOfcCd, String autoSndFlgRadio, String hndlOfcAddr, String hndlOfcEml, String ntcMsgTpCd, String cstmsNtcMsg, String cstmsNtcMsg1r, String cstmsNtcMsg1s, String creUsrId, String creDt, String updUsrId, String updDt, String autoSndFlg, String ntcMsgTpCd1r, String ntcMsgTpCd1s) {
		this.updDt = updDt;
		this.hndlOfcAddr = hndlOfcAddr;
		this.autoSndFlgRadio = autoSndFlgRadio;
		this.cstmsNtcMsg1s = cstmsNtcMsg1s;
		this.hndlOfcEml = hndlOfcEml;
		this.creDt = creDt;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
		this.ntcMsgTpCd = ntcMsgTpCd;
		this.autoSndFlg = autoSndFlg;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cstmsNtcMsg = cstmsNtcMsg;
		this.cstmsNtcMsg1r = cstmsNtcMsg1r;
		this.ntcMsgTpCd1s = ntcMsgTpCd1s;
		this.updUsrId = updUsrId;
		this.ntcMsgTpCd1r = ntcMsgTpCd1r;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hndl_ofc_addr", getHndlOfcAddr());
		this.hashColumns.put("auto_snd_flg_radio", getAutoSndFlgRadio());
		this.hashColumns.put("cstms_ntc_msg_1s", getCstmsNtcMsg1s());
		this.hashColumns.put("hndl_ofc_eml", getHndlOfcEml());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntc_msg_tp_cd", getNtcMsgTpCd());
		this.hashColumns.put("auto_snd_flg", getAutoSndFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cstms_ntc_msg", getCstmsNtcMsg());
		this.hashColumns.put("cstms_ntc_msg_1r", getCstmsNtcMsg1r());
		this.hashColumns.put("ntc_msg_tp_cd_1s", getNtcMsgTpCd1s());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ntc_msg_tp_cd_1r", getNtcMsgTpCd1r());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hndl_ofc_addr", "hndlOfcAddr");
		this.hashFields.put("auto_snd_flg_radio", "autoSndFlgRadio");
		this.hashFields.put("cstms_ntc_msg_1s", "cstmsNtcMsg1s");
		this.hashFields.put("hndl_ofc_eml", "hndlOfcEml");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_msg_tp_cd", "ntcMsgTpCd");
		this.hashFields.put("auto_snd_flg", "autoSndFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cstms_ntc_msg", "cstmsNtcMsg");
		this.hashFields.put("cstms_ntc_msg_1r", "cstmsNtcMsg1r");
		this.hashFields.put("ntc_msg_tp_cd_1s", "ntcMsgTpCd1s");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ntc_msg_tp_cd_1r", "ntcMsgTpCd1r");
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
	 * @return hndlOfcAddr
	 */
	public String getHndlOfcAddr() {
		return this.hndlOfcAddr;
	}
	
	/**
	 * Column Info
	 * @return autoSndFlgRadio
	 */
	public String getAutoSndFlgRadio() {
		return this.autoSndFlgRadio;
	}
	
	/**
	 * Column Info
	 * @return cstmsNtcMsg1s
	 */
	public String getCstmsNtcMsg1s() {
		return this.cstmsNtcMsg1s;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcEml
	 */
	public String getHndlOfcEml() {
		return this.hndlOfcEml;
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
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @return ntcMsgTpCd
	 */
	public String getNtcMsgTpCd() {
		return this.ntcMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @return autoSndFlg
	 */
	public String getAutoSndFlg() {
		return this.autoSndFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cstmsNtcMsg
	 */
	public String getCstmsNtcMsg() {
		return this.cstmsNtcMsg;
	}
	
	/**
	 * Column Info
	 * @return cstmsNtcMsg1r
	 */
	public String getCstmsNtcMsg1r() {
		return this.cstmsNtcMsg1r;
	}
	
	/**
	 * Column Info
	 * @return ntcMsgTpCd1s
	 */
	public String getNtcMsgTpCd1s() {
		return this.ntcMsgTpCd1s;
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
	 * @return ntcMsgTpCd1r
	 */
	public String getNtcMsgTpCd1r() {
		return this.ntcMsgTpCd1r;
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
	 * @param hndlOfcAddr
	 */
	public void setHndlOfcAddr(String hndlOfcAddr) {
		this.hndlOfcAddr = hndlOfcAddr;
	}
	
	/**
	 * Column Info
	 * @param autoSndFlgRadio
	 */
	public void setAutoSndFlgRadio(String autoSndFlgRadio) {
		this.autoSndFlgRadio = autoSndFlgRadio;
	}
	
	/**
	 * Column Info
	 * @param cstmsNtcMsg1s
	 */
	public void setCstmsNtcMsg1s(String cstmsNtcMsg1s) {
		this.cstmsNtcMsg1s = cstmsNtcMsg1s;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcEml
	 */
	public void setHndlOfcEml(String hndlOfcEml) {
		this.hndlOfcEml = hndlOfcEml;
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
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
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
	 * @param ntcMsgTpCd
	 */
	public void setNtcMsgTpCd(String ntcMsgTpCd) {
		this.ntcMsgTpCd = ntcMsgTpCd;
	}
	
	/**
	 * Column Info
	 * @param autoSndFlg
	 */
	public void setAutoSndFlg(String autoSndFlg) {
		this.autoSndFlg = autoSndFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cstmsNtcMsg
	 */
	public void setCstmsNtcMsg(String cstmsNtcMsg) {
		this.cstmsNtcMsg = cstmsNtcMsg;
	}
	
	/**
	 * Column Info
	 * @param cstmsNtcMsg1r
	 */
	public void setCstmsNtcMsg1r(String cstmsNtcMsg1r) {
		this.cstmsNtcMsg1r = cstmsNtcMsg1r;
	}
	
	/**
	 * Column Info
	 * @param ntcMsgTpCd1s
	 */
	public void setNtcMsgTpCd1s(String ntcMsgTpCd1s) {
		this.ntcMsgTpCd1s = ntcMsgTpCd1s;
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
	 * @param ntcMsgTpCd1r
	 */
	public void setNtcMsgTpCd1r(String ntcMsgTpCd1r) {
		this.ntcMsgTpCd1r = ntcMsgTpCd1r;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setHndlOfcAddr(JSPUtil.getParameter(request, prefix + "hndl_ofc_addr", ""));
		setAutoSndFlgRadio(JSPUtil.getParameter(request, prefix + "auto_snd_flg_radio", ""));
		setCstmsNtcMsg1s(JSPUtil.getParameter(request, prefix + "cstms_ntc_msg_1s", ""));
		setHndlOfcEml(JSPUtil.getParameter(request, prefix + "hndl_ofc_eml", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtcMsgTpCd(JSPUtil.getParameter(request, prefix + "ntc_msg_tp_cd", ""));
		setAutoSndFlg(JSPUtil.getParameter(request, prefix + "auto_snd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCstmsNtcMsg(JSPUtil.getParameter(request, prefix + "cstms_ntc_msg", ""));
		setCstmsNtcMsg1r(JSPUtil.getParameter(request, prefix + "cstms_ntc_msg_1r", ""));
		setNtcMsgTpCd1s(JSPUtil.getParameter(request, prefix + "ntc_msg_tp_cd_1s", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setNtcMsgTpCd1r(JSPUtil.getParameter(request, prefix + "ntc_msg_tp_cd_1r", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsCustomsStatusNoticeVO[]
	 */
	public UsCustomsStatusNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsCustomsStatusNoticeVO[]
	 */
	public UsCustomsStatusNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsCustomsStatusNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hndlOfcAddr = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_addr", length));
			String[] autoSndFlgRadio = (JSPUtil.getParameter(request, prefix	+ "auto_snd_flg_radio", length));
			String[] cstmsNtcMsg1s = (JSPUtil.getParameter(request, prefix	+ "cstms_ntc_msg_1s", length));
			String[] hndlOfcEml = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_eml", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntcMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "ntc_msg_tp_cd", length));
			String[] autoSndFlg = (JSPUtil.getParameter(request, prefix	+ "auto_snd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cstmsNtcMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_ntc_msg", length));
			String[] cstmsNtcMsg1r = (JSPUtil.getParameter(request, prefix	+ "cstms_ntc_msg_1r", length));
			String[] ntcMsgTpCd1s = (JSPUtil.getParameter(request, prefix	+ "ntc_msg_tp_cd_1s", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ntcMsgTpCd1r = (JSPUtil.getParameter(request, prefix	+ "ntc_msg_tp_cd_1r", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsCustomsStatusNoticeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hndlOfcAddr[i] != null)
					model.setHndlOfcAddr(hndlOfcAddr[i]);
				if (autoSndFlgRadio[i] != null)
					model.setAutoSndFlgRadio(autoSndFlgRadio[i]);
				if (cstmsNtcMsg1s[i] != null)
					model.setCstmsNtcMsg1s(cstmsNtcMsg1s[i]);
				if (hndlOfcEml[i] != null)
					model.setHndlOfcEml(hndlOfcEml[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcMsgTpCd[i] != null)
					model.setNtcMsgTpCd(ntcMsgTpCd[i]);
				if (autoSndFlg[i] != null)
					model.setAutoSndFlg(autoSndFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cstmsNtcMsg[i] != null)
					model.setCstmsNtcMsg(cstmsNtcMsg[i]);
				if (cstmsNtcMsg1r[i] != null)
					model.setCstmsNtcMsg1r(cstmsNtcMsg1r[i]);
				if (ntcMsgTpCd1s[i] != null)
					model.setNtcMsgTpCd1s(ntcMsgTpCd1s[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ntcMsgTpCd1r[i] != null)
					model.setNtcMsgTpCd1r(ntcMsgTpCd1r[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsCustomsStatusNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsCustomsStatusNoticeVO[]
	 */
	public UsCustomsStatusNoticeVO[] getUsCustomsStatusNoticeVOs(){
		UsCustomsStatusNoticeVO[] vos = (UsCustomsStatusNoticeVO[])models.toArray(new UsCustomsStatusNoticeVO[models.size()]);
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
		this.hndlOfcAddr = this.hndlOfcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndFlgRadio = this.autoSndFlgRadio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsNtcMsg1s = this.cstmsNtcMsg1s .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcEml = this.hndlOfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcMsgTpCd = this.ntcMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoSndFlg = this.autoSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsNtcMsg = this.cstmsNtcMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsNtcMsg1r = this.cstmsNtcMsg1r .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcMsgTpCd1s = this.ntcMsgTpCd1s .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcMsgTpCd1r = this.ntcMsgTpCd1r .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
