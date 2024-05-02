/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VendorCmBCImpl.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.event.EsdTrs0972Event;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.event.EsdTrs0973Event;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration.VendorCmDBDAO;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.SearchJoEdiRcvMsgListVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * VendorCmBCImpl<br>
 * 
 * @author
 * @see
 * @since J2EE 1.6
 */
public class VendorCmBCImpl implements VendorCmBC {
	private transient VendorCmDBDAO dbDao = null;

	public VendorCmBCImpl() {
		dbDao = new VendorCmDBDAO();
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchJoEdiHistory(Event e) throws EventException {
		EsdTrs0973Event event = (EsdTrs0973Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRs(dbDao.searchJoEdiHistory(event.getParamVo()));
			return eventResponse;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchJoEdiRcvMsgList(Event e) throws EventException {
		EsdTrs0972Event event = (EsdTrs0972Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setRs(dbDao.searchJoEdiRcvMsgList(event.getParamVo()));
			return eventResponse;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList multipleAccept(Event e) throws EventException {
		EsdTrs0972Event event = (EsdTrs0972Event) e;
		WorkOrderPreviewBC workOrderPreviewBC = new WorkOrderPreviewBCImpl();
		SignOnUserAccount account = event.getSignOnUserAccount();
		ArrayList joEdiFF = new ArrayList();
		try {
			SearchJoEdiRcvMsgListVO[] searchJoEdiRcvMsgListVOs = event.getSearchJoEdiRcvMsgListVOs();
			SearchJoEdiRcvMsgListVO beforeVo = null;
			SearchJoEdiRcvMsgListVO vo = null;
			List<HashMap<String, Object>> updList = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> hm;
			// Surcharge update
			for (int i = 0; i < searchJoEdiRcvMsgListVOs.length; i++) {
				vo = searchJoEdiRcvMsgListVOs[i];
				if ("1".equals(vo.getIbcheck())) {
					if (beforeVo != null) {
						if (vo.getTrspSoOfcCtyCd().equals(beforeVo.getTrspSoOfcCtyCd()) && vo.getTrspSoSeq().equals(beforeVo.getTrspSoSeq()) && vo.getMaxRcvMsgSeq().equals(beforeVo.getMaxRcvMsgSeq())) {
							continue;
						}
					}
					hm = new HashMap<String, Object>();
					hm.put("trsp_so_ofc_cty_cd", vo.getTrspSoOfcCtyCd());
					hm.put("trsp_so_seq", vo.getTrspSoSeq());
					hm.put("trsp_wo_ofc_cty_cd", vo.getTrspWoOfcCtyCd());
					hm.put("trsp_wo_seq", vo.getTrspWoSeq());
					hm.put("rcv_msg_seq", vo.getMaxRcvMsgSeq());
					hm.put("upd_usr_id", account.getUsr_id());
					hm.put("trs_sub_sts_cd", "AC");
					hm.put("rcv_msg_sts_cd", "A");
					hm.put("rcv_msg_tp_cd", vo.getRcvMsgTpCd());
					hm.put("jo_item_ref", vo.getWoNo() + "-" + vo.getSoNo());
					hm.put("wono", vo.getWoNo());
					if ("P".equals(vo.getRcvMsgTpCd())) {
						dbDao.modifyTrsTrspScgDtl(hm);
					}
					updList.add(hm);
					beforeVo = (SearchJoEdiRcvMsgListVO) vo.clone();
					hm = null;
				}
			}
			// Update [TRS_TRSP_SVC_ORD ==> Amount And TRS_SUB_STS_CD]
			Set<String> hashSet = new HashSet<String>();
			for (HashMap<String, Object> param : updList) {
				if ("J".equals(param.get("rcv_msg_tp_cd"))) {
					workOrderPreviewBC.workOrderCancelByVendorCM(param, account);
					hashSet.add(String.valueOf(param.get("trsp_wo_ofc_cty_cd")) + String.valueOf(param.get("trsp_wo_seq")));
					dbDao.modifyRcvMsgStsCd(param);
					joEdiFF.add(sendEdi(param, "N"));
				} else {
					if ("P".equals(param.get("rcv_msg_tp_cd"))) {
						dbDao.modifyTrsSoAmtAndSubTpyeCode(param);
					} else {
						dbDao.modifyTrsTrspSvcOrd(param);
					}
					dbDao.modifyRcvMsgStsCd(param);
					joEdiFF.add(sendEdi(param, "A"));
				}
			}
			HashMap<String, Object> paramTrsTrspWrkOrd = null;
			for (String s : hashSet) {
				paramTrsTrspWrkOrd = new HashMap<String, Object>();
				paramTrsTrspWrkOrd.put("trsp_wo_ofc_cty_cd", s.substring(0, 3));
				paramTrsTrspWrkOrd.put("trsp_wo_seq", s.substring(3));
				paramTrsTrspWrkOrd.put("upd_usr_id", account.getUsr_id());
				workOrderPreviewBC.manageTrsTrspWrkOrdByVendorCM(paramTrsTrspWrkOrd);
			}
			return joEdiFF;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList multipleReject(Event e) throws EventException {
		EsdTrs0972Event event = (EsdTrs0972Event) e;
		SignOnUserAccount account = event.getSignOnUserAccount();
		ArrayList joEdiFF = new ArrayList();
		try {
			SearchJoEdiRcvMsgListVO[] searchJoEdiRcvMsgListVOs = event.getSearchJoEdiRcvMsgListVOs();
			SearchJoEdiRcvMsgListVO beforeVo = null;
			SearchJoEdiRcvMsgListVO vo = null;
			List<HashMap<String, Object>> updList = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> hm;
			for (int i = 0; i < searchJoEdiRcvMsgListVOs.length; i++) {
				vo = searchJoEdiRcvMsgListVOs[i];
				if ("1".equals(vo.getIbcheck())) {
					if (beforeVo != null) {
						if (vo.getTrspSoOfcCtyCd().equals(beforeVo.getTrspSoOfcCtyCd()) && vo.getTrspSoSeq().equals(beforeVo.getTrspSoSeq()) && vo.getMaxRcvMsgSeq().equals(beforeVo.getMaxRcvMsgSeq())) {
							continue;
						}
					}
					hm = new HashMap<String, Object>();
					hm.put("trsp_so_ofc_cty_cd", vo.getTrspSoOfcCtyCd());
					hm.put("trsp_so_seq", vo.getTrspSoSeq());
					hm.put("rcv_msg_seq", vo.getMaxRcvMsgSeq());
					hm.put("upd_usr_id", account.getUsr_id());
					hm.put("trs_sub_sts_cd", "OR");
					hm.put("rcv_msg_sts_cd", "R");
					hm.put("rcv_msg_tp_cd", vo.getRcvMsgTpCd());
					hm.put("jo_item_ref", vo.getWoNo() + "-" + vo.getSoNo());
					hm.put("wono", vo.getWoNo());
					updList.add(hm);
					beforeVo = (SearchJoEdiRcvMsgListVO) vo.clone();
					hm = null;
				}
			}

			// Update [TRS_TRSP_SVC_ORD ==> Amount And TRS_SUB_STS_CD]
			for (HashMap<String, Object> param : updList) {
				if ("P".equals(param.get("rcv_msg_tp_cd"))) {
					dbDao.modifyTrsTrspSvcOrd(param);
				}
				dbDao.modifyRcvMsgStsCd(param);
				joEdiFF.add(sendEdi(param, "J"));
			}
			return joEdiFF;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param hm
	 * @param ediWoIssStsCd
	 * @return
	 * @throws EventException
	 */
	private String[] sendEdi(HashMap<String, Object> hm, String ediWoIssStsCd) throws EventException {
		WorkOrderPreviewBC workOrderPreviewBC = new WorkOrderPreviewBCImpl();
		WorkOrderPreviewVO woVO = new WorkOrderPreviewVO();
		woVO.setWoEdiUseFlg("EDI");
		woVO.setEdiWoIssStsCd(ediWoIssStsCd);
		woVO.setEdiTrspSoOfcCtyCd((String) hm.get("trsp_so_ofc_cty_cd"));
		woVO.setEdiTrspSoSeq((String) hm.get("trsp_so_seq"));
		woVO.setJoItemRef((String) hm.get("jo_item_ref"));
		String woNo = (String) hm.get("wono");
		woVO.setEdiTrspWoOfcCtyCd(woNo.substring(0, 3));
		woVO.setEdiTrspWoSeq(woNo.substring(3));
		return workOrderPreviewBC.makeFlatFileEdiUsOutBound(woVO);
	}
}
