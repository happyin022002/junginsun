/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaInbondTransmissionBackEndJob.java
 *@FileTitle : UsaInbondTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.17
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.08.17 김도완
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.MibTransmitVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Do Wan
 * @see ESM_BKG_1023EventResponse,UsaCustomsTransmissionBackEndBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class UsaInbondTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private MibTransmitVO[] mibTransmitVO;
	private String pgmNo;


	/**
	 * 다운로드 할 데이터 세팅 0533화면.
	 * 
	 * @param MibTransmitVO[] mibTransmitVO
	 */
	public void setMibTransmitVO(MibTransmitVO[] mibTransmitVO) {
		if (mibTransmitVO != null)
			this.mibTransmitVO = Arrays.copyOf(mibTransmitVO, mibTransmitVO.length);
	}
	
	/**
	 * 화면ID세팅
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndCommand Start
	 * 
	 * @return DBRowSet
	 * @throws Exception
	 */
	public Object doStart() throws Exception {
		if (pgmNo.startsWith("ESM_BKG_0533"))
		{
			UsaInbondTransmissionBC command = new UsaInbondTransmissionBCImpl();
			command.transmitMIB(mibTransmitVO);
		}
		return null;
	}
}