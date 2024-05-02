/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchUnmatchItemListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.11 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltSearchUnmatchItemListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unmatch Details
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchUnmatchItemListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("umch_bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchUnmatchItemListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("UI.BKG_NO" ).append("\n"); 
		query.append(",UI.UMCH_BKG_SEQ" ).append("\n"); 
		query.append(",UI.UMCH_TP_CD" ).append("\n"); 
		query.append(",(SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = UI.UMCH_TP_CD) AS UMCH_TP_NM" ).append("\n"); 
		query.append(",UI.BKG_ITM_LOG" ).append("\n"); 
		query.append(",UI.CTRT_ITM_LOG" ).append("\n"); 
		query.append(",UI.MTCH_UMCH_TP_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02456' AND INTG_CD_VAL_CTNT = UI.MTCH_UMCH_TP_CD) AS MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append("FROM   BKG_REV_UMCH_ITM UI" ).append("\n"); 
		query.append("WHERE  UI.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    UI.UMCH_BKG_SEQ = @[umch_bkg_seq]" ).append("\n"); 

	}
}