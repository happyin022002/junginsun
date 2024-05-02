/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgUserVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.04 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgUserVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgUserVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scr_grd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgUserVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	U.USR_ID" ).append("\n"); 
		query.append(",	U.USR_NM" ).append("\n"); 
		query.append(",	U.USR_PWD" ).append("\n"); 
		query.append(",	U.OFC_CD" ).append("\n"); 
		query.append(",	R.USR_ROLE_CD SCR_GRD_CD" ).append("\n"); 
		query.append(",	U.JB_ENG_NM JB_NM" ).append("\n"); 
		query.append(",	U.XTN_PHN_NO PHN_NO" ).append("\n"); 
		query.append(",	U.MPHN_NO" ).append("\n"); 
		query.append(",	U.FAX_NO" ).append("\n"); 
		query.append(",	U.USR_EML" ).append("\n"); 
		query.append("--,	DELT_FLG" ).append("\n"); 
		query.append(",	U.CRE_USR_ID" ).append("\n"); 
		query.append(",	U.CRE_DT" ).append("\n"); 
		query.append(",	U.UPD_USR_ID" ).append("\n"); 
		query.append(",	U.UPD_DT" ).append("\n"); 
		query.append("FROM COM_USER U" ).append("\n"); 
		query.append("    ,COM_USR_ROLE_MTCH R" ).append("\n"); 
		query.append("WHERE U.USR_ID = R.USR_ID" ).append("\n"); 
		query.append("#if (${usr_id} != '') " ).append("\n"); 
		query.append("AND U.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_nm} != '') " ).append("\n"); 
		query.append("AND	U.USR_NM like @[usr_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scr_grd_cd} != '') " ).append("\n"); 
		query.append("AND	R.USR_ROLE_CD = @[scr_grd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}