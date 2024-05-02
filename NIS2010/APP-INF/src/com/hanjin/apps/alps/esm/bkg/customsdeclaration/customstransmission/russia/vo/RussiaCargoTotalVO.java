/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RussiaCargoTotalVO.java
*@FileTitle : RussiaCargoTotalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

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

public class RussiaCargoTotalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiaCargoTotalVO> models = new ArrayList<RussiaCargoTotalVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalBlCnt = null;
	/* Column Info */
	private String hc4Cnt = null;
	/* Column Info */
	private String cntrEmptyCnt = null;
	/* Column Info */
	private String cntrFullCnt = null;
	/* Column Info */
	private String totalCntrCnt = null;
	/* Column Info */
	private String blEmptyCnt = null;
	/* Column Info */
	private String consoleCnt = null;
	/* Column Info */
	private String st20Cnt = null;
	/* Column Info */
	private String simpleCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiaCargoTotalVO() {}

	public RussiaCargoTotalVO(String ibflag, String pagerows, String simpleCnt, String consoleCnt, String blEmptyCnt, String totalBlCnt, String hc4Cnt, String st20Cnt, String cntrEmptyCnt,String cntrFullCnt, String totalCntrCnt) {
		this.ibflag = ibflag;
		this.totalBlCnt = totalBlCnt;
		this.hc4Cnt = hc4Cnt;
		this.cntrFullCnt = cntrFullCnt;
		this.cntrEmptyCnt = cntrEmptyCnt;
		this.totalCntrCnt = totalCntrCnt;
		this.blEmptyCnt = blEmptyCnt;
		this.consoleCnt = consoleCnt;
		this.st20Cnt = st20Cnt;
		this.simpleCnt = simpleCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_bl_cnt", getTotalBlCnt());
		this.hashColumns.put("hc4_cnt", getHc4Cnt());
		this.hashColumns.put("cntr_full_cnt", getCntrFullCnt());
		this.hashColumns.put("cntr_empty_cnt", getCntrEmptyCnt());		
		this.hashColumns.put("total_cntr_cnt", getTotalCntrCnt());
		this.hashColumns.put("bl_empty_cnt", getBlEmptyCnt());
		this.hashColumns.put("console_cnt", getConsoleCnt());
		this.hashColumns.put("st20_cnt", getSt20Cnt());
		this.hashColumns.put("simple_cnt", getSimpleCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_bl_cnt", "totalBlCnt");
		this.hashFields.put("hc4_cnt", "hc4Cnt");
		this.hashFields.put("cntr_full_cnt", "cntrFullCnt");
		this.hashFields.put("cntr_empty_cnt", "cntrEmptyCnt");
		this.hashFields.put("total_cntr_cnt", "totalCntrCnt");
		this.hashFields.put("bl_empty_cnt", "blEmptyCnt");
		this.hashFields.put("console_cnt", "consoleCnt");
		this.hashFields.put("st20_cnt", "st20Cnt");
		this.hashFields.put("simple_cnt", "simpleCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return totalBlCnt
	 */
	public String getTotalBlCnt() {
		return this.totalBlCnt;
	}
	
	/**
	 * Column Info
	 * @return hc4Cnt
	 */
	public String getHc4Cnt() {
		return this.hc4Cnt;
	}
	
	/**
	 * Column Info
	 * @return cntrFullCnt
	 */
	public String getCntrFullCnt() {
		return this.cntrFullCnt;
	}
	
	/**
	 * Column Info
	 * @return cntrEmptyCnt
	 */
	public String getCntrEmptyCnt() {
		return this.cntrEmptyCnt;
	}
	
	/**
	 * Column Info
	 * @return totalCntrCnt
	 */
	public String getTotalCntrCnt() {
		return this.totalCntrCnt;
	}
	
	/**
	 * Column Info
	 * @return blEmptyCnt
	 */
	public String getBlEmptyCnt() {
		return this.blEmptyCnt;
	}
	
	/**
	 * Column Info
	 * @return consoleCnt
	 */
	public String getConsoleCnt() {
		return this.consoleCnt;
	}
	
	/**
	 * Column Info
	 * @return st20Cnt
	 */
	public String getSt20Cnt() {
		return this.st20Cnt;
	}
	
	/**
	 * Column Info
	 * @return simpleCnt
	 */
	public String getSimpleCnt() {
		return this.simpleCnt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param totalBlCnt
	 */
	public void setTotalBlCnt(String totalBlCnt) {
		this.totalBlCnt = totalBlCnt;
	}
	
	/**
	 * Column Info
	 * @param hc4Cnt
	 */
	public void setHc4Cnt(String hc4Cnt) {
		this.hc4Cnt = hc4Cnt;
	}
	
	/**
	 * Column Info
	 * @param cntrEmptyCnt
	 */
	public void setCntrEmptyCnt(String cntrEmptyCnt) {
		this.cntrEmptyCnt = cntrEmptyCnt;
	}

	/**
	 * Column Info
	 * @param cntrFullCnt
	 */
	public void setCntrFullCnt(String cntrFullCnt) {
		this.cntrFullCnt = cntrFullCnt;
	}

	/**
	 * Column Info
	 * @param totalCntrCnt
	 */
	public void setTotalCntrCnt(String totalCntrCnt) {
		this.totalCntrCnt = totalCntrCnt;
	}
	
	/**
	 * Column Info
	 * @param blEmptyCnt
	 */
	public void setBlEmptyCnt(String blEmptyCnt) {
		this.blEmptyCnt = blEmptyCnt;
	}
	
	/**
	 * Column Info
	 * @param consoleCnt
	 */
	public void setConsoleCnt(String consoleCnt) {
		this.consoleCnt = consoleCnt;
	}
	
	/**
	 * Column Info
	 * @param st20Cnt
	 */
	public void setSt20Cnt(String st20Cnt) {
		this.st20Cnt = st20Cnt;
	}
	
	/**
	 * Column Info
	 * @param simpleCnt
	 */
	public void setSimpleCnt(String simpleCnt) {
		this.simpleCnt = simpleCnt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalBlCnt(JSPUtil.getParameter(request, prefix + "total_bl_cnt", ""));
		setHc4Cnt(JSPUtil.getParameter(request, prefix + "hc4_cnt", ""));
		setCntrFullCnt(JSPUtil.getParameter(request, prefix + "cntr_full_cnt", ""));
		setCntrEmptyCnt(JSPUtil.getParameter(request, prefix + "cntr_empty_cnt", ""));		
		setTotalCntrCnt(JSPUtil.getParameter(request, prefix + "total_cntr_cnt", ""));
		setBlEmptyCnt(JSPUtil.getParameter(request, prefix + "bl_empty_cnt", ""));
		setConsoleCnt(JSPUtil.getParameter(request, prefix + "console_cnt", ""));
		setSt20Cnt(JSPUtil.getParameter(request, prefix + "st20_cnt", ""));
		setSimpleCnt(JSPUtil.getParameter(request, prefix + "simple_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiaCargoTotalVO[]
	 */
	public RussiaCargoTotalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiaCargoTotalVO[]
	 */
	public RussiaCargoTotalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiaCargoTotalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalBlCnt = (JSPUtil.getParameter(request, prefix	+ "total_bl_cnt", length));
			String[] hc4Cnt = (JSPUtil.getParameter(request, prefix	+ "hc4_cnt", length));
			String[] cntrfullCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_full_cnt", length));
			String[] cntrEmptyCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_empty_cnt", length));			
			String[] totalCntrCnt = (JSPUtil.getParameter(request, prefix	+ "total_cntr_cnt", length));
			String[] blEmptyCnt = (JSPUtil.getParameter(request, prefix	+ "bl_empty_cnt", length));
			String[] consoleCnt = (JSPUtil.getParameter(request, prefix	+ "console_cnt", length));
			String[] st20Cnt = (JSPUtil.getParameter(request, prefix	+ "st20_cnt", length));
			String[] simpleCnt = (JSPUtil.getParameter(request, prefix	+ "simple_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiaCargoTotalVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalBlCnt[i] != null)
					model.setTotalBlCnt(totalBlCnt[i]);
				if (hc4Cnt[i] != null)
					model.setHc4Cnt(hc4Cnt[i]);
				if (cntrEmptyCnt[i] != null)
					model.setCntrEmptyCnt(cntrEmptyCnt[i]);
				if (cntrfullCnt[i] != null)
					model.setCntrFullCnt(cntrfullCnt[i]);				
				if (totalCntrCnt[i] != null)
					model.setTotalCntrCnt(totalCntrCnt[i]);
				if (blEmptyCnt[i] != null)
					model.setBlEmptyCnt(blEmptyCnt[i]);
				if (consoleCnt[i] != null)
					model.setConsoleCnt(consoleCnt[i]);
				if (st20Cnt[i] != null)
					model.setSt20Cnt(st20Cnt[i]);
				if (simpleCnt[i] != null)
					model.setSimpleCnt(simpleCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiaCargoTotalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiaCargoTotalVO[]
	 */
	public RussiaCargoTotalVO[] getRussiaCargoTotalVOs(){
		RussiaCargoTotalVO[] vos = (RussiaCargoTotalVO[])models.toArray(new RussiaCargoTotalVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBlCnt = this.totalBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc4Cnt = this.hc4Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEmptyCnt = this.cntrEmptyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullCnt = this.cntrFullCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.totalCntrCnt = this.totalCntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blEmptyCnt = this.blEmptyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consoleCnt = this.consoleCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st20Cnt = this.st20Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simpleCnt = this.simpleCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
