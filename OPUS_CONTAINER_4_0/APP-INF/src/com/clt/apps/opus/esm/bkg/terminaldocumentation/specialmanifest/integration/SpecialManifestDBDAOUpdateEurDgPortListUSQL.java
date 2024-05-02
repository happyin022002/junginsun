/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialManifestDBDAOUpdateEurDgPortListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOUpdateEurDgPortListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur DG 관련 Berth Port Setup 내용을 수정한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOUpdateEurDgPortListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dchg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOUpdateEurDgPortListUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_EUR_DG_SND_STUP " ).append("\n"); 
		query.append("USING DUAL " ).append("\n"); 
		query.append("ON ( PORT_CD = @[port_cd] " ).append("\n"); 
		query.append("     AND CRR_CD = @[crr_cd] )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("           SET STWG_FLG = @[stwg_flg] " ).append("\n"); 
		query.append("         , LOD_CD = @[lod_cd] " ).append("\n"); 
		query.append("         , TZ_CD = @[tz_cd] " ).append("\n"); 
		query.append("         , DCHG_CD = @[dchg_cd] " ).append("\n"); 
		query.append("         , UPD_USR_ID = @[user_id] " ).append("\n"); 
		query.append("         , UPD_DT = SYSDATE  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("           ( " ).append("\n"); 
		query.append("               PORT_CD " ).append("\n"); 
		query.append("             , CRR_CD " ).append("\n"); 
		query.append("             , STWG_FLG " ).append("\n"); 
		query.append("             , LOD_CD " ).append("\n"); 
		query.append("             , TZ_CD " ).append("\n"); 
		query.append("             , DCHG_CD " ).append("\n"); 
		query.append("             , CRE_USR_ID " ).append("\n"); 
		query.append("             , CRE_DT " ).append("\n"); 
		query.append("             , UPD_USR_ID " ).append("\n"); 
		query.append("             , UPD_DT " ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("           VALUES " ).append("\n"); 
		query.append("           (  " ).append("\n"); 
		query.append("               @[port_cd] " ).append("\n"); 
		query.append("             , @[crr_cd] " ).append("\n"); 
		query.append("             , @[stwg_flg] " ).append("\n"); 
		query.append("             , @[lod_cd] " ).append("\n"); 
		query.append("             , @[tz_cd] " ).append("\n"); 
		query.append("             , @[dchg_cd] " ).append("\n"); 
		query.append("             , @[user_id] " ).append("\n"); 
		query.append("             , SYSDATE " ).append("\n"); 
		query.append("             , @[user_id] " ).append("\n"); 
		query.append("             , SYSDATE " ).append("\n"); 
		query.append("           ) " ).append("\n"); 

	}
}