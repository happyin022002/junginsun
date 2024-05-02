/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 어떤 Vessel이 특정 포트 접안일 기준, 과거 120일 이내에 Taiwan을 접안 하였는지 조회 
	  * 
	  * --------------------------------
	  * 2011.09.29 진마리아 CHM-201113488 [VOP-VSK] 신규 Object 등록 요청 (Previous Port)
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetPreviousTaiwanPortRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*), 0, 'N', 'Y')" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("     , (SELECT VP.VSL_CD" ).append("\n"); 
		query.append("             , VP.VPS_PORT_CD" ).append("\n"); 
		query.append("             , MAX(VP.VPS_ETD_DT) MAX_VPS_ETD_DT" ).append("\n"); 
		query.append("             , MAX(TO_CHAR(VP.VPS_ETB_DT,'YYYYMMDD')) AS MAX_VPS_ETB_DT" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append("         WHERE VP.VSL_CD        = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND VP.SKD_VOY_NO    = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND VP.SKD_DIR_CD    = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("           AND VP.YD_CD         = @[yd_cd]" ).append("\n"); 
		query.append("           AND VP.CLPT_IND_SEQ  = @[clpt_ind_seq]" ).append("\n"); 
		query.append("           AND NVL(VP.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("           AND NVL(VP.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("         GROUP BY VP.VSL_CD" ).append("\n"); 
		query.append("                , VP.VPS_PORT_CD   " ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD    LIKE 'TW%'" ).append("\n"); 
		query.append("   AND TO_DATE(TO_CHAR(VPS_ETB_DT, 'YYYYMMDD'), 'YYYYMMDD')+120 >= B.MAX_VPS_ETB_DT" ).append("\n"); 
		query.append("   AND A.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("   AND NVL(A.VT_ADD_CALL_FLG, 'N')  = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("   AND NVL(A.SKD_CNG_STS_CD,' ')    <> 'S'" ).append("\n"); 

	}
}