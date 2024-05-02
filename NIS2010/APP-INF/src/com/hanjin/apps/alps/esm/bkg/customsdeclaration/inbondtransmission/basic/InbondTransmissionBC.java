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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondMibListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.MibTransmitVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Customsdeclaration Business Logic Command Interface<br>
 * - ALPS-Customsdeclaration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Subin
 * @see Esm_bkg_0533EventResponse 참조
 * @since J2EE 1.4
 */

public interface InbondTransmissionBC {
	/**
	 * 조회실행<br>
	 * 
	 * @param InbondListCondVO inbondManifestListCondVO
	 * @return List<InbondMibListDetailVO>
	 * @exception EventException
	 */
	public List<InbondMibListDetailVO> searchInbondManifestList(InbondListCondVO inbondManifestListCondVO ) throws EventException;
	
	/**
	 * USA HI FLAT FILE 생성 및 전송<br>
	 * 
	 * @param MibTransmitVO[] vos
	 * @return String
	 * @exception EventException
	 */
	public String transmitMIB(MibTransmitVO[] vos) throws EventException;
	
	
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
	 * @param InbondManifestDetailVO[] inbondManifestDetailVOs
	 * @param SignOnUserAccount account
	 * @return Integer
	 * @exception EventException
	 */
	public int modifyManifestList(InbondManifestDetailVO[] inbondManifestDetailVOs, SignOnUserAccount account) throws EventException;

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
	public String startBackEndJob(String usrId, 
			MibTransmitVO[] mibTransmitVO, String pgmNo)  throws EventException;
	
	/**
	 * hub수정권한을 조회한다.<br>
	 * 
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String[] searchUserAuthInfoForHub(String usrId) throws EventException;
	
}