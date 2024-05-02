/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArrivalNoticeDBDAOModifyBkgArrNtcAntfyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOModifyBkgArrNtcAntfyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_ARR_NTC_ANTFY_SETUP 수정 (merge)
	  * </pre>
	  */
	public ArrivalNoticeDBDAOModifyBkgArrNtcAntfyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("antfy_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOModifyBkgArrNtcAntfyUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_ARR_NTC_ANTFY_SETUP A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT @[sc_no]             AS SC_NO" ).append("\n"); 
		query.append("             , @[antfy_cust_cd]     AS ANTFY_CUST_CD" ).append("\n"); 
		query.append("             , @[pod_cd]            AS POD_CD" ).append("\n"); 
		query.append("             , @[cust_cntc_tp_cd]   AS CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("            A.SC_NO           = B.SC_NO" ).append("\n"); 
		query.append("        AND A.ANTFY_CUST_CD   = B.ANTFY_CUST_CD" ).append("\n"); 
		query.append("        AND A.POD_CD          = B.POD_CD" ).append("\n"); 
		query.append("        AND A.CUST_CNTC_TP_CD = B.CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHEN MATCHED THEN " ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("       A.FAX_NO     = @[fax_no]" ).append("\n"); 
		query.append("     , A.CNTC_EML   = @[cntc_eml]" ).append("\n"); 
		query.append("     , A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("     , A.UPD_DT     = sysdate" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT  " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("          SC_NO" ).append("\n"); 
		query.append("        , ANTFY_CUST_CD" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , CUST_CNTC_TP_CD" ).append("\n"); 
		query.append("        , FAX_NO" ).append("\n"); 
		query.append("        , CNTC_EML" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("          @[sc_no]" ).append("\n"); 
		query.append("        , @[antfy_cust_cd]" ).append("\n"); 
		query.append("        , @[pod_cd]" ).append("\n"); 
		query.append("        , @[cust_cntc_tp_cd]" ).append("\n"); 
		query.append("        , @[fax_no]" ).append("\n"); 
		query.append("        , @[cntc_eml]" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , sysdate" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}