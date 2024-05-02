/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Edi315SendDBDADAOGetInbondNbrDtItNbrDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.02
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2011.06.02 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDADAOGetInbondNbrDtItNbrDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Get INBOND_NBR, INBOND_NBR_DT, IT_NBR_DT
	  * </pre>
	  */
	public Edi315SendDBDADAOGetInbondNbrDtItNbrDtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDADAOGetInbondNbrDtItNbrDtRSQL").append("\n"); 
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
		query.append("SELECT	CAIB.IBD_TRSP_NO AS INBOND_NBR" ).append("\n"); 
		query.append(",TO_CHAR( CAIB.IBD_TRSP_ISS_DT, 'YYYY-MM-DD HH24:MI') AS INBOND_NBR_DT" ).append("\n"); 
		query.append(",( SELECT TO_CHAR( MAX(ARR_DT), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_RSLT" ).append("\n"); 
		query.append("WHERE CNT_CD  = CABL.CNT_CD" ).append("\n"); 
		query.append("AND   BL_NO   = CABL.BL_NO" ).append("\n"); 
		query.append("AND   DSPO_CD = '1J'" ).append("\n"); 
		query.append(") AS IT_NBR_DT" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BKGM" ).append("\n"); 
		query.append("JOIN BKG_CSTMS_ADV_BL CABL" ).append("\n"); 
		query.append("ON ( CABL.CNT_CD  = 'US'" ).append("\n"); 
		query.append("AND CABL.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND CABL.BL_NO  = BKGM.BL_NO  )" ).append("\n"); 
		query.append("LEFT OUTER JOIN BKG_CSTMS_ADV_IBD CAIB" ).append("\n"); 
		query.append("ON ( CABL.CNT_CD     = CAIB.CNT_CD" ).append("\n"); 
		query.append("AND CABL.BL_NO  = CAIB.BL_NO )" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO  = @[bkg_no]" ).append("\n"); 

	}
}