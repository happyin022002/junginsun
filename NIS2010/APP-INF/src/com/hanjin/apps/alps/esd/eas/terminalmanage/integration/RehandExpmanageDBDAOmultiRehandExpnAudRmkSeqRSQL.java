/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RehandExpmanageDBDAOmultiRehandExpnAudRmkSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.01
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.09.01 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RehandExpmanageDBDAOmultiRehandExpnAudRmkSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * multiRehandExpnAudRmkSeq
	  * </pre>
	  */
	public RehandExpmanageDBDAOmultiRehandExpnAudRmkSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expntpcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.terminalmanage.integration").append("\n"); 
		query.append("FileName : RehandExpmanageDBDAOmultiRehandExpnAudRmkSeqRSQL").append("\n"); 
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
		query.append("SELECT	NVL( MAX( RMK_CTNT_SEQ ), 0 ) + 1	AS RMKSEQ" ).append("\n"); 
		query.append("FROM	TRS_EXPN_AUD_RMK" ).append("\n"); 
		query.append("WHERE	BKG_NO			= @[bkgno]" ).append("\n"); 
		query.append("AND		EAS_EXPN_TP_CD	= @[expntpcd]" ).append("\n"); 

	}
}