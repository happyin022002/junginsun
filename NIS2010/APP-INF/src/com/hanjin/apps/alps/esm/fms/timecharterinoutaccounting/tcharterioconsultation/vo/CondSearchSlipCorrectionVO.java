/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchSlipCorrectionVO.java
*@FileTitle : CondSearchSlipCorrectionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.07 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondSearchSlipCorrectionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchSlipCorrectionVO> models = new ArrayList<CondSearchSlipCorrectionVO>();
	
	/* Column Info */
	private String fromCreDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String fromEffDt = null;
	/* Column Info */
	private String toCreDt = null;
	/* Column Info */
	private String slipAproFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchSlipCorrectionVO() {}

	public CondSearchSlipCorrectionVO(String ibflag, String pagerows, String fromEffDt, String toEffDt, String fromCreDt, String toCreDt, String vslCd, String csrNo, String slipAproFlg) {
		this.fromCreDt = fromCreDt;
		this.csrNo = csrNo;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.toEffDt = toEffDt;
		this.fromEffDt = fromEffDt;
		this.toCreDt = toCreDt;
		this.slipAproFlg = slipAproFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_cre_dt", getFromCreDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("from_eff_dt", getFromEffDt());
		this.hashColumns.put("to_cre_dt", getToCreDt());
		this.hashColumns.put("slip_apro_flg", getSlipAproFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_cre_dt", "fromCreDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("from_eff_dt", "fromEffDt");
		this.hashFields.put("to_cre_dt", "toCreDt");
		this.hashFields.put("slip_apro_flg", "slipAproFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromCreDt
	 */
	public String getFromCreDt() {
		return this.fromCreDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return fromEffDt
	 */
	public String getFromEffDt() {
		return this.fromEffDt;
	}
	
	/**
	 * Column Info
	 * @return toCreDt
	 */
	public String getToCreDt() {
		return this.toCreDt;
	}
	
	/**
	 * Column Info
	 * @return slipAproFlg
	 */
	public String getSlipAproFlg() {
		return this.slipAproFlg;
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
	 * @param fromCreDt
	 */
	public void setFromCreDt(String fromCreDt) {
		this.fromCreDt = fromCreDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param fromEffDt
	 */
	public void setFromEffDt(String fromEffDt) {
		this.fromEffDt = fromEffDt;
	}
	
	/**
	 * Column Info
	 * @param toCreDt
	 */
	public void setToCreDt(String toCreDt) {
		this.toCreDt = toCreDt;
	}
	
	/**
	 * Column Info
	 * @param slipAproFlg
	 */
	public void setSlipAproFlg(String slipAproFlg) {
		this.slipAproFlg = slipAproFlg;
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
		setFromCreDt(JSPUtil.getParameter(request, "from_cre_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToEffDt(JSPUtil.getParameter(request, "to_eff_dt", ""));
		setFromEffDt(JSPUtil.getParameter(request, "from_eff_dt", ""));
		setToCreDt(JSPUtil.getParameter(request, "to_cre_dt", ""));
		setSlipAproFlg(JSPUtil.getParameter(request, "slip_apro_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchSlipCorrectionVO[]
	 */
	public CondSearchSlipCorrectionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchSlipCorrectionVO[]
	 */
	public CondSearchSlipCorrectionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchSlipCorrectionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromCreDt = (JSPUtil.getParameter(request, prefix	+ "from_cre_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] fromEffDt = (JSPUtil.getParameter(request, prefix	+ "from_eff_dt", length));
			String[] toCreDt = (JSPUtil.getParameter(request, prefix	+ "to_cre_dt", length));
			String[] slipAproFlg = (JSPUtil.getParameter(request, prefix	+ "slip_apro_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchSlipCorrectionVO();
				if (fromCreDt[i] != null)
					model.setFromCreDt(fromCreDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (fromEffDt[i] != null)
					model.setFromEffDt(fromEffDt[i]);
				if (toCreDt[i] != null)
					model.setToCreDt(toCreDt[i]);
				if (slipAproFlg[i] != null)
					model.setSlipAproFlg(slipAproFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchSlipCorrectionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchSlipCorrectionVO[]
	 */
	public CondSearchSlipCorrectionVO[] getCondSearchSlipCorrectionVOs(){
		CondSearchSlipCorrectionVO[] vos = (CondSearchSlipCorrectionVO[])models.toArray(new CondSearchSlipCorrectionVO[models.size()]);
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
		this.fromCreDt = this.fromCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEffDt = this.fromEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCreDt = this.toCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipAproFlg = this.slipAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}