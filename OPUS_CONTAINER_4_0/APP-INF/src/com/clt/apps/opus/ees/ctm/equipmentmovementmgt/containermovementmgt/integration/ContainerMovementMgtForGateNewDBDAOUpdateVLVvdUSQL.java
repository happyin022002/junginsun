/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtForGateNewDBDAOUpdateVLVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtForGateNewDBDAOUpdateVLVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateVLVvd
	  * </pre>
	  */
	public ContainerMovementMgtForGateNewDBDAOUpdateVLVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtForGateNewDBDAOUpdateVLVvdUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT  CM" ).append("\n"); 
		query.append("   SET CRNT_VSL_CD = (SELECT VSL_CD FROM CTM_BKG_VVD WHERE BKG_NO = @[bkg_no] AND POL_CD = SUBSTR(CM.ORG_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("       , CRNT_SKD_VOY_NO = (SELECT SKD_VOY_NO FROM CTM_BKG_VVD WHERE BKG_NO = @[bkg_no] AND POL_CD = SUBSTR(CM.ORG_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("       , CRNT_SKD_DIR_CD = (SELECT SKD_DIR_CD FROM CTM_BKG_VVD WHERE BKG_NO = @[bkg_no] AND POL_CD = SUBSTR(CM.ORG_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("       , TRNK_VSL_CD = (SELECT VSL_CD FROM CTM_BKG_VVD WHERE BKG_NO = @[bkg_no] AND POL_CD = SUBSTR(CM.ORG_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("       , TRNK_SKD_VOY_NO = (SELECT SKD_VOY_NO FROM CTM_BKG_VVD WHERE BKG_NO = @[bkg_no] AND POL_CD = SUBSTR(CM.ORG_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("       , TRNK_SKD_DIR_CD = (SELECT SKD_DIR_CD FROM CTM_BKG_VVD WHERE BKG_NO = @[bkg_no] AND POL_CD = SUBSTR(CM.ORG_YD_CD, 1, 5) )" ).append("\n"); 
		query.append("       , BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(" WHERE CM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND (CM.CNMV_YR, CM.CNMV_ID_NO) = ( SELECT /*+ INDEX_DESC(CMM1 XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                                              CNMV_YR, CNMV_ID_NO " ).append("\n"); 
		query.append("                                         FROM CTM_MOVEMENT  CMM1" ).append("\n"); 
		query.append("                                        WHERE CM.CNTR_NO = CMM1.CNTR_NO" ).append("\n"); 
		query.append("                                          AND ROWNUM = 1)" ).append("\n"); 
		query.append("   AND CM.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("   AND BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("   AND CM.BKG_NO IS NULL" ).append("\n"); 

	}
}