/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArgManifestListDownloadBCImpl.java
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2014.12.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2014.12.31 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.integration.ArgManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.ArgManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.vo.BkgCstmsArgBlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0017EventResponse,PanamaManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ArgManifestListDownloadBCImpl extends BasicCommandSupport implements ArgManifestListDownloadBC {

	// Database Access Object
	private transient ArgManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl 객체 생성<br>
	 * ManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public ArgManifestListDownloadBCImpl() {
		dbDao = new ArgManifestListDownloadDBDAO();
	}
	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ArgManifestListDetailVO> searchManifestList(ArgManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException
	{
		try
		{
			ArgManifestListCondVO condVO = (ArgManifestListCondVO) manifestListCondVO;
			return dbDao.searchManifestList(condVO, account);
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
	 * 세관 신고 대상 List를 세관 테이블 내로 다운받는 작업
	 * @param manifestListDetailVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String manageManifest(ArgManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException
	{
		try
		{
			List<BkgCstmsArgBlVO> addList = new ArrayList<BkgCstmsArgBlVO>();
			String befBlNo = "";
			for (int i=0; i< manifestListDetailVOs.length; i++)
			{
				if (befBlNo.equals(manifestListDetailVOs[i].getBlNo())) continue;
				if ("Y".equals(manifestListDetailVOs[i].getDownYn())) continue;
				if ("1".equals(manifestListDetailVOs[i].getSel())){
					BkgCstmsArgBlVO bl = new BkgCstmsArgBlVO();
					ObjectCloner.build(manifestListDetailVOs[i], bl);
					bl.setUpdUsrId(account.getUsr_id());
					addList.add(bl);
					befBlNo = manifestListDetailVOs[i].getBlNo();
				}
			}
			dbDao.addBkgCstmsArgBl(addList);
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
	 * In Transit 값을 세관 테이블에 저장
	 * @param manifestListDetailVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String saveManifest(ArgManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException
	{
		try
		{
			List<BkgCstmsArgBlVO> addList = new ArrayList<BkgCstmsArgBlVO>();
			String befBlNo = "";
			for (int i=0; i< manifestListDetailVOs.length; i++)
			{
				if (befBlNo.equals(manifestListDetailVOs[i].getBlNo())) continue;
//				if ("Y".equals(manifestListDetailVOs[i].getDownYn())) continue;
				if ("1".equals(manifestListDetailVOs[i].getSel())){
					BkgCstmsArgBlVO bl = new BkgCstmsArgBlVO();
					ObjectCloner.build(manifestListDetailVOs[i], bl);
					bl.setUpdUsrId(account.getUsr_id());
					addList.add(bl);
					befBlNo = manifestListDetailVOs[i].getBlNo();
				}
			}
			dbDao.updateInTransitArgBl(addList);
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
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 삭제한다.
	 * @param ArgManifestListDetailVO[] manifestListDetailVOs
	 * @return 
	 * @exception EventException
	 */
	public String deleteManifest(ArgManifestListDetailVO[] manifestListDetailVOs) throws EventException
	{
		try{
			List<BkgCstmsArgBlVO> addList = new ArrayList<BkgCstmsArgBlVO>();
			String befBlNo = "";
			for (int i=0; i< manifestListDetailVOs.length; i++)
			{
				if (befBlNo.equals(manifestListDetailVOs[i].getBlNo())) continue;
				
				BkgCstmsArgBlVO bl = new BkgCstmsArgBlVO();
				ObjectCloner.build(manifestListDetailVOs[i], bl);
				addList.add(bl);
				befBlNo = manifestListDetailVOs[i].getBlNo();
			}
			dbDao.removeManifestBlByVvd(addList);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	return "Y";
	}
}