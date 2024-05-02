/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestBC.java
*@FileTitle : Attorney Search Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.11 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCargoCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgEdiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgInqModiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListModiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.DgValidationCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederNameVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsEurDgVO;

/**
 * NIS2010-TerminalDocumentation Business Logic Command Interface<br>
 * - NIS2010-TerminalDocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyoung Jong Yun
 * @see
 * @since J2EE 1.4
 */
public interface SpecialManifestBC {

	
	/**
	 * 포워더 코드 및 desc정보를 조회한다.
	 * 
	 * @param  FwdrListCondVO fwdrListCondVO
	 * @return List<FwdrListVO>
	 * @throws EventException
	 */
	public List<FwdrListVO> searchForwarderList(FwdrListCondVO fwdrListCondVO) throws EventException;
	
	/**
	 * 포워더 코드 및 desc정보를 입력한다.<br>
	 * 
	 * @param  FwdrListVO[] fwdrListModiVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
    public void manageForwarderList(FwdrListVO[] fwdrListModiVO, SignOnUserAccount account) throws EventException;

    /**
     * Bay plan 정보를 조회한다.<Br>
     * 
     * @return List<BayPlanListVO>
     * @throws EventException
     */
	public List<BayPlanListVO> searchBayPlanList() throws EventException;

    /**
     * Bay plan 상세 정보를 조회한다.<Br>
     * 
     * @param BayPlanCondVO bayPlanCondVO
     * @return List<BayPlanListDetailVO>
     * @throws EventException
     */
	public List<BayPlanListDetailVO> searchBayPlanDetailListByBaiId(BayPlanCondVO bayPlanCondVO) throws EventException;
	
    /**
     *  VVD와 Port를 가지고 Bay Plan에서 Cell position을 자동으로 가져 왔는 지 여부를 조회 한다.<Br>
     * 
	 * @param  DgListCondVO dgListCondVO
     * @return String
     * @throws EventException
     */
	public String searchIstowageInfo(DgListCondVO dgListCondVO) throws EventException;

    /**
     *  수출,수입, T/S, Barge별로 전송 대상을 조회한다.<Br>
     * 
	 * @param  DgListCondVO dgListCondVO
     * @return List<DgListDetailVO>
     * @throws EventException
     */
	public List<DgListDetailVO> searchDgManifestList(DgListCondVO dgListCondVO) throws EventException;

	/**
	 * UN No별 special 정보를 관리한다.<br>
	 * 
	 * @param  SpecialListCondVO specialListCondVO
	 * @return List<SpecialListDetailVO>
	 * @throws EventException
	 */
	public List<SpecialListDetailVO> searchSpecialList(SpecialListCondVO specialListCondVO) throws EventException;
	
	/**
	 * 포워더 코드 및 desc정보를 입력한다.<br>
	 * 
	 * @param  SpecialListVO[] specialListVO
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
    public void manageSpecialList(SpecialListVO[] specialListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 위험물 정보들을 저장한다.<br>
	 * 
	 * @param  DgListModiVO[] dgListModiVOs
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
    public void manageDgManifestList(DgListModiVO[] dgListModiVOs, SignOnUserAccount account) throws EventException;
    
    /**
     * Danger cargo 컨테이너 목록 조회<br>
     * 
     * @param  DgCargoCondVO dgCargoCondVO
     * @return List<BkgCstmsEurDgVO>
     * @throws EventException
     */
    public List<BkgCstmsEurDgVO> searchBkgCstmsEurDgList(DgCargoCondVO dgCargoCondVO) throws EventException;    
	
    /**
     * Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
     * 
     * @param  DgCargoCondVO dgCargoCondVO
     * @return DgInqModiVO
     * @throws EventException
     */
    public List<DgInqModiVO> searchDgCargoInfo(DgCargoCondVO dgCargoCondVO) throws EventException;    
		
    /**
     * Vessel Code롤 Name울 조회한다.<br>
     * 
     * @param  DgListCondVO dgListCondVO
     * @return String
     * @throws EventException
     */
    public String searchVesselName(DgListCondVO dgListCondVO) throws EventException;
    
    /**
     * Berth Code로 YardName을 조회한다.<br>
     * 
     * @param  DgListCondVO dgListCondVO
     * @return String
     * @throws EventException
     */
    public String searchYardName(DgListCondVO dgListCondVO) throws EventException;

    /**
     * Forward Code로 Forward Name을 조회한다.<br>
     * 
     * @param  DgListCondVO dgListCondVO
     * @return String
     * @throws EventException
     */
    public String searchForwarderName(DgListCondVO dgListCondVO) throws EventException;
    
    /**
     * UN NO로 NAME을 조회한다.<br>
     * 
     * @param  DgListCondVO dgListCondVO
     * @return String
     * @throws EventException
     */
    public String searchUnnoName(DgListCondVO dgListCondVO) throws EventException;

    /**
     * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
     * 
     * @param  DgCargoCondVO dgCargoCondVO
     * @return List<DgCntrInfoListVO>
     * @throws EventException
     */
    public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws EventException; 
    
    /**
     * 해당 컨테이너에에 속한 Cgo Seq 리스트를 조회한다.(셋팅을 위해)<br>
     * 
     * @param  DgCargoCondVO dgCargoCondVO
     * @return List<DgCntrInfoListVO>
     * @throws EventException
     */
    public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws EventException; 
    
	/**
	 * 위험물 상세 정보들을 저장한다.<br>
	 * 
	 * @param  DgInqModiVO dgInqModiVO
	 * @param  SignOnUserAccount account
	 * 
	 * @throws EventException
	 */
    public void modifyDgInquiry(DgInqModiVO dgInqModiVO, SignOnUserAccount account) throws EventException;
    
    /**
     * 위험물 Sent결과를 조회해 온다.<br>
     * 
     * @param  SendHistoryCondVO sendHistoryCondVO
     * @return List<SendHistoryDetailVO>
     * @throws EventException
     */
    public List<SendHistoryDetailVO> searchSendHistory(SendHistoryCondVO sendHistoryCondVO) throws EventException; 
    
	/**
	 * 구주위험물 세관신고 위해 FlatFile을 생성 및 전송
	 * 
	 * @param  DgEdiVO[] dgEdiVO
	 * @param  account
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> sendDgManifestList(DgEdiVO[] dgEdiVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다. 
	 *  
	 * @param  String rcvMsg
	 * @param  String userId
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String userId) throws EventException;
	
	/**
	 * bl_no / pol_cd / pod_cd를 입력시 validation<br>
	 * 
	 * @param  DgValidationCondVO dgValidationCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgValidationByVvdKey(DgValidationCondVO dgValidationCondVO) throws EventException;
	
	/**
	 * cntr_no를 입력시 validation<br>
	 * 
	 * @param  DgValidationCondVO dgValidationCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgValidationByCntrKey(DgValidationCondVO dgValidationCondVO) throws EventException;
	
 
	/**
	 * vvd, port로 로컬 위험물테이블에 저장된 상태인지 조회한다.<br>
	 * 
	 * @param  DgListCondVO dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgLocalSaveYn(DgListCondVO dgListCondVO) throws EventException;
	
    /**
     * B/L No.로 BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
     * 
     * @param  DgListCondVO dgListCondVO
     * @return List<DgListDetailVO>
     * @throws EventException
     */
    public List<DgListDetailVO> searchDgInfoAtBkgDgByBlNo(DgListCondVO dgListCondVO) throws EventException;
	
    /**
     * 위험물 조회조건 Declaration Type, VVD, PORT을 기준으로 먼저 세관쪽 DG테이블에 등록되어 있는지를 판단한다.<br>
     * 
     * @param  DgListCondVO dgListCondVO
     * @return String
     * @throws EventException
     */
    public String searchDgListCopyYn(DgListCondVO dgListCondVO) throws EventException; 
	
    /**
	 * Feeder Name, Lloyd No를 조회한다.<br>
     * 
	 * @return List<FeederNameVO>
     * @throws EventException
     */
    public List<FeederNameVO> searchDgFeederNameList() throws EventException;
    
    /**
     * 위험물 대상을 조회해한(세관 쪽에 등록이 안된 booking쪽 데이타만 조회한다.<Br>
     * booking쪽 데이타를 추가 하가위해<br>
     * 
	 * @param DgListCondVO dgListCondVO
     * @return List<DgListDetailVO>
     * @throws EventException
     */
	public List<DgListDetailVO> searchAppendDgInfoAtBkgDg(DgListCondVO dgListCondVO) throws EventException;
 
	/**
	 * Feeder 정보를 조회한다.
	 * @param FeederInfoVO feederInfoVO
	 * @return List<FeederInfoVO>
	 * @throws EventException
	 */
	public List<FeederInfoVO> searchFeederInfoList(FeederInfoVO feederInfoVO) throws EventException;	
	
	/**
	 * Feeder 정보를 추가,수정,삭제 한다.
	 * @param FeederInfoVO[] feederInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
    public void manageFeederInfoList(FeederInfoVO[] feederInfoVOs, SignOnUserAccount account) throws EventException;
	
    
}