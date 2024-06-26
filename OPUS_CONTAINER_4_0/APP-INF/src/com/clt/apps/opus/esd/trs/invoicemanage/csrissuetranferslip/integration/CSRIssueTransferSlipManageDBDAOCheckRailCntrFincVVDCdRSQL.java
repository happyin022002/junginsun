/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOCheckRailCntrFincVVDCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOCheckRailCntrFincVVDCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail 재무 항차 정보 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOCheckRailCntrFincVVDCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("AP_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOCheckRailCntrFincVVDCdRSQL").append("\n"); 
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
		query.append("SELECT NVL((SELECT REV.VSL_CD || REV.SKD_VOY_NO || REV.SKD_DIR_CD || REV.RLANE_DIR_CD" ).append("\n"); 
		query.append("               FROM TRS_TRSP_RAIL_BIL_ORD SVC" ).append("\n"); 
		query.append("                   ,AR_MST_REV_VVD        REV" ).append("\n"); 
		query.append("              WHERE NVL(SVC.VSL_CD, 'N') = REV.VSL_CD" ).append("\n"); 
		query.append("                AND NVL(SVC.SKD_VOY_NO, 'N') = REV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND NVL(SVC.SKD_DIR_CD, 'N') = REV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(SVC.SLAN_CD, 'N') = REV.SLAN_CD" ).append("\n"); 
		query.append("                AND SVC.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND SVC.TRSP_SO_SEQ = D.TRSP_SO_SEQ)," ).append("\n"); 
		query.append("           'CNTC' || SUBSTR(TRS_GET_GL_DT_FNC('', @[AP_OFC_CD], @[INV_DT], '15'), 3, 4) || 'MM') AS RAIL_FINC_VVD_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_INV_DTL D" ).append("\n"); 
		query.append(" WHERE D.INV_VNDR_SEQ = @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($INV_NO.size() > 0)" ).append("\n"); 
		query.append("  AND D.INV_NO IN	(" ).append("\n"); 
		query.append("		#foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("			#if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}