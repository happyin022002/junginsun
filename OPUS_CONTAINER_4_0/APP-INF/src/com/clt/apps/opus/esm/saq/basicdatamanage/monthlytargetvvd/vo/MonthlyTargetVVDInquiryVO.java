/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyTargetVVDInquiryVO.java
*@FileTitle      : MonthlyTargetVVDInquiryVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonthlyTargetVVDInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonthlyTargetVVDInquiryVO> models = new ArrayList<MonthlyTargetVVDInquiryVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String sprtGrpCd = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String updRmk = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bsaGrpCd = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String subTrdCd = null;
	/* 추가구성 시작 */
	private Object conditionVO = null;
	/* 추가구성 끝 */

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonthlyTargetVVDInquiryVO() {}

	public MonthlyTargetVVDInquiryVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String trdCd, String rlaneCd, String dirCd, String vslCd, String skdVoyNo, String skdDirCd, String sprtGrpCd, String bsaGrpCd, String bseMon, String bseWk, String subTrdCd, String iocCd, String vvdSeq, String fnlBsaCapa, String lstLodgPortEtdDt, String updRmk, String lstLodgPortCd, String deltFlg) {
		this.iocCd = iocCd;
		this.vslCd = vslCd;
		this.deltFlg = deltFlg;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.bseWk = bseWk;
		this.sprtGrpCd = sprtGrpCd;
		this.fnlBsaCapa = fnlBsaCapa;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.bseQtrCd = bseQtrCd;
		this.bseMon = bseMon;
		this.ibflag = ibflag;
		this.updRmk = updRmk;
		this.dirCd = dirCd;
		this.bsaGrpCd = bsaGrpCd;
		this.lstLodgPortCd = lstLodgPortCd;
		this.vvdSeq = vvdSeq;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_rmk", getUpdRmk());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bsa_grp_cd", getBsaGrpCd());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_rmk", "updRmk");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bsa_grp_cd", "bsaGrpCd");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return sprtGrpCd
	 */
	public String getSprtGrpCd() {
		return this.sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return lstLodgPortEtdDt
	 */
	public String getLstLodgPortEtdDt() {
		return this.lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return updRmk
	 */
	public String getUpdRmk() {
		return this.updRmk;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return bsaGrpCd
	 */
	public String getBsaGrpCd() {
		return this.bsaGrpCd;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param sprtGrpCd
	 */
	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * Column Info
	 * @param lstLodgPortEtdDt
	 */
	public void setLstLodgPortEtdDt(String lstLodgPortEtdDt) {
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param updRmk
	 */
	public void setUpdRmk(String updRmk) {
		this.updRmk = updRmk;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param bsaGrpCd
	 */
	public void setBsaGrpCd(String bsaGrpCd) {
		this.bsaGrpCd = bsaGrpCd;
	}
	
	/**
	 * Column Info 
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/* 추가구성 시작 */
	/**
	 * @return the Object
	 */
	public Object getConditionVO() {
		return conditionVO;
	}

	/**
	 * @param Object conditionVO
	 */
	public void setConditionVO(Object conditionVO) {
		this.conditionVO =  conditionVO;
	}
	/* 추가구성 끝 */

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setBseWk(JSPUtil.getParameter(request, "bse_wk", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, "sprt_grp_cd", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, "fnl_bsa_capa", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, "lst_lodg_port_etd_dt", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdRmk(JSPUtil.getParameter(request, "upd_rmk", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setBsaGrpCd(JSPUtil.getParameter(request, "bsa_grp_cd", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, "lst_lodg_port_cd", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonthlyTargetVVDInquiryVO[]
	 */
	public MonthlyTargetVVDInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonthlyTargetVVDInquiryVO[]
	 */
	public MonthlyTargetVVDInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonthlyTargetVVDInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updRmk = (JSPUtil.getParameter(request, prefix	+ "upd_rmk", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bsaGrpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_grp_cd", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			

			for (int i = 0; i < length; i++) {
				model = new MonthlyTargetVVDInquiryVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (sprtGrpCd[i] != null)
					model.setSprtGrpCd(sprtGrpCd[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updRmk[i] != null)
					model.setUpdRmk(updRmk[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bsaGrpCd[i] != null)
					model.setBsaGrpCd(bsaGrpCd[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonthlyTargetVVDInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonthlyTargetVVDInquiryVO[]
	 */
	public MonthlyTargetVVDInquiryVO[] getMonthlyTargetVVDInquiryVOs(){
		MonthlyTargetVVDInquiryVO[] vos = (MonthlyTargetVVDInquiryVO[])models.toArray(new MonthlyTargetVVDInquiryVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updRmk = this.updRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGrpCd = this.bsaGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
