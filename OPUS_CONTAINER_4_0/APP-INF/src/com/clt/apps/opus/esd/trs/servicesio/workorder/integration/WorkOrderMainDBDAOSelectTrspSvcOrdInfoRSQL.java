/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderMainDBDAOSelectTrspSvcOrdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOSelectTrspSvcOrdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOSelectTrspSvcOrdInfo
	  * </pre>
	  */
	public WorkOrderMainDBDAOSelectTrspSvcOrdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOSelectTrspSvcOrdInfoRSQL").append("\n"); 
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
		query.append("SELECT O.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,O.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,O.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,O.TRSP_WO_SEQ" ).append("\n"); 
		query.append("  	  ,CASE WHEN O.TRSP_SO_TP_CD = 'M'  THEN O.REF_ID" ).append("\n"); 
		query.append("		    WHEN O.TRSP_BND_CD = 'O' THEN O.BKG_NO" ).append("\n"); 
		query.append("	   END BKG_NO" ).append("\n"); 
		query.append("      ,DECODE(O.TRSP_BND_CD, 'I', O.BL_NO) BL_NO" ).append("\n"); 
		query.append("      ,TRIM(O.CNTC_PSON_NM) CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,TRIM(O.CNTC_PSON_PHN_NO) CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("      ,TRIM(O.EQ_NO) EQ_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(NVL(RCL.MNL_SET_DT, RCL.SYS_SET_DT), 'YYYYMMDDHH24MISS') CUT_OFF_DT" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD O" ).append("\n"); 
		query.append("      ,BKG_CLZ_TM       RCL" ).append("\n"); 
		query.append(" WHERE O.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND O.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND O.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND O.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 
		query.append("   AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND O.BKG_NO = RCL.BKG_NO(+)" ).append("\n"); 
		query.append("   AND RCL.CLZ_TP_CD(+) = 'R'" ).append("\n"); 

	}
}