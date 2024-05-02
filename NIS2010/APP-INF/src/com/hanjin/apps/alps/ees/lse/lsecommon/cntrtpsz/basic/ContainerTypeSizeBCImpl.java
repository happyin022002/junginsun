/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzBCImpl.java
*@FileTitle : Container Type/Size Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic;

import java.util.List;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.integration.ContainerTypeSizeDBDAO;

/**
 * NIS2010-CntrTpSz Business Logic Basic Command implementation<br>
 * - NIS2010-CntrTpSz에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see ContainerTypeSizeBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ContainerTypeSizeBCImpl extends BasicCommandSupport implements ContainerTypeSizeBC {

	// Database Access Object
	private transient ContainerTypeSizeDBDAO dbDao = null;

	/**
	 * CntrTpSzBCImpl 객체 생성<br>
	 * CntrTpSzDBDAO를 생성한다.<br>
	 */
	public ContainerTypeSizeBCImpl() {
		dbDao = new ContainerTypeSizeDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 *  Container Type/Size에 대한 조회 이벤트 처리<br>
	 *
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchCntrTpSzListBasic() throws EventException {
		List<MdmCntrTpSzVO> list = null;
		try {
			list = dbDao.searchContainerTypeSizeListData();

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Container Type Size의 가변적 Header를 조회합니다.<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerTypeSizeDynamicHeaderBasic() throws EventException {
		String cntrTpszHd = null;

		try {
			cntrTpszHd = dbDao.searchContainerTypeSizeDynamicHeaderData();
			if ( cntrTpszHd == null ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return cntrTpszHd;
	}
}