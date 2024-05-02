/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrOfcCntcPsonVO.java
*@FileTitle : CustomMnrOfcCntcPsonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.19 정영훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrOfcCntcPsonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrOfcCntcPsonVO> models = new ArrayList<CustomMnrOfcCntcPsonVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String orgOfcCd = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String mnrCntcRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String orgMnrGrpTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String cntcUsrId = null;
	/* Column Info */
	private String orgCntcUsrId = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	 /**
	 * CustomMnrOfcCntcPsonVO을 생성함
	 */
	public CustomMnrOfcCntcPsonVO() {}

     /**
     * CustomMnrOfcCntcPsonVO을 생성함
     */
	public CustomMnrOfcCntcPsonVO(String ibflag, String pagerows, String updDt, String mnrGrpTpCd, String mnrCntcRmk, String creDt, String arHdQtrOfcCd, String ofcCd, String creUsrId, String usrNm, String cntcUsrId, String usrEml, String updUsrId, String orgOfcCd, String orgMnrGrpTpCd, String orgCntcUsrId) {
		this.updDt = updDt;
		this.orgOfcCd = orgOfcCd;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.mnrCntcRmk = mnrCntcRmk;
		this.creDt = creDt;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.orgMnrGrpTpCd = orgMnrGrpTpCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.usrNm = usrNm;
		this.cntcUsrId = cntcUsrId;
		this.orgCntcUsrId = orgCntcUsrId;
		this.usrEml = usrEml;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("org_ofc_cd", getOrgOfcCd());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("mnr_cntc_rmk", getMnrCntcRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("org_mnr_grp_tp_cd", getOrgMnrGrpTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("cntc_usr_id", getCntcUsrId());
		this.hashColumns.put("org_cntc_usr_id", getOrgCntcUsrId());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("org_ofc_cd", "orgOfcCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("mnr_cntc_rmk", "mnrCntcRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("org_mnr_grp_tp_cd", "orgMnrGrpTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cntc_usr_id", "cntcUsrId");
		this.hashFields.put("org_cntc_usr_id", "orgCntcUsrId");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return orgOfcCd
	 */
	public String getOrgOfcCd() {
		return this.orgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrCntcRmk
	 */
	public String getMnrCntcRmk() {
		return this.mnrCntcRmk;
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
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
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
	 * Column Info
	 * @return orgMnrGrpTpCd
	 */
	public String getOrgMnrGrpTpCd() {
		return this.orgMnrGrpTpCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return cntcUsrId
	 */
	public String getCntcUsrId() {
		return this.cntcUsrId;
	}
	
	/**
	 * Column Info
	 * @return orgCntcUsrId
	 */
	public String getOrgCntcUsrId() {
		return this.orgCntcUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param orgOfcCd
	 */
	public void setOrgOfcCd(String orgOfcCd) {
		this.orgOfcCd = orgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrCntcRmk
	 */
	public void setMnrCntcRmk(String mnrCntcRmk) {
		this.mnrCntcRmk = mnrCntcRmk;
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
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
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
	 * Column Info
	 * @param orgMnrGrpTpCd
	 */
	public void setOrgMnrGrpTpCd(String orgMnrGrpTpCd) {
		this.orgMnrGrpTpCd = orgMnrGrpTpCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param cntcUsrId
	 */
	public void setCntcUsrId(String cntcUsrId) {
		this.cntcUsrId = cntcUsrId;
	}
	
	/**
	 * Column Info
	 * @param orgCntcUsrId
	 */
	public void setOrgCntcUsrId(String orgCntcUsrId) {
		this.orgCntcUsrId = orgCntcUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setOrgOfcCd(JSPUtil.getParameter(request, "org_ofc_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setMnrCntcRmk(JSPUtil.getParameter(request, "mnr_cntc_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setOrgMnrGrpTpCd(JSPUtil.getParameter(request, "org_mnr_grp_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setCntcUsrId(JSPUtil.getParameter(request, "cntc_usr_id", ""));
		setOrgCntcUsrId(JSPUtil.getParameter(request, "org_cntc_usr_id", ""));
		setUsrEml(JSPUtil.getParameter(request, "usr_eml", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrOfcCntcPsonVO[]
	 */
	public CustomMnrOfcCntcPsonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrOfcCntcPsonVO[]
	 */
	public CustomMnrOfcCntcPsonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrOfcCntcPsonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] orgOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_ofc_cd", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] mnrCntcRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_cntc_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] orgMnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_mnr_grp_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] cntcUsrId = (JSPUtil.getParameter(request, prefix	+ "cntc_usr_id", length));
			String[] orgCntcUsrId = (JSPUtil.getParameter(request, prefix	+ "org_cntc_usr_id", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrOfcCntcPsonVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (orgOfcCd[i] != null)
					model.setOrgOfcCd(orgOfcCd[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (mnrCntcRmk[i] != null)
					model.setMnrCntcRmk(mnrCntcRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (orgMnrGrpTpCd[i] != null)
					model.setOrgMnrGrpTpCd(orgMnrGrpTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (cntcUsrId[i] != null)
					model.setCntcUsrId(cntcUsrId[i]);
				if (orgCntcUsrId[i] != null)
					model.setOrgCntcUsrId(orgCntcUsrId[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrOfcCntcPsonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrOfcCntcPsonVO[]
	 */
	public CustomMnrOfcCntcPsonVO[] getCustomMnrOfcCntcPsonVOs(){
		CustomMnrOfcCntcPsonVO[] vos = (CustomMnrOfcCntcPsonVO[])models.toArray(new CustomMnrOfcCntcPsonVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOfcCd = this.orgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCntcRmk = this.mnrCntcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMnrGrpTpCd = this.orgMnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcUsrId = this.cntcUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntcUsrId = this.orgCntcUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
