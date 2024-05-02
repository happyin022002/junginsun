/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOOutstandinggroupManageDBDAOSearchTPBGroupModifyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.03.30 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOutstandinggroupManageDBDAOSearchTPBGroupModifyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTPBGroupModifyList
	  * </pre>
	  */
	public JOOutstandinggroupManageDBDAOSearchTPBGroupModifyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.integration").append("\n"); 
		query.append("FileName : JOOutstandinggroupManageDBDAOSearchTPBGroupModifyListRSQL").append("\n"); 
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
		query.append("DECODE( /* 2008-11-20 O WAN-KI 1.2 JO TPB CANCEL CSR VALID 추가 */" ).append("\n"); 
		query.append("(SELECT COUNT(0) FROM AP_INV_HDR" ).append("\n"); 
		query.append("WHERE CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND SRC_CTNT = 'SO_TERMINAL'" ).append("\n"); 
		query.append("AND APRO_FLG = 'Y' AND IF_FLG = 'Y'" ).append("\n"); 
		query.append("AND NVL(RCV_ERR_FLG,'N') <> 'E')" ).append("\n"); 
		query.append(",0 ,'N' ,'Y'" ).append("\n"); 
		query.append(") AS CSRVALID" ).append("\n"); 
		query.append(",DECODE(A.OFC_CD,@[user_ofc_cd],DECODE(B.N3PTY_INV_NO,NULL,'Y','N'),'N') AS EDITABLE" ).append("\n"); 
		query.append(",A.OTS_DTL_SEQ" ).append("\n"); 
		query.append(",A.N3PTY_NO" ).append("\n"); 
		query.append(",A.N3PTY_NO_DP_SEQ" ).append("\n"); 
		query.append(",A.N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append(",TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append(",A.N3PTY_SRC_NO" ).append("\n"); 
		query.append(",A.BKG_NO  BKG_NO_ALL" ).append("\n"); 
		query.append(",A.BL_NO   BL_NO_ALL" ).append("\n"); 
		query.append(",A.VSL_CD||A.SKD_VOY_NO||SUBSTR(A.FINC_DIR_CD,1,1) G_VVD" ).append("\n"); 
		query.append(",EQ_NO" ).append("\n"); 
		query.append(",A.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(",CASE A.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("WHEN 'V' THEN LPAD(TO_CHAR(A.VNDR_SEQ),6,'0')" ).append("\n"); 
		query.append("WHEN 'C' THEN A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("WHEN 'S' THEN A.N3PTY_OFC_CD END" ).append("\n"); 
		query.append("TRD_PARTY_VAL" ).append("\n"); 
		query.append(",COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',C.OTS_STS_CD) AS OTS_STS_NM" ).append("\n"); 
		query.append(",DECODE(A.IF_CURR_CD,NULL,A.CFM_CURR_CD,A.IF_CURR_CD) CURR_CD" ).append("\n"); 
		query.append(",A.CFM_AMT" ).append("\n"); 
		query.append(",A.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",A.BL_NO" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.FINC_DIR_CD" ).append("\n"); 
		query.append(",A.VVD_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",A.CUST_CNT_CD" ).append("\n"); 
		query.append(",A.CUST_SEQ" ).append("\n"); 
		query.append(",A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL      A" ).append("\n"); 
		query.append(",TPB_OTS_GRP        B" ).append("\n"); 
		query.append(",TPB_OTS_GRP_STS    C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.N3PTY_BIL_TP_CD = 'JO'" ).append("\n"); 
		query.append("AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND B.N3PTY_DELT_TP_CD IN ('N')" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("ORDER BY N3PTY_NO, N3PTY_NO_DP_SEQ" ).append("\n"); 

	}
}