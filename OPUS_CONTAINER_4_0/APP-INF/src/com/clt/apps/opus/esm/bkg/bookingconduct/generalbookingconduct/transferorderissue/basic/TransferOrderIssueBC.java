/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueBC.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroChangeVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgTroActCustVO;
import com.clt.syscommon.common.table.BkgTroActRepVO;
import com.clt.syscommon.common.table.MdmCustomerVO;




/**
 * OPUS-Generalbookingconduct Business Logic Command Interface<br>
 * - OPUS-Interface of Business Logic for Generalbookingconduct<br>
 *
 * @author Lee Nam Kyung
 * @see Esm_bkg_0079_02cEventResponse reference
 * @since J2EE 1.4
 */

public interface TransferOrderIssueBC {

	/**
	 * (ESM_BKG_0079_02A) europe Tro relation retrieve<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @param  String rtnTroFlg
	 * @param  SignOnUserAccount account
	 * @return TroVO
	 * @exception EventException
	 */
	public TroVO searchTro(BkgBlNoVO bkgBlNoVO, String boundCd, String rtnTroFlg, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0079_02C) europe Tro relation retrieve<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @param  SignOnUserAccount account
	 * @return EurTroVO
	 * @exception EventException
	 */
	public EurTroVO searchEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0079_02A)  europe Tro relation save<br>
	 * @author Lee NamKyung
	 * @param  TroVO troVO
	 * @param  account SignOnUserAccount
	 * @param  String currTroSeq
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTro(TroVO troVO, SignOnUserAccount account, String currTroSeq) throws EventException;
	
	/**
	 * (ESM_BKG_0079_02C) europe Tro relation save<br>
	 * @author Lee NamKyung
	 * @param  EurTroVO eurTroVO
	 * @param  String bkgNo
	 * @param  String currTroSeq
	 * @param  account SignOnUserAccount
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageEurTro(EurTroVO eurTroVO, String bkgNo, String currTroSeq, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0907) Retrieve Container of EurTro<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @return List<BkgEurCntrListVO>
	 * @exception EventException
	 */
	public List<BkgEurCntrListVO> searchEurTroCntrList(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException;

	/**
	 * (ESM_BKG_0703) cancel/frust processing target retrieve<br>
	 * @author Lee NamKyung
	 * @param  String io_bnd_cd
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<TroMultiCancelFrustVO>
	 * @exception EventException
	 */
	public List<TroMultiCancelFrustVO> searchEurTroForCancelFrust(String io_bnd_cd, BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * (ESM_BKG_0921) Multi retrieve<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String cntrNo
	 * @param  String boundCd
	 * @return List<TroMultiBkgVO>
	 * @exception EventException
	 */
	public List<TroMultiBkgVO> searchMultiBkg(BkgBlNoVO bkgBlNoVO, String cntrNo, String boundCd) throws EventException;

	/**
	 * Retrieve confirm target when confirm popup(ESM_BKG_0906) in ESM_BKG_0079_02c<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @param  String boundCd
	 * @return TroCfmVO
	 * @exception EventException
	 */
	public TroCfmVO searchEurTroListForCfm(BkgBlNoVO bkgBlNoVO, String boundCd) throws EventException;
	
	/**
	 * confirm event processing<br>
	 * confirm when confirm Popup(ESM_BKG_0906) in ESM_BKG_0079_02c screen<br>
	 * @author Lee NamKyung
	 * @param  TroCfmVO troCfmVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmEurTro(TroCfmVO troCfmVO, SignOnUserAccount account) throws EventException;

	/**
	 * Handling cancel/Frust at ESM_BKG_0703 popup in ESM_BKG_0079_02C<br>
	 * @author Lee NamKyung
	 * @param  TroMultiCancelFrustVO[] troMultiCancelFrustVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelFrustEurTro(TroMultiCancelFrustVO[] troMultiCancelFrustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Handling TroCopy at ESM_BKG_0920 popup in ESM_BKG_0079_02C<br>
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO sourceBkg
	 * @param  String boundCd
	 * @param  String sourceTroSeq
	 * @param  BkgBlNoVO[] arrTagetBkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyTro(BkgBlNoVO sourceBkg, String boundCd, String sourceTroSeq, BkgBlNoVO[] arrTagetBkgBlNoVO, SignOnUserAccount account) throws EventException;	

	
	/* : confirm 관련로직시, 수정후 사용예정
	/--**
	 * (ESM_BKG_0079_02C : ESM_BKG_0703 popup)<br>
	 * @author Lee NamKyung
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String boundCd
	 * @param String troSeq
	 * @param String newTroStsCd
	 * @exception EventException
	 *--/
	public void changeEurTroStatus(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq, String newTroStsCd) throws EventException;
	*/

	/**
	 * (ESM_BKG_0905) TroActCust Dtl I/U/D processing<br>
	 * @author Lee NamKyung
	 * @param troActCustVO TroActCustVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String manageTroActCust(TroActCustVO troActCustVO, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_BKG_0905) Customer Tab master retrieve<br>
	 * @author Lee NamKyung
	 * @param  String custCntCd
	 * @param  String custSeq
	 * @param  String custNm
	 * @return List<MdmCustomerVO>
	 * @exception EventException
	 */
	public List<MdmCustomerVO> searchMdmCustForTro(String custCntCd, String custSeq, String custNm) throws EventException;

	/**
	 * (ESM_BKG_0905) Customer Tab detail Retrieve<br>
	 * @author Lee NamKyung
	 * @param  String ofcCd
	 * @param  String cntCd
	 * @param  String custSeq
	 * @return List<BkgTroActCustVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustVO> searchTroActCustByCust(String ofcCd, String cntCd, String custSeq) throws EventException;
	
	/**
	 * (ESM_BKG_0905) ActCustRep Master retrieve<br>
	 * @author Lee NamKyung
	 * @param  String doorLoc
	 * @param  String ofcCd
	 * @param  String custNm
	 * @return List<BkgTroActRepVO>
	 * @exception EventException
	 */
	public List<BkgTroActRepVO> searchActCustRep(String doorLoc, String ofcCd, String custNm) throws EventException;

	/**
	 * (ESM_BKG_0905) TroActCust Eq Dtl retrieve<br>
	 * @author Lee NamKyung
	 * @param  String doorLoc
	 * @param  String ofcCd
	 * @param  String troActRepSeq
	 * @return List<BkgTroActCustExtVO>
	 * @exception EventException
	 */
	public List<BkgTroActCustExtVO> searchTroActCustByEq(String doorLoc, String ofcCd, String troActRepSeq) throws EventException;

	/**
	 * (ESM_BKG_0905) Vendor Name retrieve<br>
	 * @author Lee NamKyung
	 * @param  String cntCd
	 * @param  String vndrSeq
	 * @return String
	 * @exception EventException
	 */
	public String searchVndrName(String cntCd, String vndrSeq) throws EventException;

	/**
	 * (ESM_BKG_0079_02C) Cago weight retrieve by CntrNo<br>
	 * @author    Lee NamKyung
	 * @param     String bkgNo
	 * @param     String cntrNo
	 * @return    String
	 * @exception EventException
	 */
	public String searchBkgCntrWgt(String bkgNo, String cntrNo) throws EventException;
	
	/**
	 * (ESM_BKG_0905) Retrieve info for Default value initialize when Open<br>
	 * @author Lee NamKyung
	 * @param  String doorLoc
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return TroActCustDefaultVO
	 * @exception EventException
	 */
	public TroActCustDefaultVO searchTroActCustDefault(String doorLoc, BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 *   BKG_TRO Flag change.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmTro(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * BKG_EUR_TRO Flag change.(ESM_BKG_0079_01)<br>
	 * @author 	Kim Byung Kyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String boundCd
	 * @param 	SignOnUserAccount account
     * @exception EventException
     */
    public void unconfirmEurTro(BkgBlNoVO bkgBlNoVO, String boundCd, SignOnUserAccount account) throws EventException;
    
    /**
     * tro relation info copy from sourceBkg to targetBkg. <br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectTroVO> selectTroVO
     * @param String troTp
     * @param SignOnUserAccount account
     * @return List<CombineTroNewSeqVO>
     * @exception EventException
     */
    public List<CombineTroNewSeqVO> copyTroByBkg(String copyModeCd, BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectTroVO> selectTroVO,String troTp, SignOnUserAccount account) throws EventException; 

    /**
	 * (ESM_BKG_0229_06) eBooking Tro relation save processing<br>
	 * : Include Tro/EurTro
	 * 
	 * @author Lee NamKyung
	 * @param  TroVO troVO
	 * @param  EurTroVO eurTroVO
	 * @param  String isEurFlg
	 * @param  SignOnUserAccount account
	 * @return Map<String,Object>
	 * @exception EventException
	 */
	public Map<String,Object> manageTroByXter(TroVO troVO, EurTroVO eurTroVO, String isEurFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling when EUR mty release at CTM<br>
	 *
	 * @param EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyEurTroByEmptyRelease(EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO, SignOnUserAccount account) throws EventException;
	
	/**
     * inland route Validation<br>
     * Checking to change route is registered or not as inland route.<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String fullCy
	 * @param       String door
	 * @param		String trspModCd
	 * @param		String checkCop
	 * @exception 	EventException
	 */
	public void validateInlaneRoute(BkgBlNoVO bkgBlNoVO, String boundCd, String fullCy, String door, String trspModCd, String checkCop) throws EventException;
	
	/**
     * renew pctl_no  in eur tro..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param 		String boundCd
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyEurTroPctlNo(BkgBlNoVO bkgBlNoVO, String boundCd, String troSeq,  SignOnUserAccount account) throws EventException;
	
	/**
     * renew pctl_no in general tro..<br>
     * @author 		Ryu Daeyoung
	 * @param       BkgBlNoVO bkgBlNoVO
	 * @param       String troSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyTroPctlNo(BkgBlNoVO bkgBlNoVO, String troSeq,  SignOnUserAccount account) throws EventException;
	
	/**
	 * tro relation info copy  from sourceBkg to targetBkg.
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void copyTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException;

	/**
	 * cancel sourceBkg.
	 * @param sourceBkg String 
	 * @param targetBkgNoList String[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void cancelTroBySplit(String sourceBkg, String[] targetBkgNoList, SignOnUserAccount account) throws EventException;
	
	/**
	 * TRO_SUB_SEQ를 조회한다.<br>
	 * @param     String bkgNo
	 * @param	  String boundCd
	 * @param	  String troSeq
	 * @return List<TroDtlVO>
	 * @exception EventException
	 */
	public List<TroDtlVO> searchEurTroSubSeqList(String bkgNo, String boundCd, String troSeq) throws EventException;
	
	/**
	 * Mininmum TRO_SUB_SEQ를 조회한다.<br>
	 * @param      String bkgNo
	 * @param	  String boundCd
	 * @param	  String troSeq
	 * @return 	  String
	 * @exception EventException
	 */
	public String searchMinEurTroSubSeq(String bkgNo, String boundCd, String troSeq) throws EventException;
	
	/**
	 * Retrieve to check the change of key information after confirm at EUR TRO<br>
	 * @param     String bkgNo
	 * @param	  String ioBndCd
	 * @param	  String troSeq
	 * @return    List<EurTroChangeVO>
	 * @exception EventException
	 */
	public List<EurTroChangeVO> searchEurTroChange(String bkgNo, String ioBndCd, String troSeq) throws EventException;
}