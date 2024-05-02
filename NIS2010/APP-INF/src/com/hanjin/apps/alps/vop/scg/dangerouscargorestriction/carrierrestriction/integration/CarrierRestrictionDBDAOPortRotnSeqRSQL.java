/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierRestrictionDBDAOPortRotnSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.05.14 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOPortRotnSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortRotnSeq 구하기
	  * </pre>
	  */
	public CarrierRestrictionDBDAOPortRotnSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOPortRotnSeqRSQL").append("\n"); 
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
		query.append("SELECT B.CLPT_SEQ" ).append("\n"); 
		query.append("  FROM VSK_PF_SKD A" ).append("\n"); 
		query.append("     , VSK_PF_SKD_DTL B" ).append("\n"); 
		query.append("     , VSK_PF_CALL_PORT C" ).append("\n"); 
		query.append("     , MDM_VSL_SVC_LANE_DIR D" ).append("\n"); 
		query.append("WHERE A.SLAN_STND_FLG = 'Y'" ).append("\n"); 
		query.append("  AND A.VSL_SLAN_CD   = B.VSL_SLAN_CD" ).append("\n"); 
		query.append("  AND A.PF_SVC_TP_CD  = B.PF_SVC_TP_CD    " ).append("\n"); 
		query.append("  AND B.VSL_SLAN_CD   = C.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("  AND B.PF_SVC_TP_CD  = C.PF_SVC_TP_CD(+)" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND B.PORT_CD       = C.PORT_CD(+)" ).append("\n"); 
		query.append("  AND B.PORT_ROTN_SEQ = C.PORT_ROTN_SEQ(+)" ).append("\n"); 
		query.append("  AND B.VSL_SLAN_CD   = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("  AND B.SKD_DIR_CD    = D.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("  AND A.VSL_SLAN_CD   = @[slan_cd]      --:lane_cd" ).append("\n"); 
		query.append("#if (${pol_port_cd} != '')" ).append("\n"); 
		query.append("  AND B.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("  AND B.PORT_CD      = @[pol_port_cd]   --:pol_cd" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND B.PORT_ROTN_SEQ <> 1" ).append("\n"); 
		query.append("  AND B.PORT_CD      = @[pod_port_cd]   --:pod_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY B.CLPT_SEQ" ).append("\n"); 
		query.append("ORDER BY B.CLPT_SEQ" ).append("\n"); 

	}
}