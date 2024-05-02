/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IncidentSurveyBC.java
 *@FileTitle : IncidentSurveyBC 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmInciVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSlvVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.CniCgoClmSveyVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentClaimInquiryVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentCreationVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.IncidentInquiryVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.SalvageVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.vo.SurveyVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * CNI Code Business Logic Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface IncidentSurveyBC {
	
    // ===========================================================================
    // 양정란
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0012] Survey
	// ---------------------------------------------------------------------------
	/**
	 * Survey 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category searchSurveyList 
	 * @param String cgoClmNo
     * @return List<SurveyVO> 
     * @throws EventException
     */
	public List<SurveyVO> searchSurveyInfo(String cgoClmNo) throws EventException;	
	
	/**
	 * Survey 입력, 수정<br>
	 * 
	 * @author 양정란
	 * @category CPS_CNI_0012
	 * @category manageSurvey
	 * @param CniCgoClmSveyVO cniCgoClmSveyVO
	 * @return String 
	 * @exception EventException
	 */
	public String manageSurvey(CniCgoClmSveyVO cniCgoClmSveyVO) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0013] Salvage
	// ---------------------------------------------------------------------------
	/**
	 * Salvage 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category searchSalvageInfo 
	 * @param String cgoClmNo
     * @return List<SalvageVO> 
     * @throws EventException
     */
	public List<SalvageVO> searchSalvageInfo(String cgoClmNo) throws EventException;
	
	/**
	 * Salvage 입력, 수정<br>
	 * 
	 * @author 양정란
	 * @category CPS_CNI_0013
	 * @category manageSalvage
	 * @param CniCgoClmSlvVO cniCgoClmSlvVO
	 * @return String 
	 * @exception EventException
	 */
	public String manageSalvage(CniCgoClmSlvVO cniCgoClmSlvVO) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0030] Incident-Creation
	// ---------------------------------------------------------------------------
	/**
	 * Incident-Creation 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchIncidentCreationInfo 
	 * @param String cgoClmInciNo
     * @return List<IncidentCreationVO> 
     * @throws EventException
     */
	public List<IncidentCreationVO> searchIncidentCreationInfo(String cgoClmInciNo) throws EventException;
	
	/**
	 * location 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchLocation 
	 * @param String locCd
     * @return searchLocation
     * @throws EventException
     */
	public String searchLocation(String locCd) throws EventException;	
	
	/**
	 * VVD 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category searchVesselName 
	 * @param String vslCd
     * @return searchLocation
     * @throws EventException
     */
	public String searchVesselName(String vslCd) throws EventException;		
	
	/**
	 * Incident-Creation 입력, 수정<br>
	 * 
	 * @author 양정란
	 * @category CPS_CNI_0030
	 * @category manageIncidentInfo
	 * @param CniCgoClmInciVO cniCgoClmInciVO
	 * @return String 
	 * @exception EventException
	 */
	public String manageIncident(CniCgoClmInciVO cniCgoClmInciVO) throws EventException;	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0031] Incident-Inquiry
	// ---------------------------------------------------------------------------
	/**
	 * Incident-Inquiry 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0031
	 * @category searchIncidentInquiryList 
	 * @param IncidentInquiryCondVO incidentInquiryCondVO
     * @return List<IncidentInquiryVO> 
     * @throws EventException
     */
	public List<IncidentInquiryVO> searchIncidentInquiryList(IncidentInquiryCondVO incidentInquiryCondVO) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0032] Incident-Claim Inquiry
	// ---------------------------------------------------------------------------
	/**
	 * Incident-Claim Inquiry 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0032
	 * @category searchIncidentClaimInquiryList 
	 * @param String cgoClmInciNo
	 * @param String pageNo
     * @return List<IncidentClaimInquiryVO> 
     * @throws EventException
     */
	public List<IncidentClaimInquiryVO> searchIncidentClaimInquiryList(String cgoClmInciNo, String pageNo) throws EventException;	
	

	/**
	 * Claim Main Survey 입력, 수정<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category manageClaimMainSurvey
	 * @param CniCgoClmSveyVO cniCgoClmSveyVO
	 * @exception EventException
	 */
	public void manageClaimMainSurvey(CniCgoClmSveyVO cniCgoClmSveyVO) throws EventException;
	
}