/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommodityBC.java
*@FileTitle : CommodityBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.commodity.basic;
 
import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.CommodityVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.CustPackageTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.GrpCommodityVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.PackageTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.commodity.vo.RepCommodityVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Common code Business Logic Command Interface<br>
 * An interface to the business logic for Common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface CommodityBC {

	/**
	 * Group Commodity information retrieve<br>
	 * 
	 * @param String grpCmdtCd
	 * @return List<GrpCommodityVO>
	 * @exception EventException
	 */
	public List<GrpCommodityVO> searchGroupCommodity(String grpCmdtCd) throws EventException;

	/**
	 * Save Group Commodity information (adding /chainging)<br>
	 * 
	 * @param GrpCommodityVO[] grpCmdtVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCommodityVO[] grpCmdtVOs, String usrId) throws EventException;
	
	/**
	 * Rep Commodity information retrieve<br>
	 * 
	 * @param String repCmdtCd
	 * @return List<GrpCommodityVO>
	 * @exception EventException
	 */
	public List<RepCommodityVO> searchRepCommodity(String repCmdtCd) throws EventException;

	/**
	 * Save Rep Commodity information (adding /chainging<br>
	 * 
	 * @param RepCommodityVO[] repCmdtVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageRepCommodity(RepCommodityVO[] repCmdtVOs, String usrId) throws EventException;
	
	/**
	 * Commodity information retrieve<br>
	 * 
	 * @param String cmdtCd
	 * @return List<CommodityVO>
	 * @exception EventException
	 */
	public List<CommodityVO> searchCommodity(String cmdtCd) throws EventException;
	
	/**
	 * Commodity information retrieve<br>
	 * 
	 * @param String rqstNo
	 * @return List<CommodityVO>
	 * @exception EventException
	 */
	public List<CommodityVO> searchCommodityRqst(String rqstNo) throws EventException;

	/**
	 * Save Commodity information (adding /chainging<br>
	 * 
	 * @param CommodityVO[] cmdtVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageCommodity(CommodityVO[] cmdtVOs, String usrId) throws EventException;
	
	/**
	 * Save Commodity information (adding /chainging<br>
	 * 
	 * @param CommodityVO[] cmdtVOs
	 * @param String usrId
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageCommodityRqst(CommodityVO[] cmdtVOs, String usrId, String rqstNo) throws EventException;
	
	/**
	 * Customer Package Type information retrieve<br>
	 * 
	 * @param String pckCd
	 * @param String cstmsCntCd
	 * @return List<CustPackageTypeVO>
	 * @exception EventException
	 */
	public List<CustPackageTypeVO> searchCustPackageType(String pckCd, String cstmsCntCd) throws EventException;

	/**
	 * Save Customer Package Type information (adding /chainging<br>
	 * 
	 * @param CustPackageTypeVO[] custPackTypeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageCustPackageType(CustPackageTypeVO[] custPackTypeVOs, String usrId) throws EventException;

	/**
	 * Package Type information retrieve<br>
	 * 
	 * @param String pckCd
	 * @return List<PackageTypeVO>
	 * @exception EventException
	 */
	public List<PackageTypeVO> searchPackageType(String pckCd) throws EventException;

	/**
	 * Save Package Type information (adding /chainging<br>
	 * 
	 * @param PackageTypeVO[] packTypeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void managePackageType(PackageTypeVO[] packTypeVOs, String usrId) throws EventException;
	
}