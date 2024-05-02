/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MBSearchOptionCOABKGVO.java
*@FileTitle : MBSearchOptionCOABKGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.24
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.24 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MBSearchOptionCOABKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MBSearchOptionCOABKGVO> models = new ArrayList<MBSearchOptionCOABKGVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String froms = null;
	/* Column Info */
	private String workType = null;
	/* Column Info */
	private String tradeCd = null;
	/* Column Info */
	private String period = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpszList = null;
	/* Column Info */
	private String tos = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String weekList = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String soc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MBSearchOptionCOABKGVO() {}

	public MBSearchOptionCOABKGVO(String ibflag, String pagerows, String fromDt, String froms, String workType, String tradeCd, String period, String toDt, String tpszList, String tos, String tpsz, String usrId, String rdtype, String soc, String weekList) {
		this.fromDt = fromDt;
		this.froms = froms;
		this.workType = workType;
		this.tradeCd = tradeCd;
		this.period = period;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.tpszList = tpszList;
		this.tos = tos;
		this.tpsz = tpsz;
		this.usrId = usrId;
		this.weekList = weekList;
		this.rdtype = rdtype;
		this.soc = soc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("froms", getFroms());
		this.hashColumns.put("work_type", getWorkType());
		this.hashColumns.put("trade_cd", getTradeCd());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz_list", getTpszList());
		this.hashColumns.put("tos", getTos());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("week_list", getWeekList());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("soc", getSoc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("froms", "froms");
		this.hashFields.put("work_type", "workType");
		this.hashFields.put("trade_cd", "tradeCd");
		this.hashFields.put("period", "period");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz_list", "tpszList");
		this.hashFields.put("tos", "tos");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("week_list", "weekList");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("soc", "soc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return froms
	 */
	public String getFroms() {
		return this.froms;
	}
	
	/**
	 * Column Info
	 * @return workType
	 */
	public String getWorkType() {
		return this.workType;
	}
	
	/**
	 * Column Info
	 * @return tradeCd
	 */
	public String getTradeCd() {
		return this.tradeCd;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return tpszList
	 */
	public String getTpszList() {
		return this.tpszList;
	}
	
	/**
	 * Column Info
	 * @return tos
	 */
	public String getTos() {
		return this.tos;
	}
	
	/**
	 * Column Info
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return weekList
	 */
	public String getWeekList() {
		return this.weekList;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return soc
	 */
	public String getSoc() {
		return this.soc;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param froms
	 */
	public void setFroms(String froms) {
		this.froms = froms;
	}
	
	/**
	 * Column Info
	 * @param workType
	 */
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	/**
	 * Column Info
	 * @param tradeCd
	 */
	public void setTradeCd(String tradeCd) {
		this.tradeCd = tradeCd;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param tpszList
	 */
	public void setTpszList(String tpszList) {
		this.tpszList = tpszList;
	}
	
	/**
	 * Column Info
	 * @param tos
	 */
	public void setTos(String tos) {
		this.tos = tos;
	}
	
	/**
	 * Column Info
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param weekList
	 */
	public void setWeekList(String weekList) {
		this.weekList = weekList;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setFroms(JSPUtil.getParameter(request, prefix + "froms", ""));
		setWorkType(JSPUtil.getParameter(request, prefix + "work_type", ""));
		setTradeCd(JSPUtil.getParameter(request, prefix + "trade_cd", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTpszList(JSPUtil.getParameter(request, prefix + "tpsz_list", ""));
		setTos(JSPUtil.getParameter(request, prefix + "tos", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setWeekList(JSPUtil.getParameter(request, prefix + "week_list", ""));
		setRdtype(JSPUtil.getParameter(request, prefix + "rdtype", ""));
		setSoc(JSPUtil.getParameter(request, prefix + "soc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MBSearchOptionCOABKGVO[]
	 */
	public MBSearchOptionCOABKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MBSearchOptionCOABKGVO[]
	 */
	public MBSearchOptionCOABKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MBSearchOptionCOABKGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] froms = (JSPUtil.getParameter(request, prefix	+ "froms", length));
			String[] workType = (JSPUtil.getParameter(request, prefix	+ "work_type", length));
			String[] tradeCd = (JSPUtil.getParameter(request, prefix	+ "trade_cd", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpszList = (JSPUtil.getParameter(request, prefix	+ "tpsz_list", length));
			String[] tos = (JSPUtil.getParameter(request, prefix	+ "tos", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] weekList = (JSPUtil.getParameter(request, prefix	+ "week_list", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc", length));
			
			for (int i = 0; i < length; i++) {
				model = new MBSearchOptionCOABKGVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (froms[i] != null)
					model.setFroms(froms[i]);
				if (workType[i] != null)
					model.setWorkType(workType[i]);
				if (tradeCd[i] != null)
					model.setTradeCd(tradeCd[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpszList[i] != null)
					model.setTpszList(tpszList[i]);
				if (tos[i] != null)
					model.setTos(tos[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (weekList[i] != null)
					model.setWeekList(weekList[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMBSearchOptionCOABKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MBSearchOptionCOABKGVO[]
	 */
	public MBSearchOptionCOABKGVO[] getMBSearchOptionCOABKGVOs(){
		MBSearchOptionCOABKGVO[] vos = (MBSearchOptionCOABKGVO[])models.toArray(new MBSearchOptionCOABKGVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.froms = this.froms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workType = this.workType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeCd = this.tradeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszList = this.tpszList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tos = this.tos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weekList = this.weekList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
