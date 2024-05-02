/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchChargeDeletionContainerMovementOcDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchChargeDeletionContainerMovementOcDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM_MOVEMENT 테이블에서 OC 시점의 DATE를 조회
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchChargeDeletionContainerMovementOcDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchChargeDeletionContainerMovementOcDtRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(AA XUK1CTM_MOVEMENT) */ TO_CHAR(AA.CNMV_EVNT_DT, 'YYYYMMDD') OC_DT" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT AA" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND AA.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND AA.MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("   AND AA.CNMV_YR||TO_CHAR(AA.CNMV_SEQ, 'FM0000')||AA.CNMV_SPLIT_NO <= (SELECT /*+ INDEX_DESC(A XUK1CTM_MOVEMENT) */A.CNMV_YR||TO_CHAR(A.CNMV_SEQ, 'FM0000')||A.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           AND ROWNUM = 1 )" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}