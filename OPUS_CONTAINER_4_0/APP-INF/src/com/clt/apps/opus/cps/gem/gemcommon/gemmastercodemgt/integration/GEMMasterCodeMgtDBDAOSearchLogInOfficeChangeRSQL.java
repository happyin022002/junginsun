/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchLogInOfficeChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.09.09 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchLogInOfficeChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GEM_CNG_OFC Table의 정보를 조회한다.
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchLogInOfficeChangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_office_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchLogInOfficeChangeRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append(",CNG_OFC_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR (CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",DECODE (DELT_FLG, 'N', '', TO_CHAR (UPD_DT, 'YYYY-MM-DD')) UPD_DT" ).append("\n"); 
		query.append(",OFC_CNG_RMK" ).append("\n"); 
		query.append("FROM   GEM_CNG_OFC" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_delt_flg} != '')" ).append("\n"); 
		query.append("AND    DELT_FLG = @[sch_delt_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'Y')" ).append("\n"); 
		query.append("AND    OFC_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'N')" ).append("\n"); 
		query.append("AND    CNG_OFC_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}