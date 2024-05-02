/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CBFWgtGroupSummaryVO.java
*@FileTitle : CBFWgtGroupSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CBFWgtGroupSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CBFWgtGroupSummaryVO> models = new ArrayList<CBFWgtGroupSummaryVO>();
	
	/* Column Info */
	private String f40hQty = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String f45Qty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrWgtGrpCd = null;
	/* Column Info */
	private String f40Qty = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String f20Qty = null;
	/* Column Info */
	private String nm = null;
	/* Column Info */
	private String creUsrId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CBFWgtGroupSummaryVO() {}

	public CBFWgtGroupSummaryVO(String ibflag, String pagerows, String vvd, String ydCd, String crrCd, String podCd, String blckStwgCd, String seq, String cntrWgtGrpCd, String nm, String f20Qty, String f40Qty, String f40hQty, String f45Qty, String creUsrId) {
		this.f40hQty = f40hQty;
		this.blckStwgCd = blckStwgCd;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.f45Qty = f45Qty;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.cntrWgtGrpCd = cntrWgtGrpCd;
		this.f40Qty = f40Qty;
		this.seq = seq;
		this.f20Qty = f20Qty;
		this.nm = nm;
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_40h_qty", getF40hQty());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("f_45_qty", getF45Qty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_wgt_grp_cd", getCntrWgtGrpCd());
		this.hashColumns.put("f_40_qty", getF40Qty());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("f_20_qty", getF20Qty());
		this.hashColumns.put("nm", getNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_40h_qty", "f40hQty");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("f_45_qty", "f45Qty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_wgt_grp_cd", "cntrWgtGrpCd");
		this.hashFields.put("f_40_qty", "f40Qty");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("f_20_qty", "f20Qty");
		this.hashFields.put("nm", "nm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return f40hQty
	 */
	public String getF40hQty() {
		return this.f40hQty;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return f45Qty
	 */
	public String getF45Qty() {
		return this.f45Qty;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtGrpCd
	 */
	public String getCntrWgtGrpCd() {
		return this.cntrWgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return f40Qty
	 */
	public String getF40Qty() {
		return this.f40Qty;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return f20Qty
	 */
	public String getF20Qty() {
		return this.f20Qty;
	}
	
	/**
	 * Column Info
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param f40hQty
	 */
	public void setF40hQty(String f40hQty) {
		this.f40hQty = f40hQty;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param f45Qty
	 */
	public void setF45Qty(String f45Qty) {
		this.f45Qty = f45Qty;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtGrpCd
	 */
	public void setCntrWgtGrpCd(String cntrWgtGrpCd) {
		this.cntrWgtGrpCd = cntrWgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param f40Qty
	 */
	public void setF40Qty(String f40Qty) {
		this.f40Qty = f40Qty;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param f20Qty
	 */
	public void setF20Qty(String f20Qty) {
		this.f20Qty = f20Qty;
	}
	
	/**
	 * Column Info
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setF40hQty(JSPUtil.getParameter(request, prefix + "f_40h_qty", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setF45Qty(JSPUtil.getParameter(request, prefix + "f_45_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrWgtGrpCd(JSPUtil.getParameter(request, prefix + "cntr_wgt_grp_cd", ""));
		setF40Qty(JSPUtil.getParameter(request, prefix + "f_40_qty", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setF20Qty(JSPUtil.getParameter(request, prefix + "f_20_qty", ""));
		setNm(JSPUtil.getParameter(request, prefix + "nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CBFWgtGroupSummaryVO[]
	 */
	public CBFWgtGroupSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CBFWgtGroupSummaryVO[]
	 */
	public CBFWgtGroupSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CBFWgtGroupSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] f40hQty = (JSPUtil.getParameter(request, prefix	+ "f_40h_qty", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] f45Qty = (JSPUtil.getParameter(request, prefix	+ "f_45_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrWgtGrpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_grp_cd", length));
			String[] f40Qty = (JSPUtil.getParameter(request, prefix	+ "f_40_qty", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] f20Qty = (JSPUtil.getParameter(request, prefix	+ "f_20_qty", length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CBFWgtGroupSummaryVO();
				if (f40hQty[i] != null)
					model.setF40hQty(f40hQty[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (f45Qty[i] != null)
					model.setF45Qty(f45Qty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrWgtGrpCd[i] != null)
					model.setCntrWgtGrpCd(cntrWgtGrpCd[i]);
				if (f40Qty[i] != null)
					model.setF40Qty(f40Qty[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (f20Qty[i] != null)
					model.setF20Qty(f20Qty[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCBFWgtGroupSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CBFWgtGroupSummaryVO[]
	 */
	public CBFWgtGroupSummaryVO[] getCBFWgtGroupSummaryVOs(){
		CBFWgtGroupSummaryVO[] vos = (CBFWgtGroupSummaryVO[])models.toArray(new CBFWgtGroupSummaryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.f40hQty = this.f40hQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f45Qty = this.f45Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtGrpCd = this.cntrWgtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f40Qty = this.f40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f20Qty = this.f20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
