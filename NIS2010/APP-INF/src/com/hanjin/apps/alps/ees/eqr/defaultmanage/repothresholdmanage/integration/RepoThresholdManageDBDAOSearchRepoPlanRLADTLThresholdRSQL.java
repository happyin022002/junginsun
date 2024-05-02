/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOSearchRepoPlanRLADTLThresholdRSQL.java
*@FileTitle : Red Light Alert 기준 조회/수정---컨테이너 이송 계획
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.17 
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

public class RepoThresholdManageDBDAOSearchRepoPlanRLADTLThresholdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_PLN_RED_LGT_ALT_DTL테이블의 데이터 조회
	  * </pre>
	  */
	public RepoThresholdManageDBDAOSearchRepoPlanRLADTLThresholdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("B.ITEM" ).append("\n"); 
		query.append(",A.ADHR_BSE_CD" ).append("\n"); 
		query.append("#foreach( $key in ${tpszarr})" ).append("\n"); 
		query.append(",MAX(DECODE(A.CNTR_TPSZ_CD, '$key', A.ADHR_RTO))		${key}ADHR_RTO" ).append("\n"); 
		query.append(",MAX(DECODE(A.CNTR_TPSZ_CD, '$key', A.ADHR_VOL_QTY))	${key}ADHR_VOL_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",B.RCC_CD RCC_CD1" ).append("\n"); 
		query.append(",B.ITEMCODE ADHR_ITM_CD" ).append("\n"); 
		query.append(",B.RCCNUM" ).append("\n"); 
		query.append(",B.ITEMNUM" ).append("\n"); 
		query.append("FROM EQR_REPO_PLN_RED_LGT_ALT_DTL A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.RCC_CD" ).append("\n"); 
		query.append(",B.ITEM" ).append("\n"); 
		query.append(",B.ITEMCODE" ).append("\n"); 
		query.append(",A.NUM RCCNUM" ).append("\n"); 
		query.append(",B.NUM ITEMNUM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- RCC CODE" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_DESC RCC_CD" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_SEQ  NUM" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00255'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- ITEM CODE" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_CTNT    ITEMCODE" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_DESC ITEM" ).append("\n"); 
		query.append(",INTG_CD_VAL_DP_SEQ  NUM" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00565'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("ORDER BY RCCNUM, ITEMNUM" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.ADHR_ITM_CD(+) = B.ITEMCODE" ).append("\n"); 
		query.append("AND   A.RCC_CD(+)      = B.RCC_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("B.RCC_CD" ).append("\n"); 
		query.append(",B.ITEMCODE" ).append("\n"); 
		query.append(",B.ITEM" ).append("\n"); 
		query.append(",A.ADHR_BSE_CD" ).append("\n"); 
		query.append(",B.RCCNUM" ).append("\n"); 
		query.append(",B.ITEMNUM" ).append("\n"); 
		query.append("ORDER BY B.RCCNUM, B.ITEMNUM" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOSearchRepoPlanRLADTLThresholdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}