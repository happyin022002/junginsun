/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : RussiaManifestListDownloadBCImpl.java
 *@FileTitle : ESM_BKG_1163
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.04
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2013.07.04 김보배
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.11.04 김보배 [CHM-201327164] Russia Manifest 기능 보완
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration.RussiaManifestDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlInVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.ModifyCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author BOBAE KIM
 * @see EventResponse,RussiaManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class RussiaManifestListDownloadBCImpl extends BasicCommandSupport implements RussiaManifestListDownloadBC {
	// Database Access Object
	private transient RussiaManifestDownloadDBDAO dbDao = null;

	/**
	 * RussiaManifestListDownloadBCImpl 객체 생성<br>
	 * RussiaManifestListDownloadBCImpl 생성한다.<br>
	 */
	public RussiaManifestListDownloadBCImpl() {
		dbDao = new RussiaManifestDownloadDBDAO();
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Russia 를 통과하는 화물에 대한 Manifest List 를 조회한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try {
			
//			RussiaManifestListCondVO russiaManifestListCondVO = (RussiaManifestListCondVO)manifestListCondVO;
//			List<RussiaManifestListCondVO> russiaManifestListCondVOs = null;
//			List<ManifestListDetailVO> manifestListDetailVO = new ArrayList<ManifestListDetailVO>();
//			
//			russiaManifestListCondVOs = dbDao.searchManifestList(russiaManifestListCondVO);
					
			return dbDao.searchRussiaManifestList(manifestListCondVO);

		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
     * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.<br>
     * 
     * @param FdrBlInVO fdrBlInVO
     * @return List<FdrBlVO>
     * @exception EventException
     */
    public List<FdrBlVO> searchBkgListForFdrBl(FdrBlInVO fdrBlInVO) throws EventException {

        try {
        	return dbDao.searchBkgListForFdrBl(fdrBlInVO);

        } catch(DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    
	/**
	 * ESM_BKG_1164: MULTI <br>
	 * Customer 정보를 변경한다.<br>
	 * 
	 * @param FdrBlVO[] fdrBlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCustInfoBkgCstmsRuCust(FdrBlVO[] fdrBlVOs, SignOnUserAccount account) throws EventException {
		try{
			String[] arrCustCntcTpCd = new String[] { "S", "C", "N", "E"};
			
			for(int i=0; i < fdrBlVOs.length; i++){
	
				// Customer Name
				String[] arrCustNm = new String[] { fdrBlVOs[i].getShprNm(), fdrBlVOs[i].getCneeNm(), fdrBlVOs[i].getNtfyNm(), fdrBlVOs[i].getExCustNm()};
				// Customer EMAIL
				String[] arrCustAddr = new String[] {fdrBlVOs[i].getShprAddr(), fdrBlVOs[i].getCneeAddr(), fdrBlVOs[i].getNtfyAddr(),""};

				for(int j=0; j< arrCustCntcTpCd.length; j++){
	
					// Detail 정보 변경 처리
					FdrBlVO fdrBlVO = new FdrBlVO();
					fdrBlVO.setBlNo(fdrBlVOs[i].getBlNo());
					fdrBlVO.setBkgCustTpCd(arrCustCntcTpCd[j]);
					fdrBlVO.setCustNm(arrCustNm[j]);
					fdrBlVO.setCustAddr(arrCustAddr[j]);
					dbDao.addCustInfoBkgCstmsRuCust(fdrBlVO, account);
				}
			}
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_BKG_1163
	 * SAVE 시 CNTR WGT 정보 저장
	 * 
	 * @param ModifyCntrInfoVO[] modifyCntrInfoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRussiaCntrInfo(ModifyCntrInfoVO[] modifyCntrInfoVOs, SignOnUserAccount account) throws EventException {
		
		try {
			List<ModifyCntrInfoVO> insertVoList = new ArrayList<ModifyCntrInfoVO>();
			
			for ( int i=0; i<modifyCntrInfoVOs .length; i++ ) {
				if ( modifyCntrInfoVOs[i].getIbflag().equals("U")){
					modifyCntrInfoVOs[i].setCreUsrId(account.getUsr_id());
					modifyCntrInfoVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(modifyCntrInfoVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.manageRussiaCntrInfo(insertVoList, account);
			}
		} catch(DAOException ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
}
