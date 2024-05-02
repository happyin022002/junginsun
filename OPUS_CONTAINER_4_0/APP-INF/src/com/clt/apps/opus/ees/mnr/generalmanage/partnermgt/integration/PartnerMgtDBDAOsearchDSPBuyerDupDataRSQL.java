/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerMgtDBDAOsearchDSPBuyerDupDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerMgtDBDAOsearchDSPBuyerDupDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PartnerMgtDBDAOsearchDSPBuyerDupDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration ").append("\n"); 
		query.append("FileName : PartnerMgtDBDAOsearchDSPBuyerDupDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("  FROM MNR_GEN_CD" ).append("\n"); 
		query.append(" WHERE PRNT_CD_ID = 'CD00053'" ).append("\n"); 
		query.append("   AND MNR_CD_ID = (SELECT MNR_PRNR_STS_CD" ).append("\n"); 
		query.append("                      FROM MNR_PARTNER" ).append("\n"); 
		query.append("                     WHERE MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("                       AND MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("                       AND MNR_PRNR_SEQ = @[mnr_prnr_seq]" ).append("\n"); 
		query.append("                       AND ROWNUM = 1)" ).append("\n"); 

	}
}