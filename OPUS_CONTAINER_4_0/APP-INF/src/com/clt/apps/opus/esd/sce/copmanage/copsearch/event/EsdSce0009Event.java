/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0009Event.java
*@FileTitle : COP Mode Change
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-12
*@LastModifier : Se-hoon Park
*@LastVersion : 1.0
* 2006-09-12 Se-hoon Park
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import java.util.Arrays;
import java.util.Collection;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SceCopHdrInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EsdSce0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EsdSce0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Se-hoon Park
 * @see HTMLAction 참조
 * @since J2EE 1.4 
 */
@SuppressWarnings("rawtypes")
public class EsdSce0009Event extends EventSupport {
	private static final long serialVersionUID = 1L;

    /** sceCopHdr Table  Value Object */
    private SceCopHdrInfoVO sceCopHdr = null;

    /** sceCopHdrs Multi Action을 위한 Collection */
    private Collection sceCopHdrs = null;

    private COPReplanInfoVO  copReplanInfoVO= null;
	private COPReplanInfoVO[] copReplanInfoVOs = null;    
    /**
     * 생성자<br>
     */    
    public EsdSce0009Event(){}

    
    /**
     * 생성자<br>
     * 
     * @param sceCopHdr SCE_COP_HDR 
     */   
    public EsdSce0009Event(SceCopHdrInfoVO sceCopHdr) {
    	this.sceCopHdr = sceCopHdr;
    }

    /**
     * 생성자<br>
     * 
     * @param sceCopHdr SCE_COP_HDR_INFO 
     * @param sceCopHdrs Collection
     */
    public EsdSce0009Event(SceCopHdrInfoVO sceCopHdr, Collection sceCopHdrs) {
    	this.sceCopHdr = sceCopHdr;
    	this.sceCopHdrs = sceCopHdrs;
    }

    
    /**
     * SCE_COP_HDR 반환
     * 
     * @return sceCopHdr
     */
    public SceCopHdrInfoVO getSCE_COP_HDR_INFO(){
        return sceCopHdr;
    }

    /**
     * Collection 반환
     * 
     * @return sceCopHdrs
     */
    public Collection getSCE_COP_HDRS_INFO(){
        return sceCopHdrs;
    }

    /**
     * 이벤트 명(EsdSce0009Event)을 반환
     * 
     * @return response String
     */
    public String getEventName() {
        return "EsdSce0009Event";
    }

    /**
     * 객체 표현 문자열(EsdSce0009Event)을 반환
     * 
     * @return response String
     */
    public String toString() {
        return "EsdSce0009Event";
    }

    public void setCOPReplanInfoVO(COPReplanInfoVO copReplanInfoVO){
    	this.copReplanInfoVO = copReplanInfoVO;
    }
    public COPReplanInfoVO getCOPReplanInfoVO(){
    	return copReplanInfoVO;    	
    }
    public void setCOPReplanInfoVOs(COPReplanInfoVO[] copReplanInfoVOs){
		if(copReplanInfoVOs != null){
			COPReplanInfoVO[] tmpVOs = Arrays.copyOf(copReplanInfoVOs, copReplanInfoVOs.length);
			this.copReplanInfoVOs = tmpVOs;
		}
    }
    public COPReplanInfoVO[] getCOPReplanInfoVOs(){
    	COPReplanInfoVO[] rtnVOs = null;
		if (this.copReplanInfoVOs != null) {
			rtnVOs = Arrays.copyOf(copReplanInfoVOs, copReplanInfoVOs.length);
		}
		return rtnVOs; 	
    }   
    public Collection getSCE_COP_HDRS(){
        return sceCopHdrs;
    }
    
}
