/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeAutoRatingDBDAOSearchThirdPartyOfcByLbpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeAutoRatingDBDAOSearchThirdPartyOfcByLbpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LBP Surcharge 정보에 해당하는 Third Party Office 정보를 구한다.
	  * </pre>
	  */
	public SurchargeAutoRatingDBDAOSearchThirdPartyOfcByLbpRSQL(){
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
		params.put("login_office",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : SurchargeAutoRatingDBDAOSearchThirdPartyOfcByLbpRSQL").append("\n"); 
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
		query.append("SELECT  THIRD_PARTY_OFC, REP_CUST_CNT_CD, REP_CUST_SEQ, FRT_TERM_CD" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  PPD_RCV_OFC_CD, CLT_OFC_CD, LOGIN_OFC_CD" ).append("\n"); 
		query.append("                , CASE WHEN LOGIN_OFC_CD != CLT_OFC_CD THEN" ).append("\n"); 
		query.append("                   CASE WHEN DECODE(LOGIN_OFC_CD, 'SELSC','PUSSC','PUSSC','SELSC',LOGIN_OFC_CD) != CLT_OFC_CD THEN" ).append("\n"); 
		query.append("                    CASE WHEN LOGIN_OFC_CD != PPD_RCV_OFC_CD THEN" ).append("\n"); 
		query.append("                     CASE WHEN DECODE(LOGIN_OFC_CD, 'SELSC','PUSSC','PUSSC','SELSC',LOGIN_OFC_CD) = PPD_RCV_OFC_CD THEN NULL" ).append("\n"); 
		query.append("                          ELSE LOGIN_OFC_CD END" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                  END THIRD_PARTY_OFC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , CASE WHEN LOGIN_OFC_CD != CLT_OFC_CD THEN" ).append("\n"); 
		query.append("                            CASE WHEN DECODE(LOGIN_OFC_CD, 'SELSC','PUSSC','PUSSC','SELSC',LOGIN_OFC_CD) = CLT_OFC_CD THEN" ).append("\n"); 
		query.append("                                'C'" ).append("\n"); 
		query.append("                                 ELSE 'P'" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                        ELSE 'C'" ).append("\n"); 
		query.append("                   END FRT_TERM_CD" ).append("\n"); 
		query.append("          FROM  BKG_RATE BR," ).append("\n"); 
		query.append("                (SELECT @[login_office] LOGIN_OFC_CD FROM DUAL)" ).append("\n"); 
		query.append("         WHERE  BR.BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("        ) A, MDM_ORGANIZATION MOR" ).append("\n"); 
		query.append(" WHERE  A.THIRD_PARTY_OFC = MOR.OFC_CD" ).append("\n"); 
		query.append("   AND  DELT_FLG = 'N'" ).append("\n"); 

	}
}