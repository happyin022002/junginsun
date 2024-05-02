/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsReportBC.java
*@FileTitle : ChinaCustomsReportBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.02
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsChnDeModDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.DelModeListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.SearchLocationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ChinaCustomsReport Business Logic Command Interface<br>
 * - OPUS-ChinaCustomsReport 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see ChinaCustomsReportBCImpl 참조
 * @since J2EE 1.6
 */
public interface ChinaCustomsReportBC {

	/**
	 * 중국 DEL 지역별 운송 Mode를 조회한다.
	 * @param bkgCstmsChnDeModCondVO
	 * @return List<DelModeListVO>
	 * @throws EventException
	 */
	public List<DelModeListVO> searchDelMode(BkgCstmsChnDeModCondVO bkgCstmsChnDeModCondVO) throws EventException;

	/**
	 * 중국 DEL 지역별 운송 Mode를 입력/수정/삭제한다.
	 *
	 * @param BkgCstmsChnDeModDetailVO[] bkgCstmsChnDeModDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDelMode(BkgCstmsChnDeModDetailVO[] bkgCstmsChnDeModDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * 중국세관에 EDI를 통해 전송한 메시지 내역을 조회한다.<br>
	 *
	 * @param transmitHistCondVO TransmitHistCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchTransmitHist(TransmitHistCondVO  transmitHistCondVO) throws EventException;

	/**
	 * 중국세관 POD, DEL Validation 을 체크한다.<br>
	 *
	 * @param searchLocationVO
	 * @return String searchLocation
	 * @throws EventException
	 */
	public String searchLocation(SearchLocationVO searchLocationVO) throws EventException;

	/**
	 * 세관에 EDI를 통해 전송한 메시지 내역을 조회한다.<br>
	 *
	 * @param String ediRefId
	 * @param String podCd
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchChinaSendDetailList(String ediRefId, String podCd) throws EventException;

}

