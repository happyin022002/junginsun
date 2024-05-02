/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : CarrierSettlementProcessBackEndJob.java
*@FileTitle : CarrierSettlementProcessBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.26 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.basic;

import java.util.List;
import java.util.ArrayList;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAO;

/**
 * ALPS-JointOperationAccrualCreation Long Transaction Business Logic <br>
 * - ALPS-JointOperationAccrualCreation에 대한 Long Transaction 비지니스 로직<br>
 *
 * @author Park Hee Dong
 * @see fns_joo_0029EventResponse 참조
 * @since J2EE 1.6
 */
public class CarrierSettlementProcessBackEndJob extends BackEndCommandSupport {
	
	private CarrierSettlementProcessDBDAO dbDao;
	private TdrLoadVO[] tdrLoadVOs = null;
	private TdrLoadVO tdrLoadVO = null;
	private SignOnUserAccount signOnUserAccount = null;
	private String jobFlg = null;
	private String gubun = null;	
	

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -4432166936180768898L;

	/**
	 * Main Start
	 * @return List<TdrLoadVO>
	 * @throws Exception
	 */
	public List<TdrLoadVO> doStart() throws Exception {
        List<TdrLoadVO> list = null;
        try{
	        dbDao = new CarrierSettlementProcessDBDAO();
	
	        if ("RETRIEVE".equals(jobFlg)){
	        	
				List<TdrLoadVO> tdrVOs = dbDao.searchRobVvdList(tdrLoadVO);
				List<TdrLoadVO> rtnTdrLoads = null; 
				KorCllCdlCondVO korCllCdlCondVO = new KorCllCdlCondVO();
				
				for(int i=0; i<tdrVOs.size(); i++){
				
					korCllCdlCondVO.setInVvdCd(tdrVOs.get(i).getVvd());
					korCllCdlCondVO.setInPolCd(tdrVOs.get(i).getVpsPortCd());
					korCllCdlCondVO.setInPolYdCd(tdrVOs.get(i).getTmlCd());
					korCllCdlCondVO.setPolSplitNo(tdrVOs.get(i).getSplitNo());
					korCllCdlCondVO.setInDcgoFlg("");
					korCllCdlCondVO.setInRcFlg("");
					korCllCdlCondVO.setInAwkCgoFlg("");
					korCllCdlCondVO.setInBbCgoFlg("");
					korCllCdlCondVO.setInStwgCd("");
					korCllCdlCondVO.setInHotDeFlg("");
					korCllCdlCondVO.setInRdCgoFlg("");
					korCllCdlCondVO.setInSocFlg("");
					korCllCdlCondVO.setInPrctFlg("");
					korCllCdlCondVO.setInHngrFlg("");
												
					rtnTdrLoads = dbDao.searchRobTotal(korCllCdlCondVO, gubun);
									
					if(rtnTdrLoads.size() > 0){				
						tdrVOs.get(i).setSubChk(rtnTdrLoads.get(0).getSubChk());
						tdrVOs.get(i).setAllTeu(rtnTdrLoads.get(0).getAllTeu());
						tdrVOs.get(i).setAllWgt(rtnTdrLoads.get(0).getAllWgt());
						tdrVOs.get(i).setSource(rtnTdrLoads.get(0).getSource());
						tdrVOs.get(i).setJo20ftSubTeuQty(rtnTdrLoads.get(0).getJo20ftSubTeuQty());
						tdrVOs.get(i).setJo20ftN1stRto(rtnTdrLoads.get(0).getJo20ftN1stRto());
						tdrVOs.get(i).setJo40ftSubTeuQty(rtnTdrLoads.get(0).getJo40ftSubTeuQty());
						tdrVOs.get(i).setJo40ftN1stRto(rtnTdrLoads.get(0).getJo40ftN1stRto());
						tdrVOs.get(i).setJo45ftSubTeuQty(rtnTdrLoads.get(0).getJo45ftSubTeuQty());
						tdrVOs.get(i).setJo45ftN1stRto(rtnTdrLoads.get(0).getJo45ftN1stRto());
						tdrVOs.get(i).setJo45ftN2ndRto(rtnTdrLoads.get(0).getJo45ftN2ndRto());
						tdrVOs.get(i).setJoRndRuleLvl(rtnTdrLoads.get(0).getJoRndRuleLvl());						
						tdrVOs.get(i).setGrandTtlWgt(rtnTdrLoads.get(0).getGrandTtlWgt());					
						tdrVOs.get(i).setTeuQty(rtnTdrLoads.get(0).getTeuQty());
						tdrVOs.get(i).setFull20(rtnTdrLoads.get(0).getFull20());
						tdrVOs.get(i).setMt20(rtnTdrLoads.get(0).getMt20());					
						tdrVOs.get(i).setFull40(rtnTdrLoads.get(0).getFull40());
						tdrVOs.get(i).setMt40(rtnTdrLoads.get(0).getMt40());
						tdrVOs.get(i).setHcLd20(rtnTdrLoads.get(0).getHcLd20());
						tdrVOs.get(i).setHcBsa20(rtnTdrLoads.get(0).getHcBsa20());
						tdrVOs.get(i).setHcLd40(rtnTdrLoads.get(0).getHcLd40());
						tdrVOs.get(i).setHcBsa40(rtnTdrLoads.get(0).getHcBsa40());
						tdrVOs.get(i).setHcLd45(rtnTdrLoads.get(0).getHcLd45());
						tdrVOs.get(i).setHcBsa45(rtnTdrLoads.get(0).getHcBsa45());
						tdrVOs.get(i).setAkUnit(rtnTdrLoads.get(0).getAkUnit());
						tdrVOs.get(i).setRf20Qty(rtnTdrLoads.get(0).getRf20Qty());
						tdrVOs.get(i).setRfRdr20(rtnTdrLoads.get(0).getRfRdr20());						
						tdrVOs.get(i).setRfRdr40(rtnTdrLoads.get(0).getRfRdr40());						
						tdrVOs.get(i).setRf40Qty(rtnTdrLoads.get(0).getRf40Qty());
						tdrVOs.get(i).setDg20(rtnTdrLoads.get(0).getDg20());
						tdrVOs.get(i).setDg40(rtnTdrLoads.get(0).getDg40());
						tdrVOs.get(i).setMtTeu(rtnTdrLoads.get(0).getMtTeu());
						tdrVOs.get(i).setMtWt(rtnTdrLoads.get(0).getMtWt());
						tdrVOs.get(i).setAkVoid(rtnTdrLoads.get(0).getAkVoid());			
						tdrVOs.get(i).setSlanCd(rtnTdrLoads.get(0).getSlanCd());
						tdrVOs.get(i).setPass(rtnTdrLoads.get(0).getPass());						
					}
				}
				
		        list = new ArrayList<TdrLoadVO>();	        
		        list.addAll(tdrVOs);				
	        }
        }catch(Exception e){
        	super.log.error(e.getMessage());
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"ROB Container Summary List", ""}).getMessage(), e);
        }
        
        return list;
	}

	/**
	 * JOB FLAG setting
	 * @param String jobFlg
	 */
	public void setJobFlg(String jobFlg){
		this.jobFlg = jobFlg;
	}
	

	
	/**
	 * gubun setting
	 * @param String gubun
	 */
	public void setGubun(String gubun){
		this.gubun = gubun;
	}
		
	
	/**
	 * TdrLoadVO[] setting
	 * @param TdrLoadVO[] tdrLoadVOs
	 */
	public void setTdrLoadVOs(TdrLoadVO[] tdrLoadVOs) {		
		if (tdrLoadVOs != null) {
			TdrLoadVO[] tmpVOs = new TdrLoadVO[tdrLoadVOs.length];
			System.arraycopy(tdrLoadVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrLoadVOs = tmpVOs;
		}		
		
	}

	/**
	 * TdrLoadVO setting
	 * @param TdrLoadVO tdrLoadVO
	 */
	public void setTdrLoadVO(TdrLoadVO tdrLoadVO) {
		this.tdrLoadVO = tdrLoadVO;
	}

	/**
	 * SignOnUserAccount setting
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setSignOnUserAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}
}
