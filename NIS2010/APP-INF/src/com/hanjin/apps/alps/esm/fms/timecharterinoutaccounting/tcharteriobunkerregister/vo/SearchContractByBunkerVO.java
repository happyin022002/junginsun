/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContractByBunkerVO.java
*@FileTitle : SearchContractByBunkerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo;

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

public class SearchContractByBunkerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractByBunkerVO> models = new ArrayList<SearchContractByBunkerVO>();
	
	/* Column Info */
	private String actDoilBodQty = null;
	/* Column Info */
	private String doilBodOutPrc = null;
	/* Column Info */
	private String foilBodOutPrc = null;
	/* Column Info */
	private String borPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String bodPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String foilBorOutPrc = null;
	/* Column Info */
	private String doilBorOutPrc = null;
	/* Column Info */
	private String actDoilBorQty = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String actFoilBodQty = null;
	/* Column Info */
	private String actFoilBorQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContractByBunkerVO() {}

	public SearchContractByBunkerVO(String ibflag, String pagerows, String fletCtrtNo, String effDt, String expDt, String actFoilBodQty, String actDoilBodQty, String actFoilBorQty, String actDoilBorQty, String foilBodOutPrc, String doilBodOutPrc, String foilBorOutPrc, String doilBorOutPrc, String bodPortCd, String borPortCd) {
		this.actDoilBodQty = actDoilBodQty;
		this.doilBodOutPrc = doilBodOutPrc;
		this.foilBodOutPrc = foilBodOutPrc;
		this.borPortCd = borPortCd;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.bodPortCd = bodPortCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.foilBorOutPrc = foilBorOutPrc;
		this.doilBorOutPrc = doilBorOutPrc;
		this.actDoilBorQty = actDoilBorQty;
		this.expDt = expDt;
		this.actFoilBodQty = actFoilBodQty;
		this.actFoilBorQty = actFoilBorQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_doil_bod_qty", getActDoilBodQty());
		this.hashColumns.put("doil_bod_out_prc", getDoilBodOutPrc());
		this.hashColumns.put("foil_bod_out_prc", getFoilBodOutPrc());
		this.hashColumns.put("bor_port_cd", getBorPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("bod_port_cd", getBodPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("foil_bor_out_prc", getFoilBorOutPrc());
		this.hashColumns.put("doil_bor_out_prc", getDoilBorOutPrc());
		this.hashColumns.put("act_doil_bor_qty", getActDoilBorQty());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("act_foil_bod_qty", getActFoilBodQty());
		this.hashColumns.put("act_foil_bor_qty", getActFoilBorQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_doil_bod_qty", "actDoilBodQty");
		this.hashFields.put("doil_bod_out_prc", "doilBodOutPrc");
		this.hashFields.put("foil_bod_out_prc", "foilBodOutPrc");
		this.hashFields.put("bor_port_cd", "borPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("bod_port_cd", "bodPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("foil_bor_out_prc", "foilBorOutPrc");
		this.hashFields.put("doil_bor_out_prc", "doilBorOutPrc");
		this.hashFields.put("act_doil_bor_qty", "actDoilBorQty");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("act_foil_bod_qty", "actFoilBodQty");
		this.hashFields.put("act_foil_bor_qty", "actFoilBorQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actDoilBodQty
	 */
	public String getActDoilBodQty() {
		return this.actDoilBodQty;
	}
	
	/**
	 * Column Info
	 * @return doilBodOutPrc
	 */
	public String getDoilBodOutPrc() {
		return this.doilBodOutPrc;
	}
	
	/**
	 * Column Info
	 * @return foilBodOutPrc
	 */
	public String getFoilBodOutPrc() {
		return this.foilBodOutPrc;
	}
	
	/**
	 * Column Info
	 * @return borPortCd
	 */
	public String getBorPortCd() {
		return this.borPortCd;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return bodPortCd
	 */
	public String getBodPortCd() {
		return this.bodPortCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return foilBorOutPrc
	 */
	public String getFoilBorOutPrc() {
		return this.foilBorOutPrc;
	}
	
	/**
	 * Column Info
	 * @return doilBorOutPrc
	 */
	public String getDoilBorOutPrc() {
		return this.doilBorOutPrc;
	}
	
	/**
	 * Column Info
	 * @return actDoilBorQty
	 */
	public String getActDoilBorQty() {
		return this.actDoilBorQty;
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
	 * @return actFoilBodQty
	 */
	public String getActFoilBodQty() {
		return this.actFoilBodQty;
	}
	
	/**
	 * Column Info
	 * @return actFoilBorQty
	 */
	public String getActFoilBorQty() {
		return this.actFoilBorQty;
	}
	

	/**
	 * Column Info
	 * @param actDoilBodQty
	 */
	public void setActDoilBodQty(String actDoilBodQty) {
		this.actDoilBodQty = actDoilBodQty;
	}
	
	/**
	 * Column Info
	 * @param doilBodOutPrc
	 */
	public void setDoilBodOutPrc(String doilBodOutPrc) {
		this.doilBodOutPrc = doilBodOutPrc;
	}
	
	/**
	 * Column Info
	 * @param foilBodOutPrc
	 */
	public void setFoilBodOutPrc(String foilBodOutPrc) {
		this.foilBodOutPrc = foilBodOutPrc;
	}
	
	/**
	 * Column Info
	 * @param borPortCd
	 */
	public void setBorPortCd(String borPortCd) {
		this.borPortCd = borPortCd;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param bodPortCd
	 */
	public void setBodPortCd(String bodPortCd) {
		this.bodPortCd = bodPortCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param foilBorOutPrc
	 */
	public void setFoilBorOutPrc(String foilBorOutPrc) {
		this.foilBorOutPrc = foilBorOutPrc;
	}
	
	/**
	 * Column Info
	 * @param doilBorOutPrc
	 */
	public void setDoilBorOutPrc(String doilBorOutPrc) {
		this.doilBorOutPrc = doilBorOutPrc;
	}
	
	/**
	 * Column Info
	 * @param actDoilBorQty
	 */
	public void setActDoilBorQty(String actDoilBorQty) {
		this.actDoilBorQty = actDoilBorQty;
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
	 * @param actFoilBodQty
	 */
	public void setActFoilBodQty(String actFoilBodQty) {
		this.actFoilBodQty = actFoilBodQty;
	}
	
	/**
	 * Column Info
	 * @param actFoilBorQty
	 */
	public void setActFoilBorQty(String actFoilBorQty) {
		this.actFoilBorQty = actFoilBorQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActDoilBodQty(JSPUtil.getParameter(request, "act_doil_bod_qty", ""));
		setDoilBodOutPrc(JSPUtil.getParameter(request, "doil_bod_out_prc", ""));
		setFoilBodOutPrc(JSPUtil.getParameter(request, "foil_bod_out_prc", ""));
		setBorPortCd(JSPUtil.getParameter(request, "bor_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setBodPortCd(JSPUtil.getParameter(request, "bod_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setFoilBorOutPrc(JSPUtil.getParameter(request, "foil_bor_out_prc", ""));
		setDoilBorOutPrc(JSPUtil.getParameter(request, "doil_bor_out_prc", ""));
		setActDoilBorQty(JSPUtil.getParameter(request, "act_doil_bor_qty", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setActFoilBodQty(JSPUtil.getParameter(request, "act_foil_bod_qty", ""));
		setActFoilBorQty(JSPUtil.getParameter(request, "act_foil_bor_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContractByBunkerVO[]
	 */
	public SearchContractByBunkerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContractByBunkerVO[]
	 */
	public SearchContractByBunkerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractByBunkerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actDoilBodQty = (JSPUtil.getParameter(request, prefix	+ "act_doil_bod_qty", length));
			String[] doilBodOutPrc = (JSPUtil.getParameter(request, prefix	+ "doil_bod_out_prc", length));
			String[] foilBodOutPrc = (JSPUtil.getParameter(request, prefix	+ "foil_bod_out_prc", length));
			String[] borPortCd = (JSPUtil.getParameter(request, prefix	+ "bor_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] bodPortCd = (JSPUtil.getParameter(request, prefix	+ "bod_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] foilBorOutPrc = (JSPUtil.getParameter(request, prefix	+ "foil_bor_out_prc", length));
			String[] doilBorOutPrc = (JSPUtil.getParameter(request, prefix	+ "doil_bor_out_prc", length));
			String[] actDoilBorQty = (JSPUtil.getParameter(request, prefix	+ "act_doil_bor_qty", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] actFoilBodQty = (JSPUtil.getParameter(request, prefix	+ "act_foil_bod_qty", length));
			String[] actFoilBorQty = (JSPUtil.getParameter(request, prefix	+ "act_foil_bor_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractByBunkerVO();
				if (actDoilBodQty[i] != null)
					model.setActDoilBodQty(actDoilBodQty[i]);
				if (doilBodOutPrc[i] != null)
					model.setDoilBodOutPrc(doilBodOutPrc[i]);
				if (foilBodOutPrc[i] != null)
					model.setFoilBodOutPrc(foilBodOutPrc[i]);
				if (borPortCd[i] != null)
					model.setBorPortCd(borPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (bodPortCd[i] != null)
					model.setBodPortCd(bodPortCd[i]);
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
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContractByBunkerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContractByBunkerVO[]
	 */
	public SearchContractByBunkerVO[] getSearchContractByBunkerVOs(){
		SearchContractByBunkerVO[] vos = (SearchContractByBunkerVO[])models.toArray(new SearchContractByBunkerVO[models.size()]);
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
		this.actDoilBodQty = this.actDoilBodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilBodOutPrc = this.doilBodOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBodOutPrc = this.foilBodOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.borPortCd = this.borPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodPortCd = this.bodPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBorOutPrc = this.foilBorOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilBorOutPrc = this.doilBorOutPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDoilBorQty = this.actDoilBorQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilBodQty = this.actFoilBodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilBorQty = this.actFoilBorQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
