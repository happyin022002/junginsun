/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : searchBlCntrMfDescVO.java
*@FileTitle : searchBlCntrMfDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchBlCntrMfDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchBlCntrMfDescVO> models = new ArrayList<searchBlCntrMfDescVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String dMark = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dMeas = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dDesc = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String dPunit = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String dPkg = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchBlCntrMfDescVO() {}

	public searchBlCntrMfDescVO(String ibflag, String pagerows, String dPunit, String dPkg, String dWgt, String dMeas, String dDesc, String dMark, String vslCd, String skdVoyNo, String skdDirCd, String blNo, String polCd, String cntrNo, String cntrMfSeq, String pckQty, String cntrMfMkDesc, String cntrMfGdsDesc, String pckTpCd, String measQty, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.dMark = dMark;
		this.creDt = creDt;
		this.skdVoyNo = skdVoyNo;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.blNo = blNo;
		this.cntrMfSeq = cntrMfSeq;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.dMeas = dMeas;
		this.cntrNo = cntrNo;
		this.dDesc = dDesc;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.dPunit = dPunit;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.dPkg = dPkg;
		this.pckTpCd = pckTpCd;
		this.updUsrId = updUsrId;
		this.dWgt = dWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("d_mark", getDMark());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("d_meas", getDMeas());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("d_desc", getDDesc());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("d_punit", getDPunit());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("d_wgt", getDWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("d_mark", "dMark");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("d_meas", "dMeas");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("d_desc", "dDesc");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("d_punit", "dPunit");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("d_wgt", "dWgt");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return dMark
	 */
	public String getDMark() {
		return this.dMark;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc
	 */
	public String getCntrMfMkDesc() {
		return this.cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return dMeas
	 */
	public String getDMeas() {
		return this.dMeas;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return dDesc
	 */
	public String getDDesc() {
		return this.dDesc;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return dPunit
	 */
	public String getDPunit() {
		return this.dPunit;
	}
	
	/**
	 * Column Info
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return dPkg
	 */
	public String getDPkg() {
		return this.dPkg;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
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
	 * @return dWgt
	 */
	public String getDWgt() {
		return this.dWgt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param dMark
	 */
	public void setDMark(String dMark) {
		this.dMark = dMark;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc
	 */
	public void setCntrMfMkDesc(String cntrMfMkDesc) {
		this.cntrMfMkDesc = cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param dMeas
	 */
	public void setDMeas(String dMeas) {
		this.dMeas = dMeas;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param dDesc
	 */
	public void setDDesc(String dDesc) {
		this.dDesc = dDesc;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param dPunit
	 */
	public void setDPunit(String dPunit) {
		this.dPunit = dPunit;
	}
	
	/**
	 * Column Info
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param dPkg
	 */
	public void setDPkg(String dPkg) {
		this.dPkg = dPkg;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param dWgt
	 */
	public void setDWgt(String dWgt) {
		this.dWgt = dWgt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDMark(JSPUtil.getParameter(request, prefix + "d_mark", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDMeas(JSPUtil.getParameter(request, prefix + "d_meas", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDDesc(JSPUtil.getParameter(request, prefix + "d_desc", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setDPunit(JSPUtil.getParameter(request, prefix + "d_punit", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setDPkg(JSPUtil.getParameter(request, prefix + "d_pkg", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDWgt(JSPUtil.getParameter(request, prefix + "d_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchBlCntrMfDescVO[]
	 */
	public searchBlCntrMfDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchBlCntrMfDescVO[]
	 */
	public searchBlCntrMfDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchBlCntrMfDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] dMark = (JSPUtil.getParameter(request, prefix	+ "d_mark", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dMeas = (JSPUtil.getParameter(request, prefix	+ "d_meas", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dDesc = (JSPUtil.getParameter(request, prefix	+ "d_desc", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] dPunit = (JSPUtil.getParameter(request, prefix	+ "d_punit", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dWgt = (JSPUtil.getParameter(request, prefix	+ "d_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchBlCntrMfDescVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (dMark[i] != null)
					model.setDMark(dMark[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dMeas[i] != null)
					model.setDMeas(dMeas[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dDesc[i] != null)
					model.setDDesc(dDesc[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (dPunit[i] != null)
					model.setDPunit(dPunit[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (dPkg[i] != null)
					model.setDPkg(dPkg[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dWgt[i] != null)
					model.setDWgt(dWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchBlCntrMfDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchBlCntrMfDescVO[]
	 */
	public searchBlCntrMfDescVO[] getsearchBlCntrMfDescVOs(){
		searchBlCntrMfDescVO[] vos = (searchBlCntrMfDescVO[])models.toArray(new searchBlCntrMfDescVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMark = this.dMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMeas = this.dMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDesc = this.dDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPunit = this.dPunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWgt = this.dWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
