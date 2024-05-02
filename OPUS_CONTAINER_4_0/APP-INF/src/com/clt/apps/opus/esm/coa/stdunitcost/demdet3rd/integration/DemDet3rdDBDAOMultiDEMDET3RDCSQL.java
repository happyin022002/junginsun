/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DemDet3rdDBDAOMultiDEMDET3RDCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDet3rdDBDAOMultiDEMDET3RDCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * @@ PCM.20141222.MOD : INSERT -> MERGE : DUP ERROR
	  * </pre>
	  */
	public DemDet3rdDBDAOMultiDEMDET3RDCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dmdt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_ass_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.integration").append("\n"); 
		query.append("FileName : DemDet3rdDBDAOMultiDEMDET3RDCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_DMDT_N3RD_PTY A" ).append("\n"); 
		query.append("USING (SELECT REPLACE(@[cost_yrmon],'-','') COST_YRMON" ).append("\n"); 
		query.append("             , @[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        	 , @[stnd_cost_cd] STND_COST_CD" ).append("\n"); 
		query.append("        	 , TO_NUMBER(@[uc_amt]) UC_AMT" ).append("\n"); 
		query.append("        	 , TO_NUMBER(@[bkg_vol_qty]) BKG_VOL_QTY" ).append("\n"); 
		query.append("        	 , TO_NUMBER(@[ttl_dmdt_amt]) TTL_DMDT_AMT" ).append("\n"); 
		query.append("        	 , @[cost_ass_bse_cd] COST_ASS_BSE_CD" ).append("\n"); 
		query.append("        	 , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("        	 , SYSDATE CRE_DT" ).append("\n"); 
		query.append("        	 , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("        	 , SYSDATE UPD_DT" ).append("\n"); 
		query.append("		FROM DUAL" ).append("\n"); 
		query.append("        	 ) B" ).append("\n"); 
		query.append("ON (    A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND A.STND_COST_CD = B.STND_COST_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("      SET A.UC_AMT = B.UC_AMT" ).append("\n"); 
		query.append("        , A.BKG_VOL_QTY = B.BKG_VOL_QTY" ).append("\n"); 
		query.append("        , A.TTL_DMDT_AMT = B.TTL_DMDT_AMT" ).append("\n"); 
		query.append("        , A.COST_ASS_BSE_CD = B.COST_ASS_BSE_CD" ).append("\n"); 
		query.append("        , A.UPD_USR_ID = B.UPD_USR_ID" ).append("\n"); 
		query.append("        , A.UPD_DT = B.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT(A.COST_YRMON, A.CNTR_TPSZ_CD, A.STND_COST_CD, A.UC_AMT, A.BKG_VOL_QTY, A.TTL_DMDT_AMT, A.COST_ASS_BSE_CD, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT)" ).append("\n"); 
		query.append("    VALUES(B.COST_YRMON, B.CNTR_TPSZ_CD, B.STND_COST_CD, B.UC_AMT, B.BKG_VOL_QTY, B.TTL_DMDT_AMT, B.COST_ASS_BSE_CD, B.CRE_USR_ID, B.CRE_DT, B.UPD_USR_ID, B.UPD_DT)" ).append("\n"); 

	}
}