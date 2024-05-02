/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BDRSettingDBDAOsearchBdrVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRSettingDBDAOsearchBdrVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBdrVvdList
	  * </pre>
	  */
	public BDRSettingDBDAOsearchBdrVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bdrbookinginterface.bdrbookinginterface.integration").append("\n"); 
		query.append("FileName : BDRSettingDBDAOsearchBdrVvdListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       'TRNK' AS UPD_CD" ).append("\n"); 
		query.append("FROM   BKG_VVD_BDR_LOG" ).append("\n"); 
		query.append("WHERE  NVL(TRNK_MNL_BDR_DT,TRNK_ESTM_BDR_DT) > SYSDATE-15" ).append("\n"); 
		query.append("AND    NVL(TRNK_MNL_BDR_DT,TRNK_ESTM_BDR_DT) <= SYSDATE -1" ).append("\n"); 
		query.append("AND    NVL(TRNK_MNL_BDR_DT,TRNK_ESTM_BDR_DT) >  GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),SYSDATE-15,POL_CD) " ).append("\n"); 
		query.append("AND    NVL(TRNK_MNL_BDR_DT,TRNK_ESTM_BDR_DT) <=  GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),SYSDATE-1,POL_CD) " ).append("\n"); 
		query.append("AND    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, POL_CD), 'HH24') <= '03'" ).append("\n"); 
		query.append("AND    'N' = TRNK_MNL_BDR_FLG" ).append("\n"); 
		query.append("AND    'N' = TRNK_BDR_FLG" ).append("\n"); 
		query.append("AND    (('M' = SLAN_TP_CD AND 'Y' = TRNK_AUTO_BDR_FLG) OR ('N' = TRNK_AUTO_BDR_FLG))" ).append("\n"); 
		query.append("AND		TRNK_BDR_SET_CD = 'A'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       'FDR'" ).append("\n"); 
		query.append("FROM   BKG_VVD_BDR_LOG" ).append("\n"); 
		query.append("WHERE  NVL(FDR_MNL_BDR_DT,FDR_ESTM_BDR_DT) > SYSDATE-15" ).append("\n"); 
		query.append("AND    NVL(FDR_MNL_BDR_DT,FDR_ESTM_BDR_DT) <= SYSDATE -1" ).append("\n"); 
		query.append("AND    NVL(FDR_MNL_BDR_DT,FDR_ESTM_BDR_DT) >  GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),SYSDATE-15,POL_CD) " ).append("\n"); 
		query.append("AND    NVL(FDR_MNL_BDR_DT,FDR_ESTM_BDR_DT) <=  GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(),SYSDATE-1,POL_CD) " ).append("\n"); 
		query.append("AND    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_CONSTANTMGR_PKG.COM_GETBASELOCATIONCODE_FNC(), SYSDATE, POL_CD), 'HH24') <= '03'" ).append("\n"); 
		query.append("AND    'N' = FDR_MNL_BDR_FLG " ).append("\n"); 
		query.append("AND    'N' = FDR_BDR_FLG " ).append("\n"); 
		query.append("AND	   'M' = SLAN_TP_CD" ).append("\n"); 
		query.append("--AND    (('M' = SLAN_TP_CD AND 'Y' = FDR_AUTO_BDR_FLG) OR ('N' = FDR_AUTO_BDR_FLG))" ).append("\n"); 

	}
}