/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOaddBareMGSetDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOaddBareMGSetDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBareMGSetData
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOaddBareMGSetDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eq_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_bare_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bare_mgst_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_bare_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOaddBareMGSetDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_BARE_MGST_REPO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     MGST_NO" ).append("\n"); 
		query.append("    ,MGST_BARE_STS_SEQ" ).append("\n"); 
		query.append("    ,MGST_BARE_STS_CD  " ).append("\n"); 
		query.append("    ,CHSS_NO" ).append("\n"); 
		query.append("    ,CNTR_NO" ).append("\n"); 
		query.append("    ,VNDR_SEQ" ).append("\n"); 
		query.append("    ,EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("    ,RTN_YD_CD " ).append("\n"); 
		query.append("    ,BARE_MGST_RMK" ).append("\n"); 
		query.append("    ,MGST_BARE_EVNT_DT " ).append("\n"); 
		query.append("    ,CRE_OFC_CD" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     @[mgst_no]" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("        SELECT NVL(MAX(MGST_BARE_STS_SEQ),0) + 1 as MGST_BARE_STS_SEQ" ).append("\n"); 
		query.append("        FROM CGM_BARE_MGST_REPO" ).append("\n"); 
		query.append("        WHERE MGST_NO = @[mgst_no]   " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    ,@[mgst_bare_sts_cd]   " ).append("\n"); 
		query.append("    ,@[chss_no]" ).append("\n"); 
		query.append("    ,@[cntr_no]" ).append("\n"); 
		query.append("    ,@[vndr_seq]" ).append("\n"); 
		query.append("    ,@[eq_trsp_mod_cd]" ).append("\n"); 
		query.append("	,@[rtn_yd_cd]" ).append("\n"); 
		query.append("    ,@[bare_mgst_rmk]" ).append("\n"); 
		query.append("    ,TO_DATE(@[mgst_bare_evnt_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("    ,@[cre_ofc_cd]" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}