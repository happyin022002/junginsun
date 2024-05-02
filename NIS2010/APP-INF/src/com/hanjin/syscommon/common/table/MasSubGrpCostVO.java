/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MasSubGrpCostVO.java
*@FileTitle : MasSubGrpCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MasSubGrpCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasSubGrpCostVO> models = new ArrayList<MasSubGrpCostVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mgrpCostCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUcSeq = null;
	/* Column Info */
	private String fxCostDtrbFlg = null;
	/* Column Info */
	private String sgrpCostCd = null;
	/* Column Info */
	private String sgrpCostCdDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MasSubGrpCostVO() {}

	public MasSubGrpCostVO(String ibflag, String pagerows, String mgrpCostCd, String sgrpCostCd, String sgrpCostCdDesc, String fxCostDtrbFlg, String creUcSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.mgrpCostCd = mgrpCostCd;
		this.creDt = creDt;
		this.creUcSeq = creUcSeq;
		this.fxCostDtrbFlg = fxCostDtrbFlg;
		this.sgrpCostCd = sgrpCostCd;
		this.sgrpCostCdDesc = sgrpCostCdDesc;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mgrp_cost_cd", getMgrpCostCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_uc_seq", getCreUcSeq());
		this.hashColumns.put("fx_cost_dtrb_flg", getFxCostDtrbFlg());
		this.hashColumns.put("sgrp_cost_cd", getSgrpCostCd());
		this.hashColumns.put("sgrp_cost_cd_desc", getSgrpCostCdDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mgrp_cost_cd", "mgrpCostCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_uc_seq", "creUcSeq");
		this.hashFields.put("fx_cost_dtrb_flg", "fxCostDtrbFlg");
		this.hashFields.put("sgrp_cost_cd", "sgrpCostCd");
		this.hashFields.put("sgrp_cost_cd_desc", "sgrpCostCdDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return mgrpCostCd
	 */
	public String getMgrpCostCd() {
		return this.mgrpCostCd;
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
	 * @return creUcSeq
	 */
	public String getCreUcSeq() {
		return this.creUcSeq;
	}
	
	/**
	 * Column Info
	 * @return fxCostDtrbFlg
	 */
	public String getFxCostDtrbFlg() {
		return this.fxCostDtrbFlg;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCd
	 */
	public String getSgrpCostCd() {
		return this.sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCdDesc
	 */
	public String getSgrpCostCdDesc() {
		return this.sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param mgrpCostCd
	 */
	public void setMgrpCostCd(String mgrpCostCd) {
		this.mgrpCostCd = mgrpCostCd;
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
	 * @param creUcSeq
	 */
	public void setCreUcSeq(String creUcSeq) {
		this.creUcSeq = creUcSeq;
	}
	
	/**
	 * Column Info
	 * @param fxCostDtrbFlg
	 */
	public void setFxCostDtrbFlg(String fxCostDtrbFlg) {
		this.fxCostDtrbFlg = fxCostDtrbFlg;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCd
	 */
	public void setSgrpCostCd(String sgrpCostCd) {
		this.sgrpCostCd = sgrpCostCd;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCdDesc
	 */
	public void setSgrpCostCdDesc(String sgrpCostCdDesc) {
		this.sgrpCostCdDesc = sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMgrpCostCd(JSPUtil.getParameter(request, "mgrp_cost_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUcSeq(JSPUtil.getParameter(request, "cre_uc_seq", ""));
		setFxCostDtrbFlg(JSPUtil.getParameter(request, "fx_cost_dtrb_flg", ""));
		setSgrpCostCd(JSPUtil.getParameter(request, "sgrp_cost_cd", ""));
		setSgrpCostCdDesc(JSPUtil.getParameter(request, "sgrp_cost_cd_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasSubGrpCostVO[]
	 */
	public MasSubGrpCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasSubGrpCostVO[]
	 */
	public MasSubGrpCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasSubGrpCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "mgrp_cost_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUcSeq = (JSPUtil.getParameter(request, prefix	+ "cre_uc_seq", length));
			String[] fxCostDtrbFlg = (JSPUtil.getParameter(request, prefix	+ "fx_cost_dtrb_flg", length));
			String[] sgrpCostCd = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd", length));
			String[] sgrpCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasSubGrpCostVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mgrpCostCd[i] != null)
					model.setMgrpCostCd(mgrpCostCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUcSeq[i] != null)
					model.setCreUcSeq(creUcSeq[i]);
				if (fxCostDtrbFlg[i] != null)
					model.setFxCostDtrbFlg(fxCostDtrbFlg[i]);
				if (sgrpCostCd[i] != null)
					model.setSgrpCostCd(sgrpCostCd[i]);
				if (sgrpCostCdDesc[i] != null)
					model.setSgrpCostCdDesc(sgrpCostCdDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasSubGrpCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasSubGrpCostVO[]
	 */
	public MasSubGrpCostVO[] getMasSubGrpCostVOs(){
		MasSubGrpCostVO[] vos = (MasSubGrpCostVO[])models.toArray(new MasSubGrpCostVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrpCostCd = this.mgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUcSeq = this.creUcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxCostDtrbFlg = this.fxCostDtrbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCd = this.sgrpCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCdDesc = this.sgrpCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}