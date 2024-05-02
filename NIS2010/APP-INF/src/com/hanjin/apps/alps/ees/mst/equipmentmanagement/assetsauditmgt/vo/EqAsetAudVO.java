/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MstEqAsetAudVO.java
*@FileTitle : MstEqAsetAudVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.09.01 이호선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqAsetAudVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqAsetAudVO> models = new ArrayList<EqAsetAudVO>();
	
	/* Column Info */
	private String faQty = null;
	/* Column Info */
	private String mstQty = null;
	/* Column Info */
	private String mstOnyQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String diffRmkM = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String faOnyQty = null;
	/* Column Info */
	private String verNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String yrMon = null;
	/* Column Info */
	private String rsltCd = null;
	/* Column Info */
	private String diffQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqAsetAudVO() {}

	public EqAsetAudVO(String ibflag, String pagerows, String yrMon, String eqType, String verNo, String mstQty, String faQty, String creDt, String diffQty, String mstOnyQty, String faOnyQty, String diffRmkM, String rsltCd) {
		this.faQty = faQty;
		this.mstQty = mstQty;
		this.mstOnyQty = mstOnyQty;
		this.creDt = creDt;
		this.diffRmkM = diffRmkM;
		this.eqType = eqType;
		this.pagerows = pagerows;
		this.faOnyQty = faOnyQty;
		this.verNo = verNo;
		this.ibflag = ibflag;
		this.yrMon = yrMon;
		this.rsltCd = rsltCd;
		this.diffQty = diffQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fa_qty", getFaQty());
		this.hashColumns.put("mst_qty", getMstQty());
		this.hashColumns.put("mst_ony_qty", getMstOnyQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("diff_rmk_m", getDiffRmkM());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fa_ony_qty", getFaOnyQty());
		this.hashColumns.put("ver_no", getVerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yr_mon", getYrMon());
		this.hashColumns.put("rslt_cd", getRsltCd());
		this.hashColumns.put("diff_qty", getDiffQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fa_qty", "faQty");
		this.hashFields.put("mst_qty", "mstQty");
		this.hashFields.put("mst_ony_qty", "mstOnyQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("diff_rmk_m", "diffRmkM");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fa_ony_qty", "faOnyQty");
		this.hashFields.put("ver_no", "verNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yr_mon", "yrMon");
		this.hashFields.put("rslt_cd", "rsltCd");
		this.hashFields.put("diff_qty", "diffQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return faQty
	 */
	public String getFaQty() {
		return this.faQty;
	}
	
	/**
	 * Column Info
	 * @return mstQty
	 */
	public String getMstQty() {
		return this.mstQty;
	}
	
	/**
	 * Column Info
	 * @return mstOnyQty
	 */
	public String getMstOnyQty() {
		return this.mstOnyQty;
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
	 * @return diffRmkM
	 */
	public String getDiffRmkM() {
		return this.diffRmkM;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @return faOnyQty
	 */
	public String getFaOnyQty() {
		return this.faOnyQty;
	}
	
	/**
	 * Column Info
	 * @return verNo
	 */
	public String getVerNo() {
		return this.verNo;
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
	 * @return yrMon
	 */
	public String getYrMon() {
		return this.yrMon;
	}
	
	/**
	 * Column Info
	 * @return rsltCd
	 */
	public String getRsltCd() {
		return this.rsltCd;
	}
	
	/**
	 * Column Info
	 * @return diffQty
	 */
	public String getDiffQty() {
		return this.diffQty;
	}
	

	/**
	 * Column Info
	 * @param faQty
	 */
	public void setFaQty(String faQty) {
		this.faQty = faQty;
	}
	
	/**
	 * Column Info
	 * @param mstQty
	 */
	public void setMstQty(String mstQty) {
		this.mstQty = mstQty;
	}
	
	/**
	 * Column Info
	 * @param mstOnyQty
	 */
	public void setMstOnyQty(String mstOnyQty) {
		this.mstOnyQty = mstOnyQty;
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
	 * @param diffRmkM
	 */
	public void setDiffRmkM(String diffRmkM) {
		this.diffRmkM = diffRmkM;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
	 * @param faOnyQty
	 */
	public void setFaOnyQty(String faOnyQty) {
		this.faOnyQty = faOnyQty;
	}
	
	/**
	 * Column Info
	 * @param verNo
	 */
	public void setVerNo(String verNo) {
		this.verNo = verNo;
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
	 * @param yrMon
	 */
	public void setYrMon(String yrMon) {
		this.yrMon = yrMon;
	}
	
	/**
	 * Column Info
	 * @param rsltCd
	 */
	public void setRsltCd(String rsltCd) {
		this.rsltCd = rsltCd;
	}
	
	/**
	 * Column Info
	 * @param diffQty
	 */
	public void setDiffQty(String diffQty) {
		this.diffQty = diffQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFaQty(JSPUtil.getParameter(request, "fa_qty", ""));
		setMstQty(JSPUtil.getParameter(request, "mst_qty", ""));
		setMstOnyQty(JSPUtil.getParameter(request, "mst_ony_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDiffRmkM(JSPUtil.getParameter(request, "diff_rmk_m", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFaOnyQty(JSPUtil.getParameter(request, "fa_ony_qty", ""));
		setVerNo(JSPUtil.getParameter(request, "ver_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYrMon(JSPUtil.getParameter(request, "yr_mon", ""));
		setRsltCd(JSPUtil.getParameter(request, "rslt_cd", ""));
		setDiffQty(JSPUtil.getParameter(request, "diff_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqAsetAudVO[]
	 */
	public EqAsetAudVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqAsetAudVO[]
	 */
	public EqAsetAudVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqAsetAudVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] faQty = (JSPUtil.getParameter(request, prefix	+ "fa_qty", length));
			String[] mstQty = (JSPUtil.getParameter(request, prefix	+ "mst_qty", length));
			String[] mstOnyQty = (JSPUtil.getParameter(request, prefix	+ "mst_ony_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] diffRmkM = (JSPUtil.getParameter(request, prefix	+ "diff_rmk_m", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] faOnyQty = (JSPUtil.getParameter(request, prefix	+ "fa_ony_qty", length));
			String[] verNo = (JSPUtil.getParameter(request, prefix	+ "ver_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] yrMon = (JSPUtil.getParameter(request, prefix	+ "yr_mon", length));
			String[] rsltCd = (JSPUtil.getParameter(request, prefix	+ "rslt_cd", length));
			String[] diffQty = (JSPUtil.getParameter(request, prefix	+ "diff_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqAsetAudVO();
				if (faQty[i] != null)
					model.setFaQty(faQty[i]);
				if (mstQty[i] != null)
					model.setMstQty(mstQty[i]);
				if (mstOnyQty[i] != null)
					model.setMstOnyQty(mstOnyQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (diffRmkM[i] != null)
					model.setDiffRmkM(diffRmkM[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (faOnyQty[i] != null)
					model.setFaOnyQty(faOnyQty[i]);
				if (verNo[i] != null)
					model.setVerNo(verNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yrMon[i] != null)
					model.setYrMon(yrMon[i]);
				if (rsltCd[i] != null)
					model.setRsltCd(rsltCd[i]);
				if (diffQty[i] != null)
					model.setDiffQty(diffQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqAsetAudVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqAsetAudVO[]
	 */
	public EqAsetAudVO[] getEqAsetAudVOs(){
		EqAsetAudVO[] vos = (EqAsetAudVO[])models.toArray(new EqAsetAudVO[models.size()]);
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
		this.faQty = this.faQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstQty = this.mstQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstOnyQty = this.mstOnyQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmkM = this.diffRmkM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faOnyQty = this.faOnyQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verNo = this.verNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrMon = this.yrMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltCd = this.rsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffQty = this.diffQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
