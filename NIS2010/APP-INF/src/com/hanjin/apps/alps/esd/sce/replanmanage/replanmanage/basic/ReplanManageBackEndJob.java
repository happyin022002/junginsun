/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : BkgCopManageBackEndJob.java
* @FileTitle : BkgCopManage BackEndJob
* Open Issues :
* Change history :
* @LastModifyDate : 2011-09-27
* @LastModifier : Poong-Yeon Cho
* @LastVersion : 1.0
* 2011-09-27 Poong-Yeon Cho
* 1.0 최초생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.backend.core.BackEndMetaData;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.syscommon.common.table.SceCopHdrVO;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration.ReplanManageDBDAO;

/**
 * Back End Job 처리를 담당<br>
 * @author poong yeon cho
 * @see BkgCopManageBackEndJobBCImpl 참조
 * @since J2EE 1.6
 */
public class ReplanManageBackEndJob extends BackEndCommandSupport {

	//private static final long serialVersionUID = -5785543456939529197L;
	
	private transient ReplanManageDBDAO replanManageDbDao = null;
	private transient ReplanManageBCImpl replanCommand = null;
	
	private String pctlNo = null;
	private String bkgNo = null;
	private String cntrNo = null;
	
	/**
	 * Constructor
	 * @param String pctlNoVal
	 * @param String bkgNoVal
	 * @param String cntrNoVal
	 */
	public ReplanManageBackEndJob(String pctlNoVal, String bkgNoVal, String cntrNoVal){
		replanManageDbDao = new ReplanManageDBDAO();
		replanCommand = new ReplanManageBCImpl();
		this.pctlNo = pctlNoVal;
		this.bkgNo = bkgNoVal;
		this.cntrNo = cntrNoVal;
	}
	
	/**
	 * back end job을 실행시키는 mail method
	 * @return Object
	 * @throws Exception
	 */
	public Object doStart() throws Exception {
		
		List<SceCopHdrVO> rowVOs = replanManageDbDao.searchPartialCopsExptSelf(bkgNo, cntrNo, "C", "Y");
		boolean replanResult = false;
		
		log.debug("************* ReplanManageBackEndJob doStart ***************");
		for(int i=0;rowVOs!=null && rowVOs.size()>i; i++){
			rowVOs.get(i).setPctlNo(pctlNo);
			replanResult = replanCommand.replanCop(rowVOs.get(i), "SoRpln");
			log.debug("************* ReplanManageBackEndJob replan result("+i+")="+replanResult+" ***************");
		}
		log.debug("************* ReplanManageBackEndJob end ***************");		
		return null;
	}

}
