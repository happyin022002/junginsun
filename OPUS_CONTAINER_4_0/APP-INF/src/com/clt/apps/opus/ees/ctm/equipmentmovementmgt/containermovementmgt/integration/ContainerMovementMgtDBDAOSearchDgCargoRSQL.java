/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchDgCargoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.17 
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

public class ContainerMovementMgtDBDAOSearchDgCargoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DG Cargo 존재 여부
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchDgCargoRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchDgCargoRSQL").append("\n"); 
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
		query.append("SELECT 'X' AS EXIST_CD" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("     ,BKG_BOOKING BK" ).append("\n"); 
		query.append("     ,MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("AND BK.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("AND NVL(DG.SPCL_CGO_APRO_CD,'N') IN ('N', 'R', 'P')" ).append("\n"); 
		query.append("AND BK.POL_NOD_CD NOT IN (SELECT BHCC.ATTR_CTNT1 " ).append("\n"); 
		query.append("                            FROM BKG_HRD_CDG_CTNT BHCC " ).append("\n"); 
		query.append("                           WHERE BHCC.HRD_CDG_ID = 'SPECIAL_VENDOR_301') " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X' AS EXIST_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BB.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("AND BB.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND ML.CONTI_CD = 'E'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' FROM BKG_DG_CGO DG WHERE DG.BKG_NO = BB.BKG_NO)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X' AS EXIST_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("     ,MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BB.POL_CD = ML.LOC_CD" ).append("\n"); 
		query.append("AND ML.CONTI_CD <> 'E'" ).append("\n"); 

	}
}