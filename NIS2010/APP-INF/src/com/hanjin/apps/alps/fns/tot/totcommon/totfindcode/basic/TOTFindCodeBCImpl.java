/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TOTFindCodeBCImpl.java
*@FileTitle : TOTCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.25 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.basic;

import java.util.Collection;
import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration.TOTFindCodeDBDAO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.CustomVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.MdmLaneVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeInfoVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.framework.support.db.RowSetUtil;

/**
 * ALPS-TOTCommon Business Logic Basic Command implementation<br>
 * - ALPS-TOTCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Chang Soo
 * @see TOTCommonEventResponse,TOTFindCodeBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TOTFindCodeBCImpl extends BasicCommandSupport implements TOTFindCodeBC {

	// Database Access Object
	private transient TOTFindCodeDBDAO dbDao = null;

	/**
	 * TOTFindCodeBCImpl 객체 생성<br>
	 * TOTFindCodeDBDAO를 생성한다.<br>
	 */
	public TOTFindCodeBCImpl() {
		dbDao = new TOTFindCodeDBDAO();
	}

	/**
	 * 해당 선박코드의 vessel name 과 계약일자 데이터를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */	
	public List<VslVO> searchFmsVslInfo(VslVO vslVO) throws EventException {
		try {
			log.debug("::CALL::> FNS_TOT_0001 SC 계약시작 종료일자 조회DAO전> :::::::::");
			return dbDao.searchFmsVslInfo(vslVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"Fms Vessel Info Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"Fms Vessel Info Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * 해당년월의 마감여부를 조회한다 <br>
	 * 
	 * @param String isYear
	 * @return List<TotStlClzVO>
	 * @exception EventException
	 */	
	public List<TotStlClzVO> checkSettlementClosing(String isYear) throws EventException {
		try {
			return dbDao.searchStlClosing(isYear);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"Settlement Closing Search"}).getUserMessage(),ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"Settlement Closing Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * lane에 해당하는 trade code를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 	
	public List<TotCodeInfoVO> searchTrdCodeByLaneList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchTrdCodeByLaneList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}
    */
	
	/**
	 * 해당하는 trade code를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchTradeCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchTradeCodeList(totCodeParamVO);
		}  catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * 해당 lane 존재여부를 체크한다. <br>
	 * 
	 * @param MdmLaneVO mdmLaneVO
	 * @return List<MdmLaneVO>
	 * @exception EventException
	 */	
	public List<MdmLaneVO> searchLaneCheckList(MdmLaneVO mdmLaneVO) throws EventException {
		try {
			return dbDao.searchLaneCheckList(mdmLaneVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}	

	/**
	 * pendlum lane을 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchPLaneCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchPLaneCodeList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * pendlum lane에 해당하는 trade를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchPLaneTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchPLaneTrdCodeList(totCodeParamVO);
		}  catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * pendlum lane에 해당하는 trade를 조회한다. 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @throws EventException
	 */
	public List<TotCodeInfoVO>  searchPLaneDistinctTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchPLaneDistinctTrdCodeList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * BSA lane을 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchBsaLaneCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchBsaLaneCodeList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * BSA lane에 해당하는 trade를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchBsaTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchBsaTrdCodeList(totCodeParamVO);
		}  catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * 해당 시작일자 종료일자 lane, dir_cd 에 해당하는 port조회한다. <br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchPortCodeList(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		try {
			return dbDao.searchPortCodeList(vskVslPortSkdVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	
	/**
	 * BSA Trade code 조회한다.
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @throws EventException
	 */
	public List<TotCodeInfoVO> searchBSATradeCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchBSATradeCodeList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * tot lane을 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchTotLaneCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchTotLaneCodeList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * tot lane에 해당하는 trade 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchTotLaneTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchTotLaneTrdCodeList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * tot lane에 해당하는 trade 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchTotLaneDistinctTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchTotLaneDistinctTrdCodeList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * trade에 해당하는 lane을 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchTotLaneByTrdList(TotCodeParamVO totCodeParamVO) throws EventException {
		try {
			return dbDao.searchTotLaneByTrdList(totCodeParamVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * 공통코드를 가지고 있는 데이터에 한해 해당코드를 넘겨주면 해당코드의 리스트를 조회한다.. <br>
	 * 
	 * @param String code
	 * @return CustomVO
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	public CustomVO searchComboCodeList(String code) throws EventException{
		log.debug("::CALL::>searchComboCodeList BC >진입 :::::::::");
				CustomVO vo = new CustomVO();
				try{
				CodeUtil codeUtil = CodeUtil.getInstance();
				Collection<CodeInfo> codelist1 = codeUtil.getCodeSelect(code, 0);
				vo.setCodelist1(codelist1);
			
				vo.setUsrMsg(new ErrorHandler("CGM00001").getUserMessage());
			}catch (Exception ex) {
				throw new EventException(ex.getMessage(), ex);
			}
			
			return vo;

	}
	
	/**
	 * BSA Creation back end job return 데이터를 조회한다. <br>
	 * 
	 * @param String backEndJobKey
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCreationByBackEndJobStatus(String backEndJobKey) throws EventException {
		try {
			// Backend job이 완료되었는지 검사한다.
	    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);
	    	
	    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
	    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
	    	log.debug(":::::>>> dbRowSetlist : "+dbRowSetlist);

	    	ComBakEndJbVO jobVo = null;
	    	String[] res = new String[3];		
	    	
	    	if (dbRowSetlist.size() == 0) {
	    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
	    		jobVo = new ComBakEndJbVO();
	    		jobVo.setJbStsFlg("0");
	    	} else {
	    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
	    	}
	    	log.debug(":::::>>><<<<<< status : "+jobVo.getJbStsFlg());
	    	res[0] = jobVo.getJbStsFlg();
	    	
	    	if(res[0].equals("3")){
	    		//BackEndJobResult backEndJobResult = new BackEndJobResult();
	    		res[1] = (String)BackEndJobResult.loadFromFile(backEndJobKey);
	    	}			
			 
			return res;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getUserMessage(),ex);
		}
	}	
}