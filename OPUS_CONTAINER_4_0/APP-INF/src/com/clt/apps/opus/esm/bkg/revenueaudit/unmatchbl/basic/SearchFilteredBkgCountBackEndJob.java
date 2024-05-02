/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchFilteredBkgCountBackEndJob.java
*@FileTitle : Filtered B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.21 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration.UnmatchBLDBDAO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 *  - UNMATCH BL INQUERY 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 이승준
 * @see UnmatchBLDBDAO
 * @since J2EE 1.6
 */
public class SearchFilteredBkgCountBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 1658687229317513392L;

	private  UnmatchBLDBDAO dbDao = new UnmatchBLDBDAO();
	RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO; 

	/**
	 * UNMATCH BL INQUERY 시 조건에 해당되는 값 세팅<br>
	 * 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 */
	public void setRsltUnmatchBLListbyAuditorVO(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) {
		this.rsltUnmatchBLListbyAuditorVO = rsltUnmatchBLListbyAuditorVO;
	}

	/**
	 * UNMATCH BL INQUERY 시 조건에 해당되는 BKG COUNT SEARCH<br>
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		String cnt = "0";
		try {
			cnt = dbDao.searchFilteredBkgCount(this.rsltUnmatchBLListbyAuditorVO);
        } catch(DAOException de) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), de);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
		}
		return cnt;
	}
}
