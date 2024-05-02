/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanLinkBackEndJob.java
*@FileTitle : Ocean Link Background Job
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.01
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.08.01 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.basic;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration.OceanLinkBackEndDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-Product Catalog Back End Job Business Logic Basic Command implementation<br>
 * - ALPS-Product Catalog BackEnd작업을 처리하는 Business Class
 * @author Park Mangeon
 * @see ESD_PRD_0012
 * @date 2009.06.05
 * @since J2EE 1.6
 */
public class OceanLinkBackEndJob extends BackEndCommandSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066055L;
	
	/**
	 * HQ Link정보
	 */
	private SaveOceanLinkVO[] saveOceanLinkVOs;
	/**
	 * 등록/수정 Office Code
	 */
	private String ofcCd;
	/**
	 * 등록/수정 User ID
	 */
	private String usrId;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private OceanLinkBackEndDBDAO dbDao;
	
	/**
	 * Ocean Link를 Modify하기 위한 Value를 Setup 한다.
	 * @param SaveOceanLinkVO[] saveOceanLinkVOs
	 * @param String ofcCd
	 * @param String usrId
	 */
	public void setModifyOceanLink(SaveOceanLinkVO[] saveOceanLinkVOs, String ofcCd, String usrId) {
		this.saveOceanLinkVOs = saveOceanLinkVOs;
		this.ofcCd = ofcCd;
		this.usrId = usrId;
	}
	
	/**
	 * Ocean Route와 HQ Link를 수행할 Thread 기동시 동작한다.<br>
	 * @return Object
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		modifyOceanLink(this.saveOceanLinkVOs, this.ofcCd, this.usrId); 
		return null;
	}
	
	/**
	 * ESD_PRD_0012 HQ Link Management<br>
	 * Ocean Route와 HQ Link를 수정한다.
	 * @param SaveOceanLinkVO[] vos
	 * @param String ofcCd
	 * @param String usrId
	 * @exception EventException
	 */
	private void modifyOceanLink(SaveOceanLinkVO[] vos, String ofcCd, String usrId) throws EventException {
		this.dbDao = new OceanLinkBackEndDBDAO();
		double tztmHrs = 0;
		
		try {
			if(vos != null){
				boolean isOcnRout = false;
				for(int i = 0; i < vos.length; i++){
					isOcnRout = false;
					SaveOceanLinkVO vo = vos[i];
					if("0".equals(vo.getChk()) && !"D".equals(vo.getIbflag())) {
						continue;
					}
					vo.setCreOfcCd(ofcCd);
					vo.setCreUsrId(usrId);
					vo.setUpdUsrId(usrId);

					String delOption = "HQ Link Delete"; //= vo.getDelcombo().equals("D") ? "Direct Calling. " : "Transshipment.  ";
					String remarks = delOption + vo.getRemark().replace("Direct Calling. ", "").replace("Transshipment.  ", "");
					vo.setRemark(remarks);
					
					tztmHrs = Double.parseDouble(vo.getFmtTztmHrs().substring(0, 2)) * 24 + Double.parseDouble(vo.getFmtTztmHrs().substring(2));
					log.debug("\n ★ fmt_tztm_hrs[i] :" + vo.getFmtTztmHrs() + ", tztmHrs:" + tztmHrs + "=  " + Double.parseDouble(vo.getFmtTztmHrs().substring(0, 2)) * 24 + "+" + Double.parseDouble(vo.getFmtTztmHrs().substring(2)));
					vo.setFmtTztmHrs(tztmHrs + "");

					// Insert의 경우 Direct에 대해서만 처리한다.
					if(vo.getIbflag().equals("I")){ //sStatus
//						DBRowSet dRs = dbDao.oceanLinkSChk(vo);
//						
//						if(dRs.next()){
//							throw new DAOException((new ErrorHandler("PRD00048")).getMessage());
//						}
						
						// 중복검사가 되었으므로,Link를 저장(merge한다.)
						int retInsertVal = dbDao.insertPrdPfTxTm(vo);
						log.debug("\n\n ★insertVar: " + retInsertVal);

						DBRowSet tmpDRs = dbDao.searchDirecOcnRout(vo.getPolprot(), vo.getPodprot(), vo.getLanecd());
//						boolean isOcnRout = false;
						while(tmpDRs.next()){
							isOcnRout = true;
							// history 생성 JSY 
							dbDao.historyOcnAdd(tmpDRs.getString("ORG_LOC_CD"), tmpDRs.getString("DEST_LOC_CD"), tmpDRs.getString("ROUT_SEQ"));
						}

						// Direct Ocean Route Create or Update (Direct의 경우 priority 1, Standard, user remark = null : mgpark 20110802
						dbDao.oceanLinkMergeInto(vo);
						
// 신규이므로 불필요해 보인다.
//						if(!isOcnRout){ // if created create history
//							tmpDRs = dbDao.searchDirecOcnRout(vo.getPolprot(), vo.getPodprot(), vo.getLanecd());
//							if(tmpDRs.next()){
//								dbDao.historyOcnAdd(tmpDRs.getString("ORG_LOC_CD"), tmpDRs.getString("DEST_LOC_CD"), tmpDRs.getString("ROUT_SEQ"));
//							}
//						}
					} 
				
					if(!isOcnRout) {
						// Ocean Route - Direct는 Standard로 처리된다. Remark update한다.
						// update대상은 그냥 history생성 (mgpark)
						// 신규이면서, 이전에 데이터가 없었던 경우 history생성 (mgpark)
						DBRowSet tmpDRs2 = dbDao.searchDirecOcnRout(vo.getPolprot(), vo.getPodprot(), vo.getLanecd()); //새로 추가된 ocn rout를 찾는다.
						if(tmpDRs2.next()){
							// history 생성 JSY 
							dbDao.historyOcnAdd(tmpDRs2.getString("ORG_LOC_CD"), tmpDRs2.getString("DEST_LOC_CD"), tmpDRs2.getString("ROUT_SEQ"));
						}
					}
					dbDao.oceanLinkUpdate1(vo);
				    
				    if(vo.getIbflag().equals("D")){
						dbDao.deleteManualPfTzTm(vo);
						dbDao.addOceanRouteHistoryByHQLink(vo);
						dbDao.removeOceanRouteByHQLink(vo);
					} else if(vo.getIbflag().equals("U") && vo.getOcnLnkMnlFlg().equals("Y")){ //sStatus가 U  , manual 일때 
						dbDao.updateManualPfTzTm(vo);
						dbDao.addOceanRouteHistoryByHQLink(vo);
						dbDao.updateManualOcnRout(vo, "1");
						dbDao.updateManualOcnRout(vo, "2");
						dbDao.updateManualOcnRout(vo, "3");
						dbDao.updateManualOcnRout(vo, "4");
					}
				}// for끝

			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
}
