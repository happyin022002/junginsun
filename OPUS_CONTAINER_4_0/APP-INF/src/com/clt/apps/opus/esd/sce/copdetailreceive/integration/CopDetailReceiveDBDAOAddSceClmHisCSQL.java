/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOAddSceClmHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOAddSceClmHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceClmHis
	  * </pre>
	  */
	public CopDetailReceiveDBDAOAddSceClmHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_dest_n1st_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtl_seq_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_itchg_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOAddSceClmHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_CLM (CNTR_NO" ).append("\n"); 
		query.append(",CNMV_YR" ).append("\n"); 
		query.append(",CNMV_ID_NO" ).append("\n"); 
		query.append(",CLM_SEQ" ).append("\n"); 
		query.append(",ARR_DT" ).append("\n"); 
		query.append(",ARR_LOC_NM" ).append("\n"); 
		query.append(",ARR_STE_CD" ).append("\n"); 
		query.append(",DEP_DT" ).append("\n"); 
		query.append(",CLM_CRR_NM" ).append("\n"); 
		query.append(",TRSP_MOD_TP_CD" ).append("\n"); 
		query.append(",CLM_RCV_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("VALUES(@[cntr_no]" ).append("\n"); 
		query.append(", CASE WHEN to_number(@[cop_itchg_chk]) = 1 OR (to_number(@[cop_itchg_chk]) > 1 AND @[dtl_seq_tp] = 'MAX') THEN 'DETA'" ).append("\n"); 
		query.append("ELSE 'IETA' END" ).append("\n"); 
		query.append(",@[cnmv_id_no]" ).append("\n"); 
		query.append(",@[clm_seq]" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",SUBSTR(@[evnt_cty_nm],1,20)" ).append("\n"); 
		query.append(",@[evnt_ste_cd]" ).append("\n"); 
		query.append(",TO_DATE(@[rail_dest_n1st_eta_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",@[sndr_id]" ).append("\n"); 
		query.append(",'R'" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",SYSDATE)" ).append("\n"); 

	}
}