/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthorizationAssignmentBCImpl.java
*@FileTitle : Authority Creation
*Open Issues :
*Change history :
*@LastModifyDate : 8
*@LastModifier :
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.integration.AuthorizationAssignmentDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author 
 * @see ESM_PRI_0009EventResponse,AuthorizationAssignmentBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class AuthorizationAssignmentBCImpl extends BasicCommandSupport implements AuthorizationAssignmentBC {

	// Database Access Object
	private transient AuthorizationAssignmentDBDAO dbDao = null;

	/**
	 * Creating AuthorizationAssignmentBCImpl object<br>
	 * Creating AuthorizationAssignmentDBDAO<br>
	 */
	public AuthorizationAssignmentBCImpl() {
		dbDao = new AuthorizationAssignmentDBDAO();
	}

	/**
	 * Retrieving S/C Authority information<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return List<RsltAuthorizationVO>
	 * @exception EventException
	 */
	public List<RsltAuthorizationVO> searchScAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException {
		try {
		    rsltAuthorizationVO.setPrcCtrtTpCd("S");
			return dbDao.searchAuthorizationAssignmentList(rsltAuthorizationVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

    /**
     * Retrieving RFA Authority information<br>
     * 
     * @param RsltAuthorizationVO rsltAuthorizationVO
     * @return List<RsltAuthorizationVO>
     * @exception EventException
     */
    public List<RsltAuthorizationVO> searchRfaAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException {
        try {
            rsltAuthorizationVO.setPrcCtrtTpCd("R");
            return dbDao.searchAuthorizationAssignmentList(rsltAuthorizationVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Saving Authority information<br>
	 * 
	 * @param RsltAuthorizationVO[] rsltAuthorizationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAuthorizationAssignment (RsltAuthorizationVO[] rsltAuthorizationVOs, SignOnUserAccount account)
            throws EventException {
        try {
            for (int i = 0; i < rsltAuthorizationVOs.length; i++) {
                if (rsltAuthorizationVOs[i].getIbflag().equals("U")) {
                	rsltAuthorizationVOs[i].setCreUsrId(account.getUsr_id());
                	rsltAuthorizationVOs[i].setUpdUsrId(account.getUsr_id());

                    if (rsltAuthorizationVOs[i].getAuthFlg().equals("Y")) {
                        if (dbDao.modifyScAuthorizationAssignment(rsltAuthorizationVOs[i]) <= 0) {
                            dbDao.addScAuthorizationAssignment(rsltAuthorizationVOs[i]);
                        }
                    } else {
                        dbDao.removeScAuthorizationAssignment(rsltAuthorizationVOs[i]);
                    }
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Retrieving combo list by organization user on Authority Creation screen<br>
	 * 
	 * @param ComUserVO comUserVO
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchComUserList (ComUserVO comUserVO) throws EventException {
		try {
			return dbDao.searchComUserList(comUserVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}


    /**
     * Retrieving RFA Authorization's organization map<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchRFAOfficeTreeList (OrganizationVO organizationVO) throws EventException {
        try {
        	List<OrganizationVO> treeList = new ArrayList<OrganizationVO> ();
        	Map<String,OrganizationVO> pathMap = new TreeMap<String,OrganizationVO>();
        	List<OrganizationVO> list = dbDao.searchRFAOfficeTreeList(organizationVO);
        	int size = list.size();
        	StringBuffer sb = new StringBuffer();
            //there is no row related to parent node because row with level which is related to approval office in query is selected.
        	for(int i = 0 ; i < size ; i++ ){
        		OrganizationVO vo = list.get(i);
        		String path = vo.getByPath();
        		String arrPath[] = path.split("\\|");
        		sb.setLength(0);
        		for(int x = 0 ; x < arrPath.length ; x++){
        			if( x != 0 )
        				sb.append("|");
        			sb.append(arrPath[x]);
        			if( pathMap.get( sb.toString() ) == null){
        				OrganizationVO newVo = new OrganizationVO();
        				newVo.setLvl(String.valueOf(x+1));
        				newVo.setOfcCd(arrPath[x] );
        				newVo.setPrntOfcCd(vo.getPrntOfcCd());
        				newVo.setOfcEngNm(arrPath[x]);
        				newVo.setByPath(sb.toString());
        				pathMap.put( sb.toString()  ,  newVo);
        			}
        		}
        	}
        	// Re-arranging completed nodes by order
        	Set<String> keySet = pathMap.keySet();
        	Iterator<String> itr = keySet.iterator();
        	while(itr.hasNext()){
        		String key = itr.next();
        		treeList.add(pathMap.get(key));
        	}
        	
        	
            return treeList;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving S/C Authorization's organization map<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchSCOfficeTreeList (OrganizationVO organizationVO) throws EventException {
        try {
        	List<OrganizationVO> treeList = new ArrayList<OrganizationVO> ();
        	Map<String,OrganizationVO> pathMap = new TreeMap<String,OrganizationVO>();
        	List<OrganizationVO> list = dbDao.searchSCOfficeTreeList(organizationVO);
        	int size = list.size();
        	StringBuffer sb = new StringBuffer();
        	//there is no row related to parent node because row with level which is related to approval office in query is selected.
        	for(int i = 0 ; i < size ; i++ ){
        		OrganizationVO vo = list.get(i);
        		String path = vo.getByPath();
        		String arrPath[] = path.split("\\|");
        		sb.setLength(0);
        		for(int x = 0 ; x < arrPath.length ; x++){
        			if( x != 0 )
        				sb.append("|");
        			sb.append(arrPath[x]);
        			if( pathMap.get( sb.toString() ) == null){
        				OrganizationVO newVo = new OrganizationVO();
        				newVo.setLvl(String.valueOf(x+1));
        				newVo.setOfcCd(arrPath[x] );
        				newVo.setPrntOfcCd(vo.getPrntOfcCd());
        				newVo.setOfcEngNm(arrPath[x]);
        				newVo.setByPath(sb.toString());
        				pathMap.put( sb.toString()  ,  newVo);
        			}
        		}
        	}
        	// Re-arranging completed nodes by order
        	Set<String> keySet = pathMap.keySet();
        	Iterator<String> itr = keySet.iterator();
        	while(itr.hasNext()){
        		String key = itr.next();
        		treeList.add(pathMap.get(key));
        	}        	
            return treeList;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }
}