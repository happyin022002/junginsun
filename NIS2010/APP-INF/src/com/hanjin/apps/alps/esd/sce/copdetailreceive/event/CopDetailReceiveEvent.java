/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveEvent.java
*@FileTitle : Cop Detail Receive Admin
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.01
*@LastModifier : 안정선
*@LastVersion : 1.0
* 2010.06.01 안정선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.event;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CopDetailReceiveEvent 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CopDetailReceiveHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim In-soo
 * @see CopDetailReceiveHTMLAction 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
//	/** Table Value Object 조회 조건 및 단건 처리  */
//	private SceCopHdrVO sceCopHdrVO = null;
//	
//	private BkgCopManageVO bkgCopManageVO = null;
//	
//	/** Table Value Object Multi Data 처리 */
//	private SceCopHdrVO[] sceCopHdrVOs = null;
//	
//	private BkgCopManageVO[] bkgCopManageVOs = null;
//
//	public CopDetailReceiveEvent(){}
//	
//	public void setSceCopHdrVO(SceCopHdrVO sceCopHdrVO){
//		this. sceCopHdrVO = sceCopHdrVO;
//	}
//
//	public void setSceCopHdrVOS(SceCopHdrVO[] sceCopHdrVOs){
//		this. sceCopHdrVOs = sceCopHdrVOs;
//	}
//
//	public SceCopHdrVO getSceCopHdrVO(){
//		return sceCopHdrVO;
//	}
//
//	public SceCopHdrVO[] getSceCopHdrVOS(){
//		return sceCopHdrVOs;
//	}
//	
//	
//	public void setBkgCopManageVO(BkgCopManageVO bkgCopManageVO){
//		this. bkgCopManageVO = bkgCopManageVO;
//	}
//
//	public void setBkgCopManageVOS(BkgCopManageVO[] bkgCopManageVOs){
//		this. bkgCopManageVOs = bkgCopManageVOs;
//	}
//
//	public BkgCopManageVO getBkgCopManageVO(){
//		return bkgCopManageVO;
//	}
//
//	public BkgCopManageVO[] getBkgCopManageVOS(){
//		return bkgCopManageVOs;
//	}
	
    public String getEventName() {
        return "CopDetailReceiveEvent";
    }


}