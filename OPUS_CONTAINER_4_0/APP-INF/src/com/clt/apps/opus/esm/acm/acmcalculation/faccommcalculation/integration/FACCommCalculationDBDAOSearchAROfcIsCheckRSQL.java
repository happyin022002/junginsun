/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchAROfcIsCheckRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.11
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchAROfcIsCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchAROfcIsCheckRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchAROfcIsCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n");
		query.append("FileName : FACCommCalculationDBDAOSearchAROfcIsCheckRSQL").append("\n");
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
		query.append("SELECT COUNT(*) CNT " ).append("\n");
		query.append("  FROM BKG_CHG_RT A,MDM_ORGANIZATION B, MDM_LOCATION C " ).append("\n");
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND A.FRT_TERM_CD = 'C' " ).append("\n");
		query.append("   AND A.FRT_INCL_XCLD_DIV_CD = 'N' " ).append("\n");
		query.append("   AND NVL(A.N3PTY_RCV_OFC_CD, @[ppd_ofc_cd]) = @[ppd_ofc_cd] " ).append("\n");
		query.append("   AND NVL(A.N3PTY_RCV_OFC_CD, @[ppd_ofc_cd]) = B.OFC_CD " ).append("\n");
		query.append("   AND B.LOC_CD = C.LOC_CD " ).append("\n");
		query.append("   AND C.CONTI_CD IN ('F', 'E') " ).append("\n");
		query.append("   AND ROWNUM = 1 " ).append("\n");

	}
}