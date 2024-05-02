/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchOfficeListVO.java
*@FileTitle : SearchOfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo;

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

public class SearchOfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeListVO> models = new ArrayList<SearchOfficeListVO>();
	
	/* Column Info */
	private String isSave = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyCtrlOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n3ptyArOfcCd = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyOfcTpCd = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sN3ptyOfcTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOfficeListVO() {}

	public SearchOfficeListVO(String ibflag, String pagerows, String updDt, String n3ptyCtrlOfcCd, String rhqCd, String deltFlg, String sOfcCd, String creDt, String n3ptyArOfcCd, String sIfOfcCd, String n3ptyOfcTpCd, String n3ptyOfcCd, String ofcCd, String creUsrId, String sIfRhqCd, String sN3ptyOfcTpCd, String updUsrId, String isSave, String arHdQtrOfcCd) {
		this.isSave = isSave;
		this.updDt = updDt;
		this.n3ptyCtrlOfcCd = n3ptyCtrlOfcCd;
		this.rhqCd = rhqCd;
		this.deltFlg = deltFlg;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.sOfcCd = sOfcCd;
		this.creDt = creDt;
		this.n3ptyArOfcCd = n3ptyArOfcCd;
		this.sIfOfcCd = sIfOfcCd;
		this.pagerows = pagerows;
		this.n3ptyOfcTpCd = n3ptyOfcTpCd;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sIfRhqCd = sIfRhqCd;
		this.updUsrId = updUsrId;
		this.sN3ptyOfcTpCd = sN3ptyOfcTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("is_save", getIsSave());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_ctrl_ofc_cd", getN3ptyCtrlOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n3pty_ar_ofc_cd", getN3ptyArOfcCd());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_ofc_tp_cd", getN3ptyOfcTpCd());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_n3pty_ofc_tp_cd", getSN3ptyOfcTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("is_save", "isSave");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_ctrl_ofc_cd", "n3ptyCtrlOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n3pty_ar_ofc_cd", "n3ptyArOfcCd");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_ofc_tp_cd", "n3ptyOfcTpCd");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_n3pty_ofc_tp_cd", "sN3ptyOfcTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return isSave
	 */
	public String getIsSave() {
		return this.isSave;
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
	 * @return n3ptyCtrlOfcCd
	 */
	public String getN3ptyCtrlOfcCd() {
		return this.n3ptyCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
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
	 * @return n3ptyArOfcCd
	 */
	public String getN3ptyArOfcCd() {
		return this.n3ptyArOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
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
	 * @return n3ptyOfcTpCd
	 */
	public String getN3ptyOfcTpCd() {
		return this.n3ptyOfcTpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
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
	 * @return sN3ptyOfcTpCd
	 */
	public String getSN3ptyOfcTpCd() {
		return this.sN3ptyOfcTpCd;
	}
	

	/**
	 * Column Info
	 * @param isSave
	 */
	public void setIsSave(String isSave) {
		this.isSave = isSave;
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
	 * @param n3ptyCtrlOfcCd
	 */
	public void setN3ptyCtrlOfcCd(String n3ptyCtrlOfcCd) {
		this.n3ptyCtrlOfcCd = n3ptyCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
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
	 * @param n3ptyArOfcCd
	 */
	public void setN3ptyArOfcCd(String n3ptyArOfcCd) {
		this.n3ptyArOfcCd = n3ptyArOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
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
	 * @param n3ptyOfcTpCd
	 */
	public void setN3ptyOfcTpCd(String n3ptyOfcTpCd) {
		this.n3ptyOfcTpCd = n3ptyOfcTpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
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
	 * @param sN3ptyOfcTpCd
	 */
	public void setSN3ptyOfcTpCd(String sN3ptyOfcTpCd) {
		this.sN3ptyOfcTpCd = sN3ptyOfcTpCd;
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
		setIsSave(JSPUtil.getParameter(request, prefix + "is_save", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN3ptyCtrlOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ctrl_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setN3ptyArOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ar_ofc_cd", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, prefix + "s_if_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyOfcTpCd(JSPUtil.getParameter(request, prefix + "n3pty_ofc_tp_cd", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, prefix + "s_if_rhq_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSN3ptyOfcTpCd(JSPUtil.getParameter(request, prefix + "s_n3pty_ofc_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOfficeListVO[]
	 */
	public SearchOfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOfficeListVO[]
	 */
	public SearchOfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] isSave = (JSPUtil.getParameter(request, prefix	+ "is_save", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ctrl_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n3ptyArOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ar_ofc_cd", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyOfcTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_tp_cd", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sN3ptyOfcTpCd = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_ofc_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeListVO();
				if (isSave[i] != null)
					model.setIsSave(isSave[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyCtrlOfcCd[i] != null)
					model.setN3ptyCtrlOfcCd(n3ptyCtrlOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n3ptyArOfcCd[i] != null)
					model.setN3ptyArOfcCd(n3ptyArOfcCd[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyOfcTpCd[i] != null)
					model.setN3ptyOfcTpCd(n3ptyOfcTpCd[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sN3ptyOfcTpCd[i] != null)
					model.setSN3ptyOfcTpCd(sN3ptyOfcTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOfficeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOfficeListVO[]
	 */
	public SearchOfficeListVO[] getSearchOfficeListVOs(){
		SearchOfficeListVO[] vos = (SearchOfficeListVO[])models.toArray(new SearchOfficeListVO[models.size()]);
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
		this.isSave = this.isSave .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCtrlOfcCd = this.n3ptyCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyArOfcCd = this.n3ptyArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcTpCd = this.n3ptyOfcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyOfcTpCd = this.sN3ptyOfcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}