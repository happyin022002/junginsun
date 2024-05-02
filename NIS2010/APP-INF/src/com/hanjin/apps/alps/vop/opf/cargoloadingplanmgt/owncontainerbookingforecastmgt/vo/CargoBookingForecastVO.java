/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoBookingForecastVO.java
*@FileTitle : CargoBookingForecastVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.16 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CargoBookingForecastVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CargoBookingForecastVO> models = new ArrayList<CargoBookingForecastVO>();
	
	/* Column Info */
	private String cntrLmtWgt4 = null;
	/* Column Info */
	private String cntrLmtWgt2 = null;
	/* Column Info */
	private String cntrWgtGrpSeq = null;
	/* Column Info */
	private String cntrLmtWgt3 = null;
	/* Column Info */
	private String cntrLmtWgt1 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String wgtGrpCdDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrWgtGrpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CargoBookingForecastVO() {}

	public CargoBookingForecastVO(String ibflag, String pagerows, String cntrWgtGrpSeq, String slanCd, String skdDirCd, String polCd, String cntrWgtGrpCd, String wgtGrpCdDesc, String cntrLmtWgt1, String cntrLmtWgt2, String cntrLmtWgt3, String cntrLmtWgt4, String creUsrId, String updUsrId) {
		this.cntrLmtWgt4 = cntrLmtWgt4;
		this.cntrLmtWgt2 = cntrLmtWgt2;
		this.cntrWgtGrpSeq = cntrWgtGrpSeq;
		this.cntrLmtWgt3 = cntrLmtWgt3;
		this.cntrLmtWgt1 = cntrLmtWgt1;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.wgtGrpCdDesc = wgtGrpCdDesc;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.cntrWgtGrpCd = cntrWgtGrpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_lmt_wgt4", getCntrLmtWgt4());
		this.hashColumns.put("cntr_lmt_wgt2", getCntrLmtWgt2());
		this.hashColumns.put("cntr_wgt_grp_seq", getCntrWgtGrpSeq());
		this.hashColumns.put("cntr_lmt_wgt3", getCntrLmtWgt3());
		this.hashColumns.put("cntr_lmt_wgt1", getCntrLmtWgt1());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("wgt_grp_cd_desc", getWgtGrpCdDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_wgt_grp_cd", getCntrWgtGrpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_lmt_wgt4", "cntrLmtWgt4");
		this.hashFields.put("cntr_lmt_wgt2", "cntrLmtWgt2");
		this.hashFields.put("cntr_wgt_grp_seq", "cntrWgtGrpSeq");
		this.hashFields.put("cntr_lmt_wgt3", "cntrLmtWgt3");
		this.hashFields.put("cntr_lmt_wgt1", "cntrLmtWgt1");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("wgt_grp_cd_desc", "wgtGrpCdDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_wgt_grp_cd", "cntrWgtGrpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrLmtWgt4
	 */
	public String getCntrLmtWgt4() {
		return this.cntrLmtWgt4;
	}
	
	/**
	 * Column Info
	 * @return cntrLmtWgt2
	 */
	public String getCntrLmtWgt2() {
		return this.cntrLmtWgt2;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtGrpSeq
	 */
	public String getCntrWgtGrpSeq() {
		return this.cntrWgtGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrLmtWgt3
	 */
	public String getCntrLmtWgt3() {
		return this.cntrLmtWgt3;
	}
	
	/**
	 * Column Info
	 * @return cntrLmtWgt1
	 */
	public String getCntrLmtWgt1() {
		return this.cntrLmtWgt1;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return wgtGrpCdDesc
	 */
	public String getWgtGrpCdDesc() {
		return this.wgtGrpCdDesc;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtGrpCd
	 */
	public String getCntrWgtGrpCd() {
		return this.cntrWgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param cntrLmtWgt4
	 */
	public void setCntrLmtWgt4(String cntrLmtWgt4) {
		this.cntrLmtWgt4 = cntrLmtWgt4;
	}
	
	/**
	 * Column Info
	 * @param cntrLmtWgt2
	 */
	public void setCntrLmtWgt2(String cntrLmtWgt2) {
		this.cntrLmtWgt2 = cntrLmtWgt2;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtGrpSeq
	 */
	public void setCntrWgtGrpSeq(String cntrWgtGrpSeq) {
		this.cntrWgtGrpSeq = cntrWgtGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrLmtWgt3
	 */
	public void setCntrLmtWgt3(String cntrLmtWgt3) {
		this.cntrLmtWgt3 = cntrLmtWgt3;
	}
	
	/**
	 * Column Info
	 * @param cntrLmtWgt1
	 */
	public void setCntrLmtWgt1(String cntrLmtWgt1) {
		this.cntrLmtWgt1 = cntrLmtWgt1;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param wgtGrpCdDesc
	 */
	public void setWgtGrpCdDesc(String wgtGrpCdDesc) {
		this.wgtGrpCdDesc = wgtGrpCdDesc;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtGrpCd
	 */
	public void setCntrWgtGrpCd(String cntrWgtGrpCd) {
		this.cntrWgtGrpCd = cntrWgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrLmtWgt4(JSPUtil.getParameter(request, "cntr_lmt_wgt4", ""));
		setCntrLmtWgt2(JSPUtil.getParameter(request, "cntr_lmt_wgt2", ""));
		setCntrWgtGrpSeq(JSPUtil.getParameter(request, "cntr_wgt_grp_seq", ""));
		setCntrLmtWgt3(JSPUtil.getParameter(request, "cntr_lmt_wgt3", ""));
		setCntrLmtWgt1(JSPUtil.getParameter(request, "cntr_lmt_wgt1", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setWgtGrpCdDesc(JSPUtil.getParameter(request, "wgt_grp_cd_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCntrWgtGrpCd(JSPUtil.getParameter(request, "cntr_wgt_grp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CargoBookingForecastVO[]
	 */
	public CargoBookingForecastVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CargoBookingForecastVO[]
	 */
	public CargoBookingForecastVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CargoBookingForecastVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrLmtWgt4 = (JSPUtil.getParameter(request, prefix	+ "cntr_lmt_wgt4", length));
			String[] cntrLmtWgt2 = (JSPUtil.getParameter(request, prefix	+ "cntr_lmt_wgt2", length));
			String[] cntrWgtGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_grp_seq", length));
			String[] cntrLmtWgt3 = (JSPUtil.getParameter(request, prefix	+ "cntr_lmt_wgt3", length));
			String[] cntrLmtWgt1 = (JSPUtil.getParameter(request, prefix	+ "cntr_lmt_wgt1", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] wgtGrpCdDesc = (JSPUtil.getParameter(request, prefix	+ "wgt_grp_cd_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrWgtGrpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_grp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CargoBookingForecastVO();
				if (cntrLmtWgt4[i] != null)
					model.setCntrLmtWgt4(cntrLmtWgt4[i]);
				if (cntrLmtWgt2[i] != null)
					model.setCntrLmtWgt2(cntrLmtWgt2[i]);
				if (cntrWgtGrpSeq[i] != null)
					model.setCntrWgtGrpSeq(cntrWgtGrpSeq[i]);
				if (cntrLmtWgt3[i] != null)
					model.setCntrLmtWgt3(cntrLmtWgt3[i]);
				if (cntrLmtWgt1[i] != null)
					model.setCntrLmtWgt1(cntrLmtWgt1[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (wgtGrpCdDesc[i] != null)
					model.setWgtGrpCdDesc(wgtGrpCdDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrWgtGrpCd[i] != null)
					model.setCntrWgtGrpCd(cntrWgtGrpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCargoBookingForecastVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CargoBookingForecastVO[]
	 */
	public CargoBookingForecastVO[] getCargoBookingForecastVOs(){
		CargoBookingForecastVO[] vos = (CargoBookingForecastVO[])models.toArray(new CargoBookingForecastVO[models.size()]);
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
		this.cntrLmtWgt4 = this.cntrLmtWgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLmtWgt2 = this.cntrLmtWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtGrpSeq = this.cntrWgtGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLmtWgt3 = this.cntrLmtWgt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLmtWgt1 = this.cntrLmtWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtGrpCdDesc = this.wgtGrpCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtGrpCd = this.cntrWgtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
