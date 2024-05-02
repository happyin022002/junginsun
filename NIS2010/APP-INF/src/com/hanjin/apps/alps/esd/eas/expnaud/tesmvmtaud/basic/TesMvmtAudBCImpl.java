/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesMvmtAudBCImpl
*@FileTitle : Contianer Movement - Reefer
*Open Issues :   
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.basic;


import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.event.EsdEas0315Event;
import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.integration.TesMvmtAudDBDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.vo.SearchMvmtLegListVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * TesMvmtAudBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class TesMvmtAudBCImpl extends BasicCommandSupport implements TesMvmtAudBC {

	
	// Database Access Object
	private transient TesMvmtAudDBDAO dbDao = null;

	/**
	 * TesMvmtAudBCImpl 객체 생성<br>
	 * TesMvmtAudDBDAO 생성한다.<br>
	 */
	public TesMvmtAudBCImpl(){
		dbDao = new TesMvmtAudDBDAO();
	}

	/**
	 * Contianer Movement - Reefer 조회
	 * 
	 * @category EDS_EAS_0315
	 * @param e EsdEas0315Event
	 * @return List<SearchMvmtLegListVO>
	 * @throws EventException
	 */
	public List<SearchMvmtLegListVO> searchMvmtLegList(Event e) throws EventException {
		EsdEas0315Event event = (EsdEas0315Event) e;
		try {
			return dbDao.searchMvmtLegList(event.getSearchMvmtLegListVO());

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
}
