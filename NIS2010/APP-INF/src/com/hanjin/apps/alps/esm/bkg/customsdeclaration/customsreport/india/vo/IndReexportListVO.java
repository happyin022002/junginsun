/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndReexportListVO.java
*@FileTitle : IndReexportListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo;

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

public class IndReexportListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndReexportListVO> models = new ArrayList<IndReexportListVO>();
	
	/* Column Info */
	private String pcDt = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String igmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String impVsl = null;
	/* Column Info */
	private String igmDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String expVsl = null;
	/* Column Info */
	private String vslVoy = null;
	/* Column Info */
	private String pcNo = null;
	/* Column Info */
	private String isoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndReexportListVO() {}

	public IndReexportListVO(String ibflag, String pagerows, String bkgNo, String cnmvCycNo, String polNodCd, String bkgCgoTpCd, String cntrNo, String isoCd, String impVsl, String vslVoy, String igmNo, String igmDt, String expVsl, String skdVoyNo, String pcNo, String pcDt, String vpsEtdDt) {
		this.pcDt = pcDt;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.vpsEtdDt = vpsEtdDt;
		this.cnmvCycNo = cnmvCycNo;
		this.skdVoyNo = skdVoyNo;
		this.polNodCd = polNodCd;
		this.igmNo = igmNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.impVsl = impVsl;
		this.igmDt = igmDt;
		this.cntrNo = cntrNo;
		this.expVsl = expVsl;
		this.vslVoy = vslVoy;
		this.pcNo = pcNo;
		this.isoCd = isoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pc_dt", getPcDt());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("igm_no", getIgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("imp_vsl", getImpVsl());
		this.hashColumns.put("igm_dt", getIgmDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("exp_vsl", getExpVsl());
		this.hashColumns.put("vsl_voy", getVslVoy());
		this.hashColumns.put("pc_no", getPcNo());
		this.hashColumns.put("iso_cd", getIsoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pc_dt", "pcDt");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("igm_no", "igmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("imp_vsl", "impVsl");
		this.hashFields.put("igm_dt", "igmDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("exp_vsl", "expVsl");
		this.hashFields.put("vsl_voy", "vslVoy");
		this.hashFields.put("pc_no", "pcNo");
		this.hashFields.put("iso_cd", "isoCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pcDt
	 */
	public String getPcDt() {
		return this.pcDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
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
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return igmNo
	 */
	public String getIgmNo() {
		return this.igmNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return impVsl
	 */
	public String getImpVsl() {
		return this.impVsl;
	}
	
	/**
	 * Column Info
	 * @return igmDt
	 */
	public String getIgmDt() {
		return this.igmDt;
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
	 * @return expVsl
	 */
	public String getExpVsl() {
		return this.expVsl;
	}
	
	/**
	 * Column Info
	 * @return vslVoy
	 */
	public String getVslVoy() {
		return this.vslVoy;
	}
	
	/**
	 * Column Info
	 * @return pcNo
	 */
	public String getPcNo() {
		return this.pcNo;
	}
	
	/**
	 * Column Info
	 * @return isoCd
	 */
	public String getIsoCd() {
		return this.isoCd;
	}
	

	/**
	 * Column Info
	 * @param pcDt
	 */
	public void setPcDt(String pcDt) {
		this.pcDt = pcDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
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
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param igmNo
	 */
	public void setIgmNo(String igmNo) {
		this.igmNo = igmNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param impVsl
	 */
	public void setImpVsl(String impVsl) {
		this.impVsl = impVsl;
	}
	
	/**
	 * Column Info
	 * @param igmDt
	 */
	public void setIgmDt(String igmDt) {
		this.igmDt = igmDt;
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
	 * @param expVsl
	 */
	public void setExpVsl(String expVsl) {
		this.expVsl = expVsl;
	}
	
	/**
	 * Column Info
	 * @param vslVoy
	 */
	public void setVslVoy(String vslVoy) {
		this.vslVoy = vslVoy;
	}
	
	/**
	 * Column Info
	 * @param pcNo
	 */
	public void setPcNo(String pcNo) {
		this.pcNo = pcNo;
	}
	
	/**
	 * Column Info
	 * @param isoCd
	 */
	public void setIsoCd(String isoCd) {
		this.isoCd = isoCd;
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
		setPcDt(JSPUtil.getParameter(request, prefix + "pc_dt", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setIgmNo(JSPUtil.getParameter(request, prefix + "igm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setImpVsl(JSPUtil.getParameter(request, prefix + "imp_vsl", ""));
		setIgmDt(JSPUtil.getParameter(request, prefix + "igm_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setExpVsl(JSPUtil.getParameter(request, prefix + "exp_vsl", ""));
		setVslVoy(JSPUtil.getParameter(request, prefix + "vsl_voy", ""));
		setPcNo(JSPUtil.getParameter(request, prefix + "pc_no", ""));
		setIsoCd(JSPUtil.getParameter(request, prefix + "iso_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndReexportListVO[]
	 */
	public IndReexportListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndReexportListVO[]
	 */
	public IndReexportListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndReexportListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pcDt = (JSPUtil.getParameter(request, prefix	+ "pc_dt", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] igmNo = (JSPUtil.getParameter(request, prefix	+ "igm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] impVsl = (JSPUtil.getParameter(request, prefix	+ "imp_vsl", length));
			String[] igmDt = (JSPUtil.getParameter(request, prefix	+ "igm_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] expVsl = (JSPUtil.getParameter(request, prefix	+ "exp_vsl", length));
			String[] vslVoy = (JSPUtil.getParameter(request, prefix	+ "vsl_voy", length));
			String[] pcNo = (JSPUtil.getParameter(request, prefix	+ "pc_no", length));
			String[] isoCd = (JSPUtil.getParameter(request, prefix	+ "iso_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndReexportListVO();
				if (pcDt[i] != null)
					model.setPcDt(pcDt[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (igmNo[i] != null)
					model.setIgmNo(igmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (impVsl[i] != null)
					model.setImpVsl(impVsl[i]);
				if (igmDt[i] != null)
					model.setIgmDt(igmDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (expVsl[i] != null)
					model.setExpVsl(expVsl[i]);
				if (vslVoy[i] != null)
					model.setVslVoy(vslVoy[i]);
				if (pcNo[i] != null)
					model.setPcNo(pcNo[i]);
				if (isoCd[i] != null)
					model.setIsoCd(isoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndReexportListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndReexportListVO[]
	 */
	public IndReexportListVO[] getIndReexportListVOs(){
		IndReexportListVO[] vos = (IndReexportListVO[])models.toArray(new IndReexportListVO[models.size()]);
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
		this.pcDt = this.pcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.igmNo = this.igmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.impVsl = this.impVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.igmDt = this.igmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expVsl = this.expVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVoy = this.vslVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcNo = this.pcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCd = this.isoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
