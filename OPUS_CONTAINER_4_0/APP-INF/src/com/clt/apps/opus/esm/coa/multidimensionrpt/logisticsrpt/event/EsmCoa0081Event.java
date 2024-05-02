/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0081Event.java
*@FileTitle : Logistics Exp. by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.04 ���ΰ�
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.event;

import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO2;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_COA_0081 �� ���� PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0081HTMLAction���� �ۼ�<br>
 * - ServiceCommand Layer�� ����ϴ� PDTO�� ���<br>
 *
 * @author Choi In Kyung
 * @see ESM_COA_0081HTMLAction ����
 * @since J2EE 1.6
 */

public class EsmCoa0081Event extends EventSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object ��ȸ ���� �� �ܰ� ó��  */
	private SearchLogisticsRPT0081ListVO searchLogisticsRPT0081ListVO = null;	
	private SearchLogisticsRPT0081ListVO2 searchLogisticsRPT0081ListVO2 = null;	
	private SearchLgstConditionVO searchLgstConditionVO = null;
	
	/** Table Value Object Multi Data ó�� */
	private SearchLogisticsRPT0081ListVO[] searchLogisticsRPT0081ListVOs = null;
	private SearchLogisticsRPT0081ListVO2[] searchLogisticsRPT0081ListVO2s = null;
	
	

	public SearchLgstConditionVO getSearchLgstConditionVO() {
		return searchLgstConditionVO;
	}

	public void setSearchLgstConditionVO(SearchLgstConditionVO searchLgstConditionVO) {
		this.searchLgstConditionVO = searchLgstConditionVO;
	}

	public SearchLogisticsRPT0081ListVO getSearchLogisticsRPT0081ListVO() {
		return searchLogisticsRPT0081ListVO;
	}

	public void setSearchLogisticsRPT0081ListVO(
			SearchLogisticsRPT0081ListVO searchLogisticsRPT0081ListVO) {
		this.searchLogisticsRPT0081ListVO = searchLogisticsRPT0081ListVO;
	}

	public SearchLogisticsRPT0081ListVO2 getSearchLogisticsRPT0081ListVO2() {
		return searchLogisticsRPT0081ListVO2;
	}

	public void setSearchLogisticsRPT0081ListVO2(
			SearchLogisticsRPT0081ListVO2 searchLogisticsRPT0081ListVO2) {
		this.searchLogisticsRPT0081ListVO2 = searchLogisticsRPT0081ListVO2;
	}

	//SJH.20150507.소스품질
	public SearchLogisticsRPT0081ListVO[] getSearchLogisticsRPT0081ListVOs() {
		SearchLogisticsRPT0081ListVO[] rtnVOs = null;
		if (this.searchLogisticsRPT0081ListVOs != null) {
			rtnVOs = Arrays.copyOf(searchLogisticsRPT0081ListVOs, searchLogisticsRPT0081ListVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSearchLogisticsRPT0081ListVOs(SearchLogisticsRPT0081ListVO[] searchLogisticsRPT0081ListVOs){
		if(searchLogisticsRPT0081ListVOs != null){
			SearchLogisticsRPT0081ListVO[] tmpVOs = Arrays.copyOf(searchLogisticsRPT0081ListVOs, searchLogisticsRPT0081ListVOs.length);
			this.searchLogisticsRPT0081ListVOs = tmpVOs;
		}
	}
	//SJH.20150507.소스품질
	public SearchLogisticsRPT0081ListVO2[] getSearchLogisticsRPT0081ListVO2s() {
		SearchLogisticsRPT0081ListVO2[] rtnVOs = null;
		if (this.searchLogisticsRPT0081ListVO2s != null) {
			rtnVOs = Arrays.copyOf(searchLogisticsRPT0081ListVO2s, searchLogisticsRPT0081ListVO2s.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSearchLogisticsRPT0081ListVO2s(SearchLogisticsRPT0081ListVO2[] searchLogisticsRPT0081ListVO2s){
		if(searchLogisticsRPT0081ListVO2s != null){
			SearchLogisticsRPT0081ListVO2[] tmpVOs = Arrays.copyOf(searchLogisticsRPT0081ListVO2s, searchLogisticsRPT0081ListVO2s.length);
			this.searchLogisticsRPT0081ListVO2s = tmpVOs;
		}
	}
}