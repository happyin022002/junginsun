/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.03.29 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 실시간 배치대상에 이미 포함되어 있는지를 검사한다.
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL").append("\n"); 
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
		query.append("SELECT	'Y' AS PROG_FLG" ).append("\n"); 
		query.append("FROM	EAS_AUTO_AUD_BAT" ).append("\n"); 
		query.append("WHERE	SUB_SYS_CD				= 'TES'" ).append("\n"); 
		query.append("AND		BAT_PROG_STS_CD 		= 'P'" ).append("\n"); 
		query.append("AND		INV_NO					= @[inv_no]" ).append("\n"); 
		query.append("AND		INV_VNDR_SEQ			= @[vndr_seq]" ).append("\n"); 
		query.append("AND		INV_CFM_DT				= TO_DATE(@[inv_cfm_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND		NVL(VSL_CD, 'X')		= NVL(@[vsl_cd], 'X')" ).append("\n"); 
		query.append("AND		NVL(SKD_VOY_NO, 'X')	= NVL(@[skd_voy_no], 'X')" ).append("\n"); 
		query.append("AND		NVL(SKD_DIR_CD, 'X')	= NVL(@[skd_dir_cd], 'X')" ).append("\n"); 
		query.append("AND		NVL(IO_BND_CD, 'X')		= NVL(@[io_bnd_cd], 'X')" ).append("\n"); 

	}
}