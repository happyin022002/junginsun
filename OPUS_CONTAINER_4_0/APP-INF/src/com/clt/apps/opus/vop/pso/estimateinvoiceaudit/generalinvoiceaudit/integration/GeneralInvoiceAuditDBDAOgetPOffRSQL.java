/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetPOffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
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

public class GeneralInvoiceAuditDBDAOgetPOffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tariff 비용 계산을 위해 Pilot Off를 구한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetPOffRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOgetPOffRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(NVL(B.PLT_LST_UNLD_DT, T.PILOT_DEP),'HH24MI')" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("     , VSK_ACT_PORT_SKD B" ).append("\n"); 
		query.append("     , TDR_HEADER T" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.VSL_CD         = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO     = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD     = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD    = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("   AND A.YD_CD          = @[yd_cd] /*2016.04.06 Add*/" ).append("\n"); 
		query.append("   AND A.CLPT_IND_SEQ   = @[clpt_ind_seq] /*2016.04.06 Add*/" ).append("\n"); 
		query.append("   AND NVL(A.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ " ).append("\n"); 
		query.append("   AND NVL(A.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("   AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD    = B.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND A.CLPT_IND_SEQ   = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND B.VSL_CD         = T.VSL_CD(+)" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO     = T.VOY_NO(+)" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD     = T.DIR_CD(+)" ).append("\n"); 
		query.append("   AND B.VPS_PORT_CD    = T.PORT_CD(+)" ).append("\n"); 
		query.append("   AND B.CLPT_IND_SEQ   = T.CALL_IND(+)" ).append("\n"); 

	}
}