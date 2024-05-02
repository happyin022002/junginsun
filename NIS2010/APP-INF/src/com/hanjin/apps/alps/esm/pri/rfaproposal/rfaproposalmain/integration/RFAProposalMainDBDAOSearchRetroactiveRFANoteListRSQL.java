/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAOSearchRetroactiveRFANoteListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.27 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOSearchRetroactiveRFANoteListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RetroactiveRFANote대상 조회
	  * </pre>
	  */
	public RFAProposalMainDBDAOSearchRetroactiveRFANoteListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration ").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOSearchRetroactiveRFANoteListRSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT AS RTRO_NOTE_CD" ).append("\n"); 
		query.append("     , INTG_CD_VAL_DESC AS RTRO_NOTE_NM" ).append("\n"); 
		query.append("  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = 'CD03344'" ).append("\n"); 
		query.append(" ORDER BY INTG_CD_VAL_DP_SEQ ASC" ).append("\n"); 

	}
}