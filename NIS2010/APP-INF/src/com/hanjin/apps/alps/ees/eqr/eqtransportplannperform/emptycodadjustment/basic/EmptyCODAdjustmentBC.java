/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyCODAdjustmentBC.java
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.07.31 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueListOptionVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODMasterVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODPortSumVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDPort01VO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.hanjin.apps.alps.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.PODListByVVDVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Eqtransportplannperform Business Logic Command Interface<br>
 * - ALPS-Eqtransportplannperform에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Prak Kwang Seok
 * @see Ees_cim_1038EventResponse 참조
 * @since J2EE 1.6
 */

public interface EmptyCODAdjustmentBC { 

	/**
	 * [PODListByVVD]을 [조회] 합니다.<br>
	 * 
	 * @param week
	 * @param vvd
	 * @return List<PODListByVVDVO>
	 * @throws EventException
	 */
	public List<PODListByVVDVO> searchPODListByVVD(String week,String vvd) throws EventException;

    /**
     * [비즈니스대상]을 [행위] 합니다.<br>
     * 
     * @param vvd
     * @return List<PODListByVVDVO>
     * @throws EventException
     */
    public List<PODListByVVDVO> searchPODListByVVD2(String vvd) throws EventException;	
	
	/**
	 * [MTYCODList]을 [조회] 합니다.<br>
	 * 
	 * @param week
	 * @param trade
	 * @return List<EmptyCODMasterVO>
	 * @throws EventException
	 */
	public EmptyCODMasterVO searchMTYCODList(String week,String trade) throws EventException;
	
	/**
	 * [CODByVVD]을 [저장,수정,삭제] 합니다.<br>
	 * 
	 * @param emptyCODMasterVO
	 * @param account
	 * @throws EventException
	 */
	public void manageCODByVVD(EmptyCODMasterVO emptyCODMasterVO,SignOnUserAccount account ) throws EventException;
	
    /**
     * MTY COD Confirmation 을 조회 합니다. <br>
     * 
     * @param vvd
     * @param version
     * @param emptyCODMasterVO
     * @return EmptyCODMasterVO
     * @throws EventException
     */
    public EmptyCODMasterVO searchMTYREPOPlan( String vvd , String version , EmptyCODMasterVO emptyCODMasterVO ) throws EventException;
    
    /**
     * MTY COD Confirmation Tab 을 조회 합니다. <br>
     * 
     * @param vvd
     * @return String
     * @throws EventException
     */
    public String searchVVDInformation( String vvd ) throws EventException;
    
    /**
     * MTY COD Confirmation 을 조회 합니다. <br>
     * 
     * @param vvd
     * @param port
     * @param ibFlag
     * @return List<EmptyCODPortSumVO>
     * @throws EventException
     */
    public List<EmptyCODPortSumVO> searchYardNETBByVVDPort( String vvd , String port , String ibFlag ) throws EventException;
    
    /**
     * MTY COD Confirmation 을 조회 합니다. <br>
     *  
     * @param vvd
     * @param port
     * @param ibFlag
     * @return List<EmptyCODPortSumVO>
     * @throws EventException
     */
    public List<EmptyCODPortSumVO> searchYardNETBByPort( String vvd , String port , String ibFlag ) throws EventException;

    /**
     * 저장 이벤트 처리<br>
     * MTY COD Confirmation 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param vvd
     * @param lane
     * @param bay
     * @param version
     * @param remark
     * @param sh2RC
     * @param n1stEtb
     * @param emptyCODVVDPortVOS
     * @param account
     * @return String
     * @throws EventException
     */
    public String manageMTYREPOPlan( String vvd , String lane , String bay , String version , String remark , String sh2RC , String n1stEtb , EmptyCODVVDPort01VO[] emptyCODVVDPortVOS , SignOnUserAccount account) throws EventException;
    
    /**
     * 저장 이벤트 처리<br>
     * MTY COD Confirmation 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param vvd
     * @throws EventException
     */
    public void deleteConfirmation( String vvd ) throws EventException;
    
    /**
     * MTY COD Confirmation 을 조회 합니다. <br>
     * 
     * @param vvd
     * @param pod
     * @param damageRevenueEmptyListVO
     * @return DamageRevenueEmptyListVO
     * @throws EventException
     */
    public DamageRevenueEmptyListVO searchRevenueMTYList( String vvd , String pod , DamageRevenueEmptyListVO damageRevenueEmptyListVO ) throws EventException;
    
    /**
     * MTY COD Confirmation 을 조회 합니다. <br>
     * 
     * @param damageRevenueListOptionVO
     * @param damageRevenueEmptyListVO
     * @return DamageRevenueEmptyListVO
     * @throws EventException
     */
    public DamageRevenueEmptyListVO searchDamageHangerMTYList ( DamageRevenueListOptionVO damageRevenueListOptionVO , DamageRevenueEmptyListVO damageRevenueEmptyListVO ) throws EventException;
    
    /**
     * MTY Repo Inquiry by Period 을 조회 합니다. <br>
     * 
     * @param mTYREPOByPeriodOptionVO
     * @return List<MTYREPOByPeriodVO>
     * @throws EventException
     */
    public List<MTYREPOByPeriodVO> searchMTYREPOByPeriod ( MTYREPOByPeriodOptionVO mTYREPOByPeriodOptionVO ) throws EventException;    

	/**
	 * [VvdRemark]을 [조회] 합니다.<br>
	 * 
	 * @param vvd
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdRemark(String vvd) throws EventException;

	/**
	 * [VvdRemark]을 [저장] 합니다.<br>
	 * 
	 * @param emptyCODVVDVO
	 * @param account
	 * @throws EventException
	 */
	public void saveVvdRemark(EmptyCODVVDVO emptyCODVVDVO,SignOnUserAccount account ) throws EventException;

	/**
	 * [VvdRemark]을 [삭제] 합니다.<br>
	 * 
	 * @param emptyCODVVDVO
	 * @exception EventException
	 */
	public void deleteVvdRemark(EmptyCODVVDVO emptyCODVVDVO) throws EventException;
	
    /**
     * searchYardCode 을 조회 합니다. <br>
     * 
     * @param yardcode
     * @return String
     * @exception EventException
     */
    public String searchYardCode( String yardcode ) throws EventException;
	
	/**
	 * Location을 check  합니다. <br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException;
	
}