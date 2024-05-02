/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAOPriTriMnVOAssignTriNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.08 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOPriTriMnVOAssignTriNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_TRI_MN TRI No. Assign
	  * </pre>
	  */
	public TRIProposalDBDAOPriTriMnVOAssignTriNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOPriTriMnVOAssignTriNoUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRI_MN" ).append("\n"); 
		query.append("SET TRI_NO = (" ).append("\n"); 
		query.append("WITH T AS (" ).append("\n"); 
		query.append("SELECT T0.TRI_PROP_NO" ).append("\n"); 
		query.append(",T0.CMDT_CD" ).append("\n"); 
		query.append(",T0.TRI_NO" ).append("\n"); 
		query.append(",SUBSTR(T0.TRI_NO, 1, 10) AS ROUT_TRI_NO" ).append("\n"); 
		query.append(",T1.ROUT_KEY || '*' || T2.ROUT_KEY AS ROUT_KEY" ).append("\n"); 
		query.append(",LPAD(MAX(SUBSTR(T0.TRI_NO, 1, 10)) OVER(PARTITION BY T0.TRF_PFX_CD, T0.TRF_NO, T0.CMDT_CD) + 1, 10, '0') AS NEXT_ROUT_NO" ).append("\n"); 
		query.append(",LPAD(MAX(T0.TRI_NO) OVER(PARTITION BY T0.TRF_PFX_CD, T0.TRF_NO, T0.CMDT_CD, SUBSTR(T0.TRI_NO, 1, 10)) + 1, 13, '0') AS NEXT_RATE_NO" ).append("\n"); 
		query.append("FROM PRI_TRI_MN T0" ).append("\n"); 
		query.append(",(SELECT TRI_PROP_NO" ).append("\n"); 
		query.append(",MAX(SYS_CONNECT_BY_PATH(ORG_DEST_TP_CD || ROUT_PNT_LOC_CD || RCV_DE_TERM_CD || PRC_TRSP_MOD_CD, '|')) AS ROUT_KEY" ).append("\n"); 
		query.append("FROM (SELECT B.TRI_PROP_NO" ).append("\n"); 
		query.append(",B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",B.ROUT_PNT_LOC_CD" ).append("\n"); 
		query.append(",B.RCV_DE_TERM_CD" ).append("\n"); 
		query.append(",B.PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY B.TRI_PROP_NO ORDER BY B.TRI_PROP_NO, B.ORG_DEST_TP_CD, B.ROUT_PNT_LOC_CD, B.RCV_DE_TERM_CD, B.PRC_TRSP_MOD_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_MN A, PRI_TRI_RT_ROUT_PNT B" ).append("\n"); 
		query.append("WHERE A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND A.CMDT_CD = @[cmdt_cd])" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY TRI_PROP_NO) T1" ).append("\n"); 
		query.append(",(SELECT TRI_PROP_NO, MAX(SYS_CONNECT_BY_PATH(ORG_DEST_TP_CD || ROUT_VIA_PORT_CD, '|')) AS ROUT_KEY" ).append("\n"); 
		query.append("FROM (SELECT B.TRI_PROP_NO" ).append("\n"); 
		query.append(",B.ORG_DEST_TP_CD" ).append("\n"); 
		query.append(",B.ROUT_VIA_PORT_CD" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY B.TRI_PROP_NO ORDER BY B.TRI_PROP_NO, B.ORG_DEST_TP_CD, B.ROUT_VIA_PORT_CD) AS RN" ).append("\n"); 
		query.append("FROM PRI_TRI_MN A, PRI_TRI_RT_ROUT_VIA B" ).append("\n"); 
		query.append("WHERE A.TRI_PROP_NO = B.TRI_PROP_NO" ).append("\n"); 
		query.append("AND A.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND A.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND A.CMDT_CD = @[cmdt_cd])" ).append("\n"); 
		query.append("START WITH RN = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR TRI_PROP_NO = TRI_PROP_NO" ).append("\n"); 
		query.append("AND PRIOR RN = RN - 1" ).append("\n"); 
		query.append("GROUP BY TRI_PROP_NO) T2" ).append("\n"); 
		query.append("WHERE T0.TRI_PROP_NO = T1.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("AND T0.TRI_PROP_NO = T2.TRI_PROP_NO(+)" ).append("\n"); 
		query.append("AND T0.TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND T0.TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND T0.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT NVL((SELECT NEXT_RATE_NO" ).append("\n"); 
		query.append("FROM T" ).append("\n"); 
		query.append("WHERE ROUT_KEY = (SELECT ROUT_KEY FROM T WHERE TRI_PROP_NO = @[tri_prop_no])" ).append("\n"); 
		query.append("AND TRI_NO IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append(",NVL((SELECT NEXT_ROUT_NO FROM T WHERE ROWNUM = 1), @[cmdt_cd] || '0001') || '001')" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 

	}
}