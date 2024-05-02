/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomAcctItmVO.java
*@FileTitle : CustomAcctItmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.21 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo;

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
 * @author 윤세영
 * @since J2EE 1.5
 * @see ESM_FMS_0069HTMLAction
 */

public class CustomAcctItmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomAcctItmVO> models = new ArrayList<CustomAcctItmVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String updUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctCd = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String updDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String creDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String creUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctEngNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmNm = null;
	/* Page Number */
	private String pagerows = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmSeq = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	  * 생성자
	  * @param
	  * @return 
	  */
	public CustomAcctItmVO() {}

	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctCd, String acctItmSeq, String acctItmNm, String creUsrId, String creDt, String updUsrId, String updDt, String acctEngNm
	 * @return 
	 */
	public CustomAcctItmVO(String ibflag, String pagerows, String acctCd, String acctItmSeq, String acctItmNm, String creUsrId, String creDt, String updUsrId, String updDt, String acctEngNm) {
		this.updUsrId = updUsrId;
		this.acctCd = acctCd;
		this.ibflag = ibflag;
		this.updDt = updDt;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.acctEngNm = acctEngNm;
		this.acctItmNm = acctItmNm;
		this.pagerows = pagerows;
		this.acctItmSeq = acctItmSeq;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		return this.hashFields;
	}
	
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
		//this.acctEngNm=true;
	}
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
		//this.acctItmNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
		//this.acctItmSeq=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
	}

	public CustomAcctItmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomAcctItmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomAcctItmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm".trim(), length));
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomAcctItmVO();
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomAcctItmVOs();
	}

	public CustomAcctItmVO[] getCustomAcctItmVOs(){
		CustomAcctItmVO[] vos = (CustomAcctItmVO[])models.toArray(new CustomAcctItmVO[models.size()]);
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
	 * @throws IllegalAccessException
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
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
