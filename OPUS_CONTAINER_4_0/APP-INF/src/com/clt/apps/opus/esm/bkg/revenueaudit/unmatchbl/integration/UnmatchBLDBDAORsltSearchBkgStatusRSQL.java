/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchBkgStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.21 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAORsltSearchBkgStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgStatus
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchBkgStatusRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchBkgStatusRSQL").append("\n"); 
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
		query.append("SELECT  BK.BKG_STS_CD ," ).append("\n"); 
		query.append("        'N'   CA_FLG  ," ).append("\n"); 
		query.append("        BR.BKG_CTRT_TP_CD CTRT_TP_CD  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  CORR_NO" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  CORR_NO ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY BKG_NO ORDER BY CORR_GDT DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                FROM    BKG_CORRECTION" ).append("\n"); 
		query.append("                WHERE   BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                AND     CORR_NO <> 'TMP0000001'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append("        ) CORR_NO       ," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BK  ," ).append("\n"); 
		query.append("        BKG_RATE    BR" ).append("\n"); 
		query.append("WHERE   BR.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}