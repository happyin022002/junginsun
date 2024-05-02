/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAOAddSpotBidCnddtVndrHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.11.27 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpotBiddingManageDBDAOAddSpotBidCnddtVndrHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Candidate Vendor History Insert
	  * </pre>
	  */
	public SpotBiddingManageDBDAOAddSpotBidCnddtVndrHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration ").append("\n"); 
		query.append("FileName : SpotBiddingManageDBDAOAddSpotBidCnddtVndrHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_SPOT_BID_CNDDT_VNDR_HIS" ).append("\n"); 
		query.append("  	  (SPOT_BID_CNDDT_TERM_SEQ" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,CNDDT_VNDR_HIS_SEQ" ).append("\n"); 
		query.append("      ,SPOT_BID_VNDR_EML" ).append("\n"); 
		query.append("      ,SP_PTAL_EXIST_FLG" ).append("\n"); 
		query.append("      ,LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,CRE_OFC_CD" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SPOT_BID_CNDDT_TERM_SEQ," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(CNDDT_VNDR_HIS_SEQ)+1, 1)" ).append("\n"); 
		query.append("          FROM TRS_SPOT_BID_CNDDT_VNDR_HIS" ).append("\n"); 
		query.append("         WHERE SPOT_BID_CNDDT_TERM_SEQ = SBCV.SPOT_BID_CNDDT_TERM_SEQ" ).append("\n"); 
		query.append("           AND VNDR_SEQ = SBCV.VNDR_SEQ) CNDDT_VNDR_HIS_SEQ," ).append("\n"); 
		query.append("       SPOT_BID_VNDR_EML," ).append("\n"); 
		query.append("       SP_PTAL_EXIST_FLG," ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]) LOCL_CRE_DT," ).append("\n"); 
		query.append("       @[cre_ofc_cd] CRE_OFC_CD," ).append("\n"); 
		query.append("       DELT_FLG," ).append("\n"); 
		query.append("       @[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE CRE_DT," ).append("\n"); 
		query.append("       @[cre_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM TRS_SPOT_BID_CNDDT_VNDR SBCV" ).append("\n"); 
		query.append(" WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("   " ).append("\n"); 

	}
}