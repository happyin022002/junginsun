/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesActCostDtlVO.java
*@FileTitle : TesActCostDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class TesActCostDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesActCostDtlVO> models = new ArrayList<TesActCostDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmlActCostSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String tmlAwkCgoTrfTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ioGaCd = null;
	/* Column Info */
	private String tmlAwkTsCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesActCostDtlVO() {}

	public TesActCostDtlVO(String ibflag, String pagerows, String tmlActCostSeq, String ydCd, String tmlAwkCgoTrfTpCd, String ioBndCd, String ioGaCd, String tmlAwkTsCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.tmlActCostSeq = tmlActCostSeq;
		this.ydCd = ydCd;
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
		this.creDt = creDt;
		this.ioGaCd = ioGaCd;
		this.tmlAwkTsCd = tmlAwkTsCd;
		this.ioBndCd = ioBndCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tml_act_cost_seq", getTmlActCostSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tml_awk_cgo_trf_tp_cd", getTmlAwkCgoTrfTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("io_ga_cd", getIoGaCd());
		this.hashColumns.put("tml_awk_ts_cd", getTmlAwkTsCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tml_act_cost_seq", "tmlActCostSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tml_awk_cgo_trf_tp_cd", "tmlAwkCgoTrfTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("io_ga_cd", "ioGaCd");
		this.hashFields.put("tml_awk_ts_cd", "tmlAwkTsCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return tmlActCostSeq
	 */
	public String getTmlActCostSeq() {
		return this.tmlActCostSeq;
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
	 * @return tmlAwkCgoTrfTpCd
	 */
	public String getTmlAwkCgoTrfTpCd() {
		return this.tmlAwkCgoTrfTpCd;
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
	 * @return ioGaCd
	 */
	public String getIoGaCd() {
		return this.ioGaCd;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkTsCd
	 */
	public String getTmlAwkTsCd() {
		return this.tmlAwkTsCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param tmlActCostSeq
	 */
	public void setTmlActCostSeq(String tmlActCostSeq) {
		this.tmlActCostSeq = tmlActCostSeq;
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
	 * @param tmlAwkCgoTrfTpCd
	 */
	public void setTmlAwkCgoTrfTpCd(String tmlAwkCgoTrfTpCd) {
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
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
	 * @param ioGaCd
	 */
	public void setIoGaCd(String ioGaCd) {
		this.ioGaCd = ioGaCd;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkTsCd
	 */
	public void setTmlAwkTsCd(String tmlAwkTsCd) {
		this.tmlAwkTsCd = tmlAwkTsCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTmlActCostSeq(JSPUtil.getParameter(request, prefix + "tml_act_cost_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTmlAwkCgoTrfTpCd(JSPUtil.getParameter(request, prefix + "tml_awk_cgo_trf_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setIoGaCd(JSPUtil.getParameter(request, prefix + "io_ga_cd", ""));
		setTmlAwkTsCd(JSPUtil.getParameter(request, prefix + "tml_awk_ts_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesActCostDtlVO[]
	 */
	public TesActCostDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesActCostDtlVO[]
	 */
	public TesActCostDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesActCostDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmlActCostSeq = (JSPUtil.getParameter(request, prefix	+ "tml_act_cost_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] tmlAwkCgoTrfTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_cgo_trf_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ioGaCd = (JSPUtil.getParameter(request, prefix	+ "io_ga_cd", length));
			String[] tmlAwkTsCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_ts_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesActCostDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmlActCostSeq[i] != null)
					model.setTmlActCostSeq(tmlActCostSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (tmlAwkCgoTrfTpCd[i] != null)
					model.setTmlAwkCgoTrfTpCd(tmlAwkCgoTrfTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ioGaCd[i] != null)
					model.setIoGaCd(ioGaCd[i]);
				if (tmlAwkTsCd[i] != null)
					model.setTmlAwkTsCd(tmlAwkTsCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesActCostDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesActCostDtlVO[]
	 */
	public TesActCostDtlVO[] getTesActCostDtlVOs(){
		TesActCostDtlVO[] vos = (TesActCostDtlVO[])models.toArray(new TesActCostDtlVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlActCostSeq = this.tmlActCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkCgoTrfTpCd = this.tmlAwkCgoTrfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaCd = this.ioGaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkTsCd = this.tmlAwkTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
