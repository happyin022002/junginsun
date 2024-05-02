/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SegregationSimulationInputVO.java
*@FileTitle : SegregationSimulationInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.08.26 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SegregationSimulationInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SegregationSimulationInputVO> models = new ArrayList<SegregationSimulationInputVO>();
	
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String imdgSubsRskLblRmk = null;
	/* Column Info */
	private String imdgLmtQty = null;
	/* Column Info */
	private String lqChk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgExptQtyCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String selChk = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgTecNm = null;
	/* Column Info */
	private String eqChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SegregationSimulationInputVO() {}

	public SegregationSimulationInputVO(String ibflag, String pagerows, String selChk, String lqChk, String eqChk, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String imdgCompGrpCd, String imdgSubsRskLblRmk, String prpShpNm, String imdgTecNm, String imdgPckGrpCd, String imdgLmtQty, String imdgExptQtyCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
		this.imdgLmtQty = imdgLmtQty;
		this.lqChk = lqChk;
		this.pagerows = pagerows;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.ibflag = ibflag;
		this.imdgExptQtyCd = imdgExptQtyCd;
		this.prpShpNm = prpShpNm;
		this.selChk = selChk;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.imdgTecNm = imdgTecNm;
		this.eqChk = eqChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("imdg_subs_rsk_lbl_rmk", getImdgSubsRskLblRmk());
		this.hashColumns.put("imdg_lmt_qty", getImdgLmtQty());
		this.hashColumns.put("lq_chk", getLqChk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_expt_qty_cd", getImdgExptQtyCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("sel_chk", getSelChk());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_tec_nm", getImdgTecNm());
		this.hashColumns.put("eq_chk", getEqChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("imdg_subs_rsk_lbl_rmk", "imdgSubsRskLblRmk");
		this.hashFields.put("imdg_lmt_qty", "imdgLmtQty");
		this.hashFields.put("lq_chk", "lqChk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_expt_qty_cd", "imdgExptQtyCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("sel_chk", "selChk");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_tec_nm", "imdgTecNm");
		this.hashFields.put("eq_chk", "eqChk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblRmk
	 */
	public String getImdgSubsRskLblRmk() {
		return this.imdgSubsRskLblRmk;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQty
	 */
	public String getImdgLmtQty() {
		return this.imdgLmtQty;
	}
	
	/**
	 * Column Info
	 * @return lqChk
	 */
	public String getLqChk() {
		return this.lqChk;
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
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
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
	 * @return imdgExptQtyCd
	 */
	public String getImdgExptQtyCd() {
		return this.imdgExptQtyCd;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return selChk
	 */
	public String getSelChk() {
		return this.selChk;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return imdgTecNm
	 */
	public String getImdgTecNm() {
		return this.imdgTecNm;
	}
	
	/**
	 * Column Info
	 * @return eqChk
	 */
	public String getEqChk() {
		return this.eqChk;
	}
	

	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblRmk
	 */
	public void setImdgSubsRskLblRmk(String imdgSubsRskLblRmk) {
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQty
	 */
	public void setImdgLmtQty(String imdgLmtQty) {
		this.imdgLmtQty = imdgLmtQty;
	}
	
	/**
	 * Column Info
	 * @param lqChk
	 */
	public void setLqChk(String lqChk) {
		this.lqChk = lqChk;
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
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
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
	 * @param imdgExptQtyCd
	 */
	public void setImdgExptQtyCd(String imdgExptQtyCd) {
		this.imdgExptQtyCd = imdgExptQtyCd;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param selChk
	 */
	public void setSelChk(String selChk) {
		this.selChk = selChk;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param imdgTecNm
	 */
	public void setImdgTecNm(String imdgTecNm) {
		this.imdgTecNm = imdgTecNm;
	}
	
	/**
	 * Column Info
	 * @param eqChk
	 */
	public void setEqChk(String eqChk) {
		this.eqChk = eqChk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setImdgPckGrpCd(JSPUtil.getParameter(request, "imdg_pck_grp_cd", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setImdgSubsRskLblRmk(JSPUtil.getParameter(request, "imdg_subs_rsk_lbl_rmk", ""));
		setImdgLmtQty(JSPUtil.getParameter(request, "imdg_lmt_qty", ""));
		setLqChk(JSPUtil.getParameter(request, "lq_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, "imdg_comp_grp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setImdgExptQtyCd(JSPUtil.getParameter(request, "imdg_expt_qty_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setSelChk(JSPUtil.getParameter(request, "sel_chk", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setImdgTecNm(JSPUtil.getParameter(request, "imdg_tec_nm", ""));
		setEqChk(JSPUtil.getParameter(request, "eq_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SegregationSimulationInputVO[]
	 */
	public SegregationSimulationInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SegregationSimulationInputVO[]
	 */
	public SegregationSimulationInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SegregationSimulationInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] imdgSubsRskLblRmk = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_rmk", length));
			String[] imdgLmtQty = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty", length));
			String[] lqChk = (JSPUtil.getParameter(request, prefix	+ "lq_chk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgExptQtyCd = (JSPUtil.getParameter(request, prefix	+ "imdg_expt_qty_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] selChk = (JSPUtil.getParameter(request, prefix	+ "sel_chk", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgTecNm = (JSPUtil.getParameter(request, prefix	+ "imdg_tec_nm", length));
			String[] eqChk = (JSPUtil.getParameter(request, prefix	+ "eq_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SegregationSimulationInputVO();
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (imdgSubsRskLblRmk[i] != null)
					model.setImdgSubsRskLblRmk(imdgSubsRskLblRmk[i]);
				if (imdgLmtQty[i] != null)
					model.setImdgLmtQty(imdgLmtQty[i]);
				if (lqChk[i] != null)
					model.setLqChk(lqChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgExptQtyCd[i] != null)
					model.setImdgExptQtyCd(imdgExptQtyCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (selChk[i] != null)
					model.setSelChk(selChk[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgTecNm[i] != null)
					model.setImdgTecNm(imdgTecNm[i]);
				if (eqChk[i] != null)
					model.setEqChk(eqChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSegregationSimulationInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SegregationSimulationInputVO[]
	 */
	public SegregationSimulationInputVO[] getSegregationSimulationInputVOs(){
		SegregationSimulationInputVO[] vos = (SegregationSimulationInputVO[])models.toArray(new SegregationSimulationInputVO[models.size()]);
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
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblRmk = this.imdgSubsRskLblRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQty = this.imdgLmtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lqChk = this.lqChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgExptQtyCd = this.imdgExptQtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selChk = this.selChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgTecNm = this.imdgTecNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqChk = this.eqChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
