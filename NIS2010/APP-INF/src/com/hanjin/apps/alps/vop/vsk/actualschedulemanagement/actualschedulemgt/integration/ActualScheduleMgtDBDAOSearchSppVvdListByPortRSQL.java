/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchSppVvdListByPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.06
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.06 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchSppVvdListByPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPP에서 요청하는 Yard에 대해 이전, 이후 일주일 이내 VVD 리스트를 조회한다.
	  * ------------------------------------------------------------------------
	  * 2011.12.06 CHM-201114962-01 진마리아 SPP를 통해 스케줄 업데이트 하는 로직 변경
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchSppVvdListByPortRSQL(){
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
		params.put("vsl_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchSppVvdListByPortRSQL").append("\n"); 
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
		query.append("SELECT  A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, CLPT_IND_SEQ, C.VSL_ENG_NM" ).append("\n"); 
		query.append("    FROM    VSK_VSL_PORT_SKD A, VSK_VSL_SKD B, MDM_VSL_CNTR C, MDM_VSL_SVC_LANE D" ).append("\n"); 
		query.append("    WHERE   A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("    AND     A.SKD_VOY_NO    = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND     A.SKD_DIR_CD    = B.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND     B.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("    AND     B.SKD_STS_CD    = 'ACT'" ).append("\n"); 
		query.append("    AND     A.VPS_PORT_CD   = SUBSTR(@[vps_port_cd], 1, 5) -- SPP에서 YD_CD 값으로 전송됨" ).append("\n"); 
		query.append("    AND     A.YD_CD         = @[vps_port_cd]" ).append("\n"); 
		query.append("    AND     NVL(A.TURN_PORT_IND_CD, ' ') NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("    AND     'S'             <> NVL(A.SKD_CNG_STS_CD, 'N')" ).append("\n"); 
		query.append("    AND     B.VSL_SLAN_CD   = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND     D.VSL_TP_CD     = 'C' /* 컨테이너선 */" ).append("\n"); 
		query.append("    AND     DECODE(@[vsl_svc_tp_cd], NULL, 'ALL', 'A', 'A', DECODE(NVL(D.VSL_SVC_TP_CD, 'N'), 'O', 'O', 'T')) =" ).append("\n"); 
		query.append("            DECODE(@[vsl_svc_tp_cd], NULL, 'ALL', 'A', 'A', 'F', 'O', 'T')" ).append("\n"); 
		query.append("    AND     A.VPS_ETA_DT    BETWEEN SYSDATE - 7" ).append("\n"); 
		query.append("                            AND     SYSDATE + 7" ).append("\n"); 
		query.append("    ORDER BY 1, 2, 3" ).append("\n"); 

	}
}