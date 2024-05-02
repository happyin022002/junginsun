/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyUserAuthSetupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.02.10 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyUserAuthSetupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 갱신
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyUserAuthSetupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mib",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_fpo",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("of_his",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_hub",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_ptt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("of_mit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mi_hub",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyUserAuthSetupUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_COM_USR_AUTH" ).append("\n"); 
		query.append("   SET CSTMS_AUTH_FLG =" ).append("\n"); 
		query.append("           CASE WHEN @[bl_vvd] = 1 AND PROC_ID = 'BLI' AND ACT_ID = 'VVD' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[bl_pod] = 1 AND PROC_ID = 'BLI' AND ACT_ID = 'POD' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[bl_del] = 1 AND PROC_ID = 'BLI' AND ACT_ID = 'DEL' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[bl_hub] = 1 AND PROC_ID = 'BLI' AND ACT_ID = 'HUB' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[bl_mib] = 1 AND PROC_ID = 'BLI' AND ACT_ID = 'MIB' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[bl_fpo] = 1 AND PROC_ID = 'BLI' AND ACT_ID = 'FPO' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[bl_ptt] = 1 AND PROC_ID = 'BLI' AND ACT_ID = 'PTT' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[mi_hub] = 1 AND PROC_ID = 'MIB' AND ACT_ID = 'HUB' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[of_mit] = 1 AND PROC_ID = 'OFM' AND ACT_ID = 'MIT' THEN 'Y'" ).append("\n"); 
		query.append("                WHEN @[of_his] = 1 AND PROC_ID = 'OFM' AND ACT_ID = 'HIS' THEN 'Y'" ).append("\n"); 
		query.append("           ELSE 'N' END" ).append("\n"); 
		query.append("      ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND USR_ID = @[usr_id]" ).append("\n"); 

	}
}