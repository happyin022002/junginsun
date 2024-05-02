/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOsearchBayPlanPolInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.11.23 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOsearchBayPlanPolInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOsearchBayPlanPolInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOsearchBayPlanPolInfoRSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_CHAR(ACT_DEP_DT, 'YYYYMMDDHH24MI') ACT_DEP_DT" ).append("\n"); 
		query.append("FROM VSK_ACT_PORT_SKD" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND	VSL_CD		    = SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO		= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD		= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("AND	VPS_PORT_CD		= @[pol]" ).append("\n"); 
		query.append("AND	CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 
		query.append(") POL_ACT_DEP_DT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHH24MI') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("WHERE VSL_CD		= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO		= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD		= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("AND	VPS_PORT_CD		= @[pol]" ).append("\n"); 
		query.append("AND	CLPT_IND_SEQ	= @[clpt_ind_seq]" ).append("\n"); 
		query.append(") POL_EST_DEP_DT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MI') VPS_ETA_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("WHERE VSL_CD		= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO		= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD		= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("AND	VPS_PORT_CD		= @[pod]" ).append("\n"); 
		query.append("AND	CLPT_IND_SEQ	= '1'" ).append("\n"); 
		query.append(") POD_EST_ARR_DT," ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("    SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("        WHERE A.VSL_CD 		= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO 	= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD 	= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("         AND NVL(A.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("        AND A.CLPT_SEQ = (" ).append("\n"); 
		query.append("            SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD A " ).append("\n"); 
		query.append("            WHERE A.VSL_CD 		= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO 	= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD 	= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("            AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("            AND VPS_PORT_CD =@[vps_port_cd]" ).append("\n"); 
		query.append("			AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append(" ) FRIST_CA_PORT," ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHH24MI') FRIST_ETA_DT" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("        WHERE A.VSL_CD 		= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO 	= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD 	= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("		AND NVL(A.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("        AND A.CLPT_SEQ = (" ).append("\n"); 
		query.append("            SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD A " ).append("\n"); 
		query.append("            WHERE A.VSL_CD 		= SUBSTR(@[vvd],1, 4)" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO 	= SUBSTR(@[vvd],5, 4)" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD 	= SUBSTR(@[vvd],9, 1)" ).append("\n"); 
		query.append("            AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("            AND VPS_PORT_CD =@[vps_port_cd]" ).append("\n"); 
		query.append("			AND CLPT_IND_SEQ=@[clpt_ind_seq]" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append(" ) FRIST_CA_ETA_DT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT 'Y'" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ADV_STWG_SND_LOG A" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND CVY_REF_NO = @[cvy_ref_no]" ).append("\n"); 
		query.append("    AND ROWNUM=1" ).append("\n"); 
		query.append(") ORIGIN_TRAN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}