/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCheckFirmBkgRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.15
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.11.15 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI, Duk-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOCheckFirmBkgRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCheckFirmBkgRSQLRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCheckFirmBkgRSQLRSQL").append("\n"); 
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
		query.append("SELECT CTM.BKG_NO as TMP" ).append("\n"); 
		query.append("  FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append("       ,BKG_CONTAINER    BC" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("            SELECT /*+ INDEX_DESC(CTM_MOVEMENT XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                 CNTR_NO, MVMT_STS_CD, CNMV_EVNT_DT, ORG_YD_CD, BKG_NO" ).append("\n"); 
		query.append("             FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("            WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            AND     MVMT_STS_CD IN ('OP', 'OC')" ).append("\n"); 
		query.append("         )  CTM" ).append("\n"); 
		query.append("WHERE   BK.BKG_NO   =   BC.BKG_NO" ).append("\n"); 
		query.append("AND     BC.CNTR_NO  =   CTM.CNTR_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO   =   CTM.BKG_NO" ).append("\n"); 
		query.append("AND     CTM.CNMV_EVNT_DT >= SYSDATE - 45" ).append("\n"); 
		query.append("AND     BC.CNTR_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND     SUBSTR(CTM.ORG_YD_CD, 1, 5) = SUBSTR(@[yd_cd], 1, 5)" ).append("\n"); 
		query.append("AND     BC.BKG_NO <> @[bkg_no]" ).append("\n"); 

	}
}