/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : CostcdVO
*@FileTitle : Table Value Ojbect
*Open Issues :
*Change history :
*@LastModifyDate : 2007-04-07
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2007-04-07 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event;

import java.util.ArrayList;

import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - TRS 업무에서 사용하는 PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author poong
 * @see
 * @since J2EE 1.4
 */
public class CostcdVO {
	
	ArrayList src = null;
	
	public CostcdVO(){
		src = createSrc(); 
	}
	
	public String getCostCd(String CostMode, String TransMode, String CgoTpCd){
		String costModeValue = null;
		String transValue = null;
		String cgoValue = null;
		String costCdValue = null;
		boolean isSearch = false;
		
		CostMode = JSPUtil.getNull(CostMode);
		TransMode = JSPUtil.getNull(getTransModeCd(TransMode));
		CgoTpCd = JSPUtil.getNull(CgoTpCd);
		
		for(int i=0; i< src.size(); i++){
			
			ArrayList contents = (ArrayList) src.get(i);
			costModeValue = (String) contents.get(0);
			transValue = (String) contents.get(1);
			cgoValue = (String) contents.get(2);
			costCdValue = (String) contents.get(3);
			
			if(	costModeValue.equals(CostMode) &&
					transValue.equals(TransMode) &&
					cgoValue.equals(CgoTpCd)){
				isSearch = true;
				break;
			}
		}
		
		if(!isSearch) costCdValue = "";
		return costCdValue;
	}

	public String getCostCd(String CostMode, String TransMode){
		return getCostCd(CostMode, TransMode, "");
	}
	
	public ArrayList createSrc(){
	
		src = new ArrayList();
		
		ArrayList contents01 = new ArrayList();
		ArrayList contents02 = new ArrayList();
		ArrayList contents03 = new ArrayList();
		ArrayList contents04 = new ArrayList();
		ArrayList contents05 = new ArrayList();
		ArrayList contents06 = new ArrayList();
		ArrayList contents07 = new ArrayList();
		ArrayList contents08 = new ArrayList();
		ArrayList contents09 = new ArrayList();
		ArrayList contents10 = new ArrayList();
		
		ArrayList contents11 = new ArrayList();
		ArrayList contents12 = new ArrayList();
		ArrayList contents13 = new ArrayList();
		ArrayList contents14 = new ArrayList();
		ArrayList contents15 = new ArrayList();
		ArrayList contents16 = new ArrayList();
		ArrayList contents17 = new ArrayList();
		ArrayList contents18 = new ArrayList();
		ArrayList contents19 = new ArrayList();
		ArrayList contents20 = new ArrayList();
		
		ArrayList contents21 = new ArrayList();
		ArrayList contents22 = new ArrayList();
		ArrayList contents23 = new ArrayList();
		ArrayList contents24 = new ArrayList();
		ArrayList contents25 = new ArrayList();
		ArrayList contents26 = new ArrayList();
		ArrayList contents27 = new ArrayList();
		ArrayList contents28 = new ArrayList();
		ArrayList contents29 = new ArrayList();
		ArrayList contents30 = new ArrayList();
		
		ArrayList contents31 = new ArrayList();
		ArrayList contents32 = new ArrayList();
		ArrayList contents33 = new ArrayList();
		ArrayList contents34 = new ArrayList();
		ArrayList contents35 = new ArrayList();
		ArrayList contents36 = new ArrayList();
		ArrayList contents37 = new ArrayList();
		ArrayList contents38 = new ArrayList();
		ArrayList contents39 = new ArrayList();
		ArrayList contents40 = new ArrayList();
		
		ArrayList contents41 = new ArrayList();
		ArrayList contents42 = new ArrayList();
		ArrayList contents43 = new ArrayList();
		ArrayList contents44 = new ArrayList();
		ArrayList contents45 = new ArrayList();
		ArrayList contents46 = new ArrayList();
		ArrayList contents47 = new ArrayList();
		ArrayList contents48 = new ArrayList();
		
		contents01.add("GD");	contents01.add("RD");	contents01.add("");	contents01.add("TRGDRD");	src.add(contents01);
		contents02.add("GD");	contents02.add("TD");	contents02.add("");	contents02.add("TRGDTD");	src.add(contents02);
		contents03.add("GD");	contents03.add("WD");	contents03.add("");	contents03.add("TRGDWD");	src.add(contents03);
		contents04.add("GD");	contents04.add("RT");	contents04.add("");	contents04.add("TRGDRT");	src.add(contents04);
		contents05.add("GD");	contents05.add("WR");	contents05.add("");	contents05.add("TRGDWR");	src.add(contents05);
		contents06.add("GD");	contents06.add("WT");	contents06.add("");	contents06.add("TRGDWT");	src.add(contents06);
		
		contents07.add("GN");	contents07.add("RD");	contents07.add("");	contents07.add("TRGNRD");	src.add(contents07);
		contents08.add("GN");	contents08.add("TD");	contents08.add("");	contents08.add("TRGNTD");	src.add(contents08);
		contents09.add("GN");	contents09.add("WD");	contents09.add("");	contents09.add("TRGNWD");	src.add(contents09);
		contents10.add("GN");	contents10.add("RT");	contents10.add("");	contents10.add("TRGNRT");	src.add(contents10);
		contents11.add("GN");	contents11.add("WR");	contents11.add("");	contents11.add("TRGNWR");	src.add(contents11);
		contents12.add("GN");	contents12.add("WT");	contents12.add("");	contents12.add("TRGNWT");	src.add(contents12);
		
		contents13.add("GF");	contents13.add("RD");	contents13.add("");	contents13.add("TRGFRD");	src.add(contents13);
		contents14.add("GF");	contents14.add("TD");	contents14.add("");	contents14.add("TRGFTD");	src.add(contents14);
		contents15.add("GF");	contents15.add("WD");	contents15.add("");	contents15.add("TRGFWD");	src.add(contents15);
		contents16.add("GF");	contents16.add("RT");	contents16.add("");	contents16.add("TRGFRT");	src.add(contents16);
		contents17.add("GF");	contents17.add("WR");	contents17.add("");	contents17.add("TRGFWR");	src.add(contents17);
		contents18.add("GF");	contents18.add("WT");	contents18.add("");	contents18.add("TRGFWT");	src.add(contents18);
		
		contents19.add("ZD");	contents19.add("RD");	contents19.add("");	contents19.add("TRCDRD");	src.add(contents19);
		contents20.add("ZD");	contents20.add("TD");	contents20.add("");	contents20.add("TRCDTD");	src.add(contents20);
		contents21.add("ZD");	contents21.add("WD");	contents21.add("");	contents21.add("TRCDWD");	src.add(contents21);
		contents22.add("ZD");	contents22.add("RT");	contents22.add("");	contents22.add("TRCDRT");	src.add(contents22);
		contents23.add("ZD");	contents23.add("WR");	contents23.add("");	contents23.add("TRCDWR");	src.add(contents23);
		contents24.add("ZD");	contents24.add("WT");	contents24.add("");	contents24.add("TRCDWT");	src.add(contents24);
		
		contents25.add("ZN");	contents25.add("RD");	contents25.add("");	contents25.add("TRCNRD");	src.add(contents25);
		contents26.add("ZN");	contents26.add("TD");	contents26.add("");	contents26.add("TRCNTD");	src.add(contents26);
		contents27.add("ZN");	contents27.add("WD");	contents27.add("");	contents27.add("TRCNWD");	src.add(contents27);
		contents28.add("ZN");	contents28.add("RT");	contents28.add("");	contents28.add("TRCNRT");	src.add(contents28);
		contents29.add("ZN");	contents29.add("WR");	contents29.add("");	contents29.add("TRCNWR");	src.add(contents29);
		contents30.add("ZN");	contents30.add("WT");	contents30.add("");	contents30.add("TRCNWT");	src.add(contents30);
		
		contents31.add("ZF");	contents31.add("RD");	contents31.add("");	contents31.add("TRCFRD");	src.add(contents31);
		contents32.add("ZF");	contents32.add("TD");	contents32.add("");	contents32.add("TRCFTD");	src.add(contents32);
		contents33.add("ZF");	contents33.add("WD");	contents33.add("");	contents33.add("TRCFWD");	src.add(contents33);
		contents34.add("ZF");	contents34.add("RT");	contents34.add("");	contents34.add("TRCFRT");	src.add(contents34);
		contents35.add("ZF");	contents35.add("WR");	contents35.add("");	contents35.add("TRCFWR");	src.add(contents35);
		contents36.add("ZF");	contents36.add("WT");	contents36.add("");	contents36.add("TRCFWT");	src.add(contents36);
		
		contents37.add("OT");	contents37.add("RD");	contents37.add("F");	contents37.add("TROTRD");	src.add(contents37);
		contents38.add("OT");	contents38.add("TD");	contents38.add("F");	contents38.add("TROTTD");	src.add(contents38);
		contents39.add("OT");	contents39.add("WD");	contents39.add("F");	contents39.add("TROTWD");	src.add(contents39);
		contents40.add("OT");	contents40.add("RT");	contents40.add("F");	contents40.add("TROTRT");	src.add(contents40);
		contents41.add("OT");	contents41.add("WR");	contents41.add("F");	contents41.add("TROTWR");	src.add(contents41);
		contents42.add("OT");	contents42.add("WT");	contents42.add("F");	contents42.add("TROTWT");	src.add(contents42);
		
		contents43.add("OT");	contents43.add("RD");	contents43.add("M");	contents43.add("TRMORD");	src.add(contents43);
		contents44.add("OT");	contents44.add("TD");	contents44.add("M");	contents44.add("TRMOTD");	src.add(contents44);
		contents45.add("OT");	contents45.add("WD");	contents45.add("M");	contents45.add("TRMOWD");	src.add(contents45);
		contents46.add("OT");	contents46.add("RT");	contents46.add("M");	contents46.add("TRMORT");	src.add(contents46);
		contents47.add("OT");	contents47.add("WR");	contents47.add("M");	contents47.add("TRMOWR");	src.add(contents47);
		contents48.add("OT");	contents48.add("WT");	contents48.add("M");	contents48.add("TRMOWT");	src.add(contents48);
		
		return src;
	}
	
	public String getTransModeCd(String src){
		String transModeCd = src;
		if(src != null && src.equals("TW")){
			transModeCd = "WT";
		}else if(src != null && src.equals("RW")){
			transModeCd = "WR";
		}else if(src != null && src.equals("TR")){
			transModeCd = "RT";
		}
		
		return transModeCd;
	}
	
}
