/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : USADeliveryOrderManageDBDAOMultiUSADeliveryOrderDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USADeliveryOrderManageDBDAOMultiUSADeliveryOrderDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiUSADeliveryOrderDtl
	  * </pre>
	  */
	public USADeliveryOrderManageDBDAOMultiUSADeliveryOrderDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.integration").append("\n"); 
		query.append("FileName : USADeliveryOrderManageDBDAOMultiUSADeliveryOrderDtlUSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_TRSP_USA_DO_DTL TARGET                                     " ).append("\n"); 
		query.append("USING DUAL SELT                                                      " ).append("\n"); 
		query.append("      ON( TARGET.BL_NO = @[bl_no]                                 " ).append("\n"); 
		query.append("            	AND TARGET.EQ_NO = @[eq_no]                                              " ).append("\n"); 
		query.append("        )                                                                  " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                                       " ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("        	DO_RMK          = @[do_rmk]                                              " ).append("\n"); 
		query.append("        	, UPD_USR_ID    = @[cre_usr_id]                                    " ).append("\n"); 
		query.append("        	, UPD_DT        = SYSDATE " ).append("\n"); 
		query.append("        	, LOCL_UPD_DT   = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd]) " ).append("\n"); 
		query.append("    WHERE BL_NO = @[bl_no]                                  " ).append("\n"); 
		query.append("       AND EQ_NO = @[eq_no]                                                   " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN                                                   " ).append("\n"); 
		query.append("      INSERT " ).append("\n"); 
		query.append("      ( " ).append("\n"); 
		query.append("            BL_NO                                                       " ).append("\n"); 
		query.append("            , EQ_NO                                                       " ).append("\n"); 
		query.append("            , DO_RMK                                                      " ).append("\n"); 
		query.append("            , CRE_OFC_CD                                                  " ).append("\n"); 
		query.append("            , CRE_USR_ID                                                  " ).append("\n"); 
		query.append("            , CRE_DT                                                      " ).append("\n"); 
		query.append("            , UPD_USR_ID                                                  " ).append("\n"); 
		query.append("            , UPD_DT                                                      " ).append("\n"); 
		query.append("            , LOCL_CRE_DT                                                      " ).append("\n"); 
		query.append("            , LOCL_UPD_DT                                                      " ).append("\n"); 
		query.append("      )                                                                    " ).append("\n"); 
		query.append("       VALUES (                                                            " ).append("\n"); 
		query.append("            @[bl_no]                                              " ).append("\n"); 
		query.append("            , @[eq_no]                                                           " ).append("\n"); 
		query.append("            , @[do_rmk]                                                           " ).append("\n"); 
		query.append("            , @[usr_ofc_cd]                                                           " ).append("\n"); 
		query.append("            , @[cre_usr_id]         " ).append("\n"); 
		query.append("            , SYSDATE                                                " ).append("\n"); 
		query.append("            , @[cre_usr_id]         " ).append("\n"); 
		query.append("            , SYSDATE                                                " ).append("\n"); 
		query.append("            , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])                        " ).append("\n"); 
		query.append("            , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[usr_ofc_cd])                        " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}