/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalOwnListVO.java
*@FileTitle : OnhireApprovalOwnListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.26 진준성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진준성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OnhireApprovalOwnListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OnhireApprovalOwnListVO> models = new ArrayList<OnhireApprovalOwnListVO>();
	
	/* Column Info */
	private String agmtNo2 = null;
	/* Column Info */
	private String agmtNo1 = null;
	/* Column Info */
	private String cntrStsSeq = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String pkupDueDt = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String authVol = null;
	/* Column Info */
	private String pupVol = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String authCntrVolOrg = null;
	/* Column Info */
	private String tysz = null;
	/* Column Info */
	private String pupYard = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pickupVol = null;
	/* Column Info */
	private String newVanType = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String authCntrVol = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String pupDate = null;
	/* Column Info */
	private String listKey = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OnhireApprovalOwnListVO() {}

	public OnhireApprovalOwnListVO(String ibflag, String pagerows, String agmtNo2, String agmtNo1, String cntrStsSeq, String remark, String pkupDueDt, String authNo, String agmtNo, String authVol, String pupVol, String authCntrVolOrg, String tysz, String pupYard, String pickupVol, String cntrNo, String newVanType, String authCntrVol, String lstmCd, String listKey, String pupDate, String updUsrId) {
		this.agmtNo2 = agmtNo2;
		this.agmtNo1 = agmtNo1;
		this.cntrStsSeq = cntrStsSeq;
		this.remark = remark;
		this.pkupDueDt = pkupDueDt;
		this.authNo = authNo;
		this.agmtNo = agmtNo;
		this.authVol = authVol;
		this.pupVol = pupVol;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.authCntrVolOrg = authCntrVolOrg;
		this.tysz = tysz;
		this.pupYard = pupYard;
		this.cntrNo = cntrNo;
		this.pickupVol = pickupVol;
		this.newVanType = newVanType;
		this.lstmCd = lstmCd;
		this.authCntrVol = authCntrVol;
		this.updUsrId = updUsrId;
		this.pupDate = pupDate;
		this.listKey = listKey;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_no2", getAgmtNo2());
		this.hashColumns.put("agmt_no1", getAgmtNo1());
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("pkup_due_dt", getPkupDueDt());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("auth_vol", getAuthVol());
		this.hashColumns.put("pup_vol", getPupVol());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("auth_cntr_vol_org", getAuthCntrVolOrg());
		this.hashColumns.put("tysz", getTysz());
		this.hashColumns.put("pup_yard", getPupYard());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pickup_vol", getPickupVol());
		this.hashColumns.put("new_van_type", getNewVanType());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("auth_cntr_vol", getAuthCntrVol());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pup_date", getPupDate());
		this.hashColumns.put("list_key", getListKey());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_no2", "agmtNo2");
		this.hashFields.put("agmt_no1", "agmtNo1");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("pkup_due_dt", "pkupDueDt");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("auth_vol", "authVol");
		this.hashFields.put("pup_vol", "pupVol");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("auth_cntr_vol_org", "authCntrVolOrg");
		this.hashFields.put("tysz", "tysz");
		this.hashFields.put("pup_yard", "pupYard");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pickup_vol", "pickupVol");
		this.hashFields.put("new_van_type", "newVanType");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("auth_cntr_vol", "authCntrVol");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pup_date", "pupDate");
		this.hashFields.put("list_key", "listKey");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtNo2
	 */
	public String getAgmtNo2() {
		return this.agmtNo2;
	}
	
	/**
	 * Column Info
	 * @return agmtNo1
	 */
	public String getAgmtNo1() {
		return this.agmtNo1;
	}
	
	/**
	 * Column Info
	 * @return cntrStsSeq
	 */
	public String getCntrStsSeq() {
		return this.cntrStsSeq;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return pkupDueDt
	 */
	public String getPkupDueDt() {
		return this.pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return authVol
	 */
	public String getAuthVol() {
		return this.authVol;
	}
	
	/**
	 * Column Info
	 * @return pupVol
	 */
	public String getPupVol() {
		return this.pupVol;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return authCntrVolOrg
	 */
	public String getAuthCntrVolOrg() {
		return this.authCntrVolOrg;
	}
	
	/**
	 * Column Info
	 * @return tysz
	 */
	public String getTysz() {
		return this.tysz;
	}
	
	/**
	 * Column Info
	 * @return pupYard
	 */
	public String getPupYard() {
		return this.pupYard;
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
	 * @return pickupVol
	 */
	public String getPickupVol() {
		return this.pickupVol;
	}
	
	/**
	 * Column Info
	 * @return newVanType
	 */
	public String getNewVanType() {
		return this.newVanType;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return authCntrVol
	 */
	public String getAuthCntrVol() {
		return this.authCntrVol;
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
	 * @return pupDate
	 */
	public String getPupDate() {
		return this.pupDate;
	}
	
	/**
	 * Column Info
	 * @return listKey
	 */
	public String getListKey() {
		return this.listKey;
	}
	

	/**
	 * Column Info
	 * @param agmtNo2
	 */
	public void setAgmtNo2(String agmtNo2) {
		this.agmtNo2 = agmtNo2;
	}
	
	/**
	 * Column Info
	 * @param agmtNo1
	 */
	public void setAgmtNo1(String agmtNo1) {
		this.agmtNo1 = agmtNo1;
	}
	
	/**
	 * Column Info
	 * @param cntrStsSeq
	 */
	public void setCntrStsSeq(String cntrStsSeq) {
		this.cntrStsSeq = cntrStsSeq;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param pkupDueDt
	 */
	public void setPkupDueDt(String pkupDueDt) {
		this.pkupDueDt = pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param authVol
	 */
	public void setAuthVol(String authVol) {
		this.authVol = authVol;
	}
	
	/**
	 * Column Info
	 * @param pupVol
	 */
	public void setPupVol(String pupVol) {
		this.pupVol = pupVol;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param authCntrVolOrg
	 */
	public void setAuthCntrVolOrg(String authCntrVolOrg) {
		this.authCntrVolOrg = authCntrVolOrg;
	}
	
	/**
	 * Column Info
	 * @param tysz
	 */
	public void setTysz(String tysz) {
		this.tysz = tysz;
	}
	
	/**
	 * Column Info
	 * @param pupYard
	 */
	public void setPupYard(String pupYard) {
		this.pupYard = pupYard;
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
	 * @param pickupVol
	 */
	public void setPickupVol(String pickupVol) {
		this.pickupVol = pickupVol;
	}
	
	/**
	 * Column Info
	 * @param newVanType
	 */
	public void setNewVanType(String newVanType) {
		this.newVanType = newVanType;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param authCntrVol
	 */
	public void setAuthCntrVol(String authCntrVol) {
		this.authCntrVol = authCntrVol;
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
	 * @param pupDate
	 */
	public void setPupDate(String pupDate) {
		this.pupDate = pupDate;
	}
	
	/**
	 * Column Info
	 * @param listKey
	 */
	public void setListKey(String listKey) {
		this.listKey = listKey;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtNo2(JSPUtil.getParameter(request, "agmt_no2", ""));
		setAgmtNo1(JSPUtil.getParameter(request, "agmt_no1", ""));
		setCntrStsSeq(JSPUtil.getParameter(request, "cntr_sts_seq", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setPkupDueDt(JSPUtil.getParameter(request, "pkup_due_dt", ""));
		setAuthNo(JSPUtil.getParameter(request, "auth_no", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAuthVol(JSPUtil.getParameter(request, "auth_vol", ""));
		setPupVol(JSPUtil.getParameter(request, "pup_vol", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAuthCntrVolOrg(JSPUtil.getParameter(request, "auth_cntr_vol_org", ""));
		setTysz(JSPUtil.getParameter(request, "tysz", ""));
		setPupYard(JSPUtil.getParameter(request, "pup_yard", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPickupVol(JSPUtil.getParameter(request, "pickup_vol", ""));
		setNewVanType(JSPUtil.getParameter(request, "new_van_type", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setAuthCntrVol(JSPUtil.getParameter(request, "auth_cntr_vol", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPupDate(JSPUtil.getParameter(request, "pup_date", ""));
		setListKey(JSPUtil.getParameter(request, "list_key", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OnhireApprovalOwnListVO[]
	 */
	public OnhireApprovalOwnListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OnhireApprovalOwnListVO[]
	 */
	public OnhireApprovalOwnListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OnhireApprovalOwnListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtNo2 = (JSPUtil.getParameter(request, prefix	+ "agmt_no2", length));
			String[] agmtNo1 = (JSPUtil.getParameter(request, prefix	+ "agmt_no1", length));
			String[] cntrStsSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_seq", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] pkupDueDt = (JSPUtil.getParameter(request, prefix	+ "pkup_due_dt", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] authVol = (JSPUtil.getParameter(request, prefix	+ "auth_vol", length));
			String[] pupVol = (JSPUtil.getParameter(request, prefix	+ "pup_vol", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] authCntrVolOrg = (JSPUtil.getParameter(request, prefix	+ "auth_cntr_vol_org", length));
			String[] tysz = (JSPUtil.getParameter(request, prefix	+ "tysz", length));
			String[] pupYard = (JSPUtil.getParameter(request, prefix	+ "pup_yard", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pickupVol = (JSPUtil.getParameter(request, prefix	+ "pickup_vol", length));
			String[] newVanType = (JSPUtil.getParameter(request, prefix	+ "new_van_type", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] authCntrVol = (JSPUtil.getParameter(request, prefix	+ "auth_cntr_vol", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pupDate = (JSPUtil.getParameter(request, prefix	+ "pup_date", length));
			String[] listKey = (JSPUtil.getParameter(request, prefix	+ "list_key", length));
			
			for (int i = 0; i < length; i++) {
				model = new OnhireApprovalOwnListVO();
				if (agmtNo2[i] != null)
					model.setAgmtNo2(agmtNo2[i]);
				if (agmtNo1[i] != null)
					model.setAgmtNo1(agmtNo1[i]);
				if (cntrStsSeq[i] != null)
					model.setCntrStsSeq(cntrStsSeq[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (pkupDueDt[i] != null)
					model.setPkupDueDt(pkupDueDt[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (authVol[i] != null)
					model.setAuthVol(authVol[i]);
				if (pupVol[i] != null)
					model.setPupVol(pupVol[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (authCntrVolOrg[i] != null)
					model.setAuthCntrVolOrg(authCntrVolOrg[i]);
				if (tysz[i] != null)
					model.setTysz(tysz[i]);
				if (pupYard[i] != null)
					model.setPupYard(pupYard[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pickupVol[i] != null)
					model.setPickupVol(pickupVol[i]);
				if (newVanType[i] != null)
					model.setNewVanType(newVanType[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (authCntrVol[i] != null)
					model.setAuthCntrVol(authCntrVol[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pupDate[i] != null)
					model.setPupDate(pupDate[i]);
				if (listKey[i] != null)
					model.setListKey(listKey[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOnhireApprovalOwnListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OnhireApprovalOwnListVO[]
	 */
	public OnhireApprovalOwnListVO[] getOnhireApprovalOwnListVOs(){
		OnhireApprovalOwnListVO[] vos = (OnhireApprovalOwnListVO[])models.toArray(new OnhireApprovalOwnListVO[models.size()]);
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
		this.agmtNo2 = this.agmtNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo1 = this.agmtNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq = this.cntrStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDueDt = this.pkupDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authVol = this.authVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pupVol = this.pupVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authCntrVolOrg = this.authCntrVolOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tysz = this.tysz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pupYard = this.pupYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickupVol = this.pickupVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVanType = this.newVanType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authCntrVol = this.authCntrVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pupDate = this.pupDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.listKey = this.listKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
