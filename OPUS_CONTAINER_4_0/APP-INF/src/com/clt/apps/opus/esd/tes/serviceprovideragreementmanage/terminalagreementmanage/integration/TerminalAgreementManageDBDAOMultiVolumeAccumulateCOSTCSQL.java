/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOMultiVolumeAccumulateCOSTCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOMultiVolumeAccumulateCOSTCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TES_TML_SO_ACCM_COST  Insert or Update
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOMultiVolumeAccumulateCOSTCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("accm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOMultiVolumeAccumulateCOSTCSQL").append("\n"); 
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
		query.append("MERGE INTO TES_TML_SO_ACCM_COST T " ).append("\n"); 
		query.append("USING DUAL " ).append("\n"); 
		query.append("ON ( T.ACCM_SEQ = @[accm_seq] " ).append("\n"); 
		query.append("	AND T.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("    AND T.LGS_COST_CD = @[lgs_cost_cd] )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("           SET UPD_USR_ID = @[upd_usr_id] " ).append("\n"); 
		query.append("         , UPD_DT = SYSDATE " ).append("\n"); 
		query.append("         , LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])  " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("               VNDR_SEQ " ).append("\n"); 
		query.append("             , ACCM_SEQ " ).append("\n"); 
		query.append("             , ACCM_COST_SEQ " ).append("\n"); 
		query.append("             , LGS_COST_CD " ).append("\n"); 
		query.append("             , CRE_USR_ID " ).append("\n"); 
		query.append("             , CRE_DT " ).append("\n"); 
		query.append("             , UPD_USR_ID " ).append("\n"); 
		query.append("             , UPD_DT " ).append("\n"); 
		query.append("             , LOCL_CRE_DT " ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("           VALUES " ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("               @[vndr_seq] " ).append("\n"); 
		query.append("             , @[accm_seq] " ).append("\n"); 
		query.append("             , (SELECT NVL(MAX(ACCM_COST_SEQ), 0) + 1 " ).append("\n"); 
		query.append("                 FROM TES_TML_SO_ACCM_COST " ).append("\n"); 
		query.append("                WHERE 1 = 1 " ).append("\n"); 
		query.append("                  AND VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("                  AND ACCM_SEQ = @[accm_seq]" ).append("\n"); 
		query.append("               ) " ).append("\n"); 
		query.append("             , @[lgs_cost_cd] " ).append("\n"); 
		query.append("             , @[cre_usr_id] " ).append("\n"); 
		query.append("             , SYSDATE " ).append("\n"); 
		query.append("             , @[upd_usr_id] " ).append("\n"); 
		query.append("             , SYSDATE " ).append("\n"); 
		query.append("             , GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])  " ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}