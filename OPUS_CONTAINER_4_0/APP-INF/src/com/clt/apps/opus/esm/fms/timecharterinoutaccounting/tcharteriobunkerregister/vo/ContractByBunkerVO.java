/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ModifyContractByBunkerVO.java
*@FileTitle : ModifyContractByBunkerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.03
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.03 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0050HTMLAction
 */

public class ContractByBunkerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ContractByBunkerVO> models = new ArrayList<ContractByBunkerVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String actDoilBodQty = null;
	/* 而щ읆 �ㅻ챸 */
	private String doilBodOutPrc = null;
	/* 而щ읆 �ㅻ챸 */
	private String foilBodOutPrc = null;
	/* Page Number */
	private String pagerows = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String effDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String foilBorOutPrc = null;
	/* 而щ읆 �ㅻ챸 */
	private String doilBorOutPrc = null;
	/* 而щ읆 �ㅻ챸 */
	private String actDoilBorQty = null;
	/* 而щ읆 �ㅻ챸 */
	private String expDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String actFoilBodQty = null;
	/* 而щ읆 �ㅻ챸 */
	private String actFoilBorQty = null;
	/* Column Info */
	private String bodPortCd = null;
	/* Column Info */
	private String borPortCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public ContractByBunkerVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String effDt, String expDt, String actFoilBodQty, String actDoilBodQty, String actFoilBorQty, String actDoilBorQty, String foilBodOutPrc, String doilBodOutPrc, String foilBorOutPrc, String doilBorOutPrc
	 * @return 
	 */
	public ContractByBunkerVO(String ibflag, String pagerows, String fletCtrtNo, String effDt, String expDt, String actFoilBodQty, String actDoilBodQty, String actFoilBorQty, String actDoilBorQty, String foilBodOutPrc, String doilBodOutPrc, String foilBorOutPrc, String doilBorOutPrc, String bodPortCd, String borPortCd) {
		this.actDoilBodQty = actDoilBodQty;
		this.doilBodOutPrc = doilBodOutPrc;
		this.foilBodOutPrc = foilBodOutPrc;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.foilBorOutPrc = foilBorOutPrc;
		this.doilBorOutPrc = doilBorOutPrc;
		this.actDoilBorQty = actDoilBorQty;
		this.expDt = expDt;
		this.actFoilBodQty = actFoilBodQty;
		this.actFoilBorQty = actFoilBorQty;
		this.bodPortCd = bodPortCd;
		this.borPortCd = borPortCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_doil_bod_qty", getActDoilBodQty());
		this.hashColumns.put("doil_bod_out_prc", getDoilBodOutPrc());
		this.hashColumns.put("foil_bod_out_prc", getFoilBodOutPrc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("foil_bor_out_prc", getFoilBorOutPrc());
		this.hashColumns.put("doil_bor_out_prc", getDoilBorOutPrc());
		this.hashColumns.put("act_doil_bor_qty", getActDoilBorQty());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("act_foil_bod_qty", getActFoilBodQty());
		this.hashColumns.put("act_foil_bor_qty", getActFoilBorQty());
		this.hashColumns.put("bod_port_cd", getBodPortCd());
		this.hashColumns.put("bor_port_cd", getBorPortCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_doil_bod_qty", "actDoilBodQty");
		this.hashFields.put("doil_bod_out_prc", "doilBodOutPrc");
		this.hashFields.put("foil_bod_out_prc", "foilBodOutPrc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("foil_bor_out_prc", "foilBorOutPrc");
		this.hashFields.put("doil_bor_out_prc", "doilBorOutPrc");
		this.hashFields.put("act_doil_bor_qty", "actDoilBorQty");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("act_foil_bod_qty", "actFoilBodQty");
		this.hashFields.put("act_foil_bor_qty", "actFoilBorQty");
		this.hashFields.put("bod_port_cd", "bodPortCd");
		this.hashFields.put("bor_port_cd", "borPortCd");
		return this.hashFields;
	}
	
	public String getActDoilBodQty() {
		return this.actDoilBodQty;
	}
	public String getDoilBodOutPrc() {
		return this.doilBodOutPrc;
	}
	public String getFoilBodOutPrc() {
		return this.foilBodOutPrc;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getFoilBorOutPrc() {
		return this.foilBorOutPrc;
	}
	public String getDoilBorOutPrc() {
		return this.doilBorOutPrc;
	}
	public String getActDoilBorQty() {
		return this.actDoilBorQty;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getActFoilBodQty() {
		return this.actFoilBodQty;
	}
	public String getActFoilBorQty() {
		return this.actFoilBorQty;
	}
	public String getBodPortCd() {
		return this.bodPortCd;
	}
	public String getBorPortCd() {
		return this.borPortCd;
	}

	public void setActDoilBodQty(String actDoilBodQty) {
		this.actDoilBodQty = actDoilBodQty;
		//this.actDoilBodQty=true;
	}
	public void setDoilBodOutPrc(String doilBodOutPrc) {
		this.doilBodOutPrc = doilBodOutPrc;
		//this.doilBodOutPrc=true;
	}
	public void setFoilBodOutPrc(String foilBodOutPrc) {
		this.foilBodOutPrc = foilBodOutPrc;
		//this.foilBodOutPrc=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setFoilBorOutPrc(String foilBorOutPrc) {
		this.foilBorOutPrc = foilBorOutPrc;
		//this.foilBorOutPrc=true;
	}
	public void setDoilBorOutPrc(String doilBorOutPrc) {
		this.doilBorOutPrc = doilBorOutPrc;
		//this.doilBorOutPrc=true;
	}
	public void setActDoilBorQty(String actDoilBorQty) {
		this.actDoilBorQty = actDoilBorQty;
		//this.actDoilBorQty=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setActFoilBodQty(String actFoilBodQty) {
		this.actFoilBodQty = actFoilBodQty;
		//this.actFoilBodQty=true;
	}
	public void setActFoilBorQty(String actFoilBorQty) {
		this.actFoilBorQty = actFoilBorQty;
		//this.actFoilBorQty=true;
	}
	public void setBodPortCd(String bodPortCd) {
		this.bodPortCd = bodPortCd;
		//this.bodPortCd=true;
	}
	public void setBorPortCd(String borPortCd) {
		this.borPortCd = borPortCd;
		//this.borPortCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setActDoilBodQty(JSPUtil.getParameter(request, "act_doil_bod_qty", ""));
		setDoilBodOutPrc(JSPUtil.getParameter(request, "doil_bod_out_prc", ""));
		setFoilBodOutPrc(JSPUtil.getParameter(request, "foil_bod_out_prc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setFoilBorOutPrc(JSPUtil.getParameter(request, "foil_bor_out_prc", ""));
		setDoilBorOutPrc(JSPUtil.getParameter(request, "doil_bor_out_prc", ""));
		setActDoilBorQty(JSPUtil.getParameter(request, "act_doil_bor_qty", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setActFoilBodQty(JSPUtil.getParameter(request, "act_foil_bod_qty", ""));
		setActFoilBorQty(JSPUtil.getParameter(request, "act_foil_bor_qty", ""));
		setBodPortCd(JSPUtil.getParameter(request, "bod_port_cd", ""));
		setBorPortCd(JSPUtil.getParameter(request, "bor_port_cd", ""));
	}

	public ContractByBunkerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ContractByBunkerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ContractByBunkerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actDoilBodQty = (JSPUtil.getParameter(request, prefix	+ "act_doil_bod_qty".trim(), length));
			String[] doilBodOutPrc = (JSPUtil.getParameter(request, prefix	+ "doil_bod_out_prc".trim(), length));
			String[] foilBodOutPrc = (JSPUtil.getParameter(request, prefix	+ "foil_bod_out_prc".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] foilBorOutPrc = (JSPUtil.getParameter(request, prefix	+ "foil_bor_out_prc".trim(), length));
			String[] doilBorOutPrc = (JSPUtil.getParameter(request, prefix	+ "doil_bor_out_prc".trim(), length));
			String[] actDoilBorQty = (JSPUtil.getParameter(request, prefix	+ "act_doil_bor_qty".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] actFoilBodQty = (JSPUtil.getParameter(request, prefix	+ "act_foil_bod_qty".trim(), length));
			String[] actFoilBorQty = (JSPUtil.getParameter(request, prefix	+ "act_foil_bor_qty".trim(), length));
			String[] bodPortCd = (JSPUtil.getParameter(request, prefix	+ "bod_port_cd".trim(), length));
			String[] borPortCd = (JSPUtil.getParameter(request, prefix	+ "bor_port_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ContractByBunkerVO();
				if (actDoilBodQty[i] != null)
					model.setActDoilBodQty(actDoilBodQty[i]);
				if (doilBodOutPrc[i] != null)
					model.setDoilBodOutPrc(doilBodOutPrc[i]);
				if (foilBodOutPrc[i] != null)
					model.setFoilBodOutPrc(foilBodOutPrc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (foilBorOutPrc[i] != null)
					model.setFoilBorOutPrc(foilBorOutPrc[i]);
				if (doilBorOutPrc[i] != null)
					model.setDoilBorOutPrc(doilBorOutPrc[i]);
				if (actDoilBorQty[i] != null)
					model.setActDoilBorQty(actDoilBorQty[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (actFoilBodQty[i] != null)
					model.setActFoilBodQty(actFoilBodQty[i]);
				if (actFoilBorQty[i] != null)
					model.setActFoilBorQty(actFoilBorQty[i]);
				if (bodPortCd[i] != null)
					model.setBodPortCd(bodPortCd[i]);
				if (borPortCd[i] != null)
					model.setBorPortCd(borPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getModifyContractByBunkerVOs();
	}

	public ContractByBunkerVO[] getModifyContractByBunkerVOs(){
		ContractByBunkerVO[] vos = (ContractByBunkerVO[])models.toArray(new ContractByBunkerVO[models.size()]);
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
		this.actDoilBodQty = this.actDoilBodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilBodOutPrc = this.doilBodOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBodOutPrc = this.foilBodOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBorOutPrc = this.foilBorOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilBorOutPrc = this.doilBorOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDoilBorQty = this.actDoilBorQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilBodQty = this.actFoilBodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilBorQty = this.actFoilBorQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodPortCd = this.bodPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.borPortCd = this.borPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
