/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0102ViewAdapter.java
*@FileTitle : Daily Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.10
*@LastModifier : 전상화
*@LastVersion : 1.0
* 2012.09.10 전상화
* 1.0 Creation
* 2013.01.04 최윤성 [CHM-201322312-01] FCST Input(SELSA) 2차 수정요청
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2015.03.10 [CHM-201534747]Forecast Input(Loading) 화면 정보 추가-Weight
* 2015.03.13 [CHM-201534835]Forecast Input POL별 Summary 데이터 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;

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
		
		int totCnt  = vos.size();
		int realCnt = vos.size();
		
		// 조회된 전체 Count 를  화면에 맞게 주차별로 변경후 화면에 보이는 실제 Row 수( TTL 의 개수 )
		totCnt = Integer.parseInt(nullToZero(getNull(vos.get(0).getColumnValues().get("tot_cnt"))));
		
		String[] vvds = new String[30];
		
		int week_cnt = 0;
		
		String salesRepCodeList   = null;	// Data변화없이 Save시 저장시킬 Sales Rep Code
		String beforeSalesRepCode = null;	// Sales Rep Code중복되지 않도록
		
		int titleRows    = 4;
		int vvd_cnt      = 0;
		int lvl1         = 0;
		int lvl2         = 0;
		int rnum         = 0;
//		int child        = 0;
		int colCount     = 50;//43;	//36;Fcast TotalTEU, Confirm TotalTEU추가, 53 관련 추가 : 41-> 36 으로 수정 2012.09.10.
		int infoColCount = 23;
		int color_num    = 0;
		
		String fcast_ttl_qty     = "";
		String fcast_ttl_teu_qty = "";
		double fcast_20_qty      = 0;
		double fcast_40_qty      = 0;
		double bkg_20_qty        = 0;
		double bkg_40_qty        = 0;
		
		String fcast_20ft_dry_qty = "";
		String fcast_40ft_dry_qty = "";
		String fcast_40ft_hc_qty = "";
		String fcast_45ft_hc_qty = "";
		String fcast_53ft_qty    = "";
		String fcast_rf_qty      = "";
		String fcast_rd_qty      = "";
		String fcast_ttl_wgt     = "";
		
		int rowNum  = titleRows;
		int rowLane = titleRows;
		int rowGrpA = titleRows;
		int rowGrpB = titleRows;
		int rowGrpBm = titleRows;
		int rowGrpBs = titleRows;
		int rowGrpC = titleRows;
		int rowRep  = titleRows;
		int rowUs = titleRows;
		int rowUsI  = titleRows;
		int rowUsL  = titleRows;
		int rowUsO  = titleRows;
		int rowPol  = titleRows;
		
		String srep        = "";
		String cust_tp_cd  = "";
		String cust_cnt_cd = "";
		String cust_seq    = "";
		String acct_lvl    = "";
		String pol         = "";
		String pod         = "";
		String ioc_ts_cd   = "";
		String vsl_cd      = "";
		String sameColor   = "BLUE";
		String skipColor   = "RED";
		String fontColor   = "";
		String ctrl_lvl    = "";
		
		String usa_bkg_mod_cd  = "";//
		
		boolean isMaster   = false;
		boolean isForecast = false;
		boolean isEditable = false;
		
		String cust_nm         = "";
		String bkg_cust_cnt_cd = "";
		String bkg_cust_seq    = "";
		String bkg_cust_nm     = "";
		
		String viewType = getNull(vos.get(0).getColumnValues().get("view_type"));
		
		int treeLvl = 0;
		
		String[] nColor     = { "225,244,226", "237,255,168", "235,240,255", "240,230,240", "", "", ""};						// 그 외
		String[] sColor     = { "225,244,226", "237,255,168", "", "", "", "", ""};												// Sales Rep 부분
		String[] tColor     = { "225,244,226", "237,255,168", "235,240,255", "240,230,240", "235,240,255", "235,240,255", "210,252,188"};	// F'cast Total 부분
		String[] bgColor    = { "225,244,226", "237,255,168", "235,240,255", "240,230,240", "", "255,255,128", "210,252,188"};				// F'cast 입력 부분 "255,255,128"이 노랑색
		String[] bkgBGColor = { "225,244,226", "237,255,168", "235,240,255", "240,230,240", "240,240,240", "240,240,240", "210,252,188"};	// BKG 부분
		
		salesRepCodeList   = "";
		beforeSalesRepCode = "";
		
		sbufXML.append("<DATA TOTAL='" + totCnt + "'>\n");
		
		for(int i=0;i<realCnt;i++){
			Map<String, String> colValues = vos.get(i).getColumnValues();				
			
			lvl1      = Integer.parseInt(nullToZero(getNull(colValues.get("lvl1"))));
			lvl2      = Integer.parseInt(nullToZero(getNull(colValues.get("lvl2"))));
			rnum      = Integer.parseInt(nullToZero(getNull(colValues.get("rnum"))));
//			child     = Integer.parseInt(nullToZero(getNull(colValues.get("chl"))));
			color_num = Integer.parseInt(nullToZero(getNull(colValues.get("color"))));
			
			srep        = getNull(colValues.get("srep_cd"));
			cust_tp_cd  = getNull(colValues.get("cust_tp_cd"));
			cust_cnt_cd = getNull(colValues.get("cust_cnt_cd"));
			
			acct_lvl    = getNull(colValues.get("acct_lvl"));
			
			cust_seq    = getNull(colValues.get("cust_seq"));
			cust_nm     = getNull(colValues.get("cust_nm"));			
			
			bkg_cust_cnt_cd = getNull(colValues.get("bkg_cust_cnt_cd"));
			bkg_cust_seq    = getNull(colValues.get("bkg_cust_seq"));
			bkg_cust_nm     = getNull(colValues.get("bkg_cust_nm"));
			
			pol    = getNull(colValues.get("pol_cd"));
			pod    = getNull(colValues.get("pod_cd"));
			vsl_cd = getNull(colValues.get("vsl_cd"));
			if(vsl_cd == null) vsl_cd = "";
			ioc_ts_cd = getNull(colValues.get("ioc_ts_cd"));

			ctrl_lvl = getNull(colValues.get("ctrl_lvl"));
			
			usa_bkg_mod_cd = colValues.get("usa_bkg_mod_cd");
			
			fcast_ttl_teu_qty = nullToZero(getNull(colValues.get("fcast_ttl_teu_qty")));
			fcast_ttl_qty     = nullToZero(getNull(colValues.get("fcast_ttl_qty")));
						
			fcast_20ft_dry_qty = nullToZero(getNull(colValues.get("fcast_20ft_dry_qty")));//추가
			fcast_40ft_dry_qty = nullToZero(getNull(colValues.get("fcast_40ft_dry_qty")));//추가
			fcast_40ft_hc_qty = nullToZero(getNull(colValues.get("fcast_40ft_hc_qty")));
			fcast_45ft_hc_qty = nullToZero(getNull(colValues.get("fcast_45ft_hc_qty")));
			fcast_53ft_qty    = nullToZero(getNull(colValues.get("fcast_53ft_qty")));
			fcast_rf_qty      = nullToZero(getNull(colValues.get("fcast_rf_qty")));
			fcast_rd_qty      = nullToZero(getNull(colValues.get("fcast_rd_qty")));//추가	
			fcast_ttl_wgt     = nullToZero(getNull(colValues.get("fcast_ttl_wgt")));
						
			isMaster   = !getNull(colValues.get("mst_cnt")).equals("0");
			isForecast = !getNull(colValues.get("fcast_cnt")).equals("0");
			fontColor  = (lvl1==3)||(lvl1==4&&lvl2==1)?"":(!isMaster?skipColor:sameColor);
//			fontColor  = (lvl1==3)||(lvl1==4&&lvl2<=2)?"":(!isMaster?skipColor:sameColor); //3-0:Group별 Alloc, 3-1:Fcst/BKG물량, 4-1:Sales Rep-Custome 변경안함

			String vvd = vsl_cd + getNull(colValues.get("skd_voy_no")) + getNull(colValues.get("skd_dir_cd"));
			vvd = vvd.trim();
			vvds[rnum-1]  = vvd;

			week_cnt = (week_cnt < rnum) ? rnum : week_cnt;
			
			if(vvd_cnt == 0){
				String rowMerge = (lvl1 <= 1 || (lvl1 == 3 && lvl2 == 0))? "TRUE":"FALSE";
				//0:1:VVD별 Total, 3-0:Group별 Alloc
				treeLvl = lvl1<=1?1:lvl2+2;

				
				sbufXML.append("<TR MERGE='" + rowMerge + "' LEVEL='" + treeLvl + "'>");
				sbufXML.append("	<TD>" + getNull(colValues.get("trd_cd"))     + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("sub_trd_cd")) + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("rlane_cd"))   + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("dir_cd"))     + "</TD>");
				sbufXML.append("	<TD>" + ioc_ts_cd + "</TD>");
				sbufXML.append("	<TD>" + getNull(colValues.get("rgn_ofc_cd")) + "</TD>");
				
//				sbufXML.append("	<TD INDENT='" + (lvl1>3||treeLvl<3?0:1) + "'>" + getNull(colValues.get("sub_ofc_cd")) + "</TD>");
				sbufXML.append("	<TD INDENT='" + (lvl1>3||treeLvl<4?0:1) + "'>" + getNull(colValues.get("sub_ofc_cd")) + "</TD>");
				
				sbufXML.append("	<TD BGCOLOR='" + sColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?0:1) + "'>" + srep + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + sColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?0:1) + "'><![CDATA[" + getNull(colValues.get("srep_nm")) + "]]></TD>");
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?0:1) + "'>" + cust_tp_cd + "</TD>");
				
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='1'>" + (lvl1==3&&lvl2>1?"":acct_lvl) + "</TD>");	// ACCT_LVL
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='1'>" + (lvl1==0?"":(lvl1==3&&lvl2>1?"":usa_bkg_mod_cd)) + "</TD>");//USA Mode
//				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='1'>" + usa_bkg_mod_cd + "</TD>");//USA Mode
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='1'>" + (lvl1==3&&lvl2>1?"":getNull(colValues.get("guide")))    + "</TD>");	// GUIDE
				
				//treeLvl3-->4로
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?0:1) + "'>" + cust_cnt_cd + cust_seq + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?0:1) + "'><![CDATA[" + ((lvl1==2&&treeLvl==2)||(lvl1==3&&lvl2==1)?"TOTAL":(cust_nm.equals("OTHERS")?cust_nm + " (+)":cust_nm)) + "]]></TD>");
//				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?0:1) + "'><![CDATA[" + ((lvl1==2&&treeLvl==2)||(lvl1==3&&lvl2==1)?"TOTAL":cust_nm) + "]]></TD>");
//				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<3?0:1) + "'>" + cust_cnt_cd + cust_seq + "</TD>");
//				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<3?0:1) + "'><![CDATA[" + ((lvl1==2&&treeLvl==2)||(lvl1==3&&lvl2==1)?"TOTAL":(cust_nm.equals("OTHERS")?cust_nm + " (+)":cust_nm)) + "]]></TD>");
				// S/C No 추가 - @2013.02.06
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?(getNull(colValues.get("sc_no")).isEmpty()?1:0):1) + "'>"  + getNull(colValues.get("sc_no"))   +"</TD>");
				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<4?(getNull(colValues.get("rfa_no")).isEmpty()?1:0):1) + "'>"  + getNull(colValues.get("rfa_no")) +"</TD>");				
//				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<3?(getNull(colValues.get("sc_no")).isEmpty()?1:0):1) + "'>"  + getNull(colValues.get("sc_no"))   +"</TD>");
//				sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' INDENT='" + (lvl1>3||treeLvl<3?(getNull(colValues.get("rfa_no")).isEmpty()?1:0):1) + "'>"  + getNull(colValues.get("rfa_no")) +"</TD>");				
				   
				// Add 2012.09.12.
				sbufXML.append("	<TD INDENT='1'></TD>");
				sbufXML.append("	<TD INDENT='1'>"+ bkg_cust_cnt_cd + bkg_cust_seq + "</TD>");
				sbufXML.append("	<TD INDENT='1'><![CDATA["+ bkg_cust_nm+ "]]></TD>");							
				sbufXML.append("	<TD INDENT='1'>"+ getNull(colValues.get("exist_flg"))   +"</TD>");		
				//QTA/Alloc(TEU)/Alloc(Weight) 
//				sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "' INDENT='1'>" + (lvl1==1?"QTA/Alloc":(lvl1==3&&lvl2==0?"Alloc":(lvl1==3&&lvl2==1?"-":(lvl1==4&&lvl2==1?"CTRT FCST":(lvl2==0 && (lvl1==2 || (lvl1==4 && child>0)))?"-":pol)))) + "</TD>");
//				sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "'>" + (lvl1==1?"QTA/Alloc":(lvl1==4&&lvl2==1?"CTRT FCST":(lvl1>=2 && lvl2==2)?"-":pod)) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "'>" + (lvl1==1?"QTA/Alloc(TEU)/Alloc(Weight)":(lvl1==2?pol:(lvl1==3&&lvl2==0?"Alloc":(treeLvl==4?"-":pol)))) + "</TD>"); //POL
				sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "'>" + (lvl1==1?"QTA/Alloc(TEU)/Alloc(Weight)":(lvl1==4&&lvl2==1?"":(treeLvl==5?"-":pod)))   + "</TD>"); //POD
//				sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "'>" + pod + "</TD>"); //POD

			
			}
			
			vvd_cnt = vvd_cnt + 1;
			if(lvl1 == 0){//VVD Total(Trade,Lane,IOC,RgnOffice)
				for(int t = 0 ; t < vvds.length ; t++){
					vvds[t] = "";
				}
				
				for(; vvd_cnt < rnum ; vvd_cnt++){
					for(int t = 0 ; t < colCount ; t++){
						sbufXML.append("	<TD BGCOLOR='" + bgColor[0] + "' INDENT='" + rnum%2 + "' CALCU-LOGIC='' DATA-ALIGN='daCenter'></TD>");
					}
				}
				
				for(int t = 0 ; t < infoColCount ; t++){
					sbufXML.append("	<TD DATA-ALIGN='daCenter'></TD>");
				}
				
				for(int t = infoColCount ; t < colCount ; t++){
					sbufXML.append("	<TD DATA-FORMAT='dfNone' DATA-ALIGN='daCenter' BGCOLOR='" + bgColor[0] + "' BOLD='TRUE' COLOR='0,83,116' CALCU-LOGIC=''>" + vvd + "</TD>");
				}
			} else if(lvl1 == 1){//VVD Total(QTA/Alloc)
				for(; vvd_cnt < rnum ; vvd_cnt++){
					for(int t = 0 ; t < colCount ; t++){
						sbufXML.append("	<TD BGCOLOR='" + bgColor[1] + "' INDENT='" + rnum%2 + "' CALCU-LOGIC='' DATA-ALIGN='daCenter'></TD>");
					}
				}
				
				sbufXML.append("	<TD DATA-ALIGN='daCenter'></TD>");
				sbufXML.append("	<TD DATA-ALIGN='daCenter'></TD>");
				sbufXML.append("	<TD DATA-ALIGN='daCenter'>" + vvd + "</TD>");
				
				for(int t = 3 ; t < infoColCount ; t++){
					sbufXML.append("	<TD DATA-ALIGN='daCenter'></TD>");
				}
				
				for(int t = infoColCount ; t < colCount ; t++){
					sbufXML.append("	<TD DATA-FORMAT='dfNone' DATA-ALIGN='daCenter' BGCOLOR='" + bgColor[1] + "' INDENT='" + rnum%2 + "' CALCU-LOGIC=''><![CDATA[" + fcast_ttl_qty+"" + "]]></TD>");
				}
			} else if(lvl1 == 3 && lvl2 == 0){//Acct LVL(Yeild Group)별 Alloc만
				for(; vvd_cnt < rnum ; vvd_cnt++){
					for(int t = 0 ; t < colCount ; t++){
						sbufXML.append("	<TD BGCOLOR='" + bgColor[1] + "' INDENT='" + rnum%2 + "' CALCU-LOGIC='' DATA-ALIGN='daCenter'></TD>");
					}
				}
				
				sbufXML.append("	<TD DATA-ALIGN='daCenter'></TD>");
				sbufXML.append("	<TD DATA-ALIGN='daCenter'></TD>");
				sbufXML.append("	<TD DATA-ALIGN='daCenter'>" + vvd + "</TD>");
				
				for(int t = 3 ; t < infoColCount ; t++){
					sbufXML.append("	<TD></TD>");
				}
				
				for(int t = infoColCount ; t < colCount ; t++){
					sbufXML.append("	<TD DATA-FORMAT='dfNone' DATA-ALIGN='daCenter' BGCOLOR='" + bgColor[1] + "' INDENT='" + rnum%2 + "' CALCU-LOGIC=''><![CDATA[" + fcast_ttl_qty+"" + "]]></TD>");
				}
			} else {
				
				
				for(; vvd_cnt < rnum ; vvd_cnt++){
					sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "'></TD>");
					sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "'></TD>");
					sbufXML.append("	<TD BGCOLOR='" + nColor[color_num] + "' DATA-ALIGN='daCenter'>" + vvds[vvd_cnt-1] + "</TD>");
					
					String color = "";
					if(lvl1==4&&lvl2==1){//SalesRep Total
						color = bgColor[6];
					}else
						color = bgColor[2];
					
					for(int t = 3 ; t < infoColCount ; t++){
						sbufXML.append("	<TD BGCOLOR='" + color + "'>0</TD>");	// Forecast 앞에 숨겨진 정보
					}
					
					sbufXML.append("	<TD BGCOLOR='" + color + "'>0</TD>");	// Forecast Total TEU
					sbufXML.append("	<TD BGCOLOR='" + color + "'>0</TD>");	// Forecast Total
					
					for(int t = infoColCount + 2 ; t < infoColCount + 12 ; t++){//9-->12
						sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor +"'>0</TD>");	// F'cast 부분
					}
					
					sbufXML.append("	<TD BGCOLOR='" + color + "'></TD>");	// Remark
					
					for(int t = infoColCount + 13 ; t < colCount ; t++){//10-->13
						sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>0</TD>");	// BKG 부분
						
					}
				}
				
				isEditable = "TRUE".equals(colValues.get("iseditable"))?true:false;
				
				// add 2012.10.10  bkg_cust 가 있으면 수정 불가.
				if(bkg_cust_seq !=null && bkg_cust_seq.length() > 0){
					isEditable = false;
				}
				
				if(isEditable) {
					color_num++;
				}

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
				sbufXML.append("	<TD INDENT='" + (lvl1>2?0:1) + "'>" + srep + "</TD>");		
				
				sbufXML.append("	<TD>" + usa_bkg_mod_cd + "</TD>");//USA Mode추가
				sbufXML.append("	<TD>" + (!bkg_cust_cnt_cd.equals("")?bkg_cust_cnt_cd:cust_cnt_cd) + "</TD>");
				sbufXML.append("	<TD>" + (!bkg_cust_seq.equals("")?bkg_cust_seq:cust_seq) + "</TD>");
				sbufXML.append("	<TD>" + pol + "</TD>");
				sbufXML.append("	<TD>" + pod + "</TD>");
				
				sbufXML.append("	<TD>" + getNull(colValues.get("ofc_cd")) + "</TD>");
				sbufXML.append("	<TD>" + cust_tp_cd + "</TD>");				
				sbufXML.append("	<TD>" + (lvl1==4&&lvl2==4?"D":"") + "</TD>");//43-->44
				sbufXML.append("	<TD>" + ctrl_lvl + "</TD>");				
				sbufXML.append("	<TD>" + getNull(colValues.get("fcast_seq"))   + "</TD>");				
				sbufXML.append("	<TD>" + getNull(colValues.get("sc_no"))       + "</TD>");				
				sbufXML.append("	<TD>" + getNull(colValues.get("sc_flg"))       + "</TD>");	
				sbufXML.append("	<TD>" + getNull(colValues.get("rfa_no"))      + "</TD>");				
				sbufXML.append("	<TD>" + (lvl1==4&&lvl2==4&&isForecast?"R":"") + "</TD>");//43-->44
				
				sbufXML.append("	<TD BGCOLOR='" + tColor[color_num] + "'>" + fcast_ttl_teu_qty + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + fcast_ttl_qty + "</TD>");
				
				if(viewType.equals("TEU")){
					fcast_20_qty = Double.valueOf(nullToZero(getNull(colValues.get("fcast_20ft_qty")))).doubleValue() + Double.valueOf(nullToZero(getNull(colValues.get("fcast_40ft_qty")))).doubleValue() * 2;
					fcast_40_qty = 0;
					bkg_20_qty   = Double.valueOf(nullToZero(getNull(colValues.get("bkg_20ft_qty")))).doubleValue() + Double.valueOf(nullToZero(getNull(colValues.get("bkg_40ft_qty")))).doubleValue() * 2;
					bkg_40_qty   = Double.valueOf(nullToZero(getNull(colValues.get("bkg_40ft_qty")))).doubleValue();
				} else if(viewType.equals("FEU")) {
					fcast_20_qty = 0;
					fcast_40_qty = Double.valueOf(nullToZero(getNull(colValues.get("fcast_20ft_qty")))).doubleValue() / 2 + Double.valueOf(nullToZero(getNull(colValues.get("fcast_40ft_qty")))).doubleValue();
					bkg_20_qty   = Double.valueOf(nullToZero(getNull(colValues.get("bkg_20ft_qty")))).doubleValue();
					bkg_40_qty   = Double.valueOf(nullToZero(getNull(colValues.get("bkg_20ft_qty")))).doubleValue() / 2 + Double.valueOf(nullToZero(getNull(colValues.get("bkg_40ft_qty")))).doubleValue();
				} else {
					fcast_20_qty = Double.valueOf(nullToZero(getNull(colValues.get("fcast_20ft_qty")))).doubleValue();
					fcast_40_qty = Double.valueOf(nullToZero(getNull(colValues.get("fcast_40ft_qty")))).doubleValue();
					bkg_20_qty   = Double.valueOf(nullToZero(getNull(colValues.get("bkg_20ft_qty")))).doubleValue();
					bkg_40_qty   = Double.valueOf(nullToZero(getNull(colValues.get("bkg_40ft_qty")))).doubleValue();
				}
				
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_20_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_40_qty + "</TD>");
				
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_20ft_dry_qty + "</TD>");//추가	
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_40ft_dry_qty + "</TD>");//추가				

				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_40ft_hc_qty + "</TD>");				
				
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_45ft_hc_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_53ft_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_rf_qty + "</TD>");
				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_rd_qty + "</TD>");//추가

				sbufXML.append("	<TD EDIT='" + isEditable + "' BGCOLOR='" + bgColor[color_num] + "' COLOR='" + fontColor + "'>" + fcast_ttl_wgt + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bgColor[color_num] + "'>" + (vvd.equals("TTL")?"":getNull(colValues.get("fcast_rmk"))) + "</TD>");
				
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_ttl_qty")) )    + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + bkg_20_qty + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + bkg_40_qty + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_20ft_dry_qty"))) + "</TD>");//추가
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_40ft_dry_qty"))) + "</TD>");//추가
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_40ft_hc_qty"))) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_45ft_hc_qty"))) + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_53ft_qty")))    + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_rf_qty")) )     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_rd_qty")) )     + "</TD>");//추가
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("bkg_ttl_wgt")))     + "</TD>");
			
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("cif")))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("fob")))     + "</TD>");
				sbufXML.append("	<TD BGCOLOR='" + bkgBGColor[color_num] + "'>" + nullToZero(getNull(colValues.get("oth")))     + "</TD>");
			}
			
			if(vsl_cd.equals("TTL")){
				vvd_cnt = 0;
				switch(treeLvl){
				case 1:
					rowLane = rowNum;
					break;
				case 2://salesRep total
					if(lvl1==4) {
						rowRep = rowNum;
					}
					
					break;
					
				case 3://salesRep, UsaMode
					if(lvl1==4) {
						lvl1 = 4;
					} else {					
						if(!(lvl1==4&&lvl2==1)){ // Ctrt Fcast
							if(acct_lvl.equals("A")) {
								rowGrpA = rowNum;
							} else if(acct_lvl.equals("B")) {
								rowGrpB = rowNum;
							} else if(acct_lvl.equals("Bm")){
								rowGrpBm = rowNum;								
							} else if(acct_lvl.equals("Bs")){
								rowGrpBs = rowNum;
							} else {
								rowGrpC = rowNum;
							}
						}	
						
					}
					break;
					
				case 4://salesRep, UsaMode, Account
					if(lvl1==2 && lvl2==2) {
						if(usa_bkg_mod_cd.equals("IPI")) {
							rowUsI = rowNum;	
						} else if(usa_bkg_mod_cd.equals("LOCAL")){
							rowUsL = rowNum;	
						} else {
							rowUsO = rowNum;	
						}
					} else if(lvl1==4 && lvl2==2){
						rowUs = rowNum;
					}
					break;
				case 5: //Salesrep, UsaMode, POL
					rowPol = rowNum;
					break;
				case 6://Salesrep, UsaMode, POL, POD
					break;
				}
				
				sbufXML.append("	<TD>" + treeLvl + "</TD>");
				sbufXML.append("	<TD></TD>");
				sbufXML.append("	<TD>" + rowLane + "</TD>");
				sbufXML.append("	<TD>" + (acct_lvl.equals("A")?rowGrpA:(acct_lvl.equals("B")?rowGrpB:(acct_lvl.equals("Bm")?rowGrpBm:(acct_lvl.equals("Bs")?rowGrpBs:rowGrpC)))) + "</TD>");
				sbufXML.append("	<TD>" + rowRep  + "</TD>");
				sbufXML.append("	<TD>" + (usa_bkg_mod_cd.equals("IPI")?rowUsI:(usa_bkg_mod_cd.equals("LOCAL")?rowUsL:rowUsO)) + "</TD>");
				sbufXML.append("	<TD>" + rowUs  + "</TD>");
				sbufXML.append("	<TD>" + rowPol  + "</TD>");
				sbufXML.append("	<TD>"  + getNull(colValues.get("sc_flg"))   +"</TD>");
				sbufXML.append("</TR>\n");
				
				rowNum = rowNum + 1;
			}
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
		if(str == null || str.equals(""))
			str = "0";
		return str;
	}
	
	protected String getETCData(EventResponse eventResponse) {
		if(eventResponse==null) 
			return "";
		
		List<Object> vos = eventResponse.getRsVoList();
		int realCnt = vos.size();
		
		String[] weeks      = new String[30];
		String[] vvds       = new String[30];
		String ctrl_opt[][] = new String[30][];
		String   newAcct    = "N";
		
		int week_cnt   = 0;
		int lvl1       = 0;
		int rnum       = 0;
		
		String srep               = "";
		String srep_nm            = "";
		String vsl_cd             = "";
		String salesRepCodeList   = "";
		String beforeSalesRepCode = "";
		String bkg_cust_seq       = "";
		String ofc_cd             = "";
		String sub_ofc_cd         = "";
		String hh_flg             = "";
		String bfr_hh_flg         = "N";
		String ctrl_flg           = "";
		String sls_rhq_cd         = "";
		String ctrl_lvl           = "";
		
		//fcast는 dest사용안함
		String ctrl_dest_lvl_cd      = "";//T:DEL, D:POD
		String aloc_ctrl_tp_cd       = "";//E:Ecc, L:Location
		String ctrl_usa_svc_mod_flg  = "";//
		
		boolean ctrl_d2 = false;
		boolean ctrl_d4 = false;
		boolean ctrl_hc = false;
		boolean ctrl_45 = false;
		boolean ctrl_53 = false;
		boolean ctrl_rf = false;
		boolean ctrl_rd = false;
		boolean ctrl_wt = false;
		
		boolean isEditable = false;
		SearchDailyForecastManageListVO vo = null;
		
		for(int i=0;i<realCnt;i++){
			vo = (SearchDailyForecastManageListVO)vos.get(i);
			Map<String, String> colValues = vo.getColumnValues();
			
			lvl1 = Integer.parseInt(nullToZero(getNull(colValues.get("lvl1"))));
			rnum = Integer.parseInt(nullToZero(getNull(colValues.get("rnum"))));
			
			srep   = getNull(colValues.get("srep_cd"));
			vsl_cd = getNull(colValues.get("vsl_cd"));
			
			bkg_cust_seq = getNull(colValues.get("bkg_cust_seq"));
			hh_flg = getNull(colValues.get("hh_flg"));
			
			ctrl_d2 = getNull(colValues.get("ctrl_d2_flg")).equals("Y");
			ctrl_d4 = getNull(colValues.get("ctrl_d4_flg")).equals("Y");
			ctrl_hc = getNull(colValues.get("ctrl_hc")).equals("Y");
			ctrl_45 = getNull(colValues.get("ctrl_45")).equals("Y");
			ctrl_53 = getNull(colValues.get("ctrl_53")).equals("Y");
			ctrl_rf = getNull(colValues.get("ctrl_rf")).equals("Y");
			ctrl_rd = getNull(colValues.get("ctrl_rd_flg")).equals("Y");
			ctrl_wt = getNull(colValues.get("ctrl_wt")).equals("Y");
			
			String vvd = vsl_cd + getNull(colValues.get("skd_voy_no")) + getNull(colValues.get("skd_dir_cd"));
			vvd = vvd.trim();
			
			weeks[rnum-1] = getNull(colValues.get("cost_yr")) + getNull(colValues.get("cost_wk"));
			vvds[rnum-1]  = vvd;
			
			week_cnt = week_cnt < rnum ? rnum : week_cnt;
			
			if(ctrl_opt[rnum-1] == null) {
				// hc, 45, 53, rf, wt -->d2, d4, hc, 45, 53, rf, rd, wt, 
				ctrl_opt[rnum-1] = new String[] {"false", "false", "false", "false", "false", "false", "false", "false"};
			}
			
			//ctrl lvl: O, P, D --> O, P, D, T(control lvl 추가에 따라 코드를 그대로 보내준다.
			if(getNull(colValues.get("ctrl_lvl")).equals("D")||getNull(colValues.get("ctrl_lvl")).equals("T")) ctrl_lvl = "Y";
			//하나라도 Y이면 Y, 이전것이 Y이면 Y로 아니면 새VVD값으로
			ctrl_usa_svc_mod_flg = ("Y".equals(ctrl_usa_svc_mod_flg)?"Y":getNull(colValues.get("ctrl_usa_svc_mod_flg")));//추가
			
			if(getNull(colValues.get("new_flg")).equals("Y"))
				newAcct = "Y";
			if(getNull(colValues.get("ctrl_acct")).equals("Y"))
				ctrl_flg = "Y";
			if(!getNull(colValues.get("sls_rhq_cd")).equals(""))
				sls_rhq_cd = getNull(colValues.get("sls_rhq_cd"));
			
			if(lvl1 == 0){
				for(int t = 0 ; t < vvds.length ; t++){
					vvds[t] = "";
				}
			} else {
				isEditable = "TRUE".equals(colValues.get("iseditable"))?true:false;
				
				if(bkg_cust_seq != null && bkg_cust_seq.length() > 0){
					isEditable = false;
					ctrl_d2    = false;
					ctrl_d4    = false;
					ctrl_hc    = false;
					ctrl_45    = false;
					ctrl_53    = false;
					ctrl_rf    = false;
					ctrl_rd    = false;
					ctrl_wt    = false;
				}
				
				if(!beforeSalesRepCode.equals(srep) && isEditable) {
					beforeSalesRepCode = srep;
					salesRepCodeList   = salesRepCodeList + "|" + srep;
					
					srep_nm            = colValues.get("srep_nm");
					ofc_cd             = colValues.get("ofc_cd");
					sub_ofc_cd         = colValues.get("sub_ofc_cd");
				}
				
				if(ctrl_opt[rnum-1][0].equals("false") && ctrl_d2) ctrl_opt[rnum-1][0] = "true";
				if(ctrl_opt[rnum-1][1].equals("false") && ctrl_d4) ctrl_opt[rnum-1][1] = "true";
				if(ctrl_opt[rnum-1][2].equals("false") && ctrl_hc) ctrl_opt[rnum-1][2] = "true";
				if(ctrl_opt[rnum-1][3].equals("false") && ctrl_45) ctrl_opt[rnum-1][3] = "true";
				if(ctrl_opt[rnum-1][4].equals("false") && ctrl_53) ctrl_opt[rnum-1][4] = "true";
				if(ctrl_opt[rnum-1][5].equals("false") && ctrl_rf) ctrl_opt[rnum-1][5] = "true";
				if(ctrl_opt[rnum-1][6].equals("false") && ctrl_rd) ctrl_opt[rnum-1][6] = "true";
				if(ctrl_opt[rnum-1][7].equals("false") && ctrl_wt) ctrl_opt[rnum-1][7] = "true";
				
				if ( hh_flg.equals("Y") ) {
					bfr_hh_flg = hh_flg;
				}
				
			}
		}
		
		String yrwk    = "";
		String strVVD  = "";
		String ctrlopt = "";
		
		//2014.06.30 김용습 R4J 패치 사전 작업
      	StringBuffer out1 = new StringBuffer();
    	StringBuffer out2 = new StringBuffer();
    	StringBuffer out3 = new StringBuffer();
		
		for(int i = 0 ; i < week_cnt ; i++){
			//2014.06.30 김용습 R4J 패치 사전 작업
			//yrwk   = yrwk + "|" + weeks[i];
			//strVVD = strVVD + "|" + vvds[i];
			out1.append("|").append(weeks[i]);
			out2.append("|").append(vvds[i]);
			
			for(int j = 0 ; j < 8; j++){
				//2014.06.30 김용습 R4J 패치 사전 작업
				//ctrlopt = ctrlopt + "|" + ctrl_opt[i][j];
				out3.append("|").append(ctrl_opt[i][j]);
			}
		}
		ctrlopt = out3.toString();
		yrwk = out1.toString();
		strVVD = out2.toString();
		
		if(newAcct.equals("Y") && salesRepCodeList.split("|").length == 7)
			newAcct = newAcct + "|" + srep_nm + "|" + ofc_cd + "|" + sub_ofc_cd;
		
		StringBuilder sb = new StringBuilder();
		
		try{
			
			sb.append("<ETC-DATA>\n");
			sb.append("    <ETC KEY='status'>OK</ETC>\n");
			sb.append("    <ETC KEY='week'>" + yrwk + "</ETC>\n");
			sb.append("    <ETC KEY='vvd'>" + strVVD + "</ETC>\n");
			sb.append("    <ETC KEY='salesRepCodeList'>" + salesRepCodeList + "</ETC>\n");
			sb.append("    <ETC KEY='ctrlLvl'>" + ctrl_lvl + "</ETC>\n");
			sb.append("    <ETC KEY='ctrlopt'>" + ctrlopt + "</ETC>\n");
			sb.append("    <ETC KEY='newAcct'>" + newAcct + "</ETC>\n");
			sb.append("    <ETC KEY='hhFlg'>" + bfr_hh_flg + "</ETC>\n");
			sb.append("    <ETC KEY='ctrlAcct'>" + ctrl_flg + "</ETC>\n");
			sb.append("    <ETC KEY='slsRhqCd'>" + sls_rhq_cd + "</ETC>\n");
			sb.append("    <ETC KEY='destLvl'>" + ctrl_dest_lvl_cd + "</ETC>\n");
			sb.append("    <ETC KEY='destLocTp'>" + aloc_ctrl_tp_cd + "</ETC>\n");
			sb.append("    <ETC KEY='usModFlg'>" + ctrl_usa_svc_mod_flg + "</ETC>\n");
			sb.append("</ETC-DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	} 

}
