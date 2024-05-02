/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OutstandinggroupManageDBDAOSearchTPBModificationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OutstandinggroupManageDBDAOSearchTPBModificationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPBModification
	  * </pre>
	  */
	public OutstandinggroupManageDBDAOSearchTPBModificationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.integration").append("\n"); 
		query.append("FileName : OutstandinggroupManageDBDAOSearchTPBModificationRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.OFC_CD,@[s_user_ofc_cd],DECODE(B.N3PTY_INV_NO,NULL,'Y','N'),'N') AS EDITABLE," ).append("\n"); 
		query.append("A.OTS_DTL_SEQ," ).append("\n"); 
		query.append("A.N3PTY_NO," ).append("\n"); 
		query.append("A.N3PTY_NO_DP_SEQ," ).append("\n"); 
		query.append("A.N3PTY_SRC_SUB_SYS_CD," ).append("\n"); 
		query.append("TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM," ).append("\n"); 
		query.append("A.N3PTY_SRC_NO AS N3PTY_SRC_NO_VISIBLE," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO_ALL," ).append("\n"); 
		query.append("A.BL_NO AS BL_NO_ALL," ).append("\n"); 
		query.append("DECODE(A.N3PTY_BIL_TP_CD,'JO',A.VVD_CD, A.VSL_CD || A.SKD_VOY_NO || SUBSTR(A.FINC_DIR_CD,1,1)) AS G_VVD," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("A.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("CASE A.VNDR_CUST_DIV_CD WHEN 'V' THEN LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')" ).append("\n"); 
		query.append("WHEN 'C' THEN A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("WHEN 'S' THEN A.N3PTY_OFC_CD END AS TRD_PARTY_VAL," ).append("\n"); 
		query.append("CASE WHEN C.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',B.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD)" ).append("\n"); 
		query.append("END AS OTS_STS_NM," ).append("\n"); 
		query.append("--DECODE(A.IF_CURR_CD,NULL,A.CFM_CURR_CD,A.IF_CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("A.CFM_CURR_CD CURR_CD," ).append("\n"); 
		query.append("A.CFM_AMT," ).append("\n"); 
		query.append("A.N3PTY_BIL_TP_CD," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.BL_NO," ).append("\n"); 
		query.append("A.VSL_CD," ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("A.FINC_DIR_CD," ).append("\n"); 
		query.append("A.VVD_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.CUST_CNT_CD," ).append("\n"); 
		query.append("A.CUST_SEQ," ).append("\n"); 
		query.append("A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A," ).append("\n"); 
		query.append("TPB_OTS_GRP B," ).append("\n"); 
		query.append("TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD != 'JO'" ).append("\n"); 
		query.append("--AND B.N3PTY_INV_NO IS NULL" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND B.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("ORDER BY N3PTY_NO, N3PTY_NO_DP_SEQ" ).append("\n"); 

	}
}