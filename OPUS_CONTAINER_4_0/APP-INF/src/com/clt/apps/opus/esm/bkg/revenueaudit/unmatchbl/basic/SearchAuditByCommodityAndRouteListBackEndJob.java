/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchChargeFilteringListBackEndJob.java
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.29 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic;
import java.util.List;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLDBDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Audit by Commodity And Route 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sun-Woo, Ryu
 * @see UnmatchBLDBDAO
 * @since J2EE 1.6
 */
public class SearchAuditByCommodityAndRouteListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -1300323170372099358L;

	private  UnmatchBLDBDAO dbDao = new UnmatchBLDBDAO();
	
	private RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO; 

	/**
	 * Audit by Commodity And Route 리스트 조회조건을 셋팅한다. <br>
	 *  
	 * @param RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO
	 */
	public void setRsltSearchAuditByCommodityAndRouteListVO(RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO) {
		this.rsltSearchAuditByCommodityAndRouteListVO = rsltSearchAuditByCommodityAndRouteListVO;
	}

	/**
	 * Audit by Commodity And Route 리스트를 조회한다. <br>
	 *  
	 * @return List
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")	 	
	public List doStart() throws Exception {
		List list = null;
		try {
			list = dbDao.searchAuditByCommodityAndRouteList(this.rsltSearchAuditByCommodityAndRouteListVO);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
	        throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
		}
		return list;
	}
}
