/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtBC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.AdjustSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.AuthorityOfficeVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarFinanMtrxGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CarrierVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CusBzcAgmtVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.CustomSearchOfficeMappingManagementVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.STLItemAcctVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.StlBssPortVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooCrrMrgVO;
import com.clt.syscommon.common.table.JooStlBssPortVO;
import com.clt.syscommon.common.table.JooStlVvdVO;

/**
 * OPUS-Jointoperationmasterdatamgt Business Logic Command Interface<br>
 * - OPUS-Jointoperationmasterdatamgt: Business Logic Interface<br>
 *
 * @author
 * @see Ui_joo_0028EventResponse
 * @since J2EE 1.4
 */

public interface JointOperationMasterDataMgtBC {
	/**
	 * retrieving Account Item List
	 * @return List<STLItemAcctVO>
	 * @throws EventException
	 */
	public List<STLItemAcctVO> searchSTLItemAcctList() throws EventException;
	
	/**
	 * saving Settlement Item 
	 * @param STLItemAcctVO[] sTLItemAcctVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageSTLItemAcct(STLItemAcctVO[] sTLItemAcctVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * retrieving Financial Matrix
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO searchCarFinancialMtrxList(CarrierVO carrierVO) throws EventException;

	/**
	 * retrieving settlement item not exists to create finance matrix
	 * @param CarrierVO carrierVO
	 * @return CarFinanMtrxGrpVO
	 * @throws EventException
	 */
	public CarFinanMtrxGrpVO calCarFinancialMtrx(CarrierVO carrierVO) throws EventException;

	/**
	 * saving Financial Matrix
	 * @param CarFinanMtrxGrpVO carFinanMtrxGrpVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarFinancialMtrx(CarFinanMtrxGrpVO carFinanMtrxGrpVO, SignOnUserAccount signOnUserAccount) throws EventException;
	
	
	/**
	 * retrieving Carrier Merge
	 * @param MstComInputVO mstComInputVO
	 * @return List<JooCrrMrgVO>
	 * @throws EventException
	 */
	public List<JooCrrMrgVO> searchCarrierMerge(MstComInputVO mstComInputVO) throws EventException;
	
	/**
	 * saving Carrier Merge
	 * @param JooCrrMrgVO[] jooCrrMrgVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCarrierMerge(JooCrrMrgVO[] jooCrrMrgVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * retrieving Vendor/Customer of carrier
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @throws EventException
	 */
	public List<CarrierVO> searchVndrCustListByCar(CarrierVO carrierVO) throws EventException;
	
	/**
	 * retrieving Basic Port List
	 * @param MstComInputVO mstComInputVO
	 * @param String lsAbbr
	 * @param String lsDir
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchSettlementBasicPortList(MstComInputVO mstComInputVO, String lsAbbr, String lsDir) throws EventException;
	
	/**
	 * saving Basic Port
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageSettlementBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * creating data again in case of duplication
	 * @param JooStlBssPortVO[] jooStlBssPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageCopyBasicPort(JooStlBssPortVO[] jooStlBssPortVOs, SignOnUserAccount signOnUserAccount) throws EventException;	
	
	/**
	 * retrieving Basic Port to create
	 * @param MstComInputVO mstComInputVO
	 * @return List<StlBssPortVO>
	 * @throws EventException
	 */
	public List<StlBssPortVO> searchItemDirList(MstComInputVO mstComInputVO) throws EventException;

	/**
	 * retrieving Target VVD 
	 * @param TargetVVDVO targetVVDVO
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> searchTargetVVDList(TargetVVDVO targetVVDVO) throws EventException;

	/**
	 * retrieving Target VVD to create
	 * @param TargetVVDVO targetVVDVO
	 * @param String joStlOptCd
	 * @return List<TargetVVDVO>
	 * @throws EventException
	 */
	public List<TargetVVDVO> createTargetVVDList(TargetVVDVO targetVVDVO, String joStlOptCd) throws EventException;
	
	/**
	 * saving Target VVD
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageTargetVVD(JooStlVvdVO[] jooStlVvdVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * retrieving jo_mnu_nm in jo_stl_tgt_tp_cd of Basic Port
	 * @param JooStlVvdVO jooStlVvdVO
	 * @return List<JooStlVvdVO>
	 * @throws EventException
	 */
	public List<JooStlVvdVO> searchOusTdrRdrInBssPort(JooStlVvdVO jooStlVvdVO) throws EventException;

	/**
	 * updating PROC_JP_FLG = 'Y' in case of settlement
	 * @param ProcSettlementVO[] procSettlementVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageTargetVVDForSettlement(ProcSettlementVO[] procSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
    /**
     * retrieving authority of Authority Office Creation
     * @param  AuthorityOfficeVO authorityOfficeVO
     * @return List<AuthorityOfficeVO>
     * @throws EventException
     */
    public List<AuthorityOfficeVO> searchAuthorityOffice(AuthorityOfficeVO authorityOfficeVO) throws EventException;
		
	
    /**
     * saving locale authority of Authority Office Creation<br>
     * 
     * @param  AuthorityOfficeVO[] authorityOfficeVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @author 
     */
	public void manageAuthorityOffice(AuthorityOfficeVO[] authorityOfficeVOs, SignOnUserAccount signOnUserAccount) throws EventException;
 
	
    /**
     * creating VVD not exists in target VVD
     * @param AdjustSettlementVO[] adjustSettlementVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageTargetVVDForAdjustment(AdjustSettlementVO[] adjustSettlementVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * retrieving target VVD closing status
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws EventException
	 */
	public List<JooCodeInfoVO> searchCloseYn(JooCodeParamVO jooCodeParamVO) throws EventException;

	/**
	 * deleting target VVD
	 * @param JooStlVvdVO[] jooStlVvdVOs
	 * @throws EventException
	 */
	public void removeTargetVVD(JooStlVvdVO[] jooStlVvdVOs) throws EventException;
	
    /**
     * 
     * @param  CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO
     * @return List<CustomSearchOfficeMappingManagementVO>
     * @throws EventException
     */
//    public List<CustomSearchOfficeMappingManagementVO> searchOfficeMappingManagementList(CustomSearchOfficeMappingManagementVO customSearchOfficeMappingManagementVO) throws EventException;

    /**
     * 
     * 
     * @param  CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     * @author
     */
//	public String manageOfficeMappingManagement(CustomSearchOfficeMappingManagementVO[] customSearchOfficeMappingManagementVOs, SignOnUserAccount signOnUserAccount) throws EventException;

//	/**
//	 * 
//	 * @param CusBzcAgmtVO[] cusBzcAgmtVOs
//	 * @param SignOnUserAccount signOnUserAccount
//	 * @return String
//	 * @throws EventException
//	 */
//	public String manageJooBzcAgmt(CusBzcAgmtVO[] cusBzcAgmtVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	
//	/**
//	 *
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws EventException
//	 */
//	public List<CusBzcAgmtVO> searchJooBzcAgmtList(CusBzcAgmtVO cusBzcAgmtVO) throws EventException ;

//	/**
//	 * 
//	 * @param JooCodeParamVO jooCodeParamVO
//	 * @return List<JooCodeInfoVO>
//	 * @throws EventException
//	 */
//	public List<JooCodeInfoVO> searchRefNoList(JooCodeParamVO jooCodeParamVO) throws EventException;

//	/**
//	 * 
//	 * @param CusBzcAgmtVO cusBzcAgmtVO
//	 * @return List<CusBzcAgmtVO>
//	 * @throws EventException
//	 */
//	public List<CusBzcAgmtVO> searchRefNoNPeriod(CusBzcAgmtVO cusBzcAgmtVO) throws EventException;	
}