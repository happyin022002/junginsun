/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchFACChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.30 
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

public class BookingARCreationDBDAOSearchFACChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchFACChargeRSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchFACChargeRSQL").append("\n"); 
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
		query.append("SELECT FAC.BKG_NO," ).append("\n"); 
		query.append("       'FAC' CHG_CD, " ).append("\n"); 
		query.append("       FAC.CURR_CD, " ).append("\n"); 
		query.append("       'BL' PER_TP_CD, " ).append("\n"); 
		query.append("       ROUND(NVL(FAC.CRNT_AMT,0),2)*-1 TRF_RT_AMT, " ).append("\n"); 
		query.append("       1 RAT_AS_CNTR_QTY, " ).append("\n"); 
		query.append("       ROUND(NVL(FAC.CRNT_AMT,0),2)*-1 CHG_AMT,       " ).append("\n"); 
		query.append("       0 INV_XCH_RT," ).append("\n"); 
		query.append("	   '' TRF_NO," ).append("\n"); 
		query.append("	   '' DE_TERM_CD," ).append("\n"); 
		query.append("	   '' AUTO_RAT_CD" ).append("\n"); 
		query.append("  FROM ACM_FAC_COMM FAC" ).append("\n"); 
		query.append(" WHERE FAC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND FAC.SLS_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND FAC.FAC_STS_CD != 'CE'" ).append("\n"); 
		query.append("   AND FAC.cre_usr_id !='UNIT COST'" ).append("\n"); 
		query.append("   AND (FAC.bkg_no, FAC.fac_seq) = (select /*+ INDEX_DESC(acm_fac_comm, XPKACM_FAC_COMM) */ c.bkg_no,c.fac_seq " ).append("\n"); 
		query.append("                                      from acm_fac_comm c " ).append("\n"); 
		query.append("                                     where c.bkg_no = FAC.bkg_no " ).append("\n"); 
		query.append("                                       and c.fac_seq = FAC.fac_seq and rownum = 1) " ).append("\n"); 
		query.append("   AND NVL(FAC.CRNT_AMT,0) <> 0" ).append("\n"); 

	}
}