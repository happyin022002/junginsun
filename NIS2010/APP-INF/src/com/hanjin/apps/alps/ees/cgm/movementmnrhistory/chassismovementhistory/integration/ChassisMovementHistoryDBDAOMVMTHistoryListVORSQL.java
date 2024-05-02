/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOMVMTHistoryListVORSQL.java
*@FileTitle : Chassis Movement Update by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.11 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOMVMTHistoryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOMVMTHistoryListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOMVMTHistoryListVORSQL").append("\n"); 
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
		query.append("DISTINCT" ).append("\n"); 
		query.append("CTM.CNMV_CYC_NO" ).append("\n"); 
		query.append(",BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VL" ).append("\n"); 
		query.append(",BKG.POR_CD" ).append("\n"); 
		query.append(",BKG.POL_CD" ).append("\n"); 
		query.append(",BKG.POD_CD" ).append("\n"); 
		query.append(",BKG.DEL_CD" ).append("\n"); 
		query.append(",BKG.BKG_NO" ).append("\n"); 
		query.append(",BKG.BL_NO BL_NO" ).append("\n"); 
		query.append(",MDT.REP_CMDT_NM" ).append("\n"); 
		query.append(",DECODE (BKG.POL_CD, BV.POL_CD, '', BV.POL_CD) RELAY" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, BKG_CONTAINER BCNT, (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("CTR.BKG_NO, CTR.CNMV_CYC_NO, CTR.CNTR_NO" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CTR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${p_cntrno} != '')" ).append("\n"); 
		query.append("AND CTR.CNTR_NO =  @[p_cntrno] || @[check_digit]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_date1} != '')" ).append("\n"); 
		query.append("AND CTR.CNMV_EVNT_DT BETWEEN TO_DATE (REPLACE (@[p_date1], '-', ''), 'YYYY-MM-DD') AND TO_DATE (REPLACE (@[p_date2], '-', ''), 'YYYY-MM-DD') + 0.9999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") CTM, MDM_REP_CMDT MDT, BKG_VVD BV" ).append("\n"); 
		query.append("WHERE CTM.CNTR_NO = BCNT.CNTR_NO" ).append("\n"); 
		query.append("AND CTM.CNMV_CYC_NO = BCNT.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND BCNT.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BKG.REP_CMDT_CD = MDT.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("AND BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BKG.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("AND BKG.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BKG.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("ORDER BY CTM.CNMV_CYC_NO ASC" ).append("\n"); 

	}
}