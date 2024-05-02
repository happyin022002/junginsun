/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchVermasDataByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchVermasDataByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking I/F를 위한 VERMAS data 조회.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchVermasDataByCntrNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchVermasDataByCntrNoRSQL").append("\n"); 
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
		query.append("SELECT VGM_WGT_QTY," ).append("\n"); 
		query.append("  VRFD_WGT_CD," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  TO_CHAR(VGM_VRFY_DT, 'YYYYMMDDHH24MI') AS VGM_VRFY_DT," ).append("\n"); 
		query.append("  PTY_PSON_NM," ).append("\n"); 
		query.append("  REF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("   SELECT MSG.*," ).append("\n"); 
		query.append("     ROW_NUMBER() OVER(ORDER BY DECODE(PTY_FUNC_CD, 'SPC', 1, 'WPA', 2, 'AM', 3, 'WC', 4, 'OB', 5) ASC, VGM_SEQ DESC) AS RN" ).append("\n"); 
		query.append("   FROM CTM_VRFD_GRS_MASS_EDI_MSG MSG" ).append("\n"); 
		query.append("   WHERE 1 = 1" ).append("\n"); 
		query.append("     AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("     AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("WHERE RN = 1" ).append("\n"); 

	}
}