/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBlockBkgMalaysiaToEuRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBlockBkgMalaysiaToEuRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOSearchBlockBkgMalaysiaToEuRSQL
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBlockBkgMalaysiaToEuRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBlockBkgMalaysiaToEuRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO, " ).append("\n"); 
		query.append("    CASE WHEN (B.POR_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK')" ).append("\n"); 
		query.append("               OR" ).append("\n"); 
		query.append("               B.POL_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK')" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("          AND ('E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.POD_CD)" ).append("\n"); 
		query.append("               OR" ).append("\n"); 
		query.append("               'E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.DEL_CD)" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          THEN 'Y'" ).append("\n"); 
		query.append("          WHEN (B.POD_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK')" ).append("\n"); 
		query.append("               OR" ).append("\n"); 
		query.append("               B.DEL_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK')" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("          AND ('E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.POR_CD)" ).append("\n"); 
		query.append("               OR" ).append("\n"); 
		query.append("               'E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.POL_CD)" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          THEN 'Y'          " ).append("\n"); 
		query.append("          ELSE 'N'" ).append("\n"); 
		query.append("    END BLOCK_FLG  ,    " ).append("\n"); 
		query.append("    CASE WHEN B.POL_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK') THEN B.POL_CD" ).append("\n"); 
		query.append("		 WHEN B.POR_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK') THEN B.POR_CD" ).append("\n"); 
		query.append("         WHEN B.POD_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK') THEN B.POD_CD" ).append("\n"); 
		query.append("         WHEN B.DEL_CD IN (SELECT ATTR_CTNT1 FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                       WHERE HRD_CDG_ID = 'EUSANCTION_ROUT_BLCK') THEN B.DEL_CD" ).append("\n"); 
		query.append("         ELSE 'NOT'" ).append("\n"); 
		query.append("    END BLOCK_LOC," ).append("\n"); 
		query.append("    CASE WHEN ('E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.POD_CD)" ).append("\n"); 
		query.append("               OR" ).append("\n"); 
		query.append("               'E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.DEL_CD)" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          THEN 'TO'" ).append("\n"); 
		query.append("          WHEN ('E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.POR_CD)" ).append("\n"); 
		query.append("               OR" ).append("\n"); 
		query.append("               'E' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD=B.POL_CD)" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          THEN 'FROM'          " ).append("\n"); 
		query.append("          ELSE 'NOT'" ).append("\n"); 
		query.append("    END BLOCK_EU             " ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST B " ).append("\n"); 
		query.append("WHERE B.PCTL_NO= @[pctl_no] --'ATL200739100'" ).append("\n"); 

	}
}