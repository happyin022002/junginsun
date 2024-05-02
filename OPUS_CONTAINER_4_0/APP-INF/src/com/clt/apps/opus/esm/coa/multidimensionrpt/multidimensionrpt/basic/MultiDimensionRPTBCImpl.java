/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultiDimensionRPTBCImpl.java
*@FileTitle : Inquiry the report of the office Weekly atypical performance ananlysis
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.basic;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration.MultiDimensionRPTDBDAO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.MultiDimensionRptRtnVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.PnlRptItemVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.RepoPfmcConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.vo.SearchReportViewListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaRptAuthMgmtVO;

/**
 * OPUS-COA Business Logic Basic Command implementation<br>
 * 
 * 
 * @author
 * @see multiDimensionRPTBC reference the each DAO class 
 * @since J2EE 1.6
 */
public class MultiDimensionRPTBCImpl   extends BasicCommandSupport implements MultiDimensionRPTBC {

	// Database Access Object
	private transient MultiDimensionRPTDBDAO dbDao=null;

	/**
	 * MultiDimensionRPTBCImpl Object creation<br>
	 * MultiDimensionRPTDBDAO Creation<br>
	 */
	public MultiDimensionRPTBCImpl(){
		dbDao = new MultiDimensionRPTDBDAO();
	}
	
	/**
	 * 
	 * About the ESM_COA_0130, Handling the inquiry event<br>
	 * 
	 * @param SearchReportViewListVO searchReportViewListVO
	 * @return List<SearchReportViewListVO>
	 * @exception EventException
	 */
	public List<SearchReportViewListVO> searchReportViewList(SearchReportViewListVO searchReportViewListVO) throws EventException {
		try {
			return dbDao.searchReportViewList(searchReportViewListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * About the ESM_COA_0130, Handling the save event<br>
	 * 
	 * @param SearchReportViewListVO[] searchReportViewListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiReportView(SearchReportViewListVO[] searchReportViewListVO,SignOnUserAccount account) throws EventException{
		try {
			List<CoaRptAuthMgmtVO> updateVoList = new ArrayList<CoaRptAuthMgmtVO>();
			
			String usr_id = account.getUsr_id();
			
			for ( int i=0; i<searchReportViewListVO .length; i++ ) {
					if ( searchReportViewListVO[i].getIbflag().equals("U")){
					
					CoaRptAuthMgmtVO updateVoListVO = new CoaRptAuthMgmtVO();
					
					updateVoListVO.setPfitVwDfltCd((searchReportViewListVO[i].getPfitDflt().equals("P")) ? "Y" : "N");
					updateVoListVO.setPfitVwSlctFlg(searchReportViewListVO[i].getPfitCd1());
    		  updateVoListVO.setOfcVwDfltCd((searchReportViewListVO[i].getOfcDflt().equals("C")) ? "Y" : "N");
					updateVoListVO.setOfcVwSlctFlg(searchReportViewListVO[i].getOfcCd1());				
					updateVoListVO.setPfitLvlDfltCd((searchReportViewListVO[i].getLvlDflt().equals("C")) ? "Y" : "N");
					updateVoListVO.setPfitLvlSlctFlg(searchReportViewListVO[i].getLvlCd1());
					updateVoListVO.setUpdUsrId(usr_id);
					updateVoListVO.setRptSeq(searchReportViewListVO[i].getRptSeq());
					updateVoListVO.setOfcLvl(searchReportViewListVO[i].getOfcLvl());
					updateVoList.add(updateVoListVO);					
		
					CoaRptAuthMgmtVO updateVoListVO2 = new CoaRptAuthMgmtVO();
					updateVoListVO2.setPfitVwDfltCd((searchReportViewListVO[i].getPfitDflt().equals("R")) ? "Y" : "N");
					updateVoListVO2.setPfitVwSlctFlg(searchReportViewListVO[i].getPfitCd2());
					updateVoListVO2.setOfcVwDfltCd((searchReportViewListVO[i].getOfcDflt().equals("L")) ? "Y" : "N");
					updateVoListVO2.setOfcVwSlctFlg(searchReportViewListVO[i].getOfcCd2());				
					updateVoListVO2.setPfitLvlDfltCd((searchReportViewListVO[i].getLvlDflt().equals("O")) ? "Y" : "N");
					updateVoListVO2.setPfitLvlSlctFlg(searchReportViewListVO[i].getLvlCd2());
					updateVoListVO2.setUpdUsrId(usr_id);
					updateVoListVO2.setRptSeq(String.valueOf(Integer.parseInt(searchReportViewListVO[i].getRptSeq())+ 1));
					updateVoListVO2.setOfcLvl(searchReportViewListVO[i].getOfcLvl());
					updateVoList.add(updateVoListVO2);
					
				} 
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiReportView(updateVoList);
			}		
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * Header Handling the inquiry event<br>
	 * About the MultiDimensionRPT Header, Handling the inquiry event<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3HeaderList(RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // DB ResultSet
		List<MultiDimensionRptRtnVO> rtnList= new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo= new MultiDimensionRptRtnVO();
				
		String strDisplay = "O";
		
		try {			
			vo.setFProVw("P");
			vo.setFProLvl("O");
			vo.setFProObj("P");		
			
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
	        // P->O:performance, A:route, B:TS contribution
			if(vo.getFProObj().equals("P")){
				strDisplay = "O";
			}else{
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);
			
			rowSetArr[0] = dbDao.searchLaneRgstList(vo);
			rowSetArr[1] = dbDao.searchPfitLssRptItmList(vo);
						
			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);
			return rtnList;
		} catch (DAOException de) {
			 throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Handling the inquiry event<br>
	 * About the MultiDimensionRPT, Handling the inquiry event<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased1List(RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; // DB ResultSet
		List<MultiDimensionRptRtnVO> rtnList= new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo= new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj  = "";
		List<String> cols  = new ArrayList();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
	        // P->O:performance, A:route, B:TS contribution
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj  = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);
			
			if(fProObj.equals("P")){
				strDisplay = "O";
			}else{
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);
			
			// Header
			rowSetArr[0] = dbDao.searchLaneRgstList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("trd_cd"));
				} 
			}
			rowSetArr[0].beforeFirst();

			rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased1List(vo, cols);	
					
			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);
			
			return rtnList;
		} catch (DAOException de) {
			 throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Handling the inquiry event<br>
	 * About the MultiDimensionRPT, Handling the inquiry event<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased2List(RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; //  DB ResultSet
		List<MultiDimensionRptRtnVO> rtnList= new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo= new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj  = "";
		List<String> cols  = new ArrayList();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
	        // P->O:performance, A:route, B:TS contribution
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj  = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);
			
			if(fProObj.equals("P")){
				strDisplay = "O";
			}else{
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);
			
			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));					
				} 
			}
			rowSetArr[0].beforeFirst();
			rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased2List(vo, cols);
						
			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);
			
			return rtnList;
		} catch (DAOException de) {
			 throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * Handling the inquiry event<br>
	 * About the MultiDimensionRPT, Handling the inquiry event<br>
	 * 
	 * @param vo RepoPfmcConditionVO
	 * @return List<MultiDimensionRptRtnVO>
	 * @exception EventException
	 */
	public List<MultiDimensionRptRtnVO> searchWeeklySalesByOffice3TEUBased3List(RepoPfmcConditionVO vo) throws EventException {
		DBRowSet[] rowSetArr = new DBRowSet[2]; //  DB ResultSet
		List<MultiDimensionRptRtnVO> rtnList= new ArrayList<MultiDimensionRptRtnVO>();
		MultiDimensionRptRtnVO rtnVo= new MultiDimensionRptRtnVO();
		String strDisplay = "O";
		String fProVw = "";
		String fProLvl = "";
		String fProObj  = "";
		List<String> cols  = new ArrayList();

		try {
			// By Object
			// - P: Actual Operating Profit
			// - A: Trade Economical Profit
			// - B: Trade Grp Operating Profit
	        // P->O:performance, A:route, B:TS contribution
			fProVw = (vo.getFProVw() == null) ? "P" : vo.getFProVw();
			fProLvl = (vo.getFProLvl() == null) ? "O" : vo.getFProLvl();
			fProObj  = (vo.getFProObj() == null) ? "P" : vo.getFProObj();
			vo.setFProVw(fProVw);
			vo.setFProLvl(fProLvl);
			vo.setFProObj(fProObj);
			
			if(fProObj.equals("P")){
				strDisplay = "O";
			}else{
				strDisplay = vo.getFProObj();
			}
			vo.setStrDisplay(strDisplay);
			
			// Header
			rowSetArr[0] = dbDao.searchPfitLssRptItmList(vo);
			if (rowSetArr[0] != null) {
				while (rowSetArr[0].next()) {
					cols.add(rowSetArr[0].getString("stnd_cost_cd"));
				} 
			}
			rowSetArr[0].beforeFirst();			
			rowSetArr[1] = dbDao.searchWeeklySalesByOffice3TEUBased3List(vo, cols);
							
			rtnVo.setRowSets(rowSetArr);
			rtnList.add(rtnVo);
			
			return rtnList;
		} catch (DAOException de) {
			 throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}  
	
	/**
	 * P/L Report Item retrieve<br>
	 * 
	 * @return List<PnlRptItemVO>
	 * @exception EventException
	 */
	public List<PnlRptItemVO> searchPnlRptItem() throws EventException{
		try {
			return dbDao.searchPnlRptItem();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 *  P/L Report Item add/modify/remove<br>
	 * 
	 * @param  PnlRptItemVO[] pnlRptItemVOs
	 * @param  SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String multiPnlRptItem(PnlRptItemVO[] pnlRptItemVOs, SignOnUserAccount account) throws EventException{
		
		String result = "S";
		try {
			List<PnlRptItemVO> insertVoList = new ArrayList<PnlRptItemVO>();
			List<PnlRptItemVO> updateVoList = new ArrayList<PnlRptItemVO>();
			List<PnlRptItemVO> deleteVoList = new ArrayList<PnlRptItemVO>();

			for(int i=0; i<pnlRptItemVOs.length;i++){
			
				if(pnlRptItemVOs[i].getIbflag().equals("I")){
					int checkCnt = dbDao.checkPnlRptItem(pnlRptItemVOs[i]);
					if(checkCnt == 0){
						pnlRptItemVOs[i].setCreUsrId(account.getUsr_id());
						pnlRptItemVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(pnlRptItemVOs[i]);
						
						if(pnlRptItemVOs[i].getRptItmColrFlg().equals("1")){
							pnlRptItemVOs[i].setRptItmColrFlg("Y");
						}else if(pnlRptItemVOs[i].getRptItmColrFlg().equals("0")){
							pnlRptItemVOs[i].setRptItmColrFlg("N");
						}
					}else{
						result = "Dup";
					}
				}
				else if(pnlRptItemVOs[i].getIbflag().equals("U")){
					pnlRptItemVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(pnlRptItemVOs[i]);
					if(pnlRptItemVOs[i].getRptItmColrFlg().equals("1")){
						pnlRptItemVOs[i].setRptItmColrFlg("Y");
					}else if(pnlRptItemVOs[i].getRptItmColrFlg().equals("0")){
						pnlRptItemVOs[i].setRptItmColrFlg("N");
					}
				}
				else if(pnlRptItemVOs[i].getIbflag().equals("D")){
					deleteVoList.add(pnlRptItemVOs[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addPnlRptItem(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyPnlRptItem(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removePnlRptItem(deleteVoList);
			}

			return result;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
		
	
}



