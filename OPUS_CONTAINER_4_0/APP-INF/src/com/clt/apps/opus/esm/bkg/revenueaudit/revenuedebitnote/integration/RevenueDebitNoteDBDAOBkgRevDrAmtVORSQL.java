/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrAmtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrAmtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrAmtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrAmtVORSQL").append("\n"); 
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
		query.append("SELECT A1.RDN_NO ," ).append("\n"); 
		query.append("  	   A1.RVIS_SEQ ," ).append("\n"); 
		query.append("       A1.CURR_CD ," ).append("\n"); 
		query.append("       A1.DR_AMT ," ).append("\n"); 
		query.append("       A1.CRE_USR_ID ," ).append("\n"); 
		query.append("       A1.CRE_DT ," ).append("\n"); 
		query.append("       A1.UPD_USR_ID ," ).append("\n"); 
		query.append("       A1.UPD_DT ," ).append("\n"); 
		query.append("       NVL(TO_CHAR(ROUND(A1.DR_AMT / B1.USD_LOCL_XCH_RT, 3)), '0') AS USD_AMOUNT  " ).append("\n"); 
		query.append("FROM BKG_REV_DR_AMT A1," ).append("\n"); 
		query.append("     GL_MON_XCH_RT B1," ).append("\n"); 
		query.append("     BKG_REV_DR_NOTE C1" ).append("\n"); 
		query.append("WHERE A1.RDN_NO = @[rdn_no]" ).append("\n"); 
		query.append("  AND A1.RVIS_SEQ = @[rvis_seq]" ).append("\n"); 
		query.append("  AND A1.RDN_NO = C1.RDN_NO" ).append("\n"); 
		query.append("  AND A1.RVIS_SEQ = C1.RVIS_SEQ" ).append("\n"); 
		query.append("  AND A1.CURR_CD = B1.CURR_CD" ).append("\n"); 
		query.append("  AND B1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("  AND B1.ACCT_XCH_RT_YRMON = SUBSTR(TO_CHAR(NVL(C1.RDN_ISS_DT,SYSDATE),'YYYYMMDD'),0,6)" ).append("\n"); 

	}
}