/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOCheckSubTrdCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.07 
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

public class CommonDBDAOCheckSubTrdCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 Sub Trade의 유효성을 체크합니다.
	  * </pre>
	  */
	public CommonDBDAOCheckSubTrdCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCheckSubTrdCdRSQL").append("\n"); 
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
		query.append("   SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT DISTINCT" ).append("\n"); 
		query.append("                    B.TRD_CD  ," ).append("\n"); 
		query.append("                    SUB_TRD_CD" ).append("\n"); 
		query.append("               FROM MDM_REV_LANE     A," ).append("\n"); 
		query.append("                    MDM_DTL_REV_LANE B," ).append("\n"); 
		query.append("                    MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("              WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.VSL_TP_CD  = 'C'" ).append("\n"); 
		query.append("                AND B.DELT_FLG   IN ('N', 'N')" ).append("\n"); 
		query.append("                AND B.TRD_CD     <> 'COM'" ).append("\n"); 
		query.append("                AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("				AND B.TRD_CD 	 = @[trd_cd]	" ).append("\n"); 
		query.append("                AND B.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("												" ).append("\n"); 
		query.append("          ) A," ).append("\n"); 
		query.append("          MDM_SUB_TRD B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD = B.SUB_TRD_CD" ).append("\n"); 

	}
}