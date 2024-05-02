/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorSumVO.java
*@FileTitle : KorSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.08 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorSumVO> models = new ArrayList<KorSumVO>();
	
	/* Column Info */
	private String cntLc45 = null;
	/* Column Info */
	private String cntEc20 = null;
	/* Column Info */
	private String cntEc45 = null;
	/* Column Info */
	private String cntTsEc20 = null;
	/* Column Info */
	private String cntLc20 = null;
	/* Column Info */
	private String cntTsEc45 = null;
	/* Column Info */
	private String cntEc40 = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cntTsEc40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String inType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntEmpty = null;
	/* Column Info */
	private String cntTs45 = null;
	/* Column Info */
	private String cntTs40 = null;
	/* Column Info */
	private String cntFull = null;
	/* Column Info */
	private String cntLc40 = null;
	/* Column Info */
	private String podTml = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String cntTs20 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorSumVO() {}

	public KorSumVO(String ibflag, String pagerows, String cntLc20, String cntLc40, String cntLc45, String cntTs20, String cntTs40, String cntTs45, String cntEc20, String cntEc40, String cntEc45, String cntTsEc20, String cntTsEc40, String cntTsEc45, String cntFull, String cntEmpty, String vvd, String portCd, String inType, String ioBndCd, String podCd, String polCd, String podTml) {
		this.cntLc45 = cntLc45;
		this.cntEc20 = cntEc20;
		this.cntEc45 = cntEc45;
		this.cntTsEc20 = cntTsEc20;
		this.cntLc20 = cntLc20;
		this.cntTsEc45 = cntTsEc45;
		this.cntEc40 = cntEc40;
		this.ioBndCd = ioBndCd;
		this.cntTsEc40 = cntTsEc40;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.polCd = polCd;
		this.inType = inType;
		this.ibflag = ibflag;
		this.cntEmpty = cntEmpty;
		this.cntTs45 = cntTs45;
		this.cntTs40 = cntTs40;
		this.cntFull = cntFull;
		this.cntLc40 = cntLc40;
		this.podTml = podTml;
		this.portCd = portCd;
		this.cntTs20 = cntTs20;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt_lc_45", getCntLc45());
		this.hashColumns.put("cnt_ec_20", getCntEc20());
		this.hashColumns.put("cnt_ec_45", getCntEc45());
		this.hashColumns.put("cnt_ts_ec_20", getCntTsEc20());
		this.hashColumns.put("cnt_lc_20", getCntLc20());
		this.hashColumns.put("cnt_ts_ec_45", getCntTsEc45());
		this.hashColumns.put("cnt_ec_40", getCntEc40());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cnt_ts_ec_40", getCntTsEc40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_empty", getCntEmpty());
		this.hashColumns.put("cnt_ts_45", getCntTs45());
		this.hashColumns.put("cnt_ts_40", getCntTs40());
		this.hashColumns.put("cnt_full", getCntFull());
		this.hashColumns.put("cnt_lc_40", getCntLc40());
		this.hashColumns.put("pod_tml", getPodTml());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("cnt_ts_20", getCntTs20());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt_lc_45", "cntLc45");
		this.hashFields.put("cnt_ec_20", "cntEc20");
		this.hashFields.put("cnt_ec_45", "cntEc45");
		this.hashFields.put("cnt_ts_ec_20", "cntTsEc20");
		this.hashFields.put("cnt_lc_20", "cntLc20");
		this.hashFields.put("cnt_ts_ec_45", "cntTsEc45");
		this.hashFields.put("cnt_ec_40", "cntEc40");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cnt_ts_ec_40", "cntTsEc40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_empty", "cntEmpty");
		this.hashFields.put("cnt_ts_45", "cntTs45");
		this.hashFields.put("cnt_ts_40", "cntTs40");
		this.hashFields.put("cnt_full", "cntFull");
		this.hashFields.put("cnt_lc_40", "cntLc40");
		this.hashFields.put("pod_tml", "podTml");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("cnt_ts_20", "cntTs20");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntLc45
	 */
	public String getCntLc45() {
		return this.cntLc45;
	}
	
	/**
	 * Column Info
	 * @return cntEc20
	 */
	public String getCntEc20() {
		return this.cntEc20;
	}
	
	/**
	 * Column Info
	 * @return cntEc45
	 */
	public String getCntEc45() {
		return this.cntEc45;
	}
	
	/**
	 * Column Info
	 * @return cntTsEc20
	 */
	public String getCntTsEc20() {
		return this.cntTsEc20;
	}
	
	/**
	 * Column Info
	 * @return cntLc20
	 */
	public String getCntLc20() {
		return this.cntLc20;
	}
	
	/**
	 * Column Info
	 * @return cntTsEc45
	 */
	public String getCntTsEc45() {
		return this.cntTsEc45;
	}
	
	/**
	 * Column Info
	 * @return cntEc40
	 */
	public String getCntEc40() {
		return this.cntEc40;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return cntTsEc40
	 */
	public String getCntTsEc40() {
		return this.cntTsEc40;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return cntEmpty
	 */
	public String getCntEmpty() {
		return this.cntEmpty;
	}
	
	/**
	 * Column Info
	 * @return cntTs45
	 */
	public String getCntTs45() {
		return this.cntTs45;
	}
	
	/**
	 * Column Info
	 * @return cntTs40
	 */
	public String getCntTs40() {
		return this.cntTs40;
	}
	
	/**
	 * Column Info
	 * @return cntFull
	 */
	public String getCntFull() {
		return this.cntFull;
	}
	
	/**
	 * Column Info
	 * @return cntLc40
	 */
	public String getCntLc40() {
		return this.cntLc40;
	}
	
	/**
	 * Column Info
	 * @return podTml
	 */
	public String getPodTml() {
		return this.podTml;
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
	 * @return cntTs20
	 */
	public String getCntTs20() {
		return this.cntTs20;
	}
	

	/**
	 * Column Info
	 * @param cntLc45
	 */
	public void setCntLc45(String cntLc45) {
		this.cntLc45 = cntLc45;
	}
	
	/**
	 * Column Info
	 * @param cntEc20
	 */
	public void setCntEc20(String cntEc20) {
		this.cntEc20 = cntEc20;
	}
	
	/**
	 * Column Info
	 * @param cntEc45
	 */
	public void setCntEc45(String cntEc45) {
		this.cntEc45 = cntEc45;
	}
	
	/**
	 * Column Info
	 * @param cntTsEc20
	 */
	public void setCntTsEc20(String cntTsEc20) {
		this.cntTsEc20 = cntTsEc20;
	}
	
	/**
	 * Column Info
	 * @param cntLc20
	 */
	public void setCntLc20(String cntLc20) {
		this.cntLc20 = cntLc20;
	}
	
	/**
	 * Column Info
	 * @param cntTsEc45
	 */
	public void setCntTsEc45(String cntTsEc45) {
		this.cntTsEc45 = cntTsEc45;
	}
	
	/**
	 * Column Info
	 * @param cntEc40
	 */
	public void setCntEc40(String cntEc40) {
		this.cntEc40 = cntEc40;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param cntTsEc40
	 */
	public void setCntTsEc40(String cntTsEc40) {
		this.cntTsEc40 = cntTsEc40;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param cntEmpty
	 */
	public void setCntEmpty(String cntEmpty) {
		this.cntEmpty = cntEmpty;
	}
	
	/**
	 * Column Info
	 * @param cntTs45
	 */
	public void setCntTs45(String cntTs45) {
		this.cntTs45 = cntTs45;
	}
	
	/**
	 * Column Info
	 * @param cntTs40
	 */
	public void setCntTs40(String cntTs40) {
		this.cntTs40 = cntTs40;
	}
	
	/**
	 * Column Info
	 * @param cntFull
	 */
	public void setCntFull(String cntFull) {
		this.cntFull = cntFull;
	}
	
	/**
	 * Column Info
	 * @param cntLc40
	 */
	public void setCntLc40(String cntLc40) {
		this.cntLc40 = cntLc40;
	}
	
	/**
	 * Column Info
	 * @param podTml
	 */
	public void setPodTml(String podTml) {
		this.podTml = podTml;
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
	 * @param cntTs20
	 */
	public void setCntTs20(String cntTs20) {
		this.cntTs20 = cntTs20;
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
		setCntLc45(JSPUtil.getParameter(request, prefix + "cnt_lc_45", ""));
		setCntEc20(JSPUtil.getParameter(request, prefix + "cnt_ec_20", ""));
		setCntEc45(JSPUtil.getParameter(request, prefix + "cnt_ec_45", ""));
		setCntTsEc20(JSPUtil.getParameter(request, prefix + "cnt_ts_ec_20", ""));
		setCntLc20(JSPUtil.getParameter(request, prefix + "cnt_lc_20", ""));
		setCntTsEc45(JSPUtil.getParameter(request, prefix + "cnt_ts_ec_45", ""));
		setCntEc40(JSPUtil.getParameter(request, prefix + "cnt_ec_40", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCntTsEc40(JSPUtil.getParameter(request, prefix + "cnt_ts_ec_40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntEmpty(JSPUtil.getParameter(request, prefix + "cnt_empty", ""));
		setCntTs45(JSPUtil.getParameter(request, prefix + "cnt_ts_45", ""));
		setCntTs40(JSPUtil.getParameter(request, prefix + "cnt_ts_40", ""));
		setCntFull(JSPUtil.getParameter(request, prefix + "cnt_full", ""));
		setCntLc40(JSPUtil.getParameter(request, prefix + "cnt_lc_40", ""));
		setPodTml(JSPUtil.getParameter(request, prefix + "pod_tml", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCntTs20(JSPUtil.getParameter(request, prefix + "cnt_ts_20", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorSumVO[]
	 */
	public KorSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorSumVO[]
	 */
	public KorSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntLc45 = (JSPUtil.getParameter(request, prefix	+ "cnt_lc_45", length));
			String[] cntEc20 = (JSPUtil.getParameter(request, prefix	+ "cnt_ec_20", length));
			String[] cntEc45 = (JSPUtil.getParameter(request, prefix	+ "cnt_ec_45", length));
			String[] cntTsEc20 = (JSPUtil.getParameter(request, prefix	+ "cnt_ts_ec_20", length));
			String[] cntLc20 = (JSPUtil.getParameter(request, prefix	+ "cnt_lc_20", length));
			String[] cntTsEc45 = (JSPUtil.getParameter(request, prefix	+ "cnt_ts_ec_45", length));
			String[] cntEc40 = (JSPUtil.getParameter(request, prefix	+ "cnt_ec_40", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cntTsEc40 = (JSPUtil.getParameter(request, prefix	+ "cnt_ts_ec_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntEmpty = (JSPUtil.getParameter(request, prefix	+ "cnt_empty", length));
			String[] cntTs45 = (JSPUtil.getParameter(request, prefix	+ "cnt_ts_45", length));
			String[] cntTs40 = (JSPUtil.getParameter(request, prefix	+ "cnt_ts_40", length));
			String[] cntFull = (JSPUtil.getParameter(request, prefix	+ "cnt_full", length));
			String[] cntLc40 = (JSPUtil.getParameter(request, prefix	+ "cnt_lc_40", length));
			String[] podTml = (JSPUtil.getParameter(request, prefix	+ "pod_tml", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cntTs20 = (JSPUtil.getParameter(request, prefix	+ "cnt_ts_20", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorSumVO();
				if (cntLc45[i] != null)
					model.setCntLc45(cntLc45[i]);
				if (cntEc20[i] != null)
					model.setCntEc20(cntEc20[i]);
				if (cntEc45[i] != null)
					model.setCntEc45(cntEc45[i]);
				if (cntTsEc20[i] != null)
					model.setCntTsEc20(cntTsEc20[i]);
				if (cntLc20[i] != null)
					model.setCntLc20(cntLc20[i]);
				if (cntTsEc45[i] != null)
					model.setCntTsEc45(cntTsEc45[i]);
				if (cntEc40[i] != null)
					model.setCntEc40(cntEc40[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cntTsEc40[i] != null)
					model.setCntTsEc40(cntTsEc40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntEmpty[i] != null)
					model.setCntEmpty(cntEmpty[i]);
				if (cntTs45[i] != null)
					model.setCntTs45(cntTs45[i]);
				if (cntTs40[i] != null)
					model.setCntTs40(cntTs40[i]);
				if (cntFull[i] != null)
					model.setCntFull(cntFull[i]);
				if (cntLc40[i] != null)
					model.setCntLc40(cntLc40[i]);
				if (podTml[i] != null)
					model.setPodTml(podTml[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cntTs20[i] != null)
					model.setCntTs20(cntTs20[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorSumVO[]
	 */
	public KorSumVO[] getKorSumVOs(){
		KorSumVO[] vos = (KorSumVO[])models.toArray(new KorSumVO[models.size()]);
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
		this.cntLc45 = this.cntLc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntEc20 = this.cntEc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntEc45 = this.cntEc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTsEc20 = this.cntTsEc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntLc20 = this.cntLc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTsEc45 = this.cntTsEc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntEc40 = this.cntEc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTsEc40 = this.cntTsEc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntEmpty = this.cntEmpty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTs45 = this.cntTs45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTs40 = this.cntTs40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntFull = this.cntFull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntLc40 = this.cntLc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTml = this.podTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTs20 = this.cntTs20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
