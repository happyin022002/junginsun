/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalBCImpl.java
*@FileTitle : On Hire Approval inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.basic; 

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.integration.OnhireApprovalDBDAO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.LseOnhAproVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
/**
 * ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * Handling Biz Logic of ContainerLeaseMgt<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0031EventResponse,OnhireApprovalBC 
 * @since J2EE 1.6
 */
public class OnhireApprovalBCImpl extends BasicCommandSupport implements OnhireApprovalBC {

	// Database Access Object 
	private transient OnhireApprovalDBDAO        dbDao = null;

	/**
	 * Generating OnhireApprovalBCImpl Object<br>
	 * Generating OnhireApprovalDBDAO<br>
	 */
	public OnhireApprovalBCImpl() {
		dbDao     = new OnhireApprovalDBDAO();
	}
	/**
	 * Handling Retrieving Event<br>
	 * Retrieving Approval number of Equipment which is going to be Onhire<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalNumberBasic(OnhireApprovalVO onhireApprovalVO) throws EventException {
		
		try {
			return dbDao.searchOnhireApprovalNumberData(onhireApprovalVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}
	/**
	 * Handling Auth No Retrieving Event<br>
	 * Handling Auth No Retrieving Event about OnHireApproval Screen<br>
	 * 
	 * @param  String pOnhLocCd
	 * @param  String pLstmCd
	 * @param  String periodStdt
	 * @param  String periodEddt
	 * @param  String cntrOnhAuthNo
	 * @return List<LseOnhAproVO>
	 * @exception EventException
	 */
    public List<LseOnhAproVO> searchOnhireApprovalNumberBrieflyBasic(String pOnhLocCd , String pLstmCd , String cntrOnhAuthNo)  throws EventException {
		
		try {
			return dbDao.searchOnhireApprovalNumberBrieflyData(pOnhLocCd , pLstmCd , cntrOnhAuthNo);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBriefly Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBriefly Search"}).getMessage(),ex);
		}
	}
	/**
	 * Handling Saving Event<br>
	 * Saving detail pick-up Approval after Hire Contract of hiring Containers(Long-term, Short-term, OF)<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @param  OnhireApprovalVO[] onhireApprovalVOs
	 * @param  SignOnUserAccount account
	 * @param  List<MdmCntrTpSzVO> cntrList
	 * @return String
	 * @exception EventException    
	 */
    public String createOnhireApprovalNumberBasic(OnhireApprovalVO onhireApprovalVO, OnhireApprovalVO[] onhireApprovalVOs , SignOnUserAccount account, List<MdmCntrTpSzVO> cntrList) throws EventException {
		try {
			
			String locCd          = onhireApprovalVO.getLocCd();
			String leaseTerm      = onhireApprovalVO.getLeaseTerm();
			String pkupFmDt       = onhireApprovalVO.getPkupFmDt();
			String pkupDueDt      = onhireApprovalVO.getPkupDueDt();
			String aproRmk        = onhireApprovalVO.getAproRmk();
			String tpszCd         = onhireApprovalVO.getTpszCd();
			String MainAgmtSeq    = "";
						
			String cntrOnhAuthNo = "";
			if(locCd.length() == 5){
			    cntrOnhAuthNo = locCd.substring(2) + leaseTerm;
			}
			for(int i = 0 ; i < onhireApprovalVOs.length ; i++){
				MainAgmtSeq       = onhireApprovalVOs[i].getAgmtSeq();
			}
			cntrOnhAuthNo = dbDao.addOnhireApprovalAuthNoData(cntrOnhAuthNo , locCd , leaseTerm, MainAgmtSeq);
			String agmtCtyCd     = "";
            String agmtSeq       = "";
            String mftYr         = "";
            String freeDys       = "";
            String pkupChgAmt    = "";
            String pkupChgCrAmt  = "";
            String minOnhDys     = "";
            String creUsrId      = account.getUsr_id();
            String cntrTpszCd    = "";
            String onhQtyOld     = "";
            String onhQtyNew     = "";
            String onhQtyLon     = "";
            String pkupChgQty    = "";
            String errTpsz       = "";
            String retrunLccCd       = "";
            
            String strQtyChk ="Y";
            String strFullAgmtSeq = "";
            for(int i = 0 ; i < onhireApprovalVOs.length ; i++){
            	
	            agmtCtyCd     = onhireApprovalVOs[i].getAgmtCtyCd();
	            agmtSeq       = onhireApprovalVOs[i].getAgmtSeq();
	            mftYr         = onhireApprovalVOs[i].getMftYr();
	            freeDys       = onhireApprovalVOs[i].getFreeDys();
	            pkupChgAmt    = onhireApprovalVOs[i].getPkupChgAmt();
	            pkupChgCrAmt  = onhireApprovalVOs[i].getPkupChgCrAmt();
	            minOnhDys     = onhireApprovalVOs[i].getMinOnhDys();
	            retrunLccCd            = onhireApprovalVOs[i].getReturnLcc();
	            
	            if(i == 0){
                	strFullAgmtSeq = agmtSeq;
                }else{
                	strFullAgmtSeq = strFullAgmtSeq+","+agmtSeq;
                }
                
	            
                if(minOnhDys == null || "".equals(minOnhDys)){
                	minOnhDys = "0";
                }

                String tpszs  = "";
                
                for( int tpi = 0 ; tpi < cntrList.size(); tpi++){
                	MdmCntrTpSzVO tpVo = cntrList.get(tpi);
                	tpVo.getCntrTpszCd();
                	if(tpi == 0){
                	    tpszs = tpszs +  tpVo.getCntrTpszCd();
                	}else{
                		tpszs = tpszs + "," + tpVo.getCntrTpszCd();
                	}
                }
                
				dbDao.addOnhireApprovalNumberData(cntrOnhAuthNo ,agmtCtyCd ,agmtSeq ,leaseTerm ,locCd ,pkupFmDt ,pkupDueDt ,mftYr ,freeDys ,pkupChgAmt ,pkupChgCrAmt ,minOnhDys ,aproRmk ,creUsrId, retrunLccCd);
				
	            String[] arryTpszCd = tpszCd.split(",");
	            for(int j=0; j<arryTpszCd.length; j++){
	            
	            	cntrTpszCd = arryTpszCd[j];
	            	
	            	if( cntrTpszCd != null && cntrTpszCd.equals("D2")){
	            		onhQtyOld = onhireApprovalVOs[i].getD2Old();
			            onhQtyNew = onhireApprovalVOs[i].getD2New();
			            onhQtyLon = onhireApprovalVOs[i].getD2Lon();
	            	}else if( cntrTpszCd != null && cntrTpszCd.equals("D4")){
	            		onhQtyOld = onhireApprovalVOs[i].getD4Old();
	            		onhQtyNew = onhireApprovalVOs[i].getD4New();
	            		onhQtyLon = onhireApprovalVOs[i].getD4Lon();
	            	}else if( cntrTpszCd != null && cntrTpszCd.equals("D5")){
	            		onhQtyOld = onhireApprovalVOs[i].getD5Old();
	            		onhQtyNew = onhireApprovalVOs[i].getD5New();
	            		onhQtyLon = onhireApprovalVOs[i].getD5Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D7")){
		            	onhQtyOld = onhireApprovalVOs[i].getD7Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD7New();
		            	onhQtyLon = onhireApprovalVOs[i].getD7Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R5")){
		            	onhQtyOld = onhireApprovalVOs[i].getR5Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR5New();
		            	onhQtyLon = onhireApprovalVOs[i].getR5Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("O2")){
		            	onhQtyOld = onhireApprovalVOs[i].getO2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getO2New();
		            	onhQtyLon = onhireApprovalVOs[i].getO2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("S2")){
		            	onhQtyOld = onhireApprovalVOs[i].getS2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getS2New();
		            	onhQtyLon = onhireApprovalVOs[i].getS2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("O4")){
		            	onhQtyOld = onhireApprovalVOs[i].getO4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getO4New();
		            	onhQtyLon = onhireApprovalVOs[i].getO4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("S4")){
		            	onhQtyOld = onhireApprovalVOs[i].getS4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getS4New();
		            	onhQtyLon = onhireApprovalVOs[i].getS4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("F2")){
		            	onhQtyOld = onhireApprovalVOs[i].getF2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getF2New();
		            	onhQtyLon = onhireApprovalVOs[i].getF2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("A2")){
		            	onhQtyOld = onhireApprovalVOs[i].getA2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getA2New();
		            	onhQtyLon = onhireApprovalVOs[i].getA2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("F4")){
		            	onhQtyOld = onhireApprovalVOs[i].getF4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getF4New();
		            	onhQtyLon = onhireApprovalVOs[i].getF4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("A4")){
		            	onhQtyOld = onhireApprovalVOs[i].getA4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getA4New();
		            	onhQtyLon = onhireApprovalVOs[i].getA4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("F5")){
		            	onhQtyOld = onhireApprovalVOs[i].getF5Old();
		            	onhQtyNew = onhireApprovalVOs[i].getF5New();
		            	onhQtyLon = onhireApprovalVOs[i].getF5Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R7")){
		            	onhQtyOld = onhireApprovalVOs[i].getR7Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR7New();
		            	onhQtyLon = onhireApprovalVOs[i].getR7Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("P2")){
		            	onhQtyOld = onhireApprovalVOs[i].getP2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getP2New();
		            	onhQtyLon = onhireApprovalVOs[i].getP2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("P4")){
		            	onhQtyOld = onhireApprovalVOs[i].getP4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getP4New();
		            	onhQtyLon = onhireApprovalVOs[i].getP4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("T2")){
		            	onhQtyOld = onhireApprovalVOs[i].getT2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getT2New();
		            	onhQtyLon = onhireApprovalVOs[i].getT2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("T4")){
		            	onhQtyOld = onhireApprovalVOs[i].getT4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getT4New();
		            	onhQtyLon = onhireApprovalVOs[i].getT4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R2")){
		            	onhQtyOld = onhireApprovalVOs[i].getR2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR2New();
		            	onhQtyLon = onhireApprovalVOs[i].getR2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("Q4")){
		            	onhQtyOld = onhireApprovalVOs[i].getQ4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getQ4New();
		            	onhQtyLon = onhireApprovalVOs[i].getQ4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("Q2")){
		            	onhQtyOld = onhireApprovalVOs[i].getQ2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getQ2New();
		            	onhQtyLon = onhireApprovalVOs[i].getQ2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D9")){
		            	onhQtyOld = onhireApprovalVOs[i].getD9Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD9New();
		            	onhQtyLon = onhireApprovalVOs[i].getD9Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D8")){
		            	onhQtyOld = onhireApprovalVOs[i].getD8Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD8New();
		            	onhQtyLon = onhireApprovalVOs[i].getD8Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D3")){
		            	onhQtyOld = onhireApprovalVOs[i].getD3Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD3New();
		            	onhQtyLon = onhireApprovalVOs[i].getD3Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R4")){
		            	onhQtyOld = onhireApprovalVOs[i].getR4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR4New();
		            	onhQtyLon = onhireApprovalVOs[i].getR4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("DX")){
		            	onhQtyOld = onhireApprovalVOs[i].getDxLon();
		            	onhQtyNew = onhireApprovalVOs[i].getDxNew();
		            	onhQtyLon = onhireApprovalVOs[i].getDxLon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("DW")){
		            	onhQtyOld = onhireApprovalVOs[i].getDwLon();
		            	onhQtyNew = onhireApprovalVOs[i].getDwNew();
		            	onhQtyLon = onhireApprovalVOs[i].getDwLon();
		            }
	            	
			        if(onhQtyOld == null || onhQtyOld.equals("")){
			        	onhQtyOld = "0";
			        }
			        if(onhQtyNew == null || onhQtyNew.equals("")){
			        	onhQtyNew = "0";
			        }
			        if(onhQtyLon == null || onhQtyLon.equals("")){
			        	onhQtyLon = "0.00";
			        }
			        
			        int iOld = Integer.parseInt(onhQtyOld);
			        int iNew = Integer.parseInt(onhQtyNew);
			        
			        if(cntrTpszCd != null) {
		            	if(tpszs.indexOf(cntrTpszCd) < 0 && (  iOld > 0  || iNew > 0 ) ){
		            		//if(errTpsz == ""){
		            		if("".equals(errTpsz)){
		            			errTpsz = cntrTpszCd ;
		            		}else{
		            			errTpsz = errTpsz + "," + cntrTpszCd ;
		            		}
		            	}else{
		            		dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "O" , pkupChgQty , onhQtyOld , onhQtyLon, creUsrId );
			            	dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "N" , pkupChgQty , onhQtyNew , onhQtyLon, creUsrId );
		            	}
			        }
	            }
	            
	            //if(errTpsz != ""){
	            if(!"".equals(errTpsz)){
	            	throw new EventException(new ErrorHandler("LSE01141", new String[]{ "HHO" + agmtSeq , errTpsz  }).getMessage());
	            }
			}

            createOnhireApprovalNumberHistoryBasic(cntrOnhAuthNo, creUsrId);
            
            List<OnhireApprovalVO> data = dbDao.searchApprovalQtyChkData(strFullAgmtSeq);
            if(data.size() > 0) {
            	for(int i=0;i<data.size();i++) {
            		if(Integer.parseInt(data.get(i).getTotalOnhQty()) < Integer.parseInt(data.get(i).getOnhQty())) {
                    	strQtyChk = "N";
                    	break;
                    }
            	}
            }
            
            if("N".equals(strQtyChk)) {
            	throw new EventException(new ErrorHandler("LSE10008", new String[]{ "HHO" + agmtSeq , errTpsz  }).getMessage());
            }

            return cntrOnhAuthNo;
            
		} catch(EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBasic Create"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBasic Create"}).getMessage(),ex);
		}
    }
    
	/**
	 * Handling Retrieving Event<br>
	 * Retrieving detail pick-up Approval modifying information of hiring Container<br>
	 * 
	 * @param  String authNo
	 * @param  String tysz
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalNumber2Basic(String authNo , String tysz) throws EventException {
		try {
			return dbDao.searchOnhireApprovalNumber2Data(authNo , tysz);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber2 Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber2 Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Handling Modifying Event<br>
	 * Cancelling pick-up Approval modifying information of hiring Container<br>
	 * 
	 * @param String authNo
	 * @param String agmtCtyCd
	 * @param String agmtSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelOnhireApprovalNumberBasic(String authNo , String agmtCtyCd ,String agmtSeq , SignOnUserAccount account) throws EventException {
		try {
			int cntrAuthNoCnt = dbDao.searchCntrAuthNoCountData(authNo);
			
			if ( cntrAuthNoCnt > 0 ) {
				throw new EventException(new ErrorHandler("LSE01156").getMessage());
			}
			
			dbDao.modifyOnhireApprovalNumberData(authNo , agmtCtyCd , agmtSeq , account);
		} catch(EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBasic Cancel"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBasic Cancel"}).getMessage(),ex);
		}
	}
	
	/**
	 * save Event Handling<br>
	 * After Long/Short term Container hiring Contract, when there is change in detail pick-up Approval, Updating <br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @param  SignOnUserAccount account
	 * @param  OnhireApprovalVO[] onhireApprovalVOs
	 * @param  List<MdmCntrTpSzVO> cntrList
	 * @return String
	 * @exception EventException
	 */
	public String modifyOnhireApprovalNumberBasic( OnhireApprovalVO onhireApprovalVO , SignOnUserAccount account , OnhireApprovalVO[] onhireApprovalVOs, List<MdmCntrTpSzVO> cntrList) throws EventException {
       		
		try {
			
			String locCd         = onhireApprovalVO.getLocCd();
			String leaseTerm     = onhireApprovalVO.getLstmCd();
			String pkupFmDt      = onhireApprovalVO.getPkupFmDt();
			String pkupDueDt     = onhireApprovalVO.getPkupDueDt();
			String aproRmk       = onhireApprovalVO.getAproRmk();
			String tpszCd        = onhireApprovalVO.getTpszCd();
			String cntrOnhAuthNo = onhireApprovalVO.getCntrOnhAuthNo();
			
			dbDao.removeOnhireApprovalNumber2Data(cntrOnhAuthNo  );
			
			dbDao.removeOnhireApprovalNumberData(cntrOnhAuthNo );
			
            String mftYr         = "";
            String freeDys       = "";
            String pkupChgAmt    = "";
            String pkupChgCrAmt  = "";
            String minOnhDys     = "";
            String creUsrId      = account.getUsr_id();
            String cntrTpszCd    = "";
            String onhQtyOld     = "";
            String onhQtyNew     = "";
            String onhQtyLon     = "";
            String pkupChgQty    = "";
            String agmtCtyCd     = "";
            String agmtSeq       = "";
            String errTpsz       = "";
            String retrunLccCd      = "";
            
            String strQtyChk = "Y";
            String strFullAgmtSeq = "";
            for(int i = 0 ; i < onhireApprovalVOs.length ; i++){
            	
                agmtCtyCd     = onhireApprovalVOs[i].getAgmtCtyCd();
                agmtSeq       = onhireApprovalVOs[i].getAgmtSeq();
                mftYr         = onhireApprovalVOs[i].getMftYr();
                freeDys       = onhireApprovalVOs[i].getFreeDys();
                pkupChgAmt    = onhireApprovalVOs[i].getPkupChgAmt();
                pkupChgCrAmt  = onhireApprovalVOs[i].getPkupChgCrAmt();
                minOnhDys     = onhireApprovalVOs[i].getMinOnhDys();
                retrunLccCd            = onhireApprovalVOs[i].getReturnLcc();
                
                if(i == 0){
                	strFullAgmtSeq = agmtSeq;
                }else{
                	strFullAgmtSeq = strFullAgmtSeq+","+agmtSeq;
                }
                
                if(leaseTerm == null || "".equals(leaseTerm)) {
                	leaseTerm =  onhireApprovalVOs[i].getLstm();  
                }

                dbDao.addOnhireApprovalNumberData(cntrOnhAuthNo ,agmtCtyCd ,agmtSeq ,leaseTerm ,locCd ,pkupFmDt, pkupDueDt ,mftYr ,freeDys ,pkupChgAmt ,pkupChgCrAmt ,minOnhDys ,aproRmk ,creUsrId,retrunLccCd);
                
                String tpszs  = "";
                
                for( int tpi = 0 ; tpi < cntrList.size(); tpi++){
                	MdmCntrTpSzVO tpVo = cntrList.get(tpi);
                	tpVo.getCntrTpszCd();
                	if(tpi == 0){
                	    tpszs = tpszs +  tpVo.getCntrTpszCd();
                	}else{
                		tpszs = tpszs + "," + tpVo.getCntrTpszCd();
                	}
                }
                
                String[] arryTpszCd = tpszCd.split(",");
                
                for(int j=0; j<arryTpszCd.length; j++){

                    cntrTpszCd = arryTpszCd[j];
                    
                    if( cntrTpszCd != null && cntrTpszCd.equals("D2")){
	            		onhQtyOld = onhireApprovalVOs[i].getD2Old();
			            onhQtyNew = onhireApprovalVOs[i].getD2New();
			            onhQtyLon = onhireApprovalVOs[i].getD2Lon();
	            	}else if( cntrTpszCd != null && cntrTpszCd.equals("D4")){
	            		onhQtyOld = onhireApprovalVOs[i].getD4Old();
	            		onhQtyNew = onhireApprovalVOs[i].getD4New();
	            		onhQtyLon = onhireApprovalVOs[i].getD4Lon();
	            	}else if( cntrTpszCd != null && cntrTpszCd.equals("D5")){
	            		onhQtyOld = onhireApprovalVOs[i].getD5Old();
	            		onhQtyNew = onhireApprovalVOs[i].getD5New();
	            		onhQtyLon = onhireApprovalVOs[i].getD5Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D7")){
		            	onhQtyOld = onhireApprovalVOs[i].getD7Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD7New();
		            	onhQtyLon = onhireApprovalVOs[i].getD7Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R5")){
		            	onhQtyOld = onhireApprovalVOs[i].getR5Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR5New();
		            	onhQtyLon = onhireApprovalVOs[i].getR5Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("O2")){
		            	onhQtyOld = onhireApprovalVOs[i].getO2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getO2New();
		            	onhQtyLon = onhireApprovalVOs[i].getO2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("S2")){
		            	onhQtyOld = onhireApprovalVOs[i].getS2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getS2New();
		            	onhQtyLon = onhireApprovalVOs[i].getS2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("O4")){
		            	onhQtyOld = onhireApprovalVOs[i].getO4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getO4New();
		            	onhQtyLon = onhireApprovalVOs[i].getO4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("S4")){
		            	onhQtyOld = onhireApprovalVOs[i].getS4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getS4New();
		            	onhQtyLon = onhireApprovalVOs[i].getS4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("F2")){
		            	onhQtyOld = onhireApprovalVOs[i].getF2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getF2New();
		            	onhQtyLon = onhireApprovalVOs[i].getF2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("A2")){
		            	onhQtyOld = onhireApprovalVOs[i].getA2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getA2New();
		            	onhQtyLon = onhireApprovalVOs[i].getA2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("F4")){
		            	onhQtyOld = onhireApprovalVOs[i].getF4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getF4New();
		            	onhQtyLon = onhireApprovalVOs[i].getF4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("A4")){
		            	onhQtyOld = onhireApprovalVOs[i].getA4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getA4New();
		            	onhQtyLon = onhireApprovalVOs[i].getA4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("F5")){
		            	onhQtyOld = onhireApprovalVOs[i].getF5Old();
		            	onhQtyNew = onhireApprovalVOs[i].getF5New();
		            	onhQtyLon = onhireApprovalVOs[i].getF5Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R7")){
		            	onhQtyOld = onhireApprovalVOs[i].getR7Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR7New();
		            	onhQtyLon = onhireApprovalVOs[i].getR7Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("P2")){
		            	onhQtyOld = onhireApprovalVOs[i].getP2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getP2New();
		            	onhQtyLon = onhireApprovalVOs[i].getP2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("P4")){
		            	onhQtyOld = onhireApprovalVOs[i].getP4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getP4New();
		            	onhQtyLon = onhireApprovalVOs[i].getP4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("T2")){
		            	onhQtyOld = onhireApprovalVOs[i].getT2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getT2New();
		            	onhQtyLon = onhireApprovalVOs[i].getT2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("T4")){
		            	onhQtyOld = onhireApprovalVOs[i].getT4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getT4New();
		            	onhQtyLon = onhireApprovalVOs[i].getT4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R2")){
		            	onhQtyOld = onhireApprovalVOs[i].getR2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR2New();
		            	onhQtyLon = onhireApprovalVOs[i].getR2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("Q4")){
		            	onhQtyOld = onhireApprovalVOs[i].getQ4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getQ4New();
		            	onhQtyLon = onhireApprovalVOs[i].getQ4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("Q2")){
		            	onhQtyOld = onhireApprovalVOs[i].getQ2Old();
		            	onhQtyNew = onhireApprovalVOs[i].getQ2New();
		            	onhQtyLon = onhireApprovalVOs[i].getQ2Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D9")){
		            	onhQtyOld = onhireApprovalVOs[i].getD9Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD9New();
		            	onhQtyLon = onhireApprovalVOs[i].getD9Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D8")){
		            	onhQtyOld = onhireApprovalVOs[i].getD8Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD8New();
		            	onhQtyLon = onhireApprovalVOs[i].getD8Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("D3")){
		            	onhQtyOld = onhireApprovalVOs[i].getD3Old();
		            	onhQtyNew = onhireApprovalVOs[i].getD3New();
		            	onhQtyLon = onhireApprovalVOs[i].getD3Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("R4")){
		            	onhQtyOld = onhireApprovalVOs[i].getR4Old();
		            	onhQtyNew = onhireApprovalVOs[i].getR4New();
		            	onhQtyLon = onhireApprovalVOs[i].getR4Lon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("DX")){
		            	onhQtyOld = onhireApprovalVOs[i].getDxOld();
		            	onhQtyNew = onhireApprovalVOs[i].getDxNew();
		            	onhQtyLon = onhireApprovalVOs[i].getDxLon();
		            }else if( cntrTpszCd != null && cntrTpszCd.equals("DW")){
		            	onhQtyOld = onhireApprovalVOs[i].getDwOld();
		            	onhQtyNew = onhireApprovalVOs[i].getDwNew();
		            	onhQtyLon = onhireApprovalVOs[i].getDwLon();
		            }
                    
			        if(onhQtyOld == null || onhQtyOld.equals("")){
			        	onhQtyOld = "0";
			        }
			        if(onhQtyNew == null || onhQtyNew.equals("")){
			        	onhQtyNew = "0";
			        }
			        if(onhQtyLon == null || onhQtyLon.equals("")){
			        	onhQtyLon = "0.00";
			        }
			        
			        int iOld = Integer.parseInt(onhQtyOld);
			        int iNew = Integer.parseInt(onhQtyNew);
			        
			        if(tpszs.indexOf(cntrTpszCd) < 0 && (  iOld > 0  || iNew > 0 ) ){
	            		//if(errTpsz == ""){
			        	if("".equals(errTpsz)){
	            			errTpsz = cntrTpszCd ;
	            		}else{
	            			errTpsz = errTpsz + "," + cntrTpszCd ;
	            		}
	            	}else{

                        if(onhQtyOld != null && !onhQtyOld.equals("")){
                            dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "O" , pkupChgQty , onhQtyOld , onhQtyLon , creUsrId );
                        }
                        if(onhQtyNew != null && !onhQtyNew.equals("")){
                            dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "N" , pkupChgQty , onhQtyNew , onhQtyLon , creUsrId );
                        }
	            	}
                }
	            //if(errTpsz != ""){
                if(!"".equals(errTpsz)){
	            	throw new EventException(new ErrorHandler("LSE01141", new String[]{ "HHO" + agmtSeq , errTpsz  }).getMessage());
	            }
            }

            createOnhireApprovalNumberHistoryBasic(cntrOnhAuthNo, creUsrId);
            
            List<OnhireApprovalVO> data = dbDao.searchApprovalQtyChkData(strFullAgmtSeq);
            if(data.size() > 0) {
            	for(int i=0;i<data.size();i++) {
            		if(Integer.parseInt(data.get(i).getTotalOnhQty()) < Integer.parseInt(data.get(i).getOnhQty())) {
                    	strQtyChk = "N";
                    	break;
                    }
            	}
            }
            
            if("N".equals(strQtyChk)) {
            	throw new EventException(new ErrorHandler("LSE10008", new String[]{ "HHO" + agmtSeq , errTpsz  }).getMessage());
            }

            return cntrOnhAuthNo;
            
		} catch(EventException ex) {
			log.error(ex.getMessage());
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Modify"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Modify"}).getMessage(),ex);
		}
	}

	/**
	 * Handling Retrieving Event<br>
	 * Retrieving picked up Own Containers to give Auth No  <br>
	 * 
	 * @param  String loc_cd
	 * @param  String loc_tp
	 * @return List<OnhireApprovalOwnListVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalOwnListVO> searchApprovalOwnListBasic(String loc_cd ,String loc_tp) throws EventException {
		
		try {
			return dbDao.searchApprovalOwnListData(loc_cd , loc_tp);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ApprovalOwnList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ApprovalOwnList Search"}).getMessage(),ex);
		}
	}
	/**
	 * Handling Retrieving Event<br>
	 *  Handling Retrieving Own Equipment Sum Event for OnhireApproval Screen <br>
	 * 
	 * @param  String loc_cd
	 * @param  String loc_tp
	 * @return List<OnhireApprovalOwnListVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalOwnListVO> searchApprovalOwnSumListBasic(String loc_cd ,String loc_tp) throws EventException {
		
		try {
			return dbDao.searchApprovalOwnSumListData(loc_cd , loc_tp);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ApprovalOwnSumList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ApprovalOwnSumList Search"}).getMessage(),ex);
		}
	}
	/**
	 * Handling Retrieving Own Container pick-up Event<br>
	 * After Long/Short term Container hiring Contract, Retrieving pick-up amount about pick-up Approval<br>
	 * 
	 * @param  SearchApprovalVO searchApprovalVO
	 * @return List<SearchApprovalVO>
	 * @exception EventException
	 */
	public List<SearchApprovalVO> searchPickupStatusSummaryBasic(SearchApprovalVO searchApprovalVO) throws EventException {
		List<SearchApprovalVO> list = null;
		try {
			list =  dbDao.searchPickupStatusSummaryData(searchApprovalVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusSummary Search"}).getMessage(),ex);
		}
		
		return list;
	}
	
	/**
	 * Handling Retrieving Event<br>
	 * After Long/Short term Container hiring Contract, Retrieving pick-up amount about pick-up Approval in dettail<br>
	 * 
	 * @param  SearchApprovalDetailVO saearchApprovalDetailVO
	 * @return List<SearchApprovalDetailVO>
	 * @exception EventException
	 */
	public List<SearchApprovalDetailVO> searchPickupStatusDetailBasic(SearchApprovalDetailVO saearchApprovalDetailVO) throws EventException {
		
		try {
			return dbDao.searchPickupStatusDetailData(saearchApprovalDetailVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusDetail Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Handling Modifying and Retrieving Event<br>
	 * Handling Event retrieving Lift On Charge information of Equipment which is going to be Onhire<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalLiftOnChargeBasic(OnhireApprovalVO onhireApprovalVO) throws EventException {
		
		try {
			return dbDao.searchOnhireApprovalLiftOnChargeData(onhireApprovalVO);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}

	/**
	 * Generating Onhire Approval History<br>
	 * 
	 * @param  String cntrOnhAuthNo
	 * @exception EventException
	 */
	private void createOnhireApprovalNumberHistoryBasic(String cntrOnhAuthNo, String usrId) throws EventException {
		try {
			String onhAproSeq = dbDao.searchOnhireApprovalNumberHistorySeqData(cntrOnhAuthNo);
			dbDao.addOnhireApprovalNumberHistoryData(cntrOnhAuthNo, onhAproSeq, usrId);
			dbDao.addOnhireApprovalNumberQtyHistoryData(cntrOnhAuthNo, onhAproSeq, usrId);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusDetail Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusDetail Search"}).getMessage(),ex);
		}
	}
	
	/**
     *Checking AGMT TP/SZ
     * 
     * @param	OnhireApprovalVO onhireApprovalVO
     * @return	String 
	 * @exception EventException
	 */
    public String searchValidaionAgmtTpsz(OnhireApprovalVO onhireApprovalVO) throws EventException {
    	String cntrTpszCd = null;
    	
    	try {
			cntrTpszCd = dbDao.searchValidaionAgmtTpsz(onhireApprovalVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),ex);			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("", new String[]{""}).getMessage(),de);
		}
		
		return cntrTpszCd;
    }
}