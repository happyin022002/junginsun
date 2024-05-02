/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEmergencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEmergencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(ESV_N)-JOEDI_EU_OUTBOUND
	  * {EMERGENCY_CONTACT
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEmergencyRSQL(){
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
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvEmergencyRSQL").append("\n"); 
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
		query.append("#if(${f_type} == 'L')" ).append("\n"); 
		query.append("SELECT ''                AS CONTACT_TYPE" ).append("\n"); 
		query.append("     , EMS_NO            AS CONTACT_NO" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD      AS CNTR_TPSZ" ).append("\n"); 
		query.append("  FROM BKG_DG_CGO" ).append("\n"); 
		query.append(" WHERE CNTR_NO      = @[eq_no]" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("   AND BKG_NO 		= @[bkg_no]" ).append("\n"); 
		query.append("   AND DCGO_SEQ 	= @[dcgo_seq]" ).append("\n"); 
		query.append("#elseif(${f_type} == 'D')" ).append("\n"); 
		query.append("SELECT ''                AS CONTACT_TYPE" ).append("\n"); 
		query.append("     , ''                AS CONTACT_NO" ).append("\n"); 
		query.append("     , ''                AS CNTR_NO" ).append("\n"); 
		query.append("     , ''                AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , ''                AS CNTR_TPSZ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}