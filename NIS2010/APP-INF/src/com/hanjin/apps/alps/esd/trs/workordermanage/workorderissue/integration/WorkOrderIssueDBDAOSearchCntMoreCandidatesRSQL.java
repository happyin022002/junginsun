/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOSearchCntMoreCandidatesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.26
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.02.26 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOSearchCntMoreCandidatesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * More CNT Candidates Search
	  * </pre>
	  */
	public WorkOrderIssueDBDAOSearchCntMoreCandidatesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOSearchCntMoreCandidatesRSQL").append("\n"); 
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
		query.append("SELECT B.VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.VNDR_LGL_ENG_NM  VNDR_NM" ).append("\n"); 
		query.append("      ,A.CTRT_CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("      ,A.CTRT_CUST_SEQ    CUST_SEQ" ).append("\n"); 
		query.append("      ,A.CUST_NOMI_TRKR_IND_CD CNT_TP_CD" ).append("\n"); 
		query.append("  FROM TRS_CUST_NOMI_TRKR A" ).append("\n"); 
		query.append("      ,MDM_VENDOR B" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.PRC_CTRT_TP_CD = DECODE(@[sc_no],'','R','S')" ).append("\n"); 
		query.append("   AND A.PRC_CTRT_NO =NVL(@[sc_no],@[rfa_no])" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[trsp_bnd_cd]" ).append("\n"); 
		query.append("   AND A.ORG_NOD_CD = CASE WHEN @[trsp_bnd_cd] = 'I' AND LENGTH(A.ORG_NOD_CD)= 5 THEN @[fm_nod_cd]" ).append("\n"); 
		query.append("                           WHEN @[trsp_bnd_cd] = 'I' AND LENGTH(A.ORG_NOD_CD)= 7 THEN @[fm_nod_cd]||@[fm_nod_yard]" ).append("\n"); 
		query.append("                           WHEN @[trsp_bnd_cd] = 'O' AND LENGTH(A.ORG_NOD_CD)= 5 THEN @[dor_nod_cd]" ).append("\n"); 
		query.append("                           WHEN @[trsp_bnd_cd] = 'O' AND LENGTH(A.ORG_NOD_CD)= 7 THEN @[dor_nod_cd]||@[dor_nod_yard]" ).append("\n"); 
		query.append("                       END " ).append("\n"); 
		query.append("   AND A.DEST_NOD_CD = CASE WHEN @[trsp_bnd_cd] = 'I' AND LENGTH(A.DEST_NOD_CD)= 5 THEN @[dor_nod_cd]" ).append("\n"); 
		query.append("                            WHEN @[trsp_bnd_cd] = 'I' AND LENGTH(A.DEST_NOD_CD)= 7 THEN @[dor_nod_cd]||@[dor_nod_yard]" ).append("\n"); 
		query.append("                            WHEN @[trsp_bnd_cd] = 'O' AND LENGTH(A.DEST_NOD_CD)= 5 THEN @[to_nod_cd]" ).append("\n"); 
		query.append("                            WHEN @[trsp_bnd_cd] = 'O' AND LENGTH(A.DEST_NOD_CD)= 7 THEN @[to_nod_cd]||@[to_nod_yard]" ).append("\n"); 
		query.append("						END " ).append("\n"); 
		query.append("   AND A.DISP_STS_CD = '03' --Approval status" ).append("\n"); 

	}
}