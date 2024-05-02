/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : NodeListVO.java
*@FileTitle : NodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.29 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NodeListVO> models = new ArrayList<NodeListVO>();
	
	/* Column Info */
	private String znNm = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String ydFctyTpRailRmpFlg = null;
	/* Column Info */
	private String ydFctyTpMrnTmlFlg = null;
	/* Column Info */
	private String ydFctyTpPsdoYdFlg = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String dstrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ydFctyTpCfsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String ydAddr = null;
	/* Column Info */
	private String pstCd = null;
	/* Column Info */
	private String ydFctyTpCyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NodeListVO() {}

	public NodeListVO(String ibflag, String pagerows, String locCd, String locNm, String ydCd, String ydNm, String eqCtrlOfcCd, String ydFctyTpCyFlg, String ydFctyTpCfsFlg, String ydFctyTpRailRmpFlg, String ydFctyTpPsdoYdFlg, String ydFctyTpMrnTmlFlg, String ydAddr, String znCd, String znNm, String pstCd, String dstrNm) {
		this.znNm = znNm;
		this.znCd = znCd;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
		this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
		this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
		this.locNm = locNm;
		this.dstrNm = dstrNm;
		this.pagerows = pagerows;
		this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.ydCd = ydCd;
		this.ydNm = ydNm;
		this.ydAddr = ydAddr;
		this.pstCd = pstCd;
		this.ydFctyTpCyFlg = ydFctyTpCyFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("zn_nm", getZnNm());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("yd_fcty_tp_rail_rmp_flg", getYdFctyTpRailRmpFlg());
		this.hashColumns.put("yd_fcty_tp_mrn_tml_flg", getYdFctyTpMrnTmlFlg());
		this.hashColumns.put("yd_fcty_tp_psdo_yd_flg", getYdFctyTpPsdoYdFlg());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("dstr_nm", getDstrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yd_fcty_tp_cfs_flg", getYdFctyTpCfsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("yd_addr", getYdAddr());
		this.hashColumns.put("pst_cd", getPstCd());
		this.hashColumns.put("yd_fcty_tp_cy_flg", getYdFctyTpCyFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("zn_nm", "znNm");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("yd_fcty_tp_rail_rmp_flg", "ydFctyTpRailRmpFlg");
		this.hashFields.put("yd_fcty_tp_mrn_tml_flg", "ydFctyTpMrnTmlFlg");
		this.hashFields.put("yd_fcty_tp_psdo_yd_flg", "ydFctyTpPsdoYdFlg");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("dstr_nm", "dstrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yd_fcty_tp_cfs_flg", "ydFctyTpCfsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("yd_addr", "ydAddr");
		this.hashFields.put("pst_cd", "pstCd");
		this.hashFields.put("yd_fcty_tp_cy_flg", "ydFctyTpCyFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return znNm
	 */
	public String getZnNm() {
		return this.znNm;
	}
	
	/**
	 * Column Info
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpRailRmpFlg
	 */
	public String getYdFctyTpRailRmpFlg() {
		return this.ydFctyTpRailRmpFlg;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpMrnTmlFlg
	 */
	public String getYdFctyTpMrnTmlFlg() {
		return this.ydFctyTpMrnTmlFlg;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpPsdoYdFlg
	 */
	public String getYdFctyTpPsdoYdFlg() {
		return this.ydFctyTpPsdoYdFlg;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return dstrNm
	 */
	public String getDstrNm() {
		return this.dstrNm;
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
	 * @return ydFctyTpCfsFlg
	 */
	public String getYdFctyTpCfsFlg() {
		return this.ydFctyTpCfsFlg;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return ydAddr
	 */
	public String getYdAddr() {
		return this.ydAddr;
	}
	
	/**
	 * Column Info
	 * @return pstCd
	 */
	public String getPstCd() {
		return this.pstCd;
	}
	
	/**
	 * Column Info
	 * @return ydFctyTpCyFlg
	 */
	public String getYdFctyTpCyFlg() {
		return this.ydFctyTpCyFlg;
	}
	

	/**
	 * Column Info
	 * @param znNm
	 */
	public void setZnNm(String znNm) {
		this.znNm = znNm;
	}
	
	/**
	 * Column Info
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpRailRmpFlg
	 */
	public void setYdFctyTpRailRmpFlg(String ydFctyTpRailRmpFlg) {
		this.ydFctyTpRailRmpFlg = ydFctyTpRailRmpFlg;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpMrnTmlFlg
	 */
	public void setYdFctyTpMrnTmlFlg(String ydFctyTpMrnTmlFlg) {
		this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpPsdoYdFlg
	 */
	public void setYdFctyTpPsdoYdFlg(String ydFctyTpPsdoYdFlg) {
		this.ydFctyTpPsdoYdFlg = ydFctyTpPsdoYdFlg;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param dstrNm
	 */
	public void setDstrNm(String dstrNm) {
		this.dstrNm = dstrNm;
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
	 * @param ydFctyTpCfsFlg
	 */
	public void setYdFctyTpCfsFlg(String ydFctyTpCfsFlg) {
		this.ydFctyTpCfsFlg = ydFctyTpCfsFlg;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param ydAddr
	 */
	public void setYdAddr(String ydAddr) {
		this.ydAddr = ydAddr;
	}
	
	/**
	 * Column Info
	 * @param pstCd
	 */
	public void setPstCd(String pstCd) {
		this.pstCd = pstCd;
	}
	
	/**
	 * Column Info
	 * @param ydFctyTpCyFlg
	 */
	public void setYdFctyTpCyFlg(String ydFctyTpCyFlg) {
		this.ydFctyTpCyFlg = ydFctyTpCyFlg;
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
		setZnNm(JSPUtil.getParameter(request, prefix + "zn_nm", ""));
		setZnCd(JSPUtil.getParameter(request, prefix + "zn_cd", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setYdFctyTpRailRmpFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_rail_rmp_flg", ""));
		setYdFctyTpMrnTmlFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_mrn_tml_flg", ""));
		setYdFctyTpPsdoYdFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_psdo_yd_flg", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setDstrNm(JSPUtil.getParameter(request, prefix + "dstr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setYdFctyTpCfsFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cfs_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setYdAddr(JSPUtil.getParameter(request, prefix + "yd_addr", ""));
		setPstCd(JSPUtil.getParameter(request, prefix + "pst_cd", ""));
		setYdFctyTpCyFlg(JSPUtil.getParameter(request, prefix + "yd_fcty_tp_cy_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NodeListVO[]
	 */
	public NodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NodeListVO[]
	 */
	public NodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] znNm = (JSPUtil.getParameter(request, prefix	+ "zn_nm", length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] ydFctyTpRailRmpFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_rail_rmp_flg", length));
			String[] ydFctyTpMrnTmlFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_mrn_tml_flg", length));
			String[] ydFctyTpPsdoYdFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_psdo_yd_flg", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] dstrNm = (JSPUtil.getParameter(request, prefix	+ "dstr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ydFctyTpCfsFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_cfs_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] ydAddr = (JSPUtil.getParameter(request, prefix	+ "yd_addr", length));
			String[] pstCd = (JSPUtil.getParameter(request, prefix	+ "pst_cd", length));
			String[] ydFctyTpCyFlg = (JSPUtil.getParameter(request, prefix	+ "yd_fcty_tp_cy_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new NodeListVO();
				if (znNm[i] != null)
					model.setZnNm(znNm[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (ydFctyTpRailRmpFlg[i] != null)
					model.setYdFctyTpRailRmpFlg(ydFctyTpRailRmpFlg[i]);
				if (ydFctyTpMrnTmlFlg[i] != null)
					model.setYdFctyTpMrnTmlFlg(ydFctyTpMrnTmlFlg[i]);
				if (ydFctyTpPsdoYdFlg[i] != null)
					model.setYdFctyTpPsdoYdFlg(ydFctyTpPsdoYdFlg[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (dstrNm[i] != null)
					model.setDstrNm(dstrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ydFctyTpCfsFlg[i] != null)
					model.setYdFctyTpCfsFlg(ydFctyTpCfsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (ydAddr[i] != null)
					model.setYdAddr(ydAddr[i]);
				if (pstCd[i] != null)
					model.setPstCd(pstCd[i]);
				if (ydFctyTpCyFlg[i] != null)
					model.setYdFctyTpCyFlg(ydFctyTpCyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NodeListVO[]
	 */
	public NodeListVO[] getNodeListVOs(){
		NodeListVO[] vos = (NodeListVO[])models.toArray(new NodeListVO[models.size()]);
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
		this.znNm = this.znNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpRailRmpFlg = this.ydFctyTpRailRmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpMrnTmlFlg = this.ydFctyTpMrnTmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpPsdoYdFlg = this.ydFctyTpPsdoYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstrNm = this.dstrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpCfsFlg = this.ydFctyTpCfsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydAddr = this.ydAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstCd = this.pstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydFctyTpCyFlg = this.ydFctyTpCyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
