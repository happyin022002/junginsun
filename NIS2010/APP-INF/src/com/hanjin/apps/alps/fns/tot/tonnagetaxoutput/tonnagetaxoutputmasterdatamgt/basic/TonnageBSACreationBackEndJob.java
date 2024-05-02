/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TonnageBSACreationBackEndJob.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
 * 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration.TonnageTaxOutputMasterDataMgtDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.syscommon.common.table.TotBsaVO;

/**
 * FNS_TOT_0009 화면에 관련한 BACKEND에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jang chang su
 * @see UI_GEM_0019EventResponse,TonnageTaxOutputMasterDataMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class TonnageBSACreationBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private TonnageTaxOutputMasterDataMgtDBDAO dbDao;

	/**
     * TonnageTaxOutputMasterDataMgtBCImpl 객체 생성<br>
     * TonnageTaxOutputMasterDataMgtDBDAO 생성한다.<br>
     */
    public TonnageBSACreationBackEndJob() {
		dbDao = new TonnageTaxOutputMasterDataMgtDBDAO();

    }

	private TotBsaVO totBsaVO;
    private String usrId;
    
	public void setTotBsaVO(TotBsaVO totBsaVO) {
		this.totBsaVO = totBsaVO;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}


	/**
	 * BSA 정보를 생성한다. <br>
	 * @return String
	 * @exception EventException
	 */
	public String doStart() throws Exception {
			
			try {
				
				log.debug("::CALL::> doStart >진입 :::::::::");
				List<TotBsaVO> list = null;
			    String res = null;
				//totBsaVO.setCreUsrId(signOnUserAccount.getUsr_id());
				list = dbDao.searchIFBSAByVVD(totBsaVO);
                if(list.size()==0){
                	res = "nodata";
                	
                }else{
                	res = "existdata";
                }
				List<TotBsaVO> insertVoList = new ArrayList<TotBsaVO>();
				
				log.debug("::CALL::> FNS_TOT_0006 I/F DAQ > search 진입::::::::: list.size() : "+list.size());
				for(int i=0; i<list.size(); i++){
					log.debug("i ::::::::::::::::::::::::::::::::::: "+i);
					list.get(i).setCreUsrId(usrId);
					log.debug("list.get(i).getVslCd() : "+list.get(i).getVslCd());
					insertVoList.add(list.get(i));					
				}

				if ( insertVoList.size() > 0 ) {
					
					dbDao.addBSAByVVDs(insertVoList);
				}
				return res;
			} catch (DAOException ex) {
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(ex.getMessage(),ex);
			}
	}
}