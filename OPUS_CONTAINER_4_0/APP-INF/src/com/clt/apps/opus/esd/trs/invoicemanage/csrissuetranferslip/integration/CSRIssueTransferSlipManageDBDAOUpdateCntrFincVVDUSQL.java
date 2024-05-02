/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
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

public class CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CNTR VVD를 업데이트한다
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL(){
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
		query.append("FileName : CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD D" ).append("\n"); 
		query.append("   SET D.FINC_VVD_CD = DECODE(SIGN((SELECT COUNT(*) - 1" ).append("\n"); 
		query.append("                                     FROM AR_MST_REV_VVD REV" ).append("\n"); 
		query.append("                                    WHERE REV.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("                                      AND REV.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND REV.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      AND REV.SLAN_CD = D.SLAN_CD" ).append("\n"); 
		query.append("                                      AND REV.DELT_FLG = 'N'))" ).append("\n"); 
		query.append("                             ,-1" ).append("\n"); 
		query.append("                             ,'CNTC' || SUBSTR(TRS_GET_GL_DT_FNC('', @[AP_OFC_CD], @[INV_DT], '15'), 3, 4) || 'MM'" ).append("\n"); 
		query.append("                             ,0" ).append("\n"); 
		query.append("                             ,(SELECT REV.VSL_CD || REV.SKD_VOY_NO || REV.SKD_DIR_CD || REV.RLANE_DIR_CD" ).append("\n"); 
		query.append("                                FROM AR_MST_REV_VVD REV" ).append("\n"); 
		query.append("                               WHERE REV.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("                                 AND REV.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND REV.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                                 AND REV.SLAN_CD = D.SLAN_CD" ).append("\n"); 
		query.append("                                 AND REV.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                             ,1" ).append("\n"); 
		query.append("                             ,(SELECT VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD || NVL(COA_REV_DIR_CONV_FNC(VVD.SLAN_CD, VVD.POL_CD, VVD.SKD_DIR_CD), VVD.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                               WHERE VVD.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                                 AND VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                                 AND ROWNUM = 1))" ).append("\n"); 
		query.append(" WHERE D.INV_VNDR_SEQ = @[INV_VNDR_SEQ]" ).append("\n"); 
		query.append(" #if ($INV_NO.size() > 0) " ).append("\n"); 
		query.append("  AND D.INV_NO  IN  (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${INV_NO}) " ).append("\n"); 
		query.append("      #if($velocityCount < $INV_NO.size()) " ).append("\n"); 
		query.append("        '$key', " ).append("\n"); 
		query.append("      #else " ).append("\n"); 
		query.append("        '$key' " ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}