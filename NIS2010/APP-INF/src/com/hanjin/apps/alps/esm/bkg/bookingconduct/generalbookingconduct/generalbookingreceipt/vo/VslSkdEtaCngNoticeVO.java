/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VslSkdEtaCngNoticeVO.java
*@FileTitle : VslSkdEtaCngNoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.04.22 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdEtaCngNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdEtaCngNoticeVO> models = new ArrayList<VslSkdEtaCngNoticeVO>();
	
	/* Column Info */
	private String newEtaDt = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newEtdDt = null;
	/* Column Info */
	private String skdCngTpCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String oldEtdDt = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String oldEtaDt = null;
	/* Column Info */
	private String portCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdEtaCngNoticeVO() {}

	public VslSkdEtaCngNoticeVO(String ibflag, String pagerows, String usrId, String usrEml, String vvd, String portCd, String skdCngTpCd, String oldEtdDt, String oldEtaDt, String newEtdDt, String newEtaDt) {
		this.newEtaDt = newEtaDt;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.newEtdDt = newEtdDt;
		this.skdCngTpCd = skdCngTpCd;
		this.usrId = usrId;
		this.oldEtdDt = oldEtdDt;
		this.usrEml = usrEml;
		this.oldEtaDt = oldEtaDt;
		this.portCd = portCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_eta_dt", getNewEtaDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_etd_dt", getNewEtdDt());
		this.hashColumns.put("skd_cng_tp_cd", getSkdCngTpCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("old_etd_dt", getOldEtdDt());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("old_eta_dt", getOldEtaDt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_eta_dt", "newEtaDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_etd_dt", "newEtdDt");
		this.hashFields.put("skd_cng_tp_cd", "skdCngTpCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("old_etd_dt", "oldEtdDt");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("old_eta_dt", "oldEtaDt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newEtaDt
	 */
	public String getNewEtaDt() {
		return this.newEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return newEtdDt
	 */
	public String getNewEtdDt() {
		return this.newEtdDt;
	}
	
	/**
	 * Column Info
	 * @return skdCngTpCd
	 */
	public String getSkdCngTpCd() {
		return this.skdCngTpCd;
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
	 * @return oldEtdDt
	 */
	public String getOldEtdDt() {
		return this.oldEtdDt;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return oldEtaDt
	 */
	public String getOldEtaDt() {
		return this.oldEtaDt;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @param newEtaDt
	 */
	public void setNewEtaDt(String newEtaDt) {
		this.newEtaDt = newEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param newEtdDt
	 */
	public void setNewEtdDt(String newEtdDt) {
		this.newEtdDt = newEtdDt;
	}
	
	/**
	 * Column Info
	 * @param skdCngTpCd
	 */
	public void setSkdCngTpCd(String skdCngTpCd) {
		this.skdCngTpCd = skdCngTpCd;
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
	 * @param oldEtdDt
	 */
	public void setOldEtdDt(String oldEtdDt) {
		this.oldEtdDt = oldEtdDt;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param oldEtaDt
	 */
	public void setOldEtaDt(String oldEtaDt) {
		this.oldEtaDt = oldEtaDt;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setNewEtaDt(JSPUtil.getParameter(request, prefix + "new_eta_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNewEtdDt(JSPUtil.getParameter(request, prefix + "new_etd_dt", ""));
		setSkdCngTpCd(JSPUtil.getParameter(request, prefix + "skd_cng_tp_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setOldEtdDt(JSPUtil.getParameter(request, prefix + "old_etd_dt", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setOldEtaDt(JSPUtil.getParameter(request, prefix + "old_eta_dt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdEtaCngNoticeVO[]
	 */
	public VslSkdEtaCngNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdEtaCngNoticeVO[]
	 */
	public VslSkdEtaCngNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdEtaCngNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newEtaDt = (JSPUtil.getParameter(request, prefix	+ "new_eta_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newEtdDt = (JSPUtil.getParameter(request, prefix	+ "new_etd_dt", length));
			String[] skdCngTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_tp_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] oldEtdDt = (JSPUtil.getParameter(request, prefix	+ "old_etd_dt", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] oldEtaDt = (JSPUtil.getParameter(request, prefix	+ "old_eta_dt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdEtaCngNoticeVO();
				if (newEtaDt[i] != null)
					model.setNewEtaDt(newEtaDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newEtdDt[i] != null)
					model.setNewEtdDt(newEtdDt[i]);
				if (skdCngTpCd[i] != null)
					model.setSkdCngTpCd(skdCngTpCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (oldEtdDt[i] != null)
					model.setOldEtdDt(oldEtdDt[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (oldEtaDt[i] != null)
					model.setOldEtaDt(oldEtaDt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdEtaCngNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdEtaCngNoticeVO[]
	 */
	public VslSkdEtaCngNoticeVO[] getVslSkdEtaCngNoticeVOs(){
		VslSkdEtaCngNoticeVO[] vos = (VslSkdEtaCngNoticeVO[])models.toArray(new VslSkdEtaCngNoticeVO[models.size()]);
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
		this.newEtaDt = this.newEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newEtdDt = this.newEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngTpCd = this.skdCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEtdDt = this.oldEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEtaDt = this.oldEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
