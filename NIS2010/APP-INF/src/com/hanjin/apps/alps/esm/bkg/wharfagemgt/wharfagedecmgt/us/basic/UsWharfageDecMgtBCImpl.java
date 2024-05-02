/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsWharfageDecMgtBCImpl.java
 *@FileTitle : UsWharfageDecMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.25 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.basic.WharfageDecMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration.UsWharfageDecMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration.UsWharfageDecMgtEAIDAO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfEmlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfEmlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfExceptCmdtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfExceptCmdtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfPortRtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendQtyVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfEmlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfEmlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExceptCmdtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExceptCmdtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfSendCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfSendVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfBlVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfBlkCgoVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfCntrVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfEmlVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfExptCmdtVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfRtDtlVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfRtVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndHisVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndQtyVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndVO;

/**
 * NIS2010-WharfageDecMgt Business Logic Basic Command implementation<br>
 * - NIS2010-WharfageDecMgt 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Min jeong
 * @see UsWharfageDecMgtDBDAO 참조
 * @since J2EE 1.4
 */
public class UsWharfageDecMgtBCImpl extends WharfageDecMgtBCImpl {
	// Database Access Object
	private transient UsWharfageDecMgtDBDAO dbDao = null;

	/**
	 * UsWharfageDecMgtBCImpl 객체 생성<br>
	 * UsWharfageDecMgtDBDAO 생성한다.<br>
	 */
	public UsWharfageDecMgtBCImpl() {
		dbDao = new UsWharfageDecMgtDBDAO();
	}

	/**
	 * Wharfage 면제 Commoidty 목록 조회
	 * 
	 * @param whfExceptCmdtListCondVO 조회조건
	 * @return List<WhfExceptCmdtVO>
	 * @throws EventException
	 */
	public List<WhfExceptCmdtVO> searchWhfExceptCmdtList(WhfExceptCmdtListCondVO whfExceptCmdtListCondVO)
			throws EventException {
		try
		{
			return dbDao.searchUsWhfExceptCmdtList((UsWhfExceptCmdtListCondVO) whfExceptCmdtListCondVO);
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
	 * Wharfage 면제 Commodity 관리
	 * 
	 * @param whfExceptCmdtVOs Wharfage 면제 Commodity
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageWhfExceptCmdt(WhfExceptCmdtVO[] whfExceptCmdtVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			// 등록
			List<BkgUsaWhfExptCmdtVO> addList = new ArrayList<BkgUsaWhfExptCmdtVO>();
			// 수정
			List<BkgUsaWhfExptCmdtVO> updList = new ArrayList<BkgUsaWhfExptCmdtVO>();
			// 삭제
			List<BkgUsaWhfExptCmdtVO> delList = new ArrayList<BkgUsaWhfExptCmdtVO>();
			for (int i = 0; i < whfExceptCmdtVOs.length; i++)
			{
				BkgUsaWhfExptCmdtVO bkgUsaWhfExptCmdtVO = new BkgUsaWhfExptCmdtVO();
				UsWhfExceptCmdtVO usWhfExceptCmdtVO = (UsWhfExceptCmdtVO) whfExceptCmdtVOs[i];
				usWhfExceptCmdtVO.setUpdUsrId(account.getUsr_id());
				// usWhfExceptCmdtVO -> bkgUsaWhfCmdtVO 복사
				ObjectCloner.build(usWhfExceptCmdtVO, bkgUsaWhfExptCmdtVO);
				if ("I".equals(usWhfExceptCmdtVO.getIbflag()))
				{
					bkgUsaWhfExptCmdtVO.setPortCd("USLGB");
					addList.add(bkgUsaWhfExptCmdtVO);
				}
				if ("U".equals(usWhfExceptCmdtVO.getIbflag()))
				{
					updList.add(bkgUsaWhfExptCmdtVO);
				}
				if ("D".equals(usWhfExceptCmdtVO.getIbflag()))
				{
					delList.add(bkgUsaWhfExptCmdtVO);
				}
			}
			if (addList.size() > 0)
			{
				dbDao.addBkgUsaWhfExptCmdt(addList);
			}
			if (updList.size() > 0)
			{
				dbDao.modifyBkgUsaWhfExptCmdt(updList);
			}
			if (delList.size() > 0)
			{
				dbDao.removeBkgUsaWhfExptCmdt(delList);
			}
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
	 * Wharfage Table Download
	 * 
	 * @param whfBlListCondVO 조회조건
	 * @return String
	 * @throws EventException
	 */
	public String downloadWhfBlCntr(WhfBlListCondVO whfBlListCondVO) throws EventException {
		try
		{
			UsWhfBlListCondVO usWhfBlListCondVO = (UsWhfBlListCondVO) whfBlListCondVO;
			UsWharfageDecMgtBackEndJob usWharfageDecMgtBackEndJob = new UsWharfageDecMgtBackEndJob();
			usWharfageDecMgtBackEndJob.setUsWhfBlListCondVO(usWhfBlListCondVO);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(usWharfageDecMgtBackEndJob, usWhfBlListCondVO.getCreUsrId(),
					"USA Wharfage B/L(LGB)");
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * WHF BL 목록 조회
	 * 
	 * @param whfBlListCondVO 조회조건
	 * @return List<WhfBlVO>
	 * @throws EventException
	 */
	public List<WhfBlVO> searchWhfBlList(WhfBlListCondVO whfBlListCondVO) throws EventException {
		try
		{
			UsWhfBlListCondVO usWhfBlListCondVO = (UsWhfBlListCondVO) whfBlListCondVO;
			return dbDao.searchUsWhfBlList(usWhfBlListCondVO);
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
	 * WHF BL 목록 조회
	 * 
	 * @param whfBlListCondVO 조회조건
	 * @return List<WhfBlVO>
	 * @throws EventException
	 */
	public List<WhfBlVO> searchWhfBlCntrList(WhfBlListCondVO whfBlListCondVO) throws EventException {
		try
		{
			return dbDao.searchUsWhfBlCntrList((UsWhfBlListCondVO) whfBlListCondVO);
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
	 * 다운로드 받은 WHF BL 정보 관리
	 * 
	 * @param whfBlVOs WHF BL 정보 
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageWhfBl(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {
		try
		{
			// 등록
			List<BkgUsaWhfBlVO> addBlList = new ArrayList<BkgUsaWhfBlVO>();
			List<BkgUsaWhfCntrVO> addCntrList = new ArrayList<BkgUsaWhfCntrVO>();
			// 수정
			List<BkgUsaWhfCntrVO> updCntrList = new ArrayList<BkgUsaWhfCntrVO>();
			// 삭제
			List<BkgUsaWhfBlVO> delBlList = new ArrayList<BkgUsaWhfBlVO>();
			List<BkgUsaWhfCntrVO> delCntrList = new ArrayList<BkgUsaWhfCntrVO>();
			for (int i = 0; i < whfBlVOs.length; i++)
			{
				UsWhfBlVO usWhfBlVO = (UsWhfBlVO) whfBlVOs[i];
				// BL
				BkgUsaWhfBlVO bkgUsaWhfBlVO = new BkgUsaWhfBlVO();
				// Container
				BkgUsaWhfCntrVO bkgUsaWhfCntrVO = new BkgUsaWhfCntrVO();
				// User Id
				bkgUsaWhfBlVO.setCreUsrId(account.getUsr_id());
				bkgUsaWhfBlVO.setUpdUsrId(account.getUsr_id());
				bkgUsaWhfCntrVO.setCreUsrId(account.getUsr_id());
				bkgUsaWhfCntrVO.setUpdUsrId(account.getUsr_id());
				if ("I".equals(usWhfBlVO.getIbflag()))
				{
					// BKG_USA_WHF_BL
					bkgUsaWhfBlVO.setVslCd(usWhfBlVO.getVslCd());
					bkgUsaWhfBlVO.setSkdVoyNo(usWhfBlVO.getSkdVoyNo());
					bkgUsaWhfBlVO.setSkdDirCd(usWhfBlVO.getSkdDirCd());
					bkgUsaWhfBlVO.setPortCd(usWhfBlVO.getPortCd());
					bkgUsaWhfBlVO.setIoBndCd(usWhfBlVO.getIoBndCd());
					bkgUsaWhfBlVO.setBlNo(usWhfBlVO.getBlNo());
					bkgUsaWhfBlVO.setCstmsDesc(usWhfBlVO.getCstmsDesc());
					bkgUsaWhfBlVO.setOrgDestLocCd(usWhfBlVO.getOrgDestLocCd());
					// BKG_USA_WHF_CNTR
					bkgUsaWhfCntrVO.setVslCd(usWhfBlVO.getVslCd());
					bkgUsaWhfCntrVO.setSkdVoyNo(usWhfBlVO.getSkdVoyNo());
					bkgUsaWhfCntrVO.setSkdDirCd(usWhfBlVO.getSkdDirCd());
					bkgUsaWhfCntrVO.setPortCd(usWhfBlVO.getPortCd());
					bkgUsaWhfCntrVO.setIoBndCd(usWhfBlVO.getIoBndCd());
					bkgUsaWhfCntrVO.setBlNo(usWhfBlVO.getBlNo());
					bkgUsaWhfCntrVO.setCntrNo(usWhfBlVO.getCntrNo());
					bkgUsaWhfCntrVO.setFullMtyCd(usWhfBlVO.getFullMtyCd());
					// 직접 입력한 경우 CntrTpszCd가 없다
					if ("".equals(usWhfBlVO.getCntrTpszCd()))
					{
						if (!"".equals(usWhfBlVO.getFt20()))
						{
							bkgUsaWhfCntrVO.setCntrTpszCd("D2");
							bkgUsaWhfCntrVO.setUsaWhfRatUtCd("20F");
							bkgUsaWhfCntrVO.setCntrVolQty(usWhfBlVO.getFt20());
							bkgUsaWhfCntrVO.setRatAsQty(usWhfBlVO.getFt20());
						}
						else if (!"".equals(usWhfBlVO.getFt40()))
						{
							bkgUsaWhfCntrVO.setCntrTpszCd("D4");
							bkgUsaWhfCntrVO.setUsaWhfRatUtCd("40F");
							bkgUsaWhfCntrVO.setCntrVolQty(usWhfBlVO.getFt40());
							bkgUsaWhfCntrVO.setRatAsQty(usWhfBlVO.getFt40());
						}
						else if (!"".equals(usWhfBlVO.getFt45()))
						{
							bkgUsaWhfCntrVO.setCntrTpszCd("D7");
							bkgUsaWhfCntrVO.setUsaWhfRatUtCd("45F");
							bkgUsaWhfCntrVO.setCntrVolQty(usWhfBlVO.getFt45());
							bkgUsaWhfCntrVO.setRatAsQty(usWhfBlVO.getFt45());
						}
					}
					else
					{
						bkgUsaWhfCntrVO.setCntrTpszCd(usWhfBlVO.getCntrTpszCd());
						bkgUsaWhfCntrVO.setUsaWhfRatUtCd(usWhfBlVO.getUsaWhfRatUtCd());
						bkgUsaWhfCntrVO.setCntrVolQty(usWhfBlVO.getRatAsQty());
						bkgUsaWhfCntrVO.setRatAsQty(usWhfBlVO.getRatAsQty());
					}
					if ("I".equals(usWhfBlVO.getIoBndCd()))
					{
						bkgUsaWhfCntrVO.setDeTermCd(usWhfBlVO.getTerm());
					}
					else
					{
						bkgUsaWhfCntrVO.setRcvTermCd(usWhfBlVO.getTerm());
					}
					bkgUsaWhfCntrVO.setUsaWhfTrspTpCd(usWhfBlVO.getUsaWhfTrspTpCd());
					bkgUsaWhfCntrVO.setUsaWhfExptFlg(usWhfBlVO.getUsaWhfExptFlg());
					bkgUsaWhfCntrVO.setWhfUtPrc(usWhfBlVO.getWhfUtPrc());
					addBlList.add(bkgUsaWhfBlVO);
					addCntrList.add(bkgUsaWhfCntrVO);
				}
				if ("U".equals(usWhfBlVO.getIbflag()))
				{
					bkgUsaWhfCntrVO.setVslCd(usWhfBlVO.getVslCd());
					bkgUsaWhfCntrVO.setSkdVoyNo(usWhfBlVO.getSkdVoyNo());
					bkgUsaWhfCntrVO.setSkdDirCd(usWhfBlVO.getSkdDirCd());
					bkgUsaWhfCntrVO.setPortCd(usWhfBlVO.getPortCd());
					bkgUsaWhfCntrVO.setIoBndCd(usWhfBlVO.getIoBndCd());
					bkgUsaWhfCntrVO.setBlNo(usWhfBlVO.getBlNo());
					bkgUsaWhfCntrVO.setCntrNo(usWhfBlVO.getCntrNo());
					bkgUsaWhfCntrVO.setUsaWhfExptFlg(usWhfBlVO.getUsaWhfExptFlg());
					bkgUsaWhfCntrVO.setUsaWhfTrspTpCd(usWhfBlVO.getUsaWhfTrspTpCd());
					bkgUsaWhfCntrVO.setCntrTpszCd(usWhfBlVO.getCntrTpszCd());
					if ("2".equals(usWhfBlVO.getCntrTpszCd().substring(1, 2)))
					{
						bkgUsaWhfCntrVO.setCntrVolQty(usWhfBlVO.getFt20());
					}
					else if ("4,5".indexOf(usWhfBlVO.getCntrTpszCd().substring(1, 2)) >= 0)
					{
						bkgUsaWhfCntrVO.setCntrVolQty(usWhfBlVO.getFt40());
					}
					else
					{
						bkgUsaWhfCntrVO.setCntrVolQty(usWhfBlVO.getFt45());
					}
					updCntrList.add(bkgUsaWhfCntrVO);
				}
				if ("D".equals(usWhfBlVO.getIbflag()))
				{
					bkgUsaWhfCntrVO.setVslCd(usWhfBlVO.getVslCd());
					bkgUsaWhfCntrVO.setSkdVoyNo(usWhfBlVO.getSkdVoyNo());
					bkgUsaWhfCntrVO.setSkdDirCd(usWhfBlVO.getSkdDirCd());
					bkgUsaWhfCntrVO.setPortCd(usWhfBlVO.getPortCd());
					bkgUsaWhfCntrVO.setIoBndCd(usWhfBlVO.getIoBndCd());
					bkgUsaWhfCntrVO.setBlNo(usWhfBlVO.getBlNo());
					bkgUsaWhfCntrVO.setCntrNo(usWhfBlVO.getCntrNo());
					delCntrList.add(bkgUsaWhfCntrVO);
				}
			}
			if (addBlList.size() > 0)
			{
				dbDao.addBkgUsaWhfBl(addBlList);
			}
			if (addCntrList.size() > 0)
			{
				dbDao.addBkgUsaWhfCntr(addCntrList);
			}
			if (updCntrList.size() > 0)
			{
				dbDao.modifyBkgUsaWhfCntr(updCntrList);
			}
			if (delCntrList.size() > 0)
			{
				dbDao.removeBkgUsaWhfCntr(delCntrList);
			}
			// BL No.를 가지고Container 테이블에 데이타가 없고 BL테이블에만 있으면 BL테이블 데이타 삭제
			UsWhfBlListCondVO usWhfBlListCondVO = new UsWhfBlListCondVO();
			UsWhfBlVO usWhfBlVO = (UsWhfBlVO) whfBlVOs[0];
			usWhfBlListCondVO.setVvd(usWhfBlVO.getVslCd() + usWhfBlVO.getSkdVoyNo() + usWhfBlVO.getSkdDirCd());
			usWhfBlListCondVO.setBound(usWhfBlVO.getIoBndCd());
			usWhfBlListCondVO.setPort(usWhfBlVO.getPortCd());
			List<UsWhfBlVO> usWhfBlVOs = dbDao.searchUsWhfBlListForRemove(usWhfBlListCondVO);
			for (int i = 0; i < usWhfBlVOs.size(); i++)
			{
				BkgUsaWhfBlVO bkgUsaWhfBlVO = new BkgUsaWhfBlVO();
				bkgUsaWhfBlVO.setVslCd(usWhfBlVOs.get(i).getVslCd());
				bkgUsaWhfBlVO.setSkdVoyNo(usWhfBlVOs.get(i).getSkdVoyNo());
				bkgUsaWhfBlVO.setSkdDirCd(usWhfBlVOs.get(i).getSkdDirCd());
				bkgUsaWhfBlVO.setPortCd(usWhfBlVOs.get(i).getPortCd());
				bkgUsaWhfBlVO.setIoBndCd(usWhfBlVOs.get(i).getIoBndCd());
				bkgUsaWhfBlVO.setBlNo(usWhfBlVOs.get(i).getBlNo());
				delBlList.add(bkgUsaWhfBlVO);
			}
			if (delBlList.size() > 0)
			{
				dbDao.removeBkgUsaWhfBl(delBlList);
			}
			// BL이 없으면 SND 테이블, QTY 테이블 삭제
			if (!dbDao.checkUsWhfBl(usWhfBlListCondVO))
			{
				BkgUsaWhfSndVO bkgUsaWhfSndVO = new BkgUsaWhfSndVO();
				bkgUsaWhfSndVO.setVslCd(usWhfBlVO.getVslCd());
				bkgUsaWhfSndVO.setSkdVoyNo(usWhfBlVO.getSkdVoyNo());
				bkgUsaWhfSndVO.setSkdDirCd(usWhfBlVO.getSkdDirCd());
				bkgUsaWhfSndVO.setPortCd(usWhfBlVO.getPortCd());
				bkgUsaWhfSndVO.setIoBndCd(usWhfBlVO.getIoBndCd());
				dbDao.removeBkgUsaWhfSnd(bkgUsaWhfSndVO);
			}
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
	 * US Wharfage Sending시 Wharfage Preview에 입력될 정보를 자동 기입하고 <br>
	 * Preview를 E-Mailing할 수있도록 E-Mail Address를 등록하기 위한 Pop-up화면
	 * 
	 * @param whfEmlListCondVO 조회조건
	 * @return List<WhfEmlVO>
	 * @throws EventException
	 */
	public List<WhfEmlVO> searchWhfEmlList(WhfEmlListCondVO whfEmlListCondVO) throws EventException {
		try
		{
			return dbDao.searchUsWhfEmlList((UsWhfEmlListCondVO) whfEmlListCondVO);
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
	 * E-Mail Address 관리
	 * 
	 * @param whfEmlVOs E-Mail Address
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageWhfEml(WhfEmlVO[] whfEmlVOs, SignOnUserAccount account) throws EventException {
		try
		{
			// 등록
			List<BkgUsaWhfEmlVO> addList = new ArrayList<BkgUsaWhfEmlVO>();
			// 수정
			List<BkgUsaWhfEmlVO> updList = new ArrayList<BkgUsaWhfEmlVO>();
			// 삭제
			List<BkgUsaWhfEmlVO> delList = new ArrayList<BkgUsaWhfEmlVO>();
			for (int i = 0; i < whfEmlVOs.length; i++)
			{
				BkgUsaWhfEmlVO bkgUsaWhfEmlVO = new BkgUsaWhfEmlVO();
				UsWhfEmlVO usWhfEmlVO = (UsWhfEmlVO) whfEmlVOs[i];
				bkgUsaWhfEmlVO.setUpdUsrId(account.getUsr_id());
				bkgUsaWhfEmlVO.setCreUsrId(account.getUsr_id());
				// usWhfEmlVO -> bkgUsaWhfEmlVO 복사
				ObjectCloner.build(usWhfEmlVO, bkgUsaWhfEmlVO);
				if ("I".equals(usWhfEmlVO.getIbflag()))
				{
					addList.add(bkgUsaWhfEmlVO);
				}
				if ("U".equals(usWhfEmlVO.getIbflag()))
				{
					updList.add(bkgUsaWhfEmlVO);
				}
				if ("D".equals(usWhfEmlVO.getIbflag()))
				{
					delList.add(bkgUsaWhfEmlVO);
				}
			}
			if (addList.size() > 0)
			{
				dbDao.addBkgUsaWhfEml(addList);
			}
			if (updList.size() > 0)
			{
				dbDao.modifyBkgUsaWhfEml(updList);
			}
			if (delList.size() > 0)
			{
				dbDao.removeBkgUsaWhfEml(delList);
			}
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
	 * Port별 Wharfage 신고 요율 조회
	 * 
	 * @param whfPortRtListCondVO 조회조건
	 * @return List<WhfPortRtVO>
	 * @throws EventException
	 */
	public List<WhfPortRtVO> searchWhfPortRtList(WhfPortRtListCondVO whfPortRtListCondVO) throws EventException {
		try
		{
			return dbDao.searchUsWhfPortRtList((UsWhfPortRtListCondVO) whfPortRtListCondVO);
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
	 * Port별 Wharfage 신고 요율 수정
	 * 
	 * @param whfPortRtVOs 신고 요율
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageWhfPortRt(WhfPortRtVO[] whfPortRtVOs, SignOnUserAccount account) throws EventException {
		try
		{
			// 등록/수정
			List<BkgUsaWhfRtVO> mergeBkgUsaWhfRtVOList = new ArrayList<BkgUsaWhfRtVO>();
			// 등록/수정
			List<BkgUsaWhfRtDtlVO> mergeBkgUsaWhfRtDtlVOList = new ArrayList<BkgUsaWhfRtDtlVO>();
			// 삭제
			List<BkgUsaWhfRtDtlVO> removeBkgUsaWhfRtDtlVOList = new ArrayList<BkgUsaWhfRtDtlVO>();
			for (int i = 0; i < whfPortRtVOs.length; i++)
			{
				// parameter
				UsWhfPortRtVO usWhfPortRtVO = (UsWhfPortRtVO) whfPortRtVOs[i];
				// BKG_USA_WHF_RT TABLE은 한번만 등록해도됨
				BkgUsaWhfRtVO bkgUsaWhfRtVO = new BkgUsaWhfRtVO();
				if (i == 0)
				{
					bkgUsaWhfRtVO.setPortCd(usWhfPortRtVO.getPort());
					bkgUsaWhfRtVO.setIoBndCd(usWhfPortRtVO.getBound());
					bkgUsaWhfRtVO.setEffDt(usWhfPortRtVO.getEffDt());
					bkgUsaWhfRtVO.setUpdUsrId(account.getUsr_id());
					bkgUsaWhfRtVO.setWhfDcRt(usWhfPortRtVO.getWhfDcRt());
					mergeBkgUsaWhfRtVOList.add(bkgUsaWhfRtVO);
				}
				if ("USLGB".equals(usWhfPortRtVO.getPort()))
				{
					// BKG_USA_WHF_RT_DTL
					mergeBkgUsaWhfRtDtlVOList.add(setBkgUsaWhfRtDtlLGBVO(usWhfPortRtVO, "L", account.getUsr_id()));
					mergeBkgUsaWhfRtDtlVOList.add(setBkgUsaWhfRtDtlLGBVO(usWhfPortRtVO, "R", account.getUsr_id()));
					mergeBkgUsaWhfRtDtlVOList.add(setBkgUsaWhfRtDtlLGBVO(usWhfPortRtVO, "T", account.getUsr_id()));
				}
				else if ("USOAK".equals(usWhfPortRtVO.getPort()))
				{
					// BKG_USA_WHF_RT_DTL
					BkgUsaWhfRtDtlVO bkgUsaWhfRtDtlVO1 = setBkgUsaWhfRtDtlOAKVO(usWhfPortRtVO, "20F", account
							.getUsr_id());
					if ("D".equals(bkgUsaWhfRtDtlVO1.getIbflag()))
						removeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO1);
					else
						mergeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO1);
					BkgUsaWhfRtDtlVO bkgUsaWhfRtDtlVO2 = setBkgUsaWhfRtDtlOAKVO(usWhfPortRtVO, "40F", account
							.getUsr_id());
					if ("D".equals(bkgUsaWhfRtDtlVO2.getIbflag()))
						removeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO2);
					else
						mergeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO2);
					BkgUsaWhfRtDtlVO bkgUsaWhfRtDtlVO3 = setBkgUsaWhfRtDtlOAKVO(usWhfPortRtVO, "45F", account
							.getUsr_id());
					if ("D".equals(bkgUsaWhfRtDtlVO3.getIbflag()))
						removeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO3);
					else
						mergeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO3);
					BkgUsaWhfRtDtlVO bkgUsaWhfRtDtlVO4 = setBkgUsaWhfRtDtlOAKVO(usWhfPortRtVO, "CON", account
							.getUsr_id());
					if ("D".equals(bkgUsaWhfRtDtlVO4.getIbflag()))
						removeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO4);
					else
						mergeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO4);
					BkgUsaWhfRtDtlVO bkgUsaWhfRtDtlVO5 = setBkgUsaWhfRtDtlOAKVO(usWhfPortRtVO, "TEU", account
							.getUsr_id());
					if ("D".equals(bkgUsaWhfRtDtlVO5.getIbflag()))
						removeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO5);
					else
						mergeBkgUsaWhfRtDtlVOList.add(bkgUsaWhfRtDtlVO5);
				}
			}
			if (mergeBkgUsaWhfRtVOList.size() > 0)
			{
				dbDao.addBkgUsaWhfRt(mergeBkgUsaWhfRtVOList);
			}
			if (mergeBkgUsaWhfRtDtlVOList.size() > 0)
			{
				dbDao.addBkgUsaWhfRtDtl(mergeBkgUsaWhfRtDtlVOList);
			}
			if (removeBkgUsaWhfRtDtlVOList.size() > 0)
			{
				dbDao.removeBkgUsaWhfRtDtl(removeBkgUsaWhfRtDtlVOList);
			}
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
	 * Wharfaeg 전송을 위한 Download
	 * 
	 * @param whfSendCondVO 조회조건
	 * @return String
	 * @throws EventException
	 */
	public String downloadWhfSend(WhfSendCondVO whfSendCondVO) throws EventException {
		try
		{
			UsWhfSendCondVO usWhfSendCondVO = (UsWhfSendCondVO) whfSendCondVO;
			UsWharfageDecMgtBackEndJob usWharfageDecMgtBackEndJob = new UsWharfageDecMgtBackEndJob();
			usWharfageDecMgtBackEndJob.setUsWhfSendCondVO(usWhfSendCondVO);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(usWharfageDecMgtBackEndJob, usWhfSendCondVO.getCreUsrId(),
					"US Wharfage Send (LGB)");
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Wharfaeg 전송을 위한 사전 정보 조회
	 * 
	 * @param whfSendCondVO 조회조건
	 * @return WhfSendVO
	 * @throws EventException
	 */
	public WhfSendVO searchWhfSend(WhfSendCondVO whfSendCondVO) throws EventException {
		try
		{
			return dbDao.searchUsWhfSend((UsWhfSendCondVO) whfSendCondVO);
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
	 * Wharfage 신고정보 관리
	 * 
	 * @param whfSendVO Wharfage 신고정보
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void manageWhfSend(WhfSendVO whfSendVO, SignOnUserAccount account) throws EventException {
		try
		{
			UsWhfSendVO usWhfSendVO = (UsWhfSendVO) whfSendVO;
			BkgUsaWhfSndVO pBkgUsaWhfSndVO = usWhfSendVO.getBkgUsaWhfSndVO();
			List<BkgUsaWhfSndVO> modBkgUsaWhfSndVOs = new ArrayList<BkgUsaWhfSndVO>();
			// BKG_USA_WHF_SND MODIFY
			pBkgUsaWhfSndVO.setCreUsrId(account.getUsr_id());
			modBkgUsaWhfSndVOs.add(pBkgUsaWhfSndVO);
			dbDao.modifyBkgUsaWhfSnd(modBkgUsaWhfSndVOs);
			// BKG_USA_WHF_BLK_CGO ADD, MODIFY, REMOVE
			List<BkgUsaWhfBlkCgoVO> pBkgUsaWhfBlkCgoVOs = usWhfSendVO.getBkgUsaWhfBlkCgoVOs();
			List<BkgUsaWhfBlkCgoVO> addBkgUsaWhfBlkCgoVOs = new ArrayList<BkgUsaWhfBlkCgoVO>();
			List<BkgUsaWhfBlkCgoVO> modBkgUsaWhfBlkCgoVOs = new ArrayList<BkgUsaWhfBlkCgoVO>();
			List<BkgUsaWhfBlkCgoVO> remBkgUsaWhfBlkCgoVOs = new ArrayList<BkgUsaWhfBlkCgoVO>();
			// 
			for (int i = 0; i < pBkgUsaWhfBlkCgoVOs.size(); i++)
			{
				pBkgUsaWhfBlkCgoVOs.get(i).setCreUsrId(account.getUsr_id());
				if ("I".equals(pBkgUsaWhfBlkCgoVOs.get(i).getIbflag()))
				{
					addBkgUsaWhfBlkCgoVOs.add(pBkgUsaWhfBlkCgoVOs.get(i));
				}
				else if ("U".equals(pBkgUsaWhfBlkCgoVOs.get(i).getIbflag()))
				{
					modBkgUsaWhfBlkCgoVOs.add(pBkgUsaWhfBlkCgoVOs.get(i));
				}
				else if ("D".equals(pBkgUsaWhfBlkCgoVOs.get(i).getIbflag()))
				{
					remBkgUsaWhfBlkCgoVOs.add(pBkgUsaWhfBlkCgoVOs.get(i));
				}
			}
			if (addBkgUsaWhfBlkCgoVOs.size() > 0)
				dbDao.addBkgUsaWhfBlkCgo(addBkgUsaWhfBlkCgoVOs);
			if (modBkgUsaWhfBlkCgoVOs.size() > 0)
				dbDao.modifyBkgUsaWhfBlkCgo(modBkgUsaWhfBlkCgoVOs);
			if (remBkgUsaWhfBlkCgoVOs.size() > 0)
				dbDao.removeBkgUsaWhfBlkCgo(remBkgUsaWhfBlkCgoVOs);
			// BKG_USA_WHF_SND_HIS ADD, MODIFY
			List<BkgUsaWhfSndHisVO> pBkgUsaWhfSndHisVOs = usWhfSendVO.getBkgUsaWhfSndHisVOs();
			List<BkgUsaWhfSndHisVO> addBkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
			List<BkgUsaWhfSndHisVO> modBkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
			if (pBkgUsaWhfSndHisVOs != null && pBkgUsaWhfSndHisVOs.size() > 0)
			{
				for (int i = 0; i < pBkgUsaWhfSndHisVOs.size(); i++)
				{
					pBkgUsaWhfSndHisVOs.get(i).setCreUsrId(account.getUsr_id());
					pBkgUsaWhfSndHisVOs.get(i).setSndOfcCd(account.getOfc_cd());
					if ("0".equals(pBkgUsaWhfSndHisVOs.get(i).getHisSeq()) || "".equals(pBkgUsaWhfSndHisVOs.get(i).getHisSeq()))
					{
						addBkgUsaWhfSndHisVOs.add(pBkgUsaWhfSndHisVOs.get(i));
					}
					else
					{
						if (!"".equals(pBkgUsaWhfSndHisVOs.get(i).getSndId()))
						{
							addBkgUsaWhfSndHisVOs.add(pBkgUsaWhfSndHisVOs.get(i));
						}
						else
						{
							modBkgUsaWhfSndHisVOs.add(pBkgUsaWhfSndHisVOs.get(0));
						}
					}
				}
			}
			if (addBkgUsaWhfSndHisVOs.size() > 0)
				dbDao.addBkgUsaWhfSndHis(addBkgUsaWhfSndHisVOs);
			if (modBkgUsaWhfSndHisVOs.size() > 0)
				dbDao.modifyBkgUsaWhfSndHis(modBkgUsaWhfSndHisVOs);
			// BKG_USA_WHF_SND_QTY ADD, MODIFY
			if ("USOAK".equals(pBkgUsaWhfSndVO.getPortCd()))
			{
				// 오클랜드의 경우 수정가능
				if (usWhfSendVO.getUsWhfSendQtyVOs() != null)
				{
					List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVOs = new ArrayList<BkgUsaWhfSndQtyVO>();
					for (int i = 0; i < usWhfSendVO.getUsWhfSendQtyVOs().size(); i++)
					{
						// 20FT
						BkgUsaWhfSndQtyVO bkgUsaWhfSndQtyVO = setBkgUsaWhfSndQtyVO(usWhfSendVO.getUsWhfSendQtyVOs()
								.get(i), pBkgUsaWhfSndVO, account.getUsr_id());
						bkgUsaWhfSndQtyVO.setUsaWhfRatUtCd("20F");
						bkgUsaWhfSndQtyVO.setRatAsQty(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getFt20());
						bkgUsaWhfSndQtyVO.setWhfUtPrc(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getUtPrc20ft());
						bkgUsaWhfSndQtyVO
								.setWhfAmt(""
										+ (Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getFt20())) * Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i)
														.getUtPrc20ft()))));
						bkgUsaWhfSndQtyVOs.add(bkgUsaWhfSndQtyVO);
						// 40FT
						bkgUsaWhfSndQtyVO = setBkgUsaWhfSndQtyVO(usWhfSendVO.getUsWhfSendQtyVOs().get(i),
								pBkgUsaWhfSndVO, account.getUsr_id());
						bkgUsaWhfSndQtyVO.setUsaWhfRatUtCd("40F");
						bkgUsaWhfSndQtyVO.setRatAsQty(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getFt40());
						bkgUsaWhfSndQtyVO.setWhfUtPrc(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getUtPrc40ft());
						bkgUsaWhfSndQtyVO
								.setWhfAmt(""
										+ (Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getFt40())) * Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i)
														.getUtPrc40ft()))));
						bkgUsaWhfSndQtyVOs.add(bkgUsaWhfSndQtyVO);
						// 45FT
						bkgUsaWhfSndQtyVO = setBkgUsaWhfSndQtyVO(usWhfSendVO.getUsWhfSendQtyVOs().get(i),
								pBkgUsaWhfSndVO, account.getUsr_id());
						bkgUsaWhfSndQtyVO.setUsaWhfRatUtCd("45F");
						bkgUsaWhfSndQtyVO.setRatAsQty(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getFt45());
						bkgUsaWhfSndQtyVO.setWhfUtPrc(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getUtPrc45ft());
						bkgUsaWhfSndQtyVO
								.setWhfAmt(""
										+ (Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getFt45())) * Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i)
														.getUtPrc45ft()))));
						bkgUsaWhfSndQtyVOs.add(bkgUsaWhfSndQtyVO);
						// CONT
						bkgUsaWhfSndQtyVO = setBkgUsaWhfSndQtyVO(usWhfSendVO.getUsWhfSendQtyVOs().get(i),
								pBkgUsaWhfSndVO, account.getUsr_id());
						bkgUsaWhfSndQtyVO.setUsaWhfRatUtCd("CON");
						bkgUsaWhfSndQtyVO.setRatAsQty(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getCont());
						bkgUsaWhfSndQtyVO.setWhfUtPrc(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getUtPrcCont());
						bkgUsaWhfSndQtyVO
								.setWhfAmt(""
										+ (Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getCont())) * Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i)
														.getUtPrcCont()))));
						bkgUsaWhfSndQtyVOs.add(bkgUsaWhfSndQtyVO);
						// TEUS
						bkgUsaWhfSndQtyVO = setBkgUsaWhfSndQtyVO(usWhfSendVO.getUsWhfSendQtyVOs().get(i),
								pBkgUsaWhfSndVO, account.getUsr_id());
						bkgUsaWhfSndQtyVO.setUsaWhfRatUtCd("TEU");
						bkgUsaWhfSndQtyVO.setRatAsQty(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getTeus());
						bkgUsaWhfSndQtyVO.setWhfUtPrc(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getUtPrcTeus());
						bkgUsaWhfSndQtyVO
								.setWhfAmt(""
										+ (Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i).getTeus())) * Float
												.parseFloat(getNumber(usWhfSendVO.getUsWhfSendQtyVOs().get(i)
														.getUtPrcTeus()))));
						bkgUsaWhfSndQtyVOs.add(bkgUsaWhfSndQtyVO);
					}
					dbDao.modifyBkgUsaWhfSndQty(bkgUsaWhfSndQtyVOs);
				}
			}
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
	 * Wharfage Send E-mail
	 * 
	 * @param bkgUsaWhfSndHisVOs Send History
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void sendWhfDeclEml(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			UsWharfageDecMgtEAIDAO eaiDao = new UsWharfageDecMgtEAIDAO();
			String sndId = eaiDao.sendWhfDeclEml(bkgUsaWhfSndHisVOs, account);
			for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
			{
				bkgUsaWhfSndHisVOs.get(i).setSndId(sndId);
				bkgUsaWhfSndHisVOs.get(i).setCreUsrId(account.getUsr_id());
				bkgUsaWhfSndHisVOs.get(i).setSndOfcCd(account.getOfc_cd());
				bkgUsaWhfSndHisVOs.get(i).setSndUsrId(account.getUsr_id());
			}
			dbDao.modifyBkgUsaWhfSndHis(bkgUsaWhfSndHisVOs);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG00243", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send Fax
	 * 
	 * @param bkgUsaWhfSndHisVOs Send History
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void sendWhfDeclFax(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			UsWharfageDecMgtEAIDAO eaiDao = new UsWharfageDecMgtEAIDAO();
			List<String> list = eaiDao.sendWhfDeclFax(bkgUsaWhfSndHisVOs, account);
			for (int i = 0; i < list.size(); i++)
			{
				bkgUsaWhfSndHisVOs.get(i).setSndId(list.get(i));
				bkgUsaWhfSndHisVOs.get(i).setCreUsrId(account.getUsr_id());
				bkgUsaWhfSndHisVOs.get(i).setSndOfcCd(account.getOfc_cd());
				bkgUsaWhfSndHisVOs.get(i).setSndUsrId(account.getUsr_id());
			}
			dbDao.modifyBkgUsaWhfSndHis(bkgUsaWhfSndHisVOs);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG00242", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send E-mail
	 * 
	 * @param bkgUsaWhfSndHisVOs Send History
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void sendWhfExptTsEml(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			List<BkgBookingVO> bkgBooking = dbDao.searchUsWhfSendExptTsBkgNo(bkgUsaWhfSndHisVOs.get(0));
			if (bkgBooking.size() > 0)
			{
				StringBuffer sbBkgNo = new StringBuffer();
				boolean bComma = false;
				for (int i = 0; i < bkgBooking.size(); i++)
				{
					if (i == 0)
						sbBkgNo.append("(");
					if (bComma)
						sbBkgNo.append(",");
					sbBkgNo.append("'");
					sbBkgNo.append(bkgBooking.get(i).getBkgNo());
					sbBkgNo.append("'");
					bComma = true;
					if (i == bkgBooking.size() - 1)
						sbBkgNo.append(")");
				}
				UsWharfageDecMgtEAIDAO eaiDao = new UsWharfageDecMgtEAIDAO();
				String sndId = eaiDao.sendWhfExptTsEml(bkgUsaWhfSndHisVOs, account, sbBkgNo.toString());
				for (int i = 0; i < bkgUsaWhfSndHisVOs.size(); i++)
				{
					bkgUsaWhfSndHisVOs.get(i).setSndId(sndId);
					bkgUsaWhfSndHisVOs.get(i).setCreUsrId(account.getUsr_id());
					bkgUsaWhfSndHisVOs.get(i).setSndOfcCd(account.getOfc_cd());
					bkgUsaWhfSndHisVOs.get(i).setSndUsrId(account.getUsr_id());
				}
				dbDao.modifyBkgUsaWhfSndHis(bkgUsaWhfSndHisVOs);
			}
			else
			{
				throw new EventException(new ErrorHandler("BKG95017", new String[] {"Excpt & T/S B/Ls"}).getMessage());
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG00243", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}
	}

	/**
	 * Wharfage Send Fax
	 * 
	 * @param bkgUsaWhfSndHisVOs Send History
	 * @param account 세션정보
	 * @throws EventException
	 */
	public void sendWhfExptTsFax(List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs, SignOnUserAccount account)
			throws EventException {
		try
		{
			List<BkgBookingVO> bkgBooking = dbDao.searchUsWhfSendExptTsBkgNo(bkgUsaWhfSndHisVOs.get(0));
			if (bkgBooking.size() > 0)
			{
				StringBuffer sbBkgNo = new StringBuffer();
				boolean bComma = false;
				for (int i = 0; i < bkgBooking.size(); i++)
				{
					if (i == 0)
						sbBkgNo.append("(");
					if (bComma)
						sbBkgNo.append(",");
					sbBkgNo.append("'");
					sbBkgNo.append(bkgBooking.get(i).getBkgNo());
					sbBkgNo.append("'");
					bComma = true;
					if (i == bkgBooking.size() - 1)
						sbBkgNo.append(")");
				}
				UsWharfageDecMgtEAIDAO eaiDao = new UsWharfageDecMgtEAIDAO();
				List<String> list = eaiDao.sendWhfExptTsFax(bkgUsaWhfSndHisVOs, account, sbBkgNo.toString());
				for (int i = 0; i < list.size(); i++)
				{
					bkgUsaWhfSndHisVOs.get(i).setSndId(list.get(i));
					bkgUsaWhfSndHisVOs.get(i).setCreUsrId(account.getUsr_id());
					bkgUsaWhfSndHisVOs.get(i).setSndOfcCd(account.getOfc_cd());
					bkgUsaWhfSndHisVOs.get(i).setSndUsrId(account.getUsr_id());
				}
				dbDao.modifyBkgUsaWhfSndHis(bkgUsaWhfSndHisVOs);
			}
			else
			{
				throw new EventException(new ErrorHandler("BKG95017", new String[] {"Excpt & T/S B/Ls"}).getMessage());
			}
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG00242", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}
	}

	/**
	 * BKG_USA_WHF_RT_DTL Table Set (LGB)
	 * 
	 * @param usWhfPortRtVO 신고 요율
	 * @param sUsaWhfTrspTpCd 운송수단
	 * @param sUsrId 세션ID
	 * @return BkgUsaWhfRtDtlVO
	 */
	private BkgUsaWhfRtDtlVO setBkgUsaWhfRtDtlLGBVO(UsWhfPortRtVO usWhfPortRtVO, String sUsaWhfTrspTpCd, String sUsrId) {
		// BKG_USA_WHF_RT_DTL
		BkgUsaWhfRtDtlVO bkgUsaWhfRtDtlVO = new BkgUsaWhfRtDtlVO();
		bkgUsaWhfRtDtlVO.setPortCd(usWhfPortRtVO.getPort());
		bkgUsaWhfRtDtlVO.setIoBndCd(usWhfPortRtVO.getBound());
		bkgUsaWhfRtDtlVO.setEffDt(usWhfPortRtVO.getEffDt());
		// 운송수단
		bkgUsaWhfRtDtlVO.setUsaWhfTrspTpCd(sUsaWhfTrspTpCd);
		// Container Size
		bkgUsaWhfRtDtlVO.setUsaWhfRatUtCd(usWhfPortRtVO.getUsaWhfRatUtCd());
		// Full Empty Type
		bkgUsaWhfRtDtlVO.setFullMtyCd(usWhfPortRtVO.getFullMtyCd());
		// 면제요소(Exception)
		bkgUsaWhfRtDtlVO.setUsaWhfExptFlg(usWhfPortRtVO.getUsaWhfExptFlg());
		if (sUsaWhfTrspTpCd.equals("L"))
		{
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getLocalPrc());
		}
		else if (sUsaWhfTrspTpCd.equals("R"))
		{
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getRailPrc());
		}
		else if (sUsaWhfTrspTpCd.equals("T"))
		{
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getTsPrc());
		}
		bkgUsaWhfRtDtlVO.setUpdUsrId(sUsrId);
		return bkgUsaWhfRtDtlVO;
	}

	/**
	 * BKG_USA_WHF_RT_DTL Table Set (LGB)
	 * 
	 * @param usWhfPortRtVO 신고 요율
	 * @param sCntrSize 컨테이너 사이즈
	 * @param sUsrId 세션ID
	 * @return BkgUsaWhfRtDtlVO
	 */
	private BkgUsaWhfRtDtlVO setBkgUsaWhfRtDtlOAKVO(UsWhfPortRtVO usWhfPortRtVO, String sCntrSize, String sUsrId) {
		// BKG_USA_WHF_RT_DTL
		BkgUsaWhfRtDtlVO bkgUsaWhfRtDtlVO = new BkgUsaWhfRtDtlVO();
		bkgUsaWhfRtDtlVO.setPortCd(usWhfPortRtVO.getPort());
		bkgUsaWhfRtDtlVO.setIoBndCd(usWhfPortRtVO.getBound());
		bkgUsaWhfRtDtlVO.setEffDt(usWhfPortRtVO.getEffDt());
		// 운송수단
		bkgUsaWhfRtDtlVO.setUsaWhfTrspTpCd(usWhfPortRtVO.getUsaWhfTrspTpCd());
		// Container Size
		bkgUsaWhfRtDtlVO.setUsaWhfRatUtCd(sCntrSize);
		// Full Empty Type
		bkgUsaWhfRtDtlVO.setFullMtyCd(usWhfPortRtVO.getFullMtyCd());
		// 면제요소(Exception)
		bkgUsaWhfRtDtlVO.setUsaWhfExptFlg(usWhfPortRtVO.getUsaWhfExptFlg());
		if (sCntrSize.equals("20F"))
		{
			if ("".equals(usWhfPortRtVO.getFt20()) || "0".equals(usWhfPortRtVO.getFt20()))
				bkgUsaWhfRtDtlVO.setIbflag("D");
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getFt20());
		}
		else if (sCntrSize.equals("40F"))
		{
			if ("".equals(usWhfPortRtVO.getFt40()) || "0".equals(usWhfPortRtVO.getFt40()))
				bkgUsaWhfRtDtlVO.setIbflag("D");
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getFt40());
		}
		else if (sCntrSize.equals("45F"))
		{
			if ("".equals(usWhfPortRtVO.getFt45()) || "0".equals(usWhfPortRtVO.getFt45()))
				bkgUsaWhfRtDtlVO.setIbflag("D");
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getFt45());
		}
		else if (sCntrSize.equals("CON"))
		{
			if ("".equals(usWhfPortRtVO.getCont()) || "0".equals(usWhfPortRtVO.getCont()))
				bkgUsaWhfRtDtlVO.setIbflag("D");
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getCont());
		}
		else if (sCntrSize.equals("TEU"))
		{
			if ("".equals(usWhfPortRtVO.getTeus()) || "0".equals(usWhfPortRtVO.getTeus()))
				bkgUsaWhfRtDtlVO.setIbflag("D");
			bkgUsaWhfRtDtlVO.setWhfUtPrc(usWhfPortRtVO.getTeus());
		}
		bkgUsaWhfRtDtlVO.setUpdUsrId(sUsrId);
		return bkgUsaWhfRtDtlVO;
	}

	/**
	 * BKG_USA_WHF_SND_QTY Set
	 * 
	 * @param usWhfSendQtyVO Send Qty정보
	 * @param pBkgUsaWhfSndVO Send 정보
	 * @param sUsrId 세션ID
	 * @return BkgUsaWhfSndQtyVO
	 */
	private BkgUsaWhfSndQtyVO setBkgUsaWhfSndQtyVO(UsWhfSendQtyVO usWhfSendQtyVO, BkgUsaWhfSndVO pBkgUsaWhfSndVO,
			String sUsrId) {
		BkgUsaWhfSndQtyVO bkgUsaWhfSndQtyVO = new BkgUsaWhfSndQtyVO();
		bkgUsaWhfSndQtyVO.setVslCd(pBkgUsaWhfSndVO.getVslCd());
		bkgUsaWhfSndQtyVO.setSkdVoyNo(pBkgUsaWhfSndVO.getSkdVoyNo());
		bkgUsaWhfSndQtyVO.setSkdDirCd(pBkgUsaWhfSndVO.getSkdDirCd());
		bkgUsaWhfSndQtyVO.setPortCd(pBkgUsaWhfSndVO.getPortCd());
		bkgUsaWhfSndQtyVO.setIoBndCd(pBkgUsaWhfSndVO.getIoBndCd());
		bkgUsaWhfSndQtyVO.setFullMtyCd(usWhfSendQtyVO.getFullMtyCd());
		bkgUsaWhfSndQtyVO.setUsaWhfTrspTpCd(usWhfSendQtyVO.getUsaWhfTrspTpCd());
		bkgUsaWhfSndQtyVO.setUsaWhfExptFlg("N");
		bkgUsaWhfSndQtyVO.setCreUsrId(sUsrId);
		bkgUsaWhfSndQtyVO.setUpdUsrId(sUsrId);
		return bkgUsaWhfSndQtyVO;
	}

	/**
	 * "" -> "0"으로 변환
	 * 
	 * @param sValue 값
	 * @return String
	 */
	private String getNumber(String sValue) {
		if (sValue == null || "".equals(sValue))
			return "0";
		return sValue;
	}
}