/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPso0203Event.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo.PsoObjListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_PSO-0203 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_PSO-0203HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see UI_PSO-0203HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0208Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoObjListVO psoObjListVO = null;
	private List<PsoObjListVO[]> listPsoObjList = new ArrayList<PsoObjListVO[]>();
	/** Table Value Object Multi Data 처리 */
	
	private HashMap<String,PsoObjListVO[]> hMap = new HashMap<String,PsoObjListVO[]>();
	
	public PsoObjListVO getPsoObjListVO() {
		return psoObjListVO;
	}

	public void setPsoObjListVO(PsoObjListVO psoObjListVO) {
		this.psoObjListVO = psoObjListVO;
	}

	public VopPso0208Event(){}
	
	public void setPsoObjListVOS(PsoObjListVO[] psoObjListVOs, String key) {
		// TODO Auto-generated method stub
		hMap.put(key, psoObjListVOs);
	}
	public Map<String, PsoObjListVO[]> getPsoObjListVOS() {
		// TODO Auto-generated method stub
		return this.hMap;
	}
	
	/**
	 * Favorite Object List의 정보를 저장하긴 위해 화면 우측 3개의 sheet의 데이터를 담는다.
	 * @param listPsoObjList
	 */
	public void addListPsoObjList(PsoObjListVO[] listPsoObjList) {
		this.listPsoObjList.add(listPsoObjList);
	}
	/**
	 * Favorite Object List의 정보Index로 가져온다.
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

}