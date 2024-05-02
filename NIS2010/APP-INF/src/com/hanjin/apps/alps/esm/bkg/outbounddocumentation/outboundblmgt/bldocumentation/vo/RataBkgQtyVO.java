/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RataBkgQtyVO.java
*@FileTitle : RataBkgQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class RataBkgQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RataBkgQtyVO> models = new ArrayList<RataBkgQtyVO>();
	
	/* Column Info */
	private String dryCgoFlg = null;
	/* Column Info */
	private String deTermD = null;
	/* Column Info */
	private String rcvTermS = null;
	/* Column Info */
	private String rcvTermT = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String rcvTermY = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deTermT = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermS = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String category = null;
	/* Column Info */
	private String deTermO = null;
	/* Column Info */
	private String rcvTermD = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String deTermY = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String rcvTermI = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RataBkgQtyVO() {}

	public RataBkgQtyVO(String ibflag, String pagerows, String cntrTpszCd, String category, String dryCgoFlg, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String hngrFlg, String socFlg, String rcvTermY, String rcvTermD, String rcvTermS, String rcvTermT, String rcvTermI, String deTermY, String deTermD, String deTermS, String deTermT, String deTermO, String opCntrQty) {
		this.dryCgoFlg = dryCgoFlg;
		this.deTermD = deTermD;
		this.rcvTermS = rcvTermS;
		this.rcvTermT = rcvTermT;
		this.awkCgoFlg = awkCgoFlg;
		this.rcvTermY = rcvTermY;
		this.pagerows = pagerows;
		this.deTermT = deTermT;
		this.socFlg = socFlg;
		this.deTermS = deTermS;
		this.ibflag = ibflag;
		this.category = category;
		this.deTermO = deTermO;
		this.rcvTermD = rcvTermD;
		this.bbCgoFlg = bbCgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.opCntrQty = opCntrQty;
		this.hngrFlg = hngrFlg;
		this.deTermY = deTermY;
		this.rcFlg = rcFlg;
		this.rcvTermI = rcvTermI;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("de_term_d", getDeTermD());
		this.hashColumns.put("rcv_term_s", getRcvTermS());
		this.hashColumns.put("rcv_term_t", getRcvTermT());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("rcv_term_y", getRcvTermY());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("de_term_t", getDeTermT());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_s", getDeTermS());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("category", getCategory());
		this.hashColumns.put("de_term_o", getDeTermO());
		this.hashColumns.put("rcv_term_d", getRcvTermD());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("de_term_y", getDeTermY());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("rcv_term_i", getRcvTermI());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("de_term_d", "deTermD");
		this.hashFields.put("rcv_term_s", "rcvTermS");
		this.hashFields.put("rcv_term_t", "rcvTermT");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("rcv_term_y", "rcvTermY");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("de_term_t", "deTermT");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_s", "deTermS");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("category", "category");
		this.hashFields.put("de_term_o", "deTermO");
		this.hashFields.put("rcv_term_d", "rcvTermD");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("de_term_y", "deTermY");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("rcv_term_i", "rcvTermI");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dryCgoFlg
	 */
	public String getDryCgoFlg() {
		return this.dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermD
	 */
	public String getDeTermD() {
		return this.deTermD;
	}
	
	/**
	 * Column Info
	 * @return rcvTermS
	 */
	public String getRcvTermS() {
		return this.rcvTermS;
	}
	
	/**
	 * Column Info
	 * @return rcvTermT
	 */
	public String getRcvTermT() {
		return this.rcvTermT;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvTermY
	 */
	public String getRcvTermY() {
		return this.rcvTermY;
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
	 * @return deTermT
	 */
	public String getDeTermT() {
		return this.deTermT;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermS
	 */
	public String getDeTermS() {
		return this.deTermS;
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
	 * @return category
	 */
	public String getCategory() {
		return this.category;
	}
	
	/**
	 * Column Info
	 * @return deTermO
	 */
	public String getDeTermO() {
		return this.deTermO;
	}
	
	/**
	 * Column Info
	 * @return rcvTermD
	 */
	public String getRcvTermD() {
		return this.rcvTermD;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermY
	 */
	public String getDeTermY() {
		return this.deTermY;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvTermI
	 */
	public String getRcvTermI() {
		return this.rcvTermI;
	}
	

	/**
	 * Column Info
	 * @param dryCgoFlg
	 */
	public void setDryCgoFlg(String dryCgoFlg) {
		this.dryCgoFlg = dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermD
	 */
	public void setDeTermD(String deTermD) {
		this.deTermD = deTermD;
	}
	
	/**
	 * Column Info
	 * @param rcvTermS
	 */
	public void setRcvTermS(String rcvTermS) {
		this.rcvTermS = rcvTermS;
	}
	
	/**
	 * Column Info
	 * @param rcvTermT
	 */
	public void setRcvTermT(String rcvTermT) {
		this.rcvTermT = rcvTermT;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvTermY
	 */
	public void setRcvTermY(String rcvTermY) {
		this.rcvTermY = rcvTermY;
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
	 * @param deTermT
	 */
	public void setDeTermT(String deTermT) {
		this.deTermT = deTermT;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermS
	 */
	public void setDeTermS(String deTermS) {
		this.deTermS = deTermS;
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
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Column Info
	 * @param deTermO
	 */
	public void setDeTermO(String deTermO) {
		this.deTermO = deTermO;
	}
	
	/**
	 * Column Info
	 * @param rcvTermD
	 */
	public void setRcvTermD(String rcvTermD) {
		this.rcvTermD = rcvTermD;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermY
	 */
	public void setDeTermY(String deTermY) {
		this.deTermY = deTermY;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvTermI
	 */
	public void setRcvTermI(String rcvTermI) {
		this.rcvTermI = rcvTermI;
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
		setDryCgoFlg(JSPUtil.getParameter(request, prefix + "dry_cgo_flg", ""));
		setDeTermD(JSPUtil.getParameter(request, prefix + "de_term_d", ""));
		setRcvTermS(JSPUtil.getParameter(request, prefix + "rcv_term_s", ""));
		setRcvTermT(JSPUtil.getParameter(request, prefix + "rcv_term_t", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setRcvTermY(JSPUtil.getParameter(request, prefix + "rcv_term_y", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDeTermT(JSPUtil.getParameter(request, prefix + "de_term_t", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setDeTermS(JSPUtil.getParameter(request, prefix + "de_term_s", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCategory(JSPUtil.getParameter(request, prefix + "category", ""));
		setDeTermO(JSPUtil.getParameter(request, prefix + "de_term_o", ""));
		setRcvTermD(JSPUtil.getParameter(request, prefix + "rcv_term_d", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setDeTermY(JSPUtil.getParameter(request, prefix + "de_term_y", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setRcvTermI(JSPUtil.getParameter(request, prefix + "rcv_term_i", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RataBkgQtyVO[]
	 */
	public RataBkgQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RataBkgQtyVO[]
	 */
	public RataBkgQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RataBkgQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] deTermD = (JSPUtil.getParameter(request, prefix	+ "de_term_d", length));
			String[] rcvTermS = (JSPUtil.getParameter(request, prefix	+ "rcv_term_s", length));
			String[] rcvTermT = (JSPUtil.getParameter(request, prefix	+ "rcv_term_t", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] rcvTermY = (JSPUtil.getParameter(request, prefix	+ "rcv_term_y", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deTermT = (JSPUtil.getParameter(request, prefix	+ "de_term_t", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermS = (JSPUtil.getParameter(request, prefix	+ "de_term_s", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] category = (JSPUtil.getParameter(request, prefix	+ "category", length));
			String[] deTermO = (JSPUtil.getParameter(request, prefix	+ "de_term_o", length));
			String[] rcvTermD = (JSPUtil.getParameter(request, prefix	+ "rcv_term_d", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] deTermY = (JSPUtil.getParameter(request, prefix	+ "de_term_y", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] rcvTermI = (JSPUtil.getParameter(request, prefix	+ "rcv_term_i", length));
			
			for (int i = 0; i < length; i++) {
				model = new RataBkgQtyVO();
				if (dryCgoFlg[i] != null)
					model.setDryCgoFlg(dryCgoFlg[i]);
				if (deTermD[i] != null)
					model.setDeTermD(deTermD[i]);
				if (rcvTermS[i] != null)
					model.setRcvTermS(rcvTermS[i]);
				if (rcvTermT[i] != null)
					model.setRcvTermT(rcvTermT[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (rcvTermY[i] != null)
					model.setRcvTermY(rcvTermY[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deTermT[i] != null)
					model.setDeTermT(deTermT[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermS[i] != null)
					model.setDeTermS(deTermS[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (category[i] != null)
					model.setCategory(category[i]);
				if (deTermO[i] != null)
					model.setDeTermO(deTermO[i]);
				if (rcvTermD[i] != null)
					model.setRcvTermD(rcvTermD[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (deTermY[i] != null)
					model.setDeTermY(deTermY[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (rcvTermI[i] != null)
					model.setRcvTermI(rcvTermI[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRataBkgQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RataBkgQtyVO[]
	 */
	public RataBkgQtyVO[] getRataBkgQtyVOs(){
		RataBkgQtyVO[] vos = (RataBkgQtyVO[])models.toArray(new RataBkgQtyVO[models.size()]);
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
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermD = this.deTermD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermS = this.rcvTermS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermT = this.rcvTermT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermY = this.rcvTermY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermT = this.deTermT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermS = this.deTermS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.category = this.category .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermO = this.deTermO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermD = this.rcvTermD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermY = this.deTermY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermI = this.rcvTermI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
