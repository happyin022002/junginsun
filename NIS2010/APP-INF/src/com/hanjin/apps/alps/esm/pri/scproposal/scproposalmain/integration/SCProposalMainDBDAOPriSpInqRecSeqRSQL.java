/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SCProposalMainDBDAOPriSpInqRecSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.27
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.12.27 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpInqRecSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI SP DOWNLOAD RECORD SEQ 생성 조회
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpInqRecSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpInqRecSeqRSQL").append("\n"); 
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
		query.append("--SELECT NVL(" ).append("\n"); 
		query.append("	--(SELECT /*+ INDEX_DESC(A XPKPRI_SP_DL_REC) */ SCRN_EVNT_SEQ" ).append("\n"); 
		query.append("    --  FROM PRI_SP_DL_REC A" ).append("\n"); 
		query.append("    -- WHERE ROWNUM < 2)  + 1" ).append("\n"); 
		query.append("    -- , 1)  AS SCRN_EVNT_SEQ" ).append("\n"); 
		query.append("-- FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT PRI_SP_INQ_REC_SEQ.NEXTVAL AS SCRN_EVNT_SEQ " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}