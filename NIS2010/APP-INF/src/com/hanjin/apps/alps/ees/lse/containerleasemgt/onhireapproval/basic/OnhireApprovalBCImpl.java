/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalBCImpl.java
*@FileTitle : On Hire Approval inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.04 진준성
* 1.0 Creation
* =======================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
* 2013.12.24 채창호 [CHM-201328112] ALPS Lease-On hire Approval Creation-Update-Inquiry화면에 column 추가 요청
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration.OnhireApprovalDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchRequestListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LseOnhAproVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
/**
 * NIS2010-ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * - NIS2010-ContainerLeaseMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jin Jun Sung
 * @see EES_LSE_0031EventResponse,OnhireApprovalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OnhireApprovalBCImpl extends BasicCommandSupport implements OnhireApprovalBC {

	// Database Access Object
	private transient OnhireApprovalDBDAO        dbDao = null;

	/**
	 * OnhireApprovalBCImpl 객체 생성<br>
	 * OnhireApprovalDBDAO를 생성한다.<br>
	 */
	public OnhireApprovalBCImpl() {
		dbDao     = new OnhireApprovalDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Onhire 될 장비의 Approval number 내용을 조회<br>
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
	 * Auth No 조회 이벤트 처리<br>
	 *  OnhireApproval화면에 대한  Auth No조회 이벤트 처리<br>
	 * 
	 * @param  String pOnhLocCd
	 * @param  String pLstmCd
	 * @param  String periodStdt
	 * @param  String periodEddt
	 * @return List<LseOnhAproVO>
	 * @exception EventException
	 */
    public List<LseOnhAproVO> searchOnhireApprovalNumberBrieflyBasic(String pOnhLocCd , String pLstmCd , String periodStdt , String periodEddt) throws EventException {
		
		try {
			return dbDao.searchOnhireApprovalNumberBrieflyData(pOnhLocCd , pLstmCd , periodStdt , periodEddt);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBriefly Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumberBriefly Search"}).getMessage(),ex);
		}
	}
	/**
	 * 저장 이벤트 처리<br>
	 * 임차 컨테이너(장기.단기,OF) 임차 계약 후, 상세한 pick-up 승인 저장<br>
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
			
			String locCd     = onhireApprovalVO.getLocCd();
			String leaseTerm = onhireApprovalVO.getLeaseTerm();
			String pkupDueDt = onhireApprovalVO.getPkupDueDt();
			String aproRmk   = onhireApprovalVO.getAproRmk();
			String tpszCd    = onhireApprovalVO.getTpszCd();
			String reqno     = onhireApprovalVO.getReqNo();
			String locCod    = onhireApprovalVO.getLocCod();
			String eccCd     = onhireApprovalVO.getEccCd();
			String errMsg    = "";
			
			String cntrOnhAuthNo = "";
			if(locCd.length() == 5){
			    cntrOnhAuthNo = locCd.substring(2) + leaseTerm;
			}
			
			cntrOnhAuthNo = dbDao.addOnhireApprovalAuthNoData(cntrOnhAuthNo , locCd , leaseTerm);
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
            String onhOrdYr      = "";
            //LSE_ONH_APRO 생성
            for(int i = 0 ; i < onhireApprovalVOs.length ; i++){
            	
				//LSE_ONH_APRO_QTY 생성
	            agmtCtyCd     = onhireApprovalVOs[i].getAgmtCtyCd();
	            agmtSeq       = onhireApprovalVOs[i].getAgmtSeq();
	            mftYr         = onhireApprovalVOs[i].getMftYr();
	            freeDys       = onhireApprovalVOs[i].getFreeDys();
	            pkupChgAmt    = onhireApprovalVOs[i].getPkupChgAmt();
	            pkupChgCrAmt  = onhireApprovalVOs[i].getPkupChgCrAmt();
	            minOnhDys     = onhireApprovalVOs[i].getMinOnhDys();
	            onhOrdYr      = onhireApprovalVOs[i].getOnhOrdYr();
	            locCod        = onhireApprovalVOs[i].getLocCod();
	            eccCd         = onhireApprovalVOs[i].getEccCd();
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
                
				dbDao.addOnhireApprovalNumberData(cntrOnhAuthNo ,agmtCtyCd ,agmtSeq ,leaseTerm ,locCd ,pkupDueDt ,mftYr ,freeDys ,pkupChgAmt ,pkupChgCrAmt ,minOnhDys ,aproRmk ,creUsrId ,reqno ,onhOrdYr, locCod, eccCd);
				
	            //LSE_ONH_APRO_QTY 생성
	            String[] arryTpszCd = tpszCd.split(",");
	            String[] arrOld =null;
                String[] arrLon =null;
                String[] arrNew =null;
                
	            for(int j=0; j<arryTpszCd.length; j++){
	            
	            	cntrTpszCd = arryTpszCd[j];
	            	arrOld =onhireApprovalVOs[i].getArrOld().split("[|]");
                    arrLon =onhireApprovalVOs[i].getArrLon().split("[|]");
                    arrNew =onhireApprovalVOs[i].getArrNew().split("[|]");
                    
                    onhQtyOld = arrOld[j];
		            onhQtyNew = arrNew[j];
		            onhQtyLon = arrLon[j];
	            		            	
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
	            		if(errTpsz.equals("")){
	            			errTpsz = cntrTpszCd ;
	            		}else{
	            			errTpsz = errTpsz + "," + cntrTpszCd ;
	            		}
	            	}else{
	            		dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "O" , pkupChgQty , onhQtyOld , onhQtyLon, creUsrId, locCod, eccCd );
		            	dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "N" , pkupChgQty , onhQtyNew , onhQtyLon, creUsrId, locCod, eccCd );
	            	}
	            }
	            
	            if(!errTpsz.equals("")){
	            	throw new EventException(new ErrorHandler("LSE01141", new String[]{ "HHO" + agmtSeq , errTpsz  }).getMessage());
	            }
	           
	     	}
            // OW,LT,ST Term 인경우에는 무조건  EQR_REQLIST의 수향과 비교한다.
            if (leaseTerm.equals("OW") || leaseTerm.equals("LT") || leaseTerm.equals("ST")){
                errMsg = dbDao.searchEqrReqListValidation(reqno ,tpszCd );
                if(!errMsg.equals("SU")){
	            	throw new EventException(new ErrorHandler("LSE10005", new String[]{"TPSZ Total Qty different"}).getMessage());
	            }
        	}
            createOnhireApprovalNumberHistoryBasic(cntrOnhAuthNo, creUsrId);

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
	 * 조회 이벤트 처리<br>
	 * 임차 컨테이너 상세한 pick-up 승인 수정내용을 조회한다.<br>
	 * 
	 * @param  String authNo
	 * @param  String tysz
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalNumber2Basic(String authNo , String tysz) throws EventException {
		String reqNo = "";
		String totalqty ="";
		//String titletpsz ="";
		String[] result = new String[2];
		try {
			//titletpsz = dbDao.searchReqListTietleCode(authNo);
			result = dbDao.searchEqrReqListReqNoData(authNo , tysz);
			reqNo = result[0];
			totalqty = result[1];
			return dbDao.searchOnhireApprovalNumber2Data(authNo , tysz ,reqNo , totalqty);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber2 Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber2 Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * 임차 컨테이너 상세한 pick-up 승인에 대한 취소처리<br>
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
	 * save 이벤트 처리<br>
	 * 장/단기 컨테이너 임차 계약 후, 상세한 pick-up 승인에 대하여 변경 상황 발생시 up-date <br>
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
			String pkupDueDt     = onhireApprovalVO.getPkupDueDt();
			String aproRmk       = onhireApprovalVO.getAproRmk();
			String tpszCd        = onhireApprovalVO.getTpszCd();
			String cntrOnhAuthNo = onhireApprovalVO.getCntrOnhAuthNo();
			String reqno         = onhireApprovalVO.getReqNo();
			String locCod        = onhireApprovalVO.getLocCod();
			String eccCd         = onhireApprovalVO.getEccCd();
//			String errMsg        = "";
			
			//1. LSE_ONH_APRO_QTY 삭제 key : authNo ,  AgmtCtyCd , agmtSeq
			dbDao.removeOnhireApprovalNumber2Data(cntrOnhAuthNo  );
			
			//2. LSE_ONH_APRO 삭제 key : authNo ,  AgmtCtyCd , agmtSeq
			dbDao.removeOnhireApprovalNumberData(cntrOnhAuthNo );
			
			//3. LSE_ONH_APRO , SET LSE_ONH_APRO 생성
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
            String onhOrdYr      = "";
            //LSE_ONH_APRO 생성
            for(int i = 0 ; i < onhireApprovalVOs.length ; i++){
            	
                //LSE_ONH_APRO_QTY 생성
                agmtCtyCd     = onhireApprovalVOs[i].getAgmtCtyCd();
                agmtSeq       = onhireApprovalVOs[i].getAgmtSeq();
                mftYr         = onhireApprovalVOs[i].getMftYr();
                freeDys       = onhireApprovalVOs[i].getFreeDys();
                pkupChgAmt    = onhireApprovalVOs[i].getPkupChgAmt();
                pkupChgCrAmt  = onhireApprovalVOs[i].getPkupChgCrAmt();
                minOnhDys     = onhireApprovalVOs[i].getMinOnhDys();
                onhOrdYr      = onhireApprovalVOs[i].getOnhOrdYr(); 
	            locCod        = onhireApprovalVOs[i].getLocCod();
	            eccCd         = onhireApprovalVOs[i].getEccCd();
                dbDao.addOnhireApprovalNumberData(cntrOnhAuthNo ,agmtCtyCd ,agmtSeq ,leaseTerm ,locCd ,pkupDueDt ,mftYr ,freeDys ,pkupChgAmt ,pkupChgCrAmt ,minOnhDys ,aproRmk ,creUsrId ,reqno ,onhOrdYr, locCod, eccCd);
                
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
                
                //LSE_ONH_APRO_QTY 생성
                String[] arryTpszCd = tpszCd.split(",");
                String[] arrOld =null;
                String[] arrLon =null;
                String[] arrNew =null;
                
                for(int j=0; j<arryTpszCd.length; j++){

                    cntrTpszCd = arryTpszCd[j];
                    arrOld =onhireApprovalVOs[i].getArrOld().split("[|]");
                    arrLon =onhireApprovalVOs[i].getArrLon().split("[|]");
                    arrNew =onhireApprovalVOs[i].getArrNew().split("[|]");
                    
                    onhQtyOld = arrOld[j];
		            onhQtyNew = arrNew[j];
		            onhQtyLon = arrLon[j];
                    
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
	            		if(errTpsz.equals("")){
	            			errTpsz = cntrTpszCd ;
	            		}else{
	            			errTpsz = errTpsz + "," + cntrTpszCd ;
	            		}
	            	}else{

                        if(onhQtyOld != null && !onhQtyOld.equals("")){
                            dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "O" , pkupChgQty , onhQtyOld , onhQtyLon , creUsrId, locCod, eccCd );
                        }
                        if(onhQtyNew != null && !onhQtyNew.equals("")){
                            dbDao.addOnhireApprovalNumberQtyData(cntrOnhAuthNo  , agmtCtyCd , agmtSeq , cntrTpszCd , "N" , pkupChgQty , onhQtyNew , onhQtyLon , creUsrId, locCod, eccCd );
                        }
	            	}
                }
	            if(!errTpsz.equals("")){
	            	throw new EventException(new ErrorHandler("LSE01141", new String[]{ "HHO" + agmtSeq , errTpsz  }).getMessage());
	            }
            }
//            // OW,LT,ST Term 인경우에는 무조건  EQR_REQLIST의 수량과 비교한다.
//            if (leaseTerm.equals("OW") || leaseTerm.equals("LT") || leaseTerm.equals("ST")){
//            	if (!reqno.equals("")){
//            		errMsg = dbDao.searchEqrReqListValidation(reqno ,tpszCd );
//            		if(!errMsg.equals("SU")){
//            			throw new EventException(new ErrorHandler("LSE10005", new String[]{"TP/SZ Total Qty different"}).getMessage());
//            		}
//            	}
//        	}
            createOnhireApprovalNumberHistoryBasic(cntrOnhAuthNo, creUsrId);

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
	 * 조회 이벤트 처리<br>
	 * 자가컨테이너 pick up 한 장비를 auth no를 부여하기위하여 내용을 조회 <br>
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
	 * 조회 이벤트 처리<br>
	 *  OnhireApproval화면에 대한 자가장비 Sum 조회 이벤트 처리 <br>
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
	 * 자가컨테이너 pick up 장비 조회 이벤트 처리<br>
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 조회<br>
	 * 
	 * @param  SearchApprovalVO searchApprovalVO
	 * @return SearchApprovalVO
	 * @exception EventException
	 */
	public SearchApprovalVO searchPickupStatusSummaryBasic(SearchApprovalVO searchApprovalVO) throws EventException {
		SearchApprovalVO rsVo = new SearchApprovalVO();
		try {
			rsVo =  dbDao.searchPickupStatusSummaryData(searchApprovalVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusSummary Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"PickupStatusSummary Search"}).getMessage(),ex);
		}
		
		return rsVo;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 상세조회<br>
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
	 * 수정조회 이벤트 처리<br>
	 * Onhire 될 장비의 Lift On Charge  내용을 조회하는 이벤트 처리<br>
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
	 * Onhire Approval History 생성<br>
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
	 * 조회 이벤트 처리<br>
	 * Req List 화면의 타이틀 만들기 위한 내용을 조회하는 이벤트 처리<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String  searchReqListTietleCodeService() throws EventException {
		
		try {
			return dbDao.searchReqListTietleCode();
			
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"OnhireApprovalNumber Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQR의 Req List 수량을 상세조회<br>
	 * 
	 * @param  SearchRequestListVO searchRequestListVO
	 * @return List<SearchRequestListVO>
	 * @exception EventException
	 */
	public List<SearchRequestListVO> searchEqrReqListService(SearchRequestListVO searchRequestListVO) throws EventException {
		 String result ="";
		
		try {
			result = dbDao.searchReqListTietleCode();
			searchRequestListVO.setTitlelist(result);
			return dbDao.searchEqrReqListDetailData(searchRequestListVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Req List Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Req List Search"}).getMessage(),ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DOL List를 조회<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalDolListBasic(OnhireApprovalVO onhireApprovalVO) throws EventException {
		
		try {
			return dbDao.searchDolListData(onhireApprovalVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"DOL List Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"DOL List Search"}).getMessage(),ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ECC List를 조회<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalEccListBasic(OnhireApprovalVO onhireApprovalVO) throws EventException {
		
		try {
			
			return dbDao.searchEccListData(onhireApprovalVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ECC List Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ECC List Search"}).getMessage(),ex);
		}
	}


}