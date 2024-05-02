/*=========================================================
*Copyright(c) 20006 CyberLogitec
*@FileName : COPUpdateBCImpl.java
*@FileTitle : COP Update
*Open Issues :
*Change history :
*@LastModifyDate : 20006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 20006-10-02 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copupdate.basic;


import java.util.List;


import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.clt.apps.opus.esd.sce.copmanage.copupdate.integration.COPUpdateDBDAO;
import com.clt.apps.opus.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;



/**
 * SCE Business Logic Basic Command implementation<br>
 * - SCE에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Seong-mun Kang
 * @see EsdSce0010EventResponse,COPUpdateBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class COPUpdateBCImpl   extends BasicCommandSupport implements COPUpdateBC {

	// Database Access Object
	private transient COPUpdateDBDAO dbDao=null; 

	/**
	 * 생성자
	 * COPUpdateDBDAO를 생성한다.<br>
	 */
	public COPUpdateBCImpl(){
		dbDao = new COPUpdateDBDAO();
	}

	
	/**
     * COP Detail Search 화면에 대한 MODIFY 이벤트 처리<br>
     * 
     * @param COPUpdateInfoVO inqVO
     * @return List<COPUpdateInfoVO>
     * @exception EventException
     */
	public List<COPUpdateInfoVO> modifyCOPDetailEstmActDT(COPUpdateInfoVO inqVO) throws EventException {
		List<COPUpdateInfoVO> list = null;
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();		                                                                                        
	
		
        String           dtType  = inqVO.getEstmActDt();
		String           actDT   = "A".equals(dtType)?
				                   JSPUtil.replace(inqVO.getActDate(),"-","") +
				                   inqVO.getActTime() : "";
		boolean           result  = false ;
		String           message = dtType.equals("E")?"Estimated Date/Time" : "Actual Date/Time" ;

		log.debug("\n dtType : " + dtType);
		try{
			if(dtType.equals("A")){

				boolean hasActDt = dbDao.searchCOPDetailActDt(inqVO);	
				if(!hasActDt){
					//tobe                                                                                                                                          
					command.copDetailReceiveMANUAL(inqVO.getCopNo(),                                                                                               
		                       inqVO.getCopDtlSeq(),                                                                                                                
		                       actDT,                                                                                                                  
		                       inqVO.getUserId(),                                                                                                                   
		                       "A", //actual                                                                                                            
		                       inqVO.getActStsCd(),                                                                                                                 
		                       inqVO.getNodCd(),                                                                                                                    
		                       inqVO.getActCd());					
				}else{
					throw new EventException(new ErrorHandler("SCE00029", new String[]{message}).getMessage()) ;					
				}

				result = true;
				
			}
			else{
				result = dbDao.modifyCOPEstmDT(inqVO) ;
			}
			
			if(!result){
				throw new EventException(new ErrorHandler("SCE00029", new String[]{message}).getMessage()) ;
			}
			
			list = dbDao.searchCOPDetailData(inqVO); 

		}
        catch(DAOException de){
        	log.error(de.getMessage(), de);
            throw new EventException(de.getMessage());
        }
		return list;
	}
	
	
}