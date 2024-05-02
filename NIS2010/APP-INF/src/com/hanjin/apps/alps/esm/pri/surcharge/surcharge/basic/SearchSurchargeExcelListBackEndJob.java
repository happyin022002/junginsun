/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchSurchargeExcelListBackEndJob.java
*@FileTitle : SurchargeExcelList
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration.SurchargeDBDAO;
import com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo.CstPriScgRtVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 *  대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 
 * @see SurchargeDBDAO
 * @since J2EE 1.6
 */
public class SearchSurchargeExcelListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 6952105465428416158L;

	private  SurchargeDBDAO dbDao = new SurchargeDBDAO();
	
	private CstPriScgRtVO cstPriScgRtVO; 

	/**
	 *   SurchargeExcelList를 위해 조회 조건을 셋팅한다. <br>
	 *  
	 * @param CstPriScgRtVO cstPriScgRtVO
	 */	
	public void setCstPriScgRtVO(CstPriScgRtVO cstPriScgRtVO) {
		this.cstPriScgRtVO = cstPriScgRtVO;
	}

	/**
	 * SurchargeExcelList 조회한다.
	 *  
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")		
	public List doStart() throws Exception {
    	DBRowSet rowSet = null;
    	List<Object> sList = new ArrayList();
		String[] sTitle = null;
		String[] sColum = null;
		int colCnt = 0;
		try {
			rowSet = dbDao.searchSurchargeExcelList(this.cstPriScgRtVO);
			sList.add( rowSet );
			//엑셀다운 로드시 헤더 세팅..
			rowSet.next();
			colCnt = rowSet.getMetaData().getColumnCount();
			sTitle = new String[colCnt];
			sColum = new String[colCnt];

			for(int k=1; k<=rowSet.getMetaData().getColumnCount(); k++){
				sTitle[k-1] = JSPUtil.getNull(rowSet.getString(k));
				sColum[k-1] = rowSet.getMetaData().getColumnLabel(k);
				log.debug(">>>>*********************************************");
				log.debug("sTitle"+sTitle[k-1]);
				log.debug("sColum"+sColum[k-1]);
				log.debug("*********************************************<<<<");
			}
			sList.add( sTitle );
			sList.add( sColum );
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return sList;
	}
}
