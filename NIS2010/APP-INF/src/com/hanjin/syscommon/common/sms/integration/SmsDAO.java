/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MessagesDAO.java
 *@FileTitle : Message
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.01.02
 *@LastModifier : 정인선
 *@LastVersion : 1.0
 * 2009.01.02 정인선
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.sms.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.fileupload.integration.FileUploadDAOModulePathUSQL;
import com.hanjin.syscommon.common.sms.integration.SmsDAOSndCSQL;
import com.hanjin.syscommon.common.table.TblSubmitQueueVO;

/**
 * SMSDAO <br>
 * - SMS 발송에 필요한 DB 저장.<br>
 * 
 * @author Heo
 * @see SmsUtil 참조
 * @since 
 */
public class SmsDAO extends DBDAOSupport {

	
	/**
	 * 
	 * SMSDAO 메세지 발송 정보 추가<br>
	 * @param TblSubmitQueueVO
	 * @return int[]
	 * @throws DAOException
	 */
	public static int[] insertSms(TblSubmitQueueVO TblSubmitQueueVO) throws DAOException{
		Collection<TblSubmitQueueVO> models = new ArrayList<TblSubmitQueueVO>();
		models.add(TblSubmitQueueVO);
		try {
		return (new SQLExecuter("SysComDB").executeBatch(new SmsDAOSndCSQL(), models, null));
		} catch (SQLException e) {
			Logger.getLogger(e.getMessage());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} catch (Exception e) {
			Logger.getLogger(e.getMessage());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}


}
