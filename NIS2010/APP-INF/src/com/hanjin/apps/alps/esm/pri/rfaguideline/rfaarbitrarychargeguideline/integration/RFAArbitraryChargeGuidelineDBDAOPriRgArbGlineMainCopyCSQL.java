/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAArbitraryChargeGuidelineDBDAOPriRgArbGlineMainCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.16 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAArbitraryChargeGuidelineDBDAOPriRgArbGlineMainCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline Main Copy
	  * </pre>
	  */
	public RFAArbitraryChargeGuidelineDBDAOPriRgArbGlineMainCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trgt_svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trgt_gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration ").append("\n"); 
		query.append("FileName : RFAArbitraryChargeGuidelineDBDAOPriRgArbGlineMainCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_RG_ARB" ).append("\n"); 
		query.append("SELECT @[trgt_svc_scp_cd]" ).append("\n"); 
		query.append(", @[trgt_gline_seq]" ).append("\n"); 
		query.append(", ORG_DEST_TP_CD" ).append("\n"); 
		query.append(", ARB_SEQ" ).append("\n"); 
		query.append(", ROUT_PNT_LOC_TP_CD" ).append("\n"); 
		query.append(", ROUT_PNT_LOC_DEF_CD" ).append("\n"); 
		query.append(", BSE_PORT_TP_CD" ).append("\n"); 
		query.append(", BSE_PORT_DEF_CD" ).append("\n"); 
		query.append(", RAT_UT_CD" ).append("\n"); 
		query.append(", PRC_CGO_TP_CD" ).append("\n"); 
		query.append(", PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append(", RCV_DE_TERM_CD" ).append("\n"); 
		query.append(", MIN_CGO_WGT" ).append("\n"); 
		query.append(", MAX_CGO_WGT" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", FRT_RT_AMT" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM PRI_RG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ = @[gline_seq]" ).append("\n"); 
		query.append("AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 

	}
}