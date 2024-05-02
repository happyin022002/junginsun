/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementTrsComScgMgmtDBDAOMergeTrsComScgMgmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.15 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementTrsComScgMgmtDBDAOMergeTrsComScgMgmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MergeTrsComScgMgmt
	  * </pre>
	  */
	public AgreementTrsComScgMgmtDBDAOMergeTrsComScgMgmtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementTrsComScgMgmtDBDAOMergeTrsComScgMgmtCSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_COM_SCG_MGMT M" ).append("\n"); 
		query.append("USING (SELECT * FROM TRS_COM_SCG_MGMT_TMP" ).append("\n"); 
		query.append("        WHERE TRSP_TMP_SEQ = @[trsp_tmp_seq]" ).append("\n"); 
		query.append("      ) T" ).append("\n"); 
		query.append(" ON (" ).append("\n"); 
		query.append("      M.COM_SCG_KND_CD = T.COM_SCG_KND_CD AND" ).append("\n"); 
		query.append("      M.COM_SCG_SEQ    = T.COM_SCG_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("     SET TRSP_COST_MOD_CD = T.TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("         AGMT_TRSP_TP_CD  = T.AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("         RCC_CD           = T.RCC_CD," ).append("\n"); 
		query.append("         LCC_CD           = T.LCC_CD," ).append("\n"); 
		query.append("         SCC_CD           = T.SCC_CD," ).append("\n"); 
		query.append("         EQ_KND_CD        = T.EQ_KND_CD," ).append("\n"); 
		query.append("         EQ_TPSZ_CD       = T.EQ_TPSZ_CD," ).append("\n"); 
		query.append("         CGO_TP_CD        = T.CGO_TP_CD," ).append("\n"); 
		query.append("         BND_CD           = T.BND_CD," ).append("\n"); 
		query.append("         RT_TP_CD         = T.RT_TP_CD," ).append("\n"); 
		query.append("         CURR_CD          = T.CURR_CD," ).append("\n"); 
		query.append("         ONE_WY_RT        = T.ONE_WY_RT," ).append("\n"); 
		query.append("         RND_RT           = T.RND_RT," ).append("\n"); 
		query.append("         EFF_FM_DT        = T.EFF_FM_DT," ).append("\n"); 
		query.append("         EFF_TO_DT        = T.EFF_TO_DT," ).append("\n"); 
		query.append("         WO_APLY_FLG      = T.WO_APLY_FLG," ).append("\n"); 
		query.append("         CRE_USR_ID       = T.CRE_USR_ID," ).append("\n"); 
		query.append("         CRE_DT           = SYSDATE," ).append("\n"); 
		query.append("         UPD_USR_ID       = T.UPD_USR_ID," ).append("\n"); 
		query.append("         UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           COM_SCG_KND_CD," ).append("\n"); 
		query.append("           COM_SCG_SEQ," ).append("\n"); 
		query.append("           TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("           AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("           RCC_CD," ).append("\n"); 
		query.append("           LCC_CD," ).append("\n"); 
		query.append("           SCC_CD," ).append("\n"); 
		query.append("           EQ_KND_CD," ).append("\n"); 
		query.append("           EQ_TPSZ_CD," ).append("\n"); 
		query.append("           CGO_TP_CD," ).append("\n"); 
		query.append("           BND_CD," ).append("\n"); 
		query.append("           RT_TP_CD," ).append("\n"); 
		query.append("           CURR_CD," ).append("\n"); 
		query.append("           ONE_WY_RT," ).append("\n"); 
		query.append("           RND_RT," ).append("\n"); 
		query.append("           EFF_FM_DT," ).append("\n"); 
		query.append("           EFF_TO_DT," ).append("\n"); 
		query.append("           WO_APLY_FLG," ).append("\n"); 
		query.append("           CRE_USR_ID," ).append("\n"); 
		query.append("           CRE_DT," ).append("\n"); 
		query.append("           UPD_USR_ID," ).append("\n"); 
		query.append("           UPD_DT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  VALUES" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           T.COM_SCG_KND_CD," ).append("\n"); 
		query.append("           OPUSADM.TRS_COM_SCG_MGMT_SEQ.NEXTVAL," ).append("\n"); 
		query.append("           T.TRSP_COST_MOD_CD," ).append("\n"); 
		query.append("           T.AGMT_TRSP_TP_CD," ).append("\n"); 
		query.append("           T.RCC_CD," ).append("\n"); 
		query.append("           T.LCC_CD," ).append("\n"); 
		query.append("           T.SCC_CD," ).append("\n"); 
		query.append("           T.EQ_KND_CD," ).append("\n"); 
		query.append("           T.EQ_TPSZ_CD," ).append("\n"); 
		query.append("           T.CGO_TP_CD," ).append("\n"); 
		query.append("           T.BND_CD," ).append("\n"); 
		query.append("           T.RT_TP_CD," ).append("\n"); 
		query.append("           T.CURR_CD," ).append("\n"); 
		query.append("           T.ONE_WY_RT," ).append("\n"); 
		query.append("           T.RND_RT," ).append("\n"); 
		query.append("           T.EFF_FM_DT," ).append("\n"); 
		query.append("           T.EFF_TO_DT," ).append("\n"); 
		query.append("           T.WO_APLY_FLG," ).append("\n"); 
		query.append("           T.CRE_USR_ID," ).append("\n"); 
		query.append("           SYSDATE," ).append("\n"); 
		query.append("           T.UPD_USR_ID," ).append("\n"); 
		query.append("           SYSDATE" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}