/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOmodifyContainerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOmodifyContainerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyContainer
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOmodifyContainerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ibd_cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOmodifyContainerUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_AMER_CNTR CT" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[cnt_cd] AS CNT_CD," ).append("\n"); 
		query.append("		   @[bl_no] AS BL_NO," ).append("\n"); 
		query.append("		   @[cntr_no] AS CNTR_NO" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append(") TM" ).append("\n"); 
		query.append("ON ( CT.CNT_CD = TM.CNT_CD AND" ).append("\n"); 
		query.append("	 CT.BL_NO = TM.BL_NO AND" ).append("\n"); 
		query.append("	 CT.CNTR_NO = TM.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE" ).append("\n"); 
		query.append("        SET		UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("		,		CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("		,		FULL_MTY_CD = @[full_mty_cd]" ).append("\n"); 
		query.append("		,		IBD_CNTR_STS_CD = 'A'" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT ( CNT_CD" ).append("\n"); 
		query.append("                ,BL_NO" ).append("\n"); 
		query.append("				,CNTR_NO" ).append("\n"); 
		query.append("			    ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,IBD_CNTR_STS_CD" ).append("\n"); 
		query.append("				,FULL_MTY_CD" ).append("\n"); 
		query.append("                ,IO_BND_CD" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,UPD_USR_ID" ).append("\n"); 
		query.append("                ,UPD_DT )" ).append("\n"); 
		query.append("        VALUES ( @[cnt_cd]" ).append("\n"); 
		query.append("                ,@[bl_no]" ).append("\n"); 
		query.append("				,@[cntr_no]" ).append("\n"); 
		query.append("				,@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("				,NVL(@[ibd_cntr_sts_cd],'A')" ).append("\n"); 
		query.append("                ,@[full_mty_cd]" ).append("\n"); 
		query.append("                ,'O'" ).append("\n"); 
		query.append("                ,@[cre_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE" ).append("\n"); 
		query.append("                ,@[upd_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE )" ).append("\n"); 

	}
}