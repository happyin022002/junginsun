/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgXterRfCgoVO.java
*@FileTitle : BkgXterRfCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.10.26 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgXterRfCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgXterRfCgoVO> models = new ArrayList<BkgXterRfCgoVO>();
	
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String pwrSplCblFlg = null;
	/* Column Info */
	private String minTempUtCd = null;
	/* Column Info */
	private String minTemp = null;
	/* Column Info */
	private String ventRto = null;
	/* Column Info */
	private String clngTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String humidNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrVentCd = null;
	/* Column Info */
	private String diffRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgXterRfCgoVO() {}

	public BkgXterRfCgoVO(String ibflag, String pagerows, String cntrNo, String rcSeq, String cntrTpszCd, String cmdtCd, String cmdtDesc, String minTemp, String minTempUtCd, String pwrSplCblFlg, String ventRto, String clngTpCd, String humidNo, String cntrVentCd, String diffRmk) {
		this.rcSeq = rcSeq;
		this.pwrSplCblFlg = pwrSplCblFlg;
		this.minTempUtCd = minTempUtCd;
		this.minTemp = minTemp;
		this.ventRto = ventRto;
		this.clngTpCd = clngTpCd;
		this.pagerows = pagerows;
		this.humidNo = humidNo;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrVentCd = cntrVentCd;
		this.diffRmk = diffRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("pwr_spl_cbl_flg", getPwrSplCblFlg());
		this.hashColumns.put("min_temp_ut_cd", getMinTempUtCd());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("vent_rto", getVentRto());
		this.hashColumns.put("clng_tp_cd", getClngTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("humid_no", getHumidNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_vent_cd", getCntrVentCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("pwr_spl_cbl_flg", "pwrSplCblFlg");
		this.hashFields.put("min_temp_ut_cd", "minTempUtCd");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("vent_rto", "ventRto");
		this.hashFields.put("clng_tp_cd", "clngTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("humid_no", "humidNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_vent_cd", "cntrVentCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
	}
	
	/**
	 * Column Info
	 * @return pwrSplCblFlg
	 */
	public String getPwrSplCblFlg() {
		return this.pwrSplCblFlg;
	}
	
	/**
	 * Column Info
	 * @return minTempUtCd
	 */
	public String getMinTempUtCd() {
		return this.minTempUtCd;
	}
	
	/**
	 * Column Info
	 * @return minTemp
	 */
	public String getMinTemp() {
		return this.minTemp;
	}
	
	/**
	 * Column Info
	 * @return ventRto
	 */
	public String getVentRto() {
		return this.ventRto;
	}
	
	/**
	 * Column Info
	 * @return clngTpCd
	 */
	public String getClngTpCd() {
		return this.clngTpCd;
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
	 * @return humidNo
	 */
	public String getHumidNo() {
		return this.humidNo;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrVentCd
	 */
	public String getCntrVentCd() {
		return this.cntrVentCd;
	}

	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}

	/**
	 * Column Info
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}
	
	/**
	 * Column Info
	 * @param pwrSplCblFlg
	 */
	public void setPwrSplCblFlg(String pwrSplCblFlg) {
		this.pwrSplCblFlg = pwrSplCblFlg;
	}
	
	/**
	 * Column Info
	 * @param minTempUtCd
	 */
	public void setMinTempUtCd(String minTempUtCd) {
		this.minTempUtCd = minTempUtCd;
	}
	
	/**
	 * Column Info
	 * @param minTemp
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}
	
	/**
	 * Column Info
	 * @param ventRto
	 */
	public void setVentRto(String ventRto) {
		this.ventRto = ventRto;
	}
	
	/**
	 * Column Info
	 * @param clngTpCd
	 */
	public void setClngTpCd(String clngTpCd) {
		this.clngTpCd = clngTpCd;
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
	 * @param humidNo
	 */
	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrVentCd
	 */
	public void setCntrVentCd(String cntrVentCd) {
		this.cntrVentCd = cntrVentCd;
	}

	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRcSeq(JSPUtil.getParameter(request, "rc_seq", ""));
		setPwrSplCblFlg(JSPUtil.getParameter(request, "pwr_spl_cbl_flg", ""));
		setMinTempUtCd(JSPUtil.getParameter(request, "min_temp_ut_cd", ""));
		setMinTemp(JSPUtil.getParameter(request, "min_temp", ""));
		setVentRto(JSPUtil.getParameter(request, "vent_rto", ""));
		setClngTpCd(JSPUtil.getParameter(request, "clng_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHumidNo(JSPUtil.getParameter(request, "humid_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrVentCd(JSPUtil.getParameter(request, "cntr_vent_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterRfCgoVO[]
	 */
	public BkgXterRfCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterRfCgoVO[]
	 */
	public BkgXterRfCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgXterRfCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] pwrSplCblFlg = (JSPUtil.getParameter(request, prefix	+ "pwr_spl_cbl_flg", length));
			String[] minTempUtCd = (JSPUtil.getParameter(request, prefix	+ "min_temp_ut_cd", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] ventRto = (JSPUtil.getParameter(request, prefix	+ "vent_rto", length));
			String[] clngTpCd = (JSPUtil.getParameter(request, prefix	+ "clng_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrVentCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgXterRfCgoVO();
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (pwrSplCblFlg[i] != null)
					model.setPwrSplCblFlg(pwrSplCblFlg[i]);
				if (minTempUtCd[i] != null)
					model.setMinTempUtCd(minTempUtCd[i]);
				if (minTemp[i] != null)
					model.setMinTemp(minTemp[i]);
				if (ventRto[i] != null)
					model.setVentRto(ventRto[i]);
				if (clngTpCd[i] != null)
					model.setClngTpCd(clngTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrVentCd[i] != null)
					model.setCntrVentCd(cntrVentCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgXterRfCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgXterRfCgoVO[]
	 */
	public BkgXterRfCgoVO[] getBkgXterRfCgoVOs(){
		BkgXterRfCgoVO[] vos = (BkgXterRfCgoVO[])models.toArray(new BkgXterRfCgoVO[models.size()]);
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
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pwrSplCblFlg = this.pwrSplCblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTempUtCd = this.minTempUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ventRto = this.ventRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clngTpCd = this.clngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentCd = this.cntrVentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
