/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ZeroBalanceDtlVO.java
*@FileTitle : ZeroBalanceDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ZeroBalanceDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ZeroBalanceDtlVO> models = new ArrayList<ZeroBalanceDtlVO>();
	
	/* Column Info */
	private String otsAdjSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chgTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String adjTpCd = null;
	/* Column Info */
	private String otsBalAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ZeroBalanceDtlVO() {}

	public ZeroBalanceDtlVO(String ibflag, String pagerows, String otsAdjSeq, String adjTpCd, String chgTpCd, String blCurrCd, String otsBalAmt, String creUsrId) {
		this.otsAdjSeq = otsAdjSeq;
		this.creUsrId = creUsrId;
		this.chgTpCd = chgTpCd;
		this.ibflag = ibflag;
		this.blCurrCd = blCurrCd;
		this.adjTpCd = adjTpCd;
		this.otsBalAmt = otsBalAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ots_adj_seq", getOtsAdjSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());
		this.hashColumns.put("ots_bal_amt", getOtsBalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ots_adj_seq", "otsAdjSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("ots_bal_amt", "otsBalAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otsAdjSeq
	 */
	public String getOtsAdjSeq() {
		return this.otsAdjSeq;
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
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
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
	 * @return blCurrCd
	 */
	public String getBlCurrCd() {
		return this.blCurrCd;
	}
	
	/**
	 * Column Info
	 * @return adjTpCd
	 */
	public String getAdjTpCd() {
		return this.adjTpCd;
	}
	
	/**
	 * Column Info
	 * @return otsBalAmt
	 */
	public String getOtsBalAmt() {
		return this.otsBalAmt;
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
	 * @param otsAdjSeq
	 */
	public void setOtsAdjSeq(String otsAdjSeq) {
		this.otsAdjSeq = otsAdjSeq;
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
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
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
	 * @param blCurrCd
	 */
	public void setBlCurrCd(String blCurrCd) {
		this.blCurrCd = blCurrCd;
	}
	
	/**
	 * Column Info
	 * @param adjTpCd
	 */
	public void setAdjTpCd(String adjTpCd) {
		this.adjTpCd = adjTpCd;
	}
	
	/**
	 * Column Info
	 * @param otsBalAmt
	 */
	public void setOtsBalAmt(String otsBalAmt) {
		this.otsBalAmt = otsBalAmt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOtsAdjSeq(JSPUtil.getParameter(request, prefix + "ots_adj_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setAdjTpCd(JSPUtil.getParameter(request, prefix + "adj_tp_cd", ""));
		setOtsBalAmt(JSPUtil.getParameter(request, prefix + "ots_bal_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ZeroBalanceDtlVO[]
	 */
	public ZeroBalanceDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ZeroBalanceDtlVO[]
	 */
	public ZeroBalanceDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ZeroBalanceDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otsAdjSeq = (JSPUtil.getParameter(request, prefix	+ "ots_adj_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] adjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tp_cd", length));
			String[] otsBalAmt = (JSPUtil.getParameter(request, prefix	+ "ots_bal_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ZeroBalanceDtlVO();
				if (otsAdjSeq[i] != null)
					model.setOtsAdjSeq(otsAdjSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (adjTpCd[i] != null)
					model.setAdjTpCd(adjTpCd[i]);
				if (otsBalAmt[i] != null)
					model.setOtsBalAmt(otsBalAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getZeroBalanceDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ZeroBalanceDtlVO[]
	 */
	public ZeroBalanceDtlVO[] getZeroBalanceDtlVOs(){
		ZeroBalanceDtlVO[] vos = (ZeroBalanceDtlVO[])models.toArray(new ZeroBalanceDtlVO[models.size()]);
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
		this.otsAdjSeq = this.otsAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd = this.adjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalAmt = this.otsBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
