/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchIFTSAIDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchIFTSAIDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IFTSAI전송을 위한 Data조회
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchIFTSAIDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchIFTSAIDateRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CLPT_SEQ, @[vps_call_seq], '9', '153') PORT_IND" ).append("\n"); 
		query.append(", VPS_PORT_CD LOC_CD" ).append("\n"); 
		query.append(", LOC_NM LOC_DESC" ).append("\n"); 
		query.append(", NVL(PLISM_YD_CD, ' ') YD_CD" ).append("\n"); 
		query.append(", TO_CHAR(VPS_ETA_DT, 'RRRRMMDDHH24MI') ETA" ).append("\n"); 
		query.append(", TO_CHAR(VPS_ETD_DT, 'RRRRMMDDHH24MI') ETD" ).append("\n"); 
		query.append(", TO_CHAR(VPS_ETB_DT, 'RRRRMMDDHH24MI') ETB" ).append("\n"); 
		query.append(", TO_CHAR(NVL(PRD_GET_CCT_FNC(Yd_Cd,Slan_Cd,SKD_DIR_CD, 'F', VPS_ETB_DT, VPS_ETD_DT, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD  ) , VPS_ETB_DT -10/24), 'RRRRMMDDHH24MI') CCT" ).append("\n"); 
		query.append(", TO_CHAR(FT_DT, 'RRRRMMDD') FT" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD A, MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE   VPS_PORT_CD      = B.LOC_CD  (+)" ).append("\n"); 
		query.append("AND     VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO      = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD      = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     CLPT_SEQ       >= @[vps_call_seq]" ).append("\n"); 
		query.append("AND     'S'            <> NVL(A.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}