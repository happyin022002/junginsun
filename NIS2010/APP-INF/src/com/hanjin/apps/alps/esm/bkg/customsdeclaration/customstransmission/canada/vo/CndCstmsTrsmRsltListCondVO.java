/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsTrsmRsltListCondVO.java
*@FileTitle : CndCstmsTrsmRsltListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.04 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsTrsmRsltListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsTrsmRsltListCondVO extends CstmsTrsmRsltListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsTrsmRsltListCondVO> models = new ArrayList<CndCstmsTrsmRsltListCondVO>();
	
	/* Column Info */
	private String totcountFlag = null;
	/* Column Info */
	private String cstmsTrsmStsCd = null;
	/* Column Info */
	private String rptFlag = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sSndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String sRcvDt = null;
	/* Column Info */
	private String eRcvDt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String subcmd = null;
	/* Column Info */
	private String cstmsAckProcRsltCd = null;
	/* Column Info */
	private String eSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsTrsmRsltListCondVO() {}

	public CndCstmsTrsmRsltListCondVO(String ibflag, String pagerows, String rptFlag, String vvdCd, String podCd, String polCd, String cstmsTrsmStsCd, String blNo, String sSndDt, String eSndDt, String cstmsAckProcRsltCd, String sRcvDt, String eRcvDt, String pageNo, String totcountFlag, String subcmd) {
		this.totcountFlag = totcountFlag;
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
		this.rptFlag = rptFlag;
		this.blNo = blNo;
		this.sSndDt = sSndDt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.sRcvDt = sRcvDt;
		this.eRcvDt = eRcvDt;
		this.vvdCd = vvdCd;
		this.pageNo = pageNo;
		this.subcmd = subcmd;
		this.cstmsAckProcRsltCd = cstmsAckProcRsltCd;
		this.eSndDt = eSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("totcount_flag", getTotcountFlag());
		this.hashColumns.put("cstms_trsm_sts_cd", getCstmsTrsmStsCd());
		this.hashColumns.put("rpt_flag", getRptFlag());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("s_snd_dt", getSSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("s_rcv_dt", getSRcvDt());
		this.hashColumns.put("e_rcv_dt", getERcvDt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("subcmd", getSubcmd());
		this.hashColumns.put("cstms_ack_proc_rslt_cd", getCstmsAckProcRsltCd());
		this.hashColumns.put("e_snd_dt", getESndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("totcount_flag", "totcountFlag");
		this.hashFields.put("cstms_trsm_sts_cd", "cstmsTrsmStsCd");
		this.hashFields.put("rpt_flag", "rptFlag");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("s_snd_dt", "sSndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("s_rcv_dt", "sRcvDt");
		this.hashFields.put("e_rcv_dt", "eRcvDt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("subcmd", "subcmd");
		this.hashFields.put("cstms_ack_proc_rslt_cd", "cstmsAckProcRsltCd");
		this.hashFields.put("e_snd_dt", "eSndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totcountFlag
	 */
	public String getTotcountFlag() {
		return this.totcountFlag;
	}
	
	/**
	 * Column Info
	 * @return cstmsTrsmStsCd
	 */
	public String getCstmsTrsmStsCd() {
		return this.cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @return rptFlag
	 */
	public String getRptFlag() {
		return this.rptFlag;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return sSndDt
	 */
	public String getSSndDt() {
		return this.sSndDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return sRcvDt
	 */
	public String getSRcvDt() {
		return this.sRcvDt;
	}
	
	/**
	 * Column Info
	 * @return eRcvDt
	 */
	public String getERcvDt() {
		return this.eRcvDt;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return subcmd
	 */
	public String getSubcmd() {
		return this.subcmd;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckProcRsltCd
	 */
	public String getCstmsAckProcRsltCd() {
		return this.cstmsAckProcRsltCd;
	}
	
	/**
	 * Column Info
	 * @return eSndDt
	 */
	public String getESndDt() {
		return this.eSndDt;
	}
	

	/**
	 * Column Info
	 * @param totcountFlag
	 */
	public void setTotcountFlag(String totcountFlag) {
		this.totcountFlag = totcountFlag;
	}
	
	/**
	 * Column Info
	 * @param cstmsTrsmStsCd
	 */
	public void setCstmsTrsmStsCd(String cstmsTrsmStsCd) {
		this.cstmsTrsmStsCd = cstmsTrsmStsCd;
	}
	
	/**
	 * Column Info
	 * @param rptFlag
	 */
	public void setRptFlag(String rptFlag) {
		this.rptFlag = rptFlag;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param sSndDt
	 */
	public void setSSndDt(String sSndDt) {
		this.sSndDt = sSndDt;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param sRcvDt
	 */
	public void setSRcvDt(String sRcvDt) {
		this.sRcvDt = sRcvDt;
	}
	
	/**
	 * Column Info
	 * @param eRcvDt
	 */
	public void setERcvDt(String eRcvDt) {
		this.eRcvDt = eRcvDt;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param subcmd
	 */
	public void setSubcmd(String subcmd) {
		this.subcmd = subcmd;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckProcRsltCd
	 */
	public void setCstmsAckProcRsltCd(String cstmsAckProcRsltCd) {
		this.cstmsAckProcRsltCd = cstmsAckProcRsltCd;
	}
	
	/**
	 * Column Info
	 * @param eSndDt
	 */
	public void setESndDt(String eSndDt) {
		this.eSndDt = eSndDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotcountFlag(JSPUtil.getParameter(request, "totcount_flag", ""));
		setCstmsTrsmStsCd(JSPUtil.getParameter(request, "cstms_trsm_sts_cd", ""));
		setRptFlag(JSPUtil.getParameter(request, "rpt_flag", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSSndDt(JSPUtil.getParameter(request, "s_snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSRcvDt(JSPUtil.getParameter(request, "s_rcv_dt", ""));
		setERcvDt(JSPUtil.getParameter(request, "e_rcv_dt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setSubcmd(JSPUtil.getParameter(request, "subcmd", ""));
		setCstmsAckProcRsltCd(JSPUtil.getParameter(request, "cstms_ack_proc_rslt_cd", ""));
		setESndDt(JSPUtil.getParameter(request, "e_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsTrsmRsltListCondVO[]
	 */
	public CndCstmsTrsmRsltListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsTrsmRsltListCondVO[]
	 */
	public CndCstmsTrsmRsltListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsTrsmRsltListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totcountFlag = (JSPUtil.getParameter(request, prefix	+ "totcount_flag".trim(), length));
			String[] cstmsTrsmStsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_trsm_sts_cd".trim(), length));
			String[] rptFlag = (JSPUtil.getParameter(request, prefix	+ "rpt_flag".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] sSndDt = (JSPUtil.getParameter(request, prefix	+ "s_snd_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] sRcvDt = (JSPUtil.getParameter(request, prefix	+ "s_rcv_dt".trim(), length));
			String[] eRcvDt = (JSPUtil.getParameter(request, prefix	+ "e_rcv_dt".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no".trim(), length));
			String[] subcmd = (JSPUtil.getParameter(request, prefix	+ "subcmd".trim(), length));
			String[] cstmsAckProcRsltCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_proc_rslt_cd".trim(), length));
			String[] eSndDt = (JSPUtil.getParameter(request, prefix	+ "e_snd_dt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsTrsmRsltListCondVO();
				if (totcountFlag[i] != null)
					model.setTotcountFlag(totcountFlag[i]);
				if (cstmsTrsmStsCd[i] != null)
					model.setCstmsTrsmStsCd(cstmsTrsmStsCd[i]);
				if (rptFlag[i] != null)
					model.setRptFlag(rptFlag[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sSndDt[i] != null)
					model.setSSndDt(sSndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (sRcvDt[i] != null)
					model.setSRcvDt(sRcvDt[i]);
				if (eRcvDt[i] != null)
					model.setERcvDt(eRcvDt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (subcmd[i] != null)
					model.setSubcmd(subcmd[i]);
				if (cstmsAckProcRsltCd[i] != null)
					model.setCstmsAckProcRsltCd(cstmsAckProcRsltCd[i]);
				if (eSndDt[i] != null)
					model.setESndDt(eSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsTrsmRsltListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsTrsmRsltListCondVO[]
	 */
	public CndCstmsTrsmRsltListCondVO[] getCndCstmsTrsmRsltListCondVOs(){
		CndCstmsTrsmRsltListCondVO[] vos = (CndCstmsTrsmRsltListCondVO[])models.toArray(new CndCstmsTrsmRsltListCondVO[models.size()]);
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
		this.totcountFlag = this.totcountFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsTrsmStsCd = this.cstmsTrsmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptFlag = this.rptFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSndDt = this.sSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRcvDt = this.sRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eRcvDt = this.eRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subcmd = this.subcmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckProcRsltCd = this.cstmsAckProcRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eSndDt = this.eSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
