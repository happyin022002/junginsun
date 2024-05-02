/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAORuleChargeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.01.21 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAORuleChargeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rule code, charge  code 조회
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAORuleChargeCodeListRSQL(){
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
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration ").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAORuleChargeCodeListRSQL").append("\n"); 
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
		query.append("SELECT T1.CD, T1.NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.NOTE_CONV_RULE_CD CD" ).append("\n"); 
		query.append(", A.NOTE_CONV_RULE_NM NM" ).append("\n"); 
		query.append("FROM PRI_NOTE_CONV_RULE A" ).append("\n"); 
		query.append(", PRI_NOTE_CONV_TP_RULE_MAPG B" ).append("\n"); 
		query.append("WHERE A.NOTE_CONV_RULE_CD = B.NOTE_CONV_RULE_CD" ).append("\n"); 
		query.append("AND B.PRC_CTRT_TP_CD = 'T'" ).append("\n"); 
		query.append("AND B.NOTE_CONV_TP_CD =  'F'" ).append("\n"); 
		query.append("ORDER BY A.NOTE_CONV_RULE_CD ASC" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT T2.CD, T2.NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.CHG_CD AS CD" ).append("\n"); 
		query.append(",B.CHG_NM AS NM" ).append("\n"); 
		query.append("FROM PRI_SCG_PRF A" ).append("\n"); 
		query.append(",MDM_CHARGE B" ).append("\n"); 
		query.append("WHERE A.CHG_CD = B.CHG_CD" ).append("\n"); 
		query.append("AND A.SVC_SCP_CD IN (" ).append("\n"); 
		query.append("SELECT SVC_SCP_CD FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD = @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.CHG_CD" ).append("\n"); 
		query.append(") T2" ).append("\n"); 

	}
}