/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateBC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018MultiVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1050ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1051ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.MtyBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS Business Logic Command Interface<br>
 * - 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ees_eqr_1018EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrMtyBkgCreateBC {

	/**
	 * [EES_EQR_1018 : ]<br>
	 * 
	 * @param EesEqr1018ConditionVO eesEqr1018ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 * 
	 */
	public CommonRsVO searchCntrMtyBkgList(EesEqr1018ConditionVO eesEqr1018ConditionVO) throws EventException; 

	/**
	 * [EES_EQR_1051 : ]<br>
	 * 
	 * @param EesEqr1051ConditionVO eesEqr1051ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 * searchCntrMtyBkgContainerList
	 */
	public CommonRsVO searchCntrMtyBkgContainerList(EesEqr1051ConditionVO eesEqr1051ConditionVO) throws EventException;
	
	/**
	 * [EES_EQR_1018 : ]<br>
	 * 
	 * @param eesEqr1018MultiVOs EesEqr0059MultiVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrMtyBkgList(EesEqr1018MultiVO[] eesEqr1018MultiVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * [EES_EQR_1018 : VVD 존재 확인 및 SLAN 조회]<br>
	 * 
	 * @param String vvd 
	 * @param String trsp_mod_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrMtyBkgVvdSlan(String vvd, String trsp_mod_cd) throws EventException;	
	
	/**
	 * [EES_EQR_1018 : From Yard 및 ETD 조회]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgVvdFmYdList(String vvd) throws EventException;	
	
	/**
	 * [EES_EQR_1018 : To Yard 및 ETB 조회]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgVvdToYdList(String vvd) throws EventException;	
	
	
	/**
	 * [EES_EQR_1018 : MTY Booking Creation ]<br>
	 * 
	 * @param EesEqr1018MultiVO multiVO
	 * @param account SignOnUserAccount
	 * @return MtyBookingCreateVO
	 * @exception EventException
	 */
	public MtyBookingCreateVO createRepoBKG(EesEqr1018MultiVO multiVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * [EES_EQR_1018 : MTY Booking Creation 후 각 테이블에 Bkg No. 업데이트 해주기. ]<br>
	 * 
	 * @param EesEqr1018MultiVO multiVO
	 * @exception EventException
	 */
	public void modifyMtyBkgNo(EesEqr1018MultiVO multiVO) throws EventException;		
	
	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 * 
	 */
	public CommonRsVO searchCntrMtyBkgSplitContainerList(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws EventException;	

	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param EesEqr1052MultiVO[] eesEqr1052MultiVOs
	 * @param EesEqr1052ConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void addCntrMtyBkgSplitListTmp(EesEqr1052MultiVO[] eesEqr1052MultiVOs, EesEqr1052ConditionVO conditionVO, SignOnUserAccount account) throws EventException;	

	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param String tmp_seq
	 * @return List<EesEqr1052MultiVO>
	 * @exception EventException
	 * 
	 */
	public List<EesEqr1052MultiVO> searchCntrMtyBkgSplitListTmp(String tmp_seq) throws EventException;	
	
	/**
	 * [EES_EQR_1052 : MTY BKG Split Creation ]<br>
	 * 
	 * @param EesEqr1052ConditionVO conditionVO
	 * @param account			SignOnUserAccount
	 * @return MtyBookingSplitVO
	 * @exception EventException
	 */
	public MtyBookingSplitVO createRepoBKGSplit(EesEqr1052ConditionVO conditionVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 * 
	 */
	public CommonRsVO searchCntrMtySplitResult(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws EventException;		
	
	/**
	 * [EES_EQR_1052 : VVD의 mty bkg no 를 조회합니다.]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMtyBkgNoInVVD(String vvd) throws EventException;
	
	/**
	 * [EES_EQR_1052 :  VVD의 To Yard 및 ETB 조회]<br>
	 * 
	 * @param String vvd 
	 * @param String flag_rob
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPodYardInVVD(String vvd, String flag_rob) throws EventException;			
	
	/**
	 * [EES_EQR_1052 :  ROB VVD 리스트 조회한다.]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchROBVVDList(String vvd) throws EventException;	
	
	/**
	 * [EES_EQR_1052 : vvd 존재여부확인]<br>
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchCntrMtyBkgVvdExist(String vvd) throws EventException;	
	
	/**
	 * [EES_EQR_1052 : Feeder VVD 인지 조사	]<br>
	 * 
	 * @param String vvd
	 * @return String
	 * @exception EventException
	 * 
	 */
	public String searchCntrMtyBkgVvdIsWater(String vvd) throws EventException;		
	
	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param String vvd
	 * @param String excel_cntr_no
	 * @param String flag	
	 * @return CommonRsVO
	 * @exception EventException
	 * 
	 */
	public EesEqr1052MultiVO searchCntrMtyBkgSplitContainerInfo(String vvd, String excel_cntr_no, String flag) throws EventException;		
	
	/**
	 * [BKG/DOC InterFace : Volume Cancel ]<br>
	 * 
	 * @param  mtyBkgVO MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgCancel(MtyBkgVO mtyBkgVO) throws EventException;	
	
	/**
	 * Mty Bkg History 입력<br>
	 * 
	 * @param  hisCategory String
	 * @param  mtyBkgNo String
	 * @param  usrId String
	 * @param  crntCtnt String
	 * @exception EventException
	 */
	public void createMtyBkgHistory(String hisCategory, String mtyBkgNo, String usrId, String crntCtnt) throws EventException;		
	
	/**
	 * [EES_EQR_1050 : ]<br>
	 * 
	 * @param EesEqr1050ConditionVO eesEqr1050ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 * searchCntrMtyBkgContainerList
	 */
	public CommonRsVO searchMtyROBVVDDetail(EesEqr1050ConditionVO eesEqr1050ConditionVO) throws EventException;	
	
	/**
	 * checking Location
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException;
	
	/**
	 * [YARD 존재 확인 및 조회]<br>
	 * 
	 * @param String yard
	 * @param String vvd  
	 * @return String
	 * @exception EventException
	 */
	public String searchYardInDateInfo(String yard, String vvd) throws EventException ;	
	
	
	/**
	 * [Seq 조회]<br>
	 * 
	 * @param String gubun
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @param String vsl_lane_cd
	 * @param String vps_port_cd    
	 * @return String
	 * @exception EventException
	 */
	public String searchClptIndSEq(String gubun, String vsl_cd, String skd_voy_no, String skd_dir_cd, String vsl_lane_cd, String vps_port_cd) throws EventException;
}