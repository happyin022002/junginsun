/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BaplieAlarmSetupVO.java
*@FileTitle : BaplieAlarmSetupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BaplieAlarmSetupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BaplieAlarmSetupVO> models = new ArrayList<BaplieAlarmSetupVO>();
	
	/* Column Info */
	private String emlSndHrs = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String lstPortCd = null;
	/* Column Info */
	private String hiddenRcvrEml = null;
	/* Column Info */
	private String emlSndUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String hiddenLstPortCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String hiddenSlanCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BaplieAlarmSetupVO() {}

	public BaplieAlarmSetupVO(String ibflag, String pagerows, String slanCd, String lstPortCd, String hiddenSlanCd, String hiddenLstPortCd, String rcvrEml, String hiddenRcvrEml, String emlSndUsrId, String emlSndHrs, String usrNm, String ofcCd, String etd, String userId, String userNm) {
		this.emlSndHrs = emlSndHrs;
		this.etd = etd;
		this.lstPortCd = lstPortCd;
		this.hiddenRcvrEml = hiddenRcvrEml;
		this.emlSndUsrId = emlSndUsrId;
		this.pagerows = pagerows;
		this.userNm = userNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.rcvrEml = rcvrEml;
		this.slanCd = slanCd;
		this.hiddenLstPortCd = hiddenLstPortCd;
		this.usrNm = usrNm;
		this.userId = userId;
		this.hiddenSlanCd = hiddenSlanCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml_snd_hrs", getEmlSndHrs());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("lst_port_cd", getLstPortCd());
		this.hashColumns.put("hidden_rcvr_eml", getHiddenRcvrEml());
		this.hashColumns.put("eml_snd_usr_id", getEmlSndUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("hidden_lst_port_cd", getHiddenLstPortCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("hidden_slan_cd", getHiddenSlanCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eml_snd_hrs", "emlSndHrs");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("lst_port_cd", "lstPortCd");
		this.hashFields.put("hidden_rcvr_eml", "hiddenRcvrEml");
		this.hashFields.put("eml_snd_usr_id", "emlSndUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("hidden_lst_port_cd", "hiddenLstPortCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("hidden_slan_cd", "hiddenSlanCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return emlSndHrs
	 */
	public String getEmlSndHrs() {
		return this.emlSndHrs;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return lstPortCd
	 */
	public String getLstPortCd() {
		return this.lstPortCd;
	}
	
	/**
	 * Column Info
	 * @return hiddenRcvrEml
	 */
	public String getHiddenRcvrEml() {
		return this.hiddenRcvrEml;
	}
	
	/**
	 * Column Info
	 * @return emlSndUsrId
	 */
	public String getEmlSndUsrId() {
		return this.emlSndUsrId;
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
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return hiddenLstPortCd
	 */
	public String getHiddenLstPortCd() {
		return this.hiddenLstPortCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return hiddenSlanCd
	 */
	public String getHiddenSlanCd() {
		return this.hiddenSlanCd;
	}
	

	/**
	 * Column Info
	 * @param emlSndHrs
	 */
	public void setEmlSndHrs(String emlSndHrs) {
		this.emlSndHrs = emlSndHrs;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param lstPortCd
	 */
	public void setLstPortCd(String lstPortCd) {
		this.lstPortCd = lstPortCd;
	}
	
	/**
	 * Column Info
	 * @param hiddenRcvrEml
	 */
	public void setHiddenRcvrEml(String hiddenRcvrEml) {
		this.hiddenRcvrEml = hiddenRcvrEml;
	}
	
	/**
	 * Column Info
	 * @param emlSndUsrId
	 */
	public void setEmlSndUsrId(String emlSndUsrId) {
		this.emlSndUsrId = emlSndUsrId;
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
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param hiddenLstPortCd
	 */
	public void setHiddenLstPortCd(String hiddenLstPortCd) {
		this.hiddenLstPortCd = hiddenLstPortCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param hiddenSlanCd
	 */
	public void setHiddenSlanCd(String hiddenSlanCd) {
		this.hiddenSlanCd = hiddenSlanCd;
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
		setEmlSndHrs(JSPUtil.getParameter(request, prefix + "eml_snd_hrs", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setLstPortCd(JSPUtil.getParameter(request, prefix + "lst_port_cd", ""));
		setHiddenRcvrEml(JSPUtil.getParameter(request, prefix + "hidden_rcvr_eml", ""));
		setEmlSndUsrId(JSPUtil.getParameter(request, prefix + "eml_snd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setHiddenLstPortCd(JSPUtil.getParameter(request, prefix + "hidden_lst_port_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setHiddenSlanCd(JSPUtil.getParameter(request, prefix + "hidden_slan_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BaplieAlarmSetupVO[]
	 */
	public BaplieAlarmSetupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BaplieAlarmSetupVO[]
	 */
	public BaplieAlarmSetupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BaplieAlarmSetupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] emlSndHrs = (JSPUtil.getParameter(request, prefix	+ "eml_snd_hrs", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] lstPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_port_cd", length));
			String[] hiddenRcvrEml = (JSPUtil.getParameter(request, prefix	+ "hidden_rcvr_eml", length));
			String[] emlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "eml_snd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] hiddenLstPortCd = (JSPUtil.getParameter(request, prefix	+ "hidden_lst_port_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] hiddenSlanCd = (JSPUtil.getParameter(request, prefix	+ "hidden_slan_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BaplieAlarmSetupVO();
				if (emlSndHrs[i] != null)
					model.setEmlSndHrs(emlSndHrs[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (lstPortCd[i] != null)
					model.setLstPortCd(lstPortCd[i]);
				if (hiddenRcvrEml[i] != null)
					model.setHiddenRcvrEml(hiddenRcvrEml[i]);
				if (emlSndUsrId[i] != null)
					model.setEmlSndUsrId(emlSndUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (hiddenLstPortCd[i] != null)
					model.setHiddenLstPortCd(hiddenLstPortCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (hiddenSlanCd[i] != null)
					model.setHiddenSlanCd(hiddenSlanCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBaplieAlarmSetupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BaplieAlarmSetupVO[]
	 */
	public BaplieAlarmSetupVO[] getBaplieAlarmSetupVOs(){
		BaplieAlarmSetupVO[] vos = (BaplieAlarmSetupVO[])models.toArray(new BaplieAlarmSetupVO[models.size()]);
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
		this.emlSndHrs = this.emlSndHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstPortCd = this.lstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenRcvrEml = this.hiddenRcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndUsrId = this.emlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenLstPortCd = this.hiddenLstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenSlanCd = this.hiddenSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
