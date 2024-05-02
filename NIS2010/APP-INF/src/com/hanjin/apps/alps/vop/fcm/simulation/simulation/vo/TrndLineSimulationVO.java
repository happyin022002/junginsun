/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TrndLineSimulationVO.java
*@FileTitle : TrndLineSimulationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.26 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrndLineSimulationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrndLineSimulationVO> models = new ArrayList<TrndLineSimulationVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trndLineToDt = null;
	/* Column Info */
	private String target = null;
	/* Column Info */
	private String trndLineFmDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrndLineSimulationVO() {}

	public TrndLineSimulationVO(String ibflag, String pagerows, String target, String cntrDznCapa, String vslCd, String vslSlanCd, String skdDirCd, String trndLineFmDt, String trndLineToDt) {
		this.vslCd = vslCd;
		this.cntrDznCapa = cntrDznCapa;
		this.ibflag = ibflag;
		this.trndLineToDt = trndLineToDt;
		this.target = target;
		this.trndLineFmDt = trndLineFmDt;
		this.vslSlanCd = vslSlanCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trnd_line_to_dt", getTrndLineToDt());
		this.hashColumns.put("target", getTarget());
		this.hashColumns.put("trnd_line_fm_dt", getTrndLineFmDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trnd_line_to_dt", "trndLineToDt");
		this.hashFields.put("target", "target");
		this.hashFields.put("trnd_line_fm_dt", "trndLineFmDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
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
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
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
	 * @return trndLineToDt
	 */
	public String getTrndLineToDt() {
		return this.trndLineToDt;
	}
	
	/**
	 * Column Info
	 * @return target
	 */
	public String getTarget() {
		return this.target;
	}
	
	/**
	 * Column Info
	 * @return trndLineFmDt
	 */
	public String getTrndLineFmDt() {
		return this.trndLineFmDt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
	 * @param trndLineToDt
	 */
	public void setTrndLineToDt(String trndLineToDt) {
		this.trndLineToDt = trndLineToDt;
	}
	
	/**
	 * Column Info
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	
	/**
	 * Column Info
	 * @param trndLineFmDt
	 */
	public void setTrndLineFmDt(String trndLineFmDt) {
		this.trndLineFmDt = trndLineFmDt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, prefix + "cntr_dzn_capa", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrndLineToDt(JSPUtil.getParameter(request, prefix + "trnd_line_to_dt", ""));
		setTarget(JSPUtil.getParameter(request, prefix + "target", ""));
		setTrndLineFmDt(JSPUtil.getParameter(request, prefix + "trnd_line_fm_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrndLineSimulationVO[]
	 */
	public TrndLineSimulationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrndLineSimulationVO[]
	 */
	public TrndLineSimulationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrndLineSimulationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trndLineToDt = (JSPUtil.getParameter(request, prefix	+ "trnd_line_to_dt", length));
			String[] target = (JSPUtil.getParameter(request, prefix	+ "target", length));
			String[] trndLineFmDt = (JSPUtil.getParameter(request, prefix	+ "trnd_line_fm_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrndLineSimulationVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trndLineToDt[i] != null)
					model.setTrndLineToDt(trndLineToDt[i]);
				if (target[i] != null)
					model.setTarget(target[i]);
				if (trndLineFmDt[i] != null)
					model.setTrndLineFmDt(trndLineFmDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrndLineSimulationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrndLineSimulationVO[]
	 */
	public TrndLineSimulationVO[] getTrndLineSimulationVOs(){
		TrndLineSimulationVO[] vos = (TrndLineSimulationVO[])models.toArray(new TrndLineSimulationVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineToDt = this.trndLineToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.target = this.target .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineFmDt = this.trndLineFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
