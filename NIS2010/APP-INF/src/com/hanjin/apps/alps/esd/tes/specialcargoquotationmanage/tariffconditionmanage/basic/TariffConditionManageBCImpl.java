/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffConditionManageBCImpl.java
*@FileTitle : TariffConditionManageBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.06
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.03.06 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.TariffConditionManageSC;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.event.EsdTes0050Event;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.integration.TariffConditionManageDBDAO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo.ComTesCondDtlVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.tariffconditionmanage.vo.ComTesTrfCondVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesObjListVO;
import com.hanjin.syscommon.common.table.TesTrfCondDtlVO;
import com.hanjin.syscommon.common.table.TesTrfCondVO;


/**
 * ALPS-TariffConditionManage Business Logic Command Interface<br>
 * - ALPS-TariffConditionManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see TariffConditionManageSC 참조
 * @since J2EE 1.6
 */
public class TariffConditionManageBCImpl extends BasicCommandSupport implements TariffConditionManageBC {

	// Database Access Object
	private transient TariffConditionManageDBDAO dbDao = null;

	// Login User Information
//	private SignOnUserAccount account = null;
	
	/** 
	 * TariffConditionManageBCImpl 객체 생성<br>
	 * TariffConditionManageDBDAO 생성한다.<br>
	 */
	public TariffConditionManageBCImpl() {
		dbDao = new TariffConditionManageDBDAO();
	}
	
	/**
	 * Tariff Condition List를 조회한다.<br>
	 * @param ComTesTrfCondVO comTesTrfCondVO
	 * @return List<ComTesTrfCondVO>
	 * @exception EventException
	 */
	public List<ComTesTrfCondVO> searchTariffCond(ComTesTrfCondVO comTesTrfCondVO) throws EventException {
		try {
			return dbDao.searchTariffCond(comTesTrfCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Tariff Condition 항목을 조회한다.<br>
	 * @param tesTrfCondVO
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchTariffCondItem(TesTrfCondVO tesTrfCondVO) throws EventException {
		try {
			return dbDao.searchTariffCondItem(tesTrfCondVO,TRF_COND_USE_TP_DISPLAY);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Tariff Object 항목을 조회한다.<br>
	 * @param tesObjListVO
	 * @return List<TesObjListVO>
	 * @throws EventException
	 */
	public List<TesObjListVO> searchTariffObjectList(TesObjListVO tesObjListVO) throws EventException {
		try {
			return dbDao.searchTariffObjectList(tesObjListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Tariff Condition 항목을 조회한다.<br>
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchTariffCondItem2(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		List<DBRowSet> arrList = new ArrayList<DBRowSet>();
		
		EsdTes0050Event event = (EsdTes0050Event)e;
		TesTrfCondVO tesTrfCondVO = event.getTesTrfCondVO();
			
		DBRowSet hdrSet = null;
		DBRowSet dtrbSetDP = null;
		DBRowSet dtrbSetSYS = null;
		
		try {
			if (tesTrfCondVO!=null){
				hdrSet 	= dbDao.searchTariffCondHdr(event.getTesTrfCondVO());
				dtrbSetDP = dbDao.searchTariffCondItem(event.getTesTrfCondVO(),TRF_COND_USE_TP_DISPLAY);
				dtrbSetSYS = dbDao.searchTariffCondItem(event.getTesTrfCondVO(),TRF_COND_USE_TP_SYSTEM);
				arrList.add(hdrSet);
				arrList.add(dtrbSetDP);
				arrList.add(dtrbSetSYS);
				
				eventResponse.setRsList(arrList);
				eventResponse.setETCData("successFlag", "SUCCESS");				
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * condition의 참조 여부 확인
	 * @param e
	 * @return String
	 * @throws EventException
	 */
	public String checkTariffCondRef(Event e) throws EventException {
		EsdTes0050Event	event = (EsdTes0050Event)e;
		TesTrfCondVO tesTrfCondVO = null;
		String retval = null;
		
		try {
			tesTrfCondVO = event.getTesTrfCondVO();
			if (tesTrfCondVO!=null) {
				if (tesTrfCondVO.getCondNo()!=null && !tesTrfCondVO.getCondNo().trim().equals("")) {
					retval = dbDao.checkTariffCondRef(tesTrfCondVO);
					if (retval!=null && !retval.trim().equals("")){
						if (retval.trim().equals("Y")){
							throw new EventException("\nCONDITION NO. NOT TO BE DELETED!!!\n");
						}
					} else {
						throw new EventException("\nCONDITION NO. REFERENCE CHECK EXCEPTION!\n");
					}
				} else {
					throw new EventException("\nCONDITION NO. not found exception!\n");
				}
			} else {
				log.error("\nCONDITION VO not found exception!\n");
				throw new EventException("\nCONDITION VO not found exception!\n");
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}
	
	/**
	 * condition 삭제
	 * @param e
	 * @throws EventException
	 */
	public void removeTariffCondInfo(Event e) throws EventException {
		EsdTes0050Event	event = (EsdTes0050Event)e;
		TesTrfCondVO tesTrfCondVO = null;
		SignOnUserAccount account = event.getSignOnUserAccount();
		
		try {
			tesTrfCondVO = event.getTesTrfCondVO();
			if (tesTrfCondVO!=null) {
				tesTrfCondVO.setCreUsrId(account.getUsr_id());
				tesTrfCondVO.setUpdUsrId(account.getUsr_id());
				if (tesTrfCondVO.getCondNo()!=null && !tesTrfCondVO.getCondNo().trim().equals("")) {
					dbDao.removeTrfCondHdr(tesTrfCondVO);
				}
			} else {
				log.error("");
				throw new EventException("");
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Tariff Condition 항목의 data을 관리한다.<br>
	 * @param e
	 * @throws EventException
	 */
	public void manageTariffCondDtlInfo(Event e) throws EventException {

		EsdTes0050Event	event = (EsdTes0050Event)e;
		TesTrfCondVO tesTrfCondVO = null;
		ComTesCondDtlVO[] comTesCondDtlVOs = null;
		TesTrfCondVO insTesTrfCondVO = null;
		TesTrfCondDtlVO insTesTrfCondDtlVO = null;
		List<TesTrfCondDtlVO> insTesTrfCondDtlVOLst = null;
		SignOnUserAccount account = event.getSignOnUserAccount();
		int dp_use_idx = 1;
		int sys_use_idx = 1;
		
		try {
			tesTrfCondVO 		= event.getTesTrfCondVO();
			comTesCondDtlVOs 	= event.getComTesCondDtlVOs();
			log.debug("\n\n manageTariffCondDtlInfo -- comTesCondDtlVOs.length : "+(comTesCondDtlVOs!=null?comTesCondDtlVOs.length:0)+" !!!!!!!!!!!!!!!!!! \n\n");
			if (tesTrfCondVO!=null) {
				tesTrfCondVO.setCreUsrId(account.getUsr_id());
				tesTrfCondVO.setUpdUsrId(account.getUsr_id());
				log.debug("\n ### manageTariffCondDtlInfo - tesTrfCondVO : " 
						+ "\n - condNo: " + JSPUtil.getNull(tesTrfCondVO.getCondNo()) 
						+ "\n - condTpCd: " + JSPUtil.getNull(tesTrfCondVO.getTmlAwkCgoCondTpCd())
						+ "\n - desc: " + JSPUtil.getNull(tesTrfCondVO.getCondDesc())
						+ "\n - sysdesc: " + JSPUtil.getNull(tesTrfCondVO.getCondSysDesc())
						+ "\n");
				if (tesTrfCondVO.getCondNo()!=null && !tesTrfCondVO.getCondNo().trim().equals("")) { //UPDATE

					log.debug("\n\n TariffConditionManageBCImpl.manageTariffCondDtlInfo -- UPDATE ================================== \n\n");
					
					/**
					 * TODO: VALIDATE CONDITION -----------------------------------
					 * 1) COND HDR STS -> N(INITIAL)로 변경
					 * 2) COND DTL에 DESC과 SYS DTL을 넣기
					 * 3) SYS DTL을 대상으로 CASE문으로 CONDITION식 유효성 검사
					 * 4-1) 정상: COND HDR STS -> C(CONFIRM)로 변경
					 * 4-2) 이상: COND HDR STS -> X(INVALID)로 변경
					 * 4-3) 오류: COND HDR STS -> E(ERROR)로 변경
					 */
					
					log.debug("\n\n UPDATE COND DATA @@@@@@@@@@@@@ \n\n");
					tesTrfCondVO.setCondCreStsCd(TRF_COND_STS_INITIAL);
					dbDao.updateTrfCondHdr(tesTrfCondVO);// hdr 수정
					insTesTrfCondDtlVOLst = new ArrayList<TesTrfCondDtlVO>();
					log.debug("\n\n comTesCondDtlVOs.length :"+(comTesCondDtlVOs!=null?comTesCondDtlVOs.length:0)+"\n\n");
					for (int i=0; comTesCondDtlVOs!=null && i<comTesCondDtlVOs.length; i++){
						if (comTesCondDtlVOs[i]!=null){
							if (comTesCondDtlVOs[i].getCondDtlUseTpCd()!=null){
								log.debug("\n CondDTL ["+i+"] : "
										+ " - condSeq: " + JSPUtil.getNull(comTesCondDtlVOs[i].getCondSeq())    
										+ " - objDpNm: " + JSPUtil.getNull(comTesCondDtlVOs[i].getObjDpNm())
										+ " - use_tp: " + JSPUtil.getNull(comTesCondDtlVOs[i].getCondDtlUseTpCd())
										+ "\n");
								insTesTrfCondDtlVO = new TesTrfCondDtlVO();
								if (comTesCondDtlVOs[i].getCondDtlUseTpCd().trim().equals(TRF_COND_USE_TP_DISPLAY)){
									insTesTrfCondDtlVO.setCondDtlUseTpCd(TRF_COND_USE_TP_DISPLAY);
									insTesTrfCondDtlVO.setCondSeq(Integer.toString(dp_use_idx++));
								} else if (comTesCondDtlVOs[i].getCondDtlUseTpCd().trim().equals(TRF_COND_USE_TP_SYSTEM)){
									insTesTrfCondDtlVO.setCondDtlUseTpCd(TRF_COND_USE_TP_SYSTEM);
									insTesTrfCondDtlVO.setCondSeq(Integer.toString(sys_use_idx++));
								}
								insTesTrfCondDtlVO.setCondNo(tesTrfCondVO.getCondNo());
								insTesTrfCondDtlVO.setTmlCondDtlTpCd(comTesCondDtlVOs[i].getTmlCondDtlTpCd());
								insTesTrfCondDtlVO.setTmlCondOprCd(comTesCondDtlVOs[i].getTmlCondOprCd());
								insTesTrfCondDtlVO.setObjListNo(comTesCondDtlVOs[i].getObjListNo());
								insTesTrfCondDtlVO.setCondOprValCtnt(comTesCondDtlVOs[i].getCondOprValCtnt());
								insTesTrfCondDtlVO.setUpdUsrId(JSPUtil.getNull(account.getUsr_id()));
								insTesTrfCondDtlVOLst.add(insTesTrfCondDtlVO);
							}
						}
					}
					if (insTesTrfCondDtlVOLst!=null && insTesTrfCondDtlVOLst.size()>0){
						dbDao.deleteTrfCondDtl(tesTrfCondVO);// dtl 삭제
						dbDao.saveTrfCondDtl(insTesTrfCondDtlVOLst);// dtl 넣기
						validateCondition(tesTrfCondVO);
						dbDao.updateTrfCondHdr(tesTrfCondVO);// hdr 수정
					} else {
						tesTrfCondVO.setCondCreStsCd(TRF_COND_STS_ERROR);
						tesTrfCondVO.setErrRmk("Condition Validation ERROR");
						dbDao.updateTrfCondHdr(tesTrfCondVO);// hdr 수정
						log.error("");
						throw new EventException("");						
					}
				} else {  //INSERT
					log.debug("\n\n TariffConditionManageBCImpl.manageTariffCondDtlInfo -- INSERT ================================== \n\n");
					String new_cond_no = dbDao.createCondNo();
					if (new_cond_no!=null && !new_cond_no.trim().equals("")){
						tesTrfCondVO.setCondNo(new_cond_no);
						insTesTrfCondVO = new TesTrfCondVO();
						insTesTrfCondVO.setCondNo(JSPUtil.getNull(new_cond_no));
						insTesTrfCondVO.setCondNm(tesTrfCondVO.getCondNm());
						insTesTrfCondVO.setCondDesc(tesTrfCondVO.getCondDesc());
						insTesTrfCondVO.setCondSysDesc(tesTrfCondVO.getCondSysDesc());
						insTesTrfCondVO.setTmlAwkCgoCondTpCd(tesTrfCondVO.getTmlAwkCgoCondTpCd());
						insTesTrfCondVO.setCondCreTpCd(TRF_COND_CREATE_TP_SCREENINPUT);
						insTesTrfCondVO.setCondCreStsCd(TRF_COND_STS_CONFIRM);
						insTesTrfCondVO.setCondFxFlg("N");
						insTesTrfCondVO.setRowNo("");
						insTesTrfCondVO.setUpdUsrId(JSPUtil.getNull(account.getUsr_id()));
						if (insTesTrfCondVO!=null){
							dbDao.saveTrfCondHdr(insTesTrfCondVO);// hdr 넣기
						}
						
						log.debug("\n\n INSERT COND DATA -- comTesCondDtlVOs.length : "+(comTesCondDtlVOs!=null?comTesCondDtlVOs.length:0)+" !!!!!!!!!!!!!!!!!! \n\n");
						
						insTesTrfCondDtlVOLst = new ArrayList<TesTrfCondDtlVO>();
						for (int i=0; comTesCondDtlVOs!=null && i<comTesCondDtlVOs.length; i++){
							if (comTesCondDtlVOs[i]!=null){
								if (comTesCondDtlVOs[i].getCondDtlUseTpCd()!=null){
									log.debug("\n CondDTL ["+i+"] : "
											+ " - condDtlUseTpCd: " + comTesCondDtlVOs[i].getCondDtlUseTpCd()
											+ " - condSeq: " + comTesCondDtlVOs[i].getCondSeq()    
											+ " - objDpNm: " + comTesCondDtlVOs[i].getObjDpNm()
											+ "\n");
									insTesTrfCondDtlVO = new TesTrfCondDtlVO();
									if (comTesCondDtlVOs[i].getCondDtlUseTpCd().trim().equals(TRF_COND_USE_TP_DISPLAY)){
										insTesTrfCondDtlVO.setCondDtlUseTpCd(TRF_COND_USE_TP_DISPLAY);
										insTesTrfCondDtlVO.setCondSeq(Integer.toString(dp_use_idx++));
									} else if (comTesCondDtlVOs[i].getCondDtlUseTpCd().trim().equals(TRF_COND_USE_TP_SYSTEM)){
										insTesTrfCondDtlVO.setCondDtlUseTpCd(TRF_COND_USE_TP_SYSTEM);
										insTesTrfCondDtlVO.setCondSeq(Integer.toString(sys_use_idx++));
									}
									insTesTrfCondDtlVO.setCondNo(JSPUtil.getNull(new_cond_no));
									insTesTrfCondDtlVO.setTmlCondDtlTpCd(comTesCondDtlVOs[i].getTmlCondDtlTpCd());
									insTesTrfCondDtlVO.setTmlCondOprCd(comTesCondDtlVOs[i].getTmlCondOprCd());
									insTesTrfCondDtlVO.setObjListNo(comTesCondDtlVOs[i].getObjListNo());
									insTesTrfCondDtlVO.setCondOprValCtnt(comTesCondDtlVOs[i].getCondOprValCtnt());
									insTesTrfCondDtlVO.setUpdUsrId(JSPUtil.getNull(account.getUsr_id()));
									insTesTrfCondDtlVOLst.add(insTesTrfCondDtlVO);
								}
							}
						}
						if (insTesTrfCondDtlVOLst!=null && insTesTrfCondDtlVOLst.size()>0){
							dbDao.saveTrfCondDtl(insTesTrfCondDtlVOLst);// dtl 넣기
							validateCondition(insTesTrfCondVO);
							dbDao.updateTrfCondHdr(insTesTrfCondVO);// hdr 수정
						} else {
							insTesTrfCondVO.setCondCreStsCd(TRF_COND_STS_ERROR);
							tesTrfCondVO.setErrRmk("Condition Validation ERROR");
							dbDao.updateTrfCondHdr(insTesTrfCondVO);// hdr 수정
							log.error("");
							throw new EventException("");						
						}						
					} else {
						log.error("");
						throw new EventException("");
					}
				}
			} else {
				log.error("");
				throw new EventException("");
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CONDITION식 유효성 확인
	 * @param tesTrfCondVO
	 */
	public void validateCondition(TesTrfCondVO tesTrfCondVO) {
		String sys_desc_w_defval = null;
		String retval = null;
		
		try {
			sys_desc_w_defval = dbDao.getSysDescWthDefVal(tesTrfCondVO);
			log.debug("\n TariffConditionManageBCImpl.validateCondition - sys_desc_w_defval :"+JSPUtil.getNull(sys_desc_w_defval)+"\n");
			if (sys_desc_w_defval!=null && !sys_desc_w_defval.trim().equals("")){
				retval = dbDao.validateCondition(JSPUtil.getNull(sys_desc_w_defval));
				if (retval!=null && (retval.trim().equals("Y") || retval.trim().equals("N"))){
					tesTrfCondVO.setCondCreStsCd(TRF_COND_STS_CONFIRM);
				} else {
					tesTrfCondVO.setCondCreStsCd(TRF_COND_STS_INVALID);
					tesTrfCondVO.setErrRmk("INVALID CONDITION");
				}
			} else {
				tesTrfCondVO.setCondCreStsCd(TRF_COND_STS_ERROR);
				tesTrfCondVO.setErrRmk("Condition Validation ERROR");
			}
		} catch(DAOException ex) {
			log.error("err " + ex.getMessage(), ex);
			tesTrfCondVO.setCondCreStsCd(TRF_COND_STS_INVALID);
			tesTrfCondVO.setErrRmk(ex.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			tesTrfCondVO.setCondCreStsCd(TRF_COND_STS_ERROR);
			tesTrfCondVO.setErrRmk(ex.getMessage());
		}
	}	
}