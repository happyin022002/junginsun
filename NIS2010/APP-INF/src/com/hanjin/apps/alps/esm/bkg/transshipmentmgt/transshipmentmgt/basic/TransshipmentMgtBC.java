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
* ------------------------------------------------------
* HISTORY
* 2012.01.27 김경섭 [CHM-201115348] [BKG] T/S 화물 Transit Time 조회/분석 report 신규개발
* 2014.04.07 조인영 [CHM-201429635] NMC ( Non-Manipulation Certificate) Form 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.basic;


import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgRouteForPortAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgTsCoffTmVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.CntrSumByPodVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSTimeRptVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsBkgListForBayPlanInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SendTsListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetBkgVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgTsRmkVO;
import com.hanjin.syscommon.common.table.BkgVslDchgYdVO;
import com.hanjin.syscommon.common.table.BkgVslOopVO;
import com.hanjin.syscommon.common.table.BkgVslOpCrrCdVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
/**
 * alps-Transshipmentmgt Business Logic Command Interface<br>
 * - alps-Transshipmentmgt에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author Choi Yeoung Hee
 * @see Esm_bkg-0580EventResponse 참조
 * @since J2EE 1.4
 */

public interface TransshipmentMgtBC {
	/**
	 * 조회 조건에 맞는 vessel schedule과 지정되어 있는 crn, uvi no를 조회한다.<br>
	 * 
	 * @param  BkgVslDchgYdInputVO bkgVslDchgYdInputVO 
	 * @return VslDischargingVO 
	 * @exception EventException
	 */
	public VslDischargingVO searchVslDischarging(BkgVslDchgYdInputVO bkgVslDchgYdInputVO) throws EventException;
	/**
	 * Port 별로 입항하는 VVD의 port와 터미널 코드 및 CRN No, UVI No를 저장한다.<br>
	 * 
	 * @param  BkgVslDchgYdVO[] bkgVslDchgYdVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslDischarging(BkgVslDchgYdVO[] bkgVslDchgYdVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * bkg_vsl_op_crr_cd를 조회한다<br>
	 * 
	 * @return List<BkgVslOpCrrCdVO>
	 * @exception EventException
	 */
	public List<BkgVslOpCrrCdVO> searchCarrierCode() throws EventException;
	
	/**
	 * Feeder 선사가 운영하는 선박에 대해 당사 T/S booking 선복 사용에 대해 선박별 이용 선사를 구분 정보와 선사 구분 code를 조회한다.<br>
	 * 
	 * @param  InputVO inputVO
	 * @return VslOopVO
	 * @exception EventException
	 */
	public VslOopVO searchVslOopMatch (VslOopInputVO inputVO) throws EventException;
	
	/**
	 * Feeder 선사가 운영하는 선박에 대해 당사 T/S booking 선복 사용에 대해 선박별 이용 선사를 구분 정보를 저장한다.<br>
	 * 
	 * @param  BkgVslOopVO[] bkgVslOopVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageVslOopMatch (BkgVslOopVO[] bkgVslOopVO,SignOnUserAccount account) throws EventException;
	
    /**
	 * 선복 사용 식별에 사용하는 oop code를 저장한다.<br>
	 * 
	 * @param BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageOopCode (BkgVslOpCrrCdVO[] bkgVslOpCrrCdVO,SignOnUserAccount account) throws EventException;
	
    /**
	 * t/s port에서 next vessel이 재지정 되지 않고 port에 머물러 있는 booking들을 조회한다.<br>
     * 신규화면이며 long staying을 막기 위해 사용한다.<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemianListVO>
	 * @exception EventException
	 */
    public List<TSRemianListVO> searchTSRemainList(TSRemainListInputVO tSRemainListInputVO) throws EventException;
    
    /**
     * 전달받은 location에 전달받은 날짜를 기준으로 cnmv_sts_cd가 'TS', 'TN'인 container들을<br>
     * type/size, cargo type별로 합계를 내서 조회한다.<br>
     * 
     * @param  TSRemainListInputVO tSRemainListInputVO
     * @return List<TSRemainSumVO>
     * @exception EventException
     */
    public List<TSRemainSumVO> searchTSRemainSumByLoc(TSRemainListInputVO tSRemainListInputVO) throws EventException;
    
    /**
	 * t/s port를 기준으로 booking들의 입항 vessel과 출항 vessel을 조회한다.<br>
     * 
	 * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO 
	 * @return List<TSListBy1st2ndVVDListVO>
	 * @exception EventException
	 */
    public List<TSListBy1st2ndVVDListVO> searchTSListBy1st2ndVVDList(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException;
    
    /**
     * vvd를 drop down으로 조회한다.<br>
	 * 
     * @param  TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO 
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchTSVvdFor1st2nd (TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO) throws EventException;
    
    
    /**
     * 팩스 보내기 이벤트 처리<br>
     * 
     * @param SendTsListVO sendTsListVO
     * @param SignOnUserAccount account
     * @return List<String>
     * @exception EventException
     */
    public List<String> sendTsListByFax (SendTsListVO sendTsListVO,SignOnUserAccount account)throws EventException;
    
    
    /**
     * 이메일 보내기 이벤트 처리<br>
     * 
     * @param SendTsListVO sendTsListVO
     * @param String vvd
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String sendTsListByEmail (SendTsListVO sendTsListVO,String vvd,SignOnUserAccount account)throws EventException;
    
    /**
     * 메일 내용에 들어가는 POD별 컨테이너 VOLUMN 표시<br>
     * 
     * @param SendTsListVO sendTsListVO
     * @return List<CntrSumByPodVO>
     * @exception EventException
     */
    public List<CntrSumByPodVO> searchCntrSumByPod (SendTsListVO sendTsListVO)throws EventException;
    
    
    /**
     * T/S port에 입항한 1st VVD를 기준으로 연결되는 선명 별로 물량을 조회한다.<br>
	 * 
     * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO
     * @return List<TSSummaryVO>
     * @exception EventException
     */
    public List<TSSummaryVO> searchTSSummary(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws EventException;
    
    /**
     * Relay Vessel Group Assign by Relay Port 화면에서 assing을 위해 list를 조회한다.<br>
     * 
     * @param  RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO
     * @return List<RlyVslGrpAssignVO>
     * @exception EventException
     */
    public List<RlyVslGrpAssignVO>searchRlyVslGrpAssign ( RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO )throws EventException;
    
    /**
     * Next VVD Assign T/S Remark 화면에서 T/S remark를 조회한다.<br>
     * 
     * @param  BkgTsRmkVO bkgTsRmkVO
     * @return BkgTsRmkVO 
     * @exception EventException
     */
    public BkgTsRmkVO searchTSRemark (BkgTsRmkVO bkgTsRmkVO ) throws EventException;
    
    /**
     * t/s port에서 next vessel을 재지정시 입력한 remark를 저장한다.<br>
     * 
     * @param BkgTsRmkVO bkgTsRmkVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTSRemark (BkgTsRmkVO bkgTsRmkVO, SignOnUserAccount account ) throws EventException;
    
    /**
     * VVD Assign을 위해 입항 vvd와 출항 vvd, 대상 Bkg들을 조회한다.<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<FormerVvdVO>
     * @exception EventException
     */
    public List<FormerVvdVO>searchFormerVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException;
    
    /**
     * vvd assign에서 next vvd를 지정할 대상을 조회한다.<br>
     * 
     * @param NextVvdAssignInputVO nextVvdAssignInputVO
     * @return VvdAssignTargetListVO
     * @exception EventException
     */
    public VvdAssignTargetListVO searchTargetForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException;
    
    /**
     * vvd assign에서 next vvd가 될 수 있는 vvd를 조회한다.<br>
     * 
     * @param  NextVvdAssignInputVO nextVvdAssignInputVO
     * @return List<NextVvdVO>
     * @exception EventException
     */
    public List<NextVvdVO>searchNextVvdForAssign(NextVvdAssignInputVO nextVvdAssignInputVO)throws EventException;
    
    /**
    * 조건에 맞는 Booking을 route 별로 group으로 조회한다.<br>
    * 
    * @param String vvd
    * @param String portCd
    * @param String pol
    * @param String pod
    * @param String bkgOfcCd
    * @param String yardCd
    * @return List<BkgRouteForPortAssignVO>
    * @exception EventException
    */
    public List<BkgRouteForPortAssignVO>searchBkgRouteForPortAssign(String vvd, String portCd, String pol, String pod, String bkgOfcCd, String yardCd)throws EventException;
    
    /**
	 * route 별로 group으로 조회한 것을 기준으로 상세 Booking들을 조회한다.<br>
     * 
     * @param  BkgListForPortAssignInputVO bkgListForPortAssignInputVO
     * @return List<BkgListForPortAssignVO>
     * @exception EventException
     */
    public List<BkgListForPortAssignVO>searchBkgListForPortAssign(BkgListForPortAssignInputVO bkgListForPortAssignInputVO)throws EventException;
    
    /**
     * bkg vvd port를 조회한다.<br>
	 * 
     * @param  BkgBlNoVO bkgBlNoVO
     * @return List<BkgVvdVO>
     * @exception EventException
     */
    public List<BkgVvdVO>searchBkgVvdForVvdPortAssign(BkgBlNoVO bkgBlNoVO)throws EventException;
    
    /**
	 * 조회 조건에 맞는 출발 vvd들을 조회한다.<br>
     * 
	 * @param  TSTimeRptVO tSTimeRptVO
	 * @return List<TSTimeRptVO>
	 * @exception EventException
	 */
	public List<TSTimeRptVO> searchPortTurnTimeVVDList(TSTimeRptVO tSTimeRptVO)throws EventException;    
	
	/**
	 * Transit Time report in T/S port Summary를 조회한다. - UI-ESM_BKG_0499<br>
	 * 
	 * @param  TSTimeRptVO tSTimeRptVO
	 * @return List<TSTimeRptVO>
	 * @exception EventException
	 */
	public List<TSTimeRptVO> searchTSTimeRptSmry(TSTimeRptVO tSTimeRptVO)throws EventException;
	
	/**
	 * Transit Time report in T/S port Detail을 조회한다. - UI-ESM_BKG_0499<br>
	 * 
	 * @param  TSTimeRptVO tSTimeRptVO
	 * @return List<TSTimeRptVO>
	 * @exception EventException
	 */
	public List<TSTimeRptVO> searchTSTimeRptDtl(TSTimeRptVO tSTimeRptVO)throws EventException;
	
	/**
	 * Booking close / reopen하기 위한 list를 조회한다.<br>
	 *
	 * @param TsBkgListForBayPlanInputVO tsBkgListForBayPlanInputVO
	 * @param String subChk
	 * @return List<BkgTsCoffTmVO>
	 * @exception EventException
	 */
	public List<BkgTsCoffTmVO> searchTsBkgCoffTm(TsBkgListForBayPlanInputVO tsBkgListForBayPlanInputVO, String subChk) throws EventException;

	/**
	 * ESM_BKG_1157:checkTsCloseByBayPlan<br>
	 * Transshipment Close에 해당되는지 확인<br>
	 * 
	 * @param VvdAssignTargetBkgVO[] vvdAssignTargetBkgVOs
	 * @param String newVvd
	 * @return String
	 * @exception EventException
	 */
	public String checkTsCloseByBayPlan(VvdAssignTargetBkgVO[] vvdAssignTargetBkgVOs, String newVvd) throws EventException;
	
	/**
	 * ESM_BKG_1157:checkTsCloseByBayPlan<br>
	 * Transshipment Close에 해당되는지 확인<br>
	 * 
	 * @param BkgVvdVO[] BkgVvdVOs
	 * @param BkgBlNoVO[] bkgBlNoVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkTsCloseByBayPlanForVvdPortAssign(BkgVvdVO[] bkgVvdVOs,
			BkgBlNoVO[] bkgBlNoVOs) throws EventException;
	
	/**
	 * ESM_BKG_1174: NMC (Non-Manipulation Certificate)<br>
	 * 
	 * @param String bkgNo
	 * @param String blNo
	 * @param String cntrNo
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchNmc(String bkgNo, String blNo, String cntrNo) throws EventException;
}