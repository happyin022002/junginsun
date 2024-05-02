/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : MstMgmtDBDAOSearchMdmUsrAuthVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MstMgmtDBDAOSearchMdmUsrAuthVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmUsrAuthVO 리스트 정보 조회
	  * </pre>
	  */
	public MstMgmtDBDAOSearchMdmUsrAuthVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_dat_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auth_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.integration").append("\n"); 
		query.append("FileName : MstMgmtDBDAOSearchMdmUsrAuthVORSQL").append("\n"); 
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
		query.append("SELECT USR_ID," ).append("\n"); 
		query.append("       (SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = A.USR_ID) USR_NM," ).append("\n"); 
		query.append("       MST_DAT_SUBJ_CD," ).append("\n"); 
		query.append("       (SELECT U.OFC_CD" ).append("\n"); 
		query.append("          FROM COM_USER U" ).append("\n"); 
		query.append("         WHERE U.USR_ID = A.USR_ID) OFC_CD," ).append("\n"); 
		query.append("       AUTH_TP_CD," ).append("\n"); 
		query.append("       PGM_ID," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("	   UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI:SS') CRE_DT," ).append("\n"); 
		query.append("	   '' CRE_OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_USR_AUTH A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mst_dat_subj_cd} != '') " ).append("\n"); 
		query.append("	AND MST_DAT_SUBJ_CD = @[mst_dat_subj_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usr_id} != '')" ).append("\n"); 
		query.append("	AND USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${auth_tp_cd} != '') " ).append("\n"); 
		query.append("	AND AUTH_TP_CD = @[auth_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC " ).append("\n"); 

	}
}