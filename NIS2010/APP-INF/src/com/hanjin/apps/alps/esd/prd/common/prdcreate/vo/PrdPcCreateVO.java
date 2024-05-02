/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PrdPcCreateVO.java
*@FileTitle : PrdPcCreateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.common.prdcreate.vo;

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

public class PrdPcCreateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdPcCreateVO> models = new ArrayList<PrdPcCreateVO>();
	
	/* Column Info */
	private String minPctlNo = null;
	/* Column Info */
	private String idaHlgTpCd = null;
	/* Column Info */
	private String skdType = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String obTroFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hdPctlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String skdDate = null;
	/* Column Info */
	private String pcRtnStr = null;
	/* Column Info */
	private String ibTroFlg = null;
	/* Column Info */
	private String maxPctlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PrdPcCreateVO() {}

	public PrdPcCreateVO(String ibflag, String pagerows, String hdPctlNo, String pcRtnStr, String minPctlNo, String maxPctlNo, String skdType, String skdDate, String obTroFlg, String ibTroFlg, String idaHlgTpCd, String copNo, String bkgNo) {
		this.minPctlNo = minPctlNo;
		this.idaHlgTpCd = idaHlgTpCd;
		this.skdType = skdType;
		this.copNo = copNo;
		this.obTroFlg = obTroFlg;
		this.pagerows = pagerows;
		this.hdPctlNo = hdPctlNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.skdDate = skdDate;
		this.pcRtnStr = pcRtnStr;
		this.ibTroFlg = ibTroFlg;
		this.maxPctlNo = maxPctlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("min_pctl_no", getMinPctlNo());
		this.hashColumns.put("ida_hlg_tp_cd", getIdaHlgTpCd());
		this.hashColumns.put("skd_type", getSkdType());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("ob_tro_flg", getObTroFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hd_pctl_no", getHdPctlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("skd_date", getSkdDate());
		this.hashColumns.put("pc_rtn_str", getPcRtnStr());
		this.hashColumns.put("ib_tro_flg", getIbTroFlg());
		this.hashColumns.put("max_pctl_no", getMaxPctlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("min_pctl_no", "minPctlNo");
		this.hashFields.put("ida_hlg_tp_cd", "idaHlgTpCd");
		this.hashFields.put("skd_type", "skdType");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("ob_tro_flg", "obTroFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hd_pctl_no", "hdPctlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("skd_date", "skdDate");
		this.hashFields.put("pc_rtn_str", "pcRtnStr");
		this.hashFields.put("ib_tro_flg", "ibTroFlg");
		this.hashFields.put("max_pctl_no", "maxPctlNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return minPctlNo
	 */
	public String getMinPctlNo() {
		return this.minPctlNo;
	}
	
	/**
	 * Column Info
	 * @return idaHlgTpCd
	 */
	public String getIdaHlgTpCd() {
		return this.idaHlgTpCd;
	}
	
	/**
	 * Column Info
	 * @return skdType
	 */
	public String getSkdType() {
		return this.skdType;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return obTroFlg
	 */
	public String getObTroFlg() {
		return this.obTroFlg;
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
	 * @return hdPctlNo
	 */
	public String getHdPctlNo() {
		return this.hdPctlNo;
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
	 * @return skdDate
	 */
	public String getSkdDate() {
		return this.skdDate;
	}
	
	/**
	 * Column Info
	 * @return pcRtnStr
	 */
	public String getPcRtnStr() {
		return this.pcRtnStr;
	}
	
	/**
	 * Column Info
	 * @return ibTroFlg
	 */
	public String getIbTroFlg() {
		return this.ibTroFlg;
	}
	
	/**
	 * Column Info
	 * @return maxPctlNo
	 */
	public String getMaxPctlNo() {
		return this.maxPctlNo;
	}
	

	/**
	 * Column Info
	 * @param minPctlNo
	 */
	public void setMinPctlNo(String minPctlNo) {
		this.minPctlNo = minPctlNo;
	}
	
	/**
	 * Column Info
	 * @param idaHlgTpCd
	 */
	public void setIdaHlgTpCd(String idaHlgTpCd) {
		this.idaHlgTpCd = idaHlgTpCd;
	}
	
	/**
	 * Column Info
	 * @param skdType
	 */
	public void setSkdType(String skdType) {
		this.skdType = skdType;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param obTroFlg
	 */
	public void setObTroFlg(String obTroFlg) {
		this.obTroFlg = obTroFlg;
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
	 * @param hdPctlNo
	 */
	public void setHdPctlNo(String hdPctlNo) {
		this.hdPctlNo = hdPctlNo;
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
	 * @param skdDate
	 */
	public void setSkdDate(String skdDate) {
		this.skdDate = skdDate;
	}
	
	/**
	 * Column Info
	 * @param pcRtnStr
	 */
	public void setPcRtnStr(String pcRtnStr) {
		this.pcRtnStr = pcRtnStr;
	}
	
	/**
	 * Column Info
	 * @param ibTroFlg
	 */
	public void setIbTroFlg(String ibTroFlg) {
		this.ibTroFlg = ibTroFlg;
	}
	
	/**
	 * Column Info
	 * @param maxPctlNo
	 */
	public void setMaxPctlNo(String maxPctlNo) {
		this.maxPctlNo = maxPctlNo;
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
		setMinPctlNo(JSPUtil.getParameter(request, prefix + "min_pctl_no", ""));
		setIdaHlgTpCd(JSPUtil.getParameter(request, prefix + "ida_hlg_tp_cd", ""));
		setSkdType(JSPUtil.getParameter(request, prefix + "skd_type", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setObTroFlg(JSPUtil.getParameter(request, prefix + "ob_tro_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHdPctlNo(JSPUtil.getParameter(request, prefix + "hd_pctl_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSkdDate(JSPUtil.getParameter(request, prefix + "skd_date", ""));
		setPcRtnStr(JSPUtil.getParameter(request, prefix + "pc_rtn_str", ""));
		setIbTroFlg(JSPUtil.getParameter(request, prefix + "ib_tro_flg", ""));
		setMaxPctlNo(JSPUtil.getParameter(request, prefix + "max_pctl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdPcCreateVO[]
	 */
	public PrdPcCreateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdPcCreateVO[]
	 */
	public PrdPcCreateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdPcCreateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] minPctlNo = (JSPUtil.getParameter(request, prefix	+ "min_pctl_no", length));
			String[] idaHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_hlg_tp_cd", length));
			String[] skdType = (JSPUtil.getParameter(request, prefix	+ "skd_type", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] obTroFlg = (JSPUtil.getParameter(request, prefix	+ "ob_tro_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hdPctlNo = (JSPUtil.getParameter(request, prefix	+ "hd_pctl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] skdDate = (JSPUtil.getParameter(request, prefix	+ "skd_date", length));
			String[] pcRtnStr = (JSPUtil.getParameter(request, prefix	+ "pc_rtn_str", length));
			String[] ibTroFlg = (JSPUtil.getParameter(request, prefix	+ "ib_tro_flg", length));
			String[] maxPctlNo = (JSPUtil.getParameter(request, prefix	+ "max_pctl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdPcCreateVO();
				if (minPctlNo[i] != null)
					model.setMinPctlNo(minPctlNo[i]);
				if (idaHlgTpCd[i] != null)
					model.setIdaHlgTpCd(idaHlgTpCd[i]);
				if (skdType[i] != null)
					model.setSkdType(skdType[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (obTroFlg[i] != null)
					model.setObTroFlg(obTroFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hdPctlNo[i] != null)
					model.setHdPctlNo(hdPctlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (skdDate[i] != null)
					model.setSkdDate(skdDate[i]);
				if (pcRtnStr[i] != null)
					model.setPcRtnStr(pcRtnStr[i]);
				if (ibTroFlg[i] != null)
					model.setIbTroFlg(ibTroFlg[i]);
				if (maxPctlNo[i] != null)
					model.setMaxPctlNo(maxPctlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdPcCreateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdPcCreateVO[]
	 */
	public PrdPcCreateVO[] getPrdPcCreateVOs(){
		PrdPcCreateVO[] vos = (PrdPcCreateVO[])models.toArray(new PrdPcCreateVO[models.size()]);
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
		this.minPctlNo = this.minPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHlgTpCd = this.idaHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdType = this.skdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTroFlg = this.obTroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdPctlNo = this.hdPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDate = this.skdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcRtnStr = this.pcRtnStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTroFlg = this.ibTroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPctlNo = this.maxPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
