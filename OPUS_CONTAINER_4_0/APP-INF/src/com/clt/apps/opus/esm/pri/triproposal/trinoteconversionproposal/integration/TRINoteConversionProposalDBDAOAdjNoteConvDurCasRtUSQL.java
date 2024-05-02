/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOAdjNoteConvDurCasRtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2010.01.14 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOAdjNoteConvDurCasRtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rate의 Duration이 Conversion Duration을 이에 맞춰주는 작업
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOAdjNoteConvDurCasRtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOAdjNoteConvDurCasRtUSQL").append("\n"); 
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
		query.append("MERGE INTO PRI_TRI_NOTE_CONV A" ).append("\n"); 
		query.append("USING (SELECT N.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(",EFF_DT AS OLD_EFF_DT" ).append("\n"); 
		query.append(",EXP_DT AS OLD_EXP_DT" ).append("\n"); 
		query.append(",TO_DATE(@[eff_dt], 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",TO_DATE(@[exp_dt], 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("FROM PRI_TRI_RT N" ).append("\n"); 
		query.append("WHERE N.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("AND N.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET A.EFF_DT = DECODE(A.EFF_DT, B.OLD_EFF_DT, B.EFF_DT, GREATEST(A.EFF_DT, B.EFF_DT))" ).append("\n"); 
		query.append(",A.EXP_DT = DECODE(A.EXP_DT, B.OLD_EXP_DT, B.EXP_DT, LEAST(A.EXP_DT, B.EXP_DT))" ).append("\n"); 
		query.append("--   WHERE (A.EFF_DT BETWEEN B.EFF_DT AND B.EXP_DT OR A.EXP_DT BETWEEN B.EFF_DT AND B.EXP_DT OR" ).append("\n"); 
		query.append("--         (A.EFF_DT <= B.EFF_DT AND A.EXP_DT > B.EXP_DT))" ).append("\n"); 
		query.append("DELETE" ).append("\n"); 
		query.append("WHERE (A.EFF_DT > B.EXP_DT OR A.EXP_DT < B.EFF_DT)" ).append("\n"); 
		query.append("AND (A.NOTE_CONV_RULE_CD IS NULL OR A.NOTE_CONV_RULE_CD <> 'APP')" ).append("\n"); 

	}
}