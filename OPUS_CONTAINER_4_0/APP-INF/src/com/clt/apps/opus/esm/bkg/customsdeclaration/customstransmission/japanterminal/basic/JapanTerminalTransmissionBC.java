/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JapanTerminalTransmissionBC.java
*@FileTitle : JapanTerminalTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCheckRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiGroupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-JapanTerminalTransmission Business Logic Command Interface<br>
 * - OPUS-JapanTerminalTransmission 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see JapanTerminalTransmissionBCImpl 참조
 * @since J2EE 1.6
 */
public interface JapanTerminalTransmissionBC {

	/**
	 * 전송 이벤트 처리<br>
	 * 일본세관 수신 처리.<br>
	 *
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiveJapanTerminalOpusBkgNaccs(String flatFile, SignOnUserAccount account) throws EventException;

	/**
	 * Japan Terminal EDI 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account
	 * @param int logSeq
	 * @return String
	 * @throws EventException
	 */
	public String sendTerminalEdi(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account, int logSeq) throws EventException;

	/**
	 *  조원주_Sea-NACCS 프로젝트(20120312)
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException;

	/**
	 *  조원주_Sea-NACCS 프로젝트(20120312)
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForBKGRoute(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException;

	/**
	 * [CHM-201216099] Sea-NACCS 프로젝트스케줄 Retrieve 후 수정 SAVE<br>
	 * @param VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @return JapanTerminalEdiCheckRsltVO
	 * @exception EventException
	 */
	public JapanTerminalEdiCheckRsltVO manageTerminalEdi(VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  김종옥_Sea-NACCS 프로젝트(20120312)
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException;

	/**
	 *  김종옥_Sea-NACCS 프로젝트(20120312)
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchPartialBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException;

	/**
	 * 판별로직 확인
	 * J<br>
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckColumns(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException;

	/**
	 * searchNewBkgInfo<br>
	 *
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @return List<BkgTerminalEdiJapanBlVO>
	 * @exception EventException
	 */
	public List<BkgTerminalEdiJapanBlVO> searchNewBkgInfo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException;

	/**
	 * searchNewBkgDetailInfo<br>
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return JapanTerminalEdiGroupVO
	 * @exception EventException
	 */
	public JapanTerminalEdiGroupVO searchNewBkgDetailInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException;

	/**
	 * addNewBkgInfo<br>
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account
	 * @param String vvdChk
	 * @return String
	 * @exception EventException
	 */
	public String addNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account, String vvdChk) throws EventException;

	/**
	 * managePartialBkgInfoForSchedule SAVE<br>
	 * @param BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartialBkgInfoForSchedule(BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs, SignOnUserAccount account) throws EventException;

	/**
	 * searchNewBkgInfo<br>
	 *
	 * @param String bkgNo
	 * @return BkgTerminalEdiJapanBlVO
	 * @exception EventException
	 */
	public BkgTerminalEdiJapanBlVO searchNewBkgInfoForVvdChk(String bkgNo) throws EventException;
}
