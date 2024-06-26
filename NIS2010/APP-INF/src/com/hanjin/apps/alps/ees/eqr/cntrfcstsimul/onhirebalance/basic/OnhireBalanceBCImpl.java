/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireBalanceBCImpl.java
*@FileTitle : On-Hire Status
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.05 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration.OnhireBalanceDBDAO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrCtrlOnhOrdQtyVO;
import com.hanjin.syscommon.common.table.EqrCtrlOnhOrdVO;
import com.hanjin.syscommon.common.table.EqrCtrlOnhPlnAproQtyVO;
import com.hanjin.syscommon.common.table.EqrCtrlOnhPlnAproVO;

/**
 * ALPS-CntrFcstSimul Business Logic Command Interface<br>
 * - ALPS-CntrFcstSimul에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dong-sun Moon
 * @see
 * @since J2EE 1.6
 */
public class OnhireBalanceBCImpl extends BasicCommandSupport implements OnhireBalanceBC {

	// Database Access Object
	private transient OnhireBalanceDBDAO dbDao = null;

	/**
	 * OnhireBalanceBCImpl 객체 생성<br>
	 * OnhireBalanceDBDAO를 생성한다.<br>
	 */
	public OnhireBalanceBCImpl() {
		dbDao = new OnhireBalanceDBDAO();
	}
	
	/**
	 * On hire Status 데이터를 조회 합니다.<br>
	 * 
	 * @param OnhireStatusVO onhireStatusVO
	 * @return List<OnhireStatusVO>
	 * @exception EventException
	 */
	public List<OnhireStatusVO> searchOnhireStatusBasic(OnhireStatusVO onhireStatusVO) throws EventException {
		try {
			List<OnhireStatusVO> list = null;
			List<OnhireStatusVO> result = new ArrayList<OnhireStatusVO>();
			
			list =	dbDao.searchOnhireStatusData(onhireStatusVO);
			
			OnhireStatusVO nowVO = null;   // 현재 Row의 VO. 계산은 하지 않고 LCC,Year,Term 이 바뀌는를 확인만 함 
			OnhireStatusVO preVO = null;   // 직전 Row의 VO. 
			OnhireStatusVO putVO = null;   // return List 에 담기 위한 VO
			OnhireStatusVO countVO = null; // APPR/RSLT 를 Row 별로 분배하는 걸 세기 위한 VO
			
			if(list.size() > 0){

				preVO = (OnhireStatusVO)list.get(0).clone();
				countVO = (OnhireStatusVO)list.get(0).clone();
				putVO = (OnhireStatusVO)list.get(0).clone();

				for(int i=1; i<list.size(); i++){
					nowVO = (OnhireStatusVO)list.get(i).clone();
					
					if(nowVO.getRccCd().equals(preVO.getRccCd()) && nowVO.getLccCd().equals(preVO.getLccCd()) 
							&& nowVO.getOnhOrdYr().equals(preVO.getOnhOrdYr()) && nowVO.getEqLstmCd().equals(preVO.getEqLstmCd()) ){ // merge 영역 그대로, (countVO 잔량 내에서) Row 에 ORDER 만큼 APPR/RSLT 배분
						// Aproval 
						if(Integer.parseInt(countVO.getApprD2Qty()) > Integer.parseInt(preVO.getOrderD2Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setApprD2Qty(preVO.getOrderD2Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setApprD2Qty(Integer.toString(Integer.parseInt(countVO.getApprD2Qty())-Integer.parseInt(preVO.getOrderD2Qty())));
						}else{
							putVO.setApprD2Qty(countVO.getApprD2Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setApprD2Qty("0");
						}
						
						if(Integer.parseInt(countVO.getApprD4Qty()) > Integer.parseInt(preVO.getOrderD4Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setApprD4Qty(preVO.getOrderD4Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setApprD4Qty(Integer.toString(Integer.parseInt(countVO.getApprD4Qty())-Integer.parseInt(preVO.getOrderD4Qty())));
						}else{
							putVO.setApprD4Qty(countVO.getApprD4Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setApprD4Qty("0");
						}
						
						if(Integer.parseInt(countVO.getApprD5Qty()) > Integer.parseInt(preVO.getOrderD5Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setApprD5Qty(preVO.getOrderD5Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setApprD5Qty(Integer.toString(Integer.parseInt(countVO.getApprD5Qty())-Integer.parseInt(preVO.getOrderD5Qty())));
						}else{
							putVO.setApprD5Qty(countVO.getApprD5Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setApprD5Qty("0");
						}
						
						if(Integer.parseInt(countVO.getApprD7Qty()) > Integer.parseInt(preVO.getOrderD7Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setApprD7Qty(preVO.getOrderD7Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setApprD7Qty(Integer.toString(Integer.parseInt(countVO.getApprD7Qty())-Integer.parseInt(preVO.getOrderD7Qty())));
						
						}else{
							putVO.setApprD7Qty(countVO.getApprD7Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setApprD7Qty("0");
						}
						if(Integer.parseInt(countVO.getApprR2Qty()) > Integer.parseInt(preVO.getOrderR2Qty())){ 
							putVO.setApprR2Qty(preVO.getOrderR2Qty()); 
							countVO.setApprR2Qty(Integer.toString(Integer.parseInt(countVO.getApprR2Qty())-Integer.parseInt(preVO.getOrderR2Qty())));
						}else{
							putVO.setApprR2Qty(countVO.getApprR2Qty()); 
							countVO.setApprR2Qty("0");
						}
						if(Integer.parseInt(countVO.getApprR5Qty()) > Integer.parseInt(preVO.getOrderR5Qty())){ 
							putVO.setApprR5Qty(preVO.getOrderR5Qty()); 
							countVO.setApprR5Qty(Integer.toString(Integer.parseInt(countVO.getApprR5Qty())-Integer.parseInt(preVO.getOrderR5Qty())));
						}else{
							putVO.setApprR5Qty(countVO.getApprR5Qty()); 
							countVO.setApprR5Qty("0");
						}
						if(Integer.parseInt(countVO.getApprR9Qty()) > Integer.parseInt(preVO.getOrderR9Qty())){ 
							putVO.setApprR9Qty(preVO.getOrderR9Qty()); 
							countVO.setApprR9Qty(Integer.toString(Integer.parseInt(countVO.getApprR9Qty())-Integer.parseInt(preVO.getOrderR9Qty())));
						}else{
							putVO.setApprR9Qty(countVO.getApprR9Qty()); 
							countVO.setApprR9Qty("0");
						}		

						if(Integer.parseInt(countVO.getApprF2Qty()) > Integer.parseInt(preVO.getOrderF2Qty())){ 
							putVO.setApprF2Qty(preVO.getOrderF2Qty()); 
							countVO.setApprF2Qty(Integer.toString(Integer.parseInt(countVO.getApprF2Qty())-Integer.parseInt(preVO.getOrderF2Qty())));
						}else{
							putVO.setApprF2Qty(countVO.getApprF2Qty()); 
							countVO.setApprF2Qty("0");
						}
						if(Integer.parseInt(countVO.getApprF4Qty()) > Integer.parseInt(preVO.getOrderF4Qty())){ 
							putVO.setApprF4Qty(preVO.getOrderF4Qty()); 
							countVO.setApprF4Qty(Integer.toString(Integer.parseInt(countVO.getApprF4Qty())-Integer.parseInt(preVO.getOrderF4Qty())));
						}else{
							putVO.setApprF4Qty(countVO.getApprF4Qty()); 
							countVO.setApprF4Qty("0");
						}
						if(Integer.parseInt(countVO.getApprF5Qty()) > Integer.parseInt(preVO.getOrderF5Qty())){ 
							putVO.setApprF5Qty(preVO.getOrderF5Qty()); 
							countVO.setApprF5Qty(Integer.toString(Integer.parseInt(countVO.getApprF5Qty())-Integer.parseInt(preVO.getOrderF5Qty())));
						}else{
							putVO.setApprF5Qty(countVO.getApprF5Qty()); 
							countVO.setApprF5Qty("0");
						}						

						if(Integer.parseInt(countVO.getApprS2Qty()) > Integer.parseInt(preVO.getOrderS2Qty())){ 
							putVO.setApprS2Qty(preVO.getOrderS2Qty()); 
							countVO.setApprS2Qty(Integer.toString(Integer.parseInt(countVO.getApprS2Qty())-Integer.parseInt(preVO.getOrderS2Qty())));
						}else{
							putVO.setApprS2Qty(countVO.getApprS2Qty()); 
							countVO.setApprS2Qty("0");
						}
						if(Integer.parseInt(countVO.getApprS4Qty()) > Integer.parseInt(preVO.getOrderS4Qty())){ 
							putVO.setApprS4Qty(preVO.getOrderS4Qty()); 
							countVO.setApprS4Qty(Integer.toString(Integer.parseInt(countVO.getApprS4Qty())-Integer.parseInt(preVO.getOrderS4Qty())));
						}else{
							putVO.setApprS4Qty(countVO.getApprS4Qty()); 
							countVO.setApprS4Qty("0");
						}

						if(Integer.parseInt(countVO.getApprO2Qty()) > Integer.parseInt(preVO.getOrderO2Qty())){ 
							putVO.setApprO2Qty(preVO.getOrderO2Qty()); 
							countVO.setApprO2Qty(Integer.toString(Integer.parseInt(countVO.getApprO2Qty())-Integer.parseInt(preVO.getOrderO2Qty())));
						}else{
							putVO.setApprO2Qty(countVO.getApprO2Qty()); 
							countVO.setApprO2Qty("0");
						}
						if(Integer.parseInt(countVO.getApprO4Qty()) > Integer.parseInt(preVO.getOrderO4Qty())){ 
							putVO.setApprO4Qty(preVO.getOrderO4Qty()); 
							countVO.setApprO4Qty(Integer.toString(Integer.parseInt(countVO.getApprO4Qty())-Integer.parseInt(preVO.getOrderO4Qty())));
						}else{
							putVO.setApprO4Qty(countVO.getApprO4Qty()); 
							countVO.setApprO4Qty("0");
						}	
						
						if(Integer.parseInt(countVO.getApprO5Qty()) > Integer.parseInt(preVO.getOrderO5Qty())){ 
							putVO.setApprO5Qty(preVO.getOrderO5Qty()); 
							countVO.setApprO5Qty(Integer.toString(Integer.parseInt(countVO.getApprO5Qty())-Integer.parseInt(preVO.getOrderO5Qty())));
						}else{
							putVO.setApprO5Qty(countVO.getApprO5Qty()); 
							countVO.setApprO5Qty("0");
						}							
						
						if(Integer.parseInt(countVO.getApprO5Qty()) > Integer.parseInt(preVO.getOrderO5Qty())){ 
							putVO.setApprO5Qty(preVO.getOrderO5Qty()); 
							countVO.setApprO5Qty(Integer.toString(Integer.parseInt(countVO.getApprO5Qty())-Integer.parseInt(preVO.getOrderO5Qty())));
						}else{
							putVO.setApprO5Qty(countVO.getApprO5Qty()); 
							countVO.setApprO5Qty("0");
						}						
						
						if(Integer.parseInt(countVO.getApprA2Qty()) > Integer.parseInt(preVO.getOrderA2Qty())){ 
							putVO.setApprA2Qty(preVO.getOrderA2Qty()); 
							countVO.setApprA2Qty(Integer.toString(Integer.parseInt(countVO.getApprA2Qty())-Integer.parseInt(preVO.getOrderA2Qty())));
						}else{
							putVO.setApprA2Qty(countVO.getApprA2Qty()); 
							countVO.setApprA2Qty("0");
						}
						if(Integer.parseInt(countVO.getApprA4Qty()) > Integer.parseInt(preVO.getOrderA4Qty())){ 
							putVO.setApprA4Qty(preVO.getOrderA4Qty()); 
							countVO.setApprA4Qty(Integer.toString(Integer.parseInt(countVO.getApprA4Qty())-Integer.parseInt(preVO.getOrderA4Qty())));
						}else{
							putVO.setApprA4Qty(countVO.getApprA4Qty()); 
							countVO.setApprA4Qty("0");
						}					
						
						// Result
						if(Integer.parseInt(countVO.getRsltD2Qty()) > Integer.parseInt(preVO.getOrderD2Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setRsltD2Qty(preVO.getOrderD2Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setRsltD2Qty(Integer.toString(Integer.parseInt(countVO.getRsltD2Qty())-Integer.parseInt(preVO.getOrderD2Qty())));
						}else{
							putVO.setRsltD2Qty(countVO.getRsltD2Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setRsltD2Qty("0");
						}
						
						if(Integer.parseInt(countVO.getRsltD4Qty()) > Integer.parseInt(preVO.getOrderD4Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setRsltD4Qty(preVO.getOrderD4Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setRsltD4Qty(Integer.toString(Integer.parseInt(countVO.getRsltD4Qty())-Integer.parseInt(preVO.getOrderD4Qty())));
						}else{
							putVO.setRsltD4Qty(countVO.getRsltD4Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setRsltD4Qty("0");
						}
						
						if(Integer.parseInt(countVO.getRsltD5Qty()) > Integer.parseInt(preVO.getOrderD5Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setRsltD5Qty(preVO.getOrderD5Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setRsltD5Qty(Integer.toString(Integer.parseInt(countVO.getRsltD5Qty())-Integer.parseInt(preVO.getOrderD5Qty())));
						}else{
							putVO.setRsltD5Qty(countVO.getRsltD5Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setRsltD5Qty("0");
						}
						
						if(Integer.parseInt(countVO.getRsltD7Qty()) > Integer.parseInt(preVO.getOrderD7Qty())){ // countVO 가 ORDER 이상 남아 있으면
							putVO.setRsltD7Qty(preVO.getOrderD7Qty()); // ORDER 만큼 넣고, countVO 에서 뺌
							countVO.setRsltD7Qty(Integer.toString(Integer.parseInt(countVO.getRsltD7Qty())-Integer.parseInt(preVO.getOrderD7Qty())));
						
						}else{
							putVO.setRsltD7Qty(countVO.getRsltD7Qty()); // 남은 countVO 만큼만 다 넣음
							countVO.setRsltD7Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltR2Qty()) > Integer.parseInt(preVO.getOrderR2Qty())){ 
							putVO.setRsltR2Qty(preVO.getOrderR2Qty()); 
							countVO.setRsltR2Qty(Integer.toString(Integer.parseInt(countVO.getRsltR2Qty())-Integer.parseInt(preVO.getOrderR2Qty())));
						}else{
							putVO.setRsltR2Qty(countVO.getRsltR2Qty()); 
							countVO.setRsltR2Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltR5Qty()) > Integer.parseInt(preVO.getOrderR5Qty())){ 
							putVO.setRsltR5Qty(preVO.getOrderR5Qty()); 
							countVO.setRsltR5Qty(Integer.toString(Integer.parseInt(countVO.getRsltR5Qty())-Integer.parseInt(preVO.getOrderR5Qty())));
						}else{
							putVO.setRsltR5Qty(countVO.getRsltR5Qty()); 
							countVO.setRsltR5Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltR9Qty()) > Integer.parseInt(preVO.getOrderR9Qty())){ 
							putVO.setRsltR9Qty(preVO.getOrderR9Qty()); 
							countVO.setRsltR9Qty(Integer.toString(Integer.parseInt(countVO.getRsltR9Qty())-Integer.parseInt(preVO.getOrderR9Qty())));
						}else{
							putVO.setRsltR9Qty(countVO.getRsltR9Qty()); 
							countVO.setRsltR9Qty("0");
						}		

						if(Integer.parseInt(countVO.getRsltF2Qty()) > Integer.parseInt(preVO.getOrderF2Qty())){ 
							putVO.setRsltF2Qty(preVO.getOrderF2Qty()); 
							countVO.setRsltF2Qty(Integer.toString(Integer.parseInt(countVO.getRsltF2Qty())-Integer.parseInt(preVO.getOrderF2Qty())));
						}else{
							putVO.setRsltF2Qty(countVO.getRsltF2Qty()); 
							countVO.setRsltF2Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltF4Qty()) > Integer.parseInt(preVO.getOrderF4Qty())){ 
							putVO.setRsltF4Qty(preVO.getOrderF4Qty()); 
							countVO.setRsltF4Qty(Integer.toString(Integer.parseInt(countVO.getRsltF4Qty())-Integer.parseInt(preVO.getOrderF4Qty())));
						}else{
							putVO.setRsltF4Qty(countVO.getRsltF4Qty()); 
							countVO.setRsltF4Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltF5Qty()) > Integer.parseInt(preVO.getOrderF5Qty())){ 
							putVO.setRsltF5Qty(preVO.getOrderF5Qty()); 
							countVO.setRsltF5Qty(Integer.toString(Integer.parseInt(countVO.getRsltF5Qty())-Integer.parseInt(preVO.getOrderF5Qty())));
						}else{
							putVO.setRsltF5Qty(countVO.getRsltF5Qty()); 
							countVO.setRsltF5Qty("0");
						}						

						if(Integer.parseInt(countVO.getRsltS2Qty()) > Integer.parseInt(preVO.getOrderS2Qty())){ 
							putVO.setRsltS2Qty(preVO.getOrderS2Qty()); 
							countVO.setRsltS2Qty(Integer.toString(Integer.parseInt(countVO.getRsltS2Qty())-Integer.parseInt(preVO.getOrderS2Qty())));
						}else{
							putVO.setRsltS2Qty(countVO.getRsltS2Qty()); 
							countVO.setRsltS2Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltS4Qty()) > Integer.parseInt(preVO.getOrderS4Qty())){ 
							putVO.setRsltS4Qty(preVO.getOrderS4Qty()); 
							countVO.setRsltS4Qty(Integer.toString(Integer.parseInt(countVO.getRsltS4Qty())-Integer.parseInt(preVO.getOrderS4Qty())));
						}else{
							putVO.setRsltS4Qty(countVO.getRsltS4Qty()); 
							countVO.setRsltS4Qty("0");
						}

						if(Integer.parseInt(countVO.getRsltO2Qty()) > Integer.parseInt(preVO.getOrderO2Qty())){ 
							putVO.setRsltO2Qty(preVO.getOrderO2Qty()); 
							countVO.setRsltO2Qty(Integer.toString(Integer.parseInt(countVO.getRsltO2Qty())-Integer.parseInt(preVO.getOrderO2Qty())));
						}else{
							putVO.setRsltO2Qty(countVO.getRsltO2Qty()); 
							countVO.setRsltO2Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltO4Qty()) > Integer.parseInt(preVO.getOrderO4Qty())){ 
							putVO.setRsltO4Qty(preVO.getOrderO4Qty()); 
							countVO.setRsltO4Qty(Integer.toString(Integer.parseInt(countVO.getRsltO4Qty())-Integer.parseInt(preVO.getOrderO4Qty())));
						}else{
							putVO.setRsltO4Qty(countVO.getRsltO4Qty()); 
							countVO.setRsltO4Qty("0");
						}
						
						if(Integer.parseInt(countVO.getRsltO5Qty()) > Integer.parseInt(preVO.getOrderO5Qty())){ 
							putVO.setRsltO5Qty(preVO.getOrderO5Qty()); 
							countVO.setRsltO5Qty(Integer.toString(Integer.parseInt(countVO.getRsltO5Qty())-Integer.parseInt(preVO.getOrderO5Qty())));
						}else{
							putVO.setRsltO5Qty(countVO.getRsltO5Qty()); 
							countVO.setRsltO5Qty("0");
						}						
						
						if(Integer.parseInt(countVO.getRsltA2Qty()) > Integer.parseInt(preVO.getOrderA2Qty())){ 
							putVO.setRsltA2Qty(preVO.getOrderA2Qty()); 
							countVO.setRsltA2Qty(Integer.toString(Integer.parseInt(countVO.getRsltA2Qty())-Integer.parseInt(preVO.getOrderA2Qty())));
						}else{
							putVO.setRsltA2Qty(countVO.getRsltA2Qty()); 
							countVO.setRsltA2Qty("0");
						}
						if(Integer.parseInt(countVO.getRsltA4Qty()) > Integer.parseInt(preVO.getOrderA4Qty())){ 
							putVO.setRsltA4Qty(preVO.getOrderA4Qty()); 
							countVO.setRsltA4Qty(Integer.toString(Integer.parseInt(countVO.getRsltA4Qty())-Integer.parseInt(preVO.getOrderA4Qty())));
						}else{
							putVO.setRsltA4Qty(countVO.getRsltA4Qty()); 
							countVO.setRsltA4Qty("0");
						}							
					}else{ // merge 영역 바뀜, Row 에 APPR/RSLT countVO 잔량 다 넣음
						// 나머지 다 넣고
						// Approval
						putVO.setApprD2Qty(countVO.getApprD2Qty()); // D 남은 countVO 다 넣음
						putVO.setApprD4Qty(countVO.getApprD4Qty());
						putVO.setApprD5Qty(countVO.getApprD5Qty());
						putVO.setApprD7Qty(countVO.getApprD7Qty());
						putVO.setApprR2Qty(countVO.getApprR2Qty()); // R
						putVO.setApprR5Qty(countVO.getApprR5Qty());
						putVO.setApprR9Qty(countVO.getApprR9Qty());
						putVO.setApprF2Qty(countVO.getApprF2Qty()); // F
						putVO.setApprF4Qty(countVO.getApprF4Qty());
						putVO.setApprF5Qty(countVO.getApprF5Qty());
						putVO.setApprS2Qty(countVO.getApprS2Qty()); // A
						putVO.setApprS4Qty(countVO.getApprS4Qty());
						putVO.setApprO2Qty(countVO.getApprO2Qty()); // O
						putVO.setApprO4Qty(countVO.getApprO4Qty());
						putVO.setApprO5Qty(countVO.getApprO5Qty());						
						putVO.setApprA2Qty(countVO.getApprA2Qty()); // A
                        putVO.setApprA4Qty(countVO.getApprA4Qty());						
						// Result
						putVO.setRsltD2Qty(countVO.getRsltD2Qty()); // D 남은 countVO 다 넣음
						putVO.setRsltD4Qty(countVO.getRsltD4Qty());
						putVO.setRsltD5Qty(countVO.getRsltD5Qty());
						putVO.setRsltD7Qty(countVO.getRsltD7Qty());
						putVO.setRsltR2Qty(countVO.getRsltR2Qty()); // R
						putVO.setRsltR5Qty(countVO.getRsltR5Qty());
						putVO.setRsltR9Qty(countVO.getRsltR9Qty());
						putVO.setRsltF2Qty(countVO.getRsltF2Qty()); // F
						putVO.setRsltF4Qty(countVO.getRsltF4Qty());
						putVO.setRsltF5Qty(countVO.getRsltF5Qty());
						putVO.setRsltS2Qty(countVO.getRsltS2Qty()); // A
						putVO.setRsltS4Qty(countVO.getRsltS4Qty());
						putVO.setRsltO2Qty(countVO.getRsltO2Qty()); // O
						putVO.setRsltO4Qty(countVO.getRsltO4Qty());
						putVO.setRsltO5Qty(countVO.getRsltO5Qty());						
						putVO.setRsltA2Qty(countVO.getRsltA2Qty()); // A
						putVO.setRsltA4Qty(countVO.getRsltA4Qty());	
						
						// 다음 merge 영역 계산 위해 countVO 재 설정
						countVO = (OnhireStatusVO)list.get(i).clone();
					}
					
					result.add(putVO);
					
					// 다음 Row 계산 위해 preVO 재 설정
					preVO = (OnhireStatusVO)list.get(i).clone();
					putVO = (OnhireStatusVO)list.get(i).clone();
				}
			
				// 마지막줄 세팅
				// Approval
				putVO.setApprD2Qty(countVO.getApprD2Qty()); // D 남은 countVO 다 넣음
				putVO.setApprD4Qty(countVO.getApprD4Qty());
				putVO.setApprD5Qty(countVO.getApprD5Qty());
				putVO.setApprD7Qty(countVO.getApprD7Qty());
				putVO.setApprR2Qty(countVO.getApprR2Qty()); // R
				putVO.setApprR5Qty(countVO.getApprR5Qty());
				putVO.setApprR9Qty(countVO.getApprR9Qty());
				putVO.setApprF2Qty(countVO.getApprF2Qty()); // F
				putVO.setApprF4Qty(countVO.getApprF4Qty());
				putVO.setApprF5Qty(countVO.getApprF5Qty());
				putVO.setApprS2Qty(countVO.getApprS2Qty()); // A
				putVO.setApprS4Qty(countVO.getApprS4Qty());
				putVO.setApprO2Qty(countVO.getApprO2Qty()); // O
				putVO.setApprO4Qty(countVO.getApprO4Qty());
				putVO.setApprO5Qty(countVO.getApprO5Qty());				
				putVO.setApprA2Qty(countVO.getApprA2Qty()); // A
	            putVO.setApprA4Qty(countVO.getApprA4Qty());	
				// Result
	            putVO.setRsltD2Qty(countVO.getRsltD2Qty()); // D 남은 countVO 다 넣음
				putVO.setRsltD4Qty(countVO.getRsltD4Qty());
				putVO.setRsltD5Qty(countVO.getRsltD5Qty());
				putVO.setRsltD7Qty(countVO.getRsltD7Qty());
				putVO.setRsltR2Qty(countVO.getRsltR2Qty()); // R
				putVO.setRsltR5Qty(countVO.getRsltR5Qty());
				putVO.setRsltR9Qty(countVO.getRsltR9Qty());
				putVO.setRsltF2Qty(countVO.getRsltF2Qty()); // F
				putVO.setRsltF4Qty(countVO.getRsltF4Qty());
				putVO.setRsltF5Qty(countVO.getRsltF5Qty());
				putVO.setRsltS2Qty(countVO.getRsltS2Qty()); // A
				putVO.setRsltS4Qty(countVO.getRsltS4Qty());
				putVO.setRsltO2Qty(countVO.getRsltO2Qty()); // O
				putVO.setRsltO4Qty(countVO.getRsltO4Qty());
				putVO.setRsltO5Qty(countVO.getRsltO5Qty());				
				putVO.setRsltA2Qty(countVO.getRsltA2Qty()); // A
				putVO.setRsltA4Qty(countVO.getRsltA4Qty());	
				result.add(putVO);
			}
			return result;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * On hire Status 데이터를 Insert/Update/Delete 합니다.<br>
	 * 
	 * @param OnhireStatusVO[] onhireStatusVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageOnhireStatusBasic(OnhireStatusVO[] onhireStatusVOs, SignOnUserAccount account) throws EventException{
		try {
			List<EqrCtrlOnhOrdVO> insertVoList = new ArrayList<EqrCtrlOnhOrdVO>();
			List<EqrCtrlOnhOrdVO> updateVoList = new ArrayList<EqrCtrlOnhOrdVO>();
			List<EqrCtrlOnhOrdVO> deleteVoList = new ArrayList<EqrCtrlOnhOrdVO>();
			
			List<EqrCtrlOnhOrdQtyVO> insertQtyVoList = new ArrayList<EqrCtrlOnhOrdQtyVO>();
			List<EqrCtrlOnhOrdQtyVO> updateQtyVoList = new ArrayList<EqrCtrlOnhOrdQtyVO>();
			List<EqrCtrlOnhOrdQtyVO> deleteQtyVoList = new ArrayList<EqrCtrlOnhOrdQtyVO>();
			
			EqrCtrlOnhOrdVO eqrCtrlOnhOrdVO = new EqrCtrlOnhOrdVO();
			EqrCtrlOnhOrdQtyVO eqrCtrlOnhOrdQtyVO = new EqrCtrlOnhOrdQtyVO();
			
			for ( int i=0; i<onhireStatusVOs.length; i++ ) {
				if ( onhireStatusVOs[i].getIbflag().equals("I")){
						
					eqrCtrlOnhOrdVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhOrdVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhOrdVO.setOnhOrdYr(onhireStatusVOs[i].getOnhOrdYr());   
					eqrCtrlOnhOrdVO.setLccCd(onhireStatusVOs[i].getLccCd());       
					eqrCtrlOnhOrdVO.setRccCd(onhireStatusVOs[i].getRccCd());       
					eqrCtrlOnhOrdVO.setEqLstmCd(onhireStatusVOs[i].getEqLstmCd());      
					eqrCtrlOnhOrdVO.setLsePrdSeq(onhireStatusVOs[i].getLsePrdSeq());       
					eqrCtrlOnhOrdVO.setOnhOrdRmk(onhireStatusVOs[i].getOnhOrdRmk());   
					
					insertVoList.add((EqrCtrlOnhOrdVO)eqrCtrlOnhOrdVO.clone());
					
					eqrCtrlOnhOrdQtyVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhOrdQtyVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhOrdQtyVO.setOnhOrdYr(onhireStatusVOs[i].getOnhOrdYr());   
					eqrCtrlOnhOrdQtyVO.setLccCd(onhireStatusVOs[i].getLccCd());             
					eqrCtrlOnhOrdQtyVO.setEqLstmCd(onhireStatusVOs[i].getEqLstmCd());      
					eqrCtrlOnhOrdQtyVO.setLsePrdSeq(onhireStatusVOs[i].getLsePrdSeq());    
					
					// TPSZ 별로 반복
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD2Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD4Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD5Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D7");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD7Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("R2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderR2Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("R5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderR5Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("R9");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderR9Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("O2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderO2Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("O4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderO4Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("O5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderO5Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 					
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("S2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderS2Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("S4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderS4Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("F2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderF2Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("F4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderF4Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("F5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderF5Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("A2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderA2Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("A4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderA4Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("A5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderA5Qty());
					insertQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 					
				
				} else if ( onhireStatusVOs[i].getIbflag().equals("U")){
					
					eqrCtrlOnhOrdVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhOrdVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhOrdVO.setOnhOrdYr(onhireStatusVOs[i].getOnhOrdYr());   
					eqrCtrlOnhOrdVO.setLccCd(onhireStatusVOs[i].getLccCd());       
					eqrCtrlOnhOrdVO.setRccCd(onhireStatusVOs[i].getRccCd());       
					eqrCtrlOnhOrdVO.setEqLstmCd(onhireStatusVOs[i].getEqLstmCd());      
					eqrCtrlOnhOrdVO.setLsePrdSeq(onhireStatusVOs[i].getLsePrdSeq());       
					eqrCtrlOnhOrdVO.setOnhOrdRmk(onhireStatusVOs[i].getOnhOrdRmk());   
					
					updateVoList.add((EqrCtrlOnhOrdVO)eqrCtrlOnhOrdVO.clone());
					
					eqrCtrlOnhOrdQtyVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhOrdQtyVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhOrdQtyVO.setOnhOrdYr(onhireStatusVOs[i].getOnhOrdYr());   
					eqrCtrlOnhOrdQtyVO.setLccCd(onhireStatusVOs[i].getLccCd());             
					eqrCtrlOnhOrdQtyVO.setEqLstmCd(onhireStatusVOs[i].getEqLstmCd());      
					eqrCtrlOnhOrdQtyVO.setLsePrdSeq(onhireStatusVOs[i].getLsePrdSeq());    
					
					// TPSZ 별로 반복
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD2Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD4Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD5Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("D7");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderD7Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("R2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderR2Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("R5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderR5Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("R9");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderR9Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("O2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderO2Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("O4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderO4Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 

					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("O5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderO5Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("S2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderS2Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("S4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderS4Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("F2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderF2Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("F4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderF4Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("F5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderF5Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("A2");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderA2Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("A4");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderA4Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 
					
					eqrCtrlOnhOrdQtyVO.setCntrTpszCd("A5");
					eqrCtrlOnhOrdQtyVO.setCntrQty(onhireStatusVOs[i].getOrderA5Qty());
					updateQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone()); 					
					
				} else if ( onhireStatusVOs[i].getIbflag().equals("D")){

					eqrCtrlOnhOrdVO.setOnhOrdYr(onhireStatusVOs[i].getOnhOrdYr());   
					eqrCtrlOnhOrdVO.setLccCd(onhireStatusVOs[i].getLccCd());            
					eqrCtrlOnhOrdVO.setEqLstmCd(onhireStatusVOs[i].getEqLstmCd());      
					eqrCtrlOnhOrdVO.setLsePrdSeq(onhireStatusVOs[i].getLsePrdSeq());         
					
					deleteVoList.add((EqrCtrlOnhOrdVO)eqrCtrlOnhOrdVO.clone());
					
					eqrCtrlOnhOrdQtyVO.setOnhOrdYr(onhireStatusVOs[i].getOnhOrdYr());   
					eqrCtrlOnhOrdQtyVO.setLccCd(onhireStatusVOs[i].getLccCd());             
					eqrCtrlOnhOrdQtyVO.setEqLstmCd(onhireStatusVOs[i].getEqLstmCd());      
					eqrCtrlOnhOrdQtyVO.setLsePrdSeq(onhireStatusVOs[i].getLsePrdSeq()); 
					
					deleteQtyVoList.add((EqrCtrlOnhOrdQtyVO)eqrCtrlOnhOrdQtyVO.clone());
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addOnhireStatusData(insertVoList);
				dbDao.modifyOnhireStatusQtyData(insertQtyVoList); // merge 쿼리라서 update 걸 함께 사용
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyOnhireStatusData(updateVoList);
				dbDao.modifyOnhireStatusQtyData(updateQtyVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeOnhireStatusQtyData(deleteQtyVoList);
				dbDao.removeOnhireStatusData(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * RCC, LCC 콤보 조회<br>
	 * 
	 * @param String loc_grp_cd
	 * @param String loc_cd
	 * @return CommonRsVO
	 * @exception EventException
	 */	
	public CommonRsVO searchRccLccCd(String loc_grp_cd, String loc_cd) throws EventException{
		try {
			return dbDao.searchRccLccCd(loc_grp_cd,  loc_cd);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * LT ST OW Plan and Approval 을 조회 합니다.<br>
	 * 
	 * @param PlanAndApprovalConditionVO planAndApprovalConditionVO
	 * @return List<OnhireStatusVO>
	 * @exception EventException
	 */
	public List<PlanAndApprovalVO> searchPlanAndApprovalBasic(PlanAndApprovalConditionVO planAndApprovalConditionVO) throws EventException {
		try {
			List<PlanAndApprovalVO> list = null;
			
			list =	dbDao.searchPlanAndApprovalData(planAndApprovalConditionVO);	
			return list;
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * LT ST OW Plan and Approval 을 Insert/Update/Delete 합니다.<br>
	 * 
	 * @param PlanAndApprovalVO[] planAndApprovalVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePlanAndApprovalBasic(PlanAndApprovalVO[] planAndApprovalVOs, SignOnUserAccount account) throws EventException{
		
		List<EqrCtrlOnhPlnAproVO> insertVoList = new ArrayList<EqrCtrlOnhPlnAproVO>();
		List<EqrCtrlOnhPlnAproVO> updateVoList = new ArrayList<EqrCtrlOnhPlnAproVO>();
		List<EqrCtrlOnhPlnAproVO> deleteVoList = new ArrayList<EqrCtrlOnhPlnAproVO>();
		
		List<EqrCtrlOnhPlnAproQtyVO> insertQtyVoList = new ArrayList<EqrCtrlOnhPlnAproQtyVO>();
		List<EqrCtrlOnhPlnAproQtyVO> updateQtyVoList = new ArrayList<EqrCtrlOnhPlnAproQtyVO>();
		List<EqrCtrlOnhPlnAproQtyVO> deleteQtyVoList = new ArrayList<EqrCtrlOnhPlnAproQtyVO>();
		
		StringBuffer newLsePlnSeqBuf = new StringBuffer(); 
		String newLsePlnSeqStr = "";
		try {
			
			EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO = new EqrCtrlOnhPlnAproVO();
			EqrCtrlOnhPlnAproQtyVO eqrCtrlOnhPlnAproQtyVO = new EqrCtrlOnhPlnAproQtyVO();
			
			for ( int i=0; i<planAndApprovalVOs.length; i++ ) {
				if ( planAndApprovalVOs[i].getIbflag().equals("I")){
					
				// [ EqrCtrlOnhPlnAproVO 로 mapping ] 
					eqrCtrlOnhPlnAproVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproVO.setOnhPkupYrwk(planAndApprovalVOs[i].getOnhPkupYrwk());   
					eqrCtrlOnhPlnAproVO.setOnhOrdYr(planAndApprovalVOs[i].getOnhOrdYr());  					
					eqrCtrlOnhPlnAproVO.setLccCd(planAndApprovalVOs[i].getLccCd());       
					eqrCtrlOnhPlnAproVO.setRccCd(planAndApprovalVOs[i].getRccCd());    
					eqrCtrlOnhPlnAproVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproVO.setLsePlnSeq(planAndApprovalVOs[i].getLsePlnSeq());
					eqrCtrlOnhPlnAproVO.setAproRmk(planAndApprovalVOs[i].getAproRmk());   
					// lse_rqst_no 는 managePlanAndApprovalRequestBasic() 으로 처리
					
					String seq = dbDao.addPlanAndApprovalData(eqrCtrlOnhPlnAproVO); // Insert 수행 후 새로 채번한 lse_pln_seq 를 반환 함 
					eqrCtrlOnhPlnAproVO.setLsePlnSeq(seq);
					newLsePlnSeqBuf.append(seq+",");
					
					insertVoList.add((EqrCtrlOnhPlnAproVO)eqrCtrlOnhPlnAproVO.clone()); // 메서드 하단에서 사용
					
				// [ EqrCtrlOnhPlnAproQtyVO 로 mapping ] 
					eqrCtrlOnhPlnAproQtyVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproQtyVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproQtyVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproQtyVO.setLccCd(planAndApprovalVOs[i].getLccCd());          
					eqrCtrlOnhPlnAproQtyVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproQtyVO.setLsePlnSeq(seq); // 채번한 lse_pln_seq 로 setting
					
					// TPSZ 별로 반복
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD2Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD4Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD5Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D7");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD7Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR2Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR5Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R9");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR9Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO2Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO4Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 

					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO5Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("S2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getS2Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("S4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getS4Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF2Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF4Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF5Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA2Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA4Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 

					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA5Qty());
					insertQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
				}else if ( planAndApprovalVOs[i].getIbflag().equals("U")){
					
					eqrCtrlOnhPlnAproVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproVO.setOnhPkupYrwk(planAndApprovalVOs[i].getOnhPkupYrwk());   
					eqrCtrlOnhPlnAproVO.setOnhOrdYr(planAndApprovalVOs[i].getOnhOrdYr());  					
					eqrCtrlOnhPlnAproVO.setLccCd(planAndApprovalVOs[i].getLccCd());       
					eqrCtrlOnhPlnAproVO.setRccCd(planAndApprovalVOs[i].getRccCd());       
					eqrCtrlOnhPlnAproVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproVO.setLsePlnSeq(planAndApprovalVOs[i].getLsePlnSeq());
					eqrCtrlOnhPlnAproVO.setAproRmk(planAndApprovalVOs[i].getAproRmk());   
					// lse_rqst_no 는 managePlanAndApprovalRequestBasic() 으로 처리
					
					updateVoList.add((EqrCtrlOnhPlnAproVO)eqrCtrlOnhPlnAproVO.clone());
					
					eqrCtrlOnhPlnAproQtyVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproQtyVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproQtyVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproQtyVO.setLccCd(planAndApprovalVOs[i].getLccCd());          
					eqrCtrlOnhPlnAproQtyVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproQtyVO.setLsePlnSeq(planAndApprovalVOs[i].getLsePlnSeq()); 
					
					// TPSZ 별로 반복
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D7");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD7Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R9");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR9Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 

					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("S2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getS2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("S4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getS4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 

					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
				} else if ( planAndApprovalVOs[i].getIbflag().equals("D")){

					eqrCtrlOnhPlnAproVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproVO.setLccCd(planAndApprovalVOs[i].getLccCd());          
					eqrCtrlOnhPlnAproVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproVO.setLsePlnSeq(planAndApprovalVOs[i].getLsePlnSeq());        
					
					deleteVoList.add((EqrCtrlOnhPlnAproVO)eqrCtrlOnhPlnAproVO.clone());
					
					eqrCtrlOnhPlnAproQtyVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproQtyVO.setLccCd(planAndApprovalVOs[i].getLccCd());          
					eqrCtrlOnhPlnAproQtyVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproQtyVO.setLsePlnSeq(planAndApprovalVOs[i].getLsePlnSeq()); 
					
					deleteQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone());
				}
			}
			if ( insertVoList.size() > 0 ) {
                // insertVoList는  위에서 이미 insert 했음
				newLsePlnSeqStr = newLsePlnSeqBuf.toString(); // Insert 하면서 채번한 lse_pln_seq 를 , 로 이은 String
				dbDao.addPlanAndApprovalQtyData(insertQtyVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPlanAndApprovalData(updateVoList);
				dbDao.modifyPlanAndApprovalQtyData(updateQtyVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePlanAndApprovalQtyData(deleteQtyVoList);
				dbDao.removePlanAndApprovalData(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return newLsePlnSeqStr; // Insert 하면서 채번한 lse_pln_seq 를 , 로 이은 String
	}
	
	/**
	 * LT ST OW Plan and Approval 을 Request/Request Cancel 합니다.<br>
	 * 
	 * @param PlanAndApprovalVO[] planAndApprovalVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePlanAndApprovalRequestBasic(PlanAndApprovalVO[] planAndApprovalVOs, SignOnUserAccount account) throws EventException{
		StringBuffer newLseRqstNoBuf = new StringBuffer(); 
		String newLseRqstNoStr = "";
		
		try {
			List<EqrCtrlOnhPlnAproVO> updateVoList = new ArrayList<EqrCtrlOnhPlnAproVO>();
			List<EqrCtrlOnhPlnAproQtyVO> updateQtyVoList = new ArrayList<EqrCtrlOnhPlnAproQtyVO>();
			
			EqrCtrlOnhPlnAproVO eqrCtrlOnhPlnAproVO = new EqrCtrlOnhPlnAproVO();
			EqrCtrlOnhPlnAproQtyVO eqrCtrlOnhPlnAproQtyVO = new EqrCtrlOnhPlnAproQtyVO();
			
			for ( int i=0; i<planAndApprovalVOs.length; i++ ) {
				if ( true){
					
					eqrCtrlOnhPlnAproVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproVO.setLccCd(planAndApprovalVOs[i].getLccCd());       
					eqrCtrlOnhPlnAproVO.setRccCd(planAndApprovalVOs[i].getRccCd());       
					eqrCtrlOnhPlnAproVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproVO.setLsePlnSeq(planAndApprovalVOs[i].getLsePlnSeq());
					eqrCtrlOnhPlnAproVO.setAproRmk(planAndApprovalVOs[i].getAproRmk());   
					// lse_rqst_no 는 insert 쿼리 수행 후 반환 됨
					
					String newRqstNo = dbDao.modifyPlanAndApprovalRequestData(eqrCtrlOnhPlnAproVO, planAndApprovalVOs[i].getStsCd()); // Update 수행 후 새로 채번한 lse_rqst_no 를 반환 함 
					newLseRqstNoBuf.append(newRqstNo+",");
					eqrCtrlOnhPlnAproVO.setLseRqstNo(newRqstNo); // 채번한 lse_rqst_no 로 setting
					
					updateVoList.add((EqrCtrlOnhPlnAproVO)eqrCtrlOnhPlnAproVO.clone()); // 메서드 하단에서 사용 
					
					eqrCtrlOnhPlnAproQtyVO.setCreUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproQtyVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlOnhPlnAproQtyVO.setOnhPlnYrwk(planAndApprovalVOs[i].getOnhPlnYrwk());   
					eqrCtrlOnhPlnAproQtyVO.setLccCd(planAndApprovalVOs[i].getLccCd());          
					eqrCtrlOnhPlnAproQtyVO.setEqLstmCd(planAndApprovalVOs[i].getEqLstmCd());      
					eqrCtrlOnhPlnAproQtyVO.setLsePlnSeq(planAndApprovalVOs[i].getLsePlnSeq()); 
					
					// TPSZ 별로 반복
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("D7");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getD7Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("R9");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getR9Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 

					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("O5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getO5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("S2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getS2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("S4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getS4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("F5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getF5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A2");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA2Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A4");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA4Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
					
					eqrCtrlOnhPlnAproQtyVO.setCntrTpszCd("A5");
					eqrCtrlOnhPlnAproQtyVO.setCntrQty(planAndApprovalVOs[i].getA5Qty());
					updateQtyVoList.add((EqrCtrlOnhPlnAproQtyVO)eqrCtrlOnhPlnAproQtyVO.clone()); 
				} 
			}
			if ( updateVoList.size() > 0 ) {
				// updateVoList 는 이미 위에서 update 하였음
				newLseRqstNoStr = newLseRqstNoBuf.toString();
				dbDao.modifyPlanAndApprovalQtyData(updateQtyVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return newLseRqstNoStr;
	}
}