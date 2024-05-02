/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GhanaCustomsTransmissionBCImpl.java
 *@FileTitle : Ghana Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.12
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.04.12 김보배
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.basic;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.integration.GhanaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.vo.GhanaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author BOBAE KIM
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class GhanaCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient GhanaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public GhanaCustomsTransmissionBCImpl() {
		dbDao = new GhanaCustomsTransmissionDBDAO();
	}

	/**
	 * 가나세관에 Manifest 신고한 BL 전송 History를 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addSendLog(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {

		BookingUtil command = new BookingUtil();
//		List<GhanaManifestTransmitVO> ghanaManifestTransmitVOs = new ArrayList<GhanaManifestTransmitVO>();
		GhanaManifestTransmitVO ghanaManifestTransmitVO = null;
		try {
			
			if (manifestTransmitVOs != null) {
				for(int i=0; i<manifestTransmitVOs.length; i++) {
					ghanaManifestTransmitVO = (GhanaManifestTransmitVO)manifestTransmitVOs[i];
					ghanaManifestTransmitVO.setMfSndDt(command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
					ghanaManifestTransmitVO.setUserId(account.getUsr_id());
//					ghanaManifestTransmitVOs.add(ghanaManifestTransmitVO);

					dbDao.addBlSendLog(ghanaManifestTransmitVO);
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
  	}
		
}