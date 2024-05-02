/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CODCorrectionDBDAOSearchCopForBkgCodParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOSearchCopForBkgCodParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CODCorrectionDBDAOSearchCopForBkgCodParamRSQL
	  * </pre>
	  */
	public CODCorrectionDBDAOSearchCopForBkgCodParamRSQL(){
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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.integration ").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOSearchCopForBkgCodParamRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO      BKG_NO" ).append("\n"); 
		query.append("     , BK.POD_NOD_CD  OLD_POD_NOD_CD" ).append("\n"); 
		query.append("     , BK.DEL_NOD_CD  OLD_DEL_NOD_CD" ).append("\n"); 
		query.append("     , PRD.POD_NOD_CD NEW_POD_NOD_CD" ).append("\n"); 
		query.append("     , PRD.DEL_NOD_CD NEW_DEL_NOD_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      BK" ).append("\n"); 
		query.append("     , PRD_PROD_CTL_MST PRD" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("   AND PRD.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("   AND (   SUBSTR(BK.POD_NOD_CD,1,2) <> SUBSTR(PRD.POD_NOD_CD,1,2)" ).append("\n"); 
		query.append("        OR SUBSTR(BK.DEL_NOD_CD,1,2) <> SUBSTR(PRD.DEL_NOD_CD,1,2) )" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                     FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                    WHERE HRD_CDG_ID = 'POD_DEL_CNG_COP_CALL'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = 'OFF')" ).append("\n"); 

	}
}