/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAODomesticManualProccesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAODomesticManualProccesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Domestic 에서 CO 이후에 EN/TN 판정이 나는경우를 방지하기 위한처리
	  * </pre>
	  */
	public ContainerMovementMgtDBDAODomesticManualProccesRSQL(){
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
		params.put("dest_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAODomesticManualProccesRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(B XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                B.MVMT_STS_CD,B.ORG_YD_CD, SUBSTR(B.ORG_YD_CD,1,5)," ).append("\n"); 
		query.append("                MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'SCC') SCC_CD ,MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'LCC') LCC_CD," ).append("\n"); 
		query.append("                MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'ECC') ECC_CD ,MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'RCC') RCC_CD," ).append("\n"); 
		query.append("                MST_LOC_FNC(SUBSTR(@[event_yard],1,5),'LCC') ORG_LCC_CD, MST_LOC_FNC(SUBSTR(@[event_yard],1,5),'SCC') ORG_SCC_CD," ).append("\n"); 
		query.append("                 MST_LOC_FNC(SUBSTR(@[dest_yard],1,5),'LCC') DEST_LCC_CD, MST_LOC_FNC(SUBSTR(@[dest_yard],1,5),'SCC') DEST_SCC_CD," ).append("\n"); 
		query.append("                DECODE(B.BKG_NO,null,'TCHIDUMMYBKG',B.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("        FROM    CTM_MOVEMENT B" ).append("\n"); 
		query.append("        WHERE   B.CNTR_NO   = MST_COMMON_PKG.MST_CNTR_NO_FNC(@[cntr_no])" ).append("\n"); 
		query.append("        AND     ROWNUM      = 1" ).append("\n"); 

	}
}