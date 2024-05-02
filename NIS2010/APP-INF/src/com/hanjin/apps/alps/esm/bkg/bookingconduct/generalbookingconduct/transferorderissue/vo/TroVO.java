package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0079_02A 화면에서, 조회용 Container VO
 * @author 이남경
 * @since J2EE 1.5
 */
public class TroVO {

	/* param */
	String eBkgFlg   = null;  //eBooking 여부 	
	String bkgNo     = null;
	String ioBndCd   = null;
	String rtnTroFlg = null;
	String delFlg    = null;  //화면 save 이벤트구분 flg 


	/** 조회용 */
	//1) General 용
	BkgBlNoVO                bkgBlNoVO           = null;
	
	BkgInfoForTroVO          bkgInfoForTroVO     = null;
	List<DgSeqVO>            dgSeqVOs            = new ArrayList<DgSeqVO>();
	List<RfSeqVO>            rfSeqVOs            = new ArrayList<RfSeqVO>();
	List<AwkSeqVO>           awkSeqVOs           = new ArrayList<AwkSeqVO>();

	List<TroMstVO>           bkgTroVOs           = new ArrayList<TroMstVO>();
	List<TroDtlVO>           troDtlVOs           = new ArrayList<TroDtlVO>();
    List<BkgTroSpclCgoSeqVO> bkgTroSpclCgoSeqVOs = new ArrayList<BkgTroSpclCgoSeqVO>();
    List<QtyInfoForTroVO>    qtyInfoForTroVOs    = new ArrayList<QtyInfoForTroVO>();

    //2) rtn_Cago 용
    List<TroMstVO>           bkgTroVOsrtn        = new ArrayList<TroMstVO>();
	List<TroDtlVO>           troDtlVOsrtn        = new ArrayList<TroDtlVO>();
	
	//Cntr 배열 
	List<String>             cntrs               = new ArrayList<String>();

    /** 저장용 */
	/** Table Value Object Multi Data 처리 */
	//private BkgTroVO[]           arrBkgTroVO           = null; 
	private TroMstVO[]           arrTroMstVO           = null;  	
	/** Table Value Object Multi Data 처리 */
	private TroDtlVO[]           arrTroDtlVO           = null;
	/** Table Value Object Multi Data 처리 */
	private BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = null;

	/** Table Value Object Multi Data 처리 : rtn_cago */
	//private BkgTroVO[]           arrBkgTroVOrtn       = null; 
	private TroMstVO[]           arrTroMstVOrtn        = null;	
	/** Table Value Object Multi Data 처리 : rtn_cago */
	private TroDtlVO[]           arrTroDtlVOrtn        = null; 

	//Cntr 배열 
	private String[]             arrCntr               = null;
	

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}
	/**
	 * @return the arrCntr
	 */
	public String[] getArrCntr() {
		return arrCntr;
	}
	/**
	 * @param arrCntr the arrCntr to set
	 */
	public void setArrCntr(String[] arrCntr) {
		this.arrCntr = arrCntr;
	}
	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	/**
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}
	/**
	 * @param ioBndCd the ioBndCd to set
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	/**
	 * @return the rtnTroFlg
	 */
	public String getRtnTroFlg() {
		return rtnTroFlg;
	}
	/**
	 * @param rtnTroFlg the rtnTroFlg to set
	 */
	public void setRtnTroFlg(String rtnTroFlg) {
		this.rtnTroFlg = rtnTroFlg;
	}
	/**
	 * @return the bkgInfoForTroVO
	 */
	public BkgInfoForTroVO getBkgInfoForTroVO() {
		return bkgInfoForTroVO;
	}
	/**
	 * @param bkgInfoForTroVO the bkgInfoForTroVO to set
	 */
	public void setBkgInfoForTroVO(BkgInfoForTroVO bkgInfoForTroVO) {
		this.bkgInfoForTroVO = bkgInfoForTroVO;
	}
	/**
	 * @return the dgSeqVOs
	 */
	public List<DgSeqVO> getDgSeqVOs() {
		return dgSeqVOs;
	}
	/**
	 * @param dgSeqVOs the dgSeqVOs to set
	 */
	public void setDgSeqVOs(List<DgSeqVO> dgSeqVOs) {
		this.dgSeqVOs = dgSeqVOs;
	}
	/**
	 * @return the rfSeqVOs
	 */
	public List<RfSeqVO> getRfSeqVOs() {
		return rfSeqVOs;
	}
	/**
	 * @param rfSeqVOs the rfSeqVOs to set
	 */
	public void setRfSeqVOs(List<RfSeqVO> rfSeqVOs) {
		this.rfSeqVOs = rfSeqVOs;
	}
	/**
	 * @return the awkSeqVOs
	 */
	public List<AwkSeqVO> getAwkSeqVOs() {
		return awkSeqVOs;
	}
	/**
	 * @param awkSeqVOs the awkSeqVOs to set
	 */
	public void setAwkSeqVOs(List<AwkSeqVO> awkSeqVOs) {
		this.awkSeqVOs = awkSeqVOs;
	}
	/**
	 * @return the bkgTroVOs
	 */
	public List<TroMstVO> getBkgTroVOs() {
		return bkgTroVOs;
	}
	/**
	 * @param bkgTroVOs the bkgTroVOs to set
	 */
	public void setBkgTroVOs(List<TroMstVO> bkgTroVOs) {
		this.bkgTroVOs = bkgTroVOs;
	}
	/**
	 * @return the troDtlVOs
	 */
	public List<TroDtlVO> getTroDtlVOs() {
		return troDtlVOs;
	}
	/**
	 * @param troDtlVOs the troDtlVOs to set
	 */
	public void setTroDtlVOs(List<TroDtlVO> troDtlVOs) {
		this.troDtlVOs = troDtlVOs;
	}
	/**
	 * @return the bkgTroSpclCgoSeqVOs
	 */
	public List<BkgTroSpclCgoSeqVO> getBkgTroSpclCgoSeqVOs() {
		return bkgTroSpclCgoSeqVOs;
	}
	/**
	 * @param bkgTroSpclCgoSeqVOs the bkgTroSpclCgoSeqVOs to set
	 */
	public void setBkgTroSpclCgoSeqVOs(List<BkgTroSpclCgoSeqVO> bkgTroSpclCgoSeqVOs) {
		this.bkgTroSpclCgoSeqVOs = bkgTroSpclCgoSeqVOs;
	}
	/**
	 * @return the qtyInfoForTroVOs
	 */
	public List<QtyInfoForTroVO> getQtyInfoForTroVOs() {
		return qtyInfoForTroVOs;
	}
	/**
	 * @param qtyInfoForTroVOs the qtyInfoForTroVOs to set
	 */
	public void setQtyInfoForTroVOs(List<QtyInfoForTroVO> qtyInfoForTroVOs) {
		this.qtyInfoForTroVOs = qtyInfoForTroVOs;
	}
	/**
	 * @return the bkgTroVOsrtn
	 */
	public List<TroMstVO> getBkgTroVOsrtn() {
		return bkgTroVOsrtn;
	}
	/**
	 * @param bkgTroVOsrtn the bkgTroVOsrtn to set
	 */
	public void setBkgTroVOsrtn(List<TroMstVO> bkgTroVOsrtn) {
		this.bkgTroVOsrtn = bkgTroVOsrtn;
	}
	/**
	 * @return the troDtlVOsrtn
	 */
	public List<TroDtlVO> getTroDtlVOsrtn() {
		return troDtlVOsrtn;
	}
	/**
	 * @param troDtlVOsrtn the troDtlVOsrtn to set
	 */
	public void setTroDtlVOsrtn(List<TroDtlVO> troDtlVOsrtn) {
		this.troDtlVOsrtn = troDtlVOsrtn;
	}
	/**
	 * @return the arrTroDtlVO
	 */
	public TroDtlVO[] getArrTroDtlVO() {
		return arrTroDtlVO;
	}
	/**
	 * @param arrTroDtlVO the arrTroDtlVO to set
	 */
	public void setArrTroDtlVO(TroDtlVO[] arrTroDtlVO) {
		this.arrTroDtlVO = arrTroDtlVO;
	}
	/**
	 * @return the arrBkgTroSpclCgoSeqVO
	 */
	public BkgTroSpclCgoSeqVO[] getArrBkgTroSpclCgoSeqVO() {
		return arrBkgTroSpclCgoSeqVO;
	}
	/**
	 * @param arrBkgTroSpclCgoSeqVO the arrBkgTroSpclCgoSeqVO to set
	 */
	public void setArrBkgTroSpclCgoSeqVO(BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO) {
		this.arrBkgTroSpclCgoSeqVO = arrBkgTroSpclCgoSeqVO;
	}
	/**
	 * @return the arrTroDtlVOrtn
	 */
	public TroDtlVO[] getArrTroDtlVOrtn() {
		return arrTroDtlVOrtn;
	}
	/**
	 * @param arrTroDtlVOrtn the arrTroDtlVOrtn to set
	 */
	public void setArrTroDtlVOrtn(TroDtlVO[] arrTroDtlVOrtn) {
		this.arrTroDtlVOrtn = arrTroDtlVOrtn;
	}
	/**
	 * @return the arrTroMstVO
	 */
	public TroMstVO[] getArrTroMstVO() {
		return arrTroMstVO;
	}
	/**
	 * @param arrTroMstVO the arrTroMstVO to set
	 */
	public void setArrTroMstVO(TroMstVO[] arrTroMstVO) {
		this.arrTroMstVO = arrTroMstVO;
	}
	/**
	 * @return the arrTroMstVOrtn
	 */
	public TroMstVO[] getArrTroMstVOrtn() {
		return arrTroMstVOrtn;
	}
	/**
	 * @param arrTroMstVOrtn the arrTroMstVOrtn to set
	 */
	public void setArrTroMstVOrtn(TroMstVO[] arrTroMstVOrtn) {
		this.arrTroMstVOrtn = arrTroMstVOrtn;
	}
	/**
	 * @return the cntrs
	 */
	public List<String> getCntrs() {
		return cntrs;
	}
	/**
	 * @param cntrs the cntrs to set
	 */
	public void setCntrs(List<String> cntrs) {
		this.cntrs = cntrs;
	}
	/**
	 * @return the eBkgFlg
	 */
	public String getEBkgFlg() {
		return eBkgFlg;
	}
	/**
	 * @param bkgFlg the eBkgFlg to set
	 */
	public void setEBkgFlg(String bkgFlg) {
		eBkgFlg = bkgFlg;
	}
	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}
	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}
	/**
	 * @return the delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}
	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}		
}