/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOSearchCntrSpecLastSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOSearchCntrSpecLastSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrSpecLastSeq
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchCntrSpecLastSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spec_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration ").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOSearchCntrSpecLastSeqRSQL").append("\n"); 
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
		query.append("SELECT @[spec_yr] || '-' || @[cntr_tpsz_cd] || '-' ||" ).append("\n"); 
		query.append("       DECODE(SUBSTR(MAX(A.CNTR_SPEC_NO),1,7)" ).append("\n"); 
		query.append("       ,@[spec_yr] || '-' || @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("       ,LPAD(SUBSTR(MAX(A.CNTR_SPEC_NO),9,3)+1,3,'0') " ).append("\n"); 
		query.append("       ,'001') as CNTR_SPEC_NO" ).append("\n"); 
		query.append("FROM MST_CNTR_SPEC A" ).append("\n"); 
		query.append("WHERE A.SPEC_YR = @[spec_yr]" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}