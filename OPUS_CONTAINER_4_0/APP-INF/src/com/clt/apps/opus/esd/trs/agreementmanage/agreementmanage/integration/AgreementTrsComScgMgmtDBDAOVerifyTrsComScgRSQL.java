/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementTrsComScgMgmtDBDAOVerifyTrsComScgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.15 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsComScgMgmtDBDAOVerifyTrsComScgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Surcharge Verify
	  * </pre>
	  */
	public AgreementTrsComScgMgmtDBDAOVerifyTrsComScgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementTrsComScgMgmtDBDAOVerifyTrsComScgRSQL").append("\n"); 
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
		query.append("SELECT ROW_NO" ).append("\n"); 
		query.append("      ,DB_DUP --DB에 동일한 자료가 있는지 체크" ).append("\n"); 
		query.append("      ,TRSP_TMP_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                ROW_NO" ).append("\n"); 
		query.append("               ,TRSP_TMP_SEQ" ).append("\n"); 
		query.append("               ,(SELECT 'DUP'" ).append("\n"); 
		query.append("                  FROM TRS_COM_SCG_MGMT   E" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND E.COM_SCG_KND_CD                = T.COM_SCG_KND_CD" ).append("\n"); 
		query.append("                   AND E.TRSP_COST_MOD_CD              = T.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("                   AND E.AGMT_TRSP_TP_CD               = T.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("                   AND NVL(E.RCC_CD, 'X')              = NVL(T.RCC_CD, 'X')" ).append("\n"); 
		query.append("                   AND NVL(E.LCC_CD, 'X')              = NVL(T.LCC_CD, 'X')" ).append("\n"); 
		query.append("                   AND NVL(E.SCC_CD, 'X')              = NVL(T.SCC_CD, 'X')" ).append("\n"); 
		query.append("                   AND E.EQ_KND_CD                     = T.EQ_KND_CD" ).append("\n"); 
		query.append("                   AND E.EQ_TPSZ_CD                    = T.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                   AND NVL(E.CGO_TP_CD, 'X')           = NVL(T.CGO_TP_CD, 'X')" ).append("\n"); 
		query.append("                   AND NVL(E.BND_CD, 'X')              = NVL(T.BND_CD, 'X')" ).append("\n"); 
		query.append("                   AND E.COM_SCG_SEQ                  <> NVL(T.COM_SCG_SEQ, 0)" ).append("\n"); 
		query.append("                   AND (   (E.EFF_TO_DT BETWEEN T.EFF_FM_DT AND T.EFF_TO_DT) OR (E.EFF_FM_DT BETWEEN T.EFF_FM_DT AND T.EFF_TO_DT)" ).append("\n"); 
		query.append("                        OR (T.EFF_TO_DT BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT) OR (T.EFF_FM_DT BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT)) " ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) DB_DUP" ).append("\n"); 
		query.append("           FROM TRS_COM_SCG_MGMT_TMP T" ).append("\n"); 
		query.append("          WHERE T.TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE DB_DUP IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY ROW_NO" ).append("\n"); 

	}
}