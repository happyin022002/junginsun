/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtBackEndJob.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.09.24 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration.TariffMgtDBDAO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * COM-AgreementManage Business Logic Command Interface<br>
 * - COM-AgreementManage에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jang Jun-Woo
 * @see ees_mnr_0188EventResponse,TariffMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TariffMgtBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;

	private TariffMgtDBDAO dbDao = new TariffMgtDBDAO();

	private String jobType = null;

	private DisposalTariffRegionVO[] disposalTariffRegionVOs = null;

	private SignOnUserAccount userAccount = null;

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return Object result
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		Object result = null;

		try {
			if(getJobType().equals("manageDisposalTariffRegionList")) {
				List<DisposalTariffRegionVO> insertVoList = new ArrayList<DisposalTariffRegionVO>();
				List<DisposalTariffRegionVO> updateVoList = new ArrayList<DisposalTariffRegionVO>();
				List<DisposalTariffRegionVO> deleteVoList = new ArrayList<DisposalTariffRegionVO>();

				for(int i = 0, cnt = 0; i < disposalTariffRegionVOs.length; i++ ) {
					if(disposalTariffRegionVOs[i].getIbflag().equals("I")) {
						//기존 데이터 존재 여부에 따라 insert 여부 결정
						if(!dbDao.searchDisposalTariffRegionExistData(disposalTariffRegionVOs[i])) {
							disposalTariffRegionVOs[i].setCreOfcCd(userAccount.getOfc_cd());
							disposalTariffRegionVOs[i].setCreUsrId(userAccount.getUsr_id());
							disposalTariffRegionVOs[i].setInsertSeq(String.valueOf(cnt++));
							insertVoList.add(disposalTariffRegionVOs[i]);
						}
					} else if(disposalTariffRegionVOs[i].getIbflag().equals("U")) {
						disposalTariffRegionVOs[i].setUpdUsrId(userAccount.getUsr_id());
						updateVoList.add(disposalTariffRegionVOs[i]);
					} else if(disposalTariffRegionVOs[i].getIbflag().equals("D")) {
						deleteVoList.add(disposalTariffRegionVOs[i]);
					}
				}

				if(insertVoList.size() > 0) {
					dbDao.addDisposalTariffRegionListData(insertVoList);
					result = insertVoList;
				}
				if(updateVoList.size() > 0) {
					dbDao.modifyDisposalTariffRegionListData(updateVoList);
					result = updateVoList;
				}
				if(deleteVoList.size() > 0) {
					dbDao.removeDisposalTariffRegionListData(deleteVoList);
					result = deleteVoList;
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}

		return result;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return the disposalTariffRegionVOs
	 */
	public DisposalTariffRegionVO[] getDisposalTariffRegionVOs() {
		DisposalTariffRegionVO[] rtnVOs = null;
		if (this.disposalTariffRegionVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(disposalTariffRegionVOs, disposalTariffRegionVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param disposalTariffRegionVOs the disposalTariffRegionVOs to set
	 */
	public void setDisposalTariffRegionVOs(DisposalTariffRegionVO[] disposalTariffRegionVOs){
		if(disposalTariffRegionVOs != null){
			DisposalTariffRegionVO[] tmpVOs = java.util.Arrays.copyOf(disposalTariffRegionVOs, disposalTariffRegionVOs.length);
			this.disposalTariffRegionVOs = tmpVOs;
		}
	}

	/**
	 * @return the userAccount
	 */
	public SignOnUserAccount getUserAccount() {
		return userAccount;
	}

	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(SignOnUserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
