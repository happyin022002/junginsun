/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueApPeriodBCImpl.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2008-06-17 : schema변경
 * 2010-03-09 [CHM-201002999] : ERP  결산 정보(컬럼)을 ENIS/ALPS로 I/F 요청
 =========================================================*/
package com.clt.apps.opus.common.tableSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.clt.apps.opus.common.tableSync.jms.integration.ReceiveQueueApPeriodDBDAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.ApPeriodVO;
import com.clt.irep.erp.EAIHeaderType;
import com.clt.irep.erp.FNS0480002Document;
import com.clt.irep.erp.FNS0480002Document.FNS0480002;
import com.clt.irep.erp.FNS0480002Document.FNS0480002.DataArea;
import com.clt.irep.erp.FNS0480002Document.FNS0480002.DataArea.ROWSET;
import com.clt.irep.erp.FNS0480002Document.FNS0480002.DataArea.ROWSET.ROW;

/**
 * XML 메시지를 parsing 하고 DBDAO에게 넘겨준다.
 * @author KJJ
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueApPeriodBCImpl extends BasicCommandSupport
		implements ReceiveQueueBC {
	private transient ReceiveQueueApPeriodDBDAO dbDao = null;

	/**
	 * 생성자
	 *
	 */
	public ReceiveQueueApPeriodBCImpl() {
		dbDao = new ReceiveQueueApPeriodDBDAO();
	}

	/**
	 * FNS0480001Document parse
	 * @param xmlObjcet
	 */
	@SuppressWarnings("unchecked")
	public Collection receiveBKGTB(XmlObject xmlObject) {
		FNS0480002Document	doc		= (FNS0480002Document) xmlObject;
		FNS0480002			sync	= doc.getFNS0480002();
		
		EAIHeaderType		header	= sync.getEAIHeader();

		DataArea			data	= sync.getDataArea();
		ROWSET				rowset	= data.getROWSET();
		ROW	[]				row		= rowset.getROWArray();
		
		ApPeriodVO			model	= null;
		Collection			models	= new ArrayList();

		
		String			instanceId	= header.getInstanceId();
		String			eai_evnt_dt	= instanceId.substring(12,26);

		for (int i = 0; row != null && i < row.length; i++) {
			model = new ApPeriodVO();
			model.setSysDivCd		( row[i].getSYSDIV());
			model.setEffYrmon		( row[i].getEFFDT());
			model.setClzStsCd		( row[i].getCLSSTS());
			model.setSysDesc		( row[i].getSYSDESC());
			model.setEaiEvntDt		( eai_evnt_dt);
			model.setOfcCd			( row[i].getOFC());
			model.setArApDivCd		( row[i].getARAPDIV());
			model.setRhqCd			( row[i].getRHQ());
			// 2010-03-09 [CHM-201002999] : ERP  결산 정보(컬럼)을 ENIS/ALPS로 I/F 요청
			model.setLstUpdDt		( row[i].getLASTUPDATEDATE());
			models.add(model);
		}
		return models;
	}

	/**
	 * flag에 따라 DBDAO의 메서드를 호출 한다.
	 * @param models
	 */
	@SuppressWarnings("unchecked")
	public void ctrlBKGTB(Collection models) throws DAOException{

		Iterator	itr			= models.iterator();
		ApPeriodVO	apPeriodVO	= null;
		
		int		i	= 1;
		boolean	isSuccessful	= false;
		
		while (itr.hasNext()) {
			apPeriodVO = (ApPeriodVO)itr.next();
			
			try {
				
				isSuccessful = dbDao.searchApPeriodList(apPeriodVO);
				
				if ( isSuccessful ) {
					dbDao.addApPeriod(apPeriodVO);
				} else {
					dbDao.modifyApPeriod(apPeriodVO);
				}
				
			} catch (DAOException de) {
				log.error("err " + de.toString(), de);
				throw de;
			} catch (Exception e) {
				log.error("Exception " + e.toString(), e);
			}
			i++;
		}
	}
}
