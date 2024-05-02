/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VendorCmDBDAOModifyTrsTrspScgDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VendorCmDBDAOModifyTrsTrspScgDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VendorCmDBDAOModifyTrsTrspScgDtl
	  * </pre>
	  */
	public VendorCmDBDAOModifyTrsTrspScgDtlUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration").append("\n"); 
		query.append("FileName : VendorCmDBDAOModifyTrsTrspScgDtlUSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_TRSP_SCG_DTL T1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT    M2.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                 ,M2.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                 ,M2.RCV_MSG_SEQ" ).append("\n"); 
		query.append("                 ,M2.LGS_COST_CD" ).append("\n"); 
		query.append("                 ,M2.CURR_CD" ).append("\n"); 
		query.append("                 ,M2.RCV_AMT" ).append("\n"); 
		query.append("                 ,M2.FUEL_RTO" ).append("\n"); 
		query.append("                 ,M1.CRE_OFC_CD" ).append("\n"); 
		query.append("                 ,M1.CURR_CD SO_CURRENCY" ).append("\n"); 
		query.append("             FROM TRS_TRSP_SVC_ORD    M1" ).append("\n"); 
		query.append("                 ,TRS_EDI_USA_RCV_MSG M2" ).append("\n"); 
		query.append("            WHERE M1.TRSP_SO_OFC_CTY_CD = M2.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("              AND M1.TRSP_SO_SEQ = M2.TRSP_SO_SEQ" ).append("\n"); 
		query.append("              AND M2.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] " ).append("\n"); 
		query.append("              AND M2.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("              AND M2.RCV_MSG_SEQ = @[rcv_msg_seq]" ).append("\n"); 
		query.append("              AND M2.LGS_COST_CD <> 'TRCOST'" ).append("\n"); 
		query.append("			  AND M2.RCV_MSG = 'Charges'" ).append("\n"); 
		query.append("       ) T2" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("       T1.TRSP_SO_OFC_CTY_CD = T2.TRSP_SO_OFC_CTY_CD " ).append("\n"); 
		query.append("   AND T1.TRSP_SO_SEQ = T2.TRSP_SO_SEQ " ).append("\n"); 
		query.append("   AND T1.LGS_COST_CD = T2.LGS_COST_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("     SET T1.SCG_AMT     = DECODE(T1.SCG_DTL_SEQ, 1, T2.RCV_AMT, 0)" ).append("\n"); 
		query.append("		,T1.FUEL_RTO    = DECODE(T1.SCG_DTL_SEQ, 1, T2.FUEL_RTO, NULL)" ).append("\n"); 
		query.append("        ,T1.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(T1.CRE_OFC_CD)" ).append("\n"); 
		query.append("        ,T1.UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,T1.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" INSERT (" ).append("\n"); 
		query.append("            TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          , TRSP_SO_SEQ" ).append("\n"); 
		query.append("          , LGS_COST_CD" ).append("\n"); 
		query.append("		  , SCG_DTL_SEQ" ).append("\n"); 
		query.append("          , SCG_AMT" ).append("\n"); 
		query.append("		  , FUEL_RTO" ).append("\n"); 
		query.append("          , CRE_OFC_CD" ).append("\n"); 
		query.append("          , LOCL_CRE_DT" ).append("\n"); 
		query.append("          , LOCL_UPD_DT" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT" ).append("\n"); 
		query.append("      ) VALUES (" ).append("\n"); 
		query.append("           T2.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          ,T2.TRSP_SO_SEQ" ).append("\n"); 
		query.append("          ,T2.LGS_COST_CD" ).append("\n"); 
		query.append("	      ,1" ).append("\n"); 
		query.append("          ,T2.RCV_AMT" ).append("\n"); 
		query.append("		  ,T2.FUEL_RTO" ).append("\n"); 
		query.append("          ,T2.CRE_OFC_CD" ).append("\n"); 
		query.append("          ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(T2.CRE_OFC_CD)" ).append("\n"); 
		query.append("          ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(T2.CRE_OFC_CD)" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[upd_usr_id]" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}