/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVesselInfoVO.java
*@FileTitle : SearchVesselInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.08.14 윤진영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVesselInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVesselInfoVO> models = new ArrayList<SearchVesselInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String procgb = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mdmVslYn = null;
	/* Column Info */
	private String portClssCapa = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String tradeCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String stndLdbCapa = null;
	/* Column Info */
	private String srow = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVesselInfoVO() {}

	public SearchVesselInfoVO(String ibflag, String pagerows, String vslCd, String vslClssCapa, String portClssCapa, String stndLdbCapa, String vslOshpCd, String vopCd, String mdmVslYn, String tradeCd, String srow, String procgb) {
		this.vslCd = vslCd;
		this.procgb = procgb;
		this.ibflag = ibflag;
		this.mdmVslYn = mdmVslYn;
		this.portClssCapa = portClssCapa;
		this.vopCd = vopCd;
		this.vslOshpCd = vslOshpCd;
		this.tradeCd = tradeCd;
		this.vslClssCapa = vslClssCapa;
		this.stndLdbCapa = stndLdbCapa;
		this.srow = srow;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("procgb", getProcgb());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mdm_vsl_yn", getMdmVslYn());
		this.hashColumns.put("port_clss_capa", getPortClssCapa());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("trade_cd", getTradeCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("stnd_ldb_capa", getStndLdbCapa());
		this.hashColumns.put("srow", getSrow());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("procgb", "procgb");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mdm_vsl_yn", "mdmVslYn");
		this.hashFields.put("port_clss_capa", "portClssCapa");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("trade_cd", "tradeCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("stnd_ldb_capa", "stndLdbCapa");
		this.hashFields.put("srow", "srow");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return procgb
	 */
	public String getProcgb() {
		return this.procgb;
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
	 * @return mdmVslYn
	 */
	public String getMdmVslYn() {
		return this.mdmVslYn;
	}
	
	/**
	 * Column Info
	 * @return portClssCapa
	 */
	public String getPortClssCapa() {
		return this.portClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCd
	 */
	public String getVslOshpCd() {
		return this.vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return tradeCd
	 */
	public String getTradeCd() {
		return this.tradeCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return stndLdbCapa
	 */
	public String getStndLdbCapa() {
		return this.stndLdbCapa;
	}
	
	/**
	 * Column Info
	 * @return srow
	 */
	public String getSrow() {
		return this.srow;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param procgb
	 */
	public void setProcgb(String procgb) {
		this.procgb = procgb;
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
	 * @param mdmVslYn
	 */
	public void setMdmVslYn(String mdmVslYn) {
		this.mdmVslYn = mdmVslYn;
	}
	
	/**
	 * Column Info
	 * @param portClssCapa
	 */
	public void setPortClssCapa(String portClssCapa) {
		this.portClssCapa = portClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCd
	 */
	public void setVslOshpCd(String vslOshpCd) {
		this.vslOshpCd = vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param tradeCd
	 */
	public void setTradeCd(String tradeCd) {
		this.tradeCd = tradeCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param stndLdbCapa
	 */
	public void setStndLdbCapa(String stndLdbCapa) {
		this.stndLdbCapa = stndLdbCapa;
	}
	
	/**
	 * Column Info
	 * @param srow
	 */
	public void setSrow(String srow) {
		this.srow = srow;
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
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setProcgb(JSPUtil.getParameter(request, "procgb", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMdmVslYn(JSPUtil.getParameter(request, "mdm_vsl_yn", ""));
		setPortClssCapa(JSPUtil.getParameter(request, "port_clss_capa", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setVslOshpCd(JSPUtil.getParameter(request, "vsl_oshp_cd", ""));
		setTradeCd(JSPUtil.getParameter(request, "trade_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setStndLdbCapa(JSPUtil.getParameter(request, "stnd_ldb_capa", ""));
		setSrow(JSPUtil.getParameter(request, "srow", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVesselInfoVO[]
	 */
	public SearchVesselInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVesselInfoVO[]
	 */
	public SearchVesselInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVesselInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] procgb = (JSPUtil.getParameter(request, prefix	+ "procgb", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mdmVslYn = (JSPUtil.getParameter(request, prefix	+ "mdm_vsl_yn", length));
			String[] portClssCapa = (JSPUtil.getParameter(request, prefix	+ "port_clss_capa", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] tradeCd = (JSPUtil.getParameter(request, prefix	+ "trade_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] stndLdbCapa = (JSPUtil.getParameter(request, prefix	+ "stnd_ldb_capa", length));
			String[] srow = (JSPUtil.getParameter(request, prefix	+ "srow", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVesselInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (procgb[i] != null)
					model.setProcgb(procgb[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mdmVslYn[i] != null)
					model.setMdmVslYn(mdmVslYn[i]);
				if (portClssCapa[i] != null)
					model.setPortClssCapa(portClssCapa[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (tradeCd[i] != null)
					model.setTradeCd(tradeCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (stndLdbCapa[i] != null)
					model.setStndLdbCapa(stndLdbCapa[i]);
				if (srow[i] != null)
					model.setSrow(srow[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVesselInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVesselInfoVO[]
	 */
	public SearchVesselInfoVO[] getSearchVesselInfoVOs(){
		SearchVesselInfoVO[] vos = (SearchVesselInfoVO[])models.toArray(new SearchVesselInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procgb = this.procgb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmVslYn = this.mdmVslYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClssCapa = this.portClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeCd = this.tradeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndLdbCapa = this.stndLdbCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srow = this.srow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
