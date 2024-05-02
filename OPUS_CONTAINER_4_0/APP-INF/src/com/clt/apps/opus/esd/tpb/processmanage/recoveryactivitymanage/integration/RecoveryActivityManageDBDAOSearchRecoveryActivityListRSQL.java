/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Recovery Activity List Search
	  * </pre>
	  */
	public RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.integration").append("\n"); 
		query.append("FileName : RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL").append("\n"); 
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
		query.append("SELECT 2 SORTNO" ).append("\n"); 
		query.append("      ,B.N3PTY_NO" ).append("\n"); 
		query.append("      ,B.OTS_GRP_RCVR_ACT_SEQ" ).append("\n"); 
		query.append("      ,B.ACT_RMK" ).append("\n"); 
		query.append("      ,TO_CHAR(TPB_GET_LCL_DATE_FNC(B.LOCL_CRE_DT,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,B.CLT_ACT_UPD_OFC_CD" ).append("\n"); 
		query.append("      ,B.UPD_USR_ID" ).append("\n"); 
		query.append("      ,B.CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,DECODE(B.N3PTY_CLT_RMK_TP_CD,'A',1,0) N3PTY_NO_Y" ).append("\n"); 
		query.append("      ,DECODE(B.N3PTY_CLT_RMK_TP_CD,'M',1,0) N3PTY_NO_N" ).append("\n"); 
		query.append("      ,NVL2(B.FILE_NO,'File Attach',DECODE(B.N3PTY_CLT_RMK_TP_CD,'M','File Attach')) IMG_FILE_NO" ).append("\n"); 
		query.append("      ,B.FILE_NO" ).append("\n"); 
		query.append("      ,A.N3PTY_INV_NO" ).append("\n"); 
		query.append("      ,B.N3PTY_CLT_RMK_TP_CD" ).append("\n"); 
		query.append("	  ,NVL2(b.file_no, ( SELECT COUNT(0) cnt FROM TPB_TTL_FILE_MGMT f WHERE f.file_no=b.file_no AND f.delt_flg='N' ), 0) As file_count		" ).append("\n"); 
		query.append("  FROM TPB_OTS_GRP A" ).append("\n"); 
		query.append("      ,TPB_OTS_GRP_RCVR_ACT B" ).append("\n"); 
		query.append(" WHERE A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '') " ).append("\n"); 
		query.append("   AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 2 SORTNO" ).append("\n"); 
		query.append("      ,B.N3PTY_NO" ).append("\n"); 
		query.append("      ,B.OTS_GRP_RCVR_ACT_SEQ" ).append("\n"); 
		query.append("      ,TPB_GET_IF_RMK_FNC(B.N3PTY_NO) ACT_RMK" ).append("\n"); 
		query.append("      ,TO_CHAR(TPB_GET_LCL_DATE_FNC(B.LOCL_CRE_DT,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,B.CLT_ACT_UPD_OFC_CD" ).append("\n"); 
		query.append("      ,B.UPD_USR_ID" ).append("\n"); 
		query.append("      ,B.CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,DECODE(B.N3PTY_CLT_RMK_TP_CD,'A',1,0) N3PTY_NO_Y" ).append("\n"); 
		query.append("      ,DECODE(B.N3PTY_CLT_RMK_TP_CD,'M',1,0) N3PTY_NO_N" ).append("\n"); 
		query.append("      ,NVL2(B.FILE_NO,'File Attach',DECODE(B.N3PTY_CLT_RMK_TP_CD,'M','File Attach')) IMG_FILE_NO" ).append("\n"); 
		query.append("      ,B.FILE_NO" ).append("\n"); 
		query.append("      ,A.N3PTY_INV_NO" ).append("\n"); 
		query.append("      ,B.N3PTY_CLT_RMK_TP_CD" ).append("\n"); 
		query.append("	  ,NVL2(b.file_no, ( SELECT COUNT(0) cnt FROM TPB_TTL_FILE_MGMT f WHERE f.file_no=b.file_no AND f.delt_flg='N' ), 0) As file_count" ).append("\n"); 
		query.append("  FROM TPB_OTS_GRP A" ).append("\n"); 
		query.append("      ,TPB_OTS_GRP_RCVR_ACT B" ).append("\n"); 
		query.append(" WHERE A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '') " ).append("\n"); 
		query.append("   AND A.N3PTY_NO = @[s_n3pty_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.OTS_GRP_RCVR_ACT_SEQ = 1" ).append("\n"); 
		query.append("   AND TPB_GET_IF_RMK_FNC(B.N3PTY_NO) IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY SORTNO, N3PTY_NO, OTS_GRP_RCVR_ACT_SEQ" ).append("\n"); 

	}
}