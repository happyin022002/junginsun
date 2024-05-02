/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerSupplyDemandPlanDBDAOEqPriceDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.20 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSupplyDemandPlanDBDAOEqPriceDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Purchasing Trend by Year & input & update
	  * </pre>
	  */
	public ContainerSupplyDemandPlanDBDAOEqPriceDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.integration").append("\n"); 
		query.append("FileName : ContainerSupplyDemandPlanDBDAOEqPriceDetailVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   A.BSE_YRMON," ).append("\n"); 
		query.append("   A.EQ_KND_CD," ).append("\n"); 
		query.append("   A.VNDR_SEQ," ).append("\n"); 
		query.append("   A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("   A.LOC_CD," ).append("\n"); 
		query.append("   A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("   A.EQ_QTY," ).append("\n"); 
		query.append("   A.PUR_PRC," ).append("\n"); 
		query.append("   A.PUR_UT_PRC," ).append("\n"); 
		query.append("   A.DRYG_AMT," ).append("\n"); 
		query.append("   A.CRE_USR_ID," ).append("\n"); 
		query.append("   A.CRE_DT," ).append("\n"); 
		query.append("   A.UPD_USR_ID," ).append("\n"); 
		query.append("   A.UPD_DT," ).append("\n"); 
		query.append("   A.CURR_CD," ).append("\n"); 
		query.append("   A.STL1," ).append("\n"); 
		query.append("   A.STL2," ).append("\n"); 
		query.append("   A.STL3," ).append("\n"); 
		query.append("   A.INSFLG," ).append("\n"); 
		query.append("   A.UPDFLG," ).append("\n"); 
		query.append("   A.DELFLG," ).append("\n"); 
		query.append("   A.DIFF_RMK" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(   " ).append("\n"); 
		query.append("SELECT /*+ Index (A XPKMST_EQ_PUR_PRC) */" ).append("\n"); 
		query.append("   A.BSE_YRMON BSE_YRMON," ).append("\n"); 
		query.append("   A.EQ_KND_CD," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(A.VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("   --B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("   MST_COMMON_PKG.MST_VNDR_SEQ_CONV_FNC(A.VNDR_SEQ) VNDR_ABBR_NM," ).append("\n"); 
		query.append("   NVL(B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM) VNDR_NM," ).append("\n"); 
		query.append("   A.LOC_CD," ).append("\n"); 
		query.append("   A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("   A.EQ_QTY," ).append("\n"); 
		query.append("   A.PUR_PRC," ).append("\n"); 
		query.append("   A.PUR_UT_PRC," ).append("\n"); 
		query.append("   A.DRYG_AMT," ).append("\n"); 
		query.append("   A.CRE_USR_ID," ).append("\n"); 
		query.append("   A.CRE_DT," ).append("\n"); 
		query.append("   A.UPD_USR_ID," ).append("\n"); 
		query.append("   A.UPD_DT," ).append("\n"); 
		query.append("   A.CURR_CD," ).append("\n"); 
		query.append("   '' STL1," ).append("\n"); 
		query.append("   '' STL2," ).append("\n"); 
		query.append("   '' STL3," ).append("\n"); 
		query.append("   '' INSFLG," ).append("\n"); 
		query.append("   '' UPDFLG," ).append("\n"); 
		query.append("   '' DELFLG," ).append("\n"); 
		query.append("   A.DIFF_RMK" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   MST_EQ_PUR_PRC A," ).append("\n"); 
		query.append("   MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE 1 = 1 " ).append("\n"); 
		query.append("AND   A.BSE_YRMON   =   @[bse_yrmon]" ).append("\n"); 
		query.append("AND   A.EQ_KND_CD   =   @[eq_knd_cd]" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ    =   B.VNDR_SEQ(+)" ).append("\n"); 
		query.append(") A, MDM_CNTR_TP_SZ B" ).append("\n"); 
		query.append("WHERE    A.EQ_TPSZ_CD  =   B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.VNDR_NM, A.LOC_CD, B.RPT_DP_SEQ" ).append("\n"); 

	}
}