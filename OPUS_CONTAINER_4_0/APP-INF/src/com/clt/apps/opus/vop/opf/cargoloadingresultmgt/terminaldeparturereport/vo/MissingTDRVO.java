/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MissingTDRVO.java
*@FileTitle : MissingTDRVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.03
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.03 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MissingTDRVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MissingTDRVO> models = new ArrayList<MissingTDRVO>();
	
	/* Column Info */
	private String dpDt = null;
	/* Column Info */
	private String bayPlnFlg = null;
	/* Column Info */
	private String arDt = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String svcTpCd = null;
	/* Column Info */
	private String mvCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String tdrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MissingTDRVO() {}

	public MissingTDRVO(String ibflag, String pagerows, String rhqOfcCd, String crrCd, String portCd, String ydCd, String ydNm, String slanCd, String svcTpCd, String vvd, String arDt, String dpDt, String mvCnt, String bayPlnFlg, String tdrFlg) {
		this.dpDt = dpDt;
		this.bayPlnFlg = bayPlnFlg;
		this.arDt = arDt;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.rhqOfcCd = rhqOfcCd;
		this.vvd = vvd;
		this.svcTpCd = svcTpCd;
		this.mvCnt = mvCnt;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.ydCd = ydCd;
		this.ydNm = ydNm;
		this.portCd = portCd;
		this.tdrFlg = tdrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_dt", getDpDt());
		this.hashColumns.put("bay_pln_flg", getBayPlnFlg());
		this.hashColumns.put("ar_dt", getArDt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("svc_tp_cd", getSvcTpCd());
		this.hashColumns.put("mv_cnt", getMvCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("tdr_flg", getTdrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_dt", "dpDt");
		this.hashFields.put("bay_pln_flg", "bayPlnFlg");
		this.hashFields.put("ar_dt", "arDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("svc_tp_cd", "svcTpCd");
		this.hashFields.put("mv_cnt", "mvCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("tdr_flg", "tdrFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpDt
	 */
	public String getDpDt() {
		return this.dpDt;
	}
	
	/**
	 * Column Info
	 * @return bayPlnFlg
	 */
	public String getBayPlnFlg() {
		return this.bayPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return arDt
	 */
	public String getArDt() {
		return this.arDt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return svcTpCd
	 */
	public String getSvcTpCd() {
		return this.svcTpCd;
	}
	
	/**
	 * Column Info
	 * @return mvCnt
	 */
	public String getMvCnt() {
		return this.mvCnt;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return tdrFlg
	 */
	public String getTdrFlg() {
		return this.tdrFlg;
	}
	

	/**
	 * Column Info
	 * @param dpDt
	 */
	public void setDpDt(String dpDt) {
		this.dpDt = dpDt;
	}
	
	/**
	 * Column Info
	 * @param bayPlnFlg
	 */
	public void setBayPlnFlg(String bayPlnFlg) {
		this.bayPlnFlg = bayPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param arDt
	 */
	public void setArDt(String arDt) {
		this.arDt = arDt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param svcTpCd
	 */
	public void setSvcTpCd(String svcTpCd) {
		this.svcTpCd = svcTpCd;
	}
	
	/**
	 * Column Info
	 * @param mvCnt
	 */
	public void setMvCnt(String mvCnt) {
		this.mvCnt = mvCnt;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param tdrFlg
	 */
	public void setTdrFlg(String tdrFlg) {
		this.tdrFlg = tdrFlg;
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
		setDpDt(JSPUtil.getParameter(request, prefix + "dp_dt", ""));
		setBayPlnFlg(JSPUtil.getParameter(request, prefix + "bay_pln_flg", ""));
		setArDt(JSPUtil.getParameter(request, prefix + "ar_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSvcTpCd(JSPUtil.getParameter(request, prefix + "svc_tp_cd", ""));
		setMvCnt(JSPUtil.getParameter(request, prefix + "mv_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setTdrFlg(JSPUtil.getParameter(request, prefix + "tdr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MissingTDRVO[]
	 */
	public MissingTDRVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MissingTDRVO[]
	 */
	public MissingTDRVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MissingTDRVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpDt = (JSPUtil.getParameter(request, prefix	+ "dp_dt", length));
			String[] bayPlnFlg = (JSPUtil.getParameter(request, prefix	+ "bay_pln_flg", length));
			String[] arDt = (JSPUtil.getParameter(request, prefix	+ "ar_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] svcTpCd = (JSPUtil.getParameter(request, prefix	+ "svc_tp_cd", length));
			String[] mvCnt = (JSPUtil.getParameter(request, prefix	+ "mv_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] tdrFlg = (JSPUtil.getParameter(request, prefix	+ "tdr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new MissingTDRVO();
				if (dpDt[i] != null)
					model.setDpDt(dpDt[i]);
				if (bayPlnFlg[i] != null)
					model.setBayPlnFlg(bayPlnFlg[i]);
				if (arDt[i] != null)
					model.setArDt(arDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (svcTpCd[i] != null)
					model.setSvcTpCd(svcTpCd[i]);
				if (mvCnt[i] != null)
					model.setMvCnt(mvCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (tdrFlg[i] != null)
					model.setTdrFlg(tdrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMissingTDRVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MissingTDRVO[]
	 */
	public MissingTDRVO[] getMissingTDRVOs(){
		MissingTDRVO[] vos = (MissingTDRVO[])models.toArray(new MissingTDRVO[models.size()]);
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
		this.dpDt = this.dpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPlnFlg = this.bayPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arDt = this.arDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTpCd = this.svcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvCnt = this.mvCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tdrFlg = this.tdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
