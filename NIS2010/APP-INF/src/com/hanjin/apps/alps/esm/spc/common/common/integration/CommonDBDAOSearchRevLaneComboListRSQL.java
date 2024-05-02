/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchRevLaneComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchRevLaneComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Lane을 가져온다.
	  * 김종준 AND B.TRD_CD   = -> in  ($trdCd)  수정
	  * </pre>
	  */
	public CommonDBDAOSearchRevLaneComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchRevLaneComboListRSQL").append("\n"); 
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
		query.append("/* Lane List를  가져 온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         B.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD  ," ).append("\n"); 
		query.append("         A.RLANE_NM" ).append("\n"); 
		query.append("    FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("         MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("         MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("   WHERE A.RLANE_CD     = B.RLANE_CD" ).append("\n"); 
		query.append("     AND A.VSL_TP_CD    = 'C'" ).append("\n"); 
		query.append("#if (${ipc} != 'true')" ).append("\n"); 
		query.append("     AND A.REP_TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trdCd} != '')" ).append("\n"); 
		query.append("     AND B.TRD_CD   IN ($trdCd) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${subTrdCd} != '')" ).append("\n"); 
		query.append("     AND B.SUB_TRD_CD   IN ($subTrdCd) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND B.DELT_FLG   IN ('N', @[del])" ).append("\n"); 
		query.append("     AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("     AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("     AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("     AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("ORDER BY B.TRD_CD    ," ).append("\n"); 
		query.append("         B.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD" ).append("\n"); 

	}
}