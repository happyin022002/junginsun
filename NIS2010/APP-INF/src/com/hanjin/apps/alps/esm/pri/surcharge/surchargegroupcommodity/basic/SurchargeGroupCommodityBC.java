/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonGroupCommodityBC.java
*@FileTitle : GRI COMM Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.08 이승준
* 1.0 Creation
=========================================================
* 2016.02.04 전지예 [CHM-201640066] TPW Non-Cargo NOS 체크 권한 로직 부여 Request by Hye-In Ahn
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.CommonGroupCommodityVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriComGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo.RsltPriScgGrpCmdtDtlVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * NIS2010-Surcharge Business Logic Command Interface<br>
 * - NIS2010-Surcharge에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Esm_pri_4008EventResponse 참조
 * @since J2EE 1.4
 */

public interface SurchargeGroupCommodityBC {
	/**
	 * 조회 이벤트 처리<br>
	 *  GRI Commodity 화면에 대한 Master 조회 이벤트 처리<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @return CommonGroupCommodityVO
	 * @exception EventException
	 */
	public CommonGroupCommodityVO searchSurchargeGroupCommodityList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException;

    /**
     * 조회 이벤트 처리<br>
     *  GRI Commodity 화면에 대한 Detail 조회 이벤트 처리<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
	 * @param SignOnUserAccount account
     * @return List<RsltPriScgGrpCmdtDtlVO>
     * @exception EventException
     */
	public List<RsltPriScgGrpCmdtDtlVO> searchSurchargeGroupCommodityDetailList(PriScgGrpCmdtVO priScgGrpCmdtVO, SignOnUserAccount account) throws EventException;
	
	/**
     * 조회 이벤트 처리<br>
     * GRI Commodity 화면에 대한 Excel 조회 이벤트 처리<br>
     * 
     * @param PriScgGrpCmdtVO priScgGrpCmdtVO
     * @return List<RsltPriComGrpCmdtExcelVO>
     * @exception EventException
     */
    public List<RsltPriComGrpCmdtExcelVO> searchSurchargeGroupCommodityExcelList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * GRI Commodity 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param CommonGroupCommodityVO commonGroupCommodityVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageSurchargeGroupCommodity(CommonGroupCommodityVO commonGroupCommodityVO, SignOnUserAccount account) throws EventException;
}