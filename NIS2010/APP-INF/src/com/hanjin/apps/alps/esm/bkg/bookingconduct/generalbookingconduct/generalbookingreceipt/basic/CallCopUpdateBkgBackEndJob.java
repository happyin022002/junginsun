/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CallCopUpdateBkgBackEndJob.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.08.25
 *@LastModifier : 문동선
 *@LastVersion : 0.1
 * 2015.08.25
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS- Business Logic Basic Command implementation<br>
 * - ALPS- 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see  클래스 참조
 * @since J2EE 1.6
 */
public class CallCopUpdateBkgBackEndJob   extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;

	private String methodName;
	private String bkgNo;
	private String mapSeq;
	private String[] newBkgNoArr = null;
	private String[] copMapSeqArr = null;
	
	private String[] combinedBkgNo = null;
	private String targetBkg;
	private List<CombineTroNewSeqVO> combineTroNewSeqVOs = null;
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public void setMapSeq(String mapSeq) {
		this.mapSeq = mapSeq;
	}
	public void setNewBkgNoArr(String[] newBkgNoArr){
		if(newBkgNoArr != null){
			String[] tmpVOs = new String[newBkgNoArr.length];
			System.arraycopy(newBkgNoArr, 0, tmpVOs, 0, tmpVOs.length);
			this.newBkgNoArr = tmpVOs;
		}
	}
	public void setCopMapSeqArr(String[] copMapSeqArr){
		if(copMapSeqArr != null){
			String[] tmpVOs = new String[copMapSeqArr.length];
			System.arraycopy(copMapSeqArr, 0, tmpVOs, 0, tmpVOs.length);
			this.copMapSeqArr = tmpVOs;
		}
	}
	
	public void setTargetBkg(String targetBkg) {
		this.targetBkg = targetBkg;
	}
	public void setCombinedBkgNo(String[] combinedBkgNo){
		if(combinedBkgNo != null){
			String[] tmpVOs = new String[combinedBkgNo.length];
			System.arraycopy(combinedBkgNo, 0, tmpVOs, 0, tmpVOs.length);
			this.combinedBkgNo = tmpVOs;
		}
	}
	public void setCombineTroNewSeqVOs(List<CombineTroNewSeqVO> combineTroNewSeqVOs) {
		this.combineTroNewSeqVOs = combineTroNewSeqVOs;
	}

	/**
	 * COP 의 updateBkg 메서드를 BackEnd로 부름<br>
	 *
	 * @return Object
	 * @exception Exception
	 */	
	public Object doStart() throws Exception {
		BkgCopManageBC copBC = new BkgCopManageBCImpl();
		
		try{		
			if("updateBkg".equals(methodName)){
				// 18. updateBkg(타 모듈 호출)				
				copBC.updateBkg(bkgNo, mapSeq);
			}else if("splitBkg".equals(methodName)){
				copBC.splitBkg(bkgNo, newBkgNoArr, copMapSeqArr);
			}else if("combineBkg".equals(methodName)){
				copBC.combineBkg(combinedBkgNo, targetBkg, combineTroNewSeqVOs);
			}
		}catch(Exception ex){
			throw new EventException(ex.getMessage(),ex);			
		}
		return null;
	}
}
