/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableAgreementAvailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.01.04 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableAgreementAvailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력받은 AGMT No.에 대한 유효성 여부를 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableAgreementAvailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableAgreementAvailRSQL").append("\n"); 
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
		query.append("SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("TO_CHAR(A.LST_EFF_DT, 'YYYYMMDD') AS EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(A.LST_EXP_DT, 'YYYYMMDD') AS EXP_DT," ).append("\n"); 
		query.append("A.VNDR_SEQ, C.VNDR_ABBR_NM, A.LSTM_CD, A.REF_NO," ).append("\n"); 
		query.append("P.COST_YRMON, D.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("FROM   (SELECT  'HHO'         AS AGMT_CTY_CD," ).append("\n"); 
		query.append("@[agmt_seq]   AS AGMT_SEQ," ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(TO_DATE(@[qty_yrmon]," ).append("\n"); 
		query.append("'RRRRMM'), 1), 'RRRRMM') AS COST_YRMON" ).append("\n"); 
		query.append("FROM    DUAL) P," ).append("\n"); 
		query.append("LSE_AGREEMENT A," ).append("\n"); 
		query.append("LSE_AGMT_VER B," ).append("\n"); 
		query.append("MDM_VENDOR C," ).append("\n"); 
		query.append("LSE_RCV_RNTL_CHG D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND     P.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     P.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND     P.AGMT_CTY_CD = D.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND     P.AGMT_SEQ = D.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND     P.COST_YRMON = D.COST_YRMON(+)" ).append("\n"); 
		query.append("AND     A.ITCHG_FEE_FLG <> 'Y'" ).append("\n"); 
		query.append("AND     B.AGMT_VER_SEQ = 1" ).append("\n"); 
		query.append("AND     A.LSTM_CD IN ('SO','MO')" ).append("\n"); 

	}
}