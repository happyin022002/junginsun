/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortSurplusAreaConditionVO.java
*@FileTitle : PortSurplusAreaConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo;

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

public class PortSurplusAreaConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortSurplusAreaConditionVO> models = new ArrayList<PortSurplusAreaConditionVO>();
	
	/* Column Info */
	private String chkId = null;
	/* Column Info */
	private String subtrade = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String chkIm = null;
	/* Column Info */
	private String currYrwk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String chkIs = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fmYrwk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toYrwk = null;
	/* Column Info */
	private String levelCd = null;
	/* Column Info */
	private String subconti = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortSurplusAreaConditionVO() {}

	public PortSurplusAreaConditionVO(String ibflag, String pagerows, String chkIs, String chkId, String fmYrwk, String subtrade, String toYrwk, String trade, String subconti, String chkIm, String currYrwk, String lane, String levelCd, String ofcCd) {
		this.chkId = chkId;
		this.subtrade = subtrade;
		this.trade = trade;
		this.chkIm = chkIm;
		this.currYrwk = currYrwk;
		this.pagerows = pagerows;
		this.lane = lane;
		this.chkIs = chkIs;
		this.ofcCd = ofcCd;
		this.fmYrwk = fmYrwk;
		this.ibflag = ibflag;
		this.toYrwk = toYrwk;
		this.levelCd = levelCd;
		this.subconti = subconti;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chk_id", getChkId());
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("chk_im", getChkIm());
		this.hashColumns.put("curr_yrwk", getCurrYrwk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("chk_is", getChkIs());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("fm_yrwk", getFmYrwk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_yrwk", getToYrwk());
		this.hashColumns.put("level_cd", getLevelCd());
		this.hashColumns.put("subconti", getSubconti());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chk_id", "chkId");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("chk_im", "chkIm");
		this.hashFields.put("curr_yrwk", "currYrwk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("chk_is", "chkIs");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("fm_yrwk", "fmYrwk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_yrwk", "toYrwk");
		this.hashFields.put("level_cd", "levelCd");
		this.hashFields.put("subconti", "subconti");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chkId
	 */
	public String getChkId() {
		return this.chkId;
	}
	
	/**
	 * Column Info
	 * @return subtrade
	 */
	public String getSubtrade() {
		return this.subtrade;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return chkIm
	 */
	public String getChkIm() {
		return this.chkIm;
	}
	
	/**
	 * Column Info
	 * @return currYrwk
	 */
	public String getCurrYrwk() {
		return this.currYrwk;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return chkIs
	 */
	public String getChkIs() {
		return this.chkIs;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return fmYrwk
	 */
	public String getFmYrwk() {
		return this.fmYrwk;
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
	 * @return toYrwk
	 */
	public String getToYrwk() {
		return this.toYrwk;
	}
	
	/**
	 * Column Info
	 * @return levelCd
	 */
	public String getLevelCd() {
		return this.levelCd;
	}
	
	/**
	 * Column Info
	 * @return subconti
	 */
	public String getSubconti() {
		return this.subconti;
	}
	

	/**
	 * Column Info
	 * @param chkId
	 */
	public void setChkId(String chkId) {
		this.chkId = chkId;
	}
	
	/**
	 * Column Info
	 * @param subtrade
	 */
	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param chkIm
	 */
	public void setChkIm(String chkIm) {
		this.chkIm = chkIm;
	}
	
	/**
	 * Column Info
	 * @param currYrwk
	 */
	public void setCurrYrwk(String currYrwk) {
		this.currYrwk = currYrwk;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param chkIs
	 */
	public void setChkIs(String chkIs) {
		this.chkIs = chkIs;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param fmYrwk
	 */
	public void setFmYrwk(String fmYrwk) {
		this.fmYrwk = fmYrwk;
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
	 * @param toYrwk
	 */
	public void setToYrwk(String toYrwk) {
		this.toYrwk = toYrwk;
	}
	
	/**
	 * Column Info
	 * @param levelCd
	 */
	public void setLevelCd(String levelCd) {
		this.levelCd = levelCd;
	}
	
	/**
	 * Column Info
	 * @param subconti
	 */
	public void setSubconti(String subconti) {
		this.subconti = subconti;
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
		setChkId(JSPUtil.getParameter(request, prefix + "chk_id", ""));
		setSubtrade(JSPUtil.getParameter(request, prefix + "subtrade", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setChkIm(JSPUtil.getParameter(request, prefix + "chk_im", ""));
		setCurrYrwk(JSPUtil.getParameter(request, prefix + "curr_yrwk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setChkIs(JSPUtil.getParameter(request, prefix + "chk_is", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFmYrwk(JSPUtil.getParameter(request, prefix + "fm_yrwk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToYrwk(JSPUtil.getParameter(request, prefix + "to_yrwk", ""));
		setLevelCd(JSPUtil.getParameter(request, prefix + "level_cd", ""));
		setSubconti(JSPUtil.getParameter(request, prefix + "subconti", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortSurplusAreaConditionVO[]
	 */
	public PortSurplusAreaConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortSurplusAreaConditionVO[]
	 */
	public PortSurplusAreaConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortSurplusAreaConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chkId = (JSPUtil.getParameter(request, prefix	+ "chk_id", length));
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] chkIm = (JSPUtil.getParameter(request, prefix	+ "chk_im", length));
			String[] currYrwk = (JSPUtil.getParameter(request, prefix	+ "curr_yrwk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] chkIs = (JSPUtil.getParameter(request, prefix	+ "chk_is", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fmYrwk = (JSPUtil.getParameter(request, prefix	+ "fm_yrwk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toYrwk = (JSPUtil.getParameter(request, prefix	+ "to_yrwk", length));
			String[] levelCd = (JSPUtil.getParameter(request, prefix	+ "level_cd", length));
			String[] subconti = (JSPUtil.getParameter(request, prefix	+ "subconti", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortSurplusAreaConditionVO();
				if (chkId[i] != null)
					model.setChkId(chkId[i]);
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (chkIm[i] != null)
					model.setChkIm(chkIm[i]);
				if (currYrwk[i] != null)
					model.setCurrYrwk(currYrwk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (chkIs[i] != null)
					model.setChkIs(chkIs[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fmYrwk[i] != null)
					model.setFmYrwk(fmYrwk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toYrwk[i] != null)
					model.setToYrwk(toYrwk[i]);
				if (levelCd[i] != null)
					model.setLevelCd(levelCd[i]);
				if (subconti[i] != null)
					model.setSubconti(subconti[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortSurplusAreaConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortSurplusAreaConditionVO[]
	 */
	public PortSurplusAreaConditionVO[] getPortSurplusAreaConditionVOs(){
		PortSurplusAreaConditionVO[] vos = (PortSurplusAreaConditionVO[])models.toArray(new PortSurplusAreaConditionVO[models.size()]);
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
		this.chkId = this.chkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkIm = this.chkIm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currYrwk = this.currYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkIs = this.chkIs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYrwk = this.fmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYrwk = this.toYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.levelCd = this.levelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subconti = this.subconti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
