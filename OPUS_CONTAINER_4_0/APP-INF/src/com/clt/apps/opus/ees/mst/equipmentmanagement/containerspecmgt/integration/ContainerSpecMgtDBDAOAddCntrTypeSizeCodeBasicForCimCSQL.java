/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOAddCntrTypeSizeCodeBasicForCimCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOAddCntrTypeSizeCodeBasicForCimCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MST에서 MDM의 CNTR TP/SZ 데이터 변경 시에 동일한 데이터를 CIM에 형성하기위해 MDM_CNTR_TP_SZ테이블의 데이터를 Insert한다.
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOAddCntrTypeSizeCodeBasicForCimCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOAddCntrTypeSizeCodeBasicForCimCSQL").append("\n"); 
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
		query.append("INSERT INTO CIM_TP_SZ_DP_SEQ" ).append("\n"); 
		query.append("SELECT LTRIM(TO_CHAR(ROW_NUMBER() OVER (ORDER BY RPT_DP_SEQ), '00')) AS DP_SEQ," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CNTR_TP_CD," ).append("\n"); 
		query.append("       @[ofc_cd]," ).append("\n"); 
		query.append("       @[ofc_cd]," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}