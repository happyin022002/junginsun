/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgCmpnVORSQL.java
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

public class StevedoreDamageMgtDBDAOOpfStvDmgCmpnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgCmpnVO Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgCmpnVORSQL(){
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
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgCmpnVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',UPD_DT,'GMT'), UPD_DT), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",	STV_DMG_NO" ).append("\n"); 
		query.append(",	STV_DMG_CMPN_PROC_STS_CD" ).append("\n"); 
		query.append(",	CLM_HNDL_OFC_CD" ).append("\n"); 
		query.append(",	CLM_HNDL_USR_ID" ).append("\n"); 
		query.append(",	(SELECT USR_NM " ).append("\n"); 
		query.append("	 FROM   COM_USER" ).append("\n"); 
		query.append("	 WHERE  USR_ID = CMPN.CLM_HNDL_USR_ID" ).append("\n"); 
		query.append("	   AND  OFC_CD = CMPN.CLM_HNDL_OFC_CD) AS CLM_HNDL_USR_NM " ).append("\n"); 
		query.append(",	STV_DMG_RESPB_PTY_CO_NM" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_PTY_PIC_NM" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_PTY_PIC_TIT_NM" ).append("\n"); 
		query.append(",	TO_CHAR(STV_DMG_CMPN_DT, 'YYYY-MM-DD') AS STV_DMG_CMPN_DT" ).append("\n"); 
		query.append(",	CMPN_CURR_CD" ).append("\n"); 
		query.append(",	CMPN_COST_LOCL_AMT" ).append("\n"); 
		query.append(",	CMPN_COST_USD_AMT" ).append("\n"); 
		query.append(",	CMPN_ACCT_NO" ).append("\n"); 
		query.append(",	CMPN_EML_SND_NO" ).append("\n"); 
		query.append(",	CMPN_RMK" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_CMPN CMPN" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 

	}
}