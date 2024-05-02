/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2016.07.12 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 상태 정보 CHECK
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckFullContainerStatusFirstCntrRSQL").append("\n"); 
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
		query.append("    MST.CNTR_NO CONTAINER_NO," ).append("\n"); 
		query.append("    DECODE(MST.CNTR_TPSZ_CD, 'D4', 'D45', 'D5', 'D45', MST.CNTR_TPSZ_CD) CONTAINER_TP_SZ," ).append("\n"); 
		query.append("    DECODE(MST.LSTM_CD, 'SH', 'Y', 'OF', 'Y', 'N') IS_SOC," ).append("\n"); 
		query.append("    DECODE(NVL(MST.ACIAC_DIV_CD , 'N'), 'A', 'Y', 'I', 'N') IS_ACTIVE," ).append("\n"); 
		query.append("    DECODE(MST.SYS_AREA_GRP_ID, 'USA', 'Y', 'DUS', 'Y', 'N') IS_US_REGION," ).append("\n"); 
		query.append("    NVL(MST.DMG_FLG, 'N') IS_DAMAGED," ).append("\n"); 
		query.append("    NVL(MST.DISP_FLG, 'N') IS_DISPOSAL," ).append("\n"); 
		query.append("    DECODE(MST.LSTM_CD, 'OF', 'Y', 'N') IS_LEASE_EXPIRED," ).append("\n"); 
		query.append("    COP.COP_NO COP_NO," ).append("\n"); 
		query.append("    COP.COST_ACT_GRP_SEQ COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("	COP.PCTL_NO PCTL_NO," ).append("\n"); 
		query.append("    DECODE(MSTSPEC.TARE_WGT, NULL, (" ).append("\n"); 
		query.append("        SELECT TO_CHAR(ROUND((CNTR_TPSZ_TARE_WGT) * 2.2046, 0))" ).append("\n"); 
		query.append("        FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("        WHERE CNTR_TPSZ_CD = MST.CNTR_TPSZ_CD ), " ).append("\n"); 
		query.append("        TO_CHAR(ROUND((MSTSPEC.TARE_WGT) * 2.2046, 0))) TARE_WGT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    MST_CONTAINER MST," ).append("\n"); 
		query.append("    MST_CNTR_SPEC MSTSPEC," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            H.COP_NO," ).append("\n"); 
		query.append("            H.CNTR_NO," ).append("\n"); 
		query.append("            G.COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("			H.PCTL_NO" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            SCE_COP_HDR H," ).append("\n"); 
		query.append("            SCE_PLN_SO_LIST G" ).append("\n"); 
		query.append("        WHERE H.COP_NO = G.COP_NO" ).append("\n"); 
		query.append("        AND   H.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("        AND   DECODE (H.MST_COP_NO, H.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("        AND   G.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("        AND   G.TRSP_MOD_CD = 'RD'" ).append("\n"); 
		query.append("        AND   SUBSTR(G.COST_ACT_GRP_CD , 1,1) = 'O'" ).append("\n"); 
		query.append("        AND   H.BKG_NO = @[bkgNo]" ).append("\n"); 
		query.append("        AND   H.CNTR_NO = @[eqNo]" ).append("\n"); 
		query.append("    ) COP" ).append("\n"); 
		query.append("WHERE MST.CNTR_NO = COP.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   MST.CNTR_SPEC_NO = MSTSPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND   MST.CNTR_NO = @[eqNo]" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("    MST.CNTR_NO ASC" ).append("\n"); 

	}
}