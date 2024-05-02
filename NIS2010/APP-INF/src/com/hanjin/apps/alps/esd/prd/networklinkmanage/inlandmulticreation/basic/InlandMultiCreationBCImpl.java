/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : InlandRouteManageBCImpl.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-02-10
 *@LastModifier : noh seung bae
 *@LastVersion : 1.0
 * 2010-02-10 noh seung bae
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.basic;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.integration.InlandMultiCreationDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.vo.SearchInlandRouteVO;
import java.util.List;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_005EventResponse,InlandRouteManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class InlandMultiCreationBCImpl extends BasicCommandSupport implements InlandMultiCreationBC{

	// Database Access Object
	private transient InlandMultiCreationDBDAO dbDao = null;

	/**
	 * InlandRouteManageBCImpl 객체 생성<br>
	 * InlandRouteManageDBDAO를 생성한다.<br>
	 */
	public InlandMultiCreationBCImpl(){
		dbDao = new InlandMultiCreationDBDAO();
	}

	/**
	 *
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List searchInlandMultiList(SearchInlandRouteVO vo) throws EventException{
		try{
			return dbDao.searchInlandMultiList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 *
	 * @param vo
	 * @return
	 * @throws EventException
	 * @throws DAOException
	 */
	public String multiInlandMulti(SearchInlandRouteVO vo) throws EventException, DAOException{
		String result = "";
		try{
			String ibFlag = vo.getIbflag();
			if("I".equals(ibFlag)){
				String routeSeq = dbDao.searchRouteSeq();
				vo.setRoutSeq(routeSeq);
				result =result + dbDao.insertRouteMaster(vo.getRoutOrgNodCd(), vo.getRoutDestNodCd(), vo.getRoutSeq(), vo.getPrioSeq(), vo.getInlndRoutInvBilPattCd()
						, vo.getRoutPlnCd(), vo.getWrsFullCmdt(), vo.getWrsMtyCmdtCd(), vo.getInlndRoutBkgFlg(), vo.getPctlIoBndCd()
						, vo.getInlndRoutTmpFlg(), vo.getInlndRoutRmk1(), vo.getHubLocCd(), vo.getCreUsrId());
				if(!"".equals(vo.getN2ndNode())){
					result =result + dbDao.insertEachLink(vo.getN1stNode(), vo.getN2ndNode(), vo.getTm1(), vo.getVndr1(), vo.getFmtTztmHrs1()
							, vo.getInlndRoutRmk1(), vo.getCreUsrId());
					result =result + dbDao.insertRouteDetail(vo.getRoutOrgNodCd(), vo.getRoutDestNodCd(), vo.getRoutSeq() , vo.getN1stNode(), vo.getN2ndNode()
							, "1", vo.getTm1(), vo.getVndr1(), vo.getComFlg1(), vo.getJuncNm1()
							, vo.getRdCrrTp1(), vo.getAgmtNo1(), vo.getCreUsrId());
				}
				if(!"".equals(vo.getN3rdNode())){
					result =result + dbDao.insertEachLink(vo.getN2ndNode(), vo.getN3rdNode(), vo.getTm2(), vo.getVndr2(), vo.getFmtTztmHrs2()
							, vo.getInlndRoutRmk2(), vo.getCreUsrId());
					result =result + dbDao.insertRouteDetail(vo.getRoutOrgNodCd(), vo.getRoutDestNodCd(), vo.getRoutSeq() , vo.getN2ndNode(), vo.getN3rdNode()
							, "2", vo.getTm2(), vo.getVndr2(), vo.getComFlg2(), vo.getJuncNm2()
							, vo.getRdCrrTp2(), vo.getAgmtNo2(), vo.getCreUsrId());
				}
				if(!"".equals(vo.getN4thNode())){
					result =result + dbDao.insertEachLink(vo.getN3rdNode(), vo.getN4thNode(), vo.getTm3(), vo.getVndr3(), vo.getFmtTztmHrs3()
							, vo.getInlndRoutRmk3(), vo.getCreUsrId());
					result =result + dbDao.insertRouteDetail(vo.getRoutOrgNodCd(), vo.getRoutDestNodCd(), vo.getRoutSeq() , vo.getN3rdNode(), vo.getN4thNode()
							, "3", vo.getTm3(), vo.getVndr3(), vo.getComFlg3(), vo.getJuncNm3()
							, vo.getRdCrrTp3(), vo.getAgmtNo3(), vo.getCreUsrId());
				}
				if(!"".equals(vo.getN5thNode())){
					result =result + dbDao.insertEachLink(vo.getN4thNode(), vo.getN5thNode(), vo.getTm4(), vo.getVndr4(), vo.getFmtTztmHrs4()
							, vo.getInlndRoutRmk4(), vo.getCreUsrId());
					result =result + dbDao.insertRouteDetail(vo.getRoutOrgNodCd(), vo.getRoutDestNodCd(), vo.getRoutSeq() , vo.getN4thNode(), vo.getN5thNode()
							, "4", vo.getTm4(), vo.getVndr4(), vo.getComFlg4(), vo.getJuncNm4()
							, vo.getRdCrrTp4(), vo.getAgmtNo4(), vo.getCreUsrId());
				}
				if(!"".equals(vo.getN6thNode())){
					result =result + dbDao.insertEachLink(vo.getN5thNode(), vo.getN6thNode(), vo.getTm5(), vo.getVndr5(), vo.getFmtTztmHrs5()
							, vo.getInlndRoutRmk5(), vo.getCreUsrId());
					result =result + dbDao.insertRouteDetail(vo.getRoutOrgNodCd(), vo.getRoutDestNodCd(), vo.getRoutSeq() , vo.getN5thNode(), vo.getN5thNode()
							, "5", vo.getTm5(), vo.getVndr5(), vo.getComFlg5(), vo.getJuncNm5()
							, vo.getRdCrrTp5(), vo.getAgmtNo5(), vo.getCreUsrId());
				}
			}else if("U".equals(ibFlag)){
				throw new UnsupportedOperationException((new ErrorHandler("PRD00038")).getMessage());
			}else if( "D".equals(ibFlag)){
				 int updateCount = dbDao.updateInlandMulti(vo.getRoutOrgNodCd(), vo.getRoutDestNodCd(), vo.getRoutSeq());
				 if(updateCount < 1){
					 throw new DAOException((new ErrorHandler("PRD00039")).getMessage());
				 }
			}

			// master, eachlink, detail  중 하나라도 insert 가 안됐을 경우 즉, insert 리턴값이 0이 있을 경우
			if(result.contains("0")){
				String msg = "";
				msg = msg + (result.charAt(0) == '0' ? "master 에러는 없지만 입력은 실패 " : "master 성공" );
				msg = msg + (result.charAt(1) == '0' ? ", eachLink 에러는 없지만 입력은 실패 " : ", eachLink 성공") ;
				msg = msg + (result.charAt(2) == '0' ? ", detail 에러는 없지만 입력은 실패 " : ", detail 성공") ;
				result = msg;
			}
		}catch(DAOException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * InlandRouteManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
