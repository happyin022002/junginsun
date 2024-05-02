/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOCheckMaxCostTrfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOCheckMaxCostTrfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check Max Cost Trf No
	  * </pre>
	  */
	public IHCGuideLineDBDAOCheckMaxCostTrfNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOCheckMaxCostTrfNoRSQL").append("\n"); 
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
		query.append("SELECT HDR.COST_TRF_NO" ).append("\n"); 
		query.append("  FROM PRI_TRF_IHC_HDR HDR" ).append("\n"); 
		query.append("     , ( SELECT RANK() OVER(PARTITION BY CNT_CD, IO_BND_CD ORDER BY COST_TRF_NO DESC) RNK" ).append("\n"); 
		query.append("              , COST_TRF_NO" ).append("\n"); 
		query.append("          FROM #if(${rhq_cd} == 'NYCRA')" ).append("\n"); 
		query.append("                    AOC_USA_INLND_TRF_HDR  " ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if(${rhq_cd} == 'HAMRU')    " ).append("\n"); 
		query.append("                    AOC_EUR_INLND_TRF_HDR " ).append("\n"); 
		query.append("               #end " ).append("\n"); 
		query.append("               #if(${rhq_cd} == 'SINRS')" ).append("\n"); 
		query.append("                    AOC_CHN_INLND_TRF_HDR" ).append("\n"); 
		query.append("               #end " ).append("\n"); 
		query.append("               #if(${rhq_cd} == 'SHARC')" ).append("\n"); 
		query.append("                    AOC_CHN_INLND_TRF_HDR" ).append("\n"); 
		query.append("               #end           " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND COST_TRF_STS_CD = 'C'" ).append("\n"); 
		query.append("           AND IO_BND_CD       = DECODE( @[org_dest_tp_cd] ,'O','O','D','I')" ).append("\n"); 
		query.append("           AND CNT_CD          = @[cost_cnt_cd]   " ).append("\n"); 
		query.append("     ) AOC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND HDR.SVC_SCP_CD       = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND HDR.ORG_DEST_TP_CD   = @[org_dest_tp_cd] " ).append("\n"); 
		query.append("   AND HDR.IHC_TRF_NO       = @[ihc_trf_no]" ).append("\n"); 
		query.append("   AND HDR.COST_TRF_NO      = AOC.COST_TRF_NO" ).append("\n"); 
		query.append("   AND AOC.RNK = 1" ).append("\n"); 

	}
}