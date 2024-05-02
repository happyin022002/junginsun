/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchDtocFreeTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.25 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchDtocFreeTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDtocFreeTime
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchDtocFreeTimeRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BB.BKG_NO" ).append("\n"); 
		query.append(",BC.DCGO_FLG" ).append("\n"); 
		query.append(",BC.RC_FLG" ).append("\n"); 
		query.append(",BC.AWK_CGO_FLG" ).append("\n"); 
		query.append(",BC.RD_CGO_FLG" ).append("\n"); 
		query.append(",BC.BB_CGO_FLG" ).append("\n"); 
		query.append(",BC.SOC_FLG" ).append("\n"); 
		query.append(",BC.CNTR_PRT_FLG" ).append("\n"); 
		query.append(",BC.ADV_SHTG_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BB.POR_CD 				POR_CD" ).append("\n"); 
		query.append(",NVL (RL.CONTI_CD, ' ') 	POR_CONTI_CD" ).append("\n"); 
		query.append(",NVL (RL.CNT_CD, ' ') 	POR_CNT_CD" ).append("\n"); 
		query.append(",NVL (RL.RGN_CD, ' ') 	POR_RGN_CD" ).append("\n"); 
		query.append(",NVL (RL.STE_CD, ' ') 	POR_STE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BB.POL_CD" ).append("\n"); 
		query.append(",NVL (LL.CONTI_CD, ' ') 	POL_CONTI_CD" ).append("\n"); 
		query.append(",NVL (LL.CNT_CD, ' ') 	POL_CNT_CD" ).append("\n"); 
		query.append(",NVL (LL.RGN_CD, ' ') 	POL_RGN_CD" ).append("\n"); 
		query.append(",NVL (LL.STE_CD, ' ') 	POL_STE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",BB.DEL_CD" ).append("\n"); 
		query.append(",NVL (EL.CONTI_CD, ' ') 	DEL_CONTI_CD" ).append("\n"); 
		query.append(",NVL (EL.CNT_CD, ' ') 	DEL_CNT_CD" ).append("\n"); 
		query.append(",NVL (EL.RGN_CD, ' ') 	DEL_RGN_CD" ).append("\n"); 
		query.append(",NVL (EL.STE_CD, ' ') 	DEL_STE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",SUBSTR (@[fm_yd_cd] ,1 ,5) YRD_CD" ).append("\n"); 
		query.append(",NVL (ML.CONTI_CD, ' ') 	YRD_CONTI_CD" ).append("\n"); 
		query.append(",NVL (ML.CNT_CD, ' ') 	YRD_CNT_CD" ).append("\n"); 
		query.append(",NVL (ML.RGN_CD, ' ') 	YRD_RGN_CD" ).append("\n"); 
		query.append(",NVL (ML.STE_CD, ' ') 	YRD_STE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append(",BKG_BOOKING BB" ).append("\n"); 
		query.append(",MDM_LOCATION RL" ).append("\n"); 
		query.append(",MDM_LOCATION LL" ).append("\n"); 
		query.append(",MDM_LOCATION EL" ).append("\n"); 
		query.append(",MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND BC.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("AND BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("AND BB.POR_CD = RL.LOC_CD" ).append("\n"); 
		query.append("AND BB.POL_CD = LL.LOC_CD" ).append("\n"); 
		query.append("AND BB.DEL_CD = EL.LOC_CD" ).append("\n"); 
		query.append("AND ML.LOC_CD = SUBSTR (@[fm_yd_cd],1,5)" ).append("\n"); 
		query.append("AND BB.BKG_STS_CD <> 'S'" ).append("\n"); 
		query.append("AND BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchDtocFreeTimeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}