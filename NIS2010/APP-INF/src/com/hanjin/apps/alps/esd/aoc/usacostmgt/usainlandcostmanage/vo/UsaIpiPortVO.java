/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaIpiPortVO.java
*@FileTitle : UsaIpiPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo;

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

public class UsaIpiPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaIpiPortVO> models = new ArrayList<UsaIpiPortVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String svcModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcModNm = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String avgCnt = null;
	/* Column Info */
	private String ttlCnt = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String avgTrkCnt = null;
	/* Page Number */
	private String avgRailCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaIpiPortVO() {}

	public UsaIpiPortVO(String ibflag, String pagerows, String seq, String svcModCd, String svcModNm, String ttlCnt, String updDt, String updUsrNm, String avgCnt, String avgTrkCnt, String avgRailCnt) {
		this.updDt = updDt;
		this.svcModCd = svcModCd;
		this.ibflag = ibflag;
		this.svcModNm = svcModNm;
		this.seq = seq;
		this.avgCnt = avgCnt;
		this.ttlCnt = ttlCnt;
		this.updUsrNm = updUsrNm;
		this.pagerows = pagerows;
		this.avgTrkCnt = avgTrkCnt;
		this.avgRailCnt = avgRailCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("svc_mod_cd", getSvcModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_mod_nm", getSvcModNm());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("avg_cnt", getAvgCnt());
		this.hashColumns.put("ttl_cnt", getTtlCnt());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("avg_trk_cnt", getAvgTrkCnt());
		this.hashColumns.put("avg_rail_cnt", getAvgRailCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("svc_mod_cd", "svcModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_mod_nm", "svcModNm");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("avg_cnt", "avgCnt");
		this.hashFields.put("ttl_cnt", "ttlCnt");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("avg_trk_cnt", "avgTrkCnt");
		this.hashFields.put("avg_rail_cnt", "avgRailCnt");
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
	 * @return svcModCd
	 */
	public String getSvcModCd() {
		return this.svcModCd;
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
	 * @return svcModNm
	 */
	public String getSvcModNm() {
		return this.svcModNm;
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
	 * @return avgCnt
	 */
	public String getAvgCnt() {
		return this.avgCnt;
	}
	
	/**
	 * Column Info
	 * @return ttlCnt
	 */
	public String getTtlCnt() {
		return this.ttlCnt;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return avgTrkCnt
	 */
	public String getAvgTrkCnt() {
		return this.avgTrkCnt;
	}
	
	/**
	 * Page Number
	 * @return avgRailCnt
	 */
	public String getAvgRailCnt() {
		return this.avgRailCnt;
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
	 * @param svcModCd
	 */
	public void setSvcModCd(String svcModCd) {
		this.svcModCd = svcModCd;
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
	 * @param svcModNm
	 */
	public void setSvcModNm(String svcModNm) {
		this.svcModNm = svcModNm;
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
	 * @param avgCnt
	 */
	public void setAvgCnt(String avgCnt) {
		this.avgCnt = avgCnt;
	}
	
	/**
	 * Column Info
	 * @param ttlCnt
	 */
	public void setTtlCnt(String ttlCnt) {
		this.ttlCnt = ttlCnt;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param avgTrkCnt
	 */
	public void setAvgTrkCnt(String avgTrkCnt) {
		this.avgTrkCnt = avgTrkCnt;
	}
	
	/**
	 * Page Number
	 * @param avgRailCnt
	 */
	public void setAvgRailCnt(String avgRailCnt) {
		this.avgRailCnt = avgRailCnt;
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
		setSvcModCd(JSPUtil.getParameter(request, prefix + "svc_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSvcModNm(JSPUtil.getParameter(request, prefix + "svc_mod_nm", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setAvgCnt(JSPUtil.getParameter(request, prefix + "avg_cnt", ""));
		setTtlCnt(JSPUtil.getParameter(request, prefix + "ttl_cnt", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAvgTrkCnt(JSPUtil.getParameter(request, prefix + "avg_trk_cnt", ""));
		setAvgRailCnt(JSPUtil.getParameter(request, prefix + "avg_rail_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaIpiPortVO[]
	 */
	public UsaIpiPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaIpiPortVO[]
	 */
	public UsaIpiPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaIpiPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] svcModCd = (JSPUtil.getParameter(request, prefix	+ "svc_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcModNm = (JSPUtil.getParameter(request, prefix	+ "svc_mod_nm", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] avgCnt = (JSPUtil.getParameter(request, prefix	+ "avg_cnt", length));
			String[] ttlCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cnt", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] avgTrkCnt = (JSPUtil.getParameter(request, prefix	+ "avg_trk_cnt", length));
			String[] avgRailCnt = (JSPUtil.getParameter(request, prefix	+ "avg_rail_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaIpiPortVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (svcModCd[i] != null)
					model.setSvcModCd(svcModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcModNm[i] != null)
					model.setSvcModNm(svcModNm[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (avgCnt[i] != null)
					model.setAvgCnt(avgCnt[i]);
				if (ttlCnt[i] != null)
					model.setTtlCnt(ttlCnt[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (avgTrkCnt[i] != null)
					model.setAvgTrkCnt(avgTrkCnt[i]);
				if (avgRailCnt[i] != null)
					model.setAvgRailCnt(avgRailCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaIpiPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaIpiPortVO[]
	 */
	public UsaIpiPortVO[] getUsaIpiPortVOs(){
		UsaIpiPortVO[] vos = (UsaIpiPortVO[])models.toArray(new UsaIpiPortVO[models.size()]);
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
		this.svcModCd = this.svcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcModNm = this.svcModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgCnt = this.avgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCnt = this.ttlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTrkCnt = this.avgTrkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgRailCnt = this.avgRailCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
