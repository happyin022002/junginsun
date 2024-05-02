/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOSdmsStepHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.09.07 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SunyoungLee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOSdmsStepHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgStepHis Table Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOSdmsStepHistoryVORSQL(){
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
		query.append("FileName : StevedoreDamageMgtDBDAOSdmsStepHistoryVORSQL").append("\n"); 
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
		query.append("SELECT H.STV_DMG_NO," ).append("\n"); 
		query.append("M.VSL_CD," ).append("\n"); 
		query.append("M.SKD_VOY_NO," ).append("\n"); 
		query.append("M.SKD_DIR_CD," ).append("\n"); 
		query.append("M.VPS_PORT_CD," ).append("\n"); 
		query.append("(SELECT SLAN_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD      = M.VSL_CD" ).append("\n"); 
		query.append("AND    SKD_VOY_NO  = M.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    SKD_DIR_CD  = M.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    VPS_PORT_CD  = M.VPS_PORT_CD)    AS SLAN_CD," ).append("\n"); 
		query.append("TO_CHAR(M.STV_DMG_EVNT_DT, 'YYYY-MM-DD') AS STV_DMG_EVNT_DT," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD02122'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = M.VSL_OSHP_CNTR_BLK_TP_CD) AS VSL_OSHP_CNTR_BLK_TP_CD," ).append("\n"); 
		query.append("M.STV_DMG_REF_NO," ).append("\n"); 
		query.append("M.CLM_HNDL_OFC_CD," ).append("\n"); 
		query.append("DECODE(H.STV_DMG_PROC_CD,'D',(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD01888'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = H.STV_DMG_CRNT_PROC_STS_CD),NULL) AS STV_DMG_PROC_CD," ).append("\n"); 
		query.append("H.STV_DMG_STEP_HIS_SEQ," ).append("\n"); 
		query.append("DECODE(H.STV_DMG_PROC_CD,'R',(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD01887'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = H.STV_DMG_CRNT_PROC_STS_CD),NULL) AS RPR_STS_CD," ).append("\n"); 
		query.append("DECODE(H.STV_DMG_PROC_CD,'C',(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD01884'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = H.STV_DMG_CRNT_PROC_STS_CD),NULL) AS CMPN_STS_CD," ).append("\n"); 
		query.append("DECODE(H.STV_DMG_PROC_CD,'S',(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE  INTG_CD_ID = 'CD01889'" ).append("\n"); 
		query.append("AND    INTG_CD_VAL_CTNT = H.STV_DMG_CRNT_PROC_STS_CD),NULL) AS STL_STS_CD," ).append("\n"); 
		query.append("(SELECT OFC_CD" ).append("\n"); 
		query.append("FROM   COM_USER" ).append("\n"); 
		query.append("WHERE  USR_ID = H.UPD_USR_ID) AS CRE_USR_OFC_CD," ).append("\n"); 
		query.append("(SELECT USR_NM" ).append("\n"); 
		query.append("FROM   COM_USER" ).append("\n"); 
		query.append("WHERE  USR_ID = H.UPD_USR_ID) AS CRE_USR_NM," ).append("\n"); 
		query.append("H.UPD_USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(H.UPD_DT,'YYYY-MM-DD') AS CRE_DT," ).append("\n"); 
		query.append("TO_CHAR(H.UPD_DT,'HH24:MI')    AS CRE_TIME" ).append("\n"); 
		query.append("FROM   OPF_STV_DMG_STEP_HIS H, OPF_STV_DMG M" ).append("\n"); 
		query.append("WHERE  M.STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 
		query.append("AND    H.STV_DMG_NO(+) = M.STV_DMG_NO" ).append("\n"); 
		query.append("ORDER BY H.STV_DMG_STEP_HIS_SEQ, H.UPD_DT" ).append("\n"); 

	}
}