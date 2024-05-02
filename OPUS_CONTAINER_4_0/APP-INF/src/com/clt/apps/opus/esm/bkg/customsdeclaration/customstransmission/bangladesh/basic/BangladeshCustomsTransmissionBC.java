/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BangladeshCustomsTransmissionBCImpl.java
 *@FileTitle : BangladeshCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.10
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.04.21 임재택
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-BangladeshCustomsTransmission Business Logic Basic Command implementation<br>
 * - OPUS-BangladeshCustomsTransmission에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lim Jae Taek
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public interface BangladeshCustomsTransmissionBC {

	/**
	 * Flat File 생성 처리<br>
	 * Bangladesh 세관에 신고할 Vessel Arrival 데이터를 조회하여 FlatFile을 생성하고, Send Date를 저장한다. -- UI_BKG-0493
	 *
	 * @param BangladeshManifestListCondVO bangladeshManifestListCondVO
	 * @param BangladeshManifestTransmitVO[] bangladeshManifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(BangladeshManifestListCondVO bangladeshManifestListCondVO, BangladeshManifestTransmitVO[] bangladeshManifestTransmitVOs, SignOnUserAccount account) throws EventException;


}