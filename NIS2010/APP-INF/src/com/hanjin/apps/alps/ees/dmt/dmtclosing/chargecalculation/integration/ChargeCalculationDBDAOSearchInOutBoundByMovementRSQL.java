/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchInOutBoundByMovementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchInOutBoundByMovementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR Movement 정보에 대해서 해당 CNTR의 In/Out Bound 정보를 조회한다.
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchInOutBoundByMovementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchInOutBoundByMovementRSQL").append("\n"); 
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
		query.append("SELECT	NVL(ATTR_CTNT8,OB_CNTR_FLG)" ).append("\n"); 
		query.append("FROM	CTM_MOVEMENT CTM, DMT_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("WHERE	CTM.CNTR_NO		= @[cntr_no]" ).append("\n"); 
		query.append("AND		CTM.CNMV_CYC_NO	= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		CTM.MVMT_STS_CD	= 'VD'" ).append("\n"); 
		query.append("AND		CTM.ORG_YD_CD	= @[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("AND 	HRD.HRD_CDG_ID(+) = 'SHIP_BACK_CDG'" ).append("\n"); 
		query.append("AND     HRD.ATTR_CTNT3(+) = CTM.CNTR_NO" ).append("\n"); 
		query.append("AND     HRD.ATTR_CTNT4(+) = CTM.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND     HRD.ATTR_CTNT7(+) = CTM.ORG_YD_CD" ).append("\n"); 

	}
}