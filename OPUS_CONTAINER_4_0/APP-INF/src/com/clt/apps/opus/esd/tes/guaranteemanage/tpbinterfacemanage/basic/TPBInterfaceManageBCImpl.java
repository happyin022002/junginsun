/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TPBInterfaceManageBCImpl.java
 *@FileTitle : Guarantee TPB I/F
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration.TPBInterfaceManageDBDAO;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.vo.SearchGuaranteeTPBIfDataVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.vo.SearchRevVVDListVO;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;

/**
 * TPBInterfaceManage Business Logic Command Interface<br>
 * 
 * @author yOng hO lEE
 * @see GuarnateeManageSC
 * @since J2EE 1.6
 */
public class TPBInterfaceManageBCImpl extends BasicCommandSupport implements TPBInterfaceManageBC {

	// Database Access Object
	private transient TPBInterfaceManageDBDAO dbDao = null;

	/**
	 * TPBInterfaceManageBCImpl object creation<br>
	 * TPBInterfaceManageDBDAO creation<br>
	 */
	public TPBInterfaceManageBCImpl() {
		dbDao = new TPBInterfaceManageDBDAO();
	}

	/**
	 * [Guarantee TPB I/F] [Select] <br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeTPBIfDataVO>
	 * @exception EventException
	 */
	public List<SearchGuaranteeTPBIfDataVO> searchGuaranteeTPBIfData(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			return dbDao.searchGuaranteeTPBIfData(guaranteeCommonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * [Guarantee TPB I/F Revenue VVD] [Select] <br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param TesN3rdPtyIfVO[] tesN3rdPtyIfVOs
	 * @return TesN3rdPtyIfVO[]
	 * @exception EventException
	 */
	public TesN3rdPtyIfVO[] searchRevVVDList(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, TesN3rdPtyIfVO[] tesN3rdPtyIfVOs) throws EventException {
		List<SearchRevVVDListVO> list = new ArrayList<SearchRevVVDListVO>();

		TesGnteCntrListVO tesGnteCntrListVO = null;
		SearchRevVVDListVO searchRevVVDListVO = null;

		String fincVslCd = "";
		String fincSkdVoyNo = "";
		String fincSkdDirCd = "";

		try {

			for (int i = 0; tesGnteCntrListVOs != null && i < tesGnteCntrListVOs.length; i++) {
				tesGnteCntrListVO = tesGnteCntrListVOs[i];

				list = dbDao.searchRevVVDList(tesGnteHdrVO, tesGnteCntrListVO);
				searchRevVVDListVO = list.get(0);

				if (!"".equals(searchRevVVDListVO.getRevVvd())) {
					fincVslCd = searchRevVVDListVO.getRevVvd().substring(0, 4);
					fincSkdVoyNo = searchRevVVDListVO.getRevVvd().substring(4, 8);
					fincSkdDirCd = searchRevVVDListVO.getRevVvd().substring(8);
				}

				tesN3rdPtyIfVOs[i].setFincVslCd(fincVslCd);
				tesN3rdPtyIfVOs[i].setFincSkdVoyNo(fincSkdVoyNo);
				tesN3rdPtyIfVOs[i].setFincSkdDirCd(fincSkdDirCd);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return tesN3rdPtyIfVOs;
	}

	/**
	 * [Guarantee TPB I/F] [Insert] <br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param TesN3rdPtyIfVO[] tesN3rdPtyIfVOs
	 * @param account SignOnUserAccount
	 * @return TesGnteCntrListVO[]
	 * @exception EventException
	 */
	public TesGnteCntrListVO[] addGuaranteeTPBIfData(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, TesN3rdPtyIfVO[] tesN3rdPtyIfVOs, SignOnUserAccount account) throws EventException {
		List<TesN3rdPtyIfVO> insertVoList = new ArrayList<TesN3rdPtyIfVO>();

		int tpbSeq = 0;

		try {

			int maxSeq = dbDao.searchGuaranteeTPBIfDataSeq(account.getOfc_cd());

			for (int i = 0; tesGnteCntrListVOs != null && i < tesGnteCntrListVOs.length; i++) {

				if ("I".equals(tesGnteCntrListVOs[i].getIbflag())) {
					tpbSeq = maxSeq++;
					tesN3rdPtyIfVOs[i].setTmlIfOfcCd(account.getOfc_cd());
					tesN3rdPtyIfVOs[i].setTmlIfSeq(String.valueOf(tpbSeq));
					tesN3rdPtyIfVOs[i].setCurrCd(tesGnteHdrVO.getCurrCd());
					tesN3rdPtyIfVOs[i].setInvNo(tesGnteHdrVO.getGnteNo());
					tesN3rdPtyIfVOs[i].setN3ptyBilTpCd(tesGnteHdrVO.getGnteTpCd());
					tesN3rdPtyIfVOs[i].setVndrCustDivCd("C");
					tesN3rdPtyIfVOs[i].setCustCntCd(tesGnteHdrVO.getGnteCustCd().substring(0, 2));
					tesN3rdPtyIfVOs[i].setCustSeq(tesGnteHdrVO.getGnteCustCd().substring(2, 8));
					tesN3rdPtyIfVOs[i].setYdCd(tesGnteHdrVO.getYdCd());
					tesN3rdPtyIfVOs[i].setIfAmt(tesN3rdPtyIfVOs[i].getIfAmt().replaceAll("\\,", ""));
					tesN3rdPtyIfVOs[i].setIfRmk(tesN3rdPtyIfVOs[i].getN3ptyDesc().replaceAll("\\,", ""));
					tesN3rdPtyIfVOs[i].setGnteDivFlg("Y"); // Guarantee TPB IF "Y"
					tesN3rdPtyIfVOs[i].setCreUsrId(account.getUsr_id());
					tesN3rdPtyIfVOs[i].setUpdUsrId(account.getUsr_id());

					insertVoList.add(tesN3rdPtyIfVOs[i]);

					// TPB I/F 처리후 Update 정보.
					tesGnteCntrListVOs[i].setTmlIfOfcCd(account.getOfc_cd());
					tesGnteCntrListVOs[i].setTmlIfSeq(String.valueOf(tpbSeq));
					tesGnteCntrListVOs[i].setIbflag("U");
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addGuaranteeTPBIfData(insertVoList, account.getOfc_cd());
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return tesGnteCntrListVOs;
	}

	/**
	 * [Guarantee TPB I/F] [TPB Interface Procedure Call] <br>
	 * 
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @return boolean
	 * @exception EventException
	 */
	public boolean sendGuaranteeTPBIfData(TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException {
		TPBInterfaceBCImpl tbpIF = new TPBInterfaceBCImpl();
		TPBInterfaceVO[] tpbInterfaceVOs = new TPBInterfaceVO[tesGnteCntrListVOs.length];

		boolean isSuccessful = false;

		try {

			for (int i = 0; tpbInterfaceVOs != null && i < tpbInterfaceVOs.length; i++) {
				tpbInterfaceVOs[i] = new TPBInterfaceVO();

				tpbInterfaceVOs[i].setTmlIfOfcCd((String) tesGnteCntrListVOs[i].getTmlIfOfcCd());
				tpbInterfaceVOs[i].setTmlIfSeq((String) tesGnteCntrListVOs[i].getTmlIfSeq());
			}

			isSuccessful = tbpIF.createTESTPB(tpbInterfaceVOs, account);

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}

	/**
	 * [Guarantee TPB I/F] [Update] <br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO[] tesGnteCntrListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void updateGuaranteeTPBIfDataSts(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO[] tesGnteCntrListVOs, SignOnUserAccount account) throws EventException {
		List<TesGnteCntrListVO> updateVoList = new ArrayList<TesGnteCntrListVO>();

		try {
			for (int i = 0; tesGnteCntrListVOs != null && i < tesGnteCntrListVOs.length; i++) {

				if ("U".equals(tesGnteCntrListVOs[i].getIbflag())) {
					// TML_IF_OFC_CD, TML_IF_SEQ Update
					tesGnteCntrListVOs[i].setGnteNo(tesGnteHdrVO.getGnteNo());
					tesGnteCntrListVOs[i].setGnteProcTpCd("T"); // TPB I/F Container.
					tesGnteCntrListVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(tesGnteCntrListVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyGuaranteeTPBIfDataSts(updateVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}