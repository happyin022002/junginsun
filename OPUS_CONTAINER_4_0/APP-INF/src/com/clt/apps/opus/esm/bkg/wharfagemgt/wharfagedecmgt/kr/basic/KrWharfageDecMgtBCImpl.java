/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : KrWharfageDecMgtBCImpl.java
 *@FileTitle : KrWharfageDecMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.25 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.basic.WharfageDecMgtBCImpl;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration.KrWharfageDecMgtDBDAO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgCstmsLocVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgWhfCfmVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrCntrVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrCustVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfAplyPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgKrWhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExpInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCfmVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCgoClassCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgExpSumVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgGenVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCntrExpInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCommInvListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecBzcInfoForApIfVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCheckSendDtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiFfContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiFfVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiVvdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecExptVolVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecIfArInvVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfLocCdListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfRateListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfRateVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoContainerVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVvdDtlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.BlCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.VvdPortEtdEtaVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCgoClassCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfConfirmVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateListCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoCondVO;
import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApInvDtrbVO;
import com.clt.syscommon.common.table.ApInvHdrVO;
import com.clt.syscommon.common.table.BkgCstmsLocVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgKrWhfBlVO;
import com.clt.syscommon.common.table.BkgKrWhfBrthVO;
import com.clt.syscommon.common.table.BkgKrWhfCfmVO;
import com.clt.syscommon.common.table.BkgKrWhfCntrVO;
import com.clt.syscommon.common.table.BkgKrWhfCustVO;
import com.clt.syscommon.common.table.BkgKrWhfPortRtVO;
import com.clt.syscommon.common.table.BkgKrWhfRtVO;
import com.clt.syscommon.common.table.BkgKrWhfVolVO;
import com.clt.syscommon.common.table.BkgKrWhfVvdDtlVO;

/**
 * OPUS-KrWharfageDecMgt Business Logic Command implementation<br>
 * - OPUS-KrWharfageDecMgt handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class KrWharfageDecMgtBCImpl extends WharfageDecMgtBCImpl {


	// Database Access Object
	private transient KrWharfageDecMgtDBDAO  dbDao = null;

	/**
	 * Generating KrWharfageDecMgtBCImpl Object<br>
	 * Generating KrWharfageDecMgtDBDAO<br>
	 */
	public KrWharfageDecMgtBCImpl() {
		dbDao  = new KrWharfageDecMgtDBDAO();
	}


	/**
	 *  Handling retrieving event of Wharfage
	 *
	 * @param WhfBerthCdCondVO whfBerthCdCondVO
	 * @return List<WhfBerthCdVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBerthCdVO> searchWhfBerthCd(WhfBerthCdCondVO whfBerthCdCondVO) throws EventException {

		try {
			List<BkgKrWhfBrthVO> list  = dbDao.searchKrWhfBerthCd((KrWhfBerthCdCondVO)whfBerthCdCondVO);
			List<WhfBerthCdVO>    list2 = new ArrayList<WhfBerthCdVO>();

			KrWhfBerthCdVO krWhfBerthCdVO;
			BkgKrWhfBrthVO bkgKrWhfBrthVO;
			for (Iterator<BkgKrWhfBrthVO> iterator = list.iterator(); iterator.hasNext();) {

				krWhfBerthCdVO = new KrWhfBerthCdVO();
				bkgKrWhfBrthVO = iterator.next();
				ObjectCloner.build(bkgKrWhfBrthVO, krWhfBerthCdVO);
				list2.add(krWhfBerthCdVO);
			}

			return list2;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 *  Handling manage event of Wharfage
	 *
	 * @param List<WhfBerthCdVO> whfBerthCdVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageWhfBerthCd(List<WhfBerthCdVO> whfBerthCdVOs, SignOnUserAccount account) throws EventException {

		try {

			List<BkgKrWhfBrthVO> ilist = new ArrayList<BkgKrWhfBrthVO>();
			List<BkgKrWhfBrthVO> ulist = new ArrayList<BkgKrWhfBrthVO>();
			List<BkgKrWhfBrthVO> dlist = new ArrayList<BkgKrWhfBrthVO>();

			for (Iterator<WhfBerthCdVO> iterator = whfBerthCdVOs.iterator(); iterator.hasNext();) {
				WhfBerthCdVO   whfBerthCdVO   = iterator.next();
				BkgKrWhfBrthVO bkgKrWhfBrthVO = new BkgKrWhfBrthVO();

				ObjectCloner.build(whfBerthCdVO, bkgKrWhfBrthVO);
				bkgKrWhfBrthVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfBrthVO.setUpdUsrId(account.getUsr_id());

				if("I".equals(bkgKrWhfBrthVO.getIbflag()))
					ilist.add(bkgKrWhfBrthVO);
				else if("U".equals(bkgKrWhfBrthVO.getIbflag()))
					ulist.add(bkgKrWhfBrthVO);
				else if("D".equals(bkgKrWhfBrthVO.getIbflag()))
					dlist.add(bkgKrWhfBrthVO);
			}

			if(ilist.size() > 0) dbDao.addBkgKrWhfBrth(ilist);
			if(ulist.size() > 0) dbDao.modifyBkgKrWhfBrth(ulist);
			if(dlist.size() > 0) dbDao.removeBkgKrWhfBrth(dlist);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Wharfage port Rt
	 *
	 * @param WhfPortRtListCondVO whfPortRtListCondVO
	 * @return List<WhfPortRtVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfPortRtVO> searchWhfPortRtList(WhfPortRtListCondVO whfPortRtListCondVO) throws EventException {

		try {
			KrWhfPortRtListCondVO krWhfPortRtListCondVO = (KrWhfPortRtListCondVO)whfPortRtListCondVO;
			List<BkgKrWhfPortRtVO> list  = dbDao.searchKrWhfPortRtList(krWhfPortRtListCondVO);
			List<WhfPortRtVO>      list2 = new ArrayList<WhfPortRtVO>();

			KrWhfPortRtVO krWhfPortRtVO;
			BkgKrWhfPortRtVO bkgKrWhfPortRtVO;
			for (Iterator<BkgKrWhfPortRtVO> iterator = list.iterator(); iterator.hasNext();) {

				krWhfPortRtVO = new KrWhfPortRtVO();
				bkgKrWhfPortRtVO = iterator.next();
				ObjectCloner.build(bkgKrWhfPortRtVO, krWhfPortRtVO);
				list2.add(krWhfPortRtVO);
			}

			return list2;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 *  Handling manage event of Wharfage port Rt
	 *
	 * @param WhfPortRtVO[] whfPortRtVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageWhfPortRt(WhfPortRtVO[] whfPortRtVOs, SignOnUserAccount account) throws EventException {

		try {
			List<BkgKrWhfPortRtVO> checklist = null;
			List<BkgKrWhfPortRtVO> ilist = new ArrayList<BkgKrWhfPortRtVO>();
			List<BkgKrWhfPortRtVO> ulist = new ArrayList<BkgKrWhfPortRtVO>();
			List<BkgKrWhfPortRtVO> dlist = new ArrayList<BkgKrWhfPortRtVO>();

			for (int i = 0; i < whfPortRtVOs.length; i++) {
				WhfPortRtVO   whfPortRtVO   = whfPortRtVOs[i];
				BkgKrWhfPortRtVO bkgKrWhfPortRtVO = new BkgKrWhfPortRtVO();

				ObjectCloner.build(whfPortRtVO, bkgKrWhfPortRtVO);
				bkgKrWhfPortRtVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfPortRtVO.setUpdUsrId(account.getUsr_id());

				if("I".equals(bkgKrWhfPortRtVO.getIbflag()))
					ilist.add(bkgKrWhfPortRtVO);
				else if("U".equals(bkgKrWhfPortRtVO.getIbflag()))
					ulist.add(bkgKrWhfPortRtVO);
				else if("D".equals(bkgKrWhfPortRtVO.getIbflag()))
					dlist.add(bkgKrWhfPortRtVO);
			}

			if(ilist.size() > 0){
				checklist = dbDao.checkIfPortRate(ilist);
				if (checklist == null){
					dbDao.addBkgKrWhfPortRt(ilist);
				}else{
					BkgKrWhfPortRtVO bkgKrWhfPortRtVO = checklist.get(0);

					throw new EventException(new ErrorHandler("BKG06014",new String[]{bkgKrWhfPortRtVO.getCntrBlkDivCd() + ", " +
																					  bkgKrWhfPortRtVO.getPortCd()       + ", " +
																					  bkgKrWhfPortRtVO.getIoBndCd()      + ", " +
																					  bkgKrWhfPortRtVO.getDcRtoNo()      + "%인 데이터가 이미 존재합니다." }).getMessage());

				}
			}
			if(ulist.size() > 0) dbDao.modifyBkgKrWhfPortRt(ulist);
			if(dlist.size() > 0) dbDao.removeBkgKrWhfPortRt(dlist);

		}catch(EventException ex){
			throw ex;
		}catch(DAOException dx) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), dx);
		}
	}

	/**
	 *  Handling retrieving event of Wharfage chg
	 *
	 * @param WhfChgListCondVO whfChgListCondVO
	 * @return List<WhfChgVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfChgVO> searchWhfChgList(WhfChgListCondVO whfChgListCondVO) throws EventException {

		try {

			List<WhfChgVO> whfChgVOs = new ArrayList<WhfChgVO>();
			KrWhfChgContainerVO krWhfChgContainerVO = new KrWhfChgContainerVO();
			KrWhfChgListCondVO krWhfChgListCondVO = (KrWhfChgListCondVO)whfChgListCondVO;

			VvdPortEtdEtaVO        vvdPortEtdEtaVO = dbDao.searchVvdPortEtdEta(krWhfChgListCondVO.getVvd(), ("S".equals(krWhfChgListCondVO.getBkgCustTpCd()) ? krWhfChgListCondVO.getPolCd() : krWhfChgListCondVO.getPodCd()));
			List<KrWhfChgVO>       list1 = dbDao.searchKrWhfChgList(krWhfChgListCondVO);
			List<KrWhfChgGenVO>    list2 = dbDao.searchKrWhfChgListGenSum(krWhfChgListCondVO);
			List<KrWhfChgExpSumVO> list3 = dbDao.searchKrWhfChgListExpSum(krWhfChgListCondVO);
			BkgKrWhfCfmVO bkgKrWhfCfmVO  = dbDao.searchKrWhfCfmInfo(krWhfChgListCondVO);

			krWhfChgContainerVO.setVvdPortEtdEtaVO(vvdPortEtdEtaVO);
			krWhfChgContainerVO.setKrWhfChgVOs(list1);
			krWhfChgContainerVO.setKrWhfChgGenVOs(list2);
			krWhfChgContainerVO.setKrWhfChgExpSumVOs(list3);
			krWhfChgContainerVO.setKrWhfCfmVO((KrWhfCfmVO)bkgKrWhfCfmVO);

			whfChgVOs.add((WhfChgVO)krWhfChgContainerVO);

			return whfChgVOs;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of Wharfage vsl
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO
	 * @return WhfVslInfoVO
	 * @throws EventException
	 */
	@Override
	public WhfVslInfoVO searchWhfVslEtdMrn(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException {

		try {
			BookingUtil utilCmd = new BookingUtil();
			KrWhfVslInfoCondVO krWhfVslInfoCondVO = (KrWhfVslInfoCondVO)whfVslInfoCondVO;
			KrWhfVslInfoContainerVO krWhfVslInfoContainerVO = new KrWhfVslInfoContainerVO();

			KrWhfVslInfoVO krWhfVslInfoVO = dbDao.searchKrWhfVslEtdMrn(krWhfVslInfoCondVO);

			if(! "".equals(krWhfVslInfoCondVO.getVpsPortCd())) {
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("KR_WHF_VSL_INFO");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1(krWhfVslInfoCondVO.getVpsPortCd());
				List<BkgHrdCdgCtntVO> bkgHrdCdgCntnVOs = utilCmd.searchHardCoding(bkgHrdCdgCtntListCondVO);
				if (bkgHrdCdgCntnVOs.size() > 0) {
					if (krWhfVslInfoVO == null) {
						krWhfVslInfoVO = new KrWhfVslInfoVO();
						krWhfVslInfoVO.setMrnChkNo("");
						krWhfVslInfoVO.setMrnNo("");
						krWhfVslInfoVO.setVpsDt("");
					}

					krWhfVslInfoVO.setTmlCd(bkgHrdCdgCntnVOs.get(0).getAttrCtnt5());
					if (bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().length() == 7) {
//						log.debug("bkgHrdCdgCntnVOs.get(0).getAttrCtnt2()=[" + bkgHrdCdgCntnVOs.get(0).getAttrCtnt2() + "]");
						krWhfVslInfoVO.setUnldAgnCd1(bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().substring(0, 2));
						krWhfVslInfoVO.setUnldAgnCd2(bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().substring(2, 3));
						krWhfVslInfoVO.setUnldAgnCd3(bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().substring(3));
					}
//					log.debug("krWhfVslInfoCondVO.getIoBndCd().substring(0,1)=[" + krWhfVslInfoCondVO.getIoBndCd().substring(0,1) + "]");
					if (krWhfVslInfoCondVO.getIoBndCd().substring(0,1).equals("O")) {
						krWhfVslInfoVO.setWhfRt(bkgHrdCdgCntnVOs.get(0).getAttrCtnt4());
					}
					else {
						krWhfVslInfoVO.setWhfRt(bkgHrdCdgCntnVOs.get(0).getAttrCtnt3());
					}
				}
				krWhfVslInfoContainerVO.setKrWhfVslInfoVO(krWhfVslInfoVO);

				List<KrWhfVslInfoVO> krWhfVslInfoVOs = dbDao.searchKrWhfWharfList(krWhfVslInfoCondVO);
				krWhfVslInfoContainerVO.setKrWhfVslInfoVOs(krWhfVslInfoVOs);
			}



			return krWhfVslInfoContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

	}


	/**
	 *  Handling retrieving event of Wharfage vsl info
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO
	 * @return WhfVslInfoVO
	 * @throws EventException
	 */
	@Override
	public WhfVslInfoVO searchWhfVslInfo(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException {
		try {
			WhfVslInfoVO whfVslInfoVO = null;
			whfVslInfoVO = dbDao.searchKrWhfVslInfo((KrWhfVslInfoCondVO)whfVslInfoCondVO);

			if(whfVslInfoVO == null)
				whfVslInfoVO = dbDao.searchKrWhfDfltVslInfo((KrWhfVslInfoCondVO)whfVslInfoCondVO);

			return whfVslInfoVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 *  Handling manageW event of Wharfage vsl info
	 *
	 * @param WhfVslInfoVO whfVslInfoVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageWhfVslInfo(WhfVslInfoVO whfVslInfoVO, SignOnUserAccount account) throws EventException {
		try {
			//WhfVslInfoVO whfVslInfoVO = null;
			List<BkgKrWhfVolVO> bkgKrWhfVolVOs = null;
			BkgKrWhfVolVO bkgKrWhfVolVO = null;
			KrWhfVslInfoVO krWhfVslInfoVO = (KrWhfVslInfoVO)whfVslInfoVO ;
			String vvd = krWhfVslInfoVO.getVvd();
			String vslCd    = vvd.substring(0, 4);
			String skdVoyNo = vvd.substring(4, 8);
			String skdDirCd = vvd.substring(8, 9);

			//CHECK VVD
			Boolean boolean1 = dbDao.checkIfVvdExist(vslCd, skdVoyNo, skdDirCd);

			if (boolean1 == true){

				bkgKrWhfVolVOs = new ArrayList<BkgKrWhfVolVO>();
				bkgKrWhfVolVO = new BkgKrWhfVolVO();
				ObjectCloner.build(krWhfVslInfoVO, bkgKrWhfVolVO);

				bkgKrWhfVolVO.setVslCd(vslCd);
				bkgKrWhfVolVO.setSkdVoyNo(skdVoyNo);
				bkgKrWhfVolVO.setSkdDirCd(skdDirCd);
				bkgKrWhfVolVO.setWhfBndCd(krWhfVslInfoVO.getWhfBndCd());
				bkgKrWhfVolVO.setUnldAgnCd(krWhfVslInfoVO.getUnldAgnCd1() + krWhfVslInfoVO.getUnldAgnCd2() + krWhfVslInfoVO.getUnldAgnCd3());
				bkgKrWhfVolVO.setWhfPayDt(krWhfVslInfoVO.getWhfPayDt().replace("-", ""));
				bkgKrWhfVolVO.setMfRefNo(krWhfVslInfoVO.getMrnNo());
				bkgKrWhfVolVO.setSailDt(krWhfVslInfoVO.getVpsDt().replaceAll("-", ""));

				bkgKrWhfVolVO.setVslNm(krWhfVslInfoVO.getVslNm());
				bkgKrWhfVolVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());

				String[] whfBndCd = new String[2];

				if ("II".equals(krWhfVslInfoVO.getWhfBndCd())){

					whfBndCd[0] = "II";
					whfBndCd[1] = "IT";
				}else if ("OO".equals(krWhfVslInfoVO.getWhfBndCd())){
					whfBndCd[0] = "OO";
					whfBndCd[1] = "OT";
				}
				for (int i = 0; i < whfBndCd.length; i++) {
					bkgKrWhfVolVO.setWhfBndCd(whfBndCd[i]);
					bkgKrWhfVolVOs.add(bkgKrWhfVolVO);
					dbDao.addBkgKrWhfVol(bkgKrWhfVolVOs);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * Retrieving KOREA WHF BL List
	 *
	 * @param WhfBlListCondVO whfBlListCondVO
	 * @return List<WhfBlVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBlVO> searchWhfBlList(WhfBlListCondVO whfBlListCondVO) throws EventException {
		KrWhfBlListCondVO krWhfBlListCondVO = (KrWhfBlListCondVO) whfBlListCondVO;
		log.info("krWhfBlListCondVO.getVvd()=[" + krWhfBlListCondVO.getVvd() + "]");
		log.info("krWhfBlListCondVO.getWhfPolCd()=[" + krWhfBlListCondVO.getWhfPolCd() + "]");
		log.info("krWhfBlListCondVO.getWhfBndCd()=[" + krWhfBlListCondVO.getWhfBndCd() + "]");
		try {
			String krWhfExistFlg = dbDao.searchKrWhfBlExistFlg(krWhfBlListCondVO);
			log.info("krWhfExistFlg=[" + krWhfExistFlg + "]");
			if ("Y".equals(krWhfExistFlg)) {
				throw new EventException(new ErrorHandler("BKG06063", new String[]{
						krWhfBlListCondVO.getVvd(),
						krWhfBlListCondVO.getWhfPolCd(),
						krWhfBlListCondVO.getWhfBndCd()}).getMessage());
			}

			List<KrWhfBlVO> list = dbDao.searchKrWhfBlList(krWhfBlListCondVO);
			WhfBlVO whfBlVO = null;
			List<WhfBlVO> list2 = new ArrayList<WhfBlVO>();
			if(list != null){
				for (Iterator<KrWhfBlVO> iterator = list.iterator(); iterator.hasNext();) {
					KrWhfBlVO krWhfBlVO = iterator.next();
					whfBlVO = (WhfBlVO)krWhfBlVO;
					list2.add(whfBlVO);
				}
			}
			return list2;

		} catch(DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * Handling Retrieving event of Wharfage Location Code
	 *
	 * @param WhfLocCdListCondVO whfLocCdListCondVO
	 * @return List<WhfLocCdVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfLocCdVO> searchWhfLocCdList(WhfLocCdListCondVO whfLocCdListCondVO) throws EventException {
		try {
			List<BkgCstmsLocVO> list = dbDao.searchKrWhfLocCdList((KrWhfLocCdListCondVO)whfLocCdListCondVO);
			WhfLocCdVO whfLocCdVO = null;
			KrBkgCstmsLocVO krBkgCstmsLocVO = null;
			List<WhfLocCdVO> list2 = new ArrayList<WhfLocCdVO>();

			if(list != null){
				for (Iterator<BkgCstmsLocVO> iterator = list.iterator(); iterator.hasNext();) {
					BkgCstmsLocVO bkgCstmsLocVO = iterator.next();
					krBkgCstmsLocVO = new KrBkgCstmsLocVO();
					ObjectCloner.build(bkgCstmsLocVO, krBkgCstmsLocVO);

					krBkgCstmsLocVO.setOlocCd(bkgCstmsLocVO.getLocCd());
					krBkgCstmsLocVO.setOunLocId(bkgCstmsLocVO.getUnLocId());

					whfLocCdVO = (WhfLocCdVO)krBkgCstmsLocVO;
					list2.add(whfLocCdVO);
				}
			}
			return list2;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage Location Code
	 *
	 * @param List<WhfLocCdVO> whfLocCdVOs Wharfage Location Code
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageWhfLocCd(List<WhfLocCdVO> whfLocCdVOS, SignOnUserAccount account) throws EventException {

		try {

			List<KrBkgCstmsLocVO> ilist = new ArrayList<KrBkgCstmsLocVO>();
			List<KrBkgCstmsLocVO> ulist = new ArrayList<KrBkgCstmsLocVO>();
			List<KrBkgCstmsLocVO> dlist = new ArrayList<KrBkgCstmsLocVO>();

			for (Iterator<WhfLocCdVO> iterator = whfLocCdVOS.iterator(); iterator.hasNext();) {
				WhfLocCdVO   whfLocCdVO   = iterator.next();
				KrBkgCstmsLocVO krBkgKrWhfBrthVO =  (KrBkgCstmsLocVO)whfLocCdVO;

				krBkgKrWhfBrthVO.setCreUsrId(account.getUsr_id());
				krBkgKrWhfBrthVO.setUpdUsrId(account.getUsr_id());

				if("I".equals(krBkgKrWhfBrthVO.getIbflag()))
					ilist.add(krBkgKrWhfBrthVO);
				else if("U".equals(krBkgKrWhfBrthVO.getIbflag()))
					ulist.add(krBkgKrWhfBrthVO);
				else if("D".equals(krBkgKrWhfBrthVO.getIbflag()))
					dlist.add(krBkgKrWhfBrthVO);
			}

			if(ilist.size() > 0) dbDao.addBkgCstmsLoc(ilist);
			if(ulist.size() > 0) dbDao.modifyBkgCstmsLoc(ulist);
			if(dlist.size() > 0) dbDao.deleteBkgCstmsLoc(dlist);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}


	/**
	 * Wharfage confirm event
	 *
	 * @param WhfConfirmVO whfConfirmVO Wharfage
	 * @param SignOnUserAccount account
	 * @return BkgKrWhfCfmVO
	 * @throws EventException
	 */
	@Override
	public BkgKrWhfCfmVO makeWhfConfirm(WhfConfirmVO whfConfirmVO, SignOnUserAccount account) throws EventException {
		BkgKrWhfCfmVO outBkgKrWhfCfmVO = null;

		try {

			KrBkgWhfCfmVO krBkgWhfCfmVO = (KrBkgWhfCfmVO)whfConfirmVO;
			BkgKrWhfCfmVO bkgKrWhfCfmVO = new BkgKrWhfCfmVO();
			String sVvd = krBkgWhfCfmVO.getVvd();
			bkgKrWhfCfmVO.setVslCd(sVvd.substring(0, 4));
			bkgKrWhfCfmVO.setSkdVoyNo(sVvd.substring(4, 8));
			bkgKrWhfCfmVO.setSkdDirCd(sVvd.substring(8, 9));

			if("S".equals(krBkgWhfCfmVO.getBkgCustTpCd()))
				bkgKrWhfCfmVO.setPortCd(krBkgWhfCfmVO.getPolCd());
			else
				bkgKrWhfCfmVO.setPortCd(krBkgWhfCfmVO.getPodCd());

			bkgKrWhfCfmVO.setWhfBndCd(krBkgWhfCfmVO.getBkgCustTpCd());
			bkgKrWhfCfmVO.setCfmUsrId(account.getUsr_nm());
			bkgKrWhfCfmVO.setCreUsrId(account.getUsr_id());
			bkgKrWhfCfmVO.setUpdUsrId(account.getUsr_id());

			Boolean boolean1 = dbDao.checkWhfConfirm(bkgKrWhfCfmVO);

			if (boolean1 == true){
				dbDao.addBkgKrWhfCfm(bkgKrWhfCfmVO);

				KrWhfChgListCondVO krWhfChgListCondVO = new KrWhfChgListCondVO();
				krWhfChgListCondVO.setVvd(bkgKrWhfCfmVO.getVslCd() +
						bkgKrWhfCfmVO.getSkdVoyNo() +
						bkgKrWhfCfmVO.getSkdDirCd());
				krWhfChgListCondVO.setBkgCustTpCd(krBkgWhfCfmVO.getBkgCustTpCd());
				krWhfChgListCondVO.setPolCd(krBkgWhfCfmVO.getPolCd());
				krWhfChgListCondVO.setPodCd(krBkgWhfCfmVO.getPodCd());

				outBkgKrWhfCfmVO = dbDao.searchKrWhfCfmInfo(krWhfChgListCondVO);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return outBkgKrWhfCfmVO;
	}



	/**
	 * handling retrieving event of B/L info
	 *
	 * @param BlCondVO blCondVO
	 * @return BlVO
	 * @throws EventException
	 */
	@Override
	public BlVO searchBl(BlCondVO blCondVO) throws EventException {

		try {

			KrBlContainerVO krBlContainerVO = new KrBlContainerVO();

			KrBlCondVO krBlCondVO = (KrBlCondVO)blCondVO;
			KrBlVO krBlVO            = dbDao.searchKrBl(krBlCondVO);
			List<KrCntrVO> krCntrVOs = dbDao.searchKrCntr(krBlCondVO);
			List<KrCustVO> krCustVOs = dbDao.searchKrCust(krBlCondVO);


			krBlContainerVO.setKrBlVO(krBlVO);
			krBlContainerVO.setKrCntrVOs(krCntrVOs);
			krBlContainerVO.setKrCustVOs(krCustVOs);

			return krBlContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

	}


	/**
	 * handling retrieving event WHF charge code
	 *
	 * @param WhfRateListCondVO whfRateListCondVO
	 * @return List<WhfRateVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfRateVO> searchWhfRateList(WhfRateListCondVO whfRateListCondVO) throws EventException {

		try {

			List<WhfRateVO> list = new ArrayList<WhfRateVO>();
			List<KrWhfRateVO> krWhfRateVOs = dbDao.searchKrWhfRateList((KrWhfRateListCondVO)whfRateListCondVO);
			for (Iterator<KrWhfRateVO> iterator = krWhfRateVOs.iterator(); iterator.hasNext();) {
				WhfRateVO whfRateVO = (WhfRateVO) iterator.next();
				list.add(whfRateVO);
			}

			return list;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * handling retrieving event WHF charge
	 *
	 * @param WhfBlChkListCondVO whfBlChkListCondVO
	 * @return List<WhfBlChkVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBlChkVO> searchWhfBlChkList(WhfBlChkListCondVO whfBlChkListCondVO) throws EventException {
		try {
			return dbDao.searchKrWhfBlChkList((KrWhfBlChkListCondVO)whfBlChkListCondVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * manage WHF BL info
	 *
	 * @param WhfBlVO[] whfBlVOs WHF BL 정보
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageWhfBl(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {
		try {
			//GeneralEventResponse eventResponse = new GeneralEventResponse();
			KrWhfBlContainerVO krWhfBlContainerVO = (KrWhfBlContainerVO)whfBlVOs[0];

		if(!"EsmBkg0122Event".equals(krWhfBlContainerVO.getSvcGubunId()))	{

			KrWhfVslInfoCondVO krWhfVslInfoCondVO = krWhfBlContainerVO.getKrWhfVslInfoCondVO();

			if (whfBlVOs != null) {
				String sVslCd    = "";
				String sSkdVoyNo = "";
				String sSkdDirCd = "";
				String sBlNo     = "";
				String sPortCd   = "";
				String sWhfBndCd = "";

				KrWhfBkgInfoVO krWhfBkgInfoVO = dbDao.searchBkgInfo(krWhfBlContainerVO.getKrWhfBkgInfoCondVO());



				KrWhfBkgKrWhfBlVO[] arry = krWhfBlContainerVO.getKrWhfBkgKrWhfBlVOs();
				List<KrWhfBkgKrWhfBlVO> list = new ArrayList<KrWhfBkgKrWhfBlVO>();
				for (int i = 0; i < arry.length; i++) {
					arry[i].setCreUsrId(account.getUsr_id());
					arry[i].setUpdUsrId(account.getUsr_id());

					arry[i].setPckQty(arry[i].getPckQty().replaceAll(",", ""));
					arry[i].setMeasQty(arry[i].getMeasQty().replaceAll(",", ""));
					arry[i].setActWgt(arry[i].getActWgt().replaceAll(",", ""));
					arry[i].setRevenue(arry[i].getRevenue().replaceAll(",", ""));
					arry[i].setWhfBlThruTsFlg(krWhfBkgInfoVO.getWhfBlThruTsFlg());
					arry[i].setBkgCgoTpCd(krWhfBkgInfoVO.getBkgCgoTpCd());
					arry[i].setObSlsOfcCd(krWhfBkgInfoVO.getObSlsOfcCd());
					arry[i].setSlanCd(krWhfBkgInfoVO.getSlanCd());

					sVslCd    = arry[i].getVslCd();
					sSkdVoyNo = arry[i].getSkdVoyNo();
					sSkdDirCd = arry[i].getSkdDirCd();
					sBlNo     = arry[i].getBlNo();
					sPortCd   = arry[i].getPortCd();
					sWhfBndCd = arry[i].getWhfBndCd();
					list.add(arry[i]);
				}

				krWhfVslInfoCondVO.setPortCd(sPortCd);
				krWhfVslInfoCondVO.setVvd(sVslCd + sSkdVoyNo + sSkdDirCd);
				krWhfVslInfoCondVO.setWhfBndCd(sWhfBndCd);

				if(! dbDao.checkIfDecNoExist(krWhfVslInfoCondVO)){
					dbDao.mergeBkgKrWhfBl(list);


					BkgKrWhfCustVO[] bkgKrWhfCustVOs = krWhfBlContainerVO.getBkgKrWhfCustVOs();

					if(bkgKrWhfCustVOs != null){
						List<BkgKrWhfCustVO> ilist = new ArrayList<BkgKrWhfCustVO>();
						List<BkgKrWhfCustVO> dlist = new ArrayList<BkgKrWhfCustVO>();

						BkgKrWhfCustVO bkgKrWhfCustVO = new BkgKrWhfCustVO();
						bkgKrWhfCustVO.setBlNo(sBlNo);
						bkgKrWhfCustVO.setVslCd(sVslCd);
						bkgKrWhfCustVO.setSkdVoyNo(sSkdVoyNo);
						bkgKrWhfCustVO.setSkdDirCd(sSkdDirCd);
						dlist.add(bkgKrWhfCustVO);
						if(dlist.size() > 0) dbDao.removeBkgKrWhfCust(dlist);

						for (int i = 0; i < bkgKrWhfCustVOs.length; i++) {

							if("I".equals(bkgKrWhfCustVOs[i].getIbflag()) || "U".equals(bkgKrWhfCustVOs[i].getIbflag())){
								bkgKrWhfCustVOs[i].setVslCd(sVslCd);
								bkgKrWhfCustVOs[i].setSkdVoyNo(sSkdVoyNo);
								bkgKrWhfCustVOs[i].setSkdDirCd(sSkdDirCd);
								bkgKrWhfCustVOs[i].setBlNo(sBlNo);
								bkgKrWhfCustVOs[i].setCreUsrId(account.getUsr_id());
								bkgKrWhfCustVOs[i].setUpdUsrId(account.getUsr_id());
								ilist.add(bkgKrWhfCustVOs[i]);
							}
						}
						if(ilist.size() > 0) dbDao.addBkgKrWhfCust(ilist);
					}

					BkgKrWhfCntrVO[] bkgKrWhfCntrVOs = krWhfBlContainerVO.getBkgKrWhfCntrVOs();

					if(bkgKrWhfCntrVOs != null){
						List<BkgKrWhfCntrVO> ilist2 = new ArrayList<BkgKrWhfCntrVO>();
						List<BkgKrWhfCntrVO> dlist2 = new ArrayList<BkgKrWhfCntrVO>();

						BkgKrWhfCntrVO bkgKrWhfCntrVO = new BkgKrWhfCntrVO();
						bkgKrWhfCntrVO.setBlNo(sBlNo);
						bkgKrWhfCntrVO.setVslCd(sVslCd);
						bkgKrWhfCntrVO.setSkdVoyNo(sSkdVoyNo);
						bkgKrWhfCntrVO.setSkdDirCd(sSkdDirCd);
						dlist2.add(bkgKrWhfCntrVO);
						if(dlist2.size() > 0) dbDao.removeBkgKrWhfCntr(dlist2);

						for (int i = 0; i < bkgKrWhfCntrVOs.length; i++) {

							if("I".equals(bkgKrWhfCntrVOs[i].getIbflag()) || "U".equals(bkgKrWhfCntrVOs[i].getIbflag())){
								bkgKrWhfCntrVOs[i].setVslCd(sVslCd);
								bkgKrWhfCntrVOs[i].setSkdVoyNo(sSkdVoyNo);
								bkgKrWhfCntrVOs[i].setSkdDirCd(sSkdDirCd);
								bkgKrWhfCntrVOs[i].setBlNo(sBlNo);
								bkgKrWhfCntrVOs[i].setCreUsrId(account.getUsr_id());
								bkgKrWhfCntrVOs[i].setUpdUsrId(account.getUsr_id());
								ilist2.add(bkgKrWhfCntrVOs[i]);
							}
						}
						if(ilist2.size() > 0) dbDao.addBkgKrWhfCntr(ilist2);
					}
				}
				else
				{
					throw new EventException(new ErrorHandler("BKG06103", new String[] {}).getMessage());
				}


			}
		} else {
			KrWhfVslInfoCondVO krWhfVslInfoCondVO = krWhfBlContainerVO.getKrWhfVslInfoCondVO();
			BkgKrWhfVolVO bkgKrWhfVolVO           = krWhfBlContainerVO.getBkgKrWhfVolVO();
			KrWhfBlInfoVO[] krWhfBlInfoVOs        = krWhfBlContainerVO.getKrWhfBlInfoVOs();
			if(! dbDao.checkIfDecNoExist(krWhfVslInfoCondVO)){

				String sVvd = krWhfVslInfoCondVO.getVvd();
				bkgKrWhfVolVO.setVslCd(sVvd.substring(0, 4));
				bkgKrWhfVolVO.setSkdVoyNo(sVvd.substring(4, 8));
				bkgKrWhfVolVO.setSkdDirCd(sVvd.substring(8, 9));
				bkgKrWhfVolVO.setRtonWgt(bkgKrWhfVolVO.getRtonWgt().replace(",", ""));
				bkgKrWhfVolVO.setWhfRtAmt(bkgKrWhfVolVO.getWhfRtAmt().replace(",", ""));
				bkgKrWhfVolVO.setExptTonWgt(bkgKrWhfVolVO.getExptTonWgt().replace(",", ""));
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
				List<BkgKrWhfVolVO> list = new ArrayList<BkgKrWhfVolVO>();
				list.add(bkgKrWhfVolVO);
				dbDao.modifyBkgKrWhfVol(list);

				KrWhfBlInfoVO krWhfBlInfoVO   = new KrWhfBlInfoVO();
				KrWhfVslInfoVO krWhfVslInfoVO = new KrWhfVslInfoVO();
				String sPortOfcCd = dbDao.searchPortOfc(krWhfVslInfoCondVO.getPortCd());
				List< BkgKrWhfBlVO > bkgKrWhfBlVOs = new ArrayList<BkgKrWhfBlVO>();
				for (int i = 0; i < krWhfBlInfoVOs.length; i++) {

					krWhfBlInfoVO = krWhfBlInfoVOs[i];
					krWhfVslInfoCondVO.setBlNo (krWhfBlInfoVO.getBlNo());
					krWhfVslInfoVO = dbDao.searchLastKrWhfRtInfo(krWhfVslInfoCondVO);
					if (krWhfVslInfoVO != null) {
						if("D".equals(krWhfBlInfoVO.getIbflag()) && "Y".equals(krWhfVslInfoVO.getArIfFlg())){
							continue ;
						}
					}

					BkgKrWhfBlVO bkgKrWhfBlVO = new BkgKrWhfBlVO();

					bkgKrWhfBlVO.setVslCd(sVvd.substring(0, 4));
					bkgKrWhfBlVO.setSkdVoyNo(sVvd.substring(4, 8));
					bkgKrWhfBlVO.setSkdDirCd(sVvd.substring(8, 9));
					bkgKrWhfBlVO.setWhfBndCd(krWhfBlInfoVO.getWhfBndCd());
					bkgKrWhfBlVO.setBlNo(krWhfBlInfoVO.getBlNo());


					bkgKrWhfBlVO.setPolCd(krWhfBlInfoVO.getPolCd());
					bkgKrWhfBlVO.setPodCd(krWhfBlInfoVO.getPodCd());
					bkgKrWhfBlVO.setWfgExptCd(krWhfBlInfoVO.getWfgExptCd());
					bkgKrWhfBlVO.setCustRgstNo(krWhfBlInfoVO.getCustRgstNo());
					bkgKrWhfBlVO.setWgtQty(krWhfBlInfoVO.getWgtQty());
					bkgKrWhfBlVO.setMeasQty(krWhfBlInfoVO.getMeasQty());
					bkgKrWhfBlVO.setCstmsDeclTpCd(krWhfBlInfoVO.getT());

					if("D".equals(krWhfBlInfoVO.getIbflag()))
						bkgKrWhfBlVO.setWhfBlStsCd("D");

					bkgKrWhfBlVO.setRtonWgt(krWhfBlInfoVO.getRtonWgt());
					bkgKrWhfBlVO.setWhfAmt (krWhfBlInfoVO.getWhfAmt());
					bkgKrWhfBlVO.setCmdtCd (krWhfBlInfoVO.getCmdtCd());
					bkgKrWhfBlVO.setPckTpCd(krWhfBlInfoVO.getWhfPckTpCd());
					bkgKrWhfBlVO.setUpdUsrId(account.getUsr_id());

					bkgKrWhfBlVOs.add(bkgKrWhfBlVO);

/*					if (null != krWhfVslInfoVO){
						newChgAmt = krWhfVslInfoVO.getNewChgAmt();
						chgRtSeq  = krWhfVslInfoVO.getChgRtSeq();
					}else{
						newChgAmt = "0";
						chgRtSeq  = "1";
					}*/
					String chgRtSeq = "";
					String oldChgAmt = "";
					if (krWhfVslInfoVO != null) {
						chgRtSeq  = krWhfVslInfoVO.getChgRtSeq();
						oldChgAmt = krWhfVslInfoVO.getNewChgAmt();
					}
					String newChgAmt = krWhfBlInfoVO.getWhfAmt();
					float diffAmt = (Float.parseFloat(newChgAmt) - Float.parseFloat(oldChgAmt));

					List<BkgKrWhfRtVO> bkgKrWhfRtVOs = new ArrayList<BkgKrWhfRtVO>();
					List<BkgKrWhfRtVO> bkgKrWhfRtVOs2 = new ArrayList<BkgKrWhfRtVO>();
					BkgKrWhfRtVO bkgKrWhfRtVO        = new BkgKrWhfRtVO();
//					if(newChgAmt.equals(oldWhfAmt)){

					// diffAmt이 정수이거나 chgRtSeq가 0보다 크면
					if (Float.compare(diffAmt, (int)diffAmt) == 0 && Integer.parseInt(chgRtSeq) > 0) {
						bkgKrWhfRtVO.setPortOfcCd(sPortOfcCd);
						bkgKrWhfRtVO.setCmdtCd  (krWhfBlInfoVO.getCmdtCd());
						bkgKrWhfRtVO.setBlCustNm(krWhfBlInfoVO.getCustNm());
						bkgKrWhfRtVO.setTaxCustNm("");
						bkgKrWhfRtVO.setKrWhfExptCd(krWhfBlInfoVO.getWfgExptCd());
						bkgKrWhfRtVO.setDeclRmk    (krWhfBlInfoVO.getCustRgstNo());

						if (krWhfBlInfoVO.getWfgExptCd().equals("S") ||
							krWhfBlInfoVO.getWfgExptCd().equals("D") ||
							krWhfBlInfoVO.getWfgExptCd().equals("X") ||
							krWhfBlInfoVO.getWfgExptCd().equals("I") ||
							krWhfBlInfoVO.getWfgExptCd().equals("J") ||
							krWhfBlInfoVO.getWfgExptCd().equals("K")) {
							bkgKrWhfRtVO.setTaxTeuQty  ("0");
							bkgKrWhfRtVO.setTaxFeuQty  ("0");
							bkgKrWhfRtVO.setTax45ftQty ("0");

							bkgKrWhfRtVO.setExptTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setExptFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setExpt45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());
						}
						else {
							bkgKrWhfRtVO.setTaxTeuQty  (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setTaxFeuQty  (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setTax45ftQty (krWhfBlInfoVO.getWhfCntr45ftQty());

							bkgKrWhfRtVO.setExptTeuQty ("0");
							bkgKrWhfRtVO.setExptFeuQty ("0");
							bkgKrWhfRtVO.setExpt45ftQty("0");
						}


						bkgKrWhfRtVO.setCntrTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
						bkgKrWhfRtVO.setCntrFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
						bkgKrWhfRtVO.setCntr45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());

						bkgKrWhfRtVO.setCntrTpszTeuQty (krWhfBlInfoVO.getWhfBkg20ftQty());
						bkgKrWhfRtVO.setCntrTpszFeuQty (krWhfBlInfoVO.getWhfBkg40ftQty());
						bkgKrWhfRtVO.setCntrTpsz45ftQty(krWhfBlInfoVO.getWhfBkg45ftQty());



						bkgKrWhfRtVO.setBlkTeuQty (krWhfBlInfoVO.getWhfBlk20ftQty());
						bkgKrWhfRtVO.setBlkFeuQty (krWhfBlInfoVO.getWhfBlk40ftQty());
						bkgKrWhfRtVO.setBlk45ftQty(krWhfBlInfoVO.getWhfBlk45ftQty());

						bkgKrWhfRtVO.setBbCgoWgt(krWhfBlInfoVO.getBlkWgtQty());
						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getBlkMeasQty());
//						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getMeasQty());

						bkgKrWhfRtVO.setKrCstmsFrtTpCd(krWhfBlInfoVO.getWhfPckTpCd());
						bkgKrWhfRtVO.setPortCd(krWhfVslInfoCondVO.getPortCd());
						bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());

						bkgKrWhfRtVO.setVslCd   (sVvd.substring(0, 4));
						bkgKrWhfRtVO.setSkdVoyNo(sVvd.substring(4, 8));
						bkgKrWhfRtVO.setSkdDirCd(sVvd.substring(8, 9));
//						bkgKrWhfRtVO.setWhfBndCd(krWhfVslInfoCondVO.getWhfBndCd());
						bkgKrWhfRtVO.setWhfBndCd(krWhfBlInfoVO.getWhfBndCd());
						bkgKrWhfRtVO.setBlNo    (krWhfBlInfoVO.getBlNo());
						bkgKrWhfRtVO.setChgRtSeq(chgRtSeq);

						bkgKrWhfRtVOs.add(bkgKrWhfRtVO);


						dbDao.modifyBkgKrWhfRt(bkgKrWhfRtVOs);
						dbDao.modifyBkgKrWhfCntr(bkgKrWhfRtVOs);
					}
					else {
						bkgKrWhfRtVO.setVslCd   (sVvd.substring(0, 4));
						bkgKrWhfRtVO.setSkdVoyNo(sVvd.substring(4, 8));
						bkgKrWhfRtVO.setSkdDirCd(sVvd.substring(8, 9));
						bkgKrWhfRtVO.setPortCd(krWhfVslInfoCondVO.getPortCd());
//						bkgKrWhfRtVO.setWhfBndCd(krWhfVslInfoCondVO.getWhfBndCd());
						bkgKrWhfRtVO.setWhfBndCd(krWhfBlInfoVO.getWhfBndCd());
						bkgKrWhfRtVO.setBlNo    (krWhfBlInfoVO.getBlNo());

						bkgKrWhfRtVO.setPortOfcCd(sPortOfcCd);
						bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());

						bkgKrWhfRtVO.setChgRtSeq(chgRtSeq);

						bkgKrWhfRtVOs.add(bkgKrWhfRtVO);
						//dbDao.modifyBkgKrWhfRt2(bkgKrWhfRtVOs);

						bkgKrWhfRtVO.setChgRtSeq(Integer.parseInt(chgRtSeq) + 1 + "");

						bkgKrWhfRtVO.setNewChgAmt(newChgAmt);
						bkgKrWhfRtVO.setOldChgAmt(oldChgAmt);
						bkgKrWhfRtVO.setDiffAmt (diffAmt + "");

						bkgKrWhfRtVO.setRtonWgt(krWhfBlInfoVO.getRtonWgt());
						bkgKrWhfRtVO.setCntrWgt(krWhfBlInfoVO.getBlkWgtQty());
						bkgKrWhfRtVO.setWgtUtCd(krWhfBlInfoVO.getWgtUtCd());
						bkgKrWhfRtVO.setMeasQty(krWhfBlInfoVO.getMeasQty());
						bkgKrWhfRtVO.setMeasUtCd(krWhfBlInfoVO.getMeasUtCd());
						bkgKrWhfRtVO.setCntrQty("0");
						bkgKrWhfRtVO.setKrWhfExptCd(krWhfBlInfoVO.getWfgExptCd());
						bkgKrWhfRtVO.setBlCustNm(krWhfBlInfoVO.getCustNm());
						bkgKrWhfRtVO.setTaxCustNm("");

						bkgKrWhfRtVO.setCntrTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
						bkgKrWhfRtVO.setCntrFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
						bkgKrWhfRtVO.setCntr45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());

						bkgKrWhfRtVO.setCntrTpszTeuQty (krWhfBlInfoVO.getWhfBkg20ftQty());
						bkgKrWhfRtVO.setCntrTpszFeuQty (krWhfBlInfoVO.getWhfBkg40ftQty());
						bkgKrWhfRtVO.setCntrTpsz45ftQty(krWhfBlInfoVO.getWhfBkg45ftQty());

						if (krWhfBlInfoVO.getWfgExptCd().equals("S") ||
							krWhfBlInfoVO.getWfgExptCd().equals("D") ||
							krWhfBlInfoVO.getWfgExptCd().equals("X") ||
							krWhfBlInfoVO.getWfgExptCd().equals("I") ||
							krWhfBlInfoVO.getWfgExptCd().equals("J") ||
							krWhfBlInfoVO.getWfgExptCd().equals("K")) {
							bkgKrWhfRtVO.setTaxTeuQty  ("0");
							bkgKrWhfRtVO.setTaxFeuQty  ("0");
							bkgKrWhfRtVO.setTax45ftQty ("0");

							bkgKrWhfRtVO.setExptTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setExptFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setExpt45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());
						}
						else {
							bkgKrWhfRtVO.setTaxTeuQty  (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setTaxFeuQty  (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setTax45ftQty (krWhfBlInfoVO.getWhfCntr45ftQty());

							bkgKrWhfRtVO.setExptTeuQty ("0");
							bkgKrWhfRtVO.setExptFeuQty ("0");
							bkgKrWhfRtVO.setExpt45ftQty("0");
						}

						bkgKrWhfRtVO.setBlkTeuQty (krWhfBlInfoVO.getWhfBlk20ftQty());
						bkgKrWhfRtVO.setBlkFeuQty (krWhfBlInfoVO.getWhfBlk40ftQty());
						bkgKrWhfRtVO.setBlk45ftQty(krWhfBlInfoVO.getWhfBlk45ftQty());
						bkgKrWhfRtVO.setBbCgoWgt(krWhfBlInfoVO.getBlkWgtQty());
						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getBlkMeasQty());
//						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getMeasQty());

						bkgKrWhfRtVO.setKrCstmsFrtTpCd(krWhfBlInfoVO.getWhfPckTpCd());

						bkgKrWhfRtVO.setCreUsrId(account.getUsr_id());

						bkgKrWhfRtVOs2.add(bkgKrWhfRtVO);
						dbDao.addBkgKrWhfRt(bkgKrWhfRtVOs2);
					}
				}
				dbDao.modifyBkgKrWhfBl(bkgKrWhfBlVOs);
			}
			else
			{
				throw new EventException(new ErrorHandler("BKG06103", new String[] {}).getMessage());
			}
		}

		}catch (EventException ex){
			throw ex;
		}catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}



	/**
	 * download BL List
	 *
	 * @param WhfBlVO[] whfBlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void downloadWhfBlList(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {
		try {

			if(whfBlVOs != null){

				KrWhfBlContainerVO krWhfBlContainerVO = (KrWhfBlContainerVO)whfBlVOs[0];
				KrWhfBkgKrWhfBlVO krWhfBkgKrWhfBlVO = krWhfBlContainerVO.getKrWhfBkgKrWhfBlVO();
				List<KrWhfBkgKrWhfBlVO> list = new ArrayList<KrWhfBkgKrWhfBlVO>();

				String sVvd   = krWhfBkgKrWhfBlVO.getVvd();
				String sVslCd = sVvd.substring(0, 4);
				String sSkdVoyNo = sVvd.substring(4, 8);
				String sSkdDirCd = sVvd.substring(8, sVvd.length());

				krWhfBkgKrWhfBlVO.setVslCd(sVslCd);
				krWhfBkgKrWhfBlVO.setSkdVoyNo(sSkdVoyNo);
				krWhfBkgKrWhfBlVO.setSkdDirCd(sSkdDirCd);

				krWhfBkgKrWhfBlVO.setCreUsrId(account.getUsr_id());
				krWhfBkgKrWhfBlVO.setUpdUsrId(account.getUsr_id());
				list.add(krWhfBkgKrWhfBlVO);
				dbDao.mergeSearchBkgKrWhfBl(list);

				BkgKrWhfCustVO bkgKrWhfCustVO = krWhfBlContainerVO.getBkgKrWhfCustVO();
				List<BkgKrWhfCustVO> bkgKrWhfCustVOs = new ArrayList<BkgKrWhfCustVO>();

				bkgKrWhfCustVO.setVslCd(sVslCd);
				bkgKrWhfCustVO.setSkdVoyNo(sSkdVoyNo);
				bkgKrWhfCustVO.setSkdDirCd(sSkdDirCd);
				bkgKrWhfCustVO.setFaxNo(krWhfBkgKrWhfBlVO.getBkgNo());
				bkgKrWhfCustVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfCustVO.setUpdUsrId(account.getUsr_id());

				bkgKrWhfCustVOs.add(bkgKrWhfCustVO);
				if(bkgKrWhfCustVOs.size() > 0) {

					dbDao.removeBkgKrWhfCust(bkgKrWhfCustVOs);
					dbDao.addSearchBkgKrWhfCust(bkgKrWhfCustVOs);
				}

				BkgKrWhfCntrVO bkgKrWhfCntrVO  = krWhfBlContainerVO.getBkgKrWhfCntrVO();
				List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs = new ArrayList<BkgKrWhfCntrVO>();
				bkgKrWhfCntrVO.setVslCd(sVslCd);
				bkgKrWhfCntrVO.setSkdVoyNo(sSkdVoyNo);
				bkgKrWhfCntrVO.setSkdDirCd(sSkdDirCd);
				bkgKrWhfCntrVO.setCntrNo(krWhfBkgKrWhfBlVO.getBkgNo());
				bkgKrWhfCntrVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfCntrVO.setUpdUsrId(account.getUsr_id());
				bkgKrWhfCntrVOs.add(bkgKrWhfCntrVO);
				if(bkgKrWhfCntrVOs.size() > 0) {
					dbDao.removeBkgKrWhfCntr(bkgKrWhfCntrVOs);
					dbDao.addSearchBkgKrWhfCntr(bkgKrWhfCntrVOs);
				}

			}
		}catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}


	/**
	 * retrieving event of WHF
	 *
	 * @param WhfDecChkListCondVO whfDecChkListCondVO
	 * @return List<WhfDecChkVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfDecChkVO> searchWhfDecChkList(WhfDecChkListCondVO whfDecChkListCondVO) throws EventException {
		try {

			return dbDao.searchKrWhfDecChkList((KrWhfDecChkListCondVO)whfDecChkListCondVO)  ;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * retrieving event of Freight charges arrival
	 *
	 * @param WhfCommInvListCondVO whfCommInvListCondVO
	 * @return List<WhfCommInvListVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfCommInvListVO> searchWhfCommInvList(WhfCommInvListCondVO whfCommInvListCondVO) throws EventException {
		try {

			KrWhfCommInvListCondVO krWhfCommInvListCondVO = (KrWhfCommInvListCondVO)whfCommInvListCondVO;
			krWhfCommInvListCondVO.setWhfNtcDt1(krWhfCommInvListCondVO.getWhfNtcDt1().replaceAll("-", ""));
			krWhfCommInvListCondVO.setWhfNtcDt2(krWhfCommInvListCondVO.getWhfNtcDt2().replaceAll("-", ""));

			return dbDao.searchKrWhfCommInvList((KrWhfCommInvListCondVO)whfCommInvListCondVO)  ;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * update Wharfage info
	 *
	 * @param WhfCommInvVO[] whfCommInvVOs Wharfage
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageWhfCommInv(WhfCommInvVO[] whfCommInvVOs, SignOnUserAccount account) throws EventException {
		try {
			List<BkgKrWhfVolVO> bkgKrWhfVolVOs = new ArrayList<BkgKrWhfVolVO>();
			dbDao.modifyBkgKrWhfVol(bkgKrWhfVolVOs);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}

	}


	/**
	 * retrieving KOREA WHF BL
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO
	 * @return List<WhfVslInfoVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfVslInfoVO> searchWhfMrnSailDt(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException {
		try {

			return dbDao.searchKrWhfMrnSailDt((KrWhfVslInfoCondVO)whfVslInfoCondVO)  ;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * retrieving KOREA WHF BL
	 *
	 * @param WhfCgoClassCondVO whfCgoClassCondVO
	 * @return List<WhfBlInfoVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBlInfoVO> searchWhfCgoClass(WhfCgoClassCondVO whfCgoClassCondVO) throws EventException {
		try {

			KrWhfPortRtListCondVO krWhfPortRtListCondVO = new KrWhfPortRtListCondVO();

			ObjectCloner.build(whfCgoClassCondVO, krWhfPortRtListCondVO);

			List<KrWhfAplyPortRtVO> krWhfAplyPortRtVOs = dbDao.searchKrWhfAplyPortRt(krWhfPortRtListCondVO)  ;

			String sKrWhfBlkRt = "0" ;
			if(krWhfAplyPortRtVOs.size() > 0){
				sKrWhfBlkRt = krWhfAplyPortRtVOs.get(0).getKrWhfBlkRt();
				if("".equals(sKrWhfBlkRt)) sKrWhfBlkRt = "0" ;
			}
			List<KrWhfBlInfoVO> krWhfBlInfoVOs = dbDao.searchKrWhfCgoClass((KrWhfCgoClassCondVO)whfCgoClassCondVO)  ;

			/*
			 "[CNTR Bulk Qty 20' > 0 OR CNTR Bulk Qty 40' > 0 OR CNTR Bulk Qty 45' > 0] {
				 [CNTR Bulk Weight * 0.999 < CNTR Bulk Measure * 0.883 + 0.999] {
					""E""
				 } ELSE {
				   ""W""
				 }
			  }"
			 */
			/*
			   "[Bulk Rton Appl Type = ""E""] {
					 CNTR Bulk Measure
				}
				[Bulk Rton Appl Type = ""W""] {
					 CNTR Bulk Weight
				}"
			 */
			List<KrWhfBlInfoVO> krWhfBlInfoVOs2 = new ArrayList<KrWhfBlInfoVO>();
			for (Iterator<KrWhfBlInfoVO> iterator = krWhfBlInfoVOs.iterator(); iterator.hasNext();) {
				KrWhfBlInfoVO krWhfBlInfoVO = iterator.next();

				// Null Exception 을 피하기 위해 초기 값을 setting 해 줌
				if (krWhfBlInfoVO.getRtonWgt() == null) krWhfBlInfoVO.setRtonWgt("0");
/*
				if (Float.parseFloat(krWhfBlInfoVO.getWhfCntr20ftQty()) > 0
					 ||	Float.parseFloat(krWhfBlInfoVO.getWhfCntr40ftQty()) > 0
					 ||	Float.parseFloat(krWhfBlInfoVO.getWhfCntr45ftQty()) > 0) {
				if ("BLK".equals(krWhfBlInfoVO.getWhfPckTpCd())) {
					if(Float.parseFloat(krWhfBlInfoVO.getBlkWgtQty()) * 0.999  <  (Float.parseFloat(krWhfBlInfoVO.getBlkMeasQty()) * 0.888) + 0.999) {
					if(Float.parseFloat(krWhfBlInfoVO.getBlkWgtQty())  <  (Float.parseFloat(krWhfBlInfoVO.getBlkMeasQty()))) {
						krWhfBlInfoVO.setBulkRtonApplType("E");
						krWhfBlInfoVO.setRtonWgt(krWhfBlInfoVO.getBlkMeasQty());
					} else {
						krWhfBlInfoVO.setBulkRtonApplType("W");
						krWhfBlInfoVO.setRtonWgt(krWhfBlInfoVO.getBlkWgtQty());
					}
				}
 */


//				if((krWhfBlInfoVO.getT() != "E") && (krWhfBlInfoVO.getT() != "R")){
//					krWhfBlInfoVO.setBulkWharfageAmount(String.valueOf(Float.parseFloat(krWhfBlInfoVO.getBulkRton()) * Float.parseFloat(sKrWhfBlkRt)));
//				}else{
//					krWhfBlInfoVO.setBulkWharfageAmount("0");
//				}
				krWhfBlInfoVO.setBulkWharfageAmount(String.valueOf(Float.parseFloat(krWhfBlInfoVO.getRtonWgt()) * Float.parseFloat(sKrWhfBlkRt)));
				krWhfBlInfoVOs2.add(krWhfBlInfoVO);
			}

			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId("KR_WHF_EXEMPT_CD");
			//hrdCdgVO.setAttrCtnt1(krWhfDecCondVO.getPortCd());
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = bkgUtil.searchHardCoding(hrdCdgVO);
//    		String sName = "";
//    		String sValue  = "";
//    		for (Iterator<BkgHrdCdgCtntVO> iterator = bkgHrdCdgCtntVOs.iterator(); iterator.hasNext();) {
//				BkgHrdCdgCtntVO bkgHrdCdgCtntVO = iterator.next();
//				sName = bkgHrdCdgCtntVO.getAttrCtnt5();
//				sValue  = bkgHrdCdgCtntVO.getAttrCtnt1();
//			}

			KrWhfBlInfoContainerVO krWhfBlInfoContainerVO = new KrWhfBlInfoContainerVO();
			krWhfBlInfoContainerVO.setKrWhfBlInfoVOs(krWhfBlInfoVOs2);
			krWhfBlInfoContainerVO.setKrWhfAplyPortRtVOs(krWhfAplyPortRtVOs);
			krWhfBlInfoContainerVO.setBkgHrdCdgCtntVOs(bkgHrdCdgCtntVOs);

			List<WhfBlInfoVO> whfBlInfoVOs = new ArrayList<WhfBlInfoVO>();
			WhfBlInfoVO whfBlInfoVO = (WhfBlInfoVO)krWhfBlInfoContainerVO;
			whfBlInfoVOs.add(whfBlInfoVO);

			return whfBlInfoVOs ;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * retrieving KOREA WHF BL
	 *
	 * @param WhfExemptInfoCondVO whfExemptInfoCondVO
	 * @return WhfExemptInfoVO
	 * @throws EventException
	 */
	@Override
	public WhfExemptInfoVO searchWhfExemptInfo(WhfExemptInfoCondVO whfExemptInfoCondVO) throws EventException {

		try {
			KrWhfBlExpInfoVO  krWhfBlExpInfoVO           = dbDao.searchKrWhfBlInfo((KrWhfExemptInfoCondVO)whfExemptInfoCondVO);
			List<KrWhfBlExptInfoVO> krWhfBlExptInfoVOs   = dbDao.searchKrWhfBlExptInfo((KrWhfExemptInfoCondVO)whfExemptInfoCondVO);
			List<KrWhfCntrExpInfoVO> krWhfCntrExpInfoVOs = dbDao.searchKrWhfCntrExpInfo((KrWhfExemptInfoCondVO)whfExemptInfoCondVO);

			KrWhfExemptInfoContainerVO krWhfExemptInfoContainerVO = new KrWhfExemptInfoContainerVO();
			krWhfExemptInfoContainerVO.setKrWhfBlExpInfoVO(krWhfBlExpInfoVO);
			krWhfExemptInfoContainerVO.setKrWhfBlExptInfoVOs(krWhfBlExptInfoVOs);
			krWhfExemptInfoContainerVO.setKrWhfCntrExpInfoVOs(krWhfCntrExpInfoVOs);

			return krWhfExemptInfoContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

	}

	/**
	 * retrieving WHF
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @return WhfDecVO
	 * @throws EventException
	 */
	@Override
	public WhfDecVO searchWhfDec(WhfDecCondVO whfDecCondVO) throws EventException {
		try {
			List<KrWhfVvdDtlVO> krWhfVvdDtlVOs = null ;
			KrWhfDecContainerVO krWhfDecContainerVO = new KrWhfDecContainerVO();


			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
			krWhfVvdDtlVOs = dbDao.searchKrWhfVvdDtlSavedList(krWhfDecCondVO);
			if(krWhfVvdDtlVOs.size() == 0){
				krWhfVvdDtlVOs = dbDao.searchKrWhfVvdDtlInitialList(krWhfDecCondVO);
			}

			if(krWhfVvdDtlVOs.size() == 0)
				return krWhfDecContainerVO ;

			krWhfDecContainerVO.setKrWhfVvdDtlVOs(krWhfVvdDtlVOs);

			BkgKrWhfVolVO bkgKrWhfVolVO = dbDao.searchKrWhfVol(krWhfDecCondVO);
			if(bkgKrWhfVolVO == null)
				return krWhfDecContainerVO ;

			String sWhfBndCd = krWhfDecCondVO.getWhfBndCd();
			String sWhfRtAmt = dbDao.searchKrWhfTtlAmt(krWhfDecCondVO);
			if("OO".equals(sWhfBndCd) || "II".equals(sWhfBndCd) || "IN".equals(sWhfBndCd)){
				bkgKrWhfVolVO.setWhfRtAmt(sWhfRtAmt);
			}
			krWhfDecContainerVO.setBkgKrWhfVolVO(bkgKrWhfVolVO);

			KrWhfDecVO krWhfDecVO = dbDao.searchKrWhfDec(krWhfDecCondVO);
			String sDeclNoYr = "";
			if(krWhfDecVO == null){
				sDeclNoYr = dbDao.searchYearAsYyyy(krWhfDecCondVO);
				krWhfDecVO = new KrWhfDecVO();
				krWhfDecVO.setWhfNtcNoYr(sDeclNoYr);
			}
			krWhfDecContainerVO.setKrWhfDecVO(krWhfDecVO);


			List<KrWhfDecExptVolVO> krWhfDecExptVolVOs = dbDao.searchKrWhfDecExptVolList(krWhfDecCondVO);

			String sRepoMt = "0";
			String sMtQty  = "0";
			String sBlkQty = "0";

			for (Iterator<KrWhfDecExptVolVO> iterator = krWhfDecExptVolVOs.iterator(); iterator.hasNext();) {
				KrWhfDecExptVolVO krWhfDecExptVolVO = iterator.next();

				sBlkQty = dbDao.searchKrWhfDecExptBlkVol(krWhfDecCondVO, krWhfDecExptVolVO.getSizeId());
				krWhfDecExptVolVO.setBlkQty(sBlkQty);

				sMtQty  = dbDao.searchKrWhfDecExptMtCntrVol(krWhfDecCondVO, krWhfDecExptVolVO.getSizeId());
				if(!"".equals(sMtQty) || !"".equals(sBlkQty)) {
					krWhfDecExptVolVO.setMtQty (sMtQty);
					sRepoMt = Float.toString(Float.parseFloat(sMtQty) + Float.parseFloat(sBlkQty));
					krWhfDecExptVolVO.setRepoMt(sRepoMt);

					krWhfDecExptVolVO.setTsTotal(Float.toString((Float.parseFloat(krWhfDecExptVolVO.getThruTsQty()) + Float.parseFloat(krWhfDecExptVolVO.getCustTsQty())))) ;
					krWhfDecExptVolVO.setMtyTotal(Float.toString(Float.parseFloat(krWhfDecExptVolVO.getRevMtQty()) + Float.parseFloat(sRepoMt)));
					krWhfDecExptVolVO.setExemptTotal(Float.toString((Float.parseFloat(krWhfDecExptVolVO.getHyoSungQty())
																	+ Float.parseFloat(krWhfDecExptVolVO.getDaeWooQty())
																	+ Float.parseFloat(krWhfDecExptVolVO.getDongBuQty())
																	+ Float.parseFloat(krWhfDecExptVolVO.getHyunDaiQty())
																	+ Float.parseFloat(krWhfDecExptVolVO.getDongKukQty()))));
				}
			}

			krWhfDecContainerVO.setKrWhfDecExptVolVOs(krWhfDecExptVolVOs);
			KrWhfPortRtVO krWhfPortRtVO  = dbDao.searchKrWhfCntrPortRt(krWhfDecCondVO.getPortCd(), krWhfDecCondVO.getWhfBndCd(), bkgKrWhfVolVO.getWhfVolDcCd());
			KrWhfPortRtVO krWhfPortRtVO2 = dbDao.searchKrWhfBlkPortRt(krWhfDecCondVO.getPortCd(), krWhfDecCondVO.getWhfBndCd(), bkgKrWhfVolVO.getWhfVolDcCd());
			krWhfDecContainerVO.setCntr_KrWhfPortRtVO(krWhfPortRtVO);
			krWhfDecContainerVO.setBlk_KrWhfPortRtVO(krWhfPortRtVO2);

			return krWhfDecContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * Wharfage
	 *
	 * @param whfDecVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageWhfDec(WhfDecVO whfDecVO, SignOnUserAccount account) throws EventException {
		try {
			KrWhfDecContainerVO krWhfDecContainerVO = (KrWhfDecContainerVO)whfDecVO;
			BkgKrWhfVolVO  bkgKrWhfVolVO   = krWhfDecContainerVO.getBkgKrWhfVolVO();
			KrWhfDecVO     krWhfDecVO      = krWhfDecContainerVO.getKrWhfDecVO();
			KrWhfDecCondVO krWhfDecCondVO  = krWhfDecContainerVO.getKrWhfDecCondVO();
			KrWhfVvdDtlVO[] krWhfVvdDtlVOs = krWhfDecContainerVO.getKrWhfVvdDtlVOs2();
			String sVvd      = krWhfDecCondVO.getVvd();
			String sNtcNo    = krWhfDecVO.getWhfNtcNoYr() + krWhfDecVO.getWhfNtcNoMon() + krWhfDecVO.getWhfNtcNoSeq();
			String sWhfBndCd = krWhfDecCondVO.getWhfBndCd();


			if(sNtcNo.length() != 12)
				sNtcNo = "";

			int iKrWhfDecKnt = dbDao.searchKrWhfDecKnt(krWhfDecCondVO);
			if(iKrWhfDecKnt != 0){
				bkgKrWhfVolVO.setVslCd   (sVvd.substring(0, 4));
				bkgKrWhfVolVO.setSkdVoyNo(sVvd.substring(4, 8));
				bkgKrWhfVolVO.setSkdDirCd(sVvd.substring(8, 9));
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgKrWhfVolWhfCustKndSave(bkgKrWhfVolVO);
				//commit();
//				throw new EventException(new ErrorHandler("BKG06103").getMessage());
				krWhfDecContainerVO.setErrMsg("BKG06103");
				return;
			}

			String sCustKndCd = bkgKrWhfVolVO.getWhfCustKndCd();
			if(!"IN".equals(sWhfBndCd)){
				int iDistinctKnt = dbDao.searchKrWhfNoExptCustRgstNoDistinctKnt(krWhfDecCondVO);
				if(("C".equals(sCustKndCd) && iDistinctKnt<=1) || ("U".equals(sCustKndCd) && iDistinctKnt>1)){
					throw new EventException(new ErrorHandler("BKG06047").getMessage());
				}
				bkgKrWhfVolVO.setVslCd   (sVvd.substring(0, 4));
				bkgKrWhfVolVO.setSkdVoyNo(sVvd.substring(4, 8));
				bkgKrWhfVolVO.setSkdDirCd(sVvd.substring(8, 9));
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgKrWhfVolWhfDecSave(bkgKrWhfVolVO);
			}


			List<BkgKrWhfVvdDtlVO> addlist             = new ArrayList<BkgKrWhfVvdDtlVO>();
			List<BkgKrWhfVvdDtlVO> bkgKrWhfVvdDtlVOs = new ArrayList<BkgKrWhfVvdDtlVO>();
			if(krWhfVvdDtlVOs != null) {
				for (int i=0; i<krWhfVvdDtlVOs.length; i++) {

					KrWhfVvdDtlVO krWhfVvdDtlVO = (KrWhfVvdDtlVO) krWhfVvdDtlVOs[i];
					BkgKrWhfVvdDtlVO bkgKrWhfVvdDtlVO = new BkgKrWhfVvdDtlVO();
					ObjectCloner.build(krWhfVvdDtlVO, bkgKrWhfVvdDtlVO);
					bkgKrWhfVvdDtlVO.setVslCd(sVvd.substring(0, 4));
					bkgKrWhfVvdDtlVO.setSkdVoyNo(sVvd.substring(4, 8));
					bkgKrWhfVvdDtlVO.setSkdDirCd(sVvd.substring(8, 9));
					bkgKrWhfVvdDtlVO.setPortCd(krWhfDecCondVO.getPortCd());
					bkgKrWhfVvdDtlVO.setWhfBndCd(krWhfDecCondVO.getWhfBndCd());
					bkgKrWhfVvdDtlVO.setCreUsrId(account.getUsr_id());
					bkgKrWhfVvdDtlVO.setUpdUsrId(account.getUsr_id());

					if("I".equals(bkgKrWhfVvdDtlVO.getIbflag())){
						addlist.add(bkgKrWhfVvdDtlVO);
					}else if("U".equals(bkgKrWhfVvdDtlVO.getIbflag())){
						addlist.add(bkgKrWhfVvdDtlVO);
					}
					bkgKrWhfVvdDtlVOs.add(bkgKrWhfVvdDtlVO);

				}
			}

			if(bkgKrWhfVvdDtlVOs.size()>0){
				dbDao.removeBkgKrWhfVvdDtlWhfDec(bkgKrWhfVvdDtlVOs);
			}

			dbDao.addBkgKrWhfVvdDtlWhfDec(addlist);

			if(!"IN".equals(sWhfBndCd)){
				dbDao.modifyBkgKrWhfRtWhfDec(krWhfDecCondVO, sNtcNo);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * Wharfage Check
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchSendCheck(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException{
		KrWhfDecCondVO krWhfDecCondVO = null;
		String dtCheck = "";
		String etaDt = "";
		String frInDt = "";
		String retVal = "";
		String emptyCheck = "";
		try{
			krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;


			List<KrWhfDecCheckSendDtVO> krWhfDecCheckSendDtVOs = dbDao.checkSendDate(krWhfDecCondVO);

			dtCheck = krWhfDecCheckSendDtVOs.get(0).getDtChk();
			etaDt = krWhfDecCheckSendDtVOs.get(0).getEtaDt();
			frInDt = krWhfDecCheckSendDtVOs.get(0).getFrIndt();
			emptyCheck = krWhfDecCheckSendDtVOs.get(0).getEmptyChk();

			retVal = dtCheck + ":" + etaDt + ":" + frInDt + ":" + emptyCheck;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return retVal;
	}

	/**
	 * Wharfage
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void sendWhfDec(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {
		try {
			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
			String sWhfBndCd = krWhfDecCondVO.getWhfBndCd();
			String sPrefixWhfBndCd = sWhfBndCd.substring(0, 1);
			String sPolCd = "";
			String sPodCd = "";
			if("O".equals(sPrefixWhfBndCd)){
				sPolCd = krWhfDecCondVO.getPortCd();
			} else if ("I".equals(sPrefixWhfBndCd)) {
				sPodCd = krWhfDecCondVO.getPortCd();
			}

			KrWhfDecEdiFfContainerVO krWhfDecEdiFfContainerVO  = (KrWhfDecEdiFfContainerVO)searchKrWhfDecEdiFf(krWhfDecCondVO);
			KrWhfDecEdiVvdVO krWhfDecEdiVvdVO = krWhfDecEdiFfContainerVO.getKrWhfDecEdiVvdVO();
			List<KrWhfDecEdiRtVO> krWhfDecEdiRtVOs = krWhfDecEdiFfContainerVO.getKrWhfDecEdiRtVOs();

			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId("KR_WHF_EDI_SND_INFO");
			hrdCdgVO.setAttrCtnt1(krWhfDecCondVO.getPortCd());
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = bkgUtil.searchHardCoding(hrdCdgVO);
			String sSndrId = "";
			String sRcvId  = "";
			String sMsgId  = "";
			for (Iterator<BkgHrdCdgCtntVO> iterator = bkgHrdCdgCtntVOs.iterator(); iterator.hasNext();) {
				BkgHrdCdgCtntVO bkgHrdCdgCtntVO = iterator.next();
				sSndrId = bkgHrdCdgCtntVO.getAttrCtnt3();
				sRcvId  = bkgHrdCdgCtntVO.getAttrCtnt4();
				sMsgId  = bkgHrdCdgCtntVO.getAttrCtnt2();
			}

			BookingUtil command = new BookingUtil();
			String sEdiHeader = command.searchEdiHeader(sSndrId, sRcvId, sMsgId);
			StringBuffer flatFile = new StringBuffer();
			flatFile.append(sEdiHeader).append("\n")
					.append("VVD:").append(krWhfDecEdiVvdVO.getVvd()).append("\n")
					.append("VSL_CALLSIGN:").append(krWhfDecEdiVvdVO.getVslCallsign()).append("\n")
					.append("VSL_FULLNAME:").append(krWhfDecEdiVvdVO.getVslFullname()).append("\n")
					.append("VSL_COUNTRY:").append(krWhfDecEdiVvdVO.getVslCountry()).append("\n")
					.append("ETA:").append(krWhfDecEdiVvdVO.getEta()).append("\n")
					.append("ETD:").append(krWhfDecEdiVvdVO.getEtd()).append("\n")
					.append("POL:").append(sPolCd).append("\n")
					.append("POD:").append(sPodCd).append("\n")
					.append("IO_IND:").append(krWhfDecEdiVvdVO.getIoInd()).append("\n")
					.append("SND_IND:").append(krWhfDecCondVO.getSend()   		).append("\n")
					.append("PORT_CD:").append(krWhfDecEdiVvdVO.getPortCd()).append("\n")
					.append("TMNL_CD:").append(krWhfDecEdiVvdVO.getTmnlCd()).append("\n")
					.append("IN_SEQ:").append(krWhfDecEdiVvdVO.getInSeq()).append("\n")
					.append("DSCH_COM:").append(krWhfDecEdiVvdVO.getDschCom()).append("\n")
					.append("DSCH_IND:").append(krWhfDecEdiVvdVO.getDschInd()).append("\n")
					.append("DSC_RATE:").append(krWhfDecEdiVvdVO.getDscRate()).append("\n")
					.append("F45_TTL:").append(krWhfDecEdiVvdVO.getF45Ttl()).append("\n")
					.append("F40_TTL:").append(krWhfDecEdiVvdVO.getF40Ttl()).append("\n")
					.append("F35_TTL:").append(krWhfDecEdiVvdVO.getF35Ttl()).append("\n")
					.append("F20_TTL:").append(krWhfDecEdiVvdVO.getF20Ttl()).append("\n")
					.append("F10_TTL:").append(krWhfDecEdiVvdVO.getF10Ttl()).append("\n")
					.append("FETC_TTL:").append(krWhfDecEdiVvdVO.getFetcTtl()).append("\n")
					.append("E45_TTL:").append(krWhfDecEdiVvdVO.getE45Ttl()).append("\n")
					.append("E40_TTL:").append(krWhfDecEdiVvdVO.getE40Ttl()).append("\n")
					.append("E35_TTL:").append(krWhfDecEdiVvdVO.getE35Ttl()).append("\n")
					.append("E20_TTL:").append(krWhfDecEdiVvdVO.getE20Ttl()).append("\n")
					.append("E10_TTL:").append(krWhfDecEdiVvdVO.getE10Ttl()).append("\n")
					.append("EETC_TTL:").append(krWhfDecEdiVvdVO.getEetcTtl()).append("\n")
					.append("RTON:").append(krWhfDecEdiVvdVO.getRton()).append("\n")
					.append("AMOUNT:").append(krWhfDecEdiVvdVO.getAmount()).append("\n")
					.append("FREE_RTON:").append(krWhfDecEdiVvdVO.getFreeRton()).append("\n")
					.append("FREE_AMOUNT:").append(krWhfDecEdiVvdVO.getFreeAmount()).append("\n")
					.append("RTON_TTL:").append(krWhfDecEdiVvdVO.getRtonTtl()).append("\n")
					.append("AMOUNT_TTL:").append(krWhfDecEdiVvdVO.getAmountTtl()).append("\n")
					.append("TAX_DATE:").append(krWhfDecEdiVvdVO.getTaxDate()).append("\n")
					.append("EST_VOL:").append(krWhfDecEdiVvdVO.getEstVol()).append("\n")
					.append("SUM_AMOUNT:").append(krWhfDecEdiVvdVO.getSumAmount()).append("\n");
					//Wharfage Detail Loop Header [ start ]
					for (Iterator<KrWhfDecEdiRtVO> iterator = krWhfDecEdiRtVOs.iterator(); iterator.hasNext();) {
						KrWhfDecEdiRtVO krWhfDecEdiRtVO = iterator.next();
						flatFile.append("{WHF_DTL").append("").append("\n")
								.append("RTON:").append(krWhfDecEdiRtVO.getRton()).append("\n")
								.append("DSCH_IND:").append(krWhfDecEdiRtVO.getDschInd()).append("\n")
								.append("DC_CD:").append(krWhfDecEdiRtVO.getDcCd()).append("\n")
								.append("DC_REASON:").append(krWhfDecEdiRtVO.getDcReason()).append("\n")
								.append("UNIT:").append(krWhfDecEdiRtVO.getUnit()).append("\n")
								.append("AMOUNT:").append(krWhfDecEdiRtVO.getAmount()).append("\n")
								.append("}WHF_DTL").append("").append("\n");
					}
					//Wharfage Detail Loop Header [ end ]

			BkgKrWhfVolVO bkgKrWhfVolVO = new BkgKrWhfVolVO();
			String sVvd = krWhfDecCondVO.getVvd();
			ObjectCloner.build(krWhfDecCondVO, bkgKrWhfVolVO);
			bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
			bkgKrWhfVolVO.setCreUsrId(account.getUsr_id());
			bkgKrWhfVolVO.setVslCd(sVvd.substring(0, 4));
			bkgKrWhfVolVO.setSkdVoyNo(sVvd.substring(4, 8));
			bkgKrWhfVolVO.setSkdDirCd(sVvd.substring(8, 9));
			bkgKrWhfVolVO.setEdiMsgSndId(krWhfDecCondVO.getSend());
			dbDao.modifyBkgKrWhfVolWhfDecSend(bkgKrWhfVolVO);

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			log.info(flatFile.toString());
			sendFlatFileVO.setFlatFile(flatFile.toString());

			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_KRCUS_GENERAL.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
		} catch(EventException ee){
			throw ee;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 *  Handling retrieving event of KOREA WHF
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return KrWhfDecEdiFfVO
	 * @throws EventException
	 */
	private KrWhfDecEdiFfVO searchKrWhfDecEdiFf(KrWhfDecCondVO krWhfDecCondVO) throws EventException {
		try {
			KrWhfDecEdiFfContainerVO krWhfDecEdiFfContainerVO = new KrWhfDecEdiFfContainerVO();

			KrWhfDecEdiVvdVO krWhfDecEdiVvdVO  = dbDao.searchKrWhfDecEdiVvd(krWhfDecCondVO);
			KrWhfDecEdiVvdVO krWhfDecEdiVvdVO2 = dbDao.searchKrWhfDecEdiQty(krWhfDecCondVO);
			krWhfDecEdiVvdVO.setEstVol(krWhfDecEdiVvdVO2.getEstVol());
			krWhfDecEdiVvdVO.setSumAmount(krWhfDecEdiVvdVO2.getSumAmount());
			List<KrWhfDecEdiRtVO>  krWhfDecEdiRtVOs = dbDao.searchKrWhfDecEdiRtList (krWhfDecCondVO);
			krWhfDecEdiFfContainerVO.setKrWhfDecEdiVvdVO(krWhfDecEdiVvdVO);
			krWhfDecEdiFfContainerVO.setKrWhfDecEdiRtVOs(krWhfDecEdiRtVOs);

			return krWhfDecEdiFfContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage I/F
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void interfaceWhfDec(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {
		try {

			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;

			String cancelFlag = krWhfDecCondVO.getCancelFlag();

			KrWhfDecCondVO krWhfDecCondVO2 = dbDao.searchKrWhfDecBzcInfo(krWhfDecCondVO);
			String sOfcCd = krWhfDecCondVO2.getWhfDeclOfcCd();
			krWhfDecCondVO.setWhfDeclOfcCd(sOfcCd);

			if(!"Y".equals(cancelFlag)){  // Dec I/F
				KrWhfDecCondVO krWhfDecCondVO3 = createKrWhfDecNo(krWhfDecCondVO, account);
				krWhfDecCondVO.setWhfDeclNo(krWhfDecCondVO3.getWhfDeclNo());

				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfApIf(krWhfDecCondVO, account);

				dbDao.modifyBkgKrWhfRtIfDecNo(krWhfDecCondVO, account);

				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfArInvIf(krWhfDecCondVO, account);
			}else{  // Dec Cancel I/F
				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfApIf(krWhfDecCondVO, account);

				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfArInvIf(krWhfDecCondVO, account);

				dbDao.modifyBkgKrWhfRtIfDecNo(krWhfDecCondVO, account);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch(EventException ee){
			throw ee;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 * Declare Number
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @param SignOnUserAccount account
	 * @return KrWhfDecCondVO
	 * @throws EventException
	 */
	private KrWhfDecCondVO createKrWhfDecNo(KrWhfDecCondVO krWhfDecCondVO, SignOnUserAccount account) throws EventException {
		try {
			KrWhfDecCondVO krWhfDecCondVO2 = dbDao.searchKrWhfDecBzcInfo(krWhfDecCondVO);
			String sOfcCd = krWhfDecCondVO2.getWhfDeclOfcCd();

			String sWhfAmtFmSmry = dbDao.searchKrWhfSumAmtFmSmry(krWhfDecCondVO);
			String sWhfAmtFmDtl  = dbDao.searchKrWhfSumAmtFmDtl(krWhfDecCondVO);
			if (Integer.parseInt("".equals(sWhfAmtFmSmry)?"0":sWhfAmtFmSmry) != Integer.parseInt(sWhfAmtFmDtl))
				throw new EventException(new ErrorHandler("BKG06067",new String[]{}).getMessage());

			String sWhfDeclNoExistFlg = dbDao.searchKrWhfDecDeclNoWithVvdExistFlg(krWhfDecCondVO);
			if ("Y".equals(sWhfDeclNoExistFlg))
				throw new EventException(new ErrorHandler("BKG06068",new String[]{sWhfDeclNoExistFlg}).getMessage());

			if (0 != krWhfDecCondVO.getWhfDeclNo().length())
				throw new EventException(new ErrorHandler("BKG06068",new String[]{krWhfDecCondVO.getWhfDeclNo()}).getMessage());

			BookingUtil BookingUtil = new BookingUtil();
			String sBkgDivCd = "KWD" ;
			String sOfficeCd = krWhfDecCondVO.getVvd() + "|" + krWhfDecCondVO.getPortCd() + "|" + sOfcCd ;
			BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO
				=  BookingUtil.manageBkgReferenceNumberGeneration(sBkgDivCd, sOfficeCd, account.getUsr_id());
			String sWhfDeclNo = bkgReferenceNoGenerationVO.getKrWhfDeclNo();//getWhfDeclNo();
			String sWhfDeclNoExistFlg2 = dbDao.searchKrWhfDecDeclNoWithDiffVvdExistFlg(krWhfDecCondVO.getVvd(), sWhfDeclNo);
			if("Y".equals(sWhfDeclNoExistFlg2))
				throw new EventException(new ErrorHandler("BKG06069",new String[]{sWhfDeclNo}).getMessage());

			krWhfDecCondVO.setWhfDeclNo(sWhfDeclNo);
			return krWhfDecCondVO;
		} catch(EventException ee){
			throw ee;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * Interface AP Invoice
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	private WhfDecCondVO manageWhfApIf(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {

		try {
			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO ;
			KrWhfDecBzcInfoForApIfVO krWhfDecBzcInfoForApIfVO   = dbDao.searchKrWhfDecBzcInfoForApIf(krWhfDecCondVO);

			String sRevenueVvd = dbDao.searchRevVvd(krWhfDecCondVO);

			BookingUtil BookingUtil = new BookingUtil();
			String sBkgDivCd = "KWC" ;
			String sOfficeCd = krWhfDecCondVO.getWhfDeclOfcCd() ;

			String orgCsrNo = "";

			//
			String totalAmount = krWhfDecCondVO.getWhfRtAmt().replaceAll(",", "");
			//
			String ntcAmount = String.valueOf(Float.parseFloat(krWhfDecCondVO.getNtcAmt().replaceAll(",", "")) * -1) ;
			//
			String rducAmt = String.valueOf(Float.parseFloat(krWhfDecCondVO.getRducAmt()) * -1) ;
			//


			if("Y".equals(krWhfDecCondVO.getCancelFlag())){
				totalAmount = (Integer.parseInt(totalAmount) * -1) + "";
				ntcAmount = (Float.parseFloat(ntcAmount) * -1) + "";
				rducAmt = (Float.parseFloat(rducAmt) * -1) + "";
				orgCsrNo = krWhfDecCondVO.getCsrNo();
			}



			BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO
				= BookingUtil.manageBkgReferenceNumberGeneration(sBkgDivCd, sOfficeCd, account.getUsr_id());
			String sCsrNo = bkgReferenceNoGenerationVO.getKrWhfCsrNo();
			krWhfDecCondVO.setCsrNo(sCsrNo);

			List<ApInvHdrVO> apInvHdrVOs = new ArrayList<ApInvHdrVO>();
			ApInvHdrVO apInvHdrVO = new ApInvHdrVO();


			/*
			 * Create Header [start]
			 */

			apInvHdrVO.setCsrNo(sCsrNo);
			apInvHdrVO.setCsrTpCd("STANDARD");
			apInvHdrVO.setInvDt(DateTime.getFormatDate(new Date(), "yyyyMMdd"));
			apInvHdrVO.setInvTermDt(DateTime.getFormatDate(new Date(), "yyyyMMdd"));
			apInvHdrVO.setGlDt(krWhfDecBzcInfoForApIfVO.getGlDt());
			apInvHdrVO.setVndrNo(krWhfDecBzcInfoForApIfVO.getVndrNo());
			apInvHdrVO.setCsrAmt("0");
			apInvHdrVO.setCsrCurrCd("KRW");
			apInvHdrVO.setVndrTermNm(krWhfDecBzcInfoForApIfVO.getVndrTermNm());
			apInvHdrVO.setInvDesc(krWhfDecCondVO.getWhfDeclNo());
			apInvHdrVO.setAttrCateNm("기타");
			apInvHdrVO.setAttrCtnt10(krWhfDecCondVO.getWhfUsrNm());
			apInvHdrVO.setAttrCtnt15("Y");
			apInvHdrVO.setSrcCtnt("OPUS AR");
			apInvHdrVO.setPayMzdLuCd("WIRE");
			apInvHdrVO.setPayGrpLuCd("ZERO PAYMENT");
			apInvHdrVO.setCoaCoCd("01");
			apInvHdrVO.setCoaRgnCd("11");
			apInvHdrVO.setCoaCtrCd(krWhfDecBzcInfoForApIfVO.getApCtrCd());
			apInvHdrVO.setCoaAcctCd("210111");
			apInvHdrVO.setCoaVvdCd("0000000000");
			apInvHdrVO.setCoaInterCoCd("00");
			apInvHdrVO.setCoaFtuN1stCd("000000");
			apInvHdrVO.setCoaFtuN2ndCd("000000");
			apInvHdrVO.setAproFlg("Y");
			apInvHdrVO.setErrCsrNo(" ");
			apInvHdrVO.setTjOfcCd(krWhfDecCondVO.getWhfDeclOfcCd());
			apInvHdrVO.setCreDt(DateTime.getFormatDate(new Date(), "yyyyMMdd"));
			apInvHdrVO.setCreUsrId(account.getUsr_id());
			apInvHdrVO.setAttrCtnt11      (orgCsrNo);
			/*
			 * Create Header [end]
			 */
			apInvHdrVOs.add(apInvHdrVO);

			/*
			 * Create Distribute [start] 1st
			 */
			String sDtrbCoaAcctCd = "211541";
			String sDtrbCoaAcctCdForTruncatedAmt = "422011";
			String sAttrCateNm    = "211541";
			String sAttrCntt3     = krWhfDecCondVO.getWhfDeclNo().substring(0,5);
			List<ApInvDtrbVO> apInvDtrbVOs = new ArrayList<ApInvDtrbVO>();




			ApInvDtrbVO apInvDtrbVO = new ApInvDtrbVO();
			apInvDtrbVO.setCsrNo           (sCsrNo);
			apInvDtrbVO.setLineSeq         ("0001");
			apInvDtrbVO.setLineNo          ("0001");
			apInvDtrbVO.setLineTpLuCd      ("ITEM");
			apInvDtrbVO.setInvAmt          (totalAmount);
			apInvDtrbVO.setInvDesc         (krWhfDecCondVO.getWhfDeclNo());
			apInvDtrbVO.setDtrbCoaCoCd     ("01");
			apInvDtrbVO.setDtrbCoaRgnCd    ("11");
			apInvDtrbVO.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
			apInvDtrbVO.setDtrbCoaAcctCd   (sDtrbCoaAcctCd);
			apInvDtrbVO.setDtrbCoaVvdCd    ("0000000000");
			apInvDtrbVO.setDtrbCoaInterCoCd("00");
			apInvDtrbVO.setDtrbCoaFtuN1stCd("000000");
			apInvDtrbVO.setDtrbCoaFtuN2ndCd("000000");
			apInvDtrbVO.setAttrCateNm      (sAttrCateNm);
			apInvDtrbVO.setAttrCtnt3       (sAttrCntt3);
			apInvDtrbVO.setActVvdCd        (sRevenueVvd);
			apInvDtrbVO.setPlnSctrDivCd    (" ");
			apInvDtrbVO.setCreDt           ("SYSDATE");
			apInvDtrbVO.setCreUsrId        (account.getUsr_id());
			apInvDtrbVO.setAttrCtnt11      (orgCsrNo);

			/*
			 * Create Distribute [end]
			 */
			apInvDtrbVOs.add(apInvDtrbVO);
			/*
			 * Create Distribute [start] WHF  INSERT
			 */



			ApInvDtrbVO apInvDtrbVO2 = new ApInvDtrbVO();
			apInvDtrbVO2.setCsrNo           (sCsrNo);
			apInvDtrbVO2.setLineSeq         ("0002");
			apInvDtrbVO2.setLineNo          ("0002");
			apInvDtrbVO2.setLineTpLuCd      ("ITEM");
			apInvDtrbVO2.setInvAmt          (ntcAmount);
			apInvDtrbVO2.setInvDesc         (krWhfDecCondVO.getWhfDeclNo());
			apInvDtrbVO2.setDtrbCoaCoCd     ("01");
			apInvDtrbVO2.setDtrbCoaRgnCd    ("11");
			apInvDtrbVO2.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
			apInvDtrbVO2.setDtrbCoaAcctCd   ("111211");
			apInvDtrbVO2.setDtrbCoaVvdCd    ("0000000000");
			apInvDtrbVO2.setDtrbCoaInterCoCd("00");
			apInvDtrbVO2.setDtrbCoaFtuN1stCd("000000");
			apInvDtrbVO2.setDtrbCoaFtuN2ndCd("000000");
			apInvDtrbVO2.setAttrCateNm      ("111211");
			apInvDtrbVO2.setAttrCtnt3       (sAttrCntt3);
			apInvDtrbVO2.setActVvdCd        (sRevenueVvd);
			apInvDtrbVO2.setPlnSctrDivCd    (" ");
			apInvDtrbVO2.setCreDt           ("SYSDATE");
			apInvDtrbVO2.setCreUsrId        (account.getUsr_id());
			apInvDtrbVO2.setAttrCtnt11       (orgCsrNo);

			/*
			 * Create Distribute [end]
			 */
			apInvDtrbVOs.add(apInvDtrbVO2);


			if(Float.parseFloat(krWhfDecCondVO.getRducAmt()) > 0){

				/*
				 * Create Distribute [start]  INSERT
				 */


				ApInvDtrbVO apInvDtrbVO3 = new ApInvDtrbVO();
				apInvDtrbVO3.setCsrNo           (sCsrNo);
				apInvDtrbVO3.setLineSeq         ("0003");
				apInvDtrbVO3.setLineNo          ("0003");
				apInvDtrbVO3.setLineTpLuCd      ("ITEM");
				apInvDtrbVO3.setInvAmt          (rducAmt);
				apInvDtrbVO3.setInvDesc         (krWhfDecCondVO.getWhfDeclNo());
				apInvDtrbVO3.setDtrbCoaCoCd     ("01");
				apInvDtrbVO3.setDtrbCoaRgnCd    ("11");
				apInvDtrbVO3.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
				apInvDtrbVO3.setDtrbCoaAcctCd   (sDtrbCoaAcctCdForTruncatedAmt);
				apInvDtrbVO3.setDtrbCoaVvdCd    (sRevenueVvd);
				apInvDtrbVO3.setDtrbCoaInterCoCd("00");
				apInvDtrbVO3.setDtrbCoaFtuN1stCd("000000");
				apInvDtrbVO3.setDtrbCoaFtuN2ndCd("000000");
				apInvDtrbVO3.setAttrCateNm      (sDtrbCoaAcctCdForTruncatedAmt);
				apInvDtrbVO3.setAttrCtnt3       (sAttrCntt3);
				apInvDtrbVO3.setActVvdCd        (sRevenueVvd);
				apInvDtrbVO3.setPlnSctrDivCd    (" ");
				apInvDtrbVO3.setCreDt           ("SYSDATE");
				apInvDtrbVO3.setCreUsrId        (account.getUsr_id());
				apInvDtrbVO3.setAttrCtnt11      (orgCsrNo);
				/*
				 * Create Distribute [end]
				 */
				apInvDtrbVOs.add(apInvDtrbVO3);

			}

//			dbDao.addApInvHdrList(apInvHdrVOs);

//			dbDao.addApInvDtrbList(apInvDtrbVOs);

			List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVOs = new ArrayList<SearchApSlipInterfaceListVO>();
			for (Iterator<ApInvDtrbVO> iterator = apInvDtrbVOs.iterator(); iterator.hasNext();) {
				ApInvDtrbVO tempApInvDtrbVO = iterator.next();
				SearchApSlipInterfaceListVO searchApSlipInterfaceListVO1 = new SearchApSlipInterfaceListVO();

				/*
				 * HEADER
				 */
				searchApSlipInterfaceListVO1.setHdrCsrNo       (apInvHdrVO.getCsrNo       ());
				searchApSlipInterfaceListVO1.setHdrCsrTpCd     (apInvHdrVO.getCsrTpCd     ());
				searchApSlipInterfaceListVO1.setHdrInvDt       (apInvHdrVO.getInvDt       ());
				searchApSlipInterfaceListVO1.setHdrInvTermDt   (apInvHdrVO.getInvTermDt   ());
				searchApSlipInterfaceListVO1.setHdrGlDt        (apInvHdrVO.getGlDt        ());
				searchApSlipInterfaceListVO1.setHdrVndrNo      (apInvHdrVO.getVndrNo      ());
				searchApSlipInterfaceListVO1.setHdrCsrAmt      (apInvHdrVO.getCsrAmt      ());
				searchApSlipInterfaceListVO1.setHdrCsrCurrCd   (apInvHdrVO.getCsrCurrCd   ());
				searchApSlipInterfaceListVO1.setHdrVndrTermNm  (apInvHdrVO.getVndrTermNm  ());
				searchApSlipInterfaceListVO1.setHdrInvDesc     (apInvHdrVO.getInvDesc     ());
				searchApSlipInterfaceListVO1.setHdrAttrCateNm  (apInvHdrVO.getAttrCateNm  ());
				searchApSlipInterfaceListVO1.setHdrAttrCtnt10  (apInvHdrVO.getAttrCtnt10  ());
				searchApSlipInterfaceListVO1.setHdrAttrCtnt15  (apInvHdrVO.getAttrCtnt15  ());
				searchApSlipInterfaceListVO1.setHdrSrcCtnt     (apInvHdrVO.getSrcCtnt     ());
				searchApSlipInterfaceListVO1.setHdrPayMzdLuCd  (apInvHdrVO.getPayMzdLuCd  ());
				searchApSlipInterfaceListVO1.setHdrPayGrpLuCd  (apInvHdrVO.getPayGrpLuCd  ());
				searchApSlipInterfaceListVO1.setHdrCoaCoCd     (apInvHdrVO.getCoaCoCd     ());
				searchApSlipInterfaceListVO1.setHdrCoaRgnCd    (apInvHdrVO.getCoaRgnCd    ());
				searchApSlipInterfaceListVO1.setHdrCoaCtrCd    (apInvHdrVO.getCoaCtrCd    ());
				searchApSlipInterfaceListVO1.setHdrCoaAcctCd   (apInvHdrVO.getCoaAcctCd   ());
				searchApSlipInterfaceListVO1.setHdrCoaVvdCd    (apInvHdrVO.getCoaVvdCd    ());
				searchApSlipInterfaceListVO1.setHdrCoaInterCoCd(apInvHdrVO.getCoaInterCoCd());
				searchApSlipInterfaceListVO1.setHdrCoaFtuN1stCd(apInvHdrVO.getCoaFtuN1stCd());
				searchApSlipInterfaceListVO1.setHdrCoaFtuN2ndCd(apInvHdrVO.getCoaFtuN2ndCd());
				searchApSlipInterfaceListVO1.setHdrAproFlg     (apInvHdrVO.getAproFlg     ());
				searchApSlipInterfaceListVO1.setHdrErrCsrNo    (apInvHdrVO.getErrCsrNo    ());
				searchApSlipInterfaceListVO1.setHdrTjOfcCd     (apInvHdrVO.getTjOfcCd     ());
				searchApSlipInterfaceListVO1.setHdrCreDt       (apInvHdrVO.getCreDt       ());
				searchApSlipInterfaceListVO1.setHdrCreUsrId    (apInvHdrVO.getCreUsrId    ());
				searchApSlipInterfaceListVO1.setHdrAttrCtnt11  (apInvHdrVO.getAttrCtnt11  ());
				/*
				 * DETAIL
				 */
				searchApSlipInterfaceListVO1.setDCsrNo           (tempApInvDtrbVO.getCsrNo           ());
				searchApSlipInterfaceListVO1.setDLineSeq         (tempApInvDtrbVO.getLineSeq         ());
				searchApSlipInterfaceListVO1.setDLineNo          (tempApInvDtrbVO.getLineNo          ());
				searchApSlipInterfaceListVO1.setDLineTpLuCd      (tempApInvDtrbVO.getLineTpLuCd      ());
				searchApSlipInterfaceListVO1.setDInvAmt          (tempApInvDtrbVO.getInvAmt          ());
				searchApSlipInterfaceListVO1.setDInvDesc         (tempApInvDtrbVO.getInvDesc         ());
				searchApSlipInterfaceListVO1.setDDtrbCoaCoCd     (tempApInvDtrbVO.getDtrbCoaCoCd     ());
				searchApSlipInterfaceListVO1.setDDtrbCoaRgnCd    (tempApInvDtrbVO.getDtrbCoaRgnCd    ());
				searchApSlipInterfaceListVO1.setDDtrbCoaCtrCd    (tempApInvDtrbVO.getDtrbCoaCtrCd    ());
				searchApSlipInterfaceListVO1.setDDtrbCoaAcctCd   (tempApInvDtrbVO.getDtrbCoaAcctCd   ());
				searchApSlipInterfaceListVO1.setDDtrbCoaVvdCd    (tempApInvDtrbVO.getDtrbCoaVvdCd    ());
				searchApSlipInterfaceListVO1.setDDtrbCoaInterCoCd(tempApInvDtrbVO.getDtrbCoaInterCoCd());
				searchApSlipInterfaceListVO1.setDDtrbCoaFtuN1stCd(tempApInvDtrbVO.getDtrbCoaFtuN1stCd());
				searchApSlipInterfaceListVO1.setDDtrbCoaFtuN2ndCd(tempApInvDtrbVO.getDtrbCoaFtuN2ndCd());
				searchApSlipInterfaceListVO1.setDAttrCateNm      (tempApInvDtrbVO.getAttrCateNm      ());
				searchApSlipInterfaceListVO1.setDAttrCtnt3       (tempApInvDtrbVO.getAttrCtnt3       ());
				searchApSlipInterfaceListVO1.setDActVvdCd        (tempApInvDtrbVO.getActVvdCd        ());
				searchApSlipInterfaceListVO1.setDPlnSctrDivCd    (tempApInvDtrbVO.getPlnSctrDivCd    ());
				searchApSlipInterfaceListVO1.setDCreDt           (tempApInvDtrbVO.getCreDt           ());
				searchApSlipInterfaceListVO1.setDCreUsrId        (tempApInvDtrbVO.getCreUsrId        ());
				searchApSlipInterfaceListVO1.setDAttrCtnt11      (tempApInvDtrbVO.getAttrCtnt11      ());

				searchApSlipInterfaceListVOs.add(searchApSlipInterfaceListVO1);
			}

//			eaiDao.interfaceKrWhfToAp(sCsrNo, searchApSlipInterfaceListVOs);
//			dbDao.addApInvIfSearch(sCsrNo, account.getUsr_id());

			return krWhfDecCondVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * Wharfage I/F
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void interfaceWhfCngNo(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {
		try{

			dbDao.modifyBkgKrWhfRtWhfCngNo((KrWhfDecCondVO)whfDecCondVO);

			manageWhfArInvIf(whfDecCondVO, account);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 * Wharfage I/F
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @return
	 * @throws EventException
	 */
	private WhfDecCondVO manageWhfArInvIf(WhfDecCondVO whfDecCondVO, SignOnUserAccount account)throws EventException{
		try{

			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
			List<KrWhfDecIfArInvVO> krWhfDecIfArInvVOs = dbDao.searchKrWhfDecIfArInv(krWhfDecCondVO);
			BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();

			String vvdCd = krWhfDecCondVO.getVvd();
			String whfBndCd =krWhfDecCondVO.getWhfBndCd();
			String portCd = krWhfDecCondVO.getPortCd();
			String cancelFlag = krWhfDecCondVO.getCancelFlag();

			for (Iterator<KrWhfDecIfArInvVO> iterator = krWhfDecIfArInvVOs.iterator(); iterator.hasNext();) {
				KrWhfDecIfArInvVO krWhfDecIfArInvVO = iterator.next();


				BkgKrWhfRtVO bkgKrWhfRtVO = new BkgKrWhfRtVO();
				bkgKrWhfRtVO.setVslCd(krWhfDecIfArInvVO.getVslCd());
				bkgKrWhfRtVO.setSkdVoyNo(krWhfDecIfArInvVO.getSkdVoyNo());
				bkgKrWhfRtVO.setSkdDirCd(krWhfDecIfArInvVO.getSkdDirCd());
				bkgKrWhfRtVO.setWhfBndCd(krWhfDecIfArInvVO.getWhfBndCd());
				bkgKrWhfRtVO.setBlNo(krWhfDecIfArInvVO.getBlNo());
				bkgKrWhfRtVO.setChgRtSeq(krWhfDecIfArInvVO.getChgRtSeq());
				bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());

				bkgKrWhfRtVO.setPagerows(krWhfDecCondVO.getCancelFlag());

				dbDao.modifyBkgKrWhfRtIfArInv(bkgKrWhfRtVO);
			}


			bookingARCreationBC.interfaceWHFARInvoiceToINV(vvdCd, whfBndCd, portCd, account.getUsr_id(), cancelFlag);


		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return whfDecCondVO;
	}

	/**
	 * AR I/F confirmed WHF
	 *
	 * @param WhfBlVO[] whfBlVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	@Override
	public String interfaceWhfToArInv(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {
		String sBAJobRtn = "";

		try{
			KrWhfBlContainerVO krWhfBlContainerVO = (KrWhfBlContainerVO)whfBlVOs[0];
			KrWhfBlInfoVO[] krWhfBlInfoVOs  = krWhfBlContainerVO.getKrWhfBlInfoVOs();
			KrWhfCgoClassCondVO krWhfCgoClassCondVO = krWhfBlContainerVO.getKrWhfCgoClassCondVO();
			BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
			KrWhfVslInfoCondVO krWhfVslInfoCondVO = new KrWhfVslInfoCondVO();
			ObjectCloner.build(krWhfCgoClassCondVO, krWhfVslInfoCondVO);

			if(dbDao.checkIfDecNoExist(krWhfVslInfoCondVO)){
				throw new EventException(new ErrorHandler("BKG06103",new String[]{}).getMessage());
			}
			if(krWhfBlInfoVOs == null){
				KrWhfDecCondVO krWhfDecCondVO = new KrWhfDecCondVO();
				ObjectCloner.build(krWhfCgoClassCondVO, krWhfDecCondVO);
				WhfDecCondVO condVO = manageWhfArInvIf((WhfDecCondVO)krWhfDecCondVO, account);
				sBAJobRtn = condVO.getSBAJobRtn();
			} else { // BL I/F
				BkgKrWhfRtVO bkgKrWhfRtVO = new BkgKrWhfRtVO();
				List<ARBkgInterfaceCreationVO> ListARBkgInterfaceCreationVO = new ArrayList<ARBkgInterfaceCreationVO>();
				for (int i = 0; i < krWhfBlInfoVOs.length; i++) {
					KrWhfBlInfoVO krWhfBlInfoVO = krWhfBlInfoVOs[i];
					ARBkgInterfaceCreationVO bkgInterfaceCreationVO = new ARBkgInterfaceCreationVO();
					bkgInterfaceCreationVO.setBkgNo(krWhfBlInfoVO.getBkgNo());
					bkgInterfaceCreationVO.setVvdCd(krWhfBlInfoVO.getVvd());
					bkgInterfaceCreationVO.setManDivInd("B");
					bkgInterfaceCreationVO.setUserId(account.getUsr_id());

					ListARBkgInterfaceCreationVO.add(bkgInterfaceCreationVO);

					bkgKrWhfRtVO.setVslCd(krWhfBlInfoVO.getVvd().substring(0, 4));
					bkgKrWhfRtVO.setSkdVoyNo(krWhfBlInfoVO.getVvd().substring(4, 8));
					bkgKrWhfRtVO.setSkdDirCd(krWhfBlInfoVO.getVvd().substring(8, 9));
					bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());
					bkgKrWhfRtVO.setWhfBndCd(krWhfBlInfoVO.getWhfBndCd());
					bkgKrWhfRtVO.setBlNo(krWhfBlInfoVO.getBlNo());
					dbDao.modifyBkgKrWhfRtIfArInv(bkgKrWhfRtVO);

				}
				sBAJobRtn = bookingARCreationBC.interfaceBKGARInvoiceToINV(ListARBkgInterfaceCreationVO);
			}
			return sBAJobRtn;

		} catch(DAOException dx) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), dx);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), e);
		}

	}



}