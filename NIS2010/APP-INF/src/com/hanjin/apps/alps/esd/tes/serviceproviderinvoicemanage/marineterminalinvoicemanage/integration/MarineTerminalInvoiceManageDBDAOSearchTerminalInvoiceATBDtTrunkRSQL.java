/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceATBDtTrunk
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL").append("\n"); 
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
		query.append("SELECT	ATB_DT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT V.CLPT_IND_SEQ," ).append("\n"); 
		query.append("			   (SELECT DECODE(L.VSL_SVC_TP_CD,'O',DECODE((SELECT M.CRR_CD FROM MDM_VSL_CNTR M WHERE M.VSL_CD=S.VSL_CD),'SML','H','C'),'H')" ).append("\n"); 
		query.append("				FROM   VSK_VSL_SKD S, MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("				WHERE  S.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("				AND    S.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				AND    S.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("				AND    S.VSL_SLAN_CD = L.VSL_SLAN_CD(+) )|| '|'" ).append("\n"); 
		query.append("				-- CHM-201537358 ATB는 실제 ATB적용/ATB없을 경우 ETB적용  (2015-07-31 조아영D)" ).append("\n"); 
		query.append("				-- ||TO_CHAR(V.VPS_ETB_DT, 'YYYY-MM-DD')||'|'" ).append("\n"); 
		query.append("				|| TO_CHAR(NVL(P.ACT_BRTH_DT, NVL(LAG(P.ACT_BRTH_DT) OVER (PARTITION BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD ORDER BY V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, V.VPS_PORT_CD, V.CLPT_IND_SEQ), V.VPS_ETB_DT)), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("				|| '|' || A.REV_YRMON || '|' || V.YD_CD ATB_DT --//정미화K 요청 [CHM-201428898]" ).append("\n"); 
		query.append("		FROM	VSK_VSL_PORT_SKD V, AR_MST_REV_VVD A" ).append("\n"); 
		query.append("				, VSK_ACT_PORT_SKD P" ).append("\n"); 
		query.append("		WHERE  V.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("		AND    V.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		AND    V.SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("		AND    V.VPS_PORT_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("		AND    V.VSL_CD  	 = A.VSL_CD(+)" ).append("\n"); 
		query.append("		AND    V.SKD_VOY_NO  = A.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("		AND    V.SKD_DIR_CD  = A.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("		AND    V.VSL_CD  	 = P.VSL_CD(+)" ).append("\n"); 
		query.append("		AND    V.SKD_VOY_NO  = P.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("		AND    V.SKD_DIR_CD  = P.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("		AND    V.VPS_PORT_CD = P.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("		AND    V.CLPT_IND_SEQ= P.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("		AND    V.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("		AND    V.CALL_YD_IND_SEQ = @[call_yd_ind_seq]" ).append("\n"); 
		query.append("		--ORDER BY V.CLPT_IND_SEQ DESC" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("WHERE	ROWNUM	= 1" ).append("\n"); 

	}
}