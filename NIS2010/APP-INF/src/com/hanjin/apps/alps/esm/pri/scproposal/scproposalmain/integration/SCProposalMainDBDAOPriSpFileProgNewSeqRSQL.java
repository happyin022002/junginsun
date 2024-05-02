/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCProposalMainDBDAOPriSpFileProgNewSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.18
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.06.18 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOPriSpFileProgNewSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SP_FILE_PROG 의 신규 Sequence 생성
	  * </pre>
	  */
	public SCProposalMainDBDAOPriSpFileProgNewSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration ").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOPriSpFileProgNewSeqRSQL").append("\n"); 
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
		query.append("SELECT  NVL (   (   SELECT /*+ INDEX_DESC(A XPKPRI_SP_FILE_PROG) */" ).append("\n"); 
		query.append("                       	    A.FILE_PROG_SEQ" ).append("\n"); 
		query.append("                    FROM	PRI_SP_FILE_PROG A" ).append("\n"); 
		query.append("                    WHERE	A.PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("                    AND     A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                    AND		ROWNUM = 1 ), 0 ) + 1 AS NEW_FILE_PROG_SEQ" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}