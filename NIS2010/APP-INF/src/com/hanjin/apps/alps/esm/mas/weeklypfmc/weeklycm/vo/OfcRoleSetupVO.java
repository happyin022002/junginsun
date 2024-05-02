/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfcRoleSetupVO.java
*@FileTitle : OfcRoleSetupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.03.17 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfcRoleSetupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfcRoleSetupVO> models = new ArrayList<OfcRoleSetupVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrIdSheet = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String updUsrIdOrg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ofcCdOrg = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrIdOrg = null;
	/* Column Info */
	private String updUsrIdSheet = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OfcRoleSetupVO() {}

	public OfcRoleSetupVO(String ibflag, String pagerows, String ofcCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String ofcCdOrg, String creUsrIdSheet, String updUsrIdSheet, String creUsrIdOrg, String updUsrIdOrg, String fOfcCd) {
		this.updDt = updDt;
		this.creUsrIdSheet = creUsrIdSheet;
		this.deltFlg = deltFlg;
		this.updUsrIdOrg = updUsrIdOrg;
		this.creDt = creDt;
		this.ofcCdOrg = ofcCdOrg;
		this.fOfcCd = fOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.creUsrIdOrg = creUsrIdOrg;
		this.updUsrIdSheet = updUsrIdSheet;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id_sheet", getCreUsrIdSheet());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("upd_usr_id_org", getUpdUsrIdOrg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ofc_cd_org", getOfcCdOrg());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id_org", getCreUsrIdOrg());
		this.hashColumns.put("upd_usr_id_sheet", getUpdUsrIdSheet());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id_sheet", "creUsrIdSheet");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("upd_usr_id_org", "updUsrIdOrg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ofc_cd_org", "ofcCdOrg");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id_org", "creUsrIdOrg");
		this.hashFields.put("upd_usr_id_sheet", "updUsrIdSheet");
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
	 * @return creUsrIdSheet
	 */
	public String getCreUsrIdSheet() {
		return this.creUsrIdSheet;
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
	 * @return updUsrIdOrg
	 */
	public String getUpdUsrIdOrg() {
		return this.updUsrIdOrg;
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
	 * @return ofcCdOrg
	 */
	public String getOfcCdOrg() {
		return this.ofcCdOrg;
	}
	
	/**
	 * Column Info
	 * @return fOfcCd
	 */
	public String getFOfcCd() {
		return this.fOfcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creUsrIdOrg
	 */
	public String getCreUsrIdOrg() {
		return this.creUsrIdOrg;
	}
	
	/**
	 * Column Info
	 * @return updUsrIdSheet
	 */
	public String getUpdUsrIdSheet() {
		return this.updUsrIdSheet;
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
	 * @param creUsrIdSheet
	 */
	public void setCreUsrIdSheet(String creUsrIdSheet) {
		this.creUsrIdSheet = creUsrIdSheet;
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
	 * @param updUsrIdOrg
	 */
	public void setUpdUsrIdOrg(String updUsrIdOrg) {
		this.updUsrIdOrg = updUsrIdOrg;
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
	 * @param ofcCdOrg
	 */
	public void setOfcCdOrg(String ofcCdOrg) {
		this.ofcCdOrg = ofcCdOrg;
	}
	
	/**
	 * Column Info
	 * @param fOfcCd
	 */
	public void setFOfcCd(String fOfcCd) {
		this.fOfcCd = fOfcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creUsrIdOrg
	 */
	public void setCreUsrIdOrg(String creUsrIdOrg) {
		this.creUsrIdOrg = creUsrIdOrg;
	}
	
	/**
	 * Column Info
	 * @param updUsrIdSheet
	 */
	public void setUpdUsrIdSheet(String updUsrIdSheet) {
		this.updUsrIdSheet = updUsrIdSheet;
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
		setCreUsrIdSheet(JSPUtil.getParameter(request, prefix + "cre_usr_id_sheet", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setUpdUsrIdOrg(JSPUtil.getParameter(request, prefix + "upd_usr_id_org", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOfcCdOrg(JSPUtil.getParameter(request, prefix + "ofc_cd_org", ""));
		setFOfcCd(JSPUtil.getParameter(request, prefix + "f_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrIdOrg(JSPUtil.getParameter(request, prefix + "cre_usr_id_org", ""));
		setUpdUsrIdSheet(JSPUtil.getParameter(request, prefix + "upd_usr_id_sheet", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfcRoleSetupVO[]
	 */
	public OfcRoleSetupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfcRoleSetupVO[]
	 */
	public OfcRoleSetupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfcRoleSetupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrIdSheet = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id_sheet", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] updUsrIdOrg = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id_org", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ofcCdOrg = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_org", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrIdOrg = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id_org", length));
			String[] updUsrIdSheet = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id_sheet", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfcRoleSetupVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrIdSheet[i] != null)
					model.setCreUsrIdSheet(creUsrIdSheet[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (updUsrIdOrg[i] != null)
					model.setUpdUsrIdOrg(updUsrIdOrg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ofcCdOrg[i] != null)
					model.setOfcCdOrg(ofcCdOrg[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrIdOrg[i] != null)
					model.setCreUsrIdOrg(creUsrIdOrg[i]);
				if (updUsrIdSheet[i] != null)
					model.setUpdUsrIdSheet(updUsrIdSheet[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfcRoleSetupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfcRoleSetupVO[]
	 */
	public OfcRoleSetupVO[] getOfcRoleSetupVOs(){
		OfcRoleSetupVO[] vos = (OfcRoleSetupVO[])models.toArray(new OfcRoleSetupVO[models.size()]);
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
		this.creUsrIdSheet = this.creUsrIdSheet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrIdOrg = this.updUsrIdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdOrg = this.ofcCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrIdOrg = this.creUsrIdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrIdSheet = this.updUsrIdSheet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
