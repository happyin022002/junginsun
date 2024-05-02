/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderBCImpl.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate :
*@LastModifier   :
*@LastVersion    :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderEAIDAO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgOutstandingVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBlStatusVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoAsignVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPrnRmkVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DubaiCstmsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoCntrRqstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuCstmsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoNtcSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRcvrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiYdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseYdInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.GenDoBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaCstmsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCntrRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseInfoForCopyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseReportVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapCstmsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoIssueVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorStatusVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorCstmsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBlStatusVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCgoRlseVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgDoCntrVO;
import com.clt.syscommon.common.table.BkgDoDtlVO;
import com.clt.syscommon.common.table.BkgDoFomVO;
import com.clt.syscommon.common.table.BkgDoHisVO;
import com.clt.syscommon.common.table.BkgDoRefVO;
import com.clt.syscommon.common.table.BkgDoVO;
import com.clt.syscommon.common.table.BkgEdoCntrVO;
import com.clt.syscommon.common.table.BkgEdoDoVO;
import com.clt.syscommon.common.table.BkgEdoIbdTrspVO;
import com.clt.syscommon.common.table.BkgEdoLogVO;
import com.clt.syscommon.common.table.BkgEdoMstVO;
import com.clt.syscommon.common.table.BkgEdoPtyTrspVO;
import com.clt.syscommon.common.table.BkgEdoSelfTrspVO;
import com.clt.syscommon.common.table.BkgEuPinNoVO;
import com.clt.syscommon.common.table.BkgFullCgoRlseOrdVO;
import com.clt.syscommon.common.table.BkgFullCntrRemarkVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgIbEdiSndLogVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.ComUserVO;


/**
 * CargoReleaseOrderMgt Business Logic Basic Command implementation<br>
 * CargoReleaseOrderMgt handling business transaction.<br>
 *
 * @author
 * @see ESM_BKG_1001EventResponse,FullReleaseOrderBC refer to each DAO class
 * @since J2EE 1.4
 */
public class CargoReleaseOrderBCImpl extends BasicCommandSupport implements CargoReleaseOrderBC {

	// Database Access Object
	transient CargoReleaseOrderDBDAO dbDao = null;

	// Database Access Object
	transient CargoReleaseOrderEAIDAO eaiDbDao = null;

	/**
	 * Generating FullReleaseOrderBCImpl Object<br>
	 * Generating FullReleaseOrderDBDAO<br>
	 */
	public CargoReleaseOrderBCImpl() {
		dbDao    = new CargoReleaseOrderDBDAO();
		eaiDbDao = new CargoReleaseOrderEAIDAO();
	}

	/**
	 * BackEndJob공통 - Back End Job Status 조회
	 *(동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용) <br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {

		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return(String) rowSet.getObject("jb_sts_flg");
		} catch(BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(InterruptedException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of FullReleaseOrder<br>
	 *
	 * @param String usrNm
	 * @param String usrRegNo
	 * @return response EventResponse
	 * @exception EventException
	 */
	public List<KorDoAttorneyVO> searchKorDoCustList(String usrNm, String usrRegNo) throws EventException {
		try {
			return dbDao.searchKorDoCustList(usrNm, usrRegNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Cargo Release Order<br>
	 *
	 * @param String bkgNo
	 * @return response EventResponse
	 * @exception EventException
	 */
	public List<DoHisVO> searchDoHistory(String bkgNo) throws EventException {
		try {
			return dbDao.searchDoHistory(bkgNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling manage event of Cargo Release Order<br>
	 *
	 * @param KorDoAttorneyVO[] attorneys
	 * @param SignOnUserAccount account
	 * @return response EventResponse
	 * @exception EventException
	 */
	public int manageKorDoCust(KorDoAttorneyVO[] attorneys, SignOnUserAccount account) throws EventException {
		int rtnVal = 0;
		try {
			List<KorDoAttorneyVO> insertVoList = new ArrayList<KorDoAttorneyVO>();
			List<KorDoAttorneyVO> updateVoList = new ArrayList<KorDoAttorneyVO>();
			List<KorDoAttorneyVO> deleteVoList = new ArrayList<KorDoAttorneyVO>();

			if(null != attorneys){
				for ( int i=0; i<attorneys .length; i++ ) {
					if ( attorneys[i].getIbflag().equals("I")){
						attorneys[i].setRgstUsrId(account.getUsr_id());
						attorneys[i].setCreUsrId(account.getUsr_id());
						attorneys[i].setUpdUsrId(account.getUsr_id());
						attorneys[i].setRgstOfcCd(account.getOfc_cd());
						attorneys[i].setUpdOfcCd(account.getOfc_cd());
						insertVoList.add(attorneys[i]);
					} else if ( attorneys[i].getIbflag().equals("U")){
						attorneys[i].setUpdUsrId(account.getUsr_id());
						attorneys[i].setUpdOfcCd(account.getOfc_cd());
						updateVoList.add(attorneys[i]);
					} else if ( attorneys[i].getIbflag().equals("D")){
						deleteVoList.add(attorneys[i]);
					}
				}
			}
			if ( insertVoList.size() > 0 ) {
				rtnVal = dbDao.addKorDoCust(insertVoList);
				if(rtnVal ==1){
					throw new EventException(new ErrorHandler("BKG43045").getMessage());
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyKorDoCust(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeKorDoCust(deleteVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 *  Handling retrieving event of Cargo Release<br>
	 *
	 * @param String custType
	 * @param String custNm
	 * @param String custBizNo
	 * @return KorDoAttorneyDtlVO
	 * @exception EventException
	 */
	public List<KorDoAttorneyDtlVO> searchKorDoAttorneyList(String custType, String custNm, String custBizNo) throws EventException {
		try {
			return dbDao.searchKorDoAttorneyList(custType, custNm, custBizNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling manage event of Attorney Register Pop-up<br>
	 *
	 * @param KorDoAttorneyDtlVO[] attorneyDtls
	 * @param SignOnUserAccount account
	 * @return int ;
	 * @exception EventException
	 */
	public int manageKorDoAttorney(KorDoAttorneyDtlVO[] attorneyDtls, SignOnUserAccount account) throws EventException {
		int rtnVal = 0;
		try {
			List<KorDoAttorneyDtlVO> insertVoList = new ArrayList<KorDoAttorneyDtlVO>();
			List<KorDoAttorneyDtlVO> updateVoList = new ArrayList<KorDoAttorneyDtlVO>();
			List<KorDoAttorneyDtlVO> deleteVoList = new ArrayList<KorDoAttorneyDtlVO>();

			if(null != attorneyDtls){
				for ( int i=0; i<attorneyDtls .length; i++ ) {
					if ( attorneyDtls[i].getIbflag().equals("I")){
						attorneyDtls[i].setRgstUsrId(account.getUsr_id());
						attorneyDtls[i].setCreUsrId(account.getUsr_id());
						attorneyDtls[i].setUpdUsrId(account.getUsr_id());
						attorneyDtls[i].setRgstOfcCd(account.getOfc_cd());
						attorneyDtls[i].setUpdOfcCd(account.getOfc_cd());
						insertVoList.add(attorneyDtls[i]);
					} else if ( attorneyDtls[i].getIbflag().equals("U")){
						attorneyDtls[i].setUpdUsrId(account.getUsr_id());
						attorneyDtls[i].setUpdOfcCd(account.getOfc_cd());
						updateVoList.add(attorneyDtls[i]);
					} else if ( attorneyDtls[i].getIbflag().equals("D")){
						deleteVoList.add(attorneyDtls[i]);
					}
				}
			}

			if ( insertVoList.size() > 0 ) {
				rtnVal = dbDao.addKorDoAttorney(insertVoList);
				if(rtnVal ==1){
					throw new EventException(new ErrorHandler("BKG00764").getMessage());
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyKorDoAttorney(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeKorDoAttorney(deleteVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return rtnVal;
	}

	/**
	 *  Handling retrieving event of Attorney Create Pop-up<br>
	 *
	 * @param String fmAttyBizNo
	 * @param String toAttyBizNo
	 * @return EventResponse EsmBkg0999EventResponse
	 * @exception EventException
	 */
	public String searchKorDoAttorneyDtl(String fmAttyBizNo, String toAttyBizNo) throws EventException {
		try {
			return dbDao.searchKorDoAttorneyDtl(fmAttyBizNo, toAttyBizNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Korea D/O.<br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return KorDoMstVO korDoMst
	 * @exception EventException
	 */
	public KorDoMstVO searchKorDo(String bkgNo, SignOnUserAccount account) throws EventException {

		KorDoMstVO korDoMst = new KorDoMstVO();
		KorDoBlInfoVO korDoBlInfo = new KorDoBlInfoVO();


		try {

			validateBkgSts(bkgNo);

			DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
			//korDoMst.setBlInfo(blInfo);

			if(blInfo != null){
				ObjectCloner.build(blInfo, korDoBlInfo);
			}

			if(blInfo != null){
				if(!blInfo.getDelCd().substring(0,2).equals("KR")) {  // 12
					String[] msg = new String[]{blInfo.getPodCd()};
					throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
					//You can't handle this B/L Because the Port of Discharging is [$s]
				}

				BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo);

				if(doRef != null){
					ObjectCloner.build(doRef, korDoBlInfo);
				}

				KorCstmsVO korCstms = dbDao.searchKorCstmsInfo(bkgNo);
				//korDoMst.setKorCstms(korCstms);
				if(korCstms != null){
					ObjectCloner.build(korCstms, korDoBlInfo);
				}

				List<DoRlseStsVO> doRlseSts = dbDao.searchDoRlseSts(bkgNo);
				korDoMst.setDoRlseSts(doRlseSts);

				BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
				//korDoMst.setBlIss(blIss);

				if(blIss != null){
					ObjectCloner.build(blIss, korDoBlInfo);
				}

				EdoRqstStsVO edoRqstSts = dbDao.searchEdoRqstSts(bkgNo);

				if(edoRqstSts != null){
					ObjectCloner.build(edoRqstSts, korDoBlInfo);
				}

				String attorneyValChk = "Y";

				if(edoRqstSts != null ){
					if(edoRqstSts.getPrPtyRgstNo() != null) {
						if(!edoRqstSts.getPrPtyRgstNo().equals( edoRqstSts.getMsPtyRgstNo())){
							attorneyValChk = dbDao.searchKorDoAttorneyValChk(edoRqstSts.getMsPtyRgstNo(), edoRqstSts.getPrPtyRgstNo());
						}
					}
			   }

				korDoBlInfo.setAttorneyValChk(attorneyValChk);

				OtsRcvInfoVO otsRcvInfo = new OtsRcvInfoVO();

				otsRcvInfo = this.searchErpOtsInfo(blInfo.getBlNo());

				if(otsRcvInfo != null){
					ObjectCloner.build(otsRcvInfo, korDoBlInfo);
				}

				korDoMst.setKorDoBlInfo(korDoBlInfo);

				String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());

				korDoMst.setMrdId(mrdId);
			}
			return korDoMst;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Check Booking Status
	 * @param String bkgNo
	 * @exception EventException
	 */
	private void validateBkgSts(String bkgNo) throws EventException {
		try {
			String bkgStsCd = dbDao.searchBkgStatus(bkgNo);

			if("X".equals(bkgStsCd)){
				throw new EventException(new ErrorHandler("BKG00879").getMessage());
				//This booking already canceled, You can not update booking data
				//This booking already canceled or Advanced
				//Booking in waiting status
			}else if("".equals(bkgStsCd)){
				throw new EventException(new ErrorHandler("BKG40033", new String[]{bkgNo}).getMessage());

				//Booking No.(Value) doesn't exist
			}else {
				bkgStsCd = dbDao.searchBkgCgoTp(bkgNo);

				if (bkgStsCd.equals("P")) {
					throw new EventException(new ErrorHandler("BKG40030").getMessage());
				}
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * save D/O info
	 *
	 * @param KorDoSaveVO korDoSave
	 * @exception EventException
	 */
	public void manageKorDo(KorDoSaveVO korDoSave) throws EventException {
		try {
			int resultCnt =0;

			BkgDoHisVO doHis = new BkgDoHisVO();

			/**
			 * do_cng_evnt_cd
			 * RB : Received O. B/L
			 * RO : Received Other Doc
			 * RI : Received In bond Doc
			 * CR : Cancelled O/BL Received

			 * do_cng_evnt_cd = RB
			 * pre_ctnt  : old_obl_rdem_knt
			 * crnt_ctnt : new_obl_rdem_knt

			 * do_cng_evnt_cd = RO
			 * pre_ctnt  : 'N'
			 * crnt_ctnt : 'Y'

			 * do_cng_evnt_cd = RI
			 * pre_ctnt  : 'N'
			 * crnt_ctnt : 'Y'

			 * do_cng_evnt_cd = CR
			 * pre_ctnt  : 'N'
			 * crnt_ctnt : 'Y'
			 */

			String preCtnt  = "N";
			String crntCtnt = "Y";

			if("CR".equals(korDoSave.getDoCngEvntCd())){
				preCtnt  = "Y";
				crntCtnt = "N";
			}

			if("Y".equals(korDoSave.getOblCngFlg())){

				doHis.setBkgNo(korDoSave.getBkgNo());
				doHis.setCreUsrId(korDoSave.getAcount().getUsr_id());
				doHis.setUpdUsrId(korDoSave.getAcount().getUsr_id());
				doHis.setDoCngEvntCd(korDoSave.getDoCngEvntCd());
				doHis.setPreCtnt(preCtnt);
				doHis.setCrntCtnt(crntCtnt);
				doHis.setEvntUsrId(korDoSave.getAcount().getUsr_id());
				doHis.setEvntOfcCd(korDoSave.getAcount().getOfc_cd());

				dbDao.addDoHistory(doHis);
			}

			BkgDoRefVO refInfos = new BkgDoRefVO();

			refInfos.setBkgNo(korDoSave.getBkgNo());
			refInfos.setCstmsRefNm(korDoSave.getCstmsRefNm());
			refInfos.setCstmsRefCtnt(korDoSave.getCstmsRefCtnt());
			refInfos.setCstmsAsgnNm(korDoSave.getCstmsAsgnNm());
			refInfos.setCstmsAsgnCtnt(korDoSave.getCstmsAsgnCtnt());
			refInfos.setInterRmk(korDoSave.getInterRmk());
			refInfos.setDoHldFlg(korDoSave.getDoHldFlg());
			refInfos.setCreUsrId(korDoSave.getAcount().getUsr_id());
			refInfos.setUpdUsrId(korDoSave.getAcount().getUsr_id());
			refInfos.setInfoCgoFlg(korDoSave.getInfoCgoFlg());
			refInfos.setDoSplitFlg(korDoSave.getDoSplitFlg());
			refInfos.setCyOpCd(korDoSave.getCyOpCd());

			resultCnt = dbDao.modifyDoRef(refInfos);

			if ( resultCnt == 0 ) {
				dbDao.addDoRef(refInfos);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * D/O No Assign.<br>
	 * @param DoAsignVO doAsign
	 * @return String doNo
	 * @exception EventException
	 */
	public String assignDo(DoAsignVO doAsign) throws EventException {
		try {
			//DO Assign availability
			validateDoAssign(doAsign.getBkgNo());

			//get DO No
			String doNo = this.makeDoNo(doAsign.getAcount().getOfc_cd(), doAsign.getAcount().getUsr_id());
			String doSplitNo = "00";

			//Value Object
			BkgDoVO bkgDo       = new BkgDoVO();
			BkgDoRefVO bkgDoRef = new BkgDoRefVO();
			BkgDoDtlVO doDtl    = new BkgDoDtlVO();
			BkgDoHisVO doHis    = new BkgDoHisVO();

			bkgDo.setBkgNo(doAsign.getBkgNo());
			bkgDo.setDoNo(doNo);
			bkgDo.setRlseSeq("1");
			bkgDo.setDoNoSplit(doSplitNo);
			bkgDo.setCreUsrId(doAsign.getAcount().getUsr_id());
			bkgDo.setUpdUsrId(doAsign.getAcount().getUsr_id());


			/*****************************************
				DO RELEASE STATUS CODE
			******************************************
			AS  Assigned
			CR  Cancelled O/BL Received
			DC  DOR Cancel
			DF  DOR I/F
			DT  DOR Transmit
			HC  Cancelled Cargo Hold
			PD  Printed D/O
			RB  Received O. B/L
			RE  Released
			RI  Received In bond Doc
			RO  Received Other Doc
			RR  Remark for Release
			SF  Sent Fax/E-Mail
			XX  Canceled

			/*****************************************
				RELEASE STATUS CODE
			******************************************
			A ASSIGN
			R RELEASE
			D DOR I/F
			I ASSIGN & ISSUE
			C CANCEL
			******************************************/

			doDtl.setBkgNo(doAsign.getBkgNo());
			doDtl.setRlseSeq("1");
			doDtl.setRlseStsCd("A"); //ASSIGN
			doDtl.setEvntUsrId(doAsign.getAcount().getUsr_id());
			doDtl.setEvntOfcCd(doAsign.getAcount().getOfc_cd());
			doDtl.setCreUsrId(doAsign.getAcount().getUsr_id());
			doDtl.setUpdUsrId(doAsign.getAcount().getUsr_id());

			doHis.setBkgNo(doAsign.getBkgNo());
			doHis.setCreUsrId(doAsign.getAcount().getUsr_id());
			doHis.setUpdUsrId(doAsign.getAcount().getUsr_id());
			doHis.setDoCngEvntCd("AS"); //AI  ASSIGN & ISSUE

			doHis.setPreCtnt("");
			doHis.setCrntCtnt(doNo + doSplitNo);

			doHis.setEvntUsrId(doAsign.getAcount().getUsr_id());
			doHis.setEvntOfcCd(doAsign.getAcount().getOfc_cd());

			manageDo(bkgDo, bkgDoRef, doDtl, doHis);

			dbDao.modifyKorDoRcvrBizNo(doAsign.getBkgNo());

			return doNo;
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * DO Assign availability<br>
	 * @param bkgNo
	 * @exception EventException
	 */
	private void validateDoAssign(String bkgNo)throws EventException {
		try {
			if(dbDao.checkHold(bkgNo)){
				throw new EventException(new ErrorHandler("BKG00649").getMessage());
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * D/O Cancel <br>
	 *
	 * @param KorDoCancelVO korDoCancel
	 * @exception EventException
	 * @author
	 */
	public void cancelKorDo(KorDoCancelVO korDoCancel) throws EventException {
		try {
			DoCancelVO doCancel = new DoCancelVO();
			//Value Object Copy
			ObjectCloner.build(korDoCancel, doCancel);

			doCancel.setResetFlg("N");
			doCancel.setRlseStsCd("'A','R','C'");

			this.cancelDo(doCancel);

			KorDoEdiTransVO korDoEdiTrans = new KorDoEdiTransVO();
			//Value Object Copy
			ObjectCloner.build(korDoCancel, korDoEdiTrans);

			korDoEdiTrans.setDoType("KDC");
			korDoEdiTrans.setSelfTrnsFlg("N");

//            this.transmitEdiByKorDo(korDoEdiTrans);

		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * D/O Cancel<br>
	 *
	 * @param DoCancelVO doCancel
	 * @exception EventException
	 * @author
	 */
	public void cancelDo(DoCancelVO doCancel) throws EventException {
		try {
			BkgDoVO doInfo = dbDao.searchDoInfo(doCancel.getDoNo());

			doCancel.setBkgNo(doInfo.getBkgNo());
			doCancel.setRlseSeq(doInfo.getRlseSeq());

			validateDoCancel(doCancel);

			if ("Y".equals(doCancel.getResetFlg())) {
				log.debug("==============");
				log.debug("D/O번호 초기화");
				log.debug("==============");
				dbDao.resetDoNo(doCancel.getBkgNo(), doCancel.getRlseSeq());
			}

			dbDao.removeDoDtlByCancel(doCancel.getBkgNo(), doCancel.getRlseSeq(), doCancel.getRlseStsCd());

			if (!"Y".equals(doCancel.getSplitFlg())) {
				BkgDoDtlVO bkgDoDtl = new BkgDoDtlVO();

				bkgDoDtl.setBkgNo(doCancel.getBkgNo());
				bkgDoDtl.setRlseSeq(doCancel.getRlseSeq());
				bkgDoDtl.setRlseStsCd("C");
				bkgDoDtl.setEvntUsrId(doCancel.getCreUsrId());
				bkgDoDtl.setEvntOfcCd(doCancel.getEvntOfcCd());
				bkgDoDtl.setUpdUsrId(doCancel.getUpdUsrId());
				bkgDoDtl.setCreUsrId(doCancel.getCreUsrId());

				dbDao.addDoDtlSts(bkgDoDtl);
			}

			/*****************************************
				DO RELEASE STATUS CODE
			******************************************
			AS  Assigned
			CR  Cancelled O/BL Received
			DC  DOR Cancel
			DF  DOR I/F
			DT  DOR Transmit
			HC  Cancelled Cargo Hold
			PD  Printed D/O
			RB  Received O. B/L
			RE  Released
			RI  Received In bond Doc
			RO  Received Other Doc
			RR  Remark for Release
			SF  Sent Fax/E-Mail
			XX  Canceled
			/*****************************************
				RELEASE STATUS CODE
			******************************************
			A ASSIGN
			R RELEASE
			D DOR I/F
			I ASSIGN & ISSUE
			C CANCEL
			******************************************/

			//D/O HISTORY Create XX
			log.debug("================");
			log.debug("D/O HISTORY 생성");
			log.debug("================");

			doCancel.setDoCngEvntCd("XX");
			doCancel.setCrntCtnt("X");
			doCancel.setPreCtnt(doCancel.getDoNo());

			BkgDoHisVO bkgDoHis = new BkgDoHisVO();

			bkgDoHis.setBkgNo(doCancel.getBkgNo());
			bkgDoHis.setDoCngEvntCd(doCancel.getDoCngEvntCd());
			bkgDoHis.setPreCtnt(doCancel.getPreCtnt());
			bkgDoHis.setCrntCtnt(doCancel.getCrntCtnt());
			bkgDoHis.setEvntUsrId(doCancel.getCreUsrId());
			bkgDoHis.setEvntOfcCd(doCancel.getEvntOfcCd());
			bkgDoHis.setCreUsrId(doCancel.getCreUsrId());
			bkgDoHis.setUpdUsrId(doCancel.getUpdUsrId());

			dbDao.addDoHistory(bkgDoHis);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * check DO Cancel Y/N<br>
	 *
	 * @param DoCancelVO doCancel
	 * @exception EventException
	 */
	private void validateDoCancel(DoCancelVO doCancel)throws EventException {

		try {
			//HOLD 여부 체크
			log.debug("================================");
			log.debug("해당 D/O의 Hold 여부를 조회한다.");
			log.debug("================================");

			//HOLD check
			if(dbDao.checkHold(doCancel.getBkgNo())){
				throw new EventException(new ErrorHandler("BKG00649").getMessage());
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Cargo Release Order raised by the Event History for historical information should be recorded.<br>
	 *
	 * @param BkgDoHisVO bkgDoHis
	 * @exception EventException
	 */
	public void createDoHistory(BkgDoHisVO bkgDoHis) throws EventException {
		try {
			dbDao.addDoHistory(bkgDoHis);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Target B/L for the D/O Release operations are performed.<br>
	 *
	 * @param DoRlseVO doRlse
	 * @exception EventException
	 * @author
	 */
	private void releaseDo(DoRlseVO doRlse) throws EventException {

		log.debug("===================================================");
		log.debug("화면에서 전달 된 파라메터 : "+doRlse.getRlseStsCd());
		log.debug("===================================================");

		if(!"A".equals(doRlse.getRlseStsCd())){
			DoAsignVO doAsign = new DoAsignVO();
			ObjectCloner.build(doRlse, doAsign);

			String doNo = this.assignDo(doAsign);
			doRlse.setDoNo(doNo);
		}

		validateDoRelease(doRlse.getBkgNo());

		//Value Object
		BkgDoVO bkgDo       = new BkgDoVO();
		BkgDoRefVO bkgDoRef = new BkgDoRefVO();
		BkgDoDtlVO doDtl    = new BkgDoDtlVO();
		BkgDoHisVO doHis    = new BkgDoHisVO();

		bkgDo.setBkgNo(doRlse.getBkgNo());
		bkgDo.setDoNo(doRlse.getDoNo());
		bkgDo.setRlseSeq("1");
		bkgDo.setDoNoSplit("00");
		bkgDo.setCgorRmk(doRlse.getCgorRmk());
		bkgDo.setCreUsrId(doRlse.getAcount().getUsr_id());
		bkgDo.setUpdUsrId(doRlse.getAcount().getUsr_id());

		bkgDoRef.setBkgNo(doRlse.getBkgNo());

		bkgDoRef.setCyOpCd(doRlse.getDoRef().getCyOpCd());
		bkgDoRef.setCstmsRefNm(doRlse.getDoRef().getCstmsRefNm());
		bkgDoRef.setCstmsRefCtnt(doRlse.getDoRef().getCstmsRefCtnt());
		bkgDoRef.setCstmsAsgnNm(doRlse.getDoRef().getCstmsAsgnNm());
		bkgDoRef.setCstmsAsgnCtnt(doRlse.getDoRef().getCstmsAsgnCtnt());
		bkgDoRef.setInterRmk(doRlse.getDoRef().getInterRmk());
		bkgDoRef.setDoHldFlg(JSPUtil.getNull(doRlse.getDoRef().getDoHldFlg(),"N"));
		bkgDoRef.setInfoCgoFlg(doRlse.getDoRef().getInfoCgoFlg());
		bkgDoRef.setDoSplitFlg(JSPUtil.getNull(doRlse.getDoRef().getDoSplitFlg(),"N"));

		bkgDoRef.setCreUsrId(doRlse.getAcount().getUsr_id());
		bkgDoRef.setUpdUsrId(doRlse.getAcount().getUsr_id());

		/*****************************************
			DO RELEASE STATUS CODE
		******************************************
		AS  Assigned
		CR  Cancelled O/BL Received
		DC  DOR Cancel
		DF  DOR I/F
		DT  DOR Transmit
		HC  Cancelled Cargo Hold
		PD  Printed D/O
		RB  Received O. B/L
		RE  Released
		RI  Received In bond Doc
		RO  Received Other Doc
		RR  Remark for Release
		SF  Sent Fax/E-Mail
		XX  Canceled

		/*****************************************
			RELEASE STATUS CODE
		******************************************
		A ASSIGN
		R RELEASE
		D DOR I/F
		I ASSIGN & ISSUE
		C CANCEL
		******************************************/

		doDtl.setBkgNo(doRlse.getBkgNo());
		doDtl.setRlseSeq("1");
		doDtl.setRlseStsCd("R"); //RELEASE
		doDtl.setEvntUsrId(doRlse.getAcount().getUsr_id());
		doDtl.setEvntOfcCd(doRlse.getAcount().getOfc_cd());
		doDtl.setCreUsrId(doRlse.getAcount().getUsr_id());
		doDtl.setUpdUsrId(doRlse.getAcount().getUsr_id());

		doHis.setBkgNo(doRlse.getBkgNo());
		doHis.setCreUsrId(doRlse.getAcount().getUsr_id());
		doHis.setUpdUsrId(doRlse.getAcount().getUsr_id());
		doHis.setDoCngEvntCd("RE"); // Released
		doHis.setPreCtnt("");

		doHis.setCrntCtnt(doRlse.getDoNo().length() == 10?doRlse.getDoNo()+ "00":doRlse.getDoNo());
		doHis.setEvntUsrId(doRlse.getAcount().getUsr_id());
		doHis.setEvntOfcCd(doRlse.getAcount().getOfc_cd());


		bkgDo.setDoNo(bkgDo.getDoNo().substring(0,10));
		this.manageDo(bkgDo, bkgDoRef, doDtl, doHis);
	}

	/**
	 * Target B/L for the D/O Release operations are performed.<br>
	 *
	 * @param KorDoRlseVO korDoRlse
	 * @exception EventException
	 * @author
	 */
	public void releaseKorDo(KorDoRlseVO korDoRlse) throws EventException {

		DoRlseVO doRlse = new DoRlseVO();
		ObjectCloner.build(korDoRlse, doRlse);

		this.releaseDo(doRlse);

		if( JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRPUS") ||
			JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRKAN") ||
			JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRPTK") ||
			JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRPYT") ||
			JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRUSN") ||
			JSPUtil.getNull(korDoRlse.getBlInfo().getPodCd(),"").equals("KRINC")){

			KorDoEdiTransVO korDoEdiTrans = new KorDoEdiTransVO();

			korDoEdiTrans.setDoType("KDS");
			korDoEdiTrans.setBkgNo(korDoRlse.getBkgNo());
			korDoEdiTrans.setRlseSeq(korDoRlse.getRlseSeq());
			korDoEdiTrans.setSelfTrnsFlg(korDoRlse.getSelfTrnsFlg());
			korDoEdiTrans.setDiscLocCd(korDoRlse.getDiscLocCd());
			korDoEdiTrans.setAcount(korDoRlse.getAcount());

//            this.transmitEdiByKorDo(korDoEdiTrans);
		}
	}

	/**
	 * check DO Cancel<br>
	 *
	 * @param String bkgNo
	 * @exception EventException
	 */
	private void validateDoRelease(String bkgNo)throws EventException {

		try {
			log.debug("================================");
			log.debug("해당 D/O의 Hold 여부를 조회한다.");
			log.debug("================================");

			if(dbDao.checkHold(bkgNo)){
				throw new EventException(new ErrorHandler("BKG00649").getMessage());
			}

			log.debug("========================================================");
			log.debug("LCL일 경우 관련 B/L들에 대한 O/BL 회수 여부를 CHECK한다.");
			log.debug("========================================================");

		} catch(EventException ee) {
			throw ee;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * DO target B/L units to HOLD.<br>
	 * @param DoHoldVO doHold
	 * @exception EventException
	 */
	public void holdDo(DoHoldVO doHold) throws EventException {
		try {
			BkgDoRefVO bkgDoRef = new BkgDoRefVO();
			String doCngEvntCd = "";
			//Hold
			if ("H".equals(doHold.getEvntFlag())) {
				doCngEvntCd = "HC";
				log.debug("HOLD : FLG : N ==> Y");
				int modifyCnt = dbDao.modifyDoRefByHold(doHold);

				if(modifyCnt == 0){
					bkgDoRef.setBkgNo(doHold.getBkgNo());
					bkgDoRef.setDoHldFlg("Y");
					bkgDoRef.setDoSplitFlg("N");
					bkgDoRef.setCreUsrId(doHold.getCreUsrId());
					bkgDoRef.setUpdUsrId(doHold.getUpdUsrId());
					dbDao.addDoRef(bkgDoRef);
				}
			//Put
			}else if ("R".equals(doHold.getEvntFlag())){
				doCngEvntCd = "CH";
				log.debug("UN-HOLD FLG : Y ==> N");
				dbDao.holdRlseDo(doHold);
				//BL 단위로 Hold remove 할 때 유럽에서는 container로 hold되어 있던 부분도 다 지워져야함
				dbDao.removeDoCntrHld(doHold.getBkgNo());
			}
			//D/O HISTORY Create
			BkgDoHisVO doHis = new BkgDoHisVO();

			log.debug("D/O HISTORY Create");
			doHis.setBkgNo(doHold.getBkgNo());
			doHis.setCreUsrId(doHold.getAcount().getUsr_id());
			doHis.setUpdUsrId(doHold.getAcount().getUsr_id());
			doHis.setDoCngEvntCd(doCngEvntCd);
			doHis.setPreCtnt("NO");
			doHis.setCrntCtnt("YES");
			doHis.setEvntUsrId(doHold.getAcount().getUsr_id());
			doHis.setEvntOfcCd(doHold.getAcount().getOfc_cd());

			dbDao.addDoHistory(doHis);


		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * KT-NET E-DO request came through (D/O issuance application form) will send the results for.<br>
	 *
	 * @param EdoEdiTransVO[] edoEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByEdo(EdoEdiTransVO[] edoEdiTrans) throws EventException {
		try {
			for(int idx=0; idx<edoEdiTrans.length; idx++){

				log.debug("\n==========>>>"+edoEdiTrans[idx].getEdoTpCd());
				log.debug("\n==========>>>"+edoEdiTrans[idx].getEdoAckCd());

				if("5JN".equals(edoEdiTrans[idx].getEdoTpCd())){
					log.debug("D/O 발급 신청서");
					this.transmitEdoBy5JN(edoEdiTrans[idx]);

					if("A".equals(edoEdiTrans[idx].getEdoAckCd())){
						String ediEdoCusagdDoMst  = dbDao.searchEdiEdoCusagdDoMst(edoEdiTrans[idx].getBkgNo());
						String[] ediEdoCusagdDoCntr = dbDao.searchEdiEdoCusagdDoCntr(edoEdiTrans[idx].getBkgNo());


						StringBuffer sb = new StringBuffer();

						sb.append( ediEdoCusagdDoMst );

						for(int i=0; i< ediEdoCusagdDoCntr.length; i++){
							sb.append(ediEdoCusagdDoCntr[i]);
						}

						/*
						 * EDI.
						 */
						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(sb.toString());

						//QueueNm
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EDO.IBMMQ.QUEUE"));
						BookingUtil command = new BookingUtil();

						FlatFileAckVO flatFileAckVO = new FlatFileAckVO();

						log.debug("========================================");
						log.debug("transmitEdiByEdo 로그 호출");
						log.debug(sendFlatFileVO.toString());
						log.debug("========================================");

						flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

						//EDI ERROR
						if ( flatFileAckVO.getAckStsCd().equals("E")){
							throw new EventException(new ErrorHandler("BKG00205").getMessage());
						}
						dbDao.modifyEdoDoByCusagdDoEdiTrans(edoEdiTrans[idx]);

						// EDI log
						BkgIbEdiSndLogVO ibEdiSndLog = new BkgIbEdiSndLogVO();

						ibEdiSndLog.setBkgNo(edoEdiTrans[idx].getBkgNo());
						ibEdiSndLog.setFltFileRefNo(ediEdoCusagdDoMst.substring(62,76));
						ibEdiSndLog.setDoEdiTpCd(edoEdiTrans[idx].getEdoTpCd());
						ibEdiSndLog.setMsgTpNm("CUSAGD");
						ibEdiSndLog.setMsgTpId("KTNMFCSDO");
						ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
						ibEdiSndLog.setEdiEvntOfcCd(edoEdiTrans[idx].getAcount().getOfc_cd());
						ibEdiSndLog.setEdiEvntUsrId(edoEdiTrans[idx].getAcount().getUsr_id());
						ibEdiSndLog.setCreUsrId(edoEdiTrans[idx].getAcount().getUsr_id());
						ibEdiSndLog.setUpdUsrId(edoEdiTrans[idx].getAcount().getUsr_id());

						dbDao.addIbEdiSndLog(ibEdiSndLog);
					}
				}else if("5JM".equals(edoEdiTrans[idx].getEdoTpCd())){
					log.debug("\n자가운송 요청 동의서");
					log.debug("\n==========>>>>>>>>>>>>>>>>"+edoEdiTrans[idx].getEdoAckCd());
					this.transmitEdoBy5JM(edoEdiTrans[idx]);
				}else if("5JK".equals(edoEdiTrans[idx].getEdoTpCd())){
					log.debug("보세운송 요청 동의서");
					this.transmitEdoBy5JK(edoEdiTrans[idx]);
				}
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * KT-NET E-DO request came through (D/O issuance application form) will send the results for.<br>
	 *
	 * @param EdoTransVO edoTrans
	 * @exception EventException
	 */
	private void transmitEdiByEdoGenres(EdoEdiTransVO edoEdiTrans) throws EventException {
		try {
			String ediGenresHeader  = dbDao.searchEdiEdoGenresHeader();
			String ediGenresMst     = dbDao.searchEdiEdoGenresMst(edoEdiTrans);
			String ediGenresPtyTrsp = dbDao.searchEdiEdoGenresPtyTrsp(edoEdiTrans);

			/*
			 * EDI .
			 */
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(ediGenresHeader+ediGenresMst+ediGenresPtyTrsp);

			log.debug("\n========================================");
			log.debug("\n"+"transmitEdiByEdoGenres 로그 호출");
			log.debug(sendFlatFileVO.toString());
			log.debug("\n========================================");

			//QueueNm
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EDO.IBMMQ.QUEUE"));
			BookingUtil command = new BookingUtil();

			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			//EDI ERROR
			if ( flatFileAckVO.getAckStsCd().equals("E")){
				edoEdiTrans.setEdoAckCd(flatFileAckVO.getAckStsCd());
				throw new EventException(new ErrorHandler("BKG00205").getMessage());
			}

			// EDI log
			BkgIbEdiSndLogVO ibEdiSndLog = new BkgIbEdiSndLogVO();

			ibEdiSndLog.setBkgNo(edoEdiTrans.getBkgNo());
			ibEdiSndLog.setFltFileRefNo(ediGenresHeader.substring(62,76));
			ibEdiSndLog.setDoEdiTpCd(edoEdiTrans.getEdoTpCd());
			ibEdiSndLog.setMsgTpNm("GENRES");
			ibEdiSndLog.setMsgTpId("KTNMFCSDO");
			ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
			ibEdiSndLog.setEdiEvntOfcCd(edoEdiTrans.getAcount().getOfc_cd());
			ibEdiSndLog.setEdiEvntUsrId(edoEdiTrans.getAcount().getUsr_id());
			ibEdiSndLog.setCreUsrId(edoEdiTrans.getAcount().getUsr_id());
			ibEdiSndLog.setUpdUsrId(edoEdiTrans.getAcount().getUsr_id());

			dbDao.addIbEdiSndLog(ibEdiSndLog);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * KT-NET E-DO request came through (D/O issuance application form) will send the results for.<br>
	 *
	 * @param EdoTransVO edoTrans
	 * @exception EventException
	 */
	private void transmitEdoBy5JN(EdoEdiTransVO edoEdiTrans) throws EventException {

		try {
			 if(! "N".equals(edoEdiTrans.getEdoAckCd())){
				 dbDao.modifyEdoMstByGenresEdiTrans(edoEdiTrans);
			 }
			//Approved, rejected
			if("A".equals(edoEdiTrans.getEdoAckCd()) || "R".equals(edoEdiTrans.getEdoAckCd())){
				this.transmitEdiByEdoGenres(edoEdiTrans);
				dbDao.modifyEdoDoByGenresEdiTrans(edoEdiTrans);       //Issue Office 정보
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * KT-NET E-DO request came through (D/O issuance application form) will send the results for.<br>
	 *
	 * @param EdoTransVO edoTrans
	 * @exception EventException
	 */
	private void transmitEdoBy5JM(EdoEdiTransVO edoEdiTrans) throws EventException {
		String selfTransFlg = "N";
		try {
			if(! "N".equals(edoEdiTrans.getEdoAckCd())){
				  dbDao.modifyEdoMstByGenresEdiTrans(edoEdiTrans);
			}
			//Approved, rejected
			if("A".equals(edoEdiTrans.getEdoAckCd()) || "R".equals(edoEdiTrans.getEdoAckCd())){
				this.transmitEdiByEdoGenres(edoEdiTrans);
				if("A".equals(edoEdiTrans.getEdoAckCd())){
					selfTransFlg = "Y";

					 /*##################################################*/
					KorDoEdiTransVO korDoEdiTrans = new KorDoEdiTransVO();

					korDoEdiTrans.setDoType("KDS");
					korDoEdiTrans.setBkgNo(edoEdiTrans.getBkgNo());
					korDoEdiTrans.setRlseSeq("1");
					korDoEdiTrans.setSelfTrnsFlg(selfTransFlg);
					korDoEdiTrans.setAcount(edoEdiTrans.getAcount());

//                    this.transmitEdiByKorDo(korDoEdiTrans);
				}

			}


		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * KT-NET E-DO request came through (D/O issuance application form) will send the results for.<br>
	 *
	 * @param EdoTransVO edoTrans
	 * @exception EventException
	 */
	private void transmitEdoBy5JK(EdoEdiTransVO edoEdiTrans) throws EventException {
		try {
			if(! "N".equals(edoEdiTrans.getEdoAckCd())){
				  dbDao.modifyEdoMstByGenresEdiTrans(edoEdiTrans);
			}
			//기각 시
			if("R".equals(edoEdiTrans.getEdoAckCd())){
				this.transmitEdiByEdoGenres(edoEdiTrans);
			}//승인 시
			else if("A".equals(edoEdiTrans.getEdoAckCd())){

				String ediCusagdMst       = dbDao.searchEdiEdoCusagdEdoMst(edoEdiTrans);
				String[] ediCusagdPtyTrsp = dbDao.searchEdiEdoCusagdEdoPtyTrsp(edoEdiTrans);
				String[] ediCusagdCntr    = dbDao.searchEdiEdoCusagdEdoCntr(edoEdiTrans);

				StringBuffer sb = new StringBuffer();

				sb.append( ediCusagdMst );

				for(int idx=0; idx< ediCusagdPtyTrsp.length; idx++){
					sb.append(ediCusagdPtyTrsp[idx]);
				}

				for(int idx=0; idx< ediCusagdCntr.length; idx++){
					sb.append(ediCusagdCntr[idx]);
				}

				/*
				 * EDI.
				 */
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile( sb.toString() );

				log.debug("\n========================================");
				log.debug("\n"+"transmitEdoBy5JK 로그 호출");
				log.debug(sendFlatFileVO.toString());
				log.debug("\n========================================");

				//QueueNm
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EDO.IBMMQ.QUEUE"));
				BookingUtil command = new BookingUtil();

				FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
				flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

				//EDI ERROR
				if ( flatFileAckVO.getAckStsCd().equals("E")){
					edoEdiTrans.setEdoTpCd(flatFileAckVO.getAckStsCd());
					throw new EventException(new ErrorHandler("BKG00205").getMessage());
				}


			   // EDI log
				BkgIbEdiSndLogVO ibEdiSndLog = new BkgIbEdiSndLogVO();

				ibEdiSndLog.setBkgNo(edoEdiTrans.getBkgNo());
				ibEdiSndLog.setFltFileRefNo(ediCusagdMst.substring(62,76));
				ibEdiSndLog.setDoEdiTpCd(edoEdiTrans.getEdoTpCd());
				ibEdiSndLog.setMsgTpNm("CUSAGD");
				ibEdiSndLog.setMsgTpId("KTNMFCSDO_BTC");
				ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
				ibEdiSndLog.setEdiEvntOfcCd(edoEdiTrans.getAcount().getOfc_cd());
				ibEdiSndLog.setEdiEvntUsrId(edoEdiTrans.getAcount().getUsr_id());
				ibEdiSndLog.setCreUsrId(edoEdiTrans.getAcount().getUsr_id());
				ibEdiSndLog.setUpdUsrId(edoEdiTrans.getAcount().getUsr_id());

				dbDao.addIbEdiSndLog(ibEdiSndLog);
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0682 : EDI receive <br>
	 *
	 * @param String rqstNo
	 * @param String ackInd
	 * @exception EventException
	 */
	public void receiptEdoRqstAck(String rqstNo, String ackInd) throws EventException {
		try {
			dbDao.modifyEdoDoByAck(rqstNo, ackInd);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0682 : EDI receive <br>
	 *
	 * @param EdoRqstVO edoRqst
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiptEdo(EdoRqstVO edoRqst, SignOnUserAccount account) throws EventException {
		try {
			String edoTpCd = edoRqst.getBkgEdoMstVO().getEdoTpCd();
			String podCd   = "";

			log.debug("==============================");
			log.debug("EDO로 수신한 문서 종류 : "+edoTpCd);
			log.debug("요청번호 : "+edoRqst.getBkgEdoMstVO().getEdoRqstNo());
			log.debug("==============================");

			podCd = dbDao.searchPodCd(edoRqst.getBkgEdoMstVO().getBlNo());

			edoRqst.getBkgEdoMstVO().setPodCd(podCd);

			String edoRqstSeq = dbDao.searchEdoMaxRqstSeq(edoRqst.getBkgEdoMstVO().getEdoRqstNo());

			dbDao.addEdoMst(edoRqst.getBkgEdoMstVO(), edoRqstSeq, account);

			if("5JN".equals(edoTpCd)){
				dbDao.addEdoDo(edoRqst.getBkgEdoDoVO(), edoRqstSeq, account);
			}else if("5JM".equals(edoTpCd)){
				dbDao.addEdoSelfTrsp(edoRqst.getBkgEdoSelfTrspVO(), edoRqstSeq, account);
			}else if("5JK".equals(edoTpCd)){
				dbDao.addEdoIbdTrsp(edoRqst.getBkgEdoIbdTrspVO(), edoRqstSeq, account);
			}

			List<BkgEdoPtyTrspVO> ptyTrspVoList = new ArrayList<BkgEdoPtyTrspVO>();
			Iterator<BkgEdoPtyTrspVO> itr = edoRqst.getBkgEdoPtyTrspVOs().iterator();

			while (itr.hasNext()){

				BkgEdoPtyTrspVO ptyTrspVo = (BkgEdoPtyTrspVO) itr.next();
				ptyTrspVo.setEdoRqstNo(edoRqst.getBkgEdoMstVO().getEdoRqstNo());
				ptyTrspVo.setEdoRqstSeq(edoRqstSeq);
				ptyTrspVo.setCreUsrId("ESM_BKG_B024");
				ptyTrspVo.setUpdUsrId("ESM_BKG_B024");
				ptyTrspVoList.add(ptyTrspVo);
			}

			if ( ptyTrspVoList.size() > 0 ) {
				dbDao.addEdoPtyTrsp(ptyTrspVoList);
			}

			List<BkgEdoCntrVO> cnntrVoList = new ArrayList<BkgEdoCntrVO>();
			Iterator<BkgEdoCntrVO> iterator = edoRqst.getBkgEdoCntrVOs().iterator();

			while (iterator.hasNext()) {
				BkgEdoCntrVO cntrVO = (BkgEdoCntrVO) iterator.next();
				cntrVO.setEdoRqstNo(edoRqst.getBkgEdoMstVO().getEdoRqstNo());
				cntrVO.setEdoRqstSeq(edoRqstSeq);
				cntrVO.setCreUsrId("ESM_BKG_B024");
				cntrVO.setUpdUsrId("ESM_BKG_B024");
				cnntrVoList.add(cntrVO);
			}

			if ( cnntrVoList.size() > 0 ) {
				dbDao.addEdoCntr(cnntrVoList);
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0682 : EDI receive <br>
	 *
	 * @param BkgEdoLogVO edoLog
	 * @exception EventException
	 */
	public void receiptEdoLog(BkgEdoLogVO edoLog) throws EventException {
		try {
			dbDao.addEdoLog(edoLog);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Retrieving Japan D/O <br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return JapDoMstVO japDoMst
	 * @exception EventException
	 */
	public JapDoMstVO searchJapDo(String bkgNo, SignOnUserAccount account)throws EventException {

		JapDoMstVO japDoMst = new JapDoMstVO();

		try {
			validateBkgSts(bkgNo);
			DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
			japDoMst.setBlInfo(blInfo);

			if(blInfo != null){
				log.debug("==============================");
				log.debug("searchDoBlInfo");
				log.debug("==============================");

				if(!blInfo.getDelCd().substring(0,2).equals("JP")) {  // 12
					String[] msg = new String[]{blInfo.getPodCd()};
					throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
				}

				BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo);

				if(doRef == null){
					doRef = new BkgDoRefVO();
					doRef.setBkgNo(blInfo.getBkgNo());
				}

				japDoMst.setDoRef(doRef);

				/**
				 * Japan Customs for B / L INFO to retrieving.
				 */
				JapCstmsVO japCstms = dbDao.searchJapCstmsInfo(bkgNo);
				japDoMst.setJapCstms(japCstms);

				/**
				 * B/L by D/O of the STATUS (ASSIGN, RELEASE, ISSUE) is lookup by the details.
				 */
				List<DoRlseStsVO> doRlseSts= dbDao.searchDoRlseSts(bkgNo);

				japDoMst.setDoRlseSts(doRlseSts);

				if(doRlseSts.size() > 0 ){
					//retrieving Dor Interface
					JapDorStatusVO japDorStatus = dbDao.searchJapDorStatus(bkgNo, doRlseSts.get(0).getRlseSeq());
					//Japan DO ID Save the information sheet at BKG NO BKG NO setting is required
					japDorStatus.setBkgNo(bkgNo);
					japDoMst.setJapDorStatus(japDorStatus);

					//DOR I/F of the DOR does not DOR Transmit number of  B/L
					int dorStowage = dbDao.searchJapDorStowageCnt();
					japDoMst.setDorStowage(String.valueOf(dorStowage));
				}

				/**
				 * Retrieved at the time of Retrieved Original B/L number of issued and whether discharge is lookup and Detail information.
				 */
				BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
				japDoMst.setBlIss(blIss);

				/**
				 * Outstanding Amounts of whether freight payment information is lookup from the ERP system.
				 */
				OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
				otsRcvInfoVO = this.searchErpOtsInfo(japDoMst.getBlInfo().getBlNo());
				japDoMst.setOtsRcvInfoVO(otsRcvInfoVO);

				/**
				 * 출력 FORM의 종류를 조회한다.
				 */
				String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());
				japDoMst.setMrdId(mrdId);
			} else {
				log.debug("==============================");
				log.debug("searchDoBlInfo 데이터 없음");
				log.debug("==============================");

			}
			return japDoMst;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * saving D/O information.
	 *
	 * @param JapDoSaveVO japDoSave
	 * @exception EventException
	 */
	public void manageJapDo(JapDoSaveVO japDoSave) throws EventException {
		try {
			int resultCnt =0;

			BkgDoHisVO doHis = new BkgDoHisVO();

			String preCtnt  = "N";
			String crntCtnt = "Y";

			if("CR".equals(japDoSave.getDoCngEvntCd())){
				preCtnt  = "Y";
				crntCtnt = "N";
			}

			if("Y".equals(japDoSave.getOblCngFlg())){

				doHis.setBkgNo(japDoSave.getBkgNo());
				doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
				doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
				doHis.setDoCngEvntCd(japDoSave.getDoCngEvntCd());
				doHis.setPreCtnt(preCtnt);
				doHis.setCrntCtnt(crntCtnt);
				doHis.setEvntUsrId(japDoSave.getAcount().getUsr_id());
				doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

				dbDao.addDoHistory(doHis);
			}

			BkgDoRefVO refInfo = dbDao.searchDoRefInfo(japDoSave.getBkgNo());
			if(refInfo == null || !japDoSave.getInterRmk().equals(refInfo.getInterRmk())){

				doHis = new BkgDoHisVO();

				doHis.setBkgNo(japDoSave.getBkgNo());
				doHis.setCreUsrId(japDoSave.getAcount().getUsr_id());
				doHis.setUpdUsrId(japDoSave.getAcount().getUsr_id());
				doHis.setDoCngEvntCd("IR");
				if(refInfo == null){
					doHis.setPreCtnt(null);
				} else {
					doHis.setPreCtnt(refInfo.getInterRmk());
				}
				doHis.setCrntCtnt(japDoSave.getInterRmk());
				doHis.setEvntOfcCd(japDoSave.getAcount().getOfc_cd());

				dbDao.addDoHistory(doHis);

			}

			BkgDoRefVO refInfos = new BkgDoRefVO();

			refInfos.setBkgNo(japDoSave.getBkgNo());
			refInfos.setCstmsRefNm(japDoSave.getCstmsRefNm());
			refInfos.setCstmsRefCtnt(japDoSave.getCstmsRefCtnt());
			refInfos.setCstmsAsgnNm(japDoSave.getCstmsAsgnNm());
			refInfos.setCstmsAsgnCtnt(japDoSave.getCstmsAsgnCtnt());
			refInfos.setInterRmk(japDoSave.getInterRmk());
			refInfos.setDoHldFlg(japDoSave.getDoHldFlg());
			refInfos.setCreUsrId(japDoSave.getAcount().getUsr_id());
			refInfos.setUpdUsrId(japDoSave.getAcount().getUsr_id());
			refInfos.setInfoCgoFlg(japDoSave.getInfoCgoFlg());
			refInfos.setDoSplitFlg(japDoSave.getDoSplitFlg());
			refInfos.setCyOpCd(japDoSave.getCyOpCd());

			resultCnt = dbDao.modifyDoRef(refInfos);

			if ( resultCnt == 0 ) {
				dbDao.addDoRef(refInfos);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Japan D/O target B/L for the D/O Assign & Issue task is performed.
	 *
	 * @param JapDoIssueVO japDoIssue
	 * @exception EventException
	 */
	public void issueJapDo(JapDoIssueVO japDoIssue) throws EventException {
		try {
			//check DO Assign / Issue
			validateJapDoIssue(japDoIssue.getBkgNo());

			//get DO No
			String doNo = makeDoNo(japDoIssue.getAcount().getOfc_cd(), japDoIssue.getAcount().getUsr_id());

			//Value Object
			BkgDoVO bkgDo       = new BkgDoVO();
			BkgDoRefVO bkgDoRef = new BkgDoRefVO();
			BkgDoDtlVO doDtl    = new BkgDoDtlVO();

			bkgDo.setBkgNo(japDoIssue.getBkgNo());
			bkgDo.setDoNo(doNo);
			bkgDo.setRlseSeq("1");
			bkgDo.setDoNoSplit("00");
			bkgDo.setCgorRmk(japDoIssue.getCgorRmk());
			bkgDo.setCreUsrId(japDoIssue.getAcount().getUsr_id());
			bkgDo.setUpdUsrId(japDoIssue.getAcount().getUsr_id());

			bkgDoRef.setBkgNo(japDoIssue.getBkgNo());

			if(null != japDoIssue.getRefInfo()){

				bkgDoRef.setCyOpCd(japDoIssue.getRefInfo().getCyOpCd());
				bkgDoRef.setCstmsRefNm(japDoIssue.getRefInfo().getCstmsRefNm());
				bkgDoRef.setCstmsRefCtnt(japDoIssue.getRefInfo().getCstmsRefCtnt());
				bkgDoRef.setCstmsAsgnNm(japDoIssue.getRefInfo().getCstmsAsgnNm());
				bkgDoRef.setCstmsAsgnCtnt(japDoIssue.getRefInfo().getCstmsAsgnCtnt());
				bkgDoRef.setInterRmk(japDoIssue.getRefInfo().getInterRmk());
				bkgDoRef.setDoHldFlg(JSPUtil.getNull(japDoIssue.getRefInfo().getDoHldFlg(),"N"));
				bkgDoRef.setInfoCgoFlg(japDoIssue.getRefInfo().getInfoCgoFlg());
				bkgDoRef.setDoSplitFlg(JSPUtil.getNull(japDoIssue.getRefInfo().getDoSplitFlg(),"N"));
			}else{
				bkgDoRef.setDoHldFlg("N");
				bkgDoRef.setDoSplitFlg("N");
			}
			bkgDoRef.setCreUsrId(japDoIssue.getAcount().getUsr_id());
			bkgDoRef.setUpdUsrId(japDoIssue.getAcount().getUsr_id());

			/*****************************************
				RELEASE STATUS CODE
			******************************************
			A ASSIGN
			R RELEASE
			D DOR I/F
			I ASSIGN & ISSUE
			C CANCEL
			******************************************/

			doDtl.setBkgNo(japDoIssue.getBkgNo());
			doDtl.setRlseSeq("1");
			doDtl.setRlseStsCd("I");
			doDtl.setEvntUsrId(japDoIssue.getAcount().getUsr_id());
			doDtl.setEvntOfcCd(japDoIssue.getAcount().getOfc_cd());
			doDtl.setCreUsrId(japDoIssue.getAcount().getUsr_id());
			doDtl.setUpdUsrId(japDoIssue.getAcount().getUsr_id());

			BkgDoHisVO doHis = new BkgDoHisVO();

			doHis.setBkgNo(japDoIssue.getBkgNo());
			doHis.setCreUsrId(japDoIssue.getAcount().getUsr_id());
			doHis.setUpdUsrId(japDoIssue.getAcount().getUsr_id());
			doHis.setDoCngEvntCd("AI"); //AI  ASSIGN & ISSUE
			doHis.setPreCtnt("");
			doHis.setCrntCtnt(doNo);

			doHis.setEvntUsrId(japDoIssue.getAcount().getUsr_id());
			doHis.setEvntOfcCd(japDoIssue.getAcount().getOfc_cd());

			manageDo(bkgDo, bkgDoRef, doDtl, doHis);

		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * DO Assign / Issue check<br>
	 * @param String bkgNo
	 * @exception EventException
	 */
	private void validateJapDoIssue(String bkgNo)throws EventException {
		try {
			if(dbDao.checkHold(bkgNo)){
				throw new EventException(new ErrorHandler("BKG00649").getMessage());
			}
			if(dbDao.checkJapDoIssue(bkgNo)){
				throw new EventException(new ErrorHandler("BKG00434").getMessage());
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * get DO No<br>
	 * @param String ofcCd
	 * @param String userId
	 * @return String doNo
	 * @exception EventException
	 */
	private String makeDoNo(String ofcCd, String userId) throws EventException {

		BookingUtil command = new BookingUtil();
		BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = new BkgReferenceNoGenerationVO(); //채번할 D/O

		//D/O No
		bkgReferenceNoGenerationVO = command.manageBkgReferenceNumberGeneration ( "D/O" , ofcCd, userId);
		return bkgReferenceNoGenerationVO.getDnoNo();
	}

	/**
	 * D/O to store information.
	 * @param bkgDo
	 * @param bkgDoRef
	 * @param doDtl
	 * @param doHis
	 * @exception EventException
	 */
	private void manageDo(BkgDoVO bkgDo, BkgDoRefVO bkgDoRef, BkgDoDtlVO doDtl, BkgDoHisVO doHis) throws EventException {
		try {
			int resultCnt = 0;

			resultCnt = dbDao.modifyDo(bkgDo);

			if ( resultCnt == 0 ) {
				dbDao.addDo(bkgDo);
			}

			if (null != bkgDoRef.getBkgNo()) {
				resultCnt = dbDao.modifyDoRef(bkgDoRef);

				if ( resultCnt == 0 ) {
					dbDao.addDoRef(bkgDoRef);
				}
			}

			dbDao.removeDoCancel(doDtl);

			dbDao.addDoDtlSts(doDtl);

			dbDao.addDoHistory(doHis);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * handling Cancel event<br>
	 *
	 * @param KorDoEdiTransVO korDoEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByKorDo(KorDoEdiTransVO korDoEdiTrans) throws EventException {

		BkgIbEdiSndLogVO ibEdiSndLog = null;
		BookingUtil utilBC = null;

		try {
			//* Default
			//2.Receiver ID   : KLDOCHKS
			//3.MsgId         : COREOR

			String senderId = "";

			utilBC = new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("IB_NTC_PRTY_ID");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1("SNDRID");
			List<BkgHrdCdgCtntVO> resultSenderId = utilBC.searchHardCoding(bkgHrdCdgCtntListCondVO);

			if(resultSenderId.size() > 0){
				senderId = ((BkgHrdCdgCtntVO)resultSenderId.get(0)).getAttrCtnt2();
			}

			String receiverId = "KLDOCHKS";
			String msgId      = "COREOR";

			String doType = korDoEdiTrans.getDoType(); //DO TYPE

			BkgHrdCdgCtntVO hrdCDdgCtnt = new  BkgHrdCdgCtntVO();

			//
			if(!"KDL".equals(doType)){
				dbDao.mergeKorDoSelfTransFlg(korDoEdiTrans.getBkgNo(), korDoEdiTrans.getSelfTrnsFlg(), korDoEdiTrans.getAcount().getUsr_id());
			}

			//
			if("KDS".equals(doType)){
				if( "".equals( korDoEdiTrans.getDiscLocCd()) ){
					korDoEdiTrans.setDiscLocCd(null);
				}

				if( korDoEdiTrans.getDiscLocCd() != null ){
					hrdCDdgCtnt = dbDao.searchKorDoEdiId(korDoEdiTrans.getDiscLocCd());
					if(hrdCDdgCtnt != null) {
					   senderId   = hrdCDdgCtnt.getAttrCtnt2();
					   receiverId = hrdCDdgCtnt.getAttrCtnt3();
					}
				}

			}

			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
			String header   = dbDao.searchDoEdiHeader(senderId, receiverId, referenceNumber, msgId);
			String doBlInfo = dbDao.searchEdiKorDoBlInfo(korDoEdiTrans.getBkgNo(), doType);

			if ( "".equals(doBlInfo) || doBlInfo == null) {
				throw new EventException(new ErrorHandler("BKG00205").getMessage());
			}

			//retrieve Booking Container
			String[] cntrInfo   = dbDao.searchEdiKorDoCntrInfo(korDoEdiTrans.getBkgNo(), doType);

			/*****************************************************************************
			 * Flat File Create
			 * MQName : OPUSBKG_UBIZCOM_DO
			 * Sender ID :  ( Default Value )
			 * Receiver ID : KLDOCHKS ( Default Value )
			*****************************************************************************/

			/**
			 * EDI .
			 */
			StringBuffer flatFile = new StringBuffer();

			flatFile.append(header);
			flatFile.append(doBlInfo);

			for(int i=0 ; i < cntrInfo.length ; i++) {
			   flatFile.append(cntrInfo[i]);
			}


			log.debug("\n========================================");
			log.debug("\n"+"KL-NET 호출");
			log.debug(flatFile.toString());
			log.debug("\n========================================");

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());

			//QueueNm 세팅
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_DO.IBMMQ.QUEUE"));
			BookingUtil command = new BookingUtil();

			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			log.debug("\n========================================");
			log.debug("\n"+"KL-NET 호출");
			log.debug("doType: " + doType);
			log.debug("\n========================================");
			log.debug("doType: " + doType);



			//EDI ERROR
			if ( flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205").getMessage());


			ibEdiSndLog = new BkgIbEdiSndLogVO();

			ibEdiSndLog.setBkgNo(korDoEdiTrans.getBkgNo());
			ibEdiSndLog.setFltFileRefNo(header.substring(62,76));
			ibEdiSndLog.setDoEdiTpCd(doType);
			ibEdiSndLog.setMsgTpId("KLDOCHKS");
			ibEdiSndLog.setMsgTpNm("COREOR");
			ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
			ibEdiSndLog.setEdiEvntOfcCd(korDoEdiTrans.getAcount().getOfc_cd());
			ibEdiSndLog.setEdiEvntUsrId(korDoEdiTrans.getAcount().getUsr_id());
			ibEdiSndLog.setCreUsrId(korDoEdiTrans.getAcount().getUsr_id());
			ibEdiSndLog.setUpdUsrId(korDoEdiTrans.getAcount().getUsr_id());

			dbDao.addIbEdiSndLog(ibEdiSndLog);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  D/O ID and its Detail information is transmitted to EDI.
	 *
	 * @param JapDorEdiTransVO japDorEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByJapDor(JapDorEdiTransVO japDorEdiTrans) throws EventException {

		BkgIbEdiSndLogVO ibEdiSndLog = null;
		try {

			//HOLD check
			if(dbDao.checkHold(japDorEdiTrans.getBkgNo())){
				throw new EventException(new ErrorHandler("BKG00649").getMessage());
			}

			//MFR check
			if(!dbDao.checkJapMfrTransmit(japDorEdiTrans.getBlNo())){
				throw new EventException(new ErrorHandler("BKG43038",new String[]{japDorEdiTrans.getBlNo()}).getMessage());
			}


			int cnt = 0; //DOR not Transmit B/L count

			//Japan D/O 에서 DOR 버튼 클릭시
			//  C: 세관호출,D:D/O화면 호출
			if("D".equals(japDorEdiTrans.getSvcCd())){
				if(dbDao.checkJapDor(japDorEdiTrans.getBkgNo())){
					throw new EventException(new ErrorHandler("BKG43046").getMessage());
				}

				dbDao.addJapDorTmp(japDorEdiTrans);

				//D/O HISTORY Create
				japDorEdiTrans.setDoCngEvntCd("DF");
				japDorEdiTrans.setCrntCtnt("DF");

				BkgDoHisVO bkgDoHis = new BkgDoHisVO();

				bkgDoHis.setBkgNo(japDorEdiTrans.getBkgNo());
				bkgDoHis.setDoCngEvntCd(japDorEdiTrans.getDoCngEvntCd());

				bkgDoHis.setPreCtnt("");
				bkgDoHis.setCrntCtnt(japDorEdiTrans.getDoNo());

				bkgDoHis.setEvntUsrId(japDorEdiTrans.getCreUsrId());
				bkgDoHis.setEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
				bkgDoHis.setCreUsrId(japDorEdiTrans.getCreUsrId());
				bkgDoHis.setUpdUsrId(japDorEdiTrans.getUpdUsrId());

				dbDao.addDoHistory(bkgDoHis);

				dbDao.modifyJapDorStsByReqest(japDorEdiTrans);

				cnt = dbDao.searchJapDorStowageCnt();

				BkgDoDtlVO bkgDoDtl = new BkgDoDtlVO();

				bkgDoDtl.setBkgNo(japDorEdiTrans.getBkgNo());
				bkgDoDtl.setRlseSeq(japDorEdiTrans.getRlseSeq());
				bkgDoDtl.setRlseStsCd("D");
				bkgDoDtl.setEvntUsrId(japDorEdiTrans.getCreUsrId());
				bkgDoDtl.setEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
				bkgDoDtl.setUpdUsrId(japDorEdiTrans.getUpdUsrId());
				bkgDoDtl.setCreUsrId(japDorEdiTrans.getCreUsrId());

				dbDao.addDoDtlSts(bkgDoDtl);
			}

			if(cnt >9 ||"C".equals(japDorEdiTrans.getSvcCd())){

				String grpNo = dbDao.searchJapDorNextGrpNo();
				japDorEdiTrans.setGrpNo(grpNo);

				japDorEdiTrans.setRlseSeq("1");

				dbDao.modifyJapDorTmpStsByTrans(japDorEdiTrans);

				String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
				japDorEdiTrans.setRefNumber(referenceNumber);

				String header   = dbDao.searchEdiSeanaccsHeader(japDorEdiTrans);
				String common   = dbDao.searchEdiSeanaccsCommon(japDorEdiTrans);
				String eventCd  = dbDao.searchEdiSeanaccsEventType(japDorEdiTrans.getEvntCd());
				String[] blInfo = dbDao.searchEdiSeanaccsBlInfoByTrans(japDorEdiTrans);

				StringBuffer blInfo_tmp = new StringBuffer();

				for(int idx =0; idx <blInfo.length; idx++){
				   blInfo_tmp.append(blInfo[idx]);
				}


				/*
				 * EDI
				 */
				StringBuffer flatFile = new StringBuffer();

				flatFile.append(header);
				flatFile.append(common);
				flatFile.append(eventCd);
				flatFile.append(blInfo_tmp.toString());

				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());

				log.debug("\n========================================");
				log.debug("\n"+"transmitEdiByJapDor 로그 호출" + "\n");
				log.debug(flatFile.toString());
				log.debug("\n========================================");

				//QueueNm
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
				BookingUtil command = new BookingUtil();

				FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
				flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

				//EDI ERROR
				if ( flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205").getMessage());

				dbDao.modifyJapDorStsByTrans(japDorEdiTrans);

				dbDao.addJapDorHistoryByTrans(japDorEdiTrans);

				ibEdiSndLog = new BkgIbEdiSndLogVO();

				ibEdiSndLog.setFltFileRefNo("DOR");
				ibEdiSndLog.setDoEdiTpCd("JDF");  //  JDF  : JAPAN D/O DOR I/F
				ibEdiSndLog.setMsgTpId("JPNCUS");
				ibEdiSndLog.setMsgTpNm("MANIFEST");
				ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());


				ibEdiSndLog.setEdiEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
				ibEdiSndLog.setEdiEvntUsrId(japDorEdiTrans.getCreUsrId());
				ibEdiSndLog.setCreUsrId(japDorEdiTrans.getCreUsrId());
				ibEdiSndLog.setUpdUsrId(japDorEdiTrans.getCreUsrId());

				dbDao.addIbEdiSndLogByJapDor(ibEdiSndLog,grpNo);

			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * cancel Japan Dor I/F
	 *
	 * @param JapDorEdiTransVO japDorEdiTrans
	 * @exception EventException
	 */
	public void transmitEdiByJapDorCancel(JapDorEdiTransVO japDorEdiTrans) throws EventException {
		BkgIbEdiSndLogVO ibEdiSndLog = null;
		try {

			dbDao.modifyJapDorStsByReqest(japDorEdiTrans);

			String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
			japDorEdiTrans.setRefNumber(referenceNumber);

			String header   = dbDao.searchEdiSeanaccsHeader(japDorEdiTrans);
			String common   = dbDao.searchEdiSeanaccsCommonByCancel(japDorEdiTrans);
			String eventCd  = dbDao.searchEdiSeanaccsEventType(japDorEdiTrans.getEvntCd());
			String[] blInfo = dbDao.searchEdiSeanaccsBlInfoByCancel(japDorEdiTrans);

			StringBuffer blInfo_tmp = new StringBuffer();

			for(int idx =0; idx <blInfo.length; idx++){
			   blInfo_tmp.append(blInfo[idx]);
			}

			/*
			 * EDI
			 */
			StringBuffer flatFile = new StringBuffer();

			flatFile.append(header);
			flatFile.append(common);
			flatFile.append(eventCd);
			flatFile.append(blInfo_tmp.toString());

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());

			//QueueNm
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NACCS.IBMMQ.QUEUE"));
			BookingUtil command = new BookingUtil();

			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			//EDI ERROR
			if ( flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205").getMessage());

			dbDao.removeDoDtlByCancel(japDorEdiTrans.getBkgNo(), japDorEdiTrans.getRlseSeq(),"'D','C'");

			dbDao.modifyJapDorCancel(japDorEdiTrans);

			//History
			japDorEdiTrans.setDoCngEvntCd("DC"); //Dor Cancel
			japDorEdiTrans.setPreCtnt(japDorEdiTrans.getDoNo());
			japDorEdiTrans.setCrntCtnt("NO");

			dbDao.addJapDorHistoryByRequest(japDorEdiTrans);

			ibEdiSndLog = new BkgIbEdiSndLogVO();

			ibEdiSndLog.setBkgNo(japDorEdiTrans.getBkgNo());
			ibEdiSndLog.setFltFileRefNo("DOR");
			ibEdiSndLog.setDoEdiTpCd("JDC");  //  JDC : JAPAN D/O DOR Cancel
			ibEdiSndLog.setMsgTpId("JPNCUS");
			ibEdiSndLog.setMsgTpNm("MANIFEST");
			ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
			ibEdiSndLog.setEdiEvntOfcCd(japDorEdiTrans.getEvntOfcCd());
			ibEdiSndLog.setEdiEvntUsrId(japDorEdiTrans.getCreUsrId());
			ibEdiSndLog.setCreUsrId(japDorEdiTrans.getCreUsrId());
			ibEdiSndLog.setUpdUsrId(japDorEdiTrans.getCreUsrId());

			dbDao.addIbEdiSndLog(ibEdiSndLog);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * update Japan Do Id<br>
	 *
	 * @param JapDorStatusVO japDorStatus
	 * @exception EventException
	 * @author
	 */
	public void modifyJapDoId(JapDorStatusVO japDorStatus)throws EventException {
		try {
			dbDao.modifyJapDoId(japDorStatus);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * [0909] retrieving Inbound Cargo Release List
	 *
	 * @param UsCgoRlseSearchVO searchvo
	 * @return List<UsCgoRlseListVO>
	 * @exception EventException
	 */
	public List<UsCgoRlseListVO> searchUsCgoRlseList(UsCgoRlseSearchVO searchvo) throws EventException {
		List<UsCgoRlseListVO> listVO = null;

		try {
			listVO = dbDao.searchUsCgoRlseList(searchvo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240")
					.getMessage(), ex);
		}
		return listVO;
	}

	/**
	 * [0909] retrieving B/L cntr No.
	 *
	 * @param String bkgNo
	 * @return List<BkgContainerVO>
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchUsCgoRlseFoc(String bkgNo) throws EventException {
		List<BkgContainerVO> listVO = null;

		try {
			listVO = dbDao.searchUsCgoRlseFoc(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return listVO;
	}

	/**
	 * [0909] save btn event
	 *
	 * @param BkgCgoRlseVO bkgCgoRlseVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageUsCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException {

		try {
			/***************************
			 * 1. BKG_CGO_RLSE UPDATE.
			 ****************************/
			if (bkgCgoRlseVo != null) {

			   int modRowsByMaster = dbDao.modifyUsCgoRlseEdi(bkgCgoRlseVo, account);

			   if (modRowsByMaster > 0) {// SUCCESS
				   dbDao.addUsCgoRlseHisEdi(bkgCgoRlseVo, account);
			   }

			//[31548] [BKG IND] Change management 2015.03
			   WorkOrderIssueBC workOrderIssueBC = new WorkOrderIssueBCImpl();

			   TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();


				trsChgMgmtBkgVO.setCateSepCd("CRUS");
				trsChgMgmtBkgVO.setChageFlg("Y");
				trsChgMgmtBkgVO.setBkNo(bkgCgoRlseVo.getBlNo());
				trsChgMgmtBkgVO.setBndCd("I");
				trsChgMgmtBkgVO.setRtnPrdFlg("");
				trsChgMgmtBkgVO.setTroSeq("0");
				trsChgMgmtBkgVO.setTroSubSeq("0");
				trsChgMgmtBkgVO.setSpclSeq("0");
				trsChgMgmtBkgVO.setVslSeq("0");
				trsChgMgmtBkgVO.setDeltFlg("N");
				trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
				trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());

			try{
					log.debug(" ###### interfaceToTrs ==>CRUS:"+bkgCgoRlseVo.getBlNo());
					workOrderIssueBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
				}catch(Exception e1){
					log.error("[end:: CargoReleaseOrderBC == manageUsCgoRlse workorderissueBC.insertTrsChgMgmtBkgPrc update ]==========");
				}
			//[31548] end

			/***************************
			* 2.EDI
			****************************/
			// check
			if( !"X".equals(dbDao.checkCstmsEvnt(bkgCgoRlseVo.getBlNo()))){
				new USCargoReleaseOrder().bkbcUsCgoEdi(bkgCgoRlseVo.getBlNo(),"N", account);    //2번째 파라미터 N은 멀티 전송이 아닌것
			} else {
				log.debug("------------------ backendjob is not executed!!!!");
			}
			}
		} catch (EventException ex) {
			if(ex.getMessage().indexOf("BKG40085") > -1  ){
				log.debug("");
			}else{
				log.error("err " + ex.toString(), ex);
			}
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0909 : Multi TDC315 - Complete IVC click [Back End Job 시작]<br>
	 * transmit Customer information Flat File as EDI
	 * 
	 * @param BkgCgoRlseVO[] bkgCgoRlseVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobSendBlTdc315EdiMulti(BkgCgoRlseVO[] bkgCgoRlseVOs, SignOnUserAccount account) throws EventException {
		UsCgoRlseBackEndJob usCgoRlseBackEndJob = new UsCgoRlseBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			usCgoRlseBackEndJob.setAccount(account);
			usCgoRlseBackEndJob.setMultiSnd("Y");
			usCgoRlseBackEndJob.setBkgCgoRlseVOs(bkgCgoRlseVOs);
			return backEndJobManager.execute(usCgoRlseBackEndJob, account.getUsr_id(), "ESM_BKG_0909 - Multi TDC315");
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0909 : Multi TDC315 - Complete IVC click [Back End Job 결과]<br>
	 * transmit Customer information Flat File as EDI
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobSendBlTdc315EdiMulti(String backEndJobKey) throws EventException {
		try {
			return (String)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [0909] handling Hold
	 *
	 * @param DoRefVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	public void manageUsCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException {

		try {
			String blNo = "";
			DoRefVO vo = new DoRefVO();


			//D/O HISTORY Create
			BkgDoHisVO doHis = new BkgDoHisVO();
			log.debug("------------vo.getDoHldFlg() "+vo.getDoHldFlg());

			for (int i = 0; i < vos.length; i++) {
				vo = vos[i];
				int modRowsByMaster = dbDao.modifyHoldFlgDoRef(vo, account);
				if (modRowsByMaster == 0) {
					dbDao.addHoldFlgDoRef(vo, account);
				}
				blNo = vo.getBlNo();

				log.debug("------------D/O HISTORY Create11");
				log.debug("------------ vo "+vo.getColumnValues());
				doHis.setCreUsrId(account.getUsr_id());
				doHis.setUpdUsrId(account.getUsr_id());
				if(vo.getDoHldFlg().equals("Y")){
					doHis.setDoCngEvntCd("HC");
				}else if(vo.getDoHldFlg().equals("N")){
					doHis.setDoCngEvntCd("CH");
				}
				doHis.setPreCtnt("NO");
				doHis.setCrntCtnt("YES");
				doHis.setEvntUsrId(account.getUsr_id());
				doHis.setEvntOfcCd(account.getOfc_cd());
				doHis.setBkgNo(vo.getBkgNo());
				dbDao.addDoHistory(doHis);

				//[31548] [BKG IND] Change management 2015.03
				WorkOrderIssueBC workOrderIssueBC = new WorkOrderIssueBCImpl();
				TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();
				trsChgMgmtBkgVO.setCateSepCd("CRUS");
				trsChgMgmtBkgVO.setChageFlg("Y");
				trsChgMgmtBkgVO.setBkNo(blNo);
				trsChgMgmtBkgVO.setBndCd("I");
				trsChgMgmtBkgVO.setRtnPrdFlg("");
				trsChgMgmtBkgVO.setTroSeq("0");
				trsChgMgmtBkgVO.setTroSubSeq("0");
				trsChgMgmtBkgVO.setSpclSeq("0");
				trsChgMgmtBkgVO.setVslSeq("0");
				trsChgMgmtBkgVO.setDeltFlg("N");
				trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
				trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());

			 try{
				log.debug(" ###### interfaceToTrs ==>CRUS:"+blNo);
					workOrderIssueBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
				}catch(Exception e1){
					log.error("[end:: CargoReleaseOrderBC == manageUsCgoRlse workorderissueBC.insertTrsChgMgmtBkgPrc update ]==========");
				}
			   //[31548] end



				// Hold Removal 일 경우 UsCgoRlseBackEndJob 실행
				try{
					if("N".equals(vo.getDoHldFlg())){
						new USCargoReleaseOrder().bkbcUsCgoEdi(vo.getBlNo(),"N", account);    //2번째 파라미터 N은 멀티 전송이 아닌것
					}
				} catch(EventException ex) {

					if(ex.getMessage().indexOf("BKG40085") > -1 || ex.getMessage().indexOf("BKG40086") > -1 || ex.getMessage().indexOf("BKG40087") > -1 || ex.getMessage().indexOf("BKG40108") > -1){
						break;
					}else{
						throw ex;
					}
				}

				break;

			}

			List<DoRefVO> blList = dbDao.searchHoldFlgPrtBl(blNo);
			for (int j = 0; j < blList.size(); j++) {
				vo.setBlNo(blList.get(j).getBlNo());
				BookingUtilDBDAO buDao = new BookingUtilDBDAO();
				vo.setBkgNo(buDao.searchBkgNoByBlNo(vo.getBlNo()));
				log.debug("--------------- 여러개 Hold " + j + " vo.getBlNo() "  + vo.getBlNo());
				log.debug("--------------- 여러개 Hold " + j + " vo.getBkgNo() " + vo.getBkgNo());
				int modRowsByMaster = dbDao.modifyHoldFlgDoRef(vo, account);
				if (modRowsByMaster == 0) {
					dbDao.addHoldFlgDoRef(vo, account);
				}
				//History
				doHis.setBkgNo(vo.getBkgNo());
				dbDao.addDoHistory(doHis);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * [0909] handling Cargo Release
	 * @param CstmsClrVO cstmsClr
	 * @exception Exception
	 */
	public void setupFocByCstms(CstmsClrVO cstmsClr) throws Exception {

		dbDao.receiveOtsLog("BKG_US_CGO_AMS", cstmsClr.getBlNo(), "21.Call Cstms");

		try {
			 log.debug("--------------------- setupFocByCstms method 실행 ");
			 CstmsClrVO retVO = dbDao.searchBkbcCstms(cstmsClr);
			 String orgBlNo = cstmsClr.getBlNo();

			 if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {// US경우만

				if (Integer.parseInt(retVO.getCstmsChkCnt()) == 0) {
					dbDao.addBkbcCstmsUsCgoRlse(cstmsClr);
				} else if (Integer.parseInt(retVO.getCstmsChkCnt()) > 0) {
					dbDao.modifyBkbcCstmsUsCgo(cstmsClr);
				}

				dbDao.addBkbcCstmsUsCgoRlseHis(cstmsClr);


				SignOnUserAccount account = new SignOnUserAccount(cstmsClr
						.getEvntUsrId(), "2", "3", "4", "5", "6", "7", "8",
						"9", "10", "11", "12", cstmsClr.getEvntOfcCd(), "14",
						"15", "16", "17", "18", "19", "20", "21", "22");
				log.debug("~~~~~~~~~~    account.getUsr_id()    "
						+ account.getUsr_id());
				log.debug("~~~~~~~~~~    account.getOfc_cd()    "
						+ account.getOfc_cd());

				log.debug("-------- 관련 bl 을 구하여 처리한다.");

				//[31548] [BKG IND] Change management 2015.03
				WorkOrderIssueBC workOrderIssueBC = new WorkOrderIssueBCImpl();

				TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();


				trsChgMgmtBkgVO.setCateSepCd("CRUS");
				trsChgMgmtBkgVO.setChageFlg("Y");
				trsChgMgmtBkgVO.setBkNo(orgBlNo);
				trsChgMgmtBkgVO.setBndCd("I");
				trsChgMgmtBkgVO.setRtnPrdFlg("");
				trsChgMgmtBkgVO.setTroSeq("0");
				trsChgMgmtBkgVO.setTroSubSeq("0");
				trsChgMgmtBkgVO.setSpclSeq("0");
				trsChgMgmtBkgVO.setVslSeq("0");
				trsChgMgmtBkgVO.setDeltFlg("N");
				trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
				trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());

			 try{
					log.debug(" ###### interfaceToTrs ==>CRUS:"+orgBlNo);
					workOrderIssueBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
				}catch(Exception e1){
					log.error("[end:: CargoReleaseOrderBC == manageUsCgoRlse workorderissueBC.insertTrsChgMgmtBkgPrc update ]==========");
				}
			  //[31548] end


			 try{
				if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
					dbDao.receiveOtsLog("BKG_US_CGO_AMS", cstmsClr.getBlNo(), "22.Call CSMTS USCargoRelease");
					new USCargoReleaseOrder().bkbcUsCgoEdi(orgBlNo,"N", account);    //2번째 파라미터 N은 멀티 전송이 아닌것
				}
			 }catch(Exception e1){
				log.error("[end:: CargoReleaseOrderBC == manageUsCgoRlse UsCgoRlseBackEndJob CUSTOMS ]==========");
			}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		} catch (Exception ex) {
			if(ex.getMessage().indexOf("BKG40085") > -1  ){
				log.debug("");
			}else{
				log.error("err " + ex.toString(), ex);
			}
			throw ex;
		}
	}

	/**
	 * [0909]handling Cargo Release
	 *
	 * @param FrtCltLstVO frtCltLst
	 * @exception Exception
	 */
	public void setupFocByFreight(FrtCltLstVO frtCltLst) throws Exception {

		try {
			 log.debug("--------------------- setupFocByFreight method 실행 ");
			 FrtCltLstVO retVO = dbDao.searchBkbcFrt(frtCltLst);
			 String orgBlNo = frtCltLst.getBlNo();
			 dbDao.receiveOtsLog("BKG_US_CGO_SWB", frtCltLst.getBlNo(), "23_0.Freight USCA doStart");
			if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {

				// 실행
				if (Integer.parseInt(retVO.getFrtChkCnt()) == 0) {
					dbDao.addBkbcFrtUsCgoRlse(frtCltLst);
				} else if (Integer.parseInt(retVO.getFrtChkCnt()) > 0) {
					dbDao.modifyBkbcFrtUsCgo(frtCltLst);
				}

				dbDao.addBkbcFrtUsCgoRlseHis(frtCltLst);
				// retVO = dbDao.searchBkbcMaxHisSeq(frtCltLst);

				SignOnUserAccount account = new SignOnUserAccount(frtCltLst
						.getEvntUsrId(), "2", "3", "4", "5", "6", "7", "8",
						"9", "10", "11", "12", frtCltLst.getEvntOfcCd(), "14",
						"15", "16", "17", "18", "19", "20", "21", "22");
				log.debug("~~~~~~~~~~    account.getUsr_id()    "+ account.getUsr_id());
				log.debug("~~~~~~~~~~    account.getOfc_cd()    "+ account.getOfc_cd());

				//[31548] [BKG IND] Change management 2015.03
				WorkOrderIssueBC workOrderIssueBC = new WorkOrderIssueBCImpl();

				TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();


				trsChgMgmtBkgVO.setCateSepCd("CRUS");
				trsChgMgmtBkgVO.setChageFlg("Y");
				trsChgMgmtBkgVO.setBkNo(orgBlNo);
				trsChgMgmtBkgVO.setBndCd("I");
				trsChgMgmtBkgVO.setRtnPrdFlg("");
				trsChgMgmtBkgVO.setTroSeq("0");
				trsChgMgmtBkgVO.setTroSubSeq("0");
				trsChgMgmtBkgVO.setSpclSeq("0");
				trsChgMgmtBkgVO.setVslSeq("0");
				trsChgMgmtBkgVO.setDeltFlg("N");
				trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
				trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());

			 try{
				log.debug(" ###### interfaceToTrs ==>CRUS:"+orgBlNo);
					workOrderIssueBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
				}catch(Exception e1){
					log.error("[end:: CargoReleaseOrderBC == manageUsCgoRlse workorderissueBC.insertTrsChgMgmtBkgPrc update ]==========");
				}
			  //[31548] end

				log.debug("-------- 관련 bl 을 구하여 처리한다.");
				if(retVO.getCntCd()!=null && retVO.getCaChk().equals("CA")){
					dbDao.receiveOtsLog("BKG_US_CGO_SWB", frtCltLst.getBlNo(), "23.Freight CA doStart");
					frtCltLst.setCngIndFlg("N"); //이미 배치가 돈 대상들은 N으로 flag를 찍어 다음 배치가 돌  때 대상으로 잡지 않도록 한다.
					dbDao.modifyCngIndFlg(frtCltLst);
					new CACargoReleaseOrder().caCgoRlse(orgBlNo, "N", account);  //2번째 파라미터 N은 멀티 전송이 아닌것
				}
				else if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
					if( !"X".equals(dbDao.checkCstmsEvnt(orgBlNo))){
						dbDao.receiveOtsLog("BKG_US_CGO_SWB", frtCltLst.getBlNo(), "23.Freight US doStart");
						frtCltLst.setCngIndFlg("N"); //이미 배치가 돈 대상들은 N으로 flag를 찍어 다음 배치가 돌  때 대상으로 잡지 않도록 한다.
						dbDao.modifyCngIndFlg(frtCltLst);
						new USCargoReleaseOrder().bkbcUsCgoEdi(orgBlNo,"N", account);    //2번째 파라미터 N은 멀티 전송이 아닌것
					}
				}

			}
		} catch(NullPointerException se){
		 log.error("setupFocByFreight null err " + se.toString(), se);
		 throw se;
		} catch (DAOException de) {
		   log.error("setupFocByFreight DAO err " + de.toString(), de);
		   throw de;
		}	catch (Exception ex) {
		   if(ex.getMessage().indexOf("BKG40085") > -1  ){
			log.debug("");
		   }else{
			   log.error("setupFocByFreight Except err " + ex.toString(), ex);
		   }
		   throw ex;
	   }
   }

	/**
	 * [0909] handling Cargo Release
	 *
	 * @param OblRdemVO oblRdem
	 * @exception Exception
	 */
	public void setupFocByObl(OblRdemVO oblRdem) throws Exception {

			try {

				if(oblRdem != null){
					dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "24_0.US Obl doStart CgoTeamCd: " + oblRdem.getCgorTeamCd());
				if(!oblRdem.getCgorTeamCd().equals("C") && !oblRdem.getCgorTeamCd().equals("B")){
					log.debug("--------------------- setupFocByObl method 실행 ");
					OblRdemVO retVO = dbDao.searchBkbcObl(oblRdem);
					String orgBlNo = oblRdem.getBlNo();
					dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "24_1.US Obl_getCgorTeamCd: " + oblRdem.getCgorTeamCd() + " /retVO.getUsChk() " + retVO.getUsChk() + " /oblRdem.getOblRdemFlg()" + oblRdem.getOblRdemFlg());
					
					if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {// US경우만

							// Model No. 8
							FrtCltLstVO cltLstVO = new FrtCltLstVO();

							cltLstVO.setBlNo(oblRdem.getBlNo());
							cltLstVO.setEvntOfcCd(oblRdem.getEvntOfcCd());
							cltLstVO.setEvntDt(oblRdem.getEvntDt());
							cltLstVO.setEvntUsrId(oblRdem.getEvntUsrId());
							cltLstVO.setCgorTeamCd(oblRdem.getCgorTeamCd());
							cltLstVO.setCgoEvntNm(oblRdem.getCgoEvntNm());

							if(oblRdem.getCgorTeamCd().equals("S") ){
								cltLstVO.setOblRdemFlg(oblRdem.getOblRdemFlg());
							}else {
								cltLstVO.setOblRdemFlg(retVO.getOblRdemFlg());
							}

							if (Integer.parseInt(retVO.getOblChkCnt()) == 0) {
								dbDao.addBkbcOblUsCgoRlse(cltLstVO);
							} else if (Integer.parseInt(retVO.getOblChkCnt()) > 0) {
								dbDao.modifyBkbcOblUsCgo(cltLstVO);
							}

							// Model No. 7
							dbDao.addBkbcOblUsCgoRlseHis(cltLstVO);

							SignOnUserAccount account = new SignOnUserAccount(oblRdem.getEvntUsrId()
									, "2", "3", "4", "5", "6", "7", "8",
									"9", "10", "11", "12", oblRdem.getEvntOfcCd(), "14",
									"15", "16", "17", "18", "19", "20", "21", "22");
							log.debug("~~~~~~~~~~    account.getUsr_id()    "+ account.getUsr_id());
							log.debug("~~~~~~~~~~    account.getOfc_cd()    "+ account.getOfc_cd());

							log.debug("-------- 관련 bl 을 구하여 처리한다.");

							//[31548] [BKG IND] Change management 2015.03
							WorkOrderIssueBC workOrderIssueBC = new WorkOrderIssueBCImpl();

							TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();


							trsChgMgmtBkgVO.setCateSepCd("CRUS");
							trsChgMgmtBkgVO.setChageFlg("Y");
							trsChgMgmtBkgVO.setBkNo(orgBlNo);
							trsChgMgmtBkgVO.setBndCd("I");
							trsChgMgmtBkgVO.setRtnPrdFlg("");
							trsChgMgmtBkgVO.setTroSeq("0");
							trsChgMgmtBkgVO.setTroSubSeq("0");
							trsChgMgmtBkgVO.setSpclSeq("0");
							trsChgMgmtBkgVO.setVslSeq("0");
							trsChgMgmtBkgVO.setDeltFlg("N");
							trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
							trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());

						 try{
							log.debug(" ###### interfaceToTrs ==>CRUS:"+ orgBlNo);
								workOrderIssueBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
							}catch(Exception e1){
								log.error("[end:: CargoReleaseOrderBC == manageUsCgoRlse workorderissueBC.insertTrsChgMgmtBkgPrc update ]==========");
							}
						  //[31548] end

							if(retVO.getCntCd()!= null && retVO.getCaChk().equals("CA")){
								dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "24_2.CA Obl doStart");
								new CACargoReleaseOrder().caCgoRlse(orgBlNo, "N", account);
							}else if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
								dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "24_2.US Obl doStart");
								new USCargoReleaseOrder().bkbcUsCgoEdi(orgBlNo, "N", account);    //2번째 파라미터 N은 멀티 전송이 아닌것
							}

					 }else{


							retVO = dbDao.searchBkbCacObl(oblRdem);
							orgBlNo = oblRdem.getBlNo();

							 // CA 경우

							dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "31.CA CHECK cntCd:"+retVO.getCntCd()+",fobCaChk:"+retVO.getFobCaChk()+", podCaChk:"+retVO.getPodCaChk());

							if ( retVO.getFobCaChk() != null && retVO.getFobCaChk().equals("Y")
									&& retVO.getCntCd()!=null && retVO.getCntCd().equals("CA")
									&& retVO.getPodCaChk()!=null && retVO.getPodCaChk().equals("CA") ){

								FrtCltLstVO cltLstVO = new FrtCltLstVO();

								cltLstVO.setBlNo(oblRdem.getBlNo());
								cltLstVO.setEvntOfcCd(oblRdem.getEvntOfcCd());
								cltLstVO.setEvntDt(oblRdem.getEvntDt());
								cltLstVO.setEvntUsrId(oblRdem.getEvntUsrId());
								cltLstVO.setCgorTeamCd(oblRdem.getCgorTeamCd());
								cltLstVO.setCgoEvntNm(oblRdem.getCgoEvntNm());

								if(oblRdem.getCgorTeamCd().equals("S") ){
									cltLstVO.setOblRdemFlg(oblRdem.getOblRdemFlg());
								}else {
									cltLstVO.setOblRdemFlg(retVO.getOblRdemFlg());
								}

								// 실행
								if (Integer.parseInt(retVO.getOblChkCnt()) == 0) {
									dbDao.addBkbcOblUsCgoRlse(cltLstVO);
								} else if (Integer.parseInt(retVO.getOblChkCnt()) > 0) {
									dbDao.modifyBkbcOblUsCgo(cltLstVO);
								}

								// Model No. 7
								dbDao.addBkbcOblUsCgoRlseHis(cltLstVO);

								SignOnUserAccount account = new SignOnUserAccount(oblRdem.getEvntUsrId()
										, "2", "3", "4", "5", "6", "7", "8",
										"9", "10", "11", "12", oblRdem.getEvntOfcCd(), "14",
										"15", "16", "17", "18", "19", "20", "21", "22");

								dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "32.CA Obl doStart");
								new CACargoReleaseOrder().caCgoRlse(orgBlNo, "N", account);
							}

					 }
				 }
				}
			} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw de;
			} catch (Exception ex) {
				if(ex.getMessage().indexOf("BKG40085") > -1  ){
					log.debug("");
				}else{
					log.error("setupFocByObl Exception err" + ex.toString(), ex);
				}
				throw ex;
			}
	}

	/**
	 * [0909] handling Cargo Release
	 * @param OblRdemVO[] oblRdems
	 * @throws Exception
	 */
	public void setupFocByOblAutoBdr(OblRdemVO[] oblRdems) throws Exception {

			try {
				   for(int i=0;i<oblRdems.length;i++){
					   OblRdemVO oblRdem = oblRdems[i];

					   OblRdemVO retVO = dbDao.searchBkbcObl(oblRdem);
					   String orgBlNo = oblRdem.getBlNo();

						if (retVO.getUsChk() != null && retVO.getUsChk().equals("Y")) {

							// Model No. 8
							FrtCltLstVO cltLstVO = new FrtCltLstVO();

							cltLstVO.setBlNo(oblRdem.getBlNo());
							cltLstVO.setEvntOfcCd(oblRdem.getEvntOfcCd());
							cltLstVO.setEvntDt(oblRdem.getEvntDt());
							cltLstVO.setEvntUsrId(oblRdem.getEvntUsrId());
							cltLstVO.setCgorTeamCd(oblRdem.getCgorTeamCd());
							cltLstVO.setCgoEvntNm(oblRdem.getCgoEvntNm());
							cltLstVO.setOblRdemFlg(retVO.getOblRdemFlg());

							if (Integer.parseInt(retVO.getOblChkCnt()) == 0) {
								dbDao.addBkbcOblUsCgoRlse(cltLstVO);
							} else if (Integer.parseInt(retVO.getOblChkCnt()) > 0) {

								dbDao.modifyBkbcOblUsCgo(cltLstVO);
							}

							// Model No. 7
							dbDao.addBkbcOblUsCgoRlseHis(cltLstVO);

							SignOnUserAccount account = new SignOnUserAccount(oblRdem.getEvntUsrId()
									, "2", "3", "4", "5", "6", "7", "8",
									"9", "10", "11", "12", oblRdem.getEvntOfcCd(), "14",
									"15", "16", "17", "18", "19", "20", "21", "22");
							log.debug("~~~~~~~~~~    account.getUsr_id()    "+ account.getUsr_id());
							log.debug("~~~~~~~~~~    account.getOfc_cd()    "+ account.getOfc_cd());

							log.debug("-------- 관련 bl 을 구하여 처리한다.");

							//[31548] [BKG IND] Change management 2015.03
							WorkOrderIssueBC workOrderIssueBC = new WorkOrderIssueBCImpl();

							TrsChgMgmtBkgVO trsChgMgmtBkgVO = new TrsChgMgmtBkgVO();


							trsChgMgmtBkgVO.setCateSepCd("CRUS");
							trsChgMgmtBkgVO.setChageFlg("Y");
							trsChgMgmtBkgVO.setBkNo(orgBlNo);
							trsChgMgmtBkgVO.setBndCd("I");
							trsChgMgmtBkgVO.setRtnPrdFlg("");
							trsChgMgmtBkgVO.setTroSeq("0");
							trsChgMgmtBkgVO.setTroSubSeq("0");
							trsChgMgmtBkgVO.setSpclSeq("0");
							trsChgMgmtBkgVO.setVslSeq("0");
							trsChgMgmtBkgVO.setDeltFlg("N");
							trsChgMgmtBkgVO.setUsrId(account.getUsr_id());
							trsChgMgmtBkgVO.setUsrOffCd(account.getOfc_cd());

						 try{
							log.debug(" ###### interfaceToTrs ==>CRUS:"+orgBlNo);
								workOrderIssueBC.insertTrsChgMgmtBkgPrc(trsChgMgmtBkgVO);
							}catch(Exception e1){
								log.error("[end:: CargoReleaseOrderBC == manageUsCgoRlse workorderissueBC.insertTrsChgMgmtBkgPrc update ]==========");
							}
						  //[31548] end

							if(retVO.getCntCd()!=null && retVO.getCntCd().equals("US") ){
								new USCargoReleaseOrder().bkbcUsCgoEdi(orgBlNo,"N", account);    //2번째 파라미터 N은 멀티 전송이 아닌것
							}

						} else{

							retVO = dbDao.searchBkbCacObl(oblRdem);
							orgBlNo = oblRdem.getBlNo();

							 // CA 경우

							dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "31.CA CHECK cntCd:"+retVO.getCntCd()+",fobCaChk:"+retVO.getFobCaChk()+", podCaChk:"+retVO.getPodCaChk());

							if ( retVO.getFobCaChk() != null && retVO.getFobCaChk().equals("Y")
									&& retVO.getCntCd()!=null && retVO.getCntCd().equals("CA")
									&& retVO.getPodCaChk()!=null && retVO.getPodCaChk().equals("CA") ){

								FrtCltLstVO cltLstVO = new FrtCltLstVO();

								cltLstVO.setBlNo(oblRdem.getBlNo());
								cltLstVO.setEvntOfcCd(oblRdem.getEvntOfcCd());
								cltLstVO.setEvntDt(oblRdem.getEvntDt());
								cltLstVO.setEvntUsrId(oblRdem.getEvntUsrId());
								cltLstVO.setCgorTeamCd(oblRdem.getCgorTeamCd());
								cltLstVO.setCgoEvntNm(oblRdem.getCgoEvntNm());

								if(oblRdem.getCgorTeamCd().equals("S") ){
									cltLstVO.setOblRdemFlg(oblRdem.getOblRdemFlg());
								}else {
									cltLstVO.setOblRdemFlg(retVO.getOblRdemFlg());
								}

								// 실행
								if (Integer.parseInt(retVO.getOblChkCnt()) == 0) {
									dbDao.addBkbcOblUsCgoRlse(cltLstVO);
								} else if (Integer.parseInt(retVO.getOblChkCnt()) > 0) {
									dbDao.modifyBkbcOblUsCgo(cltLstVO);
								}

								// Model No. 7
								dbDao.addBkbcOblUsCgoRlseHis(cltLstVO);

								SignOnUserAccount account = new SignOnUserAccount(oblRdem.getEvntUsrId()
										, "2", "3", "4", "5", "6", "7", "8",
										"9", "10", "11", "12", oblRdem.getEvntOfcCd(), "14",
										"15", "16", "17", "18", "19", "20", "21", "22");

								dbDao.receiveOtsLog("BKG_US_CGO_SWB", oblRdem.getBlNo(), "32.CA Obl doStart");
								new CACargoReleaseOrder().caCgoRlse(orgBlNo, "N", account);
							}
						 }
				   }
			} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw de;
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw ex;
			}
	}

	/**
	 * [0909] ERP I / F EAIDAO calls for
	 *
	 * @param String blNo
	 * @return OtsRcvInfoVO
	 * @exception EventException
	 */
	public OtsRcvInfoVO searchErpOtsInfo(String blNo) throws EventException {
		OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
		try {
			log.debug("ERP I/F를 위한 EAIDAO 호출");
//            otsRcvInfoVO = eaiDbDao.searchOtsInfo(blNo);
			otsRcvInfoVO = dbDao.searchOtsInfo(blNo);
			//otsRcvInfoVO.setTotOtsCurrCd1("XXX");
			//otsRcvInfoVO.setTotOtsAmt1("10000");
			log.debug("------------------- otsRcvInfoVO " + otsRcvInfoVO.getColumnValues());
			//if(otsRcvInfoVO.getTotOtsCurrCd1() == null || otsRcvInfoVO.getTotOtsCurrCd1().trim().equals("")){
			if(otsRcvInfoVO.getTotOtsAmt1() == null
					|| otsRcvInfoVO.getTotOtsAmt1().trim().equals("")
					|| otsRcvInfoVO.getTotOtsStsCd() == null
					|| otsRcvInfoVO.getTotOtsStsCd().trim().equals("")
					){
				otsRcvInfoVO.setTotOtsStsCd("");
				otsRcvInfoVO.setTotOtsAmt1("N/A");
			}
		} catch (DAOException de) {
			otsRcvInfoVO.setTotOtsStsCd("");
			otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
			log.error("ERP I/F Error");
		} catch (Exception ex) {
			otsRcvInfoVO.setTotOtsStsCd("");
			otsRcvInfoVO.setTotOtsAmt1("ERP I/F Error");
			log.error("ERP I/F Error");
		}
		return otsRcvInfoVO;
	}

	/**
	 * retrieving cntr by bkg_no
	 *
	 * @param String bkgNo
	 * @return String[] Container No List
	 * @exception EventException
	 */
	public String[] searchDemDetCntrList(String bkgNo) throws EventException {
		String[] arrRet;
		try {
			arrRet = dbDao.searchDemDetCntrList(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return arrRet;
	}
	/**
	 * [0909] Original Bill of Lading Status
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return List<UsCgoRlseBlStatusVO>
	 * @throws EventException
	 */
	public List<UsCgoRlseBlStatusVO>  searchUsCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException{
		List<UsCgoRlseBlStatusVO> usCgoRlseBlStatus = null;

		try {
			usCgoRlseBlStatus = (List<UsCgoRlseBlStatusVO>) dbDao.searchUsCgoRlseBlStatus(bkgNo, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return usCgoRlseBlStatus;
	}

	/**
	 * [0909] Partial
	 *
	 * @param UsCgoRlseBkbcBlVO usCgoRlseBkbc
	 * @return UsCgoRlseBkbcBlVO
	 * @exception EventException
	 */
	public UsCgoRlseBkbcBlVO searchPrtlBl(UsCgoRlseBkbcBlVO usCgoRlseBkbc) throws EventException {

		UsCgoRlseBkbcBlVO uscgoRlseBkbcBL = new UsCgoRlseBkbcBlVO();

		try {
			uscgoRlseBkbcBL = (UsCgoRlseBkbcBlVO) dbDao.searchPrtlBl(usCgoRlseBkbc);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return uscgoRlseBkbcBL;
	}



	/**
	 * Information storage handling Dubai Customs<br>
	 *
	 * @param DubaiCstmsVO[] dubaiCstms
	 * @exception EventException
	 */

	public void modifyDubaiCstmsRefNo(DubaiCstmsVO[] dubaiCstms ) throws EventException {
		try {
			for(int i=0;i<dubaiCstms.length;i++){
				dbDao.modifyDubaiCstmsRefNo(dubaiCstms[i]);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * delete event<br>
	 *
	 * @param String office
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDoForm(String office, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeDoForm(office, account);

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * delete event<br>
	 *
	 * @param EdoRqstsVO[] edoRqstsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeEdoErrData(EdoRqstsVO[] edoRqstsVO, SignOnUserAccount account) throws EventException {
		try {
			List<EdoRqstsVO> updateVoList = new ArrayList<EdoRqstsVO>();

			if(null != edoRqstsVO){
				for ( int i=0; i<edoRqstsVO .length; i++ ) {
					edoRqstsVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(edoRqstsVO[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.removeEdoErrData(updateVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Cargo Release Order<br>
	 *
	 * @param String office
	 * @return List<BkgDoFomVO>
	 * @exception EventException
	 */
	public List<BkgDoFomVO> searchDoForm(String office) throws EventException {
		try {
			log.debug("BCImpl ==> searchDoForm 호출");
			return dbDao.searchDoForm(office);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of K-DO Application info<br>
	 *
	 * @param String rqstNo
	 * @param String tpCd
	 * @return EdoRqstVO edoRqstVO
	 * @exception EventException
	 */
	public EdoRqstVO searchEdoByDoRqst(String rqstNo, String tpCd) throws EventException {
		try {
			EdoRqstVO edoRqstVO = new EdoRqstVO();
			log.debug("===================================");
			log.debug("    기본 Reference 정보  조회      ");
			log.debug("===================================");

			BkgEdoMstVO bkgEdoMstVO = dbDao.searchEdoMst(rqstNo, tpCd);
			edoRqstVO.setBkgEdoMstVO(bkgEdoMstVO);

			if(bkgEdoMstVO != null){
				// BKG_EDO_DO
				log.debug("========================================================");
				log.debug("    BKG_EDO_DO 를 조회한다.                             ");
				log.debug("========================================================");

				BkgEdoDoVO bkgEdoDoVO = dbDao.searchEdoDo(rqstNo, tpCd);
				edoRqstVO.setBkgEdoDoVO(bkgEdoDoVO);

				// BKG_EDO_PTY_TRSP(MS, AS, PR)
				log.debug("=================================================");
				log.debug("    BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)    ");
				log.debug("=================================================");

				List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs = dbDao.searchEdoPtyTrsp(rqstNo, tpCd);
				edoRqstVO.setBkgEdoPtyTrspVOs(bkgEdoPtyTrspVOs);

			}
			return edoRqstVO;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of In-bond Transportation Application info<br>
	 *
	 * @param String rqstNo
	 * @param String tpCd
	 * @return EdoRqstVO edoRqstVO
	 * @exception EventException
	 */
	public EdoRqstVO searchEdoByIbdTrspRqst(String rqstNo, String tpCd) throws EventException {
		try {
			EdoRqstVO edoRqstVO = new EdoRqstVO();
			log.debug("===================================");
			log.debug("    기본 Reference 정보  조회      ");
			log.debug("===================================");

			BkgEdoMstVO bkgEdoMstVO = dbDao.searchEdoMst(rqstNo, tpCd);
			edoRqstVO.setBkgEdoMstVO(bkgEdoMstVO);

			if(bkgEdoMstVO != null){
				log.debug("========================================================");
				log.debug("    BKG_EDO_DO 를 조회한다.                             ");
				log.debug("========================================================");

				BkgEdoIbdTrspVO bkgEdoIbdTrspVO = dbDao.searchEdoIbdTrsp(rqstNo, tpCd);
				edoRqstVO.setBkgEdoIbdTrspVO(bkgEdoIbdTrspVO);

				log.debug("=================================================");
				log.debug("    BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)    ");
				log.debug("=================================================");

				List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs = dbDao.searchEdoPtyTrsp(rqstNo, tpCd);
				edoRqstVO.setBkgEdoPtyTrspVOs(bkgEdoPtyTrspVOs);

			}
			return edoRqstVO;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Merchant Haulage Application info<br>
	 *
	 * @param String rqstNo
	 * @param String tpCd
	 * @return EdoRqstVO edoRqstVO
	 * @exception EventException
	 */
	public EdoRqstVO searchEdoBySelfTrspRqst(String rqstNo, String tpCd) throws EventException {
		try {
			EdoRqstVO edoRqstVO = new EdoRqstVO();
			log.debug("===================================");
			log.debug("    기본 Reference 정보  조회      ");
			log.debug("===================================");

			BkgEdoMstVO bkgEdoMstVO = dbDao.searchEdoMst(rqstNo, tpCd);
			edoRqstVO.setBkgEdoMstVO(bkgEdoMstVO);

			if(bkgEdoMstVO != null){

				log.debug("===============================================================");
				log.debug("    BKG_EDO_SELF_TRSP 를 조회한다.                             ");
				log.debug("===============================================================");

				BkgEdoSelfTrspVO bkgEdoSelfTrspVO = dbDao.searchEdoSelfTrsp(rqstNo, tpCd);
				edoRqstVO.setBkgEdoSelfTrspVO(bkgEdoSelfTrspVO);


				log.debug("=================================================");
				log.debug("    BKG_EDO_PTY_TRSP 를 조회한다.(MS, AS, PR)     ");
				log.debug("=================================================");

				List<BkgEdoPtyTrspVO> bkgEdoPtyTrspVOs = dbDao.searchEdoPtyTrsp(rqstNo, tpCd);
				edoRqstVO.setBkgEdoPtyTrspVOs(bkgEdoPtyTrspVOs);

			}
			return edoRqstVO;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Cargo Release Order_E-D/O inquiry _Main<br>
	 *
	 * @param EdoSearchVO edoSearch
	 * @return List<EdoRqstsVO>
	 * @exception EventException
	 */
	public List<EdoRqstsVO> searchEdoRqstList(EdoSearchVO edoSearch) throws EventException {
		try {
			return dbDao.searchEdoRqstList(edoSearch);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of D/O EDI Transmit Log List Inquiry<br>
	 *
	 * @param String rcvToDt
	 * @param String rcvFmDt
	 * @param String blNo
	 * @return List<BkgEdoLogVO>
	 * @exception EventException
	 */
	public List<BkgEdoLogVO> searchEdoTransLog(String rcvToDt, String rcvFmDt, String blNo) throws EventException {
		try {
			return dbDao.searchEdoTransLog(rcvToDt, rcvFmDt, blNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Cargo Release Order Office Default From Setup<br>
	 *
	 * @param BkgDoFomVO[] bkgDoFomVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupDoForm(BkgDoFomVO[] bkgDoFomVOs, SignOnUserAccount account) throws EventException {
		try {
			int resultCnt =0;
			log.debug("=======================================");
			log.debug("    Office Default From Setup 저장시   ");
			log.debug("=======================================");

			resultCnt = dbDao.modifyDoForm(bkgDoFomVOs, account);

			if ( resultCnt == 0 ) {
				log.debug("=======================================");
				log.debug("    수정된 건수가 없음 신규 Create       ");
				log.debug("=======================================");
				dbDao.addDoForm(bkgDoFomVOs, account);
			}

			log.debug("================================================================================");
			log.debug("    Office Default From Setup Insert 처리를 한다.                               ");
			log.debug("================================================================================");

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of EU_Cargo Release Order의 D/O Receiver Setting<br>
	 *
	 * @param String doNo
	 * @param String doNoSplit
	 * @return EuDoRcvrVO euDoRcvrVO
	 * @exception EventException
	 */
	public EuDoRcvrVO searchEuDoRcvrInfo(String doNo, String doNoSplit) throws EventException {
		try {

			EuDoRcvrVO euDoRcvrVO = new EuDoRcvrVO();

			log.debug("===============================================================");
			log.debug("    Multi Container를 조회한다.                                ");
			log.debug("===============================================================");
			List<DoCntrVO> doCntrVOs = dbDao.searchDoCntrInfo(doNo, doNoSplit);
			euDoRcvrVO.setDoCntrVos(doCntrVOs);

			// BKG_DO 를 조회한다
			log.debug("===============================================================");
			log.debug("    BKG_DO 를 조회한다                                         ");
			log.debug("===============================================================");

			BkgDoVO bkgDoVO = dbDao.searchEuDoRcvrInfo(doNo, doNoSplit);
			euDoRcvrVO.setBkgDoVO(bkgDoVO);

			// BKG_DO 를 조회한다
			log.debug("===============================================================");
			log.debug("    BKG_DO_CNTR을 조회한다                                     ");
			log.debug("===============================================================");

			List<BkgDoCntrVO> bkgDoCntrVOs = dbDao.searchEuDoTruckerInfo(doNo, doNoSplit);
			euDoRcvrVO.setBkgDoCntrVOs(bkgDoCntrVOs);

			return euDoRcvrVO;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of EU_Cargo Release Order의 D/O Receiver Setting <br>
	 *
	 * @param BkgDoVO[] bkgDoVO
	 * @param SignOnUserAccount account
	 * @return EventResponse EsmBkg0937EventResponse
	 * @exception EventException
	 */
	public void setupEuDoRcvrInfo(BkgDoVO[] bkgDoVO, SignOnUserAccount account) throws EventException {
		try {
			int resultCnt =0;
			log.debug("=======================================");
			log.debug("    EU_Cargo Release Order의 D/O Receiver 저장시   ");
			log.debug("=======================================");

			resultCnt = dbDao.modifyEuDoRcvrInfo(bkgDoVO, account);

			if ( resultCnt == 0 ) {
				log.debug("=======================================");
				log.debug("    D/O Receiver 수정된 건수가 없음                ");
				log.debug("=======================================");
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of EU_Cargo Release Order D/O Receiver Setting<br>
	 *
	 * @param BkgDoCntrVO[] bkgDoCntrVOs
	 * @param SignOnUserAccount account
	 * @return EventResponse EsmBkg0937EventResponse
	 * @exception EventException
	 */
	public void setupEuDoTruckerInfo(BkgDoCntrVO[] bkgDoCntrVOs, SignOnUserAccount account) throws EventException {
		try {
			int resultCnt =0;

			log.debug("=======================================");
			log.debug("    EU_Cargo Release Order의 Trucker 저장시   ");
			log.debug("=======================================");

			List<BkgDoCntrVO> updateVoList = new ArrayList<BkgDoCntrVO>();

			if(null != bkgDoCntrVOs){
				for ( int i=0; i<bkgDoCntrVOs.length; i++ ) {
					log.debug("getIbflag : " + bkgDoCntrVOs[i].getIbflag());
					if ( bkgDoCntrVOs[i].getIbflag().equals("U")){
						log.debug("getCntrNo : " + bkgDoCntrVOs[i].getCntrNo());

						bkgDoCntrVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(bkgDoCntrVOs[i]);
					}
				}
			} else {
				log.debug("bkgDoCntrVOs 데이터  Null");
			}

			resultCnt = dbDao.modifyEuDoTruckerInfo(updateVoList, account);

			if ( resultCnt == 0 ) {
				log.debug("=======================================");
				log.debug("    Trucker 수정된 건수가 없음                             ");
				log.debug("=======================================");
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * send mail event<br>
	 *
	 * @param BkgDoVO[] bkgDo
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> bkgNtcHisVOs
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendEuDoByEmail(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException {

		CargoReleaseOrderEAIDAO eai = new CargoReleaseOrderEAIDAO();

		try {
			int resultCnt =0;
			log.debug("===================================================");
			log.debug("    EU_Cargo Release Order의 D/O Receiver 저장시   ");
			log.debug("===================================================");

			resultCnt = dbDao.modifyEuDoRcvrInfo(bkgDo, account);

			if ( resultCnt == 0 ) {
				log.debug("=======================================");
				log.debug("    D/O Receiver 수정된 건수가 없음    ");
				log.debug("=======================================");
			}

			log.debug("=======================================");
			log.debug("    searchDoMrdId 조회 Start           ");
			log.debug("=======================================");
			String bl_no  = dbDao.searchBlNo(bkgDo[0].getBkgNo());
			String mrd_id = dbDao.searchDoMrdId(account.getOfc_cd());

			log.debug("    searchDoMrdId 결과 : " + mrd_id );

			log.debug("=======================================");
			log.debug("    sendEuDoByEmail 메일 전송 Start.   ");
			log.debug("=======================================");

			if ("".equals(mrd_id) || mrd_id.isEmpty()) {

				log.debug("=======================================");
				log.debug("    mrd_id의 값이 존재하지 않음        ");
				log.debug("=======================================");

				throw new EventException(new ErrorHandler("BKG40080").getMessage());
			}
			EuDoNtcSendVO euDoNtcSend = new EuDoNtcSendVO();
			euDoNtcSend.setBkgNo(bkgDo[0].getBkgNo());
			euDoNtcSend.setBlNo(bl_no);
			euDoNtcSend.setDoNo(bkgDo[0].getDoNo());
			euDoNtcSend.setDoNoSplit(bkgDo[0].getDoNoSplit());
			euDoNtcSend.setMrdId(mrd_id);
			euDoNtcSend.setNtcEml(bkgDo[0].getRcvrEml());
			euDoNtcSend.setNtcFaxNo(bkgDo[0].getRcvrFaxNo());
			euDoNtcSend.setUsrEml(account.getUsr_eml());
			euDoNtcSend.setUsrId(account.getUsr_id());
			euDoNtcSend.setUsrNm(account.getUsr_nm());
			euDoNtcSend.setOfcCd(account.getOfc_cd());
			euDoNtcSend.setNtcViaCd("E");
			euDoNtcSend.setCreUsrId(account.getUsr_id());
			euDoNtcSend.setUpdUsrId(account.getUsr_id());
			euDoNtcSend.setCustNm(bkgDo[0].getRcvrCneeNm());

			euDoNtcSend.setSndId(eai.sendEuDoByEmail(euDoNtcSend));

			List<BkgNtcHisVO> bkgNtcHisVOs = dbDao.searchEuDoNtcSndHistory(euDoNtcSend);

			String copyEml = new BookingUtil().searchCcEmailAddrRSQL("EU", account.getUsr_id());

			if( !StringUtils.isBlank(copyEml) ){
				euDoNtcSend.setNtcEml(copyEml);
				eai.sendEuDoByEmail(euDoNtcSend);
			}

			return bkgNtcHisVOs;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			if(ex.getMessage().indexOf("BKG40080") > -1) {
				throw new EventException(new ErrorHandler("BKG40080").getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
			}

//            throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}
	}

	/**
	 * FAX send event<br>
	 *
	 * @param BkgDoVO[] bkgDo
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO> bkgNtcHisVOs
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendEuDoByFax(BkgDoVO[] bkgDo, SignOnUserAccount account) throws EventException {

		CargoReleaseOrderEAIDAO eai = new CargoReleaseOrderEAIDAO();
		ComUserVO comUserVO = null;

		try {
			int resultCnt =0;
			log.debug("===================================================");
			log.debug("    EU_Cargo Release Order의 D/O Receiver 저장시   ");
			log.debug("===================================================");

			resultCnt = dbDao.modifyEuDoRcvrInfo(bkgDo, account);

			if ( resultCnt == 0 ) {
				log.debug("=======================================");
				log.debug("    D/O Receiver 수정된 건수가 없음    ");
				log.debug("=======================================");
			}

			log.debug("=======================================");
			log.debug("    searchDoMrdId 조회 Start           ");
			log.debug("=======================================");
			String mrd_id = dbDao.searchDoMrdId(account.getOfc_cd());

			log.debug("    searchDoMrdId 결과 : " + mrd_id );

			log.debug("=======================================");
			log.debug("    sendEuDoByFax Fax 전송 Start.      ");
			log.debug("=======================================");

			if ("".equals(mrd_id) || mrd_id.isEmpty()) {
				log.debug("=======================================");
				log.debug("    mrd_id의 값이 존재하지 않음        ");
				log.debug("=======================================");

				throw new EventException(new ErrorHandler("BKG40080").getMessage());
			}
			// 수정  account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}

			EuDoNtcSendVO euDoNtcSend = new EuDoNtcSendVO();
			euDoNtcSend.setBkgNo(bkgDo[0].getBkgNo());
			euDoNtcSend.setDoNo(bkgDo[0].getDoNo());
			euDoNtcSend.setDoNoSplit(bkgDo[0].getDoNoSplit());
			euDoNtcSend.setMrdId(mrd_id);
			euDoNtcSend.setNtcEml(bkgDo[0].getRcvrEml());
			euDoNtcSend.setNtcFaxNo(bkgDo[0].getRcvrFaxNo());
			euDoNtcSend.setUsrEml(sUsrEml);
			euDoNtcSend.setUsrId(account.getUsr_id());
			euDoNtcSend.setUsrNm(account.getUsr_nm());
			euDoNtcSend.setOfcCd(account.getOfc_cd());
			euDoNtcSend.setNtcViaCd("F");
			euDoNtcSend.setCreUsrId(account.getUsr_id());
			euDoNtcSend.setUpdUsrId(account.getUsr_id());
			euDoNtcSend.setCustNm(bkgDo[0].getRcvrCneeNm());

			euDoNtcSend.setSndId(eai.sendEuDoByFax(euDoNtcSend));

			List<BkgNtcHisVO> bkgNtcHisVOs = dbDao.searchEuDoNtcSndHistory(euDoNtcSend);

			return bkgNtcHisVOs;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			if(ex.getMessage().indexOf("BKG40080") > -1) {
				throw new EventException(new ErrorHandler("BKG40080").getMessage(), ex);
			} else {
				throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
			}
		}
	}

	/**
	 * 0938 retrieve event<br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return EuDoMstVO euDoMst
	 * @exception EventException
	 */
	public EuDoMstVO searchEuDo(String bkgNo, SignOnUserAccount account)throws EventException {

		EuDoMstVO euDoMst = new EuDoMstVO();

		try {


			validateBkgSts(bkgNo);

			DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
			euDoMst.setBlInfo(blInfo);

			if(blInfo != null){

				if (dbDao.checkEuDoDischLoc(blInfo.getPodCd().substring(0,2)).equals("N")) {
					String[] msg = new String[]{blInfo.getPodCd()};
					throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
				}

				BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo);

				if(doRef == null){
					doRef = new BkgDoRefVO();
					doRef.setBkgNo(blInfo.getBkgNo());
					euDoMst.setSplitFlg("N");
				}else{
					euDoMst.setSplitFlg(doRef.getDoSplitFlg());
				}

				euDoMst.setBkgDoRefVO(doRef);

				EuCstmsVO euCstms = dbDao.searchEuCstmsInfo(bkgNo);
				euDoMst.setEuCstms(euCstms);

				List<EuDoCntrRlseStsVO> euDoCntrRlseStsVOs = dbDao.searchEuDoRlseStsByCntr(bkgNo);
				euDoMst.setEuDoCntrRlseStsVOs(euDoCntrRlseStsVOs);

				int cntrCnt = dbDao.searchDoRemainCntrCnt(bkgNo);
				euDoMst.setCntrCnt(cntrCnt);

				List<EuDoRlseStsVO> euDoRlseStss= dbDao.searchEuDoRlseStsByBl(bkgNo);
				euDoMst.setEuDoRlseStsVOs(euDoRlseStss);

				String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);
				if(cntrNo != null){
					euDoMst.setCntrNo(cntrNo);
				}

				BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
				euDoMst.setBlIss(blIss);

				OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
				otsRcvInfoVO = this.searchErpOtsInfo(euDoMst.getBlInfo().getBlNo());
				euDoMst.setOtsRcvInfoVO(otsRcvInfoVO);

				String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());
				euDoMst.setMrdId(mrdId);
			}
			return euDoMst;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * save D/O info.
	 *
	 * @param EuDoSaveVO euDoSave
	 * @exception EventException
	 */
	public void manageEuDo(EuDoSaveVO euDoSave) throws EventException {
		try {
			int resultCnt =0;

			BkgDoHisVO doHis = new BkgDoHisVO();

			String preCtnt  = "N";
			String crntCtnt = "Y";

			if("CR".equals(euDoSave.getDoCngEvntCd())){
				preCtnt  = "Y";
				crntCtnt = "N";
			}
			if("Y".equals(euDoSave.getOblCngFlg())){

				doHis.setBkgNo(euDoSave.getBkgNo());
				doHis.setCreUsrId(euDoSave.getAcount().getUsr_id());
				doHis.setUpdUsrId(euDoSave.getAcount().getUsr_id());
				doHis.setDoCngEvntCd(euDoSave.getDoCngEvntCd());
				doHis.setPreCtnt(preCtnt);
				doHis.setCrntCtnt(crntCtnt);
				doHis.setEvntUsrId(euDoSave.getAcount().getUsr_id());
				doHis.setEvntOfcCd(euDoSave.getAcount().getOfc_cd());

				dbDao.addDoHistory(doHis);
			}

			BkgDoRefVO bkgDoRef = new BkgDoRefVO();

			bkgDoRef.setBkgNo(euDoSave.getBkgNo());
			bkgDoRef.setInterRmk(euDoSave.getInterRmk());
			bkgDoRef.setCreUsrId(euDoSave.getUserId());
			bkgDoRef.setUpdUsrId(euDoSave.getUserId());
			bkgDoRef.setDoSplitFlg(euDoSave.getDoSplitFlg());
			bkgDoRef.setCstmsRefNm(euDoSave.getCstmsRefNm());
			bkgDoRef.setCstmsRefCtnt(euDoSave.getCstmsRefCtnt());
			bkgDoRef.setCstmsAsgnNm(euDoSave.getCstmsAsgnNm());
			bkgDoRef.setCstmsAsgnCtnt(euDoSave.getCstmsAsgnCtnt());
			bkgDoRef.setDoHldFlg(JSPUtil.getNull(euDoSave.getDoHldFlg(),"N"));

			log.debug("getCstmsRefNm : " + bkgDoRef.getCstmsRefNm());

			resultCnt = dbDao.modifyDoRef(bkgDoRef);

			if ( resultCnt == 0 ) {
				log.debug("============================");
				log.debug("수정된 건수가 없음 신규 Create");
				log.debug("============================");

				dbDao.addDoRef(bkgDoRef);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * D/O Release<br>
	 *
	 * @param EuDoRlseVO euDoRlse
	 * @param DoCntrVO doCntrs
	 * @exception EventException
	 */
	public void releaseEuDo(EuDoRlseVO euDoRlse, DoCntrVO doCntrs) throws EventException {
		try {

			validateDoRelease(euDoRlse.getBkgNo());

			String doNo = null;
			if (euDoRlse.getDoSplitFlg().equals("Y")) {
				doNo = dbDao.searchDoNo(euDoRlse.getBkgNo());
			}

			if (doNo == null || doNo.equals("")) {
				doNo = makeDoNo(euDoRlse.getUsrOfcCd(), euDoRlse.getUsrId());
			}
			euDoRlse.setDoNo(doNo);

			//Split Flg == 'Y'
			String doNoSplit = "";
			int rlseSeq      = 0;

			//Split
			if ("Y".equals(euDoRlse.getDoSplitFlg())) {
				log.debug("==================================");
				log.debug("searchDoSplitNo - doNoSplit을 채번");
				log.debug("==================================");

				doNoSplit = dbDao.searchDoSplitNo(euDoRlse.getBkgNo(), euDoRlse.getDoNo()); // DO Number를 제공해야 합니다

				log.debug("==================================");
				log.debug("searchDoRlseSeq - rlseSeq를 채번");
				log.debug("==================================");
				rlseSeq = dbDao.searchDoRlseSeq(euDoRlse.getBkgNo());

			} else {
				doNoSplit = "00";
				rlseSeq = 1;
			}

			//Value Object
			BkgDoVO bkgDo       = new BkgDoVO();
			BkgDoRefVO bkgDoRef = new BkgDoRefVO();
			BkgDoDtlVO doDtl    = new BkgDoDtlVO();
			BkgDoHisVO doHis    = new BkgDoHisVO();

			bkgDo.setBkgNo(euDoRlse.getBkgNo());
			bkgDo.setDoNo(doNo);
			bkgDo.setRlseSeq(Integer.toString(rlseSeq));
			bkgDo.setDoNoSplit(doNoSplit);
			bkgDo.setJpDoId("");
			bkgDo.setCgorRmk(euDoRlse.getCgorRmk());
			bkgDo.setCreUsrId(euDoRlse.getUsrId());
			bkgDo.setUpdUsrId(euDoRlse.getUsrId());
			bkgDo.setCustPrnFlg("N");
			bkgDo.setSelfTrnsFlg("N");

			bkgDoRef.setBkgNo(euDoRlse.getBkgNo());

			bkgDoRef.setCstmsRefNm(euDoRlse.getCstmsRefNm());
			bkgDoRef.setCstmsRefCtnt(euDoRlse.getCstmsRefCtnt());
			bkgDoRef.setCstmsAsgnNm(euDoRlse.getCstmsAsgnNm());
			bkgDoRef.setCstmsAsgnCtnt(euDoRlse.getCstmsAsgnCtnt());
			bkgDoRef.setInterRmk(euDoRlse.getInterRmk());
			bkgDoRef.setDoHldFlg(euDoRlse.getDoHldFlg());

			bkgDoRef.setCreUsrId(euDoRlse.getUsrId());
			bkgDoRef.setUpdUsrId(euDoRlse.getUsrId());
			bkgDoRef.setDoSplitFlg(euDoRlse.getDoSplitFlg());

			/*****************************************
				RELEASE STATUS CODE
			******************************************
			A ASSIGN
			R RELEASE
			D DOR I/F
			I ASSIGN & ISSUE
			C CANCEL
			******************************************/

			doDtl.setBkgNo(euDoRlse.getBkgNo());
			doDtl.setRlseSeq(Integer.toString(rlseSeq));
			doDtl.setRlseStsCd("R");
			doDtl.setEvntUsrId(euDoRlse.getUsrId());
			doDtl.setEvntOfcCd(euDoRlse.getUsrOfcCd());
			doDtl.setCreUsrId(euDoRlse.getUsrId());
			doDtl.setUpdUsrId(euDoRlse.getUsrId());

			doHis.setBkgNo(euDoRlse.getBkgNo());
			doHis.setCreUsrId(euDoRlse.getUsrId());
			doHis.setUpdUsrId(euDoRlse.getUsrId());
			doHis.setDoCngEvntCd("RE"); //Release
			doHis.setPreCtnt("");
			doHis.setCrntCtnt(euDoRlse.getDoNo());
			doHis.setEvntUsrId(euDoRlse.getUsrId());
			doHis.setEvntOfcCd(euDoRlse.getUsrOfcCd());

			//manageDo
			manageDo(bkgDo, bkgDoRef, doDtl, doHis);

			//Split
			if ("Y".equals(euDoRlse.getDoSplitFlg())) {

//                log.debug("=======================================");
//                log.debug(""+doCntrs.length+"건 만큼 For Loop 실행");
//                log.debug("=======================================");

//                for(int i=0;i<doCntrs.length;i++){
//                    log.debug("==================================");
//                    log.debug("addDoRlseByCntr 호출 " + i + "건");
//                    log.debug("==================================");

					doCntrs.setRlseSeq(Integer.toString(rlseSeq));
					doCntrs.setCreUsrId(euDoRlse.getUsrId());
					doCntrs.setUpdUsrId(euDoRlse.getUsrId());

					dbDao.addDoRlseByCntr(doCntrs);
//                }
			} else {
				log.debug("==================================");
				log.debug("addDoRlseByBl 호출 : " + Integer.toString(rlseSeq));
				log.debug("==================================");

				dbDao.addDoRlseByBl(euDoRlse.getBkgNo(), Integer.toString(rlseSeq), euDoRlse.getUsrId());
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * cancel 0938 EU D/O<br>
	 *
	 * @param DoCancelVO doCancel
	 * @exception EventException
	 * @author
	 */
	public void cancelEuDo(DoCancelVO doCancel) throws EventException {
		try {
			this.cancelDo(doCancel);
			dbDao.removeDoCntr(doCancel.getBkgNo(), doCancel.getRlseSeq());

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * retrieving 1035 CY Delivery <br>
	 *
	 * @param String bkgNo
	 * @return BkgDoVO
	 * @exception EventException
	 * @author
	 */
	public BkgDoVO searchVetnamPrnCd(String bkgNo) throws EventException {
		try {
			return dbDao.searchVetnamPrnCd(bkgNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling manage event of CY Delivery <br>
	 *
	 * @param String doNo
	 * @param String doNoSplit
	 * @param String vnCgoDeCd
	 * @param SignOnUserAccount account
	 * @return EventResponse EsmBkg1035EventResponse
	 * @exception EventException
	 */
	public void setupVetnamPrnCd(String bkgNo, String rlseSeq, String vnCgoDeCd, String usrId) throws EventException {
		try {
			int resultCnt =0;

			resultCnt = dbDao.modifyVetnamPrnCd(bkgNo, rlseSeq, vnCgoDeCd, usrId);

			if ( resultCnt == 0 ) {
				log.debug("=======================================");
				log.debug("    수정된 건수가 없음                ");
				log.debug("=======================================");
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 *  Handling retrieving event of 0128<br>
	 *
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return DoMstVO doMst
	 * @exception EventException
	 */
	public DoMstVO searchGenDo(String bkgNo, SignOnUserAccount account)throws EventException {

		DoMstVO doMst = new DoMstVO();

		try {
			validateBkgSts(bkgNo);

			DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
			doMst.setBlInfo(blInfo);

			GenDoBlInfoVO genBlInfo = new GenDoBlInfoVO();

			if(blInfo != null){

				if (dbDao.checkGenDoDischLoc(blInfo.getPodCd().substring(0,2)).equals("N")) {
					String[] msg = new String[]{blInfo.getPodCd()};
					throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
				}

				BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo);

				if(doRef == null){
					doRef = new BkgDoRefVO();
					doRef.setBkgNo(blInfo.getBkgNo());

					doRef.setCstmsRefNm("Customs Ref. No.");
					doRef.setCstmsAsgnNm("Customs Ref. No.");

					doMst.setSplitFlg("N");
				}else{
					doMst.setSplitFlg(doRef.getDoSplitFlg());
				}

				doMst.setBkgDoRefVO(doRef);

//                List<DoRlseStsVO> doRlseStsVOs = dbDao.searchDoRlseSts(bkgNo);
//                doMst.setDoRlseStsVOs(doRlseStsVOs);

				List<EuDoCntrRlseStsVO> euDoCntrRlseStsVOs = dbDao.searchGenDoRlseStsByCntr(bkgNo);
				doMst.setGenDoCntrRlseStsVOs(euDoCntrRlseStsVOs);

				int cntrCnt = dbDao.searchDoRemainCntrCnt(bkgNo);
				doMst.setCntrCnt(cntrCnt);

				List<EuDoRlseStsVO> euDoRlseStss= dbDao.searchGenDoRlseStsByBl(bkgNo);
				doMst.setGenDoRlseStsVOs(euDoRlseStss);

				String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);
				if(cntrNo != null){
					doMst.setCntrNo(cntrNo);
				}

				BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
				doMst.setBlIss(blIss);


				OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
				otsRcvInfoVO = this.searchErpOtsInfo(doMst.getBlInfo().getBlNo());

				doMst.setOtsRcvInfoVO(otsRcvInfoVO);

				String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());

				doMst.setMrdId(mrdId);


				ObjectCloner.build(blInfo, genBlInfo);
				ObjectCloner.build(doRef, genBlInfo);
				if(blIss != null){
					ObjectCloner.build(blIss, genBlInfo);
				}
				if(otsRcvInfoVO != null){
					ObjectCloner.build(otsRcvInfoVO, genBlInfo);
				}

				doMst.setGenBlInfo(genBlInfo);


			}
			return doMst;

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * saving 0128 D/O infomation.
	 *
	 * @param DoSaveVO doSave
	 * @exception EventException
	 */
	public void manageGenDo(DoSaveVO doSave) throws EventException {
		try {
			int resultCnt =0;

			BkgDoHisVO doHis = new BkgDoHisVO();

			String preCtnt  = "N";
			String crntCtnt = "Y";

			if("CR".equals(doSave.getDoCngEvntCd())){
				preCtnt  = "Y";
				crntCtnt = "N";
			}

			if("Y".equals(doSave.getOblCngFlg())){

				doHis.setBkgNo(doSave.getBkgNo());
				doHis.setCreUsrId(doSave.getAcount().getUsr_id());
				doHis.setUpdUsrId(doSave.getAcount().getUsr_id());
				doHis.setDoCngEvntCd(doSave.getDoCngEvntCd());
				doHis.setPreCtnt(preCtnt);
				doHis.setCrntCtnt(crntCtnt);
				doHis.setEvntUsrId(doSave.getAcount().getUsr_id());
				doHis.setEvntOfcCd(doSave.getAcount().getOfc_cd());

				dbDao.addDoHistory(doHis);
			}

			BkgDoRefVO bkgDoRef = new BkgDoRefVO();

			bkgDoRef.setBkgNo(doSave.getBkgNo());
			bkgDoRef.setInterRmk(doSave.getInterRmk());
			bkgDoRef.setCreUsrId(doSave.getUserId());
			bkgDoRef.setUpdUsrId(doSave.getUserId());
			bkgDoRef.setDoSplitFlg(doSave.getDoSplitFlg());
			bkgDoRef.setCstmsRefNm(doSave.getCstmsRefNm());
			bkgDoRef.setCstmsRefCtnt(doSave.getCstmsRefCtnt());
			bkgDoRef.setCstmsAsgnNm(doSave.getCstmsAsgnNm());
			bkgDoRef.setCstmsAsgnCtnt(doSave.getCstmsAsgnCtnt());
			bkgDoRef.setDoHldFlg(JSPUtil.getNull(doSave.getDoHldFlg(),"N"));

			log.debug("getCstmsRefNm : " + bkgDoRef.getCstmsRefNm());

			resultCnt = dbDao.modifyDoRef(bkgDoRef);

			if ( resultCnt == 0 ) {
				dbDao.addDoRef(bkgDoRef);
			}

		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of D/O<br>
	 *
	 * @param String bkgNo
	 * @return DoMstVO doMst
	 * @exception EventException
	 */
	public DoMstVO searchDo(String bkgNo)throws EventException {

		DoMstVO doMst = new DoMstVO();

		try {
			log.debug("===================================");
			log.debug("8. Booking의 Actual Staus 를 조회한다. (9, 10번 포함)");
			log.debug("===================================");
			//F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled,  W
			validateBkgSts(bkgNo);

			// EU D/O Release
			log.debug("=======================================");
			log.debug("12. D/O Release를 위한 기본 정보 조회");
			log.debug("=======================================");

			DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);
			doMst.setBlInfo(blInfo);

			GenDoBlInfoVO genBlInfo = new GenDoBlInfoVO();

			if(blInfo != null){
				log.debug("=================================================");
				log.debug("13. D/O Release를 위한 기본 Reference 정보 조회");
				log.debug("=================================================");

				BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo);
				doMst.setBkgDoRefVO(doRef);


				//16. splitFlg == "Y" check
				if(null != doRef){
					doMst.setSplitFlg(doRef.getDoSplitFlg());
				} else {
					doMst.setSplitFlg("N");
				}

				// B/L D/O STATUS(ASSIGN, RELEASE, ISSUE)
				log.debug("===========================================================");
				log.debug("20. B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 조회");
				log.debug("===========================================================");

				List<DoRlseStsVO> doRlseStss= dbDao.searchDoRlseStsByBl(bkgNo);
				doMst.setDoRlseStsVOs(doRlseStss);

				log.debug("==================================");
				log.debug("17. Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.");
				log.debug("==================================");

				List<DoCntrRlseStsVO> doCntrRlseStsVOs = dbDao.searchDoRlseStsByCntr(bkgNo);
				doMst.setDoCntrRlseStsVOs(doCntrRlseStsVOs);

				log.debug("================================================================");
				log.debug("21. DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회");
				log.debug("================================================================");
				String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);

				if(cntrNo != null){
					doMst.setCntrNo(cntrNo);
				}

				log.debug("=================================================================================");
				log.debug("22. 조회된 시점에 조회된 Original B/L 회수 여부와 발행통수 및  Detail정보를 조회한다.");
				log.debug("=================================================================================");
				BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
				doMst.setBlIss(blIss);

				log.debug("=================================================================");
				log.debug("11. 운임 결재 여부와 Outstanding Amounts 조회를 위한 Office 정보 조회");
				log.debug("=================================================================");

				OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
				log.debug("ERP I/F를 위한 EAIDAO 호출");
				otsRcvInfoVO = this.searchErpOtsInfo(doMst.getBlInfo().getBlNo());
				doMst.setOtsRcvInfoVO(otsRcvInfoVO);

				ObjectCloner.build(blInfo, genBlInfo);

				if(doRef != null){
					ObjectCloner.build(doRef, genBlInfo);
				}
				if(blIss != null){
					ObjectCloner.build(blIss, genBlInfo);
				}
				if(otsRcvInfoVO != null){
					ObjectCloner.build(otsRcvInfoVO, genBlInfo);
				}

				doMst.setGenBlInfo(genBlInfo);
			}
			return doMst;
		} catch(EventException ex) {
			throw ex;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 0292 Cargo Release Remark save event<br>
	 *
	 * @param BkgDoRefVO bkgDoRef
	 * @exception EventException
	 */
	public void manageDoHldRmk(BkgDoRefVO bkgDoRef) throws EventException {
		try {
			int resultCnt =0;

			resultCnt = dbDao.mergeDoRef(bkgDoRef);

			if ( resultCnt == 0 ) {
				log.debug("============================");
				log.debug("처리된 건수가 없음");
				log.debug("============================");
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Target B / L for the D/O Release operations are performed.<br>
	 *
	 * @param DoRlseVO doRlse
	 * @param DoCntrVO doCntrs
	 * @exception EventException
	 */
	public void releaseGenDo(DoRlseVO doRlse, DoCntrVO doCntrs) throws EventException {
		try {
				validateDoRelease(doRlse.getBkgNo());

			   // DO No
				log.debug("==================================");
				log.debug("makeDoNo - DO No를 채번 한다.");
				log.debug("==================================");

				String doNo = null;
				if (doRlse.getDoSplitFlg().equals("Y")) {
					doNo = dbDao.searchDoNo(doRlse.getBkgNo());
				}

				if (doNo == null || doNo.equals("")) {
//	                doNo = makeDoNo(doRlse.getAcount().getOfc_cd(),doRlse.getAcount().getUsr_id());
					doNo = makeDoNo(doRlse.getUsrOfcCd(),doRlse.getCreUsrId());
				}

				doRlse.setDoNo(doNo);

	//Split Flg == 'Y'
				String doNoSplit = "";
				int rlseSeq      = 0;

				//Split
				if ("Y".equals(doRlse.getDoSplitFlg())) {
					log.debug("==================================");
					log.debug("searchDoSplitNo - doNoSplit을 채번");
					log.debug("==================================");

					doNoSplit = dbDao.searchDoSplitNo(doRlse.getBkgNo(),doRlse.getDoNo()); // DO Number를 제공해야 합니다

					log.debug("==================================");
					log.debug("searchDoRlseSeq - rlseSeq를 채번");
					log.debug("==================================");
					rlseSeq = dbDao.searchDoRlseSeq(doRlse.getBkgNo());

				} else {
					doNoSplit = "00";
					rlseSeq = 1;
				}



				// Value Object
				BkgDoVO bkgDo = new BkgDoVO();
				BkgDoRefVO bkgDoRef = new BkgDoRefVO();
				BkgDoDtlVO doDtl = new BkgDoDtlVO();
				BkgDoHisVO doHis = new BkgDoHisVO();

				bkgDo.setBkgNo(doRlse.getBkgNo());
				bkgDo.setDoNo(doNo);
				bkgDo.setRlseSeq(Integer.toString(rlseSeq));
				bkgDo.setDoNoSplit(doNoSplit);
				bkgDo.setCgorRmk(doRlse.getCgorRmk());
				bkgDo.setCreUsrId(doRlse.getCreUsrId());
				bkgDo.setUpdUsrId(doRlse.getCreUsrId());
				bkgDo.setCustPrnFlg("N");
				bkgDo.setSelfTrnsFlg("N");

				bkgDoRef.setBkgNo(doRlse.getBkgNo());
				bkgDoRef.setCstmsRefNm(doRlse.getCstmsRefNm());
				bkgDoRef.setCstmsRefCtnt(doRlse.getCstmsRefCtnt());
				bkgDoRef.setCstmsAsgnNm(doRlse.getCstmsAsgnNm());
				bkgDoRef.setCstmsAsgnCtnt(doRlse.getCstmsAsgnCtnt());
				bkgDoRef.setInterRmk(doRlse.getInterRmk());
				bkgDoRef.setDoHldFlg(doRlse.getDoHldFlg());
				bkgDoRef.setCreUsrId(doRlse.getCreUsrId());
				bkgDoRef.setUpdUsrId(doRlse.getCreUsrId());
				bkgDoRef.setDoSplitFlg(doRlse.getDoSplitFlg());


				/*****************************************
					DO RELEASE STATUS CODE
				******************************************
				AS  Assigned
				CR  Cancelled O/BL Received
				DC  DOR Cancel
				DF  DOR I/F
				DT  DOR Transmit
				HC  Cancelled Cargo Hold
				PD  Printed D/O
				RB  Received O. B/L
				RE  Released
				RI  Received In bond Doc
				RO  Received Other Doc
				RR  Remark for Release
				SF  Sent Fax/E-Mail
				XX  Canceled

				/*****************************************
					RELEASE STATUS CODE
				******************************************
				A ASSIGN
				R RELEASE
				D DOR I/F
				I ASSIGN & ISSUE
				C CANCEL
				******************************************/

				doDtl.setBkgNo(doRlse.getBkgNo());
				doDtl.setRlseSeq(Integer.toString(rlseSeq));
				doDtl.setRlseStsCd("R");
				doDtl.setEvntUsrId(doRlse.getCreUsrId());
				doDtl.setEvntOfcCd(doRlse.getUsrOfcCd());
				doDtl.setCreUsrId(doRlse.getCreUsrId());
				doDtl.setUpdUsrId(doRlse.getCreUsrId());

				doHis.setBkgNo(doRlse.getBkgNo());
				doHis.setCreUsrId(doRlse.getCreUsrId());
				doHis.setUpdUsrId(doRlse.getCreUsrId());
				doHis.setDoCngEvntCd("RE"); // Release
				doHis.setPreCtnt("");
				doHis.setCrntCtnt(doRlse.getDoNo());
				doHis.setEvntUsrId(doRlse.getCreUsrId());
				doHis.setEvntOfcCd(doRlse.getUsrOfcCd());

				manageDo(bkgDo, bkgDoRef, doDtl, doHis);


	//Split
				if ("Y".equals(doRlse.getDoSplitFlg())) {

//	                log.debug("=======================================");
//	                log.debug(""+doCntrs.length+"건 만큼 For Loop 실행");
//	                log.debug("=======================================");

//	                for(int i=0;i<doCntrs.length;i++){
//	                    log.debug("==================================");
//	                    log.debug("addDoRlseByCntr 호출 " + i + "건");
//	                    log.debug("==================================");

						doCntrs.setRlseSeq(Integer.toString(rlseSeq));
						doCntrs.setCreUsrId(doRlse.getCreUsrId());
						doCntrs.setUpdUsrId(doRlse.getUsrOfcCd());

						dbDao.addDoRlseByCntr(doCntrs);
//	                }
				} else {
					log.debug("==================================");
					log.debug("addDoRlseByBl 호출 : " + Integer.toString(rlseSeq));
					log.debug("==================================");

					dbDao.addDoRlseByBl(doRlse.getBkgNo(), Integer.toString(rlseSeq), doRlse.getCreUsrId());
				}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	 * @param String doNo
	 * @param String doNoSplit
	 * @return DoRcvrVO
	 * @exception EventException
	 * @author
	 */
	public DoRcvrVO searchIdaDoRcvrInfo(String doNo, String doNoSplit) throws EventException {
		try {
			return dbDao.searchIdaDoRcvrInfo(doNo, doNoSplit);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0936 D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	 * @param DoRcvrVO doRcvr
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author
	 */
	public void setupIdaDoRcvrInfo(DoRcvrVO doRcvr, SignOnUserAccount account) throws EventException {
		try {
			dbDao.setupIdaDoRcvrInfo(doRcvr, account);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0694 - Cargo Delivery - DO LIST CHECK REPORT(JAPAN)<br>
	 * @param JapDoHisSearchVO japDoHisSearch
	 * @return List<JapDoHisListVO>
	 * @exception EventException
	 * @author
	 */
	public List<JapDoHisListVO> searchJapDoHistory(JapDoHisSearchVO japDoHisSearch) throws EventException {
		try {
			return dbDao.searchJapDoHistory(japDoHisSearch);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0131 Cargo Release Order List Check Report<br>
	 * @param DoCheckListSearchVO checkListSearch
	 * @return List<DoCheckListVO>
	 * @exception EventException
	 * @author
	 */
	public List<DoCheckListVO> searchDoCheckReport (DoCheckListSearchVO checkListSearch) throws EventException{
		try {
			return dbDao.searchDoCheckReport(checkListSearch);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0939 India Cargo Release Order list Inquery<br>
	 * @param IdaDoRlseSearchVO idaDoRlseSearch
	 * @return IdaDoRlseReportVO
	 * @exception EventException
	 * @author
	 */
	public IdaDoRlseReportVO searchIdaDoRlseReport (IdaDoRlseSearchVO idaDoRlseSearch) throws EventException {
		IdaDoRlseReportVO idaDoRlseReport = new IdaDoRlseReportVO();
		try {
			idaDoRlseReport.setIdaDoWeeklyReportVO(dbDao.searchIdaDoRlseWeeklyReport(idaDoRlseSearch));
			idaDoRlseReport.setIdaDoRlseListVO(dbDao.searchIdaDoRlseList(idaDoRlseSearch));
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return idaDoRlseReport;
	}

	/**
	 *  Handling retrieving event of India D/O<br>
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return IdaDoMstVO
	 * @exception EventException
	 * @author
	 */
	public IdaDoMstVO searchIdaDo(String bkgNo, SignOnUserAccount account) throws EventException {

		IdaDoMstVO doMst = new IdaDoMstVO();

		try {

			/**
			 * retrieving Actual Staus of Booking
			 * F: Firm, W: Waiting, S: Split, A: Advanced, X: Cancelled, first state W
			 */
			validateBkgSts(bkgNo);

			/**
			 * India D / O Release for the basic information is viewed.
			 */
			DoBlInfoVO blInfo = dbDao.searchDoBlInfo(bkgNo);   // 11
			doMst.setDoBlInfoVO(blInfo);

			if(blInfo != null){
				if(!blInfo.getDelCd().substring(0,2).equals("IN")) {  // 12
					String[] msg = new String[]{blInfo.getPodCd()};
					throw new EventException (new ErrorHandler("BKG40091", msg).getMessage());
				}

				/**
				 * Container-based retrieve information DO Release
				 */
				List<IdaDoCntrRlseStsVO> idaDoCntrRlseStsVOList = dbDao.searchIdaDoRlseStsByCntr(bkgNo);
				doMst.setIdaDoCntrRlseStsVOList(idaDoCntrRlseStsVOList);

				int remainCnt = dbDao.searchDoRemainCntrCnt(bkgNo);
				doMst.setRemainCnt(remainCnt);

				/**
				 * DO Release information, views, based on BL
				 */
				List<IdaDoRlseStsVO> idaDoRlseStsVOList = dbDao.searchIdaDoRlseStsByBl(bkgNo);
				doMst.setIdaDoRlseStsVOList(idaDoRlseStsVOList);

				/**
				 * Indian customs declaration for B / L INFO is viewed.
				 */
				IdaCstmsVO idaCstmsVO = dbDao.searchIdaCstmsInfo(bkgNo);  // 15
				doMst.setIdaCstmsVO(idaCstmsVO);

				/**
				 * D/O Release Reference information for the base is viewed.
				 */
				BkgDoRefVO doRef = dbDao.searchDoRefInfo(bkgNo);

				if (doRef == null) {
					doRef = new BkgDoRefVO();
					doRef.setBkgNo(bkgNo);
					doRef.setDoSplitFlg("N");
					doRef.setDoHldFlg("N");
				}
				doRef.setIdaImpGenMfNo(idaCstmsVO.getIdaImpGenMfNo());
				doRef.setIdaCgorOrdYr(idaCstmsVO.getIdaCgorOrdYr());
				doRef.setIdaCstmsAsgnLineNo(idaCstmsVO.getIdaCstmsAsgnLineNo());

				doMst.setBkgDoRefVO(doRef);

				String[] cntrNo = dbDao.searchDemDetCntrList(bkgNo);  // 19
				doMst.setCntrNoList(cntrNo);

				OtsRcvInfoVO otsRcvInfoVO = new OtsRcvInfoVO();
				otsRcvInfoVO = this.searchErpOtsInfo(doMst.getDoBlInfoVO().getBlNo());  // 13
				doMst.setOtsRcvInfoVO(otsRcvInfoVO);

				/**
				 * Retrieved at the time of the queried Original B/L number of issued and whether discharge is viewed and Detail information.
				 */
				BlIssVO blIss = dbDao.searchOBLSts(bkgNo);
				doMst.setBkgBlIssVO(blIss);

				String mrdId = dbDao.searchDoMrdId(account.getOfc_cd());  // 21
				doMst.setMrdId(mrdId);
			}
			return doMst;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0680 India Cargo Releass<br>
	 * @param IdaDoSaveVO idaDoSaveVO
	 * @exception EventException
	 * @author
	 */
	public void manageIdaDo(IdaDoSaveVO idaDoSaveVO) throws EventException {
		try {

			BkgDoHisVO doHis = new BkgDoHisVO();

			String preCtnt  = "N";
			String crntCtnt = "Y";

			if("CR".equals(idaDoSaveVO.getDoCngEvntCd())){
				preCtnt  = "Y";
				crntCtnt = "N";
			}
			if("Y".equals(idaDoSaveVO.getOblCngFlg())){

				doHis.setBkgNo(idaDoSaveVO.getBkgNo());
				doHis.setCreUsrId(idaDoSaveVO.getUsrId());
				doHis.setUpdUsrId(idaDoSaveVO.getUsrId());
				doHis.setDoCngEvntCd(idaDoSaveVO.getDoCngEvntCd());
				doHis.setPreCtnt(preCtnt);
				doHis.setCrntCtnt(crntCtnt);
				doHis.setEvntUsrId(idaDoSaveVO.getUsrId());
				doHis.setEvntOfcCd(idaDoSaveVO.getOfcCd());

				dbDao.addDoHistory(doHis);
			}

			int resultCnt =0;

			BkgDoRefVO bkgDoRefVO = new BkgDoRefVO();
			ObjectCloner.build(idaDoSaveVO, bkgDoRefVO);
			bkgDoRefVO.setUpdUsrId(idaDoSaveVO.getUsrId());
			bkgDoRefVO.setDoSplitFlg(idaDoSaveVO.getDoSplitFlg());
			resultCnt = dbDao.modifyDoRef(bkgDoRefVO);

			if ( resultCnt == 0 ) {
				bkgDoRefVO.setCreUsrId(idaDoSaveVO.getUsrId());
				dbDao.addDoRef(bkgDoRefVO);
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Handling UI-BKG-0680 DO Release event<br>
	 * @param IdaDoRlseVO idaDoRlse
	 * @param DoCntrVO doCntrs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author
	 */
	public void releaseIdaDo(IdaDoRlseVO idaDoRlse, DoCntrVO doCntrs, SignOnUserAccount account) throws EventException{
		try {
			validateDoRelease(idaDoRlse.getBkgNo());

			String doNo = null;
			if (idaDoRlse.getDoSplitFlg().equals("Y")) {
				doNo = dbDao.searchDoNo(idaDoRlse.getBkgNo());
			}

			if (doNo == null || doNo.equals("")) {
				doNo = makeDoNo(account.getOfc_cd(), account.getUsr_id());
			}

			idaDoRlse.setDoNo(doNo);
			String rlseSeq      = "";

			// 4. split_flg == Y
			// 4.1. searchDoSplitNo(bkgNo)
			if (idaDoRlse.getDoSplitFlg().equals("Y")) {
				String doNoSplit = dbDao.searchDoSplitNo(idaDoRlse.getBkgNo(), idaDoRlse.getDoNo()); // doNo
				idaDoRlse.setDoNoSplit(doNoSplit);

				rlseSeq = Integer.toString(dbDao.searchDoRlseSeq(idaDoRlse.getBkgNo()));
				idaDoRlse.setRlseSeq(rlseSeq);
			} else {
				idaDoRlse.setDoNoSplit("00");
				rlseSeq = "1";
				idaDoRlse.setRlseSeq(rlseSeq);
			}

			// 5. searchDoRlseSeq()
//            String rlseSeq = Integer.toString(dbDao.searchDoRlseSeq(idaDoRlse.getBkgNo()));
//            idaDoRlse.setRlseSeq(rlseSeq);

			//6.1 searchIdaDoRcvInfoForCopy (bkgNo)


			//6. manageDo(bkgDo, bkgDoRef, doDtl, doHis)
			BkgDoVO bkgDo = new BkgDoVO();
			ObjectCloner.build(idaDoRlse, bkgDo);

			//6.1 searchIdaDoRcvInfoForCopy (bkgNo)

			//인도지역 D/O Extension(2)
			IdaDoRlseInfoForCopyVO idaDoRlseInfoForCopyVo = dbDao.searchIdaDoRlseInfoForCopy(idaDoRlse.getBkgNo());

			if(idaDoRlseInfoForCopyVo != null) {
				bkgDo.setHblNo(idaDoRlseInfoForCopyVo .getHblNo());
				bkgDo.setRcvrCneeNm(idaDoRlseInfoForCopyVo .getRcvrCneeNm());
				bkgDo.setRcvrCoNm(idaDoRlseInfoForCopyVo .getRcvrCoNm());
				bkgDo.setRcvrPhnNo(idaDoRlseInfoForCopyVo .getRcvrPhnNo());
				bkgDo.setPicNm(idaDoRlseInfoForCopyVo .getPicNm());
				bkgDo.setRcvrEml(idaDoRlseInfoForCopyVo .getRcvrEml());
				bkgDo.setRcvrFaxNo(idaDoRlseInfoForCopyVo .getRcvrFaxNo());
				bkgDo.setDoPrnRmk(idaDoRlseInfoForCopyVo .getDoPrnRmk());
			}

			bkgDo.setCustPrnFlg("N");  // default NN
			bkgDo.setSelfTrnsFlg("N"); // default NN

			BkgDoRefVO bkgDoRef = new BkgDoRefVO();
			ObjectCloner.build(idaDoRlse, bkgDoRef);

			BkgDoDtlVO doDtl = new BkgDoDtlVO();
			ObjectCloner.build(idaDoRlse, doDtl);
			doDtl.setEvntUsrId(idaDoRlse.getUpdUsrId());
			doDtl.setRlseStsCd("R"); // Release
			doDtl.setRlseStsSeq("1");

			BkgDoHisVO doHis = new BkgDoHisVO();
			ObjectCloner.build(idaDoRlse, doHis);

			doHis.setPreCtnt("");
			if (idaDoRlse.getDoNoSplit() != null && Integer.parseInt(idaDoRlse.getDoNoSplit()) > 0) {
				doHis.setCrntCtnt((new StringBuffer()).append(idaDoRlse.getDoNo()).append(idaDoRlse.getDoNoSplit()).toString());
			} else {
				doHis.setCrntCtnt(idaDoRlse.getDoNo());
			}

			manageDo(bkgDo, bkgDoRef, doDtl, doHis);

			// 7. if (split_flg==Y)
			// 7.1. for [doCntr]
			// 7.1.1. addDoRlseByCntr(doCntr)
			// 7. else (split_flg==N)
			// 7.2. addDoRlseByBl
			if (idaDoRlse.getDoSplitFlg().equals("Y")) {
//                for (int idx = 0; idx < doCntrs.length; idx ++ ){
					doCntrs.setRlseSeq(rlseSeq);
					doCntrs.setCreUsrId(account.getUsr_id());
					doCntrs.setUpdUsrId(account.getUsr_id());
					dbDao.addDoRlseByCntr(doCntrs);
//                }
			} else {
				dbDao.addDoRlseByBl(idaDoRlse.getBkgNo(), idaDoRlse.getRlseSeq(), idaDoRlse.getCreUsrId());
			}
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(EventException ee) {
			throw ee;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0923 Inbound Cargo Release for POD Office_Popup History
	 * @param String blNo
	 * @return List<UsCgoRlseHisVO>
	 * @exception EventException
	 * @author
	 */
	public List<UsCgoRlseHisVO> searchUsCgoRlseHis(String blNo) throws EventException{
		try {
			return dbDao.searchUsCgoRlseHis(blNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
	 * @param String doNo
	 * @param SignOnUserAccount account
	 * @return DoPrnRmkVO
	 * @exception EventException
	 * @author
	 */
	public List<DoPrnRmkVO> searchDoPrnRmk(String doNo, SignOnUserAccount account) throws EventException{
		List<DoPrnRmkVO> doPrnRmkVOs = null;
		try{
			doPrnRmkVOs = dbDao.searchDoPrnRmk(doNo, account);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return doPrnRmkVOs;
	}

	/**
	 * UI-BKG-1018 D/O Cargo Release Remark Setting<br>
	 * @param DoPrnRmkVO doPrnRmkVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author
	 */
	public void modifyDoPrnRmk(DoPrnRmkVO doPrnRmkVO, SignOnUserAccount account) throws EventException{
		try{
			dbDao.modifyDoPrnRmk(doPrnRmkVO, account);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-0272 Full CNTR Release Order<br>
	 * @param FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch
	 * @return List<FullCntrRlseOrdVO>
	 * @exception EventException
	 * @author
	 */
	public List<FullCntrRlseOrdVO> searchFullCntrRlseOrderList(FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch) throws EventException{
		List<FullCntrRlseOrdVO> list = null;
		try{
			list = dbDao.searchFullCntrRlseOrderList(fullCntrRlseOrderSearch);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return list;
	}

	/**
	 * SendEmail<br>
	 * Full Container Order Send Mail<br>
	 * @param FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs
	 * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVOs
	 * @param BkgEuPinNoVO[] bkgEuPinNoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendEmailFullCntrRlseOrder(FullCntrRlseOrderMailSendVO[] fullCntrRlseOrderMailSendVOs, FullCntrRlseOrdVO[] fullCntrRlseOrdVOs, BkgEuPinNoVO[] bkgEuPinNoVOs, SignOnUserAccount account ) throws EventException{

		List<BkgFullCgoRlseOrdVO> bkgFullCgoRlseOrdVos = null;
		BkgFullCgoRlseOrdVO       bkgFullCgoRlseOrdVo  = null;
		try{
			// SEND EMAIL

			String emlSndId = null;

			String copyEml = new BookingUtil().searchCcEmailAddrRSQL("FR", account.getUsr_id());

			for(int i=0;i<fullCntrRlseOrderMailSendVOs.length;i++){
				String[] rcvAddr = StringUtils.split(fullCntrRlseOrderMailSendVOs[i].getRecipient(), ";");

				for(int j=0; j < rcvAddr.length ; j ++) {
					if(rcvAddr[j] == null) {
						throw new EventException(new ErrorHandler("BKG00366").getMessage());
					}

					fullCntrRlseOrderMailSendVOs[i].setRecipient(rcvAddr[j]);
					String tempStr = fullCntrRlseOrderMailSendVOs[i].getContent();
					fullCntrRlseOrderMailSendVOs[i].setContent(tempStr.replaceAll("\r\n", "<br>"));

					emlSndId = eaiDbDao.sendEmailByFullCntrReleaseOrder(fullCntrRlseOrderMailSendVOs[i], account);

					fullCntrRlseOrderMailSendVOs[i].setNtcSndId(emlSndId);

				}
				if( !StringUtils.isBlank(copyEml) ){
					fullCntrRlseOrderMailSendVOs[i].setRecipient(copyEml);
					eaiDbDao.sendEmailByFullCntrReleaseOrder(fullCntrRlseOrderMailSendVOs[i], account);
				}
			}

			bkgFullCgoRlseOrdVos = new ArrayList<BkgFullCgoRlseOrdVO>();

			for(int i=0;i<fullCntrRlseOrdVOs.length;i++){
				 FullCntrRlseOrdVO fullCntrRlseOrdVo = (FullCntrRlseOrdVO)fullCntrRlseOrdVOs[i];

				 for(int j=0;j<fullCntrRlseOrderMailSendVOs.length;j++){

					 if( fullCntrRlseOrdVo.getBlNo().equals(fullCntrRlseOrderMailSendVOs[j].getBlNo()) &&
						 fullCntrRlseOrdVo.getYdCd().equals(fullCntrRlseOrderMailSendVOs[j].getYdCd()) )  {

						 fullCntrRlseOrdVo.setYdEml(fullCntrRlseOrderMailSendVOs[j].getYdEml());
						 fullCntrRlseOrdVo.setNtcSndId(fullCntrRlseOrderMailSendVOs[j].getNtcSndId());
					 }
				 }
				 bkgFullCgoRlseOrdVo  = new BkgFullCgoRlseOrdVO();
				 ObjectCloner.build(fullCntrRlseOrdVo, bkgFullCgoRlseOrdVo);

				 bkgFullCgoRlseOrdVo.setCgorMzdCd("M");
				 bkgFullCgoRlseOrdVo.setBkgTrspModCd(fullCntrRlseOrdVo.getBkgTrspModCd());
				 bkgFullCgoRlseOrdVo.setRlseNtcEml(fullCntrRlseOrdVo.getYdEml());
				 bkgFullCgoRlseOrdVo.setEmlSndId(fullCntrRlseOrdVo.getNtcSndId());
				 bkgFullCgoRlseOrdVo.setRlseUsrId(account.getUsr_id());
				 bkgFullCgoRlseOrdVo.setRlseOfcCd(account.getOfc_cd());
				 bkgFullCgoRlseOrdVo.setCreUsrId(account.getUsr_id());
				 bkgFullCgoRlseOrdVo.setUpdUsrId(account.getUsr_id());

				 bkgFullCgoRlseOrdVos.add(bkgFullCgoRlseOrdVo);

			}
			dbDao.addFullCntrRlseOrder(bkgFullCgoRlseOrdVos );


			if(bkgEuPinNoVOs != null){
				BkgEuPinNoVO bkgEuPinNoVO = null;


				for(int i=0;i<bkgEuPinNoVOs.length;i++){

					bkgEuPinNoVO = new BkgEuPinNoVO();

					bkgEuPinNoVO.setBkgNo(bkgEuPinNoVOs[i].getBkgNo());
					bkgEuPinNoVO.setCntrNo(bkgEuPinNoVOs[i].getCntrNo());
//        			bkgEuPinNoVO.setRlseOrdSeq(bkgEuPinNoVOs[i].getRlseOrdSeq());
					bkgEuPinNoVO.setSndFlg("Y");
					bkgEuPinNoVO.setPinNo(bkgEuPinNoVOs[i].getPinNo());
					bkgEuPinNoVO.setCreUsrId(account.getUsr_id());
					bkgEuPinNoVO.setUpdUsrId(account.getUsr_id());

					log.debug("bkgEuPinNoVO ===>" + bkgEuPinNoVOs);

					String ordSeq     = dbDao.searchMaxOrdSubSeq(bkgEuPinNoVO);

					bkgEuPinNoVO.setRlseOrdSeq(ordSeq);

					String subSeq     = dbDao.searchMaxSubSeq(bkgEuPinNoVO);

					bkgEuPinNoVO.setRlseOrdSubSeq(subSeq);

					int iCnt = 0;

					if (bkgEuPinNoVO.getSndFlg().equals("N")) {
						//미전송 데이터는 업데이트 호출
						iCnt = dbDao.updateBkgEuPinNo(bkgEuPinNoVO, account);
					} else {
						//전송 데이터인 경우는 Insert 처리함

						bkgEuPinNoVO.setSndFlg("Y");
						iCnt = dbDao.manageBkgEuPinNo(bkgEuPinNoVO, account);
					}

					if (iCnt == 0) {
						dbDao.insertBkgEuPinNo(bkgEuPinNoVO, account);
					}
				}
			}

		} catch(EventException ee) {
			 log.error("err " + ee.toString(), ee);
			 throw ee;
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of India D/O<br>
	 * @param FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs
	 * @param BkgEuPinNoVO[] bkgEuPinNoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @author
	 */
	public void transmitEdiFullCntrRlseOrder ( FullCntrRlseOrderEdiSendVO[] fullCntrRlseOrderEdiSendVOs, BkgEuPinNoVO[] bkgEuPinNoVOs, SignOnUserAccount account) throws EventException{
		try{
			if(fullCntrRlseOrderEdiSendVOs != null){

				FullCntrRlseOrderEdiYdVO   fullCntrRlseOrderEdiYdVo = null;
				FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSend = null;
				BookingUtil                bookingUtil              = null;
				SendFlatFileVO             sendFlatFileVO           = null;
				FlatFileAckVO              flatFileAckVO            = null;
				List<BkgFullCgoRlseOrdVO> bkgFullCgoRlseOrdVos      = new ArrayList<BkgFullCgoRlseOrdVO>();

				for(int i=0;i<fullCntrRlseOrderEdiSendVOs.length;i++){
					fullCntrRlseOrderEdiYdVo = dbDao.searchEdiFullCntrRlseOrderYardCd(fullCntrRlseOrderEdiSendVOs[i].getYdCd());
					if(fullCntrRlseOrderEdiYdVo == null){
						//Invalid EDI Yard Code
						throw new EventException(new ErrorHandler("BKG04015",new String[]{fullCntrRlseOrderEdiSendVOs[i].getYdCd(),"EDI"}).getMessage());
					}

					bookingUtil =  new BookingUtil();
					fullCntrRlseOrderEdiSend = new FullCntrRlseOrderEdiSendVO();

					fullCntrRlseOrderEdiSend.setBkgNo(fullCntrRlseOrderEdiSendVOs[i].getBkgNo());
					fullCntrRlseOrderEdiSend.setCntrNo(fullCntrRlseOrderEdiSendVOs[i].getCntrNo());
					fullCntrRlseOrderEdiSend.setCxlFlg(fullCntrRlseOrderEdiSendVOs[i].getCxlFlg());
					fullCntrRlseOrderEdiSend.setBlNo(fullCntrRlseOrderEdiSendVOs[i].getBlNo());
					fullCntrRlseOrderEdiSend.setVvd(fullCntrRlseOrderEdiSendVOs[i].getVvd());
					fullCntrRlseOrderEdiSend.setDiffRmk(fullCntrRlseOrderEdiSendVOs[i].getDiffRmk());
					fullCntrRlseOrderEdiSend.setCustNm(fullCntrRlseOrderEdiSendVOs[i].getCustNm());
					fullCntrRlseOrderEdiSend.setCgoPkupDt(fullCntrRlseOrderEdiSendVOs[i].getCgoPkupDt());
					fullCntrRlseOrderEdiSend.setYdCd(fullCntrRlseOrderEdiSendVOs[i].getYdCd());
					fullCntrRlseOrderEdiSend.setCoBdgId(fullCntrRlseOrderEdiSendVOs[i].getCoBdgId());
					fullCntrRlseOrderEdiSend.setCgoCrrId(fullCntrRlseOrderEdiSendVOs[i].getCgoCrrId());
					fullCntrRlseOrderEdiSend.setRlseOfcCd(account.getOfc_cd());
					fullCntrRlseOrderEdiSend.setRlseExpDt(fullCntrRlseOrderEdiSendVOs[i].getRlseExpDt());
					fullCntrRlseOrderEdiSend.setPinNo(fullCntrRlseOrderEdiSendVOs[i].getPinNo());
					fullCntrRlseOrderEdiSend.setVehRgstId(fullCntrRlseOrderEdiSendVOs[i].getVehRgstId());
					fullCntrRlseOrderEdiSend.setRoadHlgId(fullCntrRlseOrderEdiSendVOs[i].getRoadHlgId());
					fullCntrRlseOrderEdiSend.setUqVslIdNo(fullCntrRlseOrderEdiSendVOs[i].getUqVslIdNo());
					fullCntrRlseOrderEdiSend.setCntrSltNo(fullCntrRlseOrderEdiSendVOs[i].getCntrSltNo());
					fullCntrRlseOrderEdiSend.setCstmsVoyNo(fullCntrRlseOrderEdiSendVOs[i].getCstmsVoyNo());
					fullCntrRlseOrderEdiSend.setMtyRtnYdCd(fullCntrRlseOrderEdiSendVOs[i].getMtyRtnYdCd());


					String referenceNumber = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");

					String header = dbDao.searchDoEdiHeader(fullCntrRlseOrderEdiYdVo.getSendId()
														   ,fullCntrRlseOrderEdiYdVo.getReceiverId()
														   ,referenceNumber
														   ,"COREOR");

					String brac     = dbDao.searchEdiFullCntrRlseOrdBrac(fullCntrRlseOrderEdiSend);
					fullCntrRlseOrderEdiSend.setCxlFlg(brac);

					String blInfo   = dbDao.searchEdiFullCntrRlseOrderBlInfo(fullCntrRlseOrderEdiSend);
					String cntrInfo = dbDao.searchEdiFullCntrRlseOrderCntrInfo(fullCntrRlseOrderEdiSend);

					String eurInfo = dbDao.searchEdiFullCntRlseOrderEurDtlInfo(fullCntrRlseOrderEdiSend);

					String cntrSealNo = dbDao.searchEdiFullCntRlseOrderEurCntrSealNo(fullCntrRlseOrderEdiSend);

					String dgInfo   = dbDao.searchEdiFullCntrRlseOrderDgInfo(fullCntrRlseOrderEdiSendVOs[i].getBkgNo()
																			,fullCntrRlseOrderEdiSendVOs[i].getCntrNo());

					String blCntr   = dbDao.searchEdiFullCntrRlseOrderBlCntr(fullCntrRlseOrderEdiSendVOs[i].getBkgNo()
																			,fullCntrRlseOrderEdiSendVOs[i].getCntrNo()
																			,fullCntrRlseOrderEdiSendVOs[i].getBkgTrspModCd());


					// Flat File Create
					StringBuffer buffer = new StringBuffer();
					buffer.append(header);
					buffer.append(blInfo);
					buffer.append(cntrInfo);
					buffer.append(eurInfo);
					buffer.append(cntrSealNo);
					buffer.append(dgInfo);
					buffer.append(blCntr);

					sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(buffer.toString());

					//QueueNm
					bookingUtil = new BookingUtil();

					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR.IBMMQ.QUEUE"));

					flatFileAckVO = new FlatFileAckVO();

					flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
						//EDI ERROR

					if( flatFileAckVO.getAckStsCd().equals("E")) {
						throw new EventException(new ErrorHandler("BKG40110",new String[]{fullCntrRlseOrderEdiYdVo.getReceiverId()}).getMessage());
					}

					BkgFullCgoRlseOrdVO bkgFullCgoRlseOrdVo = new BkgFullCgoRlseOrdVO();
					ObjectCloner.build(fullCntrRlseOrderEdiSendVOs[i], bkgFullCgoRlseOrdVo);
					// EDI Transmit
					bkgFullCgoRlseOrdVo.setCgorMzdCd("E");

					bkgFullCgoRlseOrdVo.setRlseUsrId(account.getUsr_id());
					bkgFullCgoRlseOrdVo.setRlseOfcCd(account.getOfc_cd());
					bkgFullCgoRlseOrdVo.setCreUsrId(account.getUsr_id());
					bkgFullCgoRlseOrdVo.setUpdUsrId(account.getUsr_id());

					bkgFullCgoRlseOrdVos.add(bkgFullCgoRlseOrdVo);


					/*******************COREOR 전송시에 RELRED도 같이 전송****************
					 *******************************************************************/
					fullCntrRlseOrderEdiSendVOs[i].setGubun("BKG");
					String referenceNumber1 = ReferenceNumberGeneratorBroker.getKey("BKG","BKG_EDI_SEQ");
					fullCntrRlseOrderEdiYdVo = dbDao.searchRelredInfoYardCd(fullCntrRlseOrderEdiSendVOs[i].getMtyRtnYdCd());
					
					if(fullCntrRlseOrderEdiYdVo != null){
						this.transmitRelRedMtyRlseOrder(fullCntrRlseOrderEdiSendVOs[i], fullCntrRlseOrderEdiYdVo, account, referenceNumber1);
				    }

				}// Loop Of For(i)





				dbDao.addFullCntrRlseOrder(bkgFullCgoRlseOrdVos);


				if(bkgEuPinNoVOs != null){
					BkgEuPinNoVO bkgEuPinNoVO = null;


					for(int i=0;i<bkgEuPinNoVOs.length;i++){

						bkgEuPinNoVO = new BkgEuPinNoVO();

						bkgEuPinNoVO.setBkgNo(bkgEuPinNoVOs[i].getBkgNo());
						bkgEuPinNoVO.setCntrNo(bkgEuPinNoVOs[i].getCntrNo());
//            			bkgEuPinNoVO.setRlseOrdSeq(bkgEuPinNoVOs[i].getRlseOrdSeq());
//            			bkgEuPinNoVO.setSndFlg(bkgEuPinNoVOs[i].getSndFlg());
						bkgEuPinNoVO.setSndFlg("Y");

						bkgEuPinNoVO.setPinNo(bkgEuPinNoVOs[i].getPinNo());
						bkgEuPinNoVO.setCreUsrId(account.getUsr_id());
						bkgEuPinNoVO.setUpdUsrId(account.getUsr_id());

						log.debug("bkgEuPinNoVO ===>" + bkgEuPinNoVOs);

						String ordSeq     = dbDao.searchMaxOrdSubSeq(bkgEuPinNoVO);

						bkgEuPinNoVO.setRlseOrdSeq(ordSeq);

						String subSeq     = dbDao.searchMaxSubSeq(bkgEuPinNoVO);

						bkgEuPinNoVO.setRlseOrdSubSeq(subSeq);

						if (bkgEuPinNoVO.getSndFlg().equals("N")) {
							//미전송 데이터는 업데이트 호출
							dbDao.updateBkgEuPinNo(bkgEuPinNoVO, account);
						} else {
							//전송 데이터인 경우는 Insert 처리함
							bkgEuPinNoVO.setSndFlg("Y");
							dbDao.manageBkgEuPinNo(bkgEuPinNoVO, account);
						}

					}
				}
			}
		} catch(EventException ee) {
			log.error("err " + ee.toString(), ee);
			throw ee;
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of India D/O<br>
	 * @param FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSendVO
	 * @param FullCntrRlseOrderEdiYdVO fullCntrRlseOrderEdiYdVo
	 * @param SignOnUserAccount account
	 * @param String referenceNumber
	 * @exception EventException
	 * @author
	 */
	public void transmitRelRedMtyRlseOrder ( FullCntrRlseOrderEdiSendVO fullCntrRlseOrderEdiSendVO, FullCntrRlseOrderEdiYdVO fullCntrRlseOrderEdiYdVo, SignOnUserAccount account, String referenceNumber) throws EventException{
		try{
			if(fullCntrRlseOrderEdiSendVO != null){


				BookingUtil                bookingUtil              = null;
				SendFlatFileVO             sendFlatFileVO           = null;
				FlatFileAckVO              flatFileAckVO            = null;

					/*******************COREOR 전송시에 RELRED도 같이 전송****************
					 *******************************************************************/
					String NEW_LINE = "\n";
					DBRowSet relredInfoRs = null;
					DBRowSet bkgDgCgoVOs = null;
					StringBuilder flatFile = new StringBuilder();
					
					String relRedheader = dbDao.searchDoEdiHeader(fullCntrRlseOrderEdiYdVo.getSendId()
																	,fullCntrRlseOrderEdiYdVo.getReceiverId()
																	,referenceNumber
																	,"RELRED");
					String masterInfo   = dbDao.searchRelredMasterForEmptyRelease(fullCntrRlseOrderEdiSendVO);

					flatFile.insert(0, relRedheader);
					flatFile.append(masterInfo);

					relredInfoRs = dbDao.searchRelredInfoForEmptyRelease(fullCntrRlseOrderEdiSendVO);
					 while (relredInfoRs.next()) {


					flatFile.append("{RELRED_INFO").append(NEW_LINE);
					flatFile.append("VENDOR:").append(relredInfoRs.getString("VENDOR")).append(NEW_LINE);
					flatFile.append("TRANS_MODE:").append(relredInfoRs.getString("TRANS_MODE")).append(NEW_LINE);
					flatFile.append("PD_DT:").append(relredInfoRs.getString("PD_DT")).append(NEW_LINE);
					flatFile.append("SPCL_INST:").append(relredInfoRs.getString("SPCL_INST")).append(NEW_LINE);
					flatFile.append("CNTR_NO:").append(relredInfoRs.getString("CNTR_NO")).append(NEW_LINE);
					flatFile.append("CSN:").append(relredInfoRs.getString("SLT_NO")).append(NEW_LINE);
					flatFile.append("CNTR_TYPE:").append(relredInfoRs.getString("CNTR_TYPE")).append(NEW_LINE);
					flatFile.append("CARGOTYPE:").append(relredInfoRs.getString("CARGOTYPE")).append(NEW_LINE);
					flatFile.append("SEAL:").append(relredInfoRs.getString("SEAL")).append(NEW_LINE);
					flatFile.append("CNTR_QTY:").append(relredInfoRs.getString("CNTR_QTY")).append(NEW_LINE);
					flatFile.append("DIND:").append(relredInfoRs.getString("DIND")).append(NEW_LINE);
					flatFile.append("RIND:").append(relredInfoRs.getString("RIND")).append(NEW_LINE);
					flatFile.append("AIND:").append(relredInfoRs.getString("AIND")).append(NEW_LINE);
					flatFile.append("TEMP_F:").append(relredInfoRs.getString("TEMP_F")).append(NEW_LINE);
					flatFile.append("TEMP_C:").append(relredInfoRs.getString("TEMP_C")).append(NEW_LINE);
					flatFile.append("RF_VOLTAGE:").append(relredInfoRs.getString("RF_VOLTAGE")).append(NEW_LINE);
					flatFile.append("VENT:").append(relredInfoRs.getString("VENT")).append(NEW_LINE);
					flatFile.append("VENT_CMH:").append(relredInfoRs.getString("VENT_CMH")).append(NEW_LINE);
					flatFile.append("VENT_PCT:").append(relredInfoRs.getString("VENT_PCT")).append(NEW_LINE);
					flatFile.append("HUMID:").append(relredInfoRs.getString("HUMID")).append(NEW_LINE);
					flatFile.append("GENSET:").append(relredInfoRs.getString("GENSET")).append(NEW_LINE);
					flatFile.append("RF_REMARK:").append(relredInfoRs.getString("RF_REMARK")).append(NEW_LINE);
					flatFile.append("RFDRY_IND:").append(relredInfoRs.getString("RFDRY_IND")).append(NEW_LINE);
					flatFile.append("RF_DRAIN:").append(relredInfoRs.getString("RF_DRAIN")).append(NEW_LINE);
					flatFile.append("OVF:").append(relredInfoRs.getString("OVF")).append(NEW_LINE);
					flatFile.append("OVR:").append(relredInfoRs.getString("OVR")).append(NEW_LINE);
					flatFile.append("OVH:").append(relredInfoRs.getString("OVH")).append(NEW_LINE);
					flatFile.append("OVLW:").append(relredInfoRs.getString("OVLW")).append(NEW_LINE);
					flatFile.append("OVRW:").append(relredInfoRs.getString("OVRW")).append(NEW_LINE);
					flatFile.append("OVWGT:").append(relredInfoRs.getString("OVWGT")).append(NEW_LINE);
					flatFile.append("VOID_SLOT:").append(relredInfoRs.getString("VOID_SLOT")).append(NEW_LINE);
					flatFile.append("STWG_REQ:").append(relredInfoRs.getString("STWG_REQ")).append(NEW_LINE);
					flatFile.append("TTL_DIM_LEN:").append(relredInfoRs.getString("TTL_DIM_LEN")).append(NEW_LINE);
					flatFile.append("TTL_DIM_WDT:").append(relredInfoRs.getString("TTL_DIM_WDT")).append(NEW_LINE);
					flatFile.append("TTL_DIM_HGT:").append(relredInfoRs.getString("TTL_DIM_HGT")).append(NEW_LINE);
					flatFile.append("GWGTUNIT:").append(relredInfoRs.getString("GWGT_UNIT")).append(NEW_LINE);
					flatFile.append("GWGT:").append(relredInfoRs.getString("GWGT")).append(NEW_LINE);
					flatFile.append("NWGTUNIT:").append(relredInfoRs.getString("NWGT_UNIT")).append(NEW_LINE);
					flatFile.append("NWGT:").append(relredInfoRs.getString("NWGT")).append(NEW_LINE);
					flatFile.append("TWGTUNIT:").append(relredInfoRs.getString("TWGT_UNIT")).append(NEW_LINE);
					flatFile.append("TWGT:").append(relredInfoRs.getString("TWGT")).append(NEW_LINE);
					flatFile.append("CMD:").append(relredInfoRs.getString("CMD")).append(NEW_LINE);
					flatFile.append("CMDD:").append(relredInfoRs.getString("CMDD")).append(NEW_LINE);

					bkgDgCgoVOs = dbDao.searchBkgDgCgoforEmptyRelease(fullCntrRlseOrderEdiSendVO.getBkgNo()
																			,fullCntrRlseOrderEdiSendVO.getCntrNo());
					if (bkgDgCgoVOs.getRowCount() > 0) {
						while (bkgDgCgoVOs.next()) {
							flatFile.append("{CNTR_DANGER").append(NEW_LINE);
							flatFile.append("UNBR:").append(bkgDgCgoVOs.getString("UNBR")).append(NEW_LINE);
							flatFile.append("CLAS:").append(bkgDgCgoVOs.getString("CLAS")).append(NEW_LINE);
							flatFile.append("DESC:").append(bkgDgCgoVOs.getString("DG_DESC")).append(NEW_LINE);
							flatFile.append("PROPER_NM:").append(bkgDgCgoVOs.getString("PROPER_NM")).append(NEW_LINE);
							flatFile.append("TECH_NM:").append(bkgDgCgoVOs.getString("TECH_NM")).append(NEW_LINE);
							flatFile.append("DG_APPROVAL:").append(bkgDgCgoVOs.getString("DG_APPROVAL")).append(NEW_LINE);
							flatFile.append("PHON:").append(bkgDgCgoVOs.getString("PHON")).append(NEW_LINE);
							flatFile.append("FPNT:").append(bkgDgCgoVOs.getString("FPNT")).append(NEW_LINE);
							flatFile.append("FPUN:").append(bkgDgCgoVOs.getString("FPUN")).append(NEW_LINE);
							flatFile.append("DG_REMARK:").append(bkgDgCgoVOs.getString("DG_REMARK")).append(NEW_LINE);
							flatFile.append("EMSNO:").append(bkgDgCgoVOs.getString("EMSNO")).append(NEW_LINE);
							flatFile.append("PSACLS:").append(bkgDgCgoVOs.getString("PSACLS")).append(NEW_LINE);
							flatFile.append("PKGGRP:").append(bkgDgCgoVOs.getString("PKGGRP")).append(NEW_LINE);
							flatFile.append("MAR_POLL:").append(bkgDgCgoVOs.getString("MAR_POLL")).append(NEW_LINE);
							flatFile.append("HAZ_CONT:").append(bkgDgCgoVOs.getString("HAZ_CONT")).append(NEW_LINE);
							flatFile.append("IMO_LIMIT:").append(bkgDgCgoVOs.getString("IMO_LIMIT")).append(NEW_LINE);
							flatFile.append("}CNTR_DANGER").append(NEW_LINE);
						}
						bkgDgCgoVOs = null;
					} else {
						flatFile.append("{CNTR_DANGER").append(NEW_LINE);
						flatFile.append("UNBR:").append(NEW_LINE);
						flatFile.append("CLAS:").append(NEW_LINE);
						flatFile.append("DESC:").append(NEW_LINE);
						flatFile.append("PROPER_NM:").append(NEW_LINE);
						flatFile.append("TECH_NM:").append(NEW_LINE);
						flatFile.append("DG_APPROVAL:").append(NEW_LINE);
						flatFile.append("PHON:").append(NEW_LINE);
						flatFile.append("FPNT:").append(NEW_LINE);
						flatFile.append("FPUN:").append(NEW_LINE);
						flatFile.append("DG_REMARK:").append(NEW_LINE);
						flatFile.append("EMSNO:").append(NEW_LINE);
						flatFile.append("PSACLS:").append(NEW_LINE);
						flatFile.append("PKGGRP:").append(NEW_LINE);
						flatFile.append("MAR_POLL:").append(NEW_LINE);
						flatFile.append("HAZ_CONT:").append(NEW_LINE);
						flatFile.append("IMO_LIMIT:").append(NEW_LINE);
						flatFile.append("}CNTR_DANGER").append(NEW_LINE);
					}
					flatFile.append("}RELRED_INFO").append(NEW_LINE);

					}

			  sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile.toString());

			  //QueueNm
			  bookingUtil = new BookingUtil();

			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_VENDOR.IBMMQ.QUEUE"));

			  flatFileAckVO = new FlatFileAckVO();

			  flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			  log.debug("ReleaseReDelivery : " + flatFile.toString());
				  //EDI ERROR

			  if( flatFileAckVO.getAckStsCd().equals("E")) {
				  throw new EventException(new ErrorHandler("BKG40110",new String[]{fullCntrRlseOrderEdiYdVo.getReceiverId()}).getMessage());
			  }
			  relredInfoRs = null;

			  // EDI log_ BKG_IB_EDI_SND_LOG 테이블에 Log 쌓음
			  BkgIbEdiSndLogVO ibEdiSndLog = new BkgIbEdiSndLogVO();

			  ibEdiSndLog.setBkgNo(fullCntrRlseOrderEdiSendVO.getBkgNo());
			  ibEdiSndLog.setCntrNo(fullCntrRlseOrderEdiSendVO.getCntrNo());
			  ibEdiSndLog.setFltFileRefNo(relRedheader.substring(62,76));
			  ibEdiSndLog.setDoEdiTpCd("");
			  if("BKG".equals(fullCntrRlseOrderEdiSendVO.getGubun())){
				ibEdiSndLog.setMsgTpId("BKG");
			  }else{
				ibEdiSndLog.setMsgTpId("CTM");  //CTM에서 호출할 시에는 CTM으로 로그 남김
			  }
			  ibEdiSndLog.setMsgTpNm("RELRED");
			  ibEdiSndLog.setEdiSndMsgCtnt(sendFlatFileVO.getFlatFile());
			  ibEdiSndLog.setEdiEvntOfcCd(account.getOfc_cd());
			  ibEdiSndLog.setEdiEvntUsrId(account.getUsr_id());
			  ibEdiSndLog.setCreUsrId(account.getUsr_id());
			  ibEdiSndLog.setUpdUsrId(account.getUsr_id());

			  dbDao.addIbEdiSndLog(ibEdiSndLog);
					}
		} catch(EventException ee) {
			log.error("err " + ee.toString(), ee);
			throw ee;
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * 0272 - Pin No Save<br>
	 * @param BkgEuPinNoVO[] bkgEuPinNoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgEuPinNo(BkgEuPinNoVO[] bkgEuPinNoVOs, SignOnUserAccount account) throws EventException{
		try{

			log.debug("BCImpl manageBkgEuPinNo 호출  ");

			if(bkgEuPinNoVOs != null){
				BkgEuPinNoVO bkgEuPinNoVO = null;


				for(int i=0;i<bkgEuPinNoVOs.length;i++){

					bkgEuPinNoVO = new BkgEuPinNoVO();

					bkgEuPinNoVO.setBkgNo(bkgEuPinNoVOs[i].getBkgNo());
					bkgEuPinNoVO.setCntrNo(bkgEuPinNoVOs[i].getCntrNo());
					bkgEuPinNoVO.setRlseOrdSeq(bkgEuPinNoVOs[i].getRlseOrdSeq());
					bkgEuPinNoVO.setSndFlg("N");
					bkgEuPinNoVO.setPinNo(bkgEuPinNoVOs[i].getPinNo());
					bkgEuPinNoVO.setCreUsrId(account.getUsr_id());
					bkgEuPinNoVO.setUpdUsrId(account.getUsr_id());

					log.debug("bkgEuPinNoVO ===>" + bkgEuPinNoVOs);

					String subSeq     = dbDao.searchMaxSubSeq(bkgEuPinNoVO);

					bkgEuPinNoVO.setRlseOrdSubSeq(subSeq);

					dbDao.manageBkgEuPinNo(bkgEuPinNoVO, account);
				}
			}
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 1052 - Remark Save<br>
	 * @param BkgFullCntrRemarkVO bkgFullCntrRemarkVO
	 * @param SignOnUserAccount account
	 * @return int updateCount
	 * @exception EventException
	 */
	public int modifyFullCntrRlseRmk(BkgFullCntrRemarkVO bkgFullCntrRemarkVO, SignOnUserAccount account) throws EventException{
		int updateCount = 0;
		try{
			updateCount = dbDao.modifyFullCntrRlseRmk(bkgFullCntrRemarkVO, account);
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return updateCount;
	}

	/**
	 * Full Continer Release Order History<br>
	 * [ESM_BKG_0273]
	 * @param FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO
	 * @return List<FullCntrRlseOrderHisVO>
	 * @exception EventException
	 */
	public List<FullCntrRlseOrderHisVO> searchFullCntrRlseOrderHis(FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO) throws EventException{
		List<FullCntrRlseOrderHisVO> list = null;
		try{
			String fromDate = fullCntrRlseOrderHisSearchVO.getInCreDtFrom().replaceAll("-", "");
			String toDate = fullCntrRlseOrderHisSearchVO.getInCreDtTo().replaceAll("-", "");
			fullCntrRlseOrderHisSearchVO.setInCreDtFrom(fromDate);
			fullCntrRlseOrderHisSearchVO.setInCreDtTo(toDate);

			list = dbDao.searchFullCntrRlseOrderHis(fullCntrRlseOrderHisSearchVO);
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return list;
	}

	/**
	 * Full Continer Release Order History<br>
	 * [ESM_BKG_0273]
	 * @param BkgEuPinNoVO bkgEuPinNoSearchVO
	 * @return List<BkgEuPinNoVO>
	 * @exception EventException
	 */
	public List<BkgEuPinNoVO> searchBkgEuPinNoHis(BkgEuPinNoVO bkgEuPinNoSearchVO) throws EventException{
		List<BkgEuPinNoVO> list = null;
		try{
			list = dbDao.searchBkgEuPinNoHis(bkgEuPinNoSearchVO);
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return list;
	}


	/**
	 * [0130] : Retrieving Receiver Info <br>
	 * [ESM_BKG_0130]
	 * @param String doNo
	 * @return DoRcvrInfoVO
	 * @exception EventException
	 */
	public DoRcvrInfoVO searchDoRcvrInfo(String doNo) throws EventException{
		DoRcvrInfoVO doRcvrInfoVO = null;
		try{
			doRcvrInfoVO = dbDao.searchDoRcvrInfo(doNo);
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return doRcvrInfoVO;
	}

	/**
	 * [0130] : Saving Receiver Info <br>
	 * [ESM_BKG_0130]
	 * @param DoRcvrInfoVO doRcvrInfoVO
	 * @param SignOnUserAccount account
	 * @return int Update Count
	 * @exception EventException
	 */
	public int setupDoRcvrInfo(DoRcvrInfoVO doRcvrInfoVO, SignOnUserAccount account) throws EventException{
		int updCount = 0;
		try{
			updCount = dbDao.modifyDoRcvrInfo(doRcvrInfoVO, account);
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return updCount;
	}


	/**
	 * Retrieving Yard Information<br>
	 * @param String ydCd  : Yard Cord
	 * @return FullCntrRlseYdInfoVO ydInfoVO
	 * @exception EventException
	 * @author
	 */
	public FullCntrRlseYdInfoVO searchFullCntrRlseYdInfo(String ydCd) throws EventException{
		FullCntrRlseYdInfoVO ydInfoVO = null;
		try{
			ydInfoVO = dbDao.searchFullCntrRlseYdInfo(ydCd);
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return ydInfoVO;
	}



	/**
	 * Full Container Order email body Create.<br>
	 * @param FullCntrRlseOrdVO fullCntrRlseOrdVo
	 * @param SignOnUserAccount account
	 * @return String emlCtnt
	 * @exception EventException
	 * @author
	 */
	private String makeFullCntrRlseEmlHdr(FullCntrRlseOrdVO fullCntrRlseOrdVo,SignOnUserAccount account) throws EventException{

		StringBuffer sb = new StringBuffer();

		try{

			 sb.append("<Full Container Release Order>").append("\r\n").append("\r\n");

			 String temp = fullCntrRlseOrdVo.getSendDate();

			 sb.append("Date : " + temp.replaceAll("/", " / ")).append("\r\n");

			 sb.append("To : " + fullCntrRlseOrdVo.getYdNm()).append("\r\n");
			 sb.append("Tel : " + fullCntrRlseOrdVo.getPhnNo()).append("\r\n");
			 sb.append("Fax : " + fullCntrRlseOrdVo.getFaxNo()).append("\r\n").append("\r\n");

			 sb.append("From : " + account.getUsr_id() + " " + account.getOfc_eng_nm()).append("\r\n").append("\r\n").append("\r\n");


		 } catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return sb.toString();
	}

	/**
	 * Full Container Order email body Create.<br>
	 * @param FullCntrRlseOrdVO fullCntrRlseOrdVo
	 * @return String
	 * @exception EventException
	 * @author
	 */
	private String makeFullCntrRlseEmlCtnt(FullCntrRlseOrdVO fullCntrRlseOrdVo) throws EventException{

		StringBuffer sb = new StringBuffer();

		try{

			String cgoPkupDt = fullCntrRlseOrdVo.getCgoPkupDt();
			String rlseExpDt = fullCntrRlseOrdVo.getRlseExpDt();
			 sb.append("B/L No.(REF No) : " + fullCntrRlseOrdVo.getBlNo()).append("\r\n");
			 sb.append("Container No : " + fullCntrRlseOrdVo.getCntrNo()).append("\r\n");
			 sb.append("Release From Date : " + cgoPkupDt.substring(0, 4) + "-" + cgoPkupDt.substring(4, 6) + "-" +cgoPkupDt.substring(6, 8)).append("\r\n");
			 if(rlseExpDt == null || rlseExpDt.equals("")){
			 sb.append("Release Expiry Date : " ).append("\r\n");
			 }else{
				 sb.append("Release Expiry Date : " + rlseExpDt.substring(0, 4) + "-" + rlseExpDt.substring(4, 6) + "-" +rlseExpDt.substring(6, 8)).append("\r\n");
			 }
			 sb.append("Vessel Name : " + fullCntrRlseOrdVo.getVslNm()).append("\r\n");
			 String vvd = fullCntrRlseOrdVo.getVvd();
			 sb.append("VoyageNo : " + vvd.substring(4)).append("\r\n");
			 sb.append("Port Of Loading : " + fullCntrRlseOrdVo.getLocNm()).append("\r\n");
			 sb.append("Port Of Discharge : " + fullCntrRlseOrdVo.getPodNm()).append("\r\n");
//             sb.append("Consignee Or Release To : " + fullCntrRlseOrdVo.getCustNm()).append("\r\n");
			 sb.append("Pin No : " + fullCntrRlseOrdVo.getPinNo()).append("\r\n");

			 String pkupMode = fullCntrRlseOrdVo.getBkgTrspModCd();


			 if("T".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Truck").append("\r\n");
			 else if("R".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Rail").append("\r\n");
			 else if("F".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Feeder").append("\r\n");
			 else if("B".equals(pkupMode)) sb.append("Trans(Pick-Up)Mode : Barge").append("\r\n");
			 else sb.append("Trans(Pick-Up)Mode : ").append("\r\n");

			 sb.append("Remark : " + fullCntrRlseOrdVo.getDiffRmk()).append("\r\n").append("\r\n");

		 } catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return sb.toString();
	}

	/**
	 * Full Container Order email Signature Create.<br>
	 * @return String
	 * @exception EventException
	 * @author
	 */
	private String makeFullCntrRlseEmlSign() throws EventException{

		StringBuffer sb = new StringBuffer();

		try{
			 sb.append("END OF E-MAIL").append("\r\n").append("\r\n");
			 sb.append("Best Regards").append("\r\n");
			 sb.append(ConstantMgr.getCompanyName()).append("\r\n");

		 } catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return sb.toString();
	}

	/**
	 * Full Container Order email Create.<br>
	 * @param FullCntrRlseOrdVO[] fullCntrRlseOrdVos
	 * @param SignOnUserAccount account
	 * @return FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo
	 * @exception EventException
	 * @author
	 */
	@SuppressWarnings("unchecked")
	public FullCntrRlseOrderMailVO searchFullCntrRlseOrdMailCtnt(FullCntrRlseOrdVO[] fullCntrRlseOrdVos, SignOnUserAccount account) throws EventException{

		List<FullCntrRlseOrdVO> fullCntrRlseOrdVoSortList = new ArrayList<FullCntrRlseOrdVO>();

		List<FullCntrRlseOrdVO> fullCntrRlseOrdVoHisList = new ArrayList<FullCntrRlseOrdVO>();
		List<FullCntrRlseOrderMailSendVO> fullCntrRlseOrderMailSendVoList = new ArrayList<FullCntrRlseOrderMailSendVO>();
		FullCntrRlseOrderMailSendVO fullCntrRlseOrderMailSendVo = null; //new FullCntrRlseOrderMailSendVO();

		FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo = new FullCntrRlseOrderMailVO();

		try{
			List<Object> sortLists = sortArray(fullCntrRlseOrdVos, "blNo", "ydCd");

//			FullCntrRlseOrdVO fullCntrRlseOrdVo = null;
			FullCntrRlseOrdVO fullCntrRlseOrdVo = new FullCntrRlseOrdVO();
			FullCntrRlseYdInfoVO fullCntrRlseYdInfoVo = null;

			for (int i=0; i<sortLists.size(); i++) {


				fullCntrRlseOrdVoSortList = (List<FullCntrRlseOrdVO>) sortLists.get(i);

				StringBuffer emlTxt = new StringBuffer();
				StringBuffer emlCtnt = new StringBuffer();

				for (int j=0; j<fullCntrRlseOrdVoSortList.size(); j++) {
					fullCntrRlseOrdVo = fullCntrRlseOrdVoSortList.get(j);

					fullCntrRlseYdInfoVo = searchFullCntrRlseYdInfo(fullCntrRlseOrdVo.getYdCd());

					 if (fullCntrRlseYdInfoVo != null) {
						fullCntrRlseOrdVo.setYdEml(fullCntrRlseYdInfoVo.getYdEml());
						fullCntrRlseOrdVo.setYdNm(fullCntrRlseYdInfoVo.getYdNm());
						fullCntrRlseOrdVo.setPhnNo(fullCntrRlseYdInfoVo.getPhnNo());
						fullCntrRlseOrdVo.setFaxNo(fullCntrRlseYdInfoVo.getFaxNo());
					 }
					 // create email body
					 emlCtnt.append(this.makeFullCntrRlseEmlCtnt(fullCntrRlseOrdVo));

					 fullCntrRlseOrdVoHisList.add(fullCntrRlseOrdVo);

				}
				 // create email header
				emlTxt.append(this.makeFullCntrRlseEmlHdr(fullCntrRlseOrdVo, account));
				 // create email body
				emlTxt.append(emlCtnt.toString());
				// create email Signature
				emlTxt.append(this.makeFullCntrRlseEmlSign());


				fullCntrRlseOrderMailSendVo =  new FullCntrRlseOrderMailSendVO();

				if(fullCntrRlseOrdVo != null){
					ObjectCloner.build(fullCntrRlseOrdVo, fullCntrRlseOrderMailSendVo);
				}


				fullCntrRlseOrderMailSendVo.setContent(emlTxt.toString());
				fullCntrRlseOrderMailSendVoList.add(fullCntrRlseOrderMailSendVo);

			}

			fullCntrRlseOrderMailVo.setFullCntrRlseOrdVos(fullCntrRlseOrdVoHisList);
			fullCntrRlseOrderMailVo.setFullCntrRlseOrderMailSendVos(fullCntrRlseOrderMailSendVoList);

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return fullCntrRlseOrderMailVo;
	}


	/**
	 * Sort an Array (compareName) is based on the realignment<br>
	 * <br>
	 * Ex.)<br>
	 * FullCntrRlseOrdVO[] fullCntrRlseOrd = new FullCntrRlseOrdVO[];<br>
	 * sortArray(fullCntrRlseOrd, "ntcEml");<br>
	 *
	 * @param Object[] objects Sort destination
	 * @param String compareName1 Sort Name
	 * @param String compareName2 Sort Name
	 * @return List<Object>
	 * @throws Exception
	 */
	private List<Object> sortArray(Object[] objects, String compareName1, String compareName2) throws Exception {

		List<Object> results = new ArrayList<Object>();

		Object temp = null;
		List<Object> temps = null;
		String str11, str12, str21, str22;
		int i, j, cnt = 0;
		String funcName1 = "";
		String funcName2 = "";


		if (objects == null || objects.length == 0) return null;
		if (compareName1 == null || compareName1.length() == 0) return null;


		if (compareName1.length() > 1) funcName1 = "get" + compareName1.substring(0,1).toUpperCase() + compareName1.substring(1);
		else funcName1 = "get" + compareName1.toUpperCase();

		if (compareName2.length() > 1) funcName2 = "get" + compareName2.substring(0,1).toUpperCase() + compareName2.substring(1);
		else funcName2 = "get" + compareName2.toUpperCase();


		Method meth1 = objects[0].getClass().getMethod(funcName1);
		Method meth2 = objects[0].getClass().getMethod(funcName2);


		for (i=0; i<objects.length; i++)
		{
			str11 = "";
			str12 = "";
			str21 = "";
			str22 = "";
			temps = new ArrayList<Object>();

			for(cnt=0, j=i; j<objects.length; j++)
			{
				if (j == i) {
					str11 = (String) meth1.invoke(objects[i]);
					str12 = (String) meth2.invoke(objects[i]);

					temps.add(objects[j]);
				} else {
					str21 = (String) meth1.invoke(objects[j]);
					str22 = (String) meth2.invoke(objects[j]);

					if (str11.compareTo(str21) == 0 && str12.compareTo(str22) == 0)
					{
						temps.add(objects[j]);

						cnt++;

						temp = objects[i+cnt];
						objects[i+cnt] = objects[j];
						objects[j] = temp;
					}
				}
			}

			results.add(temps);

			i = i + cnt;
		}

		return results;
	}

	/**
	 * Retrieve event handling<br>
	 * Cargo Release Order_E-D / O inquiry _Main viewed on-screen event handling by the shipping<br>
	 *
	 * @param EdoSearchVO edoSearch
	 * @return List<EdoRqstsVO>
	 * @exception EventException
	 */
	public List<EdoCntrRqstsVO> searchEdoCntrRqstList(EdoSearchVO edoSearch) throws EventException {
		try {
			return dbDao.searchEdoCntrRqstList(edoSearch);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * IDA D / O Release handles to delete history
	 *
	 * @param IdaDoCancelVO idaDoCancelVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelIdaDo(IdaDoCancelVO  idaDoCancelVo, SignOnUserAccount account) throws EventException {
		if(JSPUtil.getNull(idaDoCancelVo.getBkgNo()).equals("") )return;

		 try{
			 dbDao.removeDoCntrInfo(idaDoCancelVo.getBkgNo());
			 dbDao.removeDoDtlInfo(idaDoCancelVo.getBkgNo());
			 dbDao.removeDoRefInfo(idaDoCancelVo.getBkgNo());
			 dbDao.removeDoInfo(idaDoCancelVo.getBkgNo());

			 BkgDoHisVO doHis = new BkgDoHisVO();

			 doHis.setBkgNo(idaDoCancelVo.getBkgNo());
			 doHis.setDoCngEvntCd("XX");
			 doHis.setCrntCtnt("X");
			 doHis.setPreCtnt("YES");
			 doHis.setCreUsrId(account.getUsr_id());
			 doHis.setUpdUsrId(account.getUsr_id());
			 doHis.setEvntUsrId(account.getUsr_id());
			 doHis.setEvntOfcCd(account.getOfc_cd());
			 dbDao.addDoHistory(doHis);

		 } catch(DAOException de) {
			 log.error("err " + de.toString(), de);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		 } catch(Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		 }



	}


	/**
	 * VVD
	 *
	 * @param BkgOutstandingVO ots
	 * @exception Exception
	 */
	public void searchOtsUsCgo(BkgOutstandingVO ots) throws Exception {
		try {
			   // Coollection
				 String frtCltFlg = "N";
				 if( "Y".equals( ots.getOtsStlFlg() )||"Y".equals(ots.getCrFlg())){ //배치를 통해 들어온 Settle flag가 Y이거나, credit customer일 경우 Y
					 frtCltFlg = "Y";
				 }

				 FrtCltLstVO frtCltLst = new FrtCltLstVO(); //dbDao.searchBkbcOtsUsCgo(ots);

				 frtCltLst.setBlNo(ots.getCltBlNo());
				 frtCltLst.setEvntOfcCd(ots.getLstCltOfcCd());
				 frtCltLst.setEvntUsrId("BATCH");
				 frtCltLst.setEvntDt(ots.getUpdDt());
				 frtCltLst.setCgorTeamCd("F");
				 frtCltLst.setCgoEvntNm("SAR_FINANCE");
				 frtCltLst.setFrtCltFlg(frtCltFlg);
				 frtCltLst.setCngIndFlg(ots.getCngIndFlg());
				 frtCltLst.setOfcCd(ots.getOfcCd());
				 frtCltLst.setInvNo(ots.getInvNo());

				 if("Y".equals(dbDao.checkScndOtsLstUptValid(ots))){ //여기서 국가 체크및 flag 체크를 해야한다. <<<<<<<<<<<<<<<<<NULL이면 어떻게 될까
					  dbDao.receiveOtsLog("BKG_OTS_RCV", ots.getCltBlNo(), "searchOtsUsCgo:"+ots.getOtsTjSeq());
					this.setupFocByFreight(frtCltLst);

					frtCltLst.setCngIndFlg("N"); //이미 배치가 돈 대상들은 N으로 flag를 찍어 다음 배치가 돌  때 대상으로 잡지 않도록 한다.
					dbDao.modifyCngIndFlg(frtCltLst);
				 }else{
					frtCltLst.setCngIndFlg("X"); //아예 대상이 아니므로 X 찍음
					dbDao.modifyCngIndFlg(frtCltLst);
				 }

			   } catch(EventException ex){
				   log.error("searchOtsUsCgo err " + ex.toString(), ex);
				  throw ex;
			   }catch (Exception ex) {
				   log.error("searchOtsUsCgo err " + ex.toString(), ex);
				  throw new EventException(new ErrorHandler("COM12240")
						   .getMessage(), ex);
			   }

	}


	/**
	 * ESM_BKG_1167 Canada Cargo Release에 대한 List를 Item별로 조회한다.
	 *
	 * @param CaCgoRlseSearchVO searchvo
	 * @return List<CaCgoRlseListVO>
	 * @exception EventException
	 */
	public List<CaCgoRlseListVO> searchCaCgoRlseList(CaCgoRlseSearchVO searchvo) throws EventException {
		List<CaCgoRlseListVO> listVO = null;

		try {
			listVO = dbDao.searchCaCgoRlseList(searchvo);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return listVO;
	}

	/**
	 * ESM_BKG_1167 B/L별 컨테이너 번호를 조회한다.
	 *
	 * @param String bkgNo
	 * @return List<BkgContainerVO>
	 * @exception EventException
	 */
	public List<BkgContainerVO> searchCaCgoRlseFoc(String bkgNo) throws EventException {
		List<BkgContainerVO> listVO = null;

		try {
			listVO = dbDao.searchCaCgoRlseFoc(bkgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return listVO;
	}

	/**
	 * ESM_BKG_1167 Original Bill of Lading Status 조회
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return List<CaCgoRlseBlStatusVO>
	 * @throws EventException
	 */
	public List<CaCgoRlseBlStatusVO>  searchCaCgoRlseBlStatus(String bkgNo, SignOnUserAccount account) throws EventException{
		List<CaCgoRlseBlStatusVO> caCgoRlseBlStatus = null;

		try {
			caCgoRlseBlStatus = (List<CaCgoRlseBlStatusVO>) dbDao.searchCaCgoRlseBlStatus(bkgNo, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return caCgoRlseBlStatus;
	}

	/**
	 * ESM_BKG_1167 Partial 정보가져오기
	 *
	 * @param CaCgoRlseBkbcBlVO caCgoRlseBkbc
	 * @return CaCgoRlseBkbcBlVO
	 * @exception EventException
	 */
	public CaCgoRlseBkbcBlVO searchCaPrtlBl(CaCgoRlseBkbcBlVO caCgoRlseBkbc) throws EventException {

		CaCgoRlseBkbcBlVO cacgoRlseBkbcBL = new CaCgoRlseBkbcBlVO();

		try {
			cacgoRlseBkbcBL = (CaCgoRlseBkbcBlVO) dbDao.searchCaPrtlBl(caCgoRlseBkbc);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return cacgoRlseBkbcBL;
	}



	/**
	 * ESM_BKG_1167 save버튼 저장
	 *
	 * @param BkgCgoRlseVO bkgCgoRlseVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCaCgoRlse(BkgCgoRlseVO bkgCgoRlseVo, SignOnUserAccount account) throws EventException {

		try {
			/***************************
			 * 1. BKG_CGO_RLSE UPDATE.
			 ****************************/
			if (bkgCgoRlseVo != null) {

			   int modRowsByMaster = dbDao.modifyCaCgoRlseEdi(bkgCgoRlseVo, account);

			   if (modRowsByMaster > 0) {// SUCCESS 이면
				   dbDao.addCaCgoRlseHisEdi(bkgCgoRlseVo, account);
			   }

			  /***************************
			   * 2. FOC 관리 시작(EDI 전송)
			   ****************************/
			   new CACargoReleaseOrder().caCgoRlse(bkgCgoRlseVo.getBlNo(), "N", account);
			}
		} catch (EventException ex) {
			if(ex.getMessage().indexOf("BKG40085") > -1  ){
				log.debug("");
			}else{
				log.error("err " + ex.toString(), ex);
			}

			throw ex;

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1167 : Multi TDC315 - Complete IVC click [Back End Job 시작]<br>
	 * transmit Customer information Flat File as EDI (For Canada)
	 * 
	 * @param BkgCgoRlseVO[] bkgCgoRlseVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJobSendCaBlTdc315EdiMulti(BkgCgoRlseVO[] bkgCgoRlseVOs, SignOnUserAccount account) throws EventException {
		CaCgoRlseBackEndJob caCgoRlseBackEndJob = new CaCgoRlseBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			caCgoRlseBackEndJob.setAccount(account);
			caCgoRlseBackEndJob.setMultiSnd("Y");
			caCgoRlseBackEndJob.setBkgCgoRlseVOs(bkgCgoRlseVOs);
			return backEndJobManager.execute(caCgoRlseBackEndJob, account.getUsr_id(), "ESM_BKG_1167 - Multi TDC315");
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1167 : Multi TDC315 - Complete IVC click [Back End Job 결과]<br>
	 * transmit Customer information Flat File as EDI (For Canada)
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobSendCaBlTdc315EdiMulti(String backEndJobKey) throws EventException {
		try {
			return (String)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch(BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1167 Hold 작업을 수행한다.
	 *
	 * @param DoRefVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	public void manageCaCgoRlseHold(DoRefVO[] vos, SignOnUserAccount account) throws EventException {

		try {
			DoRefVO vo = new DoRefVO();


			//D/O HISTORY 생성
			BkgDoHisVO doHis = new BkgDoHisVO();
			log.debug("------------vo.getDoHldFlg() "+vo.getDoHldFlg());

			// 1번만 실행됨.
			for (int i = 0; i < vos.length; i++) {
				vo = vos[i];
				int modRowsByMaster = dbDao.modifyHoldFlgDoRef(vo, account);
				if (modRowsByMaster == 0) {
					dbDao.addHoldFlgDoRef(vo, account);
				}

				//History
				doHis.setCreUsrId(account.getUsr_id());
				doHis.setUpdUsrId(account.getUsr_id());
				if(vo.getDoHldFlg().equals("Y")){
					doHis.setDoCngEvntCd("HC");
				}else if(vo.getDoHldFlg().equals("N")){
					doHis.setDoCngEvntCd("CH");
				}
				doHis.setPreCtnt("NO");
				doHis.setCrntCtnt("YES");
				doHis.setEvntUsrId(account.getUsr_id());
				doHis.setEvntOfcCd(account.getOfc_cd());
				doHis.setBkgNo(vo.getBkgNo());
				dbDao.addDoHistory(doHis);

				break;
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0938 Container 단위로 hold<br>
	 *
	 * @param EuDoRlseVO euDoRlse
	 * @param DoCntrVO doCntrs
	 * @exception EventException
	 */
	public void holdbyCntr(EuDoRlseVO euDoRlse, DoCntrVO doCntrs) throws EventException {
		try {
				doCntrs.setCreUsrId(euDoRlse.getUsrId());
				doCntrs.setUpdUsrId(euDoRlse.getUsrId());

				dbDao.addHoldByCntr(doCntrs);
				
				//history
				BkgDoHisVO doHis = new BkgDoHisVO();
				//History
				doHis.setCreUsrId(euDoRlse.getUsrId());
				doHis.setUpdUsrId(euDoRlse.getUsrId());
				
				doHis.setDoCngEvntCd("HC");
				
				doHis.setPreCtnt("NO");
				doHis.setCrntCtnt("YES " + ": " + doCntrs.getCntrNo());
				doHis.setEvntUsrId(euDoRlse.getUsrId());
				doHis.setEvntOfcCd(euDoRlse.getUsrOfcCd());
				doHis.setBkgNo(doCntrs.getBkgNo());
				dbDao.addDoHistory(doHis);
				
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0938 Container 단위로 hold remove<br>
	 *
	 * @param EuDoRlseVO euDoRlse
	 * @param DoCntrVO doCntrs
	 * @exception EventException
	 */
	public void holdRemovalbyCntr(EuDoRlseVO euDoRlse, DoCntrVO doCntrs) throws EventException {
		try {
			    doCntrs.setCreUsrId(euDoRlse.getUsrId());
		    	doCntrs.setUpdUsrId(euDoRlse.getUsrId());

				dbDao.holdRemovalbyCntr(doCntrs);
				
				//history
				BkgDoHisVO doHis = new BkgDoHisVO();
				//History
				doHis.setCreUsrId(euDoRlse.getUsrId());
				doHis.setUpdUsrId(euDoRlse.getUsrId());
				
				doHis.setDoCngEvntCd("CH");
				
				doHis.setPreCtnt("NO");
				doHis.setCrntCtnt("YES " + ": " + doCntrs.getCntrNo());
				doHis.setEvntUsrId(euDoRlse.getUsrId());
				doHis.setEvntOfcCd(euDoRlse.getUsrOfcCd());
				doHis.setBkgNo(doCntrs.getBkgNo());
				dbDao.addDoHistory(doHis);
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

}