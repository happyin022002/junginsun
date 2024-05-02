/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ManifestListDownloadBCImpl.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration.DubaiManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiCstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiVesselManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.clt.syscommon.common.table.BkgCstmsDuBlVO;
import com.clt.syscommon.common.table.BkgCstmsDuCntrMfVO;
import com.clt.syscommon.common.table.BkgCstmsDuCntrVO;
import com.clt.syscommon.common.table.BkgCstmsDuCustVO;
import com.clt.syscommon.common.table.BkgCstmsDuVvdVO;


/**
 * OPUS-DubaiManifestListDownload Business Logic Command implementation<br>
 * - OPUS-DubaiManifestListDownload handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class DubaiManifestListDownloadBCImpl extends BasicCommandSupport implements DubaiManifestListDownloadBC {

	private transient DubaiManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl Object creating<br>
	 *  creating ManifestListDownloadDBDAObr>
	 */
	public DubaiManifestListDownloadBCImpl() {
		dbDao = new DubaiManifestListDownloadDBDAO();
	}

	/**
	 *  B/L List for customs declaration Retrieve
	 *
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try
		{
			// Retrieve
			DubaiManifestListCondVO dubaiManifestListCondVO = (DubaiManifestListCondVO) manifestListCondVO;
			// return List
			List<ManifestListDetailVO> manifestListDetailVOs = new ArrayList<ManifestListDetailVO>();
			// Container VO to setting
			DubaiManifestListVO dubaiManifestListVO = new DubaiManifestListVO();
			dubaiManifestListVO.setDubaiBlManifestListVOs(dbDao.searchDubaiBlManifestList(dubaiManifestListCondVO));
			dubaiManifestListVO.setDubaiCntrManifestListVOs(dbDao.searchDubaiCntrManifestList(dubaiManifestListCondVO));
			// add
			manifestListDetailVOs.add(dubaiManifestListVO);
			return manifestListDetailVOs;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  download List for customs declaration in customs table
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			//
			DubaiManifestListVO dubaiManifestListVO = (DubaiManifestListVO) manifestListDetailVOs[0];
			DubaiManifestListCondVO dubaiManifestListCondVO = dubaiManifestListVO.getDubaiManifestListCondVO();

			if ("bl".equals(dubaiManifestListCondVO.getDataType()))
			{
				/***************************************************
				 *  Download in customs table<BR>
				 * 1. customs table deleting <BR>
				 * 2. customs table registration<BR>
				 * 3. modifying modified Information to Dubai table<BR>
				 ***************************************************/
				// Log in ID
				dubaiManifestListCondVO.setUpdUsrId(account.getUsr_id());
				dbDao.removeBkgCstmsDuCntrMf(dubaiManifestListCondVO);
				dbDao.removeBkgCstmsDuCntr(dubaiManifestListCondVO);
				dbDao.removeBkgCstmsDuCust(dubaiManifestListCondVO);
				dbDao.removeBkgCstmsDuBl(dubaiManifestListCondVO);
//				dbDao.removeBkgCstmsDuVvd(dubaiManifestListCondVO);
				/***************************************************
				 * VVD
				 ***************************************************/
				if (dbDao.searchDubaiVesselManifestList(dubaiManifestListCondVO).size() == 0)
				{
					dbDao.addBkgCstmsDuVvd(dubaiManifestListCondVO);
				}
				else
				{
					BkgCstmsDuVvdVO bkgCstmsDuVvdVO = new BkgCstmsDuVvdVO();
					ObjectCloner.build(dubaiManifestListVO.getDubaiBlManifestListVOs().get(0), bkgCstmsDuVvdVO);
					bkgCstmsDuVvdVO.setEtaDt(dubaiManifestListCondVO.getEtaDt());
					bkgCstmsDuVvdVO.setDuRotnNo(dubaiManifestListCondVO.getRotnNo());
					bkgCstmsDuVvdVO.setDuInstlNo(dubaiManifestListCondVO.getInstlNo());
					bkgCstmsDuVvdVO.setDuMrnNo(dubaiManifestListCondVO.getMrnNo());
					bkgCstmsDuVvdVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgCstmsDuVvd(bkgCstmsDuVvdVO);
				}
				/***************************************************
				 * B/L
				 ***************************************************/
				dbDao.addBkgCstmsDuBl(dubaiManifestListCondVO);
				/***************************************************
				 * Customer
				 ***************************************************/
				dbDao.addBkgCstmsDuCust(dubaiManifestListCondVO);
				/***************************************************
				 * Container, MF
				 ***************************************************/
				dbDao.addBkgCstmsDuCntr(dubaiManifestListCondVO);
				dbDao.addBkgCstmsDuCntrMf(dubaiManifestListCondVO);
				// modified Information Update
				modifyCstmsDubai(dubaiManifestListCondVO, dubaiManifestListVO, account);
			}
			else if ("dl".equals(dubaiManifestListCondVO.getDataType()))
			{
				/***************************************************
				 * VVD
				 ***************************************************/
				if (dubaiManifestListVO.getDubaiBlManifestListVOs().size() > 0)
				{
					BkgCstmsDuVvdVO bkgCstmsDuVvdVO = new BkgCstmsDuVvdVO();
					ObjectCloner.build(dubaiManifestListVO.getDubaiBlManifestListVOs().get(0), bkgCstmsDuVvdVO);
					bkgCstmsDuVvdVO.setEtaDt(dubaiManifestListCondVO.getEtaDt());
					bkgCstmsDuVvdVO.setDuRotnNo(dubaiManifestListCondVO.getRotnNo());
					bkgCstmsDuVvdVO.setDuInstlNo(dubaiManifestListCondVO.getInstlNo());
					bkgCstmsDuVvdVO.setUpdUsrId(account.getUsr_id());
					dbDao.modifyBkgCstmsDuVvd(bkgCstmsDuVvdVO);
				}
				/***************************************************
				 * B/L, Customer, Container, C/M
				 ***************************************************/
				modifyCstmsDubai(dubaiManifestListCondVO, dubaiManifestListVO, account);
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return null;
	}

	/**
	 * BL modifying
	 *
	 * @param dubaiManifestListCondVO
	 * @param dubaiManifestListVO
	 * @param account
	 * @throws DAOException
	 */
	private void modifyCstmsDubai(DubaiManifestListCondVO dubaiManifestListCondVO,
			DubaiManifestListVO dubaiManifestListVO, SignOnUserAccount account) throws DAOException, EventException {
		/***************************************************
		 * B/L
		 ***************************************************/
		// modified Information Update
		List<BkgCstmsDuBlVO> modBl = new ArrayList<BkgCstmsDuBlVO>();
		for (int i = 0; i < dubaiManifestListVO.getDubaiBlManifestListVOs().size(); i++)
		{
			if ("U".equals(dubaiManifestListVO.getDubaiBlManifestListVOs().get(i).getIbflag()))
			{
				BkgCstmsDuBlVO bkgCstmsDuBlVO = new BkgCstmsDuBlVO();
				ObjectCloner.build(dubaiManifestListVO.getDubaiBlManifestListVOs().get(i), bkgCstmsDuBlVO);
				bkgCstmsDuBlVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsDuBlVO.setDuRotnNo(dubaiManifestListCondVO.getRotnNo());
				bkgCstmsDuBlVO.setIbflag("I");
				modBl.add(bkgCstmsDuBlVO);
			}
		}
		dbDao.modifyBkgCstmsDuBl(modBl);
		/***************************************************
		 * Customer
		 ***************************************************/
		//  modified Information Update
		List<BkgCstmsDuCustVO> modCust = new ArrayList<BkgCstmsDuCustVO>();
		for (int i = 0; i < dubaiManifestListVO.getDubaiBlManifestListVOs().size(); i++)
		{
			if ("U".equals(dubaiManifestListVO.getDubaiBlManifestListVOs().get(i).getIbflag()))
			{
				BkgCstmsDuCustVO bkgCstmsDuCustVO = new BkgCstmsDuCustVO();
				ObjectCloner.build(dubaiManifestListVO.getDubaiBlManifestListVOs().get(i), bkgCstmsDuCustVO);
				bkgCstmsDuCustVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsDuCustVO.setIbflag("I");
				modCust.add(bkgCstmsDuCustVO);
			}
		}
		dbDao.modifyBkgCstmsDuCust(modCust);
		/***************************************************
		 * Container
		 ***************************************************/
		//  modified Information Update
		List<BkgCstmsDuCntrVO> modCntr = new ArrayList<BkgCstmsDuCntrVO>();
		List<BkgCstmsDuCntrMfVO> modCntrMf = new ArrayList<BkgCstmsDuCntrMfVO>();
		String preCntrNo = "";
		for (int i = 0; i < dubaiManifestListVO.getDubaiCntrManifestListVOs().size(); i++)
		{
			//Cntr No can be duplicated because of MF List
			if (!preCntrNo.equals(dubaiManifestListVO.getDubaiCntrManifestListVOs().get(i).getCntrNo()))
			{
				BkgCstmsDuCntrVO bkgCstmsDuCntrVO = new BkgCstmsDuCntrVO();
				ObjectCloner.build(dubaiManifestListVO.getDubaiCntrManifestListVOs().get(i), bkgCstmsDuCntrVO);
				bkgCstmsDuCntrVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsDuCntrVO.setIbflag("I");
				modCntr.add(bkgCstmsDuCntrVO);
			}
			preCntrNo = dubaiManifestListVO.getDubaiCntrManifestListVOs().get(i).getCntrNo();
			BkgCstmsDuCntrMfVO bkgCstmsDuCntrMfVO = new BkgCstmsDuCntrMfVO();
			ObjectCloner.build(dubaiManifestListVO.getDubaiCntrManifestListVOs().get(i), bkgCstmsDuCntrMfVO);
			bkgCstmsDuCntrMfVO.setUpdUsrId(account.getUsr_id());
			bkgCstmsDuCntrMfVO.setIbflag("I");
			modCntrMf.add(bkgCstmsDuCntrMfVO);
		}
		dbDao.modifyBkgCstmsDuCntr(modCntr);
		dbDao.modifyBkgCstmsDuCntrMf(modCntrMf);
	}

	/**
	 *  Package Unit Retrieve for country
	 *
	 * @param bkgCstmsCdConvCtntVO
	 * @return List<BkgCstmsCdConvCtntVO>
	 * @throws EventException
	 */
	public List<BkgCstmsCdConvCtntVO> searchPkgUnitList(BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO) throws EventException {
		try
		{
			return dbDao.searchPkgUnitList(bkgCstmsCdConvCtntVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BL detail Retrieve
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestInfo(ManifestListCondVO manifestListCondVO) throws EventException {
		try
		{
			return dbDao.searchDubaiManifestInfo((DubaiManifestListCondVO) manifestListCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BL, Customer modifying
	 *
	 * @param cstmsBlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException {
		try
		{
			// screen detail modifying
			DubaiCstmsBlVO dubaiCstmsBlVO = (DubaiCstmsBlVO) cstmsBlVOs[0];
			/***************************************************
			 * B/L
			 ***************************************************/
			List<BkgCstmsDuBlVO> bkgCstmsDuBls = new ArrayList<BkgCstmsDuBlVO>();
			BkgCstmsDuBlVO bkgCstmsDuBlVO = new BkgCstmsDuBlVO();
			ObjectCloner.build(dubaiCstmsBlVO, bkgCstmsDuBlVO);
			bkgCstmsDuBlVO.setIbflag("U");
			bkgCstmsDuBlVO.setUpdUsrId(account.getUsr_id());
			bkgCstmsDuBls.add(bkgCstmsDuBlVO);
			dbDao.modifyBkgCstmsDuBl(bkgCstmsDuBls);
			/***************************************************
			 * Customer
			 ***************************************************/
			List<BkgCstmsDuCustVO> bkgCstmsDuCusts = new ArrayList<BkgCstmsDuCustVO>();
			// Shipper
			BkgCstmsDuCustVO bkgCstmsDuCust1 = new BkgCstmsDuCustVO();
			bkgCstmsDuCust1.setBlNo(dubaiCstmsBlVO.getBlNo());
			bkgCstmsDuCust1.setPodCd(dubaiCstmsBlVO.getPodCd());
			bkgCstmsDuCust1.setBkgCustTpCd("S");
			bkgCstmsDuCust1.setCustCntCd(dubaiCstmsBlVO.getSCustCntCd());
			bkgCstmsDuCust1.setCustNm(dubaiCstmsBlVO.getSCustNm());
			bkgCstmsDuCust1.setCustAddr(dubaiCstmsBlVO.getSCustAddr());
			bkgCstmsDuCust1.setOrgCustNm(dubaiCstmsBlVO.getSOrgCustNm());
			bkgCstmsDuCust1.setOrgCustAddr(dubaiCstmsBlVO.getSOrgCustAddr());
			bkgCstmsDuCust1.setUpdUsrId(account.getUsr_id());
			bkgCstmsDuCust1.setIbflag("U");
			// Consignee
			BkgCstmsDuCustVO bkgCstmsDuCust2 = new BkgCstmsDuCustVO();
			bkgCstmsDuCust2.setBlNo(dubaiCstmsBlVO.getBlNo());
			bkgCstmsDuCust2.setPodCd(dubaiCstmsBlVO.getPodCd());
			bkgCstmsDuCust2.setBkgCustTpCd("C");
			bkgCstmsDuCust2.setDuCustId(dubaiCstmsBlVO.getCDuCustId());
			bkgCstmsDuCust2.setCustNm(dubaiCstmsBlVO.getCCustNm());
			bkgCstmsDuCust2.setCustAddr(dubaiCstmsBlVO.getCCustAddr());
			bkgCstmsDuCust2.setOrgCustNm(dubaiCstmsBlVO.getCOrgCustNm());
			bkgCstmsDuCust2.setOrgCustAddr(dubaiCstmsBlVO.getCOrgCustAddr());
			bkgCstmsDuCust2.setUpdUsrId(account.getUsr_id());
			bkgCstmsDuCust2.setIbflag("U");
			// Notify
			BkgCstmsDuCustVO bkgCstmsDuCust3 = new BkgCstmsDuCustVO();
			bkgCstmsDuCust3.setBlNo(dubaiCstmsBlVO.getBlNo());
			bkgCstmsDuCust3.setPodCd(dubaiCstmsBlVO.getPodCd());
			bkgCstmsDuCust3.setBkgCustTpCd("N");
			bkgCstmsDuCust3.setCustNm(dubaiCstmsBlVO.getNCustNm());
			bkgCstmsDuCust3.setCustAddr(dubaiCstmsBlVO.getNCustAddr());
			bkgCstmsDuCust3.setUpdUsrId(account.getUsr_id());
			bkgCstmsDuCust3.setIbflag("U");
			bkgCstmsDuCusts.add(bkgCstmsDuCust1);
			bkgCstmsDuCusts.add(bkgCstmsDuCust2);
			bkgCstmsDuCusts.add(bkgCstmsDuCust3);
			dbDao.modifyBkgCstmsDuCust(bkgCstmsDuCusts);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD Information for customs creating, modifying, deleting
	 * @param CstmsVvdInfoVO[] cstmsVvdInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsVvdInfo(CstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException {
		try
		{
			DubaiVesselManifestListVO vvd = (DubaiVesselManifestListVO) cstmsVvdInfoVOs[0];
			BkgCstmsDuVvdVO bkgCstmsDuVvdVO = new BkgCstmsDuVvdVO();
			ObjectCloner.build(vvd, bkgCstmsDuVvdVO);
			bkgCstmsDuVvdVO.setIbflag("EDI");
			dbDao.modifyBkgCstmsDuVvd(bkgCstmsDuVvdVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
}