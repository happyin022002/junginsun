/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchBkgVvdByBlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchBkgVvdByBlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchBkgVvdByBlNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchBkgVvdByBlNoRSQL").append("\n"); 
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
		query.append("SELECT BL_NO," ).append("\n"); 
		query.append("       '' AS HBL_NO," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POL_NM," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       POD_NM," ).append("\n"); 
		query.append("       SHPR_NM," ).append("\n"); 
		query.append("       CNEE_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("       SELECT BKG.BL_NO," ).append("\n"); 
		query.append("              VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("              VVD.POL_CD," ).append("\n"); 
		query.append("              (SELECT LOC.LOC_NM" ).append("\n"); 
		query.append("                 FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("                WHERE LOC.LOC_CD = VVD.POL_CD) AS POL_NM," ).append("\n"); 
		query.append("              VVD.POD_CD," ).append("\n"); 
		query.append("              (SELECT LOC.LOC_NM" ).append("\n"); 
		query.append("                 FROM MDM_LOCATION LOC" ).append("\n"); 
		query.append("                WHERE LOC.LOC_CD = VVD.POD_CD) AS POD_NM," ).append("\n"); 
		query.append("              (SELECT S.CUST_NM" ).append("\n"); 
		query.append("                 FROM BKG_CUSTOMER S" ).append("\n"); 
		query.append("                WHERE S.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                  AND S.BKG_CUST_TP_CD = 'S') AS SHPR_NM," ).append("\n"); 
		query.append("              (SELECT C.CUST_NM" ).append("\n"); 
		query.append("                 FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("                WHERE C.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                  AND C.BKG_CUST_TP_CD = 'C') AS CNEE_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         FROM BKG_VVD VVD," ).append("\n"); 
		query.append("              BKG_BOOKING BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND VVD.POD_CD LIKE 'JP%'" ).append("\n"); 
		query.append("          AND VVD.POL_CD NOT LIKE 'JP%'" ).append("\n"); 
		query.append("          AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ORDER BY VVD.CRE_DT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}