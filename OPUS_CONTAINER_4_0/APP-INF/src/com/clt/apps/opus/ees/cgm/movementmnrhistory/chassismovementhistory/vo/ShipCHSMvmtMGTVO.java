/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ShipCHSMvmtMGTVO.java
*@FileTitle : ShipCHSMvmtMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.27
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.27 장준우
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo;

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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ShipCHSMvmtMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ShipCHSMvmtMGTVO> models = new ArrayList<ShipCHSMvmtMGTVO>();

	/* Column Info */
	private String pChssNo = null;
	/* Column Info */
	private String pMvmtDt = null;
	/* Column Info */
	private String pLocCd = null;
	/* Column Info */
	private String pYdCd = null;
	/* Column Info */
	private String sysSeq01 = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String sysSeq02 = null;
	/* Column Info */
	private String cntSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lstSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cntrNo02 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo01 = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String gateIoCd = null;
	/* Column Info */
	private int iPage = 1;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ShipCHSMvmtMGTVO() {}

	public ShipCHSMvmtMGTVO(String ibflag, String pagerows, String pChssNo, String pMvmtDt, String pLocCd, String pYdCd, String chssNo, String mvmtDt, String ydCd, String locCd, String gateIoCd, String sysSeq01, String cntrNo01, String sysSeq02, String cntrNo02, String cntSeq, String lstSeq) {
		this.sysSeq01 = sysSeq01;
		this.chssNo = chssNo;
		this.sysSeq02 = sysSeq02;
		this.cntSeq = cntSeq;
		this.pagerows = pagerows;
		this.lstSeq = lstSeq;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.cntrNo02 = cntrNo02;
		this.ydCd = ydCd;
		this.cntrNo01 = cntrNo01;
		this.mvmtDt = mvmtDt;
		this.gateIoCd = gateIoCd;
		this.pChssNo = pChssNo;
		this.pMvmtDt = pMvmtDt;
		this.pLocCd = pLocCd;
		this.pYdCd = pYdCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sys_seq_01", getSysSeq01());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("sys_seq_02", getSysSeq02());
		this.hashColumns.put("cnt_seq", getCntSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lst_seq", getLstSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cntr_no_02", getCntrNo02());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no_01", getCntrNo01());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("gate_io_cd", getGateIoCd());
		this.hashColumns.put("p_chss_no", getPChssNo());
		this.hashColumns.put("p_mvmt_dt", getPMvmtDt());
		this.hashColumns.put("p_loc_cd", getPLocCd());
		this.hashColumns.put("p_yd_cd", getPYdCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sys_seq_01", "sysSeq01");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("sys_seq_02", "sysSeq02");
		this.hashFields.put("cnt_seq", "cntSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lst_seq", "lstSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cntr_no_02", "cntrNo02");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no_01", "cntrNo01");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("gate_io_cd", "gateIoCd");
		this.hashFields.put("p_chss_no", "pChssNo");
		this.hashFields.put("p_mvmt_dt", "pMvmtDt");
		this.hashFields.put("p_loc_cd", "pLocCd");
		this.hashFields.put("p_yd_cd", "pYdCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return sysSeq01
	 */
	public String getSysSeq01() {
		return this.sysSeq01;
	}

	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}

	/**
	 * Column Info
	 * @return sysSeq02
	 */
	public String getSysSeq02() {
		return this.sysSeq02;
	}

	/**
	 * Column Info
	 * @return cntSeq
	 */
	public String getCntSeq() {
		return this.cntSeq;
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
	 * @return lstSeq
	 */
	public String getLstSeq() {
		return this.lstSeq;
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
	 * @return cntrNo02
	 */
	public String getCntrNo02() {
		return this.cntrNo02;
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
	 * @return cntrNo01
	 */
	public String getCntrNo01() {
		return this.cntrNo01;
	}

	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}

	/**
	 * Column Info
	 * @return gateIoCd
	 */
	public String getGateIoCd() {
		return this.gateIoCd;
	}


	/**
	 * Column Info
	 * @param sysSeq01
	 */
	public void setSysSeq01(String sysSeq01) {
		this.sysSeq01 = sysSeq01;
	}

	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}

	/**
	 * Column Info
	 * @param sysSeq02
	 */
	public void setSysSeq02(String sysSeq02) {
		this.sysSeq02 = sysSeq02;
	}

	/**
	 * Column Info
	 * @param cntSeq
	 */
	public void setCntSeq(String cntSeq) {
		this.cntSeq = cntSeq;
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
	 * @param lstSeq
	 */
	public void setLstSeq(String lstSeq) {
		this.lstSeq = lstSeq;
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
	 * @param cntrNo02
	 */
	public void setCntrNo02(String cntrNo02) {
		this.cntrNo02 = cntrNo02;
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
	 * @param cntrNo01
	 */
	public void setCntrNo01(String cntrNo01) {
		this.cntrNo01 = cntrNo01;
	}

	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}

	/**
	 * Column Info
	 * @param gateIoCd
	 */
	public void setGateIoCd(String gateIoCd) {
		this.gateIoCd = gateIoCd;
	}

	/**
	 * @return the pChssNo
	 */
	public String getPChssNo() {
		return pChssNo;
	}

	/**
	 * @param chssNo the pChssNo to set
	 */
	public void setPChssNo(String chssNo) {
		pChssNo = chssNo;
	}

	/**
	 * @return the pMvmtDt
	 */
	public String getPMvmtDt() {
		return pMvmtDt;
	}

	/**
	 * @param mvmtDt the pMvmtDt to set
	 */
	public void setPMvmtDt(String mvmtDt) {
		pMvmtDt = mvmtDt;
	}

	/**
	 * @return the pLocCd
	 */
	public String getPLocCd() {
		return pLocCd;
	}

	/**
	 * @param locCd the pLocCd to set
	 */
	public void setPLocCd(String locCd) {
		pLocCd = locCd;
	}

	/**
	 * @return the pYdCd
	 */
	public String getPYdCd() {
		return pYdCd;
	}

	/**
	 * @param ydCd the pYdCd to set
	 */
	public void setPYdCd(String ydCd) {
		pYdCd = ydCd;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param page the iPage to set
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
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
		setSysSeq01(JSPUtil.getParameter(request, prefix + "sys_seq_01", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setSysSeq02(JSPUtil.getParameter(request, prefix + "sys_seq_02", ""));
		setCntSeq(JSPUtil.getParameter(request, prefix + "cnt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLstSeq(JSPUtil.getParameter(request, prefix + "lst_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCntrNo02(JSPUtil.getParameter(request, prefix + "cntr_no_02", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo01(JSPUtil.getParameter(request, prefix + "cntr_no_01", ""));
		setMvmtDt(JSPUtil.getParameter(request, prefix + "mvmt_dt", ""));
		setGateIoCd(JSPUtil.getParameter(request, prefix + "gate_io_cd", ""));
		setPChssNo(JSPUtil.getParameter(request, prefix + "p_chss_no", ""));
		setPMvmtDt(JSPUtil.getParameter(request, prefix + "p_mvmt_dt", "").replaceAll("-", ""));
		setPLocCd(JSPUtil.getParameter(request, prefix + "p_loc_cd", ""));
		setPYdCd(JSPUtil.getParameter(request, prefix + "p_yd_cd", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ShipCHSMvmtMGTVO[]
	 */
	public ShipCHSMvmtMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ShipCHSMvmtMGTVO[]
	 */
	public ShipCHSMvmtMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ShipCHSMvmtMGTVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] sysSeq01 = (JSPUtil.getParameter(request, prefix	+ "sys_seq_01", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] sysSeq02 = (JSPUtil.getParameter(request, prefix	+ "sys_seq_02", length));
			String[] cntSeq = (JSPUtil.getParameter(request, prefix	+ "cnt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lstSeq = (JSPUtil.getParameter(request, prefix	+ "lst_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] cntrNo02 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_02", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo01 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_01", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] gateIoCd = (JSPUtil.getParameter(request, prefix	+ "gate_io_cd", length));
			String[] pChssNo = (JSPUtil.getParameter(request, prefix	+ "p_chss_no", length));
			String[] pMvmtDt = (JSPUtil.getParameter(request, prefix	+ "p_mvmt_dt", length));
			String[] pLocCd = (JSPUtil.getParameter(request, prefix	+ "p_loc_cd", length));
			String[] pYdCd = (JSPUtil.getParameter(request, prefix	+ "p_yd_cd", length));

			for (int i = 0; i < length; i++) {
				model = new ShipCHSMvmtMGTVO();
				if (sysSeq01[i] != null)
					model.setSysSeq01(sysSeq01[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (sysSeq02[i] != null)
					model.setSysSeq02(sysSeq02[i]);
				if (cntSeq[i] != null)
					model.setCntSeq(cntSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lstSeq[i] != null)
					model.setLstSeq(lstSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cntrNo02[i] != null)
					model.setCntrNo02(cntrNo02[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo01[i] != null)
					model.setCntrNo01(cntrNo01[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (gateIoCd[i] != null)
					model.setGateIoCd(gateIoCd[i]);
				if (pChssNo[i] != null)
					model.setPChssNo(pChssNo[i]);
				if (pMvmtDt[i] != null)
					model.setPMvmtDt(pMvmtDt[i]);
				if (pLocCd[i] != null)
					model.setPLocCd(pLocCd[i]);
				if (pYdCd[i] != null)
					model.setPYdCd(pYdCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getShipCHSMvmtMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ShipCHSMvmtMGTVO[]
	 */
	public ShipCHSMvmtMGTVO[] getShipCHSMvmtMGTVOs(){
		ShipCHSMvmtMGTVO[] vos = (ShipCHSMvmtMGTVO[])models.toArray(new ShipCHSMvmtMGTVO[models.size()]);
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
		this.sysSeq01 = this.sysSeq01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSeq02 = this.sysSeq02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntSeq = this.cntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSeq = this.lstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo02 = this.cntrNo02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo01 = this.cntrNo01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIoCd = this.gateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pChssNo = this.pChssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pMvmtDt = this.pMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocCd = this.pLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYdCd = this.pYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
