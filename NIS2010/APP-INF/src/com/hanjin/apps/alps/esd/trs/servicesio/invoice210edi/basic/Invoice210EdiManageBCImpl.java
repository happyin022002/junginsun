/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiManageBCImpl.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-08
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-05-08 eunju son
* 1.0 최초생성
=============================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.integration.Invoice210EdiManageDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.TrsTrspInvEdiVO;

/**
 * Invoice210EdiManageBCImpl
 * - Invoice210EdiManageBCImpl
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class Invoice210EdiManageBCImpl   extends BasicCommandSupport implements Invoice210EdiManageBC {
	// Database Access Object
	private transient Invoice210EdiManageDBDAO dbDao=null;
	
	public Invoice210EdiManageBCImpl(){
		dbDao = new Invoice210EdiManageDBDAO();
	}
	
	private String opCd ;
	
	public String getOp_cd() {
		return opCd;
	}
	
	public void setOp_cd(String opCd) {
		this.opCd = opCd;
	}

	/**
	 * 
	 * @param str
	 * @return
	 * @throws EventException
	 */
	public TrsTrspInvEdiVO receive210EDIData(String str) throws EventException {
		
		log.debug("str: " + str );

			
		String[] ediStr = str.split("\n");
		String  edi_seq = "";

			
		TrsTrspInvEdiVO model = null; 

	    
		///===== Collect received data & Allocate them to Collection models =====			
		model = new TrsTrspInvEdiVO();  
		
		try {	
			
			for( int i = 0; i<ediStr.length; i++){
				
				String[] itemStr = ediStr[i].split(":");

				if( "INV_NO".equals(itemStr[0])){
					if( itemStr[1].length() > 0){
						model.setInvNo((itemStr[1]).trim());						
					}
					
				}
				else if( "WO_NO".equals(itemStr[0])){
					if( itemStr.length == 2){
						if( itemStr[1].length() > 3){
							model.setTrspWoOfcCtyCd((itemStr[1].substring(0,3)).trim());   
							model.setTrspWoSeq((itemStr[1].substring(3,itemStr[1].length())).trim());
						}else{
							model.setTrspWoOfcCtyCd((itemStr[1].substring(0,itemStr[1].length())).trim());   
						}
					}
				}
				else if( "SO_NO".equals(itemStr[0])){
					if( itemStr.length == 2){
						if( itemStr[1].length() > 3){
							model.setTrspSoOfcCtyCd((itemStr[1].substring(0,3)).trim());  
							model.setTrspSoSeq((itemStr[1].substring(3,itemStr[1].length())).trim());
						}else{
							model.setTrspSoOfcCtyCd((itemStr[1].substring(0,itemStr[1].length())).trim());  
						}
					}
				}
				else if( "CNTR_NO".equals(itemStr[0])){
					if( itemStr.length == 2){
						model.setEqNo((itemStr[1]).trim());		
					}					
				}
				else if( "CNTR_TYPE".equals(itemStr[0])){
					if( itemStr.length == 2){
						model.setEqTpszCd((itemStr[1]).trim());	
					}
				}
				else if( "BKG_NO".equals(itemStr[0])){
					if( itemStr.length == 2){
						if( itemStr[1] != null || itemStr[1].length() >= 11 || itemStr[1].length() <= 13 ){	
							model.setBkgNo((itemStr[1]).trim());
						}
					}
				}
				else if( "T_AMOUNT".equals(itemStr[0])){
					if( itemStr.length == 2){
						model.setInvAmt((itemStr[1]).trim());								
					}
				}
				else if( "T_CUR_UNIT".equals(itemStr[0])){
					if( itemStr.length == 2){
						model.setInvCurrCd((itemStr[1]).trim());			
					}
				}
			}// for( int i = 0; i<ediStr.length; i++){ End !!!
			

			edi_seq = dbDao.getEdiSeq();

			if( !"".equals(edi_seq) && edi_seq != null ){
				model.setTrspInvEdiSeq(edi_seq);
			}
			log.debug("receive210EDIData:END "  );
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}
		return model;
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public boolean add210EDIManage(TrsTrspInvEdiVO model)throws EventException{
		
		boolean isSuccessful = false; 
	
		try{
	
			log.error("add210EDIManage START" );
			isSuccessful = dbDao.add210EDIManage(model);
			log.error("add210EDIManage END");
	
		}catch (DAOException de) {
			log.error("err " + de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new EventException(e.getMessage());
		}	
		
		return isSuccessful;
	
	}


}
