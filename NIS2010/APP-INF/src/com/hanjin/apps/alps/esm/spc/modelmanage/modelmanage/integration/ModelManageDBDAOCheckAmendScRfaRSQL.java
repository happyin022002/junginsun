/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOCheckAmendScRfaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOCheckAmendScRfaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 S/C, RFA 가 유효 한지 확인합니다.
	  * 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2015.02.06 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
	  * 2015.02.09 박은주 [CHM-201534243] SMP RFA amend 건
	  *                            PRI와 비교하는 기준이 상이하여 유효한 계약임에도 불구하고 유효하지 않은것으로 처리하고 있음
	  * 2015.12.29 이혜민 선반영 SMP 저장로직 변경 및 입력 날짜 기준 +30일(한달) 내 effective date를 보유한 RFA/SC시 import 가능토록 변경
	  * </pre>
	  */
	public ModelManageDBDAOCheckAmendScRfaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOCheckAmendScRfaRSQL").append("\n"); 
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
		query.append("SELECT SUM(CNT)" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("            FROM PRI_RP_HDR   HDR" ).append("\n"); 
		query.append("               , PRI_RP_MN    MN" ).append("\n"); 
		query.append("               , MDM_CUSTOMER I" ).append("\n"); 
		query.append("           WHERE HDR.PROP_NO         = MN.PROP_NO" ).append("\n"); 
		query.append("             AND MN.PROP_STS_CD      = 'A'" ).append("\n"); 
		query.append("#if (${trade} == 'AES')" ).append("\n"); 
		query.append("             AND MN.RFA_CTRT_TP_CD   = 'C' -- AES 에서는 Contract 화주만 IAS는 상관없이 모든 화주에 대해서" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             AND I.CUST_CNT_CD       = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("             AND I.CUST_SEQ          = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("             AND I.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("             AND MN.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("             AND MN.CTRT_CUST_SEQ    = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("             AND HDR.RFA_NO         IN (@[rfa_no], @[sc_no])" ).append("\n"); 
		query.append("             AND MN.AMDT_SEQ         = ( SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                           FROM PRI_RP_MN K" ).append("\n"); 
		query.append("                                          WHERE K.PROP_NO     = MN.PROP_NO" ).append("\n"); 
		query.append("                                            AND K.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                            AND (TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT))" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT COUNT(1) AS CNT" ).append("\n"); 
		query.append("            FROM PRI_SP_MN       M" ).append("\n"); 
		query.append("               , PRI_SP_CTRT_PTY D" ).append("\n"); 
		query.append("               , PRI_SP_HDR      H" ).append("\n"); 
		query.append("               , MDM_CUSTOMER    I" ).append("\n"); 
		query.append("           WHERE M.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("             AND M.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("             AND M.AMDT_SEQ           = D.AMDT_SEQ" ).append("\n"); 
		query.append("             AND H.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("             AND I.CUST_CNT_CD        = D.CUST_CNT_CD" ).append("\n"); 
		query.append("             AND I.CUST_SEQ           = D.CUST_SEQ" ).append("\n"); 
		query.append("             AND D.CUST_CNT_CD        = SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("             AND D.CUST_SEQ           = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("             AND H.SC_NO             IN (@[rfa_no], @[sc_no])" ).append("\n"); 
		query.append("             AND I.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("             AND D.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("             AND M.AMDT_SEQ           = ( SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                            FROM PRI_SP_MN K" ).append("\n"); 
		query.append("                                           WHERE K.PROP_NO     = M.PROP_NO" ).append("\n"); 
		query.append("                                             AND K.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                             AND (TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT))" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}