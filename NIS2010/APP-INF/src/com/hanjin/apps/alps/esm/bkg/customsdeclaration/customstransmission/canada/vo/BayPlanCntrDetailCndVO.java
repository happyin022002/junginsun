/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BayPlanCntrDetailCndVO.java
*@FileTitle : BayPlanCntrDetailCndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

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

public class BayPlanCntrDetailCndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BayPlanCntrDetailCndVO> models = new ArrayList<BayPlanCntrDetailCndVO>();
	
	/* Column Info */
	private String cntrStatus = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String tunit = null;
	/* Column Info */
	private String xterLen = null;
	/* Column Info */
	private String imdg = null;
	/* Column Info */
	private String pos = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String unno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String coLoaded = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String fmInd = null;
	/* Column Info */
	private String cntrtype = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String scac = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String xterHgt = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String xterWdt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BayPlanCntrDetailCndVO() {}

	public BayPlanCntrDetailCndVO(String ibflag, String pagerows, String cntrNo, String cntrtype, String fmInd, String pos, String wgt, String por, String pol, String pod, String del, String imdg, String unno, String coLoaded, String scac, String cntrSize, String xterLen, String xterWdt, String xterHgt, String temp, String tunit, String cntrStatus, String pckQty, String pckTpCd, String cntrMfGdsDesc) {
		this.cntrStatus = cntrStatus;
		this.por = por;
		this.tunit = tunit;
		this.xterLen = xterLen;
		this.imdg = imdg;
		this.pos = pos;
		this.pagerows = pagerows;
		this.unno = unno;
		this.ibflag = ibflag;
		this.coLoaded = coLoaded;
		this.wgt = wgt;
		this.pol = pol;
		this.pckQty = pckQty;
		this.del = del;
		this.pckTpCd = pckTpCd;
		this.pod = pod;
		this.fmInd = fmInd;
		this.cntrtype = cntrtype;
		this.cntrSize = cntrSize;
		this.scac = scac;
		this.cntrNo = cntrNo;
		this.temp = temp;
		this.xterHgt = xterHgt;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.xterWdt = xterWdt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_status", getCntrStatus());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("tunit", getTunit());
		this.hashColumns.put("xter_len", getXterLen());
		this.hashColumns.put("imdg", getImdg());
		this.hashColumns.put("pos", getPos());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("unno", getUnno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("co_loaded", getCoLoaded());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("fm_ind", getFmInd());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("scac", getScac());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("xter_hgt", getXterHgt());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("xter_wdt", getXterWdt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_status", "cntrStatus");
		this.hashFields.put("por", "por");
		this.hashFields.put("tunit", "tunit");
		this.hashFields.put("xter_len", "xterLen");
		this.hashFields.put("imdg", "imdg");
		this.hashFields.put("pos", "pos");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("unno", "unno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("co_loaded", "coLoaded");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("del", "del");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("fm_ind", "fmInd");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("scac", "scac");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("xter_hgt", "xterHgt");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("xter_wdt", "xterWdt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrStatus
	 */
	public String getCntrStatus() {
		return this.cntrStatus;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return tunit
	 */
	public String getTunit() {
		return this.tunit;
	}
	
	/**
	 * Column Info
	 * @return xterLen
	 */
	public String getXterLen() {
		return this.xterLen;
	}
	
	/**
	 * Column Info
	 * @return imdg
	 */
	public String getImdg() {
		return this.imdg;
	}
	
	/**
	 * Column Info
	 * @return pos
	 */
	public String getPos() {
		return this.pos;
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
	 * @return unno
	 */
	public String getUnno() {
		return this.unno;
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
	 * @return coLoaded
	 */
	public String getCoLoaded() {
		return this.coLoaded;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return del
	 */
	public String getDel() {
		return this.del;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return fmInd
	 */
	public String getFmInd() {
		return this.fmInd;
	}
	
	/**
	 * Column Info
	 * @return cntrtype
	 */
	public String getCntrtype() {
		return this.cntrtype;
	}
	
	/**
	 * Column Info
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
	}
	
	/**
	 * Column Info
	 * @return scac
	 */
	public String getScac() {
		return this.scac;
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
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
	}
	
	/**
	 * Column Info
	 * @return xterHgt
	 */
	public String getXterHgt() {
		return this.xterHgt;
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
	 * @return xterWdt
	 */
	public String getXterWdt() {
		return this.xterWdt;
	}
	

	/**
	 * Column Info
	 * @param cntrStatus
	 */
	public void setCntrStatus(String cntrStatus) {
		this.cntrStatus = cntrStatus;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param tunit
	 */
	public void setTunit(String tunit) {
		this.tunit = tunit;
	}
	
	/**
	 * Column Info
	 * @param xterLen
	 */
	public void setXterLen(String xterLen) {
		this.xterLen = xterLen;
	}
	
	/**
	 * Column Info
	 * @param imdg
	 */
	public void setImdg(String imdg) {
		this.imdg = imdg;
	}
	
	/**
	 * Column Info
	 * @param pos
	 */
	public void setPos(String pos) {
		this.pos = pos;
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
	 * @param unno
	 */
	public void setUnno(String unno) {
		this.unno = unno;
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
	 * @param coLoaded
	 */
	public void setCoLoaded(String coLoaded) {
		this.coLoaded = coLoaded;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
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
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param fmInd
	 */
	public void setFmInd(String fmInd) {
		this.fmInd = fmInd;
	}
	
	/**
	 * Column Info
	 * @param cntrtype
	 */
	public void setCntrtype(String cntrtype) {
		this.cntrtype = cntrtype;
	}
	
	/**
	 * Column Info
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
	}
	
	/**
	 * Column Info
	 * @param scac
	 */
	public void setScac(String scac) {
		this.scac = scac;
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
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	/**
	 * Column Info
	 * @param xterHgt
	 */
	public void setXterHgt(String xterHgt) {
		this.xterHgt = xterHgt;
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
	 * @param xterWdt
	 */
	public void setXterWdt(String xterWdt) {
		this.xterWdt = xterWdt;
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
		setCntrStatus(JSPUtil.getParameter(request, prefix + "cntr_status", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setTunit(JSPUtil.getParameter(request, prefix + "tunit", ""));
		setXterLen(JSPUtil.getParameter(request, prefix + "xter_len", ""));
		setImdg(JSPUtil.getParameter(request, prefix + "imdg", ""));
		setPos(JSPUtil.getParameter(request, prefix + "pos", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUnno(JSPUtil.getParameter(request, prefix + "unno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCoLoaded(JSPUtil.getParameter(request, prefix + "co_loaded", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setFmInd(JSPUtil.getParameter(request, prefix + "fm_ind", ""));
		setCntrtype(JSPUtil.getParameter(request, prefix + "cntrtype", ""));
		setCntrSize(JSPUtil.getParameter(request, prefix + "cntr_size", ""));
		setScac(JSPUtil.getParameter(request, prefix + "scac", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
		setXterHgt(JSPUtil.getParameter(request, prefix + "xter_hgt", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setXterWdt(JSPUtil.getParameter(request, prefix + "xter_wdt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BayPlanCntrDetailCndVO[]
	 */
	public BayPlanCntrDetailCndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BayPlanCntrDetailCndVO[]
	 */
	public BayPlanCntrDetailCndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BayPlanCntrDetailCndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrStatus = (JSPUtil.getParameter(request, prefix	+ "cntr_status", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] tunit = (JSPUtil.getParameter(request, prefix	+ "tunit", length));
			String[] xterLen = (JSPUtil.getParameter(request, prefix	+ "xter_len", length));
			String[] imdg = (JSPUtil.getParameter(request, prefix	+ "imdg", length));
			String[] pos = (JSPUtil.getParameter(request, prefix	+ "pos", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] unno = (JSPUtil.getParameter(request, prefix	+ "unno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] coLoaded = (JSPUtil.getParameter(request, prefix	+ "co_loaded", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] fmInd = (JSPUtil.getParameter(request, prefix	+ "fm_ind", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] scac = (JSPUtil.getParameter(request, prefix	+ "scac", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] xterHgt = (JSPUtil.getParameter(request, prefix	+ "xter_hgt", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] xterWdt = (JSPUtil.getParameter(request, prefix	+ "xter_wdt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BayPlanCntrDetailCndVO();
				if (cntrStatus[i] != null)
					model.setCntrStatus(cntrStatus[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (tunit[i] != null)
					model.setTunit(tunit[i]);
				if (xterLen[i] != null)
					model.setXterLen(xterLen[i]);
				if (imdg[i] != null)
					model.setImdg(imdg[i]);
				if (pos[i] != null)
					model.setPos(pos[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (unno[i] != null)
					model.setUnno(unno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (coLoaded[i] != null)
					model.setCoLoaded(coLoaded[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (fmInd[i] != null)
					model.setFmInd(fmInd[i]);
				if (cntrtype[i] != null)
					model.setCntrtype(cntrtype[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (scac[i] != null)
					model.setScac(scac[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (xterHgt[i] != null)
					model.setXterHgt(xterHgt[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (xterWdt[i] != null)
					model.setXterWdt(xterWdt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBayPlanCntrDetailCndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BayPlanCntrDetailCndVO[]
	 */
	public BayPlanCntrDetailCndVO[] getBayPlanCntrDetailCndVOs(){
		BayPlanCntrDetailCndVO[] vos = (BayPlanCntrDetailCndVO[])models.toArray(new BayPlanCntrDetailCndVO[models.size()]);
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
		this.cntrStatus = this.cntrStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tunit = this.tunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterLen = this.xterLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg = this.imdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pos = this.pos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unno = this.unno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coLoaded = this.coLoaded .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInd = this.fmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scac = this.scac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterHgt = this.xterHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterWdt = this.xterWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
