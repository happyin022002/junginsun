/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName      : EsmBkg1184Event.java
*@FileTitle     : e-VGM Upload Monitoring
*Open Issues    :
*Change history :
*
*@LastModifyDate : 2016.04.20
*@LastModifier : CHANG WOO CHO
*@LastVersion : 1.0

* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.ArrayList;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCustShpRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1184 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1184HTMLAction에서 작성<br>
 *
 * @author CHANGWOO LANCE CHO
 * @see ESM_BKG_1184HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1184Event extends EventSupport {
           
        private static final long serialVersionUID = 1L;
           
        /** Table Value Object 조회 조건 및 단건 처리  */
        private XterVgmRqstListInputVO   xterVgmRqstListInputVO  = null;
        private XterVgmRqstListVO        xterVgmRqstListVO       = null;
        
        /** Table Value Object Multi Data 처리 */
        private XterVgmRqstListInputVO[] xterVgmRqstListInputVOs = null;
        private XterVgmRqstListVO[]      xterVgmRqstListVOs      = null;
           
		public XterVgmRqstListInputVO getXterVgmRqstListInputVO() {
        	   return xterVgmRqstListInputVO;
		}  
		public void setXterVgmRqstListInputVO(
				XterVgmRqstListInputVO xterVgmRqstListInputVO) {
			this.xterVgmRqstListInputVO = xterVgmRqstListInputVO;
		}
		public XterVgmRqstListVO getXterVgmRqstListVO() {
			return xterVgmRqstListVO;
		}
		public void setXterVgmRqstListVO(XterVgmRqstListVO xterVgmRqstListVO) {
			this.xterVgmRqstListVO = xterVgmRqstListVO;
		}
		
	    public void setXterVgmRqstListInputVOs(XterVgmRqstListInputVO[] xterVgmRqstListInputVOs){
			if(xterVgmRqstListInputVOs != null){
				XterVgmRqstListInputVO[] tmpVOs = new XterVgmRqstListInputVO[xterVgmRqstListInputVOs.length];
				System.arraycopy(xterVgmRqstListInputVOs, 0, tmpVOs, 0, tmpVOs.length);
				this.xterVgmRqstListInputVOs = tmpVOs;
			}
		}
	    
	    public XterVgmRqstListInputVO[] getXterVgmRqstListInputVOs(){
	    	XterVgmRqstListInputVO[] rtnVOs = null;
			if (this.xterVgmRqstListInputVOs != null) {
				rtnVOs = new XterVgmRqstListInputVO[xterVgmRqstListInputVOs.length];
				System.arraycopy(xterVgmRqstListInputVOs, 0, rtnVOs, 0, rtnVOs.length);
			}
			return rtnVOs;
		}
	    
	    public void setXterVgmRqstListVOs(XterVgmRqstListVO[] xterVgmRqstListVOs){
			if(xterVgmRqstListVOs != null){
				XterVgmRqstListVO[] tmpVOs = new XterVgmRqstListVO[xterVgmRqstListVOs.length];
				System.arraycopy(xterVgmRqstListVOs, 0, tmpVOs, 0, tmpVOs.length);
				this.xterVgmRqstListVOs = tmpVOs;
			}
		}
	    
	    public XterVgmRqstListVO[] getXterVgmRqstListVOs(){
	    	XterVgmRqstListVO[] rtnVOs = null;
			if (this.xterVgmRqstListVOs != null) {
				rtnVOs = new XterVgmRqstListVO[xterVgmRqstListVOs.length];
				System.arraycopy(xterVgmRqstListVOs, 0, rtnVOs, 0, rtnVOs.length);
			}
			return rtnVOs;
		}

}