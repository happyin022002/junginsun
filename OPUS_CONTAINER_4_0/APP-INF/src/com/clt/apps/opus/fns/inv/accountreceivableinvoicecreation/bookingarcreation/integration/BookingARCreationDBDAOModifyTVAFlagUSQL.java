/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyTVAFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyTVAFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyTVAFlag
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyTVAFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyTVAFlagUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG" ).append("\n"); 
		query.append("SET TVA_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND CHG_CD IN ( SELECT PBC.CHG_CD" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT BR" ).append("\n"); 
		query.append("                     , MDM_CHARGE M" ).append("\n"); 
		query.append("                     , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                     , MDM_LOCATION L" ).append("\n"); 
		query.append("                     , BKG_BOOKING B" ).append("\n"); 
		query.append("                     , PRI_SCG_PRF PF" ).append("\n"); 
		query.append("                     , PRI_SCG_PCT_BSE_CHG PBC" ).append("\n"); 
		query.append("                 WHERE 1=1 " ).append("\n"); 
		query.append("                   AND B.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("                   AND M.CHG_CD = BR.CHG_CD" ).append("\n"); 
		query.append("                   AND BR.AUTO_RAT_CD = 'A' " ).append("\n"); 
		query.append("                   AND BR.RAT_UT_CD = 'PC' " ).append("\n"); 
		query.append("                   AND M.TAX_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND B.SVC_SCP_CD = PF.SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND PF.CHG_CD = BR.CHG_CD" ).append("\n"); 
		query.append("                   AND PF.PCT_BSE_CD = PBC.PCT_BSE_CD" ).append("\n"); 
		query.append("                   AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("                   AND (L.CNT_CD = M.TAX_CNT_CD OR M.TAX_CNT_CD IS NULL)" ).append("\n"); 
		query.append("                   AND O.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                   AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BR.CHG_CD IN (SELECT CHG_CD" ).append("\n"); 
		query.append("                                     FROM INV_AR_CHG" ).append("\n"); 
		query.append("                                     WHERE AR_IF_NO = @[ar_if_no])" ).append("\n"); 
		query.append("                   GROUP BY PBC.CHG_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}