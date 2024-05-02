/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0206Event.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.02 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PsoCondDtlVO;


/**
 * VOP_PSO-0206 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0206HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park MyoungJong
 * @see VOP_PSO-0206HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0206Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String ofcCd = "";
	private String psoObjCd = "";
	private String types = "";	
	private String condNo = "";	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoObjListVO psoObjListVO = null;
	private List<PsoObjListVO[]> listPsoObjList = new ArrayList<PsoObjListVO[]>();
	/** Table Value Object Multi Data 처리 */
	
	private PsoCondDtlVO psoCondDtlVO = null;
	private PsoCondDtlVO[] psoCondDtlVOs = null;
	
	private ConditionVO conditionVO = null;
	private ConditionVO[] conditionVOs = null;

	private HashMap<String,PsoObjListVO[]> hMap = new HashMap<String,PsoObjListVO[]>();
	
	public PsoObjListVO getPsoObjListVO() {
		return psoObjListVO;
	}

	public void setPsoObjListVO(PsoObjListVO psoObjListVO) {
		this.psoObjListVO = psoObjListVO;
	}

	public VopPso0206Event(){}
	
	public void setPsoObjListVOS(PsoObjListVO[] psoObjListVOs, String key) {
		// TODO Auto-generated method stub
		hMap.put(key, psoObjListVOs);
	}
	public Map<String, PsoObjListVO[]> getPsoObjListVOS() {
		// TODO Auto-generated method stub
		return this.hMap;
	}
	/**
	 * PSO_INVOICE_OFFICE OBJECT LIST의 배열을 ArrayList에 저장한다.
	 * @param listPsoObjList
	 */
	public void addListPsoObjList(PsoObjListVO[] listPsoObjList) {
		this.listPsoObjList.add(listPsoObjList);
	}
	/**
	 * ArrayList에서 PSO_INVOICE_OFFICE OBJECT배열을 꺼내 온다.
	 * @param idx
	 * @return
	 */
	public PsoObjListVO[] getListPsoObjList(int idx) {
		return this.listPsoObjList.get(idx);
	}
	/**
	 *  새로운 PSO_INVOICE_OFFICE OBJECT LIST의 데이터를 생성하기 위해 3개의 인서트 그룹으로 나누어진
	 *  데이터를 하나의 어레이에 넣어서 리턴한다. 
	 * @return PsoObjListVO[]
	 */
	public PsoObjListVO[] getListPsoObjListAll() {
		Object[] objs = this.listPsoObjList.toArray();
		if(objs.length<=0) return null;
		int size = 0;
		for(int i=0;i<objs.length;i++){
			PsoObjListVO[] ps= (PsoObjListVO[]) objs[i];
			if(ps!=null) size += ps.length;
		}
		if(size <= 0) return null;
		PsoObjListVO[] psoObjListVOs = new PsoObjListVO[size];
		int z = 0;
		for(int i=0;i<objs.length;i++){
			PsoObjListVO[] ps= (PsoObjListVO[]) objs[i];
			if(ps!=null){
				for(int j=0;j<ps.length;j++)
					psoObjListVOs[z++] = ps[j];
			}
		}
		return psoObjListVOs;
	}
	public void setListPsoObjList(List<PsoObjListVO[]> listPsoObjList) {
		this.listPsoObjList = listPsoObjList;
	}
	public List<PsoObjListVO[]> getListPsoObjList() {
		return listPsoObjList;
	}

	public void setPsoObjListVOS(PsoObjListVO[] os) {
	}

	/**
	 * @param ofc_cd the ofc_cd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the ofc_cd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param pso_obj_cd the pso_obj_cd to set
	 */
	public void setPsoObjCd(String psoObjCd) {
		this.psoObjCd = psoObjCd;
	}

	/**
	 * @return the pso_obj_cd
	 */
	public String getPsoObjCd() {
		return psoObjCd;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(String types) {
		this.types = types;
	}

	/**
	 * @return the types
	 */
	public String getTypes() {
		return types;
	}

	/**
	 * @return the psoCondDtlVO
	 */
	public PsoCondDtlVO getPsoCondDtlVO() {
		return psoCondDtlVO;
	}

	/**
	 * @param psoCondDtlVO the psoCondDtlVO to set
	 */
	public void setPsoCondDtlVO(PsoCondDtlVO psoCondDtlVO) {
		this.psoCondDtlVO = psoCondDtlVO;
	}

	/**
	 * @return the psoCondDtlVOs 
	 */
	public PsoCondDtlVO[] getPsoCondDtlVOs(){
		PsoCondDtlVO[] tmpVOs = null;
		if (this. psoCondDtlVOs != null) {
			tmpVOs = new PsoCondDtlVO[psoCondDtlVOs .length];
			System.arraycopy(psoCondDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param psoCondDtlVOs the psoCondDtlVOs to set
	 */
	public void setPsoCondDtlVOs(PsoCondDtlVO[] psoCondDtlVOs){
		if (psoCondDtlVOs != null) {
			PsoCondDtlVO[] tmpVOs = new PsoCondDtlVO[psoCondDtlVOs .length];
			System.arraycopy(psoCondDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. psoCondDtlVOs = tmpVOs;
		}
	}
	
	/**
	 * @return the conditionVO
	 */
	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	/**
	 * @param conditionVO the conditionVO to set
	 */
	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	/**
	 * @return the conditionVOs
	 */
	public ConditionVO[] getConditionVOs(){
		ConditionVO[] tmpVOs = null;
		if (this. conditionVOs != null) {
			tmpVOs = new ConditionVO[conditionVOs .length];
			System.arraycopy(conditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * @param conditionVOs the conditionVOs to set
	 */
	public void setConditionVOs(ConditionVO[] conditionVOs){
		if (conditionVOs != null) {
			ConditionVO[] tmpVOs = new ConditionVO[conditionVOs .length];
			System.arraycopy(conditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. conditionVOs = tmpVOs;
		}
	}

	/**
	 * @return the condNo
	 */
	public String getCondNo() {
		return condNo;
	}

	/**
	 * @param condNo the condNo to set
	 */
	public void setCondNo(String condNo) {
		this.condNo = condNo;
	}

}