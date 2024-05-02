/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchSakuraConversionInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchSakuraConversionInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSakuraConversionInfo
	  * </pre>
	  */
	public StatementCommonDBDAOSearchSakuraConversionInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("enbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchSakuraConversionInfoRSQL").append("\n"); 
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
		query.append("SELECT  SLD.LU_CD             AS SRC_CD" ).append("\n"); 
		query.append("    ,   SLD.LU_DESC           AS SRC_DESC" ).append("\n"); 
		query.append("    ,   SSCC.TGT_CD           AS TGT_CD" ).append("\n"); 
		query.append("    ,   SSCC.TGT_DESC         AS TGT_DESC" ).append("\n"); 
		query.append("    ,   NVL(DECODE(USE_FLG, 'Y', '1', 'N', '0'), '1') AS USE_FLG" ).append("\n"); 
		query.append("    ,   SLD.LU_TP_CD          AS CONV_TP_CD" ).append("\n"); 
		query.append("FROM    SCO_LU_HDR         SLH" ).append("\n"); 
		query.append("    ,   SCO_LU_DTL         SLD" ).append("\n"); 
		query.append("    ,   SCO_STMT_CD_CONV   SSCC" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("  AND   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("  AND   SLH.CD_CONV_ND_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${lu_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("  AND   SLD.LU_TP_CD = @[lu_tp_cd]  --Selected Converion Type ComboBox Value" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND   SLD.LU_TP_CD = SSCC.CONV_TP_CD(+)" ).append("\n"); 
		query.append("  AND   SLD.LU_CD = SSCC.SRC_CD(+)" ).append("\n"); 
		query.append("  AND   SLD.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("  AND   SSCC.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("  AND   NVL(SSCC.USE_FLG, 'Y')  = @[enbl_flg] --Selected use Flag ComboBox Value" ).append("\n"); 
		query.append("ORDER BY SLH.LU_TP_CD, LU_CD" ).append("\n"); 

	}
}