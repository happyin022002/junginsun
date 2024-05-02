/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetSecondListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.03.19 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderSheetDBDAOsearchWorkOrderSheetSecondListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Work Order Sheet Second List
	  * </pre>
	  */
	public WorkOrderSheetDBDAOsearchWorkOrderSheetSecondListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetSecondListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT  b.EQ_NO 							AS equipment_number," ).append("\n"); 
		query.append("        T.CNTR_TPSZ_RMK  					AS eq_tpsz_nm," ).append("\n"); 
		query.append("        T.CNTR_TPSZ_CD                      AS eq_tpsz_cd," ).append("\n"); 
		query.append("        COUNT(1) 							AS quantity," ).append("\n"); 
		query.append("        B.CURR_CD ||' '|| SUM(TO_CHAR(NVL(B.BZC_AMT,0)+" ).append("\n"); 
		query.append("        NVL(B.ETC_ADD_AMT,0)+NVL(B.FUEL_SCG_AMT,0)+" ).append("\n"); 
		query.append("        NVL(B.NEGO_AMT,0)+NVL(B.TOLL_FEE_AMT,0)))    			AS rate," ).append("\n"); 
		query.append("        B.SPCL_INSTR_RMK 					AS remark" ).append("\n"); 
		query.append("        ,max((select a.wo_fmt_tp_cd" ).append("\n"); 
		query.append("			from trs_trsp_wrk_ord a" ).append("\n"); 
		query.append("			where 1=1" ).append("\n"); 
		query.append("			and a.trsp_wo_ofc_cty_cd = wrk.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("			and a.trsp_wo_seq = wrk.trsp_wo_seq" ).append("\n"); 
		query.append("			and a.wo_fmt_tp_cd is not null)) wo_fmt_tp_cd" ).append("\n"); 
		query.append("FROM  TRS_TRSP_WRK_ORD WRK," ).append("\n"); 
		query.append("      TRS_TRSP_SVC_ORD B," ).append("\n"); 
		query.append("      MDM_CNTR_TP_SZ T" ).append("\n"); 
		query.append("WHERE WRK.TRSP_WO_OFC_CTY_CD                   = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND WRK.TRSP_WO_SEQ                          = B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("  AND (WRK.TRSP_WO_OFC_CTY_CD,WRK.TRSP_WO_SEQ) in ((@[trsp_wo_ofc_cty_cd],@[trsp_wo_seq]))" ).append("\n"); 
		query.append("#if (${wo_vndr_seq} != '')" ).append("\n"); 
		query.append("  AND WRK.wo_vndr_seq  =  @[wo_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND   B.EQ_TPSZ_CD                = T.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("GROUP BY b.EQ_NO,T.CNTR_TPSZ_RMK,T.CNTR_TPSZ_CD,B.SPCL_INSTR_RMK,b.curr_cd" ).append("\n"); 

	}
}