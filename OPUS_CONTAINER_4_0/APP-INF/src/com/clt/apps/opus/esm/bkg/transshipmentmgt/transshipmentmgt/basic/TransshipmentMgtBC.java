/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtBC.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.basic;


import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgRouteForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.CntrSumByPodVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SearchCondForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SendTsListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdDetailForPortAssignVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgTsRmkVO;
import com.clt.syscommon.common.table.BkgVslDchgYdVO;
import com.clt.syscommon.common.table.BkgVslOopVO;
import com.clt.syscommon.common.table.BkgVslOpCrrCdVO;
import com.clt.syscommon.common.table.BkgVvdVO;

/**
 * OPUS-Transshipmentmgt Business Logic Basic Command interface<br>
 * - OPUS-Transshipmentmgt handling business transaction.<br>
 * 
 * @author
 * @see
 * @since J2EE 1.4
 */
public interface TransshipmentMgtBC {
	/**
	 * retrieving  crn, uvi no<br>
	 * 
	 * @param  BkgVslDchgYdInputVO bkgVslDchgYdInputVO
	 * @return VslDischargingVO
	 * @exception EventException
	 */
	public VslDischargingVO searchVslDischarging(BkgVslDchgYdInputVO bkgVslDchgYdInputVO) throws EventException;
	/**
	 * Saving  port, CRN No, UVI No<br>
	 * 
	 * @param BkgVslDchgYdVO[] bkgVslDchgYdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslDischarging(BkgVslDchgYdVO[] bkgVslDchgYdVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving of bkg_vsl_op_crr_cd<br>
	 * 
	 * @return List<BkgVslOpCrrCdVO>
	 * @exception EventException
	 */
	public List<BkgVslOpCrrCdVO> searchCarrierCode() throws EventException;
	
    /**
	 * retrieving of op_crr_code<br>
	 * 
	 * @param  InputVO inputVO
	 * @return VslOOPVO
	 * @exception EventException
	 */
	public VslOopVO searchVslOopMatch (VslOopInputVO inputVO) throws EventException;
	
	/**
	 * saving oop code<br>
	 * 
	 * @param BkgVslOopVO[] bkgVslOopVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageVslOopMatch (BkgVslOopVO[] bkgVslOopVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * saving oop code<br>
	 * 
	 * @param BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageOopCode (BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling retrieving event of booking<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemianListVO> 
	 * @exception EventException
	 */
    public List<TSRemianListVO> searchTSRemainList(TSRemainListInputVO tSRemainListInputVO) throws EventException;
    
	/**
	 * Handling retrieving event of cntr<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemainSumVO>
	 * @exception EventException
	 */
    public List<TSRemainSumVO> searchTSRemainSumByLoc(TSRemainListInputVO tSRemainListInputVO) throws EventException;
    
	/**
	 * Handling retrieving event of vessel<br>
	 * 
	 * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO 
	 * @return List<TSListBy1st2ndVVDListVO>
	 * @exception EventException
	 */
    public List<TSListBy1st2ndVVDListVO> searchTSListBy1st2ndVVDList(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException;
    
	/**
	 * Handling retrieving event of vvd<br>
	 * 
     * @param  TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchTSVvdFor1st2nd (TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO) throws EventException;
    
    
    /**
     * fax send event
     * 
     * @param SendTsListVO sendTsListVO
     * @param SignOnUserAccount account
     * @return List<String>
     * @exception EventException
     */
    public List<String> sendTsListByFax (SendTsListVO sendTsListVO,SignOnUserAccount account)throws EventException;
    
    
    /**
     * email send event
     * 
     * @param SendTsListVO sendTsListVO
     * @param String vvd
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String sendTsListByEmail (SendTsListVO sendTsListVO,String vvd,SignOnUserAccount account)throws EventException;
    
    /**
     * retrieving of Cntr Sum<br>
     * 
     * @param  SendTsListVO sendTsListVO
     * @return List<CntrSumByPodVO>
     * @exception EventException
     */
    public List<CntrSumByPodVO> searchCntrSumByPod (SendTsListVO sendTsListVO)throws EventException;
    
    
    /**
     * retrieving  T/S port<br>
	 * 
     * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO
     * @return List<TSSummaryVO>
     * @exception EventException
     */
    public List<TSSummaryVO> searchTSSummary(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException;
    
    /**
     * retrieving Relay Vessel Group Assign by Relay Port list.<br>
     * 
     * @param  RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO
     * @return List<RlyVslGrpAssignVO>
     * @exception EventException
     */
    public List<RlyVslGrpAssignVO>searchRlyVslGrpAssign ( RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO )throws EventException;
    
    /**
     * retrieving Next VVD Assign T/S Remark T/S remark<br>
     * 
     * @param  BkgTsRmkVO bkgTsRmkVO 
     * @return BkgTsRmkVO
     * @exception EventException
     */
    public BkgTsRmkVO searchTSRemark (BkgTsRmkVO bkgTsRmkVO ) throws EventException;
    
    /**
     * Saving t/s port remark<br>
     * 
     * @param  BkgTsRmkVO bkgTsRmkVO
     * @param  SignOnUserAccount account
     * @exception EventException
     */
    public void manageTSRemark (BkgTsRmkVO bkgTsRmkVO, SignOnUserAccount account ) throws EventException;
    
    /**
     * retrieving of vvd,Bkg.<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<FormerVvdVO>
     * @exception EventException
     */
    public List<FormerVvdVO>searchFormerVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException;
    
    /**
     * retrieving of  next vvd<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return VvdAssignTargetListVO
     * @exception EventException
     */
    public VvdAssignTargetListVO searchTargetForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException;
    
    /**
     * retrieving of next vvd<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<NextVvdVO>
     * @exception EventException
     */
    public List<NextVvdVO>searchNextVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException;
    
    /**
     * retrieving of Booking by route<br>
     * 
     * @param SearchCondForPortAssignVO searchCondForPortAssignVO
     * @return List<BkgRouteForPortAssignVO>
     * @exception EventException
     */
    public List<BkgRouteForPortAssignVO>searchBkgRouteForPortAssign(SearchCondForPortAssignVO searchCondForPortAssignVO)throws EventException;
    
    /**
     * retrieving of Detail Booking by route<br>
     * 
     * @param  BkgListForPortAssignInputVO bkgListForPortAssignInputVO
     * @return List<BkgListForPortAssignVO>
     * @exception EventException
     */
    public List<BkgListForPortAssignVO>searchBkgListForPortAssign(BkgListForPortAssignInputVO bkgListForPortAssignInputVO)throws EventException;
    
    /**
     * retrieving of Booking by bkg vvd port<br>
	 * 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<BkgVvdVO>
     * @exception EventException
     */
    public List<BkgVvdVO>searchBkgVvdForVvdPortAssign(BkgBlNoVO bkgBlNoVO)throws EventException;
    
    /**
     * Search VVD detail for Group VVD/Port Assign.<br>
     * 
     * @param SearchCondForPortAssignVO searchCondForPortAssignVO
     * @return List<VvdDetailForPortAssignVO>
     * @exception EventException
     */
    public List<VvdDetailForPortAssignVO>searchVvdDetailForPortAssign(SearchCondForPortAssignVO searchCondForPortAssignVO)throws EventException;
 
}