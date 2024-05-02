/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSendBCImpl.java
*@FileTitle : VskEmailSend
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.26 박준용
* 1.0 Creation
* 2010.10.29 김진승 [소스품질 보완] Line 154 부근 빈 Block 문장 에 대해 주석 처리
* 2010.11.15 박준용 [CSR NO 미정] [ESD-SCE] VSK SKD E-MAIL 로직 변경
* 2010.11.17 김진승 [소스품질 보완] += 보완  
=========================================================*/
package com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration.VskEmailSendDBDAO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.integration.VskEmailSendEAIDAO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.SceEmlJbSubscSubVO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.SceEmlSndRsltSubscVO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.vslSkdCtntVO;
import com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.vo.vslSkdEmlVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * EmailJobManage Business Logic Command Interface<br>
 * - EmailJobManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Jun Yong
 * @see  
 * @since J2EE 1.6
 */
public class VskEmailSendBCImpl extends BasicCommandSupport implements VskEmailSendBC {

	VskEmailSendDBDAO dbDao = null;
	VskEmailSendEAIDAO eaiDao = null;

	/**
	 * VskEmailSendBCImpl 객체 생성<br>
	 * VskEmailSendDBDAO를 생성한다.<br>
	 * VskEmailSendEAIDAO를 생성한다.<br>
	 */
	public VskEmailSendBCImpl() {
		dbDao = new VskEmailSendDBDAO();
		eaiDao = new VskEmailSendEAIDAO();
	}
	
	/**
	 * @param eml_jb_id String 
	 * @see com.clt.apps.opus.esd.sce.emailjobmanage.vskemailsend.basic.VskEmailSendBC#sendVslSkdEmail(java.lang.String)
	 */
	public void sendVslSkdEmail(String eml_jb_id) throws EventException {
		List<vslSkdEmlVO> vslSkdEmlVo = new ArrayList<vslSkdEmlVO>();
		List<vslSkdCtntVO> vslSkdCtntVo = new ArrayList<vslSkdCtntVO>();
		List<SceEmlJbSubscSubVO> sceEmlJbSubscSubVO = new ArrayList<SceEmlJbSubscSubVO>();
		
		String vvd = "";
		String vslNm = "";
		String pol = "";
		String lane = "";
		String vpsEtbDt = "";
		String vpsEtdDt = "";
		String pfEtbDt = "";
		String pfEtdDt = "";
		String delayBerth = "";
		String delayDep = "";
		String ctnt = "";
		
		try {
			vslSkdEmlVo = dbDao.searchVslSkdEmlJob(eml_jb_id);
			
			for(int i = 0; i < vslSkdEmlVo.size(); i++){				
				if( i != 0 && 
					vslSkdEmlVo.get(i-1).getEmlGrpId().equals(vslSkdEmlVo.get(i).getEmlGrpId()) &&
					vslSkdEmlVo.get(i-1).getSubscEml().equals(vslSkdEmlVo.get(i).getSubscEml()) &&
					vslSkdEmlVo.get(i-1).getVslSlanCd().equals(vslSkdEmlVo.get(i).getVslSlanCd()) ){
					
					vvd = ""; 
					vslNm = "";
					pol = "";
					lane = "";
					vpsEtbDt = "";
					vpsEtdDt = "";
					pfEtbDt = "";
					pfEtdDt = "";
					delayBerth = "";
					delayDep = "";	
										
					if( vslSkdEmlVo.size()-1 == i || 
							  !vslSkdEmlVo.get(i).getEmlGrpId().equals(vslSkdEmlVo.get(i+1).getEmlGrpId()) ||
							  !vslSkdEmlVo.get(i).getSubscEml().equals(vslSkdEmlVo.get(i+1).getSubscEml()) ){
							sceEmlJbSubscSubVO = dbDao.searchVslSkdEmlSubsc(vslSkdEmlVo.get(i));
							
							SceEmlSndRsltSubscVO[] sceEmlSndRsltSubscVO = new SceEmlSndRsltSubscVO[sceEmlJbSubscSubVO.size()];
							
							for(int h = 0; h < sceEmlJbSubscSubVO.size(); h++){
								sceEmlSndRsltSubscVO[h] = new SceEmlSndRsltSubscVO();
								sceEmlSndRsltSubscVO[h].setEmlJbId(sceEmlJbSubscSubVO.get(h).getEmlJbId());
								sceEmlSndRsltSubscVO[h].setSvcStDt(sceEmlJbSubscSubVO.get(h).getSvcStDt());
								sceEmlSndRsltSubscVO[h].setSvcEndDt(sceEmlJbSubscSubVO.get(h).getSvcEndDt());
								sceEmlSndRsltSubscVO[h].setEmlGrpId(sceEmlJbSubscSubVO.get(h).getEmlGrpId());
								sceEmlSndRsltSubscVO[h].setSubscSeq(sceEmlJbSubscSubVO.get(h).getSubscSeq());
								sceEmlSndRsltSubscVO[h].setSubscTpCd(sceEmlJbSubscSubVO.get(h).getSubscTpCd());
								sceEmlSndRsltSubscVO[h].setSubscEml(sceEmlJbSubscSubVO.get(h).getSubscEml());
								sceEmlSndRsltSubscVO[h].setDeltFlg(sceEmlJbSubscSubVO.get(h).getDeltFlg());
								sceEmlSndRsltSubscVO[h].setEmlCtnt(ctnt);	
								sceEmlSndRsltSubscVO[h].setSysDt(sceEmlJbSubscSubVO.get(h).getSysDt());
								sceEmlSndRsltSubscVO[h].setVslSlanCd(sceEmlJbSubscSubVO.get(h).getVslSlanCd());
								sceEmlSndRsltSubscVO[h].setToPortCd(sceEmlJbSubscSubVO.get(h).getToPortCd());
								
								if( h == 0 ){
									eaiDao.sendVslSkd(sceEmlSndRsltSubscVO[h]);							
								}						 
								dbDao.addEmlSndRslt(sceEmlSndRsltSubscVO[h]);
							}
							ctnt = "";						
						}	
				}else{
					vslSkdCtntVo = dbDao.searchVslSkdCtnt(vslSkdEmlVo.get(i));
					
					for(int k = 0; k < vslSkdCtntVo.size(); k++){
						if( k == 0 ){
							vvd = "".equals(vslSkdCtntVo.get(k).getVvd()) ? "-" : vslSkdCtntVo.get(k).getVvd(); 
							vslNm = "".equals(vslSkdCtntVo.get(k).getVesselName()) ? "-" : vslSkdCtntVo.get(k).getVesselName();
							pol = "".equals(vslSkdCtntVo.get(k).getPol()) ? "-" : vslSkdCtntVo.get(k).getPol();
							lane = "".equals(vslSkdCtntVo.get(k).getLane()) ? "-" : vslSkdCtntVo.get(k).getLane();
							vpsEtbDt = "".equals(vslSkdCtntVo.get(k).getVpsEtbDt()) ? "-" : vslSkdCtntVo.get(k).getVpsEtbDt();
							vpsEtdDt = "".equals(vslSkdCtntVo.get(k).getVpsEtdDt()) ? "-" : vslSkdCtntVo.get(k).getVpsEtdDt() ;
							pfEtbDt = "".equals(vslSkdCtntVo.get(k).getPfEtbDt()) ? "-" : vslSkdCtntVo.get(k).getPfEtbDt();
							pfEtdDt = "".equals(vslSkdCtntVo.get(k).getPfEtdDt()) ? "-" : vslSkdCtntVo.get(k).getPfEtdDt();
							delayBerth = "".equals(vslSkdCtntVo.get(k).getDelayBerth()) ? "0" : vslSkdCtntVo.get(k).getDelayBerth();
							delayDep = "".equals(vslSkdCtntVo.get(k).getDelayDep()) ? "0" : vslSkdCtntVo.get(k).getDelayDep();	
						}else{
							vvd = vvd + ",";
							vvd = vvd + ("".equals(vslSkdCtntVo.get(k).getVvd()) ? "-" : vslSkdCtntVo.get(k).getVvd());
							vslNm = vslNm + ",";
							vslNm = vslNm + ("".equals(vslSkdCtntVo.get(k).getVesselName()) ? "-" : vslSkdCtntVo.get(k).getVesselName());
							pol = pol + ",";
							pol = pol + ("".equals(vslSkdCtntVo.get(k).getPol()) ? "-" : vslSkdCtntVo.get(k).getPol());
							lane = lane + ",";
							lane = lane + ("".equals(vslSkdCtntVo.get(k).getLane()) ? "-" : vslSkdCtntVo.get(k).getLane());							
							vpsEtbDt = vpsEtbDt + ",";
							vpsEtbDt = vpsEtbDt + ("".equals(vslSkdCtntVo.get(k).getVpsEtbDt()) ? "-" : vslSkdCtntVo.get(k).getVpsEtbDt());
							vpsEtdDt = vpsEtdDt + ",";
							vpsEtdDt = vpsEtdDt + ("".equals(vslSkdCtntVo.get(k).getVpsEtdDt()) ? "-" : vslSkdCtntVo.get(k).getVpsEtdDt());
							pfEtbDt = pfEtbDt + ",";
							pfEtbDt = pfEtbDt + ("".equals(vslSkdCtntVo.get(k).getPfEtbDt()) ? "-" : vslSkdCtntVo.get(k).getPfEtbDt());
							pfEtdDt = pfEtdDt + ",";
							pfEtdDt = pfEtdDt + ("".equals(vslSkdCtntVo.get(k).getPfEtdDt()) ? "-" : vslSkdCtntVo.get(k).getPfEtdDt());
							delayBerth = delayBerth + ",";
							delayBerth = delayBerth + ("".equals(vslSkdCtntVo.get(k).getDelayBerth()) ? "0" : vslSkdCtntVo.get(k).getDelayBerth());
							delayDep = delayDep + ",";
							delayDep = delayDep + ("".equals(vslSkdCtntVo.get(k).getDelayDep()) ? "0" : vslSkdCtntVo.get(k).getDelayDep());		
						}								
					}	
										
					if( ctnt.equals("") ){
						ctnt = vvd + "||" + vslNm + "||" + pol + "||" + lane + "||" + vpsEtbDt + "||" + vpsEtdDt
						+ "||" + pfEtbDt + "||" + pfEtdDt + "||" + delayBerth + "||" + delayDep;
					// }else if( "".equals(vvd) ){ // 2010.10.29 소스품질 보완
					}else{
						ctnt = ctnt + "##" + vvd + "||" + vslNm + "||" + pol + "||" + lane + "||" + vpsEtbDt + "||" + vpsEtdDt
						+ "||" + pfEtbDt + "||" + pfEtdDt + "||" + delayBerth + "||" + delayDep;
					}
					
					if( vslSkdEmlVo.size()-1 == i || 
						  !vslSkdEmlVo.get(i).getEmlGrpId().equals(vslSkdEmlVo.get(i+1).getEmlGrpId()) ||
						  !vslSkdEmlVo.get(i).getSubscEml().equals(vslSkdEmlVo.get(i+1).getSubscEml()) ){
						sceEmlJbSubscSubVO = dbDao.searchVslSkdEmlSubsc(vslSkdEmlVo.get(i));
						
						SceEmlSndRsltSubscVO[] sceEmlSndRsltSubscVO = new SceEmlSndRsltSubscVO[sceEmlJbSubscSubVO.size()];
						
						for(int h = 0; h < sceEmlJbSubscSubVO.size(); h++){
							sceEmlSndRsltSubscVO[h] = new SceEmlSndRsltSubscVO();
							sceEmlSndRsltSubscVO[h].setEmlJbId(sceEmlJbSubscSubVO.get(h).getEmlJbId());
							sceEmlSndRsltSubscVO[h].setSvcStDt(sceEmlJbSubscSubVO.get(h).getSvcStDt());
							sceEmlSndRsltSubscVO[h].setSvcEndDt(sceEmlJbSubscSubVO.get(h).getSvcEndDt());
							sceEmlSndRsltSubscVO[h].setEmlGrpId(sceEmlJbSubscSubVO.get(h).getEmlGrpId());
							sceEmlSndRsltSubscVO[h].setSubscSeq(sceEmlJbSubscSubVO.get(h).getSubscSeq());
							sceEmlSndRsltSubscVO[h].setSubscTpCd(sceEmlJbSubscSubVO.get(h).getSubscTpCd());
							sceEmlSndRsltSubscVO[h].setSubscEml(sceEmlJbSubscSubVO.get(h).getSubscEml());
							sceEmlSndRsltSubscVO[h].setDeltFlg(sceEmlJbSubscSubVO.get(h).getDeltFlg());
							sceEmlSndRsltSubscVO[h].setEmlCtnt(ctnt);	
							sceEmlSndRsltSubscVO[h].setSysDt(sceEmlJbSubscSubVO.get(h).getSysDt());
							sceEmlSndRsltSubscVO[h].setVslSlanCd(sceEmlJbSubscSubVO.get(h).getVslSlanCd());
							sceEmlSndRsltSubscVO[h].setToPortCd(sceEmlJbSubscSubVO.get(h).getToPortCd());
							
							if( h == 0 ){
								eaiDao.sendVslSkd(sceEmlSndRsltSubscVO[h]);							
							}						 
							dbDao.addEmlSndRslt(sceEmlSndRsltSubscVO[h]);
						}
						ctnt = "";						
					}					
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
}