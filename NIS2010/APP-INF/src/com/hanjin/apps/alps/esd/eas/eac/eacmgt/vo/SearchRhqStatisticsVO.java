/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchRhqStatisticsVO.java
*@FileTitle : SearchRhqStatisticsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.12.02 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */


public class SearchRhqStatisticsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRhqStatisticsVO> models = new ArrayList<SearchRhqStatisticsVO>();
	
	/* Column Info */
	private String mOtrCnt = null;
	/* Column Info */
	private String mBilUmchAmt = null;
	/* Column Info */
	private String iWrkOrdAmt = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String mLackEvidCnt = null;
	/* Column Info */
	private String mDblBilUmchCnt = null;
	/* Column Info */
	private String iBkgCnt = null;
	/* Column Info */
	private String iCtrtAmt = null;
	/* Column Info */
	private String mSubTotCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String iOpAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String iOtrAmt = null;
	/* Column Info */
	private String iBkgAmt = null;
	/* Column Info */
	private String iSubTotAmt = null;
	/* Column Info */
	private String misTpbCnt = null;
	/* Column Info */
	private String misTpbAmt = null;
	/* Column Info */
	private String iSysCnt = null;
	/* Column Info */
	private String iSubTotCnt = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String mSubTotAmt = null;
	/* Column Info */
	private String mOtrAmt = null;
	/* Column Info */
	private String mRtDisUmchCnt = null;
	/* Column Info */
	private String mNotAcctUmchAmt = null;
	/* Column Info */
	private String mBilUmchCnt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String colorCd = null;
	/* Column Info */
	private String iCtrtCnt = null;
	/* Column Info */
	private String mDblBilUmchAmt = null;
	/* Column Info */
	private String mLackEvidAmt = null;
	/* Column Info */
	private String mRtDisUmchAmt = null;
	/* Column Info */
	private String iOtrCnt = null;
	/* Column Info */
	private String mNotAcctUmchCnt = null;
	/* Column Info */
	private String iSysAmt = null;
	/* Column Info */
	private String iWrkOrdCnt = null;
	/* Column Info */
	private String iOpCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchRhqStatisticsVO() {}

	public SearchRhqStatisticsVO(String ibflag, String pagerows, String rhqOfcCd, String mBilUmchCnt, String mBilUmchAmt, String mRtDisUmchCnt, String mRtDisUmchAmt, String mDblBilUmchCnt, String mDblBilUmchAmt, String mNotAcctUmchCnt, String mNotAcctUmchAmt, String mLackEvidCnt, String mLackEvidAmt, String mOtrCnt, String mOtrAmt, String mSubTotCnt, String mSubTotAmt, String iBkgCnt, String iBkgAmt, String iWrkOrdCnt, String iWrkOrdAmt, String iOpCnt, String iOpAmt, String iCtrtCnt, String iCtrtAmt, String iSysCnt, String iSysAmt, String iOtrCnt, String iOtrAmt, String iSubTotCnt, String iSubTotAmt, String misTpbCnt, String misTpbAmt, String totCnt, String totAmt, String colorCd) {
		this.mOtrCnt = mOtrCnt;
		this.mBilUmchAmt = mBilUmchAmt;
		this.iWrkOrdAmt = iWrkOrdAmt;
		this.totAmt = totAmt;
		this.mLackEvidCnt = mLackEvidCnt;
		this.mDblBilUmchCnt = mDblBilUmchCnt;
		this.iBkgCnt = iBkgCnt;
		this.iCtrtAmt = iCtrtAmt;
		this.mSubTotCnt = mSubTotCnt;
		this.pagerows = pagerows;
		this.iOpAmt = iOpAmt;
		this.ibflag = ibflag;
		this.iOtrAmt = iOtrAmt;
		this.iBkgAmt = iBkgAmt;
		this.iSubTotAmt = iSubTotAmt;
		this.misTpbCnt = misTpbCnt;
		this.misTpbAmt = misTpbAmt;
		this.iSysCnt = iSysCnt;
		this.iSubTotCnt = iSubTotCnt;
		this.totCnt = totCnt;
		this.mSubTotAmt = mSubTotAmt;
		this.mOtrAmt = mOtrAmt;
		this.mRtDisUmchCnt = mRtDisUmchCnt;
		this.mNotAcctUmchAmt = mNotAcctUmchAmt;
		this.mBilUmchCnt = mBilUmchCnt;
		this.rhqOfcCd = rhqOfcCd;
		this.colorCd = colorCd;
		this.iCtrtCnt = iCtrtCnt;
		this.mDblBilUmchAmt = mDblBilUmchAmt;
		this.mLackEvidAmt = mLackEvidAmt;
		this.mRtDisUmchAmt = mRtDisUmchAmt;
		this.iOtrCnt = iOtrCnt;
		this.mNotAcctUmchCnt = mNotAcctUmchCnt;
		this.iSysAmt = iSysAmt;
		this.iWrkOrdCnt = iWrkOrdCnt;
		this.iOpCnt = iOpCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("m_otr_cnt", getMOtrCnt());
		this.hashColumns.put("m_bil_umch_amt", getMBilUmchAmt());
		this.hashColumns.put("i_wrk_ord_amt", getIWrkOrdAmt());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("m_lack_evid_cnt", getMLackEvidCnt());
		this.hashColumns.put("m_dbl_bil_umch_cnt", getMDblBilUmchCnt());
		this.hashColumns.put("i_bkg_cnt", getIBkgCnt());
		this.hashColumns.put("i_ctrt_amt", getICtrtAmt());
		this.hashColumns.put("m_sub_tot_cnt", getMSubTotCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("i_op_amt", getIOpAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("i_otr_amt", getIOtrAmt());
		this.hashColumns.put("i_bkg_amt", getIBkgAmt());
		this.hashColumns.put("i_sub_tot_amt", getISubTotAmt());
		this.hashColumns.put("mis_tpb_cnt", getMisTpbCnt());
		this.hashColumns.put("mis_tpb_amt", getMisTpbAmt());
		this.hashColumns.put("i_sys_cnt", getISysCnt());
		this.hashColumns.put("i_sub_tot_cnt", getISubTotCnt());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("m_sub_tot_amt", getMSubTotAmt());
		this.hashColumns.put("m_otr_amt", getMOtrAmt());
		this.hashColumns.put("m_rt_dis_umch_cnt", getMRtDisUmchCnt());
		this.hashColumns.put("m_not_acct_umch_amt", getMNotAcctUmchAmt());
		this.hashColumns.put("m_bil_umch_cnt", getMBilUmchCnt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("color_cd", getColorCd());
		this.hashColumns.put("i_ctrt_cnt", getICtrtCnt());
		this.hashColumns.put("m_dbl_bil_umch_amt", getMDblBilUmchAmt());
		this.hashColumns.put("m_lack_evid_amt", getMLackEvidAmt());
		this.hashColumns.put("m_rt_dis_umch_amt", getMRtDisUmchAmt());
		this.hashColumns.put("i_otr_cnt", getIOtrCnt());
		this.hashColumns.put("m_not_acct_umch_cnt", getMNotAcctUmchCnt());
		this.hashColumns.put("i_sys_amt", getISysAmt());
		this.hashColumns.put("i_wrk_ord_cnt", getIWrkOrdCnt());
		this.hashColumns.put("i_op_cnt", getIOpCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("m_otr_cnt", "mOtrCnt");
		this.hashFields.put("m_bil_umch_amt", "mBilUmchAmt");
		this.hashFields.put("i_wrk_ord_amt", "iWrkOrdAmt");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("m_lack_evid_cnt", "mLackEvidCnt");
		this.hashFields.put("m_dbl_bil_umch_cnt", "mDblBilUmchCnt");
		this.hashFields.put("i_bkg_cnt", "iBkgCnt");
		this.hashFields.put("i_ctrt_amt", "iCtrtAmt");
		this.hashFields.put("m_sub_tot_cnt", "mSubTotCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("i_op_amt", "iOpAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("i_otr_amt", "iOtrAmt");
		this.hashFields.put("i_bkg_amt", "iBkgAmt");
		this.hashFields.put("i_sub_tot_amt", "iSubTotAmt");
		this.hashFields.put("mis_tpb_cnt", "misTpbCnt");
		this.hashFields.put("mis_tpb_amt", "misTpbAmt");
		this.hashFields.put("i_sys_cnt", "iSysCnt");
		this.hashFields.put("i_sub_tot_cnt", "iSubTotCnt");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("m_sub_tot_amt", "mSubTotAmt");
		this.hashFields.put("m_otr_amt", "mOtrAmt");
		this.hashFields.put("m_rt_dis_umch_cnt", "mRtDisUmchCnt");
		this.hashFields.put("m_not_acct_umch_amt", "mNotAcctUmchAmt");
		this.hashFields.put("m_bil_umch_cnt", "mBilUmchCnt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("color_cd", "colorCd");
		this.hashFields.put("i_ctrt_cnt", "iCtrtCnt");
		this.hashFields.put("m_dbl_bil_umch_amt", "mDblBilUmchAmt");
		this.hashFields.put("m_lack_evid_amt", "mLackEvidAmt");
		this.hashFields.put("m_rt_dis_umch_amt", "mRtDisUmchAmt");
		this.hashFields.put("i_otr_cnt", "iOtrCnt");
		this.hashFields.put("m_not_acct_umch_cnt", "mNotAcctUmchCnt");
		this.hashFields.put("i_sys_amt", "iSysAmt");
		this.hashFields.put("i_wrk_ord_cnt", "iWrkOrdCnt");
		this.hashFields.put("i_op_cnt", "iOpCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mOtrCnt
	 */
	public String getMOtrCnt() {
		return this.mOtrCnt;
	}
	
	/**
	 * Column Info
	 * @return mBilUmchAmt
	 */
	public String getMBilUmchAmt() {
		return this.mBilUmchAmt;
	}
	
	/**
	 * Column Info
	 * @return iWrkOrdAmt
	 */
	public String getIWrkOrdAmt() {
		return this.iWrkOrdAmt;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return mLackEvidCnt
	 */
	public String getMLackEvidCnt() {
		return this.mLackEvidCnt;
	}
	
	/**
	 * Column Info
	 * @return mDblBilUmchCnt
	 */
	public String getMDblBilUmchCnt() {
		return this.mDblBilUmchCnt;
	}
	
	/**
	 * Column Info
	 * @return iBkgCnt
	 */
	public String getIBkgCnt() {
		return this.iBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return iCtrtAmt
	 */
	public String getICtrtAmt() {
		return this.iCtrtAmt;
	}
	
	/**
	 * Column Info
	 * @return mSubTotCnt
	 */
	public String getMSubTotCnt() {
		return this.mSubTotCnt;
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
	 * @return iOpAmt
	 */
	public String getIOpAmt() {
		return this.iOpAmt;
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
	 * @return iOtrAmt
	 */
	public String getIOtrAmt() {
		return this.iOtrAmt;
	}
	
	/**
	 * Column Info
	 * @return iBkgAmt
	 */
	public String getIBkgAmt() {
		return this.iBkgAmt;
	}
	
	/**
	 * Column Info
	 * @return iSubTotAmt
	 */
	public String getISubTotAmt() {
		return this.iSubTotAmt;
	}
	
	/**
	 * Column Info
	 * @return misTpbCnt
	 */
	public String getMisTpbCnt() {
		return this.misTpbCnt;
	}
	
	/**
	 * Column Info
	 * @return misTpbAmt
	 */
	public String getMisTpbAmt() {
		return this.misTpbAmt;
	}
	
	/**
	 * Column Info
	 * @return iSysCnt
	 */
	public String getISysCnt() {
		return this.iSysCnt;
	}
	
	/**
	 * Column Info
	 * @return iSubTotCnt
	 */
	public String getISubTotCnt() {
		return this.iSubTotCnt;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return mSubTotAmt
	 */
	public String getMSubTotAmt() {
		return this.mSubTotAmt;
	}
	
	/**
	 * Column Info
	 * @return mOtrAmt
	 */
	public String getMOtrAmt() {
		return this.mOtrAmt;
	}
	
	/**
	 * Column Info
	 * @return mRtDisUmchCnt
	 */
	public String getMRtDisUmchCnt() {
		return this.mRtDisUmchCnt;
	}
	
	/**
	 * Column Info
	 * @return mNotAcctUmchAmt
	 */
	public String getMNotAcctUmchAmt() {
		return this.mNotAcctUmchAmt;
	}
	
	/**
	 * Column Info
	 * @return mBilUmchCnt
	 */
	public String getMBilUmchCnt() {
		return this.mBilUmchCnt;
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
	 * @return colorCd
	 */
	public String getColorCd() {
		return this.colorCd;
	}
	
	/**
	 * Column Info
	 * @return iCtrtCnt
	 */
	public String getICtrtCnt() {
		return this.iCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @return mDblBilUmchAmt
	 */
	public String getMDblBilUmchAmt() {
		return this.mDblBilUmchAmt;
	}
	
	/**
	 * Column Info
	 * @return mLackEvidAmt
	 */
	public String getMLackEvidAmt() {
		return this.mLackEvidAmt;
	}
	
	/**
	 * Column Info
	 * @return mRtDisUmchAmt
	 */
	public String getMRtDisUmchAmt() {
		return this.mRtDisUmchAmt;
	}
	
	/**
	 * Column Info
	 * @return iOtrCnt
	 */
	public String getIOtrCnt() {
		return this.iOtrCnt;
	}
	
	/**
	 * Column Info
	 * @return mNotAcctUmchCnt
	 */
	public String getMNotAcctUmchCnt() {
		return this.mNotAcctUmchCnt;
	}
	
	/**
	 * Column Info
	 * @return iSysAmt
	 */
	public String getISysAmt() {
		return this.iSysAmt;
	}
	
	/**
	 * Column Info
	 * @return iWrkOrdCnt
	 */
	public String getIWrkOrdCnt() {
		return this.iWrkOrdCnt;
	}
	
	/**
	 * Column Info
	 * @return iOpCnt
	 */
	public String getIOpCnt() {
		return this.iOpCnt;
	}
	

	/**
	 * Column Info
	 * @param mOtrCnt
	 */
	public void setMOtrCnt(String mOtrCnt) {
		this.mOtrCnt = mOtrCnt;
	}
	
	/**
	 * Column Info
	 * @param mBilUmchAmt
	 */
	public void setMBilUmchAmt(String mBilUmchAmt) {
		this.mBilUmchAmt = mBilUmchAmt;
	}
	
	/**
	 * Column Info
	 * @param iWrkOrdAmt
	 */
	public void setIWrkOrdAmt(String iWrkOrdAmt) {
		this.iWrkOrdAmt = iWrkOrdAmt;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param mLackEvidCnt
	 */
	public void setMLackEvidCnt(String mLackEvidCnt) {
		this.mLackEvidCnt = mLackEvidCnt;
	}
	
	/**
	 * Column Info
	 * @param mDblBilUmchCnt
	 */
	public void setMDblBilUmchCnt(String mDblBilUmchCnt) {
		this.mDblBilUmchCnt = mDblBilUmchCnt;
	}
	
	/**
	 * Column Info
	 * @param iBkgCnt
	 */
	public void setIBkgCnt(String iBkgCnt) {
		this.iBkgCnt = iBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param iCtrtAmt
	 */
	public void setICtrtAmt(String iCtrtAmt) {
		this.iCtrtAmt = iCtrtAmt;
	}
	
	/**
	 * Column Info
	 * @param mSubTotCnt
	 */
	public void setMSubTotCnt(String mSubTotCnt) {
		this.mSubTotCnt = mSubTotCnt;
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
	 * @param iOpAmt
	 */
	public void setIOpAmt(String iOpAmt) {
		this.iOpAmt = iOpAmt;
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
	 * @param iOtrAmt
	 */
	public void setIOtrAmt(String iOtrAmt) {
		this.iOtrAmt = iOtrAmt;
	}
	
	/**
	 * Column Info
	 * @param iBkgAmt
	 */
	public void setIBkgAmt(String iBkgAmt) {
		this.iBkgAmt = iBkgAmt;
	}
	
	/**
	 * Column Info
	 * @param iSubTotAmt
	 */
	public void setISubTotAmt(String iSubTotAmt) {
		this.iSubTotAmt = iSubTotAmt;
	}
	
	/**
	 * Column Info
	 * @param misTpbCnt
	 */
	public void setMisTpbCnt(String misTpbCnt) {
		this.misTpbCnt = misTpbCnt;
	}
	
	/**
	 * Column Info
	 * @param misTpbAmt
	 */
	public void setMisTpbAmt(String misTpbAmt) {
		this.misTpbAmt = misTpbAmt;
	}
	
	/**
	 * Column Info
	 * @param iSysCnt
	 */
	public void setISysCnt(String iSysCnt) {
		this.iSysCnt = iSysCnt;
	}
	
	/**
	 * Column Info
	 * @param iSubTotCnt
	 */
	public void setISubTotCnt(String iSubTotCnt) {
		this.iSubTotCnt = iSubTotCnt;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param mSubTotAmt
	 */
	public void setMSubTotAmt(String mSubTotAmt) {
		this.mSubTotAmt = mSubTotAmt;
	}
	
	/**
	 * Column Info
	 * @param mOtrAmt
	 */
	public void setMOtrAmt(String mOtrAmt) {
		this.mOtrAmt = mOtrAmt;
	}
	
	/**
	 * Column Info
	 * @param mRtDisUmchCnt
	 */
	public void setMRtDisUmchCnt(String mRtDisUmchCnt) {
		this.mRtDisUmchCnt = mRtDisUmchCnt;
	}
	
	/**
	 * Column Info
	 * @param mNotAcctUmchAmt
	 */
	public void setMNotAcctUmchAmt(String mNotAcctUmchAmt) {
		this.mNotAcctUmchAmt = mNotAcctUmchAmt;
	}
	
	/**
	 * Column Info
	 * @param mBilUmchCnt
	 */
	public void setMBilUmchCnt(String mBilUmchCnt) {
		this.mBilUmchCnt = mBilUmchCnt;
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
	 * @param colorCd
	 */
	public void setColorCd(String colorCd) {
		this.colorCd = colorCd;
	}
	
	/**
	 * Column Info
	 * @param iCtrtCnt
	 */
	public void setICtrtCnt(String iCtrtCnt) {
		this.iCtrtCnt = iCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @param mDblBilUmchAmt
	 */
	public void setMDblBilUmchAmt(String mDblBilUmchAmt) {
		this.mDblBilUmchAmt = mDblBilUmchAmt;
	}
	
	/**
	 * Column Info
	 * @param mLackEvidAmt
	 */
	public void setMLackEvidAmt(String mLackEvidAmt) {
		this.mLackEvidAmt = mLackEvidAmt;
	}
	
	/**
	 * Column Info
	 * @param mRtDisUmchAmt
	 */
	public void setMRtDisUmchAmt(String mRtDisUmchAmt) {
		this.mRtDisUmchAmt = mRtDisUmchAmt;
	}
	
	/**
	 * Column Info
	 * @param iOtrCnt
	 */
	public void setIOtrCnt(String iOtrCnt) {
		this.iOtrCnt = iOtrCnt;
	}
	
	/**
	 * Column Info
	 * @param mNotAcctUmchCnt
	 */
	public void setMNotAcctUmchCnt(String mNotAcctUmchCnt) {
		this.mNotAcctUmchCnt = mNotAcctUmchCnt;
	}
	
	/**
	 * Column Info
	 * @param iSysAmt
	 */
	public void setISysAmt(String iSysAmt) {
		this.iSysAmt = iSysAmt;
	}
	
	/**
	 * Column Info
	 * @param iWrkOrdCnt
	 */
	public void setIWrkOrdCnt(String iWrkOrdCnt) {
		this.iWrkOrdCnt = iWrkOrdCnt;
	}
	
	/**
	 * Column Info
	 * @param iOpCnt
	 */
	public void setIOpCnt(String iOpCnt) {
		this.iOpCnt = iOpCnt;
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
		setMOtrCnt(JSPUtil.getParameter(request, prefix + "m_otr_cnt", ""));
		setMBilUmchAmt(JSPUtil.getParameter(request, prefix + "m_bil_umch_amt", ""));
		setIWrkOrdAmt(JSPUtil.getParameter(request, prefix + "i_wrk_ord_amt", ""));
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setMLackEvidCnt(JSPUtil.getParameter(request, prefix + "m_lack_evid_cnt", ""));
		setMDblBilUmchCnt(JSPUtil.getParameter(request, prefix + "m_dbl_bil_umch_cnt", ""));
		setIBkgCnt(JSPUtil.getParameter(request, prefix + "i_bkg_cnt", ""));
		setICtrtAmt(JSPUtil.getParameter(request, prefix + "i_ctrt_amt", ""));
		setMSubTotCnt(JSPUtil.getParameter(request, prefix + "m_sub_tot_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIOpAmt(JSPUtil.getParameter(request, prefix + "i_op_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIOtrAmt(JSPUtil.getParameter(request, prefix + "i_otr_amt", ""));
		setIBkgAmt(JSPUtil.getParameter(request, prefix + "i_bkg_amt", ""));
		setISubTotAmt(JSPUtil.getParameter(request, prefix + "i_sub_tot_amt", ""));
		setMisTpbCnt(JSPUtil.getParameter(request, prefix + "mis_tpb_cnt", ""));
		setMisTpbAmt(JSPUtil.getParameter(request, prefix + "mis_tpb_amt", ""));
		setISysCnt(JSPUtil.getParameter(request, prefix + "i_sys_cnt", ""));
		setISubTotCnt(JSPUtil.getParameter(request, prefix + "i_sub_tot_cnt", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setMSubTotAmt(JSPUtil.getParameter(request, prefix + "m_sub_tot_amt", ""));
		setMOtrAmt(JSPUtil.getParameter(request, prefix + "m_otr_amt", ""));
		setMRtDisUmchCnt(JSPUtil.getParameter(request, prefix + "m_rt_dis_umch_cnt", ""));
		setMNotAcctUmchAmt(JSPUtil.getParameter(request, prefix + "m_not_acct_umch_amt", ""));
		setMBilUmchCnt(JSPUtil.getParameter(request, prefix + "m_bil_umch_cnt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setColorCd(JSPUtil.getParameter(request, prefix + "color_cd", ""));
		setICtrtCnt(JSPUtil.getParameter(request, prefix + "i_ctrt_cnt", ""));
		setMDblBilUmchAmt(JSPUtil.getParameter(request, prefix + "m_dbl_bil_umch_amt", ""));
		setMLackEvidAmt(JSPUtil.getParameter(request, prefix + "m_lack_evid_amt", ""));
		setMRtDisUmchAmt(JSPUtil.getParameter(request, prefix + "m_rt_dis_umch_amt", ""));
		setIOtrCnt(JSPUtil.getParameter(request, prefix + "i_otr_cnt", ""));
		setMNotAcctUmchCnt(JSPUtil.getParameter(request, prefix + "m_not_acct_umch_cnt", ""));
		setISysAmt(JSPUtil.getParameter(request, prefix + "i_sys_amt", ""));
		setIWrkOrdCnt(JSPUtil.getParameter(request, prefix + "i_wrk_ord_cnt", ""));
		setIOpCnt(JSPUtil.getParameter(request, prefix + "i_op_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRhqStatisticsVO[]
	 */
	public SearchRhqStatisticsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRhqStatisticsVO[]
	 */
	public SearchRhqStatisticsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRhqStatisticsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mOtrCnt = (JSPUtil.getParameter(request, prefix	+ "m_otr_cnt", length));
			String[] mBilUmchAmt = (JSPUtil.getParameter(request, prefix	+ "m_bil_umch_amt", length));
			String[] iWrkOrdAmt = (JSPUtil.getParameter(request, prefix	+ "i_wrk_ord_amt", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] mLackEvidCnt = (JSPUtil.getParameter(request, prefix	+ "m_lack_evid_cnt", length));
			String[] mDblBilUmchCnt = (JSPUtil.getParameter(request, prefix	+ "m_dbl_bil_umch_cnt", length));
			String[] iBkgCnt = (JSPUtil.getParameter(request, prefix	+ "i_bkg_cnt", length));
			String[] iCtrtAmt = (JSPUtil.getParameter(request, prefix	+ "i_ctrt_amt", length));
			String[] mSubTotCnt = (JSPUtil.getParameter(request, prefix	+ "m_sub_tot_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] iOpAmt = (JSPUtil.getParameter(request, prefix	+ "i_op_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] iOtrAmt = (JSPUtil.getParameter(request, prefix	+ "i_otr_amt", length));
			String[] iBkgAmt = (JSPUtil.getParameter(request, prefix	+ "i_bkg_amt", length));
			String[] iSubTotAmt = (JSPUtil.getParameter(request, prefix	+ "i_sub_tot_amt", length));
			String[] misTpbCnt = (JSPUtil.getParameter(request, prefix	+ "mis_tpb_cnt", length));
			String[] misTpbAmt = (JSPUtil.getParameter(request, prefix	+ "mis_tpb_amt", length));
			String[] iSysCnt = (JSPUtil.getParameter(request, prefix	+ "i_sys_cnt", length));
			String[] iSubTotCnt = (JSPUtil.getParameter(request, prefix	+ "i_sub_tot_cnt", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] mSubTotAmt = (JSPUtil.getParameter(request, prefix	+ "m_sub_tot_amt", length));
			String[] mOtrAmt = (JSPUtil.getParameter(request, prefix	+ "m_otr_amt", length));
			String[] mRtDisUmchCnt = (JSPUtil.getParameter(request, prefix	+ "m_rt_dis_umch_cnt", length));
			String[] mNotAcctUmchAmt = (JSPUtil.getParameter(request, prefix	+ "m_not_acct_umch_amt", length));
			String[] mBilUmchCnt = (JSPUtil.getParameter(request, prefix	+ "m_bil_umch_cnt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] colorCd = (JSPUtil.getParameter(request, prefix	+ "color_cd", length));
			String[] iCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "i_ctrt_cnt", length));
			String[] mDblBilUmchAmt = (JSPUtil.getParameter(request, prefix	+ "m_dbl_bil_umch_amt", length));
			String[] mLackEvidAmt = (JSPUtil.getParameter(request, prefix	+ "m_lack_evid_amt", length));
			String[] mRtDisUmchAmt = (JSPUtil.getParameter(request, prefix	+ "m_rt_dis_umch_amt", length));
			String[] iOtrCnt = (JSPUtil.getParameter(request, prefix	+ "i_otr_cnt", length));
			String[] mNotAcctUmchCnt = (JSPUtil.getParameter(request, prefix	+ "m_not_acct_umch_cnt", length));
			String[] iSysAmt = (JSPUtil.getParameter(request, prefix	+ "i_sys_amt", length));
			String[] iWrkOrdCnt = (JSPUtil.getParameter(request, prefix	+ "i_wrk_ord_cnt", length));
			String[] iOpCnt = (JSPUtil.getParameter(request, prefix	+ "i_op_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRhqStatisticsVO();
				if (mOtrCnt[i] != null)
					model.setMOtrCnt(mOtrCnt[i]);
				if (mBilUmchAmt[i] != null)
					model.setMBilUmchAmt(mBilUmchAmt[i]);
				if (iWrkOrdAmt[i] != null)
					model.setIWrkOrdAmt(iWrkOrdAmt[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (mLackEvidCnt[i] != null)
					model.setMLackEvidCnt(mLackEvidCnt[i]);
				if (mDblBilUmchCnt[i] != null)
					model.setMDblBilUmchCnt(mDblBilUmchCnt[i]);
				if (iBkgCnt[i] != null)
					model.setIBkgCnt(iBkgCnt[i]);
				if (iCtrtAmt[i] != null)
					model.setICtrtAmt(iCtrtAmt[i]);
				if (mSubTotCnt[i] != null)
					model.setMSubTotCnt(mSubTotCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (iOpAmt[i] != null)
					model.setIOpAmt(iOpAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iOtrAmt[i] != null)
					model.setIOtrAmt(iOtrAmt[i]);
				if (iBkgAmt[i] != null)
					model.setIBkgAmt(iBkgAmt[i]);
				if (iSubTotAmt[i] != null)
					model.setISubTotAmt(iSubTotAmt[i]);
				if (misTpbCnt[i] != null)
					model.setMisTpbCnt(misTpbCnt[i]);
				if (misTpbAmt[i] != null)
					model.setMisTpbAmt(misTpbAmt[i]);
				if (iSysCnt[i] != null)
					model.setISysCnt(iSysCnt[i]);
				if (iSubTotCnt[i] != null)
					model.setISubTotCnt(iSubTotCnt[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (mSubTotAmt[i] != null)
					model.setMSubTotAmt(mSubTotAmt[i]);
				if (mOtrAmt[i] != null)
					model.setMOtrAmt(mOtrAmt[i]);
				if (mRtDisUmchCnt[i] != null)
					model.setMRtDisUmchCnt(mRtDisUmchCnt[i]);
				if (mNotAcctUmchAmt[i] != null)
					model.setMNotAcctUmchAmt(mNotAcctUmchAmt[i]);
				if (mBilUmchCnt[i] != null)
					model.setMBilUmchCnt(mBilUmchCnt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (colorCd[i] != null)
					model.setColorCd(colorCd[i]);
				if (iCtrtCnt[i] != null)
					model.setICtrtCnt(iCtrtCnt[i]);
				if (mDblBilUmchAmt[i] != null)
					model.setMDblBilUmchAmt(mDblBilUmchAmt[i]);
				if (mLackEvidAmt[i] != null)
					model.setMLackEvidAmt(mLackEvidAmt[i]);
				if (mRtDisUmchAmt[i] != null)
					model.setMRtDisUmchAmt(mRtDisUmchAmt[i]);
				if (iOtrCnt[i] != null)
					model.setIOtrCnt(iOtrCnt[i]);
				if (mNotAcctUmchCnt[i] != null)
					model.setMNotAcctUmchCnt(mNotAcctUmchCnt[i]);
				if (iSysAmt[i] != null)
					model.setISysAmt(iSysAmt[i]);
				if (iWrkOrdCnt[i] != null)
					model.setIWrkOrdCnt(iWrkOrdCnt[i]);
				if (iOpCnt[i] != null)
					model.setIOpCnt(iOpCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRhqStatisticsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRhqStatisticsVO[]
	 */
	public SearchRhqStatisticsVO[] getSearchRhqStatisticsVOs(){
		SearchRhqStatisticsVO[] vos = (SearchRhqStatisticsVO[])models.toArray(new SearchRhqStatisticsVO[models.size()]);
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
		this.mOtrCnt = this.mOtrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mBilUmchAmt = this.mBilUmchAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iWrkOrdAmt = this.iWrkOrdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mLackEvidCnt = this.mLackEvidCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mDblBilUmchCnt = this.mDblBilUmchCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iBkgCnt = this.iBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iCtrtAmt = this.iCtrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mSubTotCnt = this.mSubTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOpAmt = this.iOpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOtrAmt = this.iOtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iBkgAmt = this.iBkgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSubTotAmt = this.iSubTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misTpbCnt = this.misTpbCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misTpbAmt = this.misTpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSysCnt = this.iSysCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSubTotCnt = this.iSubTotCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mSubTotAmt = this.mSubTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mOtrAmt = this.mOtrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRtDisUmchCnt = this.mRtDisUmchCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mNotAcctUmchAmt = this.mNotAcctUmchAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mBilUmchCnt = this.mBilUmchCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colorCd = this.colorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iCtrtCnt = this.iCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mDblBilUmchAmt = this.mDblBilUmchAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mLackEvidAmt = this.mLackEvidAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mRtDisUmchAmt = this.mRtDisUmchAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOtrCnt = this.iOtrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mNotAcctUmchCnt = this.mNotAcctUmchCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSysAmt = this.iSysAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iWrkOrdCnt = this.iWrkOrdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOpCnt = this.iOpCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
