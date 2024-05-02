/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA RAIL BILLING Vendor 및 Invoice 금액을 수정
	  * </pre>
	  */
	public RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railRoadCode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("SET INV_NO = @[invNo]," ).append("\n"); 
		query.append("    INV_VNDR_SEQ = @[invVndrSeq]," ).append("\n"); 
		query.append("    INV_CURR_CD	= (" ).append("\n"); 
		query.append("    				SELECT D.INV_CURR_CD" ).append("\n"); 
		query.append("    				FROM" ).append("\n"); 
		query.append("    					TRS_TRSP_RAIL_INV_DTL D" ).append("\n"); 
		query.append("    				,	TRS_TRSP_RAIL_INV_WRK W" ).append("\n"); 
		query.append("    				WHERE D.INV_NO= W.INV_NO" ).append("\n"); 
		query.append("    				AND   D.INV_VNDR_SEQ = W.INV_VNDR_SEQ" ).append("\n"); 
		query.append("    				AND   D.TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    				AND   D.TRSP_SO_SEQ = A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    				AND   W.WO_VNDR_SEQ = A.PAIR_VNDR_SEQ" ).append("\n"); 
		query.append("    				GROUP BY D.INV_CURR_CD" ).append("\n"); 
		query.append("			     )," ).append("\n"); 
		query.append("    INV_BZC_AMT = CASE (SELECT RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("				        FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("        				WHERE TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        				AND   TRSP_SO_SEQ = A.TRSP_SO_SEQ )" ).append("\n"); 
		query.append("			         WHEN 'C2T' THEN" ).append("\n"); 
		query.append("				        CASE A.SUB_RAIL_SEQ WHEN 1 THEN @[inv_bzc_amt] ELSE '0' END" ).append("\n"); 
		query.append("			         WHEN 'C3T' THEN" ).append("\n"); 
		query.append("				        CASE A.SUB_RAIL_SEQ WHEN 1 THEN @[inv_bzc_amt] ELSE '0' END" ).append("\n"); 
		query.append("			         WHEN 'C2C' THEN" ).append("\n"); 
		query.append("				        CASE A.SUB_RAIL_SEQ WHEN 2 THEN @[inv_bzc_amt] ELSE '0' END" ).append("\n"); 
		query.append("			         WHEN 'C3S' THEN" ).append("\n"); 
		query.append("				        CASE A.SUB_RAIL_SEQ WHEN 2 THEN @[inv_bzc_amt]" ).append("\n"); 
		query.append("					 WHEN 3 THEN @[inv_bzc_amt] ELSE '0' END" ).append("\n"); 
		query.append("			      ELSE @[inv_bzc_amt]" ).append("\n"); 
		query.append("			      END," ).append("\n"); 
		query.append("    INV_ETC_ADD_AMT = CASE (SELECT RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("				            FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("            				WHERE TRSP_SO_OFC_CTY_CD = A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("            				AND   TRSP_SO_SEQ = A.TRSP_SO_SEQ )" ).append("\n"); 
		query.append("			             WHEN 'C2T' THEN" ).append("\n"); 
		query.append("				            CASE A.SUB_RAIL_SEQ WHEN 1 THEN @[inv_etc_add_amt] ELSE '0' END" ).append("\n"); 
		query.append("			             WHEN 'C3T' THEN" ).append("\n"); 
		query.append("				            CASE A.SUB_RAIL_SEQ WHEN 1 THEN @[inv_etc_add_amt] ELSE '0' END" ).append("\n"); 
		query.append("			             WHEN 'C2C' THEN" ).append("\n"); 
		query.append("				            CASE A.SUB_RAIL_SEQ WHEN 2 THEN @[inv_etc_add_amt] ELSE '0' END" ).append("\n"); 
		query.append("			             WHEN 'C3S' THEN" ).append("\n"); 
		query.append("				            CASE A.SUB_RAIL_SEQ WHEN 2 THEN @[inv_etc_add_amt]" ).append("\n"); 
		query.append("						 WHEN 3 THEN @[inv_etc_add_amt] ELSE '0' END" ).append("\n"); 
		query.append("			          ELSE @[inv_etc_add_amt] " ).append("\n"); 
		query.append("			          END," ).append("\n"); 
		query.append("    UPD_USR_ID				= @[sUsrId]," ).append("\n"); 
		query.append("    LOCL_UPD_DT				= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)," ).append("\n"); 
		query.append("    UPD_DT                  = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD)" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD	= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   TRSP_SO_SEQ		= @[trsp_so_seq]" ).append("\n"); 
		query.append("AND   PAIR_VNDR_SEQ		= @[railRoadCode]" ).append("\n"); 

	}
}