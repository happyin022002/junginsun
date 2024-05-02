/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_atch_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVORSQL").append("\n"); 
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
		query.append("	STV_DMG_NO" ).append("\n"); 
		query.append(",	STV_DMG_PROC_CD" ).append("\n"); 
		query.append(",	STV_DMG_ATCH_FILE_TP_CD" ).append("\n"); 
		query.append(",	STV_DMG_ATCH_FILE_SEQ" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	FILE_NM" ).append("\n"); 
		query.append(",	FILE_SAV_ID" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',UPD_DT,'GMT'), UPD_DT), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_ATCH_FILE" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append("#if (${stv_dmg_proc_cd} != '') " ).append("\n"); 
		query.append("AND	STV_DMG_PROC_CD = @[stv_dmg_proc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stv_dmg_atch_file_tp_cd} != '') " ).append("\n"); 
		query.append("AND	STV_DMG_ATCH_FILE_TP_CD = @[stv_dmg_atch_file_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY STV_DMG_NO,STV_DMG_PROC_CD,STV_DMG_ATCH_FILE_TP_CD,STV_DMG_ATCH_FILE_SEQ" ).append("\n"); 

	}
}