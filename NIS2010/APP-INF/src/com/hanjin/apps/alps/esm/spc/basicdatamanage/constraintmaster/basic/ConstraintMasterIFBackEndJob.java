/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName       : ConstraintMasterIFBackEndJob.java
*@FileTitle      : ConstraintMasterIFBackEndJob
*Open Issues     :
*Change history  :
*@LastModifyDate : 2015.05.27
*@LastModifier   : SPC USER
*@LastVersion    : 1.0
* 2015.05.27 SPC USER
* 1.0 Creation
* History 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration.ConstraintMasterDBDAO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic.StatusManageBC;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * -ConstraintMasterIFBackEndJob 에 대한 BackEndJob<br>
 *
 * @author SPC USER
 * @see StatusManageBC
 * @since J2EE 1.6
 */
public class ConstraintMasterIFBackEndJob  extends BackEndCommandSupport{
	
	private static final long serialVersionUID = -2031526954169419719L;
	
	private ConstraintMasterDBDAO dbDao = new ConstraintMasterDBDAO();
	
	private String jobType = "";
	private String propNo = "";
	private String amdtSeq = "";
	private String usrId = "";

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * BackEndJob 실행 - 프로시져 호출 <br>
	 *  
	 * @return ParamProcedureVO
	 * @exception Exception
	 */	
	@Override
	public Object doStart() {
		try{
			//Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받는다.	
			if( jobType.equals("FixedFlagIF") ) {
				dbDao.addFixedFlagInfoByPri(propNo, amdtSeq, usrId);
			}	

		} catch (DAOException ex) {
			log.error(ex.getMessage());
			try {
				//Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받다가 에러시 Log를 남긴다.
				dbDao.addFixedFlagInfoByPriErrLog(propNo, amdtSeq);
			} catch (DAOException e) {
				log.error(e.getMessage());
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
			try {
				//Pri에서 Fixed Flag가 체크된 계약의 계약NO를 I/F 받다가 에러시 Log를 남긴다.
				dbDao.addFixedFlagInfoByPriErrLog(propNo, amdtSeq);
			} catch (DAOException e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}
}
