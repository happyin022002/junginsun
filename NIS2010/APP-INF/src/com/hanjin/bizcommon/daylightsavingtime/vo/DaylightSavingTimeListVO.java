/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DaylightSavingTimeListVO.java
*@FileTitle : DaylightSavingTimeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.24
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2012.02.24 이준범 
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.daylightsavingtime.vo;

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
 * @author 이준범
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class DaylightSavingTimeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DaylightSavingTimeListVO> models = new ArrayList<DaylightSavingTimeListVO>();
	
	/* Column Info */
	private String dstCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String endDstDt = null;
	/* Column Info */
	private String dstId = null;
	/* Column Info */
	private String mdmYn = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String dstMnts = null;
	/* Column Info */
	private String dstYr = null;
	/* Column Info */
	private String stDstDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DaylightSavingTimeListVO() {}

	public DaylightSavingTimeListVO(String ibflag, String pagerows, String dstId, String dstCntCd, String dstYr, String dstMnts, String stDstDt, String endDstDt, String mdmYn, String deltFlg) {
		this.dstCntCd = dstCntCd;
		this.ibflag = ibflag;
		this.endDstDt = endDstDt;
		this.dstId = dstId;
		this.mdmYn = mdmYn;
		this.deltFlg = deltFlg;
		this.dstMnts = dstMnts;
		this.dstYr = dstYr;
		this.stDstDt = stDstDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dst_cnt_cd", getDstCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("end_dst_dt", getEndDstDt());
		this.hashColumns.put("dst_id", getDstId());
		this.hashColumns.put("mdm_yn", getMdmYn());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("dst_mnts", getDstMnts());
		this.hashColumns.put("dst_yr", getDstYr());
		this.hashColumns.put("st_dst_dt", getStDstDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dst_cnt_cd", "dstCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("end_dst_dt", "endDstDt");
		this.hashFields.put("dst_id", "dstId");
		this.hashFields.put("mdm_yn", "mdmYn");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("dst_mnts", "dstMnts");
		this.hashFields.put("dst_yr", "dstYr");
		this.hashFields.put("st_dst_dt", "stDstDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dstCntCd
	 */
	public String getDstCntCd() {
		return this.dstCntCd;
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
	 * @return endDstDt
	 */
	public String getEndDstDt() {
		return this.endDstDt;
	}
	
	/**
	 * Column Info
	 * @return dstId
	 */
	public String getDstId() {
		return this.dstId;
	}
	
	/**
	 * Column Info
	 * @return mdmYn
	 */
	public String getMdmYn() {
		return this.mdmYn;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return dstMnts
	 */
	public String getDstMnts() {
		return this.dstMnts;
	}
	
	/**
	 * Column Info
	 * @return dstYr
	 */
	public String getDstYr() {
		return this.dstYr;
	}
	
	/**
	 * Column Info
	 * @return stDstDt
	 */
	public String getStDstDt() {
		return this.stDstDt;
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
	 * @param dstCntCd
	 */
	public void setDstCntCd(String dstCntCd) {
		this.dstCntCd = dstCntCd;
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
	 * @param endDstDt
	 */
	public void setEndDstDt(String endDstDt) {
		this.endDstDt = endDstDt;
	}
	
	/**
	 * Column Info
	 * @param dstId
	 */
	public void setDstId(String dstId) {
		this.dstId = dstId;
	}
	
	/**
	 * Column Info
	 * @param mdmYn
	 */
	public void setMdmYn(String mdmYn) {
		this.mdmYn = mdmYn;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param dstMnts
	 */
	public void setDstMnts(String dstMnts) {
		this.dstMnts = dstMnts;
	}
	
	/**
	 * Column Info
	 * @param dstYr
	 */
	public void setDstYr(String dstYr) {
		this.dstYr = dstYr;
	}
	
	/**
	 * Column Info
	 * @param stDstDt
	 */
	public void setStDstDt(String stDstDt) {
		this.stDstDt = stDstDt;
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
		setDstCntCd(JSPUtil.getParameter(request, prefix + "dst_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEndDstDt(JSPUtil.getParameter(request, prefix + "end_dst_dt", ""));
		setDstId(JSPUtil.getParameter(request, prefix + "dst_id", ""));
		setMdmYn(JSPUtil.getParameter(request, prefix + "mdm_yn", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setDstMnts(JSPUtil.getParameter(request, prefix + "dst_mnts", ""));
		setDstYr(JSPUtil.getParameter(request, prefix + "dst_yr", ""));
		setStDstDt(JSPUtil.getParameter(request, prefix + "st_dst_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DaylightSavingTimeListVO[]
	 */
	public DaylightSavingTimeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DaylightSavingTimeListVO[]
	 */
	public DaylightSavingTimeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DaylightSavingTimeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dstCntCd = (JSPUtil.getParameter(request, prefix	+ "dst_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] endDstDt = (JSPUtil.getParameter(request, prefix	+ "end_dst_dt", length));
			String[] dstId = (JSPUtil.getParameter(request, prefix	+ "dst_id", length));
			String[] mdmYn = (JSPUtil.getParameter(request, prefix	+ "mdm_yn", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] dstMnts = (JSPUtil.getParameter(request, prefix	+ "dst_mnts", length));
			String[] dstYr = (JSPUtil.getParameter(request, prefix	+ "dst_yr", length));
			String[] stDstDt = (JSPUtil.getParameter(request, prefix	+ "st_dst_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DaylightSavingTimeListVO();
				if (dstCntCd[i] != null)
					model.setDstCntCd(dstCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (endDstDt[i] != null)
					model.setEndDstDt(endDstDt[i]);
				if (dstId[i] != null)
					model.setDstId(dstId[i]);
				if (mdmYn[i] != null)
					model.setMdmYn(mdmYn[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (dstMnts[i] != null)
					model.setDstMnts(dstMnts[i]);
				if (dstYr[i] != null)
					model.setDstYr(dstYr[i]);
				if (stDstDt[i] != null)
					model.setStDstDt(stDstDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDaylightSavingTimeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DaylightSavingTimeListVO[]
	 */
	public DaylightSavingTimeListVO[] getDaylightSavingTimeListVOs(){
		DaylightSavingTimeListVO[] vos = (DaylightSavingTimeListVO[])models.toArray(new DaylightSavingTimeListVO[models.size()]);
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
		this.dstCntCd = this.dstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDstDt = this.endDstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstId = this.dstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmYn = this.mdmYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstMnts = this.dstMnts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstYr = this.dstYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDstDt = this.stDstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
