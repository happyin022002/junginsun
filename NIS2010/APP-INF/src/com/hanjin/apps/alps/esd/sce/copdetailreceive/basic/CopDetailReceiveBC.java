/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveBC.java
*@FileTitle : CopDetailReceived Actual Mapping 
*Open Issues : 
*@Created Date : 2009-08-24
*@FirstModifier : JeongSeon An
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.basic;
   
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.event.CopDetailReceiveEvent;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.CopDtlActMapgVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceCopSkdHisVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceVpsIfVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ENIS-SCE Business Logic Command Interface<br>
 * Cop Detail Received Actual Mapping  <br>
 *
 * @author JeongSeon An
 * @see CopDetailReceiveEvent 참조
 * @since J2EE 1.6
 */

public interface CopDetailReceiveBC {

	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param actVo SceActRcvIfVO 
	 * @throws EventException ...
	 */
	public void createCOPMVMT(SceActRcvIfVO actVo) throws EventException;

	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (many rows) <br>
	 * 
	 * @param actVos List<SceActRcvIfVO> 
	 * @throws EventException ...
	 */
	public void createCOPMVMT(List<SceActRcvIfVO> actVos) throws EventException;
	
	/**
	 * SEARCH AUTO MVMT : From Others MVMT <br>
	 * 
	 * @param searchActVo SceActRcvIfVO 
	 * @return List<SceActRcvIfVO>
	 * @throws EventException ...
	 */
	public  List<SceActRcvIfVO>  searchMvmtInclAutoCase(SceActRcvIfVO searchActVo) throws EventException;	

	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @return boolean 
	 * @throws EventException ...
	 */
	public boolean addSceActRcvIf(SceActRcvIfVO actVo) throws EventException;

	/**
	 * INSERT INTO SCE_SVC_PTAL_ACT_IF : From MVMT to SCE (1row)<br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @return boolean
	 * @throws EventException ...
	 */
	public boolean addSceSvcPtalActIfVO(SceActRcvIfVO actVo) throws EventException;

	/**
	 * INSERT INTO SCE_CNTR_STS_MSG_TGT : From MVMT to SCE (1row)<br>
	 * 
	 * @param actVo SceActRcvIfVO 
	 * @return boolean
	 * @throws EventException ...
	 */
	public boolean addSceCntrStsMsgTgtVO(SceActRcvIfVO actVo) throws EventException;
	
	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From VSK to SCE (1row)<br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @throws EventException ...
	 */
	public void sendVslSkdSceIf(SceActRcvIfVO actVo) throws EventException;

	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From 322 to SCE (1row)<br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @throws EventException ...
	 */
	public void create322SceIf(SceActRcvIfVO actVo) throws EventException;

	/**
	 * INSERT INTO SCE_ACT_RCV_IF : From 322 to SCE (1row)<br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @param bkgNo String
	 * @throws EventException ...
	 */
	public void create322SceIf(SceActRcvIfVO actVo, String bkgNo) throws EventException;

	/**
	 * 214 외부 인터페이스, Actual Mapping <br>
	 * 
	 * @param dtlMapgVO CopDtlActMapgVO
	 * @param callType String
	 * @throws EventException ...
	 */
	public void create214SceIf(CopDtlActMapgVO dtlMapgVO, String callType) throws EventException;	
	
	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduled COP Information (1row)<br>
	 * 
	 * @param skdVo SceCopSkdHisVO 
	 * @throws EventException ...
	 */
	public void scheduleCopDetailBound(SceCopSkdHisVO skdVo) throws EventException;

	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduled COP Information (1row)<br>
	 * 
	 * @param list ArrayList 
	 * @throws EventException ...
	 */
	public void scheduleCopDetailOcean(ArrayList<?> list)  throws EventException; 
	
	/**
	 * Search EstimateDate GAP : From Before EstimateDate to After EstimateDate (1row)<br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return SceCopSkdHisVO
	 * @throws EventException ...
	 */
	public SceCopSkdHisVO searchGapDatetime(SceCopSkdHisVO skdVo) throws EventException;	

//	/**
//	 * SetUp Scheduling Information : Bound Schedule Duplication Check <br>
//	 * 
//	 * @return void
//	 * @throws EventException ...
//	 */
//	public String checkDuplicationSchedule(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * SetUp Scheduling Information : Get COP Info. Before Schedule <br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return SceCopSkdHisVO
	 * @throws EventException ...
	 */
	public SceCopSkdHisVO searchCopDetailBeforeSchedule(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * SetUp Scheduling Information : By Actual Action (1row)<br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return SceCopSkdHisVO
	 * @throws EventException ...
	 */
	public SceCopSkdHisVO searchScheduleInformationByAct(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * SetUp Scheduling Information : By Vps Action (1row)<br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return SceCopSkdHisVO
	 * @throws EventException ...
	 */
	public SceCopSkdHisVO searchScheduleInformationByVps(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * SetUp Scheduling Information : Search COP Header (1row)<br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return SceCopSkdHisVO
	 * @throws EventException ...
	 */
	public SceCopSkdHisVO searchCopHeader(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * SetUp Scheduling Information : Search SceCopHisKey (1row)<br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return SceCopSkdHisVO
	 * @throws EventException ...
	 */
	public SceCopSkdHisVO searchSceCopSkdHisKey(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * CopDetail Scheduling : Bound의 마지막(MAX) COP Detail Seq구하기 <br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return SceCopSkdHisVO
	 * @throws EventException ...
	 */
	public SceCopSkdHisVO searchMaxCopDetailByBound(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * CopDetail Scheduling : Scheduling COP Detail <br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return boolean
	 * @throws EventException ...
	 */
	public boolean modifySceCopDetailEstmDtByBound(SceCopSkdHisVO skdVo) throws EventException;	

	/**
	 * INSERT INTO SCE_COP_SKD_HIS : Scheduling Log (1row)<br>
	 * 
	 * @param skdVo SceCopSkdHisVO
	 * @return boolean
	 * @throws EventException ...
	 */
	public boolean addSceCopSkdHis(SceCopSkdHisVO skdVo) throws EventException;

	
	/**
	 * MVMT(CTM) & 322 Actual Mapping<br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @param pro_flg String
	 * @throws EventException ...
	 */
	public void copDetailReceiveMVMT(SceActRcvIfVO actVo, String pro_flg) throws EventException;
	
	/**
	 * SPP Actual Mapping <br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @param pro_flg String
	 * @throws EventException ...
	 */
	public void copDetailReceiveSPP(SceActRcvIfVO actVo, String pro_flg) throws EventException;
	
	/**
	 * VSK Actual Mapping <br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @param pro_flg String
	 * @param copMapgVO CopDtlActMapgVO
	 * @param cntCopAll int 
	 * @param currCop int 
	 * @throws EventException ...
	 */
	public void copDetailReceiveVessel(SceActRcvIfVO actVo, String pro_flg, CopDtlActMapgVO copMapgVO, int cntCopAll, int currCop) throws EventException;
	
	/**
	 * MANUAL Actual Mapping<br>
	 * @param cop_no String
	 * @param cop_dtl_seq String
	 * @param act_dt String
	 * @param usr_id String
	 * @param prc_flg String
	 * @param act_sts_cd String
	 * @param nod_cd String
	 * @param act_cd String
	 * 
	 * @throws EventException ...
	 */
	public void copDetailReceiveMANUAL(String cop_no, String cop_dtl_seq, String act_dt, String usr_id, String prc_flg, String act_sts_cd, String nod_cd, String act_cd) throws EventException;
	
	/**
	 * REPLAN관련  Actual Mapping<br>
	 * 
	 * @param actVo SceActRcvIfVO
	 * @throws EventException ...
	 */
	public void copDetailReceiveREPLAN(SceActRcvIfVO actVo) throws EventException;
	
	/**
	 * Error 종료 처리 : Sce Act Rcv If 결과 업데이트 <br>
	 * 
	 * @param actVO SceActRcvIfVO
	 * @return boolean
	 * @throws EventException ...
	 */
	public boolean modifySceActRcvIfByError(SceActRcvIfVO actVO) throws EventException;	
	
	/**
	 * VSK Schedule Batch Logic
	 * 
	 * @param vpsVO SceVpsIfVO 
	 * @return String
	 * @throws EventException ... 
	 */
	public String copDetailReceiveVSLSKD(SceVpsIfVO vpsVO) throws EventException;	
	
	/**
	 * Modify Actual Data Receive Date By Temp Role
	 * 
	 * @param actVo SceActRcvIfVO
	 * @throws EventException ...
	 */
	public void modifyActDatRcvDtByTmpRole (SceActRcvIfVO actVo) throws EventException;
	
	/**
	 * Modify Actual Data Receive Date By Temp VSK
	 * 
	 * @param actVo SceActRcvIfVO
	 * @throws EventException ...
	 */
	public void modifyActDatRcvDtByTmpVSK(SceActRcvIfVO actVo) throws EventException;
	
	/**
	 * OP 가 누락된 case 에 대해 OC / VL 처리 시 OC / VL 의 movement cycle no 또는 이전 no 로 OP 를 찾고 저장한다.
	 * @param SceActRcvIfVO sceActRcvIfVO
	 * @return List<SceActRcvIfVO>
	 * @throws DAOException
	 */
	public List<SceActRcvIfVO> manageMissingOPByMvmt (SceActRcvIfVO sceActRcvIfVO) throws EventException;
	
}
