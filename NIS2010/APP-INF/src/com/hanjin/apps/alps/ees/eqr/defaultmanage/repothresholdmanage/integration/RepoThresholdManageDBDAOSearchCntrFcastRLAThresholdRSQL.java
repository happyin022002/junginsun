/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOSearchCntrFcastRLAThresholdRSQL.java
*@FileTitle : Red Light Alert 기준 조회/수정---컨테이너 수급 예측
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoThresholdManageDBDAOSearchCntrFcastRLAThresholdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_OB_FCAST_RED_LGT_ALT 테이블에서 데이터 조회
	  * </pre>
	  */
	public RepoThresholdManageDBDAOSearchCntrFcastRLAThresholdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT" ).append("\n"); 
		query.append("RCC RCC_CD" ).append("\n"); 
		query.append(",TYPE1_DESC" ).append("\n"); 
		query.append(",TYPE2" ).append("\n"); 
		query.append(",DECODE(" ).append("\n"); 
		query.append("TYPE2NUM, 1, ROUND(SUM(RLA)/" ).append("\n"); 
		query.append("DECODE((" ).append("\n"); 
		query.append("#foreach( $key in ${tpszarr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("DECODE(MAX(DECODE(TPSZ, '$key', RLA)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ DECODE(MAX(DECODE(TPSZ, '$key', RLA)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), 0, 1," ).append("\n"); 
		query.append("#foreach( $key in ${tpszarr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("DECODE(MAX(DECODE(TPSZ, '$key', RLA)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ DECODE(MAX(DECODE(TPSZ, '$key', RLA)), NULL, 0, 0, 0, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", 2), 2, SUM(RLA)" ).append("\n"); 
		query.append(") TOTAL" ).append("\n"); 
		query.append("#foreach( $key in ${tpszarr})" ).append("\n"); 
		query.append(",MAX(DECODE(TPSZ, '$key', RLA))  ${key}RLA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",TYPE1_CODE RLA_TP_CD" ).append("\n"); 
		query.append(",RCCNUM" ).append("\n"); 
		query.append(",TYPE1NUM" ).append("\n"); 
		query.append(",TYPE2NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.RCC RCC" ).append("\n"); 
		query.append(",A.TYPE1_CODE TYPE1_CODE" ).append("\n"); 
		query.append(",A.TYPE1_DESC TYPE1_DESC" ).append("\n"); 
		query.append(",A.TYPE2 TYPE2" ).append("\n"); 
		query.append(",NVL(DECODE(A.TYPE2, 'Ratio', B.RLA_RTO, 'Qty', B.RLA_QTY), 0) RLA" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD TPSZ" ).append("\n"); 
		query.append(",A.RCCNUM" ).append("\n"); 
		query.append(",A.TYPE1NUM" ).append("\n"); 
		query.append(",A.TYPE2NUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.INTG_CD_VAL_DP_DESC RCC" ).append("\n"); 
		query.append(",B.INTG_CD_VAL_CTNT    TYPE1_CODE" ).append("\n"); 
		query.append(",B.INTG_CD_VAL_DP_DESC TYPE1_DESC" ).append("\n"); 
		query.append(",C.PARAM               TYPE2" ).append("\n"); 
		query.append(",A.INTG_CD_VAL_DP_SEQ  RCCNUM" ).append("\n"); 
		query.append(",B.NUM                 TYPE1NUM" ).append("\n"); 
		query.append(",C.NUM                 TYPE2NUM" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_CTNT," ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC," ).append("\n"); 
		query.append("ROWNUM NUM" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   INTG_CD_ID = 'CD00256'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'Ratio' PARAM, 1 NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'Qty'   PARAM, 2 NUM FROM DUAL" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   A.INTG_CD_ID = 'CD00255'" ).append("\n"); 
		query.append("ORDER BY A.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("B.NUM," ).append("\n"); 
		query.append("C.NUM" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("EQR_OB_FCAST_RED_LGT_ALT B" ).append("\n"); 
		query.append("WHERE A.RCC        = B.RCC_CD(+)" ).append("\n"); 
		query.append("AND   A.TYPE1_CODE = B.RLA_TP_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("RCC" ).append("\n"); 
		query.append(",TYPE1_CODE" ).append("\n"); 
		query.append(",TYPE1_DESC" ).append("\n"); 
		query.append(",TYPE2" ).append("\n"); 
		query.append(",RCCNUM" ).append("\n"); 
		query.append(",TYPE1NUM" ).append("\n"); 
		query.append(",TYPE2NUM" ).append("\n"); 
		query.append("ORDER BY RCCNUM, TYPE1NUM, TYPE2NUM" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOSearchCntrFcastRLAThresholdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}