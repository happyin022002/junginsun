/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0102Event.java
*@FileTitle      : Daily Forecast Input
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.02
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2009.09.02
* 1.0 Creation
* history
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.spc.common.SPCUtil;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author CHOI Yun Sung
 * @see ViewAdapter 참조
 * @since CHOI Yun Sung 
 */
public class EsmSpc0102ViewAdapter extends ViewAdapter { 

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();
		
		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		String[] weeks      = new String[30];
		String[] vvds       = new String[30];
		String[] ctrl_hcArr = new String[30];
		String[] ctrl_45Arr = new String[30];
		String[] ctrl_53Arr = new String[30];
		String[] ctrl_rfArr = new String[30];
		String[] ctrl_wtArr = new String[30];
		
		int week_cnt = 0;
		
		String salesRepCodeList   = null;	// Data변화없이 Save시 저장시킬 Sales Rep Code
		String beforeSalesRepCode = null;	// Sales Rep Code중복되지 않도록
		
		int titleRows    = 4;
		int vvd_cnt      = 0;
//		int lvl          = 0;
		int lvl1         = 0;
		int lvl2         = 0;
		int rnum         = 0;
		int child        = 0;
		int colCount     = 46;		//36;Fcast TotalTEU, Confirm TotalTEU추가, 53 관련 추가, 20160211.MOD : fcast, bkg, confirm zone : 43->47 //20160405.MOD : 47->46
		int infoColCount = 22;		//20160211.MOD : hidden key값인듯 infoColumnCount 맞추기, 19->23 //20160405.MOD : 23->22
		int polSeq       = 0;		//20160112.ADD
		int podSeq       = 0;		//20160112.ADD
		String bfsubOfcCd = "";		//20160112.ADD
		String bfcustCd = "";		//20160216.ADD
		String bfctrcCustCd = "";	//20160216.ADD
		
		String fcast_ttl_qty     = "";
		String fcast_ttl_teu_qty = "";
		String fcast_40ft_hc_qty = "";
		String fcast_45ft_hc_qty = "";
		String fcast_53ft_qty    = "";
		String fcast_rf_qty      = "";
		String fcast_ttl_wgt     = "";
		String cfm_ttl_qty       = "";
		String cfm_40ft_hc_qty   = "";
		String cfm_45ft_hc_qty   = "";
		String cfm_53ft_qty      = "";
		String cfm_rf_qty        = "";
		String cfm_ttl_wgt       = "";
		
		int rowNum  = titleRows;
		int rowLane = titleRows;
		int rowRep  = titleRows;
		int rowPol  = titleRows;
		
//		String key         = "";
//		String oldKey      = "";
		String srep        = "";
		String cust_tp_cd  = "";
		String cust_cnt_cd = "";
		String cust_seq    = "";
		String ctrt_no     = "";			//20160328.ADD
		String ctrt_cust_cnt_cd = "";		//20160215.ADD
		String ctrt_cust_seq    = "";		//20160215.ADD	
		String pol         = "";
		String pod         = "";
		String ioc_ts_cd   = "";
		String bgColor     = "";
		String color       = "";
		String vsl_cd      = "";
		String sameColor   = "BLUE";
		String skipColor   = "RED";
		String ctrl_lvl    = "";
		String bkgBGColor  = "240,240,240";
		String cfmBGColor  = "240,245,245";
		
		boolean ctrl_hc = false;
		boolean ctrl_45 = false;
		boolean ctrl_53 = false;
		boolean ctrl_rf = false;
		boolean ctrl_wt = false;
		
		boolean isMaster   = false;
		boolean isForecast = false;
		boolean isEditable = false;
		
		int treeLvl = 0;
		String[] colors = SPCUtil.getColors(3);
		
		salesRepCodeList   = "";
		beforeSalesRepCode = "";
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();
			
//			lvl   = Integer.parseInt(nullToZero(getNull(colValues.get("lvl"))));
			lvl1  = Integer.parseInt(nullToZero(getNull(colValues.get("lvl1"))));
			lvl2  = Integer.parseInt(nullToZero(getNull(colValues.get("lvl2"))));
			rnum  = Integer.parseInt(nullToZero(getNull(colValues.get("rnum"))));
			child = Integer.parseInt(nullToZero(getNull(colValues.get("chl"))));
			polSeq= Integer.parseInt(nullToZero(getNull(colValues.get("pol_seq"))));	//20160112.ADD
			podSeq= Integer.parseInt(nullToZero(getNull(colValues.get("pod_seq"))));	//20160112.ADD
			
			srep        = getNull(colValues.get("srep_cd"));
			cust_tp_cd  = getNull(colValues.get("cust_tp_cd"));
			cust_cnt_cd = getNull(colValues.get("cust_cnt_cd"));
			cust_seq    = getNull(colValues.get("cust_seq"));
			
			ctrt_no     = getNull(colValues.get("ctrt_no"));							//20160328.ADD
			ctrt_cust_cnt_cd = getNull(colValues.get("ctrt_cust_cnt_cd"));				//20160215.ADD
			ctrt_cust_seq = getNull(colValues.get("ctrt_cust_seq"));					//20160215.ADD
			
			pol    = getNull(colValues.get("pol_cd"));
			pod    = getNull(colValues.get("pod_cd"));
			vsl_cd = getNull(colValues.get("vsl_cd"));
			if(vsl_cd == null) vsl_cd = "";
			ioc_ts_cd = getNull(colValues.get("ioc_ts_cd"));

			ctrl_lvl = getNull(colValues.get("ctrl_lvl"));
			ctrl_hc  = getNull(colValues.get("ctrl_hc")).equals("Y");
			ctrl_45  = getNull(colValues.get("ctrl_45")).equals("Y");
			ctrl_53  = getNull(colValues.get("ctrl_53")).equals("Y");
			ctrl_rf  = getNull(colValues.get("ctrl_rf")).equals("Y");
			ctrl_wt  = getNull(colValues.get("ctrl_wt")).equals("Y");
			
			fcast_ttl_teu_qty = getNull(colValues.get("fcast_ttl_teu_qty"));	
			fcast_ttl_qty     = getNull(colValues.get("fcast_ttl_qty"));
			fcast_40ft_hc_qty = getNull(colValues.get("fcast_40ft_hc_qty"));
			fcast_45ft_hc_qty = getNull(colValues.get("fcast_45ft_hc_qty"));
			fcast_53ft_qty    = getNull(colValues.get("fcast_53ft_qty"));
			fcast_rf_qty      = getNull(colValues.get("fcast_rf_qty"));
			fcast_ttl_wgt     = getNull(colValues.get("fcast_ttl_wgt"));
			
			cfm_ttl_qty     = getNull(colValues.get("cfm_ttl_qty"));
			cfm_40ft_hc_qty = getNull(colValues.get("cfm_40ft_hc_qty"));
			cfm_45ft_hc_qty = getNull(colValues.get("cfm_45ft_hc_qty"));
			cfm_53ft_qty    = getNull(colValues.get("cfm_53ft_qty"));
			cfm_rf_qty      = getNull(colValues.get("cfm_rf_qty"));
			cfm_ttl_wgt     = getNull(colValues.get("cfm_ttl_wgt"));

			isMaster   = !getNull(colValues.get("mst_cnt")).equals("0");
			isForecast = !getNull(colValues.get("fcast_cnt")).equals("0");
			
//			key = srep + "|" + cust_tp_cd + "|" + cust_cnt_cd + "|" + cust_seq + "|" + lvl1 + "|" + pol + "|" + pod;
			
			String vvd = vsl_cd + getNull(colValues.get("skd_voy_no")) + getNull(colValues.get("skd_dir_cd"));
			vvd = vvd.trim();
			weeks[rnum-1] = getNull(colValues.get("cost_yr")) + getNull(colValues.get("cost_wk"));
			vvds[rnum-1]  = vvd;
			
			//vvd별 control option저장
			ctrl_hcArr[rnum-1] = getNull(colValues.get("ctrl_hc"));
			ctrl_45Arr[rnum-1] = getNull(colValues.get("ctrl_45"));
			ctrl_53Arr[rnum-1] = getNull(colValues.get("ctrl_53"));
			ctrl_rfArr[rnum-1] = getNull(colValues.get("ctrl_rf"));
			ctrl_wtArr[rnum-1] = getNull(colValues.get("ctrl_wt"));

			week_cnt = (week_cnt < rnum) ? rnum : week_cnt;
			
			if(vvd_cnt == 0){
//				String rowMerge = lvl1 <= 1? "TRUE":"FALSE";
				treeLvl = lvl1<=1?1:lvl2+2;
				if(i==0) {
					//첫번째 ROW의 VVD ROWMERGE를 위해 따로 구현함
					sbufXML.append("<TR Align='Center'  MERGE='TRUE' HIDDEN='TRUE'>");
//					sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))     + "*</TD>");
//					sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd")) + "*</TD>");
//					sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))   + "*</TD>");
//					sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd"))     + "*</TD>");
//					sbufXML.append("	<TD>" + ioc_ts_cd + "*</TD>");
//					sbufXML.append("	<TD>" + getNull(colValues.get("rgn_ofc_cd")) + "*</TD>");
				} else {
					if("D".equals(ctrl_lvl)||!ioc_ts_cd.equals("O")) {
						sbufXML.append("<TR>");
					} else {
						sbufXML.append("<TR"+( lvl2==2?" HIDDEN='TRUE'":"")+">");						
					}

				}
//				sbufXML.append("<TR"+(lvl2==2?" HIDDEN='TRUE'":"")+">");
//				sbufXML.append("<TR LEVEL='" + treeLvl + "'>");
				
				//d_변수 zone
				if(i==0) {
					//20160112.MOD : 위치변경
					sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))     + "</TD>");
					sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
					sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))   + "</TD>");
					sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd"))     + "</TD>");
					sbufXML.append("	<TD>" + ioc_ts_cd + "</TD>");
					sbufXML.append("	<TD>" + getNull(colValues.get("rgn_ofc_cd")) + "</TD>");					
					sbufXML.append("	<TD>" + getNull(colValues.get("sub_ofc_cd")) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:"") + "' FONTCOLOR='"+ (lvl1<=1?colors[lvl1]:("".equals(srep)?"#FFFFFF":"")) +"'>" + ("".equals(srep)?"":srep) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:"") + "' FONTCOLOR='"+ (lvl1<=1?colors[lvl1]:("".equals(getNull(colValues.get("srep_nm")))?"#FFFFFF":"")) +"'><![CDATA[" + getNull(colValues.get("srep_nm")) + "]]></TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + cust_tp_cd + "</TD>");
					//sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + cust_cnt_cd + cust_seq + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' FONTCOLOR='"+(lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:""))+"'>" +cust_cnt_cd + cust_seq + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' ><![CDATA[" + (lvl1==2&&treeLvl==2?"TOTAL":getNull(colValues.get("cust_nm"))) + "]]></TD>");
					//20160203.ADD
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + "" + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + "" + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + "" + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + "" + "</TD>");
					
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "'>" + (lvl1==1?"TGT/Alloc":(lvl2==0 && (lvl1==2 || (lvl1==3 && child>0)))?"-":pol) + "</TD>");
	//				sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "'>" + (lvl1==1?"TGT/Alloc":(lvl1>=2 && lvl2==1)?"-":pod) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "'>" + (lvl1==1?"":(lvl1>=2 && lvl2==1)?"-":pod) + "</TD>");		
				} else {
					//20160112.MOD : 빈값으로..
					sbufXML.append("	<TD>" + "" + "</TD>");
					sbufXML.append("	<TD>" + "" + "</TD>");
					sbufXML.append("	<TD>" + "" + "</TD>");
					sbufXML.append("	<TD>" + "" + "</TD>");
					sbufXML.append("	<TD>" + "" + "</TD>");
					sbufXML.append("	<TD>" + "" + "</TD>");		
					//20160112.ADD : 첫줄만 나오게..
					sbufXML.append("	<TD>" + (getNull(colValues.get("sub_ofc_cd")).equals(bfsubOfcCd)?"":colValues.get("sub_ofc_cd")) + "</TD>");
					//20160112.ADD : 첫줄만 나오게..
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:"") + "' FONTCOLOR='"+ (lvl1<=1?colors[lvl1]:("".equals(srep)?"#FFFFFF":"")) +"'>" + (treeLvl==2?srep:"") + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:"") + "' FONTCOLOR='"+ (lvl1<=1?colors[lvl1]:("".equals(getNull(colValues.get("srep_nm")))?"#FFFFFF":"")) +"'><![CDATA[" + (treeLvl==2?("".equals(getNull(colValues.get("srep_nm")))?".":getNull(colValues.get("srep_nm"))):"") + "]]></TD>");
					//account-code, 20160112.ADD : 첫줄만 나오게..
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + ((srep+cust_tp_cd+cust_cnt_cd+cust_seq).equals(bfcustCd)?"":cust_tp_cd) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' FONTCOLOR='"+(lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:""))+"'>" + ((srep+cust_tp_cd+cust_cnt_cd+cust_seq).equals(bfcustCd)?"":(cust_cnt_cd+cust_seq)) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' ><![CDATA[" + (lvl1==2&&treeLvl==2?"TOTAL":((srep+cust_tp_cd+cust_cnt_cd+cust_seq).equals(bfcustCd)?"":getNull(colValues.get("cust_nm"))) ) + "]]></TD>");
					//20160203.ADD, 20160215.MOD, 20160325.MOD
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + ((cust_tp_cd+cust_cnt_cd+cust_seq+ctrt_no+ctrt_cust_cnt_cd+ctrt_cust_seq).equals(bfctrcCustCd)?"":getNull(colValues.get("ctrt_no"))) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + ((cust_tp_cd+cust_cnt_cd+cust_seq+ctrt_no+ctrt_cust_cnt_cd+ctrt_cust_seq).equals(bfctrcCustCd)?"":ctrt_cust_cnt_cd+ctrt_cust_seq) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "' >" + ((cust_tp_cd+cust_cnt_cd+cust_seq+ctrt_no+ctrt_cust_cnt_cd+ctrt_cust_seq).equals(bfctrcCustCd)?"":getNull(colValues.get("ctrt_cust_nm"))) + "</TD>");
					
					//POL: merge풀고 최상의 타이틀만..
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "'>" + (lvl1==1?"TGT/Alloc":(lvl2==0 && (lvl1==2 || (lvl1==3 && child>0)))?"-":(lvl2>1?"":pol)) + "</TD>");
	//				sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "'>" + (lvl1==1?"TGT/Alloc":(lvl1>=2 && lvl2==1)?"-":pod) + "</TD>");
					sbufXML.append("	<TD BGCOLOR='" + (lvl1<=1?colors[lvl1]:(treeLvl==2?lvl1==2?"240,230,240":colors[treeLvl]:"")) + "'>" + (lvl1==1?"":(lvl1>=2 && lvl2==1)?"-":pod) + "</TD>");		
				}				
			}
			
			vvd_cnt = vvd_cnt + 1;
			//타이틀데이타
			if(lvl1 == 0){
				for(int t = 0 ; t < vvds.length ; t++){
					vvds[t] = "";
				}				
				//모르겠다..
				for(; vvd_cnt < rnum ; vvd_cnt++){
					for(int t = 0 ; t < colCount ; t++){
						sbufXML.append("	<TD BGCOLOR='" + colors[0] + "'></TD>");
					}
				}
				//hidden key zone
				for(int t = 0 ; t < infoColCount ; t++){
					sbufXML.append("	<TD></TD>");
				}
				
				//fcast, bkg, confirm zone
				for(int t = infoColCount ; t < colCount ; t++){
					sbufXML.append("	<TD Align='Center' BGCOLOR='" + colors[0] + "' FontBold='1' COLOR='0,83,116' EDIT='0'>" + vvd + "</TD>");
				}
			//TGT/Alloc
			} else if(lvl1 == 1){				
				//모르겠다..
				for(; vvd_cnt < rnum ; vvd_cnt++){
					for(int t = 0 ; t < colCount ; t++){
						sbufXML.append("	<TD BGCOLOR='" + colors[1] + "' ></TD>");
					}
				}
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD>" + vvd + "</TD>");
				
				for(int t = 3 ; t < infoColCount ; t++){
					sbufXML.append("	<TD></TD>");
				}
				
				for(int t = infoColCount ; t < colCount ; t++){
					sbufXML.append("	<TD DATA-FORMAT='dfNone' DATA-ALIGN='daCenter' BGCOLOR='" + colors[1] + "' EDIT='0' >" + fcast_ttl_qty + "</TD>");
				}
			//데이타부
			} else {
				for(; vvd_cnt < rnum ; vvd_cnt++){
					sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:"") + "'></TD>");
					sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:"") + "'></TD>");
					sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:"") + "'>" + vvds[vvd_cnt-1] + "</TD>");
					
					for(int t = 3 ; t < infoColCount + 5 ; t++){
						sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'></TD>");
					}
					
					for(int t = infoColCount + 5 ; t < infoColCount + 12 ; t++){
						sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'></TD>");
					}
					
					for(int t = infoColCount + 12 ; t < colCount ; t++){
						sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'></TD>");
					}
				}
				
				isEditable = lvl2 > 0 && lvl1 == 3 && !vsl_cd.equals("TTL") && (isMaster||isForecast) && ((lvl2 == 2 && (ctrl_lvl.equals("D") || !ioc_ts_cd.equals("O")) ) || (ioc_ts_cd.equals("O") && !ctrl_lvl.equals("D") && lvl2 == 1));
				bgColor    = isEditable?"255,255,128":"";
				color      = "";

				// Data변화없이 Save시 저장시킬 Sales Rep Code, 변경가능한 ROW만 처리
				if(!beforeSalesRepCode.equals(srep) && isEditable) {
					beforeSalesRepCode = srep;
					salesRepCodeList   = salesRepCodeList + "|" + srep;
				}
				
				sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))     + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))   + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd"))     + "</TD>");
				sbufXML.append("	<TD>" + vsl_cd + "</TD>");	
				sbufXML.append("	<TD>" + getNull(colValues.get("skd_voy_no")).trim() + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("skd_dir_cd")).trim() + "</TD>");
				sbufXML.append("	<TD>" + ioc_ts_cd + "</TD>");
				sbufXML.append("	<TD >" + srep + "</TD>");
				sbufXML.append("	<TD>" + cust_cnt_cd + "</TD>");
				sbufXML.append("	<TD>" + cust_seq + "</TD>");
				//20160203.ADD start, 20160325.MOD
				sbufXML.append("	<TD>" + ctrt_no   		  + "</TD>");				//20160328.MOD
				sbufXML.append("	<TD>" + ctrt_cust_cnt_cd  + "</TD>");				//20160215.MOD
				sbufXML.append("	<TD>" + ctrt_cust_seq     + "</TD>");
				//20160203.ADD end
				sbufXML.append("	<TD>" + pol + "</TD>");
				sbufXML.append("	<TD>" + pod + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("ofc_cd")) + "</TD>");
				sbufXML.append("	<TD>" + cust_tp_cd + "</TD>");
				sbufXML.append("	<TD>" + (lvl1==3&&lvl2==2&&(!cfm_ttl_qty.equals(fcast_ttl_qty)||!cfm_40ft_hc_qty.equals(fcast_40ft_hc_qty)||!cfm_45ft_hc_qty.equals(fcast_45ft_hc_qty)||!cfm_53ft_qty.equals(fcast_53ft_qty)||!cfm_rf_qty.equals(fcast_rf_qty)||!cfm_ttl_wgt.equals(fcast_ttl_wgt))?"D":"") + "</TD>");
				sbufXML.append("	<TD>" + ctrl_lvl + "</TD>");
				sbufXML.append("	<TD>" + (cfm_ttl_qty.equals(fcast_ttl_qty)?"S":"D") + "," + (cfm_40ft_hc_qty.equals(fcast_40ft_hc_qty)?"S":"D") + "," + (cfm_45ft_hc_qty.equals(fcast_45ft_hc_qty)?"S":"D") + "," + (cfm_53ft_qty.equals(fcast_53ft_qty)?"S":"D") + "," + (cfm_rf_qty.equals(fcast_rf_qty)?"S":"D") + "," + (cfm_ttl_wgt.equals(fcast_ttl_wgt)?"S":"D") + "</TD>");
				sbufXML.append("	<TD>" + (lvl1==3&&lvl2==2&&isForecast?"R":"") + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2&&lvl1==2?"240,230,240":colors[2]) + "'>" + fcast_ttl_teu_qty + "</TD>");
//				if(lvl1==2&&treeLvl==2){
//					log.debug("fcast_ttl_teu_qty : " + fcast_ttl_teu_qty);
//					log.debug("fcast_ttl_qty : " + fcast_ttl_qty);
//				}
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bgColor) + "' COLOR='" + (!isMaster?skipColor:cfm_ttl_qty.equals(fcast_ttl_qty)?sameColor:color) +"'>" + fcast_ttl_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:isEditable&&!ctrl_hc?"255,255,200":bgColor) + "' COLOR='" + (!isMaster?skipColor:cfm_40ft_hc_qty.equals(fcast_40ft_hc_qty)?sameColor:color) + "'>" + fcast_40ft_hc_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:isEditable&&!ctrl_45?"255,255,200":bgColor) + "' COLOR='" + (!isMaster?skipColor:cfm_45ft_hc_qty.equals(fcast_45ft_hc_qty)?sameColor:color) + "'>" + fcast_45ft_hc_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:isEditable&&!ctrl_53?"255,255,200":bgColor) + "' COLOR='" + (!isMaster?skipColor:cfm_53ft_qty.equals(fcast_53ft_qty)?sameColor:color) + "'>" + fcast_53ft_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:isEditable&&!ctrl_rf?"255,255,200":bgColor) + "' COLOR='" + (!isMaster?skipColor:cfm_rf_qty.equals(fcast_rf_qty)?sameColor:color)   + "'>" + fcast_rf_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:isEditable&&!ctrl_wt?"255,255,200":bgColor) + "' COLOR='" + (!isMaster?skipColor:cfm_ttl_wgt.equals(fcast_ttl_wgt)?sameColor:color) + "'>" + fcast_ttl_wgt + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_ttl_qty"))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_20ft_qty"))    + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_40ft_qty"))    + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_40ft_hc_qty")) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_45ft_hc_qty")) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_53ft_qty"))    + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_rf_qty"))      + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'>" + getNull(colValues.get("bkg_ttl_wgt"))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:bkgBGColor) + "'></TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("cfm_ttl_qty"))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("cfm_40ft_hc_qty")) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("cfm_45ft_hc_qty")) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("cfm_53ft_qty"))    + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("cfm_rf_qty"))      + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("cfm_ttl_wgt"))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("fcast_40ft_hc_rat"))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + (treeLvl==2?lvl1==2?"240,230,240":colors[2]:cfmBGColor) + "'>" + getNull(colValues.get("fcast_45ft_hc_rat"))     + "</TD>");
			}
			
			if(vsl_cd.equals("TTL")){
				vvd_cnt = 0;
				switch(treeLvl){
				case 1:
					rowLane = rowNum;
					break;
				case 2:
					rowRep = rowNum;
					rowPol = rowNum;
					break;
				case 3:
					rowPol = rowNum;
					break;
				case 4:
					break;
				}
				
				sbufXML.append("	<TD>" + treeLvl + "</TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD>" + rowLane + "</TD>");
				sbufXML.append("	<TD>" + rowRep  + "</TD>");
				sbufXML.append("	<TD>" + rowPol  + "</TD>");
				
				sbufXML.append("	<TD>" + (treeLvl==2?1:0)  + "</TD>");
				sbufXML.append("	<TD>" + (treeLvl==3?1:0)  + "</TD>");
				sbufXML.append("	<TD>" + (treeLvl==4?1:0)  + "</TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("</TR>\n");
				
				rowNum = rowNum + 1;
			}
//			oldKey = key;	
			
			bfsubOfcCd 	 = getNull(colValues.get("sub_ofc_cd"));		//20160120.ADD
			bfcustCd 	 = srep + cust_tp_cd + cust_cnt_cd + cust_seq;				//20160215.ADD
			bfctrcCustCd = cust_tp_cd+cust_cnt_cd + cust_seq + ctrt_no + ctrt_cust_cnt_cd + ctrt_cust_seq; //20160215.ADD, 20160328.ADD
		}
		sbufXML.append("</DATA>\n");
		
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(SQLException ex){
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		return sb.toString();
	}

	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}

		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	
	private String nullToZero(String str) {
		String rtnStr = ""; //소스 품질 수정 요청건
		//if(str == null || str == "") //소스 품질 수정 요청건
		if(str == null || "".equals(str)) {
			rtnStr = "0";
		} else {
			rtnStr = str;			
		}
		return rtnStr;
	}
	
	protected String getETCData(EventResponse eventResponse) {
		if(eventResponse==null) 
			return "";
		
		List<Object> vos = eventResponse.getRsVoList();
		int realCnt = vos.size();
		
		String[] weeks = new String[30];
		String[] vvds  = new String[30];
		int week_cnt   = 0;
		int lvl1       = 0;
		int lvl2       = 0;
		int rnum       = 0;
		
		String srep        = "";
		String ioc_ts_cd   = "";
		String vsl_cd      = "";
		String ctrl_lvl    = "";
		String salesRepCodeList   = "";
		String beforeSalesRepCode = "";
		boolean isMaster   = false;
		boolean isForecast = false;
		boolean isEditable = false;
		
		//화면조회후 control option에 따라 Data Setting을 하기 위해 추가
		
		String[] ctrlHcA = new String[30];
		String[] ctrl45A = new String[30];
		String[] ctrl53A = new String[30];
		String[] ctrlRfA = new String[30];
		String[] ctrlWtA = new String[30];	
		String[] ctrlLvlA = new String[30];
		
		String ttlHc = "N";
		String ttl45 = "N";
		String ttl53 = "N";
		String ttlRf = "N";
		String ttlWt = "N";
		String ttlLvl = "L";
		
		for(int i=0;i<realCnt;i++){
			SearchDailyForecastManageListVO vo = (SearchDailyForecastManageListVO)vos.get(i);
			Map<String, String> colValues = vo.getColumnValues();
			
			lvl1 = Integer.parseInt(nullToZero(getNull(colValues.get("lvl1"))));
			lvl2 = Integer.parseInt(nullToZero(getNull(colValues.get("lvl2"))));
			rnum = Integer.parseInt(nullToZero(getNull(colValues.get("rnum"))));
			
			srep      = getNull(colValues.get("srep_cd"));
			ioc_ts_cd = getNull(colValues.get("ioc_ts_cd"));
			vsl_cd    = getNull(colValues.get("vsl_cd"));
			ctrl_lvl  = getNull(colValues.get("ctrl_lvl"));
			
			isMaster   = !getNull(colValues.get("mst_cnt")).equals("0");
			isForecast = !getNull(colValues.get("fcast_cnt")).equals("0");
			
			String vvd = vsl_cd + getNull(colValues.get("skd_voy_no")) + getNull(colValues.get("skd_dir_cd"));
			vvd = vvd.trim();
			weeks[rnum-1] = getNull(colValues.get("cost_yr")) + getNull(colValues.get("cost_wk"));
			vvds[rnum-1]  = vvd;
			
			ctrlHcA[rnum-1] = getNull(colValues.get("ctrl_hc"));
			ctrl45A[rnum-1] = getNull(colValues.get("ctrl_45"));
			ctrl53A[rnum-1] = getNull(colValues.get("ctrl_53"));
			ctrlRfA[rnum-1] = getNull(colValues.get("ctrl_rf"));
			ctrlWtA[rnum-1] = getNull(colValues.get("ctrl_wt"));
			ctrlLvlA[rnum-1] = ctrl_lvl;
			
			week_cnt = week_cnt < rnum ? rnum : week_cnt;
			
			if(lvl1 == 0){
				for(int t = 0 ; t < vvds.length ; t++){
					vvds[t] = "";
					ctrlHcA[t] = "";
					ctrl45A[t] = "";
					ctrl53A[t] = "";
					ctrlRfA[t] = "";
					ctrlWtA[t] = "";
				}
			} else {
				isEditable = lvl2 > 0 && lvl1 == 3 && !vsl_cd.equals("TTL") && (isMaster||isForecast) && ((lvl2 == 2 && (ctrl_lvl.equals("D") || !ioc_ts_cd.equals("O")) ) || (ioc_ts_cd.equals("O") && !ctrl_lvl.equals("D") && lvl2 == 1));
				
				if(!beforeSalesRepCode.equals(srep) && isEditable) {
					beforeSalesRepCode = srep;
					salesRepCodeList   = salesRepCodeList + "|" + srep;
				}
			}
		}
		
		String yrwk = "";
		String strVVD = "";
		String ctrlHc = "";
		String ctrl45 = "";
		String ctrl53 = "";
		String ctrlRf = "";
		String ctrlWt = "";
		
		StringBuffer sbYrwk = new StringBuffer(); //소스 품질 수정 요청건
		StringBuffer sbVVD = new StringBuffer(); //소스 품질 수정 요청건
		StringBuffer sbCtrlHc = new StringBuffer(); //소스 품질 수정 요청건
		StringBuffer sbCtrl45 = new StringBuffer(); //소스 품질 수정 요청건
		StringBuffer sbCtrl53 = new StringBuffer(); //소스 품질 수정 요청건
		StringBuffer sbCtrlRf = new StringBuffer(); //소스 품질 수정 요청건
		StringBuffer sbCtrlWt = new StringBuffer(); //소스 품질 수정 요청건
		
		for(int i = 0 ; i < week_cnt ; i++){
//			yrwk = yrwk + "|" + weeks[i];  //소스 품질 수정 요청건
//			strVVD = strVVD + "|" + vvds[i];
//			ctrlHc = ctrlHc + "|" + ctrlHcA[i];
//			ctrl45 = ctrl45 + "|" + ctrl45A[i];
//			ctrl53 = ctrl53 + "|" + ctrl53A[i];
//			ctrlRf = ctrlRf + "|" + ctrlRfA[i];
//			ctrlWt = ctrlWt + "|" + ctrlWtA[i];
			
			sbYrwk.append("|").append(weeks[i]);  //소스 품질 수정 요청건
			sbVVD.append("|").append(vvds[i]);
			sbCtrlHc.append("|").append(ctrlHcA[i]);
			sbCtrl45.append("|").append(ctrl45A[i]);
			sbCtrl53.append("|").append(ctrl53A[i]);
			sbCtrlRf.append("|").append(ctrlRfA[i]);
			sbCtrlWt.append("|").append(ctrlWtA[i]);
			
			if("Y".equals(ctrlHcA[i])) ttlHc = "Y";
			if("Y".equals(ctrl45A[i])) ttl45 = "Y";
			if("Y".equals(ctrl53A[i])) ttl53 = "Y";
			if("Y".equals(ctrlRfA[i])) ttlRf = "Y";
			if("Y".equals(ctrlWtA[i])) ttlWt = "Y";			
			if("D".equals(ctrlLvlA[i])||!"O".equals(ioc_ts_cd)) ttlLvl = "D";
		}
		
		yrwk = sbYrwk.toString(); //소스 품질 수정 요청건
		strVVD = sbVVD.toString(); 
		ctrlHc = sbCtrlHc.toString();
		ctrl45 = sbCtrl45.toString();
		ctrl53 = sbCtrl53.toString();
		ctrlRf = sbCtrlRf.toString();
		ctrlWt = sbCtrlWt.toString();
		
		ctrlHc = ctrlHc + ttlHc;
		ctrl45 = ctrl45 + ttl45;
		ctrl53 = ctrl53 + ttl53;
		ctrlRf = ctrlRf + ttlRf;
		ctrlWt = ctrlWt + ttlWt;
		
		StringBuilder sb = new StringBuilder();		
		try{		
			sb.append("<ETC-DATA>\n");
			sb.append("    <ETC KEY='status'>OK</ETC>\n");
			sb.append("    <ETC KEY='week'>" + yrwk + "</ETC>\n");
			sb.append("    <ETC KEY='vvd'>" + strVVD + "</ETC>\n");
			sb.append("    <ETC KEY='salesRepCodeList'>" + salesRepCodeList + "</ETC>\n");
			sb.append("    <ETC KEY='ctrl_hc'>" + ctrlHc + "</ETC>\n");
			sb.append("    <ETC KEY='ctrl_45'>" + ctrl45 + "</ETC>\n");
			sb.append("    <ETC KEY='ctrl_53'>" + ctrl53 + "</ETC>\n");
			sb.append("    <ETC KEY='ctrl_rf'>" + ctrlRf + "</ETC>\n");
			sb.append("    <ETC KEY='ctrl_wt'>" + ctrlWt + "</ETC>\n");
			sb.append("    <ETC KEY='ctrl_lvl_all'>" + ttlLvl +"</ETC>\n");
			sb.append("    <ETC KEY='ctrl_tpsz_all'>|" + ttlHc +"|"+ ttl45 +"|"+ ttl53 +"|"+ ttlRf +"|"+ ttlWt +"</ETC>\n");			
			sb.append("</ETC-DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	} 

}