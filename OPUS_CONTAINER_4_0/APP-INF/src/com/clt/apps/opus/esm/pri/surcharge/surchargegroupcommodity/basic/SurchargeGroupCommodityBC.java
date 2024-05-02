/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonGroupCommodityBC.java
*@FileTitle : GRI COMM Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.CommonGroupCommodityVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriComGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriScgGrpCmdtDtlVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * Surcharge Business Logic Command Interface<br>
 * - interface about Surcharge biz logic<br>
 *
 * @author 
 * @see Esm_pri_4008EventResponse 
 * @since J2EE 1.4
 */

public interface SurchargeGroupCommodityBC {
	/**
	 * Retrieving GRI Commodity's Master list<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @return CommonGroupCommodityVO
	 * @exception EventException
	 */
	public CommonGroupCommodityVO searchSurchargeGroupCommodityList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException;

    /**
     * Retrieving GRI Commodity's Detail list<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
     * @return List<RsltPriScgGrpCmdtDtlVO>
     * @exception EventException
     */
	public List<RsltPriScgGrpCmdtDtlVO> searchSurchargeGroupCommodityDetailList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException;
	
	/**
     * Retrieving GRI Commodity's Download Excel list<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
     * @return List<RsltPriComGrpCmdtExcelVO>
     * @exception EventException
     */
    public List<RsltPriComGrpCmdtExcelVO> searchSurchargeGroupCommodityExcelList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException;
	
	/**
	 * Saving GRI Commodity information <br>
	 * 
	 * @param CommonGroupCommodityVO commonGroupCommodityVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeGroupCommodity(CommonGroupCommodityVO commonGroupCommodityVO, SignOnUserAccount account) throws EventException;
}