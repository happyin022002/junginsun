package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpSumVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;

public class CodeInfoGRPVO {

	private List<MdmVslCntrVO> vslClsCapaVOs = null;
	private List<MdmVslCntrVO> vslDzndCapaVOs = null;
	
	public CodeInfoGRPVO(){
		vslClsCapaVOs = new ArrayList<MdmVslCntrVO>();
		vslDzndCapaVOs = new ArrayList<MdmVslCntrVO>();
	}
	
	public void setVslClsCapaVOs(List<MdmVslCntrVO> mdmVslCntrVOs){
		this.vslClsCapaVOs = mdmVslCntrVOs;
	}
	
	public List<MdmVslCntrVO> getVslClsCapaVOss(){
		return this.vslClsCapaVOs;
	}
	
	public void setVslDzndCapaVOs(List<MdmVslCntrVO> mdmVslCntrVOs){
		this.vslDzndCapaVOs = mdmVslCntrVOs;
	}
	
	public List<MdmVslCntrVO> getVslDzndCapaVOs(){
		return this.vslDzndCapaVOs;
	}
	
}
