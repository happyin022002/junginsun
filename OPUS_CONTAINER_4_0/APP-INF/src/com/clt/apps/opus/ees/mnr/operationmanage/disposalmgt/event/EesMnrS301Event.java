/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnrS301Event.java
*@FileTitle : My Bidding List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김완규  
*@LastVersion : 1.0
* 2009.07.20 김완규 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event;

import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_S301 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_MNR_S301HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김완규
 * @see EES_MNR_S301HTMLAction 참조
 * @since J2EE 1.6
 */    
 
public class EesMnrS301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	public EesMnrS301Event(){}     
		
	/** My Bidding List 조회 조건 및 단건 처리  */
	private MyBiddingGRPVO myBiddingGRPVO = null;
	private MyBiddingINVO myBiddingINVO = null;

	public MyBiddingGRPVO getMyBiddingGRPVO() {
		return myBiddingGRPVO;
	}

	public void setMyBiddingGRPVO(MyBiddingGRPVO myBiddingGRPVO) {
		this.myBiddingGRPVO = myBiddingGRPVO;
	}
	
	public void setMyBiddingINVO(MyBiddingINVO myBiddingINVO) {
		this.myBiddingINVO = myBiddingINVO;
	}
	
	public MyBiddingINVO getMyBiddingINVO() {
		return myBiddingINVO;
	}
}