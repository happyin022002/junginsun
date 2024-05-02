/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FnsTot0030Event.java
*@FileTitle : Inquiry VSL Owner/Charter
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.19
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.19 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.StlCfmVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.VvdStlAmtVO;
import com.hanjin.syscommon.common.table.TotPortStlAmtVO;
/**
 * FNS_TOT_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VvdStlAmtVO vvdStlAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VvdStlAmtVO[] vvdStlAmtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private StlCfmVO stlCfmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private StlCfmVO[] stlCfmVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotPortStlAmtVO totPortStlAmtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotPortStlAmtVO[] totPortStlAmtVOs = null;
	
	public FnsTot0030Event(){}

	public VvdStlAmtVO getVvdStlAmtVO() {
		return vvdStlAmtVO;
	}

	public void setVvdStlAmtVO(VvdStlAmtVO vvdStlAmtVO) {
		this.vvdStlAmtVO = vvdStlAmtVO;
	}

	public VvdStlAmtVO[] getVvdStlAmtVOs() {
		VvdStlAmtVO[] rtnVOs = null;
		if (this.vvdStlAmtVOs != null) {
			rtnVOs = new VvdStlAmtVO[vvdStlAmtVOs.length];
			System.arraycopy(vvdStlAmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setVvdStlAmtVOs(VvdStlAmtVO[] vvdStlAmtVOs) {
		if (vvdStlAmtVOs != null) {
			VvdStlAmtVO[] tmpVOs = new VvdStlAmtVO[vvdStlAmtVOs.length];
			System.arraycopy(vvdStlAmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdStlAmtVOs = tmpVOs;
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

	public TotPortStlAmtVO getTotPortStlAmtVO() {
		return totPortStlAmtVO;
	}

	public void setTotPortStlAmtVO(TotPortStlAmtVO totPortStlAmtVO) {
		this.totPortStlAmtVO = totPortStlAmtVO;
	}

	public TotPortStlAmtVO[] getTotPortStlAmtVOs() {
		TotPortStlAmtVO[] rtnVOs = null;
		if (this.totPortStlAmtVOs != null) {
			rtnVOs = new TotPortStlAmtVO[totPortStlAmtVOs.length];
			System.arraycopy(totPortStlAmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTotPortStlAmtVOs(TotPortStlAmtVO[] totPortStlAmtVOs) {
		if (totPortStlAmtVOs != null) {
			TotPortStlAmtVO[] tmpVOs = new TotPortStlAmtVO[totPortStlAmtVOs.length];
			System.arraycopy(totPortStlAmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.totPortStlAmtVOs = tmpVOs;
		}
	}

	


}