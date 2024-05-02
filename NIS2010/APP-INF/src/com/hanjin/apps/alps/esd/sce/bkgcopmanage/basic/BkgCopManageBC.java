/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManage.java
*@FileTitle : Bkg Cop Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : Kim In-soo
*@LastVersion : 1.0
*
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic;

import java.util.List;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.CntrDiffVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.CopHdrToBeCopiedVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.ManRplnRsltVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SceActTmlRtvVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SearchCopVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForVVDChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.PrdBkgCopMapVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;


/**
 * Back End Job 처리를 담당<br>
 * @author poong yeon cho
 * @see BkgCopManageBC 참조
 * @since J2EE 1.6
 */
public interface BkgCopManageBC  {

	/**
	 * 미주 Outbound, 구주 In / outbound 의 carrier's haulage 의 경우 booking 에서 confirm 된 TRO 정보를 받아
	 * SCE_TRO_MAPG, SCE_COP_HDR 에 해당 정보를 관리한다. 
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param pctl_no
	 * @param area_conti_cd
	 * @throws EventException
	 */
	public void confirmTro(String bkg_no, String tro_seq, String tro_sub_seq,
			String io_bnd_cd, String pctl_no, String area_conti_cd) throws EventException;
	
	
	
	
	/**
	 * TRO 가 unconfirm 되었을 경우 SCE_COP_HDR 의 flag 변경, SCE_TRO_MAPG 정보 삭제를 수행한다.
	 * Booking 에서 term 이 변경될 때 Door S/O 가 발행되지 않은 TRO 에 대해 자동으로 unconfirm 을 진행하며
	 * 이때 booking 단위 일괄 정리를 위해 호출한다.   
	 * @param bkg_no
	 * @param io_bnd_cd
	 * @throws EventException
	 */
	public void unconfirmTro(String bkg_no, String io_bnd_cd) throws EventException;
	
	/**
	 * TRO 가 unconfirm 되었을 경우 SCE_COP_HDR 의 flag 변경, SCE_TRO_MAPG 정보 삭제를 수행한다.
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @throws EventException
	 */
	public void unconfirmTro(String bkg_no, String tro_seq, String tro_sub_seq,
			String io_bnd_cd) throws EventException;
	
	/**
	 * 최초 booking creation 될 때 BKG_QUANTITY 의 CNTR_TPSZ 별 개수 대로 COP 를 생성한다.
	 * @param bkg_no
	 * @param pctl_no
	 * @throws EventException
	 */
	public void createBkg(String bkg_no, String pctl_no) throws EventException;
	
	/**
	 * ESD_SCE_9999 화면을 통한 manual 작업에서 사용
	 * @param prdBkgCopMapVO
	 * @throws EventException
	 */
	public void updateBkg(PrdBkgCopMapVO prdBkgCopMapVO) throws EventException;
	
	/**
	 * 각종 BOOKING REPLAN 작업이 있을 때 호출 되고 PRD 에서 생성한 PRD_BKG_COP_MAP TABLE 의 OPERATION 명세 대로
	 * REPLAN 을 수행한다.
	 * (QTY 증감, CNTR TPSZ 변경, TERM 변경, ROUTE 재 생성 등 각종 BOOKING 변경 사항)
	 * @param bkg_no
	 * @param mapg_seq
	 * @throws EventException
	 */
	public void updateBkg(String bkg_no, String mapg_seq) throws EventException;
	
	/**
	 * VVD 변경시 VCL EDI EVNET 발송
	 * @param updBkgForVVDChgVO
	 * @throws EventException
	 */
	public void updateBkgForVVDChange(UpdBkgForVVDChgVO updBkgForVVDChgVO) throws EventException;
	
	/**
	 * BKG COD시 SCE COD 데이터 생성
	 * @param updBkgForBkgCodVO
	 * @throws EventException
	 */
	public void updateBkgForBkgCod(UpdBkgForBkgCodVO updBkgForBkgCodVO) throws EventException;
	
	/**
	 * Booking creation 의 CNTR 탭에서 container 가 삭제되고 저장시 호출되어 COP 의 CNTR 정보를 삭제한다.
	 * @param bkg_no
	 * @param cntr_no
	 * @param isPartial
	 * @throws EventException
	 */
	public void detachCntr(String bkg_no, String cntr_no, String isPartial) throws EventException;
	
	/**
	 * booking cancel 시 호출되어 관련 COP 를 cancel 시킨다.
	 * @param bkg_no
	 * @throws EventException
	 */
	public void cancelBkg(String bkg_no) throws EventException;
	
	
	/**
	 * Booking creation 의 CNTR 탭에서 container 가 add 되고 저장시 호출되어 COP 의 container 정보를 변경한다.
	 * @param bkg_no
	 * @param cntr_no
	 * @param isPartial
	 * @throws EventException
	 */
	public void attachCntr(String bkg_no, String cntr_no, String isPartial) throws EventException;
	
	
	/**
	 * booking combine 시 호출되어 org_bkg_no 에 할당된 COP 를 combined_bkg_no 로 소속 변경
	 * org_bkg_no 의 COP 가 combined_bkg_no 에 존재하는 COP 와 동일한 container 를 가진 경우 등 partial 관계를 적용하여
	 * booking no 의 변경 / cancel 등의 작업을 수행하며 Master cop no 의 정제 및 기 발행된 S/O 의 booking no 수정을 수행한다.
	 * @param org_bkg_no
	 * @param combined_bkg_no
	 * @param combineTroNewSeqVOs
	 * @throws EventException
	 */
	public void combineBkg(String[] org_bkg_no, String combined_bkg_no, List<CombineTroNewSeqVO> combineTroNewSeqVOs) throws EventException;
//	public void combineBkg(String[] org_bkg_no, String combined_bkg_no) throws EventException;

	
	/**
	 * ESD_SCE_9999 화면을 통한 manual 작업에서 사용
	 * @param org_bkg_no
	 * @param new_bkg_no
	 * @throws EventException
	 */
	public void splitBkg(String org_bkg_no, String[] new_bkg_no) throws EventException; 
	
	/**
	 * booking split 화면에서 호출되며 PRD 에서 생성한 PRD_BKG_COP_MAP 의 OPERATION 명세에 따라 split 작업을 수행한다.
	 * VVD 가 변경될 경우는 본 method 호출 후 updateBkg method 를 booking 에서 재 호출한다.
	 * @param org_bkg_no
	 * @param new_bkg_no
	 * @param mapg_seq
	 * @throws EventException
	 */
	public void splitBkg(String org_bkg_no, String[] new_bkg_no, String[] mapg_seq) throws EventException; 
	
	/**
	 * PRD 에서 TRO 로 인한 PC 생성을 위하여 TRO 가 mapping 될 cop_no 를 선정하기 위하여 호출한다.
	 * @param bkg_no
	 * @param tro_seq
	 * @param tro_sub_seq
	 * @param io_bnd_cd
	 * @param area_conti_cd
	 * @return SearchCopVO
	 * @throws EventException
	 */
	public SearchCopVO searchCopNoFrmPrdByTro (String bkg_no, String tro_seq, String tro_sub_seq, String io_bnd_cd, String area_conti_cd) throws EventException;
	
	
	/**
	 * Container 를 org_bkg_no 의 booking 에서 (복수개의) dest_bkg_no 인 booking 으로 이동시킨다.
	 * 이때 booking 의 partial 여부에 따라 master cop no 의 정제가 이뤄진다. (S/O 의 booking no 변경도 병행)
	 * @param org_bkg_no
	 * @param dest_bkg_no
	 * @param cntr_no
	 * @throws EventException
	 */
	public void moveCntr (String org_bkg_no, String[] dest_bkg_no, String cntr_no) throws EventException;
	
	/**
	 * container confirm 시 혹시 누락된 attach / detach 현황이 있는지 확인하여 재 작업하고 
	 * qty 정제 작업도 수행한다.
	 * @param bkg_no
	 * @throws EventException
	 */
	public void confirmCntr (String bkg_no) throws EventException;
	
	/**
	 * booking split, create, copy 등 booking no 가 신규 생성 / 변경되는 case 에서 booking 에서 호출하여
	 * SCE_COP_HDR 의 rail_rcv_coff_fm_dt, rail_rcv_coff_to_dt 를 변경한다.
	 * @param bkg_no
	 * @param rail_rcv_coff_fm_dt
	 * @param rail_rcv_coff_to_dt
	 * @param upd_usr_id
	 * @return int 
	 * @throws EventException
	 */
	public int modifyRailRcvCoffDt(String bkg_no, String rail_rcv_coff_fm_dt, String rail_rcv_coff_to_dt, String upd_usr_id) throws EventException;
	
	/**
	 * container attach 후 기 입수된 Actual 을 재 매핑하기 위해 act_umch_tp_cd = '00' 으로 변경
	 * @param bkg_no
	 * @param cntr_no
	 * @return int
	 * @throws EventException
	 */
	public int initializeSceActRcvIf(String bkg_no, String cntr_no) throws EventException;
	
	/**
	 * Terminal change 결과를 조회
	 * @param fm_dt
	 * @param to_dt
	 * @return List<SceActTmlRtvVO>
	 * @throws EventException
	 */
	public List<SceActTmlRtvVO> searchActTmlIfDtl (String fm_dt, String to_dt) throws EventException;
	
	/**
	 * master cop no 의 diff 를 조회한다.
	 * @param fm_dt
	 * @param to_dt
	 * @return List<SceCopHdrVO>
	 * @throws EventException
	 */
	public List<SceCopHdrVO> searchMstCopNoDiff (String fm_dt, String to_dt) throws EventException;
	
	/**
	 * @param fm_dt
	 * @param to_dt
	 * @return List<CntrDiffVO>
	 * @throws EventException
	 */
	public List<CntrDiffVO> searchCntrDiff(String fm_dt, String to_dt) throws EventException;
	
	/**
	 * manual replan 이전 mst_cop_no, bkg_no, pctl_no 를 조회
	 * @param cop_no
	 * @return
	 * @throws EventException
	 */
	public ManRplnRsltVO searchPresetBfRpln(String cop_no) throws EventException;
	
	/**
	 * cop 를 copy 하여 신규 cop_no 를 부여하여 생성
	 * @param bkg_no
	 * @param cop_sts_cd
	 * @param cop_upd_rmk
	 * @return
	 * @throws EventException
	 */
	public List<CopHdrToBeCopiedVO> copyCop(String bkg_no, String cop_sts_cd, String cop_upd_rmk) throws EventException;
	
	/**
	 * Mas 의 비용계산 일배치로 bkg 을 넘김
	 * @param bkgNoSet
	 * @throws EventException
	 */
	public void interfaceCoaDailyBtch (Set<String> bkgNoSet) throws EventException ;
	
	/**
	 * booking 의 호출을 받아 bkg_no 와 연관된 COP 의 status 를 복구
	 * @param String bkg_no
	 * @throws EventException
	 */
	public void reviveCopsByBkgRqst (String bkg_no) throws EventException ;
	
}