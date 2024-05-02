/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyCODAdjustmentBC.java
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueEmptyListVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.DamageRevenueListOptionVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODMasterVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODPortSumVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDPortVO00;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodOptionVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.MTYREPOByPeriodVO;
import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.PODListByVVDVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -Eqtransportplannperform Business Logic Command Interface<br>

 *
 * @author
 * @see Ees_cim_1038EventResponse 
 * @since J2EE 1.6
 */

public interface EmptyCODAdjustmentBC {

	/**
	 * retrieving for PODListByVVD<br>
	 * 
	 * @param week
	 * @param vvd
	 * @return List<PODListByVVDVO>
	 * @throws EventException
	 */
	public List<PODListByVVDVO> searchPODListByVVD(String week,String vvd) throws EventException;

    /**
	 * retrieving for POD list in VVD<br>
     * 
     * @param vvd
     * @return List<PODListByVVDVO>
     * @throws EventException
     */
    public List<PODListByVVDVO> searchPODListByVVD2(String vvd) throws EventException;	
	
	/**
	 * retrieving for MTYCODList<br>
	 * 
	 * @param week
	 * @param trade
	 * @return List<EmptyCODMasterVO>
	 * @throws EventException
	 */
	public EmptyCODMasterVO searchMTYCODList(String week,String trade) throws EventException;
	
	/**
	 * saving COD Simulation By VVD<br>
	 * 
	 * @param emptyCODMasterVO
	 * @param account
	 * @throws EventException
	 */
	public void manageCODByVVD(EmptyCODMasterVO emptyCODMasterVO,SignOnUserAccount account ) throws EventException;
	
    /**
     * retrieving for MTY COD Confirmation <br>
     * 
     * @param vvd
     * @param version
     * @param emptyCODMasterVO
     * @return EmptyCODMasterVO
     * @throws EventException
     */
    public EmptyCODMasterVO searchMTYREPOPlan( String vvd , String version , EmptyCODMasterVO emptyCODMasterVO ) throws EventException;
    
    /**
     * retrieving for MTY COD Confirmation Tab <br>
     * 
     * @param vvd
     * @return String
     * @throws EventException
     */
    public String searchVVDInformation( String vvd ) throws EventException;
    
    /**
     * retrieving for  MTY COD Confirmation <br>
     * 
     * @param vvd
     * @param port
     * @param ibFlag
     * @return List<EmptyCODPortSumVO>
     * @throws EventException
     */
    public List<EmptyCODPortSumVO> searchYardNETBByVVDPort( String vvd , String port , String ibFlag ) throws EventException;
    
    /**
     * retrieving for MTY COD Confirmation  <br>
     *  
     * @param vvd
     * @param port
     * @param ibFlag
     * @return List<EmptyCODPortSumVO>
     * @throws EventException
     */
    public List<EmptyCODPortSumVO> searchYardNETBByPort( String vvd , String port , String ibFlag ) throws EventException;

    /**
	   * saving MTY COD Confirmation<br>
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
    public String manageMTYREPOPlan( String vvd , String lane , String bay , String version , String remark , String sh2RC , String n1stEtb , EmptyCODVVDPortVO00[] emptyCODVVDPortVOS , SignOnUserAccount account) throws EventException;
    
    /**
	   * removing MTY COD Confirmation<br>
     * 
     * @param vvd
     * @throws EventException
     */
    public void deleteConfirmation( String vvd ) throws EventException;
    
    /**
     * retrieving for MTY COD Confirmation  <br>
     * 
     * @param vvd
     * @param pod
     * @param damageRevenueEmptyListVO
     * @return DamageRevenueEmptyListVO
     * @throws EventException
     */
    public DamageRevenueEmptyListVO searchRevenueMTYList( String vvd , String pod , DamageRevenueEmptyListVO damageRevenueEmptyListVO ) throws EventException;
    
    /**
     * retrieving for MTY COD Confirmation <br>
     * 
     * @param damageRevenueListOptionVO
     * @param damageRevenueEmptyListVO
     * @return DamageRevenueEmptyListVO
     * @throws EventException
     */
    public DamageRevenueEmptyListVO searchDamageHangerMTYList ( DamageRevenueListOptionVO damageRevenueListOptionVO , DamageRevenueEmptyListVO damageRevenueEmptyListVO ) throws EventException;
    
    /**
     * retrieving for MTY Repo Inquiry by Period <br>
     * 
     * @param mTYREPOByPeriodOptionVO
     * @return List<MTYREPOByPeriodVO>
     * @throws EventException
     */
    public List<MTYREPOByPeriodVO> searchMTYREPOByPeriod ( MTYREPOByPeriodOptionVO mTYREPOByPeriodOptionVO ) throws EventException;    

	/**
	 * retrieving for VvdRemark<br>
	 * 
	 * @param vvd
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdRemark(String vvd) throws EventException;

	/**
	 * saving VvdRemark<br>
	 * 
	 * @param emptyCODVVDVO
	 * @param account
	 * @throws EventException
	 */
	public void saveVvdRemark(EmptyCODVVDVO emptyCODVVDVO,SignOnUserAccount account ) throws EventException;

	/**
	 * removing VvdRemark<br>
	 * 
	 * @param emptyCODVVDVO
	 * @exception EventException
	 */
	public void deleteVvdRemark(EmptyCODVVDVO emptyCODVVDVO) throws EventException;
	
    /**
     * retrieving for searchYardCode  <br>
     * 
     * @param yardcode
     * @return String
     * @exception EventException
     */
    public String searchYardCode( String yardcode ) throws EventException;
	
	/**
	 * checking Location <br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException;
	
}