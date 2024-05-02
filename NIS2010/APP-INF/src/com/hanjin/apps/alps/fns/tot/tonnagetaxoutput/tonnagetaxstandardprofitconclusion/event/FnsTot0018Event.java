/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsTot0018Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.24 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.StlCfmVO;

/**
 * FNS_TOT_0018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0018HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ErpIfVO erpIfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ErpIfVO[] erpIfVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private StlCfmVO stlCfmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private StlCfmVO[] stlCfmVOs = null;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotStlClzVO totStlClzVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotStlClzVO[] totStlClzVOs = null;

	
	public FnsTot0018Event(){}


	public ErpIfVO getErpIfVO() {
		return erpIfVO;
	}


	public void setErpIfVO(ErpIfVO erpIfVO) {
		this.erpIfVO = erpIfVO;
		
	}


	public ErpIfVO[] getErpIfVOs() {
		ErpIfVO[] rtnVOs = null;
		if (this.erpIfVOs != null) {
			rtnVOs = new ErpIfVO[erpIfVOs.length];
			System.arraycopy(erpIfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setErpIfVOs(ErpIfVO[] erpIfVOs) {
		if (erpIfVOs != null) {
			ErpIfVO[] tmpVOs = new ErpIfVO[erpIfVOs.length];
			System.arraycopy(erpIfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.erpIfVOs = tmpVOs;
		}
	}


	public StlCfmVO getStlCfmVO() {
		return stlCfmVO;
	}


	public void setStlCfmVO(StlCfmVO stlCfmVO) {
		this.stlCfmVO = stlCfmVO;
	}


	public StlCfmVO[] getStlCfmVOs() {
		StlCfmVO[] rtnVOs = null;
		if (this.stlCfmVOs != null) {
			rtnVOs = new StlCfmVO[stlCfmVOs.length];
			System.arraycopy(stlCfmVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}


	public void setStlCfmVOs(StlCfmVO[] stlCfmVOs) {
		if (stlCfmVOs != null) {
			StlCfmVO[] tmpVOs = new StlCfmVO[stlCfmVOs.length];
			System.arraycopy(stlCfmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stlCfmVOs = tmpVOs;
		}
	}

	public void setTotStlClzVO(TotStlClzVO totStlClzVO){
		this. totStlClzVO = totStlClzVO;
	}

	public void setTotStlClzVOS(TotStlClzVO[] totStlClzVOs){
		if (totStlClzVOs != null) {
			TotStlClzVO[] tmpVOs = new TotStlClzVO[totStlClzVOs.length];
			System.arraycopy(totStlClzVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totStlClzVOs = tmpVOs;
		}
	}

	public TotStlClzVO getTotStlClzVO(){
		return totStlClzVO;
	}

	public TotStlClzVO[] getTotStlClzVOS(){
		TotStlClzVO[] rtnVOs = null;
		if (this.totStlClzVOs != null) {
			rtnVOs = new TotStlClzVO[totStlClzVOs.length];
			System.arraycopy(totStlClzVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}