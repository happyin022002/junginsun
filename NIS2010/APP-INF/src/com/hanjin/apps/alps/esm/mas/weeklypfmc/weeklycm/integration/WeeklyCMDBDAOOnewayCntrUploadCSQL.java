/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOOnewayCntrUploadCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.05.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOOnewayCntrUploadCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Oneway Container Upload 의 정보를 삽입 후 저장한다.
	  * </pre>
	  */
	public WeeklyCMDBDAOOnewayCntrUploadCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOOnewayCntrUploadCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_OFFH_BKG_LIST A USING " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT  @[bkg_no]  BKG_NO" ).append("\n"); 
		query.append("              , @[cntr_no] CNTR_NO " ).append("\n"); 
		query.append("              , @[tpsz_cd] TPSZ_CD" ).append("\n"); 
		query.append("              , @[term_cd] TERM_CD" ).append("\n"); 
		query.append("              , @[mvmt_cd] MVMT_CD" ).append("\n"); 
		query.append("              , REPLACE(@[onh_dt],'-','') ONH_DT" ).append("\n"); 
		query.append("              , @[onh_yd_cd] ONH_YD_CD" ).append("\n"); 
		query.append("              , REPLACE(@[offh_dt],'-','') OFFH_DT" ).append("\n"); 
		query.append("              , @[offh_yd_cd] OFFH_YD_CD" ).append("\n"); 
		query.append("           FROM DUAL " ).append("\n"); 
		query.append(") B " ).append("\n"); 
		query.append("ON (    " ).append("\n"); 
		query.append("        A.BKG_NO   = B.BKG_NO " ).append("\n"); 
		query.append("    AND A.CNTR_NO  = B.CNTR_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append(" UPDATE" ).append("\n"); 
		query.append("    SET A.TPSZ_CD       = B.TPSZ_CD" ).append("\n"); 
		query.append("      , A.TERM_CD       = B.TERM_CD" ).append("\n"); 
		query.append("	  , A.MVMT_CD       = B.MVMT_CD    " ).append("\n"); 
		query.append("      , A.ONH_DT        = TO_DATE(B.ONH_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("      , A.ONH_YD_CD     = B.ONH_YD_CD     " ).append("\n"); 
		query.append("      , A.OFFH_DT       = TO_DATE(B.OFFH_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("      , A.OFFH_YD_CD    = B.OFFH_YD_CD" ).append("\n"); 
		query.append("      , A.UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("      , A.UPD_DT        = SYSDATE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" INSERT" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append("           ,CNTR_NO" ).append("\n"); 
		query.append("           ,TPSZ_CD" ).append("\n"); 
		query.append("           ,TERM_CD" ).append("\n"); 
		query.append("           ,MVMT_CD" ).append("\n"); 
		query.append("           ,ONH_DT" ).append("\n"); 
		query.append("           ,ONH_YD_CD" ).append("\n"); 
		query.append("           ,OFFH_DT" ).append("\n"); 
		query.append("           ,OFFH_YD_CD" ).append("\n"); 
		query.append("           ,CRE_USR_ID" ).append("\n"); 
		query.append("           ,CRE_DT" ).append("\n"); 
		query.append("           ,UPD_USR_ID" ).append("\n"); 
		query.append("           ,UPD_DT" ).append("\n"); 
		query.append("        ) VALUES( " ).append("\n"); 
		query.append("            @[bkg_no]" ).append("\n"); 
		query.append("           ,@[cntr_no]" ).append("\n"); 
		query.append("           ,@[tpsz_cd]" ).append("\n"); 
		query.append("           ,@[term_cd]" ).append("\n"); 
		query.append("           ,@[mvmt_cd]" ).append("\n"); 
		query.append("           ,TO_DATE(@[onh_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("           ,@[onh_yd_cd]	" ).append("\n"); 
		query.append("           ,TO_DATE(@[offh_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("           ,@[offh_yd_cd]	" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}