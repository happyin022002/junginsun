/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchVnorItmSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchVnorItmSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vnor Itm Seq 조회
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchVnorItmSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_offh_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchVnorItmSeqRSQL").append("\n"); 
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
		query.append("    CASE WHEN ( " ).append("\n"); 
		query.append("                SELECT  " ).append("\n"); 
		query.append("                    COUNT(F.VNOR_SEQ) " ).append("\n"); 
		query.append("                FROM FMS_VNOR F, FMS_VNOR_ITM I " ).append("\n"); 
		query.append("                WHERE 1=1 " ).append("\n"); 
		query.append("                AND F.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("                AND F.VNOR_OFFH_FM_DT = TO_DATE(@[vnor_offh_fm_dt],'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                AND F.VNOR_OFFH_TO_DT = TO_DATE(@[vnor_offh_to_dt],'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                AND F.VSL_CD = I.VSL_CD " ).append("\n"); 
		query.append("                AND F.VNOR_SEQ = I.VNOR_SEQ " ).append("\n"); 
		query.append("                AND I.VNOR_ITM_FLET_ADD_CD = 'O'     " ).append("\n"); 
		query.append("    			AND F.CR_CHK_FLG = @[cr_chk_flg] " ).append("\n"); 
		query.append("                ) > 0 THEN (  " ).append("\n"); 
		query.append("                            SELECT MAX(VNOR_ITM_SEQ)+1 FROM FMS_VNOR_ITM I " ).append("\n"); 
		query.append("                            WHERE 1=1 " ).append("\n"); 
		query.append("                            AND I.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("                            AND I.VNOR_SEQ = ( " ).append("\n"); 
		query.append("                                                SELECT  " ).append("\n"); 
		query.append("                                                    MAX(F.VNOR_SEQ)  " ).append("\n"); 
		query.append("                                                FROM FMS_VNOR F, FMS_VNOR_ITM I " ).append("\n"); 
		query.append("                                                WHERE 1=1 " ).append("\n"); 
		query.append("                                                AND F.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("                                                AND F.VNOR_OFFH_FM_DT = TO_DATE(@[vnor_offh_fm_dt],'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                                AND F.VNOR_OFFH_TO_DT = TO_DATE(@[vnor_offh_to_dt],'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("                                                AND F.VSL_CD = I.VSL_CD " ).append("\n"); 
		query.append("                                                AND F.VNOR_SEQ = I.VNOR_SEQ " ).append("\n"); 
		query.append("                                                AND I.VNOR_ITM_FLET_ADD_CD = 'O'       " ).append("\n"); 
		query.append("            									AND F.CR_CHK_FLG = @[cr_chk_flg]                                             " ).append("\n"); 
		query.append("                                              )                 " ).append("\n"); 
		query.append("                            )  " ).append("\n"); 
		query.append("          ELSE 1 " ).append("\n"); 
		query.append("          END VNOR_SEQ " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}