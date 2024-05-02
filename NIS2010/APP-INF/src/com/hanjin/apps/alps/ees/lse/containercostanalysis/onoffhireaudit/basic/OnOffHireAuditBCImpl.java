/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IOnOffHireAuditBCImpl.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.19 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.integration.OnOffHireAuditDBDAO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditGroupVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-ContainerCostAnalysis Business Logic Basic Command implementation<br>
 * - NIS2010-ContainerCostAnalysis에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jin Jun Sung
 * @see ees_lse_0055EventResponse,IOnOffHireAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OnOffHireAuditBCImpl extends BasicCommandSupport implements OnOffHireAuditBC {

	// Database Access Object
	private transient OnOffHireAuditDBDAO dbDao = null;

	/**
	 * OnOffHireAuditBCImpl 객체 생성<br>
	 * OnOffHireAuditDBDAO를 생성한다.<br>
	 */
	public OnOffHireAuditBCImpl() {
		dbDao = new OnOffHireAuditDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 * 임차 장비에 대한 임차-반납 조회<br>
	 *
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return OnOffHireAuditGroupVO
	 * @exception EventException
	 */
	public OnOffHireAuditGroupVO searchAuditResultOnOffHirelistBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException {
		OnOffHireAuditGroupVO resultVO = new OnOffHireAuditGroupVO();
		try {
			List<List<OnOffHireAuditSearchVO>> listOnOffHireAuditSearchVOS = new ArrayList<List<OnOffHireAuditSearchVO>>();
			List<OnOffHireAuditSearchVO> rowSet0 = dbDao.searchAuditResultOnOffHirelistData(onOffHireAuditSearchVO , "" );
			List<OnOffHireAuditSearchVO> rowSet1 = dbDao.searchAuditResultOnOffHirelistData(onOffHireAuditSearchVO , "C");
			List<OnOffHireAuditSearchVO> rowSet2 = dbDao.searchAuditResultOnOffHirelistData(onOffHireAuditSearchVO , "D");
			List<OnOffHireAuditSearchVO> rowSet3 = dbDao.searchAuditResultOnOffHirelistData(onOffHireAuditSearchVO , "H");
			List<OnOffHireAuditSearchVO> rowSet4 = dbDao.searchAuditResultOnOffHirelistData(onOffHireAuditSearchVO , "L");
			listOnOffHireAuditSearchVOS.add(rowSet0);
			listOnOffHireAuditSearchVOS.add(rowSet1);
			listOnOffHireAuditSearchVOS.add(rowSet2);
			listOnOffHireAuditSearchVOS.add(rowSet3);
			listOnOffHireAuditSearchVOS.add(rowSet4);

			if ( listOnOffHireAuditSearchVOS.size() < 1 ) {
				new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			}

			resultVO.setOnOffHireAuditSearchVOs(listOnOffHireAuditSearchVOS);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AuditResultOnOffHirelist Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AuditResultOnOffHirelist Search"}).getMessage(),ex);
		}

		return resultVO;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * verify LSE_CTRT_NO 정합성 체크를 위한 조회<br>
	 *
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @exception EventException
	 */
	public List<OnOffHireAuditSearchVO> verifyImportOnOffHireListBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException {
		try {
			return dbDao.verifyImportOnOffHireListData ( onOffHireAuditSearchVO );
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"verifyImportOnOffHireList Search"}).getMessage(),ex);
		}
	}

	/**
	 * 저장 이벤트 처리<br>
	 * Invodce File Import 화면에 대한 저장 이벤트 처리<br>
	 *
	 * @param  OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createImportOnOffHireListBasic(OnOffHireAuditSearchVO[] onOffHireAuditSearchVOs, SignOnUserAccount account) throws EventException {
		int audSeq  = 1;
		String  audVerSeq  = "";

		try {
			if(onOffHireAuditSearchVOs.length > 0){

				audVerSeq = dbDao.addImportOnOffHireSequenceData(onOffHireAuditSearchVOs[0].getVndrSeq());

			    for(int i = 0 ; i < onOffHireAuditSearchVOs.length ; i++){
                    String onhDt = onOffHireAuditSearchVOs[i].getOnhDt();
                    if(onhDt != null && onhDt.length() == 8){
                    	onhDt = onhDt.substring(4) + onhDt.substring(2,4)  + onhDt.substring(0,2) ; //txt 파일에서 넘어올경우
                    	onOffHireAuditSearchVOs[i].setOnhDt(onhDt);
    				}else if(onhDt != null && onhDt.length() > 8){
    					onhDt = onhDt.replaceAll("-", "");                                          //xls 파일에서 넘어올경우
    					onOffHireAuditSearchVOs[i].setOnhDt(onhDt);
    			    }

                    String strOnhLocCd = onOffHireAuditSearchVOs[i].getOnhLocCd();
                    if(strOnhLocCd != null && strOnhLocCd.length() > 4){
                        onOffHireAuditSearchVOs[i].setOnhLocCd(strOnhLocCd.substring(0,5));
                    }

                    String offhDt = onOffHireAuditSearchVOs[i].getOffhDt();
    				if(offhDt != null && offhDt.length() == 8){
    					offhDt = offhDt.substring(4) + offhDt.substring(2,4)  + offhDt.substring(0,2) ;	//txt 파일에서 넘어올경우
    					onOffHireAuditSearchVOs[i].setOffhDt(offhDt);
    				}else if(offhDt != null && offhDt.length() > 8){
    					offhDt = offhDt.replaceAll("-", "");                                            //xls 파일에서 넘어올경우
    					onOffHireAuditSearchVOs[i].setOffhDt(offhDt);
    				}

    				String strOffhLocCd = onOffHireAuditSearchVOs[i].getOffhLocCd();
    				if(strOffhLocCd != null && strOffhLocCd.length() > 4){
    				    onOffHireAuditSearchVOs[i].setOffhLocCd(strOffhLocCd.substring(0,5));
    				}

    				String strLrOnhLocCd = onOffHireAuditSearchVOs[i].getLrOnhLocCd();
                    if(strLrOnhLocCd != null && strLrOnhLocCd.length() > 4){
                        onOffHireAuditSearchVOs[i].setLrOnhLocCd(strLrOnhLocCd.substring(0,5));
                    }

                    String strLrOffhLocCd = onOffHireAuditSearchVOs[i].getLrOffhLocCd();
                    if(strLrOffhLocCd != null && strLrOffhLocCd.length() > 4){
                        onOffHireAuditSearchVOs[i].setLrOffhLocCd(strLrOffhLocCd.substring(0,5));
                    }

                    String lrOnhDt = onOffHireAuditSearchVOs[i].getLrOnhDt();
                    if(lrOnhDt != null && lrOnhDt.length() > 8){
            		    lrOnhDt = lrOnhDt.replaceAll("-", "");
            		    onOffHireAuditSearchVOs[i].setLrOnhDt(lrOnhDt);
            		}

                    String lrOffhDt = onOffHireAuditSearchVOs[i].getLrOffhDt();
                    if(lrOffhDt != null && lrOffhDt.length() > 8){
                    	lrOffhDt = lrOffhDt.replaceAll("-", "");
            		    onOffHireAuditSearchVOs[i].setLrOffhDt(lrOffhDt);
            		}

    				if(onOffHireAuditSearchVOs[i].getLrOffhDt() == null || "".equals(onOffHireAuditSearchVOs[i].getLrOffhDt())){
    				    onOffHireAuditSearchVOs[i].setOnfHirStsCd("F");  //OFFH의 경우
    				}else{
    				    onOffHireAuditSearchVOs[i].setOnfHirStsCd("N");  //ONH의 경우
    				}

                    dbDao.addImportOnOffHireListData (onOffHireAuditSearchVOs[i] , audVerSeq , audSeq , account);
				    audSeq++;
			    }
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease ImportOnOffHireListBasic Create"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease ImportOnOffHireListBasic Create"}).getMessage(),ex);
		}
		return audVerSeq ;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * OnOffHireAudit화면에 대한 조회 이벤트 처리 <br>
	 * Audit 버전 리스트를 조회한다.
	 * @param  OnOffHireAuditSearchVO onOffHireAuditSearchVO
	 * @return List<OnOffHireAuditSearchVO>
	 * @exception EventException
	 */
	public List<OnOffHireAuditSearchVO> searchAuditResultOnOffHireVersionlistBasic(OnOffHireAuditSearchVO onOffHireAuditSearchVO) throws EventException {
		try {
			return dbDao.searchAuditResultOnOffHireVersionlistData (onOffHireAuditSearchVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AuditResultOnOffHireVersionlist Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AuditResultOnOffHireVersionlist Search"}).getMessage(),ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OnOffHireAudit화면에 대한 조회 이벤트 처리 <br>
	 * Lessor & HJS를 비교하여 Audit Result 리스트를 조회한다.
	 * @param  OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @return OnOffHireAuditGroupVO
	 * @exception EventException
	 */
	public OnOffHireAuditGroupVO searchAuditResultOnOffHireBasic(OnOffHireAuditDetailVO onOffHireAuditDetailVO) throws EventException {
		OnOffHireAuditGroupVO resultVO = new OnOffHireAuditGroupVO();
		try {
			 List<List<OnOffHireAuditDetailVO>> listOnOffHireAuditDetailVOS = new ArrayList<List<OnOffHireAuditDetailVO>>();
			 List<OnOffHireAuditDetailVO> rowSet0 = new ArrayList<OnOffHireAuditDetailVO>();
			 List<OnOffHireAuditDetailVO> rowSet1 = new ArrayList<OnOffHireAuditDetailVO>();
			 List<OnOffHireAuditDetailVO> rowSet2 = new ArrayList<OnOffHireAuditDetailVO>();
			 List<OnOffHireAuditDetailVO> rowSet3 = new ArrayList<OnOffHireAuditDetailVO>();
			 OnOffHireAuditDetailVO tempVO = new OnOffHireAuditDetailVO();

			 List<OnOffHireAuditDetailVO> list = dbDao.searchAuditResultOnOffHireData(onOffHireAuditDetailVO);

			 for(int i = 0 ; i < list.size() ; i++){
				 tempVO  = list.get(i);
				 if( tempVO.getLseAudTpCd() != null && "C".equals(tempVO.getLseAudTpCd())){
					 tempVO.setAuditType("C");
					 rowSet0.add(tempVO);
				 }else if( tempVO.getLseAudTpCd() != null && "D".equals(tempVO.getLseAudTpCd())){
					 rowSet1.add(tempVO);
				 }else if( tempVO.getLseAudTpCd() != null && "H".equals(tempVO.getLseAudTpCd())){
					 rowSet2.add(tempVO);
				 }else if( tempVO.getLseAudTpCd() != null && "L".equals(tempVO.getLseAudTpCd())){
					 rowSet3.add(tempVO);
				 }
			 }
			 listOnOffHireAuditDetailVOS.add(rowSet0);
			 listOnOffHireAuditDetailVOS.add(rowSet1);
			 listOnOffHireAuditDetailVOS.add(rowSet2);
			 listOnOffHireAuditDetailVOS.add(rowSet3);

			 if ( listOnOffHireAuditDetailVOS.size() < 1 ) {
                 new EventException(new ErrorHandler("LSE01041",new String[]{"User Information"}).getMessage());
			 }

			 resultVO.setOnOffHireAuditDetailVOs(listOnOffHireAuditDetailVOS);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AuditResultOnOffHirelist Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"AuditResultOnOffHirelist Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * 저장 이벤트 처리<br>
	 * Invodce File Import 화면에 대한 저장 이벤트 처리<br>
	 * @param  OnOffHireAuditDetailVO onOffHireAuditDetailVO
	 * @param  OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs
	 * @param  SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOnOffHireListBasic( OnOffHireAuditDetailVO onOffHireAuditDetailVO, OnOffHireAuditDetailVO[] onOffHireAuditDetailVOs , SignOnUserAccount account) throws EventException {
		int audSeq  = 1;
		String audVerSeq  = "";
		try {
			String strVndrSeq         = onOffHireAuditDetailVO.getVndrSeq();
			String strAudVerSeq       = onOffHireAuditDetailVO.getAudVerSeq();
			String strSearchStdt      = onOffHireAuditDetailVO.getBilFmDt();
			String srtSearchAuditType = onOffHireAuditDetailVO.getAuditType();

			if(strSearchStdt != null){
				strSearchStdt = strSearchStdt.replaceAll("-", "");
			}
			String strSearchEndt  = onOffHireAuditDetailVO.getBilToDt();
			if(strSearchEndt != null){
				strSearchEndt = strSearchEndt.replaceAll("-", "");
			}
			String strOffhDt      = "";
			String strLrOffhDt    = "";
			String strOnfHirStsCd = "";
			String strLseAudTpCd  = "";
			if( onOffHireAuditDetailVOs.length > 0){

				dbDao.removeOnOffHireListData( strVndrSeq ,  strAudVerSeq );
				if(strAudVerSeq == null || "".equals(strAudVerSeq)){
				     audVerSeq = dbDao.addImportOnOffHireSequenceData(onOffHireAuditDetailVOs[0].getVndrSeq());
				}else{
					 audVerSeq = strAudVerSeq;
				}
			    for(int i = 0 ; i < onOffHireAuditDetailVOs.length ; i++){

			    	strOffhDt   = onOffHireAuditDetailVOs[i].getOffhDt();
			    	if(strOffhDt == null){
			    		strOffhDt = "";
			    	}
			    	strLrOffhDt = onOffHireAuditDetailVOs[i].getLrOffhDt();
			    	if(strLrOffhDt == null){
			    		strLrOffhDt = "";
			    	}
			    	strOnfHirStsCd = onOffHireAuditDetailVOs[i].getOnfHirStsCd();
			    	if(strOnfHirStsCd == null){
			    		strOnfHirStsCd = "";
			    	}

			    	strLseAudTpCd = onOffHireAuditDetailVOs[i].getLseAudTpCd();
			    	if(strLseAudTpCd == null){
			    		strLseAudTpCd = "";
			    	}

			    	if("".equals(strOnfHirStsCd)){
			    		if("H".equals(strLseAudTpCd)){
			    		    if("".equals(strOffhDt)){
			    			    onOffHireAuditDetailVOs[i].setOnfHirStsCd("N");
			    		    }else{
			    			    onOffHireAuditDetailVOs[i].setOnfHirStsCd("F");
			    		    }
			    		}else{
			    			if("".equals(strOffhDt) && "".equals(strLrOffhDt)){
			    			    onOffHireAuditDetailVOs[i].setOnfHirStsCd("N");
			    		    }else{
			    			    onOffHireAuditDetailVOs[i].setOnfHirStsCd("F");
			    		    }
			    		}
			    	}

			    	onOffHireAuditDetailVOs[i].setBilFmDt(strSearchStdt);
			    	onOffHireAuditDetailVOs[i].setBilToDt(strSearchEndt);
			    	onOffHireAuditDetailVOs[i].setAuditType(srtSearchAuditType);

			    	dbDao.addOnOffHireListData(onOffHireAuditDetailVOs[i] , audVerSeq , audSeq , account);
				    audSeq++;
			    }
			}
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease OnOffHireList Create"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease OnOffHireList Create"}).getMessage(),ex);
		}
		return audVerSeq ;
	}
}