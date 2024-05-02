/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpBlplExcelVO.java
*@FileTitle : RsltPriSpBlplExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.01 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpBlplExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpBlplExcelVO> models = new ArrayList<RsltPriSpBlplExcelVO>();
	
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prcProgStsDtl1 = null;
	/* Column Info */
	private String blplTitNm = null;
	/* Column Info */
	private String blplCtnt = null;
	/* Column Info */
	private String prcProgStsDtl = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String eff2Dt = null;
	/* Column Info */
	private String srcInfoDtl = null;
	/* Column Info */
	private String srcInfoDtl1 = null;
	/* Column Info */
	private String exp2Dt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpBlplExcelVO() {}

	public RsltPriSpBlplExcelVO(String ibflag, String pagerows, String blplTitNm, String effDt, String expDt, String srcInfoDtl, String prcProgStsDtl, String blplCtnt, String eff2Dt, String exp2Dt, String srcInfoDtl1, String prcProgStsDtl1) {
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.prcProgStsDtl1 = prcProgStsDtl1;
		this.blplTitNm = blplTitNm;
		this.blplCtnt = blplCtnt;
		this.prcProgStsDtl = prcProgStsDtl;
		this.expDt = expDt;
		this.eff2Dt = eff2Dt;
		this.srcInfoDtl = srcInfoDtl;
		this.srcInfoDtl1 = srcInfoDtl1;
		this.exp2Dt = exp2Dt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prc_prog_sts_dtl1", getPrcProgStsDtl1());
		this.hashColumns.put("blpl_tit_nm", getBlplTitNm());
		this.hashColumns.put("blpl_ctnt", getBlplCtnt());
		this.hashColumns.put("prc_prog_sts_dtl", getPrcProgStsDtl());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("eff2_dt", getEff2Dt());
		this.hashColumns.put("src_info_dtl", getSrcInfoDtl());
		this.hashColumns.put("src_info_dtl1", getSrcInfoDtl1());
		this.hashColumns.put("exp2_dt", getExp2Dt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prc_prog_sts_dtl1", "prcProgStsDtl1");
		this.hashFields.put("blpl_tit_nm", "blplTitNm");
		this.hashFields.put("blpl_ctnt", "blplCtnt");
		this.hashFields.put("prc_prog_sts_dtl", "prcProgStsDtl");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("eff2_dt", "eff2Dt");
		this.hashFields.put("src_info_dtl", "srcInfoDtl");
		this.hashFields.put("src_info_dtl1", "srcInfoDtl1");
		this.hashFields.put("exp2_dt", "exp2Dt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return prcProgStsDtl1
	 */
	public String getPrcProgStsDtl1() {
		return this.prcProgStsDtl1;
	}
	
	/**
	 * Column Info
	 * @return blplTitNm
	 */
	public String getBlplTitNm() {
		return this.blplTitNm;
	}
	
	/**
	 * Column Info
	 * @return blplCtnt
	 */
	public String getBlplCtnt() {
		return this.blplCtnt;
	}
	
	/**
	 * Column Info
	 * @return prcProgStsDtl
	 */
	public String getPrcProgStsDtl() {
		return this.prcProgStsDtl;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return eff2Dt
	 */
	public String getEff2Dt() {
		return this.eff2Dt;
	}
	
	/**
	 * Column Info
	 * @return srcInfoDtl
	 */
	public String getSrcInfoDtl() {
		return this.srcInfoDtl;
	}
	
	/**
	 * Column Info
	 * @return srcInfoDtl1
	 */
	public String getSrcInfoDtl1() {
		return this.srcInfoDtl1;
	}
	
	/**
	 * Column Info
	 * @return exp2Dt
	 */
	public String getExp2Dt() {
		return this.exp2Dt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param prcProgStsDtl1
	 */
	public void setPrcProgStsDtl1(String prcProgStsDtl1) {
		this.prcProgStsDtl1 = prcProgStsDtl1;
	}
	
	/**
	 * Column Info
	 * @param blplTitNm
	 */
	public void setBlplTitNm(String blplTitNm) {
		this.blplTitNm = blplTitNm;
	}
	
	/**
	 * Column Info
	 * @param blplCtnt
	 */
	public void setBlplCtnt(String blplCtnt) {
		this.blplCtnt = blplCtnt;
	}
	
	/**
	 * Column Info
	 * @param prcProgStsDtl
	 */
	public void setPrcProgStsDtl(String prcProgStsDtl) {
		this.prcProgStsDtl = prcProgStsDtl;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param eff2Dt
	 */
	public void setEff2Dt(String eff2Dt) {
		this.eff2Dt = eff2Dt;
	}
	
	/**
	 * Column Info
	 * @param srcInfoDtl
	 */
	public void setSrcInfoDtl(String srcInfoDtl) {
		this.srcInfoDtl = srcInfoDtl;
	}
	
	/**
	 * Column Info
	 * @param srcInfoDtl1
	 */
	public void setSrcInfoDtl1(String srcInfoDtl1) {
		this.srcInfoDtl1 = srcInfoDtl1;
	}
	
	/**
	 * Column Info
	 * @param exp2Dt
	 */
	public void setExp2Dt(String exp2Dt) {
		this.exp2Dt = exp2Dt;
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
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPrcProgStsDtl1(JSPUtil.getParameter(request, "prc_prog_sts_dtl1", ""));
		setBlplTitNm(JSPUtil.getParameter(request, "blpl_tit_nm", ""));
		setBlplCtnt(JSPUtil.getParameter(request, "blpl_ctnt", ""));
		setPrcProgStsDtl(JSPUtil.getParameter(request, "prc_prog_sts_dtl", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setEff2Dt(JSPUtil.getParameter(request, "eff2_dt", ""));
		setSrcInfoDtl(JSPUtil.getParameter(request, "src_info_dtl", ""));
		setSrcInfoDtl1(JSPUtil.getParameter(request, "src_info_dtl1", ""));
		setExp2Dt(JSPUtil.getParameter(request, "exp2_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpBlplExcelVO[]
	 */
	public RsltPriSpBlplExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpBlplExcelVO[]
	 */
	public RsltPriSpBlplExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpBlplExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] prcProgStsDtl1 = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_dtl1".trim(), length));
			String[] blplTitNm = (JSPUtil.getParameter(request, prefix	+ "blpl_tit_nm".trim(), length));
			String[] blplCtnt = (JSPUtil.getParameter(request, prefix	+ "blpl_ctnt".trim(), length));
			String[] prcProgStsDtl = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_dtl".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] eff2Dt = (JSPUtil.getParameter(request, prefix	+ "eff2_dt".trim(), length));
			String[] srcInfoDtl = (JSPUtil.getParameter(request, prefix	+ "src_info_dtl".trim(), length));
			String[] srcInfoDtl1 = (JSPUtil.getParameter(request, prefix	+ "src_info_dtl1".trim(), length));
			String[] exp2Dt = (JSPUtil.getParameter(request, prefix	+ "exp2_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpBlplExcelVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prcProgStsDtl1[i] != null)
					model.setPrcProgStsDtl1(prcProgStsDtl1[i]);
				if (blplTitNm[i] != null)
					model.setBlplTitNm(blplTitNm[i]);
				if (blplCtnt[i] != null)
					model.setBlplCtnt(blplCtnt[i]);
				if (prcProgStsDtl[i] != null)
					model.setPrcProgStsDtl(prcProgStsDtl[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (eff2Dt[i] != null)
					model.setEff2Dt(eff2Dt[i]);
				if (srcInfoDtl[i] != null)
					model.setSrcInfoDtl(srcInfoDtl[i]);
				if (srcInfoDtl1[i] != null)
					model.setSrcInfoDtl1(srcInfoDtl1[i]);
				if (exp2Dt[i] != null)
					model.setExp2Dt(exp2Dt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpBlplExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpBlplExcelVO[]
	 */
	public RsltPriSpBlplExcelVO[] getRsltPriSpBlplExcelVOs(){
		RsltPriSpBlplExcelVO[] vos = (RsltPriSpBlplExcelVO[])models.toArray(new RsltPriSpBlplExcelVO[models.size()]);
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
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsDtl1 = this.prcProgStsDtl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplTitNm = this.blplTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplCtnt = this.blplCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsDtl = this.prcProgStsDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eff2Dt = this.eff2Dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoDtl = this.srcInfoDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoDtl1 = this.srcInfoDtl1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exp2Dt = this.exp2Dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
