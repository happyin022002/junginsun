/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PSOCodeFinderBC.java
*@FileTitle : 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * ALPS-Psocommon Business Logic Command Interface<br>
 *
 * @author
 * @see Reference Pso_comEventResponse 
 * @since J2EE 1.4
 */

public interface PSOCodeFinderBC {

	/**
	 * Retrieve Vessel Class List
	 * @return
	 */
	public List<MdmVslCntrVO> searchVesselClassList() throws EventException;

	/**
	 * Retrieve Account List
	 * @return
	 */
	public List<CostListVO> searchAccountList() throws EventException;
	
	
	/**
	 * Retrieve Account<br>
	 * @param String ofcCd
	 * @return List<CostListVO>
	 * @exception EventException
	 */
	public List<CostListVO> searchAccountList(String ofcCd) throws EventException;
	
	/**
	 * Setting BankInfo of vendor by using vendor_seq in VOP_PSO_0203
	 * @param vndrSeq
	 * @return
	 * @throws EventException 
	 */
	public String searchVendorName(String vndrSeq) throws EventException;

	/**
	 * Retrieve Vendor List of VOP_PSO_0017,0031,0002 
	 * @param  VendorListVO vendorListVO
	 * @return List<VendorListVO>
	 * @throws EventException
	 */
	public List<VendorListVO> searchVendorList(VendorListVO vendorListVO) throws EventException;
	
	/**
	 * VOP_PSO_0014 : check Grid VVD   
	 * @param vslCd String 
	 * @param skdVoyNo String 
	 * @param skdDirCd String 
	 * @param String ydCd
	 * @return boolean 
	 * @throws EventException
	 */
	public boolean checkVslPortSkdVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * VOP_PSO_0014 : AfterEdit Grid VVD <br/>
	 * check existence of VVD input by user in VSK_VSL_PORT_SKD: check whether Turn Port 
	 * @category VOP_PSO_0014_GridVVDCheck
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param ydCd 
	 * @return
	 */
	public String getTurnPortIndCd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;
	/**
	 * check existence of Lane
	 * @param  String rlaneCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String checkRevLane(String rlaneCd) throws EventException;
	
	/**
	 * check whether Turning Port of VVD chosen
	 * @param vslCd String 
	 * @param skdVoyNo String 
	 * @param skdDirCd String 
	 * @param ydCd String
	 * @return String 
	 * @exception EventException
	 */
	public String getDefaultTurnPortIndIoData(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

	/**
	 * AR_MST_REV_VVD Check 구분 구하기 
	 * @param vslCd String 
	 * @param skdVoyNo String 
	 * @param skdDirCd String 
	 * @return String 
	 * @exception EventException
	 */
	public String checkArMasterRevenueByVvd(String vslCd, String skdVoyNo, String skdDirCd) throws EventException;

	/**
	 *  clpt_ind_seq를 조회한다.
	 * @param String vvd
	 * @param String ydCd
	 * @return String 
	 * @exception EventException
	 */
	public String searchClptIndSeq(String vvd, String ydCd) throws EventException;

}