/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0135ConditionVO.java
*@FileTitle : EesEqr0135ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.14 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0135ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0135ConditionVO> models = new ArrayList<EesEqr0135ConditionVO>();
	
	/* Column Info */
	private String toTypeBy = null;
	/* Column Info */
	private String fmToAt = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String toType = null;
	/* Column Info */
	private String cntrTpsz = null;
	/* Column Info */
	private String atEccCd = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oddTpsz = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String atType = null;
	/* Column Info */
	private String fmToAll = null;
	/* Column Info */
	private String atTypeBy = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String fmType = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fmTypeBy = null;
	
	private String nextWeek	= null;
	private String fromEcc	= null;
	private String toEcc	= null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0135ConditionVO() {}

	public EesEqr0135ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statusType, String fmToAt, String fmType, String fmEccCd, String fmTypeBy, String toType, String toEccCd, String toTypeBy, String atType, String atEccCd, String atTypeBy, String cntrTpsz, String cntrTpszCd, String fmToAll, String oddTpsz, String item, String lane, String vvd) {
		this.toTypeBy = toTypeBy;
		this.fmToAt = fmToAt;
		this.toEccCd = toEccCd;
		this.statusType = statusType;
		this.toType = toType;
		this.cntrTpsz = cntrTpsz;
		this.atEccCd = atEccCd;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.oddTpsz = oddTpsz;
		this.yyyyww = yyyyww;
		this.atType = atType;
		this.fmToAll = fmToAll;
		this.atTypeBy = atTypeBy;
		this.ibflag = ibflag;
		this.fmEccCd = fmEccCd;
		this.fmType = fmType;
		this.item = item;
		this.cntrTpszCd = cntrTpszCd;
		this.seq = seq;
		this.fmTypeBy = fmTypeBy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_type_by", getToTypeBy());
		this.hashColumns.put("fm_to_at", getFmToAt());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("to_type", getToType());
		this.hashColumns.put("cntr_tpsz", getCntrTpsz());
		this.hashColumns.put("at_ecc_cd", getAtEccCd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("odd_tpsz", getOddTpsz());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("at_type", getAtType());
		this.hashColumns.put("fm_to_all", getFmToAll());
		this.hashColumns.put("at_type_by", getAtTypeBy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("fm_type", getFmType());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("fm_type_by", getFmTypeBy());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_type_by", "toTypeBy");
		this.hashFields.put("fm_to_at", "fmToAt");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("to_type", "toType");
		this.hashFields.put("cntr_tpsz", "cntrTpsz");
		this.hashFields.put("at_ecc_cd", "atEccCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("odd_tpsz", "oddTpsz");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("at_type", "atType");
		this.hashFields.put("fm_to_all", "fmToAll");
		this.hashFields.put("at_type_by", "atTypeBy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("fm_type", "fmType");
		this.hashFields.put("item", "item");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("fm_type_by", "fmTypeBy");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toTypeBy
	 */
	public String getToTypeBy() {
		return this.toTypeBy;
	}
	
	/**
	 * Column Info
	 * @return fmToAt
	 */
	public String getFmToAt() {
		return this.fmToAt;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return toType
	 */
	public String getToType() {
		return this.toType;
	}
	
	/**
	 * Column Info
	 * @return cntrTpsz
	 */
	public String getCntrTpsz() {
		return this.cntrTpsz;
	}
	
	/**
	 * Column Info
	 * @return atEccCd
	 */
	public String getAtEccCd() {
		return this.atEccCd;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return oddTpsz
	 */
	public String getOddTpsz() {
		return this.oddTpsz;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return atType
	 */
	public String getAtType() {
		return this.atType;
	}
	
	/**
	 * Column Info
	 * @return fmToAll
	 */
	public String getFmToAll() {
		return this.fmToAll;
	}
	
	/**
	 * Column Info
	 * @return atTypeBy
	 */
	public String getAtTypeBy() {
		return this.atTypeBy;
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
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	
	/**
	 * Column Info
	 * @return fmType
	 */
	public String getFmType() {
		return this.fmType;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return fmTypeBy
	 */
	public String getFmTypeBy() {
		return this.fmTypeBy;
	}
	

	/**
	 * Column Info
	 * @param toTypeBy
	 */
	public void setToTypeBy(String toTypeBy) {
		this.toTypeBy = toTypeBy;
	}
	
	/**
	 * Column Info
	 * @param fmToAt
	 */
	public void setFmToAt(String fmToAt) {
		this.fmToAt = fmToAt;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param toType
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}
	
	/**
	 * Column Info
	 * @param cntrTpsz
	 */
	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
	}
	
	/**
	 * Column Info
	 * @param atEccCd
	 */
	public void setAtEccCd(String atEccCd) {
		this.atEccCd = atEccCd;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param oddTpsz
	 */
	public void setOddTpsz(String oddTpsz) {
		this.oddTpsz = oddTpsz;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param atType
	 */
	public void setAtType(String atType) {
		this.atType = atType;
	}
	
	/**
	 * Column Info
	 * @param fmToAll
	 */
	public void setFmToAll(String fmToAll) {
		this.fmToAll = fmToAll;
	}
	
	/**
	 * Column Info
	 * @param atTypeBy
	 */
	public void setAtTypeBy(String atTypeBy) {
		this.atTypeBy = atTypeBy;
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
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Column Info
	 * @param fmType
	 */
	public void setFmType(String fmType) {
		this.fmType = fmType;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param fmTypeBy
	 */
	public void setFmTypeBy(String fmTypeBy) {
		this.fmTypeBy = fmTypeBy;
	}
	
	public String getNextWeek() {
		return nextWeek;
	}

	public void setNextWeek(String nextWeek) {
		this.nextWeek = nextWeek;
	}

	public String getFromEcc() {
		return fromEcc;
	}

	public void setFromEcc(String fromEcc) {
		this.fromEcc = fromEcc;
	}

	public String getToEcc() {
		return toEcc;
	}

	public void setToEcc(String toEcc) {
		this.toEcc = toEcc;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
		setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
		setStatusType(JSPUtil.getParameter(request, "status_type".trim(), ""));

		// FM/TO, At
		setFmToAt(JSPUtil.getParameter(request, "fmToAt".trim(), ""));

		// FM/TO
		setFmType(JSPUtil.getParameter(request, "fmType".trim(), ""));
		setFmEccCd(JSPUtil.getParameter(request, "fmEccCd".trim(), ""));
		setFmTypeBy(JSPUtil.getParameter(request, "fmTypeBy".trim(), ""));  	

		setToType(JSPUtil.getParameter(request, "toType".trim(), ""));
		setToEccCd(JSPUtil.getParameter(request, "toEccCd".trim(), ""));
		setToTypeBy(JSPUtil.getParameter(request, "toTypeBy".trim(), ""));   

		// At
		setAtType(JSPUtil.getParameter(request, "atType".trim(), ""));
		setAtEccCd(JSPUtil.getParameter(request, "atEccCd".trim(), ""));
		setAtTypeBy(JSPUtil.getParameter(request, "atTypeBy".trim(), ""));

		// TP/SZ
		setCntrTpsz(JSPUtil.getParameter(request, "cntrTpsz".trim(), ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));

		// FM/TO/ALL
		setFmToAll(JSPUtil.getParameter(request, "fmtoall".trim(),""));    	
		setOddTpsz(JSPUtil.getParameter(request,"oddtpsz".trim(),""));
		setItem(JSPUtil.getParameter(request, "item".trim(),""));
		setLane(JSPUtil.getParameter(request, "lane".trim() ,""));
		setVvd(JSPUtil.getParameter(request,"vvd".trim() , ""));

		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0135ConditionVO[]
	 */
	public EesEqr0135ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0135ConditionVO[]
	 */
	public EesEqr0135ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0135ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toTypeBy = (JSPUtil.getParameter(request, prefix	+ "to_type_by", length));
			String[] fmToAt = (JSPUtil.getParameter(request, prefix	+ "fm_to_at", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] toType = (JSPUtil.getParameter(request, prefix	+ "to_type", length));
			String[] cntrTpsz = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz", length));
			String[] atEccCd = (JSPUtil.getParameter(request, prefix	+ "at_ecc_cd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oddTpsz = (JSPUtil.getParameter(request, prefix	+ "odd_tpsz", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] atType = (JSPUtil.getParameter(request, prefix	+ "at_type", length));
			String[] fmToAll = (JSPUtil.getParameter(request, prefix	+ "fm_to_all", length));
			String[] atTypeBy = (JSPUtil.getParameter(request, prefix	+ "at_type_by", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] fmType = (JSPUtil.getParameter(request, prefix	+ "fm_type", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fmTypeBy = (JSPUtil.getParameter(request, prefix	+ "fm_type_by", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0135ConditionVO();
				if (toTypeBy[i] != null)
					model.setToTypeBy(toTypeBy[i]);
				if (fmToAt[i] != null)
					model.setFmToAt(fmToAt[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (toType[i] != null)
					model.setToType(toType[i]);
				if (cntrTpsz[i] != null)
					model.setCntrTpsz(cntrTpsz[i]);
				if (atEccCd[i] != null)
					model.setAtEccCd(atEccCd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oddTpsz[i] != null)
					model.setOddTpsz(oddTpsz[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (atType[i] != null)
					model.setAtType(atType[i]);
				if (fmToAll[i] != null)
					model.setFmToAll(fmToAll[i]);
				if (atTypeBy[i] != null)
					model.setAtTypeBy(atTypeBy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (fmType[i] != null)
					model.setFmType(fmType[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fmTypeBy[i] != null)
					model.setFmTypeBy(fmTypeBy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0135ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0135ConditionVO[]
	 */
	public EesEqr0135ConditionVO[] getEesEqr0135ConditionVOs(){
		EesEqr0135ConditionVO[] vos = (EesEqr0135ConditionVO[])models.toArray(new EesEqr0135ConditionVO[models.size()]);
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
		this.toTypeBy = this.toTypeBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmToAt = this.fmToAt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toType = this.toType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpsz = this.cntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atEccCd = this.atEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oddTpsz = this.oddTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atType = this.atType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmToAll = this.fmToAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atTypeBy = this.atTypeBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmType = this.fmType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTypeBy = this.fmTypeBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
