/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgStlVORSQL.java
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

public class StevedoreDamageMgtDBDAOOpfStvDmgStlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgStlVO Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgStlVORSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgStlVORSQL").append("\n"); 
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
		query.append(",	STV_DMG_STL_PROC_STS_CD" ).append("\n"); 
		query.append(",	SHP_OWNR_CO_NM" ).append("\n"); 
		query.append(",	USTL_ACCT_NO" ).append("\n"); 
		query.append(",	RUN_RPR_ACCT_NO" ).append("\n"); 
		query.append(",	BIL_INV_NO" ).append("\n"); 
		query.append(",	TO_CHAR(PAY_DT, 'YYYY-MM-DD') AS PAY_DT" ).append("\n"); 
		query.append(",	PAY_CURR_CD" ).append("\n"); 
		query.append(",	PAY_LOCL_AMT" ).append("\n"); 
		query.append(",	PAY_USD_AMT" ).append("\n"); 
		query.append(",	PAY_ACCT_NO" ).append("\n"); 
		query.append(",	STL_INV_ATCH_FLG" ).append("\n"); 
		query.append(",	STL_DOC_ATCH_FLG" ).append("\n"); 
		query.append(",	STL_RMK" ).append("\n"); 
		query.append(",	STL_APRO_DT" ).append("\n"); 
		query.append(",	STL_APRO_FLG" ).append("\n"); 
		query.append(",	STL_APRO_USR_ID" ).append("\n"); 
		query.append(",	STL_EML_SND_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',UPD_DT,'GMT'), UPD_DT), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",   STL_INV_ATCH_KNT" ).append("\n"); 
		query.append(",   STL_DOC_ATCH_KNT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_STL" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 

	}
}