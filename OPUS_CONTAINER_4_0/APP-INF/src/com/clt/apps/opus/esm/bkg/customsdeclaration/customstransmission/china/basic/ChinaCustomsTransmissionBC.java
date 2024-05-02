/*=========================================================
*Copyright(c)2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionBC.java
*@FileTitle : ChinaCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier :
*@LastVersion : 1.0
* 2009.08.25
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSGRPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoBLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.VvdKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ContainerCondVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ChinaCustomsTransmission Business Logic Basic Command Interface<br>
 * - OPUS-ChinaCustomsTransmission에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Subin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface ChinaCustomsTransmissionBC {

	/**
	 * 세관 테이블의 Customer, Container, Commodity(CM) 등의 BL 정보를 조회한다
	 *
	 * @param ChinaBlInfoCondVO chinaBlInfoCondVO
	 * @return ChinaBlInfoVO
	 * @exception EventException
	 */
	public ChinaBlInfoVO searchBlInfo(ChinaBlInfoCondVO chinaBlInfoCondVO) throws EventException;

	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회한다
	 *
	 * @param ContainerCondVO containerCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerType(ContainerCondVO containerCondVO) throws EventException;

	/**
	 * Transmit 하기 위한 중국 세관 테이블의 Customer, Container 등의 BL 정보를 조회한다
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return List<ChinaBlInfoListVO>
	 * @exception EventException
	 */
	public List<ChinaBlInfoListVO> searchBlByVvd(VvdKeyVO vvdKeyVO) throws EventException;

	/**
	 * 세관에 신고할 대상 Manifest 정보(CSV 저장용 데이터)를 조회한 후<br>
	 * 서버에 .CSV  파일생성해서 로컬로 다운로드<br>
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(VvdKeyVO vvdKeyVO) throws EventException;

	/**
	 * 중국 세관 신고를 위해 FlatFile을 생성한다.
	 *
	 * @param ChinaManifestTransmitVO chinamanifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ChinaManifestTransmitVO chinamanifestTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * 중국 세관 수신 FlatFile 데이터를 로그 테이블에 저장<br>
	 *
	 * @param String rcvMsg
	 * @exception EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg) throws EventException;

	/**
	 * Transmit 하기 위한 중국 세관 테이블의 Customer, Container 등의 Terminal BL 정보를 조회한다
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return List<ChinaBlInfoListVO>
	 * @exception EventException
	 */
	public List<ChinaBlInfoListVO> searchTmlBlByVvd(VvdKeyVO vvdKeyVO) throws EventException;

	/**
	 * 중국 Terminal 세관 신고를 위해 FlatFile을 생성한다.
	 *
	 * @param ChinaManifestTransmitVO chinaManifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitTmlManifest(ChinaManifestTransmitVO chinaManifestTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * Inbound Domestic T/S Manifest -
	 * 세관 테이블의 Customer, Container, Commodity(CM)등의 대상목록 조회
	 *
	 * @param InboundTSInfoBLVO serchCondVO
	 * @return InboundTSInfoGRPVO
	 * @exception EventException
	 */
	public InboundTSGRPVO searchInboundTSManifest(InboundTSInfoBLVO serchCondVO) throws EventException;

	/**
	 * [EDI_T_BKG_T_CNCUS_SYS_ACK]
	 *  China SYS ACK 메세지 수신
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDISysAck(String flatFile) throws EventException;


}
