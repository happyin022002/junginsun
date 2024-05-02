/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutBdMovementStsYardSumListOutVO.java
*@FileTitle : OutBdMovementStsYardSumListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.09.03 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OutBdMovementStsYardSumListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutBdMovementStsYardSumListOutVO> models = new ArrayList<OutBdMovementStsYardSumListOutVO>();
	
	/* Column Info */
	private String otDr4 = null;
	/* Column Info */
	private String mtDr2 = null;
	/* Column Info */
	private String ocDr2 = null;
	/* Column Info */
	private String mtDr4 = null;
	/* Column Info */
	private String ocDr4 = null;
	/* Column Info */
	private String ocRf2 = null;
	/* Column Info */
	private String etnRf2 = null;
	/* Column Info */
	private String opDr2 = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String opDr4 = null;
	/* Column Info */
	private String etnDr2 = null;
	/* Column Info */
	private String ocRf4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String etnDr4 = null;
	/* Column Info */
	private String mtRf2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etnRf4 = null;
	/* Column Info */
	private String otDr2 = null;
	/* Column Info */
	private String opRf2 = null;
	/* Column Info */
	private String opRf4 = null;
	/* Column Info */
	private String otRf2 = null;
	/* Column Info */
	private String otRf4 = null;
	/* Column Info */
	private String mtRf4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OutBdMovementStsYardSumListOutVO() {}

	public OutBdMovementStsYardSumListOutVO(String ibflag, String pagerows, String orgYdCd, String opDr2, String opDr4, String opRf2, String opRf4, String ocDr2, String ocDr4, String ocRf2, String ocRf4, String etnDr2, String etnDr4, String etnRf2, String etnRf4, String mtDr2, String mtDr4, String mtRf2, String mtRf4, String otDr2, String otDr4, String otRf2, String otRf4) {
		this.otDr4 = otDr4;
		this.mtDr2 = mtDr2;
		this.ocDr2 = ocDr2;
		this.mtDr4 = mtDr4;
		this.ocDr4 = ocDr4;
		this.ocRf2 = ocRf2;
		this.etnRf2 = etnRf2;
		this.opDr2 = opDr2;
		this.orgYdCd = orgYdCd;
		this.opDr4 = opDr4;
		this.etnDr2 = etnDr2;
		this.ocRf4 = ocRf4;
		this.pagerows = pagerows;
		this.etnDr4 = etnDr4;
		this.mtRf2 = mtRf2;
		this.ibflag = ibflag;
		this.etnRf4 = etnRf4;
		this.otDr2 = otDr2;
		this.opRf2 = opRf2;
		this.opRf4 = opRf4;
		this.otRf2 = otRf2;
		this.otRf4 = otRf4;
		this.mtRf4 = mtRf4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ot_dr4", getOtDr4());
		this.hashColumns.put("mt_dr2", getMtDr2());
		this.hashColumns.put("oc_dr2", getOcDr2());
		this.hashColumns.put("mt_dr4", getMtDr4());
		this.hashColumns.put("oc_dr4", getOcDr4());
		this.hashColumns.put("oc_rf2", getOcRf2());
		this.hashColumns.put("etn_rf2", getEtnRf2());
		this.hashColumns.put("op_dr2", getOpDr2());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("op_dr4", getOpDr4());
		this.hashColumns.put("etn_dr2", getEtnDr2());
		this.hashColumns.put("oc_rf4", getOcRf4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("etn_dr4", getEtnDr4());
		this.hashColumns.put("mt_rf2", getMtRf2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etn_rf4", getEtnRf4());
		this.hashColumns.put("ot_dr2", getOtDr2());
		this.hashColumns.put("op_rf2", getOpRf2());
		this.hashColumns.put("op_rf4", getOpRf4());
		this.hashColumns.put("ot_rf2", getOtRf2());
		this.hashColumns.put("ot_rf4", getOtRf4());
		this.hashColumns.put("mt_rf4", getMtRf4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ot_dr4", "otDr4");
		this.hashFields.put("mt_dr2", "mtDr2");
		this.hashFields.put("oc_dr2", "ocDr2");
		this.hashFields.put("mt_dr4", "mtDr4");
		this.hashFields.put("oc_dr4", "ocDr4");
		this.hashFields.put("oc_rf2", "ocRf2");
		this.hashFields.put("etn_rf2", "etnRf2");
		this.hashFields.put("op_dr2", "opDr2");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("op_dr4", "opDr4");
		this.hashFields.put("etn_dr2", "etnDr2");
		this.hashFields.put("oc_rf4", "ocRf4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("etn_dr4", "etnDr4");
		this.hashFields.put("mt_rf2", "mtRf2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etn_rf4", "etnRf4");
		this.hashFields.put("ot_dr2", "otDr2");
		this.hashFields.put("op_rf2", "opRf2");
		this.hashFields.put("op_rf4", "opRf4");
		this.hashFields.put("ot_rf2", "otRf2");
		this.hashFields.put("ot_rf4", "otRf4");
		this.hashFields.put("mt_rf4", "mtRf4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otDr4
	 */
	public String getOtDr4() {
		return this.otDr4;
	}
	
	/**
	 * Column Info
	 * @return mtDr2
	 */
	public String getMtDr2() {
		return this.mtDr2;
	}
	
	/**
	 * Column Info
	 * @return ocDr2
	 */
	public String getOcDr2() {
		return this.ocDr2;
	}
	
	/**
	 * Column Info
	 * @return mtDr4
	 */
	public String getMtDr4() {
		return this.mtDr4;
	}
	
	/**
	 * Column Info
	 * @return ocDr4
	 */
	public String getOcDr4() {
		return this.ocDr4;
	}
	
	/**
	 * Column Info
	 * @return ocRf2
	 */
	public String getOcRf2() {
		return this.ocRf2;
	}
	
	/**
	 * Column Info
	 * @return etnRf2
	 */
	public String getEtnRf2() {
		return this.etnRf2;
	}
	
	/**
	 * Column Info
	 * @return opDr2
	 */
	public String getOpDr2() {
		return this.opDr2;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return opDr4
	 */
	public String getOpDr4() {
		return this.opDr4;
	}
	
	/**
	 * Column Info
	 * @return etnDr2
	 */
	public String getEtnDr2() {
		return this.etnDr2;
	}
	
	/**
	 * Column Info
	 * @return ocRf4
	 */
	public String getOcRf4() {
		return this.ocRf4;
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
	 * @return etnDr4
	 */
	public String getEtnDr4() {
		return this.etnDr4;
	}
	
	/**
	 * Column Info
	 * @return mtRf2
	 */
	public String getMtRf2() {
		return this.mtRf2;
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
	 * @return etnRf4
	 */
	public String getEtnRf4() {
		return this.etnRf4;
	}
	
	/**
	 * Column Info
	 * @return otDr2
	 */
	public String getOtDr2() {
		return this.otDr2;
	}
	
	/**
	 * Column Info
	 * @return opRf2
	 */
	public String getOpRf2() {
		return this.opRf2;
	}
	
	/**
	 * Column Info
	 * @return opRf4
	 */
	public String getOpRf4() {
		return this.opRf4;
	}
	
	/**
	 * Column Info
	 * @return otRf2
	 */
	public String getOtRf2() {
		return this.otRf2;
	}
	
	/**
	 * Column Info
	 * @return otRf4
	 */
	public String getOtRf4() {
		return this.otRf4;
	}
	
	/**
	 * Column Info
	 * @return mtRf4
	 */
	public String getMtRf4() {
		return this.mtRf4;
	}
	

	/**
	 * Column Info
	 * @param otDr4
	 */
	public void setOtDr4(String otDr4) {
		this.otDr4 = otDr4;
	}
	
	/**
	 * Column Info
	 * @param mtDr2
	 */
	public void setMtDr2(String mtDr2) {
		this.mtDr2 = mtDr2;
	}
	
	/**
	 * Column Info
	 * @param ocDr2
	 */
	public void setOcDr2(String ocDr2) {
		this.ocDr2 = ocDr2;
	}
	
	/**
	 * Column Info
	 * @param mtDr4
	 */
	public void setMtDr4(String mtDr4) {
		this.mtDr4 = mtDr4;
	}
	
	/**
	 * Column Info
	 * @param ocDr4
	 */
	public void setOcDr4(String ocDr4) {
		this.ocDr4 = ocDr4;
	}
	
	/**
	 * Column Info
	 * @param ocRf2
	 */
	public void setOcRf2(String ocRf2) {
		this.ocRf2 = ocRf2;
	}
	
	/**
	 * Column Info
	 * @param etnRf2
	 */
	public void setEtnRf2(String etnRf2) {
		this.etnRf2 = etnRf2;
	}
	
	/**
	 * Column Info
	 * @param opDr2
	 */
	public void setOpDr2(String opDr2) {
		this.opDr2 = opDr2;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param opDr4
	 */
	public void setOpDr4(String opDr4) {
		this.opDr4 = opDr4;
	}
	
	/**
	 * Column Info
	 * @param etnDr2
	 */
	public void setEtnDr2(String etnDr2) {
		this.etnDr2 = etnDr2;
	}
	
	/**
	 * Column Info
	 * @param ocRf4
	 */
	public void setOcRf4(String ocRf4) {
		this.ocRf4 = ocRf4;
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
	 * @param etnDr4
	 */
	public void setEtnDr4(String etnDr4) {
		this.etnDr4 = etnDr4;
	}
	
	/**
	 * Column Info
	 * @param mtRf2
	 */
	public void setMtRf2(String mtRf2) {
		this.mtRf2 = mtRf2;
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
	 * @param etnRf4
	 */
	public void setEtnRf4(String etnRf4) {
		this.etnRf4 = etnRf4;
	}
	
	/**
	 * Column Info
	 * @param otDr2
	 */
	public void setOtDr2(String otDr2) {
		this.otDr2 = otDr2;
	}
	
	/**
	 * Column Info
	 * @param opRf2
	 */
	public void setOpRf2(String opRf2) {
		this.opRf2 = opRf2;
	}
	
	/**
	 * Column Info
	 * @param opRf4
	 */
	public void setOpRf4(String opRf4) {
		this.opRf4 = opRf4;
	}
	
	/**
	 * Column Info
	 * @param otRf2
	 */
	public void setOtRf2(String otRf2) {
		this.otRf2 = otRf2;
	}
	
	/**
	 * Column Info
	 * @param otRf4
	 */
	public void setOtRf4(String otRf4) {
		this.otRf4 = otRf4;
	}
	
	/**
	 * Column Info
	 * @param mtRf4
	 */
	public void setMtRf4(String mtRf4) {
		this.mtRf4 = mtRf4;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOtDr4(JSPUtil.getParameter(request, "ot_dr4", ""));
		setMtDr2(JSPUtil.getParameter(request, "mt_dr2", ""));
		setOcDr2(JSPUtil.getParameter(request, "oc_dr2", ""));
		setMtDr4(JSPUtil.getParameter(request, "mt_dr4", ""));
		setOcDr4(JSPUtil.getParameter(request, "oc_dr4", ""));
		setOcRf2(JSPUtil.getParameter(request, "oc_rf2", ""));
		setEtnRf2(JSPUtil.getParameter(request, "etn_rf2", ""));
		setOpDr2(JSPUtil.getParameter(request, "op_dr2", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setOpDr4(JSPUtil.getParameter(request, "op_dr4", ""));
		setEtnDr2(JSPUtil.getParameter(request, "etn_dr2", ""));
		setOcRf4(JSPUtil.getParameter(request, "oc_rf4", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEtnDr4(JSPUtil.getParameter(request, "etn_dr4", ""));
		setMtRf2(JSPUtil.getParameter(request, "mt_rf2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtnRf4(JSPUtil.getParameter(request, "etn_rf4", ""));
		setOtDr2(JSPUtil.getParameter(request, "ot_dr2", ""));
		setOpRf2(JSPUtil.getParameter(request, "op_rf2", ""));
		setOpRf4(JSPUtil.getParameter(request, "op_rf4", ""));
		setOtRf2(JSPUtil.getParameter(request, "ot_rf2", ""));
		setOtRf4(JSPUtil.getParameter(request, "ot_rf4", ""));
		setMtRf4(JSPUtil.getParameter(request, "mt_rf4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutBdMovementStsYardSumListOutVO[]
	 */
	public OutBdMovementStsYardSumListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutBdMovementStsYardSumListOutVO[]
	 */
	public OutBdMovementStsYardSumListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutBdMovementStsYardSumListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otDr4 = (JSPUtil.getParameter(request, prefix	+ "ot_dr4", length));
			String[] mtDr2 = (JSPUtil.getParameter(request, prefix	+ "mt_dr2", length));
			String[] ocDr2 = (JSPUtil.getParameter(request, prefix	+ "oc_dr2", length));
			String[] mtDr4 = (JSPUtil.getParameter(request, prefix	+ "mt_dr4", length));
			String[] ocDr4 = (JSPUtil.getParameter(request, prefix	+ "oc_dr4", length));
			String[] ocRf2 = (JSPUtil.getParameter(request, prefix	+ "oc_rf2", length));
			String[] etnRf2 = (JSPUtil.getParameter(request, prefix	+ "etn_rf2", length));
			String[] opDr2 = (JSPUtil.getParameter(request, prefix	+ "op_dr2", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] opDr4 = (JSPUtil.getParameter(request, prefix	+ "op_dr4", length));
			String[] etnDr2 = (JSPUtil.getParameter(request, prefix	+ "etn_dr2", length));
			String[] ocRf4 = (JSPUtil.getParameter(request, prefix	+ "oc_rf4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] etnDr4 = (JSPUtil.getParameter(request, prefix	+ "etn_dr4", length));
			String[] mtRf2 = (JSPUtil.getParameter(request, prefix	+ "mt_rf2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etnRf4 = (JSPUtil.getParameter(request, prefix	+ "etn_rf4", length));
			String[] otDr2 = (JSPUtil.getParameter(request, prefix	+ "ot_dr2", length));
			String[] opRf2 = (JSPUtil.getParameter(request, prefix	+ "op_rf2", length));
			String[] opRf4 = (JSPUtil.getParameter(request, prefix	+ "op_rf4", length));
			String[] otRf2 = (JSPUtil.getParameter(request, prefix	+ "ot_rf2", length));
			String[] otRf4 = (JSPUtil.getParameter(request, prefix	+ "ot_rf4", length));
			String[] mtRf4 = (JSPUtil.getParameter(request, prefix	+ "mt_rf4", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutBdMovementStsYardSumListOutVO();
				if (otDr4[i] != null)
					model.setOtDr4(otDr4[i]);
				if (mtDr2[i] != null)
					model.setMtDr2(mtDr2[i]);
				if (ocDr2[i] != null)
					model.setOcDr2(ocDr2[i]);
				if (mtDr4[i] != null)
					model.setMtDr4(mtDr4[i]);
				if (ocDr4[i] != null)
					model.setOcDr4(ocDr4[i]);
				if (ocRf2[i] != null)
					model.setOcRf2(ocRf2[i]);
				if (etnRf2[i] != null)
					model.setEtnRf2(etnRf2[i]);
				if (opDr2[i] != null)
					model.setOpDr2(opDr2[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (opDr4[i] != null)
					model.setOpDr4(opDr4[i]);
				if (etnDr2[i] != null)
					model.setEtnDr2(etnDr2[i]);
				if (ocRf4[i] != null)
					model.setOcRf4(ocRf4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (etnDr4[i] != null)
					model.setEtnDr4(etnDr4[i]);
				if (mtRf2[i] != null)
					model.setMtRf2(mtRf2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etnRf4[i] != null)
					model.setEtnRf4(etnRf4[i]);
				if (otDr2[i] != null)
					model.setOtDr2(otDr2[i]);
				if (opRf2[i] != null)
					model.setOpRf2(opRf2[i]);
				if (opRf4[i] != null)
					model.setOpRf4(opRf4[i]);
				if (otRf2[i] != null)
					model.setOtRf2(otRf2[i]);
				if (otRf4[i] != null)
					model.setOtRf4(otRf4[i]);
				if (mtRf4[i] != null)
					model.setMtRf4(mtRf4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutBdMovementStsYardSumListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutBdMovementStsYardSumListOutVO[]
	 */
	public OutBdMovementStsYardSumListOutVO[] getOutBdMovementStsYardSumListOutVOs(){
		OutBdMovementStsYardSumListOutVO[] vos = (OutBdMovementStsYardSumListOutVO[])models.toArray(new OutBdMovementStsYardSumListOutVO[models.size()]);
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
		this.otDr4 = this.otDr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtDr2 = this.mtDr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocDr2 = this.ocDr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtDr4 = this.mtDr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocDr4 = this.ocDr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocRf2 = this.ocRf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etnRf2 = this.etnRf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opDr2 = this.opDr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opDr4 = this.opDr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etnDr2 = this.etnDr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocRf4 = this.ocRf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etnDr4 = this.etnDr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRf2 = this.mtRf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etnRf4 = this.etnRf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otDr2 = this.otDr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opRf2 = this.opRf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opRf4 = this.opRf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otRf2 = this.otRf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otRf4 = this.otRf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRf4 = this.mtRf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
