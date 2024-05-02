/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : MonthlyTargetVVDBCImpl.java
 *@FileTitle      : Target VVD/Supply Inquiry
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    : 
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.integration.MonthlyTargetVVDDBDAO;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.vo.MonthlyTargetVVDInquiryVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.vo.MonthlyTargetVVDManagementVO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonTgtVvdVO;

/**
 * BasicDataManage Business Logic Basic Command implementation<br>
 * handling business transaction<br>
 * 
 * @author
 * @see ESM_SAQ_0154EventResponse,MonthlyTargetVVDBC
 * @since J2EE 1.6
 */
public class MonthlyTargetVVDBCImpl extends BasicCommandSupport implements MonthlyTargetVVDBC {

	// Database Access Object
	private transient MonthlyTargetVVDDBDAO dbDao = null;

	/**
	 * MonthlyTargetVVDBCImpl objects creation<br>
	 * MonthlyTargetVVDDBDAO objects creation<br>
	 */
	public MonthlyTargetVVDBCImpl() {
		dbDao = new MonthlyTargetVVDDBDAO();
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVDInquiry0154List01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		try {
			List<MonthlyTargetVVDInquiryVO> resultVO = dbDao.searchMonthlyTargetVVDInquiry0154List01(conditionVO);
			listVO.addList(resultVO);
			listVO.addList(conditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVD0040Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		try {
			List<MonthlyTargetVVDManagementVO> resultVO = dbDao.searchMonthlyTargetVVD0040Tab01(conditionVO);
			List<MonthlyTargetVVDManagementVO> resultVO2 = dbDao.searchMonthlyTargetVVDOrg0040Tab01(conditionVO);
			
			String resultYN = dbDao.searchMonthlyTargetVVD0040Tab01SaveChk(conditionVO);
			
			listVO.addList(conditionVO);
			listVO.addList(resultVO);
			listVO.addList(resultVO2);
			
			listVO.setResultYN(resultYN);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVDGroup0040Tab02(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		try {
			List<MonthlyTargetVVDManagementVO> resultVO = dbDao.searchMonthlyTargetVVDGroup0040Tab02(conditionVO);
			listVO.addList(conditionVO);
			listVO.addList(resultVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * 
	 * @param SaqMonTgtVvdVO[] saqMonTgtVvdVOs
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO multiMonthlyTargetVVD0040(SaqMonTgtVvdVO[] saqMonTgtVvdVOs, SignOnUserAccount account) throws EventException {
		ReturnVO listVO = new ReturnVO();
		try {

			List<SaqMonTgtVvdVO> insertVoList = new ArrayList<SaqMonTgtVvdVO>();
			List<SaqMonTgtVvdVO> updateVoList = new ArrayList<SaqMonTgtVvdVO>();
			List<SaqMonTgtVvdVO> deleteVoList = new ArrayList<SaqMonTgtVvdVO>();
			for (int i = 0; i < saqMonTgtVvdVOs.length; i++) {
				if (saqMonTgtVvdVOs[i].getIbflag().equals("I")) {
					saqMonTgtVvdVOs[i].setCreUsrId(account.getUsr_id());
					saqMonTgtVvdVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(saqMonTgtVvdVOs[i]);
				}
				if (saqMonTgtVvdVOs[i].getIbflag().equals("U")) {
					saqMonTgtVvdVOs[i].setCreUsrId(account.getUsr_id());
					saqMonTgtVvdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqMonTgtVvdVOs[i]);
				}
				if (saqMonTgtVvdVOs[i].getIbflag().equals("D")) {
					saqMonTgtVvdVOs[i].setCreUsrId(account.getUsr_id());
					saqMonTgtVvdVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(saqMonTgtVvdVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.multiMonthlyTargetVVDDelete0040(deleteVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.multiMonthlyTargetVVDUpdate0040(updateVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.multiMonthlyTargetVVDInsert0040(insertVoList);
			}

			// listVO.addList(quotaCondition);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO processSKDCopy0040(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		log.debug("processSKDCopy0040 Start!!!");
		ReturnVO listVO = new ReturnVO();
		try {
			List<MonthlyTargetVVDManagementVO> stsCDVO = dbDao.searchTgtVVDStsCdCopy0040(conditionVO);
			String tgt_vvd_sts_cd = ""; //소스 품질 수정 요청건 null --> ""
			String sts_text = ""; //소스 품질 수정 요청건 null --> ""
			for (int i = 0; i < stsCDVO.size(); i++) {
				Map<String, String> colValues = stsCDVO.get(i).getColumnValues();
				tgt_vvd_sts_cd = JSPUtil.getNull(colValues.get("tgt_vvd_sts_cd"));
				sts_text = JSPUtil.getNull(colValues.get("sts_text"));
			}
			// only Confirm == C
			if (stsCDVO == null || !tgt_vvd_sts_cd.equals("C")) {
				String msgParam[] = { "SKD Copy", dbDao.searchComIntgCdDtl0040("C"), sts_text };
				throw new EventException((new ErrorHandler("SAQ00012", msgParam)).getMessage());

			}
			DBRowSet dRs = dbDao.searchTgtVVDStsCdCancel0040(conditionVO);
			if (dRs.next()) {
				StringBuffer msg = new StringBuffer();
				do {
					String trd_cd = dRs.getString("trd_cd");
					String dir_cd = dRs.getString("dir_cd");
					String sts = dRs.getString("sts_text");
					msg.append(trd_cd).append("/").append(dir_cd).append("/").append(sts);
				} while (dRs.next());
				throw new EventException((new ErrorHandler("SAQ00099", new String[]{msg.toString()}).getMessage()));
			}

			dbDao.modifySaqMonTgtVvd0040(conditionVO, "N");
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO processConfirm0040(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		log.debug("processConfirm0040 Start!!!");
		ReturnVO listVO = new ReturnVO();
		String stsCd[] = null;
		try {
			List<MonthlyTargetVVDManagementVO> stsCDVO = dbDao.searchTgtVVDStsCdCopy0040(conditionVO);
//          Unused Local Variable (2013-03-12)			
//			String tgt_vvd_sts_cd = null;
//			String sts_text = null;
			for (int i = 0; i < stsCDVO.size(); i++) {
				stsCd = new String[2];
				Map<String, String> colValues = stsCDVO.get(i).getColumnValues();
//				tgt_vvd_sts_cd = JSPUtil.getNull(colValues.get("tgt_vvd_sts_cd"));
//				sts_text = JSPUtil.getNull(colValues.get("sts_text"));
				stsCd[0] = JSPUtil.getNull(colValues.get("tgt_vvd_sts_cd"));
				stsCd[1] = JSPUtil.getNull(colValues.get("sts_text"));
			}

			// String stsCd[] = dbDao.searchTgtVVDStsCd_01(event.getYear(),event.getQuarter(), event.getTrade(), event.getBound());
			// if( stsCd == null || !stsCd[0].equals("0")){
			// String msgParam[] = {"Confirmation",dbDao.searchComIntgCdDtl("0"),stsCd[1]};
			// throw new EventException( (new ErrorHandler("SAQ00012",msgParam)).getMessage() );
			//
			// }
			//
			// dbDao.modifySAQ_MON_TGT_VVD_01(event.getYear(),event.getQuarter(), event.getTrade(),
			// event.getBound(),"C");
			// HashMap h = new HashMap();
			// h.put("tgt_vvd_sts_cd","C");
			// response = new ESM_SAQ_040EventResponse(new DBRowSet() ,h, "SUCCESS");

			if (stsCDVO == null || !stsCd[0].equals("0")) {
				String msgParam[] = { "Confirmation", dbDao.searchComIntgCdDtl0040("0"), stsCd[1] };
				throw new EventException((new ErrorHandler("SAQ00012", msgParam)).getMessage());

			}
			dbDao.processConfirm0040(conditionVO, "C");
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * ESM_SAQ_0040 : [Cancel Confirmation]<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO processCancelConfirm0040(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		log.debug("processCancelConfirm0040 Start!!!");
		ReturnVO listVO = new ReturnVO();
		String stsCd[] = null;
		try {
			List<MonthlyTargetVVDManagementVO> stsCDVO = dbDao.searchTgtVVDStsCdCopy0040(conditionVO);
//			Unused Local Variable
//			String tgt_vvd_sts_cd = null;
//			String sts_text = null;
			// for(int i=0; i<stsCDVO.size(); i++){
			// Map<String, String> colValues = stsCDVO.get(i).getColumnValues();
			// tgt_vvd_sts_cd = JSPUtil.getNull(colValues.get("tgt_vvd_sts_cd"));
			// sts_text = JSPUtil.getNull(colValues.get("sts_text"));
			// }
			for (int i = 0; i < stsCDVO.size(); i++) {
				stsCd = new String[2];
				Map<String, String> colValues = stsCDVO.get(i).getColumnValues();
//				tgt_vvd_sts_cd = JSPUtil.getNull(colValues.get("tgt_vvd_sts_cd"));
//				sts_text = JSPUtil.getNull(colValues.get("sts_text"));
				stsCd[0] = JSPUtil.getNull(colValues.get("tgt_vvd_sts_cd"));
				stsCd[1] = JSPUtil.getNull(colValues.get("sts_text"));
			}

			if (stsCDVO == null || !stsCd[0].equals("C")) {
				String msgParam[] = { "Cancel Confirmation", dbDao.searchComIntgCdDtl0040("C"), stsCd[1] };
				throw new EventException((new ErrorHandler("SAQ00012", msgParam)).getMessage());

			}
			dbDao.processConfirm0040(conditionVO, "0");
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return listVO;
	}

	/**
	 * SKD Copy - message creation<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public HashMap searchSKDCopyMessage0040(QuotaConditionVO conditionVO) throws EventException {
		HashMap h = new HashMap();
		try {
			DBRowSet dRs = dbDao.searchSKDCopyMessage0040(conditionVO);
			StringBuffer msg = new StringBuffer();
			String cfm_chk = "true";
			while (dRs.next()) {
				String trd_cd = dRs.getString("trd_cd");
				String dir_cd = dRs.getString("dir_cd");
				String sts_text = dRs.getString("sts_text");
				msg.append("- ").append(trd_cd).append("/").append(dir_cd).append("/").append(sts_text).append("\r\n");
				if (dRs.getString("cfm_flg").equals("1")) {
					cfm_chk = "false";
				}
			}
			String m = ((new ErrorHandler("SAQ00099", new String[] { msg.toString() })).getUserMessage());
			h.put("message", m);
			h.put("cfm_flg", cfm_chk);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return h;
	}
}