/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PaperlessBCImpl.java
*@FileTitle : Paperless
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.09.01 차상영
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.paperless.basic;

import java.util.List;

import com.hanjin.bizcommon.paperless.integration.PaperlessDBDAO;
import com.hanjin.bizcommon.paperless.vo.SearchPaperlessListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-BizCommon Business Logic Basic Command implementation<br>
 * - NIS2010-BizCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author cha sangyoung
 * @since J2EE 1.4
 */

public class PaperlessBCImpl extends BasicCommandSupport implements PaperlessBC {

	// Database Access Object
	private transient PaperlessDBDAO dbDao = null;

	/**
	 * PaperlessBCImpl 객체 생성<br>
	 * PaperlessDBDAO를 생성한다.<br>
	 */
	public PaperlessBCImpl() {
		dbDao = new PaperlessDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 *  Paperless화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchPaperlessListVO   SearchPaperlessListVO
	 * @return List<SearchPaperlessListVO>
	 * @exception EventException
	 */
	public List<SearchPaperlessListVO> searchPaperlessList(SearchPaperlessListVO searchPaperlessListVO) throws EventException {
		try {
						
			List<SearchPaperlessListVO> list = dbDao.searchPaperlessListALPSA(searchPaperlessListVO); //ALPSA 조회
							
			if(list == null || list.size() < 1) { //ALPSA 조회후 데이터가 없으면 ALPSB 데이터를 출력
				list = dbDao.searchPaperlessListALPSB(searchPaperlessListVO);
			}
			
			if(list != null && list.size() > 0) {	
				SearchPaperlessListVO item = null;
				
				// content 컬럼 trim 처리
				for(int i=0; i<list.size(); i++) {
					item = (SearchPaperlessListVO) list.get(i);
					item.setPprlEmlCtnt(item.getPprlEmlCtnt().trim());
					list.set(i, item);
				}
			}
			
			return list;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}