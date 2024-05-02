/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOMergeKorDoSelfTransFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOMergeKorDoSelfTransFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOMergeKorDoSelfTransFlgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("self_trns_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOMergeKorDoSelfTransFlgUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_DO A" ).append("\n"); 
		query.append("USING (SELECT  @[bkg_no]                 AS BKG_NO   " ).append("\n"); 
		query.append("              ,'1'                       AS RLSE_SEQ " ).append("\n"); 
		query.append("              ,@[self_trns_flg]          AS SELF_TRNS_FLG   " ).append("\n"); 
		query.append("              ,'N'                       AS CUST_PRN_FLG  " ).append("\n"); 
		query.append("              ,@[cre_usr_id]             AS CRE_USR_ID  " ).append("\n"); 
		query.append("              ,SYSDATE                   AS CRE_DT           " ).append("\n"); 
		query.append("              ,@[upd_usr_id]             AS UPD_USR_ID " ).append("\n"); 
		query.append("			  ,SYSDATE                   AS UPD_DT    " ).append("\n"); 
		query.append("        FROM DUAL " ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.RLSE_SEQ=B.RLSE_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET SELF_TRNS_FLG  = B.SELF_TRNS_FLG" ).append("\n"); 
		query.append("    ,   CUST_PRN_FLG   = B.CUST_PRN_FLG" ).append("\n"); 
		query.append("    ,	UPD_USR_ID     = B.UPD_USR_ID" ).append("\n"); 
		query.append("    ,	UPD_DT         = B.UPD_DT    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (BKG_NO,RLSE_SEQ,SELF_TRNS_FLG,CUST_PRN_FLG,CRE_USR_ID,CRE_DT, UPD_USR_ID, UPD_DT) VALUES( B.BKG_NO                  " ).append("\n"); 
		query.append("                 , B.RLSE_SEQ           " ).append("\n"); 
		query.append("                 , NVL(B.SELF_TRNS_FLG, 'N')" ).append("\n"); 
		query.append("                 , NVL(B.CUST_PRN_FLG, 'N') " ).append("\n"); 
		query.append("                 , B.CRE_USR_ID              " ).append("\n"); 
		query.append("                 , B.CRE_DT               " ).append("\n"); 
		query.append("                 , B.UPD_USR_ID" ).append("\n"); 
		query.append("                 , B.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    " ).append("\n"); 

	}
}