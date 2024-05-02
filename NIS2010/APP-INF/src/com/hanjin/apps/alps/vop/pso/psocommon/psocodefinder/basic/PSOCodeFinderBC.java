/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSOCodeFinderBC.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
* 
* History
* 2012.03.05 진마리아 CHM-201216583-01 Port Charge Invoice Creation 로직 변경 - 스케줄 존재 여부 점검 로직 추가 / KRPUS 스케줄에 대해 'Actual SKD 존재 체크' 로직 제외
=========================================================*/
package com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.CostListVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.MdmVslCntrVO;
import com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ALPS-Psocommon Business Logic Command Interface<br>
 * - ALPS-Psocommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jin Ihl
 * @see Pso_comEventResponse 참조
 * @since J2EE 1.4
 */

public interface PSOCodeFinderBC {

	/**
	 * Vessel Class List를 조회한다.
	 * @return
	 */
	public List<MdmVslCntrVO> searchVesselClassList() throws EventException;

	/**
	 * Account List를 조회한다.
	 * @return
	 */
	public List<CostListVO> searchAccountList() throws EventException;
	
	/**
	 * VOP_PSO_0203에서 vendor_seq를 이용하여 해당 vendor의 BankInfo를 Setting한다.
	 * @param vndrSeq
	 * @return
	 * @throws EventException 
	 */
	public String searchVendorName(String vndrSeq) throws EventException;

	/**
	 * VOP_PSO_0017,0031,0002의 Vendor List를 조회한다. 
	 * @param  VendorListVO vendorListVO
	 * @return List<VendorListVO>
	 * @throws EventException
	 */
	public List<VendorListVO> searchVendorList(VendorListVO vendorListVO) throws EventException;
	
	/**
	 * VOP_PSO_0014 : Grid VVD 체크  
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
	 * 유저가 입력한 VVD가 VSK_VSL_PORT_SKD에 존재하는 가 확인: Turn Port 인지 확인
	 * @category VOP_PSO_0014_GridVVDCheck
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param ydCd 
	 * @return
	 */
	public String getTurnPortIndCd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;
	/**
	 * 존재하는 Lane인지 체크
	 * @param  String rlaneCd
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 */
	public String checkRevLane(String rlaneCd) throws EventException;
	
	/**
	 * VVD가 SKD에 존재하는지 체크
	 * @param String vslCd  
	 * @param String skdVoyNo 
	 * @param String skdDirCd 
	 * @param String ydCd
	 * @return boolean 
	 * @exception EventException
	 */
	public boolean checkVslSkdVvd(String vslCd, String skdVoyNo, String skdDirCd, String ydCd) throws EventException;

}