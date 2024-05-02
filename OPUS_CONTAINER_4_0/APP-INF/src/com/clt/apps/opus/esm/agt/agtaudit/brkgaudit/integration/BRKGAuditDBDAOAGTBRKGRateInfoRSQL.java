/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOAGTBRKGRateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOAGTBRKGRateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (ESM_AGT_014) 실제로 Commission 계산한 Brokerage Agreement 요율 정보 조회
	  * </pre>
	  */
	public BRKGAuditDBDAOAGTBRKGRateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brog_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOAGTBRKGRateInfoRSQL").append("\n"); 
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
		query.append("A.BROG_CNT_CD||TO_CHAR(A.BROG_CUST_SEQ, 'FM000000') AS BROG_CNT_CUST_SEQ," ).append("\n"); 
		query.append("DECODE(	TO_CHAR(A.BROG_CUST_SEQ, 'FM000000')," ).append("\n"); 
		query.append("'999999', 'All customer	for	General	Rate Case','888888', 'All customer for Special Rate	Case'," ).append("\n"); 
		query.append("'777777', 'All customer	for	Canadian Special Rate Case'," ).append("\n"); 
		query.append("NVL(REPLACE(REPLACE(REPLACE(B.CUST_LGL_ENG_NM, '&',	'&amp;'), CHR(13)||CHR(10),	''), CHR(9),''), '')) AS BROG_CNT_CUST_NM," ).append("\n"); 
		query.append("NVL(DECODE(	A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000')," ).append("\n"); 
		query.append("'*000000', '*',A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000')),	'*') AS SHPR_CNT_SEQ," ).append("\n"); 
		query.append("NVL(REPLACE(REPLACE(REPLACE(C.CUST_LGL_ENG_NM, '&',	'&amp;'), CHR(13)||CHR(10),	''), CHR(9),''), '') AS SHPR_CNT_NM," ).append("\n"); 
		query.append("NVL	(A.POR_GRP_TP_CD, '*') AS POR_GRP_TP_CD," ).append("\n"); 
		query.append("NVL	(A.POR_ROUT_CD,	'*') AS POR_ROUT_CD," ).append("\n"); 
		query.append("NVL	(A.POL_GRP_TP_CD, '*') AS POL_GRP_TP_CD," ).append("\n"); 
		query.append("NVL	(A.POL_ROUT_CD,	'*') AS POL_ROUT_CD," ).append("\n"); 
		query.append("NVL	(A.POD_GRP_TP_CD, '*') AS POD_GRP_TP_CD," ).append("\n"); 
		query.append("NVL	(A.POD_ROUT_CD,	'*') AS POD_ROUT_CD," ).append("\n"); 
		query.append("NVL	(A.FM_EFF_DT, '20000101') AS FM_EFF_DT," ).append("\n"); 
		query.append("NVL	(A.TO_EFF_DT, '29991231') AS TO_EFF_DT," ).append("\n"); 
		query.append("NVL(A.SC_NO, '*') AS SC_NO," ).append("\n"); 
		query.append("NVL(A.RFA_NO, '*') AS RFA_NO," ).append("\n"); 
		query.append("NVL	(A.CMDT_TP_CD, '*')	AS CMDT_TP_CD," ).append("\n"); 
		query.append("NVL	(A.CMDT_CD,	'*') AS CMDT_CD," ).append("\n"); 
		query.append("DECODE (A.CMDT_TP_CD, '2', D.REP_CMDT_NM, '3', E.CMDT_NM) AS CMDT_NM," ).append("\n"); 
		query.append("NVL	(A.BROG_DIV_CD,	'') AS BROG_DIV_CD," ).append("\n"); 
		query.append("NVL	(A.BKG_BROG_RT,	0) BKG_BROG_RT,	NVL	(A.BROG_BX_RT, 0) AS BROG_BX_RT," ).append("\n"); 
		query.append("NVL	(A.BROG_TEU_RT,	0) BROG_TEU_RT,	NVL	(A.BROG_FEU_RT,	0) ASBROG_FEU_RT," ).append("\n"); 
		query.append("NVL	(A.BROG_RF_RT, 0) AS BROG_RF_RT," ).append("\n"); 
		query.append("NVL	(A.BROG_CHG_CTNT, '') AS BROG_CHG_CTNT," ).append("\n"); 
		query.append("NVL	(A.BROG_KND_CD,	'F') AS BROG_KND_CD" ).append("\n"); 
		query.append("FROM AGT_BROG_AGMT_RT A, MDM_CUSTOMER B, MDM_CUSTOMER C," ).append("\n"); 
		query.append("MDM_REP_CMDT D,	MDM_COMMODITY E" ).append("\n"); 
		query.append("WHERE A.BROG_CNT_CD	= B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND	A.BROG_CUST_SEQ	= B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND	A.SHPR_CNT_CD =	C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND	A.SHPR_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND	A.CMDT_CD =	D.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND	A.CMDT_CD =	E.CMDT_CD(+)" ).append("\n"); 
		query.append("AND	A.BROG_CNT_CD =	@[brog_cnt_cd]" ).append("\n"); 
		query.append("AND	A.BROG_CUST_SEQ	= @[brog_cust_seq]" ).append("\n"); 
		query.append("AND	A.BROG_RT_SEQ =	@[brog_rt_seq]" ).append("\n"); 

	}
}