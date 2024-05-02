/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalBCImpl.java
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
* 1.0 Creation
* =========================================================
* history
* 2013.06.03 김현화 [CHM-201324585]DG Packing Instruction 기능 적용. 
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration.PartnerLinesDangerousCargoApprovalDBDAO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInvalidReasonDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionMtdItemVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionRegulatoryVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSegregationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSpclProviVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSppDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstFileVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.mysql.jdbc.StringUtils;



/**
 * APLS-CargoLoadingApproval Business Logic Basic Command implementation<br>
 * - APLS-CargoLoadingApproval에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0022EventResponse,PartnerLinesDangerousCargoApprovalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PartnerLinesDangerousCargoApprovalBCImpl extends BasicCommandSupport implements PartnerLinesDangerousCargoApprovalBC {

	// Database Access Object
	private transient PartnerLinesDangerousCargoApprovalDBDAO dbDao = null;

	/**
	 * PartnerLinesDangerousCargoApprovalBCImpl 객체 생성<br>
	 * PartnerLinesDangerousCargoApprovalDBDAO를 생성한다.<br>
	 */
	public PartnerLinesDangerousCargoApprovalBCImpl() {
		dbDao = new PartnerLinesDangerousCargoApprovalDBDAO();
	}
	/**
	 * VOP_SCG_0022 : Retrieve <br>
	 * SPCL CGO APVL for Partner Lines 를 조회 합니다. <br>
	 * 
	 * @param partnerApprovalRequestVO   PartnerApprovalRequestVO
	 * @return List<PartnerApprovalRequestVO>
	 * @exception EventException
	 */
	public List<PartnerApprovalRequestVO> searchPatnerSCGList(PartnerApprovalRequestVO partnerApprovalRequestVO) throws EventException {
		try {
			return dbDao.searchPatnerSCGList(partnerApprovalRequestVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_0022 : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param partnerApprovalRequestVO PartnerApprovalRequestVO[]
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int managePartnerSCG(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException{
		int resultValue = 0;
		boolean isExists = false;
		try {
			if(partnerApprovalRequestVO != null) {
				
				ScgPrnrAproRqstVO[]     scgPrnrAproRqstVOs     = partnerApprovalRequestVO.getScgPrnrAproRqstVOs();	
				ScgPrnrAproRqstCgoVO[]  scgPrnrAproRqstCgoVOs  = partnerApprovalRequestVO.getScgPrnrAproRqstCgoVOs();
				ScgPrnrAproRqstFileVO[] scgPrnrAproRqstFileVOs = partnerApprovalRequestVO.getScgPrnrAproRqstFileVOs();
				
				List<ScgPrnrAproRqstVO> insertVoList1 = new ArrayList<ScgPrnrAproRqstVO>();
				List<ScgPrnrAproRqstVO> updateVoList1 = new ArrayList<ScgPrnrAproRqstVO>();
				List<ScgPrnrAproRqstVO> deleteVoList1 = new ArrayList<ScgPrnrAproRqstVO>();
				
				List<ScgPrnrAproRqstCgoVO> insertVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> updateVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> deleteVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				List<ScgPrnrAproRqstCgoVO> rqstNoVoList2 = new ArrayList<ScgPrnrAproRqstCgoVO>();
				
				List<ScgPrnrAproRqstFileVO> insertVoList3 = new ArrayList<ScgPrnrAproRqstFileVO>();
				List<ScgPrnrAproRqstFileVO> updateVoList3 = new ArrayList<ScgPrnrAproRqstFileVO>();
				List<ScgPrnrAproRqstFileVO> deleteVoList3 = new ArrayList<ScgPrnrAproRqstFileVO>();
				
				if(scgPrnrAproRqstVOs != null) {
					
					//Booking 갯수 와 Cago 갯수로 분류
					int bkgRqtCt = scgPrnrAproRqstVOs.length;
					int cagoRqtCt = scgPrnrAproRqstCgoVOs==null?0:scgPrnrAproRqstCgoVOs.length;
					String usrId = "";
					String ofcCd = "";
					for ( int bkgIdx=0; bkgIdx<bkgRqtCt; bkgIdx++ ) {
						if(!StringUtils.isNullOrEmpty(partnerApprovalRequestVO.getRgnShpOprCd())){							
							scgPrnrAproRqstVOs[bkgIdx].setRgnShpOprCd(partnerApprovalRequestVO.getRgnShpOprCd());
						}
						if(!StringUtils.isNullOrEmpty(partnerApprovalRequestVO.getDgFlg())){
							scgPrnrAproRqstVOs[bkgIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());
						}
						if(!StringUtils.isNullOrEmpty(partnerApprovalRequestVO.getAwkFlg())){
							scgPrnrAproRqstVOs[bkgIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
						}
						
						
						if(account == null){
							if(StringUtils.isNullOrEmpty(scgPrnrAproRqstVOs[bkgIdx].getCreUsrId())){
								usrId = "-1";
							} else {
								usrId = scgPrnrAproRqstVOs[bkgIdx].getCreUsrId();
							}							
						} else {
							usrId = account.getUsr_id();
							ofcCd = account.getOfc_cd();
						}
						scgPrnrAproRqstVOs[bkgIdx].setCreUsrId(usrId);
						scgPrnrAproRqstVOs[bkgIdx].setUpdUsrId(usrId);
						
						//DG Detail Pop-Up의 경우 SLAN_CD로 BKG & CARGO 의 파라미터를 구분한다.
						if(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo() != null && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getBkgRefNo()) && !"".equals(scgPrnrAproRqstVOs[bkgIdx].getSlanCd())) {
							if (scgPrnrAproRqstVOs[bkgIdx].getIbflag().equals("I")){
								if(scgPrnrAproRqstVOs[bkgIdx].getSpclCgoRqstSeq().equals("")) { 
									// D-cube에서 호출시 DangerousCargoInformationMgtJMSProxy 에서 SpclCgoRqstSeq의 값은 항상 null. 2014-07-16
									// INSERT 건중에서 기존에 들어있는 값과 같은 조합을 가지는 경우가 들어온 경우 들어있는 값을 사용하게끔 하며
									// 아래에서 insertVoList1 이 Insert 될 때에 제외 시킨다. 2011.04.21
									int currSeq = dbDao.searchPatnerSCGExistSeq(scgPrnrAproRqstVOs[bkgIdx]);
									if( currSeq > 0 ) {
										scgPrnrAproRqstVOs[bkgIdx].setMeFlag("Y");
										scgPrnrAproRqstVOs[bkgIdx].setSpclCgoRqstSeq(Integer.toString(currSeq));
									} else {
										scgPrnrAproRqstVOs[bkgIdx].setMeFlag("N");
									}
									insertVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
								}
							} else if (scgPrnrAproRqstVOs[bkgIdx].getIbflag().equals("U")){							
								updateVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							} else if (scgPrnrAproRqstVOs[bkgIdx].getIbflag().equals("D")){
								deleteVoList1.add(scgPrnrAproRqstVOs[bkgIdx]);
							}
						}
					}
					
					for ( int cgoIdx=0; cgoIdx<cagoRqtCt; cgoIdx++ ) {
						
						//필수항목 예외처리
						Method[] methods  = scgPrnrAproRqstCgoVOs[cgoIdx].getClass().getMethods();		
						String gMethodNm = "", sMethodNm = "";
						for(int mIdx1=0; mIdx1<methods.length; mIdx1++) {
							Method gMethod = methods[mIdx1];
							if (gMethod.getName().indexOf("get") != -1) {								
								if(gMethod.getReturnType().getName().equals("java.lang.String")) {
									String val = (String)gMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx]);									
						            if(val == null || "".equals(val)) {
						            	gMethodNm = gMethod.getName();
										gMethodNm = gMethodNm.substring(3,gMethodNm.length());										
							            for(int mIdx2=0; mIdx2<methods.length; mIdx2++) {
											Method sMethod = methods[mIdx2];
											sMethodNm = sMethod.getName();
											sMethodNm = sMethodNm.substring(3,sMethodNm.length());
											if(sMethod.getName().indexOf("set") != -1 && gMethodNm.equals(sMethodNm)) {
												if(gMethodNm.equals("AproRefNo")||gMethodNm.equals("PckQty")||
												   gMethodNm.equals("InN1stImdgPckQty")||gMethodNm.equals("InN2ndImdgPckQty")||
												   gMethodNm.equals("MaxInPckQty")||gMethodNm.equals("MeasQty")||
												   gMethodNm.equals("OutN1stImdgPckQty")||gMethodNm.equals("OutN2ndImdgPckQty")||
												   gMethodNm.equals("ImdgUnNo")||gMethodNm.equals("ImdgUnNoSeq")
											      ) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "0");
												} else if(gMethodNm.equals("ClodFlg")) {
													sMethod.invoke(scgPrnrAproRqstCgoVOs[cgoIdx], "N");
												}
											}
							            }
						            }
								}
					        }
						}
						
						//DG Detail Pop-Up의 경우 CNTR_SEQ 로 BKG & CARGO 의 파라미터를 구분한다.
						if(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq() != null && !"".equals(scgPrnrAproRqstCgoVOs[cgoIdx].getSpclCntrSeq())) {
							scgPrnrAproRqstCgoVOs[cgoIdx].setDgFlg(partnerApprovalRequestVO.getDgFlg());	
							scgPrnrAproRqstCgoVOs[cgoIdx].setAwkFlg(partnerApprovalRequestVO.getAwkFlg());
							if("-1".equals(ofcCd)){
								if(StringUtils.isNullOrEmpty(scgPrnrAproRqstCgoVOs[cgoIdx].getAuthOfcCd())){
									ofcCd = scgPrnrAproRqstCgoVOs[cgoIdx].getAuthOfcCd();
								}									
							} 
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthOfcCd(ofcCd);							
							scgPrnrAproRqstCgoVOs[cgoIdx].setAuthUsrId(usrId);
							scgPrnrAproRqstCgoVOs[cgoIdx].setCreUsrId(usrId);
							scgPrnrAproRqstCgoVOs[cgoIdx].setUpdUsrId(usrId);
							if (scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag().equals("I")){
								insertVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							} else if (scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag().equals("U")){							
								updateVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							} else if (scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag().equals("D")){
								deleteVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}
							
							//승인번호 생성할 트랜잭션 추리기
							if (scgPrnrAproRqstCgoVOs[cgoIdx].getAuthStsCd().equals("Y") || scgPrnrAproRqstCgoVOs[cgoIdx].getIbflag().equals("D")){
								rqstNoVoList2.add(scgPrnrAproRqstCgoVOs[cgoIdx]);
							}
						}
					}
					
					//1. 삭제 처리
					if ( deleteVoList2.size() > 0 ) {
						
						//1-1. Cago 지우고
						dbDao.removePartnerSCGCGO(deleteVoList2);
						isExists = true;
						
						//1-2. Cago가 모두 삭제됬다면 요청을 삭제한다.
						Iterator list = deleteVoList1.iterator();	
						String[] rmList = new String[deleteVoList1.size()];	
						int isCt = 0, expCt = 0;
			        	while(list.hasNext()){
			        		ScgPrnrAproRqstVO vo = (ScgPrnrAproRqstVO)list.next();
			        		isCt = dbDao.searchPatnerSCGCGOIsSeq(vo);
			        		if(isCt > 0) {
			        			rmList[expCt] = "Y";
			        		}
			        		expCt++;
			        	}
			        	for(int delCt=rmList.length-1; delCt >= 0; delCt--) {
							if("Y".equals(rmList[delCt])) deleteVoList1.remove(delCt);
		        		}
			        	if ( deleteVoList1.size() > 0 ) {
							dbDao.removePartnerSCG(deleteVoList1);
							
						}
					}
					
					//2. 수정 처리
					if ( updateVoList1.size() > 0 ) {
						dbDao.modifyPartnerSCG(updateVoList1);
						isExists = true;
					}
					if ( updateVoList2.size() > 0 ) {
						dbDao.modifyPartnerSCGCGO(updateVoList2);
						isExists = true;
					}
					
					//FILE UPLOAD KEY값
					Iterator<String> keyArr = null;			
					if(keys != null) keyArr = keys.iterator();
					
					if(scgPrnrAproRqstFileVOs != null) {
						for ( int i=0; i<scgPrnrAproRqstFileVOs.length; i++ ) {
							
							//FILE UPLOAD KEY값 SETTING하기
							if(keyArr != null) {
								if("Y".equals(scgPrnrAproRqstFileVOs[i].getFileSetYn()) && keyArr.hasNext()) 
									scgPrnrAproRqstFileVOs[i].setFileSavId(keyArr.next());	 
							}
							
							if (scgPrnrAproRqstFileVOs[i].getIbflag().equals("I")){
								scgPrnrAproRqstFileVOs[i].setCreUsrId(usrId);
								scgPrnrAproRqstFileVOs[i].setUpdUsrId(usrId);
								insertVoList3.add(scgPrnrAproRqstFileVOs[i]);
							} else if (scgPrnrAproRqstFileVOs[i].getIbflag().equals("U")){
								scgPrnrAproRqstFileVOs[i].setUpdUsrId(usrId);
								updateVoList3.add(scgPrnrAproRqstFileVOs[i]);
							} else if (scgPrnrAproRqstFileVOs[i].getIbflag().equals("D")){
								deleteVoList3.add(scgPrnrAproRqstFileVOs[i]);
							}
						}
					}
					
					//3. 생성 처리
					if ( insertVoList2.size() > 0 ||  insertVoList3.size() > 0 ) {
						//3-1. 요청을 묶음별로 구분한다. <기준:BKG Company, BKG No, VVD CD, POL, POD>
						String[] rmList = new String[insertVoList1.size()];	
						String valStr1 = "", valStr2 = "";
						for(int expCt1=0; expCt1<insertVoList1.size(); expCt1++) {
							ScgPrnrAproRqstVO vo1 = (ScgPrnrAproRqstVO)insertVoList1.get(expCt1);
							valStr1 = vo1.getCgoOprCd() + vo1.getBkgRefNo() + vo1.getVslCd() + vo1.getSkdVoyNo() + vo1.getSkdDirCd() + vo1.getPolCd() + vo1.getPodCd();
							for(int expCt2=expCt1+1; expCt2<insertVoList1.size(); expCt2++) {
								ScgPrnrAproRqstVO vo2 = (ScgPrnrAproRqstVO)insertVoList1.get(expCt2);
								valStr2 = vo2.getCgoOprCd() + vo2.getBkgRefNo() + vo2.getVslCd() + vo2.getSkdVoyNo() + vo2.getSkdDirCd() + vo2.getPolCd() + vo2.getPodCd();
								
								if(valStr1.equals(valStr2)) rmList[expCt1] = "Y";
							}
						}
			        	for(int delCt=rmList.length-1; delCt >= 0; delCt--) {
							if("Y".equals(rmList[delCt])) insertVoList1.remove(delCt);
		        		}
			        	//3-2. 요청번호를 생성하여 붙인다.
			        	int spclCgoRqstMaxSeq;
			        	int spclCgoRqstAttachFileSeq;
			        	int spclCgoRqstSeq = 0;
			        	String appendSpclCgoRqstSeq;	//기존 등록 요청의 하위 Cago로 입력하기 위한 기존요청번호 : 화면에서 카피된다.
			        	for(int insCt1=0; insCt1<insertVoList1.size(); insCt1++) {
			        		// 기존에 있는 조합으로 새로 생성된 경우 위에서 가져와 지정한 Current Spcl_cgo_rqst_seq 를 가져와 사용한다. 2011.04.21
			        		if ( "Y".equals(insertVoList1.get(insCt1).getMeFlag()) ) {
			        			spclCgoRqstSeq = Integer.parseInt( insertVoList1.get(insCt1).getSpclCgoRqstSeq() );
			        		} else {
			        			spclCgoRqstMaxSeq = dbDao.searchPatnerSCGMaxSeq(insertVoList1.get(insCt1)); 
			        			spclCgoRqstSeq = spclCgoRqstMaxSeq;
			        			insertVoList1.get(insCt1).setSpclCgoRqstSeq(Integer.toString(spclCgoRqstSeq));
			        			spclCgoRqstMaxSeq++;
			        		}
			        		//valStr1 = insertVoList1.get(insCt1).getCgoOprCd() + insertVoList1.get(insCt1).getBkgRefNo() + insertVoList1.get(insCt1).getVslCd() + insertVoList1.get(insCt1).getSkdVoyNo() + insertVoList1.get(insCt1).getSkdDirCd() + insertVoList1.get(insCt1).getPolCd() + insertVoList1.get(insCt1).getPodCd();
			        		valStr1 = insertVoList1.get(insCt1).getCrrCd() + insertVoList1.get(insCt1).getBkgRefNo();
			        		
			        		//Cago에 요청번호 붙이기
			        		for(int insCt2=0; insCt2<insertVoList2.size(); insCt2++) {
			        			//valStr2 = insertVoList2.get(insCt2).getCgoOprCd() + insertVoList2.get(insCt2).getBkgRefNo() + insertVoList2.get(insCt2).getVslCd() + insertVoList2.get(insCt2).getSkdVoyNo() + insertVoList2.get(insCt2).getSkdDirCd() + insertVoList2.get(insCt2).getPolCd() + insertVoList2.get(insCt2).getPodCd();
			        			valStr2 = insertVoList2.get(insCt2).getCrrCd() + insertVoList2.get(insCt2).getBkgRefNo();
			        			appendSpclCgoRqstSeq = insertVoList2.get(insCt2).getSpclCgoRqstSeq();
			        			if((appendSpclCgoRqstSeq == null || "".equals(appendSpclCgoRqstSeq)) && valStr1.equals(valStr2)) {
			        				insertVoList2.get(insCt2).setSpclCgoRqstSeq(Integer.toString(spclCgoRqstSeq));
			        			}
			        		}
			        		
			        		//File에 요청번호&Sequence 붙이기 - BKG 기준으로 분류
			        		spclCgoRqstAttachFileSeq = dbDao.searchPatnerSCGAttachMaxSeq(insertVoList1.get(insCt1));
			        		for(int insCt3=0; insCt3<insertVoList3.size(); insCt3++) {
			        			appendSpclCgoRqstSeq = insertVoList3.get(insCt3).getSpclCgoRqstSeq();
			        			if(appendSpclCgoRqstSeq == null || "".equals(appendSpclCgoRqstSeq)) insertVoList3.get(insCt3).setSpclCgoRqstSeq(Integer.toString(spclCgoRqstSeq));
			        			
			        			insertVoList3.get(insCt3).setSpclCgoRqstAtchFileSeq(Integer.toString(spclCgoRqstAttachFileSeq));
			        			
			        			spclCgoRqstAttachFileSeq++;
			        		}
			        		
			        		//spclCgoRqstSeq++;
			        	}
			        	//3-3. 요청번호를 생성하여 붙인다.
			        	String setSpclCgoRqstAttachFileSeq = "";
			        	for(int updCt1=0; updCt1<updateVoList1.size(); updCt1++) {
			        		
			        		//File에 Sequence 붙이기 - BKG 기준으로 분류
			        		for(int insCt3=0; insCt3<insertVoList3.size(); insCt3++) {
			        			setSpclCgoRqstAttachFileSeq = insertVoList3.get(insCt3).getSpclCgoRqstAtchFileSeq();
			        			if(setSpclCgoRqstAttachFileSeq == null || "".equals(setSpclCgoRqstAttachFileSeq)) {
				        			spclCgoRqstAttachFileSeq = dbDao.searchPatnerSCGAttachMaxSeq(updateVoList1.get(updCt1));
				        			insertVoList3.get(insCt3).setSpclCgoRqstAtchFileSeq(Integer.toString(spclCgoRqstAttachFileSeq));
			        			}
			        		}
			        	}
			        	// 기존에 있었던 조합과 같은 값을 가지는 데이터는 INSERT 에서 제외 시킨다.
			        	for(int insCt1=insertVoList1.size()-1; insCt1>=0; insCt1--) {
			        		if("Y".equals(insertVoList1.get(insCt1).getMeFlag())) insertVoList1.remove(insCt1);
			        	}
			        	//3-4. 요청을 생성한다.
			        	if(insertVoList1.size() > 0) {
			        		dbDao.addPartnerSCG(insertVoList1);	
			        		isExists = true;
			        	} else {
			        		log.info("INFO : NOT EXISTS SCG_PRNR_APRO_RQST");
			        	}
			        	//3-5. Cago를 생성한다.
			        	if (insertVoList2.size() > 0) {
			        		dbDao.addPartnerSCGCGO(insertVoList2);
			        		isExists = true;
			        	} else {
			        		log.info("INFO : NOT EXISTS SCG_PRNR_APRO_RQST_CGO");
			        	}
					}
					
					//4. 중복 체크
//					List<ScgPrnrAproRqstVO> dupList = null;					
//					dupList = dbDao.searchPatnerSCGRqstDup(scgPrnrAproRqstCgoVOs[0]);
//					if(dupList.size() > 0) {
//						return 0;
//					}
					
					
					//5. 승인번호를 생성한다.
					dbDao.modifyPatnerSCGRqstNo(rqstNoVoList2);
					
					//6-1. 파일 삭제 처리
					if ( deleteVoList3.size() > 0 ) {
						dbDao.removePartnerSCGAttach(deleteVoList3);
						isExists = true;
					}
					
					//6-2. 파일 생성 처리
					if ( insertVoList3.size() > 0 ) {
						dbDao.addPartnerSCGAttach(insertVoList3);
						isExists = true;
					}
					
					//6-3. 파일 수정 처리
					if ( updateVoList3.size() > 0 ) {
						dbDao.modifyPartnerSCGAttach(updateVoList3);
						isExists = true;
					}
				}				
			}
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
		if(isExists){
			resultValue = 1;
		}
		return resultValue;
	}
	
	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 수정 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updatePartnerSCGCGOApproved(ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs, SignOnUserAccount account) throws EventException{
		try {
			List<ScgPrnrAproRqstCgoVO> updateVoList = new ArrayList<ScgPrnrAproRqstCgoVO>();
			
			for ( int i=0; i<scgPrnrAproRqstCgoVOs.length; i++ ) {		
				if(!"".equals(scgPrnrAproRqstCgoVOs[i].getSpclCgoRqstSeq())) {
					scgPrnrAproRqstCgoVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(scgPrnrAproRqstCgoVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPartnerSCGCGOApproved(updateVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_1022 : Retrieve <br>
	 * Dangerous CGO Application Details for Partner Lines 를 조회 합니다. <br>
	 * 
	 * @param  ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return PartnerApprovalRequestVO
	 * @exception EventException
	 */
	public PartnerApprovalRequestVO searchPartnerSCGDetailList(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException{
		PartnerApprovalRequestVO rsltVO = new PartnerApprovalRequestVO();
		try {
			ScgPrnrAproRqstVO          vo   = dbDao.searchPatnerSCG(scgPrnrAproRqstVO);
			List<ScgPrnrAproRqstCgoVO> list1 = dbDao.searchPatnerSCGCGO(scgPrnrAproRqstVO);
			
			scgPrnrAproRqstVO.setCrrCd(vo.getCrrCd());
			scgPrnrAproRqstVO.setBkgRefNo(vo.getBkgRefNo());
			scgPrnrAproRqstVO.setSpclCgoRqstSeq(vo.getSpclCgoRqstSeq());
			List<ScgPrnrAproRqstFileVO> list2 = dbDao.searchPatnerSCGAttach(scgPrnrAproRqstVO);
			
			rsltVO.setScgPrnrAproRqstVO(vo);			
			rsltVO.setScgPrnrAproRqstCgoVOl(list1);
			rsltVO.setScgPrnrAproRqstFileVOl(list2);
			
			return rsltVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"SPCL CGO APVL for Partner Lines"}).getMessage(), ex);
        }
	}
	
	/**
	 * VOP_SCG_1022 : Validation <br>
	 * Dangerous CGO Application Details for Partner Lines 의 MPA1의 NET Weight 합을 조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerSCGMpa1NetSum(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException{
		try {			
			return dbDao.searchPatnerSCGMpa1NetSum(scgPrnrAproRqstVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"NET Weight"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"NET Weight"}).getMessage(), ex);
        }
	}
	
	/**
	 * Pre Checking Report(VVD별 채크기능 추가) 를 조회 합니다.(BKG 사용) <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @param boolean segChk
	 * @param boolean vslChk
	 * @param boolean prtChk
	 * @param boolean bkgRequestchk
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO, boolean segChk, boolean vslChk, boolean prtChk, boolean bkgRequestchk) throws EventException {
		/********************************************************************************************************************************************
		 * cf.) 
		 * PreRestrictionInputVO containerVO = new PreRestrictionInputVO();
		 * PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
		 * preRestrictionInputVO.setBkgNo("ATLX1210006");
		 * preRestrictionInputVO.setVslCd("HNBR");
		 * preRestrictionInputVO.setSkdVoyNo("0039");
		 * preRestrictionInputVO.setSkdDirCd("E");
		 * containerVO.setInnerPreRestrictionInputVO(preRestrictionInputVO);
		 * PreRestrictionOutputVO chkRslt = checkPreRestriction(containerVO, false, true, true);
		 * boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
		 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
		 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
		 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
		 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
		 * List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
		 ********************************************************************************************************************************************/
		try {
			PreRestrictionOutputVO preRestrictionOutputVO = new PreRestrictionOutputVO();
			
				PreRestrictionInputVO[] dgCgos;
				
				if(bkgRequestchk){
					//Step1 : select list of dangerous cargo in booking (from bkg request)
					List<PreRestrictionInputVO> dgCgoList = dbDao.searchBkgDgCargoList(preRestrictionInputVO);					
					dgCgos = (PreRestrictionInputVO[])(dgCgoList.toArray(new PreRestrictionInputVO[dgCgoList.size()]));
				}else{
					dgCgos = new PreRestrictionInputVO[1];
					dgCgos[0] = preRestrictionInputVO.getInnerPreRestrictionInputVO();
				}
			
			if(dgCgos != null && dgCgos.length > 0) {
				
				preRestrictionInputVO.setInnerPreRestrictionInputVOS(dgCgos);
//				PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();
				ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs = preRestrictionInputVO.getInnerScgPrnrAproRqstCgoVOS();
				String vslCd    = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				
				//Step2 : check segregation
				if(segChk) {
					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH01));
					List<PreRestrictionSegregationVO> segChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionSegregationVOs();
					
					if(segChkRslt != null && segChkRslt.size() > 0) {
						preRestrictionOutputVO.setSegChkRslt(false);
						preRestrictionOutputVO.setPreRestrictionSegregationVOs(segChkRslt);
					} else {
						preRestrictionOutputVO.setSegChkRslt(true);
					}
				}
				//Step3 : check vessel
				if(vslChk) {
					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH02));
					List<PreRestrictionVesselOperatorVO> vslChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionVesselOperatorVOs();
					
					if(vslChkRslt != null && vslChkRslt.size() > 0) {	
						vslCd    = preRestrictionInputVO.getVslCd();
						if(vslCd != null && !"".equals(vslCd)) {							
							skdVoyNo = preRestrictionInputVO.getSkdVoyNo();
							skdDirCd = preRestrictionInputVO.getSkdDirCd();
							
							List<PreRestrictionVesselOperatorVO> vslChkVos = new ArrayList<PreRestrictionVesselOperatorVO>();
							
							for(int rsltCt=0; rsltCt<vslChkRslt.size(); rsltCt++) {
								if(vslChkRslt.get(rsltCt).getVslCd().equals(vslCd) && vslChkRslt.get(rsltCt).getSkdVoyNo().equals(skdVoyNo) && vslChkRslt.get(rsltCt).getSkdDirCd().equals(skdDirCd)) {
									preRestrictionOutputVO.setVslChkRslt(false);
									vslChkVos.add(vslChkRslt.get(rsltCt));
								}
							}
							preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(vslChkVos);
						} else {
							preRestrictionOutputVO.setVslChkRslt(false);
							preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(vslChkRslt);
						}
					} else {
						preRestrictionOutputVO.setVslChkRslt(true);
					}
				}
				//Step4 : check port
				if(prtChk) {
					preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH05));
					
					preRestrictionInputVO.setInnerPreRestrictionInputVOS(dgCgos);
					List<PreRestrictionPortVO> prtChkRslt = checkPreRestriction(preRestrictionInputVO).getPreRestrictionPortVOs();
					
					List<PreRestrictionPortVO> prtChkVos = new ArrayList<PreRestrictionPortVO>();
					
					for(int rsltCt=0; prtChkRslt!=null && rsltCt<prtChkRslt.size(); rsltCt++) {
						if(!"".equals(prtChkRslt.get(rsltCt).getImdgCmptnAuthDesc().trim())) {
							vslCd    = preRestrictionInputVO.getVslCd();
							skdVoyNo = preRestrictionInputVO.getSkdVoyNo();
							skdDirCd = preRestrictionInputVO.getSkdDirCd();
							
							if(vslCd != null && !"".equals(vslCd)) {							
								if(prtChkRslt.get(rsltCt).getVvdCd().equals(vslCd+skdVoyNo+skdDirCd)) {
									preRestrictionOutputVO.setPrtChkRslt(false);
									prtChkVos.add(prtChkRslt.get(rsltCt));
								}
							} else {
								preRestrictionOutputVO.setPrtChkRslt(false);
								prtChkVos.add(prtChkRslt.get(rsltCt));
							}
						} 
					}
					if(preRestrictionOutputVO.getPrtChkRslt()) {
						preRestrictionOutputVO.setPreRestrictionPortVOs(prtChkVos);
					}
//					if(prtChkRslt.size() == 0){
//						preRestrictionOutputVO.setPrtChkRslt(true);
//					}
					//2015.08.17 Secure Coding 적용 [CWE-476] Null Dereferencing
					if(prtChkRslt!=null && prtChkRslt.size() == 0){
						preRestrictionOutputVO.setPrtChkRslt(true);
					}
				}

				if(Boolean.parseBoolean(preRestrictionInputVO.getInnerPreRestrictionInputVO().getPckChk())){
					preRestrictionInputVO.setFCmd(Integer.toString(FormCommand.SEARCH03));
					String pckPreChkCd = "1";
					if(scgPrnrAproRqstCgoVOs == null){
						scgPrnrAproRqstCgoVOs = new ScgPrnrAproRqstCgoVO[dgCgos.length];
					}
					for(int i = 0; i < dgCgos.length; i++){
						if(scgPrnrAproRqstCgoVOs[i] == null){
							scgPrnrAproRqstCgoVOs[i] = new ScgPrnrAproRqstCgoVO();
						}
						//packing instruction check result
						//partner BKG와 Own BKG의 변수 이름이 다른 관계로 세팅
						//preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(Integer.toString(FormCommand.SEARCH03));
						
//						if(preRestrictionInputVOs[i].getOutImdgPckCd1() == null || "".equals(preRestrictionInputVOs[i].getOutImdgPckCd1())){
//							preRestrictionInputVOs[i].setOutImdgPckQty1(scgPrnrAproRqstCgoVOs[i].getOutN1stImdgPckQty());
//							preRestrictionInputVOs[i].setOutImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getOutN1stImdgPckCd());
//							preRestrictionInputVOs[i].setIntmdImdgPckQty1(scgPrnrAproRqstCgoVOs[i].getIntmdN1stImdgPckQty());
//							preRestrictionInputVOs[i].setIntmdImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getIntmdN1stImdgPckCd());
//							preRestrictionInputVOs[i].setInImdgPckQty1(scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckQty());
//							preRestrictionInputVOs[i].setInImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckCd());
//							preRestrictionInputVOs[i].setInImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckCd());
//						}else{
//							scgPrnrAproRqstCgoVOs[i].setOutN1stImdgPckQty(preRestrictionInputVOs[i].getOutImdgPckQty1());
//							scgPrnrAproRqstCgoVOs[i].setOutN1stImdgPckCd(preRestrictionInputVOs[i].getOutImdgPckCd1());
//							scgPrnrAproRqstCgoVOs[i].setIntmdN1stImdgPckQty(preRestrictionInputVOs[i].getIntmdImdgPckQty1());
//							scgPrnrAproRqstCgoVOs[i].setIntmdN1stImdgPckCd(preRestrictionInputVOs[i].getIntmdImdgPckCd1());
//							scgPrnrAproRqstCgoVOs[i].setInN1stImdgPckQty(preRestrictionInputVOs[i].getInImdgPckQty1());
//							scgPrnrAproRqstCgoVOs[i].setInN1stImdgPckCd(preRestrictionInputVOs[i].getInImdgPckCd1());
//						}
						
//						if(scgPrnrAproRqstCgoVOs[i].getEmerCntcPhnNoCtnt() != null && !"".equals(scgPrnrAproRqstCgoVOs[i].getEmerCntcPhnNoCtnt())){
//							scgPrnrAproRqstCgoVOs[i].setEmerCntcPhnNo(scgPrnrAproRqstCgoVOs[i].getEmerCntcPhnNoCtnt());
//						}
	
						PreRestrictionInputVO packInstrInputVO = new PreRestrictionInputVO();						
						String f_cmd = Integer.toString(FormCommand.SEARCH03);
						dgCgos[i].setFCmd(f_cmd);						
						packInstrInputVO.setInnerPreRestrictionInputVO(dgCgos[i]);
						PreRestrictionOutputVO piOutputVO = checkPreRestriction(packInstrInputVO);

						int rsnDtlCnt = piOutputVO.getPreRestrictionInvalidReasonDetailVOs().size();
						String pkgTp = "";
						for(int pk = 0; pk <piOutputVO.getPreRestrictionRegulatoryVOs().size(); pk++){
							//PreRestrictionRegulatoryVO regulatoryVO = null;
							String div = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getDivNm();
							String piWgtRslt = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getMaxWgtRslt();
							//String pkgTpNm = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getPkgTpNm();
							String pkgTpRslt = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getPkgTpRslt();
							if ("Packing Instruction".equals(div) && "N/A".equals(pkgTpRslt) && !("Invalid".equals(piWgtRslt)) ){
								 pkgTp = "N" ;
							}
						}
						if(rsnDtlCnt > 0){			
							//Packing Instruction invaild
							if("Y".equals(dgCgos[i].getImdgLmtQtyFlg())){
								scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("X");
								scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
								scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
							}else if("Y".equals(dgCgos[i].getImdgExptQtyFlg())){
								scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
								scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("X");
								scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
							}else{
								scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
								scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
								if ("N".equals(pkgTp)){
								    scgPrnrAproRqstCgoVOs[i].setPiFlg("M");
								}else{
									scgPrnrAproRqstCgoVOs[i].setPiFlg("X");
								}
							}
						}else{
							//Packing Instruction 완전 통과
							if("Y".equals(dgCgos[i].getImdgLmtQtyFlg())){
								scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("O");
								scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
								scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
							}else if("Y".equals(dgCgos[i].getImdgExptQtyFlg())){
								scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
								scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("O");
								scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
							}else{
								scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
								scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
								scgPrnrAproRqstCgoVOs[i].setPiFlg("O");
							}
						}
						
						if(scgPrnrAproRqstCgoVOs[i].getPiFlg().equals("N/A")){
							scgPrnrAproRqstCgoVOs[i].setPiFlg("O");
		        		}
		        		if(pckPreChkCd.equals("1")){
		        			pckPreChkCd = scgPrnrAproRqstCgoVOs[i].getPiFlg();
		        		} else {
		        			if(pckPreChkCd.equals("O")
		        					&& scgPrnrAproRqstCgoVOs[i].getPiFlg().equals("X")){
		        				pckPreChkCd = "X";
		        			}
		        			if(pckPreChkCd.equals("O")
		        					&& scgPrnrAproRqstCgoVOs[i].getPiFlg().equals("M")){
		        				pckPreChkCd = "M";
		        			}
		        		}  
		        		preRestrictionOutputVO.setPckChkRslt(pckPreChkCd);
					}	
				}
			
				if(preRestrictionOutputVO.getPckChkRslt() == null){
					preRestrictionOutputVO.setPckChkRslt("X");
				}			
			}			
			return preRestrictionOutputVO;
			
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report by VVD"}).getMessage(), ex);
		}
	}
	
	
	
	
	
	/**
	 * Pre Checking Report 를 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO) throws EventException {
		try {
			PreRestrictionOutputVO preRestrictionOutputVO = new PreRestrictionOutputVO();
			
			String f_cmd = preRestrictionInputVO.getInnerPreRestrictionInputVO().getFCmd();			
			if(Integer.toString(FormCommand.SEARCH01).equals(f_cmd)) {
				//Container 별  체크를 위한 Sortting
				PreRestrictionInputVO[] sortVO = preRestrictionInputVO.getInnerPreRestrictionInputVOS();
				PreRestrictionInputVO   tmpVO = null;
				String spclCntrSeq1 = "", spclCgoSeq1 = "";
				String spclCntrSeq2 = "", spclCgoSeq2 = "";
				for(int sortCt1=0; sortCt1 < sortVO.length; sortCt1++) {
					spclCntrSeq1 = sortVO[sortCt1].getSpclCntrSeq();
					spclCgoSeq1  = sortVO[sortCt1].getSpclCgoSeq();
					for(int sortCt2=sortCt1+1; sortCt2 < sortVO.length; sortCt2++) {
						spclCntrSeq2 = sortVO[sortCt2].getSpclCntrSeq();
						spclCgoSeq2  = sortVO[sortCt2].getSpclCgoSeq();
						if(Integer.parseInt(spclCntrSeq1) >= Integer.parseInt(spclCntrSeq2) && Integer.parseInt(spclCgoSeq1) > Integer.parseInt(spclCgoSeq2)) {
							tmpVO = sortVO[sortCt1]; 
							sortVO[sortCt1] = sortVO[sortCt2];
							sortVO[sortCt2] = tmpVO;
						}
					}
				}
				//Container 별 체크
				List<PreRestrictionSegregationVO> rsltVO = null;
				List<PreRestrictionSegregationVO> rtnVO  = new ArrayList<PreRestrictionSegregationVO>();
				spclCntrSeq1 = "";
				spclCntrSeq2 = "";
				int startNum = 0, endNum = 0;
				for(int addCt=0; addCt<sortVO.length; addCt++) {
					spclCntrSeq1 = sortVO[addCt].getSpclCntrSeq();
					if((!"".equals(spclCntrSeq2) && !spclCntrSeq1.equals(spclCntrSeq2)) || addCt == sortVO.length-1) {	
						endNum = addCt;
						if((spclCntrSeq1.equals(spclCntrSeq2) && addCt == sortVO.length-1) || addCt == 0) {
							endNum++;
						}
						preRestrictionInputVO.getInnerPreRestrictionInputVO().setStartNum(Integer.toString(startNum));
						preRestrictionInputVO.getInnerPreRestrictionInputVO().setEndNum(Integer.toString(endNum));
						rsltVO = dbDao.checkPreRestrictionSegregation(preRestrictionInputVO);
						
						String[] rmList = new String[rsltVO.size()];					
						for(int rsltCt=0; rsltCt<rsltVO.size(); rsltCt++) {
							for(int rmCt=rsltCt+1; rmCt<rsltVO.size(); rmCt++) {
								if(rsltVO.get(rsltCt).getSpclCntrSeq1().equals(rsltVO.get(rmCt).getSpclCntrSeq2())
								   && rsltVO.get(rsltCt).getSpclCgoSeq1().equals(rsltVO.get(rmCt).getSpclCgoSeq2())
								   && rsltVO.get(rsltCt).getImdgUnNo1().equals(rsltVO.get(rmCt).getImdgUnNo2())
								   && rsltVO.get(rsltCt).getImdgUnNoSeq1().equals(rsltVO.get(rmCt).getImdgUnNoSeq2())
								   && rsltVO.get(rsltCt).getSpclCntrSeq2().equals(rsltVO.get(rmCt).getSpclCntrSeq1())
								   && rsltVO.get(rsltCt).getSpclCgoSeq2().equals(rsltVO.get(rmCt).getSpclCgoSeq1())
								   && rsltVO.get(rsltCt).getImdgUnNo2().equals(rsltVO.get(rmCt).getImdgUnNo1())
								   && rsltVO.get(rsltCt).getImdgUnNoSeq2().equals(rsltVO.get(rmCt).getImdgUnNoSeq1())
								) 
								{
									rmList[rmCt] = "Y";
								}
							}
						}	
						
						/*
						 * 같은 쌍의 경우에도 모두 보여주기로 하여 주석처리함.
						 * for(int delCt=rmList.length-1; delCt >= 0; delCt--) {
							if("Y".equals(rmList[delCt])) rsltVO.remove(delCt);	
		        		}*/
						
						for(int rsltCt=0; rsltCt<rsltVO.size(); rsltCt++) {
							rtnVO.add(rsltVO.get(rsltCt));
						}
						
						startNum = addCt;
					}
					spclCntrSeq2 = spclCntrSeq1;
				}
				preRestrictionOutputVO.setPreRestrictionSegregationVOs(rtnVO);
			} else if(Integer.toString(FormCommand.SEARCH02).equals(f_cmd)) {
				
				/*
				 * 1. UN No.로 체크했을 경우 C(Excepted fm Class Prohibition, Target Lane에 포함되지 않은 VVD일 경우-타사제외)일 경우만 제외하고 Class로 재체크를 한다.
				 * 2. 두개의 체크 모두 Prohibition이 L,P,T인 경우만 목록으로 리턴한다.
				 */
				//1. 1차 Un No. 기준 Restriction
				preRestrictionInputVO.getInnerPreRestrictionInputVO().setOptClss("U");
				List<PreRestrictionVesselOperatorVO> preRestrictionVesselOperatorVOs = dbDao.checkPreRestrictionVesselOperator(preRestrictionInputVO);

				//2. 2차 Class 기준 Restriction
				Iterator<PreRestrictionVesselOperatorVO> rsltlist = preRestrictionVesselOperatorVOs.iterator();	
				ArrayList<Integer> expList 		= new ArrayList<Integer>();
				ArrayList<Integer> expLaneList 	= new ArrayList<Integer>();
				int expCt = 0;
				String restrictYn = "";
	        	while(rsltlist.hasNext()){
	        		PreRestrictionVesselOperatorVO vo = (PreRestrictionVesselOperatorVO)rsltlist.next();
	        		restrictYn = vo.getProhibitionCd();
	        		if(restrictYn == null || "".equals(restrictYn) || "R".equals(restrictYn)) {
        				expList.add(new Integer(expCt));
	        		}else if ("L".equals(restrictYn) || "C".equals(restrictYn)){  
	        			// 2013.11.06. BY 원종규 , C 일땐 	tndInputVOs 에서 제외되므로   상기 expCount(expList) 에서 제외한다. 	그렇지않으면 NULL 값 포함됨.
        				expLaneList.add(new Integer(expCt));	        			
	        		}
	        		expCt++;
	        	}	
	        	
	        	int expCount = expList.size();
	        	if(expCount > 0) {
		        	PreRestrictionInputVO[] tndInputVOs = null;
					PreRestrictionInputVO   tndInputVO  = null;
					PreRestrictionVesselOperatorVO tVO  = null;
					
					tndInputVOs = new PreRestrictionInputVO[expCount];
					expCt = 0;
		        	for(int delCt=0; delCt < expList.size(); delCt++) {
		        		
		        		tndInputVO = new PreRestrictionInputVO();
		        				        		
		        		tVO = preRestrictionVesselOperatorVOs.get(expList.get(delCt).intValue());		        		
		        		restrictYn = tVO.getProhibitionCd();
		        		
		        		if(!"C".equals(restrictYn)) {  				        			
			        		tndInputVO.setSpclCntrSeq(tVO.getSpclCntrSeq());
			        		tndInputVO.setSpclCgoSeq(tVO.getSpclCgoSeq());
			        		tndInputVO.setImdgUnNo(tVO.getImdgUnNo());
			        		tndInputVO.setImdgUnNoSeq(tVO.getImdgUnNoSeq());
			        		tndInputVO.setImdgClssCd(tVO.getImdgClssCd());
			        		tndInputVO.setVslCd(tVO.getVslCd());
			        		tndInputVO.setSkdVoyNo(tVO.getSkdVoyNo());
			        		tndInputVO.setSkdDirCd(tVO.getSkdDirCd());
			        		tndInputVO.setCrrCd(tVO.getCrrCd());
			        		tndInputVO.setSlanCd(tVO.getSlanCd());
			        		
			        		tndInputVOs[expCt++] = tndInputVO;
		        		}
	        		}
		        	
		        	if(!"C".equals(restrictYn)) {    //C 가 아닌 경우만 CLASS 로 재 조회를 하고 PORT 로 조회한다.  
		        		preRestrictionInputVO.setInnerPreRestrictionInputVOS(tndInputVOs);
		        	}
		        	
		        	for(int delCt=expCount-1; delCt >= 0; delCt--) {		        		
		        		restrictYn = preRestrictionVesselOperatorVOs.get(expList.get(delCt).intValue()).getProhibitionCd();		        		
			        	if (!"P".equals(restrictYn) && !"R".equals(restrictYn)) {   //C 일땐 UN NO 로 조회한 ROW를 제거해서 화면에 안보이게
			        			preRestrictionVesselOperatorVOs.remove(expList.get(delCt).intValue());
			        		}
	        		}
		        	
		        	preRestrictionInputVO.getInnerPreRestrictionInputVO().setOptClss("C");
		        	List<PreRestrictionVesselOperatorVO> tndVOs = dbDao.checkPreRestrictionVesselOperator(preRestrictionInputVO);
		        
		        	Iterator<PreRestrictionVesselOperatorVO> tndRsltlist = tndVOs.iterator();	
		        	while(tndRsltlist.hasNext()){
		        		PreRestrictionVesselOperatorVO vo = (PreRestrictionVesselOperatorVO)tndRsltlist.next();
			        	//VVD가 2개 이상일때 UN으로 Check된 내용이 우선이므로 Class로 Check된 내용을 삭제한다.  UN NO 로 체크된 ROW와 같을때만 CLASS 체크ROW를 추가한다.
		        		for(int delCt=0; delCt < expCt; delCt++) {
			        		if (tndInputVOs[delCt].getSpclCntrSeq().equals(vo.getSpclCntrSeq()) 
			        			&& tndInputVOs[delCt].getSpclCgoSeq().equals(vo.getSpclCgoSeq()) 
			        			&& tndInputVOs[delCt].getImdgUnNo().equals(vo.getImdgUnNo()) 
			        			&& tndInputVOs[delCt].getImdgUnNoSeq().equals(vo.getImdgUnNoSeq()) 
			        			&& tndInputVOs[delCt].getVslCd().equals(vo.getVslCd()) 
			        			&& tndInputVOs[delCt].getSkdVoyNo().equals(vo.getSkdVoyNo()) 
			        			&& tndInputVOs[delCt].getSkdDirCd().equals(vo.getSkdDirCd()) 
			        			&& tndInputVOs[delCt].getCrrCd().equals(vo.getCrrCd()) ) {
		        				preRestrictionVesselOperatorVOs.add(vo);
			        		}
			        	}
		        	}
	        	}
	        	
				preRestrictionOutputVO.setPreRestrictionVesselOperatorVOs(preRestrictionVesselOperatorVOs);
				preRestrictionOutputVO.setPreRestrictionPortVOs(dbDao.checkPreRestrictionPort(preRestrictionInputVO));
				
			}else if(Integer.toString(FormCommand.SEARCH05).equals(f_cmd)) {
				preRestrictionOutputVO.setPreRestrictionPortVOs(dbDao.checkPreRestrictionPort(preRestrictionInputVO));
			}else if(Integer.toString(FormCommand.SEARCH03).equals(f_cmd)) {
				List<PreRestrictionRegulatoryVO> preRestrictionRegulatoryVOs = new ArrayList<PreRestrictionRegulatoryVO>();
				List<PreRestrictionInvalidReasonDetailVO> preRestrictionInvalidReasonDetailVOs = new ArrayList<PreRestrictionInvalidReasonDetailVO>();
				List<PreRestrictionSppDetailVO> preRestrictionSppDetailVOs = new ArrayList<PreRestrictionSppDetailVO>();
				
				PreRestrictionInputVO inputVO = preRestrictionInputVO.getInnerPreRestrictionInputVO();
				/*
				 * 1. LQ/EQ flag를 체크하여 해당할 경우 해당 규정을 적용한다.
				 * 2. LQ/EQ가 아닐 경우 일반 규정을 적용한다.
				 */
				if("Y".equals(inputVO.getImdgLmtQtyFlg())){
					preRestrictionRegulatoryVOs = dbDao.checkPreRestrictionLQRegulatory(inputVO);
					preRestrictionInvalidReasonDetailVOs = dbDao.checkPreRestrictionLQInvalidReasonDetail(inputVO);
				}else if("Y".equals(inputVO.getImdgExptQtyFlg())){
					preRestrictionRegulatoryVOs = dbDao.checkPreRestrictionEQRegulatory(inputVO);
					preRestrictionInvalidReasonDetailVOs = dbDao.checkPreRestrictionEQInvalidReasonDetail(inputVO);
				}else{
					if(inputVO.getOutImdgPckCd1() != null && !"".equals(inputVO.getOutImdgPckCd1())){
						String pckDivCd = "";
						String pckStyCd = "";
						String outImdgPckCd1 = inputVO.getOutImdgPckCd1().substring(0, 2);
						//outer package code로 package 형식을 판별
						if("11".equals(outImdgPckCd1) || "13".equals(outImdgPckCd1) || "21".equals(outImdgPckCd1) || "31".equals(outImdgPckCd1)){
							//IBC
							pckDivCd = "I";
						}else if("50".equals(outImdgPckCd1) || "51".equals(outImdgPckCd1)){
							//LP
							pckDivCd = "L";
						}else{
							outImdgPckCd1 = inputVO.getOutImdgPckCd1().substring(0, 1);
							if("1".equals(outImdgPckCd1) || "2".equals(outImdgPckCd1) || "3".equals(outImdgPckCd1) || "4".equals(outImdgPckCd1) || "5".equals(outImdgPckCd1) || "6".equals(outImdgPckCd1)){
								//P
								pckDivCd = "P";
							}else{
								//그 밖의 경우(판단 불가, inner/intermediate 용 용기 코드 잘못 들어온 경우 etc)
								pckDivCd = "E";
							}
						}
						inputVO.setPckDivCd(pckDivCd);
						
						//Combine or Single package 판별   //W: C,S 로직 분기 상세화
						if(inputVO.getInImdgPckCd1() != null && !"".equals(inputVO.getInImdgPckCd1())){
							pckStyCd = "C";
						}else{
							pckStyCd = "S";
						}
						inputVO.setPckStyCd(pckStyCd);
					}else{
						inputVO.setPckDivCd("E");
					}
					
					String sVldChk[] = new String[50];
					String pVldChk[] = new String[50];
					String[] allVldChk = new String[100];

					List<PreRestrictionSpclProviVO> spclProviVOS  = new ArrayList<PreRestrictionSpclProviVO>();
					PreRestrictionSpclProviVO spclProviVO = new PreRestrictionSpclProviVO();
					PreRestrictionSpclProviVO spclProviCondVO = new PreRestrictionSpclProviVO();
					spclProviVOS = dbDao.searchPreRestrictionSpclProvi(inputVO);	//조건절 제외한 결과절만 체크(불일치)
					
					
					if("E".equals(inputVO.getPckDivCd())){
						allVldChk[0] = "COP"+"|"+inputVO.getOutImdgPckCd1()+"|";  // admin / error msg 에 정의  COP -> PGI
					}else{
						if(spclProviVOS.size() > 0){
							
							for(int i = 0; i < spclProviVOS.size(); i++){		
								spclProviVO = spclProviVOS.get(i);
								
								if("M".equals(spclProviVO.getPrmtChkCd())){			//'M' 인 경우 조건절이 일치하며 결과 절이 불일치하면 INVALID 이므로 별도 체크
									sVldChk[i] = spclProviVO.getSpclPckProviDivCd()+"SI"+"|"+spclProviVO.getImdgPckInstrCd()+"|"+spclProviVO.getImdgUnNo()+"|";
								}else if("Y".equals(spclProviVO.getGrpN1stUseFlg())){						//GRP_I_USE_FLG 가 'Y'인 경우 해당 그룹의 PI 체크
									inputVO.setImdgPckGrpCd("1");
									pVldChk = dbDao.searchPreRestrictionPckPkgInstr(inputVO);
								}else if("Y".equals(spclProviVO.getGrpN2ndUseFlg())){						//GRP_II_USE_FLG 가 'Y'인 경우 해당 그룹의 PI 체크
									inputVO.setImdgPckGrpCd("2");
									pVldChk = dbDao.searchPreRestrictionPckPkgInstr(inputVO);
								}else if("Y".equals(spclProviVO.getGrpN3rdUseFlg())){						//GRP_III_USE_FLG 가 'Y'인 경우 해당 그룹의 PI 체크
									inputVO.setImdgPckGrpCd("3");
									pVldChk = dbDao.searchPreRestrictionPckPkgInstr(inputVO);
								}else{				//그 외의 경우 조건절 존재/일치 확인
									spclProviCondVO = dbDao.searchPreRestrictionSpclProviCond(spclProviVO);
									
									if(spclProviCondVO != null){
										if("P".equals(spclProviCondVO.getPrmtChkCd())){    // getImdgPckInstrCd
											sVldChk[i] = spclProviVO.getSpclPckProviDivCd()+"SI"+"|"+spclProviVO.getImdgPckInstrCd()+"|"+spclProviVO.getImdgUnNo()+"|";
											
										}else if("A".equals(spclProviCondVO.getPrmtChkCd()) || "M".equals(spclProviCondVO.getPrmtChkCd())){
											sVldChk[i] = "V";
										}else{
											sVldChk[i] = "CSP";
										}
									}									
							                     //SPP 체크후에 PckPkgInstr 체크하기
										pVldChk = dbDao.searchPreRestrictionPckPkgInstr(inputVO);
										
								}
								
								allVldChk[i] = sVldChk[i];																
								for(int j=0; j<pVldChk.length; j++)
								{											
									allVldChk[j+i+1] = pVldChk[j];
								}
								
							}
						}else{			//SPP에 일치하는 결과 없을 경우 PI 체크
							allVldChk = dbDao.searchPreRestrictionPckPkgInstr(inputVO);
						}
					}
					
									
					  preRestrictionRegulatoryVOs = dbDao.checkPreRestrictionPIRegulatory(allVldChk, inputVO);
					  preRestrictionInvalidReasonDetailVOs = dbDao.checkPreRestrictionPIInvalidReasonDetail(allVldChk, inputVO);
					  preRestrictionSppDetailVOs = dbDao.searchPreRestrictionpiSppDetail(inputVO);
					
				} 
	        	
				preRestrictionOutputVO.setPreRestrictionRegulatoryVOs(preRestrictionRegulatoryVOs);
				preRestrictionOutputVO.setPreRestrictionInvalidReasonDetailVOs(preRestrictionInvalidReasonDetailVOs);
				preRestrictionOutputVO.setPreRestrictionSppDetailVOs(preRestrictionSppDetailVOs);
			}
			
			return preRestrictionOutputVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Pre Checking Report"}).getMessage(), ex);
		}
	}
	
	/**
	 * Pre Checking Report summary 을 조회 합니다. <br>
	 * 
	 * @param  PreRestrictionInputVO preRestrictionInputVO
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO searchPreCheckingSummaryList(PreRestrictionInputVO preRestrictionInputVO) throws EventException {
		try {
			PreRestrictionOutputVO preRestrictionOutputVO = new PreRestrictionOutputVO();
			ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs = preRestrictionInputVO.getInnerScgPrnrAproRqstCgoVOS();
			PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();
			List<ScgPrnrAproRqstCgoVO> outScgPrnrAproRqstCgoVOs = new ArrayList<ScgPrnrAproRqstCgoVO>();
			List<PreRestrictionMtdItemVO> preRestrictionMtdItemVOs = new ArrayList<PreRestrictionMtdItemVO>();
			
			//Segrigation check
			String f_cmd = Integer.toString(FormCommand.SEARCH01);
			preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(f_cmd);	
			PreRestrictionOutputVO segOutputVO = checkPreRestriction(preRestrictionInputVO);
			List<PreRestrictionSegregationVO> preRestrictionSegregationVO = segOutputVO.getPreRestrictionSegregationVOs();
			
			//Vessel Operation check
			f_cmd = Integer.toString(FormCommand.SEARCH02);
			preRestrictionInputVO.getInnerPreRestrictionInputVO().setFCmd(f_cmd);	
			PreRestrictionOutputVO vslOutputVO = checkPreRestriction(preRestrictionInputVO);
			List<PreRestrictionVesselOperatorVO> preRestrictionVesselOperatorVOs = vslOutputVO.getPreRestrictionVesselOperatorVOs();
			List<PreRestrictionPortVO> preRestrictionPortVOs = vslOutputVO.getPreRestrictionPortVOs();
			
			
			for(int i = 0; i < scgPrnrAproRqstCgoVOs.length; i++){
				//Segrigation check result
				int segChk = 0;
				for(int segCnt = 0; segCnt < preRestrictionSegregationVO.size(); segCnt++){
					if(preRestrictionSegregationVO.get(segCnt).getSpclCntrSeq1().equals(scgPrnrAproRqstCgoVOs[i].getSpclCntrSeq()) && preRestrictionSegregationVO.get(segCnt).getSpclCgoSeq1().equals(scgPrnrAproRqstCgoVOs[i].getSpclCgoSeq())){
						segChk++;
					}
				}
				if(segChk > 0){
					scgPrnrAproRqstCgoVOs[i].setSegFlg("X");
				}else{
					scgPrnrAproRqstCgoVOs[i].setSegFlg("O");
				}
				
				//vsl operator check result
				int vslOptChk = 0;
				int vslOptRestrictedChk = 0;
				int vslOptNotRestrictedChk = 0;
				for(int vslOptCnt = 0; vslOptCnt < preRestrictionVesselOperatorVOs.size(); vslOptCnt++){
					if(preRestrictionVesselOperatorVOs.get(vslOptCnt).getSpclCntrSeq().equals(scgPrnrAproRqstCgoVOs[i].getSpclCntrSeq()) && preRestrictionVesselOperatorVOs.get(vslOptCnt).getSpclCgoSeq().equals(scgPrnrAproRqstCgoVOs[i].getSpclCgoSeq())){
						vslOptChk++;
					}
					
					if("UN No. - Restricted".equals(preRestrictionVesselOperatorVOs.get(vslOptCnt).getProhibitionDesc())){
						vslOptRestrictedChk++;
					}
					if("UN No. - Prohibited".equals(preRestrictionVesselOperatorVOs.get(vslOptCnt).getProhibitionDesc())){
						vslOptNotRestrictedChk++;
					}
				}

				if(vslOptNotRestrictedChk > 0){
					vslOptRestrictedChk = 0;
				}
				
				if(vslOptChk > 0){
					scgPrnrAproRqstCgoVOs[i].setCrrFlg("X");
					if(vslOptRestrictedChk > 0){
						scgPrnrAproRqstCgoVOs[i].setCrrFlg("R");
					}
				}else{
					scgPrnrAproRqstCgoVOs[i].setCrrFlg("O");
//					if(vslOptRestrictedChk > 0){
//						scgPrnrAproRqstCgoVOs[i].setCrrFlg("R");
//					}
				}
				
				
				//vsl port check result 
				int vslPortChk = 0;
				int vslPortPermitChk = 0;
				int vslPortNotPermitChk = 0;
				for(int vslPortCnt = 0; vslPortCnt < preRestrictionPortVOs.size(); vslPortCnt++){
					if(preRestrictionPortVOs.get(vslPortCnt).getSpclCntrSeq().equals(scgPrnrAproRqstCgoVOs[i].getSpclCntrSeq()) && preRestrictionPortVOs.get(vslPortCnt).getSpclCgoSeq().equals(scgPrnrAproRqstCgoVOs[i].getSpclCgoSeq())){
						vslPortChk++;
						
						if("Permit".equals(preRestrictionPortVOs.get(vslPortCnt).getRestictionReq())){
							vslPortPermitChk++;
						}
						if("Prohibition".equals(preRestrictionPortVOs.get(vslPortCnt).getRestictionReq())){
							vslPortNotPermitChk++;
						}
						if("Prohibition".equals(preRestrictionPortVOs.get(vslPortCnt).getColumnValues().get("imdg_cmptn_auth_desc"))){
							vslPortNotPermitChk++;
						}
					}
				}
				if(vslPortNotPermitChk > 0){
					vslPortPermitChk = 0;
				}
				if(vslPortChk > 0){
					scgPrnrAproRqstCgoVOs[i].setPortFlg("X");
					if(vslPortPermitChk > 0){
						scgPrnrAproRqstCgoVOs[i].setPortFlg("R");
					}
				}else{
					scgPrnrAproRqstCgoVOs[i].setPortFlg("O");
				}
				
				//packing instruction check result
				//partner BKG와 Own BKG의 변수 이름이 다른 관계로 세팅
				f_cmd = Integer.toString(FormCommand.SEARCH03);
				preRestrictionInputVOs[i].setFCmd(f_cmd);
				if(preRestrictionInputVOs[i].getOutImdgPckCd1() == null || "".equals(preRestrictionInputVOs[i].getOutImdgPckCd1())){
					preRestrictionInputVOs[i].setOutImdgPckQty1(scgPrnrAproRqstCgoVOs[i].getOutN1stImdgPckQty());
					preRestrictionInputVOs[i].setOutImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getOutN1stImdgPckCd());
					preRestrictionInputVOs[i].setIntmdImdgPckQty1(scgPrnrAproRqstCgoVOs[i].getIntmdN1stImdgPckQty());
					preRestrictionInputVOs[i].setIntmdImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getIntmdN1stImdgPckCd());
					preRestrictionInputVOs[i].setInImdgPckQty1(scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckQty());
					preRestrictionInputVOs[i].setInImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckCd());
					preRestrictionInputVOs[i].setInImdgPckCd1(scgPrnrAproRqstCgoVOs[i].getInN1stImdgPckCd());
				}else{
					scgPrnrAproRqstCgoVOs[i].setOutN1stImdgPckQty(preRestrictionInputVOs[i].getOutImdgPckQty1());
					scgPrnrAproRqstCgoVOs[i].setOutN1stImdgPckCd(preRestrictionInputVOs[i].getOutImdgPckCd1());
					scgPrnrAproRqstCgoVOs[i].setIntmdN1stImdgPckQty(preRestrictionInputVOs[i].getIntmdImdgPckQty1());
					scgPrnrAproRqstCgoVOs[i].setIntmdN1stImdgPckCd(preRestrictionInputVOs[i].getIntmdImdgPckCd1());
					scgPrnrAproRqstCgoVOs[i].setInN1stImdgPckQty(preRestrictionInputVOs[i].getInImdgPckQty1());
					scgPrnrAproRqstCgoVOs[i].setInN1stImdgPckCd(preRestrictionInputVOs[i].getInImdgPckCd1());
				}
				
				if(scgPrnrAproRqstCgoVOs[i].getEmerCntcPhnNoCtnt() != null && !"".equals(scgPrnrAproRqstCgoVOs[i].getEmerCntcPhnNoCtnt())){
					scgPrnrAproRqstCgoVOs[i].setEmerCntcPhnNo(scgPrnrAproRqstCgoVOs[i].getEmerCntcPhnNoCtnt());
				}

				PreRestrictionInputVO packInstrInputVO = new PreRestrictionInputVO();
				packInstrInputVO.setInnerPreRestrictionInputVO(preRestrictionInputVOs[i]);
				PreRestrictionOutputVO piOutputVO = checkPreRestriction(packInstrInputVO);
//				int sppCnt = piOutputVO.getPreRestrictionSppDetailVOs().size();
				int rsnDtlCnt = piOutputVO.getPreRestrictionInvalidReasonDetailVOs().size();
				String pkgTp = "";
				for(int pk = 0; pk <piOutputVO.getPreRestrictionRegulatoryVOs().size(); pk++){
					//PreRestrictionRegulatoryVO regulatoryVO = null;
					String div = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getDivNm();
					String piWgtRslt = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getMaxWgtRslt();
					//String pkgTpNm = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getPkgTpNm();
					String pkgTpRslt = piOutputVO.getPreRestrictionRegulatoryVOs().get(pk).getPkgTpRslt();
					if ("Packing Instruction".equals(div) && "N/A".equals(pkgTpRslt) && !("Invalid".equals(piWgtRslt)) ){
						 pkgTp = "N" ;
					}
				}
				
				
				if(rsnDtlCnt > 0){			//Packing Instruction invaild
					if("Y".equals(preRestrictionInputVOs[i].getImdgLmtQtyFlg())){
						scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("X");
						scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
						scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
					}else if("Y".equals(preRestrictionInputVOs[i].getImdgExptQtyFlg())){
						scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
						scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("X");
						scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
					}else{
						scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
						scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
						if ("N".equals(pkgTp)){
						    scgPrnrAproRqstCgoVOs[i].setPiFlg("M");
						}else{
							scgPrnrAproRqstCgoVOs[i].setPiFlg("X");
						}
					}
				}else{
// 2013.07.06 KIM HYUN HWA "C" 표기 제외함.					
//					if(sppCnt > 0){				//Packing Instruction은 vaild 이나 Special Provision 존재하여 사용자의 manual checking이 필요한 부분
//						if("Y".equals(preRestrictionInputVOs[i].getImdgLmtQtyFlg())){
//							scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("C");
//							scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
//							scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
//						}else if("Y".equals(preRestrictionInputVOs[i].getImdgExptQtyFlg())){
//							scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
//							scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("C");
//							scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
//						}else{
//							scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
//							scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
//							scgPrnrAproRqstCgoVOs[i].setPiFlg("C");
//						}
//					}else{						//Packing Instruction 완전 통과
						if("Y".equals(preRestrictionInputVOs[i].getImdgLmtQtyFlg())){
							scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("O");
							scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
							scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
						}else if("Y".equals(preRestrictionInputVOs[i].getImdgExptQtyFlg())){
							scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
							scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("O");
							scgPrnrAproRqstCgoVOs[i].setPiFlg("N/A");
						}else{
							scgPrnrAproRqstCgoVOs[i].setLtdQtyFlg("N/A");
							scgPrnrAproRqstCgoVOs[i].setExptQtyFlg("N/A");
							scgPrnrAproRqstCgoVOs[i].setPiFlg("O");
						}
//					}
				}
				
				//mandatory item check
				List<PreRestrictionMtdItemVO> tempPreRestrictionMtdItemVOs = dbDao.searchPreRestrictionMtdItemList(scgPrnrAproRqstCgoVOs[i]);
				if(tempPreRestrictionMtdItemVOs.size() > 0){
					scgPrnrAproRqstCgoVOs[i].setMdtFlg("X");
					preRestrictionMtdItemVOs.addAll(tempPreRestrictionMtdItemVOs);
				}else{
					scgPrnrAproRqstCgoVOs[i].setMdtFlg("O");
				}
				
				outScgPrnrAproRqstCgoVOs.add(scgPrnrAproRqstCgoVOs[i]);
			}
			
			preRestrictionOutputVO.setPreRestrictionMtdItemVOs(preRestrictionMtdItemVOs);
			preRestrictionOutputVO.setScgPrnrAproRqstCgoVOs(outScgPrnrAproRqstCgoVOs);
			return preRestrictionOutputVO;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dangerous CGO Application Details for Partner Lines"}).getMessage(), ex);
		}
	}	
	
}

