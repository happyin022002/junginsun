/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCOPInfoPolDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.10.06 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCOPInfoPolDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOPInfoPolDt
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCOPInfoPolDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCOPInfoPolDtRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(E_T1, 'YYYYMMDDHH24MI') POL_ETA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T1, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T1, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ETA_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T1, 'YYYYMMDDHH24MI') POL_ATA," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T1, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T1, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ATA_GMT ," ).append("\n"); 
		query.append("TO_CHAR(E_T2, 'YYYYMMDDHH24MI') POL_ETD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(E_T2, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, E_T2, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ETD_GMT ," ).append("\n"); 
		query.append("TO_CHAR(A_T2, 'YYYYMMDDHH24MI') POL_ATD," ).append("\n"); 
		query.append("DECODE(NOD, NULL, '', DECODE(A_T2, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NOD, A_T2, 'GMT'), 'YYYYMMDDHH24MI'))) POL_ATD_GMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.BEF_ESTM_DT E_T1 ," ).append("\n"); 
		query.append("CASE WHEN A.BEF_ACT_DT IS NULL" ).append("\n"); 
		query.append("AND A.BEF_COP_STS = 'F' THEN A.BEF_ESTM_DT ELSE A.BEF_ACT_DT END A_T1 ," ).append("\n"); 
		query.append("A.AFT_ESTM_DT E_T2 ," ).append("\n"); 
		query.append("CASE WHEN A.AFT_ACT_CD IS NULL" ).append("\n"); 
		query.append("AND A.AFT_COP_STS = 'F' THEN A.AFT_ESTM_DT ELSE A.AFT_ACT_CD END A_T2 ," ).append("\n"); 
		query.append("NVL(A.BEF_NOD_CD, A.AFT_NOD_CD) AS NOD --CFS Term 경우에 GMT로 변환기준이 되는Node 를 aft_nod_cd 로 찾음" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BEF_ESTM_DT," ).append("\n"); 
		query.append("BEF_ACT_DT," ).append("\n"); 
		query.append("BEF_NOD_CD," ).append("\n"); 
		query.append("BEF_COP_STS," ).append("\n"); 
		query.append("AFT_ESTM_DT," ).append("\n"); 
		query.append("AFT_ACT_CD," ).append("\n"); 
		query.append("AFT_NOD_CD," ).append("\n"); 
		query.append("AFT_COP_STS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT STND_EDI_STS_CD," ).append("\n"); 
		query.append("D.ESTM_DT ," ).append("\n"); 
		query.append("LAG(D.ESTM_DT, 1) --  POL TEMINAL ARRIVAL" ).append("\n"); 
		query.append("OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_ESTM_DT ," ).append("\n"); 
		query.append("LAG(D.ACT_DT, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_ACT_DT ," ).append("\n"); 
		query.append("LAG(SUBSTR(D.NOD_CD, 1, 5), 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_NOD_CD ," ).append("\n"); 
		query.append("LAG(D.ACT_STS_CD, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) BEF_COP_STS ," ).append("\n"); 
		query.append("LEAD(D.ESTM_DT, 1) -- POL VESSLE DEPARTURE" ).append("\n"); 
		query.append("OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_ESTM_DT ," ).append("\n"); 
		query.append("LEAD(D.ACT_DT, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_ACT_CD ," ).append("\n"); 
		query.append("LEAD(SUBSTR(D.NOD_CD, 1, 5), 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_NOD_CD ," ).append("\n"); 
		query.append("LEAD(D.ACT_STS_CD, 1) OVER (PARTITION BY D.COP_NO" ).append("\n"); 
		query.append("ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_COP_STS" ).append("\n"); 
		query.append("FROM SCE_COP_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE STND_EDI_STS_CD = 'AEL' ) A )" ).append("\n"); 

	}
}