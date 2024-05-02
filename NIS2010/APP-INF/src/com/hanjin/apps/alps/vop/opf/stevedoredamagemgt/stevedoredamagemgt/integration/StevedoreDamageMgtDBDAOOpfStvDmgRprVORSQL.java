/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgRprVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.03.16 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgRprVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgRprVO Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgRprVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgRprVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("STV_DMG_NO" ).append("\n"); 
		query.append(",	STV_DMG_RPR_SEQ" ).append("\n"); 
		query.append(",	STV_DMG_RPR_PROC_STS_CD" ).append("\n"); 
		query.append(",	QTTN_LOCL_CURR_CD" ).append("\n"); 
		query.append(",	QTTN_COST_LOCL_AMT" ).append("\n"); 
		query.append(",	QTTN_COST_USD_AMT" ).append("\n"); 
		query.append(",	RPR_PORT_CD" ).append("\n"); 
		query.append(",	TO_CHAR(RPR_DT, 'YYYY-MM-DD') AS RPR_DT" ).append("\n"); 
		query.append(",	RPR_VNDR_NM" ).append("\n"); 
		query.append(",	USTL_ACCT_NO" ).append("\n"); 
		query.append(",	RUN_RPR_ACCT_NO" ).append("\n"); 
		query.append(",	RPR_CURR_CD" ).append("\n"); 
		query.append(",	RPR_COST_LOCL_AMT" ).append("\n"); 
		query.append(",	RPR_COST_USD_AMT" ).append("\n"); 
		query.append(",	RPR_RSLT_RPT_ATCH_FLG" ).append("\n"); 
		query.append(",	RPR_INV_ATCH_FLG" ).append("\n"); 
		query.append(",	RPR_PICT_ATCH_FLG" ).append("\n"); 
		query.append(",	RPR_DOC_ATCH_FLG" ).append("\n"); 
		query.append(",	RPR_RMK" ).append("\n"); 
		query.append(",	RPR_EML_SND_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',UPD_DT,'GMT'), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",   RPR_RSLT_RPT_ATCH_KNT" ).append("\n"); 
		query.append(",   RPR_INV_ATCH_KNT" ).append("\n"); 
		query.append(",   RPR_PICT_ATCH_KNT" ).append("\n"); 
		query.append(",   RPR_DOC_ATCH_KNT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_RPR" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 

	}
}