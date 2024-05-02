/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AutosettlementCondVO.java
*@FileTitle : AutosettlementCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10  
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

public class AutosettlementCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutosettlementCondVO> models = new ArrayList<AutosettlementCondVO>();
	
	/* Column Info */
	private String multiOfcCd = null;
	/* Column Info */
	private String backendjobKey = null;
	/* Column Info */
	private String balUpdDt = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xcldOtsSrcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String autoTpCd = null;
	/* Column Info */
	private String adjTjTpKeyCd = null;
	/* Column Info */
	private String adjTjTpCd = null;
	/* Column Info */
	private String xcldOtsTpCd = null;
	/* Column Info */
	private String accoutOfcCd = null;
	/* Column Info */
	private String adjDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AutosettlementCondVO() {}

	public AutosettlementCondVO(String ibflag, String pagerows, String multiOfcCd, String backendjobKey, String balUpdDt, String sailArrDt, String xcldOtsSrcCd, String creUsrId, String autoTpCd, String adjTjTpKeyCd, String adjTjTpCd, String xcldOtsTpCd, String adjDt, String accoutOfcCd) {
		this.multiOfcCd = multiOfcCd;
		this.backendjobKey = backendjobKey;
		this.balUpdDt = balUpdDt;
		this.sailArrDt = sailArrDt;
		this.pagerows = pagerows;
		this.xcldOtsSrcCd = xcldOtsSrcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.autoTpCd = autoTpCd;
		this.adjTjTpKeyCd = adjTjTpKeyCd;
		this.adjTjTpCd = adjTjTpCd;
		this.xcldOtsTpCd = xcldOtsTpCd;
		this.accoutOfcCd = accoutOfcCd;
		this.adjDt = adjDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("multi_ofc_cd", getMultiOfcCd());
		this.hashColumns.put("backendjob_key", getBackendjobKey());
		this.hashColumns.put("bal_upd_dt", getBalUpdDt());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xcld_ots_src_cd", getXcldOtsSrcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("auto_tp_cd", getAutoTpCd());
		this.hashColumns.put("adj_tj_tp_key_cd", getAdjTjTpKeyCd());
		this.hashColumns.put("adj_tj_tp_cd", getAdjTjTpCd());
		this.hashColumns.put("xcld_ots_tp_cd", getXcldOtsTpCd());
		this.hashColumns.put("accout_ofc_cd", getAccoutOfcCd());
		this.hashColumns.put("adj_dt", getAdjDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("multi_ofc_cd", "multiOfcCd");
		this.hashFields.put("backendjob_key", "backendjobKey");
		this.hashFields.put("bal_upd_dt", "balUpdDt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xcld_ots_src_cd", "xcldOtsSrcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("auto_tp_cd", "autoTpCd");
		this.hashFields.put("adj_tj_tp_key_cd", "adjTjTpKeyCd");
		this.hashFields.put("adj_tj_tp_cd", "adjTjTpCd");
		this.hashFields.put("xcld_ots_tp_cd", "xcldOtsTpCd");
		this.hashFields.put("accout_ofc_cd", "accoutOfcCd");
		this.hashFields.put("adj_dt", "adjDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return multiOfcCd
	 */
	public String getMultiOfcCd() {
		return this.multiOfcCd;
	}
	
	/**
	 * Column Info
	 * @return backendjobKey
	 */
	public String getBackendjobKey() {
		return this.backendjobKey;
	}
	
	/**
	 * Column Info
	 * @return balUpdDt
	 */
	public String getBalUpdDt() {
		return this.balUpdDt;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return xcldOtsSrcCd
	 */
	public String getXcldOtsSrcCd() {
		return this.xcldOtsSrcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return autoTpCd
	 */
	public String getAutoTpCd() {
		return this.autoTpCd;
	}
	
	/**
	 * Column Info
	 * @return adjTjTpKeyCd
	 */
	public String getAdjTjTpKeyCd() {
		return this.adjTjTpKeyCd;
	}
	
	/**
	 * Column Info
	 * @return adjTjTpCd
	 */
	public String getAdjTjTpCd() {
		return this.adjTjTpCd;
	}
	
	/**
	 * Column Info
	 * @return xcldOtsTpCd
	 */
	public String getXcldOtsTpCd() {
		return this.xcldOtsTpCd;
	}
	
	/**
	 * Column Info
	 * @return accoutOfcCd
	 */
	public String getAccoutOfcCd() {
		return this.accoutOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adjDt
	 */
	public String getAdjDt() {
		return this.adjDt;
	}
	

	/**
	 * Column Info
	 * @param multiOfcCd
	 */
	public void setMultiOfcCd(String multiOfcCd) {
		this.multiOfcCd = multiOfcCd;
	}
	
	/**
	 * Column Info
	 * @param backendjobKey
	 */
	public void setBackendjobKey(String backendjobKey) {
		this.backendjobKey = backendjobKey;
	}
	
	/**
	 * Column Info
	 * @param balUpdDt
	 */
	public void setBalUpdDt(String balUpdDt) {
		this.balUpdDt = balUpdDt;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param xcldOtsSrcCd
	 */
	public void setXcldOtsSrcCd(String xcldOtsSrcCd) {
		this.xcldOtsSrcCd = xcldOtsSrcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param autoTpCd
	 */
	public void setAutoTpCd(String autoTpCd) {
		this.autoTpCd = autoTpCd;
	}
	
	/**
	 * Column Info
	 * @param adjTjTpKeyCd
	 */
	public void setAdjTjTpKeyCd(String adjTjTpKeyCd) {
		this.adjTjTpKeyCd = adjTjTpKeyCd;
	}
	
	/**
	 * Column Info
	 * @param adjTjTpCd
	 */
	public void setAdjTjTpCd(String adjTjTpCd) {
		this.adjTjTpCd = adjTjTpCd;
	}
	
	/**
	 * Column Info
	 * @param xcldOtsTpCd
	 */
	public void setXcldOtsTpCd(String xcldOtsTpCd) {
		this.xcldOtsTpCd = xcldOtsTpCd;
	}
	
	/**
	 * Column Info
	 * @param accoutOfcCd
	 */
	public void setAccoutOfcCd(String accoutOfcCd) {
		this.accoutOfcCd = accoutOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adjDt
	 */
	public void setAdjDt(String adjDt) {
		this.adjDt = adjDt;
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
		setMultiOfcCd(JSPUtil.getParameter(request, prefix + "multi_ofc_cd", ""));
		setBackendjobKey(JSPUtil.getParameter(request, prefix + "backendjob_key", ""));
		setBalUpdDt(JSPUtil.getParameter(request, prefix + "bal_upd_dt", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setXcldOtsSrcCd(JSPUtil.getParameter(request, prefix + "xcld_ots_src_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAutoTpCd(JSPUtil.getParameter(request, prefix + "auto_tp_cd", ""));
		setAdjTjTpKeyCd(JSPUtil.getParameter(request, prefix + "adj_tj_tp_key_cd", ""));
		setAdjTjTpCd(JSPUtil.getParameter(request, prefix + "adj_tj_tp_cd", ""));
		setXcldOtsTpCd(JSPUtil.getParameter(request, prefix + "xcld_ots_tp_cd", ""));
		setAccoutOfcCd(JSPUtil.getParameter(request, prefix + "accout_ofc_cd", ""));
		setAdjDt(JSPUtil.getParameter(request, prefix + "adj_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutosettlementCondVO[]
	 */
	public AutosettlementCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AutosettlementCondVO[]
	 */
	public AutosettlementCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutosettlementCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] multiOfcCd = (JSPUtil.getParameter(request, prefix	+ "multi_ofc_cd", length));
			String[] backendjobKey = (JSPUtil.getParameter(request, prefix	+ "backendjob_key", length));
			String[] balUpdDt = (JSPUtil.getParameter(request, prefix	+ "bal_upd_dt", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xcldOtsSrcCd = (JSPUtil.getParameter(request, prefix	+ "xcld_ots_src_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] autoTpCd = (JSPUtil.getParameter(request, prefix	+ "auto_tp_cd", length));
			String[] adjTjTpKeyCd = (JSPUtil.getParameter(request, prefix	+ "adj_tj_tp_key_cd", length));
			String[] adjTjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tj_tp_cd", length));
			String[] xcldOtsTpCd = (JSPUtil.getParameter(request, prefix	+ "xcld_ots_tp_cd", length));
			String[] accoutOfcCd = (JSPUtil.getParameter(request, prefix	+ "accout_ofc_cd", length));
			String[] adjDt = (JSPUtil.getParameter(request, prefix	+ "adj_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new AutosettlementCondVO();
				if (multiOfcCd[i] != null)
					model.setMultiOfcCd(multiOfcCd[i]);
				if (backendjobKey[i] != null)
					model.setBackendjobKey(backendjobKey[i]);
				if (balUpdDt[i] != null)
					model.setBalUpdDt(balUpdDt[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xcldOtsSrcCd[i] != null)
					model.setXcldOtsSrcCd(xcldOtsSrcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (autoTpCd[i] != null)
					model.setAutoTpCd(autoTpCd[i]);
				if (adjTjTpKeyCd[i] != null)
					model.setAdjTjTpKeyCd(adjTjTpKeyCd[i]);
				if (adjTjTpCd[i] != null)
					model.setAdjTjTpCd(adjTjTpCd[i]);
				if (xcldOtsTpCd[i] != null)
					model.setXcldOtsTpCd(xcldOtsTpCd[i]);
				if (accoutOfcCd[i] != null)
					model.setAccoutOfcCd(accoutOfcCd[i]);
				if (adjDt[i] != null)
					model.setAdjDt(adjDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutosettlementCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutosettlementCondVO[]
	 */
	public AutosettlementCondVO[] getAutosettlementCondVOs(){
		AutosettlementCondVO[] vos = (AutosettlementCondVO[])models.toArray(new AutosettlementCondVO[models.size()]);
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
		this.multiOfcCd = this.multiOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backendjobKey = this.backendjobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balUpdDt = this.balUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldOtsSrcCd = this.xcldOtsSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoTpCd = this.autoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTjTpKeyCd = this.adjTjTpKeyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTjTpCd = this.adjTjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldOtsTpCd = this.xcldOtsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accoutOfcCd = this.accoutOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjDt = this.adjDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
