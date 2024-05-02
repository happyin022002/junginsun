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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.basic;

import java.util.List; 

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Bookingreport Business Logic Command Interface<br>
 * - NIS2010-CustomsCommon 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kyu Jeong Shin
 * @see Esm_bkg_1201EventResponse 참조
 * @since J2EE 1.6
 */
public interface CustomsCommonMgtBC {
	
	/**
	 * searching Country Code, Customs Division ID, Customs Code Description information<br>
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvDescList(CstmsCdConvVO cstmsCdConvVO) throws EventException;
	
	/**
	 * searching Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 * @param CstmsCdConvVO cstmsCdConvVO
	 * @return List<CstmsCdConvVO>
	 * @throws EventException
	 */
	public List<CstmsCdConvVO> searchCstmsCdConvCtntList(CstmsCdConvVO cstmsCdConvVO) throws EventException;
	
	/**
	 * managing information of Country Code, Customs Division ID, Customs Code Description<br>
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvDesc(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * managing Attribute Content information at sheet2 about Country Code, Customs Division ID of sheet1<br>
	 * @param CstmsCdConvVO[] cstmsCdConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsCdConvCtnt(CstmsCdConvVO[] cstmsCdConvVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * checking duplication of Country Code, Customs Division ID<br>
	 * @param String cntCd
	 * @param String cstmsDivId
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsCdConvDesc(String cntCd, String cstmsDivId) throws EventException;
	
	/**
	 * searching Country Code, Package Type Code, Customs Package Type Code information<br>
	 * @param CstmsPckTpConvVO cstmsPckTpConvVO
	 * @return List<CstmsPckTpConvVO>
	 * @throws EventException
	 */
	public List<CstmsPckTpConvVO> searchCstmsPckTpConvList(CstmsPckTpConvVO cstmsPckTpConvVO) throws EventException;
	
	/**
	 * managing information of Country Code, Package Type Code, Customs Package Type Code<br>
	 * @param CstmsPckTpConvVO[] cstmsPckTpConvVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsPckTpConv(CstmsPckTpConvVO[] cstmsPckTpConvVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * checking duplication of Country Code, Package Type Code, Customs Package Type Code<br>
	 * @param String cntCd
	 * @param String pckTpCd
	 * @param String cstmsPckTpCd
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsPckTpConv(String cntCd, String pckTpCd, String cstmsPckTpCd) throws EventException;
	
	/**
	 * checking Package Type Code<br>
	 * @param String pckTpCd
     * @return String
	 * @throws EventException
	 */
	public String checkPckTpCd(String pckTpCd) throws EventException;
	
	/**
	 * searching Country Code, Customs Error Code information<br>
	 * @param CstmsErrCdVO cstmsErrCdVO
	 * @return List<CstmsErrCdVO>
	 * @throws EventException
	 */
	public List<CstmsErrCdVO> searchCstmsAdvErrList(CstmsErrCdVO cstmsErrCdVO) throws EventException;
	
	/**
	 * managing information of Country Code, Customs Error Code<br>
	 * @param CstmsErrCdVO[] cstmsErrCdVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageCstmsAdvErr(CstmsErrCdVO[] cstmsErrCdVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * checking duplication of Country Code, Customs Error Code<br>
	 * @param String cntCd
	 * @param String cstmsErrCd
	 * @return String
	 * @throws EventException
	 */
	public String checkCstmsAdvErr(String cntCd, String cstmsErrCd) throws EventException;

	/**
	 * EDI수신오류 시 메일전송할 수신처 조회<br>
	 *
	 * @param CstmsEmlNtfcVO cstmsEmlNtfcVO
	 * @return CstmsEmlNtfcVO
	 * @exception EventException
	 */
	public CstmsEmlNtfcVO searchCstmsEmlNtfcInfo(CstmsEmlNtfcVO cstmsEmlNtfcVO) throws EventException;
}