/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualAdjustmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualAdjustmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조정계수을 조회한다.
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualAdjustmentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualAdjustmentListRSQL").append("\n"); 
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
		query.append("#if (${date_sts} == '0')" ).append("\n"); 
		query.append("SELECT  B.SEQ, " ).append("\n"); 
		query.append("		SUBSTR(B.EXE_YRMON,1,4) || '-' || SUBSTR(B.EXE_YRMON,5,2) AS EXE_YRMON, " ).append("\n"); 
		query.append("		SUBSTR(B.REV_YRMON,1,4) || '-' || SUBSTR(B.REV_YRMON,5,2) AS REV_YRMON, " ).append("\n"); 
		query.append("		B.ACCL_LGC_TP_CD, " ).append("\n"); 
		query.append("--        RTRIM(TO_CHAR(NVL(A.ACCL_ADJ_FCTR_RT,0), 'FM9990.0000000000'), '.') AS ACCL_ADJ_FCTR_RT," ).append("\n"); 
		query.append("        NVL(A.ACCL_ADJ_FCTR_RT,0) AS ACCL_ADJ_FCTR_RT," ).append("\n"); 
		query.append("		A.ACCL_ADJ_FCTR_CFM_FLG, " ).append("\n"); 
		query.append("		A.ACCL_ADJ_FCTR_APLY_PROC_CD, " ).append("\n"); 
		query.append("		A.ACCL_ADJ_FCTR_APLY_ST_DT," ).append("\n"); 
		query.append("        A.ACCL_ADJ_FCTR_APLY_END_DT, " ).append("\n"); 
		query.append("		A.DELT_FLG," ).append("\n"); 
		query.append("        A.ACCL_ADJ_FCTR_FNL_FLG" ).append("\n"); 
		query.append("FROM LEA_ACCL_ADJ_FCTR A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LEVEL SEQ, TO_CHAR(TO_DATE(@[exe_yrmon], 'YYYY-MM'),'YYYYMM') AS EXE_YRMON, " ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(TO_DATE(@[exe_yrmon], 'YYYY-MM'),TRUNC((LEVEL-1)/6,0)*-1),'YYYYMM') AS REV_YRMON," ).append("\n"); 
		query.append("DECODE(MOD(LEVEL,6),1,'LB',2,'LO',3,'NB',4,'NO',5,'LC',0,'NC') AS ACCL_LGC_TP_CD FROM DUAL CONNECT BY LEVEL <=30" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.EXE_YRMON(+) = B.EXE_YRMON" ).append("\n"); 
		query.append("AND A.REV_YRMON(+) = B.REV_YRMON" ).append("\n"); 
		query.append("AND A.ACCL_LGC_TP_CD(+) = B.ACCL_LGC_TP_CD" ).append("\n"); 
		query.append("ORDER BY B.SEQ ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${date_sts} == '1')" ).append("\n"); 
		query.append("SELECT  B.SEQ," ).append("\n"); 
		query.append("SUBSTR(B.EXE_YRMON,1,4) || '-' || SUBSTR(B.EXE_YRMON,5,2) AS EXE_YRMON," ).append("\n"); 
		query.append("SUBSTR(B.REV_YRMON,1,4) || '-' || SUBSTR(B.REV_YRMON,5,2) AS REV_YRMON," ).append("\n"); 
		query.append("B.ACCL_LGC_TP_CD," ).append("\n"); 
		query.append("--        RTRIM(TO_CHAR(NVL(A.ACCL_ADJ_FCTR_RT,0), 'FM9990.0000000000'), '.') AS ACCL_ADJ_FCTR_RT," ).append("\n"); 
		query.append("NVL(A.ACCL_ADJ_FCTR_RT,0) AS ACCL_ADJ_FCTR_RT," ).append("\n"); 
		query.append("A.ACCL_ADJ_FCTR_CFM_FLG," ).append("\n"); 
		query.append("A.ACCL_ADJ_FCTR_APLY_PROC_CD," ).append("\n"); 
		query.append("A.ACCL_ADJ_FCTR_APLY_ST_DT," ).append("\n"); 
		query.append("A.ACCL_ADJ_FCTR_APLY_END_DT," ).append("\n"); 
		query.append("A.DELT_FLG," ).append("\n"); 
		query.append("A.ACCL_ADJ_FCTR_FNL_FLG" ).append("\n"); 
		query.append("FROM LEA_ACCL_ADJ_FCTR A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LEVEL SEQ, TO_CHAR(TO_DATE(@[exe_yrmon], 'YYYY-MM'),'YYYYMM') AS EXE_YRMON," ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(TO_DATE(@[exe_yrmon], 'YYYY-MM'),TRUNC((LEVEL-1)/6,0)*-1),'YYYYMM') AS REV_YRMON," ).append("\n"); 
		query.append("DECODE(MOD(LEVEL,6),1,'LB',2,'LO',3,'NB',4,'NO',5,'LC',0,'NC') AS ACCL_LGC_TP_CD FROM DUAL CONNECT BY LEVEL <=30" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT LEVEL+30 SEQ, TO_CHAR(TO_DATE(@[exe_yrmon], 'YYYY-MM'),'YYYYMM') AS EXE_YRMON," ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(TO_DATE(CONCAT(SUBSTR(@[exe_yrmon],1,5),'01'),'YYYY-MM'),TRUNC((LEVEL-1)/2,0)), 'YYYYMM') AS REV_YRMON," ).append("\n"); 
		query.append("DECODE(MOD(LEVEL,2),1,'LC',0,'NC') AS ACCL_LGC_TP_CD FROM DUAL CONNECT BY LEVEL <=(TO_NUMBER(SUBSTR(@[exe_yrmon],6,2))-5)*2" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.EXE_YRMON(+) = B.EXE_YRMON" ).append("\n"); 
		query.append("AND A.REV_YRMON(+) = B.REV_YRMON" ).append("\n"); 
		query.append("AND A.ACCL_LGC_TP_CD(+) = B.ACCL_LGC_TP_CD" ).append("\n"); 
		query.append("ORDER BY SUBSTR(B.REV_YRMON,1,4) || '-' || SUBSTR(B.REV_YRMON,5,2) DESC, B.SEQ ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}