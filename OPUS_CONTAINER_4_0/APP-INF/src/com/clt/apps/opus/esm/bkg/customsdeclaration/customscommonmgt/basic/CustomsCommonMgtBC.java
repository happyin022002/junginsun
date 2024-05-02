/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtBC.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.BkgCstmsCommonInputVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.BkgCstmsCommonReturnVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvSeqVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsCommonMgt Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface CustomsCommonMgtBC {

	/**
	 * [공통]
	 * 쿼리 조합 조회<br>
	 *
	 * @param BkgCstmsCommonInputVO bkgCstmsCommonInputVO
	 * @return List<BkgCstmsCommonReturnVO>
	 * @exception EventException
	 */
	public List<BkgCstmsCommonReturnVO> getCodeValue(BkgCstmsCommonInputVO bkgCstmsCommonInputVO) throws EventException;

	/**
	 * searching Country Code, Customs Division ID, Customs Code Description information<br>
	 *
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvDescList(CstmsCdConvVO cstmsCdConvVO) throws EventException;

	/**
	 * searching Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 *
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvCtntList(CstmsCdConvVO cstmsCdConvVO) throws EventException;

	/**
	 * managing information of Country Code, Customs Division ID, Customs Code Description<br>
	 *
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvDesc(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException;

	/**
	 * managing Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 *
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvCtnt(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException;
	/**
	 * searching Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 *
	 * @param CstmsCdConvSeqVO cstmsCdConvSeqVO
	 * @return List<CstmsCdConvSeqVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvSeqVO> searchCstmsCdConvSeqDescList(CstmsCdConvSeqVO cstmsCdConvSeqVO) throws EventException;

	/**
	 * searching Country Code, Customs Division ID, Customs Code Description information<br>
	 *
	 * @param CstmsCdConvSeqVO cstmsCdConvSeqVO
	 * @return List<cstmsCdConvSeqVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvSeqVO> searchCstmsCdConvSeqCtntList(CstmsCdConvSeqVO cstmsCdConvSeqVO) throws EventException;

	/**
	 * managing information of Country Code, Customs Division ID, Customs Code Description<br>
	 *
	 * @param CstmsCdConvSeqVO[] cstmsCdConvSeqVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvSeqCtnt(CstmsCdConvSeqVO[] cstmsCdConvSeqVOs, SignOnUserAccount account) throws EventException;

	/**
	 * checking duplication of Country Code, Customs Division ID<br>
	 *
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsCdConvDesc(String cntCd, String cstmsDivId) throws EventException;

	/**
	 * searching Country Code, Package Type Code, Customs Package Type Code information<br>
	 *
	 * @param CstmsPckTpConvVO cstmsPckTpConvVO
	 * @return List<CstmsPckTpConvVO>
	 * @throws EventException
	 */
	public List<CstmsPckTpConvVO> searchCstmsPckTpConvList(CstmsPckTpConvVO cstmsPckTpConvVO) throws EventException;

	/**
	 * managing information of Country Code, Package Type Code, Customs Package Type Code<br>
	 *
	 * @param CstmsPckTpConvVO[] cstmsPckTpConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsPckTpConv(CstmsPckTpConvVO[] cstmsPckTpConvVOs, SignOnUserAccount account) throws EventException;

	/**
	 * checking duplication of Country Code, Package Type Code, Customs Package Type Code<br>
	 *
	 * @param String cntCd
	 * @param String pckTpCd
	 * @param String rcvrId
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsPckTpConv(String cntCd, String pckTpCd, String rcvrId) throws EventException;

	/**
	 * checking Package Type Code
	 *
	 * @param pckTpCd
	 * @return
	 * @throws EventException
	 */
	public String checkPckTpCd(String pckTpCd) throws EventException;

	/**
	 * searching Country Code, Customs Error Code information<br>
	 *
	 * @param CstmsErrCdVO cstmsErrCdVO
	 * @return List<CstmsErrCdVO>
	 * @throws EventException
	 */
	public List<CstmsErrCdVO> searchCstmsAdvErrList(CstmsErrCdVO cstmsErrCdVO) throws EventException;

	/**
	 * managing information of Country Code, Customs Error Code<br>
	 *
	 * @param CstmsErrCdVO[] cstmsErrCdVOs
	 * @param SignOnUserAccount account
	 * @return List<CstmsErrCdVO>
	 * @throws EventException
	 */
	public List<CstmsErrCdVO> manageCstmsAdvErr(CstmsErrCdVO[] cstmsErrCdVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_BKG_1513]
	 * Manifest e-Maiil Notification 목록 조회<br>
	 *
	 * @param CstmsEmlNtfcVO cstmsEmlNtfcVO
	 * @return List<CstmsEmlNtfcVO>
	 * @exception EventException
	 */
	public List<CstmsEmlNtfcVO> searchCstmsEmlNtfc(CstmsEmlNtfcVO cstmsEmlNtfcVO) throws EventException;

	/**
	 * [ESM_BKG_1513]
	 * Manifest e-Maiil Notification 목록 저장<br>
	 *
	 * @param CstmsEmlNtfcVO[] cstmsEmlNtfcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsEmlNtfc(CstmsEmlNtfcVO[] cstmsEmlNtfcVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EDI수신오류 시 메일전송할 수신처 조회<br>
	 *
	 * @param CstmsEmlNtfcVO cstmsEmlNtfcVO
	 * @return CstmsEmlNtfcVO
	 * @exception EventException
	 */
	public CstmsEmlNtfcVO searchCstmsEmlNtfcInfo(CstmsEmlNtfcVO cstmsEmlNtfcVO) throws EventException;

	/**
	 * Consortium VVD 조회<br>
	 *
	 * @param vvd
	 * @param portCd
	 * @param ioType
	 * @return
	 * @throws EventException
	 */
	public String searchConVvd(String vvd, String portCd, String ioType) throws EventException;

	/**
	 * MDM_VSL_SVC_LANE 존재여부
	 *
	 * @param vslSlanCd
	 * @return
	 * @throws EventException
	 */
	public boolean checkMdmVslSvcLane(String vslSlanCd) throws EventException;

}