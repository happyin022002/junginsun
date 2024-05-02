/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InPrsProposalSummarySimulationVO.java
*@FileTitle : InPrsProposalSummarySimulationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.10 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPrsProposalSummarySimulationSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrsProposalSummarySimulationVO> models = new ArrayList<InPrsProposalSummarySimulationVO>();

	
	private ArrayList<InPrsProposalSummarySimulationVO[]> inPrsProposalSummarySimulationVOsList = new ArrayList<InPrsProposalSummarySimulationVO[]>();

	private ArrayList<String> sheetNames = new ArrayList<String>();

 
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrsProposalSummarySimulationSetVO() {}
 
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		 
		 
		return null;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		return null;
	}
	
	/**
	 * Column Info
	 * @return sheetName
	 */
	public String getSheetName(int i) {
		return this.sheetNames.get(i);
	}
	 

	/**
	 * Column Info
	 * @param frmCrgTpAk
	 */
	public void setSheetName(String sheetName) {
		this.sheetNames.add( sheetName );
	}
	 
	 
	public int getSize(){
		return this.sheetNames.size();
	}

	 /*
	 * VO 배열을 반환
	 * @return InPrsProposalSummarySimulationVO[]
	 */
	public InPrsProposalSummarySimulationVO[] getInPrsProposalSummarySimulationVOs(int idx){
		InPrsProposalSummarySimulationVO[] vos = null;
		if(  inPrsProposalSummarySimulationVOsList.size() > idx ){
			 vos = inPrsProposalSummarySimulationVOsList.get(idx);
		}
		return vos;
	}
	public void addInPrsProposalSummarySimulationVOS(InPrsProposalSummarySimulationVO[] inPrsProposalSummarySimulationVOs,String sheetName){
		inPrsProposalSummarySimulationVOsList.add(inPrsProposalSummarySimulationVOs);
		setSheetName(sheetName);
	}
	  
}
