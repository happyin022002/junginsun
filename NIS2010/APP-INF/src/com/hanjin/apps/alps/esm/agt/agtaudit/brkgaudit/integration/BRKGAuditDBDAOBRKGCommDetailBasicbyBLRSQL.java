/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOBRKGCommDetailBasicbyBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOBRKGCommDetailBasicbyBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (ESM_AGT_014) Brokerage Commission의 Basic 정보 조회
	  * </pre>
	  */
	public BRKGAuditDBDAOBRKGCommDetailBasicbyBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOBRKGCommDetailBasicbyBLRSQL").append("\n"); 
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
		query.append("TO_CHAR(B.VSL_DEP_DT, 'YYYY-MM-DD') AS VSL_DEP_DT," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("NVL(A.BL_NO,'') AS BL_NO," ).append("\n"); 
		query.append("A.SHPR_CNT_CD||TRIM(TO_CHAR(A.SHPR_SEQ,'000000')) AS SHPR_CNT_SEQ," ).append("\n"); 
		query.append("NVL(LTRIM(C.CUST_LGL_ENG_NM),'') AS SHPR_NM," ).append("\n"); 
		query.append("DECODE(B.FRT_FWRD_CNT_CD,'*','',B.FRT_FWRD_CNT_CD||TRIM(TO_CHAR(B.FRT_FWRD_SEQ,'000000'))) AS FRT_FWRD_CNT_SEQ," ).append("\n"); 
		query.append("B.VNDR_CNT_CD||TRIM(TO_CHAR(B.VNDR_SEQ,'000000')) AS VNDR_CNT_SEQ," ).append("\n"); 
		query.append("NVL(LTRIM(D.CUST_LGL_ENG_NM),'') AS FRT_FWRD_NM," ).append("\n"); 
		query.append("B.COMM_VSL_CD||B.COMM_SKD_VOY_NO||B.COMM_SKD_DIR_CD	AS COMM_VSL," ).append("\n"); 
		query.append("A.BKG_POR_CD AS BKG_POR_CD," ).append("\n"); 
		query.append("A.BKG_POL_CD AS BKG_POL_CD," ).append("\n"); 
		query.append("A.BKG_POD_CD AS BKG_POD_CD," ).append("\n"); 
		query.append("A.BKG_DEL_CD AS BKG_DEL_CD," ).append("\n"); 
		query.append("B.BROG_REF_NO AS BROG_REF_NO," ).append("\n"); 
		query.append("A.FMC_NO AS FMC_NO," ).append("\n"); 
		query.append("A.SC_NO AS SC_NO," ).append("\n"); 
		query.append("A.RFA_NO AS RFA_NO," ).append("\n"); 
		query.append("B.BROG_KND_CD AS BROG_KND_CD" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO A, AGT_BROG_COMM	B, MDM_CUSTOMER	C, MDM_CUSTOMER	D" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND	B.CRE_USR_ID !=	'COST'" ).append("\n"); 
		query.append("AND	A.SHPR_CNT_CD =	C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND	A.SHPR_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND	A.FRT_FWRD_CNT_CD =	D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND	A.FRT_FWRD_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND	A.BL_NO	= @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND	A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}