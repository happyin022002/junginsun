/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : InbondTransmissionBC.java
*@FileTitle : Generate Arrival Manifest by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.22 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondMibListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.MibTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Subin
 * @see Esm_bkg_0533EventResponse 참조
 * @since J2EE 1.4
 */

public interface UsaInbondTransmissionBC {

	/**
	 * 0408, PMIB Manifest List의 상단, 하단 그리드 조회실행<br>
	 *
	 * @param InbondListCondVO inbondListCondVO
	 * @return List<InbondMibListDetailVO>
	 * @exception EventException
	 */
	public List<InbondMibListDetailVO> searchInbondManifestList(InbondListCondVO inbondListCondVO ) throws EventException;

	/**
	 * USA HI(Arrival, Export) FLAT FILE 생성 및 전송<br>
	 *
	 * @param MibTransmitVO[] mibTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitMIB(MibTransmitVO[] mibTransmitVO) throws EventException;

	/**
	 * USA Inbound화주의 Customs Clearance Type을 조회 <br>
	 *
	 * @param InbondManifestListCondVO inbondManifestListCondVO
	 * @return List<InbondManifestDetailVO>
	 * @exception EventException
	 */
	public List<InbondManifestDetailVO> searchInbondClearanceList( InbondManifestListCondVO inbondManifestListCondVO ) throws EventException;

	/**
	 * USA Inbound화주의 Customs Clearance Type을 등록 및 수정<br>
	 *
	 * @param InbondManifestDetailVO[] inbondManifestDetailVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyManifestList(InbondManifestDetailVO[] inbondManifestDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * Mdm Commodity Name 조회<br>
	 *
	 * @param String cmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodity(String cmdtCd) throws EventException;

	/**
	 * BackEndJob을 실행.
	 *
	 * @param String usrId
	 * @param MibTransmitVO[] mibTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 *
	 */
	public String startBackEndJob(String usrId, MibTransmitVO[] mibTransmitVO, String pgmNo)  throws EventException;

	/**
	 * hub수정권한을 조회한다.<br>
	 *
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String[] searchUserAuthInfoForHub(String usrId) throws EventException;

	/**
	 * SC No. 조회<br>
	 *
	 * @param String inScNo
	 * @return String
	 * @exception EventException
	 */
	public String searchScNo(String inScNo) throws EventException;

}