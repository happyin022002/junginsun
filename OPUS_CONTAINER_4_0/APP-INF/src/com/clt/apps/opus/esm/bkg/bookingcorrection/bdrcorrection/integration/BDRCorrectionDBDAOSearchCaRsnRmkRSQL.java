/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCaRsnRmkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCaRsnRmkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCaRsnRmkRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCaRsnRmkRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCaRsnRmkRSQL").append("\n"); 
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
		query.append("SELECT BC.CA_RSN_CD                      AS CA_RSN_CD," ).append("\n"); 
		query.append("BC.BKG_CORR_RMK                   AS BKG_CORR_RMK," ).append("\n"); 
		query.append("NVL(BC.RDN_NO,   BRDN.RDN_NO)     AS RDN_NO," ).append("\n"); 
		query.append("NVL(BC.RVIS_SEQ, BRDN.RVIS_SEQ)   AS RVIS_SEQ," ).append("\n"); 
		query.append("NVL(BC.RDN_ACPT_FLG, 'N')         AS RDN_ACPT_FLG," ).append("\n"); 
		query.append("NVL(( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_VAL_CTNT = NVL(BRDN.RDN_STS_CD,' ')" ).append("\n"); 
		query.append("AND INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("AND APLY_ST_DT  <= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD')), 'NOT ISSUED') AS INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(", BRDN.RDN_STS_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING    BKG," ).append("\n"); 
		query.append("BKG_CORRECTION BC," ).append("\n"); 
		query.append("( SELECT BKG_NO," ).append("\n"); 
		query.append("RDN_NO," ).append("\n"); 
		query.append("RVIS_SEQ," ).append("\n"); 
		query.append("RDN_STS_CD" ).append("\n"); 
		query.append("FROM BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND RDN_STS_CD IN ( 'RV','IS' ) ) BRDN" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO    = BRDN.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO    = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BC.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("AND BKG.BKG_NO    = @[bkg_no]" ).append("\n"); 

	}
}