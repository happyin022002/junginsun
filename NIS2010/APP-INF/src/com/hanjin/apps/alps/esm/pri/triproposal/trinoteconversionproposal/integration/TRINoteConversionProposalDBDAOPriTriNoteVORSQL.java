/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAOPriTriNoteVORSQL.java
*@FileTitle : TRI Creation &amp; Amendment - Note Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.12.01 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAOPriTriNoteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_TRI_NOTE SELECT
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAOPriTriNoteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAOPriTriNoteVORSQL").append("\n"); 
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
		query.append(", TRF_NO" ).append("\n"); 
		query.append(", NOTE_SEQ" ).append("\n"); 
		query.append(", TO_CHAR(EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(", DECODE(TO_CHAR(EXP_DT, 'YYYY-MM-DD'),'9999-12-31','',TO_CHAR(EXP_DT, 'YYYY-MM-DD')) AS EXP_DT" ).append("\n"); 
		query.append(", NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append(", CFM_FLG" ).append("\n"); 
		query.append(", CFM_USR_ID" ).append("\n"); 
		query.append(", CFM_OFC_CD" ).append("\n"); 
		query.append("FROM PRI_TRI_NOTE" ).append("\n"); 
		query.append("WHERE TRF_PFX_CD	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("AND TRF_NO		= @[trf_no]" ).append("\n"); 
		query.append("#if (${note_seq} != '' && ${note_seq} != 'X')" ).append("\n"); 
		query.append("AND NOTE_SEQ		= @[note_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY EFF_DT DESC" ).append("\n"); 

	}
}