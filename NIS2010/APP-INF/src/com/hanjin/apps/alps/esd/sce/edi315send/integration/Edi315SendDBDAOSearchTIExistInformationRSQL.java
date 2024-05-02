/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchTIExistInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.22 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchTIExistInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTIExistInformation
	  * </pre>
	  */
	public Edi315SendDBDAOSearchTIExistInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_poleta1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_blpod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_poleta1_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_blpol1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchTIExistInformationRSQL").append("\n"); 
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
		query.append("SELECT      TO_CHAR(TO_DATE( @[e_poleta1],     'YYYYMMDDHH24MI') + TZTM_HRS + 2,'YYYYMMDDHH24MI') podeta1," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE( @[e_poleta1_gmt], 'YYYYMMDDHH24MI') + TZTM_HRS + 2,'YYYYMMDDHH24MI') podeta1_gmt," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE( @[e_poleta1],     'YYYYMMDDHH24MI') + TZTM_HRS + 2 + 2,'YYYYMMDDHH24MI') podetd1," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE( @[e_poleta1_gmt], 'YYYYMMDDHH24MI') + TZTM_HRS + 2 + 2,'YYYYMMDDHH24MI') podetd1_gmt" ).append("\n"); 
		query.append("FROM    PRD_FDR_LNK" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if(${e_blpol1} != '')" ).append("\n"); 
		query.append("AND LNK_ORG_LOC_CD          = @[e_blpol1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${e_blpod1} != '')" ).append("\n"); 
		query.append("AND     LNK_DEST_LOC_CD     = @[e_blpod1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}