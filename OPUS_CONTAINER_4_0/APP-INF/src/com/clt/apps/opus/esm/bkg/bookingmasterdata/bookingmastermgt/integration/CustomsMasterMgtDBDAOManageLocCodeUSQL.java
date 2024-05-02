/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsMasterMgtDBDAOManageLocCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsMasterMgtDBDAOManageLocCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  0354 Canada ACI: Location of Goods Setup - Loc Code 생성/수정			
	  * </pre>
	  */
	public CustomsMasterMgtDBDAOManageLocCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gds_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : CustomsMasterMgtDBDAOManageLocCodeUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_CND_GDS_LOC TA" ).append("\n"); 
		query.append("    USING (" ).append("\n"); 
		query.append("            SELECT   @[pod_cd] POD_CD" ).append("\n"); 
		query.append("                   , @[del_cd] DEL_CD" ).append("\n"); 
		query.append("                   , @[hub_loc_cd] HUB_LOC_CD" ).append("\n"); 
		query.append("                   , @[trsp_mod_id] TRSP_MOD_ID" ).append("\n"); 
		query.append("                   , @[gds_desc] GDS_DESC" ).append("\n"); 
		query.append("				   , @[cstms_cd] CSTMS_CD" ).append("\n"); 
		query.append("                   , @[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("                   , @[pod_yd_no] POD_YD_NO" ).append("\n"); 
		query.append("                   , @[gds_loc_seq] GDS_LOC_SEQ" ).append("\n"); 
		query.append("            FROM   DUAL" ).append("\n"); 
		query.append("          ) TB" ).append("\n"); 
		query.append("    ON(TA.GDS_LOC_SEQ = TB.GDS_LOC_SEQ)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET HUB_LOC_CD  = TB.HUB_LOC_CD" ).append("\n"); 
		query.append("             , TRSP_MOD_ID = TB.TRSP_MOD_ID" ).append("\n"); 
		query.append("             , GDS_DESC    = TB.GDS_DESC" ).append("\n"); 
		query.append("			 , CSTMS_CD	   = TB.CSTMS_CD" ).append("\n"); 
		query.append("             , UPD_USR_ID  = TB.UPD_USR_ID" ).append("\n"); 
		query.append("             , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("             , POD_YD_NO   = TB.POD_YD_NO" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT (POD_CD        ,DEL_CD    ,HUB_LOC_CD    ,TRSP_MOD_ID    ,GDS_DESC       ,CSTMS_CD    " ).append("\n"); 
		query.append("           ,CRE_USR_ID    ,CRE_DT    ,UPD_USR_ID    ,UPD_DT         ,POD_YD_NO      ,GDS_LOC_SEQ)" ).append("\n"); 
		query.append("    VALUES (TB.POD_CD     ,TB.DEL_CD ,TB.HUB_LOC_CD ,TB.TRSP_MOD_ID ,TB.GDS_DESC    ,TB.CSTMS_CD" ).append("\n"); 
		query.append("           ,TB.UPD_USR_ID ,SYSDATE   ,TB.UPD_USR_ID ,SYSDATE        ,TB.POD_YD_NO   ,( SELECT NVL(MAX(GDS_LOC_SEQ),0) + 1 FROM BKG_CSTMS_CND_GDS_LOC )" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}