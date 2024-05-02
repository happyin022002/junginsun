/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.10 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI Calc. Commodity 조회
	  * </pre>
	  */
	public TRIGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.integration").append("\n"); 
		query.append("FileName : TRIGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL").append("\n"); 
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
		query.append("SELECT TRF_PFX_CD" ).append("\n"); 
		query.append(",TRF_NO" ).append("\n"); 
		query.append(",GRI_GRP_SEQ" ).append("\n"); 
		query.append(",CMDT_SEQ" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",(SELECT CMDT_NM" ).append("\n"); 
		query.append("FROM MDM_COMMODITY" ).append("\n"); 
		query.append("WHERE CMDT_CD = A.CMDT_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS CMDT_NM" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM PRI_TRI_GRI_CMDT A" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND GRI_GRP_SEQ = @[gri_grp_seq]" ).append("\n"); 
		query.append("ORDER BY CMDT_CD" ).append("\n"); 

	}
}