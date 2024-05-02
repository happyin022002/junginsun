/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneOrderInPutVO.java
*@FileTitle : LaneOrderInPutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.06 김세일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김세일
 * @since J2EE 1.5
 */

public class LaneOrderInPutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LaneOrderInPutVO> models = new ArrayList<LaneOrderInPutVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String rnkSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String iocDesc = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String rlaneNm = null;
	/* Column Info */
	private String rlaneDesc = null;
	/* Column Info */
	private String znIocCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LaneOrderInPutVO() {}

	public LaneOrderInPutVO(String ibflag, String pagerows, String rlaneCd, String rlaneNm, String rnkSeq, String rlaneDesc, String znIocCd, String iocDesc, String slanCd, String deltFlg, String creUsrId, String creDt, String eaiEvntDt, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.rnkSeq = rnkSeq;
		this.creDt = creDt;
		this.rlaneCd = rlaneCd;
		this.eaiEvntDt = eaiEvntDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.iocDesc = iocDesc;
		this.slanCd = slanCd;
		this.rlaneNm = rlaneNm;
		this.rlaneDesc = rlaneDesc;
		this.znIocCd = znIocCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rnk_seq", getRnkSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ioc_desc", getIocDesc());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rlane_nm", getRlaneNm());
		this.hashColumns.put("rlane_desc", getRlaneDesc());
		this.hashColumns.put("zn_ioc_cd", getZnIocCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("rnk_seq", "rnkSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ioc_desc", "iocDesc");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rlane_nm", "rlaneNm");
		this.hashFields.put("rlane_desc", "rlaneDesc");
		this.hashFields.put("zn_ioc_cd", "znIocCd");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getRnkSeq() {
		return this.rnkSeq;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getIocDesc() {
		return this.iocDesc;
	}
	public String getSlanCd() {
		return this.slanCd;
	}
	public String getRlaneNm() {
		return this.rlaneNm;
	}
	public String getRlaneDesc() {
		return this.rlaneDesc;
	}
	public String getZnIocCd() {
		return this.znIocCd;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setRnkSeq(String rnkSeq) {
		this.rnkSeq = rnkSeq;
		//this.rnkSeq=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
		//this.rlaneCd=true;
	}
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
		//this.eaiEvntDt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setIocDesc(String iocDesc) {
		this.iocDesc = iocDesc;
		//this.iocDesc=true;
	}
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
		//this.slanCd=true;
	}
	public void setRlaneNm(String rlaneNm) {
		this.rlaneNm = rlaneNm;
		//this.rlaneNm=true;
	}
	public void setRlaneDesc(String rlaneDesc) {
		this.rlaneDesc = rlaneDesc;
		//this.rlaneDesc=true;
	}
	public void setZnIocCd(String znIocCd) {
		this.znIocCd = znIocCd;
		//this.znIocCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setRnkSeq(JSPUtil.getParameter(request, "rnk_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIocDesc(JSPUtil.getParameter(request, "ioc_desc", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setRlaneNm(JSPUtil.getParameter(request, "rlane_nm", ""));
		setRlaneDesc(JSPUtil.getParameter(request, "rlane_desc", ""));
		setZnIocCd(JSPUtil.getParameter(request, "zn_ioc_cd", ""));
	}

	public LaneOrderInPutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public LaneOrderInPutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LaneOrderInPutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] rnkSeq = (JSPUtil.getParameter(request, prefix	+ "rnk_seq".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd".trim(), length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] iocDesc = (JSPUtil.getParameter(request, prefix	+ "ioc_desc".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] rlaneNm = (JSPUtil.getParameter(request, prefix	+ "rlane_nm".trim(), length));
			String[] rlaneDesc = (JSPUtil.getParameter(request, prefix	+ "rlane_desc".trim(), length));
			String[] znIocCd = (JSPUtil.getParameter(request, prefix	+ "zn_ioc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new LaneOrderInPutVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (rnkSeq[i] != null)
					model.setRnkSeq(rnkSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (iocDesc[i] != null)
					model.setIocDesc(iocDesc[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (rlaneNm[i] != null)
					model.setRlaneNm(rlaneNm[i]);
				if (rlaneDesc[i] != null)
					model.setRlaneDesc(rlaneDesc[i]);
				if (znIocCd[i] != null)
					model.setZnIocCd(znIocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getLaneOrderInPutVOs();
	}

	public LaneOrderInPutVO[] getLaneOrderInPutVOs(){
		LaneOrderInPutVO[] vos = (LaneOrderInPutVO[])models.toArray(new LaneOrderInPutVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @exception IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnkSeq = this.rnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocDesc = this.iocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneNm = this.rlaneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneDesc = this.rlaneDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znIocCd = this.znIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
