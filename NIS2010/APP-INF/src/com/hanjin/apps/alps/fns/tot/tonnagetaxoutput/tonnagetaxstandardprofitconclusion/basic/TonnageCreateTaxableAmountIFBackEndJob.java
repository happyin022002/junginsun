/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TonnageCreateTaxableAmountIFBackEndJob.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration.TonnageTaxStandardProfitConclusionDBDAO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.integration.TonnageTaxStandardProfitConclusionEAIDAO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * FNS_TOT_0018 화면에 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jang chang su
 * @see UI_GEM_0019EventResponse,GEMPlanningPerformanceBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TonnageCreateTaxableAmountIFBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private TonnageTaxStandardProfitConclusionDBDAO dbDao;
	private TonnageTaxStandardProfitConclusionEAIDAO eaiDao;
	/**
     * TonnageTaxStandardProfitConclusionBCImpl 객체 생성<br>
     * TonnageTaxStandardProfitConclusionDBDAO 생성한다.<br>
     */
    public TonnageCreateTaxableAmountIFBackEndJob() {
		dbDao = new TonnageTaxStandardProfitConclusionDBDAO();
		eaiDao = new TonnageTaxStandardProfitConclusionEAIDAO();
    }

    private String stlYrmon;
    private String usrId;
	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * ERP I/F 의 데이터를 생성하고 연동작업을 수행한다. <br>
	 * 
	 * @return List<ErpIfVO>
	 * @exception EventException
	 */

	public List<ErpIfVO> doStart() throws Exception {
			
			List<ErpIfVO> erpIfVOs = new ArrayList<ErpIfVO>();
			try {
				
				log.debug("::CALL::> FNS_TOT_0018 BC >진입  createTaxableAmountIF :::::::::   "+stlYrmon);
              
				String stlYrmm = "";
				String stlMm = "";
				String userId = this.usrId;
				
				int toNum = Integer.parseInt(this.stlYrmon.substring(5, 7));
				
				for(int i=1;i<=toNum;i++){
					
					if(i<10){
						stlMm = "0"+i;
					}else{
						stlMm = i+"";
					}
					
					 stlYrmm = this.stlYrmon.substring(0, 4)+stlMm;
					 log.debug("stlYrmm    :::::::::::::::::::   "+stlYrmm);
					 
					 
					 //log.debug("::CALL::> FNS_TOT_0001 BC >진입 :::::::::");
					 List<ErpIfVO> list = null;
						
						//totBsaVO.setCreUsrId(signOnUserAccount.getUsr_id());
					 list = dbDao.searchTaxableAmountForCreationIF(stlYrmm,userId);

					 List<ErpIfVO> insertVoList = new ArrayList<ErpIfVO>();
						
					 log.debug("::CALL::> FNS_TOT_0018 I/F DAQ > search 진입::::::::: list.size() : "+list.size());
					 for(int j=0; j<list.size(); j++){
							insertVoList.add(list.get(j));					
					 }

					 if ( insertVoList.size() > 0 ) {
							
					 	dbDao.createTaxableAmountIF(insertVoList);
					 }
					
				}
				erpIfVOs = dbDao.searchTaxableAmountIF(stlYrmm);
				log.debug("::CALL::> getRNum :::: :::::::::   "+erpIfVOs.get(0).getRNum());
				eaiDao.sendErpIfData(stlYrmm,userId,erpIfVOs);// ==> EAI 연계
				return null;
			} catch (DAOException ex) {
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(ex.getMessage(),ex);
			}
	}
}